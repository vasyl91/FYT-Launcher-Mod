package org.apache.poi.hssf.model;

import java.util.List;
import module.canbus.FinalCanbus;
import org.apache.poi.hssf.record.DimensionsRecord;
import org.apache.poi.hssf.record.EOFRecord;
import org.apache.poi.hssf.record.GutsRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordBase;
import org.apache.poi.hssf.record.aggregates.ColumnInfoRecordsAggregate;
import org.apache.poi.hssf.record.aggregates.ConditionalFormattingTable;
import org.apache.poi.hssf.record.aggregates.DataValidityTable;
import org.apache.poi.hssf.record.aggregates.MergedCellsTable;
import org.apache.poi.hssf.record.aggregates.PageSettingsBlock;
import org.apache.poi.hssf.record.aggregates.WorksheetProtectionBlock;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
final class RecordOrderer {
    private static boolean isDVTSubsequentRecord(short s) {
        return s == 10 || s == 2146 || s == 2248 || s == 2151 || s == 2152;
    }

    public static boolean isRowBlockRecord(int i) {
        if (i == 6 || i == 253 || i == 513 || i == 520 || i == 545 || i == 566 || i == 638 || i == 1212) {
            return true;
        }
        switch (i) {
            case FinalCanbus.U_CAR_SEAT_BELT_RIGHT /* 515 */:
            case FinalCanbus.U_CAR_ACCON /* 516 */:
            case FinalCanbus.U_CAR_LIGHT /* 517 */:
                return true;
            default:
                return false;
        }
    }

    private RecordOrderer() {
    }

    public static void addNewSheetRecord(List<RecordBase> list, RecordBase recordBase) {
        list.add(findSheetInsertPos(list, recordBase.getClass()), recordBase);
    }

    private static int findSheetInsertPos(List<RecordBase> list, Class<? extends RecordBase> cls) {
        if (cls == DataValidityTable.class) {
            return findDataValidationTableInsertPos(list);
        }
        if (cls == MergedCellsTable.class) {
            return findInsertPosForNewMergedRecordTable(list);
        }
        if (cls == ConditionalFormattingTable.class) {
            return findInsertPosForNewCondFormatTable(list);
        }
        if (cls == GutsRecord.class) {
            return getGutsRecordInsertPos(list);
        }
        if (cls == PageSettingsBlock.class) {
            return getPageBreakRecordInsertPos(list);
        }
        if (cls == WorksheetProtectionBlock.class) {
            return getWorksheetProtectionBlockInsertPos(list);
        }
        throw new RuntimeException("Unexpected record class (" + cls.getName() + ")");
    }

    private static int getWorksheetProtectionBlockInsertPos(List<RecordBase> list) {
        int dimensionsIndex = getDimensionsIndex(list);
        while (dimensionsIndex > 0) {
            dimensionsIndex--;
            if (!isProtectionSubsequentRecord(list.get(dimensionsIndex))) {
                return dimensionsIndex + 1;
            }
        }
        throw new IllegalStateException("did not find insert pos for protection block");
    }

    private static boolean isProtectionSubsequentRecord(Object obj) {
        if (obj instanceof ColumnInfoRecordsAggregate) {
            return true;
        }
        if (!(obj instanceof Record)) {
            return false;
        }
        short sid = ((Record) obj).getSid();
        return sid == 85 || sid == 144;
    }

    private static int getPageBreakRecordInsertPos(List<RecordBase> list) {
        int dimensionsIndex = getDimensionsIndex(list) - 1;
        while (dimensionsIndex > 0) {
            dimensionsIndex--;
            if (isPageBreakPriorRecord(list.get(dimensionsIndex))) {
                return dimensionsIndex + 1;
            }
        }
        throw new RuntimeException("Did not find insert point for GUTS");
    }

    private static boolean isPageBreakPriorRecord(Object obj) {
        if (!(obj instanceof Record)) {
            return false;
        }
        short sid = ((Record) obj).getSid();
        if (sid == 34 || sid == 523 || sid == 549 || sid == 2057 || sid == 42 || sid == 43 || sid == 94 || sid == 95 || sid == 129 || sid == 130) {
            return true;
        }
        switch (sid) {
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                return true;
            default:
                return false;
        }
    }

