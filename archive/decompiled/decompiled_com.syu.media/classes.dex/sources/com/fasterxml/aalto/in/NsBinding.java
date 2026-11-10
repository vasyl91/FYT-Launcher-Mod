package com.fasterxml.aalto.in;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
final class NsBinding {
    public final String mPrefix;
    public String mURI;
    public static final NsBinding XML_BINDING = new NsBinding("xml", "http://www.w3.org/XML/1998/namespace", null);
    public static final NsBinding XMLNS_BINDING = new NsBinding("xmlns", "http://www.w3.org/2000/xmlns/", null);

    public NsBinding(String str) {
        if (str == "xml" || str == "xmlns") {
            throw new RuntimeException("Trying to create non-singleton binding for ns prefix '" + str + "'");
        }
        this.mPrefix = str;
        this.mURI = null;
    }

    public static final NsBinding createDefaultNs() {
        return new NsBinding(null);
    }

    private NsBinding(String str, String str2, Object obj) {
        this.mPrefix = str;
        this.mURI = str2;
    }

    public boolean isImmutable() {
        return this == XML_BINDING || this == XMLNS_BINDING;
    }
}
