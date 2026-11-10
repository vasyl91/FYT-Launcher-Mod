package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class AppinfoDocumentImpl extends XmlComplexContentImpl implements AppinfoDocument {
    private static final QName APPINFO$0 = new QName(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA, "appinfo");
    private static final long serialVersionUID = 1;

    public AppinfoDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument
    public AppinfoDocument.Appinfo getAppinfo() {
        synchronized (monitor()) {
            check_orphaned();
            AppinfoDocument.Appinfo appinfo = (AppinfoDocument.Appinfo) get_store().find_element_user(APPINFO$0, 0);
            if (appinfo == null) {
                return null;
            }
            return appinfo;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument
    public void setAppinfo(AppinfoDocument.Appinfo appinfo) {
        generatedSetterHelperImpl(appinfo, APPINFO$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument
    public AppinfoDocument.Appinfo addNewAppinfo() {
        AppinfoDocument.Appinfo appinfo;
        synchronized (monitor()) {
            check_orphaned();
            appinfo = (AppinfoDocument.Appinfo) get_store().add_element_user(APPINFO$0);
        }
        return appinfo;
    }

    public static class AppinfoImpl extends XmlComplexContentImpl implements AppinfoDocument.Appinfo {
        private static final QName SOURCE$0 = new QName("", "source");
        private static final long serialVersionUID = 1;

        public AppinfoImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument.Appinfo
        public String getSource() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SOURCE$0);
                if (simpleValueFind_attribute_user == null) {
                    return null;
                }
                return simpleValueFind_attribute_user.getStringValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument.Appinfo
        public XmlAnyURI xgetSource() {
            XmlAnyURI xmlAnyURIFind_attribute_user;
            synchronized (monitor()) {
                check_orphaned();
                xmlAnyURIFind_attribute_user = get_store().find_attribute_user(SOURCE$0);
            }
            return xmlAnyURIFind_attribute_user;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument.Appinfo
        public boolean isSetSource() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(SOURCE$0) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument.Appinfo
        public void setSource(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SOURCE$0;
                SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
                if (simpleValueFind_attribute_user == null) {
                    simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValueFind_attribute_user.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument.Appinfo
        public void xsetSource(XmlAnyURI xmlAnyURI) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SOURCE$0;
                XmlAnyURI xmlAnyURIFind_attribute_user = typeStore.find_attribute_user(qName);
                if (xmlAnyURIFind_attribute_user == null) {
                    xmlAnyURIFind_attribute_user = (XmlAnyURI) get_store().add_attribute_user(qName);
                }
                xmlAnyURIFind_attribute_user.set(xmlAnyURI);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument.Appinfo
        public void unsetSource() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(SOURCE$0);
            }
        }
    }
}
