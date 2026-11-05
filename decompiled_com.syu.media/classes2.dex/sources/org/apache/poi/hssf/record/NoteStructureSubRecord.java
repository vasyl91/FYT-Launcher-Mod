package org.apache.poi.hssf.record;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class NoteStructureSubRecord extends SubRecord implements Cloneable {
    private static final int ENCODED_SIZE = 22;
    public static final short sid = 13;
    private byte[] reserved;

    public short getSid() {
        return (short) 13;
    }

    public NoteStructureSubRecord() {
        this.reserved = new byte[22];
    }

    public NoteStructureSubRecord(LittleEndianInput littleEndianInput, int i) {
        if (i != 22) {
            throw new RecordFormatException("Unexpected size (" + i + ")");
        }
        byte[] bArr = new byte[i];
        littleEndianInput.readFully(bArr);
        this.reserved = bArr;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[ftNts ]\n  size     = ");
        stringBuffer.append(getDataSize()).append("\n  reserved = ");
        stringBuffer.append(HexDump.toHex(this.reserved)).append("\n[/ftNts ]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(13);
        littleEndianOutput.writeShort(this.reserved.length);
        littleEndianOutput.write(this.reserved);
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    protected int getDataSize() {
        return this.reserved.length;
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    /* JADX INFO: renamed from: clone */
    public NoteStructureSubRecord mo1560clone() {
        NoteStructureSubRecord noteStructureSubRecord = new NoteStructureSubRecord();
        byte[] bArr = this.reserved;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        noteStructureSubRecord.reserved = bArr2;
        return noteStructureSubRecord;
    }
}
