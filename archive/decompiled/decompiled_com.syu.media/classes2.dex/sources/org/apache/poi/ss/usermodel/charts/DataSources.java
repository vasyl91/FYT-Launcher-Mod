package org.apache.poi.ss.usermodel.charts;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DataSources {
    private DataSources() {
    }

    public static <T> ChartDataSource<T> fromArray(T[] tArr) {
        return new ArrayDataSource(tArr);
    }

    public static ChartDataSource<Number> fromNumericCellRange(Sheet sheet, CellRangeAddress cellRangeAddress) {
        return new AbstractCellRangeDataSource<Number>(sheet, cellRangeAddress) { // from class: org.apache.poi.ss.usermodel.charts.DataSources.1
            @Override // org.apache.poi.ss.usermodel.charts.ChartDataSource
            public boolean isNumeric() {
                return true;
            }

            @Override // org.apache.poi.ss.usermodel.charts.ChartDataSource
            public Number getPointAt(int i) {
                CellValue cellValueAt = getCellValueAt(i);
                if (cellValueAt == null || cellValueAt.getCellTypeEnum() != CellType.NUMERIC) {
                    return null;
                }
                return Double.valueOf(cellValueAt.getNumberValue());
            }
        };
    }

    public static ChartDataSource<String> fromStringCellRange(Sheet sheet, CellRangeAddress cellRangeAddress) {
        return new AbstractCellRangeDataSource<String>(sheet, cellRangeAddress) { // from class: org.apache.poi.ss.usermodel.charts.DataSources.2
            @Override // org.apache.poi.ss.usermodel.charts.ChartDataSource
            public boolean isNumeric() {
                return false;
            }

            @Override // org.apache.poi.ss.usermodel.charts.ChartDataSource
            public String getPointAt(int i) {
                CellValue cellValueAt = getCellValueAt(i);
                if (cellValueAt == null || cellValueAt.getCellTypeEnum() != CellType.STRING) {
                    return null;
                }
                return cellValueAt.getStringValue();
            }
        };
    }

    private static class ArrayDataSource<T> implements ChartDataSource<T> {
        private final T[] elements;

        @Override // org.apache.poi.ss.usermodel.charts.ChartDataSource
        public boolean isReference() {
            return false;
        }

        public ArrayDataSource(T[] tArr) {
            this.elements = (T[]) ((Object[]) tArr.clone());
        }

        @Override // org.apache.poi.ss.usermodel.charts.ChartDataSource
        public int getPointCount() {
            return this.elements.length;
        }

        @Override // org.apache.poi.ss.usermodel.charts.ChartDataSource
        public T getPointAt(int i) {
            return this.elements[i];
        }

        @Override // org.apache.poi.ss.usermodel.charts.ChartDataSource
        public boolean isNumeric() {
            return Number.class.isAssignableFrom(this.elements.getClass().getComponentType());
        }

        @Override // org.apache.poi.ss.usermodel.charts.ChartDataSource
        public String getFormulaString() {
            throw new UnsupportedOperationException("Literal data source can not be expressed by reference.");
        }
    }

    private static abstract class AbstractCellRangeDataSource<T> implements ChartDataSource<T> {
        private final CellRangeAddress cellRangeAddress;
        private FormulaEvaluator evaluator;
        private final int numOfCells;
        private final Sheet sheet;

        @Override // org.apache.poi.ss.usermodel.charts.ChartDataSource
        public boolean isReference() {
            return true;
        }

        protected AbstractCellRangeDataSource(Sheet sheet, CellRangeAddress cellRangeAddress) {
            this.sheet = sheet;
            CellRangeAddress cellRangeAddressCopy = cellRangeAddress.copy();
            this.cellRangeAddress = cellRangeAddressCopy;
            this.numOfCells = cellRangeAddressCopy.getNumberOfCells();
            this.evaluator = sheet.getWorkbook().getCreationHelper().createFormulaEvaluator();
        }

        @Override // org.apache.poi.ss.usermodel.charts.ChartDataSource
        public int getPointCount() {
            return this.numOfCells;
        }

        @Override // org.apache.poi.ss.usermodel.charts.ChartDataSource
        public String getFormulaString() {
            return this.cellRangeAddress.formatAsString(this.sheet.getSheetName(), true);
        }

        protected CellValue getCellValueAt(int i) {
            if (i < 0 || i >= this.numOfCells) {
                throw new IndexOutOfBoundsException("Index must be between 0 and " + (this.numOfCells - 1) + " (inclusive), given: " + i);
            }
            int firstRow = this.cellRangeAddress.getFirstRow();
            int firstColumn = this.cellRangeAddress.getFirstColumn();
            int lastColumn = (this.cellRangeAddress.getLastColumn() - firstColumn) + 1;
            int i2 = firstColumn + (i % lastColumn);
            Row row = this.sheet.getRow(firstRow + (i / lastColumn));
            if (row == null) {
                return null;
            }
            return this.evaluator.evaluate(row.getCell(i2));
        }
    }
}
