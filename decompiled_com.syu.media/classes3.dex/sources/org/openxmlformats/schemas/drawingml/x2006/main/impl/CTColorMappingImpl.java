package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.STColorSchemeIndex;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTColorMappingImpl extends XmlComplexContentImpl implements CTColorMapping {
    private static final QName EXTLST$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
    private static final QName BG1$2 = new QName("", "bg1");
    private static final QName TX1$4 = new QName("", "tx1");
    private static final QName BG2$6 = new QName("", "bg2");
    private static final QName TX2$8 = new QName("", "tx2");
    private static final QName ACCENT1$10 = new QName("", "accent1");
    private static final QName ACCENT2$12 = new QName("", "accent2");
    private static final QName ACCENT3$14 = new QName("", "accent3");
    private static final QName ACCENT4$16 = new QName("", "accent4");
    private static final QName ACCENT5$18 = new QName("", "accent5");
    private static final QName ACCENT6$20 = new QName("", "accent6");
    private static final QName HLINK$22 = new QName("", "hlink");
    private static final QName FOLHLINK$24 = new QName("", "folHlink");

    public CTColorMappingImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(EXTLST$0);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex.Enum getAccent1() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ACCENT1$10);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STColorSchemeIndex.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex.Enum getAccent2() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ACCENT2$12);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STColorSchemeIndex.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex.Enum getAccent3() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ACCENT3$14);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STColorSchemeIndex.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex.Enum getAccent4() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ACCENT4$16);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STColorSchemeIndex.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex.Enum getAccent5() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ACCENT5$18);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STColorSchemeIndex.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex.Enum getAccent6() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ACCENT6$20);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STColorSchemeIndex.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex.Enum getBg1() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BG1$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STColorSchemeIndex.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex.Enum getBg2() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BG2$6);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STColorSchemeIndex.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public CTOfficeArtExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTOfficeArtExtensionList cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().find_element_user(EXTLST$0, 0);
            if (cTOfficeArtExtensionList == null) {
                return null;
            }
            return cTOfficeArtExtensionList;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex.Enum getFolHlink() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FOLHLINK$24);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STColorSchemeIndex.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex.Enum getHlink() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HLINK$22);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STColorSchemeIndex.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex.Enum getTx1() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TX1$4);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STColorSchemeIndex.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex.Enum getTx2() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TX2$8);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STColorSchemeIndex.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void setAccent1(STColorSchemeIndex.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ACCENT1$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void setAccent2(STColorSchemeIndex.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ACCENT2$12;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void setAccent3(STColorSchemeIndex.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ACCENT3$14;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void setAccent4(STColorSchemeIndex.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ACCENT4$16;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void setAccent5(STColorSchemeIndex.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ACCENT5$18;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void setAccent6(STColorSchemeIndex.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ACCENT6$20;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void setBg1(STColorSchemeIndex.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BG1$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void setBg2(STColorSchemeIndex.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BG2$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$0;
            CTOfficeArtExtensionList cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) typeStore.find_element_user(qName, 0);
            if (cTOfficeArtExtensionList2 == null) {
                cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) get_store().add_element_user(qName);
            }
            cTOfficeArtExtensionList2.set(cTOfficeArtExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void setFolHlink(STColorSchemeIndex.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FOLHLINK$24;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void setHlink(STColorSchemeIndex.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HLINK$22;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void setTx1(STColorSchemeIndex.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TX1$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void setTx2(STColorSchemeIndex.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TX2$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex xgetAccent1() {
        STColorSchemeIndex sTColorSchemeIndex;
        synchronized (monitor()) {
            check_orphaned();
            sTColorSchemeIndex = (STColorSchemeIndex) get_store().find_attribute_user(ACCENT1$10);
        }
        return sTColorSchemeIndex;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex xgetAccent2() {
        STColorSchemeIndex sTColorSchemeIndex;
        synchronized (monitor()) {
            check_orphaned();
            sTColorSchemeIndex = (STColorSchemeIndex) get_store().find_attribute_user(ACCENT2$12);
        }
        return sTColorSchemeIndex;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex xgetAccent3() {
        STColorSchemeIndex sTColorSchemeIndex;
        synchronized (monitor()) {
            check_orphaned();
            sTColorSchemeIndex = (STColorSchemeIndex) get_store().find_attribute_user(ACCENT3$14);
        }
        return sTColorSchemeIndex;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex xgetAccent4() {
        STColorSchemeIndex sTColorSchemeIndex;
        synchronized (monitor()) {
            check_orphaned();
            sTColorSchemeIndex = (STColorSchemeIndex) get_store().find_attribute_user(ACCENT4$16);
        }
        return sTColorSchemeIndex;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex xgetAccent5() {
        STColorSchemeIndex sTColorSchemeIndex;
        synchronized (monitor()) {
            check_orphaned();
            sTColorSchemeIndex = (STColorSchemeIndex) get_store().find_attribute_user(ACCENT5$18);
        }
        return sTColorSchemeIndex;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex xgetAccent6() {
        STColorSchemeIndex sTColorSchemeIndex;
        synchronized (monitor()) {
            check_orphaned();
            sTColorSchemeIndex = (STColorSchemeIndex) get_store().find_attribute_user(ACCENT6$20);
        }
        return sTColorSchemeIndex;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex xgetBg1() {
        STColorSchemeIndex sTColorSchemeIndex;
        synchronized (monitor()) {
            check_orphaned();
            sTColorSchemeIndex = (STColorSchemeIndex) get_store().find_attribute_user(BG1$2);
        }
        return sTColorSchemeIndex;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex xgetBg2() {
        STColorSchemeIndex sTColorSchemeIndex;
        synchronized (monitor()) {
            check_orphaned();
            sTColorSchemeIndex = (STColorSchemeIndex) get_store().find_attribute_user(BG2$6);
        }
        return sTColorSchemeIndex;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex xgetFolHlink() {
        STColorSchemeIndex sTColorSchemeIndex;
        synchronized (monitor()) {
            check_orphaned();
            sTColorSchemeIndex = (STColorSchemeIndex) get_store().find_attribute_user(FOLHLINK$24);
        }
        return sTColorSchemeIndex;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex xgetHlink() {
        STColorSchemeIndex sTColorSchemeIndex;
        synchronized (monitor()) {
            check_orphaned();
            sTColorSchemeIndex = (STColorSchemeIndex) get_store().find_attribute_user(HLINK$22);
        }
        return sTColorSchemeIndex;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex xgetTx1() {
        STColorSchemeIndex sTColorSchemeIndex;
        synchronized (monitor()) {
            check_orphaned();
            sTColorSchemeIndex = (STColorSchemeIndex) get_store().find_attribute_user(TX1$4);
        }
        return sTColorSchemeIndex;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex xgetTx2() {
        STColorSchemeIndex sTColorSchemeIndex;
        synchronized (monitor()) {
            check_orphaned();
            sTColorSchemeIndex = (STColorSchemeIndex) get_store().find_attribute_user(TX2$8);
        }
        return sTColorSchemeIndex;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void xsetAccent1(STColorSchemeIndex sTColorSchemeIndex) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ACCENT1$10;
            STColorSchemeIndex sTColorSchemeIndex2 = (STColorSchemeIndex) typeStore.find_attribute_user(qName);
            if (sTColorSchemeIndex2 == null) {
                sTColorSchemeIndex2 = (STColorSchemeIndex) get_store().add_attribute_user(qName);
            }
            sTColorSchemeIndex2.set((XmlObject) sTColorSchemeIndex);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void xsetAccent2(STColorSchemeIndex sTColorSchemeIndex) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ACCENT2$12;
            STColorSchemeIndex sTColorSchemeIndex2 = (STColorSchemeIndex) typeStore.find_attribute_user(qName);
            if (sTColorSchemeIndex2 == null) {
                sTColorSchemeIndex2 = (STColorSchemeIndex) get_store().add_attribute_user(qName);
            }
            sTColorSchemeIndex2.set((XmlObject) sTColorSchemeIndex);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void xsetAccent3(STColorSchemeIndex sTColorSchemeIndex) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ACCENT3$14;
            STColorSchemeIndex sTColorSchemeIndex2 = (STColorSchemeIndex) typeStore.find_attribute_user(qName);
            if (sTColorSchemeIndex2 == null) {
                sTColorSchemeIndex2 = (STColorSchemeIndex) get_store().add_attribute_user(qName);
            }
            sTColorSchemeIndex2.set((XmlObject) sTColorSchemeIndex);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void xsetAccent4(STColorSchemeIndex sTColorSchemeIndex) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ACCENT4$16;
            STColorSchemeIndex sTColorSchemeIndex2 = (STColorSchemeIndex) typeStore.find_attribute_user(qName);
            if (sTColorSchemeIndex2 == null) {
                sTColorSchemeIndex2 = (STColorSchemeIndex) get_store().add_attribute_user(qName);
            }
            sTColorSchemeIndex2.set((XmlObject) sTColorSchemeIndex);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void xsetAccent5(STColorSchemeIndex sTColorSchemeIndex) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ACCENT5$18;
            STColorSchemeIndex sTColorSchemeIndex2 = (STColorSchemeIndex) typeStore.find_attribute_user(qName);
            if (sTColorSchemeIndex2 == null) {
                sTColorSchemeIndex2 = (STColorSchemeIndex) get_store().add_attribute_user(qName);
            }
            sTColorSchemeIndex2.set((XmlObject) sTColorSchemeIndex);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void xsetAccent6(STColorSchemeIndex sTColorSchemeIndex) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ACCENT6$20;
            STColorSchemeIndex sTColorSchemeIndex2 = (STColorSchemeIndex) typeStore.find_attribute_user(qName);
            if (sTColorSchemeIndex2 == null) {
                sTColorSchemeIndex2 = (STColorSchemeIndex) get_store().add_attribute_user(qName);
            }
            sTColorSchemeIndex2.set((XmlObject) sTColorSchemeIndex);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void xsetBg1(STColorSchemeIndex sTColorSchemeIndex) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BG1$2;
            STColorSchemeIndex sTColorSchemeIndex2 = (STColorSchemeIndex) typeStore.find_attribute_user(qName);
            if (sTColorSchemeIndex2 == null) {
                sTColorSchemeIndex2 = (STColorSchemeIndex) get_store().add_attribute_user(qName);
            }
            sTColorSchemeIndex2.set((XmlObject) sTColorSchemeIndex);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void xsetBg2(STColorSchemeIndex sTColorSchemeIndex) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BG2$6;
            STColorSchemeIndex sTColorSchemeIndex2 = (STColorSchemeIndex) typeStore.find_attribute_user(qName);
            if (sTColorSchemeIndex2 == null) {
                sTColorSchemeIndex2 = (STColorSchemeIndex) get_store().add_attribute_user(qName);
            }
            sTColorSchemeIndex2.set((XmlObject) sTColorSchemeIndex);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void xsetFolHlink(STColorSchemeIndex sTColorSchemeIndex) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FOLHLINK$24;
            STColorSchemeIndex sTColorSchemeIndex2 = (STColorSchemeIndex) typeStore.find_attribute_user(qName);
            if (sTColorSchemeIndex2 == null) {
                sTColorSchemeIndex2 = (STColorSchemeIndex) get_store().add_attribute_user(qName);
            }
            sTColorSchemeIndex2.set((XmlObject) sTColorSchemeIndex);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void xsetHlink(STColorSchemeIndex sTColorSchemeIndex) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HLINK$22;
            STColorSchemeIndex sTColorSchemeIndex2 = (STColorSchemeIndex) typeStore.find_attribute_user(qName);
            if (sTColorSchemeIndex2 == null) {
                sTColorSchemeIndex2 = (STColorSchemeIndex) get_store().add_attribute_user(qName);
            }
            sTColorSchemeIndex2.set((XmlObject) sTColorSchemeIndex);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void xsetTx1(STColorSchemeIndex sTColorSchemeIndex) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TX1$4;
            STColorSchemeIndex sTColorSchemeIndex2 = (STColorSchemeIndex) typeStore.find_attribute_user(qName);
            if (sTColorSchemeIndex2 == null) {
                sTColorSchemeIndex2 = (STColorSchemeIndex) get_store().add_attribute_user(qName);
            }
            sTColorSchemeIndex2.set((XmlObject) sTColorSchemeIndex);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void xsetTx2(STColorSchemeIndex sTColorSchemeIndex) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TX2$8;
            STColorSchemeIndex sTColorSchemeIndex2 = (STColorSchemeIndex) typeStore.find_attribute_user(qName);
            if (sTColorSchemeIndex2 == null) {
                sTColorSchemeIndex2 = (STColorSchemeIndex) get_store().add_attribute_user(qName);
            }
            sTColorSchemeIndex2.set((XmlObject) sTColorSchemeIndex);
        }
    }
}
