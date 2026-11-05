package org.apache.poi.xssf.streaming;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import org.apache.poi.openxml4j.util.ZipEntrySource;
import org.apache.poi.openxml4j.util.ZipFileZipEntrySource;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.SheetVisibility;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;
import org.apache.poi.util.NotImplemented;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.Removal;
import org.apache.poi.util.TempFile;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.usermodel.XSSFChartSheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SXSSFWorkbook implements Workbook {
    public static final int DEFAULT_WINDOW_SIZE = 100;
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) SXSSFWorkbook.class);
    private boolean _compressTmpFiles;
    private int _randomAccessWindowSize;
    private final SharedStringsTable _sharedStringSource;
    private final Map<SXSSFSheet, XSSFSheet> _sxFromXHash;
    private final XSSFWorkbook _wb;
    private final Map<XSSFSheet, SXSSFSheet> _xFromSxHash;

    public SXSSFWorkbook() {
        this((XSSFWorkbook) null);
    }

    public SXSSFWorkbook(XSSFWorkbook xSSFWorkbook) {
        this(xSSFWorkbook, 100);
    }

    public SXSSFWorkbook(XSSFWorkbook xSSFWorkbook, int i) {
        this(xSSFWorkbook, i, false);
    }

    public SXSSFWorkbook(XSSFWorkbook xSSFWorkbook, int i, boolean z) {
        this(xSSFWorkbook, i, z, false);
    }

    public SXSSFWorkbook(XSSFWorkbook xSSFWorkbook, int i, boolean z, boolean z2) {
        this._sxFromXHash = new HashMap();
        this._xFromSxHash = new HashMap();
        this._randomAccessWindowSize = 100;
        setRandomAccessWindowSize(i);
        setCompressTempFiles(z);
        if (xSSFWorkbook == null) {
            XSSFWorkbook xSSFWorkbook2 = new XSSFWorkbook();
            this._wb = xSSFWorkbook2;
            this._sharedStringSource = z2 ? xSSFWorkbook2.getSharedStringSource() : null;
        } else {
            this._wb = xSSFWorkbook;
            this._sharedStringSource = z2 ? xSSFWorkbook.getSharedStringSource() : null;
            Iterator<Sheet> it = xSSFWorkbook.iterator();
            while (it.hasNext()) {
                createAndRegisterSXSSFSheet((XSSFSheet) it.next());
            }
        }
    }

    public SXSSFWorkbook(int i) {
        this(null, i);
    }

    public int getRandomAccessWindowSize() {
        return this._randomAccessWindowSize;
    }

    private void setRandomAccessWindowSize(int i) {
        if (i == 0 || i < -1) {
            throw new IllegalArgumentException("rowAccessWindowSize must be greater than 0 or -1");
        }
        this._randomAccessWindowSize = i;
    }

    public boolean isCompressTempFiles() {
        return this._compressTmpFiles;
    }

    public void setCompressTempFiles(boolean z) {
        this._compressTmpFiles = z;
    }

    @Internal
    protected SharedStringsTable getSharedStringSource() {
        return this._sharedStringSource;
    }

    protected SheetDataWriter createSheetDataWriter() throws IOException {
        if (this._compressTmpFiles) {
            return new GZIPSheetDataWriter(this._sharedStringSource);
        }
        return new SheetDataWriter(this._sharedStringSource);
    }

    XSSFSheet getXSSFSheet(SXSSFSheet sXSSFSheet) {
        return this._sxFromXHash.get(sXSSFSheet);
    }

    SXSSFSheet getSXSSFSheet(XSSFSheet xSSFSheet) {
        return this._xFromSxHash.get(xSSFSheet);
    }

    void registerSheetMapping(SXSSFSheet sXSSFSheet, XSSFSheet xSSFSheet) {
        this._sxFromXHash.put(sXSSFSheet, xSSFSheet);
        this._xFromSxHash.put(xSSFSheet, sXSSFSheet);
    }

    void deregisterSheetMapping(XSSFSheet xSSFSheet) {
        SXSSFSheet sXSSFSheet = getSXSSFSheet(xSSFSheet);
        try {
            sXSSFSheet.getSheetDataWriter().close();
        } catch (IOException unused) {
        }
        this._sxFromXHash.remove(sXSSFSheet);
        this._xFromSxHash.remove(xSSFSheet);
    }

    private XSSFSheet getSheetFromZipEntryName(String str) {
        for (XSSFSheet xSSFSheet : this._sxFromXHash.values()) {
            if (str.equals(xSSFSheet.getPackagePart().getPartName().getName().substring(1))) {
                return xSSFSheet;
            }
        }
        return null;
    }

    protected void injectData(ZipEntrySource zipEntrySource, OutputStream outputStream) throws IOException {
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
            try {
                Enumeration<? extends ZipEntry> entries = zipEntrySource.getEntries();
                while (entries.hasMoreElements()) {
                    ZipEntry zipEntryNextElement = entries.nextElement();
                    zipOutputStream.putNextEntry(new ZipEntry(zipEntryNextElement.getName()));
                    InputStream inputStream = zipEntrySource.getInputStream(zipEntryNextElement);
                    XSSFSheet sheetFromZipEntryName = getSheetFromZipEntryName(zipEntryNextElement.getName());
                    if (sheetFromZipEntryName != null && !(sheetFromZipEntryName instanceof XSSFChartSheet)) {
                        InputStream worksheetXMLInputStream = getSXSSFSheet(sheetFromZipEntryName).getWorksheetXMLInputStream();
                        try {
                            copyStreamAndInjectWorksheet(inputStream, zipOutputStream, worksheetXMLInputStream);
                            worksheetXMLInputStream.close();
                        } catch (Throwable th) {
                            worksheetXMLInputStream.close();
                            throw th;
                        }
                    } else {
                        IOUtils.copy(inputStream, zipOutputStream);
                    }
                    inputStream.close();
                }
                zipOutputStream.close();
                zipEntrySource.close();
            } catch (Throwable th2) {
                zipOutputStream.close();
                throw th2;
            }
        } catch (Throwable th3) {
            zipEntrySource.close();
            throw th3;
        }
    }

    private static void copyStreamAndInjectWorksheet(InputStream inputStream, OutputStream outputStream, InputStream inputStream2) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
        int i = 10;
        boolean z = true;
        int i2 = 0;
        String str = "<sheetData";
        while (true) {
            int i3 = inputStreamReader.read();
            if (i3 == -1) {
                break;
            }
            if (i3 == str.charAt(i2)) {
                i2++;
                if (i2 != i) {
                    continue;
                } else {
                    if (!"<sheetData".equals(str)) {
                        break;
                    }
                    int i4 = inputStreamReader.read();
                    if (i4 == -1) {
                        outputStreamWriter.write(str);
                        break;
                    }
                    if (i4 == 62) {
                        outputStreamWriter.write(str);
                        outputStreamWriter.write(i4);
                        i = 12;
                        i2 = 0;
                        z = false;
                        str = "</sheetData>";
                    } else {
                        if (i4 == 47) {
                            int i5 = inputStreamReader.read();
                            if (i5 == -1) {
                                outputStreamWriter.write(str);
                                break;
                            } else {
                                if (i5 == 62) {
                                    break;
                                }
                                outputStreamWriter.write(str);
                                outputStreamWriter.write(47);
                                outputStreamWriter.write(i5);
                            }
                        } else {
                            outputStreamWriter.write(str);
                            outputStreamWriter.write(47);
                            outputStreamWriter.write(i4);
                        }
                        i2 = 0;
                    }
                }
            } else {
                if (i2 > 0) {
                    outputStreamWriter.write(str, 0, i2);
                }
                if (i3 == str.charAt(0)) {
                    i2 = 1;
                } else {
                    outputStreamWriter.write(i3);
                    i2 = 0;
                }
            }
        }
        outputStreamWriter.flush();
        if (z) {
            outputStreamWriter.write("<sheetData>\n");
            outputStreamWriter.flush();
        }
        IOUtils.copy(inputStream2, outputStream);
        outputStreamWriter.write("</sheetData>");
        outputStreamWriter.flush();
        while (true) {
            int i6 = inputStreamReader.read();
            if (i6 != -1) {
                outputStreamWriter.write(i6);
            } else {
                outputStreamWriter.flush();
                return;
            }
        }
    }

    public XSSFWorkbook getXSSFWorkbook() {
        return this._wb;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getActiveSheetIndex() {
        return this._wb.getActiveSheetIndex();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setActiveSheet(int i) {
        this._wb.setActiveSheet(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getFirstVisibleTab() {
        return this._wb.getFirstVisibleTab();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setFirstVisibleTab(int i) {
        this._wb.setFirstVisibleTab(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSheetOrder(String str, int i) {
        this._wb.setSheetOrder(str, i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSelectedTab(int i) {
        this._wb.setSelectedTab(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSheetName(int i, String str) {
        this._wb.setSheetName(i, str);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public String getSheetName(int i) {
        return this._wb.getSheetName(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getSheetIndex(String str) {
        return this._wb.getSheetIndex(str);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getSheetIndex(Sheet sheet) {
        return this._wb.getSheetIndex(getXSSFSheet((SXSSFSheet) sheet));
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public SXSSFSheet createSheet() {
        return createAndRegisterSXSSFSheet(this._wb.createSheet());
    }

    SXSSFSheet createAndRegisterSXSSFSheet(XSSFSheet xSSFSheet) {
        try {
            SXSSFSheet sXSSFSheet = new SXSSFSheet(this, xSSFSheet);
            registerSheetMapping(sXSSFSheet, xSSFSheet);
            return sXSSFSheet;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public SXSSFSheet createSheet(String str) {
        return createAndRegisterSXSSFSheet(this._wb.createSheet(str));
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    @NotImplemented
    public Sheet cloneSheet(int i) {
        throw new RuntimeException("NotImplemented");
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getNumberOfSheets() {
        return this._wb.getNumberOfSheets();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Iterator<Sheet> sheetIterator() {
        return new SheetIterator();
    }

    private final class SheetIterator<T extends Sheet> implements Iterator<T> {
        private final Iterator<XSSFSheet> it;

        public SheetIterator() {
            this.it = SXSSFWorkbook.this._wb.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.it.hasNext();
        }

        @Override // java.util.Iterator
        public T next() throws NoSuchElementException {
            return SXSSFWorkbook.this.getSXSSFSheet(this.it.next());
        }

        @Override // java.util.Iterator
        public void remove() throws IllegalStateException {
            throw new UnsupportedOperationException("remove method not supported on XSSFWorkbook.iterator(). Use Sheet.removeSheetAt(int) instead.");
        }
    }

    @Override // java.lang.Iterable
    public Iterator<Sheet> iterator() {
        return sheetIterator();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public SXSSFSheet getSheetAt(int i) {
        return getSXSSFSheet(this._wb.getSheetAt(i));
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public SXSSFSheet getSheet(String str) {
        return getSXSSFSheet(this._wb.getSheet(str));
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void removeSheetAt(int i) {
        XSSFSheet sheetAt = this._wb.getSheetAt(i);
        SXSSFSheet sXSSFSheet = getSXSSFSheet(sheetAt);
        this._wb.removeSheetAt(i);
        deregisterSheetMapping(sheetAt);
        try {
            sXSSFSheet.dispose();
        } catch (IOException e) {
            logger.log(5, e);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Font createFont() {
        return this._wb.createFont();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Font findFont(boolean z, short s, short s2, String str, boolean z2, boolean z3, short s3, byte b) {
        return this._wb.findFont(z, s, s2, str, z2, z3, s3, b);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public short getNumberOfFonts() {
        return this._wb.getNumberOfFonts();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Font getFontAt(short s) {
        return this._wb.getFontAt(s);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public CellStyle createCellStyle() {
        return this._wb.createCellStyle();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getNumCellStyles() {
        return this._wb.getNumCellStyles();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public CellStyle getCellStyleAt(int i) {
        return this._wb.getCellStyleAt(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        for (SXSSFSheet sXSSFSheet : this._xFromSxHash.values()) {
            try {
                sXSSFSheet.getSheetDataWriter().close();
            } catch (IOException e) {
                logger.log(5, "An exception occurred while closing sheet data writer for sheet " + sXSSFSheet.getSheetName() + ".", e);
            }
        }
        this._wb.close();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void write(OutputStream outputStream) throws IOException {
        flushSheets();
        File fileCreateTempFile = TempFile.createTempFile("poi-sxssf-template", ".xlsx");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            try {
                this._wb.write(fileOutputStream);
                fileOutputStream.close();
                injectData(new ZipFileZipEntrySource(new ZipFile(fileCreateTempFile)), outputStream);
                if (!fileCreateTempFile.delete()) {
                    throw new IOException("Could not delete temporary file after processing: " + fileCreateTempFile);
                }
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            fileCreateTempFile.delete();
            throw th2;
        }
    }

    protected void flushSheets() throws IOException {
        Iterator<SXSSFSheet> it = this._xFromSxHash.values().iterator();
        while (it.hasNext()) {
            it.next().flushRows();
        }
    }

    public boolean dispose() {
        Iterator<SXSSFSheet> it = this._sxFromXHash.keySet().iterator();
        boolean z = true;
        while (it.hasNext()) {
            boolean z2 = false;
            try {
                if (it.next().dispose() && z) {
                    z2 = true;
                }
            } catch (IOException e) {
                logger.log(5, e);
            }
            z = z2;
        }
        return z;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getNumberOfNames() {
        return this._wb.getNumberOfNames();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Name getName(String str) {
        return this._wb.getName(str);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public List<? extends Name> getNames(String str) {
        return this._wb.getNames(str);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public List<? extends Name> getAllNames() {
        return this._wb.getAllNames();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    @Removal(version = "3.18")
    @Deprecated
    public Name getNameAt(int i) {
        return this._wb.getNameAt(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Name createName() {
        return this._wb.createName();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    @Removal(version = "3.18")
    @Deprecated
    public int getNameIndex(String str) {
        return this._wb.getNameIndex(str);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    @Removal(version = "3.18")
    @Deprecated
    public void removeName(int i) {
        this._wb.removeName(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    @Removal(version = "3.18")
    @Deprecated
    public void removeName(String str) {
        this._wb.removeName(str);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void removeName(Name name) {
        this._wb.removeName(name);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setPrintArea(int i, String str) {
        this._wb.setPrintArea(i, str);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setPrintArea(int i, int i2, int i3, int i4, int i5) {
        this._wb.setPrintArea(i, i2, i3, i4, i5);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public String getPrintArea(int i) {
        return this._wb.getPrintArea(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void removePrintArea(int i) {
        this._wb.removePrintArea(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Row.MissingCellPolicy getMissingCellPolicy() {
        return this._wb.getMissingCellPolicy();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setMissingCellPolicy(Row.MissingCellPolicy missingCellPolicy) {
        this._wb.setMissingCellPolicy(missingCellPolicy);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public DataFormat createDataFormat() {
        return this._wb.createDataFormat();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int addPicture(byte[] bArr, int i) {
        return this._wb.addPicture(bArr, i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public List<? extends PictureData> getAllPictures() {
        return this._wb.getAllPictures();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public CreationHelper getCreationHelper() {
        return new SXSSFCreationHelper(this);
    }

    protected boolean isDate1904() {
        return this._wb.isDate1904();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    @NotImplemented("XSSFWorkbook#isHidden is not implemented")
    public boolean isHidden() {
        return this._wb.isHidden();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    @NotImplemented("XSSFWorkbook#setHidden is not implemented")
    public void setHidden(boolean z) {
        this._wb.setHidden(z);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public boolean isSheetHidden(int i) {
        return this._wb.isSheetHidden(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public boolean isSheetVeryHidden(int i) {
        return this._wb.isSheetVeryHidden(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public SheetVisibility getSheetVisibility(int i) {
        return this._wb.getSheetVisibility(i);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSheetHidden(int i, boolean z) {
        this._wb.setSheetHidden(i, z);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    @Removal(version = "3.18")
    @Deprecated
    public void setSheetHidden(int i, int i2) {
        this._wb.setSheetHidden(i, i2);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setSheetVisibility(int i, SheetVisibility sheetVisibility) {
        this._wb.setSheetVisibility(i, sheetVisibility);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    @NotImplemented
    public int linkExternalWorkbook(String str, Workbook workbook) {
        throw new RuntimeException("NotImplemented");
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void addToolPack(UDFFinder uDFFinder) {
        this._wb.addToolPack(uDFFinder);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public void setForceFormulaRecalculation(boolean z) {
        this._wb.setForceFormulaRecalculation(z);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public boolean getForceFormulaRecalculation() {
        return this._wb.getForceFormulaRecalculation();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public SpreadsheetVersion getSpreadsheetVersion() {
        return SpreadsheetVersion.EXCEL2007;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int addOlePackage(byte[] bArr, String str, String str2, String str3) throws IOException {
        return this._wb.addOlePackage(bArr, str, str2, str3);
    }
}
