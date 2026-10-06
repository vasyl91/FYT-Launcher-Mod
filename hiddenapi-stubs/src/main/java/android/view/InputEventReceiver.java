package android.view;

import android.os.Looper;

/**
 * Stub of the hidden android.view.InputEventReceiver, for compiling only.
 * Only what the app uses is declared; the signatures match the framework class.
 */
public abstract class InputEventReceiver {
    public InputEventReceiver(InputChannel inputChannel, Looper looper) {
        throw new RuntimeException("Stub!");
    }

    public void onInputEvent(InputEvent event) {
        throw new RuntimeException("Stub!");
    }

    public final void finishInputEvent(InputEvent event, boolean handled) {
        throw new RuntimeException("Stub!");
    }

    public void dispose() {
        throw new RuntimeException("Stub!");
    }
}
