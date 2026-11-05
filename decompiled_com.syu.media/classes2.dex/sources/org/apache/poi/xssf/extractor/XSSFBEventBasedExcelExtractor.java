package org.apache.poi.xssf.extractor;

import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.extractor.ExcelExtractor;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.xssf.binary.XSSFBCommentsTable;
import org.apache.poi.xssf.binary.XSSFBHyperlinksTable;
import org.apache.poi.xssf.binary.XSSFBSharedStringsTable;
import org.apache.poi.xssf.binary.XSSFBSheetHandler;
import org.apache.poi.xssf.binary.XSSFBStylesTable;
import org.apache.poi.xssf.eventusermodel.XSSFBReader;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.XmlException;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFBEventBasedExcelExtractor extends XSSFEventBasedExcelExtractor implements ExcelExtractor {
    private static final POILogger LOGGER = POILogFactory.getLogger((Class<?>) XSSFBEventBasedExcelExtractor.class);
    public static final XSSFRelation[] SUPPORTED_TYPES = {XSSFRelation.XLSB_BINARY_WORKBOOK};
    private boolean handleHyperlinksInCells;

    public XSSFBEventBasedExcelExtractor(String str) throws XmlException, OpenXML4JException, IOException {
        super(str);
        this.handleHyperlinksInCells = false;
    }

    public XSSFBEventBasedExcelExtractor(OPCPackage oPCPackage) throws XmlException, OpenXML4JException, IOException {
        super(oPCPackage);
        this.handleHyperlinksInCells = false;
    }

    public static void main(String[] strArr) throws Exception {
        if (strArr.length < 1) {
            System.err.println("Use:");
            System.err.println("  XSSFBEventBasedExcelExtractor <filename.xlsb>");
            System.exit(1);
        }
        XSSFBEventBasedExcelExtractor xSSFBEventBasedExcelExtractor = new XSSFBEventBasedExcelExtractor(strArr[0]);
        System.out.println(xSSFBEventBasedExcelExtractor.getText());
        xSSFBEventBasedExcelExtractor.close();
    }

    public void setHandleHyperlinksInCells(boolean z) {
        this.handleHyperlinksInCells = z;
    }

    @Override // org.apache.poi.xssf.extractor.XSSFEventBasedExcelExtractor, org.apache.poi.ss.extractor.ExcelExtractor
    public void setFormulasNotResults(boolean z) {
        throw new IllegalArgumentException("Not currently supported");
    }

    public void processSheet(XSSFSheetXMLHandler.SheetContentsHandler sheetContentsHandler, XSSFBStylesTable xSSFBStylesTable, XSSFBCommentsTable xSSFBCommentsTable, XSSFBSharedStringsTable xSSFBSharedStringsTable, InputStream inputStream) throws SAXException, IOException {
        DataFormatter dataFormatter;
        if (getLocale() == null) {
            dataFormatter = new DataFormatter();
        } else {
            dataFormatter = new DataFormatter(getLocale());
        }
        new XSSFBSheetHandler(inputStream, xSSFBStylesTable, xSSFBCommentsTable, xSSFBSharedStringsTable, sheetContentsHandler, dataFormatter, getFormulasNotResults()).parse();
    }

    @Override // org.apache.poi.xssf.extractor.XSSFEventBasedExcelExtractor, org.apache.poi.POITextExtractor
    public String getText() {
        try {
            XSSFBSharedStringsTable xSSFBSharedStringsTable = new XSSFBSharedStringsTable(getPackage());
            XSSFBReader xSSFBReader = new XSSFBReader(getPackage());
            XSSFBStylesTable xSSFBStylesTable = xSSFBReader.getXSSFBStylesTable();
            XSSFBReader.SheetIterator sheetIterator = (XSSFBReader.SheetIterator) xSSFBReader.getSheetsData();
            StringBuffer stringBuffer = new StringBuffer();
            XSSFEventBasedExcelExtractor.SheetTextExtractor sheetTextExtractor = new XSSFEventBasedExcelExtractor.SheetTextExtractor();
            while (sheetIterator.hasNext()) {
                InputStream next = sheetIterator.next();
                if (getIncludeSheetNames()) {
                    stringBuffer.append(sheetIterator.getSheetName());
                    stringBuffer.append('\n');
                }
                if (this.handleHyperlinksInCells) {
                    new XSSFBHyperlinksTable(sheetIterator.getSheetPart());
                }
                processSheet(sheetTextExtractor, xSSFBStylesTable, getIncludeCellComments() ? sheetIterator.getXSSFBSheetComments() : null, xSSFBSharedStringsTable, next);
                if (getIncludeHeadersFooters()) {
                    sheetTextExtractor.appendHeaderText(stringBuffer);
                }
                sheetTextExtractor.appendCellText(stringBuffer);
                if (getIncludeTextBoxes()) {
                    processShapes(sheetIterator.getShapes(), stringBuffer);
                }
                if (getIncludeHeadersFooters()) {
                    sheetTextExtractor.appendFooterText(stringBuffer);
                }
                sheetTextExtractor.reset();
                next.close();
            }
            return stringBuffer.toString();
        } catch (IOException e) {
            LOGGER.log(5, e);
            return null;
        } catch (OpenXML4JException e2) {
            LOGGER.log(5, e2);
            return null;
        } catch (SAXException e3) {
            LOGGER.log(5, e3);
            return null;
        }
    }
}
