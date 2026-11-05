package org.apache.poi.hssf.record;

import org.apache.poi.hssf.util.CellRangeAddress8Bit;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ArrayRecord extends SharedValueRecordBase implements Cloneable {
    private static final int OPT_ALWAYS_RECALCULATE = 1;
    private static final int OPT_CALCULATE_ON_OPEN = 2;
    public static final short sid = 545;
    private int _field3notUsed;
    private Formula _formula;
    private int _options;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public ArrayRecord(RecordInputStream recordInputStream) {
        super(recordInputStream);
        this._options = recordInputStream.readUShort();
        this._field3notUsed = recordInputStream.readInt();
        this._formula = Formula.read(recordInputStream.readUShort(), recordInputStream, recordInputStream.available());
    }

    public ArrayRecord(Formula formula, CellRangeAddress8Bit cellRangeAddress8Bit) {
        super(cellRangeAddress8Bit);
        this._options = 0;
        this._field3notUsed = 0;
        this._formula = formula;
    }

    public boolean isAlwaysRecalculate() {
        return (this._options & 1) != 0;
    }

    public boolean isCalculateOnOpen() {
        return (this._options & 2) != 0;
    }

    public Ptg[] getFormulaTokens() {
        return this._formula.getTokens();
    }

    @Override // org.apache.poi.hssf.record.SharedValueRecordBase
    protected int getExtraDataSize() {
        return this._formula.getEncodedSize() + 6;
    }

    @Override // org.apache.poi.hssf.record.SharedValueRecordBase
    protected void serializeExtraData(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this._options);
        littleEndianOutput.writeInt(this._field3notUsed);
        this._formula.serialize(littleEndianOutput);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getClass().getName()).append(" [ARRAY]\n range=");
        stringBuffer.append(getRange()).append("\n options=");
        stringBuffer.append(HexDump.shortToHex(this._options)).append("\n notUsed=");
        stringBuffer.append(HexDump.intToHex(this._field3notUsed)).append("\n formula:\n");
        for (Ptg ptg : this._formula.getTokens()) {
            stringBuffer.append(ptg).append(ptg.getRVAType()).append("\n");
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.Record
    public ArrayRecord clone() {
        ArrayRecord arrayRecord = new ArrayRecord(this._formula.copy(), getRange());
        arrayRecord._options = this._options;
        arrayRecord._field3notUsed = this._field3notUsed;
        return arrayRecord;
    }
}
