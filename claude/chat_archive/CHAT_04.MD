# CHAT_04 — Wake detection, LogcatWorker on wake, and the "home screen on top" guard (HomeFrontGuard) for wake and cold start

| Field | Value |
|---|---|
| Conversation title | unknown |
| Approximate dates | 2026-10-12 to about 2026-10-13. The test logs are timestamped 10-12 08:39 through 10-13 01:06; some device clocks showed 12-07 before time sync. |
| Model / role | Implementation and log analysis (code changes, commits, pushes, analysis of device logcat captures) |
| Repository branch(es) mentioned | `ccr-893cd285-tau8vs` (working branch); base commit `920fe8c` ("Merge pull request #26 from vasyl91/main-6mxprj") |
| Report written | 2026-11-11 |

## 1. Aspect of the project discussed

- **[Historical]** The user, writing in Polish, reported that LogcatWorker does not start on device wake on some FYT units and on the "phone" flavor. They asked to add every known wake-detection method, except what the 09-22-08 log showed. That log shows the FYT black screen (screen blanked and restored), which must not count as a sleep or a wake.
- **[Historical]** The user asked to strengthen both "Home screen always on top*" options (`launcher_home_wake`, `launcher_home_cold_start`), so the launcher is always in front in those scenarios when an option is enabled.
- **[Historical]** The conversation then went through several rounds of device logs (FYT Unisoc `ums512_1h10_Natv`, Android 10). Each round refined:
  - which apps the launcher may send back after a wake or a cold start;
  - how to tell the user's launches from the device's;
  - how com.syu.ms restores its "top app" at wake.
- **[Confirmed]** A side bug was found and fixed: the fuel-stats overlay of the launcher's own `CanbusService` appeared over another app after a cold start.

## 2. Work performed

Done, with commits pushed to `ccr-893cd285-tau8vs`. Each push was shown by `git push` output.

- **[Confirmed]** `ffba656` "Wake: every signal, for the whole process; home screen kept in front after a wake". Added:
  - `WakeSignals.java`: merges ACC, display, screen broadcasts, unlock, dream, poll, CPU suspend and restart signals. It ignores the black screen and persists state with the boot id.
  - `WakeDetection.java`: a process-wide singleton.
  - `WakeDetectionService`, reduced to an anchor.
  - `CarStates` listening to more com.syu.ms codes.
  - `LogcatWorker.startForWake`.
  - The first `HomeFrontGuard` version.
  - Tests `WakeSignalsTest`.
  - This commit was made before the summarised part of the conversation; the details come from the conversation summary.
- **[Confirmed]** `3f79815` "Home screen in front: only against what the device opens, never the user":
  - Guard v2: expectations by package and time window, attribution of user input, and FYT BSP button listening in `UserTouches`.
  - A restart-at-wake bound in `WakeSignals` (`RESTART_AT_WAKE_MS`).
- **[Confirmed]** `c91621d` "Home screen in front: fixes from the captures of 12-10-2026":
  - Touches are now noted in `Launcher.dispatchTouchEvent`/`dispatchKeyEvent` instead of `onUserInteraction`.
  - The guard reads what is in front from the task stack (`DefaultDisplayTask.topTask`).
  - `pressHomeButtonAfterWake` was removed.
  - A cover left in front no longer ends the guard; `leftInFront`/`leftTasks` were added.
  - The protected list was split, with a "protected unless expected" exception.
- **[Confirmed]** `96d595f` "send a device's app back behind what was in front before it":
  - The pull-back target comes from the default-display task recency order (`DefaultDisplayTask.defaultDisplayTasks`, `launcherSeen`, `pulledBackTasks`, `Expectations.namesUnused`).
  - The first wake check runs at once (`WAKE_FRONT_FIRST_CHECK_MS = 0`).
- **[Confirmed]** `bb79f33` "Sleep: launcher on top before the MCU goes off; wake guard never waits a second":
  - `SLEEP_HOME_EARLY_MS` changed from 1500 to 300.
  - With the display off, the guard re-checks at its normal interval, and the launcher's own task on top counts even when the display is off.
- **[Confirmed]** `2ffd26f` "Wake: expect only what com.syu.ms noted when the MCU went off":
  - New `WakeSignals.Listener.onMcuOff()`, raised when U_MCU_ON goes to 0.
  - `WakeDetection.onMcuOff()` takes the restore-candidate snapshot again at that moment.
