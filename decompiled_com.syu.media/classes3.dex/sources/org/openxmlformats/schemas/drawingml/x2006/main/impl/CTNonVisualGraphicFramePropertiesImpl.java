package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectFrameLocking;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGraphicFrameProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTNonVisualGraphicFramePropertiesImpl extends XmlComplexContentImpl implements CTNonVisualGraphicFrameProperties {
    private static final QName GRAPHICFRAMELOCKS$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "graphicFrameLocks");
    private static final QName EXTLST$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");

    public CTNonVisualGraphicFramePropertiesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGraphicFrameProperties
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(EXTLST$2);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGraphicFrameProperties
    public CTGraphicalObjectFrameLocking addNewGraphicFrameLocks() {
        CTGraphicalObjectFrameLocking cTGraphicalObjectFrameLocking;
        synchronized (monitor()) {
            check_orphaned();
            cTGraphicalObjectFrameLocking = (CTGraphicalObjectFrameLocking) get_store().add_element_user(GRAPHICFRAMELOCKS$0);
        }
        return cTGraphicalObjectFrameLocking;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGraphicFrameProperties
    public CTOfficeArtExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTOfficeArtExtensionList cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().find_element_user(EXTLST$2, 0);
            if (cTOfficeArtExtensionList == null) {
                return null;
            }
            return cTOfficeArtExtensionList;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGraphicFrameProperties
    public CTGraphicalObjectFrameLocking getGraphicFrameLocks() {
        synchronized (monitor()) {
            check_orphaned();
            CTGraphicalObjectFrameLocking cTGraphicalObjectFrameLocking = (CTGraphicalObjectFrameLocking) get_store().find_element_user(GRAPHICFRAMELOCKS$0, 0);
            if (cTGraphicalObjectFrameLocking == null) {
                return null;
            }
            return cTGraphicalObjectFrameLocking;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGraphicFrameProperties
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGraphicFrameProperties
    public boolean isSetGraphicFrameLocks() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(GRAPHICFRAMELOCKS$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGraphicFrameProperties
    public void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$2;
            CTOfficeArtExtensionList cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) typeStore.find_element_user(qName, 0);
            if (cTOfficeArtExtensionList2 == null) {
                cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) get_store().add_element_user(qName);
            }
            cTOfficeArtExtensionList2.set(cTOfficeArtExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGraphicFrameProperties
    public void setGraphicFrameLocks(CTGraphicalObjectFrameLocking cTGraphicalObjectFrameLocking) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GRAPHICFRAMELOCKS$0;
            CTGraphicalObjectFrameLocking cTGraphicalObjectFrameLocking2 = (CTGraphicalObjectFrameLocking) typeStore.find_element_user(qName, 0);
            if (cTGraphicalObjectFrameLocking2 == null) {
                cTGraphicalObjectFrameLocking2 = (CTGraphicalObjectFrameLocking) get_store().add_element_user(qName);
            }
            cTGraphicalObjectFrameLocking2.set(cTGraphicalObjectFrameLocking);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGraphicFrameProperties
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGraphicFrameProperties
    public void unsetGraphicFrameLocks() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GRAPHICFRAMELOCKS$0, 0);
        }
    }
}
