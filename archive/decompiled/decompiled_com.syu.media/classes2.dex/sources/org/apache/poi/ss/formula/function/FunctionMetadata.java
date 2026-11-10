package org.apache.poi.ss.formula.function;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class FunctionMetadata {
    private static final short FUNCTION_MAX_PARAMS = 30;
    private final int _index;
    private final int _maxParams;
    private final int _minParams;
    private final String _name;
    private final byte[] _parameterClassCodes;
    private final byte _returnClassCode;

    FunctionMetadata(int i, String str, int i2, int i3, byte b, byte[] bArr) {
        this._index = i;
        this._name = str;
        this._minParams = i2;
        this._maxParams = i3;
        this._returnClassCode = b;
        this._parameterClassCodes = bArr == null ? null : (byte[]) bArr.clone();
    }

    public int getIndex() {
        return this._index;
    }

    public String getName() {
        return this._name;
    }

    public int getMinParams() {
        return this._minParams;
    }

    public int getMaxParams() {
        return this._maxParams;
    }

    public boolean hasFixedArgsLength() {
        return this._minParams == this._maxParams;
    }

    public byte getReturnClassCode() {
        return this._returnClassCode;
    }

    public byte[] getParameterClassCodes() {
        return (byte[]) this._parameterClassCodes.clone();
    }

    public boolean hasUnlimitedVarags() {
        return 30 == this._maxParams;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append(getClass().getName()).append(" [");
        stringBuffer.append(this._index).append(" ").append(this._name);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
