package org.apache.poi.hssf.record;

import org.apache.poi.ss.usermodel.FormulaError;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class BoolErrRecord extends CellRecord implements Cloneable {
    public static final short sid = 517;
    private boolean _isError;
    private int _value;

    @Override // org.apache.poi.hssf.record.CellRecord
    protected String getRecordName() {
        return "BOOLERR";
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 517;
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    protected int getValueDataSize() {
        return 2;
    }

    public BoolErrRecord() {
    }

    public BoolErrRecord(RecordInputStream recordInputStream) {
        super(recordInputStream);
        int iRemaining = recordInputStream.remaining();
        if (iRemaining == 2) {
            this._value = recordInputStream.readByte();
        } else if (iRemaining == 3) {
            this._value = recordInputStream.readUShort();
        } else {
            throw new RecordFormatException("Unexpected size (" + recordInputStream.remaining() + ") for BOOLERR record.");
        }
        int uByte = recordInputStream.readUByte();
        if (uByte == 0) {
            this._isError = false;
        } else {
            if (uByte == 1) {
                this._isError = true;
                return;
            }
            throw new RecordFormatException("Unexpected isError flag (" + uByte + ") for BOOLERR record.");
        }
    }

    public void setValue(boolean z) {
        this._value = z ? 1 : 0;
        this._isError = false;
    }

    public void setValue(byte b) {
        setValue(FormulaError.forInt(b));
    }

    /* JADX INFO: renamed from: org.apache.poi.hssf.record.BoolErrRecord$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$FormulaError;

        static {
            int[] iArr = new int[FormulaError.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$FormulaError = iArr;
            try {
                iArr[FormulaError.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$FormulaError[FormulaError.DIV0.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$FormulaError[FormulaError.VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$FormulaError[FormulaError.REF.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$FormulaError[FormulaError.NAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$FormulaError[FormulaError.NUM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$FormulaError[FormulaError.NA.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public void setValue(FormulaError formulaError) {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$FormulaError[formulaError.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                this._value = formulaError.getCode();
                this._isError = true;
                return;
            default:
                throw new IllegalArgumentException("Error Value can only be 0,7,15,23,29,36 or 42. It cannot be " + ((int) formulaError.getCode()) + " (" + formulaError + ")");
        }
    }

    public boolean getBooleanValue() {
        return this._value != 0;
    }

    public byte getErrorValue() {
        return (byte) this._value;
    }

    public boolean isBoolean() {
        return !this._isError;
    }

    public boolean isError() {
        return this._isError;
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    protected void appendValueText(StringBuilder sb) {
        if (isBoolean()) {
            sb.append("  .boolVal = ");
            sb.append(getBooleanValue());
        } else {
            sb.append("  .errCode = ");
            sb.append(FormulaError.forInt(getErrorValue()).getString());
            sb.append(" (").append(HexDump.byteToHex(getErrorValue())).append(")");
        }
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    protected void serializeValue(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(this._value);
        littleEndianOutput.writeByte(this._isError ? 1 : 0);
    }

    @Override // org.apache.poi.hssf.record.Record
    public BoolErrRecord clone() {
        BoolErrRecord boolErrRecord = new BoolErrRecord();
        copyBaseFields(boolErrRecord);
        boolErrRecord._value = this._value;
        boolErrRecord._isError = this._isError;
        return boolErrRecord;
    }
}
