package org.apache.poi.ss.usermodel;

import org.apache.poi.ss.util.CellRangeAddressList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface DataValidationHelper {
    DataValidationConstraint createCustomConstraint(String str);

    DataValidationConstraint createDateConstraint(int i, String str, String str2, String str3);

    DataValidationConstraint createDecimalConstraint(int i, String str, String str2);

    DataValidationConstraint createExplicitListConstraint(String[] strArr);

    DataValidationConstraint createFormulaListConstraint(String str);

    DataValidationConstraint createIntegerConstraint(int i, String str, String str2);

    DataValidationConstraint createNumericConstraint(int i, int i2, String str, String str2);

    DataValidationConstraint createTextLengthConstraint(int i, String str, String str2);

    DataValidationConstraint createTimeConstraint(int i, String str, String str2);

    DataValidation createValidation(DataValidationConstraint dataValidationConstraint, CellRangeAddressList cellRangeAddressList);
}
