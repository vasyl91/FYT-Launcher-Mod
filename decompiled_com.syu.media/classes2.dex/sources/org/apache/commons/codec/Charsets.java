package org.apache.commons.codec;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Charsets {

    @Deprecated
    public static final Charset ISO_8859_1 = Charset.forName(CharEncoding.ISO_8859_1);

    @Deprecated
    public static final Charset US_ASCII = Charset.forName(CharEncoding.US_ASCII);

    @Deprecated
    public static final Charset UTF_16 = Charset.forName(CharEncoding.UTF_16);

    @Deprecated
    public static final Charset UTF_16BE = Charset.forName(CharEncoding.UTF_16BE);

    @Deprecated
    public static final Charset UTF_16LE = Charset.forName(CharEncoding.UTF_16LE);

    @Deprecated
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    public static Charset toCharset(Charset charset) {
        return charset == null ? Charset.defaultCharset() : charset;
    }

    public static Charset toCharset(String str) {
        return str == null ? Charset.defaultCharset() : Charset.forName(str);
    }
}
