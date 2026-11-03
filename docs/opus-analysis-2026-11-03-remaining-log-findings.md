# Remaining findings from the logs of 2026-11-03 (after commits C1-C7 and the pane fix) - brief for deeper analysis

Device: Samsung SM-A556B, Android 16 (API 36), standard flavor, Shizuku host. Branch `testBranch`.
Logs (owner, Download/Launcher66_Logs): `reboot_pid_03-11-2026_12-26-13.txt` (cold start, PID 4076),
`user_pid_03-11-2026_12-18-03.txt` (drag of an icon to a new screen, PID 15226).

The fixes of the brief `sonnet-prompt-2026-11-03-crash-loop-and-log-fixes.md` were verified in these logs (no crash,
no duplicated drag events, RAISE/RESTORE of the stats limit works, no requestLayout/fytver/RecyclerView noise).
Three items remain. They are not regressions. Please analyse them in depth and propose changes.

## 1. StrictMode 146 ms on the main thread: icon of the left bar (`LauncherAppBars.loadLeftBarIconStrict`)

Not in the earlier list; `LauncherAppBars.initAppData()` runs `setupLeftRecyclerView()` -> `initializeLeftAppData()` ->
`loadLeftBarIconStrict()` (≈2191) -> `PackageManager.getActivityIcon()` on the main thread. `getLiveIcon()` creates a
`PathClassLoader` for the icon pack (dex path lists: `File.isDirectory`, `stat`), hence the disk reads. Both violations
are the same call (reported twice by two policies, ~146 ms each).

Questions: why is the "Strict" loader on the main thread (the name suggests it was made for StrictMode reasons)?
Can the icons be loaded in the preload threads (`warmUpOffMainThread`, `BarRows.preload`) and the bar bind from a cache?
What else does `getActivityIcon` pull in at 12:26:19 (see the main-thread stall below)?

```
11-03 12:26:19.200  4076  4076Mode: StrictMode policy violation; ~duration=146 ms: android.os.strictmode.DiskReadViolation
11-03 12:26:19.200  4076  4076Mode: 	at android.os.StrictMode$AndroidBlockGuardPolicy.onReadFromDisk(StrictMode.java:1722)
11-03 12:26:19.200  4076  4076Mode: 	at java.io.UnixFileSystem.getBooleanAttributes(UnixFileSystem.java:306)
11-03 12:26:19.200  4076  4076Mode: 	at java.io.File.isDirectory(File.java:859)
11-03 12:26:19.200  4076  4076Mode: 	at dalvik.system.DexPathList$Element.<init>(DexPathList.java:681)
11-03 12:26:19.200  4076  4076Mode: 	at dalvik.system.DexPathList.makeDexElements(DexPathList.java:400)
11-03 12:26:19.200  4076  4076Mode: 	at dalvik.system.DexPathList.<init>(DexPathList.java:167)
11-03 12:26:19.200  4076  4076Mode: 	at dalvik.system.BaseDexClassLoader.<init>(BaseDexClassLoader.java:152)
11-03 12:26:19.200  4076  4076Mode: 	at dalvik.system.BaseDexClassLoader.<init>(BaseDexClassLoader.java:104)
11-03 12:26:19.200  4076  4076Mode: 	at dalvik.system.PathClassLoader.<init>(PathClassLoader.java:45)
11-03 12:26:19.200  4076  4076Mode: 	at android.app.ApplicationPackageManager.getLiveIcon(ApplicationPackageManager.java:4717)
11-03 12:26:19.200  4076  4076Mode: 	at android.app.ApplicationPackageManager.loadUnbadgedItemIcon(ApplicationPackageManager.java:3957)
11-03 12:26:19.200  4076  4076Mode: 	at android.app.ApplicationPackageManager.loadUnbadgedItemIcon(ApplicationPackageManager.java:3932)
11-03 12:26:19.200  4076  4076Mode: 	at android.app.ApplicationPackageManager.loadItemIcon(ApplicationPackageManager.java:3801)
11-03 12:26:19.200  4076  4076Mode: 	at android.content.pm.PackageItemInfo.loadIcon(PackageItemInfo.java:320)
11-03 12:26:19.200  4076  4076Mode: 	at android.content.pm.PackageItemInfo.loadIcon(PackageItemInfo.java:315)
11-03 12:26:19.200  4076  4076Mode: 	at android.app.ApplicationPackageManager.getActivityIcon(ApplicationPackageManager.java:2030)
11-03 12:26:19.200  4076  4076Mode: 	at com.android.launcher66.LauncherAppBars.loadLeftBarIconStrict(LauncherAppBars.java:2191)
11-03 12:26:19.200  4076  4076Mode: 	at com.android.launcher66.LauncherAppBars.initializeLeftAppData(LauncherAppBars.java:890)
11-03 12:26:19.200  4076  4076Mode: 	at com.android.launcher66.LauncherAppBars.setupLeftRecyclerView(LauncherAppBars.java:719)
11-03 12:26:19.200  4076  4076Mode: 	at com.android.launcher66.LauncherAppBars.lambda$initAppData$8(LauncherAppBars.java:533)
11-03 12:26:19.200  4076  4076Mode: 	at com.android.launcher66.LauncherAppBars.$r8$lambda$to-Jro7iYSTWVpoXg5D0mYMgTgw(LauncherAppBars.java:0)
11-03 12:26:19.200  4076  4076Mode: 	at com.android.launcher66.LauncherAppBars$$ExternalSyntheticLambda16.run(D8$$SyntheticClass:0)
```

