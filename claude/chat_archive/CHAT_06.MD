# CHAT_06 — FYT stock sources in the music widget (7870 com.syu.media, 7862 radio): implementation, review, fixes, 7870 test guide and commits

| Field | Value |
|---|---|
| Conversation title | unknown |
| Approximate dates | 2026-10-23 (implementation, per a memory file written in this conversation) to 2026-10-26 (review and commits); this report requested 2026-11-12 |
| Model / role | Implementation of the owner's brief (first part, before a context compaction), then review, fixes, writing the test guide and committing (second part, after the owner switched the model with `/model`) |
| Repository branch(es) mentioned | `ccr-087eed00-gbqsuz` (all work and commits), `main` (main branch in git status), `testBranch` (named only in a CLAUDE.md shown at the end of the conversation) |
| Report written | 2026-11-12 |

## 1. Aspect of the project discussed

The launcher's music widget (`LauncherMusicWidget`, AppWidgets `DateMusicWidget` and `DateRadioWidget`) and the FYT stock audio sources:
- On the 7870 (`com.syu.media`): USB/local music (MCU channel 8), internet radio (7), BT music (3) and FM/AM radio (1).
- On the 7862/8581 (`com.syu.music`, `com.syu.radio`): showing the radio station when the MCU channel is 1.
- The MCU sound-channel logic in `NotificationListener` and fixes D1–D13 and N1 from the owner's brief (work packages WP1–WP12, P3 optional).

The second part of the conversation was a review of that implementation, three fixes, a plain-English test guide for a 7870 tester, and committing everything.

## 2. Work performed

**Done (with evidence)**
- [Confirmed] WP1–WP12 were implemented in the first part. New classes in `com.fyt.car`:
  - `StockKindArbiter`, `StockTrack`, `StockFreq`, `StockTitles`, `StockResumePolicy`, `StockSources`, `SyuMediaClient`, `StockRadioSource`, `StockBtSource`;
  - unit tests `StockKindArbiterTest`, `StockFreqTest`, `StockTitlesTest`, `StockResumePolicyTest`.
  - Changes to `MusicService`, `NotificationListener.kt`, `LauncherMusicWidget`, `MediaTransportController`, `MediaFavoriteController`, `Launcher`, `DateMusicWidget`, `DateRadioWidget`, `CarStates`, `UserTouches`, `LauncherApplication` and `MediaDebugDump.kt`.
  - Evidence: the git status and diffs shown, and a build result of 78 tests passing with both debug flavors building.
- [Confirmed] The owner tested on the 7862 and reported: "Na 7862 każda wcześniejsza funkcja działa bez zmian, a poprawka z com.syu.radio dokladnie tak jak zaplanowano; przełączanie między kanałami działa bezbłędnie."
- [Confirmed] The implementation was reviewed against the decompiled sources. Matches found:
  - `MainAct` page actions (`com.syu.music`, `com.syu.radio`, `com.syu.btmusic`, `com.syu.online`);
  - the `MediaSource` and `RadioSource` parcel layout (RadioSource appends type, country, local, freqTitle, icon);
  - the `Player.getPlayingSong()` placeholder (id −1, every text "unknown");
  - the `BluetoothController` module-2 commands (0 prev, 1 next, 2 play/pause, 3 pause, 27 play, 4 stop);
  - `LsecService.U_BUTTON_EVENT = 2` on the 7870, with `MRemoteModule.register` ignoring the code;
  - the `RadioObserver` codes 13 and 26.
- [Confirmed] Fix 1 in `StockKindArbiter.onPlayerPlaying`: it now returns false when `shown.overlay && lastChannel == shown.channel`. Two tests were added to `StockKindArbiterTest`:
  - `aPlayerDoesNotTakeTheRadioOrBtOffWhileTheMcuIsOnTheirChannel`;
  - `aPlayerTakesOverFromARadioThatLostItsChannel`.
