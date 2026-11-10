package org.apache.poi.xwpf.usermodel;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XWPFTable implements IBodyElement, ISDTContents {
    private static HashMap<Integer, XWPFBorderType> stBorderTypeMap;
    private static EnumMap<XWPFBorderType, STBorder.Enum> xwpfBorderTypeMap;
    private CTTbl ctTbl;
    protected IBody part;
    protected List<XWPFTableRow> tableRows;
    protected StringBuffer text;

    public enum XWPFBorderType {
        NIL,
        NONE,
        SINGLE,
        THICK,
        DOUBLE,
        DOTTED,
        DASHED,
        DOT_DASH
    }

    public void addNewRowBetween(int i, int i2) {
    }

    static {
        EnumMap<XWPFBorderType, STBorder.Enum> enumMap = new EnumMap<>(XWPFBorderType.class);
        xwpfBorderTypeMap = enumMap;
        enumMap.put(XWPFBorderType.NIL, STBorder.Enum.forInt(1));
        xwpfBorderTypeMap.put(XWPFBorderType.NONE, STBorder.Enum.forInt(2));
        xwpfBorderTypeMap.put(XWPFBorderType.SINGLE, STBorder.Enum.forInt(3));
        xwpfBorderTypeMap.put(XWPFBorderType.THICK, STBorder.Enum.forInt(4));
        xwpfBorderTypeMap.put(XWPFBorderType.DOUBLE, STBorder.Enum.forInt(5));
        xwpfBorderTypeMap.put(XWPFBorderType.DOTTED, STBorder.Enum.forInt(6));
        xwpfBorderTypeMap.put(XWPFBorderType.DASHED, STBorder.Enum.forInt(7));
        xwpfBorderTypeMap.put(XWPFBorderType.DOT_DASH, STBorder.Enum.forInt(8));
        HashMap<Integer, XWPFBorderType> map = new HashMap<>();
        stBorderTypeMap = map;
        map.put(1, XWPFBorderType.NIL);
        stBorderTypeMap.put(2, XWPFBorderType.NONE);
        stBorderTypeMap.put(3, XWPFBorderType.SINGLE);
        stBorderTypeMap.put(4, XWPFBorderType.THICK);
        stBorderTypeMap.put(5, XWPFBorderType.DOUBLE);
        stBorderTypeMap.put(6, XWPFBorderType.DOTTED);
        stBorderTypeMap.put(7, XWPFBorderType.DASHED);
        stBorderTypeMap.put(8, XWPFBorderType.DOT_DASH);
    }

    public XWPFTable(CTTbl cTTbl, IBody iBody, int i, int i2) {
        this(cTTbl, iBody);
        for (int i3 = 0; i3 < i; i3++) {
            XWPFTableRow xWPFTableRowCreateRow = getRow(i3) == null ? createRow() : getRow(i3);
            for (int i4 = 0; i4 < i2; i4++) {
                if (xWPFTableRowCreateRow.getCell(i4) == null) {
                    xWPFTableRowCreateRow.createCell();
                }
            }
        }
    }

    public XWPFTable(CTTbl cTTbl, IBody iBody) {
        this.text = new StringBuffer();
        this.part = iBody;
        this.ctTbl = cTTbl;
        this.tableRows = new ArrayList();
        if (cTTbl.sizeOfTrArray() == 0) {
            createEmptyTable(cTTbl);
        }
        for (CTRow cTRow : cTTbl.getTrArray()) {
            StringBuilder sb = new StringBuilder();
            this.tableRows.add(new XWPFTableRow(cTRow, this));
            for (CTTc cTTc : cTRow.getTcArray()) {
                for (CTP ctp : cTTc.getPArray()) {
                    XWPFParagraph xWPFParagraph = new XWPFParagraph(ctp, iBody);
                    if (sb.length() > 0) {
                        sb.append('\t');
                    }
                    sb.append(xWPFParagraph.getText());
                }
            }
            if (sb.length() > 0) {
                this.text.append((CharSequence) sb);
                this.text.append('\n');
            }
        }
    }

    private void createEmptyTable(CTTbl cTTbl) {
        cTTbl.addNewTr().addNewTc().addNewP();
        CTTblPr cTTblPrAddNewTblPr = cTTbl.addNewTblPr();
        cTTblPrAddNewTblPr.addNewTblW().setW(new BigInteger("0"));
        cTTblPrAddNewTblPr.getTblW().setType(STTblWidth.AUTO);
        CTTblBorders cTTblBordersAddNewTblBorders = cTTblPrAddNewTblPr.addNewTblBorders();
        cTTblBordersAddNewTblBorders.addNewBottom().setVal(STBorder.SINGLE);
        cTTblBordersAddNewTblBorders.addNewInsideH().setVal(STBorder.SINGLE);
        cTTblBordersAddNewTblBorders.addNewInsideV().setVal(STBorder.SINGLE);
        cTTblBordersAddNewTblBorders.addNewLeft().setVal(STBorder.SINGLE);
        cTTblBordersAddNewTblBorders.addNewRight().setVal(STBorder.SINGLE);
        cTTblBordersAddNewTblBorders.addNewTop().setVal(STBorder.SINGLE);
        getRows();
    }

    @Internal
    public CTTbl getCTTbl() {
        return this.ctTbl;
    }

    public String getText() {
        return this.text.toString();
    }

    public void addNewCol() {
        if (this.ctTbl.sizeOfTrArray() == 0) {
            createRow();
        }
        for (int i = 0; i < this.ctTbl.sizeOfTrArray(); i++) {
            new XWPFTableRow(this.ctTbl.getTrArray(i), this).createCell();
        }
    }

    public XWPFTableRow createRow() {
        int iSizeOfTcArray = this.ctTbl.sizeOfTrArray() > 0 ? this.ctTbl.getTrArray(0).sizeOfTcArray() : 0;
        XWPFTableRow xWPFTableRow = new XWPFTableRow(this.ctTbl.addNewTr(), this);
        addColumn(xWPFTableRow, iSizeOfTcArray);
        this.tableRows.add(xWPFTableRow);
        return xWPFTableRow;
    }

    public XWPFTableRow getRow(int i) {
        if (i < 0 || i >= this.ctTbl.sizeOfTrArray()) {
            return null;
        }
        return getRows().get(i);
    }

    public int getWidth() {
        CTTblPr trPr = getTrPr();
        if (trPr.isSetTblW()) {
            return trPr.getTblW().getW().intValue();
        }
        return -1;
    }

    public void setWidth(int i) {
        CTTblPr trPr = getTrPr();
        (trPr.isSetTblW() ? trPr.getTblW() : trPr.addNewTblW()).setW(new BigInteger("" + i));
    }

    public int getNumberOfRows() {
        return this.ctTbl.sizeOfTrArray();
    }

    private CTTblPr getTrPr() {
        return this.ctTbl.getTblPr() != null ? this.ctTbl.getTblPr() : this.ctTbl.addNewTblPr();
    }

    private void addColumn(XWPFTableRow xWPFTableRow, int i) {
        if (i > 0) {
            for (int i2 = 0; i2 < i; i2++) {
                xWPFTableRow.createCell();
            }
        }
    }

    public String getStyleID() {
        CTString tblStyle;
        CTTblPr tblPr = this.ctTbl.getTblPr();
        if (tblPr == null || (tblStyle = tblPr.getTblStyle()) == null) {
            return null;
        }
        return tblStyle.getVal();
    }

    public void setStyleID(String str) {
        CTTblPr trPr = getTrPr();
        CTString tblStyle = trPr.getTblStyle();
        if (tblStyle == null) {
            tblStyle = trPr.addNewTblStyle();
        }
        tblStyle.setVal(str);
    }

    public XWPFBorderType getInsideHBorderType() {
        CTTblPr trPr = getTrPr();
        if (trPr.isSetTblBorders()) {
            CTTblBorders tblBorders = trPr.getTblBorders();
            if (tblBorders.isSetInsideH()) {
                return stBorderTypeMap.get(Integer.valueOf(tblBorders.getInsideH().getVal().intValue()));
            }
        }
        return null;
    }

    public int getInsideHBorderSize() {
        CTTblPr trPr = getTrPr();
        if (trPr.isSetTblBorders()) {
            CTTblBorders tblBorders = trPr.getTblBorders();
            if (tblBorders.isSetInsideH()) {
                return tblBorders.getInsideH().getSz().intValue();
            }
        }
        return -1;
    }

    public int getInsideHBorderSpace() {
        CTTblPr trPr = getTrPr();
        if (trPr.isSetTblBorders()) {
            CTTblBorders tblBorders = trPr.getTblBorders();
            if (tblBorders.isSetInsideH()) {
                return tblBorders.getInsideH().getSpace().intValue();
            }
        }
        return -1;
    }

    public String getInsideHBorderColor() {
        CTTblPr trPr = getTrPr();
        if (trPr.isSetTblBorders()) {
            CTTblBorders tblBorders = trPr.getTblBorders();
            if (tblBorders.isSetInsideH()) {
                return tblBorders.getInsideH().xgetColor().getStringValue();
            }
        }
        return null;
    }

    public XWPFBorderType getInsideVBorderType() {
        CTTblPr trPr = getTrPr();
        if (trPr.isSetTblBorders()) {
            CTTblBorders tblBorders = trPr.getTblBorders();
            if (tblBorders.isSetInsideV()) {
                return stBorderTypeMap.get(Integer.valueOf(tblBorders.getInsideV().getVal().intValue()));
            }
        }
        return null;
    }

    public int getInsideVBorderSize() {
        CTTblPr trPr = getTrPr();
        if (trPr.isSetTblBorders()) {
            CTTblBorders tblBorders = trPr.getTblBorders();
            if (tblBorders.isSetInsideV()) {
                return tblBorders.getInsideV().getSz().intValue();
            }
        }
        return -1;
    }

    public int getInsideVBorderSpace() {
        CTTblPr trPr = getTrPr();
        if (trPr.isSetTblBorders()) {
            CTTblBorders tblBorders = trPr.getTblBorders();
            if (tblBorders.isSetInsideV()) {
                return tblBorders.getInsideV().getSpace().intValue();
            }
        }
        return -1;
    }

    public String getInsideVBorderColor() {
        CTTblPr trPr = getTrPr();
        if (trPr.isSetTblBorders()) {
            CTTblBorders tblBorders = trPr.getTblBorders();
            if (tblBorders.isSetInsideV()) {
                return tblBorders.getInsideV().xgetColor().getStringValue();
            }
        }
        return null;
    }

    public int getRowBandSize() {
        CTTblPr trPr = getTrPr();
        if (trPr.isSetTblStyleRowBandSize()) {
            return trPr.getTblStyleRowBandSize().getVal().intValue();
        }
        return 0;
    }

    public void setRowBandSize(int i) {
        CTTblPr trPr = getTrPr();
        (trPr.isSetTblStyleRowBandSize() ? trPr.getTblStyleRowBandSize() : trPr.addNewTblStyleRowBandSize()).setVal(BigInteger.valueOf(i));
    }

    public int getColBandSize() {
        CTTblPr trPr = getTrPr();
        if (trPr.isSetTblStyleColBandSize()) {
            return trPr.getTblStyleColBandSize().getVal().intValue();
        }
        return 0;
    }

    public void setColBandSize(int i) {
        CTTblPr trPr = getTrPr();
        (trPr.isSetTblStyleColBandSize() ? trPr.getTblStyleColBandSize() : trPr.addNewTblStyleColBandSize()).setVal(BigInteger.valueOf(i));
    }

    public void setInsideHBorder(XWPFBorderType xWPFBorderType, int i, int i2, String str) {
        CTTblPr trPr = getTrPr();
        CTTblBorders tblBorders = trPr.isSetTblBorders() ? trPr.getTblBorders() : trPr.addNewTblBorders();
        CTBorder insideH = tblBorders.isSetInsideH() ? tblBorders.getInsideH() : tblBorders.addNewInsideH();
        insideH.setVal(xwpfBorderTypeMap.get(xWPFBorderType));
        insideH.setSz(BigInteger.valueOf(i));
        insideH.setSpace(BigInteger.valueOf(i2));
        insideH.setColor(str);
    }

    public void setInsideVBorder(XWPFBorderType xWPFBorderType, int i, int i2, String str) {
        CTTblPr trPr = getTrPr();
        CTTblBorders tblBorders = trPr.isSetTblBorders() ? trPr.getTblBorders() : trPr.addNewTblBorders();
        CTBorder insideV = tblBorders.isSetInsideV() ? tblBorders.getInsideV() : tblBorders.addNewInsideV();
        insideV.setVal(xwpfBorderTypeMap.get(xWPFBorderType));
        insideV.setSz(BigInteger.valueOf(i));
        insideV.setSpace(BigInteger.valueOf(i2));
        insideV.setColor(str);
    }

    public int getCellMarginTop() {
        CTTblWidth top;
        CTTblCellMar tblCellMar = getTrPr().getTblCellMar();
        if (tblCellMar == null || (top = tblCellMar.getTop()) == null) {
            return 0;
        }
        return top.getW().intValue();
    }

    public int getCellMarginLeft() {
        CTTblWidth left;
        CTTblCellMar tblCellMar = getTrPr().getTblCellMar();
        if (tblCellMar == null || (left = tblCellMar.getLeft()) == null) {
            return 0;
        }
        return left.getW().intValue();
    }

    public int getCellMarginBottom() {
        CTTblWidth bottom;
        CTTblCellMar tblCellMar = getTrPr().getTblCellMar();
        if (tblCellMar == null || (bottom = tblCellMar.getBottom()) == null) {
            return 0;
        }
        return bottom.getW().intValue();
    }

    public int getCellMarginRight() {
        CTTblWidth right;
        CTTblCellMar tblCellMar = getTrPr().getTblCellMar();
        if (tblCellMar == null || (right = tblCellMar.getRight()) == null) {
            return 0;
        }
        return right.getW().intValue();
    }

    public void setCellMargins(int i, int i2, int i3, int i4) {
        CTTblPr trPr = getTrPr();
        CTTblCellMar tblCellMar = trPr.isSetTblCellMar() ? trPr.getTblCellMar() : trPr.addNewTblCellMar();
        CTTblWidth left = tblCellMar.isSetLeft() ? tblCellMar.getLeft() : tblCellMar.addNewLeft();
        left.setType(STTblWidth.DXA);
        left.setW(BigInteger.valueOf(i2));
        CTTblWidth top = tblCellMar.isSetTop() ? tblCellMar.getTop() : tblCellMar.addNewTop();
        top.setType(STTblWidth.DXA);
        top.setW(BigInteger.valueOf(i));
        CTTblWidth bottom = tblCellMar.isSetBottom() ? tblCellMar.getBottom() : tblCellMar.addNewBottom();
        bottom.setType(STTblWidth.DXA);
        bottom.setW(BigInteger.valueOf(i3));
        CTTblWidth right = tblCellMar.isSetRight() ? tblCellMar.getRight() : tblCellMar.addNewRight();
        right.setType(STTblWidth.DXA);
        right.setW(BigInteger.valueOf(i4));
    }

    public void addRow(XWPFTableRow xWPFTableRow) {
        this.ctTbl.addNewTr();
        this.ctTbl.setTrArray(getNumberOfRows() - 1, xWPFTableRow.getCtRow());
        this.tableRows.add(xWPFTableRow);
    }

    public boolean addRow(XWPFTableRow xWPFTableRow, int i) {
        if (i < 0 || i > this.tableRows.size()) {
            return false;
        }
        this.ctTbl.insertNewTr(i);
        this.ctTbl.setTrArray(i, xWPFTableRow.getCtRow());
        this.tableRows.add(i, xWPFTableRow);
        return true;
    }

    public XWPFTableRow insertNewTableRow(int i) {
        if (i < 0 || i > this.tableRows.size()) {
            return null;
        }
        XWPFTableRow xWPFTableRow = new XWPFTableRow(this.ctTbl.insertNewTr(i), this);
        this.tableRows.add(i, xWPFTableRow);
        return xWPFTableRow;
    }

    public boolean removeRow(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= this.tableRows.size()) {
            return false;
        }
        if (this.ctTbl.sizeOfTrArray() > 0) {
            this.ctTbl.removeTr(i);
        }
        this.tableRows.remove(i);
        return true;
    }

    public List<XWPFTableRow> getRows() {
        return this.tableRows;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBodyElement
    public BodyElementType getElementType() {
        return BodyElementType.TABLE;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBodyElement
    public IBody getBody() {
        return this.part;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBodyElement, org.apache.poi.xwpf.usermodel.IRunBody
    public POIXMLDocumentPart getPart() {
        IBody iBody = this.part;
        if (iBody != null) {
            return iBody.getPart();
        }
        return null;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBodyElement
    public BodyType getPartType() {
        return this.part.getPartType();
    }

    public XWPFTableRow getRow(CTRow cTRow) {
        for (int i = 0; i < getRows().size(); i++) {
            if (getRows().get(i).getCtRow() == cTRow) {
                return getRow(i);
            }
        }
        return null;
    }
}
