package org.apache.poi.poifs.dev;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.poifs.filesystem.DocumentNode;
import org.apache.poi.poifs.filesystem.Entry;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.poifs.filesystem.NPOIFSStream;
import org.apache.poi.util.IOUtils;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class POIFSDump {
    public static void main(String[] strArr) throws IOException {
        if (strArr.length == 0) {
            System.err.println("Must specify at least one file to dump");
            System.exit(1);
        }
        boolean z = false;
        boolean z2 = false;
        for (String str : strArr) {
            if (str.equalsIgnoreCase("-dumprops") || str.equalsIgnoreCase("-dump-props") || str.equalsIgnoreCase("-dump-properties")) {
                z = true;
            } else if (str.equalsIgnoreCase("-dumpmini") || str.equalsIgnoreCase("-dump-mini") || str.equalsIgnoreCase("-dump-ministream") || str.equalsIgnoreCase("-dump-mini-stream")) {
                z2 = true;
            } else {
                System.out.println("Dumping " + str);
                FileInputStream fileInputStream = new FileInputStream(str);
                try {
                    NPOIFSFileSystem nPOIFSFileSystem = new NPOIFSFileSystem(fileInputStream);
                    fileInputStream.close();
                    try {
                        DirectoryNode root = nPOIFSFileSystem.getRoot();
                        File file = new File(new File(new File(str).getName() + "_dump"), root.getName());
                        if (!file.exists() && !file.mkdirs()) {
                            throw new IOException("Could not create directory " + file);
                        }
                        dump(root, file);
                        if (z) {
                            dump(nPOIFSFileSystem, nPOIFSFileSystem.getHeaderBlock().getPropertyStart(), "properties", file);
                        }
                        if (z2) {
                            int startBlock = nPOIFSFileSystem.getPropertyTable().getRoot().getStartBlock();
                            if (startBlock == -2) {
                                System.err.println("No Mini Stream in file");
                            } else {
                                dump(nPOIFSFileSystem, startBlock, "mini-stream", file);
                            }
                        }
                        nPOIFSFileSystem.close();
                    } catch (Throwable th) {
                        nPOIFSFileSystem.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    fileInputStream.close();
                    throw th2;
                }
            }
        }
    }

    public static void dump(DirectoryEntry directoryEntry, File file) throws IOException {
        Iterator<Entry> entries = directoryEntry.getEntries();
        while (entries.hasNext()) {
            Entry next = entries.next();
            if (next instanceof DocumentNode) {
                DocumentNode documentNode = (DocumentNode) next;
                DocumentInputStream documentInputStream = new DocumentInputStream(documentNode);
                byte[] byteArray = IOUtils.toByteArray(documentInputStream);
                documentInputStream.close();
                FileOutputStream fileOutputStream = new FileOutputStream(new File(file, documentNode.getName().trim()));
                try {
                    fileOutputStream.write(byteArray);
                    fileOutputStream.close();
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } else if (next instanceof DirectoryEntry) {
                DirectoryEntry directoryEntry2 = (DirectoryEntry) next;
                File file2 = new File(file, next.getName());
                if (!file2.exists() && !file2.mkdirs()) {
                    throw new IOException("Could not create directory " + file2);
                }
                dump(directoryEntry2, file2);
            } else {
                System.err.println("Skipping unsupported POIFS entry: " + next);
            }
        }
    }

    public static void dump(NPOIFSFileSystem nPOIFSFileSystem, int i, String str, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(file, str));
        try {
            NPOIFSStream nPOIFSStream = new NPOIFSStream(nPOIFSFileSystem, i);
            byte[] bArr = new byte[nPOIFSFileSystem.getBigBlockSize()];
            for (ByteBuffer byteBuffer : nPOIFSStream) {
                int iRemaining = byteBuffer.remaining();
                byteBuffer.get(bArr);
                fileOutputStream.write(bArr, 0, iRemaining);
            }
            fileOutputStream.close();
        } catch (Throwable th) {
            fileOutputStream.close();
            throw th;
        }
    }
}
