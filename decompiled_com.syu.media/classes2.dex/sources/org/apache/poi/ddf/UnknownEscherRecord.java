package org.apache.poi.ddf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class UnknownEscherRecord extends EscherRecord implements Cloneable {
    private static final byte[] NO_BYTES = new byte[0];
    private byte[] thedata = NO_BYTES;
    private List<EscherRecord> _childRecords = new ArrayList();

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i, EscherRecordFactory escherRecordFactory) {
        int header = readHeader(bArr, i);
        int i2 = 8;
        int i3 = i + 8;
        int length = bArr.length - i3;
        if (header > length) {
            header = length;
        }
        if (isContainerRecord()) {
            this.thedata = new byte[0];
            while (header > 0) {
                EscherRecord escherRecordCreateRecord = escherRecordFactory.createRecord(bArr, i3);
                int iFillFields = escherRecordCreateRecord.fillFields(bArr, i3, escherRecordFactory);
                i2 += iFillFields;
                i3 += iFillFields;
                header -= iFillFields;
                getChildRecords().add(escherRecordCreateRecord);
            }
            return i2;
        }
        if (header < 0) {
            header = 0;
        }
        byte[] bArr2 = new byte[header];
        this.thedata = bArr2;
        System.arraycopy(bArr, i3, bArr2, 0, header);
        return header + 8;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i, getRecordId(), this);
        LittleEndian.putShort(bArr, i, getOptions());
        LittleEndian.putShort(bArr, i + 2, getRecordId());
        int length = this.thedata.length;
        Iterator<EscherRecord> it = this._childRecords.iterator();
        while (it.hasNext()) {
            length += it.next().getRecordSize();
        }
        LittleEndian.putInt(bArr, i + 4, length);
        byte[] bArr2 = this.thedata;
        int i2 = i + 8;
        System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
        int length2 = i2 + this.thedata.length;
        Iterator<EscherRecord> it2 = this._childRecords.iterator();
        while (it2.hasNext()) {
            length2 += it2.next().serialize(length2, bArr, escherSerializationListener);
        }
        int i3 = length2 - i;
        escherSerializationListener.afterRecordSerialize(length2, getRecordId(), i3, this);
        return i3;
    }

    public byte[] getData() {
        return this.thedata;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return this.thedata.length + 8;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public List<EscherRecord> getChildRecords() {
        return this._childRecords;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public void setChildRecords(List<EscherRecord> list) {
        this._childRecords = list;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public UnknownEscherRecord clone() {
        UnknownEscherRecord unknownEscherRecord = new UnknownEscherRecord();
        unknownEscherRecord.thedata = (byte[]) this.thedata.clone();
        unknownEscherRecord.setOptions(getOptions());
        unknownEscherRecord.setRecordId(getRecordId());
        return unknownEscherRecord;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return "Unknown 0x" + HexDump.toHex(getRecordId());
    }

    public void addChildRecord(EscherRecord escherRecord) {
        getChildRecords().add(escherRecord);
    }

    @Override // org.apache.poi.ddf.EscherRecord
    protected Object[][] getAttributeMap() {
        int size = getChildRecords().size();
        ArrayList arrayList = new ArrayList((size * 2) + 2);
        arrayList.add("children");
        arrayList.add(Integer.valueOf(size));
        for (EscherRecord escherRecord : this._childRecords) {
            arrayList.add(escherRecord.getRecordName());
            arrayList.add(escherRecord);
        }
        return new Object[][]{new Object[]{"isContainer", Boolean.valueOf(isContainerRecord())}, arrayList.toArray(), new Object[]{"Extra Data", this.thedata}};
    }
}
