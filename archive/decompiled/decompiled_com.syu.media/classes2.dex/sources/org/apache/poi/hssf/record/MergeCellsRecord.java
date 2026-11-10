package org.apache.poi.hssf.record;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class MergeCellsRecord extends StandardRecord implements Cloneable {
    public static final short sid = 229;
    private final int _numberOfRegions;
    private final CellRangeAddress[] _regions;
    private final int _startIndex;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public MergeCellsRecord(CellRangeAddress[] cellRangeAddressArr, int i, int i2) {
        this._regions = cellRangeAddressArr;
        this._startIndex = i;
        this._numberOfRegions = i2;
    }

    public MergeCellsRecord(RecordInputStream recordInputStream) {
        int uShort = recordInputStream.readUShort();
        CellRangeAddress[] cellRangeAddressArr = new CellRangeAddress[uShort];
        for (int i = 0; i < uShort; i++) {
            cellRangeAddressArr[i] = new CellRangeAddress(recordInputStream);
        }
        this._numberOfRegions = uShort;
        this._startIndex = 0;
        this._regions = cellRangeAddressArr;
    }

    public short getNumAreas() {
        return (short) this._numberOfRegions;
    }

    public CellRangeAddress getAreaAt(int i) {
        return this._regions[this._startIndex + i];
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return CellRangeAddressList.getEncodedSize(this._numberOfRegions);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this._numberOfRegions);
        for (int i = 0; i < this._numberOfRegions; i++) {
            this._regions[this._startIndex + i].serialize(littleEndianOutput);
        }
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[MERGEDCELLS]\n     .numregions =");
        stringBuffer.append((int) getNumAreas()).append("\n");
        for (int i = 0; i < this._numberOfRegions; i++) {
            CellRangeAddress cellRangeAddress = this._regions[this._startIndex + i];
            stringBuffer.append("     .rowfrom =").append(cellRangeAddress.getFirstRow()).append("\n     .rowto   =");
            stringBuffer.append(cellRangeAddress.getLastRow()).append("\n     .colfrom =");
            stringBuffer.append(cellRangeAddress.getFirstColumn()).append("\n     .colto   =");
            stringBuffer.append(cellRangeAddress.getLastColumn()).append("\n");
        }
        stringBuffer.append("[MERGEDCELLS]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.Record
    public MergeCellsRecord clone() {
        int i = this._numberOfRegions;
        CellRangeAddress[] cellRangeAddressArr = new CellRangeAddress[i];
        for (int i2 = 0; i2 < i; i2++) {
            cellRangeAddressArr[i2] = this._regions[this._startIndex + i2].copy();
        }
        return new MergeCellsRecord(cellRangeAddressArr, 0, i);
    }
}
