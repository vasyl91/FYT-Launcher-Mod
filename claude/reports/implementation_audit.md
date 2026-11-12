# Implementation audit (2026-11-10, re-verified 2026-11-12)

> **Latest verification: 2026-11-12**, at `ee8e4f91`. The findings of 2026-11-10 below are kept as they were
> written. What changed since, and what turned out to be wrong, is in the addendum at the end. Where the two
> disagree, the addendum holds.

An audit of the codebase at `testBranch` `3dd71894`, done to build the knowledge base in `claude/`. No
application code was changed. The current-state documents are `../PROJECT_STATE.md`, `../ARCHITECTURE.md`
and `../KNOWN_ISSUES.md`; this report keeps the method, the evidence and the open questions.

## Method

- **Git:** the clone had 50 commits. The full history (792 commits) was fetched. The audit then grouped
  commits by month, tag, author trailer and `Claude-Session`, and compared `testBranch` with `main` and
  `v1.2.1`.
- **Code:** file and line counts per package; class-level Javadoc of the main subsystems; the manifests;
  `build.gradle.kts`, `libs.versions.toml`, `settings.gradle.kts`; the workflows; the assets.
- **Dependencies:** "used" means an import of the library's package under `app/src`.
- **Secrets:** searched by pattern without printing values. The keystore values were compared with the
  public defaults without printing them.
- **Briefs:** each brief's prescribed commit subjects were matched against `git log`
  (`../prompts/README.md`).
- **CI:** the latest `build.yml` runs on `testBranch`, read through the GitHub API (run 464 on `3dd71894`:
  success). The releases and open issues were read the same way.

### Limitations

- **Nothing was built or run locally.** The container has no Android SDK. The build and test status comes
  from CI only.
- **No device behaviour could be checked.** Statements about devices come from the briefs and `README.MD`
  and are marked [H].
- The AOSP-derived and decompiled code (`com/syu/**`, much of `com/android/launcher66`) was mapped, not
  reviewed line by line.
- Unused-dependency detection by import can miss reflection or manifest-only use. It does not apply to Room
  or Compose, which have no such use.

## Findings

### Size and composition [V]
- `app/src/main/java`: 1,916 Java and 9 Kotlin files, about 330k lines.
- Decompiled FYT code dominates by file count: `com/syu/module/canbus` 729 files, `com/syu/ui/air` 473.
- The owner's code is mainly in `com/android/launcher66` (192 files) and `…/settings` (120), plus
  `com/syu/util` (the panes) and `com/fyt/car` (the stock sources).
- Largest classes: `Launcher` 9,471 lines, `Workspace` 8,558, `CellLayout` 4,870, `LauncherModel` 3,814,
  `MediaFavoriteController` 3,814, `PagedView` 3,105, `SettingsFragmentSecond` 2,598.

### Build and CI [V]
- Five Gradle modules and two flavors; see `../ARCHITECTURE.md` §2.
- CI: unit tests, both debug flavors and the Magisk zip on every push. Green on HEAD. No lint task, and the
  `:baselineprofile` journeys do not run in CI.

### Tests [V]
- 95 JVM test files, about 866 `@Test` methods (JUnit 5), almost all for plain-Java rule classes introduced by
  the briefs.
- No `androidTest` source set anywhere.

### Dependencies [V]
- Used: Glide, OkHttp, LitePal, Flexbox, Material, Ackpine, coroutines, Play services location, Shizuku,
  profileinstaller, LeakCanary (debug), and `app/libs/cn.jar` (Kuwo auto SDK).
- **Declared but unused:** Room (runtime + KSP compiler) and Compose (BOM, runtime, tooling, the compose
  plugin, `buildFeatures.compose`). KI-03.

### Security [V]
- **The OpenWeather key is hardcoded** in `com/syu/weather/WeatherManager.java:50`. It is redacted from the
  logs but not rotated or moved. KI-01.
- The keystore is committed with the public defaults, on purpose (D-02, KI-02).
- The Spotify refresh token is stored in SharedPreferences. `allowBackup="false"`, so it stays on the device.
  PKCE without a client secret, which is normal for a public client. No action needed.
- The `system` flavor holds many signature permissions as uid 1000. That is inherent to its design.

### Technical debt [V]
- 31 `TODO`/`XXX` markers, all AOSP Launcher3 leftovers (KI-08).
- Reliance on hidden APIs and reflection (KI-12).
- About 305 MB of decompiled reference trees, 176 MB of media in `images/`, and an obsolete `android_jar/`
  (KI-07).

### Release state [V]
- Last release v1.2.1 (2026-10-06). `versionName` is still `1.2.1`.
- 532 commits since the tag; `testBranch` is 137 commits ahead of `main`. KI-10.

### History [V]
- 792 commits from 2024-11-12.
- Releases v1.0.2 … v1.2.1, all tagged.
- External PRs #4–#7 (2026-07/08): media favorites, the Maps window, zh-rCN.
- 517 commits are co-authored by Claude, since 2026-10-05.
- 33 briefs, from 2026-10-27 to 2026-11-08, are all implemented (`../prompts/README.md`).

