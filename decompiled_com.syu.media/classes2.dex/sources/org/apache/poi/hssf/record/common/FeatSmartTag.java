package org.apache.poi.hssf.record.common;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class FeatSmartTag implements SharedFeature {
    private byte[] data;

    @Override // org.apache.poi.hssf.record.common.SharedFeature
    public String toString() {
        return " [FEATURE SMART TAGS]\n [/FEATURE SMART TAGS]\n";
    }

    public FeatSmartTag() {
        this.data = new byte[0];
    }

    public FeatSmartTag(RecordInputStream recordInputStream) {
        this.data = recordInputStream.readRemainder();
    }

    @Override // org.apache.poi.hssf.record.common.SharedFeature
    public int getDataSize() {
        return this.data.length;
    }

    @Override // org.apache.poi.hssf.record.common.SharedFeature
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.write(this.data);
    }
}
