package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStop;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTGradientStopListImpl extends XmlComplexContentImpl implements CTGradientStopList {
    private static final QName GS$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "gs");

    public CTGradientStopListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList
    public CTGradientStop addNewGs() {
        CTGradientStop cTGradientStop;
        synchronized (monitor()) {
            check_orphaned();
            cTGradientStop = (CTGradientStop) get_store().add_element_user(GS$0);
        }
        return cTGradientStop;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList
    public CTGradientStop getGsArray(int i) {
        CTGradientStop cTGradientStop;
        synchronized (monitor()) {
            check_orphaned();
            cTGradientStop = (CTGradientStop) get_store().find_element_user(GS$0, i);
            if (cTGradientStop == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTGradientStop;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList
    public CTGradientStop[] getGsArray() {
        CTGradientStop[] cTGradientStopArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(GS$0, arrayList);
            cTGradientStopArr = new CTGradientStop[arrayList.size()];
            arrayList.toArray(cTGradientStopArr);
        }
        return cTGradientStopArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList
    public List<CTGradientStop> getGsList() {
        1GsList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1GsList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList
    public CTGradientStop insertNewGs(int i) {
        CTGradientStop cTGradientStop;
        synchronized (monitor()) {
            check_orphaned();
            cTGradientStop = (CTGradientStop) get_store().insert_element_user(GS$0, i);
        }
        return cTGradientStop;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList
    public void removeGs(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GS$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList
    public void setGsArray(int i, CTGradientStop cTGradientStop) {
        synchronized (monitor()) {
            check_orphaned();
            CTGradientStop cTGradientStop2 = (CTGradientStop) get_store().find_element_user(GS$0, i);
            if (cTGradientStop2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTGradientStop2.set(cTGradientStop);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList
    public void setGsArray(CTGradientStop[] cTGradientStopArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTGradientStopArr, GS$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList
    public int sizeOfGsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(GS$0);
        }
        return iCount_elements;
    }
}
