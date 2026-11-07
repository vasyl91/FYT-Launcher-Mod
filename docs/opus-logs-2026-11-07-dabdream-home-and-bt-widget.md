# Logi i fakty dla Opus: DABdream staje po Home, widget BT (okładka, symbol pauzy) — urządzenie FYT 7870

Raport testera z 2026-11-07, po rundzie `com.syu.media` (okładki, serca, widget muzyki, 7870), stan kodu `4677b990`. Plik zawiera wyciągi z dwóch pełnych logów (`-b all`, przez hosta VD) i to, czego w nich **brakuje**, żeby analiza mogła pójść dalej.

## 1. Raport testera (oryginał, EN)
1. Covers in FM — working now (at least 2 from 3). Only built-in covers tested.
2. BT player: I have seen cover once, but then it stopped to refresh them. Another issue: widget always shows pause symbol, disregarding the real player state. Pressing this pause symbol toggles playing state, but the current state symbol jumps to pause again always.
3. DABdream (`com.thf.dabplayer`): going from the fullscreen state of the app to the launcher (just pressing Home) — the app stops playing. Another player (AIMP) does not do it.

## 2. Środowisko i pliki źródłowe
- UNISOC `uis7870sc_2h10_nosec`, Android 13 (API 33). Launcher `com.android.launcher66` (uid 10199).
- **Plik A** `cade8856-user_full_07-11-2026_10-51-34_dabdream_stop_after_ging_home.txt` (21 630 linii): launcher pid 13777, host VD (`FytVdHost`) uid 2000 pid 13859. DAB pid 15690, potem 15916.
- **Plik B** `d22ce423-user_full_07-11-2026_09-33-02_Player_stops_when_ging_home.txt` (12 880 linii): launcher pid 2202, host VD uid 2000 pid 4505. DAB pid 23077, potem 23428.
- Panele launchera działają na wirtualnych displayach (w B DAB na display 3, w A na display 8; Sygic na 5). Numery linii w wyciągach to numery z oryginałów.
- Z wyciągów usunięto szum: RenderEngine, TrustyKeymaster, mali_gralloc, GNSS, AudioAgc, System.err, ConstraintSet, SurfaceSyncer, Sygic, MyGLUtils, PowerHAL, auditd, InputDispatcher.

## Streszczenie ustaleń (do zweryfikowania przez Opus)

### Problem 3 — to nie jest pauza, tylko crash aplikacji DAB, powtarzalny 3 z 3 razy
Sekwencja przy każdym Home z pełnego ekranu DAB (`PlayerActivity`):
1. `ActivityTaskManager: START … cat=HOME … cmp=com.android.launcher66/.Launcher` (uid 0).
2. Launcher odbudowuje panele: `pane launch: second`, `second: show com.thf.dabplayer`, `WindowHostVdView: display N with com.thf.dabplayer taken over from the previous pane, no fresh display`.
3. Dla Sygica (i Torque) w tym samym przebiegu jest `… already runs on display N, not started again` (skrót w `WindowHostVdView.startActivitySafely`, ok. linii 194–199). **Dla DAB tego komunikatu nie ma we wszystkich 5 przebudowach paneli w obu plikach, także przy pierwszym starcie**, więc idzie `FytVdHost: startActivity ComponentInfo{com.thf.dabplayer/…MainActivity} on display N -> 0`. System widzi `START … act=MAIN cat=LAUNCHER flg=0x34720000 pkg=com.thf.dabplayer … MainActivity from uid 2000`.
4. DAB: `MainActivity/onCreate` → sam startuje `PlayerActivity` (`START_DELIVERED_TO_TOP`, `Duplicate finish request for … MainActivity`) → `FATAL EXCEPTION: main … NullPointerException: … Window.getDecorView() on a null object reference at ActivityThread.handleResumeActivity(ActivityThread.java:5049)`. `am_crash`, SIG 9.
5. Skutki: `MediaSessionService: Media button session is changed to null`, `AudioFocus removeFocusStackEntryOnDeath`, `APM_AudioPolicyManager: stopOutput()`; `Scheduling restart of crashed service …DabService in 1000ms`. Po restarcie serwis nie gra.
6. Nie ma w logach odpowiedzi, **który warunek skrótu zawiódł**: `pkg.equals(vd.getPackage())` czy `Boolean.FALSE.equals(WindowHostVdClient.isDisplayEmpty(displayId))` (ten drugi zwraca `Boolean`, może być `null`). Brak logu tego warunku.
7. Ten sam `MAIN/LAUNCHER` start `MainActivity` zdarza się też przy pierwszym uruchomieniu (A: 10:51:36.78; B: 09:33:04.89) i wtedy nie szkodzi, bo DAB jeszcze nie działa. Po Home to ten sam start trafia w proces, który ma już `PlayerActivity` na wierzchu. AIMP nie ginie, bo jego `MainActivity` znosi powtórny start.
8. Wniosek do sprawdzenia: skrót jest wyłączony dla DAB zawsze (nie tylko po Home), więc podejrzany jest warunek `vd.getPackage()`/`isDisplayEmpty` dla tego panelu (DAB to jedyny z trzech, który ma wiele aktywności i własny serwis).

### Problem 2 — w tych logach nie ma żadnych linii launchera o muzyce
W obu plikach nie ma ani jednej linii z tagów `StockSources`, `StockCovers`, `SyuMedia`, `SyuMediaFiles`, `MediaTransport`, `MusicService`, `LauncherMusicWidget`. Przechwycono sam Home z DAB, nie przejście na BT. Z samego kodu wynika hipoteza, nie fakt:
- Symbol pauzy BT: `StockBtSource.buildTrack` (ok. 243) liczy `playing = btPlaying && CarStates.mAppID == Kind.MEDIA_BT.channel`, gdzie `btPlaying = ints[0] == 1` z kodu 13 modułu 2 (ok. 141). Gdy `CarStates.mAppID` nie jest kanałem BT albo kod 13 nie przychodzi, widget zawsze pokazuje „pauza”.
- Naciśnięcie symbolu idzie ścieżką transportu (`MediaTransportController`, ok. 172–181 pomija sesję `com.syu.media`, bo ta ignoruje `TransportControls`), po czym stan wraca do pauzy, bo źródłem stanu jest nadal ten sam `playing`.
- Okładka BT: plik `/data/blink/Id3_CoverArt.JPEG` (jeden na utwór), odczyt po kodzie 51, po 1,5 s od zmiany tytułu i po 3 i 6 s; „odświeża raz i przestaje” pasuje do pliku starszego niż zmiana utworu (nie jest brany) albo do braku kodu 51 przy kolejnych utworach.

## 3. Problem 3 — oś czasu trzech prób (Home z pełnego ekranu DABdream)

#### 3.1 Próba 1, plik B (09:33)

Źródło: `d22ce423-user_full_07-11-2026_09-33-02_Player_stops_when_ging_home.txt`, okno 09:33:19.9–09:33:22.9, 264 linii (numer: oryginalna linia).

