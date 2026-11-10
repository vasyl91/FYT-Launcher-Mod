package android.net.http;

import android.content.Context;
import java.io.File;
import org.apache.http.HttpHost;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class HttpsConnection extends Connection {
    protected SslCertificate mCertificate;
    protected AndroidHttpClientConnection mHttpClientConnection;

    @Override // android.net.http.Connection
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    HttpsConnection() {
        super((Context) null, (HttpHost) null, (RequestFeeder) null);
        throw new RuntimeException("Stub!");
    }

    public static void initializeEngine(File sessionDir) {
        throw new RuntimeException("Stub!");
    }
}
