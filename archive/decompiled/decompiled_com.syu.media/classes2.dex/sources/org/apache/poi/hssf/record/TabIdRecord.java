package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class TabIdRecord extends StandardRecord {
    private static final short[] EMPTY_SHORT_ARRAY = new short[0];
    public static final short sid = 317;
    public short[] _tabids;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 317;
    }

    public TabIdRecord() {
        this._tabids = EMPTY_SHORT_ARRAY;
    }

    public TabIdRecord(RecordInputStream recordInputStream) {
        this._tabids = new short[recordInputStream.remaining() / 2];
        int i = 0;
        while (true) {
            short[] sArr = this._tabids;
            if (i >= sArr.length) {
                return;
            }
            sArr[i] = recordInputStream.readShort();
            i++;
        }
    }

    public void setTabIdArray(short[] sArr) {
        this._tabids = (short[]) sArr.clone();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[TABID]\n    .elements        = ");
        stringBuffer.append(this._tabids.length).append("\n");
        for (int i = 0; i < this._tabids.length; i++) {
            stringBuffer.append("    .element_").append(i).append(" = ").append((int) this._tabids[i]).append("\n");
        }
        stringBuffer.append("[/TABID]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        for (short s : this._tabids) {
            littleEndianOutput.writeShort(s);
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return this._tabids.length * 2;
    }
}
