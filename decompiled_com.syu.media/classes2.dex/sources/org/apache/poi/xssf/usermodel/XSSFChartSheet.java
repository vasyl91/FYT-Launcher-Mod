package org.apache.poi.xssf.usermodel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.namespace.QName;
import org.apache.poi.POIXMLException;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTLegacyDrawing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ChartsheetDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFChartSheet extends XSSFSheet {
    private static final byte[] BLANK_WORKSHEET = blankWorksheet();
    protected CTChartsheet chartsheet;

    protected XSSFChartSheet(PackagePart packagePart) {
        super(packagePart);
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFSheet
    protected void read(InputStream inputStream) throws IOException {
        super.read(new ByteArrayInputStream(BLANK_WORKSHEET));
        try {
            this.chartsheet = ChartsheetDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getChartsheet();
        } catch (XmlException e) {
            throw new POIXMLException(e);
        }
    }

    public CTChartsheet getCTChartsheet() {
        return this.chartsheet;
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFSheet
    protected CTDrawing getCTDrawing() {
        return this.chartsheet.getDrawing();
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFSheet
    protected CTLegacyDrawing getCTLegacyDrawing() {
        return this.chartsheet.getLegacyDrawing();
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFSheet
    protected void write(OutputStream outputStream) throws IOException {
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTChartsheet.type.getName().getNamespaceURI(), "chartsheet"));
        this.chartsheet.save(outputStream, xmlOptions);
    }

    private static byte[] blankWorksheet() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new XSSFSheet().write(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
