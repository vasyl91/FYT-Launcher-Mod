package org.apache.poi.ddf;

import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class EscherBlipRecord extends EscherRecord {
    private static final int HEADER_SIZE = 8;
    public static final String RECORD_DESCRIPTION = "msofbtBlip";
    public static final short RECORD_ID_END = -3817;
    public static final short RECORD_ID_START = -4072;
    private byte[] field_pictureData;

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return "Blip";
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i, EscherRecordFactory escherRecordFactory) {
        int header = readHeader(bArr, i);
        byte[] bArr2 = new byte[header];
        this.field_pictureData = bArr2;
        System.arraycopy(bArr, i + 8, bArr2, 0, header);
        return header + 8;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i, getRecordId(), this);
        LittleEndian.putShort(bArr, i, getOptions());
        LittleEndian.putShort(bArr, i + 2, getRecordId());
        byte[] bArr2 = this.field_pictureData;
        int i2 = i + 4;
        System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
        escherSerializationListener.afterRecordSerialize(i2 + this.field_pictureData.length, getRecordId(), this.field_pictureData.length + 4, this);
        return this.field_pictureData.length + 4;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return this.field_pictureData.length + 8;
    }

    public byte[] getPicturedata() {
        return this.field_pictureData;
    }

    public void setPictureData(byte[] bArr) {
        setPictureData(bArr, 0, bArr == null ? 0 : bArr.length);
    }

    public void setPictureData(byte[] bArr, int i, int i2) {
        if (bArr == null || i < 0 || i2 < 0 || bArr.length < i + i2) {
            throw new IllegalArgumentException("picture data can't be null");
        }
        byte[] bArr2 = new byte[i2];
        this.field_pictureData = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
    }

    @Override // org.apache.poi.ddf.EscherRecord
    protected Object[][] getAttributeMap() {
        return new Object[][]{new Object[]{"Extra Data", getPicturedata()}};
    }
}
