package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlide;
import org.openxmlformats.schemas.presentationml.x2006.main.SldDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SldDocumentImpl extends XmlComplexContentImpl implements SldDocument {
    private static final QName SLD$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "sld");

    public SldDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.SldDocument
    public CTSlide addNewSld() {
        CTSlide cTSlide;
        synchronized (monitor()) {
            check_orphaned();
            cTSlide = (CTSlide) get_store().add_element_user(SLD$0);
        }
        return cTSlide;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.SldDocument
    public CTSlide getSld() {
        synchronized (monitor()) {
            check_orphaned();
            CTSlide cTSlide = (CTSlide) get_store().find_element_user(SLD$0, 0);
            if (cTSlide == null) {
                return null;
            }
            return cTSlide;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.SldDocument
    public void setSld(CTSlide cTSlide) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SLD$0;
            CTSlide cTSlide2 = (CTSlide) typeStore.find_element_user(qName, 0);
            if (cTSlide2 == null) {
                cTSlide2 = (CTSlide) get_store().add_element_user(qName);
            }
            cTSlide2.set(cTSlide);
        }
    }
}
