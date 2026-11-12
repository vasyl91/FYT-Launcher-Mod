# CHAT_08 — Focus conflict with FYT's pinned PiP: launcher keyboard (folder rename) and closing the keyboard

| Field | Value |
|---|---|
| Conversation title | unknown |
| Approximate dates | 2026-10-28 (task, log captured 28-10-2026 14:17:45); this archive request 2026-11-11 |
| Model / role | Implementation. The session was configured for `claude-opus-5-5`; it analysed a log and the decompiled framework, then implemented, committed and pushed |
| Repository branch(es) mentioned | `ccr-087eed00-gbqsuz` (local and `origin/ccr-087eed00-gbqsuz`) |
| Report written | 2026-11-11 |

## 1. Aspect of the project discussed

- On the home-screen page where FYT's pinned PiP is shown, input focus stayed with the app in the PiP. As a result the soft keyboard could not be opened for launcher UI (renaming a folder). The keyboard opened by the PiP app could only be closed by a tap inside the PiP or by Back. [Historical] (owner's report)
- The owner reported that a windowed PiP (multi-PiP panes) does not cause the problem. [Historical]
- The cause, found from the log and the decompiled FYT framework, is described in section 6. [Confirmed]

## 2. Work performed

**Done (with evidence):**

1. **Analysed the owner's log** `/root/.claude/uploads/21fbf036-b4cc-516e-9ed8-bfc96ca0cbb2/9c1c8cf4-user_full_28-10-2026_14-17-45.txt`, 15046 lines. Its header reads `device=sprd ums512_1h10_Natv, android=10 (API 29)`. Key lines: [Confirmed]
   - `14:17:48.783 ... START ... app.revanced.android.youtube/.revanced_rounded_2` followed by `forcePip true`
   - `14:17:49.134 WindowManager: Input focus has changed to Window{78722bb u0 app.revanced.android.youtube/...}`
   - `14:17:50.913 CheckLongPressHelper: Has window focus: false`
   - `14:17:52.743 sysui_multi_action ... com.android.launcher66 ... edittext`, with no input start for the launcher
   - `14:17:52.775 ClipboardService: Denying clipboard access to com.android.launcher66, application is not in focus`
   - `14:17:54.989 LatinIME: Starting input`
   - `14:17:58.628 Back button event`
2. **Read that `LatinIME: Starting input` line as the PiP app's input.** Nothing in the log confirms which client it was. [Unverified]
3. **Read the decompiled FYT 7862 framework** in `decompiled_FYT_jars/7862/system.zip` (extracted to the scratchpad). Findings: [Confirmed]
   - `DisplayContent` focus search (the `mFindFocusedWindow` lambda) returns the topmost window that `canReceiveKeys()`.
   - `TaskStackContainers.mMpipStack` (mode 6) is always moved to the top.
   - `AppWindowToken.mpip()` returns true for windowing mode 6.
   - `WindowManagerService.handleTaskFocusChange()` returns early for the home stack.
   - `TaskPositioningController.handleTapOutsideTask()` only acts on `findTaskForResizePoint()`.
   - `ActivityTaskManagerService.setMpipVisible()` / `getMpipVisible()` and `ActivityManagerService.setPinnedStackVisible()` / `getPinnedStackVisible()` exist.
   - The client-side `InputMethodManager` uses `checkInputConnectionProxy()` in `showSoftInput`, `restartInput`, `isActive` and `updateSelection`.
4. **Confirmed that `getPinnedStackVisible()` is in FYT's AIDL.** It is present in `IActivityManager.java` from `decompiled_FYT_jars/7870/system.zip` (`TRANSACTION_getPinnedStackVisible = 232`). The 7862 zip had no `IActivityManager.java`. [Confirmed]
5. **Implemented the fix and committed it** locally as `a63f42c`, titled "Pinned PiP: the launcher takes the focus back when it is touched". After a rebase it was pushed as `d9fc21d` (`4f6ee7d..d9fc21d`). [Confirmed]
   - New file: `app/src/main/java/com/android/launcher66/PinnedPipFocus.java`.
   - Modified: `Launcher.java`, `PinnedPip.java`, `WindowUtil.java`, `Folder.java`, `FolderEditText.java`, `DragController.java`, `CheckLongPressHelper.java`, `settings/CanbusService.java`, `settings/StateAccessibilityService.java`, and the test `PinnedPipTest.java`.
   - 11 files in total, 443 insertions and 1 deletion.
