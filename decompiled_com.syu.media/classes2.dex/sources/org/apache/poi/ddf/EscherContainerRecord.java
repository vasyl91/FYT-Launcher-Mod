package org.apache.poi.ddf;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.Removal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class EscherContainerRecord extends EscherRecord implements Iterable<EscherRecord> {
    public static final short BSTORE_CONTAINER = -4095;
    public static final short DGG_CONTAINER = -4096;
    public static final short DG_CONTAINER = -4094;
    public static final short SOLVER_CONTAINER = -4091;
    public static final short SPGR_CONTAINER = -4093;
    public static final short SP_CONTAINER = -4092;
    private static final POILogger log = POILogFactory.getLogger((Class<?>) EscherContainerRecord.class);
    private final List<EscherRecord> _childRecords = new ArrayList();
    private int _remainingLength;

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i, EscherRecordFactory escherRecordFactory) {
        int header = readHeader(bArr, i);
        int i2 = 8;
        int i3 = i + 8;
        while (header > 0 && i3 < bArr.length) {
            EscherRecord escherRecordCreateRecord = escherRecordFactory.createRecord(bArr, i3);
            int iFillFields = escherRecordCreateRecord.fillFields(bArr, i3, escherRecordFactory);
            i2 += iFillFields;
            i3 += iFillFields;
            header -= iFillFields;
            addChildRecord(escherRecordCreateRecord);
            if (i3 >= bArr.length && header > 0) {
                this._remainingLength = header;
                POILogger pOILogger = log;
                if (pOILogger.check(5)) {
                    pOILogger.log(5, "Not enough Escher data: " + header + " bytes remaining but no space left");
                }
            }
        }
        return i2;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i, getRecordId(), this);
        LittleEndian.putShort(bArr, i, getOptions());
        LittleEndian.putShort(bArr, i + 2, getRecordId());
        Iterator<EscherRecord> it = iterator();
        int recordSize = 0;
        while (it.hasNext()) {
            recordSize += it.next().getRecordSize();
        }
        LittleEndian.putInt(bArr, i + 4, recordSize + this._remainingLength);
        int iSerialize = i + 8;
        Iterator<EscherRecord> it2 = iterator();
        while (it2.hasNext()) {
            iSerialize += it2.next().serialize(iSerialize, bArr, escherSerializationListener);
        }
        int i2 = iSerialize - i;
        escherSerializationListener.afterRecordSerialize(iSerialize, getRecordId(), i2, this);
        return i2;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        Iterator<EscherRecord> it = iterator();
        int recordSize = 0;
        while (it.hasNext()) {
            recordSize += it.next().getRecordSize();
        }
        return recordSize + 8;
    }

    public boolean hasChildOfType(short s) {
        Iterator<EscherRecord> it = iterator();
        while (it.hasNext()) {
            if (it.next().getRecordId() == s) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public EscherRecord getChild(int i) {
        return this._childRecords.get(i);
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public List<EscherRecord> getChildRecords() {
        return new ArrayList(this._childRecords);
    }

    @Removal(version = "3.18")
    @Deprecated
    public Iterator<EscherRecord> getChildIterator() {
        return iterator();
    }

    @Override // java.lang.Iterable
    public Iterator<EscherRecord> iterator() {
        return Collections.unmodifiableList(this._childRecords).iterator();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public void setChildRecords(List<EscherRecord> list) {
        List<EscherRecord> list2 = this._childRecords;
        if (list == list2) {
            throw new IllegalStateException("Child records private data member has escaped");
        }
        list2.clear();
        this._childRecords.addAll(list);
    }

    public boolean removeChildRecord(EscherRecord escherRecord) {
        return this._childRecords.remove(escherRecord);
    }

    public List<EscherContainerRecord> getChildContainers() {
        ArrayList arrayList = new ArrayList();
        for (EscherRecord escherRecord : this) {
            if (escherRecord instanceof EscherContainerRecord) {
                arrayList.add((EscherContainerRecord) escherRecord);
            }
        }
        return arrayList;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        switch (getRecordId()) {
            case -4096:
                return "DggContainer";
            case -4095:
                return "BStoreContainer";
            case -4094:
                return "DgContainer";
            case -4093:
                return "SpgrContainer";
            case -4092:
                return "SpContainer";
            case -4091:
                return "SolverContainer";
            default:
                return "Container 0x" + HexDump.toHex(getRecordId());
        }
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public void display(PrintWriter printWriter, int i) {
        super.display(printWriter, i);
        Iterator<EscherRecord> it = iterator();
        while (it.hasNext()) {
            it.next().display(printWriter, i + 1);
        }
    }

    public void addChildRecord(EscherRecord escherRecord) {
        this._childRecords.add(escherRecord);
    }

    public void addChildBefore(EscherRecord escherRecord, int i) {
        Iterator<EscherRecord> it = iterator();
        int i2 = 0;
        while (it.hasNext() && it.next().getRecordId() != ((short) i)) {
            i2++;
        }
        this._childRecords.add(i2, escherRecord);
    }

    public <T extends EscherRecord> T getChildById(short s) {
        Iterator<EscherRecord> it = iterator();
        while (it.hasNext()) {
            T t = (T) it.next();
            if (t.getRecordId() == s) {
                return t;
            }
        }
        return null;
    }

    public void getRecordsById(short s, List<EscherRecord> list) {
        for (EscherRecord escherRecord : this) {
            if (escherRecord instanceof EscherContainerRecord) {
                ((EscherContainerRecord) escherRecord).getRecordsById(s, list);
            } else if (escherRecord.getRecordId() == s) {
                list.add(escherRecord);
            }
        }
    }

    @Override // org.apache.poi.ddf.EscherRecord
    protected Object[][] getAttributeMap() {
        ArrayList arrayList = new ArrayList((this._childRecords.size() * 2) + 2);
        arrayList.add("children");
        arrayList.add(Integer.valueOf(this._childRecords.size()));
        int i = 0;
        for (EscherRecord escherRecord : this) {
            arrayList.add("Child " + i);
            arrayList.add(escherRecord);
            i++;
        }
        return new Object[][]{new Object[]{"isContainer", Boolean.valueOf(isContainerRecord())}, arrayList.toArray()};
    }
}
