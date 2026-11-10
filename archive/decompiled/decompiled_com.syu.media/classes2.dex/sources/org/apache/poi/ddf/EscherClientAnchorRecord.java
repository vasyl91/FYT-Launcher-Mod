package org.apache.poi.ddf;

import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class EscherClientAnchorRecord extends EscherRecord {
    public static final String RECORD_DESCRIPTION = "MsofbtClientAnchor";
    public static final short RECORD_ID = -4080;
    private short field_1_flag;
    private short field_2_col1;
    private short field_3_dx1;
    private short field_4_row1;
    private short field_5_dy1;
    private short field_6_col2;
    private short field_7_dx2;
    private short field_8_row2;
    private short field_9_dy2;
    private byte[] remainingData = new byte[0];
    private boolean shortRecord = false;

    @Override // org.apache.poi.ddf.EscherRecord
    public short getRecordId() {
        return RECORD_ID;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return "ClientAnchor";
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i, EscherRecordFactory escherRecordFactory) {
        int i2;
        int header = readHeader(bArr, i);
        int i3 = i + 8;
        if (header != 4) {
            this.field_1_flag = LittleEndian.getShort(bArr, i3 + 0);
            this.field_2_col1 = LittleEndian.getShort(bArr, i3 + 2);
            this.field_3_dx1 = LittleEndian.getShort(bArr, i3 + 4);
            this.field_4_row1 = LittleEndian.getShort(bArr, i3 + 6);
            i2 = 18;
            if (header >= 18) {
                this.field_5_dy1 = LittleEndian.getShort(bArr, i3 + 8);
                this.field_6_col2 = LittleEndian.getShort(bArr, i3 + 10);
                this.field_7_dx2 = LittleEndian.getShort(bArr, i3 + 12);
                this.field_8_row2 = LittleEndian.getShort(bArr, i3 + 14);
                this.field_9_dy2 = LittleEndian.getShort(bArr, i3 + 16);
                this.shortRecord = false;
            } else {
                this.shortRecord = true;
                i2 = 8;
            }
        } else {
            i2 = 0;
        }
        int i4 = header - i2;
        byte[] bArr2 = new byte[i4];
        this.remainingData = bArr2;
        System.arraycopy(bArr, i3 + i2, bArr2, 0, i4);
        return i2 + 8 + i4;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i, getRecordId(), this);
        if (this.remainingData == null) {
            this.remainingData = new byte[0];
        }
        LittleEndian.putShort(bArr, i, getOptions());
        LittleEndian.putShort(bArr, i + 2, getRecordId());
        LittleEndian.putInt(bArr, i + 4, this.remainingData.length + (this.shortRecord ? 8 : 18));
        int i2 = i + 8;
        LittleEndian.putShort(bArr, i2, this.field_1_flag);
        LittleEndian.putShort(bArr, i + 10, this.field_2_col1);
        LittleEndian.putShort(bArr, i + 12, this.field_3_dx1);
        LittleEndian.putShort(bArr, i + 14, this.field_4_row1);
        if (!this.shortRecord) {
            LittleEndian.putShort(bArr, i + 16, this.field_5_dy1);
            LittleEndian.putShort(bArr, i + 18, this.field_6_col2);
            LittleEndian.putShort(bArr, i + 20, this.field_7_dx2);
            LittleEndian.putShort(bArr, i + 22, this.field_8_row2);
            LittleEndian.putShort(bArr, i + 24, this.field_9_dy2);
        }
        byte[] bArr2 = this.remainingData;
        System.arraycopy(bArr2, 0, bArr, (this.shortRecord ? 16 : 26) + i, bArr2.length);
        int length = i2 + (this.shortRecord ? 8 : 18) + this.remainingData.length;
        int i3 = length - i;
        escherSerializationListener.afterRecordSerialize(length, getRecordId(), i3, this);
        return i3;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        int i = (this.shortRecord ? 8 : 18) + 8;
        byte[] bArr = this.remainingData;
        return i + (bArr == null ? 0 : bArr.length);
    }

    public short getFlag() {
        return this.field_1_flag;
    }

    public void setFlag(short s) {
        this.field_1_flag = s;
    }

    public short getCol1() {
        return this.field_2_col1;
    }

    public void setCol1(short s) {
        this.field_2_col1 = s;
    }

    public short getDx1() {
        return this.field_3_dx1;
    }

    public void setDx1(short s) {
        this.field_3_dx1 = s;
    }

    public short getRow1() {
        return this.field_4_row1;
    }

    public void setRow1(short s) {
        this.field_4_row1 = s;
    }

    public short getDy1() {
        return this.field_5_dy1;
    }

    public void setDy1(short s) {
        this.shortRecord = false;
        this.field_5_dy1 = s;
    }

    public short getCol2() {
        return this.field_6_col2;
    }

    public void setCol2(short s) {
        this.shortRecord = false;
        this.field_6_col2 = s;
    }

    public short getDx2() {
        return this.field_7_dx2;
    }

    public void setDx2(short s) {
        this.shortRecord = false;
        this.field_7_dx2 = s;
    }

    public short getRow2() {
        return this.field_8_row2;
    }

    public void setRow2(short s) {
        this.shortRecord = false;
        this.field_8_row2 = s;
    }

    public short getDy2() {
        return this.field_9_dy2;
    }

    public void setDy2(short s) {
        this.shortRecord = false;
        this.field_9_dy2 = s;
    }

    public byte[] getRemainingData() {
        return this.remainingData;
    }

    public void setRemainingData(byte[] bArr) {
        if (bArr == null) {
            this.remainingData = new byte[0];
        } else {
            this.remainingData = (byte[]) bArr.clone();
        }
    }

    @Override // org.apache.poi.ddf.EscherRecord
    protected Object[][] getAttributeMap() {
        return new Object[][]{new Object[]{"Flag", Short.valueOf(this.field_1_flag)}, new Object[]{"Col1", Short.valueOf(this.field_2_col1)}, new Object[]{"DX1", Short.valueOf(this.field_3_dx1)}, new Object[]{"Row1", Short.valueOf(this.field_4_row1)}, new Object[]{"DY1", Short.valueOf(this.field_5_dy1)}, new Object[]{"Col2", Short.valueOf(this.field_6_col2)}, new Object[]{"DX2", Short.valueOf(this.field_7_dx2)}, new Object[]{"Row2", Short.valueOf(this.field_8_row2)}, new Object[]{"DY2", Short.valueOf(this.field_9_dy2)}, new Object[]{"Extra Data", this.remainingData}};
    }
}
