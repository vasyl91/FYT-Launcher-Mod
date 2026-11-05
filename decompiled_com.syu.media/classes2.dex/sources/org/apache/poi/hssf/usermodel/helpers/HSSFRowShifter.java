package org.apache.poi.hssf.usermodel.helpers;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.formula.FormulaShifter;
import org.apache.poi.ss.formula.eval.NotImplementedException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.helpers.RowShifter;
import org.apache.poi.util.Internal;
import org.apache.poi.util.NotImplemented;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class HSSFRowShifter extends RowShifter {
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) HSSFRowShifter.class);

    public HSSFRowShifter(HSSFSheet hSSFSheet) {
        super(hSSFSheet);
    }

    @Override // org.apache.poi.ss.usermodel.helpers.RowShifter
    @NotImplemented
    public void updateNamedRanges(FormulaShifter formulaShifter) {
        throw new NotImplementedException("HSSFRowShifter.updateNamedRanges");
    }

    @Override // org.apache.poi.ss.usermodel.helpers.RowShifter
    @NotImplemented
    public void updateFormulas(FormulaShifter formulaShifter) {
        throw new NotImplementedException("updateFormulas");
    }

    @Override // org.apache.poi.ss.usermodel.helpers.RowShifter
    @Internal
    @NotImplemented
    public void updateRowFormulas(Row row, FormulaShifter formulaShifter) {
        throw new NotImplementedException("updateRowFormulas");
    }

    @Override // org.apache.poi.ss.usermodel.helpers.RowShifter
    @NotImplemented
    public void updateConditionalFormatting(FormulaShifter formulaShifter) {
        throw new NotImplementedException("updateConditionalFormatting");
    }

    @Override // org.apache.poi.ss.usermodel.helpers.RowShifter
    @NotImplemented
    public void updateHyperlinks(FormulaShifter formulaShifter) {
        throw new NotImplementedException("updateHyperlinks");
    }
}
