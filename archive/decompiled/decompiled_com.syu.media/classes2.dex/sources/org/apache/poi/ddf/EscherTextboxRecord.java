package org.apache.poi.ddf;

import java.util.ArrayList;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class EscherTextboxRecord extends EscherRecord implements Cloneable {
    private static final byte[] NO_BYTES = new byte[0];
    public static final String RECORD_DESCRIPTION = "msofbtClientTextbox";
    public static final short RECORD_ID = -4083;
    private byte[] thedata = NO_BYTES;

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return "ClientTextbox";
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i, EscherRecordFactory escherRecordFactory) {
        int header = readHeader(bArr, i);
        byte[] bArr2 = new byte[header];
        this.thedata = bArr2;
        System.arraycopy(bArr, i + 8, bArr2, 0, header);
        return header + 8;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i, getRecordId(), this);
        LittleEndian.putShort(bArr, i, getOptions());
        LittleEndian.putShort(bArr, i + 2, getRecordId());
        LittleEndian.putInt(bArr, i + 4, this.thedata.length);
        byte[] bArr2 = this.thedata;
        int i2 = i + 8;
        System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
        int length = i2 + this.thedata.length;
        int i3 = length - i;
        escherSerializationListener.afterRecordSerialize(length, getRecordId(), i3, this);
        if (i3 == getRecordSize()) {
            return i3;
        }
        throw new RecordFormatException(i3 + " bytes written but getRecordSize() reports " + getRecordSize());
    }

    public byte[] getData() {
        return this.thedata;
    }

    public void setData(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        this.thedata = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
    }

    public void setData(byte[] bArr) {
        setData(bArr, 0, bArr.length);
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return this.thedata.length + 8;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public EscherTextboxRecord clone() {
        EscherTextboxRecord escherTextboxRecord = new EscherTextboxRecord();
        escherTextboxRecord.setOptions(getOptions());
        escherTextboxRecord.setRecordId(getRecordId());
        escherTextboxRecord.thedata = (byte[]) this.thedata.clone();
        return escherTextboxRecord;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    protected Object[][] getAttributeMap() {
        int size = getChildRecords().size();
        ArrayList arrayList = new ArrayList((size * 2) + 2);
        arrayList.add("children");
        arrayList.add(Integer.valueOf(size));
        for (EscherRecord escherRecord : getChildRecords()) {
            arrayList.add(escherRecord.getRecordName());
            arrayList.add(escherRecord);
        }
        return new Object[][]{new Object[]{"isContainer", Boolean.valueOf(isContainerRecord())}, arrayList.toArray(), new Object[]{"Extra Data", this.thedata}};
    }
}
