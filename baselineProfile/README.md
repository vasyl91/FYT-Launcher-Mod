# Baseline Profile – FYT Launcher Mod

End-to-end guide for generating the Baseline Profile of `com.android.launcher66` on a rooted
FYT test unit and delivering it to user head units (no root, no PC).

---

## 1. How it fits together

| Piece | Where | Role |
|---|---|---|
| `:baselineprofile` module | `baselineprofile/` | Self-instrumenting test APK that drives the launcher and records the profile |
| `BaselineProfileGenerator.kt` | `baselineprofile/src/main/java/.../baselineprofile/` | The recorded user journeys |
| `StartupBenchmark.kt` | same | Optional startup measurement (with vs. without profile) |
| `prepare_device.sh` | `baselineprofile/tools/` | Prepares the rooted test unit (root, HOME role, test conditions) |
| `su_wrapper.sh` | `baselineprofile/tools/` | Makes Magisk understand Macrobenchmark's `su root <cmd>` |
| `apply_profile_on_device.sh` | `baselineprofile/tools/` | Dev unit only: applies a profile manually for quick checks |
| `BaselineProfileCompiler.kt` | `app/src/main/java/com/android/launcher66/perf/` | Applies the profile on user units automatically |
| Generated profiles | `app/src/fytRelease/generated/baselineProfiles/` | `baseline-prof.txt`, `startup-prof.txt` – committed to Git |

Data flow:

```
test unit (root)                         build                     user unit (no root)
generateFytReleaseBaselineProfile  ->  baseline-prof.txt   ->  fytRelease APK contains      ->  BaselineProfileCompiler
(BaselineProfileGenerator)             startup-prof.txt        assets/dexopt/baseline.prof      compiles it (speed-profile)
                                                               + R8 startup DEX layout          90 s after the first start
```

Why a runtime compiler is needed: ProfileInstaller only copies the profile into ART. Android
compiles it in the background dexopt job, which needs "idle maintenance" (screen off, charging,
long inactivity) – a head unit in a car practically never gets there.

---

## 2. Prerequisites

**PC**
- Android Studio with AGP 9.3.2, Kotlin 2.4.10, Gradle 9.x, JDK 21.
- `adb` on `PATH`.
- Git Bash (MINGW64) for `prepare_device.sh`. Gradle commands work in PowerShell or Git Bash.

**Test unit** (FYT, Android 10 / API 29)
- Rooted with Magisk; root access for **Shell** allowed (Magisk → Superuser).
- Connected over ADB (USB or Wi-Fi), exactly one device.
- The launcher is installed as a system app (`/oem/priv-app/…`, `sharedUserId=android.uid.system`).

**Signing** – the most common source of failures
- Gradle installs `fytNonMinifiedRelease` as an **update** of the system app. It must be signed
  with the **same platform key** as the APK in `/oem/priv-app` (release signing config:
  `keystore.properties` or the fallback `app/keystore.jks`).
- Wrong key → `INSTALL_FAILED_UPDATE_INCOMPATIBLE` / `INSTALL_FAILED_SHARED_USER_INCOMPATIBLE`.

**Line endings** – `.sh` files must stay LF. Recommended `.gitattributes` in the repo root:

```
*.sh text eol=lf
```

(`prepare_device.sh` also strips CR from `su_wrapper.sh` before pushing it.)

---

## 3. Prepare the test unit

Run from **Git Bash**:

```bash
cd baselineprofile/tools
chmod +x prepare_device.sh
./prepare_device.sh
```

What it does:
1. Checks that exactly one device is connected and shows model / API / build type.
2. Checks the launcher package (UID 1000) and warns if a leftover `/data/app` update exists.
3. **Root for Macrobenchmark** – on Android 10 profile capture needs root. Macrobenchmark runs
   root commands as `su root <cmd>`; Magisk's `su` hangs on that syntax, which makes the tests
   freeze at `0/N completed`. The script detects this (5 s timeout) and installs
   `su_wrapper.sh` as `/sbin/su`, translating `su root <cmd>` into `magisk su -c "<cmd>"`.
   The original is kept as `/sbin/su.orig`.
4. Makes the launcher the default HOME app (`cmd role add-role-holder android.app.role.HOME`).
5. Shows the system Settings package (the test force-stops it after every cold start).
6. Keeps the screen on and disables ADB install verification (no Play Protect dialogs).

> **Re-run `prepare_device.sh` after every reboot of the unit.** `/sbin` is a tmpfs, so the
> wrapper disappears on reboot (which is also the safest way to undo it).

