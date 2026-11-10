package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMapInfo;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.MapInfoDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class MapInfoDocumentImpl extends XmlComplexContentImpl implements MapInfoDocument {
    private static final QName MAPINFO$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "MapInfo");

    public MapInfoDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.MapInfoDocument
    public CTMapInfo addNewMapInfo() {
        CTMapInfo cTMapInfo;
        synchronized (monitor()) {
            check_orphaned();
            cTMapInfo = (CTMapInfo) get_store().add_element_user(MAPINFO$0);
        }
        return cTMapInfo;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.MapInfoDocument
    public CTMapInfo getMapInfo() {
        synchronized (monitor()) {
            check_orphaned();
            CTMapInfo cTMapInfo = (CTMapInfo) get_store().find_element_user(MAPINFO$0, 0);
            if (cTMapInfo == null) {
                return null;
            }
            return cTMapInfo;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.MapInfoDocument
    public void setMapInfo(CTMapInfo cTMapInfo) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAPINFO$0;
            CTMapInfo cTMapInfo2 = (CTMapInfo) typeStore.find_element_user(qName, 0);
            if (cTMapInfo2 == null) {
                cTMapInfo2 = (CTMapInfo) get_store().add_element_user(qName);
            }
            cTMapInfo2.set(cTMapInfo);
        }
    }
}
