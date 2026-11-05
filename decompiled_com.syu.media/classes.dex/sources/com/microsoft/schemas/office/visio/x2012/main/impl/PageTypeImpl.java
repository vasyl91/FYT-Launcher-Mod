package com.microsoft.schemas.office.visio.x2012.main.impl;

import chip.FinalChip;
import com.microsoft.schemas.office.visio.x2012.main.PageSheetType;
import com.microsoft.schemas.office.visio.x2012.main.PageType;
import com.microsoft.schemas.office.visio.x2012.main.RelType;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class PageTypeImpl extends XmlComplexContentImpl implements PageType {
    private static final QName PAGESHEET$0 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "PageSheet");
    private static final QName REL$2 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "Rel");
    private static final QName ID$4 = new QName(FinalChip.BSP_PLATFORM_Null, "ID");
    private static final QName NAME$6 = new QName(FinalChip.BSP_PLATFORM_Null, "Name");
    private static final QName NAMEU$8 = new QName(FinalChip.BSP_PLATFORM_Null, "NameU");
    private static final QName ISCUSTOMNAME$10 = new QName(FinalChip.BSP_PLATFORM_Null, "IsCustomName");
    private static final QName ISCUSTOMNAMEU$12 = new QName(FinalChip.BSP_PLATFORM_Null, "IsCustomNameU");
    private static final QName BACKGROUND$14 = new QName(FinalChip.BSP_PLATFORM_Null, "Background");
    private static final QName BACKPAGE$16 = new QName(FinalChip.BSP_PLATFORM_Null, "BackPage");
    private static final QName VIEWSCALE$18 = new QName(FinalChip.BSP_PLATFORM_Null, "ViewScale");
    private static final QName VIEWCENTERX$20 = new QName(FinalChip.BSP_PLATFORM_Null, "ViewCenterX");
    private static final QName VIEWCENTERY$22 = new QName(FinalChip.BSP_PLATFORM_Null, "ViewCenterY");
    private static final QName REVIEWERID$24 = new QName(FinalChip.BSP_PLATFORM_Null, "ReviewerID");
    private static final QName ASSOCIATEDPAGE$26 = new QName(FinalChip.BSP_PLATFORM_Null, "AssociatedPage");

    public PageTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public PageSheetType addNewPageSheet() {
        PageSheetType pageSheetTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            pageSheetTypeAdd_element_user = get_store().add_element_user(PAGESHEET$0);
        }
        return pageSheetTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public RelType addNewRel() {
        RelType relTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            relTypeAdd_element_user = get_store().add_element_user(REL$2);
        }
        return relTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public long getAssociatedPage() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ASSOCIATEDPAGE$26);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public long getBackPage() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BACKPAGE$16);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public boolean getBackground() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BACKGROUND$14);
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public long getID() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ID$4);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public boolean getIsCustomName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ISCUSTOMNAME$10);
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public boolean getIsCustomNameU() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ISCUSTOMNAMEU$12);
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public String getName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(NAME$6);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public String getNameU() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(NAMEU$8);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
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

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
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

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public long getReviewerID() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(REVIEWERID$24);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public double getViewCenterX() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(VIEWCENTERX$20);
            if (simpleValueFind_attribute_user == null) {
                return 0.0d;
            }
            return simpleValueFind_attribute_user.getDoubleValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public double getViewCenterY() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(VIEWCENTERY$22);
            if (simpleValueFind_attribute_user == null) {
                return 0.0d;
            }
            return simpleValueFind_attribute_user.getDoubleValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public double getViewScale() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(VIEWSCALE$18);
            if (simpleValueFind_attribute_user == null) {
                return 0.0d;
            }
            return simpleValueFind_attribute_user.getDoubleValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public boolean isSetAssociatedPage() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ASSOCIATEDPAGE$26) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public boolean isSetBackPage() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BACKPAGE$16) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public boolean isSetBackground() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BACKGROUND$14) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public boolean isSetIsCustomName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ISCUSTOMNAME$10) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public boolean isSetIsCustomNameU() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ISCUSTOMNAMEU$12) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public boolean isSetName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(NAME$6) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public boolean isSetNameU() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(NAMEU$8) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public boolean isSetPageSheet() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PAGESHEET$0) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public boolean isSetReviewerID() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(REVIEWERID$24) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public boolean isSetViewCenterX() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(VIEWCENTERX$20) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public boolean isSetViewCenterY() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(VIEWCENTERY$22) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public boolean isSetViewScale() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(VIEWSCALE$18) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void setAssociatedPage(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ASSOCIATEDPAGE$26;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void setBackPage(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BACKPAGE$16;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void setBackground(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BACKGROUND$14;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void setID(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void setIsCustomName(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ISCUSTOMNAME$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void setIsCustomNameU(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ISCUSTOMNAMEU$12;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void setName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void setNameU(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAMEU$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
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

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
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

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void setReviewerID(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REVIEWERID$24;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void setViewCenterX(double d) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VIEWCENTERX$20;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setDoubleValue(d);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void setViewCenterY(double d) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VIEWCENTERY$22;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setDoubleValue(d);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void setViewScale(double d) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VIEWSCALE$18;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setDoubleValue(d);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void unsetAssociatedPage() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ASSOCIATEDPAGE$26);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void unsetBackPage() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BACKPAGE$16);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void unsetBackground() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BACKGROUND$14);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void unsetIsCustomName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ISCUSTOMNAME$10);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void unsetIsCustomNameU() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ISCUSTOMNAMEU$12);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void unsetName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(NAME$6);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void unsetNameU() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(NAMEU$8);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void unsetPageSheet() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PAGESHEET$0, 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void unsetReviewerID() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(REVIEWERID$24);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void unsetViewCenterX() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(VIEWCENTERX$20);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void unsetViewCenterY() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(VIEWCENTERY$22);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void unsetViewScale() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(VIEWSCALE$18);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public XmlUnsignedInt xgetAssociatedPage() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(ASSOCIATEDPAGE$26);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public XmlUnsignedInt xgetBackPage() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(BACKPAGE$16);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public XmlBoolean xgetBackground() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(BACKGROUND$14);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public XmlUnsignedInt xgetID() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(ID$4);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public XmlBoolean xgetIsCustomName() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(ISCUSTOMNAME$10);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public XmlBoolean xgetIsCustomNameU() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(ISCUSTOMNAMEU$12);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public XmlString xgetName() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(NAME$6);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public XmlString xgetNameU() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(NAMEU$8);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public XmlUnsignedInt xgetReviewerID() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(REVIEWERID$24);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public XmlDouble xgetViewCenterX() {
        XmlDouble xmlDoubleFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlDoubleFind_attribute_user = get_store().find_attribute_user(VIEWCENTERX$20);
        }
        return xmlDoubleFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public XmlDouble xgetViewCenterY() {
        XmlDouble xmlDoubleFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlDoubleFind_attribute_user = get_store().find_attribute_user(VIEWCENTERY$22);
        }
        return xmlDoubleFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public XmlDouble xgetViewScale() {
        XmlDouble xmlDoubleFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlDoubleFind_attribute_user = get_store().find_attribute_user(VIEWSCALE$18);
        }
        return xmlDoubleFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void xsetAssociatedPage(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ASSOCIATEDPAGE$26;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void xsetBackPage(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BACKPAGE$16;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void xsetBackground(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BACKGROUND$14;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void xsetID(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$4;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void xsetIsCustomName(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ISCUSTOMNAME$10;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void xsetIsCustomNameU(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ISCUSTOMNAMEU$12;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void xsetName(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$6;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void xsetNameU(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAMEU$8;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void xsetReviewerID(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REVIEWERID$24;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void xsetViewCenterX(XmlDouble xmlDouble) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VIEWCENTERX$20;
            XmlDouble xmlDoubleFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlDoubleFind_attribute_user == null) {
                xmlDoubleFind_attribute_user = (XmlDouble) get_store().add_attribute_user(qName);
            }
            xmlDoubleFind_attribute_user.set(xmlDouble);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void xsetViewCenterY(XmlDouble xmlDouble) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VIEWCENTERY$22;
            XmlDouble xmlDoubleFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlDoubleFind_attribute_user == null) {
                xmlDoubleFind_attribute_user = (XmlDouble) get_store().add_attribute_user(qName);
            }
            xmlDoubleFind_attribute_user.set(xmlDouble);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageType
    public void xsetViewScale(XmlDouble xmlDouble) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VIEWSCALE$18;
            XmlDouble xmlDoubleFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlDoubleFind_attribute_user == null) {
                xmlDoubleFind_attribute_user = (XmlDouble) get_store().add_attribute_user(qName);
            }
            xmlDoubleFind_attribute_user.set(xmlDouble);
        }
    }
}
