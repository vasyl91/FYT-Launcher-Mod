package okhttp3;

import java.net.Socket;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface Connection {
    @Nullable
    Handshake handshake();

    Protocol protocol();

    Route route();

    Socket socket();
}
