# CHAT_03 — LAUNCHER_HOME off: last-app restore at cold start and wake, navigation app reset, ACC wake signal, settings split

| Field | Value |
|---|---|
| Conversation title | unknown |
| Approximate dates | 2026-10-08 → 2026-10-09 (work); report requested 2026-11-12 |
| Model / role | analysis + implementation (single session, direct edits, commits and pushes on owner's request) |
| Repository branch(es) mentioned | `main`, `main-6mxprj` (origin/main-6mxprj), `testBranch` (only in the CLAUDE.md shown at the end) |
| Report written | 2026-11-12 |

## 1. Aspect of the project discussed

- Behaviour of the launcher at a cold boot and at a wake from sleep when `Keys.LAUNCHER_HOME` ("Home screen always on top while device starts or wakes up") is off: the app that was in front before should come back, "tak jak wygląda to przy gołych ustawieniach systemowych". [Historical]
- The system navigation app (FYT settings) being reset to Google Maps at every cold boot. [Historical]
- Wake/sleep detection in `WakeDetectionService` (display listener vs. a system ACC signal). [Confirmed]
- Splitting `LAUNCHER_HOME` into separate wake and cold-start settings. [Confirmed]
- Git workflow: pushing to the cloud branch `main-6mxprj` without undoing the owner's own commits on `main`. [Confirmed]

## 2. Work performed

Done (each commit pushed to `origin/main-6mxprj`, builds checked with `./gradlew :app:compileFytDebugJavaWithJavac` and, for resources, `:app:processFytDebugResources`, both offline, BUILD SUCCESSFUL / exit 0):

- `44833aa0` "Navigation: never overwrite the app picked in the system settings" — removed `setDefaultNavi()` from `AllAppsList` (called for every navigation-like app on every app-list load), removed `FytPackage.setDefaultNavigationPackage()` and every `sendStr(0, 9, …)` from `Hotseat.openNavigation`, `Launcher.openNavigation`, `AppListView.startResolvedNavigation`; on FYT `FytPackage.resolveNavigationPackage()` now returns only the package com.syu.ms reports via `FinalMain.U_NAVI_PACKAGE` (code 28, stored in `CarStates.mNaviPkg`, previously subscribed but ignored), else "" so callers fall back to `C_JUMP_PAGE` (`sendInt(0, 24, 0)`). [Confirmed]
- `97633176` "Cold boot: bring back the last app when LAUNCHER_HOME is off" — `ForegroundAppTracker.checkForeground()` calls `ColdStart.noteForegroundApp()`, which stores the last main-display app in the existing `launcher_boot_state` prefs under `last_foreground_app` ("" = home screen); `ColdStart.start()` reopens it over the launcher's home screen at a cold boot. First version (with PiP-pane skip, screen check, `isProtectedCover` filter) was simplified at the owner's request before this commit was pushed. [Confirmed]
- `24e9cfc3` "Merge remote-tracking branch 'origin/main' into main-6mxprj" — cloud branch was 23 commits behind `main`; merged instead of force-pushing; tree diff vs `origin/main` was empty before re-applying the work. [Confirmed]
- `d40620bd` "Wake: bring back the app in front before the sleep; ACC from com.syu.ms" — `WakeDetectionService` notes `appBeforeSleep` at the sleep branch and, with LAUNCHER_HOME off, calls `ColdStart.bringBackLastApp()` after the wake; added a listener for `FinalMain.U_ACC_ON` (code 50) as a second source feeding `DISPLAY_ON` next to the display listener (first report treated as state, seeded from `CarStates.mAccState` when connected). Restore also handles a PiP pane app opened full screen by com.syu.ms. [Confirmed]
- PR #23 merged by the owner (`c19afd9d`); remote `main-6mxprj` deleted; local stale branch deleted and branch recreated from `main`. [Confirmed]
- `0329b002` "Wake: panes no longer pull the launcher over the restored app" — `WindowUtil.reassertLauncherTop()` moves the launcher only when the main display (`DefaultDisplayTask.topActivity`) shows the launcher or a `DEFAULT_SOURCE_STEALERS` app; `WakeDetectionService.isAsleep()` (static `sAsleep`) blocks `noteForegroundApp()` between sleep and wake. [Confirmed]
- Owner merged it (`dc2b9a14`). [Confirmed]
- `fc343bfe` "Last app: no delay by default; stock apps wait 5 s and are watched at a cold boot" — cold boot: `com.syu.*`/`com.fyt.*` always 5000 ms delay + 2000 ms watch (`watchLastApp`, 500 ms steps; reopens once if the launcher is in front and the app has no task); other apps the same only with new `Keys.COLD_START_LAST_APP_DELAY` (`cold_start_last_app_delay`, default false), otherwise reopened on the Launcher's first `onActivityResumed`; wake: immediately (`postForGeneration(..., 0)`), no watch. New preference + strings in `values`, `values-pl`, `values-zh-rCN`; `CarStates` raw `new ArrayList()` → `new ArrayList<>()`. [Confirmed]
- Owner merged PR #25 (`91d512f0`). [Confirmed]
- `36359b61` "Settings: home screen in front at a wake and at a start, separately" — `Keys.LAUNCHER_HOME_WAKE` (`launcher_home_wake`) and `Keys.LAUNCHER_HOME_COLD_START` (`launcher_home_cold_start`); one-time migration in `LauncherApplication.onCreate()` copies old `launcher_home` into both and removes it; `COLD_START_LAST_APP_DELAY` visible only with the cold-start option off; old string `launcher_home` replaced by `launcher_home_wake`/`launcher_home_cold_start` in 3 locales. [Confirmed]

Owner device results:
- "Cold start działa, wake nie." (after d40620bd). [Historical]
- "Wake działa" (after 0329b002) plus "Cold reset średnio" with a log of the launcher breaking through. [Historical]
- "Działa. Logi do sprawdzenia." (after fc343bfe, logs `fullwake4.log`, `09-10-2026_02-21-59.txt`). [Historical]

Not done:
- No unit tests were run (`testFytDebugUnitTest` / `testSystemDebugUnitTest`). [Confirmed]
- No PR was opened by the assistant (`gh` not installed); compare links were given. [Confirmed]
- Final split commit `36359b61` not tested on a device in this conversation. [Confirmed]

## 3. Requirements discovered

- LAUNCHER_HOME off at cold start must leave the last front app in front; "na standardowym launcherze się to nie dzieje". [Historical]
- The launcher must not change the navigation app chosen in system settings ("przestawianie aplikacji nawigacji … na Google Maps … na 100% wina launchara"). [Historical]
- Step 2 changes minimal: "tak aby zmiany były minimalne, bez tworzenia nowych plików". [Historical]
- "standardowy launcher nie wychodzi na wierzch jeśli podczas wyłączania na wierzchu była inna apka." [Historical]
- Update the stale cloud branch before pushing: "merge pull request cofnie zmiany, które naniosłem sam, zaktualizuj to zanim zrobisz push." [Historical]
- The function must also work at wake; "Miej na uwadze to, że Intent.ACTION_SCREEN_ON nie działa na FYT." [Historical]
- Use a reliable system signal for wake if logs show one. [Historical]
- Watch window must be short: "15s to dużo, użytkownik w tym czasie sam mógłby ubić apkę". [Historical]
- "zamiast 2500ms przy cold starcie zrób 5000ms i 2000ms sprawdzania ale tylko dla apek com.syu.* i com.fyt.* - obligatoryjnie"; optional delay for others behind `Keys.COLD_START_LAST_APP_DELAY`, visible only with the home option unchecked, with a description; translations PL and Simplified Chinese; "W wake bez tego opóźnienia." [Historical]
- No delay for default cold start and wake: "Tu miało być wszędzie brak." [Historical]
- Two independent options `Keys.LAUNCHER_HOME_WAKE` and `Keys.LAUNCHER_HOME_COLD_START`, the latter combined with `COLD_START_LAST_APP_DELAY`; "Pamętaj o tłumaczeniach stringów." [Historical]

## 4. Architectural and technical decisions

- Launcher never writes the system navigation app; on FYT it uses ms's reported package or `C_JUMP_PAGE`. Reason: `persist.sys.navi.packagename` was written only by the launcher (Google Maps as first candidate) and not kept current by com.syu.ms, so the guess overwrote the user's choice. Decided by assistant, pushed and merged via PR. [Confirmed]
- Last app is recorded continuously from `ForegroundAppTracker` (task stack listener, main display only), not at shutdown. Reason: shutdown log `full.log` showed the launcher receives nothing at power-off. Assistant. [Confirmed]
- Recording filter = `TRANSIENT_PACKAGES` ("android", "com.android.systemui", "com.android.launcher3") + camera name parts (`isCameraPackage`, extracted from `isProtectedCover`), not `PROTECTED_COVER_PACKAGES`. Reason: that list contains `com.syu.carlink`, the app in front in the shutdown log. Assistant. [Confirmed]
- Restore acts only when the main display shows the launcher's home screen (or a PiP pane app); otherwise leaves what is in front. Assistant. [Confirmed]
- ACC from com.syu.ms (`U_ACC_ON`) added as a parallel source in `WakeDetectionService`; whichever reports first switches `DISPLAY_ON`. Reason: in `fullwake.log` ACC off came 1.2 s before display off, ACC on 0.1 s before display on; FYT apps use it (`MusicLib: U_ACC_ON`). Side effect stated: sleep handling starts ~1.2 s earlier. Assistant, on owner's request for a "pewniak". [Confirmed]
- `reassertLauncherTop` guard (see §2). Reason: log 00:53:24.332 showed it moving the launcher over restored carlink. Assistant. [Confirmed]
- Crash vs. Home distinguished by task presence (a crash removes the task, Home leaves it). Assistant. [Confirmed]
- Delay/watch values and scope per owner (§3). Owner. [Historical]
- Migration of `launcher_home` to both new keys. Reason: so nothing changes until the user chooses. Assistant. [Confirmed]
- Branch handling: merge/fast-forward `main` into `main-6mxprj`, never force-push. Owner requirement, assistant execution. [Confirmed]

## 5. Rejected decisions and why

- First step-2 implementation (PiP-package skip, screen-off check, `isProtectedCover` filter, extra docs) — replaced by a smaller version on owner's request for minimal changes. [Confirmed]
- 15 s post-restore watch — rejected by owner as too long. [Historical]
- 2500 ms extra delay for all apps at cold start / 3 s watch — replaced by owner's 5000/2000 rule for `com.syu.*`/`com.fyt.*` plus optional flag. [Historical]
- Fixed 2500 ms delay for default cold start and wake — rejected by owner ("wszędzie brak"). [Historical]
- Fixing the `ActivityView` NPE warning via reflection into framework internals — not done; judged harmless. [Suggestion]
- Assistant's earlier interpretation that carlink killed itself because of the clock jump — dropped after finding a `FATAL EXCEPTION` at 29.558. [Confirmed]

## 6. Problems encountered and their solutions

- Navigation reset to Google Maps at every cold boot → `AllAppsList.add/updatePackage` → `setDefaultNavi()` (from commit `a9be1524`, stock code only handled Gaode with an empty property) resolved from stale `persist.sys.navi.packagename` and sent it to ms → fix `44833aa0` → device confirmation not given in this conversation. [Unverified]
- Cold start, launcher on top with LAUNCHER_HOME off → in `08-10-2026_20-00-54.txt` com.syu.ms had nothing to restore (`rememberLastApp goto DataMain.sTopAppWhenMcuOff:` empty); no launcher code was found pulling itself up → launcher-side restore (`97633176`) → owner: "Cold start działa". [Historical]
- carlink would never be recorded → it was in `PROTECTED_COVER_PACKAGES` → new transient filter → fixed in code. [Confirmed]
- Wake failed → ROM starts HOME (`from uid 0`) ~1 s after ACC off; at wake ms restores carlink but the pane build continues and `reassertLauncherTop moved launcher to top` covered it (`fullwake2.log`, 00:53:24.332) → `0329b002` → owner: "Wake działa". [Historical]
- com.syu.ms records a PiP pane app as `sTopAppWhenMcuOff` (Maps in `fullwake.log` while home screen was in front) → restore treats a pane app full screen as replaceable. [Confirmed] Effect on device of that branch: [Unverified]
- Cold start, launcher broke through after carlink was restored (`09-10-2026_01-10-12.txt`) → carlink crashed at 29.558 (`FATAL EXCEPTION: Carlink-Service`, `FileNotFoundException: /sdcard/carlink/logo/car_log.png`) when its activity started before ms's ServiceKeeper started `CarLinkService` (30.6 s vs 27.9/28.3 s in good boots); kill deferred by the boot stall (`Sending signal. PID: 6012 SIG: 9` at 01:10:21.202) → 5000 ms delay + 2000 ms watch (`fc343bfe`) → owner: "Działa." with log showing restore at 5.0 s and no crash; watch path itself never exercised. [Historical]
- `fullwake3.log` HOME at 01:09:16.965 after touches — assistant judged it likely user-initiated; owner then said that was "Nie ten log". [Unverified]
- Compiler note "CarStates.java uses unchecked or unsafe operations" → raw `ArrayList` → `new ArrayList<>()` → note gone in build output. [Confirmed]
- `ActivityView$TaskStackListenerImpl.onTaskDescriptionChanged` → `SurfaceView.setResizeBackgroundColor` NPE warning → assistant's explanation: Android 10 framework, surface already destroyed, exception caught by Binder → not fixed. [Unverified]
- Tooling: UTF-16 logs (`full.log`, `fullwake*.log`) converted with `iconv` into scratchpad; Python edits needed CRLF handling; `gh` missing. [Confirmed]

## 7. Features implemented or discussed

- Navigation app no longer overwritten; ms-reported navi package in `CarStates` — implemented. [Confirmed]
- Last-app restore at cold boot (LAUNCHER_HOME_COLD_START off) — implemented. [Confirmed]
- Last-app restore at wake (LAUNCHER_HOME_WAKE off) — implemented. [Confirmed]
- ACC from com.syu.ms as wake/sleep source — implemented. [Confirmed]
- `reassertLauncherTop` guard — implemented. [Confirmed]
- Post-restore watch and reopen-once for stock apps / opt-in — implemented. [Confirmed]
- Setting `cold_start_last_app_delay` with EN/PL/zh-CN strings — implemented. [Confirmed]
- Split `launcher_home_wake` / `launcher_home_cold_start` with migration — implemented, not device-tested. [Confirmed]
- Long-sleep wake test — discussed only ("Sprawdzę później jak to wygląda przy dłuższym okresie uśpienia"). [Historical]

## 8. Important constraints

- Device in logs: `sprd ums512_1h10_Natv, android=10 (API 29)`; launcher runs as uid 1000 (system privileges; "Task stack listener registered"). [Confirmed]
- `Intent.ACTION_SCREEN_ON` does not work on FYT. [Historical]
- Boot-time stall blocks system_server calls for seconds; system_server calls kept off the main thread. [Confirmed]
- Clock at boot is the ROM build date (12-07 2024 04:45) until network/GPS sync. [Confirmed]
- `ForegroundAppTracker` needs system privileges; without it no last app is noted. [Confirmed]
- Owner's rule: do not undo the owner's commits; update the cloud branch before pushing. [Historical]
- The `claude/CLAUDE.md` shown at the end (work on `testBranch`, never write a model name in the repository, new strings in all 59 `values*` files, do not migrate preference values unless a brief says so, run unit tests before push) was not in context during the work; this session committed to `main-6mxprj`, added `Co-Authored-By` trailers naming the model, translated only 3 locales, migrated `launcher_home`, and ran no unit tests. [Confirmed]

## 9. Unresolved questions

- Whether com.syu.ms delivers the navigation package in `strs[0]` for `U_NAVI_PACKAGE`; nav fix not confirmed on device. [Unverified]
- Why the stock launcher shows the last app after a cold boot (ms record is empty at boot). [Unverified]
- Stale `persist.sys.navi.packagename` (Google Maps) remains; owner was told to reselect Waze once. [Suggestion]
- Cause of other users' wake failures; only the owner's unit was logged. [Unverified]
- Long-sleep wake behaviour. [Historical]
- Whether the ~1.2 s earlier sleep handling (ACC off before display off) has visible side effects. [Unverified]
- Whether the PR for `36359b61` was opened/merged, and whether the migration works on device: unknown. [Unverified]
- Missing translations for the other locales and the model-name trailers relative to the CLAUDE.md rules. [Unverified]

## 10. Information that may be missing from the repository

- Log timings: ACC off → display off 1.2 s; ACC on → display on ~0.1 s; WakeDetection reacted 10 ms / 52 ms after display (`fullwake.log`). [Confirmed]
- ROM starts HOME ~1 s after ACC off, just after ms records `MCU OFF sTopAppWhenMcuOff`. [Confirmed]
- com.syu.ms `sTopAppWhenMcuOff` is empty after a restart; it takes PiP pane apps for the top app. [Confirmed]
- ms ServiceKeeper starts carlink's service from ~2 s before to 4.1 s after the launcher start; carlink crashes if its activity starts first. [Confirmed]
- Owner uses `com.syu.carlink` and Waze; pane apps YouTube (revanced), Spotify, Google Maps; autostart `vasyl.titles`, `james.dsp`. [Confirmed]
- In `fullwake4.log` carlink was restored 65 ms after wake, before ms's goto. [Confirmed]

## 11. Relevant file paths and references

- Code: `app/src/main/java/com/android/launcher66/ColdStart.java`, `settings/WakeDetectionService.java`, `settings/ForegroundAppTracker.java`, `settings/Keys.java`, `settings/SettingsFragmentFirst.java`, `LauncherApplication.java`, `AllAppsList.java`, `Hotseat.java`, `Launcher.java`, `DefaultDisplayTask.java`, `app/src/main/java/com/fyt/widget/AppListView.java`, `com/syu/car/CarStates.java`, `com/syu/util/FytPackage.java`, `com/syu/util/WindowUtil.java`, `com/syu/remote/RemoteTools.java`, `com/syu/ipc/data/FinalMain.java`; `app/src/main/res/xml/launcher_preferences.xml`; `res/values/strings.xml`, `values-pl/strings.xml`, `values-zh-rCN/strings.xml`.
- Commits: `44833aa0`, `97633176`, `24e9cfc3`, `d40620bd`, `0329b002`, `fc343bfe`, `36359b61`; owner merges `c19afd9d` (PR #23), `dc2b9a14`, `91d512f0` (PR #25); earlier `a9be1524`, `10397756`, `25783123`.
- Logs (owner's Desktop): `08-10-2026_20-00-54.txt`, `07-12-2024_04-47-57.txt`, `full.log`, `fullwake.log`, `fullwake2.log`, `fullwake3.log`, `fullwake4.log`, `09-10-2026_00-50-55.txt`, `09-10-2026_01-10-12.txt`, `09-10-2026_01-12-58.txt`, `09-10-2026_02-21-59.txt`.
- Links: https://github.com/vasyl91/FYT-Launcher-Mod/compare/main...main-6mxprj?expand=1, https://github.com/vasyl91/FYT-Launcher-Mod/pull/new/main-6mxprj

## Summary by label
- Confirmed: 58, Historical: 21, Suggestion: 2, Unverified: 12