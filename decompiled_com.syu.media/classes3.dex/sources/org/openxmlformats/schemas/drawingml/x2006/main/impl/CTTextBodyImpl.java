package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTTextBodyImpl extends XmlComplexContentImpl implements CTTextBody {
    private static final QName BODYPR$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "bodyPr");
    private static final QName LSTSTYLE$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lstStyle");
    private static final QName P$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "p");

    public CTTextBodyImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody
    public CTTextBodyProperties addNewBodyPr() {
        CTTextBodyProperties cTTextBodyProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextBodyProperties = (CTTextBodyProperties) get_store().add_element_user(BODYPR$0);
        }
        return cTTextBodyProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody
    public CTTextListStyle addNewLstStyle() {
        CTTextListStyle cTTextListStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTextListStyle = (CTTextListStyle) get_store().add_element_user(LSTSTYLE$2);
        }
        return cTTextListStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody
    public CTTextParagraph addNewP() {
        CTTextParagraph cTTextParagraph;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraph = (CTTextParagraph) get_store().add_element_user(P$4);
        }
        return cTTextParagraph;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody
    public CTTextBodyProperties getBodyPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextBodyProperties cTTextBodyProperties = (CTTextBodyProperties) get_store().find_element_user(BODYPR$0, 0);
            if (cTTextBodyProperties == null) {
                return null;
            }
            return cTTextBodyProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody
    public CTTextListStyle getLstStyle() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextListStyle cTTextListStyle = (CTTextListStyle) get_store().find_element_user(LSTSTYLE$2, 0);
            if (cTTextListStyle == null) {
                return null;
            }
            return cTTextListStyle;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody
    public CTTextParagraph getPArray(int i) {
        CTTextParagraph cTTextParagraph;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraph = (CTTextParagraph) get_store().find_element_user(P$4, i);
            if (cTTextParagraph == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTextParagraph;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody
    public CTTextParagraph[] getPArray() {
        CTTextParagraph[] cTTextParagraphArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(P$4, arrayList);
            cTTextParagraphArr = new CTTextParagraph[arrayList.size()];
            arrayList.toArray(cTTextParagraphArr);
        }
        return cTTextParagraphArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody
    public List<CTTextParagraph> getPList() {
        1PList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody
    public CTTextParagraph insertNewP(int i) {
        CTTextParagraph cTTextParagraph;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraph = (CTTextParagraph) get_store().insert_element_user(P$4, i);
        }
        return cTTextParagraph;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody
    public boolean isSetLstStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LSTSTYLE$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody
    public void removeP(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(P$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody
    public void setBodyPr(CTTextBodyProperties cTTextBodyProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BODYPR$0;
            CTTextBodyProperties cTTextBodyProperties2 = (CTTextBodyProperties) typeStore.find_element_user(qName, 0);
            if (cTTextBodyProperties2 == null) {
                cTTextBodyProperties2 = (CTTextBodyProperties) get_store().add_element_user(qName);
            }
            cTTextBodyProperties2.set(cTTextBodyProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody
    public void setLstStyle(CTTextListStyle cTTextListStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LSTSTYLE$2;
            CTTextListStyle cTTextListStyle2 = (CTTextListStyle) typeStore.find_element_user(qName, 0);
            if (cTTextListStyle2 == null) {
                cTTextListStyle2 = (CTTextListStyle) get_store().add_element_user(qName);
            }
            cTTextListStyle2.set(cTTextListStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody
    public void setPArray(int i, CTTextParagraph cTTextParagraph) {
        synchronized (monitor()) {
            check_orphaned();
            CTTextParagraph cTTextParagraph2 = (CTTextParagraph) get_store().find_element_user(P$4, i);
            if (cTTextParagraph2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTextParagraph2.set(cTTextParagraph);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody
    public void setPArray(CTTextParagraph[] cTTextParagraphArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTextParagraphArr, P$4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody
    public int sizeOfPArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(P$4);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody
    public void unsetLstStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LSTSTYLE$2, 0);
        }
    }
}
