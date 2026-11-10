package org.apache.poi.hssf.util;

import org.apache.poi.ss.util.CellRangeAddressBase;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class CellRangeAddress8Bit extends CellRangeAddressBase {
    public static final int ENCODED_SIZE = 6;

    public static int getEncodedSize(int i) {
        return i * 6;
    }

    public CellRangeAddress8Bit(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
    }

    public CellRangeAddress8Bit(LittleEndianInput littleEndianInput) {
        super(readUShortAndCheck(littleEndianInput), littleEndianInput.readUShort(), littleEndianInput.readUByte(), littleEndianInput.readUByte());
    }

    private static int readUShortAndCheck(LittleEndianInput littleEndianInput) {
        if (littleEndianInput.available() < 6) {
            throw new RuntimeException("Ran out of data reading CellRangeAddress");
        }
        return littleEndianInput.readUShort();
    }

    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getFirstRow());
        littleEndianOutput.writeShort(getLastRow());
        littleEndianOutput.writeByte(getFirstColumn());
        littleEndianOutput.writeByte(getLastColumn());
    }

    public CellRangeAddress8Bit copy() {
        return new CellRangeAddress8Bit(getFirstRow(), getLastRow(), getFirstColumn(), getLastColumn());
    }
}
