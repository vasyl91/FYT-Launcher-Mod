package com.microsoft.schemas.office.visio.x2012.main.impl;

import chip.FinalChip;
import com.microsoft.schemas.office.visio.x2012.main.IconType;
import com.microsoft.schemas.office.visio.x2012.main.MasterType;
import com.microsoft.schemas.office.visio.x2012.main.PageSheetType;
import com.microsoft.schemas.office.visio.x2012.main.RelType;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.XmlUnsignedShort;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class MasterTypeImpl extends XmlComplexContentImpl implements MasterType {
    private static final QName PAGESHEET$0 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "PageSheet");
    private static final QName REL$2 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "Rel");
    private static final QName ICON$4 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "Icon");
    private static final QName ID$6 = new QName(FinalChip.BSP_PLATFORM_Null, "ID");
    private static final QName BASEID$8 = new QName(FinalChip.BSP_PLATFORM_Null, "BaseID");
    private static final QName UNIQUEID$10 = new QName(FinalChip.BSP_PLATFORM_Null, "UniqueID");
    private static final QName MATCHBYNAME$12 = new QName(FinalChip.BSP_PLATFORM_Null, "MatchByName");
    private static final QName NAME$14 = new QName(FinalChip.BSP_PLATFORM_Null, "Name");
    private static final QName NAMEU$16 = new QName(FinalChip.BSP_PLATFORM_Null, "NameU");
    private static final QName ISCUSTOMNAME$18 = new QName(FinalChip.BSP_PLATFORM_Null, "IsCustomName");
    private static final QName ISCUSTOMNAMEU$20 = new QName(FinalChip.BSP_PLATFORM_Null, "IsCustomNameU");
    private static final QName ICONSIZE$22 = new QName(FinalChip.BSP_PLATFORM_Null, "IconSize");
    private static final QName PATTERNFLAGS$24 = new QName(FinalChip.BSP_PLATFORM_Null, "PatternFlags");
    private static final QName PROMPT$26 = new QName(FinalChip.BSP_PLATFORM_Null, "Prompt");
    private static final QName HIDDEN$28 = new QName(FinalChip.BSP_PLATFORM_Null, "Hidden");
    private static final QName ICONUPDATE$30 = new QName(FinalChip.BSP_PLATFORM_Null, "IconUpdate");
    private static final QName ALIGNNAME$32 = new QName(FinalChip.BSP_PLATFORM_Null, "AlignName");
    private static final QName MASTERTYPE$34 = new QName(FinalChip.BSP_PLATFORM_Null, "MasterType");

    public MasterTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public IconType addNewIcon() {
        IconType iconTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            iconTypeAdd_element_user = get_store().add_element_user(ICON$4);
        }
        return iconTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public PageSheetType addNewPageSheet() {
        PageSheetType pageSheetTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            pageSheetTypeAdd_element_user = get_store().add_element_user(PAGESHEET$0);
        }
        return pageSheetTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public RelType addNewRel() {
        RelType relTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            relTypeAdd_element_user = get_store().add_element_user(REL$2);
        }
        return relTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public int getAlignName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ALIGNNAME$32);
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public String getBaseID() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BASEID$8);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public boolean getHidden() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HIDDEN$28);
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public long getID() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ID$6);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public IconType getIcon() {
        synchronized (monitor()) {
            check_orphaned();
            IconType iconTypeFind_element_user = get_store().find_element_user(ICON$4, 0);
            if (iconTypeFind_element_user == null) {
                return null;
            }
            return iconTypeFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public int getIconSize() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ICONSIZE$22);
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public boolean getIconUpdate() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ICONUPDATE$30);
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public boolean getIsCustomName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ISCUSTOMNAME$18);
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public boolean getIsCustomNameU() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ISCUSTOMNAMEU$20);
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public int getMasterType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(MASTERTYPE$34);
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public boolean getMatchByName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(MATCHBYNAME$12);
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public String getName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(NAME$14);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public String getNameU() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(NAMEU$16);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public PageSheetType getPageSheet() {
        synchronized (monitor()) {
            check_orphaned();
            PageSheetType pageSheetTypeFind_element_user = get_store().find_element_user(PAGESHEET$0, 0);
            if (pageSheetTypeFind_element_user == null) {
                return null;
            }
            return pageSheetTypeFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public int getPatternFlags() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(PATTERNFLAGS$24);
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public String getPrompt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(PROMPT$26);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public RelType getRel() {
        synchronized (monitor()) {
            check_orphaned();
            RelType relTypeFind_element_user = get_store().find_element_user(REL$2, 0);
            if (relTypeFind_element_user == null) {
                return null;
            }
            return relTypeFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public String getUniqueID() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(UNIQUEID$10);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public boolean isSetAlignName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALIGNNAME$32) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public boolean isSetBaseID() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BASEID$8) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public boolean isSetHidden() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HIDDEN$28) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public boolean isSetIcon() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ICON$4) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public boolean isSetIconSize() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ICONSIZE$22) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public boolean isSetIconUpdate() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ICONUPDATE$30) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public boolean isSetIsCustomName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ISCUSTOMNAME$18) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public boolean isSetIsCustomNameU() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ISCUSTOMNAMEU$20) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public boolean isSetMasterType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MASTERTYPE$34) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public boolean isSetMatchByName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MATCHBYNAME$12) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public boolean isSetName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(NAME$14) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public boolean isSetNameU() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(NAMEU$16) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public boolean isSetPageSheet() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PAGESHEET$0) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public boolean isSetPatternFlags() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PATTERNFLAGS$24) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public boolean isSetPrompt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROMPT$26) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public boolean isSetUniqueID() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(UNIQUEID$10) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void setAlignName(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALIGNNAME$32;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void setBaseID(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BASEID$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void setHidden(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HIDDEN$28;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void setID(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void setIcon(IconType iconType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ICON$4;
            IconType iconTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (iconTypeFind_element_user == null) {
                iconTypeFind_element_user = (IconType) get_store().add_element_user(qName);
            }
            iconTypeFind_element_user.set(iconType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void setIconSize(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ICONSIZE$22;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void setIconUpdate(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ICONUPDATE$30;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void setIsCustomName(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ISCUSTOMNAME$18;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void setIsCustomNameU(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ISCUSTOMNAMEU$20;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void setMasterType(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MASTERTYPE$34;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void setMatchByName(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MATCHBYNAME$12;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void setName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$14;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void setNameU(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAMEU$16;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void setPageSheet(PageSheetType pageSheetType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PAGESHEET$0;
            PageSheetType pageSheetTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (pageSheetTypeFind_element_user == null) {
                pageSheetTypeFind_element_user = (PageSheetType) get_store().add_element_user(qName);
            }
            pageSheetTypeFind_element_user.set(pageSheetType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void setPatternFlags(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PATTERNFLAGS$24;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void setPrompt(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PROMPT$26;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void setRel(RelType relType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REL$2;
            RelType relTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (relTypeFind_element_user == null) {
                relTypeFind_element_user = (RelType) get_store().add_element_user(qName);
            }
            relTypeFind_element_user.set(relType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void setUniqueID(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UNIQUEID$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void unsetAlignName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALIGNNAME$32);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void unsetBaseID() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BASEID$8);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void unsetHidden() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HIDDEN$28);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void unsetIcon() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ICON$4, 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void unsetIconSize() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ICONSIZE$22);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void unsetIconUpdate() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ICONUPDATE$30);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void unsetIsCustomName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ISCUSTOMNAME$18);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void unsetIsCustomNameU() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ISCUSTOMNAMEU$20);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void unsetMasterType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MASTERTYPE$34);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void unsetMatchByName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MATCHBYNAME$12);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void unsetName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(NAME$14);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void unsetNameU() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(NAMEU$16);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void unsetPageSheet() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PAGESHEET$0, 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void unsetPatternFlags() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PATTERNFLAGS$24);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void unsetPrompt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROMPT$26);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void unsetUniqueID() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(UNIQUEID$10);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public XmlUnsignedShort xgetAlignName() {
        XmlUnsignedShort xmlUnsignedShortFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedShortFind_attribute_user = get_store().find_attribute_user(ALIGNNAME$32);
        }
        return xmlUnsignedShortFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public XmlString xgetBaseID() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(BASEID$8);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public XmlBoolean xgetHidden() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(HIDDEN$28);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public XmlUnsignedInt xgetID() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(ID$6);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public XmlUnsignedShort xgetIconSize() {
        XmlUnsignedShort xmlUnsignedShortFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedShortFind_attribute_user = get_store().find_attribute_user(ICONSIZE$22);
        }
        return xmlUnsignedShortFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public XmlBoolean xgetIconUpdate() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(ICONUPDATE$30);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public XmlBoolean xgetIsCustomName() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(ISCUSTOMNAME$18);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public XmlBoolean xgetIsCustomNameU() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(ISCUSTOMNAMEU$20);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public XmlUnsignedShort xgetMasterType() {
        XmlUnsignedShort xmlUnsignedShortFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedShortFind_attribute_user = get_store().find_attribute_user(MASTERTYPE$34);
        }
        return xmlUnsignedShortFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public XmlBoolean xgetMatchByName() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(MATCHBYNAME$12);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public XmlString xgetName() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(NAME$14);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public XmlString xgetNameU() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(NAMEU$16);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public XmlUnsignedShort xgetPatternFlags() {
        XmlUnsignedShort xmlUnsignedShortFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedShortFind_attribute_user = get_store().find_attribute_user(PATTERNFLAGS$24);
        }
        return xmlUnsignedShortFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public XmlString xgetPrompt() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(PROMPT$26);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public XmlString xgetUniqueID() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(UNIQUEID$10);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void xsetAlignName(XmlUnsignedShort xmlUnsignedShort) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALIGNNAME$32;
            XmlUnsignedShort xmlUnsignedShortFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedShortFind_attribute_user == null) {
                xmlUnsignedShortFind_attribute_user = (XmlUnsignedShort) get_store().add_attribute_user(qName);
            }
            xmlUnsignedShortFind_attribute_user.set(xmlUnsignedShort);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void xsetBaseID(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BASEID$8;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void xsetHidden(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HIDDEN$28;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void xsetID(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$6;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void xsetIconSize(XmlUnsignedShort xmlUnsignedShort) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ICONSIZE$22;
            XmlUnsignedShort xmlUnsignedShortFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedShortFind_attribute_user == null) {
                xmlUnsignedShortFind_attribute_user = (XmlUnsignedShort) get_store().add_attribute_user(qName);
            }
            xmlUnsignedShortFind_attribute_user.set(xmlUnsignedShort);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void xsetIconUpdate(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ICONUPDATE$30;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void xsetIsCustomName(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ISCUSTOMNAME$18;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void xsetIsCustomNameU(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ISCUSTOMNAMEU$20;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void xsetMasterType(XmlUnsignedShort xmlUnsignedShort) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MASTERTYPE$34;
            XmlUnsignedShort xmlUnsignedShortFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedShortFind_attribute_user == null) {
                xmlUnsignedShortFind_attribute_user = (XmlUnsignedShort) get_store().add_attribute_user(qName);
            }
            xmlUnsignedShortFind_attribute_user.set(xmlUnsignedShort);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void xsetMatchByName(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MATCHBYNAME$12;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void xsetName(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$14;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void xsetNameU(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAMEU$16;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void xsetPatternFlags(XmlUnsignedShort xmlUnsignedShort) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PATTERNFLAGS$24;
            XmlUnsignedShort xmlUnsignedShortFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedShortFind_attribute_user == null) {
                xmlUnsignedShortFind_attribute_user = (XmlUnsignedShort) get_store().add_attribute_user(qName);
            }
            xmlUnsignedShortFind_attribute_user.set(xmlUnsignedShort);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void xsetPrompt(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PROMPT$26;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.MasterType
    public void xsetUniqueID(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UNIQUEID$10;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }
}
