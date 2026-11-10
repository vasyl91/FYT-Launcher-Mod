package org.apache.poi.xssf.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Vector;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.helpers.XSSFSingleXmlCell;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.SingleXmlCellsDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SingleXmlCells extends POIXMLDocumentPart {
    private CTSingleXmlCells singleXMLCells;

    public SingleXmlCells() {
        this.singleXMLCells = CTSingleXmlCells.Factory.newInstance();
    }

    public SingleXmlCells(PackagePart packagePart) throws IOException {
        super(packagePart);
        readFrom(packagePart.getInputStream());
    }

    public void readFrom(InputStream inputStream) throws IOException {
        try {
            this.singleXMLCells = SingleXmlCellsDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getSingleXmlCells();
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    public XSSFSheet getXSSFSheet() {
        return (XSSFSheet) getParent();
    }

    protected void writeTo(OutputStream outputStream) throws IOException {
        SingleXmlCellsDocument singleXmlCellsDocumentNewInstance = SingleXmlCellsDocument.Factory.newInstance();
        singleXmlCellsDocumentNewInstance.setSingleXmlCells(this.singleXMLCells);
        singleXmlCellsDocumentNewInstance.save(outputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        writeTo(outputStream);
        outputStream.close();
    }

    public CTSingleXmlCells getCTSingleXMLCells() {
        return this.singleXMLCells;
    }

    public List<XSSFSingleXmlCell> getAllSimpleXmlCell() {
        Vector vector = new Vector();
        for (CTSingleXmlCell cTSingleXmlCell : this.singleXMLCells.getSingleXmlCellArray()) {
            vector.add(new XSSFSingleXmlCell(cTSingleXmlCell, this));
        }
        return vector;
    }
}