Undo without rebooting:

```bash
./prepare_device.sh --restore
```

If a root prompt appears on the head unit screen, allow it for **Shell** permanently.

---

## 4. Generate the profile

From the project root.

**PowerShell** – the `-P` argument must be quoted, otherwise PowerShell splits it at the dot:

```powershell
./gradlew :app:generateFytReleaseBaselineProfile "-Pandroid.testInstrumentationRunnerArguments.androidx.benchmark.enabledRules=BaselineProfile"
```

**Git Bash**:

```bash
./gradlew :app:generateFytReleaseBaselineProfile -Pandroid.testInstrumentationRunnerArguments.androidx.benchmark.enabledRules=BaselineProfile
```

Notes:
- `enabledRules=BaselineProfile` runs only the generator; the two `StartupBenchmark` tests are
  reported as `SKIPPED`. Gradle still counts them (e.g. `Starting 4 tests`).
- The task picks the right variants itself (`fytNonMinifiedRelease`); the selection in the
  *Build Variants* panel does not matter.
- Duration on a UMS512 unit: roughly **10–16 minutes**. Do not touch the unit meanwhile.

Recorded journeys (`BaselineProfileGenerator`):

| Test | Journey | In startup profile |
|---|---|---|
| `startup` | Cold start via HOME intent, workspace swipes along the bottom edge (8 dp above it, below the embedded PiP apps) | yes |
| `secondaryScreens` | App drawer (tap 40 dp from bottom-left, 2 s, BACK), launcher settings (scroll, BACK), wallpaper picker (6 taps on thumbnails, 100 dp apart, BACK) | no |

Follow the run live (second terminal):

```powershell
adb logcat -s BaselineProfileGen Benchmark TestRunner
```

Expected per iteration: the task stack before each BACK, and
`Profile flush requested for com.android.launcher66:wallpaper_chooser (pid …)`.

What you should see on the unit: system Settings briefly → launcher cold start → page swipes →
app drawer opens/closes → launcher settings scroll → back **directly** to the home screen →
wallpaper picker with changing previews → back directly to the home screen.

At the end Gradle prints the paths and a comparison with the previous profile, e.g.:

```
A baseline profile was generated for the variant `fytRelease`:
file:///…/app/src/fytRelease/generated/baselineProfiles/baseline-prof.txt
Comparison with previous baseline profile:
  11230 Old rules / 11175 New rules / 24 Added / 79 Removed
```

Between runs with an unchanged app, a difference below ~1 % is normal.

### Check the result

```powershell
$bp = "app\src\fytRelease\generated\baselineProfiles\baseline-prof.txt"
(Get-Content $bp).Count                                               # total rules
(Select-String -Path $bp -Pattern "Lcom/android/launcher66/").Count   # launcher rules
(Select-String -Path $bp -Pattern "WallpaperPicker|WallpaperCrop").Count
(Select-String -Path $bp -Pattern "Lcom/syu/|Lcom/fyt/").Count
```

`startup-prof.txt` must be noticeably smaller than `baseline-prof.txt` (it contains only the
`startup` journey). **Commit both files.** Never edit them by hand – the next generation
overwrites them.

---

## 5. Build the release APK

```powershell
./gradlew :app:assembleFytRelease
```

Verify that the profile is packaged (Windows 10+ `tar` can list ZIP files):

```powershell
tar -tf app\build\outputs\apk\fyt\release\fyt_release_<version>.apk | findstr dexopt
```

Expected:

```
assets/dexopt/baseline.prof
assets/dexopt/baseline.profm
```

R8 also uses `startup-prof.txt` to place startup classes in the primary DEX
(`dexLayoutOptimization = true`).

> The `profile` build type has its own source set and does **not** receive the profile from
> `src/fytRelease`. Ship `fytRelease` builds, or copy the file to
> `app/src/fytProfile/baselineProfiles/` if you really deploy `profile` builds.

---

## 6. Deploy to FYT units (user units: no root, no PC)

1. Put the release APK on the USB stick exactly as before (same directory layout / file name
   `190001066_com.android.launcher66.apk`) and run the usual install script.
   - The line `rm -rf /data/dalvik-cache/profiles/190001066_com.android.launcher66*` is a no-op
     on Android 10 (profiles live in `/data/misc/profiles/`) and can be removed. Profile cleanup
     is now done by the launcher itself.
   - Everything else in the script stays unchanged.
