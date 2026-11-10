package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrameNonVisual;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTGraphicalObjectFrameImpl extends XmlComplexContentImpl implements CTGraphicalObjectFrame {
    private static final QName NVGRAPHICFRAMEPR$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "nvGraphicFramePr");
    private static final QName XFRM$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "xfrm");
    private static final QName GRAPHIC$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "graphic");
    private static final QName MACRO$6 = new QName("", "macro");
    private static final QName FPUBLISHED$8 = new QName("", "fPublished");

    public CTGraphicalObjectFrameImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame
    public CTGraphicalObject addNewGraphic() {
        CTGraphicalObject cTGraphicalObject;
        synchronized (monitor()) {
            check_orphaned();
            cTGraphicalObject = (CTGraphicalObject) get_store().add_element_user(GRAPHIC$4);
        }
        return cTGraphicalObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame
    public CTGraphicalObjectFrameNonVisual addNewNvGraphicFramePr() {
        CTGraphicalObjectFrameNonVisual cTGraphicalObjectFrameNonVisual;
        synchronized (monitor()) {
            check_orphaned();
            cTGraphicalObjectFrameNonVisual = (CTGraphicalObjectFrameNonVisual) get_store().add_element_user(NVGRAPHICFRAMEPR$0);
        }
        return cTGraphicalObjectFrameNonVisual;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame
    public CTTransform2D addNewXfrm() {
        CTTransform2D cTTransform2D;
        synchronized (monitor()) {
            check_orphaned();
            cTTransform2D = (CTTransform2D) get_store().add_element_user(XFRM$2);
        }
        return cTTransform2D;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame
    public boolean getFPublished() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FPUBLISHED$8;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame
    public CTGraphicalObject getGraphic() {
        synchronized (monitor()) {
            check_orphaned();
            CTGraphicalObject cTGraphicalObject = (CTGraphicalObject) get_store().find_element_user(GRAPHIC$4, 0);
            if (cTGraphicalObject == null) {
                return null;
            }
            return cTGraphicalObject;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame
    public String getMacro() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(MACRO$6);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame
    public CTGraphicalObjectFrameNonVisual getNvGraphicFramePr() {
        synchronized (monitor()) {
            check_orphaned();
            CTGraphicalObjectFrameNonVisual cTGraphicalObjectFrameNonVisual = (CTGraphicalObjectFrameNonVisual) get_store().find_element_user(NVGRAPHICFRAMEPR$0, 0);
            if (cTGraphicalObjectFrameNonVisual == null) {
                return null;
            }
            return cTGraphicalObjectFrameNonVisual;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame
    public CTTransform2D getXfrm() {
        synchronized (monitor()) {
            check_orphaned();
            CTTransform2D cTTransform2D = (CTTransform2D) get_store().find_element_user(XFRM$2, 0);
            if (cTTransform2D == null) {
                return null;
            }
            return cTTransform2D;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame
    public boolean isSetFPublished() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FPUBLISHED$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame
    public boolean isSetMacro() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MACRO$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame
    public void setFPublished(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FPUBLISHED$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame
    public void setGraphic(CTGraphicalObject cTGraphicalObject) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GRAPHIC$4;
            CTGraphicalObject cTGraphicalObject2 = (CTGraphicalObject) typeStore.find_element_user(qName, 0);
            if (cTGraphicalObject2 == null) {
                cTGraphicalObject2 = (CTGraphicalObject) get_store().add_element_user(qName);
            }
            cTGraphicalObject2.set(cTGraphicalObject);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame
    public void setMacro(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MACRO$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame
    public void setNvGraphicFramePr(CTGraphicalObjectFrameNonVisual cTGraphicalObjectFrameNonVisual) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NVGRAPHICFRAMEPR$0;
            CTGraphicalObjectFrameNonVisual cTGraphicalObjectFrameNonVisual2 = (CTGraphicalObjectFrameNonVisual) typeStore.find_element_user(qName, 0);
            if (cTGraphicalObjectFrameNonVisual2 == null) {
                cTGraphicalObjectFrameNonVisual2 = (CTGraphicalObjectFrameNonVisual) get_store().add_element_user(qName);
            }
            cTGraphicalObjectFrameNonVisual2.set(cTGraphicalObjectFrameNonVisual);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame
    public void setXfrm(CTTransform2D cTTransform2D) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = XFRM$2;
            CTTransform2D cTTransform2D2 = (CTTransform2D) typeStore.find_element_user(qName, 0);
            if (cTTransform2D2 == null) {
                cTTransform2D2 = (CTTransform2D) get_store().add_element_user(qName);
            }
            cTTransform2D2.set(cTTransform2D);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame
    public void unsetFPublished() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FPUBLISHED$8);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame
    public void unsetMacro() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MACRO$6);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame
    public XmlBoolean xgetFPublished() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FPUBLISHED$8;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame
    public XmlString xgetMacro() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(MACRO$6);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame
    public void xsetFPublished(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FPUBLISHED$8;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame
    public void xsetMacro(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MACRO$6;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }
}
