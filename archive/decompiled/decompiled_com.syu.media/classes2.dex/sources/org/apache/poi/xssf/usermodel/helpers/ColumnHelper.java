package org.apache.poi.xssf.usermodel.helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.util.CTColComparator;
import org.apache.poi.xssf.util.NumericRanges;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCol;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ColumnHelper {
    private CTWorksheet worksheet;

    public ColumnHelper(CTWorksheet cTWorksheet) {
        this.worksheet = cTWorksheet;
        cleanColumns();
    }

    public void cleanColumns() {
        TreeSet<CTCol> treeSet = new TreeSet<>((Comparator<? super CTCol>) CTColComparator.BY_MIN_MAX);
        CTCols cTColsNewInstance = CTCols.Factory.newInstance();
        CTCols[] colsArray = this.worksheet.getColsArray();
        int i = 0;
        while (i < colsArray.length) {
            for (CTCol cTCol : colsArray[i].getColArray()) {
                addCleanColIntoCols(cTColsNewInstance, cTCol, treeSet);
            }
            i++;
        }
        for (int i2 = i - 1; i2 >= 0; i2--) {
            this.worksheet.removeCols(i2);
        }
        cTColsNewInstance.setColArray((CTCol[]) treeSet.toArray(new CTCol[treeSet.size()]));
        this.worksheet.addNewCols();
        this.worksheet.setColsArray(0, cTColsNewInstance);
    }

    public CTCols addCleanColIntoCols(CTCols cTCols, CTCol cTCol) {
        TreeSet<CTCol> treeSet = new TreeSet<>((Comparator<? super CTCol>) CTColComparator.BY_MIN_MAX);
        treeSet.addAll(cTCols.getColList());
        addCleanColIntoCols(cTCols, cTCol, treeSet);
        cTCols.setColArray((CTCol[]) treeSet.toArray(new CTCol[0]));
        return cTCols;
    }

    private void addCleanColIntoCols(CTCols cTCols, CTCol cTCol, TreeSet<CTCol> treeSet) {
        List<CTCol> overlappingCols = getOverlappingCols(cTCol, treeSet);
        if (overlappingCols.isEmpty()) {
            treeSet.add(cloneCol(cTCols, cTCol));
            return;
        }
        treeSet.removeAll(overlappingCols);
        for (CTCol cTCol2 : overlappingCols) {
            long[] overlap = getOverlap(cTCol, cTCol2);
            CTCol cTColCloneCol = cloneCol(cTCols, cTCol2, overlap);
            setColumnAttributes(cTCol, cTColCloneCol);
            treeSet.add(cTColCloneCol);
            CTCol cTCol3 = cTCol2.getMin() < cTCol.getMin() ? cTCol2 : cTCol;
            long jMin = Math.min(cTCol2.getMin(), cTCol.getMin());
            long j = overlap[0] - 1;
            long[] jArr = {jMin, j};
            if (jMin <= j) {
                treeSet.add(cloneCol(cTCols, cTCol3, jArr));
            }
            CTCol cTCol4 = cTCol2.getMax() > cTCol.getMax() ? cTCol2 : cTCol;
            long jMax = Math.max(cTCol2.getMax(), cTCol.getMax());
            long[] jArr2 = {overlap[1] + 1, jMax};
            if (jArr2[0] <= jMax) {
                treeSet.add(cloneCol(cTCols, cTCol4, jArr2));
            }
        }
    }

    private CTCol cloneCol(CTCols cTCols, CTCol cTCol, long[] jArr) {
        CTCol cTColCloneCol = cloneCol(cTCols, cTCol);
        cTColCloneCol.setMin(jArr[0]);
        cTColCloneCol.setMax(jArr[1]);
        return cTColCloneCol;
    }

    private long[] getOverlap(CTCol cTCol, CTCol cTCol2) {
        return getOverlappingRange(cTCol, cTCol2);
    }

    private List<CTCol> getOverlappingCols(CTCol cTCol, TreeSet<CTCol> treeSet) {
        CTCol cTColLower = treeSet.lower(cTCol);
        TreeSet<CTCol> treeSetTailSet = treeSet;
        if (cTColLower != null) {
            treeSetTailSet = treeSet.tailSet(cTColLower, overlaps(cTColLower, cTCol));
        }
        ArrayList arrayList = new ArrayList();
        for (CTCol cTCol2 : treeSetTailSet) {
            if (!overlaps(cTCol, cTCol2)) {
                break;
            }
            arrayList.add(cTCol2);
        }
        return arrayList;
    }

    private boolean overlaps(CTCol cTCol, CTCol cTCol2) {
        return NumericRanges.getOverlappingType(toRange(cTCol), toRange(cTCol2)) != -1;
    }

    private long[] getOverlappingRange(CTCol cTCol, CTCol cTCol2) {
        return NumericRanges.getOverlappingRange(toRange(cTCol), toRange(cTCol2));
    }

    private long[] toRange(CTCol cTCol) {
        return new long[]{cTCol.getMin(), cTCol.getMax()};
    }

    public static void sortColumns(CTCols cTCols) {
        CTCol[] colArray = cTCols.getColArray();
        Arrays.sort(colArray, CTColComparator.BY_MIN_MAX);
        cTCols.setColArray(colArray);
    }

    public CTCol cloneCol(CTCols cTCols, CTCol cTCol) {
        CTCol cTColAddNewCol = cTCols.addNewCol();
        cTColAddNewCol.setMin(cTCol.getMin());
        cTColAddNewCol.setMax(cTCol.getMax());
        setColumnAttributes(cTCol, cTColAddNewCol);
        return cTColAddNewCol;
    }

    public CTCol getColumn(long j, boolean z) {
        return getColumn1Based(j + 1, z);
    }

    public CTCol getColumn1Based(long j, boolean z) {
        char c = 0;
        CTCols colsArray = this.worksheet.getColsArray(0);
        CTCol[] colArray = colsArray.getColArray();
        int length = colArray.length;
        int i = 0;
        while (i < length) {
            CTCol cTCol = colArray[i];
            long min = cTCol.getMin();
            long max = cTCol.getMax();
            if (min <= j && max >= j) {
                if (z) {
                    if (min < j) {
                        CTCol[] cTColArr = new CTCol[1];
                        cTColArr[c] = cTCol;
                        insertCol(colsArray, min, j - 1, cTColArr);
                    }
                    if (max > j) {
                        insertCol(colsArray, j + 1, max, new CTCol[]{cTCol});
                    }
                    cTCol.setMin(j);
                    cTCol.setMax(j);
                }
                return cTCol;
            }
            i++;
            c = c;
        }
        return null;
    }

    private CTCol insertCol(CTCols cTCols, long j, long j2, CTCol[] cTColArr) {
        return insertCol(cTCols, j, j2, cTColArr, false, null);
    }

    private CTCol insertCol(CTCols cTCols, long j, long j2, CTCol[] cTColArr, boolean z, CTCol cTCol) {
        if (!z && columnExists(cTCols, j, j2)) {
            return null;
        }
        CTCol cTColInsertNewCol = cTCols.insertNewCol(0);
        cTColInsertNewCol.setMin(j);
        cTColInsertNewCol.setMax(j2);
        for (CTCol cTCol2 : cTColArr) {
            setColumnAttributes(cTCol2, cTColInsertNewCol);
        }
        if (cTCol != null) {
            setColumnAttributes(cTCol, cTColInsertNewCol);
        }
        return cTColInsertNewCol;
    }

    public boolean columnExists(CTCols cTCols, long j) {
        return columnExists1Based(cTCols, j + 1);
    }

    private boolean columnExists1Based(CTCols cTCols, long j) {
        for (CTCol cTCol : cTCols.getColArray()) {
            if (cTCol.getMin() == j) {
                return true;
            }
        }
        return false;
    }

    public void setColumnAttributes(CTCol cTCol, CTCol cTCol2) {
        if (cTCol.isSetBestFit()) {
            cTCol2.setBestFit(cTCol.getBestFit());
        }
        if (cTCol.isSetCustomWidth()) {
            cTCol2.setCustomWidth(cTCol.getCustomWidth());
        }
        if (cTCol.isSetHidden()) {
            cTCol2.setHidden(cTCol.getHidden());
        }
        if (cTCol.isSetStyle()) {
            cTCol2.setStyle(cTCol.getStyle());
        }
        if (cTCol.isSetWidth()) {
            cTCol2.setWidth(cTCol.getWidth());
        }
        if (cTCol.isSetCollapsed()) {
            cTCol2.setCollapsed(cTCol.getCollapsed());
        }
        if (cTCol.isSetPhonetic()) {
            cTCol2.setPhonetic(cTCol.getPhonetic());
        }
        if (cTCol.isSetOutlineLevel()) {
            cTCol2.setOutlineLevel(cTCol.getOutlineLevel());
        }
        cTCol2.setCollapsed(cTCol.isSetCollapsed());
    }

    public void setColBestFit(long j, boolean z) {
        getOrCreateColumn1Based(j + 1, false).setBestFit(z);
    }

    public void setCustomWidth(long j, boolean z) {
        getOrCreateColumn1Based(j + 1, true).setCustomWidth(z);
    }

    public void setColWidth(long j, double d) {
        getOrCreateColumn1Based(j + 1, true).setWidth(d);
    }

    public void setColHidden(long j, boolean z) {
        getOrCreateColumn1Based(j + 1, true).setHidden(z);
    }

    protected CTCol getOrCreateColumn1Based(long j, boolean z) {
        CTCol column1Based = getColumn1Based(j, z);
        if (column1Based != null) {
            return column1Based;
        }
        CTCol cTColAddNewCol = this.worksheet.getColsArray(0).addNewCol();
        cTColAddNewCol.setMin(j);
        cTColAddNewCol.setMax(j);
        return cTColAddNewCol;
    }

    public void setColDefaultStyle(long j, CellStyle cellStyle) {
        setColDefaultStyle(j, cellStyle.getIndex());
    }

    public void setColDefaultStyle(long j, int i) {
        getOrCreateColumn1Based(j + 1, true).setStyle(i);
    }

    public int getColDefaultStyle(long j) {
        if (getColumn(j, false) != null) {
            return (int) getColumn(j, false).getStyle();
        }
        return -1;
    }

    private boolean columnExists(CTCols cTCols, long j, long j2) {
        for (CTCol cTCol : cTCols.getColArray()) {
            if (cTCol.getMin() == j && cTCol.getMax() == j2) {
                return true;
            }
        }
        return false;
    }

    public int getIndexOfColumn(CTCols cTCols, CTCol cTCol) {
        if (cTCols != null && cTCol != null) {
            int i = 0;
            for (CTCol cTCol2 : cTCols.getColArray()) {
                if (cTCol2.getMin() == cTCol.getMin() && cTCol2.getMax() == cTCol.getMax()) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }
}
