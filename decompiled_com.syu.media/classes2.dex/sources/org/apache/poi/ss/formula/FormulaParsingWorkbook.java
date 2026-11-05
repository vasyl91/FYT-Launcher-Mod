package org.apache.poi.ss.formula;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Table;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface FormulaParsingWorkbook {
    Name createName();

    Ptg get3DReferencePtg(AreaReference areaReference, SheetIdentifier sheetIdentifier);

    Ptg get3DReferencePtg(CellReference cellReference, SheetIdentifier sheetIdentifier);

    int getExternalSheetIndex(String str);

    int getExternalSheetIndex(String str, String str2);

    EvaluationName getName(String str, int i);

    Ptg getNameXPtg(String str, SheetIdentifier sheetIdentifier);

    SpreadsheetVersion getSpreadsheetVersion();

    Table getTable(String str);
}
