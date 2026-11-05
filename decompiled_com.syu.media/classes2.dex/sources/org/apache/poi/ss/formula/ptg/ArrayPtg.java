package org.apache.poi.ss.formula.ptg;

import java.lang.reflect.Array;
import org.apache.poi.ss.formula.constant.ConstantValueParser;
import org.apache.poi.ss.formula.constant.ErrorConstant;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ArrayPtg extends Ptg {
    public static final int PLAIN_TOKEN_SIZE = 8;
    private static final int RESERVED_FIELD_LEN = 7;
    public static final byte sid = 32;
    private final Object[] _arrayValues;
    private final int _nColumns;
    private final int _nRows;
    private final int _reserved0Int;
    private final int _reserved1Short;
    private final int _reserved2Byte;

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getDefaultOperandClass() {
        return Ptg.CLASS_ARRAY;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public boolean isBaseToken() {
        return false;
    }

    ArrayPtg(int i, int i2, int i3, int i4, int i5, Object[] objArr) {
        this._reserved0Int = i;
        this._reserved1Short = i2;
        this._reserved2Byte = i3;
        this._nColumns = i4;
        this._nRows = i5;
        this._arrayValues = (Object[]) objArr.clone();
    }

    public ArrayPtg(Object[][] objArr) {
        int length = objArr[0].length;
        int length2 = objArr.length;
        short s = (short) length;
        this._nColumns = s;
        short s2 = (short) length2;
        this._nRows = s2;
        Object[] objArr2 = new Object[s * s2];
        for (int i = 0; i < length2; i++) {
            Object[] objArr3 = objArr[i];
            for (int i2 = 0; i2 < length; i2++) {
                objArr2[getValueIndex(i2, i)] = objArr3[i2];
            }
        }
        this._arrayValues = objArr2;
        this._reserved0Int = 0;
        this._reserved1Short = 0;
        this._reserved2Byte = 0;
    }

    public Object[][] getTokenArrayValues() {
        if (this._arrayValues == null) {
            throw new IllegalStateException("array values not read yet");
        }
        Object[][] objArr = (Object[][]) Array.newInstance((Class<?>) Object.class, this._nRows, this._nColumns);
        for (int i = 0; i < this._nRows; i++) {
            Object[] objArr2 = objArr[i];
            for (int i2 = 0; i2 < this._nColumns; i2++) {
                objArr2[i2] = this._arrayValues[getValueIndex(i2, i)];
            }
        }
        return objArr;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[ArrayPtg]\nnRows = ");
        stringBuffer.append(getRowCount()).append("\nnCols = ");
        stringBuffer.append(getColumnCount()).append("\n");
        if (this._arrayValues == null) {
            stringBuffer.append("  #values#uninitialised#\n");
        } else {
            stringBuffer.append("  ").append(toFormulaString());
        }
        return stringBuffer.toString();
    }

    int getValueIndex(int i, int i2) {
        int i3;
        if (i < 0 || i >= (i3 = this._nColumns)) {
            throw new IllegalArgumentException("Specified colIx (" + i + ") is outside the allowed range (0.." + (this._nColumns - 1) + ")");
        }
        if (i2 < 0 || i2 >= this._nRows) {
            throw new IllegalArgumentException("Specified rowIx (" + i2 + ") is outside the allowed range (0.." + (this._nRows - 1) + ")");
        }
        return (i2 * i3) + i;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getPtgClass() + 32);
        littleEndianOutput.writeInt(this._reserved0Int);
        littleEndianOutput.writeShort(this._reserved1Short);
        littleEndianOutput.writeByte(this._reserved2Byte);
    }

    public int writeTokenValueBytes(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(this._nColumns - 1);
        littleEndianOutput.writeShort(this._nRows - 1);
        ConstantValueParser.encode(littleEndianOutput, this._arrayValues);
        return ConstantValueParser.getEncodedSize(this._arrayValues) + 3;
    }

    public int getRowCount() {
        return this._nRows;
    }

    public int getColumnCount() {
        return this._nColumns;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return ConstantValueParser.getEncodedSize(this._arrayValues) + 11;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        StringBuffer stringBuffer = new StringBuffer("{");
        for (int i = 0; i < this._nRows; i++) {
            if (i > 0) {
                stringBuffer.append(";");
            }
            for (int i2 = 0; i2 < this._nColumns; i2++) {
                if (i2 > 0) {
                    stringBuffer.append(",");
                }
                stringBuffer.append(getConstantText(this._arrayValues[getValueIndex(i2, i)]));
            }
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    private static String getConstantText(Object obj) {
        if (obj == null) {
            throw new RuntimeException("Array item cannot be null");
        }
        if (obj instanceof String) {
            return "\"" + ((String) obj) + "\"";
        }
        if (obj instanceof Double) {
            return NumberToTextConverter.toText(((Double) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue() ? "TRUE" : "FALSE";
        }
        if (obj instanceof ErrorConstant) {
            return ((ErrorConstant) obj).getText();
        }
        throw new IllegalArgumentException("Unexpected constant class (" + obj.getClass().getName() + ")");
    }

    static final class Initial extends Ptg {
        private final int _reserved0;
        private final int _reserved1;
        private final int _reserved2;

        @Override // org.apache.poi.ss.formula.ptg.Ptg
        public int getSize() {
            return 8;
        }

        @Override // org.apache.poi.ss.formula.ptg.Ptg
        public boolean isBaseToken() {
            return false;
        }

        public Initial(LittleEndianInput littleEndianInput) {
            this._reserved0 = littleEndianInput.readInt();
            this._reserved1 = littleEndianInput.readUShort();
            this._reserved2 = littleEndianInput.readUByte();
        }

        private static RuntimeException invalid() {
            throw new IllegalStateException("This object is a partially initialised tArray, and cannot be used as a Ptg");
        }

        @Override // org.apache.poi.ss.formula.ptg.Ptg
        public byte getDefaultOperandClass() {
            throw invalid();
        }

        @Override // org.apache.poi.ss.formula.ptg.Ptg
        public String toFormulaString() {
            throw invalid();
        }

        @Override // org.apache.poi.ss.formula.ptg.Ptg
        public void write(LittleEndianOutput littleEndianOutput) {
            throw invalid();
        }

        public ArrayPtg finishReading(LittleEndianInput littleEndianInput) {
            int uByte = littleEndianInput.readUByte() + 1;
            short s = (short) (littleEndianInput.readShort() + 1);
            ArrayPtg arrayPtg = new ArrayPtg(this._reserved0, this._reserved1, this._reserved2, uByte, s, ConstantValueParser.parse(littleEndianInput, s * uByte));
            arrayPtg.setClass(getPtgClass());
            return arrayPtg;
        }
    }
}
