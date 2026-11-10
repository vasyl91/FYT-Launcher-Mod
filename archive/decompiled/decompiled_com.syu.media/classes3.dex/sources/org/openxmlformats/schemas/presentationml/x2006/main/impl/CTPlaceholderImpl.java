package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder;
import org.openxmlformats.schemas.presentationml.x2006.main.STDirection;
import org.openxmlformats.schemas.presentationml.x2006.main.STDirection$Enum;
import org.openxmlformats.schemas.presentationml.x2006.main.STPlaceholderSize;
import org.openxmlformats.schemas.presentationml.x2006.main.STPlaceholderSize$Enum;
import org.openxmlformats.schemas.presentationml.x2006.main.STPlaceholderType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTPlaceholderImpl extends XmlComplexContentImpl implements CTPlaceholder {
    private static final QName EXTLST$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");
    private static final QName TYPE$2 = new QName("", JamXmlElements.TYPE);
    private static final QName ORIENT$4 = new QName("", "orient");
    private static final QName SZ$6 = new QName("", "sz");
    private static final QName IDX$8 = new QName("", "idx");
    private static final QName HASCUSTOMPROMPT$10 = new QName("", "hasCustomPrompt");

    public CTPlaceholderImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public CTExtensionListModify addNewExtLst() {
        CTExtensionListModify cTExtensionListModifyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListModifyAdd_element_user = get_store().add_element_user(EXTLST$0);
        }
        return cTExtensionListModifyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public CTExtensionListModify getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionListModify cTExtensionListModifyFind_element_user = get_store().find_element_user(EXTLST$0, 0);
            if (cTExtensionListModifyFind_element_user == null) {
                return null;
            }
            return cTExtensionListModifyFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public boolean getHasCustomPrompt() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HASCUSTOMPROMPT$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public long getIdx() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IDX$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public STDirection$Enum getOrient() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ORIENT$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STDirection$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public STPlaceholderSize$Enum getSz() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SZ$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STPlaceholderSize$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public STPlaceholderType.Enum getType() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STPlaceholderType.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public boolean isSetHasCustomPrompt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HASCUSTOMPROMPT$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public boolean isSetIdx() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(IDX$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public boolean isSetOrient() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ORIENT$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public boolean isSetSz() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SZ$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public boolean isSetType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TYPE$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void setExtLst(CTExtensionListModify cTExtensionListModify) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$0;
            CTExtensionListModify cTExtensionListModifyFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExtensionListModifyFind_element_user == null) {
                cTExtensionListModifyFind_element_user = (CTExtensionListModify) get_store().add_element_user(qName);
            }
            cTExtensionListModifyFind_element_user.set(cTExtensionListModify);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void setHasCustomPrompt(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HASCUSTOMPROMPT$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void setIdx(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IDX$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void setOrient(STDirection$Enum sTDirection$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ORIENT$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTDirection$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void setSz(STPlaceholderSize$Enum sTPlaceholderSize$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SZ$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTPlaceholderSize$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void setType(STPlaceholderType.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void unsetHasCustomPrompt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HASCUSTOMPROMPT$10);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void unsetIdx() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(IDX$8);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void unsetOrient() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ORIENT$4);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void unsetSz() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SZ$6);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TYPE$2);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public XmlBoolean xgetHasCustomPrompt() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HASCUSTOMPROMPT$10;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public XmlUnsignedInt xgetIdx() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IDX$8;
            xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_default_attribute_value(qName);
            }
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public STDirection xgetOrient() {
        STDirection sTDirectionFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ORIENT$4;
            sTDirectionFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTDirectionFind_attribute_user == null) {
                sTDirectionFind_attribute_user = (STDirection) get_default_attribute_value(qName);
            }
        }
        return sTDirectionFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public STPlaceholderSize xgetSz() {
        STPlaceholderSize sTPlaceholderSizeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SZ$6;
            sTPlaceholderSizeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTPlaceholderSizeFind_attribute_user == null) {
                sTPlaceholderSizeFind_attribute_user = (STPlaceholderSize) get_default_attribute_value(qName);
            }
        }
        return sTPlaceholderSizeFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public STPlaceholderType xgetType() {
        STPlaceholderType sTPlaceholderType;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$2;
            sTPlaceholderType = (STPlaceholderType) typeStore.find_attribute_user(qName);
            if (sTPlaceholderType == null) {
                sTPlaceholderType = (STPlaceholderType) get_default_attribute_value(qName);
            }
        }
        return sTPlaceholderType;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void xsetHasCustomPrompt(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HASCUSTOMPROMPT$10;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void xsetIdx(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = IDX$8;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void xsetOrient(STDirection sTDirection) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ORIENT$4;
            STDirection sTDirectionFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTDirectionFind_attribute_user == null) {
                sTDirectionFind_attribute_user = (STDirection) get_store().add_attribute_user(qName);
            }
            sTDirectionFind_attribute_user.set(sTDirection);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void xsetSz(STPlaceholderSize sTPlaceholderSize) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SZ$6;
            STPlaceholderSize sTPlaceholderSizeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTPlaceholderSizeFind_attribute_user == null) {
                sTPlaceholderSizeFind_attribute_user = (STPlaceholderSize) get_store().add_attribute_user(qName);
            }
            sTPlaceholderSizeFind_attribute_user.set(sTPlaceholderSize);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void xsetType(STPlaceholderType sTPlaceholderType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$2;
            STPlaceholderType sTPlaceholderType2 = (STPlaceholderType) typeStore.find_attribute_user(qName);
            if (sTPlaceholderType2 == null) {
                sTPlaceholderType2 = (STPlaceholderType) get_store().add_attribute_user(qName);
            }
            sTPlaceholderType2.set((XmlObject) sTPlaceholderType);
        }
    }
}
