package org.apache.poi.hssf.record;

import org.apache.poi.hpsf.Variant;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class CommonObjectDataSubRecord extends SubRecord implements Cloneable {
    public static final short OBJECT_TYPE_ARC = 4;
    public static final short OBJECT_TYPE_BUTTON = 7;
    public static final short OBJECT_TYPE_CHART = 5;
    public static final short OBJECT_TYPE_CHECKBOX = 11;
    public static final short OBJECT_TYPE_COMBO_BOX = 20;
    public static final short OBJECT_TYPE_COMMENT = 25;
    public static final short OBJECT_TYPE_DIALOG_BOX = 15;
    public static final short OBJECT_TYPE_EDIT_BOX = 13;
    public static final short OBJECT_TYPE_GROUP = 0;
    public static final short OBJECT_TYPE_GROUP_BOX = 19;
    public static final short OBJECT_TYPE_LABEL = 14;
    public static final short OBJECT_TYPE_LINE = 1;
    public static final short OBJECT_TYPE_LIST_BOX = 18;
    public static final short OBJECT_TYPE_MICROSOFT_OFFICE_DRAWING = 30;
    public static final short OBJECT_TYPE_OPTION_BUTTON = 12;
    public static final short OBJECT_TYPE_OVAL = 3;
    public static final short OBJECT_TYPE_PICTURE = 8;
    public static final short OBJECT_TYPE_POLYGON = 9;
    public static final short OBJECT_TYPE_RECTANGLE = 2;
    public static final short OBJECT_TYPE_RESERVED1 = 10;
    public static final short OBJECT_TYPE_RESERVED2 = 21;
    public static final short OBJECT_TYPE_RESERVED3 = 22;
    public static final short OBJECT_TYPE_RESERVED4 = 23;
    public static final short OBJECT_TYPE_RESERVED5 = 24;
    public static final short OBJECT_TYPE_RESERVED6 = 26;
    public static final short OBJECT_TYPE_RESERVED7 = 27;
    public static final short OBJECT_TYPE_RESERVED8 = 28;
    public static final short OBJECT_TYPE_RESERVED9 = 29;
    public static final short OBJECT_TYPE_SCROLL_BAR = 17;
    public static final short OBJECT_TYPE_SPINNER = 16;
    public static final short OBJECT_TYPE_TEXT = 6;
    public static final short sid = 21;
    private short field_1_objectType;
    private int field_2_objectId;
    private short field_3_option;
    private int field_4_reserved1;
    private int field_5_reserved2;
    private int field_6_reserved3;
    private static final BitField locked = BitFieldFactory.getInstance(1);
    private static final BitField printable = BitFieldFactory.getInstance(16);
    private static final BitField autofill = BitFieldFactory.getInstance(8192);
    private static final BitField autoline = BitFieldFactory.getInstance(Variant.VT_BYREF);

    @Override // org.apache.poi.hssf.record.SubRecord
    protected int getDataSize() {
        return 18;
    }

    public short getSid() {
        return (short) 21;
    }

    public CommonObjectDataSubRecord() {
    }

    public CommonObjectDataSubRecord(LittleEndianInput littleEndianInput, int i) {
        if (i != 18) {
            throw new RecordFormatException("Expected size 18 but got (" + i + ")");
        }
        this.field_1_objectType = littleEndianInput.readShort();
        this.field_2_objectId = littleEndianInput.readUShort();
        this.field_3_option = littleEndianInput.readShort();
        this.field_4_reserved1 = littleEndianInput.readInt();
        this.field_5_reserved2 = littleEndianInput.readInt();
        this.field_6_reserved3 = littleEndianInput.readInt();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[ftCmo]\n    .objectType           = 0x");
        stringBuffer.append(HexDump.toHex(getObjectType())).append(" (").append((int) getObjectType()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .objectId             = 0x").append(HexDump.toHex(getObjectId())).append(" (").append(getObjectId()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .option               = 0x").append(HexDump.toHex(getOption())).append(" (").append((int) getOption()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("         .locked                   = ").append(isLocked()).append("\n         .printable                = ");
        stringBuffer.append(isPrintable()).append("\n         .autofill                 = ");
        stringBuffer.append(isAutofill()).append("\n         .autoline                 = ");
        stringBuffer.append(isAutoline()).append("\n    .reserved1            = 0x");
        stringBuffer.append(HexDump.toHex(getReserved1())).append(" (").append(getReserved1()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .reserved2            = 0x").append(HexDump.toHex(getReserved2())).append(" (").append(getReserved2()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("    .reserved3            = 0x").append(HexDump.toHex(getReserved3())).append(" (").append(getReserved3()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("[/ftCmo]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(21);
        littleEndianOutput.writeShort(getDataSize());
        littleEndianOutput.writeShort(this.field_1_objectType);
        littleEndianOutput.writeShort(this.field_2_objectId);
        littleEndianOutput.writeShort(this.field_3_option);
        littleEndianOutput.writeInt(this.field_4_reserved1);
        littleEndianOutput.writeInt(this.field_5_reserved2);
        littleEndianOutput.writeInt(this.field_6_reserved3);
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public CommonObjectDataSubRecord mo1560clone() {
        CommonObjectDataSubRecord commonObjectDataSubRecord = new CommonObjectDataSubRecord();
        commonObjectDataSubRecord.field_1_objectType = this.field_1_objectType;
        commonObjectDataSubRecord.field_2_objectId = this.field_2_objectId;
        commonObjectDataSubRecord.field_3_option = this.field_3_option;
        commonObjectDataSubRecord.field_4_reserved1 = this.field_4_reserved1;
        commonObjectDataSubRecord.field_5_reserved2 = this.field_5_reserved2;
        commonObjectDataSubRecord.field_6_reserved3 = this.field_6_reserved3;
        return commonObjectDataSubRecord;
    }

    public short getObjectType() {
        return this.field_1_objectType;
    }

    public void setObjectType(short s) {
        this.field_1_objectType = s;
    }

    public int getObjectId() {
        return this.field_2_objectId;
    }

    public void setObjectId(int i) {
        this.field_2_objectId = i;
    }

    public short getOption() {
        return this.field_3_option;
    }

    public void setOption(short s) {
        this.field_3_option = s;
    }

    public int getReserved1() {
        return this.field_4_reserved1;
    }

    public void setReserved1(int i) {
        this.field_4_reserved1 = i;
    }

    public int getReserved2() {
        return this.field_5_reserved2;
    }

    public void setReserved2(int i) {
        this.field_5_reserved2 = i;
    }

    public int getReserved3() {
        return this.field_6_reserved3;
    }

    public void setReserved3(int i) {
        this.field_6_reserved3 = i;
    }

    public void setLocked(boolean z) {
        this.field_3_option = locked.setShortBoolean(this.field_3_option, z);
    }

    public boolean isLocked() {
        return locked.isSet(this.field_3_option);
    }

    public void setPrintable(boolean z) {
        this.field_3_option = printable.setShortBoolean(this.field_3_option, z);
    }

    public boolean isPrintable() {
        return printable.isSet(this.field_3_option);
    }

    public void setAutofill(boolean z) {
        this.field_3_option = autofill.setShortBoolean(this.field_3_option, z);
    }

    public boolean isAutofill() {
        return autofill.isSet(this.field_3_option);
    }

    public void setAutoline(boolean z) {
        this.field_3_option = autoline.setShortBoolean(this.field_3_option, z);
    }

    public boolean isAutoline() {
        return autoline.isSet(this.field_3_option);
    }
}
