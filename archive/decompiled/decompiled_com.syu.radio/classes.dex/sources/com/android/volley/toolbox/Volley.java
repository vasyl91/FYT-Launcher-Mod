package com.android.volley.toolbox;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.http.AndroidHttpClient;
import android.os.Build;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import java.io.File;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Volley {
    private static final String DEFAULT_CACHE_DIR = "volley";

    public static RequestQueue newRequestQueue(Context context, HttpStack stack, int maxDiskCacheBytes) {
        RequestQueue queue;
        File cacheDir = new File(context.getCacheDir(), DEFAULT_CACHE_DIR);
        String userAgent = "volley/0";
        try {
            String packageName = context.getPackageName();
            PackageInfo info = context.getPackageManager().getPackageInfo(packageName, 0);
            userAgent = String.valueOf(packageName) + "/" + info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
        }
        if (stack == null) {
            if (Build.VERSION.SDK_INT >= 9) {
                stack = new HurlStack();
            } else {
                stack = new HttpClientStack(AndroidHttpClient.newInstance(userAgent));
            }
        }
        Network network = new BasicNetwork(stack);
        if (maxDiskCacheBytes <= -1) {
            queue = new RequestQueue(new DiskBasedCache(cacheDir), network);
        } else {
            queue = new RequestQueue(new DiskBasedCache(cacheDir, maxDiskCacheBytes), network);
        }
        queue.start();
        return queue;
    }

    public static RequestQueue newRequestQueue(Context context, int maxDiskCacheBytes) {
        return newRequestQueue(context, null, maxDiskCacheBytes);
    }

    public static RequestQueue newRequestQueue(Context context, HttpStack stack) {
        return newRequestQueue(context, stack, -1);
    }

    public static RequestQueue newRequestQueue(Context context) {
        return newRequestQueue(context, (HttpStack) null);
    }
}
