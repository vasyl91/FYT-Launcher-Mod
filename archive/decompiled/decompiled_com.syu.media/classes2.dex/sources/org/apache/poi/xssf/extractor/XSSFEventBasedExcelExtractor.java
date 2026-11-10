package org.apache.poi.xssf.extractor;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.poi.POIXMLProperties;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.extractor.ExcelExtractor;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.SAXHelper;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.model.CommentsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSimpleShape;
import org.apache.xmlbeans.XmlException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFEventBasedExcelExtractor extends POIXMLTextExtractor implements ExcelExtractor {
    private static final POILogger LOGGER = POILogFactory.getLogger((Class<?>) XSSFEventBasedExcelExtractor.class);
    private boolean concatenatePhoneticRuns;
    private OPCPackage container;
    private boolean formulasNotResults;
    private boolean includeCellComments;
    private boolean includeHeadersFooters;
    private boolean includeSheetNames;
    private boolean includeTextBoxes;
    private Locale locale;
    private POIXMLProperties properties;

    public XSSFEventBasedExcelExtractor(String str) throws XmlException, OpenXML4JException, IOException {
        this(OPCPackage.open(str));
    }

    public XSSFEventBasedExcelExtractor(OPCPackage oPCPackage) throws XmlException, OpenXML4JException, IOException {
        super(null);
        this.includeTextBoxes = true;
        this.includeSheetNames = true;
        this.includeCellComments = false;
        this.includeHeadersFooters = true;
        this.formulasNotResults = false;
        this.concatenatePhoneticRuns = true;
        this.container = oPCPackage;
        this.properties = new POIXMLProperties(oPCPackage);
    }

    public static void main(String[] strArr) throws Exception {
        if (strArr.length < 1) {
            System.err.println("Use:");
            System.err.println("  XSSFEventBasedExcelExtractor <filename.xlsx>");
            System.exit(1);
        }
        XSSFEventBasedExcelExtractor xSSFEventBasedExcelExtractor = new XSSFEventBasedExcelExtractor(strArr[0]);
        System.out.println(xSSFEventBasedExcelExtractor.getText());
        xSSFEventBasedExcelExtractor.close();
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setIncludeSheetNames(boolean z) {
        this.includeSheetNames = z;
    }

    public boolean getIncludeSheetNames() {
        return this.includeSheetNames;
    }

    public void setFormulasNotResults(boolean z) {
        this.formulasNotResults = z;
    }

    public boolean getFormulasNotResults() {
        return this.formulasNotResults;
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setIncludeHeadersFooters(boolean z) {
        this.includeHeadersFooters = z;
    }

    public boolean getIncludeHeadersFooters() {
        return this.includeHeadersFooters;
    }

    public void setIncludeTextBoxes(boolean z) {
        this.includeTextBoxes = z;
    }

    public boolean getIncludeTextBoxes() {
        return this.includeTextBoxes;
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setIncludeCellComments(boolean z) {
        this.includeCellComments = z;
    }

    public boolean getIncludeCellComments() {
        return this.includeCellComments;
    }

    public void setConcatenatePhoneticRuns(boolean z) {
        this.concatenatePhoneticRuns = z;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public Locale getLocale() {
        return this.locale;
    }

    @Override // org.apache.poi.POIXMLTextExtractor
    public OPCPackage getPackage() {
        return this.container;
    }

    @Override // org.apache.poi.POIXMLTextExtractor
    public POIXMLProperties.CoreProperties getCoreProperties() {
        return this.properties.getCoreProperties();
    }

    @Override // org.apache.poi.POIXMLTextExtractor
    public POIXMLProperties.ExtendedProperties getExtendedProperties() {
        return this.properties.getExtendedProperties();
    }

    @Override // org.apache.poi.POIXMLTextExtractor
    public POIXMLProperties.CustomProperties getCustomProperties() {
        return this.properties.getCustomProperties();
    }

    public void processSheet(XSSFSheetXMLHandler.SheetContentsHandler sheetContentsHandler, StylesTable stylesTable, CommentsTable commentsTable, ReadOnlySharedStringsTable readOnlySharedStringsTable, InputStream inputStream) throws SAXException, IOException {
        DataFormatter dataFormatter;
        if (this.locale == null) {
            dataFormatter = new DataFormatter();
        } else {
            dataFormatter = new DataFormatter(this.locale);
        }
        DataFormatter dataFormatter2 = dataFormatter;
        InputSource inputSource = new InputSource(inputStream);
        try {
            XMLReader xMLReaderNewXMLReader = SAXHelper.newXMLReader();
            xMLReaderNewXMLReader.setContentHandler(new XSSFSheetXMLHandler(stylesTable, commentsTable, readOnlySharedStringsTable, sheetContentsHandler, dataFormatter2, this.formulasNotResults));
            xMLReaderNewXMLReader.parse(inputSource);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException("SAX parser appears to be broken - " + e.getMessage());
        }
    }

    @Override // org.apache.poi.POITextExtractor
    public String getText() {
        try {
            ReadOnlySharedStringsTable readOnlySharedStringsTable = new ReadOnlySharedStringsTable(this.container, this.concatenatePhoneticRuns);
            XSSFReader xSSFReader = new XSSFReader(this.container);
            StylesTable stylesTable = xSSFReader.getStylesTable();
            XSSFReader.SheetIterator sheetIterator = (XSSFReader.SheetIterator) xSSFReader.getSheetsData();
            StringBuffer stringBuffer = new StringBuffer();
            SheetTextExtractor sheetTextExtractor = new SheetTextExtractor();
            while (sheetIterator.hasNext()) {
                InputStream next = sheetIterator.next();
                if (this.includeSheetNames) {
                    stringBuffer.append(sheetIterator.getSheetName());
                    stringBuffer.append('\n');
                }
                processSheet(sheetTextExtractor, stylesTable, this.includeCellComments ? sheetIterator.getSheetComments() : null, readOnlySharedStringsTable, next);
                if (this.includeHeadersFooters) {
                    sheetTextExtractor.appendHeaderText(stringBuffer);
                }
                sheetTextExtractor.appendCellText(stringBuffer);
                if (this.includeTextBoxes) {
                    processShapes(sheetIterator.getShapes(), stringBuffer);
                }
                if (this.includeHeadersFooters) {
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

    void processShapes(List<XSSFShape> list, StringBuffer stringBuffer) {
        String text;
        if (list == null) {
            return;
        }
        for (XSSFShape xSSFShape : list) {
            if ((xSSFShape instanceof XSSFSimpleShape) && (text = ((XSSFSimpleShape) xSSFShape).getText()) != null && text.length() > 0) {
                stringBuffer.append(text).append('\n');
            }
        }
    }

    @Override // org.apache.poi.POIXMLTextExtractor, org.apache.poi.POITextExtractor, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        OPCPackage oPCPackage = this.container;
        if (oPCPackage != null) {
            oPCPackage.close();
            this.container = null;
        }
        super.close();
    }

    protected class SheetTextExtractor implements XSSFSheetXMLHandler.SheetContentsHandler {
        private final Map<String, String> headerFooterMap;
        private final StringBuffer output = new StringBuffer();
        private boolean firstCellOfRow = true;

        protected SheetTextExtractor() {
            this.headerFooterMap = XSSFEventBasedExcelExtractor.this.includeHeadersFooters ? new HashMap() : null;
        }

        @Override // org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler
        public void startRow(int i) {
            this.firstCellOfRow = true;
        }

        @Override // org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler
        public void endRow(int i) {
            this.output.append('\n');
        }

        @Override // org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler
        public void cell(String str, String str2, XSSFComment xSSFComment) {
            if (this.firstCellOfRow) {
                this.firstCellOfRow = false;
            } else {
                this.output.append('\t');
            }
            if (str2 != null) {
                XSSFEventBasedExcelExtractor.this.checkMaxTextSize(this.output, str2);
                this.output.append(str2);
            }
            if (!XSSFEventBasedExcelExtractor.this.includeCellComments || xSSFComment == null) {
                return;
            }
            String strReplace = xSSFComment.getString().getString().replace('\n', ' ');
            this.output.append(str2 != null ? " Comment by " : "Comment by ");
            XSSFEventBasedExcelExtractor.this.checkMaxTextSize(this.output, strReplace);
            if (strReplace.startsWith(xSSFComment.getAuthor() + ": ")) {
                this.output.append(strReplace);
            } else {
                this.output.append(xSSFComment.getAuthor()).append(": ").append(strReplace);
            }
        }

        @Override // org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler
        public void headerFooter(String str, boolean z, String str2) {
            Map<String, String> map = this.headerFooterMap;
            if (map != null) {
                map.put(str2, str);
            }
        }

        private void appendHeaderFooterText(StringBuffer stringBuffer, String str) {
            String str2 = this.headerFooterMap.get(str);
            if (str2 == null || str2.length() <= 0) {
                return;
            }
            stringBuffer.append(handleHeaderFooterDelimiter(handleHeaderFooterDelimiter(handleHeaderFooterDelimiter(str2, "&L"), "&C"), "&R")).append('\n');
        }

        private String handleHeaderFooterDelimiter(String str, String str2) {
            int iIndexOf = str.indexOf(str2);
            if (iIndexOf == 0) {
                return str.substring(2);
            }
            return iIndexOf > 0 ? str.substring(0, iIndexOf) + "\t" + str.substring(iIndexOf + 2) : str;
        }

        void appendHeaderText(StringBuffer stringBuffer) {
            appendHeaderFooterText(stringBuffer, "firstHeader");
            appendHeaderFooterText(stringBuffer, "oddHeader");
            appendHeaderFooterText(stringBuffer, "evenHeader");
        }

        void appendFooterText(StringBuffer stringBuffer) {
            appendHeaderFooterText(stringBuffer, "firstFooter");
            appendHeaderFooterText(stringBuffer, "oddFooter");
            appendHeaderFooterText(stringBuffer, "evenFooter");
        }

        void appendCellText(StringBuffer stringBuffer) {
            XSSFEventBasedExcelExtractor.this.checkMaxTextSize(stringBuffer, this.output.toString());
            stringBuffer.append(this.output);
        }

        void reset() {
            this.output.setLength(0);
            this.firstCellOfRow = true;
            Map<String, String> map = this.headerFooterMap;
            if (map != null) {
                map.clear();
            }
        }
    }
}
