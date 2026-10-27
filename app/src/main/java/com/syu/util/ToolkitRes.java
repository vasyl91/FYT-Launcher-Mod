package com.syu.util;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.android.launcher66.LauncherApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ToolkitRes {
    private static final String TAG = "ToolkitRes";

    /**
     * The assets that are not in the APK, so each is reported and looked for once. The mod ships
     * none of the stock images of the canbus screens (assets/ has no parking/ folder), and at
     * every start the parking views asked for 13 of them: a stack trace each, ~270 of the 730
     * lines of a capture, and a leaked stream each (StrictMode).
     */
    private static final Set<String> sMissing = ConcurrentHashMap.newKeySet();

    /** The image, or a transparent drawable where the APK does not have it: the callers take no null. */
    public static Drawable loadDrawable(String fileName) {
        if (sMissing.contains(fileName)) {
            return new ColorDrawable(0);
        }
        try (InputStream in = LauncherApplication.getAssetManager().open(fileName)) {
            return new BitmapDrawable(LauncherApplication.sApp.getResources(), BitmapFactory.decodeStream(in));
        } catch (IOException e) {
            if (sMissing.add(fileName)) {
                Log.w(TAG, "asset missing: " + fileName);
            }
            return new ColorDrawable(0);
        }
    }
}
