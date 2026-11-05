package okio;

import java.io.IOException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
final class PeekSource implements Source {
    private final Buffer buffer;
    private boolean closed;
    private int expectedPos;
    private Segment expectedSegment;
    private long pos;
    private final BufferedSource upstream;

    PeekSource(BufferedSource bufferedSource) {
        this.upstream = bufferedSource;
        Buffer buffer = bufferedSource.buffer();
        this.buffer = buffer;
        Segment segment = buffer.head;
        this.expectedSegment = segment;
        this.expectedPos = segment != null ? segment.pos : -1;
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        Segment segment = this.expectedSegment;
        if (segment != null && (segment != this.buffer.head || this.expectedPos != this.buffer.head.pos)) {
            throw new IllegalStateException("Peek source is invalid because upstream source was used");
        }
        this.upstream.request(this.pos + j);
        if (this.expectedSegment == null && this.buffer.head != null) {
            this.expectedSegment = this.buffer.head;
            this.expectedPos = this.buffer.head.pos;
        }
        long jMin = Math.min(j, this.buffer.size - this.pos);
        if (jMin <= 0) {
            return -1L;
        }
        this.buffer.copyTo(buffer, this.pos, jMin);
        this.pos += jMin;
        return jMin;
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.upstream.timeout();
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
    }
}