- **[Confirmed]** `555015c` "never take 'any app' for the device's own":
  - The cold-boot ANY_APP guard was removed, along with the 2-second ANY_APP window on wake when candidates are unknown.
  - `ANY_APP`, `waitForCoverStart` and the `once` flag were removed.
- **[Confirmed]** `4de4c99` "no app is protected for being one the user may want": the `PROTECTED_UNLESS_EXPECTED_PACKAGES` list was removed. This list covered carlink, canbus, bt, settings and gearhead.
- **[Confirmed]** `05747c7` "Fuel stats: the home screen's only over the home screen": `CanbusService.addStatsViewMainScreen()` now requires the Launcher lifecycle to be RESUMED.
- **[Confirmed]** `10c9b3b` "Wake and boot: com.syu.ms opening its noted app again, with either setting":
  - `keepHomeScreenTopAfterSleep()` (option off, home screen in front at sleep).
  - `frontAtSleep`.
  - `restoreToWatch(...)` with new tests in `WakeDetectionTest`.
  - The MCU-off snapshot is persisted (`ColdStart.noteMcuOffApps`/`mcuOffApps`).
  - `ColdStart.watchForRestoreAfterBoot`.
- **[Confirmed]** Verification for each change:
  - An ECJ compile in a scratchpad harness, diffed against the `920fe8c` baseline, showed 0 new errors.
  - JUnit runs passed: 28–31 tests successful at different points.
  - 5 failures were always in `WeatherManagerDistanceTest`, attributed to the harness lacking Play Services.
  - No Gradle or SDK build was run.
- **[Confirmed]** Device verification by the user, from logs:
  - Logs 21-48-36, 21-48-53 and 21-49-05, plus full.log: the user wrote "Wygląda na to że działa".
  - The 22-36-41 log: carlink opened within 3 s of the wake "pozostał na ekranie tak jak powinien".
  - Cold-start logs (23-35-26, 23-36-57) and later rounds.
  - Final round of 4 logs: analysed as all correct, after the `10c9b3b` changes.
- **[Unverified]** The path "com.syu.ms actually reopens its noted app at wake or cold boot, and the guard sends it back" was never exercised on the device after `10c9b3b`. On the user's unit com.syu.ms noted nothing in those runs.
- No pull request was created. The user never asked for one.

## 3. Requirements discovered

- **[Historical]** The FYT black screen (`U_BLACK_SCREEN`) must not count as a sleep or a wake.
- **[Historical]** The launcher must never pull back an app the user launched themselves, including com.syu.* apps, both at wake and at cold start. In the user's words: "Logika to wymaga wzmocnienia, aby uniknąć sytuacji w której użytkownik sam uruchomił jakąś aplikację (nawet com.syu.*) - zarówno przy wybudzeniu urządzania jak i przy cold starcie."
- **[Historical]** A PiP app opened deliberately in full screen must not be pulled back merely because its package matches: "A co jeśli użytkownik otworzy aplikację z PiP celowo w pełnym ekranie? Jeśli jest to sprawdzane tylko po pakiecie to zostanie cofnięta."
- **[Historical]** A fixed "first N seconds, anything goes back" window is unacceptable: "4s wystarczą żeby użytkownik uruchomił celowo inną apke".
- **[Historical]** No app may be special-cased. "skąd w ogóle ta logika? Carlink to była moja opcja z wyboru, równie dobrze mogłem wybrać cokolwiek." Also: "To co zrobiłeś jest nieakceptowalne, ponieważ różne przyciski mogą uruchamiać różne aplikacje." And: "był na wierzchu ponieważ celowo go tam zostawiłem. Mogłem zostawić dosłownie każdą inną aplikację."
- **[Historical]** The design must account for firmware where com.syu.ms actually restores its MCU-off app: "to że tego nie robi na moim urzadzeniu moze być kwestią jednostkową, na innych ta funkcja może działać."
- **[Confirmed]** Steering-wheel (CAN-bus) buttons and `adb shell am start` launches are invisible to the launcher.
  - Logs show no Android key events and no BSP `U_BUTTON_EVENT` for them.
  - com.syu.ms starts the canbus page itself.
  - adb starts show as "from uid 2000".
- **[Historical]** The user used `adb shell am start -n com.syu.carlink/.MainActivity` and `adb shell am start -n com.syu.filemanager/com.syu.media.act.ActMedia` to simulate user launches. These were not wheel buttons: "nie uruchamiałem go przyciskiem tylko za pomocą adb shell am start".

