package org.apache.poi.ss.usermodel;

import java.util.Iterator;
import org.apache.poi.ss.formula.ConditionalFormattingEvaluator;
import org.apache.poi.ss.formula.EvaluationConditionalFormatRule;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ExcelNumberFormat {
    private final String format;
    private final int idx;

    public static ExcelNumberFormat from(CellStyle cellStyle) {
        if (cellStyle == null) {
            return null;
        }
        return new ExcelNumberFormat(cellStyle.getDataFormat(), cellStyle.getDataFormatString());
    }

    public static ExcelNumberFormat from(Cell cell, ConditionalFormattingEvaluator conditionalFormattingEvaluator) {
        ExcelNumberFormat numberFormat = null;
        if (cell == null) {
            return null;
        }
        if (conditionalFormattingEvaluator != null) {
            Iterator<EvaluationConditionalFormatRule> it = conditionalFormattingEvaluator.getConditionalFormattingForCell(cell).iterator();
            while (it.hasNext() && (numberFormat = it.next().getNumberFormat()) == null) {
            }
        }
        return numberFormat == null ? from(cell.getCellStyle()) : numberFormat;
    }

    public ExcelNumberFormat(int i, String str) {
        this.idx = i;
        this.format = str;
    }

    public int getIdx() {
        return this.idx;
    }

    public String getFormat() {
        return this.format;
    }
}
