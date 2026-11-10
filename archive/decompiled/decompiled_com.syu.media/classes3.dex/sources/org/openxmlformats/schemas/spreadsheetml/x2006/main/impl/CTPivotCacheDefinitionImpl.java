package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlUnsignedByte;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheFields;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheHierarchies;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheSource;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalculatedItems;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalculatedMembers;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDimensions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMeasureDimensionMaps;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMeasureGroups;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPCDKPIs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTupleCache;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTPivotCacheDefinitionImpl extends XmlComplexContentImpl implements CTPivotCacheDefinition {
    private static final QName CACHESOURCE$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "cacheSource");
    private static final QName CACHEFIELDS$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "cacheFields");
    private static final QName CACHEHIERARCHIES$4 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "cacheHierarchies");
    private static final QName KPIS$6 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "kpis");
    private static final QName TUPLECACHE$8 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "tupleCache");
    private static final QName CALCULATEDITEMS$10 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "calculatedItems");
    private static final QName CALCULATEDMEMBERS$12 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "calculatedMembers");
    private static final QName DIMENSIONS$14 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "dimensions");
    private static final QName MEASUREGROUPS$16 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "measureGroups");
    private static final QName MAPS$18 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "maps");
    private static final QName EXTLST$20 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
    private static final QName ID$22 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "id");
    private static final QName INVALID$24 = new QName("", "invalid");
    private static final QName SAVEDATA$26 = new QName("", "saveData");
    private static final QName REFRESHONLOAD$28 = new QName("", "refreshOnLoad");
    private static final QName OPTIMIZEMEMORY$30 = new QName("", "optimizeMemory");
    private static final QName ENABLEREFRESH$32 = new QName("", "enableRefresh");
    private static final QName REFRESHEDBY$34 = new QName("", "refreshedBy");
    private static final QName REFRESHEDDATE$36 = new QName("", "refreshedDate");
    private static final QName BACKGROUNDQUERY$38 = new QName("", "backgroundQuery");
    private static final QName MISSINGITEMSLIMIT$40 = new QName("", "missingItemsLimit");
    private static final QName CREATEDVERSION$42 = new QName("", "createdVersion");
    private static final QName REFRESHEDVERSION$44 = new QName("", "refreshedVersion");
    private static final QName MINREFRESHABLEVERSION$46 = new QName("", "minRefreshableVersion");
    private static final QName RECORDCOUNT$48 = new QName("", "recordCount");
    private static final QName UPGRADEONREFRESH$50 = new QName("", "upgradeOnRefresh");
    private static final QName TUPLECACHE2$52 = new QName("", "tupleCache");
    private static final QName SUPPORTSUBQUERY$54 = new QName("", "supportSubquery");
    private static final QName SUPPORTADVANCEDDRILL$56 = new QName("", "supportAdvancedDrill");

    public CTPivotCacheDefinitionImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public CTCacheFields addNewCacheFields() {
        CTCacheFields cTCacheFields;
        synchronized (monitor()) {
            check_orphaned();
            cTCacheFields = (CTCacheFields) get_store().add_element_user(CACHEFIELDS$2);
        }
        return cTCacheFields;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public CTCacheHierarchies addNewCacheHierarchies() {
        CTCacheHierarchies cTCacheHierarchiesAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCacheHierarchiesAdd_element_user = get_store().add_element_user(CACHEHIERARCHIES$4);
        }
        return cTCacheHierarchiesAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public CTCacheSource addNewCacheSource() {
        CTCacheSource cTCacheSource;
        synchronized (monitor()) {
            check_orphaned();
            cTCacheSource = (CTCacheSource) get_store().add_element_user(CACHESOURCE$0);
        }
        return cTCacheSource;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public CTCalculatedItems addNewCalculatedItems() {
        CTCalculatedItems cTCalculatedItemsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCalculatedItemsAdd_element_user = get_store().add_element_user(CALCULATEDITEMS$10);
        }
        return cTCalculatedItemsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public CTCalculatedMembers addNewCalculatedMembers() {
        CTCalculatedMembers cTCalculatedMembersAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCalculatedMembersAdd_element_user = get_store().add_element_user(CALCULATEDMEMBERS$12);
        }
        return cTCalculatedMembersAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public CTDimensions addNewDimensions() {
        CTDimensions cTDimensionsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDimensionsAdd_element_user = get_store().add_element_user(DIMENSIONS$14);
        }
        return cTDimensionsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$20);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public CTPCDKPIs addNewKpis() {
        CTPCDKPIs cTPCDKPIsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPCDKPIsAdd_element_user = get_store().add_element_user(KPIS$6);
        }
        return cTPCDKPIsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public CTMeasureDimensionMaps addNewMaps() {
        CTMeasureDimensionMaps cTMeasureDimensionMapsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMeasureDimensionMapsAdd_element_user = get_store().add_element_user(MAPS$18);
        }
        return cTMeasureDimensionMapsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public CTMeasureGroups addNewMeasureGroups() {
        CTMeasureGroups cTMeasureGroupsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMeasureGroupsAdd_element_user = get_store().add_element_user(MEASUREGROUPS$16);
        }
        return cTMeasureGroupsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public CTTupleCache addNewTupleCache() {
        CTTupleCache cTTupleCacheAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTupleCacheAdd_element_user = get_store().add_element_user(TUPLECACHE$8);
        }
        return cTTupleCacheAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean getBackgroundQuery() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BACKGROUNDQUERY$38;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public CTCacheFields getCacheFields() {
        synchronized (monitor()) {
            check_orphaned();
            CTCacheFields cTCacheFields = (CTCacheFields) get_store().find_element_user(CACHEFIELDS$2, 0);
            if (cTCacheFields == null) {
                return null;
            }
            return cTCacheFields;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public CTCacheHierarchies getCacheHierarchies() {
        synchronized (monitor()) {
            check_orphaned();
            CTCacheHierarchies cTCacheHierarchiesFind_element_user = get_store().find_element_user(CACHEHIERARCHIES$4, 0);
            if (cTCacheHierarchiesFind_element_user == null) {
                return null;
            }
            return cTCacheHierarchiesFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public CTCacheSource getCacheSource() {
        synchronized (monitor()) {
            check_orphaned();
            CTCacheSource cTCacheSource = (CTCacheSource) get_store().find_element_user(CACHESOURCE$0, 0);
            if (cTCacheSource == null) {
                return null;
            }
            return cTCacheSource;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public CTCalculatedItems getCalculatedItems() {
        synchronized (monitor()) {
            check_orphaned();
            CTCalculatedItems cTCalculatedItemsFind_element_user = get_store().find_element_user(CALCULATEDITEMS$10, 0);
            if (cTCalculatedItemsFind_element_user == null) {
                return null;
            }
            return cTCalculatedItemsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public CTCalculatedMembers getCalculatedMembers() {
        synchronized (monitor()) {
            check_orphaned();
            CTCalculatedMembers cTCalculatedMembersFind_element_user = get_store().find_element_user(CALCULATEDMEMBERS$12, 0);
            if (cTCalculatedMembersFind_element_user == null) {
                return null;
            }
            return cTCalculatedMembersFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public short getCreatedVersion() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CREATEDVERSION$42;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return (short) 0;
            }
            return simpleValueFind_attribute_user.getShortValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public CTDimensions getDimensions() {
        synchronized (monitor()) {
            check_orphaned();
            CTDimensions cTDimensionsFind_element_user = get_store().find_element_user(DIMENSIONS$14, 0);
            if (cTDimensionsFind_element_user == null) {
                return null;
            }
            return cTDimensionsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean getEnableRefresh() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENABLEREFRESH$32;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList cTExtensionListFind_element_user = get_store().find_element_user(EXTLST$20, 0);
            if (cTExtensionListFind_element_user == null) {
                return null;
            }
            return cTExtensionListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ID$22);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean getInvalid() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INVALID$24;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public CTPCDKPIs getKpis() {
        synchronized (monitor()) {
            check_orphaned();
            CTPCDKPIs cTPCDKPIsFind_element_user = get_store().find_element_user(KPIS$6, 0);
            if (cTPCDKPIsFind_element_user == null) {
                return null;
            }
            return cTPCDKPIsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public CTMeasureDimensionMaps getMaps() {
        synchronized (monitor()) {
            check_orphaned();
            CTMeasureDimensionMaps cTMeasureDimensionMapsFind_element_user = get_store().find_element_user(MAPS$18, 0);
            if (cTMeasureDimensionMapsFind_element_user == null) {
                return null;
            }
            return cTMeasureDimensionMapsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public CTMeasureGroups getMeasureGroups() {
        synchronized (monitor()) {
            check_orphaned();
            CTMeasureGroups cTMeasureGroupsFind_element_user = get_store().find_element_user(MEASUREGROUPS$16, 0);
            if (cTMeasureGroupsFind_element_user == null) {
                return null;
            }
            return cTMeasureGroupsFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public short getMinRefreshableVersion() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINREFRESHABLEVERSION$46;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return (short) 0;
            }
            return simpleValueFind_attribute_user.getShortValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public long getMissingItemsLimit() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(MISSINGITEMSLIMIT$40);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean getOptimizeMemory() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OPTIMIZEMEMORY$30;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public long getRecordCount() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(RECORDCOUNT$48);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean getRefreshOnLoad() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REFRESHONLOAD$28;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public String getRefreshedBy() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(REFRESHEDBY$34);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public double getRefreshedDate() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(REFRESHEDDATE$36);
            if (simpleValueFind_attribute_user == null) {
                return 0.0d;
            }
            return simpleValueFind_attribute_user.getDoubleValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public short getRefreshedVersion() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REFRESHEDVERSION$44;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return (short) 0;
            }
            return simpleValueFind_attribute_user.getShortValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean getSaveData() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SAVEDATA$26;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean getSupportAdvancedDrill() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SUPPORTADVANCEDDRILL$56;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean getSupportSubquery() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SUPPORTSUBQUERY$54;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public CTTupleCache getTupleCache() {
        synchronized (monitor()) {
            check_orphaned();
            CTTupleCache cTTupleCacheFind_element_user = get_store().find_element_user(TUPLECACHE$8, 0);
            if (cTTupleCacheFind_element_user == null) {
                return null;
            }
            return cTTupleCacheFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean getTupleCache2() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TUPLECACHE2$52;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean getUpgradeOnRefresh() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UPGRADEONREFRESH$50;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean isSetBackgroundQuery() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BACKGROUNDQUERY$38) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean isSetCacheHierarchies() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CACHEHIERARCHIES$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean isSetCalculatedItems() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CALCULATEDITEMS$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean isSetCalculatedMembers() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CALCULATEDMEMBERS$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean isSetCreatedVersion() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CREATEDVERSION$42) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean isSetDimensions() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DIMENSIONS$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean isSetEnableRefresh() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ENABLEREFRESH$32) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$22) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean isSetInvalid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(INVALID$24) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean isSetKpis() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(KPIS$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean isSetMaps() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MAPS$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean isSetMeasureGroups() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MEASUREGROUPS$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean isSetMinRefreshableVersion() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MINREFRESHABLEVERSION$46) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean isSetMissingItemsLimit() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MISSINGITEMSLIMIT$40) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean isSetOptimizeMemory() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(OPTIMIZEMEMORY$30) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean isSetRecordCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(RECORDCOUNT$48) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean isSetRefreshOnLoad() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(REFRESHONLOAD$28) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean isSetRefreshedBy() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(REFRESHEDBY$34) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean isSetRefreshedDate() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(REFRESHEDDATE$36) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean isSetRefreshedVersion() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(REFRESHEDVERSION$44) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean isSetSaveData() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SAVEDATA$26) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean isSetSupportAdvancedDrill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SUPPORTADVANCEDDRILL$56) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean isSetSupportSubquery() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SUPPORTSUBQUERY$54) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean isSetTupleCache() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TUPLECACHE$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean isSetTupleCache2() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TUPLECACHE2$52) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public boolean isSetUpgradeOnRefresh() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(UPGRADEONREFRESH$50) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void setBackgroundQuery(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BACKGROUNDQUERY$38;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void setCacheFields(CTCacheFields cTCacheFields) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CACHEFIELDS$2;
            CTCacheFields cTCacheFields2 = (CTCacheFields) typeStore.find_element_user(qName, 0);
            if (cTCacheFields2 == null) {
                cTCacheFields2 = (CTCacheFields) get_store().add_element_user(qName);
            }
            cTCacheFields2.set(cTCacheFields);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void setCacheHierarchies(CTCacheHierarchies cTCacheHierarchies) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CACHEHIERARCHIES$4;
            CTCacheHierarchies cTCacheHierarchiesFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTCacheHierarchiesFind_element_user == null) {
                cTCacheHierarchiesFind_element_user = (CTCacheHierarchies) get_store().add_element_user(qName);
            }
            cTCacheHierarchiesFind_element_user.set(cTCacheHierarchies);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void setCacheSource(CTCacheSource cTCacheSource) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CACHESOURCE$0;
            CTCacheSource cTCacheSource2 = (CTCacheSource) typeStore.find_element_user(qName, 0);
            if (cTCacheSource2 == null) {
                cTCacheSource2 = (CTCacheSource) get_store().add_element_user(qName);
            }
            cTCacheSource2.set(cTCacheSource);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void setCalculatedItems(CTCalculatedItems cTCalculatedItems) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CALCULATEDITEMS$10;
            CTCalculatedItems cTCalculatedItemsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTCalculatedItemsFind_element_user == null) {
                cTCalculatedItemsFind_element_user = (CTCalculatedItems) get_store().add_element_user(qName);
            }
            cTCalculatedItemsFind_element_user.set(cTCalculatedItems);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void setCalculatedMembers(CTCalculatedMembers cTCalculatedMembers) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CALCULATEDMEMBERS$12;
            CTCalculatedMembers cTCalculatedMembersFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTCalculatedMembersFind_element_user == null) {
                cTCalculatedMembersFind_element_user = (CTCalculatedMembers) get_store().add_element_user(qName);
            }
            cTCalculatedMembersFind_element_user.set(cTCalculatedMembers);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void setCreatedVersion(short s) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CREATEDVERSION$42;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setShortValue(s);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void setDimensions(CTDimensions cTDimensions) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIMENSIONS$14;
            CTDimensions cTDimensionsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTDimensionsFind_element_user == null) {
                cTDimensionsFind_element_user = (CTDimensions) get_store().add_element_user(qName);
            }
            cTDimensionsFind_element_user.set(cTDimensions);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void setEnableRefresh(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENABLEREFRESH$32;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$20;
            CTExtensionList cTExtensionListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExtensionListFind_element_user == null) {
                cTExtensionListFind_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            cTExtensionListFind_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$22;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void setInvalid(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INVALID$24;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void setKpis(CTPCDKPIs cTPCDKPIs) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = KPIS$6;
            CTPCDKPIs cTPCDKPIsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTPCDKPIsFind_element_user == null) {
                cTPCDKPIsFind_element_user = (CTPCDKPIs) get_store().add_element_user(qName);
            }
            cTPCDKPIsFind_element_user.set(cTPCDKPIs);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void setMaps(CTMeasureDimensionMaps cTMeasureDimensionMaps) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAPS$18;
            CTMeasureDimensionMaps cTMeasureDimensionMapsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTMeasureDimensionMapsFind_element_user == null) {
                cTMeasureDimensionMapsFind_element_user = (CTMeasureDimensionMaps) get_store().add_element_user(qName);
            }
            cTMeasureDimensionMapsFind_element_user.set(cTMeasureDimensionMaps);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void setMeasureGroups(CTMeasureGroups cTMeasureGroups) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MEASUREGROUPS$16;
            CTMeasureGroups cTMeasureGroupsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTMeasureGroupsFind_element_user == null) {
                cTMeasureGroupsFind_element_user = (CTMeasureGroups) get_store().add_element_user(qName);
            }
            cTMeasureGroupsFind_element_user.set(cTMeasureGroups);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void setMinRefreshableVersion(short s) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINREFRESHABLEVERSION$46;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setShortValue(s);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void setMissingItemsLimit(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MISSINGITEMSLIMIT$40;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void setOptimizeMemory(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OPTIMIZEMEMORY$30;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void setRecordCount(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RECORDCOUNT$48;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void setRefreshOnLoad(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REFRESHONLOAD$28;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void setRefreshedBy(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REFRESHEDBY$34;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void setRefreshedDate(double d) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REFRESHEDDATE$36;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setDoubleValue(d);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void setRefreshedVersion(short s) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REFRESHEDVERSION$44;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setShortValue(s);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void setSaveData(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SAVEDATA$26;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void setSupportAdvancedDrill(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SUPPORTADVANCEDDRILL$56;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void setSupportSubquery(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SUPPORTSUBQUERY$54;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void setTupleCache(CTTupleCache cTTupleCache) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TUPLECACHE$8;
            CTTupleCache cTTupleCacheFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTupleCacheFind_element_user == null) {
                cTTupleCacheFind_element_user = (CTTupleCache) get_store().add_element_user(qName);
            }
            cTTupleCacheFind_element_user.set(cTTupleCache);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void setTupleCache2(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TUPLECACHE2$52;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void setUpgradeOnRefresh(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UPGRADEONREFRESH$50;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void unsetBackgroundQuery() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BACKGROUNDQUERY$38);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void unsetCacheHierarchies() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CACHEHIERARCHIES$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void unsetCalculatedItems() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CALCULATEDITEMS$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void unsetCalculatedMembers() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CALCULATEDMEMBERS$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void unsetCreatedVersion() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CREATEDVERSION$42);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void unsetDimensions() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DIMENSIONS$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void unsetEnableRefresh() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ENABLEREFRESH$32);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$22);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void unsetInvalid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(INVALID$24);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void unsetKpis() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(KPIS$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void unsetMaps() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MAPS$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void unsetMeasureGroups() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MEASUREGROUPS$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void unsetMinRefreshableVersion() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MINREFRESHABLEVERSION$46);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void unsetMissingItemsLimit() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MISSINGITEMSLIMIT$40);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void unsetOptimizeMemory() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(OPTIMIZEMEMORY$30);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void unsetRecordCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(RECORDCOUNT$48);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void unsetRefreshOnLoad() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(REFRESHONLOAD$28);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void unsetRefreshedBy() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(REFRESHEDBY$34);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void unsetRefreshedDate() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(REFRESHEDDATE$36);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void unsetRefreshedVersion() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(REFRESHEDVERSION$44);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void unsetSaveData() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SAVEDATA$26);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void unsetSupportAdvancedDrill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SUPPORTADVANCEDDRILL$56);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void unsetSupportSubquery() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SUPPORTSUBQUERY$54);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void unsetTupleCache() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TUPLECACHE$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void unsetTupleCache2() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TUPLECACHE2$52);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void unsetUpgradeOnRefresh() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(UPGRADEONREFRESH$50);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public XmlBoolean xgetBackgroundQuery() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BACKGROUNDQUERY$38;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public XmlUnsignedByte xgetCreatedVersion() {
        XmlUnsignedByte xmlUnsignedByteFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CREATEDVERSION$42;
            xmlUnsignedByteFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedByteFind_attribute_user == null) {
                xmlUnsignedByteFind_attribute_user = (XmlUnsignedByte) get_default_attribute_value(qName);
            }
        }
        return xmlUnsignedByteFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public XmlBoolean xgetEnableRefresh() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENABLEREFRESH$32;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public STRelationshipId xgetId() {
        STRelationshipId sTRelationshipId;
        synchronized (monitor()) {
            check_orphaned();
            sTRelationshipId = (STRelationshipId) get_store().find_attribute_user(ID$22);
        }
        return sTRelationshipId;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public XmlBoolean xgetInvalid() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INVALID$24;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public XmlUnsignedByte xgetMinRefreshableVersion() {
        XmlUnsignedByte xmlUnsignedByteFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINREFRESHABLEVERSION$46;
            xmlUnsignedByteFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedByteFind_attribute_user == null) {
                xmlUnsignedByteFind_attribute_user = (XmlUnsignedByte) get_default_attribute_value(qName);
            }
        }
        return xmlUnsignedByteFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public XmlUnsignedInt xgetMissingItemsLimit() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(MISSINGITEMSLIMIT$40);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public XmlBoolean xgetOptimizeMemory() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OPTIMIZEMEMORY$30;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public XmlUnsignedInt xgetRecordCount() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(RECORDCOUNT$48);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public XmlBoolean xgetRefreshOnLoad() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REFRESHONLOAD$28;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public STXstring xgetRefreshedBy() {
        STXstring sTXstring;
        synchronized (monitor()) {
            check_orphaned();
            sTXstring = (STXstring) get_store().find_attribute_user(REFRESHEDBY$34);
        }
        return sTXstring;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public XmlDouble xgetRefreshedDate() {
        XmlDouble xmlDoubleFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlDoubleFind_attribute_user = get_store().find_attribute_user(REFRESHEDDATE$36);
        }
        return xmlDoubleFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public XmlUnsignedByte xgetRefreshedVersion() {
        XmlUnsignedByte xmlUnsignedByteFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REFRESHEDVERSION$44;
            xmlUnsignedByteFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedByteFind_attribute_user == null) {
                xmlUnsignedByteFind_attribute_user = (XmlUnsignedByte) get_default_attribute_value(qName);
            }
        }
        return xmlUnsignedByteFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public XmlBoolean xgetSaveData() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SAVEDATA$26;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public XmlBoolean xgetSupportAdvancedDrill() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SUPPORTADVANCEDDRILL$56;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public XmlBoolean xgetSupportSubquery() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SUPPORTSUBQUERY$54;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public XmlBoolean xgetTupleCache2() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TUPLECACHE2$52;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public XmlBoolean xgetUpgradeOnRefresh() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UPGRADEONREFRESH$50;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void xsetBackgroundQuery(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BACKGROUNDQUERY$38;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void xsetCreatedVersion(XmlUnsignedByte xmlUnsignedByte) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CREATEDVERSION$42;
            XmlUnsignedByte xmlUnsignedByteFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedByteFind_attribute_user == null) {
                xmlUnsignedByteFind_attribute_user = (XmlUnsignedByte) get_store().add_attribute_user(qName);
            }
            xmlUnsignedByteFind_attribute_user.set(xmlUnsignedByte);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void xsetEnableRefresh(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENABLEREFRESH$32;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void xsetId(STRelationshipId sTRelationshipId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$22;
            STRelationshipId sTRelationshipId2 = (STRelationshipId) typeStore.find_attribute_user(qName);
            if (sTRelationshipId2 == null) {
                sTRelationshipId2 = (STRelationshipId) get_store().add_attribute_user(qName);
            }
            sTRelationshipId2.set(sTRelationshipId);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void xsetInvalid(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INVALID$24;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void xsetMinRefreshableVersion(XmlUnsignedByte xmlUnsignedByte) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINREFRESHABLEVERSION$46;
            XmlUnsignedByte xmlUnsignedByteFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedByteFind_attribute_user == null) {
                xmlUnsignedByteFind_attribute_user = (XmlUnsignedByte) get_store().add_attribute_user(qName);
            }
            xmlUnsignedByteFind_attribute_user.set(xmlUnsignedByte);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void xsetMissingItemsLimit(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MISSINGITEMSLIMIT$40;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void xsetOptimizeMemory(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OPTIMIZEMEMORY$30;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void xsetRecordCount(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RECORDCOUNT$48;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void xsetRefreshOnLoad(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REFRESHONLOAD$28;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void xsetRefreshedBy(STXstring sTXstring) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REFRESHEDBY$34;
            STXstring sTXstring2 = (STXstring) typeStore.find_attribute_user(qName);
            if (sTXstring2 == null) {
                sTXstring2 = (STXstring) get_store().add_attribute_user(qName);
            }
            sTXstring2.set(sTXstring);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void xsetRefreshedDate(XmlDouble xmlDouble) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REFRESHEDDATE$36;
            XmlDouble xmlDoubleFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlDoubleFind_attribute_user == null) {
                xmlDoubleFind_attribute_user = (XmlDouble) get_store().add_attribute_user(qName);
            }
            xmlDoubleFind_attribute_user.set(xmlDouble);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void xsetRefreshedVersion(XmlUnsignedByte xmlUnsignedByte) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REFRESHEDVERSION$44;
            XmlUnsignedByte xmlUnsignedByteFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedByteFind_attribute_user == null) {
                xmlUnsignedByteFind_attribute_user = (XmlUnsignedByte) get_store().add_attribute_user(qName);
            }
            xmlUnsignedByteFind_attribute_user.set(xmlUnsignedByte);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void xsetSaveData(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SAVEDATA$26;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void xsetSupportAdvancedDrill(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SUPPORTADVANCEDDRILL$56;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void xsetSupportSubquery(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SUPPORTSUBQUERY$54;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void xsetTupleCache2(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TUPLECACHE2$52;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition
    public void xsetUpgradeOnRefresh(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UPGRADEONREFRESH$50;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }
}