- [Confirmed] Fix 2 in `StockSources.acceptSyuMedia`: added `PLAYER_SETTLE_MS = 1500L`. A takeover now needs `sampledAtMs >= sChannelChangeAtMs + PLAYER_SETTLE_MS`.
- [Confirmed] Fix 3 in `MusicService.applySyuMedia`: a playing update now goes to `NotificationListener.onStockSourceUpdate` only if `hasTitle && new Helpers().isFytMusicAllowed()`.
- [Confirmed] Build and tests after the fixes:
  - `:app:testFytDebugUnitTest`, `:app:assembleFytDebug` and `:app:assembleStandardDebug` gave "BUILD SUCCESSFUL in 3m 12s", with tests=80, failures=0, errors=0.
  - The second commit compiled on its own (the later files were stashed): `:app:compileFytDebugJavaWithJavac` and `:app:compileStandardDebugJavaWithJavac` gave "BUILD SUCCESSFUL in 40s".
- [Confirmed] Wrote the test guide `docs/7870-stock-sources-test.md`. It is in plain English, uses the launcher's own Logcat service, and has Parts A–F.
- [Confirmed] Five commits on `ccr-087eed00-gbqsuz`, each made of whole files, with the working tree clean afterwards:
  1. `ded0e6ef` Stock sources: which one the music widget shows, as pure model classes
  2. `d5030a6e` Stock sources: radio, BT and both com.syu.media players behind the music widget
  3. `4ad0bed2` Music widget: show, control and open the stock source shown
  4. `f1773cc1` UserTouches: count only button events as buttons
  5. `0b722649` Docs: stock sources brief and a 7870 test guide. This commit also contains the `.gitignore` change and `docs/prompts/sonnet_stock_media_sources.md`.
- [Confirmed] Updated the memory files `project-stock-sources-7870.md` and `MEMORY.md`. They are outside the repository.

**Not done or planned only**
- [Confirmed] Nothing was pushed, and nothing was run on a 7870.
- [Confirmed] P3 is mostly not done. Only the radio frequency line in place of "Live" was done. Not done: online radio logos from `cabinet.data`, names from `radio.db` via root, the BT cover from code 51.
- [Suggestion] Publish the test guide as a shareable page. It was offered and not done.

## 3. Requirements discovered

- [Historical] The com.syu.music path (7862/8581) behaves identically. The brief forbids changing:
  - `MusicService.onStartCommand/sendData/sendInternalData/post`;
  - `NotificationListener.onFytUpdate/handleFytUpdate/requestFytMeta/readFytMeta`;
  - `settings/SyuMusicLibrary.java`;
  - the com.syu.music branch of `MediaFavoriteController`;
  - the 1/3/8/10 channel logic for the 7862.
- [Historical] All new behavior is gated by `StockSources.isSyuMediaUnit()` or `shownOverlay()`/`radioShown()`. Consumers resolve in this order: the overlay, then `MusicService.isSyuMediaSource()`, then the old code.
- [Historical] No new manifest permissions and no root requirement. Both flavors must build.
- [Historical] No Binder, ContentResolver, file IO or bitmap decoding on the main thread.
- [Historical] Comments in English (why, not what). New classes go in `com.fyt.car`. One log line per state change.
- [Historical] At first, no commit until the owner asks, and no `decompiled_*` directories in git.
- [Historical] Second-part request: "Sprawdź poprawność tego co wdrożył Sonnet i wykonaj poprawki jeśli uznasz, że takie powinny się pojawić. Napisz też instrukcję testów krok po kroku dla użytkownika 7870 używając prostego angielskiego. Następnie całość zacommituj na ccr-087eed00-gbqsuz tak jak uznasz, ale bez ręcznego rozdzielania plików."
- [Historical] About the tester: "użytkownik, który ma to przetestować nie jest bystrzakiem". No 7870 logs exist yet.
- [Historical] Final report in Polish. Unit tests are required for the arbiter, frequency formatting, `StockTitles` and the resume decision.

## 4. Architectural and technical decisions

