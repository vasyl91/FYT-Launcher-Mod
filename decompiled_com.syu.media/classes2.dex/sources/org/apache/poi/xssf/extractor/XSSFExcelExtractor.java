package org.apache.poi.xssf.extractor;

import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.extractor.ExcelExtractor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.HeaderFooter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFSimpleShape;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.XmlException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFExcelExtractor extends POIXMLTextExtractor implements ExcelExtractor {
    public static final XSSFRelation[] SUPPORTED_TYPES = {XSSFRelation.WORKBOOK, XSSFRelation.MACRO_TEMPLATE_WORKBOOK, XSSFRelation.MACRO_ADDIN_WORKBOOK, XSSFRelation.TEMPLATE_WORKBOOK, XSSFRelation.MACROS_WORKBOOK};
    private boolean formulasNotResults;
    private boolean includeCellComments;
    private boolean includeHeadersFooters;
    private boolean includeSheetNames;
    private boolean includeTextBoxes;
    private Locale locale;
    private XSSFWorkbook workbook;

    public XSSFExcelExtractor(OPCPackage oPCPackage) throws XmlException, OpenXML4JException, IOException {
        this(new XSSFWorkbook(oPCPackage));
    }

    public XSSFExcelExtractor(XSSFWorkbook xSSFWorkbook) {
        super(xSSFWorkbook);
        this.includeSheetNames = true;
        this.includeHeadersFooters = true;
        this.includeTextBoxes = true;
        this.workbook = xSSFWorkbook;
    }

    public static void main(String[] strArr) throws Exception {
        if (strArr.length < 1) {
            System.err.println("Use:");
            System.err.println("  XSSFExcelExtractor <filename.xlsx>");
            System.exit(1);
        }
        XSSFExcelExtractor xSSFExcelExtractor = new XSSFExcelExtractor(OPCPackage.create(strArr[0]));
        try {
            System.out.println(xSSFExcelExtractor.getText());
        } finally {
            xSSFExcelExtractor.close();
        }
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setIncludeSheetNames(boolean z) {
        this.includeSheetNames = z;
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setFormulasNotResults(boolean z) {
        this.formulasNotResults = z;
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setIncludeCellComments(boolean z) {
        this.includeCellComments = z;
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setIncludeHeadersFooters(boolean z) {
        this.includeHeadersFooters = z;
    }

    public void setIncludeTextBoxes(boolean z) {
        this.includeTextBoxes = z;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override // org.apache.poi.POITextExtractor
    public String getText() {
        DataFormatter dataFormatter;
        XSSFDrawing drawingPatriarch;
        if (this.locale == null) {
            dataFormatter = new DataFormatter();
        } else {
            dataFormatter = new DataFormatter(this.locale);
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (XSSFSheet xSSFSheet : this.workbook) {
            if (this.includeSheetNames) {
                stringBuffer.append(xSSFSheet.getSheetName()).append("\n");
            }
            if (this.includeHeadersFooters) {
                stringBuffer.append(extractHeaderFooter(xSSFSheet.getFirstHeader()));
                stringBuffer.append(extractHeaderFooter(xSSFSheet.getOddHeader()));
                stringBuffer.append(extractHeaderFooter(xSSFSheet.getEvenHeader()));
            }
            Iterator<Row> it = xSSFSheet.iterator();
            while (it.hasNext()) {
                Iterator<Cell> itCellIterator = it.next().cellIterator();
                while (itCellIterator.hasNext()) {
                    Cell next = itCellIterator.next();
                    if (next.getCellTypeEnum() == CellType.FORMULA) {
                        if (this.formulasNotResults) {
                            String cellFormula = next.getCellFormula();
                            checkMaxTextSize(stringBuffer, cellFormula);
                            stringBuffer.append(cellFormula);
                        } else if (next.getCachedFormulaResultTypeEnum() == CellType.STRING) {
                            handleStringCell(stringBuffer, next);
                        } else {
                            handleNonStringCell(stringBuffer, next, dataFormatter);
                        }
                    } else if (next.getCellTypeEnum() == CellType.STRING) {
                        handleStringCell(stringBuffer, next);
                    } else {
                        handleNonStringCell(stringBuffer, next, dataFormatter);
                    }
                    Comment cellComment = next.getCellComment();
                    if (this.includeCellComments && cellComment != null) {
                        String strReplace = cellComment.getString().getString().replace('\n', ' ');
                        checkMaxTextSize(stringBuffer, strReplace);
                        stringBuffer.append(" Comment by ").append(cellComment.getAuthor()).append(": ").append(strReplace);
                    }
                    if (itCellIterator.hasNext()) {
                        stringBuffer.append("\t");
                    }
                }
                stringBuffer.append("\n");
            }
            if (this.includeTextBoxes && (drawingPatriarch = xSSFSheet.getDrawingPatriarch()) != null) {
                for (XSSFShape xSSFShape : drawingPatriarch.getShapes()) {
                    if (xSSFShape instanceof XSSFSimpleShape) {
                        String text = ((XSSFSimpleShape) xSSFShape).getText();
                        if (text.length() > 0) {
                            stringBuffer.append(text);
                            stringBuffer.append('\n');
                        }
                    }
                }
            }
            if (this.includeHeadersFooters) {
                stringBuffer.append(extractHeaderFooter(xSSFSheet.getFirstFooter()));
                stringBuffer.append(extractHeaderFooter(xSSFSheet.getOddFooter()));
                stringBuffer.append(extractHeaderFooter(xSSFSheet.getEvenFooter()));
            }
        }
        return stringBuffer.toString();
    }

    private void handleStringCell(StringBuffer stringBuffer, Cell cell) {
        String string = cell.getRichStringCellValue().getString();
        checkMaxTextSize(stringBuffer, string);
        stringBuffer.append(string);
    }

    private void handleNonStringCell(StringBuffer stringBuffer, Cell cell, DataFormatter dataFormatter) {
        CellStyle cellStyle;
        CellType cellTypeEnum = cell.getCellTypeEnum();
        if (cellTypeEnum == CellType.FORMULA) {
            cellTypeEnum = cell.getCachedFormulaResultTypeEnum();
        }
        if (cellTypeEnum == CellType.NUMERIC && (cellStyle = cell.getCellStyle()) != null && cellStyle.getDataFormatString() != null) {
            String rawCellContents = dataFormatter.formatRawCellContents(cell.getNumericCellValue(), cellStyle.getDataFormat(), cellStyle.getDataFormatString());
            checkMaxTextSize(stringBuffer, rawCellContents);
            stringBuffer.append(rawCellContents);
        } else {
            String rawValue = ((XSSFCell) cell).getRawValue();
            if (rawValue != null) {
                checkMaxTextSize(stringBuffer, rawValue);
                stringBuffer.append(rawValue);
            }
        }
    }

    private String extractHeaderFooter(HeaderFooter headerFooter) {
        return org.apache.poi.hssf.extractor.ExcelExtractor._extractHeaderFooter(headerFooter);
    }
}
