package org.apache.poi.ss.formula.functions;

import java.util.regex.Pattern;
import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
final class LookupUtils {

    public interface LookupValueComparer {
        CompareResult compareTo(ValueEval valueEval);
    }

    public interface ValueVector {
        ValueEval getItem(int i);

        int getSize();
    }

    LookupUtils() {
    }

    private static final class RowVector implements ValueVector {
        private final int _rowIndex;
        private final int _size;
        private final TwoDEval _tableArray;

        public RowVector(TwoDEval twoDEval, int i) {
            this._rowIndex = i;
            int height = twoDEval.getHeight() - 1;
            if (i < 0 || i > height) {
                throw new IllegalArgumentException("Specified row index (" + i + ") is outside the allowed range (0.." + height + ")");
            }
            this._tableArray = twoDEval;
            this._size = twoDEval.getWidth();
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.ValueVector
        public ValueEval getItem(int i) {
            if (i > this._size) {
                throw new ArrayIndexOutOfBoundsException("Specified index (" + i + ") is outside the allowed range (0.." + (this._size - 1) + ")");
            }
            return this._tableArray.getValue(this._rowIndex, i);
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.ValueVector
        public int getSize() {
            return this._size;
        }
    }

    private static final class ColumnVector implements ValueVector {
        private final int _columnIndex;
        private final int _size;
        private final TwoDEval _tableArray;

        public ColumnVector(TwoDEval twoDEval, int i) {
            this._columnIndex = i;
            int width = twoDEval.getWidth() - 1;
            if (i < 0 || i > width) {
                throw new IllegalArgumentException("Specified column index (" + i + ") is outside the allowed range (0.." + width + ")");
            }
            this._tableArray = twoDEval;
            this._size = twoDEval.getHeight();
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.ValueVector
        public ValueEval getItem(int i) {
            if (i > this._size) {
                throw new ArrayIndexOutOfBoundsException("Specified index (" + i + ") is outside the allowed range (0.." + (this._size - 1) + ")");
            }
            return this._tableArray.getValue(i, this._columnIndex);
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.ValueVector
        public int getSize() {
            return this._size;
        }
    }

    private static final class SheetVector implements ValueVector {
        private final RefEval _re;
        private final int _size;

        public SheetVector(RefEval refEval) {
            this._size = refEval.getNumberOfSheets();
            this._re = refEval;
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.ValueVector
        public ValueEval getItem(int i) {
            if (i >= this._size) {
                throw new ArrayIndexOutOfBoundsException("Specified index (" + i + ") is outside the allowed range (0.." + (this._size - 1) + ")");
            }
            return this._re.getInnerValueEval(this._re.getFirstSheetIndex() + i);
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.ValueVector
        public int getSize() {
            return this._size;
        }
    }

    public static ValueVector createRowVector(TwoDEval twoDEval, int i) {
        return new RowVector(twoDEval, i);
    }

    public static ValueVector createColumnVector(TwoDEval twoDEval, int i) {
        return new ColumnVector(twoDEval, i);
    }

    public static ValueVector createVector(TwoDEval twoDEval) {
        if (twoDEval.isColumn()) {
            return createColumnVector(twoDEval, 0);
        }
        if (twoDEval.isRow()) {
            return createRowVector(twoDEval, 0);
        }
        return null;
    }

    public static ValueVector createVector(RefEval refEval) {
        return new SheetVector(refEval);
    }

    public static final class CompareResult {
        private final boolean _isEqual;
        private final boolean _isGreaterThan;
        private final boolean _isLessThan;
        private final boolean _isTypeMismatch;
        public static final CompareResult TYPE_MISMATCH = new CompareResult(true, 0);
        public static final CompareResult LESS_THAN = new CompareResult(false, -1);
        public static final CompareResult EQUAL = new CompareResult(false, 0);
        public static final CompareResult GREATER_THAN = new CompareResult(false, 1);

        private CompareResult(boolean z, int i) {
            if (z) {
                this._isTypeMismatch = true;
                this._isLessThan = false;
                this._isEqual = false;
                this._isGreaterThan = false;
                return;
            }
            this._isTypeMismatch = false;
            this._isLessThan = i < 0;
            this._isEqual = i == 0;
            this._isGreaterThan = i > 0;
        }

        public static CompareResult valueOf(int i) {
            if (i < 0) {
                return LESS_THAN;
            }
            if (i > 0) {
                return GREATER_THAN;
            }
            return EQUAL;
        }

        public static CompareResult valueOf(boolean z) {
            if (z) {
                return EQUAL;
            }
            return LESS_THAN;
        }

        public boolean isTypeMismatch() {
            return this._isTypeMismatch;
        }

        public boolean isLessThan() {
            return this._isLessThan;
        }

        public boolean isEqual() {
            return this._isEqual;
        }

        public boolean isGreaterThan() {
            return this._isGreaterThan;
        }

        public String toString() {
            return getClass().getName() + " [" + formatAsString() + "]";
        }

        private String formatAsString() {
            if (this._isTypeMismatch) {
                return "TYPE_MISMATCH";
            }
            if (this._isLessThan) {
                return "LESS_THAN";
            }
            if (this._isEqual) {
                return "EQUAL";
            }
            return this._isGreaterThan ? "GREATER_THAN" : "??error??";
        }
    }

    private static abstract class LookupValueComparerBase implements LookupValueComparer {
        private final Class<? extends ValueEval> _targetClass;

        protected abstract CompareResult compareSameType(ValueEval valueEval);

        protected abstract String getValueAsString();

        protected LookupValueComparerBase(ValueEval valueEval) {
            if (valueEval == null) {
                throw new RuntimeException("targetValue cannot be null");
            }
            this._targetClass = valueEval.getClass();
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.LookupValueComparer
        public final CompareResult compareTo(ValueEval valueEval) {
            if (valueEval == null) {
                throw new RuntimeException("compare to value cannot be null");
            }
            if (this._targetClass != valueEval.getClass()) {
                return CompareResult.TYPE_MISMATCH;
            }
            return compareSameType(valueEval);
        }

        public String toString() {
            return getClass().getName() + " [" + getValueAsString() + "]";
        }
    }

    private static final class StringLookupComparer extends LookupValueComparerBase {
        private boolean _isMatchFunction;
        private boolean _matchExact;
        private String _value;
        private final Pattern _wildCardPattern;

        protected StringLookupComparer(StringEval stringEval, boolean z, boolean z2) {
            super(stringEval);
            String stringValue = stringEval.getStringValue();
            this._value = stringValue;
            this._wildCardPattern = Countif.StringMatcher.getWildCardPattern(stringValue);
            this._matchExact = z;
            this._isMatchFunction = z2;
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.LookupValueComparerBase
        protected CompareResult compareSameType(ValueEval valueEval) {
            String stringValue = ((StringEval) valueEval).getStringValue();
            Pattern pattern = this._wildCardPattern;
            if (pattern != null) {
                boolean zMatches = pattern.matcher(stringValue).matches();
                if (this._isMatchFunction || !this._matchExact) {
                    return CompareResult.valueOf(zMatches);
                }
            }
            return CompareResult.valueOf(this._value.compareToIgnoreCase(stringValue));
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.LookupValueComparerBase
        protected String getValueAsString() {
            return this._value;
        }
    }

    private static final class NumberLookupComparer extends LookupValueComparerBase {
        private double _value;

        protected NumberLookupComparer(NumberEval numberEval) {
            super(numberEval);
            this._value = numberEval.getNumberValue();
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.LookupValueComparerBase
        protected CompareResult compareSameType(ValueEval valueEval) {
            return CompareResult.valueOf(Double.compare(this._value, ((NumberEval) valueEval).getNumberValue()));
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.LookupValueComparerBase
        protected String getValueAsString() {
            return String.valueOf(this._value);
        }
    }

    private static final class BooleanLookupComparer extends LookupValueComparerBase {
        private boolean _value;

        protected BooleanLookupComparer(BoolEval boolEval) {
            super(boolEval);
            this._value = boolEval.getBooleanValue();
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.LookupValueComparerBase
        protected CompareResult compareSameType(ValueEval valueEval) {
            boolean booleanValue = ((BoolEval) valueEval).getBooleanValue();
            boolean z = this._value;
            if (z == booleanValue) {
                return CompareResult.EQUAL;
            }
            if (z) {
                return CompareResult.GREATER_THAN;
            }
            return CompareResult.LESS_THAN;
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.LookupValueComparerBase
        protected String getValueAsString() {
            return String.valueOf(this._value);
        }
    }

    public static int resolveRowOrColIndexArg(ValueEval valueEval, int i, int i2) throws EvaluationException {
        if (valueEval == null) {
            throw new IllegalArgumentException("argument must not be null");
        }
        try {
            ValueEval singleValue = OperandResolver.getSingleValue(valueEval, i, (short) i2);
            if ((singleValue instanceof StringEval) && OperandResolver.parseDouble(((StringEval) singleValue).getStringValue()) == null) {
                throw EvaluationException.invalidRef();
            }
            int iCoerceValueToInt = OperandResolver.coerceValueToInt(singleValue);
            if (iCoerceValueToInt >= 1) {
                return iCoerceValueToInt - 1;
            }
            throw EvaluationException.invalidValue();
        } catch (EvaluationException unused) {
            throw EvaluationException.invalidRef();
        }
    }

    public static TwoDEval resolveTableArrayArg(ValueEval valueEval) throws EvaluationException {
        if (valueEval instanceof TwoDEval) {
            return (TwoDEval) valueEval;
        }
        if (valueEval instanceof RefEval) {
            return ((RefEval) valueEval).offset(0, 0, 0, 0);
        }
        throw EvaluationException.invalidValue();
    }

    public static boolean resolveRangeLookupArg(ValueEval valueEval, int i, int i2) throws EvaluationException {
        ValueEval singleValue = OperandResolver.getSingleValue(valueEval, i, i2);
        if (singleValue instanceof BlankEval) {
            return false;
        }
        if (singleValue instanceof BoolEval) {
            return ((BoolEval) singleValue).getBooleanValue();
        }
        if (singleValue instanceof StringEval) {
            String stringValue = ((StringEval) singleValue).getStringValue();
            if (stringValue.length() < 1) {
                throw EvaluationException.invalidValue();
            }
            Boolean bool = Countif.parseBoolean(stringValue);
            if (bool != null) {
                return bool.booleanValue();
            }
            throw EvaluationException.invalidValue();
        }
        if (singleValue instanceof NumericValueEval) {
            return 0.0d != ((NumericValueEval) singleValue).getNumberValue();
        }
        throw new RuntimeException("Unexpected eval type (" + singleValue + ")");
    }

    public static int lookupIndexOfValue(ValueEval valueEval, ValueVector valueVector, boolean z) throws EvaluationException {
        int iLookupIndexOfExactValue;
        LookupValueComparer lookupValueComparerCreateLookupComparer = createLookupComparer(valueEval, z, false);
        if (z) {
            iLookupIndexOfExactValue = performBinarySearch(valueVector, lookupValueComparerCreateLookupComparer);
        } else {
            iLookupIndexOfExactValue = lookupIndexOfExactValue(lookupValueComparerCreateLookupComparer, valueVector);
        }
        if (iLookupIndexOfExactValue >= 0) {
            return iLookupIndexOfExactValue;
        }
        throw new EvaluationException(ErrorEval.NA);
    }

    private static int lookupIndexOfExactValue(LookupValueComparer lookupValueComparer, ValueVector valueVector) {
        int size = valueVector.getSize();
        for (int i = 0; i < size; i++) {
            if (lookupValueComparer.compareTo(valueVector.getItem(i)).isEqual()) {
                return i;
            }
        }
        return -1;
    }

    private static final class BinarySearchIndexes {
        private int _highIx;
        private int _lowIx = -1;

        public BinarySearchIndexes(int i) {
            this._highIx = i;
        }

        public int getMidIx() {
            int i = this._highIx;
            int i2 = this._lowIx;
            int i3 = i - i2;
            if (i3 < 2) {
                return -1;
            }
            return i2 + (i3 / 2);
        }

        public int getLowIx() {
            return this._lowIx;
        }

        public int getHighIx() {
            return this._highIx;
        }

        public void narrowSearch(int i, boolean z) {
            if (z) {
                this._highIx = i;
            } else {
                this._lowIx = i;
            }
        }
    }

    private static int performBinarySearch(ValueVector valueVector, LookupValueComparer lookupValueComparer) {
        BinarySearchIndexes binarySearchIndexes = new BinarySearchIndexes(valueVector.getSize());
        while (true) {
            int midIx = binarySearchIndexes.getMidIx();
            if (midIx < 0) {
                return binarySearchIndexes.getLowIx();
            }
            CompareResult compareResultCompareTo = lookupValueComparer.compareTo(valueVector.getItem(midIx));
            if (compareResultCompareTo.isTypeMismatch()) {
                midIx = handleMidValueTypeMismatch(lookupValueComparer, valueVector, binarySearchIndexes, midIx);
                if (midIx < 0) {
                    continue;
                } else {
                    compareResultCompareTo = lookupValueComparer.compareTo(valueVector.getItem(midIx));
                }
            }
            if (compareResultCompareTo.isEqual()) {
                return findLastIndexInRunOfEqualValues(lookupValueComparer, valueVector, midIx, binarySearchIndexes.getHighIx());
            }
            binarySearchIndexes.narrowSearch(midIx, compareResultCompareTo.isLessThan());
        }
    }

    private static int handleMidValueTypeMismatch(LookupValueComparer lookupValueComparer, ValueVector valueVector, BinarySearchIndexes binarySearchIndexes, int i) {
        CompareResult compareResultCompareTo;
        int highIx = binarySearchIndexes.getHighIx();
        int i2 = i;
        do {
            i2++;
            if (i2 == highIx) {
                binarySearchIndexes.narrowSearch(i, true);
                return -1;
            }
            compareResultCompareTo = lookupValueComparer.compareTo(valueVector.getItem(i2));
            if (compareResultCompareTo.isLessThan() && i2 == highIx - 1) {
                binarySearchIndexes.narrowSearch(i, true);
                return -1;
            }
        } while (compareResultCompareTo.isTypeMismatch());
        if (compareResultCompareTo.isEqual()) {
            return i2;
        }
        binarySearchIndexes.narrowSearch(i2, compareResultCompareTo.isLessThan());
        return -1;
    }

    private static int findLastIndexInRunOfEqualValues(LookupValueComparer lookupValueComparer, ValueVector valueVector, int i, int i2) {
        do {
            i++;
            if (i >= i2) {
                return i2 - 1;
            }
        } while (lookupValueComparer.compareTo(valueVector.getItem(i)).isEqual());
        return i - 1;
    }

    public static LookupValueComparer createLookupComparer(ValueEval valueEval, boolean z, boolean z2) {
        if (valueEval == BlankEval.instance) {
            return new NumberLookupComparer(NumberEval.ZERO);
        }
        if (valueEval instanceof StringEval) {
            return new StringLookupComparer((StringEval) valueEval, z, z2);
        }
        if (valueEval instanceof NumberEval) {
            return new NumberLookupComparer((NumberEval) valueEval);
        }
        if (valueEval instanceof BoolEval) {
            return new BooleanLookupComparer((BoolEval) valueEval);
        }
        throw new IllegalArgumentException("Bad lookup value type (" + valueEval.getClass().getName() + ")");
    }
}
