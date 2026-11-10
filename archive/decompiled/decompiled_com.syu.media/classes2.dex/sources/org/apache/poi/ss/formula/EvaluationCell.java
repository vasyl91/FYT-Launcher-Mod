package org.apache.poi.ss.formula;

import org.apache.poi.ss.usermodel.CellType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface EvaluationCell {
    boolean getBooleanCellValue();

    int getCachedFormulaResultType();

    CellType getCachedFormulaResultTypeEnum();

    int getCellType();

    CellType getCellTypeEnum();

    int getColumnIndex();

    int getErrorCellValue();

    Object getIdentityKey();

    double getNumericCellValue();

    int getRowIndex();

    EvaluationSheet getSheet();

    String getStringCellValue();
}
