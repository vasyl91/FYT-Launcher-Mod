package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.SettingsDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class SettingsDocumentImpl extends XmlComplexContentImpl implements SettingsDocument {
    private static final QName SETTINGS$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "settings");

    public SettingsDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.SettingsDocument
    public CTSettings addNewSettings() {
        CTSettings cTSettingsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSettingsAdd_element_user = get_store().add_element_user(SETTINGS$0);
        }
        return cTSettingsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.SettingsDocument
    public CTSettings getSettings() {
        synchronized (monitor()) {
            check_orphaned();
            CTSettings cTSettingsFind_element_user = get_store().find_element_user(SETTINGS$0, 0);
            if (cTSettingsFind_element_user == null) {
                return null;
            }
            return cTSettingsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.SettingsDocument
    public void setSettings(CTSettings cTSettings) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SETTINGS$0;
            CTSettings cTSettingsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTSettingsFind_element_user == null) {
                cTSettingsFind_element_user = (CTSettings) get_store().add_element_user(qName);
            }
            cTSettingsFind_element_user.set(cTSettings);
        }
    }
}
