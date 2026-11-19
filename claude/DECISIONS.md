# Decisions

Important technical and product decisions. Last consolidated on 2026-11-12 from the code, git, the briefs
(`prompts/archive/`), the 15 chat reports (`chat_archive/CHAT_01.MD` … `CHAT_15.MD`) and the owner's answers
of that day. D-52 … D-57 were added on 2026-11-13 with round 13, D-58 … D-63 on 2026-11-15 with round 14,
D-64 and D-65 on 2026-11-16 with round 15, D-66 with round 16, D-67 with round 19, D-68 … D-74 with round 22
(2026-11-18/19).

## How to read this file

**Status of a decision:**

- **ACTIVE**: in force, and the code follows it.
- **SUPERSEDED**: replaced by a later decision, which the entry names. Kept for the reasoning.
- **REJECTED**: proposed or tried, then turned down or reverted. Do not bring it back without asking.
- **UNDER_REVIEW**: implemented or proposed, but not confirmed by the owner or on a device.

**Who decided** matters as much as the status:

- *Owner* means the owner chose it, in a chat or through a brief. Do not undo it without asking.
- *Assistant* means a Claude session chose it while implementing and nobody objected. It can be revisited
  with a reason.

**Evidence tags:** [V] the code or a commit shows it · [H] a brief or a chat report states it · [U] unknown.
Where no reason was recorded the entry says so. Do not invent one.

Sources are written as `CHAT_nn` (a report in `chat_archive/`), a brief's date (a file in
`prompts/archive/`), a commit hash, or a file.

Add new entries at the end with the next number. Never delete an entry; change its status and name the
entry that replaces it.

## Index

| ID | Decision | Status | By |
|---|---|---|---|
| D-01 | Two flavors from one codebase | ACTIVE | Owner |
| D-02 | Public AOSP test key committed | ACTIVE | Owner |
| D-03 | Platform by chipset, media by package | ACTIVE | Owner |
| D-04 | Panes through own virtual displays and a VD host | ACTIVE | Owner / Assistant |
| D-05 | What the standard flavor does not get through the host | ACTIVE | Owner (brief) |
| D-06 | Logcat: build-type defaults, never forced | ACTIVE | Owner |
| D-07 | StrictMode in release builds | ACTIVE | Owner |
| D-08 | The launcher handles `uiMode`; panes survive a recreation | ACTIVE | Owner (brief) |
| D-09 | Preference keys keep their stored values | ACTIVE | Owner (brief) |
| D-10 | Strings in all 59 languages | ACTIVE | Owner |
| D-11 | FYT firmware code fails soft | ACTIVE | Owner (brief) |
| D-12 | CAN bus: one library, requests only where needed | ACTIVE | Owner (brief) |
| D-13 | The fuel estimate is a fallback | ACTIVE | Owner (brief) |
| D-14 | `com.syu.media` is never forced | ACTIVE | Owner (brief) |
| D-15 | Framework warnings that are not fixed | ACTIVE | Owner (brief) |
| D-16 | The stats window is only moved by the bars | ACTIVE | Owner |
| D-17 | Rules R1–R3 | ACTIVE | Assistant (brief), owner asked for lasting fixes |
| D-18 | Bars at either side; the handle catches only the swipe | ACTIVE | Owner |
| D-19 | Location: the platform first | ACTIVE | Owner |
| D-20 | Night brightness floor only on the 7870 | ACTIVE | Owner |
| D-21 | The launcher compiles itself with its Baseline Profile | ACTIVE | Owner |
| D-22 | The updater downloads its own flavor's asset | ACTIVE | Owner |
| D-23 | Google Maps' minimal UI is solved outside the launcher | ACTIVE | Owner |
| D-24 | Reverted changes (table) | REJECTED | Owner |
| D-25 | Development process | ACTIVE | Owner |
| D-26 | The OpenWeather key stays hardcoded | ACTIVE | Owner |
| D-27 | Wake and sleep from every signal, for the whole process | ACTIVE | Assistant, on the owner's request |
| D-28 | Home screen in front: only against what the device opens | ACTIVE | Owner |
| D-29 | The launcher never overwrites the system's navigation app | ACTIVE | Owner (requirement) |
| D-30 | Last app comes back when "home screen on top" is off | ACTIVE | Owner |
| D-31 | Sound channel: a tap is told from an app that came up by itself | ACTIVE | Owner (requirement) / Assistant |
| D-32 | Stock sources are overlays; the launcher never starts the stock player | ACTIVE | Owner (brief) |
| D-33 | Music favorites: each player's own way | ACTIVE | Owner / Assistant |
| D-34 | Pinned PiP on FYT: mode 6 up to Android 10, the waits stay | ACTIVE | Owner / Assistant |
| D-35 | Review scope and intentional behaviours | ACTIVE | Owner |
| D-36 | `Launcher.java` split into helpers, then stopped | ACTIVE | Owner |
| D-37 | The Magisk module version stays 1.0.0 | ACTIVE | Owner |
| D-38 | Never do arithmetic on `R.*` ids | ACTIVE | Assistant |
| D-39 | Exported components: validated, not closed | ACTIVE | Assistant |
| D-40 | Left bar capacity from the visible icon | ACTIVE | Owner (brief) |
| D-41 | Date widget fitted to its box | ACTIVE | Assistant |
| D-42 | Screen numbers, overlaps, Spotify sign-in (round 2026-11-04) | ACTIVE | Owner (brief) |
| D-43 | Repository layout: `claude/` and `archive/` | ACTIVE | Owner |
| D-44 | Focus overlay for the keyboard beside the pinned PiP | ACTIVE | Assistant; confirmed by the owner |
| D-45 | Pinned PiP only on units with `com.syu.music` | SUPERSEDED by D-03 | Owner (brief) |
| D-46 | New strings in English only | SUPERSEDED by D-10 | Owner (brief) |
| D-47 | Date widget with AppCompat autosize | SUPERSEDED by D-41 | Owner (brief) |
| D-48 | Fixed 45 s workspace-load watchdog | SUPERSEDED by D-17 (R1) | Assistant |
| D-49 | Rejected proposals (table) | REJECTED | Owner |
| D-50 | History before 1.2.1 is not reconstructed | ACTIVE | Owner |
| D-51 | Room and Compose are not planned | ACTIVE | Owner |
| D-52 | The grid of a page is the area the bars leave; rows and columns can be set | ACTIVE | Owner |
| D-53 | The wallpaper from one source with fallbacks; a host errand without a new module version | ACTIVE | Owner |
| D-54 | Text and button colour: any colour, or "Default" | ACTIVE | Owner |
| D-55 | One background choice for the fuel stats window | ACTIVE | Owner |
| D-56 | "Home screen layout" on the second settings screen | ACTIVE | Owner |
| D-57 | Choices the assistant made in round 13 (table) | UNDER_REVIEW | Assistant |
| D-58 | "Pick wallpaper" opens the wallpaper picker of the settings | ACTIVE | Owner |
| D-59 | Night mode without a saved picture leaves the wallpaper | ACTIVE | Owner |
| D-60 | Android 16: the host reads the wallpaper before any all-files access | ACTIVE | Owner |
| D-61 | The vertical bar is as wide as the launcher counts it | ACTIVE | Owner |
| D-62 | The scope of round 14 in `KNOWN_ISSUES.md` | ACTIVE | Owner |
| D-63 | Choices the assistant made in round 14 (table) | UNDER_REVIEW | Assistant |
| D-64 | The bars' windows are panels of the launcher's window, under every floating button | ACTIVE | Owner (requirement) / Assistant |
| D-65 | Icons and widgets may lie under the statistics window | ACTIVE | Owner |
| D-66 | A widget that cannot be shown shows its preview, and its app is told to update it | ACTIVE | Owner |
| D-67 | A bar on every page stands still: one window, no swap while the pages move | ACTIVE | Owner (requirement) / Assistant |
| D-68 | Robolectric for the tests of views | ACTIVE | Owner |
| D-69 | The statistics window on the home screen lies under the bars, over the panes | ACTIVE | Owner (requirement) / Assistant |
| D-70 | The vertical bar's width may be set, 4–10 % of the longer edge | ACTIVE | Owner |
| D-71 | The number of app icons on each bar may be set | ACTIVE | Owner |
| D-72 | "Transparent status bar" in "Home screen layout" | ACTIVE | Owner |
| D-73 | The settings list keeps its place; the guides lie below the app bar | ACTIVE | Owner |
| D-74 | Choices the assistant made in round 22 (table) | UNDER_REVIEW | Assistant |