## 2. `WindowHostDualPane: LEFT/RIGHT: bounds update never arrived, starting ... anyway`

Seen once, after `recreateView()` (return from the settings) in `user_pid_03-11-2026_12-18-03.txt`. The same flow in
`user_pid_03-11-2026_12-23-18.txt` (PID 15226, 5 minutes later) does not show it. The panes start anyway
("taken over from the previous pane"), so there is no visible damage, but the wait timed out (~100 ms after
`Third: resizeVD OK`). Suspected race between the bounds update of the dual pane and the takeover by the new host/window
after the recreate. Look at `WindowHostDualPane` (the wait for bounds), `pumpPipBoundsUntilReady()` and
`WindowUtil.onPaneScreensChanged()` (new, forces the next bounds update) for interaction.

```
11-03 12:18:08.356 15226 15369 D HWUI    : HWUI - treat SMPTE_170M as sRGB
11-03 12:18:08.383 15226 15226 I WindowHostVdView: app.revanced.android.youtube already runs on display 12, not started again
11-03 12:18:08.383 15226 15226 I WindowHostSinglePane: Third: start ok for app.revanced.android.youtube
11-03 12:18:08.442 15226 15226 D WindowHostSinglePane: Third: resizeVD OK -> 709x660 @450
11-03 12:18:08.658 15226 15226 I WindowHostAvReaper: releaseNow id=100679810 displayId=12 reason=display handed over
11-03 12:18:08.658 15226 15226 I WindowHostAvReaper: released retired ActivityView (displayId=12, display handed over)
11-03 12:18:08.784 15226 15226 W WindowHostDualPane: LEFT: bounds update never arrived, starting app.revanced.android.apps.youtube.music anyway
11-03 12:18:08.784 15226 15226 W WindowHostDualPane: RIGHT: bounds update never arrived, starting com.google.android.apps.maps anyway
11-03 12:18:08.806 15226 15226 I WindowHostVdView: app.revanced.android.apps.youtube.music already runs on display 10, not started again
11-03 12:18:08.806 15226 15226 I WindowHostDualPane: LEFT: start ok for app.revanced.android.apps.youtube.music
```

## 3. Heavy cold start (reboot) - out of the scope of the previous brief, now with data

Main-thread stalls in `reboot_pid_03-11-2026_12-26-13.txt` (cold start 12:26:10, launcher is the system's home after
the boot autostart of `vasyl.titles.phone`):

