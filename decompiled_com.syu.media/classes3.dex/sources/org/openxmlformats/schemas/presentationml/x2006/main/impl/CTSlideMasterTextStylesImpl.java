package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterTextStyles;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTSlideMasterTextStylesImpl extends XmlComplexContentImpl implements CTSlideMasterTextStyles {
    private static final QName TITLESTYLE$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "titleStyle");
    private static final QName BODYSTYLE$2 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "bodyStyle");
    private static final QName OTHERSTYLE$4 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "otherStyle");
    private static final QName EXTLST$6 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");

    public CTSlideMasterTextStylesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterTextStyles
    public CTTextListStyle addNewBodyStyle() {
        CTTextListStyle cTTextListStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTextListStyle = (CTTextListStyle) get_store().add_element_user(BODYSTYLE$2);
        }
        return cTTextListStyle;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterTextStyles
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$6);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterTextStyles
    public CTTextListStyle addNewOtherStyle() {
        CTTextListStyle cTTextListStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTextListStyle = (CTTextListStyle) get_store().add_element_user(OTHERSTYLE$4);
        }
        return cTTextListStyle;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterTextStyles
    public CTTextListStyle addNewTitleStyle() {
        CTTextListStyle cTTextListStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTextListStyle = (CTTextListStyle) get_store().add_element_user(TITLESTYLE$0);
        }
        return cTTextListStyle;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterTextStyles
    public CTTextListStyle getBodyStyle() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextListStyle cTTextListStyle = (CTTextListStyle) get_store().find_element_user(BODYSTYLE$2, 0);
            if (cTTextListStyle == null) {
                return null;
            }
            return cTTextListStyle;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterTextStyles
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList cTExtensionListFind_element_user = get_store().find_element_user(EXTLST$6, 0);
            if (cTExtensionListFind_element_user == null) {
                return null;
            }
            return cTExtensionListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterTextStyles
    public CTTextListStyle getOtherStyle() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextListStyle cTTextListStyle = (CTTextListStyle) get_store().find_element_user(OTHERSTYLE$4, 0);
            if (cTTextListStyle == null) {
                return null;
            }
            return cTTextListStyle;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterTextStyles
    public CTTextListStyle getTitleStyle() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextListStyle cTTextListStyle = (CTTextListStyle) get_store().find_element_user(TITLESTYLE$0, 0);
            if (cTTextListStyle == null) {
                return null;
            }
            return cTTextListStyle;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterTextStyles
    public boolean isSetBodyStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BODYSTYLE$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterTextStyles
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterTextStyles
    public boolean isSetOtherStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OTHERSTYLE$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterTextStyles
    public boolean isSetTitleStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TITLESTYLE$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterTextStyles
    public void setBodyStyle(CTTextListStyle cTTextListStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BODYSTYLE$2;
            CTTextListStyle cTTextListStyle2 = (CTTextListStyle) typeStore.find_element_user(qName, 0);
            if (cTTextListStyle2 == null) {
                cTTextListStyle2 = (CTTextListStyle) get_store().add_element_user(qName);
            }
            cTTextListStyle2.set(cTTextListStyle);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterTextStyles
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$6;
            CTExtensionList cTExtensionListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExtensionListFind_element_user == null) {
                cTExtensionListFind_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            cTExtensionListFind_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterTextStyles
    public void setOtherStyle(CTTextListStyle cTTextListStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OTHERSTYLE$4;
            CTTextListStyle cTTextListStyle2 = (CTTextListStyle) typeStore.find_element_user(qName, 0);
            if (cTTextListStyle2 == null) {
                cTTextListStyle2 = (CTTextListStyle) get_store().add_element_user(qName);
            }
            cTTextListStyle2.set(cTTextListStyle);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterTextStyles
    public void setTitleStyle(CTTextListStyle cTTextListStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TITLESTYLE$0;
            CTTextListStyle cTTextListStyle2 = (CTTextListStyle) typeStore.find_element_user(qName, 0);
            if (cTTextListStyle2 == null) {
                cTTextListStyle2 = (CTTextListStyle) get_store().add_element_user(qName);
            }
            cTTextListStyle2.set(cTTextListStyle);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterTextStyles
    public void unsetBodyStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BODYSTYLE$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterTextStyles
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterTextStyles
    public void unsetOtherStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OTHERSTYLE$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterTextStyles
    public void unsetTitleStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TITLESTYLE$0, 0);
        }
    }
}
