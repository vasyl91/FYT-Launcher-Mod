# Known issues

As of 2026-11-16 (`a654c0d60`, after round 16), with the owner's answers of 2026-11-12 and 2026-11-15. Sources: the code, git, CI, the
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
| KI-03 | Room and Compose declared but unused | Tech debt | Low | fixed 2026-11-12 |
| KI-04 | Baseline Profile probably stale | Performance | Medium | open |
| KI-06 | No instrumented or UI tests | Missing tests | Medium | open (Robolectric left for a later round, 2026-11-15) |
| KI-07 | Repository footprint | Maintenance | Low | open |
| KI-09 | `README.MD` lagged behind the bar features | Docs | Low | fixed 2026-11-10 |
| KI-10 | Unreleased work: version still 1.2.1 | Release | Medium | open |
| KI-11 | Heavy cold start after a reboot | Performance | Medium | partial |
| KI-17 | Lint is weak in this project | Quality | Low | open |
| KI-19 | The build needs `android_jar/android-36.jar` at that path | Build | High | fixed 2026-11-12 |
| KI-20 | `display_pip` is read with two different defaults | Bug risk | Low | fixed 2026-11-15 |
| KI-23 | Translations are machine-written and unreviewed | Quality | Low | partial: a machine check since 2026-11-15 |
| KI-24 | Round 12 (G1–G3) had no device result | Verification | Medium | fixed 2026-11-12: confirmed by the owner |
| KI-33 | The icon text sizes and the grid can be set only while the user layout is on | Usability | Low | open |

### KI-03 Room and Compose declared but unused
- **Where:** `app/build.gradle.kts` (`room-runtime`, `ksp(room-compiler)`, the Compose BOM, runtime and
  tooling, `buildFeatures.compose = true`, the Kotlin Compose plugin).
- **Evidence [V]:** zero imports of `androidx.room` or `androidx.compose` under `app/src`.
- **Impact:** build time (KSP, the Compose compiler). R8 keeps the effect on APK size small.
- **Owner, 2026-11-12 [H]:** not planned; they may be removed if unused.
- **Fixed 2026-11-12 [V]:** the Room and Compose dependencies, the Compose BOM, the Kotlin Compose plugin
  and `buildFeatures.compose` are removed (`ROADMAP.md` P-12). KSP stays for Glide. AGP 9 has built-in
  Kotlin, so the nine `.kt` files needed no other plugin.

### KI-04 Baseline Profile probably stale
- **Where:** `app/src/main/generated/baselineProfiles/`.
- **Evidence:** since the profile was moved into `src/main` (`97c59837`, 2026-10-15), commits only deleted
  lines for removed classes [V]. The owner planned to regenerate it later (Cling brief, CHAT_07) [H]. Entries
  for classes removed since may remain; they do not break the build [H].
- **Impact:** new code is not compiled ahead of time, so the start is slower.
- **Next:** regenerate on a device before 1.2.2 (P-3, `baselineProfile/README.md` §10).

### KI-06 No instrumented or UI tests
- **What exists [V]:** 110 JVM test files (1011 tests), which cover the plain-Java logic.
- **Not covered:** views, windows, panes, the IPC with FYT apps, and the settings UI. These are verified only
  by the owner and the tester on their devices. `:baselineprofile` holds Macrobenchmark journeys, not tests,
  and CI does not run it.
- **Impact:** UI regressions surface only on a device, one round later. Almost every chat report ends with
  "not tested on a device" (Part C).
- **2026-11-15 [V/H]:** the owner approved Robolectric as a test dependency (round 14). It could not be set
  up in the session: Maven Central redirects one of its files (`nativeruntime-dist-compat`) to a mirror the
  session's network refuses. The owner chose to leave it for a later round. 123 test files, 1083 tests now.

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
- **Fixed 2026-11-15 [V]:** the three reads take `true`, like the others and the XML (`11b5dc244`).

### KI-23 Translations are machine-written and unreviewed
- **Evidence [V]:** all 59 locale files were filled by one session on 2026-10-26 (60 commits), and every new
  string since is translated by the implementing session (D-10).
- **Impact:** quality in the less common languages is unknown (CHAT_12 names `rm`, `lo-rLA`, `km-rKH`, `am`,
  `zu`, `sw`).
- **Since 2026-11-15 [V]:** `StringResourcesTest` checks all 58 translations against the English file:
  well-formed, no key twice, no key the English file lacks, the same format arguments, nothing empty where
  English is not. Its first run found two ADJUST labels without their padding (`km-rKH`, `lo-rLA`;
  `0bd6971f6`). The quality of the language is not something it can tell.
