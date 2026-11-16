# Round 14: implementation report (2026-11-15)

**Branch:** `testBranch`, code commits `6fbd5605b` … `c7ed19880`. **Plan:** written with the owner on
2026-11-15 (in Polish, outside the repository) after the owner's device test of round 13, then extended the
same day with six items from a second test on the 7862 ("round 14b"). There was no brief.

**State:** every commit builds; 123 test files, 1083 JVM tests, all pass locally; CI green on every push,
the last code commit included (run 491). **Nothing of this round has been run on
a device.** Tags as in `CLAUDE.md`: [V] code/git/CI · [H] owner · [A] assumed · [U] unknown.

## The owner's result for round 13 (2026-11-15) [H]

Works: tasks 1, 3, 5, 7, 8, 9, 12, 13, 14, 15, 16, 19; 6 seen in a debug build only. To fix: 2 (Restart
text), 4 (the colour tile and the selection frame), 10/16 (the bars in the overview on pages after the
first), 11 (the wallpaper), 17 (icon size in a dense grid), 18 (the keyboard in dialogs). `KNOWN_ISSUES.md`
KI-30 is closed with this.

## Owner decisions of 2026-11-15

1. "Pick wallpaper" in both dialogs opens what the "Wallpaper picker" row of Miscellaneous opens.
2. Night mode with "Use the default wallpapers" off and no saved picture for the mode: the wallpaper stays.
3. Android 16: the host reads the wallpaper itself first; access to all files only later, if refused.
4. KI-06 (UI tests, with a new test dependency) and Part B of `KNOWN_ISSUES.md` are opened again; KI-33 and
   KI-17 are not part of the round.
5. The vertical bar is as wide as the launcher counts it (about 155 px on an A55 in portrait), not the
   layout's ratio (about 139 px).
6. Robolectric (KI-06) is left for a later round: this session's network refuses one of its files.

## Commits

### Round 14, part A: the round-13 items to fix

| Commit | Subject | What to look at on a device |
|---|---|---|
| `6fbd5605b` | Settings: the Restart buttons keep their text on one line | a phone, font scale 0.85–1.3, a language with a long label (`lt`) |
| `34a2a006d` | Settings: a dialog with one field opens the keyboard | start page, margins, skip codes, inspector and logcat timeouts, Spotify client id, text sizes, the weather key |
| `f72e1bed2` | Backgrounds: the colour tile shows what is behind it, and a frame of more colours | a colour at 0, 50, 100 % alpha; the frame on light and dark tiles |
| `44ed8f4cb` | Night mode: a mode without a saved picture leaves the wallpaper alone | default wallpapers off, nothing saved: no change at sunrise or sunset, also on the 7862 |
| `ed61469d0` | Wallpaper: the launcher keeps a copy of the wallpaper it sets | A55 (Android 16): a wallpaper set with the launcher's picker is seen in the selectors and can be saved |
| `deaaffe08` | Wallpaper: "Pick wallpaper" opens the wallpaper picker of the settings | both dialogs, with each "Wallpaper picker source" |
| `dfe91dc85` | VD host: the wallpaper asked of the wallpaper service where its file cannot be opened | A55 with Shizuku: log `readHomeWallpaper: wallpaper service …` says whether shell may [U] |
| `6d58ebb93` | Workspace: an icon is made smaller where its cell cannot hold it | 14 × 10 and the default grid in both orientations, folders, dragging |
| `724564455` | Bars: a picture of the bars on the other pages while the pages are small | replaced in part by `1ca81e616` below |

### Round 14, part B: `KNOWN_ISSUES.md`

| Commit | Subject | KI |
|---|---|---|
| `11b5dc244` | Settings: display_pip is read with one default | KI-20, fixed |
| `0905bff8f` | VD host: the calls that bind the Shizuku host leave the main thread | KI-31, one of four places |
| `367cbc607`, `edfa41596`, `bce7ad204` | three observations of KI-26 (null check, worker thread, stored height) | KI-26, three of nine |
| `8b76509c4` | Weather: an OpenWeather key of one's own | KI-01 (two new strings × 59) |
| `590c153ec` | Compat: a report when a hidden member the launcher uses is missing | KI-12 |
| `11ea5c5ee` | Pinned PiP: the log says when the pinned app keeps coming to the front | KI-15, log only |
| `5392230c2` | Fuel stats: a picture of the window moves with its page | KI-21, **reverted** in `fe72e5a6f` |
| `0bd6971f6` | Strings: what the translation check found | KI-23: `StringResourcesTest`, two labels fixed |

### Round 14b: the owner's second test on the 7862 (logs of 17:28 and 17:34)

