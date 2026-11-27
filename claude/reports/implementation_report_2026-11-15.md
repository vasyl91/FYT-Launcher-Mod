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

### After round 16 (2026-11-16, the owner's logs of 09:02 and 09:11)

| Commit | Subject | Why |
|---|---|---|
| `f860da64d` | Widgets: the preview of a widget that cannot be shown is laid out as the host expects | the preview had ViewGroup layout parameters; `AppWidgetHostView.prepareView()` casts them to FrameLayout's, and in `handleViewError()` nothing catches that: the launcher crashed at every start |
| `4929e3da8` | Model: an icon is shown whenever the list of apps would start its app | `ef10031ab` still let `applicationInfo.enabled` (false on the A55 for Authenticator, Alior, Anki, Booksy, Bolt) hide icons the list of apps shows |

Both are my mistakes in round 16. Not tested on a device.
| `88bacd560` | Bars: the page's own bar is hidden in the frame its window is drawn shown | on the 7862 the page's bar was hidden ~900 ms after its window showed (a post behind the busy main thread), and not at all under a window built at that moment: two bars at the start of each swipe |

The owner confirmed on 2026-11-16 that the icons stay (`4929e3da8`).


## Round 19 (2026-11-16): a bar on every page that stands still (the owner's log of 10:12 on the 7862)

The owner: `88bacd560` changed nothing; "no jump and no flicker is acceptable". The log shows the first page's
bar hidden 118/127 ms after the windows were shown in the first move and 64/57 ms in the second [V].

| Commit | Subject | Why |
|---|---|---|
| `dffdd806b` | Bars: the windows of the bars on every page lie over the PiP panes | bars and panes were both panels; the one added later lay higher, so after a cold start a pane moving with its page passed over the vertical bar |
| `074c09350` | Bars: the bars' windows stay with the launcher's window when an app comes to the front | the windows were removed at every pause and built 250/400 ms after the return; a swipe in that time moved the first page's bar with its page |
| `33edcda65` | Bars: a bar on every page is its window on the first page too, and nothing swaps while the pages move | Android 10 cannot swap two windows in one frame; a frame of the swap during a move lasted 60–280 ms on the 7862 |

**What changed:** the bar on every page is its window on every page, the first one too; the first page's own
bar of that kind is hidden from the moment the page is built and seen only where the window steps aside
(overview, drag, folder, all apps), at rest. The windows are built in the page's first frame, kept while an
app is in front, never built or shown while the pages move (D-67).

**Deviations from the plan:** the windows are built in the first page's first frame (an `OnPreDrawListener`,
after its layout) and not at the end of `createUserPage()` with a correction afterwards: there the box and
the vertical bar are measured, so the windows cannot start in a wrong place and jump. That frame is in the
launcher's window, so the extra call in `Launcher.onAttachedToWindow()` was not needed. The swap at once
while the launcher is not in front uses one new method, `PageBarSwap.hideNow()`, for both that case and the
new page. `PERSISTENT_CROSSFADE_MS` was removed: in this mode both bars have one rectangle.

**What remains:** the swap where the window steps aside, at rest and in one place (at most one frame of a
darker translucent background); the vertical window of the mixed setting (vertical on every page, horizontal
on the first only) grows by the corner after the pages come to rest elsewhere; at a page build the windows
are drawn in the frame after the page's first [A].

**Not tested on a device.** To look at on the 7862 and the A55: swipes from the first page and between the
others at once after a start, after a return from an app and after a change of settings (no doubled bar, the
panes under the vertical bar); an app opened from the bar and the return (the bar does not go away, its
buttons answer); the overview, a drag, a folder, all apps; without "every page" the bar moves with the first
page as before. The log has "Bars on every page: …" when the page is built and no "hidden under its window"
in a move.

### Round 19b (2026-11-16): the owner's test on the A55 (logs of 13:25 and 13:30)

The owner: the other changes of round 19 work so far on the phone (the FYT is tested later); after the overview
the vertical bar stood a little higher until the next swipe; and, asked for: with the horizontal bar on the
first page only, the vertical bar should change its height smoothly as soon as that bar moves off or onto it,
not at the end of the swipe.

| Commit | Subject | Why |
|---|---|---|
| `d939d294a` | Bars: the bars' windows come back after the overview has ended, where the page lies at rest | the state is normal at the start of the way back from the overview; the window was shown then and placed on the bar measured on the small page (top 157 instead of 229) |
| (next) | Bars: the vertical bar grows into the corner as soon as the first page's horizontal bar has left it | the window took the other page's frame only when the pages came to rest |

**Deviation:** a change of state without an animation has no end callback here, so `setState(NORMAL)` posts one
more update after it; the check of full size has a tolerance of a thousandth. **Not tested on a device.**

The owner then: both work; in the overview the vertical bar of the pages without the horizontal bar was
shorter by that bar. Its picture was recorded from the window as it was on the first page, with the corner
left free; `VerticalBarWindow.recordAtFullHeight()` lays the bar out at the whole height for the recording and
back in the same step (commit "Bars: the picture of the vertical bar for the other pages has the whole
height"). Not tested on a device.

## Round 20 (2026-11-16): no item of a page outside its visible part (the owner's screenshot of 16:15, A55)

The owner: after a reorganisation of a page an item sometimes lies partly under the navigation bar; a music
widget in the screenshot. No log, so the way it took is not known [U].

| Commit | Subject | Way closed |
|---|---|---|
| `91db3326a` | Grid: an item keeps no stale temporary cell | an item laid out in a temporary cell from another page or grid (`addInScreen()` wrote only the cell) |
| `efe1e4fe9` | Grid: the padding of the first rows never pushes an item out of the grid | an item from row 0–2 to the last row reached 4–18 px past the grid |
| `dabe84886` | Grid: every item added, dropped or bound lies wholly in its page's grid | the drop's page from the last drag-over; an added widget saved with its full size where only its smallest fit; "no place" taken for a place |
| `69b495780` | Creator: an element lies wholly in the page's box | elements drawn at saved pixels past the page; the box taken for the screen without the status bar (2251 instead of 2116 px) before it was measured |
| `36cf3e7c3` | Workspace: an item outside its page is brought back after every change | any way not found: every page is checked after each drag and resize, with a log line |

**Deviations:** commit 3 only logs an item that `addViewToCellLayout()` adds partly outside the grid; the check
of commit 5 moves it (one way for all). The bound widget saved as 0×0 (`bindAppWidget`) is left to that check
too. The plan's step 6 (a system bar at the side in landscape) was not done: it changes the width, the scroll and
the panes' places of every page, and whether the A55 has such a bar is not known; KI-39 keeps it open. The
statistics window is not moved (its own window keeps clear of the bars). **Not tested on a device.**

## Round 21 (2026-11-16): the statistics window's full alpha with Shizuku after a start (log of 17:26, A55)

The owner: round 20 seems to work; the statistics window is again not at full alpha with Shizuku.

**The log [V]:** the window was added at 09.556 while the host was not connected yet (`RAISE: route
UNAVAILABLE`), so the system cut its alpha to 0.8. At 10.810 the host raised the limit to 1 (`result OK (cmd)`),
the setting read 1, and the window was laid out again once at 10.840 (`relayoutAsync=true … ch=false`). Nothing
followed: the rule (`needsRelayout`) was satisfied for good.

**Cause [A]:** the setting is not the window manager's copy of it; that copy is taken up by the system's own
observer a while after the write, and an app can read neither it nor the window's real alpha. A layout 30 ms
after the write most likely came before it.

| Commit | Subject |
|---|---|
| (this round) | Fuel stats: the window is laid out again a few times after the limit reaches 1 |

The window cut in a showing is laid out again at once, then 0.3, 1, 3 and 10 s after the setting is seen at 1,
and with every look of the minute while it is shown (`StatsOverlayAlpha.RELAYOUT_AFTER_MS`, `keepsRelayingOut`).
A layout with the same parameters changes nothing that is seen. The 7862 (a trusted overlay) is not affected.
If the window is still see-through after the series, the next step is to add the window again. Not tested on a
device.

## Round 22 (2026-11-18/19): the owner's log of 2026-11-16 18:42 on the 7862, and eight guidelines

The owner [H]: the statistics window moves over the vertical bar during a swipe (P1); the buttons of the bar's
music widget do not respond and its title and artist are not updated (P2); the vertical bar's width should be
adjustable, 4–10 % of the longer edge (P3); sliders of the number of icons on each bar (P4). Added on
2026-11-18: Robolectric in the repository (W1); a chosen number of icons is lowered only where it is above the
newly worked-out most, and nothing chosen means the most (W2); the guides below the app bar (W3); "Transparent
status bar" moved above "Set the start page" (W4); the bar's title and artist wrongly sized with "Resizable
horizontal bar" off (W5); the statistics window in landscape a few pixels below the creator's place (W6); the
settings list keeping its place (W7); one current list in `KNOWN_ISSUES.md` (W8).

| Commit | Subject |
|---|---|
| `62fc51126` | Build: Robolectric for tests of views |
| `bb7caf843` | Bars: the bar's views stay bound while its window stays |
| `e968fcaa2` | Bars: the title and the artist are sized the same with or without "Resizable horizontal bar" |
| `6449c7b22` | Settings: the guides lie below the app bar like the other screens |
| `a43efdf66` | Settings: "Transparent status bar" in "Home screen layout" |
| `d46e345ec` | Fuel stats: the window lies where the creator puts it, in landscape too |
| `cbd7c10cf` | Fuel stats: on the home screen the window lies under the bars, over the panes |
| `e703c9a55` | Settings: the list keeps its place across the screens it opens |
| `fa3e84d9e` | Bars: the vertical bar's width may be set |
| `5a6272396` | Bars: the number of icons on each bar may be set |

**What was found [V]:**
- P2: `Launcher.cleanWidgetBar()` let go of the bar's views (the music buttons' listeners, the title and
  artist, the weather) at every app start: from an icon, the bar's list, a widget, the settings button, the
  music widget. Since round 19 the window of a bar on every page stays while the app is in front, so nothing
  bound them again; round 19 had kept them only in `onPause()`. `BarViews.release()` keeps them while the window
  stays, and they go when the launcher's window goes.
