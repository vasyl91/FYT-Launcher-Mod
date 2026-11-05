package org.apache.poi.ss.util;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class CellRangeUtil {
    public static final int ENCLOSES = 4;
    public static final int INSIDE = 3;
    public static final int NO_INTERSECTION = 1;
    public static final int OVERLAP = 2;

    private static boolean lt(int i, int i2) {
        if (i == -1) {
            return false;
        }
        return i2 == -1 || i < i2;
    }

    private CellRangeUtil() {
    }

    public static int intersect(CellRangeAddress cellRangeAddress, CellRangeAddress cellRangeAddress2) {
        int firstRow = cellRangeAddress2.getFirstRow();
        int lastRow = cellRangeAddress2.getLastRow();
        int firstColumn = cellRangeAddress2.getFirstColumn();
        int lastColumn = cellRangeAddress2.getLastColumn();
        if (gt(cellRangeAddress.getFirstRow(), lastRow) || lt(cellRangeAddress.getLastRow(), firstRow) || gt(cellRangeAddress.getFirstColumn(), lastColumn) || lt(cellRangeAddress.getLastColumn(), firstColumn)) {
            return 1;
        }
        if (contains(cellRangeAddress, cellRangeAddress2)) {
            return 3;
        }
        return contains(cellRangeAddress2, cellRangeAddress) ? 4 : 2;
    }

    public static CellRangeAddress[] mergeCellRanges(CellRangeAddress[] cellRangeAddressArr) {
        return cellRangeAddressArr.length < 1 ? new CellRangeAddress[0] : toArray(mergeCellRanges(toList(cellRangeAddressArr)));
    }

    private static List<CellRangeAddress> mergeCellRanges(List<CellRangeAddress> list) {
        while (list.size() > 1) {
            int i = 0;
            boolean z = false;
            while (i < list.size()) {
                CellRangeAddress cellRangeAddress = list.get(i);
                int i2 = i + 1;
                int i3 = i2;
                while (i3 < list.size()) {
                    CellRangeAddress[] cellRangeAddressArrMergeRanges = mergeRanges(cellRangeAddress, list.get(i3));
                    if (cellRangeAddressArrMergeRanges != null) {
                        list.set(i, cellRangeAddressArrMergeRanges[0]);
                        list.remove(i3);
                        i3--;
                        for (int i4 = 1; i4 < cellRangeAddressArrMergeRanges.length; i4++) {
                            i3++;
                            list.add(i3, cellRangeAddressArrMergeRanges[i4]);
                        }
                        z = true;
                    }
                    i3++;
                }
                i = i2;
            }
            if (!z) {
                break;
            }
        }
        return list;
    }

    private static CellRangeAddress[] mergeRanges(CellRangeAddress cellRangeAddress, CellRangeAddress cellRangeAddress2) {
        int iIntersect = intersect(cellRangeAddress, cellRangeAddress2);
        if (iIntersect == 1) {
            if (hasExactSharedBorder(cellRangeAddress, cellRangeAddress2)) {
                return new CellRangeAddress[]{createEnclosingCellRange(cellRangeAddress, cellRangeAddress2)};
            }
            return null;
        }
        if (iIntersect == 2) {
            return null;
        }
        if (iIntersect == 3) {
            return new CellRangeAddress[]{cellRangeAddress};
        }
        if (iIntersect == 4) {
            return new CellRangeAddress[]{cellRangeAddress2};
        }
        throw new RuntimeException("unexpected intersection result (" + iIntersect + ")");
    }

    private static CellRangeAddress[] toArray(List<CellRangeAddress> list) {
        CellRangeAddress[] cellRangeAddressArr = new CellRangeAddress[list.size()];
        list.toArray(cellRangeAddressArr);
        return cellRangeAddressArr;
    }

    private static List<CellRangeAddress> toList(CellRangeAddress[] cellRangeAddressArr) {
        ArrayList arrayList = new ArrayList(cellRangeAddressArr.length);
        for (CellRangeAddress cellRangeAddress : cellRangeAddressArr) {
            arrayList.add(cellRangeAddress);
        }
        return arrayList;
    }

    public static boolean contains(CellRangeAddress cellRangeAddress, CellRangeAddress cellRangeAddress2) {
        return le(cellRangeAddress.getFirstRow(), cellRangeAddress2.getFirstRow()) && ge(cellRangeAddress.getLastRow(), cellRangeAddress2.getLastRow()) && le(cellRangeAddress.getFirstColumn(), cellRangeAddress2.getFirstColumn()) && ge(cellRangeAddress.getLastColumn(), cellRangeAddress2.getLastColumn());
    }

    public static boolean hasExactSharedBorder(CellRangeAddress cellRangeAddress, CellRangeAddress cellRangeAddress2) {
        int firstRow = cellRangeAddress2.getFirstRow();
        int lastRow = cellRangeAddress2.getLastRow();
        int firstColumn = cellRangeAddress2.getFirstColumn();
        int lastColumn = cellRangeAddress2.getLastColumn();
        if ((cellRangeAddress.getFirstRow() <= 0 || cellRangeAddress.getFirstRow() - 1 != lastRow) && (firstRow <= 0 || firstRow - 1 != cellRangeAddress.getLastRow())) {
            return ((cellRangeAddress.getFirstColumn() > 0 && cellRangeAddress.getFirstColumn() - 1 == lastColumn) || (firstColumn > 0 && cellRangeAddress.getLastColumn() == firstColumn - 1)) && cellRangeAddress.getFirstRow() == firstRow && cellRangeAddress.getLastRow() == lastRow;
        }
        return cellRangeAddress.getFirstColumn() == firstColumn && cellRangeAddress.getLastColumn() == lastColumn;
    }

    public static CellRangeAddress createEnclosingCellRange(CellRangeAddress cellRangeAddress, CellRangeAddress cellRangeAddress2) {
        if (cellRangeAddress2 == null) {
            return cellRangeAddress.copy();
        }
        return new CellRangeAddress(lt(cellRangeAddress2.getFirstRow(), cellRangeAddress.getFirstRow()) ? cellRangeAddress2.getFirstRow() : cellRangeAddress.getFirstRow(), gt(cellRangeAddress2.getLastRow(), cellRangeAddress.getLastRow()) ? cellRangeAddress2.getLastRow() : cellRangeAddress.getLastRow(), lt(cellRangeAddress2.getFirstColumn(), cellRangeAddress.getFirstColumn()) ? cellRangeAddress2.getFirstColumn() : cellRangeAddress.getFirstColumn(), gt(cellRangeAddress2.getLastColumn(), cellRangeAddress.getLastColumn()) ? cellRangeAddress2.getLastColumn() : cellRangeAddress.getLastColumn());
    }

    private static boolean le(int i, int i2) {
        return i == i2 || lt(i, i2);
    }

    private static boolean gt(int i, int i2) {
        return lt(i2, i);
    }

    private static boolean ge(int i, int i2) {
        return !lt(i, i2);
    }
}
