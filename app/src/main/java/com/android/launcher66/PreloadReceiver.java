package com.android.launcher66;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import java.lang.reflect.Field;

public class PreloadReceiver extends BroadcastReceiver {
    public static final String EXTRA_WORKSPACE_NAME = "com.android.launcher66.action.EXTRA_WORKSPACE_NAME";

    @Override
    public void onReceive(Context context, Intent intent) {
        final LauncherProvider provider = LauncherAppState.getLauncherProvider();
        if (provider != null) {
            String name = intent.getStringExtra(EXTRA_WORKSPACE_NAME);
            final int workspaceResId = !TextUtils.isEmpty(name) ? getResId(name) : 0;
            new Thread(() -> provider.loadDefaultFavoritesIfNecessary(workspaceResId)).start();
        }
    }

    public int getResId(String resName) {
        try {
            Field idField = R.xml.class.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            return -1;
        }
    }
}
