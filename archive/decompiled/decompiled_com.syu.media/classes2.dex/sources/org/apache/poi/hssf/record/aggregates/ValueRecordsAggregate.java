package org.apache.poi.hssf.record.aggregates;

import java.util.Iterator;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.BlankRecord;
import org.apache.poi.hssf.record.CellValueRecordInterface;
import org.apache.poi.hssf.record.FormulaRecord;
import org.apache.poi.hssf.record.MulBlankRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordBase;
import org.apache.poi.hssf.record.StringRecord;
import org.apache.poi.ss.formula.FormulaShifter;
import org.apache.poi.ss.formula.ptg.Ptg;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ValueRecordsAggregate implements Iterable<CellValueRecordInterface> {
    private static final int INDEX_NOT_SET = -1;
    private static final int MAX_ROW_INDEX = 65535;
    private int firstcell;
    private int lastcell;
    private CellValueRecordInterface[][] records;

    public ValueRecordsAggregate() {
        this(-1, -1, new CellValueRecordInterface[30][]);
    }

    private ValueRecordsAggregate(int i, int i2, CellValueRecordInterface[][] cellValueRecordInterfaceArr) {
        this.firstcell = i;
        this.lastcell = i2;
        this.records = cellValueRecordInterfaceArr;
    }

    public void insertCell(CellValueRecordInterface cellValueRecordInterface) {
        short column = cellValueRecordInterface.getColumn();
        int row = cellValueRecordInterface.getRow();
        CellValueRecordInterface[][] cellValueRecordInterfaceArr = this.records;
        if (row >= cellValueRecordInterfaceArr.length) {
            int length = cellValueRecordInterfaceArr.length * 2;
            int i = row + 1;
            if (length < i) {
                length = i;
            }
            CellValueRecordInterface[][] cellValueRecordInterfaceArr2 = new CellValueRecordInterface[length][];
            this.records = cellValueRecordInterfaceArr2;
            System.arraycopy(cellValueRecordInterfaceArr, 0, cellValueRecordInterfaceArr2, 0, cellValueRecordInterfaceArr.length);
        }
        CellValueRecordInterface[][] cellValueRecordInterfaceArr3 = this.records;
        CellValueRecordInterface[] cellValueRecordInterfaceArr4 = cellValueRecordInterfaceArr3[row];
        if (cellValueRecordInterfaceArr4 == null) {
            int i2 = column + 1;
            if (i2 < 10) {
                i2 = 10;
            }
            cellValueRecordInterfaceArr4 = new CellValueRecordInterface[i2];
            cellValueRecordInterfaceArr3[row] = cellValueRecordInterfaceArr4;
        }
        if (column >= cellValueRecordInterfaceArr4.length) {
            int length2 = cellValueRecordInterfaceArr4.length * 2;
            int i3 = column + 1;
            if (length2 < i3) {
                length2 = i3;
            }
            CellValueRecordInterface[] cellValueRecordInterfaceArr5 = new CellValueRecordInterface[length2];
            System.arraycopy(cellValueRecordInterfaceArr4, 0, cellValueRecordInterfaceArr5, 0, cellValueRecordInterfaceArr4.length);
            this.records[row] = cellValueRecordInterfaceArr5;
            cellValueRecordInterfaceArr4 = cellValueRecordInterfaceArr5;
        }
        cellValueRecordInterfaceArr4[column] = cellValueRecordInterface;
        int i4 = this.firstcell;
        if (column < i4 || i4 == -1) {
            this.firstcell = column;
        }
        int i5 = this.lastcell;
        if (column > i5 || i5 == -1) {
            this.lastcell = column;
        }
    }

    public void removeCell(CellValueRecordInterface cellValueRecordInterface) {
        if (cellValueRecordInterface == null) {
            throw new IllegalArgumentException("cell must not be null");
        }
        int row = cellValueRecordInterface.getRow();
        CellValueRecordInterface[][] cellValueRecordInterfaceArr = this.records;
        if (row >= cellValueRecordInterfaceArr.length) {
            throw new RuntimeException("cell row is out of range");
        }
        CellValueRecordInterface[] cellValueRecordInterfaceArr2 = cellValueRecordInterfaceArr[row];
        if (cellValueRecordInterfaceArr2 == null) {
            throw new RuntimeException("cell row is already empty");
        }
        short column = cellValueRecordInterface.getColumn();
        if (column >= cellValueRecordInterfaceArr2.length) {
            throw new RuntimeException("cell column is out of range");
        }
        cellValueRecordInterfaceArr2[column] = null;
    }

    public void removeAllCellsValuesForRow(int i) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("Specified rowIndex " + i + " is outside the allowable range (0..65535)");
        }
        CellValueRecordInterface[][] cellValueRecordInterfaceArr = this.records;
        if (i >= cellValueRecordInterfaceArr.length) {
            return;
        }
        cellValueRecordInterfaceArr[i] = null;
    }

    public int getPhysicalNumberOfCells() {
        int i = 0;
        int i2 = 0;
        while (true) {
            CellValueRecordInterface[][] cellValueRecordInterfaceArr = this.records;
            if (i >= cellValueRecordInterfaceArr.length) {
                return i2;
            }
            CellValueRecordInterface[] cellValueRecordInterfaceArr2 = cellValueRecordInterfaceArr[i];
            if (cellValueRecordInterfaceArr2 != null) {
                for (CellValueRecordInterface cellValueRecordInterface : cellValueRecordInterfaceArr2) {
                    if (cellValueRecordInterface != null) {
                        i2++;
                    }
                }
            }
            i++;
        }
    }

    public int getFirstCellNum() {
        return this.firstcell;
    }

    public int getLastCellNum() {
        return this.lastcell;
    }

    public void addMultipleBlanks(MulBlankRecord mulBlankRecord) {
        for (int i = 0; i < mulBlankRecord.getNumColumns(); i++) {
            BlankRecord blankRecord = new BlankRecord();
            blankRecord.setColumn((short) (mulBlankRecord.getFirstColumn() + i));
            blankRecord.setRow(mulBlankRecord.getRow());
            blankRecord.setXFIndex(mulBlankRecord.getXFAt(i));
            insertCell(blankRecord);
        }
    }

    public void construct(CellValueRecordInterface cellValueRecordInterface, RecordStream recordStream, SharedValueManager sharedValueManager) {
        if (cellValueRecordInterface instanceof FormulaRecord) {
            insertCell(new FormulaRecordAggregate((FormulaRecord) cellValueRecordInterface, recordStream.peekNextClass() == StringRecord.class ? (StringRecord) recordStream.getNext() : null, sharedValueManager));
        } else {
            insertCell(cellValueRecordInterface);
        }
    }

    public int getRowCellBlockSize(int i, int i2) {
        int rowSerializedSize = 0;
        while (i <= i2) {
            CellValueRecordInterface[][] cellValueRecordInterfaceArr = this.records;
            if (i >= cellValueRecordInterfaceArr.length) {
                break;
            }
            rowSerializedSize += getRowSerializedSize(cellValueRecordInterfaceArr[i]);
            i++;
        }
        return rowSerializedSize;
    }

    public boolean rowHasCells(int i) {
        CellValueRecordInterface[] cellValueRecordInterfaceArr;
        CellValueRecordInterface[][] cellValueRecordInterfaceArr2 = this.records;
        if (i >= cellValueRecordInterfaceArr2.length || (cellValueRecordInterfaceArr = cellValueRecordInterfaceArr2[i]) == null) {
            return false;
        }
        for (CellValueRecordInterface cellValueRecordInterface : cellValueRecordInterfaceArr) {
            if (cellValueRecordInterface != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static int getRowSerializedSize(CellValueRecordInterface[] cellValueRecordInterfaceArr) {
        int i = 0;
        if (cellValueRecordInterfaceArr == 0) {
            return 0;
        }
        int recordSize = 0;
        while (i < cellValueRecordInterfaceArr.length) {
            RecordBase recordBase = (RecordBase) cellValueRecordInterfaceArr[i];
            if (recordBase != null) {
                int iCountBlanks = countBlanks(cellValueRecordInterfaceArr, i);
                if (iCountBlanks > 1) {
                    recordSize += (iCountBlanks * 2) + 10;
                    i += iCountBlanks - 1;
                } else {
                    recordSize += recordBase.getRecordSize();
                }
            }
            i++;
        }
        return recordSize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void visitCellsForRow(int i, RecordAggregate.RecordVisitor recordVisitor) {
        CellValueRecordInterface[] cellValueRecordInterfaceArr = this.records[i];
        if (cellValueRecordInterfaceArr == 0) {
            throw new IllegalArgumentException("Row [" + i + "] is empty");
        }
        int i2 = 0;
        while (i2 < cellValueRecordInterfaceArr.length) {
            RecordBase recordBase = (RecordBase) cellValueRecordInterfaceArr[i2];
            if (recordBase != null) {
                int iCountBlanks = countBlanks(cellValueRecordInterfaceArr, i2);
                if (iCountBlanks > 1) {
                    recordVisitor.visitRecord(createMBR(cellValueRecordInterfaceArr, i2, iCountBlanks));
                    i2 += iCountBlanks - 1;
                } else if (recordBase instanceof RecordAggregate) {
                    ((RecordAggregate) recordBase).visitContainedRecords(recordVisitor);
                } else {
                    recordVisitor.visitRecord((Record) recordBase);
                }
            }
            i2++;
        }
    }

    private static int countBlanks(CellValueRecordInterface[] cellValueRecordInterfaceArr, int i) {
        int i2 = i;
        while (i2 < cellValueRecordInterfaceArr.length && (cellValueRecordInterfaceArr[i2] instanceof BlankRecord)) {
            i2++;
        }
        return i2 - i;
    }

    private MulBlankRecord createMBR(CellValueRecordInterface[] cellValueRecordInterfaceArr, int i, int i2) {
        short[] sArr = new short[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            sArr[i3] = ((BlankRecord) cellValueRecordInterfaceArr[i + i3]).getXFIndex();
        }
        return new MulBlankRecord(cellValueRecordInterfaceArr[i].getRow(), i, sArr);
    }

    public void updateFormulasAfterRowShift(FormulaShifter formulaShifter, int i) {
        int i2 = 0;
        while (true) {
            CellValueRecordInterface[][] cellValueRecordInterfaceArr = this.records;
            if (i2 >= cellValueRecordInterfaceArr.length) {
                return;
            }
            CellValueRecordInterface[] cellValueRecordInterfaceArr2 = cellValueRecordInterfaceArr[i2];
            if (cellValueRecordInterfaceArr2 != null) {
                for (CellValueRecordInterface cellValueRecordInterface : cellValueRecordInterfaceArr2) {
                    if (cellValueRecordInterface instanceof FormulaRecordAggregate) {
                        FormulaRecordAggregate formulaRecordAggregate = (FormulaRecordAggregate) cellValueRecordInterface;
                        Ptg[] formulaTokens = formulaRecordAggregate.getFormulaTokens();
                        formulaRecordAggregate.getFormulaRecord().getParsedExpression();
                        if (formulaShifter.adjustFormula(formulaTokens, i)) {
                            formulaRecordAggregate.setParsedExpression(formulaTokens);
                        }
                    }
                }
            }
            i2++;
        }
    }

    class ValueIterator implements Iterator<CellValueRecordInterface> {
        int curRowIndex = 0;
        int curColIndex = -1;
        int nextRowIndex = 0;
        int nextColIndex = -1;

        public ValueIterator() {
            getNextPos();
        }

        void getNextPos() {
            if (this.nextRowIndex >= ValueRecordsAggregate.this.records.length) {
                return;
            }
            while (this.nextRowIndex < ValueRecordsAggregate.this.records.length) {
                this.nextColIndex++;
                if (ValueRecordsAggregate.this.records[this.nextRowIndex] != null && this.nextColIndex < ValueRecordsAggregate.this.records[this.nextRowIndex].length) {
                    if (ValueRecordsAggregate.this.records[this.nextRowIndex][this.nextColIndex] != null) {
                        return;
                    }
                } else {
                    this.nextRowIndex++;
                    this.nextColIndex = -1;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextRowIndex < ValueRecordsAggregate.this.records.length;
        }

        @Override // java.util.Iterator
        public CellValueRecordInterface next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException("iterator has no next");
            }
            this.curRowIndex = this.nextRowIndex;
            this.curColIndex = this.nextColIndex;
            CellValueRecordInterface cellValueRecordInterface = ValueRecordsAggregate.this.records[this.curRowIndex][this.curColIndex];
            getNextPos();
            return cellValueRecordInterface;
        }

        @Override // java.util.Iterator
        public void remove() {
            ValueRecordsAggregate.this.records[this.curRowIndex][this.curColIndex] = null;
        }
    }

    @Override // java.lang.Iterable
    public Iterator<CellValueRecordInterface> iterator() {
        return new ValueIterator();
    }

    public Object clone() {
        throw new RuntimeException("clone() should not be called.  ValueRecordsAggregate should be copied via Sheet.cloneSheet()");
    }
}
