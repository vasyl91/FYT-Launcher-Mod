package org.apache.poi.hssf.record;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class CellRecord extends StandardRecord implements CellValueRecordInterface {
    private int _columnIndex;
    private int _formatIndex;
    private int _rowIndex;

    protected abstract void appendValueText(StringBuilder sb);

    protected abstract String getRecordName();

    protected abstract int getValueDataSize();

    protected abstract void serializeValue(LittleEndianOutput littleEndianOutput);

    protected CellRecord() {
    }

    protected CellRecord(RecordInputStream recordInputStream) {
        this._rowIndex = recordInputStream.readUShort();
        this._columnIndex = recordInputStream.readUShort();
        this._formatIndex = recordInputStream.readUShort();
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public final void setRow(int i) {
        this._rowIndex = i;
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public final void setColumn(short s) {
        this._columnIndex = s;
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public final void setXFIndex(short s) {
        this._formatIndex = s;
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public final int getRow() {
        return this._rowIndex;
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public final short getColumn() {
        return (short) this._columnIndex;
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public final short getXFIndex() {
        return (short) this._formatIndex;
    }

    @Override // org.apache.poi.hssf.record.Record
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        String recordName = getRecordName();
        sb.append("[").append(recordName).append("]\n    .row    = ");
        sb.append(HexDump.shortToHex(getRow())).append("\n    .col    = ");
        sb.append(HexDump.shortToHex(getColumn())).append("\n    .xfindex= ");
        sb.append(HexDump.shortToHex(getXFIndex())).append("\n");
        appendValueText(sb);
        sb.append("\n");
        sb.append("[/").append(recordName).append("]\n");
        return sb.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public final void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getRow());
        littleEndianOutput.writeShort(getColumn());
        littleEndianOutput.writeShort(getXFIndex());
        serializeValue(littleEndianOutput);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected final int getDataSize() {
        return getValueDataSize() + 6;
    }

    protected final void copyBaseFields(CellRecord cellRecord) {
        cellRecord._rowIndex = this._rowIndex;
        cellRecord._columnIndex = this._columnIndex;
        cellRecord._formatIndex = this._formatIndex;
    }
}
