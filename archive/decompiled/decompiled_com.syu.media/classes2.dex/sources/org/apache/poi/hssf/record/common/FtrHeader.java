package org.apache.poi.hssf.record.common;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class FtrHeader implements Cloneable {
    private CellRangeAddress associatedRange;
    private short grbitFrt;
    private short recordType;

    public static int getDataSize() {
        return 12;
    }

    public FtrHeader() {
        this.associatedRange = new CellRangeAddress(0, 0, 0, 0);
    }

    public FtrHeader(RecordInputStream recordInputStream) {
        this.recordType = recordInputStream.readShort();
        this.grbitFrt = recordInputStream.readShort();
        this.associatedRange = new CellRangeAddress(recordInputStream);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(" [FUTURE HEADER]\n");
        stringBuffer.append("   Type " + ((int) this.recordType));
        stringBuffer.append("   Flags " + ((int) this.grbitFrt));
        stringBuffer.append(" [/FUTURE HEADER]\n");
        return stringBuffer.toString();
    }

    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.recordType);
        littleEndianOutput.writeShort(this.grbitFrt);
        this.associatedRange.serialize(littleEndianOutput);
    }

    public short getRecordType() {
        return this.recordType;
    }

    public void setRecordType(short s) {
        this.recordType = s;
    }

    public short getGrbitFrt() {
        return this.grbitFrt;
    }

    public void setGrbitFrt(short s) {
        this.grbitFrt = s;
    }

    public CellRangeAddress getAssociatedRange() {
        return this.associatedRange;
    }

    public void setAssociatedRange(CellRangeAddress cellRangeAddress) {
        this.associatedRange = cellRangeAddress;
    }

    public Object clone() {
        FtrHeader ftrHeader = new FtrHeader();
        ftrHeader.recordType = this.recordType;
        ftrHeader.grbitFrt = this.grbitFrt;
        ftrHeader.associatedRange = this.associatedRange.copy();
        return ftrHeader;
    }
}
