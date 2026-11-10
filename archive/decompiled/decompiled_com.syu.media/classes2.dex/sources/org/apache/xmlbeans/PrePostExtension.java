package org.apache.xmlbeans;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface PrePostExtension {
    public static final int OPERATION_INSERT = 2;
    public static final int OPERATION_REMOVE = 3;
    public static final int OPERATION_SET = 1;

    String getStaticHandler();

    boolean hasPostCall();

    boolean hasPreCall();
}
