package org.apache.poi.xssf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCache;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFPivotCache extends POIXMLDocumentPart {
    private CTPivotCache ctPivotCache;

    public XSSFPivotCache() {
        this.ctPivotCache = CTPivotCache.Factory.newInstance();
    }

    public XSSFPivotCache(CTPivotCache cTPivotCache) {
        this.ctPivotCache = cTPivotCache;
    }

    protected XSSFPivotCache(PackagePart packagePart) throws IOException {
        super(packagePart);
        readFrom(packagePart.getInputStream());
    }

    protected void readFrom(InputStream inputStream) throws IOException {
        try {
            XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
            xmlOptions.setLoadReplaceDocumentElement(null);
            this.ctPivotCache = CTPivotCache.Factory.parse(inputStream, xmlOptions);
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    public CTPivotCache getCTPivotCache() {
        return this.ctPivotCache;
    }
}
