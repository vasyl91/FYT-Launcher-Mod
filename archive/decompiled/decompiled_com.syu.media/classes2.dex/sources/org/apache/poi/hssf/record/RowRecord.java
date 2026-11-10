package org.apache.poi.hssf.record;

import org.apache.poi.hpsf.Variant;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class RowRecord extends StandardRecord {
    public static final int ENCODED_SIZE = 20;
    private static final int OPTION_BITS_ALWAYS_SET = 256;
    public static final short sid = 520;
    private int field_1_row_number;
    private int field_2_first_col;
    private int field_3_last_col;
    private short field_4_height;
    private short field_5_optimize;
    private short field_6_reserved;
    private int field_7_option_flags;
    private int field_8_option_flags;
    private static final BitField outlineLevel = BitFieldFactory.getInstance(7);
    private static final BitField colapsed = BitFieldFactory.getInstance(16);
    private static final BitField zeroHeight = BitFieldFactory.getInstance(32);
    private static final BitField badFontHeight = BitFieldFactory.getInstance(64);
    private static final BitField formatted = BitFieldFactory.getInstance(128);
    private static final BitField xfIndex = BitFieldFactory.getInstance(4095);
    private static final BitField topBorder = BitFieldFactory.getInstance(4096);
    private static final BitField bottomBorder = BitFieldFactory.getInstance(8192);
    private static final BitField phoeneticGuide = BitFieldFactory.getInstance(Variant.VT_BYREF);

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 16;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 520;
    }

    public RowRecord(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Invalid row number (" + i + ")");
        }
        this.field_1_row_number = i;
        this.field_4_height = (short) 255;
        this.field_5_optimize = (short) 0;
        this.field_6_reserved = (short) 0;
        this.field_7_option_flags = 256;
        this.field_8_option_flags = 15;
        setEmpty();
    }

    public RowRecord(RecordInputStream recordInputStream) {
        int uShort = recordInputStream.readUShort();
        this.field_1_row_number = uShort;
        if (uShort < 0) {
            throw new IllegalArgumentException("Invalid row number " + this.field_1_row_number + " found in InputStream");
        }
        this.field_2_first_col = recordInputStream.readShort();
        this.field_3_last_col = recordInputStream.readShort();
        this.field_4_height = recordInputStream.readShort();
        this.field_5_optimize = recordInputStream.readShort();
        this.field_6_reserved = recordInputStream.readShort();
        this.field_7_option_flags = recordInputStream.readShort();
        this.field_8_option_flags = recordInputStream.readShort();
    }

    public void setEmpty() {
        this.field_2_first_col = 0;
        this.field_3_last_col = 0;
    }

    public boolean isEmpty() {
        return (this.field_2_first_col | this.field_3_last_col) == 0;
    }

    public void setRowNumber(int i) {
        this.field_1_row_number = i;
    }

    public void setFirstCol(int i) {
        this.field_2_first_col = i;
    }

    public void setLastCol(int i) {
        this.field_3_last_col = i;
    }

    public void setHeight(short s) {
        this.field_4_height = s;
    }

    public void setOptimize(short s) {
        this.field_5_optimize = s;
    }

    public void setOutlineLevel(short s) {
        this.field_7_option_flags = outlineLevel.setValue(this.field_7_option_flags, s);
    }

    public void setColapsed(boolean z) {
        this.field_7_option_flags = colapsed.setBoolean(this.field_7_option_flags, z);
    }

    public void setZeroHeight(boolean z) {
        this.field_7_option_flags = zeroHeight.setBoolean(this.field_7_option_flags, z);
    }

    public void setBadFontHeight(boolean z) {
        this.field_7_option_flags = badFontHeight.setBoolean(this.field_7_option_flags, z);
    }

    public void setFormatted(boolean z) {
        this.field_7_option_flags = formatted.setBoolean(this.field_7_option_flags, z);
    }

    public void setXFIndex(short s) {
        this.field_8_option_flags = xfIndex.setValue(this.field_8_option_flags, s);
    }

    public void setTopBorder(boolean z) {
        this.field_8_option_flags = topBorder.setBoolean(this.field_8_option_flags, z);
    }

    public void setBottomBorder(boolean z) {
        this.field_8_option_flags = bottomBorder.setBoolean(this.field_8_option_flags, z);
    }

    public void setPhoeneticGuide(boolean z) {
        this.field_8_option_flags = phoeneticGuide.setBoolean(this.field_8_option_flags, z);
    }

    public int getRowNumber() {
        return this.field_1_row_number;
    }

    public int getFirstCol() {
        return this.field_2_first_col;
    }

    public int getLastCol() {
        return this.field_3_last_col;
    }

    public short getHeight() {
        return this.field_4_height;
    }

    public short getOptimize() {
        return this.field_5_optimize;
    }

    public short getOptionFlags() {
        return (short) this.field_7_option_flags;
    }

    public short getOutlineLevel() {
        return (short) outlineLevel.getValue(this.field_7_option_flags);
    }

    public boolean getColapsed() {
        return colapsed.isSet(this.field_7_option_flags);
    }

    public boolean getZeroHeight() {
        return zeroHeight.isSet(this.field_7_option_flags);
    }

    public boolean getBadFontHeight() {
        return badFontHeight.isSet(this.field_7_option_flags);
    }

    public boolean getFormatted() {
        return formatted.isSet(this.field_7_option_flags);
    }

    public short getOptionFlags2() {
        return (short) this.field_8_option_flags;
    }

    public short getXFIndex() {
        return xfIndex.getShortValue((short) this.field_8_option_flags);
    }

    public boolean getTopBorder() {
        return topBorder.isSet(this.field_8_option_flags);
    }

    public boolean getBottomBorder() {
        return bottomBorder.isSet(this.field_8_option_flags);
    }

    public boolean getPhoeneticGuide() {
        return phoeneticGuide.isSet(this.field_8_option_flags);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[ROW]\n    .rownumber      = ");
        stringBuffer.append(Integer.toHexString(getRowNumber())).append("\n    .firstcol       = ");
        stringBuffer.append(HexDump.shortToHex(getFirstCol())).append("\n    .lastcol        = ");
        stringBuffer.append(HexDump.shortToHex(getLastCol())).append("\n    .height         = ");
        stringBuffer.append(HexDump.shortToHex(getHeight())).append("\n    .optimize       = ");
        stringBuffer.append(HexDump.shortToHex(getOptimize())).append("\n    .reserved       = ");
        stringBuffer.append(HexDump.shortToHex(this.field_6_reserved)).append("\n    .optionflags    = ");
        stringBuffer.append(HexDump.shortToHex(getOptionFlags())).append("\n        .outlinelvl = ");
        stringBuffer.append(Integer.toHexString(getOutlineLevel())).append("\n        .colapsed   = ");
        stringBuffer.append(getColapsed()).append("\n        .zeroheight = ");
        stringBuffer.append(getZeroHeight()).append("\n        .badfontheig= ");
        stringBuffer.append(getBadFontHeight()).append("\n        .formatted  = ");
        stringBuffer.append(getFormatted()).append("\n    .optionsflags2  = ");
        stringBuffer.append(HexDump.shortToHex(getOptionFlags2())).append("\n        .xfindex       = ");
        stringBuffer.append(Integer.toHexString(getXFIndex())).append("\n        .topBorder     = ");
        stringBuffer.append(getTopBorder()).append("\n        .bottomBorder  = ");
        stringBuffer.append(getBottomBorder()).append("\n        .phoeneticGuide= ");
        stringBuffer.append(getPhoeneticGuide()).append("\n[/ROW]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getRowNumber());
        littleEndianOutput.writeShort(getFirstCol() == -1 ? 0 : getFirstCol());
        littleEndianOutput.writeShort(getLastCol() != -1 ? getLastCol() : 0);
        littleEndianOutput.writeShort(getHeight());
        littleEndianOutput.writeShort(getOptimize());
        littleEndianOutput.writeShort(this.field_6_reserved);
        littleEndianOutput.writeShort(getOptionFlags());
        littleEndianOutput.writeShort(getOptionFlags2());
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        RowRecord rowRecord = new RowRecord(this.field_1_row_number);
        rowRecord.field_2_first_col = this.field_2_first_col;
        rowRecord.field_3_last_col = this.field_3_last_col;
        rowRecord.field_4_height = this.field_4_height;
        rowRecord.field_5_optimize = this.field_5_optimize;
        rowRecord.field_6_reserved = this.field_6_reserved;
        rowRecord.field_7_option_flags = this.field_7_option_flags;
        rowRecord.field_8_option_flags = this.field_8_option_flags;
        return rowRecord;
    }
}