## 4. Architectural and technical decisions

- **[Confirmed]** **Wake detection is process-wide** (`WakeDetection.start` from `LauncherApplication`), and `WakeDetectionService` is only an anchor.
  - Reason: the service stopped when the launcher activity was destroyed (`stopServicesOnDestroy`).
  - Decided by the assistant.
- **[Confirmed]** **The guard pulls back only apps it can name.** These are:
  - the app com.syu.ms noted at MCU off, mirrored by a launcher snapshot at the U_MCU_ON 0 callback, which arrives 5–31 ms before com.syu.ms's note;
  - a pane app the launcher itself just stopped (`expectSystemLaunch`, `RELAUNCH_EXPECT_MS = 3000`).
  - Never "any app".
  - Reason: user launches via buttons or adb are invisible.
  - Decided after the user's objections.
- **[Confirmed]** **User input is real input only.**
  - Android's `performUserLeaving()` calls `onUserInteraction()` whenever an activity starts over the launcher, which made every com.syu.ms restore look like a tap.
  - Touches and keys are now noted in `dispatchTouchEvent`/`dispatchKeyEvent`.
- **[Confirmed]** **The front is read from the task stack, not from the lifecycle.**
  - The main thread stalls about 2 s on the first frame after a wake ("Davey! duration=1739ms").
  - During that stall the guard believed the launcher was resumed.
- **[Confirmed]** **The pull-back target is what was in front before the cover**, taken from the default-display recency order.
  - Reason: log 20-52-40, where carlink (opened via adb) was in front for 0.2 s before com.syu.ms's Maps, and the 250 ms polling never saw it.
- **[Confirmed]** **The home press at sleep comes at 300 ms, not 1500 ms.**
  - com.syu.ms notes `sTopAppWhenMcuOff` at MCU off, 0.8–1.0 s after ACC off, from `getRunningTasks(1)`, which includes pane tasks.
  - The launcher's `moveTaskToFront` makes it the top: com.syu.ms logged `newPackage = com.android.launcher66` 0.2 s after the press.
  - Result confirmed in later logs: `MCU OFF sTopAppWhenMcuOff:` empty.
- **[Confirmed]** **With the option off and the home screen in front at sleep**, an invisible `moveTaskToFront` runs at 300 ms (`keepHomeScreenTopAfterSleep`).
  - The g4 log confirms this: "Home screen kept as the top app for com.syu.ms", then an empty sTopAppWhenMcuOff.
- **[Confirmed]** **Restore watching applies under both settings** through `restoreToWatch(candidates, homeOnWake, frontAtSleep)`.
  - With the option on, the target is the home screen.
  - With the option off, the target is what was in front at sleep, which is excluded from the watch.
  - The rule is covered by unit tests; it has not been triggered on a device.
- **[Confirmed]** **There is no cold-boot "any app" guard.** Only the persisted MCU-off app is watched, within max(20 s, boot stall + 5 s), excluding the launcher's own last-app restore when the option is off.
  - Reason given: the device opens nothing at cold boot on this unit. com.syu.ms's `sTopAppWhenMcuOff` is empty after restart, and nothing came up in 6 captured cold boots.
- **[Confirmed]** **Protected packages are now only:**
  - system screens: `android`, `com.android.systemui`, `com.android.launcher3` (recents), permission controllers and package installers;
  - phone and calls: `com.android.phone`, dialer, incallui;
  - `com.syu.ms` and `vasyl.fytrating`;
  - camera name parts: "camera", "panoram", "backcar", "reverse";
  - plus the reversing and call states.
  - Everything else is treated alike.
- **[Confirmed]** **A process RESTART during sleep** brings the launcher to front only if `restartAtTheWake()` holds, meaning at most 5000 ms of CPU awake time (uptime) since the persisted sleep state. Later, with no candidates, nothing is watched.

## 5. Rejected decisions and why

