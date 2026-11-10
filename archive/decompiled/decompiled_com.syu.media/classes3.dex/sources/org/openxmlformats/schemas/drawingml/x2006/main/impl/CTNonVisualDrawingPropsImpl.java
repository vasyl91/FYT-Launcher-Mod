package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.STDrawingElementId;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTNonVisualDrawingPropsImpl extends XmlComplexContentImpl implements CTNonVisualDrawingProps {
    private static final QName HLINKCLICK$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "hlinkClick");
    private static final QName HLINKHOVER$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "hlinkHover");
    private static final QName EXTLST$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
    private static final QName ID$6 = new QName("", "id");
    private static final QName NAME$8 = new QName("", "name");
    private static final QName DESCR$10 = new QName("", "descr");
    private static final QName HIDDEN$12 = new QName("", "hidden");

    public CTNonVisualDrawingPropsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(EXTLST$4);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public CTHyperlink addNewHlinkClick() {
        CTHyperlink cTHyperlink;
        synchronized (monitor()) {
            check_orphaned();
            cTHyperlink = (CTHyperlink) get_store().add_element_user(HLINKCLICK$0);
        }
        return cTHyperlink;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public CTHyperlink addNewHlinkHover() {
        CTHyperlink cTHyperlink;
        synchronized (monitor()) {
            check_orphaned();
            cTHyperlink = (CTHyperlink) get_store().add_element_user(HLINKHOVER$2);
        }
        return cTHyperlink;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public String getDescr() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DESCR$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public boolean getHidden() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HIDDEN$12;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public CTHyperlink getHlinkClick() {
        synchronized (monitor()) {
            check_orphaned();
            CTHyperlink cTHyperlink = (CTHyperlink) get_store().find_element_user(HLINKCLICK$0, 0);
            if (cTHyperlink == null) {
                return null;
            }
            return cTHyperlink;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public CTHyperlink getHlinkHover() {
        synchronized (monitor()) {
            check_orphaned();
            CTHyperlink cTHyperlink = (CTHyperlink) get_store().find_element_user(HLINKHOVER$2, 0);
            if (cTHyperlink == null) {
                return null;
            }
            return cTHyperlink;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public long getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ID$6);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public String getName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(NAME$8);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public boolean isSetDescr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DESCR$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public boolean isSetHidden() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HIDDEN$12) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public boolean isSetHlinkClick() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HLINKCLICK$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public boolean isSetHlinkHover() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HLINKHOVER$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public void setDescr(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DESCR$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public void setHidden(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HIDDEN$12;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public void setHlinkClick(CTHyperlink cTHyperlink) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HLINKCLICK$0;
            CTHyperlink cTHyperlink2 = (CTHyperlink) typeStore.find_element_user(qName, 0);
            if (cTHyperlink2 == null) {
                cTHyperlink2 = (CTHyperlink) get_store().add_element_user(qName);
            }
            cTHyperlink2.set(cTHyperlink);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public void setHlinkHover(CTHyperlink cTHyperlink) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HLINKHOVER$2;
            CTHyperlink cTHyperlink2 = (CTHyperlink) typeStore.find_element_user(qName, 0);
            if (cTHyperlink2 == null) {
                cTHyperlink2 = (CTHyperlink) get_store().add_element_user(qName);
            }
            cTHyperlink2.set(cTHyperlink);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public void setId(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public void setName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public void unsetDescr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DESCR$10);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public void unsetHidden() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HIDDEN$12);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public void unsetHlinkClick() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HLINKCLICK$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public void unsetHlinkHover() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HLINKHOVER$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public XmlString xgetDescr() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DESCR$10;
            xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_default_attribute_value(qName);
            }
        }
        return xmlStringFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public XmlBoolean xgetHidden() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HIDDEN$12;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public STDrawingElementId xgetId() {
        STDrawingElementId sTDrawingElementId;
        synchronized (monitor()) {
            check_orphaned();
            sTDrawingElementId = (STDrawingElementId) get_store().find_attribute_user(ID$6);
        }
        return sTDrawingElementId;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public XmlString xgetName() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(NAME$8);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public void xsetDescr(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DESCR$10;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public void xsetHidden(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HIDDEN$12;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public void xsetId(STDrawingElementId sTDrawingElementId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$6;
            STDrawingElementId sTDrawingElementId2 = (STDrawingElementId) typeStore.find_attribute_user(qName);
            if (sTDrawingElementId2 == null) {
                sTDrawingElementId2 = (STDrawingElementId) get_store().add_attribute_user(qName);
            }
            sTDrawingElementId2.set(sTDrawingElementId);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps
    public void xsetName(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$8;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }
}
