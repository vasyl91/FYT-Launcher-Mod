package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps;
import org.openxmlformats.schemas.presentationml.x2006.main.CTConnectorNonVisual;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTConnectorNonVisualImpl extends XmlComplexContentImpl implements CTConnectorNonVisual {
    private static final QName CNVPR$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "cNvPr");
    private static final QName CNVCXNSPPR$2 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "cNvCxnSpPr");
    private static final QName NVPR$4 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "nvPr");

    public CTConnectorNonVisualImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTConnectorNonVisual
    public CTNonVisualConnectorProperties addNewCNvCxnSpPr() {
        CTNonVisualConnectorProperties cTNonVisualConnectorProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTNonVisualConnectorProperties = (CTNonVisualConnectorProperties) get_store().add_element_user(CNVCXNSPPR$2);
        }
        return cTNonVisualConnectorProperties;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTConnectorNonVisual
    public CTNonVisualDrawingProps addNewCNvPr() {
        CTNonVisualDrawingProps cTNonVisualDrawingProps;
        synchronized (monitor()) {
            check_orphaned();
            cTNonVisualDrawingProps = (CTNonVisualDrawingProps) get_store().add_element_user(CNVPR$0);
        }
        return cTNonVisualDrawingProps;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTConnectorNonVisual
    public CTApplicationNonVisualDrawingProps addNewNvPr() {
        CTApplicationNonVisualDrawingProps cTApplicationNonVisualDrawingProps;
        synchronized (monitor()) {
            check_orphaned();
            cTApplicationNonVisualDrawingProps = (CTApplicationNonVisualDrawingProps) get_store().add_element_user(NVPR$4);
        }
        return cTApplicationNonVisualDrawingProps;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTConnectorNonVisual
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTConnectorNonVisual
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTConnectorNonVisual
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTConnectorNonVisual
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTConnectorNonVisual
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTConnectorNonVisual
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