- W5: with the setting off nothing sized the first page's bar. In portrait the widened music widget's XML height
  ("H,0.45" of its width, 216 px on the A55) is above the bar's 153 px; `MusicWidgetSizer` sized the text for that.
  `HorizontalBarDimensions.applyBarSizes()` now runs whatever the setting says.
- W6: the statistics (and the panes and the pinned PiP rectangle) took the `status_bar_height` resource as the
  page's top; the page lies on the window's real inset. `Launcher.getPageTopOnScreen()` gives the measured top.
- P1: the statistics were an overlay, above every window of the launcher. On the home screen they are a
  sub-panel of the launcher's window now, and the bars on every page one layer above (D-69).
- P3: `Launcher.calculatedVerticalBarWidth` was computed once and three places worked out 0.071 by themselves;
  the landscape layout's 7.1 % share was never replaced. `VerticalBarDimensions` is the one source (D-70).
- P4: `BarCapacity` gives the room; `BarIconCount` the rule; `BarIconLimits` the live most in the settings (D-71).
- W1: Robolectric 4.18 runs on JUnit 4 beside JUnit 5 (D-68); the owner allowed `gcp.mirrors.maven.org` for its
  large files. View tests of this round: the guides' insets, the bar's sizes, the vertical bar's width in both
  orientations, the rows' order, the scroll memory, the icon sliders.

**Deviations from the plan:**
- W4: the switch's code on screen 1 was removed, not moved: the row stores its value itself and the launcher reads
  it on return; nothing on screen 2 needed it.
- P3: the fallbacks for a process without the launcher (`PipEdgeTrim`, the creator) keep the old formula through
  a shared constant rather than reading the setting; the settings work the width out from the launcher's value.
- P4: the number counts only with the bar's "Resizable" switch on (D-74); the vertical most in the settings comes
  from the geometry, and the launcher shows min(choice, measured room).
- W7: the restore happens in `onViewCreated` of the new screen, before its first layout; a screen kept while an
  activity is in front keeps its own place.
- Strings: the four new ones are in the 51 full language files and `pt-rPT`, as the horizontal bar's are; the
  regional files fall back to their language.

**What a device has to show:** `KNOWN_ISSUES.md` KI-40 (and KI-34, KI-35, KI-38). Nothing of this round has run
on a device.