---

## Product and platform

### D-01 Two flavors from one codebase: `system` and `standard`
- **Status:** ACTIVE. **By:** owner.
- **Decision:** `system` declares `sharedUserId="android.uid.system"` (uid 1000); `standard` is a normal app.
  Only the manifests differ.
- **Naming history [V]:** the flavors were `fyt` and `phone` (Gradle flavors since 2026-09-01). `phone` became
  `standard` in `192fea4c` (2026-10-17) and `fyt` became `system` in `e2086527` (2026-11-05). Chat reports
  before those dates use the old names and tasks such as `installFytDebug`.
- **Context:** Android installs a uid-1000 app only where the firmware's platform key signed it. FYT firmware
  uses the public AOSP test key, and some units and custom ROMs do not.
- **Consequences:**
  - Both APKs are the same package, so switching between them needs an uninstall that wipes the data.
  - Every privileged feature must degrade without privileges. Nothing may crash when the launcher runs as a
    plain user app (owner rule, CHAT_05).
- **Source:** `app/build.gradle.kts`, `README.MD` [V][H].

### D-02 Signed with the public AOSP test key, committed to the repository
- **Status:** ACTIVE. **By:** owner.
- **Decision:** `app/keystore.jks` (alias and password `android`) and `keystore.properties` are committed
  (`7d1d9ee8`, "Public android keystore", 2026-08-27).
- **Reasoning:** the `system` flavor must carry the firmware's platform key, which is the public AOSP test
  key [H] (README). Making it public lets anyone build an installable APK.
- **Consequences:** anyone can sign an APK that installs over the launcher on such firmware. This is
  inherent to the platform key, not a leak. See `KNOWN_ISSUES.md` KI-02.

### D-03 Platform by chipset, media by package; pinned PiP everywhere on FYT except the 7870
- **Status:** ACTIVE. **By:** owner. **Replaces:** D-45.
- **Decision:**
  - The FYT platform comes from the chipset, once, and is remembered (`DeviceIdentity`, `FytPlatform`). The
    main source is `ro.fyt.platform` (6318 = 7870, 6315 = 7862, 6316 = 8581, 6521 = 9853i).
  - The following are decided **by chipset**: being FYT, pinned PiP, the 7870's minimum night brightness,
    and the device line in the settings.
  - Everything about music sources stays **by package** (`StockSources.isSyuMediaUnit()`, `com.syu.music`
    installed).
  - Pinned PiP is unavailable only on the 7870 and on non-FYT devices (`84d8a3ed`, `681b5c74`).
- **Alternatives rejected:** the owner's `CompleteFytDetector` draft. It checked the chipset before the FYT
  markers, so Teyes CC3 and T618 tablets would have been taken for a 7862. It also used `toLowerCase()`
  without `Locale.ROOT`, its own reflection, unconfirmed properties (`ro.fyt.version`, `ro.syu.version`) and
  Polish names in code.
- **Also:** the Android version comes from `SDK_INT`, never from `RELEASE`, because the 7862's UI and
  build.prop can be faked to show 13/14.
- **Source:** brief 2026-10-28 device-identity; CHAT_11 [H][V].

### D-04 PiP panes through own virtual displays and a VD host, not by patching the system
- **Status:** ACTIVE. **By:** owner (direction), assistant (design).
- **Decision:**
  - Android 8–10 as a system app: the framework's hidden ActivityView.
  - Otherwise: the launcher's own VirtualDisplays rendered into SurfaceViews, created by a VD host with
    signature permissions. The hosts, in order: the launcher itself as uid 1000, the FYT VDHost Magisk daemon
    (uid 1000), or Shizuku (uid 2000).
  - Panes wait up to 15 s for a host that has not attached yet, instead of starting their apps without a
    display (`fee2455`, CHAT_05; later `HostAwait`, `d366d3be`).
- **Context:** Android 12 removed `reparentDisplayContent` and ActivityView. Android 11's version lacks what
  the launcher uses.
