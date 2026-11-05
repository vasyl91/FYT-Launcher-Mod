package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChartSpace;
import org.openxmlformats.schemas.drawingml.x2006.chart.ChartSpaceDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class ChartSpaceDocumentImpl extends XmlComplexContentImpl implements ChartSpaceDocument {
    private static final QName CHARTSPACE$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "chartSpace");

    public ChartSpaceDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.ChartSpaceDocument
    public CTChartSpace addNewChartSpace() {
        CTChartSpace cTChartSpace;
        synchronized (monitor()) {
            check_orphaned();
            cTChartSpace = (CTChartSpace) get_store().add_element_user(CHARTSPACE$0);
        }
        return cTChartSpace;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.ChartSpaceDocument
    public CTChartSpace getChartSpace() {
        synchronized (monitor()) {
            check_orphaned();
            CTChartSpace cTChartSpace = (CTChartSpace) get_store().find_element_user(CHARTSPACE$0, 0);
            if (cTChartSpace == null) {
                return null;
            }
            return cTChartSpace;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.ChartSpaceDocument
    public void setChartSpace(CTChartSpace cTChartSpace) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHARTSPACE$0;
            CTChartSpace cTChartSpace2 = (CTChartSpace) typeStore.find_element_user(qName, 0);
            if (cTChartSpace2 == null) {
                cTChartSpace2 = (CTChartSpace) get_store().add_element_user(qName);
            }
            cTChartSpace2.set(cTChartSpace);
        }
    }
}
