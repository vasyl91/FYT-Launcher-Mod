# Architecture

State of `ee8e4f91` (2026-11-12). Everything here was checked in the code [V] unless it is tagged otherwise.
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
| `archive/decompiled/` | Decompiled FYT apps: `decompiled_carinfo`, `decompiled_com.syu.canbus` (three versions: `classes.dex`, `classes.dex.new`, `classes.dex.7870`), `decompiled_com.syu.media`, `decompiled_com.syu.radio`. **Reference only, not in the build** (about 300 MB). `canbus_library/build_canbus_library.py --launcher .` reads the first two. |
| `archive/fuel_stats_example/` | Four decompiled example classes that `README.MD` links to. |
| `archive/android_jar/` | The two `.rar` archives of the modified-`android.jar` workflow, obsolete since 1.1.7 (README). |
| `images/` | README screenshots and videos. |
| `.github/workflows/` | `build.yml` (CI), `release-assets.yml` (legacy updater asset names). |
| `claude/` | Documentation for Claude sessions (this folder, lower case). |

The decompiled FYT framework (`decompiled_FYT_jars/`, three zips) was removed from the tree in `8bfc5a8d`. It
is still in git history, e.g. `git show 8bfc5a8d^:decompiled_FYT_jars/7862/system.zip`. Several briefs and
chat reports cite files inside it.

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
  - `release`: R8 minify and shrink, `proguard-rules.pro` + `proguard-widgets.pro`,
    `IS_DEBUG_FEATURES_ENABLED=false`.
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
location (as a fallback only), Shizuku, profileinstaller and LeakCanary (debug). **Room and Compose are
declared but have no imports** (`KNOWN_ISSUES.md` KI-03).

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
  the launcher kept in front, the autostart apps). `L/HomeLayoutRecovery` restores the layout after a wake.
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

## 5. Bars

- **Geometry** (pure, tested): `L/BarLayout` (one page's bars: the horizontal bar at the top or bottom, the
  vertical bar left or right, the corner, the insets) and `S/BarLayouts.of()` (reads the preferences once).
  `L/BarConstraints.apply()` rearranges an inflated layout: the bar to the top, the vertical bar mirrored to
  the right, with no extra XML.
- **Content:** `L/LauncherAppBars` holds the apps of both bars. The lists are stored with LitePal:
  `com/android/recycler/AppMultiple` for the horizontal bar, `LeftAppMultiple` for the vertical bar. `L/BarCapacity` and `L/BarRows` handle slots and
  preloading.
- **Bar on every page:**
  - `L/HorizontalBarPlacement` and `L/VerticalBarPlacement` decide where each bar is drawn.
  - `L/PersistentBarWindow` is the logic of the window that stays put while the pages move (pre-built, so
    showing it costs nothing); `L/VerticalBarWindow` is the vertical bar's window.
  - `L/PageBox` and `L/TopBarFrame` keep the windows on the page's box, below the status bar and the
    cut-out.
- **Auto-hide and the edge handle:**
  - `L/HorizontalBarEdgeHandle` is the window, on the left or right edge.
  - `L/HorizontalBarEdgeGesture` recognises the inward swipe; `L/EdgeHandleGeometry`, `L/EdgeHandleInput`
    and `L/EdgeHandlePass` do the rest.
  - On Android 10 system units the handle window takes no touches. `L/EdgeSwipeMonitor` and
    `L/EdgeMonitorTracker` watch an input monitor and pilfer only the opening swipe.
- **Widget bar** (the music widget on the horizontal bar): `L/WidgetBarLayout`, `L/WidgetBarPlan`,
  `L/WidgetBarLines`.

## 6. Layout creator

- `S/CreatorScreen.newInstance(page)` + `S/DrawViewScreen` is one creator for every page (since 2026-11-08).
- `S/CreatorPage` is the pure description of a page; `L/CreatorBars` and `S/CreatorBarMarks` draw the
  bars as they look on the home screen.
- `S/CreatorAppStats` + `S/DrawViewAppStats` is the creator of the stats window.
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
  `S/StatusBarSwipeDetector` (system only).

## 8. Media widgets

- **Views:** `L/LauncherMusicWidget`, `L/LauncherRadioWidget`. Sizing and text: `L/MusicWidgetPlan`,
  `L/MusicWidgetSizer`, `L/MusicWidgetText`, `L/RadioWidgetPlan`, `L/RadioWidgetSizer`. Look:
  `L/WidgetStyle` + `L/WidgetStyler` + `L/ViewTint`. Colors are view tints, never color filters on shared
  drawables (rule R2, 2026-11-08).