- **[Confirmed]** **A time-window guard that pulls back anything in the first 4 s, then only pane apps for 15 s** (v1). Rejected by the user: a deliberate PiP full-screen open or an app launched within 4 s would be pulled back.
- **[Confirmed]** **The `onUserInteraction` note.** It produced a fake touch on every activity start over the launcher.
- **[Confirmed]** **`pressHomeButtonAfterWake`** (a blind move 500 ms after the wake). It ran about 2 s late and covered the user's canbus page in logs w2 and w3.
- **[Confirmed]** **The cold-boot ANY_APP window of about 27 s.** It sent back `com.syu.filemanager` launched via adb; the user called this unacceptable.
- **[Confirmed]** **The `PROTECTED_UNLESS_EXPECTED_PACKAGES` list, which made carlink, canbus, bt and others special.** The user objected to special-casing, and the list had no effect under named-only pull-backs.
- **[Confirmed]** **A 2-second ANY_APP window after wake when candidates are unknown** (phone, or restart). It violated the "never any app" rule.
- **[Suggestion]** **Considered but not done:**
  - parsing logcat `ActivityTaskManager: START ... from uid` lines to attribute launches;
  - `IActivityController`;
  - reading usage events for `SCREEN_INTERACTIVE`.
  - All were judged too hacky or invasive and never implemented.

## 6. Problems encountered and their solutions

- **[Confirmed]** **LogcatWorker not starting on wake.**
  - Cause: the service lifetime, limited signals, and a capture still running at the wake.
  - Solution: the `ffba656` changes, and `startForWake` extends or queues a capture.
  - Confirmed: later logs show `LogcatWorker: start()` at every wake.
- **[Confirmed]** **Every guard ended with "the user opened something".**
  - Cause: `onUserInteraction` is called from `performUserLeaving()`.
  - Solution: `c91621d`.
  - Confirmed in later logs, where the guard attributed covers correctly.
- **[Confirmed]** **The guard was blind during the main-thread stall** (carlink on top 1.4 s while the guard saw the launcher as resumed).
  - Solution: task-stack front detection (`c91621d`).
  - Confirmed: the 20-52-26 log shows carlink sent back 32 ms after appearing.
- **[Confirmed]** **The user's canbus page was covered** by the delayed `pressHomeButtonAfterWake` (logs w2, w3).
  - Solution: the press was removed (`c91621d`).
- **[Confirmed]** **com.syu.ms restored carlink, which was on the protected list** (log w4).
  - First solution: the named-expectation exception (`c91621d`).
  - Later made moot and removed (`4de4c99`).
- **[Confirmed]** **The user's adb-carlink ended up behind the launcher when Maps came over it within 0.2 s** (log 20-52-40).
  - Solution: the recency-order pull-back target (`96d595f`).
- **[Confirmed]** **The first wake check came 0.1 s before the display was on, and the guard then waited a full second** (log 21-13-23).
  - Solution: `bb79f33`.
- **[Confirmed]** **com.syu.ms recorded a pane app (Maps) at MCU off and reopened it full screen at wake, pulled out of its pane.**
  - Cause: pane tasks are more recent than the launcher's task, and the old 1.5 s home press came after MCU off.
  - Solution: the 300 ms press.
  - Confirmed by logs showing an empty `sTopAppWhenMcuOff` and no restore.
- **[Confirmed]** **com.syu.filemanager was pulled back during cold start.**
  - Cause: the ANY_APP boot window.
  - Solution: `555015c`.
  - Confirmed: logs e1 and e4 show filemanager stayed.
- **[Confirmed]** **The "canbus service view" appeared over a restored random app at cold start** (option off, apkanalyzer).
  - Cause: the launcher's `CanbusService.addStatsViewMainScreen()` checked the persisted `pipStarted` pref, whose value survives from before the restart.
  - Solution: also require the Launcher lifecycle to be RESUMED (`05747c7`).
  - **[Unverified]** whether this fix was confirmed on the device; no later log specifically showed this scenario.
- **[Confirmed]** **"Device put to sleep" lines missing from several logs.**
  - Cause: logd chatty rate limiting ("expire 40 lines" / "expire 42 lines").
  - Not a launcher bug; no code change.
- **[Confirmed]** **Harness issues during verification:**
  - ECJ conflicts with `android.jar` java.* packages;
  - Java keywords in the generated R class;
  - the stub-only `android.jar`, solved with an ASM mockable jar.
  - All were solved inside the scratchpad harness (from the summary).

## 7. Features implemented or discussed

