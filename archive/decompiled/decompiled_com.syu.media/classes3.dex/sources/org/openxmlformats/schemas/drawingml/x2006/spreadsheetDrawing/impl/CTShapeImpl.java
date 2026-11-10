package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShapeNonVisual;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTShapeImpl extends XmlComplexContentImpl implements CTShape {
    private static final QName NVSPPR$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "nvSpPr");
    private static final QName SPPR$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "spPr");
    private static final QName STYLE$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "style");
    private static final QName TXBODY$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "txBody");
    private static final QName MACRO$8 = new QName("", "macro");
    private static final QName TEXTLINK$10 = new QName("", "textlink");
    private static final QName FLOCKSTEXT$12 = new QName("", "fLocksText");
    private static final QName FPUBLISHED$14 = new QName("", "fPublished");

    public CTShapeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public CTShapeNonVisual addNewNvSpPr() {
        CTShapeNonVisual cTShapeNonVisual;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeNonVisual = (CTShapeNonVisual) get_store().add_element_user(NVSPPR$0);
        }
        return cTShapeNonVisual;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public CTShapeProperties addNewSpPr() {
        CTShapeProperties cTShapeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeProperties = (CTShapeProperties) get_store().add_element_user(SPPR$2);
        }
        return cTShapeProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public CTShapeStyle addNewStyle() {
        CTShapeStyle cTShapeStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeStyle = (CTShapeStyle) get_store().add_element_user(STYLE$4);
        }
        return cTShapeStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public CTTextBody addNewTxBody() {
        CTTextBody cTTextBody;
        synchronized (monitor()) {
            check_orphaned();
            cTTextBody = (CTTextBody) get_store().add_element_user(TXBODY$6);
        }
        return cTTextBody;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public boolean getFLocksText() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FLOCKSTEXT$12;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public boolean getFPublished() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FPUBLISHED$14;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public String getMacro() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(MACRO$8);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public CTShapeNonVisual getNvSpPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTShapeNonVisual cTShapeNonVisual = (CTShapeNonVisual) get_store().find_element_user(NVSPPR$0, 0);
            if (cTShapeNonVisual == null) {
                return null;
            }
            return cTShapeNonVisual;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public CTShapeProperties getSpPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTShapeProperties cTShapeProperties = (CTShapeProperties) get_store().find_element_user(SPPR$2, 0);
            if (cTShapeProperties == null) {
                return null;
            }
            return cTShapeProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public CTShapeStyle getStyle() {
        synchronized (monitor()) {
            check_orphaned();
            CTShapeStyle cTShapeStyle = (CTShapeStyle) get_store().find_element_user(STYLE$4, 0);
            if (cTShapeStyle == null) {
                return null;
            }
            return cTShapeStyle;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public String getTextlink() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TEXTLINK$10);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public CTTextBody getTxBody() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextBody cTTextBody = (CTTextBody) get_store().find_element_user(TXBODY$6, 0);
            if (cTTextBody == null) {
                return null;
            }
            return cTTextBody;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public boolean isSetFLocksText() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FLOCKSTEXT$12) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public boolean isSetFPublished() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FPUBLISHED$14) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public boolean isSetMacro() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MACRO$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public boolean isSetStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(STYLE$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public boolean isSetTextlink() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TEXTLINK$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public boolean isSetTxBody() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TXBODY$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public void setFLocksText(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FLOCKSTEXT$12;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public void setFPublished(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FPUBLISHED$14;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public void setMacro(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MACRO$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public void setNvSpPr(CTShapeNonVisual cTShapeNonVisual) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NVSPPR$0;
            CTShapeNonVisual cTShapeNonVisual2 = (CTShapeNonVisual) typeStore.find_element_user(qName, 0);
            if (cTShapeNonVisual2 == null) {
                cTShapeNonVisual2 = (CTShapeNonVisual) get_store().add_element_user(qName);
            }
            cTShapeNonVisual2.set(cTShapeNonVisual);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public void setSpPr(CTShapeProperties cTShapeProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPPR$2;
            CTShapeProperties cTShapeProperties2 = (CTShapeProperties) typeStore.find_element_user(qName, 0);
            if (cTShapeProperties2 == null) {
                cTShapeProperties2 = (CTShapeProperties) get_store().add_element_user(qName);
            }
            cTShapeProperties2.set(cTShapeProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public void setStyle(CTShapeStyle cTShapeStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLE$4;
            CTShapeStyle cTShapeStyle2 = (CTShapeStyle) typeStore.find_element_user(qName, 0);
            if (cTShapeStyle2 == null) {
                cTShapeStyle2 = (CTShapeStyle) get_store().add_element_user(qName);
            }
            cTShapeStyle2.set(cTShapeStyle);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public void setTextlink(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TEXTLINK$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public void setTxBody(CTTextBody cTTextBody) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TXBODY$6;
            CTTextBody cTTextBody2 = (CTTextBody) typeStore.find_element_user(qName, 0);
            if (cTTextBody2 == null) {
                cTTextBody2 = (CTTextBody) get_store().add_element_user(qName);
            }
            cTTextBody2.set(cTTextBody);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public void unsetFLocksText() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FLOCKSTEXT$12);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public void unsetFPublished() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FPUBLISHED$14);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public void unsetMacro() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MACRO$8);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public void unsetStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STYLE$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public void unsetTextlink() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TEXTLINK$10);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public void unsetTxBody() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TXBODY$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public XmlBoolean xgetFLocksText() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FLOCKSTEXT$12;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public XmlBoolean xgetFPublished() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FPUBLISHED$14;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public XmlString xgetMacro() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(MACRO$8);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public XmlString xgetTextlink() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(TEXTLINK$10);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public void xsetFLocksText(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FLOCKSTEXT$12;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public void xsetFPublished(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FPUBLISHED$14;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public void xsetMacro(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MACRO$8;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape
    public void xsetTextlink(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TEXTLINK$10;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }
}