- **Next:** native-speaker review where it matters; no plan is recorded.

### KI-24 Round 12 (G1–G3) had no device result (confirmed 2026-11-12)
- **What:** the workspace-load restart (`e3136f45`), widget colors as view tints (`b1fe254c`) and the overlap
  rule with "Proceed and fit" (`3dd71894`).
- **Result [H]:** the owner, 2026-11-12: "It works as intended."
- **Still unknown:** where the 2026-11-08 15:03 load stopped (KI-28). The new loader log lines are meant to
  show it if it happens again.

### KI-33 The icon text sizes and the grid can be set only while the user layout is on
The two text-size rows moved from the first settings screen to "Home screen layout" on the second one, as
the owner asked (D-56). The second screen can be opened only while "User layout" is on [V], so a user of
the built-in layout can no longer change the sizes; the stored values still apply. Fix, if wanted: show the
category on the first screen while the user layout is off.

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
- **Since 2026-11-15 [V]:** the user can enter an OpenWeather key of their own (Settings, optional); it is
  used instead of the built-in one (`8b76509c4`, `WeatherKey`). The built-in key stays (D-26).

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
- **Mitigation:** the `FytCompat` fuse, the compat reports, and the host protocol versioning. Since
  2026-11-15 `HiddenApiProbe` looks at every start (system flavour, off the main thread) for the hidden
  members the launcher looks up and writes one compat report when one is missing (`590c153ec`); the table
  is short and grows with the lookups.

### KI-13 Shizuku host limits
- Apps with `FLAG_SECURE` (streaming, banking) show black in a pane.
- The panes come up only once Shizuku runs. How long that takes depends on the Shizuku in use; `README.MD`
  recommends Shizuku Next, whose server starts right after a boot on most devices when "Start without
  Wi-Fi" is available and enabled (2026-11-13).
- Shizuku without root must be started again after each reboot.
- Starting Shizuku with root is expected to fail before Android 14, because root owns no package.
- Shizuku Next can disconnect and reconnect at boot: its server needs about 9–10 s to start, and its own
  starters race each other. That is in Shizuku Next's code, not the launcher's (CHAT_05) [H].

Source: `README.MD`, `vdhost/README.md`.

