# Project state

**Snapshot: 2026-11-15, `testBranch` after round 14 (`6fbd5605b` … `c7ed19880`, then the documentation
commits). CI is green on every push of the round, the last code commit `c7ed19880` included (run 491). Nothing of round 14 has been run on a device.** This file is the authoritative entry point for a new session. Update it at the
end of every round (see `CLAUDE.md`).

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
| Active brief | **None.** `prompts/active/` is empty [V]. |
| Last code change | **Round 14, 2026-11-15:** the fixes from the owner's test of round 13, the open items of `KNOWN_ISSUES.md` (D-62), and six items from a second test on the 7862; 29 code commits `6fbd5605b` … `c7ed19880`, one of them a revert, done in one session from a plan agreed with the owner [V]. **Waiting for the owner's device test** (KI-34). Report: `reports/implementation_report_2026-11-15.md`. |
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
| Round 14: one bar while the pages move, the bars in the overview, the vertical bar at the edge and as wide as counted, play/pause, "Unknown" titles, the listener after a reconnect, the stats window's alpha, a weather key of one's own, the hidden-API report | **no device result** | KI-34, KI-35, D-61, D-63. |

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

**The owner's device review of round 14.** It is implemented, builds and passes its tests (1083); none of
it has been seen on a device. `reports/implementation_report_2026-11-15.md` lists what to check and the
choices made without the owner (D-63). The bar's music buttons after an app (KI-35) have no known cause;
the round adds the log lines that should show it. The next round records the result.

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
4. **Round 14 is untested on devices (KI-34).** It changes what the 7862 shows while the pages move and in
   the overview, the centring of the cells, the play/pause button and the night mode without a saved
   picture; the stats picture of KI-21 was reverted at the owner's request.

The hardcoded OpenWeather key is **not** an open issue: the owner decided to keep it (D-26).

## Next priorities

**Confirmed by the owner or the briefs:**
- Release 1.2.2 at some point; before it, a fresh Baseline Profile (`ROADMAP.md` P-2, P-3).
- Deferred ideas, each needing its own brief: day/night mode pinned to the PiP displays; FYT skins in the
  standard flavor.

**Recommendations (not decided):** see `ROADMAP.md`, "Recommendations".

## Documentation map

| File | What it holds |
|---|---|
| [`CLAUDE.md`](CLAUDE.md) | Rules, commands, Opus/Sonnet workflow |
| [`ARCHITECTURE.md`](ARCHITECTURE.md) | What exists and where: modules, subsystems, data, services, privileges |
| [`DECISIONS.md`](DECISIONS.md) | Why: 63 decisions with status, who decided and the source |
| [`ROADMAP.md`](ROADMAP.md) | History in milestones, confirmed plans, recommendations |
| [`KNOWN_ISSUES.md`](KNOWN_ISSUES.md) | Confirmed problems, accepted limitations, unverified reports |
| [`prompts/README.md`](prompts/README.md) | Catalogue of all briefs → commits → status |
| [`chat_archive/README.md`](chat_archive/README.md) | Index of the 15 conversation reports and what was taken from each |
| [`reports/`](reports/) | The audits of 2026-11-10, the consolidation report of 2026-11-12, round 13's audit and implementation report, and round 14's implementation report |
