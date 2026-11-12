# CHAT_05 — StrictMode clean-up, music widget (covers, players, favorites for YT Music and the stock players), pane fixes, and Shizuku boot analysis

| Field | Value |
|---|---|
| Conversation title | unknown |
| Approximate dates | 2026-10-18 to 2026-10-19. Earlier, summarised part: logs dated 18-10-2026. Last log analysed: 19-10-2026 08:03:14. |
| Model / role | Implementation and log analysis: commits pushed and CI checked |
| Repository branch(es) mentioned | `ccr-087eed00-gbqsuz` (work branch); `ccr-893cd285-tau8vs` and tag `v1.2.1` (seen in a fetch, not used); `main` (never merged into) |
| Report written | 2026-11-11 |

## 1. Aspect of the project discussed

- **Music widget (`LauncherMusicWidget`, `NotificationListener.kt`, `MediaFavoriteController`):**
  - covers;
  - play/pause icon;
  - opening the last player;
  - favorite (like) state for YouTube ReVanced, YT Music and the FYT stock players `com.syu.music` (7862/8581) and `com.syu.media` (7870).
- **StrictMode violations on the main thread:** launcher start, Settings, left bar, Id3 cover reading.
- **Widget layout and relocation; new screen when a widget is added.**
- **Baseline profiles; README tables:** Baseline Profiles, Supported devices, platform key.
- **FYT stock players:**
  - BACK behaviour and the MCU sound channel;
  - routing of the transport buttons;
  - access to `com.syu.music`'s `music.db`;
  - the `com.syu.media` IPlayer binder.
- **PiP panes (dual/single) under Shizuku when the VD host attaches late.**
- **Shizuku (Shizuku Next) disconnect/reconnect at boot:** analysis only.

## 2. Work performed

### Earlier part of the conversation

This part is known only from the compacted summary.

