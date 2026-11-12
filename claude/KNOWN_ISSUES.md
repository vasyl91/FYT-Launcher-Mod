# Known issues

As of 2026-11-12 (`ee8e4f91` plus documentation commits), with the owner's answers of the same day. Sources: the code, git, CI, the
briefs and the chat reports (`chat_archive/`).

The file has three parts, because they call for different handling:

- **Part A, confirmed:** the code, git or CI shows the problem today.
- **Part B, accepted limitations:** known, and decided or inherent. Do not "fix" them without asking.
- **Part C, unverified:** a report or a code reading suggests a problem, or a change was never confirmed on a
  device. Check before acting on any of these.

**Priority:** High = fix before the next release · Medium = plan it · Low = when convenient.
**Status:** open · partial · fixed (kept for one release, then removed).

Add new issues at the end of their part with the next number. Numbers are never reused.

## Part A: confirmed

| ID | Issue | Kind | Priority | Status |
|---|---|---|---|---|
| KI-03 | Room and Compose declared but unused | Tech debt | Low | open; removal approved by the owner |
| KI-04 | Baseline Profile probably stale | Performance | Medium | open |
| KI-06 | No instrumented or UI tests | Missing tests | Medium | open |
| KI-07 | Repository footprint | Maintenance | Low | open |
| KI-09 | `README.MD` lagged behind the bar features | Docs | Low | fixed 2026-11-10 |
| KI-10 | Unreleased work: version still 1.2.1 | Release | Medium | open |
| KI-11 | Heavy cold start after a reboot | Performance | Medium | partial |
| KI-17 | Lint is weak in this project | Quality | Low | open |
| KI-19 | The build needs `android_jar/android-36.jar` at that path | Build | High | fixed 2026-11-12 |
| KI-20 | `display_pip` is read with two different defaults | Bug risk | Low | open |
| KI-23 | Translations are machine-written and unreviewed | Quality | Low | open |
| KI-24 | Round 12 (G1–G3) had no device result | Verification | Medium | fixed 2026-11-12: confirmed by the owner |

### KI-03 Room and Compose declared but unused
- **Where:** `app/build.gradle.kts` (`room-runtime`, `ksp(room-compiler)`, the Compose BOM, runtime and
  tooling, `buildFeatures.compose = true`, the Kotlin Compose plugin).
- **Evidence [V]:** zero imports of `androidx.room` or `androidx.compose` under `app/src`.
- **Impact:** build time (KSP, the Compose compiler). R8 keeps the effect on APK size small.
- **Owner, 2026-11-12 [H]:** not planned; they may be removed if unused.
- **Next:** remove them (`ROADMAP.md` P-12). This is a build change: Room's KSP processor goes, but KSP
  itself stays for Glide. CI is the check.

### KI-04 Baseline Profile probably stale
- **Where:** `app/src/main/generated/baselineProfiles/`.
- **Evidence:** since the profile was moved into `src/main` (`97c59837`, 2026-10-15), commits only deleted
  lines for removed classes [V]. The owner planned to regenerate it later (Cling brief, CHAT_07) [H]. Entries
  for classes removed since may remain; they do not break the build [H].
- **Impact:** new code is not compiled ahead of time, so the start is slower.
- **Next:** regenerate on a device before 1.2.2 (P-3, `baselineProfile/README.md` §10).

### KI-06 No instrumented or UI tests
- **What exists [V]:** 95 JVM test files (about 866 tests), which cover the plain-Java logic.
- **Not covered:** views, windows, panes, the IPC with FYT apps, and the settings UI. These are verified only
  by the owner and the tester on their devices. `:baselineprofile` holds Macrobenchmark journeys, not tests,
  and CI does not run it.
- **Impact:** UI regressions surface only on a device, one round later. Almost every chat report ends with
  "not tested on a device" (Part C).

### KI-07 Repository footprint
- **Evidence [V]:** `.git` is about 560 MB. The working tree holds `archive/` (about 300 MB of decompiled
  reference code) and `images/` (176 MB, mostly mp4/gif). Clones and CI checkouts are slow.
- **Done:** the owner gathered the reference material under `archive/` and removed `decompiled_FYT_jars/`
  from the tree (`8bfc5a8d`). History still carries everything.
- **Next:** R-5 is the owner's call. `archive/` is reference material: do not delete it.

### KI-09 README lag (fixed 2026-11-10)
`README.MD` did not describe the features of 2026-11-08 (bars at either side, the vertical bar on every
page, the handle on either edge, the Bars category). Updated in `a30c9a72`. Keep it current with
`Docs: README for …` commits.

### KI-10 Unreleased work
`versionName = "1.2.1"` [V]. At `ee8e4f91` (2026-11-12) there were 536 commits since `v1.2.1`, and `main` was
141 commits behind `testBranch`. Users of the built-in updater get none of the 2026-10/11 work until a release (P-2).

