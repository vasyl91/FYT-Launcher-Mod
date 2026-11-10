package org.apache.poi.xssf.usermodel.helpers;

import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.model.SingleXmlCells;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXmlDataType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFSingleXmlCell {
    private SingleXmlCells parent;
    private CTSingleXmlCell singleXmlCell;

    public XSSFSingleXmlCell(CTSingleXmlCell cTSingleXmlCell, SingleXmlCells singleXmlCells) {
        this.singleXmlCell = cTSingleXmlCell;
        this.parent = singleXmlCells;
    }

    public XSSFCell getReferencedCell() {
        CellReference cellReference = new CellReference(this.singleXmlCell.getR());
        XSSFRow row = this.parent.getXSSFSheet().getRow(cellReference.getRow());
        if (row == null) {
            row = this.parent.getXSSFSheet().createRow(cellReference.getRow());
        }
        XSSFCell cell = row.getCell((int) cellReference.getCol());
        return cell == null ? row.createCell((int) cellReference.getCol()) : cell;
    }

    public String getXpath() {
        return this.singleXmlCell.getXmlCellPr().getXmlPr().getXpath();
    }

    public long getMapId() {
        return this.singleXmlCell.getXmlCellPr().getXmlPr().getMapId();
    }

    public STXmlDataType.Enum getXmlDataType() {
        return this.singleXmlCell.getXmlCellPr().getXmlPr().getXmlDataType();
    }
}