    private static int findInsertPosForNewCondFormatTable(List<RecordBase> list) {
        short sid;
        for (int size = list.size() - 2; size >= 0; size--) {
            RecordBase recordBase = list.get(size);
            if (recordBase instanceof MergedCellsTable) {
                return size + 1;
            }
            if (!(recordBase instanceof DataValidityTable) && ((sid = ((Record) recordBase).getSid()) == 29 || sid == 65 || sid == 153 || sid == 160 || sid == 239 || sid == 351 || sid == 574)) {
                return size + 1;
            }
        }
        throw new RuntimeException("Did not find Window2 record");
    }

    private static int findInsertPosForNewMergedRecordTable(List<RecordBase> list) {
        short sid;
        for (int size = list.size() - 2; size >= 0; size--) {
            RecordBase recordBase = list.get(size);
            if ((recordBase instanceof Record) && ((sid = ((Record) recordBase).getSid()) == 29 || sid == 65 || sid == 153 || sid == 160 || sid == 574)) {
                return size + 1;
            }
        }
        throw new RuntimeException("Did not find Window2 record");
    }

    private static int findDataValidationTableInsertPos(List<RecordBase> list) {
        int size = list.size() - 1;
        if (!(list.get(size) instanceof EOFRecord)) {
            throw new IllegalStateException("Last sheet record should be EOFRecord");
        }
        while (size > 0) {
            size--;
            RecordBase recordBase = list.get(size);
            if (isDVTPriorRecord(recordBase)) {
                int i = size + 1;
                Record record = (Record) list.get(i);
                if (isDVTSubsequentRecord(record.getSid())) {
                    return i;
                }
                throw new IllegalStateException("Unexpected (" + record.getClass().getName() + ") found after (" + recordBase.getClass().getName() + ")");
            }
            Record record2 = (Record) recordBase;
            if (!isDVTSubsequentRecord(record2.getSid())) {
                throw new IllegalStateException("Unexpected (" + record2.getClass().getName() + ") while looking for DV Table insert pos");
            }
        }
        return 0;
    }

    private static boolean isDVTPriorRecord(RecordBase recordBase) {
        short sid;
        return (recordBase instanceof MergedCellsTable) || (recordBase instanceof ConditionalFormattingTable) || (sid = ((Record) recordBase).getSid()) == 29 || sid == 65 || sid == 153 || sid == 160 || sid == 239 || sid == 351 || sid == 440 || sid == 442 || sid == 574 || sid == 2048;
    }

    private static int getDimensionsIndex(List<RecordBase> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i) instanceof DimensionsRecord) {
                return i;
            }
        }
        throw new RuntimeException("DimensionsRecord not found");
    }

    private static int getGutsRecordInsertPos(List<RecordBase> list) {
        int dimensionsIndex = getDimensionsIndex(list) - 1;
        while (dimensionsIndex > 0) {
            dimensionsIndex--;
            if (isGutsPriorRecord(list.get(dimensionsIndex))) {
                return dimensionsIndex + 1;
            }
        }
        throw new RuntimeException("Did not find insert point for GUTS");
    }

    private static boolean isGutsPriorRecord(RecordBase recordBase) {
        if (!(recordBase instanceof Record)) {
            return false;
        }
        short sid = ((Record) recordBase).getSid();
        if (sid == 34 || sid == 130 || sid == 523 || sid == 2057 || sid == 42 || sid == 43 || sid == 94 || sid == 95) {
            return true;
        }
        switch (sid) {
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                return true;
            default:
                return false;
        }
    }

    public static boolean isEndOfRowBlock(int i) {
        if (i == 10) {
            throw new RuntimeException("Found EOFRecord before WindowTwoRecord was encountered");
        }
        if (i == 61 || i == 93 || i == 125 || i == 128 || i == 176 || i == 434 || i == 438 || i == 574 || i == 236 || i == 237) {
            return true;
        }
        return PageSettingsBlock.isComponentRecord(i);
    }
}
