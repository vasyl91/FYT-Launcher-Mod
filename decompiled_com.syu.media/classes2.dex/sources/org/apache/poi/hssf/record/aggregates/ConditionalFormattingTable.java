package org.apache.poi.hssf.record.aggregates;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.CFHeader12Record;
import org.apache.poi.hssf.record.CFHeaderRecord;
import org.apache.poi.ss.formula.FormulaShifter;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ConditionalFormattingTable extends RecordAggregate {
    private final List<CFRecordsAggregate> _cfHeaders;

    public ConditionalFormattingTable() {
        this._cfHeaders = new ArrayList();
    }

    public ConditionalFormattingTable(RecordStream recordStream) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            if (recordStream.peekNextClass() == CFHeaderRecord.class || recordStream.peekNextClass() == CFHeader12Record.class) {
                arrayList.add(CFRecordsAggregate.createCFAggregate(recordStream));
            } else {
                this._cfHeaders = arrayList;
                return;
            }
        }
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate
    public void visitContainedRecords(RecordAggregate.RecordVisitor recordVisitor) {
        Iterator<CFRecordsAggregate> it = this._cfHeaders.iterator();
        while (it.hasNext()) {
            it.next().visitContainedRecords(recordVisitor);
        }
    }

    public int add(CFRecordsAggregate cFRecordsAggregate) {
        cFRecordsAggregate.getHeader().setID(this._cfHeaders.size());
        this._cfHeaders.add(cFRecordsAggregate);
        return this._cfHeaders.size() - 1;
    }

    public int size() {
        return this._cfHeaders.size();
    }

    public CFRecordsAggregate get(int i) {
        checkIndex(i);
        return this._cfHeaders.get(i);
    }

    public void remove(int i) {
        checkIndex(i);
        this._cfHeaders.remove(i);
    }

    private void checkIndex(int i) {
        if (i < 0 || i >= this._cfHeaders.size()) {
            throw new IllegalArgumentException("Specified CF index " + i + " is outside the allowable range (0.." + (this._cfHeaders.size() - 1) + ")");
        }
    }

    public void updateFormulasAfterCellShift(FormulaShifter formulaShifter, int i) {
        int i2 = 0;
        while (i2 < this._cfHeaders.size()) {
            if (!this._cfHeaders.get(i2).updateFormulasAfterCellShift(formulaShifter, i)) {
                this._cfHeaders.remove(i2);
                i2--;
            }
            i2++;
        }
    }
}
