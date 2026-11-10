package org.apache.poi.ss.formula.eval.forked;

import org.apache.poi.hssf.usermodel.HSSFEvaluationWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.CollaboratingWorkbooksEnvironment;
import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.formula.EvaluationWorkbook;
import org.apache.poi.ss.formula.IStabilityClassifier;
import org.apache.poi.ss.formula.WorkbookEvaluator;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ForkedEvaluator {
    private WorkbookEvaluator _evaluator;
    private ForkedEvaluationWorkbook _sewb;

    private ForkedEvaluator(EvaluationWorkbook evaluationWorkbook, IStabilityClassifier iStabilityClassifier, UDFFinder uDFFinder) {
        this._sewb = new ForkedEvaluationWorkbook(evaluationWorkbook);
        this._evaluator = new WorkbookEvaluator(this._sewb, iStabilityClassifier, uDFFinder);
    }

    private static EvaluationWorkbook createEvaluationWorkbook(Workbook workbook) {
        if (workbook instanceof HSSFWorkbook) {
            return HSSFEvaluationWorkbook.create((HSSFWorkbook) workbook);
        }
        try {
            return (EvaluationWorkbook) Class.forName("org.apache.poi.xssf.usermodel.XSSFEvaluationWorkbook").getDeclaredMethod("create", Class.forName("org.apache.poi.xssf.usermodel.XSSFWorkbook")).invoke(null, workbook);
        } catch (Exception e) {
            throw new IllegalArgumentException("Unexpected workbook type (" + workbook.getClass().getName() + ") - check for poi-ooxml and poi-ooxml schemas jar in the classpath", e);
        }
    }

    public static ForkedEvaluator create(Workbook workbook, IStabilityClassifier iStabilityClassifier, UDFFinder uDFFinder) {
        return new ForkedEvaluator(createEvaluationWorkbook(workbook), iStabilityClassifier, uDFFinder);
    }

    public void updateCell(String str, int i, int i2, ValueEval valueEval) {
        ForkedEvaluationCell orCreateUpdatableCell = this._sewb.getOrCreateUpdatableCell(str, i, i2);
        orCreateUpdatableCell.setValue(valueEval);
        this._evaluator.notifyUpdateCell(orCreateUpdatableCell);
    }

    public void copyUpdatedCells(Workbook workbook) {
        this._sewb.copyUpdatedCells(workbook);
    }

    public ValueEval evaluate(String str, int i, int i2) {
        EvaluationCell evaluationCell = this._sewb.getEvaluationCell(str, i, i2);
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[evaluationCell.getCellTypeEnum().ordinal()]) {
            case 1:
                return BoolEval.valueOf(evaluationCell.getBooleanCellValue());
            case 2:
                return ErrorEval.valueOf(evaluationCell.getErrorCellValue());
            case 3:
                return this._evaluator.evaluate(evaluationCell);
            case 4:
                return new NumberEval(evaluationCell.getNumericCellValue());
            case 5:
                return new StringEval(evaluationCell.getStringCellValue());
            case 6:
                return null;
            default:
                throw new IllegalStateException("Bad cell type (" + evaluationCell.getCellTypeEnum() + ")");
        }
    }

    /* JADX INFO: renamed from: org.apache.poi.ss.formula.eval.forked.ForkedEvaluator$1, reason: invalid class name */
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

    public static void setupEnvironment(String[] strArr, ForkedEvaluator[] forkedEvaluatorArr) {
        int length = forkedEvaluatorArr.length;
        WorkbookEvaluator[] workbookEvaluatorArr = new WorkbookEvaluator[length];
        for (int i = 0; i < length; i++) {
            workbookEvaluatorArr[i] = forkedEvaluatorArr[i]._evaluator;
        }
        CollaboratingWorkbooksEnvironment.setup(strArr, workbookEvaluatorArr);
    }
}
