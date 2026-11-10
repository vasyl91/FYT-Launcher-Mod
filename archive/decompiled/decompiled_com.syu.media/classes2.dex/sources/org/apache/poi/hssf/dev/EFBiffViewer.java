package org.apache.poi.hssf.dev;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.hssf.eventusermodel.HSSFEventFactory;
import org.apache.poi.hssf.eventusermodel.HSSFListener;
import org.apache.poi.hssf.eventusermodel.HSSFRequest;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class EFBiffViewer {
    String file;

    public void run() throws IOException {
        NPOIFSFileSystem nPOIFSFileSystem = new NPOIFSFileSystem(new File(this.file), true);
        try {
            InputStream pOIFSInputStream = BiffViewer.getPOIFSInputStream(nPOIFSFileSystem);
            try {
                HSSFRequest hSSFRequest = new HSSFRequest();
                hSSFRequest.addListenerForAllRecords(new HSSFListener() { // from class: org.apache.poi.hssf.dev.EFBiffViewer.1
                    @Override // org.apache.poi.hssf.eventusermodel.HSSFListener
                    public void processRecord(Record record) {
                        System.out.println(record);
                    }
                });
                new HSSFEventFactory().processEvents(hSSFRequest, pOIFSInputStream);
                pOIFSInputStream.close();
                nPOIFSFileSystem.close();
            } catch (Throwable th) {
                pOIFSInputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            nPOIFSFileSystem.close();
            throw th2;
        }
    }

    public void setFile(String str) {
        this.file = str;
    }

    public static void main(String[] strArr) throws IOException {
        if (strArr.length == 1 && !strArr[0].equals("--help")) {
            EFBiffViewer eFBiffViewer = new EFBiffViewer();
            eFBiffViewer.setFile(strArr[0]);
            eFBiffViewer.run();
        } else {
            System.out.println("EFBiffViewer");
            System.out.println("Outputs biffview of records based on HSSFEventFactory");
            System.out.println("usage: java org.apache.poi.hssf.dev.EBBiffViewer filename");
        }
    }
}
