package org.apache.poi.xslf.usermodel;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import org.apache.poi.sl.draw.DrawPaint;
import org.apache.poi.sl.usermodel.PaintStyle;
import org.apache.poi.sl.usermodel.StrokeStyle;
import org.apache.poi.sl.usermodel.TableCell;
import org.apache.poi.sl.usermodel.TextShape;
import org.apache.poi.sl.usermodel.VerticalAlignment;
import org.apache.poi.util.Units;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFontReference;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineEndProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTable;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCell;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleCellStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.main.STCompoundLine;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineCap;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndLength;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndType;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndWidth;
import org.openxmlformats.schemas.drawingml.x2006.main.STPenAlignment;
import org.openxmlformats.schemas.drawingml.x2006.main.STPresetLineDashVal;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAnchoringType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextVerticalType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSLFTableCell extends XSLFTextShape implements TableCell<XSLFShape, XSLFTextParagraph> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private CTTableCellProperties _tcPr;
    private Rectangle2D anchor;
    private int col;
    private int row;
    private final XSLFTable table;

    XSLFTableCell(CTTableCell cTTableCell, XSLFTable xSLFTable) {
        super(cTTableCell, xSLFTable.getSheet());
        this._tcPr = null;
        this.row = 0;
        this.col = 0;
        this.anchor = null;
        this.table = xSLFTable;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape
    protected CTTextBody getTextBody(boolean z) {
        CTTableCell cell = getCell();
        CTTextBody txBody = cell.getTxBody();
        if (txBody != null || !z) {
            return txBody;
        }
        CTTextBody cTTextBodyAddNewTxBody = cell.addNewTxBody();
        XSLFAutoShape.initTextBody(cTTextBodyAddNewTxBody);
        return cTTextBodyAddNewTxBody;
    }

    static CTTableCell prototype() {
        CTTableCell cTTableCellNewInstance = CTTableCell.Factory.newInstance();
        CTTableCellProperties cTTableCellPropertiesAddNewTcPr = cTTableCellNewInstance.addNewTcPr();
        cTTableCellPropertiesAddNewTcPr.addNewLnL().addNewNoFill();
        cTTableCellPropertiesAddNewTcPr.addNewLnR().addNewNoFill();
        cTTableCellPropertiesAddNewTcPr.addNewLnT().addNewNoFill();
        cTTableCellPropertiesAddNewTcPr.addNewLnB().addNewNoFill();
        return cTTableCellNewInstance;
    }

    protected CTTableCellProperties getCellProperties(boolean z) {
        if (this._tcPr == null) {
            CTTableCell cell = getCell();
            CTTableCellProperties tcPr = cell.getTcPr();
            this._tcPr = tcPr;
            if (tcPr == null && z) {
                this._tcPr = cell.addNewTcPr();
            }
        }
        return this._tcPr;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape
    public void setLeftInset(double d) {
        getCellProperties(true).setMarL(Units.toEMU(d));
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape
    public void setRightInset(double d) {
        getCellProperties(true).setMarR(Units.toEMU(d));
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape
    public void setTopInset(double d) {
        getCellProperties(true).setMarT(Units.toEMU(d));
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape
    public void setBottomInset(double d) {
        getCellProperties(true).setMarB(Units.toEMU(d));
    }

    private CTLineProperties getCTLine(TableCell.BorderEdge borderEdge, boolean z) {
        if (borderEdge == null) {
            throw new IllegalArgumentException("BorderEdge needs to be specified.");
        }
        CTTableCellProperties cellProperties = getCellProperties(z);
        if (cellProperties == null) {
            return null;
        }
        int i = AnonymousClass2.$SwitchMap$org$apache$poi$sl$usermodel$TableCell$BorderEdge[borderEdge.ordinal()];
        if (i == 1) {
            if (cellProperties.isSetLnB()) {
                return cellProperties.getLnB();
            }
            if (z) {
                return cellProperties.addNewLnB();
            }
            return null;
        }
        if (i == 2) {
            if (cellProperties.isSetLnL()) {
                return cellProperties.getLnL();
            }
            if (z) {
                return cellProperties.addNewLnL();
            }
            return null;
        }
        if (i == 3) {
            if (cellProperties.isSetLnT()) {
                return cellProperties.getLnT();
            }
            if (z) {
                return cellProperties.addNewLnT();
            }
            return null;
        }
        if (i != 4) {
            return null;
        }
        if (cellProperties.isSetLnR()) {
            return cellProperties.getLnR();
        }
        if (z) {
            return cellProperties.addNewLnR();
        }
        return null;
    }

    @Override // org.apache.poi.sl.usermodel.TableCell
    public void removeBorder(TableCell.BorderEdge borderEdge) {
        CTTableCellProperties cellProperties = getCellProperties(false);
        if (cellProperties == null) {
            return;
        }
        int i = AnonymousClass2.$SwitchMap$org$apache$poi$sl$usermodel$TableCell$BorderEdge[borderEdge.ordinal()];
        if (i == 1) {
            if (cellProperties.isSetLnB()) {
                cellProperties.unsetLnB();
                return;
            }
            return;
        }
        if (i == 2) {
            if (cellProperties.isSetLnL()) {
                cellProperties.unsetLnL();
            }
        } else if (i == 3) {
            if (cellProperties.isSetLnT()) {
                cellProperties.unsetLnT();
            }
        } else {
            if (i == 4) {
                if (cellProperties.isSetLnR()) {
                    cellProperties.unsetLnB();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    @Override // org.apache.poi.sl.usermodel.TableCell
    public StrokeStyle getBorderStyle(final TableCell.BorderEdge borderEdge) {
        final Double borderWidth = getBorderWidth(borderEdge);
        if (borderWidth == null) {
            return null;
        }
        return new StrokeStyle() { // from class: org.apache.poi.xslf.usermodel.XSLFTableCell.1
            @Override // org.apache.poi.sl.usermodel.StrokeStyle
            public PaintStyle getPaint() {
                return DrawPaint.createSolidPaint(XSLFTableCell.this.getBorderColor(borderEdge));
            }

            @Override // org.apache.poi.sl.usermodel.StrokeStyle
            public StrokeStyle.LineCap getLineCap() {
                return XSLFTableCell.this.getBorderCap(borderEdge);
            }

            @Override // org.apache.poi.sl.usermodel.StrokeStyle
            public StrokeStyle.LineDash getLineDash() {
                return XSLFTableCell.this.getBorderDash(borderEdge);
            }

            @Override // org.apache.poi.sl.usermodel.StrokeStyle
            public StrokeStyle.LineCompound getLineCompound() {
                return XSLFTableCell.this.getBorderCompound(borderEdge);
            }

            @Override // org.apache.poi.sl.usermodel.StrokeStyle
            public double getLineWidth() {
                return borderWidth.doubleValue();
            }
        };
    }

    @Override // org.apache.poi.sl.usermodel.TableCell
    public void setBorderStyle(TableCell.BorderEdge borderEdge, StrokeStyle strokeStyle) {
        if (strokeStyle == null) {
            throw new IllegalArgumentException("StrokeStyle needs to be specified.");
        }
        StrokeStyle.LineCap lineCap = strokeStyle.getLineCap();
        if (lineCap != null) {
            setBorderCap(borderEdge, lineCap);
        }
        StrokeStyle.LineCompound lineCompound = strokeStyle.getLineCompound();
        if (lineCompound != null) {
            setBorderCompound(borderEdge, lineCompound);
        }
        StrokeStyle.LineDash lineDash = strokeStyle.getLineDash();
        if (lineDash != null) {
            setBorderDash(borderEdge, lineDash);
        }
        setBorderWidth(borderEdge, strokeStyle.getLineWidth());
    }

    public Double getBorderWidth(TableCell.BorderEdge borderEdge) {
        CTLineProperties cTLine = getCTLine(borderEdge, false);
        if (cTLine == null || !cTLine.isSetW()) {
            return null;
        }
        return Double.valueOf(Units.toPoints(cTLine.getW()));
    }

    @Override // org.apache.poi.sl.usermodel.TableCell
    public void setBorderWidth(TableCell.BorderEdge borderEdge, double d) {
        getCTLine(borderEdge, true).setW(Units.toEMU(d));
    }

    private CTLineProperties setBorderDefaults(TableCell.BorderEdge borderEdge) {
        CTLineProperties cTLine = getCTLine(borderEdge, true);
        if (cTLine.isSetNoFill()) {
            cTLine.unsetNoFill();
        }
        if (!cTLine.isSetPrstDash()) {
            cTLine.addNewPrstDash().setVal(STPresetLineDashVal.SOLID);
        }
        if (!cTLine.isSetCmpd()) {
            cTLine.setCmpd(STCompoundLine.SNG);
        }
        if (!cTLine.isSetAlgn()) {
            cTLine.setAlgn(STPenAlignment.CTR);
        }
        if (!cTLine.isSetCap()) {
            cTLine.setCap(STLineCap.FLAT);
        }
        if (!cTLine.isSetRound()) {
            cTLine.addNewRound();
        }
        if (!cTLine.isSetHeadEnd()) {
            CTLineEndProperties cTLineEndPropertiesAddNewHeadEnd = cTLine.addNewHeadEnd();
            cTLineEndPropertiesAddNewHeadEnd.setType(STLineEndType.NONE);
            cTLineEndPropertiesAddNewHeadEnd.setW(STLineEndWidth.MED);
            cTLineEndPropertiesAddNewHeadEnd.setLen(STLineEndLength.MED);
        }
        if (!cTLine.isSetTailEnd()) {
            CTLineEndProperties cTLineEndPropertiesAddNewTailEnd = cTLine.addNewTailEnd();
            cTLineEndPropertiesAddNewTailEnd.setType(STLineEndType.NONE);
            cTLineEndPropertiesAddNewTailEnd.setW(STLineEndWidth.MED);
            cTLineEndPropertiesAddNewTailEnd.setLen(STLineEndLength.MED);
        }
        return cTLine;
    }

    @Override // org.apache.poi.sl.usermodel.TableCell
    public void setBorderColor(TableCell.BorderEdge borderEdge, Color color) {
        if (color == null) {
            throw new IllegalArgumentException("Colors need to be specified.");
        }
        CTSolidColorFillProperties cTSolidColorFillPropertiesAddNewSolidFill = setBorderDefaults(borderEdge).addNewSolidFill();
        new XSLFColor(cTSolidColorFillPropertiesAddNewSolidFill, getSheet().getTheme(), cTSolidColorFillPropertiesAddNewSolidFill.getSchemeClr()).setColor(color);
    }

    public Color getBorderColor(TableCell.BorderEdge borderEdge) {
        CTLineProperties cTLine = getCTLine(borderEdge, false);
        if (cTLine == null || cTLine.isSetNoFill() || !cTLine.isSetSolidFill()) {
            return null;
        }
        CTSolidColorFillProperties solidFill = cTLine.getSolidFill();
        return new XSLFColor(solidFill, getSheet().getTheme(), solidFill.getSchemeClr()).getColor();
    }

    public StrokeStyle.LineCompound getBorderCompound(TableCell.BorderEdge borderEdge) {
        CTLineProperties cTLine = getCTLine(borderEdge, false);
        if (cTLine == null || cTLine.isSetNoFill() || !cTLine.isSetSolidFill() || !cTLine.isSetCmpd()) {
            return null;
        }
        return StrokeStyle.LineCompound.fromOoxmlId(cTLine.getCmpd().intValue());
    }

    @Override // org.apache.poi.sl.usermodel.TableCell
    public void setBorderCompound(TableCell.BorderEdge borderEdge, StrokeStyle.LineCompound lineCompound) {
        if (lineCompound == null) {
            throw new IllegalArgumentException("LineCompound need to be specified.");
        }
        setBorderDefaults(borderEdge).setCmpd(STCompoundLine.Enum.forInt(lineCompound.ooxmlId));
    }

    public StrokeStyle.LineDash getBorderDash(TableCell.BorderEdge borderEdge) {
        CTLineProperties cTLine = getCTLine(borderEdge, false);
        if (cTLine == null || cTLine.isSetNoFill() || !cTLine.isSetSolidFill() || !cTLine.isSetPrstDash()) {
            return null;
        }
        return StrokeStyle.LineDash.fromOoxmlId(cTLine.getPrstDash().getVal().intValue());
    }

    @Override // org.apache.poi.sl.usermodel.TableCell
    public void setBorderDash(TableCell.BorderEdge borderEdge, StrokeStyle.LineDash lineDash) {
        if (lineDash == null) {
            throw new IllegalArgumentException("LineDash need to be specified.");
        }
        setBorderDefaults(borderEdge).getPrstDash().setVal(STPresetLineDashVal.Enum.forInt(lineDash.ooxmlId));
    }

    public StrokeStyle.LineCap getBorderCap(TableCell.BorderEdge borderEdge) {
        CTLineProperties cTLine = getCTLine(borderEdge, false);
        if (cTLine == null || cTLine.isSetNoFill() || !cTLine.isSetSolidFill() || !cTLine.isSetCap()) {
            return null;
        }
        return StrokeStyle.LineCap.fromOoxmlId(cTLine.getCap().intValue());
    }

    public void setBorderCap(TableCell.BorderEdge borderEdge, StrokeStyle.LineCap lineCap) {
        if (lineCap == null) {
            throw new IllegalArgumentException("LineCap need to be specified.");
        }
        setBorderDefaults(borderEdge).setCap(STLineCap.Enum.forInt(lineCap.ooxmlId));
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape, org.apache.poi.sl.usermodel.SimpleShape
    public void setFillColor(Color color) {
        CTTableCellProperties cellProperties = getCellProperties(true);
        if (color == null) {
            if (cellProperties.isSetSolidFill()) {
                cellProperties.unsetSolidFill();
            }
        } else {
            CTSolidColorFillProperties solidFill = cellProperties.isSetSolidFill() ? cellProperties.getSolidFill() : cellProperties.addNewSolidFill();
            new XSLFColor(solidFill, getSheet().getTheme(), solidFill.getSchemeClr()).setColor(color);
        }
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape, org.apache.poi.sl.usermodel.SimpleShape
    public Color getFillColor() {
        PaintStyle fillPaint = getFillPaint();
        if (fillPaint instanceof PaintStyle.SolidPaint) {
            return DrawPaint.applyColorTransform(((PaintStyle.SolidPaint) fillPaint).getSolidColor());
        }
        return null;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public PaintStyle getFillPaint() {
        CTFillProperties fillRef;
        PaintStyle paintStyleSelectPaint;
        PaintStyle paintStyleSelectPaint2;
        XSLFSheet sheet = getSheet();
        XSLFTheme theme = sheet.getTheme();
        boolean z = getPlaceholder() != null;
        XSLFPropertiesDelegate.XSLFFillProperties fillDelegate = XSLFPropertiesDelegate.getFillDelegate(getCellProperties(false));
        if (fillDelegate != null && (paintStyleSelectPaint2 = selectPaint(fillDelegate, null, sheet.getPackagePart(), theme, z)) != null) {
            return paintStyleSelectPaint2;
        }
        CTTablePartStyle tablePartStyle = getTablePartStyle(null);
        if ((tablePartStyle != null && tablePartStyle.isSetTcStyle()) || ((tablePartStyle = getTablePartStyle(XSLFTableStyle.TablePartStyle.wholeTbl)) != null && tablePartStyle.isSetTcStyle())) {
            XMLSlideShow slideShow = sheet.getSlideShow();
            CTTableStyleCellStyle tcStyle = tablePartStyle.getTcStyle();
            if (tcStyle.isSetFill()) {
                fillRef = tcStyle.getFill();
            } else if (tcStyle.isSetFillRef()) {
                fillRef = tcStyle.getFillRef();
            }
            XSLFPropertiesDelegate.XSLFFillProperties fillDelegate2 = XSLFPropertiesDelegate.getFillDelegate(fillRef);
            if (fillDelegate2 != null && (paintStyleSelectPaint = XSLFShape.selectPaint(fillDelegate2, null, slideShow.getPackagePart(), theme, z)) != null) {
                return paintStyleSelectPaint;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CTTablePartStyle getTablePartStyle(XSLFTableStyle.TablePartStyle tablePartStyle) {
        CTTable cTTable = this.table.getCTTable();
        if (!cTTable.isSetTblPr()) {
            return null;
        }
        CTTableProperties tblPr = cTTable.getTblPr();
        boolean z = false;
        boolean z2 = tblPr.isSetBandRow() && tblPr.getBandRow();
        int i = (tblPr.isSetFirstRow() && tblPr.getFirstRow()) ? 1 : 0;
        boolean z3 = tblPr.isSetLastRow() && tblPr.getLastRow();
        boolean z4 = tblPr.isSetBandCol() && tblPr.getBandCol();
        int i2 = (tblPr.isSetFirstCol() && tblPr.getFirstCol()) ? 1 : 0;
        if (tblPr.isSetLastCol() && tblPr.getLastCol()) {
            z = true;
        }
        if (tablePartStyle == null) {
            int i3 = this.row;
            if (i3 == 0 && i != 0) {
                tablePartStyle = XSLFTableStyle.TablePartStyle.firstRow;
            } else if (i3 == this.table.getNumberOfRows() - 1 && z3) {
                tablePartStyle = XSLFTableStyle.TablePartStyle.lastRow;
            } else {
                int i4 = this.col;
                if (i4 == 0 && i2 != 0) {
                    tablePartStyle = XSLFTableStyle.TablePartStyle.firstCol;
                } else if (i4 == this.table.getNumberOfColumns() - 1 && z) {
                    tablePartStyle = XSLFTableStyle.TablePartStyle.lastCol;
                } else {
                    tablePartStyle = XSLFTableStyle.TablePartStyle.wholeTbl;
                    int i5 = this.row + i;
                    int i6 = this.col + i2;
                    if (z2 && (i5 & 1) == 0) {
                        tablePartStyle = XSLFTableStyle.TablePartStyle.band1H;
                    } else if (z4 && (i6 & 1) == 0) {
                        tablePartStyle = XSLFTableStyle.TablePartStyle.band1V;
                    }
                }
            }
        }
        XSLFTableStyle tableStyle = this.table.getTableStyle();
        if (tableStyle == null) {
            return null;
        }
        CTTablePartStyle tablePartStyle2 = tableStyle.getTablePartStyle(tablePartStyle);
        return tablePartStyle2 == null ? tableStyle.getTablePartStyle(XSLFTableStyle.TablePartStyle.wholeTbl) : tablePartStyle2;
    }

    void setGridSpan(int i) {
        getCell().setGridSpan(i);
    }

    @Override // org.apache.poi.sl.usermodel.TableCell
    public int getGridSpan() {
        CTTableCell cell = getCell();
        if (cell.isSetGridSpan()) {
            return cell.getGridSpan();
        }
        return 1;
    }

    void setRowSpan(int i) {
        getCell().setRowSpan(i);
    }

    @Override // org.apache.poi.sl.usermodel.TableCell
    public int getRowSpan() {
        CTTableCell cell = getCell();
        if (cell.isSetRowSpan()) {
            return cell.getRowSpan();
        }
        return 1;
    }

    void setHMerge(boolean z) {
        getCell().setHMerge(z);
    }

    void setVMerge(boolean z) {
        getCell().setVMerge(z);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape, org.apache.poi.sl.usermodel.TextShape
    public void setVerticalAlignment(VerticalAlignment verticalAlignment) {
        CTTableCellProperties cellProperties = getCellProperties(true);
        if (verticalAlignment == null) {
            if (cellProperties.isSetAnchor()) {
                cellProperties.unsetAnchor();
                return;
            }
            return;
        }
        cellProperties.setAnchor(STTextAnchoringType.Enum.forInt(verticalAlignment.ordinal() + 1));
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape, org.apache.poi.sl.usermodel.TextShape
    public VerticalAlignment getVerticalAlignment() {
        CTTableCellProperties cellProperties = getCellProperties(false);
        VerticalAlignment verticalAlignment = VerticalAlignment.TOP;
        if (cellProperties == null || !cellProperties.isSetAnchor()) {
            return verticalAlignment;
        }
        return VerticalAlignment.values()[cellProperties.getAnchor().intValue() - 1];
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape, org.apache.poi.sl.usermodel.TextShape
    public void setTextDirection(TextShape.TextDirection textDirection) {
        STTextVerticalType.Enum r3;
        CTTableCellProperties cellProperties = getCellProperties(true);
        if (textDirection == null) {
            if (cellProperties.isSetVert()) {
                cellProperties.unsetVert();
                return;
            }
            return;
        }
        int i = AnonymousClass2.$SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextDirection[textDirection.ordinal()];
        if (i == 2) {
            r3 = STTextVerticalType.VERT;
        } else if (i == 3) {
            r3 = STTextVerticalType.VERT_270;
        } else if (i != 4) {
            r3 = STTextVerticalType.HORZ;
        } else {
            r3 = STTextVerticalType.WORD_ART_VERT;
        }
        cellProperties.setVert(r3);
    }

    /* JADX INFO: renamed from: org.apache.poi.xslf.usermodel.XSLFTableCell$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$TableCell$BorderEdge;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextDirection;

        static {
            int[] iArr = new int[TextShape.TextDirection.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextDirection = iArr;
            try {
                iArr[TextShape.TextDirection.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextDirection[TextShape.TextDirection.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextDirection[TextShape.TextDirection.VERTICAL_270.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextDirection[TextShape.TextDirection.STACKED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[TableCell.BorderEdge.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$TableCell$BorderEdge = iArr2;
            try {
                iArr2[TableCell.BorderEdge.bottom.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TableCell$BorderEdge[TableCell.BorderEdge.left.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TableCell$BorderEdge[TableCell.BorderEdge.top.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TableCell$BorderEdge[TableCell.BorderEdge.right.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape, org.apache.poi.sl.usermodel.TextShape
    public TextShape.TextDirection getTextDirection() {
        STTextVerticalType.Enum vert;
        CTTableCellProperties cellProperties = getCellProperties(false);
        if (cellProperties != null && cellProperties.isSetVert()) {
            vert = cellProperties.getVert();
        } else {
            vert = STTextVerticalType.HORZ;
        }
        switch (vert.intValue()) {
            case 2:
            case 5:
            case 6:
                return TextShape.TextDirection.VERTICAL;
            case 3:
                return TextShape.TextDirection.VERTICAL_270;
            case 4:
            case 7:
                return TextShape.TextDirection.STACKED;
            default:
                return TextShape.TextDirection.HORIZONTAL;
        }
    }

    private CTTableCell getCell() {
        return getXmlObject();
    }

    void setRowColIndex(int i, int i2) {
        this.row = i;
        this.col = i2;
    }

    protected CTTransform2D getXfrm() {
        Rectangle2D anchor = getAnchor();
        CTTransform2D cTTransform2DNewInstance = CTTransform2D.Factory.newInstance();
        CTPoint2D cTPoint2DAddNewOff = cTTransform2DNewInstance.addNewOff();
        cTPoint2DAddNewOff.setX(Units.toEMU(anchor.getX()));
        cTPoint2DAddNewOff.setY(Units.toEMU(anchor.getY()));
        CTPositiveSize2D cTPositiveSize2DAddNewExt = cTTransform2DNewInstance.addNewExt();
        cTPositiveSize2DAddNewExt.setCx(Units.toEMU(anchor.getWidth()));
        cTPositiveSize2DAddNewExt.setCy(Units.toEMU(anchor.getHeight()));
        return cTTransform2DNewInstance;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape, org.apache.poi.sl.usermodel.PlaceableShape
    public void setAnchor(Rectangle2D rectangle2D) {
        Rectangle2D rectangle2D2 = this.anchor;
        if (rectangle2D2 == null) {
            this.anchor = (Rectangle2D) rectangle2D.clone();
        } else {
            rectangle2D2.setRect(rectangle2D);
        }
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape, org.apache.poi.sl.usermodel.Shape, org.apache.poi.sl.usermodel.PlaceableShape
    public Rectangle2D getAnchor() {
        if (this.anchor == null) {
            this.table.updateCellAnchor();
        }
        return this.anchor;
    }

    @Override // org.apache.poi.sl.usermodel.TableCell
    public boolean isMerged() {
        CTTableCell cell = getCell();
        return (cell.isSetHMerge() && cell.getHMerge()) || (cell.isSetVMerge() && cell.getVMerge());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape
    public XSLFCellTextParagraph newTextParagraph(CTTextParagraph cTTextParagraph) {
        return new XSLFCellTextParagraph(cTTextParagraph, this);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    protected XmlObject getShapeProperties() {
        return getCellProperties(false);
    }

    private class XSLFCellTextParagraph extends XSLFTextParagraph {
        protected XSLFCellTextParagraph(CTTextParagraph cTTextParagraph, XSLFTextShape xSLFTextShape) {
            super(cTTextParagraph, xSLFTextShape);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.poi.xslf.usermodel.XSLFTextParagraph
        public XSLFCellTextRun newTextRun(CTRegularTextRun cTRegularTextRun) {
            return XSLFTableCell.this.new XSLFCellTextRun(cTRegularTextRun, this);
        }
    }

    private class XSLFCellTextRun extends XSLFTextRun {
        protected XSLFCellTextRun(CTRegularTextRun cTRegularTextRun, XSLFTextParagraph xSLFTextParagraph) {
            super(cTRegularTextRun, xSLFTextParagraph);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFTextRun, org.apache.poi.sl.usermodel.TextRun
        public PaintStyle getFontColor() {
            CTTableStyleTextStyle textStyle = getTextStyle();
            if (textStyle == null) {
                return super.getFontColor();
            }
            CTFontReference fontRef = textStyle.getFontRef();
            return DrawPaint.createSolidPaint(new XSLFColor(textStyle, XSLFTableCell.this.getSheet().getTheme(), fontRef != null ? fontRef.getSchemeClr() : null).getColorStyle());
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFTextRun, org.apache.poi.sl.usermodel.TextRun
        public boolean isBold() {
            CTTableStyleTextStyle textStyle = getTextStyle();
            if (textStyle == null) {
                return super.isBold();
            }
            return textStyle.isSetB() && textStyle.getB().intValue() == 1;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFTextRun, org.apache.poi.sl.usermodel.TextRun
        public boolean isItalic() {
            CTTableStyleTextStyle textStyle = getTextStyle();
            if (textStyle == null) {
                return super.isItalic();
            }
            return textStyle.isSetI() && textStyle.getI().intValue() == 1;
        }

        private CTTableStyleTextStyle getTextStyle() {
            CTTablePartStyle tablePartStyle = XSLFTableCell.this.getTablePartStyle(null);
            if (tablePartStyle == null || !tablePartStyle.isSetTcTxStyle()) {
                tablePartStyle = XSLFTableCell.this.getTablePartStyle(XSLFTableStyle.TablePartStyle.wholeTbl);
            }
            if (tablePartStyle == null) {
                return null;
            }
            return tablePartStyle.getTcTxStyle();
        }
    }
}
