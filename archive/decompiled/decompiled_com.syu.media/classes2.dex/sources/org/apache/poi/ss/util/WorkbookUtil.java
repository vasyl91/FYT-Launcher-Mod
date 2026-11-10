package org.apache.poi.ss.util;

import org.apache.poi.util.Removal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class WorkbookUtil {
    public static final String createSafeSheetName(String str) {
        return createSafeSheetName(str, ' ');
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0050  */
    public static final String createSafeSheetName(String str, char c) {
        if (str == null) {
            return "null";
        }
        if (str.length() < 1) {
            return "empty";
        }
        int iMin = Math.min(31, str.length());
        StringBuilder sb = new StringBuilder(str.substring(0, iMin));
        for (int i = 0; i < iMin; i++) {
            char cCharAt = sb.charAt(i);
            if (cCharAt == 0 || cCharAt == 3) {
                sb.setCharAt(i, c);
            } else if (cCharAt != '\'') {
                if (cCharAt == '*' || cCharAt == '/' || cCharAt == ':' || cCharAt == '?') {
                    sb.setCharAt(i, c);
                } else {
                    switch (cCharAt) {
                        case '[':
                        case '\\':
                        case ']':
                            sb.setCharAt(i, c);
                            break;
                    }
                }
            } else if (i == 0 || i == iMin - 1) {
                sb.setCharAt(i, c);
            }
        }
        return sb.toString();
    }

    public static void validateSheetName(String str) {
        if (str == null) {
            throw new IllegalArgumentException("sheetName must not be null");
        }
        int length = str.length();
        if (length < 1 || length > 31) {
            throw new IllegalArgumentException("sheetName '" + str + "' is invalid - character count MUST be greater than or equal to 1 and less than or equal to 31");
        }
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '*' && cCharAt != '/' && cCharAt != ':' && cCharAt != '?') {
                switch (cCharAt) {
                    case '[':
                    case '\\':
                    case ']':
                        break;
                    default:
                        break;
                }
            }
            throw new IllegalArgumentException("Invalid char (" + cCharAt + ") found at index (" + i + ") in sheet name '" + str + "'");
        }
        if (str.charAt(0) == '\'' || str.charAt(length - 1) == '\'') {
            throw new IllegalArgumentException("Invalid sheet name '" + str + "'. Sheet names must not begin or end with (').");
        }
    }

    @Removal(version = "3.18")
    @Deprecated
    public static void validateSheetState(int i) {
        if (i != 0 && i != 1 && i != 2) {
            throw new IllegalArgumentException("Invalid sheet state : " + i + "\nSheet state must be one of the Workbook.SHEET_STATE_* constants");
        }
    }
}
