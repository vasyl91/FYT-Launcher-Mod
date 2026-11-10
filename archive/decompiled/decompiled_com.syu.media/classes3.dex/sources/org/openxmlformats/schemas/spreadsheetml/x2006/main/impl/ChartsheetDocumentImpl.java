package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ChartsheetDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class ChartsheetDocumentImpl extends XmlComplexContentImpl implements ChartsheetDocument {
    private static final QName CHARTSHEET$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "chartsheet");

    public ChartsheetDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.ChartsheetDocument
    public CTChartsheet addNewChartsheet() {
        CTChartsheet cTChartsheet;
        synchronized (monitor()) {
            check_orphaned();
            cTChartsheet = (CTChartsheet) get_store().add_element_user(CHARTSHEET$0);
        }
        return cTChartsheet;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.ChartsheetDocument
    public CTChartsheet getChartsheet() {
        synchronized (monitor()) {
            check_orphaned();
            CTChartsheet cTChartsheet = (CTChartsheet) get_store().find_element_user(CHARTSHEET$0, 0);
            if (cTChartsheet == null) {
                return null;
            }
            return cTChartsheet;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.ChartsheetDocument
    public void setChartsheet(CTChartsheet cTChartsheet) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHARTSHEET$0;
            CTChartsheet cTChartsheet2 = (CTChartsheet) typeStore.find_element_user(qName, 0);
            if (cTChartsheet2 == null) {
                cTChartsheet2 = (CTChartsheet) get_store().add_element_user(qName);
            }
            cTChartsheet2.set(cTChartsheet);
        }
    }
}