- [Confirmed] Commits pushed to `ccr-087eed00-gbqsuz`, as listed in the summary:
  - **StrictMode:**
    - `4b03c3b`: `Launcher.getSharedPreferences` goes through the app context.
    - `28f9587`: `WorkspaceScreensPreload.java`.
  - **Standard build running on FYT with Shizuku:**
    - `68ff22b`: crash guards.
    - `26cfc27`, `660d1e8`: pinned PiP guarded by `isFytDevice()`.
    - `1d81c91`: `com/syu/util/PaneYieldWatcher.java` (HiCar / 360 camera via the VD host's foreground watch).
  - **Start-up and widgets:**
    - `accdf22`, `2c0aad0`, `a96c0e7`, `9e7d52b`: StrictMode, widget `setExecutor`, `BaselineProfileCompiler.warmUp()`.
    - `0256c9b`, `7553e13`: relocate overlapping widgets; show the screen of a newly added widget.
  - **Baseline profiles:** `14e436f`, `3e8a26a`; the debug build no longer shows "Deployment OK".
  - **Panes:** `7cc6359`: `canHostPips()` is `WindowHostVdClient.canHostPanes()` only.
  - **README:** `3879d74`: Baseline Profiles section, Supported devices table, platform-key text, custom ROM paragraph.
  - **YT Music rating:**
    - `9d0f193`: preferred-package controller choice.
    - `e76d30a`: compile fix for the parameter name.
  - **Music widget:** `77c4f5e`: play/pause reliability, FYT-only use of `com.syu.ms` / `com.fyt.car.MusicService`, last-track restore.

### Commits in this part of the conversation

Each was pushed and CI ("Build" workflow) passed.

- [Confirmed] `5a6d4d4`: two music widget features.
  - When a track has no cover, the player's app icon is shown and saved instead (`NotificationListener.appIconFor`, `LauncherMusicWidget.playerIcon`).
  - With no active session of the last player, any widget button opens that app (`openLastPlayerIfNoSession`, `PREF_LAST_PLAYER = "last_music_player"`). This is skipped for `com.syu.music`.
- [Confirmed] `9fc2c74`:
  - with no session of its own the player counts as paused;
  - the last player opens only if it is installed (`launchIntentIfInstalled`);
  - play/pause no longer crashes when its player was uninstalled meanwhile;
  - `refreshLeftCycle` writes the database on the `LeftCycleWriter` thread;
  - `SettingsActivity.getSharedPreferences` goes through the app context;
  - the app-type line (`hasRoot()`) is computed off the main thread;
  - when a YouTube-family session has no video id, the whole session is dumped to the log.
- [Confirmed] `90c8073`: the video id is matched by queue-item title (and artist) when YT Music marks no queue item as active.
- [Confirmed] `4a31ec4`: YT Music like state is read and toggled through its session custom action, "Like" vs "Undo like". The session dump no longer reads non-rating or non-bitmap keys as such.
- [Confirmed] `6e75090`: the like state is told from the icon's resource name (`yt_fill` vs `yt_outline`), so it works in any language. English names stay as the fallback.
- [Confirmed] `2e4e77f`, stock players:
  - the player's own channel release on BACK is no longer restored (`isStockPlayerLeaving`);
  - transport buttons go to the stock player whose track is shown (`dispatchToStockPlayer`, `getTransportTargetPackage`);
  - `SyuMusicLibrary`:
    - reads the whole `Table_Favorite` and re-reads it on `onLauncherResumed`;
    - pending presses overlay the read values until written and read back;
    - opens `music.db` directly with system privileges, otherwise through su;
    - finds the access by trying to open the database off the main thread;
  - the Id3 cover is read off the main thread (`ID3_READER`).
- [Confirmed] `d83bc8f`: every `SyuMusicLib` write line names the access mode.
- [Confirmed] `c2a6245`: `com.syu.media` play/pause/next/previous go through its IPlayer binder (`MusicService.controlSyuMedia`, transaction codes 1/7/8/6/5).
- [Confirmed] `fee2455`: dual and single panes wait up to 15 s for a late VD host (`HOST_WAIT_TIMEOUT_MS`, `isAwaitingVdHost`) instead of starting their apps without a display.

### Results confirmed by the user

- [Confirmed] YT Music like in English: "W angielskiej wersji działa bezbłędnie". In Polish it stopped working until `6e75090`; after that: "Wszystko działa."
- [Confirmed] On the 7862, after `2e4e77f`/`d83bc8f`: "Zdecydowana wiekszość opisanych problemów zniknęła"; "Na 7862 wszystko jak na razie działa tak jak trzeba".
- [Confirmed] Device log line: `SyuMusicLib: favorite=true written for /mnt/sdcard/Music/Alvaro Soler - Animal.mp3 (opened directly)`. This is direct access with system privileges on the 7862.

### Planned or proposed only

- [Suggestion] The Shizuku Next fixes in §4. Not implemented: the Shizuku Next repository is not in this session.
- [Suggestion] Sending a "stopped" state to "Display media Titles" after BACK. Deferred by the user: „Display media Titles” zajmiemy się kiedy indziej.

## 3. Requirements discovered

- [Historical] "jeśli brak okładki to zrób proszę tak, aby zapisywała się i wyświetlała ikona aplikacji."
- [Historical] "w razie braku aktywnej sesji, po kliknięciu w dowolny przycisk otwierała się aplikacja, z której odtwarzał ostatnio zapisany utwór. Dla com.syu.music tego nie rób".
- [Historical] "jeśli nie ma aktywnej sesji to przycisk pause nie zmienia się na play … tutaj też należy sprawdzać czy w ogóle jest zainstalowana."
- [Historical] "Upewnij się że wszystkie ostatnie zmiany nie będą wywoływać StrictMode".
- [Historical] YT Music like detection must work regardless of the app's language: "nie można stworzyć tego tak aby działalo automatycznie niezależnie od tłumaczenia?"
- [Historical] User's choice: "Wybieram opcję 2 … opcja 1 jako fallback". Option 2 is the session's like button; option 1 is the ReVanced patch publishing the video id.
- [Historical] Owner rules, in force throughout:
  - work only on `ccr-087eed00-gbqsuz`;
  - no PR, never merge to main;
  - answer in Polish;
  - Magisk module version stays 1.0.0;
  - no model IDs in commits or code;
  - FYT services only on FYT units;
  - nothing may crash when running as a plain user app.

## 4. Architectural and technical decisions

- **Like state for YT Music** [Confirmed]
  - Read from the session's custom action, not from the video id: songs carry no video id (`mediaId=null`, `yt3.googleusercontent.com` icon). Option chosen by the user.
  - The language-independent signal is the icon resource name, because action names are localised ("Podoba mi się" / "Cofnij polubienie"). My decision.
- **BACK out of `com.syu.music` is treated as the user's stop and its channel is not restored** [Confirmed]
  - Reason: logs show `pause:2`, `bOnKeyBack: true` and `stopOutput`, then the launcher's "Panes settled" restore resumed playback only when the channel change landed after `onResume`.
  - I decided it; the user later agreed the "play" icon is correct.
- **Widget buttons go to the stock player whenever the widget shows its track** [Confirmed]
  - Reason: with `MusicService.state=false`, `pickTargetController` fell back to the paused Musicolet session.
- **`music.db` access order: system privileges, then root (su), otherwise none, which keeps the launcher cache** [Confirmed]
  - Shizuku as shell (uid 2000) is ruled out because neither the uid nor SELinux's shell domain may reach another app's private data. This was reasoned, not tested on a device.
- **`com.syu.media` control goes through the IPlayer binder** [Confirmed]
  - Based on decompiled classes the user provided. Its media session (`music_MediaManager`) registers no keys for music, and it takes no intents.
- **Panes wait for a VD host that has not attached yet** [Confirmed]
  - Decision: wait up to 15 s rather than start apps without a display.

## 5. Rejected decisions and why

- [Historical] Background resume of the last track after a restart was not implemented: it cannot be done universally. Decided in the earlier, summarised part.
- [Historical] Option 1 for YT Music (the patch publishing the video id) was kept only as a fallback, not used as the main path.
- [Confirmed] Media buttons to `com.syu.media`'s session were replaced by binder calls in `c2a6245`. The session ignores media keys for music, per the user's decompilation.
- [Confirmed] English-only like detection was replaced because it failed in the Polish UI.
- [Unverified] The alternative of resuming music after BACK (restoring the channel every time) was offered and not chosen. The user accepted the current behaviour.

## 6. Problems encountered and their solutions

- **Cover from the previous track; no cover for tracks without art**
  - Fix: save and show the app icon (`5a6d4d4`).
  - [Confirmed] it works on the phone: "Pozostałe zmiany działają na telefonie".
- **YT Music like state not read**
  - Cause, step 1: no video id in the session, and the active queue id was -1. The title match (`90c8073`) found the item, but it had no id either.
  - Fix: read the session's like action (`4a31ec4`), then the icon name (`6e75090`).
  - [Confirmed] it works in English and in Polish.
- **StrictMode violations**
  - Sources: `refreshLeftCycle` LitePal, Settings preferences, `hasRoot()` files, the Id3 cover read (about 30 ms every second).
  - Fixed in `9fc2c74` and `2e4e77f`.
  - [Unverified] that they are gone; no follow-up log was checked for them.
  - [Confirmed] the remaining ones are system-side: Samsung `IdsController`, `FreecessController` via binder, `Toast.isSpeg`.
- **After BACK from `com.syu.music`: play/pause looked wrong and next/prev drove Musicolet**
  - Cause: the race described in §4.
  - Fix: `2e4e77f`.
  - [Confirmed] the next/prev part is fixed. On the remaining icon complaint the user agreed: "ikona “play” jest poprawna"; the confusion came from the "Display media Titles" app.
- **Stale liked heart for a moment after unliking in `com.syu.music` and returning**
  - Cause: per-path cache re-read only every 1.5 s.
  - Fix: full-table read on resume (`2e4e77f`).
  - [Confirmed] in the user's statement that most problems disappeared.
- **`com.syu.media` play/pause sent a `com.syu.music` intent, which the 7870 does not have**
  - Fix: binder control (`c2a6245`).
  - [Unverified]: 7870 logs are pending.
- **SyuMusicLib probe line missing from a log**
  - Cause: the line is written once per process, and the capture started with `FROM_NOW`.
  - Fix: `d83bc8f` adds the access mode to every write line.
  - [Confirmed] the device line shows "(opened directly)".
- **Empty dual pane on A16 with Shizuku after an Android Studio reinstall or a long sleep**
  - Cause: the panes started before the Shizuku host attached (17.5 s vs 18.17 s), and nothing retried.
  - Fix: `fee2455`.
  - [Unverified] on the device.
- **Shizuku disconnects and reconnects at boot**
  - Cause, from logs: `ShizukuStateMachine.update()` demotes `STARTING` to `STOPPED`; parallel starters run; a newer starter kills the booting server ("killed by signal 9"); timeouts are shorter than the roughly 9–10 s the server needs at boot.
  - Not fixed. [Suggestion]

## 7. Features implemented or discussed

- [Confirmed] App icon as the cover for tracks without art: implemented.
- [Confirmed] Opening the last player when it has no session: implemented. Skipped for `com.syu.music`; checks that the app is installed.
- [Confirmed] YT Music like read and toggle through its session button: implemented and works per the user.
- [Confirmed] Session dump to `MediaDebug` when a YouTube-family session has no video id: implemented.
- [Confirmed] Stock transport routing (`dispatchToStockPlayer`) for the launcher widget and the home widget (`MediaTransportReceiver`): implemented.
- [Confirmed] `SyuMusicLibrary` with direct, root or no access, a whole-table cache and re-read on resume: implemented. Direct access confirmed on the 7862.
- [Unverified] `com.syu.media` IPlayer control: implemented, untested on the 7870.
- [Unverified] Pane wait for a late VD host: implemented, untested.
- [Suggestion] Shizuku Next start fixes: discussed only.
- [Suggestion] "Display media Titles" stopped state: discussed only, deferred.

## 8. Important constraints

- **Devices:** FYT 7862/8581 (`com.syu.music`, sprd `ums512_1h10_Natv`, Android 10); FYT 7870 (`com.syu.media`); Samsung SM-A556B (Android 16, Shizuku); Xiaomi Redmi Note 8T (Android 14). [Confirmed] from the log headers.
- **The device 192.168.1.104:5555 cannot be reached from the cloud container; there is no `adb` there.** [Confirmed] So no live tests were run.
- **`music.db`:** owned by `com.syu.music` (system uid, mode 660). [Historical] From the other chat's commit text.
- **`com.syu.media`'s `play()` returns false unless its `isRunning` model value is true.** [Historical] From the decompiled `MusicService.java` the user provided.
- **MCU channels:** 8 is FYT music, 0 is Android/none, 10 is third party. [Confirmed] From code and logs.
- **Kotlin files are checked only by CI; the local javac check produces AppCompat/R noise.** [Confirmed]

## 9. Unresolved questions

- [Unverified] Does `com.syu.media` binder control work on the 7870? The user said: "Logi z 7870 podeślę jak tylko je dostanę."
- [Unverified] Is the empty dual pane fixed on A16?
- [Suggestion] Shizuku Next fixes: need access to that repository. The user called it "temat na później".
- [Suggestion] Whether to send a stopped state to "Display media Titles".
- [Unverified] Whether the StrictMode fixes cleared the Settings and left-bar violations: not re-checked in a log.

## 10. Information that may be missing from the repository

- **YT Music like action names and resources** [Confirmed]
  - Names: "Like" ↔ "Undo like" (EN); "Podoba mi się" ↔ "Cofnij polubienie" (PL).
  - Icons: 2131233341 (not liked) and 2131232976 (liked); dislike 2131233337.
  - YT Music sometimes reports the active queue id as -1, and song queue items carry `mediaId=null` and `yt3.googleusercontent.com` icons.
- **BACK in `com.syu.music`** [Confirmed]
  - The player pauses and releases channel 8→0 between 54 ms before and 18 ms after the launcher's `onResume`.
  - Its per-second MusicService updates stop until playback resumes.
- **Shizuku server start time at boot** [Confirmed]
  - About 9–10 s from "starting server" to "service created".
  - Measured: 19:18:50.7→19:19:00.4, 21:12:57.6→21:13:07.0, 21:36:13.9→21:36:22.7 (logs from 17-10).
- **IPlayer transaction codes** [Historical], from the user's decompilation: play 1, playLast 5, playNext 6, pause 7, isPlaying 8, getProgress 9, getPlayingSong 10, seekTo 12, registerCallback 15.
- **The "Display media Titles" app keeps showing the interrupted title.** The user was misled by it about the play state. [Historical]

## 11. Relevant file paths and references

### Files touched in this part

- `app/src/main/java/com/android/launcher66/LauncherMusicWidget.java`
- `app/src/main/java/com/android/launcher66/NotificationListener.kt`
- `app/src/main/java/com/android/launcher66/MediaFavoriteController.java`
- `app/src/main/java/com/android/launcher66/MediaTransportController.java`
- `app/src/main/java/com/android/launcher66/MediaTransportReceiver.java`
- `app/src/main/java/com/android/launcher66/LauncherAppBars.java`
- `app/src/main/java/com/android/launcher66/Launcher.java`
- `app/src/main/java/com/android/launcher66/settings/SyuMusicLibrary.java`
- `app/src/main/java/com/android/launcher66/settings/SettingsActivity.java`
- `app/src/main/java/com/android/launcher66/settings/SettingsFragmentFirst.java`
- `app/src/main/java/com/fyt/car/MusicService.java`
- `app/src/main/java/com/syu/util/WindowHostDualPane.java`
- `app/src/main/java/com/syu/util/WindowHostSinglePane.java`
- `app/src/main/java/com/syu/util/WindowHostVdView.java`
- `app/src/main/java/com/syu/util/WindowHostActivityView.java`

### Commits

- This part: `5a6d4d4`, `9fc2c74`, `90c8073`, `4a31ec4`, `6e75090`, `2e4e77f`, `d83bc8f`, `c2a6245`, `fee2455`.
- From another chat, analysed here: `05acaa4`, `81ad1df`, `ba030bf`, `c2cc312`, `a7039ad`.
- Earlier part of this conversation: listed in §2.

### Logs (user uploads)

- `c27525e6-18-10-2026_16-48-03.txt`
- `ecbf376e-18-10-2026_17-14-22.txt`
- `b43e6e27-18-10-2026_17-37-12.txt`
- `db79e274-18-10-2026_17-42-42.txt`
- `c5cb3bc4-18-10-2026_18-01-44.txt`
- `8e057542-18-10-2026_23-18-46.txt`
- `0986893a-18-10-2026_23-29-09.txt`
- `7c6c7113-19-10-2026_00-23-07.txt`
- `522ec376-dual_pip_bug_19-10-2026_08-03-14.txt`
- Boot logs `70ff373b-boot.txt`, `9a096b39-boot.txt`, `21251cb0-boot.txt`

### Decompiled `com.syu.media` classes (provided by the user)

`f13bf21c-IPlayer.java`, `c88a92a1-MusicService.java`, `528c9d90-PlaybackBinder.java`, `73cba3b4-PlaybackService.java`

### External

- Shizuku Next source: `https://github.com/rushiranpise/Shizuku-Next.git`, cloned in the scratchpad.
- Its relevant files: `ShizukuStateMachine.kt`, `WatchdogService.kt`, `AdbStarter.kt`, `AdbStartWorker.kt`, `starter.cpp`.

## Summary by label
- Confirmed: 43, Historical: 15, Suggestion: 9, Unverified: 9