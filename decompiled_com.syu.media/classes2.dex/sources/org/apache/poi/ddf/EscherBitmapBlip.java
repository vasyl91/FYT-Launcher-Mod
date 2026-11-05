package org.apache.poi.ddf;

import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class EscherBitmapBlip extends EscherBlipRecord {
    private static final int HEADER_SIZE = 8;
    public static final short RECORD_ID_DIB = -4065;
    public static final short RECORD_ID_JPEG = -4067;
    public static final short RECORD_ID_PNG = -4066;
    private final byte[] field_1_UID = new byte[16];
    private byte field_2_marker = -1;

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i, EscherRecordFactory escherRecordFactory) {
        int header = readHeader(bArr, i);
        int i2 = i + 8;
        System.arraycopy(bArr, i2, this.field_1_UID, 0, 16);
        int i3 = i2 + 16;
        this.field_2_marker = bArr[i3];
        setPictureData(bArr, i3 + 1, header - 17);
        return header + 8;
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord
    public int serialize(int i, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i, getRecordId(), this);
        LittleEndian.putShort(bArr, i, getOptions());
        LittleEndian.putShort(bArr, i + 2, getRecordId());
        LittleEndian.putInt(bArr, i + 4, getRecordSize() - 8);
        int i2 = i + 8;
        System.arraycopy(this.field_1_UID, 0, bArr, i2, 16);
        bArr[i2 + 16] = this.field_2_marker;
        byte[] picturedata = getPicturedata();
        System.arraycopy(picturedata, 0, bArr, i2 + 17, picturedata.length);
        escherSerializationListener.afterRecordSerialize(i + getRecordSize(), getRecordId(), getRecordSize(), this);
        return picturedata.length + 25;
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return getPicturedata().length + 25;
    }

    public byte[] getUID() {
        return this.field_1_UID;
    }

    public void setUID(byte[] bArr) {
        if (bArr == null || bArr.length != 16) {
            throw new IllegalArgumentException("field_1_UID must be byte[16]");
        }
        System.arraycopy(bArr, 0, this.field_1_UID, 0, 16);
    }

    public byte getMarker() {
        return this.field_2_marker;
    }

    public void setMarker(byte b) {
        this.field_2_marker = b;
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord
    protected Object[][] getAttributeMap() {
        return new Object[][]{new Object[]{"Marker", Byte.valueOf(this.field_2_marker)}, new Object[]{"Extra Data", getPicturedata()}};
    }
}
