package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTAnchorClientData;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.STEditAs;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTTwoCellAnchorImpl extends XmlComplexContentImpl implements CTTwoCellAnchor {
    private static final QName FROM$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "from");
    private static final QName TO$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "to");
    private static final QName SP$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "sp");
    private static final QName GRPSP$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "grpSp");
    private static final QName GRAPHICFRAME$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "graphicFrame");
    private static final QName CXNSP$10 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "cxnSp");
    private static final QName PIC$12 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "pic");
    private static final QName CLIENTDATA$14 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "clientData");
    private static final QName EDITAS$16 = new QName("", "editAs");

    public CTTwoCellAnchorImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public CTAnchorClientData addNewClientData() {
        CTAnchorClientData cTAnchorClientData;
        synchronized (monitor()) {
            check_orphaned();
            cTAnchorClientData = (CTAnchorClientData) get_store().add_element_user(CLIENTDATA$14);
        }
        return cTAnchorClientData;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public CTConnector addNewCxnSp() {
        CTConnector cTConnector;
        synchronized (monitor()) {
            check_orphaned();
            cTConnector = (CTConnector) get_store().add_element_user(CXNSP$10);
        }
        return cTConnector;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public CTMarker addNewFrom() {
        CTMarker cTMarker;
        synchronized (monitor()) {
            check_orphaned();
            cTMarker = (CTMarker) get_store().add_element_user(FROM$0);
        }
        return cTMarker;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public CTGraphicalObjectFrame addNewGraphicFrame() {
        CTGraphicalObjectFrame cTGraphicalObjectFrame;
        synchronized (monitor()) {
            check_orphaned();
            cTGraphicalObjectFrame = (CTGraphicalObjectFrame) get_store().add_element_user(GRAPHICFRAME$8);
        }
        return cTGraphicalObjectFrame;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public CTGroupShape addNewGrpSp() {
        CTGroupShape cTGroupShape;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupShape = (CTGroupShape) get_store().add_element_user(GRPSP$6);
        }
        return cTGroupShape;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public CTPicture addNewPic() {
        CTPicture cTPicture;
        synchronized (monitor()) {
            check_orphaned();
            cTPicture = (CTPicture) get_store().add_element_user(PIC$12);
        }
        return cTPicture;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public CTShape addNewSp() {
        CTShape cTShape;
        synchronized (monitor()) {
            check_orphaned();
            cTShape = (CTShape) get_store().add_element_user(SP$4);
        }
        return cTShape;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public CTMarker addNewTo() {
        CTMarker cTMarker;
        synchronized (monitor()) {
            check_orphaned();
            cTMarker = (CTMarker) get_store().add_element_user(TO$2);
        }
        return cTMarker;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public CTAnchorClientData getClientData() {
        synchronized (monitor()) {
            check_orphaned();
            CTAnchorClientData cTAnchorClientData = (CTAnchorClientData) get_store().find_element_user(CLIENTDATA$14, 0);
            if (cTAnchorClientData == null) {
                return null;
            }
            return cTAnchorClientData;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public CTConnector getCxnSp() {
        synchronized (monitor()) {
            check_orphaned();
            CTConnector cTConnector = (CTConnector) get_store().find_element_user(CXNSP$10, 0);
            if (cTConnector == null) {
                return null;
            }
            return cTConnector;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public STEditAs.Enum getEditAs() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EDITAS$16;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STEditAs.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public CTMarker getFrom() {
        synchronized (monitor()) {
            check_orphaned();
            CTMarker cTMarker = (CTMarker) get_store().find_element_user(FROM$0, 0);
            if (cTMarker == null) {
                return null;
            }
            return cTMarker;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public CTGraphicalObjectFrame getGraphicFrame() {
        synchronized (monitor()) {
            check_orphaned();
            CTGraphicalObjectFrame cTGraphicalObjectFrame = (CTGraphicalObjectFrame) get_store().find_element_user(GRAPHICFRAME$8, 0);
            if (cTGraphicalObjectFrame == null) {
                return null;
            }
            return cTGraphicalObjectFrame;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public CTGroupShape getGrpSp() {
        synchronized (monitor()) {
            check_orphaned();
            CTGroupShape cTGroupShape = (CTGroupShape) get_store().find_element_user(GRPSP$6, 0);
            if (cTGroupShape == null) {
                return null;
            }
            return cTGroupShape;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public CTPicture getPic() {
        synchronized (monitor()) {
            check_orphaned();
            CTPicture cTPicture = (CTPicture) get_store().find_element_user(PIC$12, 0);
            if (cTPicture == null) {
                return null;
            }
            return cTPicture;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public CTShape getSp() {
        synchronized (monitor()) {
            check_orphaned();
            CTShape cTShape = (CTShape) get_store().find_element_user(SP$4, 0);
            if (cTShape == null) {
                return null;
            }
            return cTShape;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public CTMarker getTo() {
        synchronized (monitor()) {
            check_orphaned();
            CTMarker cTMarker = (CTMarker) get_store().find_element_user(TO$2, 0);
            if (cTMarker == null) {
                return null;
            }
            return cTMarker;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public boolean isSetCxnSp() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CXNSP$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public boolean isSetEditAs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(EDITAS$16) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public boolean isSetGraphicFrame() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(GRAPHICFRAME$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public boolean isSetGrpSp() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(GRPSP$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public boolean isSetPic() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PIC$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public boolean isSetSp() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SP$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public void setClientData(CTAnchorClientData cTAnchorClientData) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLIENTDATA$14;
            CTAnchorClientData cTAnchorClientData2 = (CTAnchorClientData) typeStore.find_element_user(qName, 0);
            if (cTAnchorClientData2 == null) {
                cTAnchorClientData2 = (CTAnchorClientData) get_store().add_element_user(qName);
            }
            cTAnchorClientData2.set(cTAnchorClientData);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public void setCxnSp(CTConnector cTConnector) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CXNSP$10;
            CTConnector cTConnector2 = (CTConnector) typeStore.find_element_user(qName, 0);
            if (cTConnector2 == null) {
                cTConnector2 = (CTConnector) get_store().add_element_user(qName);
            }
            cTConnector2.set(cTConnector);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public void setEditAs(STEditAs.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EDITAS$16;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public void setFrom(CTMarker cTMarker) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FROM$0;
            CTMarker cTMarker2 = (CTMarker) typeStore.find_element_user(qName, 0);
            if (cTMarker2 == null) {
                cTMarker2 = (CTMarker) get_store().add_element_user(qName);
            }
            cTMarker2.set(cTMarker);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public void setGraphicFrame(CTGraphicalObjectFrame cTGraphicalObjectFrame) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GRAPHICFRAME$8;
            CTGraphicalObjectFrame cTGraphicalObjectFrame2 = (CTGraphicalObjectFrame) typeStore.find_element_user(qName, 0);
            if (cTGraphicalObjectFrame2 == null) {
                cTGraphicalObjectFrame2 = (CTGraphicalObjectFrame) get_store().add_element_user(qName);
            }
            cTGraphicalObjectFrame2.set(cTGraphicalObjectFrame);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public void setGrpSp(CTGroupShape cTGroupShape) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GRPSP$6;
            CTGroupShape cTGroupShape2 = (CTGroupShape) typeStore.find_element_user(qName, 0);
            if (cTGroupShape2 == null) {
                cTGroupShape2 = (CTGroupShape) get_store().add_element_user(qName);
            }
            cTGroupShape2.set(cTGroupShape);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public void setPic(CTPicture cTPicture) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PIC$12;
            CTPicture cTPicture2 = (CTPicture) typeStore.find_element_user(qName, 0);
            if (cTPicture2 == null) {
                cTPicture2 = (CTPicture) get_store().add_element_user(qName);
            }
            cTPicture2.set(cTPicture);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public void setSp(CTShape cTShape) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SP$4;
            CTShape cTShape2 = (CTShape) typeStore.find_element_user(qName, 0);
            if (cTShape2 == null) {
                cTShape2 = (CTShape) get_store().add_element_user(qName);
            }
            cTShape2.set(cTShape);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public void setTo(CTMarker cTMarker) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TO$2;
            CTMarker cTMarker2 = (CTMarker) typeStore.find_element_user(qName, 0);
            if (cTMarker2 == null) {
                cTMarker2 = (CTMarker) get_store().add_element_user(qName);
            }
            cTMarker2.set(cTMarker);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public void unsetCxnSp() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CXNSP$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public void unsetEditAs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(EDITAS$16);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public void unsetGraphicFrame() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GRAPHICFRAME$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public void unsetGrpSp() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GRPSP$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public void unsetPic() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PIC$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public void unsetSp() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SP$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public STEditAs xgetEditAs() {
        STEditAs sTEditAs;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EDITAS$16;
            sTEditAs = (STEditAs) typeStore.find_attribute_user(qName);
            if (sTEditAs == null) {
                sTEditAs = (STEditAs) get_default_attribute_value(qName);
            }
        }
        return sTEditAs;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public void xsetEditAs(STEditAs sTEditAs) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EDITAS$16;
            STEditAs sTEditAs2 = (STEditAs) typeStore.find_attribute_user(qName);
            if (sTEditAs2 == null) {
                sTEditAs2 = (STEditAs) get_store().add_attribute_user(qName);
            }
            sTEditAs2.set((XmlObject) sTEditAs);
        }
    }
}
