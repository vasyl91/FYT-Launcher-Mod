package org.apache.poi.ddf;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface EscherSerializationListener {
    void afterRecordSerialize(int i, short s, int i2, EscherRecord escherRecord);

    void beforeRecordSerialize(int i, short s, EscherRecord escherRecord);
}
