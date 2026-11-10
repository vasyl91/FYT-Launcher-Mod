package okhttp3.internal.http;

import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.connection.RealConnection;
import okio.Sink;
import okio.Source;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface ExchangeCodec {
    public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

    void cancel();

    RealConnection connection();

    Sink createRequestBody(Request request, long j) throws IOException;

    void finishRequest() throws IOException;

    void flushRequest() throws IOException;

    Source openResponseBodySource(Response response) throws IOException;

    @Nullable
    Response.Builder readResponseHeaders(boolean z) throws IOException;

    long reportedContentLength(Response response) throws IOException;

    Headers trailers() throws IOException;

    void writeRequestHeaders(Request request) throws IOException;
}
