package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerData;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTagsData;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTCustomerDataListImpl extends XmlComplexContentImpl implements CTCustomerDataList {
    private static final QName CUSTDATA$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "custData");
    private static final QName TAGS$2 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "tags");

    public CTCustomerDataListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList
    public CTCustomerData addNewCustData() {
        CTCustomerData cTCustomerDataAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomerDataAdd_element_user = get_store().add_element_user(CUSTDATA$0);
        }
        return cTCustomerDataAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList
    public CTTagsData addNewTags() {
        CTTagsData cTTagsData;
        synchronized (monitor()) {
            check_orphaned();
            cTTagsData = (CTTagsData) get_store().add_element_user(TAGS$2);
        }
        return cTTagsData;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList
    public CTCustomerData getCustDataArray(int i) {
        CTCustomerData cTCustomerDataFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomerDataFind_element_user = get_store().find_element_user(CUSTDATA$0, i);
            if (cTCustomerDataFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTCustomerDataFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList
    public CTCustomerData[] getCustDataArray() {
        CTCustomerData[] cTCustomerDataArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTDATA$0, arrayList);
            cTCustomerDataArr = new CTCustomerData[arrayList.size()];
            arrayList.toArray(cTCustomerDataArr);
        }
        return cTCustomerDataArr;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList
    public List<CTCustomerData> getCustDataList() {
        1CustDataList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CustDataList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList
    public CTTagsData getTags() {
        synchronized (monitor()) {
            check_orphaned();
            CTTagsData cTTagsData = (CTTagsData) get_store().find_element_user(TAGS$2, 0);
            if (cTTagsData == null) {
                return null;
            }
            return cTTagsData;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList
    public CTCustomerData insertNewCustData(int i) {
        CTCustomerData cTCustomerDataInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomerDataInsert_element_user = get_store().insert_element_user(CUSTDATA$0, i);
        }
        return cTCustomerDataInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList
    public boolean isSetTags() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TAGS$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList
    public void removeCustData(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTDATA$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList
    public void setCustDataArray(int i, CTCustomerData cTCustomerData) {
        synchronized (monitor()) {
            check_orphaned();
            CTCustomerData cTCustomerDataFind_element_user = get_store().find_element_user(CUSTDATA$0, i);
            if (cTCustomerDataFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTCustomerDataFind_element_user.set(cTCustomerData);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList
    public void setCustDataArray(CTCustomerData[] cTCustomerDataArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTCustomerDataArr, CUSTDATA$0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList
    public void setTags(CTTagsData cTTagsData) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TAGS$2;
            CTTagsData cTTagsData2 = (CTTagsData) typeStore.find_element_user(qName, 0);
            if (cTTagsData2 == null) {
                cTTagsData2 = (CTTagsData) get_store().add_element_user(qName);
            }
            cTTagsData2.set(cTTagsData);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList
    public int sizeOfCustDataArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTDATA$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList
    public void unsetTags() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TAGS$2, 0);
        }
    }
}
