package org.apache.poi.ss.formula.ptg;

import org.apache.poi.ss.usermodel.FormulaError;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ErrPtg extends ScalarConstantPtg {
    private static final int SIZE = 2;
    public static final short sid = 28;
    private final int field_1_error_code;
    public static final ErrPtg NULL_INTERSECTION = new ErrPtg(FormulaError.NULL.getCode());
    public static final ErrPtg DIV_ZERO = new ErrPtg(FormulaError.DIV0.getCode());
    public static final ErrPtg VALUE_INVALID = new ErrPtg(FormulaError.VALUE.getCode());
    public static final ErrPtg REF_INVALID = new ErrPtg(FormulaError.REF.getCode());
    public static final ErrPtg NAME_INVALID = new ErrPtg(FormulaError.NAME.getCode());
    public static final ErrPtg NUM_ERROR = new ErrPtg(FormulaError.NUM.getCode());
    public static final ErrPtg N_A = new ErrPtg(FormulaError.NA.getCode());

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 2;
    }

    private ErrPtg(int i) {
        if (!FormulaError.isValidCode(i)) {
            throw new IllegalArgumentException("Invalid error code (" + i + ")");
        }
        this.field_1_error_code = i;
    }

    public static ErrPtg read(LittleEndianInput littleEndianInput) {
        return valueOf(littleEndianInput.readByte());
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getPtgClass() + 28);
        littleEndianOutput.writeByte(this.field_1_error_code);
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        return FormulaError.forInt(this.field_1_error_code).getString();
    }

    public int getErrorCode() {
        return this.field_1_error_code;
    }

    /* JADX INFO: renamed from: org.apache.poi.ss.formula.ptg.ErrPtg$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$FormulaError;

        static {
            int[] iArr = new int[FormulaError.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$FormulaError = iArr;
            try {
                iArr[FormulaError.DIV0.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$FormulaError[FormulaError.NA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$FormulaError[FormulaError.NAME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$FormulaError[FormulaError.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$FormulaError[FormulaError.NUM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$FormulaError[FormulaError.REF.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$FormulaError[FormulaError.VALUE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static ErrPtg valueOf(int i) {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$FormulaError[FormulaError.forInt(i).ordinal()]) {
            case 1:
                return DIV_ZERO;
            case 2:
                return N_A;
            case 3:
                return NAME_INVALID;
            case 4:
                return NULL_INTERSECTION;
            case 5:
                return NUM_ERROR;
            case 6:
                return REF_INVALID;
            case 7:
                return VALUE_INVALID;
            default:
                throw new RuntimeException("Unexpected error code (" + i + ")");
        }
    }
}
