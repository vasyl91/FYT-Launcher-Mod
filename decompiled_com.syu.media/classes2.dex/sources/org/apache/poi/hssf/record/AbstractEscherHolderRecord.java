package org.apache.poi.hssf.record;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ddf.DefaultEscherRecordFactory;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherRecordFactory;
import org.apache.poi.ddf.NullEscherSerializationListener;
import org.apache.poi.hssf.util.LazilyConcatenatedByteArray;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class AbstractEscherHolderRecord extends Record implements Cloneable {
    private static boolean DESERIALISE;
    private final List<EscherRecord> escherRecords;
    private final LazilyConcatenatedByteArray rawDataContainer;

    protected abstract String getRecordName();

    @Override // org.apache.poi.hssf.record.Record
    public abstract short getSid();

    static {
        try {
            DESERIALISE = System.getProperty("poi.deserialize.escher") != null;
        } catch (SecurityException unused) {
            DESERIALISE = false;
        }
    }

    public AbstractEscherHolderRecord() {
        this.rawDataContainer = new LazilyConcatenatedByteArray();
        this.escherRecords = new ArrayList();
    }

    public AbstractEscherHolderRecord(RecordInputStream recordInputStream) {
        LazilyConcatenatedByteArray lazilyConcatenatedByteArray = new LazilyConcatenatedByteArray();
        this.rawDataContainer = lazilyConcatenatedByteArray;
        this.escherRecords = new ArrayList();
        if (!DESERIALISE) {
            lazilyConcatenatedByteArray.concatenate(recordInputStream.readRemainder());
        } else {
            byte[] allContinuedRemainder = recordInputStream.readAllContinuedRemainder();
            convertToEscherRecords(0, allContinuedRemainder.length, allContinuedRemainder);
        }
    }

    protected void convertRawBytesToEscherRecords() {
        if (DESERIALISE) {
            return;
        }
        byte[] rawData = getRawData();
        convertToEscherRecords(0, rawData.length, rawData);
    }

    private void convertToEscherRecords(int i, int i2, byte[] bArr) {
        this.escherRecords.clear();
        EscherRecordFactory defaultEscherRecordFactory = new DefaultEscherRecordFactory();
        int i3 = i;
        while (i3 < i + i2) {
            EscherRecord escherRecordCreateRecord = defaultEscherRecordFactory.createRecord(bArr, i3);
            int iFillFields = escherRecordCreateRecord.fillFields(bArr, i3, defaultEscherRecordFactory);
            this.escherRecords.add(escherRecordCreateRecord);
            i3 += iFillFields;
        }
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String property = System.getProperty("line.separator");
        stringBuffer.append("[" + getRecordName() + ']' + property);
        if (this.escherRecords.size() == 0) {
            stringBuffer.append("No Escher Records Decoded" + property);
        }
        Iterator<EscherRecord> it = this.escherRecords.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
        }
        stringBuffer.append("[/" + getRecordName() + ']' + property);
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public int serialize(int i, byte[] bArr) {
        int i2 = i + 0;
        LittleEndian.putShort(bArr, i2, getSid());
        int i3 = i + 2;
        LittleEndian.putShort(bArr, i3, (short) (getRecordSize() - 4));
        byte[] rawData = getRawData();
        if (this.escherRecords.size() == 0 && rawData != null) {
            LittleEndian.putShort(bArr, i2, getSid());
            LittleEndian.putShort(bArr, i3, (short) (getRecordSize() - 4));
            System.arraycopy(rawData, 0, bArr, i + 4, rawData.length);
            return rawData.length + 4;
        }
        LittleEndian.putShort(bArr, i2, getSid());
        LittleEndian.putShort(bArr, i3, (short) (getRecordSize() - 4));
        int iSerialize = i + 4;
        Iterator<EscherRecord> it = this.escherRecords.iterator();
        while (it.hasNext()) {
            iSerialize += it.next().serialize(iSerialize, bArr, new NullEscherSerializationListener());
        }
        return getRecordSize();
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public int getRecordSize() {
        byte[] rawData = getRawData();
        if (this.escherRecords.size() == 0 && rawData != null) {
            return rawData.length;
        }
        Iterator<EscherRecord> it = this.escherRecords.iterator();
        int recordSize = 0;
        while (it.hasNext()) {
            recordSize += it.next().getRecordSize();
        }
        return recordSize;
    }

    @Override // org.apache.poi.hssf.record.Record
    public AbstractEscherHolderRecord clone() {
        return (AbstractEscherHolderRecord) cloneViaReserialise();
    }

    public void addEscherRecord(int i, EscherRecord escherRecord) {
        this.escherRecords.add(i, escherRecord);
    }

    public boolean addEscherRecord(EscherRecord escherRecord) {
        return this.escherRecords.add(escherRecord);
    }

    public List<EscherRecord> getEscherRecords() {
        return this.escherRecords;
    }

    public void clearEscherRecords() {
        this.escherRecords.clear();
    }

    public EscherContainerRecord getEscherContainer() {
        for (EscherRecord escherRecord : this.escherRecords) {
            if (escherRecord instanceof EscherContainerRecord) {
                return (EscherContainerRecord) escherRecord;
            }
        }
        return null;
    }

    public EscherRecord findFirstWithId(short s) {
        return findFirstWithId(s, getEscherRecords());
    }

    private EscherRecord findFirstWithId(short s, List<EscherRecord> list) {
        EscherRecord escherRecordFindFirstWithId;
        for (EscherRecord escherRecord : list) {
            if (escherRecord.getRecordId() == s) {
                return escherRecord;
            }
        }
        for (EscherRecord escherRecord2 : list) {
            if (escherRecord2.isContainerRecord() && (escherRecordFindFirstWithId = findFirstWithId(s, escherRecord2.getChildRecords())) != null) {
                return escherRecordFindFirstWithId;
            }
        }
        return null;
    }

    public EscherRecord getEscherRecord(int i) {
        return this.escherRecords.get(i);
    }

    public void join(AbstractEscherHolderRecord abstractEscherHolderRecord) {
        this.rawDataContainer.concatenate(abstractEscherHolderRecord.getRawData());
    }

    public void processContinueRecord(byte[] bArr) {
        this.rawDataContainer.concatenate(bArr);
    }

    public byte[] getRawData() {
        return this.rawDataContainer.toArray();
    }

    public void setRawData(byte[] bArr) {
        this.rawDataContainer.clear();
        this.rawDataContainer.concatenate(bArr);
    }

    public void decode() {
        List<EscherRecord> list = this.escherRecords;
        if (list == null || list.size() == 0) {
            byte[] rawData = getRawData();
            convertToEscherRecords(0, rawData.length, rawData);
        }
    }
}
