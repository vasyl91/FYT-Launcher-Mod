package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class BottomMarginRecord extends StandardRecord implements Margin, Cloneable {
    public static final short sid = 41;
    private double field_1_margin;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 8;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 41;
    }

    public BottomMarginRecord() {
    }

    public BottomMarginRecord(RecordInputStream recordInputStream) {
        this.field_1_margin = recordInputStream.readDouble();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[BottomMargin]\n    .margin               =  (");
        stringBuffer.append(getMargin()).append(" )\n[/BottomMargin]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeDouble(this.field_1_margin);
    }

    @Override // org.apache.poi.hssf.record.Margin
    public double getMargin() {
        return this.field_1_margin;
    }

    @Override // org.apache.poi.hssf.record.Margin
    public void setMargin(double d) {
        this.field_1_margin = d;
    }

    @Override // org.apache.poi.hssf.record.Record
    public BottomMarginRecord clone() {
        BottomMarginRecord bottomMarginRecord = new BottomMarginRecord();
        bottomMarginRecord.field_1_margin = this.field_1_margin;
        return bottomMarginRecord;
    }
}
