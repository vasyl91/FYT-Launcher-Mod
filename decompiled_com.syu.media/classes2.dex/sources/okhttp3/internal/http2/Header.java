package okhttp3.internal.http2;

import module.canbus.FinalCanbus;
import okhttp3.internal.Util;
import okio.ByteString;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Header {
    final int hpackSize;
    public final ByteString name;
    public final ByteString value;
    public static final ByteString PSEUDO_PREFIX = ByteString.encodeUtf8(":");
    public static final String RESPONSE_STATUS_UTF8 = ":status";
    public static final ByteString RESPONSE_STATUS = ByteString.encodeUtf8(RESPONSE_STATUS_UTF8);
    public static final String TARGET_METHOD_UTF8 = ":method";
    public static final ByteString TARGET_METHOD = ByteString.encodeUtf8(TARGET_METHOD_UTF8);
    public static final String TARGET_PATH_UTF8 = ":path";
    public static final ByteString TARGET_PATH = ByteString.encodeUtf8(TARGET_PATH_UTF8);
    public static final String TARGET_SCHEME_UTF8 = ":scheme";
    public static final ByteString TARGET_SCHEME = ByteString.encodeUtf8(TARGET_SCHEME_UTF8);
    public static final String TARGET_AUTHORITY_UTF8 = ":authority";
    public static final ByteString TARGET_AUTHORITY = ByteString.encodeUtf8(TARGET_AUTHORITY_UTF8);

    public Header(String str, String str2) {
        this(ByteString.encodeUtf8(str), ByteString.encodeUtf8(str2));
    }

    public Header(ByteString byteString, String str) {
        this(byteString, ByteString.encodeUtf8(str));
    }

    public Header(ByteString byteString, ByteString byteString2) {
        this.name = byteString;
        this.value = byteString2;
        this.hpackSize = byteString.size() + 32 + byteString2.size();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        return this.name.equals(header.name) && this.value.equals(header.value);
    }

    public int hashCode() {
        return ((FinalCanbus.U_CAR_LIGHT_NEAR_ENABLE + this.name.hashCode()) * 31) + this.value.hashCode();
    }

    public String toString() {
        return Util.format("%s: %s", this.name.utf8(), this.value.utf8());
    }
}
