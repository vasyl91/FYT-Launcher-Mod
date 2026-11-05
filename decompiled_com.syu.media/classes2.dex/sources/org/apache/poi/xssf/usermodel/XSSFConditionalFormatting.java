package org.apache.poi.xssf.usermodel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.ConditionalFormatting;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.util.CellRangeAddress;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFConditionalFormatting implements ConditionalFormatting {
    private final CTConditionalFormatting _cf;
    private final XSSFSheet _sh;

    XSSFConditionalFormatting(XSSFSheet xSSFSheet) {
        this._cf = CTConditionalFormatting.Factory.newInstance();
        this._sh = xSSFSheet;
    }

    XSSFConditionalFormatting(XSSFSheet xSSFSheet, CTConditionalFormatting cTConditionalFormatting) {
        this._cf = cTConditionalFormatting;
        this._sh = xSSFSheet;
    }

    CTConditionalFormatting getCTConditionalFormatting() {
        return this._cf;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormatting
    public CellRangeAddress[] getFormattingRanges() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this._cf.getSqref().iterator();
        while (it.hasNext()) {
            for (String str : it.next().toString().split(" ")) {
                arrayList.add(CellRangeAddress.valueOf(str));
            }
        }
        return (CellRangeAddress[]) arrayList.toArray(new CellRangeAddress[arrayList.size()]);
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormatting
    public void setFormattingRanges(CellRangeAddress[] cellRangeAddressArr) {
        if (cellRangeAddressArr == null) {
            throw new IllegalArgumentException("cellRanges must not be null");
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (CellRangeAddress cellRangeAddress : cellRangeAddressArr) {
            if (z) {
                z = false;
            } else {
                sb.append(" ");
            }
            sb.append(cellRangeAddress.formatAsString());
        }
        this._cf.setSqref(Collections.singletonList(sb.toString()));
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormatting
    public void setRule(int i, ConditionalFormattingRule conditionalFormattingRule) {
        this._cf.getCfRuleArray(i).set(((XSSFConditionalFormattingRule) conditionalFormattingRule).getCTCfRule());
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormatting
    public void addRule(ConditionalFormattingRule conditionalFormattingRule) {
        this._cf.addNewCfRule().set(((XSSFConditionalFormattingRule) conditionalFormattingRule).getCTCfRule());
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormatting
    public XSSFConditionalFormattingRule getRule(int i) {
        return new XSSFConditionalFormattingRule(this._sh, this._cf.getCfRuleArray(i));
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormatting
    public int getNumberOfRules() {
        return this._cf.sizeOfCfRuleArray();
    }

    public String toString() {
        return this._cf.toString();
    }
}
