package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTCell3D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNoFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPatternFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.STCoordinate32;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAnchoringType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextHorzOverflowType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextVerticalType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTTableCellPropertiesImpl extends XmlComplexContentImpl implements CTTableCellProperties {
    private static final QName LNL$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lnL");
    private static final QName LNR$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lnR");
    private static final QName LNT$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lnT");
    private static final QName LNB$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lnB");
    private static final QName LNTLTOBR$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lnTlToBr");
    private static final QName LNBLTOTR$10 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lnBlToTr");
    private static final QName CELL3D$12 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "cell3D");
    private static final QName NOFILL$14 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "noFill");
    private static final QName SOLIDFILL$16 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "solidFill");
    private static final QName GRADFILL$18 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "gradFill");
    private static final QName BLIPFILL$20 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "blipFill");
    private static final QName PATTFILL$22 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "pattFill");
    private static final QName GRPFILL$24 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "grpFill");
    private static final QName EXTLST$26 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
    private static final QName MARL$28 = new QName("", "marL");
    private static final QName MARR$30 = new QName("", "marR");
    private static final QName MART$32 = new QName("", "marT");
    private static final QName MARB$34 = new QName("", "marB");
    private static final QName VERT$36 = new QName("", "vert");
    private static final QName ANCHOR$38 = new QName("", "anchor");
    private static final QName ANCHORCTR$40 = new QName("", "anchorCtr");
    private static final QName HORZOVERFLOW$42 = new QName("", "horzOverflow");

    public CTTableCellPropertiesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public CTBlipFillProperties addNewBlipFill() {
        CTBlipFillProperties cTBlipFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTBlipFillProperties = (CTBlipFillProperties) get_store().add_element_user(BLIPFILL$20);
        }
        return cTBlipFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public CTCell3D addNewCell3D() {
        CTCell3D cTCell3DAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCell3DAdd_element_user = get_store().add_element_user(CELL3D$12);
        }
        return cTCell3DAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(EXTLST$26);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public CTGradientFillProperties addNewGradFill() {
        CTGradientFillProperties cTGradientFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTGradientFillProperties = (CTGradientFillProperties) get_store().add_element_user(GRADFILL$18);
        }
        return cTGradientFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public CTGroupFillProperties addNewGrpFill() {
        CTGroupFillProperties cTGroupFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupFillProperties = (CTGroupFillProperties) get_store().add_element_user(GRPFILL$24);
        }
        return cTGroupFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public CTLineProperties addNewLnB() {
        CTLineProperties cTLineProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTLineProperties = (CTLineProperties) get_store().add_element_user(LNB$6);
        }
        return cTLineProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public CTLineProperties addNewLnBlToTr() {
        CTLineProperties cTLineProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTLineProperties = (CTLineProperties) get_store().add_element_user(LNBLTOTR$10);
        }
        return cTLineProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public CTLineProperties addNewLnL() {
        CTLineProperties cTLineProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTLineProperties = (CTLineProperties) get_store().add_element_user(LNL$0);
        }
        return cTLineProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public CTLineProperties addNewLnR() {
        CTLineProperties cTLineProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTLineProperties = (CTLineProperties) get_store().add_element_user(LNR$2);
        }
        return cTLineProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public CTLineProperties addNewLnT() {
        CTLineProperties cTLineProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTLineProperties = (CTLineProperties) get_store().add_element_user(LNT$4);
        }
        return cTLineProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public CTLineProperties addNewLnTlToBr() {
        CTLineProperties cTLineProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTLineProperties = (CTLineProperties) get_store().add_element_user(LNTLTOBR$8);
        }
        return cTLineProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public CTNoFillProperties addNewNoFill() {
        CTNoFillProperties cTNoFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTNoFillProperties = (CTNoFillProperties) get_store().add_element_user(NOFILL$14);
        }
        return cTNoFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public CTPatternFillProperties addNewPattFill() {
        CTPatternFillProperties cTPatternFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTPatternFillProperties = (CTPatternFillProperties) get_store().add_element_user(PATTFILL$22);
        }
        return cTPatternFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public CTSolidColorFillProperties addNewSolidFill() {
        CTSolidColorFillProperties cTSolidColorFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTSolidColorFillProperties = (CTSolidColorFillProperties) get_store().add_element_user(SOLIDFILL$16);
        }
        return cTSolidColorFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public STTextAnchoringType.Enum getAnchor() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ANCHOR$38;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTextAnchoringType.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public boolean getAnchorCtr() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ANCHORCTR$40;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public CTBlipFillProperties getBlipFill() {
        synchronized (monitor()) {
            check_orphaned();
            CTBlipFillProperties cTBlipFillProperties = (CTBlipFillProperties) get_store().find_element_user(BLIPFILL$20, 0);
            if (cTBlipFillProperties == null) {
                return null;
            }
            return cTBlipFillProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public CTCell3D getCell3D() {
        synchronized (monitor()) {
            check_orphaned();
            CTCell3D cTCell3DFind_element_user = get_store().find_element_user(CELL3D$12, 0);
            if (cTCell3DFind_element_user == null) {
                return null;
            }
            return cTCell3DFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public CTOfficeArtExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTOfficeArtExtensionList cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().find_element_user(EXTLST$26, 0);
            if (cTOfficeArtExtensionList == null) {
                return null;
            }
            return cTOfficeArtExtensionList;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public CTGradientFillProperties getGradFill() {
        synchronized (monitor()) {
            check_orphaned();
            CTGradientFillProperties cTGradientFillProperties = (CTGradientFillProperties) get_store().find_element_user(GRADFILL$18, 0);
            if (cTGradientFillProperties == null) {
                return null;
            }
            return cTGradientFillProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public CTGroupFillProperties getGrpFill() {
        synchronized (monitor()) {
            check_orphaned();
            CTGroupFillProperties cTGroupFillProperties = (CTGroupFillProperties) get_store().find_element_user(GRPFILL$24, 0);
            if (cTGroupFillProperties == null) {
                return null;
            }
            return cTGroupFillProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public STTextHorzOverflowType.Enum getHorzOverflow() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HORZOVERFLOW$42;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTextHorzOverflowType.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public CTLineProperties getLnB() {
        synchronized (monitor()) {
            check_orphaned();
            CTLineProperties cTLineProperties = (CTLineProperties) get_store().find_element_user(LNB$6, 0);
            if (cTLineProperties == null) {
                return null;
            }
            return cTLineProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public CTLineProperties getLnBlToTr() {
        synchronized (monitor()) {
            check_orphaned();
            CTLineProperties cTLineProperties = (CTLineProperties) get_store().find_element_user(LNBLTOTR$10, 0);
            if (cTLineProperties == null) {
                return null;
            }
            return cTLineProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public CTLineProperties getLnL() {
        synchronized (monitor()) {
            check_orphaned();
            CTLineProperties cTLineProperties = (CTLineProperties) get_store().find_element_user(LNL$0, 0);
            if (cTLineProperties == null) {
                return null;
            }
            return cTLineProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public CTLineProperties getLnR() {
        synchronized (monitor()) {
            check_orphaned();
            CTLineProperties cTLineProperties = (CTLineProperties) get_store().find_element_user(LNR$2, 0);
            if (cTLineProperties == null) {
                return null;
            }
            return cTLineProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public CTLineProperties getLnT() {
        synchronized (monitor()) {
            check_orphaned();
            CTLineProperties cTLineProperties = (CTLineProperties) get_store().find_element_user(LNT$4, 0);
            if (cTLineProperties == null) {
                return null;
            }
            return cTLineProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public CTLineProperties getLnTlToBr() {
        synchronized (monitor()) {
            check_orphaned();
            CTLineProperties cTLineProperties = (CTLineProperties) get_store().find_element_user(LNTLTOBR$8, 0);
            if (cTLineProperties == null) {
                return null;
            }
            return cTLineProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public int getMarB() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MARB$34;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public int getMarL() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MARL$28;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public int getMarR() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MARR$30;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public int getMarT() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MART$32;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public CTNoFillProperties getNoFill() {
        synchronized (monitor()) {
            check_orphaned();
            CTNoFillProperties cTNoFillProperties = (CTNoFillProperties) get_store().find_element_user(NOFILL$14, 0);
            if (cTNoFillProperties == null) {
                return null;
            }
            return cTNoFillProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public CTPatternFillProperties getPattFill() {
        synchronized (monitor()) {
            check_orphaned();
            CTPatternFillProperties cTPatternFillProperties = (CTPatternFillProperties) get_store().find_element_user(PATTFILL$22, 0);
            if (cTPatternFillProperties == null) {
                return null;
            }
            return cTPatternFillProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public CTSolidColorFillProperties getSolidFill() {
        synchronized (monitor()) {
            check_orphaned();
            CTSolidColorFillProperties cTSolidColorFillProperties = (CTSolidColorFillProperties) get_store().find_element_user(SOLIDFILL$16, 0);
            if (cTSolidColorFillProperties == null) {
                return null;
            }
            return cTSolidColorFillProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public STTextVerticalType.Enum getVert() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VERT$36;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTextVerticalType.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public boolean isSetAnchor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ANCHOR$38) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public boolean isSetAnchorCtr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ANCHORCTR$40) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public boolean isSetBlipFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BLIPFILL$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public boolean isSetCell3D() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CELL3D$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$26) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public boolean isSetGradFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(GRADFILL$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public boolean isSetGrpFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(GRPFILL$24) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public boolean isSetHorzOverflow() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HORZOVERFLOW$42) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public boolean isSetLnB() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LNB$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public boolean isSetLnBlToTr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LNBLTOTR$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public boolean isSetLnL() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LNL$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public boolean isSetLnR() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LNR$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public boolean isSetLnT() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LNT$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public boolean isSetLnTlToBr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LNTLTOBR$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public boolean isSetMarB() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MARB$34) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public boolean isSetMarL() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MARL$28) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public boolean isSetMarR() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MARR$30) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public boolean isSetMarT() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MART$32) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public boolean isSetNoFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NOFILL$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public boolean isSetPattFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PATTFILL$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public boolean isSetSolidFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SOLIDFILL$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public boolean isSetVert() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(VERT$36) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void setAnchor(STTextAnchoringType.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ANCHOR$38;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void setAnchorCtr(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ANCHORCTR$40;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void setBlipFill(CTBlipFillProperties cTBlipFillProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLIPFILL$20;
            CTBlipFillProperties cTBlipFillProperties2 = (CTBlipFillProperties) typeStore.find_element_user(qName, 0);
            if (cTBlipFillProperties2 == null) {
                cTBlipFillProperties2 = (CTBlipFillProperties) get_store().add_element_user(qName);
            }
            cTBlipFillProperties2.set(cTBlipFillProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void setCell3D(CTCell3D cTCell3D) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CELL3D$12;
            CTCell3D cTCell3DFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTCell3DFind_element_user == null) {
                cTCell3DFind_element_user = (CTCell3D) get_store().add_element_user(qName);
            }
            cTCell3DFind_element_user.set(cTCell3D);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$26;
            CTOfficeArtExtensionList cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) typeStore.find_element_user(qName, 0);
            if (cTOfficeArtExtensionList2 == null) {
                cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) get_store().add_element_user(qName);
            }
            cTOfficeArtExtensionList2.set(cTOfficeArtExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void setGradFill(CTGradientFillProperties cTGradientFillProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GRADFILL$18;
            CTGradientFillProperties cTGradientFillProperties2 = (CTGradientFillProperties) typeStore.find_element_user(qName, 0);
            if (cTGradientFillProperties2 == null) {
                cTGradientFillProperties2 = (CTGradientFillProperties) get_store().add_element_user(qName);
            }
            cTGradientFillProperties2.set(cTGradientFillProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void setGrpFill(CTGroupFillProperties cTGroupFillProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GRPFILL$24;
            CTGroupFillProperties cTGroupFillProperties2 = (CTGroupFillProperties) typeStore.find_element_user(qName, 0);
            if (cTGroupFillProperties2 == null) {
                cTGroupFillProperties2 = (CTGroupFillProperties) get_store().add_element_user(qName);
            }
            cTGroupFillProperties2.set(cTGroupFillProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void setHorzOverflow(STTextHorzOverflowType.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HORZOVERFLOW$42;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void setLnB(CTLineProperties cTLineProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LNB$6;
            CTLineProperties cTLineProperties2 = (CTLineProperties) typeStore.find_element_user(qName, 0);
            if (cTLineProperties2 == null) {
                cTLineProperties2 = (CTLineProperties) get_store().add_element_user(qName);
            }
            cTLineProperties2.set(cTLineProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void setLnBlToTr(CTLineProperties cTLineProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LNBLTOTR$10;
            CTLineProperties cTLineProperties2 = (CTLineProperties) typeStore.find_element_user(qName, 0);
            if (cTLineProperties2 == null) {
                cTLineProperties2 = (CTLineProperties) get_store().add_element_user(qName);
            }
            cTLineProperties2.set(cTLineProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void setLnL(CTLineProperties cTLineProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LNL$0;
            CTLineProperties cTLineProperties2 = (CTLineProperties) typeStore.find_element_user(qName, 0);
            if (cTLineProperties2 == null) {
                cTLineProperties2 = (CTLineProperties) get_store().add_element_user(qName);
            }
            cTLineProperties2.set(cTLineProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void setLnR(CTLineProperties cTLineProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LNR$2;
            CTLineProperties cTLineProperties2 = (CTLineProperties) typeStore.find_element_user(qName, 0);
            if (cTLineProperties2 == null) {
                cTLineProperties2 = (CTLineProperties) get_store().add_element_user(qName);
            }
            cTLineProperties2.set(cTLineProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void setLnT(CTLineProperties cTLineProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LNT$4;
            CTLineProperties cTLineProperties2 = (CTLineProperties) typeStore.find_element_user(qName, 0);
            if (cTLineProperties2 == null) {
                cTLineProperties2 = (CTLineProperties) get_store().add_element_user(qName);
            }
            cTLineProperties2.set(cTLineProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void setLnTlToBr(CTLineProperties cTLineProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LNTLTOBR$8;
            CTLineProperties cTLineProperties2 = (CTLineProperties) typeStore.find_element_user(qName, 0);
            if (cTLineProperties2 == null) {
                cTLineProperties2 = (CTLineProperties) get_store().add_element_user(qName);
            }
            cTLineProperties2.set(cTLineProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void setMarB(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MARB$34;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void setMarL(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MARL$28;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void setMarR(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MARR$30;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void setMarT(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MART$32;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void setNoFill(CTNoFillProperties cTNoFillProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NOFILL$14;
            CTNoFillProperties cTNoFillProperties2 = (CTNoFillProperties) typeStore.find_element_user(qName, 0);
            if (cTNoFillProperties2 == null) {
                cTNoFillProperties2 = (CTNoFillProperties) get_store().add_element_user(qName);
            }
            cTNoFillProperties2.set(cTNoFillProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void setPattFill(CTPatternFillProperties cTPatternFillProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PATTFILL$22;
            CTPatternFillProperties cTPatternFillProperties2 = (CTPatternFillProperties) typeStore.find_element_user(qName, 0);
            if (cTPatternFillProperties2 == null) {
                cTPatternFillProperties2 = (CTPatternFillProperties) get_store().add_element_user(qName);
            }
            cTPatternFillProperties2.set(cTPatternFillProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SOLIDFILL$16;
            CTSolidColorFillProperties cTSolidColorFillProperties2 = (CTSolidColorFillProperties) typeStore.find_element_user(qName, 0);
            if (cTSolidColorFillProperties2 == null) {
                cTSolidColorFillProperties2 = (CTSolidColorFillProperties) get_store().add_element_user(qName);
            }
            cTSolidColorFillProperties2.set(cTSolidColorFillProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void setVert(STTextVerticalType.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VERT$36;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void unsetAnchor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ANCHOR$38);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void unsetAnchorCtr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ANCHORCTR$40);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void unsetBlipFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BLIPFILL$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void unsetCell3D() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CELL3D$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$26, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void unsetGradFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GRADFILL$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void unsetGrpFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GRPFILL$24, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void unsetHorzOverflow() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HORZOVERFLOW$42);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void unsetLnB() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LNB$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void unsetLnBlToTr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LNBLTOTR$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void unsetLnL() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LNL$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void unsetLnR() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LNR$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void unsetLnT() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LNT$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void unsetLnTlToBr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LNTLTOBR$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void unsetMarB() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MARB$34);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void unsetMarL() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MARL$28);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void unsetMarR() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MARR$30);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void unsetMarT() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MART$32);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void unsetNoFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NOFILL$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void unsetPattFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PATTFILL$22, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void unsetSolidFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SOLIDFILL$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void unsetVert() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(VERT$36);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public STTextAnchoringType xgetAnchor() {
        STTextAnchoringType sTTextAnchoringType;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ANCHOR$38;
            sTTextAnchoringType = (STTextAnchoringType) typeStore.find_attribute_user(qName);
            if (sTTextAnchoringType == null) {
                sTTextAnchoringType = (STTextAnchoringType) get_default_attribute_value(qName);
            }
        }
        return sTTextAnchoringType;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public XmlBoolean xgetAnchorCtr() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ANCHORCTR$40;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public STTextHorzOverflowType xgetHorzOverflow() {
        STTextHorzOverflowType sTTextHorzOverflowType;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HORZOVERFLOW$42;
            sTTextHorzOverflowType = (STTextHorzOverflowType) typeStore.find_attribute_user(qName);
            if (sTTextHorzOverflowType == null) {
                sTTextHorzOverflowType = (STTextHorzOverflowType) get_default_attribute_value(qName);
            }
        }
        return sTTextHorzOverflowType;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public STCoordinate32 xgetMarB() {
        STCoordinate32 sTCoordinate32;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MARB$34;
            sTCoordinate32 = (STCoordinate32) typeStore.find_attribute_user(qName);
            if (sTCoordinate32 == null) {
                sTCoordinate32 = (STCoordinate32) get_default_attribute_value(qName);
            }
        }
        return sTCoordinate32;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public STCoordinate32 xgetMarL() {
        STCoordinate32 sTCoordinate32;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MARL$28;
            sTCoordinate32 = (STCoordinate32) typeStore.find_attribute_user(qName);
            if (sTCoordinate32 == null) {
                sTCoordinate32 = (STCoordinate32) get_default_attribute_value(qName);
            }
        }
        return sTCoordinate32;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public STCoordinate32 xgetMarR() {
        STCoordinate32 sTCoordinate32;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MARR$30;
            sTCoordinate32 = (STCoordinate32) typeStore.find_attribute_user(qName);
            if (sTCoordinate32 == null) {
                sTCoordinate32 = (STCoordinate32) get_default_attribute_value(qName);
            }
        }
        return sTCoordinate32;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public STCoordinate32 xgetMarT() {
        STCoordinate32 sTCoordinate32;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MART$32;
            sTCoordinate32 = (STCoordinate32) typeStore.find_attribute_user(qName);
            if (sTCoordinate32 == null) {
                sTCoordinate32 = (STCoordinate32) get_default_attribute_value(qName);
            }
        }
        return sTCoordinate32;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public STTextVerticalType xgetVert() {
        STTextVerticalType sTTextVerticalType;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VERT$36;
            sTTextVerticalType = (STTextVerticalType) typeStore.find_attribute_user(qName);
            if (sTTextVerticalType == null) {
                sTTextVerticalType = (STTextVerticalType) get_default_attribute_value(qName);
            }
        }
        return sTTextVerticalType;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void xsetAnchor(STTextAnchoringType sTTextAnchoringType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ANCHOR$38;
            STTextAnchoringType sTTextAnchoringType2 = (STTextAnchoringType) typeStore.find_attribute_user(qName);
            if (sTTextAnchoringType2 == null) {
                sTTextAnchoringType2 = (STTextAnchoringType) get_store().add_attribute_user(qName);
            }
            sTTextAnchoringType2.set((XmlObject) sTTextAnchoringType);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void xsetAnchorCtr(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ANCHORCTR$40;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void xsetHorzOverflow(STTextHorzOverflowType sTTextHorzOverflowType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HORZOVERFLOW$42;
            STTextHorzOverflowType sTTextHorzOverflowType2 = (STTextHorzOverflowType) typeStore.find_attribute_user(qName);
            if (sTTextHorzOverflowType2 == null) {
                sTTextHorzOverflowType2 = (STTextHorzOverflowType) get_store().add_attribute_user(qName);
            }
            sTTextHorzOverflowType2.set((XmlObject) sTTextHorzOverflowType);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void xsetMarB(STCoordinate32 sTCoordinate32) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MARB$34;
            STCoordinate32 sTCoordinate33 = (STCoordinate32) typeStore.find_attribute_user(qName);
            if (sTCoordinate33 == null) {
                sTCoordinate33 = (STCoordinate32) get_store().add_attribute_user(qName);
            }
            sTCoordinate33.set(sTCoordinate32);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void xsetMarL(STCoordinate32 sTCoordinate32) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MARL$28;
            STCoordinate32 sTCoordinate33 = (STCoordinate32) typeStore.find_attribute_user(qName);
            if (sTCoordinate33 == null) {
                sTCoordinate33 = (STCoordinate32) get_store().add_attribute_user(qName);
            }
            sTCoordinate33.set(sTCoordinate32);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void xsetMarR(STCoordinate32 sTCoordinate32) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MARR$30;
            STCoordinate32 sTCoordinate33 = (STCoordinate32) typeStore.find_attribute_user(qName);
            if (sTCoordinate33 == null) {
                sTCoordinate33 = (STCoordinate32) get_store().add_attribute_user(qName);
            }
            sTCoordinate33.set(sTCoordinate32);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void xsetMarT(STCoordinate32 sTCoordinate32) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MART$32;
            STCoordinate32 sTCoordinate33 = (STCoordinate32) typeStore.find_attribute_user(qName);
            if (sTCoordinate33 == null) {
                sTCoordinate33 = (STCoordinate32) get_store().add_attribute_user(qName);
            }
            sTCoordinate33.set(sTCoordinate32);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties
    public void xsetVert(STTextVerticalType sTTextVerticalType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VERT$36;
            STTextVerticalType sTTextVerticalType2 = (STTextVerticalType) typeStore.find_attribute_user(qName);
            if (sTTextVerticalType2 == null) {
                sTTextVerticalType2 = (STTextVerticalType) get_store().add_attribute_user(qName);
            }
            sTTextVerticalType2.set((XmlObject) sTTextVerticalType);
        }
    }
}
