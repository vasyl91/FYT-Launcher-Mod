# Prompt catalogue

The implementation briefs (Opus → Sonnet) and the analyses written for them. The briefs are in Polish; this
catalogue is in English.

## Folders

| Folder | Holds |
|---|---|
| `active/` | The brief being implemented or waiting for its device review, and the analyses it uses. Empty now. |
| `archive/` | Finished briefs. **Read-only history: never edit them.** |
| `archive/analysis/` | Log analyses and comparisons written as input for a brief. |

Workflow (details in `../CLAUDE.md`):

1. Add a row to this catalogue **in the same commit** as the new brief, which goes to `active/`.
2. After the owner's device review, `git mv` the brief (and its analyses) to `archive/` and update its status
   here.

File names: `sonnet-prompt-YYYY-MM-DD-<topic>.md` for briefs; `opus-logs-…`, `opus-analysis-…` or a
descriptive name for analyses.

## Moved on 2026-11-10

All 37 files used to be in `docs/` at the repository root. They were moved here with `git mv`, so
`git log --follow` shows their history; the contents are unchanged. Links inside them still say
`docs/<name>.md`. Read such a link as `archive/<name>.md`, or `archive/analysis/<name>.md` for the four
analyses.

## How the status was established

The commit subjects that each brief prescribes were matched verbatim against `git log`. Every prescribed
subject exists, in the brief's order. Four briefs prescribe no subjects; for those (marked ≈) the commits were
matched by topic and time. "Follow-ups" are commits on the same topic made right after the round without a
brief of their own.

**Statuses:**

- ✅ implemented: all prescribed commits are in `testBranch`, and later rounds build on them. A device
  result, where one was given, is in the next brief's review section; it was not checked brief by brief.
- ✅¹ implemented with green CI; no later brief exists yet, so no device review is recorded.
- ↩ partly reverted or superseded later (see the note).

## Briefs

