package org.apache.poi.ss.formula;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeSet;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.atp.AnalysisToolPak;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.ExternalNameEval;
import org.apache.poi.ss.formula.eval.FunctionEval;
import org.apache.poi.ss.formula.eval.FunctionNameEval;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.NotImplementedException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefListEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.Choose;
import org.apache.poi.ss.formula.functions.FreeRefFunction;
import org.apache.poi.ss.formula.functions.Function;
import org.apache.poi.ss.formula.functions.IfFunc;
import org.apache.poi.ss.formula.ptg.Area3DPtg;
import org.apache.poi.ss.formula.ptg.Area3DPxg;
import org.apache.poi.ss.formula.ptg.AreaErrPtg;
import org.apache.poi.ss.formula.ptg.AreaPtg;
import org.apache.poi.ss.formula.ptg.AttrPtg;
import org.apache.poi.ss.formula.ptg.BoolPtg;
import org.apache.poi.ss.formula.ptg.ControlPtg;
import org.apache.poi.ss.formula.ptg.DeletedArea3DPtg;
import org.apache.poi.ss.formula.ptg.DeletedRef3DPtg;
import org.apache.poi.ss.formula.ptg.ErrPtg;
import org.apache.poi.ss.formula.ptg.ExpPtg;
import org.apache.poi.ss.formula.ptg.FuncVarPtg;
import org.apache.poi.ss.formula.ptg.IntPtg;
import org.apache.poi.ss.formula.ptg.MemAreaPtg;
import org.apache.poi.ss.formula.ptg.MemErrPtg;
import org.apache.poi.ss.formula.ptg.MemFuncPtg;
import org.apache.poi.ss.formula.ptg.MissingArgPtg;
import org.apache.poi.ss.formula.ptg.NamePtg;
import org.apache.poi.ss.formula.ptg.NameXPtg;
import org.apache.poi.ss.formula.ptg.NameXPxg;
import org.apache.poi.ss.formula.ptg.NumberPtg;
import org.apache.poi.ss.formula.ptg.OperationPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.Ref3DPtg;
import org.apache.poi.ss.formula.ptg.Ref3DPxg;
import org.apache.poi.ss.formula.ptg.RefErrorPtg;
import org.apache.poi.ss.formula.ptg.RefPtg;
import org.apache.poi.ss.formula.ptg.RefPtgBase;
import org.apache.poi.ss.formula.ptg.StringPtg;
import org.apache.poi.ss.formula.ptg.UnionPtg;
import org.apache.poi.ss.formula.ptg.UnknownPtg;
import org.apache.poi.ss.formula.udf.AggregatingUDFFinder;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.CellRangeAddressBase;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.Internal;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public final class WorkbookEvaluator {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) WorkbookEvaluator.class);
    private final POILogger EVAL_LOG;
    private EvaluationCache _cache;
    private CollaboratingWorkbooksEnvironment _collaboratingWorkbookEnvironment;
    private final IEvaluationListener _evaluationListener;
    private boolean _ignoreMissingWorkbooks;
    private final Map<String, Integer> _sheetIndexesByName;
    private final Map<EvaluationSheet, Integer> _sheetIndexesBySheet;
    private final IStabilityClassifier _stabilityClassifier;
    private final AggregatingUDFFinder _udfFinder;
    private final EvaluationWorkbook _workbook;
    private int _workbookIx;
    private boolean dbgEvaluationOutputForNextEval;
    private int dbgEvaluationOutputIndent;

    public WorkbookEvaluator(EvaluationWorkbook evaluationWorkbook, IStabilityClassifier iStabilityClassifier, UDFFinder uDFFinder) {
        this(evaluationWorkbook, null, iStabilityClassifier, uDFFinder);
    }

    WorkbookEvaluator(EvaluationWorkbook evaluationWorkbook, IEvaluationListener iEvaluationListener, IStabilityClassifier iStabilityClassifier, UDFFinder uDFFinder) {
        this.EVAL_LOG = POILogFactory.getLogger("POI.FormulaEval");
        this.dbgEvaluationOutputIndent = -1;
        this._workbook = evaluationWorkbook;
        this._evaluationListener = iEvaluationListener;
        this._cache = new EvaluationCache(iEvaluationListener);
        this._sheetIndexesBySheet = new IdentityHashMap();
        this._sheetIndexesByName = new IdentityHashMap();
        this._collaboratingWorkbookEnvironment = CollaboratingWorkbooksEnvironment.EMPTY;
        this._workbookIx = 0;
        this._stabilityClassifier = iStabilityClassifier;
        AggregatingUDFFinder aggregatingUDFFinder = evaluationWorkbook == null ? null : (AggregatingUDFFinder) evaluationWorkbook.getUDFFinder();
        if (aggregatingUDFFinder != null && uDFFinder != null) {
            aggregatingUDFFinder.add(uDFFinder);
        }
        this._udfFinder = aggregatingUDFFinder;
    }

    String getSheetName(int i) {
        return this._workbook.getSheetName(i);
    }

    EvaluationSheet getSheet(int i) {
        return this._workbook.getSheet(i);
    }

    EvaluationWorkbook getWorkbook() {
        return this._workbook;
    }

    EvaluationName getName(String str, int i) {
        return this._workbook.getName(str, i);
    }

    private static boolean isDebugLogEnabled() {
        return LOG.check(1);
    }

    private static boolean isInfoLogEnabled() {
        return LOG.check(3);
    }

    private static void logDebug(String str) {
        if (isDebugLogEnabled()) {
            LOG.log(1, str);
        }
    }

    private static void logInfo(String str) {
        if (isInfoLogEnabled()) {
            LOG.log(3, str);
        }
    }

    void attachToEnvironment(CollaboratingWorkbooksEnvironment collaboratingWorkbooksEnvironment, EvaluationCache evaluationCache, int i) {
        this._collaboratingWorkbookEnvironment = collaboratingWorkbooksEnvironment;
        this._cache = evaluationCache;
        this._workbookIx = i;
    }

    CollaboratingWorkbooksEnvironment getEnvironment() {
        return this._collaboratingWorkbookEnvironment;
    }

    void detachFromEnvironment() {
        this._collaboratingWorkbookEnvironment = CollaboratingWorkbooksEnvironment.EMPTY;
        this._cache = new EvaluationCache(this._evaluationListener);
        this._workbookIx = 0;
    }

    WorkbookEvaluator getOtherWorkbookEvaluator(String str) throws CollaboratingWorkbooksEnvironment.WorkbookNotFoundException {
        return this._collaboratingWorkbookEnvironment.getWorkbookEvaluator(str);
    }

    IEvaluationListener getEvaluationListener() {
        return this._evaluationListener;
    }

    public void clearAllCachedResultValues() {
        this._cache.clear();
        this._sheetIndexesBySheet.clear();
        this._workbook.clearAllCachedResultValues();
    }

    public void notifyUpdateCell(EvaluationCell evaluationCell) {
        this._cache.notifyUpdateCell(this._workbookIx, getSheetIndex(evaluationCell.getSheet()), evaluationCell);
    }

    public void notifyDeleteCell(EvaluationCell evaluationCell) {
        this._cache.notifyDeleteCell(this._workbookIx, getSheetIndex(evaluationCell.getSheet()), evaluationCell);
    }

    private int getSheetIndex(EvaluationSheet evaluationSheet) {
        Integer numValueOf = this._sheetIndexesBySheet.get(evaluationSheet);
        if (numValueOf == null) {
            int sheetIndex = this._workbook.getSheetIndex(evaluationSheet);
            if (sheetIndex < 0) {
                throw new RuntimeException("Specified sheet from a different book");
            }
            numValueOf = Integer.valueOf(sheetIndex);
            this._sheetIndexesBySheet.put(evaluationSheet, numValueOf);
        }
        return numValueOf.intValue();
    }

    public ValueEval evaluate(EvaluationCell evaluationCell) {
        return evaluateAny(evaluationCell, getSheetIndex(evaluationCell.getSheet()), evaluationCell.getRowIndex(), evaluationCell.getColumnIndex(), new EvaluationTracker(this._cache));
    }

    int getSheetIndex(String str) {
        Integer numValueOf = this._sheetIndexesByName.get(str);
        if (numValueOf == null) {
            int sheetIndex = this._workbook.getSheetIndex(str);
            if (sheetIndex < 0) {
                return -1;
            }
            numValueOf = Integer.valueOf(sheetIndex);
            this._sheetIndexesByName.put(str, numValueOf);
        }
        return numValueOf.intValue();
    }

    int getSheetIndexByExternIndex(int i) {
        return this._workbook.convertFromExternSheetIndex(i);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r6v1 ??, still in use, count: 2, list:
          (r6v1 ?? I:org.apache.poi.ss.formula.OperationEvaluationContext) from 0x006e: INVOKE (r1v39 ?? I:org.apache.poi.ss.formula.eval.ValueEval) = 
          (r16v0 'this' ?? I:org.apache.poi.ss.formula.WorkbookEvaluator A[IMMUTABLE_TYPE, THIS])
          (r6v1 ?? I:org.apache.poi.ss.formula.OperationEvaluationContext)
          (r1v38 ?? I:org.apache.poi.ss.formula.ptg.Ptg[])
         VIRTUAL call: org.apache.poi.ss.formula.WorkbookEvaluator.evaluateFormula(org.apache.poi.ss.formula.OperationEvaluationContext, org.apache.poi.ss.formula.ptg.Ptg[]):org.apache.poi.ss.formula.eval.ValueEval A[Catch: all -> 0x007e, RuntimeException -> 0x0082, NotImplementedException -> 0x014f, MD:(org.apache.poi.ss.formula.OperationEvaluationContext, org.apache.poi.ss.formula.ptg.Ptg[]):org.apache.poi.ss.formula.eval.ValueEval (m)] (LINE:281)
          (r6v1 ?? I:org.apache.poi.ss.formula.OperationEvaluationContext) from 0x0066: INVOKE (r0v30 ?? I:org.apache.poi.ss.formula.eval.ValueEval) = 
          (r16v0 'this' ?? I:org.apache.poi.ss.formula.WorkbookEvaluator A[IMMUTABLE_TYPE, THIS])
          (r6v1 ?? I:org.apache.poi.ss.formula.OperationEvaluationContext)
          (r1v38 ?? I:org.apache.poi.ss.formula.ptg.Ptg[])
         VIRTUAL call: org.apache.poi.ss.formula.WorkbookEvaluator.evaluateFormula(org.apache.poi.ss.formula.OperationEvaluationContext, org.apache.poi.ss.formula.ptg.Ptg[]):org.apache.poi.ss.formula.eval.ValueEval A[Catch: all -> 0x007e, RuntimeException -> 0x0082, NotImplementedException -> 0x014f, MD:(org.apache.poi.ss.formula.OperationEvaluationContext, org.apache.poi.ss.formula.ptg.Ptg[]):org.apache.poi.ss.formula.eval.ValueEval (m)] (LINE:278)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    private org.apache.poi.ss.formula.eval.ValueEval evaluateAny(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r6v1 ??, still in use, count: 2, list:
          (r6v1 ?? I:org.apache.poi.ss.formula.OperationEvaluationContext) from 0x006e: INVOKE (r1v39 ?? I:org.apache.poi.ss.formula.eval.ValueEval) = 
          (r16v0 'this' ?? I:org.apache.poi.ss.formula.WorkbookEvaluator A[IMMUTABLE_TYPE, THIS])
          (r6v1 ?? I:org.apache.poi.ss.formula.OperationEvaluationContext)
          (r1v38 ?? I:org.apache.poi.ss.formula.ptg.Ptg[])
         VIRTUAL call: org.apache.poi.ss.formula.WorkbookEvaluator.evaluateFormula(org.apache.poi.ss.formula.OperationEvaluationContext, org.apache.poi.ss.formula.ptg.Ptg[]):org.apache.poi.ss.formula.eval.ValueEval A[Catch: all -> 0x007e, RuntimeException -> 0x0082, NotImplementedException -> 0x014f, MD:(org.apache.poi.ss.formula.OperationEvaluationContext, org.apache.poi.ss.formula.ptg.Ptg[]):org.apache.poi.ss.formula.eval.ValueEval (m)] (LINE:281)
          (r6v1 ?? I:org.apache.poi.ss.formula.OperationEvaluationContext) from 0x0066: INVOKE (r0v30 ?? I:org.apache.poi.ss.formula.eval.ValueEval) = 
          (r16v0 'this' ?? I:org.apache.poi.ss.formula.WorkbookEvaluator A[IMMUTABLE_TYPE, THIS])
          (r6v1 ?? I:org.apache.poi.ss.formula.OperationEvaluationContext)
          (r1v38 ?? I:org.apache.poi.ss.formula.ptg.Ptg[])
         VIRTUAL call: org.apache.poi.ss.formula.WorkbookEvaluator.evaluateFormula(org.apache.poi.ss.formula.OperationEvaluationContext, org.apache.poi.ss.formula.ptg.Ptg[]):org.apache.poi.ss.formula.eval.ValueEval A[Catch: all -> 0x007e, RuntimeException -> 0x0082, NotImplementedException -> 0x014f, MD:(org.apache.poi.ss.formula.OperationEvaluationContext, org.apache.poi.ss.formula.ptg.Ptg[]):org.apache.poi.ss.formula.eval.ValueEval (m)] (LINE:278)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r17v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
        */

    /* JADX INFO: renamed from: org.apache.poi.ss.formula.WorkbookEvaluator$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$CellType;

        static {
            int[] iArr = new int[CellType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$CellType = iArr;
            try {
                iArr[CellType.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BLANK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BOOLEAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.FORMULA.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private NotImplementedException addExceptionInfo(NotImplementedException notImplementedException, int i, int i2, int i3) {
        try {
            return new NotImplementedException("Error evaluating cell " + new CellReference(this._workbook.getSheetName(i), i2, i3, false, false).formatAsString(), notImplementedException);
        } catch (Exception e) {
            LOG.log(7, "Can't add exception info", e);
            return notImplementedException;
        }
    }

    static ValueEval getValueFromNonFormulaCell(EvaluationCell evaluationCell) {
        if (evaluationCell == null) {
            return BlankEval.instance;
        }
        CellType cellTypeEnum = evaluationCell.getCellTypeEnum();
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellTypeEnum.ordinal()];
        if (i == 1) {
            return new NumberEval(evaluationCell.getNumericCellValue());
        }
        if (i == 2) {
            return new StringEval(evaluationCell.getStringCellValue());
        }
        if (i == 3) {
            return BlankEval.instance;
        }
        if (i == 4) {
            return BoolEval.valueOf(evaluationCell.getBooleanCellValue());
        }
        if (i == 5) {
            return ErrorEval.valueOf(evaluationCell.getErrorCellValue());
        }
        throw new RuntimeException("Unexpected cell type (" + cellTypeEnum + ")");
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0219 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:110:0x0221 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x019e A[PHI: r8
  0x019e: PHI (r8v2 org.apache.poi.ss.formula.ptg.Ptg) = (r8v1 org.apache.poi.ss.formula.ptg.Ptg), (r8v7 org.apache.poi.ss.formula.ptg.Ptg) binds: [B:15:0x00c2, B:50:0x0180] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:67:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:68:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:70:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:72:0x01db A[LOOP:1: B:71:0x01d9->B:72:0x01db, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:74:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:76:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:78:0x01f8  */
    @Internal
    ValueEval evaluateFormula(OperationEvaluationContext operationEvaluationContext, Ptg[] ptgArr) {
        ValueEval evalForPtg;
        ValueEval[] valueEvalArr;
        int i;
        int iCountTokensToBeSkipped;
        int chooseFuncOffset;
        int i2;
        if (this.dbgEvaluationOutputForNextEval) {
            this.dbgEvaluationOutputIndent = 1;
            this.dbgEvaluationOutputForNextEval = false;
        }
        int i3 = this.dbgEvaluationOutputIndent;
        String str = "";
        if (i3 > 0) {
            String strSubstring = "                                                                                                    ".substring(0, Math.min(100, i3 * 2));
            this.EVAL_LOG.log(5, strSubstring + "- evaluateFormula('" + operationEvaluationContext.getRefEvaluatorForCurrentSheet().getSheetNameRange() + "'/" + new CellReference(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex()).formatAsString() + "): " + Arrays.toString(ptgArr).replaceAll("\\Qorg.apache.poi.ss.formula.ptg.\\E", ""));
            this.dbgEvaluationOutputIndent++;
            str = strSubstring;
        }
        Stack stack = new Stack();
        int length = ptgArr.length;
        int iCountTokensToBeSkipped2 = 0;
        while (iCountTokensToBeSkipped2 < length) {
            Ptg ptg = ptgArr[iCountTokensToBeSkipped2];
            if (this.dbgEvaluationOutputIndent > 0) {
                this.EVAL_LOG.log(3, str + "  * ptg " + iCountTokensToBeSkipped2 + ": " + ptg + ", stack: " + stack);
            }
            if (ptg instanceof AttrPtg) {
                AttrPtg attrPtg = (AttrPtg) ptg;
                if (attrPtg.isSum()) {
                    ptg = FuncVarPtg.SUM;
                }
                if (attrPtg.isOptimizedChoose()) {
                    ValueEval valueEval = (ValueEval) stack.pop();
                    int[] jumpTable = attrPtg.getJumpTable();
                    int length2 = jumpTable.length;
                    try {
                        int iEvaluateFirstArg = Choose.evaluateFirstArg(valueEval, operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
                        if (iEvaluateFirstArg < 1 || iEvaluateFirstArg > length2) {
                            stack.push(ErrorEval.VALUE_INVALID);
                            chooseFuncOffset = attrPtg.getChooseFuncOffset();
                            i2 = chooseFuncOffset + 4;
                        } else {
                            i2 = jumpTable[iEvaluateFirstArg - 1];
                        }
                    } catch (EvaluationException e) {
                        stack.push(e.getErrorEval());
                        chooseFuncOffset = attrPtg.getChooseFuncOffset();
                    }
                    iCountTokensToBeSkipped = countTokensToBeSkipped(ptgArr, iCountTokensToBeSkipped2, i2 - ((length2 * 2) + 2));
                } else if (attrPtg.isOptimizedIf()) {
                    try {
                        if (!IfFunc.evaluateFirstArg((ValueEval) stack.pop(), operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex())) {
                            iCountTokensToBeSkipped2 += countTokensToBeSkipped(ptgArr, iCountTokensToBeSkipped2, attrPtg.getData());
                            int i4 = iCountTokensToBeSkipped2 + 1;
                            Ptg ptg2 = ptgArr[i4];
                            if ((ptgArr[iCountTokensToBeSkipped2] instanceof AttrPtg) && (ptg2 instanceof FuncVarPtg) && ((FuncVarPtg) ptg2).getFunctionIndex() == 1) {
                                stack.push(BoolEval.FALSE);
                                iCountTokensToBeSkipped2 = i4;
                            }
                        }
                    } catch (EvaluationException e2) {
                        stack.push(e2.getErrorEval());
                        iCountTokensToBeSkipped2 += countTokensToBeSkipped(ptgArr, iCountTokensToBeSkipped2, attrPtg.getData());
                        iCountTokensToBeSkipped = countTokensToBeSkipped(ptgArr, iCountTokensToBeSkipped2, ((AttrPtg) ptgArr[iCountTokensToBeSkipped2]).getData() + 1);
                        iCountTokensToBeSkipped2 += iCountTokensToBeSkipped;
                    }
                } else if (attrPtg.isSkip()) {
                    iCountTokensToBeSkipped2 += countTokensToBeSkipped(ptgArr, iCountTokensToBeSkipped2, attrPtg.getData() + 1);
                    if (stack.peek() == MissingArgEval.instance) {
                        stack.pop();
                        stack.push(BlankEval.instance);
                    }
                } else if ((ptg instanceof ControlPtg) && !(ptg instanceof MemFuncPtg) && !(ptg instanceof MemAreaPtg) && !(ptg instanceof MemErrPtg)) {
                    if (ptg instanceof UnionPtg) {
                        stack.push(new RefListEval((ValueEval) stack.pop(), (ValueEval) stack.pop()));
                    } else {
                        if (ptg instanceof OperationPtg) {
                            OperationPtg operationPtg = (OperationPtg) ptg;
                            int numberOfOperands = operationPtg.getNumberOfOperands();
                            valueEvalArr = new ValueEval[numberOfOperands];
                            for (i = numberOfOperands - 1; i >= 0; i--) {
                                valueEvalArr[i] = (ValueEval) stack.pop();
                            }
                            evalForPtg = OperationEvaluatorFactory.evaluate(operationPtg, valueEvalArr, operationEvaluationContext);
                        } else {
                            evalForPtg = getEvalForPtg(ptg, operationEvaluationContext);
                        }
                        if (evalForPtg != null) {
                            throw new RuntimeException("Evaluation result must not be null");
                        }
                        stack.push(evalForPtg);
                        if (this.dbgEvaluationOutputIndent > 0) {
                            this.EVAL_LOG.log(3, str + "    = " + evalForPtg);
                        }
                    }
                }
                iCountTokensToBeSkipped2 += iCountTokensToBeSkipped;
            } else if (ptg instanceof ControlPtg) {
                continue;
            } else if (ptg instanceof UnionPtg) {
                stack.push(new RefListEval((ValueEval) stack.pop(), (ValueEval) stack.pop()));
            } else {
                if (ptg instanceof OperationPtg) {
                    OperationPtg operationPtg2 = (OperationPtg) ptg;
                    int numberOfOperands2 = operationPtg2.getNumberOfOperands();
                    valueEvalArr = new ValueEval[numberOfOperands2];
                    while (i >= 0) {
                        valueEvalArr[i] = (ValueEval) stack.pop();
                    }
                    evalForPtg = OperationEvaluatorFactory.evaluate(operationPtg2, valueEvalArr, operationEvaluationContext);
                } else {
                    evalForPtg = getEvalForPtg(ptg, operationEvaluationContext);
                }
                if (evalForPtg != null) {
                    throw new RuntimeException("Evaluation result must not be null");
                }
                stack.push(evalForPtg);
                if (this.dbgEvaluationOutputIndent > 0) {
                    this.EVAL_LOG.log(3, str + "    = " + evalForPtg);
                }
            }
            iCountTokensToBeSkipped2++;
        }
        ValueEval valueEvalDereferenceResult = (ValueEval) stack.pop();
        if (!stack.isEmpty()) {
            throw new IllegalStateException("evaluation stack not empty");
        }
        if (operationEvaluationContext.isSingleValue()) {
            valueEvalDereferenceResult = dereferenceResult(valueEvalDereferenceResult, operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
        }
        if (this.dbgEvaluationOutputIndent > 0) {
            this.EVAL_LOG.log(3, str + "finshed eval of " + new CellReference(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex()).formatAsString() + ": " + valueEvalDereferenceResult);
            int i5 = this.dbgEvaluationOutputIndent - 1;
            this.dbgEvaluationOutputIndent = i5;
            if (i5 == 1) {
                this.dbgEvaluationOutputIndent = -1;
            }
        }
        return valueEvalDereferenceResult;
    }

    private static int countTokensToBeSkipped(Ptg[] ptgArr, int i, int i2) {
        int i3 = i;
        while (i2 != 0) {
            i3++;
            i2 -= ptgArr[i3].getSize();
            if (i2 < 0) {
                throw new RuntimeException("Bad skip distance (wrong token size calculation).");
            }
            if (i3 >= ptgArr.length) {
                throw new RuntimeException("Skip distance too far (ran out of formula tokens).");
            }
        }
        return i3 - i;
    }

    public static ValueEval dereferenceResult(ValueEval valueEval, int i, int i2) {
        try {
            ValueEval singleValue = OperandResolver.getSingleValue(valueEval, i, i2);
            return singleValue == BlankEval.instance ? NumberEval.ZERO : singleValue;
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private ValueEval getEvalForPtg(Ptg ptg, OperationEvaluationContext operationEvaluationContext) {
        if (ptg instanceof NamePtg) {
            return getEvalForNameRecord(this._workbook.getName((NamePtg) ptg), operationEvaluationContext);
        }
        if (ptg instanceof NameXPtg) {
            return processNameEval(operationEvaluationContext.getNameXEval((NameXPtg) ptg), operationEvaluationContext);
        }
        if (ptg instanceof NameXPxg) {
            return processNameEval(operationEvaluationContext.getNameXEval((NameXPxg) ptg), operationEvaluationContext);
        }
        if (ptg instanceof IntPtg) {
            return new NumberEval(((IntPtg) ptg).getValue());
        }
        if (ptg instanceof NumberPtg) {
            return new NumberEval(((NumberPtg) ptg).getValue());
        }
        if (ptg instanceof StringPtg) {
            return new StringEval(((StringPtg) ptg).getValue());
        }
        if (ptg instanceof BoolPtg) {
            return BoolEval.valueOf(((BoolPtg) ptg).getValue());
        }
        if (ptg instanceof ErrPtg) {
            return ErrorEval.valueOf(((ErrPtg) ptg).getErrorCode());
        }
        if (ptg instanceof MissingArgPtg) {
            return MissingArgEval.instance;
        }
        if ((ptg instanceof AreaErrPtg) || (ptg instanceof RefErrorPtg) || (ptg instanceof DeletedArea3DPtg) || (ptg instanceof DeletedRef3DPtg)) {
            return ErrorEval.REF_INVALID;
        }
        if (ptg instanceof Ref3DPtg) {
            return operationEvaluationContext.getRef3DEval((Ref3DPtg) ptg);
        }
        if (ptg instanceof Ref3DPxg) {
            return operationEvaluationContext.getRef3DEval((Ref3DPxg) ptg);
        }
        if (ptg instanceof Area3DPtg) {
            return operationEvaluationContext.getArea3DEval((Area3DPtg) ptg);
        }
        if (ptg instanceof Area3DPxg) {
            return operationEvaluationContext.getArea3DEval((Area3DPxg) ptg);
        }
        if (ptg instanceof RefPtg) {
            RefPtg refPtg = (RefPtg) ptg;
            return operationEvaluationContext.getRefEval(refPtg.getRow(), refPtg.getColumn());
        }
        if (ptg instanceof AreaPtg) {
            AreaPtg areaPtg = (AreaPtg) ptg;
            return operationEvaluationContext.getAreaEval(areaPtg.getFirstRow(), areaPtg.getFirstColumn(), areaPtg.getLastRow(), areaPtg.getLastColumn());
        }
        if (ptg instanceof UnknownPtg) {
            throw new RuntimeException("UnknownPtg not allowed");
        }
        if (ptg instanceof ExpPtg) {
            throw new RuntimeException("ExpPtg currently not supported");
        }
        throw new RuntimeException("Unexpected ptg class (" + ptg.getClass().getName() + ")");
    }

    private ValueEval processNameEval(ValueEval valueEval, OperationEvaluationContext operationEvaluationContext) {
        return valueEval instanceof ExternalNameEval ? getEvalForNameRecord(((ExternalNameEval) valueEval).getName(), operationEvaluationContext) : valueEval;
    }

    private ValueEval getEvalForNameRecord(EvaluationName evaluationName, OperationEvaluationContext operationEvaluationContext) {
        if (evaluationName.isFunctionName()) {
            return new FunctionNameEval(evaluationName.getNameText());
        }
        if (evaluationName.hasFormula()) {
            return evaluateNameFormula(evaluationName.getNameDefinition(), operationEvaluationContext);
        }
        throw new RuntimeException("Don't now how to evalate name '" + evaluationName.getNameText() + "'");
    }

    ValueEval evaluateNameFormula(Ptg[] ptgArr, OperationEvaluationContext operationEvaluationContext) {
        if (ptgArr.length == 1) {
            return getEvalForPtg(ptgArr[0], operationEvaluationContext);
        }
        return evaluateFormula(operationEvaluationContext, ptgArr);
    }

    ValueEval evaluateReference(EvaluationSheet evaluationSheet, int i, int i2, int i3, EvaluationTracker evaluationTracker) {
        return evaluateAny(evaluationSheet.getCell(i2, i3), i, i2, i3, evaluationTracker);
    }

    public FreeRefFunction findUserDefinedFunction(String str) {
        return this._udfFinder.findFunction(str);
    }

    public ValueEval evaluate(String str, CellReference cellReference) {
        String sheetName = cellReference == null ? null : cellReference.getSheetName();
        int sheetIndex = sheetName == null ? -1 : getWorkbook().getSheetIndex(sheetName);
        int row = cellReference == null ? -1 : cellReference.getRow();
        return evaluateNameFormula(FormulaParser.parse(str, (FormulaParsingWorkbook) getWorkbook(), FormulaType.CELL, sheetIndex, row), new OperationEvaluationContext(this, getWorkbook(), sheetIndex, row, cellReference != null ? cellReference.getCol() : (short) -1, new EvaluationTracker(this._cache)));
    }

    public ValueEval evaluate(String str, CellReference cellReference, CellRangeAddressBase cellRangeAddressBase) {
        return evaluate(str, cellReference, cellRangeAddressBase, FormulaType.CELL);
    }

    public ValueEval evaluateList(String str, CellReference cellReference, CellRangeAddressBase cellRangeAddressBase) {
        return evaluate(str, cellReference, cellRangeAddressBase, FormulaType.DATAVALIDATION_LIST);
    }

    private ValueEval evaluate(String str, CellReference cellReference, CellRangeAddressBase cellRangeAddressBase, FormulaType formulaType) {
        String sheetName = cellReference == null ? null : cellReference.getSheetName();
        if (sheetName == null) {
            throw new IllegalArgumentException("Sheet name is required");
        }
        int sheetIndex = getWorkbook().getSheetIndex(sheetName);
        Ptg[] ptgArr = FormulaParser.parse(str, (FormulaParsingWorkbook) getWorkbook(), formulaType, sheetIndex, cellReference.getRow());
        adjustRegionRelativeReference(ptgArr, cellReference, cellRangeAddressBase);
        return evaluateNameFormula(ptgArr, new OperationEvaluationContext(this, getWorkbook(), sheetIndex, cellReference.getRow(), cellReference.getCol(), new EvaluationTracker(this._cache), formulaType.isSingleValue()));
    }

    protected boolean adjustRegionRelativeReference(Ptg[] ptgArr, CellReference cellReference, CellRangeAddressBase cellRangeAddressBase) {
        if (!cellRangeAddressBase.isInRange(cellReference)) {
            throw new IllegalArgumentException(cellReference + " is not within " + cellRangeAddressBase);
        }
        return adjustRegionRelativeReference(ptgArr, cellReference.getRow() - cellRangeAddressBase.getFirstRow(), cellReference.getCol() - cellRangeAddressBase.getFirstColumn());
    }

    protected boolean adjustRegionRelativeReference(Ptg[] ptgArr, int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("offset row must be positive");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("offset column must be positive");
        }
        boolean z = false;
        for (Ptg ptg : ptgArr) {
            if (ptg instanceof RefPtgBase) {
                RefPtgBase refPtgBase = (RefPtgBase) ptg;
                SpreadsheetVersion spreadsheetVersion = this._workbook.getSpreadsheetVersion();
                if (refPtgBase.isRowRelative()) {
                    int row = refPtgBase.getRow() + i;
                    if (row > spreadsheetVersion.getMaxRows()) {
                        throw new IndexOutOfBoundsException(spreadsheetVersion.name() + " files can only have " + spreadsheetVersion.getMaxRows() + " rows, but row " + row + " was requested.");
                    }
                    refPtgBase.setRow(row);
                    z = true;
                }
                if (refPtgBase.isColRelative()) {
                    int column = refPtgBase.getColumn() + i2;
                    if (column > spreadsheetVersion.getMaxColumns()) {
                        throw new IndexOutOfBoundsException(spreadsheetVersion.name() + " files can only have " + spreadsheetVersion.getMaxColumns() + " columns, but column " + column + " was requested.");
                    }
                    refPtgBase.setColumn(column);
                    z = true;
                } else {
                    continue;
                }
            }
        }
        return z;
    }

    public void setIgnoreMissingWorkbooks(boolean z) {
        this._ignoreMissingWorkbooks = z;
    }

    public boolean isIgnoreMissingWorkbooks() {
        return this._ignoreMissingWorkbooks;
    }

    public static Collection<String> getSupportedFunctionNames() {
        TreeSet treeSet = new TreeSet();
        treeSet.addAll(FunctionEval.getSupportedFunctionNames());
        treeSet.addAll(AnalysisToolPak.getSupportedFunctionNames());
        return Collections.unmodifiableCollection(treeSet);
    }

    public static Collection<String> getNotSupportedFunctionNames() {
        TreeSet treeSet = new TreeSet();
        treeSet.addAll(FunctionEval.getNotSupportedFunctionNames());
        treeSet.addAll(AnalysisToolPak.getNotSupportedFunctionNames());
        return Collections.unmodifiableCollection(treeSet);
    }

    public static void registerFunction(String str, FreeRefFunction freeRefFunction) {
        AnalysisToolPak.registerFunction(str, freeRefFunction);
    }

    public static void registerFunction(String str, Function function) {
        FunctionEval.registerFunction(str, function);
    }

    public void setDebugEvaluationOutputForNextEval(boolean z) {
        this.dbgEvaluationOutputForNextEval = z;
    }

    public boolean isDebugEvaluationOutputForNextEval() {
        return this.dbgEvaluationOutputForNextEval;
    }
}
