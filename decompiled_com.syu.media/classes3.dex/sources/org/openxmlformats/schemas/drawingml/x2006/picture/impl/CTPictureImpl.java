package org.openxmlformats.schemas.drawingml.x2006.picture.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture;
import org.openxmlformats.schemas.drawingml.x2006.picture.CTPictureNonVisual;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTPictureImpl extends XmlComplexContentImpl implements CTPicture {
    private static final QName NVPICPR$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/picture", "nvPicPr");
    private static final QName BLIPFILL$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/picture", "blipFill");
    private static final QName SPPR$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/picture", "spPr");

    public CTPictureImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture
    public CTBlipFillProperties addNewBlipFill() {
        CTBlipFillProperties cTBlipFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTBlipFillProperties = (CTBlipFillProperties) get_store().add_element_user(BLIPFILL$2);
        }
        return cTBlipFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture
    public CTPictureNonVisual addNewNvPicPr() {
        CTPictureNonVisual cTPictureNonVisual;
        synchronized (monitor()) {
            check_orphaned();
            cTPictureNonVisual = (CTPictureNonVisual) get_store().add_element_user(NVPICPR$0);
        }
        return cTPictureNonVisual;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture
    public CTShapeProperties addNewSpPr() {
        CTShapeProperties cTShapeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeProperties = (CTShapeProperties) get_store().add_element_user(SPPR$4);
        }
        return cTShapeProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture
    public CTBlipFillProperties getBlipFill() {
        synchronized (monitor()) {
            check_orphaned();
            CTBlipFillProperties cTBlipFillProperties = (CTBlipFillProperties) get_store().find_element_user(BLIPFILL$2, 0);
            if (cTBlipFillProperties == null) {
                return null;
            }
            return cTBlipFillProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture
    public CTPictureNonVisual getNvPicPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTPictureNonVisual cTPictureNonVisual = (CTPictureNonVisual) get_store().find_element_user(NVPICPR$0, 0);
            if (cTPictureNonVisual == null) {
                return null;
            }
            return cTPictureNonVisual;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture
    public CTShapeProperties getSpPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTShapeProperties cTShapeProperties = (CTShapeProperties) get_store().find_element_user(SPPR$4, 0);
            if (cTShapeProperties == null) {
                return null;
            }
            return cTShapeProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture
    public void setBlipFill(CTBlipFillProperties cTBlipFillProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLIPFILL$2;
            CTBlipFillProperties cTBlipFillProperties2 = (CTBlipFillProperties) typeStore.find_element_user(qName, 0);
            if (cTBlipFillProperties2 == null) {
                cTBlipFillProperties2 = (CTBlipFillProperties) get_store().add_element_user(qName);
            }
            cTBlipFillProperties2.set(cTBlipFillProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture
    public void setNvPicPr(CTPictureNonVisual cTPictureNonVisual) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NVPICPR$0;
            CTPictureNonVisual cTPictureNonVisual2 = (CTPictureNonVisual) typeStore.find_element_user(qName, 0);
            if (cTPictureNonVisual2 == null) {
                cTPictureNonVisual2 = (CTPictureNonVisual) get_store().add_element_user(qName);
            }
            cTPictureNonVisual2.set(cTPictureNonVisual);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture
    public void setSpPr(CTShapeProperties cTShapeProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPPR$4;
            CTShapeProperties cTShapeProperties2 = (CTShapeProperties) typeStore.find_element_user(qName, 0);
            if (cTShapeProperties2 == null) {
                cTShapeProperties2 = (CTShapeProperties) get_store().add_element_user(qName);
            }
            cTShapeProperties2.set(cTShapeProperties);
        }
    }
}
