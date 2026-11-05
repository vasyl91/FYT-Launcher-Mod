package org.apache.poi.ss.formula.ptg;

import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class StringPtg extends ScalarConstantPtg {
    private static final char FORMULA_DELIMITER = '\"';
    public static final byte sid = 23;
    private final boolean _is16bitUnicode;
    private final String field_3_string;

    public StringPtg(LittleEndianInput littleEndianInput) {
        int uByte = littleEndianInput.readUByte();
        boolean z = (littleEndianInput.readByte() & 1) != 0;
        this._is16bitUnicode = z;
        if (z) {
            this.field_3_string = StringUtil.readUnicodeLE(littleEndianInput, uByte);
        } else {
            this.field_3_string = StringUtil.readCompressedUnicode(littleEndianInput, uByte);
        }
    }

    public StringPtg(String str) {
        if (str.length() > 255) {
            throw new IllegalArgumentException("String literals in formulas can't be bigger than 255 characters ASCII");
        }
        this._is16bitUnicode = StringUtil.hasMultibyte(str);
        this.field_3_string = str;
    }

    public String getValue() {
        return this.field_3_string;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getPtgClass() + sid);
        littleEndianOutput.writeByte(this.field_3_string.length());
        littleEndianOutput.writeByte(this._is16bitUnicode ? 1 : 0);
        if (this._is16bitUnicode) {
            StringUtil.putUnicodeLE(this.field_3_string, littleEndianOutput);
        } else {
            StringUtil.putCompressedUnicode(this.field_3_string, littleEndianOutput);
        }
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return (this.field_3_string.length() * (this._is16bitUnicode ? 2 : 1)) + 3;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        String str = this.field_3_string;
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length + 4);
        stringBuffer.append('\"');
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\"') {
                stringBuffer.append('\"');
            }
            stringBuffer.append(cCharAt);
        }
        stringBuffer.append('\"');
        return stringBuffer.toString();
    }
}
