# Chat archive

## Purpose

Much of the project's reasoning was worked out in conversations with Claude, and a new session cannot read
those. This folder keeps one structured report per conversation, written by that conversation itself, so
that requirements, decisions, rejected approaches and solved problems survive.

**What is here (2026-11-12):** 15 reports, `CHAT_01.MD` … `CHAT_15.MD`, plus this index and the template.
The index describes the files that exist. It does not assume any other number of conversations.

## What a report is, and is not

A report says what a conversation **said**. It does not prove what the code **does**.

- **A planning report** (CHAT_14) describes requirements, reasoning and intended work. What it calls planned
  may have been built later by another session.
- **An implementation report** (most of the others) describes what a session did and saw: commits, CI
  results, the owner's replies.
- Neither kind proves that a change is in the current code. That is checked against git and the code, and
  the results are in the tables below.

Each report labels its own statements. Read them this way:

| Label in a report | Meaning | In the main docs it becomes |
|---|---|---|
| [Confirmed] | shown in that conversation by a tool result, a log or the owner's reply | [V] only after a re-check in git or the code; otherwise [H] |
| [Historical] | the owner's statement or a brief's text, not checked there | [H]; an owner decision if the owner chose it |
| [Suggestion] | proposed, with no sign it was done | never a decision or a plan by itself |
| [Unverified] | claimed without evidence | [U] or an entry in `../KNOWN_ISSUES.md` Part C |

Where a report contradicts the code, the code is right (it usually changed later). Do not change code to
match an old report.

## The reports

Dates are those of the work, not of the report. "Session" is the `Claude-Session` id in the commits the
report cites [V]; reports without one were local sessions whose work the owner committed.

| Report | Dates of the work | Kind | What it covers | Session / commits |
|---|---|---|---|---|
| `CHAT_01.MD` | 2026-10-05 | review + implementation (local) | First bug review; fixes to receivers, weather, Spotify redirect, splash, panes; the workspace-load watchdog; the `CustomNoSwitchPreference` layout. The owner keeps the OpenWeather key hardcoded | no session id; committed by the owner as `eed91b73`, `3f4d96da` |
| `CHAT_02.MD` | 2026-10-05 → 10-06 | implementation + log analysis | Adaptive pane launch; sound-channel handling and the input monitor; return from the settings; fYT Rating timing; CI set-up; `Launcher.java` split into ten helpers; v1.2.1 release notes | `session_01XJFQ2J9hp7tXEzML48Cd3Z`; `dbfac7a` … `1039775` |
| `CHAT_03.MD` | 2026-10-08 → 10-09 | analysis + implementation (local) | Navigation app no longer overwritten; last app restored at cold boot and wake; ACC as a wake signal; `launcher_home` split in two | no session id; `44833aa0` … `36359b61` |
| `CHAT_04.MD` | 2026-10-12 → 10-13 | implementation + log analysis | Wake detection from every signal for the whole process; `HomeFrontGuard` and its rules; stats overlay fix | `session_019ijirifzjb1fxfQDDxkApX`; `ffba656` … `10c9b3b` |
| `CHAT_05.MD` | 2026-10-18 → 10-19 | implementation + log analysis | StrictMode clean-up; music widget (covers, last player, YT Music likes); stock players (`com.syu.music` favorites, `com.syu.media` binder); panes waiting for a late host; Shizuku Next boot analysis | `session_019sm7LnhdFzQAC5is3J8b4E`; `4b03c3b` … `fee2455` |
| `CHAT_06.MD` | 2026-10-23 → 10-26 | implementation, then review (local) | FYT stock sources behind the music widget: 7870 `com.syu.media`, radio and BT overlays; three review fixes; a 7870 test guide | no session id; `ded0e6ef`, `d5030a6e`, `4ad0bed2`, `f1773cc1` |
| `CHAT_07.MD` | 2026-10-28 | implementation of a brief | Removal of the dead `Cling` code (brief 2026-10-28 cling) | `session_0142a81FjuUhN4N8Ur5Y6kPX`; `de25567`, `8bddb4c`, `4f6ee7d` |
| `CHAT_08.MD` | 2026-10-28 | analysis + implementation | Keyboard focus beside FYT's pinned PiP: `PinnedPipFocus` | `session_0142a81FB52cB8MraNzBwcR3`; `d9fc21d` |
| `CHAT_09.MD` | 2026-11-01 | implementation of a brief | Left bar capacity from the visible icon (brief 2026-11-01) | `session_0142a81DHyCgzXndvQ5SeamD`; `219c47eb` |
| `CHAT_10.MD` | 2026-10-27 → 10-28 | implementation + log analysis | Pinned PiP fixes; pane and stats-window movement while pages scroll (7862, A55); the reverted surface mover | `session_01QUq7jCJ1Ck7Wotj3zNQQUs`; `3a0217e`, `1cccf3c`, `998d56f` and others |
| `CHAT_11.MD` | 2026-10-28 | implementation of a brief + fixes | Device-identity round (D1–U3); icon plate regression; StrictMode fixes; platform-first location | `session_0142a81ECW5Abkr9EArb3fBY`; `84d8a3ed` …, `ee9b303`, `4ab8ddb`, `620fd61` |
| `CHAT_12.MD` | 2026-11-04 | implementation of a brief | Log legend, screen-number rule, overlapping elements, Spotify browser start (brief 2026-11-04) | `session_0142a81EpifZuFpaBxCecTPR`; `d55390a`, `a2a180c`, `1c32b4d`, `1ace149` |
| `CHAT_13.MD` | 2026-11-02 | implementation of a brief | Widgets and bars layout: trimming, the move → trim → reset resolver, dual-PiP split, date widget fit (brief 2026-11-02 widgets-bars) | `session_0142a81DsEDFR79QsCmvxnzc`; `d74b5a3` … `3eb7798` |
| `CHAT_14.MD` | 2026-11-07 → 11-08 | **planning and review** | Opus reviews Sonnet's commits, analyses logs and writes the briefs for rounds 8–12 | `session_0142a81Eq3Gq9xVgbLZQ1kRV`; briefs `f9d1c471` … `33ac3869` |
| `CHAT_15.MD` | 2026-11-06 → 11-08 | implementation of briefs | Rounds 8–12 implemented: C1–C10, D1–D4, E1–E3, F1–F3, G1–G3 | `session_0142a81ESLme1Sb2pFN966C6`; `a64a2e90` … `3dd71894` |

