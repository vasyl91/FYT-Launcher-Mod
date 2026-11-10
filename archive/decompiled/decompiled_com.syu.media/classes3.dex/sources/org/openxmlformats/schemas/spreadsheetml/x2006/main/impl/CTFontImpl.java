package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBooleanProperty;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontName;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontScheme;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontSize;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIntProperty;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTUnderlineProperty;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTVerticalAlignFontProperty;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTFontImpl extends XmlComplexContentImpl implements CTFont {
    private static final QName NAME$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "name");
    private static final QName CHARSET$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "charset");
    private static final QName FAMILY$4 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "family");
    private static final QName B$6 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "b");
    private static final QName I$8 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "i");
    private static final QName STRIKE$10 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "strike");
    private static final QName OUTLINE$12 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "outline");
    private static final QName SHADOW$14 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "shadow");
    private static final QName CONDENSE$16 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "condense");
    private static final QName EXTEND$18 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extend");
    private static final QName COLOR$20 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "color");
    private static final QName SZ$22 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sz");
    private static final QName U$24 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "u");
    private static final QName VERTALIGN$26 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "vertAlign");
    private static final QName SCHEME$28 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "scheme");

    public CTFontImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTBooleanProperty addNewB() {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().add_element_user(B$6);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTIntProperty addNewCharset() {
        CTIntProperty cTIntProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTIntProperty = (CTIntProperty) get_store().add_element_user(CHARSET$2);
        }
        return cTIntProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTColor addNewColor() {
        CTColor cTColor;
        synchronized (monitor()) {
            check_orphaned();
            cTColor = (CTColor) get_store().add_element_user(COLOR$20);
        }
        return cTColor;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTBooleanProperty addNewCondense() {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().add_element_user(CONDENSE$16);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTBooleanProperty addNewExtend() {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().add_element_user(EXTEND$18);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTIntProperty addNewFamily() {
        CTIntProperty cTIntProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTIntProperty = (CTIntProperty) get_store().add_element_user(FAMILY$4);
        }
        return cTIntProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTBooleanProperty addNewI() {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().add_element_user(I$8);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTFontName addNewName() {
        CTFontName cTFontName;
        synchronized (monitor()) {
            check_orphaned();
            cTFontName = (CTFontName) get_store().add_element_user(NAME$0);
        }
        return cTFontName;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTBooleanProperty addNewOutline() {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().add_element_user(OUTLINE$12);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTFontScheme addNewScheme() {
        CTFontScheme cTFontScheme;
        synchronized (monitor()) {
            check_orphaned();
            cTFontScheme = (CTFontScheme) get_store().add_element_user(SCHEME$28);
        }
        return cTFontScheme;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTBooleanProperty addNewShadow() {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().add_element_user(SHADOW$14);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTBooleanProperty addNewStrike() {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().add_element_user(STRIKE$10);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTFontSize addNewSz() {
        CTFontSize cTFontSize;
        synchronized (monitor()) {
            check_orphaned();
            cTFontSize = (CTFontSize) get_store().add_element_user(SZ$22);
        }
        return cTFontSize;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTUnderlineProperty addNewU() {
        CTUnderlineProperty cTUnderlineProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTUnderlineProperty = (CTUnderlineProperty) get_store().add_element_user(U$24);
        }
        return cTUnderlineProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTVerticalAlignFontProperty addNewVertAlign() {
        CTVerticalAlignFontProperty cTVerticalAlignFontProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTVerticalAlignFontProperty = (CTVerticalAlignFontProperty) get_store().add_element_user(VERTALIGN$26);
        }
        return cTVerticalAlignFontProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTBooleanProperty getBArray(int i) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().find_element_user(B$6, i);
            if (cTBooleanProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTBooleanProperty[] getBArray() {
        CTBooleanProperty[] cTBooleanPropertyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(B$6, arrayList);
            cTBooleanPropertyArr = new CTBooleanProperty[arrayList.size()];
            arrayList.toArray(cTBooleanPropertyArr);
        }
        return cTBooleanPropertyArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public List<CTBooleanProperty> getBList() {
        1BList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1BList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTIntProperty getCharsetArray(int i) {
        CTIntProperty cTIntProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTIntProperty = (CTIntProperty) get_store().find_element_user(CHARSET$2, i);
            if (cTIntProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTIntProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTIntProperty[] getCharsetArray() {
        CTIntProperty[] cTIntPropertyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CHARSET$2, arrayList);
            cTIntPropertyArr = new CTIntProperty[arrayList.size()];
            arrayList.toArray(cTIntPropertyArr);
        }
        return cTIntPropertyArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public List<CTIntProperty> getCharsetList() {
        1CharsetList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CharsetList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTColor getColorArray(int i) {
        CTColor cTColor;
        synchronized (monitor()) {
            check_orphaned();
            cTColor = (CTColor) get_store().find_element_user(COLOR$20, i);
            if (cTColor == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTColor;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTColor[] getColorArray() {
        CTColor[] cTColorArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COLOR$20, arrayList);
            cTColorArr = new CTColor[arrayList.size()];
            arrayList.toArray(cTColorArr);
        }
        return cTColorArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public List<CTColor> getColorList() {
        1ColorList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ColorList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTBooleanProperty getCondenseArray(int i) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().find_element_user(CONDENSE$16, i);
            if (cTBooleanProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTBooleanProperty[] getCondenseArray() {
        CTBooleanProperty[] cTBooleanPropertyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CONDENSE$16, arrayList);
            cTBooleanPropertyArr = new CTBooleanProperty[arrayList.size()];
            arrayList.toArray(cTBooleanPropertyArr);
        }
        return cTBooleanPropertyArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public List<CTBooleanProperty> getCondenseList() {
        1CondenseList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CondenseList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTBooleanProperty getExtendArray(int i) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().find_element_user(EXTEND$18, i);
            if (cTBooleanProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTBooleanProperty[] getExtendArray() {
        CTBooleanProperty[] cTBooleanPropertyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(EXTEND$18, arrayList);
            cTBooleanPropertyArr = new CTBooleanProperty[arrayList.size()];
            arrayList.toArray(cTBooleanPropertyArr);
        }
        return cTBooleanPropertyArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public List<CTBooleanProperty> getExtendList() {
        1ExtendList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ExtendList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTIntProperty getFamilyArray(int i) {
        CTIntProperty cTIntProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTIntProperty = (CTIntProperty) get_store().find_element_user(FAMILY$4, i);
            if (cTIntProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTIntProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTIntProperty[] getFamilyArray() {
        CTIntProperty[] cTIntPropertyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FAMILY$4, arrayList);
            cTIntPropertyArr = new CTIntProperty[arrayList.size()];
            arrayList.toArray(cTIntPropertyArr);
        }
        return cTIntPropertyArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public List<CTIntProperty> getFamilyList() {
        1FamilyList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FamilyList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTBooleanProperty getIArray(int i) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().find_element_user(I$8, i);
            if (cTBooleanProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTBooleanProperty[] getIArray() {
        CTBooleanProperty[] cTBooleanPropertyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(I$8, arrayList);
            cTBooleanPropertyArr = new CTBooleanProperty[arrayList.size()];
            arrayList.toArray(cTBooleanPropertyArr);
        }
        return cTBooleanPropertyArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public List<CTBooleanProperty> getIList() {
        1IList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1IList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTFontName getNameArray(int i) {
        CTFontName cTFontName;
        synchronized (monitor()) {
            check_orphaned();
            cTFontName = (CTFontName) get_store().find_element_user(NAME$0, i);
            if (cTFontName == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFontName;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTFontName[] getNameArray() {
        CTFontName[] cTFontNameArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(NAME$0, arrayList);
            cTFontNameArr = new CTFontName[arrayList.size()];
            arrayList.toArray(cTFontNameArr);
        }
        return cTFontNameArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public List<CTFontName> getNameList() {
        1NameList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1NameList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTBooleanProperty getOutlineArray(int i) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().find_element_user(OUTLINE$12, i);
            if (cTBooleanProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTBooleanProperty[] getOutlineArray() {
        CTBooleanProperty[] cTBooleanPropertyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(OUTLINE$12, arrayList);
            cTBooleanPropertyArr = new CTBooleanProperty[arrayList.size()];
            arrayList.toArray(cTBooleanPropertyArr);
        }
        return cTBooleanPropertyArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public List<CTBooleanProperty> getOutlineList() {
        1OutlineList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1OutlineList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTFontScheme getSchemeArray(int i) {
        CTFontScheme cTFontScheme;
        synchronized (monitor()) {
            check_orphaned();
            cTFontScheme = (CTFontScheme) get_store().find_element_user(SCHEME$28, i);
            if (cTFontScheme == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFontScheme;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTFontScheme[] getSchemeArray() {
        CTFontScheme[] cTFontSchemeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SCHEME$28, arrayList);
            cTFontSchemeArr = new CTFontScheme[arrayList.size()];
            arrayList.toArray(cTFontSchemeArr);
        }
        return cTFontSchemeArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public List<CTFontScheme> getSchemeList() {
        1SchemeList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SchemeList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTBooleanProperty getShadowArray(int i) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().find_element_user(SHADOW$14, i);
            if (cTBooleanProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTBooleanProperty[] getShadowArray() {
        CTBooleanProperty[] cTBooleanPropertyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SHADOW$14, arrayList);
            cTBooleanPropertyArr = new CTBooleanProperty[arrayList.size()];
            arrayList.toArray(cTBooleanPropertyArr);
        }
        return cTBooleanPropertyArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public List<CTBooleanProperty> getShadowList() {
        1ShadowList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ShadowList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTBooleanProperty getStrikeArray(int i) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().find_element_user(STRIKE$10, i);
            if (cTBooleanProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTBooleanProperty[] getStrikeArray() {
        CTBooleanProperty[] cTBooleanPropertyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(STRIKE$10, arrayList);
            cTBooleanPropertyArr = new CTBooleanProperty[arrayList.size()];
            arrayList.toArray(cTBooleanPropertyArr);
        }
        return cTBooleanPropertyArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public List<CTBooleanProperty> getStrikeList() {
        1StrikeList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1StrikeList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTFontSize getSzArray(int i) {
        CTFontSize cTFontSize;
        synchronized (monitor()) {
            check_orphaned();
            cTFontSize = (CTFontSize) get_store().find_element_user(SZ$22, i);
            if (cTFontSize == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFontSize;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTFontSize[] getSzArray() {
        CTFontSize[] cTFontSizeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SZ$22, arrayList);
            cTFontSizeArr = new CTFontSize[arrayList.size()];
            arrayList.toArray(cTFontSizeArr);
        }
        return cTFontSizeArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public List<CTFontSize> getSzList() {
        1SzList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SzList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTUnderlineProperty getUArray(int i) {
        CTUnderlineProperty cTUnderlineProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTUnderlineProperty = (CTUnderlineProperty) get_store().find_element_user(U$24, i);
            if (cTUnderlineProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTUnderlineProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTUnderlineProperty[] getUArray() {
        CTUnderlineProperty[] cTUnderlinePropertyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(U$24, arrayList);
            cTUnderlinePropertyArr = new CTUnderlineProperty[arrayList.size()];
            arrayList.toArray(cTUnderlinePropertyArr);
        }
        return cTUnderlinePropertyArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public List<CTUnderlineProperty> getUList() {
        1UList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1UList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTVerticalAlignFontProperty getVertAlignArray(int i) {
        CTVerticalAlignFontProperty cTVerticalAlignFontProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTVerticalAlignFontProperty = (CTVerticalAlignFontProperty) get_store().find_element_user(VERTALIGN$26, i);
            if (cTVerticalAlignFontProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTVerticalAlignFontProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTVerticalAlignFontProperty[] getVertAlignArray() {
        CTVerticalAlignFontProperty[] cTVerticalAlignFontPropertyArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(VERTALIGN$26, arrayList);
            cTVerticalAlignFontPropertyArr = new CTVerticalAlignFontProperty[arrayList.size()];
            arrayList.toArray(cTVerticalAlignFontPropertyArr);
        }
        return cTVerticalAlignFontPropertyArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public List<CTVerticalAlignFontProperty> getVertAlignList() {
        1VertAlignList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1VertAlignList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTBooleanProperty insertNewB(int i) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().insert_element_user(B$6, i);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTIntProperty insertNewCharset(int i) {
        CTIntProperty cTIntProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTIntProperty = (CTIntProperty) get_store().insert_element_user(CHARSET$2, i);
        }
        return cTIntProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTColor insertNewColor(int i) {
        CTColor cTColor;
        synchronized (monitor()) {
            check_orphaned();
            cTColor = (CTColor) get_store().insert_element_user(COLOR$20, i);
        }
        return cTColor;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTBooleanProperty insertNewCondense(int i) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().insert_element_user(CONDENSE$16, i);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTBooleanProperty insertNewExtend(int i) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().insert_element_user(EXTEND$18, i);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTIntProperty insertNewFamily(int i) {
        CTIntProperty cTIntProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTIntProperty = (CTIntProperty) get_store().insert_element_user(FAMILY$4, i);
        }
        return cTIntProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTBooleanProperty insertNewI(int i) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().insert_element_user(I$8, i);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTFontName insertNewName(int i) {
        CTFontName cTFontName;
        synchronized (monitor()) {
            check_orphaned();
            cTFontName = (CTFontName) get_store().insert_element_user(NAME$0, i);
        }
        return cTFontName;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTBooleanProperty insertNewOutline(int i) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().insert_element_user(OUTLINE$12, i);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTFontScheme insertNewScheme(int i) {
        CTFontScheme cTFontScheme;
        synchronized (monitor()) {
            check_orphaned();
            cTFontScheme = (CTFontScheme) get_store().insert_element_user(SCHEME$28, i);
        }
        return cTFontScheme;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTBooleanProperty insertNewShadow(int i) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().insert_element_user(SHADOW$14, i);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTBooleanProperty insertNewStrike(int i) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().insert_element_user(STRIKE$10, i);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTFontSize insertNewSz(int i) {
        CTFontSize cTFontSize;
        synchronized (monitor()) {
            check_orphaned();
            cTFontSize = (CTFontSize) get_store().insert_element_user(SZ$22, i);
        }
        return cTFontSize;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTUnderlineProperty insertNewU(int i) {
        CTUnderlineProperty cTUnderlineProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTUnderlineProperty = (CTUnderlineProperty) get_store().insert_element_user(U$24, i);
        }
        return cTUnderlineProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public CTVerticalAlignFontProperty insertNewVertAlign(int i) {
        CTVerticalAlignFontProperty cTVerticalAlignFontProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTVerticalAlignFontProperty = (CTVerticalAlignFontProperty) get_store().insert_element_user(VERTALIGN$26, i);
        }
        return cTVerticalAlignFontProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void removeB(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(B$6, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void removeCharset(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CHARSET$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void removeColor(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COLOR$20, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void removeCondense(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CONDENSE$16, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void removeExtend(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTEND$18, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void removeFamily(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FAMILY$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void removeI(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(I$8, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void removeName(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NAME$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void removeOutline(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OUTLINE$12, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void removeScheme(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SCHEME$28, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void removeShadow(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHADOW$14, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void removeStrike(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STRIKE$10, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void removeSz(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SZ$22, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void removeU(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(U$24, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void removeVertAlign(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VERTALIGN$26, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void setBArray(int i, CTBooleanProperty cTBooleanProperty) {
        synchronized (monitor()) {
            check_orphaned();
            CTBooleanProperty cTBooleanProperty2 = (CTBooleanProperty) get_store().find_element_user(B$6, i);
            if (cTBooleanProperty2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTBooleanProperty2.set(cTBooleanProperty);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void setBArray(CTBooleanProperty[] cTBooleanPropertyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBooleanPropertyArr, B$6);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void setCharsetArray(int i, CTIntProperty cTIntProperty) {
        synchronized (monitor()) {
            check_orphaned();
            CTIntProperty cTIntProperty2 = (CTIntProperty) get_store().find_element_user(CHARSET$2, i);
            if (cTIntProperty2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTIntProperty2.set(cTIntProperty);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void setCharsetArray(CTIntProperty[] cTIntPropertyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTIntPropertyArr, CHARSET$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void setColorArray(int i, CTColor cTColor) {
        synchronized (monitor()) {
            check_orphaned();
            CTColor cTColor2 = (CTColor) get_store().find_element_user(COLOR$20, i);
            if (cTColor2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTColor2.set(cTColor);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void setColorArray(CTColor[] cTColorArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTColorArr, COLOR$20);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void setCondenseArray(int i, CTBooleanProperty cTBooleanProperty) {
        synchronized (monitor()) {
            check_orphaned();
            CTBooleanProperty cTBooleanProperty2 = (CTBooleanProperty) get_store().find_element_user(CONDENSE$16, i);
            if (cTBooleanProperty2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTBooleanProperty2.set(cTBooleanProperty);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void setCondenseArray(CTBooleanProperty[] cTBooleanPropertyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBooleanPropertyArr, CONDENSE$16);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void setExtendArray(int i, CTBooleanProperty cTBooleanProperty) {
        synchronized (monitor()) {
            check_orphaned();
            CTBooleanProperty cTBooleanProperty2 = (CTBooleanProperty) get_store().find_element_user(EXTEND$18, i);
            if (cTBooleanProperty2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTBooleanProperty2.set(cTBooleanProperty);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void setExtendArray(CTBooleanProperty[] cTBooleanPropertyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBooleanPropertyArr, EXTEND$18);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void setFamilyArray(int i, CTIntProperty cTIntProperty) {
        synchronized (monitor()) {
            check_orphaned();
            CTIntProperty cTIntProperty2 = (CTIntProperty) get_store().find_element_user(FAMILY$4, i);
            if (cTIntProperty2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTIntProperty2.set(cTIntProperty);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void setFamilyArray(CTIntProperty[] cTIntPropertyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTIntPropertyArr, FAMILY$4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void setIArray(int i, CTBooleanProperty cTBooleanProperty) {
        synchronized (monitor()) {
            check_orphaned();
            CTBooleanProperty cTBooleanProperty2 = (CTBooleanProperty) get_store().find_element_user(I$8, i);
            if (cTBooleanProperty2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTBooleanProperty2.set(cTBooleanProperty);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void setIArray(CTBooleanProperty[] cTBooleanPropertyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBooleanPropertyArr, I$8);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void setNameArray(int i, CTFontName cTFontName) {
        synchronized (monitor()) {
            check_orphaned();
            CTFontName cTFontName2 = (CTFontName) get_store().find_element_user(NAME$0, i);
            if (cTFontName2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTFontName2.set(cTFontName);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void setNameArray(CTFontName[] cTFontNameArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTFontNameArr, NAME$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void setOutlineArray(int i, CTBooleanProperty cTBooleanProperty) {
        synchronized (monitor()) {
            check_orphaned();
            CTBooleanProperty cTBooleanProperty2 = (CTBooleanProperty) get_store().find_element_user(OUTLINE$12, i);
            if (cTBooleanProperty2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTBooleanProperty2.set(cTBooleanProperty);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void setOutlineArray(CTBooleanProperty[] cTBooleanPropertyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBooleanPropertyArr, OUTLINE$12);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void setSchemeArray(int i, CTFontScheme cTFontScheme) {
        synchronized (monitor()) {
            check_orphaned();
            CTFontScheme cTFontScheme2 = (CTFontScheme) get_store().find_element_user(SCHEME$28, i);
            if (cTFontScheme2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTFontScheme2.set(cTFontScheme);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void setSchemeArray(CTFontScheme[] cTFontSchemeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTFontSchemeArr, SCHEME$28);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void setShadowArray(int i, CTBooleanProperty cTBooleanProperty) {
        synchronized (monitor()) {
            check_orphaned();
            CTBooleanProperty cTBooleanProperty2 = (CTBooleanProperty) get_store().find_element_user(SHADOW$14, i);
            if (cTBooleanProperty2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTBooleanProperty2.set(cTBooleanProperty);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void setShadowArray(CTBooleanProperty[] cTBooleanPropertyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBooleanPropertyArr, SHADOW$14);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void setStrikeArray(int i, CTBooleanProperty cTBooleanProperty) {
        synchronized (monitor()) {
            check_orphaned();
            CTBooleanProperty cTBooleanProperty2 = (CTBooleanProperty) get_store().find_element_user(STRIKE$10, i);
            if (cTBooleanProperty2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTBooleanProperty2.set(cTBooleanProperty);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void setStrikeArray(CTBooleanProperty[] cTBooleanPropertyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBooleanPropertyArr, STRIKE$10);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void setSzArray(int i, CTFontSize cTFontSize) {
        synchronized (monitor()) {
            check_orphaned();
            CTFontSize cTFontSize2 = (CTFontSize) get_store().find_element_user(SZ$22, i);
            if (cTFontSize2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTFontSize2.set(cTFontSize);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void setSzArray(CTFontSize[] cTFontSizeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTFontSizeArr, SZ$22);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void setUArray(int i, CTUnderlineProperty cTUnderlineProperty) {
        synchronized (monitor()) {
            check_orphaned();
            CTUnderlineProperty cTUnderlineProperty2 = (CTUnderlineProperty) get_store().find_element_user(U$24, i);
            if (cTUnderlineProperty2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTUnderlineProperty2.set(cTUnderlineProperty);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void setUArray(CTUnderlineProperty[] cTUnderlinePropertyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTUnderlinePropertyArr, U$24);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void setVertAlignArray(int i, CTVerticalAlignFontProperty cTVerticalAlignFontProperty) {
        synchronized (monitor()) {
            check_orphaned();
            CTVerticalAlignFontProperty cTVerticalAlignFontProperty2 = (CTVerticalAlignFontProperty) get_store().find_element_user(VERTALIGN$26, i);
            if (cTVerticalAlignFontProperty2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTVerticalAlignFontProperty2.set(cTVerticalAlignFontProperty);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public void setVertAlignArray(CTVerticalAlignFontProperty[] cTVerticalAlignFontPropertyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTVerticalAlignFontPropertyArr, VERTALIGN$26);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public int sizeOfBArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(B$6);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public int sizeOfCharsetArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CHARSET$2);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public int sizeOfColorArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(COLOR$20);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public int sizeOfCondenseArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CONDENSE$16);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public int sizeOfExtendArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(EXTEND$18);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public int sizeOfFamilyArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(FAMILY$4);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public int sizeOfIArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(I$8);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public int sizeOfNameArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(NAME$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public int sizeOfOutlineArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(OUTLINE$12);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public int sizeOfSchemeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SCHEME$28);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public int sizeOfShadowArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SHADOW$14);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public int sizeOfStrikeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(STRIKE$10);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public int sizeOfSzArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SZ$22);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public int sizeOfUArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(U$24);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont
    public int sizeOfVertAlignArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(VERTALIGN$26);
        }
        return iCount_elements;
    }
}
