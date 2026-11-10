package org.apache.poi.util;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.zip.CRC32;
import org.apache.poi.EmptyFileException;
import org.apache.poi.POIDocument;
import org.apache.poi.ss.usermodel.Workbook;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class IOUtils {
    private static final int SKIP_BUFFER_SIZE = 2048;
    private static byte[] SKIP_BYTE_BUFFER;
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) IOUtils.class);

    private IOUtils() {
    }

    public static byte[] peekFirst8Bytes(InputStream inputStream) throws EmptyFileException, IOException {
        return peekFirstNBytes(inputStream, 8);
    }

    public static byte[] peekFirstNBytes(InputStream inputStream, int i) throws EmptyFileException, IOException {
        inputStream.mark(i);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i);
        copy(new BoundedInputStream(inputStream, i), byteArrayOutputStream);
        int size = byteArrayOutputStream.size();
        if (size == 0) {
            throw new EmptyFileException();
        }
        if (size < i) {
            byteArrayOutputStream.write(new byte[i - size]);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (inputStream instanceof PushbackInputStream) {
            ((PushbackInputStream) inputStream).unread(byteArray, 0, size);
        } else {
            inputStream.reset();
        }
        return byteArray;
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        return toByteArray(inputStream, Integer.MAX_VALUE);
    }

    public static byte[] toByteArray(InputStream inputStream, int i) throws IOException {
        int i2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i == Integer.MAX_VALUE ? 4096 : i);
        byte[] bArr = new byte[4096];
        int iMax = 0;
        do {
            i2 = inputStream.read(bArr, 0, Math.min(4096, i - iMax));
            iMax += Math.max(i2, 0);
            if (i2 > 0) {
                byteArrayOutputStream.write(bArr, 0, i2);
            }
            if (iMax >= i) {
                break;
            }
        } while (i2 > -1);
        if (i != Integer.MAX_VALUE && iMax < i) {
            throw new IOException("unexpected EOF");
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] toByteArray(ByteBuffer byteBuffer, int i) {
        if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            return byteBuffer.array();
        }
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return bArr;
    }

    public static int readFully(InputStream inputStream, byte[] bArr) throws IOException {
        return readFully(inputStream, bArr, 0, bArr.length);
    }

    public static int readFully(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        do {
            int i4 = inputStream.read(bArr, i + i3, i2 - i3);
            if (i4 < 0) {
                if (i3 == 0) {
                    return -1;
                }
                return i3;
            }
            i3 += i4;
        } while (i3 != i2);
        return i3;
    }

    public static int readFully(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer) throws IOException {
        int i = 0;
        do {
            int i2 = readableByteChannel.read(byteBuffer);
            if (i2 >= 0) {
                i += i2;
                if (i == byteBuffer.capacity()) {
                    break;
                }
            } else {
                if (i == 0) {
                    return -1;
                }
                return i;
            }
        } while (byteBuffer.position() != byteBuffer.capacity());
        return i;
    }

    public static void write(POIDocument pOIDocument, OutputStream outputStream) throws IOException {
        try {
            pOIDocument.write(outputStream);
        } finally {
            closeQuietly(outputStream);
        }
    }

    public static void write(Workbook workbook, OutputStream outputStream) throws IOException {
        try {
            workbook.write(outputStream);
        } finally {
            closeQuietly(outputStream);
        }
    }

    public static void writeAndClose(POIDocument pOIDocument, OutputStream outputStream) throws IOException {
        try {
            write(pOIDocument, outputStream);
        } finally {
            closeQuietly(pOIDocument);
        }
    }

    public static void writeAndClose(POIDocument pOIDocument, File file) throws IOException {
        try {
            pOIDocument.write(file);
        } finally {
            closeQuietly(pOIDocument);
        }
    }

    public static void writeAndClose(POIDocument pOIDocument) throws IOException {
        try {
            pOIDocument.write();
        } finally {
            closeQuietly(pOIDocument);
        }
    }

    public static void writeAndClose(Workbook workbook, OutputStream outputStream) throws IOException {
        try {
            workbook.write(outputStream);
        } finally {
            closeQuietly(workbook);
        }
    }

    public static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return;
            }
            if (i < -1) {
                throw new RecordFormatException("Can't have read < -1 bytes");
            }
            if (i > 0) {
                outputStream.write(bArr, 0, i);
            }
        }
    }

    public static long calculateChecksum(byte[] bArr) {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr, 0, bArr.length);
        return crc32.getValue();
    }

    public static long calculateChecksum(InputStream inputStream) throws IOException {
        CRC32 crc32 = new CRC32();
        byte[] bArr = new byte[4096];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return crc32.getValue();
            }
            if (i > 0) {
                crc32.update(bArr, 0, i);
            }
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception e) {
            logger.log(7, "Unable to close resource: " + e, e);
        }
    }

    public static long skipFully(InputStream inputStream, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("Skip count must be non-negative, actual: " + j);
        }
        if (j == 0) {
            return 0L;
        }
        if (SKIP_BYTE_BUFFER == null) {
            SKIP_BYTE_BUFFER = new byte[2048];
        }
        long j2 = j;
        while (j2 > 0) {
            long j3 = inputStream.read(SKIP_BYTE_BUFFER, 0, (int) Math.min(j2, 2048L));
            if (j3 < 0) {
                break;
            }
            j2 -= j3;
        }
        if (j == j2) {
            return -1L;
        }
        return j - j2;
    }

    public static byte[] safelyAllocate(long j, int i) {
        if (j < 0) {
            throw new RecordFormatException("Can't allocate an array of length < 0");
        }
        if (j > 2147483647L) {
            throw new RecordFormatException("Can't allocate an array > 2147483647");
        }
        if (j > i) {
            throw new RecordFormatException("Not allowed to allocate an array > " + i + " for this record type.If the file is not corrupt, please open an issue on bugzilla to request increasing the maximum allowable size for this record type");
        }
        return new byte[(int) j];
    }
}
