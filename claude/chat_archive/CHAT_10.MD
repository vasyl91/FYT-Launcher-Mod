# CHAT_10 — Pinned PiP fixes on FYT and reducing panecanbus-stats lag while pages scroll (7862, A55)

 Field  Value 
------
 Conversation title  unknown 
 Approximate dates  2026-10-27 to 2026-10-28, from the log timestamps 27-10-2026 2331, 2355, then 0057, 0122, 0201, 0229. The exact first and last message dates are unknown. 
 Model  role  Implementation and log analysis, plus one design discussion (embedding) 
 Repository branch(es) mentioned  `ccr-087eed00-gbqsuz` (repo `vasyl91FYT-Launcher-Mod`) 
 Report written  2026-11-11 

## 1. Aspect of the project discussed
- Pinned PiP behaviour on FYT units [Confirmed]
  - starting it without breaking the windowed PiPs;
  - no jump to the home page;
  - closing it at once on a page swipe;
  - opening it as soon as the pages stop.
- Release-and-regrab bug [Confirmed] releasing and regrabbing the moving screens turned off both the pinned PiP and the canbus stats window.
- Window sync during page scrolling [Confirmed] keeping the windowed PiP panes and the canbus stats overlay in step with the launcher's scrolling. This was done on the 7862 (Android 10) and on the A55, where the code treats relayout as async (API ≥ 34).
- Design discussion only [Confirmed] pros and cons of embedding the ActivityViewVD host in the launcher window.

## 2. Work performed
Done. Each fix was committed and pushed to `ccr-087eed00-gbqsuz`. Hashes are known only where given.

1. [Confirmed] Pinned PiP regression fix (hash unknown).
   - `DefaultDisplayTask.FYT_PINNED_MODE = SDK_INT = Q`.
   - `PinnedPipLaunch.WINDOWING_MODE_FYT_PINNED = 6` and `canCoverHome(mode, fytPinnedMode)`.
   - `outsidePinned(displayId)` now decides by display only (`displayId = 0 && displayId != 0`).
   - The user then reported Działa niemal idealnie (log 2355).
2. [Confirmed] No jump to the default screen on the launcher's own restart of the pinned app.
   - `WindowUtil.forceStopPinnedPipApp()` records `sOwnForceStopUptimeMs`.
   - `pipDieFromOwnForceStop()` and `PinnedPipLaunch.answersOwnForceStop(now, forceStoppedAt, windowMs)` were added; the tests use a 2000 ms window.
   - `Launcher.CloseSystemDialogsIntentReceiver` skips `moveToDefaultScreen` for `com.lsec.pipdie` when the pipdie answers the launcher's own force stop.
3. [Confirmed] Hide delay.
   - `PinnedPipLaunch.hideMustWait(coldStart, now, startedAt, settleMs)` makes only a cold start that is still settling wait (1500 ms in the tests).
   - `sPinnedColdStart` is determined in `startPinnedPip` via `WindowHostActivityView.isProcessAlive`, with the log line warmcold start, N ms after the pages last stopped.
4. [Confirmed] Opening delay.
   - `PagedView.computeScrollHelper` aborts the scroller once currXcurrY equal finalXfinalY, while `mNextPage != INVALID_PAGE` and the interpolator is `ScrollInterpolator`. The quintic tail is pixel-identical.
   - `WindowUtil.setPersistentProperty()` was added.
   - The 250 ms and 100 ms waits were kept, at the user's request.
5. [Confirmed] Regrab bug code change made. `Workspace.enterOverviewMode()` now checks `mTouchState != TOUCH_STATE_REST` first, and the old later check was removed.
   - [Unverified] The user never explicitly confirmed that this fixed the bug.
6. [Confirmed] A55 WindowManager backlog, in `WindowUtil.updatePipPositionsForScroll`.
   - Off-screen skip while `pagesMoving`, against `paneViewportWidth` from `Display.getRealSize`.
   - Relayout budget `PANE_RELAYOUTS_PER_SECOND = 80` with a 2 ms tolerance on API ≥ 34.
   - `lastRequestedScrollOffset` is flushed in `onPagesSettled()`.
   - New helpers `PaneWindows.relayoutIsAsync`, `staysOffScreen` and `withinRelayoutBudget`.
   - On API ≥ 34 the stats sit in a page-wide `statsHost` window and move by `translationX`.
   - Measured in the A55 log 0201 median 6–9 ms against about 540 ms before. The user said the A55 is niemal idealnie.
