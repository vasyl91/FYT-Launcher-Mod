package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTMarker;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTMarkerSize;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTMarkerStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTMarkerImpl extends XmlComplexContentImpl implements CTMarker {
    private static final QName SYMBOL$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "symbol");
    private static final QName SIZE$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "size");
    private static final QName SPPR$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "spPr");
    private static final QName EXTLST$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst");

    public CTMarkerImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTMarker
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$6);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTMarker
    public CTMarkerSize addNewSize() {
        CTMarkerSize cTMarkerSizeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkerSizeAdd_element_user = get_store().add_element_user(SIZE$2);
        }
        return cTMarkerSizeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTMarker
    public CTShapeProperties addNewSpPr() {
        CTShapeProperties cTShapeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeProperties = (CTShapeProperties) get_store().add_element_user(SPPR$4);
        }
        return cTShapeProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTMarker
    public CTMarkerStyle addNewSymbol() {
        CTMarkerStyle cTMarkerStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkerStyle = (CTMarkerStyle) get_store().add_element_user(SYMBOL$0);
        }
        return cTMarkerStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTMarker
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTMarker
    public CTMarkerSize getSize() {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkerSize cTMarkerSizeFind_element_user = get_store().find_element_user(SIZE$2, 0);
            if (cTMarkerSizeFind_element_user == null) {
                return null;
            }
            return cTMarkerSizeFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTMarker
    public CTShapeProperties getSpPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTShapeProperties cTShapeProperties = (CTShapeProperties) get_store().find_element_user(SPPR$4, 0);
            if (cTShapeProperties == null) {
                return null;
            }
            return cTShapeProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTMarker
    public CTMarkerStyle getSymbol() {
        synchronized (monitor()) {
            check_orphaned();
            CTMarkerStyle cTMarkerStyle = (CTMarkerStyle) get_store().find_element_user(SYMBOL$0, 0);
            if (cTMarkerStyle == null) {
                return null;
            }
            return cTMarkerStyle;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTMarker
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTMarker
    public boolean isSetSize() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SIZE$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTMarker
    public boolean isSetSpPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SPPR$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTMarker
    public boolean isSetSymbol() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SYMBOL$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTMarker
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTMarker
    public void setSize(CTMarkerSize cTMarkerSize) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIZE$2;
            CTMarkerSize cTMarkerSizeFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTMarkerSizeFind_element_user == null) {
                cTMarkerSizeFind_element_user = (CTMarkerSize) get_store().add_element_user(qName);
            }
            cTMarkerSizeFind_element_user.set(cTMarkerSize);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTMarker
    public void setSpPr(CTShapeProperties cTShapeProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPPR$4;
            CTShapeProperties cTShapeProperties2 = (CTShapeProperties) typeStore.find_element_user(qName, 0);
            if (cTShapeProperties2 == null) {
                cTShapeProperties2 = (CTShapeProperties) get_store().add_element_user(qName);
            }
            cTShapeProperties2.set(cTShapeProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTMarker
    public void setSymbol(CTMarkerStyle cTMarkerStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SYMBOL$0;
            CTMarkerStyle cTMarkerStyle2 = (CTMarkerStyle) typeStore.find_element_user(qName, 0);
            if (cTMarkerStyle2 == null) {
                cTMarkerStyle2 = (CTMarkerStyle) get_store().add_element_user(qName);
            }
            cTMarkerStyle2.set(cTMarkerStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTMarker
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTMarker
    public void unsetSize() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SIZE$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTMarker
    public void unsetSpPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SPPR$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTMarker
    public void unsetSymbol() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SYMBOL$0, 0);
        }
    }
}
