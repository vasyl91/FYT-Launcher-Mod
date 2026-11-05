package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class HCenterRecord extends StandardRecord implements Cloneable {
    public static final short sid = 131;
    private short field_1_hcenter;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 131;
    }

    public HCenterRecord() {
    }

    public HCenterRecord(RecordInputStream recordInputStream) {
        this.field_1_hcenter = recordInputStream.readShort();
    }

    public void setHCenter(boolean z) {
        if (z) {
            this.field_1_hcenter = (short) 1;
        } else {
            this.field_1_hcenter = (short) 0;
        }
    }

    public boolean getHCenter() {
        return this.field_1_hcenter == 1;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[HCENTER]\n    .hcenter        = ");
        stringBuffer.append(getHCenter()).append("\n[/HCENTER]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_hcenter);
    }

    @Override // org.apache.poi.hssf.record.Record
    public HCenterRecord clone() {
        HCenterRecord hCenterRecord = new HCenterRecord();
        hCenterRecord.field_1_hcenter = this.field_1_hcenter;
        return hCenterRecord;
    }
}
