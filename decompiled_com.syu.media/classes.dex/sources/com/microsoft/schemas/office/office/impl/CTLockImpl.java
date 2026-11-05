package com.microsoft.schemas.office.office.impl;

import chip.FinalChip;
import com.microsoft.schemas.office.office.CTLock;
import com.microsoft.schemas.office.office.STTrueFalse;
import com.microsoft.schemas.office.office.STTrueFalse$Enum;
import com.microsoft.schemas.vml.STExt;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class CTLockImpl extends XmlComplexContentImpl implements CTLock {
    private static final QName EXT$0 = new QName("urn:schemas-microsoft-com:vml", "ext");
    private static final QName POSITION$2 = new QName(FinalChip.BSP_PLATFORM_Null, "position");
    private static final QName SELECTION$4 = new QName(FinalChip.BSP_PLATFORM_Null, "selection");
    private static final QName GROUPING$6 = new QName(FinalChip.BSP_PLATFORM_Null, "grouping");
    private static final QName UNGROUPING$8 = new QName(FinalChip.BSP_PLATFORM_Null, "ungrouping");
    private static final QName ROTATION$10 = new QName(FinalChip.BSP_PLATFORM_Null, "rotation");
    private static final QName CROPPING$12 = new QName(FinalChip.BSP_PLATFORM_Null, "cropping");
    private static final QName VERTICIES$14 = new QName(FinalChip.BSP_PLATFORM_Null, "verticies");
    private static final QName ADJUSTHANDLES$16 = new QName(FinalChip.BSP_PLATFORM_Null, "adjusthandles");
    private static final QName TEXT$18 = new QName(FinalChip.BSP_PLATFORM_Null, "text");
    private static final QName ASPECTRATIO$20 = new QName(FinalChip.BSP_PLATFORM_Null, "aspectratio");
    private static final QName SHAPETYPE$22 = new QName(FinalChip.BSP_PLATFORM_Null, "shapetype");

    public CTLockImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public STTrueFalse$Enum getAdjusthandles() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ADJUSTHANDLES$16);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public STTrueFalse$Enum getAspectratio() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ASPECTRATIO$20);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public STTrueFalse$Enum getCropping() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CROPPING$12);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public STExt.Enum getExt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(EXT$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STExt.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public STTrueFalse$Enum getGrouping() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(GROUPING$6);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public STTrueFalse$Enum getPosition() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(POSITION$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public STTrueFalse$Enum getRotation() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ROTATION$10);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public STTrueFalse$Enum getSelection() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SELECTION$4);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public STTrueFalse$Enum getShapetype() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SHAPETYPE$22);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public STTrueFalse$Enum getText() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TEXT$18);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public STTrueFalse$Enum getUngrouping() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(UNGROUPING$8);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public STTrueFalse$Enum getVerticies() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(VERTICIES$14);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTrueFalse$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public boolean isSetAdjusthandles() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ADJUSTHANDLES$16) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public boolean isSetAspectratio() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ASPECTRATIO$20) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public boolean isSetCropping() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CROPPING$12) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public boolean isSetExt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(EXT$0) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public boolean isSetGrouping() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(GROUPING$6) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public boolean isSetPosition() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(POSITION$2) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public boolean isSetRotation() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ROTATION$10) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public boolean isSetSelection() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SELECTION$4) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public boolean isSetShapetype() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SHAPETYPE$22) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public boolean isSetText() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TEXT$18) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public boolean isSetUngrouping() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(UNGROUPING$8) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public boolean isSetVerticies() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(VERTICIES$14) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void setAdjusthandles(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ADJUSTHANDLES$16;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void setAspectratio(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ASPECTRATIO$20;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void setCropping(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CROPPING$12;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void setExt(STExt.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXT$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void setGrouping(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GROUPING$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void setPosition(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = POSITION$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void setRotation(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ROTATION$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void setSelection(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SELECTION$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void setShapetype(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHAPETYPE$22;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void setText(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TEXT$18;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void setUngrouping(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UNGROUPING$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void setVerticies(STTrueFalse$Enum sTTrueFalse$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VERTICIES$14;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTTrueFalse$Enum);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void unsetAdjusthandles() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ADJUSTHANDLES$16);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void unsetAspectratio() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ASPECTRATIO$20);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void unsetCropping() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CROPPING$12);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void unsetExt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(EXT$0);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void unsetGrouping() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(GROUPING$6);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void unsetPosition() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(POSITION$2);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void unsetRotation() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ROTATION$10);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void unsetSelection() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SELECTION$4);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void unsetShapetype() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SHAPETYPE$22);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void unsetText() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TEXT$18);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void unsetUngrouping() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(UNGROUPING$8);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void unsetVerticies() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(VERTICIES$14);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public STTrueFalse xgetAdjusthandles() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(ADJUSTHANDLES$16);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public STTrueFalse xgetAspectratio() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(ASPECTRATIO$20);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public STTrueFalse xgetCropping() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(CROPPING$12);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public STExt xgetExt() {
        STExt sTExtFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTExtFind_attribute_user = get_store().find_attribute_user(EXT$0);
        }
        return sTExtFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public STTrueFalse xgetGrouping() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(GROUPING$6);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public STTrueFalse xgetPosition() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(POSITION$2);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public STTrueFalse xgetRotation() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(ROTATION$10);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public STTrueFalse xgetSelection() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(SELECTION$4);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public STTrueFalse xgetShapetype() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(SHAPETYPE$22);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public STTrueFalse xgetText() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(TEXT$18);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public STTrueFalse xgetUngrouping() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(UNGROUPING$8);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public STTrueFalse xgetVerticies() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(VERTICIES$14);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void xsetAdjusthandles(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ADJUSTHANDLES$16;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void xsetAspectratio(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ASPECTRATIO$20;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void xsetCropping(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CROPPING$12;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void xsetExt(STExt sTExt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXT$0;
            STExt sTExtFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTExtFind_attribute_user == null) {
                sTExtFind_attribute_user = (STExt) get_store().add_attribute_user(qName);
            }
            sTExtFind_attribute_user.set((XmlObject) sTExt);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void xsetGrouping(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GROUPING$6;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void xsetPosition(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = POSITION$2;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void xsetRotation(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ROTATION$10;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void xsetSelection(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SELECTION$4;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void xsetShapetype(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHAPETYPE$22;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void xsetText(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TEXT$18;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void xsetUngrouping(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UNGROUPING$8;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }

    @Override // com.microsoft.schemas.office.office.CTLock
    public void xsetVerticies(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VERTICIES$14;
            STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTrueFalseFind_attribute_user == null) {
                sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
            }
            sTTrueFalseFind_attribute_user.set(sTTrueFalse);
        }
    }
}
