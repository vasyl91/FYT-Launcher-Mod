package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.ByteBufferUtil;
import com.bumptech.glide.util.Preconditions;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
interface ImageReader {
    Bitmap decodeBitmap(BitmapFactory.Options options) throws IOException;

    int getImageOrientation() throws IOException;

    ImageHeaderParser.ImageType getImageType() throws IOException;

    void stopGrowingBuffers();

    public static final class ByteArrayReader implements ImageReader {
        private final ArrayPool byteArrayPool;
        private final byte[] bytes;
        private final List<ImageHeaderParser> parsers;

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public void stopGrowingBuffers() {
        }

        ByteArrayReader(byte[] bArr, List<ImageHeaderParser> list, ArrayPool arrayPool) {
            this.bytes = bArr;
            this.parsers = list;
            this.byteArrayPool = arrayPool;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public Bitmap decodeBitmap(BitmapFactory.Options options) {
            byte[] bArr = this.bytes;
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public ImageHeaderParser.ImageType getImageType() throws IOException {
            return ImageHeaderParserUtils.getType(this.parsers, ByteBuffer.wrap(this.bytes));
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public int getImageOrientation() throws IOException {
            return ImageHeaderParserUtils.getOrientation(this.parsers, ByteBuffer.wrap(this.bytes), this.byteArrayPool);
        }
    }

    public static final class FileReader implements ImageReader {
        private final ArrayPool byteArrayPool;
        private final File file;
        private final List<ImageHeaderParser> parsers;

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public void stopGrowingBuffers() {
        }

        FileReader(File file, List<ImageHeaderParser> list, ArrayPool arrayPool) {
            this.file = file;
            this.parsers = list;
            this.byteArrayPool = arrayPool;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public Bitmap decodeBitmap(BitmapFactory.Options options) throws Throwable {
            RecyclableBufferedInputStream recyclableBufferedInputStream = null;
            try {
                RecyclableBufferedInputStream recyclableBufferedInputStream2 = new RecyclableBufferedInputStream(new FileInputStream(this.file), this.byteArrayPool);
                try {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(recyclableBufferedInputStream2, null, options);
                    try {
                        recyclableBufferedInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return bitmapDecodeStream;
                } catch (Throwable th) {
                    th = th;
                    recyclableBufferedInputStream = recyclableBufferedInputStream2;
                    if (recyclableBufferedInputStream != null) {
                        try {
                            recyclableBufferedInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public ImageHeaderParser.ImageType getImageType() throws Throwable {
            RecyclableBufferedInputStream recyclableBufferedInputStream;
            Throwable th;
            try {
                recyclableBufferedInputStream = new RecyclableBufferedInputStream(new FileInputStream(this.file), this.byteArrayPool);
                try {
                    ImageHeaderParser.ImageType type = ImageHeaderParserUtils.getType(this.parsers, recyclableBufferedInputStream, this.byteArrayPool);
                    try {
                        recyclableBufferedInputStream.close();
                    } catch (IOException unused) {
                    }
                    return type;
                } catch (Throwable th2) {
                    th = th2;
                    if (recyclableBufferedInputStream != null) {
                        try {
                            recyclableBufferedInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                recyclableBufferedInputStream = null;
                th = th3;
            }
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public int getImageOrientation() throws Throwable {
            RecyclableBufferedInputStream recyclableBufferedInputStream;
            Throwable th;
            try {
                recyclableBufferedInputStream = new RecyclableBufferedInputStream(new FileInputStream(this.file), this.byteArrayPool);
                try {
                    int orientation = ImageHeaderParserUtils.getOrientation(this.parsers, recyclableBufferedInputStream, this.byteArrayPool);
                    try {
                        recyclableBufferedInputStream.close();
                    } catch (IOException unused) {
                    }
                    return orientation;
                } catch (Throwable th2) {
                    th = th2;
                    if (recyclableBufferedInputStream != null) {
                        try {
                            recyclableBufferedInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                recyclableBufferedInputStream = null;
                th = th3;
            }
        }
    }

    public static final class ByteBufferReader implements ImageReader {
        private final ByteBuffer buffer;
        private final ArrayPool byteArrayPool;
        private final List<ImageHeaderParser> parsers;

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public void stopGrowingBuffers() {
        }

        ByteBufferReader(ByteBuffer byteBuffer, List<ImageHeaderParser> list, ArrayPool arrayPool) {
            this.buffer = byteBuffer;
            this.parsers = list;
            this.byteArrayPool = arrayPool;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public Bitmap decodeBitmap(BitmapFactory.Options options) {
            return BitmapFactory.decodeStream(stream(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public ImageHeaderParser.ImageType getImageType() throws IOException {
            return ImageHeaderParserUtils.getType(this.parsers, ByteBufferUtil.rewind(this.buffer));
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public int getImageOrientation() throws IOException {
            return ImageHeaderParserUtils.getOrientation(this.parsers, ByteBufferUtil.rewind(this.buffer), this.byteArrayPool);
        }

        private InputStream stream() {
            return ByteBufferUtil.toStream(ByteBufferUtil.rewind(this.buffer));
        }
    }

    public static final class InputStreamImageReader implements ImageReader {
        private final ArrayPool byteArrayPool;
        private final InputStreamRewinder dataRewinder;
        private final List<ImageHeaderParser> parsers;

        InputStreamImageReader(InputStream inputStream, List<ImageHeaderParser> list, ArrayPool arrayPool) {
            this.byteArrayPool = (ArrayPool) Preconditions.checkNotNull(arrayPool);
            this.parsers = (List) Preconditions.checkNotNull(list);
            this.dataRewinder = new InputStreamRewinder(inputStream, arrayPool);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public Bitmap decodeBitmap(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeStream(this.dataRewinder.rewindAndGet(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public ImageHeaderParser.ImageType getImageType() throws IOException {
            return ImageHeaderParserUtils.getType(this.parsers, this.dataRewinder.rewindAndGet(), this.byteArrayPool);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public int getImageOrientation() throws IOException {
            return ImageHeaderParserUtils.getOrientation(this.parsers, this.dataRewinder.rewindAndGet(), this.byteArrayPool);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public void stopGrowingBuffers() {
            this.dataRewinder.fixMarkLimits();
        }
    }

    public static final class ParcelFileDescriptorImageReader implements ImageReader {
        private final ArrayPool byteArrayPool;
        private final ParcelFileDescriptorRewinder dataRewinder;
        private final List<ImageHeaderParser> parsers;

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public void stopGrowingBuffers() {
        }

        ParcelFileDescriptorImageReader(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, ArrayPool arrayPool) {
            this.byteArrayPool = (ArrayPool) Preconditions.checkNotNull(arrayPool);
            this.parsers = (List) Preconditions.checkNotNull(list);
            this.dataRewinder = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public Bitmap decodeBitmap(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeFileDescriptor(this.dataRewinder.rewindAndGet().getFileDescriptor(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public ImageHeaderParser.ImageType getImageType() throws IOException {
            return ImageHeaderParserUtils.getType(this.parsers, this.dataRewinder, this.byteArrayPool);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public int getImageOrientation() throws IOException {
            return ImageHeaderParserUtils.getOrientation(this.parsers, this.dataRewinder, this.byteArrayPool);
        }
    }
}
