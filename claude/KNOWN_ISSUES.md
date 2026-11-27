# Known issues

As of 2026-11-27 (`testBranch` after round 29, none of which was tried on a device; the owner's A55 results for rounds 27 and 28 are in KI-51; the 7870 tester's results are awaited, see `checks/7870.md`). KI-46 closed 2026-11-25 by the 7862's log; KI-22, KI-28, KI-37, KI-50 and KI-52 closed 2026-11-27 (the round 29 report). One list of what is open today,
rewritten on 2026-11-18 at the owner's request. What was fixed or closed has been taken out; it stays in git
and in the reports (`reports/`, `chat_archive/`). Sources: the code, git, CI, the briefs, the chat reports and
the owner's results.

**Kind:** *problem* (the code, git or CI shows it) · *limit* (known, and decided or inherent: do not "fix" it
without asking) · *unverified* (a report or a code reading suggests it, or a change was never confirmed on a
device: check before acting on it).
**Status:** open · partial · watching (a fix is in, the owner's result is awaited) · accepted.

Add a new issue at the end with the next number. Numbers are never reused; a closed issue is removed from this
file and named in the round's report.

| ID | Issue | Kind | Status | What is awaited |
|---|---|---|---|---|
| KI-01 | OpenWeather API key hardcoded in public source | limit | accepted (D-26) | — |
| KI-02 | Public platform signing key committed | limit | accepted (D-02) | — |
| KI-04 | Baseline Profile probably stale | problem | open | the owner regenerates it on a device |
| KI-05 | Android 8–10 through the VD host never run on a device | unverified | open | one device each: 8.0, 8.1/9, 10 |
| KI-06 | Few tests of views | problem | partial (Robolectric since 2026-11-18, D-68) | more view tests with each change |
| KI-07 | Repository footprint | problem | open | the owner's call (R-5) |
| KI-08 | Very large classes and legacy AOSP TODOs | limit | accepted (policy) | — |
| KI-10 | Unreleased work: version still 1.2.1 | problem | open | the owner's release |
| KI-11 | Heavy cold start after a reboot | problem | partial | profiling on a device |
| KI-12 | Reliance on hidden APIs and reflection | limit | accepted | — |
| KI-13 | Shizuku host limits | limit | accepted | — |
| KI-14 | `com.syu.media` favorites limits (7870) | limit | accepted (D-14) | — |
| KI-15 | Pinned PiP limits | limit | accepted | a log from a unit where it fails |
| KI-16 | A standard ("phone") 1.2.1 cannot update itself | limit | accepted | — |
| KI-17 | Lint is weak in this project | problem | open | — |
| KI-18 | Framework warnings in logs | limit | accepted (D-15) | — |
| KI-21 | The stats window on the 7862 while pages scroll | limit | accepted | — |
| KI-23 | Translations are machine-written and unreviewed | problem | partial (a machine check) | native speakers |
| KI-25 | Older changes with no device confirmation on record | unverified | open | the owner's result for each |
| KI-26 | Code observations from reviews | unverified | partial | a re-check of the four left |
| KI-27 | Limits of the home-screen guard | limit | accepted (D-28) | — |
| KI-29 | "Changes do not work on the 7870" | unverified | open | the tester's reply |
| KI-31 | StrictMode reports inside the framework (A55 log of 2026-11-09) | problem | partial | — |
| KI-33 | Some settings of the home screen only with the user layout on | limit | accepted (D-85) | — |
| KI-44 | The GPS of the fuel statistics only while something needs it | unverified | partial | a unit whose code check waits for a drive |
| KI-48 | The 7870's covers and the position slider | unverified | watching | the tester's result and log (round 26) |
| KI-49 | The canbus script's `--launcher .` needs the decompiled folders, now zips | limit | accepted (the owner, 2026-11-22) | — |
| KI-51 | Round 28 on a device: what the A55 has not shown yet | unverified | watching | the owner's results for A3, A6, A7, D1 to D3, I1, I2 (the A55) and the 7862 |
| KI-53 | The release build of the settings' preferences (A3) cannot be tried in a session | unverified | watching | a release build by the owner |
| KI-54 | Direct boot hung the A55 at boot (round 28, A7), then a crash at the unlock | problem | watching | the owner's A55 test of round 29's debug build, with and without a PIN |
| KI-55 | Round 29 on a device | unverified | watching | the owner's test on the A55 and the 7862 (the list below) |
| KI-56 | The 7862's keyboard above the bars rests on an assumption about Android 10 | unverified | watching | the 7862: a keyboard from a PiP with the bars shown |
| KI-57 | The drawer's changes of round 29 have no view test | unverified | watching | the owner's test of the drawer on the A55 and the 7862 |
| KI-58 | R8 keeps every CAN bus callback in a release | limit | open (the owner's call) | — |

## Problems

### KI-04 Baseline Profile probably stale
`app/src/main/generated/baselineProfiles/` has only lost lines for removed classes since `97c59837`
(2026-10-15) [V]. New code is not compiled ahead of time, so the start is slower. Regenerate it on a device
before 1.2.2 (P-3, `baselineProfile/README.md` §10).

### KI-06 Few tests of views
- JVM tests cover the plain-Java logic. Since 2026-11-18 Robolectric runs tests of views beside them (D-68):
  the settings screens, the guides' insets, the bar's sizes and the vertical bar's width, the scroll memory and
  the icon sliders of the settings.
- **Not covered:** the windows (bars, panes, statistics), the IPC with FYT apps, the VD host. Those are seen
  only on the owner's and the tester's devices. `:baselineprofile` holds journeys, not tests, and CI does not
  run it.

### KI-07 Repository footprint
`.git` is about 560 MB; `archive/` (about 300 MB of decompiled reference code) and `images/` (176 MB) are in
the tree [V]. `archive/` is reference material: do not delete it. R-5 is the owner's call.

### KI-10 Unreleased work
`versionName = "1.2.1"` [V]; `testBranch` is hundreds of commits past `v1.2.1` and far ahead of `main`. Users of
the built-in updater get none of it until a release (P-2).

### KI-11 Heavy cold start after a reboot
Measured [H]: plan → `finishBindingItems` 3.2 s (Samsung), 9.3 s (Xiaomi); on the 7862 about 6.6 s after a
force-stop; panes ready 6–7 s after a cold start. This ROM blocks calls into `system_server` for about ten
seconds at boot (`ColdStart`). `69aac3b1` moved the widget list and class verification off the critical path.
Next: profiling on a device (P-8).

### KI-17 Lint is weak in this project
`lint.checkReleaseBuilds = false`; `lintConfig` is commented out, so `app/lint.xml` is not used; the
dependency-analysis plugin only warns; CI runs no lint task. Not in scope since round 14 (D-62).

### KI-23 Translations are machine-written and unreviewed
Every string of the 58 translations was written by a session (D-10). `StringResourcesTest` checks them
against the English file (well-formed, no key twice or missing in English, the same format arguments, nothing
empty) [V]; the quality of the language it cannot tell (`rm`, `lo-rLA`, `km-rKH`, `am`, `zu`, `sw` most at
risk). No review is planned.

### KI-31 StrictMode reports inside the framework
From the A55 log of 2026-11-09 [H]: `WindowHostVdShizuku.maybeBind` is fixed (`0905bff8f`). Left as described
[V]: `VdHostProtocol$Proxy.startActivity` (the start of a pane; it would need the way panes start rebuilt), and
the reads under `LauncherAppWidgetHostView.onLayout` and in a toast, both inside Samsung's framework code. The A55's
`start_full` log of 2026-11-27 [V] shows the toast's again: Samsung's `Toast.show` of the toast about a crash.

### KI-33 Some settings of the home screen only with the user layout on
The second settings screen opens only with "User layout" on [V]. Its "Home screen layout" holds the grid, the
icon text sizes (D-56) and, since 2026-11-18, "Transparent status bar" (D-72): with the built-in layout they
cannot be changed. **Accepted 2026-11-25 (D-85):** that is the rule now; "Stock layout" turns off everything of the
creator, and since round 28 their stored values no longer apply to it either (`CreatorPrefs`).

### KI-51 Round 28 on a device
The owner's test of round 28 on the A55, 2026-11-27 [H]:
- **Works:** A4 (the vertical bar at a swipe), A5 (the statistics window after a restart), B1 and B2 (the slider); and
  of the rounds before: round 27's slider, "Start on wake" and "Start on boot" (KI-50 closed), KI-22, KI-28 and KI-37
  (closed), P-11.
- **Partly:** C1 to C3 (the accent, the switches, "Stock layout"), D4 to D7 (folders, free widgets, overlap) and F (the
  drawer): what was wrong is fixed in round 29 (KI-55).
- **Not built in round 28:** E1's horizontal half, E2, E3 and G1 (KI-52): built in round 29.
- **No result yet:** A3 (a release build's settings, KI-53), A6 (the logcat stop after a restart), A7 (the black window
  before and after the unlock, KI-54), D1 to D3 (the colour of the icons' names, the two swipes, the double tap: lock,
  turn off, turn on), I1 (BOOT_COMPLETED at a wake), I2 (the welcome texts); and KI-44, P-3, P-5.
- On the 7862 nothing of round 28 has been reported: the double tap "Turn off screen" is the tile's command and the same
  double tap brings the screen back; the swipe down is the quick settings panel; the slider of com.syu.music has no knob.

### KI-53 The release build of the settings' preferences (A3)
The second settings screen crashed in the A55's release build (standard release 1.2.1, Android 17, the owner's crash log of 2026-11-25): R8 removed the `(Context, AttributeSet)` constructor of a preference, which the inflater calls by reflection.
A3 keeps them (`proguard-rules.pro`), but a release cannot be built in a session, so the fix is [V] only by reading the
rules. The owner opens the settings of a release build to see.

### KI-54 Direct boot hung the A55 at boot (round 28, A7)
The owner, 2026-11-26 [H]: after installing the round 28 build the A55 stayed on "Powered by Android" at a restart;
safe mode, which leaves the launcher out, booted. The cause, read in the code [V; no log of the hang]: the Launcher
activity was direct boot aware (`baa2432fc`), so Android made it before the user's first unlock. Its field initializer
`helpers = new Helpers()` runs before `onCreate()` and its lock check, and loading `Helpers` opened the credential
encrypted file `HelpersPrefsSus` in a static field. Android refuses that before the unlock with an
`IllegalStateException`, so the activity could not be made and the home was started again and again.
- `e8fc35713`: the attribute taken off at once, so every build starts after the unlock as before round 28.
- `b21482ef1`: `Helpers` opens the file at the first use; `StorageAtClassLoadTest` scans the sources so that no static
  field or block reads storage (it catches the old line); `LockedStartViewTest` makes the activity with a locked storage
  that throws. Direct boot comes from the placeholder `launcherDirectBoot`: **on in debug builds, off in release**, until
  the owner confirms it.
- To try on the A55 with a debug build (it installs over a release, the same key): a restart with a PIN and one without.
  The wallpaper should show before the unlock, the home screen after it, with `Launcher: direct boot, waiting for the
  user's unlock` and `LauncherApplication: unlocked, starting` in the log. If it hangs again: `adb logcat -b all` during
  the boot (adb works before the unlock), then safe mode and One UI Home as the home app to get out.
- **The owner's debug build, 2026-11-27** [H, crash log `2._crash_pid_27-11-2026_00-45-13`, V]: the boot no longer hangs,
  but after the unlock the launcher came up where it was not the home app, slowly, and crashed: a
  `NullPointerException` in `Workspace.onAttachedToWindow` (no drag controller yet) in `setContentView` of
  `handleRelaunchActivity`. The locked activity's `recreate()` at the unlock relaunched it with its window kept.
  `35366adbf` (round 29, D-99): at the unlock the activity ends (`finish()`) and the system starts the home the user chose;
  `Workspace.onAttachedToWindow` no longer needs the drag controller. To try again as above, with the home app set to
  another launcher once.

## Limits

### KI-01 OpenWeather API key hardcoded in public source
`WeatherManager.OPEN_WEATHER_APPID`, kept by the owner (D-26). The key and exact coordinates never reach the
logs. Since 2026-11-15 a key of one's own can be entered in the settings and is used instead (`WeatherKey`).

### KI-02 Public platform signing key committed
`app/keystore.jks` and `keystore.properties` hold the public `android` defaults. The `system` flavor needs the
AOSP test platform key FYT firmware uses; anyone can sign an APK that updates the launcher there.

### KI-08 Very large classes and legacy AOSP TODOs
`Launcher.java`, `Workspace.java`, `CellLayout.java`, `LauncherModel.java`, `MediaFavoriteController.java` and
`SettingsFragmentSecond.java` are thousands of lines each; the `TODO`/`XXX` markers are AOSP leftovers.
Targeted edits only; new logic in small tested classes (D-36).

### KI-12 Reliance on hidden APIs and reflection
ActivityView members, `IActivityManager`/`IActivityTaskManager`, the hidden input monitor, `TaskStackListener`,
the decompiled FYT IPC, and since 2026-11-18 the hidden window type of the bars on every page (the layer above
sub-panels, with fallbacks: `BarWindows`). A new Android version or ROM can break a feature silently. The
`FytCompat` fuse, the compat reports and `HiddenApiProbe` (one report when a member is missing) soften it.

### KI-13 Shizuku host limits
Apps with `FLAG_SECURE` show black in a pane; the panes come up only once Shizuku runs; Shizuku without root must
be started again after each reboot, and with root it fails before Android 14; Shizuku Next may disconnect and
reconnect at boot (its own code, CHAT_05). Source: `README.MD`, `vdhost/README.md`.

### KI-14 `com.syu.media` favorites limits (7870)
A heart pressed in the widget shows in `com.syu.media` only after it reloads its library (it has no call to
make it reload, checked 2026-11-15); FM favorites are read-only; the Bluetooth heart stays grey.

### KI-15 Pinned PiP limits
Google Maps switches to its minimal UI in FYT's pinned PiP unless the LSPosed module is used (D-23). Where pinned
PiP does not work, Maps pops up on the home page; since 2026-11-15 the log says so after three times in a row
(`PinnedPipHealth`), and nothing is stopped.

**The pinned PiP cannot move with the pages (checked 2026-11-21 in the 7862's framework,
`archive/decompiled/7862/system.zip`) [V].** The owner asked whether it could follow a swipe like the windowed PiPs.
FYT's mode-6 stack (`ActivityStack`) takes its rectangle from `sys.lsec.pip_rect` when it is created, and its
`setBounds()` replaces any rectangle with that one for mode 6; `resizeStack` ends in `setBounds()`, `resizeTask`
throws for anything but freeform (`canResizeTask()`), and `setPinnedStackVisible` → `TaskStack.lsecSetVisble` only
shows or hides the surface. A new rectangle is taken only by a new stack, so moving it with the pages would need a
change of the framework (an LSPosed hook on `ActivityStack.setBounds`, say), outside the launcher. Hiding it while
the pages move stays (D-34).

### KI-16 A standard ("phone") 1.2.1 cannot update itself
Its updater downloads the system build. One update by hand; documented in `README.MD`.

### KI-18 Framework warnings
`W Parcel: Expecting binder but got null!` and `E SurfaceSyncer: Failed to find sync for id=0` (Android 13)
have no effect (D-15). Looked at on 2026-11-19 in the A55's log of a start [V]:
- `RippleDrawable: Thread doesn't have a looper. Skipping animation.` — the widgets' layouts are inflated on the
  launcher's `WidgetApply` thread (off the main thread, for StrictMode); a ripple made there cannot start its
  press animation, and nothing is pressed during inflation. Harmless.
- `LocaleConfig: The resource file pointed to by the given resource ID isn't found.` — from the contexts made for
  other apps' resources (the widgets, their previews); the launcher declares no locale config of its own.
- `AppWidgetHostView: Error inflating RemoteViews … Permission Denial: opening provider
  androidx.core.content.FileProvider` — Allegro's widget, written by Android before the launcher's preview
  replaces the error (D-66). It stays until Allegro sends its widget again with the image granted; the launcher
  may not make it do so through Shizuku. Its widget has no preview picture, so its icon is shown.
- `WallpaperResourcesInfo`, `ashmem: Pinning is deprecated`, `InputDispatcher` (system_server), `BitmapFactory: Null
  Options` — Samsung's framework or other processes.
- `AppsCustomizePagedView E … can not fit on this device` — a Samsung test widget larger than the screen,
  left out of the list of widgets; only the level of the line is too high.
- `BitmapDrawable created with null Bitmap` (14 at a start) was the launcher's: fixed in `0e2ac7833`.

### KI-21 The stats window on the 7862 while pages scroll
Three fixes in 2026-11 did not help; direct surface moves (`3a0217ea`) were reverted as worse (`b38f1286`, D-24),
and a picture of the window (`5392230c2`) made the window and the floating buttons vanish (reverted,
`fe72e5a6f`). Not to be retried that way. Since round 22 the window on the home screen is a sub-window of the
launcher's window under the bars (D-69); the owner, 2026-11-19 on the 7862: it moves under the vertical bar
during a swipe as it should [H].

### KI-27 Limits of the home-screen guard
An app `com.syu.ms` noted and the user opens within 3 s of the wake is sent back once; apps on FYT SystemUI's
autostart list stay in front after a cold start; nothing is guarded on a phone without privileges; steering-wheel
buttons and `adb shell am start` produce no input the launcher can see.

### KI-58 R8 keeps every CAN bus callback in a release
Measured on 2026-11-27 [V] with `:app:minifyStandardReleaseWithR8` (`usage.txt`, `mapping.txt`, `seeds.txt`): of the 726
`com.syu.module.canbus.Callback_*` classes 724 stay, 721 of them as seeds of the rule
`-keep class * implements android.os.IInterface { *; }` (they extend `IModuleCallback.Stub`); without the rule they would
stay too, since `HandlerCanbus` (795) and `HandlerCanbus7870` (873) make each with `new` behind the car's id, which R8
cannot know. The rule only keeps all their members. Of `com.syu.ui` 12 classes stay and 522 go. The dex files are 2.8 MB
and 3.7 MB. Nothing was changed: narrowing the rule would risk the `IllegalAccessError` it guards against (an inlined
`Stub.asInterface()`, see `proguard-rules.pro`), and dropping the callbacks would need a lookup by name. `largeHeap` is already `false`.

## Unverified

### KI-05 Android 8–10 through the VD host never run on a device
Written from the AOSP sources only. Checklist in `vdhost/README.md` ("Still to test on a device").

### KI-25 Older changes with no device confirmation on record
The commits exist [V]; no result was reported [U]: the navigation app no longer overwritten (`44833aa0`), the
`launcher_home` split (`36359b61`), the guard where `com.syu.ms` really reopens its app (`10c9b3b`), the stats
overlay at cold start (`05747c7`), splash readiness on Android 11+ and the empty pinned package (`eed91b73`),
the weather re-check without network (`91ef98b`), the empty dual pane with a late Shizuku host (`fee2455`), the
regrab of moving pages, the icon plate and disk writes (`ee9b303f`, `4ab8ddb3`, `620fd619`), screen numbers,
overlap fitting and the Spotify start (`a2a180c`, `1c32b4d`, `1ace149`), the date widget (`3eb7798`), the left
bar capacity (`219c47eb`), the Cling removal (`de25567`, `8bddb4c`, `4f6ee7d`).

### KI-26 Code observations from reviews
Left after the re-check of 2026-11-15 [V]: `WindowHostAvReaper` abandons views when the stack query is
unavailable, and `swapActivityViewSurfaces` blocks the main thread up to 1000 ms per swap (the 7862's panes: not
changed blind); `Launcher.refreshBtInfo` takes the 7870's Bluetooth milliseconds for seconds (waits for KI-29);
a YouTube ReVanced crash during a fast pane rebuild, taken for the app's own bug.

### KI-29 "Changes do not work on the 7870"
The tester did not say which (2026-11-12) [H]. Open questions for the 7870's logs: does `com.syu.ms` push the
current values when the launcher registers; does `com.syu.media` give up its channel when it pauses for a pane
app; Bluetooth times in milliseconds (KI-26).

### KI-44 The GPS of the fuel statistics only while something needs it
The owner's A55 asked for the GPS every 500 ms whenever the statistics' service ran (2026-11-19) [V], also with no
canbus. `71c8e0e03`: `LocationNeed` — none without a canbus or need, every 5 s while only a drive has to be seen,
every 0.5 s for the estimate, the speed code's scale and the code check's recording. `7e955ba65`: the code check sees
a drive from the speed code too, so with a known speed code it waits without the GPS. **The owner's logs of
2026-11-20 [V]:** the A55 makes no location request any more (no `RequestManager_FLP` line for the launcher). It has
no `GPS:` line either: the service logs a change of the rate, and "none" from the start is no change. The 7862 asks
every 500 ms as before, for the estimate's altitude (it has no barometer; its speed comes from the code). Not seen yet
on a device: a unit whose code check waits for a drive (every 5 s without a speed code, nothing with one).

### KI-48 The 7870's covers and the position slider
The tester [H]: "sometimes media widget shows default picture until cover or track changes", and a position slider on
the big widget for files and BT. No log of it yet; three causes were found in the code and fixed in round 26 [V]:
- BT's cover file was refused as old after a start in the middle of a song, after a title cleared for a moment, and
  after the clock jumped back (`StockBtCover`, `8ac8400a7`);
- a file's cover was read by the launcher's ID3 reader (mp3 with a JPEG only) and a failed read was kept; it is now
  read with `MediaMetadataRetriever` as com.syu.media reads it, once more if the file could not be opened
  (`FileCover`, `1026d6b69`);
- the cover was drawn only while playing; in a pause and on a widget built again it is drawn too (`PausedCover`,
  `18cc6e3f6`).
The slider (`PositionSlider`, `6c525ff3e`) moves com.syu.media's files through IPlayer transaction 12 and only shows
the position for BT and stations. To look at in the tester's log: `StockSources: bt cover … song changed before the
start -> fresh`, `MusicCover: file cover …`, `SyuMediaClient: seek MEDIA_MUSIC to …`. Not tested on a device.

### KI-49 The canbus script's `--launcher .` needs the decompiled folders, now zips
The owner's `22490c9e0` (2026-11-21) replaced `archive/decompiled/decompiled_*` by zip files whose top folders have no
`decompiled_` prefix (`carinfo/`, `com.syu.canbus/`, …) [V]. `canbus_library/build_canbus_library.py --launcher .`
reads `archive/decompiled/decompiled_com.syu.canbus/{classes.dex.new,classes.dex,classes.dex.7870}/sources` and
`archive/decompiled/decompiled_carinfo` (`LAUNCHER_SOURCE_ROOT`), names that also go into the library's header.
**Accepted (the owner, 2026-11-22):** the zips stay and the script is not changed; `canbus_library/README.md` (the
owner's `2d222c6ac`, and section 5 since round 27) tells how to unpack them under those names and not to commit them.
Checked on 2026-11-22 [V]: unpacked that way, `--launcher .` and `--launcher . --platform 7870` give both assets byte
for byte. The built-in assets are not affected: nothing rebuilds them by itself.

### KI-55 Round 29 on a device
Round 29 (2026-11-27) is built, its tests are green and CI ran on every batch, but none of it was tried on a device [V:
every commit says so]. What to look at, by the plan's points:
- the start after a restart with a PIN and without (KI-54), the heart of a liked song, the theme colour of the PiP and
  widget rows' buttons, the dimmed rows that are off, the two swipes (a long press and a move is no swipe; the drawer
  opens while the finger moves);
- folders with "Follow home screen grid", "Freeform widgets" (the drop, the frame of a resize, a new widget's frame) and
  "Allow widgets to overlap" (nothing pushed, a widget off a PiP), with the log's `FreeformWidgets` lines;
- the drawer (KI-57), the tab creator and its lists, the badges' slider, "Estimate below the car's threshold", the
  settings' text size at 150 % on both screens;
- "Display horizontal bar", "Hide the app drawer button" and "Hide the music widget", in both orientations and on the
  7862's home screen (the page and the bar's window alike);
- on the 7862, the keyboard of a PiP above the bars (KI-56).

### KI-56 The 7862's keyboard above the bars rests on an assumption about Android 10
The owner, 2026-11-27 [H]: on the 7862 a keyboard opened from a PiP comes up under the vertical and the horizontal bars.
The cause is read from Android 10's window manager [A, no log]: the keyboard is layered just above its target, the
topmost window that may take it, and the panes of the PiPs may while the bars' windows above them may not. `ImeAnchor`
(`f727fc0ed`, D-100) adds a 1×1 window of the bars' type above them that is such a target and takes no touch or focus.
To check on the 7862: the keyboard from a PiP's app with the bars shown; that the launcher's own dialogs with a text
field still get their keyboard; nothing of it on the A55 (Android 11 and later have no anchor).

### KI-57 The drawer's changes of round 29 have no view test
The drawer's pane (`AppsCustomizeTabHost`) does not inflate in Robolectric, so the view tests stop at its parts
(`AppsVerticalView`, `LetterScroller`, `WidgetsListView`, `DrawerTabsFragment`) [V]. Not tried as a whole: the drag from
the vertical list (`27f51efc0`), the letter scroller following the list (`f921f41d6`), the spacing (`2d48449f4`), the
apps of a new tab after a swipe (`25c25f633`), the widgets' list with its drag (`5c3c8bc19`), and the pager's pages left
empty while a list covers it and filled when it is shown, with the fix of the pager showing under the widgets' list
when the drawer opened on them (`77f440135`). To look at: a switch of "Scrolling" between vertical and horizontal while
the launcher runs, the widgets' tab, and the drag of an app and of a widget to the home screen.