- [Historical] Radio (both units) and BT (7870) are overlays with their own state that never write `MusicService` fields. Reason: com.syu.music sends one last state=false update after losing the channel, which would overwrite the station. Decided by the owner's brief.
- [Historical] com.syu.media services are bound without `BIND_AUTO_CREATE`; after `onBindingDied`, unbind and rebind after 5 s. Reason: the launcher must not start the player. Decided by the brief; present in `SyuMediaClient`.
- [Confirmed] The 7870 is detected with `resolveService("com.syu.media.music.MusicService")` on a separate thread. `isSyuMediaUnit()` stays false until it is known.
- [Confirmed] The radio's channel token is "com.syu.radio" on the 7870 as well, and BT's is "com.syu.bt". This deviates from the brief, which proposed MEDIA_PKG. Reason: the token would otherwise alternate between two names on every update. Decided by the assistant in the first part.
- [Confirmed] A com.syu.media player cannot take the widget from the radio or BT while the MCU is on their channel. Reason: a read taken just before the player's own pause could take the widget over, and nothing would give it back. Decided by the assistant in the review.
- [Confirmed] After a channel-driven change of the shown source, a player's takeover waits 1.5 s. Reason: avoid a ≤1 s flicker of the player that just lost the channel. Decided by the assistant.
- [Confirmed] The `isFytMusicAllowed()` gate applies only to com.syu.media player updates, not to overlays. Reasons: the old 7870 code and the com.syu.music path had it; an overlay's play state is read live from `CarStates.mAppID`; a dropped radio publication would not be retried; the 7862 radio is confirmed working. Decided by the assistant.
- [Confirmed] Commits are split by whole files into five, each compiling on its own. Decided by the assistant within the owner's "bez ręcznego rozdzielania plików".
- [Confirmed] The 7870 tester collects logs with the in-app Logcat service: Launcher settings → Logcat service, Timeout 900, "Log everything" if shown, saved to Download/Launcher66_Logs. adb is not used. Decided by the assistant.
- [Confirmed] The pre-existing `.gitignore` change and the brief in `docs/prompts/` were committed because the owner asked to commit "całość". Decided by the assistant.
- [Confirmed] Station-name lookup from `/sdcard/radio_logo/<Name>_<freq>.png` and `/sdcard/fmbd/fmbd.txt` runs on the 7862 only, on a background thread.

## 5. Rejected decisions and why

- [Confirmed] MEDIA_PKG as the radio's token on the 7870, as the brief proposed. Rejected because the token would flip between names.
- [Confirmed] Applying the `isFytMusicAllowed` gate to the radio and BT overlays. Rejected for the reasons in section 4.
- [Historical] Manual hunk-level splitting of files across commits. Rejected by the owner.
- [Confirmed] A single commit. It was considered and replaced by five commits that each compile.
- [Confirmed] adb for the 7870 tester. Rejected because the tester is not technical.
- [Confirmed] Changing `Launcher.refreshBtInfo`, which treats BT times as seconds while the 7870 sends ms and `btCurTime * 1000` can overflow an int. Left untouched because it is shared code.

## 6. Problems encountered and their solutions

- [Confirmed] A stale "playing" read from com.syu.media right after the switch to radio or BT could take over the widget and leave it stuck on a paused track while the radio plays. Cause: the takeover only rejected reads sampled before the channel change. Solution: the arbiter rule in section 4. Confirmed by unit tests only, not on a device.
- [Confirmed] Flicker between USB music and internet radio after switching. Cause: a stale read from the player that lost the channel. Solution: `PLAYER_SETTLE_MS`. Not tested on a device.
- [Confirmed] The `isFytMusicAllowed` gate was missing on the 7870 path. Cause: dropped in the WP3 refactor of `applySyuMedia`. Solution: restored. Build-verified only.
- [Confirmed] First part, build and code issues, all solved and followed by green builds:
  - Gradle through `cmd.exe //c gradlew.bat` from Bash failed, so it was run from PowerShell with `-p` and `--offline`;
  - a missing `IBinder` import, re-added;
  - `Handler.hasCallbacks` needs API 29 while minSdk is 26, so it was replaced by a `burstPending` flag;
  - the favorite read cadence evaluated `ticks % 5` on non-tick refreshes, fixed;
  - radio and BT `sendInt` calls ran on the main thread and were moved to the "StockControl" thread.

