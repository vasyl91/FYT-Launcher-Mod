package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.ConnectType;
import com.microsoft.schemas.office.visio.x2012.main.ConnectsType;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class ConnectsTypeImpl extends XmlComplexContentImpl implements ConnectsType {
    private static final QName CONNECT$0 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "Connect");

    public ConnectsTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectsType
    public ConnectType addNewConnect() {
        ConnectType connectTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            connectTypeAdd_element_user = get_store().add_element_user(CONNECT$0);
        }
        return connectTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectsType
    public ConnectType getConnectArray(int i) {
        ConnectType connectTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            connectTypeFind_element_user = get_store().find_element_user(CONNECT$0, i);
            if (connectTypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return connectTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectsType
    public ConnectType[] getConnectArray() {
        ConnectType[] connectTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CONNECT$0, arrayList);
            connectTypeArr = new ConnectType[arrayList.size()];
            arrayList.toArray(connectTypeArr);
        }
        return connectTypeArr;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectsType
    public List<ConnectType> getConnectList() {
        1ConnectList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ConnectList(this);
        }
        return r1;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectsType
    public ConnectType insertNewConnect(int i) {
        ConnectType connectTypeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            connectTypeInsert_element_user = get_store().insert_element_user(CONNECT$0, i);
        }
        return connectTypeInsert_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectsType
    public void removeConnect(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CONNECT$0, i);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectsType
    public void setConnectArray(int i, ConnectType connectType) {
        synchronized (monitor()) {
            check_orphaned();
            ConnectType connectTypeFind_element_user = get_store().find_element_user(CONNECT$0, i);
            if (connectTypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            connectTypeFind_element_user.set(connectType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectsType
    public void setConnectArray(ConnectType[] connectTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(connectTypeArr, CONNECT$0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectsType
    public int sizeOfConnectArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CONNECT$0);
        }
        return iCount_elements;
    }
}