- **Any player:** `L/NotificationListener.kt` (media sessions) and `L/MediaTransportController`. With no
  cover the player's app icon is shown; with no session a widget button opens the last player.
- **Sound channel:** `com.syu.ms` switches the MCU's sound channel when a media app comes up (1 radio,
  3 Bluetooth, 8 FYT music, 10 third party; on the 7870 also 7 internet radio). `NotificationListener.kt`
  restores the channel that was playing after the panes start their apps, unless the user tapped something.
  Taps on panes are seen through `U/UserTouches`, a system-wide input monitor (D-31).
- **FYT stock sources:**
  - `C/StockSources` decides which source is shown: `com.syu.music` on 7862/8581; `com.syu.media` music,
    online radio and BT on 7870; the radio on both.
  - The other pieces are `C/MusicService`, `C/StockRadioSource`, `C/StockBtSource`, `C/SyuMediaClient` and
    `C/SyuMediaFiles` (covers read directly or through the host).
- **Favorites (the heart):** `L/MediaFavoriteController`.
  - `com.syu.media` favorites are written to its library; FM favorites are read-only
    (`C/SyuMediaRadioFavorites`).
  - The like status comes from `S/SpotifyRating` (Spotify Web API, PKCE, a client ID the user enters, the
    refresh token in preferences) or `S/FytRating` (the separate *fYT Rating* app `vasyl.fytrating`; the
    launcher holds no Google credentials; `S/FytRatingBridgeStarter` starts it).
- **App widgets:** `com/syu/widget/*Provider` (date, music, navigation, radio, time).

## 9. CAN bus and fuel statistics

- **FYT IPC:** `com/syu/ipc` and `com/syu/module` (decompiled) connect to `com.syu.ms` over binder: modules,
  `DATA[]` codes, callbacks. The per-car callbacks are in `com/syu/module/canbus` (729 files), including the
  7870's own path (`com/syu/module/canbus/HandlerCanbus7870`).
- **Service:** `S/CanbusService`, a foreground service.
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
  `S/RoadGrade`, `S/FuelUnit`, `S/ConsumptionUnits`.
- **Stats window:** `S/StatsWindowSize`, `S/StatsOverlayAlpha` (full alpha through the host),
  `S/StatsBarFit` (the bars move the window, never resize it).
- **Background** [H]: newer `com.syu.canbus` builds shift the `DATA[n]` indices (+11 for the PSA family).
  `claude/prompts/archive/analysis/canbus-app-comparison-2026-10-30.md` has the details.

## 10. Night mode, location and weather

- **Night mode:** `S/NightModeService` (`S/DayNightMode`); `S/SunTask` (sunrise and sunset from
  api.sunrise-sunset.org, with a fallback); `S/DayNightBrightness` (a minimum night brightness on the 7870);
  `S/HeadlightNightMode`. It changes the wallpaper and brightness, not the system dark mode. The launcher
  declares `uiMode` so that it is not recreated.
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
| FYT system apps: `com.syu.ms`, `com.syu.canbus`, `com.syu.media`, `com.syu.music`, `com.syu.radio` | IPC, widgets, fuel statistics | decompiled copies under `decompiled_*` |

## 16. Cross-cutting rules

- No main-thread I/O; StrictMode runs in release too.
- No arithmetic on `R.*` ids (`ResourceIdArithmeticTest`), and no resource ids in `switch`/`case`.
- `L/Launcher` keeps delegates for the ten helper classes split out of it (`LauncherWeather`,
  `HomeLayoutRecovery`, `LauncherWake`, `LauncherPipStarter`, `LauncherPermissionFlow`, `LauncherFab`,
  `LauncherAppBars`, `LauncherMusicWidget`, `LauncherRadioWidget`, `LauncherWallpaperPicker`; D-36).
- Logic in plain Java classes with JUnit 5 tests (95 test files under `app/src/test/java`).
- Rules R1–R3 (2026-11-08) are written in the Javadoc of the classes that enforce them:
  - R1 in `WorkspaceLoadWatch` and `LauncherModel`;
  - R2 in `WidgetStyle`, `WidgetStyler` and `ViewTint`;
  - R3 in `RectOverlap` and `DrawViewScreen`.
- 59 string resource files (`res/values*/strings.xml`).
