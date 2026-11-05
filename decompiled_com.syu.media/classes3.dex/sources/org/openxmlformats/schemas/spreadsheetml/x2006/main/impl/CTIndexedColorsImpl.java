package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIndexedColors;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRgbColor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTIndexedColorsImpl extends XmlComplexContentImpl implements CTIndexedColors {
    private static final QName RGBCOLOR$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "rgbColor");

    public CTIndexedColorsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIndexedColors
    public CTRgbColor addNewRgbColor() {
        CTRgbColor cTRgbColor;
        synchronized (monitor()) {
            check_orphaned();
            cTRgbColor = (CTRgbColor) get_store().add_element_user(RGBCOLOR$0);
        }
        return cTRgbColor;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIndexedColors
    public CTRgbColor getRgbColorArray(int i) {
        CTRgbColor cTRgbColor;
        synchronized (monitor()) {
            check_orphaned();
            cTRgbColor = (CTRgbColor) get_store().find_element_user(RGBCOLOR$0, i);
            if (cTRgbColor == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRgbColor;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIndexedColors
    public CTRgbColor[] getRgbColorArray() {
        CTRgbColor[] cTRgbColorArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(RGBCOLOR$0, arrayList);
            cTRgbColorArr = new CTRgbColor[arrayList.size()];
            arrayList.toArray(cTRgbColorArr);
        }
        return cTRgbColorArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIndexedColors
    public List<CTRgbColor> getRgbColorList() {
        AbstractList<CTRgbColor> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTRgbColor>() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTIndexedColorsImpl.1RgbColorList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTRgbColor cTRgbColor) {
                    CTIndexedColorsImpl.this.insertNewRgbColor(i).set(cTRgbColor);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRgbColor get(int i) {
                    return CTIndexedColorsImpl.this.getRgbColorArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRgbColor remove(int i) {
                    CTRgbColor rgbColorArray = CTIndexedColorsImpl.this.getRgbColorArray(i);
                    CTIndexedColorsImpl.this.removeRgbColor(i);
                    return rgbColorArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRgbColor set(int i, CTRgbColor cTRgbColor) {
                    CTRgbColor rgbColorArray = CTIndexedColorsImpl.this.getRgbColorArray(i);
                    CTIndexedColorsImpl.this.setRgbColorArray(i, cTRgbColor);
                    return rgbColorArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTIndexedColorsImpl.this.sizeOfRgbColorArray();
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIndexedColors
    public CTRgbColor insertNewRgbColor(int i) {
        CTRgbColor cTRgbColor;
        synchronized (monitor()) {
            check_orphaned();
            cTRgbColor = (CTRgbColor) get_store().insert_element_user(RGBCOLOR$0, i);
        }
        return cTRgbColor;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIndexedColors
    public void removeRgbColor(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RGBCOLOR$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIndexedColors
    public void setRgbColorArray(int i, CTRgbColor cTRgbColor) {
        synchronized (monitor()) {
            check_orphaned();
            CTRgbColor cTRgbColor2 = (CTRgbColor) get_store().find_element_user(RGBCOLOR$0, i);
            if (cTRgbColor2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRgbColor2.set(cTRgbColor);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIndexedColors
    public void setRgbColorArray(CTRgbColor[] cTRgbColorArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRgbColorArr, RGBCOLOR$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIndexedColors
    public int sizeOfRgbColorArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(RGBCOLOR$0);
        }
        return iCount_elements;
    }
}