6. **Verification:** [Confirmed]
   - `PinnedPip.java` and `PinnedPipFocus.java` compiled with `javac` against `android_jar/android-36.jar`, using hand-written stubs for `Launcher`, `LauncherApplication`, `Keys` and `PreferenceManager`. The only warnings came from annotations inside android.jar.
   - A parse-only syntax check passed on all 11 changed Java files.
   - `PinnedPipTest` passed 6/6 using `junit-platform-console-standalone-1.10.2` (sha1 `552303cce67dc3485ded393d744c0f6b5cae355b`, matching Maven Central).
7. **Rebased before the push.** The remote branch had gained 8 commits (`3a0217e`, `b38f128`, `fdc0100`, `4a593c5`, `7ae6869`, `de25567`, `8bddb4c`, `4f6ee7d`: the Cling removal and a Canbus revert). The rebase had no conflicts. The hooks were re-checked in place and the syntax check re-run. [Confirmed]

**Not done:**

- No full Gradle/APK build: the container has no Android SDK. [Confirmed]
- No test on a device. [Confirmed]
- No feedback from the owner that the fix works. [Confirmed]

## 3. Requirements discovered

- "Spodziewane zachowanie to możliwość otworzenia klawiatury zarówno dla aplikacji otworzonej w PiP jak i poza nią na ekranie launchera (np. wspomniana zmiana nazwy w folderze z logu)". [Historical]
- The keyboard must close the same way in both cases: "standardowo poprzez dotknięcie ekranu poza jej obszarem, przycisk back czy też inne standardowe zachowania". [Historical]
- "Problem pojawia się tylko i wyłącznie na ekranie, na którym uruchomiony jest pinned PiP. Aplikacja działająca w windowed PiP nie wywołuje już takiego konfliktu." [Historical]
- "Nie zmieniaj istniejącej logiki wykraczającej poza ten problem, a miejsca w kodzie, które mogłyby coś namieszać po wykonanym fixie oznacz odpowiednim komentarzem." [Historical]
- "Napraw ten problem i zacommituj." [Historical]
- Session rules required:
  - development on branch `ccr-087eed00-gbqsuz`;
  - no PR unless asked;
  - no model identifier in commits;
  - fixed attribution lines in commit messages. [Historical]

## 4. Architectural and technical decisions

All decisions below were made by the assistant. None was discussed with or approved by the owner beyond the original request.

1. **A focus-holding overlay window.** `PinnedPipFocus` adds a 1×1 transparent `TYPE_APPLICATION_OVERLAY` window. Flags: `FLAG_NOT_TOUCHABLE | FLAG_NOT_TOUCH_MODAL | FLAG_WATCH_OUTSIDE_TOUCH | FLAG_LAYOUT_IN_SCREEN | FLAG_LAYOUT_NO_LIMITS`, gravity TOP|LEFT, `SOFT_INPUT_STATE_UNSPECIFIED | SOFT_INPUT_ADJUST_NOTHING`. Reason: the launcher's activity window can never sit above the mpip stack, so only a window of the launcher that does sit above it can take the focus. [Confirmed] implemented. Whether it works on a device: [Unverified]
2. **When the overlay is added.** It is attached in `Launcher.dispatchTouchEvent` on ACTION_DOWN only when all of these hold: [Confirmed]
   - the launcher's window has no focus;
   - a pane is set to pinned mode (prefs, read without side effects);
   - `IActivityManager.getPinnedStackVisible()` (via reflection) returns true.

   If the reflection fails, the PiP is treated as shown. [Confirmed]
