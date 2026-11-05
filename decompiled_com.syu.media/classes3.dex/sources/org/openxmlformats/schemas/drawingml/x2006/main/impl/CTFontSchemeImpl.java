package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFontScheme;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTFontSchemeImpl extends XmlComplexContentImpl implements CTFontScheme {
    private static final QName MAJORFONT$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "majorFont");
    private static final QName MINORFONT$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "minorFont");
    private static final QName EXTLST$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
    private static final QName NAME$6 = new QName("", "name");

    public CTFontSchemeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontScheme
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(EXTLST$4);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontScheme
    public CTFontCollection addNewMajorFont() {
        CTFontCollection cTFontCollection;
        synchronized (monitor()) {
            check_orphaned();
            cTFontCollection = (CTFontCollection) get_store().add_element_user(MAJORFONT$0);
        }
        return cTFontCollection;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontScheme
    public CTFontCollection addNewMinorFont() {
        CTFontCollection cTFontCollection;
        synchronized (monitor()) {
            check_orphaned();
            cTFontCollection = (CTFontCollection) get_store().add_element_user(MINORFONT$2);
        }
        return cTFontCollection;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontScheme
    public CTOfficeArtExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTOfficeArtExtensionList cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().find_element_user(EXTLST$4, 0);
            if (cTOfficeArtExtensionList == null) {
                return null;
            }
            return cTOfficeArtExtensionList;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontScheme
    public CTFontCollection getMajorFont() {
        synchronized (monitor()) {
            check_orphaned();
            CTFontCollection cTFontCollection = (CTFontCollection) get_store().find_element_user(MAJORFONT$0, 0);
            if (cTFontCollection == null) {
                return null;
            }
            return cTFontCollection;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontScheme
    public CTFontCollection getMinorFont() {
        synchronized (monitor()) {
            check_orphaned();
            CTFontCollection cTFontCollection = (CTFontCollection) get_store().find_element_user(MINORFONT$2, 0);
            if (cTFontCollection == null) {
                return null;
            }
            return cTFontCollection;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontScheme
    public String getName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(NAME$6);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontScheme
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontScheme
    public void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$4;
            CTOfficeArtExtensionList cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) typeStore.find_element_user(qName, 0);
            if (cTOfficeArtExtensionList2 == null) {
                cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) get_store().add_element_user(qName);
            }
            cTOfficeArtExtensionList2.set(cTOfficeArtExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontScheme
    public void setMajorFont(CTFontCollection cTFontCollection) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAJORFONT$0;
            CTFontCollection cTFontCollection2 = (CTFontCollection) typeStore.find_element_user(qName, 0);
            if (cTFontCollection2 == null) {
                cTFontCollection2 = (CTFontCollection) get_store().add_element_user(qName);
            }
            cTFontCollection2.set(cTFontCollection);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontScheme
    public void setMinorFont(CTFontCollection cTFontCollection) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINORFONT$2;
            CTFontCollection cTFontCollection2 = (CTFontCollection) typeStore.find_element_user(qName, 0);
            if (cTFontCollection2 == null) {
                cTFontCollection2 = (CTFontCollection) get_store().add_element_user(qName);
            }
            cTFontCollection2.set(cTFontCollection);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontScheme
    public void setName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontScheme
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontScheme
    public XmlString xgetName() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(NAME$6);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontScheme
    public void xsetName(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$6;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }
}
