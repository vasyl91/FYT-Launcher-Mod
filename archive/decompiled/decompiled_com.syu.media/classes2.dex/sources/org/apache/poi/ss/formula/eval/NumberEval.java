package org.apache.poi.ss.formula.eval;

import org.apache.poi.ss.formula.ptg.IntPtg;
import org.apache.poi.ss.formula.ptg.NumberPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.util.NumberToTextConverter;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class NumberEval implements NumericValueEval, StringValueEval {
    public static final NumberEval ZERO = new NumberEval(0.0d);
    private String _stringValue;
    private final double _value;

    public NumberEval(Ptg ptg) {
        if (ptg == null) {
            throw new IllegalArgumentException("ptg must not be null");
        }
        if (ptg instanceof IntPtg) {
            this._value = ((IntPtg) ptg).getValue();
        } else {
            if (ptg instanceof NumberPtg) {
                this._value = ((NumberPtg) ptg).getValue();
                return;
            }
            throw new IllegalArgumentException("bad argument type (" + ptg.getClass().getName() + ")");
        }
    }

    public NumberEval(double d) {
        this._value = d;
    }

    @Override // org.apache.poi.ss.formula.eval.NumericValueEval
    public double getNumberValue() {
        return this._value;
    }

    @Override // org.apache.poi.ss.formula.eval.StringValueEval
    public String getStringValue() {
        if (this._stringValue == null) {
            this._stringValue = NumberToTextConverter.toText(this._value);
        }
        return this._stringValue;
    }

    public final String toString() {
        return getClass().getName() + " [" + getStringValue() + "]";
    }
}
