package okhttp3.internal.cache2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
final class Relay {
    private static final long FILE_HEADER_SIZE = 32;
    static final ByteString PREFIX_CLEAN = ByteString.encodeUtf8("OkHttp cache v1\n");
    static final ByteString PREFIX_DIRTY = ByteString.encodeUtf8("OkHttp DIRTY :(\n");
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    final long bufferMaxSize;
    boolean complete;
    RandomAccessFile file;
    private final ByteString metadata;
    int sourceCount;
    Source upstream;
    long upstreamPos;
    Thread upstreamReader;
    final Buffer upstreamBuffer = new Buffer();
    final Buffer buffer = new Buffer();

    private Relay(RandomAccessFile randomAccessFile, Source source, long j, ByteString byteString, long j2) {
        this.file = randomAccessFile;
        this.upstream = source;
        this.complete = source == null;
        this.upstreamPos = j;
        this.metadata = byteString;
        this.bufferMaxSize = j2;
    }

    public static Relay edit(File file, Source source, ByteString byteString, long j) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        Relay relay = new Relay(randomAccessFile, source, 0L, byteString, j);
        randomAccessFile.setLength(0L);
        relay.writeHeader(PREFIX_DIRTY, -1L, -1L);
        return relay;
    }

    public static Relay read(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        FileOperator fileOperator = new FileOperator(randomAccessFile.getChannel());
        Buffer buffer = new Buffer();
        fileOperator.read(0L, buffer, FILE_HEADER_SIZE);
        ByteString byteString = PREFIX_CLEAN;
        if (!buffer.readByteString(byteString.size()).equals(byteString)) {
            throw new IOException("unreadable cache file");
        }
        long j = buffer.readLong();
        long j2 = buffer.readLong();
        Buffer buffer2 = new Buffer();
        fileOperator.read(j + FILE_HEADER_SIZE, buffer2, j2);
        return new Relay(randomAccessFile, null, j, buffer2.readByteString(), 0L);
    }

    private void writeHeader(ByteString byteString, long j, long j2) throws IOException {
        Buffer buffer = new Buffer();
        buffer.write(byteString);
        buffer.writeLong(j);
        buffer.writeLong(j2);
        if (buffer.size() != FILE_HEADER_SIZE) {
            throw new IllegalArgumentException();
        }
        new FileOperator(this.file.getChannel()).write(0L, buffer, FILE_HEADER_SIZE);
    }

    private void writeMetadata(long j) throws IOException {
        Buffer buffer = new Buffer();
        buffer.write(this.metadata);
        new FileOperator(this.file.getChannel()).write(FILE_HEADER_SIZE + j, buffer, this.metadata.size());
    }

    void commit(long j) throws IOException {
        writeMetadata(j);
        this.file.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j, this.metadata.size());
        this.file.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
        }
        Util.closeQuietly(this.upstream);
        this.upstream = null;
    }

    boolean isClosed() {
        return this.file == null;
    }

    public ByteString metadata() {
        return this.metadata;
    }

    public Source newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }

    class RelaySource implements Source {
        private FileOperator fileOperator;
        private long sourcePos;
        private final Timeout timeout = new Timeout();

        RelaySource() {
            this.fileOperator = new FileOperator(Relay.this.file.getChannel());
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            long j2;
            char c;
            if (this.fileOperator == null) {
                throw new IllegalStateException("closed");
            }
            synchronized (Relay.this) {
                while (true) {
                    long j3 = this.sourcePos;
                    j2 = Relay.this.upstreamPos;
                    if (j3 == j2) {
                        if (!Relay.this.complete) {
                            if (Relay.this.upstreamReader != null) {
                                this.timeout.waitUntilNotified(Relay.this);
                            } else {
                                Relay.this.upstreamReader = Thread.currentThread();
                                c = 1;
                                break;
                            }
                        } else {
                            return -1L;
                        }
                    } else {
                        long size = j2 - Relay.this.buffer.size();
                        long j4 = this.sourcePos;
                        if (j4 < size) {
                            c = 2;
                            break;
                        }
                        long jMin = Math.min(j, j2 - j4);
                        Relay.this.buffer.copyTo(buffer, this.sourcePos - size, jMin);
                        this.sourcePos += jMin;
                        return jMin;
                    }
                }
                if (c == 2) {
                    long jMin2 = Math.min(j, j2 - this.sourcePos);
                    this.fileOperator.read(this.sourcePos + Relay.FILE_HEADER_SIZE, buffer, jMin2);
                    this.sourcePos += jMin2;
                    return jMin2;
                }
                try {
                    long j5 = Relay.this.upstream.read(Relay.this.upstreamBuffer, Relay.this.bufferMaxSize);
                    if (j5 == -1) {
                        Relay.this.commit(j2);
                        synchronized (Relay.this) {
                            Relay.this.upstreamReader = null;
                            Relay.this.notifyAll();
                        }
                        return -1L;
                    }
                    long jMin3 = Math.min(j5, j);
                    Relay.this.upstreamBuffer.copyTo(buffer, 0L, jMin3);
                    this.sourcePos += jMin3;
                    this.fileOperator.write(j2 + Relay.FILE_HEADER_SIZE, Relay.this.upstreamBuffer.clone(), j5);
                    synchronized (Relay.this) {
                        Relay.this.buffer.write(Relay.this.upstreamBuffer, j5);
                        if (Relay.this.buffer.size() > Relay.this.bufferMaxSize) {
                            Relay.this.buffer.skip(Relay.this.buffer.size() - Relay.this.bufferMaxSize);
                        }
                        Relay.this.upstreamPos += j5;
                    }
                    synchronized (Relay.this) {
                        Relay.this.upstreamReader = null;
                        Relay.this.notifyAll();
                    }
                    return jMin3;
                } catch (Throwable th) {
                    synchronized (Relay.this) {
                        Relay.this.upstreamReader = null;
                        Relay.this.notifyAll();
                        throw th;
                    }
                }
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.fileOperator == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.fileOperator = null;
            synchronized (Relay.this) {
                Relay.this.sourceCount--;
                if (Relay.this.sourceCount == 0) {
                    RandomAccessFile randomAccessFile2 = Relay.this.file;
                    Relay.this.file = null;
                    randomAccessFile = randomAccessFile2;
                }
            }
            if (randomAccessFile != null) {
                Util.closeQuietly(randomAccessFile);
            }
        }
    }
}
