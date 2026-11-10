package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextLineBreak;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTTextLineBreakImpl extends XmlComplexContentImpl implements CTTextLineBreak {
    private static final QName RPR$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "rPr");

    public CTTextLineBreakImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextLineBreak
    public CTTextCharacterProperties addNewRPr() {
        CTTextCharacterProperties cTTextCharacterProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextCharacterProperties = (CTTextCharacterProperties) get_store().add_element_user(RPR$0);
        }
        return cTTextCharacterProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextLineBreak
    public CTTextCharacterProperties getRPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextCharacterProperties cTTextCharacterProperties = (CTTextCharacterProperties) get_store().find_element_user(RPR$0, 0);
            if (cTTextCharacterProperties == null) {
                return null;
            }
            return cTTextCharacterProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextLineBreak
    public boolean isSetRPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RPR$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextLineBreak
    public void setRPr(CTTextCharacterProperties cTTextCharacterProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RPR$0;
            CTTextCharacterProperties cTTextCharacterProperties2 = (CTTextCharacterProperties) typeStore.find_element_user(qName, 0);
            if (cTTextCharacterProperties2 == null) {
                cTTextCharacterProperties2 = (CTTextCharacterProperties) get_store().add_element_user(qName);
            }
            cTTextCharacterProperties2.set(cTTextCharacterProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextLineBreak
    public void unsetRPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RPR$0, 0);
        }
    }
}