```
6854: 11-07 09:33:19.953  1364  1364 I KeyButtonView: ====----ACTION_UP----====3
6855: 11-07 09:33:19.953  1364  1364 I KeyButtonView: ====----ACTION_UP----==1==
6856: 11-07 09:33:19.953  1364  1364 I KeyButtonView: ====----sendEvent----==1==1
6858: 11-07 09:33:19.953  1364  1364 I KeyButtonView: ====----sendEvent----==2==1
6859: 11-07 09:33:19.953  1364  1364 I KeyButtonView: ====----sendEvent----==3==1
6860: 11-07 09:33:19.953  1364  1364 I KeyButtonView: ====----sendEvent----==4==1
6861: 11-07 09:33:19.953  1364  1364 I KeyButtonView: ====----sendEvent----==5==1
6862: 11-07 09:33:19.953  1364  1364 I KeyButtonView: ====----sendEvent----==6==1
6863: 11-07 09:33:19.953  1364  1364 I KeyButtonView: ====----sendEvent----==7==1
6864: 11-07 09:33:19.954  1364  1364 I KeyButtonView: sendEvent  mCode=3,pre=8600722,action=1
6868: 11-07 09:33:19.957   860   892 I ActivityTaskManager: START u0 {act=android.intent.action.MAIN cat=[android.intent.category.HOME] flg=0x10000100 cmp=com.android.launcher66/.Launcher (has extras)} from uid 0, pid 0
6877: 11-07 09:33:19.959 23077 23077 I wm_on_top_resumed_lost_called: [55440558,com.thf.dabplayer.activity.PlayerActivity,topStateChangedWhenResumed]
6893: 11-07 09:33:19.960   860   892 I wm_set_resumed_activity: [0,com.android.launcher66/.Launcher,bringingFoundTaskToFront]
6894: 11-07 09:33:19.960   860   892 I wm_new_intent: [0,16061453,7,com.android.launcher66/.Launcher,android.intent.action.MAIN,NULL,NULL,268435712]
6899: 11-07 09:33:19.961   860   892 I ActivityTaskManager: ->startActivity for ActivityRecord{b6750b3 u0 com.android.launcher66/.Launcher} result:START_TASK_TO_FRONT
6907: 11-07 09:33:19.965 23077 23077 I wm_on_paused_called: [55440558,com.thf.dabplayer.activity.PlayerActivity,performPause]
6909: 11-07 09:33:19.967   860  7494 I wm_set_resumed_activity: [0,com.android.launcher66/.Launcher,resumeTopActivity]
6913: 11-07 09:33:19.971  2390 17807 I AppSwitcher: UsageStatsUtil: foreground app is com.android.launcher66/com.android.launcher66.Launcher
6919: 11-07 09:33:19.993   860  7494 I wm_resume_activity: [0,16061453,7,com.android.launcher66/.Launcher]
6921: 11-07 09:33:19.994  2202  2202 I wm_on_restart_called: [16061453,com.android.launcher66.Launcher,performRestartActivity]
6922: 11-07 09:33:19.994  2202  2202 D Launcher: ---->>> onStart
6923: 11-07 09:33:19.994  2202  2202 I wm_on_start_called: [16061453,com.android.launcher66.Launcher,handleStartActivity]
6927: 11-07 09:33:20.000  2202  2202 D Launcher: onResume----->
6969: 11-07 09:33:20.014  2202  2202 I wm_on_resume_called: [16061453,com.android.launcher66.Launcher,RESUME_ACTIVITY]
6973: 11-07 09:33:20.018  2202  2202 I wm_on_top_resumed_gained_called: [16061453,com.android.launcher66.Launcher,topWhenResuming]
6977: 11-07 09:33:20.036   860   895 I input_focus: [Focus request 49fc27e com.android.launcher66/com.android.launcher66.Launcher,reason=UpdateInputWindows]
6978: 11-07 09:33:20.036  2202  2202 D VRI[Launcher]: performTraversals relayoutWindow: maybeSyncSeqId=-1 ,mSyncSeqId=0 ,relayoutResult=3
7003: 11-07 09:33:20.048  2202  2202 D Launcher: onStart: registering dynamic receiver
7004: 11-07 09:33:20.048   860  1145 D WindowState: finishDrawing: syncSeqId=0, postDrawTransaction=android.view.SurfaceControl$Transaction@27e8fff, mSyncState=0, mDrawState=1, hasSyncHandlers=false, mClientWasDrawingForSync=false, win=Window{49fc27e u0 com.android.launcher66/com.android.launcher66.Launcher}-[Surface(name=*Title#3890)
7013: 11-07 09:33:20.061  2202  2202 D Launcher: -------->>> FinalRadio.U_BAND65536
7036: 11-07 09:33:20.082   860   891 I sysui_multi_action: [319,124,322,98,325,8600,757,761,758,9,759,2,806,com.android.launcher66,871,com.android.launcher66.Launcher,905,0,1320,12,1321,1]
7052: 11-07 09:33:20.091   698   698 I Layer   : fillInputInfo layer:com.android.launcher66/com.android.launcher66.Launcher#3890, visible=1 (hasInputInfo:1, isHidden:0, alpha:1.000000, mActiveBuffer:2), parent:49fc27e com.android.launcher66/com.android.launcher66.Launcher#93, parenthidden:0
7053: 11-07 09:33:20.092   860  1191 I input_focus: [Focus entering 49fc27e com.android.launcher66/com.android.launcher66.Launcher (server),reason=Window became focusable. Previous reason: NOT_VISIBLE]
7079: 11-07 09:33:20.094  1364 11401 E timer   : appName Launcher Mod
7080: 11-07 09:33:20.094  1364 11401 E hzq     : appName Launcher Mod
7137: 11-07 09:33:20.105  1984  1984 W e0      : 	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:911)
7166: 11-07 09:33:20.164 23204 23204 I AndroidRuntime: VM exiting with result code 0, cleanup skipped.
7175: 11-07 09:33:20.182   860   877 I ActivityManager: Process com.android.settings (pid 23204) has died: fg  IMPB
7176: 11-07 09:33:20.182   860   877 I am_proc_died: [0,23204,com.android.settings,0,7]
7178: 11-07 09:33:20.183   608   608 I Zygote  : Process 23204 exited cleanly (0)
7179: 11-07 09:33:20.183   860   877 D ActivityManager: cleanUpApplicationRecordLocked, remove provider timeout msg, app: ProcessRecord{2f79bb7 23204:com.android.settings/1000}
7180: 11-07 09:33:20.184   860   877 I ActivityManager: com.android.settings is exempt from freezer
7182: 11-07 09:33:20.184   860   877 D ActivityManager: PROFILE_FROM_SHELL is disabled for ProcessRecord{2f79bb7 0:com.android.settings/1000}
7188: 11-07 09:33:20.185   860   902 D ActivityManager: asking zygote to start proc:ProcessRecord{2f79bb7 0:com.android.settings/1000}
7194: 11-07 09:33:20.193   608   608 D Zygote  : Forked child process 23367
7201: 11-07 09:33:20.196   860   902 I ActivityManager: Start proc 23367:com.android.settings/1000 for restart com.android.settings
7204: 11-07 09:33:20.198 23367 23367 I Zygote  : seccomp disabled by setenforce 0
7255: 11-07 09:33:20.253  2202  4165 I WindowUtil: openPip(): show: false helpers.pipsAdded(): false Utils.topApp(): true AppPackageName.isEmpty() false helpers.isInWidgets() false helpers.isInAllApps() false helpers.isInOverviewMode() false helpers.isFirstPreferenceWindow() false helpers.allAppsVisibility() false helpers.isWallpaperW
7263: 11-07 09:33:20.261  2202  4165 I WindowUtil: openPip() pane: dismissed
7285: 11-07 09:33:20.286 23077 23077 D MusicViz: VisualizerRenderer: stop thread
7303: 11-07 09:33:20.302 23077 23077 I wm_on_stop_called: [55440558,com.thf.dabplayer.activity.PlayerActivity,STOP_ACTIVITY_ITEM]
7363: 11-07 09:33:20.364  2202  2202 I WindowUtil: pane launch set: first@0, second@1, third@1 (visible page 0)
7364: 11-07 09:33:20.364  2202  2202 I WindowUtil: pane launch: first (page 0, visible 0, 2 left)
7368: 11-07 09:33:20.378  2202  2202 I WindowHostSinglePane: First: window move animation off (privateFlags)
7372: 11-07 09:33:20.389   860   877 V WindowState: toString mSurfaceNameCache= mLastTitle=null title=PipWindowHost:First
7373: 11-07 09:33:20.389   860   877 D CoreBackPreview: Window{68bef71 u0 PipWindowHost:First}, [type=1000]: Setting back callback OnBackInvokedCallbackInfo{mCallback=android.window.IOnBackInvokedCallback$Stub$Proxy@5f86ec4, mPriority=0}
7378: 11-07 09:33:20.405  2202  2202 D VRI[PipWindowHost:First]: performTraversals relayoutWindow: maybeSyncSeqId=-1 ,mSyncSeqId=0 ,relayoutResult=3
7383: 11-07 09:33:20.412   860   894 I DisplayDeviceRepository: Display device changed state: "WindowHostVd@86558992", ON
7391: 11-07 09:33:20.417   860   894 I InputManager-JNI: Viewport [1] --- add: virtual:com.android.shell,2000,WindowHostVd@86558992,0, isActive: true 1, ViewportType::3, viewport.displayId: 2
7392: 11-07 09:33:20.417   860   894 I InputManager-JNI: Viewport [2] --- add: virtual:com.android.shell,2000,WindowHostVd@5412631,0, isActive: false 1, ViewportType::3, viewport.displayId: 3
7393: 11-07 09:33:20.417   860   894 I InputManager-JNI: Viewport [3] --- add: virtual:com.android.shell,2000,WindowHostVd@77288658,0, isActive: false 1, ViewportType::3, viewport.displayId: 4
7399: 11-07 09:33:20.425  4740  4740 I wm_on_restart_called: [131005162,com.sygic.navi.map.MapActivity,performRestartActivity]
7400: 11-07 09:33:20.425   860  1383 D WindowState: finishDrawing: syncSeqId=0, postDrawTransaction=android.view.SurfaceControl$Transaction@30518cf, mSyncState=0, mDrawState=1, hasSyncHandlers=false, mClientWasDrawingForSync=false, win=Window{68bef71 u0 PipWindowHost:First}, [type=1000]-[Surface(name=*Title#3897)/@0xc1f11ad]
7405: 11-07 09:33:20.428  4740  4740 I wm_on_start_called: [131005162,com.sygic.navi.map.MapActivity,handleStartActivity]
7414: 11-07 09:33:20.439   860  7494 D WindowState: finishDrawing: syncSeqId=0, postDrawTransaction=android.view.SurfaceControl$Transaction@5d4d25c, mSyncState=0, mDrawState=4, hasSyncHandlers=false, mClientWasDrawingForSync=false, win=Window{68bef71 u0 PipWindowHost:First}, [type=1000]-[Surface(name=*Title#3897)/@0xc1f11ad]
7415: 11-07 09:33:20.439   860  7494 D WindowStateAnimator: finishDrawingLocked: mDrawState=4 ,mLastHidden=false ,mShownAlpha=1.0 ,mLastAlpha=1.0 ,postDrawTransaction=android.view.SurfaceControl$Transaction@5d4d25c ,mWin=Window{68bef71 u0 PipWindowHost:First}, [type=1000]-[Surface(name=*Title#3897)/@0xc1f11ad]
7416: 11-07 09:33:20.439   860  7494 D WindowStateAnimator: finishDrawingLocked: syncTransaction=android.view.SurfaceControl$Transaction@5f36d25 ,mSyncTransaction=android.view.SurfaceControl$Transaction@2ddc965 ,mWin=Window{68bef71 u0 PipWindowHost:First}, [type=1000]-[Surface(name=*Title#3897)/@0xc1f11ad]
7417: 11-07 09:33:20.441  4740  4740 I wm_on_resume_called: [131005162,com.sygic.navi.map.MapActivity,RESUME_ACTIVITY]
7421: 11-07 09:33:20.443   860  3715 I am_create_service: [0,208049889,.MeasurementBrokerService,10093,11866]
7428: 11-07 09:33:20.446   698   698 I Layer   : fillInputInfo layer:PipWindowHost:First#3897, visible=1 (hasInputInfo:1, isHidden:0, alpha:1.000000, mActiveBuffer:2), parent:68bef71 PipWindowHost:First#3896, parenthidden:0
7429: 11-07 09:33:20.446   698   698 I Layer   : fillInputInfo layer:SurfaceView[PipWindowHost:First](BLAST)#3900, visible=1 (hasInputInfo:1, isHidden:0, alpha:1.000000, mActiveBuffer:0), parent:SurfaceView[PipWindowHost:First]#3899, parenthidden:0
7444: 11-07 09:33:20.465  2202  2202 D WindowUtil: Pane bounds pump started (panes launched)
7448: 11-07 09:33:20.478   860  7494 I am_create_service: [0,185389714,.SystemJobService,10141,4740]
7487: 11-07 09:33:20.517  2202  2202 D WindowHostSinglePane: First: resizeVD OK -> 842x584 @160
7514: 11-07 09:33:20.558  2202  2202 D WindowUtil: pane launch: first up after 194 ms
7515: 11-07 09:33:20.558  2202  2202 I WindowUtil: pane launch: second (page 1, visible 0, 1 left)
7516: 11-07 09:33:20.558  2202  2202 I WindowUtil: second: show com.thf.dabplayer
7518: 11-07 09:33:20.563  2202  2202 I WindowHostSinglePane: Second: window move animation off (privateFlags)
7527: 11-07 09:33:20.576   860 10120 V WindowState: toString mSurfaceNameCache= mLastTitle=null title=PipWindowHost:Second
7528: 11-07 09:33:20.576   860 10120 D CoreBackPreview: Window{3024119 u0 PipWindowHost:Second}, [type=1000]: Setting back callback OnBackInvokedCallbackInfo{mCallback=android.window.IOnBackInvokedCallback$Stub$Proxy@89f8a8c, mPriority=0}
7536: 11-07 09:33:20.581  2202  2202 D WindowHostSplash: cover up: WindowHostSplash#cover com.thf.dabplayer
7962: 11-07 09:33:20.606  2202  2202 D VRI[PipWindowHost:Second]: performTraversals relayoutWindow: maybeSyncSeqId=-1 ,mSyncSeqId=0 ,relayoutResult=3
8345: 11-07 09:33:20.623   860   894 I DisplayDeviceRepository: Display device changed state: "WindowHostVd@5412631", ON
8346: 11-07 09:33:20.623  2202  2202 I WindowHostVdView: display 3 with com.thf.dabplayer taken over from the previous pane, no fresh display
8349: 11-07 09:33:20.624   860   894 I InputManager-JNI: Viewport [1] --- add: virtual:com.android.shell,2000,WindowHostVd@86558992,0, isActive: true 1, ViewportType::3, viewport.displayId: 2
8350: 11-07 09:33:20.624   860   894 I InputManager-JNI: Viewport [2] --- add: virtual:com.android.shell,2000,WindowHostVd@5412631,0, isActive: true 1, ViewportType::3, viewport.displayId: 3
8351: 11-07 09:33:20.624   860   894 I InputManager-JNI: Viewport [3] --- add: virtual:com.android.shell,2000,WindowHostVd@77288658,0, isActive: false 1, ViewportType::3, viewport.displayId: 4
8362: 11-07 09:33:20.635   860  1387 D WindowState: finishDrawing: syncSeqId=0, postDrawTransaction=android.view.SurfaceControl$Transaction@600c378, mSyncState=0, mDrawState=1, hasSyncHandlers=false, mClientWasDrawingForSync=false, win=Window{3024119 u0 PipWindowHost:Second}, [type=1000]-[Surface(name=*Title#3908)/@0xc6cd5d5]
8367: 11-07 09:33:20.649   698   698 I Layer   : fillInputInfo layer:PipWindowHost:Second#3908, visible=1 (hasInputInfo:1, isHidden:0, alpha:1.000000, mActiveBuffer:2), parent:3024119 PipWindowHost:Second#3907, parenthidden:0
8368: 11-07 09:33:20.649   698   698 I Layer   : fillInputInfo layer:SurfaceView[PipWindowHost:Second](BLAST)#3911, visible=1 (hasInputInfo:1, isHidden:0, alpha:1.000000, mActiveBuffer:0), parent:SurfaceView[PipWindowHost:Second]#3910, parenthidden:0
8373: 11-07 09:33:20.657   860  3709 D WindowState: finishDrawing: syncSeqId=0, postDrawTransaction=android.view.SurfaceControl$Transaction@b1fa51, mSyncState=0, mDrawState=4, hasSyncHandlers=false, mClientWasDrawingForSync=false, win=Window{3024119 u0 PipWindowHost:Second}, [type=1000]-[Surface(name=*Title#3908)/@0xc6cd5d5]
8374: 11-07 09:33:20.657   860  3709 D WindowStateAnimator: finishDrawingLocked: mDrawState=4 ,mLastHidden=false ,mShownAlpha=1.0 ,mLastAlpha=1.0 ,postDrawTransaction=android.view.SurfaceControl$Transaction@b1fa51 ,mWin=Window{3024119 u0 PipWindowHost:Second}, [type=1000]-[Surface(name=*Title#3908)/@0xc6cd5d5]
8375: 11-07 09:33:20.657   860  3709 D WindowStateAnimator: finishDrawingLocked: syncTransaction=android.view.SurfaceControl$Transaction@5f36d25 ,mSyncTransaction=android.view.SurfaceControl$Transaction@1b272b6 ,mWin=Window{3024119 u0 PipWindowHost:Second}, [type=1000]-[Surface(name=*Title#3908)/@0xc6cd5d5]
8379: 11-07 09:33:20.661   860  3709 I ActivityTaskManager: START u0 {act=android.intent.action.MAIN cat=[android.intent.category.LAUNCHER] flg=0x34720000 pkg=com.thf.dabplayer cmp=com.thf.dabplayer/.activity.MainActivity} from uid 2000, pid 4505
8396: 11-07 09:33:20.687   860  3709 I wm_set_resumed_activity: [0,com.thf.dabplayer/.activity.PlayerActivity,positionChildAt]
8397: 11-07 09:33:20.688 23077 23077 I wm_on_restart_called: [55440558,com.thf.dabplayer.activity.PlayerActivity,performRestartActivity]
8398: 11-07 09:33:20.688   860  3709 I wm_set_resumed_activity: [0,com.thf.dabplayer/.activity.PlayerActivity,reparent]
8399: 11-07 09:33:20.688 23077 23077 I wm_on_start_called: [55440558,com.thf.dabplayer.activity.PlayerActivity,handleStartActivity]
8403: 11-07 09:33:20.694 23077 23077 D Dabdream: DabService/setPlayerHandler
8405: 11-07 09:33:20.697   860  3709 I wm_set_resumed_activity: [0,com.thf.dabplayer/.activity.PlayerActivity,positionChildAt]
8407: 11-07 09:33:20.697 23077 23077 D MusicViz: VisualizerRenderer: start thread
8423: 11-07 09:33:20.698 23077 23077 I wm_on_resume_called: [55440558,com.thf.dabplayer.activity.PlayerActivity,RESUME_ACTIVITY]
8427: 11-07 09:33:20.702   860  3709 I ActivityTaskManager: ->startActivity for ActivityRecord{be91c53 u0 com.thf.dabplayer/.activity.MainActivity} t58 d3} result:START_SUCCESS
8431: 11-07 09:33:20.705 23077 23077 D Dabdream: OverlayDls/showDls: duration=6000
8432: 11-07 09:33:20.711  4505 12353 I FytVdHost: startActivity ComponentInfo{com.thf.dabplayer/com.thf.dabplayer.activity.MainActivity} on display 3 -> 0
8433: 11-07 09:33:20.711  2202  2202 I WindowHostSinglePane: Second: start ok for com.thf.dabplayer
8440: 11-07 09:33:20.721  2202  2202 I wm_on_top_resumed_lost_called: [16061453,com.android.launcher66.Launcher,topStateChangedWhenResumed]
8461: 11-07 09:33:20.738 23077 23400 D MusicViz: TextureViewViz: custom shader available
8463: 11-07 09:33:20.740  2202  2202 D WindowHostSinglePane: Second: resizeVD OK -> 428x597 @160
8469: 11-07 09:33:20.745 23077 23400 D MusicViz: TextureViewViz: scene=CustomScene
8539: 11-07 09:33:20.861 23077 23077 I wm_on_paused_called: [55440558,com.thf.dabplayer.activity.PlayerActivity,performPause]
8544: 11-07 09:33:20.864   860  1145 W ActivityTaskManager: Tried to set launchTime (0) < mLastActivityLaunchTime (8587382)
8548: 11-07 09:33:20.865   860  1145 I wm_set_resumed_activity: [0,com.thf.dabplayer/.activity.MainActivity,minimalResumeActivityLocked]
8559: 11-07 09:33:20.876  2202  2202 D WindowUtil: pane launch: second up after 317 ms
8560: 11-07 09:33:20.876  2202  2202 I WindowUtil: pane launch: third (page 1, visible 0, 0 left)
8561: 11-07 09:33:20.876  2202  2202 I WindowUtil: third: show org.prowl.torque
8562: 11-07 09:33:20.877  2202  2202 I WindowHostSinglePane: Third: window move animation off (privateFlags)
8572: 11-07 09:33:20.898   860  7494 V WindowState: toString mSurfaceNameCache= mLastTitle=null title=PipWindowHost:Third
8573: 11-07 09:33:20.898   860  7494 D CoreBackPreview: Window{afde2b5 u0 PipWindowHost:Third}, [type=1000]: Setting back callback OnBackInvokedCallbackInfo{mCallback=android.window.IOnBackInvokedCallback$Stub$Proxy@e8f4bb, mPriority=0}
8591: 11-07 09:33:20.913  2202  2202 D WindowHostSplash: cover up: WindowHostSplash#cover org.prowl.torque
8601: 11-07 09:33:20.929  2202  2202 D VRI[PipWindowHost:Third]: performTraversals relayoutWindow: maybeSyncSeqId=-1 ,mSyncSeqId=0 ,relayoutResult=3
8614: 11-07 09:33:20.943  2147  2717 E Qin     :  top Act from: ComponentInfo{com.thf.dabplayer/com.thf.dabplayer.activity.PlayerActivity}  to ComponentInfo{com.android.launcher66/com.android.launcher66.Launcher}
8615: 11-07 09:33:20.944   860   894 I DisplayDeviceRepository: Display device changed state: "WindowHostVd@77288658", ON
8616: 11-07 09:33:20.945  2202  2202 I WindowHostVdView: display 4 with org.prowl.torque taken over from the previous pane, no fresh display
8618: 11-07 09:33:20.948  2147  2717 E Qin     :  newPackage =    ModuleSound.getInstance().isIgnored(newPackage) : false
8619: 11-07 09:33:20.949 32483   375 E main    : Message{module=0, code=138, ints=null, flts=null, strs=[com.android.launcher66, com.android.launcher66.Launcher]} true
8621: 11-07 09:33:20.953 23077 23077 D Dabdream: MainActivity/onCreate: board=uis7870sc_2h10 device=uis7870sc_2h10 release=13 product=uis7870sc_2h10_nosec app_version=26.10.20
8622: 11-07 09:33:20.953 23077 23077 D Dabdream: MainActivity/onCreate: started by=Intent { act=android.intent.action.MAIN cat=[android.intent.category.LAUNCHER] flg=0x34720000 pkg=com.thf.dabplayer cmp=com.thf.dabplayer/.activity.MainActivity }
8624: 11-07 09:33:20.953   860   894 I InputManager-JNI: Viewport [1] --- add: virtual:com.android.shell,2000,WindowHostVd@86558992,0, isActive: true 1, ViewportType::3, viewport.displayId: 2
8625: 11-07 09:33:20.953   860   894 I InputManager-JNI: Viewport [2] --- add: virtual:com.android.shell,2000,WindowHostVd@5412631,0, isActive: true 1, ViewportType::3, viewport.displayId: 3
8626: 11-07 09:33:20.953   860   894 I InputManager-JNI: Viewport [3] --- add: virtual:com.android.shell,2000,WindowHostVd@77288658,0, isActive: true 1, ViewportType::3, viewport.displayId: 4
8644: 11-07 09:33:20.973   860  7494 D WindowState: finishDrawing: syncSeqId=0, postDrawTransaction=android.view.SurfaceControl$Transaction@1ade325, mSyncState=0, mDrawState=1, hasSyncHandlers=false, mClientWasDrawingForSync=false, win=Window{afde2b5 u0 PipWindowHost:Third}, [type=1000]-[Surface(name=*Title#3919)/@0x1635dd8]
8649: 11-07 09:33:20.976  5013  5013 I wm_on_restart_called: [176769660,org.prowl.torque.Torque,performRestartActivity]
8650: 11-07 09:33:20.976  5013  5013 I wm_on_start_called: [176769660,org.prowl.torque.Torque,handleStartActivity]
8663: 11-07 09:33:20.991   698   698 I Layer   : fillInputInfo layer:PipWindowHost:Third#3919, visible=1 (hasInputInfo:1, isHidden:0, alpha:1.000000, mActiveBuffer:2), parent:afde2b5 PipWindowHost:Third#3918, parenthidden:0
8664: 11-07 09:33:20.991   698   698 I Layer   : fillInputInfo layer:SurfaceView[PipWindowHost:Third](BLAST)#3923, visible=1 (hasInputInfo:1, isHidden:0, alpha:1.000000, mActiveBuffer:0), parent:SurfaceView[PipWindowHost:Third]#3922, parenthidden:0
8669: 11-07 09:33:20.992 23077 23077 I wm_on_create_called: [199826515,com.thf.dabplayer.activity.MainActivity,performCreate]
8675: 11-07 09:33:20.999 23077 23077 I wm_on_start_called: [199826515,com.thf.dabplayer.activity.MainActivity,handleStartActivity]
8677: 11-07 09:33:21.000   860  1334 I ActivityTaskManager: START u0 {flg=0x14000000 cmp=com.thf.dabplayer/.activity.PlayerActivity} from uid 10151, pid 23077
8679: 11-07 09:33:21.001   860  1334 I wm_finish_activity: [0,199826515,58,com.thf.dabplayer/.activity.MainActivity,clear-task-stack]
8685: 11-07 09:33:21.005  5013  5013 I wm_on_resume_called: [176769660,org.prowl.torque.Torque,RESUME_ACTIVITY]
8703: 11-07 09:33:21.022   860  1334 I ActivityTaskManager: ->startActivity for ActivityRecord{f3e9e87 u0 com.thf.dabplayer/.activity.PlayerActivity} result:START_DELIVERED_TO_TOP
8717: 11-07 09:33:21.036   860  1387 D WindowState: finishDrawing: syncSeqId=0, postDrawTransaction=android.view.SurfaceControl$Transaction@2a06152, mSyncState=0, mDrawState=4, hasSyncHandlers=false, mClientWasDrawingForSync=false, win=Window{afde2b5 u0 PipWindowHost:Third}, [type=1000]-[Surface(name=*Title#3919)/@0x1635dd8]
8718: 11-07 09:33:21.036   860  1387 D WindowStateAnimator: finishDrawingLocked: mDrawState=4 ,mLastHidden=false ,mShownAlpha=1.0 ,mLastAlpha=1.0 ,postDrawTransaction=android.view.SurfaceControl$Transaction@2a06152 ,mWin=Window{afde2b5 u0 PipWindowHost:Third}, [type=1000]-[Surface(name=*Title#3919)/@0x1635dd8]
8719: 11-07 09:33:21.036   860  1387 D WindowStateAnimator: finishDrawingLocked: syncTransaction=android.view.SurfaceControl$Transaction@5f36d25 ,mSyncTransaction=android.view.SurfaceControl$Transaction@35c9c23 ,mWin=Window{afde2b5 u0 PipWindowHost:Third}, [type=1000]-[Surface(name=*Title#3919)/@0x1635dd8]
8725: 11-07 09:33:21.041  2202  2202 I WindowHostVdView: org.prowl.torque already runs on display 4, not started again
8726: 11-07 09:33:21.041   860  7494 W ActivityTaskManager: Duplicate finish request for r=ActivityRecord{be91c53 u0 com.thf.dabplayer/.activity.MainActivity} t58 d3 f}}
8727: 11-07 09:33:21.041 23077 23077 I wm_on_resume_called: [199826515,com.thf.dabplayer.activity.MainActivity,RESUME_ACTIVITY]
8729: 11-07 09:33:21.042 23077 23077 D AndroidRuntime: Shutting down VM
8731: 11-07 09:33:21.042 23077 23077 E AndroidRuntime: FATAL EXCEPTION: main
8732: 11-07 09:33:21.042 23077 23077 E AndroidRuntime: Process: com.thf.dabplayer, PID: 23077
8733: 11-07 09:33:21.042 23077 23077 E AndroidRuntime: java.lang.NullPointerException: Attempt to invoke virtual method 'android.view.View android.view.Window.getDecorView()' on a null object reference
8734: 11-07 09:33:21.042 23077 23077 E AndroidRuntime: 	at android.app.ActivityThread.handleResumeActivity(ActivityThread.java:5049)
8735: 11-07 09:33:21.042 23077 23077 E AndroidRuntime: 	at android.app.servertransaction.ResumeActivityItem.execute(ResumeActivityItem.java:54)
8736: 11-07 09:33:21.042 23077 23077 E AndroidRuntime: 	at android.app.servertransaction.ActivityTransactionItem.execute(ActivityTransactionItem.java:45)
8737: 11-07 09:33:21.042 23077 23077 E AndroidRuntime: 	at android.app.servertransaction.TransactionExecutor.executeLifecycleState(TransactionExecutor.java:178)
8738: 11-07 09:33:21.042 23077 23077 E AndroidRuntime: 	at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:99)
8739: 11-07 09:33:21.042 23077 23077 E AndroidRuntime: 	at android.app.ActivityThread$H.handleMessage(ActivityThread.java:2393)
8740: 11-07 09:33:21.042 23077 23077 E AndroidRuntime: 	at android.os.Handler.dispatchMessage(Handler.java:106)
8741: 11-07 09:33:21.042 23077 23077 E AndroidRuntime: 	at android.os.Looper.loopOnce(Looper.java:201)
8742: 11-07 09:33:21.042 23077 23077 E AndroidRuntime: 	at android.os.Looper.loop(Looper.java:288)
8743: 11-07 09:33:21.042 23077 23077 E AndroidRuntime: 	at android.app.ActivityThread.main(ActivityThread.java:8073)
8744: 11-07 09:33:21.042 23077 23077 E AndroidRuntime: 	at java.lang.reflect.Method.invoke(Native Method)
8745: 11-07 09:33:21.042 23077 23077 E AndroidRuntime: 	at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:703)
8746: 11-07 09:33:21.042 23077 23077 E AndroidRuntime: 	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:911)
8747: 11-07 09:33:21.043   860  1383 I am_crash: [23077,0,com.thf.dabplayer,550026820,java.lang.NullPointerException,Attempt to invoke virtual method 'android.view.View android.view.Window.getDecorView()' on a null object reference,ActivityThread.java,5049]
8752: 11-07 09:33:21.046  2202  2202 I WindowHostSinglePane: Third: start ok for org.prowl.torque
8771: 11-07 09:33:21.050  2202  2202 D WindowHostSinglePane: Third: resizeVD OK -> 841x596 @160
8774: 11-07 09:33:21.058   860  1383 W ActivityTaskManager:   Force finishing activity com.thf.dabplayer/.activity.PlayerActivity
8776: 11-07 09:33:21.058   860  1383 I wm_finish_activity: [0,55440558,58,com.thf.dabplayer/.activity.PlayerActivity,force-crash]
8778: 11-07 09:33:21.060   860  1191 I input_focus: [Focus entering 49fc27e com.android.launcher66/com.android.launcher66.Launcher (server),reason=lsec]
8779: 11-07 09:33:21.061   860  1383 I wm_set_resumed_activity: [0,com.android.launcher66/.Launcher,positionChildAt]
8780: 11-07 09:33:21.061   860  1383 I wm_set_resumed_activity: [0,com.android.launcher66/.Launcher,finish-top]
8825: 11-07 09:33:21.108 23077 23077 I Process : Sending signal. PID: 23077 SIG: 9
8829: 11-07 09:33:21.111   860  1383 I am_create_service: [0,140493570,.PersistentIntentOperationService,10093,11866]
8864: 11-07 09:33:21.130  1984  1984 W e0      : 	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:911)
8881: 11-07 09:33:21.153   860  1383 I am_create_service: [0,233341001,.DropBoxEntryAddedService,10093,11866]
8946: 11-07 09:33:21.221  1045  5609 I Codec2-Component@1.2: Client died ! release the component !!
8948: 11-07 09:33:21.222  2202  2202 D WindowHostSplash: cover down: WindowHostSplash#cover com.thf.dabplayer
8967: 11-07 09:33:21.235   860  1334 D MediaSessionService: Media button session is changed to null
8968: 11-07 09:33:21.235   860  2341 I MediaFocusControl: AudioFocus  removeFocusStackEntryOnDeath(): removing entry for android.os.BinderProxy@1f77826
8971: 11-07 09:33:21.236   608   608 I Zygote  : Process 23077 exited due to signal 9 (Killed)
8972: 11-07 09:33:21.236   860  1385 I ActivityManager: Process com.thf.dabplayer (pid 23077) has died: fg +50 TOP
8973: 11-07 09:33:21.236   860  1385 I am_proc_died: [0,23077,com.thf.dabplayer,50,2]
8987: 11-07 09:33:21.249   860  1385 W ActivityManager: Scheduling restart of crashed service com.thf.dabplayer/.service.DabService in 1000ms for start-requested
8988: 11-07 09:33:21.249   860  1385 I am_schedule_service_restart: [0,com.thf.dabplayer/.service.DabService,1000]
9074: 11-07 09:33:21.333   693  1050 I APM_AudioPolicyManager: stopOutput portId 197
9075: 11-07 09:33:21.333   693  1050 I AudioPolicyManagerCustomBase: stopOutputSetInt portId 197
9076: 11-07 09:33:21.333   693  1050 I AudioPolicyManagerCustomBase: stopOutputSetInt out portId 197
9077: 11-07 09:33:21.333   693  1050 I APM_AudioPolicyManager: stopOutput() output 13, stream 3, session 1353
9081: 11-07 09:33:21.334   693  1050 I AudioPolicyManagerCustomBase: stopOutputSetEnd portId 197
9082: 11-07 09:33:21.334   693  1050 I AudioPolicyManagerCustomBase: stopOutputSetEnd out portId 197
9090: 11-07 09:33:21.338   860   894 W ActivityManager: setHasOverlayUi called on unknown pid: 23077
9103: 11-07 09:33:21.355   860   894 W ActivityManager: setHasOverlayUi called on unknown pid: 23077
9152: 11-07 09:33:21.490  2202  2202 D WindowHostSplash: cover down: WindowHostSplash#cover org.prowl.torque
9161: 11-07 09:33:21.520   860   894 W ActivityTaskManager: Activity top resumed state loss timeout for ActivityRecord{be91c53 u0 com.thf.dabplayer/.activity.MainActivity} t-1 d3 f}}
9166: 11-07 09:33:21.528  2202  2202 I wm_on_top_resumed_gained_called: [16061453,com.android.launcher66.Launcher,topStateChangedWhenResumed]
9176: 11-07 09:33:21.575  2202  2202 I WindowHostAvReaper: retire enter id=170953730
9177: 11-07 09:33:21.575  2202  2202 I WindowHostAvReaper: releaseNow id=170953730 displayId=-1 reason=no virtual display
9178: 11-07 09:33:21.575  2202  2202 I WindowHostAvReaper: released retired ActivityView (displayId=-1, no virtual display)
9179: 11-07 09:33:21.575  2202  2202 I WindowHostAvReaper: retire enter id=173379517
9180: 11-07 09:33:21.575  2202  2202 I WindowHostAvReaper: releaseNow id=173379517 displayId=-1 reason=no virtual display
9181: 11-07 09:33:21.575  2202  2202 I WindowHostAvReaper: released retired ActivityView (displayId=-1, no virtual display)
9182: 11-07 09:33:21.575  2202  2202 I WindowHostAvReaper: retire enter id=208593453
9183: 11-07 09:33:21.575  2202  2202 I WindowHostAvReaper: releaseNow id=208593453 displayId=-1 reason=no virtual display
9184: 11-07 09:33:21.575  2202  2202 I WindowHostAvReaper: released retired ActivityView (displayId=-1, no virtual display)
9293: 11-07 09:33:21.958   860   894 I DisplayDeviceRepository: Display device changed state: "WindowHostVd@86558992", OFF
9295: 11-07 09:33:21.959   860   894 I InputManager-JNI: Viewport [1] --- add: virtual:com.android.shell,2000,WindowHostVd@86558992,0, isActive: false 1, ViewportType::3, viewport.displayId: 2
9296: 11-07 09:33:21.960   860   894 I InputManager-JNI: Viewport [2] --- add: virtual:com.android.shell,2000,WindowHostVd@5412631,0, isActive: true 1, ViewportType::3, viewport.displayId: 3
9297: 11-07 09:33:21.960   860   894 I InputManager-JNI: Viewport [3] --- add: virtual:com.android.shell,2000,WindowHostVd@77288658,0, isActive: true 1, ViewportType::3, viewport.displayId: 4
9307: 11-07 09:33:21.969  4740  4740 I wm_on_paused_called: [131005162,com.sygic.navi.map.MapActivity,performPause]
9373: 11-07 09:33:22.021  4505 12353 D FytVdHost: surface detach in 63 ms
9385: 11-07 09:33:22.034  4740  4740 I wm_on_stop_called: [131005162,com.sygic.navi.map.MapActivity,STOP_ACTIVITY_ITEM]
9466: 11-07 09:33:22.176   860   894 I DisplayDeviceRepository: Display device changed state: "WindowHostVd@86558992", ON
9469: 11-07 09:33:22.177   860   894 I InputManager-JNI: Viewport [1] --- add: virtual:com.android.shell,2000,WindowHostVd@86558992,0, isActive: true 1, ViewportType::3, viewport.displayId: 2
9470: 11-07 09:33:22.177   860   894 I InputManager-JNI: Viewport [2] --- add: virtual:com.android.shell,2000,WindowHostVd@5412631,0, isActive: true 1, ViewportType::3, viewport.displayId: 3
9471: 11-07 09:33:22.177   860   894 I InputManager-JNI: Viewport [3] --- add: virtual:com.android.shell,2000,WindowHostVd@77288658,0, isActive: true 1, ViewportType::3, viewport.displayId: 4
9477: 11-07 09:33:22.184  4740  4740 I wm_on_restart_called: [131005162,com.sygic.navi.map.MapActivity,performRestartActivity]
9484: 11-07 09:33:22.188  4740  4740 I wm_on_start_called: [131005162,com.sygic.navi.map.MapActivity,handleStartActivity]
9490: 11-07 09:33:22.197  4740  4740 I wm_on_resume_called: [131005162,com.sygic.navi.map.MapActivity,RESUME_ACTIVITY]
9525: 11-07 09:33:22.221   860   877 I am_create_service: [0,7853865,.SystemJobService,10141,4740]
9534: 11-07 09:33:22.228   860   894 I DisplayDeviceRepository: Display device changed state: "WindowHostVd@5412631", OFF
9539: 11-07 09:33:22.230   860   894 I InputManager-JNI: Viewport [1] --- add: virtual:com.android.shell,2000,WindowHostVd@86558992,0, isActive: true 1, ViewportType::3, viewport.displayId: 2
9540: 11-07 09:33:22.230   860   894 I InputManager-JNI: Viewport [2] --- add: virtual:com.android.shell,2000,WindowHostVd@5412631,0, isActive: false 1, ViewportType::3, viewport.displayId: 3
9541: 11-07 09:33:22.230   860   894 I InputManager-JNI: Viewport [3] --- add: virtual:com.android.shell,2000,WindowHostVd@77288658,0, isActive: true 1, ViewportType::3, viewport.displayId: 4
9562: 11-07 09:33:22.253   860   901 D ActivityManager: PROFILE_FROM_SHELL is disabled for ProcessRecord{cc663dc 0:com.thf.dabplayer/u0a151}
9567: 11-07 09:33:22.260   860   902 D ActivityManager: asking zygote to start proc:ProcessRecord{cc663dc 0:com.thf.dabplayer/u0a151}
9597: 11-07 09:33:22.276  4505 12353 D FytVdHost: surface detach in 50 ms
9600: 11-07 09:33:22.278   608   608 D Zygote  : Forked child process 23428
9602: 11-07 09:33:22.280   860   902 I ActivityManager: Start proc 23428:com.thf.dabplayer/u0a151 for service {com.thf.dabplayer/com.thf.dabplayer.service.DabService}
9607: 11-07 09:33:22.281 23428 23428 I Zygote  : seccomp disabled by setenforce 0
9708: 11-07 09:33:22.364   860  1145 I am_create_service: [0,219914519,.DabService,10151,23428]
10591: 11-07 09:33:22.446   860   894 I DisplayDeviceRepository: Display device changed state: "WindowHostVd@5412631", ON
10593: 11-07 09:33:22.448   860   894 I InputManager-JNI: Viewport [1] --- add: virtual:com.android.shell,2000,WindowHostVd@86558992,0, isActive: true 1, ViewportType::3, viewport.displayId: 2
10594: 11-07 09:33:22.448   860   894 I InputManager-JNI: Viewport [2] --- add: virtual:com.android.shell,2000,WindowHostVd@5412631,0, isActive: true 1, ViewportType::3, viewport.displayId: 3
10595: 11-07 09:33:22.448   860   894 I InputManager-JNI: Viewport [3] --- add: virtual:com.android.shell,2000,WindowHostVd@77288658,0, isActive: true 1, ViewportType::3, viewport.displayId: 4
10602: 11-07 09:33:22.464 23428 23428 D Dabdream: DabService/onCreate
10614: 11-07 09:33:22.483   860  1145 D MediaSessionService: Media button session is changed to com.thf.dabplayer/dab (userId=0)
10625: 11-07 09:33:22.506 23428 23428 D Dabdream: DabService/onStartCommand
10639: 11-07 09:33:22.548   860   894 I DisplayDeviceRepository: Display device changed state: "WindowHostVd@77288658", OFF
10641: 11-07 09:33:22.550   860   894 I InputManager-JNI: Viewport [1] --- add: virtual:com.android.shell,2000,WindowHostVd@86558992,0, isActive: true 1, ViewportType::3, viewport.displayId: 2
10642: 11-07 09:33:22.550   860   894 I InputManager-JNI: Viewport [2] --- add: virtual:com.android.shell,2000,WindowHostVd@5412631,0, isActive: true 1, ViewportType::3, viewport.displayId: 3
10643: 11-07 09:33:22.550   860   894 I InputManager-JNI: Viewport [3] --- add: virtual:com.android.shell,2000,WindowHostVd@77288658,0, isActive: false 1, ViewportType::3, viewport.displayId: 4
10654: 11-07 09:33:22.566  5013  5013 I wm_on_paused_called: [176769660,org.prowl.torque.Torque,performPause]
10677: 11-07 09:33:22.595  4505 12353 D FytVdHost: surface detach in 47 ms
10713: 11-07 09:33:22.624  5013  5013 I wm_on_stop_called: [176769660,org.prowl.torque.Torque,STOP_ACTIVITY_ITEM]
10746: 11-07 09:33:22.756   860   894 I DisplayDeviceRepository: Display device changed state: "WindowHostVd@77288658", ON
10749: 11-07 09:33:22.757   860   894 I InputManager-JNI: Viewport [1] --- add: virtual:com.android.shell,2000,WindowHostVd@86558992,0, isActive: true 1, ViewportType::3, viewport.displayId: 2
10750: 11-07 09:33:22.757   860   894 I InputManager-JNI: Viewport [2] --- add: virtual:com.android.shell,2000,WindowHostVd@5412631,0, isActive: true 1, ViewportType::3, viewport.displayId: 3
10751: 11-07 09:33:22.757   860   894 I InputManager-JNI: Viewport [3] --- add: virtual:com.android.shell,2000,WindowHostVd@77288658,0, isActive: true 1, ViewportType::3, viewport.displayId: 4
10755: 11-07 09:33:22.766  5013  5013 I wm_on_restart_called: [176769660,org.prowl.torque.Torque,performRestartActivity]
10756: 11-07 09:33:22.766  5013  5013 I wm_on_start_called: [176769660,org.prowl.torque.Torque,handleStartActivity]
10757: 11-07 09:33:22.770 23428 23428 D Dabdream: DabService/onBind: android.media.browse.MediaBrowserService
10758: 11-07 09:33:22.770 23428 23428 D Dabdream: DabService/onBind: MediaBrowser client -> super.onBind
10764: 11-07 09:33:22.777   860   860 I am_create_service: [0,168682027,.CastMediaRoute2ProviderService_Persistent,10093,11866]
10766: 11-07 09:33:22.786 23428 23428 D Dabdream: MediaBrowseTree/root: client=com.android.systemui -> media_root_id
10778: 11-07 09:33:22.794 23428 23428 D Dabdream: MediaBrowseTree/loadChildren: parentMediaId=media_root_id
10780: 11-07 09:33:22.796 23428 23454 D Dabdream: MediaBrowseTree/loadChildren: getInstance=null -> new instance
10781: 11-07 09:33:22.797 23428 23454 D Dabdream: DatabaseHelper/openDatabase: open db
10797: 11-07 09:33:22.814 23428 23454 D Dabdream: MediaBrowseTree/loadChildren: favorites=false stations=119
10798: 11-07 09:33:22.817 23428 23454 D Dabdream: MediaBrowseTree/loadChildren: ROOT -> 2 folders
10799: 11-07 09:33:22.817  5013  5013 I wm_on_resume_called: [176769660,org.prowl.torque.Torque,RESUME_ACTIVITY]
10821: 11-07 09:33:22.832 23428 23428 D Dabdream: DabService/onUnbind
10822: 11-07 09:33:22.832 23428 23428 D Dabdream: Intent { act=android.media.browse.MediaBrowserService cmp=com.thf.dabplayer/.service.DabService }
```

