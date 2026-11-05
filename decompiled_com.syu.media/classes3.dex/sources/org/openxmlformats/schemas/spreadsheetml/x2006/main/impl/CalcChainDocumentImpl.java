package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CalcChainDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CalcChainDocumentImpl extends XmlComplexContentImpl implements CalcChainDocument {
    private static final QName CALCCHAIN$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "calcChain");

    public CalcChainDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CalcChainDocument
    public CTCalcChain addNewCalcChain() {
        CTCalcChain cTCalcChain;
        synchronized (monitor()) {
            check_orphaned();
            cTCalcChain = (CTCalcChain) get_store().add_element_user(CALCCHAIN$0);
        }
        return cTCalcChain;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CalcChainDocument
    public CTCalcChain getCalcChain() {
        synchronized (monitor()) {
            check_orphaned();
            CTCalcChain cTCalcChain = (CTCalcChain) get_store().find_element_user(CALCCHAIN$0, 0);
            if (cTCalcChain == null) {
                return null;
            }
            return cTCalcChain;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CalcChainDocument
    public void setCalcChain(CTCalcChain cTCalcChain) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CALCCHAIN$0;
            CTCalcChain cTCalcChain2 = (CTCalcChain) typeStore.find_element_user(qName, 0);
            if (cTCalcChain2 == null) {
                cTCalcChain2 = (CTCalcChain) get_store().add_element_user(qName);
            }
            cTCalcChain2.set(cTCalcChain);
        }
    }
}
