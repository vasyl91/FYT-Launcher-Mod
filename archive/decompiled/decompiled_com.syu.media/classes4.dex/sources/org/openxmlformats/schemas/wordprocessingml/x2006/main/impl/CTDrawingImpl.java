package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTDrawingImpl extends XmlComplexContentImpl implements CTDrawing {
    private static final QName ANCHOR$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "anchor");
    private static final QName INLINE$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "inline");

    public CTDrawingImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public CTAnchor addNewAnchor() {
        CTAnchor cTAnchorAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAnchorAdd_element_user = get_store().add_element_user(ANCHOR$0);
        }
        return cTAnchorAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public CTInline addNewInline() {
        CTInline cTInlineAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTInlineAdd_element_user = get_store().add_element_user(INLINE$2);
        }
        return cTInlineAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public CTAnchor getAnchorArray(int i) {
        CTAnchor cTAnchorFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAnchorFind_element_user = get_store().find_element_user(ANCHOR$0, i);
            if (cTAnchorFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAnchorFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public CTAnchor[] getAnchorArray() {
        CTAnchor[] cTAnchorArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ANCHOR$0, arrayList);
            cTAnchorArr = new CTAnchor[arrayList.size()];
            arrayList.toArray(cTAnchorArr);
        }
        return cTAnchorArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public List<CTAnchor> getAnchorList() {
        1AnchorList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AnchorList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public CTInline getInlineArray(int i) {
        CTInline cTInlineFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTInlineFind_element_user = get_store().find_element_user(INLINE$2, i);
            if (cTInlineFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTInlineFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public CTInline[] getInlineArray() {
        CTInline[] cTInlineArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(INLINE$2, arrayList);
            cTInlineArr = new CTInline[arrayList.size()];
            arrayList.toArray(cTInlineArr);
        }
        return cTInlineArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public List<CTInline> getInlineList() {
        1InlineList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1InlineList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public CTAnchor insertNewAnchor(int i) {
        CTAnchor cTAnchorInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAnchorInsert_element_user = get_store().insert_element_user(ANCHOR$0, i);
        }
        return cTAnchorInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public CTInline insertNewInline(int i) {
        CTInline cTInlineInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTInlineInsert_element_user = get_store().insert_element_user(INLINE$2, i);
        }
        return cTInlineInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public void removeAnchor(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ANCHOR$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public void removeInline(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INLINE$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public void setAnchorArray(int i, CTAnchor cTAnchor) {
        synchronized (monitor()) {
            check_orphaned();
            CTAnchor cTAnchorFind_element_user = get_store().find_element_user(ANCHOR$0, i);
            if (cTAnchorFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTAnchorFind_element_user.set(cTAnchor);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public void setAnchorArray(CTAnchor[] cTAnchorArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTAnchorArr, ANCHOR$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public void setInlineArray(int i, CTInline cTInline) {
        synchronized (monitor()) {
            check_orphaned();
            CTInline cTInlineFind_element_user = get_store().find_element_user(INLINE$2, i);
            if (cTInlineFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTInlineFind_element_user.set(cTInline);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public void setInlineArray(CTInline[] cTInlineArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTInlineArr, INLINE$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public int sizeOfAnchorArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ANCHOR$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public int sizeOfInlineArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(INLINE$2);
        }
        return iCount_elements;
    }
}