7. [Historical] Two earlier attempts for the 7862 stats. Commits `1cccf3c` and `998d56f` were 7862 stats attempts, but after them the stats still lagged (Na 7862 okno statystyk nadal wyraźnie odstaje, then Nadal odstaje). Their exact content is not preserved in this conversation's summary.
8. [Confirmed] Commit `3a0217e`, Canbus on the 7862 the stats' surface moves with the launcher's frame, pushed.
   - New class `appsrcmainjavacomsyuutilWindowSurfaceMover.java`, wired into `CanbusService` for the NO_LIMITS stats window on Android  14.
   - The workspace scroll listener returns while `isPageMoving()`.
   - `Workspace.onPageEndMoving()` calls `CanbusService.onPagesSettled(mUnboundedScrollX)`.
9. [Confirmed] Checks run.
   - 27 unit tests pass `PinnedPipLaunchTest` (17) and `PaneWindowsTest` (10).
   - javac shows no new errors; the 5409 errors were already there, and none are in changed hunks.
   - `WindowSurfaceMover` compiles on its own against android-36.jar.

Planned or discussed only
- [Suggestion] Embedding the ActivityViewVD host in the launcher window. This was discussed only and never implemented.

## 3. Requirements discovered
- [Historical] Git workflow
  - Commit each fix and push to `ccr-087eed00-gbqsuz`.
  - No PR.
  - Commit messages are in English, in the style `Area what`, with bodies that cite the logs.
- [Historical] Pinned PiP must not break other things. The original complaint Włączanie pinned PiP wyłącza pozostałe windowed PiPs, sam pinned PiP ostatecznie się wtedy nie włącza, ponadto ekrany zostają przesunięte do home screen.
- [Historical] No jump on the launcher's own restarts Tak, wyłącz ten przeskok dla restartów launchera.
- [Historical] Close at once, open at once Przechodzenie między ekranami powinno zamykać go od razu … a uruchomienie powinno następić natychmiast po tym jak ekran się zatrzyma po swipe.
- [Historical] Keep the deliberate waits 'a otwieranie dodatkowo czeka 250 ms w onPageEndMoving i 100 ms w startPinnedPip' to zostaw, popraw tylko pozostałe opóźnienia.
- [Historical] Regrab must not kill windows. Releasing and regrabbing the moving screens must not turn off the pinned PiP or the canbus stats window.
- [Historical] Scope of the lag work. Only the 7862 stats window needs fixing Poprawki wymaga tylko okno statystyk na 7862. The host-app panes are acceptable te są akceptowalne.

## 4. Architectural and technical decisions
- [Confirmed] Mode 6 counts as FYT's pinned stack only up to Android 10 (`SDK_INT = Q`).
  - Reason FYT's mpip stack is `getOrCreateStack(6,0,true)`, while from Android 11 on mode 6 is any multi-window task.
  - Decided by the assistant; covered by tests.
- [Confirmed] A task is outside pinned by display only.
  - Reason FYT's ActivityStarter moves full-screen tasks into that stack itself.
  - Decided by the assistant.
- [Confirmed] A pipdie within the window after the launcher's own force stop does not move to the default screen.
  - Decided by the user (Tak, wyłącz ten przeskok).
- [Confirmed] Only a cold start that is still settling delays the hide.
  - Reason log 2355 showed warm starts hidden 0.7–0.8 s late.
  - Decided by the assistant.
- [Confirmed] Off-screen skip and an 80s relayout budget on API ≥ 34.
  - Reason `relayoutAsync` is oneway with no backpressure. On the A55, WindowManager handled 100–150 relayoutss while the launcher sent about 190s, giving a 400–530 ms backlog.
  - Decided by the assistant.
- [Confirmed] On API ≥ 34 the stats move by translation inside a page-wide host window, so moving them needs no WindowManager relayout.
  - Decided by the assistant.
- [Confirmed] On Android  14 the stats window uses `FLAG_LAYOUT_NO_LIMITS`, so WindowManager does not clamp its position.
  - Decided by the assistant.
