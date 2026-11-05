package org.openxmlformats.schemas.drawingml.x2006.picture.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture;
import org.openxmlformats.schemas.drawingml.x2006.picture.PicDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class PicDocumentImpl extends XmlComplexContentImpl implements PicDocument {
    private static final QName PIC$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/picture", "pic");

    public PicDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.picture.PicDocument
    public CTPicture addNewPic() {
        CTPicture cTPicture;
        synchronized (monitor()) {
            check_orphaned();
            cTPicture = (CTPicture) get_store().add_element_user(PIC$0);
        }
        return cTPicture;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.picture.PicDocument
    public CTPicture getPic() {
        synchronized (monitor()) {
            check_orphaned();
            CTPicture cTPicture = (CTPicture) get_store().find_element_user(PIC$0, 0);
            if (cTPicture == null) {
                return null;
            }
            return cTPicture;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.picture.PicDocument
    public void setPic(CTPicture cTPicture) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PIC$0;
            CTPicture cTPicture2 = (CTPicture) typeStore.find_element_user(qName, 0);
            if (cTPicture2 == null) {
                cTPicture2 = (CTPicture) get_store().add_element_user(qName);
            }
            cTPicture2.set(cTPicture);
        }
    }
}
