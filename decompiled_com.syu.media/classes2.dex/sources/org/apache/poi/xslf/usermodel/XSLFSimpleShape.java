package org.apache.poi.xslf.usermodel;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.sl.draw.DrawPaint;
import org.apache.poi.sl.draw.geom.CustomGeometry;
import org.apache.poi.sl.draw.geom.Guide;
import org.apache.poi.sl.draw.geom.PresetGeometries;
import org.apache.poi.sl.usermodel.FillStyle;
import org.apache.poi.sl.usermodel.LineDecoration;
import org.apache.poi.sl.usermodel.PaintStyle;
import org.apache.poi.sl.usermodel.Placeholder;
import org.apache.poi.sl.usermodel.ShapeType;
import org.apache.poi.sl.usermodel.SimpleShape;
import org.apache.poi.sl.usermodel.StrokeStyle;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.Units;
import org.apache.poi.xslf.model.PropertyFetcher;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlip;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineEndProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSchemeColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrix;
import org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.main.STCompoundLine;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineCap;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndLength;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndType;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndWidth;
import org.openxmlformats.schemas.drawingml.x2006.main.STPresetLineDashVal;
import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class XSLFSimpleShape extends XSLFShape implements SimpleShape<XSLFShape, XSLFTextParagraph> {
    private static CTOuterShadowEffect NO_SHADOW = CTOuterShadowEffect.Factory.newInstance();
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) XSLFSimpleShape.class);

    XSLFSimpleShape(XmlObject xmlObject, XSLFSheet xSLFSheet) {
        super(xmlObject, xSLFSheet);
    }

    @Override // org.apache.poi.sl.usermodel.SimpleShape
    public void setShapeType(ShapeType shapeType) {
        XSLFPropertiesDelegate.XSLFGeometryProperties geometryDelegate = XSLFPropertiesDelegate.getGeometryDelegate(getShapeProperties());
        if (geometryDelegate == null) {
            return;
        }
        if (geometryDelegate.isSetCustGeom()) {
            geometryDelegate.unsetCustGeom();
        }
        (geometryDelegate.isSetPrstGeom() ? geometryDelegate.getPrstGeom() : geometryDelegate.addNewPrstGeom()).setPrst(STShapeType.Enum.forInt(shapeType.ooxmlId));
    }

    @Override // org.apache.poi.sl.usermodel.SimpleShape
    public ShapeType getShapeType() {
        STShapeType.Enum prst;
        XSLFPropertiesDelegate.XSLFGeometryProperties geometryDelegate = XSLFPropertiesDelegate.getGeometryDelegate(getShapeProperties());
        if (geometryDelegate == null || !geometryDelegate.isSetPrstGeom() || (prst = geometryDelegate.getPrstGeom().getPrst()) == null) {
            return null;
        }
        return ShapeType.forId(prst.intValue(), true);
    }

    protected CTTransform2D getXfrm(boolean z) {
        PropertyFetcher<CTTransform2D> propertyFetcher = new PropertyFetcher<CTTransform2D>() { // from class: org.apache.poi.xslf.usermodel.XSLFSimpleShape.1
            @Override // org.apache.poi.xslf.model.PropertyFetcher
            public boolean fetch(XSLFShape xSLFShape) {
                CTShapeProperties shapeProperties = xSLFShape.getShapeProperties();
                if (!(shapeProperties instanceof CTShapeProperties)) {
                    return false;
                }
                CTShapeProperties cTShapeProperties = shapeProperties;
                if (!cTShapeProperties.isSetXfrm()) {
                    return false;
                }
                setValue(cTShapeProperties.getXfrm());
                return true;
            }
        };
        fetchShapeProperty(propertyFetcher);
        CTTransform2D value = propertyFetcher.getValue();
        if (!z || value != null) {
            return value;
        }
        CTShapeProperties shapeProperties = getShapeProperties();
        if (shapeProperties instanceof CTShapeProperties) {
            return shapeProperties.addNewXfrm();
        }
        LOG.log(5, getClass() + " doesn't have xfrm element.");
        return null;
    }

    @Override // org.apache.poi.sl.usermodel.Shape, org.apache.poi.sl.usermodel.PlaceableShape
    public Rectangle2D getAnchor() {
        CTTransform2D xfrm = getXfrm(false);
        if (xfrm == null) {
            return null;
        }
        CTPoint2D off = xfrm.getOff();
        double points = Units.toPoints(off.getX());
        double points2 = Units.toPoints(off.getY());
        CTPositiveSize2D ext = xfrm.getExt();
        return new Rectangle2D.Double(points, points2, Units.toPoints(ext.getCx()), Units.toPoints(ext.getCy()));
    }

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public void setAnchor(Rectangle2D rectangle2D) {
        CTTransform2D xfrm = getXfrm(true);
        if (xfrm == null) {
            return;
        }
        CTPoint2D off = xfrm.isSetOff() ? xfrm.getOff() : xfrm.addNewOff();
        long emu = Units.toEMU(rectangle2D.getX());
        long emu2 = Units.toEMU(rectangle2D.getY());
        off.setX(emu);
        off.setY(emu2);
        CTPositiveSize2D ext = xfrm.isSetExt() ? xfrm.getExt() : xfrm.addNewExt();
        long emu3 = Units.toEMU(rectangle2D.getWidth());
        long emu4 = Units.toEMU(rectangle2D.getHeight());
        ext.setCx(emu3);
        ext.setCy(emu4);
    }

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public void setRotation(double d) {
        CTTransform2D xfrm = getXfrm(true);
        if (xfrm != null) {
            xfrm.setRot((int) (d * 60000.0d));
        }
    }

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public double getRotation() {
        CTTransform2D xfrm = getXfrm(false);
        if (xfrm == null || !xfrm.isSetRot()) {
            return 0.0d;
        }
        return ((double) xfrm.getRot()) / 60000.0d;
    }

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public void setFlipHorizontal(boolean z) {
        CTTransform2D xfrm = getXfrm(true);
        if (xfrm != null) {
            xfrm.setFlipH(z);
        }
    }

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public void setFlipVertical(boolean z) {
        CTTransform2D xfrm = getXfrm(true);
        if (xfrm != null) {
            xfrm.setFlipV(z);
        }
    }

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public boolean getFlipHorizontal() {
        CTTransform2D xfrm = getXfrm(false);
        if (xfrm == null || !xfrm.isSetFlipH()) {
            return false;
        }
        return xfrm.getFlipH();
    }

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public boolean getFlipVertical() {
        CTTransform2D xfrm = getXfrm(false);
        if (xfrm == null || !xfrm.isSetFlipV()) {
            return false;
        }
        return xfrm.getFlipV();
    }

    CTLineProperties getDefaultLineProperties() {
        CTStyleMatrixReference lnRef;
        CTBaseStyles themeElements;
        CTStyleMatrix fmtScheme;
        CTLineStyleList lnStyleLst;
        CTShapeStyle spStyle = getSpStyle();
        if (spStyle == null || (lnRef = spStyle.getLnRef()) == null) {
            return null;
        }
        int idx = (int) lnRef.getIdx();
        XSLFTheme theme = getSheet().getTheme();
        if (theme == null || (themeElements = theme.getXmlObject().getThemeElements()) == null || (fmtScheme = themeElements.getFmtScheme()) == null || (lnStyleLst = fmtScheme.getLnStyleLst()) == null || lnStyleLst.sizeOfLnArray() < idx) {
            return null;
        }
        return lnStyleLst.getLnArray(idx - 1);
    }

    public void setLineColor(Color color) {
        CTLineProperties ln = getLn(this, true);
        if (ln == null) {
            return;
        }
        if (ln.isSetSolidFill()) {
            ln.unsetSolidFill();
        }
        if (ln.isSetGradFill()) {
            ln.unsetGradFill();
        }
        if (ln.isSetPattFill()) {
            ln.unsetPattFill();
        }
        if (ln.isSetNoFill()) {
            ln.unsetNoFill();
        }
        if (color == null) {
            ln.addNewNoFill();
        } else {
            CTSolidColorFillProperties cTSolidColorFillPropertiesAddNewSolidFill = ln.addNewSolidFill();
            new XSLFColor(cTSolidColorFillPropertiesAddNewSolidFill, getSheet().getTheme(), cTSolidColorFillPropertiesAddNewSolidFill.getSchemeClr()).setColor(color);
        }
    }

    public Color getLineColor() {
        PaintStyle linePaint = getLinePaint();
        if (linePaint instanceof PaintStyle.SolidPaint) {
            return ((PaintStyle.SolidPaint) linePaint).getSolidColor().getColor();
        }
        return null;
    }

    protected PaintStyle getLinePaint() {
        final XSLFTheme theme = getSheet().getTheme();
        final boolean z = getPlaceholder() != null;
        PropertyFetcher<PaintStyle> propertyFetcher = new PropertyFetcher<PaintStyle>() { // from class: org.apache.poi.xslf.usermodel.XSLFSimpleShape.2
            @Override // org.apache.poi.xslf.model.PropertyFetcher
            public boolean fetch(XSLFShape xSLFShape) {
                XSLFPropertiesDelegate.XSLFFillProperties fillDelegate = XSLFPropertiesDelegate.getFillDelegate(XSLFSimpleShape.getLn(xSLFShape, false));
                if (fillDelegate != null && fillDelegate.isSetNoFill()) {
                    setValue(null);
                    return true;
                }
                PackagePart packagePart = xSLFShape.getSheet().getPackagePart();
                PaintStyle paintStyleSelectPaint = XSLFShape.selectPaint(fillDelegate, null, packagePart, theme, z);
                if (paintStyleSelectPaint != null) {
                    setValue(paintStyleSelectPaint);
                    return true;
                }
                CTShapeStyle spStyle = xSLFShape.getSpStyle();
                if (spStyle != null && (paintStyleSelectPaint = XSLFShape.selectPaint(XSLFPropertiesDelegate.getFillDelegate(spStyle.getLnRef()), null, packagePart, theme, z)) == null) {
                    paintStyleSelectPaint = getThemePaint(spStyle, packagePart);
                }
                if (paintStyleSelectPaint == null) {
                    return false;
                }
                setValue(paintStyleSelectPaint);
                return true;
            }

            PaintStyle getThemePaint(CTShapeStyle cTShapeStyle, PackagePart packagePart) {
                CTStyleMatrixReference lnRef = cTShapeStyle.getLnRef();
                if (lnRef == null) {
                    return null;
                }
                int idx = (int) lnRef.getIdx();
                CTSchemeColor schemeClr = lnRef.getSchemeClr();
                if (idx <= 0) {
                    return null;
                }
                return XSLFShape.selectPaint(XSLFPropertiesDelegate.getFillDelegate(theme.getXmlObject().getThemeElements().getFmtScheme().getLnStyleLst().getLnArray(idx - 1)), schemeClr, packagePart, theme, z);
            }
        };
        fetchShapeProperty(propertyFetcher);
        return propertyFetcher.getValue();
    }

    public void setLineWidth(double d) {
        CTLineProperties ln = getLn(this, true);
        if (ln == null) {
            return;
        }
        if (d == 0.0d) {
            if (ln.isSetW()) {
                ln.unsetW();
            }
            if (!ln.isSetNoFill()) {
                ln.addNewNoFill();
            }
            if (ln.isSetSolidFill()) {
                ln.unsetSolidFill();
            }
            if (ln.isSetGradFill()) {
                ln.unsetGradFill();
            }
            if (ln.isSetPattFill()) {
                ln.unsetPattFill();
                return;
            }
            return;
        }
        if (ln.isSetNoFill()) {
            ln.unsetNoFill();
        }
        ln.setW(Units.toEMU(d));
    }

    public double getLineWidth() {
        PropertyFetcher<Double> propertyFetcher = new PropertyFetcher<Double>() { // from class: org.apache.poi.xslf.usermodel.XSLFSimpleShape.3
            @Override // org.apache.poi.xslf.model.PropertyFetcher
            public boolean fetch(XSLFShape xSLFShape) {
                CTLineProperties ln = XSLFSimpleShape.getLn(xSLFShape, false);
                if (ln != null) {
                    if (ln.isSetNoFill()) {
                        setValue(Double.valueOf(0.0d));
                        return true;
                    }
                    if (ln.isSetW()) {
                        setValue(Double.valueOf(Units.toPoints(ln.getW())));
                        return true;
                    }
                }
                return false;
            }
        };
        fetchShapeProperty(propertyFetcher);
        if (propertyFetcher.getValue() == null) {
            CTLineProperties defaultLineProperties = getDefaultLineProperties();
            if (defaultLineProperties == null || !defaultLineProperties.isSetW()) {
                return 0.0d;
            }
            return Units.toPoints(defaultLineProperties.getW());
        }
        return propertyFetcher.getValue().doubleValue();
    }

    public void setLineCompound(StrokeStyle.LineCompound lineCompound) {
        STCompoundLine.Enum r3;
        CTLineProperties ln = getLn(this, true);
        if (ln == null) {
            return;
        }
        if (lineCompound == null) {
            if (ln.isSetCmpd()) {
                ln.unsetCmpd();
                return;
            }
            return;
        }
        int i = AnonymousClass11.$SwitchMap$org$apache$poi$sl$usermodel$StrokeStyle$LineCompound[lineCompound.ordinal()];
        if (i == 2) {
            r3 = STCompoundLine.DBL;
        } else if (i == 3) {
            r3 = STCompoundLine.THICK_THIN;
        } else if (i == 4) {
            r3 = STCompoundLine.THIN_THICK;
        } else if (i != 5) {
            r3 = STCompoundLine.SNG;
        } else {
            r3 = STCompoundLine.TRI;
        }
        ln.setCmpd(r3);
    }

    /* JADX INFO: renamed from: org.apache.poi.xslf.usermodel.XSLFSimpleShape$11, reason: invalid class name */
    static /* synthetic */ class AnonymousClass11 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$StrokeStyle$LineCompound;

        static {
            int[] iArr = new int[StrokeStyle.LineCompound.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$StrokeStyle$LineCompound = iArr;
            try {
                iArr[StrokeStyle.LineCompound.SINGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$StrokeStyle$LineCompound[StrokeStyle.LineCompound.DOUBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$StrokeStyle$LineCompound[StrokeStyle.LineCompound.THICK_THIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$StrokeStyle$LineCompound[StrokeStyle.LineCompound.THIN_THICK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$StrokeStyle$LineCompound[StrokeStyle.LineCompound.TRIPLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public StrokeStyle.LineCompound getLineCompound() {
        CTLineProperties defaultLineProperties;
        PropertyFetcher<Integer> propertyFetcher = new PropertyFetcher<Integer>() { // from class: org.apache.poi.xslf.usermodel.XSLFSimpleShape.4
            @Override // org.apache.poi.xslf.model.PropertyFetcher
            public boolean fetch(XSLFShape xSLFShape) {
                STCompoundLine.Enum cmpd;
                CTLineProperties ln = XSLFSimpleShape.getLn(xSLFShape, false);
                if (ln == null || (cmpd = ln.getCmpd()) == null) {
                    return false;
                }
                setValue(Integer.valueOf(cmpd.intValue()));
                return true;
            }
        };
        fetchShapeProperty(propertyFetcher);
        if (propertyFetcher.getValue() != null || (defaultLineProperties = getDefaultLineProperties()) == null || !defaultLineProperties.isSetCmpd()) {
            return null;
        }
        int iIntValue = defaultLineProperties.getCmpd().intValue();
        if (iIntValue == 2) {
            return StrokeStyle.LineCompound.DOUBLE;
        }
        if (iIntValue == 3) {
            return StrokeStyle.LineCompound.THICK_THIN;
        }
        if (iIntValue == 4) {
            return StrokeStyle.LineCompound.THIN_THICK;
        }
        if (iIntValue != 5) {
            return StrokeStyle.LineCompound.SINGLE;
        }
        return StrokeStyle.LineCompound.TRIPLE;
    }

    public void setLineDash(StrokeStyle.LineDash lineDash) {
        CTLineProperties ln = getLn(this, true);
        if (ln == null) {
            return;
        }
        if (lineDash == null) {
            if (ln.isSetPrstDash()) {
                ln.unsetPrstDash();
                return;
            }
            return;
        }
        (ln.isSetPrstDash() ? ln.getPrstDash() : ln.addNewPrstDash()).setVal(STPresetLineDashVal.Enum.forInt(lineDash.ooxmlId));
    }

    public StrokeStyle.LineDash getLineDash() {
        CTLineProperties defaultLineProperties;
        PropertyFetcher<StrokeStyle.LineDash> propertyFetcher = new PropertyFetcher<StrokeStyle.LineDash>() { // from class: org.apache.poi.xslf.usermodel.XSLFSimpleShape.5
            @Override // org.apache.poi.xslf.model.PropertyFetcher
            public boolean fetch(XSLFShape xSLFShape) {
                CTLineProperties ln = XSLFSimpleShape.getLn(xSLFShape, false);
                if (ln == null || !ln.isSetPrstDash()) {
                    return false;
                }
                setValue(StrokeStyle.LineDash.fromOoxmlId(ln.getPrstDash().getVal().intValue()));
                return true;
            }
        };
        fetchShapeProperty(propertyFetcher);
        StrokeStyle.LineDash value = propertyFetcher.getValue();
        return (value == null && (defaultLineProperties = getDefaultLineProperties()) != null && defaultLineProperties.isSetPrstDash()) ? StrokeStyle.LineDash.fromOoxmlId(defaultLineProperties.getPrstDash().getVal().intValue()) : value;
    }

    public void setLineCap(StrokeStyle.LineCap lineCap) {
        CTLineProperties ln = getLn(this, true);
        if (ln == null) {
            return;
        }
        if (lineCap == null) {
            if (ln.isSetCap()) {
                ln.unsetCap();
                return;
            }
            return;
        }
        ln.setCap(STLineCap.Enum.forInt(lineCap.ooxmlId));
    }

    public StrokeStyle.LineCap getLineCap() {
        CTLineProperties defaultLineProperties;
        PropertyFetcher<StrokeStyle.LineCap> propertyFetcher = new PropertyFetcher<StrokeStyle.LineCap>() { // from class: org.apache.poi.xslf.usermodel.XSLFSimpleShape.6
            @Override // org.apache.poi.xslf.model.PropertyFetcher
            public boolean fetch(XSLFShape xSLFShape) {
                CTLineProperties ln = XSLFSimpleShape.getLn(xSLFShape, false);
                if (ln == null || !ln.isSetCap()) {
                    return false;
                }
                setValue(StrokeStyle.LineCap.fromOoxmlId(ln.getCap().intValue()));
                return true;
            }
        };
        fetchShapeProperty(propertyFetcher);
        StrokeStyle.LineCap value = propertyFetcher.getValue();
        return (value == null && (defaultLineProperties = getDefaultLineProperties()) != null && defaultLineProperties.isSetCap()) ? StrokeStyle.LineCap.fromOoxmlId(defaultLineProperties.getCap().intValue()) : value;
    }

    public void setFillColor(Color color) {
        XSLFPropertiesDelegate.XSLFFillProperties fillDelegate = XSLFPropertiesDelegate.getFillDelegate(getShapeProperties());
        if (fillDelegate == null) {
            return;
        }
        if (color == null) {
            if (fillDelegate.isSetSolidFill()) {
                fillDelegate.unsetSolidFill();
            }
            if (fillDelegate.isSetGradFill()) {
                fillDelegate.unsetGradFill();
            }
            if (fillDelegate.isSetPattFill()) {
                fillDelegate.unsetGradFill();
            }
            if (fillDelegate.isSetBlipFill()) {
                fillDelegate.unsetBlipFill();
            }
            if (fillDelegate.isSetNoFill()) {
                return;
            }
            fillDelegate.addNewNoFill();
            return;
        }
        if (fillDelegate.isSetNoFill()) {
            fillDelegate.unsetNoFill();
        }
        CTSolidColorFillProperties solidFill = fillDelegate.isSetSolidFill() ? fillDelegate.getSolidFill() : fillDelegate.addNewSolidFill();
        new XSLFColor(solidFill, getSheet().getTheme(), solidFill.getSchemeClr()).setColor(color);
    }

    @Override // org.apache.poi.sl.usermodel.SimpleShape
    public Color getFillColor() {
        PaintStyle fillPaint = getFillPaint();
        if (fillPaint instanceof PaintStyle.SolidPaint) {
            return DrawPaint.applyColorTransform(((PaintStyle.SolidPaint) fillPaint).getSolidColor());
        }
        return null;
    }

    @Override // org.apache.poi.sl.usermodel.SimpleShape
    public XSLFShadow getShadow() {
        CTShapeStyle spStyle;
        int idx;
        PropertyFetcher<CTOuterShadowEffect> propertyFetcher = new PropertyFetcher<CTOuterShadowEffect>() { // from class: org.apache.poi.xslf.usermodel.XSLFSimpleShape.7
            @Override // org.apache.poi.xslf.model.PropertyFetcher
            public boolean fetch(XSLFShape xSLFShape) {
                XSLFPropertiesDelegate.XSLFEffectProperties effectDelegate = XSLFPropertiesDelegate.getEffectDelegate(xSLFShape.getShapeProperties());
                if (effectDelegate == null || !effectDelegate.isSetEffectLst()) {
                    return false;
                }
                CTOuterShadowEffect outerShdw = effectDelegate.getEffectLst().getOuterShdw();
                if (outerShdw == null) {
                    outerShdw = XSLFSimpleShape.NO_SHADOW;
                }
                setValue(outerShdw);
                return true;
            }
        };
        fetchShapeProperty(propertyFetcher);
        CTOuterShadowEffect value = propertyFetcher.getValue();
        if (value == null && (spStyle = getSpStyle()) != null && spStyle.getEffectRef() != null && (idx = (int) spStyle.getEffectRef().getIdx()) != 0) {
            value = getSheet().getTheme().getXmlObject().getThemeElements().getFmtScheme().getEffectStyleLst().getEffectStyleArray(idx - 1).getEffectLst().getOuterShdw();
        }
        if (value == null || value == NO_SHADOW) {
            return null;
        }
        return new XSLFShadow(value, this);
    }

    @Override // org.apache.poi.sl.usermodel.SimpleShape
    public CustomGeometry getGeometry() {
        XSLFPropertiesDelegate.XSLFGeometryProperties geometryDelegate = XSLFPropertiesDelegate.getGeometryDelegate(getShapeProperties());
        if (geometryDelegate == null) {
            return null;
        }
        PresetGeometries presetGeometries = PresetGeometries.getInstance();
        if (geometryDelegate.isSetPrstGeom()) {
            String string = geometryDelegate.getPrstGeom().getPrst().toString();
            CustomGeometry customGeometry = (CustomGeometry) presetGeometries.get(string);
            if (customGeometry != null) {
                return customGeometry;
            }
            throw new IllegalStateException("Unknown shape geometry: " + string + ", available geometries are: " + presetGeometries.keySet());
        }
        if (geometryDelegate.isSetCustGeom()) {
            XMLStreamReader xMLStreamReaderNewXMLStreamReader = geometryDelegate.getCustGeom().newXMLStreamReader();
            CustomGeometry customGeometryConvertCustomGeometry = PresetGeometries.convertCustomGeometry(xMLStreamReaderNewXMLStreamReader);
            try {
                xMLStreamReaderNewXMLStreamReader.close();
                return customGeometryConvertCustomGeometry;
            } catch (XMLStreamException e) {
                LOG.log(5, "An error occurred while closing a Custom Geometry XML Stream Reader: " + e.getMessage());
                return customGeometryConvertCustomGeometry;
            }
        }
        return (CustomGeometry) presetGeometries.get("rect");
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    void copy(XSLFShape xSLFShape) {
        super.copy(xSLFShape);
        XSLFSimpleShape xSLFSimpleShape = (XSLFSimpleShape) xSLFShape;
        Color fillColor = xSLFSimpleShape.getFillColor();
        Color fillColor2 = getFillColor();
        if (fillColor != null && !fillColor.equals(fillColor2)) {
            setFillColor(fillColor);
        }
        XSLFPropertiesDelegate.XSLFFillProperties fillDelegate = XSLFPropertiesDelegate.getFillDelegate(getShapeProperties());
        if (fillDelegate != null && fillDelegate.isSetBlipFill()) {
            CTBlip blip = fillDelegate.getBlipFill().getBlip();
            blip.setEmbed(getSheet().importBlip(blip.getEmbed(), xSLFSimpleShape.getSheet().getPackagePart()));
        }
        Color lineColor = xSLFSimpleShape.getLineColor();
        Color lineColor2 = getLineColor();
        if (lineColor != null && !lineColor.equals(lineColor2)) {
            setLineColor(lineColor);
        }
        double lineWidth = xSLFSimpleShape.getLineWidth();
        if (lineWidth != getLineWidth()) {
            setLineWidth(lineWidth);
        }
        StrokeStyle.LineDash lineDash = xSLFSimpleShape.getLineDash();
        StrokeStyle.LineDash lineDash2 = getLineDash();
        if (lineDash != null && lineDash != lineDash2) {
            setLineDash(lineDash);
        }
        StrokeStyle.LineCap lineCap = xSLFSimpleShape.getLineCap();
        StrokeStyle.LineCap lineCap2 = getLineCap();
        if (lineCap == null || lineCap == lineCap2) {
            return;
        }
        setLineCap(lineCap);
    }

    public void setLineHeadDecoration(LineDecoration.DecorationShape decorationShape) {
        CTLineProperties ln = getLn(this, true);
        if (ln == null) {
            return;
        }
        CTLineEndProperties headEnd = ln.isSetHeadEnd() ? ln.getHeadEnd() : ln.addNewHeadEnd();
        if (decorationShape == null) {
            if (headEnd.isSetType()) {
                headEnd.unsetType();
                return;
            }
            return;
        }
        headEnd.setType(STLineEndType.Enum.forInt(decorationShape.ooxmlId));
    }

    public LineDecoration.DecorationShape getLineHeadDecoration() {
        CTLineProperties ln = getLn(this, false);
        LineDecoration.DecorationShape decorationShape = LineDecoration.DecorationShape.NONE;
        return (ln != null && ln.isSetHeadEnd() && ln.getHeadEnd().isSetType()) ? LineDecoration.DecorationShape.fromOoxmlId(ln.getHeadEnd().getType().intValue()) : decorationShape;
    }

    public void setLineHeadWidth(LineDecoration.DecorationSize decorationSize) {
        CTLineProperties ln = getLn(this, true);
        if (ln == null) {
            return;
        }
        CTLineEndProperties headEnd = ln.isSetHeadEnd() ? ln.getHeadEnd() : ln.addNewHeadEnd();
        if (decorationSize == null) {
            if (headEnd.isSetW()) {
                headEnd.unsetW();
                return;
            }
            return;
        }
        headEnd.setW(STLineEndWidth.Enum.forInt(decorationSize.ooxmlId));
    }

    public LineDecoration.DecorationSize getLineHeadWidth() {
        CTLineProperties ln = getLn(this, false);
        LineDecoration.DecorationSize decorationSize = LineDecoration.DecorationSize.MEDIUM;
        return (ln != null && ln.isSetHeadEnd() && ln.getHeadEnd().isSetW()) ? LineDecoration.DecorationSize.fromOoxmlId(ln.getHeadEnd().getW().intValue()) : decorationSize;
    }

    public void setLineHeadLength(LineDecoration.DecorationSize decorationSize) {
        CTLineProperties ln = getLn(this, true);
        if (ln == null) {
            return;
        }
        CTLineEndProperties headEnd = ln.isSetHeadEnd() ? ln.getHeadEnd() : ln.addNewHeadEnd();
        if (decorationSize == null) {
            if (headEnd.isSetLen()) {
                headEnd.unsetLen();
                return;
            }
            return;
        }
        headEnd.setLen(STLineEndLength.Enum.forInt(decorationSize.ooxmlId));
    }

    public LineDecoration.DecorationSize getLineHeadLength() {
        CTLineProperties ln = getLn(this, false);
        LineDecoration.DecorationSize decorationSize = LineDecoration.DecorationSize.MEDIUM;
        return (ln != null && ln.isSetHeadEnd() && ln.getHeadEnd().isSetLen()) ? LineDecoration.DecorationSize.fromOoxmlId(ln.getHeadEnd().getLen().intValue()) : decorationSize;
    }

    public void setLineTailDecoration(LineDecoration.DecorationShape decorationShape) {
        CTLineProperties ln = getLn(this, true);
        if (ln == null) {
            return;
        }
        CTLineEndProperties tailEnd = ln.isSetTailEnd() ? ln.getTailEnd() : ln.addNewTailEnd();
        if (decorationShape == null) {
            if (tailEnd.isSetType()) {
                tailEnd.unsetType();
                return;
            }
            return;
        }
        tailEnd.setType(STLineEndType.Enum.forInt(decorationShape.ooxmlId));
    }

    public LineDecoration.DecorationShape getLineTailDecoration() {
        CTLineProperties ln = getLn(this, false);
        LineDecoration.DecorationShape decorationShape = LineDecoration.DecorationShape.NONE;
        return (ln != null && ln.isSetTailEnd() && ln.getTailEnd().isSetType()) ? LineDecoration.DecorationShape.fromOoxmlId(ln.getTailEnd().getType().intValue()) : decorationShape;
    }

    public void setLineTailWidth(LineDecoration.DecorationSize decorationSize) {
        CTLineProperties ln = getLn(this, true);
        if (ln == null) {
            return;
        }
        CTLineEndProperties tailEnd = ln.isSetTailEnd() ? ln.getTailEnd() : ln.addNewTailEnd();
        if (decorationSize == null) {
            if (tailEnd.isSetW()) {
                tailEnd.unsetW();
                return;
            }
            return;
        }
        tailEnd.setW(STLineEndWidth.Enum.forInt(decorationSize.ooxmlId));
    }

    public LineDecoration.DecorationSize getLineTailWidth() {
        CTLineProperties ln = getLn(this, false);
        LineDecoration.DecorationSize decorationSize = LineDecoration.DecorationSize.MEDIUM;
        return (ln != null && ln.isSetTailEnd() && ln.getTailEnd().isSetW()) ? LineDecoration.DecorationSize.fromOoxmlId(ln.getTailEnd().getW().intValue()) : decorationSize;
    }

    public void setLineTailLength(LineDecoration.DecorationSize decorationSize) {
        CTLineProperties ln = getLn(this, true);
        if (ln == null) {
            return;
        }
        CTLineEndProperties tailEnd = ln.isSetTailEnd() ? ln.getTailEnd() : ln.addNewTailEnd();
        if (decorationSize == null) {
            if (tailEnd.isSetLen()) {
                tailEnd.unsetLen();
                return;
            }
            return;
        }
        tailEnd.setLen(STLineEndLength.Enum.forInt(decorationSize.ooxmlId));
    }

    public LineDecoration.DecorationSize getLineTailLength() {
        CTLineProperties ln = getLn(this, false);
        LineDecoration.DecorationSize decorationSize = LineDecoration.DecorationSize.MEDIUM;
        return (ln != null && ln.isSetTailEnd() && ln.getTailEnd().isSetLen()) ? LineDecoration.DecorationSize.fromOoxmlId(ln.getTailEnd().getLen().intValue()) : decorationSize;
    }

    public boolean isPlaceholder() {
        return getCTPlaceholder() != null;
    }

    @Override // org.apache.poi.sl.draw.geom.IAdjustableShape
    public Guide getAdjustValue(String str) {
        XSLFPropertiesDelegate.XSLFGeometryProperties geometryDelegate = XSLFPropertiesDelegate.getGeometryDelegate(getShapeProperties());
        if (geometryDelegate == null || !geometryDelegate.isSetPrstGeom() || !geometryDelegate.getPrstGeom().isSetAvLst()) {
            return null;
        }
        for (CTGeomGuide cTGeomGuide : geometryDelegate.getPrstGeom().getAvLst().getGdArray()) {
            if (cTGeomGuide.getName().equals(str)) {
                return new Guide(cTGeomGuide.getName(), cTGeomGuide.getFmla());
            }
        }
        return null;
    }

    @Override // org.apache.poi.sl.usermodel.SimpleShape
    public LineDecoration getLineDecoration() {
        return new LineDecoration() { // from class: org.apache.poi.xslf.usermodel.XSLFSimpleShape.8
            @Override // org.apache.poi.sl.usermodel.LineDecoration
            public LineDecoration.DecorationShape getHeadShape() {
                return XSLFSimpleShape.this.getLineHeadDecoration();
            }

            @Override // org.apache.poi.sl.usermodel.LineDecoration
            public LineDecoration.DecorationSize getHeadWidth() {
                return XSLFSimpleShape.this.getLineHeadWidth();
            }

            @Override // org.apache.poi.sl.usermodel.LineDecoration
            public LineDecoration.DecorationSize getHeadLength() {
                return XSLFSimpleShape.this.getLineHeadLength();
            }

            @Override // org.apache.poi.sl.usermodel.LineDecoration
            public LineDecoration.DecorationShape getTailShape() {
                return XSLFSimpleShape.this.getLineTailDecoration();
            }

            @Override // org.apache.poi.sl.usermodel.LineDecoration
            public LineDecoration.DecorationSize getTailWidth() {
                return XSLFSimpleShape.this.getLineTailWidth();
            }

            @Override // org.apache.poi.sl.usermodel.LineDecoration
            public LineDecoration.DecorationSize getTailLength() {
                return XSLFSimpleShape.this.getLineTailLength();
            }
        };
    }

    @Override // org.apache.poi.sl.usermodel.SimpleShape
    public FillStyle getFillStyle() {
        return new FillStyle() { // from class: org.apache.poi.xslf.usermodel.XSLFSimpleShape.9
            @Override // org.apache.poi.sl.usermodel.FillStyle
            public PaintStyle getPaint() {
                return XSLFSimpleShape.this.getFillPaint();
            }
        };
    }

    @Override // org.apache.poi.sl.usermodel.SimpleShape
    public StrokeStyle getStrokeStyle() {
        return new StrokeStyle() { // from class: org.apache.poi.xslf.usermodel.XSLFSimpleShape.10
            @Override // org.apache.poi.sl.usermodel.StrokeStyle
            public PaintStyle getPaint() {
                return XSLFSimpleShape.this.getLinePaint();
            }

            @Override // org.apache.poi.sl.usermodel.StrokeStyle
            public StrokeStyle.LineCap getLineCap() {
                return XSLFSimpleShape.this.getLineCap();
            }

            @Override // org.apache.poi.sl.usermodel.StrokeStyle
            public StrokeStyle.LineDash getLineDash() {
                return XSLFSimpleShape.this.getLineDash();
            }

            @Override // org.apache.poi.sl.usermodel.StrokeStyle
            public double getLineWidth() {
                return XSLFSimpleShape.this.getLineWidth();
            }

            @Override // org.apache.poi.sl.usermodel.StrokeStyle
            public StrokeStyle.LineCompound getLineCompound() {
                return XSLFSimpleShape.this.getLineCompound();
            }
        };
    }

    @Override // org.apache.poi.sl.usermodel.SimpleShape
    public void setStrokeStyle(Object... objArr) {
        if (objArr.length == 0) {
            setLineColor(null);
            return;
        }
        for (Object obj : objArr) {
            if (obj instanceof Number) {
                setLineWidth(((Number) obj).doubleValue());
            } else if (obj instanceof StrokeStyle.LineCap) {
                setLineCap((StrokeStyle.LineCap) obj);
            } else if (obj instanceof StrokeStyle.LineDash) {
                setLineDash((StrokeStyle.LineDash) obj);
            } else if (obj instanceof StrokeStyle.LineCompound) {
                setLineCompound((StrokeStyle.LineCompound) obj);
            } else if (obj instanceof Color) {
                setLineColor((Color) obj);
            }
        }
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape, org.apache.poi.sl.usermodel.SimpleShape
    public void setPlaceholder(Placeholder placeholder) {
        super.setPlaceholder(placeholder);
    }

    @Override // org.apache.poi.sl.usermodel.SimpleShape
    public XSLFHyperlink getHyperlink() {
        CTNonVisualDrawingProps cNvPr = getCNvPr();
        if (cNvPr.isSetHlinkClick()) {
            return new XSLFHyperlink(cNvPr.getHlinkClick(), getSheet());
        }
        return null;
    }

    @Override // org.apache.poi.sl.usermodel.SimpleShape
    public XSLFHyperlink createHyperlink() {
        XSLFHyperlink hyperlink = getHyperlink();
        return hyperlink == null ? new XSLFHyperlink(getCNvPr().addNewHlinkClick(), getSheet()) : hyperlink;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static CTLineProperties getLn(XSLFShape xSLFShape, boolean z) {
        CTShapeProperties shapeProperties = xSLFShape.getShapeProperties();
        if (!(shapeProperties instanceof CTShapeProperties)) {
            LOG.log(5, xSLFShape.getClass() + " doesn't have line properties");
            return null;
        }
        CTShapeProperties cTShapeProperties = shapeProperties;
        return (cTShapeProperties.isSetLn() || !z) ? cTShapeProperties.getLn() : cTShapeProperties.addNewLn();
    }
}