- `Launcher.Model: waitForIdle: main thread still busy after 3579ms, loading all apps anyway`;
- `LogcatWorker: Main thread not responding for 2138 ms ... it is at: DisplayInfo.readFromParcel <- DisplayManagerGlobal.getDisplayInfo <- ActivityThread.getTopLevelResources <- ApplicationPackageManager.getDrawable <- PackageItemInfo.loadIcon` (the main thread loads an icon: same family as item 1), responding again after 2491 ms;
- `HWUI Davey!` 1778 ms, 2083 ms, 3457 ms (skipped 413 frames at 12:26:43), 2060 ms, 1934 ms; many `Choreographer: Skipped 30-200 frames`;
- `Long monitor contention with owner LauncherWidgetSort ... Parcel.readParcelableCreatorInternal` (4 times, 12:26:23-31): the widget sort thread holds the Parcel creator cache lock while other threads wait;
- `Verification of ... took 1.109s` (ConstraintLayout.setChildrenConstraints) and GMS classes `failed lock verification and will run slower` (first start after an install: no baseline profile compiled yet? check `BaselineProfileCompiler` status in this run);
- `Skipped 57 frames` already at 12:26:12.978 (`Application.onCreate`, `LauncherMusicWidget.<init>` verification 122 ms).

Questions: what runs on the main thread between 12:26:15 and 12:26:20 (the 218 skipped frames at 12:26:19.227 coincide
with the icon load of item 1)? Is `LauncherWidgetSort` started too early on a cold boot (competes for CPU and the
Parcel lock)? Which of the boot work can wait until after the first frame (`StartupSteps` lines)? Is the baseline
profile in effect?

