# CHAT_15 — Implementation rounds 8–12 (C1–C10, D1–D4, E1–E3, F1–F3, G1–G3) of FYT Launcher Mod on `testBranch`

| Field | Value |
|---|---|
| Conversation title | unknown |
| Approximate dates | The briefs are dated 2026-11-06 to 2026-11-08; the session date during the work was 2026-11-08; the last message is 2026-11-12 |
| Model / role | Implementation: executing the owner's Polish briefs (`docs/sonnet-prompt-*.md`), committing, pushing and reporting. The configured model was `claude-sonnet-5-5`, switched to `claude-opus-5-5` for this report |
| Repository branch(es) mentioned | `testBranch` (all work). The system prompt also named `ccr-078a64ad-g6hl5c`, but the briefs said to work only on `testBranch` |
| Report written | 2026-11-12 |

## 1. Aspect of the project discussed
- **Bars and edge handle:**
  - The horizontal bar at the top or bottom, the vertical bar on the left or right.
  - The auto-hide collapsed button versus the edge handle.
  - The vertical bar on every page, done as an overlay window.
  - The handle's touch pass-through on FYT Android 10.
- **Layout creators:** merging the creator of the first page and the creator of the other pages into one, how the bars are drawn in them, and the rule for overlapping rectangles.
- **Stats window:** where it sits relative to the bars.
- **Workspace loading:** robustness of the load and its watchdog.
- **Widget look:** text and button colour, and the widget background.
- **Earlier part of the conversation (only as a compaction summary):**
  - DAB pane crash, BT music widget, Android 10 touch inject.
  - Fuel threshold learning, Spotify and fYT Rating state.
  - Bars renaming, the Settings "Bars" category.
  - Top/right bars, right-side handle.
  - A logs file for Opus about com.syu.media on 7870.

## 2. Work performed

### Earlier part (known only from the compaction summary)
- [Confirmed] Commits from earlier rounds: ea203541, cced3912, 5e3fb395 (creator/canbus-leak round), 4677b990 (edge-handle width) and 3191a484 (Opus logs file).
- [Confirmed] The brief `docs/sonnet-prompt-2026-11-07-dab-bt-bars-settings.md` became 10 commits, all with CI success: C1 a64a2e90, C2 24ea895b, C3 9a61126a, C4 70f04048, C5 b0d2729e, C6 0ea8f2eb, C7 d0e67aaf, C8 663800c2, C9 9bc0faa5, C10 6080ce99.
- [Confirmed] Unintended edits that a rename script made to `decompiled_com.syu.canbus` (×80), `decompiled_com.syu.media` (×2) and `baselineProfile/README.md` were reverted with `git checkout --` before the C7 commit.

### Brief `docs/sonnet-prompt-2026-11-08-top-bar-button-vertical-every-page.md`
The owner's brief itself was commit bd24835b. All four commits showed CI `completed success`.
- [Confirmed] **D1 a4f522bf** "Bars: the horizontal bar and its handle at the top start below the status bar on every device":
  - Adds `TopBarFrame` and `TopBarFrameTest`, and `Workspace.barBoxOnScreen()`.
  - Removes `topBarOffset()`.
- [Confirmed] **D2 1843f8a6** "Bars: the collapsed bar's button only on the handle's side, its arrow turned on the right":
  - `HorizontalBarPlacement.bar` gets a `buttonSide` parameter.
  - `BarLayout` gets `handleRight`, `buttonShown()` and `sidesAgree()`.
  - Adds the `settings/BarLayouts` factory and the arrow rotation by 180°.
- [Confirmed] **D3 5604d116** "Bars: the vertical bar on every page":
  - New `Keys.VERTICAL_BAR_EVERY_PAGE` (`vertical_bar_every_page`), its preference, and the string in 59 files.
  - Adds `VerticalBarPlacement`, `VerticalBarWindow` and `EvenVerticalLayoutManager.setFollowsCapacity`.
  - Page geometry now follows `BarLayouts.verticalOnPage`.