| # | Date | File (`archive/`) | Topic | Commits | Status / notes |
|---|---|---|---|---|---|
| 1 | 10-27 | `sonnet-prompt-2026-10-27.md` | C1–C12: 7870 on Shizuku: waiting for the VD host, logcat, uiMode, parking assets, key redaction, night mode, hygiene. Based on `archive/analysis/log-analysis-2026-10-26.md`, and overrides it where they differ | `66961f21` `d366d3be` `cf7b175c` `05efb292` `5791c694` `2148c52c` `43d89b4d` `771f9387` `0c3cc191` `bb669baa` `02a13c5e` `22bb4f98` | ✅ ↩ C1 reverted in #3 (`735e308b`) |
| 2 | 10-27 | `sonnet-prompt-2026-10-27-music-widget.md` | D1–D5: music widget lines and "Live", sizing, night brightness floor, canbus guard, OpenWeather key test | ≈ `34c05384` `9c889643` `85f36a7d` `8cc9f9a9` `8cc9e48f` | ✅ D3 refined by #6 (by chipset) |
| 3 | 10-27 | `sonnet-prompt-2026-10-27-bar-pip.md` | E1 swipe on the auto-hide bar; E2a/E2b pane moves in the page frame; E3 pinned PiP only on 7862/8581 | ≈ `053c7995` `bf47df57` `50714e55` `a2959497`; follow-up `4f94b198` | ✅ ↩ E3 superseded by #6 (D-03) |
| 4 | 10-27 | `sonnet-prompt-2026-10-27-pinned-logcat.md` | R revert of `66961f2`; D logcat defaults by build; S StrictMode in release; P1–P3 pinned PiP; L log file names; I legend; T translations | `735e308b` `2b70e8f4` `5bb6e2d7` `ea0ecfa3` `6451e395` `7c7b158c` `d5d6cb73` `ff3dcc0a` `a843af1e`; follow-ups `f1ae1f56`…`06fb5b5d` | ✅ |
| 5 | 10-28 | `sonnet-prompt-2026-10-28-cling.md` | C1–C3: remove the Cling leftovers (dead code, no visible change) | `de25567b` `8bddb4c9` `4f6ee7de` | ✅ |
| 6 | 10-28 | `sonnet-prompt-2026-10-28-device-identity.md` | Platform by chipset (with the **verified platform map**), device line, clipboard link, Shizuku Next, carinfo out of the build, res clean-up | `84d8a3ed` … `0c1895b0` (13 prescribed); follow-ups `ee9b303f` `4ab8ddb3` `620fd619` | ✅ |
| 7 | 10-28 | `sonnet-prompt-2026-10-28-canbus-requests-logcat-stop.md` | C1–C8: canbus library v1 and its script, import, code reader guesses, logcat stop button, README | `9a05cfce` `1e3d934a` `34f764a6` `99493ca3` `0be3b0e6` `7f07582f` `9d5bc0b7` `ee0e7a0e` | ✅ |
| 8 | 10-29 | `sonnet-prompt-2026-10-29-canbus-library-classes-reader.md` | D1–D5: library-only classes, fuel and range codes (format v2), reader without zeros, estimator, CAN-box frames | `75d41dff` `f2e178bc` `5fd0aec8` `dd6871f2` `5c785b93`; follow-ups `e393ca5d`…`4d043ffa` | ✅ |
| 9 | 10-30 | `sonnet-prompt-2026-10-30-canbus-library-update.md` | Library from the newer `com.syu.canbus`, several code pairs, export, diff and merge. With `archive/analysis/canbus-app-comparison-2026-10-30.md` | `2894aadc` `438e2e21` `98bf89fa` `ca201326` `6e6a2a51` | ✅ |
| 10 | 10-30 | `sonnet-prompt-2026-10-30-reader-labels-fixes.md` | Readable reader categories, small fixes after a test drive | `83d8ac10`; follow-up `8153720b` | ✅ |
| 11 | 10-30 | `sonnet-prompt-2026-10-30-fuel-estimate-handover.md` | Smooth handover between the car's value and the estimate | `bd86cfbd`; follow-up `43ea9093` | ✅ |
| 12 | 10-31 | `sonnet-prompt-2026-10-31-fuel-model-v3.md` | Fuel model v3: physics, car data, road grade, RPM, codes, units, stats window | `8b51f33a` `e421cdb0` `aa9fcbae` `b3e50f33` `fd29a66d` `f97c20c4` `943163f9`; follow-up `495fb7f1` | ✅ |
| 13 | 10-31 | `sonnet-prompt-2026-10-31-fuel-handover-and-window.md` | Stats window width; handovers in steps and over time | `71b4dea8` `36838e55` `5fe28bad` | ✅ |
| 14 | 10-31 | `sonnet-prompt-2026-10-31-stats-window-font.md` | Stats window font and widths | `af257c3a` `cb897ac0` | ✅ |
| 15 | 10-31 | `sonnet-prompt-2026-10-31-stats-window-alpha.md` | Full alpha of the stats window through root or Shizuku, touches pass through | `c9e4650c` | ✅ |
| 16 | 11-01 | `sonnet-prompt-2026-11-01-left-bar-spacing.md` | Left (now vertical) bar spacing in both orientations | ≈ `219c47eb` | ✅ |
| 17 | 11-02 | `sonnet-prompt-2026-11-02-widgets-bars-layout.md` | Tasks 1–4: trim widgets at the bars like PiPs, text fit, move → cut → reset, dual PiP minimum | ≈ `d74b5a3b` `adf77fca` `53655786` `d2b4e83a` `a2b0516e` `5a867334` `ad48b72e` | ✅ |
| 18 | 11-02 | `sonnet-prompt-2026-11-02-screens-from-model.md` | Pages and custom elements planned by the model (DB) | `a0378f06` `debe430a` `8d178056` `660bad7d` `4d313903` `56418db5` | ✅ |
| 19 | 11-03 | `sonnet-prompt-2026-11-03-crash-loop-and-log-fixes.md` | FYT crash loop, crash reports, loop guard, log fixes. Cold-start profiling left out of scope | `5d9b6889` `66e2ce1a` `b446402d` `b51ae4cd` `56878940` `2da730f3` `7b9a8ad3`; follow-up `e3edfb3b` | ✅ |
| 20 | 11-03 | `sonnet-prompt-2026-11-03-bar-icons-pane-bounds-cold-start.md` | Bar icons off the main thread, the pane bounds pump, a lighter cold start. Answers `archive/analysis/opus-analysis-2026-11-03-remaining-log-findings.md` | `09d94e43` `efa70192` `69aac3b1`; fixes `93c9bd76` `e6cf49bb` | ✅ |
| 21 | 11-04 | `sonnet-prompt-2026-11-04-screens-overlaps-spotify-log-legend.md` | Screen number past the last page, overlaps on every page, Spotify sign-in on the main display, log legend | `d55390a8` `a2a180c7` `1c32b4d0` `1ace1496` | ✅ |
| 22 | 11-05 | `sonnet-prompt-2026-11-05-media-system-canbus7870.md` | `com.syu.media` covers and hearts; flavor `fyt` → `system`; FYT code fuse; the 7870 CAN library; automatic code check; VD host protocol 3; standard flavor permissions through the host; panes survive a recreation. §7 = deferred idea | `e2086527` `314897ef` `fbf4632c` `4721980e` `916beeaf` `1ca66135` `b574e758` `608ff0a8` `da02b9f7` `502464e7`; follow-ups `9849b1cd` `429ce279` | ✅ C11 (conditional) not needed |
| 23 | 11-05 | `sonnet-prompt-2026-11-05-review-bottom-bar.md` | Round 1 review fixes, 7870 log fixes, bottom bar: handle, widget bar, every page | `06d62c4e` … `8c1ca9d6` (12) | ✅ |
| 24 | 11-05 | `sonnet-prompt-2026-11-05-widget-bar-layout.md` | Round 2 fixes, the music layout in the widget bar | `0c13dddc` … `e717b75f` (8); follow-ups `13ca7186` `d72fe14c` `48b4ac3f` | ✅ |
| 25 | 11-05 | `sonnet-prompt-2026-11-05-widget-bar-round4.md` | Round 3 fixes, widget bar sizes, the weather manager stops when no weather is shown | `0767fd7a` … `11e49736` (7) | ✅ |
| 26 | 11-05 | `sonnet-prompt-2026-11-05-every-page-bar-fixes.md` | Edge handle crash; icons and jank of the bar on every page | `347f06be` `656decb4` `11e70c29` | ✅ |
| 27 | 11-06 | `sonnet-prompt-2026-11-06-creator-hint-canbus-leak.md` | Creator arrows, the double-tap hint, canbus callback leak | `ea203541` `cced3912` `5e3fb395` | ✅ |
| 28 | 11-06 | `sonnet-prompt-2026-11-06-edge-handle-width.md` | Edge handle as wide as the left bar | `4677b990` | ✅ |
| 29 | 11-07 | `sonnet-prompt-2026-11-07-dab-bt-bars-settings.md` | C1–C10: DABdream back to its pane, BT widget, handle tap on Android 10, fuel speed threshold, Spotify and fYT Rating state, bars renamed, the Bars category, bar sides, handle on either edge. Uses `archive/analysis/opus-logs-2026-11-07-dabdream-home-and-bt-widget.md` | `a64a2e90` `24ea895b` `9a61126a` `70f04048` `b0d2729e` `0ea8f2eb` `d0e67aaf` `663800c2` `9bc0faa5` `6080ce99` | ✅ |
| 30 | 11-08 | `sonnet-prompt-2026-11-08-top-bar-button-vertical-every-page.md` | Top bar below the status bar, button or handle, the vertical bar on every page, touches under the handle | `a4f522bf` `1843f8a6` `5604d116` `4b63a077` | ✅ |
| 31 | 11-08 | `sonnet-prompt-2026-11-08-top-bar-box-vertical-corner-creators.md` | Top bar on the page's box, the vertical bar in the empty corner, creators as the home screen | `752222ec` `6961a9ca` `8a0229d5` | ✅ |
| 32 | 11-08 | `sonnet-prompt-2026-11-08-vertical-window-side-one-creator-stats.md` | Vertical bar window on the right, one creator for every page, stats window moved by the bars | `fc5cac17` `76c1c110` `f791b67e` | ✅ |
| 33 | 11-08 | `sonnet-prompt-2026-11-08-workspace-load-widget-style-creator-overlap.md` | G1–G3 with rules R1–R3: workspace load watchdog, widget colors as view tints, one overlap rule | `e3136f45` `b1fe254c` `3dd71894` | ✅¹ archived 2026-11-10 at the owner's request; device review pending |

Note: commit `0ea8f2eb` (fYT Rating, C6 of #29) carries a lower-case subject (`fYT Rating: …`), which the
verbatim match missed; it was matched by hand.

## Analyses (`archive/analysis/`)

| Date | File | Language | What it is | Used by |
|---|---|---|---|---|
| 10-26 | `log-analysis-2026-10-26.md` | PL | Four 7870 logcats read with grep only; findings P1–P11, marked [OBS]/[HIP] | #1, which confirms or refutes each item. **P10 (move and rotate the API key) still open: KI-01** |
| 10-30 | `canbus-app-comparison-2026-10-30.md` | PL | Old vs new `com.syu.canbus`: IPC identical, the `DATA[n]` shift (+11 for PSA), what changed for car 1507667, recommendations | #9; lasting reference for `DATA[]` indices |
| 11-03 | `opus-analysis-2026-11-03-remaining-log-findings.md` | EN | Three findings left after #19 (StrictMode on bar icons, pane bounds, cold start) | #20 |
| 11-07 | `opus-logs-2026-11-07-dabdream-home-and-bt-widget.md` | PL | The tester's report and log excerpts (170 KB): DABdream crash after Home, BT widget state | #29 |
