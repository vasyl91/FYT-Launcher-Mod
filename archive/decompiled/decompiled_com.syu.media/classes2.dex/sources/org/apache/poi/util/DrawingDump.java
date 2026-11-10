package org.apache.poi.util;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.ss.usermodel.Sheet;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DrawingDump {
    public static void main(String[] strArr) throws IOException {
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out, Charset.defaultCharset()));
        NPOIFSFileSystem nPOIFSFileSystem = new NPOIFSFileSystem(new File(strArr[0]));
        HSSFWorkbook hSSFWorkbook = new HSSFWorkbook(nPOIFSFileSystem);
        try {
            printWriter.println("Drawing group:");
            hSSFWorkbook.dumpDrawingGroupRecords(true);
            for (Sheet sheet : hSSFWorkbook) {
                printWriter.println("Sheet 1(" + sheet.getSheetName() + "):");
                ((HSSFSheet) sheet).dumpDrawingRecords(true, printWriter);
            }
            hSSFWorkbook.close();
            nPOIFSFileSystem.close();
        } catch (Throwable th) {
            hSSFWorkbook.close();
            nPOIFSFileSystem.close();
            throw th;
        }
    }
}
