package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnectorNonVisual;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTConnectorNonVisualImpl extends XmlComplexContentImpl implements CTConnectorNonVisual {
    private static final QName CNVPR$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "cNvPr");
    private static final QName CNVCXNSPPR$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "cNvCxnSpPr");

    public CTConnectorNonVisualImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnectorNonVisual
    public CTNonVisualConnectorProperties addNewCNvCxnSpPr() {
        CTNonVisualConnectorProperties cTNonVisualConnectorProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTNonVisualConnectorProperties = (CTNonVisualConnectorProperties) get_store().add_element_user(CNVCXNSPPR$2);
        }
        return cTNonVisualConnectorProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnectorNonVisual
    public CTNonVisualDrawingProps addNewCNvPr() {
        CTNonVisualDrawingProps cTNonVisualDrawingProps;
        synchronized (monitor()) {
            check_orphaned();
            cTNonVisualDrawingProps = (CTNonVisualDrawingProps) get_store().add_element_user(CNVPR$0);
        }
        return cTNonVisualDrawingProps;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnectorNonVisual
    public CTNonVisualConnectorProperties getCNvCxnSpPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTNonVisualConnectorProperties cTNonVisualConnectorProperties = (CTNonVisualConnectorProperties) get_store().find_element_user(CNVCXNSPPR$2, 0);
            if (cTNonVisualConnectorProperties == null) {
                return null;
            }
            return cTNonVisualConnectorProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnectorNonVisual
    public CTNonVisualDrawingProps getCNvPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTNonVisualDrawingProps cTNonVisualDrawingProps = (CTNonVisualDrawingProps) get_store().find_element_user(CNVPR$0, 0);
            if (cTNonVisualDrawingProps == null) {
                return null;
            }
            return cTNonVisualDrawingProps;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnectorNonVisual
    public void setCNvCxnSpPr(CTNonVisualConnectorProperties cTNonVisualConnectorProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CNVCXNSPPR$2;
            CTNonVisualConnectorProperties cTNonVisualConnectorProperties2 = (CTNonVisualConnectorProperties) typeStore.find_element_user(qName, 0);
            if (cTNonVisualConnectorProperties2 == null) {
                cTNonVisualConnectorProperties2 = (CTNonVisualConnectorProperties) get_store().add_element_user(qName);
            }
            cTNonVisualConnectorProperties2.set(cTNonVisualConnectorProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnectorNonVisual
    public void setCNvPr(CTNonVisualDrawingProps cTNonVisualDrawingProps) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CNVPR$0;
            CTNonVisualDrawingProps cTNonVisualDrawingProps2 = (CTNonVisualDrawingProps) typeStore.find_element_user(qName, 0);
            if (cTNonVisualDrawingProps2 == null) {
                cTNonVisualDrawingProps2 = (CTNonVisualDrawingProps) get_store().add_element_user(qName);
            }
            cTNonVisualDrawingProps2.set(cTNonVisualDrawingProps);
        }
    }
}
