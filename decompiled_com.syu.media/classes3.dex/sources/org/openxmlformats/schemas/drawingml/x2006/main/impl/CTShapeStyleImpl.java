package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFontReference;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTShapeStyleImpl extends XmlComplexContentImpl implements CTShapeStyle {
    private static final QName LNREF$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lnRef");
    private static final QName FILLREF$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "fillRef");
    private static final QName EFFECTREF$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "effectRef");
    private static final QName FONTREF$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "fontRef");

    public CTShapeStyleImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle
    public CTStyleMatrixReference addNewEffectRef() {
        CTStyleMatrixReference cTStyleMatrixReference;
        synchronized (monitor()) {
            check_orphaned();
            cTStyleMatrixReference = (CTStyleMatrixReference) get_store().add_element_user(EFFECTREF$4);
        }
        return cTStyleMatrixReference;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle
    public CTStyleMatrixReference addNewFillRef() {
        CTStyleMatrixReference cTStyleMatrixReference;
        synchronized (monitor()) {
            check_orphaned();
            cTStyleMatrixReference = (CTStyleMatrixReference) get_store().add_element_user(FILLREF$2);
        }
        return cTStyleMatrixReference;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle
    public CTFontReference addNewFontRef() {
        CTFontReference cTFontReference;
        synchronized (monitor()) {
            check_orphaned();
            cTFontReference = (CTFontReference) get_store().add_element_user(FONTREF$6);
        }
        return cTFontReference;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle
    public CTStyleMatrixReference addNewLnRef() {
        CTStyleMatrixReference cTStyleMatrixReference;
        synchronized (monitor()) {
            check_orphaned();
            cTStyleMatrixReference = (CTStyleMatrixReference) get_store().add_element_user(LNREF$0);
        }
        return cTStyleMatrixReference;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle
    public CTStyleMatrixReference getEffectRef() {
        synchronized (monitor()) {
            check_orphaned();
            CTStyleMatrixReference cTStyleMatrixReference = (CTStyleMatrixReference) get_store().find_element_user(EFFECTREF$4, 0);
            if (cTStyleMatrixReference == null) {
                return null;
            }
            return cTStyleMatrixReference;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle
    public CTStyleMatrixReference getFillRef() {
        synchronized (monitor()) {
            check_orphaned();
            CTStyleMatrixReference cTStyleMatrixReference = (CTStyleMatrixReference) get_store().find_element_user(FILLREF$2, 0);
            if (cTStyleMatrixReference == null) {
                return null;
            }
            return cTStyleMatrixReference;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle
    public CTFontReference getFontRef() {
        synchronized (monitor()) {
            check_orphaned();
            CTFontReference cTFontReference = (CTFontReference) get_store().find_element_user(FONTREF$6, 0);
            if (cTFontReference == null) {
                return null;
            }
            return cTFontReference;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle
    public CTStyleMatrixReference getLnRef() {
        synchronized (monitor()) {
            check_orphaned();
            CTStyleMatrixReference cTStyleMatrixReference = (CTStyleMatrixReference) get_store().find_element_user(LNREF$0, 0);
            if (cTStyleMatrixReference == null) {
                return null;
            }
            return cTStyleMatrixReference;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle
    public void setEffectRef(CTStyleMatrixReference cTStyleMatrixReference) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EFFECTREF$4;
            CTStyleMatrixReference cTStyleMatrixReference2 = (CTStyleMatrixReference) typeStore.find_element_user(qName, 0);
            if (cTStyleMatrixReference2 == null) {
                cTStyleMatrixReference2 = (CTStyleMatrixReference) get_store().add_element_user(qName);
            }
            cTStyleMatrixReference2.set(cTStyleMatrixReference);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle
    public void setFillRef(CTStyleMatrixReference cTStyleMatrixReference) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLREF$2;
            CTStyleMatrixReference cTStyleMatrixReference2 = (CTStyleMatrixReference) typeStore.find_element_user(qName, 0);
            if (cTStyleMatrixReference2 == null) {
                cTStyleMatrixReference2 = (CTStyleMatrixReference) get_store().add_element_user(qName);
            }
            cTStyleMatrixReference2.set(cTStyleMatrixReference);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle
    public void setFontRef(CTFontReference cTFontReference) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FONTREF$6;
            CTFontReference cTFontReference2 = (CTFontReference) typeStore.find_element_user(qName, 0);
            if (cTFontReference2 == null) {
                cTFontReference2 = (CTFontReference) get_store().add_element_user(qName);
            }
            cTFontReference2.set(cTFontReference);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle
    public void setLnRef(CTStyleMatrixReference cTStyleMatrixReference) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LNREF$0;
            CTStyleMatrixReference cTStyleMatrixReference2 = (CTStyleMatrixReference) typeStore.find_element_user(qName, 0);
            if (cTStyleMatrixReference2 == null) {
                cTStyleMatrixReference2 = (CTStyleMatrixReference) get_store().add_element_user(qName);
            }
            cTStyleMatrixReference2.set(cTStyleMatrixReference);
        }
    }
}
