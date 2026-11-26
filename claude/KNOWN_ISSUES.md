# Known issues

As of 2026-11-26 (`testBranch` after round 28; none of it tried on a device; the 7870 tester's results are awaited, see `checks/7870.md`). KI-46 closed 2026-11-25 by the 7862's log. One list of what is open today,
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
| KI-22 | Two side effects of the pinned-PiP keyboard fix | unverified | open | a check on the 7862 |
| KI-23 | Translations are machine-written and unreviewed | problem | partial (a machine check) | native speakers |
| KI-25 | Older changes with no device confirmation on record | unverified | open | the owner's result for each |
| KI-26 | Code observations from reviews | unverified | partial | a re-check of the four left |
| KI-27 | Limits of the home-screen guard | limit | accepted (D-28) | — |
| KI-28 | A workspace load that bound nothing for 30 s | unverified | watching | a log of the next case |
| KI-29 | "Changes do not work on the 7870" | unverified | open | the tester's reply |
| KI-31 | StrictMode reports inside the framework (A55 log of 2026-11-09) | problem | partial | — |
| KI-33 | Some settings of the home screen only with the user layout on | limit | accepted (D-85) | — |
| KI-37 | A widget lay over icons after a change of the grid | unverified | watching | a log with `Item out of place` |
| KI-44 | The GPS of the fuel statistics only while something needs it | unverified | partial | a unit whose code check waits for a drive |
| KI-48 | The 7870's covers and the position slider | unverified | watching | the tester's result and log (round 26) |
| KI-49 | The canbus script's `--launcher .` needs the decompiled folders, now zips | limit | accepted (the owner, 2026-11-22) | — |
| KI-50 | The position slider for every player, and "Start on wake" | unverified | watching | the owner's test on the A55 and the 7862's log (round 27) |
| KI-51 | Round 28 on a device: crashes, the black window before the unlock, the settings' look, the gestures, the drawer, the badges | unverified | watching | the owner's test on the A55 and the 7862 (the lists in the round's report) |
| KI-52 | Round 28's brief only partly built: E1 horizontal, E2, E3, G1 | problem | open | a round with a device to try the bar and the drag on |
| KI-53 | The release build of the settings' preferences (A3) cannot be tried in a session | unverified | watching | a release build by the owner |

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
the reads under `LauncherAppWidgetHostView.onLayout` and in a toast, both inside Samsung's framework code.

### KI-33 Some settings of the home screen only with the user layout on
The second settings screen opens only with "User layout" on [V]. Its "Home screen layout" holds the grid, the
icon text sizes (D-56) and, since 2026-11-18, "Transparent status bar" (D-72): with the built-in layout they
cannot be changed. **Accepted 2026-11-25 (D-85):** that is the rule now; "Stock layout" turns off everything of the
creator, and since round 28 their stored values no longer apply to it either (`CreatorPrefs`).

### KI-51 Round 28 on a device
Round 28 is built and its tests are green, but none of it was tried on a device [V: every commit says so]. What to look
at, by the owner's points: the crashes (A1 to A3, the settings of a release build included), the vertical bar at a
swipe (A4), the statistics window after a restart (A5), the logcat stop after a restart (A6), the black window before
and after the unlock, with a PIN and without (A7); the slider's colour, centre, touch and area (B1, B2); the accent and the
switches (C1, C2), "Stock layout" (C3); the colour of the icons' names, the two swipes, the double tap: lock, turn off, turn
on (D1 to D3); folders (D4, D5); free widgets and overlap with its question (D6, D7); "Start on wake" with BOOT_COMPLETED
(I1), the welcome texts (I2); the badges (H1, H2); the drawer: vertical, the letters, the search bar, the grid, the
tabs and their creator, the lists of apps (F1 to F6). On the 7862: the double tap "Turn off screen" is the tile's
command and the same double tap brings the screen back; the swipe down is the quick settings panel; the slider
of com.syu.music has no knob. The unit tests do not tell whether a swipe of a finger is taken by the right view.

### KI-52 Round 28's brief only partly built
Built: A1 to A8, B1, B2, C1 to C3, D1 to D7, F1 to F6, H1, H2, I1, I2, and "Display vertical bar" (the vertical half of
E1). **Not built:** the horizontal half of E1 (the switch "Display horizontal bar" with the launcher not building the
bar and giving its room to the grid, and `DrawerAccess` in the settings), E2 (hide the app drawer button), E3 (hide the
music widget, and `BarShares` used by the page's layout, the window's, the apps list's room, the tiles and the music
widget's size) and G1 (the widget list). What exists of them is the tested models `BarShares` and `WidgetGroups` (D-87,
D-89), which nothing calls yet. Reason: the bar's placement is decided at about a dozen places in `Workspace`, `Helpers`
and `Launcher`, and the widget picker is the way widgets get onto the home screen; neither can be tried without a
device, and a regression there would be in the 7862's home screen. A round with a device should take them one by one.

### KI-53 The release build of the settings' preferences (A3)
The second settings screen crashed in the A55's release build (standard release 1.2.1, Android 17, the owner's crash log of 2026-11-25): R8 removed the `(Context, AttributeSet)` constructor of a preference, which the inflater calls by reflection.
A3 keeps them (`proguard-rules.pro`), but a release cannot be built in a session, so the fix is [V] only by reading the
rules. The owner opens the settings of a release build to see.

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

## Unverified

### KI-05 Android 8–10 through the VD host never run on a device
Written from the AOSP sources only. Checklist in `vdhost/README.md` ("Still to test on a device").

### KI-22 Two side effects of the pinned-PiP keyboard fix
`PinnedPipFocus` is confirmed (D-44). Not checked: launcher dialogs with text fields while the pinned PiP is shown;
with the accessibility fallback, the foreground package may alternate between the PiP app and the launcher.

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

### KI-28 A workspace load that bound nothing for 30 s
After leaving the settings (`e3136f45`, logs `Loader <id> …`): mitigated with a guard and logging [V], cause
unknown [U]. The owner's report of the vertical bar on the right with the setting "left" is not explained by the
cause fixed on 2026-11-13 [U].

### KI-29 "Changes do not work on the 7870"
The tester did not say which (2026-11-12) [H]. Open questions for the 7870's logs: does `com.syu.ms` push the
current values when the launcher registers; does `com.syu.media` give up its channel when it pauses for a pane
app; Bluetooth times in milliseconds (KI-26).

### KI-37 A widget lay over icons after a change of the grid
The owner, 2026-11-15 [H]. `GridOverflowPropertyTest` finds no overlap in 3000 random screens [V]; the way it
happened is unknown [U]. Every page moves an item that shares a cell or lies outside its grid after every load,
drop and resize (`CellOverlap`, `PageFit`) and logs `Item out of place on page …` with the item and the way (the
line was `Items sharing cells` before round 20). **The owner's log of 2026-11-19 13:16 [V]:** two changes of the
grid (3×8 → 7×12 and 7×12 → 5×8, the second giving 4 icons of the first page a new cell) and no such line, so
nothing shared a cell after either load.

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

### KI-50 The position slider for every player, and "Start on wake"
Round 27 [V in the code, not on a device]:
- the slider is on every unit (`7ec71e8dc`); it moves a session's own app where its session has a length and allows
  `ACTION_SEEK_TO` (`8f2259db1`), shows the position where it does not, and is empty without a length or for a live
  stream. **com.syu.music on the 7862 cannot be moved from outside** [V, 2026-11-25, in the owner's
  `archive/decompiled/com.syu.music.zip`]: its exported `MService` takes only playpause, stop, next, prev, path and
  widget actions; its `MediaSession` (`MediaManager`) only handles media buttons, with no playback state, no length
  and no `onSeekTo`; it seeks only from its own screens (`Page_Player`, `Page_Id3`, `Page_Player_HalfScreen` →
  `App_Music.seekTo`). The slider therefore shows its position without a knob (SHOW);
- on the 7862 the widget's position row is higher (0.09 of the height instead of 0.04), the cover, text and buttons a
  little lower;
- "Start on wake" (`65a43ebc4`, `58b5c3365`): its apps compete for the front with the app from before the sleep, so
  they start 3 s after the wake and the launcher or that app comes back only when the user did nothing. To look at:
  `ColdStart: Wake autostart …` lines after a wake, nothing of it after a restart of the device.
