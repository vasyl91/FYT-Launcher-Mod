package com.syu.canbus;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipCompare {
    /**
     * Whether the two zips list the same entries (time, size, crc). The streams are left open for
     * the caller, who may reset and read them again; only the zip streams made here are closed,
     * which frees their Inflaters (StrictMode reported them as leaked).
     */
    public static boolean isSameZip(InputStream input1, InputStream input2) {
        ZipInputStream zipInputStream1 = new ZipInputStream(new KeepOpen(input1));
        ZipInputStream zipInputStream2 = new ZipInputStream(new KeepOpen(input2));
        try {
            return sameEntries(zipInputStream1, zipInputStream2);
        } finally {
            closeQuietly(zipInputStream1);
            closeQuietly(zipInputStream2);
        }
    }

    private static boolean sameEntries(ZipInputStream zipInputStream1, ZipInputStream zipInputStream2) {
        ZipEntry entry1;
        ZipEntry entry2;
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

    private static void closeQuietly(ZipInputStream stream) {
        try {
            stream.close();
        } catch (IOException ignored) {
        }
    }

    /** Passes the bytes through; close() does nothing, so closing the zip stream spares the source. */
    private static final class KeepOpen extends FilterInputStream {
        KeepOpen(InputStream in) {
            super(in);
        }

        @Override
        public void close() {
        }
    }
}