3. **The keyboard is routed to the launcher's text field through a proxy.** The overlay's `FocusView` takes the focused text editor of the launcher window. It delegates `onCreateInputConnection` to that field and returns true from `checkInputConnectionProxy` for it. This keeps the folder-name field where it is with no UI change. [Confirmed] implemented. Behaviour: [Unverified]
4. **A touch on the PiP is recognised by zeroed coordinates.** An `ACTION_OUTSIDE` whose `getRawX()` and `getRawY()` are both 0 counts as a touch on another app's window. The reasoning is that InputDispatcher sets FLAG_ZERO_COORDS for other-uid targets. The rule is `PinnedPip.outsideTouchOnOtherApp()` and has tests. [Confirmed] implemented. The InputDispatcher behaviour was recalled from AOSP and not read in FYT's native code. [Unverified]
5. **When the overlay is removed.** Each release also closes the overlay's keyboard. Triggers: [Confirmed]
   - a touch on another app's window (the release is posted);
   - the three `setPinnedStackVisible(false)` call sites in `WindowUtil` (in `openPip`, `removePip` and `hidePinnedStackNow`);
   - `com.lsec.pipdie` in `CloseSystemDialogsIntentReceiver`;
   - `Launcher.onPause()`, placed before its early return;
   - `Launcher.onDestroy()`;
   - a launcher touch once `getPinnedStackVisible()` returns false.
6. **Keys are forwarded to the launcher.** Pre-IME keys go to the launcher decor's `dispatchKeyEventPreIme`, which reaches `FolderEditText.onKeyPreIme`. Post-IME keys go to `Launcher.dispatchKeyEvent`. A consequence: after a touch on the launcher, Back goes to the launcher, not to the PiP app. [Confirmed] implemented. Whether the owner accepts this behaviour change: unknown.
7. **`FieldConnection` wraps the field's InputConnection.** Its `sendKeyEvent()` dispatches straight to the field's root view. Reason given: `BaseInputConnection` queues key events on the field's `ViewRootImpl`, which drops them while that window has no focus. [Confirmed] implemented. The reason comes from AOSP knowledge. [Unverified]
8. **How input restarts when the launcher's focused view changes.** A global focus listener on the launcher decor drives it. A new text field is restarted synchronously, because `TextView.onTouchEvent` asks for the keyboard right after taking focus. When the field loses focus, the keyboard is hidden and the restart is posted, because the change can happen inside an editor-action call on the field's own connection. [Confirmed]
9. **The existing `hideSoftInputFromWindow(launcher token)` calls were left unchanged.** They are marked with comments; `PinnedPipFocus` does the hiding itself. This follows the owner's rule against changing logic. [Confirmed]
10. **Places that could interfere were marked with `PinnedPipFocus:` comments.** [Confirmed]
    - `Launcher`: `mHasFocus`/`alreadyOnHome` (2 places), `onWindowFocusChanged`, the IME hide in `onNewIntent`
    - `CanbusService` (`alreadyOnHome`)
    - `CheckLongPressHelper`
    - `Folder.startEditingFolderName()` / `dismissEditingName()`
    - `FolderEditText.onKeyPreIme()`
    - `DragController.startDrag()`
    - `StateAccessibilityService`

## 5. Rejected decisions and why

These alternatives were weighed only in the assistant's internal analysis. None was discussed with the owner.

- **Hiding the pinned PiP while the folder name is edited** (`setPinnedStackVisible(false)`): the PiP would disappear, while the owner wants the keyboard to work in both places. [Unverified]
- **Moving the folder-name editing into an overlay EditText:** a visible UI change. [Unverified]
- **Making the mpip window non-focusable, or putting the launcher window above it:** no API the launcher can use. Only hiding the stack changes focusability, per the decompiled `setMpipVisible` and `lsecSetVisble`. [Confirmed] as code-reading. That nothing else is possible: [Unverified]
- **Using `FLAG_ALT_FOCUSABLE_IM` / IME-target tricks on the launcher window:** the IME target and the focused client would still be the topmost mpip window. This was based on recalled AOSP `computeImeTarget` / `isInputMethodClientFocus`, not read in FYT code. [Unverified]
- **Injecting a Back key to close the PiP app's keyboard:** it would hit the PiP app when no keyboard is shown, and the standard version cannot inject. [Unverified]
- **Matching `ACTION_OUTSIDE` to the launcher's DOWN by timing:** the delivery order is not deterministic and could make the focus flicker. [Unverified]
- **Keeping the overlay attached permanently:** it would get outside events for touches in other apps and wake the launcher process. [Unverified]

