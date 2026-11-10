package org.apache.poi.hssf.record;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.LittleEndianInputStream;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ObjRecord extends Record implements Cloneable {
    private static int MAX_PAD_ALIGNMENT = 4;
    private static final int NORMAL_PAD_ALIGNMENT = 2;
    public static final short sid = 93;
    private boolean _isPaddedToQuadByteMultiple;
    private final byte[] _uninterpretedData;
    private List<SubRecord> subrecords;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 93;
    }

    public ObjRecord() {
        this.subrecords = new ArrayList(2);
        this._uninterpretedData = null;
    }

    public ObjRecord(RecordInputStream recordInputStream) {
        SubRecord subRecordCreateSubRecord;
        byte[] remainder = recordInputStream.readRemainder();
        if (LittleEndian.getUShort(remainder, 0) != 21) {
            this._uninterpretedData = remainder;
            this.subrecords = null;
            return;
        }
        this.subrecords = new ArrayList();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(remainder);
        LittleEndianInputStream littleEndianInputStream = new LittleEndianInputStream(byteArrayInputStream);
        CommonObjectDataSubRecord commonObjectDataSubRecord = (CommonObjectDataSubRecord) SubRecord.createSubRecord(littleEndianInputStream, 0);
        this.subrecords.add(commonObjectDataSubRecord);
        do {
            subRecordCreateSubRecord = SubRecord.createSubRecord(littleEndianInputStream, commonObjectDataSubRecord.getObjectType());
            this.subrecords.add(subRecordCreateSubRecord);
        } while (!subRecordCreateSubRecord.isTerminating());
        int iAvailable = byteArrayInputStream.available();
        if (iAvailable > 0) {
            int length = remainder.length;
            int i = MAX_PAD_ALIGNMENT;
            boolean z = length % i == 0;
            this._isPaddedToQuadByteMultiple = z;
            if (iAvailable >= (z ? i : 2)) {
                if (!canPaddingBeDiscarded(remainder, iAvailable)) {
                    throw new RecordFormatException("Leftover " + iAvailable + " bytes in subrecord data " + HexDump.toHex(remainder));
                }
                this._isPaddedToQuadByteMultiple = false;
            }
        } else {
            this._isPaddedToQuadByteMultiple = false;
        }
        this._uninterpretedData = null;
    }

    private static boolean canPaddingBeDiscarded(byte[] bArr, int i) {
        for (int length = bArr.length - i; length < bArr.length; length++) {
            if (bArr[length] != 0) {
                return false;
            }
        }
        return true;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[OBJ]\n");
        List<SubRecord> list = this.subrecords;
        if (list != null) {
            Iterator<SubRecord> it = list.iterator();
            while (it.hasNext()) {
                stringBuffer.append("SUBRECORD: ").append(it.next());
            }
        }
        stringBuffer.append("[/OBJ]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public int getRecordSize() {
        byte[] bArr = this._uninterpretedData;
        if (bArr != null) {
            return bArr.length + 4;
        }
        Iterator<SubRecord> it = this.subrecords.iterator();
        int dataSize = 0;
        while (it.hasNext()) {
            dataSize += it.next().getDataSize() + 4;
        }
        if (this._isPaddedToQuadByteMultiple) {
            while (dataSize % MAX_PAD_ALIGNMENT != 0) {
                dataSize++;
            }
        } else {
            while (dataSize % 2 != 0) {
                dataSize++;
            }
        }
        return dataSize + 4;
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public int serialize(int i, byte[] bArr) {
        int recordSize = getRecordSize();
        int i2 = recordSize - 4;
        LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream = new LittleEndianByteArrayOutputStream(bArr, i, recordSize);
        littleEndianByteArrayOutputStream.writeShort(93);
        littleEndianByteArrayOutputStream.writeShort(i2);
        byte[] bArr2 = this._uninterpretedData;
        if (bArr2 == null) {
            for (int i3 = 0; i3 < this.subrecords.size(); i3++) {
                this.subrecords.get(i3).serialize(littleEndianByteArrayOutputStream);
            }
            int i4 = i + i2;
            while (littleEndianByteArrayOutputStream.getWriteIndex() < i4) {
                littleEndianByteArrayOutputStream.writeByte(0);
            }
        } else {
            littleEndianByteArrayOutputStream.write(bArr2);
        }
        return recordSize;
    }

    public List<SubRecord> getSubRecords() {
        return this.subrecords;
    }

    public void clearSubRecords() {
        this.subrecords.clear();
    }

    public void addSubRecord(int i, SubRecord subRecord) {
        this.subrecords.add(i, subRecord);
    }

    public boolean addSubRecord(SubRecord subRecord) {
        return this.subrecords.add(subRecord);
    }

    @Override // org.apache.poi.hssf.record.Record
    public ObjRecord clone() {
        ObjRecord objRecord = new ObjRecord();
        Iterator<SubRecord> it = this.subrecords.iterator();
        while (it.hasNext()) {
            objRecord.addSubRecord(it.next().mo1560clone());
        }
        return objRecord;
    }
}
