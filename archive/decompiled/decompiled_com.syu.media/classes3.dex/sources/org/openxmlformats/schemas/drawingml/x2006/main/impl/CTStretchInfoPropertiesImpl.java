package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTStretchInfoProperties;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTStretchInfoPropertiesImpl extends XmlComplexContentImpl implements CTStretchInfoProperties {
    private static final QName FILLRECT$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "fillRect");

    public CTStretchInfoPropertiesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStretchInfoProperties
    public CTRelativeRect addNewFillRect() {
        CTRelativeRect cTRelativeRect;
        synchronized (monitor()) {
            check_orphaned();
            cTRelativeRect = (CTRelativeRect) get_store().add_element_user(FILLRECT$0);
        }
        return cTRelativeRect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStretchInfoProperties
    public CTRelativeRect getFillRect() {
        synchronized (monitor()) {
            check_orphaned();
            CTRelativeRect cTRelativeRect = (CTRelativeRect) get_store().find_element_user(FILLRECT$0, 0);
            if (cTRelativeRect == null) {
                return null;
            }
            return cTRelativeRect;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStretchInfoProperties
    public boolean isSetFillRect() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FILLRECT$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStretchInfoProperties
    public void setFillRect(CTRelativeRect cTRelativeRect) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLRECT$0;
            CTRelativeRect cTRelativeRect2 = (CTRelativeRect) typeStore.find_element_user(qName, 0);
            if (cTRelativeRect2 == null) {
                cTRelativeRect2 = (CTRelativeRect) get_store().add_element_user(qName);
            }
            cTRelativeRect2.set(cTRelativeRect);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStretchInfoProperties
    public void unsetFillRect() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FILLRECT$0, 0);
        }
    }
}