### KI-11 Heavy cold start after a reboot
- **Measurements [H]:**
  - plan → `finishBindingItems`: 3.2 s (Samsung), 9.3 s (Xiaomi) (analysis 2026-11-03);
  - on the 7862, `bindItems` → `finishBindingItems` about 6.6 s after a force-stop (CHAT_01, 2026-10-05);
  - first frame about 2.1 s, bars 2.3 s, panes ready 6–7 s after a cold start (CHAT_02).
- **Known cause [H]:** this ROM blocks calls into `system_server` for about ten seconds at boot (`ColdStart`).
- **Done:** `69aac3b1` moved the widget list and class verification off the critical path.
- **Next:** profiling on a device (P-8).

### KI-17 Lint is weak in this project
- `lint.checkReleaseBuilds = false`, and `lintConfig` is commented out, so `app/lint.xml` (which ignores
  `deprecation` and `unchecked`) is not used.
- The dependency-analysis plugin reports at `warn` only. CI runs no lint task.

### KI-19 The build needs `android_jar/android-36.jar` at that path (fixed 2026-11-12)
- **What happened [V]:** commit `8bfc5a8d` moved `android_jar/` to `archive/android_jar/`. Two modules
  compile against the old path (`hiddenapi-stubs/build.gradle.kts`, `vdhost/shared/build.gradle.kts`), so CI
  failed on `754c8258` (run 467). The owner moved the jar back in `ee8e4f91`.
- **Why it happened:** the 2026-11-10 audit wrongly called `android_jar/` "obsolete since 1.1.7". Only the
  *modified* `android.jar` workflow is obsolete (the two `.rar` archives, now in `archive/android_jar/`).
- **Rule:** before moving or deleting a top-level folder, search the Gradle files and scripts for its name.

### KI-20 `display_pip` is read with two different defaults
- **Evidence [V]:** `Keys.DISPLAY_PIP` is read with default `true` in nine places (`CustomElementPrefs`,
  `Launcher`, `LauncherPipStarter`, `WakeDetection`, `ColdStart` …) and with default `false` in
  `settings/SettingsFragmentSecond.java` (two places) and `settings/DrawViewScreen.java`. The preference XML
  declares `true`, and nothing calls `PreferenceManager.setDefaultValues`.
- **Impact:** until the user has changed the switch once, the creator and the settings code can take the PiPs
  for off while the home screen takes them for on. A visible effect has not been reported [U].
- **Source:** CHAT_12 noticed it; re-checked in the code on 2026-11-12.

### KI-23 Translations are machine-written and unreviewed
- **Evidence [V]:** all 59 locale files were filled by one session on 2026-10-26 (60 commits), and every new
  string since is translated by the implementing session (D-10).
- **Impact:** quality in the less common languages is unknown (CHAT_12 names `rm`, `lo-rLA`, `km-rKH`, `am`,
  `zu`, `sw`).
- **Next:** native-speaker review where it matters; no plan is recorded.

### KI-24 Round 12 (G1–G3) had no device result (confirmed 2026-11-12)
- **What:** the workspace-load restart (`e3136f45`), widget colors as view tints (`b1fe254c`) and the overlap
  rule with "Proceed and fit" (`3dd71894`).
- **Result [H]:** the owner, 2026-11-12: "It works as intended."
- **Still unknown:** where the 2026-11-08 15:03 load stopped (KI-28). The new loader log lines are meant to
  show it if it happens again.

## Part B: accepted limitations

| ID | Limitation | Why accepted |
|---|---|---|
| KI-01 | OpenWeather API key hardcoded in public source | owner decision D-26 |
| KI-02 | Public platform signing key committed | owner decision D-02 |
| KI-08 | Very large classes and legacy AOSP TODOs | policy: targeted edits only |
| KI-12 | Reliance on hidden APIs and reflection | inherent to the product |
| KI-13 | Shizuku host limits | inherent to Shizuku |
| KI-14 | `com.syu.media` favorites limits (7870) | owner decision D-14 |
| KI-15 | Pinned PiP limits | platform |
| KI-16 | A standard ("phone") 1.2.1 cannot update itself | documented, one-time |
| KI-18 | Framework warnings in logs | owner decision D-15 |
| KI-27 | Limits of the home-screen guard | stated to the owner, D-28 |
| KI-21 | The stats window on the 7862 while pages scroll | owner: acceptable as it is |

### KI-01 OpenWeather API key hardcoded in public source
- **Where:** `app/src/main/java/com/syu/weather/WeatherManager.java` (`OPEN_WEATHER_APPID`), since 1.1.7.
- **Decision:** the owner keeps it there (D-26): the service is free and anyone can get a key. A move to
  `BuildConfig` was made and reverted at the owner's request.