```
48:11-03 12:26:12.973  4076  4625 W roid.launcher66: Verification of void com.android.launcher66.LauncherMusicWidget.<init>(com.android.launcher66.Launcher) took 122.814ms (537.40 bytecodes/s) (0B arena alloc)
49:11-03 12:26:12.978  4076  4076 I Choreographer: Skipped 57 frames!  The application may be doing too much work on its main thread.
188:11-03 12:26:14.357  4076  4076 I Choreographer: Skipped 48 frames!  The application may be doing too much work on its main thread.
200:11-03 12:26:15.167  4076  4076 I Choreographer: Skipped 96 frames!  The application may be doing too much work on its main thread.
217:11-03 12:26:16.351  4076  4076 W roid.launcher66: Verification of void androidx.constraintlayout.widget.ConstraintLayout.setChildrenConstraints() took 1.109s (483.10 bytecodes/s) (0B arena alloc)
250:11-03 12:26:18.389  4076  4726 W Launcher.Model: waitForIdle: main thread still busy after 3579ms, loading all apps anyway
255:11-03 12:26:18.418  4076  4107 I HWUI    : Davey! duration=1778ms; Flags=1, FrameTimelineVsyncId=18952, IntendedVsync=56491810022, Vsync=56741828297, InputEventId=0, HandleInputStart=56755229100, AnimationStart=56755233280, PerformTraversalsStart=56755330233, DrawStart=58230839491, FrameDeadline=56508476689, FrameStartTime=56754946600, FrameInterval=16667885, WorkloadTarget=16666667, SyncQueue
282:11-03 12:26:18.695  4076  5899 W roid.launcher66: Verification of void com.google.android.gms.internal.location.zzdz.zzC(com.google.android.gms.common.api.internal.ListenerHolder, com.google.android.gms.location.DeviceOrientationRequest, com.google.android.gms.tasks.TaskCompletionSource) took 194.705ms (719.03 bytecodes/s) (0B arena alloc)
290:11-03 12:26:18.873  4076  4633 W LogcatWorker: Main thread not responding for 2138 ms, blocked in one place (1 samples), it is at:
316:11-03 12:26:18.970  4076  4107 W roid.launcher66: Long monitor contention with owner main (4076) at android.view.DisplayInfo android.hardware.display.DisplayManagerGlobal.getDisplayInfo(int)(DisplayManagerGlobal.java:318) waiters=0 in void android.hardware.display.DisplayManagerGlobal.handleDisplayEvent(int, int, boolean) for 159ms
398:11-03 12:26:19.227  4076  4076 I Choreographer: Skipped 218 frames!  The application may be doing too much work on its main thread.
401:11-03 12:26:19.339  4076  5899 W roid.launcher66: Verification of com.google.android.gms.common.zzx com.google.android.gms.common.zzn.zzh(java.lang.String, com.google.android.gms.common.zzj, boolean, boolean) took 207.969ms (644.33 bytecodes/s) (0B arena alloc)
402:11-03 12:26:19.373  4076  4633 W LogcatWorker: Main thread responding again after 2491 ms
406:11-03 12:26:19.495  4076  5883 I HWUI    : Davey! duration=2083ms; Flags=0, FrameTimelineVsyncId=18996, IntendedVsync=57275151341, Vsync=59091577045, InputEventId=0, HandleInputStart=59093282186, AnimationStart=59093286444, PerformTraversalsStart=59094005272, DrawStart=59322851444, FrameDeadline=58283607050, FrameStartTime=59092917225, FrameInterval=8332228, WorkloadTarget=8333333, SyncQueued=
414:11-03 12:26:19.668  4076  4076 I Choreographer: Skipped 52 frames!  The application may be doing too much work on its main thread.
543:11-03 12:26:20.927  4076  4076 I Choreographer: Skipped 50 frames!  The application may be doing too much work on its main thread.
631:11-03 12:26:23.417  4076  4132 W roid.launcher66: Long monitor contention with owner LauncherWidgetSort (4801) at android.os.Parcelable$Creator android.os.Parcel.readParcelableCreatorInternal(java.lang.ClassLoader, java.lang.Class)(Parcel.java:5312) waiters=0 in android.os.Parcelable$Creator android.os.Parcel.readParcelableCreatorInternal(java.lang.ClassLoader, java.lang.Class) for 238ms
850:11-03 12:26:26.627  4076  4076 I Choreographer: Skipped 33 frames!  The application may be doing too much work on its main thread.
853:11-03 12:26:27.423  4076  4107 W roid.launcher66: Long monitor contention with owner LauncherWidgetSort (4801) at android.os.Parcelable$Creator android.os.Parcel.readParcelableCreatorInternal(java.lang.ClassLoader, java.lang.Class)(Parcel.java:5312) waiters=0 in android.os.Parcelable$Creator android.os.Parcel.readParcelableCreatorInternal(java.lang.ClassLoader, java.lang.Class) for 164ms
875:11-03 12:26:28.546  4076  4726 W roid.launcher66: Long monitor contention with owner LauncherWidgetSort (4801) at android.os.Parcelable$Creator android.os.Parcel.readParcelableCreatorInternal(java.lang.ClassLoader, java.lang.Class)(Parcel.java:5312) waiters=0 in android.os.Parcelable$Creator android.os.Parcel.readParcelableCreatorInternal(java.lang.ClassLoader, java.lang.Class) for 609ms
888:11-03 12:26:31.559  4076  4076 W roid.launcher66: Long monitor contention with owner LauncherWidgetSort (4801) at android.os.Parcelable$Creator android.os.Parcel.readParcelableCreatorInternal(java.lang.ClassLoader, java.lang.Class)(Parcel.java:5312) waiters=0 in android.os.Parcelable$Creator android.os.Parcel.readParcelableCreatorInternal(java.lang.ClassLoader, java.lang.Class) for 225ms
891:11-03 12:26:31.877  4076  4076 I Choreographer: Skipped 66 frames!  The application may be doing too much work on its main thread.
892:11-03 12:26:32.588  4076  4076 I Choreographer: Skipped 46 frames!  The application may be doing too much work on its main thread.
895:11-03 12:26:33.661  4076  4076 I Choreographer: Skipped 42 frames!  The application may be doing too much work on its main thread.
908:11-03 12:26:34.656  4076  4076 I Choreographer: Skipped 62 frames!  The application may be doing too much work on its main thread.
915:11-03 12:26:34.871  4076  4132 I HWUI    : Davey! duration=727ms; Flags=0, FrameTimelineVsyncId=34535, IntendedVsync=73999186370, Vsync=74515787234, InputEventId=0, HandleInputStart=74532678670, AnimationStart=74532687342, PerformTraversalsStart=74534159647, DrawStart=74719908514, FrameDeadline=74007519703, FrameStartTime=74522416483, FrameInterval=8332272, WorkloadTarget=8333333, SyncQueued=7
916:11-03 12:26:35.184  4076  4076 I Choreographer: Skipped 38 frames!  The application may be doing too much work on its main thread.
921:11-03 12:26:35.928  4076  4076 I Choreographer: Skipped 78 frames!  The application may be doing too much work on its main thread.
927:11-03 12:26:38.002  4076  4076 I Choreographer: Skipped 90 frames!  The application may be doing too much work on its main thread.
928:11-03 12:26:38.028  4076  4132 I HWUI    : Davey! duration=763ms; Flags=0, FrameTimelineVsyncId=37791, IntendedVsync=77115731571, Vsync=77865713091, InputEventId=0, HandleInputStart=77873295155, AnimationStart=77873299256, PerformTraversalsStart=77875663631, DrawStart=77875919295, FrameDeadline=77132391689, FrameStartTime=77867822577, FrameInterval=8333128, WorkloadTarget=8333333, SyncQueued=7
935:11-03 12:26:40.050  4076  4076 I Choreographer: Skipped 115 frames!  The application may be doing too much work on its main thread.
936:11-03 12:26:40.069  4076  7631 I HWUI    : Davey! duration=1934ms; Flags=0, FrameTimelineVsyncId=38530, IntendedVsync=77990579235, Vsync=79906685315, InputEventId=0, HandleInputStart=79916647459, AnimationStart=79916651405, PerformTraversalsStart=79919283748, DrawStart=79919514998, FrameDeadline=78023952354, FrameStartTime=79916202225, FrameInterval=16661792, WorkloadTarget=16666667, SyncQueue
940:11-03 12:26:42.289  4076  4633 W LogcatWorker: Main thread not responding for 2232 ms, busy, 3 different places in 3 samples, it is at:
964:11-03 12:26:43.508  4076  4076 I Choreographer: Skipped 413 frames!  The application may be doing too much work on its main thread.
965:11-03 12:26:43.523  4076  6894 I HWUI    : Davey! duration=3457ms; Flags=0, FrameTimelineVsyncId=39902, IntendedVsync=79923731893, Vsync=83365659438, InputEventId=0, HandleInputStart=83375773202, AnimationStart=83375777303, PerformTraversalsStart=83376205663, DrawStart=83376436991, FrameDeadline=79948342232, FrameStartTime=83373625741, FrameInterval=8333965, WorkloadTarget=8333333, SyncQueued=
966:11-03 12:26:43.805  4076  4633 W LogcatWorker: Main thread responding again after 3457 ms
970:11-03 12:26:45.573  4076  4076 I Choreographer: Skipped 123 frames!  The application may be doing too much work on its main thread.
971:11-03 12:26:45.600  4076  7631 I HWUI    : Davey! duration=2060ms; Flags=0, FrameTimelineVsyncId=42482, IntendedVsync=83381841998, Vsync=85431566519, InputEventId=0, HandleInputStart=85439355858, AnimationStart=85439360897, PerformTraversalsStart=85439606327, DrawStart=85439793748, FrameDeadline=83398508665, FrameStartTime=85439001873, FrameInterval=16664427, WorkloadTarget=16666667, SyncQueue
984:11-03 12:26:52.020  4076  4076 I Choreographer: Skipped 70 frames!  The application may be doing too much work on its main thread.
996:11-03 12:26:52.911  4076  4076 I Choreographer: Skipped 54 frames!  The application may be doing too much work on its main thread.
1056:11-03 12:26:59.653  4076  4076 I Choreographer: Skipped 46 frames!  The application may be doing too much work on its main thread.
1071:11-03 12:27:00.151  4076  4076 I Choreographer: Skipped 56 frames!  The application may be doing too much work on its main thread.
```

## Other notes

- `pipWatchdog(onResume): PiP did not start, forcing it (attempt 1)` appears once after each recreate; expected.
- System noise to ignore: `WallpaperResourcesInfo parseCmfInfo`, `No package ID 9c`, `hiddenapi ... AccessibilityNodeInfo`,
  `ashmem Pinning`, `AppIconSolution`, `ShortcutContributionTestWidgetProvider can not fit`.
- Constraints of the repo apply: English comments/commits, no new dependencies, no DB schema change, StrictMode stays on.
