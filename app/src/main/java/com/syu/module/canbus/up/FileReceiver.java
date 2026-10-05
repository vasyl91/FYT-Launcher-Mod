package com.syu.module.canbus.up;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.IOException;

public class FileReceiver extends BroadcastReceiver {
    private static final String TAG = "FileReceiver";
    // The file manager only hands out files from shared storage or USB/SD media.
    private static final String[] ALLOWED_ROOTS = {"/storage/", "/mnt/", "/sdcard/"};

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle;
        String action = intent.getAction();
        if ("com.syu.filemanager".equals(action) && (bundle = intent.getExtras()) != null) {
            // The receiver is exported, so the path is not trusted blindly: it ends up as an
            // argument of the CAN upgrade command.
            String path = bundle.getString("update_file");
            if (!isAllowedPath(path)) {
                Log.w(TAG, "Ignoring update file outside of the storage roots: " + path);
                return;
            }
            DataCanUp.mFileUpdatePath = path;
            DataCanUp.NOTIFY_EVENTS_FILEPATH.onNotify();
        }
    }

    private static boolean isAllowedPath(String path) {
        if (path == null || path.isEmpty()) {
            return false;
        }
        String canonical;
        try {
            canonical = new File(path).getCanonicalPath();
        } catch (IOException e) {
            return false;
        }
        for (String root : ALLOWED_ROOTS) {
            if (canonical.startsWith(root)) {
                return true;
            }
        }
        return false;
    }
}
