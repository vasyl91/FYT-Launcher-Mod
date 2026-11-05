package org.apache.poi.xssf.binary;

import java.io.InputStream;
import java.util.Queue;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public class XSSFBSheetHandler extends XSSFBParser {
    private static final int CHECK_ALL_ROWS = -1;
    private final XSSFBCellHeader cellBuffer;
    private final XSSFBCommentsTable comments;
    private int currentRow;
    private final DataFormatter dataFormatter;
    private final boolean formulasNotResults;
    private final XSSFSheetXMLHandler.SheetContentsHandler handler;
    private XSSFBCellRange hyperlinkCellRange;
    private int lastEndedRow;
    private int lastStartedRow;
    private byte[] rkBuffer;
    private final XSSFBSharedStringsTable stringsTable;
    private final XSSFBStylesTable styles;
    private StringBuilder xlWideStringBuffer;

    public interface SheetContentsHandler extends XSSFSheetXMLHandler.SheetContentsHandler {
        void hyperlinkCell(String str, String str2, String str3, String str4, XSSFComment xSSFComment);
    }

    public XSSFBSheetHandler(InputStream inputStream, XSSFBStylesTable xSSFBStylesTable, XSSFBCommentsTable xSSFBCommentsTable, XSSFBSharedStringsTable xSSFBSharedStringsTable, XSSFSheetXMLHandler.SheetContentsHandler sheetContentsHandler, DataFormatter dataFormatter, boolean z) {
        super(inputStream);
        this.lastEndedRow = -1;
        this.lastStartedRow = -1;
        this.currentRow = 0;
        this.rkBuffer = new byte[8];
        this.hyperlinkCellRange = null;
        this.xlWideStringBuffer = new StringBuilder();
        this.cellBuffer = new XSSFBCellHeader();
        this.styles = xSSFBStylesTable;
        this.comments = xSSFBCommentsTable;
        this.stringsTable = xSSFBSharedStringsTable;
        this.handler = sheetContentsHandler;
        this.dataFormatter = dataFormatter;
        this.formulasNotResults = z;
    }

    @Override // org.apache.poi.xssf.binary.XSSFBParser
    public void handleRecord(int i, byte[] bArr) throws XSSFBParseException {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.lookup(i).ordinal()]) {
            case 1:
                int iCastToInt = XSSFBUtils.castToInt(LittleEndian.getUInt(bArr, 0));
                if (iCastToInt > 1048576) {
                    throw new XSSFBParseException("Row number beyond allowable range: " + iCastToInt);
                }
                this.currentRow = iCastToInt;
                checkMissedComments(iCastToInt);
                startRow(this.currentRow);
                return;
            case 2:
                handleBrtCellIsst(bArr);
                return;
            case 3:
                handleCellSt(bArr);
                return;
            case 4:
                handleCellRk(bArr);
                return;
            case 5:
                handleCellReal(bArr);
                return;
            case 6:
                handleBoolean(bArr);
                return;
            case 7:
                handleCellError(bArr);
                return;
            case 8:
                beforeCellValue(bArr);
                return;
            case 9:
                handleFmlaString(bArr);
                return;
            case 10:
                handleFmlaNum(bArr);
                return;
            case 11:
                handleFmlaError(bArr);
                return;
            case 12:
                checkMissedComments(-1);
                endRow(this.lastStartedRow);
                return;
            case 13:
                handleHeaderFooter(bArr);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: renamed from: org.apache.poi.xssf.binary.XSSFBSheetHandler$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType;

        static {
            int[] iArr = new int[XSSFBRecordType.values().length];
            $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType = iArr;
            try {
                iArr[XSSFBRecordType.BrtRowHdr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtCellIsst.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtCellSt.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtCellRk.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtCellReal.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtCellBool.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtCellError.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtCellBlank.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtFmlaString.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtFmlaNum.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtFmlaError.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtEndSheetData.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$binary$XSSFBRecordType[XSSFBRecordType.BrtBeginHeaderFooter.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    private void beforeCellValue(byte[] bArr) {
        XSSFBCellHeader.parse(bArr, 0, this.currentRow, this.cellBuffer);
        checkMissedComments(this.currentRow, this.cellBuffer.getColNum());
    }

    private void handleCellValue(String str) {
        CellAddress cellAddress = new CellAddress(this.currentRow, this.cellBuffer.getColNum());
        XSSFBCommentsTable xSSFBCommentsTable = this.comments;
        this.handler.cell(cellAddress.formatAsString(), str, xSSFBCommentsTable != null ? xSSFBCommentsTable.get(cellAddress) : null);
    }

    private void handleFmlaNum(byte[] bArr) {
        beforeCellValue(bArr);
        handleCellValue(formatVal(LittleEndian.getDouble(bArr, XSSFBCellHeader.length), this.cellBuffer.getStyleIdx()));
    }

    private void handleCellSt(byte[] bArr) {
        beforeCellValue(bArr);
        this.xlWideStringBuffer.setLength(0);
        XSSFBUtils.readXLWideString(bArr, XSSFBCellHeader.length, this.xlWideStringBuffer);
        handleCellValue(this.xlWideStringBuffer.toString());
    }

    private void handleFmlaString(byte[] bArr) {
        beforeCellValue(bArr);
        this.xlWideStringBuffer.setLength(0);
        XSSFBUtils.readXLWideString(bArr, XSSFBCellHeader.length, this.xlWideStringBuffer);
        handleCellValue(this.xlWideStringBuffer.toString());
    }

    private void handleCellError(byte[] bArr) {
        beforeCellValue(bArr);
        handleCellValue("ERROR");
    }

    private void handleFmlaError(byte[] bArr) {
        beforeCellValue(bArr);
        handleCellValue("ERROR");
    }

    private void handleBoolean(byte[] bArr) {
        beforeCellValue(bArr);
        handleCellValue(bArr[XSSFBCellHeader.length] == 1 ? "TRUE" : "FALSE");
    }

    private void handleCellReal(byte[] bArr) {
        beforeCellValue(bArr);
        handleCellValue(formatVal(LittleEndian.getDouble(bArr, XSSFBCellHeader.length), this.cellBuffer.getStyleIdx()));
    }

    private void handleCellRk(byte[] bArr) {
        beforeCellValue(bArr);
        handleCellValue(formatVal(rkNumber(bArr, XSSFBCellHeader.length), this.cellBuffer.getStyleIdx()));
    }

    private String formatVal(double d, int i) {
        String numberFormatString = this.styles.getNumberFormatString(i);
        short numberFormatIndex = this.styles.getNumberFormatIndex(i);
        if (numberFormatString == null) {
            numberFormatIndex = 0;
            numberFormatString = BuiltinFormats.getBuiltinFormat(0);
        }
        return this.dataFormatter.formatRawCellContents(d, numberFormatIndex, numberFormatString);
    }

    private void handleBrtCellIsst(byte[] bArr) {
        beforeCellValue(bArr);
        handleCellValue(new XSSFRichTextString(this.stringsTable.getEntryAt(XSSFBUtils.castToInt(LittleEndian.getUInt(bArr, XSSFBCellHeader.length)))).getString());
    }

    private void handleHeaderFooter(byte[] bArr) {
        XSSFBHeaderFooters xSSFBHeaderFooters = XSSFBHeaderFooters.parse(bArr);
        outputHeaderFooter(xSSFBHeaderFooters.getHeader());
        outputHeaderFooter(xSSFBHeaderFooters.getFooter());
        outputHeaderFooter(xSSFBHeaderFooters.getHeaderEven());
        outputHeaderFooter(xSSFBHeaderFooters.getFooterEven());
        outputHeaderFooter(xSSFBHeaderFooters.getHeaderFirst());
        outputHeaderFooter(xSSFBHeaderFooters.getFooterFirst());
    }

    private void outputHeaderFooter(XSSFBHeaderFooter xSSFBHeaderFooter) {
        String string = xSSFBHeaderFooter.getString();
        if (string == null || string.trim().length() <= 0) {
            return;
        }
        this.handler.headerFooter(string, xSSFBHeaderFooter.isHeader(), xSSFBHeaderFooter.getHeaderFooterTypeLabel());
    }

    private void checkMissedComments(int i, int i2) {
        XSSFBCommentsTable xSSFBCommentsTable = this.comments;
        if (xSSFBCommentsTable == null) {
            return;
        }
        Queue<CellAddress> addresses = xSSFBCommentsTable.getAddresses();
        while (addresses.size() > 0) {
            CellAddress cellAddressPeek = addresses.peek();
            if (cellAddressPeek.getRow() == i && cellAddressPeek.getColumn() < i2) {
                CellAddress cellAddressRemove = addresses.remove();
                dumpEmptyCellComment(cellAddressRemove, this.comments.get(cellAddressRemove));
            } else if (cellAddressPeek.getRow() == i && cellAddressPeek.getColumn() == i2) {
                addresses.remove();
                return;
            } else if ((cellAddressPeek.getRow() == i && cellAddressPeek.getColumn() > i2) || cellAddressPeek.getRow() > i) {
                return;
            }
        }
    }

    private void checkMissedComments(int i) {
        XSSFBCommentsTable xSSFBCommentsTable = this.comments;
        if (xSSFBCommentsTable == null) {
            return;
        }
        Queue<CellAddress> addresses = xSSFBCommentsTable.getAddresses();
        int row = -1;
        while (addresses.size() > 0) {
            CellAddress cellAddressPeek = addresses.peek();
            if (i != -1 && cellAddressPeek.getRow() >= i) {
                return;
            }
            CellAddress cellAddressRemove = addresses.remove();
            if (cellAddressRemove.getRow() != row) {
                startRow(cellAddressRemove.getRow());
            }
            dumpEmptyCellComment(cellAddressRemove, this.comments.get(cellAddressRemove));
            row = cellAddressRemove.getRow();
        }
    }

    private void startRow(int i) {
        int i2 = this.lastStartedRow;
        if (i == i2) {
            return;
        }
        if (i2 != this.lastEndedRow) {
            endRow(i2);
        }
        this.handler.startRow(i);
        this.lastStartedRow = i;
    }

    private void endRow(int i) {
        if (this.lastEndedRow == i) {
            return;
        }
        this.handler.endRow(i);
        this.lastEndedRow = i;
    }

    private void dumpEmptyCellComment(CellAddress cellAddress, XSSFBComment xSSFBComment) {
        this.handler.cell(cellAddress.formatAsString(), null, xSSFBComment);
    }

    private double rkNumber(byte[] bArr, int i) {
        double d;
        byte b = bArr[i];
        Integer.toString(b, 2);
        boolean z = (b & 1) == 1;
        boolean z2 = ((b >> 1) & 1) == 0;
        this.rkBuffer[4] = (byte) (((byte) (b & (-2))) & (-3));
        for (int i2 = 1; i2 < 4; i2++) {
            this.rkBuffer[i2 + 4] = bArr[i + i2];
        }
        if (z2) {
            d = LittleEndian.getDouble(this.rkBuffer);
        } else {
            d = LittleEndian.getInt(this.rkBuffer);
        }
        return z ? d / 100.0d : d;
    }
}
