package org.apache.poi.ss.usermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class BuiltinFormats {
    public static final int FIRST_USER_DEFINED_FORMAT_INDEX = 164;
    private static final String[] _formats = {"General", "0", "0.00", "#,##0", "#,##0.00", "\"$\"#,##0_);(\"$\"#,##0)", "\"$\"#,##0_);[Red](\"$\"#,##0)", "\"$\"#,##0.00_);(\"$\"#,##0.00)", "\"$\"#,##0.00_);[Red](\"$\"#,##0.00)", "0%", "0.00%", "0.00E+00", "# ?/?", "# ??/??", "m/d/yy", "d-mmm-yy", "d-mmm", "mmm-yy", "h:mm AM/PM", "h:mm:ss AM/PM", "h:mm", "h:mm:ss", "m/d/yy h:mm", "reserved-0x17", "reserved-0x18", "reserved-0x19", "reserved-0x1A", "reserved-0x1B", "reserved-0x1C", "reserved-0x1D", "reserved-0x1E", "reserved-0x1F", "reserved-0x20", "reserved-0x21", "reserved-0x22", "reserved-0x23", "reserved-0x24", "#,##0_);(#,##0)", "#,##0_);[Red](#,##0)", "#,##0.00_);(#,##0.00)", "#,##0.00_);[Red](#,##0.00)", "_(* #,##0_);_(* (#,##0);_(* \"-\"_);_(@_)", "_(\"$\"* #,##0_);_(\"$\"* (#,##0);_(\"$\"* \"-\"_);_(@_)", "_(* #,##0.00_);_(* (#,##0.00);_(* \"-\"??_);_(@_)", "_(\"$\"* #,##0.00_);_(\"$\"* (#,##0.00);_(\"$\"* \"-\"??_);_(@_)", "mm:ss", "[h]:mm:ss", "mm:ss.0", "##0.0E+0", "@"};

    public static String[] getAll() {
        return (String[]) _formats.clone();
    }

    public static String getBuiltinFormat(int i) {
        if (i < 0) {
            return null;
        }
        String[] strArr = _formats;
        if (i >= strArr.length) {
            return null;
        }
        return strArr[i];
    }

    public static int getBuiltinFormat(String str) {
        if ("TEXT".equalsIgnoreCase(str)) {
            str = "@";
        }
        int i = -1;
        for (String str2 : _formats) {
            i++;
            if (str2.equals(str)) {
                return i;
            }
        }
        return -1;
    }
}