- **What is done:** the key and exact coordinates never reach the logs (`771f9387`, test `8cc9e48f`).
- **History:** the 2026-11-10 audit listed this as High and recommended rotating the key. That was written
  without knowing the decision and is withdrawn.

### KI-02 Public platform signing key committed
`app/keystore.jks` and `keystore.properties` hold the public `android` defaults (`7d1d9ee8`). The `system`
flavor needs the AOSP test platform key that FYT firmware uses. Anyone can sign an APK that updates the
launcher on such firmware; that is inherent to the platform key.

### KI-08 Very large classes and legacy AOSP TODOs
- **Large classes [V]:** `Launcher.java` (9,471 lines, after the split of D-36), `Workspace.java` (8,558),
  `CellLayout.java` (4,870), `LauncherModel.java` and `MediaFavoriteController.java` (3,814 each),
  `SettingsFragmentSecond.java` (2,598).
- **TODOs:** the 31 `TODO`/`XXX` markers are AOSP Launcher3 leftovers; none is the project's own.
- **Policy:** targeted edits only, and new logic in small tested classes.

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
- Shizuku Next can disconnect and reconnect at boot: its server needs about 9–10 s to start, and its own
  starters race each other. That is in Shizuku Next's code, not the launcher's (CHAT_05) [H].

Source: `README.MD`, `vdhost/README.md`.

### KI-14 `com.syu.media` favorites limits (7870)
- A heart pressed in the widget shows in `com.syu.media`'s own screen only after it reloads its library.
- FM favorites are read-only for other apps (the widget's heart is greyed out).
- The Bluetooth heart stays grey.

### KI-15 Pinned PiP limits
- None on the 7870, where every PiP is a window.
- Google Maps switches to its minimal UI in FYT's pinned PiP unless the LSPosed module is used (D-23).
- If PiP is left on where pinned PiP does not work, Maps pops up on the home page.

### KI-16 A standard ("phone") 1.2.1 cannot update itself
Its updater downloads the system build, which it cannot install. It needs one update by hand. Documented in
`README.MD` and `release-assets.yml`.

### KI-18 Framework warnings
`W Parcel: Expecting binder but got null!` and `E SurfaceSyncer: Failed to find sync for id=0` (Android 13),
and the wallpaper `SecurityException` on Android 16, have no effect. Won't fix (D-15).

### KI-27 Limits of the home-screen guard
Stated to the owner when the guard was finished (CHAT_04) [H]:
- If the user opens, by a button or adb, exactly the app `com.syu.ms` noted, within 3 s of the wake, it is
  sent back once.
- Apps on FYT SystemUI's own autostart list stay in front after a cold start. Moving them to the launcher's
  autostart list avoids that.
- On a phone without privileges nothing is guarded; only the home press at sleep helps.
- Steering-wheel (CAN) buttons and `adb shell am start` are invisible to the launcher: they produce no
  Android input and no button event.

### KI-21 The stats window on the 7862 while pages scroll
- **History [H]:** after `4f94b19` the owner reported the stats window lagging behind the pages on the 7862.
  Two fixes did not help (`1cccf3c`, `998d56f`). A third (`3a0217ea`, direct surface moves through hidden
  Android 10 API) was pushed untested.
- **Outcome [H]:** the owner, 2026-11-12: "It didn't work as it should. Reverted it to acceptable state."
  The revert is `b38f1286`. The behaviour since then is acceptable to the owner.
- **So:** do not retry direct surface moves for it without being asked (D-24).

## Part C: unverified

Nothing here is confirmed. Each item needs a check in the code or on a device before anyone acts on it.

| ID | Item | What is missing |
|---|---|---|
| KI-05 | Android 8–10 through the VD host | never run on a device |
| KI-22 | Two side effects of the pinned-PiP keyboard fix | a check; the fix itself is confirmed |
| KI-25 | Changes with no device confirmation on record | the owner's result for each |
| KI-26 | Code observations from reviews | a re-check in today's code |
| KI-28 | Root causes that were never found | a log of the next occurrence |
| KI-29 | "Changes do not work on the 7870" | the tester's reply |

### KI-05 Android 8–10 through the VD host never run on a device
The path for a non-system launcher on 8.0, 8.1/9 and 10 (module daemon or Shizuku) was written from the
AOSP sources only. The checklist is in `vdhost/README.md` ("Still to test on a device"). Code:
`vdhost/shared/src/main/java/com/syu/vdhost/VdHostCore.java`, `app/src/main/java/com/syu/util/WindowHostVd*`.

### KI-22 Two side effects of the pinned-PiP keyboard fix were not checked
`PinnedPipFocus` (`d9fc21d`, D-44) itself is confirmed: the owner, 2026-11-12, "Works and it is acceptable",
including Back going to the launcher after a launcher touch. Two points CHAT_08 raised were not part of that
answer:
- launcher dialogs with text fields are not covered while the pinned PiP is shown;
- with the accessibility fallback, the reported foreground package may alternate between the PiP app and
  the launcher, which could affect the stats window over apps.

### KI-25 Changes that have no device confirmation on record
The commits exist [V]; the effect on a device was not reported in any source read [U]. The owner may have
tested them since.

| Change | Commit | Source |
|---|---|---|
| Navigation app no longer overwritten | `44833aa0` | CHAT_03 |
| `launcher_home` split and its migration | `36359b61` | CHAT_03 |
| Guard path where `com.syu.ms` really reopens its noted app | `10c9b3b` | CHAT_04 |
| Stats overlay only over a resumed home screen at cold start | `05747c7` | CHAT_04 |
| Splash readiness on Android 11+ (`getAllRootTaskInfos`) | `eed91b73` | CHAT_01 |
| Fuel stats shown for the wrong app when the pinned package is empty | `eed91b73` | CHAT_01 |
| Weather re-check 5 s after a fetch without network | `91ef98b` | CHAT_02 |
| Empty dual pane with a late Shizuku host on Android 16 | `fee2455` | CHAT_05 |
| Regrab of moving pages no longer closes the pinned PiP and the stats | brief 2026-10-27 round | CHAT_10 |
| Icon plate, `ColdStart` disk writes, `ZipCompare` streams, platform-first location | `ee9b303f`, `4ab8ddb3`, `620fd619` | CHAT_11 |
| Screen-number rule, overlap fitting, Spotify browser start | `a2a180c`, `1c32b4d`, `1ace149` | CHAT_12 |
| Date widget fitted to its box | `3eb7798` | CHAT_13 |
| Left bar capacity (9 on the phone, 5 on FYT, no 7 → 5 flash) | `219c47eb` | CHAT_09 |
| Cling removal: no visible change, Back still stops the assistant's speech | `de25567`, `8bddb4c`, `4f6ee7d` | CHAT_07 |

Confirmed by the owner, for contrast [H]: the stock radio overlay on the 7862 (CHAT_06); YT Music likes and
the `com.syu.music` fixes (CHAT_05); the sound-channel work and the fYT Rating timing (CHAT_02); cold start
and wake restore (CHAT_03); the guard in the owner's four scenarios (CHAT_04); rounds 8–11 (CHAT_14,
CHAT_15).

