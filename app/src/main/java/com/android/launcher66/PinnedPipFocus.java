package com.android.launcher66;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputMethodManager;

import androidx.preference.PreferenceManager;

import com.android.launcher66.settings.Keys;

import java.lang.reflect.Method;

/**
 * Gives the input focus back to the launcher when it is touched while FYT's pinned PiP is shown,
 * and back to the PiP when that is touched.
 *
 * <p>FYT's pinned stack (windowing mode 6, decompiled 7862 framework) is always the top stack of
 * the main display and, unlike AOSP's pinned mode 2, its windows take keys. WindowManager gives the
 * focus to the topmost window that can take it (DisplayContent's mFindFocusedWindow), so while the
 * pinned PiP is shown its app has the focus whatever the user touches: a tap on the launcher does
 * not move it (WindowManagerService.handleTaskFocusChange() leaves the home stack alone, and a tap
 * moves it between tasks for freeform ones only). The input method only serves the focused window,
 * so the launcher could not open the keyboard (log 28-10-2026 14:17: the YouTube PiP took the focus
 * at 49.134, the folder's name was tapped at 52.743 and no input started, "Has window focus:
 * false"), and the PiP app's keyboard could only be closed by a tap in the PiP or Back. The window
 * panes live on displays of their own and do not have this.
 *
 * <p>The launcher's window can never be above the pinned stack, so a window of its own that is
 * takes the focus for it: a 1x1 transparent overlay (TYPE_APPLICATION_OVERLAY, above every app
 * window), added at a touch on the launcher while the launcher's window has no focus and the pinned
 * PiP is shown. It goes at a touch on another app's window (the PiP, a window pane's app), when the
 * pinned stack is hidden or its app dies, and when the launcher pauses. Its only view stands in for
 * the launcher's focused text field towards the input method (View.checkInputConnectionProxy(), as
 * AutoCompleteTextView's popup does), so the keyboard types into the folder's name where it is,
 * and the keys it gets go on to the launcher (Back, ...). Taking the focus closes the keyboard the
 * PiP app had open, as a tap outside a keyboard does anywhere else.
 *
 * <p>While it has the focus, the launcher's own window still has none, as before while the PiP had
 * it: Launcher.mHasFocus, View.hasWindowFocus() and Launcher.onWindowFocusChanged() say so. And an
 * InputMethodManager call made with the launcher window's token (hideSoftInputFromWindow()) does
 * nothing: the input method's window is this one. This class closes the keyboard itself when the
 * launcher's focused view stops taking text.
 *
 * <p>Main thread, but release() may be called from any thread.
 */
public final class PinnedPipFocus {

    private static final String TAG = "PinnedPipFocus";

    private static final Handler MAIN = new Handler(Looper.getMainLooper());

    /** The overlay while it is up, null otherwise. Main thread. */
    private static FocusView sView;
    private static WindowManager sWindowManager;

    private static Method sGetService;
    private static Method sGetPinnedStackVisible;
    private static boolean sVisibilityFailureLogged;
    private static boolean sNoOverlayPermissionLogged;

    private PinnedPipFocus() {
    }

    /**
     * Launcher.dispatchTouchEvent(), ACTION_DOWN: the user works in the launcher. Takes the focus
     * when the pinned PiP keeps it from the launcher's window.
     */
    static void onLauncherTouchDown(Launcher launcher) {
        try {
            if (sView != null) {
                // The pinned stack may have gone without the launcher hiding it (its app ended):
                // without a PiP the launcher's window can have the focus itself.
                if (!pinnedStackShown()) {
                    release("the pinned PiP is gone");
                }
                return;
            }
            if (launcher.hasWindowFocus() || !pinnedPaneSet()) return;
            // A binder call: only made when the launcher is touched without having the focus.
            if (!pinnedStackShown()) return;
            attach(launcher);
        } catch (RuntimeException e) {
            Log.w(TAG, "Taking the focus from the pinned PiP failed", e);
        }
    }

