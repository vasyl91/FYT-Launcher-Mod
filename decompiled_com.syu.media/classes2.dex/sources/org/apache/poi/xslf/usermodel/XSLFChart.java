package org.apache.poi.xslf.usermodel;

import java.io.IOException;
import java.io.OutputStream;
import javax.xml.namespace.QName;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChartSpace;
import org.openxmlformats.schemas.drawingml.x2006.chart.ChartSpaceDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class XSLFChart extends POIXMLDocumentPart {
    private CTChart chart;
    private CTChartSpace chartSpace;

    protected XSLFChart(PackagePart packagePart) throws XmlException, IOException {
        super(packagePart);
        CTChartSpace chartSpace = ChartSpaceDocument.Factory.parse(packagePart.getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getChartSpace();
        this.chartSpace = chartSpace;
        this.chart = chartSpace.getChart();
    }

    @Internal
    public CTChartSpace getCTChartSpace() {
        return this.chartSpace;
    }

    @Internal
    public CTChart getCTChart() {
        return this.chart;
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTChartSpace.type.getName().getNamespaceURI(), "chartSpace", "c"));
        OutputStream outputStream = getPackagePart().getOutputStream();
        this.chartSpace.save(outputStream, xmlOptions);
        outputStream.close();
    }
}
