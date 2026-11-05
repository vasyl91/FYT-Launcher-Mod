package org.apache.poi.ss.formula.ptg;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class GreaterThanPtg extends ValueOperatorPtg {
    private static final String GREATERTHAN = ">";
    public static final ValueOperatorPtg instance = new GreaterThanPtg();
    public static final byte sid = 13;

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public int getNumberOfOperands() {
        return 2;
    }

    @Override // org.apache.poi.ss.formula.ptg.ValueOperatorPtg
    protected byte getSid() {
        return (byte) 13;
    }

    private GreaterThanPtg() {
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public String toFormulaString(String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(strArr[0]);
        stringBuffer.append(GREATERTHAN);
        stringBuffer.append(strArr[1]);
        return stringBuffer.toString();
    }
}
