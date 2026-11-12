# Project state

**Snapshot: 2026-11-12, `testBranch` at `ee8e4f91` plus two documentation commits (`e3ba694e` and the one
that carries this text). CI is green on `ee8e4f91` (run 468), the last commit that touched the build.** This file is the authoritative entry point for a new session. Update it at the
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
| Unreleased work | At `ee8e4f91`: 536 commits since `v1.2.1`, and `testBranch` 141 commits ahead of `main` (last merge: PR #33, 2026-11-01) [V]. |
| Next version | 1.2.2. README, the updater and `release-assets.yml` already describe `system_release_1.2.2.apk` [V]. **No release date is recorded** [U]. |
| Development phase | Short feature and fix rounds on `testBranch`, driven by device logs (Opus brief → Sonnet commits → owner test). 33 briefs since 2026-10-27, all implemented [V]. |
| Active brief | **None.** `prompts/active/` is empty [V]. |
| Last code change | Round 12 (G1–G3), 2026-11-08: `e3136f45`, `b1fe254c`, `3dd71894` [V]. No device result yet [H]. |
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
| Pinned PiP (FYT's pinned stack) | 7862 [H] | FYT units except the 7870, decided by chipset. The keyboard fix beside it is unconfirmed (KI-22). |
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
| Round 12: load restart, live widget colors, overlap rule | **none yet** | KI-24. |

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
JUnit 5 JVM tests: 95 files, about 866 tests, no instrumented tests. CI runs on GitHub Actions [V].

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

None. The next round starts when the owner reports on round 12 or asks for something new.

## Blocked or waiting

- **Device review of round 12** (workspace load restart, widget colors, creator overlap rule): waiting for
  the owner [H]. Open points are listed in KI-24.
- **Android 8–10 through the VD host:** needs one device each of 8.0, 8.1/9 and 10 (`vdhost/README.md`) [H].
- **A build for a ROM signed with its own platform key:** only the ROM's maintainer has the key [V].
- **Results from the 7870:** depend on the tester [H].

## Known critical issues

Nothing is rated High at the moment. The build break of 2026-11-10/12 is fixed (KI-19). The items to keep
in mind before a release, from `KNOWN_ISSUES.md`:

1. The Baseline Profile is probably stale (KI-04).
2. Round 12 has no device result (KI-24).
3. Several earlier changes have no device confirmation on record (KI-25), and the 7862 stats-window lag may
   still be there (KI-21).

The hardcoded OpenWeather key is **not** an open issue: the owner decided to keep it (D-26).

## Next priorities

**Confirmed by the owner or the briefs:**
- The owner's device review of round 12. The next brief opens with it.
- Release 1.2.2 at some point; before it, a fresh Baseline Profile (`ROADMAP.md` P-2, P-3).
- Deferred ideas, each needing its own brief: day/night mode pinned to the PiP displays; FYT skins in the
  standard flavor.

**Recommendations (not decided):** see `ROADMAP.md`, "Recommendations".

## Documentation map

| File | What it holds |
|---|---|
| [`CLAUDE.md`](CLAUDE.md) | Rules, commands, Opus/Sonnet workflow |
| [`ARCHITECTURE.md`](ARCHITECTURE.md) | What exists and where: modules, subsystems, data, services, privileges |
| [`DECISIONS.md`](DECISIONS.md) | Why: 49 decisions with status, who decided and the source |
| [`ROADMAP.md`](ROADMAP.md) | History in milestones, confirmed plans, recommendations |
| [`KNOWN_ISSUES.md`](KNOWN_ISSUES.md) | Confirmed problems, accepted limitations, unverified reports |
| [`prompts/README.md`](prompts/README.md) | Catalogue of all briefs → commits → status |
| [`chat_archive/README.md`](chat_archive/README.md) | Index of the 15 conversation reports and what was taken from each |
| [`reports/`](reports/) | The audits of 2026-11-10 and the consolidation report of 2026-11-12 |
