# Architecture

State of `a654c0d60` (2026-11-16, after round 16). Everything here was checked in the code [V] unless it is
tagged otherwise.
The reasons behind the design are in `DECISIONS.md`; this file says what exists and where.
Abbreviations used in paths below:

- `L/` = `app/src/main/java/com/android/launcher66/`
- `S/` = `L/settings/`
- `U/` = `app/src/main/java/com/syu/util/`
- `C/` = `app/src/main/java/com/fyt/car/`

The class Javadoc is the detailed reference; this file is the map.

## 1. Repository layout

| Path | What it is |
|---|---|
| `app/` | The launcher. Main code is under `app/src/main/java`: about 1,900 Java and 9 Kotlin files. |
| `app/src/system/AndroidManifest.xml` | The `system` flavor's manifest: `android:sharedUserId="android.uid.system"` and the launcher permissions it defines. |
| `app/src/{debug,release}/` | `LeakCanaryInit` (LeakCanary is debug only). |
| `app/src/main/assets/` | `canbus_library.txt`, `canbus_library_7870.txt` (the CAN bus libraries), `firenze.apk` (the skin package `SkinManager` opens), `litepal.xml`, `Can_Back.ogg`. |
| `app/src/main/generated/baselineProfiles/` | The committed Baseline Profile (`baseline-prof.txt`, `startup-prof.txt`). |
| `app/libs/cn.jar` | Kuwo auto SDK (`cn.kuwo.autosdk`), a prebuilt jar. |
| `baselineProfile/` | `:baselineprofile`: Macrobenchmark generator and startup benchmark (see its README). |
| `hiddenapi-stubs/` | `:hiddenapi-stubs`: compile-only stubs of hidden framework classes (`TaskStackListener`, `InputEventReceiver`, `InputChannel`). |
| `vdhost/` | The FYT VDHost: `shared/` (protocol and core), `server/` (the uid-1000 daemon and the Magisk zip task), `magisk/` (module template), `tools/` (pane leak scripts). See `vdhost/README.md`. |
| `canbus_library/` | `build_canbus_library.py` (+ a `.bat`): builds the CAN bus library from a decompiled `com.syu.canbus`. With `--launcher .` it rebuilds the two built-in assets from `archive/decompiled/`. |
| `android_jar/android-36.jar` | The Android 36 class library. **`:hiddenapi-stubs` and `:vdhost-shared` compile against it** (`compileOnly`), so it must stay at this path. |
| `archive/decompiled/` | Decompiled FYT apps and frameworks as zip files since the owner's `22490c9e0` (2026-11-21): `carinfo.zip`, `com.syu.canbus.zip` (three versions inside: `classes.dex`, `classes.dex.new`, `classes.dex.7870`), `com.syu.media.zip`, `com.syu.radio.zip`, and the frameworks `7862/system.zip`, `7870/system.zip`, `7870/system_ext.zip`. **Reference only, not in the build.** Read a file with `unzip -p <zip> <path>`. The folders `decompiled_*` are gone, so `canbus_library/build_canbus_library.py --launcher .`, which reads `decompiled_carinfo` and `decompiled_com.syu.canbus`, needs them unpacked first (KI-49). |
| `archive/fuel_stats_example/` | Four decompiled example classes that `README.MD` links to. |
| `archive/android_jar/` | The two `.rar` archives of the modified-`android.jar` workflow, obsolete since 1.1.7 (README). |
| `images/` | README screenshots and videos. |
| `.github/workflows/` | `build.yml` (CI), `release-assets.yml` (legacy updater asset names). |
| `claude/` | Documentation for Claude sessions (this folder, lower case). |

The decompiled FYT framework (`decompiled_FYT_jars/`, three zips) was removed from the tree in `8bfc5a8d` and is
back since `22490c9e0` as `archive/decompiled/7862/system.zip`, `7870/system.zip` and `7870/system_ext.zip`. Several
briefs and chat reports cite files inside it under their older paths.

## 2. Build

- **Modules** (`settings.gradle.kts`): `:app`, `:baselineprofile` (folder `baselineProfile`), `:hiddenapi-stubs`,
  `:vdhost-shared` and `:vdhost-server` (folders under `vdhost/`).
- **Toolchain** (`gradle/libs.versions.toml`): AGP 9.3.2, Kotlin 2.4.10, KSP 2.3.11, Gradle 9.8.0, JDK 21
  (foojay toolchain), compileSdk 37, targetSdk 36, minSdk 26.
- **Flavors** (dimension `device`):
  - `system` is the default. It runs as uid 1000 and installs only where the firmware has the matching
    platform key (FYT units and some custom ROMs).
  - `standard` (called "phone" up to 1.2.1) installs anywhere.
  - Only the manifest differs between them; the code is the same.
  - The flavor is read at runtime only in `VersionChecker`, `CrashLogger` and the Shizuku download button [H].
- **Build types:**
  - `release`: R8 minify and shrink, `proguard-rules.pro`, `IS_DEBUG_FEATURES_ENABLED=false`.
  - `debug`: LeakCanary, coverage, no Baseline Profile.
  - The Baseline Profile plugin adds `nonMinifiedRelease` and `benchmarkRelease`; its other variants are
    disabled.
- **Version:** `versionName` is set by hand (now `1.2.1`). `versionCode = major*10000 + minor*100 + patch`.
- **Compile-only jar:** `:hiddenapi-stubs` and `:vdhost-shared` take the public Android classes from
  `android_jar/android-36.jar` (`compileOnly(files(...))`). Without the file at that path the build fails.
- **Signing:** both debug and release use `app/keystore.jks` with the public `android` alias and password
  (overridable through `keystore.properties`). This key is the AOSP test platform key that FYT firmware is
  signed with, which is what lets the `system` flavor be uid 1000 (README) [H].
- **CI** (`build.yml`), on every push: `:app:testSystemDebugUnitTest`, `assembleSystemDebug`,
  `assembleStandardDebug`, `:vdhost-server:magiskZip`; it uploads the APKs and the module.
  `release-assets.yml` copies `system_release_<v>.apk` to `update<v>.apk` and `fyt_release_<v>.apk` so that
  the updaters of ≤1.2.1 still find their file.

### Dependencies actually used

