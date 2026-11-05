package org.apache.poi.hssf.record.aggregates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.record.ArrayRecord;
import org.apache.poi.hssf.record.SharedFormulaRecord;
import org.apache.poi.hssf.record.SharedValueRecordBase;
import org.apache.poi.hssf.record.TableRecord;
import org.apache.poi.hssf.util.CellRangeAddress8Bit;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class SharedValueManager {
    private final List<ArrayRecord> _arrayRecords;
    private final Map<SharedFormulaRecord, SharedFormulaGroup> _groupsBySharedFormulaRecord;
    private Map<Integer, SharedFormulaGroup> _groupsCache;
    private final TableRecord[] _tableRecords;

    private static final class SharedFormulaGroup {
        private final CellReference _firstCell;
        private final FormulaRecordAggregate[] _frAggs;
        private int _numberOfFormulas;
        private final SharedFormulaRecord _sfr;

        public SharedFormulaGroup(SharedFormulaRecord sharedFormulaRecord, CellReference cellReference) {
            if (!sharedFormulaRecord.isInRange(cellReference.getRow(), cellReference.getCol())) {
                throw new IllegalArgumentException("First formula cell " + cellReference.formatAsString() + " is not shared formula range " + sharedFormulaRecord.getRange() + ".");
            }
            this._sfr = sharedFormulaRecord;
            this._firstCell = cellReference;
            this._frAggs = new FormulaRecordAggregate[((sharedFormulaRecord.getLastColumn() - sharedFormulaRecord.getFirstColumn()) + 1) * ((sharedFormulaRecord.getLastRow() - sharedFormulaRecord.getFirstRow()) + 1)];
            this._numberOfFormulas = 0;
        }

        public void add(FormulaRecordAggregate formulaRecordAggregate) {
            if (this._numberOfFormulas == 0 && (this._firstCell.getRow() != formulaRecordAggregate.getRow() || this._firstCell.getCol() != formulaRecordAggregate.getColumn())) {
                throw new IllegalStateException("shared formula coding error: " + ((int) this._firstCell.getCol()) + '/' + this._firstCell.getRow() + " != " + ((int) formulaRecordAggregate.getColumn()) + '/' + formulaRecordAggregate.getRow());
            }
            int i = this._numberOfFormulas;
            FormulaRecordAggregate[] formulaRecordAggregateArr = this._frAggs;
            if (i >= formulaRecordAggregateArr.length) {
                throw new RuntimeException("Too many formula records for shared formula group");
            }
            this._numberOfFormulas = i + 1;
            formulaRecordAggregateArr[i] = formulaRecordAggregate;
        }

        public void unlinkSharedFormulas() {
            for (int i = 0; i < this._numberOfFormulas; i++) {
                this._frAggs[i].unlinkSharedFormula();
            }
        }

        public SharedFormulaRecord getSFR() {
            return this._sfr;
        }

        public final String toString() {
            StringBuffer stringBuffer = new StringBuffer(64);
            stringBuffer.append(getClass().getName()).append(" [");
            stringBuffer.append(this._sfr.getRange());
            stringBuffer.append("]");
            return stringBuffer.toString();
        }
    }

    public static SharedValueManager createEmpty() {
        return new SharedValueManager(new SharedFormulaRecord[0], new CellReference[0], new ArrayRecord[0], new TableRecord[0]);
    }

    private SharedValueManager(SharedFormulaRecord[] sharedFormulaRecordArr, CellReference[] cellReferenceArr, ArrayRecord[] arrayRecordArr, TableRecord[] tableRecordArr) {
        int length = sharedFormulaRecordArr.length;
        if (length != cellReferenceArr.length) {
            throw new IllegalArgumentException("array sizes don't match: " + length + "!=" + cellReferenceArr.length + ".");
        }
        this._arrayRecords = toList(arrayRecordArr);
        this._tableRecords = tableRecordArr;
        HashMap map = new HashMap((length * 3) / 2);
        for (int i = 0; i < length; i++) {
            SharedFormulaRecord sharedFormulaRecord = sharedFormulaRecordArr[i];
            map.put(sharedFormulaRecord, new SharedFormulaGroup(sharedFormulaRecord, cellReferenceArr[i]));
        }
        this._groupsBySharedFormulaRecord = map;
    }

    private static <Z> List<Z> toList(Z[] zArr) {
        ArrayList arrayList = new ArrayList(zArr.length);
        for (Z z : zArr) {
            arrayList.add(z);
        }
        return arrayList;
    }

    public static SharedValueManager create(SharedFormulaRecord[] sharedFormulaRecordArr, CellReference[] cellReferenceArr, ArrayRecord[] arrayRecordArr, TableRecord[] tableRecordArr) {
        if (sharedFormulaRecordArr.length + cellReferenceArr.length + arrayRecordArr.length + tableRecordArr.length < 1) {
            return createEmpty();
        }
        return new SharedValueManager(sharedFormulaRecordArr, cellReferenceArr, arrayRecordArr, tableRecordArr);
    }

    public SharedFormulaRecord linkSharedFormulaRecord(CellReference cellReference, FormulaRecordAggregate formulaRecordAggregate) {
        SharedFormulaGroup sharedFormulaGroupFindFormulaGroupForCell = findFormulaGroupForCell(cellReference);
        if (sharedFormulaGroupFindFormulaGroupForCell == null) {
            throw new RuntimeException("Failed to find a matching shared formula record");
        }
        sharedFormulaGroupFindFormulaGroupForCell.add(formulaRecordAggregate);
        return sharedFormulaGroupFindFormulaGroupForCell.getSFR();
    }

    private SharedFormulaGroup findFormulaGroupForCell(CellReference cellReference) {
        if (this._groupsCache == null) {
            this._groupsCache = new HashMap(this._groupsBySharedFormulaRecord.size());
            for (SharedFormulaGroup sharedFormulaGroup : this._groupsBySharedFormulaRecord.values()) {
                this._groupsCache.put(getKeyForCache(sharedFormulaGroup._firstCell), sharedFormulaGroup);
            }
        }
        return this._groupsCache.get(getKeyForCache(cellReference));
    }

    private Integer getKeyForCache(CellReference cellReference) {
        return Integer.valueOf(cellReference.getRow() | ((cellReference.getCol() + 1) << 16));
    }

    public SharedValueRecordBase getRecordForFirstCell(FormulaRecordAggregate formulaRecordAggregate) {
        SharedFormulaGroup sharedFormulaGroupFindFormulaGroupForCell;
        CellReference expReference = formulaRecordAggregate.getFormulaRecord().getFormula().getExpReference();
        if (expReference == null) {
            return null;
        }
        int row = expReference.getRow();
        short col = expReference.getCol();
        if (formulaRecordAggregate.getRow() == row && formulaRecordAggregate.getColumn() == col) {
            if (!this._groupsBySharedFormulaRecord.isEmpty() && (sharedFormulaGroupFindFormulaGroupForCell = findFormulaGroupForCell(expReference)) != null) {
                return sharedFormulaGroupFindFormulaGroupForCell.getSFR();
            }
            for (TableRecord tableRecord : this._tableRecords) {
                if (tableRecord.isFirstCell(row, col)) {
                    return tableRecord;
                }
            }
            for (ArrayRecord arrayRecord : this._arrayRecords) {
                if (arrayRecord.isFirstCell(row, col)) {
                    return arrayRecord;
                }
            }
        }
        return null;
    }

    public void unlink(SharedFormulaRecord sharedFormulaRecord) {
        SharedFormulaGroup sharedFormulaGroupRemove = this._groupsBySharedFormulaRecord.remove(sharedFormulaRecord);
        if (sharedFormulaGroupRemove == null) {
            throw new IllegalStateException("Failed to find formulas for shared formula");
        }
        this._groupsCache = null;
        sharedFormulaGroupRemove.unlinkSharedFormulas();
    }

    public void addArrayRecord(ArrayRecord arrayRecord) {
        this._arrayRecords.add(arrayRecord);
    }

    public CellRangeAddress8Bit removeArrayFormula(int i, int i2) {
        for (ArrayRecord arrayRecord : this._arrayRecords) {
            if (arrayRecord.isInRange(i, i2)) {
                this._arrayRecords.remove(arrayRecord);
                return arrayRecord.getRange();
            }
        }
        throw new IllegalArgumentException("Specified cell " + new CellReference(i, i2, false, false).formatAsString() + " is not part of an array formula.");
    }

    public ArrayRecord getArrayRecord(int i, int i2) {
        for (ArrayRecord arrayRecord : this._arrayRecords) {
            if (arrayRecord.isFirstCell(i, i2)) {
                return arrayRecord;
            }
        }
        return null;
    }
}
