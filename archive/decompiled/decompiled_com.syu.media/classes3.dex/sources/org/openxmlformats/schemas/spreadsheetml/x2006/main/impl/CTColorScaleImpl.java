package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfvo;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColorScale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTColorScaleImpl extends XmlComplexContentImpl implements CTColorScale {
    private static final QName CFVO$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "cfvo");
    private static final QName COLOR$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "color");

    public CTColorScaleImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColorScale
    public CTCfvo addNewCfvo() {
        CTCfvo cTCfvo;
        synchronized (monitor()) {
            check_orphaned();
            cTCfvo = (CTCfvo) get_store().add_element_user(CFVO$0);
        }
        return cTCfvo;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColorScale
    public CTColor addNewColor() {
        CTColor cTColor;
        synchronized (monitor()) {
            check_orphaned();
            cTColor = (CTColor) get_store().add_element_user(COLOR$2);
        }
        return cTColor;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColorScale
    public CTCfvo getCfvoArray(int i) {
        CTCfvo cTCfvo;
        synchronized (monitor()) {
            check_orphaned();
            cTCfvo = (CTCfvo) get_store().find_element_user(CFVO$0, i);
            if (cTCfvo == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTCfvo;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColorScale
    public CTCfvo[] getCfvoArray() {
        CTCfvo[] cTCfvoArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CFVO$0, arrayList);
            cTCfvoArr = new CTCfvo[arrayList.size()];
            arrayList.toArray(cTCfvoArr);
        }
        return cTCfvoArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColorScale
    public List<CTCfvo> getCfvoList() {
        1CfvoList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CfvoList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColorScale
    public CTColor getColorArray(int i) {
        CTColor cTColor;
        synchronized (monitor()) {
            check_orphaned();
            cTColor = (CTColor) get_store().find_element_user(COLOR$2, i);
            if (cTColor == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTColor;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColorScale
    public CTColor[] getColorArray() {
        CTColor[] cTColorArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COLOR$2, arrayList);
            cTColorArr = new CTColor[arrayList.size()];
            arrayList.toArray(cTColorArr);
        }
        return cTColorArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColorScale
    public List<CTColor> getColorList() {
        1ColorList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ColorList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColorScale
    public CTCfvo insertNewCfvo(int i) {
        CTCfvo cTCfvo;
        synchronized (monitor()) {
            check_orphaned();
            cTCfvo = (CTCfvo) get_store().insert_element_user(CFVO$0, i);
        }
        return cTCfvo;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColorScale
    public CTColor insertNewColor(int i) {
        CTColor cTColor;
        synchronized (monitor()) {
            check_orphaned();
            cTColor = (CTColor) get_store().insert_element_user(COLOR$2, i);
        }
        return cTColor;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColorScale
    public void removeCfvo(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CFVO$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColorScale
    public void removeColor(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COLOR$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColorScale
    public void setCfvoArray(int i, CTCfvo cTCfvo) {
        synchronized (monitor()) {
            check_orphaned();
            CTCfvo cTCfvo2 = (CTCfvo) get_store().find_element_user(CFVO$0, i);
            if (cTCfvo2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTCfvo2.set(cTCfvo);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColorScale
    public void setCfvoArray(CTCfvo[] cTCfvoArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTCfvoArr, CFVO$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColorScale
    public void setColorArray(int i, CTColor cTColor) {
        synchronized (monitor()) {
            check_orphaned();
            CTColor cTColor2 = (CTColor) get_store().find_element_user(COLOR$2, i);
            if (cTColor2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTColor2.set(cTColor);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColorScale
    public void setColorArray(CTColor[] cTColorArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTColorArr, COLOR$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColorScale
    public int sizeOfCfvoArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CFVO$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColorScale
    public int sizeOfColorArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(COLOR$2);
        }
        return iCount_elements;
    }
}