Glide, OkHttp, LitePal, Flexbox, Material, Ackpine (the updater's installer), coroutines, Play services
location (as a fallback only), Shizuku, profileinstaller and LeakCanary (debug). Room and Compose were declared but never
imported; they were removed on 2026-11-12 (`KNOWN_ISSUES.md` KI-03). KSP remains for Glide only.

## 3. Process and privileges

- `L/LauncherApplication` starts the process in this order:
  - `CrashLogger` first;
  - StrictMode (on in release);
  - `WakeDetection` (lives as long as the process);
  - the skin (`firenze.apk` is copied from the assets into the files directory);
  - LitePal.

  `isFytDevice()` lives here. The wallpaper picker runs in its own process, `:wallpaper_chooser`.
- **Platform identity:** `L/DeviceIdentity` and `L/FytPlatform` work out the chipset once from
  `ro.fyt.platform` (6318 = 7870, 6315 = 7862, 6316 = 8581, 6521 = 9853i) plus fallbacks, and remember it.
  `L/PinnedPip.supported(chipset)` gives pinned PiP to every FYT platform except the 7870. Music sources
  are chosen by **package**, not by chipset (`C/StockSources.isSyuMediaUnit()`). See `DECISIONS.md` D-03.
- **Privilege tiers:**

  | Tier | When | What it can do |
  |---|---|---|
  | System app | `system` flavor, uid 1000 | everything, inside the launcher process |
  | VD host daemon | `standard` flavor + FYT VDHost Magisk module, uid 1000 | virtual displays and input injection, compilation, full logcat, boot autostart, foreground app, permission grants, file reads |
  | Shizuku | `standard` flavor + Shizuku, uid 2000 | the same as the daemon minus what shell cannot do: secure video, protected broadcasts |
  | None | `standard` flavor alone | no multiple PiPs, no swipe area, no autostart, no full logcat; everything else works |

  - The host is chosen by `U/WindowHostVdClient`, and `U/HostAwait` waits for a host that is on its way.
  - The protocol is `vdhost/shared/.../VdHostProtocol` (`VERSION = 3`, `MIN_VERSION = 2`). The errands are
    in `HostServices`, and `HostFilePolicy` limits `readFile`. The table of what each host can do is in
    `vdhost/README.md`.
  - `readHomeWallpaper` (2026-11-13) is a new transaction added **without** a new protocol number or module
    version (`DECISIONS.md` D-53): a host that does not know it answers nothing and the launcher goes on to
    its next way of getting the wallpaper. Where the shell cannot open the file (Shizuku), the host asks the
    wallpaper service itself (`WallpaperServiceCall`, 2026-11-15); whether Android 16 allows it is [U].
- **FYT firmware code** (`com.syu.*`, decompiled) runs behind the fuse `S/FytCompat`: a
  `RuntimeException`/`LinkageError` is logged and written once to `compat_pid_<time>.txt` instead of crashing.
- **`S/CrashLoopGuard`:** three crashes within two minutes make the next start a safe one, without custom
  elements, panes or the stats window.

## 4. Home screen

- **Core** (AOSP Launcher3-era, heavily changed): `L/Launcher` (the activity, 9.5k lines), `L/Workspace` (8.6k),
  `L/PagedView`, `L/CellLayout`, `L/DragLayer`, `L/Folder`, `L/AppsCustomizePagedView` (all apps).
- **Model:** `L/LauncherModel` loads on a single worker thread (`LoaderTask`) and binds through callbacks.
  - `L/WorkspaceLoadWatch` is the watchdog: a load that stops binding is started again, and a skipped
    reload is kept (rule R1, 2026-11-08).
  - Every load is numbered and logged (`Loader <id> started (<reason>)`).
- **Pages:** `L/WorkspaceScreenPlan` (plain Java) decides which pages exist and where each custom element
  lives.
  - Page 1 is the *user page*, with the bars. It is not in the screens table.
  - Empty pages that nothing asks for are removed, and the page numbers saved in the preferences follow.
- **Grid** (2026-11-13, `DECISIONS.md` D-52):
  - `L/WorkspaceGrid` (plain Java) is the grid of a page: the rows and columns the user chose, stored as
    cells along the long and the short edge of the screen (default 10 × 6, each from two below to four
    above), one column fewer on a page with the vertical bar and one row fewer on a page with a horizontal
    bar that does not hide. The bars' strips are cut out of the page and the cells share the rest.
  - `S/WorkspaceGrids` builds it from the settings for the first page or for the others; the page
    (`CellLayout.useWorkspaceGrid`), the loader (`LauncherModel`) and the settings ask there.
  - `CellLayout` keeps its children at the whole page, from the page's corner. Only the cells start beside
    the bars and are centred in what the bars leave (`WorkspaceGrid.firstCellX`, an offset in
    `ShortcutAndWidgetContainer` set from the page's measure). The bars and the elements placed by pixels
    are not moved by it (until 2026-11-15 every child was moved by half the leftover pixels).
  - The creator's elements take their cells (`CellLayout.handleConflictingViews` moves what lies there), except
    the statistics window's placeholder, which only says where the window lies (`CustomElement.takesCells`,
    D-65). After a load, every drag and every resize each page moves an item that does not lie wholly in its
    grid or that shares a cell with another (`L/PageFit`, `L/CellOverlap`: icons stay, widgets move; KI-37;
    KI-39, closed 2026-11-16). The creator's elements are shown wholly in the page (`PageFit.intoBox`); the box measured last is
    kept per orientation for the time before the launcher has measured one (`S/HorizontalBarDimensions`).
    Outside a reorder an item's temporary cell is its cell (`CellLayout.LayoutParams.setCell`). A drop asks at most for the size an item has and takes no area of size 0
    (`L/DropSpan`). The loader shows an icon whose activity can be started as the list of apps finds it, and
    mends one whose app renamed its first activity (`L/ItemValidity`).
  - `L/IconFit` (2026-11-15): an icon is made smaller where a denser grid leaves its cell too small for it
    with its label, never larger; one size for all pages of an orientation, the standard one at 10 × 6.
  - `L/GridOverflow` (plain Java) says where items go when the grid of their page changes; the loader runs
    it once per change, before it reads the items (`LoaderTask.arrangeItemsForGrid`). An item keeps its
    place on the screen, one without a cell gets the nearest free one, nothing is deleted, and a turn of
    the screen alone moves nothing (the grid the items were arranged for is stored per orientation).
  - The app drawer and the folders still take their grid from `L/DynamicGrid` / `L/DeviceProfile`.
  - `L/CellChildId` gives the views of a page ids outside the resource id range.
- **Start page:** `S/StartPageRule` (plain Java) accepts only a page that exists; the screen plan resets a
  stored number that names none.
- **Taps on the widgets:** `L/WidgetLaunchRule` decides what a tap on the radio (and the other stock
  shortcuts) can start; the panes and the music are touched only when something starts.
- **Custom elements:** `L/CustomElement` lists the nine elements: the date, music and radio widgets, five
  PiP placeholders and the stats placeholder. Their on/off defaults live only there;
  `L/CustomElementPrefs` reads them.
- **Layout fitting:**
  - `S/Helpers` applies the layout when the settings are left.
  - `S/CustomLayoutResolver` turns the user's rectangles plus the bars into the layout actually used. An
    overlapping element is moved, then cut, then reset (rule R3: touching edges do not overlap,
    `S/RectOverlap`).
  - `S/PipEdgeTrim` and `S/StatsBarFit` handle the bars.
  - `L/CustomLayoutDb` and `S/WorkspaceOccupancy` know which grid cells hold icons and widgets.
- **Startup:** `L/StartupSteps`, `L/WorkspaceScreensPreload`, and `L/ColdStart` (the about 10 s boot stall,
  the launcher kept in front, the "Start on boot" apps; `ColdStart.startForWake` starts the "Start on wake" apps,
  see section 11). The screens' ids are read off the main thread at the start
  and kept in memory for every Workspace of the process, a launcher created again too; a write of their table
  (always through `L/LauncherProvider`) drops them and has them read again (`L/ScreenIdsMemory`, pure, tested).
- **A whole home screen** (2026-11-20, KI-43): `L/HomeIntegrity` (pure, tested) judges a snapshot of the views
  (the window's, the pages' and the hotseat's sizes, the bars' lists, the buttons, the creator's elements) and gives
  each fault a ladder of repairs; a part not ready yet (the binding, the bars' apps on their way, the elements on
  their way, the pages changing state) is waited for, not repaired. `L/HomeLayoutRecovery` opens an episode on an
  event (home press, resume, new intent, focus, configuration, a phase of a wake, the end of the binding, the bars'
  apps given, a change of the window's size) and judges after every pass of the window's layout until the home
  screen is whole or every repair was tried; no delays or retry timers.
- **Keeping the home screen in front:** `L/HomeFrontGuard` sends back only the app the device itself
  reopens after a wake or a boot, never one the user opened (`DECISIONS.md` D-28).
  - `L/DefaultDisplayTask` reads what is in front from the task stack of the default display.
  - User input is noted in `Launcher.dispatchTouchEvent`/`dispatchKeyEvent` and by `U/UserTouches`.
  - `S/ForegroundAppTracker` reports the app in front through a task stack listener (system privileges) or
    through the VD host.
- **Bringing the last app back** (when a "home screen on top" option is off): `L/ColdStart` records the last
  app on the main display (`noteForegroundApp`) and reopens it after a cold boot; `S/WakeDetection` does the
  same after a wake. The two settings are `Keys.LAUNCHER_HOME_WAKE` and `Keys.LAUNCHER_HOME_COLD_START`
  (D-30).
- **Navigation:** `U/FytPackage.resolveNavigationPackage()` returns the package `com.syu.ms` reports
  (`com/syu/car/CarStates.mNaviPkg`). The launcher never writes the system's navigation app (D-29).

### Round 28 additions to the home screen (2026-11-26)

- **Gestures:** `L/HomeGesture` (plain Java: UP, DOWN or NONE from dx, dy, time and speed), `L/HomeSwipe` (plain
  Java, since round 29: the course of one touch; it fires on the move that is long enough, a flick on the lift, and a
  touch that rested for the long press timeout is no swipe) and `L/HomeGestures` follow a touch for `Workspace`; UP
  opens the drawer (`Launcher.showAllApps(..., fromSwipe)`), DOWN asks
  `L/StatusBarPanel` for the notification shade (the accessibility service when the system service refuses).
  `L/DoubleTap` and `L/ScreenOffPlan` (plain Java) decide the double tap and what "Turn off screen" does on this unit;
  the accessibility service (`S/StateAccessibilityService.sInstance`) locks the screen, and `LauncherPermissionFlow`
  has a step `ACCESSIBILITY`.
- **Widgets:** `L/WidgetFrame` / `L/WidgetFrames` keep a freely placed widget as fractions of the page's content area
  (the file `widget_frames`); since round 29 ("Freeform widgets") `L/FreePlace` (plain Java) puts a dropped widget
  at the pixels it was let go, or at the nearest place over free cells, and `L/ResizeGeometry` (plain Java) keeps the
  resize frame round the widget; with "Allow widgets to overlap" a widget is placed by pixels too, nothing is pushed
  while it is dragged, and `L/PipEdge` (plain Java) moves one let go over a PiP edge to edge with it;
  `CellLayout.isPixelPlaced()` and `ShortcutAndWidgetContainer` lay out by pixels the
  elements of the user's layout and those widgets; with "Allow widgets to overlap" `CellLayout.takesCells()` is false
  for an app widget, `PageFit.toMove(..., widgetsMayOverlap)` and `L/GridRefit` handle the rest. `Folder` has its own
  background (`BarBackground.folders()`) and may follow the home screen's grid (`L/FolderGrid`), its icons then drawn as there
  (`L/FolderItemLook`, round 29: the page's icon size, the icon text colour and shadow).
- **Badges:** `NotificationListener` tells `L/BadgeModel`, which counts on a thread of its own (`L/BadgeCounts`, plain
  Java) and tells the views registered in `L/BadgeViews`; `L/BadgeDrawable` draws a badge in an icon's rectangle.
  Since round 29 its size is a slider of 15–35 % (`badges_size_percent`, `S/BadgeSizeSeekBarPreference`) of the icon
  as it is seen: `L/VisibleBounds` (plain Java) finds the opaque part of the picture, `L/IconBounds` keeps it per
  bitmap; `L/BadgeGeometry` has the rules (the number at 85 %, a wider badge grows towards the icon's middle).
- **"Stock layout"** (D-85): `L/CreatorKeys` (every key of the creator's XML, checked by a test) and `L/CreatorPrefs`
  (the read-only wrapper through which the launcher reads them) give the defaults while the creator is off.
- **Direct boot:** in debug builds only (`launcherDirectBoot` in `app/build.gradle.kts`, since 2026-11-26: the first
  version hung the A55 at boot) the launcher shows the wallpaper before the first unlock (`DirectBootPlan`,
  `DirectBootState`). Nothing may read storage when a class loads or in the Launcher's field initializers
  (`StorageAtClassLoadTest`, `LockedStartViewTest`). The package receiver no longer builds the launcher's state.

### The app drawer (round 28)

- `L/AppsCustomizePagedView` still holds the apps (`mAllApps` sorted, `mApps` what shows of them) and now also the
  widgets' pages. `applyFilter()` narrows `mAllApps` first by the tab (`DrawerTabs.appsOf`) and then by the search field
  (`L/AppSearch`, `L/AppSearchBar`); every change of the list goes through it.
- **Vertical by default:** `L/AppsVerticalView` (a `RecyclerView` in a `FrameLayout`, with the swipe that changes the
  tab) and `L/LetterScroller` (the handle and the bubble, `L/LetterIndex`; since round 29 the handle is the list's
  fraction of its way, `L/ScrollFraction`, and the scroller is hidden when the list does not scroll); the pager is the
  horizontal choice.
  An icon of the list is dragged through `AppsCustomizePagedView.beginVerticalDrag` (round 29, `L/VerticalDrag`),
  not through the pager's long-press checks.
  The grid is `L/AppsGrid` (plain Java) through `DeviceProfile.updateAllAppsGrid` and the keys `all_apps_grid_*`.
- **Tabs:** `L/DrawerTabs` (plain Java, tested: the rules of D-88), `L/DrawerTabsStore` (one string under `drawer_tabs`,
  read through `CreatorPrefs`), `L/DrawerTabGeometry` (plain Java: sizes and swipe decisions), `L/DrawerTabStrip` (the
  strip, in `apps_customize_pane.xml`, moved above or below the apps by `AppsCustomizePagedView.placeStrip`;
  `L/DrawerSpacing`, plain Java since round 29, gives one 8 dp gap between the search bar, the strip and the apps).
  `AppsCustomizePagedView.syncTabs()` reads the tabs when the drawer opens and when `Launcher`'s preference listener
  sees a key of the tabs.
- **Settings:** "App drawer" is a category of the creator's second screen. "Tabs" opens `S/DrawerTabsFragment` (the tab
  creator, one `RecyclerView` with the categories "Tabs" and "Miscellaneous"; the dragging as `S/BarOrderDialog`'s);
  `S/DrawerTabDialogs` has the add / edit / delete dialogs and is used by the drawer too; `S/DrawerAppsFragment` is the
  list of a tab's apps or of the hidden ones (`L/DrawerAppList` is its model), opened from the dialogs, or by itself from
  the drawer through `SettingsActivity` and the extra `DrawerAppsFragment.EXTRA_TAB`.
- **Not built (KI-52):** the widget list (`L/WidgetGroups` is its model), `L/BarShares` (the model of the widget bar's
  sharing of room) and the horizontal bar's switch.

## 5. Bars

- **Geometry** (pure, tested): `L/BarLayout` (one page's bars: the horizontal bar at the top or bottom, the
  vertical bar left or right, the corner, the insets) and `S/BarLayouts.of()` (reads the preferences once).
  `L/BarConstraints.apply()` rearranges an inflated layout: the bar to the top, the vertical bar mirrored to
  the right, with no extra XML. It also gives the first page's vertical bar the width the launcher counts
  with in place of the layout's share (of the bar's height in portrait, D-61; of the layout's width in
  landscape, since 2026-11-18).
- **Width of the vertical bar** (2026-11-18): `S/VerticalBarDimensions` (pure, tested) works out
  `Launcher.calculatedVerticalBarWidth`, the one width the grid, the panes, the statistics, the creators and
  the bar itself count with. Without "Resizable vertical bar" (or at the slider's default) it is the old 7.1 %
  to the pixel; with it, a share of the longer edge (4–10 %, per orientation, `S/VerticalBarWidthSeekBarPreference`).
  `Launcher.refreshVerticalBarWidth()` reads it again when the launcher is laid out, before it rebuilds after
  the settings, and when the settings change it. The bar's icons follow its width (`BarCapacity.leftIconSize`).
- **Content:** `L/LauncherAppBars` holds the apps of both bars. The lists are stored with LitePal:
  `com/android/recycler/AppMultiple` for the horizontal bar, `LeftAppMultiple` for the vertical bar. `L/BarCapacity` and `L/BarRows` handle slots and
  preloading. `L/BarIconCount` (2026-11-18, pure): with or without a bar's "Resizable" switch (2026-11-21), the
  user may choose how many icons it shows (1 .. what `BarCapacity` gives it room for, per bar and orientation; nothing chosen = as
  many as fit; a number above a newly smaller room is lowered and stored lowered). The settings work the room
  out live (`S/BarIconLimits`, `BarCapacity.leftCapacityFor`); the launcher counts with the room it measures.
- **Bar on every page:**
  - "Display horizontal bar" (round 29, `display_horizontal_bar`, a creator setting): off, `HorizontalBarPlacement`
    gives no bar and no reserved cell on any page, `Workspace.createUserPage` takes the layout without the widget bar
    and hides the bar's views, and `DrawerAccess` makes the swipe up the way to the drawer;
    `SettingsFragmentSecond.updateHorizontalBarRows` hides the bar's rows. "Hide the app drawer button"
    (`horizontal_bar_no_drawer`) and "Hide the music widget" (`widget_bar_no_music`): `WidgetBarLayout.applyShared`
    gives every element of the widget bar its width by `L/BarShares` (the button stays at no width, the music widget
    is gone), `WidgetBarLayout.applyPlain` gives the bar without widgets the button's room, `BarCapacity` counts the
    wider list, and a bar with nothing left turns "Display horizontal bar" off. Without them hidden the old path
    (`WidgetBarPlan.shares`) runs unchanged.
  - `L/HorizontalBarPlacement` and `L/VerticalBarPlacement` decide where each bar is drawn. A bar on every
    page is its window on every page, the first one too, moving or at rest (2026-11-16): the pages move
    under it and nothing is swapped while they move (`PersistentBarWindow.action`). With the vertical bar on
    every page and the horizontal one on the first page only, `L/VerticalBarCorner` keeps the vertical window
    at the whole height and the bar inside it leaves the corner to the first page's horizontal bar while that
    lies across its strip (an animated inset, touches there handed to the launcher's window).
  - `L/PersistentBarWindow` is the logic of the window that stays put while the pages move (pre-built, so
    showing it costs nothing); `L/VerticalBarWindow` is the vertical bar's window. Both windows stay while an
    app is in front (2026-11-16): the system hides and shows them with the launcher's window, as it does the
    panes, so nothing is built or swapped on a return.
  - `L/BarWindows` (2026-11-16): the bars' windows, the auto-hide bar's and the edge handle's are sub-windows
    of the launcher's window (through the activity's window manager): under every floating button and
    overlay, no permission to draw over other apps needed (D-64). Layers from the bottom (2026-11-18): the
    panes of the PiPs (panels), the statistics window on the home screen (`BarWindows.HOME_STATS_TYPE`, a
    sub-panel added by `CanbusService.addHomeStatsWindow`), the bars on every page (`EVERY_PAGE_TYPE`, the
    layer above sub-panels, falling back to lower layers if refused); the auto-hide bar and the edge handle
    are panels. The statistics over an app stay an overlay. On Android 10 and older `L/ImeAnchor` (round 29) is
    the top of those layers: a one-pixel window that may take the input method, added again after every bar and the
    statistics window, so the keyboard (drawn above its target window) is above all of them.
  - `L/PageBarSwap` (2026-11-15): while a bar's window is shown, the first page's own bar is hidden; it is
    hidden from the moment the page is built (the windows are built in the page's first frame) and seen
    only while the window steps aside (overview, drag, folder, all apps) or could not be added. A swap
    happens only then, at rest: the page's bar is shown first, the window goes after the page has drawn
    it, and back the other way; at once both ways while the launcher is not in front.
  - `L/BarGhostRule` and `L/PageBarGhost`: while the bars' windows step aside and the pages are seen (the
    overview, a drag of any kind, an open folder, the list of apps of a bar; 2026-11-19 also at full size) every
    page after the first draws a recording of the bars' windows in their strips (`Canvas.drawPicture`, no bitmap on
    Android 9+). `L/BarSwipeFrame` feeds a swipe on a bar's window to the pages and logs when they take it.
  - `L/PageBox` and `L/TopBarFrame` keep the windows on the page's box, below the status bar and the
    cut-out. The box is taken from a page **at rest** (`PageBox.pageRestLeft`), never from the pager's own
    edge: the pager is measured much wider than the screen and centred, so its left edge is thousands of
    pixels off screen (the cause of the vertical bar's window on the wrong side, fixed 2026-11-13).
    `L/VerticalWindowFrame` trusts the measured bar only when it lies inside that box.
- **Backgrounds** (2026-11-13): `L/BackgroundChoice` (a picture by name, the user's own colour, or none),
  `L/BarBackground` (the one resolver for the first page's bars, both windows, the widgets, the stats window
  and the creators), `L/BackgroundAngle` + `L/RotatedDrawable` (the picture turned for the side the bar is
  on; the view is not turned), `L/RoundedColorDrawable`. The bar backgrounds are part of the live look
  (`WidgetStyler.isLookSetting`, `Workspace.applyBarBackgrounds`).
- **Auto-hide and the edge handle:**
  - `L/HorizontalBarEdgeHandle` is the window, on the left or right edge.
  - `L/HorizontalBarEdgeGesture` recognises the inward swipe; `L/EdgeHandleGeometry`, `L/EdgeHandleInput`
    and `L/EdgeHandlePass` do the rest.
  - On Android 10 system units the handle window takes no touches. `L/EdgeSwipeMonitor` and
    `L/EdgeMonitorTracker` watch an input monitor and pilfer only the opening swipe.
- **Widget bar** (the music widget on the horizontal bar): `L/WidgetBarLayout`, `L/WidgetBarPlan`,
  `L/WidgetBarLines` (four arrangements: two lines either way round, or one line either way round).
  `L/MarqueeRestart` keeps the title scrolling in whichever of the two bars is bound.
- **The order of the horizontal bar's elements** (2026-11-20): `L/BarOrder` (pure, tested) holds the order per
  orientation, what is shown and how each element is tied; `L/BarOrderLayout` ties the elements of the page's bar
  (`Workspace.createUserPage`, after `WidgetBarLayout`) and of the bar's window (`Workspace.forceOriginalSizes`,
  after the sizes) from that one source. `WidgetBarLayout` only widens the music widget.
- **The apps list fitted or hidden** (2026-11-21, D-80): `L/WidgetBarPlan.shares` (pure, tested) gives every
  element's width share: the list fitted to its icons (`appsShare`: usual × shown / room) or hidden (`appsHidden`:
  only in the user layout's widget bar), its freed room 10% to the date, 10% to the weather, the rest to the music.
  `L/WidgetBarLayout.shares` counts the icons as the launcher does and feeds the page's bar, the window
  (`forceOriginalSizesLayoutTwo`) and the music cover (`MusicWidgetSizer`). The portrait list and weather keep the
  height of their usual width (`keptRatio`). A fitted tile keeps its width at the maximum (`BarCapacity.bottomTiles`,
  `AppListAdapter`). A hidden list is GONE; every place that shows the list again asks
  `WidgetBarLayout.appsListVisibility`, and `HomeLayoutRecovery.snapshot` does not judge it.

## 6. Layout creator

- `S/CreatorScreen.newInstance(page)` + `S/DrawViewScreen` is one creator for every page (since 2026-11-08).
- `S/CreatorPage` is the pure description of a page; `L/CreatorBars` and `S/CreatorBarMarks` draw the
  bars as they look on the home screen.
- `S/CreatorAppStats` + `S/DrawViewAppStats` is the creator of the stats window **over other apps**. It
  shows the bare screen, without the launcher's bars, because no bar is there when the window is shown.
  (The stats window of the home screen is placed in the page creator above.)
- `S/RectangleTouchHelper` and `S/GridGeometry` handle touch and the grid.

## 7. PiP panes

- **Owner:** `U/WindowHost` belongs to one `Launcher` instance and is never static. `U/WindowHostSinglePane`
  and `U/WindowHostDualPane` (`U/DualSplitBounds`) build on it, `U/WindowUtil` moves and removes panes, and
  `U/PaneWindows` handles the pane windows.
- **Backends:**
  - Android 8–10 as a system app: `U/WindowHostActivityView`, the framework's hidden ActivityView, unmodified
    by FYT. Helpers: `U/WindowHostReparenter`, `U/WindowHostAvReaper` (frees retired displays), and
    `U/WindowHostSplash`.
  - Everything else: `U/WindowHostVdView`. A VirtualDisplay renders into the pane's `SurfaceView`, touches
    are injected, and apps start with `setLaunchDisplayId`. Created through the VD host
    (`U/WindowHostVdDisplay`, `U/WindowHostVdProvider`, `U/WindowHostVdShizuku*`).
- **Lifecycle rules:**
  - On a configuration-change recreation, the panes are handed over to the new activity (`panes handed over`).
  - An app opened full screen comes back to its pane as it is. `U/PaneLaunchFlags` starts a pane's app with
    `NEW_TASK | RESET_TASK_IF_NEEDED` only, as the home screen does.
  - Panes start one after another: the next one when the previous one is drawing, the visible page first.
  - Panes wait for a VD host that is still attaching (`U/HostAwait`).
  - `U/PaneYieldWatcher` removes the panes when HiCar or the 360° camera comes to the front on a non-system
    launcher.
  - While the pages move, pane windows are moved with a budget on Android 14+ (`U/PaneWindows`), where
    window relayout is asynchronous.
- **Pinned PiP:** `L/PinnedPip`, `U/PinnedPipLaunch`, `L/LauncherPipStarter`. `L/PinnedPipFocus` is a 1×1
  overlay that takes the input focus so the launcher gets the keyboard beside the pinned PiP (D-44; the
  owner confirmed it on 2026-11-12).
- **Extras:** floating app-switch buttons in `S/FabOverlayService`; the status-bar swipe area in
  `S/StatusBarSwipeDetector` (system only; its window lies on one thread of its own for the whole process).

- **App widgets:** `L/LauncherAppWidgetHostView` applies the content off the main thread; a widget whose
  content fails shows its preview and opens its app on a tap, and `L/WidgetRecovery` says how its app is asked
  to send it again (options change always; APPWIDGET_UPDATE as the system or through a root host, D-66).
  A widget's configuration screen is opened by the system for the launcher as the widget's host
  (`Launcher.startWidgetConfiguration`, `L/WidgetConfigure`, 2026-11-19), so a screen its app does not export
  opens too; if it cannot, a widget with optional configuration is added without it, any other is not added.

## 8. Media widgets

- **Views:** `L/LauncherMusicWidget`, `L/LauncherRadioWidget`. Sizing and text: `L/MusicWidgetPlan`,
  `L/MusicWidgetSizer`, `L/MusicWidgetText`, `L/RadioWidgetPlan`, `L/RadioWidgetSizer`. Look:
  `L/WidgetStyle` + `L/WidgetStyler` + `L/ViewTint`. Colors are view tints, never color filters on shared
  drawables (rule R2, 2026-11-08). Since 2026-11-13 the tint is any colour or none ("Default"), chosen in
  `L/colorpicker/ColorPicker` (a text mode, and a background mode with an alpha slider; `L/ColorAlpha`).
- **Any player:** `L/NotificationListener.kt` (media sessions) and `L/MediaTransportController`. With no
  cover the player's app icon is shown; with no session a widget button opens the last player.
  `L/TitleTag` (2026-11-15) says whether a title or an artist is a value or a placeholder ("Unknown",
  "<unknown>", "null", empty: whole values only). `L/PlayPauseRequest` (2026-11-15): a tap's symbol is shown
  at once on both play/pause buttons and kept until the player answers or 2 s pass; a second tap meanwhile
  is not taken.
- **Sound channel:** `com.syu.ms` switches the MCU's sound channel when a media app comes up (1 radio,
  3 Bluetooth, 8 FYT music, 10 third party; on the 7870 also 7 internet radio). `NotificationListener.kt`
  restores the channel that was playing after the panes start their apps, unless the user tapped something.
  Taps on panes are seen through `U/UserTouches`, a system-wide input monitor (D-31).
- **FYT stock sources:**
  - `C/StockSources` decides which source is shown: `com.syu.music` on 7862/8581; `com.syu.media` music,
    online radio and BT on 7870; the radio on both.
  - The other pieces are `C/MusicService`, `C/StockRadioSource`, `C/StockBtSource`, `C/SyuMediaClient` and
    `C/SyuMediaFiles` (covers read directly or through the host).
  - The 7870's covers and position (2026-11-21): `C/StockBtCover` says when BT's cover file is this song's (the
    first song after a start takes any file, a cleared title is the same song, the change kept on the elapsed
    clock); `L/FileCover` reads a file's picture with `MediaMetadataRetriever` and `L/FileCoverRetry` reads once more
    a file that could not be opened; `L/PausedCover` keeps the cover drawn in a pause and on a widget built again.
    `L/PositionSlider` (D-81): the home widget's `music_position` slider, on every unit since 2026-11-22, in one
    of three modes: SEEK (a knob; com.syu.media's files move through `SyuMediaClient.seekTo`, IPlayer transaction
    12, and a session's own app through `MediaTransportController.seekToPosition` where its session has a length
    and `ACTION_SEEK_TO`, `canSeek`), SHOW (the position without a knob: BT, stations, a player that cannot seek)
    and GREY (empty: no length, or a live stream). `L/LauncherMusicWidget.canSeekNow` asks once per player, title
    and state, and logs `MusicWidget: slider <pkg> seek|show`; the thin `music_progress` stays in the layout,
    hidden.
- **Favorites (the heart):** `L/MediaFavoriteController`.
  - `com.syu.media` favorites are written to its library; FM favorites are read-only
    (`C/SyuMediaRadioFavorites`).
  - The like status comes from `S/SpotifyRating` (Spotify Web API, PKCE, a client ID the user enters, the
    refresh token in preferences) or `S/FytRating` (the separate *fYT Rating* app `vasyl.fytrating`; the
    launcher holds no Google credentials; `S/FytRatingBridgeStarter` starts it). `S/RatingReplyRule`
    handles a bridge that answers without a rating: its reason is logged and its wake activity is started
    once (`KNOWN_ISSUES.md` KI-32).
- **App widgets:** none of the launcher's own since round 28 (the four `com/syu/widget/Date*Provider` were removed);
  `com/syu/widget/` keeps `TimeUpdateReceiver` (it refreshes the clock and date views of the home screen) and
  `util/TimeUtil`. Widgets of other apps are hosted as always (`LauncherAppWidgetHost`).

## 9. CAN bus and fuel statistics

- **FYT IPC:** `com/syu/ipc` and `com/syu/module` (decompiled) connect to `com.syu.ms` over binder: modules,
  `DATA[]` codes, callbacks. The per-car callbacks are in `com/syu/module/canbus` (729 files), including the
  7870's own path (`com/syu/module/canbus/HandlerCanbus7870`).
- **Service:** `S/CanbusService`, a started (sticky) service; it does not call `startForeground`.
  - It reads the fuel, range, speed and RPM codes and draws the stats window over the home screen and
    chosen apps.
  - The current app comes from `S/StateAccessibilityService` or `S/ForegroundAppTracker` (through the host).
- **Library:**
  - `S/CanbusLibrary` reads the asset `canbus_library.txt`, or `canbus_library_7870.txt` on the 7870
    (format v4: each car's screen class, its requests, its fuel and range codes and its unit).
  - `S/CanbusLibraryImport` and `S/CanbusLibraryExport` import and export it.
  - `S/CanbusClasses` names a car's class without loading it.
  - The library is built by `canbus_library/build_canbus_library.py`.
- **Code reader:** `S/CanbusRecorder` records every code, then `S/CanbusCodeEstimator` and
  `S/ReaderGuesses` guess what the codes mean. `S/CanbusFrames` decodes raw CAN-box frames.
  `S/CanbusCodeInspector` is the passive inspector.
  - `S/CanbusAutoCheck` runs the reader once per car while driving.
  - Files go to `Download/Launcher66_Canbus`.
- **Estimate** (where the car gives no value): `S/FuelModel` (v3, power-based), `S/FuelSpeedThreshold`,
  `S/RoadGrade`, `S/FuelUnit`, `S/ConsumptionUnits`. Shown only with "Estimate below the car's threshold"
  (`fuel_estimate`, a creator setting, off by default since round 29: `FuelModel.setEstimateOn`, read by
  `CanbusService.showFuelEstimate`); the model learns either way.
- **GPS** (2026-11-20): `S/LocationNeed` (pure, tested) says how often the service asks for it: none on a unit without
  a canbus or when nothing needs it, every 5 s while only a drive has to be seen (the code check waiting, the pair of
  codes counting its driving time), every 0.5 s for the estimate's speed or altitude, the scale of the speed code and
  the code check's start and recording. `CanbusService.updateLocationNeed()` follows every change of those.
- **Stats window:** `S/StatsWindowSize`, `S/StatsOverlayAlpha` (full alpha through the host; the window is
  laid out again whenever the limit reaches 1 after it was laid out under less, `needsRelayout`),
  `S/StatsBarFit` (the bars move the window, never resize it).
  - `S/StatsWindowRule` (plain Java, 2026-11-13) says which window may be shown: the home screen's only
    while the launcher is in front, an app's only over that app. `CanbusService` removes a window that
    does not belong to what is in front (`onLauncherStopped`, `enforceWindowOwner`).
  - Its background is a `BackgroundChoice` like the widgets'; `S/StatsBackgroundMigration` turned the old
    six settings into it once.
- **Background** [H]: newer `com.syu.canbus` builds shift the `DATA[n]` indices (+11 for the PSA family).
  `claude/prompts/archive/analysis/canbus-app-comparison-2026-10-30.md` has the details.

## 10. Night mode, location and weather

- **Night mode:** `S/NightModeService` (`S/DayNightMode`); `S/SunTask` (sunrise and sunset from
  api.sunrise-sunset.org, with a fallback); `S/DayNightBrightness` (a minimum night brightness on the 7870);
  `S/HeadlightNightMode`. It changes the wallpaper and brightness, not the system dark mode. The launcher
  declares `uiMode` so that it is not recreated.
- **Reading the wallpaper** (2026-11-13): `S/HomeWallpaperSource` is the one place; `S/WallpaperAccess`
  (plain Java) lists the ways worth trying on a device, in order: the system's API where it gives the real
  picture, then the privileged host, then no picture (the colours, and the user picks an image). Used by
  the background selectors and by "Save the day / night wallpaper". Since 2026-11-15 a copy of every wallpaper
  the launcher sets itself (`S/OwnWallpaperCopy`, valid while the system's wallpaper id is unchanged) comes
  after the system's API; "Pick wallpaper" opens the settings' picker (`S/WallpaperPickerLauncher`), and a
  mode without a saved picture leaves the wallpaper (`S/NightWallpaperRule`). From 2026-11-16 the permission
  flow (`L/LauncherPermissionFlow`, step `ALL_FILES`) asks for access to all files on Android 13+, which the
  system API needs for the picture: through the host's `allowAppOp`, else on the screen of Settings.
- **Diagnostics added 2026-11-15:** `L/HiddenApiProbe` (one compat report when a hidden member the launcher
  looks up is missing; system flavour) and `L/PinnedPipHealth` (a log line when a pinned app keeps coming
  to the front).
- **Location:** `S/DeviceLocation`. The platform location comes first; Play services (`S/GmsLocation`) is
  used only as a way out (`S/LocationChoice`).
- **Weather:** `com/syu/weather/WeatherManager` (OpenWeather), `L/LauncherWeather`, `L/WeatherNeed`. It
  stops while no weather is shown. The API key and exact coordinates are redacted from the logs.

## 11. Wake, sleep and boot

- `S/WakeSignals` merges every signal into one state: ACC from `com.syu.ms` (`U_ACC_ON`), the display state,
  screen broadcasts, unlock, dream, a poll, CPU suspend and a process restart. FYT's black screen
  (`U_BLACK_SCREEN`) is neither a sleep nor a wake. It raises `onMcuOff()` when the MCU goes off.
- `S/WakeDetection` acts on that state for the whole process: logcat, home in front, panes, the last app.
  `S/WakeDetectionService` only keeps the process alive.
- "Start on wake" (2026-11-22, D-83): after a real wake (not a process start, `WakeSignals.RESTART`)
  `WakeDetection.onWake` plans `L/ColdStart.startForWake` 3 s later (`postForGeneration`, so a new sleep cancels
  it). Its thread starts the apps of `S/AppListAutostartDialogFragment`'s list `wake_autostart_packages` 3 s apart
  (Display Media Titles and JamesDSP by their broadcasts without BOOT_COMPLETED, the others by their launch
  activity), checking before each that the unit is still awake. `S/WakeAutostartPlan` (pure, tested) says what
  comes back to the front after the last one: the launcher (home on wake, or home in front before the sleep), the
  app from before the sleep, or nothing when the user did something or none of the started apps is in front. The
  same dialog edits both lists (its argument names the list); the Unisoc power sync releases the apps of both.
- At sleep the launcher comes to the top 300 ms after ACC off, so that `com.syu.ms` finds the launcher on top
  when it notes its "top app" at MCU off (D-28).
- `L/LauncherWake` and `L/UnisocPowerWhitelist` are the other pieces. `L/SysCalls` keeps calls into
  `system_server` off the main thread, because this ROM stalls them for seconds at boot.
- `com/syu/car/CarStates` holds what `com.syu.ms` reports (ACC, MCU, the sound channel, the navigation
  package).

## 12. Diagnostics

- **Logcat:** `S/LogcatWorker` is the capture engine.
  - Captures fall back to private storage until shared storage is mounted.
  - File names come from `S/LogFileName`, e.g. `reboot_full_<time>.txt`.
  - The rest: `S/LogcatDefaults` (off in release, on in debug), `S/LogClockShift`, `S/MainStallPlaces`,
    `S/LogcatStopButton` (an overlay stop button).
  - The full log needs uid 1000 or a host (`S/HostProcess`).
- **Reports** in `Download/Launcher66_Logs`: `crash_pid_<time>.txt` (`S/CrashLogger`) and
  `compat_pid_<time>.txt` (`S/FytCompat`).
- **Debug only:** `L/MediaDebugDump.kt`, `L/MemoryTracker`/`L/MemoryDumpActivity`, LeakCanary.

## 13. Settings, updater, skins, performance

- **Settings:** `S/SettingsActivity` with `S/SettingsFragmentFirst` and `S/SettingsFragmentSecond` (2.1k and
  2.6k lines), the preferences in `res/xml/`, and many `S/Custom*Preference` classes. `S/Keys` holds the
  preference keys; their stored values are kept across renames (`DECISIONS.md` D-09).
  - The second screen (reachable while the user layout is on) starts with "Home screen layout": the rows
    and columns sliders (`S/GridSeekBarPreference`), the start page and the two icon text sizes
    (`S/IconTextSizeRows`).
  - Since round 28: one accent colour for the settings (`L/ThemeAccent`, `L/AccentPainter`: every row as it is
    attached, every switch, the dialogs; the colour is the user's only with the creator on), and the screens that are
    not preference lists (`S/DrawerTabsFragment`, `S/DrawerAppsFragment`, `S/NotificationBadgesFragment`'s rows) use
    `AccentPainter.attach` too; `S/SettingsSystemBars` gives a screen of that kind the room of the system bars.
  - Since round 29: a row that is off is drawn at 38 % (`S/SettingsRowDim`), applied on every bind by
    `S/DimmingPreferenceAdapter`, the adapter of the three preference screens (`S/CustomPreferenceColorAdapter` of
    the first screen extends it). The theme's text colours have no disabled state, so nothing else dims a row.
  - Since round 29 "Settings text size" (`S/SettingsTextScale`, plain Java; the slider `S/SettingsTextScaleSeekBarPreference`,
    the first row of "Layout"): `SettingsActivity.attachBaseContext` multiplies the activity's font scale by it (on FYT
    units only the font scale is overridden), `SettingsActivity.withoutTextScale` gives the creator's screens their
    scale back, and above 100 % `S/DimmingPreferenceAdapter` lets every title and summary wrap without a limit.
  - Small pieces: `S/ButtonTextFit` (the text of the small buttons in a row), `S/CompatInfoText` (FYT-only
    lines of two info texts), `S/BackgroundSelectorDialog` with `S/ColorTileDrawable` and
    `S/SelectedFrameDrawable`, `L/FabButtons`.
  - The list's place (2026-11-18, D-73): `S/SettingsScrollMemory` (pure) and `S/SettingsScroll` keep it while a
    row's window is in front and give it back to the new screen before its first layout. The rows that size their
    own buttons do it when bound, before their first measure (`S/SettingsRowSizing`, 2026-11-19), so a row coming
    in at the top while the list is scrolled up does not push it.
  - The dialogs (2026-11-20, D-78): `S/SettingsDialogs` gives every one of them the theme `SettingsDialog`, the
    settings' dark colours, and the fields their colours. The order of the horizontal bar's elements is
    `S/BarOrderDialog` (a row in "Bars", a list dragged with `ItemTouchHelper`).
  - A turn of the screen (2026-11-21, D-82): on a phone `SettingsActivity` is created again for each orientation.
    `S/SettingsDialogMemory` (pure) and `S/DialogTurn` bring an open plain dialog back on the new screen with its
    fields' texts (each screen's `TURN_DIALOGS`); `S/HandedWork` (pure) hands a download, a wallpaper save or a
    canbus import to the new screen with its progress dialog; `S/ColorPickerTargets` binds a colour picker that came
    back; `S/CenterCrop` / `S/CenterCropDrawable` draw the background selector's wallpaper without stretching, and
    the selector is sized from the settings' window.
  - The rows (2026-11-20, D-79): a nested row keeps its 16dp under the text on the row itself, with or without a
    summary, so a divider below never sits under its title; "Bars" has three sections with a divider between.
- **Updater:** `S/VersionChecker` reads `github.com/vasyl91/FYT-Launcher-Mod/releases/latest`, downloads
  `system_release_<v>.apk` or `standard_release_<v>.apk`, and installs it with Ackpine. `S/ReleasesPage`
  copies the link when there is no browser.
- **Skins:** `com/fyt/skin/` (`SkinManager`, `SkinFactory`), FYT only.
- **Performance:** `L/perf/BaselineProfileCompiler.kt` compiles the launcher with its profile:
  - 90 s after a new APK's first start;
  - then after 3, 14 and 30 days, once there have been enough sessions.

  It does this itself as uid 1000, or through the host.

## 14. Data storage

| Store | Where | Holds |
|---|---|---|
| SQLite `launcher66.db`, version 15 | `L/LauncherProvider` | favorites (icons, folders, widgets) and screens |
| LitePal `yl_ui66`, version 1 | `assets/litepal.xml`, `com/android/recycler/AppMultiple`, `LeftAppMultiple` | the apps of the horizontal and vertical bars |
| SharedPreferences | `S/Keys`, `res/xml/*preferences*.xml` | all settings, rectangles, CAN codes, Spotify tokens, session counters |
| Asset libraries | `assets/canbus_library*.txt` + a user import | per-car CAN data |
| Files | `Download/Launcher66_Logs`, `Download/Launcher66_Canbus`, app files dir | logs, reports, reader output, the skin APK, the icon disk cache (`L/AppIconDiskCache`) |

There is no server and there are no user accounts.

## 15. External services and apps

| Service | Used by | Notes |
|---|---|---|
| api.openweathermap.org | `WeatherManager` | the key is a constant in the source, by the owner's decision (D-26) |
| api.sunrise-sunset.org | `SunTask` | |
| accounts.spotify.com, api.spotify.com | `SpotifyRating` | OAuth PKCE, no client secret |
| github.com releases | `VersionChecker`, `FytRating` (the bridge's release page), Shizuku Next link | |
| fYT Rating app (`vasyl.fytrating`) | `FytRating` | intents; owns the Google account |
| Shizuku | VD host path | `rikka.shizuku` provider |
| FYT system apps: `com.syu.ms`, `com.syu.canbus`, `com.syu.media`, `com.syu.music`, `com.syu.radio` | IPC, widgets, fuel statistics | decompiled copies in the zips of `archive/decompiled/` |

## 16. Cross-cutting rules

- No main-thread I/O; StrictMode runs in release too.
- No arithmetic on `R.*` ids (`ResourceIdArithmeticTest`), and no resource ids in `switch`/`case`.
- `L/Launcher` keeps delegates for the ten helper classes split out of it (`LauncherWeather`,
  `HomeLayoutRecovery`, `LauncherWake`, `LauncherPipStarter`, `LauncherPermissionFlow`, `LauncherFab`,
  `LauncherAppBars`, `LauncherMusicWidget`, `LauncherRadioWidget`, `LauncherWallpaperPicker`; D-36).
- Logic in plain Java classes with JUnit 5 tests (110 test files under `app/src/test/java`, 1011 tests).
- Rules R1–R3 (2026-11-08) are written in the Javadoc of the classes that enforce them:
  - R1 in `WorkspaceLoadWatch` and `LauncherModel`;
  - R2 in `WidgetStyle`, `WidgetStyler` and `ViewTint`;
  - R3 in `RectOverlap` and `DrawViewScreen`.
- 59 string resource files (`res/values*/strings.xml`).
