# Project state

**Snapshot: 2026-11-26, `testBranch` after round 28 (the brief `prompts/active/sonnet-prompt-2026-11-25-round-28.md`; 39
code commits, CI runs 582 to 620). Built: the crash and start fixes (A1–A8), the slider's look and touch (B1, B2), one
accent colour and "Stock layout" turning off the whole creator (C1–C3, D-85, D-86), the home screen's colour of names,
swipes, double tap, folders, free and overlapping widgets (D1–D7, D-91, D-92), the app drawer (vertical, letters,
search, grid, tabs and their creator, F1–F6, D-88), the notification badges (H1, H2, D-90), BOOT_COMPLETED at a wake
(I1) and the new welcome texts (I2), and "Display vertical bar". **Not built (KI-52):** the horizontal bar's switch,
hiding the drawer button and the music widget with the sharing rule (only the model `BarShares`, D-87), and the widget
list (only the model `WidgetGroups`, D-89). None of it was tried on a device (KI-51); the CI of the last code commit,
`0751ebbb6`, is green (run 620; the four red runs, 591, 597, 609 and 610, were fixed by the commits after them). Before
it, on 2026-11-25 the 7862's log of round 25 closed KI-46 (no StrictMode report, no leaked `ActivityView` surface); the
owner confirmed the panes, the order of the bar's elements (D-77) and the dark dialogs (D-78) on the 7862, and the A55
runs the launcher as before on Android 17. com.syu.music cannot be moved to a position from another app (KI-50, D-81).
Round 27: the home music widget's position slider on every unit, moving the track where the player's session allows
it, showing the position where it does not, empty without one (D-81, KI-50); "Start on wake", a list of its own
under "Start on boot", which stays for the cold start (D-83, KI-50); the canbus script's zips accepted and described
(KI-49). The A55 confirms round 26 (KI-47 closed). Round 26: the settings' dialogs, their work in progress and the colour picker after a turn of a phone's screen, the
background selector sized for its orientation (D-82, KI-47); "App icons" with or without "Resizable" (D-71); the apps
list fitted to its icons or hidden under the widget bar, its room 10/10/80 to the date, the weather and the music
(D-80); on the 7870 the covers of BT and files, in a pause and on a rebuilt widget, and a position slider (D-81,
KI-48); the pinned PiP cannot follow the pages (FYT's framework pins its rectangle, D-34, KI-15); the canbus script's
`--launcher .` needs the decompiled folders that are now zips (KI-49). Round 25: two older StrictMode reports fixed (KI-46), the order of the horizontal bar's elements chosen in "Bars",
per orientation (D-77), the settings' dialogs in the settings' dark colours (D-78), three sections in "Bars" and no
blank summaries above dividers (D-79). The owner's log of 2026-11-20 18:21 confirms round 24 (KI-45 closed; the
status bar swipe works). Round 23 (the home screen's check without timers, the GPS only while needed) was confirmed
the same day. `KNOWN_ISSUES.md` is one current list since 2026-11-18.** This file is the authoritative entry point for a new
session. Update it at the end of every round (see `CLAUDE.md`).

Status tags: [V] verified in code, git or CI · [H] historical, from the owner, a brief or a chat report ·
[P] planned · [A] assumed · [U] unknown.

## Purpose

A reverse-engineered, heavily extended version of the stock FYT launcher (`com.android.launcher66`) for
Android car head units [V]. The original target was FYT 7862/8581 units on Android 10, where the launcher
runs as a system app. Since 2026-10 it also runs on the FYT 7870 (Android 13) and on ordinary phones
(Android 8–16), where it gets its privileges from root (the FYT VDHost Magisk module) or from Shizuku [V].
It is distributed through GitHub releases and the XDA thread linked in `README.MD` [V].

What the owner wants from it, as the briefs and chat reports show [H]:

- It behaves like the stock launcher where the user expects that (the last app comes back, the system's
  navigation app is respected) and adds what the stock one lacks (panes, a layout creator, bars, widgets,
  fuel statistics).
- It never undoes what the user did, and it treats every app alike.
- Nothing changes on the owner's 7862 unless a task is about it.

## Where it stands

| | |
|---|---|
| Last release | **v1.2.1**, 2026-10-06 [V]. `versionName` in `app/build.gradle.kts` is still 1.2.1 [V]. |
| Unreleased work | At `ee8e4f91`: 536 commits since `v1.2.1`, and `testBranch` 141 commits ahead of `main` (last merge: PR #33, 2026-11-01) [V]. Round 13 added 26 more, round 14 31 (29 of code). |
| Next version | 1.2.2. README, the updater and `release-assets.yml` already describe `system_release_1.2.2.apk` [V]. **No release date is recorded** [U]. |
| Development phase | Short feature and fix rounds on `testBranch`, driven by device logs (Opus brief → Sonnet commits → owner test). 33 briefs since 2026-10-27, all implemented [V]. |
| Active brief | **Round 28** (2026-11-25): `prompts/active/sonnet-prompt-2026-11-25-round-28.md`, implemented 2026-11-26 except E1 (the horizontal bar's switch), E2, E3 and G1 (KI-52); waiting for the owner's test (KI-51) [V]. |
| Last code change | **Round 22, 2026-11-18/19:** Robolectric for tests of views (D-68); the bar's music buttons, title and artist bound while its window stays (KI-35); the bar's title and artist sized the same with "Resizable horizontal bar" off; the guides below the app bar and the settings list keeping its place (D-73); "Transparent status bar" moved (D-72); the statistics window in landscape where the creator puts it, and on the home screen under the bars and over the panes (D-69); the vertical bar's width (D-70) and the number of icons on each bar (D-71) may be set; 10 code commits `62fc51126` … `5a6272396` [V]. **The owner, 2026-11-19 on the 7862 [H]: all work**, except a jump of the second settings screen scrolled up after a return; `16f256ee8` sizes the settings rows when they are bound. **The owner confirmed that fix too (2026-11-19).** Then `660b032e6`: a widget's configuration opened by the system (KI-41), waiting for the owner's test. Report: `reports/implementation_report_2026-11-15.md`, section "Round 22". |
| Round 27 | **2026-11-22:** after the owner's A55 test of round 26 ("everything works"). The position slider on every unit (`PositionSlider.Mode` SEEK / SHOW / GREY), a session's own app moved where its session allows it (`MediaTransportController.canSeek`, `seekToPosition`); "Start on wake" (`WakeAutostartPlan`, `ColdStart.startForWake`, the dialog's list argument); `canbus_library/README.md` on unpacking the zips for `--launcher`. 4 code commits `7ec71e8dc` … `58b5c3365` [V]. **Waiting for the owner's test (A55, 7862).** Report: `reports/implementation_report_2026-11-15.md`, section "Round 27". |
| Round 28 | **2026-11-26:** after the owner's 25 points, logs and 20 crash logs of 2026-11-25. 39 code commits, the last run green (four red runs on the way, each fixed): see `reports/implementation_report_2026-11-15.md`, section "Round 28", for the list, the deviations and what is not built. Decisions D-84 … D-92, D-81 and D-83 changed; KI-51 … KI-53, KI-33 accepted. **Waiting for the owner's test (A55, 7862).** |
| Round 26 | **2026-11-21/22:** after the owner's A55 test of round 25 ("everything works but the dialogs after a turn") and the 7870 tester's report. A turn on a phone: the plain dialogs come back with their texts (`SettingsDialogMemory`, `DialogTurn`), a download, a wallpaper save and a canbus import go on with their dialogs (`HandedWork`), the colour picker stores its colour and the app lists come back (`ColorPickerTargets`), the background selector is sized from its window and draws the wallpaper center-crop (`CenterCropDrawable`); "App icons" without "Resizable" (D-71 changed); "Fit the apps to their icons" and "Hide the apps" under the widget bar (`WidgetBarPlan.shares`, D-80); the 7870's BT cover after a start or a title that comes back (`StockBtCover`), file covers read as com.syu.media reads them (`FileCover`), the cover in a pause and on a rebuilt widget (`PausedCover`), the position slider (`PositionSlider`, D-81). 12 code commits `edcee91a9` … `6c525ff3e` [V]. **Waiting for the owner's test (A55, 7862) and the tester's (7870).** Report: `reports/implementation_report_2026-11-15.md`, section "Round 26". |
| Round 25 | **2026-11-20:** the widget previews of the page shown first read off the main thread, and a released `ActivityView` giving back its root surface (KI-46); a nested settings row keeps its space under the title, blank summaries gone, three sections with dividers in "Bars" (D-79); every settings dialog dark like the settings (`SettingsDialogs`, D-78); the order of the horizontal bar's elements, per orientation, in a dialog of "Bars" (`BarOrder`, `BarOrderDialog`, D-77); 7 code commits `6670ecf8b` … `8118d0af9` [V]. **The owner, A55 (2026-11-21) [H]: everything works as it should, except the dialogs after a turn of the screen (round 26).** The 7862's log (KI-46) is awaited. Report: `reports/implementation_report_2026-11-15.md`, section "Round 25". |
| Round 24 | **2026-11-20:** CI only for pushes that change more than the documentation (`46b59b2a7`, the rule in `CLAUDE.md`); the screens' ids kept in memory for a launcher created again in the process (`ScreenIdsMemory`); one window thread for the status bar strip; the home check waits for the binding before it judges the bars (KI-45); 3 code commits `85f35583d` … `32adc8b50` [V]. **The owner's log of 2026-11-20 18:21 [V]: the three fixes work (KI-45 closed); the status bar swipe works [H].** Report: `reports/implementation_report_2026-11-15.md`, section "Round 24". |
| Round 23 | **2026-11-20:** the home screen checked when it changes, in episodes judged after every pass of the window's layout, without delays or retry timers (`HomeIntegrity`, D-75, KI-43); the GPS of the fuel statistics at the rate something needs, none on a phone (`LocationNeed`, D-76, KI-44); the code check sees a drive from the speed code; 4 code commits `f080ffbd4` … `7e955ba65` [V]. **The owner, 2026-11-20 [H], with logs of the 7862 and the A55 [V]: everything loads correctly, no repair in any log, one `initAppData()` per start; the A55 makes no location request.** Report: `reports/implementation_report_2026-11-15.md`, section "Round 23". |
| Round 21 | **2026-11-16:** the statistics window laid out again a few times after the alpha limit reaches 1 (`ef3d1c746`). **The owner confirmed it on 2026-11-19 [H].** |
| Round 16 | **2026-11-16:** a widget that cannot be dropped stays where it was, icons dropped from the list of apps survive a reload (and are mended where an app renamed its activity), a widget that cannot be shown shows its preview and is told to update where the launcher may (D-66); 5 code commits `e6349acf0` … `a654c0d60` [V]. **The owner confirmed it on 2026-11-19 [H]**. Report: `reports/implementation_report_2026-11-15.md`, section "Round 16". |
| Round 20 | **2026-11-16:** no item of a page outside its visible part - stale temporary cells, the padding of the first rows, the drop's page, the size of an added widget, the creator's elements kept in the page, the check of every page after each drag and resize (`PageFit`); 5 code commits `91db3326a` … `36cf3e7c3` [V]. **The owner, 2026-11-16 17:26 [H]: "it looks like it works".** Report: section "Round 20". |
| Round 19 | **2026-11-16:** the bars on every page stand still - one window on every page, the first one too, built with the page, kept while an app is in front, over the PiP panes, nothing swapped while the pages move (D-67, after `88bacd560` did not help); 3 code commits `dffdd806b` … `33edcda65` [V], then 19b and 19c (`d939d294a`, `5199b1798`, `69353b5ca`). **The owner confirmed it on the A55 and the 7862 (2026-11-19) [H].** Report: `reports/implementation_report_2026-11-15.md`, section "Round 19". |
| Round 15 | **2026-11-15/16:** after the owner's test of round 14 on the A55 - icons and widgets under the statistics window (D-65), an overlap guard after loads (KI-37), the bars' windows as panels of the launcher's window under every floating button (D-64), access to all files asked for the wallpaper (D-60); 8 code commits `45673d58a` … `932d61d1c` [V]. **The owner confirmed it on 2026-11-19 [H].** Report: `reports/implementation_report_2026-11-15.md`, section "Round 15". |
| Round 14 | **2026-11-15:** the fixes from the owner's test of round 13, the open items of `KNOWN_ISSUES.md` (D-62), and six items from a second test on the 7862; 29 code commits `6fbd5605b` … `c7ed19880`, one of them a revert, done in one session from a plan agreed with the owner [V]. **Tested by the owner on 2026-11-15; what was left, confirmed on 2026-11-19 [H].** Report: `reports/implementation_report_2026-11-15.md`. |
| Before that | Round 13 (the owner's 19 tasks), 2026-11-12/13: `4e73d1178` … `ca27a7637` [V]. The owner tested it on 2026-11-15: 12 of 19 work, the rest went into round 14 [H]. Round 12 was confirmed on 2026-11-12 [H]. |
| Since then | Documentation and repository layout only: `claude/` created (`a30c9a72`), reference material moved to `archive/` (`8bfc5a8d`), 15 chat reports added (`754c8258`), `android-36.jar` moved back (`ee8e4f91`), the folder unified as `claude/` (`e3ba694e`) [V]. |
| Open GitHub issues | 0 [V] (2026-11-10). |

## Devices

| Device | Android | Flavor | Privileges from | Whose | Role |
|---|---|---|---|---|---|
| FYT 7862 (`ums512_1h10_Natv`, 2000×1200) | 10 | system | system uid 1000 | owner | daily unit, **must not regress** |
| Xiaomi Redmi Note 8T | 14 | standard | root, VDHost module | owner | test phone |
| Samsung Galaxy A55 (SM-A556B) | 16 | standard | Shizuku | owner | test phone |
| FYT 7870 (`uis7870sc_2h10_nosec`) | 13 | standard | Shizuku | a tester | uses `com.syu.media`, no pinned PiP; results arrive later and second-hand; the tester is not technical, so logs come from the launcher's own Logcat tool |
| FYT 8581 | 10 | system | system uid | nobody on record [U] | supported by design, pinned PiP |

Ownership was confirmed by the owner on 2026-11-12. The models and Android versions come from log headers
quoted in the briefs and chat reports [H].

## Features

All features below are implemented [V]. Details are in `ARCHITECTURE.md`; user-facing descriptions are in
`README.MD`. "Device" says what is on record about a real device, which is a different question from
"implemented".

| Feature | Device | Notes |
|---|---|---|
| Up to four PiP panes on the home pages | owner's 7862 and both phones [H] | Android's ActivityView (system, 8–10) or the launcher's own virtual displays through a VD host (11+, standard). Android 8–10 through a host is **untested** (KI-05). |
| Pinned PiP (FYT's pinned stack) | 7862 [H] | FYT units except the 7870, decided by chipset. The keyboard fix beside it is confirmed by the owner (D-44). |
| Layout creator | rounds 10–11 confirmed [H] | One creator for every page since 2026-11-08. |
| Horizontal bar | rounds 8–11 confirmed [H] | Top or bottom, auto-hide with an edge handle, on every page, resizable, the widget bar with 7 options. |
| Vertical bar | rounds 9–11 confirmed [H] | Left or right, on every page. |
| Music and radio widgets | 7862 and phones confirmed; 7870 partly [H] | Any player through the notification listener; FYT stock sources; favorites for YouTube, YT Music, Spotify and the stock players. |
| Sound-channel handling between stock sources and other players | 7862 confirmed [H] | D-31. |
| Home screen kept in front, or the last app restored, after a wake and a cold boot | 7862 confirmed in the owner's scenarios [H] | D-28, D-30. One path never triggered (KI-25). |
| Fuel statistics | 7862 [H] | CAN bus library (built-in and importable), code reader, automatic code check, estimate model v3, stats window over apps. |
| Night mode, weather | 7862 [H] | Sunrise/sunset from the location, day/night wallpaper and brightness; OpenWeather. |
| Logcat tool, crash and compat reports | in daily use [H] | `Download/Launcher66_Logs`. |
| Built-in updater | released in 1.2.1 [V] | Downloads the release asset for its own flavor. |
| Baseline Profile with on-device compilation | — | The profile in the repo is probably stale (KI-04). |
| Standard flavor on root or Shizuku (VD host protocol 3) | both phones [H] | Overlay, notification access and install permissions granted through the host. |
| Round 12: load restart, live widget colors, overlap rule | owner confirmed 2026-11-12 [H] | D-17. |
| Round 13: rows and columns of the home screen, bars cut out of the grid | owner tested 2026-11-15 [H] | D-52. Icons smaller in a dense grid since round 14 (`IconFit`). |
| Round 13: a colour of one's own for backgrounds, any text colour, backgrounds turned with the bar, the stats window's background | owner tested 2026-11-15; the colour tile and the frame redone in round 14 [H] | D-54, D-55. |
| Round 13: the wallpaper read from one source with fallbacks | needed fixes (2026-11-15); redone in round 14, **no device result** | D-53, D-58 … D-60. |
| Round 13: fixes (bar windows' side, title scrolling, the leak of the bar window, radio tap without a radio, cell view ids, start page, stats over another launcher, settings texts) | owner tested 2026-11-15 [H] | KI-30 closed. |
| Round 14: one bar while the pages move, the bars in the overview, the vertical bar at the edge and as wide as counted, play/pause, "Unknown" titles, the listener after a reconnect, the stats window's alpha, a weather key of one's own, the hidden-API report | owner tested 2026-11-15 on the A55 [H]; the rest went into rounds 15–22, confirmed 2026-11-19 | D-61, D-63. |
| Round 22: the vertical bar's width, the number of icons on each bar, the settings list's place, the statistics under the bars | owner confirmed 2026-11-19 [H], the settings jump fixed after it confirmed too | D-69 … D-74. |

Not implemented:

| Item | Status |
|---|---|
| A build for custom ROMs with their own platform key | ❌ "No such build exists yet" (README) [V] |
| Day/night mode pinned to the PiP displays | [P] idea, needs a brief (`ROADMAP.md` P-6) |
| FYT skins in the standard flavor | [P] idea, needs a brief (P-7) |
| Everything in `DECISIONS.md` D-49 | rejected; do not build without asking |

## Architecture in one paragraph

One Android app module (`:app`) built in two flavors, plus a small uid-1000 daemon packaged as a Magisk
module (`vdhost/`). The app is an AOSP Launcher3-era core (`Launcher`, `Workspace`, `CellLayout`,
`LauncherModel`) with decompiled FYT code beside it (`com.syu.*`, the IPC to `com.syu.ms`) and the owner's
features on top. New logic lives in small plain-Java classes with JUnit tests; the big classes only call
them. Privileged work is done as the system uid, or through a VD host (the daemon or Shizuku) on a normal
install. See `ARCHITECTURE.md`.

## Technology

Java with some Kotlin; AGP 9.3.2, Kotlin 2.4.10, Gradle 9.8.0, JDK 21; compileSdk 37, targetSdk 36, minSdk 26.
The modules are `:app`, `:baselineprofile`, `:hiddenapi-stubs`, `:vdhost-shared` and `:vdhost-server`.
JUnit 5 JVM tests: 110 files, 1011 tests, no instrumented tests. CI runs on GitHub Actions [V].

## Constraints that shape every change

- Two flavors, one codebase: the `system` flavor runs as uid 1000 and the `standard` flavor gets its
  privileges from a VD host. A feature must degrade cleanly where its privileges are missing [V].
- FYT firmware code (`com.syu.*`) is decompiled and fits one firmware. Calls into it go through the
  `FytCompat` fuse, so a mismatch is reported, not a crash [V].
- StrictMode is on in release builds; no I/O on the main thread [V].
- No new dependencies; logic goes in plain Java classes with tests; strings go in all 59 languages
  (`CLAUDE.md`) [H].
- Nothing can be tested on a device from a Claude session. A change is "implemented" when CI is green and
  "working" only when the owner or the tester says so [H].
- `android_jar/android-36.jar` must stay where it is; `archive/` is read-only reference material [V].

## Active tasks

**Round 28 (2026-11-26), waiting for the owner's test (KI-51):** nothing of it was tried on a device. The list is in
KI-51; the ones to look at first on the A55: the settings of a release build (A3), the black window before the unlock
(A7), the slider's touch, the accent colour, the gestures and the double tap, the drawer (letters, search, tabs and their
creator), the badges. On the 7862: the double tap "Turn off screen" (the tile's command, the same double tap brings the
screen back), the swipe down (the quick settings panel), and that nothing changed where the round was not about it.
What was left out (E1 horizontal, E2, E3, G1) needs a device (KI-52).

**Round 27 (2026-11-22), waiting for the owner's test (KI-50):** on the A55 the slider with a streaming app (a knob,
a move goes there), with an app that cannot seek (no knob) and with a live YouTube stream (empty); "Start on wake"
with one or two apps, a sleep and a wake (they open one by one, then the launcher or the app from before the sleep),
and "Start on boot" unchanged after a restart. On the 7862 the log line `MusicWidget: slider com.syu.music …` and the
widget's look. **Round 26:** the A55 works (2026-11-22); on the 7870 (the tester) the BT cover after a start in the
middle of a song, FLAC/M4A covers, the cover in a pause and after the settings, and the position slider (KI-48).
**Round 25 on the 7862:** confirmed 2026-11-25 (KI-46 closed; D-77, D-78 work). Checks that only the 7870 can give
are listed in `checks/7870.md`. KI-44 waits for a unit whose code check waits for a drive. KI-37 waits for a log of a next
widget over icons, if one happens. CI runs only for a change of the code (`CLAUDE.md`).

## Blocked or waiting

- **Android 8–10 through the VD host:** needs one device each of 8.0, 8.1/9 and 10 (`vdhost/README.md`) [H].
- **A build for a ROM signed with its own platform key:** only the ROM's maintainer has the key [V].
- **Results from the 7870:** the owner is waiting for the tester's reply on which changes did not work
  there (KI-29) [H].

## Known critical issues

Nothing is rated High at the moment. The build break of 2026-11-10/12 is fixed (KI-19). The items to keep
in mind before a release, from `KNOWN_ISSUES.md`:

1. The Baseline Profile is probably stale (KI-04).
2. Something does not work on the tester's 7870, and it is not yet known what (KI-29).
3. Several earlier changes have no device confirmation on record (KI-25).
4. **Rounds 15–22 are confirmed by the owner (2026-11-19).** Waiting: the widget configuration fix (KI-41)
   and a log of the next widget over icons, if it happens again (KI-37).

The hardcoded OpenWeather key is **not** an open issue: the owner decided to keep it (D-26).

## Next priorities

**Confirmed by the owner or the briefs:**
- Round 28's left-out half (KI-52): the switch "Display horizontal bar" with the launcher building no bar, hiding the
  drawer button and the music widget, `BarShares` used by every place that counts the bar's room, and the widget list; each
  one briefed on its own, with a device to try the bar and the drag on.
- Release 1.2.2 at some point; before it, a fresh Baseline Profile (`ROADMAP.md` P-2, P-3).
- Deferred ideas, each needing its own brief: day/night mode pinned to the PiP displays; FYT skins in the
  standard flavor.

**Recommendations (not decided):** see `ROADMAP.md`, "Recommendations".

## Documentation map

| File | What it holds |
|---|---|
| [`CLAUDE.md`](CLAUDE.md) | Rules, commands, Opus/Sonnet workflow |
| [`ARCHITECTURE.md`](ARCHITECTURE.md) | What exists and where: modules, subsystems, data, services, privileges |
| [`DECISIONS.md`](DECISIONS.md) | Why: 76 decisions with status, who decided and the source |
| [`ROADMAP.md`](ROADMAP.md) | History in milestones, confirmed plans, recommendations |
| [`KNOWN_ISSUES.md`](KNOWN_ISSUES.md) | One current list: problems, accepted limits, unverified reports |
| [`prompts/README.md`](prompts/README.md) | Catalogue of all briefs → commits → status |
| [`chat_archive/README.md`](chat_archive/README.md) | Index of the 15 conversation reports and what was taken from each |
| [`reports/`](reports/) | The audits of 2026-11-10, the consolidation report of 2026-11-12, round 13's audit and implementation report, and round 14's implementation report |