#### 3.2 Próba 2, plik A (10:51:45)

Źródło: `cade8856-user_full_07-11-2026_10-51-34_dabdream_stop_after_ging_home.txt`, okno 10:51:45.0–10:51:47.0, 222 linii (numer: oryginalna linia).

```
7483: 11-07 10:51:45.029  1364  1364 I KeyButtonView: ====ACTION_DOWN====3
7485: 11-07 10:51:45.029  1364  1364 I KeyButtonView: ====----sendEvent----==1==0
7487: 11-07 10:51:45.029  1364  1364 I KeyButtonView: ====----sendEvent----==2==0
7489: 11-07 10:51:45.029  1364  1364 I KeyButtonView: ====----sendEvent----==3==0
7490: 11-07 10:51:45.029  1364  1364 I KeyButtonView: ====----sendEvent----==4==0
7491: 11-07 10:51:45.029  1364  1364 I KeyButtonView: ====----sendEvent----==5==0
7492: 11-07 10:51:45.029  1364  1364 I KeyButtonView: ====----sendEvent----==6==0
7493: 11-07 10:51:45.029  1364  1364 I KeyButtonView: sendEvent -------------------return 9241
7532: 11-07 10:51:45.092  1364  1364 I KeyButtonView: ====----ACTION_UP----====3
7533: 11-07 10:51:45.093  1364  1364 I KeyButtonView: ====----ACTION_UP----==1==
7534: 11-07 10:51:45.093  1364  1364 I KeyButtonView: ====----sendEvent----==1==1
7536: 11-07 10:51:45.093  1364  1364 I KeyButtonView: ====----sendEvent----==2==1
7537: 11-07 10:51:45.093  1364  1364 I KeyButtonView: ====----sendEvent----==3==1
7538: 11-07 10:51:45.093  1364  1364 I KeyButtonView: ====----sendEvent----==4==1
7539: 11-07 10:51:45.093  1364  1364 I KeyButtonView: ====----sendEvent----==5==1
7540: 11-07 10:51:45.093  1364  1364 I KeyButtonView: ====----sendEvent----==6==1
7541: 11-07 10:51:45.093  1364  1364 I KeyButtonView: ====----sendEvent----==7==1
7542: 11-07 10:51:45.096  1364  1364 I KeyButtonView: sendEvent  mCode=3,pre=13244308,action=1
7546: 11-07 10:51:45.104   860   892 I ActivityTaskManager: START u0 {act=android.intent.action.MAIN cat=[android.intent.category.HOME] flg=0x10000100 cmp=com.android.launcher66/.Launcher (has extras)} from uid 0, pid 0
7555: 11-07 10:51:45.106 15690 15690 I wm_on_top_resumed_lost_called: [44732475,com.thf.dabplayer.activity.PlayerActivity,topStateChangedWhenResumed]
7569: 11-07 10:51:45.107   860   892 I wm_set_resumed_activity: [0,com.android.launcher66/.Launcher,bringingFoundTaskToFront]
7570: 11-07 10:51:45.107   860   892 I wm_new_intent: [0,264133600,99,com.android.launcher66/.Launcher,android.intent.action.MAIN,NULL,NULL,268435712]
7576: 11-07 10:51:45.109   860   892 I ActivityTaskManager: ->startActivity for ActivityRecord{9c88c89 u0 com.android.launcher66/.Launcher} result:START_TASK_TO_FRONT
7585: 11-07 10:51:45.120 15690 15690 I wm_on_paused_called: [44732475,com.thf.dabplayer.activity.PlayerActivity,performPause]
7586: 11-07 10:51:45.122   860  2352 I wm_set_resumed_activity: [0,com.android.launcher66/.Launcher,resumeTopActivity]
7590: 11-07 10:51:45.127  2390  6204 I AppSwitcher: UsageStatsUtil: foreground app is com.android.launcher66/com.android.launcher66.Launcher
7617: 11-07 10:51:45.167   860  2352 I wm_resume_activity: [0,264133600,99,com.android.launcher66/.Launcher]
7620: 11-07 10:51:45.169 13777 13777 I wm_on_restart_called: [264133600,com.android.launcher66.Launcher,performRestartActivity]
7623: 11-07 10:51:45.170 13777 13777 D Launcher: ---->>> onStart
7624: 11-07 10:51:45.170 13777 13777 I wm_on_start_called: [264133600,com.android.launcher66.Launcher,handleStartActivity]
7635: 11-07 10:51:45.179 13777 13777 D Launcher: onResume----->
7683: 11-07 10:51:45.197 13777 13777 I wm_on_resume_called: [264133600,com.android.launcher66.Launcher,RESUME_ACTIVITY]
7685: 11-07 10:51:45.197 13777 13777 I wm_on_top_resumed_gained_called: [264133600,com.android.launcher66.Launcher,topWhenResuming]
7696: 11-07 10:51:45.207   860   895 I input_focus: [Focus request 65ac00d com.android.launcher66/com.android.launcher66.Launcher,reason=UpdateInputWindows]
7697: 11-07 10:51:45.208 13777 13777 D VRI[Launcher]: performTraversals relayoutWindow: maybeSyncSeqId=-1 ,mSyncSeqId=0 ,relayoutResult=3
7717: 11-07 10:51:45.217 13777 13777 D Launcher: onStart: registering dynamic receiver
7718: 11-07 10:51:45.217   860  3707 D WindowState: finishDrawing: syncSeqId=0, postDrawTransaction=android.view.SurfaceControl$Transaction@ee3979f, mSyncState=0, mDrawState=1, hasSyncHandlers=false, mClientWasDrawingForSync=false, win=Window{65ac00d u0 com.android.launcher66/com.android.launcher66.Launcher}-[Surface(name=*Title#7355)
7726: 11-07 10:51:45.224 13777 13777 D Launcher: -------->>> FinalRadio.U_BAND65536
7727: 11-07 10:51:45.224 13777 13777 D Launcher: -------->>> FinalRadio.U_BAND65536
7740: 11-07 10:51:45.236   860   891 I sysui_multi_action: [319,127,322,117,325,13244,757,761,758,9,759,2,806,com.android.launcher66,871,com.android.launcher66.Launcher,905,0,1320,12,1321,1]
7769: 11-07 10:51:45.247   698   698 I Layer   : fillInputInfo layer:com.android.launcher66/com.android.launcher66.Launcher#7355, visible=1 (hasInputInfo:1, isHidden:0, alpha:1.000000, mActiveBuffer:2), parent:65ac00d com.android.launcher66/com.android.launcher66.Launcher#7057, parenthidden:0
7772: 11-07 10:51:45.249   860  1191 I input_focus: [Focus entering 65ac00d com.android.launcher66/com.android.launcher66.Launcher (server),reason=Window became focusable. Previous reason: NOT_VISIBLE]
7795: 11-07 10:51:45.259  1984  1984 W e0      : 	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:911)
7838: 11-07 10:51:45.310 15661 15661 I AndroidRuntime: VM exiting with result code 0, cleanup skipped.
7861: 11-07 10:51:45.343   608   608 I Zygote  : Process 15661 exited cleanly (0)
7863: 11-07 10:51:45.344   860  1384 I ActivityManager: Process com.android.settings (pid 15661) has died: fg  IMPB
7864: 11-07 10:51:45.345   860  1384 I am_proc_died: [0,15661,com.android.settings,0,7]
7869: 11-07 10:51:45.349   860  1384 D ActivityManager: cleanUpApplicationRecordLocked, remove provider timeout msg, app: ProcessRecord{2f79bb7 15661:com.android.settings/1000}
7877: 11-07 10:51:45.355   860  1384 I ActivityManager: com.android.settings is exempt from freezer
7878: 11-07 10:51:45.357   860  1384 D ActivityManager: PROFILE_FROM_SHELL is disabled for ProcessRecord{2f79bb7 0:com.android.settings/1000}
7884: 11-07 10:51:45.358   860   902 D ActivityManager: asking zygote to start proc:ProcessRecord{2f79bb7 0:com.android.settings/1000}
7900: 11-07 10:51:45.372   608   608 D Zygote  : Forked child process 15859
7902: 11-07 10:51:45.372   860   902 I ActivityManager: Start proc 15859:com.android.settings/1000 for restart com.android.settings
7904: 11-07 10:51:45.374 15859 15859 I Zygote  : seccomp disabled by setenforce 0
7965: 11-07 10:51:45.434 13777 14063 I WindowUtil: openPip(): show: false helpers.pipsAdded(): false Utils.topApp(): true AppPackageName.isEmpty() false helpers.isInWidgets() false helpers.isInAllApps() false helpers.isInOverviewMode() false helpers.isFirstPreferenceWindow() false helpers.allAppsVisibility() false helpers.isWallpaperW
7966: 11-07 10:51:45.435 13777 13777 D Launcher.Workspace: Persistent bottom bar window built, in standby (standby delay)
7969: 11-07 10:51:45.442 13777 14063 I WindowUtil: openPip() pane: dismissed
7970: 11-07 10:51:45.444 15690 15690 D MusicViz: VisualizerRenderer: stop thread
7983: 11-07 10:51:45.461 15690 15690 I wm_on_stop_called: [44732475,com.thf.dabplayer.activity.PlayerActivity,STOP_ACTIVITY_ITEM]
8015: 11-07 10:51:45.501   860  1387 V WindowState: toString mSurfaceNameCache= mLastTitle=null title=Sys2038:com.android.launcher66/com.android.launcher66.Launcher
8016: 11-07 10:51:45.501   860  1387 D CoreBackPreview: Window{4f698d9 u0 Sys2038:com.android.launcher66/com.android.launcher66.Launcher}: Setting back callback OnBackInvokedCallbackInfo{mCallback=android.window.IOnBackInvokedCallback$Stub$Proxy@45517f, mPriority=0}
8027: 11-07 10:51:45.522 13777 13777 D VRI[Launcher]: performTraversals relayoutWindow: maybeSyncSeqId=-1 ,mSyncSeqId=0 ,relayoutResult=3
8047: 11-07 10:51:45.543   860  3707 D WindowState: finishDrawing: syncSeqId=0, postDrawTransaction=android.view.SurfaceControl$Transaction@2dd9850, mSyncState=0, mDrawState=1, hasSyncHandlers=false, mClientWasDrawingForSync=false, win=Window{4f698d9 u0 Sys2038:com.android.launcher66/com.android.launcher66.Launcher}-[Surface(name=*Tit
8051: 11-07 10:51:45.550   698   698 I Layer   : fillInputInfo layer:Sys2038:com.android.launcher66/com.android.launcher66.Launcher#7363, visible=1 (hasInputInfo:1, isHidden:0, alpha:0.799805, mActiveBuffer:2), parent:4f698d9 Sys2038:com.android.launcher66/com.android.launcher66.Launcher#7362, parenthidden:0
8069: 11-07 10:51:45.569 13777 13777 D Launcher.Workspace: Widget bar refreshed after wake: persistent bar standby
8071: 11-07 10:51:45.570 13777 13777 I WindowUtil: pane launch set: first@0, second@1, third@1 (visible page 0)
8072: 11-07 10:51:45.570 13777 13777 I WindowUtil: pane launch: first (page 0, visible 0, 2 left)
8074: 11-07 10:51:45.572 13777 13777 I WindowHostSinglePane: First: window move animation off (privateFlags)
8078: 11-07 10:51:45.586   860  8511 V WindowState: toString mSurfaceNameCache= mLastTitle=null title=PipWindowHost:First
8079: 11-07 10:51:45.586   860  8511 D CoreBackPreview: Window{99e6205 u0 PipWindowHost:First}, [type=1000]: Setting back callback OnBackInvokedCallbackInfo{mCallback=android.window.IOnBackInvokedCallback$Stub$Proxy@df34c8b, mPriority=0}
8097: 11-07 10:51:45.610 13777 13777 D VRI[PipWindowHost:First]: performTraversals relayoutWindow: maybeSyncSeqId=-1 ,mSyncSeqId=0 ,relayoutResult=3
8103: 11-07 10:51:45.617   860   894 I DisplayDeviceRepository: Display device changed state: "WindowHostVd@265605953", ON
8108: 11-07 10:51:45.620   860   894 I InputManager-JNI: Viewport [1] --- add: virtual:com.android.shell,2000,WindowHostVd@265605953,0, isActive: true 1, ViewportType::3, viewport.displayId: 5
8109: 11-07 10:51:45.620   860   894 I InputManager-JNI: Viewport [2] --- add: virtual:com.android.shell,2000,WindowHostVd@62812274,0, isActive: false 1, ViewportType::3, viewport.displayId: 7
8110: 11-07 10:51:45.620   860   894 I InputManager-JNI: Viewport [3] --- add: virtual:com.android.shell,2000,WindowHostVd@207690327,0, isActive: false 1, ViewportType::3, viewport.displayId: 8
8120: 11-07 10:51:45.627  4740  4740 I wm_on_restart_called: [161950649,com.sygic.navi.map.MapActivity,performRestartActivity]
8123: 11-07 10:51:45.630  4740  4740 I wm_on_start_called: [161950649,com.sygic.navi.map.MapActivity,handleStartActivity]
8126: 11-07 10:51:45.633   860  3707 D WindowState: finishDrawing: syncSeqId=0, postDrawTransaction=android.view.SurfaceControl$Transaction@b3bccbd, mSyncState=0, mDrawState=1, hasSyncHandlers=false, mClientWasDrawingForSync=false, win=Window{99e6205 u0 PipWindowHost:First}, [type=1000]-[Surface(name=*Title#7365)/@0x6c2168]
8142: 11-07 10:51:45.651   698   698 I Layer   : fillInputInfo layer:PipWindowHost:First#7365, visible=1 (hasInputInfo:1, isHidden:0, alpha:1.000000, mActiveBuffer:2), parent:99e6205 PipWindowHost:First#7364, parenthidden:0
8144: 11-07 10:51:45.651   698   698 I Layer   : fillInputInfo layer:SurfaceView[PipWindowHost:First](BLAST)#7368, visible=1 (hasInputInfo:1, isHidden:0, alpha:1.000000, mActiveBuffer:0), parent:SurfaceView[PipWindowHost:First]#7367, parenthidden:0
8156: 11-07 10:51:45.655  4740  4740 I wm_on_resume_called: [161950649,com.sygic.navi.map.MapActivity,RESUME_ACTIVITY]
8163: 11-07 10:51:45.660   860  1383 D WindowState: finishDrawing: syncSeqId=0, postDrawTransaction=android.view.SurfaceControl$Transaction@aefb580, mSyncState=0, mDrawState=4, hasSyncHandlers=false, mClientWasDrawingForSync=false, win=Window{99e6205 u0 PipWindowHost:First}, [type=1000]-[Surface(name=*Title#7365)/@0x6c2168]
8164: 11-07 10:51:45.660   860  1383 D WindowStateAnimator: finishDrawingLocked: mDrawState=4 ,mLastHidden=false ,mShownAlpha=1.0 ,mLastAlpha=1.0 ,postDrawTransaction=android.view.SurfaceControl$Transaction@aefb580 ,mWin=Window{99e6205 u0 PipWindowHost:First}, [type=1000]-[Surface(name=*Title#7365)/@0x6c2168]
8165: 11-07 10:51:45.660   860  1383 D WindowStateAnimator: finishDrawingLocked: syncTransaction=android.view.SurfaceControl$Transaction@5f36d25 ,mSyncTransaction=android.view.SurfaceControl$Transaction@25d77b9 ,mWin=Window{99e6205 u0 PipWindowHost:First}, [type=1000]-[Surface(name=*Title#7365)/@0x6c2168]
8166: 11-07 10:51:45.661   860  2359 I am_create_service: [0,207268268,.SystemJobService,10141,4740]
8175: 11-07 10:51:45.674 13777 13777 D WindowUtil: Pane bounds pump started (panes launched)
8221: 11-07 10:51:45.696  1364 28218 E timer   : appName Launcher Mod
8222: 11-07 10:51:45.696  1364 28218 E hzq     : appName Launcher Mod
8280: 11-07 10:51:45.721 13777 13777 D WindowHostSinglePane: First: resizeVD OK -> 842x584 @160
9145: 11-07 10:51:45.822 13777 13777 D WindowUtil: pane launch: first up after 252 ms
9146: 11-07 10:51:45.822 13777 13777 I WindowUtil: pane launch: second (page 1, visible 0, 1 left)
9148: 11-07 10:51:45.823 13777 13777 I WindowUtil: second: show com.thf.dabplayer
9151: 11-07 10:51:45.837 13777 13777 I WindowHostSinglePane: Second: window move animation off (privateFlags)
9154: 11-07 10:51:45.842 15690 15690 D Dabdream: OverlayDls/showDls: duration=6000
9159: 11-07 10:51:45.849   860  2359 V WindowState: toString mSurfaceNameCache= mLastTitle=null title=PipWindowHost:Second
9160: 11-07 10:51:45.850   860  2359 D CoreBackPreview: Window{82964f1 u0 PipWindowHost:Second}, [type=1000]: Setting back callback OnBackInvokedCallbackInfo{mCallback=android.window.IOnBackInvokedCallback$Stub$Proxy@6117757, mPriority=0}
9161: 11-07 10:51:45.856 13777 13777 D WindowHostSplash: cover up: WindowHostSplash#cover com.thf.dabplayer
9174: 11-07 10:51:45.881 13777 13777 D VRI[PipWindowHost:Second]: performTraversals relayoutWindow: maybeSyncSeqId=-1 ,mSyncSeqId=0 ,relayoutResult=3
9184: 11-07 10:51:45.895   860   894 I DisplayDeviceRepository: Display device changed state: "WindowHostVd@207690327", ON
9186: 11-07 10:51:45.896 13777 13777 I WindowHostVdView: display 8 with com.thf.dabplayer taken over from the previous pane, no fresh display
9190: 11-07 10:51:45.896   860   894 I InputManager-JNI: Viewport [1] --- add: virtual:com.android.shell,2000,WindowHostVd@265605953,0, isActive: true 1, ViewportType::3, viewport.displayId: 5
9191: 11-07 10:51:45.896   860   894 I InputManager-JNI: Viewport [2] --- add: virtual:com.android.shell,2000,WindowHostVd@62812274,0, isActive: false 1, ViewportType::3, viewport.displayId: 7
9192: 11-07 10:51:45.896   860   894 I InputManager-JNI: Viewport [3] --- add: virtual:com.android.shell,2000,WindowHostVd@207690327,0, isActive: true 1, ViewportType::3, viewport.displayId: 8
9213: 11-07 10:51:45.912   860  1387 D WindowState: finishDrawing: syncSeqId=0, postDrawTransaction=android.view.SurfaceControl$Transaction@7b9ec6b, mSyncState=0, mDrawState=1, hasSyncHandlers=false, mClientWasDrawingForSync=false, win=Window{82964f1 u0 PipWindowHost:Second}, [type=1000]-[Surface(name=*Title#7378)/@0x41b7eb0]
9227: 11-07 10:51:45.923   698   698 I Layer   : fillInputInfo layer:PipWindowHost:Second#7378, visible=1 (hasInputInfo:1, isHidden:0, alpha:1.000000, mActiveBuffer:2), parent:82964f1 PipWindowHost:Second#7375, parenthidden:0
9228: 11-07 10:51:45.923   698   698 I Layer   : fillInputInfo layer:SurfaceView[PipWindowHost:Second](BLAST)#7381, visible=1 (hasInputInfo:1, isHidden:0, alpha:1.000000, mActiveBuffer:0), parent:SurfaceView[PipWindowHost:Second]#7380, parenthidden:0
9237: 11-07 10:51:45.928   860   878 D WindowState: finishDrawing: syncSeqId=0, postDrawTransaction=android.view.SurfaceControl$Transaction@5f473c8, mSyncState=0, mDrawState=4, hasSyncHandlers=false, mClientWasDrawingForSync=false, win=Window{82964f1 u0 PipWindowHost:Second}, [type=1000]-[Surface(name=*Title#7378)/@0x41b7eb0]
9238: 11-07 10:51:45.929   860   878 D WindowStateAnimator: finishDrawingLocked: mDrawState=4 ,mLastHidden=false ,mShownAlpha=1.0 ,mLastAlpha=1.0 ,postDrawTransaction=android.view.SurfaceControl$Transaction@5f473c8 ,mWin=Window{82964f1 u0 PipWindowHost:Second}, [type=1000]-[Surface(name=*Title#7378)/@0x41b7eb0]
9239: 11-07 10:51:45.929   860   878 D WindowStateAnimator: finishDrawingLocked: syncTransaction=android.view.SurfaceControl$Transaction@5f36d25 ,mSyncTransaction=android.view.SurfaceControl$Transaction@90c6c61 ,mWin=Window{82964f1 u0 PipWindowHost:Second}, [type=1000]-[Surface(name=*Title#7378)/@0x41b7eb0]
9241: 11-07 10:51:45.935   860   878 I ActivityTaskManager: START u0 {act=android.intent.action.MAIN cat=[android.intent.category.LAUNCHER] flg=0x34720000 pkg=com.thf.dabplayer cmp=com.thf.dabplayer/.activity.MainActivity} from uid 2000, pid 13859
9259: 11-07 10:51:45.959   860   878 I wm_set_resumed_activity: [0,com.thf.dabplayer/.activity.PlayerActivity,positionChildAt]
9260: 11-07 10:51:45.959   860   878 I wm_set_resumed_activity: [0,com.thf.dabplayer/.activity.PlayerActivity,reparent]
9262: 11-07 10:51:45.964   860   878 I wm_set_resumed_activity: [0,com.thf.dabplayer/.activity.PlayerActivity,positionChildAt]
9272: 11-07 10:51:45.966   860   878 I ActivityTaskManager: ->startActivity for ActivityRecord{e657de3 u0 com.thf.dabplayer/.activity.MainActivity} t101 d8} result:START_SUCCESS
9281: 11-07 10:51:45.969 13859 13928 I FytVdHost: startActivity ComponentInfo{com.thf.dabplayer/com.thf.dabplayer.activity.MainActivity} on display 8 -> 0
9282: 11-07 10:51:45.971 13777 13777 I WindowHostSinglePane: Second: start ok for com.thf.dabplayer
9285: 11-07 10:51:45.975 13777 13777 I wm_on_top_resumed_lost_called: [264133600,com.android.launcher66.Launcher,topStateChangedWhenResumed]
9293: 11-07 10:51:45.985 13777 13777 D WindowHostSinglePane: Second: resizeVD OK -> 428x584 @160
9373: 11-07 10:51:46.053 15690 15690 I wm_on_restart_called: [44732475,com.thf.dabplayer.activity.PlayerActivity,performRestartActivity]
9374: 11-07 10:51:46.053 15690 15690 I wm_on_start_called: [44732475,com.thf.dabplayer.activity.PlayerActivity,handleStartActivity]
9378: 11-07 10:51:46.057 15690 15690 D Dabdream: DabService/setPlayerHandler
9379: 11-07 10:51:46.058 15690 15690 D MusicViz: VisualizerRenderer: start thread
9380: 11-07 10:51:46.058 15690 15690 I wm_on_resume_called: [44732475,com.thf.dabplayer.activity.PlayerActivity,RESUME_ACTIVITY]
9407: 11-07 10:51:46.070 15690 15894 D MusicViz: TextureViewViz: custom shader available
9409: 11-07 10:51:46.071 15690 15690 I wm_on_paused_called: [44732475,com.thf.dabplayer.activity.PlayerActivity,performPause]
9413: 11-07 10:51:46.072 15690 15894 D MusicViz: TextureViewViz: scene=CustomScene
9417: 11-07 10:51:46.075   860  3708 W ActivityTaskManager: Tried to set launchTime (0) < mLastActivityLaunchTime (13236504)
9428: 11-07 10:51:46.088   860  3708 I wm_set_resumed_activity: [0,com.thf.dabplayer/.activity.MainActivity,minimalResumeActivityLocked]
9561: 11-07 10:51:46.219 15690 15690 D Dabdream: MainActivity/onCreate: board=uis7870sc_2h10 device=uis7870sc_2h10 release=13 product=uis7870sc_2h10_nosec app_version=26.10.20
9563: 11-07 10:51:46.219 15690 15690 D Dabdream: MainActivity/onCreate: started by=Intent { act=android.intent.action.MAIN cat=[android.intent.category.LAUNCHER] flg=0x34720000 pkg=com.thf.dabplayer cmp=com.thf.dabplayer/.activity.MainActivity }
9580: 11-07 10:51:46.225  2147  2717 E Qin     :  top Act from: ComponentInfo{com.thf.dabplayer/com.thf.dabplayer.activity.PlayerActivity}  to ComponentInfo{com.android.launcher66/com.android.launcher66.Launcher}
9589: 11-07 10:51:46.233  2147  2717 E Qin     :  newPackage =    ModuleSound.getInstance().isIgnored(newPackage) : false
9595: 11-07 10:51:46.234 32483   407 E main    : Message{module=0, code=138, ints=null, flts=null, strs=[com.android.launcher66, com.android.launcher66.Launcher]} true
9597: 11-07 10:51:46.237 15690 15690 I wm_on_create_called: [241532387,com.thf.dabplayer.activity.MainActivity,performCreate]
9598: 11-07 10:51:46.239 15690 15690 I wm_on_start_called: [241532387,com.thf.dabplayer.activity.MainActivity,handleStartActivity]
9599: 11-07 10:51:46.241   860  1383 I ActivityTaskManager: START u0 {flg=0x14000000 cmp=com.thf.dabplayer/.activity.PlayerActivity} from uid 10151, pid 15690
9600: 11-07 10:51:46.242   860  1383 I wm_finish_activity: [0,241532387,101,com.thf.dabplayer/.activity.MainActivity,clear-task-stack]
9611: 11-07 10:51:46.250 13777 13777 D WindowUtil: pane launch: second up after 427 ms
9612: 11-07 10:51:46.250 13777 13777 I WindowUtil: pane launch: third (page 1, visible 0, 0 left)
9613: 11-07 10:51:46.250 13777 13777 I WindowUtil: third: show org.prowl.torque
9616: 11-07 10:51:46.259 13777 13777 I WindowHostSinglePane: Third: window move animation off (privateFlags)
9626: 11-07 10:51:46.265   860  1383 I ActivityTaskManager: ->startActivity for ActivityRecord{b85723c u0 com.thf.dabplayer/.activity.PlayerActivity} result:START_DELIVERED_TO_TOP
9638: 11-07 10:51:46.283   860  1384 V WindowState: toString mSurfaceNameCache= mLastTitle=null title=PipWindowHost:Third
9639: 11-07 10:51:46.283   860  1384 D CoreBackPreview: Window{38dfc4b u0 PipWindowHost:Third}, [type=1000]: Setting back callback OnBackInvokedCallbackInfo{mCallback=android.window.IOnBackInvokedCallback$Stub$Proxy@6be1227, mPriority=0}
9657: 11-07 10:51:46.295   860  8511 W ActivityTaskManager: Duplicate finish request for r=ActivityRecord{e657de3 u0 com.thf.dabplayer/.activity.MainActivity} t101 d8 f}}
9658: 11-07 10:51:46.295 15690 15690 I wm_on_resume_called: [241532387,com.thf.dabplayer.activity.MainActivity,RESUME_ACTIVITY]
9662: 11-07 10:51:46.296 15690 15690 D AndroidRuntime: Shutting down VM
9664: 11-07 10:51:46.296 15690 15690 E AndroidRuntime: FATAL EXCEPTION: main
9665: 11-07 10:51:46.296 15690 15690 E AndroidRuntime: Process: com.thf.dabplayer, PID: 15690
9666: 11-07 10:51:46.296 15690 15690 E AndroidRuntime: java.lang.NullPointerException: Attempt to invoke virtual method 'android.view.View android.view.Window.getDecorView()' on a null object reference
9667: 11-07 10:51:46.296 15690 15690 E AndroidRuntime: 	at android.app.ActivityThread.handleResumeActivity(ActivityThread.java:5049)
9668: 11-07 10:51:46.296 15690 15690 E AndroidRuntime: 	at android.app.servertransaction.ResumeActivityItem.execute(ResumeActivityItem.java:54)
9669: 11-07 10:51:46.296 15690 15690 E AndroidRuntime: 	at android.app.servertransaction.ActivityTransactionItem.execute(ActivityTransactionItem.java:45)
9670: 11-07 10:51:46.296 15690 15690 E AndroidRuntime: 	at android.app.servertransaction.TransactionExecutor.executeLifecycleState(TransactionExecutor.java:178)
9671: 11-07 10:51:46.296 15690 15690 E AndroidRuntime: 	at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:99)
9672: 11-07 10:51:46.296 15690 15690 E AndroidRuntime: 	at android.app.ActivityThread$H.handleMessage(ActivityThread.java:2393)
9673: 11-07 10:51:46.296 15690 15690 E AndroidRuntime: 	at android.os.Handler.dispatchMessage(Handler.java:106)
9674: 11-07 10:51:46.296 15690 15690 E AndroidRuntime: 	at android.os.Looper.loopOnce(Looper.java:201)
9675: 11-07 10:51:46.296 15690 15690 E AndroidRuntime: 	at android.os.Looper.loop(Looper.java:288)
9676: 11-07 10:51:46.296 15690 15690 E AndroidRuntime: 	at android.app.ActivityThread.main(ActivityThread.java:8073)
9677: 11-07 10:51:46.296 15690 15690 E AndroidRuntime: 	at java.lang.reflect.Method.invoke(Native Method)
9678: 11-07 10:51:46.296 15690 15690 E AndroidRuntime: 	at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:703)
9679: 11-07 10:51:46.296 15690 15690 E AndroidRuntime: 	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:911)
9681: 11-07 10:51:46.300   860  1383 I am_crash: [15690,0,com.thf.dabplayer,550026820,java.lang.NullPointerException,Attempt to invoke virtual method 'android.view.View android.view.Window.getDecorView()' on a null object reference,ActivityThread.java,5049]
9683: 11-07 10:51:46.301   860  1383 W ActivityTaskManager:   Force finishing activity com.thf.dabplayer/.activity.PlayerActivity
9684: 11-07 10:51:46.301   860  1383 I wm_finish_activity: [0,44732475,101,com.thf.dabplayer/.activity.PlayerActivity,force-crash]
9686: 11-07 10:51:46.302   860  1191 I input_focus: [Focus entering 65ac00d com.android.launcher66/com.android.launcher66.Launcher (server),reason=lsec]
9687: 11-07 10:51:46.302   860  1383 I wm_set_resumed_activity: [0,com.android.launcher66/.Launcher,positionChildAt]
9688: 11-07 10:51:46.302   860  1383 I wm_set_resumed_activity: [0,com.android.launcher66/.Launcher,finish-top]
9694: 11-07 10:51:46.306 15690 15690 I Process : Sending signal. PID: 15690 SIG: 9
9703: 11-07 10:51:46.310 13777 13777 D WindowHostSplash: cover up: WindowHostSplash#cover org.prowl.torque
9711: 11-07 10:51:46.320 13777 13777 D VRI[PipWindowHost:Third]: performTraversals relayoutWindow: maybeSyncSeqId=-1 ,mSyncSeqId=0 ,relayoutResult=3
9712: 11-07 10:51:46.321   860  8511 I am_create_service: [0,221941307,.PersistentIntentOperationService,10093,11866]
9733: 11-07 10:51:46.343   860   894 I DisplayDeviceRepository: Display device changed state: "WindowHostVd@62812274", ON
9739: 11-07 10:51:46.345   860   894 I InputManager-JNI: Viewport [1] --- add: virtual:com.android.shell,2000,WindowHostVd@265605953,0, isActive: true 1, ViewportType::3, viewport.displayId: 5
9740: 11-07 10:51:46.345   860   894 I InputManager-JNI: Viewport [2] --- add: virtual:com.android.shell,2000,WindowHostVd@62812274,0, isActive: true 1, ViewportType::3, viewport.displayId: 7
9741: 11-07 10:51:46.345   860   894 I InputManager-JNI: Viewport [3] --- add: virtual:com.android.shell,2000,WindowHostVd@207690327,0, isActive: true 1, ViewportType::3, viewport.displayId: 8
9743: 11-07 10:51:46.345 13777 13777 I WindowHostVdView: display 7 with org.prowl.torque taken over from the previous pane, no fresh display
9776: 11-07 10:51:46.363   860  8511 I am_create_service: [0,35487981,.DropBoxEntryAddedService,10093,11866]
9778: 11-07 10:51:46.368   860   878 D WindowState: finishDrawing: syncSeqId=0, postDrawTransaction=android.view.SurfaceControl$Transaction@8264b22, mSyncState=0, mDrawState=1, hasSyncHandlers=false, mClientWasDrawingForSync=false, win=Window{38dfc4b u0 PipWindowHost:Third}, [type=1000]-[Surface(name=*Title#7390)/@0x7c4ecca]
9782: 11-07 10:51:46.370   640 12522 I Codec2-Component@1.1: Client died ! release the component !!
9789: 11-07 10:51:46.371   640 12522 I C2UnisocMp3Dec: in DestroyCodec2Factory
9791: 11-07 10:51:46.379   698   698 I Layer   : fillInputInfo layer:PipWindowHost:Third#7390, visible=1 (hasInputInfo:1, isHidden:0, alpha:1.000000, mActiveBuffer:2), parent:38dfc4b PipWindowHost:Third#7389, parenthidden:0
9792: 11-07 10:51:46.379   698   698 I Layer   : fillInputInfo layer:SurfaceView[PipWindowHost:Third](BLAST)#7393, visible=1 (hasInputInfo:1, isHidden:0, alpha:1.000000, mActiveBuffer:0), parent:SurfaceView[PipWindowHost:Third]#7392, parenthidden:0
9797: 11-07 10:51:46.386   860  1383 I ActivityManager: Process com.thf.dabplayer (pid 15690) has died: fg  TOP
9798: 11-07 10:51:46.386   608   608 I Zygote  : Process 15690 exited due to signal 9 (Killed)
9800: 11-07 10:51:46.387   860  1383 I am_proc_died: [0,15690,com.thf.dabplayer,0,2]
9801: 11-07 10:51:46.387   860 10120 D MediaSessionService: Media button session is changed to null
9802: 11-07 10:51:46.388   860  3095 I MediaFocusControl: AudioFocus  removeFocusStackEntryOnDeath(): removing entry for android.os.BinderProxy@17e89b3
9811: 11-07 10:51:46.396   860  1383 W ActivityManager: Scheduling restart of crashed service com.thf.dabplayer/.service.DabService in 1000ms for start-requested
9812: 11-07 10:51:46.396   860  1383 I am_schedule_service_restart: [0,com.thf.dabplayer/.service.DabService,1000]
9841: 11-07 10:51:46.417  5013  5013 I wm_on_restart_called: [224056078,org.prowl.torque.Torque,performRestartActivity]
9842: 11-07 10:51:46.417  5013  5013 I wm_on_start_called: [224056078,org.prowl.torque.Torque,handleStartActivity]
9843: 11-07 10:51:46.419   860  8511 D WindowState: finishDrawing: syncSeqId=0, postDrawTransaction=android.view.SurfaceControl$Transaction@65d06cc, mSyncState=0, mDrawState=4, hasSyncHandlers=false, mClientWasDrawingForSync=false, win=Window{38dfc4b u0 PipWindowHost:Third}, [type=1000]-[Surface(name=*Title#7390)/@0x7c4ecca]
9844: 11-07 10:51:46.419   860  8511 D WindowStateAnimator: finishDrawingLocked: mDrawState=4 ,mLastHidden=false ,mShownAlpha=1.0 ,mLastAlpha=1.0 ,postDrawTransaction=android.view.SurfaceControl$Transaction@65d06cc ,mWin=Window{38dfc4b u0 PipWindowHost:Third}, [type=1000]-[Surface(name=*Title#7390)/@0x7c4ecca]
9845: 11-07 10:51:46.419   860  8511 D WindowStateAnimator: finishDrawingLocked: syncTransaction=android.view.SurfaceControl$Transaction@5f36d25 ,mSyncTransaction=android.view.SurfaceControl$Transaction@b763d15 ,mWin=Window{38dfc4b u0 PipWindowHost:Third}, [type=1000]-[Surface(name=*Title#7390)/@0x7c4ecca]
9857: 11-07 10:51:46.436 13777 13777 I WindowHostVdView: org.prowl.torque already runs on display 7, not started again
9858: 11-07 10:51:46.436 13777 13777 I WindowHostSinglePane: Third: start ok for org.prowl.torque
9859: 11-07 10:51:46.437 13777 13777 D WindowHostSinglePane: Third: resizeVD OK -> 841x584 @160
9880: 11-07 10:51:46.447  1984  1984 W e0      : 	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:911)
9895: 11-07 10:51:46.463   860   894 W ActivityManager: setHasOverlayUi called on unknown pid: 15690
9897: 11-07 10:51:46.464  5013  5013 I wm_on_resume_called: [224056078,org.prowl.torque.Torque,RESUME_ACTIVITY]
9909: 11-07 10:51:46.479   860   894 W ActivityManager: setHasOverlayUi called on unknown pid: 15690
9910: 11-07 10:51:46.479   693  1050 I APM_AudioPolicyManager: stopOutput portId 273
9911: 11-07 10:51:46.479   693  1050 I AudioPolicyManagerCustomBase: stopOutputSetInt portId 273
9912: 11-07 10:51:46.479   693  1050 I AudioPolicyManagerCustomBase: stopOutputSetInt out portId 273
9913: 11-07 10:51:46.479   693  1050 I APM_AudioPolicyManager: stopOutput() output 13, stream 3, session 1905
9921: 11-07 10:51:46.481   693  1050 I AudioPolicyManagerCustomBase: stopOutputSetEnd portId 273
9922: 11-07 10:51:46.481   693  1050 I AudioPolicyManagerCustomBase: stopOutputSetEnd out portId 273
9931: 11-07 10:51:46.494 13777 13777 D WindowHostSplash: cover down: WindowHostSplash#cover com.thf.dabplayer
10078: 11-07 10:51:46.763   860   894 W ActivityTaskManager: Activity top resumed state loss timeout for ActivityRecord{e657de3 u0 com.thf.dabplayer/.activity.MainActivity} t-1 d8 f}}
10080: 11-07 10:51:46.769 13777 13777 I wm_on_top_resumed_gained_called: [264133600,com.android.launcher66.Launcher,topStateChangedWhenResumed]
10081: 11-07 10:51:46.770 13777 13777 I WindowHostAvReaper: retire enter id=198695531
10082: 11-07 10:51:46.770 13777 13777 I WindowHostAvReaper: releaseNow id=198695531 displayId=-1 reason=no virtual display
10083: 11-07 10:51:46.770 13777 13777 I WindowHostAvReaper: released retired ActivityView (displayId=-1, no virtual display)
10084: 11-07 10:51:46.770 13777 13777 I WindowHostAvReaper: retire enter id=3601775
10085: 11-07 10:51:46.770 13777 13777 I WindowHostAvReaper: releaseNow id=3601775 displayId=-1 reason=no virtual display
10086: 11-07 10:51:46.771 13777 13777 I WindowHostAvReaper: released retired ActivityView (displayId=-1, no virtual display)
10087: 11-07 10:51:46.771 13777 13777 I WindowHostAvReaper: retire enter id=49682527
10088: 11-07 10:51:46.771 13777 13777 I WindowHostAvReaper: releaseNow id=49682527 displayId=-1 reason=no virtual display
10089: 11-07 10:51:46.771 13777 13777 I WindowHostAvReaper: released retired ActivityView (displayId=-1, no virtual display)
10110: 11-07 10:51:46.832 13777 13777 D WindowHostSplash: cover down: WindowHostSplash#cover org.prowl.torque
```

