package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STGuid;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STRef;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTCommentImpl extends XmlComplexContentImpl implements CTComment {
    private static final QName TEXT$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "text");
    private static final QName REF$2 = new QName("", "ref");
    private static final QName AUTHORID$4 = new QName("", "authorId");
    private static final QName GUID$6 = new QName("", "guid");

    public CTCommentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment
    public CTRst addNewText() {
        CTRst cTRst;
        synchronized (monitor()) {
            check_orphaned();
            cTRst = (CTRst) get_store().add_element_user(TEXT$0);
        }
        return cTRst;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment
    public long getAuthorId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(AUTHORID$4);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment
    public String getGuid() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(GUID$6);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment
    public String getRef() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(REF$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment
    public CTRst getText() {
        synchronized (monitor()) {
            check_orphaned();
            CTRst cTRst = (CTRst) get_store().find_element_user(TEXT$0, 0);
            if (cTRst == null) {
                return null;
            }
            return cTRst;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment
    public boolean isSetGuid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(GUID$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment
    public void setAuthorId(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AUTHORID$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment
    public void setGuid(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GUID$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment
    public void setRef(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REF$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment
    public void setText(CTRst cTRst) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TEXT$0;
            CTRst cTRst2 = (CTRst) typeStore.find_element_user(qName, 0);
            if (cTRst2 == null) {
                cTRst2 = (CTRst) get_store().add_element_user(qName);
            }
            cTRst2.set(cTRst);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment
    public void unsetGuid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(GUID$6);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment
    public XmlUnsignedInt xgetAuthorId() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(AUTHORID$4);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment
    public STGuid xgetGuid() {
        STGuid sTGuidFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTGuidFind_attribute_user = get_store().find_attribute_user(GUID$6);
        }
        return sTGuidFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment
    public STRef xgetRef() {
        STRef sTRef;
        synchronized (monitor()) {
            check_orphaned();
            sTRef = (STRef) get_store().find_attribute_user(REF$2);
        }
        return sTRef;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment
    public void xsetAuthorId(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AUTHORID$4;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment
    public void xsetGuid(STGuid sTGuid) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GUID$6;
            STGuid sTGuidFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTGuidFind_attribute_user == null) {
                sTGuidFind_attribute_user = (STGuid) get_store().add_attribute_user(qName);
            }
            sTGuidFind_attribute_user.set(sTGuid);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment
    public void xsetRef(STRef sTRef) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REF$2;
            STRef sTRef2 = (STRef) typeStore.find_attribute_user(qName);
            if (sTRef2 == null) {
                sTRef2 = (STRef) get_store().add_attribute_user(qName);
            }
            sTRef2.set(sTRef);
        }
    }
}
