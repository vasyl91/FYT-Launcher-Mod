package org.apache.poi.hssf.record.aggregates;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.MergeCellsRecord;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class MergedCellsTable extends RecordAggregate {
    private static int MAX_MERGED_REGIONS = 1027;
    private final List<CellRangeAddress> _mergedRegions = new ArrayList();

    public void read(RecordStream recordStream) {
        List<CellRangeAddress> list = this._mergedRegions;
        while (recordStream.peekNextClass() == MergeCellsRecord.class) {
            MergeCellsRecord mergeCellsRecord = (MergeCellsRecord) recordStream.getNext();
            short numAreas = mergeCellsRecord.getNumAreas();
            for (int i = 0; i < numAreas; i++) {
                list.add(mergeCellsRecord.getAreaAt(i));
            }
        }
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate, org.apache.poi.hssf.record.RecordBase
    public int getRecordSize() {
        int size = this._mergedRegions.size();
        if (size < 1) {
            return 0;
        }
        int i = MAX_MERGED_REGIONS;
        return ((size / i) * (CellRangeAddressList.getEncodedSize(i) + 4)) + 4 + CellRangeAddressList.getEncodedSize(size % i);
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate
    public void visitContainedRecords(RecordAggregate.RecordVisitor recordVisitor) {
        int size = this._mergedRegions.size();
        if (size < 1) {
            return;
        }
        int i = MAX_MERGED_REGIONS;
        int i2 = size / i;
        int i3 = size % i;
        CellRangeAddress[] cellRangeAddressArr = new CellRangeAddress[size];
        this._mergedRegions.toArray(cellRangeAddressArr);
        for (int i4 = 0; i4 < i2; i4++) {
            recordVisitor.visitRecord(new MergeCellsRecord(cellRangeAddressArr, MAX_MERGED_REGIONS * i4, MAX_MERGED_REGIONS));
        }
        if (i3 > 0) {
            recordVisitor.visitRecord(new MergeCellsRecord(cellRangeAddressArr, i2 * MAX_MERGED_REGIONS, i3));
        }
    }

    public void addRecords(MergeCellsRecord[] mergeCellsRecordArr) {
        for (MergeCellsRecord mergeCellsRecord : mergeCellsRecordArr) {
            addMergeCellsRecord(mergeCellsRecord);
        }
    }

    private void addMergeCellsRecord(MergeCellsRecord mergeCellsRecord) {
        short numAreas = mergeCellsRecord.getNumAreas();
        for (int i = 0; i < numAreas; i++) {
            this._mergedRegions.add(mergeCellsRecord.getAreaAt(i));
        }
    }

    public CellRangeAddress get(int i) {
        checkIndex(i);
        return this._mergedRegions.get(i);
    }

    public void remove(int i) {
        checkIndex(i);
        this._mergedRegions.remove(i);
    }

    private void checkIndex(int i) {
        if (i < 0 || i >= this._mergedRegions.size()) {
            throw new IllegalArgumentException("Specified CF index " + i + " is outside the allowable range (0.." + (this._mergedRegions.size() - 1) + ")");
        }
    }

    public void addArea(int i, int i2, int i3, int i4) {
        this._mergedRegions.add(new CellRangeAddress(i, i3, i2, i4));
    }

    public int getNumberOfMergedRegions() {
        return this._mergedRegions.size();
    }
}
