# Known issues

As of 2026-11-10 (`3dd71894`).

- **Priority:** High = fix before the next release · Medium = plan it · Low = when convenient ·
  Accepted = a known limitation, by design or decided.
- **Status:** open · partial · accepted · fixed (keep fixed entries for one release, then remove them).

Add new issues at the end with the next number.

| ID | Issue | Kind | Priority | Status |
|---|---|---|---|---|
| KI-01 | OpenWeather API key hardcoded in public source | Security | **High** | partial |
| KI-02 | Public platform signing key committed | Security | Accepted | accepted (D-02) |
| KI-03 | Room and Compose declared but unused | Tech debt | Low | open |
| KI-04 | Baseline Profile probably stale | Performance | Medium | open |
| KI-05 | Android 8–10 through the VD host never run on a device | Incomplete | Medium | open |
| KI-06 | No instrumented or UI tests; device behaviour checked by hand only | Missing tests | Medium | open |
| KI-07 | Repository footprint (about 550 MB of Git history) | Maintenance | Low | open |
| KI-08 | Very large classes and legacy AOSP TODOs | Tech debt | Low | accepted |
| KI-09 | `README.MD` lagged behind the bar features of 2026-11-08 | Docs | Low | fixed 2026-11-10 |
| KI-10 | Unreleased work: version still 1.2.1, `main` 137 commits behind | Release | Medium | open |
| KI-11 | Heavy cold start after a reboot | Performance | Medium | partial |
| KI-12 | Reliance on hidden APIs and reflection | Fragility | Medium | accepted |
| KI-13 | Shizuku host limits | Limitation | Accepted | accepted |
| KI-14 | `com.syu.media` favorites limits (7870) | Limitation | Accepted | accepted |
| KI-15 | Pinned PiP limits | Limitation | Accepted | accepted |
| KI-16 | A standard ("phone") 1.2.1 cannot update itself | Release | Accepted | accepted |
| KI-17 | Lint is weak in this project | Quality | Low | open |
| KI-18 | Framework warnings `Parcel`/`SurfaceSyncer` in logs | Noise | Accepted | won't fix (D-15) |

## Details

### KI-01 OpenWeather API key hardcoded in public source
- **Where:** `app/src/main/java/com/syu/weather/WeatherManager.java:50` (`OPEN_WEATHER_APPID`). It has been
  there since 1.1.7 (2025-11-21).
- **Impact:** anyone can use or exhaust the key. It also appeared in logs shared off the device before
  2026-10-27.
- **Done:** the key and exact coordinates are redacted from the logs (`771f9387`), with a test (`8cc9e48f`).
- **Not done:** moving the key to `local.properties` → `BuildConfig`, and rotating it
  (`prompts/archive/analysis/log-analysis-2026-10-26.md` P10). Whether this was decided against is
  unknown. See D-26 and R-1.

### KI-02 Public platform signing key committed
`app/keystore.jks` and `keystore.properties` hold the public `android` defaults (`7d1d9ee8`). The `system`
flavor needs the AOSP test platform key that FYT firmware uses. Anyone can sign an APK that updates the
launcher on such firmware; that is inherent to the platform key. Accepted.

### KI-03 Room and Compose declared but unused
- **Where:** `app/build.gradle.kts` (`room-runtime`, `ksp(room-compiler)`, the Compose BOM, runtime and
  tooling, `buildFeatures.compose = true`, the Kotlin Compose plugin).
- **Evidence:** zero imports of `androidx.room` or `androidx.compose` under `app/src`.
- **Impact:** build time (KSP, the Compose compiler). R8 keeps the effect on APK size small.
- **Next:** remove them unless the owner plans to use them (R-2). This is a build change, so it needs a brief.

### KI-04 Baseline Profile probably stale
- **Where:** `app/src/main/generated/baselineProfiles/`.
- **Evidence:** since the profile was moved into `src/main` (`97c59837`, 2026-10-15), commits only deleted
  lines for removed classes. A regeneration after the roughly 500 later commits is not evident [A].
- **Impact:** new code is not compiled ahead of time, so the start is slower.
- **Next:** regenerate on a device before 1.2.2 (P-3, `baselineProfile/README.md` §10).

### KI-05 Android 8–10 through the VD host never run on a device
The path for a non-system launcher on 8.0, 8.1/9 and 10 (module daemon or Shizuku) was written from the
AOSP sources only. The full checklist is in `vdhost/README.md` ("Still to test on a device"). Relevant
code: `vdhost/shared/src/main/java/com/syu/vdhost/VdHostCore.java`, `app/src/main/java/com/syu/util/WindowHostVd*`.