- [Confirmed] Direct SurfaceFlinger positioning for the 7862 stats (commit `3a0217e`).
  - Mechanism a RenderThread frame callback via `registerRtFrameCallback`, then `deferTransactionUntilSurface` + `setPosition`. This is the pattern of SurfaceView and `SyncRtSurfaceTransactionApplier`.
  - WindowManager is updated once the pages stop. There is a fallback to WindowManager moves (`MAX_UNANSWERED = 6`, the reflection checks).
  - Requested by the user zrób wersję z bezpośrednim przesuwaniem surface.
- [Confirmed] The scroll listener skips while the pages move.
  - Reason `ViewRootImpl.draw()` dispatches OnScrollChanged before `computeScroll`, so the listener saw the previous frame's scroll and set the stats back a frame during snaps.
  - Decided by the assistant.
- [Confirmed] The `WindowHostVdView.recomposeDisplay()` one-off WindowManager busy period on the A55 is left as is. This follows the user's jeśli tu nie ma już większego pola do popisu to tak zostawiamy.

## 5. Rejected decisions and why
- [Historical] Embedding the ActivityViewVD host in the launcher window. The user rejected it Takiej zmiany nie wprowadzaj and Pomijamy zatem pomysł wbudowywania tych elementów w okno launchera. The details of the assistant's proscons analysis and its verdict are not preserved in this summary.
- [Historical] Removing the 250 ms wait in `onPageEndMoving` and the 100 ms wait in `startPinnedPip`. The user said to leave them.
- [Historical] Further optimisation of the A55 and of the 7862 host-app panes. The user declined it unless there is significant room left.

## 6. Problems encountered and their solutions
- [Confirmed] Pinned PiP broke the windowed PiPs, never showed, and the pages jumped home (log 2331).
  - Cause the FYT mode-6 pinned stack was not recognised. This caused restart (force-stop) behaviour and a home-cover decision for it, and the resulting `com.lsec.pipdie` triggered `moveToDefaultScreen`.
  - Fixed per items 1–2 of section 2.
  - The user confirmed it works (Działa niemal idealnie).
- [Confirmed] The pinned PiP stayed on screen after a swipe.
  - Cause the settle wait applied to warm starts too (log 2355).
  - Fixed with `hideMustWait`.
  - The next feedback was Niemal idealnie, with only the regrab bug left.
- [Confirmed] The pinned PiP opened late after the pages stopped.
  - Cause the quintic snap tail, plus the persist writes.
  - Fixed with the `PagedView` early abort and `setPersistentProperty()`.
  - Confirmed by the same Niemal idealnie feedback.
- Regrab turned off the pinned PiP and the stats (log 0057).
  - Cause a stuck overview state (`enterOverviewMode`), identified by the assistant.
  - Fixed with the `mTouchState` check first.
  - [Unverified] whether it works on device.
- [Confirmed] A55 panes and stats lagged.
  - Cause the async relayout backlog.
  - Fixed with the off-screen skip, the budget, and moving the stats out of WindowManager.
  - Confirmed by log 0201 and by the user.
