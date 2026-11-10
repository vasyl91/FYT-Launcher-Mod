package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTDashStopList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineEndProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineJoinBevel;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineJoinMiterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineJoinRound;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNoFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPatternFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetLineDashProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.STCompoundLine;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineCap;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineWidth;
import org.openxmlformats.schemas.drawingml.x2006.main.STPenAlignment;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTLinePropertiesImpl extends XmlComplexContentImpl implements CTLineProperties {
    private static final QName NOFILL$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "noFill");
    private static final QName SOLIDFILL$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "solidFill");
    private static final QName GRADFILL$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "gradFill");
    private static final QName PATTFILL$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "pattFill");
    private static final QName PRSTDASH$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "prstDash");
    private static final QName CUSTDASH$10 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "custDash");
    private static final QName ROUND$12 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "round");
    private static final QName BEVEL$14 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "bevel");
    private static final QName MITER$16 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "miter");
    private static final QName HEADEND$18 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "headEnd");
    private static final QName TAILEND$20 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tailEnd");
    private static final QName EXTLST$22 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
    private static final QName W$24 = new QName("", "w");
    private static final QName CAP$26 = new QName("", "cap");
    private static final QName CMPD$28 = new QName("", "cmpd");
    private static final QName ALGN$30 = new QName("", "algn");

    public CTLinePropertiesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTLineJoinBevel addNewBevel() {
        CTLineJoinBevel cTLineJoinBevelAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLineJoinBevelAdd_element_user = get_store().add_element_user(BEVEL$14);
        }
        return cTLineJoinBevelAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTDashStopList addNewCustDash() {
        CTDashStopList cTDashStopListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDashStopListAdd_element_user = get_store().add_element_user(CUSTDASH$10);
        }
        return cTDashStopListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(EXTLST$22);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTGradientFillProperties addNewGradFill() {
        CTGradientFillProperties cTGradientFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTGradientFillProperties = (CTGradientFillProperties) get_store().add_element_user(GRADFILL$4);
        }
        return cTGradientFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTLineEndProperties addNewHeadEnd() {
        CTLineEndProperties cTLineEndProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTLineEndProperties = (CTLineEndProperties) get_store().add_element_user(HEADEND$18);
        }
        return cTLineEndProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTLineJoinMiterProperties addNewMiter() {
        CTLineJoinMiterProperties cTLineJoinMiterPropertiesAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLineJoinMiterPropertiesAdd_element_user = get_store().add_element_user(MITER$16);
        }
        return cTLineJoinMiterPropertiesAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTNoFillProperties addNewNoFill() {
        CTNoFillProperties cTNoFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTNoFillProperties = (CTNoFillProperties) get_store().add_element_user(NOFILL$0);
        }
        return cTNoFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTPatternFillProperties addNewPattFill() {
        CTPatternFillProperties cTPatternFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTPatternFillProperties = (CTPatternFillProperties) get_store().add_element_user(PATTFILL$6);
        }
        return cTPatternFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTPresetLineDashProperties addNewPrstDash() {
        CTPresetLineDashProperties cTPresetLineDashProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTPresetLineDashProperties = (CTPresetLineDashProperties) get_store().add_element_user(PRSTDASH$8);
        }
        return cTPresetLineDashProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTLineJoinRound addNewRound() {
        CTLineJoinRound cTLineJoinRound;
        synchronized (monitor()) {
            check_orphaned();
            cTLineJoinRound = (CTLineJoinRound) get_store().add_element_user(ROUND$12);
        }
        return cTLineJoinRound;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTSolidColorFillProperties addNewSolidFill() {
        CTSolidColorFillProperties cTSolidColorFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTSolidColorFillProperties = (CTSolidColorFillProperties) get_store().add_element_user(SOLIDFILL$2);
        }
        return cTSolidColorFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTLineEndProperties addNewTailEnd() {
        CTLineEndProperties cTLineEndProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTLineEndProperties = (CTLineEndProperties) get_store().add_element_user(TAILEND$20);
        }
        return cTLineEndProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public STPenAlignment.Enum getAlgn() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ALGN$30);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STPenAlignment.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTLineJoinBevel getBevel() {
        synchronized (monitor()) {
            check_orphaned();
            CTLineJoinBevel cTLineJoinBevelFind_element_user = get_store().find_element_user(BEVEL$14, 0);
            if (cTLineJoinBevelFind_element_user == null) {
                return null;
            }
            return cTLineJoinBevelFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public STLineCap.Enum getCap() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CAP$26);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STLineCap.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public STCompoundLine.Enum getCmpd() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CMPD$28);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STCompoundLine.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTDashStopList getCustDash() {
        synchronized (monitor()) {
            check_orphaned();
            CTDashStopList cTDashStopListFind_element_user = get_store().find_element_user(CUSTDASH$10, 0);
            if (cTDashStopListFind_element_user == null) {
                return null;
            }
            return cTDashStopListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTOfficeArtExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTOfficeArtExtensionList cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().find_element_user(EXTLST$22, 0);
            if (cTOfficeArtExtensionList == null) {
                return null;
            }
            return cTOfficeArtExtensionList;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTGradientFillProperties getGradFill() {
        synchronized (monitor()) {
            check_orphaned();
            CTGradientFillProperties cTGradientFillProperties = (CTGradientFillProperties) get_store().find_element_user(GRADFILL$4, 0);
            if (cTGradientFillProperties == null) {
                return null;
            }
            return cTGradientFillProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTLineEndProperties getHeadEnd() {
        synchronized (monitor()) {
            check_orphaned();
            CTLineEndProperties cTLineEndProperties = (CTLineEndProperties) get_store().find_element_user(HEADEND$18, 0);
            if (cTLineEndProperties == null) {
                return null;
            }
            return cTLineEndProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTLineJoinMiterProperties getMiter() {
        synchronized (monitor()) {
            check_orphaned();
            CTLineJoinMiterProperties cTLineJoinMiterPropertiesFind_element_user = get_store().find_element_user(MITER$16, 0);
            if (cTLineJoinMiterPropertiesFind_element_user == null) {
                return null;
            }
            return cTLineJoinMiterPropertiesFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTNoFillProperties getNoFill() {
        synchronized (monitor()) {
            check_orphaned();
            CTNoFillProperties cTNoFillProperties = (CTNoFillProperties) get_store().find_element_user(NOFILL$0, 0);
            if (cTNoFillProperties == null) {
                return null;
            }
            return cTNoFillProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTPatternFillProperties getPattFill() {
        synchronized (monitor()) {
            check_orphaned();
            CTPatternFillProperties cTPatternFillProperties = (CTPatternFillProperties) get_store().find_element_user(PATTFILL$6, 0);
            if (cTPatternFillProperties == null) {
                return null;
            }
            return cTPatternFillProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTPresetLineDashProperties getPrstDash() {
        synchronized (monitor()) {
            check_orphaned();
            CTPresetLineDashProperties cTPresetLineDashProperties = (CTPresetLineDashProperties) get_store().find_element_user(PRSTDASH$8, 0);
            if (cTPresetLineDashProperties == null) {
                return null;
            }
            return cTPresetLineDashProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTLineJoinRound getRound() {
        synchronized (monitor()) {
            check_orphaned();
            CTLineJoinRound cTLineJoinRound = (CTLineJoinRound) get_store().find_element_user(ROUND$12, 0);
            if (cTLineJoinRound == null) {
                return null;
            }
            return cTLineJoinRound;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTSolidColorFillProperties getSolidFill() {
        synchronized (monitor()) {
            check_orphaned();
            CTSolidColorFillProperties cTSolidColorFillProperties = (CTSolidColorFillProperties) get_store().find_element_user(SOLIDFILL$2, 0);
            if (cTSolidColorFillProperties == null) {
                return null;
            }
            return cTSolidColorFillProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public CTLineEndProperties getTailEnd() {
        synchronized (monitor()) {
            check_orphaned();
            CTLineEndProperties cTLineEndProperties = (CTLineEndProperties) get_store().find_element_user(TAILEND$20, 0);
            if (cTLineEndProperties == null) {
                return null;
            }
            return cTLineEndProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public int getW() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(W$24);
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public boolean isSetAlgn() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALGN$30) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public boolean isSetBevel() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BEVEL$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public boolean isSetCap() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CAP$26) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public boolean isSetCmpd() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CMPD$28) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public boolean isSetCustDash() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CUSTDASH$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public boolean isSetGradFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(GRADFILL$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public boolean isSetHeadEnd() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HEADEND$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public boolean isSetMiter() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MITER$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public boolean isSetNoFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NOFILL$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public boolean isSetPattFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PATTFILL$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public boolean isSetPrstDash() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PRSTDASH$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public boolean isSetRound() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ROUND$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public boolean isSetSolidFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SOLIDFILL$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public boolean isSetTailEnd() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TAILEND$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public boolean isSetW() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(W$24) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void setAlgn(STPenAlignment.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALGN$30;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void setBevel(CTLineJoinBevel cTLineJoinBevel) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BEVEL$14;
            CTLineJoinBevel cTLineJoinBevelFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTLineJoinBevelFind_element_user == null) {
                cTLineJoinBevelFind_element_user = (CTLineJoinBevel) get_store().add_element_user(qName);
            }
            cTLineJoinBevelFind_element_user.set(cTLineJoinBevel);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void setCap(STLineCap.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CAP$26;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void setCmpd(STCompoundLine.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CMPD$28;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void setCustDash(CTDashStopList cTDashStopList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CUSTDASH$10;
            CTDashStopList cTDashStopListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTDashStopListFind_element_user == null) {
                cTDashStopListFind_element_user = (CTDashStopList) get_store().add_element_user(qName);
            }
            cTDashStopListFind_element_user.set(cTDashStopList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$22;
            CTOfficeArtExtensionList cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) typeStore.find_element_user(qName, 0);
            if (cTOfficeArtExtensionList2 == null) {
                cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) get_store().add_element_user(qName);
            }
            cTOfficeArtExtensionList2.set(cTOfficeArtExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void setGradFill(CTGradientFillProperties cTGradientFillProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GRADFILL$4;
            CTGradientFillProperties cTGradientFillProperties2 = (CTGradientFillProperties) typeStore.find_element_user(qName, 0);
            if (cTGradientFillProperties2 == null) {
                cTGradientFillProperties2 = (CTGradientFillProperties) get_store().add_element_user(qName);
            }
            cTGradientFillProperties2.set(cTGradientFillProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void setHeadEnd(CTLineEndProperties cTLineEndProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HEADEND$18;
            CTLineEndProperties cTLineEndProperties2 = (CTLineEndProperties) typeStore.find_element_user(qName, 0);
            if (cTLineEndProperties2 == null) {
                cTLineEndProperties2 = (CTLineEndProperties) get_store().add_element_user(qName);
            }
            cTLineEndProperties2.set(cTLineEndProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void setMiter(CTLineJoinMiterProperties cTLineJoinMiterProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MITER$16;
            CTLineJoinMiterProperties cTLineJoinMiterPropertiesFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTLineJoinMiterPropertiesFind_element_user == null) {
                cTLineJoinMiterPropertiesFind_element_user = (CTLineJoinMiterProperties) get_store().add_element_user(qName);
            }
            cTLineJoinMiterPropertiesFind_element_user.set(cTLineJoinMiterProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void setNoFill(CTNoFillProperties cTNoFillProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NOFILL$0;
            CTNoFillProperties cTNoFillProperties2 = (CTNoFillProperties) typeStore.find_element_user(qName, 0);
            if (cTNoFillProperties2 == null) {
                cTNoFillProperties2 = (CTNoFillProperties) get_store().add_element_user(qName);
            }
            cTNoFillProperties2.set(cTNoFillProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void setPattFill(CTPatternFillProperties cTPatternFillProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PATTFILL$6;
            CTPatternFillProperties cTPatternFillProperties2 = (CTPatternFillProperties) typeStore.find_element_user(qName, 0);
            if (cTPatternFillProperties2 == null) {
                cTPatternFillProperties2 = (CTPatternFillProperties) get_store().add_element_user(qName);
            }
            cTPatternFillProperties2.set(cTPatternFillProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void setPrstDash(CTPresetLineDashProperties cTPresetLineDashProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PRSTDASH$8;
            CTPresetLineDashProperties cTPresetLineDashProperties2 = (CTPresetLineDashProperties) typeStore.find_element_user(qName, 0);
            if (cTPresetLineDashProperties2 == null) {
                cTPresetLineDashProperties2 = (CTPresetLineDashProperties) get_store().add_element_user(qName);
            }
            cTPresetLineDashProperties2.set(cTPresetLineDashProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void setRound(CTLineJoinRound cTLineJoinRound) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ROUND$12;
            CTLineJoinRound cTLineJoinRound2 = (CTLineJoinRound) typeStore.find_element_user(qName, 0);
            if (cTLineJoinRound2 == null) {
                cTLineJoinRound2 = (CTLineJoinRound) get_store().add_element_user(qName);
            }
            cTLineJoinRound2.set(cTLineJoinRound);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SOLIDFILL$2;
            CTSolidColorFillProperties cTSolidColorFillProperties2 = (CTSolidColorFillProperties) typeStore.find_element_user(qName, 0);
            if (cTSolidColorFillProperties2 == null) {
                cTSolidColorFillProperties2 = (CTSolidColorFillProperties) get_store().add_element_user(qName);
            }
            cTSolidColorFillProperties2.set(cTSolidColorFillProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void setTailEnd(CTLineEndProperties cTLineEndProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TAILEND$20;
            CTLineEndProperties cTLineEndProperties2 = (CTLineEndProperties) typeStore.find_element_user(qName, 0);
            if (cTLineEndProperties2 == null) {
                cTLineEndProperties2 = (CTLineEndProperties) get_store().add_element_user(qName);
            }
            cTLineEndProperties2.set(cTLineEndProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void setW(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = W$24;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void unsetAlgn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALGN$30);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void unsetBevel() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BEVEL$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void unsetCap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CAP$26);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void unsetCmpd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CMPD$28);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void unsetCustDash() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTDASH$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$22, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void unsetGradFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GRADFILL$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void unsetHeadEnd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HEADEND$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void unsetMiter() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MITER$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void unsetNoFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NOFILL$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void unsetPattFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PATTFILL$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void unsetPrstDash() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PRSTDASH$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void unsetRound() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ROUND$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void unsetSolidFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SOLIDFILL$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void unsetTailEnd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TAILEND$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void unsetW() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(W$24);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public STPenAlignment xgetAlgn() {
        STPenAlignment sTPenAlignment;
        synchronized (monitor()) {
            check_orphaned();
            sTPenAlignment = (STPenAlignment) get_store().find_attribute_user(ALGN$30);
        }
        return sTPenAlignment;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public STLineCap xgetCap() {
        STLineCap sTLineCap;
        synchronized (monitor()) {
            check_orphaned();
            sTLineCap = (STLineCap) get_store().find_attribute_user(CAP$26);
        }
        return sTLineCap;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public STCompoundLine xgetCmpd() {
        STCompoundLine sTCompoundLine;
        synchronized (monitor()) {
            check_orphaned();
            sTCompoundLine = (STCompoundLine) get_store().find_attribute_user(CMPD$28);
        }
        return sTCompoundLine;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public STLineWidth xgetW() {
        STLineWidth sTLineWidth;
        synchronized (monitor()) {
            check_orphaned();
            sTLineWidth = (STLineWidth) get_store().find_attribute_user(W$24);
        }
        return sTLineWidth;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void xsetAlgn(STPenAlignment sTPenAlignment) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALGN$30;
            STPenAlignment sTPenAlignment2 = (STPenAlignment) typeStore.find_attribute_user(qName);
            if (sTPenAlignment2 == null) {
                sTPenAlignment2 = (STPenAlignment) get_store().add_attribute_user(qName);
            }
            sTPenAlignment2.set((XmlObject) sTPenAlignment);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void xsetCap(STLineCap sTLineCap) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CAP$26;
            STLineCap sTLineCap2 = (STLineCap) typeStore.find_attribute_user(qName);
            if (sTLineCap2 == null) {
                sTLineCap2 = (STLineCap) get_store().add_attribute_user(qName);
            }
            sTLineCap2.set((XmlObject) sTLineCap);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void xsetCmpd(STCompoundLine sTCompoundLine) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CMPD$28;
            STCompoundLine sTCompoundLine2 = (STCompoundLine) typeStore.find_attribute_user(qName);
            if (sTCompoundLine2 == null) {
                sTCompoundLine2 = (STCompoundLine) get_store().add_attribute_user(qName);
            }
            sTCompoundLine2.set((XmlObject) sTCompoundLine);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties
    public void xsetW(STLineWidth sTLineWidth) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = W$24;
            STLineWidth sTLineWidth2 = (STLineWidth) typeStore.find_attribute_user(qName);
            if (sTLineWidth2 == null) {
                sTLineWidth2 = (STLineWidth) get_store().add_attribute_user(qName);
            }
            sTLineWidth2.set(sTLineWidth);
        }
    }
}
