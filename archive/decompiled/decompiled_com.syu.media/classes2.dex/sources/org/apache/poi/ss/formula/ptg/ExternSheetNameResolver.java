package org.apache.poi.ss.formula.ptg;

import org.apache.poi.ss.formula.EvaluationWorkbook;
import org.apache.poi.ss.formula.FormulaRenderingWorkbook;
import org.apache.poi.ss.formula.SheetNameFormatter;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
final class ExternSheetNameResolver {
    private ExternSheetNameResolver() {
    }

    public static String prependSheetName(FormulaRenderingWorkbook formulaRenderingWorkbook, int i, String str) {
        StringBuffer stringBuffer;
        EvaluationWorkbook.ExternalSheet externalSheet = formulaRenderingWorkbook.getExternalSheet(i);
        if (externalSheet != null) {
            String workbookName = externalSheet.getWorkbookName();
            String sheetName = externalSheet.getSheetName();
            if (workbookName != null) {
                stringBuffer = new StringBuffer(workbookName.length() + sheetName.length() + str.length() + 4);
                SheetNameFormatter.appendFormat(stringBuffer, workbookName, sheetName);
            } else {
                stringBuffer = new StringBuffer(sheetName.length() + str.length() + 4);
                SheetNameFormatter.appendFormat(stringBuffer, sheetName);
            }
            if (externalSheet instanceof EvaluationWorkbook.ExternalSheetRange) {
                EvaluationWorkbook.ExternalSheetRange externalSheetRange = (EvaluationWorkbook.ExternalSheetRange) externalSheet;
                if (!externalSheetRange.getFirstSheetName().equals(externalSheetRange.getLastSheetName())) {
                    stringBuffer.append(':');
                    SheetNameFormatter.appendFormat(stringBuffer, externalSheetRange.getLastSheetName());
                }
            }
        } else {
            String sheetFirstNameByExternSheet = formulaRenderingWorkbook.getSheetFirstNameByExternSheet(i);
            String sheetLastNameByExternSheet = formulaRenderingWorkbook.getSheetLastNameByExternSheet(i);
            stringBuffer = new StringBuffer(sheetFirstNameByExternSheet.length() + str.length() + 4);
            if (sheetFirstNameByExternSheet.length() < 1) {
                stringBuffer.append("#REF");
            } else {
                SheetNameFormatter.appendFormat(stringBuffer, sheetFirstNameByExternSheet);
                if (!sheetFirstNameByExternSheet.equals(sheetLastNameByExternSheet)) {
                    stringBuffer.append(':');
                    stringBuffer.append(sheetLastNameByExternSheet);
                }
            }
        }
        stringBuffer.append('!');
        stringBuffer.append(str);
        return stringBuffer.toString();
    }
}
