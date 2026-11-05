package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.ColorsType;
import com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType;
import com.microsoft.schemas.office.visio.x2012.main.DocumentSheetType;
import com.microsoft.schemas.office.visio.x2012.main.EventListType;
import com.microsoft.schemas.office.visio.x2012.main.FaceNamesType;
import com.microsoft.schemas.office.visio.x2012.main.HeaderFooterType;
import com.microsoft.schemas.office.visio.x2012.main.PublishSettingsType;
import com.microsoft.schemas.office.visio.x2012.main.StyleSheetsType;
import com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class VisioDocumentTypeImpl extends XmlComplexContentImpl implements VisioDocumentType {
    private static final QName DOCUMENTSETTINGS$0 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "DocumentSettings");
    private static final QName COLORS$2 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "Colors");
    private static final QName FACENAMES$4 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "FaceNames");
    private static final QName STYLESHEETS$6 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "StyleSheets");
    private static final QName DOCUMENTSHEET$8 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "DocumentSheet");
    private static final QName EVENTLIST$10 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "EventList");
    private static final QName HEADERFOOTER$12 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "HeaderFooter");
    private static final QName PUBLISHSETTINGS$14 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "PublishSettings");

    public VisioDocumentTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public ColorsType addNewColors() {
        ColorsType colorsTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            colorsTypeAdd_element_user = get_store().add_element_user(COLORS$2);
        }
        return colorsTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public DocumentSettingsType addNewDocumentSettings() {
        DocumentSettingsType documentSettingsTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            documentSettingsTypeAdd_element_user = get_store().add_element_user(DOCUMENTSETTINGS$0);
        }
        return documentSettingsTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public DocumentSheetType addNewDocumentSheet() {
        DocumentSheetType documentSheetTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            documentSheetTypeAdd_element_user = get_store().add_element_user(DOCUMENTSHEET$8);
        }
        return documentSheetTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public EventListType addNewEventList() {
        EventListType eventListTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            eventListTypeAdd_element_user = get_store().add_element_user(EVENTLIST$10);
        }
        return eventListTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public FaceNamesType addNewFaceNames() {
        FaceNamesType faceNamesTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            faceNamesTypeAdd_element_user = get_store().add_element_user(FACENAMES$4);
        }
        return faceNamesTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public HeaderFooterType addNewHeaderFooter() {
        HeaderFooterType headerFooterTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            headerFooterTypeAdd_element_user = get_store().add_element_user(HEADERFOOTER$12);
        }
        return headerFooterTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public PublishSettingsType addNewPublishSettings() {
        PublishSettingsType publishSettingsTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            publishSettingsTypeAdd_element_user = get_store().add_element_user(PUBLISHSETTINGS$14);
        }
        return publishSettingsTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public StyleSheetsType addNewStyleSheets() {
        StyleSheetsType styleSheetsTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            styleSheetsTypeAdd_element_user = get_store().add_element_user(STYLESHEETS$6);
        }
        return styleSheetsTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public ColorsType getColors() {
        synchronized (monitor()) {
            check_orphaned();
            ColorsType colorsTypeFind_element_user = get_store().find_element_user(COLORS$2, 0);
            if (colorsTypeFind_element_user == null) {
                return null;
            }
            return colorsTypeFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public DocumentSettingsType getDocumentSettings() {
        synchronized (monitor()) {
            check_orphaned();
            DocumentSettingsType documentSettingsTypeFind_element_user = get_store().find_element_user(DOCUMENTSETTINGS$0, 0);
            if (documentSettingsTypeFind_element_user == null) {
                return null;
            }
            return documentSettingsTypeFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public DocumentSheetType getDocumentSheet() {
        synchronized (monitor()) {
            check_orphaned();
            DocumentSheetType documentSheetTypeFind_element_user = get_store().find_element_user(DOCUMENTSHEET$8, 0);
            if (documentSheetTypeFind_element_user == null) {
                return null;
            }
            return documentSheetTypeFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public EventListType getEventList() {
        synchronized (monitor()) {
            check_orphaned();
            EventListType eventListTypeFind_element_user = get_store().find_element_user(EVENTLIST$10, 0);
            if (eventListTypeFind_element_user == null) {
                return null;
            }
            return eventListTypeFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public FaceNamesType getFaceNames() {
        synchronized (monitor()) {
            check_orphaned();
            FaceNamesType faceNamesTypeFind_element_user = get_store().find_element_user(FACENAMES$4, 0);
            if (faceNamesTypeFind_element_user == null) {
                return null;
            }
            return faceNamesTypeFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public HeaderFooterType getHeaderFooter() {
        synchronized (monitor()) {
            check_orphaned();
            HeaderFooterType headerFooterTypeFind_element_user = get_store().find_element_user(HEADERFOOTER$12, 0);
            if (headerFooterTypeFind_element_user == null) {
                return null;
            }
            return headerFooterTypeFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public PublishSettingsType getPublishSettings() {
        synchronized (monitor()) {
            check_orphaned();
            PublishSettingsType publishSettingsTypeFind_element_user = get_store().find_element_user(PUBLISHSETTINGS$14, 0);
            if (publishSettingsTypeFind_element_user == null) {
                return null;
            }
            return publishSettingsTypeFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public StyleSheetsType getStyleSheets() {
        synchronized (monitor()) {
            check_orphaned();
            StyleSheetsType styleSheetsTypeFind_element_user = get_store().find_element_user(STYLESHEETS$6, 0);
            if (styleSheetsTypeFind_element_user == null) {
                return null;
            }
            return styleSheetsTypeFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public boolean isSetColors() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(COLORS$2) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public boolean isSetDocumentSettings() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DOCUMENTSETTINGS$0) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public boolean isSetDocumentSheet() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DOCUMENTSHEET$8) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public boolean isSetEventList() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EVENTLIST$10) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public boolean isSetFaceNames() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FACENAMES$4) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public boolean isSetHeaderFooter() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HEADERFOOTER$12) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public boolean isSetPublishSettings() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PUBLISHSETTINGS$14) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public boolean isSetStyleSheets() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(STYLESHEETS$6) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public void setColors(ColorsType colorsType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLORS$2;
            ColorsType colorsTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (colorsTypeFind_element_user == null) {
                colorsTypeFind_element_user = (ColorsType) get_store().add_element_user(qName);
            }
            colorsTypeFind_element_user.set(colorsType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public void setDocumentSettings(DocumentSettingsType documentSettingsType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DOCUMENTSETTINGS$0;
            DocumentSettingsType documentSettingsTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (documentSettingsTypeFind_element_user == null) {
                documentSettingsTypeFind_element_user = (DocumentSettingsType) get_store().add_element_user(qName);
            }
            documentSettingsTypeFind_element_user.set(documentSettingsType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public void setDocumentSheet(DocumentSheetType documentSheetType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DOCUMENTSHEET$8;
            DocumentSheetType documentSheetTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (documentSheetTypeFind_element_user == null) {
                documentSheetTypeFind_element_user = (DocumentSheetType) get_store().add_element_user(qName);
            }
            documentSheetTypeFind_element_user.set(documentSheetType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public void setEventList(EventListType eventListType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EVENTLIST$10;
            EventListType eventListTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (eventListTypeFind_element_user == null) {
                eventListTypeFind_element_user = (EventListType) get_store().add_element_user(qName);
            }
            eventListTypeFind_element_user.set(eventListType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public void setFaceNames(FaceNamesType faceNamesType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FACENAMES$4;
            FaceNamesType faceNamesTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (faceNamesTypeFind_element_user == null) {
                faceNamesTypeFind_element_user = (FaceNamesType) get_store().add_element_user(qName);
            }
            faceNamesTypeFind_element_user.set(faceNamesType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public void setHeaderFooter(HeaderFooterType headerFooterType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HEADERFOOTER$12;
            HeaderFooterType headerFooterTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (headerFooterTypeFind_element_user == null) {
                headerFooterTypeFind_element_user = (HeaderFooterType) get_store().add_element_user(qName);
            }
            headerFooterTypeFind_element_user.set(headerFooterType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public void setPublishSettings(PublishSettingsType publishSettingsType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PUBLISHSETTINGS$14;
            PublishSettingsType publishSettingsTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (publishSettingsTypeFind_element_user == null) {
                publishSettingsTypeFind_element_user = (PublishSettingsType) get_store().add_element_user(qName);
            }
            publishSettingsTypeFind_element_user.set(publishSettingsType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public void setStyleSheets(StyleSheetsType styleSheetsType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLESHEETS$6;
            StyleSheetsType styleSheetsTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (styleSheetsTypeFind_element_user == null) {
                styleSheetsTypeFind_element_user = (StyleSheetsType) get_store().add_element_user(qName);
            }
            styleSheetsTypeFind_element_user.set(styleSheetsType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public void unsetColors() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COLORS$2, 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public void unsetDocumentSettings() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DOCUMENTSETTINGS$0, 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public void unsetDocumentSheet() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DOCUMENTSHEET$8, 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public void unsetEventList() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EVENTLIST$10, 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public void unsetFaceNames() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FACENAMES$4, 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public void unsetHeaderFooter() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HEADERFOOTER$12, 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public void unsetPublishSettings() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PUBLISHSETTINGS$14, 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType
    public void unsetStyleSheets() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STYLESHEETS$6, 0);
        }
    }
}
