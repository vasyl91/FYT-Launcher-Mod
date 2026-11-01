package com.syu.module.main;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import com.android.launcher66.LauncherApplication;

public class ShareHandler {
    public static final Uri URI = Uri.parse("content://com.syu.ms.provider");

    public static int getInt(ContentResolver resolver, int key, int valueIfNotFound) {
        // The FYT unit's own provider: anywhere else the lookup only logs "Failed to find
        // provider info for com.syu.ms.provider".
        if (!LauncherApplication.isFytDevice()) {
            return valueIfNotFound;
        }
        Cursor cursor;
        int result = valueIfNotFound;
        try {
            cursor = resolver != null ? resolver.query(URI, null, Integer.toString(key), null, null) : null;
        } catch (RuntimeException e) {
            // Not exported to a launcher that is not the system one, on some firmware
            Log.w("ShareHandler", "com.syu.ms.provider not readable: " + e);
            return valueIfNotFound;
        }
        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    result = cursor.getInt(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            cursor.close();
            return result;
        }
        return result;
    }
}
