package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBoolean;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDateTime;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTError;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMissing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumber;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTString;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTSharedItemsImpl extends XmlComplexContentImpl implements CTSharedItems {
    private static final QName M$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "m");
    private static final QName N$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "n");
    private static final QName B$4 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "b");
    private static final QName E$6 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "e");
    private static final QName S$8 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "s");
    private static final QName D$10 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "d");
    private static final QName CONTAINSSEMIMIXEDTYPES$12 = new QName("", "containsSemiMixedTypes");
    private static final QName CONTAINSNONDATE$14 = new QName("", "containsNonDate");
    private static final QName CONTAINSDATE$16 = new QName("", "containsDate");
    private static final QName CONTAINSSTRING$18 = new QName("", "containsString");
    private static final QName CONTAINSBLANK$20 = new QName("", "containsBlank");
    private static final QName CONTAINSMIXEDTYPES$22 = new QName("", "containsMixedTypes");
    private static final QName CONTAINSNUMBER$24 = new QName("", "containsNumber");
    private static final QName CONTAINSINTEGER$26 = new QName("", "containsInteger");
    private static final QName MINVALUE$28 = new QName("", "minValue");
    private static final QName MAXVALUE$30 = new QName("", "maxValue");
    private static final QName MINDATE$32 = new QName("", "minDate");
    private static final QName MAXDATE$34 = new QName("", "maxDate");
    private static final QName COUNT$36 = new QName("", "count");
    private static final QName LONGTEXT$38 = new QName("", "longText");

    public CTSharedItemsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTBoolean addNewB() {
        CTBoolean cTBooleanAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanAdd_element_user = get_store().add_element_user(B$4);
        }
        return cTBooleanAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTDateTime addNewD() {
        CTDateTime cTDateTimeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDateTimeAdd_element_user = get_store().add_element_user(D$10);
        }
        return cTDateTimeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTError addNewE() {
        CTError cTErrorAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTErrorAdd_element_user = get_store().add_element_user(E$6);
        }
        return cTErrorAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTMissing addNewM() {
        CTMissing cTMissingAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMissingAdd_element_user = get_store().add_element_user(M$0);
        }
        return cTMissingAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTNumber addNewN() {
        CTNumber cTNumberAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTNumberAdd_element_user = get_store().add_element_user(N$2);
        }
        return cTNumberAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTString addNewS() {
        CTString cTStringAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStringAdd_element_user = get_store().add_element_user(S$8);
        }
        return cTStringAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTBoolean getBArray(int i) {
        CTBoolean cTBooleanFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanFind_element_user = get_store().find_element_user(B$4, i);
            if (cTBooleanFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBooleanFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTBoolean[] getBArray() {
        CTBoolean[] cTBooleanArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(B$4, arrayList);
            cTBooleanArr = new CTBoolean[arrayList.size()];
            arrayList.toArray(cTBooleanArr);
        }
        return cTBooleanArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public List<CTBoolean> getBList() {
        1BList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean getContainsBlank() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSBLANK$20;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean getContainsDate() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSDATE$16;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean getContainsInteger() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSINTEGER$26;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean getContainsMixedTypes() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSMIXEDTYPES$22;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean getContainsNonDate() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSNONDATE$14;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean getContainsNumber() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSNUMBER$24;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean getContainsSemiMixedTypes() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSSEMIMIXEDTYPES$12;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean getContainsString() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSSTRING$18;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public long getCount() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(COUNT$36);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTDateTime getDArray(int i) {
        CTDateTime cTDateTimeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDateTimeFind_element_user = get_store().find_element_user(D$10, i);
            if (cTDateTimeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTDateTimeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTDateTime[] getDArray() {
        CTDateTime[] cTDateTimeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(D$10, arrayList);
            cTDateTimeArr = new CTDateTime[arrayList.size()];
            arrayList.toArray(cTDateTimeArr);
        }
        return cTDateTimeArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public List<CTDateTime> getDList() {
        1DList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTError getEArray(int i) {
        CTError cTErrorFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTErrorFind_element_user = get_store().find_element_user(E$6, i);
            if (cTErrorFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTErrorFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTError[] getEArray() {
        CTError[] cTErrorArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(E$6, arrayList);
            cTErrorArr = new CTError[arrayList.size()];
            arrayList.toArray(cTErrorArr);
        }
        return cTErrorArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public List<CTError> getEList() {
        1EList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1EList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean getLongText() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LONGTEXT$38;
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTMissing getMArray(int i) {
        CTMissing cTMissingFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMissingFind_element_user = get_store().find_element_user(M$0, i);
            if (cTMissingFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMissingFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTMissing[] getMArray() {
        CTMissing[] cTMissingArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(M$0, arrayList);
            cTMissingArr = new CTMissing[arrayList.size()];
            arrayList.toArray(cTMissingArr);
        }
        return cTMissingArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public List<CTMissing> getMList() {
        1MList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public Calendar getMaxDate() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(MAXDATE$34);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getCalendarValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public double getMaxValue() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(MAXVALUE$30);
            if (simpleValueFind_attribute_user == null) {
                return 0.0d;
            }
            return simpleValueFind_attribute_user.getDoubleValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public Calendar getMinDate() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(MINDATE$32);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getCalendarValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public double getMinValue() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(MINVALUE$28);
            if (simpleValueFind_attribute_user == null) {
                return 0.0d;
            }
            return simpleValueFind_attribute_user.getDoubleValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTNumber getNArray(int i) {
        CTNumber cTNumberFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTNumberFind_element_user = get_store().find_element_user(N$2, i);
            if (cTNumberFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTNumberFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTNumber[] getNArray() {
        CTNumber[] cTNumberArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(N$2, arrayList);
            cTNumberArr = new CTNumber[arrayList.size()];
            arrayList.toArray(cTNumberArr);
        }
        return cTNumberArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public List<CTNumber> getNList() {
        1NList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1NList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTString getSArray(int i) {
        CTString cTStringFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStringFind_element_user = get_store().find_element_user(S$8, i);
            if (cTStringFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTStringFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTString[] getSArray() {
        CTString[] cTStringArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(S$8, arrayList);
            cTStringArr = new CTString[arrayList.size()];
            arrayList.toArray(cTStringArr);
        }
        return cTStringArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public List<CTString> getSList() {
        1SList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTBoolean insertNewB(int i) {
        CTBoolean cTBooleanInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanInsert_element_user = get_store().insert_element_user(B$4, i);
        }
        return cTBooleanInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTDateTime insertNewD(int i) {
        CTDateTime cTDateTimeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDateTimeInsert_element_user = get_store().insert_element_user(D$10, i);
        }
        return cTDateTimeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTError insertNewE(int i) {
        CTError cTErrorInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTErrorInsert_element_user = get_store().insert_element_user(E$6, i);
        }
        return cTErrorInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTMissing insertNewM(int i) {
        CTMissing cTMissingInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMissingInsert_element_user = get_store().insert_element_user(M$0, i);
        }
        return cTMissingInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTNumber insertNewN(int i) {
        CTNumber cTNumberInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTNumberInsert_element_user = get_store().insert_element_user(N$2, i);
        }
        return cTNumberInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTString insertNewS(int i) {
        CTString cTStringInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStringInsert_element_user = get_store().insert_element_user(S$8, i);
        }
        return cTStringInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetContainsBlank() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CONTAINSBLANK$20) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetContainsDate() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CONTAINSDATE$16) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetContainsInteger() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CONTAINSINTEGER$26) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetContainsMixedTypes() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CONTAINSMIXEDTYPES$22) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetContainsNonDate() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CONTAINSNONDATE$14) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetContainsNumber() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CONTAINSNUMBER$24) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetContainsSemiMixedTypes() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CONTAINSSEMIMIXEDTYPES$12) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetContainsString() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CONTAINSSTRING$18) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COUNT$36) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetLongText() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(LONGTEXT$38) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetMaxDate() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MAXDATE$34) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetMaxValue() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MAXVALUE$30) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetMinDate() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MINDATE$32) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetMinValue() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MINVALUE$28) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void removeB(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(B$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void removeD(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(D$10, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void removeE(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(E$6, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void removeM(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(M$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void removeN(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(N$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void removeS(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(S$8, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setBArray(int i, CTBoolean cTBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            CTBoolean cTBooleanFind_element_user = get_store().find_element_user(B$4, i);
            if (cTBooleanFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTBooleanFind_element_user.set(cTBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setBArray(CTBoolean[] cTBooleanArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTBooleanArr, B$4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setContainsBlank(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSBLANK$20;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setContainsDate(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSDATE$16;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setContainsInteger(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSINTEGER$26;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setContainsMixedTypes(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSMIXEDTYPES$22;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setContainsNonDate(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSNONDATE$14;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setContainsNumber(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSNUMBER$24;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setContainsSemiMixedTypes(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSSEMIMIXEDTYPES$12;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setContainsString(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSSTRING$18;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setCount(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COUNT$36;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setDArray(int i, CTDateTime cTDateTime) {
        synchronized (monitor()) {
            check_orphaned();
            CTDateTime cTDateTimeFind_element_user = get_store().find_element_user(D$10, i);
            if (cTDateTimeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTDateTimeFind_element_user.set(cTDateTime);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setDArray(CTDateTime[] cTDateTimeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTDateTimeArr, D$10);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setEArray(int i, CTError cTError) {
        synchronized (monitor()) {
            check_orphaned();
            CTError cTErrorFind_element_user = get_store().find_element_user(E$6, i);
            if (cTErrorFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTErrorFind_element_user.set(cTError);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setEArray(CTError[] cTErrorArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTErrorArr, E$6);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setLongText(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LONGTEXT$38;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setMArray(int i, CTMissing cTMissing) {
        synchronized (monitor()) {
            check_orphaned();
            CTMissing cTMissingFind_element_user = get_store().find_element_user(M$0, i);
            if (cTMissingFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMissingFind_element_user.set(cTMissing);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setMArray(CTMissing[] cTMissingArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTMissingArr, M$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setMaxDate(Calendar calendar) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAXDATE$34;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setCalendarValue(calendar);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setMaxValue(double d) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAXVALUE$30;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setDoubleValue(d);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setMinDate(Calendar calendar) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINDATE$32;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setCalendarValue(calendar);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setMinValue(double d) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINVALUE$28;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setDoubleValue(d);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setNArray(int i, CTNumber cTNumber) {
        synchronized (monitor()) {
            check_orphaned();
            CTNumber cTNumberFind_element_user = get_store().find_element_user(N$2, i);
            if (cTNumberFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTNumberFind_element_user.set(cTNumber);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setNArray(CTNumber[] cTNumberArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTNumberArr, N$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setSArray(int i, CTString cTString) {
        synchronized (monitor()) {
            check_orphaned();
            CTString cTStringFind_element_user = get_store().find_element_user(S$8, i);
            if (cTStringFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTStringFind_element_user.set(cTString);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setSArray(CTString[] cTStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTStringArr, S$8);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public int sizeOfBArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(B$4);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public int sizeOfDArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(D$10);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public int sizeOfEArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(E$6);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public int sizeOfMArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(M$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public int sizeOfNArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(N$2);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public int sizeOfSArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(S$8);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetContainsBlank() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CONTAINSBLANK$20);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetContainsDate() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CONTAINSDATE$16);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetContainsInteger() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CONTAINSINTEGER$26);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetContainsMixedTypes() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CONTAINSMIXEDTYPES$22);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetContainsNonDate() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CONTAINSNONDATE$14);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetContainsNumber() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CONTAINSNUMBER$24);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetContainsSemiMixedTypes() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CONTAINSSEMIMIXEDTYPES$12);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetContainsString() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CONTAINSSTRING$18);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COUNT$36);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetLongText() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(LONGTEXT$38);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetMaxDate() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MAXDATE$34);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetMaxValue() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MAXVALUE$30);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetMinDate() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MINDATE$32);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetMinValue() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MINVALUE$28);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlBoolean xgetContainsBlank() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSBLANK$20;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlBoolean xgetContainsDate() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSDATE$16;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlBoolean xgetContainsInteger() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSINTEGER$26;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlBoolean xgetContainsMixedTypes() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSMIXEDTYPES$22;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlBoolean xgetContainsNonDate() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSNONDATE$14;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlBoolean xgetContainsNumber() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSNUMBER$24;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlBoolean xgetContainsSemiMixedTypes() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSSEMIMIXEDTYPES$12;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlBoolean xgetContainsString() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSSTRING$18;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlUnsignedInt xgetCount() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(COUNT$36);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlBoolean xgetLongText() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LONGTEXT$38;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlDateTime xgetMaxDate() {
        XmlDateTime xmlDateTimeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlDateTimeFind_attribute_user = get_store().find_attribute_user(MAXDATE$34);
        }
        return xmlDateTimeFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlDouble xgetMaxValue() {
        XmlDouble xmlDoubleFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlDoubleFind_attribute_user = get_store().find_attribute_user(MAXVALUE$30);
        }
        return xmlDoubleFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlDateTime xgetMinDate() {
        XmlDateTime xmlDateTimeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlDateTimeFind_attribute_user = get_store().find_attribute_user(MINDATE$32);
        }
        return xmlDateTimeFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlDouble xgetMinValue() {
        XmlDouble xmlDoubleFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlDoubleFind_attribute_user = get_store().find_attribute_user(MINVALUE$28);
        }
        return xmlDoubleFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetContainsBlank(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSBLANK$20;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetContainsDate(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSDATE$16;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetContainsInteger(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSINTEGER$26;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetContainsMixedTypes(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSMIXEDTYPES$22;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetContainsNonDate(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSNONDATE$14;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetContainsNumber(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSNUMBER$24;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetContainsSemiMixedTypes(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSSEMIMIXEDTYPES$12;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetContainsString(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONTAINSSTRING$18;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetCount(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COUNT$36;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetLongText(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LONGTEXT$38;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetMaxDate(XmlDateTime xmlDateTime) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAXDATE$34;
            XmlDateTime xmlDateTimeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlDateTimeFind_attribute_user == null) {
                xmlDateTimeFind_attribute_user = (XmlDateTime) get_store().add_attribute_user(qName);
            }
            xmlDateTimeFind_attribute_user.set(xmlDateTime);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetMaxValue(XmlDouble xmlDouble) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAXVALUE$30;
            XmlDouble xmlDoubleFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlDoubleFind_attribute_user == null) {
                xmlDoubleFind_attribute_user = (XmlDouble) get_store().add_attribute_user(qName);
            }
            xmlDoubleFind_attribute_user.set(xmlDouble);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetMinDate(XmlDateTime xmlDateTime) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINDATE$32;
            XmlDateTime xmlDateTimeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlDateTimeFind_attribute_user == null) {
                xmlDateTimeFind_attribute_user = (XmlDateTime) get_store().add_attribute_user(qName);
            }
            xmlDateTimeFind_attribute_user.set(xmlDateTime);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetMinValue(XmlDouble xmlDouble) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINVALUE$28;
            XmlDouble xmlDoubleFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlDoubleFind_attribute_user == null) {
                xmlDoubleFind_attribute_user = (XmlDouble) get_store().add_attribute_user(qName);
            }
            xmlDoubleFind_attribute_user.set(xmlDouble);
        }
    }
}
