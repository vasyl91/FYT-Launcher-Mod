package org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGraphicFrameProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTEffectExtent;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTPosH;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTPosV;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTWrapNone;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTWrapSquare;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTWrapThrough;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTWrapTight;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTWrapTopBottom;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.STWrapDistance;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTAnchorImpl extends XmlComplexContentImpl implements CTAnchor {
    private static final QName SIMPLEPOS$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "simplePos");
    private static final QName POSITIONH$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "positionH");
    private static final QName POSITIONV$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "positionV");
    private static final QName EXTENT$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "extent");
    private static final QName EFFECTEXTENT$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "effectExtent");
    private static final QName WRAPNONE$10 = new QName("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "wrapNone");
    private static final QName WRAPSQUARE$12 = new QName("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "wrapSquare");
    private static final QName WRAPTIGHT$14 = new QName("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "wrapTight");
    private static final QName WRAPTHROUGH$16 = new QName("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "wrapThrough");
    private static final QName WRAPTOPANDBOTTOM$18 = new QName("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "wrapTopAndBottom");
    private static final QName DOCPR$20 = new QName("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "docPr");
    private static final QName CNVGRAPHICFRAMEPR$22 = new QName("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "cNvGraphicFramePr");
    private static final QName GRAPHIC$24 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "graphic");
    private static final QName DISTT$26 = new QName("", "distT");
    private static final QName DISTB$28 = new QName("", "distB");
    private static final QName DISTL$30 = new QName("", "distL");
    private static final QName DISTR$32 = new QName("", "distR");
    private static final QName SIMPLEPOS2$34 = new QName("", "simplePos");
    private static final QName RELATIVEHEIGHT$36 = new QName("", "relativeHeight");
    private static final QName BEHINDDOC$38 = new QName("", "behindDoc");
    private static final QName LOCKED$40 = new QName("", "locked");
    private static final QName LAYOUTINCELL$42 = new QName("", "layoutInCell");
    private static final QName HIDDEN$44 = new QName("", "hidden");
    private static final QName ALLOWOVERLAP$46 = new QName("", "allowOverlap");

    public CTAnchorImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public CTNonVisualGraphicFrameProperties addNewCNvGraphicFramePr() {
        CTNonVisualGraphicFrameProperties cTNonVisualGraphicFrameProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTNonVisualGraphicFrameProperties = (CTNonVisualGraphicFrameProperties) get_store().add_element_user(CNVGRAPHICFRAMEPR$22);
        }
        return cTNonVisualGraphicFrameProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public CTNonVisualDrawingProps addNewDocPr() {
        CTNonVisualDrawingProps cTNonVisualDrawingProps;
        synchronized (monitor()) {
            check_orphaned();
            cTNonVisualDrawingProps = (CTNonVisualDrawingProps) get_store().add_element_user(DOCPR$20);
        }
        return cTNonVisualDrawingProps;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public CTEffectExtent addNewEffectExtent() {
        CTEffectExtent cTEffectExtentAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEffectExtentAdd_element_user = get_store().add_element_user(EFFECTEXTENT$8);
        }
        return cTEffectExtentAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public CTPositiveSize2D addNewExtent() {
        CTPositiveSize2D cTPositiveSize2D;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveSize2D = (CTPositiveSize2D) get_store().add_element_user(EXTENT$6);
        }
        return cTPositiveSize2D;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public CTGraphicalObject addNewGraphic() {
        CTGraphicalObject cTGraphicalObject;
        synchronized (monitor()) {
            check_orphaned();
            cTGraphicalObject = (CTGraphicalObject) get_store().add_element_user(GRAPHIC$24);
        }
        return cTGraphicalObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public CTPosH addNewPositionH() {
        CTPosH cTPosHAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPosHAdd_element_user = get_store().add_element_user(POSITIONH$2);
        }
        return cTPosHAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public CTPosV addNewPositionV() {
        CTPosV cTPosVAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPosVAdd_element_user = get_store().add_element_user(POSITIONV$4);
        }
        return cTPosVAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public CTPoint2D addNewSimplePos() {
        CTPoint2D cTPoint2D;
        synchronized (monitor()) {
            check_orphaned();
            cTPoint2D = (CTPoint2D) get_store().add_element_user(SIMPLEPOS$0);
        }
        return cTPoint2D;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public CTWrapNone addNewWrapNone() {
        CTWrapNone cTWrapNoneAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTWrapNoneAdd_element_user = get_store().add_element_user(WRAPNONE$10);
        }
        return cTWrapNoneAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public CTWrapSquare addNewWrapSquare() {
        CTWrapSquare cTWrapSquareAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTWrapSquareAdd_element_user = get_store().add_element_user(WRAPSQUARE$12);
        }
        return cTWrapSquareAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public CTWrapThrough addNewWrapThrough() {
        CTWrapThrough cTWrapThroughAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTWrapThroughAdd_element_user = get_store().add_element_user(WRAPTHROUGH$16);
        }
        return cTWrapThroughAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public CTWrapTight addNewWrapTight() {
        CTWrapTight cTWrapTightAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTWrapTightAdd_element_user = get_store().add_element_user(WRAPTIGHT$14);
        }
        return cTWrapTightAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public CTWrapTopBottom addNewWrapTopAndBottom() {
        CTWrapTopBottom cTWrapTopBottomAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTWrapTopBottomAdd_element_user = get_store().add_element_user(WRAPTOPANDBOTTOM$18);
        }
        return cTWrapTopBottomAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public boolean getAllowOverlap() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ALLOWOVERLAP$46);
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public boolean getBehindDoc() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BEHINDDOC$38);
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public CTNonVisualGraphicFrameProperties getCNvGraphicFramePr() {
        synchronized (monitor()) {
            check_orphaned();
            CTNonVisualGraphicFrameProperties cTNonVisualGraphicFrameProperties = (CTNonVisualGraphicFrameProperties) get_store().find_element_user(CNVGRAPHICFRAMEPR$22, 0);
            if (cTNonVisualGraphicFrameProperties == null) {
                return null;
            }
            return cTNonVisualGraphicFrameProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public long getDistB() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DISTB$28);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public long getDistL() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DISTL$30);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public long getDistR() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DISTR$32);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public long getDistT() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DISTT$26);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public CTNonVisualDrawingProps getDocPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTNonVisualDrawingProps cTNonVisualDrawingProps = (CTNonVisualDrawingProps) get_store().find_element_user(DOCPR$20, 0);
            if (cTNonVisualDrawingProps == null) {
                return null;
            }
            return cTNonVisualDrawingProps;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public CTEffectExtent getEffectExtent() {
        synchronized (monitor()) {
            check_orphaned();
            CTEffectExtent cTEffectExtentFind_element_user = get_store().find_element_user(EFFECTEXTENT$8, 0);
            if (cTEffectExtentFind_element_user == null) {
                return null;
            }
            return cTEffectExtentFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public CTPositiveSize2D getExtent() {
        synchronized (monitor()) {
            check_orphaned();
            CTPositiveSize2D cTPositiveSize2D = (CTPositiveSize2D) get_store().find_element_user(EXTENT$6, 0);
            if (cTPositiveSize2D == null) {
                return null;
            }
            return cTPositiveSize2D;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public CTGraphicalObject getGraphic() {
        synchronized (monitor()) {
            check_orphaned();
            CTGraphicalObject cTGraphicalObject = (CTGraphicalObject) get_store().find_element_user(GRAPHIC$24, 0);
            if (cTGraphicalObject == null) {
                return null;
            }
            return cTGraphicalObject;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public boolean getHidden() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HIDDEN$44);
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public boolean getLayoutInCell() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(LAYOUTINCELL$42);
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public boolean getLocked() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(LOCKED$40);
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public CTPosH getPositionH() {
        synchronized (monitor()) {
            check_orphaned();
            CTPosH cTPosHFind_element_user = get_store().find_element_user(POSITIONH$2, 0);
            if (cTPosHFind_element_user == null) {
                return null;
            }
            return cTPosHFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public CTPosV getPositionV() {
        synchronized (monitor()) {
            check_orphaned();
            CTPosV cTPosVFind_element_user = get_store().find_element_user(POSITIONV$4, 0);
            if (cTPosVFind_element_user == null) {
                return null;
            }
            return cTPosVFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public long getRelativeHeight() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(RELATIVEHEIGHT$36);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public CTPoint2D getSimplePos() {
        synchronized (monitor()) {
            check_orphaned();
            CTPoint2D cTPoint2D = (CTPoint2D) get_store().find_element_user(SIMPLEPOS$0, 0);
            if (cTPoint2D == null) {
                return null;
            }
            return cTPoint2D;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public boolean getSimplePos2() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SIMPLEPOS2$34);
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public CTWrapNone getWrapNone() {
        synchronized (monitor()) {
            check_orphaned();
            CTWrapNone cTWrapNoneFind_element_user = get_store().find_element_user(WRAPNONE$10, 0);
            if (cTWrapNoneFind_element_user == null) {
                return null;
            }
            return cTWrapNoneFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public CTWrapSquare getWrapSquare() {
        synchronized (monitor()) {
            check_orphaned();
            CTWrapSquare cTWrapSquareFind_element_user = get_store().find_element_user(WRAPSQUARE$12, 0);
            if (cTWrapSquareFind_element_user == null) {
                return null;
            }
            return cTWrapSquareFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public CTWrapThrough getWrapThrough() {
        synchronized (monitor()) {
            check_orphaned();
            CTWrapThrough cTWrapThroughFind_element_user = get_store().find_element_user(WRAPTHROUGH$16, 0);
            if (cTWrapThroughFind_element_user == null) {
                return null;
            }
            return cTWrapThroughFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public CTWrapTight getWrapTight() {
        synchronized (monitor()) {
            check_orphaned();
            CTWrapTight cTWrapTightFind_element_user = get_store().find_element_user(WRAPTIGHT$14, 0);
            if (cTWrapTightFind_element_user == null) {
                return null;
            }
            return cTWrapTightFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public CTWrapTopBottom getWrapTopAndBottom() {
        synchronized (monitor()) {
            check_orphaned();
            CTWrapTopBottom cTWrapTopBottomFind_element_user = get_store().find_element_user(WRAPTOPANDBOTTOM$18, 0);
            if (cTWrapTopBottomFind_element_user == null) {
                return null;
            }
            return cTWrapTopBottomFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public boolean isSetCNvGraphicFramePr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CNVGRAPHICFRAMEPR$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public boolean isSetDistB() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DISTB$28) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public boolean isSetDistL() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DISTL$30) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public boolean isSetDistR() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DISTR$32) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public boolean isSetDistT() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DISTT$26) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public boolean isSetEffectExtent() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EFFECTEXTENT$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public boolean isSetHidden() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HIDDEN$44) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public boolean isSetSimplePos2() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SIMPLEPOS2$34) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public boolean isSetWrapNone() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(WRAPNONE$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public boolean isSetWrapSquare() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(WRAPSQUARE$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public boolean isSetWrapThrough() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(WRAPTHROUGH$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public boolean isSetWrapTight() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(WRAPTIGHT$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public boolean isSetWrapTopAndBottom() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(WRAPTOPANDBOTTOM$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void setAllowOverlap(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWOVERLAP$46;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void setBehindDoc(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BEHINDDOC$38;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void setCNvGraphicFramePr(CTNonVisualGraphicFrameProperties cTNonVisualGraphicFrameProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CNVGRAPHICFRAMEPR$22;
            CTNonVisualGraphicFrameProperties cTNonVisualGraphicFrameProperties2 = (CTNonVisualGraphicFrameProperties) typeStore.find_element_user(qName, 0);
            if (cTNonVisualGraphicFrameProperties2 == null) {
                cTNonVisualGraphicFrameProperties2 = (CTNonVisualGraphicFrameProperties) get_store().add_element_user(qName);
            }
            cTNonVisualGraphicFrameProperties2.set(cTNonVisualGraphicFrameProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void setDistB(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DISTB$28;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void setDistL(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DISTL$30;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void setDistR(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DISTR$32;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void setDistT(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DISTT$26;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void setDocPr(CTNonVisualDrawingProps cTNonVisualDrawingProps) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DOCPR$20;
            CTNonVisualDrawingProps cTNonVisualDrawingProps2 = (CTNonVisualDrawingProps) typeStore.find_element_user(qName, 0);
            if (cTNonVisualDrawingProps2 == null) {
                cTNonVisualDrawingProps2 = (CTNonVisualDrawingProps) get_store().add_element_user(qName);
            }
            cTNonVisualDrawingProps2.set(cTNonVisualDrawingProps);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void setEffectExtent(CTEffectExtent cTEffectExtent) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EFFECTEXTENT$8;
            CTEffectExtent cTEffectExtentFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTEffectExtentFind_element_user == null) {
                cTEffectExtentFind_element_user = (CTEffectExtent) get_store().add_element_user(qName);
            }
            cTEffectExtentFind_element_user.set(cTEffectExtent);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void setExtent(CTPositiveSize2D cTPositiveSize2D) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTENT$6;
            CTPositiveSize2D cTPositiveSize2D2 = (CTPositiveSize2D) typeStore.find_element_user(qName, 0);
            if (cTPositiveSize2D2 == null) {
                cTPositiveSize2D2 = (CTPositiveSize2D) get_store().add_element_user(qName);
            }
            cTPositiveSize2D2.set(cTPositiveSize2D);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void setGraphic(CTGraphicalObject cTGraphicalObject) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GRAPHIC$24;
            CTGraphicalObject cTGraphicalObject2 = (CTGraphicalObject) typeStore.find_element_user(qName, 0);
            if (cTGraphicalObject2 == null) {
                cTGraphicalObject2 = (CTGraphicalObject) get_store().add_element_user(qName);
            }
            cTGraphicalObject2.set(cTGraphicalObject);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void setHidden(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HIDDEN$44;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void setLayoutInCell(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LAYOUTINCELL$42;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void setLocked(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LOCKED$40;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void setPositionH(CTPosH cTPosH) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = POSITIONH$2;
            CTPosH cTPosHFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTPosHFind_element_user == null) {
                cTPosHFind_element_user = (CTPosH) get_store().add_element_user(qName);
            }
            cTPosHFind_element_user.set(cTPosH);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void setPositionV(CTPosV cTPosV) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = POSITIONV$4;
            CTPosV cTPosVFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTPosVFind_element_user == null) {
                cTPosVFind_element_user = (CTPosV) get_store().add_element_user(qName);
            }
            cTPosVFind_element_user.set(cTPosV);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void setRelativeHeight(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RELATIVEHEIGHT$36;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void setSimplePos(CTPoint2D cTPoint2D) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIMPLEPOS$0;
            CTPoint2D cTPoint2D2 = (CTPoint2D) typeStore.find_element_user(qName, 0);
            if (cTPoint2D2 == null) {
                cTPoint2D2 = (CTPoint2D) get_store().add_element_user(qName);
            }
            cTPoint2D2.set(cTPoint2D);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void setSimplePos2(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIMPLEPOS2$34;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void setWrapNone(CTWrapNone cTWrapNone) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WRAPNONE$10;
            CTWrapNone cTWrapNoneFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTWrapNoneFind_element_user == null) {
                cTWrapNoneFind_element_user = (CTWrapNone) get_store().add_element_user(qName);
            }
            cTWrapNoneFind_element_user.set(cTWrapNone);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void setWrapSquare(CTWrapSquare cTWrapSquare) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WRAPSQUARE$12;
            CTWrapSquare cTWrapSquareFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTWrapSquareFind_element_user == null) {
                cTWrapSquareFind_element_user = (CTWrapSquare) get_store().add_element_user(qName);
            }
            cTWrapSquareFind_element_user.set(cTWrapSquare);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void setWrapThrough(CTWrapThrough cTWrapThrough) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WRAPTHROUGH$16;
            CTWrapThrough cTWrapThroughFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTWrapThroughFind_element_user == null) {
                cTWrapThroughFind_element_user = (CTWrapThrough) get_store().add_element_user(qName);
            }
            cTWrapThroughFind_element_user.set(cTWrapThrough);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void setWrapTight(CTWrapTight cTWrapTight) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WRAPTIGHT$14;
            CTWrapTight cTWrapTightFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTWrapTightFind_element_user == null) {
                cTWrapTightFind_element_user = (CTWrapTight) get_store().add_element_user(qName);
            }
            cTWrapTightFind_element_user.set(cTWrapTight);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void setWrapTopAndBottom(CTWrapTopBottom cTWrapTopBottom) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WRAPTOPANDBOTTOM$18;
            CTWrapTopBottom cTWrapTopBottomFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTWrapTopBottomFind_element_user == null) {
                cTWrapTopBottomFind_element_user = (CTWrapTopBottom) get_store().add_element_user(qName);
            }
            cTWrapTopBottomFind_element_user.set(cTWrapTopBottom);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void unsetCNvGraphicFramePr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CNVGRAPHICFRAMEPR$22, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void unsetDistB() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DISTB$28);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void unsetDistL() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DISTL$30);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void unsetDistR() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DISTR$32);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void unsetDistT() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DISTT$26);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void unsetEffectExtent() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EFFECTEXTENT$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void unsetHidden() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HIDDEN$44);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void unsetSimplePos2() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SIMPLEPOS2$34);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void unsetWrapNone() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WRAPNONE$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void unsetWrapSquare() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WRAPSQUARE$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void unsetWrapThrough() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WRAPTHROUGH$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void unsetWrapTight() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WRAPTIGHT$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void unsetWrapTopAndBottom() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WRAPTOPANDBOTTOM$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public XmlBoolean xgetAllowOverlap() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(ALLOWOVERLAP$46);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public XmlBoolean xgetBehindDoc() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(BEHINDDOC$38);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public STWrapDistance xgetDistB() {
        STWrapDistance sTWrapDistance;
        synchronized (monitor()) {
            check_orphaned();
            sTWrapDistance = (STWrapDistance) get_store().find_attribute_user(DISTB$28);
        }
        return sTWrapDistance;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public STWrapDistance xgetDistL() {
        STWrapDistance sTWrapDistance;
        synchronized (monitor()) {
            check_orphaned();
            sTWrapDistance = (STWrapDistance) get_store().find_attribute_user(DISTL$30);
        }
        return sTWrapDistance;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public STWrapDistance xgetDistR() {
        STWrapDistance sTWrapDistance;
        synchronized (monitor()) {
            check_orphaned();
            sTWrapDistance = (STWrapDistance) get_store().find_attribute_user(DISTR$32);
        }
        return sTWrapDistance;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public STWrapDistance xgetDistT() {
        STWrapDistance sTWrapDistance;
        synchronized (monitor()) {
            check_orphaned();
            sTWrapDistance = (STWrapDistance) get_store().find_attribute_user(DISTT$26);
        }
        return sTWrapDistance;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public XmlBoolean xgetHidden() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(HIDDEN$44);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public XmlBoolean xgetLayoutInCell() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(LAYOUTINCELL$42);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public XmlBoolean xgetLocked() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(LOCKED$40);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public XmlUnsignedInt xgetRelativeHeight() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(RELATIVEHEIGHT$36);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public XmlBoolean xgetSimplePos2() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(SIMPLEPOS2$34);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void xsetAllowOverlap(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALLOWOVERLAP$46;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void xsetBehindDoc(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BEHINDDOC$38;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void xsetDistB(STWrapDistance sTWrapDistance) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DISTB$28;
            STWrapDistance sTWrapDistance2 = (STWrapDistance) typeStore.find_attribute_user(qName);
            if (sTWrapDistance2 == null) {
                sTWrapDistance2 = (STWrapDistance) get_store().add_attribute_user(qName);
            }
            sTWrapDistance2.set(sTWrapDistance);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void xsetDistL(STWrapDistance sTWrapDistance) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DISTL$30;
            STWrapDistance sTWrapDistance2 = (STWrapDistance) typeStore.find_attribute_user(qName);
            if (sTWrapDistance2 == null) {
                sTWrapDistance2 = (STWrapDistance) get_store().add_attribute_user(qName);
            }
            sTWrapDistance2.set(sTWrapDistance);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void xsetDistR(STWrapDistance sTWrapDistance) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DISTR$32;
            STWrapDistance sTWrapDistance2 = (STWrapDistance) typeStore.find_attribute_user(qName);
            if (sTWrapDistance2 == null) {
                sTWrapDistance2 = (STWrapDistance) get_store().add_attribute_user(qName);
            }
            sTWrapDistance2.set(sTWrapDistance);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void xsetDistT(STWrapDistance sTWrapDistance) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DISTT$26;
            STWrapDistance sTWrapDistance2 = (STWrapDistance) typeStore.find_attribute_user(qName);
            if (sTWrapDistance2 == null) {
                sTWrapDistance2 = (STWrapDistance) get_store().add_attribute_user(qName);
            }
            sTWrapDistance2.set(sTWrapDistance);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void xsetHidden(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HIDDEN$44;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void xsetLayoutInCell(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LAYOUTINCELL$42;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void xsetLocked(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LOCKED$40;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void xsetRelativeHeight(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RELATIVEHEIGHT$36;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor
    public void xsetSimplePos2(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIMPLEPOS2$34;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }
}
