package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Offset implements Function {
    private static final int LAST_VALID_COLUMN_INDEX = 255;
    private static final int LAST_VALID_ROW_INDEX = 65535;

    static final class LinearOffsetRange {
        private final int _length;
        private final int _offset;

        public LinearOffsetRange(int i, int i2) {
            if (i2 == 0) {
                throw new RuntimeException("length may not be zero");
            }
            this._offset = i;
            this._length = i2;
        }

        public short getFirstIndex() {
            return (short) this._offset;
        }

        public short getLastIndex() {
            return (short) ((this._offset + this._length) - 1);
        }

        public LinearOffsetRange normaliseAndTranslate(int i) {
            int i2 = this._length;
            if (i2 > 0) {
                return i == 0 ? this : new LinearOffsetRange(i + this._offset, i2);
            }
            return new LinearOffsetRange(i + this._offset + i2 + 1, -i2);
        }

        public boolean isOutOfBounds(int i, int i2) {
            return this._offset < i || getLastIndex() > i2;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer(64);
            stringBuffer.append(getClass().getName()).append(" [");
            stringBuffer.append(this._offset).append("...").append((int) getLastIndex());
            stringBuffer.append("]");
            return stringBuffer.toString();
        }
    }

    private static final class BaseRef {
        private final AreaEval _areaEval;
        private final int _firstColumnIndex;
        private final int _firstRowIndex;
        private final int _height;
        private final RefEval _refEval;
        private final int _width;

        public BaseRef(RefEval refEval) {
            this._refEval = refEval;
            this._areaEval = null;
            this._firstRowIndex = refEval.getRow();
            this._firstColumnIndex = refEval.getColumn();
            this._height = 1;
            this._width = 1;
        }

        public BaseRef(AreaEval areaEval) {
            this._refEval = null;
            this._areaEval = areaEval;
            this._firstRowIndex = areaEval.getFirstRow();
            this._firstColumnIndex = areaEval.getFirstColumn();
            this._height = (areaEval.getLastRow() - areaEval.getFirstRow()) + 1;
            this._width = (areaEval.getLastColumn() - areaEval.getFirstColumn()) + 1;
        }

        public int getWidth() {
            return this._width;
        }

        public int getHeight() {
            return this._height;
        }

        public int getFirstRowIndex() {
            return this._firstRowIndex;
        }

        public int getFirstColumnIndex() {
            return this._firstColumnIndex;
        }

        public AreaEval offset(int i, int i2, int i3, int i4) {
            RefEval refEval = this._refEval;
            if (refEval == null) {
                return this._areaEval.offset(i, i2, i3, i4);
            }
            return refEval.offset(i, i2, i3, i4);
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003e A[Catch: EvaluationException -> 0x0059, TryCatch #0 {EvaluationException -> 0x0059, blocks: (B:8:0x000a, B:21:0x0047, B:23:0x0056, B:12:0x002d, B:14:0x0033, B:15:0x0038, B:17:0x003e), top: B:30:0x000a }] */
    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        ValueEval valueEval;
        if (valueEvalArr.length < 3 || valueEvalArr.length > 5) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            BaseRef baseRefEvaluateBaseRef = evaluateBaseRef(valueEvalArr[0]);
            int iEvaluateIntArg = evaluateIntArg(valueEvalArr[1], i, i2);
            int iEvaluateIntArg2 = evaluateIntArg(valueEvalArr[2], i, i2);
            int height = baseRefEvaluateBaseRef.getHeight();
            int width = baseRefEvaluateBaseRef.getWidth();
            int length = valueEvalArr.length;
            if (length == 4) {
                valueEval = valueEvalArr[3];
                if (!(valueEval instanceof MissingArgEval)) {
                    height = evaluateIntArg(valueEval, i, i2);
                }
            } else if (length == 5) {
                ValueEval valueEval2 = valueEvalArr[4];
                if (!(valueEval2 instanceof MissingArgEval)) {
                    width = evaluateIntArg(valueEval2, i, i2);
                }
                valueEval = valueEvalArr[3];
                if (!(valueEval instanceof MissingArgEval)) {
                    height = evaluateIntArg(valueEval, i, i2);
                }
            }
            if (height != 0 && width != 0) {
                return createOffset(baseRefEvaluateBaseRef, new LinearOffsetRange(iEvaluateIntArg, height), new LinearOffsetRange(iEvaluateIntArg2, width));
            }
            return ErrorEval.REF_INVALID;
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private static AreaEval createOffset(BaseRef baseRef, LinearOffsetRange linearOffsetRange, LinearOffsetRange linearOffsetRange2) throws EvaluationException {
        LinearOffsetRange linearOffsetRangeNormaliseAndTranslate = linearOffsetRange.normaliseAndTranslate(baseRef.getFirstRowIndex());
        LinearOffsetRange linearOffsetRangeNormaliseAndTranslate2 = linearOffsetRange2.normaliseAndTranslate(baseRef.getFirstColumnIndex());
        if (linearOffsetRangeNormaliseAndTranslate.isOutOfBounds(0, 65535)) {
            throw new EvaluationException(ErrorEval.REF_INVALID);
        }
        if (linearOffsetRangeNormaliseAndTranslate2.isOutOfBounds(0, 255)) {
            throw new EvaluationException(ErrorEval.REF_INVALID);
        }
        return baseRef.offset(linearOffsetRange.getFirstIndex(), linearOffsetRange.getLastIndex(), linearOffsetRange2.getFirstIndex(), linearOffsetRange2.getLastIndex());
    }

    private static BaseRef evaluateBaseRef(ValueEval valueEval) throws EvaluationException {
        if (valueEval instanceof RefEval) {
            return new BaseRef((RefEval) valueEval);
        }
        if (valueEval instanceof AreaEval) {
            return new BaseRef((AreaEval) valueEval);
        }
        if (valueEval instanceof ErrorEval) {
            throw new EvaluationException((ErrorEval) valueEval);
        }
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    }

    static int evaluateIntArg(ValueEval valueEval, int i, int i2) throws EvaluationException {
        return OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEval, i, i2));
    }
}
