package org.apache.poi.ddf;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.InflaterInputStream;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class EscherPictBlip extends EscherBlipRecord {
    private static final int HEADER_SIZE = 8;
    public static final short RECORD_ID_EMF = -4070;
    public static final short RECORD_ID_PICT = -4068;
    public static final short RECORD_ID_WMF = -4069;
    private static final POILogger log = POILogFactory.getLogger((Class<?>) EscherPictBlip.class);
    private final byte[] field_1_UID = new byte[16];
    private int field_2_cb;
    private int field_3_rcBounds_x1;
    private int field_3_rcBounds_x2;
    private int field_3_rcBounds_y1;
    private int field_3_rcBounds_y2;
    private int field_4_ptSize_h;
    private int field_4_ptSize_w;
    private int field_5_cbSave;
    private byte field_6_fCompression;
    private byte field_7_fFilter;
    private byte[] raw_pictureData;

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i, EscherRecordFactory escherRecordFactory) {
        int header = readHeader(bArr, i);
        int i2 = i + 8;
        System.arraycopy(bArr, i2, this.field_1_UID, 0, 16);
        int i3 = i2 + 16;
        this.field_2_cb = LittleEndian.getInt(bArr, i3);
        int i4 = i3 + 4;
        this.field_3_rcBounds_x1 = LittleEndian.getInt(bArr, i4);
        int i5 = i4 + 4;
        this.field_3_rcBounds_y1 = LittleEndian.getInt(bArr, i5);
        int i6 = i5 + 4;
        this.field_3_rcBounds_x2 = LittleEndian.getInt(bArr, i6);
        int i7 = i6 + 4;
        this.field_3_rcBounds_y2 = LittleEndian.getInt(bArr, i7);
        int i8 = i7 + 4;
        this.field_4_ptSize_w = LittleEndian.getInt(bArr, i8);
        int i9 = i8 + 4;
        this.field_4_ptSize_h = LittleEndian.getInt(bArr, i9);
        int i10 = i9 + 4;
        int i11 = LittleEndian.getInt(bArr, i10);
        this.field_5_cbSave = i11;
        int i12 = i10 + 4;
        this.field_6_fCompression = bArr[i12];
        int i13 = i12 + 1;
        this.field_7_fFilter = bArr[i13];
        byte[] bArr2 = new byte[i11];
        this.raw_pictureData = bArr2;
        System.arraycopy(bArr, i13 + 1, bArr2, 0, i11);
        if (this.field_6_fCompression == 0) {
            super.setPictureData(inflatePictureData(this.raw_pictureData));
        } else {
            super.setPictureData(this.raw_pictureData);
        }
        return header + 8;
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord
    public int serialize(int i, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i, getRecordId(), this);
        LittleEndian.putShort(bArr, i, getOptions());
        int i2 = i + 2;
        LittleEndian.putShort(bArr, i2, getRecordId());
        LittleEndian.putInt(bArr, 0, getRecordSize() - 8);
        int i3 = i2 + 2 + 4;
        System.arraycopy(this.field_1_UID, 0, bArr, i3, 16);
        int i4 = i3 + 16;
        LittleEndian.putInt(bArr, i4, this.field_2_cb);
        int i5 = i4 + 4;
        LittleEndian.putInt(bArr, i5, this.field_3_rcBounds_x1);
        int i6 = i5 + 4;
        LittleEndian.putInt(bArr, i6, this.field_3_rcBounds_y1);
        int i7 = i6 + 4;
        LittleEndian.putInt(bArr, i7, this.field_3_rcBounds_x2);
        int i8 = i7 + 4;
        LittleEndian.putInt(bArr, i8, this.field_3_rcBounds_y2);
        int i9 = i8 + 4;
        LittleEndian.putInt(bArr, i9, this.field_4_ptSize_w);
        int i10 = i9 + 4;
        LittleEndian.putInt(bArr, i10, this.field_4_ptSize_h);
        int i11 = i10 + 4;
        LittleEndian.putInt(bArr, i11, this.field_5_cbSave);
        int i12 = i11 + 4;
        bArr[i12] = this.field_6_fCompression;
        int i13 = i12 + 1;
        bArr[i13] = this.field_7_fFilter;
        byte[] bArr2 = this.raw_pictureData;
        System.arraycopy(bArr2, 0, bArr, i13 + 1, bArr2.length);
        escherSerializationListener.afterRecordSerialize(i + getRecordSize(), getRecordId(), getRecordSize(), this);
        return this.raw_pictureData.length + 25;
    }

    private static byte[] inflatePictureData(byte[] bArr) {
        try {
            InflaterInputStream inflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(bArr));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[4096];
            while (true) {
                int i = inflaterInputStream.read(bArr2);
                if (i > 0) {
                    byteArrayOutputStream.write(bArr2, 0, i);
                } else {
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            log.log(3, "Possibly corrupt compression or non-compressed data", e);
            return bArr;
        }
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return this.raw_pictureData.length + 58;
    }

    public byte[] getUID() {
        return this.field_1_UID;
    }

    public void setUID(byte[] bArr) {
        if (bArr == null || bArr.length != 16) {
            throw new IllegalArgumentException("uid must be byte[16]");
        }
        byte[] bArr2 = this.field_1_UID;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
    }

    public int getUncompressedSize() {
        return this.field_2_cb;
    }

    public void setUncompressedSize(int i) {
        this.field_2_cb = i;
    }

    public Rectangle getBounds() {
        int i = this.field_3_rcBounds_x1;
        int i2 = this.field_3_rcBounds_y1;
        return new Rectangle(i, i2, this.field_3_rcBounds_x2 - i, this.field_3_rcBounds_y2 - i2);
    }

    public void setBounds(Rectangle rectangle) {
        this.field_3_rcBounds_x1 = rectangle.x;
        this.field_3_rcBounds_y1 = rectangle.y;
        this.field_3_rcBounds_x2 = rectangle.x + rectangle.width;
        this.field_3_rcBounds_y2 = rectangle.y + rectangle.height;
    }

    public Dimension getSizeEMU() {
        return new Dimension(this.field_4_ptSize_w, this.field_4_ptSize_h);
    }

    public void setSizeEMU(Dimension dimension) {
        this.field_4_ptSize_w = dimension.width;
        this.field_4_ptSize_h = dimension.height;
    }

    public int getCompressedSize() {
        return this.field_5_cbSave;
    }

    public void setCompressedSize(int i) {
        this.field_5_cbSave = i;
    }

    public boolean isCompressed() {
        return this.field_6_fCompression == 0;
    }

    public void setCompressed(boolean z) {
        this.field_6_fCompression = z ? (byte) 0 : (byte) -2;
    }

    public byte getFilter() {
        return this.field_7_fFilter;
    }

    public void setFilter(byte b) {
        this.field_7_fFilter = b;
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord
    protected Object[][] getAttributeMap() {
        return new Object[][]{new Object[]{"UID", this.field_1_UID}, new Object[]{"Uncompressed Size", Integer.valueOf(this.field_2_cb)}, new Object[]{"Bounds", getBounds().toString()}, new Object[]{"Size in EMU", getSizeEMU().toString()}, new Object[]{"Compressed Size", Integer.valueOf(this.field_5_cbSave)}, new Object[]{"Compression", Byte.valueOf(this.field_6_fCompression)}, new Object[]{"Filter", Byte.valueOf(this.field_7_fFilter)}, new Object[]{"Extra Data", getPicturedata()}};
    }
}