### KI-06 No instrumented or UI tests
- **What exists:** 95 JVM test files (about 866 tests), which cover the plain-Java logic.
- **Not covered:** views, windows, panes, the IPC with FYT apps, and the settings UI. These are verified only
  by the owner and the tester on their devices. `:baselineprofile` holds Macrobenchmark journeys, not tests,
  and CI does not run it.
- **Impact:** UI regressions surface only on a device, one round later.

### KI-07 Repository footprint
`.git` is about 550 MB. The working tree holds `decompiled_*` (about 305 MB), `images/` (176 MB, mostly
mp4/gif) and `android_jar/` (52 MB, obsolete since 1.1.7). Clones and CI checkouts are slow. These are
reference material by the owner's rule, so do not delete them; R-5 is the owner's call.

### KI-08 Very large classes and legacy AOSP TODOs
- **Large classes:** `Launcher.java` (9,471 lines), `Workspace.java` (8,558), `CellLayout.java` (4,870),
  `LauncherModel.java` and `MediaFavoriteController.java` (3,814 each), `SettingsFragmentSecond.java`
  (2,598).
- **TODOs:** the 31 `TODO`/`XXX` markers are AOSP Launcher3 leftovers (e.g. `LauncherModel.java:546` "something
  breaks this in the upgrade path"). None is the project's own.
- **Policy:** targeted edits only, and new logic in small tested classes (the briefs have done this).

### KI-09 README lag (fixed 2026-11-10)
`README.MD` did not describe the features of 2026-11-08: the horizontal bar at the top or bottom, the
vertical bar left or right and on every page, the edge handle on either edge, the Bars category. It was
updated in the commit that added this folder. Keep it current with `Docs: README for …` commits.

### KI-10 Unreleased work
`versionName = "1.2.1"`, 532 commits since `v1.2.1`, and `main` is 137 commits behind `testBranch`. Users of
the built-in updater get none of the 2026-10/11 work until a release (P-2).

### KI-11 Heavy cold start after a reboot
The plan → `finishBindingItems` step took 3.2 s (Samsung) and 9.3 s (Xiaomi), and a boot-time stall of about
10 s is known on FYT units (`ColdStart`). `69aac3b1` moved the widget list and class verification off the
critical path; deeper profiling is out of scope so far (P-8).

### KI-12 Reliance on hidden APIs and reflection
- **What:** ActivityView members copied by name (`WindowHostVdView`), `IActivityManager`/`IActivityTaskManager`,
  the hidden `InputManager.monitorGestureInput()` (`EdgeSwipeMonitor`, `UserTouches`), `TaskStackListener`
  (`hiddenapi-stubs`), and the decompiled FYT IPC.
- **Impact:** a new Android version or ROM can break a feature silently.
- **Mitigation:** the `FytCompat` fuse, the compat reports, and the host protocol versioning.

### KI-13 Shizuku host limits
- Apps with `FLAG_SECURE` (streaming, banking) show black in a pane.
- The panes come up only once Shizuku runs (about 30 s after boot).
- Shizuku without root must be started again after each reboot.
- Starting Shizuku with root is expected to fail before Android 14, because root owns no package.

Source: `README.MD`, `vdhost/README.md`.

### KI-14 `com.syu.media` favorites limits (7870)
- A heart pressed in the widget shows in `com.syu.media`'s own screen only after it reloads its library.
- FM favorites are read-only for other apps (the widget's heart is greyed out).
- The Bluetooth heart stays grey.

Source: `README.MD`, D-14.

### KI-15 Pinned PiP limits
- None on the 7870, where every PiP is a window.
- Google Maps switches to its minimal UI in FYT's pinned PiP unless the LSPosed module is used (D-23).
- If PiP is left on where pinned PiP does not work, Maps pops up on the home page.

Source: `README.MD`.

### KI-16 A standard ("phone") 1.2.1 cannot update itself
Its updater downloads the system build, which it cannot install. It needs one update by hand. Documented in
`README.MD` and `release-assets.yml`.

### KI-17 Lint is weak in this project
- `lint.checkReleaseBuilds = false`, and `lintConfig` is commented out, so `app/lint.xml` (which ignores
  `deprecation` and `unchecked`) is not used.
- The dependency-analysis plugin reports at `warn` only.
- CI runs no lint task.

### KI-18 Framework warnings
`W Parcel: Expecting binder but got null!` and `E SurfaceSyncer: Failed to find sync for id=0` are Android 13
framework warnings around pane SurfaceViews and have no effect. Won't fix (D-15, `vdhost/README.md`).
