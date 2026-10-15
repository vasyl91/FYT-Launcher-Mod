# FYT VDHost: app windows on Android 11+

On Android 10 the launcher shows apps inside its pages (multiple PiP) with the framework's hidden
`android.app.ActivityView`. FYT did not modify that class (it is identical to AOSP 10); it works
because the launcher is installed as `android.uid.system` and because Android 10's system_server
has `IWindowSession.reparentDisplayContent()`, which hangs a VirtualDisplay's layers under the
ActivityView and routes touches into it.

That server side is gone: `reparentDisplayContent` was removed in Android 12,
`updateDisplayContentLocation`/`setForwardedInsets` in 13, and `ActivityView` itself in 12.
Android 11 still has the class, but rebuilt around `TaskEmbedder`, without the members the
launcher uses. So on Android 11+ the launcher uses its own `WindowHostVdView` instead:

- the VirtualDisplay renders **into** the pane's `SurfaceView` (no server-side reparenting);
- touches the pane receives are **injected** into the display;
- apps are started on the display with `ActivityOptions.setLaunchDisplayId()`.

Creating such a display (trusted, so the IME and focus behave), starting other apps on it and
injecting input need `ADD_TRUSTED_DISPLAY`, `INTERNAL_SYSTEM_WINDOW` and `INJECT_EVENTS`:
signature permissions no app can be granted. They are used by the **VD host**:

Three hosts, used in this order of preference (`WindowHostVdClient`):

| # | When | VD host | Runs as | Needs |
|---|---|---|---|---|
| 1 | launcher installed as `android.uid.system` (fyt flavor via the USB installer) | inside the launcher | 1000 | nothing else |
| 2 | FYT VDHost Magisk module installed | the module's daemon | 1000 | Magisk |
| 3 | Shizuku running (no root needed) | `WindowHostVdShizukuService`, a Shizuku UserService | 2000 (shell) | Shizuku 13+, one-time permission prompt |

Hosts 2 and 3 also run on Android 8-10, for one job only: a launcher that is not a system app
cannot have itself compiled with its Baseline Profile, so the host does it
(`VdHostCore.compilePackage()`, `clearProfiles()`, used by `BaselineProfileCompiler`). The panes
keep the framework's ActivityView there.

The first host that attaches is kept until it dies. When the module is installed, Shizuku waits
20 s for the daemon before standing in (at boot the daemon starts after the launcher), and a
daemon that attaches later still replaces it. If no host can be expected at all (e.g. rooted
without the module and without Shizuku), the launcher does not open the panes on non-FYT
devices; on Android 12+ a pane without a host stays empty instead of crashing.

Shizuku mode limits: shell has no `CAPTURE_SECURE_VIDEO_OUTPUT`, so apps using `FLAG_SECURE`
(video streaming, banking) show black in a pane. Shizuku without root has to be started again
after every reboot (wireless debugging), unless its own start-on-boot option is used.

No system_server patching and no LSPosed are involved.

## Layout

```
vdhost/
  shared/   :vdhost-shared  protocol (VdHostProtocol), implementation (VdHostCore), binder stub
  server/   :vdhost-server  the daemon (VdHostServer, BinderDelivery) + Magisk packaging task
  magisk/   module template (service.sh, customize.sh, sepolicy.rule, system.prop, ...)
```

Launcher side, `app/src/main/java/com/syu/util/`:

- `WindowHostVdView`: the pane view. Its private member names copy Android 10's ActivityView,
  so the reflection in `WindowHost*`, `WindowUtil` and `WindowHostReparenter` keeps working.
- `WindowHostVdDisplay`: the remote VirtualDisplay (`getDisplay()`, `resize()`, `setDisplayState()`).
- `WindowHostVdClient`: finds the host (in-process or daemon) and picks the backend
  (`shouldUse()`: Android 11+ and the launcher is system, or the module is installed).
- `WindowHostVdProvider`: the daemon delivers its binder here (`<package>.vdhost`).
- `WindowHostVdShizuku` / `WindowHostVdShizukuService`: the Shizuku host.

## Building the module

```
./gradlew :vdhost-server:magiskZip
```

Output: `vdhost/server/build/outputs/magisk/FYT-VDHost-<version>.zip`. Flash it in Magisk and
reboot. The launcher must be a build that contains `WindowHostVdProvider`; the protocol versions
of the module and the launcher must match (`VdHostProtocol.VERSION`).

## How the daemon runs

`service.sh` waits for `sys.boot_completed`, copies `vdhost.apk` to `/dev/fyt_vdhost/` (uid 1000
cannot enter `/data/adb`) and starts

```
su 1000 -c "CLASSPATH=/dev/fyt_vdhost/vdhost.apk app_process /system/bin com.syu.vdhost.server.VdHostServer --package com.android.launcher66"
```

restarting it if it exits. It must be uid 1000 from the start:
`DisplayManagerService.createVirtualDisplay()` checks the caller's package name, and before
Android 14 root has none that passes. Binder records the caller's uid when the process opens the
driver, so switching uid later would not help.

The daemon cannot be looked up by the launcher (SELinux blocks apps from unlabelled services), so
it pushes: once a second it checks whether the launcher process is (re)started and, if so, calls
the launcher's provider with its binder, the way the `content call` shell command does.

Other launcher packages can be served by listing them in `packages.txt` in the module folder.

The module also declares `android.software.activities_on_secondary_displays`: without that
feature ActivityTaskManager silently starts a pane's app on the main screen instead.

## Troubleshooting

- `cat /dev/fyt_vdhost/server.log`, `logcat -s FytVdHost WindowHostVdView WindowHostVdClient`
- `ready` and `binder delivered to com.android.launcher66` should appear after boot.
- "not running as uid 1000": the root solution's `su` does not support a target uid.
- "protocol N, expected M": update the module and the launcher together.

## Differences from ActivityView

- The embedded app's frames go through one extra composition (the display's buffer is composed
  again as the pane). With four panes, lower pane resolutions keep the GPU load down.
- Touches over a pane always go to the embedded app; the workspace does not page from there
  (with ActivityView those touches never reached the launcher at all).
- The IME of an embedded app is shown on the main screen (`DISPLAY_IME_POLICY_FALLBACK_DISPLAY`).
- Launcher features that call privileged task APIs directly (e.g. `removeTask`) still need the
  launcher to be system; only the pane hosting goes through the VD host.
