package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFlatText;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetTextShape;
import org.openxmlformats.schemas.drawingml.x2006.main.CTScene3D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextNoAutofit;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextShapeAutofit;
import org.openxmlformats.schemas.drawingml.x2006.main.STAngle;
import org.openxmlformats.schemas.drawingml.x2006.main.STCoordinate32;
import org.openxmlformats.schemas.drawingml.x2006.main.STPositiveCoordinate32;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAnchoringType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextColumnCount;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextHorzOverflowType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextVertOverflowType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextVerticalType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextWrappingType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTTextBodyPropertiesImpl extends XmlComplexContentImpl implements CTTextBodyProperties {
    private static final QName PRSTTXWARP$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "prstTxWarp");
    private static final QName NOAUTOFIT$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "noAutofit");
    private static final QName NORMAUTOFIT$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "normAutofit");
    private static final QName SPAUTOFIT$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "spAutoFit");
    private static final QName SCENE3D$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "scene3d");
    private static final QName SP3D$10 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "sp3d");
    private static final QName FLATTX$12 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "flatTx");
    private static final QName EXTLST$14 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
    private static final QName ROT$16 = new QName("", "rot");
    private static final QName SPCFIRSTLASTPARA$18 = new QName("", "spcFirstLastPara");
    private static final QName VERTOVERFLOW$20 = new QName("", "vertOverflow");
    private static final QName HORZOVERFLOW$22 = new QName("", "horzOverflow");
    private static final QName VERT$24 = new QName("", "vert");
    private static final QName WRAP$26 = new QName("", "wrap");
    private static final QName LINS$28 = new QName("", "lIns");
    private static final QName TINS$30 = new QName("", "tIns");
    private static final QName RINS$32 = new QName("", "rIns");
    private static final QName BINS$34 = new QName("", "bIns");
    private static final QName NUMCOL$36 = new QName("", "numCol");
    private static final QName SPCCOL$38 = new QName("", "spcCol");
    private static final QName RTLCOL$40 = new QName("", "rtlCol");
    private static final QName FROMWORDART$42 = new QName("", "fromWordArt");
    private static final QName ANCHOR$44 = new QName("", "anchor");
    private static final QName ANCHORCTR$46 = new QName("", "anchorCtr");
    private static final QName FORCEAA$48 = new QName("", "forceAA");
    private static final QName UPRIGHT$50 = new QName("", "upright");
    private static final QName COMPATLNSPC$52 = new QName("", "compatLnSpc");

    public CTTextBodyPropertiesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(EXTLST$14);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public CTFlatText addNewFlatTx() {
        CTFlatText cTFlatTextAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFlatTextAdd_element_user = get_store().add_element_user(FLATTX$12);
        }
        return cTFlatTextAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public CTTextNoAutofit addNewNoAutofit() {
        CTTextNoAutofit cTTextNoAutofit;
        synchronized (monitor()) {
            check_orphaned();
            cTTextNoAutofit = (CTTextNoAutofit) get_store().add_element_user(NOAUTOFIT$2);
        }
        return cTTextNoAutofit;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public CTTextNormalAutofit addNewNormAutofit() {
        CTTextNormalAutofit cTTextNormalAutofit;
        synchronized (monitor()) {
            check_orphaned();
            cTTextNormalAutofit = (CTTextNormalAutofit) get_store().add_element_user(NORMAUTOFIT$4);
        }
        return cTTextNormalAutofit;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public CTPresetTextShape addNewPrstTxWarp() {
        CTPresetTextShape cTPresetTextShapeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPresetTextShapeAdd_element_user = get_store().add_element_user(PRSTTXWARP$0);
        }
        return cTPresetTextShapeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public CTScene3D addNewScene3D() {
        CTScene3D cTScene3DAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTScene3DAdd_element_user = get_store().add_element_user(SCENE3D$8);
        }
        return cTScene3DAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public CTShape3D addNewSp3D() {
        CTShape3D cTShape3DAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTShape3DAdd_element_user = get_store().add_element_user(SP3D$10);
        }
        return cTShape3DAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public CTTextShapeAutofit addNewSpAutoFit() {
        CTTextShapeAutofit cTTextShapeAutofit;
        synchronized (monitor()) {
            check_orphaned();
            cTTextShapeAutofit = (CTTextShapeAutofit) get_store().add_element_user(SPAUTOFIT$6);
        }
        return cTTextShapeAutofit;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public STTextAnchoringType.Enum getAnchor() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ANCHOR$44);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTextAnchoringType.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public boolean getAnchorCtr() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ANCHORCTR$46);
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public int getBIns() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BINS$34);
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public boolean getCompatLnSpc() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(COMPATLNSPC$52);
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public CTOfficeArtExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTOfficeArtExtensionList cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().find_element_user(EXTLST$14, 0);
            if (cTOfficeArtExtensionList == null) {
                return null;
            }
            return cTOfficeArtExtensionList;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public CTFlatText getFlatTx() {
        synchronized (monitor()) {
            check_orphaned();
            CTFlatText cTFlatTextFind_element_user = get_store().find_element_user(FLATTX$12, 0);
            if (cTFlatTextFind_element_user == null) {
                return null;
            }
            return cTFlatTextFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public boolean getForceAA() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FORCEAA$48);
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public boolean getFromWordArt() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FROMWORDART$42);
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public STTextHorzOverflowType.Enum getHorzOverflow() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HORZOVERFLOW$22);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTextHorzOverflowType.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public int getLIns() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(LINS$28);
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public CTTextNoAutofit getNoAutofit() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextNoAutofit cTTextNoAutofit = (CTTextNoAutofit) get_store().find_element_user(NOAUTOFIT$2, 0);
            if (cTTextNoAutofit == null) {
                return null;
            }
            return cTTextNoAutofit;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public CTTextNormalAutofit getNormAutofit() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextNormalAutofit cTTextNormalAutofit = (CTTextNormalAutofit) get_store().find_element_user(NORMAUTOFIT$4, 0);
            if (cTTextNormalAutofit == null) {
                return null;
            }
            return cTTextNormalAutofit;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public int getNumCol() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(NUMCOL$36);
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public CTPresetTextShape getPrstTxWarp() {
        synchronized (monitor()) {
            check_orphaned();
            CTPresetTextShape cTPresetTextShapeFind_element_user = get_store().find_element_user(PRSTTXWARP$0, 0);
            if (cTPresetTextShapeFind_element_user == null) {
                return null;
            }
            return cTPresetTextShapeFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public int getRIns() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(RINS$32);
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public int getRot() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ROT$16);
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public boolean getRtlCol() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(RTLCOL$40);
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public CTScene3D getScene3D() {
        synchronized (monitor()) {
            check_orphaned();
            CTScene3D cTScene3DFind_element_user = get_store().find_element_user(SCENE3D$8, 0);
            if (cTScene3DFind_element_user == null) {
                return null;
            }
            return cTScene3DFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public CTShape3D getSp3D() {
        synchronized (monitor()) {
            check_orphaned();
            CTShape3D cTShape3DFind_element_user = get_store().find_element_user(SP3D$10, 0);
            if (cTShape3DFind_element_user == null) {
                return null;
            }
            return cTShape3DFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public CTTextShapeAutofit getSpAutoFit() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextShapeAutofit cTTextShapeAutofit = (CTTextShapeAutofit) get_store().find_element_user(SPAUTOFIT$6, 0);
            if (cTTextShapeAutofit == null) {
                return null;
            }
            return cTTextShapeAutofit;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public int getSpcCol() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SPCCOL$38);
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public boolean getSpcFirstLastPara() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SPCFIRSTLASTPARA$18);
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public int getTIns() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TINS$30);
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public boolean getUpright() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UPRIGHT$50;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public STTextVerticalType.Enum getVert() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(VERT$24);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTextVerticalType.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public STTextVertOverflowType.Enum getVertOverflow() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(VERTOVERFLOW$20);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTextVertOverflowType.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public STTextWrappingType.Enum getWrap() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(WRAP$26);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STTextWrappingType.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public boolean isSetAnchor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ANCHOR$44) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public boolean isSetAnchorCtr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ANCHORCTR$46) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public boolean isSetBIns() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BINS$34) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public boolean isSetCompatLnSpc() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COMPATLNSPC$52) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public boolean isSetFlatTx() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FLATTX$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public boolean isSetForceAA() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FORCEAA$48) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public boolean isSetFromWordArt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FROMWORDART$42) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public boolean isSetHorzOverflow() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HORZOVERFLOW$22) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public boolean isSetLIns() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(LINS$28) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public boolean isSetNoAutofit() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NOAUTOFIT$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public boolean isSetNormAutofit() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NORMAUTOFIT$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public boolean isSetNumCol() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(NUMCOL$36) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public boolean isSetPrstTxWarp() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PRSTTXWARP$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public boolean isSetRIns() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(RINS$32) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public boolean isSetRot() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ROT$16) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public boolean isSetRtlCol() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(RTLCOL$40) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public boolean isSetScene3D() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SCENE3D$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public boolean isSetSp3D() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SP3D$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public boolean isSetSpAutoFit() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SPAUTOFIT$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public boolean isSetSpcCol() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SPCCOL$38) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public boolean isSetSpcFirstLastPara() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SPCFIRSTLASTPARA$18) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public boolean isSetTIns() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TINS$30) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public boolean isSetUpright() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(UPRIGHT$50) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public boolean isSetVert() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(VERT$24) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public boolean isSetVertOverflow() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(VERTOVERFLOW$20) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public boolean isSetWrap() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(WRAP$26) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void setAnchor(STTextAnchoringType.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ANCHOR$44;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void setAnchorCtr(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ANCHORCTR$46;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void setBIns(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BINS$34;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void setCompatLnSpc(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COMPATLNSPC$52;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$14;
            CTOfficeArtExtensionList cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) typeStore.find_element_user(qName, 0);
            if (cTOfficeArtExtensionList2 == null) {
                cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) get_store().add_element_user(qName);
            }
            cTOfficeArtExtensionList2.set(cTOfficeArtExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void setFlatTx(CTFlatText cTFlatText) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FLATTX$12;
            CTFlatText cTFlatTextFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTFlatTextFind_element_user == null) {
                cTFlatTextFind_element_user = (CTFlatText) get_store().add_element_user(qName);
            }
            cTFlatTextFind_element_user.set(cTFlatText);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void setForceAA(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORCEAA$48;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void setFromWordArt(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FROMWORDART$42;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void setHorzOverflow(STTextHorzOverflowType.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HORZOVERFLOW$22;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void setLIns(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LINS$28;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void setNoAutofit(CTTextNoAutofit cTTextNoAutofit) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NOAUTOFIT$2;
            CTTextNoAutofit cTTextNoAutofit2 = (CTTextNoAutofit) typeStore.find_element_user(qName, 0);
            if (cTTextNoAutofit2 == null) {
                cTTextNoAutofit2 = (CTTextNoAutofit) get_store().add_element_user(qName);
            }
            cTTextNoAutofit2.set(cTTextNoAutofit);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void setNormAutofit(CTTextNormalAutofit cTTextNormalAutofit) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NORMAUTOFIT$4;
            CTTextNormalAutofit cTTextNormalAutofit2 = (CTTextNormalAutofit) typeStore.find_element_user(qName, 0);
            if (cTTextNormalAutofit2 == null) {
                cTTextNormalAutofit2 = (CTTextNormalAutofit) get_store().add_element_user(qName);
            }
            cTTextNormalAutofit2.set(cTTextNormalAutofit);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void setNumCol(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NUMCOL$36;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void setPrstTxWarp(CTPresetTextShape cTPresetTextShape) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRSTTXWARP$0;
            CTPresetTextShape cTPresetTextShapeFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTPresetTextShapeFind_element_user == null) {
                cTPresetTextShapeFind_element_user = (CTPresetTextShape) get_store().add_element_user(qName);
            }
            cTPresetTextShapeFind_element_user.set(cTPresetTextShape);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void setRIns(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RINS$32;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void setRot(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ROT$16;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void setRtlCol(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RTLCOL$40;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void setScene3D(CTScene3D cTScene3D) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SCENE3D$8;
            CTScene3D cTScene3DFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTScene3DFind_element_user == null) {
                cTScene3DFind_element_user = (CTScene3D) get_store().add_element_user(qName);
            }
            cTScene3DFind_element_user.set(cTScene3D);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void setSp3D(CTShape3D cTShape3D) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SP3D$10;
            CTShape3D cTShape3DFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTShape3DFind_element_user == null) {
                cTShape3DFind_element_user = (CTShape3D) get_store().add_element_user(qName);
            }
            cTShape3DFind_element_user.set(cTShape3D);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void setSpAutoFit(CTTextShapeAutofit cTTextShapeAutofit) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPAUTOFIT$6;
            CTTextShapeAutofit cTTextShapeAutofit2 = (CTTextShapeAutofit) typeStore.find_element_user(qName, 0);
            if (cTTextShapeAutofit2 == null) {
                cTTextShapeAutofit2 = (CTTextShapeAutofit) get_store().add_element_user(qName);
            }
            cTTextShapeAutofit2.set(cTTextShapeAutofit);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void setSpcCol(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPCCOL$38;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void setSpcFirstLastPara(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPCFIRSTLASTPARA$18;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void setTIns(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TINS$30;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void setUpright(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UPRIGHT$50;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void setVert(STTextVerticalType.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VERT$24;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void setVertOverflow(STTextVertOverflowType.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VERTOVERFLOW$20;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void setWrap(STTextWrappingType.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WRAP$26;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void unsetAnchor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ANCHOR$44);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void unsetAnchorCtr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ANCHORCTR$46);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void unsetBIns() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BINS$34);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void unsetCompatLnSpc() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COMPATLNSPC$52);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void unsetFlatTx() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FLATTX$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void unsetForceAA() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FORCEAA$48);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void unsetFromWordArt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FROMWORDART$42);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void unsetHorzOverflow() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HORZOVERFLOW$22);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void unsetLIns() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(LINS$28);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void unsetNoAutofit() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NOAUTOFIT$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void unsetNormAutofit() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NORMAUTOFIT$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void unsetNumCol() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(NUMCOL$36);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void unsetPrstTxWarp() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PRSTTXWARP$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void unsetRIns() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(RINS$32);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void unsetRot() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ROT$16);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void unsetRtlCol() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(RTLCOL$40);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void unsetScene3D() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SCENE3D$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void unsetSp3D() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SP3D$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void unsetSpAutoFit() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SPAUTOFIT$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void unsetSpcCol() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SPCCOL$38);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void unsetSpcFirstLastPara() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SPCFIRSTLASTPARA$18);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void unsetTIns() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TINS$30);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void unsetUpright() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(UPRIGHT$50);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void unsetVert() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(VERT$24);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void unsetVertOverflow() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(VERTOVERFLOW$20);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void unsetWrap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(WRAP$26);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public STTextAnchoringType xgetAnchor() {
        STTextAnchoringType sTTextAnchoringType;
        synchronized (monitor()) {
            check_orphaned();
            sTTextAnchoringType = (STTextAnchoringType) get_store().find_attribute_user(ANCHOR$44);
        }
        return sTTextAnchoringType;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public XmlBoolean xgetAnchorCtr() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(ANCHORCTR$46);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public STCoordinate32 xgetBIns() {
        STCoordinate32 sTCoordinate32;
        synchronized (monitor()) {
            check_orphaned();
            sTCoordinate32 = (STCoordinate32) get_store().find_attribute_user(BINS$34);
        }
        return sTCoordinate32;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public XmlBoolean xgetCompatLnSpc() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(COMPATLNSPC$52);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public XmlBoolean xgetForceAA() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(FORCEAA$48);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public XmlBoolean xgetFromWordArt() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(FROMWORDART$42);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public STTextHorzOverflowType xgetHorzOverflow() {
        STTextHorzOverflowType sTTextHorzOverflowType;
        synchronized (monitor()) {
            check_orphaned();
            sTTextHorzOverflowType = (STTextHorzOverflowType) get_store().find_attribute_user(HORZOVERFLOW$22);
        }
        return sTTextHorzOverflowType;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public STCoordinate32 xgetLIns() {
        STCoordinate32 sTCoordinate32;
        synchronized (monitor()) {
            check_orphaned();
            sTCoordinate32 = (STCoordinate32) get_store().find_attribute_user(LINS$28);
        }
        return sTCoordinate32;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public STTextColumnCount xgetNumCol() {
        STTextColumnCount sTTextColumnCountFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTextColumnCountFind_attribute_user = get_store().find_attribute_user(NUMCOL$36);
        }
        return sTTextColumnCountFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public STCoordinate32 xgetRIns() {
        STCoordinate32 sTCoordinate32;
        synchronized (monitor()) {
            check_orphaned();
            sTCoordinate32 = (STCoordinate32) get_store().find_attribute_user(RINS$32);
        }
        return sTCoordinate32;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public STAngle xgetRot() {
        STAngle sTAngle;
        synchronized (monitor()) {
            check_orphaned();
            sTAngle = (STAngle) get_store().find_attribute_user(ROT$16);
        }
        return sTAngle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public XmlBoolean xgetRtlCol() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(RTLCOL$40);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public STPositiveCoordinate32 xgetSpcCol() {
        STPositiveCoordinate32 sTPositiveCoordinate32;
        synchronized (monitor()) {
            check_orphaned();
            sTPositiveCoordinate32 = (STPositiveCoordinate32) get_store().find_attribute_user(SPCCOL$38);
        }
        return sTPositiveCoordinate32;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public XmlBoolean xgetSpcFirstLastPara() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(SPCFIRSTLASTPARA$18);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public STCoordinate32 xgetTIns() {
        STCoordinate32 sTCoordinate32;
        synchronized (monitor()) {
            check_orphaned();
            sTCoordinate32 = (STCoordinate32) get_store().find_attribute_user(TINS$30);
        }
        return sTCoordinate32;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public XmlBoolean xgetUpright() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UPRIGHT$50;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public STTextVerticalType xgetVert() {
        STTextVerticalType sTTextVerticalType;
        synchronized (monitor()) {
            check_orphaned();
            sTTextVerticalType = (STTextVerticalType) get_store().find_attribute_user(VERT$24);
        }
        return sTTextVerticalType;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public STTextVertOverflowType xgetVertOverflow() {
        STTextVertOverflowType sTTextVertOverflowType;
        synchronized (monitor()) {
            check_orphaned();
            sTTextVertOverflowType = (STTextVertOverflowType) get_store().find_attribute_user(VERTOVERFLOW$20);
        }
        return sTTextVertOverflowType;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public STTextWrappingType xgetWrap() {
        STTextWrappingType sTTextWrappingType;
        synchronized (monitor()) {
            check_orphaned();
            sTTextWrappingType = (STTextWrappingType) get_store().find_attribute_user(WRAP$26);
        }
        return sTTextWrappingType;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void xsetAnchor(STTextAnchoringType sTTextAnchoringType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ANCHOR$44;
            STTextAnchoringType sTTextAnchoringType2 = (STTextAnchoringType) typeStore.find_attribute_user(qName);
            if (sTTextAnchoringType2 == null) {
                sTTextAnchoringType2 = (STTextAnchoringType) get_store().add_attribute_user(qName);
            }
            sTTextAnchoringType2.set((XmlObject) sTTextAnchoringType);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void xsetAnchorCtr(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ANCHORCTR$46;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void xsetBIns(STCoordinate32 sTCoordinate32) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BINS$34;
            STCoordinate32 sTCoordinate33 = (STCoordinate32) typeStore.find_attribute_user(qName);
            if (sTCoordinate33 == null) {
                sTCoordinate33 = (STCoordinate32) get_store().add_attribute_user(qName);
            }
            sTCoordinate33.set(sTCoordinate32);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void xsetCompatLnSpc(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COMPATLNSPC$52;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void xsetForceAA(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORCEAA$48;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void xsetFromWordArt(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FROMWORDART$42;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void xsetHorzOverflow(STTextHorzOverflowType sTTextHorzOverflowType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HORZOVERFLOW$22;
            STTextHorzOverflowType sTTextHorzOverflowType2 = (STTextHorzOverflowType) typeStore.find_attribute_user(qName);
            if (sTTextHorzOverflowType2 == null) {
                sTTextHorzOverflowType2 = (STTextHorzOverflowType) get_store().add_attribute_user(qName);
            }
            sTTextHorzOverflowType2.set((XmlObject) sTTextHorzOverflowType);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void xsetLIns(STCoordinate32 sTCoordinate32) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LINS$28;
            STCoordinate32 sTCoordinate33 = (STCoordinate32) typeStore.find_attribute_user(qName);
            if (sTCoordinate33 == null) {
                sTCoordinate33 = (STCoordinate32) get_store().add_attribute_user(qName);
            }
            sTCoordinate33.set(sTCoordinate32);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void xsetNumCol(STTextColumnCount sTTextColumnCount) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NUMCOL$36;
            STTextColumnCount sTTextColumnCountFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTTextColumnCountFind_attribute_user == null) {
                sTTextColumnCountFind_attribute_user = (STTextColumnCount) get_store().add_attribute_user(qName);
            }
            sTTextColumnCountFind_attribute_user.set(sTTextColumnCount);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void xsetRIns(STCoordinate32 sTCoordinate32) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RINS$32;
            STCoordinate32 sTCoordinate33 = (STCoordinate32) typeStore.find_attribute_user(qName);
            if (sTCoordinate33 == null) {
                sTCoordinate33 = (STCoordinate32) get_store().add_attribute_user(qName);
            }
            sTCoordinate33.set(sTCoordinate32);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void xsetRot(STAngle sTAngle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ROT$16;
            STAngle sTAngle2 = (STAngle) typeStore.find_attribute_user(qName);
            if (sTAngle2 == null) {
                sTAngle2 = (STAngle) get_store().add_attribute_user(qName);
            }
            sTAngle2.set(sTAngle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void xsetRtlCol(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RTLCOL$40;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void xsetSpcCol(STPositiveCoordinate32 sTPositiveCoordinate32) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPCCOL$38;
            STPositiveCoordinate32 sTPositiveCoordinate33 = (STPositiveCoordinate32) typeStore.find_attribute_user(qName);
            if (sTPositiveCoordinate33 == null) {
                sTPositiveCoordinate33 = (STPositiveCoordinate32) get_store().add_attribute_user(qName);
            }
            sTPositiveCoordinate33.set(sTPositiveCoordinate32);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void xsetSpcFirstLastPara(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPCFIRSTLASTPARA$18;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void xsetTIns(STCoordinate32 sTCoordinate32) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TINS$30;
            STCoordinate32 sTCoordinate33 = (STCoordinate32) typeStore.find_attribute_user(qName);
            if (sTCoordinate33 == null) {
                sTCoordinate33 = (STCoordinate32) get_store().add_attribute_user(qName);
            }
            sTCoordinate33.set(sTCoordinate32);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void xsetUpright(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UPRIGHT$50;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void xsetVert(STTextVerticalType sTTextVerticalType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VERT$24;
            STTextVerticalType sTTextVerticalType2 = (STTextVerticalType) typeStore.find_attribute_user(qName);
            if (sTTextVerticalType2 == null) {
                sTTextVerticalType2 = (STTextVerticalType) get_store().add_attribute_user(qName);
            }
            sTTextVerticalType2.set((XmlObject) sTTextVerticalType);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void xsetVertOverflow(STTextVertOverflowType sTTextVertOverflowType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VERTOVERFLOW$20;
            STTextVertOverflowType sTTextVertOverflowType2 = (STTextVertOverflowType) typeStore.find_attribute_user(qName);
            if (sTTextVertOverflowType2 == null) {
                sTTextVertOverflowType2 = (STTextVertOverflowType) get_store().add_attribute_user(qName);
            }
            sTTextVertOverflowType2.set((XmlObject) sTTextVertOverflowType);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties
    public void xsetWrap(STTextWrappingType sTTextWrappingType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WRAP$26;
            STTextWrappingType sTTextWrappingType2 = (STTextWrappingType) typeStore.find_attribute_user(qName);
            if (sTTextWrappingType2 == null) {
                sTTextWrappingType2 = (STTextWrappingType) get_store().add_attribute_user(qName);
            }
            sTTextWrappingType2.set((XmlObject) sTTextWrappingType);
        }
    }
}
