package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Lookup extends Var2or3ArgFunction {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
        LookupUtils.ValueVector valueVectorCreateVector;
        LookupUtils.ValueVector valueVectorCreateVector2;
        try {
            ValueEval singleValue = OperandResolver.getSingleValue(valueEval, i, i2);
            TwoDEval twoDEvalResolveTableArrayArg = LookupUtils.resolveTableArrayArg(valueEval2);
            if (twoDEvalResolveTableArrayArg.getWidth() > twoDEvalResolveTableArrayArg.getHeight()) {
                valueVectorCreateVector = createVector(twoDEvalResolveTableArrayArg.getRow(0));
                valueVectorCreateVector2 = createVector(twoDEvalResolveTableArrayArg.getRow(twoDEvalResolveTableArrayArg.getHeight() - 1));
            } else {
                valueVectorCreateVector = createVector(twoDEvalResolveTableArrayArg.getColumn(0));
                valueVectorCreateVector2 = createVector(twoDEvalResolveTableArrayArg.getColumn(twoDEvalResolveTableArrayArg.getWidth() - 1));
            }
            return valueVectorCreateVector2.getItem(LookupUtils.lookupIndexOfValue(singleValue, valueVectorCreateVector, true));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        try {
            ValueEval singleValue = OperandResolver.getSingleValue(valueEval, i, i2);
            TwoDEval twoDEvalResolveTableArrayArg = LookupUtils.resolveTableArrayArg(valueEval2);
            TwoDEval twoDEvalResolveTableArrayArg2 = LookupUtils.resolveTableArrayArg(valueEval3);
            LookupUtils.ValueVector valueVectorCreateVector = createVector(twoDEvalResolveTableArrayArg);
            LookupUtils.ValueVector valueVectorCreateVector2 = createVector(twoDEvalResolveTableArrayArg2);
            if (valueVectorCreateVector.getSize() > valueVectorCreateVector2.getSize()) {
                throw new RuntimeException("Lookup vector and result vector of differing sizes not supported yet");
            }
            return valueVectorCreateVector2.getItem(LookupUtils.lookupIndexOfValue(singleValue, valueVectorCreateVector, true));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private static LookupUtils.ValueVector createVector(TwoDEval twoDEval) {
        LookupUtils.ValueVector valueVectorCreateVector = LookupUtils.createVector(twoDEval);
        if (valueVectorCreateVector != null) {
            return valueVectorCreateVector;
        }
        throw new RuntimeException("non-vector lookup or result areas not supported yet");
    }
}
