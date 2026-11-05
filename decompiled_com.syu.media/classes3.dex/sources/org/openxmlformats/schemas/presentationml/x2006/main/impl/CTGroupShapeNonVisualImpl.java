package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGroupDrawingShapeProps;
import org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShapeNonVisual;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTGroupShapeNonVisualImpl extends XmlComplexContentImpl implements CTGroupShapeNonVisual {
    private static final QName CNVPR$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "cNvPr");
    private static final QName CNVGRPSPPR$2 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "cNvGrpSpPr");
    private static final QName NVPR$4 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "nvPr");

    public CTGroupShapeNonVisualImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShapeNonVisual
    public CTNonVisualGroupDrawingShapeProps addNewCNvGrpSpPr() {
        CTNonVisualGroupDrawingShapeProps cTNonVisualGroupDrawingShapeProps;
        synchronized (monitor()) {
            check_orphaned();
            cTNonVisualGroupDrawingShapeProps = (CTNonVisualGroupDrawingShapeProps) get_store().add_element_user(CNVGRPSPPR$2);
        }
        return cTNonVisualGroupDrawingShapeProps;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShapeNonVisual
    public CTNonVisualDrawingProps addNewCNvPr() {
        CTNonVisualDrawingProps cTNonVisualDrawingProps;
        synchronized (monitor()) {
            check_orphaned();
            cTNonVisualDrawingProps = (CTNonVisualDrawingProps) get_store().add_element_user(CNVPR$0);
        }
        return cTNonVisualDrawingProps;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShapeNonVisual
    public CTApplicationNonVisualDrawingProps addNewNvPr() {
        CTApplicationNonVisualDrawingProps cTApplicationNonVisualDrawingProps;
        synchronized (monitor()) {
            check_orphaned();
            cTApplicationNonVisualDrawingProps = (CTApplicationNonVisualDrawingProps) get_store().add_element_user(NVPR$4);
        }
        return cTApplicationNonVisualDrawingProps;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShapeNonVisual
    public CTNonVisualGroupDrawingShapeProps getCNvGrpSpPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTNonVisualGroupDrawingShapeProps cTNonVisualGroupDrawingShapeProps = (CTNonVisualGroupDrawingShapeProps) get_store().find_element_user(CNVGRPSPPR$2, 0);
            if (cTNonVisualGroupDrawingShapeProps == null) {
                return null;
            }
            return cTNonVisualGroupDrawingShapeProps;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShapeNonVisual
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShapeNonVisual
    public CTApplicationNonVisualDrawingProps getNvPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTApplicationNonVisualDrawingProps cTApplicationNonVisualDrawingProps = (CTApplicationNonVisualDrawingProps) get_store().find_element_user(NVPR$4, 0);
            if (cTApplicationNonVisualDrawingProps == null) {
                return null;
            }
            return cTApplicationNonVisualDrawingProps;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShapeNonVisual
    public void setCNvGrpSpPr(CTNonVisualGroupDrawingShapeProps cTNonVisualGroupDrawingShapeProps) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CNVGRPSPPR$2;
            CTNonVisualGroupDrawingShapeProps cTNonVisualGroupDrawingShapeProps2 = (CTNonVisualGroupDrawingShapeProps) typeStore.find_element_user(qName, 0);
            if (cTNonVisualGroupDrawingShapeProps2 == null) {
                cTNonVisualGroupDrawingShapeProps2 = (CTNonVisualGroupDrawingShapeProps) get_store().add_element_user(qName);
            }
            cTNonVisualGroupDrawingShapeProps2.set(cTNonVisualGroupDrawingShapeProps);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShapeNonVisual
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShapeNonVisual
    public void setNvPr(CTApplicationNonVisualDrawingProps cTApplicationNonVisualDrawingProps) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NVPR$4;
            CTApplicationNonVisualDrawingProps cTApplicationNonVisualDrawingProps2 = (CTApplicationNonVisualDrawingProps) typeStore.find_element_user(qName, 0);
            if (cTApplicationNonVisualDrawingProps2 == null) {
                cTApplicationNonVisualDrawingProps2 = (CTApplicationNonVisualDrawingProps) get_store().add_element_user(qName);
            }
            cTApplicationNonVisualDrawingProps2.set(cTApplicationNonVisualDrawingProps);
        }
    }
}
