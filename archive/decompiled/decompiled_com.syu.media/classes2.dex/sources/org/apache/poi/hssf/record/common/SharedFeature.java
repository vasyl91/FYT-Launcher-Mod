package org.apache.poi.hssf.record.common;

import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface SharedFeature {
    int getDataSize();

    void serialize(LittleEndianOutput littleEndianOutput);

    String toString();
}
