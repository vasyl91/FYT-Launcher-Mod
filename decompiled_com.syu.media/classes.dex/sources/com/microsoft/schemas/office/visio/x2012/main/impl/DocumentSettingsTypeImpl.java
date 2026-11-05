package com.microsoft.schemas.office.visio.x2012.main.impl;

import chip.FinalChip;
import com.microsoft.schemas.office.visio.x2012.main.AttachedToolbarsType;
import com.microsoft.schemas.office.visio.x2012.main.CustomMenusFileType;
import com.microsoft.schemas.office.visio.x2012.main.CustomToolbarsFileType;
import com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType;
import com.microsoft.schemas.office.visio.x2012.main.DynamicGridEnabledType;
import com.microsoft.schemas.office.visio.x2012.main.GlueSettingsType;
import com.microsoft.schemas.office.visio.x2012.main.ProtectBkgndsType;
import com.microsoft.schemas.office.visio.x2012.main.ProtectMastersType;
import com.microsoft.schemas.office.visio.x2012.main.ProtectShapesType;
import com.microsoft.schemas.office.visio.x2012.main.ProtectStylesType;
import com.microsoft.schemas.office.visio.x2012.main.SnapAnglesType;
import com.microsoft.schemas.office.visio.x2012.main.SnapExtensionsType;
import com.microsoft.schemas.office.visio.x2012.main.SnapSettingsType;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class DocumentSettingsTypeImpl extends XmlComplexContentImpl implements DocumentSettingsType {
    private static final QName GLUESETTINGS$0 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "GlueSettings");
    private static final QName SNAPSETTINGS$2 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "SnapSettings");
    private static final QName SNAPEXTENSIONS$4 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "SnapExtensions");
    private static final QName SNAPANGLES$6 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "SnapAngles");
    private static final QName DYNAMICGRIDENABLED$8 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "DynamicGridEnabled");
    private static final QName PROTECTSTYLES$10 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "ProtectStyles");
    private static final QName PROTECTSHAPES$12 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "ProtectShapes");
    private static final QName PROTECTMASTERS$14 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "ProtectMasters");
    private static final QName PROTECTBKGNDS$16 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "ProtectBkgnds");
    private static final QName CUSTOMMENUSFILE$18 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "CustomMenusFile");
    private static final QName CUSTOMTOOLBARSFILE$20 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "CustomToolbarsFile");
    private static final QName ATTACHEDTOOLBARS$22 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "AttachedToolbars");
    private static final QName TOPPAGE$24 = new QName(FinalChip.BSP_PLATFORM_Null, "TopPage");
    private static final QName DEFAULTTEXTSTYLE$26 = new QName(FinalChip.BSP_PLATFORM_Null, "DefaultTextStyle");
    private static final QName DEFAULTLINESTYLE$28 = new QName(FinalChip.BSP_PLATFORM_Null, "DefaultLineStyle");
    private static final QName DEFAULTFILLSTYLE$30 = new QName(FinalChip.BSP_PLATFORM_Null, "DefaultFillStyle");
    private static final QName DEFAULTGUIDESTYLE$32 = new QName(FinalChip.BSP_PLATFORM_Null, "DefaultGuideStyle");

    public DocumentSettingsTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public AttachedToolbarsType addNewAttachedToolbars() {
        AttachedToolbarsType attachedToolbarsTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            attachedToolbarsTypeAdd_element_user = get_store().add_element_user(ATTACHEDTOOLBARS$22);
        }
        return attachedToolbarsTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public CustomMenusFileType addNewCustomMenusFile() {
        CustomMenusFileType customMenusFileTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            customMenusFileTypeAdd_element_user = get_store().add_element_user(CUSTOMMENUSFILE$18);
        }
        return customMenusFileTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public CustomToolbarsFileType addNewCustomToolbarsFile() {
        CustomToolbarsFileType customToolbarsFileTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            customToolbarsFileTypeAdd_element_user = get_store().add_element_user(CUSTOMTOOLBARSFILE$20);
        }
        return customToolbarsFileTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public DynamicGridEnabledType addNewDynamicGridEnabled() {
        DynamicGridEnabledType dynamicGridEnabledTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            dynamicGridEnabledTypeAdd_element_user = get_store().add_element_user(DYNAMICGRIDENABLED$8);
        }
        return dynamicGridEnabledTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public GlueSettingsType addNewGlueSettings() {
        GlueSettingsType glueSettingsTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            glueSettingsTypeAdd_element_user = get_store().add_element_user(GLUESETTINGS$0);
        }
        return glueSettingsTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public ProtectBkgndsType addNewProtectBkgnds() {
        ProtectBkgndsType protectBkgndsTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            protectBkgndsTypeAdd_element_user = get_store().add_element_user(PROTECTBKGNDS$16);
        }
        return protectBkgndsTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public ProtectMastersType addNewProtectMasters() {
        ProtectMastersType protectMastersTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            protectMastersTypeAdd_element_user = get_store().add_element_user(PROTECTMASTERS$14);
        }
        return protectMastersTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public ProtectShapesType addNewProtectShapes() {
        ProtectShapesType protectShapesTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            protectShapesTypeAdd_element_user = get_store().add_element_user(PROTECTSHAPES$12);
        }
        return protectShapesTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public ProtectStylesType addNewProtectStyles() {
        ProtectStylesType protectStylesTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            protectStylesTypeAdd_element_user = get_store().add_element_user(PROTECTSTYLES$10);
        }
        return protectStylesTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public SnapAnglesType addNewSnapAngles() {
        SnapAnglesType snapAnglesTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            snapAnglesTypeAdd_element_user = get_store().add_element_user(SNAPANGLES$6);
        }
        return snapAnglesTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public SnapExtensionsType addNewSnapExtensions() {
        SnapExtensionsType snapExtensionsTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            snapExtensionsTypeAdd_element_user = get_store().add_element_user(SNAPEXTENSIONS$4);
        }
        return snapExtensionsTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public SnapSettingsType addNewSnapSettings() {
        SnapSettingsType snapSettingsTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            snapSettingsTypeAdd_element_user = get_store().add_element_user(SNAPSETTINGS$2);
        }
        return snapSettingsTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public AttachedToolbarsType getAttachedToolbars() {
        synchronized (monitor()) {
            check_orphaned();
            AttachedToolbarsType attachedToolbarsTypeFind_element_user = get_store().find_element_user(ATTACHEDTOOLBARS$22, 0);
            if (attachedToolbarsTypeFind_element_user == null) {
                return null;
            }
            return attachedToolbarsTypeFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public CustomMenusFileType getCustomMenusFile() {
        synchronized (monitor()) {
            check_orphaned();
            CustomMenusFileType customMenusFileTypeFind_element_user = get_store().find_element_user(CUSTOMMENUSFILE$18, 0);
            if (customMenusFileTypeFind_element_user == null) {
                return null;
            }
            return customMenusFileTypeFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public CustomToolbarsFileType getCustomToolbarsFile() {
        synchronized (monitor()) {
            check_orphaned();
            CustomToolbarsFileType customToolbarsFileTypeFind_element_user = get_store().find_element_user(CUSTOMTOOLBARSFILE$20, 0);
            if (customToolbarsFileTypeFind_element_user == null) {
                return null;
            }
            return customToolbarsFileTypeFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public long getDefaultFillStyle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DEFAULTFILLSTYLE$30);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public long getDefaultGuideStyle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DEFAULTGUIDESTYLE$32);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public long getDefaultLineStyle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DEFAULTLINESTYLE$28);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public long getDefaultTextStyle() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(DEFAULTTEXTSTYLE$26);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public DynamicGridEnabledType getDynamicGridEnabled() {
        synchronized (monitor()) {
            check_orphaned();
            DynamicGridEnabledType dynamicGridEnabledTypeFind_element_user = get_store().find_element_user(DYNAMICGRIDENABLED$8, 0);
            if (dynamicGridEnabledTypeFind_element_user == null) {
                return null;
            }
            return dynamicGridEnabledTypeFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public GlueSettingsType getGlueSettings() {
        synchronized (monitor()) {
            check_orphaned();
            GlueSettingsType glueSettingsTypeFind_element_user = get_store().find_element_user(GLUESETTINGS$0, 0);
            if (glueSettingsTypeFind_element_user == null) {
                return null;
            }
            return glueSettingsTypeFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public ProtectBkgndsType getProtectBkgnds() {
        synchronized (monitor()) {
            check_orphaned();
            ProtectBkgndsType protectBkgndsTypeFind_element_user = get_store().find_element_user(PROTECTBKGNDS$16, 0);
            if (protectBkgndsTypeFind_element_user == null) {
                return null;
            }
            return protectBkgndsTypeFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public ProtectMastersType getProtectMasters() {
        synchronized (monitor()) {
            check_orphaned();
            ProtectMastersType protectMastersTypeFind_element_user = get_store().find_element_user(PROTECTMASTERS$14, 0);
            if (protectMastersTypeFind_element_user == null) {
                return null;
            }
            return protectMastersTypeFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public ProtectShapesType getProtectShapes() {
        synchronized (monitor()) {
            check_orphaned();
            ProtectShapesType protectShapesTypeFind_element_user = get_store().find_element_user(PROTECTSHAPES$12, 0);
            if (protectShapesTypeFind_element_user == null) {
                return null;
            }
            return protectShapesTypeFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public ProtectStylesType getProtectStyles() {
        synchronized (monitor()) {
            check_orphaned();
            ProtectStylesType protectStylesTypeFind_element_user = get_store().find_element_user(PROTECTSTYLES$10, 0);
            if (protectStylesTypeFind_element_user == null) {
                return null;
            }
            return protectStylesTypeFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public SnapAnglesType getSnapAngles() {
        synchronized (monitor()) {
            check_orphaned();
            SnapAnglesType snapAnglesTypeFind_element_user = get_store().find_element_user(SNAPANGLES$6, 0);
            if (snapAnglesTypeFind_element_user == null) {
                return null;
            }
            return snapAnglesTypeFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public SnapExtensionsType getSnapExtensions() {
        synchronized (monitor()) {
            check_orphaned();
            SnapExtensionsType snapExtensionsTypeFind_element_user = get_store().find_element_user(SNAPEXTENSIONS$4, 0);
            if (snapExtensionsTypeFind_element_user == null) {
                return null;
            }
            return snapExtensionsTypeFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public SnapSettingsType getSnapSettings() {
        synchronized (monitor()) {
            check_orphaned();
            SnapSettingsType snapSettingsTypeFind_element_user = get_store().find_element_user(SNAPSETTINGS$2, 0);
            if (snapSettingsTypeFind_element_user == null) {
                return null;
            }
            return snapSettingsTypeFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public long getTopPage() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TOPPAGE$24);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public boolean isSetAttachedToolbars() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ATTACHEDTOOLBARS$22) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public boolean isSetCustomMenusFile() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CUSTOMMENUSFILE$18) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public boolean isSetCustomToolbarsFile() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CUSTOMTOOLBARSFILE$20) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public boolean isSetDefaultFillStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DEFAULTFILLSTYLE$30) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public boolean isSetDefaultGuideStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DEFAULTGUIDESTYLE$32) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public boolean isSetDefaultLineStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DEFAULTLINESTYLE$28) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public boolean isSetDefaultTextStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DEFAULTTEXTSTYLE$26) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public boolean isSetDynamicGridEnabled() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DYNAMICGRIDENABLED$8) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public boolean isSetGlueSettings() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(GLUESETTINGS$0) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public boolean isSetProtectBkgnds() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROTECTBKGNDS$16) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public boolean isSetProtectMasters() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROTECTMASTERS$14) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public boolean isSetProtectShapes() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROTECTSHAPES$12) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public boolean isSetProtectStyles() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROTECTSTYLES$10) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public boolean isSetSnapAngles() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SNAPANGLES$6) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public boolean isSetSnapExtensions() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SNAPEXTENSIONS$4) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public boolean isSetSnapSettings() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SNAPSETTINGS$2) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public boolean isSetTopPage() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TOPPAGE$24) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void setAttachedToolbars(AttachedToolbarsType attachedToolbarsType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ATTACHEDTOOLBARS$22;
            AttachedToolbarsType attachedToolbarsTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (attachedToolbarsTypeFind_element_user == null) {
                attachedToolbarsTypeFind_element_user = (AttachedToolbarsType) get_store().add_element_user(qName);
            }
            attachedToolbarsTypeFind_element_user.set(attachedToolbarsType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void setCustomMenusFile(CustomMenusFileType customMenusFileType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CUSTOMMENUSFILE$18;
            CustomMenusFileType customMenusFileTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (customMenusFileTypeFind_element_user == null) {
                customMenusFileTypeFind_element_user = (CustomMenusFileType) get_store().add_element_user(qName);
            }
            customMenusFileTypeFind_element_user.set(customMenusFileType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void setCustomToolbarsFile(CustomToolbarsFileType customToolbarsFileType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CUSTOMTOOLBARSFILE$20;
            CustomToolbarsFileType customToolbarsFileTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (customToolbarsFileTypeFind_element_user == null) {
                customToolbarsFileTypeFind_element_user = (CustomToolbarsFileType) get_store().add_element_user(qName);
            }
            customToolbarsFileTypeFind_element_user.set(customToolbarsFileType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void setDefaultFillStyle(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFAULTFILLSTYLE$30;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void setDefaultGuideStyle(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFAULTGUIDESTYLE$32;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void setDefaultLineStyle(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFAULTLINESTYLE$28;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void setDefaultTextStyle(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFAULTTEXTSTYLE$26;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void setDynamicGridEnabled(DynamicGridEnabledType dynamicGridEnabledType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DYNAMICGRIDENABLED$8;
            DynamicGridEnabledType dynamicGridEnabledTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (dynamicGridEnabledTypeFind_element_user == null) {
                dynamicGridEnabledTypeFind_element_user = (DynamicGridEnabledType) get_store().add_element_user(qName);
            }
            dynamicGridEnabledTypeFind_element_user.set(dynamicGridEnabledType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void setGlueSettings(GlueSettingsType glueSettingsType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GLUESETTINGS$0;
            GlueSettingsType glueSettingsTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (glueSettingsTypeFind_element_user == null) {
                glueSettingsTypeFind_element_user = (GlueSettingsType) get_store().add_element_user(qName);
            }
            glueSettingsTypeFind_element_user.set(glueSettingsType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void setProtectBkgnds(ProtectBkgndsType protectBkgndsType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PROTECTBKGNDS$16;
            ProtectBkgndsType protectBkgndsTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (protectBkgndsTypeFind_element_user == null) {
                protectBkgndsTypeFind_element_user = (ProtectBkgndsType) get_store().add_element_user(qName);
            }
            protectBkgndsTypeFind_element_user.set(protectBkgndsType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void setProtectMasters(ProtectMastersType protectMastersType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PROTECTMASTERS$14;
            ProtectMastersType protectMastersTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (protectMastersTypeFind_element_user == null) {
                protectMastersTypeFind_element_user = (ProtectMastersType) get_store().add_element_user(qName);
            }
            protectMastersTypeFind_element_user.set(protectMastersType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void setProtectShapes(ProtectShapesType protectShapesType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PROTECTSHAPES$12;
            ProtectShapesType protectShapesTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (protectShapesTypeFind_element_user == null) {
                protectShapesTypeFind_element_user = (ProtectShapesType) get_store().add_element_user(qName);
            }
            protectShapesTypeFind_element_user.set(protectShapesType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void setProtectStyles(ProtectStylesType protectStylesType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PROTECTSTYLES$10;
            ProtectStylesType protectStylesTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (protectStylesTypeFind_element_user == null) {
                protectStylesTypeFind_element_user = (ProtectStylesType) get_store().add_element_user(qName);
            }
            protectStylesTypeFind_element_user.set(protectStylesType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void setSnapAngles(SnapAnglesType snapAnglesType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SNAPANGLES$6;
            SnapAnglesType snapAnglesTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (snapAnglesTypeFind_element_user == null) {
                snapAnglesTypeFind_element_user = (SnapAnglesType) get_store().add_element_user(qName);
            }
            snapAnglesTypeFind_element_user.set(snapAnglesType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void setSnapExtensions(SnapExtensionsType snapExtensionsType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SNAPEXTENSIONS$4;
            SnapExtensionsType snapExtensionsTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (snapExtensionsTypeFind_element_user == null) {
                snapExtensionsTypeFind_element_user = (SnapExtensionsType) get_store().add_element_user(qName);
            }
            snapExtensionsTypeFind_element_user.set(snapExtensionsType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void setSnapSettings(SnapSettingsType snapSettingsType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SNAPSETTINGS$2;
            SnapSettingsType snapSettingsTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (snapSettingsTypeFind_element_user == null) {
                snapSettingsTypeFind_element_user = (SnapSettingsType) get_store().add_element_user(qName);
            }
            snapSettingsTypeFind_element_user.set(snapSettingsType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void setTopPage(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TOPPAGE$24;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void unsetAttachedToolbars() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ATTACHEDTOOLBARS$22, 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void unsetCustomMenusFile() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMMENUSFILE$18, 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void unsetCustomToolbarsFile() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMTOOLBARSFILE$20, 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void unsetDefaultFillStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DEFAULTFILLSTYLE$30);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void unsetDefaultGuideStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DEFAULTGUIDESTYLE$32);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void unsetDefaultLineStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DEFAULTLINESTYLE$28);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void unsetDefaultTextStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DEFAULTTEXTSTYLE$26);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void unsetDynamicGridEnabled() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DYNAMICGRIDENABLED$8, 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void unsetGlueSettings() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GLUESETTINGS$0, 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void unsetProtectBkgnds() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROTECTBKGNDS$16, 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void unsetProtectMasters() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROTECTMASTERS$14, 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void unsetProtectShapes() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROTECTSHAPES$12, 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void unsetProtectStyles() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROTECTSTYLES$10, 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void unsetSnapAngles() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SNAPANGLES$6, 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void unsetSnapExtensions() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SNAPEXTENSIONS$4, 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void unsetSnapSettings() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SNAPSETTINGS$2, 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void unsetTopPage() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TOPPAGE$24);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public XmlUnsignedInt xgetDefaultFillStyle() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(DEFAULTFILLSTYLE$30);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public XmlUnsignedInt xgetDefaultGuideStyle() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(DEFAULTGUIDESTYLE$32);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public XmlUnsignedInt xgetDefaultLineStyle() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(DEFAULTLINESTYLE$28);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public XmlUnsignedInt xgetDefaultTextStyle() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(DEFAULTTEXTSTYLE$26);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public XmlUnsignedInt xgetTopPage() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(TOPPAGE$24);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void xsetDefaultFillStyle(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFAULTFILLSTYLE$30;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void xsetDefaultGuideStyle(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFAULTGUIDESTYLE$32;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void xsetDefaultLineStyle(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFAULTLINESTYLE$28;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void xsetDefaultTextStyle(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFAULTTEXTSTYLE$26;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void xsetTopPage(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TOPPAGE$24;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }
}