| Commit | Subject | Owner's item |
|---|---|---|
| `fe72e5a6f` | Fuel stats: back to the window that moves with its page | 4: the FABs and the stats window vanished while the pages moved |
| `4e983e0f5` | Workspace: the bars and the creator's elements lie at the page's edge, only the cells are centred | 2: the vertical bar a few pixels from the edge |
| `aade70cd1` | Bars: the vertical bar is as wide as the launcher counts it | 2: the margin to the bar larger than set (portrait) |
| `476013cf4` | Bars: one bar while the pages move, the page's own stays hidden under the window | 3: two bars laid over each other while the pages move |
| `1ca81e616` | Bars: the bars of the other pages in the overview are drawn from a recording | 3: the bars on every page in the overview |
| `b9c42eea5` | Media: "Unknown" is no title, "Unknown Pleasures" is one | 5 (`TitleTag`, copied from Display-Media-Titles) |
| `31fb072ab` | Media: a listener connected again starts from its first state | 5 (`NotificationListener` after a reconnect) |
| `605c2818d` | Music widget: a tap on play or pause acts at once and is not taken twice | 1: pause, play, pause for one tap |
| `45c6cc18b` | Bars: a touch on the bar's window is not lost to a stale page swipe | 1: the bar's buttons after an app (cause unknown, see below) |
| `c7ed19880` | Fuel stats: the window takes its full alpha whenever the limit reaches 1 | 6: see-through after a long sleep (Shizuku) |

## What was found, item by item (14b)

- **4 [V]:** `5392230c2` was the only commit of CI runs 486–487 that changes what is drawn while the pages
  move (on Android ≤ 10, the 7862). It made a bitmap of the stats window with `Bitmap.createBitmap(Picture)`
  at each start of a move and set the window's alpha to 0. The log shows it ran each time, and the render
  thread logs `setBufferCount(3) returned Invalid argument` after each start. Why the FABs went too is [A]
  (a hardware render of its own in the process); if they still vanish after the revert, a log of that
  moment is needed.
- **2a [V]:** `CellLayout.onLayout` moved every child of a page right by half of the pixels the columns
  leave over, the first page's bars included (7862: `page bar 1860,…,2002` on a 2000 px screen, and the
  window placed 2 px further left than asked). Now only the cells are moved (`WorkspaceGrid.firstCellX`).
- **2b [V]:** in portrait the vertical bar's XML width is `W,0.071` of its own height; the grid, the panels,
  the stats window and the creator count with `Launcher.calculatedVerticalBarWidth`. In landscape both give
  142 px on the 7862, which is why it looked right there.
- **3 [V]:** on the first page the bar is part of the page, and the bar's window came up over it at the start
  of a move while the page's own bar went on being drawn under it and moved away. `PageBarSwap`: the page's
  bar is hidden once the window has drawn, and shown before the window goes. The overview pictures were made
  with the same `Bitmap.createBitmap(Picture)` as item 4; they are now recordings drawn by the page.
- **5 [V]:** `cleanupResources()` set the titles to null while setStatus() goes on only when they are not
  null, and they are set nowhere else. Every check of "Unknown" now compares the whole value.
- **1:** two causes are in the code [V]. The pause of a session player was sent 350 ms after the tap, and
  the redraw at 500 ms showed the old state until the player answered (17:34:51.249 tap → 52.089 pause →
  52.627 icon). `PlayPauseRequest` holds one rule for every source. **Why the bar's buttons stop responding
  after an app is not known [U]:** the log has no trace of the taps, because nothing logged them; the
  binding of the buttons was checked and is right. Two plausible ways to lose a touch are closed (a window
  whose touchability was changed before its first frame kept the old one; a swipe fed from a bar's window
  stayed in progress across a pause), and every tap and every gesture the pages take from the bar is now
  logged. If the buttons still do nothing, the next log shows where the touch went.
- **6 [V/A]:** the system cuts the alpha at `addView` and at a relayout. The window was laid out again only
  when our raise was taken up within one second; after a long sleep it can come later [A]. `needsRelayout`
  lays it out whenever the limit is 1 and the window was last laid out under less.

## Deviations from the plan

- **A17:** with the default grid (10 × 6) the icon always has its standard size, whatever the cells: a guard
  so that nothing changes where the grid was not touched.
- **A11.2:** the text of `wallpaper_unreadable` was kept (same meaning; no new strings).
- **A11.3:** no copy is written where the system API gives the wallpaper (the 7862): no new files there.
- **A10:** the bar picture needed Android 9 for recordings; before, a plain bitmap (and no picture where
  the bar holds a hardware bitmap).
