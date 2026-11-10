package org.apache.poi.ss.formula.eval.forked;

import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.formula.EvaluationSheet;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
final class ForkedEvaluationCell implements EvaluationCell {
    private boolean _booleanValue;
    private CellType _cellType;
    private int _errorValue;
    private final EvaluationCell _masterCell;
    private double _numberValue;
    private final EvaluationSheet _sheet;
    private String _stringValue;

    public ForkedEvaluationCell(ForkedEvaluationSheet forkedEvaluationSheet, EvaluationCell evaluationCell) {
        this._sheet = forkedEvaluationSheet;
        this._masterCell = evaluationCell;
        setValue(BlankEval.instance);
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public Object getIdentityKey() {
        return this._masterCell.getIdentityKey();
    }

    public void setValue(ValueEval valueEval) {
        Class<?> cls = valueEval.getClass();
        if (cls == NumberEval.class) {
            this._cellType = CellType.NUMERIC;
            this._numberValue = ((NumberEval) valueEval).getNumberValue();
            return;
        }
        if (cls == StringEval.class) {
            this._cellType = CellType.STRING;
            this._stringValue = ((StringEval) valueEval).getStringValue();
            return;
        }
        if (cls == BoolEval.class) {
            this._cellType = CellType.BOOLEAN;
            this._booleanValue = ((BoolEval) valueEval).getBooleanValue();
        } else if (cls == ErrorEval.class) {
            this._cellType = CellType.ERROR;
            this._errorValue = ((ErrorEval) valueEval).getErrorCode();
        } else {
            if (cls == BlankEval.class) {
                this._cellType = CellType.BLANK;
                return;
            }
            throw new IllegalArgumentException("Unexpected value class (" + cls.getName() + ")");
        }
    }

    /* JADX INFO: renamed from: org.apache.poi.ss.formula.eval.forked.ForkedEvaluationCell$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$CellType;

        static {
            int[] iArr = new int[CellType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$CellType = iArr;
            try {
                iArr[CellType.BLANK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.NUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.STRING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public void copyValue(Cell cell) {
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[this._cellType.ordinal()];
        if (i == 1) {
            cell.setCellType(CellType.BLANK);
            return;
        }
        if (i == 2) {
            cell.setCellValue(this._numberValue);
            return;
        }
        if (i == 3) {
            cell.setCellValue(this._booleanValue);
        } else if (i == 4) {
            cell.setCellValue(this._stringValue);
        } else {
            if (i == 5) {
                cell.setCellErrorValue((byte) this._errorValue);
                return;
            }
            throw new IllegalStateException("Unexpected data type (" + this._cellType + ")");
        }
    }

    private void checkCellType(CellType cellType) {
        if (this._cellType != cellType) {
            throw new RuntimeException("Wrong data type (" + this._cellType + ")");
        }
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public int getCellType() {
        return this._cellType.getCode();
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public CellType getCellTypeEnum() {
        return this._cellType;
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public boolean getBooleanCellValue() {
        checkCellType(CellType.BOOLEAN);
        return this._booleanValue;
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public int getErrorCellValue() {
        checkCellType(CellType.ERROR);
        return this._errorValue;
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public double getNumericCellValue() {
        checkCellType(CellType.NUMERIC);
        return this._numberValue;
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public String getStringCellValue() {
        checkCellType(CellType.STRING);
        return this._stringValue;
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public EvaluationSheet getSheet() {
        return this._sheet;
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public int getRowIndex() {
        return this._masterCell.getRowIndex();
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public int getColumnIndex() {
        return this._masterCell.getColumnIndex();
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public int getCachedFormulaResultType() {
        return this._masterCell.getCachedFormulaResultType();
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public CellType getCachedFormulaResultTypeEnum() {
        return this._masterCell.getCachedFormulaResultTypeEnum();
    }
}
