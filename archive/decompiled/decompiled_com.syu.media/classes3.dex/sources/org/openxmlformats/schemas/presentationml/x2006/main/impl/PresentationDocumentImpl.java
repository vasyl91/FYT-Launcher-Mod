package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation;
import org.openxmlformats.schemas.presentationml.x2006.main.PresentationDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class PresentationDocumentImpl extends XmlComplexContentImpl implements PresentationDocument {
    private static final QName PRESENTATION$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "presentation");

    public PresentationDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.PresentationDocument
    public CTPresentation addNewPresentation() {
        CTPresentation cTPresentation;
        synchronized (monitor()) {
            check_orphaned();
            cTPresentation = (CTPresentation) get_store().add_element_user(PRESENTATION$0);
        }
        return cTPresentation;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.PresentationDocument
    public CTPresentation getPresentation() {
        synchronized (monitor()) {
            check_orphaned();
            CTPresentation cTPresentation = (CTPresentation) get_store().find_element_user(PRESENTATION$0, 0);
            if (cTPresentation == null) {
                return null;
            }
            return cTPresentation;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.PresentationDocument
    public void setPresentation(CTPresentation cTPresentation) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRESENTATION$0;
            CTPresentation cTPresentation2 = (CTPresentation) typeStore.find_element_user(qName, 0);
            if (cTPresentation2 == null) {
                cTPresentation2 = (CTPresentation) get_store().add_element_user(qName);
            }
            cTPresentation2.set(cTPresentation);
        }
    }
}
