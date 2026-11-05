package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableBackgroundStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.STGuid;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTTableStyleImpl extends XmlComplexContentImpl implements CTTableStyle {
    private static final QName TBLBG$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tblBg");
    private static final QName WHOLETBL$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "wholeTbl");
    private static final QName BAND1H$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "band1H");
    private static final QName BAND2H$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "band2H");
    private static final QName BAND1V$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "band1V");
    private static final QName BAND2V$10 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "band2V");
    private static final QName LASTCOL$12 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lastCol");
    private static final QName FIRSTCOL$14 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "firstCol");
    private static final QName LASTROW$16 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lastRow");
    private static final QName SECELL$18 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "seCell");
    private static final QName SWCELL$20 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "swCell");
    private static final QName FIRSTROW$22 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "firstRow");
    private static final QName NECELL$24 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "neCell");
    private static final QName NWCELL$26 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "nwCell");
    private static final QName EXTLST$28 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
    private static final QName STYLEID$30 = new QName("", "styleId");
    private static final QName STYLENAME$32 = new QName("", "styleName");

    public CTTableStyleImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewBand1H() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(BAND1H$4);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewBand1V() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(BAND1V$8);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewBand2H() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(BAND2H$6);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewBand2V() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(BAND2V$10);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(EXTLST$28);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewFirstCol() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(FIRSTCOL$14);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewFirstRow() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(FIRSTROW$22);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewLastCol() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(LASTCOL$12);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewLastRow() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(LASTROW$16);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewNeCell() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(NECELL$24);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewNwCell() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(NWCELL$26);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewSeCell() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(SECELL$18);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewSwCell() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(SWCELL$20);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTableBackgroundStyle addNewTblBg() {
        CTTableBackgroundStyle cTTableBackgroundStyleAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTableBackgroundStyleAdd_element_user = get_store().add_element_user(TBLBG$0);
        }
        return cTTableBackgroundStyleAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle addNewWholeTbl() {
        CTTablePartStyle cTTablePartStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTablePartStyle = (CTTablePartStyle) get_store().add_element_user(WHOLETBL$2);
        }
        return cTTablePartStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getBand1H() {
        synchronized (monitor()) {
            check_orphaned();
            CTTablePartStyle cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(BAND1H$4, 0);
            if (cTTablePartStyle == null) {
                return null;
            }
            return cTTablePartStyle;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getBand1V() {
        synchronized (monitor()) {
            check_orphaned();
            CTTablePartStyle cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(BAND1V$8, 0);
            if (cTTablePartStyle == null) {
                return null;
            }
            return cTTablePartStyle;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getBand2H() {
        synchronized (monitor()) {
            check_orphaned();
            CTTablePartStyle cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(BAND2H$6, 0);
            if (cTTablePartStyle == null) {
                return null;
            }
            return cTTablePartStyle;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getBand2V() {
        synchronized (monitor()) {
            check_orphaned();
            CTTablePartStyle cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(BAND2V$10, 0);
            if (cTTablePartStyle == null) {
                return null;
            }
            return cTTablePartStyle;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTOfficeArtExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTOfficeArtExtensionList cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().find_element_user(EXTLST$28, 0);
            if (cTOfficeArtExtensionList == null) {
                return null;
            }
            return cTOfficeArtExtensionList;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getFirstCol() {
        synchronized (monitor()) {
            check_orphaned();
            CTTablePartStyle cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(FIRSTCOL$14, 0);
            if (cTTablePartStyle == null) {
                return null;
            }
            return cTTablePartStyle;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getFirstRow() {
        synchronized (monitor()) {
            check_orphaned();
            CTTablePartStyle cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(FIRSTROW$22, 0);
            if (cTTablePartStyle == null) {
                return null;
            }
            return cTTablePartStyle;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getLastCol() {
        synchronized (monitor()) {
            check_orphaned();
            CTTablePartStyle cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(LASTCOL$12, 0);
            if (cTTablePartStyle == null) {
                return null;
            }
            return cTTablePartStyle;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getLastRow() {
        synchronized (monitor()) {
            check_orphaned();
            CTTablePartStyle cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(LASTROW$16, 0);
            if (cTTablePartStyle == null) {
                return null;
            }
            return cTTablePartStyle;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getNeCell() {
        synchronized (monitor()) {
            check_orphaned();
            CTTablePartStyle cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(NECELL$24, 0);
            if (cTTablePartStyle == null) {
                return null;
            }
            return cTTablePartStyle;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getNwCell() {
        synchronized (monitor()) {
            check_orphaned();
            CTTablePartStyle cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(NWCELL$26, 0);
            if (cTTablePartStyle == null) {
                return null;
            }
            return cTTablePartStyle;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getSeCell() {
        synchronized (monitor()) {
            check_orphaned();
            CTTablePartStyle cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(SECELL$18, 0);
            if (cTTablePartStyle == null) {
                return null;
            }
            return cTTablePartStyle;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public String getStyleId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(STYLEID$30);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public String getStyleName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(STYLENAME$32);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getSwCell() {
        synchronized (monitor()) {
            check_orphaned();
            CTTablePartStyle cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(SWCELL$20, 0);
            if (cTTablePartStyle == null) {
                return null;
            }
            return cTTablePartStyle;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTableBackgroundStyle getTblBg() {
        synchronized (monitor()) {
            check_orphaned();
            CTTableBackgroundStyle cTTableBackgroundStyleFind_element_user = get_store().find_element_user(TBLBG$0, 0);
            if (cTTableBackgroundStyleFind_element_user == null) {
                return null;
            }
            return cTTableBackgroundStyleFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public CTTablePartStyle getWholeTbl() {
        synchronized (monitor()) {
            check_orphaned();
            CTTablePartStyle cTTablePartStyle = (CTTablePartStyle) get_store().find_element_user(WHOLETBL$2, 0);
            if (cTTablePartStyle == null) {
                return null;
            }
            return cTTablePartStyle;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetBand1H() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BAND1H$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetBand1V() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BAND1V$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetBand2H() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BAND2H$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetBand2V() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BAND2V$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$28) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetFirstCol() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FIRSTCOL$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetFirstRow() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FIRSTROW$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetLastCol() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LASTCOL$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetLastRow() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LASTROW$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetNeCell() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NECELL$24) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetNwCell() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NWCELL$26) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetSeCell() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SECELL$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetSwCell() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SWCELL$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetTblBg() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLBG$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public boolean isSetWholeTbl() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(WHOLETBL$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setBand1H(CTTablePartStyle cTTablePartStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BAND1H$4;
            CTTablePartStyle cTTablePartStyle2 = (CTTablePartStyle) typeStore.find_element_user(qName, 0);
            if (cTTablePartStyle2 == null) {
                cTTablePartStyle2 = (CTTablePartStyle) get_store().add_element_user(qName);
            }
            cTTablePartStyle2.set(cTTablePartStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setBand1V(CTTablePartStyle cTTablePartStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BAND1V$8;
            CTTablePartStyle cTTablePartStyle2 = (CTTablePartStyle) typeStore.find_element_user(qName, 0);
            if (cTTablePartStyle2 == null) {
                cTTablePartStyle2 = (CTTablePartStyle) get_store().add_element_user(qName);
            }
            cTTablePartStyle2.set(cTTablePartStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setBand2H(CTTablePartStyle cTTablePartStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BAND2H$6;
            CTTablePartStyle cTTablePartStyle2 = (CTTablePartStyle) typeStore.find_element_user(qName, 0);
            if (cTTablePartStyle2 == null) {
                cTTablePartStyle2 = (CTTablePartStyle) get_store().add_element_user(qName);
            }
            cTTablePartStyle2.set(cTTablePartStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setBand2V(CTTablePartStyle cTTablePartStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BAND2V$10;
            CTTablePartStyle cTTablePartStyle2 = (CTTablePartStyle) typeStore.find_element_user(qName, 0);
            if (cTTablePartStyle2 == null) {
                cTTablePartStyle2 = (CTTablePartStyle) get_store().add_element_user(qName);
            }
            cTTablePartStyle2.set(cTTablePartStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$28;
            CTOfficeArtExtensionList cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) typeStore.find_element_user(qName, 0);
            if (cTOfficeArtExtensionList2 == null) {
                cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) get_store().add_element_user(qName);
            }
            cTOfficeArtExtensionList2.set(cTOfficeArtExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setFirstCol(CTTablePartStyle cTTablePartStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIRSTCOL$14;
            CTTablePartStyle cTTablePartStyle2 = (CTTablePartStyle) typeStore.find_element_user(qName, 0);
            if (cTTablePartStyle2 == null) {
                cTTablePartStyle2 = (CTTablePartStyle) get_store().add_element_user(qName);
            }
            cTTablePartStyle2.set(cTTablePartStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setFirstRow(CTTablePartStyle cTTablePartStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIRSTROW$22;
            CTTablePartStyle cTTablePartStyle2 = (CTTablePartStyle) typeStore.find_element_user(qName, 0);
            if (cTTablePartStyle2 == null) {
                cTTablePartStyle2 = (CTTablePartStyle) get_store().add_element_user(qName);
            }
            cTTablePartStyle2.set(cTTablePartStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setLastCol(CTTablePartStyle cTTablePartStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LASTCOL$12;
            CTTablePartStyle cTTablePartStyle2 = (CTTablePartStyle) typeStore.find_element_user(qName, 0);
            if (cTTablePartStyle2 == null) {
                cTTablePartStyle2 = (CTTablePartStyle) get_store().add_element_user(qName);
            }
            cTTablePartStyle2.set(cTTablePartStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setLastRow(CTTablePartStyle cTTablePartStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LASTROW$16;
            CTTablePartStyle cTTablePartStyle2 = (CTTablePartStyle) typeStore.find_element_user(qName, 0);
            if (cTTablePartStyle2 == null) {
                cTTablePartStyle2 = (CTTablePartStyle) get_store().add_element_user(qName);
            }
            cTTablePartStyle2.set(cTTablePartStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setNeCell(CTTablePartStyle cTTablePartStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NECELL$24;
            CTTablePartStyle cTTablePartStyle2 = (CTTablePartStyle) typeStore.find_element_user(qName, 0);
            if (cTTablePartStyle2 == null) {
                cTTablePartStyle2 = (CTTablePartStyle) get_store().add_element_user(qName);
            }
            cTTablePartStyle2.set(cTTablePartStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setNwCell(CTTablePartStyle cTTablePartStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NWCELL$26;
            CTTablePartStyle cTTablePartStyle2 = (CTTablePartStyle) typeStore.find_element_user(qName, 0);
            if (cTTablePartStyle2 == null) {
                cTTablePartStyle2 = (CTTablePartStyle) get_store().add_element_user(qName);
            }
            cTTablePartStyle2.set(cTTablePartStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setSeCell(CTTablePartStyle cTTablePartStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SECELL$18;
            CTTablePartStyle cTTablePartStyle2 = (CTTablePartStyle) typeStore.find_element_user(qName, 0);
            if (cTTablePartStyle2 == null) {
                cTTablePartStyle2 = (CTTablePartStyle) get_store().add_element_user(qName);
            }
            cTTablePartStyle2.set(cTTablePartStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setStyleId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLEID$30;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setStyleName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLENAME$32;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setSwCell(CTTablePartStyle cTTablePartStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SWCELL$20;
            CTTablePartStyle cTTablePartStyle2 = (CTTablePartStyle) typeStore.find_element_user(qName, 0);
            if (cTTablePartStyle2 == null) {
                cTTablePartStyle2 = (CTTablePartStyle) get_store().add_element_user(qName);
            }
            cTTablePartStyle2.set(cTTablePartStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setTblBg(CTTableBackgroundStyle cTTableBackgroundStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLBG$0;
            CTTableBackgroundStyle cTTableBackgroundStyleFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTTableBackgroundStyleFind_element_user == null) {
                cTTableBackgroundStyleFind_element_user = (CTTableBackgroundStyle) get_store().add_element_user(qName);
            }
            cTTableBackgroundStyleFind_element_user.set(cTTableBackgroundStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void setWholeTbl(CTTablePartStyle cTTablePartStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WHOLETBL$2;
            CTTablePartStyle cTTablePartStyle2 = (CTTablePartStyle) typeStore.find_element_user(qName, 0);
            if (cTTablePartStyle2 == null) {
                cTTablePartStyle2 = (CTTablePartStyle) get_store().add_element_user(qName);
            }
            cTTablePartStyle2.set(cTTablePartStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetBand1H() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BAND1H$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetBand1V() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BAND1V$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetBand2H() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BAND2H$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetBand2V() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BAND2V$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$28, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetFirstCol() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FIRSTCOL$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetFirstRow() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FIRSTROW$22, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetLastCol() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LASTCOL$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetLastRow() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LASTROW$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetNeCell() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NECELL$24, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetNwCell() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NWCELL$26, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetSeCell() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SECELL$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetSwCell() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SWCELL$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetTblBg() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLBG$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void unsetWholeTbl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WHOLETBL$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public STGuid xgetStyleId() {
        STGuid sTGuid;
        synchronized (monitor()) {
            check_orphaned();
            sTGuid = (STGuid) get_store().find_attribute_user(STYLEID$30);
        }
        return sTGuid;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public XmlString xgetStyleName() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(STYLENAME$32);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void xsetStyleId(STGuid sTGuid) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLEID$30;
            STGuid sTGuid2 = (STGuid) typeStore.find_attribute_user(qName);
            if (sTGuid2 == null) {
                sTGuid2 = (STGuid) get_store().add_attribute_user(qName);
            }
            sTGuid2.set(sTGuid);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle
    public void xsetStyleName(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLENAME$32;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }
}
