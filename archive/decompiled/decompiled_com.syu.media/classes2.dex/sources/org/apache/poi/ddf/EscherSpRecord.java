package org.apache.poi.ddf;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class EscherSpRecord extends EscherRecord {
    public static final int FLAG_BACKGROUND = 1024;
    public static final int FLAG_CHILD = 2;
    public static final int FLAG_CONNECTOR = 256;
    public static final int FLAG_DELETED = 8;
    public static final int FLAG_FLIPHORIZ = 64;
    public static final int FLAG_FLIPVERT = 128;
    public static final int FLAG_GROUP = 1;
    public static final int FLAG_HASSHAPETYPE = 2048;
    public static final int FLAG_HAVEANCHOR = 512;
    public static final int FLAG_HAVEMASTER = 32;
    public static final int FLAG_OLESHAPE = 16;
    public static final int FLAG_PATRIARCH = 4;
    public static final String RECORD_DESCRIPTION = "MsofbtSp";
    public static final short RECORD_ID = -4086;
    private int field_1_shapeId;
    private int field_2_flags;

    @Override // org.apache.poi.ddf.EscherRecord
    public short getRecordId() {
        return RECORD_ID;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return "Sp";
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return 16;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i, EscherRecordFactory escherRecordFactory) {
        readHeader(bArr, i);
        int i2 = i + 8;
        this.field_1_shapeId = LittleEndian.getInt(bArr, i2 + 0);
        this.field_2_flags = LittleEndian.getInt(bArr, i2 + 4);
        return getRecordSize();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i, getRecordId(), this);
        LittleEndian.putShort(bArr, i, getOptions());
        LittleEndian.putShort(bArr, i + 2, getRecordId());
        LittleEndian.putInt(bArr, i + 4, 8);
        LittleEndian.putInt(bArr, i + 8, this.field_1_shapeId);
        LittleEndian.putInt(bArr, i + 12, this.field_2_flags);
        escherSerializationListener.afterRecordSerialize(i + getRecordSize(), getRecordId(), getRecordSize(), this);
        return 16;
    }

    private String decodeFlags(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append((i & 1) != 0 ? "|GROUP" : "");
        stringBuffer.append((i & 2) != 0 ? "|CHILD" : "");
        stringBuffer.append((i & 4) != 0 ? "|PATRIARCH" : "");
        stringBuffer.append((i & 8) != 0 ? "|DELETED" : "");
        stringBuffer.append((i & 16) != 0 ? "|OLESHAPE" : "");
        stringBuffer.append((i & 32) != 0 ? "|HAVEMASTER" : "");
        stringBuffer.append((i & 64) != 0 ? "|FLIPHORIZ" : "");
        stringBuffer.append((i & 128) != 0 ? "|FLIPVERT" : "");
        stringBuffer.append((i & 256) != 0 ? "|CONNECTOR" : "");
        stringBuffer.append((i & 512) != 0 ? "|HAVEANCHOR" : "");
        stringBuffer.append((i & 1024) != 0 ? "|BACKGROUND" : "");
        stringBuffer.append((i & 2048) != 0 ? "|HASSHAPETYPE" : "");
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(0);
        }
        return stringBuffer.toString();
    }

    public int getShapeId() {
        return this.field_1_shapeId;
    }

    public void setShapeId(int i) {
        this.field_1_shapeId = i;
    }

    public int getFlags() {
        return this.field_2_flags;
    }

    public void setFlags(int i) {
        this.field_2_flags = i;
    }

    public short getShapeType() {
        return getInstance();
    }

    public void setShapeType(short s) {
        setInstance(s);
    }

    @Override // org.apache.poi.ddf.EscherRecord
    protected Object[][] getAttributeMap() {
        return new Object[][]{new Object[]{"ShapeType", Short.valueOf(getShapeType())}, new Object[]{"ShapeId", Integer.valueOf(this.field_1_shapeId)}, new Object[]{"Flags", decodeFlags(this.field_2_flags) + " (0x" + HexDump.toHex(this.field_2_flags) + ")"}};
    }
}
