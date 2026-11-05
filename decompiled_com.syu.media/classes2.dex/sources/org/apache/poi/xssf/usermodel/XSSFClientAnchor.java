package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Units;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFClientAnchor extends XSSFAnchor implements ClientAnchor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final CTMarker EMPTY_MARKER = CTMarker.Factory.newInstance();
    private ClientAnchor.AnchorType anchorType;
    private CTMarker cell1;
    private CTMarker cell2;
    private CTPoint2D position;
    private XSSFSheet sheet;
    private CTPositiveSize2D size;

    public int hashCode() {
        return 42;
    }

    public XSSFClientAnchor() {
        this(0, 0, 0, 0, 0, 0, 0, 0);
    }

    public XSSFClientAnchor(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.anchorType = ClientAnchor.AnchorType.MOVE_AND_RESIZE;
        CTMarker cTMarkerNewInstance = CTMarker.Factory.newInstance();
        this.cell1 = cTMarkerNewInstance;
        cTMarkerNewInstance.setCol(i5);
        this.cell1.setColOff(i);
        this.cell1.setRow(i6);
        this.cell1.setRowOff(i2);
        CTMarker cTMarkerNewInstance2 = CTMarker.Factory.newInstance();
        this.cell2 = cTMarkerNewInstance2;
        cTMarkerNewInstance2.setCol(i7);
        this.cell2.setColOff(i3);
        this.cell2.setRow(i8);
        this.cell2.setRowOff(i4);
    }

    protected XSSFClientAnchor(CTMarker cTMarker, CTMarker cTMarker2) {
        this.anchorType = ClientAnchor.AnchorType.MOVE_AND_RESIZE;
        this.cell1 = cTMarker;
        this.cell2 = cTMarker2;
    }

    protected XSSFClientAnchor(XSSFSheet xSSFSheet, CTMarker cTMarker, CTPositiveSize2D cTPositiveSize2D) {
        this.anchorType = ClientAnchor.AnchorType.MOVE_DONT_RESIZE;
        this.sheet = xSSFSheet;
        this.size = cTPositiveSize2D;
        this.cell1 = cTMarker;
    }

    protected XSSFClientAnchor(XSSFSheet xSSFSheet, CTPoint2D cTPoint2D, CTPositiveSize2D cTPositiveSize2D) {
        this.anchorType = ClientAnchor.AnchorType.DONT_MOVE_AND_RESIZE;
        this.sheet = xSSFSheet;
        this.position = cTPoint2D;
        this.size = cTPositiveSize2D;
    }

    private CTMarker calcCell(CTMarker cTMarker, long j, long j2) {
        CTMarker cTMarkerNewInstance = CTMarker.Factory.newInstance();
        int row = cTMarker.getRow();
        int col = cTMarker.getCol();
        int iColumnWidthToEMU = Units.columnWidthToEMU(this.sheet.getColumnWidth(col));
        long colOff = ((long) iColumnWidthToEMU) - cTMarker.getColOff();
        while (colOff < j) {
            col++;
            iColumnWidthToEMU = Units.columnWidthToEMU(this.sheet.getColumnWidth(col));
            colOff += (long) iColumnWidthToEMU;
        }
        cTMarkerNewInstance.setCol(col);
        cTMarkerNewInstance.setColOff(((long) iColumnWidthToEMU) - (colOff - j));
        int emu = Units.toEMU(getRowHeight(this.sheet, row));
        long rowOff = ((long) emu) - cTMarker.getRowOff();
        while (rowOff < j2) {
            row++;
            emu = Units.toEMU(getRowHeight(this.sheet, row));
            rowOff += (long) emu;
        }
        cTMarkerNewInstance.setRow(row);
        cTMarkerNewInstance.setRowOff(((long) emu) - (rowOff - j2));
        return cTMarkerNewInstance;
    }

    private static float getRowHeight(XSSFSheet xSSFSheet, int i) {
        XSSFRow row = xSSFSheet.getRow(i);
        return row == null ? xSSFSheet.getDefaultRowHeightInPoints() : row.getHeightInPoints();
    }

    private CTMarker getCell1() {
        CTMarker cTMarker = this.cell1;
        return cTMarker != null ? cTMarker : calcCell(EMPTY_MARKER, this.position.getX(), this.position.getY());
    }

    private CTMarker getCell2() {
        CTMarker cTMarker = this.cell2;
        return cTMarker != null ? cTMarker : calcCell(getCell1(), this.size.getCx(), this.size.getCy());
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public short getCol1() {
        return (short) getCell1().getCol();
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public void setCol1(int i) {
        this.cell1.setCol(i);
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public short getCol2() {
        return (short) getCell2().getCol();
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public void setCol2(int i) {
        this.cell2.setCol(i);
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public int getRow1() {
        return getCell1().getRow();
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public void setRow1(int i) {
        this.cell1.setRow(i);
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public int getRow2() {
        return getCell2().getRow();
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public void setRow2(int i) {
        this.cell2.setRow(i);
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public int getDx1() {
        return (int) getCell1().getColOff();
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public void setDx1(int i) {
        this.cell1.setColOff(i);
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public int getDy1() {
        return (int) getCell1().getRowOff();
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public void setDy1(int i) {
        this.cell1.setRowOff(i);
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public int getDy2() {
        return (int) getCell2().getRowOff();
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public void setDy2(int i) {
        this.cell2.setRowOff(i);
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public int getDx2() {
        return (int) getCell2().getColOff();
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public void setDx2(int i) {
        this.cell2.setColOff(i);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof XSSFClientAnchor)) {
            return false;
        }
        XSSFClientAnchor xSSFClientAnchor = (XSSFClientAnchor) obj;
        return getDx1() == xSSFClientAnchor.getDx1() && getDx2() == xSSFClientAnchor.getDx2() && getDy1() == xSSFClientAnchor.getDy1() && getDy2() == xSSFClientAnchor.getDy2() && getCol1() == xSSFClientAnchor.getCol1() && getCol2() == xSSFClientAnchor.getCol2() && getRow1() == xSSFClientAnchor.getRow1() && getRow2() == xSSFClientAnchor.getRow2();
    }

    public String toString() {
        return "from : " + getCell1() + "; to: " + getCell2();
    }

    @Internal
    public CTMarker getFrom() {
        return getCell1();
    }

    protected void setFrom(CTMarker cTMarker) {
        this.cell1 = cTMarker;
    }

    @Internal
    public CTMarker getTo() {
        return getCell2();
    }

    protected void setTo(CTMarker cTMarker) {
        this.cell2 = cTMarker;
    }

    public CTPoint2D getPosition() {
        return this.position;
    }

    public void setPosition(CTPoint2D cTPoint2D) {
        this.position = cTPoint2D;
    }

    public CTPositiveSize2D getSize() {
        return this.size;
    }

    public void setSize(CTPositiveSize2D cTPositiveSize2D) {
        this.size = cTPositiveSize2D;
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public void setAnchorType(ClientAnchor.AnchorType anchorType) {
        this.anchorType = anchorType;
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public ClientAnchor.AnchorType getAnchorType() {
        return this.anchorType;
    }

    public boolean isSet() {
        CTMarker cell1 = getCell1();
        CTMarker cell2 = getCell2();
        return (cell1.getCol() == 0 && cell2.getCol() == 0 && cell1.getRow() == 0 && cell2.getRow() == 0) ? false : true;
    }
}
