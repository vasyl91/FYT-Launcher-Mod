package org.apache.poi.ss.formula;

import java.util.Iterator;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class BaseFormulaEvaluator implements FormulaEvaluator, WorkbookEvaluatorProvider {
    protected final WorkbookEvaluator _bookEvaluator;

    protected abstract RichTextString createRichTextString(String str);

    protected abstract CellValue evaluateFormulaCellValue(Cell cell);

    protected BaseFormulaEvaluator(WorkbookEvaluator workbookEvaluator) {
        this._bookEvaluator = workbookEvaluator;
    }

    public static void setupEnvironment(String[] strArr, BaseFormulaEvaluator[] baseFormulaEvaluatorArr) {
        int length = baseFormulaEvaluatorArr.length;
        WorkbookEvaluator[] workbookEvaluatorArr = new WorkbookEvaluator[length];
        for (int i = 0; i < length; i++) {
            workbookEvaluatorArr[i] = baseFormulaEvaluatorArr[i]._bookEvaluator;
        }
        CollaboratingWorkbooksEnvironment.setup(strArr, workbookEvaluatorArr);
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void setupReferencedWorkbooks(Map<String, FormulaEvaluator> map) {
        CollaboratingWorkbooksEnvironment.setupFormulaEvaluator(map);
    }

    @Override // org.apache.poi.ss.formula.WorkbookEvaluatorProvider
    public WorkbookEvaluator _getWorkbookEvaluator() {
        return this._bookEvaluator;
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void clearAllCachedResultValues() {
        this._bookEvaluator.clearAllCachedResultValues();
    }

    /* JADX INFO: renamed from: org.apache.poi.ss.formula.BaseFormulaEvaluator$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$CellType;

        static {
            int[] iArr = new int[CellType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$CellType = iArr;
            try {
                iArr[CellType.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.FORMULA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.NUMERIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.STRING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BLANK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public CellValue evaluate(Cell cell) {
        if (cell == null) {
            return null;
        }
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cell.getCellTypeEnum().ordinal()]) {
            case 1:
                return CellValue.valueOf(cell.getBooleanCellValue());
            case 2:
                return CellValue.getError(cell.getErrorCellValue());
            case 3:
                return evaluateFormulaCellValue(cell);
            case 4:
                return new CellValue(cell.getNumericCellValue());
            case 5:
                return new CellValue(cell.getRichStringCellValue().getString());
            case 6:
                return null;
            default:
                throw new IllegalStateException("Bad cell type (" + cell.getCellTypeEnum() + ")");
        }
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public Cell evaluateInCell(Cell cell) {
        if (cell == null) {
            return null;
        }
        if (cell.getCellTypeEnum() == CellType.FORMULA) {
            CellValue cellValueEvaluateFormulaCellValue = evaluateFormulaCellValue(cell);
            setCellValue(cell, cellValueEvaluateFormulaCellValue);
            setCellType(cell, cellValueEvaluateFormulaCellValue);
        }
        return cell;
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public int evaluateFormulaCell(Cell cell) {
        return evaluateFormulaCellEnum(cell).getCode();
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public CellType evaluateFormulaCellEnum(Cell cell) {
        if (cell == null || cell.getCellTypeEnum() != CellType.FORMULA) {
            return CellType._NONE;
        }
        CellValue cellValueEvaluateFormulaCellValue = evaluateFormulaCellValue(cell);
        setCellValue(cell, cellValueEvaluateFormulaCellValue);
        return cellValueEvaluateFormulaCellValue.getCellTypeEnum();
    }

    protected static void setCellType(Cell cell, CellValue cellValue) {
        CellType cellTypeEnum = cellValue.getCellTypeEnum();
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellTypeEnum.ordinal()]) {
            case 1:
            case 2:
            case 4:
            case 5:
                cell.setCellType(cellTypeEnum);
                return;
            case 3:
                throw new IllegalArgumentException("This should never happen. Formulas should have already been evaluated.");
            case 6:
                throw new IllegalArgumentException("This should never happen. Blanks eventually get translated to zero.");
            default:
                throw new IllegalStateException("Unexpected cell value type (" + cellTypeEnum + ")");
        }
    }

    protected void setCellValue(Cell cell, CellValue cellValue) {
        CellType cellTypeEnum = cellValue.getCellTypeEnum();
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellTypeEnum.ordinal()];
        if (i == 1) {
            cell.setCellValue(cellValue.getBooleanValue());
            return;
        }
        if (i == 2) {
            cell.setCellErrorValue(cellValue.getErrorValue());
        } else if (i == 4) {
            cell.setCellValue(cellValue.getNumberValue());
        } else {
            if (i == 5) {
                cell.setCellValue(createRichTextString(cellValue.getStringValue()));
                return;
            }
            throw new IllegalStateException("Unexpected cell value type (" + cellTypeEnum + ")");
        }
    }

    public static void evaluateAllFormulaCells(Workbook workbook) {
        evaluateAllFormulaCells(workbook, workbook.getCreationHelper().createFormulaEvaluator());
    }

    protected static void evaluateAllFormulaCells(Workbook workbook, FormulaEvaluator formulaEvaluator) {
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            Iterator<Row> it = workbook.getSheetAt(i).iterator();
            while (it.hasNext()) {
                for (Cell cell : it.next()) {
                    if (cell.getCellTypeEnum() == CellType.FORMULA) {
                        formulaEvaluator.evaluateFormulaCellEnum(cell);
                    }
                }
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void setIgnoreMissingWorkbooks(boolean z) {
        this._bookEvaluator.setIgnoreMissingWorkbooks(z);
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void setDebugEvaluationOutputForNextEval(boolean z) {
        this._bookEvaluator.setDebugEvaluationOutputForNextEval(z);
    }
}
