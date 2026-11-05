package org.apache.poi.hssf.usermodel;

import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.util.CellRangeAddressList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class HSSFDataValidationHelper implements DataValidationHelper {
    public HSSFDataValidationHelper(HSSFSheet hSSFSheet) {
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationHelper
    public DataValidationConstraint createDateConstraint(int i, String str, String str2, String str3) {
        return DVConstraint.createDateConstraint(i, str, str2, str3);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationHelper
    public DataValidationConstraint createExplicitListConstraint(String[] strArr) {
        return DVConstraint.createExplicitListConstraint(strArr);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationHelper
    public DataValidationConstraint createFormulaListConstraint(String str) {
        return DVConstraint.createFormulaListConstraint(str);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationHelper
    public DataValidationConstraint createNumericConstraint(int i, int i2, String str, String str2) {
        return DVConstraint.createNumericConstraint(i, i2, str, str2);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationHelper
    public DataValidationConstraint createIntegerConstraint(int i, String str, String str2) {
        return DVConstraint.createNumericConstraint(1, i, str, str2);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationHelper
    public DataValidationConstraint createDecimalConstraint(int i, String str, String str2) {
        return DVConstraint.createNumericConstraint(2, i, str, str2);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationHelper
    public DataValidationConstraint createTextLengthConstraint(int i, String str, String str2) {
        return DVConstraint.createNumericConstraint(6, i, str, str2);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationHelper
    public DataValidationConstraint createTimeConstraint(int i, String str, String str2) {
        return DVConstraint.createTimeConstraint(i, str, str2);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationHelper
    public DataValidationConstraint createCustomConstraint(String str) {
        return DVConstraint.createCustomFormulaConstraint(str);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationHelper
    public DataValidation createValidation(DataValidationConstraint dataValidationConstraint, CellRangeAddressList cellRangeAddressList) {
        return new HSSFDataValidation(cellRangeAddressList, dataValidationConstraint);
    }
}
