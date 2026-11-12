# Project state

**Snapshot: 2026-11-10, `testBranch` at `3dd71894`, CI green.** Update this file at the end of every round
(see `CLAUDE.md`). Status tags: [V] verified · [H] historical · [P] planned · [A] assumed · [U] unknown.

## Purpose

A reverse-engineered, heavily extended version of the stock FYT launcher (`com.android.launcher66`) for
Android car head units [V]. The original target was FYT 7862/8581 units on Android 10, where the launcher
runs as a system app. Since 2026-10 it also runs on the FYT 7870 (Android 13) and on ordinary phones
(Android 8–16), where it gets its privileges from root (the FYT VDHost Magisk module) or from Shizuku [V].
It is distributed through GitHub releases and the XDA thread linked in `README.MD` [V].

## Where it stands

| | |
|---|---|
| Last release | **v1.2.1**, 2026-10-06 [V]. `versionName` in `app/build.gradle.kts` is still 1.2.1 [V]. |
| Unreleased work | 532 commits since `v1.2.1`. `testBranch` is 137 commits ahead of `main` (last merge: PR #33, 2026-11-01) [V]. |
| Next version | 1.2.2. README, the updater and `release-assets.yml` already describe `system_release_1.2.2.apk` [V]. **No release date is recorded** [U]. |
| Development phase | Short feature and fix rounds on `testBranch`, driven by device logs (Opus brief → Sonnet commits → owner test). 33 briefs since 2026-10-27, all implemented [V]. |
| Active brief | **None.** `prompts/active/` is empty. The last round (G1–G3, 2026-11-08) is implemented with green CI and archived at the owner's request. Its device review is still due [V]. |
| Open GitHub issues | 0 [V] (2026-11-10). |

## Devices [H]

These come from the briefs; they are not in the code.

| Device | Android | Flavor | Privileges from | Role |
|---|---|---|---|---|
| FYT 7862 (`ums512_1h10_Natv`) | 10 | system | system uid 1000 | owner's daily unit, **must not regress** |
| FYT 8581 | 10 | system | system uid | supported, pinned PiP |
| FYT 7870 (`uis7870sc_2h10_nosec`) | 13 | standard | Shizuku | tester's unit; uses `com.syu.media`, no pinned PiP |
| Xiaomi Redmi Note 8T | 14 | standard | root, VDHost module | test phone |
| Samsung Galaxy A55 | 16 | standard | Shizuku | test phone |

## Features

All features below are implemented [V]. Details are in `ARCHITECTURE.md`; user-facing descriptions are in
`README.MD`.

| Feature | Status | Notes |
|---|---|---|
| Up to four PiP panes on the home pages | ✅ | Android's ActivityView (system, 8–10) or the launcher's own virtual displays through a VD host (11+, standard). Android 8–10 through a host is **untested on a device** [H]. |
| Pinned PiP (FYT's pinned stack) | ✅ | FYT units except the 7870, decided by chipset [V]. |
| Layout creator | ✅ | One creator for every page since 2026-11-08 [V]. |
| Horizontal bar | ✅ | Top or bottom, auto-hide with an edge handle, on every page, resizable, the widget bar with 7 options [V]. |
| Vertical bar | ✅ | Left or right, on every page [V]. |
| Music and radio widgets | ✅ | Any player through the notification listener; FYT stock sources (`com.syu.music` on 7862/8581, `com.syu.media` on 7870); favorites and the Spotify / fYT Rating like status [V]. |
| Fuel statistics | ✅ | CAN bus library (built-in and importable), code reader, automatic code check, estimate model v3, stats window over apps [V]. |
| Night mode, weather | ✅ | Sunrise/sunset from the location, day/night wallpaper and brightness; OpenWeather [V]. |
| Logcat tool, crash and compat reports | ✅ | `Download/Launcher66_Logs` [V]. |
| Built-in updater | ✅ | Downloads the release asset for its own flavor [V]. |
| Baseline Profile with on-device compilation | ✅ | The profile in the repo is probably stale; see `KNOWN_ISSUES.md` [A]. |
| Standard flavor on root or Shizuku (VD host protocol 3) | ✅ | Overlay, notification access and install permissions granted through the host [V]. |
| A build for custom ROMs with their own platform key | ❌ | "No such build exists yet" (README) [V]. |

## Technology

Java with some Kotlin; AGP 9.3.2, Kotlin 2.4.10, Gradle 9.8.0, JDK 21; compileSdk 37, targetSdk 36, minSdk 26.
The modules are `:app`, `:baselineprofile`, `:hiddenapi-stubs`, `:vdhost-shared` and `:vdhost-server`.
JUnit 5 JVM tests: 95 files, about 866 tests, no instrumented tests. CI runs on GitHub Actions [V].
See `ARCHITECTURE.md`.

## Constraints that shape every change

- Two flavors, one codebase: the `system` flavor runs as uid 1000 and the `standard` flavor gets its
  privileges from a VD host. A feature must degrade cleanly where its privileges are missing [V].
- FYT firmware code (`com.syu.*`) is decompiled and fits one firmware. Calls into it go through the
  `FytCompat` fuse, so a mismatch is reported, not a crash [V].
- StrictMode is on in release builds; no I/O on the main thread [V].
- No new dependencies; logic goes in plain Java classes with tests; strings go in all 59 languages
  (`CLAUDE.md`) [H].

## Blocked or waiting

- Device review of round G1–G3 (workspace load watchdog, widget colors, creator overlap rule): **waiting
  for the owner** [V].
- Android 8–10 through the VD host (module or Shizuku): written from AOSP sources only, needs one device each
  of 8.0, 8.1/9 and 10 (checklist in `vdhost/README.md`) [H].
- A build for a ROM signed with its own platform key: blocked, because only the ROM's maintainer has the key
  (README) [V].

## Known critical issues

The full list with priorities is in `KNOWN_ISSUES.md`. The most important:

1. The OpenWeather API key is hardcoded in public source and was never rotated (`KI-01`).
2. The Baseline Profile has probably not been regenerated after about 500 commits of changes (`KI-04`).
3. `README.MD` lagged behind the code by one round. It was updated on 2026-11-10; keep it current (`KI-09`).

## Next priorities

**Confirmed by the owner or the briefs:**
- Owner's device review of the last round. The next brief opens with it.
- Deferred ideas, each needing its own brief (`ROADMAP.md`): pin day/night mode to the PiP displays; FYT
  skins in the standard flavor.

**Recommendations from the 2026-11-10 audit (not decided):**
- Decide on the 1.2.2 release: regenerate the Baseline Profile, bump `versionName`, merge `testBranch` → `main`.
- Move the weather API key out of the source and rotate it.
- Remove the unused Room and Compose dependencies.

## Documentation map

| File | What it holds |
|---|---|
| [`CLAUDE.md`](CLAUDE.md) | Rules, commands, Opus/Sonnet workflow |
| [`ARCHITECTURE.md`](ARCHITECTURE.md) | Modules, subsystems, data, services, privileges |
| [`DECISIONS.md`](DECISIONS.md) | Owner decisions and rejected approaches |
| [`ROADMAP.md`](ROADMAP.md) | Milestones, deferred ideas, recommendations |
| [`KNOWN_ISSUES.md`](KNOWN_ISSUES.md) | Bugs, debt, risks |
| [`prompts/README.md`](prompts/README.md) | Catalogue of all briefs → commits → status |
| [`chat_archive/README.md`](chat_archive/README.md) | Reports from the older conversations (to be filled) |
| [`reports/`](reports/) | The 2026-11-10 implementation and documentation audits |
