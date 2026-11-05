package org.apache.poi.hssf.eventusermodel;

import org.apache.poi.hssf.eventusermodel.dummyrecord.LastCellOfRowDummyRecord;
import org.apache.poi.hssf.eventusermodel.dummyrecord.MissingCellDummyRecord;
import org.apache.poi.hssf.eventusermodel.dummyrecord.MissingRowDummyRecord;
import org.apache.poi.hssf.record.BOFRecord;
import org.apache.poi.hssf.record.CellValueRecordInterface;
import org.apache.poi.hssf.record.MulBlankRecord;
import org.apache.poi.hssf.record.MulRKRecord;
import org.apache.poi.hssf.record.NoteRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordFactory;
import org.apache.poi.hssf.record.RowRecord;
import org.apache.poi.hssf.record.StringRecord;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class MissingRecordAwareHSSFListener implements HSSFListener {
    private HSSFListener childListener;
    private int lastCellColumn;
    private int lastCellRow;
    private int lastRowRow;

    public MissingRecordAwareHSSFListener(HSSFListener hSSFListener) {
        resetCounts();
        this.childListener = hSSFListener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.poi.hssf.eventusermodel.HSSFListener
    public void processRecord(Record record) {
        int row;
        int column;
        Object[] objArr = 0;
        objArr = 0;
        objConvertRKRecords = null;
        objConvertRKRecords = null;
        objConvertRKRecords = null;
        Object objConvertRKRecords = null;
        if (record instanceof CellValueRecordInterface) {
            CellValueRecordInterface cellValueRecordInterface = (CellValueRecordInterface) record;
            row = cellValueRecordInterface.getRow();
            column = cellValueRecordInterface.getColumn();
        } else {
            if (record instanceof StringRecord) {
                this.childListener.processRecord(record);
                return;
            }
            short sid = record.getSid();
            if (sid != 28) {
                if (sid == 520) {
                    RowRecord rowRecord = (RowRecord) record;
                    if (this.lastRowRow + 1 < rowRecord.getRowNumber()) {
                        int i = this.lastRowRow;
                        while (true) {
                            i++;
                            if (i >= rowRecord.getRowNumber()) {
                                break;
                            } else {
                                this.childListener.processRecord(new MissingRowDummyRecord(i));
                            }
                        }
                    }
                    this.lastRowRow = rowRecord.getRowNumber();
                    this.lastCellColumn = -1;
                } else {
                    if (sid == 1212) {
                        this.childListener.processRecord(record);
                        return;
                    }
                    if (sid == 2057) {
                        BOFRecord bOFRecord = (BOFRecord) record;
                        if (bOFRecord.getType() == 5 || bOFRecord.getType() == 16) {
                            resetCounts();
                        }
                    } else if (sid == 189) {
                        objConvertRKRecords = RecordFactory.convertRKRecords((MulRKRecord) record);
                    } else if (sid == 190) {
                        objConvertRKRecords = RecordFactory.convertBlankRecords((MulBlankRecord) record);
                    }
                }
                column = -1;
                row = -1;
                objArr = objConvertRKRecords;
            } else {
                NoteRecord noteRecord = (NoteRecord) record;
                row = noteRecord.getRow();
                column = noteRecord.getColumn();
            }
        }
        if (objArr != 0 && objArr.length > 0) {
            row = objArr[0].getRow();
            column = objArr[0].getColumn();
        }
        int i2 = this.lastCellRow;
        if (row != i2 && row > 0) {
            if (i2 == -1) {
                this.lastCellRow = 0;
            }
            int i3 = this.lastCellRow;
            while (i3 < row) {
                this.childListener.processRecord(new LastCellOfRowDummyRecord(i3, i3 == this.lastCellRow ? this.lastCellColumn : -1));
                i3++;
            }
        }
        if (this.lastCellRow != -1 && this.lastCellColumn != -1 && row == -1) {
            this.childListener.processRecord(new LastCellOfRowDummyRecord(this.lastCellRow, this.lastCellColumn));
            this.lastCellRow = -1;
            this.lastCellColumn = -1;
        }
        if (row != this.lastCellRow) {
            this.lastCellColumn = -1;
        }
        int i4 = this.lastCellColumn;
        if (i4 != column - 1) {
            while (true) {
                i4++;
                if (i4 >= column) {
                    break;
                } else {
                    this.childListener.processRecord(new MissingCellDummyRecord(row, i4));
                }
            }
        }
        if (objArr != 0 && objArr.length > 0) {
            column = objArr[objArr.length - 1].getColumn();
        }
        if (column != -1) {
            this.lastCellColumn = column;
            this.lastCellRow = row;
        }
        if (objArr != 0 && objArr.length > 0) {
            for (Object[] objArr2 : objArr) {
                this.childListener.processRecord((Record) objArr2);
            }
            return;
        }
        this.childListener.processRecord(record);
    }

    private void resetCounts() {
        this.lastRowRow = -1;
        this.lastCellRow = -1;
        this.lastCellColumn = -1;
    }
}
