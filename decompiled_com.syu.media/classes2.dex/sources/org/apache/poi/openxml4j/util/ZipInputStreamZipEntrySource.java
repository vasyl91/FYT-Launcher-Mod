package org.apache.poi.openxml4j.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ZipInputStreamZipEntrySource implements ZipEntrySource {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private ArrayList<FakeZipEntry> zipEntries = new ArrayList<>();

    public ZipInputStreamZipEntrySource(ZipSecureFile.ThresholdInputStream thresholdInputStream) throws IOException {
        boolean z = true;
        while (z) {
            ZipEntry nextEntry = thresholdInputStream.getNextEntry();
            if (nextEntry == null) {
                z = false;
            } else {
                FakeZipEntry fakeZipEntry = new FakeZipEntry(nextEntry, thresholdInputStream);
                thresholdInputStream.closeEntry();
                this.zipEntries.add(fakeZipEntry);
            }
        }
        thresholdInputStream.close();
    }

    @Override // org.apache.poi.openxml4j.util.ZipEntrySource
    public Enumeration<? extends ZipEntry> getEntries() {
        return new EntryEnumerator();
    }

    @Override // org.apache.poi.openxml4j.util.ZipEntrySource
    public InputStream getInputStream(ZipEntry zipEntry) {
        return ((FakeZipEntry) zipEntry).getInputStream();
    }

    @Override // org.apache.poi.openxml4j.util.ZipEntrySource, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.zipEntries = null;
    }

    @Override // org.apache.poi.openxml4j.util.ZipEntrySource
    public boolean isClosed() {
        return this.zipEntries == null;
    }

    private class EntryEnumerator implements Enumeration<ZipEntry> {
        private Iterator<? extends ZipEntry> iterator;

        private EntryEnumerator() {
            this.iterator = ZipInputStreamZipEntrySource.this.zipEntries.iterator();
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Enumeration
        public ZipEntry nextElement() {
            return this.iterator.next();
        }
    }

    public static class FakeZipEntry extends ZipEntry {
        private byte[] data;

        public FakeZipEntry(ZipEntry zipEntry, InputStream inputStream) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream;
            super(zipEntry.getName());
            long size = zipEntry.getSize();
            if (size == -1) {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } else {
                if (size >= 2147483647L) {
                    throw new IOException("ZIP entry size is too large");
                }
                byteArrayOutputStream = new ByteArrayOutputStream((int) size);
            }
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    this.data = byteArrayOutputStream.toByteArray();
                    return;
                }
            }
        }

        public InputStream getInputStream() {
            return new ByteArrayInputStream(this.data);
        }
    }
}
