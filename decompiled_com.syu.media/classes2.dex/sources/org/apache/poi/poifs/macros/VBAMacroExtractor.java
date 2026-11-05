package org.apache.poi.poifs.macros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class VBAMacroExtractor {
    public static void main(String[] strArr) throws IOException {
        if (strArr.length == 0) {
            System.err.println("Use:");
            System.err.println("   VBAMacroExtractor <office.doc> [output]");
            System.err.println("");
            System.err.println("If an output directory is given, macros are written there");
            System.err.println("Otherwise they are output to the screen");
            System.exit(1);
        }
        new VBAMacroExtractor().extract(new File(strArr[0]), strArr.length > 1 ? new File(strArr[1]) : null);
    }

    public void extract(File file, File file2, String str) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException(file.toString());
        }
        System.err.print("Extracting VBA Macros from " + file + " to ");
        if (file2 != null) {
            if (!file2.exists() && !file2.mkdirs()) {
                throw new IOException("Output directory " + file2 + " could not be created");
            }
            System.err.println(file2);
        } else {
            System.err.println("STDOUT");
        }
        VBAMacroReader vBAMacroReader = new VBAMacroReader(file);
        Map<String, String> macros = vBAMacroReader.readMacros();
        vBAMacroReader.close();
        for (Map.Entry<String, String> entry : macros.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (file2 == null) {
                System.out.println("---------------------------------------");
                System.out.println(key);
                System.out.println("");
                System.out.println(value);
            } else {
                File file3 = new File(file2, key + str);
                FileOutputStream fileOutputStream = new FileOutputStream(file3);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, StringUtil.UTF8);
                outputStreamWriter.write(value);
                outputStreamWriter.close();
                fileOutputStream.close();
                System.out.println("Extracted " + file3);
            }
        }
        if (file2 == null) {
            System.out.println("---------------------------------------");
        }
    }

    public void extract(File file, File file2) throws IOException {
        extract(file, file2, ".vba");
    }
}
