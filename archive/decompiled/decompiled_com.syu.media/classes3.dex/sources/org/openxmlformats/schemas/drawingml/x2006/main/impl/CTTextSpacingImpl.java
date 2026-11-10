package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacingPercent;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacingPoint;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTTextSpacingImpl extends XmlComplexContentImpl implements CTTextSpacing {
    private static final QName SPCPCT$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "spcPct");
    private static final QName SPCPTS$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "spcPts");

    public CTTextSpacingImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing
    public CTTextSpacingPercent addNewSpcPct() {
        CTTextSpacingPercent cTTextSpacingPercent;
        synchronized (monitor()) {
            check_orphaned();
            cTTextSpacingPercent = (CTTextSpacingPercent) get_store().add_element_user(SPCPCT$0);
        }
        return cTTextSpacingPercent;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing
    public CTTextSpacingPoint addNewSpcPts() {
        CTTextSpacingPoint cTTextSpacingPoint;
        synchronized (monitor()) {
            check_orphaned();
            cTTextSpacingPoint = (CTTextSpacingPoint) get_store().add_element_user(SPCPTS$2);
        }
        return cTTextSpacingPoint;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing
    public CTTextSpacingPercent getSpcPct() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextSpacingPercent cTTextSpacingPercent = (CTTextSpacingPercent) get_store().find_element_user(SPCPCT$0, 0);
            if (cTTextSpacingPercent == null) {
                return null;
            }
            return cTTextSpacingPercent;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing
    public CTTextSpacingPoint getSpcPts() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextSpacingPoint cTTextSpacingPoint = (CTTextSpacingPoint) get_store().find_element_user(SPCPTS$2, 0);
            if (cTTextSpacingPoint == null) {
                return null;
            }
            return cTTextSpacingPoint;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing
    public boolean isSetSpcPct() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SPCPCT$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing
    public boolean isSetSpcPts() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SPCPTS$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing
    public void setSpcPct(CTTextSpacingPercent cTTextSpacingPercent) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPCPCT$0;
            CTTextSpacingPercent cTTextSpacingPercent2 = (CTTextSpacingPercent) typeStore.find_element_user(qName, 0);
            if (cTTextSpacingPercent2 == null) {
                cTTextSpacingPercent2 = (CTTextSpacingPercent) get_store().add_element_user(qName);
            }
            cTTextSpacingPercent2.set(cTTextSpacingPercent);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing
    public void setSpcPts(CTTextSpacingPoint cTTextSpacingPoint) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPCPTS$2;
            CTTextSpacingPoint cTTextSpacingPoint2 = (CTTextSpacingPoint) typeStore.find_element_user(qName, 0);
            if (cTTextSpacingPoint2 == null) {
                cTTextSpacingPoint2 = (CTTextSpacingPoint) get_store().add_element_user(qName);
            }
            cTTextSpacingPoint2.set(cTTextSpacingPoint);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing
    public void unsetSpcPct() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SPCPCT$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing
    public void unsetSpcPts() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SPCPTS$2, 0);
        }
    }
}
