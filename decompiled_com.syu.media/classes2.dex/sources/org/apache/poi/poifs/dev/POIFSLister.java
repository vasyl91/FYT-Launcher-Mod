package org.apache.poi.poifs.dev;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentNode;
import org.apache.poi.poifs.filesystem.Entry;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class POIFSLister {
    public static void main(String[] strArr) throws IOException {
        if (strArr.length == 0) {
            System.err.println("Must specify at least one file to view");
            System.exit(1);
        }
        boolean z = false;
        boolean z2 = true;
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equalsIgnoreCase("-size") || strArr[i].equalsIgnoreCase("-sizes")) {
                z = true;
            } else if (strArr[i].equalsIgnoreCase("-old") || strArr[i].equalsIgnoreCase("-old-poifs")) {
                z2 = false;
            } else if (z2) {
                viewFile(strArr[i], z);
            } else {
                viewFileOld(strArr[i], z);
            }
        }
    }

    public static void viewFile(String str, boolean z) throws IOException {
        NPOIFSFileSystem nPOIFSFileSystem = new NPOIFSFileSystem(new File(str));
        displayDirectory(nPOIFSFileSystem.getRoot(), "", z);
        nPOIFSFileSystem.close();
    }

    public static void viewFileOld(String str, boolean z) throws IOException {
        POIFSFileSystem pOIFSFileSystem = new POIFSFileSystem(new FileInputStream(str));
        displayDirectory(pOIFSFileSystem.getRoot(), "", z);
        pOIFSFileSystem.close();
    }

    public static void displayDirectory(DirectoryNode directoryNode, String str, boolean z) {
        System.out.println(str + directoryNode.getName() + " -");
        String str2 = str + "  ";
        Iterator<Entry> entries = directoryNode.getEntries();
        boolean z2 = false;
        while (entries.hasNext()) {
            Entry next = entries.next();
            if (next instanceof DirectoryNode) {
                displayDirectory((DirectoryNode) next, str2, z);
            } else {
                DocumentNode documentNode = (DocumentNode) next;
                String name = documentNode.getName();
                if (name.charAt(0) < '\n') {
                    name = name.substring(1) + " <" + ("(0x0" + ((int) name.charAt(0)) + ")" + name.substring(1)) + ">";
                }
                System.out.println(str2 + name + (z ? " [" + documentNode.getSize() + " / 0x" + Integer.toHexString(documentNode.getSize()) + "]" : ""));
            }
            z2 = true;
        }
        if (z2) {
            return;
        }
        System.out.println(str2 + "(no children)");
    }
}