#### 3.3 Próba 3, plik A (10:52:00)

Źródło: `cade8856-user_full_07-11-2026_10-51-34_dabdream_stop_after_ging_home.txt`, okno 10:51:59.8–10:52:02.0, 225 linii (numer: oryginalna linia).

```
16723: 11-07 10:51:59.828  1364  1364 I KeyButtonView: ====ACTION_DOWN====3
16724: 11-07 10:51:59.828  1364  1364 I KeyButtonView: ====----sendEvent----==1==0
16726: 11-07 10:51:59.828  1364  1364 I KeyButtonView: ====----sendEvent----==2==0
16727: 11-07 10:51:59.828  1364  1364 I KeyButtonView: ====----sendEvent----==3==0
16728: 11-07 10:51:59.828  1364  1364 I KeyButtonView: ====----sendEvent----==4==0
16729: 11-07 10:51:59.828  1364  1364 I KeyButtonView: ====----sendEvent----==5==0
16730: 11-07 10:51:59.828  1364  1364 I KeyButtonView: ====----sendEvent----==6==0
16731: 11-07 10:51:59.828  1364  1364 I KeyButtonView: sendEvent -------------------return 14735
16749: 11-07 10:51:59.896  1364  1364 I KeyButtonView: ====----ACTION_UP----====3
16750: 11-07 10:51:59.897  1364  1364 I KeyButtonView: ====----ACTION_UP----==1==
16751: 11-07 10:51:59.898  1364  1364 I KeyButtonView: ====----sendEvent----==1==1
16753: 11-07 10:51:59.898  1364  1364 I KeyButtonView: ====----sendEvent----==2==1
16754: 11-07 10:51:59.898  1364  1364 I KeyButtonView: ====----sendEvent----==3==1
16755: 11-07 10:51:59.898  1364  1364 I KeyButtonView: ====----sendEvent----==4==1
16756: 11-07 10:51:59.898  1364  1364 I KeyButtonView: ====----sendEvent----==5==1
16757: 11-07 10:51:59.899  1364  1364 I KeyButtonView: ====----sendEvent----==6==1
16758: 11-07 10:51:59.899  1364  1364 I KeyButtonView: ====----sendEvent----==7==1
16759: 11-07 10:51:59.899  1364  1364 I KeyButtonView: sendEvent  mCode=3,pre=13259114,action=1
16766: 11-07 10:51:59.908   860   892 I ActivityTaskManager: START u0 {act=android.intent.action.MAIN cat=[android.intent.category.HOME] flg=0x10000100 cmp=com.android.launcher66/.Launcher (has extras)} from uid 0, pid 0
16788: 11-07 10:51:59.913   860   892 I wm_set_resumed_activity: [0,com.android.launcher66/.Launcher,bringingFoundTaskToFront]
16789: 11-07 10:51:59.914   860   892 I wm_new_intent: [0,264133600,99,com.android.launcher66/.Launcher,android.intent.action.MAIN,NULL,NULL,268435712]
16790: 11-07 10:51:59.914 15916 15916 I wm_on_top_resumed_lost_called: [100003047,com.thf.dabplayer.activity.PlayerActivity,topStateChangedWhenResumed]
16794: 11-07 10:51:59.915   860   892 I ActivityTaskManager: ->startActivity for ActivityRecord{c3b38be u0 com.android.launcher66/.Launcher} result:START_TASK_TO_FRONT
16797: 11-07 10:51:59.919 15916 15916 I wm_on_paused_called: [100003047,com.thf.dabplayer.activity.PlayerActivity,performPause]
16804: 11-07 10:51:59.923   860  2373 I wm_set_resumed_activity: [0,com.android.launcher66/.Launcher,resumeTopActivity]
16813: 11-07 10:51:59.947   860  2373 I wm_resume_activity: [0,264133600,99,com.android.launcher66/.Launcher]
16815: 11-07 10:51:59.950 13777 13777 I wm_on_restart_called: [264133600,com.android.launcher66.Launcher,performRestartActivity]
16816: 11-07 10:51:59.951 13777 13777 D Launcher: ---->>> onStart
16817: 11-07 10:51:59.951 13777 13777 I wm_on_start_called: [264133600,com.android.launcher66.Launcher,handleStartActivity]
16822: 11-07 10:51:59.958 13777 13777 D Launcher: onResume----->
16831: 11-07 10:51:59.976 13777 13777 I wm_on_resume_called: [264133600,com.android.launcher66.Launcher,RESUME_ACTIVITY]
16832: 11-07 10:51:59.976 13777 13777 I wm_on_top_resumed_gained_called: [264133600,com.android.launcher66.Launcher,topWhenResuming]
16836: 11-07 10:51:59.987   860   895 I input_focus: [Focus request 65ac00d com.android.launcher66/com.android.launcher66.Launcher,reason=UpdateInputWindows]
16837: 11-07 10:51:59.988 13777 13777 D VRI[Launcher]: performTraversals relayoutWindow: maybeSyncSeqId=-1 ,mSyncSeqId=0 ,relayoutResult=3
16848: 11-07 10:51:59.996 13777 13777 D Launcher: onStart: registering dynamic receiver
16849: 11-07 10:51:59.996   860  1384 D WindowState: finishDrawing: syncSeqId=0, postDrawTransaction=android.view.SurfaceControl$Transaction@c212ce9, mSyncState=0, mDrawState=1, hasSyncHandlers=false, mClientWasDrawingForSync=false, win=Window{65ac00d u0 com.android.launcher66/com.android.launcher66.Launcher}-[Surface(name=*Title#7451)
16854: 11-07 10:52:00.001 13777 13777 D Launcher: -------->>> FinalRadio.U_BAND65536
16855: 11-07 10:52:00.001 13777 13777 D Launcher: -------->>> FinalRadio.U_BAND65536
16882: 11-07 10:52:00.034   860   891 I sysui_multi_action: [319,125,322,96,325,13259,757,761,758,9,759,2,806,com.android.launcher66,871,com.android.launcher66.Launcher,905,0,1320,12,1321,1]
16915: 11-07 10:52:00.049   698   698 I Layer   : fillInputInfo layer:com.android.launcher66/com.android.launcher66.Launcher#7451, visible=1 (hasInputInfo:1, isHidden:0, alpha:1.000000, mActiveBuffer:2), parent:65ac00d com.android.launcher66/com.android.launcher66.Launcher#7057, parenthidden:0
16924: 11-07 10:52:00.051   860  1191 I input_focus: [Focus entering 65ac00d com.android.launcher66/com.android.launcher66.Launcher (server),reason=Window became focusable. Previous reason: NOT_VISIBLE]
16962: 11-07 10:52:00.067  1984  1984 W e0      : 	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:911)
16983: 11-07 10:52:00.107 15859 15859 I AndroidRuntime: VM exiting with result code 0, cleanup skipped.
17002: 11-07 10:52:00.135   608   608 I Zygote  : Process 15859 exited cleanly (0)
17003: 11-07 10:52:00.136   860  2360 I ActivityManager: Process com.android.settings (pid 15859) has died: fg  IMPB
17004: 11-07 10:52:00.136   860  2360 I am_proc_died: [0,15859,com.android.settings,0,7]
17008: 11-07 10:52:00.142   860  2360 D ActivityManager: cleanUpApplicationRecordLocked, remove provider timeout msg, app: ProcessRecord{2f79bb7 15859:com.android.settings/1000}
17011: 11-07 10:52:00.145   860  2360 I ActivityManager: com.android.settings is exempt from freezer
17012: 11-07 10:52:00.145   860  2360 D ActivityManager: PROFILE_FROM_SHELL is disabled for ProcessRecord{2f79bb7 0:com.android.settings/1000}
17017: 11-07 10:52:00.150   860   902 D ActivityManager: asking zygote to start proc:ProcessRecord{2f79bb7 0:com.android.settings/1000}
17025: 11-07 10:52:00.161   608   608 D Zygote  : Forked child process 16098
17026: 11-07 10:52:00.164 16098 16098 I Zygote  : seccomp disabled by setenforce 0
17028: 11-07 10:52:00.166   860   902 I ActivityManager: Start proc 16098:com.android.settings/1000 for restart com.android.settings
17078: 11-07 10:52:00.213 13777 14930 I WindowUtil: openPip(): show: false helpers.pipsAdded(): false Utils.topApp(): true AppPackageName.isEmpty() false helpers.isInWidgets() false helpers.isInAllApps() false helpers.isInOverviewMode() false helpers.isFirstPreferenceWindow() false helpers.allAppsVisibility() false helpers.isWallpaperW
17079: 11-07 10:52:00.213 15916 15916 D MusicViz: VisualizerRenderer: stop thread
17083: 11-07 10:52:00.215 13777 13777 D Launcher.Workspace: Persistent bottom bar window built, in standby (standby delay)
17102: 11-07 10:52:00.227 13777 14930 I WindowUtil: openPip() pane: dismissed
17108: 11-07 10:52:00.230 15916 15916 I wm_on_stop_called: [100003047,com.thf.dabplayer.activity.PlayerActivity,STOP_ACTIVITY_ITEM]
17156: 11-07 10:52:00.274   860  3719 V WindowState: toString mSurfaceNameCache= mLastTitle=null title=Sys2038:com.android.launcher66/com.android.launcher66.Launcher
17157: 11-07 10:52:00.274   860  3719 D CoreBackPreview: Window{cfef882 u0 Sys2038:com.android.launcher66/com.android.launcher66.Launcher}: Setting back callback OnBackInvokedCallbackInfo{mCallback=android.window.IOnBackInvokedCallback$Stub$Proxy@fa81ace, mPriority=0}
17178: 11-07 10:52:00.304 13777 13777 D VRI[Launcher]: performTraversals relayoutWindow: maybeSyncSeqId=-1 ,mSyncSeqId=0 ,relayoutResult=3
17210: 11-07 10:52:00.334   860  1332 D WindowState: finishDrawing: syncSeqId=0, postDrawTransaction=android.view.SurfaceControl$Transaction@c507e3d, mSyncState=0, mDrawState=1, hasSyncHandlers=false, mClientWasDrawingForSync=false, win=Window{cfef882 u0 Sys2038:com.android.launcher66/com.android.launcher66.Launcher}-[Surface(name=*Tit
17243: 11-07 10:52:00.351   698   698 I Layer   : fillInputInfo layer:Sys2038:com.android.launcher66/com.android.launcher66.Launcher#7459, visible=1 (hasInputInfo:1, isHidden:0, alpha:0.799805, mActiveBuffer:2), parent:cfef882 Sys2038:com.android.launcher66/com.android.launcher66.Launcher#7458, parenthidden:0
17252: 11-07 10:52:00.359 13777 13777 D Launcher.Workspace: Widget bar refreshed after wake: persistent bar standby
17254: 11-07 10:52:00.360 13777 13777 I WindowUtil: pane launch set: first@0, second@1, third@1 (visible page 0)
17255: 11-07 10:52:00.360 13777 13777 I WindowUtil: pane launch: first (page 0, visible 0, 2 left)
17259: 11-07 10:52:00.361 13777 13777 I WindowHostSinglePane: First: window move animation off (privateFlags)
17270: 11-07 10:52:00.375   860  2373 V WindowState: toString mSurfaceNameCache= mLastTitle=null title=PipWindowHost:First
17271: 11-07 10:52:00.375   860  2373 D CoreBackPreview: Window{abca0df u0 PipWindowHost:First}, [type=1000]: Setting back callback OnBackInvokedCallbackInfo{mCallback=android.window.IOnBackInvokedCallback$Stub$Proxy@f1e37f5, mPriority=0}
17279: 11-07 10:52:00.394 13777 13777 D VRI[PipWindowHost:First]: performTraversals relayoutWindow: maybeSyncSeqId=-1 ,mSyncSeqId=0 ,relayoutResult=3
17280: 11-07 10:52:00.399   860   894 I DisplayDeviceRepository: Display device changed state: "WindowHostVd@265605953", ON
17284: 11-07 10:52:00.400   860   894 I InputManager-JNI: Viewport [1] --- add: virtual:com.android.shell,2000,WindowHostVd@265605953,0, isActive: true 1, ViewportType::3, viewport.displayId: 5
17285: 11-07 10:52:00.400   860   894 I InputManager-JNI: Viewport [2] --- add: virtual:com.android.shell,2000,WindowHostVd@62812274,0, isActive: false 1, ViewportType::3, viewport.displayId: 7
17286: 11-07 10:52:00.400   860   894 I InputManager-JNI: Viewport [3] --- add: virtual:com.android.shell,2000,WindowHostVd@207690327,0, isActive: false 1, ViewportType::3, viewport.displayId: 8
17301: 11-07 10:52:00.417   860  3721 D WindowState: finishDrawing: syncSeqId=0, postDrawTransaction=android.view.SurfaceControl$Transaction@113ccd7, mSyncState=0, mDrawState=1, hasSyncHandlers=false, mClientWasDrawingForSync=false, win=Window{abca0df u0 PipWindowHost:First}, [type=1000]-[Surface(name=*Title#7461)/@0x168a98a]
17303: 11-07 10:52:00.420  4740  4740 I wm_on_restart_called: [161950649,com.sygic.navi.map.MapActivity,performRestartActivity]
17306: 11-07 10:52:00.424  4740  4740 I wm_on_start_called: [161950649,com.sygic.navi.map.MapActivity,handleStartActivity]
17313: 11-07 10:52:00.435   698   698 I Layer   : fillInputInfo layer:PipWindowHost:First#7461, visible=1 (hasInputInfo:1, isHidden:0, alpha:1.000000, mActiveBuffer:2), parent:abca0df PipWindowHost:First#7460, parenthidden:0
17314: 11-07 10:52:00.436   698   698 I Layer   : fillInputInfo layer:SurfaceView[PipWindowHost:First](BLAST)#7464, visible=1 (hasInputInfo:1, isHidden:0, alpha:1.000000, mActiveBuffer:0), parent:SurfaceView[PipWindowHost:First]#7463, parenthidden:0
17323: 11-07 10:52:00.442  4740  4740 I wm_on_resume_called: [161950649,com.sygic.navi.map.MapActivity,RESUME_ACTIVITY]
17336: 11-07 10:52:00.446   860  1332 D WindowState: finishDrawing: syncSeqId=0, postDrawTransaction=android.view.SurfaceControl$Transaction@c4270ad, mSyncState=0, mDrawState=4, hasSyncHandlers=false, mClientWasDrawingForSync=false, win=Window{abca0df u0 PipWindowHost:First}, [type=1000]-[Surface(name=*Title#7461)/@0x168a98a]
17337: 11-07 10:52:00.446   860  1332 D WindowStateAnimator: finishDrawingLocked: mDrawState=4 ,mLastHidden=false ,mShownAlpha=1.0 ,mLastAlpha=1.0 ,postDrawTransaction=android.view.SurfaceControl$Transaction@c4270ad ,mWin=Window{abca0df u0 PipWindowHost:First}, [type=1000]-[Surface(name=*Title#7461)/@0x168a98a]
17338: 11-07 10:52:00.446   860  1332 D WindowStateAnimator: finishDrawingLocked: syncTransaction=android.view.SurfaceControl$Transaction@5f36d25 ,mSyncTransaction=android.view.SurfaceControl$Transaction@96cdfe2 ,mWin=Window{abca0df u0 PipWindowHost:First}, [type=1000]-[Surface(name=*Title#7461)/@0x168a98a]
17354: 11-07 10:52:00.465   860  1383 I am_create_service: [0,246775759,.SystemJobService,10141,4740]
17357: 11-07 10:52:00.466 13777 13777 D WindowUtil: Pane bounds pump started (panes launched)
17389: 11-07 10:52:00.504 13777 13777 D WindowHostSinglePane: First: resizeVD OK -> 842x584 @160
18257: 11-07 10:52:00.629 13777 13777 D WindowUtil: pane launch: first up after 268 ms
18258: 11-07 10:52:00.629 13777 13777 I WindowUtil: pane launch: second (page 1, visible 0, 1 left)
18259: 11-07 10:52:00.629 13777 13777 I WindowUtil: second: show com.thf.dabplayer
18261: 11-07 10:52:00.638 13777 13777 I WindowHostSinglePane: Second: window move animation off (privateFlags)
18269: 11-07 10:52:00.642 15916 15916 D Dabdream: OverlayDls/showDls: duration=6000
18281: 11-07 10:52:00.656   860  3721 V WindowState: toString mSurfaceNameCache= mLastTitle=null title=PipWindowHost:Second
18282: 11-07 10:52:00.656   860  3721 D CoreBackPreview: Window{bb449eb u0 PipWindowHost:Second}, [type=1000]: Setting back callback OnBackInvokedCallbackInfo{mCallback=android.window.IOnBackInvokedCallback$Stub$Proxy@1fbc5e1, mPriority=0}
18293: 11-07 10:52:00.668 13777 13777 D WindowHostSplash: cover up: WindowHostSplash#cover com.thf.dabplayer
18308: 11-07 10:52:00.694 13777 13777 D VRI[PipWindowHost:Second]: performTraversals relayoutWindow: maybeSyncSeqId=-1 ,mSyncSeqId=0 ,relayoutResult=3
18313: 11-07 10:52:00.706   860   894 I DisplayDeviceRepository: Display device changed state: "WindowHostVd@207690327", ON
18314: 11-07 10:52:00.706 13777 13777 I WindowHostVdView: display 8 with com.thf.dabplayer taken over from the previous pane, no fresh display
18316: 11-07 10:52:00.707   860   894 I InputManager-JNI: Viewport [1] --- add: virtual:com.android.shell,2000,WindowHostVd@265605953,0, isActive: true 1, ViewportType::3, viewport.displayId: 5
18317: 11-07 10:52:00.707   860   894 I InputManager-JNI: Viewport [2] --- add: virtual:com.android.shell,2000,WindowHostVd@62812274,0, isActive: false 1, ViewportType::3, viewport.displayId: 7
18318: 11-07 10:52:00.707   860   894 I InputManager-JNI: Viewport [3] --- add: virtual:com.android.shell,2000,WindowHostVd@207690327,0, isActive: true 1, ViewportType::3, viewport.displayId: 8
18353: 11-07 10:52:00.720  1364 28218 E timer   : appName Launcher Mod
18354: 11-07 10:52:00.720  1364 28218 E hzq     : appName Launcher Mod
18359: 11-07 10:52:00.727   860  3719 D WindowState: finishDrawing: syncSeqId=0, postDrawTransaction=android.view.SurfaceControl$Transaction@bf3b4ea, mSyncState=0, mDrawState=1, hasSyncHandlers=false, mClientWasDrawingForSync=false, win=Window{bb449eb u0 PipWindowHost:Second}, [type=1000]-[Surface(name=*Title#7474)/@0x3d10592]
18400: 11-07 10:52:00.741   698   698 I Layer   : fillInputInfo layer:PipWindowHost:Second#7474, visible=1 (hasInputInfo:1, isHidden:0, alpha:1.000000, mActiveBuffer:2), parent:bb449eb PipWindowHost:Second#7471, parenthidden:0
18401: 11-07 10:52:00.741   698   698 I Layer   : fillInputInfo layer:SurfaceView[PipWindowHost:Second](BLAST)#7477, visible=1 (hasInputInfo:1, isHidden:0, alpha:1.000000, mActiveBuffer:0), parent:SurfaceView[PipWindowHost:Second]#7476, parenthidden:0
18416: 11-07 10:52:00.751   860  3720 D WindowState: finishDrawing: syncSeqId=0, postDrawTransaction=android.view.SurfaceControl$Transaction@1d035b6, mSyncState=0, mDrawState=4, hasSyncHandlers=false, mClientWasDrawingForSync=false, win=Window{bb449eb u0 PipWindowHost:Second}, [type=1000]-[Surface(name=*Title#7474)/@0x3d10592]
18417: 11-07 10:52:00.751   860  3720 D WindowStateAnimator: finishDrawingLocked: mDrawState=4 ,mLastHidden=false ,mShownAlpha=1.0 ,mLastAlpha=1.0 ,postDrawTransaction=android.view.SurfaceControl$Transaction@1d035b6 ,mWin=Window{bb449eb u0 PipWindowHost:Second}, [type=1000]-[Surface(name=*Title#7474)/@0x3d10592]
18418: 11-07 10:52:00.751   860  3720 D WindowStateAnimator: finishDrawingLocked: syncTransaction=android.view.SurfaceControl$Transaction@5f36d25 ,mSyncTransaction=android.view.SurfaceControl$Transaction@6c882b7 ,mWin=Window{bb449eb u0 PipWindowHost:Second}, [type=1000]-[Surface(name=*Title#7474)/@0x3d10592]
18445: 11-07 10:52:00.776   860  1334 I ActivityTaskManager: START u0 {act=android.intent.action.MAIN cat=[android.intent.category.LAUNCHER] flg=0x34720000 pkg=com.thf.dabplayer cmp=com.thf.dabplayer/.activity.MainActivity} from uid 2000, pid 13859
18453: 11-07 10:52:00.787 15916 15916 I wm_on_restart_called: [100003047,com.thf.dabplayer.activity.PlayerActivity,performRestartActivity]
18454: 11-07 10:52:00.787 15916 15916 I wm_on_start_called: [100003047,com.thf.dabplayer.activity.PlayerActivity,handleStartActivity]
18469: 11-07 10:52:00.794 15916 15916 D Dabdream: DabService/setPlayerHandler
18471: 11-07 10:52:00.796   860  1334 I wm_set_resumed_activity: [0,com.thf.dabplayer/.activity.PlayerActivity,positionChildAt]
18472: 11-07 10:52:00.796   860  1334 I wm_set_resumed_activity: [0,com.thf.dabplayer/.activity.PlayerActivity,reparent]
18476: 11-07 10:52:00.798 15916 15916 D MusicViz: VisualizerRenderer: start thread
18478: 11-07 10:52:00.798 15916 15916 I wm_on_resume_called: [100003047,com.thf.dabplayer.activity.PlayerActivity,RESUME_ACTIVITY]
18485: 11-07 10:52:00.806   860  1334 I wm_set_resumed_activity: [0,com.thf.dabplayer/.activity.PlayerActivity,positionChildAt]
18506: 11-07 10:52:00.807   860  1334 I ActivityTaskManager: ->startActivity for ActivityRecord{fdb2c9a u0 com.thf.dabplayer/.activity.MainActivity} t102 d8} result:START_SUCCESS
18518: 11-07 10:52:00.810 13859 13884 I FytVdHost: startActivity ComponentInfo{com.thf.dabplayer/com.thf.dabplayer.activity.MainActivity} on display 8 -> 0
18521: 11-07 10:52:00.811 13777 13777 I WindowHostSinglePane: Second: start ok for com.thf.dabplayer
18524: 11-07 10:52:00.811 15916 16129 D MusicViz: TextureViewViz: custom shader available
18525: 11-07 10:52:00.812 13777 13777 D WindowHostSinglePane: Second: resizeVD OK -> 428x584 @160
18526: 11-07 10:52:00.813 13777 13777 I wm_on_top_resumed_lost_called: [264133600,com.android.launcher66.Launcher,topStateChangedWhenResumed]
18531: 11-07 10:52:00.816 15916 16129 D MusicViz: TextureViewViz: scene=CustomScene
18605: 11-07 10:52:00.915  2147  2717 E Qin     :  top Act from: ComponentInfo{com.thf.dabplayer/com.thf.dabplayer.activity.PlayerActivity}  to ComponentInfo{com.android.launcher66/com.android.launcher66.Launcher}
18606: 11-07 10:52:00.921  2147  2717 E Qin     :  newPackage =    ModuleSound.getInstance().isIgnored(newPackage) : false
18608: 11-07 10:52:00.924 32483 32495 E main    : Message{module=0, code=138, ints=null, flts=null, strs=[com.android.launcher66, com.android.launcher66.Launcher]} true
18630: 11-07 10:52:00.948 15916 15916 I wm_on_paused_called: [100003047,com.thf.dabplayer.activity.PlayerActivity,performPause]
18631: 11-07 10:52:00.950   860  1334 W ActivityTaskManager: Tried to set launchTime (0) < mLastActivityLaunchTime (13251685)
18635: 11-07 10:52:00.954   860  1334 I wm_set_resumed_activity: [0,com.thf.dabplayer/.activity.MainActivity,minimalResumeActivityLocked]
18674: 11-07 10:52:01.000 13777 13777 D WindowUtil: pane launch: second up after 371 ms
18675: 11-07 10:52:01.000 13777 13777 I WindowUtil: pane launch: third (page 1, visible 0, 0 left)
18676: 11-07 10:52:01.000 13777 13777 I WindowUtil: third: show org.prowl.torque
18678: 11-07 10:52:01.009 13777 13777 I WindowHostSinglePane: Third: window move animation off (privateFlags)
18691: 11-07 10:52:01.034   860  1384 V WindowState: toString mSurfaceNameCache= mLastTitle=null title=PipWindowHost:Third
18692: 11-07 10:52:01.034   860  1384 D CoreBackPreview: Window{81f59ec u0 PipWindowHost:Third}, [type=1000]: Setting back callback OnBackInvokedCallbackInfo{mCallback=android.window.IOnBackInvokedCallback$Stub$Proxy@427f04a, mPriority=0}
18693: 11-07 10:52:01.038 13777 13777 D WindowHostSplash: cover up: WindowHostSplash#cover org.prowl.torque
18719: 11-07 10:52:01.059 13777 13777 D VRI[PipWindowHost:Third]: performTraversals relayoutWindow: maybeSyncSeqId=-1 ,mSyncSeqId=0 ,relayoutResult=3
18738: 11-07 10:52:01.074 15916 15916 D Dabdream: MainActivity/onCreate: board=uis7870sc_2h10 device=uis7870sc_2h10 release=13 product=uis7870sc_2h10_nosec app_version=26.10.20
18739: 11-07 10:52:01.074 15916 15916 D Dabdream: MainActivity/onCreate: started by=Intent { act=android.intent.action.MAIN cat=[android.intent.category.LAUNCHER] flg=0x34720000 pkg=com.thf.dabplayer cmp=com.thf.dabplayer/.activity.MainActivity }
18740: 11-07 10:52:01.076   860   894 I DisplayDeviceRepository: Display device changed state: "WindowHostVd@62812274", ON
18741: 11-07 10:52:01.076 13777 13777 I WindowHostVdView: display 7 with org.prowl.torque taken over from the previous pane, no fresh display
18744: 11-07 10:52:01.077   860   894 I InputManager-JNI: Viewport [1] --- add: virtual:com.android.shell,2000,WindowHostVd@265605953,0, isActive: true 1, ViewportType::3, viewport.displayId: 5
18745: 11-07 10:52:01.077   860   894 I InputManager-JNI: Viewport [2] --- add: virtual:com.android.shell,2000,WindowHostVd@62812274,0, isActive: true 1, ViewportType::3, viewport.displayId: 7
18746: 11-07 10:52:01.078   860   894 I InputManager-JNI: Viewport [3] --- add: virtual:com.android.shell,2000,WindowHostVd@207690327,0, isActive: true 1, ViewportType::3, viewport.displayId: 8
18765: 11-07 10:52:01.102   860  1334 D WindowState: finishDrawing: syncSeqId=0, postDrawTransaction=android.view.SurfaceControl$Transaction@aba3733, mSyncState=0, mDrawState=1, hasSyncHandlers=false, mClientWasDrawingForSync=false, win=Window{81f59ec u0 PipWindowHost:Third}, [type=1000]-[Surface(name=*Title#7484)/@0xafcc716]
18767: 11-07 10:52:01.103  5013  5013 I wm_on_restart_called: [224056078,org.prowl.torque.Torque,performRestartActivity]
18768: 11-07 10:52:01.103  5013  5013 I wm_on_start_called: [224056078,org.prowl.torque.Torque,handleStartActivity]
18773: 11-07 10:52:01.112   698   698 I Layer   : fillInputInfo layer:PipWindowHost:Third#7484, visible=1 (hasInputInfo:1, isHidden:0, alpha:1.000000, mActiveBuffer:2), parent:81f59ec PipWindowHost:Third#7483, parenthidden:0
18774: 11-07 10:52:01.112   698   698 I Layer   : fillInputInfo layer:SurfaceView[PipWindowHost:Third](BLAST)#7487, visible=1 (hasInputInfo:1, isHidden:0, alpha:1.000000, mActiveBuffer:0), parent:SurfaceView[PipWindowHost:Third]#7486, parenthidden:0
18784: 11-07 10:52:01.119   860  3721 D WindowState: finishDrawing: syncSeqId=0, postDrawTransaction=android.view.SurfaceControl$Transaction@3a3161c, mSyncState=0, mDrawState=4, hasSyncHandlers=false, mClientWasDrawingForSync=false, win=Window{81f59ec u0 PipWindowHost:Third}, [type=1000]-[Surface(name=*Title#7484)/@0xafcc716]
18785: 11-07 10:52:01.119   860  3721 D WindowStateAnimator: finishDrawingLocked: mDrawState=4 ,mLastHidden=false ,mShownAlpha=1.0 ,mLastAlpha=1.0 ,postDrawTransaction=android.view.SurfaceControl$Transaction@3a3161c ,mWin=Window{81f59ec u0 PipWindowHost:Third}, [type=1000]-[Surface(name=*Title#7484)/@0xafcc716]
18786: 11-07 10:52:01.119   860  3721 D WindowStateAnimator: finishDrawingLocked: syncTransaction=android.view.SurfaceControl$Transaction@5f36d25 ,mSyncTransaction=android.view.SurfaceControl$Transaction@2d52225 ,mWin=Window{81f59ec u0 PipWindowHost:Third}, [type=1000]-[Surface(name=*Title#7484)/@0xafcc716]
18787: 11-07 10:52:01.119 15916 15916 I wm_on_create_called: [266022042,com.thf.dabplayer.activity.MainActivity,performCreate]
18789: 11-07 10:52:01.122 15916 15916 I wm_on_start_called: [266022042,com.thf.dabplayer.activity.MainActivity,handleStartActivity]
18790: 11-07 10:52:01.124  5013  5013 I wm_on_resume_called: [224056078,org.prowl.torque.Torque,RESUME_ACTIVITY]
18792: 11-07 10:52:01.125 13777 13777 I WindowHostVdView: org.prowl.torque already runs on display 7, not started again
18793: 11-07 10:52:01.125 13777 13777 I WindowHostSinglePane: Third: start ok for org.prowl.torque
18802: 11-07 10:52:01.136   860  2373 I ActivityTaskManager: START u0 {flg=0x14000000 cmp=com.thf.dabplayer/.activity.PlayerActivity} from uid 10151, pid 15916
18804: 11-07 10:52:01.138   860  2373 I wm_finish_activity: [0,266022042,102,com.thf.dabplayer/.activity.MainActivity,clear-task-stack]
18830: 11-07 10:52:01.157   860  2373 I ActivityTaskManager: ->startActivity for ActivityRecord{8d97808 u0 com.thf.dabplayer/.activity.PlayerActivity} result:START_DELIVERED_TO_TOP
18843: 11-07 10:52:01.165 13777 13777 D WindowHostSinglePane: Third: resizeVD OK -> 841x584 @160
18861: 11-07 10:52:01.184   860  3708 W ActivityTaskManager: Duplicate finish request for r=ActivityRecord{fdb2c9a u0 com.thf.dabplayer/.activity.MainActivity} t102 d8 f}}
18862: 11-07 10:52:01.184 15916 15916 I wm_on_resume_called: [266022042,com.thf.dabplayer.activity.MainActivity,RESUME_ACTIVITY]
18864: 11-07 10:52:01.185 15916 15916 D AndroidRuntime: Shutting down VM
18866: 11-07 10:52:01.185 15916 15916 E AndroidRuntime: FATAL EXCEPTION: main
18867: 11-07 10:52:01.185 15916 15916 E AndroidRuntime: Process: com.thf.dabplayer, PID: 15916
18868: 11-07 10:52:01.185 15916 15916 E AndroidRuntime: java.lang.NullPointerException: Attempt to invoke virtual method 'android.view.View android.view.Window.getDecorView()' on a null object reference
18869: 11-07 10:52:01.185 15916 15916 E AndroidRuntime: 	at android.app.ActivityThread.handleResumeActivity(ActivityThread.java:5049)
18870: 11-07 10:52:01.185 15916 15916 E AndroidRuntime: 	at android.app.servertransaction.ResumeActivityItem.execute(ResumeActivityItem.java:54)
18871: 11-07 10:52:01.185 15916 15916 E AndroidRuntime: 	at android.app.servertransaction.ActivityTransactionItem.execute(ActivityTransactionItem.java:45)
18872: 11-07 10:52:01.185 15916 15916 E AndroidRuntime: 	at android.app.servertransaction.TransactionExecutor.executeLifecycleState(TransactionExecutor.java:178)
18873: 11-07 10:52:01.185 15916 15916 E AndroidRuntime: 	at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:99)
18874: 11-07 10:52:01.185 15916 15916 E AndroidRuntime: 	at android.app.ActivityThread$H.handleMessage(ActivityThread.java:2393)
18875: 11-07 10:52:01.185 15916 15916 E AndroidRuntime: 	at android.os.Handler.dispatchMessage(Handler.java:106)
18876: 11-07 10:52:01.185 15916 15916 E AndroidRuntime: 	at android.os.Looper.loopOnce(Looper.java:201)
18877: 11-07 10:52:01.185 15916 15916 E AndroidRuntime: 	at android.os.Looper.loop(Looper.java:288)
18878: 11-07 10:52:01.185 15916 15916 E AndroidRuntime: 	at android.app.ActivityThread.main(ActivityThread.java:8073)
18879: 11-07 10:52:01.185 15916 15916 E AndroidRuntime: 	at java.lang.reflect.Method.invoke(Native Method)
18880: 11-07 10:52:01.185 15916 15916 E AndroidRuntime: 	at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:703)
18881: 11-07 10:52:01.185 15916 15916 E AndroidRuntime: 	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:911)
18882: 11-07 10:52:01.186   860  2360 I am_crash: [15916,0,com.thf.dabplayer,550026820,java.lang.NullPointerException,Attempt to invoke virtual method 'android.view.View android.view.Window.getDecorView()' on a null object reference,ActivityThread.java,5049]
18887: 11-07 10:52:01.190   860  2360 W ActivityTaskManager:   Force finishing activity com.thf.dabplayer/.activity.PlayerActivity
18888: 11-07 10:52:01.190   860  2360 I wm_finish_activity: [0,100003047,102,com.thf.dabplayer/.activity.PlayerActivity,force-crash]
18896: 11-07 10:52:01.198   860  1191 I input_focus: [Focus entering 65ac00d com.android.launcher66/com.android.launcher66.Launcher (server),reason=lsec]
18897: 11-07 10:52:01.198   860  2360 I wm_set_resumed_activity: [0,com.android.launcher66/.Launcher,positionChildAt]
18898: 11-07 10:52:01.198   860  2360 I wm_set_resumed_activity: [0,com.android.launcher66/.Launcher,finish-top]
18974: 11-07 10:52:01.255 15916 15916 I Process : Sending signal. PID: 15916 SIG: 9
18990: 11-07 10:52:01.265   860  2360 I am_create_service: [0,140037905,.PersistentIntentOperationService,10093,11866]
19033: 11-07 10:52:01.296   860  2360 I am_create_service: [0,191515469,.DropBoxEntryAddedService,10093,11866]
19036: 11-07 10:52:01.299 13777 13777 D WindowHostSplash: cover down: WindowHostSplash#cover com.thf.dabplayer
19042: 11-07 10:52:01.306   640   705 I Codec2-Component@1.1: Client died ! release the component !!
19062: 11-07 10:52:01.307  1984  1984 W e0      : 	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:911)
19067: 11-07 10:52:01.308   640   705 I C2UnisocMp3Dec: in DestroyCodec2Factory
19089: 11-07 10:52:01.322   860  1383 D MediaSessionService: Media button session is changed to null
19090: 11-07 10:52:01.322   608   608 I Zygote  : Process 15916 exited due to signal 9 (Killed)
19092: 11-07 10:52:01.323   860  1334 I ActivityManager: Process com.thf.dabplayer (pid 15916) has died: fg  TOP
19093: 11-07 10:52:01.323   860  1334 I am_proc_died: [0,15916,com.thf.dabplayer,0,2]
19096: 11-07 10:52:01.326   860  1387 I MediaFocusControl: AudioFocus  removeFocusStackEntryOnDeath(): removing entry for android.os.BinderProxy@919a68
19104: 11-07 10:52:01.330   860  1334 W ActivityManager: Scheduling restart of crashed service com.thf.dabplayer/.service.DabService in 1000ms for start-requested
19105: 11-07 10:52:01.330   860  1334 I am_schedule_service_restart: [0,com.thf.dabplayer/.service.DabService,1000]
19129: 11-07 10:52:01.347   860   894 W ActivityManager: setHasOverlayUi called on unknown pid: 15916
19200: 11-07 10:52:01.403   693  1050 I APM_AudioPolicyManager: stopOutput portId 274
19201: 11-07 10:52:01.403   693  1050 I AudioPolicyManagerCustomBase: stopOutputSetInt portId 274
19202: 11-07 10:52:01.403   693  1050 I AudioPolicyManagerCustomBase: stopOutputSetInt out portId 274
19203: 11-07 10:52:01.403   693  1050 I APM_AudioPolicyManager: stopOutput() output 13, stream 3, session 1913
19207: 11-07 10:52:01.405   693  1050 I AudioPolicyManagerCustomBase: stopOutputSetEnd portId 274
19208: 11-07 10:52:01.405   693  1050 I AudioPolicyManagerCustomBase: stopOutputSetEnd out portId 274
19234: 11-07 10:52:01.548 13777 13777 D WindowHostSplash: cover down: WindowHostSplash#cover org.prowl.torque
19238: 11-07 10:52:01.560 13777 13777 I WindowHostAvReaper: retire enter id=142850145
19239: 11-07 10:52:01.560 13777 13777 I WindowHostAvReaper: releaseNow id=142850145 displayId=-1 reason=no virtual display
19240: 11-07 10:52:01.561 13777 13777 I WindowHostAvReaper: released retired ActivityView (displayId=-1, no virtual display)
19241: 11-07 10:52:01.561 13777 13777 I WindowHostAvReaper: retire enter id=178689590
19242: 11-07 10:52:01.561 13777 13777 I WindowHostAvReaper: releaseNow id=178689590 displayId=-1 reason=no virtual display
19243: 11-07 10:52:01.561 13777 13777 I WindowHostAvReaper: released retired ActivityView (displayId=-1, no virtual display)
19244: 11-07 10:52:01.561 13777 13777 I WindowHostAvReaper: retire enter id=203356390
19245: 11-07 10:52:01.561 13777 13777 I WindowHostAvReaper: releaseNow id=203356390 displayId=-1 reason=no virtual display
19246: 11-07 10:52:01.561 13777 13777 I WindowHostAvReaper: released retired ActivityView (displayId=-1, no virtual display)
19270: 11-07 10:52:01.653   860   894 W ActivityTaskManager: Activity top resumed state loss timeout for ActivityRecord{fdb2c9a u0 com.thf.dabplayer/.activity.MainActivity} t-1 d8 f}}
19271: 11-07 10:52:01.655 13777 13777 I wm_on_top_resumed_gained_called: [264133600,com.android.launcher66.Launcher,topStateChangedWhenResumed]
19314: 11-07 10:52:01.964   860   894 I DisplayDeviceRepository: Display device changed state: "WindowHostVd@265605953", OFF
19316: 11-07 10:52:01.965   860   894 I InputManager-JNI: Viewport [1] --- add: virtual:com.android.shell,2000,WindowHostVd@265605953,0, isActive: false 1, ViewportType::3, viewport.displayId: 5
19317: 11-07 10:52:01.965   860   894 I InputManager-JNI: Viewport [2] --- add: virtual:com.android.shell,2000,WindowHostVd@62812274,0, isActive: true 1, ViewportType::3, viewport.displayId: 7
19318: 11-07 10:52:01.965   860   894 I InputManager-JNI: Viewport [3] --- add: virtual:com.android.shell,2000,WindowHostVd@207690327,0, isActive: true 1, ViewportType::3, viewport.displayId: 8
19327: 11-07 10:52:01.973  4740  4740 I wm_on_paused_called: [161950649,com.sygic.navi.map.MapActivity,performPause]
```

