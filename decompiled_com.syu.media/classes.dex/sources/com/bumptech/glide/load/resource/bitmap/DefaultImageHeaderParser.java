package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class DefaultImageHeaderParser implements ImageHeaderParser {
    private static final int AVIF_BRAND = 1635150182;
    private static final int AVIS_BRAND = 1635150195;
    static final int EXIF_MAGIC_NUMBER = 65496;
    static final int EXIF_SEGMENT_TYPE = 225;
    private static final int FTYP_HEADER = 1718909296;
    private static final int GIF_HEADER = 4671814;
    private static final int INTEL_TIFF_MAGIC_NUMBER = 18761;
    private static final int MARKER_EOI = 217;
    private static final int MOTOROLA_TIFF_MAGIC_NUMBER = 19789;
    private static final int ORIENTATION_TAG_TYPE = 274;
    private static final int PNG_HEADER = -1991225785;
    private static final int RIFF_HEADER = 1380533830;
    private static final int SEGMENT_SOS = 218;
    static final int SEGMENT_START_ID = 255;
    private static final String TAG = "DfltImageHeaderParser";
    private static final int VP8_HEADER = 1448097792;
    private static final int VP8_HEADER_MASK = -256;
    private static final int VP8_HEADER_TYPE_EXTENDED = 88;
    private static final int VP8_HEADER_TYPE_LOSSLESS = 76;
    private static final int VP8_HEADER_TYPE_MASK = 255;
    private static final int WEBP_EXTENDED_ALPHA_FLAG = 16;
    private static final int WEBP_EXTENDED_ANIMATION_FLAG = 2;
    private static final int WEBP_HEADER = 1464156752;
    private static final int WEBP_LOSSLESS_ALPHA_FLAG = 8;
    private static final String JPEG_EXIF_SEGMENT_PREAMBLE = "Exif\u0000\u0000";
    static final byte[] JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = JPEG_EXIF_SEGMENT_PREAMBLE.getBytes(Charset.forName("UTF-8"));
    private static final int[] BYTES_PER_FORMAT = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    private static int calcTagOffset(int i, int i2) {
        return i + 2 + (i2 * 12);
    }

    private static boolean handles(int i) {
        return (i & EXIF_MAGIC_NUMBER) == EXIF_MAGIC_NUMBER || i == MOTOROLA_TIFF_MAGIC_NUMBER || i == INTEL_TIFF_MAGIC_NUMBER;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType getType(InputStream inputStream) throws IOException {
        return getType(new StreamReader((InputStream) Preconditions.checkNotNull(inputStream)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType getType(ByteBuffer byteBuffer) throws IOException {
        return getType(new ByteBufferReader((ByteBuffer) Preconditions.checkNotNull(byteBuffer)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(InputStream inputStream, ArrayPool arrayPool) throws IOException {
        return getOrientation(new StreamReader((InputStream) Preconditions.checkNotNull(inputStream)), (ArrayPool) Preconditions.checkNotNull(arrayPool));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(ByteBuffer byteBuffer, ArrayPool arrayPool) throws IOException {
        return getOrientation(new ByteBufferReader((ByteBuffer) Preconditions.checkNotNull(byteBuffer)), (ArrayPool) Preconditions.checkNotNull(arrayPool));
    }

    private ImageHeaderParser.ImageType getType(Reader reader) throws IOException {
        try {
            int uInt16 = reader.getUInt16();
            if (uInt16 == EXIF_MAGIC_NUMBER) {
                return ImageHeaderParser.ImageType.JPEG;
            }
            int uInt8 = (uInt16 << 8) | reader.getUInt8();
            if (uInt8 == GIF_HEADER) {
                return ImageHeaderParser.ImageType.GIF;
            }
            int uInt9 = (uInt8 << 8) | reader.getUInt8();
            if (uInt9 == PNG_HEADER) {
                reader.skip(21L);
                try {
                    return reader.getUInt8() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
                } catch (Reader.EndOfFileException unused) {
                    return ImageHeaderParser.ImageType.PNG;
                }
            }
            if (uInt9 != RIFF_HEADER) {
                return sniffAvif(reader, uInt9);
            }
            reader.skip(4L);
            if (((reader.getUInt16() << 16) | reader.getUInt16()) != WEBP_HEADER) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int uInt17 = (reader.getUInt16() << 16) | reader.getUInt16();
            if ((uInt17 & (-256)) != VP8_HEADER) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int i = uInt17 & 255;
            if (i != 88) {
                if (i == VP8_HEADER_TYPE_LOSSLESS) {
                    reader.skip(4L);
                    return (reader.getUInt8() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
                }
                return ImageHeaderParser.ImageType.WEBP;
            }
            reader.skip(4L);
            short uInt10 = reader.getUInt8();
            if ((uInt10 & 2) != 0) {
                return ImageHeaderParser.ImageType.ANIMATED_WEBP;
            }
            if ((uInt10 & 16) != 0) {
                return ImageHeaderParser.ImageType.WEBP_A;
            }
            return ImageHeaderParser.ImageType.WEBP;
        } catch (Reader.EndOfFileException unused2) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
    }

    private ImageHeaderParser.ImageType sniffAvif(Reader reader, int i) throws IOException {
        if (((reader.getUInt16() << 16) | reader.getUInt16()) != FTYP_HEADER) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        int uInt16 = (reader.getUInt16() << 16) | reader.getUInt16();
        if (uInt16 == AVIS_BRAND) {
            return ImageHeaderParser.ImageType.ANIMATED_AVIF;
        }
        int i2 = 0;
        boolean z = uInt16 == AVIF_BRAND;
        reader.skip(4L);
        int i3 = i - 16;
        if (i3 % 4 == 0) {
            while (i2 < 5 && i3 > 0) {
                int uInt17 = (reader.getUInt16() << 16) | reader.getUInt16();
                if (uInt17 == AVIS_BRAND) {
                    return ImageHeaderParser.ImageType.ANIMATED_AVIF;
                }
                if (uInt17 == AVIF_BRAND) {
                    z = true;
                }
                i2++;
                i3 -= 4;
            }
        }
        return z ? ImageHeaderParser.ImageType.AVIF : ImageHeaderParser.ImageType.UNKNOWN;
    }

    private int getOrientation(Reader reader, ArrayPool arrayPool) throws IOException {
        try {
            int uInt16 = reader.getUInt16();
            if (!handles(uInt16)) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Parser doesn't handle magic number: " + uInt16);
                }
                return -1;
            }
            int iMoveToExifSegmentAndGetLength = moveToExifSegmentAndGetLength(reader);
            if (iMoveToExifSegmentAndGetLength == -1) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Failed to parse exif segment length, or exif segment not found");
                }
                return -1;
            }
            byte[] bArr = (byte[]) arrayPool.get(iMoveToExifSegmentAndGetLength, byte[].class);
            try {
                return parseExifSegment(reader, bArr, iMoveToExifSegmentAndGetLength);
            } finally {
                arrayPool.put(bArr);
            }
        } catch (Reader.EndOfFileException unused) {
            return -1;
        }
    }

    private int parseExifSegment(Reader reader, byte[] bArr, int i) throws IOException {
        int i2 = reader.read(bArr, i);
        if (i2 != i) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Unable to read exif segment data, length: " + i + ", actually read: " + i2);
            }
            return -1;
        }
        if (hasJpegExifPreamble(bArr, i)) {
            return parseExifSegment(new RandomAccessReader(bArr, i));
        }
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "Missing jpeg exif preamble");
        }
        return -1;
    }

    private boolean hasJpegExifPreamble(byte[] bArr, int i) {
        boolean z = bArr != null && i > JPEG_EXIF_SEGMENT_PREAMBLE_BYTES.length;
        if (z) {
            int i2 = 0;
            while (true) {
                byte[] bArr2 = JPEG_EXIF_SEGMENT_PREAMBLE_BYTES;
                if (i2 >= bArr2.length) {
                    break;
                }
                if (bArr[i2] != bArr2[i2]) {
                    return false;
                }
                i2++;
            }
        }
        return z;
    }

    private int moveToExifSegmentAndGetLength(Reader reader) throws IOException {
        short uInt8;
        int uInt16;
        long j;
        long jSkip;
        do {
            short uInt9 = reader.getUInt8();
            if (uInt9 != 255) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Unknown segmentId=" + ((int) uInt9));
                }
                return -1;
            }
            uInt8 = reader.getUInt8();
            if (uInt8 == SEGMENT_SOS) {
                return -1;
            }
            if (uInt8 == MARKER_EOI) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            uInt16 = reader.getUInt16() - 2;
            if (uInt8 == 225) {
                return uInt16;
            }
            j = uInt16;
            jSkip = reader.skip(j);
        } while (jSkip == j);
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "Unable to skip enough data, type: " + ((int) uInt8) + ", wanted to skip: " + uInt16 + ", but actually skipped: " + jSkip);
        }
        return -1;
    }

    private static int parseExifSegment(RandomAccessReader randomAccessReader) {
        ByteOrder byteOrder;
        short int16 = randomAccessReader.getInt16(6);
        if (int16 == INTEL_TIFF_MAGIC_NUMBER) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            if (int16 != MOTOROLA_TIFF_MAGIC_NUMBER && Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Unknown endianness = " + ((int) int16));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        randomAccessReader.order(byteOrder);
        int int32 = randomAccessReader.getInt32(10) + 6;
        short int17 = randomAccessReader.getInt16(int32);
        for (int i = 0; i < int17; i++) {
            int iCalcTagOffset = calcTagOffset(int32, i);
            short int18 = randomAccessReader.getInt16(iCalcTagOffset);
            if (int18 == ORIENTATION_TAG_TYPE) {
                short int19 = randomAccessReader.getInt16(iCalcTagOffset + 2);
                if (int19 < 1 || int19 > 12) {
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Got invalid format code = " + ((int) int19));
                    }
                } else {
                    int int33 = randomAccessReader.getInt32(iCalcTagOffset + 4);
                    if (int33 < 0) {
                        if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, "Negative tiff component count");
                        }
                    } else {
                        if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, "Got tagIndex=" + i + " tagType=" + ((int) int18) + " formatCode=" + ((int) int19) + " componentCount=" + int33);
                        }
                        int i2 = int33 + BYTES_PER_FORMAT[int19];
                        if (i2 > 4) {
                            if (Log.isLoggable(TAG, 3)) {
                                Log.d(TAG, "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) int19));
                            }
                        } else {
                            int i3 = iCalcTagOffset + 8;
                            if (i3 < 0 || i3 > randomAccessReader.length()) {
                                if (Log.isLoggable(TAG, 3)) {
                                    Log.d(TAG, "Illegal tagValueOffset=" + i3 + " tagType=" + ((int) int18));
                                }
                            } else if (i2 < 0 || i2 + i3 > randomAccessReader.length()) {
                                if (Log.isLoggable(TAG, 3)) {
                                    Log.d(TAG, "Illegal number of bytes for TI tag data tagType=" + ((int) int18));
                                }
                            } else {
                                return randomAccessReader.getInt16(i3);
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    private static final class RandomAccessReader {
        private final ByteBuffer data;

        RandomAccessReader(byte[] bArr, int i) {
            this.data = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        void order(ByteOrder byteOrder) {
            this.data.order(byteOrder);
        }

        int length() {
            return this.data.remaining();
        }

        int getInt32(int i) {
            if (isAvailable(i, 4)) {
                return this.data.getInt(i);
            }
            return -1;
        }

        short getInt16(int i) {
            if (isAvailable(i, 2)) {
                return this.data.getShort(i);
            }
            return (short) -1;
        }

        private boolean isAvailable(int i, int i2) {
            return this.data.remaining() - i >= i2;
        }
    }

    private interface Reader {
        int getUInt16() throws IOException;

        short getUInt8() throws IOException;

        int read(byte[] bArr, int i) throws IOException;

        long skip(long j) throws IOException;

        public static final class EndOfFileException extends IOException {
            private static final long serialVersionUID = 1;

            EndOfFileException() {
                super("Unexpectedly reached end of a file");
            }
        }
    }

    private static final class ByteBufferReader implements Reader {
        private final ByteBuffer byteBuffer;

        ByteBufferReader(ByteBuffer byteBuffer) {
            this.byteBuffer = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short getUInt8() throws Reader.EndOfFileException {
            if (this.byteBuffer.remaining() < 1) {
                throw new Reader.EndOfFileException();
            }
            return (short) (this.byteBuffer.get() & 255);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int getUInt16() throws Reader.EndOfFileException {
            return (getUInt8() << 8) | getUInt8();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int read(byte[] bArr, int i) {
            int iMin = Math.min(i, this.byteBuffer.remaining());
            if (iMin == 0) {
                return -1;
            }
            this.byteBuffer.get(bArr, 0, iMin);
            return iMin;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long j) {
            int iMin = (int) Math.min(this.byteBuffer.remaining(), j);
            ByteBuffer byteBuffer = this.byteBuffer;
            byteBuffer.position(byteBuffer.position() + iMin);
            return iMin;
        }
    }

    private static final class StreamReader implements Reader {
        private final InputStream is;

        StreamReader(InputStream inputStream) {
            this.is = inputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short getUInt8() throws IOException {
            int i = this.is.read();
            if (i != -1) {
                return (short) i;
            }
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int getUInt16() throws IOException {
            return (getUInt8() << 8) | getUInt8();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int read(byte[] bArr, int i) throws IOException {
            int i2 = 0;
            int i3 = 0;
            while (i2 < i && (i3 = this.is.read(bArr, i2, i - i2)) != -1) {
                i2 += i3;
            }
            if (i2 == 0 && i3 == -1) {
                throw new Reader.EndOfFileException();
            }
            return i2;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long j) throws IOException {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long jSkip = this.is.skip(j2);
                if (jSkip <= 0) {
                    if (this.is.read() == -1) {
                        break;
                    }
                    jSkip = 1;
                }
                j2 -= jSkip;
            }
            return j - j2;
        }
    }
}
