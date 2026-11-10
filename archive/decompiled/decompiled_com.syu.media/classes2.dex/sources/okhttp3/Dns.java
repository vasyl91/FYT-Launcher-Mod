package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface Dns {
    public static final Dns SYSTEM = new Dns() { // from class: okhttp3.Dns$$ExternalSyntheticLambda0
        @Override // okhttp3.Dns
        public final List lookup(String str) {
            return Dns.lambda$static$0(str);
        }
    };

    List<InetAddress> lookup(String str) throws UnknownHostException;

    static /* synthetic */ List lambda$static$0(String str) throws UnknownHostException {
        if (str == null) {
            throw new UnknownHostException("hostname == null");
        }
        try {
            return Arrays.asList(InetAddress.getAllByName(str));
        } catch (NullPointerException e) {
            UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
            unknownHostException.initCause(e);
            throw unknownHostException;
        }
    }
}