**The owner's result, 2026-11-19 on the 7862 [H]:** every fix of round 22 works, except that the second screen of
the settings jumped while it was scrolled up after a return, e.g. from the Canbus guide (log 09:40, which shows
only the screens' changes).

| Commit | Subject |
|---|---|
| `16f256ee8` | Settings: a row has its size when it comes on the screen |

The rows of the PiPs, the dual PiP, the widgets and the restart buttons gave their buttons and text their size one
post after they were bound. With the list's place kept (W7), the screen comes back below rows never bound, and
scrolling up each one came in at the top and grew a frame later; the list keeps its first row's top, so everything
below moved down. They are sized when bound now (`SettingsRowSizing`); only the restart buttons' widths change
after the layout, never a row's height. `SettingsRowHeightViewTest` (Robolectric, 2000 × 1200) goes the owner's way
and failed without the fix on the radio widget's row. KI-35 is closed by the owner's result. Not tested on a device.

**The owner's result, 2026-11-19 (log 13:16, A55) [H]:** every item of rounds 15–22 works, the settings jump fix
too. Two questions came with it:
- *"A widget that cannot be dropped, the widget preview: is that the toast 'App isn't installed' where the list
  offers widgets that cannot be added?"* No: those two items of round 16 were a widget dropped after a change of
  the grid at a size smaller than its minimum (`DropSpan`), and Allegro's widget that failed to show its content
  (`getErrorView`, its preview). The toast is another fault, found in this log [V]: the Google app's Stocks widget
  has a configuration screen its app does not export, the launcher started it with an intent of its own, the
  system refused, and `Utilities.startActivityForResultSafely()` showed the message of an app that is not
  installed; the bound id was left unused.
- *The widget over icons after a change of the grid (KI-37):* the log has two changes of the grid and no
  `Item out of place` line after either load, so nothing shared a cell.

| Commit | Subject |
|---|---|
| `660b032e6` | Widgets: the configuration of a widget is opened by the system |

The configuration is opened through `AppWidgetHost.startAppWidgetConfigureActivityForResult()`, with the background
start option from Android 14 (`WidgetConfigure`); if it still fails, a widget with optional configuration is added
without it, any other is not added, its id is freed and a new message says why. Seen in passing, not changed: the
wallpaper picker's two fallbacks (`WallpaperPickerLauncher`, `LauncherWallpaperPicker`) show the literal text
"activity_not_found" instead of the string. Not tested on a device.

**The owner, 2026-11-19 evening (logs 20:51 and a start at 20:59, A55) [H]:** KI-41 works, the widget that cannot
be dropped works; Allegro's widget shows its app's icon and the warning is still in the log; moving an item takes
both bars off the pages after the first. The owner asked to fix the wallpaper toasts and to look at the warnings.

| Commit | Subject |
|---|---|
| `fcfe712fd` | Bars: the pages after the first keep their bars while an item is moved |
| `a5e7a594c` | Wallpaper: the message when no picker opens is the text, not its key |
| `0e2ac7833` | Bars: an icon not loaded yet leaves its row empty, without a warning |

- The bars [V]: at each drag start both windows of the bars on every page park; the pages after the first got
  pictures of the bars only while the pages were small (the overview, a drag from all apps). A move within the home
  screen keeps them at full size, so there was neither window nor picture. The pictures now go up whenever the
  windows step aside while the pages are seen (`BarGhostRule`, `Workspace.barWindowsAside()`); a folder and the
  bar's list of apps had the same gap and are covered too.
- The warnings (KI-18): `BitmapDrawable created with null Bitmap` was the bars' rows bound before their icons
  (fixed); `RippleDrawable … no looper` is the widgets' inflation off the main thread (harmless); `LocaleConfig`
  comes from other apps' resource contexts; Allegro's `Error inflating RemoteViews` is Android's own line about the
  image it may not read (its widget has no preview picture, hence the icon); the rest is Samsung's framework or
  other processes. Found and not changed: the watchdog's second build of the bars' lists at a start (KI-43), and the
  fuel statistics asking for the GPS every 500 ms also on a phone (their design: the speed for the model).

Not tested on a device.

## Round 23 (2026-11-20): the home screen's check without timers, and the GPS of the fuel statistics

The owner, 2026-11-19 [H]: KI-42 works. KI-43 is to be done, without fixed intervals, repairing a real fault at once,
in any conditions, rebuilt at the root if need be. The GPS every 500 ms: check that the estimate runs only for a car
that gives its consumption from a certain speed (it does, D-13), and propose how the code check that waits for a drive
could do better.

| Commit | Subject |
|---|---|
| `f080ffbd4` | Home: the rules of a whole home screen, in one place |
| `75af342ab` | Home: the home screen is checked when it changes, not on timers |
| `71c8e0e03` | Fuel stats: the GPS only while something needs it |
| `7e955ba65` | Fuel stats: the code check sees the car move from its speed code too |

- **The home screen's check [V]:** the old recovery polled (350 + 400 ms; 0, 250, 900 and then 300 ms up to 8
  times; 400 ms up to 25 s; a 30 s window after a wake; 1.2 s for the focus) and took a part not ready yet for a
  fault. `HomeIntegrity` (pure, 15 tests) holds the checks and repairs of before, one by one, with the parts that
  are waited for; `HomeLayoutRecovery` judges after every pass of the window's layout from an event until the home
  screen is whole, the repairs in that pass. An event during an episode joins it and the steps taken stay taken, and a
  rebuild of the bars' apps on its way is waited for (`LauncherAppBars.appDataState()`), so the events a repair brings
  about cannot repair a fault for ever. The bars' delayed decoration refresh (300 ms) went too.
- **The GPS [V]:** `CanbusService` asked for it every 0.5 s whenever it ran. `LocationNeed` (pure, 8 tests) gives the
  rate each need asks for; `updateLocationNeed()` follows the changes; the code check reports its phase and takes a
  drive from the speed code too.

**Deviations from the plan:** none in substance. Seen while doing it: `initAppData()` can end without a build and
without a retry ("Max retries reached for RecyclerView, resetting"); the home check now starts it again once
(`APP_DATA_NOT_STARTED`) instead of waiting for nothing. `HomeLayoutRecovery` and `CanbusAutoCheck` have no tests of
their own: they need a whole Launcher, and a FYT unit with a car. Not tested on a device.

### The owner's result (2026-11-20)

The owner [H]: the home screen looks as it should and everything loads correctly. Their four logs [V]:

| Log | `HomeCheck` | The bars' lists |
|---|---|---|
| 7862, cold start (09:29) | waits for the pages, then for the bars' apps; whole after 7 passes, 2613 ms | one `initAppData()` |
| 7862, activity created again after the settings (09:32:05) | whole after 6 passes, 411 ms | one `initAppData()` |
| 7862, return from the settings (09:32:16) | whole after 4 passes, 201 ms; then whole after 2 passes, 42 ms | two calls, both "unchanged, skipping rebuild" |
| 7862, wake (09:32:25) | no line: the first judgement found the screen whole (such an episode logs nothing) | none |
| 7862, reboot (09:34) | whole after 6 passes, 2361 ms | one `initAppData()` |
| 7862, return from the settings (09:37:54) | whole after 4 passes, 159 ms; then whole after 2 passes, 39 ms | two calls, both "unchanged, skipping rebuild" |
| A55, start (09:31) | whole after 6 passes, 590 ms | one `initAppData()` |

No log has a repair, a "Layout unhealthy" line or a crash. KI-43 is closed. The GPS: the 7862 asks every 500 ms as
before, for the estimate's altitude; the A55 makes no request (no `RequestManager_FLP` line for the launcher) and logs
no `GPS:` line, since "none" from the start is no change of the rate (KI-44 corrected). One thing in the return from
the settings: its first episode ended "whole" while the page with the bars was still being bound, since a page not
built yet has no bar to judge; the episode opened by the binding's end judged the bars. Two StrictMode reports of the
launcher's own code, older than this round, went into KI-45.

## Round 24 (2026-11-20): KI-45, and CI only after a change of the code

The owner, 2026-11-20 [H]: a plan for KI-45 with all three proposed fixes, in a plan file of its own (the plans of
rounds 14–23 went to `../prompts/archive/plan-2026-11-15-rounds-14-23.md`, `1c3eddd84`), and a new general rule:
CI only when the code has changed, not after the documentation or work that does not touch the code.

| Commit | Subject |
|---|---|
| `46b59b2a7` | Build: CI only for pushes that change more than the documentation |
| `d4b1c8693` | Docs: CI after a change of the code only |
| `85f35583d` | Workspace: a launcher created again finds the screens in memory |
| `84a269d99` | Status bar strip: one window thread for the launcher's process |
| `32adc8b50` | Home: the bars are judged once the pages are bound, built or not |

- **CI [V]:** `build.yml` ignores pushes and pull requests of `claude/**`, `**.md` and `**.MD` only; such a push
  also no longer cancels the run of code pushed just before it (`cancel-in-progress`). Checked: the push of
  `d4b1c8693` started no run. `CLAUDE.md` holds the rule.
