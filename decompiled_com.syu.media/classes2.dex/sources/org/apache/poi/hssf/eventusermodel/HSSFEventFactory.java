package org.apache.poi.hssf.eventusermodel;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordFactoryInputStream;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class HSSFEventFactory {
    public void processWorkbookEvents(HSSFRequest hSSFRequest, POIFSFileSystem pOIFSFileSystem) throws IOException {
        processWorkbookEvents(hSSFRequest, pOIFSFileSystem.getRoot());
    }

    public void processWorkbookEvents(HSSFRequest hSSFRequest, DirectoryNode directoryNode) throws IOException {
        String str;
        Set<String> entryNames = directoryNode.getEntryNames();
        String[] strArr = InternalWorkbook.WORKBOOK_DIR_ENTRY_NAMES;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                str = null;
                break;
            }
            str = strArr[i];
            if (entryNames.contains(str)) {
                break;
            } else {
                i++;
            }
        }
        if (str == null) {
            str = InternalWorkbook.WORKBOOK_DIR_ENTRY_NAMES[0];
        }
        DocumentInputStream documentInputStreamCreateDocumentInputStream = directoryNode.createDocumentInputStream(str);
        try {
            processEvents(hSSFRequest, documentInputStreamCreateDocumentInputStream);
        } finally {
            documentInputStreamCreateDocumentInputStream.close();
        }
    }

    public short abortableProcessWorkbookEvents(HSSFRequest hSSFRequest, POIFSFileSystem pOIFSFileSystem) throws HSSFUserException, IOException {
        return abortableProcessWorkbookEvents(hSSFRequest, pOIFSFileSystem.getRoot());
    }

    public short abortableProcessWorkbookEvents(HSSFRequest hSSFRequest, DirectoryNode directoryNode) throws HSSFUserException, IOException {
        DocumentInputStream documentInputStreamCreateDocumentInputStream = directoryNode.createDocumentInputStream("Workbook");
        try {
            return abortableProcessEvents(hSSFRequest, documentInputStreamCreateDocumentInputStream);
        } finally {
            documentInputStreamCreateDocumentInputStream.close();
        }
    }

    public void processEvents(HSSFRequest hSSFRequest, InputStream inputStream) {
        try {
            genericProcessEvents(hSSFRequest, inputStream);
        } catch (HSSFUserException unused) {
        }
    }

    public short abortableProcessEvents(HSSFRequest hSSFRequest, InputStream inputStream) throws HSSFUserException {
        return genericProcessEvents(hSSFRequest, inputStream);
    }

    private short genericProcessEvents(HSSFRequest hSSFRequest, InputStream inputStream) throws HSSFUserException {
        short sProcessRecord = 0;
        RecordFactoryInputStream recordFactoryInputStream = new RecordFactoryInputStream(inputStream, false);
        do {
            Record recordNextRecord = recordFactoryInputStream.nextRecord();
            if (recordNextRecord == null) {
                break;
            }
            sProcessRecord = hSSFRequest.processRecord(recordNextRecord);
        } while (sProcessRecord == 0);
        return sProcessRecord;
    }
}
