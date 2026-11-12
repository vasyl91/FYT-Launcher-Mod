# Implementation audit (2026-11-10)

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