### KI-26 Code observations from reviews that were not followed up
Noted while reading the code, never fixed, and not re-checked since. The code has changed a lot; some may no
longer apply.

- From the 2026-10-05 review (CHAT_01):
  - the per-`Launcher` `bg` executor is never shut down;
  - the first loop in `pickTargetController` lacks a null check;
  - `WindowHostAvReaper` abandons views when the stack query is unavailable;
  - `swapActivityViewSurfaces` blocks the main thread for up to 1000 ms per swap;
  - `CellLayout.onDetachedFromWindow` does not cancel its inner 500 ms `postDelayed`.
- `EvenVerticalLayoutManager.verifyHeightCache()` clears only the in-memory height cache, not the stored
  value, so a stale height could be reloaded once (CHAT_09).
- `Launcher.refreshBtInfo` treats Bluetooth times as seconds while the 7870 sends milliseconds, and
  `btCurTime * 1000` could overflow an `int`. Left alone because the code is shared (CHAT_06).
- Icons or folders bound after the custom elements could land under a widget or PiP (item 3.7 of brief
  2026-11-02). Reading the code suggested it does not happen in the normal bind path; no test (CHAT_13).
- A YouTube ReVanced crash, `desiredWidth must be > 0`, was seen once during a fast pane rebuild. Taken for
  the app's own bug; not investigated (CHAT_02).

### KI-28 Root causes that were never found
Both were mitigated with guards and extra logging [V]; the cause is unknown [U].
- The vertical bar's window appeared on the left on other pages with the bar set to the right (`fc5cac17`;
  logs `Persistent vertical bar frame: …`, `… window is at …`).
- A workspace load after leaving the settings bound nothing for 30 s (`e3136f45`; logs `Loader <id> …`).

### KI-29 "Changes do not work on the 7870" (waiting for the tester)
The planning report quotes the owner saying earlier that changes worked "za wyjątkiem tych z urządzenia
7870" (CHAT_14). The owner, 2026-11-12: the tester did not say which, and a reply is still awaited [H].
Questions the 7870's logs were meant to answer since 2026-10-26, from the session note
`prompts/archive/analysis/memory-2026-10-26-stock-sources-7870.md` and CHAT_06:
- does `com.syu.ms` push the current values when the launcher registers (the first radio or BT display)?
- does `com.syu.media` give up its channel (8 → 0) when it pauses for a pane app?
- Bluetooth times in milliseconds against `Launcher.refreshBtInfo`, which expects seconds (KI-26).