- **The screens [V]:** `ScreenIdsMemory` (pure, 4 tests) keeps the ids for every `Workspace` of the process: dropped
  before each write of their table, read again on `WorkspaceScreensPreload`'s own thread once it is committed
  (`LauncherProvider`: after the write outside a transaction, after `applyBatch`'s transaction). A read begun
  before a later write is refused.
- **The strip [V]:** one `HandlerThread` for the process instead of one per start of the service; no JVM test (no
  logic of its own), the device's log shows it.
- **The home check [V]:** `judgeBars()` waits for the binding before it asks whether a bar is used; 2 tests.

**Deviations from the plan:** none. Not tested on a device.

### The owner's result (2026-11-20 18:21)

The owner [H]: the status bar swipe works. Their log of the 7862 [V] (an older one from 18:08 was of an earlier
build and is not counted):
- the activity created again at 18:21:35 finds the screens in memory: no "screens not read ahead", no report from
  `WorkspaceScreensPreload.query`;
- "Setting up flushing for Thread[StatusBarSwipeWindow" once for 11 resumes, no report from `addOverlay`;
- the `HomeCheck` episodes after `recreateView` end after the binding (18:22:10.385 after "Loader 3 bind finished"
  10.198; 18:22:59.149 after 59.085). No repair in the log.

KI-45 is closed. The log holds two older StrictMode reports, fixed in round 25 (KI-46).

## Round 25 (2026-11-20): StrictMode, the order of the horizontal bar, the settings' rows and dialogs

The owner, 2026-11-20 [H]: a dialog in "Bars" to drag the horizontal bar's elements into an order (a tile with three
lines on each, the list following the settings and the orientation, its top the left of the bar), dividers between
the bars' sections, no blank summaries above dividers and a spacing that looks right on any device, the fixes of the
StrictMode reports found. Answers: one order per orientation, three sections, the dialog dark like the settings and
the same theme for the other dialogs.

| Commit | Subject |
|---|---|
| `6670ecf8b` | Widgets: the previews of the page shown first are read off the main thread too |
| `d61011f34` | Panes: a released ActivityView gives back its surface at once |
| `3dfae9e7d` | Settings: a row keeps its space under the title without a summary |
| `129fc7fc3` | Settings: dividers between the bars in "Bars" |
| `fdf25b8e9` | Settings: the dialogs in the colours of the settings |
| `989601f65` | Bars: the elements of the horizontal bar in the order chosen |
| `8118d0af9` | Settings: the order of the horizontal bar's elements |

- **StrictMode [V]:** the widgets tab read the previews of its first page on the main thread; every page now loads
  them in a background task (`PreviewLoadStart`, 2 tests). Android 10's `ActivityView` left `mRootSurfaceControl`
  to the finalizer; it is released with the view.
- **The rows [V]:** the nested rows carried their bottom space on the summary, which is GONE without one; the space
  is now the row's. `SeparatorSpacingViewTest` fails on the old layouts (`reset_night_mode`, 0 px) and passes now.
- **The dialogs [V]:** `SettingsDialogs` and `R.style.SettingsDialog` for all of them; 13 fields white instead of
  black; the colour picker dark; the selectors and lists keep the wallpaper behind them.
- **The order [V]:** `BarOrder` (pure, 6 tests) and `BarOrderLayout` tie the page's bar and the window from one
  source. Measured in Robolectric: the default order lies exactly as before where nothing is hidden; with the date or
  the weather hidden in landscape the page's bar moves by up to 21 px to lie as the window always did.
  `BarOrderViewTest` and `BarOrderDialogViewTest` check the order on the views and the dialog on the settings screen.

**Deviations from the plan:**
- The background selectors' frame comes from the theme; their title strip and button were already the settings'
  blue and white, now from the colour resources.
- The launcher's own list of apps for the bar (`dialog_fragment_applist`) takes the colour resources too; it looks
  the same.
- Not tested on a device.

**The owner's result (A55, 2026-11-21) [H]:** everything works as it should, except the dialogs after a turn of the
screen: the colour picker comes back, the background selector comes back too narrow in landscape with a stretched
wallpaper, the others are gone. The 7862 is not tested yet. Fixed in round 26.

## Round 26 (2026-11-21/22): the settings through a turn, the apps list fitted or hidden, the 7870's media

The owner, 2026-11-21 [H]: the dialogs after a turn (the colour picker as the example); "App icons" visible and
changeable without "Resizable … bar", for both bars; a switch under the widget bar that fits the apps list to its
icons, and one that hides it, only with the widget bar ("date and weather 10% each, the rest to the music"); the
7870 tester's "default picture until the cover or the track changes" and a position slider on the big widget for
files and BT; whether the 7862's pinned PiP could move with the pages, checked in the decompiled FYT framework the
owner added (`22490c9e0`).

| Commit | Subject |
|---|---|
| `edcee91a9` | Settings: an open dialog comes back after a turn of the screen |
| `5c109b2e7` | Settings: a download, a wallpaper save or an import goes on through a turn, with its dialog |
| `6361e8b5e` | Colour picker: its choice is stored after a turn of the screen |
| `362fa1375` | Settings: the background selector is sized for the orientation it is shown in |
| `ef8f97bc8` | Bars: the number of app icons is chosen with or without "Resizable ... bar" |
| `d1a5118b0` | Bars: the apps list fitted to its icons, its room to the widgets |
| `c97c6423d` | Bars: the apps list may be hidden, its room to the widgets |
| `08453d95d` | Settings: the apps list fitted to its icons or hidden, under the widget bar |
| `8ac8400a7` | Media (7870): a BT cover already on disk is taken after a start or a title that comes back |
| `1026d6b69` | Media (7870): the cover of a file is read as com.syu.media reads it |
| `18cc6e3f6` | Media (7870): a widget built again shows the cover of what plays or pauses |
| `6c525ff3e` | Media (7870): a position slider on the big widget |

- **A turn of the screen [V]:** on a phone `SettingsActivity` calls `recreate()` for the other orientation's density;
  round 25's fix for the order's dialog worked only where the settings stay (FYT). `SettingsDialogMemory` (pure, 4
  tests) and `DialogTurn` reopen a plain dialog the way a tap on its row does and put the fields' texts back
  (`SettingsDialogTurnViewTest`, `BarOrderDialogViewTest` with `controller.recreate()`). `HandedWork` (pure, 6 tests)
  hands a download, a wallpaper save or a canbus import to the new screen (`SettingsWorkTurnViewTest`, 5 tests).
  `ColorPickerTurnViewTest` failed on the old code in all four cases - "Select" and "Default" stored nothing after a
  turn, and replacing the second screen with a picker open threw "FragmentManager is already executing
  transactions" - and passes now. The lists of the statistics and of PiP were dismissed in `onPause` before the state
  was saved. The background selector took the launcher's size, which never turns (`BackgroundSelectorSizeViewTest`).
- **"App icons" [V]:** `BarCapacity.chosen` read the number only with the switch on; the slider's end needed no change
  (the room is a ratio of shares of the same width).
- **The apps list [V]:** `WidgetBarPlan.shares` (pure, 6 more tests) and `WidgetBarLayout.shares` feed the page's
  bar, the window, the tiles and the music cover from one source; `WidgetBarFitViewTest` (5 tests) checks 1 and 3
  icons and the hidden list in both orientations, nothing overlapping, the portrait list and weather at their height.
  Four places showed the list again (its setup, `enableRecycler`, the return to the home screen, the auto-hide's
  collapse); they ask `WidgetBarLayout.appsListVisibility`. Six strings in 59 language files.
- **The 7870 [V in the code, A as the tester's cause]:** three causes of the default picture: BT's cover file refused
  as old after a start, a cleared title or a clock jump (`StockBtCover`, 3 more tests); a file's cover read by an mp3
  and JPEG reader and a failed read kept (`FileCover`, `FileCoverRetry`); the cover drawn only while playing
  (`PausedCover`). The slider's IPlayer call was checked in the decompiled `com.syu.media` (`IPlayer.Stub`, case 12:
  `boolean seekTo(int)`).