- **Alternatives rejected:** patching `system_server` or using LSPosed ("No system_server patching and no
  LSPosed are involved"); embedding the pane host in the launcher's own window (D-49).
- **Consequences:**
  - Shizuku cannot show `FLAG_SECURE` content.
  - Panes need a host; a pane without one stays empty instead of crashing.
  - The host protocol is versioned (now 3, minimum 2).
- **Source:** `vdhost/README.md`, CHAT_05 [V][H].

### D-05 What the standard flavor does not get through the host, on purpose
- **Status:** ACTIVE. **By:** owner, through the brief.
- **Decision:** the host grants the overlay, notification access, unknown-apps install and WRITE_SETTINGS
  permissions. It does **not** do the following:
  - the status-bar swipe area (it needs a system window type in the launcher's own process);
  - the input monitor (it would need a monitor in the host and event forwarding);
  - FYT skins in the standard flavor (possible without permissions but risky for AppCompat inflation;
    **needs its own brief**);
  - the host-side Spotify and foreground-task checks (little to gain).
- **Also [H]:** `music.db` of `com.syu.music` is not reachable through Shizuku, because neither the shell
  uid nor its SELinux domain may read another app's private data (reasoned in CHAT_05, not tested).
- **Source:** brief 2026-11-05 media C9, `README.MD`.

### D-20 Night brightness floor only on the 7870
- **Status:** ACTIVE. **By:** owner.
- **Decision:** the 7862 may go to brightness 0. The 7870 can switch its backlight off at level 0, so it has
  a floor of 10, decided by chipset (`85f36a7d`, then `681b5c74`; `DayNightBrightness`).
- **Source:** briefs 2026-10-27 music-widget D3 and 2026-10-28 device-identity D2 [H][V].

### D-23 Google Maps' minimal UI in pinned PiP is solved outside the launcher
- **Status:** ACTIVE. **By:** owner.
- **Decision:** the only reliable fix the owner found needs root, LSPosed and a separate module
  (`Full-Interface-PiP`). The launcher's window panes avoid the problem.
- **Source:** `README.MD` [H].

### D-28 Home screen in front: only against what the device opens, never the user
- **Status:** ACTIVE. **By:** owner. The owner rejected three earlier designs (see below).
- **Decision (`HomeFrontGuard`):** with a "home screen on top" option on, the launcher sends an app back only
  when it can name it as the device's own:
  - the app `com.syu.ms` noted when the MCU went off (the launcher takes the same snapshot at the
    `U_MCU_ON` 0 callback);
  - a pane app the launcher itself just stopped, for 3 s.
- **Rules the owner set [H]:**
  - Never pull back an app the user opened, including `com.syu.*` apps, at a wake or at a cold start.
  - No app is special-cased: "Mogłem zostawić dosłownie każdą inną aplikację."
  - No time window in which "any app" goes back: "4s wystarczą żeby użytkownik uruchomił celowo inną apke".
  - Design for firmware where `com.syu.ms` really reopens its noted app, even though the owner's unit
    does not.
- **How it is done [V]:**
  - User input is noted in `dispatchTouchEvent`/`dispatchKeyEvent`, not `onUserInteraction` (Android calls
    that whenever an activity starts over the launcher).
  - What is in front is read from the task stack (`DefaultDisplayTask`), not from the lifecycle, because the
    main thread stalls about 2 s after a wake.
  - A cover goes back behind what was in front before it.
  - At sleep the launcher comes to the top 300 ms after ACC off, before `com.syu.ms` notes its "top app"
    0.8–1.0 s after it. That note is then empty and nothing is reopened at the wake.
  - Protected (never sent back): system screens, phone and call apps, `com.syu.ms`, `vasyl.fytrating`,
    cameras and the reversing view.
- **Rejected on the way:** a 4 s "anything goes back" window; a cold-boot "any app" window (it sent back an
  app the owner started with adb); a list of apps protected "unless expected" (carlink, canbus, bt …); a
  blind home press 500 ms after the wake (it covered the owner's canbus page).
- **Open:** the path where `com.syu.ms` actually reopens an app was never triggered on a device after the
  final version (`KNOWN_ISSUES.md` KI-25).
- **Source:** CHAT_04; commits `ffba656` … `10c9b3b` [H][V].

### D-29 The launcher never overwrites the system's navigation app
- **Status:** ACTIVE. **By:** owner (requirement), assistant (fix).
- **Decision:** the launcher writes no navigation package. On FYT it uses the package `com.syu.ms` reports
  (`FinalMain.U_NAVI_PACKAGE`), else it lets the system open its own (`C_JUMP_PAGE`). `setDefaultNavi()` and
  `FytPackage.setDefaultNavigationPackage()` are gone (`44833aa0`).
- **Context:** the navigation app was reset to Google Maps at every cold boot. The launcher guessed from a
  stale property and sent the guess to `com.syu.ms`.
- **Open:** not confirmed on a device in the conversation (KI-25).
- **Source:** CHAT_03 [H][V].

### D-30 The last app comes back when "home screen on top" is off
- **Status:** ACTIVE. **By:** owner.
- **Decision:**
  - Two independent settings: `launcher_home_wake` and `launcher_home_cold_start` (`36359b61`). The old
    `launcher_home` value is copied into both once, so nothing changes until the user chooses. This is a
    preference migration the owner asked for (an exception to D-09).
  - With an option off, the app that was in front before comes back: at a cold boot from the launcher's own
    record (`ColdStart.noteForegroundApp`), at a wake from what was in front at the sleep.
  - At a cold boot, `com.syu.*` and `com.fyt.*` apps always wait 5000 ms and are watched for 2000 ms; other
    apps the same only with `cold_start_last_app_delay`. At a wake there is no delay.
- **Reasoning:**
  - "tak jak wygląda to przy gołych ustawieniach systemowych" (owner).
  - The last app is recorded continuously, because the launcher receives nothing at power-off.
  - The 5 s wait exists because carlink crashes when its activity starts before `com.syu.ms` has started
    its service.
- **Rejected:** a 15 s watch ("15s to dużo, użytkownik w tym czasie sam mógłby ubić apkę"); a fixed 2500 ms
  delay for every app.
- **Source:** CHAT_03; commits `97633176`, `d40620bd`, `0329b002`, `fc343bfe`, `36359b61` [H][V].

### D-34 Pinned PiP on FYT: mode 6 up to Android 10, the waits stay
- **Status:** ACTIVE. **By:** owner (behaviour), assistant (mechanism).
- **Decision:**
  - Windowing mode 6 is FYT's pinned stack only up to Android 10; from Android 11 it is any multi-window
    task (`PinnedPipLaunch.WINDOWING_MODE_FYT_PINNED`).
  - The pages do not jump to the default screen when the pinned app dies because the launcher itself
    restarted it (owner: "Tak, wyłącz ten przeskok").
  - A swipe closes the pinned PiP at once; it opens as soon as the pages stop.
  - The 250 ms wait in `onPageEndMoving` and the 100 ms wait in `startPinnedPip` stay (owner: "to zostaw").
- **Source:** CHAT_10; briefs 2026-10-27 [H][V].

## Panes, bars and layout

### D-16 The stats window is only moved by the bars
- **Status:** ACTIVE. **By:** owner.
- **Decision:** the stats window lies above every element of the page. It is not an obstacle for the layout and
  is never resized; the bars move it into the room beside them (`StatsBarFit`, `f791b67e`). Since 2026-11-18 it
  lies under the bars themselves and over the panes on the home screen (D-69).
- **Rejected first design:** the brief first made it a fixed obstacle in `CustomLayoutResolver`. The owner
  corrected that ("to okno nie koliduje nigdy z pozostałymi elementami"), and the brief was amended
  (`7b920b51`).
- **Also [V]:** the window takes no touches (`FLAG_NOT_TOUCHABLE`, `1039775`; owner: "widokowi dotyk nie jest
  potrzebny", CHAT_02).
- **Source:** brief 2026-11-08, CHAT_14 [H].

### D-17 Rules R1–R3 (round 12, 2026-11-08)
- **Status:** ACTIVE. **By:** written by the planning session at the owner's request ("opisz naprawę tak aby
  podobne bugi nie zdarzały się w przyszłości"). **Replaces:** D-48 (R1).
- **R1:** the model owns the "loading" state. A stuck load is started again, and a skipped reload is not
  lost (`e3136f45`).
- **R2:** widget colors and backgrounds are view tints applied to what is on screen, never color filters on
  shared drawables (`b1fe254c`).
- **R3:** one overlap rule, under which touching edges do not overlap; overlapping elements are moved, then
  cut, then reset (`3dd71894`). Touching a bar is still a collision.
- These rules are written in the Javadoc of the classes that enforce them.
- **Device result [H]:** the owner, 2026-11-12: "It works as intended."
- **Source:** brief 2026-11-08, CHAT_14, CHAT_15 [H][V].

### D-18 Bars at either side; the handle catches only the opening swipe
- **Status:** ACTIVE. **By:** owner.
- **Decision:**
  - "bottom bar"/"left bar" became horizontal/vertical bar (`d0e67aaf`). The horizontal bar goes at the top
    or bottom, the vertical bar left or right, either can be on every page, and the auto-hide handle goes on
    either edge (`9bc0faa5`, `5604d116`, `6080ce99`).
  - In the handle's area only the inward swipe is caught; a click and everything else pass to what is below
    ("przechodzi tylko click i cała reszta"). On system units with Android 10+ this is an input monitor
    (`4b63a077`). A first design let a tap on the strip open the bar; the owner rejected it.
  - The collapsed bar's button shows only where the vertical bar and the handle are on the same side;
    otherwise the vertical bar runs the full height.
  - The horizontal bar is always drawn above the vertical bar, and the creator shows the bars as the home
    screen does. There is one creator for every page (`76c1c110`).
- **Source:** briefs 2026-11-07/08, CHAT_14, CHAT_15 [H][V].

### D-40 Left (vertical) bar capacity from the visible icon
- **Status:** ACTIVE. **By:** owner, through the brief.
- **Decision:** the number of slots is counted from the visible icon, with one pitch for both orientations,
  so the bar looks in landscape as it does in portrait on a phone (`219c47eb`). The capacity is stored under
  new keys (`left_bar_capacity_port_v2`, `…_land_v2`), so the old value does not flash at the first start.
- **Kept on purpose:** the horizontal bar, `LEFT_MEMORY = 12`, `MIN_LEFT_SLOTS = 5`.
- **Source:** brief 2026-11-01, CHAT_09 [H][V].

### D-41 Date widget fitted to its box
- **Status:** ACTIVE. **By:** assistant, after the owner's bug report. **Replaces:** D-47.
- **Decision:** `BoxTextFit` sets the text size from the parent's real width and height; three equal spacers
  give equal gaps (`3eb7798`).
- **Open:** no device confirmation in the conversation (KI-25).
- **Source:** CHAT_13 [H][V].

### D-42 Screen numbers, overlaps and the Spotify sign-in (round 2026-11-04)
- **Status:** ACTIVE. **By:** owner, through the brief.
- **Decision:**
  - Typing a screen number past the last page always gives the number of existing screens + 1. A switched-off
    element does not create a screen (`ScreenNumberRule`, `a2a180c`).
  - Overlapping elements on any page are fitted as the bars fit them; widgets give way to PiPs (`1c32b4d`,
    refined by R3 in D-17).
  - Spotify sign-in: only a hardened browser start and a log line. "Żadnych nowych toastów, dialogów ani
    innych widocznych promptów." (`1ace149`)
- **Source:** brief 2026-11-04, CHAT_12 [H][V].

### D-44 A focus overlay gives the launcher the keyboard beside the pinned PiP
- **Status:** ACTIVE. **By:** assistant; confirmed by the owner on 2026-11-12 ("Works and it is
  acceptable"). It was UNDER_REVIEW until then, because the session that wrote it could not test it.
- **Decision:** while FYT's pinned PiP is shown, a touch on the launcher adds a 1×1 overlay window that takes
  the input focus and proxies the keyboard to the launcher's text field (`PinnedPipFocus`, `d9fc21d`).
- **Context:** the pinned stack is always the top, focusable stack, so the launcher could not get the
  keyboard (folder rename), and the PiP app's keyboard closed only by a tap in the PiP or Back.
- **Consequence, accepted by the owner:** after a touch on the launcher, Back goes to the launcher, not to
  the PiP app.
- **Alternatives considered (assistant only):** hiding the PiP while editing; an overlay text field;
  injecting Back.
- **Source:** CHAT_08 [H][V]; `KNOWN_ISSUES.md` KI-22.

## Media

### D-14 `com.syu.media` is never forced
- **Status:** ACTIVE. **By:** owner, through the brief.
- **Decision:**
  - No force-stop, kill or write to its private database.
  - Favorites go through its library.
  - FM favorites are read-only for other apps, so the widget's FM heart is greyed out (`608ff0a8`).
- **Source:** brief 2026-11-05 media §4 [H].

### D-31 Sound channel: a tapped app is told from one that came up by itself
- **Status:** ACTIVE. **By:** owner (requirement), assistant (mechanism).
- **Decision:**
  - `com.syu.ms` switches the MCU sound channel when a known media app comes to the top or starts audio
    (channels: 1 radio, 3 Bluetooth, 8 FYT music, 10 third party; on the 7870 also 7 internet radio). When
    panes start their apps, the launcher restores the channel that was playing, unless the user tapped
    something.
  - Taps are seen through a system-wide input monitor (`UserTouches`, hidden
    `InputManager.monitorGestureInput()`), because on Android 10 a tap on a pane goes straight to the
    virtual display and the launcher's views never see it (`a5d559e`).
  - Without the monitor the launcher falls back to the earlier behaviour.
  - BACK out of `com.syu.music` counts as the user's stop: its channel is not restored (`2e4e77f`).
- **Requirement [H]:** "Trzeba to rozróżnić czy apka wychodzi na wierzch sama czy użytkownic dotknął UI".
- **Rejected:** touch wrappers on the pane roots (they saw nothing on Android 10 and paused a Spotify the
  user had started).
- **Source:** CHAT_02, CHAT_05; commits `0a71296`, `a5d559e`, `ace0d32`, `2e4e77f` [H][V].

### D-32 Stock sources are overlays; the launcher never starts the stock player
- **Status:** ACTIVE. **By:** owner, through a brief that is not in the repository (see
  `prompts/README.md`, "Briefs outside the catalogue").
- **Decision:**
  - The radio (both unit families) and Bluetooth audio (7870) are overlays with their own state. They never
    write `MusicService` fields, because `com.syu.music` sends one last "stopped" update after losing the
    channel, which would overwrite the station.
  - The `com.syu.music` path on 7862/8581 behaves exactly as before; everything new is gated by
    `StockSources.isSyuMediaUnit()` or the overlay.
  - `com.syu.media`'s services are bound without `BIND_AUTO_CREATE`: the launcher must not start the player.
    Play, pause, next and previous go through its `IPlayer` binder (`c2a6245`), because its media session
    takes no media keys for music.
  - A stock player cannot take the widget from the radio or Bluetooth while the MCU is on their channel, and
    a takeover waits 1.5 s after a channel change (`StockKindArbiter`, `PLAYER_SETTLE_MS`; assistant's
    review fixes).
- **Source:** CHAT_05, CHAT_06; the session note
  `prompts/archive/analysis/memory-2026-10-26-stock-sources-7870.md`; commits `ded0e6ef`, `d5030a6e`,
  `4ad0bed2` [H][V].

### D-33 Music favorites: each player's own way
- **Status:** ACTIVE. **By:** owner (choice of option), assistant (mechanism).
- **Decision:**
  - YT Music: the like state is read and toggled through the session's own like action, and told by the
    icon's resource name (`yt_fill` / `yt_outline`), so it works in any language (`4a31ec4`, `6e75090`). The
    owner chose this over a patch that publishes the video id, which stays as the fallback.
  - `com.syu.music`: its `music.db` is opened directly with system privileges, else through root, else not at
    all (`SyuMusicLibrary`, `2e4e77f`).
  - YouTube: through the separate fYT Rating app; Spotify: through the Web API (`ARCHITECTURE.md` §8).
  - With no cover the player's app icon is shown; with no session any widget button opens the last player,
    except for `com.syu.music` (`5a6d4d4`).
- **Not done [H]:** resuming the last track in the background after a restart ("cannot be done universally").
- **Source:** CHAT_05 [H][V].

## CAN bus and fuel

### D-12 CAN bus: one library, requests only where needed, the user's code wins
- **Status:** ACTIVE. **By:** owner, through the briefs.
- **Decision:**
  - The canbus library is the only list of cars' classes (`75d41dff`). carinfo screens are out of the
    build and kept as reference (`1ff27146`).
  - A request is sent only for cars that need one (`34f764a6`). The command logger was dropped (`9a05cfce`).
  - The 7870 has a library and callbacks of its own (`4721980e`).
  - Code precedence: the code the user typed, then the library's working pair, then the automatic check's
    guess.
  - The reader never sends the car random commands.
- **Source:** CAN briefs 2026-10-28 to 2026-11-05, `README.MD` [H].

### D-13 The fuel estimate is a fallback, never a replacement
- **Status:** ACTIVE. **By:** owner, through the briefs.
- **Decision:** the estimate is shown (marked `≈`) only where the car gives no value. It is learned from the
  car's own values and never offered for a car without a fuel code. Model v3 is power-based (`8b51f33a`).
  The car's mass and engine size are optional settings.
- **Source:** fuel briefs 2026-10-30/31, `README.MD` [H].

## Night mode, weather, location

### D-08 The launcher handles `uiMode` itself; panes survive a recreation
- **Status:** ACTIVE. **By:** owner, through the briefs.
- **Decision:**
  - The launcher declares `uiMode`, so a change of the lights or the night mode does not recreate it
    (`2148c52c`).
  - If it is recreated anyway (e.g. by the theme overlay Android 12+ builds after a new wallpaper), the
    panes' displays are handed over to the new activity (`502464e7`).
  - The wallpaper is set only when it really changed.
  - The launcher's night mode changes the wallpaper and brightness, **not** the system dark mode.
- **Deferred:** pinning day/night mode to the PiP displays (`ROADMAP.md` P-6).
- **Source:** briefs 2026-10-27 and 2026-11-05, `README.MD` [H].

### D-19 Location: the platform first, Play services only as a way out
- **Status:** ACTIVE. **By:** owner.
- **Decision:** location uses the platform providers; Google Play services is loaded only when the platform
  has no fix and Play services is installed (`620fd619`; `DeviceLocation`, `GmsLocation`, `LocationChoice`).
- **Reasoning [H]:** ART logged "failed lock verification" for Play services classes in the debug build.
  The owner first answered "load gms only where Google Play is installed", then chose "Platforma najpierw,
  gms tylko awaryjnie", because the 7862 has Play services and the first option would have changed nothing
  there.
- **Kept:** the `play-services-location` dependency, as the fallback.
- **Source:** CHAT_11 [H][V]. (The 2026-11-10 version of this entry said "reason not recorded".)

### D-26 The OpenWeather key stays hardcoded
- **Status:** ACTIVE. **By:** owner, stated twice.
- **Decision:** the key stays as a constant in `WeatherManager`. It is redacted from the logs together with
  exact coordinates (`771f9387`, test `8cc9e48f`).
- **Reasoning [H]:** "OpenWeatherMap to darmowe narzędzie, klucz może dostać każdy, więc cofnij tę zmianę."
- **Rejected alternative:** moving the key to `BuildConfig`/`local.properties`. It was implemented and then
  fully reverted at the owner's request (CHAT_01).
- **History of this entry:** the 2026-11-10 audit did not know the decision. It listed the key as a
  high-priority security issue and recommended rotating it. That recommendation is withdrawn
  (`KNOWN_ISSUES.md` KI-01, `ROADMAP.md` R-1).
- **Source:** CHAT_01, CHAT_02 [H]; the constant is in the code [V].
- **Since 2026-11-15 [V]:** a user may enter a key of their own (KI-01, opened again by the owner); the
  built-in key stays as decided (`8b76509c4`).

## Diagnostics and robustness

### D-06 Logcat captures: build-type defaults, never forced
- **Status:** ACTIVE. **By:** owner.
- **Decision:**
  - Logcat settings are off by default in release and on in debug, and changeable in both (`2b70e8f4`).
  - File names say what started the capture and what it holds (`reboot_full_…`, `d5d6cb73`).
- **Rejected:** forcing every capture on in debug builds (`66961f21`, reverted by `735e308b`; D-24).
- **Source:** brief 2026-10-27 pinned-logcat [H].

### D-07 StrictMode in release builds too
- **Status:** ACTIVE. **By:** owner.
- **Decision:** StrictMode runs in release, and its lines go into the launcher's own captures (`5bb6e2d7`).
  The main thread may do no I/O, database, `ContentResolver`, network, `su` or blocking host calls.
- **Source:** the pinned-logcat brief; every brief since; `CLAUDE.md` [H].

### D-11 FYT firmware code fails soft
- **Status:** ACTIVE. **By:** owner, through the briefs.
- **Decision:** code written against FYT firmware (the `com.syu.ms` callbacks, CAN modules, radio and music
  sources) runs behind `FytCompat`. A `RuntimeException`/`LinkageError` is logged and reported once
  (`compat_pid_…`), and the launcher goes on (`314897ef`).
- **Also:** three crashes within two minutes trigger a safe start (`CrashLoopGuard`, `66e2ce1a`).
- **Source:** briefs 2026-11-03 and 2026-11-05 [V][H].

### D-15 Framework warnings that are not fixed
- **Status:** ACTIVE. **By:** owner, through the brief.
- **Decision:** `Parcel: Expecting binder but got null!` and `SurfaceSyncer: Failed to find sync` are
  Android 13 framework warnings. Their code stays as it is. The same held for the wallpaper
  `SecurityException` on Android 16 (missing `READ_EXTERNAL_STORAGE`; the colors fall back): "to nie błąd"
  (brief 2026-11-08, CHAT_15).
- **Changed 2026-11-13:** the wallpaper part is superseded by D-53. The owner reported the same exception
  as an error toast from "Save the day wallpaper", a path with no fallback. The two framework warnings stay.
- **Source:** `vdhost/README.md`, brief 2026-11-05 media C3 [H].

### D-27 Wake and sleep from every signal, for the whole process
- **Status:** ACTIVE. **By:** assistant, on the owner's request for "every known method" and a reliable
  signal.
- **Decision:**
  - `WakeSignals` merges ACC from `com.syu.ms` (`U_ACC_ON`), the display state, screen broadcasts, unlock,
    dream, a poll, CPU suspend and a restart into one state. Whichever reports first switches it.
  - FYT's black screen (`U_BLACK_SCREEN`) is neither a sleep nor a wake (owner's requirement).
  - `WakeDetection` lives as long as the process; `WakeDetectionService` is only an anchor. Before, the
    service died with the activity and the next wakes went unhandled.
- **Context [H]:** `Intent.ACTION_SCREEN_ON` does not work on FYT. ACC off comes about 1.2 s before the
  display goes off, and ACC on about 0.1 s before it comes back.
- **Source:** CHAT_03 (`d40620bd`), CHAT_04 (`ffba656`) [H][V].

### D-39 Exported components: validated, not closed
- **Status:** ACTIVE. **By:** assistant; committed by the owner (`eed91b73`).
- **Decision:**
  - `FileReceiver` stays exported, because the system file manager sends its broadcast, but accepts a file
    only under `/storage/`, `/mnt/` or `/sdcard/`.
  - `ServiceRestarter` is not exported; `NightModeService`'s receiver is not exported on API 33+.
  - A Spotify redirect without the expected `state` does not clear a pending sign-in.
- **Source:** CHAT_01 [H][V].

## Build, release and process

### D-09 Preference keys keep their stored values across renames
- **Status:** ACTIVE. **By:** owner, through the briefs.
- **Decision:** when the bars were renamed (`d0e67aaf`), the constants changed but the stored values did not
  (e.g. `HORIZONTAL_BAR_EVERY_PAGE = "bottom_bar_every_page"`). Users' settings are not migrated unless a
  brief or the owner says so.
- **Exceptions made so far:** `launcher_home` → two keys (D-30); the `_v2` capacity keys (D-40); the user
  rectangles `…UserLeft/Top/Right/Bottom` (brief 2026-11-02); the text colours and the stats background
  (D-54, D-55, asked for by the owner on 2026-11-12).
- **Source:** commit `d0e67aaf`, `app/src/main/java/com/android/launcher66/settings/Keys.java` [V].

### D-10 Strings in all 59 languages
- **Status:** ACTIVE. **By:** owner. **Replaces:** D-46.
- **Decision:** every new or changed string goes into all 59 `values*/strings.xml` files, translated
  (brief 2026-11-07 onwards).
- **Note [V]:** the translations are written by the implementing session, not by native speakers
  (`KNOWN_ISSUES.md` KI-23). The six regional override files hold only what differs from their base language,
  so an older key can be missing there without being an error.
- **Source:** briefs [H]; `git log` 2026-10-26 [V]; CHAT_12.

### D-21 The launcher compiles itself with its Baseline Profile
- **Status:** ACTIVE. **By:** owner.
- **Decision:** Android compiles a profile only during idle maintenance, which a head unit rarely reaches.
  `BaselineProfileCompiler` therefore compiles 90 s after a new APK starts, and again after 3, 14 and 30 days
  once there have been enough sessions. Debug builds are not compiled.
- **Source:** `README.MD`, `baselineProfile/README.md`, CHAT_05 [H].

### D-22 The updater downloads its own flavor's asset
- **Status:** ACTIVE. **By:** owner.
- **Decision:** from 1.2.2 the updater downloads `system_release_<v>.apk` or `standard_release_<v>.apk`.
  `release-assets.yml` adds `update<v>.apk` and `fyt_release_<v>.apk` copies for older updaters. A standard
  ("phone") 1.2.1 must be updated by hand once.
- **Source:** `README.MD`, workflow header [V].

### D-25 Development process
- **Status:** ACTIVE. **By:** owner.
- **Decision:** Opus writes briefs, Sonnet implements them, and the owner tests on devices.
  - One commit per step, with fixed English subjects.
  - Every commit must build; CI is the gate between commits; no amend or force-push.
  - No model names in repository content (the session's commit trailers are the exception).
  - Briefs and replies to the owner are in Polish; code, commits and these docs are in English.
  - Work happens on `testBranch` only.
- **History [V]:** the working branches were `main-6mxprj` (2026-10-05 → 10-09, merged through PRs #8–#26),
  `ccr-893cd285-tau8vs` (10-12), `ccr-087eed00-gbqsuz` (10-13 → 11-01, merged into `testBranch` on 11-01),
  and `testBranch` since. The owner's rule from the start: never undo the owner's own commits; update a
  stale branch by merging before pushing (CHAT_03).
- Since 2026-11-10 the briefs live in `claude/prompts/`, and the catalogue is updated together with each
  brief.
- **Source:** every brief §1; CHAT_03, CHAT_13, CHAT_14 [H].

### D-35 Review scope and intentional behaviours
- **Status:** ACTIVE. **By:** owner.
- **Decision:**
  - A code review skips `Callback_*.java` in `com/syu/module/canbus` and the folders `com/syu/canbus/warn`,
    `com/syu/carinfo` (now only under `archive/`) and `com/syu/ui`.
  - `VersionChecker.isNewerVersion` treats an equal version as newer in debug builds on purpose ("to
    celowe"): a debug build is offered the release of the same version.
- **Source:** CHAT_01, CHAT_02 [H]; `VersionChecker.java` [V].

### D-36 `Launcher.java` was split into helper classes, and the split stopped there
- **Status:** ACTIVE. **By:** owner.
- **Decision:** on 2026-10-06 ten helpers were moved out mechanically, members unchanged, with delegates
  left in `Launcher` (`LauncherWeather`, `HomeLayoutRecovery`, `LauncherWake`, `LauncherPipStarter`,
  `LauncherPermissionFlow`, `LauncherFab`, `LauncherAppBars`, `LauncherMusicWidget`, `LauncherRadioWidget`,
  `LauncherWallpaperPicker`). `Launcher.java` went from 13,236 to 9,080 lines. The owner then stopped:
  "zatrzymujemy się zatem na tym etapie".
- **Not done:** splitting the navigation receivers and the Launcher3 core.
- **Source:** CHAT_02; commits `e99f104` … `f65f856` [H][V].

### D-37 The Magisk module version stays 1.0.0
- **Status:** ACTIVE. **By:** owner.
- **Decision:** the FYT VDHost module keeps version 1.0.0; compatibility is expressed by the protocol number
  (`429ce279`).
- **Reason:** not recorded [U].
- **Source:** CHAT_05 (owner rule), commit `429ce279` [H][V].

### D-38 Never do arithmetic on `R.*` ids
- **Status:** ACTIVE. **By:** assistant, after a regression.
- **Decision:** `R.drawable.x + n` is forbidden; `ResourceIdArithmeticTest` scans the sources for it.
- **Context:** the resource clean-up removed `icon_bg1`, and `R.drawable.icon_bg + 1` then pointed at the
  next drawable by name, so every icon got a white plate with a cog (`ee9b303f`).
- **Source:** CHAT_11 [H][V].

### D-43 Repository layout: `claude/` for Claude's documents, `archive/` for reference material
- **Status:** ACTIVE. **By:** owner (2026-11-10 and 2026-11-12).
- **Decision:**
  - Everything for Claude lives in `claude/` (lower case); only a stub `CLAUDE.md` stays at the root.
  - Decompiled FYT apps, `fuel_stats_example/` and the old `android.jar` archives live under `archive/`
    (`8bfc5a8d`). `decompiled_FYT_jars/` was removed from the tree in the same commit; it remains in git
    history.
  - `android_jar/android-36.jar` stays at the root path, because two Gradle modules compile against it
    (`ee8e4f91`).
- **Source:** the owner's instructions and commits [V].

## Superseded decisions

### D-45 Pinned PiP only on units with `com.syu.music`
- **Status:** SUPERSEDED by D-03 (one day later). **By:** owner, through brief 2026-10-27 bar-pip E3.
- **Was:** pinned PiP offered only where `com.syu.music` is installed (`a2959497`).
- **Why replaced:** an installed package is a poor sign of the platform; the chipset is not.

### D-46 New strings in English only
- **Status:** SUPERSEDED by D-10. **By:** owner, through the briefs of 2026-10-28.
- **Was:** new keys only in `values/strings.xml`; translations untouched.

### D-47 Date widget text with AppCompat autosize
- **Status:** SUPERSEDED by D-41. **By:** owner, through brief 2026-11-02.
- **Was:** autosize in `absolute_time.xml` (`adf77fc`). On the device the last digit was cut and the lines
  sat against the edges, so it was replaced the same day.

### D-48 A fixed 45 s workspace-load watchdog
- **Status:** SUPERSEDED. **By:** assistant.
- **Was:** release the loading state after 45 s. The owner objected to guessing a duration, so it became an
  inactivity watchdog: 30 s without a bind step (`eed91b73`, CHAT_01). R1 in D-17 then made it restart a
  stuck load.

## Rejected and reverted

### D-24 Reverted changes
- **Status:** REJECTED (each was implemented, then reverted).

| Change | Revert | Reason |
|---|---|---|
| `66961f21` force every logcat capture on in debug builds | `735e308b` | owner decision (D-06) |
| `3a0217ea` "on the 7862 the stats' surface moves with the launcher's frame": direct surface moves through hidden Android 10 API | `b38f1286`, by the owner, 2026-10-28 | the owner, 2026-11-12: "It didn't work as it should. Reverted it to acceptable state." It was the third attempt to stop the stats window lagging behind the pages on the 7862, pushed untested (CHAT_10). The state after the revert is acceptable (KI-21) |
| `1586b84b` (external PR #5) "Harden Maps PiP window lifecycle" | `c94703fd` (2026-07-22) | "a defect in the application view resume lifecycle causes a new instance to be created instead of restoring the existing one" |
| OpenWeather key moved to `BuildConfig` (never committed) | reverted in the working tree | owner decision (D-26) |
| `5392230c2` a picture of the stats window moves with its page on Android ≤ 10 (KI-21, fourth attempt) | `fe72e5a6f`, 2026-11-15, at the owner's request | on the 7862 the stats window and every FAB vanished while the pages moved and came back only on page 0. The picture was made with `Bitmap.createBitmap(Picture)`; do not use that for the launcher's windows again |

### D-49 Rejected proposals
- **Status:** REJECTED. Do not implement these without asking the owner again.

| Proposal | Rejected by | Reason | Source |
|---|---|---|---|
| A night-mode choice for parking lights | owner ("Zostawiamy jak jest.") | the unit receives one light signal only (`U_LAMPLET` 0/1), the same for parking lights and low beam | CHAT_02 |
| Keep the last weather across restarts | owner | not given | CHAT_02 |
| Embed the pane host (ActivityView / virtual display) in the launcher's own window | owner ("Takiej zmiany nie wprowadzaj") | not preserved | CHAT_10 |
| Remove the 250 ms and 100 ms pinned-PiP waits | owner | deliberate waits | CHAT_10 |
| Further tuning of pane movement on the A55 and the 7862 | owner | acceptable as it is; only the 7862 stats window needed work | CHAT_10 |
| A tap on the handle's strip opens the bar (system units, Android 10+) | owner | only the swipe is caught | CHAT_14 |
| "Proceed and reset" in the creator's overlap dialog | owner | it threw the drawn layout away; replaced by "Proceed and fit" (D-17 R3) | CHAT_14 |
| New toasts or dialogs for the Spotify sign-in | owner | hardening and a log line only | CHAT_12 |
| Change `VersionChecker.isNewerVersion` | owner | intentional (D-35) | CHAT_01 |
| Resume the last track in the background after a restart | not implemented | cannot be done for every player | CHAT_05 |
| Detect headlights from the CAN protocol | discussed only | the option was dropped with the parking-light idea | CHAT_02 |
| Parse logcat, `IActivityController` or usage events to attribute app starts | assistant | too invasive | CHAT_04 |
| Shizuku Next start-up fixes | deferred by the owner ("temat na później") | another project's code | CHAT_05 |
| A "stopped" state for the "Display media Titles" app | deferred by the owner | "zajmiemy się kiedy indziej" | CHAT_05 |

## Added on 2026-11-12

### D-50 History before 1.2.1 is not reconstructed
- **Status:** ACTIVE. **By:** owner, 2026-11-12.
- **Decision:** what each release before 1.2.1 added is not dug out of the commits: "too much digging as
  there are plenty of commits. We work on what we currently have."
- **Consequence:** the documents start from the current code and from 2026-10-05. Do not list the missing
  early history as a gap to fill.

### D-51 Room and Compose are not planned
- **Status:** ACTIVE. **By:** owner, 2026-11-12.
- **Decision:** neither is planned; they may be removed if unused. They are unused (`KNOWN_ISSUES.md` KI-03).
- **Next:** `ROADMAP.md` P-12.

## Added on 2026-11-13 (round 13: the owner's 19 tasks)

The round had no brief: the owner's request and the audit written for it are in
`reports/audit_blueprint_2026-11-12.md`, the result in `reports/implementation_report_2026-11-13.md`.

### D-52 The grid of a page is the area the bars leave
- **Status:** ACTIVE. **By:** owner, 2026-11-12 (chosen from three models: "Usable-area grid").
- **Decision:** a bar that stays on a page takes its strip out of the page. A page with the vertical bar has
  one column fewer, a page with a horizontal bar that does not hide one row fewer, and the cells are spread
  evenly over what is left. The size of an icon does not change. An item whose row or column is gone is
  moved to a free cell, never deleted.
- **Also the owner's:** the rows and columns can be set from two below to four above the grid the launcher
  had (10 × 6), and an update changes nobody's grid.
- **Where:** `WorkspaceGrid`, `GridOverflow` (their Javadoc holds the rules), commits `405793b42`,
  `c96a8fd8a`, `ca27a7637`.

### D-53 The wallpaper is read from one source with fallbacks, and the host gets an errand for it
- **Status:** ACTIVE. **By:** owner, 2026-11-12. **Replaces:** the wallpaper sentence of D-15.
- **Decision:** the home screen's wallpaper (never the lock screen's) is read through the system's API where
  that gives the real picture, else through the privileged host, else not at all: the selectors then show
  the colours, and saving the day or night wallpaper offers to pick an image. `READ_EXTERNAL_STORAGE` is
  requested only below Android 13; access to all files is not requested.
- **The host:** "Add a host errand - but don't change the version of the Magisk module host (current one has
  never been officially published)". So `readHomeWallpaper` is a new transaction with the protocol number
  and the module version unchanged (D-37 holds); a host without it answers nothing.
- **Where:** `HomeWallpaperSource`, `WallpaperAccess`, `HostServices.readHomeWallpaper`; `b5b4ffb54`,
  `78f037578`.

### D-54 The text and button colour is any colour, or "Default"
- **Status:** ACTIVE. **By:** owner, 2026-11-12 ("Add a 'Default' action").
- **Decision:** "Widget text and button color" and the bar's are chosen in the colour picker. "Default"
  stores no colour: the views' own look, which is what "White" used to mean. The colour is still a tint of
  the view (D-17 R2).
- **Migration (asked for):** `black_widgets` / `black_bar` on become black under `widgets_tint_color` /
  `bar_tint_color`; off stores nothing. The old keys are removed. `7faf0d09b`.

### D-55 The fuel stats window has one background choice
- **Status:** ACTIVE. **By:** owner (task 4G of the request).
- **Decision:** seven rows became two: a background chooser like the widgets' (none, a picture, a colour of
  one's own with its transparency) and the text colour.
- **Migration (asked for):** from what the service really drew, so the window looks the same after the
  update; with nothing stored that is no background (`StatsBackgroundMigration`). `5deeff937`.

### D-56 Where the grid's settings and the icon text sizes are
- **Status:** ACTIVE. **By:** owner (task 17D of the request).
- **Decision:** a category above "Widgets" on the second settings screen holds the rows and columns, "Set
  the start page" (from "Bars") and the two icon text sizes (from "Miscellaneous" on the first screen).
- **Consequence [V]:** the second screen opens only while the user layout is on, so the text sizes and the
  grid can be changed only then (`KNOWN_ISSUES.md` KI-33). The category's name, "Home screen layout", is
  the assistant's.

### D-57 Choices the assistant made in round 13
- **Status:** UNDER_REVIEW. **By:** assistant; the owner asked for the round to be implemented with
  autonomous decisions and has not reviewed these. None is an owner decision.

| Choice | Why |
|---|---|
| `hotseat_bg` is drawn for the left edge: 0° at the left, 180° at the right; the other pictures 0° bottom, 180° top, 90° left, 270° right (`BackgroundAngle`) | the pictures' own direction |
| In the creator of the in-app stats window a double tap on the rectangle still saves; elsewhere it toggles the strip | the owner's wording asked that the strip can always be hidden |
| The floating button starts when the panes of the enabled button are set, as its service already required (`FabButtons`) | the launcher asked for all four panes, the service only for the button's own |
| Items are re-arranged only when the grid of the orientation in use changed, never by a turn of the screen | the items have one cell for both orientations |
| The app drawer and the folders keep their grid; only the home screen's pages follow the new setting | the task names the workspace |
| An auto-hide bar keeps no corner cell where its handle lies in the vertical bar's strip | the strip is no cell any more |
| The vertical bar takes a column only in the user layout | the built-in first page is not made of cells |
| The stats window rule was added as a guard beside `CanbusService`'s existing conditions, not as a rewrite | the 7862's daily behaviour runs through that code |
| Shizuku answers nothing to `readHomeWallpaper` | shell cannot open the wallpaper file; not tested |
| The fYT Rating app was not changed; the launcher wakes the bridge once and logs its reason | its source is not in this repository |
| StrictMode reports seen in the owner's log of 2026-11-09 were not fixed | outside the 19 tasks (`KNOWN_ISSUES.md` KI-31) |

## Added on 2026-11-15 (round 14: the owner's test of round 13 and of the 7862)

The round had no brief; its result is in `reports/implementation_report_2026-11-15.md`.

### D-58 "Pick wallpaper" opens the wallpaper picker of the settings
- **Status:** ACTIVE. **By:** owner, 2026-11-15 ("To samo co wiersz w Miscellaneous").
- **Decision:** the button in the background selector and the offer to pick a picture when the wallpaper
  cannot be read open what the "Wallpaper picker" row opens, following "Wallpaper picker source". The
  launcher's own gallery choice in those dialogs is gone.
- **Where:** `WallpaperPickerLauncher`, `deaaffe08`.

### D-59 Night mode without a saved picture leaves the wallpaper
- **Status:** ACTIVE. **By:** owner, 2026-11-15 ("Zostaw bieżącą tapetę").
- **Decision:** with "Use the default wallpapers" off and no saved (or no readable) picture for the day or
  the night, the night mode sets no wallpaper at all, on every device. With the switch on the built-in
  wallpaper is set as before.
- **Consequence [V]:** on the 7862 too the night mode no longer falls back to the built-in wallpaper. Two
  summary strings were replaced by new keys (D-10).
- **Where:** `NightWallpaperRule`, `44ed8f4cb`.

### D-60 Android 16: the host reads the wallpaper before any all-files access
- **Status:** ACTIVE. **By:** owner, 2026-11-15.
- **Decision:** where the launcher cannot read the wallpaper, the host asks the wallpaper service itself
  (same transaction, same module version, D-37). Granting the launcher access to all files is a later step,
  only if the A55 shows that the service refuses the shell. A wallpaper the launcher set itself is kept as a
  copy, valid while the system's wallpaper id is unchanged.
- **Where:** `WallpaperServiceCall`, `OwnWallpaperCopy`, `dfe91dc85`, `ed61469d0`.
- **Second step, 2026-11-15 [H]:** the service gave shell nothing on the A55; with "access to all files"
  given by hand the selectors showed the wallpaper. The owner: the launcher asks for it with its other
  permissions where it is missing. Since `932d61d1c` the permission flow has the step (Android 13+, not for a
  system launcher), granted through the host where there is one (`d167945ad`), else on the screen of
  Settings.

### D-61 The vertical bar is as wide as the launcher counts it
- **Status:** ACTIVE. **By:** owner, 2026-11-15 (chosen over keeping the narrower bar).
- **Decision:** in portrait the first page's vertical bar takes `Launcher.calculatedVerticalBarWidth`
  instead of the layout's ratio of its own height (about 155 px instead of 139 px on an A55), so that the
  grid, the creator and the screen agree and an element lies at the margin the user set. Landscape is
  unchanged (both give the same width). The cells alone are centred in what the bars leave; the bars and
  the creator's elements keep the page's corner.
- **Where:** `BarConstraints.widthReplacesRatio`, `WorkspaceGrid.firstCellX`; `aade70cd1`, `4e983e0f5`.

### D-62 The scope of round 14 in `KNOWN_ISSUES.md`
- **Status:** ACTIVE. **By:** owner, 2026-11-15.
- **Decision:** every open item of `KNOWN_ISSUES.md` is part of the round, Part B (accepted limitations)
  opened again; KI-33 (the layout settings without the user layout) and KI-17 (lint in CI) are not. A new
  test dependency (Robolectric) was approved for KI-06; when the session's network refused one of its files
  the owner chose to leave KI-06 for a later round.
- **Consequence:** what each KI got is written in its entry.

### D-63 Choices the assistant made in round 14
- **Status:** UNDER_REVIEW. **By:** assistant. None is an owner decision.

| Choice | Why |
|---|---|
| With the default grid (10 × 6) an icon keeps its standard size whatever its cell (`IconFit`) | nothing changes where the grid was not touched |
| KI-15: a log line only, no notice and no stop after three failures | no log from a unit where pinned PiP fails to test the rule against; a false alarm on the 7862 must not happen |
| KI-31 and KI-26: only the places that are the launcher's own and safe to change were changed | the others are framework code, the 7862's panes or need the 7870's data |
| While a bar's window is shown, the first page's own bar is hidden; it is hidden only after the window has drawn and shown before the window goes (`PageBarSwap`) | one bar, standing still, and no frame without a bar |
| The overview pictures of the bars are recordings drawn by the page (`Canvas.drawPicture`), not bitmaps | `Bitmap.createBitmap(Picture)` went with vanishing windows on the 7862 (D-24) |
| A tap on play/pause is not taken while the one before waits for the player's answer, up to 2 s (`PlayPauseRequest`) | one tap, one change; the owner saw a tap toggle twice |
| "Unknown" is compared as a whole value, as `validTag` of Display-Media-Titles (`TitleTag`); "null" only in lower case | copied as the owner asked |
| The stats window is laid out again whenever the limit reaches 1 after it was laid out under less, with five late looks after a raise (`StatsOverlayAlpha.needsRelayout`) | the system takes a written limit up late after a long sleep |

## Added on 2026-11-16 (round 15: the owner's test of round 14 on the A55)

### D-64 The bars' windows are panels of the launcher's window, under every floating button
- **Status:** ACTIVE. **By:** owner (the requirement: "floating buttons must always be above the bars, also
  those of other apps", 2026-11-15); the assistant chose the means.
- **Decision:** the windows of the bars on every page, of the auto-hide bar and of the edge handle are
  sub-windows of the launcher's own window (`TYPE_APPLICATION_PANEL`, `BarWindows`), not overlays. Over the
  pages and the panes, under every overlay of any app. They need no permission to draw over other apps.
- **Rejected alternative:** adding the launcher's floating buttons again after the bars, which would leave
  the buttons of other apps under them.
- **Risk [A]:** a pinned PiP of FYT (a window of its own task) would be over a bar where it lay on one; the
  creator keeps the panes beside the bars.
- **Where:** `edce9c338`, `f79b380b6`, `27cdb331e`.

### D-65 Icons and widgets may lie under the statistics window
- **Status:** ACTIVE. **By:** owner, 2026-11-15 (reported as a fault: an item could not be put there).
- **Decision:** the statistics are a window over the page that lets every touch through; its placeholder
  takes no cells (`CustomElement.takesCells`). The panes and the creator's widgets take theirs as before.
- **Where:** `45673d58a`.

### D-66 A widget that cannot be shown shows its preview, and its app is told to update it
- **Status:** ACTIVE. **By:** owner, 2026-11-16 (chosen: "force the update + preview").
- **Decision:** a widget whose content fails in the launcher shows the preview its app gives (else the app's
  icon) and opens the app on a tap, for every app. Where the launcher may send the protected APPWIDGET_UPDATE
  (as the system, or through a host with root: `sendWidgetUpdate`, no new protocol or module version), it is
  sent, twice at most; the change of the widget's options stays for every launcher.
- **Context [V/H]:** Allegro shows an image from its own FileProvider; the launcher may read it only after
  Allegro grants it at an update, and every new install of the launcher drops the grant. Shell (Shizuku
  without root) may not send the broadcast.
- **Where:** `WidgetRecovery`, `LauncherAppWidgetHostView`, `02bdd7f0a`, `75e2377a4`, `a654c0d60`.

### D-67 A bar on every page stands still: one window, no swap while the pages move
- **Status:** ACTIVE. **By:** the owner's requirement, 2026-11-16 ("fix it at the root"; "no jump and no
  flicker is acceptable"); the way is the assistant's, in the plan the owner approved.
- **Decision:** a bar on every page (the horizontal one without auto-hide, the vertical one) is its window
  on every page, the first one too, moving or at rest; the pages move under it. The first page's own bar
  of that kind is hidden from the moment the page is built and seen only where the window steps aside (the
  overview, a drag, a folder, all apps, the list of apps), at rest, or when no window could be added. The
  windows are built in the first page's first frame, stay while an app is in front (the system hides and
  shows them with the launcher's window), and are sub-panels, over the PiP panes. Nothing is built, shown
  or swapped while the pages move.
- **Context [V]:** Android 10 cannot swap two windows in one frame; on the 7862 a frame of a swap during a
  move lasted 60 to 280 ms with one of the two bars already moved (log 2026-11-16 10:12), so the bars were
  seen doubled at the start of each swipe. The windows were also removed at every pause and built 250 and
  400 ms after the return, a time in which a swipe moved the first page's bar with its page.
- **What remains:** the swap where the window steps aside, at rest and in one place (at most one frame of
  a darker translucent background). With the vertical bar on every page and the horizontal one on the first
  page only, the vertical bar grows into the corner as soon as the first page's horizontal bar has moved off
  its strip, and gives it back as soon as that bar moves onto it, in a short animation (`VerticalBarCorner`,
  the owner's request of 2026-11-16 13:30); until then it changed only at the end of the swipe.
- **Where:** `HorizontalBarPlacement`, `VerticalBarPlacement`, `PersistentBarWindow`, `PageBarSwap`,
  `BarWindows`, `Workspace.hideEveryPageBarsOfNewPage()`, `dffdd806b`, `074c09350`, `33edcda65`.

### D-68 Robolectric for the tests of views
- **Status:** ACTIVE. **By:** owner, 2026-11-18 ("enable Robolectric in the repository and use it in the tests
  of the changes"; approved as a dependency on 2026-11-15, D-62).
- **Decision:** `testImplementation` Robolectric 4.18 with JUnit 4 and the vintage engine beside JUnit 5;
  `unitTests.isIncludeAndroidResources = true`; tests run on SDK 34 (`app/src/test/resources/robolectric.properties`).
  Tests of views live in `app/src/test/java/com/android/launcher66/views/` or beside the class they test. New changes to views and settings
  get a Robolectric test where one can show them.
- **Context:** Maven Central sends Robolectric's large files to `gcp.mirrors.maven.org`; the owner added that host
  to the cloud environment on 2026-11-18. CI has a full network.

## Added on 2026-11-18/19 (round 22: the owner's log of 2026-11-16 18:42 on the 7862 and eight guidelines)

### D-69 The statistics window on the home screen lies under the bars, over the panes
- **Status:** ACTIVE. **By:** the owner's requirement, 2026-11-16 ("it should move under the vertical bar like the
  PiPs and everything else"); the assistant chose the means.
- **Decision:** on the home screen the statistics window is a sub-window of the launcher's window
  (`TYPE_APPLICATION_SUB_PANEL`, `CanbusService.addHomeStatsWindow`), and the windows of the bars on every page
  lie one layer above it (`BarWindows.EVERY_PAGE_TYPE`, the hidden layer above sub-panels, falling back to lower
  ones with a log). Layers from the bottom: the PiP panes (panels), the statistics, the bars. Over another app
  the window stays an overlay, with the alpha limit handled as before (`StatsOverlayAlpha`).
- **Consequence:** the system's opacity limit for overlays does not apply to the window on the home screen.
- **Updates:** D-16 (it lies under the bars), D-64 (the bars on every page are no longer plain panels).
- **Risk [A]:** that Android 10 and 16 accept the hidden layer; the fallback keeps the old order.
- **Where:** `cbd7c10cf`.

### D-70 The vertical bar's width may be set, 4–10 % of the longer edge
- **Status:** ACTIVE. **By:** owner, 2026-11-16 ("with all that follows, as for the horizontal bar"; the range
  4–10 %).
- **Decision:** "Resizable vertical bar" and its slider in "Bars", per orientation, as a share of the screen's
  longer edge. Off, or at the default, the width is the old one to the pixel. Everything counts with the one
  value (`Launcher.calculatedVerticalBarWidth`, `VerticalBarDimensions`): the bar and its window, its icons,
  the grid, the panes, the statistics, the creators. Counts in the user layout only. Extends D-61: the launcher's
  width now replaces the layout's share in landscape too.
- **Where:** `fa3e84d9e`.

### D-71 The number of app icons on each bar may be set
- **Status:** ACTIVE. **By:** owner, 2026-11-16 and 2026-11-18.
- **Decision:** with a bar's "Resizable" switch on, a slider (like the grid's) chooses 1 … as many icons as the
  bar has room for, worked out as the launcher does and following every option that changes it. Nothing chosen =
  as many as fit. A newly worked-out most lowers a chosen number only where the number is above it (the owner,
  2026-11-18), and the lowered number is stored. The icons keep their size and are spread evenly.
- **Where:** `BarIconCount`, `BarIconLimits`, `5a6272396`.

### D-72 "Transparent status bar" in "Home screen layout"
- **Status:** ACTIVE. **By:** owner, 2026-11-18.
- **Decision:** the switch is in "Home screen layout" on the second screen, directly above "Set the start
  page". With the built-in layout it cannot be reached (KI-33).
- **Where:** `a43efdf66`.

### D-73 The settings list keeps its place; the guides lie below the app bar
- **Status:** ACTIVE. **By:** owner, 2026-11-18.
- **Decision:** the position of the list is kept when a row opens a window the user comes back from (the
  creator through ADJUST, the guides, the Spotify sign-in, the wallpaper picker, the device settings …) and
  restored before the first frame. It is dropped between screens 1 and 2, on the way out to the home screen,
  and when the settings start afresh (`SettingsScrollMemory`). The Canbus guide and the Spotify instructions lie
  below the app bar like the other screens.
- **Where:** `6449c7b22`, `e703c9a55`.

### D-74 Choices the assistant made in round 22
- **Status:** UNDER_REVIEW. **By:** assistant.

| Choice | Why |
|---|---|
| The icon number counts only with the bar's "Resizable" switch on | its slider is shown only then (the owner's wish) |
| The settings count the vertical bar's room from the geometry; the launcher shows min(choice, measured room) | the room must follow options before the launcher has measured anything (D-71) |
| The vertical bar's width per orientation, like the horizontal bar's height | the same shape as the existing slider |
| In landscape the first page's vertical bar takes the launcher's width instead of the layout's 7.1 % | without it the setting would not show; equal to the pixel on the 7862 |
| The new strings follow the existing horizontal ones: the 51 full language files and the `pt-rPT` override | the regional files (`en-rGB`, `fr-rCA` …) fall back to their language |
| Tests of views also beside the class they test, not only in `views/` | D-68 asked for them where they show a change |

