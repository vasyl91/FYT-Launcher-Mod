package androidx.emoji2.text;

import android.content.res.AssetManager;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
class MetadataListReader {
    private static final int EMJI_TAG = 1164798569;
    private static final int EMJI_TAG_DEPRECATED = 1701669481;
    private static final int META_TABLE_NAME = 1835365473;

    private interface OpenTypeReader {
        public static final int UINT16_BYTE_COUNT = 2;
        public static final int UINT32_BYTE_COUNT = 4;

        long getPosition();

        int readTag() throws IOException;

        long readUnsignedInt() throws IOException;

        int readUnsignedShort() throws IOException;

        void skip(int i) throws IOException;
    }

    static long toUnsignedInt(int i) {
        return ((long) i) & 4294967295L;
    }

    static int toUnsignedShort(short s) {
        return s & 65535;
    }

    static MetadataList read(InputStream inputStream) throws IOException {
        InputStreamOpenTypeReader inputStreamOpenTypeReader = new InputStreamOpenTypeReader(inputStream);
        OffsetInfo offsetInfoFindOffsetInfo = findOffsetInfo(inputStreamOpenTypeReader);
        inputStreamOpenTypeReader.skip((int) (offsetInfoFindOffsetInfo.getStartOffset() - inputStreamOpenTypeReader.getPosition()));
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) offsetInfoFindOffsetInfo.getLength());
        int i = inputStream.read(byteBufferAllocate.array());
        if (i != offsetInfoFindOffsetInfo.getLength()) {
            throw new IOException("Needed " + offsetInfoFindOffsetInfo.getLength() + " bytes, got " + i);
        }
        return MetadataList.getRootAsMetadataList(byteBufferAllocate);
    }

    static MetadataList read(ByteBuffer byteBuffer) throws IOException {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position((int) findOffsetInfo(new ByteBufferReader(byteBufferDuplicate)).getStartOffset());
        return MetadataList.getRootAsMetadataList(byteBufferDuplicate);
    }

    static MetadataList read(AssetManager assetManager, String str) throws IOException {
        InputStream inputStreamOpen = assetManager.open(str);
        try {
            MetadataList metadataList = read(inputStreamOpen);
            if (inputStreamOpen != null) {
                inputStreamOpen.close();
            }
            return metadataList;
        } catch (Throwable th) {
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private static OffsetInfo findOffsetInfo(OpenTypeReader openTypeReader) throws IOException {
        long unsignedInt;
        openTypeReader.skip(4);
        int unsignedShort = openTypeReader.readUnsignedShort();
        if (unsignedShort > 100) {
            throw new IOException("Cannot read metadata.");
        }
        openTypeReader.skip(6);
        int i = 0;
        while (true) {
            if (i >= unsignedShort) {
                unsignedInt = -1;
                break;
            }
            int tag = openTypeReader.readTag();
            openTypeReader.skip(4);
            unsignedInt = openTypeReader.readUnsignedInt();
            openTypeReader.skip(4);
            if (META_TABLE_NAME == tag) {
                break;
            }
            i++;
        }
        if (unsignedInt != -1) {
            openTypeReader.skip((int) (unsignedInt - openTypeReader.getPosition()));
            openTypeReader.skip(12);
            long unsignedInt2 = openTypeReader.readUnsignedInt();
            for (int i2 = 0; i2 < unsignedInt2; i2++) {
                int tag2 = openTypeReader.readTag();
                long unsignedInt3 = openTypeReader.readUnsignedInt();
                long unsignedInt4 = openTypeReader.readUnsignedInt();
                if (EMJI_TAG == tag2 || EMJI_TAG_DEPRECATED == tag2) {
                    return new OffsetInfo(unsignedInt3 + unsignedInt, unsignedInt4);
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    private static class OffsetInfo {
        private final long mLength;
        private final long mStartOffset;

        OffsetInfo(long j, long j2) {
            this.mStartOffset = j;
            this.mLength = j2;
        }

        long getStartOffset() {
            return this.mStartOffset;
        }

        long getLength() {
            return this.mLength;
        }
    }

    private static class InputStreamOpenTypeReader implements OpenTypeReader {
        private final byte[] mByteArray;
        private final ByteBuffer mByteBuffer;
        private final InputStream mInputStream;
        private long mPosition = 0;

        InputStreamOpenTypeReader(InputStream inputStream) {
            this.mInputStream = inputStream;
            byte[] bArr = new byte[4];
            this.mByteArray = bArr;
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            this.mByteBuffer = byteBufferWrap;
            byteBufferWrap.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public int readUnsignedShort() throws IOException {
            this.mByteBuffer.position(0);
            read(2);
            return MetadataListReader.toUnsignedShort(this.mByteBuffer.getShort());
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public long readUnsignedInt() throws IOException {
            this.mByteBuffer.position(0);
            read(4);
            return MetadataListReader.toUnsignedInt(this.mByteBuffer.getInt());
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public int readTag() throws IOException {
            this.mByteBuffer.position(0);
            read(4);
            return this.mByteBuffer.getInt();
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public void skip(int i) throws IOException {
            while (i > 0) {
                int iSkip = (int) this.mInputStream.skip(i);
                if (iSkip < 1) {
                    throw new IOException("Skip didn't move at least 1 byte forward");
                }
                i -= iSkip;
                this.mPosition += (long) iSkip;
            }
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public long getPosition() {
            return this.mPosition;
        }

        private void read(int i) throws IOException {
            if (this.mInputStream.read(this.mByteArray, 0, i) != i) {
                throw new IOException("read failed");
            }
            this.mPosition += (long) i;
        }
    }

    private static class ByteBufferReader implements OpenTypeReader {
        private final ByteBuffer mByteBuffer;

        ByteBufferReader(ByteBuffer byteBuffer) {
            this.mByteBuffer = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public int readUnsignedShort() throws IOException {
            return MetadataListReader.toUnsignedShort(this.mByteBuffer.getShort());
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public long readUnsignedInt() throws IOException {
            return MetadataListReader.toUnsignedInt(this.mByteBuffer.getInt());
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public int readTag() throws IOException {
            return this.mByteBuffer.getInt();
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public void skip(int i) throws IOException {
            ByteBuffer byteBuffer = this.mByteBuffer;
            byteBuffer.position(byteBuffer.position() + i);
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public long getPosition() {
            return this.mByteBuffer.position();
        }
    }

    private MetadataListReader() {
    }
}
