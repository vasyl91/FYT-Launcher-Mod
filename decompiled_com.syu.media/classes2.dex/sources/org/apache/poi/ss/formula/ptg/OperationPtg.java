package org.apache.poi.ss.formula.ptg;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class OperationPtg extends Ptg {
    public static final int TYPE_BINARY = 1;
    public static final int TYPE_FUNCTION = 2;
    public static final int TYPE_UNARY = 0;

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getDefaultOperandClass() {
        return (byte) 32;
    }

    public abstract int getNumberOfOperands();

    public abstract String toFormulaString(String[] strArr);
}
