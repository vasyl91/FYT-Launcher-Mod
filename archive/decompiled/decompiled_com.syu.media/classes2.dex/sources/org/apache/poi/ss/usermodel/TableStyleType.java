package org.apache.poi.ss.usermodel;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public enum TableStyleType {
    wholeTable { // from class: org.apache.poi.ss.usermodel.TableStyleType.1
        @Override // org.apache.poi.ss.usermodel.TableStyleType
        CellRangeAddressBase getRange(Table table, Cell cell) {
            return new CellRangeAddress(table.getStartRowIndex(), table.getEndRowIndex(), table.getStartColIndex(), table.getEndColIndex());
        }
    },
    pageFieldLabels,
    pageFieldValues,
    firstColumnStripe { // from class: org.apache.poi.ss.usermodel.TableStyleType.2
        @Override // org.apache.poi.ss.usermodel.TableStyleType
        CellRangeAddressBase getRange(Table table, Cell cell) {
            int i;
            TableStyleInfo style = table.getStyle();
            if (!style.isShowColumnStripes()) {
                return null;
            }
            DifferentialStyleProvider style2 = style.getStyle().getStyle(firstColumnStripe);
            DifferentialStyleProvider style3 = style.getStyle().getStyle(secondColumnStripe);
            int iMax = style2 == null ? 1 : Math.max(1, style2.getStripeSize());
            int iMax2 = style3 != null ? Math.max(1, style3.getStripeSize()) : 1;
            int startColIndex = table.getStartColIndex();
            int i2 = startColIndex + iMax;
            int columnIndex = cell.getColumnIndex();
            while (startColIndex <= columnIndex) {
                if (columnIndex >= startColIndex && columnIndex <= (i = i2 - 1)) {
                    return new CellRangeAddress(table.getStartRowIndex(), table.getEndRowIndex(), startColIndex, i);
                }
                startColIndex = i2 + iMax2;
                i2 = startColIndex + iMax;
            }
            return null;
        }
    },
    secondColumnStripe { // from class: org.apache.poi.ss.usermodel.TableStyleType.3
        @Override // org.apache.poi.ss.usermodel.TableStyleType
        CellRangeAddressBase getRange(Table table, Cell cell) {
            int i;
            TableStyleInfo style = table.getStyle();
            if (!style.isShowColumnStripes()) {
                return null;
            }
            DifferentialStyleProvider style2 = style.getStyle().getStyle(firstColumnStripe);
            DifferentialStyleProvider style3 = style.getStyle().getStyle(secondColumnStripe);
            int iMax = style2 == null ? 1 : Math.max(1, style2.getStripeSize());
            int iMax2 = style3 == null ? 1 : Math.max(1, style3.getStripeSize());
            int startColIndex = table.getStartColIndex();
            int i2 = startColIndex + iMax;
            int columnIndex = cell.getColumnIndex();
            while (startColIndex <= columnIndex) {
                if (columnIndex >= i2 && columnIndex <= (i = (i2 + iMax2) - 1)) {
                    return new CellRangeAddress(table.getStartRowIndex(), table.getEndRowIndex(), i2, i);
                }
                startColIndex = i2 + iMax2;
                i2 = startColIndex + iMax;
            }
            return null;
        }
    },
    firstRowStripe { // from class: org.apache.poi.ss.usermodel.TableStyleType.4
        @Override // org.apache.poi.ss.usermodel.TableStyleType
        CellRangeAddressBase getRange(Table table, Cell cell) {
            int i;
            TableStyleInfo style = table.getStyle();
            if (!style.isShowRowStripes()) {
                return null;
            }
            DifferentialStyleProvider style2 = style.getStyle().getStyle(firstRowStripe);
            DifferentialStyleProvider style3 = style.getStyle().getStyle(secondRowStripe);
            int iMax = style2 == null ? 1 : Math.max(1, style2.getStripeSize());
            int iMax2 = style3 != null ? Math.max(1, style3.getStripeSize()) : 1;
            int startRowIndex = table.getStartRowIndex() + table.getHeaderRowCount();
            int i2 = startRowIndex + iMax;
            int rowIndex = cell.getRowIndex();
            while (startRowIndex <= rowIndex) {
                if (rowIndex >= startRowIndex && rowIndex <= (i = i2 - 1)) {
                    return new CellRangeAddress(startRowIndex, i, table.getStartColIndex(), table.getEndColIndex());
                }
                startRowIndex = i2 + iMax2;
                i2 = startRowIndex + iMax;
            }
            return null;
        }
    },
    secondRowStripe { // from class: org.apache.poi.ss.usermodel.TableStyleType.5
        @Override // org.apache.poi.ss.usermodel.TableStyleType
        CellRangeAddressBase getRange(Table table, Cell cell) {
            int i;
            TableStyleInfo style = table.getStyle();
            if (!style.isShowRowStripes()) {
                return null;
            }
            DifferentialStyleProvider style2 = style.getStyle().getStyle(firstRowStripe);
            DifferentialStyleProvider style3 = style.getStyle().getStyle(secondRowStripe);
            int iMax = style2 == null ? 1 : Math.max(1, style2.getStripeSize());
            int iMax2 = style3 == null ? 1 : Math.max(1, style3.getStripeSize());
            int startRowIndex = table.getStartRowIndex() + table.getHeaderRowCount();
            int i2 = startRowIndex + iMax;
            int rowIndex = cell.getRowIndex();
            while (startRowIndex <= rowIndex) {
                if (rowIndex >= i2 && rowIndex <= (i = (i2 + iMax2) - 1)) {
                    return new CellRangeAddress(i2, i, table.getStartColIndex(), table.getEndColIndex());
                }
                startRowIndex = i2 + iMax2;
                i2 = startRowIndex + iMax;
            }
            return null;
        }
    },
    lastColumn { // from class: org.apache.poi.ss.usermodel.TableStyleType.6
        @Override // org.apache.poi.ss.usermodel.TableStyleType
        CellRangeAddressBase getRange(Table table, Cell cell) {
            if (table.getStyle().isShowLastColumn()) {
                return new CellRangeAddress(table.getStartRowIndex(), table.getEndRowIndex(), table.getEndColIndex(), table.getEndColIndex());
            }
            return null;
        }
    },
    firstColumn { // from class: org.apache.poi.ss.usermodel.TableStyleType.7
        @Override // org.apache.poi.ss.usermodel.TableStyleType
        CellRangeAddressBase getRange(Table table, Cell cell) {
            if (table.getStyle().isShowFirstColumn()) {
                return new CellRangeAddress(table.getStartRowIndex(), table.getEndRowIndex(), table.getStartColIndex(), table.getStartColIndex());
            }
            return null;
        }
    },
    headerRow { // from class: org.apache.poi.ss.usermodel.TableStyleType.8
        @Override // org.apache.poi.ss.usermodel.TableStyleType
        CellRangeAddressBase getRange(Table table, Cell cell) {
            if (table.getHeaderRowCount() < 1) {
                return null;
            }
            return new CellRangeAddress(table.getStartRowIndex(), (table.getStartRowIndex() + table.getHeaderRowCount()) - 1, table.getStartColIndex(), table.getEndColIndex());
        }
    },
    totalRow { // from class: org.apache.poi.ss.usermodel.TableStyleType.9
        @Override // org.apache.poi.ss.usermodel.TableStyleType
        CellRangeAddressBase getRange(Table table, Cell cell) {
            if (table.getTotalsRowCount() < 1) {
                return null;
            }
            return new CellRangeAddress((table.getEndRowIndex() - table.getTotalsRowCount()) + 1, table.getEndRowIndex(), table.getStartColIndex(), table.getEndColIndex());
        }
    },
    firstHeaderCell { // from class: org.apache.poi.ss.usermodel.TableStyleType.10
        @Override // org.apache.poi.ss.usermodel.TableStyleType
        CellRangeAddressBase getRange(Table table, Cell cell) {
            if (table.getHeaderRowCount() < 1) {
                return null;
            }
            return new CellRangeAddress(table.getStartRowIndex(), table.getStartRowIndex(), table.getStartColIndex(), table.getStartColIndex());
        }
    },
    lastHeaderCell { // from class: org.apache.poi.ss.usermodel.TableStyleType.11
        @Override // org.apache.poi.ss.usermodel.TableStyleType
        CellRangeAddressBase getRange(Table table, Cell cell) {
            if (table.getHeaderRowCount() < 1) {
                return null;
            }
            return new CellRangeAddress(table.getStartRowIndex(), table.getStartRowIndex(), table.getEndColIndex(), table.getEndColIndex());
        }
    },
    firstTotalCell { // from class: org.apache.poi.ss.usermodel.TableStyleType.12
        @Override // org.apache.poi.ss.usermodel.TableStyleType
        CellRangeAddressBase getRange(Table table, Cell cell) {
            if (table.getTotalsRowCount() < 1) {
                return null;
            }
            return new CellRangeAddress((table.getEndRowIndex() - table.getTotalsRowCount()) + 1, table.getEndRowIndex(), table.getStartColIndex(), table.getStartColIndex());
        }
    },
    lastTotalCell { // from class: org.apache.poi.ss.usermodel.TableStyleType.13
        @Override // org.apache.poi.ss.usermodel.TableStyleType
        CellRangeAddressBase getRange(Table table, Cell cell) {
            if (table.getTotalsRowCount() < 1) {
                return null;
            }
            return new CellRangeAddress((table.getEndRowIndex() - table.getTotalsRowCount()) + 1, table.getEndRowIndex(), table.getEndColIndex(), table.getEndColIndex());
        }
    },
    firstSubtotalColumn,
    secondSubtotalColumn,
    thirdSubtotalColumn,
    blankRow,
    firstSubtotalRow,
    secondSubtotalRow,
    thirdSubtotalRow,
    firstColumnSubheading,
    secondColumnSubheading,
    thirdColumnSubheading,
    firstRowSubheading,
    secondRowSubheading,
    thirdRowSubheading;

    CellRangeAddressBase getRange(Table table, Cell cell) {
        return null;
    }

    public CellRangeAddressBase appliesTo(Table table, Cell cell) {
        CellRangeAddressBase range;
        if (table == null || cell == null || !cell.getSheet().getSheetName().equals(table.getSheetName()) || !table.contains(cell) || (range = getRange(table, cell)) == null || !range.isInRange(cell.getRowIndex(), cell.getColumnIndex())) {
            return null;
        }
        return range;
    }
}
