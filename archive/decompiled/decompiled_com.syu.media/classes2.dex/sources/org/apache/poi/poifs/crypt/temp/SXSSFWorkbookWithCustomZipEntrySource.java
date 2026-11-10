package org.apache.poi.poifs.crypt.temp;

import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.streaming.SheetDataWriter;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SXSSFWorkbookWithCustomZipEntrySource extends SXSSFWorkbook {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) SXSSFWorkbookWithCustomZipEntrySource.class);

    public SXSSFWorkbookWithCustomZipEntrySource() {
        super(20);
        setCompressTempFiles(true);
    }

    @Override // org.apache.poi.xssf.streaming.SXSSFWorkbook, org.apache.poi.ss.usermodel.Workbook
    public void write(OutputStream outputStream) throws IOException {
        flushSheets();
        EncryptedTempData encryptedTempData = new EncryptedTempData();
        try {
            try {
                OutputStream outputStream2 = encryptedTempData.getOutputStream();
                try {
                    getXSSFWorkbook().write(outputStream2);
                    IOUtils.closeQuietly(outputStream2);
                    AesZipFileZipEntrySource aesZipFileZipEntrySourceCreateZipEntrySource = AesZipFileZipEntrySource.createZipEntrySource(encryptedTempData.getInputStream());
                    injectData(aesZipFileZipEntrySourceCreateZipEntrySource, outputStream);
                    encryptedTempData.dispose();
                    IOUtils.closeQuietly(aesZipFileZipEntrySourceCreateZipEntrySource);
                } catch (Throwable th) {
                    IOUtils.closeQuietly(outputStream2);
                    throw th;
                }
            } catch (GeneralSecurityException e) {
                throw new IOException(e);
            }
        } catch (Throwable th2) {
            encryptedTempData.dispose();
            IOUtils.closeQuietly(null);
            throw th2;
        }
    }

    @Override // org.apache.poi.xssf.streaming.SXSSFWorkbook
    protected SheetDataWriter createSheetDataWriter() throws IOException {
        POILogger pOILogger = LOG;
        pOILogger.log(3, "isCompressTempFiles: " + isCompressTempFiles());
        pOILogger.log(3, "SharedStringSource: " + getSharedStringSource());
        return new SheetDataWriterWithDecorator();
    }
}
