package com.android.volley;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class VolleyError extends Exception {
    public final NetworkResponse networkResponse;
    private long networkTimeMs;

    public VolleyError() {
        this.networkResponse = null;
    }

    public VolleyError(NetworkResponse response) {
        this.networkResponse = response;
    }

    public VolleyError(String exceptionMessage) {
        super(exceptionMessage);
        this.networkResponse = null;
    }

    public VolleyError(String exceptionMessage, Throwable reason) {
        super(exceptionMessage, reason);
        this.networkResponse = null;
    }

    public VolleyError(Throwable cause) {
        super(cause);
        this.networkResponse = null;
    }

    void setNetworkTimeMs(long networkTimeMs) {
        this.networkTimeMs = networkTimeMs;
    }

    public long getNetworkTimeMs() {
        return this.networkTimeMs;
    }
}