- **[Confirmed]** **WakeSignals multi-source wake detection with black-screen exclusion.** Implemented.
- **[Confirmed]** **HomeFrontGuard: named expectations, user attribution, task-stack front, pull-back behind the previous front.** Implemented.
- **[Confirmed]** **Early home press at sleep (option on), and the invisible task-to-front at sleep (option off, home in front).** Implemented and seen working in logs.
- **[Confirmed]** **MCU-off snapshot via `onMcuOff()`.** Implemented; log line "Expected to be opened again at the wake, when the MCU went off: …".
- **[Confirmed]** **Persisted MCU-off snapshot and cold-boot watch (`watchForRestoreAfterBoot`).** Implemented. The log line "Cold boot: nothing com.syu.ms may open again is watched for" was seen. The watch was never triggered on the device.
- **[Confirmed]** **FYT BSP button listening (`UserTouches.startButtons`, system service "syu", `U_BUTTON_EVENT`).**
  - Implemented; "Listening to FYT's button events" was logged.
  - No button was ever reported in any log; CAN-bus wheel buttons do not arrive through it.
- **[Confirmed]** **`WakeSignals.restartAtTheWake()`** (RESTART bound of 5000 ms of uptime). Implemented. Not specifically exercised in device logs.
- **[Confirmed]** **CanbusService overlay fix.** Implemented.
- **[Suggestion]** **The user moves apps from FYT SystemUI's own autostart list to the launcher's autostart list** (`AppListAutostartDialogFragment`), so the launcher returns home after starting them. Advice only.

## 8. Important constraints

- **[Confirmed]** Device: FYT head unit, `sprd ums512_1h10_Natv`, Android 10 (API 29), Unisoc. The launcher runs as uid 1000 (system) and has REAL_GET_TASKS and input monitor access.
- **[Historical]** There is also a "phone" flavor without system privileges. One Samsung phone log was provided at the start. The launcher_home_wake setting is shown on phones too.
- **[Confirmed]** com.syu.ms behaviour on this unit:
  - It notes `sTopAppWhenMcuOff` at MCU off, 0.8–1.0 s after ACC off, from `getRunningTasks(1)` with pane tasks included.
  - It injects KEYCODE_HOME at MCU off.
  - At wake it sometimes reopens the noted app: in early logs yes, in some later ones "goto" with no START.
  - It has an empty value after a cold boot.
  - The ROM moves a pane app's stack to the default display when com.syu.ms starts it ("moveTopStack toVDisplay:false toTopDefault:true").
- **[Confirmed]** The main thread stalls about 2 s on the first frame after a wake.
- **[Confirmed]** `getRunningTasks` order reflects task recency (lastActiveTime). `moveTaskToFront` of an already-front launcher still makes it com.syu.ms's top app (evidence: the `newPackage = com.android.launcher66` log).
- **[Historical]** The user's git and commit rules:
  - develop on `ccr-893cd285-tau8vs`;
  - no PR unless asked;
  - commit messages end with the Co-Authored-By and Claude-Session lines;
  - no model identifiers in commits or code.
- **[Confirmed]** The user communicates in Polish; replies were in Polish.

## 9. Unresolved questions

- **[Unverified]** Whether the guard correctly sends back an app that com.syu.ms actually reopens at wake or cold boot under the `10c9b3b` logic. Never triggered on the user's device after the early press made the snapshot empty.
- **[Unverified]** Which buttons, if any, FYT's BSP `U_BUTTON_EVENT` reports. None appeared in any log.
- **[Unverified]** Whether the `CanbusService` overlay fix (`05747c7`) was confirmed on the device in the exact failing scenario.
- **[Unverified]** Why com.syu.ms "goto"ed the noted app without starting it in some logs (f1, f2) but started it in others.
- **[Historical]** Remaining known risks, stated to the user:
  - A button or adb launch of exactly the app com.syu.ms noted, within 3 s of the wake, is pulled back once.
  - Apps on FYT SystemUI's own autostart list stay in front after a cold start.
  - On a phone without privileges nothing is guarded; it relies on the sleep press.
- **[Unverified]** Phone flavor behaviour (keyguard, no privileges) after these changes. Not tested in this conversation.

## 10. Information that may be missing from the repository

- **[Confirmed]** Timing measurements from logs:
  - ACC off → MCU off: 0.8–1.0 s.
  - U_MCU_ON 0 callback precedes com.syu.ms's note by 5–31 ms.
  - com.syu.ms restore: 0.5–1 s after ACC on.
  - First-frame stall: about 2 s ("Davey! duration=1739ms").
  - Panes healthy about 2.9–3.3 s after wake.
  - Some of these are in code comments; the full set is not.
