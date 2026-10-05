package android.app;

import android.os.RemoteException;

/**
 * Stub of the hidden android.app.TaskStackListener (Android 10+), for compiling only.
 * Only what the app overrides is declared; the signatures match the framework class.
 */
public abstract class TaskStackListener {
    public TaskStackListener() {
        throw new RuntimeException("Stub!");
    }

    public void onTaskStackChanged() throws RemoteException {
    }

    public void onTaskMovedToFront(ActivityManager.RunningTaskInfo taskInfo) throws RemoteException {
    }
}
