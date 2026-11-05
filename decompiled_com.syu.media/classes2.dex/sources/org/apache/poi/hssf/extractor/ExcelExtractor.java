package org.apache.poi.hssf.extractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Locale;
import org.apache.poi.POIOLE2TextExtractor;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HeaderFooter;
import org.apache.poi.ss.usermodel.Row;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ExcelExtractor extends POIOLE2TextExtractor implements org.apache.poi.ss.extractor.ExcelExtractor {
    private final HSSFDataFormatter _formatter;
    private boolean _includeBlankCells;
    private boolean _includeCellComments;
    private boolean _includeHeadersFooters;
    private boolean _includeSheetNames;
    private boolean _shouldEvaluateFormulas;
    private final HSSFWorkbook _wb;

    public ExcelExtractor(HSSFWorkbook hSSFWorkbook) {
        super(hSSFWorkbook);
        this._includeSheetNames = true;
        this._shouldEvaluateFormulas = true;
        this._includeCellComments = false;
        this._includeBlankCells = false;
        this._includeHeadersFooters = true;
        this._wb = hSSFWorkbook;
        this._formatter = new HSSFDataFormatter();
    }

    public ExcelExtractor(POIFSFileSystem pOIFSFileSystem) throws IOException {
        this(pOIFSFileSystem.getRoot());
    }

    public ExcelExtractor(DirectoryNode directoryNode) throws IOException {
        this(new HSSFWorkbook(directoryNode, true));
    }

    private static final class CommandParseException extends Exception {
        public CommandParseException(String str) {
            super(str);
        }
    }

    private static final class CommandArgs {
        private final boolean _evaluateFormulas;
        private final boolean _headersFooters;
        private final File _inputFile;
        private final boolean _requestHelp;
        private final boolean _showBlankCells;
        private final boolean _showCellComments;
        private final boolean _showSheetNames;

        public CommandArgs(String[] strArr) throws CommandParseException {
            int i;
            int length = strArr.length;
            File file = null;
            boolean z = false;
            int i2 = 0;
            boolean boolArg = false;
            boolean boolArg2 = false;
            boolean boolArg3 = true;
            boolean boolArg4 = true;
            boolean boolArg5 = true;
            while (i2 < length) {
                String str = strArr[i2];
                if ("-help".equalsIgnoreCase(str)) {
                    z = true;
                    break;
                }
                if ("-i".equals(str)) {
                    i = i2 + 1;
                    if (i >= length) {
                        throw new CommandParseException("Expected filename after '-i'");
                    }
                    String str2 = strArr[i];
                    if (file != null) {
                        throw new CommandParseException("Only one input file can be supplied");
                    }
                    file = new File(str2);
                    if (!file.exists()) {
                        throw new CommandParseException("Specified input file '" + str2 + "' does not exist");
                    }
                    if (file.isDirectory()) {
                        throw new CommandParseException("Specified input file '" + str2 + "' is a directory");
                    }
                } else if ("--show-sheet-names".equals(str)) {
                    i = i2 + 1;
                    boolArg3 = parseBoolArg(strArr, i);
                } else if ("--evaluate-formulas".equals(str)) {
                    i = i2 + 1;
                    boolArg4 = parseBoolArg(strArr, i);
                } else if ("--show-comments".equals(str)) {
                    i = i2 + 1;
                    boolArg = parseBoolArg(strArr, i);
                } else if ("--show-blanks".equals(str)) {
                    i = i2 + 1;
                    boolArg2 = parseBoolArg(strArr, i);
                } else if ("--headers-footers".equals(str)) {
                    i = i2 + 1;
                    boolArg5 = parseBoolArg(strArr, i);
                } else {
                    throw new CommandParseException("Invalid argument '" + str + "'");
                }
                i2 = i + 1;
            }
            this._requestHelp = z;
            this._inputFile = file;
            this._showSheetNames = boolArg3;
            this._evaluateFormulas = boolArg4;
            this._showCellComments = boolArg;
            this._showBlankCells = boolArg2;
            this._headersFooters = boolArg5;
        }

        private static boolean parseBoolArg(String[] strArr, int i) throws CommandParseException {
            if (i >= strArr.length) {
                throw new CommandParseException("Expected value after '" + strArr[i - 1] + "'");
            }
            String upperCase = strArr[i].toUpperCase(Locale.ROOT);
            if ("Y".equals(upperCase) || "YES".equals(upperCase) || "ON".equals(upperCase) || "TRUE".equals(upperCase)) {
                return true;
            }
            if ("N".equals(upperCase) || "NO".equals(upperCase) || "OFF".equals(upperCase) || "FALSE".equals(upperCase)) {
                return false;
            }
            throw new CommandParseException("Invalid value '" + strArr[i] + "' for '" + strArr[i - 1] + "'. Expected 'Y' or 'N'");
        }

        public boolean isRequestHelp() {
            return this._requestHelp;
        }

        public File getInputFile() {
            return this._inputFile;
        }

        public boolean shouldShowSheetNames() {
            return this._showSheetNames;
        }

        public boolean shouldEvaluateFormulas() {
            return this._evaluateFormulas;
        }

        public boolean shouldShowCellComments() {
            return this._showCellComments;
        }

        public boolean shouldShowBlankCells() {
            return this._showBlankCells;
        }

        public boolean shouldIncludeHeadersFooters() {
            return this._headersFooters;
        }
    }

    private static void printUsageMessage(PrintStream printStream) {
        printStream.println("Use:");
        printStream.println("    " + ExcelExtractor.class.getName() + " [<flag> <value> [<flag> <value> [...]]] [-i <filename.xls>]");
        printStream.println("       -i <filename.xls> specifies input file (default is to use stdin)");
        printStream.println("       Flags can be set on or off by using the values 'Y' or 'N'.");
        printStream.println("       Following are available flags and their default values:");
        printStream.println("       --show-sheet-names  Y");
        printStream.println("       --evaluate-formulas Y");
        printStream.println("       --show-comments     N");
        printStream.println("       --show-blanks       Y");
        printStream.println("       --headers-footers   Y");
    }

    public static void main(String[] strArr) throws IOException {
        InputStream fileInputStream;
        try {
            CommandArgs commandArgs = new CommandArgs(strArr);
            if (commandArgs.isRequestHelp()) {
                printUsageMessage(System.out);
                return;
            }
            if (commandArgs.getInputFile() == null) {
                fileInputStream = System.in;
            } else {
                fileInputStream = new FileInputStream(commandArgs.getInputFile());
            }
            HSSFWorkbook hSSFWorkbook = new HSSFWorkbook(fileInputStream);
            fileInputStream.close();
            ExcelExtractor excelExtractor = new ExcelExtractor(hSSFWorkbook);
            excelExtractor.setIncludeSheetNames(commandArgs.shouldShowSheetNames());
            excelExtractor.setFormulasNotResults(true ^ commandArgs.shouldEvaluateFormulas());
            excelExtractor.setIncludeCellComments(commandArgs.shouldShowCellComments());
            excelExtractor.setIncludeBlankCells(commandArgs.shouldShowBlankCells());
            excelExtractor.setIncludeHeadersFooters(commandArgs.shouldIncludeHeadersFooters());
            System.out.println(excelExtractor.getText());
            excelExtractor.close();
            hSSFWorkbook.close();
        } catch (CommandParseException e) {
            System.err.println(e.getMessage());
            printUsageMessage(System.err);
            System.exit(1);
        }
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setIncludeSheetNames(boolean z) {
        this._includeSheetNames = z;
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setFormulasNotResults(boolean z) {
        this._shouldEvaluateFormulas = !z;
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setIncludeCellComments(boolean z) {
        this._includeCellComments = z;
    }

    public void setIncludeBlankCells(boolean z) {
        this._includeBlankCells = z;
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setIncludeHeadersFooters(boolean z) {
        this._includeHeadersFooters = z;
    }

    @Override // org.apache.poi.POITextExtractor
    public String getText() {
        boolean z;
        String sheetName;
        StringBuffer stringBuffer = new StringBuffer();
        this._wb.setMissingCellPolicy(Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
        for (int i = 0; i < this._wb.getNumberOfSheets(); i++) {
            HSSFSheet sheetAt = this._wb.getSheetAt(i);
            if (sheetAt != null) {
                if (this._includeSheetNames && (sheetName = this._wb.getSheetName(i)) != null) {
                    stringBuffer.append(sheetName);
                    stringBuffer.append("\n");
                }
                if (this._includeHeadersFooters) {
                    stringBuffer.append(_extractHeaderFooter(sheetAt.getHeader()));
                }
                int lastRowNum = sheetAt.getLastRowNum();
                for (int firstRowNum = sheetAt.getFirstRowNum(); firstRowNum <= lastRowNum; firstRowNum++) {
                    HSSFRow row = sheetAt.getRow(firstRowNum);
                    if (row != null) {
                        int firstCellNum = row.getFirstCellNum();
                        short lastCellNum = row.getLastCellNum();
                        if (this._includeBlankCells) {
                            firstCellNum = 0;
                        }
                        while (firstCellNum < lastCellNum) {
                            HSSFCell cell = row.getCell(firstCellNum);
                            if (cell == null) {
                                z = this._includeBlankCells;
                            } else {
                                int i2 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cell.getCellTypeEnum().ordinal()];
                                if (i2 == 1) {
                                    stringBuffer.append(cell.getRichStringCellValue().getString());
                                } else if (i2 == 2) {
                                    stringBuffer.append(this._formatter.formatCellValue(cell));
                                } else if (i2 == 3) {
                                    stringBuffer.append(cell.getBooleanCellValue());
                                } else if (i2 == 4) {
                                    stringBuffer.append(ErrorEval.getText(cell.getErrorCellValue()));
                                } else if (i2 == 5) {
                                    if (!this._shouldEvaluateFormulas) {
                                        stringBuffer.append(cell.getCellFormula());
                                    } else {
                                        int i3 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cell.getCachedFormulaResultTypeEnum().ordinal()];
                                        if (i3 == 1) {
                                            HSSFRichTextString richStringCellValue = cell.getRichStringCellValue();
                                            if (richStringCellValue != null && richStringCellValue.length() > 0) {
                                                stringBuffer.append(richStringCellValue);
                                            }
                                        } else if (i3 == 2) {
                                            HSSFCellStyle cellStyle = cell.getCellStyle();
                                            stringBuffer.append(this._formatter.formatRawCellContents(cell.getNumericCellValue(), cellStyle.getDataFormat(), cellStyle.getDataFormatString()));
                                        } else if (i3 == 3) {
                                            stringBuffer.append(cell.getBooleanCellValue());
                                        } else if (i3 == 4) {
                                            stringBuffer.append(ErrorEval.getText(cell.getErrorCellValue()));
                                        } else {
                                            throw new IllegalStateException("Unexpected cell cached formula result type: " + cell.getCachedFormulaResultTypeEnum());
                                        }
                                    }
                                } else {
                                    throw new RuntimeException("Unexpected cell type (" + cell.getCellTypeEnum() + ")");
                                }
                                HSSFComment cellComment = cell.getCellComment();
                                if (this._includeCellComments && cellComment != null) {
                                    stringBuffer.append(" Comment by " + cellComment.getAuthor() + ": " + cellComment.getString().getString().replace('\n', ' '));
                                }
                                z = true;
                            }
                            if (z && firstCellNum < lastCellNum - 1) {
                                stringBuffer.append("\t");
                            }
                            firstCellNum++;
                        }
                        stringBuffer.append("\n");
                    }
                }
                if (this._includeHeadersFooters) {
                    stringBuffer.append(_extractHeaderFooter(sheetAt.getFooter()));
                }
            }
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: org.apache.poi.hssf.extractor.ExcelExtractor$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$CellType;

        static {
            int[] iArr = new int[CellType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$CellType = iArr;
            try {
                iArr[CellType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.NUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.FORMULA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static String _extractHeaderFooter(HeaderFooter headerFooter) {
        StringBuffer stringBuffer = new StringBuffer();
        if (headerFooter.getLeft() != null) {
            stringBuffer.append(headerFooter.getLeft());
        }
        if (headerFooter.getCenter() != null) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append("\t");
            }
            stringBuffer.append(headerFooter.getCenter());
        }
        if (headerFooter.getRight() != null) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append("\t");
            }
            stringBuffer.append(headerFooter.getRight());
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }
}
