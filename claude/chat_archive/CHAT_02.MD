# CHAT_02 — FYT Launcher Mod v1.2.1: log-driven fixes (sound channel, PiP launch, wake/boot, fYT Rating), CI, and Launcher.java split

| Field | Value |
|---|---|
| Conversation title | unknown |
| Approximate dates | 2026-10-05 – 2026-10-06 (git/CI timestamps; earlier part of the session was summarized and its start date is unknown) |
| Model / role | Implementation + device-log analysis (cloud Claude Code session, no device or Gradle build locally; CI used for compile verification) |
| Repository branch(es) mentioned | `main-6mxprj` (work branch), `main` (merged via PRs #8–#18 from `vasyl91/main-6mxprj`) |
| Report written | 2026-11-10 |

## 1. Aspect of the project discussed
Reliability and speed of the FYT Launcher Mod (`com.android.launcher66`) on an FYT/Unisoc Android 10 head unit, driven by logcat captures the owner uploaded after cold starts, wakes and tests: MCU sound-channel arbitration between stock sources (radio, `com.syu.music`) and MediaSession players (Spotify, YouTube ReVanced) in PiP panes; adaptive PiP pane launching; return-from-settings rebuild; weather refresh; fYT Rating bridge timing; stock-player cover; night mode by headlights; CI setup; splitting `Launcher.java` into helper classes; release notes for v1.2.1; local APK build JVM crashes; CanbusService stats overlay touch pass-through.

## 2. Work performed
Done (pushed to `main-6mxprj`, verified by GitHub Actions unless noted):
- [Confirmed] Adaptive pane launch: next pane starts after previous is rendering + Choreographer smoothness check, min gap 90/250 ms, max 2 s, visible page first, generation-cancel on `removePip()` — commit `dbfac7a`. Owner logs later showed `pane launch: … up after N ms`.
- [Confirmed] CI fixes: `setup-android` `packages: "platform-tools"` (`53fe063`), compile SDK resolved from `sdkmanager --list` (android-37.0) (`8df9f82`); CI green afterwards.
- [Confirmed] Sound channel series: `0a71296` (no restore over a sounding third-party player via `AudioPlaybackConfiguration`; resume only the switching player's token; ColdStart broadcasts via `SysCalls`), `710bf09`, `a46835d` (UserTouches v1 — later found ineffective), `a5d559e` (system-wide input monitor `InputManager.monitorGestureInput` in `UserTouches`, `MONITOR_INPUT` permission, auto-start handling only while monitor active, touches before `WindowUtil.lastPaneLaunchSetAtMs()` ignored), `ace0d32` (end-of-rebuild restore respects a recent tap; `USER_TOUCH_INTENT_MS` 6000; StatusBarSwipeDetector start/stop on serial background thread). Owner confirmed on device: "Działa idealnie" (17:39 log).
- [Confirmed] Return from settings: `recreateView()` leaves user page to the rebind; `bindScreens()` reattaches bar adapters; no bar rebuild when attached — `710bf09`; owner log showed `recreateView: user page left to the rebind` and `Wake home recycler restore: bindScreens`.
- [Confirmed] fYT Rating: GET_RATING/SET_RATING use foreground broadcast queue for 5 min after boot or after an unanswered request; wake not delayed to 90 s uptime when bridge wakes by broadcast; stock-player cover falls back to default — `fe85360`. Owner: "Działa idealnie" (03:58 log shows `[foreground]`, 2.2 s / 1 s).
- [Confirmed] Weather: re-check in 5 s instead of 10 min when a fetch is due without network — `91ef98b` (no device confirmation of this specific change in conversation; owner later said "Wszystko działa normalnie").
- [Confirmed] Launcher split into helpers (CI green): `LauncherWeather`, `HomeLayoutRecovery`, `LauncherWake`, `LauncherPipStarter` (`e99f104`, `d2ad587`), `LauncherPermissionFlow`, `LauncherFab` (`df98845`), `LauncherAppBars` (`af02734`, first CI failure fixed by `d48f6fa` "mLauncher not final"), `LauncherMusicWidget` (`0af7095`), `LauncherRadioWidget`, `LauncherWallpaperPicker` + `Launcher.getRadioFreq()/getRadioFreqState()` (`f65f856`). `Launcher.java` 13,236 → 9,080 lines. Owner: "Wszystko działa normalnie".
- [Confirmed] CanbusService stats overlay `FLAG_NOT_TOUCHABLE` — commit `1039775`; CI run was still in progress when the conversation ended (result not seen).
- [Confirmed] English v1.2.1 release notes written in chat with contributors (Hubert @vasyl91, davin pratama @davinpra, 谭新棋 @txq1996, Claude); text only, not committed.
- Earlier in session (from the summary, commits in git log): `43cbf5a`, `949370e`, `e2b97ee`, `a03143b`, `d421e96`, `d409461` (weather by distance/age, wake/bind fixes, SessionPrefs, ForegroundAppTracker, HeadlightNightMode, SysCalls, CrashLogger, CI workflow, tests, gradlew executable). [Confirmed] as commits; device behaviour of each individually: largely confirmed through later logs.

Only planned / not done:
- [Suggestion] Parking-light night-mode choice preference — not implemented (no signal; see §5).
- [Suggestion] Further Launcher splitting (navigation/AMap receivers, Launcher3 core) — not done.

## 3. Requirements discovered
- [Historical] Pane launch: visible-page panes first, others right after (not deferred until scroll): "powinien rysować się po tym jak powstaną te widoczne, chyba że użytkownik przewinie stronę jeszcze w trakcie limitu maksymalnego".
- [Historical] Distinguish an app coming to the top by itself from a user tap: "Trzeba to rozróżnić czy apka wychodzi na wierzch sama czy użytkownic dotknął UI".
- [Historical] A Spotify started by the user must not lose sound to `com.syu.music`; Spotify must not steal radio/stock sound when panes start.
- [Historical] Release summary from commit `077eed6…` in English with authors: "pamiętaj aby ująć w podsumowaniu autora, a samo podsumowanie zrób po angielsku".
- [Historical] Canbus stats overlay must let all touches through: "widokowi dotyk nie jest potrzebny".
- [Historical] Stop after the split stage and finish work if logs are OK: "zatrzymujemy się zatem na tym etapie".
- [Historical] Parking-lights option was requested (below `night_mode_lights`, visible only when true, based on `CustomNoSwitchPreference`) then dropped: "Zostawiamy jak jest."

## 4. Architectural and technical decisions
- [Confirmed] User-tap detection via hidden `InputManager.monitorGestureInput()` + `InputEventReceiver` subclass (stubs in `hiddenapi-stubs`), on its own `HandlerThread`; reason: on Android 10 taps on ActivityView panes go directly to the virtual-display window, so launcher views never see them. Decided by assistant; confirmed working on device.
- [Confirmed] "Came up by itself" restore+pause logic only when `UserTouches.isMonitoring()`; otherwise fall back to earlier behaviour (assistant).
- [Confirmed] Touches before the current pane launch set (+200 ms) don't count (home tap starts the rebuild) (assistant).
- [Confirmed] fYT Rating requests use foreground queue only during boot congestion / after timeout, because foreground queue's 10 s receiver timeout could ANR the bridge on slow network (assistant).
- [Confirmed] Launcher split done mechanically with a script (`jmove.py` in scratchpad) moving members unchanged; Launcher keeps delegates for external callers (assistant; owner approved continuing).
- [Confirmed] Helper `mLauncher` fields not `final` (javac rejects blank-final reads in field-initializer lambdas).
- [Confirmed] StatusBarSwipeDetector start/stop on a serial background executor to keep ordering and free the main thread.

## 5. Rejected decisions and why
- [Confirmed] Pane-root touch wrappers (`UserTouches.observingFrame`) — removed because Android 10 dispatches ActivityView touches straight to the embedded display; caused user-started Spotify to be paused (02:58 log).
- [Confirmed] Parking-light night-mode option — not implemented: log `bcdbf88a-07-12-2024_04-47-57.txt` shows only `lamplet value : 0/1` (`U_LAMPLET`), identical for parking and low beam; owner chose "Zostawiamy jak jest."
- [Historical] Point 3 (persist last weather) — owner said not to implement.
- [Confirmed] Further split of navigation code — skipped because AMap/GaoDe handling lives in receivers mixed with music (`removeMusic`, `MyAutoMapReceiver`).
- [Unverified] Committing `-XX:+UseParallelGC` to repo — only suggested for the owner's local `~/.gradle/gradle.properties`, not committed.

## 6. Problems encountered and their solutions
- com.syu.music took sound back from YouTube (01:27:37): channel switched 290 ms before YouTube session reported PLAYING → `AudioPlaybackConfiguration` started-player check → [Confirmed] (`0a71296`, later logs OK).
- Spotify resumed over YouTube (01:28:38): resume picked latest token at check time → token fixed at switch time → [Confirmed].
- Radio silent after Spotify auto-resume (02:21:23): steal swallowed by 1.5 s cooldown → cooldown bypassed when a player is sounding → [Confirmed].
- User-started Spotify paused / widget showing com.syu.music (02:58): pane taps invisible to launcher → input monitor (`a5d559e`) → [Confirmed] ("Działa niemal idealnie").
- Two Launcher instances after Android Studio `am start` (category DEFAULT) then HOME → dev-install artifact; advised reboot/HOME; [Unverified] as cause of widget confusion.
- Empty app bars ~14 s after settings (01:26:52): rebind re-created user page, adapters waited for 10 s all-apps reload → reattach adapters in `bindScreens` → [Confirmed].
- YouTube like state 43 s after boot: GET_RATING behind 64 background broadcasts → foreground queue → [Confirmed].
- fYT Rating wake ~80 s after boot: 90 s uptime gate → skipped for broadcast wake → [Confirmed].
- Stock-player previous cover shown: saved cover used regardless of path → only for same path → [Confirmed] by "Działa idealnie" (not individually tested in logs).
- Weather 11 h stale after wake (15:19): check ran before Wi-Fi; 10-min recheck → 5 s recheck → [Unverified] on device.
- CI failures: `tools` package missing; `platforms;android-37` not found; `LauncherFab` "variable mLauncher might not have been initialized" → fixed → [Confirmed] CI green.
- Spotify tapped during rebuild lost channel (17:07:49–52) and 2 s main-thread block in `stopService` (17:07:34) → `ace0d32` → [Confirmed] (17:39 log: `Not restoring 8 (Panes settled) - the user just tapped something`, no main-thread stalls).
- YouTube ReVanced crash `desiredWidth must be > 0` (17:07:37) → app's own bug during fast pane rebuild; seen once; not fixed → [Unverified] root cause.
- Local APK builds failing 3/4 with `EXCEPTION_ACCESS_VIOLATION` in G1 GC / R8 C2 code (JBR 21.0.11 b1163.116, Ryzen 7 5800X3D, Windows 11) → not a project issue; suggested switching Gradle JDK to Temurin 21, checking PBO/Curve Optimizer/EXPO, optional local `-XX:+UseParallelGC` → [Suggestion], outcome unknown.

## 7. Features implemented or discussed
- Adaptive PiP pane launch — implemented [Confirmed].
- Tap-vs-auto-start sound-channel arbitration (UserTouches input monitor) — implemented [Confirmed].
- Single rebuild + instant bars on return from settings — implemented [Confirmed].
- fYT Rating faster after boot — implemented [Confirmed].
- Stock-player default cover fallback — implemented [Confirmed].
- Weather 5 s no-network recheck — implemented, device effect [Unverified].
- Launcher.java split (10 helper classes) — implemented [Confirmed].
- `Launcher.getRadioFreq()/getRadioFreqState()` for `DateRadioWidget` — implemented [Confirmed].
- Canbus stats overlay touch pass-through — implemented, CI result not seen [Unverified].
- Parking-light night-mode choice — discussed only, rejected [Historical].
- CAN-protocol-based headlight detection — discussed only [Suggestion].

## 8. Important constraints
- [Confirmed] Device: `sprd ums512_1h10_Natv`, Android 10 (API 29), Unisoc; launcher runs as system uid 1000, platform-signed (needed for `MONITOR_INPUT`, TaskStackListener, PowerController).
- [Confirmed] `com.syu.ms` switches MCU channel 10 when a known media app reaches top or starts audio; channels: 1 radio, 3 BT, 8 com.syu.music, 10 third party.
- [Confirmed] Head unit receives only one light signal (`U_LAMPLET`/ILL 0/1).
- [Confirmed] Cloud session cannot run Gradle (dl.google.com blocked); verification via local javac signature diff + GitHub Actions.
- [Historical] Owner rules: skip `Callback_*.java` in `com/syu/module/canbus`, and dirs `com/syu/canbus/warn`, `com/syu/carinfo`, `com/syu/ui` in reviews; `VersionChecker.isNewerVersion` intentional; hardcoded OpenWeatherMap key stays ([secret omitted]); no PRs unless asked; push only to `main-6mxprj`.
- [Confirmed] Owner's PC: AMD Ryzen 7 5800X3D, Windows 11, Gradle 9.7.1, JBR 21.0.11.

## 9. Unresolved questions
- Whether local APK build crashes are JVM (JBR) or hardware instability — unknown.
- CI result of commit `1039775` (stats overlay) — not seen.
- Root cause of YouTube ReVanced `desiredWidth must be > 0` crash — not investigated.
- Whether the owner's CAN protocol reports headlight states — not checked (option dropped).
- Device confirmation of the weather 5 s recheck after wake — not shown.

## 10. Information that may be missing from the repository
- Measured timings: cold start ~+2.1 s first frame, +2.3 s bars, +3.5 s pane start, +6–7 s panes ready (logs 03:58 vs 17:06); GET_RATING 0.2–0.7 s bridge answer vs 64 queued boot broadcasts; Spotify playback up to 3.2 s after tap under load.
- Owner's car light behaviour: low beam and parking lights both light the dashboard (ILL=1), DRL does not.
- Owner preference to stop refactoring after the helper split and release v1.2.1.
- Contributor attribution for v1.2.1 (davinpra PRs #4–#6, txq1996 PR #7) and the release-notes text (chat only).
- Dev pitfall: Android Studio launching Launcher via `am start` creates a second non-home instance.

## 11. Relevant file paths and references
- Files: `app/src/main/java/com/android/launcher66/Launcher.java`, `NotificationListener.kt`, `HomeLayoutRecovery.java`, `LauncherWake.java`, `LauncherPipStarter.java`, `LauncherWeather.java`, `LauncherFab.java`, `LauncherPermissionFlow.java`, `LauncherAppBars.java`, `LauncherMusicWidget.java`, `LauncherRadioWidget.java`, `LauncherWallpaperPicker.java`, `settings/FytRating.java`, `settings/CanbusService.java`, `settings/HeadlightNightMode.java`, `ColdStart.java`, `SysCalls.java`, `MediaTransportController.java`; `com/syu/util/WindowUtil.java`, `WindowHost.java`, `UserTouches.java`, `WindowHostSinglePane.java`, `WindowHostDualPane.java`; `com/syu/weather/WeatherManager.java`, `NetworkCheck.java`; `com/syu/widget/DateRadioWidget.java`, `DateMusicWidget.java`; `hiddenapi-stubs/src/main/java/android/view/InputEventReceiver.java`, `InputChannel.java`; `app/src/main/AndroidManifest.xml`; `.github/workflows/build.yml`; `gradle.properties`; `settings/CustomNoSwitchPreference` (mentioned).
- Commits: `dbfac7a`, `53fe063`, `8df9f82`, `0a71296`, `710bf09`, `a46835d`, `a5d559e`, `fe85360`, `91ef98b`, `e99f104`, `d2ad587`, `df98845`, `af02734`, `d48f6fa`, `0af7095`, `f65f856`, `ace0d32`, `1039775`; earlier `43cbf5a`, `949370e`, `e2b97ee`, `a03143b`, `d421e96`, `d409461`; release base `077eed61544b6a918ffc03bb8bfd315300d939d1` (davin pratama, 2026-07-01); PRs #4–#7, #8–#18.
- Logs (uploads): `9e38678b-06-10-2026_01-26-19.txt`, `38f7904f-06-10-2026_02-20-35.txt`, `8ce3c364-06-10-2026_02-24-41.txt`, `ed7fb103-06-10-2026_02-35-20.txt`, `2c836f2e-06-10-2026_02-58-12.txt`, `35818ea3-06-10-2026_03-28-42.txt`, `f2c94a04-06-10-2026_03-58-57.txt`, `bfb4e35a-06-10-2026_15-19-03.txt`, `d5ef00ae-06-10-2026_17-06-58.txt`, `764b479d-06-10-2026_17-39-37.txt`, `bcdbf88a-07-12-2024_04-47-57.txt`, `hs_err_pid23620.log`, `hs_err_pid27580.log`, `hs_err_pid31668.log`.
- Links: https://github.com/vasyl91/FYT-Launcher-Mod/commit/077eed61544b6a918ffc03bb8bfd315300d939d1

## Summary by label
- Confirmed: 50, Historical: 11, Suggestion: 4, Unverified: 7