## 4. Porównanie: start DAB z launchera (bez crashu)

#### 4.1 Plik A, 10:51:36–38: pierwsze uruchomienie z launchera i otwarcie PlayerActivity

Źródło: `cade8856-user_full_07-11-2026_10-51-34_dabdream_stop_after_ging_home.txt`, okno 10:51:36.5–10:51:39.0, 260 linii (numer: oryginalna linia).

```
958: 11-07 10:51:36.500   698   698 I Layer   : fillInputInfo layer:Sys2038:com.android.launcher66/com.android.launcher66.Launcher#7291, visible=1 (hasInputInfo:1, isHidden:0, alpha:0.799805, mActiveBuffer:2), parent:fbc1569 Sys2038:com.android.launcher66/com.android.launcher66.Launcher#7288, parenthidden:0
968: 11-07 10:51:36.514 13777 13777 D Launcher.Workspace: Widget bar refreshed after wake: persistent bar standby
1858: 11-07 10:51:36.684  1364 28218 E timer   : appName Launcher Mod
1859: 11-07 10:51:36.684  1364 28218 E hzq     : appName Launcher Mod
1863: 11-07 10:51:36.690 13777 13777 D WindowUtil: pane launch: first up after 383 ms
1864: 11-07 10:51:36.690 13777 13777 I WindowUtil: pane launch: second (page 1, visible 0, 1 left)
1865: 11-07 10:51:36.691 13777 13777 I WindowUtil: second: show com.thf.dabplayer
1896: 11-07 10:51:36.700 13777 13777 I WindowHostSinglePane: Second: window move animation off (privateFlags)
1900: 11-07 10:51:36.711   860  3720 V WindowState: toString mSurfaceNameCache= mLastTitle=null title=PipWindowHost:Second
1901: 11-07 10:51:36.712   860  3720 D CoreBackPreview: Window{38e337f u0 PipWindowHost:Second}, [type=1000]: Setting back callback OnBackInvokedCallbackInfo{mCallback=android.window.IOnBackInvokedCallback$Stub$Proxy@8879b95, mPriority=0}
1902: 11-07 10:51:36.716 13777 13777 D WindowHostSplash: cover up: WindowHostSplash#cover com.thf.dabplayer
1908: 11-07 10:51:36.728 13777 13777 D VRI[PipWindowHost:Second]: performTraversals relayoutWindow: maybeSyncSeqId=-1 ,mSyncSeqId=0 ,relayoutResult=3
1909: 11-07 10:51:36.735   860   894 I DisplayDeviceRepository: Display device changed state: "WindowHostVd@207690327", ON
1910: 11-07 10:51:36.735 13777 13777 I WindowHostVdView: display 8 with com.thf.dabplayer taken over from the previous pane, no fresh display
1914: 11-07 10:51:36.737   860   894 I InputManager-JNI: Viewport [1] --- add: virtual:com.android.shell,2000,WindowHostVd@265605953,0, isActive: true 1, ViewportType::3, viewport.displayId: 5
1915: 11-07 10:51:36.737   860   894 I InputManager-JNI: Viewport [2] --- add: virtual:com.android.shell,2000,WindowHostVd@62812274,0, isActive: false 1, ViewportType::3, viewport.displayId: 7
1916: 11-07 10:51:36.737   860   894 I InputManager-JNI: Viewport [3] --- add: virtual:com.android.shell,2000,WindowHostVd@207690327,0, isActive: true 1, ViewportType::3, viewport.displayId: 8
1928: 11-07 10:51:36.755   860  1331 D WindowState: finishDrawing: syncSeqId=0, postDrawTransaction=android.view.SurfaceControl$Transaction@9135c11, mSyncState=0, mDrawState=1, hasSyncHandlers=false, mClientWasDrawingForSync=false, win=Window{38e337f u0 PipWindowHost:Second}, [type=1000]-[Surface(name=*Title#7296)/@0xd62d4aa]
1939: 11-07 10:51:36.770   698   698 I Layer   : fillInputInfo layer:PipWindowHost:Second#7296, visible=1 (hasInputInfo:1, isHidden:0, alpha:1.000000, mActiveBuffer:2), parent:38e337f PipWindowHost:Second#7295, parenthidden:0
1940: 11-07 10:51:36.770   698   698 I Layer   : fillInputInfo layer:SurfaceView[PipWindowHost:Second](BLAST)#7299, visible=1 (hasInputInfo:1, isHidden:0, alpha:1.000000, mActiveBuffer:0), parent:SurfaceView[PipWindowHost:Second]#7298, parenthidden:0
1946: 11-07 10:51:36.777   860  3707 D WindowState: finishDrawing: syncSeqId=0, postDrawTransaction=android.view.SurfaceControl$Transaction@9719176, mSyncState=0, mDrawState=4, hasSyncHandlers=false, mClientWasDrawingForSync=false, win=Window{38e337f u0 PipWindowHost:Second}, [type=1000]-[Surface(name=*Title#7296)/@0xd62d4aa]
1947: 11-07 10:51:36.777   860  3707 D WindowStateAnimator: finishDrawingLocked: mDrawState=4 ,mLastHidden=false ,mShownAlpha=1.0 ,mLastAlpha=1.0 ,postDrawTransaction=android.view.SurfaceControl$Transaction@9719176 ,mWin=Window{38e337f u0 PipWindowHost:Second}, [type=1000]-[Surface(name=*Title#7296)/@0xd62d4aa]
1948: 11-07 10:51:36.777   860  3707 D WindowStateAnimator: finishDrawingLocked: syncTransaction=android.view.SurfaceControl$Transaction@5f36d25 ,mSyncTransaction=android.view.SurfaceControl$Transaction@6f11377 ,mWin=Window{38e337f u0 PipWindowHost:Second}, [type=1000]-[Surface(name=*Title#7296)/@0xd62d4aa]
1949: 11-07 10:51:36.780   860  3707 I ActivityTaskManager: START u0 {act=android.intent.action.MAIN cat=[android.intent.category.LAUNCHER] flg=0x34720000 pkg=com.thf.dabplayer cmp=com.thf.dabplayer/.activity.MainActivity} from uid 2000, pid 13859
1976: 11-07 10:51:36.796   860  3707 I ActivityTaskManager: ->startActivity for ActivityRecord{add4f02 u0 com.thf.dabplayer/.activity.MainActivity} t101 d8} result:START_SUCCESS
1977: 11-07 10:51:36.802 13859 13884 I FytVdHost: startActivity ComponentInfo{com.thf.dabplayer/com.thf.dabplayer.activity.MainActivity} on display 8 -> 0
1978: 11-07 10:51:36.802 13777 13777 I WindowHostSinglePane: Second: start ok for com.thf.dabplayer
1983: 11-07 10:51:36.806   860   894 D ActivityManager: PROFILE_FROM_SHELL is disabled for ProcessRecord{8e0fa6f 0:com.thf.dabplayer/u0a151}
1988: 11-07 10:51:36.807   860   902 D ActivityManager: asking zygote to start proc:ProcessRecord{8e0fa6f 0:com.thf.dabplayer/u0a151}
1989: 11-07 10:51:36.808 13777 13777 I wm_on_top_resumed_lost_called: [264133600,com.android.launcher66.Launcher,topStateChangedWhenResumed]
1994: 11-07 10:51:36.819   608   608 D Zygote  : Forked child process 15690
1996: 11-07 10:51:36.820   860   902 I ActivityManager: Start proc 15690:com.thf.dabplayer/u0a151 for top-activity {com.thf.dabplayer/com.thf.dabplayer.activity.MainActivity}
1997: 11-07 10:51:36.823 15690 15690 I Zygote  : seccomp disabled by setenforce 0
2004: 11-07 10:51:36.838 13777 13777 D WindowHostSinglePane: Second: resizeVD OK -> 428x584 @160
2031: 11-07 10:51:36.875   860  8511 I wm_set_resumed_activity: [0,com.thf.dabplayer/.activity.MainActivity,minimalResumeActivityLocked]
2076: 11-07 10:51:36.921 15690 15690 D Dabdream: MainActivity/onCreate: board=uis7870sc_2h10 device=uis7870sc_2h10 release=13 product=uis7870sc_2h10_nosec app_version=26.10.20
2077: 11-07 10:51:36.921 15690 15690 D Dabdream: MainActivity/onCreate: started by=Intent { act=android.intent.action.MAIN cat=[android.intent.category.LAUNCHER] flg=0x34720000 pkg=com.thf.dabplayer cmp=com.thf.dabplayer/.activity.MainActivity }
2087: 11-07 10:51:36.945 15690 15690 I wm_on_create_called: [182275842,com.thf.dabplayer.activity.MainActivity,performCreate]
2088: 11-07 10:51:36.948 15690 15690 I wm_on_start_called: [182275842,com.thf.dabplayer.activity.MainActivity,handleStartActivity]
2089: 11-07 10:51:36.951 15690 15690 I wm_on_resume_called: [182275842,com.thf.dabplayer.activity.MainActivity,RESUME_ACTIVITY]
2090: 11-07 10:51:36.954 13777 13777 D WindowUtil: pane launch: second up after 263 ms
2091: 11-07 10:51:36.954 13777 13777 I WindowUtil: pane launch: third (page 1, visible 0, 0 left)
2093: 11-07 10:51:36.954 13777 13777 I WindowUtil: third: show org.prowl.torque
2106: 11-07 10:51:36.961 15690 15690 I wm_on_top_resumed_gained_called: [182275842,com.thf.dabplayer.activity.MainActivity,topStateChangedWhenResumed]
2108: 11-07 10:51:36.969 13777 13777 I WindowHostSinglePane: Third: window move animation off (privateFlags)
2112: 11-07 10:51:36.979   860  1331 V WindowState: toString mSurfaceNameCache= mLastTitle=null title=PipWindowHost:Third
2113: 11-07 10:51:36.979   860  1331 D CoreBackPreview: Window{387662 u0 PipWindowHost:Third}, [type=1000]: Setting back callback OnBackInvokedCallbackInfo{mCallback=android.window.IOnBackInvokedCallback$Stub$Proxy@3f98b0, mPriority=0}
2115: 11-07 10:51:36.982 13777 13777 D WindowHostSplash: cover up: WindowHostSplash#cover org.prowl.torque
2120: 11-07 10:51:36.991 13777 13777 D VRI[PipWindowHost:Third]: performTraversals relayoutWindow: maybeSyncSeqId=-1 ,mSyncSeqId=0 ,relayoutResult=3
2121: 11-07 10:51:36.998   860   894 I DisplayDeviceRepository: Display device changed state: "WindowHostVd@62812274", ON
2122: 11-07 10:51:36.998 13777 13777 I WindowHostVdView: display 7 with org.prowl.torque taken over from the previous pane, no fresh display
2125: 11-07 10:51:36.999   860   894 I InputManager-JNI: Viewport [1] --- add: virtual:com.android.shell,2000,WindowHostVd@265605953,0, isActive: true 1, ViewportType::3, viewport.displayId: 5
2126: 11-07 10:51:36.999   860   894 I InputManager-JNI: Viewport [2] --- add: virtual:com.android.shell,2000,WindowHostVd@62812274,0, isActive: true 1, ViewportType::3, viewport.displayId: 7
2127: 11-07 10:51:36.999   860   894 I InputManager-JNI: Viewport [3] --- add: virtual:com.android.shell,2000,WindowHostVd@207690327,0, isActive: true 1, ViewportType::3, viewport.displayId: 8
2140: 11-07 10:51:37.007   860  1145 D WindowState: finishDrawing: syncSeqId=0, postDrawTransaction=android.view.SurfaceControl$Transaction@b41cdc8, mSyncState=0, mDrawState=1, hasSyncHandlers=false, mClientWasDrawingForSync=false, win=Window{387662 u0 PipWindowHost:Third}, [type=1000]-[Surface(name=*Title#7306)/@0xf2b96ae]
2150: 11-07 10:51:37.026  5013  5013 I wm_on_restart_called: [224056078,org.prowl.torque.Torque,performRestartActivity]
2151: 11-07 10:51:37.026  5013  5013 I wm_on_start_called: [224056078,org.prowl.torque.Torque,handleStartActivity]
2152: 11-07 10:51:37.027   698   698 I Layer   : fillInputInfo layer:PipWindowHost:Third#7306, visible=1 (hasInputInfo:1, isHidden:0, alpha:1.000000, mActiveBuffer:2), parent:387662 PipWindowHost:Third#7305, parenthidden:0
2153: 11-07 10:51:37.027   698   698 I Layer   : fillInputInfo layer:SurfaceView[PipWindowHost:Third](BLAST)#7309, visible=1 (hasInputInfo:1, isHidden:0, alpha:1.000000, mActiveBuffer:0), parent:SurfaceView[PipWindowHost:Third]#7308, parenthidden:0
2159: 11-07 10:51:37.034   860  1331 D WindowState: finishDrawing: syncSeqId=0, postDrawTransaction=android.view.SurfaceControl$Transaction@a518647, mSyncState=0, mDrawState=4, hasSyncHandlers=false, mClientWasDrawingForSync=false, win=Window{387662 u0 PipWindowHost:Third}, [type=1000]-[Surface(name=*Title#7306)/@0xf2b96ae]
2160: 11-07 10:51:37.035   860  1331 D WindowStateAnimator: finishDrawingLocked: mDrawState=4 ,mLastHidden=false ,mShownAlpha=1.0 ,mLastAlpha=1.0 ,postDrawTransaction=android.view.SurfaceControl$Transaction@a518647 ,mWin=Window{387662 u0 PipWindowHost:Third}, [type=1000]-[Surface(name=*Title#7306)/@0xf2b96ae]
2161: 11-07 10:51:37.035   860  1331 D WindowStateAnimator: finishDrawingLocked: syncTransaction=android.view.SurfaceControl$Transaction@5f36d25 ,mSyncTransaction=android.view.SurfaceControl$Transaction@d89fe74 ,mWin=Window{387662 u0 PipWindowHost:Third}, [type=1000]-[Surface(name=*Title#7306)/@0xf2b96ae]
2164: 11-07 10:51:37.039 13777 13777 I WindowHostVdView: org.prowl.torque already runs on display 7, not started again
2165: 11-07 10:51:37.039 13777 13777 I WindowHostSinglePane: Third: start ok for org.prowl.torque
2177: 11-07 10:51:37.048  5013  5013 I wm_on_resume_called: [224056078,org.prowl.torque.Torque,RESUME_ACTIVITY]
2217: 11-07 10:51:37.066 15690 15690 D Dabdream: USB connect attempt 1/5
2220: 11-07 10:51:37.068 15690 15690 D Dabdream: USB device 1500/5824
2221: 11-07 10:51:37.068 15690 15690 D Dabdream: USB device found /dev/bus/usb/001/005
2222: 11-07 10:51:37.068 15690 15690 D Dabdream: USB device 24577/1027
2233: 11-07 10:51:37.078   860   891 I ActivityTaskManager: Displayed com.thf.dabplayer/.activity.MainActivity: +291ms
2256: 11-07 10:51:37.102 13777 13777 D WindowHostSinglePane: Third: resizeVD OK -> 841x584 @160
2301: 11-07 10:51:37.157 15690 15690 D Dabdream: UsbDeviceHandling: hasPermission /dev/bus/usb/001/005
2335: 11-07 10:51:37.174   860  1387 I am_create_service: [0,197132609,.KeyboardService,10142,1984]
2362: 11-07 10:51:37.185   860  3707 I am_create_service: [0,262548338,.TelemetryService,10142,1984]
2383: 11-07 10:51:37.198   860  2359 I ActivityTaskManager: START u0 {flg=0x14000000 cmp=com.thf.dabplayer/.activity.PlayerActivity (has extras)} from uid 10151, pid 15690
2395: 11-07 10:51:37.204   860  2359 I wm_set_resumed_activity: [0,com.thf.dabplayer/.activity.MainActivity,positionChildAt]
2401: 11-07 10:51:37.207   860  2359 I ActivityTaskManager: ->startActivity for ActivityRecord{2aa903b u0 com.thf.dabplayer/.activity.PlayerActivity} t101 d8} result:START_SUCCESS
2435: 11-07 10:51:37.238   860  1191 I input_focus: [Focus entering 65ac00d com.android.launcher66/com.android.launcher66.Launcher (server),reason=lsec]
2436: 11-07 10:51:37.243   860  8511 I wm_set_resumed_activity: [0,com.android.launcher66/.Launcher,positionChildAt]
2439: 11-07 10:51:37.244   860  8511 I wm_set_resumed_activity: [0,com.android.launcher66/.Launcher,setFocusedTask]
2464: 11-07 10:51:37.278   860  1387 I wm_finish_activity: [0,182275842,101,com.thf.dabplayer/.activity.MainActivity,app-request]
2465: 11-07 10:51:37.280 15690 15690 I wm_on_top_resumed_lost_called: [182275842,com.thf.dabplayer.activity.MainActivity,topStateChangedWhenResumed]
2466: 11-07 10:51:37.281 15690 15690 D Dabdream: MainActivity/onPause
2470: 11-07 10:51:37.284 15690 15690 I wm_on_paused_called: [182275842,com.thf.dabplayer.activity.MainActivity,performPause]
2471: 11-07 10:51:37.287   860  1387 W ActivityTaskManager: Tried to set launchTime (0) < mLastActivityLaunchTime (13236089)
2493: 11-07 10:51:37.301 13777 13777 I wm_on_top_resumed_gained_called: [264133600,com.android.launcher66.Launcher,topStateChangedWhenResumed]
2494: 11-07 10:51:37.301 13777 13777 D WindowHostSplash: cover down: WindowHostSplash#cover com.thf.dabplayer
2495: 11-07 10:51:37.303 15690 15690 D Dabdream: DatabaseHelper/openDatabase: open db
2513: 11-07 10:51:37.321   860  3720 I am_create_service: [0,50120731,.DabService,10151,15690]
2531: 11-07 10:51:37.346 15690 15690 I wm_on_create_called: [44732475,com.thf.dabplayer.activity.PlayerActivity,performCreate]
2534: 11-07 10:51:37.346 15690 15690 I wm_on_start_called: [44732475,com.thf.dabplayer.activity.PlayerActivity,handleStartActivity]
2539: 11-07 10:51:37.348 15690 15690 I wm_on_resume_called: [44732475,com.thf.dabplayer.activity.PlayerActivity,RESUME_ACTIVITY]
2553: 11-07 10:51:37.360 15690 15690 D Dabdream: DabService/onCreate
2560: 11-07 10:51:37.368   860  1331 D MediaSessionService: Media button session is changed to com.thf.dabplayer/dab (userId=0)
2561: 11-07 10:51:37.374 15690 15690 D Dabdream: DabService/onStartCommand
2611: 11-07 10:51:37.410  1984  1984 W e0      : 	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:911)
2647: 11-07 10:51:37.443  1984  1984 W e0      : 	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:911)
2671: 11-07 10:51:37.493 13777 13777 D WindowHostSplash: cover down: WindowHostSplash#cover org.prowl.torque
2694: 11-07 10:51:37.504  1984  1984 W e0      : 	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:911)
2695: 11-07 10:51:37.507 13777 13777 I WindowHostAvReaper: retire enter id=86806419
2696: 11-07 10:51:37.507 13777 13777 I WindowHostAvReaper: releaseNow id=86806419 displayId=-1 reason=no virtual display
2697: 11-07 10:51:37.507 13777 13777 I WindowHostAvReaper: released retired ActivityView (displayId=-1, no virtual display)
2698: 11-07 10:51:37.507 13777 13777 I WindowHostAvReaper: retire enter id=40114432
2699: 11-07 10:51:37.507 13777 13777 I WindowHostAvReaper: releaseNow id=40114432 displayId=-1 reason=no virtual display
2700: 11-07 10:51:37.507 13777 13777 I WindowHostAvReaper: released retired ActivityView (displayId=-1, no virtual display)
2701: 11-07 10:51:37.507 13777 13777 I WindowHostAvReaper: retire enter id=154124848
2702: 11-07 10:51:37.507 13777 13777 I WindowHostAvReaper: releaseNow id=154124848 displayId=-1 reason=no virtual display
2703: 11-07 10:51:37.507 13777 13777 I WindowHostAvReaper: released retired ActivityView (displayId=-1, no virtual display)
2727: 11-07 10:51:37.563 15690 15690 D MusicViz: VisualizerRenderer: onSurfaceTextureAvailable
2728: 11-07 10:51:37.563 15690 15690 D MusicViz: VisualizerRenderer: onSurfaceTextureAvailable start thread
2763: 11-07 10:51:37.585 15690 15754 D MusicViz: TextureViewViz: custom shader available
2768: 11-07 10:51:37.589 15690 15754 D MusicViz: TextureViewViz: scene=CustomScene
2773: 11-07 10:51:37.591 15690 15690 D Dabdream: DabService/onBind: null
2781: 11-07 10:51:37.600   860   891 I ActivityTaskManager: Displayed com.thf.dabplayer/.activity.PlayerActivity: +401ms
2783: 11-07 10:51:37.603 15690 15690 D Dabdream: server getservice
2784: 11-07 10:51:37.603 15690 15690 D Dabdream: DabConnectionController: DAB service connected
2795: 11-07 10:51:37.619 15690 15690 D Dabdream: DabService/setPlayerHandler
2796: 11-07 10:51:37.619 15690 15690 D Dabdream: DabService/setUsbDevice
2797: 11-07 10:51:37.619 15690 15690 D Dabdream: DabService/setUsbDevice: tuner attached at runtime -> upgrade FGS type
2809: 11-07 10:51:37.636 15690 15690 D Dabdream: DabService/toggleMediaReceiver: true
2810: 11-07 10:51:37.636 15690 15690 D Dabdream: DabService/startDabThread
2811: 11-07 10:51:37.636 15690 15690 D Dabdream: DabEngineHost/start: start
2812: 11-07 10:51:37.636 15690 15690 D Dabdream: DatabaseHelper/openDatabase: open db
2816: 11-07 10:51:37.638 15690 15690 D Dabdream: get dab handler
2819: 11-07 10:51:37.639 15690 15760 D Dabdream: DabThread/run: dab thread run...
2820: 11-07 10:51:37.639 15690 15761 D Dabdream: DabConnectionController: searching for DAB handler...
2821: 11-07 10:51:37.639 15690 15761 D Dabdream: get dab handler
2891: 11-07 10:51:37.739 15690 15761 D Dabdream: DabConnectionController: DAB init sent
2892: 11-07 10:51:37.740 15690 15760 D Dabdream: DabThread/dabInit: starting...
2911: 11-07 10:51:37.789 15690 15760 D Dabdream: DabThread/dabInit: done. tuner attached to device: /dev/bus/usb/001/005
2925: 11-07 10:51:37.843 15690 15690 D Dabdream: DabService/onBind: android.media.browse.MediaBrowserService
2926: 11-07 10:51:37.843 15690 15690 D Dabdream: DabService/onBind: MediaBrowser client -> super.onBind
2930: 11-07 10:51:37.852   860   860 I am_create_service: [0,55564175,.CastMediaRoute2ProviderService_Persistent,10093,11866]
2935: 11-07 10:51:37.862 15690 15690 D Dabdream: MediaBrowseTree/root: client=com.android.systemui -> media_root_id
2941: 11-07 10:51:37.867 15690 15690 D Dabdream: MediaBrowseTree/loadChildren: parentMediaId=media_root_id
2942: 11-07 10:51:37.867 15690 15776 D Dabdream: MediaBrowseTree/loadChildren: getInstance=singleton
2943: 11-07 10:51:37.869 15690 15776 D Dabdream: MediaBrowseTree/loadChildren: favorites=false stations=119
2944: 11-07 10:51:37.870 15690 15776 D Dabdream: MediaBrowseTree/loadChildren: ROOT -> 2 folders
2947: 11-07 10:51:37.873 15690 15690 D Dabdream: DabService/onUnbind
2948: 11-07 10:51:37.873 15690 15690 D Dabdream: Intent { act=android.media.browse.MediaBrowserService cmp=com.thf.dabplayer/.service.DabService }
2980: 11-07 10:51:37.904 15690 15690 I wm_on_stop_called: [182275842,com.thf.dabplayer.activity.MainActivity,LIFECYCLER_STOP_ACTIVITY]
2981: 11-07 10:51:37.905 15690 15690 D Dabdream: MainActivity/onDestroy
2982: 11-07 10:51:37.906 15690 15690 I wm_on_destroy_called: [182275842,com.thf.dabplayer.activity.MainActivity,performDestroy]
3020: 11-07 10:51:37.954 15690 15774 D Dabdream: DabThread/tunerStatusChanged: status=TUNER_STATUS_INITIALIZED
3092: 11-07 10:51:37.964 15690 15690 D Dabdream: PlayerActivity/playStation: Tuning to station index=5
3111: 11-07 10:51:37.992   860   894 I DisplayDeviceRepository: Display device changed state: "WindowHostVd@265605953", OFF
3113: 11-07 10:51:37.993   860   894 I InputManager-JNI: Viewport [1] --- add: virtual:com.android.shell,2000,WindowHostVd@265605953,0, isActive: false 1, ViewportType::3, viewport.displayId: 5
3114: 11-07 10:51:37.993   860   894 I InputManager-JNI: Viewport [2] --- add: virtual:com.android.shell,2000,WindowHostVd@62812274,0, isActive: true 1, ViewportType::3, viewport.displayId: 7
3115: 11-07 10:51:37.993   860   894 I InputManager-JNI: Viewport [3] --- add: virtual:com.android.shell,2000,WindowHostVd@207690327,0, isActive: true 1, ViewportType::3, viewport.displayId: 8
3152: 11-07 10:51:38.009  4740  4740 I wm_on_paused_called: [161950649,com.sygic.navi.map.MapActivity,performPause]
3176: 11-07 10:51:38.033 15690 15690 D Dabdream: PlayerActivity/playStation: Routing to Webradio Engine -> 90s90s - Eurodance
3178: 11-07 10:51:38.034 15690 15760 D Dabdream: DabThread/stopPlayback: stopping...
3208: 11-07 10:51:38.051 13859 13886 D FytVdHost: surface detach in 60 ms
3224: 11-07 10:51:38.075  4740  4740 I wm_on_stop_called: [161950649,com.sygic.navi.map.MapActivity,STOP_ACTIVITY_ITEM]
3229: 11-07 10:51:38.083   860  1331 I MediaFocusControl: requestAudioFocus() from uid/pid 10151/15690 AA=USAGE_MEDIA/CONTENT_TYPE_MUSIC clientId=android.media.AudioManager@12526a3g6.g@3a94da0 callingPack=com.thf.dabplayer req=1 flags=0x1 sdk=36
3231: 11-07 10:51:38.085 15690 15690 D Dabdream: RadioPlayer/play: https://regiocast.streamabc.net/regc-90s90seurodance7558633-mp3-192-3419489?sABC=6n888234%230%23q280o0r09ns9qpq3889p9qqn13p5753s%23fgernzf.90f90f.qr&aw_0_1st.playerid=streams.90s90s.de&amsparams=playerid:streams.90s90s.de;skey:1787331124
3236: 11-07 10:51:38.087 15690 15690 D Dabdream: RadioPlayer/onPlaybackStateChanged: BUFFERING (wantPlaying=true, everReady=false)
3312: 11-07 10:51:38.215   860   894 I DisplayDeviceRepository: Display device changed state: "WindowHostVd@265605953", ON
3314: 11-07 10:51:38.217   860   894 I InputManager-JNI: Viewport [1] --- add: virtual:com.android.shell,2000,WindowHostVd@265605953,0, isActive: true 1, ViewportType::3, viewport.displayId: 5
3315: 11-07 10:51:38.217   860   894 I InputManager-JNI: Viewport [2] --- add: virtual:com.android.shell,2000,WindowHostVd@62812274,0, isActive: true 1, ViewportType::3, viewport.displayId: 7
3316: 11-07 10:51:38.217   860   894 I InputManager-JNI: Viewport [3] --- add: virtual:com.android.shell,2000,WindowHostVd@207690327,0, isActive: true 1, ViewportType::3, viewport.displayId: 8
3324: 11-07 10:51:38.223  4740  4740 I wm_on_restart_called: [161950649,com.sygic.navi.map.MapActivity,performRestartActivity]
3327: 11-07 10:51:38.226  4740  4740 I wm_on_start_called: [161950649,com.sygic.navi.map.MapActivity,handleStartActivity]
3337: 11-07 10:51:38.233  4740  4740 I wm_on_resume_called: [161950649,com.sygic.navi.map.MapActivity,RESUME_ACTIVITY]
3357: 11-07 10:51:38.264   860  3720 I am_create_service: [0,38754349,.SystemJobService,10141,4740]
3414: 11-07 10:51:38.311   860   894 I DisplayDeviceRepository: Display device changed state: "WindowHostVd@207690327", OFF
3428: 11-07 10:51:38.326   860   894 I InputManager-JNI: Viewport [1] --- add: virtual:com.android.shell,2000,WindowHostVd@265605953,0, isActive: true 1, ViewportType::3, viewport.displayId: 5
3429: 11-07 10:51:38.326   860   894 I InputManager-JNI: Viewport [2] --- add: virtual:com.android.shell,2000,WindowHostVd@62812274,0, isActive: true 1, ViewportType::3, viewport.displayId: 7
3430: 11-07 10:51:38.326   860   894 I InputManager-JNI: Viewport [3] --- add: virtual:com.android.shell,2000,WindowHostVd@207690327,0, isActive: false 1, ViewportType::3, viewport.displayId: 8
3439: 11-07 10:51:38.333 15690 15690 I wm_on_paused_called: [44732475,com.thf.dabplayer.activity.PlayerActivity,performPause]
3445: 11-07 10:51:38.336   860  1191 I input_interaction: Interaction with: 65ac00d com.android.launcher66/com.android.launcher66.Launcher (server), d87ab4f com.android.systemui.ImageWallpaper (server), PointerEventDispatcher0 (server),
3465: 11-07 10:51:38.352 13859 13886 D FytVdHost: surface detach in 41 ms
3510: 11-07 10:51:38.374 13777 13777 I WindowUtil: removePip() pane: dismissed
3541: 11-07 10:51:38.398   860  1145 I ActivityTaskManager: START u0 {act=android.intent.action.MAIN cat=[android.intent.category.LAUNCHER] flg=0x10000000 pkg=com.thf.dabplayer cmp=com.thf.dabplayer/.activity.MainActivity} from uid 10199, pid 13777
3550: 11-07 10:51:38.401   860  1145 I wm_set_resumed_activity: [0,com.android.launcher66/.Launcher,positionChildAt]
3553: 11-07 10:51:38.401   860  1145 I wm_set_resumed_activity: [0,com.android.launcher66/.Launcher,reparent]
3575: 11-07 10:51:38.404   860  1145 I wm_set_resumed_activity: [0,com.thf.dabplayer/.activity.PlayerActivity,bringingFoundTaskToFront]
3578: 11-07 10:51:38.404   860  1145 I wm_pause_activity: [0,264133600,com.android.launcher66/.Launcher,userLeaving=true,pauseBackTasks]
3579: 11-07 10:51:38.405   860  1145 I ActivityTaskManager: ->startActivity for ActivityRecord{c2f8174 u0 com.thf.dabplayer/.activity.MainActivity} result:START_TASK_TO_FRONT
3580: 11-07 10:51:38.405   860  1145 I wm_add_to_stopping: [0,264133600,com.android.launcher66/.Launcher,makeInvisible]
3587: 11-07 10:51:38.413 15690 15690 D MusicViz: VisualizerRenderer: stop thread
3590: 11-07 10:51:38.417 15690 15690 I wm_on_stop_called: [44732475,com.thf.dabplayer.activity.PlayerActivity,STOP_ACTIVITY_ITEM]
3598: 11-07 10:51:38.437 15690 15690 I wm_on_restart_called: [44732475,com.thf.dabplayer.activity.PlayerActivity,performRestartActivity]
3599: 11-07 10:51:38.437 15690 15690 I wm_on_start_called: [44732475,com.thf.dabplayer.activity.PlayerActivity,handleStartActivity]
3602: 11-07 10:51:38.437 13777 13777 D WindowHostVdView: surface destroyed, display 5 detached
3603: 11-07 10:51:38.439   860   895 I input_focus: [Requesting to set focus to null window,reason=UpdateInputWindows, mCurrentFocusWindow=65ac00d com.android.launcher66/com.android.launcher66.Launcher]
3605: 11-07 10:51:38.445   860  3708 I ActivityTaskManager: Activity reported stop, but no longer stopping: ActivityRecord{2aa903b u0 com.thf.dabplayer/.activity.PlayerActivity} t101 d0} STARTED
3615: 11-07 10:51:38.454   860  1191 I input_focus: [Focus leaving 65ac00d com.android.launcher66/com.android.launcher66.Launcher (server),reason=Waiting for window because NOT_FOCUSABLE]
3630: 11-07 10:51:38.467   860   894 I DisplayDeviceRepository: Display device changed state: "WindowHostVd@265605953", OFF
3656: 11-07 10:51:38.477   860   894 I InputManager-JNI: Viewport [1] --- add: virtual:com.android.shell,2000,WindowHostVd@265605953,0, isActive: false 1, ViewportType::3, viewport.displayId: 5
3657: 11-07 10:51:38.477   860   894 I InputManager-JNI: Viewport [2] --- add: virtual:com.android.shell,2000,WindowHostVd@62812274,0, isActive: true 1, ViewportType::3, viewport.displayId: 7
3658: 11-07 10:51:38.477   860   894 I InputManager-JNI: Viewport [3] --- add: virtual:com.android.shell,2000,WindowHostVd@207690327,0, isActive: false 1, ViewportType::3, viewport.displayId: 8
3686: 11-07 10:51:38.496 13859 13886 D FytVdHost: surface detach in 57 ms
3695: 11-07 10:51:38.498 13777 13777 D WindowHostVdView: surface destroyed, display 8 detached
3696: 11-07 10:51:38.501 15690 15814 I Codec2Client: Available Codec2 services: "default" "software"
3713: 11-07 10:51:38.511   640 12522 I C2UnisocMp3Dec: in CreateCodec2Factory
3724: 11-07 10:51:38.516  4740  4740 I wm_on_paused_called: [161950649,com.sygic.navi.map.MapActivity,performPause]
3751: 11-07 10:51:38.543 13859 13886 D FytVdHost: surface detach in 43 ms
3948: 11-07 10:51:38.558 13777 13777 D WindowHostVdView: surface destroyed, display 7 detached
4166: 11-07 10:51:38.568   860   894 I DisplayDeviceRepository: Display device changed state: "WindowHostVd@62812274", OFF
4205: 11-07 10:51:38.570 15690 15814 W Codec2Client: query -- param skipped: index = 1107298332.
4229: 11-07 10:51:38.571 15690 15814 W Codec2Client: query -- param skipped: index = 1342179345.
4230: 11-07 10:51:38.571 15690 15814 W Codec2Client: query -- param skipped: index = 2415921170.
4234: 11-07 10:51:38.572 15690 15814 W Codec2Client: query -- param skipped: index = 2684356609.
4426: 11-07 10:51:38.588   860   894 I InputManager-JNI: Viewport [1] --- add: virtual:com.android.shell,2000,WindowHostVd@265605953,0, isActive: false 1, ViewportType::3, viewport.displayId: 5
4427: 11-07 10:51:38.588   860   894 I InputManager-JNI: Viewport [2] --- add: virtual:com.android.shell,2000,WindowHostVd@62812274,0, isActive: false 1, ViewportType::3, viewport.displayId: 7
4428: 11-07 10:51:38.588   860   894 I InputManager-JNI: Viewport [3] --- add: virtual:com.android.shell,2000,WindowHostVd@207690327,0, isActive: false 1, ViewportType::3, viewport.displayId: 8
4516: 11-07 10:51:38.600  5013  5013 I wm_on_paused_called: [224056078,org.prowl.torque.Torque,performPause]
4662: 11-07 10:51:38.615 13859 13886 D FytVdHost: surface detach in 56 ms
4671: 11-07 10:51:38.617 13777 13777 I wm_on_top_resumed_lost_called: [264133600,com.android.launcher66.Launcher,topStateChangedWhenResumed]
4806: 11-07 10:51:38.648 13777 13777 D Launcher.Workspace: Persistent bottom bar hidden (pause)
4821: 11-07 10:51:38.652 13777 13777 D Launcher: ---->>> onPause
4822: 11-07 10:51:38.653 13777 13777 I wm_on_paused_called: [264133600,com.android.launcher66.Launcher,performPause]
4845: 11-07 10:51:38.664   860  1383 I wm_set_resumed_activity: [0,com.thf.dabplayer/.activity.PlayerActivity,resumeTopActivity]
4847: 11-07 10:51:38.666  5013  5013 I wm_on_stop_called: [224056078,org.prowl.torque.Torque,STOP_ACTIVITY_ITEM]
4917: 11-07 10:51:38.698  4740  4740 I wm_on_stop_called: [161950649,com.sygic.navi.map.MapActivity,STOP_ACTIVITY_ITEM]
4918: 11-07 10:51:38.700 13777 13777 D VRI[PipWindowHost:First]: performTraversals relayoutWindow: maybeSyncSeqId=1 ,mSyncSeqId=0 ,relayoutResult=2
4963: 11-07 10:51:38.706   698   698 I Layer   : fillInputInfo layer:PipWindowHost:First#7282, visible=0 (hasInputInfo:1, isHidden:0, alpha:0.000000, mActiveBuffer:2), parent:2113bf9 PipWindowHost:First#7281, parenthidden:0
4964: 11-07 10:51:38.706   698   698 I Layer   : fillInputInfo layer:SurfaceView[PipWindowHost:First](BLAST)#7285, visible=0 (hasInputInfo:1, isHidden:0, alpha:0.000000, mActiveBuffer:2), parent:SurfaceView[PipWindowHost:First]#7284, parenthidden:0
5020: 11-07 10:51:38.722 13777 13777 D VRI[PipWindowHost:Second]: performTraversals relayoutWindow: maybeSyncSeqId=1 ,mSyncSeqId=0 ,relayoutResult=2
5022: 11-07 10:51:38.723   698   698 I Layer   : fillInputInfo layer:PipWindowHost:Second#7296, visible=0 (hasInputInfo:1, isHidden:0, alpha:0.000000, mActiveBuffer:2), parent:38e337f PipWindowHost:Second#7295, parenthidden:0
5023: 11-07 10:51:38.723   698   698 I Layer   : fillInputInfo layer:SurfaceView[PipWindowHost:Second](BLAST)#7299, visible=0 (hasInputInfo:1, isHidden:0, alpha:0.000000, mActiveBuffer:2), parent:SurfaceView[PipWindowHost:Second]#7298, parenthidden:0
5053: 11-07 10:51:38.751 13777 13777 D VRI[PipWindowHost:Third]: performTraversals relayoutWindow: maybeSyncSeqId=1 ,mSyncSeqId=0 ,relayoutResult=2
5059: 11-07 10:51:38.756   698   698 I Layer   : fillInputInfo layer:PipWindowHost:Third#7306, visible=0 (hasInputInfo:1, isHidden:0, alpha:0.000000, mActiveBuffer:2), parent:387662 PipWindowHost:Third#7305, parenthidden:0
5060: 11-07 10:51:38.756   698   698 I Layer   : fillInputInfo layer:SurfaceView[PipWindowHost:Third](BLAST)#7309, visible=0 (hasInputInfo:1, isHidden:0, alpha:0.000000, mActiveBuffer:2), parent:SurfaceView[PipWindowHost:Third]#7308, parenthidden:0
5091: 11-07 10:51:38.781   860  8511 V WindowState: toString mSurfaceNameCache=-[Surface(name=*Title#7306)/@0xf2b96ae] mLastTitle=PipWindowHost:Third title=PipWindowHost:Third
5092: 11-07 10:51:38.781   860  8511 D WindowState: finishDrawing: syncSeqId=1, postDrawTransaction=android.view.SurfaceControl$Transaction@c267d2a, mSyncState=0, mDrawState=4, hasSyncHandlers=true, mClientWasDrawingForSync=false, win=Window{387662 u0 PipWindowHost:Third EXITING}, [type=1000]-[Surface(name=*Title#7306)/@0xf2b96ae]
5093: 11-07 10:51:38.781   860  8511 D WindowStateAnimator: finishDrawingLocked: mDrawState=4 ,mLastHidden=false ,mShownAlpha=0.0 ,mLastAlpha=0.0 ,postDrawTransaction=android.view.SurfaceControl$Transaction@c267d2a ,mWin=Window{387662 u0 PipWindowHost:Third EXITING}, [type=1000]-[Surface(name=*Title#7306)/@0xf2b96ae]
5094: 11-07 10:51:38.781   860  8511 D WindowStateAnimator: finishDrawingLocked: syncTransaction=android.view.SurfaceControl$Transaction@5f36d25 ,mSyncTransaction=android.view.SurfaceControl$Transaction@d89fe74 ,mWin=Window{387662 u0 PipWindowHost:Third EXITING}, [type=1000]-[Surface(name=*Title#7306)/@0xf2b96ae]
5096: 11-07 10:51:38.782   860  8511 V WindowState: toString mSurfaceNameCache=-[Surface(name=*Title#7296)/@0xd62d4aa] mLastTitle=PipWindowHost:Second title=PipWindowHost:Second
5097: 11-07 10:51:38.782   860  8511 D WindowState: finishDrawing: syncSeqId=1, postDrawTransaction=android.view.SurfaceControl$Transaction@f84b0b8, mSyncState=0, mDrawState=4, hasSyncHandlers=true, mClientWasDrawingForSync=false, win=Window{38e337f u0 PipWindowHost:Second EXITING}, [type=1000]-[Surface(name=*Title#7296)/@0xd62d4aa]
5098: 11-07 10:51:38.782   860  8511 D WindowStateAnimator: finishDrawingLocked: mDrawState=4 ,mLastHidden=false ,mShownAlpha=0.0 ,mLastAlpha=0.0 ,postDrawTransaction=android.view.SurfaceControl$Transaction@f84b0b8 ,mWin=Window{38e337f u0 PipWindowHost:Second EXITING}, [type=1000]-[Surface(name=*Title#7296)/@0xd62d4aa]
5099: 11-07 10:51:38.782   860  8511 D WindowStateAnimator: finishDrawingLocked: syncTransaction=android.view.SurfaceControl$Transaction@5f36d25 ,mSyncTransaction=android.view.SurfaceControl$Transaction@6f11377 ,mWin=Window{38e337f u0 PipWindowHost:Second EXITING}, [type=1000]-[Surface(name=*Title#7296)/@0xd62d4aa]
5101: 11-07 10:51:38.784   860  8511 V WindowState: toString mSurfaceNameCache=-[Surface(name=*Title#7282)/@0xdd36aec] mLastTitle=PipWindowHost:First title=PipWindowHost:First
5102: 11-07 10:51:38.784   860  8511 D WindowState: finishDrawing: syncSeqId=1, postDrawTransaction=android.view.SurfaceControl$Transaction@fa77e91, mSyncState=0, mDrawState=4, hasSyncHandlers=true, mClientWasDrawingForSync=false, win=Window{2113bf9 u0 PipWindowHost:First EXITING}, [type=1000]-[Surface(name=*Title#7282)/@0xdd36aec]
5103: 11-07 10:51:38.784   860  8511 D WindowStateAnimator: finishDrawingLocked: mDrawState=4 ,mLastHidden=false ,mShownAlpha=0.0 ,mLastAlpha=0.0 ,postDrawTransaction=android.view.SurfaceControl$Transaction@fa77e91 ,mWin=Window{2113bf9 u0 PipWindowHost:First EXITING}, [type=1000]-[Surface(name=*Title#7282)/@0xdd36aec]
5104: 11-07 10:51:38.784   860  8511 D WindowStateAnimator: finishDrawingLocked: syncTransaction=android.view.SurfaceControl$Transaction@5f36d25 ,mSyncTransaction=android.view.SurfaceControl$Transaction@962ed52 ,mWin=Window{2113bf9 u0 PipWindowHost:First EXITING}, [type=1000]-[Surface(name=*Title#7282)/@0xdd36aec]
5105: 11-07 10:51:38.786   860  8511 D CoreBackPreview: Window{2113bf9 u0 PipWindowHost:First EXITING}, [type=1000]-[Surface(name=*Title#7282)/@0xdd36aec]: Setting back callback null
5110: 11-07 10:51:38.790   860  3707 W InputManager-JNI: Input channel object '2113bf9 PipWindowHost:First (client)' was disposed without first being removed with the input manager!
5154: 11-07 10:51:38.815   860  1383 D CoreBackPreview: Window{38e337f u0 PipWindowHost:Second EXITING}, [type=1000]-[Surface(name=*Title#7296)/@0xd62d4aa]: Setting back callback null
5155: 11-07 10:51:38.817   860  1387 W InputManager-JNI: Input channel object '38e337f PipWindowHost:Second (client)' was disposed without first being removed with the input manager!
5185: 11-07 10:51:38.832 15690 15690 D Dabdream: WebradioController/onStreamTitle: title=90s90s - Eurodance
5187: 11-07 10:51:38.834   860  8511 D CoreBackPreview: Window{387662 u0 PipWindowHost:Third EXITING}, [type=1000]-[Surface(name=*Title#7306)/@0xf2b96ae]: Setting back callback null
5200: 11-07 10:51:38.840   860  3720 W InputManager-JNI: Input channel object '387662 PipWindowHost:Third (client)' was disposed without first being removed with the input manager!
5219: 11-07 10:51:38.850   860  1383 D CoreBackPreview: Window{fbc1569 u0 Sys2038:com.android.launcher66/com.android.launcher66.Launcher}-[Surface(name=*Title#7291)/@0xa07d908]: Setting back callback null
5226: 11-07 10:51:38.853   860  1383 W InputManager-JNI: Input channel object 'fbc1569 Sys2038:com.android.launcher66/com.android.launcher66.Launcher (client)' was disposed without first being removed with the input manager!
5240: 11-07 10:51:38.868 15690 15690 D Dabdream: RadioPlayer/onPlaybackStateChanged: READY (wantPlaying=true, everReady=false)
5253: 11-07 10:51:38.879 13777 13777 D Launcher.Workspace: Widget bar refreshed after wake: persistent bar removed
5278: 11-07 10:51:38.906 15690 15690 D Dabdream: DabService/setPlayerHandler
5287: 11-07 10:51:38.910 15690 15690 D MusicViz: VisualizerRenderer: start thread
5288: 11-07 10:51:38.911 15690 15690 I wm_on_resume_called: [44732475,com.thf.dabplayer.activity.PlayerActivity,RESUME_ACTIVITY]
5289: 11-07 10:51:38.912 15690 15690 I wm_on_top_resumed_gained_called: [44732475,com.thf.dabplayer.activity.PlayerActivity,topWhenResuming]
5313: 11-07 10:51:38.924 15690 15829 D MusicViz: TextureViewViz: custom shader available
5327: 11-07 10:51:38.930 15690 15829 D MusicViz: TextureViewViz: scene=CustomScene
5367: 11-07 10:51:38.951  1984  1984 W e0      : 	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:911)
5403: 11-07 10:51:38.969   860   894 I wm_stop_activity: [0,264133600,com.android.launcher66/.Launcher]
5407: 11-07 10:51:38.976   698   698 I Layer   : fillInputInfo layer:com.android.launcher66/com.android.launcher66.Launcher#7274, visible=0 (hasInputInfo:1, isHidden:1, alpha:1.000000, mActiveBuffer:2), parent:65ac00d com.android.launcher66/com.android.launcher66.Launcher#7057, parenthidden:1
5435: 11-07 10:51:38.994 13777 13777 D VRI[Launcher]: performTraversals relayoutWindow: maybeSyncSeqId=-1 ,mSyncSeqId=0 ,relayoutResult=2
5442: 11-07 10:51:38.999 13777 13777 D Launcher: ---->>> onStop
5443: 11-07 10:51:38.999 13777 13777 D Launcher: onStop: unregistering dynamic receiver
```