### KI-14 `com.syu.media` favorites limits (7870)
- A heart pressed in the widget shows in `com.syu.media`'s own screen only after it reloads its library.
- FM favorites are read-only for other apps (the widget's heart is greyed out).
- The Bluetooth heart stays grey.
- Looked at again on 2026-11-15 [V]: the decompiled `com.syu.media` has no call another app can make to
  reload its library, so the first point stays.

### KI-15 Pinned PiP limits
- None on the 7870, where every PiP is a window.
- Google Maps switches to its minimal UI in FYT's pinned PiP unless the LSPosed module is used (D-23).
- If PiP is left on where pinned PiP does not work, Maps pops up on the home page.
- Since 2026-11-15 the log says when an app started as pinned comes to the front instead three times in a
  row (`PinnedPipHealth`, `11ea5c5ee`). Nothing is stopped and no notice is shown: there is no log yet from
  a unit where pinned PiP fails to check the rule against.

### KI-16 A standard ("phone") 1.2.1 cannot update itself
Its updater downloads the system build, which it cannot install. It needs one update by hand. Documented in
`README.MD` and `release-assets.yml`.

### KI-18 Framework warnings
`W Parcel: Expecting binder but got null!` and `E SurfaceSyncer: Failed to find sync for id=0` (Android 13),
have no effect. Won't fix (D-15). The wallpaper `SecurityException` on Android 16 that stood here is
handled since 2026-11-13: the wallpaper is read from one source with fallbacks (D-53).

Looked at again on 2026-11-15, when the owner opened Part B: KI-02, KI-13, KI-16, KI-18 and KI-27 cannot be
changed in this code (the platform key is what the system flavour needs; `FLAG_SECURE` and Shizuku's start
belong to Shizuku and the system; the released 1.2.1 cannot be changed; the warnings come from the
framework; the guard cannot see what produces no Android input). KI-08 stays a policy (D-36).

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
- **Fourth attempt, 2026-11-15 [V/H]:** the owner opened it again for round 14. `5392230c2` drew a picture of
  the window in its page while the pages moved (`Bitmap.createBitmap(Picture)`) and made the window
  invisible. On the 7862 the window and every FAB then vanished while the pages moved; the owner asked for it
  to be undone, and `fe72e5a6f` reverted it. The accepted state holds again. A picture made with
  `Bitmap.createBitmap(Picture)` is not to be used for windows of the launcher again.

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
| KI-30 | Round 13 (the 19 tasks) has no device result | closed 2026-11-15: the owner's result is recorded |
| KI-31 | StrictMode reports in the owner's log of 2026-11-09 | one place fixed, three described (2026-11-15) |
| KI-32 | fYT Rating answers without a rating until its screen was opened | closed 2026-11-15: the owner, "works" |
| KI-34 | Round 14 has no device result | partly: the owner tested it on 2026-11-15; three items wait |
| KI-35 | The bar's music buttons stop responding after an app | works on the phone; the FYT unit with `com.syu.music` untested |
| KI-36 | Round 15 has no device result | the owner's test of each item |
| KI-37 | A widget lay over icons after a change of the grid | a log with the new `Items sharing cells` line |
| KI-38 | Round 16 has no device result | the owner's test of each item |
| KI-39 | An item of a page lay partly under the navigation bar (round 20) | the owner's test; a log with `Item out of place` or `lay outside the page` |

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

Re-checked on 2026-11-15: three are fixed (`edfa41596` the executor, `367cbc607` the null check,
`bce7ad204` the stored height), the `CellLayout` one no longer applies (`onDetachedFromWindow` removes its
placement runnable today) [V]; the two of the 7862's panes and `refreshBtInfo` are left as described, not
changed blind.

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
- ~~The vertical bar's window appeared on the left on other pages with the bar set to the right.~~
  **Cause found 2026-11-13** [V]: the window's place was counted from the pager's own left edge, and the
  pager is measured far wider than the screen and centred (on the 1080 px phone its edge is at −4520, which
  the owner's log shows as `box -4520,89,-3440,2205`). Fixed in `1d5a87aa9` (`PageBox.pageRestLeft`); the
  owner confirmed it on 2026-11-15 [H]. The owner also reported the bar on the right with the setting
  "left"; the cause found does not explain that case [U].
- A workspace load after leaving the settings bound nothing for 30 s (`e3136f45`; logs `Loader <id> …`).
  Mitigated with a guard and logging [V]; the cause is unknown [U].

### KI-29 "Changes do not work on the 7870" (waiting for the tester)
The planning report quotes the owner saying earlier that changes worked "za wyjątkiem tych z urządzenia
7870" (CHAT_14). The owner, 2026-11-12: the tester did not say which, and a reply is still awaited [H].
Questions the 7870's logs were meant to answer since 2026-10-26, from the session note
`prompts/archive/analysis/memory-2026-10-26-stock-sources-7870.md` and CHAT_06:
- does `com.syu.ms` push the current values when the launcher registers (the first radio or BT display)?
- does `com.syu.media` give up its channel (8 → 0) when it pauses for a pane app?
- Bluetooth times in milliseconds against `Launcher.refreshBtInfo`, which expects seconds (KI-26).

### KI-30 Round 13 (the 19 tasks) had no device result (closed 2026-11-15)
**The owner's result, 2026-11-15 [H]:** tasks 1, 3, 5, 7, 8, 9, 12, 13, 14, 15, 16 and 19 work; 6 was seen
in a debug build only; 2, 4, 10/16, 11, 17 and 18 needed fixes, which round 14 made (KI-34). The text below
is kept as it was.

Commits `4e73d1178` … `ca27a7637` (2026-11-12/13) were built and unit-tested (1011 tests, CI green) and
never run on a device [V]. What each needs is listed in `reports/implementation_report_2026-11-13.md`. The
ones most worth a look first:
- the grid (D-52): the first start after the update re-numbers the cells of the items on a page with a bar
  at the left or the top and moves the items that lay under a bar; then dragging, the overview, the creator's
  elements beside icons, both orientations, the 7862;
- the bar windows on their side on every page (KI-28) and the title scrolling on the other pages;
- the stats window gone over another launcher and after a wake; its look after the migration;
- the colour and background choices after an update with old values stored;
- the wallpaper on Android 10 (system), 14 (root, needs the module built from this version) and 16 (Shizuku);
- the ADJUST / Restart button text and the wrapped titles at several font sizes.

### KI-31 StrictMode reports in the owner's log of 2026-11-09
Seen in the A55 log supplied for round 13 [H], not looked at in the code, not fixed (outside the tasks):
disk reads on the main thread from `VdHostProtocol$Proxy.startActivity` (three, about 169 ms),
`WindowHostVdShizuku.maybeBind`, `LauncherAppWidgetHostView.onLayout`, and the toast at
`FytRating.handlePreferenceClick`. The project rule is that StrictMode stays silent (D-07).

**2026-11-15 [V]:** `WindowHostVdShizuku.maybeBind` is off the main thread (`0905bff8f`). The other three
are described, not changed: `VdHostProtocol$Proxy.startActivity` is the start of a pane, which would need
the way panes start rebuilt; the reads under `LauncherAppWidgetHostView.onLayout` and the toast happen
inside the framework (the stack runs through Samsung's code).

### KI-32 fYT Rating answers without a rating until its screen was opened
In the same log the bridge answers the ping (signed in, launcher allowed) and five rating requests within a
second each, all without a rating; after its screen was opened once, ratings come [H]. Why is inside the
fYT Rating app, whose source is not here [U]. Since `7242003c8` the launcher logs the bridge's reason and
starts its wake activity once for this case; whether that is enough is not known. If not, the fix belongs in
fYT Rating (getting its token on the receiver's path). **Closed 2026-11-15:** the owner, "works" [H].

### KI-34 Round 14 has no device result
Commits `6fbd5605b` … `c7ed19880` (2026-11-15) build and pass the unit tests (1083), CI green up to run 491
[V]; none has run on a device. `reports/implementation_report_2026-11-15.md` lists what each needs. The ones
that change what the 7862 shows: the bars while the pages move and in the overview (`476013cf4`,
`1ca81e616`), the cells' centring (`4e983e0f5`), the play/pause symbol (`605c2818d`), the night mode
without a saved picture (`44ed8f4cb`), and the revert of the stats picture (`fe72e5a6f`).

**The owner's result, 2026-11-15 (A55) [H]:** everything works except: an item could not be put under
the statistics window, a change of the columns put the Shizuku widget over three icons, the floating
buttons lay under the bars on the pages after the first, and the wallpaper was still not read with
Shizuku (all four in round 15, KI-36). Still to watch: the bar's buttons on the FYT unit (KI-35), the
media fixes (never seen by the owner), the statistics' alpha (too short a test). **The owner, 2026-11-16 17:26
[H]:** after a start the statistics window still lacked its full alpha with Shizuku. The log shows the window
added under 0.8 before the host was there and laid out once, 30 ms after the raise through `cmd`; the window
manager keeps its own copy of the limit and takes the setting up later [A]. `StatsOverlayAlpha` now lays the
window out again at 0.3, 1, 3 and 10 s after the raise and with every look of the minute while the window cut in
that showing is shown (round 21, log `laid out again (n/4) …`). Not tested on a device.

### KI-35 The bar's music buttons stop responding after an app
The owner, 2026-11-15 [H]: after opening any app and coming back, the buttons of the music widget on the
horizontal bar stop responding; the home screen's widget works. The owner's log (17:28:29) has no trace of
the taps: nothing logged the bar's buttons or the gestures the pages take from the bar's window [V]. The
buttons of both bars are bound when each is built, and the widget's views are given back to the page's bar
after every park [V], so the binding is not the cause. `45c6cc18b` closes two ways a touch could be lost (a
touchability change asked for before the window's first frame was dropped; a swipe fed from a bar's window
stayed in progress across a pause) and logs every tap and every gesture the pages take from the bar. The
cause is unknown [U]; the next log with `play/pause tap on the …` or `BarSwipeFrame:` lines shows it.
**2026-11-15 [H]:** works on the phone after `45c6cc18b`; the FYT unit with `com.syu.music`, where it was
seen, is not tested yet.

### KI-36 Round 15 has no device result
Commits `45673d58a` … `932d61d1c` (2026-11-15/16) build and pass the unit tests, CI green [V]; none has
run on a device. What to look at: an icon and a widget dropped under the statistics window; several
changes of the columns and rows with widgets on the pages; the floating buttons (the launcher's and
another app's) over both bars on the pages after the first, the bars while the pages move, the overview
and auto-hide, on the 7862 and the A55 (the bars' windows are panels of the launcher's window now,
`BarWindows`); the launcher's start on the A55 without "access to all files" (granted through Shizuku,
log `Permission flow: ALL_FILES`), then the background selectors. The root daemon allows all-files access
only once the module is built from this version.

### KI-37 A widget lay over icons after a change of the grid
The owner, 2026-11-15 [H]: after a change of the columns the Shizuku widget lay over the icons of Allegro,
Apk info and Assistant. The re-arrangement is not the cause: `GridOverflowPropertyTest` tries 3000 random
home screens without an overlap [V], and the loader refuses overlapping rows. The way it happens is not
known [U]; the owner's logs name neither the widget's cells nor the icons'. Since `e0564df9a` every page
moves an item that shares a cell with another (`CellOverlap`: icons stay, the widget moves) and logs
`Items sharing cells on page …` with both, which should show the cause the next time.

### KI-39 An item of a page lay partly under the navigation bar
The owner, 2026-11-16 16:15 [H], A55: after a reorganisation of a page a music widget lay half under the navigation
bar (screenshot, no log). The page itself stops above the system bars (`PagedView` takes their insets off) and its
cells fit it [V], so the item had a cell reaching past the grid or was an element of the creator with pixels past
the page. Which of the ways below it took is not known [U]. Round 20 closes the ways found in the code
(`91db3326a`: stale temporary cells; `efe1e4fe9`: the padding of the first rows; `dabe84886`: the drop's page,
the size of an added widget; `69b495780`: the creator's elements kept in the page, the box remembered per
orientation instead of the screen without the status bar) and adds the check of every page after every drag and
resize (`36cf3e7c3`, `PageFit`). Each correction logs one line: `Item out of place on page …`, `Custom element …
lay outside the page …` or `Added partly outside the grid …`; the line after a next case names its way.
Not done: a system bar at the side of the screen (landscape on a phone with buttons) is not taken off the pages'
width (`PagedView` takes only the top and the bottom insets) [U whether the A55 has one there].
Not tested on a device.

### KI-38 Round 16 has no device result
Commits `e6349acf0` … `a654c0d60` (2026-11-16) build and pass the unit tests, CI green for the first [V];
none has run on a device. What they change and what to look at:
- a widget dropped where it does not fit stays where it was (`DropSpan`): after a change of the grid a
  widget's minimum was larger than its own size, the search answered 0,0 0x0 and the reorder was committed,
  which put the widget in the corner under a pane;
- icons dropped from the list of apps survive a reload (`ItemValidity`: found as the list finds them, icons of
  apps that renamed their first activity mended); each icon still hidden is logged with its reason. **The
  owner, 2026-11-16 09:11 [H]: icons still disappeared** - the log gave "the app is disabled" for
  Authenticator, Alior, Anki, Booksy and Bolt, which the list of apps shows: `ItemValidity` looked at
  `applicationInfo.enabled` before asking whether the activity starts. `4929e3da8` lets only what the system
  starts decide and logs the system's facts for each icon still hidden; why the A55 reports these apps as
  disabled is [U];
- the widget preview crashed the launcher at every start while Allegro's widget was on a page (its layout
  parameters were not FrameLayout's); fixed in `f860da64d`;
- the owner, 2026-11-16 [H]: icons work after `4929e3da8`. On the 7862 both bars were doubled for a moment at
  the start of each swipe: the page's bar was hidden through a post after the window's draw, ~900 ms late on
  a busy main thread, and not at all under a window built at that moment; `88bacd560` hides it in the
  window's own frame (log `… hidden under its window after N ms`). **The owner, 2026-11-16 10:12 [H]:
  nothing changed** - the log shows 118/127 ms and 64/57 ms: any swap of the two windows during a move costs
  a frame, and the 7862's frames in a move are that long. Round 19 (`dffdd806b`, `074c09350`, `33edcda65`,
  D-67) removes the swap: the bar on every page is its window on every page, the first one too, built with
  the page, kept while an app is in front, over the PiP panes; nothing changes while the pages move. Not yet
  on a device: swipes at once after a start and after a return from an app, the bar's buttons after a
  return, the overview, a drag, a folder, all apps, and the panes passing under the vertical bar. On the
  A55 (2026-11-16 [H]) it works so far; the bar after the overview (`d939d294a`), the vertical bar growing
  into the corner while the pages move (`5199b1798`) and its picture in the overview at the whole height are
  fixed after the owner's reports;
- a widget whose content fails shows its preview and opens its app on a tap; APPWIDGET_UPDATE is sent where
  the launcher may (system, root host). On the A55 with Shizuku through ADB only the preview helps: Allegro's
  widget comes back when Allegro updates it, or after the launcher is no longer reinstalled.