## 7. Features implemented or discussed

All items below are implemented in code and committed unless stated otherwise.

**7870 (com.syu.media)**
- [Confirmed] The widget follows USB music and internet radio through IPlayer, with the placeholder filtered out.
  - Favorites are kept in `content://com.syu.media/song` and `/radio`.
  - Not tested on a device.
- [Confirmed] BT overlay from com.syu.ms module 2, with a grey heart, control over module 2 and play from another channel by setting channel 3 and then sending command 27. Not tested on a device.
- [Confirmed] Channel 7 is treated as a stock channel on the 7870; the com.syu.media uid is excluded from the third-party audio check. Not tested on a device.
- [Confirmed] Resume of a com.syu.media player after the launcher restores its channel: `StockResumePolicy`, played ≤3 s before leaving, back within 10 s, no user pause; TX_PLAY only if not playing. Not tested on a device.
- [Confirmed] Widget taps open the right com.syu.media page. The BTAV page no longer crashes without com.syu.bt, and its buttons fall back to module 2. Not tested on a device.

**Both units**
- [Confirmed] FM/AM radio overlay. Station name from the RDS PS, then (7862 only) the files of com.syu.radio, then the frequency. Grey heart; frequency line in place of "Live". Verified by the owner on the 7862.
- [Confirmed] `UserTouches` counts only code 2 as a button.
- [Confirmed] `StockSources.dump()` is added to the `dumpMediaDebug` output.

**Discussed only**
- [Suggestion] P3 items: online radio logos from `cabinet.data`, names from `radio.db` via root, the BT cover from code 51.

## 8. Important constraints

- [Historical] Devices:
  - FYT 7862 and 8581 use `com.syu.music` and `com.syu.radio`;
  - FYT 7870 uses `com.syu.media`, and com.syu.radio, com.syu.music and com.syu.bt may be missing.
- [Historical] A CLAUDE.md shown at the end of the conversation says: "Nothing may change on the owner's **FYT 7862** (Android 10, system flavor) unless the task is about it".
- [Confirmed] `minSdk = 26`, `targetSdk = 36`. The manifest has `QUERY_ALL_PACKAGES`, which is needed for binding to and querying com.syu.media.
- [Historical] Flavors at the time were `fyt` (system uid) and `standard`. The later CLAUDE.md calls them `system` and `standard`.
- [Confirmed] On the 7870, `LsecService.MRemoteModule` sends every BSP event to every callback (codes 5, 8, 9 and others).
- [Confirmed] `com.syu.remote.Callback` callbacks arrive on the main thread.
- [Confirmed] `RemoteTools.addRefreshLisenter` only works for codes the module was enabled with in `CarStates`, which is why 13 and 26 were added to `RADIO_LOOK_CODE`.
- [Confirmed] The working tree uses CRLF line endings. Gradle runs from PowerShell with `--offline`.

## 9. Unresolved questions

- [Unverified] Whether com.syu.ms pushes current values when the launcher re-registers (`RemoteTools.notify`). The first display of radio and BT depends on it.
- [Unverified] Whether com.syu.media gives up channel 8 (8 → 0) when it pauses for a pane app. If it does, `isStockPlayerLeaving` blocks the restore and the resume.
- [Unverified] On the 7870, radio code 13 is the PTY (program type), not radiotext. It shows as the second line only for stations without a PS name. Judged harmless; not verified on a device.
- [Unverified] Whether com.syu.ms accepts `sendInt(2, code)` with an empty int array, where com.syu.media sends null.
- [Unverified] Whether com.syu.media's internet radio really plays on channel 7, and whether `getProgress` moves for streams.
- [Unverified] BT time units: ms on the 7870 versus seconds expected by `Launcher.refreshBtInfo`.
- [Unverified] The whole 7870 behavior. No 7870 logs exist yet.
- [Unverified] Whether the owner wanted `docs/prompts/sonnet_stock_media_sources.md` in the repository. It was committed on the reading of "całość".
- Not discussed: the later CLAUDE.md asks for work on `testBranch` and calls the old branch historical; this conversation committed on `ccr-087eed00-gbqsuz` as the owner instructed at the time.

