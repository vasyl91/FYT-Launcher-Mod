package org.apache.poi.hssf.record.aggregates;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.CFHeader12Record;
import org.apache.poi.hssf.record.CFHeaderBase;
import org.apache.poi.hssf.record.CFHeaderRecord;
import org.apache.poi.hssf.record.CFRule12Record;
import org.apache.poi.hssf.record.CFRuleBase;
import org.apache.poi.hssf.record.CFRuleRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.ss.formula.FormulaShifter;
import org.apache.poi.ss.formula.ptg.AreaErrPtg;
import org.apache.poi.ss.formula.ptg.AreaPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class CFRecordsAggregate extends RecordAggregate {
    private static final int MAX_97_2003_CONDTIONAL_FORMAT_RULES = 3;
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) CFRecordsAggregate.class);
    private final CFHeaderBase header;
    private final List<CFRuleBase> rules;

    private CFRecordsAggregate(CFHeaderBase cFHeaderBase, CFRuleBase[] cFRuleBaseArr) {
        if (cFHeaderBase == null) {
            throw new IllegalArgumentException("header must not be null");
        }
        if (cFRuleBaseArr == null) {
            throw new IllegalArgumentException("rules must not be null");
        }
        if (cFRuleBaseArr.length > 3) {
            logger.log(5, "Excel versions before 2007 require that No more than 3 rules may be specified, " + cFRuleBaseArr.length + " were found, this file will cause problems with old Excel versions");
        }
        if (cFRuleBaseArr.length != cFHeaderBase.getNumberOfConditionalFormats()) {
            throw new RecordFormatException("Mismatch number of rules");
        }
        this.header = cFHeaderBase;
        this.rules = new ArrayList(cFRuleBaseArr.length);
        for (CFRuleBase cFRuleBase : cFRuleBaseArr) {
            checkRuleType(cFRuleBase);
            this.rules.add(cFRuleBase);
        }
    }

    public CFRecordsAggregate(CellRangeAddress[] cellRangeAddressArr, CFRuleBase[] cFRuleBaseArr) {
        this(createHeader(cellRangeAddressArr, cFRuleBaseArr), cFRuleBaseArr);
    }

    private static CFHeaderBase createHeader(CellRangeAddress[] cellRangeAddressArr, CFRuleBase[] cFRuleBaseArr) {
        CFHeaderBase cFHeaderRecord;
        if (cFRuleBaseArr.length == 0 || (cFRuleBaseArr[0] instanceof CFRuleRecord)) {
            cFHeaderRecord = new CFHeaderRecord(cellRangeAddressArr, cFRuleBaseArr.length);
        } else {
            cFHeaderRecord = new CFHeader12Record(cellRangeAddressArr, cFRuleBaseArr.length);
        }
        cFHeaderRecord.setNeedRecalculation(true);
        return cFHeaderRecord;
    }

    public static CFRecordsAggregate createCFAggregate(RecordStream recordStream) {
        Record next = recordStream.getNext();
        if (next.getSid() != 432 && next.getSid() != 2169) {
            throw new IllegalStateException("next record sid was " + ((int) next.getSid()) + " instead of 432 or 2169 as expected");
        }
        CFHeaderBase cFHeaderBase = (CFHeaderBase) next;
        int numberOfConditionalFormats = cFHeaderBase.getNumberOfConditionalFormats();
        CFRuleBase[] cFRuleBaseArr = new CFRuleBase[numberOfConditionalFormats];
        for (int i = 0; i < numberOfConditionalFormats; i++) {
            cFRuleBaseArr[i] = (CFRuleBase) recordStream.getNext();
        }
        return new CFRecordsAggregate(cFHeaderBase, cFRuleBaseArr);
    }

    public CFRecordsAggregate cloneCFAggregate() {
        int size = this.rules.size();
        CFRuleBase[] cFRuleBaseArr = new CFRuleBase[size];
        for (int i = 0; i < size; i++) {
            cFRuleBaseArr[i] = getRule(i).clone();
        }
        return new CFRecordsAggregate(this.header.clone(), cFRuleBaseArr);
    }

    public CFHeaderBase getHeader() {
        return this.header;
    }

    private void checkRuleIndex(int i) {
        if (i < 0 || i >= this.rules.size()) {
            throw new IllegalArgumentException("Bad rule record index (" + i + ") nRules=" + this.rules.size());
        }
    }

    private void checkRuleType(CFRuleBase cFRuleBase) {
        CFHeaderBase cFHeaderBase = this.header;
        if ((cFHeaderBase instanceof CFHeaderRecord) && (cFRuleBase instanceof CFRuleRecord)) {
            return;
        }
        if (!(cFHeaderBase instanceof CFHeader12Record) || !(cFRuleBase instanceof CFRule12Record)) {
            throw new IllegalArgumentException("Header and Rule must both be CF or both be CF12, can't mix");
        }
    }

    public CFRuleBase getRule(int i) {
        checkRuleIndex(i);
        return this.rules.get(i);
    }

    public void setRule(int i, CFRuleBase cFRuleBase) {
        if (cFRuleBase == null) {
            throw new IllegalArgumentException("r must not be null");
        }
        checkRuleIndex(i);
        checkRuleType(cFRuleBase);
        this.rules.set(i, cFRuleBase);
    }

    public void addRule(CFRuleBase cFRuleBase) {
        if (cFRuleBase == null) {
            throw new IllegalArgumentException("r must not be null");
        }
        if (this.rules.size() >= 3) {
            logger.log(5, "Excel versions before 2007 cannot cope with any more than 3 - this file will cause problems with old Excel versions");
        }
        checkRuleType(cFRuleBase);
        this.rules.add(cFRuleBase);
        this.header.setNumberOfConditionalFormats(this.rules.size());
    }

    public int getNumberOfRules() {
        return this.rules.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String str = this.header instanceof CFHeader12Record ? "CF12" : "CF";
        sb.append(str).append("]\n");
        CFHeaderBase cFHeaderBase = this.header;
        if (cFHeaderBase != null) {
            sb.append(cFHeaderBase);
        }
        Iterator<CFRuleBase> it = this.rules.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        sb.append("[/").append(str).append("]\n");
        return sb.toString();
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate
    public void visitContainedRecords(RecordAggregate.RecordVisitor recordVisitor) {
        recordVisitor.visitRecord(this.header);
        Iterator<CFRuleBase> it = this.rules.iterator();
        while (it.hasNext()) {
            recordVisitor.visitRecord(it.next());
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public boolean updateFormulasAfterCellShift(FormulaShifter formulaShifter, int i) {
        CFRule12Record cFRule12Record;
        Ptg[] parsedExpressionScale;
        CellRangeAddress[] cellRanges = this.header.getCellRanges();
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (CellRangeAddress cellRangeAddress : cellRanges) {
            CellRangeAddress cellRangeAddressShiftRange = shiftRange(formulaShifter, cellRangeAddress, i);
            if (cellRangeAddressShiftRange == null) {
                z = true;
            } else {
                arrayList.add(cellRangeAddressShiftRange);
                if (cellRangeAddressShiftRange != cellRangeAddress) {
                    z = true;
                }
            }
        }
        if (z) {
            int size = arrayList.size();
            if (size == 0) {
                return false;
            }
            CellRangeAddress[] cellRangeAddressArr = new CellRangeAddress[size];
            arrayList.toArray(cellRangeAddressArr);
            this.header.setCellRanges(cellRangeAddressArr);
        }
        for (CFRuleBase cFRuleBase : this.rules) {
            Ptg[] parsedExpression1 = cFRuleBase.getParsedExpression1();
            if (parsedExpression1 != null && formulaShifter.adjustFormula(parsedExpression1, i)) {
                cFRuleBase.setParsedExpression1(parsedExpression1);
            }
            Ptg[] parsedExpression2 = cFRuleBase.getParsedExpression2();
            if (parsedExpression2 != null && formulaShifter.adjustFormula(parsedExpression2, i)) {
                cFRuleBase.setParsedExpression2(parsedExpression2);
            }
            if ((cFRuleBase instanceof CFRule12Record) && (parsedExpressionScale = (cFRule12Record = (CFRule12Record) cFRuleBase).getParsedExpressionScale()) != null && formulaShifter.adjustFormula(parsedExpressionScale, i)) {
                cFRule12Record.setParsedExpressionScale(parsedExpressionScale);
            }
        }
        return true;
    }

    private static CellRangeAddress shiftRange(FormulaShifter formulaShifter, CellRangeAddress cellRangeAddress, int i) {
        Ptg[] ptgArr = {new AreaPtg(cellRangeAddress.getFirstRow(), cellRangeAddress.getLastRow(), cellRangeAddress.getFirstColumn(), cellRangeAddress.getLastColumn(), false, false, false, false)};
        if (!formulaShifter.adjustFormula(ptgArr, i)) {
            return cellRangeAddress;
        }
        Ptg ptg = ptgArr[0];
        if (ptg instanceof AreaPtg) {
            AreaPtg areaPtg = (AreaPtg) ptg;
            return new CellRangeAddress(areaPtg.getFirstRow(), areaPtg.getLastRow(), areaPtg.getFirstColumn(), areaPtg.getLastColumn());
        }
        if (ptg instanceof AreaErrPtg) {
            return null;
        }
        throw new IllegalStateException("Unexpected shifted ptg class (" + ptg.getClass().getName() + ")");
    }
}
