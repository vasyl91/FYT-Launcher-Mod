package android.net.http;

import android.content.Context;
import org.apache.http.HttpHost;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
abstract class Connection {
    protected SslCertificate mCertificate;
    protected AndroidHttpClientConnection mHttpClientConnection;

    protected Connection(Context context, HttpHost host, RequestFeeder requestFeeder) {
        throw new RuntimeException("Stub!");
    }

    public synchronized String toString() {
        throw new RuntimeException("Stub!");
    }
}
