package org.apache.xmlbeans;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class XmlDocumentProperties {
    public static final Object SOURCE_NAME = new Object();
    public static final Object ENCODING = new Object();
    public static final Object VERSION = new Object();
    public static final Object STANDALONE = new Object();
    public static final Object DOCTYPE_NAME = new Object();
    public static final Object DOCTYPE_PUBLIC_ID = new Object();
    public static final Object DOCTYPE_SYSTEM_ID = new Object();
    public static final Object MESSAGE_DIGEST = new Object();

    public abstract Object get(Object obj);

    public abstract Object put(Object obj, Object obj2);

    public abstract Object remove(Object obj);

    public void setSourceName(String str) {
        put(SOURCE_NAME, str);
    }

    public String getSourceName() {
        return (String) get(SOURCE_NAME);
    }

    public void setEncoding(String str) {
        put(ENCODING, str);
    }

    public String getEncoding() {
        return (String) get(ENCODING);
    }

    public void setVersion(String str) {
        put(VERSION, str);
    }

    public String getVersion() {
        return (String) get(VERSION);
    }

    public void setStandalone(boolean z) {
        put(STANDALONE, z ? "true" : null);
    }

    public boolean getStandalone() {
        return get(STANDALONE) != null;
    }

    public void setDoctypeName(String str) {
        put(DOCTYPE_NAME, str);
    }

    public String getDoctypeName() {
        return (String) get(DOCTYPE_NAME);
    }

    public void setDoctypePublicId(String str) {
        put(DOCTYPE_PUBLIC_ID, str);
    }

    public String getDoctypePublicId() {
        return (String) get(DOCTYPE_PUBLIC_ID);
    }

    public void setDoctypeSystemId(String str) {
        put(DOCTYPE_SYSTEM_ID, str);
    }

    public String getDoctypeSystemId() {
        return (String) get(DOCTYPE_SYSTEM_ID);
    }

    public void setMessageDigest(byte[] bArr) {
        put(MESSAGE_DIGEST, bArr);
    }

    public byte[] getMessageDigest() {
        return (byte[]) get(MESSAGE_DIGEST);
    }
}
