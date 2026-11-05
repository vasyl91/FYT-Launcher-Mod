package org.apache.poi.poifs.dev;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class POIFSViewer {
    public static void main(String[] strArr) {
        if (strArr.length == 0) {
            System.err.println("Must specify at least one file to view");
            System.exit(1);
        }
        boolean z = strArr.length > 1;
        for (String str : strArr) {
            viewFile(str, z);
        }
    }

    private static void viewFile(String str, boolean z) {
        if (z) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(".");
            for (int i = 0; i < str.length(); i++) {
                stringBuffer.append("-");
            }
            stringBuffer.append(".");
            System.out.println(stringBuffer);
            System.out.println("|" + str + "|");
            System.out.println(stringBuffer);
        }
        try {
            NPOIFSFileSystem nPOIFSFileSystem = new NPOIFSFileSystem(new File(str));
            Iterator<String> it = POIFSViewEngine.inspectViewable(nPOIFSFileSystem, true, 0, "  ").iterator();
            while (it.hasNext()) {
                System.out.print(it.next());
            }
            nPOIFSFileSystem.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
