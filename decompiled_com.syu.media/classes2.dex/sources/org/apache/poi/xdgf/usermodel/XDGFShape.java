package org.apache.poi.xdgf.usermodel;

import com.microsoft.schemas.office.visio.x2012.main.ShapeSheetType;
import com.microsoft.schemas.office.visio.x2012.main.TextType;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import org.apache.poi.POIXMLException;
import org.apache.poi.util.Internal;
import org.apache.poi.xdgf.exceptions.XDGFException;
import org.apache.poi.xdgf.usermodel.section.CombinedIterable;
import org.apache.poi.xdgf.usermodel.section.GeometrySection;
import org.apache.poi.xdgf.usermodel.section.XDGFSection;
import org.apache.poi.xdgf.usermodel.shape.ShapeVisitor;
import org.apache.poi.xdgf.usermodel.shape.exceptions.StopVisitingThisBranch;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XDGFShape extends XDGFSheet {
    Double _angle;
    Double _beginX;
    Double _beginY;
    Double _endX;
    Double _endY;
    Boolean _flipX;
    Boolean _flipY;
    Double _height;
    Double _locPinX;
    Double _locPinY;
    XDGFMaster _master;
    XDGFShape _masterShape;
    XDGFShape _parent;
    XDGFBaseContents _parentPage;
    Double _pinX;
    Double _pinY;
    Double _rotationXAngle;
    Double _rotationYAngle;
    Double _rotationZAngle;
    List<XDGFShape> _shapes;
    XDGFText _text;
    Double _txtAngle;
    Double _txtHeight;
    Double _txtLocPinX;
    Double _txtLocPinY;
    Double _txtPinX;
    Double _txtPinY;
    Double _txtWidth;
    Double _width;

    public XDGFShape(ShapeSheetType shapeSheetType, XDGFBaseContents xDGFBaseContents, XDGFDocument xDGFDocument) {
        this(null, shapeSheetType, xDGFBaseContents, xDGFDocument);
    }

    public XDGFShape(XDGFShape xDGFShape, ShapeSheetType shapeSheetType, XDGFBaseContents xDGFBaseContents, XDGFDocument xDGFDocument) {
        super(shapeSheetType, xDGFDocument);
        this._master = null;
        this._masterShape = null;
        this._text = null;
        this._shapes = null;
        this._pinX = null;
        this._pinY = null;
        this._width = null;
        this._height = null;
        this._locPinX = null;
        this._locPinY = null;
        this._beginX = null;
        this._beginY = null;
        this._endX = null;
        this._endY = null;
        this._angle = null;
        this._rotationXAngle = null;
        this._rotationYAngle = null;
        this._rotationZAngle = null;
        this._flipX = null;
        this._flipY = null;
        this._txtPinX = null;
        this._txtPinY = null;
        this._txtLocPinX = null;
        this._txtLocPinY = null;
        this._txtAngle = null;
        this._txtWidth = null;
        this._txtHeight = null;
        this._parent = xDGFShape;
        this._parentPage = xDGFBaseContents;
        TextType text = shapeSheetType.getText();
        if (text != null) {
            this._text = new XDGFText(text, this);
        }
        if (shapeSheetType.isSetShapes()) {
            this._shapes = new ArrayList();
            for (ShapeSheetType shapeSheetType2 : shapeSheetType.getShapes().getShapeArray()) {
                this._shapes.add(new XDGFShape(this, shapeSheetType2, xDGFBaseContents, xDGFDocument));
            }
        }
        readProperties();
    }

    public String toString() {
        if (this._parentPage instanceof XDGFMasterContents) {
            return this._parentPage + ": <Shape ID=\"" + getID() + "\">";
        }
        return "<Shape ID=\"" + getID() + "\">";
    }

    protected void readProperties() {
        this._pinX = XDGFCell.maybeGetDouble(this._cells, "PinX");
        this._pinY = XDGFCell.maybeGetDouble(this._cells, "PinY");
        this._width = XDGFCell.maybeGetDouble(this._cells, "Width");
        this._height = XDGFCell.maybeGetDouble(this._cells, "Height");
        this._locPinX = XDGFCell.maybeGetDouble(this._cells, "LocPinX");
        this._locPinY = XDGFCell.maybeGetDouble(this._cells, "LocPinY");
        this._beginX = XDGFCell.maybeGetDouble(this._cells, "BeginX");
        this._beginY = XDGFCell.maybeGetDouble(this._cells, "BeginY");
        this._endX = XDGFCell.maybeGetDouble(this._cells, "EndX");
        this._endY = XDGFCell.maybeGetDouble(this._cells, "EndY");
        this._angle = XDGFCell.maybeGetDouble(this._cells, "Angle");
        this._rotationXAngle = XDGFCell.maybeGetDouble(this._cells, "RotationXAngle");
        this._rotationYAngle = XDGFCell.maybeGetDouble(this._cells, "RotationYAngle");
        this._rotationZAngle = XDGFCell.maybeGetDouble(this._cells, "RotationZAngle");
        this._flipX = XDGFCell.maybeGetBoolean(this._cells, "FlipX");
        this._flipY = XDGFCell.maybeGetBoolean(this._cells, "FlipY");
        this._txtPinX = XDGFCell.maybeGetDouble(this._cells, "TxtPinX");
        this._txtPinY = XDGFCell.maybeGetDouble(this._cells, "TxtPinY");
        this._txtLocPinX = XDGFCell.maybeGetDouble(this._cells, "TxtLocPinX");
        this._txtLocPinY = XDGFCell.maybeGetDouble(this._cells, "TxtLocPinY");
        this._txtWidth = XDGFCell.maybeGetDouble(this._cells, "TxtWidth");
        this._txtHeight = XDGFCell.maybeGetDouble(this._cells, "TxtHeight");
        this._txtAngle = XDGFCell.maybeGetDouble(this._cells, "TxtAngle");
    }

    protected void setupMaster(XDGFPageContents xDGFPageContents, XDGFMasterContents xDGFMasterContents) {
        ShapeSheetType shapeSheetTypeMo1575getXmlObject = mo1575getXmlObject();
        if (shapeSheetTypeMo1575getXmlObject.isSetMaster()) {
            XDGFMaster masterById = xDGFPageContents.getMasterById(shapeSheetTypeMo1575getXmlObject.getMaster());
            this._master = masterById;
            if (masterById == null) {
                throw XDGFException.error("refers to non-existant master " + shapeSheetTypeMo1575getXmlObject.getMaster(), this);
            }
            List<XDGFShape> topLevelShapes = masterById.getContent().getTopLevelShapes();
            int size = topLevelShapes.size();
            if (size == 0) {
                throw XDGFException.error("Could not retrieve master shape from " + this._master, this);
            }
            if (size == 1) {
                this._masterShape = topLevelShapes.iterator().next();
            }
        } else if (shapeSheetTypeMo1575getXmlObject.isSetMasterShape()) {
            XDGFShape shapeById = xDGFMasterContents.getShapeById(shapeSheetTypeMo1575getXmlObject.getMasterShape());
            this._masterShape = shapeById;
            if (shapeById == null) {
                throw XDGFException.error("refers to non-existant master shape " + shapeSheetTypeMo1575getXmlObject.getMasterShape(), this);
            }
        }
        setupSectionMasters();
        List<XDGFShape> list = this._shapes;
        if (list != null) {
            for (XDGFShape xDGFShape : list) {
                XDGFMaster xDGFMaster = this._master;
                xDGFShape.setupMaster(xDGFPageContents, xDGFMaster == null ? xDGFMasterContents : xDGFMaster.getContent());
            }
        }
    }

    protected void setupSectionMasters() {
        if (this._masterShape == null) {
            return;
        }
        try {
            for (Map.Entry<String, XDGFSection> entry : this._sections.entrySet()) {
                XDGFSection section = this._masterShape.getSection(entry.getKey());
                if (section != null) {
                    entry.getValue().setupMaster(section);
                }
            }
            for (Map.Entry<Long, GeometrySection> entry2 : this._geometry.entrySet()) {
                GeometrySection geometryByIdx = this._masterShape.getGeometryByIdx(entry2.getKey().longValue());
                if (geometryByIdx != null) {
                    entry2.getValue().setupMaster(geometryByIdx);
                }
            }
        } catch (POIXMLException e) {
            throw XDGFException.wrap(toString(), e);
        }
    }

    @Override // org.apache.poi.xdgf.usermodel.XDGFSheet
    @Internal
    /* JADX INFO: renamed from: getXmlObject, reason: merged with bridge method [inline-methods] */
    public ShapeSheetType mo1575getXmlObject() {
        return this._sheet;
    }

    public long getID() {
        return mo1575getXmlObject().getID();
    }

    public String getType() {
        return mo1575getXmlObject().getType();
    }

    public String getTextAsString() {
        XDGFText text = getText();
        return text == null ? "" : text.getTextContent();
    }

    public boolean hasText() {
        XDGFShape xDGFShape;
        return (this._text == null && ((xDGFShape = this._masterShape) == null || xDGFShape._text == null)) ? false : true;
    }

    @Override // org.apache.poi.xdgf.usermodel.XDGFSheet
    public XDGFCell getCell(String str) {
        XDGFShape xDGFShape;
        XDGFCell cell = super.getCell(str);
        return (cell != null || (xDGFShape = this._masterShape) == null) ? cell : xDGFShape.getCell(str);
    }

    public GeometrySection getGeometryByIdx(long j) {
        return this._geometry.get(Long.valueOf(j));
    }

    public List<XDGFShape> getShapes() {
        return this._shapes;
    }

    public String getName() {
        String name = mo1575getXmlObject().getName();
        return name == null ? "" : name;
    }

    public String getShapeType() {
        String type = mo1575getXmlObject().getType();
        return type == null ? "" : type;
    }

    public String getSymbolName() {
        String name;
        XDGFMaster xDGFMaster = this._master;
        return (xDGFMaster == null || (name = xDGFMaster.getName()) == null) ? "" : name;
    }

    public XDGFShape getMasterShape() {
        return this._masterShape;
    }

    public XDGFShape getParentShape() {
        return this._parent;
    }

    public XDGFShape getTopmostParentShape() {
        XDGFShape xDGFShape = this._parent;
        if (xDGFShape == null) {
            return null;
        }
        XDGFShape topmostParentShape = xDGFShape.getTopmostParentShape();
        return topmostParentShape == null ? this._parent : topmostParentShape;
    }

    public boolean hasMaster() {
        return this._master != null;
    }

    public boolean hasMasterShape() {
        return this._masterShape != null;
    }

    public boolean hasParent() {
        return this._parent != null;
    }

    public boolean hasShapes() {
        return this._shapes != null;
    }

    public boolean isTopmost() {
        return this._parent == null;
    }

    public boolean isShape1D() {
        return getBeginX() != null;
    }

    public boolean isDeleted() {
        if (mo1575getXmlObject().isSetDel()) {
            return mo1575getXmlObject().getDel();
        }
        return false;
    }

    public XDGFText getText() {
        XDGFShape xDGFShape;
        XDGFText xDGFText = this._text;
        return (xDGFText != null || (xDGFShape = this._masterShape) == null) ? xDGFText : xDGFShape.getText();
    }

    public Double getPinX() {
        XDGFShape xDGFShape;
        Double d = this._pinX;
        if (d == null && (xDGFShape = this._masterShape) != null) {
            return xDGFShape.getPinX();
        }
        if (d != null) {
            return d;
        }
        throw XDGFException.error("PinX not set!", this);
    }

    public Double getPinY() {
        XDGFShape xDGFShape;
        Double d = this._pinY;
        if (d == null && (xDGFShape = this._masterShape) != null) {
            return xDGFShape.getPinY();
        }
        if (d != null) {
            return d;
        }
        throw XDGFException.error("PinY not specified!", this);
    }

    public Double getWidth() {
        XDGFShape xDGFShape;
        Double d = this._width;
        if (d == null && (xDGFShape = this._masterShape) != null) {
            return xDGFShape.getWidth();
        }
        if (d != null) {
            return d;
        }
        throw XDGFException.error("Width not specified!", this);
    }

    public Double getHeight() {
        XDGFShape xDGFShape;
        Double d = this._height;
        if (d == null && (xDGFShape = this._masterShape) != null) {
            return xDGFShape.getHeight();
        }
        if (d != null) {
            return d;
        }
        throw XDGFException.error("Height not specified!", this);
    }

    public Double getLocPinX() {
        XDGFShape xDGFShape;
        Double d = this._locPinX;
        if (d == null && (xDGFShape = this._masterShape) != null) {
            return xDGFShape.getLocPinX();
        }
        if (d != null) {
            return d;
        }
        throw XDGFException.error("LocPinX not specified!", this);
    }

    public Double getLocPinY() {
        XDGFShape xDGFShape;
        Double d = this._locPinY;
        if (d == null && (xDGFShape = this._masterShape) != null) {
            return xDGFShape.getLocPinY();
        }
        if (d != null) {
            return d;
        }
        throw XDGFException.error("LocPinY not specified!", this);
    }

    public Double getBeginX() {
        XDGFShape xDGFShape;
        Double d = this._beginX;
        return (d != null || (xDGFShape = this._masterShape) == null) ? d : xDGFShape.getBeginX();
    }

    public Double getBeginY() {
        XDGFShape xDGFShape;
        Double d = this._beginY;
        return (d != null || (xDGFShape = this._masterShape) == null) ? d : xDGFShape.getBeginY();
    }

    public Double getEndX() {
        XDGFShape xDGFShape;
        Double d = this._endX;
        return (d != null || (xDGFShape = this._masterShape) == null) ? d : xDGFShape.getEndX();
    }

    public Double getEndY() {
        XDGFShape xDGFShape;
        Double d = this._endY;
        return (d != null || (xDGFShape = this._masterShape) == null) ? d : xDGFShape.getEndY();
    }

    public Double getAngle() {
        XDGFShape xDGFShape;
        Double d = this._angle;
        return (d != null || (xDGFShape = this._masterShape) == null) ? d : xDGFShape.getAngle();
    }

    public Boolean getFlipX() {
        XDGFShape xDGFShape;
        Boolean bool = this._flipX;
        return (bool != null || (xDGFShape = this._masterShape) == null) ? bool : xDGFShape.getFlipX();
    }

    public Boolean getFlipY() {
        XDGFShape xDGFShape;
        Boolean bool = this._flipY;
        return (bool != null || (xDGFShape = this._masterShape) == null) ? bool : xDGFShape.getFlipY();
    }

    public Double getTxtPinX() {
        XDGFShape xDGFShape;
        Double d;
        Double d2 = this._txtPinX;
        if (d2 != null || (xDGFShape = this._masterShape) == null || (d = xDGFShape._txtPinX) == null) {
            return d2 == null ? Double.valueOf(getWidth().doubleValue() * 0.5d) : d2;
        }
        return d;
    }

    public Double getTxtPinY() {
        XDGFShape xDGFShape;
        Double d;
        if (this._txtLocPinY == null && (xDGFShape = this._masterShape) != null && (d = xDGFShape._txtLocPinY) != null) {
            return d;
        }
        Double d2 = this._txtPinY;
        return d2 == null ? Double.valueOf(getHeight().doubleValue() * 0.5d) : d2;
    }

    public Double getTxtLocPinX() {
        XDGFShape xDGFShape;
        Double d;
        Double d2 = this._txtLocPinX;
        if (d2 != null || (xDGFShape = this._masterShape) == null || (d = xDGFShape._txtLocPinX) == null) {
            return d2 == null ? Double.valueOf(getTxtWidth().doubleValue() * 0.5d) : d2;
        }
        return d;
    }

    public Double getTxtLocPinY() {
        XDGFShape xDGFShape;
        Double d;
        Double d2 = this._txtLocPinY;
        if (d2 != null || (xDGFShape = this._masterShape) == null || (d = xDGFShape._txtLocPinY) == null) {
            return d2 == null ? Double.valueOf(getTxtHeight().doubleValue() * 0.5d) : d2;
        }
        return d;
    }

    public Double getTxtAngle() {
        XDGFShape xDGFShape;
        Double d = this._txtAngle;
        return (d != null || (xDGFShape = this._masterShape) == null) ? d : xDGFShape.getTxtAngle();
    }

    public Double getTxtWidth() {
        XDGFShape xDGFShape;
        Double d;
        Double d2 = this._txtWidth;
        if (d2 != null || (xDGFShape = this._masterShape) == null || (d = xDGFShape._txtWidth) == null) {
            return d2 == null ? getWidth() : d2;
        }
        return d;
    }

    public Double getTxtHeight() {
        XDGFShape xDGFShape;
        Double d;
        Double d2 = this._txtHeight;
        if (d2 != null || (xDGFShape = this._masterShape) == null || (d = xDGFShape._txtHeight) == null) {
            return d2 == null ? getHeight() : d2;
        }
        return d;
    }

    @Override // org.apache.poi.xdgf.usermodel.XDGFSheet
    public Integer getLineCap() {
        Integer lineCap = super.getLineCap();
        if (lineCap != null) {
            return lineCap;
        }
        XDGFShape xDGFShape = this._masterShape;
        if (xDGFShape != null) {
            return xDGFShape.getLineCap();
        }
        return this._document.getDefaultLineStyle().getLineCap();
    }

    @Override // org.apache.poi.xdgf.usermodel.XDGFSheet
    public Color getLineColor() {
        Color lineColor = super.getLineColor();
        if (lineColor != null) {
            return lineColor;
        }
        XDGFShape xDGFShape = this._masterShape;
        if (xDGFShape != null) {
            return xDGFShape.getLineColor();
        }
        return this._document.getDefaultLineStyle().getLineColor();
    }

    @Override // org.apache.poi.xdgf.usermodel.XDGFSheet
    public Integer getLinePattern() {
        Integer linePattern = super.getLinePattern();
        if (linePattern != null) {
            return linePattern;
        }
        XDGFShape xDGFShape = this._masterShape;
        if (xDGFShape != null) {
            return xDGFShape.getLinePattern();
        }
        return this._document.getDefaultLineStyle().getLinePattern();
    }

    @Override // org.apache.poi.xdgf.usermodel.XDGFSheet
    public Double getLineWeight() {
        Double lineWeight = super.getLineWeight();
        if (lineWeight != null) {
            return lineWeight;
        }
        XDGFShape xDGFShape = this._masterShape;
        if (xDGFShape != null) {
            return xDGFShape.getLineWeight();
        }
        return this._document.getDefaultLineStyle().getLineWeight();
    }

    @Override // org.apache.poi.xdgf.usermodel.XDGFSheet
    public Color getFontColor() {
        Color fontColor = super.getFontColor();
        if (fontColor != null) {
            return fontColor;
        }
        XDGFShape xDGFShape = this._masterShape;
        if (xDGFShape != null) {
            return xDGFShape.getFontColor();
        }
        return this._document.getDefaultTextStyle().getFontColor();
    }

    @Override // org.apache.poi.xdgf.usermodel.XDGFSheet
    public Double getFontSize() {
        Double fontSize = super.getFontSize();
        if (fontSize != null) {
            return fontSize;
        }
        XDGFShape xDGFShape = this._masterShape;
        if (xDGFShape != null) {
            return xDGFShape.getFontSize();
        }
        return this._document.getDefaultTextStyle().getFontSize();
    }

    public Stroke getStroke() {
        int i;
        float[] fArr;
        float fFloatValue = getLineWeight().floatValue();
        int iIntValue = getLineCap().intValue();
        if (iIntValue == 0) {
            i = 1;
        } else if (iIntValue == 1) {
            i = 2;
        } else {
            if (iIntValue != 2) {
                throw new POIXMLException("Invalid line cap specified");
            }
            i = 0;
        }
        int iIntValue2 = getLinePattern().intValue();
        if (iIntValue2 == 254) {
            throw new POIXMLException("Unsupported line pattern value");
        }
        switch (iIntValue2) {
            case 0:
            case 1:
                fArr = null;
                break;
            case 2:
                fArr = new float[]{5.0f, 3.0f};
                break;
            case 3:
                fArr = new float[]{1.0f, 4.0f};
                break;
            case 4:
                fArr = new float[]{6.0f, 3.0f, 1.0f, 3.0f};
                break;
            case 5:
                fArr = new float[]{6.0f, 3.0f, 1.0f, 3.0f, 1.0f, 3.0f};
                break;
            case 6:
                fArr = new float[]{1.0f, 3.0f, 6.0f, 3.0f, 6.0f, 3.0f};
                break;
            case 7:
                fArr = new float[]{15.0f, 3.0f, 6.0f, 3.0f};
                break;
            case 8:
                fArr = new float[]{6.0f, 3.0f, 6.0f, 3.0f};
                break;
            case 9:
                fArr = new float[]{3.0f, 2.0f};
                break;
            case 10:
                fArr = new float[]{1.0f, 2.0f};
                break;
            case 11:
                fArr = new float[]{3.0f, 2.0f, 1.0f, 2.0f};
                break;
            case 12:
                fArr = new float[]{3.0f, 2.0f, 1.0f, 2.0f, 1.0f};
                break;
            case 13:
                fArr = new float[]{1.0f, 2.0f, 3.0f, 2.0f, 3.0f, 2.0f};
                break;
            case 14:
                fArr = new float[]{3.0f, 2.0f, 7.0f, 2.0f};
                break;
            case 15:
                fArr = new float[]{7.0f, 2.0f, 3.0f, 2.0f, 3.0f, 2.0f};
                break;
            case 16:
                fArr = new float[]{12.0f, 6.0f};
                break;
            case 17:
                fArr = new float[]{1.0f, 6.0f};
                break;
            case 18:
                fArr = new float[]{1.0f, 6.0f, 12.0f, 6.0f};
                break;
            case 19:
                fArr = new float[]{1.0f, 6.0f, 1.0f, 6.0f, 12.0f, 6.0f};
                break;
            case 20:
                fArr = new float[]{1.0f, 6.0f, 12.0f, 6.0f, 12.0f, 6.0f};
                break;
            case 21:
                fArr = new float[]{30.0f, 6.0f, 12.0f, 6.0f};
                break;
            case 22:
                fArr = new float[]{30.0f, 6.0f, 12.0f, 6.0f, 12.0f, 6.0f};
                break;
            case 23:
                fArr = new float[]{1.0f};
                break;
            default:
                throw new POIXMLException("Invalid line pattern value");
        }
        float[] fArr2 = fArr;
        if (fArr2 != null) {
            for (int i2 = 0; i2 < fArr2.length; i2++) {
                fArr2[i2] = fArr2[i2] * fFloatValue;
            }
        }
        return new BasicStroke(fFloatValue, i, 0, 10.0f, fArr2, 0.0f);
    }

    public Iterable<GeometrySection> getGeometrySections() {
        SortedMap<Long, GeometrySection> sortedMap = this._geometry;
        XDGFShape xDGFShape = this._masterShape;
        return new CombinedIterable(sortedMap, xDGFShape != null ? xDGFShape._geometry : null);
    }

    public Rectangle2D.Double getBounds() {
        return new Rectangle2D.Double(0.0d, 0.0d, getWidth().doubleValue(), getHeight().doubleValue());
    }

    public Path2D.Double getBoundsAsPath() {
        Double width = getWidth();
        Double height = getHeight();
        Path2D.Double r2 = new Path2D.Double();
        r2.moveTo(0.0d, 0.0d);
        r2.lineTo(width.doubleValue(), 0.0d);
        r2.lineTo(width.doubleValue(), height.doubleValue());
        r2.lineTo(0.0d, height.doubleValue());
        r2.lineTo(0.0d, 0.0d);
        return r2;
    }

    public Path2D.Double getPath() {
        for (GeometrySection geometrySection : getGeometrySections()) {
            if (!geometrySection.getNoShow().booleanValue()) {
                return geometrySection.getPath(this);
            }
        }
        return null;
    }

    public boolean hasGeometry() {
        Iterator<GeometrySection> it = getGeometrySections().iterator();
        while (it.hasNext()) {
            if (!it.next().getNoShow().booleanValue()) {
                return true;
            }
        }
        return false;
    }

    protected AffineTransform getParentTransform() {
        AffineTransform affineTransform = new AffineTransform();
        Double locPinX = getLocPinX();
        Double locPinY = getLocPinY();
        Boolean flipX = getFlipX();
        Boolean flipY = getFlipY();
        Double angle = getAngle();
        affineTransform.translate(-locPinX.doubleValue(), -locPinY.doubleValue());
        affineTransform.translate(getPinX().doubleValue(), getPinY().doubleValue());
        if (angle != null && Math.abs(angle.doubleValue()) > 0.001d) {
            affineTransform.rotate(angle.doubleValue(), locPinX.doubleValue(), locPinY.doubleValue());
        }
        if (flipX != null && flipX.booleanValue()) {
            affineTransform.scale(-1.0d, 1.0d);
            affineTransform.translate(-getWidth().doubleValue(), 0.0d);
        }
        if (flipY != null && flipY.booleanValue()) {
            affineTransform.scale(1.0d, -1.0d);
            affineTransform.translate(0.0d, -getHeight().doubleValue());
        }
        return affineTransform;
    }

    public void visitShapes(ShapeVisitor shapeVisitor, AffineTransform affineTransform, int i) {
        AffineTransform affineTransform2 = (AffineTransform) affineTransform.clone();
        affineTransform2.concatenate(getParentTransform());
        try {
            if (shapeVisitor.accept(this)) {
                shapeVisitor.visit(this, affineTransform2, i);
            }
            List<XDGFShape> list = this._shapes;
            if (list != null) {
                Iterator<XDGFShape> it = list.iterator();
                while (it.hasNext()) {
                    it.next().visitShapes(shapeVisitor, affineTransform2, i + 1);
                }
            }
        } catch (POIXMLException e) {
            throw XDGFException.wrap(toString(), e);
        } catch (StopVisitingThisBranch unused) {
        }
    }

    public void visitShapes(ShapeVisitor shapeVisitor, int i) {
        try {
            if (shapeVisitor.accept(this)) {
                shapeVisitor.visit(this, null, i);
            }
            List<XDGFShape> list = this._shapes;
            if (list != null) {
                Iterator<XDGFShape> it = list.iterator();
                while (it.hasNext()) {
                    it.next().visitShapes(shapeVisitor, i + 1);
                }
            }
        } catch (POIXMLException e) {
            throw XDGFException.wrap(toString(), e);
        } catch (StopVisitingThisBranch unused) {
        }
    }
}
