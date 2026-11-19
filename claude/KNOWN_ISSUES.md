# Known issues

As of 2026-11-19 (`testBranch` after round 22, `62fc51126` … `5a6272396`, and `16f256ee8` after the owner's test). One list of what is open today,
rewritten on 2026-11-18 at the owner's request. What was fixed or closed has been taken out; it stays in git
and in the reports (`reports/`, `chat_archive/`). Sources: the code, git, CI, the briefs, the chat reports and
the owner's results.

**Kind:** *problem* (the code, git or CI shows it) · *limit* (known, and decided or inherent: do not "fix" it
without asking) · *unverified* (a report or a code reading suggests it, or a change was never confirmed on a
device: check before acting on it).
**Status:** open · partial · watching (a fix is in, the owner's result is awaited) · accepted.

Add a new issue at the end with the next number. Numbers are never reused; a closed issue is removed from this
file and named in the round's report.

| ID | Issue | Kind | Status | What is awaited |
|---|---|---|---|---|
| KI-01 | OpenWeather API key hardcoded in public source | limit | accepted (D-26) | — |
| KI-02 | Public platform signing key committed | limit | accepted (D-02) | — |
| KI-04 | Baseline Profile probably stale | problem | open | the owner regenerates it on a device |
| KI-05 | Android 8–10 through the VD host never run on a device | unverified | open | one device each: 8.0, 8.1/9, 10 |
| KI-06 | Few tests of views | problem | partial (Robolectric since 2026-11-18, D-68) | more view tests with each change |
| KI-07 | Repository footprint | problem | open | the owner's call (R-5) |
| KI-08 | Very large classes and legacy AOSP TODOs | limit | accepted (policy) | — |
| KI-10 | Unreleased work: version still 1.2.1 | problem | open | the owner's release |
| KI-11 | Heavy cold start after a reboot | problem | partial | profiling on a device |
| KI-12 | Reliance on hidden APIs and reflection | limit | accepted | — |
| KI-13 | Shizuku host limits | limit | accepted | — |
| KI-14 | `com.syu.media` favorites limits (7870) | limit | accepted (D-14) | — |
| KI-15 | Pinned PiP limits | limit | accepted | a log from a unit where it fails |
| KI-16 | A standard ("phone") 1.2.1 cannot update itself | limit | accepted | — |
| KI-17 | Lint is weak in this project | problem | open | — |
| KI-18 | Framework warnings in logs | limit | accepted (D-15) | — |
| KI-21 | The stats window on the 7862 while pages scroll | limit | accepted, see round 22 | the owner's look after round 22 |
| KI-22 | Two side effects of the pinned-PiP keyboard fix | unverified | open | a check on the 7862 |
| KI-23 | Translations are machine-written and unreviewed | problem | partial (a machine check) | native speakers |
| KI-25 | Older changes with no device confirmation on record | unverified | open | the owner's result for each |
| KI-26 | Code observations from reviews | unverified | partial | a re-check of the four left |
| KI-27 | Limits of the home-screen guard | limit | accepted (D-28) | — |
| KI-28 | A workspace load that bound nothing for 30 s | unverified | watching | a log of the next case |
| KI-29 | "Changes do not work on the 7870" | unverified | open | the tester's reply |
| KI-31 | StrictMode reports inside the framework (A55 log of 2026-11-09) | problem | partial | — |
| KI-33 | Some settings of the home screen only with the user layout on | problem | open | the owner's choice |
| KI-34 | The statistics window's full alpha with Shizuku | unverified | watching | the owner's test of rounds 21 and 22 |
| KI-36 | Rounds 15–16 without a full device result | unverified | watching | the owner's test of each item |
| KI-37 | A widget lay over icons after a change of the grid | unverified | watching | a log with `Items sharing cells` |
| KI-38 | The bars on every page on the 7862 after round 19 | unverified | watching | the owner's test on the 7862 |
| KI-40 | Round 22: the jump of the second settings screen scrolled up after a return | unverified | watching | the owner's test of `16f256ee8` |

## Problems

### KI-04 Baseline Profile probably stale
`app/src/main/generated/baselineProfiles/` has only lost lines for removed classes since `97c59837`
(2026-10-15) [V]. New code is not compiled ahead of time, so the start is slower. Regenerate it on a device
before 1.2.2 (P-3, `baselineProfile/README.md` §10).

### KI-06 Few tests of views
- JVM tests cover the plain-Java logic. Since 2026-11-18 Robolectric runs tests of views beside them (D-68):
  the settings screens, the guides' insets, the bar's sizes and the vertical bar's width, the scroll memory and
  the icon sliders of the settings.
- **Not covered:** the windows (bars, panes, statistics), the IPC with FYT apps, the VD host. Those are seen
  only on the owner's and the tester's devices. `:baselineprofile` holds journeys, not tests, and CI does not
  run it.

### KI-07 Repository footprint
`.git` is about 560 MB; `archive/` (about 300 MB of decompiled reference code) and `images/` (176 MB) are in
the tree [V]. `archive/` is reference material: do not delete it. R-5 is the owner's call.

### KI-10 Unreleased work
`versionName = "1.2.1"` [V]; `testBranch` is hundreds of commits past `v1.2.1` and far ahead of `main`. Users of
the built-in updater get none of it until a release (P-2).

### KI-11 Heavy cold start after a reboot
Measured [H]: plan → `finishBindingItems` 3.2 s (Samsung), 9.3 s (Xiaomi); on the 7862 about 6.6 s after a
force-stop; panes ready 6–7 s after a cold start. This ROM blocks calls into `system_server` for about ten
seconds at boot (`ColdStart`). `69aac3b1` moved the widget list and class verification off the critical path.
Next: profiling on a device (P-8).

### KI-17 Lint is weak in this project
`lint.checkReleaseBuilds = false`; `lintConfig` is commented out, so `app/lint.xml` is not used; the
dependency-analysis plugin only warns; CI runs no lint task. Not in scope since round 14 (D-62).

### KI-23 Translations are machine-written and unreviewed
Every string of the 58 translations was written by a session (D-10). `StringResourcesTest` checks them
against the English file (well-formed, no key twice or missing in English, the same format arguments, nothing
empty) [V]; the quality of the language it cannot tell (`rm`, `lo-rLA`, `km-rKH`, `am`, `zu`, `sw` most at
risk). No review is planned.

### KI-31 StrictMode reports inside the framework
From the A55 log of 2026-11-09 [H]: `WindowHostVdShizuku.maybeBind` is fixed (`0905bff8f`). Left as described
[V]: `VdHostProtocol$Proxy.startActivity` (the start of a pane; it would need the way panes start rebuilt), and
the reads under `LauncherAppWidgetHostView.onLayout` and in a toast, both inside Samsung's framework code.

### KI-33 Some settings of the home screen only with the user layout on
The second settings screen opens only with "User layout" on [V]. Its "Home screen layout" holds the grid, the
icon text sizes (D-56) and, since 2026-11-18, "Transparent status bar" (D-72): with the built-in layout they
cannot be changed, though their stored values still apply. A fix, if wanted: show that category on the first
screen while the user layout is off.

## Limits

### KI-01 OpenWeather API key hardcoded in public source
`WeatherManager.OPEN_WEATHER_APPID`, kept by the owner (D-26). The key and exact coordinates never reach the
logs. Since 2026-11-15 a key of one's own can be entered in the settings and is used instead (`WeatherKey`).

### KI-02 Public platform signing key committed
`app/keystore.jks` and `keystore.properties` hold the public `android` defaults. The `system` flavor needs the
AOSP test platform key FYT firmware uses; anyone can sign an APK that updates the launcher there.

### KI-08 Very large classes and legacy AOSP TODOs
`Launcher.java`, `Workspace.java`, `CellLayout.java`, `LauncherModel.java`, `MediaFavoriteController.java` and
`SettingsFragmentSecond.java` are thousands of lines each; the `TODO`/`XXX` markers are AOSP leftovers.
Targeted edits only; new logic in small tested classes (D-36).

### KI-12 Reliance on hidden APIs and reflection
ActivityView members, `IActivityManager`/`IActivityTaskManager`, the hidden input monitor, `TaskStackListener`,
the decompiled FYT IPC, and since 2026-11-18 the hidden window type of the bars on every page (the layer above
sub-panels, with fallbacks: `BarWindows`). A new Android version or ROM can break a feature silently. The
`FytCompat` fuse, the compat reports and `HiddenApiProbe` (one report when a member is missing) soften it.

### KI-13 Shizuku host limits
Apps with `FLAG_SECURE` show black in a pane; the panes come up only once Shizuku runs; Shizuku without root must
be started again after each reboot, and with root it fails before Android 14; Shizuku Next may disconnect and
reconnect at boot (its own code, CHAT_05). Source: `README.MD`, `vdhost/README.md`.

### KI-14 `com.syu.media` favorites limits (7870)
A heart pressed in the widget shows in `com.syu.media` only after it reloads its library (it has no call to
make it reload, checked 2026-11-15); FM favorites are read-only; the Bluetooth heart stays grey.

### KI-15 Pinned PiP limits
Google Maps switches to its minimal UI in FYT's pinned PiP unless the LSPosed module is used (D-23). Where pinned
PiP does not work, Maps pops up on the home page; since 2026-11-15 the log says so after three times in a row
(`PinnedPipHealth`), and nothing is stopped.

### KI-16 A standard ("phone") 1.2.1 cannot update itself
Its updater downloads the system build. One update by hand; documented in `README.MD`.

### KI-18 Framework warnings
`W Parcel: Expecting binder but got null!` and `E SurfaceSyncer: Failed to find sync for id=0` (Android 13)
have no effect (D-15).

### KI-21 The stats window on the 7862 while pages scroll
Three fixes in 2026-11 did not help; direct surface moves (`3a0217ea`) were reverted as worse (`b38f1286`, D-24),
and a picture of the window (`5392230c2`) made the window and the floating buttons vanish (reverted,
`fe72e5a6f`). Not to be retried that way. Since round 22 the window on the home screen is a sub-window of the
launcher's window under the bars (D-69); how it moves on the 7862 now is not known [U].

### KI-27 Limits of the home-screen guard
An app `com.syu.ms` noted and the user opens within 3 s of the wake is sent back once; apps on FYT SystemUI's
autostart list stay in front after a cold start; nothing is guarded on a phone without privileges; steering-wheel
buttons and `adb shell am start` produce no input the launcher can see.

## Unverified

### KI-05 Android 8–10 through the VD host never run on a device
Written from the AOSP sources only. Checklist in `vdhost/README.md` ("Still to test on a device").

### KI-22 Two side effects of the pinned-PiP keyboard fix
`PinnedPipFocus` is confirmed (D-44). Not checked: launcher dialogs with text fields while the pinned PiP is shown;
with the accessibility fallback, the foreground package may alternate between the PiP app and the launcher.

### KI-25 Older changes with no device confirmation on record
The commits exist [V]; no result was reported [U]: the navigation app no longer overwritten (`44833aa0`), the
`launcher_home` split (`36359b61`), the guard where `com.syu.ms` really reopens its app (`10c9b3b`), the stats
overlay at cold start (`05747c7`), splash readiness on Android 11+ and the empty pinned package (`eed91b73`),
the weather re-check without network (`91ef98b`), the empty dual pane with a late Shizuku host (`fee2455`), the
regrab of moving pages, the icon plate and disk writes (`ee9b303f`, `4ab8ddb3`, `620fd619`), screen numbers,
overlap fitting and the Spotify start (`a2a180c`, `1c32b4d`, `1ace149`), the date widget (`3eb7798`), the left
bar capacity (`219c47eb`), the Cling removal (`de25567`, `8bddb4c`, `4f6ee7d`).

### KI-26 Code observations from reviews
Left after the re-check of 2026-11-15 [V]: `WindowHostAvReaper` abandons views when the stack query is
unavailable, and `swapActivityViewSurfaces` blocks the main thread up to 1000 ms per swap (the 7862's panes: not
changed blind); `Launcher.refreshBtInfo` takes the 7870's Bluetooth milliseconds for seconds (waits for KI-29);
a YouTube ReVanced crash during a fast pane rebuild, taken for the app's own bug.

### KI-28 A workspace load that bound nothing for 30 s
After leaving the settings (`e3136f45`, logs `Loader <id> …`): mitigated with a guard and logging [V], cause
unknown [U]. The owner's report of the vertical bar on the right with the setting "left" is not explained by the
cause fixed on 2026-11-13 [U].

### KI-29 "Changes do not work on the 7870"
The tester did not say which (2026-11-12) [H]. Open questions for the 7870's logs: does `com.syu.ms` push the
current values when the launcher registers; does `com.syu.media` give up its channel when it pauses for a pane
app; Bluetooth times in milliseconds (KI-26).

### KI-34 The statistics window's full alpha with Shizuku
The owner, 2026-11-16 17:26 [H]: after a start the window lacked its full alpha on the A55. Round 21
(`ef3d1c746`) lays it out again 0.3, 1, 3 and 10 s after the limit reaches 1, and with every check of the minute.
Round 22 (`cbd7c10cf`) makes the window on the home screen a sub-window of the launcher's window, which the
system's limit for overlays does not touch; over an app it stays an overlay and the series applies. Not tested
on a device.

### KI-36 Rounds 15–16 without a full device result
Rounds 15 and 16 build and pass the tests [V]. The owner confirmed the icons (round 17) and nothing contradicting
the rest [H], but not each item: an icon and a widget under the statistics window (D-65); the overlap guard after
loads; the floating buttons over the bars (D-64); access to all files asked through Shizuku at the start (the
owner confirmed the wallpaper with the access given by hand); a widget dropped where it does not fit
(`DropSpan`); the widget preview and the update sent where the launcher may (D-66).

### KI-37 A widget lay over icons after a change of the grid
The owner, 2026-11-15 [H]. `GridOverflowPropertyTest` finds no overlap in 3000 random screens [V]; the way it
happened is unknown [U]. Since `e0564df9a` a page moves an item that shares a cell (`CellOverlap`) and logs
`Items sharing cells on page …` with both.

### KI-38 The bars on every page on the 7862 after round 19
Round 19 (D-67) made a bar on every page its window on every page, so nothing is swapped while the pages move;
19b and 19c fixed what the owner saw on the A55, and the owner confirmed them there [H]. The owner's log of the
7862 (2026-11-16 18:42) reported the statistics window and the music buttons, not the doubled bars, but no result
of the swipes on the 7862 is on record [U]: swipes at once after a start and after a return from an app, the
overview, a drag, a folder, all apps, the panes passing under the vertical bar.

### KI-40 Round 22: the jump of the second settings screen scrolled up after a return
**The owner, 2026-11-19 on the 7862 [H]:** every fix of round 22 works (`62fc51126` … `5a6272396`: the statistics
under the bars, the bar's music buttons, title and artist, which closes KI-35, the vertical bar's width, the
number of icons, the settings list's place, the guides, the moved switch, the bar's title and artist, the
statistics in landscape), except one: the second screen of the settings jumped while it was scrolled up after a
return, e.g. from the Canbus guide. The log of 09:40 shows only the screens' changes.

**Cause [V]:** the rows of the PiPs, the dual PiP, the widgets and the restart buttons sized their buttons one post
after they were bound. Back at its remembered place, the screen lay below rows never bound; scrolling up, each came
in at the top and grew a frame later, pushing the list down. `16f256ee8` sizes them when they are bound
(`SettingsRowSizing`); `SettingsRowHeightViewTest` goes the owner's way and fails without it. Not tested on a
device.

Still to look at from round 22 (no report against them): the type of the bars' windows the system took
(`BarWindows` in the log), the statistics' alpha with Shizuku (KI-34), the vertical bar's room in the settings
against the launcher's, which may differ by one.
