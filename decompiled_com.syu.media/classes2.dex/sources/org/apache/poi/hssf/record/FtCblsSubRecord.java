package org.apache.poi.hssf.record;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class FtCblsSubRecord extends SubRecord implements Cloneable {
    private static final int ENCODED_SIZE = 20;
    public static final short sid = 12;
    private byte[] reserved;

    public short getSid() {
        return (short) 12;
    }

    public FtCblsSubRecord() {
        this.reserved = new byte[20];
    }

    public FtCblsSubRecord(LittleEndianInput littleEndianInput, int i) {
        if (i != 20) {
            throw new RecordFormatException("Unexpected size (" + i + ")");
        }
        byte[] bArr = new byte[i];
        littleEndianInput.readFully(bArr);
        this.reserved = bArr;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[FtCbls ]\n  size     = ");
        stringBuffer.append(getDataSize()).append("\n  reserved = ");
        stringBuffer.append(HexDump.toHex(this.reserved)).append("\n[/FtCbls ]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(12);
        littleEndianOutput.writeShort(this.reserved.length);
        littleEndianOutput.write(this.reserved);
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    protected int getDataSize() {
        return this.reserved.length;
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    /* JADX INFO: renamed from: clone */
    public FtCblsSubRecord mo1560clone() {
        FtCblsSubRecord ftCblsSubRecord = new FtCblsSubRecord();
        byte[] bArr = this.reserved;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        ftCblsSubRecord.reserved = bArr2;
        return ftCblsSubRecord;
    }
}