- **KI-31:** one of four places changed. `VdHostProtocol$Proxy.startActivity` from the main thread is the
  pane's start, which needs a rebuild of how panes start; `LauncherAppWidgetHostView.onLayout` and the toast
  in `FytRating` read disk inside the framework (Samsung's code in the stack). Described, not changed.
- **KI-26:** three of nine. `swapActivityViewSurfaces`, `WindowHostAvReaper` (the 7862's panes) and
  `refreshBtInfo` (needs the 7870's data) were not changed blind.
- **KI-15:** only a log line. The plan had a notice and a stop after three failures; without a log from a
  unit where pinned PiP fails, the rule could not be tested against anything, and a wrong rule would show a
  false alarm on the 7862.
- **KI-14:** the decompiled `com.syu.media` has no call that reloads its library; no change.
- **KI-21:** the picture of the stats window was made, then reverted at the owner's request (item 4).
- **KI-06:** not done. Maven Central redirects `nativeruntime-dist-compat` to a mirror this session's
  network refuses; the owner chose to leave it (decision 6). The work is not in the repository.
- **14b, item 1:** the planned commit "the bar's buttons are bound with the bar they are in" was not made:
  reading the code and the log showed both bars' buttons bound when each is built and the widget's views
  given back to the page's bar after every park.

## What a device has to show

The 7862 first for items 1–4 of 14b (it is where they were seen), then the A55 in portrait for item 2:

1. Pages moving with both bars on every page: one bar, standing still, no second bar under it; the overview
   from page 0 and from a later page, and dragging an icon: the bars small on every page.
2. The FABs and the stats window while the pages move: as before round 14 (KI-21's accepted state).
3. The vertical bar touches the edge on both sides in portrait; the widgets and PiPs lie at the set margin.
   On the 7862 (landscape) the bar's width stays 142 px.
4. One tap on pause or play in either widget: one change of the symbol, at once.
5. Open an app from the bar and come back: the bar's buttons on page 0 and on a later page. If one does
   nothing, the log lines `play/pause tap on the …`, `next tap …` and `BarSwipeFrame: The pages took the
   gesture …` say where the touch went.
6. A55 with Shizuku after a long sleep: the stats window without a see-through look (log
   `StatsOverlayAlpha: the limit is 1.0, the window was laid out under 0.8`).
7. A title such as "Unknown Pleasures" from the stock player and from a session player.
8. Everything of part A in the table above.

## Round 15 (2026-11-15/16): the owner's test of round 14 on the A55

**The owner's result [H]:** round 14 works except four points. Still to watch: the bar's buttons on the FYT
unit with `com.syu.music` (works on the phone), the media fixes (never seen), the statistics' alpha.

| Commit | Subject | Owner's point |
|---|---|---|
| `45673d58a` | Workspace: an icon or a widget may lie under the statistics window | 1 (D-65) |
| `d97219d98` | Tests: the grid's re-arrangement never puts two items in one cell | 2: the plan is not the cause |
| `e0564df9a` | Workspace: two items never share a cell after a load | 2 (KI-37, cause unknown) |
| `edce9c338` | Bars: the bars' windows lie in the launcher's window, under every floating button | 3 (D-64) |
| `f79b380b6` | Bars: the edge handle lies in the launcher's window too | 3 |
| `27cdb331e` | Bars: on every page without the permission to draw over other apps | 3, a consequence |
| `d167945ad` | VD host: access to all files may be allowed as the user can in Settings | 11 |
| `932d61d1c` | Permissions: access to all files is asked where the wallpaper needs it | 11 (D-60) |

**What was found:**
- **1 [V]:** the statistics window's placeholder took part in every reorder of a drop as an item that cannot
  move, and the first committed reorder marked its cells as taken.
- **2 [V/U]:** `GridOverflow` keeps the items apart on 3000 random home screens, and the loader refuses
  overlapping rows, so the overlap comes about on the page by a way that is not known. The guard moves the
  widget and logs `Items sharing cells on page …`.
- **3 [V]:** the bars' windows were overlays of the same layer as every floating button, and added later, so
  above them. As panels of the launcher's window they lie under every overlay of any app.
- **11 [H]:** with "access to all files" given by hand the selectors show the wallpaper (the owner). The flow
  asks for it now; the Shizuku host grants it at once, the root daemon once the module is built from this
  version.

**Deviations:** none from the plan; the edge handle was given the launcher activity explicitly (its window
manager adds the panel). **Not tested on a device.** What to look at: `KNOWN_ISSUES.md` KI-36.

## Round 16 (2026-11-16): widgets without their image, icons that disappear, a drop of "0x0"

| Commit | Subject | Owner's report |
|---|---|---|
| `e6349acf0` | Workspace: a widget that cannot be dropped stays where it was | "no room at 0,0 (span 0x0)": the widget went to the corner under a pane |
| `ef10031ab` | Model: an icon is shown when its app can start it, and mended where the app renamed its activity | icons gone after a change of the grid ("Invalid package kept") |
| `02bdd7f0a` | Widgets: a widget that cannot be shown shows its preview | Allegro's widget: "Error inflating RemoteViews", FileProvider |
| `75e2377a4` | VD host: a widget may be told to update itself | the same |
| `a654c0d60` | Widgets: a widget that failed to show is told to update, where the launcher may | the same (D-66) |

**What was found [V]:** the widget's minimum, counted anew from a denser grid, was larger than its size, the
search gave up with 0,0 0x0 instead of -1,-1, and the reorder was committed with the dragged widget at 0,0
before the drop refused the size. The loader judged icons by `getActivityInfo()` alone while the list of apps
finds them with `queryIntentActivities()`, and never logged why; the grid change only triggered a reload.
Allegro's image needs a grant the launcher loses at each new install, and Allegro ignores the request through
the options; only the system and root may send APPWIDGET_UPDATE.

**Deviations:** the check and the mending of icons are one commit (one verdict), not two. **Not tested on a
device** (KI-38). Unknown [U]: why Assistant is hidden in some loads and not in others; the next log gives the
reason with each hidden icon.

