package org.apache.poi.ss.format;

import java.util.Locale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public enum CellFormatType {
    GENERAL { // from class: org.apache.poi.ss.format.CellFormatType.1
        @Override // org.apache.poi.ss.format.CellFormatType
        boolean isSpecial(char c) {
            return false;
        }

        @Override // org.apache.poi.ss.format.CellFormatType
        CellFormatter formatter(String str) {
            return new CellGeneralFormatter();
        }

        @Override // org.apache.poi.ss.format.CellFormatType
        CellFormatter formatter(Locale locale, String str) {
            return new CellGeneralFormatter(locale);
        }
    },
    NUMBER { // from class: org.apache.poi.ss.format.CellFormatType.2
        @Override // org.apache.poi.ss.format.CellFormatType
        boolean isSpecial(char c) {
            return false;
        }

        @Override // org.apache.poi.ss.format.CellFormatType
        CellFormatter formatter(String str) {
            return new CellNumberFormatter(str);
        }

        @Override // org.apache.poi.ss.format.CellFormatType
        CellFormatter formatter(Locale locale, String str) {
            return new CellNumberFormatter(locale, str);
        }
    },
    DATE { // from class: org.apache.poi.ss.format.CellFormatType.3
        @Override // org.apache.poi.ss.format.CellFormatType
        boolean isSpecial(char c) {
            return c == '\'' || (c <= 127 && Character.isLetter(c));
        }

        @Override // org.apache.poi.ss.format.CellFormatType
        CellFormatter formatter(String str) {
            return new CellDateFormatter(str);
        }

        @Override // org.apache.poi.ss.format.CellFormatType
        CellFormatter formatter(Locale locale, String str) {
            return new CellDateFormatter(locale, str);
        }
    },
    ELAPSED { // from class: org.apache.poi.ss.format.CellFormatType.4
        @Override // org.apache.poi.ss.format.CellFormatType
        boolean isSpecial(char c) {
            return false;
        }

        @Override // org.apache.poi.ss.format.CellFormatType
        CellFormatter formatter(String str) {
            return new CellElapsedFormatter(str);
        }

        @Override // org.apache.poi.ss.format.CellFormatType
        CellFormatter formatter(Locale locale, String str) {
            return new CellElapsedFormatter(str);
        }
    },
    TEXT { // from class: org.apache.poi.ss.format.CellFormatType.5
        @Override // org.apache.poi.ss.format.CellFormatType
        boolean isSpecial(char c) {
            return false;
        }

        @Override // org.apache.poi.ss.format.CellFormatType
        CellFormatter formatter(String str) {
            return new CellTextFormatter(str);
        }

        @Override // org.apache.poi.ss.format.CellFormatType
        CellFormatter formatter(Locale locale, String str) {
            return new CellTextFormatter(str);
        }
    };

    abstract CellFormatter formatter(String str);

    abstract CellFormatter formatter(Locale locale, String str);

    abstract boolean isSpecial(char c);
}
