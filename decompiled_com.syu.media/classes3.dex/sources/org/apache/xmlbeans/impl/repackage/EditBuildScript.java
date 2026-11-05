package org.apache.xmlbeans.impl.repackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class EditBuildScript {
    public static void main(String[] strArr) throws Exception {
        if (strArr.length != 3) {
            throw new IllegalArgumentException("Wrong number of arguments");
        }
        strArr[0] = strArr[0].replace('/', File.separatorChar);
        File file = new File(strArr[0]);
        StringBuffer file2 = readFile(file);
        String str = "<property name=\"" + strArr[1] + "\" value=\"";
        int iIndexOf = file2.indexOf(str);
        if (iIndexOf < 0) {
            throw new IllegalArgumentException("Can't find token: " + str);
        }
        int length = str.length() + iIndexOf;
        while (file2.charAt(length) != '\"') {
            length++;
        }
        file2.replace(iIndexOf + str.length(), length, strArr[2]);
        writeFile(file, file2);
    }

    static StringBuffer readFile(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        StringWriter stringWriter = new StringWriter();
        copy(inputStreamReader, stringWriter);
        stringWriter.close();
        inputStreamReader.close();
        fileInputStream.close();
        return stringWriter.getBuffer();
    }

    static void writeFile(File file, StringBuffer stringBuffer) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        StringReader stringReader = new StringReader(stringBuffer.toString());
        copy(stringReader, outputStreamWriter);
        stringReader.close();
        outputStreamWriter.close();
        fileOutputStream.close();
    }

    static void copy(Reader reader, Writer writer) throws IOException {
        char[] cArr = new char[16384];
        while (true) {
            int i = reader.read(cArr, 0, 16384);
            if (i < 0) {
                return;
            } else {
                writer.write(cArr, 0, i);
            }
        }
    }
}
