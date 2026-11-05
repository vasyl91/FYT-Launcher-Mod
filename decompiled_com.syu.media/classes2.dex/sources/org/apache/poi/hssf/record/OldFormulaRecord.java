package org.apache.poi.hssf.record;

import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.CellType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class OldFormulaRecord extends OldCellRecord {
    public static final short biff2_sid = 6;
    public static final short biff3_sid = 518;
    public static final short biff4_sid = 1030;
    public static final short biff5_sid = 6;
    private double field_4_value;
    private short field_5_options;
    private Formula field_6_parsed_expr;
    private FormulaRecord.SpecialCachedValue specialCachedValue;

    @Override // org.apache.poi.hssf.record.OldCellRecord
    protected String getRecordName() {
        return "Old Formula";
    }

    public OldFormulaRecord(RecordInputStream recordInputStream) {
        super(recordInputStream, recordInputStream.getSid() == 6);
        if (isBiff2()) {
            this.field_4_value = recordInputStream.readDouble();
        } else {
            long j = recordInputStream.readLong();
            FormulaRecord.SpecialCachedValue specialCachedValueCreate = FormulaRecord.SpecialCachedValue.create(j);
            this.specialCachedValue = specialCachedValueCreate;
            if (specialCachedValueCreate == null) {
                this.field_4_value = Double.longBitsToDouble(j);
            }
        }
        if (isBiff2()) {
            this.field_5_options = (short) recordInputStream.readUByte();
        } else {
            this.field_5_options = recordInputStream.readShort();
        }
        this.field_6_parsed_expr = Formula.read(recordInputStream.readShort(), recordInputStream, recordInputStream.available());
    }

    public int getCachedResultType() {
        FormulaRecord.SpecialCachedValue specialCachedValue = this.specialCachedValue;
        if (specialCachedValue == null) {
            return CellType.NUMERIC.getCode();
        }
        return specialCachedValue.getValueType();
    }

    public boolean getCachedBooleanValue() {
        return this.specialCachedValue.getBooleanValue();
    }

    public int getCachedErrorValue() {
        return this.specialCachedValue.getErrorValue();
    }

    public double getValue() {
        return this.field_4_value;
    }

    public short getOptions() {
        return this.field_5_options;
    }

    public Ptg[] getParsedExpression() {
        return this.field_6_parsed_expr.getTokens();
    }

    public Formula getFormula() {
        return this.field_6_parsed_expr;
    }

    @Override // org.apache.poi.hssf.record.OldCellRecord
    protected void appendValueText(StringBuilder sb) {
        sb.append("    .value       = ").append(getValue()).append("\n");
    }
}
