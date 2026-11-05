package org.apache.poi.hssf.model;

import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import module.canbus.FinalCanbus;
import org.apache.poi.ddf.EscherBSERecord;
import org.apache.poi.ddf.EscherBoolProperty;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherDgRecord;
import org.apache.poi.ddf.EscherDggRecord;
import org.apache.poi.ddf.EscherOptRecord;
import org.apache.poi.ddf.EscherProperties;
import org.apache.poi.ddf.EscherRGBProperty;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherSimpleProperty;
import org.apache.poi.ddf.EscherSpRecord;
import org.apache.poi.ddf.EscherSplitMenuColorsRecord;
import org.apache.poi.hssf.record.BOFRecord;
import org.apache.poi.hssf.record.BackupRecord;
import org.apache.poi.hssf.record.BookBoolRecord;
import org.apache.poi.hssf.record.BoundSheetRecord;
import org.apache.poi.hssf.record.CodepageRecord;
import org.apache.poi.hssf.record.CountryRecord;
import org.apache.poi.hssf.record.DSFRecord;
import org.apache.poi.hssf.record.DateWindow1904Record;
import org.apache.poi.hssf.record.DrawingGroupRecord;
import org.apache.poi.hssf.record.EOFRecord;
import org.apache.poi.hssf.record.EscherAggregate;
import org.apache.poi.hssf.record.ExtSSTRecord;
import org.apache.poi.hssf.record.ExtendedFormatRecord;
import org.apache.poi.hssf.record.FileSharingRecord;
import org.apache.poi.hssf.record.FnGroupCountRecord;
import org.apache.poi.hssf.record.FontRecord;
import org.apache.poi.hssf.record.FormatRecord;
import org.apache.poi.hssf.record.HideObjRecord;
import org.apache.poi.hssf.record.HyperlinkRecord;
import org.apache.poi.hssf.record.InterfaceEndRecord;
import org.apache.poi.hssf.record.InterfaceHdrRecord;
import org.apache.poi.hssf.record.MMSRecord;
import org.apache.poi.hssf.record.NameCommentRecord;
import org.apache.poi.hssf.record.NameRecord;
import org.apache.poi.hssf.record.PaletteRecord;
import org.apache.poi.hssf.record.PasswordRecord;
import org.apache.poi.hssf.record.PasswordRev4Record;
import org.apache.poi.hssf.record.PrecisionRecord;
import org.apache.poi.hssf.record.ProtectRecord;
import org.apache.poi.hssf.record.ProtectionRev4Record;
import org.apache.poi.hssf.record.RecalcIdRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RefreshAllRecord;
import org.apache.poi.hssf.record.SSTRecord;
import org.apache.poi.hssf.record.StyleRecord;
import org.apache.poi.hssf.record.TabIdRecord;
import org.apache.poi.hssf.record.UseSelFSRecord;
import org.apache.poi.hssf.record.WindowOneRecord;
import org.apache.poi.hssf.record.WindowProtectRecord;
import org.apache.poi.hssf.record.WriteAccessRecord;
import org.apache.poi.hssf.record.WriteProtectRecord;
import org.apache.poi.hssf.record.common.UnicodeString;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFShape;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.ss.formula.EvaluationWorkbook;
import org.apache.poi.ss.formula.FormulaShifter;
import org.apache.poi.ss.formula.ptg.Area3DPtg;
import org.apache.poi.ss.formula.ptg.NameXPtg;
import org.apache.poi.ss.formula.ptg.OperandPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.Ref3DPtg;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.SheetVisibility;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public final class InternalWorkbook {
    private static final short CODEPAGE = 1200;
    private static final int MAX_SENSITIVE_SHEET_NAME_LEN = 31;
    public static final String OLD_WORKBOOK_DIR_ENTRY_NAME = "Book";
    private DrawingManager2 drawingManager;
    private FileSharingRecord fileShare;
    private LinkTable linkTable;
    protected SSTRecord sst;
    private WindowOneRecord windowOne;
    private WriteAccessRecord writeAccess;
    private WriteProtectRecord writeProtect;
    public static final String[] WORKBOOK_DIR_ENTRY_NAMES = {"Workbook", "WORKBOOK", "BOOK"};
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) InternalWorkbook.class);
    private final WorkbookRecordList records = new WorkbookRecordList();
    private final List<BoundSheetRecord> boundsheets = new ArrayList();
    private final List<FormatRecord> formats = new ArrayList();
    private final List<HyperlinkRecord> hyperlinks = new ArrayList();
    private int numxfs = 0;
    private int numfonts = 0;
    private int maxformatid = -1;
    private boolean uses1904datewindowing = false;
    private List<EscherBSERecord> escherBSERecords = new ArrayList();
    private final Map<String, NameCommentRecord> commentRecords = new LinkedHashMap();

    private InternalWorkbook() {
    }

    public static InternalWorkbook createWorkbook(List<Record> list) {
        String str;
        LOG.log(1, "Workbook (readfile) created with reclen=", Integer.valueOf(list.size()));
        InternalWorkbook internalWorkbook = new InternalWorkbook();
        ArrayList arrayList = new ArrayList(list.size() / 3);
        internalWorkbook.records.setRecords(arrayList);
        int recordCount = 0;
        boolean z = false;
        while (recordCount < list.size()) {
            Record record = list.get(recordCount);
            switch (record.getSid()) {
                case 10:
                    str = "workbook eof";
                    break;
                case 18:
                    internalWorkbook.records.setProtpos(recordCount);
                    str = "protect";
                    break;
                case 23:
                    throw new RecordFormatException("Extern sheet is part of LinkTable");
                case 24:
                case FinalCanbus.CAR_WC2_TianLai03_07 /* 430 */:
                    LOG.log(1, "found SupBook record at " + recordCount);
                    LinkTable linkTable = new LinkTable(list, recordCount, internalWorkbook.records, internalWorkbook.commentRecords);
                    internalWorkbook.linkTable = linkTable;
                    recordCount += linkTable.getRecordCount() - 1;
                    continue;
                    recordCount++;
                    break;
                case 34:
                    internalWorkbook.uses1904datewindowing = ((DateWindow1904Record) record).getWindowing() == 1;
                    str = "datewindow1904";
                    break;
                case 49:
                    internalWorkbook.records.setFontpos(recordCount);
                    internalWorkbook.numfonts++;
                    str = CellUtil.FONT;
                    break;
                case 61:
                    internalWorkbook.windowOne = (WindowOneRecord) record;
                    str = "WindowOneRecord";
                    break;
                case 64:
                    internalWorkbook.records.setBackuppos(recordCount);
                    str = "backup";
                    break;
                case 91:
                    internalWorkbook.fileShare = (FileSharingRecord) record;
                    str = "FileSharing";
                    break;
                case 92:
                    internalWorkbook.writeAccess = (WriteAccessRecord) record;
                    str = "WriteAccess";
                    break;
                case 133:
                    internalWorkbook.boundsheets.add((BoundSheetRecord) record);
                    internalWorkbook.records.setBspos(recordCount);
                    str = "boundsheet";
                    break;
                case 134:
                    internalWorkbook.writeProtect = (WriteProtectRecord) record;
                    str = "WriteProtect";
                    break;
                case 146:
                    internalWorkbook.records.setPalettepos(recordCount);
                    str = "palette";
                    break;
                case FinalCanbus.CAR_DC_WC1_15YIDONG /* 224 */:
                    internalWorkbook.records.setXfpos(recordCount);
                    internalWorkbook.numxfs++;
                    str = "XF";
                    break;
                case FinalCanbus.CAR_WC2_PSAALL_0 /* 252 */:
                    internalWorkbook.sst = (SSTRecord) record;
                    str = "sst";
                    break;
                case FinalCanbus.CAR_WeiChi2_ATS /* 317 */:
                    internalWorkbook.records.setTabpos(recordCount);
                    str = "tabid";
                    break;
                case FinalCanbus.CAR_440 /* 440 */:
                    internalWorkbook.hyperlinks.add((HyperlinkRecord) record);
                    str = "Hyperlink";
                    break;
                case 1054:
                    FormatRecord formatRecord = (FormatRecord) record;
                    internalWorkbook.formats.add(formatRecord);
                    internalWorkbook.maxformatid = internalWorkbook.maxformatid >= formatRecord.getIndexCode() ? internalWorkbook.maxformatid : formatRecord.getIndexCode();
                    str = "format";
                    break;
                case 2196:
                    NameCommentRecord nameCommentRecord = (NameCommentRecord) record;
                    internalWorkbook.commentRecords.put(nameCommentRecord.getNameText(), nameCommentRecord);
                    str = "NameComment";
                    break;
                default:
                    str = "(sid=" + ((int) record.getSid()) + ")";
                    break;
            }
            if (!z) {
                arrayList.add(record);
            }
            LOG.log(1, "found " + str + " record at " + recordCount);
            if (record.getSid() == 10) {
                z = true;
            }
            recordCount++;
        }
        if (internalWorkbook.windowOne == null) {
            internalWorkbook.windowOne = createWindowOne();
        }
        LOG.log(1, "exit create workbook from existing file function");
        return internalWorkbook;
    }

    public static InternalWorkbook createWorkbook() {
        LOG.log(1, "creating new workbook from scratch");
        InternalWorkbook internalWorkbook = new InternalWorkbook();
        ArrayList arrayList = new ArrayList(30);
        internalWorkbook.records.setRecords(arrayList);
        List<FormatRecord> list = internalWorkbook.formats;
        arrayList.add(createBOF());
        arrayList.add(new InterfaceHdrRecord(1200));
        arrayList.add(createMMS());
        arrayList.add(InterfaceEndRecord.instance);
        arrayList.add(createWriteAccess());
        arrayList.add(createCodepage());
        arrayList.add(createDSF());
        arrayList.add(createTabId());
        internalWorkbook.records.setTabpos(arrayList.size() - 1);
        arrayList.add(createFnGroupCount());
        arrayList.add(createWindowProtect());
        arrayList.add(createProtect());
        internalWorkbook.records.setProtpos(arrayList.size() - 1);
        arrayList.add(createPassword());
        arrayList.add(createProtectionRev4());
        arrayList.add(createPasswordRev4());
        WindowOneRecord windowOneRecordCreateWindowOne = createWindowOne();
        internalWorkbook.windowOne = windowOneRecordCreateWindowOne;
        arrayList.add(windowOneRecordCreateWindowOne);
        arrayList.add(createBackup());
        internalWorkbook.records.setBackuppos(arrayList.size() - 1);
        arrayList.add(createHideObj());
        arrayList.add(createDateWindow1904());
        arrayList.add(createPrecision());
        arrayList.add(createRefreshAll());
        arrayList.add(createBookBool());
        arrayList.add(createFont());
        arrayList.add(createFont());
        arrayList.add(createFont());
        arrayList.add(createFont());
        internalWorkbook.records.setFontpos(arrayList.size() - 1);
        internalWorkbook.numfonts = 4;
        for (int i = 0; i <= 7; i++) {
            FormatRecord formatRecordCreateFormat = createFormat(i);
            internalWorkbook.maxformatid = internalWorkbook.maxformatid >= formatRecordCreateFormat.getIndexCode() ? internalWorkbook.maxformatid : formatRecordCreateFormat.getIndexCode();
            list.add(formatRecordCreateFormat);
            arrayList.add(formatRecordCreateFormat);
        }
        for (int i2 = 0; i2 < 21; i2++) {
            arrayList.add(createExtendedFormat(i2));
            internalWorkbook.numxfs++;
        }
        internalWorkbook.records.setXfpos(arrayList.size() - 1);
        for (int i3 = 0; i3 < 6; i3++) {
            arrayList.add(createStyle(i3));
        }
        arrayList.add(createUseSelFS());
        BoundSheetRecord boundSheetRecordCreateBoundSheet = createBoundSheet(0);
        arrayList.add(boundSheetRecordCreateBoundSheet);
        internalWorkbook.boundsheets.add(boundSheetRecordCreateBoundSheet);
        internalWorkbook.records.setBspos(arrayList.size() - 1);
        arrayList.add(createCountry());
        internalWorkbook.getOrCreateLinkTable().checkExternSheet(0);
        SSTRecord sSTRecord = new SSTRecord();
        internalWorkbook.sst = sSTRecord;
        arrayList.add(sSTRecord);
        arrayList.add(createExtendedSST());
        arrayList.add(EOFRecord.instance);
        LOG.log(1, "exit create new workbook from scratch");
        return internalWorkbook;
    }

    public NameRecord getSpecificBuiltinRecord(byte b, int i) {
        return getOrCreateLinkTable().getSpecificBuiltinRecord(b, i);
    }

    public void removeBuiltinRecord(byte b, int i) {
        this.linkTable.removeBuiltinRecord(b, i);
    }

    public int getNumRecords() {
        return this.records.size();
    }

    public FontRecord getFontRecordAt(int i) {
        int i2 = i > 4 ? i - 1 : i;
        if (i2 > this.numfonts - 1) {
            throw new ArrayIndexOutOfBoundsException("There are only " + this.numfonts + " font records, you asked for " + i);
        }
        WorkbookRecordList workbookRecordList = this.records;
        return (FontRecord) workbookRecordList.get((workbookRecordList.getFontpos() - (this.numfonts - 1)) + i2);
    }

    public int getFontIndex(FontRecord fontRecord) {
        int i = 0;
        while (i <= this.numfonts) {
            WorkbookRecordList workbookRecordList = this.records;
            if (((FontRecord) workbookRecordList.get((workbookRecordList.getFontpos() - (this.numfonts - 1)) + i)) == fontRecord) {
                return i > 3 ? i + 1 : i;
            }
            i++;
        }
        throw new IllegalArgumentException("Could not find that font!");
    }

    public FontRecord createNewFont() {
        FontRecord fontRecordCreateFont = createFont();
        WorkbookRecordList workbookRecordList = this.records;
        workbookRecordList.add(workbookRecordList.getFontpos() + 1, fontRecordCreateFont);
        WorkbookRecordList workbookRecordList2 = this.records;
        workbookRecordList2.setFontpos(workbookRecordList2.getFontpos() + 1);
        this.numfonts++;
        return fontRecordCreateFont;
    }

    public void removeFontRecord(FontRecord fontRecord) {
        this.records.remove(fontRecord);
        this.numfonts--;
    }

    public int getNumberOfFontRecords() {
        return this.numfonts;
    }

    public void setSheetBof(int i, int i2) {
        LOG.log(1, "setting bof for sheetnum =", Integer.valueOf(i), " at pos=", Integer.valueOf(i2));
        checkSheets(i);
        getBoundSheetRec(i).setPositionOfBof(i2);
    }

    private BoundSheetRecord getBoundSheetRec(int i) {
        return this.boundsheets.get(i);
    }

    public BackupRecord getBackupRecord() {
        WorkbookRecordList workbookRecordList = this.records;
        return (BackupRecord) workbookRecordList.get(workbookRecordList.getBackuppos());
    }

    public void setSheetName(int i, String str) {
        checkSheets(i);
        if (str.length() > 31) {
            str = str.substring(0, 31);
        }
        this.boundsheets.get(i).setSheetname(str);
    }

    public boolean doesContainsSheetName(String str, int i) {
        if (str.length() > 31) {
            str = str.substring(0, 31);
        }
        int i2 = 0;
        for (BoundSheetRecord boundSheetRecord : this.boundsheets) {
            int i3 = i2 + 1;
            if (i != i2) {
                String sheetname = boundSheetRecord.getSheetname();
                if (sheetname.length() > 31) {
                    sheetname = sheetname.substring(0, 31);
                }
                if (str.equalsIgnoreCase(sheetname)) {
                    return true;
                }
            }
            i2 = i3;
        }
        return false;
    }

    public void setSheetOrder(String str, int i) {
        int sheetIndex = getSheetIndex(str);
        List<BoundSheetRecord> list = this.boundsheets;
        list.add(i, list.remove(sheetIndex));
        int bspos = this.records.getBspos();
        int size = bspos - (this.boundsheets.size() - 1);
        int i2 = sheetIndex + size;
        Record record = this.records.get(i2);
        this.records.remove(i2);
        this.records.add(size + i, record);
        this.records.setBspos(bspos);
    }

    public String getSheetName(int i) {
        return getBoundSheetRec(i).getSheetname();
    }

    public boolean isSheetHidden(int i) {
        return getBoundSheetRec(i).isHidden();
    }

    public boolean isSheetVeryHidden(int i) {
        return getBoundSheetRec(i).isVeryHidden();
    }

    public SheetVisibility getSheetVisibility(int i) {
        BoundSheetRecord boundSheetRec = getBoundSheetRec(i);
        if (boundSheetRec.isVeryHidden()) {
            return SheetVisibility.VERY_HIDDEN;
        }
        if (boundSheetRec.isHidden()) {
            return SheetVisibility.HIDDEN;
        }
        return SheetVisibility.VISIBLE;
    }

    public void setSheetHidden(int i, boolean z) {
        setSheetHidden(i, z ? SheetVisibility.HIDDEN : SheetVisibility.VISIBLE);
    }

    public void setSheetHidden(int i, SheetVisibility sheetVisibility) {
        BoundSheetRecord boundSheetRec = getBoundSheetRec(i);
        boundSheetRec.setHidden(sheetVisibility == SheetVisibility.HIDDEN);
        boundSheetRec.setVeryHidden(sheetVisibility == SheetVisibility.VERY_HIDDEN);
    }

    public int getSheetIndex(String str) {
        int size = this.boundsheets.size();
        for (int i = 0; i < size; i++) {
            if (getSheetName(i).equalsIgnoreCase(str)) {
                return i;
            }
        }
        return -1;
    }

    private void checkSheets(int i) {
        if (this.boundsheets.size() <= i) {
            if (this.boundsheets.size() + 1 <= i) {
                throw new RuntimeException("Sheet number out of bounds!");
            }
            BoundSheetRecord boundSheetRecordCreateBoundSheet = createBoundSheet(i);
            WorkbookRecordList workbookRecordList = this.records;
            workbookRecordList.add(workbookRecordList.getBspos() + 1, boundSheetRecordCreateBoundSheet);
            WorkbookRecordList workbookRecordList2 = this.records;
            workbookRecordList2.setBspos(workbookRecordList2.getBspos() + 1);
            this.boundsheets.add(boundSheetRecordCreateBoundSheet);
            getOrCreateLinkTable().checkExternSheet(i);
            fixTabIdRecord();
        }
    }

    public void removeSheet(int i) {
        if (this.boundsheets.size() > i) {
            WorkbookRecordList workbookRecordList = this.records;
            workbookRecordList.remove((workbookRecordList.getBspos() - (this.boundsheets.size() - 1)) + i);
            this.boundsheets.remove(i);
            fixTabIdRecord();
        }
        int i2 = i + 1;
        for (int i3 = 0; i3 < getNumNames(); i3++) {
            NameRecord nameRecord = getNameRecord(i3);
            if (nameRecord.getSheetNumber() == i2) {
                nameRecord.setSheetNumber(0);
            } else if (nameRecord.getSheetNumber() > i2) {
                nameRecord.setSheetNumber(nameRecord.getSheetNumber() - 1);
            }
        }
        LinkTable linkTable = this.linkTable;
        if (linkTable != null) {
            linkTable.removeSheet(i);
        }
    }

    private void fixTabIdRecord() {
        WorkbookRecordList workbookRecordList = this.records;
        Record record = workbookRecordList.get(workbookRecordList.getTabpos());
        if (this.records.getTabpos() <= 0) {
            return;
        }
        TabIdRecord tabIdRecord = (TabIdRecord) record;
        int size = this.boundsheets.size();
        short[] sArr = new short[size];
        for (short s = 0; s < size; s = (short) (s + 1)) {
            sArr[s] = s;
        }
        tabIdRecord.setTabIdArray(sArr);
    }

    public int getNumSheets() {
        LOG.log(1, "getNumSheets=", Integer.valueOf(this.boundsheets.size()));
        return this.boundsheets.size();
    }

    public int getNumExFormats() {
        LOG.log(1, "getXF=", Integer.valueOf(this.numxfs));
        return this.numxfs;
    }

    public ExtendedFormatRecord getExFormatAt(int i) {
        return (ExtendedFormatRecord) this.records.get((this.records.getXfpos() - (this.numxfs - 1)) + i);
    }

    public void removeExFormatRecord(ExtendedFormatRecord extendedFormatRecord) {
        this.records.remove(extendedFormatRecord);
        this.numxfs--;
    }

    public void removeExFormatRecord(int i) {
        this.records.remove((this.records.getXfpos() - (this.numxfs - 1)) + i);
        this.numxfs--;
    }

    public ExtendedFormatRecord createCellXF() {
        ExtendedFormatRecord extendedFormatRecordCreateExtendedFormat = createExtendedFormat();
        WorkbookRecordList workbookRecordList = this.records;
        workbookRecordList.add(workbookRecordList.getXfpos() + 1, extendedFormatRecordCreateExtendedFormat);
        WorkbookRecordList workbookRecordList2 = this.records;
        workbookRecordList2.setXfpos(workbookRecordList2.getXfpos() + 1);
        this.numxfs++;
        return extendedFormatRecordCreateExtendedFormat;
    }

    public StyleRecord getStyleRecord(int i) {
        for (int xfpos = this.records.getXfpos(); xfpos < this.records.size(); xfpos++) {
            Record record = this.records.get(xfpos);
            if (record instanceof StyleRecord) {
                StyleRecord styleRecord = (StyleRecord) record;
                if (styleRecord.getXFIndex() == i) {
                    return styleRecord;
                }
            }
        }
        return null;
    }

    public StyleRecord createStyleRecord(int i) {
        StyleRecord styleRecord = new StyleRecord();
        styleRecord.setXFIndex(i);
        int i2 = -1;
        for (int xfpos = this.records.getXfpos(); xfpos < this.records.size() && i2 == -1; xfpos++) {
            Record record = this.records.get(xfpos);
            if (!(record instanceof ExtendedFormatRecord) && !(record instanceof StyleRecord)) {
                i2 = xfpos;
            }
        }
        if (i2 == -1) {
            throw new IllegalStateException("No XF Records found!");
        }
        this.records.add(i2, styleRecord);
        return styleRecord;
    }

    public int addSSTString(UnicodeString unicodeString) {
        LOG.log(1, "insert to sst string='", unicodeString);
        if (this.sst == null) {
            insertSST();
        }
        return this.sst.addString(unicodeString);
    }

    public UnicodeString getSSTString(int i) {
        if (this.sst == null) {
            insertSST();
        }
        UnicodeString string = this.sst.getString(i);
        LOG.log(1, "Returning SST for index=", Integer.valueOf(i), " String= ", string);
        return string;
    }

    public void insertSST() {
        LOG.log(1, "creating new SST via insertSST!");
        this.sst = new SSTRecord();
        WorkbookRecordList workbookRecordList = this.records;
        workbookRecordList.add(workbookRecordList.size() - 1, createExtendedSST());
        WorkbookRecordList workbookRecordList2 = this.records;
        workbookRecordList2.add(workbookRecordList2.size() - 2, this.sst);
    }

    public int serialize(int i, byte[] bArr) {
        int iSerialize;
        LOG.log(1, "Serializing Workbook with offsets");
        Iterator<Record> it = this.records.getRecords().iterator();
        SSTRecord sSTRecord = null;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        while (it.hasNext()) {
            Record next = it.next();
            if (next instanceof SSTRecord) {
                sSTRecord = (SSTRecord) next;
                i3 = i2;
            }
            if (next.getSid() == 255 && sSTRecord != null) {
                next = sSTRecord.createExtSSTRecord(i3 + i);
            }
            if (!(next instanceof BoundSheetRecord)) {
                iSerialize = next.serialize(i2 + i, bArr);
            } else if (z) {
                iSerialize = 0;
            } else {
                Iterator<BoundSheetRecord> it2 = this.boundsheets.iterator();
                iSerialize = 0;
                while (it2.hasNext()) {
                    iSerialize += it2.next().serialize(i2 + i + iSerialize, bArr);
                }
                z = true;
            }
            i2 += iSerialize;
        }
        LOG.log(1, "Exiting serialize workbook");
        return i2;
    }

    public void preSerialize() {
        if (this.records.getTabpos() > 0) {
            WorkbookRecordList workbookRecordList = this.records;
            if (((TabIdRecord) workbookRecordList.get(workbookRecordList.getTabpos()))._tabids.length < this.boundsheets.size()) {
                fixTabIdRecord();
            }
        }
    }

    public int getSize() {
        int recordSize;
        int i = 0;
        SSTRecord sSTRecord = null;
        for (Record record : this.records.getRecords()) {
            if (record instanceof SSTRecord) {
                sSTRecord = (SSTRecord) record;
            }
            if (record.getSid() == 255 && sSTRecord != null) {
                recordSize = sSTRecord.calcExtSSTRecordSize();
            } else {
                recordSize = record.getRecordSize();
            }
            i += recordSize;
        }
        return i;
    }

    private static BOFRecord createBOF() {
        BOFRecord bOFRecord = new BOFRecord();
        bOFRecord.setVersion(BOFRecord.VERSION);
        bOFRecord.setType(5);
        bOFRecord.setBuild(BOFRecord.BUILD);
        bOFRecord.setBuildYear(BOFRecord.BUILD_YEAR);
        bOFRecord.setHistoryBitMask(65);
        bOFRecord.setRequiredVersion(6);
        return bOFRecord;
    }

    private static MMSRecord createMMS() {
        MMSRecord mMSRecord = new MMSRecord();
        mMSRecord.setAddMenuCount((byte) 0);
        mMSRecord.setDelMenuCount((byte) 0);
        return mMSRecord;
    }

    private static WriteAccessRecord createWriteAccess() {
        WriteAccessRecord writeAccessRecord = new WriteAccessRecord();
        try {
            String property = System.getProperty("user.name");
            if (property == null) {
                property = "POI";
            }
            writeAccessRecord.setUsername(property);
        } catch (AccessControlException e) {
            LOG.log(5, "can't determine user.name", e);
            writeAccessRecord.setUsername("POI");
        }
        return writeAccessRecord;
    }

    private static CodepageRecord createCodepage() {
        CodepageRecord codepageRecord = new CodepageRecord();
        codepageRecord.setCodepage((short) 1200);
        return codepageRecord;
    }

    private static DSFRecord createDSF() {
        return new DSFRecord(false);
    }

    private static TabIdRecord createTabId() {
        return new TabIdRecord();
    }

    private static FnGroupCountRecord createFnGroupCount() {
        FnGroupCountRecord fnGroupCountRecord = new FnGroupCountRecord();
        fnGroupCountRecord.setCount((short) 14);
        return fnGroupCountRecord;
    }

    private static WindowProtectRecord createWindowProtect() {
        return new WindowProtectRecord(false);
    }

    private static ProtectRecord createProtect() {
        return new ProtectRecord(false);
    }

    private static PasswordRecord createPassword() {
        return new PasswordRecord(0);
    }

    private static ProtectionRev4Record createProtectionRev4() {
        return new ProtectionRev4Record(false);
    }

    private static PasswordRev4Record createPasswordRev4() {
        return new PasswordRev4Record(0);
    }

    private static WindowOneRecord createWindowOne() {
        WindowOneRecord windowOneRecord = new WindowOneRecord();
        windowOneRecord.setHorizontalHold((short) 360);
        windowOneRecord.setVerticalHold(EscherProperties.BLIP__PICTURELINE);
        windowOneRecord.setWidth((short) 14940);
        windowOneRecord.setHeight((short) 9150);
        windowOneRecord.setOptions((short) 56);
        windowOneRecord.setActiveSheetIndex(0);
        windowOneRecord.setFirstVisibleTab(0);
        windowOneRecord.setNumSelectedTabs((short) 1);
        windowOneRecord.setTabWidthRatio((short) 600);
        return windowOneRecord;
    }

    private static BackupRecord createBackup() {
        BackupRecord backupRecord = new BackupRecord();
        backupRecord.setBackup((short) 0);
        return backupRecord;
    }

    private static HideObjRecord createHideObj() {
        HideObjRecord hideObjRecord = new HideObjRecord();
        hideObjRecord.setHideObj((short) 0);
        return hideObjRecord;
    }

    private static DateWindow1904Record createDateWindow1904() {
        DateWindow1904Record dateWindow1904Record = new DateWindow1904Record();
        dateWindow1904Record.setWindowing((short) 0);
        return dateWindow1904Record;
    }

    private static PrecisionRecord createPrecision() {
        PrecisionRecord precisionRecord = new PrecisionRecord();
        precisionRecord.setFullPrecision(true);
        return precisionRecord;
    }

    private static RefreshAllRecord createRefreshAll() {
        return new RefreshAllRecord(false);
    }

    private static BookBoolRecord createBookBool() {
        BookBoolRecord bookBoolRecord = new BookBoolRecord();
        bookBoolRecord.setSaveLinkValues((short) 0);
        return bookBoolRecord;
    }

    private static FontRecord createFont() {
        FontRecord fontRecord = new FontRecord();
        fontRecord.setFontHeight(EscherAggregate.ST_ACTIONBUTTONMOVIE);
        fontRecord.setAttributes((short) 0);
        fontRecord.setColorPaletteIndex(Short.MAX_VALUE);
        fontRecord.setBoldWeight(EscherProperties.FILL__TOBOTTOM);
        fontRecord.setFontName(HSSFFont.FONT_ARIAL);
        return fontRecord;
    }

    private static FormatRecord createFormat(int i) {
        int[] iArr = {5, 6, 7, 8, 42, 41, 44, 43};
        if (i < 0 || i >= 8) {
            throw new IllegalArgumentException("Unexpected id " + i);
        }
        int i2 = iArr[i];
        return new FormatRecord(i2, BuiltinFormats.getBuiltinFormat(i2));
    }

    private static ExtendedFormatRecord createExtendedFormat(int i) {
        switch (i) {
            case 0:
                return createExtendedFormat(0, 0, -11, 0);
            case 1:
            case 2:
                return createExtendedFormat(1, 0, -11, -3072);
            case 3:
            case 4:
                return createExtendedFormat(2, 0, -11, -3072);
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                return createExtendedFormat(0, 0, -11, -3072);
            case 15:
                return createExtendedFormat(0, 0, 1, 0);
            case 16:
                return createExtendedFormat(1, 43, -11, -2048);
            case 17:
                return createExtendedFormat(1, 41, -11, -2048);
            case 18:
                return createExtendedFormat(1, 44, -11, -2048);
            case 19:
                return createExtendedFormat(1, 42, -11, -2048);
            case 20:
                return createExtendedFormat(1, 9, -11, -2048);
            case 21:
                return createExtendedFormat(5, 0, 1, 2048);
            case 22:
                return createExtendedFormat(6, 0, 1, 23552);
            case 23:
                return createExtendedFormat(0, 49, 1, 23552);
            case 24:
                return createExtendedFormat(0, 8, 1, 23552);
            case 25:
                return createExtendedFormat(6, 8, 1, 23552);
            default:
                throw new IllegalStateException("Unrecognized format id: " + i);
        }
    }

    private static ExtendedFormatRecord createExtendedFormat(int i, int i2, int i3, int i4) {
        ExtendedFormatRecord extendedFormatRecord = new ExtendedFormatRecord();
        extendedFormatRecord.setFontIndex((short) i);
        extendedFormatRecord.setFormatIndex((short) i2);
        extendedFormatRecord.setCellOptions((short) i3);
        extendedFormatRecord.setAlignmentOptions((short) 32);
        extendedFormatRecord.setIndentionOptions((short) i4);
        extendedFormatRecord.setBorderOptions((short) 0);
        extendedFormatRecord.setPaletteOptions((short) 0);
        extendedFormatRecord.setAdtlPaletteOptions((short) 0);
        extendedFormatRecord.setFillPaletteOptions((short) 8384);
        return extendedFormatRecord;
    }

    private static ExtendedFormatRecord createExtendedFormat() {
        ExtendedFormatRecord extendedFormatRecord = new ExtendedFormatRecord();
        extendedFormatRecord.setFontIndex((short) 0);
        extendedFormatRecord.setFormatIndex((short) 0);
        extendedFormatRecord.setCellOptions((short) 1);
        extendedFormatRecord.setAlignmentOptions((short) 32);
        extendedFormatRecord.setIndentionOptions((short) 0);
        extendedFormatRecord.setBorderOptions((short) 0);
        extendedFormatRecord.setPaletteOptions((short) 0);
        extendedFormatRecord.setAdtlPaletteOptions((short) 0);
        extendedFormatRecord.setFillPaletteOptions((short) 8384);
        extendedFormatRecord.setTopBorderPaletteIdx(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        extendedFormatRecord.setBottomBorderPaletteIdx(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        extendedFormatRecord.setLeftBorderPaletteIdx(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        extendedFormatRecord.setRightBorderPaletteIdx(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        return extendedFormatRecord;
    }

    private static StyleRecord createStyle(int i) {
        int[][] iArr = {new int[]{16, 3}, new int[]{17, 6}, new int[]{18, 4}, new int[]{19, 7}, new int[]{0, 0}, new int[]{20, 5}};
        if (i < 0 || i >= 6) {
            throw new IllegalArgumentException("Unexpected style id " + i);
        }
        StyleRecord styleRecord = new StyleRecord();
        styleRecord.setOutlineStyleLevel(-1);
        styleRecord.setXFIndex(iArr[i][0]);
        styleRecord.setBuiltinStyle(iArr[i][1]);
        return styleRecord;
    }

    private static PaletteRecord createPalette() {
        return new PaletteRecord();
    }

    private static UseSelFSRecord createUseSelFS() {
        return new UseSelFSRecord(false);
    }

    private static BoundSheetRecord createBoundSheet(int i) {
        return new BoundSheetRecord("Sheet" + (i + 1));
    }

    private static CountryRecord createCountry() {
        CountryRecord countryRecord = new CountryRecord();
        countryRecord.setDefaultCountry((short) 1);
        if ("ru_RU".equals(LocaleUtil.getUserLocale().toString())) {
            countryRecord.setCurrentCountry((short) 7);
        } else {
            countryRecord.setCurrentCountry((short) 1);
        }
        return countryRecord;
    }

    private static ExtSSTRecord createExtendedSST() {
        ExtSSTRecord extSSTRecord = new ExtSSTRecord();
        extSSTRecord.setNumStringsPerBucket((short) 8);
        return extSSTRecord;
    }

    private LinkTable getOrCreateLinkTable() {
        if (this.linkTable == null) {
            this.linkTable = new LinkTable((short) getNumSheets(), this.records);
        }
        return this.linkTable;
    }

    public int linkExternalWorkbook(String str, Workbook workbook) {
        return getOrCreateLinkTable().linkExternalWorkbook(str, workbook);
    }

    public String findSheetFirstNameFromExternSheet(int i) {
        return findSheetNameFromIndex(this.linkTable.getFirstInternalSheetIndexForExtIndex(i));
    }

    public String findSheetLastNameFromExternSheet(int i) {
        return findSheetNameFromIndex(this.linkTable.getLastInternalSheetIndexForExtIndex(i));
    }

    private String findSheetNameFromIndex(int i) {
        return (i >= 0 && i < this.boundsheets.size()) ? getSheetName(i) : "";
    }

    public EvaluationWorkbook.ExternalSheet getExternalSheet(int i) {
        String[] externalBookAndSheetName = this.linkTable.getExternalBookAndSheetName(i);
        if (externalBookAndSheetName == null) {
            return null;
        }
        if (externalBookAndSheetName.length == 2) {
            return new EvaluationWorkbook.ExternalSheet(externalBookAndSheetName[0], externalBookAndSheetName[1]);
        }
        return new EvaluationWorkbook.ExternalSheetRange(externalBookAndSheetName[0], externalBookAndSheetName[1], externalBookAndSheetName[2]);
    }

    public EvaluationWorkbook.ExternalName getExternalName(int i, int i2) {
        String strResolveNameXText = this.linkTable.resolveNameXText(i, i2, this);
        if (strResolveNameXText == null) {
            return null;
        }
        return new EvaluationWorkbook.ExternalName(strResolveNameXText, i2, this.linkTable.resolveNameXIx(i, i2));
    }

    public int getFirstSheetIndexFromExternSheetIndex(int i) {
        return this.linkTable.getFirstInternalSheetIndexForExtIndex(i);
    }

    public int getLastSheetIndexFromExternSheetIndex(int i) {
        return this.linkTable.getLastInternalSheetIndexForExtIndex(i);
    }

    public short checkExternSheet(int i) {
        return (short) getOrCreateLinkTable().checkExternSheet(i);
    }

    public short checkExternSheet(int i, int i2) {
        return (short) getOrCreateLinkTable().checkExternSheet(i, i2);
    }

    public int getExternalSheetIndex(String str, String str2) {
        return getOrCreateLinkTable().getExternalSheetIndex(str, str2, str2);
    }

    public int getExternalSheetIndex(String str, String str2, String str3) {
        return getOrCreateLinkTable().getExternalSheetIndex(str, str2, str3);
    }

    public int getNumNames() {
        LinkTable linkTable = this.linkTable;
        if (linkTable == null) {
            return 0;
        }
        return linkTable.getNumNames();
    }

    public NameRecord getNameRecord(int i) {
        return this.linkTable.getNameRecord(i);
    }

    public NameCommentRecord getNameCommentRecord(NameRecord nameRecord) {
        return this.commentRecords.get(nameRecord.getNameText());
    }

    public NameRecord createName() {
        return addName(new NameRecord());
    }

    public NameRecord addName(NameRecord nameRecord) {
        getOrCreateLinkTable().addName(nameRecord);
        return nameRecord;
    }

    public NameRecord createBuiltInName(byte b, int i) {
        if (i < 0 || i + 1 > 32767) {
            throw new IllegalArgumentException("Sheet number [" + i + "]is not valid ");
        }
        NameRecord nameRecord = new NameRecord(b, i);
        if (this.linkTable.nameAlreadyExists(nameRecord)) {
            throw new RuntimeException("Builtin (" + ((int) b) + ") already exists for sheet (" + i + ")");
        }
        addName(nameRecord);
        return nameRecord;
    }

    public void removeName(int i) {
        if (this.linkTable.getNumNames() > i) {
            this.records.remove(findFirstRecordLocBySid((short) 24) + i);
            this.linkTable.removeName(i);
        }
    }

    public void updateNameCommentRecordCache(NameCommentRecord nameCommentRecord) {
        if (this.commentRecords.containsValue(nameCommentRecord)) {
            for (Map.Entry<String, NameCommentRecord> entry : this.commentRecords.entrySet()) {
                if (entry.getValue().equals(nameCommentRecord)) {
                    this.commentRecords.remove(entry.getKey());
                    break;
                }
            }
        }
        this.commentRecords.put(nameCommentRecord.getNameText(), nameCommentRecord);
    }

    public short getFormat(String str, boolean z) {
        int iCreateFormat;
        for (FormatRecord formatRecord : this.formats) {
            if (formatRecord.getFormatString().equals(str)) {
                iCreateFormat = formatRecord.getIndexCode();
                return (short) iCreateFormat;
            }
        }
        if (!z) {
            return (short) -1;
        }
        iCreateFormat = createFormat(str);
        return (short) iCreateFormat;
    }

    public List<FormatRecord> getFormats() {
        return this.formats;
    }

    public int createFormat(String str) {
        int i = this.maxformatid;
        this.maxformatid = i >= 164 ? i + 1 : 164;
        FormatRecord formatRecord = new FormatRecord(this.maxformatid, str);
        int i2 = 0;
        while (i2 < this.records.size() && this.records.get(i2).getSid() != 1054) {
            i2++;
        }
        int size = i2 + this.formats.size();
        this.formats.add(formatRecord);
        this.records.add(size, formatRecord);
        return this.maxformatid;
    }

    public Record findFirstRecordBySid(short s) {
        for (Record record : this.records.getRecords()) {
            if (record.getSid() == s) {
                return record;
            }
        }
        return null;
    }

    public int findFirstRecordLocBySid(short s) {
        Iterator<Record> it = this.records.getRecords().iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().getSid() == s) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public Record findNextRecordBySid(short s, int i) {
        int i2 = 0;
        for (Record record : this.records.getRecords()) {
            if (record.getSid() == s) {
                int i3 = i2 + 1;
                if (i2 == i) {
                    return record;
                }
                i2 = i3;
            }
        }
        return null;
    }

    public List<HyperlinkRecord> getHyperlinks() {
        return this.hyperlinks;
    }

    public List<Record> getRecords() {
        return this.records.getRecords();
    }

    public boolean isUsing1904DateWindowing() {
        return this.uses1904datewindowing;
    }

    public PaletteRecord getCustomPalette() {
        int palettepos = this.records.getPalettepos();
        if (palettepos != -1) {
            Record record = this.records.get(palettepos);
            if (record instanceof PaletteRecord) {
                return (PaletteRecord) record;
            }
            throw new RuntimeException("InternalError: Expected PaletteRecord but got a '" + record + "'");
        }
        PaletteRecord paletteRecordCreatePalette = createPalette();
        this.records.add(1, paletteRecordCreatePalette);
        this.records.setPalettepos(1);
        return paletteRecordCreatePalette;
    }

    public DrawingManager2 findDrawingGroup() {
        DrawingManager2 drawingManager2 = this.drawingManager;
        if (drawingManager2 != null) {
            return drawingManager2;
        }
        for (Record record : this.records.getRecords()) {
            if (record instanceof DrawingGroupRecord) {
                DrawingGroupRecord drawingGroupRecord = (DrawingGroupRecord) record;
                drawingGroupRecord.processChildRecords();
                DrawingManager2 drawingManager2FindDrawingManager = findDrawingManager(drawingGroupRecord, this.escherBSERecords);
                this.drawingManager = drawingManager2FindDrawingManager;
                if (drawingManager2FindDrawingManager != null) {
                    return drawingManager2FindDrawingManager;
                }
            }
        }
        DrawingManager2 drawingManager2FindDrawingManager2 = findDrawingManager((DrawingGroupRecord) findFirstRecordBySid(DrawingGroupRecord.sid), this.escherBSERecords);
        this.drawingManager = drawingManager2FindDrawingManager2;
        return drawingManager2FindDrawingManager2;
    }

    private static DrawingManager2 findDrawingManager(DrawingGroupRecord drawingGroupRecord, List<EscherBSERecord> list) {
        EscherContainerRecord escherContainer;
        if (drawingGroupRecord == null || (escherContainer = drawingGroupRecord.getEscherContainer()) == null) {
            return null;
        }
        EscherDggRecord escherDggRecord = null;
        EscherContainerRecord escherContainerRecord = null;
        for (EscherRecord escherRecord : escherContainer) {
            if (escherRecord instanceof EscherDggRecord) {
                escherDggRecord = (EscherDggRecord) escherRecord;
            } else if (escherRecord.getRecordId() == -4095) {
                escherContainerRecord = (EscherContainerRecord) escherRecord;
            }
        }
        if (escherDggRecord == null) {
            return null;
        }
        DrawingManager2 drawingManager2 = new DrawingManager2(escherDggRecord);
        if (escherContainerRecord != null) {
            for (EscherRecord escherRecord2 : escherContainerRecord.getChildRecords()) {
                if (escherRecord2 instanceof EscherBSERecord) {
                    list.add((EscherBSERecord) escherRecord2);
                }
            }
        }
        return drawingManager2;
    }

    public void createDrawingGroup() {
        EscherContainerRecord escherContainerRecord;
        if (this.drawingManager == null) {
            EscherContainerRecord escherContainerRecord2 = new EscherContainerRecord();
            EscherDggRecord escherDggRecord = new EscherDggRecord();
            EscherOptRecord escherOptRecord = new EscherOptRecord();
            EscherSplitMenuColorsRecord escherSplitMenuColorsRecord = new EscherSplitMenuColorsRecord();
            escherContainerRecord2.setRecordId(EscherContainerRecord.DGG_CONTAINER);
            escherContainerRecord2.setOptions((short) 15);
            escherDggRecord.setRecordId(EscherDggRecord.RECORD_ID);
            escherDggRecord.setOptions((short) 0);
            escherDggRecord.setShapeIdMax(1024);
            escherDggRecord.setNumShapesSaved(0);
            escherDggRecord.setDrawingsSaved(0);
            escherDggRecord.setFileIdClusters(new EscherDggRecord.FileIdCluster[0]);
            this.drawingManager = new DrawingManager2(escherDggRecord);
            if (this.escherBSERecords.isEmpty()) {
                escherContainerRecord = null;
            } else {
                escherContainerRecord = new EscherContainerRecord();
                escherContainerRecord.setRecordId(EscherContainerRecord.BSTORE_CONTAINER);
                escherContainerRecord.setOptions((short) (15 | (this.escherBSERecords.size() << 4)));
                Iterator<EscherBSERecord> it = this.escherBSERecords.iterator();
                while (it.hasNext()) {
                    escherContainerRecord.addChildRecord(it.next());
                }
            }
            escherOptRecord.setRecordId(EscherOptRecord.RECORD_ID);
            escherOptRecord.setOptions((short) 51);
            escherOptRecord.addEscherProperty(new EscherBoolProperty((short) 191, 524296));
            escherOptRecord.addEscherProperty(new EscherRGBProperty(EscherProperties.FILL__FILLCOLOR, 134217793));
            escherOptRecord.addEscherProperty(new EscherRGBProperty(EscherProperties.LINESTYLE__COLOR, HSSFShape.LINESTYLE__COLOR_DEFAULT));
            escherSplitMenuColorsRecord.setRecordId(EscherSplitMenuColorsRecord.RECORD_ID);
            escherSplitMenuColorsRecord.setOptions((short) 64);
            escherSplitMenuColorsRecord.setColor1(134217741);
            escherSplitMenuColorsRecord.setColor2(134217740);
            escherSplitMenuColorsRecord.setColor3(134217751);
            escherSplitMenuColorsRecord.setColor4(268435703);
            escherContainerRecord2.addChildRecord(escherDggRecord);
            if (escherContainerRecord != null) {
                escherContainerRecord2.addChildRecord(escherContainerRecord);
            }
            escherContainerRecord2.addChildRecord(escherOptRecord);
            escherContainerRecord2.addChildRecord(escherSplitMenuColorsRecord);
            int iFindFirstRecordLocBySid = findFirstRecordLocBySid(DrawingGroupRecord.sid);
            if (iFindFirstRecordLocBySid == -1) {
                DrawingGroupRecord drawingGroupRecord = new DrawingGroupRecord();
                drawingGroupRecord.addEscherRecord(escherContainerRecord2);
                getRecords().add(findFirstRecordLocBySid((short) 140) + 1, drawingGroupRecord);
                return;
            }
            DrawingGroupRecord drawingGroupRecord2 = new DrawingGroupRecord();
            drawingGroupRecord2.addEscherRecord(escherContainerRecord2);
            getRecords().set(iFindFirstRecordLocBySid, drawingGroupRecord2);
        }
    }

    public WindowOneRecord getWindowOne() {
        return this.windowOne;
    }

    public EscherBSERecord getBSERecord(int i) {
        return this.escherBSERecords.get(i - 1);
    }

    public int addBSERecord(EscherBSERecord escherBSERecord) {
        EscherContainerRecord escherContainerRecord;
        createDrawingGroup();
        this.escherBSERecords.add(escherBSERecord);
        EscherContainerRecord escherContainerRecord2 = (EscherContainerRecord) ((DrawingGroupRecord) getRecords().get(findFirstRecordLocBySid(DrawingGroupRecord.sid))).getEscherRecord(0);
        if (escherContainerRecord2.getChild(1).getRecordId() == -4095) {
            escherContainerRecord = (EscherContainerRecord) escherContainerRecord2.getChild(1);
        } else {
            EscherContainerRecord escherContainerRecord3 = new EscherContainerRecord();
            escherContainerRecord3.setRecordId(EscherContainerRecord.BSTORE_CONTAINER);
            List<EscherRecord> childRecords = escherContainerRecord2.getChildRecords();
            childRecords.add(1, escherContainerRecord3);
            escherContainerRecord2.setChildRecords(childRecords);
            escherContainerRecord = escherContainerRecord3;
        }
        escherContainerRecord.setOptions((short) ((this.escherBSERecords.size() << 4) | 15));
        escherContainerRecord.addChildRecord(escherBSERecord);
        return this.escherBSERecords.size();
    }

    public DrawingManager2 getDrawingManager() {
        return this.drawingManager;
    }

    public WriteProtectRecord getWriteProtect() {
        if (this.writeProtect == null) {
            this.writeProtect = new WriteProtectRecord();
            this.records.add(findFirstRecordLocBySid((short) 2057) + 1, this.writeProtect);
        }
        return this.writeProtect;
    }

    public WriteAccessRecord getWriteAccess() {
        if (this.writeAccess == null) {
            this.writeAccess = createWriteAccess();
            this.records.add(findFirstRecordLocBySid(InterfaceEndRecord.sid) + 1, this.writeAccess);
        }
        return this.writeAccess;
    }

    public FileSharingRecord getFileSharing() {
        if (this.fileShare == null) {
            this.fileShare = new FileSharingRecord();
            this.records.add(findFirstRecordLocBySid((short) 92) + 1, this.fileShare);
        }
        return this.fileShare;
    }

    public boolean isWriteProtected() {
        return this.fileShare != null && getFileSharing().getReadOnly() == 1;
    }

    public void writeProtectWorkbook(String str, String str2) {
        FileSharingRecord fileSharing = getFileSharing();
        WriteAccessRecord writeAccess = getWriteAccess();
        getWriteProtect();
        fileSharing.setReadOnly((short) 1);
        fileSharing.setPassword((short) CryptoFunctions.createXorVerifier1(str));
        fileSharing.setUsername(str2);
        writeAccess.setUsername(str2);
    }

    public void unwriteProtectWorkbook() {
        this.records.remove(this.fileShare);
        this.records.remove(this.writeProtect);
        this.fileShare = null;
        this.writeProtect = null;
    }

    public String resolveNameXText(int i, int i2) {
        return this.linkTable.resolveNameXText(i, i2, this);
    }

    public NameXPtg getNameXPtg(String str, int i, UDFFinder uDFFinder) {
        LinkTable orCreateLinkTable = getOrCreateLinkTable();
        NameXPtg nameXPtg = orCreateLinkTable.getNameXPtg(str, i);
        return (nameXPtg != null || uDFFinder.findFunction(str) == null) ? nameXPtg : orCreateLinkTable.addNameXPtg(str);
    }

    public NameXPtg getNameXPtg(String str, UDFFinder uDFFinder) {
        return getNameXPtg(str, -1, uDFFinder);
    }

    public void cloneDrawings(InternalSheet internalSheet) {
        EscherContainerRecord escherContainer;
        EscherSimpleProperty escherSimpleProperty;
        findDrawingGroup();
        DrawingManager2 drawingManager2 = this.drawingManager;
        if (drawingManager2 == null || internalSheet.aggregateDrawingRecords(drawingManager2, false) == -1 || (escherContainer = ((EscherAggregate) internalSheet.findFirstRecordBySid(EscherAggregate.sid)).getEscherContainer()) == null) {
            return;
        }
        EscherDggRecord dgg = this.drawingManager.getDgg();
        short sFindNewDrawingGroupId = this.drawingManager.findNewDrawingGroupId();
        dgg.addCluster(sFindNewDrawingGroupId, 0);
        dgg.setDrawingsSaved(dgg.getDrawingsSaved() + 1);
        EscherDgRecord escherDgRecord = null;
        for (EscherRecord escherRecord : escherContainer) {
            if (escherRecord instanceof EscherDgRecord) {
                EscherDgRecord escherDgRecord2 = (EscherDgRecord) escherRecord;
                escherDgRecord2.setOptions((short) (sFindNewDrawingGroupId << 4));
                escherDgRecord = escherDgRecord2;
            } else if (escherRecord instanceof EscherContainerRecord) {
                Iterator<EscherRecord> it = ((EscherContainerRecord) escherRecord).iterator();
                while (it.hasNext()) {
                    for (EscherRecord escherRecord2 : (EscherContainerRecord) it.next()) {
                        short recordId = escherRecord2.getRecordId();
                        if (recordId == -4086) {
                            if (escherDgRecord == null) {
                                throw new RecordFormatException("EscherDgRecord wasn't set/processed before.");
                            }
                            int iAllocateShapeId = this.drawingManager.allocateShapeId(escherDgRecord);
                            escherDgRecord.setNumShapes(escherDgRecord.getNumShapes() - 1);
                            ((EscherSpRecord) escherRecord2).setShapeId(iAllocateShapeId);
                        } else if (recordId == -4085 && (escherSimpleProperty = (EscherSimpleProperty) ((EscherOptRecord) escherRecord2).lookup(FinalCanbus.CAR_WC2_ChuanQiGA6)) != null) {
                            EscherBSERecord bSERecord = getBSERecord(escherSimpleProperty.getPropertyValue());
                            bSERecord.setRef(bSERecord.getRef() + 1);
                        }
                    }
                }
            } else {
                continue;
            }
        }
    }

    public NameRecord cloneFilter(int i, int i2) {
        NameRecord nameRecord = getNameRecord(i);
        short sCheckExternSheet = checkExternSheet(i2);
        Ptg[] nameDefinition = nameRecord.getNameDefinition();
        for (int i3 = 0; i3 < nameDefinition.length; i3++) {
            Ptg ptg = nameDefinition[i3];
            if (ptg instanceof Area3DPtg) {
                Area3DPtg area3DPtg = (Area3DPtg) ((OperandPtg) ptg).copy();
                area3DPtg.setExternSheetIndex(sCheckExternSheet);
                nameDefinition[i3] = area3DPtg;
            } else if (ptg instanceof Ref3DPtg) {
                Ref3DPtg ref3DPtg = (Ref3DPtg) ((OperandPtg) ptg).copy();
                ref3DPtg.setExternSheetIndex(sCheckExternSheet);
                nameDefinition[i3] = ref3DPtg;
            }
        }
        NameRecord nameRecordCreateBuiltInName = createBuiltInName((byte) 13, i2 + 1);
        nameRecordCreateBuiltInName.setNameDefinition(nameDefinition);
        nameRecordCreateBuiltInName.setHidden(true);
        return nameRecordCreateBuiltInName;
    }

    public void updateNamesAfterCellShift(FormulaShifter formulaShifter) {
        for (int i = 0; i < getNumNames(); i++) {
            NameRecord nameRecord = getNameRecord(i);
            Ptg[] nameDefinition = nameRecord.getNameDefinition();
            if (formulaShifter.adjustFormula(nameDefinition, nameRecord.getSheetNumber())) {
                nameRecord.setNameDefinition(nameDefinition);
            }
        }
    }

    public RecalcIdRecord getRecalcId() {
        RecalcIdRecord recalcIdRecord = (RecalcIdRecord) findFirstRecordBySid((short) 449);
        if (recalcIdRecord != null) {
            return recalcIdRecord;
        }
        RecalcIdRecord recalcIdRecord2 = new RecalcIdRecord();
        this.records.add(findFirstRecordLocBySid((short) 140) + 1, recalcIdRecord2);
        return recalcIdRecord2;
    }

    public boolean changeExternalReference(String str, String str2) {
        return this.linkTable.changeExternalReference(str, str2);
    }

    @Internal
    public WorkbookRecordList getWorkbookRecordList() {
        return this.records;
    }
}
