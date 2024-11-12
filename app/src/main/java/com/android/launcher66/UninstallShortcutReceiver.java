package com.android.launcher66;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.widget.Toast;
import com.android.launcher66.LauncherSettings;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class UninstallShortcutReceiver extends BroadcastReceiver {
    private static final String ACTION_UNINSTALL_SHORTCUT = "com.android.launcher.action.UNINSTALL_SHORTCUT";
    private static ArrayList<PendingUninstallShortcutInfo> mUninstallQueue = new ArrayList<>();
    private static boolean mUseUninstallQueue = false;

    private static class PendingUninstallShortcutInfo {
        Intent data;

        public PendingUninstallShortcutInfo(Intent rawData) {
            this.data = rawData;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent data) {
        if (ACTION_UNINSTALL_SHORTCUT.equals(data.getAction())) {
            PendingUninstallShortcutInfo info = new PendingUninstallShortcutInfo(data);
            if (mUseUninstallQueue) {
                mUninstallQueue.add(info);
            } else {
                processUninstallShortcut(context, info);
            }
        }
    }

    static void enableUninstallQueue() {
        mUseUninstallQueue = true;
    }

    static void disableAndFlushUninstallQueue(Context context) {
        mUseUninstallQueue = false;
        Iterator<PendingUninstallShortcutInfo> iter = mUninstallQueue.iterator();
        while (iter.hasNext()) {
            processUninstallShortcut(context, iter.next());
            iter.remove();
        }
    }

    private static void processUninstallShortcut(Context context, PendingUninstallShortcutInfo pendingInfo) {
        Intent data = pendingInfo.data;
        LauncherAppState.setApplicationContext(context.getApplicationContext());
        LauncherAppState app = LauncherAppState.getInstance();
        synchronized (app) {
            removeShortcut(context, data);
        }
    }

    private static void removeShortcut(Context context, Intent data) {
        Intent intent = (Intent) data.getParcelableExtra("android.intent.extra.shortcut.INTENT");
        String name = data.getStringExtra("android.intent.extra.shortcut.NAME");
        boolean duplicate = data.getBooleanExtra("duplicate", true);
        if (intent != null && name != null) {
            ContentResolver cr = context.getContentResolver();
            Cursor c = cr.query(LauncherSettings.Favorites.CONTENT_URI, new String[]{"_id", "intent"}, "title=?", new String[]{name}, null);
            int intentIndex = c.getColumnIndexOrThrow("intent");
            int idIndex = c.getColumnIndexOrThrow("_id");
            boolean changed = false;
            while (c.moveToNext()) {
                try {
                    try {
                        if (intent.filterEquals(Intent.parseUri(c.getString(intentIndex), 0))) {
                            long id = c.getLong(idIndex);
                            Uri uri = LauncherSettings.Favorites.getContentUri(id, false);
                            cr.delete(uri, null, null);
                            changed = true;
                            if (!duplicate) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } catch (URISyntaxException e) {
                    }
                } finally {
                    c.close();
                }
            }
            if (changed) {
                cr.notifyChange(LauncherSettings.Favorites.CONTENT_URI, null);
                Toast.makeText(context, context.getString(R.string.shortcut_uninstalled, name), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
