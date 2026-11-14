# Round 13: implementation report

2026-11-12 → 2026-11-13, `testBranch`, commits `4e73d1178` … `ca27a7637` (25 code commits), `52d75131c`
(README) and the documentation commit that carries this file. The request was the owner's list of 19 tasks;
the audit written for it is [`audit_blueprint_2026-11-12.md`](audit_blueprint_2026-11-12.md).

**What "done" means here.** Every commit builds in both flavors and the unit tests pass: 1011 tests in 110
files at the end, about 866 before the round. CI was green on every push of the round (runs 473 and
475–480; 474 was cancelled by a newer push); run 480 is the last code commit, `ca27a7637`. **Nothing was run on a device.** No lint and no
release build were run: neither is part of this project's checks (`KNOWN_ISSUES.md` KI-17). Each row below
says what the owner's device test has to show.

Evidence tags as elsewhere: [V] in the code or git · [H] from the owner or a log · [A] assumed · [U] unknown.

## The 19 tasks

| # | Task | Commit | What was done | Device test |
|---|---|---|---|---|
| 1 | Artist above title | `e3e8eccb9` | Fourth choice `two_artist_first`; both two-line choices are named "Two lines: …". The two text views change places in the bar, so each line keeps its own size. | The four choices on the bar, both orientations. |
| 2 | ADJUST / Restart text cut | `61c1089a1` | One rule for the small buttons of five row classes (`ButtonTextFit`): the text is as large as the button's height allows. "Restart %d" is a string. | **The cause was a hypothesis** [A]: check at font scales 0.85–1.3 on a phone. |
| 3 | In-app stats creator without the bars | `e7d0e17bf` | The creator of the stats window over apps shows the bare screen: no bar band, no marks, no insets. | The saved place is where the window appears over an app. |
| 4A–C | A colour of one's own, the frame, independence | `f863d4161` | A "+" tile opens the picker; the chosen colour becomes a tile. A gradient frame marks the choice. One pair of keys per surface. | Each selector; alpha 0, 50, 100 %. |
| 4D, 11 | Reading the wallpaper | `b5b4ffb54`, `78f037578` | One source with fallbacks (`HomeWallpaperSource`, `WallpaperAccess`); a host errand `readHomeWallpaper`; no storage permission request on Android 13+; saving the day/night wallpaper offers to pick an image where the wallpaper cannot be read. | Android 10 (system), 14 (root: **needs the module built from this version**), 16 (Shizuku: expect the colours and the pick button). |
| 4E | Text and button colour | `7faf0d09b` | Any colour from the picker, or "Default". Migration of `black_widgets` / `black_bar`. | An update over stored "Black" and over "White". |
| 4F | Two picker modes | `0782043ff` | Text mode (no alpha, "Default"); background mode (alpha slider 0–100 % with its label). Closing without "Select" changes nothing. | Both modes, both orientations. |
| 4G | Stats window settings | `5deeff937` | Seven rows became two; migration from what the service really drew. The colour mask bug (`0xff4285f4 & color`) went with the old writer. | The window looks the same after the update, for each old combination. |
| 4H | Background turned with the bar | `83e0e6267` | The picture is turned for the bar's side (`BackgroundAngle`, `RotatedDrawable`); the view is not. | The four sides; `hotseat_bg` on the right (D-57). |
| 5 | Floating button description | `ac63de9c1` | New text; the launcher's start condition now asks only for the enabled button's own panes, as its service did. | Left button with two panes set. |
| 6 | FYT / debug only | `63603dcc0` | The delay option and the compat lines are shown only where `showsFytOptions()`; a stale value is forced off. | Standard release on a phone; FYT; debug. |
| 7 | Titles wrap | `65c39b150` | `singleLineTitle=false` in six row classes and on 23 switch rows; four lines in six layouts. | Long titles at a narrow width; the controls keep their size. |
| 8 | Radio tap without a radio | `3e0b6efe2` | `WidgetLaunchRule`: the panes and the music are touched only when something can start. Same order for the other stock shortcuts. | A unit without `com.syu.radio`; the 7862 unchanged. |
| 9 | "No package ID 9c" | `60043b9c2` | Cell views get 24-bit ids (`CellChildId`), outside the resource id range. | The line is gone from the log. |
| 10 | Vertical bar's side; background on page 1 | `1d5a87aa9`, `5a2a36e1c` | **Cause found** [V]: the window was placed from the pager's own edge (−4520 px on the A55, as the owner's log says). Now from a page at rest. Bar backgrounds are part of the live look. | Both sides on every page, while swiping and at rest. The case "set left, shown right" is **not explained** by the cause [U]. |
| 12 | Stats over another launcher | `3e62b2fc1` | `StatsWindowRule`: the home window goes when the launcher stops; a window that does not belong to the app in front goes. | Launcher not the default + Home; a wake; listed → unlisted app; the 7862 as before. |
| 13 | Bar window leak | `4e73d1178` | The log marker that held the removed window is cleared. | LeakCanary after page swipes. |
| 14 | Title stops scrolling | `792ffb6d4` | `MarqueeRestart`: the bound texts scroll, the others do not. | **Cause is a reading of the code** [A]: 30 page changes with a long title. |
| 15 | fYT Rating | `7242003c8` | The log shows the bridge answers but has no rating until its screen was opened [H]. The launcher now logs the bridge's reason and starts its wake activity once (`RatingReplyRule`). | A log after a boot; whether ratings come without opening fYT Rating is **not known** [U]. |
| 16 | Bars reserve grid space | `405793b42`, `c96a8fd8a` | The bars' strips are cut out of the page; the cells share the rest (`WorkspaceGrid`). Items under a bar are moved once (`GridOverflow`). | See "The grid" below. |
| 17 | Rows and columns | `ca27a7637` | Two sliders (two below to four above 10 × 6) in the new category "Home screen layout", with the start page and the two text sizes. | Min, default, max; both orientations; restart. |
| 18 | Start page | `e122365db` | `StartPageRule`: a number that names no page is refused, and a stored one is reset when the pages are planned. | Type 99. |
| 19 | README | `52d75131c` | Four items shortened (about 470 → 245 words); Shizuku Next link; footnote ¹ without a time. | — |

## The grid: what happens on a device

- A page with the vertical bar has one column fewer, a page with a horizontal bar that does not hide one
  row fewer. The cell pitch on such a page changes by a few pixels; the icon size does not. **This applies to
  the 7862 too.**
- **The first start after the update** arranges the items once: where a bar is at the left or at the top the
  cell numbers of that page drop by one and the icons stay where they were; an item that lay under a bar
  gets the nearest free cell (its page, then the pages after and before it, then a new page). Nothing is
  deleted. The log line is `Grid <before> -> <now> (<orientation>): n items, m given a new cell […]`.
- The same runs when a bar is switched on, off or to another side, or the sliders are moved. A turn of the
  screen alone moves nothing.
- Going back to an older build afterwards shows the re-numbered items one cell off on such a page.
- Not covered: the built-in first page (user layout off) has a vertical bar that takes no column, as before.

## Deviations from the audit

| Where | The audit said | What was done, and why |
|---|---|---|
| Task 2 | Extend the touch area with a `TouchDelegate` | Not added: the rows already extend their touch areas (`TouchDelegateGroup`). |
| Task 6 | Split the two info strings into new keys | No new strings: `CompatInfoText` takes the compat line out of the localized text. |
| Task 10 | A sanity check that accumulating corrections are reset | The reference itself was wrong; fixed there, and `VerticalWindowFrame` trusts the measured bar only inside the box. |
| Task 12 | One `evaluate()` replacing every condition in `CanbusService` | A guard beside the existing conditions (D-57): the 7862's behaviour runs through that code and could not be tested. The home window is also asked for again at every launcher resume. |
| Task 4G | Default picture where nothing was stored | Default is no background, which is what the service drew (its defaults differed from the settings'). |
| Task 4D | A Shizuku level | Shizuku answers nothing to the errand (shell cannot open the wallpaper file); untested. |
| Task 15 | Retry on the bridge's next status answer | The existing 3/6/12 s retry repeats the request; one wake per five minutes. |
| Tasks 16/17 | `DynamicGrid` reads the settings; insets on the cell container | `DynamicGrid`/`DeviceProfile` are untouched, so the app drawer and the folders keep their grid. The container keeps the whole page and the cells are offset in it: the elements placed by pixels would have moved with an inset container. |
| Task 17 | — | The corner cell of an auto-hide bar is not kept where the handle lies in the vertical bar's strip. |
| Process | CI green between commits | Commits were pushed in stages; each stage's last commit was checked by CI, the others built locally. One intermediate commit (`c96a8fd8a`) was compiled alone to check it. |

## Outstanding

1. **The device review of everything above** (`KNOWN_ISSUES.md` KI-30).
2. The assistant's choices wait for the owner's word (`DECISIONS.md` D-57).
3. The icon text sizes and the grid can be set only while the user layout is on, because the second settings
   screen opens only then (KI-33). This follows from where the owner asked the rows to be.
4. StrictMode reports seen in the log of 2026-11-09 were not touched (KI-31).
5. fYT Rating: if the wake does not help, the fix is in that app (KI-32).
6. "Vertical bar set left, shown right" has no known cause.
7. The translations of the round's new strings are the session's own, as always (KI-23).
8. The Magisk module built from this version has the new errand; its version is still 1.0.0, as asked. An
   older module on a device simply does not answer it.
9. The Baseline Profile was not touched (it had no lines for the one deleted class).

## Files

169 files changed, 6342 insertions, 1690 deletions (`git diff --stat 886442bf7..ca27a7637` plus the README).

- **New plain classes with tests:** `WorkspaceGrid`, `GridOverflow`, `CellChildId`, `WidgetLaunchRule`,
  `FabButtons`, `BackgroundChoice`, `BackgroundAngle`, `ColorAlpha`, and in `settings/`: `StartPageRule`,
  `ButtonTextFit`, `CompatInfoText`, `StatsWindowRule`, `StatsBackgroundMigration`, `WallpaperAccess`,
  `RatingReplyRule`.
- **New Android classes:** `BarBackground`, `RotatedDrawable`, `RoundedColorDrawable`, `MarqueeRestart`, and
  in `settings/`: `WorkspaceGrids`, `GridSeekBarPreference`, `IconTextSizeRows`, `HomeWallpaperSource`,
  `ColorTileDrawable`, `SelectedFrameDrawable`; layout `stats_background_selector.xml`.
- **Removed:** `settings/AlphaSeekBarPreference`, `seekbar_preference_alpha.xml`.
- **Changed, targeted:** `Launcher`, `Workspace`, `CellLayout`, `ShortcutAndWidgetContainer`, `LauncherModel`,
  `LauncherApplication`, `LauncherMusicWidget`, `LauncherRadioWidget`, `LauncherFab`, `VerticalBarWindow`,
  `VerticalWindowFrame`, `PageBox`, `WorkspaceScreenPlan`, `WidgetBarLayout`, `WidgetBarLines`,
  `WidgetStyle`, `WidgetStyler`, `ViewTint`, `colorpicker/ColorPicker.kt`, five `com/fyt/widget` views,
  `com/syu/util/WindowHostVdClient`; in `settings/`: `CanbusService`, `BackgroundSelectorDialog`,
  `CreatorAppStats`, `CreatorBarBand`, `DrawViewAppStats`, `FytRating`, `FytRatingBridgeStarter`,
  `GridGeometry`, `Helpers`, `Keys`, both settings fragments and six `Custom*Preference` classes.
- **VD host:** `VdHostProtocol`, `VdHostStub`, `HostServices`, `HostFilePolicy`, `vdhost/README.md`.
- **Resources:** `creator_preferences.xml`, `launcher_preferences.xml`, eight layouts, `arrays.xml`,
  `ids.xml`, and all 59 `strings.xml` files.

## Strings

Added (all 59 languages): `start_page_missing`, `widget_bar_two_lines_title_first`,
`widget_bar_two_lines_artist_first`, `pip_restart_button`, `fab_overlay_controls_summary`,
`color_picker_alpha`, `color_picker_default`, `stats_in_app_page`, `stats_background_preference`,
`wallpaper_unreadable`, `home_layout_category`, `workspace_grid_rows`, `workspace_grid_columns`,
`workspace_grid_rows_note`, `workspace_grid_columns_note`.

Removed: `widget_bar_one_line_off`, `fab_overlay_summary`, `black_color`, `white_color`, `stats_bg`,
`bg_drawable`, `bg_color`, `bg_color_picker`, `bg_alpha`.

## Preferences

| Change | Keys |
|---|---|
| New | `workspace_grid_long`, `workspace_grid_short` (absent = 10 × 6), `workspace_grid_arranged_landscape` / `_portrait`, `widgets_tint_color`, `bar_tint_color`, `widgets_custom_background_color`, `bar_custom_background_color`, `vertical_bar_custom_background_color`, `stats_selected_background`, `stats_custom_background_color` |
| New value | `custom` in the three `…_selected_background` keys; `two_artist_first` in `widget_bar_line_mode` |
| Migrated once, then removed | `black_widgets`, `black_bar`; `stats_bg`, `bg_drawable`, `bg_color`, `bg_stats_color`, `alpha_seek_bar` and the picker's `red`/`green`/`blue`, `bg_red`/`bg_green`/`bg_blue` |
| Forced off where hidden | `cold_start_last_app_delay` |
| Reset when it names no page | `start_page` |