- The 7862 stats lagged worse after `4f94b19` [Historical, per the user].
  - Causes identified
    - one RenderThread per process draws the launcher frame first, so the stats buffer comes a vsync late (the assistant's analysis);
    - the scroll listener used the previous frame's scroll.
  - Fixes `1cccf3c` and `998d56f` were not enough, then `3a0217e`.
  - [Unverified] whether `3a0217e` works; it is untested on device.
- [Confirmed] Development errors, all fixed before commit
  - integer division in `withinRelayoutBudget` (12 instead of 12.5), fixed with `1000.0`;
  - `desiredY` used before its declaration;
  - the Edit tool stripped trailing whitespace, restored with python;
  - the Proxy class loader was null, changed to the app loader;
  - a held finger could raise the unanswered counter, fixed by deduplicating identical positions;
  - the viewport width came from pageWidth, changed to the display's real width.
- [Confirmed] An inaccurate claim in the PagedView commit message was amended before the push.

## 7. Features implemented or discussed
- Pinned PiP on FYT up to Android 10 (mode 6) implemented [Confirmed]
- No page jump on the launcher's own restart of the pinned PiP implemented [Confirmed]
- Immediate hide on swipe for a warm start implemented [Confirmed]
- Faster pinned PiP open (snap tail abort), with the 250100 ms waits kept implemented [Confirmed]
- Regrab fix implemented, effect not confirmed [Unverified]
- Pane relayout budget and off-screen skip on API ≥ 34 implemented [Confirmed]
- Stats in a page-wide host window with translation on API ≥ 34 implemented [Confirmed]
- `WindowSurfaceMover`, direct surface moves for the 7862 stats implemented, untested on device [Unverified]
- Embedding the ActivityViewVD host in the launcher window discussed only [Suggestion]

## 8. Important constraints
- [Confirmed] Hidden API through reflection. `WindowSurfaceMover` uses hidden Android 10 API. `deferTransactionUntilSurface` is gone from Android 12 on, so `create()` returns null there.
- [Unverified] The 7862 runs Android 10 with system privileges. The new path assumes system privileges; this was stated by the assistant and not checked.
- [Unverified] The A55's exact Android version is never stated. The code treats it as API ≥ 34 (async relayout).
- [Confirmed] FYT specifics
  - the mpip stack is mode 6;
  - the pinned package is kept in `persist.launcher.packagename`;
  - `com.lsec.pipdie` is sent on death of the pinned process;
  - FYT's `startPausingLocked` does not pause other stacks for mode-6 resumes.
- [Confirmed] No full Gradle build was possible in the environment. Checks were javac against android-36.jar plus the unit tests.
- [Historical] Owner rules replies in Polish, commits on the given branch, no PR, no model identifiers in repo content.

## 9. Unresolved questions
- [Unverified] Does `3a0217e` actually remove the 7862 stats lag
  - Which path runs is shown by the log line stats follow the pages with their surface (new path) or through WindowManager (fallback).
  - The measured offset is shown by stats surface offset ….
  - `WindowSurfaceMover` warnings appear only on failure.
  - The 7862 log needed to answer this had not arrived when the conversation ended.
- [Unverified] Is the regrab fix confirmed on device
- [Unverified] Is the regression from `4f94b19` on the 7862 fully explained by the two causes found
- [Historical] The A55 recomposeDisplay one-off busy period was left unaddressed by choice.
- The assistant's verdict on embedding not preserved in this summary (unknown).

## 10. Information that may be missing from the repository
- [Confirmed] A55 measurements
  - WindowManager handled 100–150 relayoutss against about 190s sent, a 400–530 ms backlog;
  - after the fix the median was 6–9 ms against about 540 ms (log 0201).
- [Confirmed] Log 2355 the pinned PiP was swiped away 0.67–0.8 s after a warm start and hidden 0.7–0.8 s later. This is partly in the test comments.
- [Historical] Owner preferences
  - keep the 250100 ms waits;
  - the 7862 panes are acceptable;
  - the A55 is niemal idealnie;
  - embedding is rejected.
- [Historical] Commits `1cccf3c` and `998d56f` did not fix the 7862 stats lag.
- [Confirmed] Why the listener skips during movement OnScrollChanged runs before `computeScroll`.

## 11. Relevant file paths and references
Source files
- `appsrcmainjavacomsyuutilPinnedPipLaunch.java`
- `appsrcmainjavacomsyuutilWindowUtil.java`
- `appsrcmainjavacomsyuutilPaneWindows.java`
- `appsrcmainjavacomsyuutilWindowSurfaceMover.java` (new in `3a0217e`)
- `appsrcmainjavacomandroidlauncher66DefaultDisplayTask.java`
- `appsrcmainjavacomandroidlauncher66PagedView.java`
- `appsrcmainjavacomandroidlauncher66Launcher.java`
- `appsrcmainjavacomandroidlauncher66Workspace.java`
- `appsrcmainjavacomandroidlauncher66settingsCanbusService.java`

Tests
- `appsrctestjavacomsyuutilPinnedPipLaunchTest.java`
- `PaneWindowsTest` (exact path not shown)

Other classes mentioned `WindowHostActivityView`, `WindowHostVdView`, `HomeFrontGuard`, `android.view.SyncRtSurfaceTransactionApplier`

Commits `3a0217e`, `1cccf3c`, `998d56f`, `4f94b19`. Hashes of the other fixes unknown.

Logs
- 7862 27-10-2026 2331, 2355, 0057, 0229
- A55 0122, 0201
- Intents `com.lsec.pipdie`

## Summary by label
- Confirmed 39, Historical 14, Suggestion 2, Unverified 9