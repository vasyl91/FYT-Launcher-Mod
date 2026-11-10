package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTLineStyleListImpl extends XmlComplexContentImpl implements CTLineStyleList {
    private static final QName LN$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "ln");

    public CTLineStyleListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList
    public CTLineProperties addNewLn() {
        CTLineProperties cTLineProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTLineProperties = (CTLineProperties) get_store().add_element_user(LN$0);
        }
        return cTLineProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList
    public CTLineProperties getLnArray(int i) {
        CTLineProperties cTLineProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTLineProperties = (CTLineProperties) get_store().find_element_user(LN$0, i);
            if (cTLineProperties == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTLineProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList
    public CTLineProperties[] getLnArray() {
        CTLineProperties[] cTLinePropertiesArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LN$0, arrayList);
            cTLinePropertiesArr = new CTLineProperties[arrayList.size()];
            arrayList.toArray(cTLinePropertiesArr);
        }
        return cTLinePropertiesArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList
    public List<CTLineProperties> getLnList() {
        1LnList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1LnList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList
    public CTLineProperties insertNewLn(int i) {
        CTLineProperties cTLineProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTLineProperties = (CTLineProperties) get_store().insert_element_user(LN$0, i);
        }
        return cTLineProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList
    public void removeLn(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LN$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList
    public void setLnArray(int i, CTLineProperties cTLineProperties) {
        synchronized (monitor()) {
            check_orphaned();
            CTLineProperties cTLineProperties2 = (CTLineProperties) get_store().find_element_user(LN$0, i);
            if (cTLineProperties2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTLineProperties2.set(cTLineProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList
    public void setLnArray(CTLineProperties[] cTLinePropertiesArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTLinePropertiesArr, LN$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList
    public int sizeOfLnArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(LN$0);
        }
        return iCount_elements;
    }
}
