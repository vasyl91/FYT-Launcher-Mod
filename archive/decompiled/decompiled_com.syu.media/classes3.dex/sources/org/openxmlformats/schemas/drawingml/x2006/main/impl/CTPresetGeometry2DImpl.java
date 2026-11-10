package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuideList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTPresetGeometry2DImpl extends XmlComplexContentImpl implements CTPresetGeometry2D {
    private static final QName AVLST$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "avLst");
    private static final QName PRST$2 = new QName("", "prst");

    public CTPresetGeometry2DImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D
    public CTGeomGuideList addNewAvLst() {
        CTGeomGuideList cTGeomGuideList;
        synchronized (monitor()) {
            check_orphaned();
            cTGeomGuideList = (CTGeomGuideList) get_store().add_element_user(AVLST$0);
        }
        return cTGeomGuideList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D
    public STShapeType.Enum getPrst() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(PRST$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STShapeType.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D
    public boolean isSetAvLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(AVLST$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D
    public void setPrst(STShapeType.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRST$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D
    public void unsetAvLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(AVLST$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D
    public STShapeType xgetPrst() {
        STShapeType sTShapeType;
        synchronized (monitor()) {
            check_orphaned();
            sTShapeType = (STShapeType) get_store().find_attribute_user(PRST$2);
        }
        return sTShapeType;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D
    public void xsetPrst(STShapeType sTShapeType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRST$2;
            STShapeType sTShapeType2 = (STShapeType) typeStore.find_attribute_user(qName);
            if (sTShapeType2 == null) {
                sTShapeType2 = (STShapeType) get_store().add_attribute_user(qName);
            }
            sTShapeType2.set((XmlObject) sTShapeType);
        }
    }
}
