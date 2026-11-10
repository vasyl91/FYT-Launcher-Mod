package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class SheetPropertiesRecord extends StandardRecord {
    public static final byte EMPTY_INTERPOLATED = 2;
    public static final byte EMPTY_NOT_PLOTTED = 0;
    public static final byte EMPTY_ZERO = 1;
    public static final short sid = 4164;
    private int field_1_flags;
    private int field_2_empty;
    private static final BitField chartTypeManuallyFormatted = BitFieldFactory.getInstance(1);
    private static final BitField plotVisibleOnly = BitFieldFactory.getInstance(2);
    private static final BitField doNotSizeWithWindow = BitFieldFactory.getInstance(4);
    private static final BitField defaultPlotDimensions = BitFieldFactory.getInstance(8);
    private static final BitField autoPlotArea = BitFieldFactory.getInstance(16);

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 4;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public SheetPropertiesRecord() {
    }

    public SheetPropertiesRecord(RecordInputStream recordInputStream) {
        this.field_1_flags = recordInputStream.readUShort();
        this.field_2_empty = recordInputStream.readUShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[SHTPROPS]\n    .flags                = ");
        stringBuffer.append(HexDump.shortToHex(this.field_1_flags)).append("\n         .chartTypeManuallyFormatted= ");
        stringBuffer.append(isChartTypeManuallyFormatted()).append("\n         .plotVisibleOnly           = ");
        stringBuffer.append(isPlotVisibleOnly()).append("\n         .doNotSizeWithWindow       = ");
        stringBuffer.append(isDoNotSizeWithWindow()).append("\n         .defaultPlotDimensions     = ");
        stringBuffer.append(isDefaultPlotDimensions()).append("\n         .autoPlotArea              = ");
        stringBuffer.append(isAutoPlotArea()).append("\n    .empty                = ");
        stringBuffer.append(HexDump.shortToHex(this.field_2_empty)).append("\n[/SHTPROPS]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_flags);
        littleEndianOutput.writeShort(this.field_2_empty);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        SheetPropertiesRecord sheetPropertiesRecord = new SheetPropertiesRecord();
        sheetPropertiesRecord.field_1_flags = this.field_1_flags;
        sheetPropertiesRecord.field_2_empty = this.field_2_empty;
        return sheetPropertiesRecord;
    }

    public int getFlags() {
        return this.field_1_flags;
    }

    public int getEmpty() {
        return this.field_2_empty;
    }

    public void setEmpty(byte b) {
        this.field_2_empty = b;
    }

    public void setChartTypeManuallyFormatted(boolean z) {
        this.field_1_flags = chartTypeManuallyFormatted.setBoolean(this.field_1_flags, z);
    }

    public boolean isChartTypeManuallyFormatted() {
        return chartTypeManuallyFormatted.isSet(this.field_1_flags);
    }

    public void setPlotVisibleOnly(boolean z) {
        this.field_1_flags = plotVisibleOnly.setBoolean(this.field_1_flags, z);
    }

    public boolean isPlotVisibleOnly() {
        return plotVisibleOnly.isSet(this.field_1_flags);
    }

    public void setDoNotSizeWithWindow(boolean z) {
        this.field_1_flags = doNotSizeWithWindow.setBoolean(this.field_1_flags, z);
    }

    public boolean isDoNotSizeWithWindow() {
        return doNotSizeWithWindow.isSet(this.field_1_flags);
    }

    public void setDefaultPlotDimensions(boolean z) {
        this.field_1_flags = defaultPlotDimensions.setBoolean(this.field_1_flags, z);
    }

    public boolean isDefaultPlotDimensions() {
        return defaultPlotDimensions.isSet(this.field_1_flags);
    }

    public void setAutoPlotArea(boolean z) {
        this.field_1_flags = autoPlotArea.setBoolean(this.field_1_flags, z);
    }

    public boolean isAutoPlotArea() {
        return autoPlotArea.isSet(this.field_1_flags);
    }
}
