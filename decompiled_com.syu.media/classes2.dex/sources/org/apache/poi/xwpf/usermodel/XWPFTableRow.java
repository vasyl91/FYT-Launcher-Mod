package org.apache.poi.xwpf.usermodel;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.util.Internal;
import org.apache.poi.xwpf.model.WMLHelper;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XWPFTableRow {
    private CTRow ctRow;
    private XWPFTable table;
    private List<XWPFTableCell> tableCells;

    public XWPFTableRow(CTRow cTRow, XWPFTable xWPFTable) {
        this.table = xWPFTable;
        this.ctRow = cTRow;
        getTableCells();
    }

    @Internal
    public CTRow getCtRow() {
        return this.ctRow;
    }

    public XWPFTableCell createCell() {
        XWPFTableCell xWPFTableCell = new XWPFTableCell(this.ctRow.addNewTc(), this, this.table.getBody());
        this.tableCells.add(xWPFTableCell);
        return xWPFTableCell;
    }

    public XWPFTableCell getCell(int i) {
        if (i < 0 || i >= this.ctRow.sizeOfTcArray()) {
            return null;
        }
        return getTableCells().get(i);
    }

    public void removeCell(int i) {
        if (i < 0 || i >= this.ctRow.sizeOfTcArray()) {
            return;
        }
        this.tableCells.remove(i);
    }

    public XWPFTableCell addNewTableCell() {
        XWPFTableCell xWPFTableCell = new XWPFTableCell(this.ctRow.addNewTc(), this, this.table.getBody());
        this.tableCells.add(xWPFTableCell);
        return xWPFTableCell;
    }

    public int getHeight() {
        CTTrPr trPr = getTrPr();
        if (trPr.sizeOfTrHeightArray() == 0) {
            return 0;
        }
        return trPr.getTrHeightArray(0).getVal().intValue();
    }

    public void setHeight(int i) {
        CTTrPr trPr = getTrPr();
        (trPr.sizeOfTrHeightArray() == 0 ? trPr.addNewTrHeight() : trPr.getTrHeightArray(0)).setVal(new BigInteger("" + i));
    }

    private CTTrPr getTrPr() {
        return this.ctRow.isSetTrPr() ? this.ctRow.getTrPr() : this.ctRow.addNewTrPr();
    }

    public XWPFTable getTable() {
        return this.table;
    }

    public List<ICell> getTableICells() {
        ArrayList arrayList = new ArrayList();
        XmlCursor xmlCursorNewCursor = this.ctRow.newCursor();
        xmlCursorNewCursor.selectPath("./*");
        while (xmlCursorNewCursor.toNextSelection()) {
            CTSdtCell object = xmlCursorNewCursor.getObject();
            if (object instanceof CTTc) {
                arrayList.add(new XWPFTableCell((CTTc) object, this, this.table.getBody()));
            } else if (object instanceof CTSdtCell) {
                arrayList.add(new XWPFSDTCell(object, this, this.table.getBody()));
            }
        }
        xmlCursorNewCursor.dispose();
        return arrayList;
    }

    public List<XWPFTableCell> getTableCells() {
        if (this.tableCells == null) {
            ArrayList arrayList = new ArrayList();
            for (CTTc cTTc : this.ctRow.getTcArray()) {
                arrayList.add(new XWPFTableCell(cTTc, this, this.table.getBody()));
            }
            this.tableCells = arrayList;
        }
        return this.tableCells;
    }

    public XWPFTableCell getTableCell(CTTc cTTc) {
        for (int i = 0; i < this.tableCells.size(); i++) {
            if (this.tableCells.get(i).getCTTc() == cTTc) {
                return this.tableCells.get(i);
            }
        }
        return null;
    }

    public boolean isCantSplitRow() {
        if (!this.ctRow.isSetTrPr()) {
            return false;
        }
        CTTrPr trPr = getTrPr();
        if (trPr.sizeOfCantSplitArray() <= 0) {
            return false;
        }
        CTOnOff cantSplitArray = trPr.getCantSplitArray(0);
        return cantSplitArray.isSetVal() ? WMLHelper.convertSTOnOffToBoolean(cantSplitArray.getVal()) : true;
    }

    public void setCantSplitRow(boolean z) {
        CTTrPr trPr = getTrPr();
        (trPr.sizeOfCantSplitArray() > 0 ? trPr.getCantSplitArray(0) : trPr.addNewCantSplit()).setVal(WMLHelper.convertBooleanToSTOnOff(z));
    }

    public boolean isRepeatHeader() {
        boolean z = false;
        for (XWPFTableRow xWPFTableRow : this.table.getRows()) {
            boolean repeat = xWPFTableRow.getRepeat();
            if (xWPFTableRow == this || !repeat) {
                return repeat;
            }
            z = repeat;
        }
        return z;
    }

    private boolean getRepeat() {
        if (!this.ctRow.isSetTrPr()) {
            return false;
        }
        CTTrPr trPr = getTrPr();
        if (trPr.sizeOfTblHeaderArray() <= 0) {
            return false;
        }
        CTOnOff tblHeaderArray = trPr.getTblHeaderArray(0);
        return tblHeaderArray.isSetVal() ? WMLHelper.convertSTOnOffToBoolean(tblHeaderArray.getVal()) : true;
    }

    public void setRepeatHeader(boolean z) {
        CTTrPr trPr = getTrPr();
        (trPr.sizeOfTblHeaderArray() > 0 ? trPr.getTblHeaderArray(0) : trPr.addNewTblHeader()).setVal(WMLHelper.convertBooleanToSTOnOff(z));
    }
}
