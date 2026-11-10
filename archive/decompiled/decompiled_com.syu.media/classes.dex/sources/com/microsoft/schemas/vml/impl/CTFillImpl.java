package com.microsoft.schemas.vml.impl;

import chip.FinalChip;
import com.microsoft.schemas.office.office.STTrueFalse$Enum;
import com.microsoft.schemas.vml.CTFill;
import com.microsoft.schemas.vml.STColorType;
import com.microsoft.schemas.vml.STFillMethod;
import com.microsoft.schemas.vml.STFillMethod$Enum;
import com.microsoft.schemas.vml.STFillType;
import com.microsoft.schemas.vml.STFillType$Enum;
import com.microsoft.schemas.vml.STImageAspect;
import com.microsoft.schemas.vml.STImageAspect$Enum;
import com.microsoft.schemas.vml.STTrueFalse;
import com.syu.media.provider.Media;
import java.math.BigDecimal;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlDecimal;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class CTFillImpl extends XmlComplexContentImpl implements CTFill {
    private static final QName FILL$0 = new QName("urn:schemas-microsoft-com:office:office", "fill");
    private static final QName ID$2 = new QName(FinalChip.BSP_PLATFORM_Null, "id");
    private static final QName TYPE$4 = new QName(FinalChip.BSP_PLATFORM_Null, Media.TYPE);
    private static final QName ON$6 = new QName(FinalChip.BSP_PLATFORM_Null, "on");
    private static final QName COLOR$8 = new QName(FinalChip.BSP_PLATFORM_Null, "color");
    private static final QName OPACITY$10 = new QName(FinalChip.BSP_PLATFORM_Null, "opacity");
    private static final QName COLOR2$12 = new QName(FinalChip.BSP_PLATFORM_Null, "color2");
    private static final QName SRC$14 = new QName(FinalChip.BSP_PLATFORM_Null, "src");
    private static final QName HREF$16 = new QName("urn:schemas-microsoft-com:office:office", "href");
    private static final QName ALTHREF$18 = new QName("urn:schemas-microsoft-com:office:office", "althref");
    private static final QName SIZE$20 = new QName(FinalChip.BSP_PLATFORM_Null, "size");
    private static final QName ORIGIN$22 = new QName(FinalChip.BSP_PLATFORM_Null, "origin");
    private static final QName POSITION$24 = new QName(FinalChip.BSP_PLATFORM_Null, "position");
    private static final QName ASPECT$26 = new QName(FinalChip.BSP_PLATFORM_Null, "aspect");
    private static final QName COLORS$28 = new QName(FinalChip.BSP_PLATFORM_Null, "colors");
    private static final QName ANGLE$30 = new QName(FinalChip.BSP_PLATFORM_Null, "angle");
    private static final QName ALIGNSHAPE$32 = new QName(FinalChip.BSP_PLATFORM_Null, "alignshape");
    private static final QName FOCUS$34 = new QName(FinalChip.BSP_PLATFORM_Null, "focus");
    private static final QName FOCUSSIZE$36 = new QName(FinalChip.BSP_PLATFORM_Null, "focussize");
    private static final QName FOCUSPOSITION$38 = new QName(FinalChip.BSP_PLATFORM_Null, "focusposition");
    private static final QName METHOD$40 = new QName(FinalChip.BSP_PLATFORM_Null, "method");
    private static final QName DETECTMOUSECLICK$42 = new QName("urn:schemas-microsoft-com:office:office", "detectmouseclick");
    private static final QName TITLE$44 = new QName("urn:schemas-microsoft-com:office:office", "title");
    private static final QName OPACITY2$46 = new QName("urn:schemas-microsoft-com:office:office", "opacity2");
    private static final QName RECOLOR$48 = new QName(FinalChip.BSP_PLATFORM_Null, "recolor");
    private static final QName ROTATE$50 = new QName(FinalChip.BSP_PLATFORM_Null, "rotate");
    private static final QName ID2$52 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "id");
    private static final QName RELID$54 = new QName("urn:schemas-microsoft-com:office:office", "relid");

    public CTFillImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public com.microsoft.schemas.office.office.CTFill addNewFill() {
        com.microsoft.schemas.office.office.CTFill cTFillAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFillAdd_element_user = get_store().add_element_user(FILL$0);
        }
        return cTFillAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public STTrueFalse.Enum getAlignshape() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ALIGNSHAPE$32);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public String getAlthref() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ALTHREF$18);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public BigDecimal getAngle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ANGLE$30);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getBigDecimalValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public STImageAspect$Enum getAspect() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ASPECT$26);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STImageAspect$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public String getColor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(COLOR$8);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public String getColor2() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(COLOR2$12);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public String getColors() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(COLORS$28);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public STTrueFalse$Enum getDetectmouseclick() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DETECTMOUSECLICK$42);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public com.microsoft.schemas.office.office.CTFill getFill() {
        synchronized (monitor()) {
            check_orphaned();
            com.microsoft.schemas.office.office.CTFill cTFillFind_element_user = get_store().find_element_user(FILL$0, 0);
            if (cTFillFind_element_user == null) {
                return null;
            }
            return cTFillFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public String getFocus() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FOCUS$34);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public String getFocusposition() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FOCUSPOSITION$38);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public String getFocussize() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FOCUSSIZE$36);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public String getHref() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HREF$16);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ID$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public String getId2() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ID2$52);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public STFillMethod$Enum getMethod() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(METHOD$40);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STFillMethod$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public STTrueFalse.Enum getOn() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ON$6);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public String getOpacity() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(OPACITY$10);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public String getOpacity2() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(OPACITY2$46);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public String getOrigin() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ORIGIN$22);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public String getPosition() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(POSITION$24);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public STTrueFalse.Enum getRecolor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(RECOLOR$48);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public String getRelid() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(RELID$54);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public STTrueFalse.Enum getRotate() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ROTATE$50);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public String getSize() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SIZE$20);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public String getSrc() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SRC$14);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public String getTitle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TITLE$44);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public STFillType$Enum getType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TYPE$4);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STFillType$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public boolean isSetAlignshape() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALIGNSHAPE$32) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public boolean isSetAlthref() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALTHREF$18) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public boolean isSetAngle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ANGLE$30) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public boolean isSetAspect() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ASPECT$26) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public boolean isSetColor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COLOR$8) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public boolean isSetColor2() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COLOR2$12) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public boolean isSetColors() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COLORS$28) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public boolean isSetDetectmouseclick() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DETECTMOUSECLICK$42) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public boolean isSetFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FILL$0) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public boolean isSetFocus() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FOCUS$34) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public boolean isSetFocusposition() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FOCUSPOSITION$38) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public boolean isSetFocussize() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FOCUSSIZE$36) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public boolean isSetHref() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HREF$16) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$2) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public boolean isSetId2() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID2$52) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public boolean isSetMethod() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(METHOD$40) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public boolean isSetOn() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ON$6) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public boolean isSetOpacity() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(OPACITY$10) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public boolean isSetOpacity2() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(OPACITY2$46) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public boolean isSetOrigin() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ORIGIN$22) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public boolean isSetPosition() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(POSITION$24) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public boolean isSetRecolor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(RECOLOR$48) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public boolean isSetRelid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(RELID$54) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public boolean isSetRotate() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ROTATE$50) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public boolean isSetSize() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SIZE$20) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public boolean isSetSrc() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SRC$14) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public boolean isSetTitle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TITLE$44) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public boolean isSetType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TYPE$4) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void setAlignshape(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALIGNSHAPE$32;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void setAlthref(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALTHREF$18;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void setAngle(BigDecimal bigDecimal) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ANGLE$30;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBigDecimalValue(bigDecimal);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void setAspect(STImageAspect$Enum sTImageAspect$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ASPECT$26;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTImageAspect$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void setColor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLOR$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void setColor2(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLOR2$12;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void setColors(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLORS$28;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void setDetectmouseclick(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DETECTMOUSECLICK$42;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void setFill(com.microsoft.schemas.office.office.CTFill cTFill) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILL$0;
            com.microsoft.schemas.office.office.CTFill cTFillFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTFillFind_element_user == null) {
                cTFillFind_element_user = (com.microsoft.schemas.office.office.CTFill) get_store().add_element_user(qName);
            }
            cTFillFind_element_user.set(cTFill);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void setFocus(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FOCUS$34;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void setFocusposition(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FOCUSPOSITION$38;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void setFocussize(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FOCUSSIZE$36;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void setHref(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HREF$16;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void setId2(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID2$52;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void setMethod(STFillMethod$Enum sTFillMethod$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = METHOD$40;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTFillMethod$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void setOn(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ON$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void setOpacity(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OPACITY$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void setOpacity2(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OPACITY2$46;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void setOrigin(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ORIGIN$22;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void setPosition(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = POSITION$24;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void setRecolor(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RECOLOR$48;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void setRelid(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RELID$54;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void setRotate(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ROTATE$50;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void setSize(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIZE$20;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void setSrc(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SRC$14;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void setTitle(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TITLE$44;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void setType(STFillType$Enum sTFillType$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTFillType$Enum);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void unsetAlignshape() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALIGNSHAPE$32);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void unsetAlthref() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALTHREF$18);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void unsetAngle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ANGLE$30);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void unsetAspect() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ASPECT$26);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void unsetColor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COLOR$8);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void unsetColor2() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COLOR2$12);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void unsetColors() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COLORS$28);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void unsetDetectmouseclick() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DETECTMOUSECLICK$42);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void unsetFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FILL$0, 0);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void unsetFocus() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FOCUS$34);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void unsetFocusposition() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FOCUSPOSITION$38);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void unsetFocussize() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FOCUSSIZE$36);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void unsetHref() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HREF$16);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$2);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void unsetId2() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID2$52);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void unsetMethod() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(METHOD$40);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void unsetOn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ON$6);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void unsetOpacity() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(OPACITY$10);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void unsetOpacity2() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(OPACITY2$46);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void unsetOrigin() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ORIGIN$22);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void unsetPosition() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(POSITION$24);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void unsetRecolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(RECOLOR$48);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void unsetRelid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(RELID$54);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void unsetRotate() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ROTATE$50);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void unsetSize() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SIZE$20);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void unsetSrc() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SRC$14);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void unsetTitle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TITLE$44);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TYPE$4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public STTrueFalse xgetAlignshape() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(ALIGNSHAPE$32);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public XmlString xgetAlthref() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(ALTHREF$18);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public XmlDecimal xgetAngle() {
        XmlDecimal xmlDecimalFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlDecimalFind_attribute_user = get_store().find_attribute_user(ANGLE$30);
        }
        return xmlDecimalFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public STImageAspect xgetAspect() {
        STImageAspect sTImageAspectFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTImageAspectFind_attribute_user = get_store().find_attribute_user(ASPECT$26);
        }
        return sTImageAspectFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public STColorType xgetColor() {
        STColorType sTColorTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTColorTypeFind_attribute_user = get_store().find_attribute_user(COLOR$8);
        }
        return sTColorTypeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public STColorType xgetColor2() {
        STColorType sTColorTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTColorTypeFind_attribute_user = get_store().find_attribute_user(COLOR2$12);
        }
        return sTColorTypeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public XmlString xgetColors() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(COLORS$28);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public com.microsoft.schemas.office.office.STTrueFalse xgetDetectmouseclick() {
        com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(DETECTMOUSECLICK$42);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public XmlString xgetFocus() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(FOCUS$34);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public XmlString xgetFocusposition() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(FOCUSPOSITION$38);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public XmlString xgetFocussize() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(FOCUSSIZE$36);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public XmlString xgetHref() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(HREF$16);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public XmlString xgetId() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(ID$2);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public STRelationshipId xgetId2() {
        STRelationshipId sTRelationshipIdFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTRelationshipIdFind_attribute_user = get_store().find_attribute_user(ID2$52);
        }
        return sTRelationshipIdFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public STFillMethod xgetMethod() {
        STFillMethod sTFillMethodFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTFillMethodFind_attribute_user = get_store().find_attribute_user(METHOD$40);
        }
        return sTFillMethodFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public STTrueFalse xgetOn() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(ON$6);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public XmlString xgetOpacity() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(OPACITY$10);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public XmlString xgetOpacity2() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(OPACITY2$46);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public XmlString xgetOrigin() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(ORIGIN$22);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public XmlString xgetPosition() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(POSITION$24);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public STTrueFalse xgetRecolor() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(RECOLOR$48);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public com.microsoft.schemas.office.office.STRelationshipId xgetRelid() {
        com.microsoft.schemas.office.office.STRelationshipId sTRelationshipIdFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTRelationshipIdFind_attribute_user = get_store().find_attribute_user(RELID$54);
        }
        return sTRelationshipIdFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public STTrueFalse xgetRotate() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(ROTATE$50);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public XmlString xgetSize() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(SIZE$20);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public XmlString xgetSrc() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(SRC$14);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public XmlString xgetTitle() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(TITLE$44);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public STFillType xgetType() {
        STFillType sTFillTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTFillTypeFind_attribute_user = get_store().find_attribute_user(TYPE$4);
        }
        return sTFillTypeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void xsetAlignshape(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALIGNSHAPE$32;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set((XmlObject) sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void xsetAlthref(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALTHREF$18;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void xsetAngle(XmlDecimal xmlDecimal) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ANGLE$30;
            XmlDecimal xmlDecimalFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlDecimalFind_attribute_user == null) {
                xmlDecimalFind_attribute_user = (XmlDecimal) get_store().add_attribute_user(qName);
            }
            xmlDecimalFind_attribute_user.set(xmlDecimal);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void xsetAspect(STImageAspect sTImageAspect) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ASPECT$26;
            STImageAspect sTImageAspectFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTImageAspectFind_attribute_user == null) {
                sTImageAspectFind_attribute_user = (STImageAspect) get_store().add_attribute_user(qName);
            }
            sTImageAspectFind_attribute_user.set(sTImageAspect);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void xsetColor(STColorType sTColorType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLOR$8;
            STColorType sTColorTypeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTColorTypeFind_attribute_user == null) {
                sTColorTypeFind_attribute_user = (STColorType) get_store().add_attribute_user(qName);
            }
            sTColorTypeFind_attribute_user.set(sTColorType);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void xsetColor2(STColorType sTColorType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLOR2$12;
            STColorType sTColorTypeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTColorTypeFind_attribute_user == null) {
                sTColorTypeFind_attribute_user = (STColorType) get_store().add_attribute_user(qName);
            }
            sTColorTypeFind_attribute_user.set(sTColorType);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void xsetColors(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLORS$28;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void xsetDetectmouseclick(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DETECTMOUSECLICK$42;
            com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (com.microsoft.schemas.office.office.STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void xsetFocus(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FOCUS$34;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void xsetFocusposition(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FOCUSPOSITION$38;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void xsetFocussize(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FOCUSSIZE$36;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void xsetHref(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HREF$16;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void xsetId(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$2;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void xsetId2(STRelationshipId sTRelationshipId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID2$52;
            STRelationshipId sTRelationshipIdFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTRelationshipIdFind_attribute_user == null) {
                sTRelationshipIdFind_attribute_user = (STRelationshipId) get_store().add_attribute_user(qName);
            }
            sTRelationshipIdFind_attribute_user.set(sTRelationshipId);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void xsetMethod(STFillMethod sTFillMethod) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = METHOD$40;
            STFillMethod sTFillMethodFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTFillMethodFind_attribute_user == null) {
                sTFillMethodFind_attribute_user = (STFillMethod) get_store().add_attribute_user(qName);
            }
            sTFillMethodFind_attribute_user.set(sTFillMethod);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void xsetOn(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ON$6;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set((XmlObject) sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void xsetOpacity(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OPACITY$10;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void xsetOpacity2(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OPACITY2$46;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void xsetOrigin(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ORIGIN$22;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void xsetPosition(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = POSITION$24;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void xsetRecolor(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RECOLOR$48;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set((XmlObject) sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void xsetRelid(com.microsoft.schemas.office.office.STRelationshipId sTRelationshipId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RELID$54;
            com.microsoft.schemas.office.office.STRelationshipId sTRelationshipIdFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTRelationshipIdFind_attribute_user == null) {
                sTRelationshipIdFind_attribute_user = (com.microsoft.schemas.office.office.STRelationshipId) get_store().add_attribute_user(qName);
            }
            sTRelationshipIdFind_attribute_user.set(sTRelationshipId);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void xsetRotate(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ROTATE$50;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set((XmlObject) sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void xsetSize(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIZE$20;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void xsetSrc(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SRC$14;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void xsetTitle(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TITLE$44;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFill
    public void xsetType(STFillType sTFillType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$4;
            STFillType sTFillTypeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTFillTypeFind_attribute_user == null) {
                sTFillTypeFind_attribute_user = (STFillType) get_store().add_attribute_user(qName);
            }
            sTFillTypeFind_attribute_user.set(sTFillType);
        }
    }
}
