package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlip;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTStretchInfoProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTileInfoProperties;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTBlipFillPropertiesImpl extends XmlComplexContentImpl implements CTBlipFillProperties {
    private static final QName BLIP$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "blip");
    private static final QName SRCRECT$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "srcRect");
    private static final QName TILE$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tile");
    private static final QName STRETCH$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "stretch");
    private static final QName DPI$8 = new QName("", "dpi");
    private static final QName ROTWITHSHAPE$10 = new QName("", "rotWithShape");

    public CTBlipFillPropertiesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public CTBlip addNewBlip() {
        CTBlip cTBlip;
        synchronized (monitor()) {
            check_orphaned();
            cTBlip = (CTBlip) get_store().add_element_user(BLIP$0);
        }
        return cTBlip;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public CTRelativeRect addNewSrcRect() {
        CTRelativeRect cTRelativeRect;
        synchronized (monitor()) {
            check_orphaned();
            cTRelativeRect = (CTRelativeRect) get_store().add_element_user(SRCRECT$2);
        }
        return cTRelativeRect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public CTStretchInfoProperties addNewStretch() {
        CTStretchInfoProperties cTStretchInfoProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTStretchInfoProperties = (CTStretchInfoProperties) get_store().add_element_user(STRETCH$6);
        }
        return cTStretchInfoProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public CTTileInfoProperties addNewTile() {
        CTTileInfoProperties cTTileInfoPropertiesAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTileInfoPropertiesAdd_element_user = get_store().add_element_user(TILE$4);
        }
        return cTTileInfoPropertiesAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public CTBlip getBlip() {
        synchronized (monitor()) {
            check_orphaned();
            CTBlip cTBlip = (CTBlip) get_store().find_element_user(BLIP$0, 0);
            if (cTBlip == null) {
                return null;
            }
            return cTBlip;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public long getDpi() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DPI$8);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public CTRelativeRect getSrcRect() {
        synchronized (monitor()) {
            check_orphaned();
            CTRelativeRect cTRelativeRect = (CTRelativeRect) get_store().find_element_user(SRCRECT$2, 0);
            if (cTRelativeRect == null) {
                return null;
            }
            return cTRelativeRect;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public CTStretchInfoProperties getStretch() {
        synchronized (monitor()) {
            check_orphaned();
            CTStretchInfoProperties cTStretchInfoProperties = (CTStretchInfoProperties) get_store().find_element_user(STRETCH$6, 0);
            if (cTStretchInfoProperties == null) {
                return null;
            }
            return cTStretchInfoProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public CTTileInfoProperties getTile() {
        synchronized (monitor()) {
            check_orphaned();
            CTTileInfoProperties cTTileInfoPropertiesFind_element_user = get_store().find_element_user(TILE$4, 0);
            if (cTTileInfoPropertiesFind_element_user == null) {
                return null;
            }
            return cTTileInfoPropertiesFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public boolean isSetBlip() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BLIP$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public boolean isSetDpi() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DPI$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public boolean isSetRotWithShape() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ROTWITHSHAPE$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public boolean isSetSrcRect() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SRCRECT$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public boolean isSetStretch() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(STRETCH$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public boolean isSetTile() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TILE$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public void setBlip(CTBlip cTBlip) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLIP$0;
            CTBlip cTBlip2 = (CTBlip) typeStore.find_element_user(qName, 0);
            if (cTBlip2 == null) {
                cTBlip2 = (CTBlip) get_store().add_element_user(qName);
            }
            cTBlip2.set(cTBlip);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public void setDpi(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DPI$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public void setSrcRect(CTRelativeRect cTRelativeRect) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SRCRECT$2;
            CTRelativeRect cTRelativeRect2 = (CTRelativeRect) typeStore.find_element_user(qName, 0);
            if (cTRelativeRect2 == null) {
                cTRelativeRect2 = (CTRelativeRect) get_store().add_element_user(qName);
            }
            cTRelativeRect2.set(cTRelativeRect);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public void setStretch(CTStretchInfoProperties cTStretchInfoProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STRETCH$6;
            CTStretchInfoProperties cTStretchInfoProperties2 = (CTStretchInfoProperties) typeStore.find_element_user(qName, 0);
            if (cTStretchInfoProperties2 == null) {
                cTStretchInfoProperties2 = (CTStretchInfoProperties) get_store().add_element_user(qName);
            }
            cTStretchInfoProperties2.set(cTStretchInfoProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public void setTile(CTTileInfoProperties cTTileInfoProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TILE$4;
            CTTileInfoProperties cTTileInfoPropertiesFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTileInfoPropertiesFind_element_user == null) {
                cTTileInfoPropertiesFind_element_user = (CTTileInfoProperties) get_store().add_element_user(qName);
            }
            cTTileInfoPropertiesFind_element_user.set(cTTileInfoProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public void unsetBlip() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BLIP$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public void unsetDpi() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DPI$8);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public void unsetRotWithShape() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ROTWITHSHAPE$10);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public void unsetSrcRect() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SRCRECT$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public void unsetStretch() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STRETCH$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public void unsetTile() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TILE$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public XmlUnsignedInt xgetDpi() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(DPI$8);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public XmlBoolean xgetRotWithShape() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(ROTWITHSHAPE$10);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
    public void xsetDpi(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DPI$8;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties
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
