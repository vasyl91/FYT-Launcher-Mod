package com.syu.canbus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.junit.jupiter.api.Test;

class ZipCompareTest {

    private static byte[] zip(String... namesAndContents) throws IOException {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        try (ZipOutputStream out = new ZipOutputStream(bytes)) {
            for (int i = 0; i < namesAndContents.length; i += 2) {
                ZipEntry entry = new ZipEntry(namesAndContents[i]);
                entry.setTime(1_000_000_000_000L);
                out.putNextEntry(entry);
                out.write(namesAndContents[i + 1].getBytes("UTF-8"));
                out.closeEntry();
            }
        }
        return bytes.toByteArray();
    }

    @Test
    void theSameZipIsTheSame() throws IOException {
        byte[] a = zip("one", "1", "two", "22");
        assertTrue(ZipCompare.isSameZip(new ByteArrayInputStream(a), new ByteArrayInputStream(a)));
    }

    @Test
    void zipsWithADifferentNumberOfEntriesDiffer() throws IOException {
        byte[] a = zip("one", "1", "two", "22");
        byte[] fewer = zip("one", "1");
        assertFalse(ZipCompare.isSameZip(new ByteArrayInputStream(a), new ByteArrayInputStream(fewer)));
        assertFalse(ZipCompare.isSameZip(new ByteArrayInputStream(fewer), new ByteArrayInputStream(a)));
    }

    @Test
    void theCallersStreamsStayOpenAndCanBeReset() throws IOException {
        byte[] a = zip("one", "1");
        final boolean[] closed = {false};
        ByteArrayInputStream first = new ByteArrayInputStream(a) {
            @Override
            public void close() throws IOException {
                closed[0] = true;
                super.close();
            }
        };
        first.mark(a.length);
        assertTrue(ZipCompare.isSameZip(first, new ByteArrayInputStream(a)));
        assertFalse(closed[0]);
        first.reset();
        assertEquals(a.length, first.available());
    }
}
