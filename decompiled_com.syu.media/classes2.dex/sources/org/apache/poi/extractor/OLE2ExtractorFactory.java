package org.apache.poi.extractor;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.POIOLE2TextExtractor;
import org.apache.poi.POITextExtractor;
import org.apache.poi.hssf.OldExcelFormatException;
import org.apache.poi.hssf.extractor.EventBasedExcelExtractor;
import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.record.crypto.Biff8EncryptionKey;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.Entry;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.poifs.filesystem.OPOIFSFileSystem;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class OLE2ExtractorFactory {
    private static Boolean allPreferEventExtractors;
    private static final POILogger LOGGER = POILogFactory.getLogger((Class<?>) OLE2ExtractorFactory.class);
    private static final ThreadLocal<Boolean> threadPreferEventExtractors = new ThreadLocal<Boolean>() { // from class: org.apache.poi.extractor.OLE2ExtractorFactory.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Boolean initialValue() {
            return Boolean.FALSE;
        }
    };

    public static boolean getThreadPrefersEventExtractors() {
        return threadPreferEventExtractors.get().booleanValue();
    }

    public static Boolean getAllThreadsPreferEventExtractors() {
        return allPreferEventExtractors;
    }

    public static void setThreadPrefersEventExtractors(boolean z) {
        threadPreferEventExtractors.set(Boolean.valueOf(z));
    }

    public static void setAllThreadsPreferEventExtractors(Boolean bool) {
        allPreferEventExtractors = bool;
    }

    protected static boolean getPreferEventExtractor() {
        Boolean bool = allPreferEventExtractors;
        if (bool != null) {
            return bool.booleanValue();
        }
        return threadPreferEventExtractors.get().booleanValue();
    }

    public static POIOLE2TextExtractor createExtractor(POIFSFileSystem pOIFSFileSystem) throws IOException {
        return (POIOLE2TextExtractor) createExtractor(pOIFSFileSystem.getRoot());
    }

    public static POIOLE2TextExtractor createExtractor(NPOIFSFileSystem nPOIFSFileSystem) throws IOException {
        return (POIOLE2TextExtractor) createExtractor(nPOIFSFileSystem.getRoot());
    }

    public static POIOLE2TextExtractor createExtractor(OPOIFSFileSystem oPOIFSFileSystem) throws IOException {
        return (POIOLE2TextExtractor) createExtractor(oPOIFSFileSystem.getRoot());
    }

    public static POITextExtractor createExtractor(InputStream inputStream) throws IOException {
        Class<?> oOXMLClass = getOOXMLClass();
        if (oOXMLClass != null) {
            try {
                return (POITextExtractor) oOXMLClass.getDeclaredMethod("createExtractor", InputStream.class).invoke(null, inputStream);
            } catch (IllegalArgumentException e) {
                throw e;
            } catch (Exception e2) {
                throw new IllegalArgumentException("Error creating Extractor for InputStream", e2);
            }
        }
        return createExtractor(new NPOIFSFileSystem(inputStream));
    }

    private static Class<?> getOOXMLClass() {
        try {
            return OLE2ExtractorFactory.class.getClassLoader().loadClass("org.apache.poi.extractor.ExtractorFactory");
        } catch (ClassNotFoundException unused) {
            LOGGER.log(5, "POI OOXML jar missing");
            return null;
        }
    }

    private static Class<?> getScratchpadClass() {
        try {
            return OLE2ExtractorFactory.class.getClassLoader().loadClass("org.apache.poi.extractor.OLE2ScratchpadExtractorFactory");
        } catch (ClassNotFoundException unused) {
            LOGGER.log(7, "POI Scratchpad jar missing");
            throw new IllegalStateException("POI Scratchpad jar missing, required for ExtractorFactory");
        }
    }

    public static POITextExtractor createExtractor(DirectoryNode directoryNode) throws IOException {
        for (String str : InternalWorkbook.WORKBOOK_DIR_ENTRY_NAMES) {
            if (directoryNode.hasEntry(str)) {
                if (getPreferEventExtractor()) {
                    return new EventBasedExcelExtractor(directoryNode);
                }
                return new ExcelExtractor(directoryNode);
            }
        }
        if (directoryNode.hasEntry(InternalWorkbook.OLD_WORKBOOK_DIR_ENTRY_NAME)) {
            throw new OldExcelFormatException("Old Excel Spreadsheet format (1-95) found. Please call OldExcelExtractor directly for basic text extraction");
        }
        try {
            POITextExtractor pOITextExtractor = (POITextExtractor) getScratchpadClass().getDeclaredMethod("createExtractor", DirectoryNode.class).invoke(null, directoryNode);
            if (pOITextExtractor != null) {
                return pOITextExtractor;
            }
            throw new IllegalArgumentException("No supported documents found in the OLE2 stream");
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e2) {
            throw new IllegalArgumentException("Error creating Scratchpad Extractor", e2);
        }
    }

    public static POITextExtractor[] getEmbededDocsTextExtractors(POIOLE2TextExtractor pOIOLE2TextExtractor) throws IOException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        DirectoryEntry root = pOIOLE2TextExtractor.getRoot();
        if (root == null) {
            throw new IllegalStateException("The extractor didn't know which POIFS it came from!");
        }
        if (pOIOLE2TextExtractor instanceof ExcelExtractor) {
            Iterator<Entry> entries = root.getEntries();
            while (entries.hasNext()) {
                Entry next = entries.next();
                if (next.getName().startsWith("MBD")) {
                    arrayList.add(next);
                }
            }
        } else {
            try {
                getScratchpadClass().getDeclaredMethod("identifyEmbeddedResources", POIOLE2TextExtractor.class, List.class, List.class).invoke(null, pOIOLE2TextExtractor, arrayList, arrayList2);
            } catch (Exception e) {
                throw new IllegalArgumentException("Error checking for Scratchpad embedded resources", e);
            }
        }
        if (arrayList.size() == 0 && arrayList2.size() == 0) {
            return new POITextExtractor[0];
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList3.add(createExtractor((DirectoryNode) ((Entry) it.next())));
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            try {
                arrayList3.add(createExtractor((InputStream) it2.next()));
            } catch (IllegalArgumentException e2) {
                LOGGER.log(5, e2);
            } catch (Exception e3) {
                LOGGER.log(5, e3);
            }
        }
        return (POITextExtractor[]) arrayList3.toArray(new POITextExtractor[arrayList3.size()]);
    }

    private static POITextExtractor createEncyptedOOXMLExtractor(DirectoryNode directoryNode) throws IOException {
        String currentUserPassword = Biff8EncryptionKey.getCurrentUserPassword();
        if (currentUserPassword == null) {
            currentUserPassword = Decryptor.DEFAULT_PASSWORD;
        }
        Decryptor decryptor = new EncryptionInfo(directoryNode).getDecryptor();
        try {
            try {
                if (!decryptor.verifyPassword(currentUserPassword)) {
                    throw new EncryptedDocumentException("Invalid password specified - use Biff8EncryptionKey.setCurrentUserPassword() before calling extractor");
                }
                InputStream dataStream = decryptor.getDataStream(directoryNode);
                POITextExtractor pOITextExtractorCreateExtractor = createExtractor(dataStream);
                IOUtils.closeQuietly(dataStream);
                return pOITextExtractorCreateExtractor;
            } catch (IOException e) {
                throw e;
            } catch (Exception e2) {
                throw new IOException(e2);
            }
        } catch (Throwable th) {
            IOUtils.closeQuietly(null);
            throw th;
        }
    }
}
