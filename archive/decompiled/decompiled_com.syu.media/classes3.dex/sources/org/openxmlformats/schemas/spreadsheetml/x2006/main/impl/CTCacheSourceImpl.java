package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheSource;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConsolidation;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheetSource;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSourceType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTCacheSourceImpl extends XmlComplexContentImpl implements CTCacheSource {
    private static final QName WORKSHEETSOURCE$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "worksheetSource");
    private static final QName CONSOLIDATION$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "consolidation");
    private static final QName EXTLST$4 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
    private static final QName TYPE$6 = new QName("", JamXmlElements.TYPE);
    private static final QName CONNECTIONID$8 = new QName("", "connectionId");

    public CTCacheSourceImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheSource
    public CTConsolidation addNewConsolidation() {
        CTConsolidation cTConsolidationAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTConsolidationAdd_element_user = get_store().add_element_user(CONSOLIDATION$2);
        }
        return cTConsolidationAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheSource
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$4);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheSource
    public CTWorksheetSource addNewWorksheetSource() {
        CTWorksheetSource cTWorksheetSource;
        synchronized (monitor()) {
            check_orphaned();
            cTWorksheetSource = (CTWorksheetSource) get_store().add_element_user(WORKSHEETSOURCE$0);
        }
        return cTWorksheetSource;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheSource
    public long getConnectionId() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONNECTIONID$8;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheSource
    public CTConsolidation getConsolidation() {
        synchronized (monitor()) {
            check_orphaned();
            CTConsolidation cTConsolidationFind_element_user = get_store().find_element_user(CONSOLIDATION$2, 0);
            if (cTConsolidationFind_element_user == null) {
                return null;
            }
            return cTConsolidationFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheSource
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList cTExtensionListFind_element_user = get_store().find_element_user(EXTLST$4, 0);
            if (cTExtensionListFind_element_user == null) {
                return null;
            }
            return cTExtensionListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheSource
    public STSourceType.Enum getType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TYPE$6);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STSourceType.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheSource
    public CTWorksheetSource getWorksheetSource() {
        synchronized (monitor()) {
            check_orphaned();
            CTWorksheetSource cTWorksheetSource = (CTWorksheetSource) get_store().find_element_user(WORKSHEETSOURCE$0, 0);
            if (cTWorksheetSource == null) {
                return null;
            }
            return cTWorksheetSource;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheSource
    public boolean isSetConnectionId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CONNECTIONID$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheSource
    public boolean isSetConsolidation() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CONSOLIDATION$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheSource
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheSource
    public boolean isSetWorksheetSource() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(WORKSHEETSOURCE$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheSource
    public void setConnectionId(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONNECTIONID$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheSource
    public void setConsolidation(CTConsolidation cTConsolidation) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONSOLIDATION$2;
            CTConsolidation cTConsolidationFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTConsolidationFind_element_user == null) {
                cTConsolidationFind_element_user = (CTConsolidation) get_store().add_element_user(qName);
            }
            cTConsolidationFind_element_user.set(cTConsolidation);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheSource
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$4;
            CTExtensionList cTExtensionListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExtensionListFind_element_user == null) {
                cTExtensionListFind_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            cTExtensionListFind_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheSource
    public void setType(STSourceType.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheSource
    public void setWorksheetSource(CTWorksheetSource cTWorksheetSource) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WORKSHEETSOURCE$0;
            CTWorksheetSource cTWorksheetSource2 = (CTWorksheetSource) typeStore.find_element_user(qName, 0);
            if (cTWorksheetSource2 == null) {
                cTWorksheetSource2 = (CTWorksheetSource) get_store().add_element_user(qName);
            }
            cTWorksheetSource2.set(cTWorksheetSource);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheSource
    public void unsetConnectionId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CONNECTIONID$8);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheSource
    public void unsetConsolidation() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CONSOLIDATION$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheSource
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheSource
    public void unsetWorksheetSource() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WORKSHEETSOURCE$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheSource
    public XmlUnsignedInt xgetConnectionId() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONNECTIONID$8;
            xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_default_attribute_value(qName);
            }
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheSource
    public STSourceType xgetType() {
        STSourceType sTSourceType;
        synchronized (monitor()) {
            check_orphaned();
            sTSourceType = (STSourceType) get_store().find_attribute_user(TYPE$6);
        }
        return sTSourceType;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheSource
    public void xsetConnectionId(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONNECTIONID$8;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheSource
    public void xsetType(STSourceType sTSourceType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$6;
            STSourceType sTSourceType2 = (STSourceType) typeStore.find_attribute_user(qName);
            if (sTSourceType2 == null) {
                sTSourceType2 = (STSourceType) get_store().add_attribute_user(qName);
            }
            sTSourceType2.set((XmlObject) sTSourceType);
        }
    }
}
