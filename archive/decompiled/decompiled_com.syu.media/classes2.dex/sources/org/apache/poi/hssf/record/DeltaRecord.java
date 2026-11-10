package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class DeltaRecord extends StandardRecord implements Cloneable {
    public static final double DEFAULT_VALUE = 0.001d;
    public static final short sid = 16;
    private double field_1_max_change;

    @Override // org.apache.poi.hssf.record.Record
    public DeltaRecord clone() {
        return this;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 8;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 16;
    }

    public DeltaRecord(double d) {
        this.field_1_max_change = d;
    }

    public DeltaRecord(RecordInputStream recordInputStream) {
        this.field_1_max_change = recordInputStream.readDouble();
    }

    public double getMaxChange() {
        return this.field_1_max_change;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[DELTA]\n    .maxchange = ");
        stringBuffer.append(getMaxChange()).append("\n[/DELTA]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeDouble(getMaxChange());
    }
}
