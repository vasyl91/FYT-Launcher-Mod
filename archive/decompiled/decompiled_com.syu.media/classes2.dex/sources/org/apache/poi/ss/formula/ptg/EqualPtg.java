package org.apache.poi.ss.formula.ptg;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class EqualPtg extends ValueOperatorPtg {
    public static final ValueOperatorPtg instance = new EqualPtg();
    public static final byte sid = 11;

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public int getNumberOfOperands() {
        return 2;
    }

    @Override // org.apache.poi.ss.formula.ptg.ValueOperatorPtg
    protected byte getSid() {
        return (byte) 11;
    }

    private EqualPtg() {
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public String toFormulaString(String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(strArr[0]);
        stringBuffer.append("=");
        stringBuffer.append(strArr[1]);
        return stringBuffer.toString();
    }
}
