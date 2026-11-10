package com.android.volley.toolbox;

import android.os.Handler;
import android.os.Looper;
import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ClearCacheRequest extends Request<Object> {
    private final Cache mCache;
    private final Runnable mCallback;

    public ClearCacheRequest(Cache cache, Runnable callback) {
        super(0, null, null);
        this.mCache = cache;
        this.mCallback = callback;
    }

    @Override // com.android.volley.Request
    public boolean isCanceled() {
        this.mCache.clear();
        if (this.mCallback != null) {
            Handler handler = new Handler(Looper.getMainLooper());
            handler.postAtFrontOfQueue(this.mCallback);
            return true;
        }
        return true;
    }

    @Override // com.android.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.IMMEDIATE;
    }

    @Override // com.android.volley.Request
    protected Response<Object> parseNetworkResponse(NetworkResponse response) {
        return null;
    }

    @Override // com.android.volley.Request
    protected void deliverResponse(Object response) {
    }
}