2. Reboot the unit (as usual after the install).
3. On the first start of the new APK, `BaselineProfileCompiler`, **90 s after the launcher
   starts**:
   1. force-writes `baseline.prof` from the APK into the ART profile (ProfileInstallReceiver),
   2. compiles the app with `speed-profile` (`performDexOptMode`).

   The launcher keeps running during this; nothing restarts. (Earlier versions also called
   `clearApplicationProfileData`, which freezes the package and kills the launcher – removed.)
4. The compiled code is used from the **next start of the launcher process** – in practice the
   next ignition cycle.

This works without root because the launcher runs as UID 1000 with the platform signature, so
system_server allows it the same operations as `adb shell`. The work runs once per new APK
(version name + APK file time + size); failures are retried on the next starts, at most 3 times
per APK.

### Required app integration (already described earlier, listed for completeness)

`app/build.gradle.kts`:

```kotlin
implementation(libs.androidx.profileinstaller)   // implementation, not runtimeOnly (ProfileVerifier is used)
"baselineProfile"(project(":baselineprofile"))
```

`LauncherApplication.onCreate()`:

```kotlin
BaselineProfileCompiler.scheduleIfNeeded(this)
```

Optional status for units without a PC – show it e.g. as an "About" entry in the settings:

```kotlin
summary = BaselineProfileCompiler.statusText(context)
```

Expected after a successful deployment and one restart:

```
Deployment: OK (active after the next launcher restart) - <stamp>
ProfileVerifier: code=…, compiledWithProfile=true, enqueued=false
```

---

## 7. Verify on the test unit

After installing the new APK via the USB stick and rebooting, wait ~2 minutes, then:

```powershell
adb logcat -d -s BaselineProfile ProfileInstaller
adb shell "dumpsys package dexopt | grep -A 3 '\[com.android.launcher66\]'"
```

Expected log:

```
I BaselineProfile: ProfileInstaller result=1
I BaselineProfile: performDexOptMode(speed-profile) = true
I BaselineProfile: OK (active after the next launcher restart) - …
```

The launcher process must **not** end between these lines (no `PROCESS ENDED` in Logcat).
`ProfileInstaller: Skipping profile installation` at a later start is normal – the automatic
installer skips APKs it has already handled; the forced write above does not depend on it.

Expected dexopt status: `[status=speed-profile]`. `[status=speed]` is also fine (the system
chose full AOT compilation). `quicken` / `verify` means the profile was not applied.

Quick manual path on the rooted unit (skips the 90 s delay):

```powershell
adb push baselineprofile/tools/apply_profile_on_device.sh /data/local/tmp/
adb shell su -c sh /data/local/tmp/apply_profile_on_device.sh
```

If the log shows `NoSuchMethodException` or `SecurityException`, the firmware changed the hidden
API – see Troubleshooting.

---

## 8. Optional: measure the gain

`StartupBenchmark` compares a cold start without compilation against a start with the profile
(variant `fytBenchmarkRelease`, minified like the shipped APK):

```powershell
./gradlew :baselineprofile:connectedFytBenchmarkReleaseAndroidTest "-Pandroid.testInstrumentationRunnerArguments.androidx.benchmark.enabledRules=Macrobenchmark"
```

Results (`timeToInitialDisplayMs`, min/median/max) appear in the Gradle output / Android Studio
test window and as JSON under `baselineprofile/build/outputs/connected_android_test_additional_output/`.
Requires the same device preparation as generation (root wrapper, HOME role).

---

## 9. Clean-up after a session

```powershell
adb shell "dumpsys package com.android.launcher66 | grep codePath"
```

- If a `codePath=/data/app/…` line is present, a test build is still installed over the system
  app: `adb uninstall com.android.launcher66` removes the update and reverts to `/oem/priv-app`.
- Remove the su wrapper: `./prepare_device.sh --restore` (Git Bash) or reboot the unit.
- Optionally re-enable ADB install verification:
  `adb shell settings put global verifier_verify_adb_installs 1`.

---

## 10. When to regenerate

- After significant changes to startup, workspace, widgets, app drawer, settings or the
  wallpaper picker.
- After dependency upgrades that change startup code (AndroidX, Compose, Glide, Room, …).
- At least once per release. Commit the regenerated files together with the code change.

---

## 11. Troubleshooting

