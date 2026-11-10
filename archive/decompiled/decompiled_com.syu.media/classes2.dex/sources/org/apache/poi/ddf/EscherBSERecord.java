package org.apache.poi.ddf;

import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class EscherBSERecord extends EscherRecord {
    public static final byte BT_DIB = 7;
    public static final byte BT_EMF = 2;
    public static final byte BT_ERROR = 0;
    public static final byte BT_JPEG = 5;
    public static final byte BT_PICT = 4;
    public static final byte BT_PNG = 6;
    public static final byte BT_UNKNOWN = 1;
    public static final byte BT_WMF = 3;
    public static final String RECORD_DESCRIPTION = "MsofbtBSE";
    public static final short RECORD_ID = -4089;
    private byte field_10_unused2;
    private byte field_11_unused3;
    private EscherBlipRecord field_12_blipRecord;
    private byte field_1_blipTypeWin32;
    private byte field_2_blipTypeMacOS;
    private short field_4_tag;
    private int field_5_size;
    private int field_6_ref;
    private int field_7_offset;
    private byte field_8_usage;
    private byte field_9_name;
    private final byte[] field_3_uid = new byte[16];
    private byte[] _remainingData = new byte[0];

    public static String getBlipType(byte b) {
        switch (b) {
            case 0:
                return " ERROR";
            case 1:
                return " UNKNOWN";
            case 2:
                return " EMF";
            case 3:
                return " WMF";
            case 4:
                return " PICT";
            case 5:
                return " JPEG";
            case 6:
                return " PNG";
            case 7:
                return " DIB";
            default:
                return b < 32 ? " NotKnown" : " Client";
        }
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return "BSE";
    }

    public EscherBSERecord() {
        setRecordId(RECORD_ID);
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i, EscherRecordFactory escherRecordFactory) {
        int iFillFields;
        int header = readHeader(bArr, i);
        int i2 = i + 8;
        this.field_1_blipTypeWin32 = bArr[i2];
        this.field_2_blipTypeMacOS = bArr[i2 + 1];
        System.arraycopy(bArr, i2 + 2, this.field_3_uid, 0, 16);
        this.field_4_tag = LittleEndian.getShort(bArr, i2 + 18);
        this.field_5_size = LittleEndian.getInt(bArr, i2 + 20);
        this.field_6_ref = LittleEndian.getInt(bArr, i2 + 24);
        this.field_7_offset = LittleEndian.getInt(bArr, i2 + 28);
        this.field_8_usage = bArr[i2 + 32];
        this.field_9_name = bArr[i2 + 33];
        this.field_10_unused2 = bArr[i2 + 34];
        this.field_11_unused3 = bArr[i2 + 35];
        int i3 = header - 36;
        if (i3 > 0) {
            int i4 = i2 + 36;
            EscherBlipRecord escherBlipRecord = (EscherBlipRecord) escherRecordFactory.createRecord(bArr, i4);
            this.field_12_blipRecord = escherBlipRecord;
            iFillFields = escherBlipRecord.fillFields(bArr, i4, escherRecordFactory);
        } else {
            iFillFields = 0;
        }
        int i5 = i2 + iFillFields + 36;
        int i6 = i3 - iFillFields;
        byte[] bArr2 = new byte[i6];
        this._remainingData = bArr2;
        System.arraycopy(bArr, i5, bArr2, 0, i6);
        int i7 = i6 + 8 + 36;
        EscherBlipRecord escherBlipRecord2 = this.field_12_blipRecord;
        return i7 + (escherBlipRecord2 != null ? escherBlipRecord2.getRecordSize() : 0);
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i, getRecordId(), this);
        if (this._remainingData == null) {
            this._remainingData = new byte[0];
        }
        LittleEndian.putShort(bArr, i, getOptions());
        LittleEndian.putShort(bArr, i + 2, getRecordId());
        EscherBlipRecord escherBlipRecord = this.field_12_blipRecord;
        LittleEndian.putInt(bArr, i + 4, this._remainingData.length + 36 + (escherBlipRecord == null ? 0 : escherBlipRecord.getRecordSize()));
        int i2 = i + 8;
        bArr[i2] = this.field_1_blipTypeWin32;
        bArr[i + 9] = this.field_2_blipTypeMacOS;
        System.arraycopy(this.field_3_uid, 0, bArr, i + 10, 16);
        LittleEndian.putShort(bArr, i + 26, this.field_4_tag);
        LittleEndian.putInt(bArr, i + 28, this.field_5_size);
        LittleEndian.putInt(bArr, i + 32, this.field_6_ref);
        LittleEndian.putInt(bArr, i + 36, this.field_7_offset);
        bArr[i + 40] = this.field_8_usage;
        bArr[i + 41] = this.field_9_name;
        bArr[i + 42] = this.field_10_unused2;
        bArr[i + 43] = this.field_11_unused3;
        EscherBlipRecord escherBlipRecord2 = this.field_12_blipRecord;
        int iSerialize = escherBlipRecord2 != null ? escherBlipRecord2.serialize(i + 44, bArr, new NullEscherSerializationListener()) : 0;
        byte[] bArr2 = this._remainingData;
        System.arraycopy(bArr2, 0, bArr, i + 44 + iSerialize, bArr2.length);
        int length = i2 + 36 + this._remainingData.length + iSerialize;
        int i3 = length - i;
        escherSerializationListener.afterRecordSerialize(length, getRecordId(), i3, this);
        return i3;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        EscherBlipRecord escherBlipRecord = this.field_12_blipRecord;
        int recordSize = escherBlipRecord != null ? escherBlipRecord.getRecordSize() : 0;
        byte[] bArr = this._remainingData;
        return recordSize + 44 + (bArr != null ? bArr.length : 0);
    }

    public byte getBlipTypeWin32() {
        return this.field_1_blipTypeWin32;
    }

    public void setBlipTypeWin32(byte b) {
        this.field_1_blipTypeWin32 = b;
    }

    public byte getBlipTypeMacOS() {
        return this.field_2_blipTypeMacOS;
    }

    public void setBlipTypeMacOS(byte b) {
        this.field_2_blipTypeMacOS = b;
    }

    public byte[] getUid() {
        return this.field_3_uid;
    }

    public void setUid(byte[] bArr) {
        if (bArr == null || bArr.length != 16) {
            throw new IllegalArgumentException("uid must be byte[16]");
        }
        byte[] bArr2 = this.field_3_uid;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
    }

    public short getTag() {
        return this.field_4_tag;
    }

    public void setTag(short s) {
        this.field_4_tag = s;
    }

    public int getSize() {
        return this.field_5_size;
    }

    public void setSize(int i) {
        this.field_5_size = i;
    }

    public int getRef() {
        return this.field_6_ref;
    }

    public void setRef(int i) {
        this.field_6_ref = i;
    }

    public int getOffset() {
        return this.field_7_offset;
    }

    public void setOffset(int i) {
        this.field_7_offset = i;
    }

    public byte getUsage() {
        return this.field_8_usage;
    }

    public void setUsage(byte b) {
        this.field_8_usage = b;
    }

    public byte getName() {
        return this.field_9_name;
    }

    public void setName(byte b) {
        this.field_9_name = b;
    }

    public byte getUnused2() {
        return this.field_10_unused2;
    }

    public void setUnused2(byte b) {
        this.field_10_unused2 = b;
    }

    public byte getUnused3() {
        return this.field_11_unused3;
    }

    public void setUnused3(byte b) {
        this.field_11_unused3 = b;
    }

    public EscherBlipRecord getBlipRecord() {
        return this.field_12_blipRecord;
    }

    public void setBlipRecord(EscherBlipRecord escherBlipRecord) {
        this.field_12_blipRecord = escherBlipRecord;
    }

    public byte[] getRemainingData() {
        return this._remainingData;
    }

    public void setRemainingData(byte[] bArr) {
        this._remainingData = bArr == null ? new byte[0] : (byte[]) bArr.clone();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    protected Object[][] getAttributeMap() {
        return new Object[][]{new Object[]{"BlipTypeWin32", Byte.valueOf(this.field_1_blipTypeWin32)}, new Object[]{"BlipTypeMacOS", Byte.valueOf(this.field_2_blipTypeMacOS)}, new Object[]{"SUID", this.field_3_uid}, new Object[]{"Tag", Short.valueOf(this.field_4_tag)}, new Object[]{"Size", Integer.valueOf(this.field_5_size)}, new Object[]{"Ref", Integer.valueOf(this.field_6_ref)}, new Object[]{"Offset", Integer.valueOf(this.field_7_offset)}, new Object[]{"Usage", Byte.valueOf(this.field_8_usage)}, new Object[]{"Name", Byte.valueOf(this.field_9_name)}, new Object[]{"Unused2", Byte.valueOf(this.field_10_unused2)}, new Object[]{"Unused3", Byte.valueOf(this.field_11_unused3)}, new Object[]{"Blip Record", this.field_12_blipRecord}, new Object[]{"Extra Data", this._remainingData}};
    }
}
