package com.syu.canbus;

import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipCompare {
    public static boolean isSameZip(InputStream input1, InputStream input2) {
        ZipEntry entry1;
        ZipEntry entry2;
        ZipInputStream zipInputStream1 = new ZipInputStream(input1);
        ZipInputStream zipInputStream2 = new ZipInputStream(input2);
        do {
            try {
                entry1 = zipInputStream1.getNextEntry();
                if (entry1 == null) {
                    return zipInputStream2.getNextEntry() == null;
                }
                entry2 = zipInputStream2.getNextEntry();
                if (entry2 == null || entry1.getTime() != entry2.getTime() || entry1.getSize() != entry2.getSize()) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        } while (entry1.getCrc() == entry2.getCrc());
        return false;
    }
}
