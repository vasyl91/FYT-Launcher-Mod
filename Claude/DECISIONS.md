# Decisions

Important technical and product decisions, newest knowledge as of 2026-11-10.

- **[H]** means the owner or a brief stated it.
- **[V]** means the code or a commit shows it, but the reason is inferred, not stated.
- Where no reason was recorded, the entry says "reason not recorded". Do not invent one.

Archived briefs live in `prompts/archive/`. A decision there that is not listed here is still history: when
you find one, add it.

Add new entries at the end with the next number. When a decision is replaced, set its status to "superseded
by D-nn"; never delete an entry.

---

### D-01 Two flavors from one codebase: `system` and `standard`
- **Decision:** `system` declares `sharedUserId="android.uid.system"` (uid 1000); `standard` is a normal app.
  Only the manifests differ. `standard` was called "phone" until `192fea4c` (2026-10-17), and `system` was
  called `fyt` until `e2086527` (2026-11-05).
- **Context:** Android installs a uid-1000 app only where the firmware's platform key signed it. FYT firmware
  uses the public AOSP test key, and some units and custom ROMs do not.
- **Consequences:**
  - Both APKs are the same package, so switching between them needs an uninstall that wipes the data.
  - Every privileged feature must degrade without privileges.
- **Status:** active. **Source:** `app/build.gradle.kts`, `README.MD` [V][H].

### D-02 Signed with the public AOSP test key, committed to the repository
- **Decision:** `app/keystore.jks` (alias and password `android`) and `keystore.properties` are committed
  (`7d1d9ee8`, "Public android keystore", 2026-08-27).
- **Reasoning:** the `system` flavor must carry the firmware's platform key, which is the public AOSP test
  key [H] (README). Making it public lets anyone build an installable APK.
- **Consequences:** anyone can sign an APK that installs over the launcher on such firmware. This is
  inherent to the platform key, not a leak. See `KNOWN_ISSUES.md` KI-02.
- **Status:** active.

### D-03 Platform by chipset, media by package; pinned PiP everywhere on FYT except the 7870
- **Decision (owner):**
  - The FYT platform comes from the chipset, once, and is remembered (`DeviceIdentity`, `FytPlatform`). The
    main source is `ro.fyt.platform` (6318 = 7870, 6315 = 7862, 6316 = 8581, 6521 = 9853i).
  - The following are decided **by chipset**: being FYT, pinned PiP, the 7870's minimum night brightness,
    and the device line in the settings.
  - Everything about music sources stays **by package** (`StockSources.isSyuMediaUnit()`, `com.syu.music`
    installed).
  - Pinned PiP is unavailable only on the 7870 and on non-FYT devices (`84d8a3ed`, `681b5c74`).
- **Alternatives rejected:** the owner's `CompleteFytDetector` draft. It checked the chipset before the FYT
  markers, so Teyes CC3 and T618 tablets would have been taken for a 7862. It also used `toLowerCase()`
  without `Locale.ROOT`, its own reflection, unconfirmed properties (`ro.fyt.version`, `ro.syu.version`) and
  Polish names in code.
- **Also:** the Android version comes from `SDK_INT`, never from `RELEASE`, because the 7862's UI and
  build.prop can be faked to show 13/14.
- **Supersedes:** E3 of brief 2026-10-27 (pinned PiP "only with `com.syu.music`").
- **Source:** `prompts/archive/sonnet-prompt-2026-10-28-device-identity.md` [H].

### D-04 PiP panes through own virtual displays and a VD host, not by patching the system
- **Decision:**
  - Android 8–10 as a system app: the framework's hidden ActivityView.
  - Otherwise: the launcher's own VirtualDisplays rendered into SurfaceViews, created by a VD host with
    signature permissions. The hosts, in order: the launcher itself as uid 1000, the FYT VDHost Magisk daemon
    (uid 1000), or Shizuku (uid 2000).
- **Context:** Android 12 removed `reparentDisplayContent` and ActivityView. Android 11's version lacks what
  the launcher uses.