- [Confirmed] **D4 4b63a077** "Edge handle: every touch but the opening swipe goes to what is under it, as under the stats window":
  - Adds `EdgeHandleInput`, `EdgeMonitorTracker` and `EdgeSwipeMonitor` (input monitor plus `pilferPointers`).
  - Tests: `EdgeHandleInputTest`, `EdgeMonitorTrackerTest`.

### Brief `docs/sonnet-prompt-2026-11-08-top-bar-box-vertical-corner-creators.md`
All three commits showed CI success.
- [Confirmed] **E1 752222ec** "Bars: the top bar and its handle take the box of the page, not of the workspace":
  - Adds `PageBox` and `PageBoxTest`.
  - The box is measured on `workspaceView`, and a one-off `Top bar: page …, overlay …` line is logged.
- [Confirmed] **E2 6961a9ca** "Bars: the vertical bar fills the corner where the collapsed bar has no button":
  - `BarLayout` gets `autoHide` and `cornerTaken()`.
  - `BarConstraints.apply(..., verticalFullHeight, verticalWidthPx)`.
- [Confirmed] **E3 8a0229d5** "Creators: the bars look as they do on the home screen": adds `CreatorBars`, `CreatorBarsTest` and `settings/CreatorBarMarks`.

### Brief `docs/sonnet-prompt-2026-11-08-vertical-window-side-one-creator-stats.md`
All three commits showed CI success.
- [Confirmed] **F1 fc5cac17** "Bars: the window of the vertical bar lies where the first page's bar lies":
  - Adds `VerticalWindowFrame` and its test.
  - The window gets gravity matching its side, and logs and corrects its placement.
- [Confirmed] **F2 76c1c110** "Creators: one creator for every page":
  - New `CreatorScreen`, `DrawViewScreen`, `creator_screen.xml`, `CreatorPage` with `CreatorPageTest`, `CreatorBarBand` was added later in F3.
  - Removed `CreatorFirstScreen`, `CreatorOtherScreens`, `DrawViewFirstScreen`, `DrawViewOtherScreens`, `creator.xml`, `creator_vertical.xml` and `creator_other.xml`.
  - `HorizontalBarPlacement` became public; `BarLayouts.BarPrefs` was added.
- [Confirmed] **F3 f791b67e** "Stats window: the bars move it out of their way, never resize it":
  - Adds `StatsBarFit` and `StatsBarFitTest`.
  - Removes `Element.fixed`, adds the user rectangle for "stats", and draws the bars in `CreatorAppStats`.

### Brief `docs/sonnet-prompt-2026-11-08-workspace-load-widget-style-creator-overlap.md`
All three commits showed CI success.
- [Confirmed] **G1 e3136f45** "Workspace load: a load that stops binding is started again, and a skipped reload is not lost":
  - Adds `WorkspaceLoadWatch` and its test, and `LauncherModel.loadSnapshot()`.
  - Adds `Launcher.beginWorkspaceLoading/endWorkspaceLoading` and `restartWorkspaceLoad`.
  - Loader logs are now always on, and every stop carries a reason.
- [Confirmed] **G2 b1fe254c** "Widgets: colors and backgrounds follow the settings on the widgets already shown":
  - Adds `WidgetStyle`, `WidgetStyleTest`, `ViewTint`, `WidgetStyler` and the preference listener in `Launcher`.
  - Removes `Helpers.applyColorFilterToButton`, `applyColorFilterToImageView` and `removeColorFilterFromImageView`.
  - `BackgroundSelectorDialog` now takes its values as fragment arguments.
- [Confirmed] **G3 3dd71894** "Creators: touching rectangles do not overlap, and overlapping ones are fitted the way the bars fit them":
  - Adds `RectOverlap` and `RectOverlapTest`.
  - Resolver step 1: move, then cut, then reset; adds `Env.bounds` and `Result.moved`.
  - New strings `overlap_fit_message` and `proceed_and_fit` in 59 files; `wont_save` and `proceed_and_reset` removed.

