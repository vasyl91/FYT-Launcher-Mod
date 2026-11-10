package org.apache.poi.hssf.record;

import org.apache.poi.hssf.util.CellRangeAddress8Bit;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class SharedValueRecordBase extends StandardRecord {
    private CellRangeAddress8Bit _range;

    protected abstract int getExtraDataSize();

    protected abstract void serializeExtraData(LittleEndianOutput littleEndianOutput);

    protected SharedValueRecordBase(CellRangeAddress8Bit cellRangeAddress8Bit) {
        if (cellRangeAddress8Bit == null) {
            throw new IllegalArgumentException("range must be supplied.");
        }
        this._range = cellRangeAddress8Bit;
    }

    protected SharedValueRecordBase() {
        this(new CellRangeAddress8Bit(0, 0, 0, 0));
    }

    public SharedValueRecordBase(LittleEndianInput littleEndianInput) {
        this._range = new CellRangeAddress8Bit(littleEndianInput);
    }

    public final CellRangeAddress8Bit getRange() {
        return this._range;
    }

    public final int getFirstRow() {
        return this._range.getFirstRow();
    }

    public final int getLastRow() {
        return this._range.getLastRow();
    }

    public final int getFirstColumn() {
        return (short) this._range.getFirstColumn();
    }

    public final int getLastColumn() {
        return (short) this._range.getLastColumn();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return getExtraDataSize() + 6;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        this._range.serialize(littleEndianOutput);
        serializeExtraData(littleEndianOutput);
    }

    public final boolean isInRange(int i, int i2) {
        CellRangeAddress8Bit cellRangeAddress8Bit = this._range;
        return cellRangeAddress8Bit.getFirstRow() <= i && cellRangeAddress8Bit.getLastRow() >= i && cellRangeAddress8Bit.getFirstColumn() <= i2 && cellRangeAddress8Bit.getLastColumn() >= i2;
    }

    public final boolean isFirstCell(int i, int i2) {
        CellRangeAddress8Bit range = getRange();
        return range.getFirstRow() == i && range.getFirstColumn() == i2;
    }
}
