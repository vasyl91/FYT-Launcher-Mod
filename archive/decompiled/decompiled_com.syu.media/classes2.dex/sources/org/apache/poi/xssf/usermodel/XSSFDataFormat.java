package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.util.Removal;
import org.apache.poi.xssf.model.StylesTable;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFDataFormat implements DataFormat {
    private final StylesTable stylesSource;

    protected XSSFDataFormat(StylesTable stylesTable) {
        this.stylesSource = stylesTable;
    }

    @Override // org.apache.poi.ss.usermodel.DataFormat
    public short getFormat(String str) {
        int builtinFormat = BuiltinFormats.getBuiltinFormat(str);
        if (builtinFormat == -1) {
            builtinFormat = this.stylesSource.putNumberFormat(str);
        }
        return (short) builtinFormat;
    }

    @Override // org.apache.poi.ss.usermodel.DataFormat
    public String getFormat(short s) {
        String numberFormatAt = this.stylesSource.getNumberFormatAt(s);
        return numberFormatAt == null ? BuiltinFormats.getBuiltinFormat(s) : numberFormatAt;
    }

    @Removal(version = "3.18")
    public String getFormat(int i) {
        return getFormat((short) i);
    }

    public void putFormat(short s, String str) {
        this.stylesSource.putNumberFormat(s, str);
    }
}