### Verification and limits
- [Confirmed] Before pushes, `:app:testSystemDebugUnitTest` ran locally, mostly together with `:app:assembleSystemDebug`, through helper scripts `/tmp/claude-0/x/lt.sh` and `cp.sh` in the container.
- [Confirmed] Nothing was run on a device in this conversation, as stated in each final report.

## 3. Requirements discovered
- [Historical] Owner's rules from the briefs:
  - "Pracujesz wyłącznie na istniejącej gałęzi `testBranch`." and "Nie twórz pull requesta."
  - Comments, Javadoc, `Log.*` and commit messages only in English.
  - No model name or identifier anywhere in the repo.
  - Each commit must build alone; wait for green CI before the next one; fix a red build with a new commit, no amend or force-push.
  - Run `./gradlew :app:testSystemDebugUnitTest` before every push.
  - StrictMode is on: no I/O, DB, ContentResolver, network, `su` or blocking VD host calls on the main thread; `apply()` instead of `commit()`.
  - Logic goes in pure classes without `android.*`, tested with JUnit 5.
  - Every new string goes into all 59 `res/values*/strings.xml`.
  - No new dependencies.
  - Remove things only after an `rg` over the repo outside `docs/`.
- [Historical] Final reports must be in Polish, with tester scenarios in English.
- [Historical] Rule R1 (G1): the model owns the "loading" state; a stuck load is restarted, not just released; a skipped reload is not lost; every stop is logged with a reason.
- [Historical] Rule R2 (G2): look settings apply to views already on screen through one place; the colour is set both ways; never put a colour filter on a resource drawable; use the view's tint.
- [Historical] Rule R3 (G3): one overlap rule for the creator and `Helpers`; a shared edge or corner is not an overlap; touching a bar stays a collision.
- [Historical] Owner's rule for the stats window (F3): "okno statystyk leży zawsze nad wszystkimi elementami siatki launchera … Paski … tylko je **przesuwają**". No resizing, cutting or reset.
- [Historical] Owner's rule for the edge handle (D4): "w całym obszarze uchwytu … uchwyt łapie wyłącznie swipe do środka. Kliknięcie i cała reszta przechodzą do tego, co jest pod spodem."

## 4. Architectural and technical decisions
- **Top bar box (D1, then E1):**
  - [Historical] Decided by the owner's briefs: the top overlay and handle take their place from the page's box (`barBoxOnScreen`).
  - [Confirmed] Implemented. In E1 the box was moved from the `Workspace` view to `workspaceView` (`PageBox`), because the Workspace lies from y=0 (brief §2.2).
- **One reading place for bar sides (D2):** [Historical/Confirmed] `BarLayouts.of()` is the single place that reads `VERTICAL_BAR_RIGHT`, `EDGE_HANDLE_RIGHT` and later `VERTICAL_BAR_EVERY_PAGE` and `AUTO_HIDE_HORIZONTAL_BAR`. An `rg` showed only `BarLayouts` hits.
- **Vertical bar window (D3):** [Confirmed] A second use of the `PersistentBarWindow` state for `VerticalBarWindow`, driven from `updatePersistentBar`. It shares the adapter of the first page's bar and does not compute its own capacity (`setFollowsCapacity(false)`); I decided the latter, to avoid capacity oscillation.
- **Handle monitor mode (D4):** [Historical/Confirmed] When the launcher has system privileges and Android is 10 or later, the handle window is always `FLAG_NOT_TOUCHABLE` and an input monitor plus `pilferPointers()` detects the swipe. Window mode stays as the fallback. Known trade-offs:
  - A click on the visible strip no longer opens the bar.
  - The handle gives no system gesture exclusion in monitor mode.
