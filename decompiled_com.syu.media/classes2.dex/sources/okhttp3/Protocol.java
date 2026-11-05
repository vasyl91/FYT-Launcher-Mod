package okhttp3;

import java.io.IOException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");

    private final String protocol;

    Protocol(String str) {
        this.protocol = str;
    }

    public static Protocol get(String str) throws IOException {
        Protocol protocol = HTTP_1_0;
        if (str.equals(protocol.protocol)) {
            return protocol;
        }
        Protocol protocol2 = HTTP_1_1;
        if (str.equals(protocol2.protocol)) {
            return protocol2;
        }
        Protocol protocol3 = H2_PRIOR_KNOWLEDGE;
        if (str.equals(protocol3.protocol)) {
            return protocol3;
        }
        Protocol protocol4 = HTTP_2;
        if (str.equals(protocol4.protocol)) {
            return protocol4;
        }
        Protocol protocol5 = SPDY_3;
        if (str.equals(protocol5.protocol)) {
            return protocol5;
        }
        Protocol protocol6 = QUIC;
        if (str.equals(protocol6.protocol)) {
            return protocol6;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}
