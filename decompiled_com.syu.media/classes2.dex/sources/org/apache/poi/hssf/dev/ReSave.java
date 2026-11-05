package org.apache.poi.hssf.dev;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ReSave {
    public static void main(String[] strArr) throws Exception {
        OutputStream fileOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean z = false;
        boolean z2 = false;
        for (String str : strArr) {
            if (str.equals("-dg")) {
                z = true;
            } else if (str.equals("-bos")) {
                z2 = true;
            } else {
                System.out.print("reading " + str + "...");
                FileInputStream fileInputStream = new FileInputStream(str);
                HSSFWorkbook hSSFWorkbook = new HSSFWorkbook(fileInputStream);
                try {
                    System.out.println("done");
                    for (int i = 0; i < hSSFWorkbook.getNumberOfSheets(); i++) {
                        HSSFSheet sheetAt = hSSFWorkbook.getSheetAt(i);
                        if (z) {
                            sheetAt.getDrawingPatriarch();
                        }
                    }
                    if (z2) {
                        byteArrayOutputStream.reset();
                        fileOutputStream = byteArrayOutputStream;
                    } else {
                        String strReplace = str.replace(".xls", "-saved.xls");
                        System.out.print("saving to " + strReplace + "...");
                        fileOutputStream = new FileOutputStream(strReplace);
                    }
                    try {
                        hSSFWorkbook.write(fileOutputStream);
                        fileOutputStream.close();
                        System.out.println("done");
                        hSSFWorkbook.close();
                        fileInputStream.close();
                    } catch (Throwable th) {
                        fileOutputStream.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    hSSFWorkbook.close();
                    fileInputStream.close();
                    throw th2;
                }
            }
        }
    }
}