## 6. Problems encountered and their solutions

1. **No keyboard for the folder rename while the pinned PiP is shown.**
   - Cause: the mpip stack is always the top stack and focusable (mode 6, not 2). The focus search returns the topmost window that can receive keys. A tap on the launcher does not move the focus: the home stack is ignored, and tap-to-focus covers only resize-point (freeform) tasks. The IME serves only the focused client. [Confirmed] from the log and the decompiled code.
   - Solution: `PinnedPipFocus` (section 4). Whether it works on a device: [Unverified]
2. **The PiP app's keyboard could only be closed by a tap in the PiP or Back.**
   - Cause: the same.
   - Solution: taking the focus at a launcher touch hides the keyboard, both through IMMS's `SOFT_INPUT_STATE_UNSPECIFIED` handling and through an explicit `hideSoftInputFromWindow` on the overlay token. [Unverified] on a device.
3. **A possible crash or warning from removing the overlay while it handles its own input event.** The release is posted to the main thread and guarded with `sView == this`. [Unverified] (a precaution)
4. **`git push` was rejected** because the remote branch had 8 newer commits. Solved with `git fetch` and a rebase without conflicts, then pushed `d9fc21d`. [Confirmed]
5. **Maven Central returned HTTP 429** when downloading the JUnit console jar. A retry worked and the sha1 was verified. [Confirmed]
6. **No Android SDK in the container**, so no Gradle build. Worked around with a javac compile against stubs and a parse-only check. The full build is still not done. [Confirmed]

## 7. Features implemented or discussed

- `PinnedPipFocus`: the overlay that holds the focus and proxies the keyboard. Implemented, with no runtime test. [Confirmed] for the code
- Back and other keys forwarded to the launcher while the overlay has the focus. Implemented. [Confirmed]
- `PinnedPip.outsideTouchOnOtherApp()` and 2 new tests in `PinnedPipTest`. Implemented, tests pass. [Confirmed]
- Release hooks in `WindowUtil` and `Launcher`. Implemented. [Confirmed]
- Marker comments at the places that could interfere. Implemented. [Confirmed]

## 8. Important constraints

- The test device in the log: `sprd ums512_1h10_Natv`, Android 10 (API 29). [Confirmed] (log header)
- Pinned PiP is offered on FYT units whose stock player is `com.syu.music` (7862, 8581), not on the 7870 (`com.syu.media`); see `PinnedPip.supported()` and `LauncherApplication.supportsPinnedPip()`. [Confirmed] (code read)
- Per `PinnedPipLaunch.WINDOWING_MODE_FYT_PINNED`, mode 6 means FYT's pinned stack only up to Android 10. [Confirmed] (code comment read)
- The standard version (a user app) needs overlay permission (`Settings.canDrawOverlays`). Without it the fix is skipped. [Confirmed] (code). Whether a user app may call `getPinnedStackVisible()` through reflection under hidden-API rules: [Unverified]
- The manifest declares `android:windowSoftInputMode="adjustPan"` at line 139. Which activity that line belongs to was not verified. [Unverified]
- Owner's rules: do not change logic beyond the problem, mark risky places with comments, commit. Session rules: work on branch `ccr-087eed00-gbqsuz`, no PR unless asked. [Historical]

## 9. Unresolved questions

