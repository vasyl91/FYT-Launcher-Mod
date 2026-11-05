package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGraphicFrameProperties;
import org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrameNonVisual;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTGraphicalObjectFrameNonVisualImpl extends XmlComplexContentImpl implements CTGraphicalObjectFrameNonVisual {
    private static final QName CNVPR$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "cNvPr");
    private static final QName CNVGRAPHICFRAMEPR$2 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "cNvGraphicFramePr");
    private static final QName NVPR$4 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "nvPr");

    public CTGraphicalObjectFrameNonVisualImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrameNonVisual
    public CTNonVisualGraphicFrameProperties addNewCNvGraphicFramePr() {
        CTNonVisualGraphicFrameProperties cTNonVisualGraphicFrameProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTNonVisualGraphicFrameProperties = (CTNonVisualGraphicFrameProperties) get_store().add_element_user(CNVGRAPHICFRAMEPR$2);
        }
        return cTNonVisualGraphicFrameProperties;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrameNonVisual
    public CTNonVisualDrawingProps addNewCNvPr() {
        CTNonVisualDrawingProps cTNonVisualDrawingProps;
        synchronized (monitor()) {
            check_orphaned();
            cTNonVisualDrawingProps = (CTNonVisualDrawingProps) get_store().add_element_user(CNVPR$0);
        }
        return cTNonVisualDrawingProps;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrameNonVisual
    public CTApplicationNonVisualDrawingProps addNewNvPr() {
        CTApplicationNonVisualDrawingProps cTApplicationNonVisualDrawingProps;
        synchronized (monitor()) {
            check_orphaned();
            cTApplicationNonVisualDrawingProps = (CTApplicationNonVisualDrawingProps) get_store().add_element_user(NVPR$4);
        }
        return cTApplicationNonVisualDrawingProps;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrameNonVisual
    public CTNonVisualGraphicFrameProperties getCNvGraphicFramePr() {
        synchronized (monitor()) {
            check_orphaned();
            CTNonVisualGraphicFrameProperties cTNonVisualGraphicFrameProperties = (CTNonVisualGraphicFrameProperties) get_store().find_element_user(CNVGRAPHICFRAMEPR$2, 0);
            if (cTNonVisualGraphicFrameProperties == null) {
                return null;
            }
            return cTNonVisualGraphicFrameProperties;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrameNonVisual
    public CTNonVisualDrawingProps getCNvPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTNonVisualDrawingProps cTNonVisualDrawingProps = (CTNonVisualDrawingProps) get_store().find_element_user(CNVPR$0, 0);
            if (cTNonVisualDrawingProps == null) {
                return null;
            }
            return cTNonVisualDrawingProps;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrameNonVisual
    public CTApplicationNonVisualDrawingProps getNvPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTApplicationNonVisualDrawingProps cTApplicationNonVisualDrawingProps = (CTApplicationNonVisualDrawingProps) get_store().find_element_user(NVPR$4, 0);
            if (cTApplicationNonVisualDrawingProps == null) {
                return null;
            }
            return cTApplicationNonVisualDrawingProps;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrameNonVisual
    public void setCNvGraphicFramePr(CTNonVisualGraphicFrameProperties cTNonVisualGraphicFrameProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CNVGRAPHICFRAMEPR$2;
            CTNonVisualGraphicFrameProperties cTNonVisualGraphicFrameProperties2 = (CTNonVisualGraphicFrameProperties) typeStore.find_element_user(qName, 0);
            if (cTNonVisualGraphicFrameProperties2 == null) {
                cTNonVisualGraphicFrameProperties2 = (CTNonVisualGraphicFrameProperties) get_store().add_element_user(qName);
            }
            cTNonVisualGraphicFrameProperties2.set(cTNonVisualGraphicFrameProperties);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrameNonVisual
    public void setCNvPr(CTNonVisualDrawingProps cTNonVisualDrawingProps) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CNVPR$0;
            CTNonVisualDrawingProps cTNonVisualDrawingProps2 = (CTNonVisualDrawingProps) typeStore.find_element_user(qName, 0);
            if (cTNonVisualDrawingProps2 == null) {
                cTNonVisualDrawingProps2 = (CTNonVisualDrawingProps) get_store().add_element_user(qName);
            }
            cTNonVisualDrawingProps2.set(cTNonVisualDrawingProps);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrameNonVisual
    public void setNvPr(CTApplicationNonVisualDrawingProps cTApplicationNonVisualDrawingProps) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NVPR$4;
            CTApplicationNonVisualDrawingProps cTApplicationNonVisualDrawingProps2 = (CTApplicationNonVisualDrawingProps) typeStore.find_element_user(qName, 0);
            if (cTApplicationNonVisualDrawingProps2 == null) {
                cTApplicationNonVisualDrawingProps2 = (CTApplicationNonVisualDrawingProps) get_store().add_element_user(qName);
            }
            cTApplicationNonVisualDrawingProps2.set(cTApplicationNonVisualDrawingProps);
        }
    }
}