#### 4.2 Wszystkie `START` DAB i `am_crash` w obu plikach
```
[B] 193: 11-07 09:33:04.127   860   892 I ActivityTaskManager: START u0 {act=android.intent.action.MAIN cat=[android.intent.category.HOME] flg=0x10000100 cmp=com.android.launcher66/.Launcher (has extras)} from uid 0, pid 0
[B] 1635: 11-07 09:33:04.887   860   878 I ActivityTaskManager: START u0 {act=android.intent.action.MAIN cat=[android.intent.category.LAUNCHER] flg=0x34720000 pkg=com.thf.dabplayer cmp=com.thf.dabplayer/.activity.MainActivity} from uid 2000, pid 4505
[B] 2040: 11-07 09:33:05.271   860 10120 I ActivityTaskManager: START u0 {flg=0x14000000 cmp=com.thf.dabplayer/.activity.PlayerActivity (has extras)} from uid 10151, pid 23077
[B] 3108: 11-07 09:33:06.440   860   878 I ActivityTaskManager: START u0 {flg=0x10000000 cmp=com.thf.dabplayer/.activity.MainActivity} from uid 10199, pid 2202
[B] 3587: 11-07 09:33:06.890   860  1387 I ActivityTaskManager: START u0 {flg=0x14000000 cmp=com.thf.dabplayer/.activity.PlayerActivity} from uid 10151, pid 23077
[B] 6868: 11-07 09:33:19.957   860   892 I ActivityTaskManager: START u0 {act=android.intent.action.MAIN cat=[android.intent.category.HOME] flg=0x10000100 cmp=com.android.launcher66/.Launcher (has extras)} from uid 0, pid 0
[B] 8379: 11-07 09:33:20.661   860  3709 I ActivityTaskManager: START u0 {act=android.intent.action.MAIN cat=[android.intent.category.LAUNCHER] flg=0x34720000 pkg=com.thf.dabplayer cmp=com.thf.dabplayer/.activity.MainActivity} from uid 2000, pid 4505
[B] 8677: 11-07 09:33:21.000   860  1334 I ActivityTaskManager: START u0 {flg=0x14000000 cmp=com.thf.dabplayer/.activity.PlayerActivity} from uid 10151, pid 23077
[B] 8747: 11-07 09:33:21.043   860  1383 I am_crash: [23077,0,com.thf.dabplayer,550026820,java.lang.NullPointerException,Attempt to invoke virtual method 'android.view.View android.view.Window.getDecorView()' on a null object reference,ActivityThread.java,5049]
[A] 420: 11-07 10:51:35.801   860   892 I ActivityTaskManager: START u0 {act=android.intent.action.MAIN cat=[android.intent.category.HOME] flg=0x10000100 cmp=com.android.launcher66/.Launcher (has extras)} from uid 0, pid 0
[A] 1949: 11-07 10:51:36.780   860  3707 I ActivityTaskManager: START u0 {act=android.intent.action.MAIN cat=[android.intent.category.LAUNCHER] flg=0x34720000 pkg=com.thf.dabplayer cmp=com.thf.dabplayer/.activity.MainActivity} from uid 2000, pid 13859
[A] 2383: 11-07 10:51:37.198   860  2359 I ActivityTaskManager: START u0 {flg=0x14000000 cmp=com.thf.dabplayer/.activity.PlayerActivity (has extras)} from uid 10151, pid 15690
[A] 3541: 11-07 10:51:38.398   860  1145 I ActivityTaskManager: START u0 {act=android.intent.action.MAIN cat=[android.intent.category.LAUNCHER] flg=0x10000000 pkg=com.thf.dabplayer cmp=com.thf.dabplayer/.activity.MainActivity} from uid 10199, pid 13777
[A] 7546: 11-07 10:51:45.104   860   892 I ActivityTaskManager: START u0 {act=android.intent.action.MAIN cat=[android.intent.category.HOME] flg=0x10000100 cmp=com.android.launcher66/.Launcher (has extras)} from uid 0, pid 0
[A] 9241: 11-07 10:51:45.935   860   878 I ActivityTaskManager: START u0 {act=android.intent.action.MAIN cat=[android.intent.category.LAUNCHER] flg=0x34720000 pkg=com.thf.dabplayer cmp=com.thf.dabplayer/.activity.MainActivity} from uid 2000, pid 13859
[A] 9599: 11-07 10:51:46.241   860  1383 I ActivityTaskManager: START u0 {flg=0x14000000 cmp=com.thf.dabplayer/.activity.PlayerActivity} from uid 10151, pid 15690
[A] 9681: 11-07 10:51:46.300   860  1383 I am_crash: [15690,0,com.thf.dabplayer,550026820,java.lang.NullPointerException,Attempt to invoke virtual method 'android.view.View android.view.Window.getDecorView()' on a null object reference,ActivityThread.java,5049]
[A] 13111: 11-07 10:51:51.813   860  3720 I ActivityTaskManager: START u0 {act=android.intent.action.MAIN cat=[android.intent.category.LAUNCHER] flg=0x10000000 pkg=com.thf.dabplayer cmp=com.thf.dabplayer/.activity.MainActivity} from uid 10199, pid 13777
[A] 13743: 11-07 10:51:52.376   860  2360 I ActivityTaskManager: START u0 {flg=0x14000000 cmp=com.thf.dabplayer/.activity.PlayerActivity (has extras)} from uid 10151, pid 15916
[A] 16766: 11-07 10:51:59.908   860   892 I ActivityTaskManager: START u0 {act=android.intent.action.MAIN cat=[android.intent.category.HOME] flg=0x10000100 cmp=com.android.launcher66/.Launcher (has extras)} from uid 0, pid 0
[A] 18445: 11-07 10:52:00.776   860  1334 I ActivityTaskManager: START u0 {act=android.intent.action.MAIN cat=[android.intent.category.LAUNCHER] flg=0x34720000 pkg=com.thf.dabplayer cmp=com.thf.dabplayer/.activity.MainActivity} from uid 2000, pid 13859
[A] 18802: 11-07 10:52:01.136   860  2373 I ActivityTaskManager: START u0 {flg=0x14000000 cmp=com.thf.dabplayer/.activity.PlayerActivity} from uid 10151, pid 15916
[A] 18882: 11-07 10:52:01.186   860  2360 I am_crash: [15916,0,com.thf.dabplayer,550026820,java.lang.NullPointerException,Attempt to invoke virtual method 'android.view.View android.view.Window.getDecorView()' on a null object reference,ActivityThread.java,5049]
```

