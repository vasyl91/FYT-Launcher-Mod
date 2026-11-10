package org.apache.poi.ss.formula.ptg;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class LessEqualPtg extends ValueOperatorPtg {
    public static final ValueOperatorPtg instance = new LessEqualPtg();
    public static final byte sid = 10;

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public int getNumberOfOperands() {
        return 2;
    }

    @Override // org.apache.poi.ss.formula.ptg.ValueOperatorPtg
    protected byte getSid() {
        return (byte) 10;
    }

    private LessEqualPtg() {
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public String toFormulaString(String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(strArr[0]);
        stringBuffer.append("<=");
        stringBuffer.append(strArr[1]);
        return stringBuffer.toString();
    }
}
