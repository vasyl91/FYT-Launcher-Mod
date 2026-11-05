package org.apache.poi.hssf.record;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.ss.util.CellRangeUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class CFHeaderBase extends StandardRecord implements Cloneable {
    private int field_1_numcf;
    private int field_2_need_recalculation_and_id;
    private CellRangeAddress field_3_enclosing_cell_range;
    private CellRangeAddressList field_4_cell_ranges;

    @Override // org.apache.poi.hssf.record.Record
    public abstract CFHeaderBase clone();

    protected abstract String getRecordName();

    protected CFHeaderBase() {
    }

    protected CFHeaderBase(CellRangeAddress[] cellRangeAddressArr, int i) {
        setCellRanges(CellRangeUtil.mergeCellRanges(cellRangeAddressArr));
        this.field_1_numcf = i;
    }

    protected void createEmpty() {
        this.field_3_enclosing_cell_range = new CellRangeAddress(0, 0, 0, 0);
        this.field_4_cell_ranges = new CellRangeAddressList();
    }

    protected void read(RecordInputStream recordInputStream) {
        this.field_1_numcf = recordInputStream.readShort();
        this.field_2_need_recalculation_and_id = recordInputStream.readShort();
        this.field_3_enclosing_cell_range = new CellRangeAddress(recordInputStream);
        this.field_4_cell_ranges = new CellRangeAddressList(recordInputStream);
    }

    public int getNumberOfConditionalFormats() {
        return this.field_1_numcf;
    }

    public void setNumberOfConditionalFormats(int i) {
        this.field_1_numcf = i;
    }

    public boolean getNeedRecalculation() {
        return (this.field_2_need_recalculation_and_id & 1) == 1;
    }

    public void setNeedRecalculation(boolean z) {
        if (z == getNeedRecalculation()) {
            return;
        }
        if (z) {
            this.field_2_need_recalculation_and_id++;
        } else {
            this.field_2_need_recalculation_and_id--;
        }
    }

    public int getID() {
        return this.field_2_need_recalculation_and_id >> 1;
    }

    public void setID(int i) {
        boolean needRecalculation = getNeedRecalculation();
        int i2 = i << 1;
        this.field_2_need_recalculation_and_id = i2;
        if (needRecalculation) {
            this.field_2_need_recalculation_and_id = i2 + 1;
        }
    }

    public CellRangeAddress getEnclosingCellRange() {
        return this.field_3_enclosing_cell_range;
    }

    public void setEnclosingCellRange(CellRangeAddress cellRangeAddress) {
        this.field_3_enclosing_cell_range = cellRangeAddress;
    }

    public void setCellRanges(CellRangeAddress[] cellRangeAddressArr) {
        if (cellRangeAddressArr == null) {
            throw new IllegalArgumentException("cellRanges must not be null");
        }
        CellRangeAddressList cellRangeAddressList = new CellRangeAddressList();
        CellRangeAddress cellRangeAddressCreateEnclosingCellRange = null;
        for (CellRangeAddress cellRangeAddress : cellRangeAddressArr) {
            cellRangeAddressCreateEnclosingCellRange = CellRangeUtil.createEnclosingCellRange(cellRangeAddress, cellRangeAddressCreateEnclosingCellRange);
            cellRangeAddressList.addCellRangeAddress(cellRangeAddress);
        }
        this.field_3_enclosing_cell_range = cellRangeAddressCreateEnclosingCellRange;
        this.field_4_cell_ranges = cellRangeAddressList;
    }

    public CellRangeAddress[] getCellRanges() {
        return this.field_4_cell_ranges.getCellRangeAddresses();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[");
        stringBuffer.append(getRecordName()).append("]\n\t.numCF             = ");
        stringBuffer.append(getNumberOfConditionalFormats()).append("\n\t.needRecalc        = ");
        stringBuffer.append(getNeedRecalculation()).append("\n\t.id                = ");
        stringBuffer.append(getID()).append("\n\t.enclosingCellRange= ");
        stringBuffer.append(getEnclosingCellRange()).append("\n\t.cfranges=[");
        int i = 0;
        while (i < this.field_4_cell_ranges.countRanges()) {
            stringBuffer.append(i == 0 ? "" : ",").append(this.field_4_cell_ranges.getCellRangeAddress(i));
            i++;
        }
        stringBuffer.append("]\n[/");
        stringBuffer.append(getRecordName()).append("]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return this.field_4_cell_ranges.getSize() + 12;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_numcf);
        littleEndianOutput.writeShort(this.field_2_need_recalculation_and_id);
        this.field_3_enclosing_cell_range.serialize(littleEndianOutput);
        this.field_4_cell_ranges.serialize(littleEndianOutput);
    }

    protected void copyTo(CFHeaderBase cFHeaderBase) {
        cFHeaderBase.field_1_numcf = this.field_1_numcf;
        cFHeaderBase.field_2_need_recalculation_and_id = this.field_2_need_recalculation_and_id;
        cFHeaderBase.field_3_enclosing_cell_range = this.field_3_enclosing_cell_range.copy();
        cFHeaderBase.field_4_cell_ranges = this.field_4_cell_ranges.copy();
    }
}
