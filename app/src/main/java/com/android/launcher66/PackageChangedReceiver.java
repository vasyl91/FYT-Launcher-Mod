package com.android.launcher66;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

/**
 * Drops the cached widget previews of a package that was added, changed or removed.
 *
 * <p>The rule: this receiver never builds the launcher's state. The system starts the process for a
 * package broadcast even when no launcher is running in it, and {@code LauncherAppState.getInstance()}
 * would then build the whole model (icon cache, icon bitmaps from statics that only the launcher
 * activity sets) from a receiver, which crashed the A55 twelve times (width and height must be &gt; 0).
 * When the state already exists its database is used as before; otherwise the preview database is
 * opened on a worker thread under the same file name and the rows are deleted there, with
 * {@link #goAsync()} keeping the process alive until the delete is done. Nothing touches the database
 * on the main thread.
 */
public class PackageChangedReceiver extends BroadcastReceiver {
    private static final String TAG = "PackageChangedReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Uri data = intent == null ? null : intent.getData();
        String packageName = data == null ? null : data.getSchemeSpecificPart();
        if (packageName == null || packageName.length() == 0) {
            return;
        }
        LauncherAppState state = LauncherAppState.getInstanceNoCreate();
        if (state != null && state.getWidgetPreviewCacheDb() != null) {
            // The launcher is alive in this process: its database, its own background task.
            WidgetPreviewLoader.removePackageFromDb(state.getWidgetPreviewCacheDb(), packageName);
            return;
        }
        final Context appContext = context.getApplicationContext() != null
                ? context.getApplicationContext() : context;
        final String pkg = packageName;
        // Null when onReceive is called outside a real broadcast (tests): then there is nothing to finish.
        final PendingResult pending = goAsync();
        Thread worker = new Thread(() -> {
            try {
                removeFromPreviewDb(appContext, pkg);
            } finally {
                if (pending != null) {
                    pending.finish();
                }
            }
        }, "PreviewDbCleanup");
        worker.start();
    }

    /**
     * Opens the preview database by its file name, deletes the rows of the package and closes it
     * again. Blocking: call it from a worker thread only.
     */
    static void removeFromPreviewDb(Context context, String packageName) {
        WidgetPreviewLoader.CacheDb db = new WidgetPreviewLoader.CacheDb(context);
        try {
            WidgetPreviewLoader.deletePackageRows(db, packageName);
        } catch (RuntimeException e) {
            // A cache: the rows are made again when the previews are drawn.
            Log.w(TAG, "Could not drop the widget previews of " + packageName, e);
        } finally {
            db.close();
        }
    }
}
