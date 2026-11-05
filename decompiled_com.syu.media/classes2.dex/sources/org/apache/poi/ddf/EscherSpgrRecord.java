package org.apache.poi.ddf;

import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class EscherSpgrRecord extends EscherRecord {
    public static final String RECORD_DESCRIPTION = "MsofbtSpgr";
    public static final short RECORD_ID = -4087;
    private int field_1_rectX1;
    private int field_2_rectY1;
    private int field_3_rectX2;
    private int field_4_rectY2;

    @Override // org.apache.poi.ddf.EscherRecord
    public short getRecordId() {
        return RECORD_ID;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return "Spgr";
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return 24;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i, EscherRecordFactory escherRecordFactory) {
        int header = readHeader(bArr, i);
        int i2 = i + 8;
        this.field_1_rectX1 = LittleEndian.getInt(bArr, i2 + 0);
        this.field_2_rectY1 = LittleEndian.getInt(bArr, i2 + 4);
        this.field_3_rectX2 = LittleEndian.getInt(bArr, i2 + 8);
        this.field_4_rectY2 = LittleEndian.getInt(bArr, i2 + 12);
        int i3 = header - 16;
        if (i3 == 0) {
            return 24 + i3;
        }
        throw new RecordFormatException("Expected no remaining bytes but got " + i3);
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i, getRecordId(), this);
        LittleEndian.putShort(bArr, i, getOptions());
        LittleEndian.putShort(bArr, i + 2, getRecordId());
        LittleEndian.putInt(bArr, i + 4, 16);
        LittleEndian.putInt(bArr, i + 8, this.field_1_rectX1);
        LittleEndian.putInt(bArr, i + 12, this.field_2_rectY1);
        LittleEndian.putInt(bArr, i + 16, this.field_3_rectX2);
        LittleEndian.putInt(bArr, i + 20, this.field_4_rectY2);
        escherSerializationListener.afterRecordSerialize(getRecordSize() + i, getRecordId(), i + getRecordSize(), this);
        return 24;
    }

    public int getRectX1() {
        return this.field_1_rectX1;
    }

    public void setRectX1(int i) {
        this.field_1_rectX1 = i;
    }

    public int getRectY1() {
        return this.field_2_rectY1;
    }

    public void setRectY1(int i) {
        this.field_2_rectY1 = i;
    }

    public int getRectX2() {
        return this.field_3_rectX2;
    }

    public void setRectX2(int i) {
        this.field_3_rectX2 = i;
    }

    public int getRectY2() {
        return this.field_4_rectY2;
    }

    public void setRectY2(int i) {
        this.field_4_rectY2 = i;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    protected Object[][] getAttributeMap() {
        return new Object[][]{new Object[]{"RectX", Integer.valueOf(this.field_1_rectX1)}, new Object[]{"RectY", Integer.valueOf(this.field_2_rectY1)}, new Object[]{"RectWidth", Integer.valueOf(this.field_3_rectX2)}, new Object[]{"RectHeight", Integer.valueOf(this.field_4_rectY2)}};
    }
}