- **Pinned PiP [V in the 7862's framework]:** it cannot follow the pages (KI-15, D-34).

**Deviations from the plan:**
- Commit 3 also leaves the app lists of the statistics and of PiP open through a turn (`SettingsActivity.onPause`)
  and drops `executePendingTransactions()` after a dismissal, which the test showed throwing.
- Commit 7: a hidden list keeps its adapter (a GONE RecyclerView makes no item views); the binding code is unchanged.
- Commit 8: the six strings went into the 8 regional files that already have the widget bar's rows too, with the text
  of their language.
- Commit 12: the slider is on every source of the 7870 (it only shows the position where it cannot move it), so the
  home widget's rows do not change with the source; a session's app gains no seeking from it.
- Found on the way, not changed: the canbus script's `--launcher .` needs the decompiled folders (KI-49).
- Not tested on a device.

## Round 27 (2026-11-22): the position slider for every player, "Start on wake"

The owner, 2026-11-22 [H]: the A55 works (round 26); KI-49 stays as it is, with the steps the owner wrote in
`canbus_library/README.md` (fill in what is missing); the position slider of the big widget for the other players
(the 7862, the apps followed through MediaController): where a source cannot move to a position the bar shows the
playback as before, and where there is nothing to show (a live YouTube stream, no information) it stays "grey" -
the colour of the part not played yet; "Start on wake" under "Start on boot" as a separate list started at each wake,
"Start on boot" only at the cold start.

| Commit | Subject |
|---|---|
| `7ec71e8dc` | Music widget: the position slider on every unit, empty without a position |
| `8f2259db1` | Music widget: the slider moves a session's track where the player allows it |
| `65a43ebc4` | Wake: the apps of "Start on wake" are started after each wake |
| `58b5c3365` | Settings: "Start on wake", a list of its own under "Start on boot" |
| `29ed543b3` | Docs: README for round 27 |

- **The slider [V]:** `PositionSlider.mode` (pure, tested) gives SEEK, SHOW or GREY from the length, a live stream and
  whether the player seeks. `MusicWidgetSizer` gives every unit the slider's row; `music_progress` stays hidden.
  `MediaTransportController.canSeek` / `seekToPosition` act only on the package's own session (a length and
  `ACTION_SEEK_TO`, `PositionSlider.sessionSeekable`, tested); the widget asks once per player, title and state.
- **"Start on wake" [V]:** `WakeAutostartPlan` (pure, 5 tests) says when it runs (not at a process start) and what
  comes back to the front; `WakeDetection.onWake` plans `ColdStart.startForWake` 3 s after the wake through
  `postForGeneration` (`wakeGeneration` is volatile now: the worker thread reads it). The dialog takes the list's key
  in its arguments, so it comes back after a turn with the same list (`WakeAutostartRowViewTest`); the Unisoc power
  sync releases the apps of both lists. Two strings in the 51 language files that have the autostart rows.
- **KI-49 [V]:** `canbus_library/README.md` now says how to unpack the zips for `--launcher`; with them unpacked that
  way both assets rebuild byte for byte.

