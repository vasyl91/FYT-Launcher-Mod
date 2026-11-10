package org.apache.poi.ss.formula.ptg;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class ScalarConstantPtg extends Ptg {
    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public final byte getDefaultOperandClass() {
        return (byte) 32;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public final boolean isBaseToken() {
        return true;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append(getClass().getName()).append(" [");
        stringBuffer.append(toFormulaString());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
