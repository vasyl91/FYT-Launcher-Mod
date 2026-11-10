package okhttp3.internal;

import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealConnectionPool;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class Internal {
    public static Internal instance;

    public abstract void addLenient(Headers.Builder builder, String str);

    public abstract void addLenient(Headers.Builder builder, String str, String str2);

    public abstract void apply(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z);

    public abstract int code(Response.Builder builder);

    public abstract boolean equalsNonHost(Address address, Address address2);

    @Nullable
    public abstract Exchange exchange(Response response);

    public abstract void initExchange(Response.Builder builder, Exchange exchange);

    public abstract Call newWebSocketCall(OkHttpClient okHttpClient, Request request);

    public abstract RealConnectionPool realConnectionPool(ConnectionPool connectionPool);

    public static void initializeInstanceForTests() {
        new OkHttpClient();
    }
}
