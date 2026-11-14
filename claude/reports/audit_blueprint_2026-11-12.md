> **Stored copy, 2026-11-13.** This is the audit written on 2026-11-12 for the owner's request of 19 tasks
> (round 13), as it stood when the implementation began. It stood in for a brief and is history: do not
> edit it. File and line numbers refer to `3dd71894`. What was built, and where it differs from this text,
> is in [`implementation_report_2026-11-13.md`](implementation_report_2026-11-13.md).

# FYT Launcher Mod — engineering audit and implementation blueprint for the 19 tasks

## Context

The owner asked for a project-wide audit of 19 maintenance, bug-fix and UI tasks, and for a blueprint that a
later implementation phase can follow without redoing the analysis. This is the **audit and planning phase
only**: nothing in the repository or in `claude/` was changed, no commit was made, nothing was built or run.
Approving this plan accepts the audit; implementation starts only on an explicit instruction, stage by stage.

**What was read.** The whole `claude/` library core (`CLAUDE.md`, `PROJECT_STATE.md`, `ARCHITECTURE.md`,
`DECISIONS.md`, `KNOWN_ISSUES.md`, `ROADMAP.md`, `chat_archive/README.md`), the chat reports and briefs
relevant to each task (searched by topic), and the source code along each task's execution path.

**State of the checkout.** The local `testBranch` is at `3dd71894`, 8 commits behind `origin/testBranch`
(`886442bf`). The library exists only on the remote; it was read from a snapshot of that ref. Between the two
revisions `app/src` is identical; only `README.MD`, the Gradle files (Room/Compose removed) and the repository
layout differ (`docs/` → `claude/prompts/archive/`, `decompiled_*` → `archive/`). Line numbers below are from
`3dd71894`.

