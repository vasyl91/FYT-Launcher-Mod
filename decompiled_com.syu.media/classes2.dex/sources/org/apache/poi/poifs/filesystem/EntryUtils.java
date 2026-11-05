package org.apache.poi.poifs.filesystem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public class EntryUtils {
    @Internal
    public static void copyNodeRecursively(Entry entry, DirectoryEntry directoryEntry) throws IOException {
        if (entry.isDirectoryEntry()) {
            DirectoryEntry directoryEntry2 = (DirectoryEntry) entry;
            DirectoryEntry directoryEntryCreateDirectory = directoryEntry.createDirectory(entry.getName());
            directoryEntryCreateDirectory.setStorageClsid(directoryEntry2.getStorageClsid());
            Iterator<Entry> entries = directoryEntry2.getEntries();
            while (entries.hasNext()) {
                copyNodeRecursively(entries.next(), directoryEntryCreateDirectory);
            }
            return;
        }
        DocumentEntry documentEntry = (DocumentEntry) entry;
        DocumentInputStream documentInputStream = new DocumentInputStream(documentEntry);
        directoryEntry.createDocument(documentEntry.getName(), documentInputStream);
        documentInputStream.close();
    }

    public static void copyNodes(DirectoryEntry directoryEntry, DirectoryEntry directoryEntry2) throws IOException {
        Iterator<Entry> it = directoryEntry.iterator();
        while (it.hasNext()) {
            copyNodeRecursively(it.next(), directoryEntry2);
        }
    }

    public static void copyNodes(FilteringDirectoryNode filteringDirectoryNode, FilteringDirectoryNode filteringDirectoryNode2) throws IOException {
        copyNodes((DirectoryEntry) filteringDirectoryNode, (DirectoryEntry) filteringDirectoryNode2);
    }

    public static void copyNodes(OPOIFSFileSystem oPOIFSFileSystem, OPOIFSFileSystem oPOIFSFileSystem2) throws IOException {
        copyNodes(oPOIFSFileSystem.getRoot(), oPOIFSFileSystem2.getRoot());
    }

    public static void copyNodes(NPOIFSFileSystem nPOIFSFileSystem, NPOIFSFileSystem nPOIFSFileSystem2) throws IOException {
        copyNodes(nPOIFSFileSystem.getRoot(), nPOIFSFileSystem2.getRoot());
    }

    public static void copyNodes(OPOIFSFileSystem oPOIFSFileSystem, OPOIFSFileSystem oPOIFSFileSystem2, List<String> list) throws IOException {
        copyNodes(new FilteringDirectoryNode(oPOIFSFileSystem.getRoot(), list), new FilteringDirectoryNode(oPOIFSFileSystem2.getRoot(), list));
    }

    public static void copyNodes(NPOIFSFileSystem nPOIFSFileSystem, NPOIFSFileSystem nPOIFSFileSystem2, List<String> list) throws IOException {
        copyNodes(new FilteringDirectoryNode(nPOIFSFileSystem.getRoot(), list), new FilteringDirectoryNode(nPOIFSFileSystem2.getRoot(), list));
    }

    public static boolean areDirectoriesIdentical(DirectoryEntry directoryEntry, DirectoryEntry directoryEntry2) {
        boolean zAreDocumentsIdentical;
        if (!directoryEntry.getName().equals(directoryEntry2.getName()) || directoryEntry.getEntryCount() != directoryEntry2.getEntryCount()) {
            return false;
        }
        HashMap map = new HashMap();
        for (Entry entry : directoryEntry) {
            String name = entry.getName();
            if (entry.isDirectoryEntry()) {
                map.put(name, -12345);
            } else {
                map.put(name, Integer.valueOf(((DocumentNode) entry).getSize()));
            }
        }
        for (Entry entry2 : directoryEntry2) {
            String name2 = entry2.getName();
            if (!map.containsKey(name2)) {
                return false;
            }
            if ((entry2.isDirectoryEntry() ? -12345 : ((DocumentNode) entry2).getSize()) != ((Integer) map.get(name2)).intValue()) {
                return false;
            }
            map.remove(name2);
        }
        if (!map.isEmpty()) {
            return false;
        }
        for (Entry entry3 : directoryEntry) {
            try {
                Entry entry4 = directoryEntry2.getEntry(entry3.getName());
                if (entry3.isDirectoryEntry()) {
                    zAreDocumentsIdentical = areDirectoriesIdentical((DirectoryEntry) entry3, (DirectoryEntry) entry4);
                } else {
                    zAreDocumentsIdentical = areDocumentsIdentical((DocumentEntry) entry3, (DocumentEntry) entry4);
                }
                if (!zAreDocumentsIdentical) {
                    return false;
                }
            } catch (FileNotFoundException | IOException unused) {
            }
        }
        return true;
    }

    public static boolean areDocumentsIdentical(DocumentEntry documentEntry, DocumentEntry documentEntry2) throws Throwable {
        DocumentInputStream documentInputStream;
        int i;
        boolean z = false;
        if (!documentEntry.getName().equals(documentEntry2.getName()) || documentEntry.getSize() != documentEntry2.getSize()) {
            return false;
        }
        DocumentInputStream documentInputStream2 = null;
        try {
            DocumentInputStream documentInputStream3 = new DocumentInputStream(documentEntry);
            try {
                documentInputStream = new DocumentInputStream(documentEntry2);
                do {
                    try {
                        int i2 = documentInputStream3.read();
                        i = documentInputStream.read();
                        if (i2 == i) {
                            if (i2 == -1) {
                                break;
                            }
                        }
                        documentInputStream3.close();
                        documentInputStream.close();
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        documentInputStream2 = documentInputStream3;
                        if (documentInputStream2 != null) {
                            documentInputStream2.close();
                        }
                        if (documentInputStream != null) {
                            documentInputStream.close();
                        }
                        throw th;
                    }
                } while (i != -1);
                z = true;
                documentInputStream3.close();
                documentInputStream.close();
                return z;
            } catch (Throwable th2) {
                th = th2;
                documentInputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            documentInputStream = null;
        }
    }
}
