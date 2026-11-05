package org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGraphicFrameProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTEffectExtent;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.STWrapDistance;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTInlineImpl extends XmlComplexContentImpl implements CTInline {
    private static final QName EXTENT$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "extent");
    private static final QName EFFECTEXTENT$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "effectExtent");
    private static final QName DOCPR$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "docPr");
    private static final QName CNVGRAPHICFRAMEPR$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "cNvGraphicFramePr");
    private static final QName GRAPHIC$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "graphic");
    private static final QName DISTT$10 = new QName("", "distT");
    private static final QName DISTB$12 = new QName("", "distB");
    private static final QName DISTL$14 = new QName("", "distL");
    private static final QName DISTR$16 = new QName("", "distR");

    public CTInlineImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public CTNonVisualGraphicFrameProperties addNewCNvGraphicFramePr() {
        CTNonVisualGraphicFrameProperties cTNonVisualGraphicFrameProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTNonVisualGraphicFrameProperties = (CTNonVisualGraphicFrameProperties) get_store().add_element_user(CNVGRAPHICFRAMEPR$6);
        }
        return cTNonVisualGraphicFrameProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public CTNonVisualDrawingProps addNewDocPr() {
        CTNonVisualDrawingProps cTNonVisualDrawingProps;
        synchronized (monitor()) {
            check_orphaned();
            cTNonVisualDrawingProps = (CTNonVisualDrawingProps) get_store().add_element_user(DOCPR$4);
        }
        return cTNonVisualDrawingProps;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public CTEffectExtent addNewEffectExtent() {
        CTEffectExtent cTEffectExtentAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEffectExtentAdd_element_user = get_store().add_element_user(EFFECTEXTENT$2);
        }
        return cTEffectExtentAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public CTPositiveSize2D addNewExtent() {
        CTPositiveSize2D cTPositiveSize2D;
        synchronized (monitor()) {
            check_orphaned();
            cTPositiveSize2D = (CTPositiveSize2D) get_store().add_element_user(EXTENT$0);
        }
        return cTPositiveSize2D;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public CTGraphicalObject addNewGraphic() {
        CTGraphicalObject cTGraphicalObject;
        synchronized (monitor()) {
            check_orphaned();
            cTGraphicalObject = (CTGraphicalObject) get_store().add_element_user(GRAPHIC$8);
        }
        return cTGraphicalObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public CTNonVisualGraphicFrameProperties getCNvGraphicFramePr() {
        synchronized (monitor()) {
            check_orphaned();
            CTNonVisualGraphicFrameProperties cTNonVisualGraphicFrameProperties = (CTNonVisualGraphicFrameProperties) get_store().find_element_user(CNVGRAPHICFRAMEPR$6, 0);
            if (cTNonVisualGraphicFrameProperties == null) {
                return null;
            }
            return cTNonVisualGraphicFrameProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public long getDistB() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DISTB$12);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public long getDistL() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DISTL$14);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public long getDistR() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DISTR$16);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public long getDistT() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DISTT$10);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public CTNonVisualDrawingProps getDocPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTNonVisualDrawingProps cTNonVisualDrawingProps = (CTNonVisualDrawingProps) get_store().find_element_user(DOCPR$4, 0);
            if (cTNonVisualDrawingProps == null) {
                return null;
            }
            return cTNonVisualDrawingProps;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public CTEffectExtent getEffectExtent() {
        synchronized (monitor()) {
            check_orphaned();
            CTEffectExtent cTEffectExtentFind_element_user = get_store().find_element_user(EFFECTEXTENT$2, 0);
            if (cTEffectExtentFind_element_user == null) {
                return null;
            }
            return cTEffectExtentFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public CTPositiveSize2D getExtent() {
        synchronized (monitor()) {
            check_orphaned();
            CTPositiveSize2D cTPositiveSize2D = (CTPositiveSize2D) get_store().find_element_user(EXTENT$0, 0);
            if (cTPositiveSize2D == null) {
                return null;
            }
            return cTPositiveSize2D;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public CTGraphicalObject getGraphic() {
        synchronized (monitor()) {
            check_orphaned();
            CTGraphicalObject cTGraphicalObject = (CTGraphicalObject) get_store().find_element_user(GRAPHIC$8, 0);
            if (cTGraphicalObject == null) {
                return null;
            }
            return cTGraphicalObject;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public boolean isSetCNvGraphicFramePr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CNVGRAPHICFRAMEPR$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public boolean isSetDistB() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DISTB$12) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public boolean isSetDistL() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DISTL$14) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public boolean isSetDistR() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DISTR$16) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public boolean isSetDistT() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DISTT$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public boolean isSetEffectExtent() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EFFECTEXTENT$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public void setCNvGraphicFramePr(CTNonVisualGraphicFrameProperties cTNonVisualGraphicFrameProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CNVGRAPHICFRAMEPR$6;
            CTNonVisualGraphicFrameProperties cTNonVisualGraphicFrameProperties2 = (CTNonVisualGraphicFrameProperties) typeStore.find_element_user(qName, 0);
            if (cTNonVisualGraphicFrameProperties2 == null) {
                cTNonVisualGraphicFrameProperties2 = (CTNonVisualGraphicFrameProperties) get_store().add_element_user(qName);
            }
            cTNonVisualGraphicFrameProperties2.set(cTNonVisualGraphicFrameProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public void setDistB(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DISTB$12;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public void setDistL(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DISTL$14;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public void setDistR(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DISTR$16;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public void setDistT(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DISTT$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public void setDocPr(CTNonVisualDrawingProps cTNonVisualDrawingProps) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DOCPR$4;
            CTNonVisualDrawingProps cTNonVisualDrawingProps2 = (CTNonVisualDrawingProps) typeStore.find_element_user(qName, 0);
            if (cTNonVisualDrawingProps2 == null) {
                cTNonVisualDrawingProps2 = (CTNonVisualDrawingProps) get_store().add_element_user(qName);
            }
            cTNonVisualDrawingProps2.set(cTNonVisualDrawingProps);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public void setEffectExtent(CTEffectExtent cTEffectExtent) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EFFECTEXTENT$2;
            CTEffectExtent cTEffectExtentFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTEffectExtentFind_element_user == null) {
                cTEffectExtentFind_element_user = (CTEffectExtent) get_store().add_element_user(qName);
            }
            cTEffectExtentFind_element_user.set(cTEffectExtent);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public void setExtent(CTPositiveSize2D cTPositiveSize2D) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTENT$0;
            CTPositiveSize2D cTPositiveSize2D2 = (CTPositiveSize2D) typeStore.find_element_user(qName, 0);
            if (cTPositiveSize2D2 == null) {
                cTPositiveSize2D2 = (CTPositiveSize2D) get_store().add_element_user(qName);
            }
            cTPositiveSize2D2.set(cTPositiveSize2D);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public void setGraphic(CTGraphicalObject cTGraphicalObject) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GRAPHIC$8;
            CTGraphicalObject cTGraphicalObject2 = (CTGraphicalObject) typeStore.find_element_user(qName, 0);
            if (cTGraphicalObject2 == null) {
                cTGraphicalObject2 = (CTGraphicalObject) get_store().add_element_user(qName);
            }
            cTGraphicalObject2.set(cTGraphicalObject);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public void unsetCNvGraphicFramePr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CNVGRAPHICFRAMEPR$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public void unsetDistB() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DISTB$12);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public void unsetDistL() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DISTL$14);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public void unsetDistR() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DISTR$16);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public void unsetDistT() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DISTT$10);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public void unsetEffectExtent() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EFFECTEXTENT$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public STWrapDistance xgetDistB() {
        STWrapDistance sTWrapDistance;
        synchronized (monitor()) {
            check_orphaned();
            sTWrapDistance = (STWrapDistance) get_store().find_attribute_user(DISTB$12);
        }
        return sTWrapDistance;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public STWrapDistance xgetDistL() {
        STWrapDistance sTWrapDistance;
        synchronized (monitor()) {
            check_orphaned();
            sTWrapDistance = (STWrapDistance) get_store().find_attribute_user(DISTL$14);
        }
        return sTWrapDistance;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public STWrapDistance xgetDistR() {
        STWrapDistance sTWrapDistance;
        synchronized (monitor()) {
            check_orphaned();
            sTWrapDistance = (STWrapDistance) get_store().find_attribute_user(DISTR$16);
        }
        return sTWrapDistance;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public STWrapDistance xgetDistT() {
        STWrapDistance sTWrapDistance;
        synchronized (monitor()) {
            check_orphaned();
            sTWrapDistance = (STWrapDistance) get_store().find_attribute_user(DISTT$10);
        }
        return sTWrapDistance;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public void xsetDistB(STWrapDistance sTWrapDistance) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DISTB$12;
            STWrapDistance sTWrapDistance2 = (STWrapDistance) typeStore.find_attribute_user(qName);
            if (sTWrapDistance2 == null) {
                sTWrapDistance2 = (STWrapDistance) get_store().add_attribute_user(qName);
            }
            sTWrapDistance2.set(sTWrapDistance);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public void xsetDistL(STWrapDistance sTWrapDistance) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DISTL$14;
            STWrapDistance sTWrapDistance2 = (STWrapDistance) typeStore.find_attribute_user(qName);
            if (sTWrapDistance2 == null) {
                sTWrapDistance2 = (STWrapDistance) get_store().add_attribute_user(qName);
            }
            sTWrapDistance2.set(sTWrapDistance);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public void xsetDistR(STWrapDistance sTWrapDistance) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DISTR$16;
            STWrapDistance sTWrapDistance2 = (STWrapDistance) typeStore.find_attribute_user(qName);
            if (sTWrapDistance2 == null) {
                sTWrapDistance2 = (STWrapDistance) get_store().add_attribute_user(qName);
            }
            sTWrapDistance2.set(sTWrapDistance);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline
    public void xsetDistT(STWrapDistance sTWrapDistance) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DISTT$10;
            STWrapDistance sTWrapDistance2 = (STWrapDistance) typeStore.find_attribute_user(qName);
            if (sTWrapDistance2 == null) {
                sTWrapDistance2 = (STWrapDistance) get_store().add_attribute_user(qName);
            }
            sTWrapDistance2.set(sTWrapDistance);
        }
    }
}