**Evidence tags** (the library's own): **[V]** read in the current code or git by me · **[V-r]** read in the
code by an exploration pass, cited with file and line, not re-read by me · **[H]** stated by a brief, a chat
report or the owner · **[A]** assumed / hypothesis · **[U]** unknown. Nothing here is a runtime observation:
no device, no build.

**Owner's answers during this audit (2026-11-12):**
1. Grid model for tasks 16/17: **usable-area grid** (bar strips are cut out of the page; the rest holds evenly
   spaced cells; items in a lost row/column are moved, never deleted).
2. Wallpaper (4D): **add a host errand**, but **do not change the Magisk module version** (the current module
   was never officially published).
3. Text/button colour (4E): the picker gets a **"Default"** action that restores the untinted look.

**Material the owner added during the audit:**
- A launcher log from the Galaxy A55 (Android 16), `…fYT_Rating_bug_start_pid_09-11-2026_17-27-20.txt`: 60 s
  from a process start, the launcher's own PID only (4,336 lines). Cited below as **[LOG]**.
- A screenshot of the home screen in portrait with layout bounds, both bars on. Cited as **[IMG]**.

Abbreviations: `L/` = `app/src/main/java/com/android/launcher66/`, `S/` = `L/settings/`,
`U/` = `app/src/main/java/com/syu/util/`, `R/` = `app/src/main/res/`.

---

## Execution (added 2026-11-12, after the owner's instruction to implement the whole plan)

The owner asked for the complete plan to be implemented autonomously, in stages, without redoing the analysis.
Sections A–I below stay the source of truth; this section only fixes how the work is carried out.

**How it runs**
- Stage 0 first: fast-forward `testBranch` to `origin/testBranch` (no local changes exist, nothing is lost).
- Then stages 1 → 9 in the order of section E, one commit per step with the subjects given in section F,
  pushed to `testBranch` only. No pull request, no amend, no force-push.
- Docs: `README.MD` and the `claude/` documents are updated in stage 9 (and `ARCHITECTURE.md` in the same commit
  where a commit changes what it describes), as `claude/CLAUDE.md` requires. Archived briefs and chat reports
  are not edited.

**How each step is verified**
- This session has JDK 21 but no Android SDK. First try to install the SDK command-line tools so that
  `./gradlew :app:testSystemDebugUnitTest`, `assembleSystemDebug` and `assembleStandardDebug` run here. If the
  network policy does not allow that, plain-Java classes and their tests are compiled and run with `javac` and
  the JUnit console, and **CI on GitHub (`build.yml`: unit tests, both debug builds, the Magisk zip) is the
  build check** — read after each push, a red run fixed by a new commit before the next step.
- A script checks that every new string key is in all 59 `strings.xml` files and that removed keys are gone.
- Lint is not part of this project's checks (KI-17); release builds are not run by CI and are attempted here
  only if the SDK is available.
- **Nothing can be run on a device from here.** The final report lists every change as "implemented, CI green"
  and names what still needs the owner's device test; nothing is reported as working on a device.

**Decisions taken for the open points of section H (the owner asked for autonomous decisions; each is easy to
change afterwards)**
- H.10: `hotseat_bg` is drawn for the left edge — left 0°, right 180°; the `app_list_bg*` family as specified.
- H.11: a double tap on the in-app stats rectangle keeps saving; anywhere else it always toggles the strip.
- H.12: the floating button's start condition is aligned with its service (each button needs only its own PiPs).
- H.13: items are re-placed only when the grid of the current orientation changed, never because of a rotation.
- H.14: the new category is titled "Home screen layout".
- H.15: "scrollbar" in tasks 3 and 10 means the launcher's bars drawn in the creator.
- H.7: the Shizuku wallpaper level is implemented behind the same "unsupported → next level" answer as the
  root level, so it is harmless if shell may not read the wallpaper; the report says it is untested.
- H.16: the StrictMode side findings in the log are **not** fixed (outside the 19 tasks); they are listed in the
  report.
- Stage 7's optional fYT Rating change is **not** made: its source is not in this repository.

**If something does not fit the plan** (a class works differently than read, a step cannot be made safe without
a device): implement the narrowest safe version, keep existing behaviour as the default, and record the
deviation and its reason in the final report rather than stopping.

**Final report:** changed files per stage, commits, CI results, what was not verified, deviations.

---

## A. Architecture map (what the 19 tasks touch)

| Area | Central code | Notes |
|---|---|---|
| Pages | `L/Workspace` (8.5k lines) extends `SmoothPagedView`/`L/PagedView`; `L/CellLayout`; `L/WorkspaceScreenPlan` | AOSP Launcher3 (KitKat era) core, heavily changed [V]. Page 0 is the "user page": `Workspace.createUserPage()` (:880–1020) inflates `customScreen[0]` and `workspaceView` (the layout with both bars). |
| Pager geometry | `PagedView.onMeasure` (:905–1008), `getViewportOffsetX()` (:473), `launcher.xml` (`layout_gravity="center"`), `Workspace.java:667` `setMinScale(shrink − 0.2)` | The pager view is measured **larger than the screen** and centred, so its own left edge on the screen is far negative [V]. This is the root of task 10. |
| Bars, state owners | `Workspace` owns all bar state. Geometry: `L/BarLayout`, `S/BarLayouts`, `L/BarConstraints`, `L/PageBox`, `L/TopBarFrame`, `L/VerticalWindowFrame`. Rules: `L/HorizontalBarPlacement`, `L/VerticalBarPlacement`, `L/PersistentBarWindow` | Page 0 at rest shows the **embedded** bars; other pages and any moving page show **overlay windows**: horizontal = second inflation in a `BarSwipeFrame` (`Workspace.showOverlayHorizontalBar` :1930–2010), vertical = `L/VerticalBarWindow` [V]. |
| Grid | `L/DynamicGrid` (:39–46: portrait 6 cols × 10 rows, landscape 10 × 6, hard-coded), `L/DeviceProfile`, `CellLayout` (:247–248 counts, :1007–1101 measure/layout), `LauncherModel.checkItemPlacement` (:1865) | No grid preference exists [V]. The horizontal bar reserves a row only in free-cell searches of the *current* page (`CellLayout.shouldExcludeLastRow` :1616, `shownWorkspacePage` :1632); the vertical bar reserves nothing [V]. |
| Music widget on the bar | `L/LauncherMusicWidget` (`renderPair` :1015–1049, `initMusicBarView` :1238), `L/MusicWidgetText`, `L/MusicWidgetPlan`, `L/MusicWidgetSizer`, `L/WidgetBarLines`, `L/WidgetBarLayout`; `R/layout/music_bar_content*.xml` | The bound text views switch between the page-0 bar and the overlay window [V-r]. |
| Backgrounds and colours | `S/BackgroundSelectorDialog` (one class, three tags), `L/colorpicker/ColorPicker.kt`, `L/WidgetStyle`, `L/WidgetStyler`, `L/ViewTint` (rule R2), `Launcher.mWidgetStyleListener` (:1418–1429), `S/AlphaSeekBarPreference` | Keys in `S/Keys` (:172–177). The stats colours use string literals, not `Keys` [V-r]. |
| Stats windows | `S/CanbusService` (one window object, tagged `"main"` or `"app"`), `S/StateAccessibilityService`, `S/ForegroundAppTracker`, `S/StatsBarFit`, `S/StatsOverlayAlpha`; creators `S/CreatorAppStats` + `S/DrawViewAppStats` (in-app) and `S/DrawViewScreen` (home) | Show/remove is driven by broadcasts from PiP code and by persisted flags in `S/Helpers` [V]. |
| Wallpaper | `S/SettingsFragmentFirst.SaveWallpaperTask` (:1944–2108), `S/SunTask`, `S/BackgroundSelectorDialog` (:109–159, :344–447), `L/LauncherPermissionFlow` (:303), `S/SettingsFragmentSecond.getMissingReadWallpaperPermissions` (:1101) | VD host file reads: `vdhost/shared/.../HostServices.readFile`, `HostFilePolicy` [V-r]. |
| PiP and radio | `U/WindowUtil.removePip()` (:778–860), `Launcher.onClick` (:6450–6800), `L/LauncherRadioWidget`, `L/LauncherMusicWidget.openActiveMusicPlayer` (:1490) | |
| Settings | `S/SettingsFragmentFirst` (`R/xml/launcher_preferences.xml`), `S/SettingsFragmentSecond` (`R/xml/creator_preferences.xml`), `S/Custom*Preference`, `S/AutoHideSeekBarPreference` + `R/layout/seekbar_preference_autohide.xml` | 59 `values*/strings.xml` files. |
| FYT / debug gate | `LauncherApplication.showsFytOptions()` (:839) = `BuildConfig.DEBUG \|\| DeviceIdentity.isFyt()` | Already exactly the rule task 6 asks for [V]. `IS_DEBUG_FEATURES_ENABLED` is never read [V-r]. |
| fYT Rating | `S/FytRating` (broadcast request/reply), `S/FytRatingBridgeStarter`, `S/BridgeStartPolicy`, `L/LauncherWake` | No service binding; no `<queries>` entry (covered by `QUERY_ALL_PACKAGES`) [V-r]. |
| Lifecycle | `Launcher.onResume/onPause/onStop`, `S/WakeDetection`, `S/WakeSignals`, `Launcher$AppWidgetResetObserver` (:8150) | |
| Build and tests | Flavors `system`/`standard`, types `debug`/`release`; compileSdk 37, targetSdk 36, minSdk 26; 95 JUnit 5 files, **no instrumented tests**; CI = `.github/workflows/build.yml`; LeakCanary in debug | Nothing can be verified on a device from a session (KI-06). |

---

## B. What the knowledge library changes about this work

1. **Process rules that bind every stage** (`claude/CLAUDE.md`, D-25, D-07, D-09, D-10, D-38): work on
   `testBranch`; one step = one commit, subject `<Area>: <what changed>`, CI green between commits, no amend or
   force-push; no model names in repository content; StrictMode silent (no main-thread I/O, `apply()` only);
   logic in plain-Java classes with JUnit 5 tests; new strings in all 59 locales, a changed meaning gets a new
   key; no arithmetic on `R.*` ids; no new dependencies; large files get targeted edits only; delete only after
   an `rg` over the repository; update `ARCHITECTURE.md` and `README.MD` in the same round.
2. **Task 10 is KI-28.** The library records that the cause of "the vertical bar's window appears on the left"
   was never found; `fc5cac17` (round 11) only re-based the frame on the measured page-0 bar and added logs
   (CHAT_14 :135, CHAT_15 :164/:238). Those logs are what now identify the cause (section C). No later commit
   touched that arithmetic [V: `git log fc5cac17..HEAD` on the four files shows only `b1fe254c`, which changed
   imports and tints].
3. **Task 11 conflicts with D-15 / KI-18.** The wallpaper `SecurityException` on Android 16 was declared "to nie
   błąd" and won't-fix. That judgement was made for the selector dialog's backdrop, which does fall back to
   colours; it is not true for "save day/night wallpaper", which fails with a raw error toast [V-r]. The
   owner's tasks 4D/11 supersede that part of D-15; the two framework warnings in D-15 stay won't-fix.
4. **Task 4G conflicts with D-09** (no preference migration unless asked). The owner now asks for one
   explicitly; it follows the existing one-time pattern in `LauncherApplication` (:165–189).
5. **Task 9 contradicts an archived analysis.** `opus-analysis-2026-11-03-remaining-log-findings.md` :135 files
   "No package ID 9c" under system noise. The ids are the launcher's own (section C).
6. **Decisions to preserve.** D-16 (stats window only moved by the bars, takes no touches); D-17 R2 (colours are
   view tints, never filters on shared drawables); D-18 (bar sides; the handle catches only the swipe); D-28
   (no app is special-cased by name — relevant to task 12, where today's code matches launcher names by
   substring); D-37 (Magisk module stays 1.0.0 — confirmed again by the owner today); D-40/D-09 key values;
   D-49 (no new Spotify prompts, no surface moves for the stats window, Shizuku Next start-up fixes are another
   project's code); the first principle that the owner's 7862 must not regress.
7. **Rejected approaches not to repeat:** a touchable stats window; resizing the stats window for the bars
   (D-16); direct surface moves (D-24); a tap on the handle strip opening the bar on system units (D-49).
8. **Earlier fixes that the new work must keep working:** standby/activate/park of the persistent bar windows
   (brief 2026-11-05 every-page-bar-fixes C2/C3); `everyPage &= userLayout` in `HorizontalBarPlacement.reserve`;
   the RESUMED gate of `05747c7` for the home stats; R1 load restart; the fYT Rating foreground-queue timing
   (`fe85360`, confirmed by the owner in CHAT_02) and the round-8 bridge starter (`0ea8f2eb`).
9. **Documentation that the code contradicts** (to correct in the implementation phase, not now):
   `ARCHITECTURE.md` §6 calls `CreatorAppStats` "the creator of the stats window" — it is the *in-app* window's
   creator; §9 calls `CanbusService` a foreground service — it never calls `startForeground` [V-r]; KI-13 and
   the README still say Shizuku needs "about 30 s".
10. **Never discussed before:** the marquee (task 14), a grid preference (17), the ADJUST/Restart clipping (2),
    the radio tap without `com.syu.radio` (8), the FAB summary (5), and a bridge that answers without a rating
    (15) — both earlier fYT Rating rounds were about reaching the bridge.
11. **Unverified history:** why the owner's round-11 test passed although the frame arithmetic was already
    wrong [U]; whether rotation between portrait and landscape is expected to keep icon positions [U].

---

## C. Root-cause analysis

| # | Current implementation | Root cause | Evidence | Earlier attempts | Recommended solution | Depends on | Risk | Verification |
|---|---|---|---|---|---|---|---|---|
| 1 | `widget_bar_line_mode` has three values (`two`, `artist_title`, `title_artist`); `CustomNestedThreePreference` cycles through its entries | Feature gap, no defect | [V-r] `R/values/arrays.xml` :39–48, `L/WidgetBarLines` :18, `LauncherMusicWidget.renderPair` | Rounds 2026-11-05 added the one-line choices | Fourth value `two_artist_first`; new labels with the prefix "Two lines:" | 19 (README) | Low | Unit tests + device look |
| 2 | Button height is forced to `0.55 × estimated row height`, text to half of that; five copies of the same sizing code; "Restart 1–4" are hard-coded English | **[A]** the button keeps its default vertical padding and font padding inside a forced height, so the text line has less room than its font metrics need; worse at the scaled density used on phones | [V-r] `CustomWidgetPreference.applySizing` :237–284 and four siblings; `R/layout/nested_preference_pip_restart.xml` :60–90 | none | One shared sizing helper: zero vertical padding and min-height, `includeFontPadding=false`, text size capped by the font metrics; "Restart %d" as a string resource | 7 | Low–medium | Screenshots at font scale 0.85–1.3, both orientations |
| 3 | The in-app stats creator draws the launcher's vertical bar band, bar marks and a top inset, and measures X from the bar's inner edge; `CanbusService` places the in-app window in raw screen coordinates | **Confirmed mismatch**: the creator models the home page, the window is shown over other apps where no launcher bar exists. A double tap on the rectangle saves instead of toggling | [V-r] `S/CreatorAppStats` :38–68, `S/DrawViewAppStats` :193–213, :584–598; `CanbusService` :834–837. Brief 2026-11-08 F3 asked for the bars to be drawn there | F3 (round 11) introduced it | In-app creator: no vertical band, no marks, no bar insets; full-screen coordinates; double tap outside the rectangle always toggles the controls strip | 12, 4G | Low | Unit test of the creator page description; device |
| 4 | See section F, stage 4/5/6 | Feature work. Confirmed defects found on the way: (a) `bg_stats_color` is saved through the mask `0xff4285f4 & color`, which corrupts every chosen colour [V `SettingsFragmentSecond` :970]; (b) bar backgrounds are applied only when page 0 is re-inflated [V-r]; (c) the "Pick wallpaper" button appears only if the colour fallback succeeded [V-r `BackgroundSelectorDialog` :394–406]; (d) on API 33+ the dialog asks for `READ_EXTERNAL_STORAGE`, which can never be granted there, on every open [V-r :1101–1120] | as listed | b1fe254c made widget styles live (R2) | Shared background model + one picker with two modes | 10, 11, 3 | High (breadth) | Unit tests for the model and the migration; device |
| 5 | `fab_overlay_summary` is the summary of all three floating-button switches | Wording. Also found: `LauncherFab.checkIfFloatingButton` (:27–40) requires all four PiP packages even for the left/right button, while `FabOverlayService` (:242–271) needs only that button's own pair | [V-r] | none | New string key with the new sentence; align the launcher's gate with the service's rule so the sentence is true for all three | — | Low | Device: left-only with two PiPs |
| 6 | `cold_start_last_app_delay` is gated only by the cold-start switch; the "compat – …" line and `compat_pid_…` are parts of two long strings shown everywhere | Missing gate | [V-r] `SettingsFragmentFirst` :450–462; `strings.xml` :357, :359; `ColdStart` :601 | — | Gate with `showsFytOptions()`; split the strings; force the stale preference to false where hidden, as `LauncherApplication` :197–203 already does for four keys | — | Low | Four build/device combinations |
| 7 | `CustomWidgetPreference` uses androidx's default row title; several custom layouts set `singleLine` | **[A, strong]** androidx titles are single-line by default; controls take their width first | [V-r] layout audit in section F stage 2 | CHAT_01 fixed `CustomNoSwitchPreference` only | `setSingleLineTitle(false)` in the custom classes; remove `singleLine`/marquee from the listed layouts; controls keep their code-set sizes | 2 | Low | Narrow-width screenshots |
| 8 | Radio tap: `stopMusic()`, try three launch paths, then **always** `WindowUtil.removePip()` | **Confirmed**: no availability check before the destructive calls; with no `com.syu.radio`, no MCU radio and no 7870 media page nothing starts but the panes are dismissed. Same pattern in eight other branches; an NPE path when `com.syu.radio` is installed without `com.syu.music` | [V] `Launcher.java` :6575–6600; [V-r] :6544–6788, `LauncherMusicWidget` :1490–1500 | none | Resolve the target first; only a resolvable start stops music and removes panes | — | Low–medium | Unit test of the decision; device with and without the radio |
| 9 | Workspace children get `setId(getCellLayoutChildId(...))` | **Confirmed origin**: `((container & 0xFF) << 24) \| …` with `CONTAINER_DESKTOP = −100` gives `0x9C……`; byte 2 = screen id, byte 1 = cellX, byte 0 = cellY — exactly the logged pattern. Which framework component looks the names up (content capture, autofill/assist structure or an accessibility service that reports view ids) is **[A]** | [V] `LauncherModel.java` :955–959; five `setId` sites; no reader of the encoding. [LOG]: 1,575 of the 4,336 lines are this error, starting 100 ms after `bindItems` and repeating with every pass over the pages | Filed as "system noise" on 2026-11-03 | Ids that stay out of the resource range (high byte 0) | 16/17 (cell ranges) | Low | Unit test; log free of the line on the Samsung |
| 10a | Window frame x = `workspaceLeft + (bar.x − page.x)`, `workspaceLeft` = `Workspace.getLocationOnScreen()` | **Confirmed**: the pager is measured oversized and centred, so its left edge is `(screen − oversize)/2`. For the logged device: `max = 2340+89+135 = 2564`, `⌊1.5·2564⌋ = 3846`, `⌊3846/0.38⌋ = 10121`, `(1080 − 10121)/2 = −4520`; bar at 938 in its page → `−3582`, exactly the log (`page bar −3582,89,−3440,2205`). With gravity RIGHT the offset becomes 4520 px and the window manager clamps the window to the **left** edge. The same wrong reference is in `PageBox` (top bar windows), hidden there by clamping | [V] `Workspace.java` :1607–1658, :3249–3270; `PagedView.java` :905–930, :473; `launcher.xml`; `integers.xml` (58 %); `VerticalBarWindow` :139–160, :222–247. [LOG] line 264 states the same number directly: `Horizontal bar at the top: box -4520,89,-3440,2205 on screen` | `752222ec` introduced the box; `fc5cac17` built on it | Reference = the left edge of a page **at rest** (`workspaceLeft + page.getLeft() − getScrollForPage(i)`); sanity-check the measured bar against the box | 4H, 14, 16 | Medium | Unit tests with the real numbers; device, both sides |
| 10b | Bar backgrounds are set in `createUserPage` and in each window's build | **Confirmed mechanism**: only `BLACK_WIDGETS`, `BLACK_BAR` and `WIDGETS_SELECTED_BACKGROUND` are applied live; windows are rebuilt on every resume, page 0 only when the page rebuild runs, and three paths skip it | [V] `Workspace.java` :938–943, :1762–1773; [V-r] `Launcher.java` :1423–1429, :2524–2606 | b1fe254c (widgets only) | Bar background keys join the live style path | 4 | Low | Device |
| 11 | "Save day/night wallpaper" calls `WallpaperManager.getDrawable()` with no check; the exception text goes into a toast | **Confirmed path**; that the exception is the platform's wallpaper-read check is **[A]** (matches the message). `READ_EXTERNAL_STORAGE` cannot be granted to a target-36 app on API 33+ | [V-r] `SettingsFragmentFirst` :1944–2108; manifest :62–75 | D-15 declared it not a bug | Shared wallpaper source with fallback levels (stage 6) | 4D | Medium | Device matrix by Android version |
| 12 | One window; home stats are added by `PIP_STARTED`, service start and list/overview close; removed only by `PIP_REMOVED` and a few UI broadcasts | **Confirmed structural gaps**: (1) the home window has no removal tied to the launcher leaving the foreground — `WindowUtil.removePip()` returns early when no VD host can host panes, so `PIP_REMOVED` is never sent there; (2) the RESUMED gate of `05747c7` runs only at add time; (3) `START_STICKY` restart re-adds from a persisted flag whose default is true; (4) a foreground package that is not in the stats list leaves the state untouched; (5) launchers are recognised by the substring `com.android.launcher`. Which path fires on the owner's phone is **[A]** (no log) | [V] `CanbusService.java` :664–737, :767–800; [V-r] `WindowUtil.java` :778, `Helpers.java` :205 | `05747c7` (cold start only; device result never recorded, KI-25) | One pure rule that maps (foreground task, own launcher state, screen state, settings) to NONE / HOME / APP, re-evaluated on every signal | 3, 4G | High | Unit tests of the rule; device scenarios in G |
| 13 | `Workspace.mAdapterLateLoggedFor` remembers the overlay a log line was written for | **Confirmed**: a log-dedup marker holds a strong reference to the `BarSwipeFrame`; `clearOverlayReferences()` (:3516–3532) nulls `overlayHorizontalBar` but not the marker. The observer in the leak trace is only the path to the live `Launcher` | [V] `Workspace.java` :2492, :2509–2511 (added by `656decb4`) | — | Clear the marker with the overlay (or compare by identity hash) | 14 | Low | LeakCanary after page swipes |
| 14 | Two independent sets of title/artist views; marquee is started only by `setSelected(true)` in `renderPair`; text is re-set only when it changed | **[A]**: the overlay's views are in a non-focusable window, start at text size 0 and are bound while hidden; if their marquee did not start (or stopped), nothing restarts it — `setSelected(true)` on a selected view does nothing and the text is not re-set | [V-r] `LauncherMusicWidget` :1015–1049, :1238–1259; `Workspace` :2091–2101, :3408–3470 | — | Explicit, idempotent marquee restart when a view set becomes the visible one; stop it on the hidden set | 10, 13 | Low–medium | Device, repeated page changes; log of selected/layout state |
| 15 | Broadcast request/reply. A status ping at process start, at every resume and on return to the settings; rating lookups retried after 3, 6, 12 s; a recovery ladder (reset transport → start the bridge's `WakeActivity` → force-stop it) that reacts only to a bridge that **does not answer** | **Confirmed by [LOG]: this is not a start-up failure.** The bridge is running and answers: `bridge start (process start): ping -> answered` (17:27:23), again at resume (17:27:27), with `statusKnown=true signedIn=true allowed=true`. Five rating lookups between 17:27:31 and 17:27:55 are each answered within 0.15–1 s but carry **no rating** (`answered: rating=UNKNOWN`). At 17:28:02 the owner opens fYT Rating from the settings row; the next lookup (17:28:05) returns `NOT_FAVORITED`, later ones `FAVORITED`. So the bridge cannot produce a rating until its own screen has been in front. **Why is [U]**: the launcher does not log the reply's `error` text, the capture holds only the launcher's PID, and fYT Rating's source is not in this repository. **[A]**: the bridge gets or refreshes its Google access token (or sets up its API client) only on its activity path, so a process started by a broadcast answers without one | [LOG] lines 226, 1519, 1884–2292, 2634, 2869, 3038, 4292; [V] `FytRating.fetchRating` :367–387 (the `error` extra is read, never logged), `MediaFavoriteController` :1195–1224 (ladder) and :3672–3705 | `fe85360` (timing), `0ea8f2eb` (starter) — both about reaching the bridge, which works | Launcher side: log the bridge's error; treat "answered without a rating while signed in and allowed" as its own state and answer it by starting the bridge's invisible `WakeActivity` once (only while the launcher is in front), then retry. If that does not make the bridge resolve ratings, the fix belongs in fYT Rating (token refresh on the receiver path) — separate step | — | Medium | The same capture after the change, plus a capture that includes fYT Rating's own log |
| 16 | Row reserved only in drop searches on the current page; vertical bar reserves nothing; bars are parked in overview | **Confirmed**: reservation is a search filter, not geometry | [V] `CellLayout.java` :1088–1101, :1610–1639, :1666–1680; [V-r] `LauncherModel` :267–293. [IMG] shows it: six 180-px columns span the full 1080-px width, so column 0 lies under the 138-px vertical bar and a 42-px strip stays empty beside it; rows are 210 px and the last usable row ends about 55 px above the horizontal bar, whose own row is hidden under it | brief 2026-11-05 review-bottom-bar item 4 | Usable-area grid (owner's choice) | 17, 9, 10 | High | Unit tests + device matrix |
| 17 | Grid hard-coded 10 × 6 / 6 × 10 | Feature gap | [V] `DynamicGrid.java` :39–46 | — | Long-edge / short-edge counts, sliders, new category | 16, 18 | High | as 16 |
| 18 | Start page accepts 1–99; `Integer.parseInt` unguarded in two places; the summary shows the typed value | **Confirmed**: no check against the page count; startup silently falls back | [V] `Workspace.java` :1012–1018; [V-r] `SettingsFragmentSecond` :1571, :2274–2280 | `ScreenNumberRule` exists for element pages only | Pure rule + rejection in the dialog + clamp at load | 17D | Low | Unit tests; device |
| 19 | README lines 23–26 (about 470 words) and footnote ¹ | Documentation | Latest `README.MD` on `origin/testBranch` | KI-09 | Rewrite; Shizuku Next link (the app already uses that URL: `SettingsFragmentFirst` :162) | 1, 16 | Low | Review |

---

## D. Dependencies and interactions

```
        ┌──────── 13 (leak) ─────┐
10a ────┤                        ├── 14 (marquee)        all three live in the overlay-window life cycle
        └── PageBox ── top bar windows, edge handle
10b ── 4 (A,B,C,H) ── one background model for page-0 bars, both windows, creators
4F picker ── 4A/4E/4G        4G ── 12, 3 (CanbusService)        4D ── 11 (one wallpaper source)
16 ── 17 ── 9 (cell ids must cover the new ranges) ── 18 (17D moves the start-page row)
2 ── 7 (same custom preference classes)        1, 16 ── 19 (README describes them)
```

- **Shared implementations.** (a) Page-at-rest reference: `PageBox` serves the top bar window, the edge handle
  and the vertical window — one fix. (b) `BarBackground`: one resolver from (stored choice, custom colour,
  bar side) to a drawable, used by page 0, both windows, the corner, `CreatorBarBand` and the selector tiles.
  (c) `HomeWallpaperSource`: one chain for the selector backdrop and the day/night capture. (d) `WorkspaceGrid`:
  one pure description of a page's cell area for `CellLayout`, `LauncherModel`, the creators' occupancy code.
- **Together:** 13 + 14 + 10a (same windows, same device test); 4A/B/C/E/F/H + 10b; 12 + 3 + 4G; 4D + 11;
  16 + 17 (+ the 17D settings move, after 18).
- **Before others:** 10a before 16 (the grid insets take bar positions from the same box); 4F before 4A/4E/4G;
  18 before 17D; 9 before or with 17 (cell index ranges); 19 last.
- **Conflicts to watch:** stage 4 and stage 8 both touch `Workspace.createUserPage` and the creators — do not
  interleave them. Stage 5 rewrites when `CanbusService` shows its window while 4G changes how it is drawn —
  lifecycle first, drawing second.
- **Preference migrations:** 4E (`black_widgets`, `black_bar`), 4G (six stats keys), 6 (forced false), 17
  (new keys, absent = today's grid), 18 (clamp). Listed in F.
- **Device-specific verification:** 10a, 12, 14, 15, 16/17, 4D/11 cannot be judged from code alone.
- **Known regression relationships:** bar-window changes have repeatedly broken the standby/activate/park cycle
  (rounds 8–11); custom-element fitting depends on the bar sizes (`CustomLayoutResolver`, `StatsBarFit`,
  `WorkspaceOccupancy`), so stage 8 must leave those rectangles unchanged.
- **A coupling found on the way:** `CellLayout.onLayout` (:1088–1099) places *every* direct child — including
  page 0's `workspaceView` with the bars — at an offset computed from `mCountX * mCellWidth`. The grid work must
  not move that root; grid insets therefore go on the cell container, not on the `CellLayout` padding.

---

## E. Implementation order

| Stage | Tasks | Why here |
|---|---|---|
| 0 | — | Bring the local branch to `origin/testBranch`; CI baseline. No code. |
| 1 | 13, 8, 9, 18 | Confirmed causes, small and isolated; each is one commit and easy to bisect. |
| 2 | 1, 2, 5, 6, 7 | Settings and strings only; one device pass over the settings screens. |
| 3 | 10a, 14 | Bar-window geometry and life cycle, on the leak-free base of stage 1. |
| 4 | 4F, 4A, 4B, 4C, 4E, 4H, 10b | The colour/background system on correct bar windows. |
| 5 | 12, 3, 4G | Stats window: life cycle, then creator, then its new settings (uses stage 4's dialog and picker). |
| 6 | 4D, 11 | Wallpaper source; touches the host protocol, kept apart. |
| 7 | 15 | fYT Rating; independent and small now that the log shows the transport works. |
| 8 | 16, 17 | Highest risk and widest effect; last, so every earlier stage is already confirmed on devices. |
| 9 | 19 + library docs | README and `claude/` once the features have their final shape. |

After each stage: CI green on every commit, then the owner's device test, then the next stage (D-25).

---

## F. Blueprint per stage

New pure classes get JUnit 5 tests in `app/src/test/java/...` and state their rule in their Javadoc. Every new
or changed string goes into all 59 `values*/strings.xml` files; a changed meaning gets a new key and the old
key is removed after an `rg` search.

### Stage 0 — preparation
- `git pull origin testBranch` (fast-forward `3dd71894` → `886442bf`). Paths in briefs change: `docs/` is now
  `claude/prompts/archive/`, decompiled sources are under `archive/`.
- Confirm CI is green on the tip. Rollback: none needed.

### Stage 1 — isolated fixes

**13 · `Workspace: the overlay's log marker no longer keeps a removed bar window`**
- `L/Workspace.java`: set `mAdapterLateLoggedFor = null` in `clearOverlayReferences()` and in the release path
  (:3750 area). Keep the once-per-overlay log.
- Acceptance: after 20 page swipes with "bar on every page" and returning from apps, LeakCanary reports no
  retained `BarSwipeFrame`. Regression risk: none beyond a repeated log line.

**8 · `Widgets: a tap that can start nothing leaves the panes and the music alone`**
- New pure `L/WidgetLaunchRule`: from (MCU radio present, `com.syu.radio` installed, `com.syu.music` installed,
  7870 media page available) to a target or NONE.
- `Launcher.onClick`: for `WS_Radio` and `Config.RADIO` decide first; on NONE return without `stopMusic()` and
  without `removePip()`; fix the null `launchIntent` path. Apply the same "resolve, start, then remove panes"
  order to `BT`, `WS_Bt`, `VIDEO`, `MUSIC`, `EQ`, `WS_Video`, `WS_Gallery` and
  `LauncherMusicWidget.openActiveMusicPlayer`, through one private helper that uses the existing
  `LauncherMusicWidget.launchIntentIfInstalled` / `intent.resolveActivity`.
- Behaviour on units with the radio is unchanged (same calls, same order after the check).
- Acceptance: no `removePip` log lines after a radio tap without `com.syu.radio`; panes stay.

**9 · `Workspace: cell views get ids outside the resource id range`**
- `LauncherModel.getCellLayoutChildId`: 24-bit layout, high byte always 0 — marker bit 23, container bit 22,
  screen 8 bits, cellX 7 bits, cellY 7 bits (enough for the grids of stage 8). Nothing decodes the id [V].
- Test: high byte zero and distinct ids over the full ranges for desktop and hotseat.
- Side effect: saved view-hierarchy state keyed by the old ids is not restored once after the update (harmless).
- Acceptance: the "No package ID 9c" lines no longer appear while using the home screen.

**18 · `Settings: the start page is always an existing page`**
- New pure `S/StartPageRule`: `accept(typed, pageCount)` and `effective(stored, pageCount)` (unparsable or out
  of range → 1, the user page).
- `SettingsFragmentSecond` (dialog :1751, `saveStartPage` :2274): reject a number above the page count, keep the
  stored value, show a new toast string; the summary always shows the stored, effective value. Page count from
  the same source the element-page fields use for `ScreenNumberRule`.
- `Workspace` :1012 and :8474: use `StartPageRule.effective`; if it differs from the stored value write it back
  with `apply()`. `CustomElementPrefs` keeps remapping on removal/reorder.
- Strings: 1 new (rejection message).

### Stage 2 — settings and strings

**1 · `Music widget: the artist above the title, and both two-line choices named`**
- `R/values/arrays.xml`: fourth value `two_artist_first`. `L/WidgetBarLines.Text`: `TWO_LINES_ARTIST_FIRST`
  (`oneLine()` false). `LauncherMusicWidget.render`: in two-line mode the upper view shows the artist and the
  lower the title, each text keeping its own role's size and weight (decided in `MusicWidgetPlan`, tested).
- Strings: new keys "Two lines: title above artist", "Two lines: artist above title" (the old
  `widget_bar_one_line_off` is removed); one-line labels unchanged. No migration: `two` keeps its meaning.
- `CustomNestedThreePreference` already cycles over any number of entries [V-r].

**2 · `Settings: the ADJUST and Restart buttons show their whole text`**
- New `S/ControlSizing` (pure maths + one `apply(Button, heightPx)`), replacing the five copies. Rule: no
  vertical padding, min height 0, `includeFontPadding=false`, centred; text size = the largest size whose font
  height fits `height − 2·minInset`. Row height stays the estimate used today, so control sizes do not change.
- Touch target: if the button is lower than 48 dp, extend its touch area to the row height with a
  `TouchDelegate`; the drawn size stays.
- `nested_preference_pip_restart.xml`: `Restart %d` from a string resource (1 new string).
- Verify first on a phone that this removes the clipping; the cause is a hypothesis until then.

**5 · `Settings: the floating button's description says what it controls`**
- New key `fab_overlay_controls_summary`: "Assign apps to the PiPs controlled by this floating button" (the
  owner's wording is accurate: main swaps all panes, left swaps left and third, right swaps right and fourth).
  Old key removed. Note: 7 regional files do not carry the old key; they inherit from their base language.
- `LauncherFab.checkIfFloatingButton`: require the packages of the enabled button's own panes, as
  `FabOverlayService` does. **Small behaviour change — listed for the owner's confirmation in H.**

**6 · `Settings: the delay option and the compat lines only on FYT units and in debug builds`**
- `SettingsFragmentFirst`: `cold_start_last_app_delay` visible only if `showsFytOptions()` (and the existing
  cold-start condition).
- Strings: `logcat_names_info_summary` and `logcat_locations_info_summary` each get a second key without the
  compat part; the fragment picks by `showsFytOptions()`.
- `LauncherApplication` :197–203: add `COLD_START_LAST_APP_DELAY` to the keys written false when
  `!showsFytOptions()`, so a stale value cannot act (it is read in `ColdStart` :601).

**7 · `Settings: long titles wrap instead of being cut`**
- `setSingleLineTitle(false)` in `CustomWidgetPreference`, `CustomWidgetSwitchPreference` and any other class
  that relies on the androidx title.
- Layouts with their own single-line title: `preference_no_switch.xml` (marquee), `nested_preference_pip_switch.xml`,
  `nested_preference_dual_pip.xml`, `nested_preference_pip_restart.xml` (title column 25 %), and the inner titles
  of `widget_preference.xml` / `widget_switch_preference.xml`: remove `singleLine`, keep `ellipsize end` with a
  generous `maxLines`.
- Already wrapping: `nested_preference_category_switch`, `_no_switch`, `_content`, `nested_preference_category`.
- Controls keep their size: widths are `wrap_content`, heights are set in code from the estimate, not from the
  measured row [V-r]. Acceptance: at 320 dp width "Set the screen that will display the stats" shows on two
  lines and the Page/ADJUST controls measure the same as before.

### Stage 3 — bar windows

**10a · `Bars: the windows take their place from the page at rest, not from the pager's own edge`**
- `Workspace.barBoxOnScreen()`: replace `workspaceAt[0]` by the page's rest position
  `workspaceAt[0] + page.getLeft() − getScrollForPage(indexOfChild(page))`; `measurePageVerticalBar` uses the
  same value. `PageBox.of`: rename the parameter and fix the Javadoc ("the left edge the page has when shown").
- `VerticalWindowFrame.of`: use the measured bar only if it lies inside the box horizontally; else the
  `BarLayout` band. Keep gravity by side. `VerticalBarWindow.checkPlacement` stays as a diagnostic, but its
  correction must no longer accumulate (reset `correction` in `setFrame`).
- Tests: `PageBoxTest`, `VerticalWindowFrameTest` with the real numbers (pager left −4520, page left 4520,
  screen 1080, bar 142) for both sides; top-bar frames unchanged for a 7862-like case.
- Acceptance: right and left bar stay on their side on every page, during the swipe and at rest, both swipe
  directions; log shows `page bar 938,…` on the 1080-px phone.
- Not explained by this cause: the report that the *left* setting shows the bar on the right [U] — with the
  wrong reference a left bar is clamped to the left edge, i.e. looks correct. Check on the device after the fix.
- Rollback: revert the one commit; the previous behaviour returns.

**14 · `Music widget: the title scrolls in whichever bar is shown`**
- New tiny helper in `LauncherMusicWidget`: `restartMarquee(TextView)` = `setSelected(false)` then
  `setSelected(true)`, posted after layout.
- Call it when a view set becomes the visible one: in `initMusicBarView` after the sizer's first layout, in
  `Workspace.activatePersistentOverlay` (always, not only on first show) and after park when page 0 is bound
  again. On park/standby call `setSelected(false)` on the overlay's views so nothing scrolls unseen.
- Add one debug log line (selected, width, line width) to confirm the hypothesis on the device.
- Acceptance: 30 page changes with a long title; scrolling runs on every page; no scrolling in a parked window.

### Stage 4 — backgrounds and colours

**Data model (new keys in `S/Keys`):**

| Component | Choice key (existing) | New value | Custom colour key (new, ARGB int) | Tint key (new, ARGB int; absent = untinted) |
|---|---|---|---|---|
| Widgets | `widgets_selected_background` | `custom` | `widgets_custom_background_color` | `widgets_tint_color` |
| Horizontal bar | `bar_selected_background` | `custom` | `bar_custom_background_color` | `bar_tint_color` |
| Vertical bar | `vertical_bar_selected_background` | `custom` | `vertical_bar_custom_background_color` | — (follows the bar's) |
| Statistics window | `stats_selected_background` (new, stage 5) | `custom`, `none` | `stats_custom_background_color` | `stats_color` (existing, kept) |

Independence (4C) follows from one pair of keys per component; all existing drawable choices keep working.

**4F · `Color picker: a text mode and a background mode with an alpha slider`**
- `L/colorpicker/ColorPicker.kt` already has an alpha bar (0–255, hidden unless asked) [V]. Add an explicit mode
  argument: `TEXT` = today's look, no alpha, plus the "Default" button (owner's answer 3); `BACKGROUND` = a
  fourth slider below blue, max 100, label "Alpha: NN%" updated on every change, value converted to 0–255 on
  return. One class, one layout pair (`layout-land`/`layout-port`), no copy.
- Cancel: the picker reports only through "Select"; dismiss without it changes nothing (callers must not write
  in slider callbacks).
- Strings: "Alpha: %1$d%%", "Default".

**4A/4B/4C · `Backgrounds: a custom colour beside the pictures, and a gradient frame on the chosen one`**
- `S/BackgroundSelectorDialog`: first tile = "+" (`R.drawable.icon_add`, the bar's empty-slot icon) when no
  custom colour is stored; else a tile painted with the stored colour over a checkerboard so alpha is visible.
  Tapping "+" (or long-pressing the colour tile to change it) dismisses the dialog and opens the picker in
  `BACKGROUND` mode; "Select" stores the colour and the choice `custom`. Tapping the colour tile selects it.
- Selected frame: one `R/drawable/background_selected_frame.xml` (or a small `Drawable` class) — a sweep/linear
  gradient of three related hues (e.g. teal → blue → violet) with thin light and dark outlines on both sides so
  it reads on any background; replaces the orange stroke in `addFrame` (:636–642) for every tile.
- New pure `L/BackgroundChoice` (name / custom / none + colour) and `L/BarBackground.drawable(context, choice,
  side)` used by `Workspace` (:938–943, :1762–1773, :2146–2150), `VerticalBarWindow` (:176–205),
  `S/CreatorBarBand`, `WidgetStyler` (widgets: a rounded `GradientDrawable`), and the dialog tiles.

**4H · `Bars: the background turns with the bar`**
- Today nothing is rotated; the vertical bar stretches the horizontal pictures [V-r].
- `BarBackground` wraps the bitmap in a small `RotatedDrawable` (draws the wrapped drawable rotated inside its
  bounds; no view is transformed, so icons and text are untouched). Angles for the `app_list_bg*` family:
  bottom 0°, top 180°, left 90° clockwise, right 90° counter-clockwise. `hotseat_bg` is drawn for the left
  edge: left 0°, right 180° (**assumption, see H**). Custom colours need no rotation.
- Applied wherever `BarBackground` is used, so position changes and restored settings follow automatically.

**10b · `Bars: a new background shows at once on the first page too`**
- `Launcher.mWidgetStyleListener` (:1423): add the two bar background keys, the custom colour keys and the tint
  keys. `Workspace.applyBarStyle`: set the background on the embedded bars (also back to the default — today
  only non-default values are set) and on both windows.

**4E · `Settings: the text and button color is chosen in the color picker`**
- `black_widgets` / `black_bar` rows become plain preferences that open the picker in `TEXT` mode; the
  "White/Black" summaries and the strings `black_color` / `white_color` are removed after `rg`.
- `WidgetStyle`/`ViewTint`: from "black or default" to "a colour or default" (tint lists stay view properties:
  R2 holds). `VerticalBarWindow.setArrowTint` follows the bar's tint.
- **Migration** (one-time, in `LauncherApplication` beside the existing ones): `black_widgets == true` →
  `widgets_tint_color = 0xFF000000`; false or absent → no tint key; then remove the old key. Same for
  `black_bar`. Idempotent through `contains(oldKey)`.

- Tests: `BackgroundChoiceTest`, `BarBackgroundAngleTest`, `WidgetStyleTest` (extended), migration test.
- Rollback: the stage is several commits; the migration commit is last so that reverting earlier ones never
  leaves migrated values without readers.

### Stage 5 — statistics window

**12 · `Fuel stats: the window follows what is in front, from one rule`**
- New pure `S/StatsWindowRule.target(...)` → `NONE | HOME | APP`. Inputs: settings (stats on, home stats on, user
  layout, safe mode); own launcher: started/resumed, UI state (workspace, all apps, overview, list, folder);
  foreground package if known (task stack / host / accessibility) and whether it is our own package; the stats
  app list; screen interactive. Rule: HOME only if our launcher is resumed in workspace state **and** the
  foreground task, when known, is ours; APP only if the foreground package is known, is not ours and is in the
  list; everything else NONE (so another launcher's home screen is NONE unless the user listed it).
- `CanbusService`: a single `evaluate(reason)` replaces the scattered add/remove conditions; it is called from
  the foreground report, from the existing UI broadcasts, from `Launcher.onResume/onPause/onStop` (direct call,
  no longer through `removePip`), from screen off (always remove) and wake (ask `ForegroundAppTracker` for a
  fresh value — today an unchanged package is not re-reported), and from `onStartCommand` (sticky restart).
- Own package by equality, a home app by role, not by name substrings (D-28). FYT specifics kept as explicit
  inputs: `persist.launcher.packagename` naming our package, and Recents shown from `com.android.launcher3` on
  the units — both must behave as today on the 7862.
- One window object stays, so no duplicates; `prevView` remains the single source of "what is shown".
- Tests: a table of scenarios (non-default launcher + Home pressed; wake with another launcher in front; listed
  app → unlisted app; service restart while an app is in front; all apps / overview).
- Risk high: the 7862's daily behaviour runs through this code. Mitigation: the rule's test table first encodes
  today's behaviour for the FYT scenarios, then adds the new ones.

**3 · `Creator: the in-app stats window is placed on the bare screen`**
- `S/CreatorAppStats`: no `CreatorBarBand`, no `CreatorBarMarks`, no top inset, canvas = full screen, whatever
  the launcher's bar settings are. `S/DrawViewAppStats`: borders = screen minus margin on all four sides (also
  in the arrow path, :624); double tap outside the rectangle always toggles the controls strip; hint text from
  a string resource instead of the hard-coded "In app".
- Stored `appStats*` coordinates keep their meaning (raw screen), which is how `CanbusService` already reads
  them — so saved positions are now shown where they will really be.

**4G · `Fuel stats: a background chooser and a text color like the widgets'`**
- `creator_preferences.xml` (:253–311): `color_picker`, `stats_bg`, `bg_drawable`, `bg_color`, `bg_color_picker`,
  `bg_alpha`, `alpha_seek_bar` are replaced by two rows: "Choose background for statistics window"
  (`BackgroundSelectorDialog` tag `stats`, tiles: none, the `bg_custom*` set, custom colour) and "Statistics
  text color" (picker, `TEXT` mode, writes the existing `stats_color`).
- `CanbusService` (:804–810, :884–891) reads `stats_selected_background` / `stats_custom_background_color`
  through `BackgroundChoice`; corner radii stay.
- **Migration** (pure `S/StatsBackgroundMigration`, tested for all combinations, using the defaults the
  *service* uses today — they differ from the XML's: `stats_bg` true, `bg_drawable` false, `bg_color` false):
  background off → `none`; default picture → `bg_custom`; coloured → `custom` with colour = stored
  `bg_stats_color` and alpha = stored `alpha_seek_bar`. The stored colour is migrated **as it is displayed
  today**, including the effect of the faulty mask, so nothing changes on screen. Old keys (`stats_bg`,
  `bg_drawable`, `bg_color`, `bg_stats_color`, `alpha_seek_bar`, `red/green/blue`, `bg_red/green/blue`) removed
  after migration; `S/AlphaSeekBarPreference`, `seekbar_preference_alpha.xml` and the seven strings removed only
  if `rg` shows no other user.
- The mask bug disappears with the old writer.

### Stage 6 — wallpaper

**4D + 11 · `Wallpaper: one source for the home screen's wallpaper, with fallbacks`**
- New `S/HomeWallpaperSource` with a pure level chooser `S/WallpaperAccess.levels(sdk, systemUid, canRead, host)`:
  1. **Standard API**, always with `FLAG_SYSTEM` (never the lock screen): system version on every Android;
     standard version below API 33 with `READ_EXTERNAL_STORAGE` granted; API 33+ only if the app already may.
     `READ_EXTERNAL_STORAGE` is not requested on API 33+ (fix `getMissingReadWallpaperPermissions`).
  2. **System-supported, no permission:** `getWallpaperColors(FLAG_SYSTEM)` — colours only, used for the
     selector's backdrop when no picture can be had.
  3. **Root (VD host daemon)** and 4. **Shizuku:** a new host errand "read home wallpaper" returning a file
     descriptor. Added as a new transaction **without bumping `VdHostProtocol.VERSION` and without changing the
     module version** (as `TX_SET_OBSCURING_LIMIT` was added, brief 2026-10-31); a host that does not know it
     answers "unsupported" and the chain goes on. The daemon reads the system user's wallpaper file directly
     (never `wallpaper_lock`); Shizuku asks the wallpaper service as shell — **whether shell may is [U], to be
     checked on the A55 before the commit that adds it**; if not, level 4 is skipped and documented.
  5. **Fallback:** colour blend plus the visible "Pick wallpaper" button. The button is shown whenever no
     picture was obtained (today it stays hidden when the colours fail too).
- `BackgroundSelectorDialog` (two duplicated blocks :109–159 and :344–392) and `SaveWallpaperTask` use the source.
- Day/night save when nothing can be read: a localized message (no raw exception text) and an offer to pick an
  image for that mode; the saved file, the hash and `SunTask` stay as they are. A denial can no longer leave the
  loading dialog or the state half-done.
- Tests: level chooser table; `HostFilePolicyTest` if the policy is extended.
- Library: D-15's wallpaper sentence is superseded (new decision entry in stage 9).

### Stage 7 — fYT Rating

**15 · `fYT Rating: a bridge that answers without a rating is woken, and its reason is logged`**

The log shows the transport is sound, so nothing in the starter or its timing is changed.
- Launcher side (preferred, no change to fYT Rating):
  1. `FytRating.fetchRating` / `noteReplyError`: log the bridge's `error` text once per change (it is read today
     and dropped). This alone tells the next capture why the bridge had no rating.
  2. New pure `S/RatingReplyRule`: from (reply present, rating present, error, status signed-in/allowed, launcher
     resumed, already woken for this bridge process) to `ACCEPT | RETRY | WAKE_THEN_RETRY | GIVE_UP`.
     "Answered, no rating, signed in and allowed" → `WAKE_THEN_RETRY` once: `FytRating.wake()` starts the
     bridge's existing no-animation `WakeActivity` (allowed because the launcher is in front), then the lookup
     is repeated on the bridge's next status answer, not after a fixed pause.
  3. `MediaFavoriteController`: the existing 3/6/12 s retry stays as the fallback; the silent-bridge ladder
     (:1195–1224) is untouched.
  4. Housekeeping from the code reading: reset `broadcastLaunchFailed` / `autoLaunchState` on any answer (brief
     C6 asked for it; today only a missed answer resets them).
- Test: `RatingReplyRuleTest` (the five lookups of the log must yield one wake, not five).
- **Open, decides whether this is enough:** whether `WakeActivity` puts the bridge into the state that the main
  screen did in the log [U]. One device test answers it.
- **Separate step in fYT Rating, only if the wake is not enough:** obtain or refresh the token on the receiver
  path, and return a distinct error ("needs the app's screen") so the launcher can say so in the settings row
  instead of retrying. Justification: the launcher cannot create another app's credentials; it can only bring
  the app to the state where it has them.
- The owner's observation with "Unrestricted" battery usage stays relevant: if ratings then resolve without
  opening the app, the cause is the system limiting the background process rather than the token path.

### Stage 8 — grid (16 + 17)

**Model (new pure `L/WorkspaceGrid`, tested):**
- Stored: `workspace_grid_long` (default 10, range 8–14) and `workspace_grid_short` (default 6, range 4–10) —
  cells along the long and the short screen edge. Columns = long in landscape, short in portrait; rows the
  other way. Absent keys = today's grid, so nobody's layout changes by updating. Sliders: rows 4–10 and columns
  8–14 in landscape; rows 8–14 and columns 4–10 in portrait (two below, four above today's values).
- Per page: `WorkspaceGrid.of(orientation, long, short, pageSize, horizontalReserve, top, barHeight,
  verticalOnPage, right, barWidth)` → usable rectangle (page minus the bar strips), `countX = columns −
  (vertical bar on this page ? 1 : 0)`, `countY = rows − (horizontal bar without auto-hide on this page ? 1 :
  0)`. Inputs come from the existing rules `HorizontalBarPlacement.reserve` and `VerticalBarPlacement.onPage`,
  so page 0 and the other pages, "every page" on or off, are handled by the same call. Auto-hide keeps today's
  single reserved corner cell and takes no row.
- Icon size is untouched (`iconSizePx`); only the spacing follows the usable area. Compared with the same
  setting without the bar, the row pitch differs by `(H/rows − barHeight)/(rows − 1)`.

**Code:**
- `DynamicGrid`: counts from the preferences instead of constants.
- `CellLayout`: per-page `setGridSize` + new grid insets applied to the **cell container** (measure :1007, layout
  :1088) and to the geometry helpers that use `getPaddingLeft()/Top()`; `workspaceView` on page 0 stays at the
  page origin. The row filter (`excludeLastRow`, `shouldExcludeLastRow`, `isBarRowExcluded` for ROW) is retired —
  geometry replaces it on every page, shown or not, in normal, drag and overview mode.
- `LauncherModel`: per-screen counts in `checkItemPlacement`, `findNextAvailableIconSpaceInScreen` and the
  sort; a new pure `L/GridOverflow.plan(items, countsPerScreen)` moves every item outside its page's grid to
  the nearest free cell (same page, then following pages, then a new one), clamping spans that cannot fit. It
  runs on the loader thread **before** `checkItemPlacement`, which today would reject such an item. Moves are
  written with the existing batch update. It runs only when the grid signature (long, short, bars per page) of
  the current orientation changed since the last load in that orientation — never just because of a rotation.
- Custom elements, panes and the stats window keep their pixel rectangles; `S/WorkspaceOccupancy`,
  `S/GridGeometry` and `CellLayout.handleConflictingViews` map cells through `WorkspaceGrid`.
- Overview: bars keep stepping aside (as the README says) but their strips are no longer cells.

**Settings (17D/E):**
- `creator_preferences.xml`: new category above "Widgets" — proposed title **"Home screen layout"** — holding
  rows slider, columns slider, `start_page` (moved from Bars), `all_apps_textSize` and `workspace_textSize`
  (moved from Miscellaneous on the first screen; their handlers move from `SettingsFragmentFirst` :867–884,
  :1223–1237, :1840–1859 to `SettingsFragmentSecond`; keys unchanged). A `preference_separator` above "Widgets".
- Sliders: `S/AutoHideSeekBarPreference` generalized with min/max attributes (or a sibling class) on
  `seekbar_preference_autohide.xml`; summary shows the value. Under each an explanation row: effective rows are
  one fewer where the horizontal bar is shown; effective columns one fewer where the vertical bar is shown.
- Strings: category title, two slider titles, two explanations.

**Commits (each builds and passes tests):** grid class + tests → counts from preferences (defaults only, no
visible change) → cell-area insets and per-page counts → overflow planning in the loader → settings category
and sliders → README.

**Risks:** icon positions shift by a few pixels on pages with a bar on every device, the 7862 included (owner
accepted this with the model); an error in the overflow step could misplace items — hence run-once signature,
tests with real layouts, and a log line per moved item. Rollback: revert the settings commit first (grid back to
defaults), then the geometry commits; moved items stay where they were moved (valid positions in the old grid
too, because the old grid is a superset).

### Stage 9 — README and library
- `README.MD`: rewrite lines 23–26 to four short items (target ≈ 150 words in total instead of ≈ 470):
  horizontal bar with optional widgets (music, optional cover/date/weather; hidden parts give room to the music
  widget; layout, buttons and title/artist arrangement configurable; **no weather fetch and no GPS while no
  weather is shown**); auto-hide (inward swipe on the edge handle; a tap also works where supported; the system
  version on Android 10+ takes the swipe only); bar on every page (space reserved without auto-hide, the handle
  on every page with it; steps aside in apps, overview, while dragging and in folders); bars on either side
  (top/bottom, left/right, own backgrounds, vertical bar optionally on every page, both need the
  draw-over-apps permission). No percentages, row orders or touch details.
- Shizuku: link `https://github.com/rushiranpise/Shizuku-Next/releases/latest`, recommended for users who need
  Shizuku; on most devices its server starts at once when "Start without Wi-Fi" is available and enabled; no
  promise for every device.
- Footnote ¹: `FLAG_SECURE` apps may show black in a PiP; PiPs are available once Shizuku has started; no fixed
  time; points to the recommendation.
- `claude/`: `ARCHITECTURE.md` (grid, backgrounds, stats rule, corrected statements of B.9), `DECISIONS.md` (new
  entries: usable-area grid; wallpaper source superseding part of D-15; stats migration as a D-09 exception;
  tint "Default"), `KNOWN_ISSUES.md` (KI-28 cause found; KI-13 wording), `PROJECT_STATE.md`, catalogue rows.

---

## G. Test strategy

**Automatic (JUnit 5 on CI, `./gradlew :app:testSystemDebugUnitTest`):** `PageBoxTest`, `VerticalWindowFrameTest`,
`WidgetLaunchRule`, cell-id layout, `StartPageRule`, `WidgetBarLines` / `MusicWidgetPlan`, `ControlSizing`
maths, `BackgroundChoice`, bar background angles, `WidgetStyle`, both migrations, `StatsWindowRule`,
`WallpaperAccess` levels, `BridgeStartPolicy`, `WorkspaceGrid`, `GridOverflow`; plus the existing 95 files as
the regression net (`BarLayoutTest`, `CustomLayoutResolverTest`, `ResourceIdArithmeticTest` …). A string-key
parity check across the 59 files is run as a script before each strings commit.

**Device only (owner / tester):**

| Group | Cases | Devices |
|---|---|---|
| UI | Portrait and landscape; font scale 0.85 / 1.0 / 1.3; long titles in every settings category; ADJUST and Restart buttons; picker cancel vs Select; alpha 0 %, 1 %, 50 %, 100 %; "Default" tint; selected frame on light, dark and transparent tiles | A55, Redmi, 7862 |
| Workspace | Page 0 and others; vertical bar left/right; horizontal bar top/bottom; each bar alone and both; auto-hide on/off; "every page" on/off; overview; dragging icons, folders, widgets to every edge; swipes both ways; rotation; restart; grid at min, default and max | A55 (portrait), 7862 (landscape) |
| Lifecycle | Launcher default and not default; Home to another launcher; screen off/on; wake after long sleep; force-stop and service restart; switching between a listed and an unlisted app with stats on | A55 (not default), 7862 (default) |
| Integrations | With and without `com.syu.radio`; FYT and non-FYT; debug and release; Shizuku running / stopped / absent; root module; fYT Rating installed / absent / never opened since boot | all |
| Memory | 20 page swipes with bars on every page; 10 enter/leave cycles; LeakCanary (debug) | A55 |
| Persistence | Fresh install; update over a build with old values (black widgets on/off, each stats background combination, stale delay switch, start page 99); restart after changing every new setting | Redmi or A55 |
| Wallpaper | Selector backdrop and day/night save on Android 10 (system), 14 (root), 16 (Shizuku), and without any host | 7862, Redmi, A55 |

A stage is "implemented" when CI is green and "working" only when the owner says so.

---

## H. Open points and assumptions

| # | What is missing | Why it matters | How to settle | Blocks? |
|---|---|---|---|---|
| 1 | Why the round-11 device test passed although the frame reference was already wrong | Explains the "regression"; the numbers fit the log exactly either way | Device log after stage 3 | No |
| 2 | The reported mirror case (bar set left, shown right) is not produced by the confirmed cause | A second defect may exist | Same device test, left side | No |
| 3 | Which component looks up the `0x9c…` ids | Only for the write-up; the fix removes the ids | Log after stage 1 | No |
| 4 | Marquee: the actual stop condition | The fix is deterministic, but unproven | The debug line of stage 3 | No |
| 5 | Stats over another launcher: which gap fires on the phone; whether Shizuku was running then | Chooses the scenarios to test first | A capture of one occurrence, or the stage-5 logs | No |
| 6 | fYT Rating: the error the bridge returns with its empty answers, and its own log; fYT Rating's source is not in this repository | Decides whether waking its activity is enough or the fix belongs in fYT Rating | A capture after stage 7's logging, ideally with fYT Rating's PID too; the battery-setting observation | No (launcher side proceeds) |
| 16 | Side findings in [LOG], outside the 19 tasks: StrictMode disk reads on the main thread from `VdHostProtocol$Proxy.startActivity` (three, about 169 ms), `WindowHostVdShizuku.maybeBind`, `LauncherAppWidgetHostView.onLayout` and the toast at `FytRating.handlePreferenceClick` :1071 | The project rule is that StrictMode stays silent (D-07) | Owner decides whether to add them to a later round | No |
| 7 | Whether shell (Shizuku) may read the system wallpaper | Level 4 of the wallpaper chain | One check on the A55 | Only that level |
| 8 | Exact platform behaviour of the wallpaper API per Android version for a target-36 app | Level 1 conditions | Device matrix | No (the chain falls through) |
| 9 | Clipping cause of ADJUST / Restart | Fix targets a hypothesis | Phone screenshot before/after | No |
| 10 | `hotseat_bg` orientation rule (left 0°, right 180°) | Look of the default vertical background on the right | Owner's eye | No |
| 11 | Double tap **on** the in-app rectangle keeps saving (outside it toggles the strip) | Task 3 says "always hideable" | Owner confirms or asks for a change | No |
| 12 | `LauncherFab` gate aligned with the service (left/right button with only its own two PiPs) | A small behaviour change beyond the wording | Owner confirms | No (wording can ship alone) |
| 13 | How icon positions are meant to behave across rotation; today items beyond the other orientation's grid are not shown | The overflow step must not reshuffle on rotation | Owner's intent + one phone test | No (guarded by the per-orientation signature) |
| 14 | Category title "Home screen layout" | Naming | Owner | No |
| 15 | "Scrollbar" in tasks 3 and 10 is read as the launcher's bars drawn in the creator | Scope of task 3 | Owner (consistent with the code: there are no real scrollbars) | No |

---

## I. Readiness

- **Sufficient evidence to implement:** 1, 5, 6, 8, 9, 10a, 10b, 13, 16, 17, 18, 19, and 3, 4, 11, 12 as designs
  with confirmed defects behind them.
- **Fix designed, cause still a hypothesis (verify on the device right after the stage):** 2, 7, 14, and the
  specific trigger of 12. For 15 the symptom is pinned down by the log (the bridge answers but has no rating
  until its screen was opened); why the bridge behaves so is outside this repository.
- **High risk:** stage 8 (grid: every page, the item database, the 7862), stage 5 (stats life cycle on the
  7862), stage 4 (breadth: six surfaces, two migrations).
- **Must come first:** stage 0; 10a before 16; 4F before the dialogs; 18 before 17D.
- **Fixes to preserve:** see B.8.
- **Still needed from the owner:** points 10–15 of H (none blocks the start), a capture for H.5/H.6 when
  convenient, and the go-ahead per stage.

**The repository is understood well enough to begin implementation with stage 0–1.**

---

## Closing lists

**1. Tasks and status.** 1 analysed, ready · 2 analysed, cause hypothetical · 3 cause confirmed · 4 analysed,
designed (A–H), four side defects confirmed · 5 analysed, ready · 6 analysed, ready · 7 analysed, cause strongly
indicated · 8 cause confirmed · 9 origin confirmed · 10 cause confirmed (side) and mechanism confirmed
(background) · 11 path confirmed · 12 structural gaps confirmed, trigger hypothetical · 13 cause confirmed · 14
hypothesis, deterministic fix · 15 log analysed: the bridge answers without a rating until its screen was
opened; the reason inside fYT Rating is unknown · 16 cause confirmed (code and screenshot) · 17 designed · 18
cause confirmed · 19 specified.

**2. Confirmed root causes.** 10a oversized pager's edge used as the page's edge (code, arithmetic and the
log's own `box -4520,…` line) · 15 the bridge is reachable and answers; its answers carry no rating until its
screen has been in front, and the launcher's recovery only handles a silent bridge · 13 log marker retains the
detached frame · 9 cell-id encoding collides with the resource-id space · 8 panes removed without checking that
anything can start · 16 bar space is a search filter on the current page only, nothing for the vertical bar · 18
no validation against the page count · 3 the in-app creator models the home page · 10b bar backgrounds not in
the live style path · 11 wallpaper read with no check or fallback · 4 colour mask bug, never-grantable
permission request, hidden pick button · 12 no removal tied to the launcher leaving the foreground; stale
persisted flag on service restart.

**3. Unresolved hypotheses.** 2 padding/font-padding in a forced height · 7 androidx single-line title · 14
marquee never (re)started in the non-focusable window · 15 the bridge has no token (or no network) until its
activity ran, and whether its `WakeActivity` is enough to change that · 12 which gap fires on the phone · 9
which framework component does the lookup · 10 the mirror case on the left.

**4. Historical findings that matter.** Task 10 is KI-28, whose cause the library records as never found;
D-15 called the wallpaper exception "not a bug" for a case where a fallback exists; the 2026-11-03 analysis
filed the `9c` lines as system noise; R2 fixed widget styles live but left the bar backgrounds out; `05747c7`
gates the home stats only at add time and was never confirmed on a device; the every-page bar's
standby/activate/park cycle is what binds the music views to one bar or the other.

**5. Owner decisions and constraints.** `testBranch` only, one commit per step, CI between commits, no amend or
force-push, no model names in the repository; StrictMode silent; plain-Java logic with tests; 59 locales; stored
key values kept, migrations only where asked (asked for 4E/4G); no new dependencies; the 7862 must not regress;
no app special-cased by name; stats window only moved by the bars and untouchable; Magisk module version
unchanged; today's answers: usable-area grid, host errand for the wallpaper, "Default" tint action.

**6. Order.** 0 preparation → 1 (13, 8, 9, 18) → 2 (1, 2, 5, 6, 7) → 3 (10a, 14) → 4 (4F, 4A–C, 4E, 4H, 10b) →
5 (12, 3, 4G) → 6 (4D, 11) → 7 (15) → 8 (16, 17) → 9 (19, library).

**7. Highest-risk changes.** The grid (item relocation, per-page geometry, 7862 layout shift); the stats
window's life-cycle rule; the two preference migrations; the host protocol addition.

**8. Tests and devices.** Unit tests for every new pure class on CI; device passes per stage on the 7862
(Android 10, system, landscape, default launcher), the Redmi Note 8T (Android 14, root) and the Galaxy A55
(Android 16, Shizuku, portrait, not the default launcher), debug and release, with the scenario table in G.

**9. Ready?** Yes, for a staged start; the open points in H are settled by the device test of their own stage.