CHAT_14 and CHAT_15 describe the same rounds from the two sides. CHAT_14 lists G1–G3 as proposals, because
its conversation ended when the brief was written; CHAT_15 and git show they were implemented.

### Reading notes

- `CHAT_10.MD` lost characters when it was saved: table pipes, slashes in paths and comparison signs are
  missing (for example `appsrcmainjavacomsyuutil…`, `SDK_INT = Q` for `SDK_INT <= Q`). Its statements are
  readable, but take exact paths and conditions from the code.
- `CHAT_07.MD` and `CHAT_13.MD` are wrapped in a code fence, so they render as code. The content is complete.
- Reports made from a compacted conversation (CHAT_02, CHAT_05, CHAT_11, CHAT_15) say which part they know
  only from a summary.

The files are kept exactly as they were written. Corrections belong in this index, not in the reports.

## Verification (2026-11-12)

- **Commits:** the reports cite 156 distinct commits that exist, and all 156 are ancestors of `testBranch`
  [V]. Two more hashes they cite are not in the repository:
  - `a63f42c` (CHAT_08) was a local commit, replaced by `d9fc21d` after a rebase;
  - `0b722649` (CHAT_06) was never pushed. It held `docs/prompts/sonnet_stock_media_sources.md` (the
    stock-sources brief) and `docs/7870-stock-sources-test.md`. Neither file is in the repository.
- **CHAT_01** made no commits, but 14 of the 15 changes checked are in the current code; the owner committed
  them as `eed91b73` and `3f4d96da`. The fifteenth (`mStripScreensBaseOnDBAfterLoad`) was removed later by
  `660bad7d`, when the model took over the screen strip.
- **Spot checks in the code [V]:** the `launcher_home` migration; `SLEEP_HOME_EARLY_MS = 300`; no `ANY_APP`
  in `HomeFrontGuard`; `UserTouches` with the input monitor; `PinnedPipFocus`; `SyuMusicLibrary`; the
  `yt_fill` icon rule; `HOST_WAIT_TIMEOUT_MS`; `StockSources.PLAYER_SETTLE_MS`; `ResourceIdArithmeticTest`;
  the `_v2` capacity keys; `WindowSurfaceMover` absent (reverted).
- **Not verifiable here:** anything about behaviour on a device, and the owner's quoted words.

## What was taken into the main documents

