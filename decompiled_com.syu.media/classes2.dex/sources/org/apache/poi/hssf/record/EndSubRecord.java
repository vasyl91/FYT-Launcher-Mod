package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class EndSubRecord extends SubRecord implements Cloneable {
    private static final int ENCODED_SIZE = 0;
    public static final short sid = 0;

    @Override // org.apache.poi.hssf.record.SubRecord
    protected int getDataSize() {
        return 0;
    }

    public short getSid() {
        return (short) 0;
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public boolean isTerminating() {
        return true;
    }

    public String toString() {
        return "[ftEnd]\n[/ftEnd]\n";
    }

    public EndSubRecord() {
    }

    public EndSubRecord(LittleEndianInput littleEndianInput, int i) {
        if ((i & 255) != 0) {
            throw new RecordFormatException("Unexpected size (" + i + ")");
        }
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(0);
        littleEndianOutput.writeShort(0);
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    /* JADX INFO: renamed from: clone */
    public EndSubRecord mo1560clone() {
        return new EndSubRecord();
    }
}