| Symptom | Cause | Fix |
|---|---|---|
| Tests stay at `0/N completed` for minutes | Magisk `su` hangs on `su root <cmd>` | Run `prepare_device.sh` (installs the wrapper); check `adb shell "timeout 5 su root id"` |
| `Starting 0 tests … Process crashed` | Usually leftovers of a previously interrupted (hung) run | `adb shell am force-stop com.android.launcher66.baselineprofile` and run again; if it persists: `adb logcat -b crash -d` |
| `INSTALL_FAILED_UPDATE_INCOMPATIBLE` / `…SHARED_USER_INCOMPATIBLE` | Release signing key differs from the system APK key | Use the platform key in `keystore.properties` |
| `Launcher was not resumed within 15000 ms` | Another app is on top, HOME role lost, or a chooser dialog | Re-run `prepare_device.sh`; look at the unit screen |
| Return from settings / wallpaper picker goes through system Settings or Recents | Old generator version (Macrobenchmark's `CLEAR_TASK` reuses a stale launcher task) | Use the current `BaselineProfileGenerator.kt`; a reboot clears stale tasks |
| Workspace swipes move embedded PiP apps | Swipe height | Adjust `SWIPE_BOTTOM_OFFSET_DP` |
| App drawer / wallpaper taps miss | Different UI geometry | Adjust `APP_DRAWER_*` / `WALLPAPER_TAP_*` constants |
| `Profile flush skipped: process … not running` | Picker process already gone | Increase `WALLPAPER_TAP_COUNT` or check the picker opens |
| `killProcess()` throws | Firmware restarts the launcher immediately | Remove `killProcess()` from `coldStartViaHome()` |
| PowerShell: `Task '.testInstrumentationRunnerArguments…' not found` | Unquoted `-P` argument | Quote the whole `-P…` argument |
| PowerShell: `grep` not recognized | Not available in PowerShell | Use `Select-String`, or run in Git Bash; inside `adb shell "…"` use `grep` (runs on the device) |
| `Variant phone… is disabled` warnings | Intentional (`beforeVariants`) | Silence with `baselineProfile { warnings { disabledVariants = false } }` |
| `Unable to strip … libbenchmarkNative.so` | Native libs of the test APK | Harmless |
| Wrapper: `su root id` fails after install | CRLF line endings or wrong SELinux label | `prepare_device.sh` strips CR and copies the label of `/sbin/magisk`; check `adb shell "su -c 'ls -lZ /sbin/su'"` |
| Launcher restarts ~90 s after boot, status stays `Deployment: none` | Old `BaselineProfileCompiler` calling `clearApplicationProfileData` (kills the package) | Use the current version |
| User unit: status `FAILED - attempt 3/3` | Hidden API changed or ProfileInstaller error | Read `adb logcat -s BaselineProfile` on a test unit with the same firmware |
| `dexopt` shows `quicken` after deployment | Profile not applied yet or compiler failed | Check status text / log; the code is active only after the next launcher restart |

---

## 12. Configuration reference

Key decisions in the build setup and why they matter:

- **Self-instrumenting test module** (`android.experimental.self-instrumenting = true`): the test
  APK instruments itself and drives the launcher via shell/UiAutomator, so it does not need the
  platform key even though the launcher runs as UID 1000.
- **Same flavors in `:baselineprofile`** (`phone`, `fyt`) so the plugin pairs variants;
  `phone` variants are disabled with `beforeVariants` in both modules, plus the
  `nonMinifiedProfile` / `benchmarkProfile` variants in `:app`.
- **`suppressErrors = EMULATOR,LOW-BATTERY,UNLOCKED`**: a head unit has no battery / lock screen.
- **`saveProfileWaitMillis = 3000`**: slower eMMC on FYT units.
- **Consumer config in `:app`**: `automaticGenerationDuringBuild = false` (no device needed for
  normal builds), `saveInSrc = true`, `dexLayoutOptimization = true`.
- **Versions** (`gradle/libs.versions.toml`): `benchmark = 1.5.0` for both the
  `androidx.baselineprofile` plugin and `benchmark-macro-junit4` (1.5 is the first line that
  works with AGP 9 without `newDsl=false`); `profileinstaller = 1.4.1` (multi-process profile
  capture – the wallpaper picker runs in `:wallpaper_chooser`).
- **Secondary screens are started with a plain `am start -f NEW_TASK|TASK_ON_HOME`**, not with
  `startActivityAndWait()`: Macrobenchmark always adds `CLEAR_TASK`, and because
  `SettingsActivity` / `WallpaperPickerActivity` share the launcher's task affinity, that reuses
  a stale launcher task and breaks the return to the home screen.
- **Explicit HOME intent with component** for cold starts: the manifest has two `LAUNCHER`
  activities, so the default launch intent could resolve to the settings screen.
