package org.apache.poi.hssf.record;

import org.apache.poi.hpsf.Variant;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class FormulaRecord extends CellRecord implements Cloneable {
    private static int FIXED_SIZE = 14;
    private static final BitField alwaysCalc = BitFieldFactory.getInstance(1);
    private static final BitField calcOnLoad = BitFieldFactory.getInstance(2);
    private static final BitField sharedFormula = BitFieldFactory.getInstance(8);
    public static final short sid = 6;
    private double field_4_value;
    private short field_5_options;
    private int field_6_zero;
    private Formula field_8_parsed_expr;
    private SpecialCachedValue specialCachedValue;

    @Override // org.apache.poi.hssf.record.CellRecord
    protected String getRecordName() {
        return "FORMULA";
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 6;
    }

    static final class SpecialCachedValue {
        private static final long BIT_MARKER = -281474976710656L;
        public static final int BOOLEAN = 1;
        private static final int DATA_INDEX = 2;
        public static final int EMPTY = 3;
        public static final int ERROR_CODE = 2;
        public static final int STRING = 0;
        private static final int VARIABLE_DATA_LENGTH = 6;
        private final byte[] _variableData;

        private SpecialCachedValue(byte[] bArr) {
            this._variableData = bArr;
        }

        public int getTypeCode() {
            return this._variableData[0];
        }

        public static SpecialCachedValue create(long j) {
            if ((j & BIT_MARKER) != BIT_MARKER) {
                return null;
            }
            byte[] bArr = new byte[6];
            for (int i = 0; i < 6; i++) {
                bArr[i] = (byte) j;
                j >>= 8;
            }
            byte b = bArr[0];
            if (b != 0 && b != 1 && b != 2 && b != 3) {
                throw new RecordFormatException("Bad special value code (" + ((int) bArr[0]) + ")");
            }
            return new SpecialCachedValue(bArr);
        }

        public void serialize(LittleEndianOutput littleEndianOutput) {
            littleEndianOutput.write(this._variableData);
            littleEndianOutput.writeShort(Variant.VT_ILLEGAL);
        }

        public String formatDebugString() {
            return formatValue() + ' ' + HexDump.toHex(this._variableData);
        }

        private String formatValue() {
            int typeCode = getTypeCode();
            if (typeCode == 0) {
                return "<string>";
            }
            if (typeCode == 1) {
                return getDataValue() == 0 ? "FALSE" : "TRUE";
            }
            if (typeCode != 2) {
                return typeCode != 3 ? "#error(type=" + typeCode + ")#" : "<empty>";
            }
            return ErrorEval.getText(getDataValue());
        }

        private int getDataValue() {
            return this._variableData[2];
        }

        public static SpecialCachedValue createCachedEmptyValue() {
            return create(3, 0);
        }

        public static SpecialCachedValue createForString() {
            return create(0, 0);
        }

        public static SpecialCachedValue createCachedBoolean(boolean z) {
            return create(1, z ? 1 : 0);
        }

        public static SpecialCachedValue createCachedErrorCode(int i) {
            return create(2, i);
        }

        private static SpecialCachedValue create(int i, int i2) {
            return new SpecialCachedValue(new byte[]{(byte) i, 0, (byte) i2, 0, 0, 0});
        }

        public String toString() {
            return getClass().getName() + '[' + formatValue() + ']';
        }

        public int getValueType() {
            int typeCode = getTypeCode();
            if (typeCode == 0) {
                return CellType.STRING.getCode();
            }
            if (typeCode == 1) {
                return CellType.BOOLEAN.getCode();
            }
            if (typeCode == 2) {
                return CellType.ERROR.getCode();
            }
            if (typeCode == 3) {
                return CellType.STRING.getCode();
            }
            throw new IllegalStateException("Unexpected type id (" + typeCode + ")");
        }

        public boolean getBooleanValue() {
            if (getTypeCode() == 1) {
                return getDataValue() != 0;
            }
            throw new IllegalStateException("Not a boolean cached value - " + formatValue());
        }

        public int getErrorValue() {
            if (getTypeCode() != 2) {
                throw new IllegalStateException("Not an error cached value - " + formatValue());
            }
            return getDataValue();
        }
    }

    public FormulaRecord() {
        this.field_8_parsed_expr = Formula.create(Ptg.EMPTY_PTG_ARRAY);
    }

    public FormulaRecord(RecordInputStream recordInputStream) {
        super(recordInputStream);
        long j = recordInputStream.readLong();
        this.field_5_options = recordInputStream.readShort();
        SpecialCachedValue specialCachedValueCreate = SpecialCachedValue.create(j);
        this.specialCachedValue = specialCachedValueCreate;
        if (specialCachedValueCreate == null) {
            this.field_4_value = Double.longBitsToDouble(j);
        }
        this.field_6_zero = recordInputStream.readInt();
        this.field_8_parsed_expr = Formula.read(recordInputStream.readShort(), recordInputStream, recordInputStream.available());
    }

    public void setValue(double d) {
        this.field_4_value = d;
        this.specialCachedValue = null;
    }

    public void setCachedResultTypeEmptyString() {
        this.specialCachedValue = SpecialCachedValue.createCachedEmptyValue();
    }

    public void setCachedResultTypeString() {
        this.specialCachedValue = SpecialCachedValue.createForString();
    }

    public void setCachedResultErrorCode(int i) {
        this.specialCachedValue = SpecialCachedValue.createCachedErrorCode(i);
    }

    public void setCachedResultBoolean(boolean z) {
        this.specialCachedValue = SpecialCachedValue.createCachedBoolean(z);
    }

    public boolean hasCachedResultString() {
        SpecialCachedValue specialCachedValue = this.specialCachedValue;
        return specialCachedValue != null && specialCachedValue.getTypeCode() == 0;
    }

    public int getCachedResultType() {
        SpecialCachedValue specialCachedValue = this.specialCachedValue;
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

    public void setOptions(short s) {
        this.field_5_options = s;
    }

    public double getValue() {
        return this.field_4_value;
    }

    public short getOptions() {
        return this.field_5_options;
    }

    public boolean isSharedFormula() {
        return sharedFormula.isSet(this.field_5_options);
    }

    public void setSharedFormula(boolean z) {
        this.field_5_options = sharedFormula.setShortBoolean(this.field_5_options, z);
    }

    public boolean isAlwaysCalc() {
        return alwaysCalc.isSet(this.field_5_options);
    }

    public void setAlwaysCalc(boolean z) {
        this.field_5_options = alwaysCalc.setShortBoolean(this.field_5_options, z);
    }

    public boolean isCalcOnLoad() {
        return calcOnLoad.isSet(this.field_5_options);
    }

    public void setCalcOnLoad(boolean z) {
        this.field_5_options = calcOnLoad.setShortBoolean(this.field_5_options, z);
    }

    public Ptg[] getParsedExpression() {
        return this.field_8_parsed_expr.getTokens();
    }

    public Formula getFormula() {
        return this.field_8_parsed_expr;
    }

    public void setParsedExpression(Ptg[] ptgArr) {
        this.field_8_parsed_expr = Formula.create(ptgArr);
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    protected int getValueDataSize() {
        return FIXED_SIZE + this.field_8_parsed_expr.getEncodedSize();
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    protected void serializeValue(LittleEndianOutput littleEndianOutput) {
        SpecialCachedValue specialCachedValue = this.specialCachedValue;
        if (specialCachedValue == null) {
            littleEndianOutput.writeDouble(this.field_4_value);
        } else {
            specialCachedValue.serialize(littleEndianOutput);
        }
        littleEndianOutput.writeShort(getOptions());
        littleEndianOutput.writeInt(this.field_6_zero);
        this.field_8_parsed_expr.serialize(littleEndianOutput);
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    protected void appendValueText(StringBuilder sb) {
        sb.append("  .value\t = ");
        SpecialCachedValue specialCachedValue = this.specialCachedValue;
        if (specialCachedValue == null) {
            sb.append(this.field_4_value).append("\n");
        } else {
            sb.append(specialCachedValue.formatDebugString()).append("\n");
        }
        sb.append("  .options   = ").append(HexDump.shortToHex(getOptions())).append("\n");
        sb.append("    .alwaysCalc= ").append(isAlwaysCalc()).append("\n");
        sb.append("    .calcOnLoad= ").append(isCalcOnLoad()).append("\n");
        sb.append("    .shared    = ").append(isSharedFormula()).append("\n");
        sb.append("  .zero      = ").append(HexDump.intToHex(this.field_6_zero)).append("\n");
        Ptg[] tokens = this.field_8_parsed_expr.getTokens();
        for (int i = 0; i < tokens.length; i++) {
            if (i > 0) {
                sb.append("\n");
            }
            sb.append("    Ptg[").append(i).append("]=");
            Ptg ptg = tokens[i];
            sb.append(ptg).append(ptg.getRVAType());
        }
    }

    @Override // org.apache.poi.hssf.record.Record
    public FormulaRecord clone() {
        FormulaRecord formulaRecord = new FormulaRecord();
        copyBaseFields(formulaRecord);
        formulaRecord.field_4_value = this.field_4_value;
        formulaRecord.field_5_options = this.field_5_options;
        formulaRecord.field_6_zero = this.field_6_zero;
        formulaRecord.field_8_parsed_expr = this.field_8_parsed_expr;
        formulaRecord.specialCachedValue = this.specialCachedValue;
        return formulaRecord;
    }
}
