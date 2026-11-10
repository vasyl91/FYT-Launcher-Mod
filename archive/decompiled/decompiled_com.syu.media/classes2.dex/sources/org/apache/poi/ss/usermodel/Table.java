package org.apache.poi.ss.usermodel;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface Table {
    public static final Pattern isStructuredReference = Pattern.compile("[a-zA-Z_\\\\][a-zA-Z0-9._]*\\[.*\\]");

    boolean contains(Cell cell);

    int findColumnIndex(String str);

    int getEndColIndex();

    int getEndRowIndex();

    int getHeaderRowCount();

    String getName();

    String getSheetName();

    int getStartColIndex();

    int getStartRowIndex();

    TableStyleInfo getStyle();

    String getStyleName();

    int getTotalsRowCount();

    boolean isHasTotalsRow();
}
