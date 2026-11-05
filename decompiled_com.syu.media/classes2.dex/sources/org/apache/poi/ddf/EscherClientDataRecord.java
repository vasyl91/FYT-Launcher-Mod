package org.apache.poi.ddf;

import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class EscherClientDataRecord extends EscherRecord {
    public static final String RECORD_DESCRIPTION = "MsofbtClientData";
    public static final short RECORD_ID = -4079;
    private byte[] remainingData;

    @Override // org.apache.poi.ddf.EscherRecord
    public short getRecordId() {
        return RECORD_ID;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return "ClientData";
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i, EscherRecordFactory escherRecordFactory) {
        int header = readHeader(bArr, i);
        byte[] bArr2 = new byte[header];
        this.remainingData = bArr2;
        System.arraycopy(bArr, i + 8, bArr2, 0, header);
        return header + 8;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i, getRecordId(), this);
        if (this.remainingData == null) {
            this.remainingData = new byte[0];
        }
        LittleEndian.putShort(bArr, i, getOptions());
        LittleEndian.putShort(bArr, i + 2, getRecordId());
        LittleEndian.putInt(bArr, i + 4, this.remainingData.length);
        byte[] bArr2 = this.remainingData;
        int i2 = i + 8;
        System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
        int length = i2 + this.remainingData.length;
        int i3 = length - i;
        escherSerializationListener.afterRecordSerialize(length, getRecordId(), i3, this);
        return i3;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        byte[] bArr = this.remainingData;
        return (bArr == null ? 0 : bArr.length) + 8;
    }

    public byte[] getRemainingData() {
        return this.remainingData;
    }

    public void setRemainingData(byte[] bArr) {
        this.remainingData = bArr == null ? new byte[0] : (byte[]) bArr.clone();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    protected Object[][] getAttributeMap() {
        return new Object[][]{new Object[]{"Extra Data", getRemainingData()}};
    }
}
