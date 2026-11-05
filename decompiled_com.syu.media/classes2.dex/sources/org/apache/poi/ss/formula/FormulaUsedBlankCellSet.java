package org.apache.poi.ss.formula;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
final class FormulaUsedBlankCellSet {
    private final Map<BookSheetKey, BlankCellSheetGroup> _sheetGroupsByBookSheet = new HashMap();

    public static final class BookSheetKey {
        private final int _bookIndex;
        private final int _sheetIndex;

        public BookSheetKey(int i, int i2) {
            this._bookIndex = i;
            this._sheetIndex = i2;
        }

        public int hashCode() {
            return (this._bookIndex * 17) + this._sheetIndex;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof BookSheetKey)) {
                return false;
            }
            BookSheetKey bookSheetKey = (BookSheetKey) obj;
            return this._bookIndex == bookSheetKey._bookIndex && this._sheetIndex == bookSheetKey._sheetIndex;
        }
    }

    private static final class BlankCellSheetGroup {
        private BlankCellRectangleGroup _currentRectangleGroup;
        private int _firstColumnIndex;
        private int _lastColumnIndex;
        private final List<BlankCellRectangleGroup> _rectangleGroups = new ArrayList();
        private int _currentRowIndex = -1;

        public void addCell(int i, int i2) {
            int i3 = this._currentRowIndex;
            if (i3 == -1) {
                this._currentRowIndex = i;
                this._firstColumnIndex = i2;
                this._lastColumnIndex = i2;
            } else {
                if (i3 == i && this._lastColumnIndex + 1 == i2) {
                    this._lastColumnIndex = i2;
                    return;
                }
                BlankCellRectangleGroup blankCellRectangleGroup = this._currentRectangleGroup;
                if (blankCellRectangleGroup == null) {
                    this._currentRectangleGroup = new BlankCellRectangleGroup(this._currentRowIndex, this._firstColumnIndex, this._lastColumnIndex);
                } else if (!blankCellRectangleGroup.acceptRow(i3, this._firstColumnIndex, this._lastColumnIndex)) {
                    this._rectangleGroups.add(this._currentRectangleGroup);
                    this._currentRectangleGroup = new BlankCellRectangleGroup(this._currentRowIndex, this._firstColumnIndex, this._lastColumnIndex);
                }
                this._currentRowIndex = i;
                this._firstColumnIndex = i2;
                this._lastColumnIndex = i2;
            }
        }

        public boolean containsCell(int i, int i2) {
            for (int size = this._rectangleGroups.size() - 1; size >= 0; size--) {
                if (this._rectangleGroups.get(size).containsCell(i, i2)) {
                    return true;
                }
            }
            BlankCellRectangleGroup blankCellRectangleGroup = this._currentRectangleGroup;
            if (blankCellRectangleGroup != null && blankCellRectangleGroup.containsCell(i, i2)) {
                return true;
            }
            int i3 = this._currentRowIndex;
            return i3 != -1 && i3 == i && this._firstColumnIndex <= i2 && i2 <= this._lastColumnIndex;
        }
    }

    private static final class BlankCellRectangleGroup {
        private final int _firstColumnIndex;
        private final int _firstRowIndex;
        private final int _lastColumnIndex;
        private int _lastRowIndex;

        public BlankCellRectangleGroup(int i, int i2, int i3) {
            this._firstRowIndex = i;
            this._firstColumnIndex = i2;
            this._lastColumnIndex = i3;
            this._lastRowIndex = i;
        }

        public boolean containsCell(int i, int i2) {
            return i2 >= this._firstColumnIndex && i2 <= this._lastColumnIndex && i >= this._firstRowIndex && i <= this._lastRowIndex;
        }

        public boolean acceptRow(int i, int i2, int i3) {
            if (i2 != this._firstColumnIndex || i3 != this._lastColumnIndex || i != this._lastRowIndex + 1) {
                return false;
            }
            this._lastRowIndex = i;
            return true;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer(64);
            CellReference cellReference = new CellReference(this._firstRowIndex, this._firstColumnIndex, false, false);
            CellReference cellReference2 = new CellReference(this._lastRowIndex, this._lastColumnIndex, false, false);
            stringBuffer.append(getClass().getName());
            stringBuffer.append(" [").append(cellReference.formatAsString()).append(':').append(cellReference2.formatAsString()).append("]");
            return stringBuffer.toString();
        }
    }

    public void addCell(int i, int i2, int i3, int i4) {
        getSheetGroup(i, i2).addCell(i3, i4);
    }

    private BlankCellSheetGroup getSheetGroup(int i, int i2) {
        BookSheetKey bookSheetKey = new BookSheetKey(i, i2);
        BlankCellSheetGroup blankCellSheetGroup = this._sheetGroupsByBookSheet.get(bookSheetKey);
        if (blankCellSheetGroup != null) {
            return blankCellSheetGroup;
        }
        BlankCellSheetGroup blankCellSheetGroup2 = new BlankCellSheetGroup();
        this._sheetGroupsByBookSheet.put(bookSheetKey, blankCellSheetGroup2);
        return blankCellSheetGroup2;
    }

    public boolean containsCell(BookSheetKey bookSheetKey, int i, int i2) {
        BlankCellSheetGroup blankCellSheetGroup = this._sheetGroupsByBookSheet.get(bookSheetKey);
        if (blankCellSheetGroup == null) {
            return false;
        }
        return blankCellSheetGroup.containsCell(i, i2);
    }

    public boolean isEmpty() {
        return this._sheetGroupsByBookSheet.isEmpty();
    }
}
