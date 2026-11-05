package okhttp3.internal.platform;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;
import okio.Buffer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Platform {
    public static final int INFO = 4;
    public static final int WARN = 5;
    private static final Platform PLATFORM = findPlatform();
    private static final Logger logger = Logger.getLogger(OkHttpClient.class.getName());

    public void afterHandshake(SSLSocket sSLSocket) {
    }

    public void configureSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, @Nullable String str, List<Protocol> list) throws IOException {
    }

    public String getPrefix() {
        return "OkHttp";
    }

    @Nullable
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        return null;
    }

    public boolean isCleartextTrafficPermitted(String str) {
        return true;
    }

    public static Platform get() {
        return PLATFORM;
    }

    @Nullable
    protected X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        try {
            Object fieldOrNull = readFieldOrNull(sSLSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
            if (fieldOrNull == null) {
                return null;
            }
            return (X509TrustManager) readFieldOrNull(fieldOrNull, X509TrustManager.class, "trustManager");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public void log(int i, String str, @Nullable Throwable th) {
        logger.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    @Nullable
    public Object getStackTraceForCloseable(String str) {
        if (logger.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public void logCloseableLeak(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        log(5, str, (Throwable) obj);
    }

    public static List<String> alpnProtocolNames(List<Protocol> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                arrayList.add(protocol.toString());
            }
        }
        return arrayList;
    }

    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        return new BasicCertificateChainCleaner(buildTrustRootIndex(x509TrustManager));
    }

    public CertificateChainCleaner buildCertificateChainCleaner(SSLSocketFactory sSLSocketFactory) {
        X509TrustManager x509TrustManagerTrustManager = trustManager(sSLSocketFactory);
        if (x509TrustManagerTrustManager == null) {
            throw new IllegalStateException("Unable to extract the trust manager on " + get() + ", sslSocketFactory is " + sSLSocketFactory.getClass());
        }
        return buildCertificateChainCleaner(x509TrustManagerTrustManager);
    }

    public static boolean isConscryptPreferred() {
        if ("conscrypt".equals(Util.getSystemProperty("okhttp.platform", null))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    private static Platform findPlatform() {
        if (isAndroid()) {
            return findAndroidPlatform();
        }
        return findJvmPlatform();
    }

    public static boolean isAndroid() {
        return "Dalvik".equals(System.getProperty("java.vm.name"));
    }

    private static Platform findJvmPlatform() {
        ConscryptPlatform conscryptPlatformBuildIfSupported;
        if (isConscryptPreferred() && (conscryptPlatformBuildIfSupported = ConscryptPlatform.buildIfSupported()) != null) {
            return conscryptPlatformBuildIfSupported;
        }
        Jdk9Platform jdk9PlatformBuildIfSupported = Jdk9Platform.buildIfSupported();
        if (jdk9PlatformBuildIfSupported != null) {
            return jdk9PlatformBuildIfSupported;
        }
        Platform platformBuildIfSupported = Jdk8WithJettyBootPlatform.buildIfSupported();
        return platformBuildIfSupported != null ? platformBuildIfSupported : new Platform();
    }

    private static Platform findAndroidPlatform() {
        Platform platformBuildIfSupported = Android10Platform.buildIfSupported();
        if (platformBuildIfSupported != null) {
            return platformBuildIfSupported;
        }
        Platform platformBuildIfSupported2 = AndroidPlatform.buildIfSupported();
        if (platformBuildIfSupported2 != null) {
            return platformBuildIfSupported2;
        }
        throw new NullPointerException("No platform found on Android");
    }

    static byte[] concatLengthPrefixed(List<Protocol> list) {
        Buffer buffer = new Buffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                buffer.writeByte(protocol.toString().length());
                buffer.writeUtf8(protocol.toString());
            }
        }
        return buffer.readByteArray();
    }

    @Nullable
    static <T> T readFieldOrNull(Object obj, Class<T> cls, String str) {
        Object fieldOrNull;
        for (Class<?> superclass = obj.getClass(); superclass != Object.class; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (cls.isInstance(obj2)) {
                    return cls.cast(obj2);
                }
                return null;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (NoSuchFieldException unused2) {
            }
        }
        if (str.equals("delegate") || (fieldOrNull = readFieldOrNull(obj, Object.class, "delegate")) == null) {
            return null;
        }
        return (T) readFieldOrNull(fieldOrNull, cls, str);
    }

    public SSLContext getSSLContext() {
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    public TrustRootIndex buildTrustRootIndex(X509TrustManager x509TrustManager) {
        return new BasicTrustRootIndex(x509TrustManager.getAcceptedIssuers());
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
