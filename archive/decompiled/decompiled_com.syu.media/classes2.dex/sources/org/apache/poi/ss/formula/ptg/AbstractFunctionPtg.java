package org.apache.poi.ss.formula.ptg;

import java.util.Locale;
import org.apache.poi.ss.formula.function.FunctionMetadata;
import org.apache.poi.ss.formula.function.FunctionMetadataRegistry;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class AbstractFunctionPtg extends OperationPtg {
    private static final short FUNCTION_INDEX_EXTERNAL = 255;
    public static final String FUNCTION_NAME_IF = "IF";
    private final short _functionIndex;
    private final int _numberOfArgs;
    private final byte[] paramClass;
    private final byte returnClass;

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public abstract int getSize();

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public final boolean isBaseToken() {
        return false;
    }

    protected AbstractFunctionPtg(int i, int i2, byte[] bArr, int i3) {
        this._numberOfArgs = i3;
        if (i < -32768 || i > 32767) {
            throw new RuntimeException("functionIndex " + i + " cannot be cast to short");
        }
        this._functionIndex = (short) i;
        if (i2 < -128 || i2 > 127) {
            throw new RuntimeException("pReturnClass " + i2 + " cannot be cast to byte");
        }
        this.returnClass = (byte) i2;
        this.paramClass = bArr;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public final String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(getClass().getName()).append(" [");
        sb.append(lookupName(this._functionIndex));
        sb.append(" nArgs=").append(this._numberOfArgs);
        sb.append("]");
        return sb.toString();
    }

    public final short getFunctionIndex() {
        return this._functionIndex;
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public final int getNumberOfOperands() {
        return this._numberOfArgs;
    }

    public final String getName() {
        return lookupName(this._functionIndex);
    }

    public final boolean isExternalFunction() {
        return this._functionIndex == 255;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public final String toFormulaString() {
        return getName();
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public String toFormulaString(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        if (isExternalFunction()) {
            sb.append(strArr[0]);
            appendArgs(sb, 1, strArr);
        } else {
            sb.append(getName());
            appendArgs(sb, 0, strArr);
        }
        return sb.toString();
    }

    private static void appendArgs(StringBuilder sb, int i, String[] strArr) {
        sb.append('(');
        for (int i2 = i; i2 < strArr.length; i2++) {
            if (i2 > i) {
                sb.append(',');
            }
            sb.append(strArr[i2]);
        }
        sb.append(")");
    }

    public static final boolean isBuiltInFunctionName(String str) {
        return FunctionMetadataRegistry.lookupIndexByName(str.toUpperCase(Locale.ROOT)) >= 0;
    }

    protected final String lookupName(short s) {
        if (s == 255) {
            return "#external#";
        }
        FunctionMetadata functionByIndex = FunctionMetadataRegistry.getFunctionByIndex(s);
        if (functionByIndex == null) {
            throw new RuntimeException("bad function index (" + ((int) s) + ")");
        }
        return functionByIndex.getName();
    }

    protected static short lookupIndex(String str) {
        short sLookupIndexByName = FunctionMetadataRegistry.lookupIndexByName(str.toUpperCase(Locale.ROOT));
        if (sLookupIndexByName < 0) {
            return (short) 255;
        }
        return sLookupIndexByName;
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg, org.apache.poi.ss.formula.ptg.Ptg
    public byte getDefaultOperandClass() {
        return this.returnClass;
    }

    public final byte getParameterClass(int i) {
        byte[] bArr = this.paramClass;
        if (i >= bArr.length) {
            return bArr[bArr.length - 1];
        }
        return bArr[i];
    }
}
