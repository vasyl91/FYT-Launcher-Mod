package org.apache.poi.openxml4j.util;

import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ZipSecureFile extends ZipFile {
    private static final long GRACE_ENTRY_SIZE = 102400;
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) ZipSecureFile.class);
    private static double MIN_INFLATE_RATIO = 0.01d;
    private static long MAX_ENTRY_SIZE = 4294967295L;
    private static long MAX_TEXT_SIZE = 10485760;

    public static void setMinInflateRatio(double d) {
        MIN_INFLATE_RATIO = d;
    }

    public static double getMinInflateRatio() {
        return MIN_INFLATE_RATIO;
    }

    public static void setMaxEntrySize(long j) {
        if (j < 0 || j > 4294967295L) {
            throw new IllegalArgumentException("Max entry size is bounded [0-4GB], but had " + j);
        }
        MAX_ENTRY_SIZE = j;
    }

    public static long getMaxEntrySize() {
        return MAX_ENTRY_SIZE;
    }

    public static void setMaxTextSize(long j) {
        if (j < 0 || j > 4294967295L) {
            throw new IllegalArgumentException("Max text size is bounded [0-4GB], but had " + j);
        }
        MAX_TEXT_SIZE = j;
    }

    public static long getMaxTextSize() {
        return MAX_TEXT_SIZE;
    }

    public ZipSecureFile(File file, int i) throws IOException {
        super(file, i);
    }

    public ZipSecureFile(File file) throws IOException {
        super(file);
    }

    public ZipSecureFile(String str) throws IOException {
        super(str);
    }

    @Override // java.util.zip.ZipFile
    public InputStream getInputStream(ZipEntry zipEntry) throws IOException {
        return addThreshold(super.getInputStream(zipEntry));
    }

    public static ThresholdInputStream addThreshold(final InputStream inputStream) throws IOException {
        return new ThresholdInputStream(inputStream, inputStream instanceof InflaterInputStream ? (ThresholdInputStream) AccessController.doPrivileged(new PrivilegedAction<ThresholdInputStream>() { // from class: org.apache.poi.openxml4j.util.ZipSecureFile.1
            @Override // java.security.PrivilegedAction
            public ThresholdInputStream run() {
                try {
                    Field declaredField = FilterInputStream.class.getDeclaredField("in");
                    declaredField.setAccessible(true);
                    ThresholdInputStream thresholdInputStream = new ThresholdInputStream((InputStream) declaredField.get(inputStream), null);
                    declaredField.set(inputStream, thresholdInputStream);
                    return thresholdInputStream;
                } catch (Exception e) {
                    ZipSecureFile.LOG.log(5, "SecurityManager doesn't allow manipulation via reflection for zipbomb detection - continue with original input stream", e);
                    return null;
                }
            }
        }) : null);
    }

    public static class ThresholdInputStream extends PushbackInputStream {
        ThresholdInputStream cis;
        long counter;
        long markPos;

        public ThresholdInputStream(InputStream inputStream, ThresholdInputStream thresholdInputStream) {
            super(inputStream);
            this.counter = 0L;
            this.markPos = 0L;
            this.cis = thresholdInputStream;
        }

        @Override // java.io.PushbackInputStream, java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i = this.in.read();
            if (i > -1) {
                advance(1);
            }
            return i;
        }

        @Override // java.io.PushbackInputStream, java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.in.read(bArr, i, i2);
            if (i3 > -1) {
                advance(i3);
            }
            return i3;
        }

        @Override // java.io.PushbackInputStream, java.io.FilterInputStream, java.io.InputStream
        public long skip(long j) throws IOException {
            long jSkip = this.in.skip(j);
            this.counter += jSkip;
            return jSkip;
        }

        @Override // java.io.PushbackInputStream, java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() throws IOException {
            this.counter = this.markPos;
            super.reset();
        }

        public void advance(int i) throws IOException {
            long j = this.counter + ((long) i);
            this.counter = j;
            if (j > ZipSecureFile.MAX_ENTRY_SIZE) {
                StringBuilder sbAppend = new StringBuilder("Zip bomb detected! The file would exceed the max size of the expanded data in the zip-file. This may indicates that the file is used to inflate memory usage and thus could pose a security risk. You can adjust this limit via ZipSecureFile.setMaxEntrySize() if you need to work with files which are very large. Counter: ").append(this.counter).append(", cis.counter: ");
                ThresholdInputStream thresholdInputStream = this.cis;
                throw new IOException(sbAppend.append(thresholdInputStream == null ? 0L : thresholdInputStream.counter).append("Limits: MAX_ENTRY_SIZE: ").append(ZipSecureFile.MAX_ENTRY_SIZE).toString());
            }
            ThresholdInputStream thresholdInputStream2 = this.cis;
            if (thresholdInputStream2 == null) {
                return;
            }
            long j2 = this.counter;
            if (j2 <= ZipSecureFile.GRACE_ENTRY_SIZE) {
                return;
            }
            double d = thresholdInputStream2.counter / j2;
            if (d < ZipSecureFile.MIN_INFLATE_RATIO) {
                throw new IOException("Zip bomb detected! The file would exceed the max. ratio of compressed file size to the size of the expanded data.\nThis may indicate that the file is used to inflate memory usage and thus could pose a security risk.\nYou can adjust this limit via ZipSecureFile.setMinInflateRatio() if you need to work with files which exceed this limit.\nCounter: " + this.counter + ", cis.counter: " + this.cis.counter + ", ratio: " + d + "\nLimits: MIN_INFLATE_RATIO: " + ZipSecureFile.MIN_INFLATE_RATIO);
            }
        }

        public ZipEntry getNextEntry() throws IOException {
            if (!(this.in instanceof ZipInputStream)) {
                throw new UnsupportedOperationException("underlying stream is not a ZipInputStream");
            }
            this.counter = 0L;
            return ((ZipInputStream) this.in).getNextEntry();
        }

        public void closeEntry() throws IOException {
            if (!(this.in instanceof ZipInputStream)) {
                throw new UnsupportedOperationException("underlying stream is not a ZipInputStream");
            }
            this.counter = 0L;
            ((ZipInputStream) this.in).closeEntry();
        }

        @Override // java.io.PushbackInputStream
        public void unread(int i) throws IOException {
            if (!(this.in instanceof PushbackInputStream)) {
                throw new UnsupportedOperationException("underlying stream is not a PushbackInputStream");
            }
            long j = this.counter - 1;
            this.counter = j;
            if (j < 0) {
                this.counter = 0L;
            }
            ((PushbackInputStream) this.in).unread(i);
        }

        @Override // java.io.PushbackInputStream
        public void unread(byte[] bArr, int i, int i2) throws IOException {
            if (!(this.in instanceof PushbackInputStream)) {
                throw new UnsupportedOperationException("underlying stream is not a PushbackInputStream");
            }
            long j = (this.counter - ((long) i2)) - 1;
            this.counter = j;
            if (j < 0) {
                this.counter = 0L;
            }
            ((PushbackInputStream) this.in).unread(bArr, i, i2);
        }

        @Override // java.io.PushbackInputStream, java.io.FilterInputStream, java.io.InputStream
        public int available() throws IOException {
            return this.in.available();
        }

        @Override // java.io.PushbackInputStream, java.io.FilterInputStream, java.io.InputStream
        public boolean markSupported() {
            return this.in.markSupported();
        }

        @Override // java.io.PushbackInputStream, java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i) {
            this.markPos = this.counter;
            this.in.mark(i);
        }
    }
}
