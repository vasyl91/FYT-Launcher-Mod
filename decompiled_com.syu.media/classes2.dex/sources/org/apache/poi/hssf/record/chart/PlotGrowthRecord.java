package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class PlotGrowthRecord extends StandardRecord {
    public static final short sid = 4196;
    private int field_1_horizontalScale;
    private int field_2_verticalScale;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 8;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public PlotGrowthRecord() {
    }

    public PlotGrowthRecord(RecordInputStream recordInputStream) {
        this.field_1_horizontalScale = recordInputStream.readInt();
        this.field_2_verticalScale = recordInputStream.readInt();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[PLOTGROWTH]\n    .horizontalScale      = 0x");
        stringBuffer.append(HexDump.toHex(getHorizontalScale())).append(" (").append(getHorizontalScale()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .verticalScale        = 0x").append(HexDump.toHex(getVerticalScale())).append(" (").append(getVerticalScale()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("[/PLOTGROWTH]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeInt(this.field_1_horizontalScale);
        littleEndianOutput.writeInt(this.field_2_verticalScale);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        PlotGrowthRecord plotGrowthRecord = new PlotGrowthRecord();
        plotGrowthRecord.field_1_horizontalScale = this.field_1_horizontalScale;
        plotGrowthRecord.field_2_verticalScale = this.field_2_verticalScale;
        return plotGrowthRecord;
    }

    public int getHorizontalScale() {
        return this.field_1_horizontalScale;
    }

    public void setHorizontalScale(int i) {
        this.field_1_horizontalScale = i;
    }

    public int getVerticalScale() {
        return this.field_2_verticalScale;
    }

    public void setVerticalScale(int i) {
        this.field_2_verticalScale = i;
    }
}