- **Alternatives rejected:** patching `system_server` or using LSPosed ("No system_server patching and no
  LSPosed are involved").
- **Consequences:**
  - Shizuku cannot show `FLAG_SECURE` content.
  - Panes need a host; a pane without one stays empty instead of crashing.
  - The host protocol is versioned (now 3, minimum 2).
- **Status:** active. **Source:** `vdhost/README.md` [V][H].

### D-05 What the standard flavor does not get through the host, on purpose
- **Decision:** the host grants the overlay, notification access, unknown-apps install and WRITE_SETTINGS
  permissions. It does **not** do the following:
  - the status-bar swipe area (it needs a system window type in the launcher's own process);
  - the input monitor (it would need a monitor in the host and event forwarding);
  - FYT skins in the standard flavor (possible without permissions but risky for AppCompat inflation;
    **needs its own brief**);
  - the host-side Spotify and foreground-task checks (little to gain).
- **Source:** `prompts/archive/sonnet-prompt-2026-11-05-media-system-canbus7870.md` C9, `README.MD` [H].

### D-06 Logcat captures: build-type defaults, never forced
- **Decision:**
  - Logcat settings are off by default in release and on in debug, and changeable in both (`2b70e8f4`).
  - Forcing every capture on in debug builds (`66961f21`) was **reverted by the owner** (`735e308b`).
  - File names say what started the capture and what it holds (`reboot_full_…`, `d5d6cb73`).
- **Source:** `prompts/archive/sonnet-prompt-2026-10-27-pinned-logcat.md` [H].

### D-07 StrictMode in release builds too
- **Decision:** StrictMode runs in release, and its lines go into the launcher's own captures (`5bb6e2d7`).
  The main thread may do no I/O, database, `ContentResolver`, network, `su` or blocking host calls. This rule
  is repeated in every brief since.
- **Source:** the pinned-logcat brief; `CLAUDE.md` [H].

### D-08 The launcher handles `uiMode` itself; panes survive a recreation
- **Decision:**
  - The launcher declares `uiMode`, so a change of the lights or the night mode does not recreate it
    (`2148c52c`).
  - If it is recreated anyway (e.g. by the theme overlay Android 12+ builds after a new wallpaper), the
    panes' displays are handed over to the new activity (`502464e7`).
  - The wallpaper is set only when it really changed.
  - The launcher's night mode changes the wallpaper and brightness, **not** the system dark mode.
- **Deferred:** pinning day/night mode to the PiP displays (`ROADMAP.md`).
- **Source:** briefs 2026-10-27 and 2026-11-05, `README.MD` [H].

### D-09 Preference keys keep their stored values across renames
- **Decision:** when the bars were renamed (bottom → horizontal, left → vertical; `d0e67aaf`), the constants
  changed but the stored values did not (e.g. `HORIZONTAL_BAR_EVERY_PAGE = "bottom_bar_every_page"`).
  Users' settings are not migrated unless a brief says so.
- **Source:** commit `d0e67aaf`, `app/src/main/java/com/android/launcher66/settings/Keys.java` [V].

### D-10 Strings in all 59 languages
- **Decision:** every new or changed string goes into all 59 `values*/strings.xml` files, translated
  (brief 2026-11-07 onwards). Before that, new keys went into English only (brief 2026-10-28). The
  translations were completed in one pass on 2026-10-26.
- **Source:** briefs [H], `git log` 2026-10-26 [V].

### D-11 FYT firmware code fails soft
- **Decision:** code written against FYT firmware (the `com.syu.ms` callbacks, CAN modules, radio and music
  sources) runs behind `FytCompat`. A `RuntimeException`/`LinkageError` is logged and reported once
  (`compat_pid_…`), and the launcher goes on (`314897ef`).
- **Also:** three crashes within two minutes trigger a safe start (`CrashLoopGuard`, `66e2ce1a`).
- **Source:** brief 2026-11-03 and 2026-11-05 [V][H].

### D-12 CAN bus: one library, requests only where needed, the user's code wins
- **Decision:**
  - The canbus library is the only list of cars' classes (`75d41dff`). carinfo screens are out of the
    build and kept as reference (`1ff27146`).
  - A request is sent only for cars that need one (`34f764a6`). The command logger was dropped (`9a05cfce`).
  - The 7870 has a library and callbacks of its own (`4721980e`).
  - Code precedence: the code the user typed, then the library's working pair, then the automatic check's
    guess.
  - The reader never sends the car random commands.
- **Source:** CAN briefs 2026-10-28 to 2026-11-05, `README.MD` [H].

### D-13 The fuel estimate is a fallback, never a replacement
- **Decision:** the estimate is shown (marked `≈`) only where the car gives no value. It is learned from the
  car's own values and never offered for a car without a fuel code. Model v3 is power-based (`8b51f33a`).
  The car's mass and engine size are optional settings.
- **Source:** fuel briefs 2026-10-30/31, `README.MD` [H].

### D-14 `com.syu.media` is never forced
- **Decision:**
  - No force-stop, kill or write to its private database.
  - Favorites go through its library.
  - FM favorites are read-only for other apps, so the widget's FM heart is greyed out (`608ff0a8`).
- **Source:** media brief 2026-11-05 §4 [H].

### D-15 Framework warnings that are not fixed
- **Decision:** `Parcel: Expecting binder but got null!` and `SurfaceSyncer: Failed to find sync` are
  Android 13 framework warnings. Their code stays as it is.
- **Source:** `vdhost/README.md`, media brief C3 [H].

### D-16 The stats window is only moved by the bars
- **Decision:** the stats window lies above every element. It is not an obstacle for the layout and is never
  resized; the bars move it into the room beside them (`StatsBarFit`, `f791b67e`). The brief was amended to
  say so (`7b920b51`).
- **Source:** brief 2026-11-08 [H].

### D-17 Rules R1–R3 (round G, 2026-11-08)
- **R1:** the model owns the "loading" state. A stuck load is started again, and a skipped reload is not
  lost (`e3136f45`).
- **R2:** widget colors and backgrounds are view tints applied to what is on screen, never color filters on
  shared drawables (`b1fe254c`).
- **R3:** one overlap rule, under which touching edges do not overlap; overlapping elements are moved, then
  cut, then reset (`3dd71894`).
- These rules are written in the Javadoc of the classes that enforce them.
- **Source:** brief 2026-11-08 [H][V].

### D-18 Bars at either side; old names gone
- **Decision:** "bottom bar"/"left bar" became horizontal/vertical bar (`d0e67aaf`). The horizontal bar goes
  at the top or bottom, the vertical bar left or right, either can be on every page, and the auto-hide handle
  goes on either edge (`9bc0faa5`, `5604d116`, `6080ce99`). There is one creator for every page (`76c1c110`).
- **Source:** briefs 2026-11-07/08 [H].

### D-19 Location: the platform first, Play services only as a way out
- **Decision:** location uses the platform provider; Google Play services is loaded only as a fallback
  (`620fd619`).
- **Reason:** not recorded; probably that head units may lack Play services [A].

### D-20 Night brightness floor only on the 7870
- **Decision (owner):** the 7862 may go to brightness 0. The 7870 can switch its backlight off at level 0, so
  it has a floor of 10, decided by chipset (`85f36a7d`, then `681b5c74`; `DayNightBrightness`).
- **Source:** brief 2026-10-27 music-widget D3, device-identity D2 [H][V].

### D-21 The launcher compiles itself with its Baseline Profile
- **Decision:** Android compiles a profile only during idle maintenance, which a head unit rarely reaches.
  `BaselineProfileCompiler` therefore compiles:
  - 90 s after a new APK starts;
  - again after 3, 14 and 30 days, once there have been enough sessions.
- **Source:** `README.MD`, `baselineProfile/README.md` [H].

### D-22 The updater downloads its own flavor's asset
- **Decision:** from 1.2.2 the updater downloads `system_release_<v>.apk` or `standard_release_<v>.apk`.
  `release-assets.yml` adds `update<v>.apk` and `fyt_release_<v>.apk` copies for older updaters. A standard
  ("phone") 1.2.1 must be updated by hand once.
- **Source:** `README.MD`, workflow header [V].

### D-23 Google Maps' minimal UI in pinned PiP is solved outside the launcher
- **Decision:** the only reliable fix the owner found needs root, LSPosed and a separate module
  (`Full-Interface-PiP`). The launcher's window panes avoid the problem.
- **Source:** `README.MD` [H].

### D-24 Reverted approaches (keep for reference)

| Reverted change | Revert | Reason |
|---|---|---|
| `66961f21` force debug logcat | `735e308b` | owner decision (D-06) |
| `3a0217ea` "on the 7862 the stats' surface moves with the launcher's frame" | `b38f1286` (2026-10-28) | not recorded [U] |
| `1586b84b` (external PR #5) "Harden Maps PiP window lifecycle" | `c94703fd` (2026-07-22) | "a defect in the application view resume lifecycle causes a new instance to be created instead of restoring the existing one" |

### D-25 Development process
- **Decision:** Opus writes briefs, Sonnet implements them, and the owner tests on devices.
  - One commit per step, with fixed English subjects.
  - Every commit must build; CI is the gate between commits; no amend or force-push.
  - No model names in the repository.
  - Briefs and chat reports are in Polish; code, commits and these docs are in English.
- Since 2026-11-10 the briefs live in `Claude/prompts/`, and the catalogue is updated together with each
  brief.
- **Source:** every brief §1; the owner's instruction of 2026-11-10 [H].

### D-26 The OpenWeather key: out of the logs, still in the code
- **Decision so far:** the key and exact coordinates are redacted from the logs (`771f9387`), with a test
  (`8cc9e48f`).
- **Not done:** moving the key to `BuildConfig`/`local.properties` and rotating it, which
  `log-analysis-2026-10-26.md` P10 recommended. Whether that was decided against is **not recorded** [U].
  See KI-01.