#### 4.3 Stos wyjątku (plik A)
```
513: 11-07 10:51:36.001 15505 15505 I AndroidRuntime: VM exiting with result code 0, cleanup skipped.
7838: 11-07 10:51:45.310 15661 15661 I AndroidRuntime: VM exiting with result code 0, cleanup skipped.
9662: 11-07 10:51:46.296 15690 15690 D AndroidRuntime: Shutting down VM
9664: 11-07 10:51:46.296 15690 15690 E AndroidRuntime: FATAL EXCEPTION: main
9665: 11-07 10:51:46.296 15690 15690 E AndroidRuntime: Process: com.thf.dabplayer, PID: 15690
9666: 11-07 10:51:46.296 15690 15690 E AndroidRuntime: java.lang.NullPointerException: Attempt to invoke virtual method 'android.view.View android.view.Window.getDecorView()' on a null object reference
9667: 11-07 10:51:46.296 15690 15690 E AndroidRuntime: 	at android.app.ActivityThread.handleResumeActivity(ActivityThread.java:5049)
9668: 11-07 10:51:46.296 15690 15690 E AndroidRuntime: 	at android.app.servertransaction.ResumeActivityItem.execute(ResumeActivityItem.java:54)
9669: 11-07 10:51:46.296 15690 15690 E AndroidRuntime: 	at android.app.servertransaction.ActivityTransactionItem.execute(ActivityTransactionItem.java:45)
9670: 11-07 10:51:46.296 15690 15690 E AndroidRuntime: 	at android.app.servertransaction.TransactionExecutor.executeLifecycleState(TransactionExecutor.java:178)
9671: 11-07 10:51:46.296 15690 15690 E AndroidRuntime: 	at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:99)
9672: 11-07 10:51:46.296 15690 15690 E AndroidRuntime: 	at android.app.ActivityThread$H.handleMessage(ActivityThread.java:2393)
9673: 11-07 10:51:46.296 15690 15690 E AndroidRuntime: 	at android.os.Handler.dispatchMessage(Handler.java:106)
9674: 11-07 10:51:46.296 15690 15690 E AndroidRuntime: 	at android.os.Looper.loopOnce(Looper.java:201)
9675: 11-07 10:51:46.296 15690 15690 E AndroidRuntime: 	at android.os.Looper.loop(Looper.java:288)
9676: 11-07 10:51:46.296 15690 15690 E AndroidRuntime: 	at android.app.ActivityThread.main(ActivityThread.java:8073)
9677: 11-07 10:51:46.296 15690 15690 E AndroidRuntime: 	at java.lang.reflect.Method.invoke(Native Method)
9678: 11-07 10:51:46.296 15690 15690 E AndroidRuntime: 	at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:703)
9679: 11-07 10:51:46.296 15690 15690 E AndroidRuntime: 	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:911)
16983: 11-07 10:52:00.107 15859 15859 I AndroidRuntime: VM exiting with result code 0, cleanup skipped.
18864: 11-07 10:52:01.185 15916 15916 D AndroidRuntime: Shutting down VM
18866: 11-07 10:52:01.185 15916 15916 E AndroidRuntime: FATAL EXCEPTION: main
18867: 11-07 10:52:01.185 15916 15916 E AndroidRuntime: Process: com.thf.dabplayer, PID: 15916
18868: 11-07 10:52:01.185 15916 15916 E AndroidRuntime: java.lang.NullPointerException: Attempt to invoke virtual method 'android.view.View android.view.Window.getDecorView()' on a null object reference
18869: 11-07 10:52:01.185 15916 15916 E AndroidRuntime: 	at android.app.ActivityThread.handleResumeActivity(ActivityThread.java:5049)
18870: 11-07 10:52:01.185 15916 15916 E AndroidRuntime: 	at android.app.servertransaction.ResumeActivityItem.execute(ResumeActivityItem.java:54)
18871: 11-07 10:52:01.185 15916 15916 E AndroidRuntime: 	at android.app.servertransaction.ActivityTransactionItem.execute(ActivityTransactionItem.java:45)
18872: 11-07 10:52:01.185 15916 15916 E AndroidRuntime: 	at android.app.servertransaction.TransactionExecutor.executeLifecycleState(TransactionExecutor.java:178)
18873: 11-07 10:52:01.185 15916 15916 E AndroidRuntime: 	at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:99)
18874: 11-07 10:52:01.185 15916 15916 E AndroidRuntime: 	at android.app.ActivityThread$H.handleMessage(ActivityThread.java:2393)
```

