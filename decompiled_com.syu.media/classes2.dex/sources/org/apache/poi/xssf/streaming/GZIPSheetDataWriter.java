package org.apache.poi.xssf.streaming;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.poi.util.TempFile;
import org.apache.poi.xssf.model.SharedStringsTable;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class GZIPSheetDataWriter extends SheetDataWriter {
    public GZIPSheetDataWriter() throws IOException {
    }

    public GZIPSheetDataWriter(SharedStringsTable sharedStringsTable) throws IOException {
        super(sharedStringsTable);
    }

    @Override // org.apache.poi.xssf.streaming.SheetDataWriter
    public File createTempFile() throws IOException {
        return TempFile.createTempFile("poi-sxssf-sheet-xml", ".gz");
    }

    @Override // org.apache.poi.xssf.streaming.SheetDataWriter
    protected InputStream decorateInputStream(FileInputStream fileInputStream) throws IOException {
        return new GZIPInputStream(fileInputStream);
    }

    @Override // org.apache.poi.xssf.streaming.SheetDataWriter
    protected OutputStream decorateOutputStream(FileOutputStream fileOutputStream) throws IOException {
        return new GZIPOutputStream(fileOutputStream);
    }
}