- **Long press then swipe (D4):** [Unverified] I decided that a press longer than the tap timeout is a press even if a move follows, to match window mode.
- **Vertical window placement (F1):** [Confirmed] x and width come from the measured `rl_vertical_bar` of page 0. Gravity follows the side. After the first layout the window checks its own position and corrects it once. I decided the gravity and self-correction parts because the root cause was not found.
- **Single creator (F2):** [Historical/Confirmed] Per the brief. I chose to give the vertical band and button a width that is a share of the box width (`matchConstraintPercentWidth`) so they keep proportion in the creator.
- **Stats window (F3):** [Historical/Confirmed] Removed from `CustomLayoutResolver`; moved by `StatsBarFit` from its user rectangle. `StatsWindowSize.syncSavedRectangle` keeps the user rectangle's width.
- **Workspace load (G1):** [Confirmed] `WorkspaceLoadWatch.decide` returns WAIT_MORE once for a live load, RESTART otherwise, and RELEASE after 2 restarts. The pending-step count uses `DeferredHandler.size()` (the whole queue), because `runOnMainThread` ignores the runnable type.
- **Colour as view tint (G2):** [Confirmed] `ViewCompat.setBackgroundTintList`, `ImageViewCompat.setImageTintList` and `setProgressTintList`. Text gets black, or the colour it had on the first call, remembered in tag `R.id.view_tint_default_color`.
- **Bar texts in G2:** [Unverified] I decided that the bar music title and artist (`…Two`) and the Workspace bar widget texts follow `BAR_TEXT`. This changes behaviour: before, the music texts were never blackened by the bar setting.
- **Resolver step 1 (G3):** [Historical/Confirmed] Move by the shortest way in the same size, then cut, then reset. The tie-break order is horizontal-only move first, then smaller y, then smaller x. With `Env.bounds == null` the element is not moved.

## 5. Rejected decisions and why
- [Unverified] **Full `BarLayout` adoption in C9:** I did not move the `CellLayout` loops fully onto `BarLayout`. Reason from the summary: too risky without a device. D2 and D3 later partly did it.
- [Confirmed] **Old dialog behaviour (G3):** removed the "Proceed and reset" path that discarded the drawn layout without `savePrefs()`, per the brief.
- [Confirmed] **`Element.fixed` (F3):** removed, because only the stats window used it.
- [Unverified] **Separate `CanbusService` refresh after stats corners change (F3):** not done. My reasoning: `Launcher` runs `checkAndResetIfOverlappingOnScreen` before the page rebuild after the settings.
- Not otherwise discussed.

## 6. Problems encountered and their solutions
- **DAB in a pane (summary part):**
  - Symptom: DAB stops playing after returning Home.
  - [Historical] Cause: a relaunch with CLEAR_TOP-type flags crashed the trampoline `MainActivity`.
  - Solution: C1, flags replaced by NEW_TASK|RESET_TASK_IF_NEEDED.
  - [Historical] The round-9 brief lists C1 as correct.
- **C3 did not reach panes:**
  - Symptom: on FYT Android 10, touches under the handle did not reach an app in a pane.
  - [Historical] Cause: the owner reported "C3 nie działa".
  - Solution: D4, input monitor mode.
  - [Historical] The round-10 brief says "D4 działa u właściciela".
- **Top bar under the status bar on A55:**
  - Symptom: on A55 / Android 16 the top bar and handle sat under the status bar.
  - Cause: `topBarOffset()` returned 0 in portrait.
  - Solution: D1.
  - Follow-up: D1 measured the Workspace, which lies at y=0, which was a regression on FYT ([Historical], brief §2.2). Fixed by E1.
  - [Historical] The round-11 brief says round 10 works.
- **Collapsed button / handle sides:**
  - Symptom: with the bars on different sides, page 0 had a button and no handle, and the corner cell was on the wrong side.
  - Solution: D2.
  - [Historical] The owner says it works.
- **Empty corner:**
  - Symptom: an empty corner when the collapsed bar has no button.
  - Solution: E2.
  - [Historical] The owner confirmed round 10.
- **Vertical window on the wrong side:**
  - Symptom: with the vertical bar on the right and "every page" on, the window appeared on the left on other pages.
  - [Unverified] Cause: unknown; not found in the code.
  - Solution: F1 guards and logging.
  - [Historical] The round-12 brief says round 11 is confirmed working.
