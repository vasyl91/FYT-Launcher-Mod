package com.android.launcher66.settings;

import android.app.Dialog;
import android.content.Context;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Opens the keyboard with a dialog that has one field to fill in.
 *
 * <p>The rule: a dialog of the settings that asks for one value (the start page, a margin, a time, a text
 * size, a client id) comes up with its field focused and the keyboard open, so that the value can be typed
 * at once. A dialog with several fields is left alone: which of them the user wants is not known.
 *
 * <p>The dialogs asked for the keyboard in their "shown" callback, with {@code showSoftInput}. That call is
 * dropped by the system when it comes before the dialog's window has the input focus, which is the case
 * there, so the keyboard did not open on most devices. Here the window is told before it is shown that it
 * wants the keyboard visible, and the request is made again once the window has the focus.
 */
final class DialogKeyboard {

    private DialogKeyboard() {
    }

    /**
     * Call before {@code dialog.show()}.
     *
     * @param field the one field of the dialog
     */
    static void openFor(Dialog dialog, final EditText field) {
        if (dialog == null || field == null) {
            return;
        }
        Window window = dialog.getWindow();
        if (window != null) {
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE
                    | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        }
        field.requestFocus();
        field.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() {
            @Override
            public void onWindowFocusChanged(boolean hasFocus) {
                if (!hasFocus) {
                    return;
                }
                ViewTreeObserver observer = field.getViewTreeObserver();
                if (observer.isAlive()) {
                    observer.removeOnWindowFocusChangeListener(this);
                }
                field.post(() -> {
                    field.requestFocus();
                    InputMethodManager imm = (InputMethodManager) field.getContext()
                            .getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (imm != null) {
                        imm.showSoftInput(field, InputMethodManager.SHOW_IMPLICIT);
                    }
                    field.setSelection(field.getText().length());
                });
            }
        });
    }
}
