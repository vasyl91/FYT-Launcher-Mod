package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLinearShadeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPathShadeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect;
import org.openxmlformats.schemas.drawingml.x2006.main.STTileFlipMode;
import org.openxmlformats.schemas.drawingml.x2006.main.STTileFlipMode$Enum;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTGradientFillPropertiesImpl extends XmlComplexContentImpl implements CTGradientFillProperties {
    private static final QName GSLST$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "gsLst");
    private static final QName LIN$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lin");
    private static final QName PATH$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "path");
    private static final QName TILERECT$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tileRect");
    private static final QName FLIP$8 = new QName("", "flip");
    private static final QName ROTWITHSHAPE$10 = new QName("", "rotWithShape");

    public CTGradientFillPropertiesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public CTGradientStopList addNewGsLst() {
        CTGradientStopList cTGradientStopList;
        synchronized (monitor()) {
            check_orphaned();
            cTGradientStopList = (CTGradientStopList) get_store().add_element_user(GSLST$0);
        }
        return cTGradientStopList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public CTLinearShadeProperties addNewLin() {
        CTLinearShadeProperties cTLinearShadeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTLinearShadeProperties = (CTLinearShadeProperties) get_store().add_element_user(LIN$2);
        }
        return cTLinearShadeProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public CTPathShadeProperties addNewPath() {
        CTPathShadeProperties cTPathShadeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTPathShadeProperties = (CTPathShadeProperties) get_store().add_element_user(PATH$4);
        }
        return cTPathShadeProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public CTRelativeRect addNewTileRect() {
        CTRelativeRect cTRelativeRect;
        synchronized (monitor()) {
            check_orphaned();
            cTRelativeRect = (CTRelativeRect) get_store().add_element_user(TILERECT$6);
        }
        return cTRelativeRect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public STTileFlipMode$Enum getFlip() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FLIP$8);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTileFlipMode$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public CTGradientStopList getGsLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTGradientStopList cTGradientStopList = (CTGradientStopList) get_store().find_element_user(GSLST$0, 0);
            if (cTGradientStopList == null) {
                return null;
            }
            return cTGradientStopList;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public CTLinearShadeProperties getLin() {
        synchronized (monitor()) {
            check_orphaned();
            CTLinearShadeProperties cTLinearShadeProperties = (CTLinearShadeProperties) get_store().find_element_user(LIN$2, 0);
            if (cTLinearShadeProperties == null) {
                return null;
            }
            return cTLinearShadeProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public CTPathShadeProperties getPath() {
        synchronized (monitor()) {
            check_orphaned();
            CTPathShadeProperties cTPathShadeProperties = (CTPathShadeProperties) get_store().find_element_user(PATH$4, 0);
            if (cTPathShadeProperties == null) {
                return null;
            }
            return cTPathShadeProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public boolean getRotWithShape() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ROTWITHSHAPE$10);
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public CTRelativeRect getTileRect() {
        synchronized (monitor()) {
            check_orphaned();
            CTRelativeRect cTRelativeRect = (CTRelativeRect) get_store().find_element_user(TILERECT$6, 0);
            if (cTRelativeRect == null) {
                return null;
            }
            return cTRelativeRect;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public boolean isSetFlip() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FLIP$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public boolean isSetGsLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(GSLST$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public boolean isSetLin() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LIN$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public boolean isSetPath() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PATH$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public boolean isSetRotWithShape() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ROTWITHSHAPE$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public boolean isSetTileRect() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TILERECT$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public void setFlip(STTileFlipMode$Enum sTTileFlipMode$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FLIP$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTileFlipMode$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public void setGsLst(CTGradientStopList cTGradientStopList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GSLST$0;
            CTGradientStopList cTGradientStopList2 = (CTGradientStopList) typeStore.find_element_user(qName, 0);
            if (cTGradientStopList2 == null) {
                cTGradientStopList2 = (CTGradientStopList) get_store().add_element_user(qName);
            }
            cTGradientStopList2.set(cTGradientStopList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public void setLin(CTLinearShadeProperties cTLinearShadeProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LIN$2;
            CTLinearShadeProperties cTLinearShadeProperties2 = (CTLinearShadeProperties) typeStore.find_element_user(qName, 0);
            if (cTLinearShadeProperties2 == null) {
                cTLinearShadeProperties2 = (CTLinearShadeProperties) get_store().add_element_user(qName);
            }
            cTLinearShadeProperties2.set(cTLinearShadeProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public void setPath(CTPathShadeProperties cTPathShadeProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PATH$4;
            CTPathShadeProperties cTPathShadeProperties2 = (CTPathShadeProperties) typeStore.find_element_user(qName, 0);
            if (cTPathShadeProperties2 == null) {
                cTPathShadeProperties2 = (CTPathShadeProperties) get_store().add_element_user(qName);
            }
            cTPathShadeProperties2.set(cTPathShadeProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public void setRotWithShape(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ROTWITHSHAPE$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public void setTileRect(CTRelativeRect cTRelativeRect) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TILERECT$6;
            CTRelativeRect cTRelativeRect2 = (CTRelativeRect) typeStore.find_element_user(qName, 0);
            if (cTRelativeRect2 == null) {
                cTRelativeRect2 = (CTRelativeRect) get_store().add_element_user(qName);
            }
            cTRelativeRect2.set(cTRelativeRect);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public void unsetFlip() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FLIP$8);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public void unsetGsLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GSLST$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public void unsetLin() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LIN$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public void unsetPath() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PATH$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public void unsetRotWithShape() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ROTWITHSHAPE$10);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public void unsetTileRect() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TILERECT$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public STTileFlipMode xgetFlip() {
        STTileFlipMode sTTileFlipModeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTileFlipModeFind_attribute_user = get_store().find_attribute_user(FLIP$8);
        }
        return sTTileFlipModeFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public XmlBoolean xgetRotWithShape() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(ROTWITHSHAPE$10);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public void xsetFlip(STTileFlipMode sTTileFlipMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FLIP$8;
            STTileFlipMode sTTileFlipModeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTileFlipModeFind_attribute_user == null) {
                sTTileFlipModeFind_attribute_user = (STTileFlipMode) get_store().add_attribute_user(qName);
            }
            sTTileFlipModeFind_attribute_user.set(sTTileFlipMode);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties
    public void xsetRotWithShape(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ROTWITHSHAPE$10;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }
}