## Unresolved questions for the owner

1. **The OpenWeather key:** was moving and rotating it (P10 of the 2026-10-26 analysis) decided against, or
   just not done yet?
2. **Room and Compose:** planned for later, or can they go?
3. **Release 1.2.2:** is a date or a condition planned (device review, Baseline Profile)?
4. **The Baseline Profile:** when was it last generated on a device? Git does not show it.
5. **Revert `b38f1286`** ("on the 7862 the stats' surface moves with the launcher's frame"): what was the
   reason? It is not recorded.
6. **The `decompiled_*` trees and README videos:** should they stay in Git (KI-07, R-5)?
7. **Round G:** the device result of the workspace load, widget colors and overlap rule.

---

## Addendum: re-verification of 2026-11-12

Done for the knowledge consolidation (`KNOWLEDGE_CONSOLIDATION_REPORT.md`), after the owner added 15
conversation reports and moved the reference material into `archive/`.

### Corrections to the 2026-11-10 findings

| 2026-11-10 said | Correct | How found |
|---|---|---|
| `android_jar/` is obsolete since 1.1.7 | `android_jar/android-36.jar` is a compile-time dependency of `:hiddenapi-stubs` and `:vdhost-shared`. Only the two `.rar` archives of the modified-jar workflow are obsolete | the build broke when the folder was moved (`8bfc5a8d`); CI run 467 failed; reproduced with `javac` with and without the jar; fixed by the owner in `ee8e4f91` (run 468 green) |
| The OpenWeather key is a security finding; whether keeping it was decided is unknown | The owner decided to keep it hardcoded, twice, and had a move to `BuildConfig` reverted | CHAT_01, CHAT_02; `DECISIONS.md` D-26 |
| Location "platform first": reason not recorded | The owner chose it after ART warnings about Play services classes | CHAT_11; D-19 |
| Unresolved question 5: why was `b38f1286` reverted? | Still unknown, but the context is known: the reverted commit was an untested third attempt at the 7862 stats-window lag | CHAT_10; D-24, KI-21 |
| 532 commits since `v1.2.1`, 137 ahead of `main` | 536 and 141 (four commits since: the docs, two `archive` commits, `jars`) | `git rev-list --count` |

### New findings

- **Repository layout [V]:** `archive/decompiled/` (four decompiled apps), `archive/fuel_stats_example/`,
  `archive/android_jar/` (two `.rar` files); `decompiled_FYT_jars/` removed from the tree; the documentation
  folder is `claude/` (lower case).
- **`canbus_library/build_canbus_library.py` [V]:** its `--launcher` mode looked for the decompiled sources
  at the repository root. It now reads them under `archive/decompiled/` (`LAUNCHER_SOURCE_ROOT`). Checked by
  rebuilding both built-in libraries: the output is byte-identical to `canbus_library.txt` and
  `canbus_library_7870.txt`.
- **`display_pip` defaults [V]:** nine readers use default `true`, three use `false`
  (`settings/SettingsFragmentSecond.java` twice, `settings/DrawViewScreen.java`); nothing calls
  `PreferenceManager.setDefaultValues`. KI-20.
- **Chat reports against git [V]:** the reports cite 156 distinct commits, all in `testBranch`. Two cited
  hashes are not in the repository (`a63f42c`, a pre-rebase local commit; `0b722649`, never pushed). The
  fixes of CHAT_01, which made no commits, are in the code through the owner's `eed91b73` and `3f4d96da`.
- **Spot checks of reported behaviour in the code [V]:** see `../chat_archive/README.md`, "Verification".
- **CI [V]:** run 465 (`a30c9a72`) success; run 467 (`754c8258`) failure; run 468 (`ee8e4f91`) success, with
  the unit tests, both debug builds and the Magisk module.

### Limitations (unchanged)

Nothing was built or run locally beyond `javac` on two small modules and the Python library script. No
device behaviour was checked. Statements about devices come from the briefs and the reports.

### Questions for the owner: status on 2026-11-12

| # | Question of 2026-11-10 | Status |
|---|---|---|
| 1 | The OpenWeather key | **Answered** by the reports: it stays (D-26) |
| 2 | Room and Compose: planned or removable? | open |
| 3 | A date or condition for 1.2.2 | open |
| 4 | When was the Baseline Profile last generated? | open |
| 5 | Reason for revert `b38f1286` | open; and is the 7862 stats lag still there? (KI-21) |
| 6 | Should the reference trees and README videos stay in Git? | partly: they were gathered in `archive/`; the size question is open (R-5) |
| 7 | Device result of round 12 | open (KI-24) |
| 8 | *New:* whose devices are the two phones? | **Answered** by the owner 2026-11-12: both phones and the 7862 are the owner's; the 7870 is a tester's |
| 9 | *New:* which changes "did not work on the 7870" (CHAT_14)? | open (KI-29) |
| 10 | *New:* is "Proceed and fit" the wanted name for the creator's dialog button? | open (KI-24) |