    /**
     * Gives the focus up: the overlay goes, with the keyboard it had open. The focus is then the
     * pinned PiP app's while the PiP is shown, and the launcher window's when it is not.
     */
    public static void release(String why) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            MAIN.post(() -> release(why));
            return;
        }
        FocusView view = sView;
        if (view == null) return;
        sView = null;
        view.closeKeyboard();
        try {
            sWindowManager.removeViewImmediate(view);
        } catch (RuntimeException e) {
            Log.w(TAG, "Removing the focus window failed: " + e);
        }
        Log.i(TAG, "focus given up (" + why + ")");
    }

    private static void attach(Launcher launcher) {
        Context context = launcher.getApplicationContext();
        if (!Settings.canDrawOverlays(context)) {
            if (!sNoOverlayPermissionLogged) {
                sNoOverlayPermissionLogged = true;
                Log.w(TAG, "No overlay permission: the pinned PiP keeps the focus");
            }
            return;
        }
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(1, 1,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                // Not touchable: every touch goes to the windows below, and each one's ACTION_DOWN
                // still comes here as an ACTION_OUTSIDE, which tells a touch on the PiP.
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                        | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                        | WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH
                        | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                        | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                PixelFormat.TRANSLUCENT);
        params.gravity = Gravity.TOP | Gravity.LEFT;
        params.windowAnimations = 0;
        params.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_STATE_UNSPECIFIED
                | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING;
        params.setTitle(TAG);
        WindowManager windowManager =
                (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        FocusView view = new FocusView(context, launcher);
        try {
            windowManager.addView(view, params);
        } catch (RuntimeException e) {
            Log.w(TAG, "Adding the focus window failed: " + e);
            return;
        }
        sWindowManager = windowManager;
        sView = view;
        Log.i(TAG, "launcher touched while the pinned PiP had the focus: taken");
    }

    /** Whether a pane is the pinned PiP. WindowUtil.checkIfPinned(), without its writes. */
    private static boolean pinnedPaneSet() {
        if (!LauncherApplication.supportsPinnedPip()) return false;
        SharedPreferences prefs =
                PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
        return LauncherApplication.isPinnedMode(prefs, Keys.PIP_FIRST_MODE)
                || LauncherApplication.isPinnedMode(prefs, Keys.PIP_SECOND_MODE)
                || LauncherApplication.isPinnedMode(prefs, Keys.PIP_THIRD_MODE)
                || LauncherApplication.isPinnedMode(prefs, Keys.PIP_FOURTH_MODE);
    }

    /**
     * Whether FYT's pinned stack is shown: IActivityManager.getPinnedStackVisible(), FYT's own
     * (ActivityTaskManagerService.getMpipVisible(): a top activity, not force-hidden). Where it
     * cannot be asked (a user app may be refused it) the answer is yes: the launcher's window has
     * no focus, and with a pane pinned the PiP is what has it.
     */
    private static boolean pinnedStackShown() {
        try {
            if (sGetPinnedStackVisible == null) {
                sGetService = ActivityManager.class.getMethod("getService");
                sGetPinnedStackVisible = Class.forName("android.app.IActivityManager")
                        .getMethod("getPinnedStackVisible");
            }
            Object service = sGetService.invoke(null);
            return Boolean.TRUE.equals(sGetPinnedStackVisible.invoke(service));
        } catch (Throwable t) {
            if (!sVisibilityFailureLogged) {
                sVisibilityFailureLogged = true;
                Log.w(TAG, "getPinnedStackVisible() failed, the pinned PiP is taken for shown: "
                        + t);
            }
            return true;
        }
    }

    /**
     * The overlay's only view. It holds the focus, stands in for the launcher's focused text field
     * towards the input method, and hands the keys it gets to the launcher.
     */
    private static final class FocusView extends View {

        private final Launcher mLauncher;
        private final InputMethodManager mImm;
        /** The field whose connection the input method was given last, null for none. */
        private View mServedField;
        private ViewTreeObserver mObserved;
        private final ViewTreeObserver.OnGlobalFocusChangeListener mFocusListener =
                (oldFocus, newFocus) -> syncInput();

        FocusView(Context context, Launcher launcher) {
            super(context);
            mLauncher = launcher;
            mImm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            setFocusable(true);
            setFocusableInTouchMode(true);
        }

        @Override
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            requestFocus();
            View decor = launcherDecor();
            if (decor != null) {
                mObserved = decor.getViewTreeObserver();
                mObserved.addOnGlobalFocusChangeListener(mFocusListener);
            }
        }

        @Override
        protected void onDetachedFromWindow() {
            if (mObserved != null && mObserved.isAlive()) {
                mObserved.removeOnGlobalFocusChangeListener(mFocusListener);
            }
            mObserved = null;
            super.onDetachedFromWindow();
        }

        @Override
        public void onWindowFocusChanged(boolean hasWindowFocus) {
            super.onWindowFocusChanged(hasWindowFocus);
            if (!hasWindowFocus) return;
            if (!isFocused()) requestFocus();
            // After InputMethodManager.onPostWindowFocus(), which ViewRootImpl calls after this and
            // which starts the input for this view.
            post(this::onFocusTaken);
        }

        private void onFocusTaken() {
            if (!hasWindowFocus()) return;
            if (textField() == null) {
                // What was up was the pinned PiP app's keyboard: a touch on the launcher closes it.
                mImm.hideSoftInputFromWindow(getWindowToken(), 0);
            }
            // A focus got back may not have started the input again (the same view was served).
            syncInput();
        }

        /**
         * Gives the input method the launcher's focused text field, or none. Right away, not
         * posted: TextView.onTouchEvent() asks for the keyboard just after it took the focus.
         */
        private void syncInput() {
            if (!hasWindowFocus()) return;
            View field = textField();
            if (field == mServedField) return;
            if (field != null) {
                mImm.restartInput(this);
                return;
            }
            // The field gave its focus up (Folder.doneEditingFolderName()): its window's own
            // hideSoftInputFromWindow() does nothing while this window has the input method.
            mImm.hideSoftInputFromWindow(getWindowToken(), 0);
            // Posted: this can run inside a call of the field's own connection (the editor action
            // that ends the editing), which the restart would close under it.
            post(() -> {
                if (hasWindowFocus() && textField() != mServedField) mImm.restartInput(this);
            });
        }

        void closeKeyboard() {
            if (hasWindowFocus()) {
                mImm.hideSoftInputFromWindow(getWindowToken(), 0);
            }
        }

        private View launcherDecor() {
            Window window = mLauncher.getWindow();
            return window != null ? window.peekDecorView() : null;
        }

        /** The launcher's focused view when it takes text, null otherwise. */
        private View textField() {
            View decor = launcherDecor();
            View focus = decor != null ? decor.findFocus() : null;
            return focus != null && focus.onCheckIsTextEditor() ? focus : null;
        }

        @Override
        public boolean onCheckIsTextEditor() {
            return textField() != null;
        }

        @Override
        public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
            View field = textField();
            mServedField = field;
            if (field == null) return null;
            InputConnection connection = field.onCreateInputConnection(outAttrs);
            return connection != null ? new FieldConnection(connection, field) : null;
        }

        /** The field's own InputMethodManager calls (showSoftInput(), updateSelection(), ...). */
        @Override
        public boolean checkInputConnectionProxy(View view) {
            return view != null && view == mServedField;
        }

        @Override
        public boolean dispatchTouchEvent(MotionEvent event) {
            if (event.getActionMasked() == MotionEvent.ACTION_OUTSIDE
                    && PinnedPip.outsideTouchOnOtherApp(event.getRawX(), event.getRawY())) {
                // Posted: the window is not removed while its own input event is being handled.
                MAIN.post(() -> {
                    if (sView == this) release("another app's window touched");
                });
            }
            return false;
        }

        /** Before the input method: FolderEditText.onKeyPreIme() ends the editing on Back. */
        @Override
        public boolean dispatchKeyEventPreIme(KeyEvent event) {
            View decor = launcherDecor();
            return decor != null && decor.dispatchKeyEventPreIme(event);
        }

        /** What the input method left: Back closes a folder, the app drawer and so on. */
        @Override
        public boolean dispatchKeyEvent(KeyEvent event) {
            return mLauncher.dispatchKeyEvent(event);
        }
    }

    /**
     * The field's connection. The keys the input method sends through it (KEYCODE_DEL, ENTER) go
     * to the field's window directly: BaseInputConnection.sendKeyEvent() queues them on that
     * window's ViewRootImpl, which drops them while the window has no focus, as here.
     */
    private static final class FieldConnection extends InputConnectionWrapper {

        private final View mField;

        FieldConnection(InputConnection target, View field) {
            super(target, false);
            mField = field;
        }

        @Override
        public boolean sendKeyEvent(KeyEvent event) {
            mField.getRootView().dispatchKeyEvent(event);
            // What BaseInputConnection.sendKeyEvent() returns.
            return false;
        }
    }
}
