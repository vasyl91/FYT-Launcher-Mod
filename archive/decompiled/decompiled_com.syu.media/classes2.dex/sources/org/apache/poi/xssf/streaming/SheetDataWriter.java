package org.apache.poi.xssf.streaming;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaError;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.TempFile;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SheetDataWriter implements Closeable {
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) SheetDataWriter.class);
    private final File _fd;
    private int _lowestIndexOfFlushedRows;
    private int _numberLastFlushedRow;
    private int _numberOfCellsOfLastFlushedRow;
    private int _numberOfFlushedRows;
    private final Writer _out;
    private int _rownum;
    private SharedStringsTable _sharedStringSource;

    static boolean replaceWithQuestionMark(char c) {
        return c < ' ' || (65534 <= c && c <= 65535);
    }

    protected InputStream decorateInputStream(FileInputStream fileInputStream) throws IOException {
        return fileInputStream;
    }

    protected OutputStream decorateOutputStream(FileOutputStream fileOutputStream) throws IOException {
        return fileOutputStream;
    }

    public SheetDataWriter() throws IOException {
        this._numberLastFlushedRow = -1;
        File fileCreateTempFile = createTempFile();
        this._fd = fileCreateTempFile;
        this._out = createWriter(fileCreateTempFile);
    }

    public SheetDataWriter(SharedStringsTable sharedStringsTable) throws IOException {
        this();
        this._sharedStringSource = sharedStringsTable;
    }

    public File createTempFile() throws IOException {
        return TempFile.createTempFile("poi-sxssf-sheet", ".xml");
    }

    public Writer createWriter(File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            return new BufferedWriter(new OutputStreamWriter(decorateOutputStream(fileOutputStream), "UTF-8"));
        } catch (IOException e) {
            fileOutputStream.close();
            throw e;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this._out.flush();
        this._out.close();
    }

    protected File getTempFile() {
        return this._fd;
    }

    public InputStream getWorksheetXMLInputStream() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(getTempFile());
        try {
            return decorateInputStream(fileInputStream);
        } catch (IOException e) {
            fileInputStream.close();
            throw e;
        }
    }

    public int getNumberOfFlushedRows() {
        return this._numberOfFlushedRows;
    }

    public int getNumberOfCellsOfLastFlushedRow() {
        return this._numberOfCellsOfLastFlushedRow;
    }

    public int getLowestIndexOfFlushedRows() {
        return this._lowestIndexOfFlushedRows;
    }

    public int getLastFlushedRow() {
        return this._numberLastFlushedRow;
    }

    protected void finalize() throws Throwable {
        if (!this._fd.delete()) {
            logger.log(7, "Can't delete temporary encryption file: " + this._fd);
        }
        super.finalize();
    }

    public void writeRow(int i, SXSSFRow sXSSFRow) throws IOException {
        if (this._numberOfFlushedRows == 0) {
            this._lowestIndexOfFlushedRows = i;
        }
        this._numberLastFlushedRow = Math.max(i, this._numberLastFlushedRow);
        this._numberOfCellsOfLastFlushedRow = sXSSFRow.getLastCellNum();
        this._numberOfFlushedRows++;
        beginRow(i, sXSSFRow);
        Iterator<Cell> itAllCellsIterator = sXSSFRow.allCellsIterator();
        int i2 = 0;
        while (itAllCellsIterator.hasNext()) {
            writeCell(i2, itAllCellsIterator.next());
            i2++;
        }
        endRow();
    }

    void beginRow(int i, SXSSFRow sXSSFRow) throws IOException {
        this._out.write("<row");
        writeAttribute("r", Integer.toString(i + 1));
        if (sXSSFRow.hasCustomHeight()) {
            writeAttribute("customHeight", "true");
            writeAttribute("ht", Float.toString(sXSSFRow.getHeightInPoints()));
        }
        if (sXSSFRow.getZeroHeight()) {
            writeAttribute(CellUtil.HIDDEN, "true");
        }
        if (sXSSFRow.isFormatted()) {
            writeAttribute("s", Integer.toString(sXSSFRow.getRowStyleIndex()));
            writeAttribute("customFormat", "1");
        }
        if (sXSSFRow.getOutlineLevel() != 0) {
            writeAttribute("outlineLevel", Integer.toString(sXSSFRow.getOutlineLevel()));
        }
        if (sXSSFRow.getHidden() != null) {
            writeAttribute(CellUtil.HIDDEN, sXSSFRow.getHidden().booleanValue() ? "1" : "0");
        }
        if (sXSSFRow.getCollapsed() != null) {
            writeAttribute("collapsed", sXSSFRow.getCollapsed().booleanValue() ? "1" : "0");
        }
        this._out.write(">\n");
        this._rownum = i;
    }

    void endRow() throws IOException {
        this._out.write("</row>\n");
    }

    public void writeCell(int i, Cell cell) throws IOException {
        if (cell == null) {
            return;
        }
        String asString = new CellReference(this._rownum, i).formatAsString();
        this._out.write("<c");
        writeAttribute("r", asString);
        CellStyle cellStyle = cell.getCellStyle();
        if (cellStyle.getIndex() != 0) {
            writeAttribute("s", Integer.toString(cellStyle.getIndex() & 65535));
        }
        CellType cellTypeEnum = cell.getCellTypeEnum();
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellTypeEnum.ordinal()]) {
            case 1:
                writeAttribute("t", "n");
                this._out.write("><v>");
                this._out.write(Double.toString(cell.getNumericCellValue()));
                this._out.write("</v>");
                break;
            case 2:
                this._out.write(62);
                break;
            case 3:
                this._out.write("><f>");
                outputQuotedString(cell.getCellFormula());
                this._out.write("</f>");
                if (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cell.getCachedFormulaResultTypeEnum().ordinal()] == 1) {
                    double numericCellValue = cell.getNumericCellValue();
                    if (!Double.isNaN(numericCellValue)) {
                        this._out.write("<v>");
                        this._out.write(Double.toString(numericCellValue));
                        this._out.write("</v>");
                    }
                }
                break;
            case 4:
                if (this._sharedStringSource != null) {
                    int iAddEntry = this._sharedStringSource.addEntry(new XSSFRichTextString(cell.getStringCellValue()).getCTRst());
                    writeAttribute("t", STCellType.S.toString());
                    this._out.write("><v>");
                    this._out.write(String.valueOf(iAddEntry));
                    this._out.write("</v>");
                } else {
                    writeAttribute("t", "inlineStr");
                    this._out.write("><is><t");
                    if (hasLeadingTrailingSpaces(cell.getStringCellValue())) {
                        writeAttribute("xml:space", "preserve");
                    }
                    this._out.write(">");
                    outputQuotedString(cell.getStringCellValue());
                    this._out.write("</t></is>");
                }
                break;
            case 5:
                writeAttribute("t", "b");
                this._out.write("><v>");
                this._out.write(cell.getBooleanCellValue() ? "1" : "0");
                this._out.write("</v>");
                break;
            case 6:
                FormulaError formulaErrorForInt = FormulaError.forInt(cell.getErrorCellValue());
                writeAttribute("t", "e");
                this._out.write("><v>");
                this._out.write(formulaErrorForInt.getString());
                this._out.write("</v>");
                break;
            default:
                throw new IllegalStateException("Invalid cell type: " + cellTypeEnum);
        }
        this._out.write("</c>");
    }

    /* JADX INFO: renamed from: org.apache.poi.xssf.streaming.SheetDataWriter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$CellType;

        static {
            int[] iArr = new int[CellType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$CellType = iArr;
            try {
                iArr[CellType.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BLANK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.FORMULA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.STRING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private void writeAttribute(String str, String str2) throws IOException {
        this._out.write(32);
        this._out.write(str);
        this._out.write("=\"");
        this._out.write(str2);
        this._out.write(34);
    }

    boolean hasLeadingTrailingSpaces(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return Character.isWhitespace(str.charAt(0)) || Character.isWhitespace(str.charAt(str.length() - 1));
    }

    protected void outputQuotedString(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return;
        }
        char[] charArray = str.toCharArray();
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char c = charArray[i2];
            if (c == '\t') {
                writeLastChars(this._out, charArray, i, i2);
                this._out.write("&#x9;");
            } else if (c == '\n') {
                writeLastChars(this._out, charArray, i, i2);
                this._out.write("&#xa;");
            } else if (c != '\r') {
                if (c == '\"') {
                    writeLastChars(this._out, charArray, i, i2);
                    i = i2 + 1;
                    this._out.write("&quot;");
                } else if (c == '&') {
                    writeLastChars(this._out, charArray, i, i2);
                    i = i2 + 1;
                    this._out.write("&amp;");
                } else if (c == '<') {
                    writeLastChars(this._out, charArray, i, i2);
                    i = i2 + 1;
                    this._out.write("&lt;");
                } else if (c == '>') {
                    writeLastChars(this._out, charArray, i, i2);
                    i = i2 + 1;
                    this._out.write("&gt;");
                } else if (c == 160) {
                    writeLastChars(this._out, charArray, i, i2);
                    this._out.write("&#xa0;");
                } else if (replaceWithQuestionMark(c)) {
                    writeLastChars(this._out, charArray, i, i2);
                    this._out.write(63);
                } else if (Character.isHighSurrogate(c) || Character.isLowSurrogate(c)) {
                    writeLastChars(this._out, charArray, i, i2);
                    this._out.write(c);
                } else if (c > 127) {
                    writeLastChars(this._out, charArray, i, i2);
                    i = i2 + 1;
                    this._out.write("&#");
                    this._out.write(String.valueOf((int) c));
                    this._out.write(";");
                }
            } else {
                writeLastChars(this._out, charArray, i, i2);
                this._out.write("&#xd;");
            }
            i = i2 + 1;
        }
        if (i < length) {
            this._out.write(charArray, i, length - i);
        }
    }

    private static void writeLastChars(Writer writer, char[] cArr, int i, int i2) throws IOException {
        if (i2 > i) {
            writer.write(cArr, i, i2 - i);
        }
    }

    boolean dispose() throws IOException {
        try {
            this._out.close();
            return this._fd.delete();
        } catch (Throwable th) {
            this._fd.delete();
            throw th;
        }
    }
}
