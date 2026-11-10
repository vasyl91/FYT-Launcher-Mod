package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingShapeProps;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShapeNonVisual;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTShapeNonVisualImpl extends XmlComplexContentImpl implements CTShapeNonVisual {
    private static final QName CNVPR$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "cNvPr");
    private static final QName CNVSPPR$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "cNvSpPr");

    public CTShapeNonVisualImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShapeNonVisual
    public CTNonVisualDrawingProps addNewCNvPr() {
        CTNonVisualDrawingProps cTNonVisualDrawingProps;
        synchronized (monitor()) {
            check_orphaned();
            cTNonVisualDrawingProps = (CTNonVisualDrawingProps) get_store().add_element_user(CNVPR$0);
        }
        return cTNonVisualDrawingProps;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShapeNonVisual
    public CTNonVisualDrawingShapeProps addNewCNvSpPr() {
        CTNonVisualDrawingShapeProps cTNonVisualDrawingShapeProps;
        synchronized (monitor()) {
            check_orphaned();
            cTNonVisualDrawingShapeProps = (CTNonVisualDrawingShapeProps) get_store().add_element_user(CNVSPPR$2);
        }
        return cTNonVisualDrawingShapeProps;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShapeNonVisual
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShapeNonVisual
    public CTNonVisualDrawingShapeProps getCNvSpPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTNonVisualDrawingShapeProps cTNonVisualDrawingShapeProps = (CTNonVisualDrawingShapeProps) get_store().find_element_user(CNVSPPR$2, 0);
            if (cTNonVisualDrawingShapeProps == null) {
                return null;
            }
            return cTNonVisualDrawingShapeProps;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShapeNonVisual
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShapeNonVisual
    public void setCNvSpPr(CTNonVisualDrawingShapeProps cTNonVisualDrawingShapeProps) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CNVSPPR$2;
            CTNonVisualDrawingShapeProps cTNonVisualDrawingShapeProps2 = (CTNonVisualDrawingShapeProps) typeStore.find_element_user(qName, 0);
            if (cTNonVisualDrawingShapeProps2 == null) {
                cTNonVisualDrawingShapeProps2 = (CTNonVisualDrawingShapeProps) get_store().add_element_user(qName);
            }
            cTNonVisualDrawingShapeProps2.set(cTNonVisualDrawingShapeProps);
        }
    }
}
