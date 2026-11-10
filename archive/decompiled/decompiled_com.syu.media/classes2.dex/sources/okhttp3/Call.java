package okhttp3;

import java.io.IOException;
import okio.Timeout;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface Call extends Cloneable {

    public interface Factory {
        Call newCall(Request request);
    }

    void cancel();

    Call clone();

    void enqueue(Callback callback);

    Response execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    Request request();

    Timeout timeout();
}