- **[Confirmed]** CAN-bus steering-wheel buttons on this unit do not produce Android input or BSP events. com.syu.ms starts `com.syu.canbus/com.syu.carinfo.rzc.biaozhi408.RZC_BZ408OilMileIndexActi` itself.
- **[Confirmed]** com.syu.ms prints a hard-coded launcher package list at MCU off (com.android.launcher27, 29, 30, 4, 6, 66, 13, 17, 22, 34, com.autolauncher.motorcar, com.dudu.autoui, com.android.settings). A top app in this list is recorded as empty.
- **[Historical]** The owner's policy: no app-specific special treatment, and user launches must never be undone.
- **[Confirmed]** The test methodology used by the owner: adb `am start` for simulated user launches, plus named log files describing each scenario (cold start or wake, option on or off, launcher or random app left on top).
- **[Confirmed]** The verification harness (ECJ + ASM mockable jar + JUnit) lives only in the session scratchpad, not in the repo.

## 11. Relevant file paths and references

- Files changed or added (exact paths as shown):
  - `app/src/main/java/com/android/launcher66/settings/WakeSignals.java`
  - `app/src/main/java/com/android/launcher66/settings/WakeDetection.java`
  - `app/src/main/java/com/android/launcher66/settings/WakeDetectionService.java`
  - `app/src/main/java/com/android/launcher66/settings/LogcatWorker.java`
  - `app/src/main/java/com/android/launcher66/settings/CanbusService.java`
  - `app/src/main/java/com/android/launcher66/HomeFrontGuard.java`
  - `app/src/main/java/com/android/launcher66/DefaultDisplayTask.java`
  - `app/src/main/java/com/android/launcher66/ColdStart.java`
  - `app/src/main/java/com/android/launcher66/Launcher.java`
  - `app/src/main/java/com/android/launcher66/LauncherApplication.java`
  - `app/src/main/java/com/syu/util/UserTouches.java`
  - `app/src/main/java/com/syu/util/WindowUtil.java`
  - `app/src/main/java/com/syu/util/WindowHostDualPane.java`
  - `app/src/main/java/com/syu/util/WindowHostSinglePane.java`
  - `app/src/main/java/com/syu/car/CarStates.java`
- Tests:
  - `app/src/test/java/com/android/launcher66/HomeFrontGuardTest.java`
  - `app/src/test/java/com/android/launcher66/settings/WakeSignalsTest.java`
  - `app/src/test/java/com/android/launcher66/settings/WakeDetectionTest.java`
- Settings keys: `Keys.LAUNCHER_HOME_WAKE` ("launcher_home_wake"), `Keys.LAUNCHER_HOME_COLD_START`, `Keys.LOGCAT_SERVICE_WAKE`, `Keys.DISPLAY_PIP`.
- Commits: `920fe8c` (base), `ffba656`, `3f79815`, `c91621d`, `96d595f`, `bb79f33`, `2ffd26f`, `555015c`, `4de4c99`, `05747c7`, `10c9b3b`.
- Branch: `ccr-893cd285-tau8vs`.
- Device logs referenced by name:
  - `12-10-2026_09-22-08.txt` (black screen), `12-10-2026_10-35-47.txt` (phone);
  - the first 11-log set (`cold_start_*`, `wake_*`);
  - `12-10-2026_20-52-26/40/53`, `21-13-23/40/56` and `full.log`;
  - `21-48-36/53`, `21-49-05` and `full.log`;
  - `22-36-41`, `23-35-26`, `23-36-57`;
  - the cold start set (`cold_start_off_*`, `cold_start_on_*`);
  - the wake set (`wake_off_*`, `wake_on_*`);
  - the final set (`cold_start_-_opcja_w__czona_randomowa_aplikacja_na_wierzchu_przed_restartem.txt`, `Wake_-opcja_w__czona_randomowa_aplikacja_na_wierzchu.log`, `Wake_-opcja_wy__czona_randomowa_aplikacja_na_wierzchu.log`, `Wake_-opcja_wy__czona_launcher_na_wierzchu_u_pienie.log`).
- FYT and com.syu identifiers: `FinalMain.U_ACC_ON=50`, `U_BLACK_SCREEN=3`, `U_MCU_ON=1`, `U_STANDBY=2`, `U_ARM_SLEEP_WAKEUP=43`; the BSP module 0 with `U_BUTTON_EVENT=2` via system service "syu"; com.syu.ms log tag "Qin" (`MCU OFF sTopAppWhenMcuOff`).

## Summary by label
- Confirmed: 66, Historical: 15, Suggestion: 2, Unverified: 8