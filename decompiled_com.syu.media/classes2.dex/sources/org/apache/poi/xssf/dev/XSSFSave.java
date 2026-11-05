package org.apache.poi.xssf.dev;

import java.io.FileOutputStream;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class XSSFSave {
    public static void main(String[] strArr) throws Exception {
        for (int i = 0; i < strArr.length; i++) {
            OPCPackage oPCPackageOpen = OPCPackage.open(strArr[i]);
            XSSFWorkbook xSSFWorkbook = new XSSFWorkbook(oPCPackageOpen);
            FileOutputStream fileOutputStream = new FileOutputStream(strArr[i].substring(0, strArr[i].lastIndexOf(46)) + "-save.xls" + (xSSFWorkbook.isMacroEnabled() ? "m" : "x"));
            xSSFWorkbook.write(fileOutputStream);
            fileOutputStream.close();
            oPCPackageOpen.close();
        }
    }
}