- Does the fix work on a real FYT 7862/8581? Not tested. [Unverified]
- The first tap into a text field in the PiP right after a launcher touch may race with the focus handover, so the keyboard may need a second tap. [Unverified]
- Does the owner accept that Back now goes to the launcher after a launcher touch, where before it always went to the PiP app? Not discussed.
- When the accessibility fallback is used (`StateAccessibilityService`), it will now report the PiP package and the launcher package in turn. Whether that affects CanbusService's fuel-stats display: [Unverified]
- With the overlay as the focused window, its system-UI flags (none) control the status and navigation bar logic. Whether FYT's navigation-bar behaviour changes: [Unverified]
- Launcher dialogs or popups with text fields are not covered while the pinned PiP is shown (they sit below mpip). Not handled. [Unverified]
- Behaviour on FYT units running Android 11+ with pinned PiP. Not examined.
- The full Gradle build was not run. Compile errors in `Launcher.java` / `WindowUtil.java` against the real project classpath were not ruled out; only the syntax was checked. [Confirmed] that this was not checked

## 10. Information that may be missing from the repository

- The detailed evidence from the decompiled framework (the `DisplayContent` focus lambda, `TaskStackContainers` ordering, `handleTaskFocusChange`, `TaskPositioningController`, `getMpipVisible` semantics). It is only summarised in the `PinnedPipFocus` Javadoc and the commit message. [Confirmed]
- The log analysis with exact timestamps. It is partly in the Javadoc and the commit message; the full log is not in the repo. [Confirmed]
- How the change was verified (compile with stubs, parse check, 6/6 tests, no device test, no Gradle build). [Confirmed]
- The alternatives that were rejected and why (section 5). [Unverified]
- That the owner has not yet confirmed the behaviour on a device. [Confirmed]

## 11. Relevant file paths and references

**Files:**
- Created: `app/src/main/java/com/android/launcher66/PinnedPipFocus.java`
- `app/src/main/java/com/android/launcher66/PinnedPip.java`
- `app/src/test/java/com/android/launcher66/PinnedPipTest.java`
- `app/src/main/java/com/android/launcher66/Launcher.java`: `dispatchTouchEvent`, `onWindowFocusChanged`, `onPause`, `onDestroy`, `onNewIntent`, `CloseSystemDialogsIntentReceiver`
- `app/src/main/java/com/syu/util/WindowUtil.java`: `openPip`, `removePip`, `hidePinnedStackNow`
- `app/src/main/java/com/android/launcher66/Folder.java`
- `app/src/main/java/com/android/launcher66/FolderEditText.java`
- `app/src/main/java/com/android/launcher66/DragController.java`
- `app/src/main/java/com/android/launcher66/CheckLongPressHelper.java`
- `app/src/main/java/com/android/launcher66/settings/CanbusService.java`
- `app/src/main/java/com/android/launcher66/settings/StateAccessibilityService.java`

**Read for context only:**
- `app/src/main/java/com/syu/util/PinnedPipLaunch.java`
- `app/src/main/java/com/android/launcher66/DragLayer.java`
- `app/src/main/java/com/syu/util/WindowHostVdView.java`
- `app/src/main/java/com/android/launcher66/settings/ForegroundAppTracker.java`
- `app/src/main/java/com/syu/util/Utils.java`
- `app/src/main/AndroidManifest.xml`

**Decompiled framework:**
- `decompiled_FYT_jars/7862/system.zip`: `DisplayContent.java`, `AppWindowToken.java`, `WindowState.java`, `WindowManagerService.java`, `TaskTapPointerEventListener.java`, `TaskPositioningController.java`, `ActivityTaskManagerService.java`, `ActivityRecord.java`, `ActivityStack.java`, `TaskStack.java`, `ActivityManagerService.java`, `InputMethodManager.java`
- `decompiled_FYT_jars/7870/system.zip`: `IActivityManager.java`

**Commits:**
- `a63f42c`: the local commit before the rebase
- `d9fc21d`: the pushed commit
- `998d56f`: the original base
- `4f6ee7d`: the remote tip before the push
- `3a0217e`, `b38f128`, `fdc0100`, `4a593c5`, `7ae6869`, `de25567`, `8bddb4c`: the other remote commits that the rebase went onto

**Log:** `user_full_28-10-2026_14-17-45.txt` (upload path in section 2)

## Summary by label
- Confirmed: 49, Historical: 9, Suggestion: 0, Unverified: 24