- **Creators drifting apart:**
  - Symptom: the other-pages creator had the wrong bar height, the band drawn over the bar, and no rectangle keep-away; the first-page button sat at the left in landscape.
  - Solution: F2.
  - [Historical] The owner confirmed.
- **Stats window on a bar:**
  - Symptom: the stats window could sit on a bar.
  - Solution: F3.
  - [Historical] The owner confirmed.
- **Load that never bound (log 08-11 15:03):**
  - Symptom: the watchdog released the loading state after 30 s with no bind steps; icons were missing until restart.
  - [Unverified] Cause: unknown; candidates are listed in G1.
  - Solution: G1, restart plus logs.
  - [Unverified] Not confirmed on a device.
- **Widget colours:**
  - Symptom: colours stuck, or only some buttons changed.
  - [Historical] Cause (brief §2.3): the colour was never removed; filters on shared drawable state; dependence on the rebuild.
  - Solution: G2.
  - [Unverified] Not confirmed.
- **Touching rectangles:**
  - Symptom: touching rectangles were not red but raised the save dialog.
  - Cause: two different rules.
  - Solution: G3.
  - [Unverified] Not confirmed on a device.
- [Confirmed] **Build and test errors fixed during the work:**
  - Missing `TAG` in `CreatorOtherScreens`.
  - `HorizontalBarPlacement` was not public.
  - `CreatorAppStats` referenced the deleted `R.layout.creator_other`.
  - A regex put `false` into `assertEquals` in `BarLayoutTest`.
  - A wrong expectation in `CreatorPageTest` (dual PiP plus the first PiP shows neither).
  - The new strings were missing at first.
  - `wont_save` is absent in regional files, so the removal assertion was relaxed.
- [Confirmed] **Earlier FuelModelTest failures (summary part):** adapted after the C4 rules.

## 7. Features implemented or discussed
- [Confirmed] Implemented and confirmed working by the owner ([Historical]):
  - Top bar and handle below the status bar on every device (D1, E1).
  - Button only on the handle's side, arrow rotation, corner cell on the handle side (D2).
  - Vertical bar on every page (D3).
  - Handle pass-through via input monitor (D4).
  - Vertical bar filling the free corner (E2).
  - Creators mirroring the home screen bars (E3).
- [Confirmed] Implemented; the round-12 brief states the owner confirms round 11 ([Historical]): vertical window measured placement (F1), single creator for all pages (F2), stats window moved by bars only (F3).
- [Confirmed] Implemented; no owner feedback in this conversation:
  - Restart of a stuck workspace load and preserved skipped reloads (G1).
  - Widget colour and background applied live (G2).
  - Overlap rule and fitting in the creators and resolver (G3).
- [Confirmed] Implemented in the summary part (C1–C10):
  - DAB pane flags.
  - BT widget redraw and play state.
  - Android 10 edge inject (later replaced in practice by D4).
  - Fuel speed threshold learning.
  - Spotify sign-in state.
  - fYT Rating bridge starter.
  - Rename "bottom/left bar" to "horizontal/vertical bar".
  - Settings "Bars" category and vertical bar background.
  - Top and right bar placement; handle on the right.

## 8. Important constraints
- **Devices and Android versions:**
  - [Historical] FYT 7870 head unit (UNISOC uis7870sc_2h10, Android 13), according to the plan file and summary.
  - [Historical] FYT head units with Android 10: system launcher, panes in `ActivityView`.
  - [Historical] Samsung A55 with Android 16 (camera cut-out).
- **Permissions:**
  - [Historical] The input monitor needs system privileges (`LauncherApplication.hasSystemPrivileges()`, MONITOR_INPUT) and API 29 or later. The "standard" version and Android 8–9 use window mode.
  - [Historical] The `SecurityException` reading the wallpaper on Android 16 is a missing READ_EXTERNAL_STORAGE and "to nie błąd".
  - [Historical] The overlay windows need the "display over other apps" permission; the setting's summary says so when it is missing.
