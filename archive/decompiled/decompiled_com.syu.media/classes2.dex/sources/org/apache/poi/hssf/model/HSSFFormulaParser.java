package org.apache.poi.hssf.model;

import org.apache.poi.hssf.usermodel.HSSFEvaluationWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.FormulaParseException;
import org.apache.poi.ss.formula.FormulaParser;
import org.apache.poi.ss.formula.FormulaParsingWorkbook;
import org.apache.poi.ss.formula.FormulaRenderer;
import org.apache.poi.ss.formula.FormulaType;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public final class HSSFFormulaParser {
    private static FormulaParsingWorkbook createParsingWorkbook(HSSFWorkbook hSSFWorkbook) {
        return HSSFEvaluationWorkbook.create(hSSFWorkbook);
    }

    private HSSFFormulaParser() {
    }

    public static Ptg[] parse(String str, HSSFWorkbook hSSFWorkbook) throws FormulaParseException {
        return parse(str, hSSFWorkbook, FormulaType.CELL);
    }

    public static Ptg[] parse(String str, HSSFWorkbook hSSFWorkbook, FormulaType formulaType) throws FormulaParseException {
        return parse(str, hSSFWorkbook, formulaType, -1);
    }

    public static Ptg[] parse(String str, HSSFWorkbook hSSFWorkbook, FormulaType formulaType, int i) throws FormulaParseException {
        return FormulaParser.parse(str, createParsingWorkbook(hSSFWorkbook), formulaType, i);
    }

    public static String toFormulaString(HSSFWorkbook hSSFWorkbook, Ptg[] ptgArr) {
        return FormulaRenderer.toFormulaString(HSSFEvaluationWorkbook.create(hSSFWorkbook), ptgArr);
    }
}
