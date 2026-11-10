package org.apache.xmlbeans;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface SchemaLocalAttribute extends SchemaField, SchemaAnnotated {
    public static final int OPTIONAL = 2;
    public static final int PROHIBITED = 1;
    public static final int REQUIRED = 3;

    int getUse();
}
