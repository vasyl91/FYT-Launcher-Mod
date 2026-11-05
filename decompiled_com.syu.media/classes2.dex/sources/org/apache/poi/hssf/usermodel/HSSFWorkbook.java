package org.apache.poi.hssf.usermodel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;
import module.canbus.FinalCanbus;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.POIDocument;
import org.apache.poi.ddf.EscherBSERecord;
import org.apache.poi.ddf.EscherBitmapBlip;
import org.apache.poi.ddf.EscherBlipRecord;
import org.apache.poi.ddf.EscherMetafileBlip;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.hpsf.ClassID;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.OldExcelFormatException;
import org.apache.poi.hssf.model.HSSFFormulaParser;
import org.apache.poi.hssf.model.InternalSheet;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.model.WorkbookRecordList;
import org.apache.poi.hssf.record.AbstractEscherHolderRecord;
import org.apache.poi.hssf.record.DrawingGroupRecord;
import org.apache.poi.hssf.record.FilePassRecord;
import org.apache.poi.hssf.record.LabelRecord;
import org.apache.poi.hssf.record.LabelSSTRecord;
import org.apache.poi.hssf.record.NameRecord;
import org.apache.poi.hssf.record.RecalcIdRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordFactory;
import org.apache.poi.hssf.record.UnknownRecord;
import org.apache.poi.hssf.record.aggregates.RecordAggregate;
import org.apache.poi.hssf.record.common.UnicodeString;
import org.apache.poi.hssf.record.crypto.Biff8DecryptingStream;
import org.apache.poi.hssf.record.crypto.Biff8EncryptionKey;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.poifs.crypt.ChunkedCipherOutputStream;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.EncryptionVerifier;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentNode;
import org.apache.poi.poifs.filesystem.EntryUtils;
import org.apache.poi.poifs.filesystem.FilteringDirectoryNode;
import org.apache.poi.poifs.filesystem.NPOIFSDocument;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.poifs.filesystem.Ole10Native;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.FormulaShifter;
import org.apache.poi.ss.formula.FormulaType;
import org.apache.poi.ss.formula.SheetNameFormatter;
import org.apache.poi.ss.formula.ptg.IntPtg;
import org.apache.poi.ss.formula.ptg.IntersectionPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.StringPtg;
import org.apache.poi.ss.formula.ptg.UnaryPlusPtg;
import org.apache.poi.ss.formula.ptg.UnionPtg;
import org.apache.poi.ss.formula.udf.AggregatingUDFFinder;
import org.apache.poi.ss.formula.udf.IndexedUDFFinder;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Shape;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.SheetVisibility;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.Configurator;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianByteArrayInputStream;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.Removal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class HSSFWorkbook extends POIDocument implements Workbook {
    private static final int DEBUG = 1;
    private static final int MAX_STYLES = 4030;
    protected List<HSSFSheet> _sheets;
    private UDFFinder _udfFinder;
    private Map<Short, HSSFFont> fonts;
    private HSSFDataFormat formatter;
    private Row.MissingCellPolicy missingCellPolicy;
    private ArrayList<HSSFName> names;
    private boolean preserveNodes;
    private InternalWorkbook workbook;
    private static final Pattern COMMA_PATTERN = Pattern.compile(",");
    public static final int INITIAL_CAPACITY = Configurator.getIntValue("HSSFWorkbook.SheetInitialCapacity", 3);
    private static final POILogger log = POILogFactory.getLogger((Class<?>) HSSFWorkbook.class);

    public static HSSFWorkbook create(InternalWorkbook internalWorkbook) {
        return new HSSFWorkbook(internalWorkbook);
    }

    public HSSFWorkbook() {
        this(InternalWorkbook.createWorkbook());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private HSSFWorkbook(InternalWorkbook internalWorkbook) {
        super((DirectoryNode) null);
        this.missingCellPolicy = Row.MissingCellPolicy.RETURN_NULL_AND_BLANK;
        this._udfFinder = new IndexedUDFFinder(AggregatingUDFFinder.DEFAULT);
        this.workbook = internalWorkbook;
        int i = INITIAL_CAPACITY;
        this._sheets = new ArrayList(i);
        this.names = new ArrayList<>(i);
    }

    public HSSFWorkbook(POIFSFileSystem pOIFSFileSystem) throws IOException {
        this(pOIFSFileSystem, true);
    }

    public HSSFWorkbook(NPOIFSFileSystem nPOIFSFileSystem) throws IOException {
        this(nPOIFSFileSystem.getRoot(), true);
    }

    public HSSFWorkbook(POIFSFileSystem pOIFSFileSystem, boolean z) throws IOException {
        this(pOIFSFileSystem.getRoot(), pOIFSFileSystem, z);
    }

    public static String getWorkbookDirEntryName(DirectoryNode directoryNode) {
        for (String str : InternalWorkbook.WORKBOOK_DIR_ENTRY_NAMES) {
            try {
                directoryNode.getEntry(str);
                return str;
            } catch (FileNotFoundException unused) {
            }
        }
        try {
            try {
                directoryNode.getEntry(Decryptor.DEFAULT_POIFS_ENTRY);
                throw new EncryptedDocumentException("The supplied spreadsheet seems to be an Encrypted .xlsx file. It must be decrypted before use by XSSF, it cannot be used by HSSF");
            } catch (FileNotFoundException unused2) {
                throw new IllegalArgumentException("The supplied POIFSFileSystem does not contain a BIFF8 'Workbook' entry. Is it really an excel file? Had: " + directoryNode.getEntryNames());
            }
        } catch (FileNotFoundException unused3) {
            directoryNode.getEntry(InternalWorkbook.OLD_WORKBOOK_DIR_ENTRY_NAME);
            throw new OldExcelFormatException("The supplied spreadsheet seems to be Excel 5.0/7.0 (BIFF5) format. POI only supports BIFF8 format (from Excel versions 97/2000/XP/2003)");
        }
    }

    public HSSFWorkbook(DirectoryNode directoryNode, POIFSFileSystem pOIFSFileSystem, boolean z) throws IOException {
        this(directoryNode, z);
    }

    public HSSFWorkbook(DirectoryNode directoryNode, boolean z) throws IOException {
        super(directoryNode);
        this.missingCellPolicy = Row.MissingCellPolicy.RETURN_NULL_AND_BLANK;
        this._udfFinder = new IndexedUDFFinder(AggregatingUDFFinder.DEFAULT);
        String workbookDirEntryName = getWorkbookDirEntryName(directoryNode);
        this.preserveNodes = z;
        if (!z) {
            clearDirectory();
        }
        int i = INITIAL_CAPACITY;
        this._sheets = new ArrayList(i);
        this.names = new ArrayList<>(i);
        List<Record> listCreateRecords = RecordFactory.createRecords(directoryNode.createDocumentInputStream(workbookDirEntryName));
        InternalWorkbook internalWorkbookCreateWorkbook = InternalWorkbook.createWorkbook(listCreateRecords);
        this.workbook = internalWorkbookCreateWorkbook;
        setPropertiesFromWorkbook(internalWorkbookCreateWorkbook);
        int numRecords = this.workbook.getNumRecords();
        convertLabelRecords(listCreateRecords, numRecords);
        RecordStream recordStream = new RecordStream(listCreateRecords, numRecords);
        while (recordStream.hasNext()) {
            try {
                this._sheets.add(new HSSFSheet(this, InternalSheet.createSheet(recordStream)));
            } catch (InternalSheet.UnsupportedBOFType e) {
                log.log(5, "Unsupported BOF found of type " + e.getType());
            }
        }
        for (int i2 = 0; i2 < this.workbook.getNumNames(); i2++) {
            NameRecord nameRecord = this.workbook.getNameRecord(i2);
            this.names.add(new HSSFName(this, nameRecord, this.workbook.getNameCommentRecord(nameRecord)));
        }
    }

    public HSSFWorkbook(InputStream inputStream) throws IOException {
        this(inputStream, true);
    }

    public HSSFWorkbook(InputStream inputStream, boolean z) throws IOException {
        this(new NPOIFSFileSystem(inputStream).getRoot(), z);
    }

    private void setPropertiesFromWorkbook(InternalWorkbook internalWorkbook) {
        this.workbook = internalWorkbook;
    }

    private void convertLabelRecords(List<Record> list, int i) {
        POILogger pOILogger = log;
        if (pOILogger.check(1)) {
            pOILogger.log(1, "convertLabelRecords called");
        }
        while (i < list.size()) {
            Record record = list.get(i);
            if (record.getSid() == 516) {
                LabelRecord labelRecord = (LabelRecord) record;
                list.remove(i);
                LabelSSTRecord labelSSTRecord = new LabelSSTRecord();
                int iAddSSTString = this.workbook.addSSTString(new UnicodeString(labelRecord.getValue()));
                labelSSTRecord.setRow(labelRecord.getRow());
                labelSSTRecord.setColumn(labelRecord.getColumn());
                labelSSTRecord.setXFIndex(labelRecord.getXFIndex());
                labelSSTRecord.setSSTIndex(iAddSSTString);
                list.add(i, labelSSTRecord);
            }
            i++;
        }
        POILogger pOILogger2 = log;
        if (pOILogger2.check(1)) {
            pOILogger2.log(1, "convertLabelRecords exit");
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Row.MissingCellPolicy getMissingCellPolicy() {
        return this.missingCellPolicy;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setMissingCellPolicy(Row.MissingCellPolicy missingCellPolicy) {
        this.missingCellPolicy = missingCellPolicy;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSheetOrder(String str, int i) {
        int sheetIndex = getSheetIndex(str);
        List<HSSFSheet> list = this._sheets;
        list.add(i, list.remove(sheetIndex));
        this.workbook.setSheetOrder(str, i);
        FormulaShifter formulaShifterCreateForSheetShift = FormulaShifter.createForSheetShift(sheetIndex, i);
        Iterator<HSSFSheet> it = this._sheets.iterator();
        while (it.hasNext()) {
            it.next().getSheet().updateFormulasAfterCellShift(formulaShifterCreateForSheetShift, -1);
        }
        this.workbook.updateNamesAfterCellShift(formulaShifterCreateForSheetShift);
        updateNamedRangesAfterSheetReorder(sheetIndex, i);
        updateActiveSheetAfterSheetReorder(sheetIndex, i);
    }

    private void updateNamedRangesAfterSheetReorder(int i, int i2) {
        for (HSSFName hSSFName : this.names) {
            int sheetIndex = hSSFName.getSheetIndex();
            if (sheetIndex != -1) {
                if (sheetIndex == i) {
                    hSSFName.setSheetIndex(i2);
                } else if (i2 <= sheetIndex && sheetIndex < i) {
                    hSSFName.setSheetIndex(sheetIndex + 1);
                } else if (i < sheetIndex && sheetIndex <= i2) {
                    hSSFName.setSheetIndex(sheetIndex - 1);
                }
            }
        }
    }

    private void updateActiveSheetAfterSheetReorder(int i, int i2) {
        int activeSheetIndex = getActiveSheetIndex();
        if (activeSheetIndex == i) {
            setActiveSheet(i2);
            return;
        }
        if (activeSheetIndex >= i || activeSheetIndex >= i2) {
            if (activeSheetIndex <= i || activeSheetIndex <= i2) {
                if (i2 > i) {
                    setActiveSheet(activeSheetIndex - 1);
                } else {
                    setActiveSheet(activeSheetIndex + 1);
                }
            }
        }
    }

    private void validateSheetIndex(int i) {
        int size = this._sheets.size() - 1;
        if (i < 0 || i > size) {
            String str = "(0.." + size + ")";
            if (size == -1) {
                str = "(no sheets)";
            }
            throw new IllegalArgumentException("Sheet index (" + i + ") is out of range " + str);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSelectedTab(int i) {
        validateSheetIndex(i);
        int size = this._sheets.size();
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 < size) {
                HSSFSheet sheetAt = getSheetAt(i2);
                if (i2 != i) {
                    z = false;
                }
                sheetAt.setSelected(z);
                i2++;
            } else {
                this.workbook.getWindowOne().setNumSelectedTabs((short) 1);
                return;
            }
        }
    }

    public void setSelectedTabs(int[] iArr) {
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        setSelectedTabs(arrayList);
    }

    public void setSelectedTabs(Collection<Integer> collection) {
        Iterator<Integer> it = collection.iterator();
        while (it.hasNext()) {
            validateSheetIndex(it.next().intValue());
        }
        HashSet hashSet = new HashSet(collection);
        int size = this._sheets.size();
        for (int i = 0; i < size; i++) {
            getSheetAt(i).setSelected(hashSet.contains(Integer.valueOf(i)));
        }
        this.workbook.getWindowOne().setNumSelectedTabs((short) hashSet.size());
    }

    public Collection<Integer> getSelectedTabs() {
        ArrayList arrayList = new ArrayList();
        int size = this._sheets.size();
        for (int i = 0; i < size; i++) {
            if (getSheetAt(i).isSelected()) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setActiveSheet(int i) {
        validateSheetIndex(i);
        int size = this._sheets.size();
        int i2 = 0;
        while (i2 < size) {
            getSheetAt(i2).setActive(i2 == i);
            i2++;
        }
        this.workbook.getWindowOne().setActiveSheetIndex(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getActiveSheetIndex() {
        return this.workbook.getWindowOne().getActiveSheetIndex();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setFirstVisibleTab(int i) {
        this.workbook.getWindowOne().setFirstVisibleTab(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getFirstVisibleTab() {
        return this.workbook.getWindowOne().getFirstVisibleTab();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSheetName(int i, String str) {
        if (str == null) {
            throw new IllegalArgumentException("sheetName must not be null");
        }
        if (this.workbook.doesContainsSheetName(str, i)) {
            throw new IllegalArgumentException("The workbook already contains a sheet named '" + str + "'");
        }
        validateSheetIndex(i);
        this.workbook.setSheetName(i, str);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public String getSheetName(int i) {
        validateSheetIndex(i);
        return this.workbook.getSheetName(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public boolean isHidden() {
        return this.workbook.getWindowOne().getHidden();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setHidden(boolean z) {
        this.workbook.getWindowOne().setHidden(z);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public boolean isSheetHidden(int i) {
        validateSheetIndex(i);
        return this.workbook.isSheetHidden(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public boolean isSheetVeryHidden(int i) {
        validateSheetIndex(i);
        return this.workbook.isSheetVeryHidden(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public SheetVisibility getSheetVisibility(int i) {
        return this.workbook.getSheetVisibility(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSheetHidden(int i, boolean z) {
        setSheetVisibility(i, z ? SheetVisibility.HIDDEN : SheetVisibility.VISIBLE);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    @Removal(version = "3.18")
    @Deprecated
    public void setSheetHidden(int i, int i2) {
        if (i2 == 0) {
            setSheetVisibility(i, SheetVisibility.VISIBLE);
        } else if (i2 == 1) {
            setSheetVisibility(i, SheetVisibility.HIDDEN);
        } else {
            if (i2 == 2) {
                setSheetVisibility(i, SheetVisibility.VERY_HIDDEN);
                return;
            }
            throw new IllegalArgumentException("Invalid sheet state : " + i2 + "\nSheet state must beone of the Workbook.SHEET_STATE_* constants");
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSheetVisibility(int i, SheetVisibility sheetVisibility) {
        validateSheetIndex(i);
        this.workbook.setSheetHidden(i, sheetVisibility);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getSheetIndex(String str) {
        return this.workbook.getSheetIndex(str);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getSheetIndex(Sheet sheet) {
        return this._sheets.indexOf(sheet);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFSheet createSheet() {
        HSSFSheet hSSFSheet = new HSSFSheet(this);
        this._sheets.add(hSSFSheet);
        this.workbook.setSheetName(this._sheets.size() - 1, "Sheet" + (this._sheets.size() - 1));
        boolean z = this._sheets.size() == 1;
        hSSFSheet.setSelected(z);
        hSSFSheet.setActive(z);
        return hSSFSheet;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFSheet cloneSheet(int i) {
        validateSheetIndex(i);
        HSSFSheet hSSFSheet = this._sheets.get(i);
        String sheetName = this.workbook.getSheetName(i);
        HSSFSheet hSSFSheetCloneSheet = hSSFSheet.cloneSheet(this);
        hSSFSheetCloneSheet.setSelected(false);
        hSSFSheetCloneSheet.setActive(false);
        String uniqueSheetName = getUniqueSheetName(sheetName);
        int size = this._sheets.size();
        this._sheets.add(hSSFSheetCloneSheet);
        this.workbook.setSheetName(size, uniqueSheetName);
        int iFindExistingBuiltinNameRecordIdx = findExistingBuiltinNameRecordIdx(i, (byte) 13);
        if (iFindExistingBuiltinNameRecordIdx != -1) {
            this.names.add(new HSSFName(this, this.workbook.cloneFilter(iFindExistingBuiltinNameRecordIdx, size)));
        }
        return hSSFSheetCloneSheet;
    }

    private String getUniqueSheetName(String str) {
        int i;
        String str2;
        int iLastIndexOf = str.lastIndexOf(40);
        if (iLastIndexOf <= 0 || !str.endsWith(")")) {
            i = 2;
        } else {
            try {
                i = Integer.parseInt(str.substring(iLastIndexOf + 1, str.length() - 1).trim()) + 1;
                try {
                    str = str.substring(0, iLastIndexOf).trim();
                } catch (NumberFormatException unused) {
                }
            } catch (NumberFormatException unused2) {
                i = 2;
            }
        }
        while (true) {
            int i2 = i + 1;
            String string = Integer.toString(i);
            if (str.length() + string.length() + 2 < 31) {
                str2 = str + " (" + string + ")";
            } else {
                str2 = str.substring(0, (31 - string.length()) - 2) + "(" + string + ")";
            }
            if (this.workbook.getSheetIndex(str2) == -1) {
                return str2;
            }
            i = i2;
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFSheet createSheet(String str) {
        if (str == null) {
            throw new IllegalArgumentException("sheetName must not be null");
        }
        if (this.workbook.doesContainsSheetName(str, this._sheets.size())) {
            throw new IllegalArgumentException("The workbook already contains a sheet named '" + str + "'");
        }
        HSSFSheet hSSFSheet = new HSSFSheet(this);
        this.workbook.setSheetName(this._sheets.size(), str);
        this._sheets.add(hSSFSheet);
        boolean z = this._sheets.size() == 1;
        hSSFSheet.setSelected(z);
        hSSFSheet.setActive(z);
        return hSSFSheet;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Iterator<Sheet> sheetIterator() {
        return new SheetIterator();
    }

    @Override // java.lang.Iterable
    public Iterator<Sheet> iterator() {
        return sheetIterator();
    }

    private final class SheetIterator<T extends Sheet> implements Iterator<T> {
        private T cursor = null;
        private final Iterator<T> it;

        public SheetIterator() {
            this.it = HSSFWorkbook.this._sheets.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.it.hasNext();
        }

        @Override // java.util.Iterator
        public T next() throws NoSuchElementException {
            T next = this.it.next();
            this.cursor = next;
            return next;
        }

        @Override // java.util.Iterator
        public void remove() throws IllegalStateException {
            throw new UnsupportedOperationException("remove method not supported on HSSFWorkbook.iterator(). Use Sheet.removeSheetAt(int) instead.");
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getNumberOfSheets() {
        return this._sheets.size();
    }

    private HSSFSheet[] getSheets() {
        HSSFSheet[] hSSFSheetArr = new HSSFSheet[this._sheets.size()];
        this._sheets.toArray(hSSFSheetArr);
        return hSSFSheetArr;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFSheet getSheetAt(int i) {
        validateSheetIndex(i);
        return this._sheets.get(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFSheet getSheet(String str) {
        HSSFSheet hSSFSheet = null;
        for (int i = 0; i < this._sheets.size(); i++) {
            if (this.workbook.getSheetName(i).equalsIgnoreCase(str)) {
                hSSFSheet = this._sheets.get(i);
            }
        }
        return hSSFSheet;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void removeSheetAt(int i) {
        validateSheetIndex(i);
        boolean zIsSelected = getSheetAt(i).isSelected();
        this._sheets.remove(i);
        this.workbook.removeSheet(i);
        int size = this._sheets.size();
        if (size < 1) {
            return;
        }
        int i2 = i >= size ? size - 1 : i;
        if (zIsSelected) {
            boolean z = false;
            for (int i3 = 0; i3 < size; i3++) {
                if (getSheetAt(i3).isSelected()) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                setSelectedTab(i2);
            }
        }
        int activeSheetIndex = getActiveSheetIndex();
        if (activeSheetIndex == i) {
            setActiveSheet(i2);
        } else if (activeSheetIndex > i) {
            setActiveSheet(activeSheetIndex - 1);
        }
    }

    public void setBackupFlag(boolean z) {
        this.workbook.getBackupRecord().setBackup(z ? (short) 1 : (short) 0);
    }

    public boolean getBackupFlag() {
        return this.workbook.getBackupRecord().getBackup() != 0;
    }

    int findExistingBuiltinNameRecordIdx(int i, byte b) {
        for (int i2 = 0; i2 < this.names.size(); i2++) {
            NameRecord nameRecord = this.workbook.getNameRecord(i2);
            if (nameRecord == null) {
                throw new RuntimeException("Unable to find all defined names to iterate over");
            }
            if (nameRecord.isBuiltInName() && nameRecord.getBuiltInName() == b && nameRecord.getSheetNumber() - 1 == i) {
                return i2;
            }
        }
        return -1;
    }

    HSSFName createBuiltInName(byte b, int i) {
        HSSFName hSSFName = new HSSFName(this, this.workbook.createBuiltInName(b, i + 1), null);
        this.names.add(hSSFName);
        return hSSFName;
    }

    HSSFName getBuiltInName(byte b, int i) {
        int iFindExistingBuiltinNameRecordIdx = findExistingBuiltinNameRecordIdx(i, b);
        if (iFindExistingBuiltinNameRecordIdx < 0) {
            return null;
        }
        return this.names.get(iFindExistingBuiltinNameRecordIdx);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFFont createFont() {
        this.workbook.createNewFont();
        short numberOfFonts = (short) (getNumberOfFonts() - 1);
        if (numberOfFonts > 3) {
            numberOfFonts = (short) (numberOfFonts + 1);
        }
        if (numberOfFonts == Short.MAX_VALUE) {
            throw new IllegalArgumentException("Maximum number of fonts was exceeded");
        }
        return getFontAt(numberOfFonts);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFFont findFont(boolean z, short s, short s2, String str, boolean z2, boolean z3, short s3, byte b) {
        short numberOfFonts = getNumberOfFonts();
        for (short s4 = 0; s4 <= numberOfFonts; s4 = (short) (s4 + 1)) {
            if (s4 != 4) {
                HSSFFont fontAt = getFontAt(s4);
                if (fontAt.getBold() == z && fontAt.getColor() == s && fontAt.getFontHeight() == s2 && fontAt.getFontName().equals(str) && fontAt.getItalic() == z2 && fontAt.getStrikeout() == z3 && fontAt.getTypeOffset() == s3 && fontAt.getUnderline() == b) {
                    return fontAt;
                }
            }
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public short getNumberOfFonts() {
        return (short) this.workbook.getNumberOfFontRecords();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFFont getFontAt(short s) {
        if (this.fonts == null) {
            this.fonts = new HashMap();
        }
        Short shValueOf = Short.valueOf(s);
        if (this.fonts.containsKey(shValueOf)) {
            return this.fonts.get(shValueOf);
        }
        HSSFFont hSSFFont = new HSSFFont(s, this.workbook.getFontRecordAt(s));
        this.fonts.put(shValueOf, hSSFFont);
        return hSSFFont;
    }

    protected void resetFontCache() {
        this.fonts = new HashMap();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFCellStyle createCellStyle() {
        if (this.workbook.getNumExFormats() == MAX_STYLES) {
            throw new IllegalStateException("The maximum number of cell styles was exceeded. You can define up to 4000 styles in a .xls workbook");
        }
        return new HSSFCellStyle((short) (getNumCellStyles() - 1), this.workbook.createCellXF(), this);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getNumCellStyles() {
        return this.workbook.getNumExFormats();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFCellStyle getCellStyleAt(int i) {
        return new HSSFCellStyle((short) i, this.workbook.getExFormatAt(i), this);
    }

    @Override // org.apache.poi.POIDocument, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
    }

    @Override // org.apache.poi.POIDocument
    public void write() throws IOException {
        validateInPlaceWritePossible();
        DirectoryNode directory = getDirectory();
        new NPOIFSDocument((DocumentNode) directory.getEntry(getWorkbookDirEntryName(directory))).replaceContents(new ByteArrayInputStream(getBytes()));
        writeProperties();
        directory.getFileSystem().writeFilesystem();
    }

    @Override // org.apache.poi.POIDocument
    public void write(File file) throws IOException {
        POIFSFileSystem pOIFSFileSystemCreate = POIFSFileSystem.create(file);
        try {
            write(pOIFSFileSystemCreate);
            pOIFSFileSystemCreate.writeFilesystem();
        } finally {
            pOIFSFileSystemCreate.close();
        }
    }

    @Override // org.apache.poi.POIDocument
    public void write(OutputStream outputStream) throws IOException {
        NPOIFSFileSystem nPOIFSFileSystem = new NPOIFSFileSystem();
        try {
            write(nPOIFSFileSystem);
            nPOIFSFileSystem.writeFilesystem(outputStream);
        } finally {
            nPOIFSFileSystem.close();
        }
    }

    private void write(NPOIFSFileSystem nPOIFSFileSystem) throws IOException {
        ArrayList arrayList = new ArrayList(1);
        nPOIFSFileSystem.createDocument(new ByteArrayInputStream(getBytes()), "Workbook");
        writeProperties(nPOIFSFileSystem, arrayList);
        if (this.preserveNodes) {
            arrayList.addAll(Arrays.asList(InternalWorkbook.WORKBOOK_DIR_ENTRY_NAMES));
            arrayList.addAll(Arrays.asList(DocumentSummaryInformation.DEFAULT_STREAM_NAME, SummaryInformation.DEFAULT_STREAM_NAME, getEncryptedPropertyStreamName()));
            EntryUtils.copyNodes(new FilteringDirectoryNode(getDirectory(), arrayList), new FilteringDirectoryNode(nPOIFSFileSystem.getRoot(), arrayList));
            nPOIFSFileSystem.getRoot().setStorageClsid(getDirectory().getStorageClsid());
        }
    }

    private static final class SheetRecordCollector implements RecordAggregate.RecordVisitor {
        private int _totalSize = 0;
        private List<Record> _list = new ArrayList(128);

        public int getTotalSize() {
            return this._totalSize;
        }

        @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate.RecordVisitor
        public void visitRecord(Record record) {
            this._list.add(record);
            this._totalSize += record.getRecordSize();
        }

        public int serialize(int i, byte[] bArr) {
            Iterator<Record> it = this._list.iterator();
            int iSerialize = 0;
            while (it.hasNext()) {
                iSerialize += it.next().serialize(i + iSerialize, bArr);
            }
            return iSerialize;
        }
    }

    public byte[] getBytes() {
        POILogger pOILogger = log;
        if (pOILogger.check(1)) {
            pOILogger.log(1, "HSSFWorkbook.getBytes()");
        }
        HSSFSheet[] sheets = getSheets();
        int length = sheets.length;
        updateEncryptionInfo();
        this.workbook.preSerialize();
        for (HSSFSheet hSSFSheet : sheets) {
            hSSFSheet.getSheet().preSerialize();
            hSSFSheet.preSerialize();
        }
        int size = this.workbook.getSize();
        SheetRecordCollector[] sheetRecordCollectorArr = new SheetRecordCollector[length];
        for (int i = 0; i < length; i++) {
            this.workbook.setSheetBof(i, size);
            SheetRecordCollector sheetRecordCollector = new SheetRecordCollector();
            sheets[i].getSheet().visitContainedRecords(sheetRecordCollector, size);
            size += sheetRecordCollector.getTotalSize();
            sheetRecordCollectorArr[i] = sheetRecordCollector;
        }
        byte[] bArr = new byte[size];
        int iSerialize = this.workbook.serialize(0, bArr);
        for (int i2 = 0; i2 < length; i2++) {
            SheetRecordCollector sheetRecordCollector2 = sheetRecordCollectorArr[i2];
            int iSerialize2 = sheetRecordCollector2.serialize(iSerialize, bArr);
            if (iSerialize2 != sheetRecordCollector2.getTotalSize()) {
                throw new IllegalStateException("Actual serialized sheet size (" + iSerialize2 + ") differs from pre-calculated size (" + sheetRecordCollector2.getTotalSize() + ") for sheet (" + i2 + ")");
            }
            iSerialize += iSerialize2;
        }
        encryptBytes(bArr);
        return bArr;
    }

    protected void encryptBytes(byte[] bArr) {
        EncryptionInfo encryptionInfo = getEncryptionInfo();
        if (encryptionInfo == null) {
            return;
        }
        Encryptor encryptor = encryptionInfo.getEncryptor();
        LittleEndianByteArrayInputStream littleEndianByteArrayInputStream = new LittleEndianByteArrayInputStream(bArr, 0);
        LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream = new LittleEndianByteArrayOutputStream(bArr, 0);
        encryptor.setChunkSize(1024);
        byte[] bArr2 = new byte[1024];
        try {
            ChunkedCipherOutputStream dataStream = encryptor.getDataStream(littleEndianByteArrayOutputStream, 0);
            int i = 0;
            while (i < bArr.length) {
                littleEndianByteArrayInputStream.read(bArr2, 0, 4);
                int uShort = LittleEndian.getUShort(bArr2, 0);
                int uShort2 = LittleEndian.getUShort(bArr2, 2);
                boolean zIsNeverEncryptedRecord = Biff8DecryptingStream.isNeverEncryptedRecord(uShort);
                dataStream.setNextRecordSize(uShort2, zIsNeverEncryptedRecord);
                dataStream.writePlain(bArr2, 0, 4);
                if (uShort == 133) {
                    byte[] bArr3 = new byte[uShort2];
                    littleEndianByteArrayInputStream.readFully(bArr3);
                    dataStream.writePlain(bArr3, 0, 4);
                    dataStream.write(bArr3, 4, uShort2 - 4);
                } else {
                    int i2 = uShort2;
                    while (i2 > 0) {
                        int iMin = Math.min(i2, 1024);
                        littleEndianByteArrayInputStream.readFully(bArr2, 0, iMin);
                        if (zIsNeverEncryptedRecord) {
                            dataStream.writePlain(bArr2, 0, iMin);
                        } else {
                            dataStream.write(bArr2, 0, iMin);
                        }
                        i2 -= iMin;
                    }
                }
                i += uShort2 + 4;
            }
            dataStream.close();
        } catch (Exception e) {
            throw new EncryptedDocumentException(e);
        }
    }

    InternalWorkbook getWorkbook() {
        return this.workbook;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getNumberOfNames() {
        return this.names.size();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFName getName(String str) {
        int nameIndex = getNameIndex(str);
        if (nameIndex < 0) {
            return null;
        }
        return this.names.get(nameIndex);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public List<HSSFName> getNames(String str) {
        ArrayList arrayList = new ArrayList();
        for (HSSFName hSSFName : this.names) {
            if (hSSFName.getNameName().equals(str)) {
                arrayList.add(hSSFName);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFName getNameAt(int i) {
        int size = this.names.size();
        if (size < 1) {
            throw new IllegalStateException("There are no defined names in this workbook");
        }
        if (i < 0 || i > size) {
            throw new IllegalArgumentException("Specified name index " + i + " is outside the allowable range (0.." + (size - 1) + ").");
        }
        return this.names.get(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public List<HSSFName> getAllNames() {
        return Collections.unmodifiableList(this.names);
    }

    public NameRecord getNameRecord(int i) {
        return getWorkbook().getNameRecord(i);
    }

    public String getNameName(int i) {
        return getNameAt(i).getNameName();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setPrintArea(int i, String str) {
        int i2 = i + 1;
        NameRecord specificBuiltinRecord = this.workbook.getSpecificBuiltinRecord((byte) 6, i2);
        if (specificBuiltinRecord == null) {
            specificBuiltinRecord = this.workbook.createBuiltInName((byte) 6, i2);
        }
        String[] strArrSplit = COMMA_PATTERN.split(str);
        StringBuffer stringBuffer = new StringBuffer(32);
        for (int i3 = 0; i3 < strArrSplit.length; i3++) {
            if (i3 > 0) {
                stringBuffer.append(",");
            }
            SheetNameFormatter.appendFormat(stringBuffer, getSheetName(i));
            stringBuffer.append("!");
            stringBuffer.append(strArrSplit[i3]);
        }
        specificBuiltinRecord.setNameDefinition(HSSFFormulaParser.parse(stringBuffer.toString(), this, FormulaType.NAMEDRANGE, i));
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setPrintArea(int i, int i2, int i3, int i4, int i5) {
        setPrintArea(i, new CellReference(i4, i2, true, true).formatAsString() + ":" + new CellReference(i5, i3, true, true).formatAsString());
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public String getPrintArea(int i) {
        NameRecord specificBuiltinRecord = this.workbook.getSpecificBuiltinRecord((byte) 6, i + 1);
        if (specificBuiltinRecord == null) {
            return null;
        }
        return HSSFFormulaParser.toFormulaString(this, specificBuiltinRecord.getNameDefinition());
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void removePrintArea(int i) {
        getWorkbook().removeBuiltinRecord((byte) 6, i + 1);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFName createName() {
        HSSFName hSSFName = new HSSFName(this, this.workbook.createName());
        this.names.add(hSSFName);
        return hSSFName;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getNameIndex(String str) {
        for (int i = 0; i < this.names.size(); i++) {
            if (getNameName(i).equalsIgnoreCase(str)) {
                return i;
            }
        }
        return -1;
    }

    int getNameIndex(HSSFName hSSFName) {
        for (int i = 0; i < this.names.size(); i++) {
            if (hSSFName == this.names.get(i)) {
                return i;
            }
        }
        return -1;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void removeName(int i) {
        this.names.remove(i);
        this.workbook.removeName(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFDataFormat createDataFormat() {
        if (this.formatter == null) {
            this.formatter = new HSSFDataFormat(this.workbook);
        }
        return this.formatter;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void removeName(String str) {
        removeName(getNameIndex(str));
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void removeName(Name name) {
        removeName(getNameIndex((HSSFName) name));
    }

    public HSSFPalette getCustomPalette() {
        return new HSSFPalette(this.workbook.getCustomPalette());
    }

    public void insertChartRecord() {
        this.workbook.getRecords().add(this.workbook.findFirstRecordLocBySid((short) 252), new UnknownRecord(FinalCanbus.CAR_RZC4_DS5LS, new byte[]{IntersectionPtg.sid, 0, 0, -16, 82, 0, 0, 0, 0, 0, 6, -16, 24, 0, 0, 0, 1, 8, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 3, 0, 0, 0, 51, 0, 11, -16, UnaryPlusPtg.sid, 0, 0, 0, -65, 0, 8, 0, 8, 0, -127, 1, 9, 0, 0, 8, -64, 1, Ptg.CLASS_ARRAY, 0, 0, 8, Ptg.CLASS_ARRAY, 0, IntPtg.sid, -15, UnionPtg.sid, 0, 0, 0, 13, 0, 0, 8, 12, 0, 0, 8, StringPtg.sid, 0, 0, 8, -9, 0, 0, UnionPtg.sid}));
    }

    public void dumpDrawingGroupRecords(boolean z) {
        DrawingGroupRecord drawingGroupRecord = (DrawingGroupRecord) this.workbook.findFirstRecordBySid(DrawingGroupRecord.sid);
        drawingGroupRecord.decode();
        List<EscherRecord> escherRecords = drawingGroupRecord.getEscherRecords();
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out, Charset.defaultCharset()));
        for (EscherRecord escherRecord : escherRecords) {
            if (z) {
                System.out.println(escherRecord);
            } else {
                escherRecord.display(printWriter, 0);
            }
        }
        printWriter.flush();
    }

    void initDrawings() {
        if (this.workbook.findDrawingGroup() != null) {
            Iterator<HSSFSheet> it = this._sheets.iterator();
            while (it.hasNext()) {
                it.next().getDrawingPatriarch();
            }
            return;
        }
        this.workbook.createDrawingGroup();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // org.apache.poi.ss.usermodel.Workbook
    public int addPicture(byte[] bArr, int i) {
        int compressedSize;
        short s;
        EscherBlipRecord escherBlipRecord;
        initDrawings();
        byte[] bArrMd5 = DigestUtils.md5(bArr);
        if (i == 2) {
            EscherMetafileBlip escherMetafileBlip = new EscherMetafileBlip();
            escherMetafileBlip.setUID(bArrMd5);
            escherMetafileBlip.setPictureData(bArr);
            escherMetafileBlip.setFilter((byte) -2);
            compressedSize = escherMetafileBlip.getCompressedSize() + 58;
            s = 0;
            escherBlipRecord = escherMetafileBlip;
        } else if (i == 3) {
            if (LittleEndian.getInt(bArr) == -1698247209) {
                byte[] bArr2 = new byte[bArr.length - 22];
                System.arraycopy(bArr, 22, bArr2, 0, bArr.length - 22);
                bArr = bArr2;
            }
            EscherMetafileBlip escherMetafileBlip2 = new EscherMetafileBlip();
            escherMetafileBlip2.setUID(bArrMd5);
            escherMetafileBlip2.setPictureData(bArr);
            escherMetafileBlip2.setFilter((byte) -2);
            compressedSize = escherMetafileBlip2.getCompressedSize() + 58;
            s = 0;
            escherBlipRecord = escherMetafileBlip2;
        } else {
            EscherBitmapBlip escherBitmapBlip = new EscherBitmapBlip();
            escherBitmapBlip.setUID(bArrMd5);
            escherBitmapBlip.setMarker((byte) -1);
            escherBitmapBlip.setPictureData(bArr);
            compressedSize = bArr.length + 25;
            s = 255;
            escherBlipRecord = escherBitmapBlip;
        }
        escherBlipRecord.setRecordId((short) (i - 4072));
        switch (i) {
            case 2:
                escherBlipRecord.setOptions(HSSFPictureData.MSOBI_EMF);
                break;
            case 3:
                escherBlipRecord.setOptions(HSSFPictureData.MSOBI_WMF);
                break;
            case 4:
                escherBlipRecord.setOptions(HSSFPictureData.MSOBI_PICT);
                break;
            case 5:
                escherBlipRecord.setOptions(HSSFPictureData.MSOBI_JPEG);
                break;
            case 6:
                escherBlipRecord.setOptions(HSSFPictureData.MSOBI_PNG);
                break;
            case 7:
                escherBlipRecord.setOptions(HSSFPictureData.MSOBI_DIB);
                break;
            default:
                throw new IllegalStateException("Unexpected picture format: " + i);
        }
        EscherBSERecord escherBSERecord = new EscherBSERecord();
        escherBSERecord.setRecordId(EscherBSERecord.RECORD_ID);
        escherBSERecord.setOptions((short) (2 | (i << 4)));
        byte b = (byte) i;
        escherBSERecord.setBlipTypeMacOS(b);
        escherBSERecord.setBlipTypeWin32(b);
        escherBSERecord.setUid(bArrMd5);
        escherBSERecord.setTag(s);
        escherBSERecord.setSize(compressedSize);
        escherBSERecord.setRef(0);
        escherBSERecord.setOffset(0);
        escherBSERecord.setBlipRecord(escherBlipRecord);
        return this.workbook.addBSERecord(escherBSERecord);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public List<HSSFPictureData> getAllPictures() {
        ArrayList arrayList = new ArrayList();
        for (Record record : this.workbook.getRecords()) {
            if (record instanceof AbstractEscherHolderRecord) {
                AbstractEscherHolderRecord abstractEscherHolderRecord = (AbstractEscherHolderRecord) record;
                abstractEscherHolderRecord.decode();
                searchForPictures(abstractEscherHolderRecord.getEscherRecords(), arrayList);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private void searchForPictures(List<EscherRecord> list, List<HSSFPictureData> list2) {
        EscherBlipRecord blipRecord;
        for (EscherRecord escherRecord : list) {
            if ((escherRecord instanceof EscherBSERecord) && (blipRecord = ((EscherBSERecord) escherRecord).getBlipRecord()) != null) {
                list2.add(new HSSFPictureData(blipRecord));
            }
            searchForPictures(escherRecord.getChildRecords(), list2);
        }
    }

    protected static Map<String, ClassID> getOleMap() {
        HashMap map = new HashMap();
        map.put("PowerPoint Document", ClassID.PPT_SHOW);
        for (String str : InternalWorkbook.WORKBOOK_DIR_ENTRY_NAMES) {
            map.put(str, ClassID.XLS_WORKBOOK);
        }
        return map;
    }

    public int addOlePackage(POIFSFileSystem pOIFSFileSystem, String str, String str2, String str3) throws IOException {
        DirectoryNode root = pOIFSFileSystem.getRoot();
        for (Map.Entry<String, ClassID> entry : getOleMap().entrySet()) {
            if (root.hasEntry(entry.getKey())) {
                root.setStorageClsid(entry.getValue());
                break;
            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        pOIFSFileSystem.writeFilesystem(byteArrayOutputStream);
        return addOlePackage(byteArrayOutputStream.toByteArray(), str, str2, str3);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int addOlePackage(byte[] bArr, String str, String str2, String str3) throws IOException {
        if (initDirectory()) {
            this.preserveNodes = true;
        }
        int i = 0;
        DirectoryEntry directoryEntryCreateDirectory = null;
        do {
            i++;
            String str4 = "MBD" + HexDump.toHex(i);
            if (!getDirectory().hasEntry(str4)) {
                directoryEntryCreateDirectory = getDirectory().createDirectory(str4);
                directoryEntryCreateDirectory.setStorageClsid(ClassID.OLE10_PACKAGE);
            }
        } while (directoryEntryCreateDirectory == null);
        directoryEntryCreateDirectory.createDocument("\u0001Ole", new ByteArrayInputStream(new byte[]{1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
        Ole10Native ole10Native = new Ole10Native(str, str2, str3, bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ole10Native.writeOut(byteArrayOutputStream);
        directoryEntryCreateDirectory.createDocument(Ole10Native.OLE10_NATIVE, new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        return i;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int linkExternalWorkbook(String str, Workbook workbook) {
        return this.workbook.linkExternalWorkbook(str, workbook);
    }

    public boolean isWriteProtected() {
        return this.workbook.isWriteProtected();
    }

    public void writeProtectWorkbook(String str, String str2) {
        this.workbook.writeProtectWorkbook(str, str2);
    }

    public void unwriteProtectWorkbook() {
        this.workbook.unwriteProtectWorkbook();
    }

    public List<HSSFObjectData> getAllEmbeddedObjects() {
        ArrayList arrayList = new ArrayList();
        Iterator<HSSFSheet> it = this._sheets.iterator();
        while (it.hasNext()) {
            getAllEmbeddedObjects(it.next(), arrayList);
        }
        return Collections.unmodifiableList(arrayList);
    }

    private void getAllEmbeddedObjects(HSSFSheet hSSFSheet, List<HSSFObjectData> list) {
        HSSFPatriarch drawingPatriarch = hSSFSheet.getDrawingPatriarch();
        if (drawingPatriarch == null) {
            return;
        }
        getAllEmbeddedObjects(drawingPatriarch, list);
    }

    private void getAllEmbeddedObjects(HSSFShapeContainer hSSFShapeContainer, List<HSSFObjectData> list) {
        for (Shape shape : hSSFShapeContainer.getChildren()) {
            if (shape instanceof HSSFObjectData) {
                list.add((HSSFObjectData) shape);
            } else if (shape instanceof HSSFShapeContainer) {
                getAllEmbeddedObjects((HSSFShapeContainer) shape, list);
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFCreationHelper getCreationHelper() {
        return new HSSFCreationHelper(this);
    }

    UDFFinder getUDFFinder() {
        return this._udfFinder;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void addToolPack(UDFFinder uDFFinder) {
        ((AggregatingUDFFinder) this._udfFinder).add(uDFFinder);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setForceFormulaRecalculation(boolean z) {
        getWorkbook().getRecalcId().setEngineId(0);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public boolean getForceFormulaRecalculation() {
        RecalcIdRecord recalcIdRecord = (RecalcIdRecord) getWorkbook().findFirstRecordBySid((short) 449);
        return (recalcIdRecord == null || recalcIdRecord.getEngineId() == 0) ? false : true;
    }

    public boolean changeExternalReference(String str, String str2) {
        return this.workbook.changeExternalReference(str, str2);
    }

    @Removal(version = "3.18")
    @Deprecated
    public DirectoryNode getRootDirectory() {
        return getDirectory();
    }

    @Internal
    public InternalWorkbook getInternalWorkbook() {
        return this.workbook;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public SpreadsheetVersion getSpreadsheetVersion() {
        return SpreadsheetVersion.EXCEL97;
    }

    @Override // org.apache.poi.POIDocument
    public EncryptionInfo getEncryptionInfo() {
        FilePassRecord filePassRecord = (FilePassRecord) this.workbook.findFirstRecordBySid((short) 47);
        if (filePassRecord != null) {
            return filePassRecord.getEncryptionInfo();
        }
        return null;
    }

    private void updateEncryptionInfo() {
        readProperties();
        FilePassRecord filePassRecord = (FilePassRecord) this.workbook.findFirstRecordBySid((short) 47);
        String currentUserPassword = Biff8EncryptionKey.getCurrentUserPassword();
        WorkbookRecordList workbookRecordList = this.workbook.getWorkbookRecordList();
        if (currentUserPassword == null) {
            if (filePassRecord != null) {
                workbookRecordList.remove(filePassRecord);
                return;
            }
            return;
        }
        if (filePassRecord == null) {
            filePassRecord = new FilePassRecord(EncryptionMode.cryptoAPI);
            workbookRecordList.add(1, filePassRecord);
        }
        EncryptionInfo encryptionInfo = filePassRecord.getEncryptionInfo();
        EncryptionVerifier verifier = encryptionInfo.getVerifier();
        byte[] encryptedVerifier = verifier.getEncryptedVerifier();
        Decryptor decryptor = encryptionInfo.getDecryptor();
        Encryptor encryptor = encryptionInfo.getEncryptor();
        if (encryptedVerifier != null) {
            try {
                if (!decryptor.verifyPassword(currentUserPassword)) {
                    encryptor.confirmPassword(currentUserPassword);
                } else {
                    encryptor.confirmPassword(currentUserPassword, null, null, decryptor.getVerifier(), verifier.getSalt(), null);
                }
            } catch (GeneralSecurityException e) {
                throw new EncryptedDocumentException("can't validate/update encryption setting", e);
            }
        } else {
            encryptor.confirmPassword(currentUserPassword);
        }
    }
}
