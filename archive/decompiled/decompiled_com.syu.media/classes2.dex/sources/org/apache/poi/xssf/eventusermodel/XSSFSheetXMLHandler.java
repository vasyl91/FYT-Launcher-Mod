package org.apache.poi.xssf.eventusermodel;

import java.util.LinkedList;
import java.util.Queue;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.xssf.model.CommentsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFSheetXMLHandler extends DefaultHandler {
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) XSSFSheetXMLHandler.class);
    private String cellRef;
    private Queue<CellAddress> commentCellRefs;
    private CommentsTable commentsTable;
    private boolean fIsOpen;
    private short formatIndex;
    private String formatString;
    private final DataFormatter formatter;
    private StringBuffer formula;
    private boolean formulasNotResults;
    private StringBuffer headerFooter;
    private boolean hfIsOpen;
    private boolean isIsOpen;
    private xssfDataType nextDataType;
    private int nextRowNum;
    private final SheetContentsHandler output;
    private int rowNum;
    private ReadOnlySharedStringsTable sharedStringsTable;
    private StylesTable stylesTable;
    private boolean vIsOpen;
    private StringBuffer value;

    private enum EmptyCellCommentsCheckType {
        CELL,
        END_OF_ROW,
        END_OF_SHEET_DATA
    }

    public interface SheetContentsHandler {
        void cell(String str, String str2, XSSFComment xSSFComment);

        void endRow(int i);

        void headerFooter(String str, boolean z, String str2);

        void startRow(int i);
    }

    enum xssfDataType {
        BOOLEAN,
        ERROR,
        FORMULA,
        INLINE_STRING,
        SST_STRING,
        NUMBER
    }

    public XSSFSheetXMLHandler(StylesTable stylesTable, CommentsTable commentsTable, ReadOnlySharedStringsTable readOnlySharedStringsTable, SheetContentsHandler sheetContentsHandler, DataFormatter dataFormatter, boolean z) {
        this.value = new StringBuffer();
        this.formula = new StringBuffer();
        this.headerFooter = new StringBuffer();
        this.stylesTable = stylesTable;
        this.commentsTable = commentsTable;
        this.sharedStringsTable = readOnlySharedStringsTable;
        this.output = sheetContentsHandler;
        this.formulasNotResults = z;
        this.nextDataType = xssfDataType.NUMBER;
        this.formatter = dataFormatter;
        init();
    }

    public XSSFSheetXMLHandler(StylesTable stylesTable, ReadOnlySharedStringsTable readOnlySharedStringsTable, SheetContentsHandler sheetContentsHandler, DataFormatter dataFormatter, boolean z) {
        this(stylesTable, null, readOnlySharedStringsTable, sheetContentsHandler, dataFormatter, z);
    }

    public XSSFSheetXMLHandler(StylesTable stylesTable, ReadOnlySharedStringsTable readOnlySharedStringsTable, SheetContentsHandler sheetContentsHandler, boolean z) {
        this(stylesTable, readOnlySharedStringsTable, sheetContentsHandler, new DataFormatter(), z);
    }

    private void init() {
        if (this.commentsTable != null) {
            this.commentCellRefs = new LinkedList();
            for (CTComment cTComment : this.commentsTable.getCTComments().getCommentList().getCommentArray()) {
                this.commentCellRefs.add(new CellAddress(cTComment.getRef()));
            }
        }
    }

    private boolean isTextTag(String str) {
        if ("v".equals(str) || "inlineStr".equals(str)) {
            return true;
        }
        return "t".equals(str) && this.isIsOpen;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        if (str == null || str.equals(XSSFRelation.NS_SPREADSHEETML)) {
            if (isTextTag(str2)) {
                this.vIsOpen = true;
                this.value.setLength(0);
                return;
            }
            if ("is".equals(str2)) {
                this.isIsOpen = true;
                return;
            }
            if ("f".equals(str2)) {
                this.formula.setLength(0);
                if (this.nextDataType == xssfDataType.NUMBER) {
                    this.nextDataType = xssfDataType.FORMULA;
                }
                String value = attributes.getValue("t");
                if (value != null && value.equals("shared")) {
                    String value2 = attributes.getValue("ref");
                    attributes.getValue("si");
                    if (value2 != null) {
                        this.fIsOpen = true;
                        return;
                    } else {
                        if (this.formulasNotResults) {
                            logger.log(5, "shared formulas not yet supported!");
                            return;
                        }
                        return;
                    }
                }
                this.fIsOpen = true;
                return;
            }
            if ("oddHeader".equals(str2) || "evenHeader".equals(str2) || "firstHeader".equals(str2) || "firstFooter".equals(str2) || "oddFooter".equals(str2) || "evenFooter".equals(str2)) {
                this.hfIsOpen = true;
                this.headerFooter.setLength(0);
                return;
            }
            if ("row".equals(str2)) {
                String value3 = attributes.getValue("r");
                if (value3 != null) {
                    this.rowNum = Integer.parseInt(value3) - 1;
                } else {
                    this.rowNum = this.nextRowNum;
                }
                this.output.startRow(this.rowNum);
                return;
            }
            if ("c".equals(str2)) {
                this.nextDataType = xssfDataType.NUMBER;
                this.formatIndex = (short) -1;
                XSSFCellStyle styleAt = null;
                this.formatString = null;
                this.cellRef = attributes.getValue("r");
                String value4 = attributes.getValue("t");
                String value5 = attributes.getValue("s");
                if ("b".equals(value4)) {
                    this.nextDataType = xssfDataType.BOOLEAN;
                    return;
                }
                if ("e".equals(value4)) {
                    this.nextDataType = xssfDataType.ERROR;
                    return;
                }
                if ("inlineStr".equals(value4)) {
                    this.nextDataType = xssfDataType.INLINE_STRING;
                    return;
                }
                if ("s".equals(value4)) {
                    this.nextDataType = xssfDataType.SST_STRING;
                    return;
                }
                if ("str".equals(value4)) {
                    this.nextDataType = xssfDataType.FORMULA;
                    return;
                }
                StylesTable stylesTable = this.stylesTable;
                if (stylesTable != null) {
                    if (value5 != null) {
                        styleAt = this.stylesTable.getStyleAt(Integer.parseInt(value5));
                    } else if (stylesTable.getNumCellStyles() > 0) {
                        styleAt = this.stylesTable.getStyleAt(0);
                    }
                }
                if (styleAt != null) {
                    this.formatIndex = styleAt.getDataFormat();
                    String dataFormatString = styleAt.getDataFormatString();
                    this.formatString = dataFormatString;
                    if (dataFormatString == null) {
                        this.formatString = BuiltinFormats.getBuiltinFormat(this.formatIndex);
                    }
                }
            }
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        String string;
        if (str == null || str.equals(XSSFRelation.NS_SPREADSHEETML)) {
            if (isTextTag(str2)) {
                this.vIsOpen = false;
                switch (AnonymousClass1.$SwitchMap$org$apache$poi$xssf$eventusermodel$XSSFSheetXMLHandler$xssfDataType[this.nextDataType.ordinal()]) {
                    case 1:
                        string = this.value.charAt(0) != '0' ? "TRUE" : "FALSE";
                        break;
                    case 2:
                        string = "ERROR:" + ((Object) this.value);
                        break;
                    case 3:
                        if (this.formulasNotResults) {
                            string = this.formula.toString();
                        } else {
                            string = this.value.toString();
                            if (this.formatString != null) {
                                try {
                                    string = this.formatter.formatRawCellContents(Double.parseDouble(string), this.formatIndex, this.formatString);
                                } catch (NumberFormatException unused) {
                                }
                            }
                        }
                        break;
                    case 4:
                        string = new XSSFRichTextString(this.value.toString()).toString();
                        break;
                    case 5:
                        String string2 = this.value.toString();
                        try {
                            string = new XSSFRichTextString(this.sharedStringsTable.getEntryAt(Integer.parseInt(string2))).toString();
                        } catch (NumberFormatException e) {
                            logger.log(7, "Failed to parse SST index '" + string2, e);
                            string = null;
                        }
                        break;
                    case 6:
                        string = this.value.toString();
                        if (this.formatString != null && string.length() > 0) {
                            string = this.formatter.formatRawCellContents(Double.parseDouble(string), this.formatIndex, this.formatString);
                        }
                        break;
                    default:
                        string = "(TODO: Unexpected type: " + this.nextDataType + ")";
                        break;
                }
                checkForEmptyCellComments(EmptyCellCommentsCheckType.CELL);
                CommentsTable commentsTable = this.commentsTable;
                this.output.cell(this.cellRef, string, commentsTable != null ? commentsTable.findCellComment(new CellAddress(this.cellRef)) : null);
                return;
            }
            if ("f".equals(str2)) {
                this.fIsOpen = false;
                return;
            }
            if ("is".equals(str2)) {
                this.isIsOpen = false;
                return;
            }
            if ("row".equals(str2)) {
                checkForEmptyCellComments(EmptyCellCommentsCheckType.END_OF_ROW);
                this.output.endRow(this.rowNum);
                this.nextRowNum = this.rowNum + 1;
                return;
            }
            if ("sheetData".equals(str2)) {
                checkForEmptyCellComments(EmptyCellCommentsCheckType.END_OF_SHEET_DATA);
                return;
            }
            if ("oddHeader".equals(str2) || "evenHeader".equals(str2) || "firstHeader".equals(str2)) {
                this.hfIsOpen = false;
                this.output.headerFooter(this.headerFooter.toString(), true, str2);
            } else if ("oddFooter".equals(str2) || "evenFooter".equals(str2) || "firstFooter".equals(str2)) {
                this.hfIsOpen = false;
                this.output.headerFooter(this.headerFooter.toString(), false, str2);
            }
        }
    }

    /* JADX INFO: renamed from: org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xssf$eventusermodel$XSSFSheetXMLHandler$xssfDataType;

        static {
            int[] iArr = new int[xssfDataType.values().length];
            $SwitchMap$org$apache$poi$xssf$eventusermodel$XSSFSheetXMLHandler$xssfDataType = iArr;
            try {
                iArr[xssfDataType.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$eventusermodel$XSSFSheetXMLHandler$xssfDataType[xssfDataType.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$eventusermodel$XSSFSheetXMLHandler$xssfDataType[xssfDataType.FORMULA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$eventusermodel$XSSFSheetXMLHandler$xssfDataType[xssfDataType.INLINE_STRING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$eventusermodel$XSSFSheetXMLHandler$xssfDataType[xssfDataType.SST_STRING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$eventusermodel$XSSFSheetXMLHandler$xssfDataType[xssfDataType.NUMBER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) throws SAXException {
        if (this.vIsOpen) {
            this.value.append(cArr, i, i2);
        }
        if (this.fIsOpen) {
            this.formula.append(cArr, i, i2);
        }
        if (this.hfIsOpen) {
            this.headerFooter.append(cArr, i, i2);
        }
    }

    private void checkForEmptyCellComments(EmptyCellCommentsCheckType emptyCellCommentsCheckType) {
        CellAddress cellAddressRemove;
        Queue<CellAddress> queue = this.commentCellRefs;
        if (queue == null || queue.isEmpty()) {
            return;
        }
        if (emptyCellCommentsCheckType == EmptyCellCommentsCheckType.END_OF_SHEET_DATA) {
            while (!this.commentCellRefs.isEmpty()) {
                outputEmptyCellComment(this.commentCellRefs.remove());
            }
            return;
        }
        if (this.cellRef == null) {
            if (emptyCellCommentsCheckType == EmptyCellCommentsCheckType.END_OF_ROW) {
                while (!this.commentCellRefs.isEmpty() && this.commentCellRefs.peek().getRow() == this.rowNum) {
                    outputEmptyCellComment(this.commentCellRefs.remove());
                }
                return;
            }
            throw new IllegalStateException("Cell ref should be null only if there are only empty cells in the row; rowNum: " + this.rowNum);
        }
        do {
            CellAddress cellAddress = new CellAddress(this.cellRef);
            CellAddress cellAddressPeek = this.commentCellRefs.peek();
            if (emptyCellCommentsCheckType == EmptyCellCommentsCheckType.CELL && cellAddress.equals(cellAddressPeek)) {
                this.commentCellRefs.remove();
                return;
            }
            int iCompareTo = cellAddressPeek.compareTo(cellAddress);
            if (iCompareTo > 0 && emptyCellCommentsCheckType == EmptyCellCommentsCheckType.END_OF_ROW && cellAddressPeek.getRow() <= this.rowNum) {
                cellAddressRemove = this.commentCellRefs.remove();
                outputEmptyCellComment(cellAddressRemove);
            } else if (iCompareTo >= 0 || emptyCellCommentsCheckType != EmptyCellCommentsCheckType.CELL || cellAddressPeek.getRow() > this.rowNum) {
                cellAddressRemove = null;
            } else {
                cellAddressRemove = this.commentCellRefs.remove();
                outputEmptyCellComment(cellAddressRemove);
            }
            if (cellAddressRemove == null) {
                return;
            }
        } while (!this.commentCellRefs.isEmpty());
    }

    private void outputEmptyCellComment(CellAddress cellAddress) {
        this.output.cell(cellAddress.formatAsString(), null, this.commentsTable.findCellComment(cellAddress));
    }
}