**Deviations from the plan:**
- Commit 1: "grey" is the empty bar in the colour of the part not played yet (the owner's word during the round), not
  a grey tint of the bar's background as the plan had it.
- Commit 2: the log line is `MusicWidget: slider <pkg> seek|show (its session)`, written when the answer is asked
  for (a player, title or state), not "grey", which needs no question to the player.
- Commit 4: the two strings went into the 51 full language files only; the regional files have no autostart rows.
  One dialog serves both lists with its old tag (one at a time).
- The decision is D-83, not D-84 as the plan said: D-83 was the next free number.
- Not tested on a device.

**Owner's results (2026-11-25):** the A55 runs the launcher as before on Android 17 [H]. The 7862's log of round 25
(2024-12-07 on its clock) has no StrictMode report and no `LeakedClosableViolation` after pane changes and two openings of
the widgets tab, so KI-46 is closed [V]; the owner confirmed the panes, the order of the bar's elements and the dark
dialogs. Round 27 on a device: no result yet. com.syu.music (7862) cannot be moved to a position from another app,
checked in its decompiled code (`archive/decompiled/com.syu.music.zip`, KI-50).

## Round 28 (2026-11-26): crashes, one accent colour, the home screen's gestures, the app drawer, the badges

The brief `prompts/active/sonnet-prompt-2026-11-25-round-28.md` [H]: the owner's 25 points, the logs and 20 crash logs of
2026-11-25; 36 commits in groups A to J (A fixes, B the music slider, C accent, switches and
"Stock layout", D the home screen, E the bars, F the app drawer, G the widget list, H the badges, I the autostart and the
welcome texts, J the documents). Built in a cloud session without an Android SDK, so the only build check was CI: each
code commit was pushed on its own and the next one waited for its green run (39 code commits, runs 582 to 620). The
documents (J1, J2, this section) are `Docs:` commits that start no run.

| Commit | CI run | Subject |
|---|---|---|
| `0dc2cb603` | 582 green | Crashes: the package receiver no longer builds the launcher's state |
| `e87d98fb4` | 583 green | Crashes: the workspace has its settings before the first touch |
| `fb9ef31c5` | 584 green | Build: the settings' preferences keep their constructors in release |
| `779cf9bd0` | 585 green | Bars: the persistent vertical bar is placed only at rest and put back if moved |
| `1b1d589df` | 586 green | Stats: the in-app window never over the launcher's own screens |
| `9d23674f0` | 587 green | Logcat: a stop ends the capture within seconds |
| `baa2432fc` | 588 green | Start: before the first unlock the launcher shows the wallpaper |
| `0b2416ae4` | 589 green | Widgets: the launcher's four own app widgets removed |
| `6d7e353ec` | 590 green | Music widget: the slider in the bar's colour, centred on its line |
| `e7a02c8b4` | 591 RED | Music widget: the slider owns its touches, in a larger touch area |
| `95e9fcf2f` | 592 green | Music widget: the pager test makes its pager without a launcher state |
| `e2efbd02d` | 593 green | Theme: one accent colour, chosen in "Set global theme color" |
| `6abbcbbb3` | 594 green | Settings: every switch in the accent colour |
| `097151264` | 595 green | Layout: "Stock layout" applies none of the creator's settings |
| `e7d07089e` | 596 green | Home: an icon text colour of its own |
| `0f52026dd` | 597 RED | Home: swipe up opens the app drawer, swipe down the notifications |
| `dc38693cd` | 598 green | Home: the accessibility service's helper no longer clashes with the framework's method |
| `c23e3e01e` | 599 green | Home: a double tap does nothing, locks or turns the screen off |
| `6ac46639f` | 600 green | Folders: a background of their own |
| `fd4f5ff08` | 601 green (second attempt) | Folders: the home screen's grid inside, if chosen |
| `7eb117b58` | 602 green | Widgets: free placement and size on the home screen |
| `0bcd94429` | 603 green | Widgets: may overlap other items |
| `cd17c8117` | 604 green | Autostart: BOOT_COMPLETED for "Start on wake" too, the note per device |
| `3863fff6f` | 605 green | Strings: "Launcher Mod" and a shorter welcome per device |
| `fef9ab744` | 606 green | Badges: notification counts on the icons |
| `1e9f52db4` | 607 green | Settings: "Notification badges" |
| `25d41eb6e` | 608 green | Settings: an "App drawer" section under "Bars" |
| `a962bc905` | 609 RED | App drawer: vertical scrolling with a letter bubble |
| `f26a907f1` | 610 RED | App drawer: the letter scroller test has room to scroll |
| `8ee0e2d41` | 611 green | App drawer: the letter scroller test fills its rows exactly |
| `f77fb7688` | 612 green | App drawer: a search bar |
| `ef821153d` | 613 green | Settings: the drawer tabs' model and the lists of apps |
| `4559d1959` | 614 green | Settings: the tab creator |
| `acad3b91c` | 615 green | App drawer: tabs |
| `e8b91b683` | 616 green | Bars: "Display vertical bar" |
| `b7f33bebf` | 617 green | Strings: the descriptions of the home screen switches as the owner worded them |
| `3425f8bb4` | 618 green | Bars: the rule for sharing the room of the widget bar, as a tested model |
| `1e767f5fc` | 619 green | Widgets: the grouping of the widget list, as a tested model |
| `0751ebbb6` | 620 green | App drawer: the strip of tabs goes with the apps |

The 39 code commits are not a one-to-one match with the brief's 36: the parts that were not built are missing, and the
fixes and corrections of the deviations were added. Not in the table: the `Docs:` commits (README, the project library,
this report), which start no run.

**What was built [V: code and tests; none of it tried on a device]:**
- **A1 to A8, the crashes and the start:** the package receiver builds no launcher state; the workspace has its settings
  before the first touch; the settings' preferences keep their constructors in a release build (R8, KI-53); the
  persistent vertical bar is placed only at rest and put back if moved; the in-app statistics window never opens over the
  launcher's own screens; a logcat stop ends within seconds (D-84); before the first unlock the launcher shows the
  wallpaper; the launcher's four own app widgets are gone.
- **B1, B2, the music slider:** in the bar's colour and centred on its line; it owns its touches, in a larger touch area.
- **C1 to C3:** one accent colour for the settings, chosen in "Set global theme color" (D-86); every switch in it;
  "Stock layout" applies none of the creator's settings (D-85).
- **D1 to D7, the home screen:** an icon text colour of its own; swipe up opens the app drawer and swipe down the
  notifications; a double tap that does nothing, locks or turns the screen off (D-91); a background of their own for
  folders, and the home screen's grid inside them if chosen; widgets with a free place and size, and overlapping other
  items with a question first (D-92).
- **I1, I2:** BOOT_COMPLETED also starts the "Start on wake" list, with a note per device; the texts say "Launcher Mod"
  and the welcome is shorter per device.
- **H1, H2, the badges:** notification counts on the icons (`BadgeModel`, `BadgeViews`, `BadgeDrawable`) and the screen
  "Notification badges" (D-90).
- **F1 to F6, the app drawer (D-88):** an "App drawer" section under "Bars"; vertical scrolling with the letters of
  `LetterIndex` and a bubble (`AppsVerticalView`, `LetterScroller`); a search bar; the model of the tabs (`DrawerTabs`,
  `DrawerTabsStore`, pure, tested) and the lists of apps (`DrawerAppList`, `DrawerAppsFragment`); the tab creator
  (`DrawerTabsFragment`, `DrawerTabDialogs`); the tabs themselves (`DrawerTabStrip`, `DrawerTabGeometry`, the swipe
  `AppsVerticalView.TabSwipe`) and their place, top or bottom, which is a creator key.
- **E1, the vertical half:** the switch "Display vertical bar" (`display_vertical_bar`).
- **The models only (KI-52):** `BarShares` (D-87) and `WidgetGroups` (D-89) are pure and tested, and nothing calls them.

**CI that went red, and why:**
- **591** (B2): the test of the music pager needed a launcher state that a test does not have; `95e9fcf2f` (592) makes its
  pager without one.
- **597** (D2): a compile error. The static helper `StateAccessibilityService.performGlobalAction(int)` clashed with the
  framework's instance method of the same signature. It was renamed `perform(int)` (`dc38693cd`, 598); the queue of the
  later commits was rebuilt on top of it, with no `--amend` and no force-push, and the call that D3 adds was written
  with the new name.
- **601** (D5): the first attempt failed in the unit tests because Maven Central answered HTTP 429, not because of the
  code. The failed job was run again and passed; no commit.
- **609, 610** (F2): the test `theScrollerPutsTheListAtTheFirstAppOfALetter`. In 609 all six rows of the list were in view,
  so the list could not scroll. In 610 the rows were 466 px in 1400 px, 1398 px in all, and the layout closed the 2 px gap
  by scrolling back, so the first app in view was one of the row before. **The cause of 610 was worked out from the RecyclerView
  code and the sizes, not seen:** the Gradle log of CI prints the line of a failed assertion and not its message, and the
  test report is out of reach of a session. The test now has rows of 700 px (`8ee0e2d41`, 611, green) and one assertion for
  each way it can fail. The code of the drawer did not change.

**Deviations from the brief:**
- Strings: the new ones are in the 51 full language files, not in all 59. The 8 regional files (`en-rGB`, `en-rIN`,
  `es-rUS`, `et-rEE`, `fr-rCA`, `ms-rMY`, `pt-rPT`, `zh-rHK`) are short overrides of their language and take the new
  texts from it, as in round 27. The commit messages of C1 and D1 wrongly say "all 59 files".
- A corrective commit for the strings (`b7f33bebf`): eight English texts (`folder_follow_grid_*`, `widget_freeform_*`,
  `widget_overlap_*`, `widget_overlap_off_title` and `_message`) were set to the brief's wording, in all languages.
- B2: no `TouchDelegate`; the larger touch area stays inside the slider's own view.
- D3: no Robolectric test of the workspace's double tap.
- D4: the string names are `folders_background_*`.
- D6: a widget placed new has no "start frame".
- H1: the views tell the model that a count changed through a registry (`BadgeViews`), not through
  `Launcher.onBadgesChanged`; the test of `BadgeDrawable` does not compare pixels.
- F1: a test of the order of the preferences in the XML of the screens instead of the Robolectric `PreferenceScreensTest`.
- F2: no `DrawerDragSource` class; the drag to the home screen is the pager's, passed on through `AppsVerticalView.Host`.
- F4, F5: one `DrawerAppsFragment` serves both lists of apps (L1, L2); the string `drawer_tabs_category` was not created
  (the existing `drawer_tabs` is the row); the "repeat" rule is stored inside the string of the model, not under a key of
  its own; the dialogs do not use `SettingsDialogMemory`, so a phone's turn closes them. In the F4 commit nothing opened
  the lists of apps yet; F5's dialogs do.
- F6: with fewer tabs than the visible count they share the bar's width; the speed of a swipe is the greater of the
  tracker's and the swipe's average.
- E: only the vertical half of E1 was built. **E1 horizontal, E2, E3 and G1 were not built** (KI-52); `BarShares` and
  `WidgetGroups` are their models. The reason: the bar's place is decided at about a dozen places of `Workspace`,
  `Helpers` and `Launcher`, and the widget list is the way widgets reach the home screen; neither can be tried without
  a device, and a regression there would be on the 7862's home screen.
- The extra commits of this round: the fixes `95e9fcf2f`, `dc38693cd`, `f26a907f1` (it did not fix the test),
  `8ee0e2d41`, and `0751ebbb6` (the strip of tabs goes with the apps: `setContentType` now calls `syncTabs()`).
- **Flaws in commit messages that stay** (no `--amend`): C1 and D1 say "all 59 files"; the message of D5 has a stray
  "Co-Authored-By below."; F3 has a garbled sentence about the strip; B2 has "also at rest-less pages"; C1 states that
  there is no action bar and that was not checked; F5 has a wrong sentence about the colour of the "+" tile.

**What a device has to show [KI-51]:** none of the 39 commits was tried on a device. The unit tests do not tell whether a
finger's swipe is taken by the right view. The list is in KI-51; the points that need a finger: the swipes and the double
tap on the 7862 (the quick settings panel, "Turn off screen" and the same double tap bringing the screen back), the tab
swipe and the strip's place in the drawer, free and overlapping widgets, the slider of `com.syu.music` (no knob), and the
settings of a release build (A3, KI-53).

## Round 29 (2026-11-27): the A55's results, the start at the unlock, widgets by pixels, the drawer, the bars' switches, the text size

The owner's message of 2026-11-27 [H]: the A55 results of rounds 27 and 28 (KI-51), a crash log of the debug build after a
restart, observations and fixes, two new options (the fuel estimate's switch, the settings' text size), seven points of
performance, the CI's speed, what round 28 left out (E1 horizontal, E2, E3, G1), and the request to plan it in detail and
implement it in this session. During the round the owner added the 7862's keyboard under the bars. The plan, in Polish, is
`../prompts/archive/plan-2026-11-27-round-29.md`; the owner chose CI in batches with a faster CI (D-93) and tabs that split
the strip evenly.

Built in a cloud session with the Android SDK: every commit with code was compiled and its own tests run; the whole suite
and both debug builds ran at the end of every batch, and CI ran once per batch on its last commit.

| Batch | Commits | CI run |
|---|---|---|
| P0 | `e13ee4080` CI: one Gradle run, a cache written on testBranch, Robolectric's jar through Gradle; `50c7ddc0e` Docs: CI in batches | 624 green (7 min 43 s; run 623 before it took 11 min 47 s) |
| P1 | `35366adbf` Start: after the first unlock the home the user chose, no relaunch; `12c0f0b7d` Music widget: a liked heart keeps its own red; `69fbd7bb6` Theme: the PiP and widget rows' buttons in the theme colour; `2295aac0c` Settings: rows of their own layout look dimmed when off; `f220a590a` Home: a swipe from a clear move only, the drawer at once | 625 green |
| P2 | `75da43320` Folders: the home screen's icons and text inside with "Follow home screen grid"; `658a08b68` Widgets: "Freeform widgets", the frame and the widget move together; `fe496ccba` Widgets: overlapping widgets go exactly where they are dropped, nothing is pushed | 626 green |
| P3 | `27f51efc0` App drawer: icons drag from the vertical list to the home screen; `f921f41d6` App drawer: the letter scroller moves smoothly and hides when nothing scrolls; `2d48449f4` App drawer: the search bar, the tabs and the apps evenly spaced; `25c25f633` App drawer: the apps of a new tab show at once after a swipe; `3524adeb1` App drawer: "Keep apps in main app tab" only where the rule needs it, the rule in a sentence; `7dabc2158` Settings: the tab creator's sizes, its dialogs after a turn and the lists of apps | 627 green |
| P4, P5 and the keyboard | `a016cc7f7` Badges: size by a slider of 15–35 % of the icon, the number at 85 %, wider towards the icon; `34d4be595` Fuel statistics: the estimate below the threshold only when switched on; `f727fc0ed` Bars: the keyboard of a PiP above the bars on the 7862 | 628 green |
| P5 | `76a4a7fbc` Settings: the text size of the settings, 70–150 % | 629 green |
| P6 | `fe456f31f` Bars: "Display horizontal bar"; `a149a178c` Bars: the app drawer button and the music widget may be hidden, the room shared by one rule | 630 green |
| P6 | `5c3c8bc19` Widgets: a list of apps with their widgets and shortcuts, with search | 631 green |
| P7 | `7c1092873` Memory: wallpapers decoded at the screen's size; `9b6b4b000` Memory: widget previews in a cache counted in bytes, freed on trim; `e4889251e` Workspace: the settings of a touch read once, kept until they change; `77f440135` App drawer: the pages of the horizontal drawer made only when it is shown | 632 green |

Then the `Docs:` commits (the README, the project library with this report), which start no run. At the end of P7 the
suite had 1660 tests, all green (1557 at the start of the round).

**What was built [V: code and tests; none of it tried on a device]:**
- **CI (D-93):** one Gradle run, the cache written on `testBranch`, Robolectric's `android-all-instrumented` resolved by
  Gradle and read offline (the 429s of runs 574, 601 and 622), the tests in half the cores' forks. The runs of the round
  took 6 to 9 minutes.
- **The start (D-99, KI-54):** at the unlock the locked activity ends and the system starts the chosen home; the crash of
  the relaunch with a kept window (`Workspace.onAttachedToWindow` without the drag controller) cannot come back.
- **P1:** the liked heart keeps `music_favorite_p`'s red; the five `Custom*Preference` rows read `ThemeAccent` when their
  buttons are sized; rows of their own layout are dimmed to 0.38 when off (`SettingsRowDim`, `DimmingPreferenceAdapter`);
  `HomeSwipe` takes a swipe only before the long press timeout and fires on the move.
- **P2:** folders follow the page's icon size, text size, colour and shadow with "Follow home screen grid"
  (`FolderItemLook`); freeform and overlapping widgets by pixels (D-96: `FreePlace`, `ResizeGeometry`, `PipEdge`, no reorder
  while an overlapping widget is dragged).
- **P3:** the drawer's drag from the vertical list (`VerticalDrag`, `beginVerticalDrag`), the letter scroller by the
  list's scroll fraction (`ScrollFraction`), one 8 dp gap (`DrawerSpacing`), a new tab's page at once, the keep rule
  (D-94, `ListText`), the tab creator's 48 dp buttons, its checkbox beside the text, its dialogs after a turn and its
  lists with a preference title's text.
- **P4, P5:** the badges' slider (D-95, `VisibleBounds`, `BadgeSizeSeekBarPreference`), the fuel estimate's switch (D-97),
  the settings' text size (D-98).
- **The 7862's keyboard (D-100, [A]):** `ImeAnchor`, a 1×1 target for the keyboard above the bars on Android 10 and
  older.
- **P6:** "Display horizontal bar" (the bar gone from the pages and the window, the grid gets its room, its rows
  hidden, the swipe up locked on), the drawer button and the music widget hidden with `BarShares` (D-87), the widgets'
  list (D-89).
- **P7:** wallpapers for a backdrop decoded to cover the screen (`SampleSize`; "Save the day / night wallpaper" whole,
  the night mode at half size as before and smaller only for huge pictures); widget previews in an `LruCache` counted in
  bytes, keyed by size and name, emptied from "running low" on (`PreviewCachePolicy`); the bars' sides, the corner cell
  and the swipes kept between changes of the settings (`KeptReading`, `TouchSettings`) for `CellLayout`'s search for a
  cell and `HomeGestures`; one rule for the drawer's three views (`DrawerContent`) with the pager's pages left empty while
  a list covers it.
- **Measured, no code:** R8 keeps 724 of the 726 `Callback_*` classes (reached by `new` in `HandlerCanbus*`, and seeds of
  the `IInterface` rule) and 12 classes of `com.syu.ui` (KI-58); `largeHeap` is `false`; the large logcat buffers are set
  only with the boot log.

**Deviations from the plan:**
- Per commit the changed code was compiled and its own tests run; the whole suite and both builds ran at the end of every
  batch, not after every commit.
- No view test of the double tap, of the drag from the vertical list, of the drawer's spacing or of a tab's first page:
  the Launcher activity and the drawer's pane (`AppsCustomizeTabHost`) do not inflate in Robolectric. Their rules have
  plain Java tests (`DoubleTapTest`, `VerticalDragTest`, `DrawerSpacingTest`, `DrawerTabGeometryTest`); KI-57.
- Commit 15 is two: `3524adeb1` (the keep rule and its sentence) and `7dabc2158` (the sizes, the dialogs, the lists). The
  names are joined by `list_separator` and `list_last` with `drawer_tab_quoted`, not `list_pair`.
- "Freeform widgets" is the new English title only; the other languages keep their translation of the old one.
- E2 and E3 are one commit (`a149a178c`). The hidden drawer button keeps no width but stays VISIBLE (the auto-hide bar and
  the bar's order depend on it). `BarShares` is used only while the button or the music widget is hidden; otherwise the
  bar is laid out as before.
- The text of the settings wraps without a limit only above 100 %.
- The widgets' list counts without plural forms ("Widgets: 1, Shortcuts: 3") and has no description line.
- A widget added from the list still lands on cells with overlap on (its drop goes through the widget's configuration).
- `ImeAnchor` runs only on Android 10 and older; it rests on a reading of Android 10's window manager [A].
- The fuel estimate is off by default, so a user who saw it before sees it only after turning the switch on. The old
  `badges_size` is not read any more and not migrated.
- P7, item 23: the change is in `CellLayout` and `HomeGestures`; `Workspace`, `PagedView` and `DragLayer` read no setting on
  a move. The test counts the readings of a counting `SharedPreferences`, not through the test application.
- P7, item 24: the icon cache is not changed: each icon is held by its `AppInfo` or `ShortcutInfo` too, so evicting it
  would free nothing, and reading it again could reach the disk cache on the main thread.
- P7, item 25: the night mode keeps its half size as a floor, so nothing looks different on the 7862.
- P7, item 26: the pages are still made, as empty frames, so the code that asks for a page finds one. The commit also
  fixes G1's pager showing under the widgets' list when the drawer opened on the widgets.
- P7, items 27 and 28: no code; the facts are above and in KI-58.

**Not tested on a device:** all of it. The owner's lists are in `../PROJECT_STATE.md` ("Active tasks") and KI-55 to
KI-57; the 7870's in `../checks/7870.md`.

## Round 30 (2026-11-27, evening): the owner's test of round 29

The owner's message of 2026-11-27 evening [H], with the logs of freeform and overlapping widgets, of a restart and a crash:
the keyboard of a PiP on the 7862 and the restart work (KI-56, KI-54 closed); "Hide the app drawer button" with the bar on
every page, its row's look, the category titles, "Display horizontal bar" off, the frame of freeform widgets, the list of
widgets, the dialogs, the change of tab in the horizontal drawer, the letter bar on the 7862, the gap above the apps and
the crash were to be fixed. The plan, in Polish: `../prompts/archive/plan-2026-11-27-round-30.md`.

| Batch | Commits | CI run |
|---|---|---|
| Q1 | `ebe752b53` Widgets: each preview made at the size it was asked for; `7e4191d34` Settings: category titles in their own colour again; `12194c5ca` Settings: "Hide the app drawer button" as the bar's other switches; `63e556151` Start: the root check of the PiP log off the main thread | 633 green |
| Q2 | `bc63f2c50` Bars: the app drawer button hidden in the bar's window too; `91c8828a3` Bars: "Display horizontal bar" off leaves nothing of the bar | 634 green |
| Q3 | `b9b3df2d7` Widgets: a freeform widget drawn exactly in its frame, dropped where it is let go; `824f1f167` Widgets: the resize frame of a freeform widget stays on it | 635 green |
| Q4 | `096a78edd` Widgets: the list shows the widgets themselves, with the brief's texts; `cbf38e50a` App drawer: a gap above the apps at the top; `dc77d55e3` App drawer: the letter scroller as thick on every screen; `1435c468b` App drawer: the tabs of the horizontal drawer one after another, scrolled smoothly | 636 green |
| Q5 | `0c748c6a5` Settings: the background, colour and app dialogs one size; `e42cbbd54` Settings: the dialogs' text as large as the settings' rows | 637 green |

Then the `Docs:` commits (README, this section and the library). At the end the suite had 1695 tests, all green (1660 at
the start of the round).

**What was found and built [V: code, logs and tests; none of it tried on a device]:**
- **The crash** ("Improperly sized bitmap passed as argument"): the list of widgets set the loader's preview size on the
  main thread for each cell while a preview of another size was made in the background, which read the size three more
  times. Each request carries its size now (`PreviewCachePolicy.size`, `fits`).
- **The category titles:** androidx's `PreferenceCategory.isEnabled()` is always false, and round 29's dimming took it for
  off (`SettingsRowDim.looksOn`).
- **"Hide the app drawer button":** the bar on every page is a window, and `forceOriginalSizes` gave the button its width
  back after the layout's rule, with its click listener (`BarWindowWidths`). The row is a `SwitchPreferenceCompat` like
  the bar's others.
- **"Display horizontal bar" off:** the bars' set-up and the recovery showed the apps list again
  (`WidgetBarLayout.appsListVisibility`); the vertical bar kept a corner for the first page's bar
  (`VerticalBarCorner.applies`); `BarLayouts.of` now gives no page the bar.
- **Freeform and overlapping widgets (D-105):** a freely placed widget was laid out at its frame's full size with the scale
  and translation of its cells left on it, the drop counted with the laid-out size (457x615 seen, 543x731 kept in the
  owner's log), the resize frame was placed from the view's old place and committed its own rectangle when put away (the
  log's "resized, frame 0,1347" without a resize), and a resize was checked against the widget's own cells.
  `FreeformLayout` makes the frame the seen rectangle; the resize frame is placed from it and writes nothing without a
  handle moved; the vacancy leaves the widget's own cells out.
- **The list of widgets (D-104):** the previews without the pager's card, cropped to what can be seen, the brief's texts
  under them, "1 widget, 3 shortcuts" from plurals in the 51 languages, the rows centred at 90 % of the search field.
- **The drawer:** a gap above the apps always (`DrawerSpacing`), the letter bar's dp at least the A55's share of the
  shorter side (`ScrollerSize`), and with horizontal pages every tab's pages in one pager (`TabPages`, D-103).
- **The dialogs (D-101, D-102):** one size rule (`SettingsDialogSize`, `DialogFrames`) and the text of a settings row
  (`DialogText`); `dialogTextView` and `dialogTitle` are gone.
- **StrictMode in the restart log:** `isRooted()` off the main thread; the read inside Samsung Knox through
  `resolveIntent` is the system's (KI-31).

**Deviations from the plan:**
- Commit 6: the Robolectric test checks the list's visibility and the vertical bar's geometry through
  `WidgetBarLayout` and `BarLayouts`, not on a built page (the Launcher does not inflate in Robolectric); likewise commit 5
  tests the window's widths in `BarWindowWidths`, not on the window.
- Commit 8: no Robolectric test of `resizeTo` on the widget's own place (a `CellLayout` needs a `Launcher`); the geometry
  has its test (`ResizeGeometryTest`) and the vacancy is `occupiedWithout`.
- Commit 9: the cells stay the pager's `PagedViewWidget` (for the drag), restyled; the counts' Arabic one and two forms
  are words without the number.
- Commit 10 was undone locally once before it was pushed (`git reset --soft` of an unpushed commit: its test did not
  compile, JUnit 5's message is the last argument) and committed again; nothing published was rewritten.
- Commit 14: the colour picker's paddings stay as they were; only its texts take the rows' size.

**Not tested on a device:** all of it. The lists are in `../PROJECT_STATE.md` ("Active tasks") and KI-59; the 7870's in
`../checks/7870.md`.

