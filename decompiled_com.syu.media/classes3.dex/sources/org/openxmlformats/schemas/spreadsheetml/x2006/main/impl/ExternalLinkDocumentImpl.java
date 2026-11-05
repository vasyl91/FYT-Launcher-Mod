package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalLink;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ExternalLinkDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class ExternalLinkDocumentImpl extends XmlComplexContentImpl implements ExternalLinkDocument {
    private static final QName EXTERNALLINK$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "externalLink");

    public ExternalLinkDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.ExternalLinkDocument
    public CTExternalLink addNewExternalLink() {
        CTExternalLink cTExternalLink;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalLink = (CTExternalLink) get_store().add_element_user(EXTERNALLINK$0);
        }
        return cTExternalLink;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.ExternalLinkDocument
    public CTExternalLink getExternalLink() {
        synchronized (monitor()) {
            check_orphaned();
            CTExternalLink cTExternalLink = (CTExternalLink) get_store().find_element_user(EXTERNALLINK$0, 0);
            if (cTExternalLink == null) {
                return null;
            }
            return cTExternalLink;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.ExternalLinkDocument
    public void setExternalLink(CTExternalLink cTExternalLink) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTERNALLINK$0;
            CTExternalLink cTExternalLink2 = (CTExternalLink) typeStore.find_element_user(qName, 0);
            if (cTExternalLink2 == null) {
                cTExternalLink2 = (CTExternalLink) get_store().add_element_user(qName);
            }
            cTExternalLink2.set(cTExternalLink);
        }
    }
}