- **Owner's rules:** [Historical] See §3. Also do not touch decompiled sources, and do not change `WORKSPACE_LOADING_WATCHDOG_MS = 30000`, `FORCE_RELOAD_THROTTLE_MS` or `MAX_IDLE_WAIT_MS`.
- **Window layering:** [Historical] The status bar window lies above `TYPE_APPLICATION_OVERLAY` windows (brief §2.2).

## 9. Unresolved questions
- [Unverified] The root cause of the vertical bar window appearing on the left (F1) is unknown. The new logs (`Persistent vertical bar frame`, `… window is at`, `placed at … instead of`) were meant to reveal it.
- [Unverified] Where the 15:03 workspace load stopped is unknown. The new loader logs are meant to show it.
- [Unverified] Whether the top overlay and the page bar rectangles are equal is unknown: no `Top bar: page …, overlay …` log was available.
- [Unverified] The vertical bar capacity before and after E2 was only computed from the formula, not measured: 1280×720 gives 5 → 5, 1080×2340 gives 9 → 10, assuming a 48 px status bar.
- [Unverified] Whether `ViewCompat.setBackgroundTintList` works on every widget Button type (G2) was not checked.
- [Unverified] The behaviour change of bar texts following BAR_TEXT (G2) was not confirmed by the owner.
- [Unverified] In D3, the vertical window's height may jump when moving between pages of different shape (page 0 with the horizontal bar, other pages without).
- [Unverified] G3 tie-breaking and move results on real layouts are not verified on a device.
- [Historical] Not discussed further: any reply from Opus to the logs file (3191a484).

## 10. Information that may be missing from the repository
- [Historical] Owner confirmations from the briefs:
  - C1, C2 and C6 are correct; C3 did not work.
  - D2, D3 and D4 work.
  - Round 10 (E1–E3) works; round 11 (F1–F3) works.
- [Historical] The timeline of the 08-11 15:03 log:
  - `updateOnce=53031187`, CAS prev 53005708, previous return at about 15:02:52.8.
  - `loader already in flight, skipping forceReload()` at 15:03:18.323.
  - Watchdog release at 15:03:22.821.
  - It is partly in the G1 commit message.
- [Historical] Why the earlier colour filters leaked: shared `ConstantState` of resource drawables (in the G2 commit message).
- [Unverified] The capacity estimates (in the E2 commit message only as formula results).
- [Historical] Owner's report of the vertical window on the left, and that on the first-page creator the button sat at the left in landscape layouts.
- [Confirmed] None of rounds D–G was tested on a device by me. Device results, if any, exist only with the owner.
- [Confirmed] The local helper scripts used for builds and commits live only in the container: `/tmp/claude-0/x/lt.sh`, `cp.sh`, `gb.sh`, `trlib.py`, `tr_d3.py`, `tr_g3.py`.

## 11. Relevant file paths and references

**Briefs:**
- `docs/sonnet-prompt-2026-11-06-creator-hint-canbus-leak.md`
- `docs/sonnet-prompt-2026-11-06-edge-handle-width.md`
- `docs/sonnet-prompt-2026-11-07-dab-bt-bars-settings.md`
- `docs/sonnet-prompt-2026-11-08-top-bar-button-vertical-every-page.md`
- `docs/sonnet-prompt-2026-11-08-top-bar-box-vertical-corner-creators.md`
- `docs/sonnet-prompt-2026-11-08-vertical-window-side-one-creator-stats.md`
- `docs/sonnet-prompt-2026-11-08-workspace-load-widget-style-creator-overlap.md`