#### 4.4 Skrót „already runs” i przejęcie displayu (wszystkie wystąpienia)
```
[A] 784: 11-07 10:51:36.306 13777 13777 I WindowUtil: pane launch set: first@0, second@1, third@1 (visible page 0)
[A] 785: 11-07 10:51:36.306 13777 13777 I WindowUtil: pane launch: first (page 0, visible 0, 2 left)
[A] 830: 11-07 10:51:36.366 13777 13777 I WindowHostVdView: display 5 with com.sygic.aura taken over from the previous pane, no fresh display
[A] 953: 11-07 10:51:36.499 13777 13777 I WindowHostVdView: com.sygic.aura already runs on display 5, not started again
[A] 955: 11-07 10:51:36.499 13777 13777 D WindowHostSinglePane: First: resizeVD OK -> 842x584 @160
[A] 1863: 11-07 10:51:36.690 13777 13777 D WindowUtil: pane launch: first up after 383 ms
[A] 1864: 11-07 10:51:36.690 13777 13777 I WindowUtil: pane launch: second (page 1, visible 0, 1 left)
[A] 1910: 11-07 10:51:36.735 13777 13777 I WindowHostVdView: display 8 with com.thf.dabplayer taken over from the previous pane, no fresh display
[A] 2004: 11-07 10:51:36.838 13777 13777 D WindowHostSinglePane: Second: resizeVD OK -> 428x584 @160
[A] 2090: 11-07 10:51:36.954 13777 13777 D WindowUtil: pane launch: second up after 263 ms
[A] 2091: 11-07 10:51:36.954 13777 13777 I WindowUtil: pane launch: third (page 1, visible 0, 0 left)
[A] 2122: 11-07 10:51:36.998 13777 13777 I WindowHostVdView: display 7 with org.prowl.torque taken over from the previous pane, no fresh display
[A] 2164: 11-07 10:51:37.039 13777 13777 I WindowHostVdView: org.prowl.torque already runs on display 7, not started again
[A] 2256: 11-07 10:51:37.102 13777 13777 D WindowHostSinglePane: Third: resizeVD OK -> 841x584 @160
[A] 8071: 11-07 10:51:45.570 13777 13777 I WindowUtil: pane launch set: first@0, second@1, third@1 (visible page 0)
[A] 8072: 11-07 10:51:45.570 13777 13777 I WindowUtil: pane launch: first (page 0, visible 0, 2 left)
[A] 8104: 11-07 10:51:45.617 13777 13777 I WindowHostVdView: display 5 with com.sygic.aura taken over from the previous pane, no fresh display
[A] 8167: 11-07 10:51:45.665 13777 13777 I WindowHostVdView: com.sygic.aura already runs on display 5, not started again
[A] 8280: 11-07 10:51:45.721 13777 13777 D WindowHostSinglePane: First: resizeVD OK -> 842x584 @160
[A] 9145: 11-07 10:51:45.822 13777 13777 D WindowUtil: pane launch: first up after 252 ms
[A] 9146: 11-07 10:51:45.822 13777 13777 I WindowUtil: pane launch: second (page 1, visible 0, 1 left)
[A] 9186: 11-07 10:51:45.896 13777 13777 I WindowHostVdView: display 8 with com.thf.dabplayer taken over from the previous pane, no fresh display
[A] 9293: 11-07 10:51:45.985 13777 13777 D WindowHostSinglePane: Second: resizeVD OK -> 428x584 @160
[A] 9611: 11-07 10:51:46.250 13777 13777 D WindowUtil: pane launch: second up after 427 ms
[A] 9612: 11-07 10:51:46.250 13777 13777 I WindowUtil: pane launch: third (page 1, visible 0, 0 left)
[A] 9743: 11-07 10:51:46.345 13777 13777 I WindowHostVdView: display 7 with org.prowl.torque taken over from the previous pane, no fresh display
[A] 9857: 11-07 10:51:46.436 13777 13777 I WindowHostVdView: org.prowl.torque already runs on display 7, not started again
[A] 9859: 11-07 10:51:46.437 13777 13777 D WindowHostSinglePane: Third: resizeVD OK -> 841x584 @160
[A] 17254: 11-07 10:52:00.360 13777 13777 I WindowUtil: pane launch set: first@0, second@1, third@1 (visible page 0)
[A] 17255: 11-07 10:52:00.360 13777 13777 I WindowUtil: pane launch: first (page 0, visible 0, 2 left)
[A] 17281: 11-07 10:52:00.399 13777 13777 I WindowHostVdView: display 5 with com.sygic.aura taken over from the previous pane, no fresh display
[A] 17355: 11-07 10:52:00.466 13777 13777 I WindowHostVdView: com.sygic.aura already runs on display 5, not started again
[A] 17389: 11-07 10:52:00.504 13777 13777 D WindowHostSinglePane: First: resizeVD OK -> 842x584 @160
[A] 18257: 11-07 10:52:00.629 13777 13777 D WindowUtil: pane launch: first up after 268 ms
[A] 18258: 11-07 10:52:00.629 13777 13777 I WindowUtil: pane launch: second (page 1, visible 0, 1 left)
[A] 18314: 11-07 10:52:00.706 13777 13777 I WindowHostVdView: display 8 with com.thf.dabplayer taken over from the previous pane, no fresh display
[A] 18525: 11-07 10:52:00.812 13777 13777 D WindowHostSinglePane: Second: resizeVD OK -> 428x584 @160
[A] 18674: 11-07 10:52:01.000 13777 13777 D WindowUtil: pane launch: second up after 371 ms
[A] 18675: 11-07 10:52:01.000 13777 13777 I WindowUtil: pane launch: third (page 1, visible 0, 0 left)
[A] 18741: 11-07 10:52:01.076 13777 13777 I WindowHostVdView: display 7 with org.prowl.torque taken over from the previous pane, no fresh display
[B] 594: 11-07 09:33:04.596  2202  2202 I WindowUtil: pane launch set: first@0, second@1, third@1 (visible page 0)
[B] 595: 11-07 09:33:04.596  2202  2202 I WindowUtil: pane launch: first (page 0, visible 0, 2 left)
[B] 608: 11-07 09:33:04.633  2202  2202 I WindowHostVdView: display 2 with com.sygic.aura taken over from the previous pane, no fresh display
[B] 649: 11-07 09:33:04.666  2202  2202 I WindowHostVdView: com.sygic.aura already runs on display 2, not started again
[B] 711: 11-07 09:33:04.740  2202  2202 D WindowHostSinglePane: First: resizeVD OK -> 842x584 @160
[B] 749: 11-07 09:33:04.790  2202  2202 D WindowUtil: pane launch: first up after 194 ms
[B] 750: 11-07 09:33:04.790  2202  2202 I WindowUtil: pane launch: second (page 1, visible 0, 1 left)
[B] 1460: 11-07 09:33:04.847  2202  2202 I WindowHostVdView: display 3 with com.thf.dabplayer taken over from the previous pane, no fresh display
[B] 1704: 11-07 09:33:04.957  2202  2202 D WindowHostSinglePane: Second: resizeVD OK -> 428x597 @160
[B] 1740: 11-07 09:33:05.046  2202  2202 D WindowUtil: pane launch: second up after 255 ms
[B] 1741: 11-07 09:33:05.046  2202  2202 I WindowUtil: pane launch: third (page 1, visible 0, 0 left)
[B] 1834: 11-07 09:33:05.105  2202  2202 I WindowHostVdView: display 4 with org.prowl.torque taken over from the previous pane, no fresh display
[B] 1946: 11-07 09:33:05.192  2202  2202 I WindowHostVdView: org.prowl.torque already runs on display 4, not started again
[B] 1953: 11-07 09:33:05.198  2202  2202 D WindowHostSinglePane: Third: resizeVD OK -> 841x596 @160
[B] 7363: 11-07 09:33:20.364  2202  2202 I WindowUtil: pane launch set: first@0, second@1, third@1 (visible page 0)
[B] 7364: 11-07 09:33:20.364  2202  2202 I WindowUtil: pane launch: first (page 0, visible 0, 2 left)
[B] 7380: 11-07 09:33:20.410  2202  2202 I WindowHostVdView: display 2 with com.sygic.aura taken over from the previous pane, no fresh display
[B] 7422: 11-07 09:33:20.444  2202  2202 I WindowHostVdView: com.sygic.aura already runs on display 2, not started again
[B] 7487: 11-07 09:33:20.517  2202  2202 D WindowHostSinglePane: First: resizeVD OK -> 842x584 @160
[B] 7514: 11-07 09:33:20.558  2202  2202 D WindowUtil: pane launch: first up after 194 ms
[B] 7515: 11-07 09:33:20.558  2202  2202 I WindowUtil: pane launch: second (page 1, visible 0, 1 left)
[B] 8346: 11-07 09:33:20.623  2202  2202 I WindowHostVdView: display 3 with com.thf.dabplayer taken over from the previous pane, no fresh display
[B] 8463: 11-07 09:33:20.740  2202  2202 D WindowHostSinglePane: Second: resizeVD OK -> 428x597 @160
[B] 8559: 11-07 09:33:20.876  2202  2202 D WindowUtil: pane launch: second up after 317 ms
[B] 8560: 11-07 09:33:20.876  2202  2202 I WindowUtil: pane launch: third (page 1, visible 0, 0 left)
[B] 8616: 11-07 09:33:20.945  2202  2202 I WindowHostVdView: display 4 with org.prowl.torque taken over from the previous pane, no fresh display
[B] 8725: 11-07 09:33:21.041  2202  2202 I WindowHostVdView: org.prowl.torque already runs on display 4, not started again
[B] 8771: 11-07 09:33:21.050  2202  2202 D WindowHostSinglePane: Third: resizeVD OK -> 841x596 @160
```

## 5. Problem 2 — BT i widget: wszystko, co jest w logach

#### 5.1 Linie com.syu.media / muzyka / MusicWidget / Stock*
```
[A] 472: 11-07 10:51:35.946 32483   407 E music   : ------------>> MediaProvider query uri:  content://com.syu.media/song 1
[A] 609: 11-07 10:51:36.121 13777 13777 D MusicWidgetSizer: bar 576x66 -> layout=beside oneLine=false large=true cover=56+10 R=510 text=306 buttons=204(1x4, 40%) row=29 textPx=22.307693 cell=51x66/45 gap=2 capTop=0
[A] 666: 11-07 10:51:36.170 13777 13777 D MusicWidgetSizer: home 424x317 -> compact=false cover=true(120) row=41 text=26.0 progress=12 buttons=76/61 gap=5
[A] 967: 11-07 10:51:36.514 13777 13777 D MusicWidgetSizer: bar 576x66 -> layout=beside oneLine=false large=true cover=56+10 R=510 text=306 buttons=204(1x4, 40%) row=29 textPx=22.307693 cell=51x66/45 gap=2 capTop=0
[A] 982: 11-07 10:51:36.529 13777 13777 D MusicWidgetSizer: bar 576x66 -> layout=beside oneLine=false large=true cover=56+10 R=510 text=306 buttons=204(1x4, 40%) row=29 textPx=22.307693 cell=51x66/45 gap=2 capTop=0
[A] 2225: 11-07 10:51:37.071 13777 13777 D NotificationListener: Panes settled - ending rebuild window early
[A] 5252: 11-07 10:51:38.878 13777 13777 D MusicWidgetSizer: bar 576x66 -> layout=beside oneLine=false large=true cover=56+10 R=510 text=306 buttons=204(1x4, 40%) row=29 textPx=22.307693 cell=51x66/45 gap=2 capTop=0
[A] 7662: 11-07 10:51:45.189 32483   407 E music   : ------------>> MediaProvider query uri:  content://com.syu.media/song 1
[A] 8068: 11-07 10:51:45.569 13777 13777 D MusicWidgetSizer: bar 576x66 -> layout=beside oneLine=false large=true cover=56+10 R=510 text=306 buttons=204(1x4, 40%) row=29 textPx=22.307693 cell=51x66/45 gap=2 capTop=0
[A] 8132: 11-07 10:51:45.636 13777 13777 D MusicWidgetSizer: bar 576x66 -> layout=beside oneLine=false large=true cover=56+10 R=510 text=306 buttons=204(1x4, 40%) row=29 textPx=22.307693 cell=51x66/45 gap=2 capTop=0
[A] 10019: 11-07 10:51:46.624 13777 13777 D NotificationListener: Panes settled - ending rebuild window early
[A] 13573: 11-07 10:51:52.207 13777 13777 D MusicWidgetSizer: bar 576x66 -> layout=beside oneLine=false large=true cover=56+10 R=510 text=306 buttons=204(1x4, 40%) row=29 textPx=22.307693 cell=51x66/45 gap=2 capTop=0
[A] 16825: 11-07 10:51:59.963 32483 32495 E music   : ------------>> MediaProvider query uri:  content://com.syu.media/song 1
[A] 17251: 11-07 10:52:00.358 13777 13777 D MusicWidgetSizer: bar 576x66 -> layout=beside oneLine=false large=true cover=56+10 R=510 text=306 buttons=204(1x4, 40%) row=29 textPx=22.307693 cell=51x66/45 gap=2 capTop=0
[A] 17302: 11-07 10:52:00.418 13777 13777 D MusicWidgetSizer: bar 576x66 -> layout=beside oneLine=false large=true cover=56+10 R=510 text=306 buttons=204(1x4, 40%) row=29 textPx=22.307693 cell=51x66/45 gap=2 capTop=0
[A] 19169: 11-07 10:52:01.369 13777 13777 D NotificationListener: Panes settled - ending rebuild window early
[B] 292: 11-07 09:33:04.220 32483   375 E music   : ------------>> MediaProvider query uri:  content://com.syu.media/song 1
[B] 490: 11-07 09:33:04.427  2202  2202 D MusicWidgetSizer: bar 359x66 -> compact=true cover=true(56) row=27 text=20.769232 progress=0 buttons=34/27 gap=1
[B] 491: 11-07 09:33:04.427  2202  2202 I MusicWidgetSizer: bar widget 359x66 goes to one text row
[B] 537: 11-07 09:33:04.477  2202  2202 D MusicWidgetSizer: home 424x317 -> compact=false cover=true(120) row=41 text=26.0 progress=12 buttons=76/61 gap=5
[B] 2208: 11-07 09:33:05.433  2202  2202 D NotificationListener: Panes settled - ending rebuild window early
[B] 6931: 11-07 09:33:20.007 32483   375 E music   : ------------>> MediaProvider query uri:  content://com.syu.media/song 1
[B] 8964: 11-07 09:33:21.235  2202  2202 D NotificationListener: Panes settled - ending rebuild window early
```

#### 5.2 AVRCP / A2DP / Bluetooth (bez SPP Android Auto)
```
[A] 2931: 11-07 10:51:37.852 28665 28678 D BluetoothDatabase: getBondedDevicesOrdered: Invalid address for device LocalStorage
[A] 11543: 11-07 10:51:47.864 28665 28681 D BluetoothDatabase: getBondedDevicesOrdered: Invalid address for device LocalStorage
[A] 11721: 11-07 10:51:48.054 28665 28681 D BluetoothDatabase: getBondedDevicesOrdered: Invalid address for device LocalStorage
[A] 15627: 11-07 10:51:56.266 28665 28778 I bluetooth: packages/modules/Bluetooth/system/gd/hci/hci_layer.cc:292 send_next_command: LE_ENERGY_INFO
[A] 15628: 11-07 10:51:56.270 28665 28778 I bluetooth: packages/modules/Bluetooth/system/gd/hci/hci_layer.cc:226 handle_command_response: middle
[A] 15629: 11-07 10:51:56.270 28665 28778 I bluetooth: packages/modules/Bluetooth/system/gd/hci/hci_layer.cc:279 send_next_command: return 3
[A] 20683: 11-07 10:52:02.742 28665 28678 D BluetoothDatabase: getBondedDevicesOrdered: Invalid address for device LocalStorage
[A] 20831: 11-07 10:52:02.945 28665 28678 D BluetoothDatabase: getBondedDevicesOrdered: Invalid address for device LocalStorage
```

#### 5.3 Czego brakuje i jak to przechwycić
Potrzebny jest nowy log z tym samym zakresem (`everything`, `-b all`, przez hosta VD), min. 90 s: FM → przełączenie na BT → start odtwarzania w telefonie → zmiana utworu x3 → pauza w telefonie → wznowienie → klik symbolu w widgecie → klik następnego utworu. W logu mają być (ze źródeł):

| Tag | Co loguje | Plik |
|---|---|---|
| `StockSources` | `started, channel N, shown …`; `bt <stan>` przy każdej publikacji; `bt cover: code 51 reports <ścieżka>` | `fyt/car/StockSources.java` ok. 118, `StockBtSource.java` ok. 177, 236 |
| `StockCovers` | wczytanie okładki (plik, rozmiar, powód odrzucenia) | `fyt/car/StockCoverLoader.java` |
| `SyuMedia`, `SyuMediaFiles` | odczyt providera `content://com.syu.media/…`, pliki | `SyuMediaClient.java`, `SyuMediaFiles.java` |
| `MediaTransport` | wybór sesji i komend transportu | `launcher66/MediaTransportController.java` |
| `MusicService` | zmiany tytułu, stan | `fyt/car/MusicService.java` |
| `E music: MediaProvider query uri: content://com.syu.media/song` | zapytania systemowego `com.syu.media` (są już w logach) | system, pid 32483 |

**Uwaga dla Opus:** tych logów dziś jest mało. Warto zdecydować, czy dodać do kodu (a) jedną linię na każdą decyzję `playing` w `buildTrack` z wartościami `btPlaying` i `CarStates.mAppID`, (b) log odrzucenia okładki (za stara/brak pliku/ścieżki), (c) log każdej komendy transportu z jej adresatem, zanim się zacznie zgadywać.

## 6. Wskaźniki do kodu (stan `4677b990`)
- `app/src/main/java/com/syu/util/WindowHostVdView.java:182–226` `startActivitySafely`, warunek skrótu 194–199; `WindowHostVdClient.java:481` `isDisplayEmpty`; `WindowHostVdDisplay.java:71/75` `getPackage`/`setPackage`.
- `app/src/main/java/com/syu/util/WindowUtil.java:1088–1181` `pane launch` (kolejność, „up after N ms”).
- `app/src/main/java/com/fyt/car/StockBtSource.java:141, 146, 177, 236, 243`; `StockSources.java:112–118, 256–260`; `StockRadioSource.java:222`.
- `app/src/main/java/com/android/launcher66/MediaTransportController.java:172–181, 224–226`; `LauncherMusicWidget.java:538, 589, 1517`.

## 7. Pytania do Opus
1. Dlaczego skrót „already runs” nie działa dla DAB, a działa dla Sygica: `vd.getPackage()` (ustawiane tylko w `startActivitySafely` po udanym starcie, po przejęciu displayu z poprzedniego panelu może być inne), czy `isDisplayEmpty` zwraca `null`/`TRUE`?
2. Czy po Home w ogóle trzeba ponownie uruchamiać aplikację w panelu, który już ją ma na displayu? Czy wystarczy przywiązać panel do istniejącego tasku (bez `MAIN/LAUNCHER` z `0x34720000`)?
3. Jak zabezpieczyć aplikacje, które nie znoszą ponownego `MainActivity` (DAB), np. start tylko gdy displej jest pusty, `FLAG_ACTIVITY_REORDER_TO_FRONT`/`SINGLE_TOP`, albo start `PlayerActivity` zamiast `MainActivity`?
4. BT: skąd bierze się stan odtwarzania w widgecie i dlaczego klik wraca do pauzy; czy kod 13 i `CarStates.mAppID` przychodzą na 7870 w tej samej kolejności co na starszych jednostkach?
5. BT: czy okładka po pierwszej zmianie utworu jest odrzucana jako „starsza niż zmiana” (zegar pliku vs `SystemClock`), i czy kod 51 przychodzi przy każdym utworze?