## 10. Information that may be missing from the repository

- [Confirmed] The owner's 7862 result: every earlier function works unchanged, the com.syu.radio overlay works as planned, and channel switching works.
- [Historical] The 7870 tester is not technical, so logs have to come from the in-app Logcat service.
- [Confirmed] The reasons for the three review fixes: the stale-read race, the flicker, and the gate missing compared with the old 7870 code.
- [Confirmed] `NotificationListener.setStatus(2)` sets `fytMusicAllowed` to false for 1800 ms after a session player starts. `takeSourceForMcu` ignores calls within `HANDOVER_SETTLE_MS = 1500L` of a handover.
- [Confirmed] Decompilation facts:
  - 7870 radio code 13 is PTY;
  - `RadioSource` ids come from the database (≥ 1);
  - the online player returns a stream source through `isPlayerType(2)`;
  - `AudioSource` writes no extra parcel fields.
- [Confirmed] Commit 2 was checked to compile without commits 3 and 4.

## 11. Relevant file paths and references

**New classes in `app/src/main/java/com/fyt/car/`**
- `StockKindArbiter.java`, `StockTrack.java`, `StockFreq.java`, `StockTitles.java`, `StockResumePolicy.java`
- `StockSources.java`, `SyuMediaClient.java`, `StockRadioSource.java`, `StockBtSource.java`

**Changed files**
- `app/src/main/java/com/fyt/car/MusicService.java`
- `app/src/main/java/com/android/launcher66/`:
  - `NotificationListener.kt`, `LauncherMusicWidget.java`, `MediaTransportController.java`, `MediaFavoriteController.java`
  - `Launcher.java`, `LauncherApplication.java`, `MediaDebugDump.kt`
- `app/src/main/java/com/syu/widget/DateMusicWidget.java`, `app/src/main/java/com/syu/widget/DateRadioWidget.java`
- `app/src/main/java/com/syu/car/CarStates.java`, `app/src/main/java/com/syu/util/UserTouches.java`

**Tests**
- `app/src/test/java/com/fyt/car/StockKindArbiterTest.java`, `StockFreqTest.java`, `StockTitlesTest.java`, `StockResumePolicyTest.java`

**Docs and config**
- `docs/7870-stock-sources-test.md`
- `docs/prompts/sonnet_stock_media_sources.md` (the brief; on-device protocol in section 9, report format in section 11)
- `.gitignore` (adds `/decompiled_com.syu.media/` and `/decompiled_com.syu.radio/`)

**Reference material read**
- `decompiled_com.syu.media/classes.dex/sources/com/syu/media/MainAct.java`
- `.../entities/RadioSource.java`, `.../entities/MediaSource.java`, `.../player/Player.java`
- `.../com/syu/manger/module/bt/BluetoothController.java`, `.../module/radio/RadioObserver.java`
- `decompiled_FYT_jars/7870/system.zip`: `LsecService.java`, `ModuleCallbackList.java`
- `app/src/main/java/com/syu/remote/RemoteTools.java`, `Registrar.java`
- `app/src/main/java/com/android/launcher66/settings/LogcatWorker.java`

**Commits**
- `ded0e6ef`, `d5030a6e`, `4ad0bed2`, `f1773cc1`, `0b722649`
- Base: `1da85173` Update decompiled jars; earlier: `c2a62453`, `fee24555`, `d83bc8fb`, `2e4e77f8`

**Memory files (outside the repository)**
- `C:\Users\Hubert\.claude\projects\D--APK-FYT-Launcher-mod\memory\project-stock-sources-7870.md`
- `...\memory\reference-build-commands.md`
- `...\memory\MEMORY.md`

**Commands**
- `gradlew.bat :app:testFytDebugUnitTest`
- `gradlew.bat :app:assembleFytDebug :app:assembleStandardDebug`
- `adb shell am broadcast -a dumpMediaDebug`

## Summary by label
- Confirmed: 54, Historical: 14, Suggestion: 2, Unverified: 8