package com.syu.util;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import com.syu.vdhost.VdHostProtocol;

/**
 * Mailbox for the FYT VDHost daemon: it calls "attach" here with its binder in the extras (see
 * BinderDelivery in vdhost/server). Only root, system and shell may deliver -- anything else
 * could hand the launcher a fake host.
 */
public class WindowHostVdProvider extends ContentProvider {
    private static final String TAG = "WindowHostVdProvider";
    private static final int SHELL_UID = 2000;

    @Override
    public boolean onCreate() {
        return true;
    }

    @Override
    public Bundle call(String method, String arg, Bundle extras) {
        if (!VdHostProtocol.METHOD_ATTACH.equals(method)) return null;

        int uid = Binder.getCallingUid();
        if (uid != 0 && uid != android.os.Process.SYSTEM_UID && uid != SHELL_UID) {
            Log.w(TAG, "attach refused from uid " + uid);
            return null;
        }

        IBinder binder = extras != null ? extras.getBinder(VdHostProtocol.KEY_BINDER) : null;
        Bundle out = new Bundle();
        out.putBoolean(VdHostProtocol.KEY_ACCEPTED, WindowHostVdClient.onDaemonAttached(binder));
        return out;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
