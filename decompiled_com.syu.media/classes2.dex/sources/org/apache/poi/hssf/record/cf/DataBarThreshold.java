package org.apache.poi.hssf.record.cf;

import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class DataBarThreshold extends Threshold implements Cloneable {
    public DataBarThreshold() {
    }

    public DataBarThreshold(LittleEndianInput littleEndianInput) {
        super(littleEndianInput);
    }

    public DataBarThreshold clone() {
        DataBarThreshold dataBarThreshold = new DataBarThreshold();
        super.copyTo(dataBarThreshold);
        return dataBarThreshold;
    }
}
