package org.apache.poi.hssf.record.aggregates;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.ColumnInfoRecord;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ColumnInfoRecordsAggregate extends RecordAggregate implements Cloneable {
    private final List<ColumnInfoRecord> records;

    private static final class CIRComparator implements Comparator<ColumnInfoRecord> {
        public static final Comparator<ColumnInfoRecord> instance = new CIRComparator();

        private CIRComparator() {
        }

        @Override // java.util.Comparator
        public int compare(ColumnInfoRecord columnInfoRecord, ColumnInfoRecord columnInfoRecord2) {
            return compareColInfos(columnInfoRecord, columnInfoRecord2);
        }

        public static int compareColInfos(ColumnInfoRecord columnInfoRecord, ColumnInfoRecord columnInfoRecord2) {
            return columnInfoRecord.getFirstColumn() - columnInfoRecord2.getFirstColumn();
        }
    }

    public ColumnInfoRecordsAggregate() {
        this.records = new ArrayList();
    }

    public ColumnInfoRecordsAggregate(RecordStream recordStream) {
        this();
        ColumnInfoRecord columnInfoRecord = null;
        boolean z = true;
        while (recordStream.peekNextClass() == ColumnInfoRecord.class) {
            ColumnInfoRecord columnInfoRecord2 = (ColumnInfoRecord) recordStream.getNext();
            this.records.add(columnInfoRecord2);
            if (columnInfoRecord != null && CIRComparator.compareColInfos(columnInfoRecord, columnInfoRecord2) > 0) {
                z = false;
            }
            columnInfoRecord = columnInfoRecord2;
        }
        if (this.records.size() < 1) {
            throw new RuntimeException("No column info records found");
        }
        if (z) {
            return;
        }
        Collections.sort(this.records, CIRComparator.instance);
    }

    public ColumnInfoRecordsAggregate clone() {
        ColumnInfoRecordsAggregate columnInfoRecordsAggregate = new ColumnInfoRecordsAggregate();
        Iterator<ColumnInfoRecord> it = this.records.iterator();
        while (it.hasNext()) {
            columnInfoRecordsAggregate.records.add(it.next().clone());
        }
        return columnInfoRecordsAggregate;
    }

    public void insertColumn(ColumnInfoRecord columnInfoRecord) {
        this.records.add(columnInfoRecord);
        Collections.sort(this.records, CIRComparator.instance);
    }

    private void insertColumn(int i, ColumnInfoRecord columnInfoRecord) {
        this.records.add(i, columnInfoRecord);
    }

    int getNumColumns() {
        return this.records.size();
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate
    public void visitContainedRecords(RecordAggregate.RecordVisitor recordVisitor) {
        int size = this.records.size();
        if (size < 1) {
            return;
        }
        ColumnInfoRecord columnInfoRecord = null;
        int i = 0;
        while (i < size) {
            ColumnInfoRecord columnInfoRecord2 = this.records.get(i);
            recordVisitor.visitRecord(columnInfoRecord2);
            if (columnInfoRecord != null && CIRComparator.compareColInfos(columnInfoRecord, columnInfoRecord2) > 0) {
                throw new RuntimeException("Column info records are out of order");
            }
            i++;
            columnInfoRecord = columnInfoRecord2;
        }
    }

    private int findStartOfColumnOutlineGroup(int i) {
        ColumnInfoRecord columnInfoRecord = this.records.get(i);
        int outlineLevel = columnInfoRecord.getOutlineLevel();
        while (i != 0) {
            ColumnInfoRecord columnInfoRecord2 = this.records.get(i - 1);
            if (!columnInfoRecord2.isAdjacentBefore(columnInfoRecord) || columnInfoRecord2.getOutlineLevel() < outlineLevel) {
                break;
            }
            i--;
            columnInfoRecord = columnInfoRecord2;
        }
        return i;
    }

    private int findEndOfColumnOutlineGroup(int i) {
        ColumnInfoRecord columnInfoRecord = this.records.get(i);
        int outlineLevel = columnInfoRecord.getOutlineLevel();
        while (i < this.records.size() - 1) {
            int i2 = i + 1;
            ColumnInfoRecord columnInfoRecord2 = this.records.get(i2);
            if (!columnInfoRecord.isAdjacentBefore(columnInfoRecord2) || columnInfoRecord2.getOutlineLevel() < outlineLevel) {
                break;
            }
            columnInfoRecord = columnInfoRecord2;
            i = i2;
        }
        return i;
    }

    private ColumnInfoRecord getColInfo(int i) {
        return this.records.get(i);
    }

    private boolean isColumnGroupCollapsed(int i) {
        int iFindEndOfColumnOutlineGroup = findEndOfColumnOutlineGroup(i);
        int i2 = iFindEndOfColumnOutlineGroup + 1;
        if (i2 >= this.records.size()) {
            return false;
        }
        ColumnInfoRecord colInfo = getColInfo(i2);
        if (getColInfo(iFindEndOfColumnOutlineGroup).isAdjacentBefore(colInfo)) {
            return colInfo.getCollapsed();
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0047  */
    /* JADX WARN: Code duplicated, block: B:7:0x0026  */
    private boolean isColumnGroupHiddenByParent(int i) {
        int outlineLevel;
        boolean hidden;
        boolean hidden2;
        int iFindEndOfColumnOutlineGroup = findEndOfColumnOutlineGroup(i);
        int outlineLevel2 = 0;
        if (iFindEndOfColumnOutlineGroup < this.records.size()) {
            ColumnInfoRecord colInfo = getColInfo(iFindEndOfColumnOutlineGroup + 1);
            if (getColInfo(iFindEndOfColumnOutlineGroup).isAdjacentBefore(colInfo)) {
                outlineLevel = colInfo.getOutlineLevel();
                hidden = colInfo.getHidden();
            } else {
                outlineLevel = 0;
                hidden = false;
            }
        } else {
            outlineLevel = 0;
            hidden = false;
        }
        int iFindStartOfColumnOutlineGroup = findStartOfColumnOutlineGroup(i);
        if (iFindStartOfColumnOutlineGroup > 0) {
            ColumnInfoRecord colInfo2 = getColInfo(iFindStartOfColumnOutlineGroup - 1);
            if (colInfo2.isAdjacentBefore(getColInfo(iFindStartOfColumnOutlineGroup))) {
                outlineLevel2 = colInfo2.getOutlineLevel();
                hidden2 = colInfo2.getHidden();
            } else {
                hidden2 = false;
            }
        } else {
            hidden2 = false;
        }
        return outlineLevel > outlineLevel2 ? hidden : hidden2;
    }

    public void collapseColumn(int i) {
        int iFindColInfoIdx = findColInfoIdx(i, 0);
        if (iFindColInfoIdx == -1) {
            return;
        }
        int iFindStartOfColumnOutlineGroup = findStartOfColumnOutlineGroup(iFindColInfoIdx);
        setColumn(setGroupHidden(iFindStartOfColumnOutlineGroup, getColInfo(iFindStartOfColumnOutlineGroup).getOutlineLevel(), true) + 1, null, null, null, null, Boolean.TRUE);
    }

    private int setGroupHidden(int i, int i2, boolean z) {
        ColumnInfoRecord colInfo = getColInfo(i);
        while (i < this.records.size()) {
            colInfo.setHidden(z);
            i++;
            if (i < this.records.size()) {
                ColumnInfoRecord colInfo2 = getColInfo(i);
                if (!colInfo.isAdjacentBefore(colInfo2) || colInfo2.getOutlineLevel() < i2) {
                    break;
                }
                colInfo = colInfo2;
            }
        }
        return colInfo.getLastColumn();
    }

    public void expandColumn(int i) {
        int iFindColInfoIdx = findColInfoIdx(i, 0);
        if (iFindColInfoIdx != -1 && isColumnGroupCollapsed(iFindColInfoIdx)) {
            int iFindEndOfColumnOutlineGroup = findEndOfColumnOutlineGroup(iFindColInfoIdx);
            ColumnInfoRecord colInfo = getColInfo(iFindEndOfColumnOutlineGroup);
            if (!isColumnGroupHiddenByParent(iFindColInfoIdx)) {
                int outlineLevel = colInfo.getOutlineLevel();
                for (int iFindStartOfColumnOutlineGroup = findStartOfColumnOutlineGroup(iFindColInfoIdx); iFindStartOfColumnOutlineGroup <= iFindEndOfColumnOutlineGroup; iFindStartOfColumnOutlineGroup++) {
                    ColumnInfoRecord colInfo2 = getColInfo(iFindStartOfColumnOutlineGroup);
                    if (outlineLevel == colInfo2.getOutlineLevel()) {
                        colInfo2.setHidden(false);
                    }
                }
            }
            setColumn(colInfo.getLastColumn() + 1, null, null, null, null, Boolean.FALSE);
        }
    }

    private static ColumnInfoRecord copyColInfo(ColumnInfoRecord columnInfoRecord) {
        return columnInfoRecord.clone();
    }

    public void setColumn(int i, Short sh, Integer num, Integer num2, Boolean bool, Boolean bool2) {
        ColumnInfoRecord columnInfoRecord;
        int i2 = 0;
        while (true) {
            if (i2 < this.records.size()) {
                columnInfoRecord = this.records.get(i2);
                if (columnInfoRecord.containsColumn(i)) {
                    break;
                } else if (columnInfoRecord.getFirstColumn() <= i) {
                    i2++;
                }
            }
            columnInfoRecord = null;
            break;
        }
        ColumnInfoRecord columnInfoRecord2 = columnInfoRecord;
        if (columnInfoRecord2 == null) {
            ColumnInfoRecord columnInfoRecord3 = new ColumnInfoRecord();
            columnInfoRecord3.setFirstColumn(i);
            columnInfoRecord3.setLastColumn(i);
            setColumnInfoFields(columnInfoRecord3, sh, num, num2, bool, bool2);
            insertColumn(i2, columnInfoRecord3);
            attemptMergeColInfoRecords(i2);
            return;
        }
        if ((sh != null && columnInfoRecord2.getXFIndex() != sh.shortValue()) || (num != null && columnInfoRecord2.getColumnWidth() != num.shortValue()) || (num2 != null && columnInfoRecord2.getOutlineLevel() != num2.intValue()) || (bool != null && columnInfoRecord2.getHidden() != bool.booleanValue()) || (bool2 != null && columnInfoRecord2.getCollapsed() != bool2.booleanValue())) {
            if (columnInfoRecord2.getFirstColumn() == i && columnInfoRecord2.getLastColumn() == i) {
                setColumnInfoFields(columnInfoRecord2, sh, num, num2, bool, bool2);
                attemptMergeColInfoRecords(i2);
                return;
            }
            if (columnInfoRecord2.getFirstColumn() == i || columnInfoRecord2.getLastColumn() == i) {
                if (columnInfoRecord2.getFirstColumn() == i) {
                    columnInfoRecord2.setFirstColumn(i + 1);
                } else {
                    columnInfoRecord2.setLastColumn(i - 1);
                    i2++;
                }
                ColumnInfoRecord columnInfoRecordCopyColInfo = copyColInfo(columnInfoRecord2);
                columnInfoRecordCopyColInfo.setFirstColumn(i);
                columnInfoRecordCopyColInfo.setLastColumn(i);
                setColumnInfoFields(columnInfoRecordCopyColInfo, sh, num, num2, bool, bool2);
                insertColumn(i2, columnInfoRecordCopyColInfo);
                attemptMergeColInfoRecords(i2);
                return;
            }
            ColumnInfoRecord columnInfoRecordCopyColInfo2 = copyColInfo(columnInfoRecord2);
            ColumnInfoRecord columnInfoRecordCopyColInfo3 = copyColInfo(columnInfoRecord2);
            int lastColumn = columnInfoRecord2.getLastColumn();
            columnInfoRecord2.setLastColumn(i - 1);
            columnInfoRecordCopyColInfo2.setFirstColumn(i);
            columnInfoRecordCopyColInfo2.setLastColumn(i);
            setColumnInfoFields(columnInfoRecordCopyColInfo2, sh, num, num2, bool, bool2);
            int i3 = i2 + 1;
            insertColumn(i3, columnInfoRecordCopyColInfo2);
            columnInfoRecordCopyColInfo3.setFirstColumn(i + 1);
            columnInfoRecordCopyColInfo3.setLastColumn(lastColumn);
            insertColumn(i3 + 1, columnInfoRecordCopyColInfo3);
        }
    }

    private static void setColumnInfoFields(ColumnInfoRecord columnInfoRecord, Short sh, Integer num, Integer num2, Boolean bool, Boolean bool2) {
        if (sh != null) {
            columnInfoRecord.setXFIndex(sh.shortValue());
        }
        if (num != null) {
            columnInfoRecord.setColumnWidth(num.intValue());
        }
        if (num2 != null) {
            columnInfoRecord.setOutlineLevel(num2.shortValue());
        }
        if (bool != null) {
            columnInfoRecord.setHidden(bool.booleanValue());
        }
        if (bool2 != null) {
            columnInfoRecord.setCollapsed(bool2.booleanValue());
        }
    }

    private int findColInfoIdx(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("column parameter out of range: " + i);
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("fromIdx parameter out of range: " + i2);
        }
        while (i2 < this.records.size()) {
            ColumnInfoRecord colInfo = getColInfo(i2);
            if (colInfo.containsColumn(i)) {
                return i2;
            }
            if (colInfo.getFirstColumn() > i) {
                return -1;
            }
            i2++;
        }
        return -1;
    }

    private void attemptMergeColInfoRecords(int i) {
        int size = this.records.size();
        if (i < 0 || i >= size) {
            throw new IllegalArgumentException("colInfoIx " + i + " is out of range (0.." + (size - 1) + ")");
        }
        ColumnInfoRecord colInfo = getColInfo(i);
        int i2 = i + 1;
        if (i2 < size && mergeColInfoRecords(colInfo, getColInfo(i2))) {
            this.records.remove(i2);
        }
        if (i <= 0 || !mergeColInfoRecords(getColInfo(i - 1), colInfo)) {
            return;
        }
        this.records.remove(i);
    }

    private static boolean mergeColInfoRecords(ColumnInfoRecord columnInfoRecord, ColumnInfoRecord columnInfoRecord2) {
        if (!columnInfoRecord.isAdjacentBefore(columnInfoRecord2) || !columnInfoRecord.formatMatches(columnInfoRecord2)) {
            return false;
        }
        columnInfoRecord.setLastColumn(columnInfoRecord2.getLastColumn());
        return true;
    }

    public void groupColumnRange(int i, int i2, boolean z) {
        int iMax;
        int iMin;
        int i3 = 0;
        while (i <= i2) {
            int iFindColInfoIdx = findColInfoIdx(i, i3);
            if (iFindColInfoIdx != -1) {
                int outlineLevel = getColInfo(iFindColInfoIdx).getOutlineLevel();
                iMin = Math.min(7, Math.max(0, z ? outlineLevel + 1 : outlineLevel - 1));
                iMax = Math.max(0, iFindColInfoIdx - 1);
            } else {
                iMax = i3;
                iMin = 1;
            }
            setColumn(i, null, null, Integer.valueOf(iMin), null, null);
            i++;
            i3 = iMax;
        }
    }

    public ColumnInfoRecord findColumnInfo(int i) {
        int size = this.records.size();
        for (int i2 = 0; i2 < size; i2++) {
            ColumnInfoRecord colInfo = getColInfo(i2);
            if (colInfo.containsColumn(i)) {
                return colInfo;
            }
        }
        return null;
    }

    public int getMaxOutlineLevel() {
        int size = this.records.size();
        int iMax = 0;
        for (int i = 0; i < size; i++) {
            iMax = Math.max(getColInfo(i).getOutlineLevel(), iMax);
        }
        return iMax;
    }

    public int getOutlineLevel(int i) {
        ColumnInfoRecord columnInfoRecordFindColumnInfo = findColumnInfo(i);
        if (columnInfoRecordFindColumnInfo != null) {
            return columnInfoRecordFindColumnInfo.getOutlineLevel();
        }
        return 0;
    }
}
