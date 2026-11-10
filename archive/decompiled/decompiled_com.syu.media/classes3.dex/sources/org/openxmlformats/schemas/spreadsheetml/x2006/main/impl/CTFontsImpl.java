package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTFontsImpl extends XmlComplexContentImpl implements CTFonts {
    private static final QName FONT$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "font");
    private static final QName COUNT$2 = new QName("", "count");

    public CTFontsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts
    public CTFont addNewFont() {
        CTFont cTFont;
        synchronized (monitor()) {
            check_orphaned();
            cTFont = (CTFont) get_store().add_element_user(FONT$0);
        }
        return cTFont;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts
    public long getCount() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(COUNT$2);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts
    public CTFont getFontArray(int i) {
        CTFont cTFont;
        synchronized (monitor()) {
            check_orphaned();
            cTFont = (CTFont) get_store().find_element_user(FONT$0, i);
            if (cTFont == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFont;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts
    public CTFont[] getFontArray() {
        CTFont[] cTFontArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FONT$0, arrayList);
            cTFontArr = new CTFont[arrayList.size()];
            arrayList.toArray(cTFontArr);
        }
        return cTFontArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts
    public List<CTFont> getFontList() {
        1FontList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FontList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts
    public CTFont insertNewFont(int i) {
        CTFont cTFont;
        synchronized (monitor()) {
            check_orphaned();
            cTFont = (CTFont) get_store().insert_element_user(FONT$0, i);
        }
        return cTFont;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts
    public boolean isSetCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COUNT$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts
    public void removeFont(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FONT$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts
    public void setCount(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COUNT$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts
    public void setFontArray(int i, CTFont cTFont) {
        synchronized (monitor()) {
            check_orphaned();
            CTFont cTFont2 = (CTFont) get_store().find_element_user(FONT$0, i);
            if (cTFont2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTFont2.set(cTFont);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts
    public void setFontArray(CTFont[] cTFontArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTFontArr, FONT$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts
    public int sizeOfFontArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(FONT$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts
    public void unsetCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COUNT$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts
    public XmlUnsignedInt xgetCount() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedIntFind_attribute_user = get_store().find_attribute_user(COUNT$2);
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts
    public void xsetCount(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COUNT$2;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }
}
