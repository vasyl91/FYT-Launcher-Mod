package com.microsoft.schemas.vml.impl;

import chip.FinalChip;
import com.microsoft.schemas.vml.CTTextPath;
import com.microsoft.schemas.vml.STTrueFalse;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class CTTextPathImpl extends XmlComplexContentImpl implements CTTextPath {
    private static final QName ID$0 = new QName(FinalChip.BSP_PLATFORM_Null, "id");
    private static final QName STYLE$2 = new QName(FinalChip.BSP_PLATFORM_Null, "style");
    private static final QName ON$4 = new QName(FinalChip.BSP_PLATFORM_Null, "on");
    private static final QName FITSHAPE$6 = new QName(FinalChip.BSP_PLATFORM_Null, "fitshape");
    private static final QName FITPATH$8 = new QName(FinalChip.BSP_PLATFORM_Null, "fitpath");
    private static final QName TRIM$10 = new QName(FinalChip.BSP_PLATFORM_Null, "trim");
    private static final QName XSCALE$12 = new QName(FinalChip.BSP_PLATFORM_Null, "xscale");
    private static final QName STRING$14 = new QName(FinalChip.BSP_PLATFORM_Null, "string");

    public CTTextPathImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public STTrueFalse.Enum getFitpath() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FITPATH$8);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public STTrueFalse.Enum getFitshape() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FITSHAPE$6);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ID$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public STTrueFalse.Enum getOn() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ON$4);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public String getString() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(STRING$14);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public String getStyle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(STYLE$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public STTrueFalse.Enum getTrim() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TRIM$10);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public STTrueFalse.Enum getXscale() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(XSCALE$12);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public boolean isSetFitpath() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FITPATH$8) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public boolean isSetFitshape() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FITSHAPE$6) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$0) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public boolean isSetOn() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ON$4) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public boolean isSetString() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STRING$14) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public boolean isSetStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STYLE$2) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public boolean isSetTrim() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TRIM$10) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public boolean isSetXscale() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(XSCALE$12) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public void setFitpath(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FITPATH$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public void setFitshape(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FITSHAPE$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public void setOn(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ON$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public void setString(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STRING$14;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public void setStyle(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLE$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public void setTrim(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TRIM$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public void setXscale(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = XSCALE$12;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public void unsetFitpath() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FITPATH$8);
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public void unsetFitshape() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FITSHAPE$6);
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$0);
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public void unsetOn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ON$4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public void unsetString() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STRING$14);
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public void unsetStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STYLE$2);
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public void unsetTrim() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TRIM$10);
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public void unsetXscale() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(XSCALE$12);
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public STTrueFalse xgetFitpath() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(FITPATH$8);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public STTrueFalse xgetFitshape() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(FITSHAPE$6);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public XmlString xgetId() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(ID$0);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public STTrueFalse xgetOn() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(ON$4);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public XmlString xgetString() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(STRING$14);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public XmlString xgetStyle() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(STYLE$2);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public STTrueFalse xgetTrim() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(TRIM$10);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public STTrueFalse xgetXscale() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(XSCALE$12);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public void xsetFitpath(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FITPATH$8;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set((XmlObject) sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public void xsetFitshape(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FITSHAPE$6;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set((XmlObject) sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public void xsetId(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$0;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public void xsetOn(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ON$4;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set((XmlObject) sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public void xsetString(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STRING$14;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public void xsetStyle(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLE$2;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public void xsetTrim(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TRIM$10;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set((XmlObject) sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextPath
    public void xsetXscale(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = XSCALE$12;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set((XmlObject) sTTrueFalse);
        }
    }
}
