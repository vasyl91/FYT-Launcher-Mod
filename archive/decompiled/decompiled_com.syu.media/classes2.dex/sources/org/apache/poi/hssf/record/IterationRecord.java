package org.apache.poi.hssf.record;

import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class IterationRecord extends StandardRecord implements Cloneable {
    private static final BitField iterationOn = BitFieldFactory.getInstance(1);
    public static final short sid = 17;
    private int _flags;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 17;
    }

    public IterationRecord(boolean z) {
        this._flags = iterationOn.setBoolean(0, z);
    }

    public IterationRecord(RecordInputStream recordInputStream) {
        this._flags = recordInputStream.readShort();
    }

    public void setIteration(boolean z) {
        this._flags = iterationOn.setBoolean(this._flags, z);
    }

    public boolean getIteration() {
        return iterationOn.isSet(this._flags);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[ITERATION]\n    .flags      = ");
        stringBuffer.append(HexDump.shortToHex(this._flags)).append("\n[/ITERATION]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this._flags);
    }

    @Override // org.apache.poi.hssf.record.Record
    public IterationRecord clone() {
        return new IterationRecord(getIteration());
    }
}
