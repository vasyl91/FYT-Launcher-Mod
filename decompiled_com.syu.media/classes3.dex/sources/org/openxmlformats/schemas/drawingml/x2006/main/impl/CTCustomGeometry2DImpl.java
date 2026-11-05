package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuideList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomRect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTCustomGeometry2DImpl extends XmlComplexContentImpl implements CTCustomGeometry2D {
    private static final QName AVLST$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "avLst");
    private static final QName GDLST$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "gdLst");
    private static final QName AHLST$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "ahLst");
    private static final QName CXNLST$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "cxnLst");
    private static final QName RECT$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "rect");
    private static final QName PATHLST$10 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "pathLst");

    public CTCustomGeometry2DImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTAdjustHandleList addNewAhLst() {
        CTAdjustHandleList cTAdjustHandleList;
        synchronized (monitor()) {
            check_orphaned();
            cTAdjustHandleList = (CTAdjustHandleList) get_store().add_element_user(AHLST$4);
        }
        return cTAdjustHandleList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTGeomGuideList addNewAvLst() {
        CTGeomGuideList cTGeomGuideList;
        synchronized (monitor()) {
            check_orphaned();
            cTGeomGuideList = (CTGeomGuideList) get_store().add_element_user(AVLST$0);
        }
        return cTGeomGuideList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTConnectionSiteList addNewCxnLst() {
        CTConnectionSiteList cTConnectionSiteList;
        synchronized (monitor()) {
            check_orphaned();
            cTConnectionSiteList = (CTConnectionSiteList) get_store().add_element_user(CXNLST$6);
        }
        return cTConnectionSiteList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTGeomGuideList addNewGdLst() {
        CTGeomGuideList cTGeomGuideList;
        synchronized (monitor()) {
            check_orphaned();
            cTGeomGuideList = (CTGeomGuideList) get_store().add_element_user(GDLST$2);
        }
        return cTGeomGuideList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTPath2DList addNewPathLst() {
        CTPath2DList cTPath2DList;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DList = (CTPath2DList) get_store().add_element_user(PATHLST$10);
        }
        return cTPath2DList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTGeomRect addNewRect() {
        CTGeomRect cTGeomRect;
        synchronized (monitor()) {
            check_orphaned();
            cTGeomRect = (CTGeomRect) get_store().add_element_user(RECT$8);
        }
        return cTGeomRect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTAdjustHandleList getAhLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTAdjustHandleList cTAdjustHandleList = (CTAdjustHandleList) get_store().find_element_user(AHLST$4, 0);
            if (cTAdjustHandleList == null) {
                return null;
            }
            return cTAdjustHandleList;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTGeomGuideList getAvLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTGeomGuideList cTGeomGuideList = (CTGeomGuideList) get_store().find_element_user(AVLST$0, 0);
            if (cTGeomGuideList == null) {
                return null;
            }
            return cTGeomGuideList;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTConnectionSiteList getCxnLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTConnectionSiteList cTConnectionSiteList = (CTConnectionSiteList) get_store().find_element_user(CXNLST$6, 0);
            if (cTConnectionSiteList == null) {
                return null;
            }
            return cTConnectionSiteList;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTGeomGuideList getGdLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTGeomGuideList cTGeomGuideList = (CTGeomGuideList) get_store().find_element_user(GDLST$2, 0);
            if (cTGeomGuideList == null) {
                return null;
            }
            return cTGeomGuideList;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTPath2DList getPathLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTPath2DList cTPath2DList = (CTPath2DList) get_store().find_element_user(PATHLST$10, 0);
            if (cTPath2DList == null) {
                return null;
            }
            return cTPath2DList;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTGeomRect getRect() {
        synchronized (monitor()) {
            check_orphaned();
            CTGeomRect cTGeomRect = (CTGeomRect) get_store().find_element_user(RECT$8, 0);
            if (cTGeomRect == null) {
                return null;
            }
            return cTGeomRect;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public boolean isSetAhLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(AHLST$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public boolean isSetAvLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(AVLST$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public boolean isSetCxnLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CXNLST$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public boolean isSetGdLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(GDLST$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public boolean isSetRect() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RECT$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public void setAhLst(CTAdjustHandleList cTAdjustHandleList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AHLST$4;
            CTAdjustHandleList cTAdjustHandleList2 = (CTAdjustHandleList) typeStore.find_element_user(qName, 0);
            if (cTAdjustHandleList2 == null) {
                cTAdjustHandleList2 = (CTAdjustHandleList) get_store().add_element_user(qName);
            }
            cTAdjustHandleList2.set(cTAdjustHandleList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public void setAvLst(CTGeomGuideList cTGeomGuideList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AVLST$0;
            CTGeomGuideList cTGeomGuideList2 = (CTGeomGuideList) typeStore.find_element_user(qName, 0);
            if (cTGeomGuideList2 == null) {
                cTGeomGuideList2 = (CTGeomGuideList) get_store().add_element_user(qName);
            }
            cTGeomGuideList2.set(cTGeomGuideList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public void setCxnLst(CTConnectionSiteList cTConnectionSiteList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CXNLST$6;
            CTConnectionSiteList cTConnectionSiteList2 = (CTConnectionSiteList) typeStore.find_element_user(qName, 0);
            if (cTConnectionSiteList2 == null) {
                cTConnectionSiteList2 = (CTConnectionSiteList) get_store().add_element_user(qName);
            }
            cTConnectionSiteList2.set(cTConnectionSiteList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public void setGdLst(CTGeomGuideList cTGeomGuideList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GDLST$2;
            CTGeomGuideList cTGeomGuideList2 = (CTGeomGuideList) typeStore.find_element_user(qName, 0);
            if (cTGeomGuideList2 == null) {
                cTGeomGuideList2 = (CTGeomGuideList) get_store().add_element_user(qName);
            }
            cTGeomGuideList2.set(cTGeomGuideList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public void setPathLst(CTPath2DList cTPath2DList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PATHLST$10;
            CTPath2DList cTPath2DList2 = (CTPath2DList) typeStore.find_element_user(qName, 0);
            if (cTPath2DList2 == null) {
                cTPath2DList2 = (CTPath2DList) get_store().add_element_user(qName);
            }
            cTPath2DList2.set(cTPath2DList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public void setRect(CTGeomRect cTGeomRect) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RECT$8;
            CTGeomRect cTGeomRect2 = (CTGeomRect) typeStore.find_element_user(qName, 0);
            if (cTGeomRect2 == null) {
                cTGeomRect2 = (CTGeomRect) get_store().add_element_user(qName);
            }
            cTGeomRect2.set(cTGeomRect);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public void unsetAhLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(AHLST$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public void unsetAvLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(AVLST$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public void unsetCxnLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CXNLST$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public void unsetGdLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GDLST$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public void unsetRect() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RECT$8, 0);
        }
    }
}
