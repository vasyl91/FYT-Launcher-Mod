package com.android.launcher66;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutManagerCompat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UninstallShortcutReceiver extends BroadcastReceiver {
    private static final String ACTION_UNINSTALL_SHORTCUT = "com.android.launcher.action.UNINSTALL_SHORTCUT";
    private static final ArrayList<PendingUninstallShortcutInfo> mUninstallQueue = new ArrayList<>();
    private static boolean mUseUninstallQueue = false;

    private static class PendingUninstallShortcutInfo {
        Intent data;

        public PendingUninstallShortcutInfo(Intent rawData) {
            this.data = rawData;
        }
    }

    @Override
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

    private static void removeShortcut(Context context, Intent targetIntent) {
        List<ShortcutInfoCompat> dynamicShortcuts = ShortcutManagerCompat.getDynamicShortcuts(context);
        String targetName = targetIntent.getStringExtra("android.intent.extra.shortcut.NAME");
        boolean duplicate = targetIntent.getBooleanExtra("duplicate", true);
        boolean removed = false;

        for (ShortcutInfoCompat shortcut : dynamicShortcuts) {
            // Compare the intent and short label (name) to identify the shortcut
            if (targetName.contentEquals(shortcut.getShortLabel()) &&
                    targetIntent.filterEquals(shortcut.getIntent())) {
                // Remove the shortcut by its ID
                ShortcutManagerCompat.removeDynamicShortcuts(context, List.of(shortcut.getId()));
                removed = true;
                if (!duplicate) {
                    break;
                }
            }
        }

        if (removed) {
            Toast.makeText(
                    context,
                    context.getString(R.string.shortcut_uninstalled, targetName),
                    Toast.LENGTH_SHORT
            ).show();
        }
    }
}
