package org.apache.poi.hssf.record.aggregates;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.CellValueRecordInterface;
import org.apache.poi.hssf.record.DBCellRecord;
import org.apache.poi.hssf.record.DimensionsRecord;
import org.apache.poi.hssf.record.FormulaRecord;
import org.apache.poi.hssf.record.IndexRecord;
import org.apache.poi.hssf.record.MulBlankRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RowRecord;
import org.apache.poi.hssf.record.UnknownRecord;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.FormulaShifter;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class RowRecordsAggregate extends RecordAggregate {
    private int _firstrow;
    private int _lastrow;
    private RowRecord[] _rowRecordValues;
    private final Map<Integer, RowRecord> _rowRecords;
    private final SharedValueManager _sharedValueManager;
    private final List<Record> _unknownRecords;
    private final ValueRecordsAggregate _valuesAgg;

    public RowRecordsAggregate() {
        this(SharedValueManager.createEmpty());
    }

    private RowRecordsAggregate(SharedValueManager sharedValueManager) {
        this._firstrow = -1;
        this._lastrow = -1;
        this._rowRecordValues = null;
        if (sharedValueManager == null) {
            throw new IllegalArgumentException("SharedValueManager must be provided.");
        }
        this._rowRecords = new TreeMap();
        this._valuesAgg = new ValueRecordsAggregate();
        this._unknownRecords = new ArrayList();
        this._sharedValueManager = sharedValueManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RowRecordsAggregate(RecordStream recordStream, SharedValueManager sharedValueManager) {
        this(sharedValueManager);
        while (recordStream.hasNext()) {
            Record next = recordStream.getNext();
            short sid = next.getSid();
            if (sid == 81) {
                addUnknownRecord(next);
            } else if (sid == 215) {
                continue;
            } else if (sid == 520) {
                insertRow((RowRecord) next);
            } else if (next instanceof UnknownRecord) {
                addUnknownRecord(next);
                while (recordStream.peekNextSid() == 60) {
                    addUnknownRecord(recordStream.getNext());
                }
            } else if (next instanceof MulBlankRecord) {
                this._valuesAgg.addMultipleBlanks((MulBlankRecord) next);
            } else {
                if (!(next instanceof CellValueRecordInterface)) {
                    throw new RuntimeException("Unexpected record type (" + next.getClass().getName() + ")");
                }
                this._valuesAgg.construct((CellValueRecordInterface) next, recordStream, sharedValueManager);
            }
        }
    }

    private void addUnknownRecord(Record record) {
        this._unknownRecords.add(record);
    }

    public void insertRow(RowRecord rowRecord) {
        this._rowRecords.put(Integer.valueOf(rowRecord.getRowNumber()), rowRecord);
        this._rowRecordValues = null;
        int rowNumber = rowRecord.getRowNumber();
        int i = this._firstrow;
        if (rowNumber < i || i == -1) {
            this._firstrow = rowRecord.getRowNumber();
        }
        int rowNumber2 = rowRecord.getRowNumber();
        int i2 = this._lastrow;
        if (rowNumber2 > i2 || i2 == -1) {
            this._lastrow = rowRecord.getRowNumber();
        }
    }

    public void removeRow(RowRecord rowRecord) {
        int rowNumber = rowRecord.getRowNumber();
        this._valuesAgg.removeAllCellsValuesForRow(rowNumber);
        Integer numValueOf = Integer.valueOf(rowNumber);
        RowRecord rowRecordRemove = this._rowRecords.remove(numValueOf);
        if (rowRecordRemove == null) {
            throw new RuntimeException("Invalid row index (" + numValueOf.intValue() + ")");
        }
        if (rowRecord != rowRecordRemove) {
            this._rowRecords.put(numValueOf, rowRecordRemove);
            throw new RuntimeException("Attempt to remove row that does not belong to this sheet");
        }
        this._rowRecordValues = null;
    }

    public RowRecord getRow(int i) {
        int lastRowIndex = SpreadsheetVersion.EXCEL97.getLastRowIndex();
        if (i < 0 || i > lastRowIndex) {
            throw new IllegalArgumentException("The row number must be between 0 and " + lastRowIndex + ", but had: " + i);
        }
        return this._rowRecords.get(Integer.valueOf(i));
    }

    public int getPhysicalNumberOfRows() {
        return this._rowRecords.size();
    }

    public int getFirstRowNum() {
        return this._firstrow;
    }

    public int getLastRowNum() {
        return this._lastrow;
    }

    public int getRowBlockCount() {
        int size = this._rowRecords.size() / 32;
        return this._rowRecords.size() % 32 != 0 ? size + 1 : size;
    }

    private int getRowBlockSize(int i) {
        return getRowCountForBlock(i) * 20;
    }

    public int getRowCountForBlock(int i) {
        int i2 = i * 32;
        int size = (i2 + 32) - 1;
        if (size >= this._rowRecords.size()) {
            size = this._rowRecords.size() - 1;
        }
        return (size - i2) + 1;
    }

    private int getStartRowNumberForBlock(int i) {
        int i2 = i * 32;
        if (this._rowRecordValues == null) {
            this._rowRecordValues = (RowRecord[]) this._rowRecords.values().toArray(new RowRecord[this._rowRecords.size()]);
        }
        try {
            return this._rowRecordValues[i2].getRowNumber();
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new RuntimeException("Did not find start row for block " + i);
        }
    }

    private int getEndRowNumberForBlock(int i) {
        int size = ((i + 1) * 32) - 1;
        if (size >= this._rowRecords.size()) {
            size = this._rowRecords.size() - 1;
        }
        if (this._rowRecordValues == null) {
            this._rowRecordValues = (RowRecord[]) this._rowRecords.values().toArray(new RowRecord[this._rowRecords.size()]);
        }
        try {
            return this._rowRecordValues[size].getRowNumber();
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new RuntimeException("Did not find end row for block " + i);
        }
    }

    private int visitRowRecordsForBlock(int i, RecordAggregate.RecordVisitor recordVisitor) {
        int i2 = i * 32;
        int i3 = i2 + 32;
        Iterator<RowRecord> it = this._rowRecords.values().iterator();
        int recordSize = 0;
        int i4 = 0;
        while (i4 < i2) {
            it.next();
            i4++;
        }
        while (it.hasNext()) {
            int i5 = i4 + 1;
            if (i4 >= i3) {
                break;
            }
            RowRecord next = it.next();
            recordSize += next.getRecordSize();
            recordVisitor.visitRecord(next);
            i4 = i5;
        }
        return recordSize;
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate
    public void visitContainedRecords(RecordAggregate.RecordVisitor recordVisitor) {
        RecordAggregate.PositionTrackingVisitor positionTrackingVisitor = new RecordAggregate.PositionTrackingVisitor(recordVisitor, 0);
        int rowBlockCount = getRowBlockCount();
        for (int i = 0; i < rowBlockCount; i++) {
            int iVisitRowRecordsForBlock = visitRowRecordsForBlock(i, recordVisitor);
            int i2 = iVisitRowRecordsForBlock + 0;
            int endRowNumberForBlock = getEndRowNumberForBlock(i);
            DBCellRecord.Builder builder = new DBCellRecord.Builder();
            int i3 = iVisitRowRecordsForBlock - 20;
            for (int startRowNumberForBlock = getStartRowNumberForBlock(i); startRowNumberForBlock <= endRowNumberForBlock; startRowNumberForBlock++) {
                if (this._valuesAgg.rowHasCells(startRowNumberForBlock)) {
                    positionTrackingVisitor.setPosition(0);
                    this._valuesAgg.visitCellsForRow(startRowNumberForBlock, positionTrackingVisitor);
                    int position = positionTrackingVisitor.getPosition();
                    i2 += position;
                    builder.addCellOffset(i3);
                    i3 = position;
                }
            }
            recordVisitor.visitRecord(builder.build(i2));
        }
        Iterator<Record> it = this._unknownRecords.iterator();
        while (it.hasNext()) {
            recordVisitor.visitRecord(it.next());
        }
    }

    public Iterator<RowRecord> getIterator() {
        return this._rowRecords.values().iterator();
    }

    public int findStartOfRowOutlineGroup(int i) {
        short outlineLevel = getRow(i).getOutlineLevel();
        while (i >= 0 && getRow(i) != null) {
            if (getRow(i).getOutlineLevel() < outlineLevel) {
                return i + 1;
            }
            i--;
        }
        return i + 1;
    }

    public int findEndOfRowOutlineGroup(int i) {
        short outlineLevel = getRow(i).getOutlineLevel();
        while (i < getLastRowNum() && getRow(i) != null && getRow(i).getOutlineLevel() >= outlineLevel) {
            i++;
        }
        return i - 1;
    }

    private int writeHidden(RowRecord rowRecord, int i) {
        short outlineLevel = rowRecord.getOutlineLevel();
        while (rowRecord != null && getRow(i).getOutlineLevel() >= outlineLevel) {
            rowRecord.setZeroHeight(true);
            i++;
            rowRecord = getRow(i);
        }
        return i;
    }

    public void collapseRow(int i) {
        int iFindStartOfRowOutlineGroup = findStartOfRowOutlineGroup(i);
        int iWriteHidden = writeHidden(getRow(iFindStartOfRowOutlineGroup), iFindStartOfRowOutlineGroup);
        RowRecord row = getRow(iWriteHidden);
        if (row == null) {
            row = createRow(iWriteHidden);
            insertRow(row);
        }
        row.setColapsed(true);
    }

    public static RowRecord createRow(int i) {
        return new RowRecord(i);
    }

    public boolean isRowGroupCollapsed(int i) {
        int iFindEndOfRowOutlineGroup = findEndOfRowOutlineGroup(i) + 1;
        return getRow(iFindEndOfRowOutlineGroup) != null && getRow(iFindEndOfRowOutlineGroup).getColapsed();
    }

    public void expandRow(int i) {
        if (i != -1 && isRowGroupCollapsed(i)) {
            int iFindStartOfRowOutlineGroup = findStartOfRowOutlineGroup(i);
            RowRecord row = getRow(iFindStartOfRowOutlineGroup);
            int iFindEndOfRowOutlineGroup = findEndOfRowOutlineGroup(i);
            if (!isRowGroupHiddenByParent(i)) {
                while (iFindStartOfRowOutlineGroup <= iFindEndOfRowOutlineGroup) {
                    RowRecord row2 = getRow(iFindStartOfRowOutlineGroup);
                    if (row.getOutlineLevel() == row2.getOutlineLevel() || !isRowGroupCollapsed(iFindStartOfRowOutlineGroup)) {
                        row2.setZeroHeight(false);
                    }
                    iFindStartOfRowOutlineGroup++;
                }
            }
            getRow(iFindEndOfRowOutlineGroup + 1).setColapsed(false);
        }
    }

    public boolean isRowGroupHiddenByParent(int i) {
        short outlineLevel;
        boolean zeroHeight;
        boolean zeroHeight2;
        int iFindEndOfRowOutlineGroup = findEndOfRowOutlineGroup(i) + 1;
        short outlineLevel2 = 0;
        if (getRow(iFindEndOfRowOutlineGroup) == null) {
            zeroHeight = false;
            outlineLevel = 0;
        } else {
            outlineLevel = getRow(iFindEndOfRowOutlineGroup).getOutlineLevel();
            zeroHeight = getRow(iFindEndOfRowOutlineGroup).getZeroHeight();
        }
        int iFindStartOfRowOutlineGroup = findStartOfRowOutlineGroup(i) - 1;
        if (iFindStartOfRowOutlineGroup < 0 || getRow(iFindStartOfRowOutlineGroup) == null) {
            zeroHeight2 = false;
        } else {
            outlineLevel2 = getRow(iFindStartOfRowOutlineGroup).getOutlineLevel();
            zeroHeight2 = getRow(iFindStartOfRowOutlineGroup).getZeroHeight();
        }
        return outlineLevel > outlineLevel2 ? zeroHeight : zeroHeight2;
    }

    public Iterator<CellValueRecordInterface> getCellValueIterator() {
        return this._valuesAgg.iterator();
    }

    public IndexRecord createIndexRecord(int i, int i2) {
        IndexRecord indexRecord = new IndexRecord();
        indexRecord.setFirstRow(this._firstrow);
        indexRecord.setLastRowAdd1(this._lastrow + 1);
        int rowBlockCount = getRowBlockCount();
        int recordSizeForBlockCount = i + IndexRecord.getRecordSizeForBlockCount(rowBlockCount) + i2;
        for (int i3 = 0; i3 < rowBlockCount; i3++) {
            int rowBlockSize = recordSizeForBlockCount + getRowBlockSize(i3) + this._valuesAgg.getRowCellBlockSize(getStartRowNumberForBlock(i3), getEndRowNumberForBlock(i3));
            indexRecord.addDbcell(rowBlockSize);
            recordSizeForBlockCount = rowBlockSize + (getRowCountForBlock(i3) * 2) + 8;
        }
        return indexRecord;
    }

    public void insertCell(CellValueRecordInterface cellValueRecordInterface) {
        this._valuesAgg.insertCell(cellValueRecordInterface);
    }

    public void removeCell(CellValueRecordInterface cellValueRecordInterface) {
        if (cellValueRecordInterface instanceof FormulaRecordAggregate) {
            ((FormulaRecordAggregate) cellValueRecordInterface).notifyFormulaChanging();
        }
        this._valuesAgg.removeCell(cellValueRecordInterface);
    }

    public FormulaRecordAggregate createFormula(int i, int i2) {
        FormulaRecord formulaRecord = new FormulaRecord();
        formulaRecord.setRow(i);
        formulaRecord.setColumn((short) i2);
        return new FormulaRecordAggregate(formulaRecord, null, this._sharedValueManager);
    }

    public void updateFormulasAfterRowShift(FormulaShifter formulaShifter, int i) {
        this._valuesAgg.updateFormulasAfterRowShift(formulaShifter, i);
    }

    public DimensionsRecord createDimensions() {
        DimensionsRecord dimensionsRecord = new DimensionsRecord();
        dimensionsRecord.setFirstRow(this._firstrow);
        dimensionsRecord.setLastRow(this._lastrow);
        dimensionsRecord.setFirstCol((short) this._valuesAgg.getFirstCellNum());
        dimensionsRecord.setLastCol((short) this._valuesAgg.getLastCellNum());
        return dimensionsRecord;
    }
}