| Report | Incorporated into | Stays historical only (in the report) | Needs further verification |
|---|---|---|---|
| CHAT_01 | D-26, D-35, D-39, D-48; KI-01, KI-11, KI-25, KI-26; ROADMAP milestone | the full list of fixes; test commands on the device | five code observations (KI-26); splash on Android 11+ |
| CHAT_02 | D-31, D-36, D-49; ARCHITECTURE §8, §11; KI-11, KI-26 | log timings; release-notes text and contributors; the owner's local JVM crashes | weather re-check on a device |
| CHAT_03 | D-27, D-29, D-30, D-25; ARCHITECTURE §4 | log timings of ACC, MCU and carlink's start | navigation fix and the settings split on a device; a long-sleep wake (P-11) |
| CHAT_04 | D-27, D-28; KI-27, KI-25; ARCHITECTURE §4, §11 | the rounds of logs and each rejected guard version in detail | the path where `com.syu.ms` reopens its app |
| CHAT_05 | D-04, D-05, D-31, D-32, D-33, D-37, D-49; KI-13 | YT Music action names and icon ids; `IPlayer` transaction codes; Shizuku start timings | dual pane with a late host on Android 16 |
| CHAT_06 | D-32; KI-26; `../prompts/README.md` (brief outside the catalogue) | parcel layouts and module codes of `com.syu.media` | the 7870 questions listed in KI-29; BT time units. A session note on this work is in `../prompts/archive/analysis/memory-2026-10-26-stock-sources-7870.md` |
| CHAT_07 | KI-04, KI-25; catalogue row 5 | CI run ids; counts of removed files | "no visible change" on a device |
| CHAT_08 | D-44; KI-22; ARCHITECTURE §7 | the framework analysis behind the fix; rejected alternatives | two side effects (KI-22); the fix itself was confirmed by the owner on 2026-11-12 |
| CHAT_09 | D-40; KI-26; catalogue row 16 | the table of slot counts per device | look on devices; the height-cache weakness |
| CHAT_10 | D-34, D-24, D-49; KI-21; ARCHITECTURE §7 | A55 relayout measurements | the regrab fix; the stats-window question was answered by the owner on 2026-11-12 (KI-21) |
| CHAT_11 | D-03, D-19, D-38; KI-25; catalogue row 6 | the clean-up scripts (not in the repository) | the three fixes on a device |
| CHAT_12 | D-42; KI-20, KI-23, KI-25; catalogue row 21 | details of the cut and tie-break rules | device scenarios a–e; the Spotify cause |
| CHAT_13 | D-41, D-47, D-09; KI-25, KI-26; catalogue row 17 | where the implementation differs from the brief | date widget on a device; item 3.7 |
| CHAT_14 | D-16, D-17, D-18, D-49; KI-24, KI-28, KI-29; catalogue rows 29–33 | the owner's quoted confirmations per round | cause of the stuck load; the "7870" remark (the tester's reply is awaited, KI-29) |
| CHAT_15 | D-17, D-18; KI-24, KI-28; catalogue rows 27–33 | log signatures added per round; build errors fixed on the way | nothing: the owner confirmed round 12 on 2026-11-12 |

`D-nn` are entries in `../DECISIONS.md`, `KI-nn` in `../KNOWN_ISSUES.md`, `P-nn` in `../ROADMAP.md`.

## Coverage of the git history

For orientation only: which Claude Code sessions in the commit trailers have a report here. A session
without a report is not a defect; its work is in git and, from 2026-10-27, in the briefs.

| First → last commit | Commits | Session | Report |
|---|---|---|---|
| 2026-10-05 → 10-06 | 24 | `session_01XJFQ2J9hp7tXEzML48Cd3Z` | CHAT_02 |
| 2026-10-12 | 10 | `session_019ijirifzjb1fxfQDDxkApX` | CHAT_04 |
| 2026-10-13 → 10-19 | 139 | `session_019sm7LnhdFzQAC5is3J8b4E` | CHAT_05 (its last two days; the VDHost work before that only in summary) |
| 2026-10-26 | 60 | `session_01R6kYaADc9PqUwyUMcsFB7F` | — (the translations) |
| 2026-10-26 → 10-28 | 52 | `session_01QUq7jCJ1Ck7Wotj3zNQQUs` | CHAT_10 (part); briefs 1–4 |
| 2026-10-28 | 19 | `session_0142a81ECW5Abkr9EArb3fBY` | CHAT_11 |
| 2026-10-28 | 1 | `session_0142a81FB52cB8MraNzBwcR3` | CHAT_08 |
| 2026-10-28 | 6 | `session_0142a81FjuUhN4N8Ur5Y6kPX` | CHAT_07 |
| 2026-10-28 → 11-02 | 55 | `session_0142a81G9yq8pk8VbFqyTyoB` | — (CAN bus and fuel rounds; briefs 7–15) |
| 2026-10-30 → 11-01 | 3 | `session_0142a81DHyCgzXndvQ5SeamD` | CHAT_09 |
| 2026-11-01 | 4 | `session_0142a81EfUoMoFWvZEKrQ67q` | — (branch merges) |
| 2026-11-01 | 1 | `session_0142a81FzpAH7VQUdn5b6uE2` | — (settings fallback) |
| 2026-11-02 → 11-04 | 29 | `session_0142a81EpifZuFpaBxCecTPR` | CHAT_12 (round 2026-11-04); briefs 18–21 |
| 2026-11-02 | 9 | `session_0142a81DsEDFR79QsCmvxnzc` | CHAT_13 |
| 2026-11-05 → 11-08 | 16 | `session_0142a81Eq3Gq9xVgbLZQ1kRV` | CHAT_14 |
| 2026-11-05 → 11-08 | 75 | `session_0142a81ESLme1Sb2pFN966C6` | CHAT_15 (rounds 8–12; the rounds of 11-05 only in summary) |

CHAT_01, CHAT_03 and CHAT_06 were local sessions on the owner's computer; their commits carry no session id.

## Adding a report

1. In the conversation, paste the prompt from [`CHAT_EXTRACTION_TEMPLATE.md`](CHAT_EXTRACTION_TEMPLATE.md)
   (the part between the lines). The template tells the conversation to report only what it contains, to
   label every statement, and not to claim code changes it cannot show.
2. Save the answer here as `CHAT_NN.MD` with the next free number. Do not edit its claims.
3. Add a row to "The reports" above.
4. A Claude session then checks the report against git and the code, moves what holds into the main
   documents with the report as the source, and fills in the two tables above ("Verification" and "What was
   taken").
