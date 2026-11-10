package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrameNonVisual;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTGraphicalObjectFrameImpl extends XmlComplexContentImpl implements CTGraphicalObjectFrame {
    private static final QName NVGRAPHICFRAMEPR$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "nvGraphicFramePr");
    private static final QName XFRM$2 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "xfrm");
    private static final QName GRAPHIC$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "graphic");
    private static final QName EXTLST$6 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");

    public CTGraphicalObjectFrameImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public CTExtensionListModify addNewExtLst() {
        CTExtensionListModify cTExtensionListModifyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListModifyAdd_element_user = get_store().add_element_user(EXTLST$6);
        }
        return cTExtensionListModifyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public CTGraphicalObject addNewGraphic() {
        CTGraphicalObject cTGraphicalObject;
        synchronized (monitor()) {
            check_orphaned();
            cTGraphicalObject = (CTGraphicalObject) get_store().add_element_user(GRAPHIC$4);
        }
        return cTGraphicalObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public CTGraphicalObjectFrameNonVisual addNewNvGraphicFramePr() {
        CTGraphicalObjectFrameNonVisual cTGraphicalObjectFrameNonVisual;
        synchronized (monitor()) {
            check_orphaned();
            cTGraphicalObjectFrameNonVisual = (CTGraphicalObjectFrameNonVisual) get_store().add_element_user(NVGRAPHICFRAMEPR$0);
        }
        return cTGraphicalObjectFrameNonVisual;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public CTTransform2D addNewXfrm() {
        CTTransform2D cTTransform2D;
        synchronized (monitor()) {
            check_orphaned();
            cTTransform2D = (CTTransform2D) get_store().add_element_user(XFRM$2);
        }
        return cTTransform2D;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public CTExtensionListModify getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionListModify cTExtensionListModifyFind_element_user = get_store().find_element_user(EXTLST$6, 0);
            if (cTExtensionListModifyFind_element_user == null) {
                return null;
            }
            return cTExtensionListModifyFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public CTGraphicalObject getGraphic() {
        synchronized (monitor()) {
            check_orphaned();
            CTGraphicalObject cTGraphicalObject = (CTGraphicalObject) get_store().find_element_user(GRAPHIC$4, 0);
            if (cTGraphicalObject == null) {
                return null;
            }
            return cTGraphicalObject;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public CTGraphicalObjectFrameNonVisual getNvGraphicFramePr() {
        synchronized (monitor()) {
            check_orphaned();
            CTGraphicalObjectFrameNonVisual cTGraphicalObjectFrameNonVisual = (CTGraphicalObjectFrameNonVisual) get_store().find_element_user(NVGRAPHICFRAMEPR$0, 0);
            if (cTGraphicalObjectFrameNonVisual == null) {
                return null;
            }
            return cTGraphicalObjectFrameNonVisual;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public CTTransform2D getXfrm() {
        synchronized (monitor()) {
            check_orphaned();
            CTTransform2D cTTransform2D = (CTTransform2D) get_store().find_element_user(XFRM$2, 0);
            if (cTTransform2D == null) {
                return null;
            }
            return cTTransform2D;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public void setExtLst(CTExtensionListModify cTExtensionListModify) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$6;
            CTExtensionListModify cTExtensionListModifyFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExtensionListModifyFind_element_user == null) {
                cTExtensionListModifyFind_element_user = (CTExtensionListModify) get_store().add_element_user(qName);
            }
            cTExtensionListModifyFind_element_user.set(cTExtensionListModify);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public void setGraphic(CTGraphicalObject cTGraphicalObject) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GRAPHIC$4;
            CTGraphicalObject cTGraphicalObject2 = (CTGraphicalObject) typeStore.find_element_user(qName, 0);
            if (cTGraphicalObject2 == null) {
                cTGraphicalObject2 = (CTGraphicalObject) get_store().add_element_user(qName);
            }
            cTGraphicalObject2.set(cTGraphicalObject);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public void setNvGraphicFramePr(CTGraphicalObjectFrameNonVisual cTGraphicalObjectFrameNonVisual) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NVGRAPHICFRAMEPR$0;
            CTGraphicalObjectFrameNonVisual cTGraphicalObjectFrameNonVisual2 = (CTGraphicalObjectFrameNonVisual) typeStore.find_element_user(qName, 0);
            if (cTGraphicalObjectFrameNonVisual2 == null) {
                cTGraphicalObjectFrameNonVisual2 = (CTGraphicalObjectFrameNonVisual) get_store().add_element_user(qName);
            }
            cTGraphicalObjectFrameNonVisual2.set(cTGraphicalObjectFrameNonVisual);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public void setXfrm(CTTransform2D cTTransform2D) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = XFRM$2;
            CTTransform2D cTTransform2D2 = (CTTransform2D) typeStore.find_element_user(qName, 0);
            if (cTTransform2D2 == null) {
                cTTransform2D2 = (CTTransform2D) get_store().add_element_user(qName);
            }
            cTTransform2D2.set(cTTransform2D);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$6, 0);
        }
    }
}
