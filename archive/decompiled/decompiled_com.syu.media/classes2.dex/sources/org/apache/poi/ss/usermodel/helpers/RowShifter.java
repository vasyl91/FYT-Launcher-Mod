package org.apache.poi.ss.usermodel.helpers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.formula.FormulaShifter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class RowShifter {
    protected final Sheet sheet;

    public abstract void updateConditionalFormatting(FormulaShifter formulaShifter);

    public abstract void updateFormulas(FormulaShifter formulaShifter);

    public abstract void updateHyperlinks(FormulaShifter formulaShifter);

    public abstract void updateNamedRanges(FormulaShifter formulaShifter);

    @Internal
    public abstract void updateRowFormulas(Row row, FormulaShifter formulaShifter);

    public RowShifter(Sheet sheet) {
        this.sheet = sheet;
    }

    public List<CellRangeAddress> shiftMergedRegions(int i, int i2, int i3) {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        int numMergedRegions = this.sheet.getNumMergedRegions();
        for (int i4 = 0; i4 < numMergedRegions; i4++) {
            CellRangeAddress mergedRegion = this.sheet.getMergedRegion(i4);
            if (removalNeeded(mergedRegion, i, i2, i3)) {
                hashSet.add(Integer.valueOf(i4));
            } else {
                boolean z = true;
                boolean z2 = mergedRegion.getFirstRow() >= i || mergedRegion.getLastRow() >= i;
                if (mergedRegion.getFirstRow() > i2 && mergedRegion.getLastRow() > i2) {
                    z = false;
                }
                if (z2 && z && !mergedRegion.containsRow(i - 1) && !mergedRegion.containsRow(i2 + 1)) {
                    mergedRegion.setFirstRow(mergedRegion.getFirstRow() + i3);
                    mergedRegion.setLastRow(mergedRegion.getLastRow() + i3);
                    arrayList.add(mergedRegion);
                    hashSet.add(Integer.valueOf(i4));
                }
            }
        }
        if (!hashSet.isEmpty()) {
            this.sheet.removeMergedRegions(hashSet);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.sheet.addMergedRegion((CellRangeAddress) it.next());
        }
        return arrayList;
    }

    private boolean removalNeeded(CellRangeAddress cellRangeAddress, int i, int i2, int i3) {
        CellRangeAddress cellRangeAddress2;
        int i4 = (i2 - i) + 1;
        if (i3 > 0) {
            int i5 = i2 + 1;
            int i6 = i2 + i3;
            cellRangeAddress2 = new CellRangeAddress(Math.max(i5, i6 - i4), i6, 0, 0);
        } else {
            int i7 = i3 + i;
            cellRangeAddress2 = new CellRangeAddress(i7, Math.min(i - 1, i4 + i7), 0, 0);
        }
        return cellRangeAddress.intersects(cellRangeAddress2);
    }
}
