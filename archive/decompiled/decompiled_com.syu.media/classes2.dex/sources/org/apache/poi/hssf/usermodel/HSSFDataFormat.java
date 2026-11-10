package org.apache.poi.hssf.usermodel;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.record.FormatRecord;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.DataFormat;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class HSSFDataFormat implements DataFormat {
    private static final String[] _builtinFormats = BuiltinFormats.getAll();
    private final Vector<String> _formats = new Vector<>();
    private boolean _movedBuiltins = false;
    private final InternalWorkbook _workbook;

    HSSFDataFormat(InternalWorkbook internalWorkbook) {
        this._workbook = internalWorkbook;
        for (FormatRecord formatRecord : internalWorkbook.getFormats()) {
            ensureFormatsSize(formatRecord.getIndexCode());
            this._formats.set(formatRecord.getIndexCode(), formatRecord.getFormatString());
        }
    }

    public static List<String> getBuiltinFormats() {
        return Arrays.asList(_builtinFormats);
    }

    public static short getBuiltinFormat(String str) {
        return (short) BuiltinFormats.getBuiltinFormat(str);
    }

    @Override // org.apache.poi.ss.usermodel.DataFormat
    public short getFormat(String str) {
        if (str.equalsIgnoreCase("TEXT")) {
            str = "@";
        }
        if (!this._movedBuiltins) {
            int i = 0;
            while (true) {
                String[] strArr = _builtinFormats;
                if (i >= strArr.length) {
                    break;
                }
                ensureFormatsSize(i);
                if (this._formats.get(i) == null) {
                    this._formats.set(i, strArr[i]);
                }
                i++;
            }
            this._movedBuiltins = true;
        }
        for (int i2 = 0; i2 < this._formats.size(); i2++) {
            if (str.equals(this._formats.get(i2))) {
                return (short) i2;
            }
        }
        short format = this._workbook.getFormat(str, true);
        ensureFormatsSize(format);
        this._formats.set(format, str);
        return format;
    }

    @Override // org.apache.poi.ss.usermodel.DataFormat
    public String getFormat(short s) {
        String str;
        if (this._movedBuiltins) {
            return this._formats.get(s);
        }
        if (s == -1) {
            return null;
        }
        String str2 = this._formats.size() > s ? this._formats.get(s) : null;
        String[] strArr = _builtinFormats;
        return (strArr.length <= s || (str = strArr[s]) == null || str2 != null) ? str2 : str;
    }

    public static String getBuiltinFormat(short s) {
        return BuiltinFormats.getBuiltinFormat(s);
    }

    public static int getNumberOfBuiltinBuiltinFormats() {
        return _builtinFormats.length;
    }

    private void ensureFormatsSize(int i) {
        if (this._formats.size() <= i) {
            this._formats.setSize(i + 1);
        }
    }
}
