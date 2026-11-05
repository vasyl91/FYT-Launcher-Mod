package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class FontIndexRecord extends StandardRecord implements Cloneable {
    public static final short sid = 4134;
    private short field_1_fontIndex;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public FontIndexRecord() {
    }

    public FontIndexRecord(RecordInputStream recordInputStream) {
        this.field_1_fontIndex = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[FONTX]\n    .fontIndex            = 0x");
        stringBuffer.append(HexDump.toHex(getFontIndex())).append(" (").append((int) getFontIndex()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("[/FONTX]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_fontIndex);
    }

    @Override // org.apache.poi.hssf.record.Record
    public FontIndexRecord clone() {
        FontIndexRecord fontIndexRecord = new FontIndexRecord();
        fontIndexRecord.field_1_fontIndex = this.field_1_fontIndex;
        return fontIndexRecord;
    }

    public short getFontIndex() {
        return this.field_1_fontIndex;
    }

    public void setFontIndex(short s) {
        this.field_1_fontIndex = s;
    }
}
