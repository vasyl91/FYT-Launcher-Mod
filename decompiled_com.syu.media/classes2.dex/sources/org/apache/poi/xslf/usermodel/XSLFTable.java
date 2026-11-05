package org.apache.poi.xslf.usermodel;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.poi.sl.draw.DrawFactory;
import org.apache.poi.sl.usermodel.TableShape;
import org.apache.poi.sl.usermodel.TextShape;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Units;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.impl.values.XmlAnyTypeImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectData;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTable;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrameNonVisual;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSLFTable extends XSLFGraphicFrame implements Iterable<XSLFTableRow>, TableShape<XSLFShape, XSLFTextParagraph> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final String DRAWINGML_URI = "http://schemas.openxmlformats.org/drawingml/2006/main";
    static final String TABLE_URI = "http://schemas.openxmlformats.org/drawingml/2006/table";
    private List<XSLFTableRow> _rows;
    private CTTable _table;

    XSLFTable(CTGraphicalObjectFrame cTGraphicalObjectFrame, XSLFSheet xSLFSheet) {
        super(cTGraphicalObjectFrame, xSLFSheet);
        CTGraphicalObjectData graphicData = cTGraphicalObjectFrame.getGraphic().getGraphicData();
        XmlCursor xmlCursorNewCursor = graphicData.newCursor();
        if (!xmlCursorNewCursor.toChild("http://schemas.openxmlformats.org/drawingml/2006/main", "tbl")) {
            throw new IllegalStateException("a:tbl element was not found in\n " + graphicData);
        }
        CTTable object = xmlCursorNewCursor.getObject();
        if (object instanceof XmlAnyTypeImpl) {
            throw new IllegalStateException("Schemas (*.xsb) for CTTable can't be loaded - usually this happens when OSGI loading is used and the thread context classloader has no reference to the xmlbeans classes - use POIXMLTypeLoader.setClassLoader() to set the loader, e.g. with CTTable.class.getClassLoader()");
        }
        this._table = object;
        xmlCursorNewCursor.dispose();
        this._rows = new ArrayList(this._table.sizeOfTrArray());
        for (CTTableRow cTTableRow : this._table.getTrArray()) {
            this._rows.add(new XSLFTableRow(cTTableRow, this));
        }
        updateRowColIndexes();
    }

    @Override // org.apache.poi.sl.usermodel.TableShape
    public XSLFTableCell getCell(int i, int i2) {
        XSLFTableRow xSLFTableRow;
        List<XSLFTableRow> rows = getRows();
        if (i < 0 || rows.size() <= i || (xSLFTableRow = rows.get(i)) == null) {
            return null;
        }
        List<XSLFTableCell> cells = xSLFTableRow.getCells();
        if (i2 >= 0 && cells.size() > i2) {
            return cells.get(i2);
        }
        return null;
    }

    @Internal
    public CTTable getCTTable() {
        return this._table;
    }

    @Override // org.apache.poi.sl.usermodel.TableShape
    public int getNumberOfColumns() {
        return this._table.getTblGrid().sizeOfGridColArray();
    }

    @Override // org.apache.poi.sl.usermodel.TableShape
    public int getNumberOfRows() {
        return this._table.sizeOfTrArray();
    }

    @Override // org.apache.poi.sl.usermodel.TableShape
    public double getColumnWidth(int i) {
        return Units.toPoints(this._table.getTblGrid().getGridColArray(i).getW());
    }

    @Override // org.apache.poi.sl.usermodel.TableShape
    public void setColumnWidth(int i, double d) {
        this._table.getTblGrid().getGridColArray(i).setW(Units.toEMU(d));
    }

    @Override // org.apache.poi.sl.usermodel.TableShape
    public double getRowHeight(int i) {
        return Units.toPoints(this._table.getTrArray(i).getH());
    }

    @Override // org.apache.poi.sl.usermodel.TableShape
    public void setRowHeight(int i, double d) {
        this._table.getTrArray(i).setH(Units.toEMU(d));
    }

    @Override // java.lang.Iterable
    public Iterator<XSLFTableRow> iterator() {
        return this._rows.iterator();
    }

    public List<XSLFTableRow> getRows() {
        return Collections.unmodifiableList(this._rows);
    }

    public XSLFTableRow addRow() {
        XSLFTableRow xSLFTableRow = new XSLFTableRow(this._table.addNewTr(), this);
        xSLFTableRow.setHeight(20.0d);
        this._rows.add(xSLFTableRow);
        updateRowColIndexes();
        return xSLFTableRow;
    }

    static CTGraphicalObjectFrame prototype(int i) {
        CTGraphicalObjectFrame cTGraphicalObjectFrameNewInstance = CTGraphicalObjectFrame.Factory.newInstance();
        CTGraphicalObjectFrameNonVisual cTGraphicalObjectFrameNonVisualAddNewNvGraphicFramePr = cTGraphicalObjectFrameNewInstance.addNewNvGraphicFramePr();
        CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTGraphicalObjectFrameNonVisualAddNewNvGraphicFramePr.addNewCNvPr();
        cTNonVisualDrawingPropsAddNewCNvPr.setName("Table " + i);
        cTNonVisualDrawingPropsAddNewCNvPr.setId(i + 1);
        cTGraphicalObjectFrameNonVisualAddNewNvGraphicFramePr.addNewCNvGraphicFramePr().addNewGraphicFrameLocks().setNoGrp(true);
        cTGraphicalObjectFrameNonVisualAddNewNvGraphicFramePr.addNewNvPr();
        cTGraphicalObjectFrameNewInstance.addNewXfrm();
        CTGraphicalObjectData cTGraphicalObjectDataAddNewGraphicData = cTGraphicalObjectFrameNewInstance.addNewGraphic().addNewGraphicData();
        XmlCursor xmlCursorNewCursor = cTGraphicalObjectDataAddNewGraphicData.newCursor();
        xmlCursorNewCursor.toNextToken();
        xmlCursorNewCursor.beginElement(new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tbl"));
        CTTable cTTableNewInstance = CTTable.Factory.newInstance();
        cTTableNewInstance.addNewTblPr();
        cTTableNewInstance.addNewTblGrid();
        XmlCursor xmlCursorNewCursor2 = cTTableNewInstance.newCursor();
        xmlCursorNewCursor2.moveXmlContents(xmlCursorNewCursor);
        xmlCursorNewCursor2.dispose();
        xmlCursorNewCursor.dispose();
        cTGraphicalObjectDataAddNewGraphicData.setUri(TABLE_URI);
        return cTGraphicalObjectFrameNewInstance;
    }

    public void mergeCells(int i, int i2, int i3, int i4) {
        if (i > i2) {
            throw new IllegalArgumentException("Cannot merge, first row > last row : " + i + " > " + i2);
        }
        if (i3 > i4) {
            throw new IllegalArgumentException("Cannot merge, first column > last column : " + i3 + " > " + i4);
        }
        int i5 = (i2 - i) + 1;
        boolean z = i5 > 1;
        int i6 = (i4 - i3) + 1;
        boolean z2 = i6 > 1;
        for (int i7 = i; i7 <= i2; i7++) {
            XSLFTableRow xSLFTableRow = this._rows.get(i7);
            for (int i8 = i3; i8 <= i4; i8++) {
                XSLFTableCell xSLFTableCell = xSLFTableRow.getCells().get(i8);
                if (z) {
                    if (i7 == i) {
                        xSLFTableCell.setRowSpan(i5);
                    } else {
                        xSLFTableCell.setVMerge(true);
                    }
                }
                if (z2) {
                    if (i8 == i3) {
                        xSLFTableCell.setGridSpan(i6);
                    } else {
                        xSLFTableCell.setHMerge(true);
                    }
                }
            }
        }
    }

    protected XSLFTableStyle getTableStyle() {
        CTTable cTTable = getCTTable();
        if (cTTable.isSetTblPr() && cTTable.getTblPr().isSetTableStyleId()) {
            String tableStyleId = cTTable.getTblPr().getTableStyleId();
            for (XSLFTableStyle xSLFTableStyle : getSheet().getSlideShow().getTableStyles().getStyles()) {
                if (xSLFTableStyle.getStyleId().equals(tableStyleId)) {
                    return xSLFTableStyle;
                }
            }
        }
        return null;
    }

    void updateRowColIndexes() {
        Iterator<XSLFTableRow> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            Iterator<XSLFTableCell> it2 = it.next().iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                it2.next().setRowColIndex(i, i2);
                i2++;
            }
            i++;
        }
    }

    void updateCellAnchor() {
        int numberOfRows = getNumberOfRows();
        int numberOfColumns = getNumberOfColumns();
        double[] dArr = new double[numberOfColumns];
        double[] dArr2 = new double[numberOfRows];
        for (int i = 0; i < numberOfRows; i++) {
            dArr2[i] = getRowHeight(i);
        }
        for (int i2 = 0; i2 < numberOfColumns; i2++) {
            dArr[i2] = getColumnWidth(i2);
        }
        Rectangle2D anchor = getAnchor();
        DrawFactory drawFactory = DrawFactory.getInstance(null);
        double y = anchor.getY();
        for (int i3 = 0; i3 < numberOfRows; i3++) {
            double dMax = 0.0d;
            for (int i4 = 0; i4 < numberOfColumns; i4++) {
                XSLFTableCell cell = getCell(i3, i4);
                if (cell != null && cell.getGridSpan() == 1 && cell.getRowSpan() == 1) {
                    cell.setAnchor(new Rectangle2D.Double(0.0d, 0.0d, dArr[i4], 0.0d));
                    dMax = Math.max(dMax, drawFactory.getDrawable((TextShape<?, ?>) cell).getTextHeight());
                }
            }
            dArr2[i3] = Math.max(dArr2[i3], dMax);
        }
        for (int i5 = 0; i5 < numberOfRows; i5++) {
            double x = anchor.getX();
            for (int i6 = 0; i6 < numberOfColumns; i6++) {
                Rectangle2D.Double r14 = new Rectangle2D.Double(x, y, dArr[i6], dArr2[i5]);
                XSLFTableCell cell2 = getCell(i5, i6);
                if (cell2 != null) {
                    cell2.setAnchor(r14);
                    x += dArr[i6] + 2.0d;
                }
            }
            y += dArr2[i5] + 2.0d;
        }
        for (int i7 = 0; i7 < numberOfRows; i7++) {
            for (int i8 = 0; i8 < numberOfColumns; i8++) {
                XSLFTableCell cell3 = getCell(i7, i8);
                if (cell3 != null) {
                    Rectangle2D anchor2 = cell3.getAnchor();
                    for (int i9 = i8 + 1; i9 < cell3.getGridSpan() + i8; i9++) {
                        anchor2.add(getCell(i7, i9).getAnchor());
                    }
                    for (int i10 = i7 + 1; i10 < cell3.getRowSpan() + i7; i10++) {
                        anchor2.add(getCell(i10, i8).getAnchor());
                    }
                    cell3.setAnchor(anchor2);
                }
            }
        }
    }
}