**Commits:**
- Earlier rounds: ea203541, cced3912, 5e3fb395, 4677b990, 3191a484.
- Round 8: a64a2e90, 24ea895b, 9a61126a, 70f04048, b0d2729e, 0ea8f2eb, d0e67aaf, 663800c2, 9bc0faa5, 6080ce99.
- Owner's brief: bd24835b.
- Rounds 9–12: a4f522bf, 1843f8a6, 5604d116, 4b63a077, 752222ec, 6961a9ca, 8a0229d5, fc5cac17, 76c1c110, f791b67e, e3136f45, b1fe254c, 3dd71894.

**Classes under `app/src/main/java/com/android/launcher66/`:**
- Bars and handle: `Workspace`, `CellLayout`, `Launcher`, `LauncherModel`, `LauncherAppState`, `DeferredHandler`, `HorizontalBarEdgeHandle`, `HorizontalBarEdgeGesture`, `HorizontalBarPlacement`, `VerticalBarPlacement`, `VerticalBarWindow`, `VerticalWindowFrame`, `BarLayout`, `BarConstraints`, `TopBarFrame`, `PageBox`, `PersistentBarWindow`.
- Input: `EdgeHandleInput`, `EdgeMonitorTracker`, `EdgeSwipeMonitor`, `EdgePassRoute`, `EdgeInject`.
- Creators and loading: `CreatorBars`, `WorkspaceLoadWatch`.
- Widget look: `WidgetStyle`, `ViewTint`, `WidgetStyler`, `LauncherMusicWidget`, `LauncherRadioWidget`, `LauncherAppBars`.
- `settings/`: `BarLayouts`, `CreatorScreen`, `DrawViewScreen`, `CreatorPage`, `CreatorBarMarks`, `CreatorBarBand`, `CreatorBarToggle`, `CreatorAppStats`, `DrawViewAppStats`, `Helpers`, `CustomLayoutResolver`, `RectOverlap`, `StatsBarFit`, `StatsWindowSize`, `CanbusService`, `SettingsFragmentSecond`, `BackgroundSelectorDialog`, `Keys`, `HorizontalBarDimensions`, `PipEdgeTrim`, `GridGeometry`.

**Other code:**
- `app/src/main/java/com/syu/util/WindowUtil.java`, `app/src/main/java/com/syu/util/UserTouches.java`.
- `app/src/main/java/com/fyt/widget/DigitClock.java`, `Date.java`, `WeekDay.java`, `DateTwo.java`, `WeekDayTwo.java`.

**Resources:**
- `res/layout-land|port/creator_screen.xml`; removed: `creator.xml`, `creator_vertical.xml`, `creator_other.xml`.
- `res/xml/creator_preferences.xml`, `res/values/ids.xml`, all 59 `res/values*/strings.xml`.
- `app/src/main/generated/baselineProfiles/baseline-prof.txt`.

**Tests under `app/src/test/java/…`:**
- `TopBarFrameTest`, `BarLayoutTest`, `HorizontalBarPlacementTest`, `VerticalBarPlacementTest`, `EdgeHandleInputTest`, `EdgeMonitorTrackerTest`, `PageBoxTest`, `CreatorBarsTest`, `VerticalWindowFrameTest`, `WorkspaceLoadWatchTest`, `WidgetStyleTest`.
- `settings/CreatorPageTest`, `StatsBarFitTest`, `RectOverlapTest`, `CustomLayoutResolverTest`, `PipEdgeTrimTest`.

**CI and plans:**
- `.github/workflows/build.yml`.
- Plan file `/root/.claude/plans/unified-beaming-thunder.md` (Opus logs plan).

**Log signatures added:**
- `Horizontal bar at the top: box …`, `Top bar: page …, overlay …`.
- `Persistent vertical bar: <action> (<reason>)`, `Vertical bar on page <n>: …`, `Persistent vertical bar frame: …`.
- `Edge handle input: <monitor|window> (…)`, `Edge handle: swipe -> open (pilfered)`.
- `Stats window moved by the bars: …`.
- `Loader <id> started/stopped by/dropped …`.
- `Widget style applied (…)`.
- `Overlap on page <n>: …`.

## Summary by label
- Confirmed: 47, Historical: 33, Suggestion: 0, Unverified: 17