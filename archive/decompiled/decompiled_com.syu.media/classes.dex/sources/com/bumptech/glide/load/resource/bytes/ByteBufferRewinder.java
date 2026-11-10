package com.bumptech.glide.load.resource.bytes;

import com.bumptech.glide.load.data.DataRewinder;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class ByteBufferRewinder implements DataRewinder<ByteBuffer> {
    private final ByteBuffer buffer;

    @Override // com.bumptech.glide.load.data.DataRewinder
    public void cleanup() {
    }

    public ByteBufferRewinder(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    public ByteBuffer rewindAndGet() {
        this.buffer.position(0);
        return this.buffer;
    }

    public static class Factory implements DataRewinder.Factory<ByteBuffer> {
        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public DataRewinder<ByteBuffer> build(ByteBuffer byteBuffer) {
            return new ByteBufferRewinder(byteBuffer);
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public Class<ByteBuffer> getDataClass() {
            return ByteBuffer.class;
        }
    }
}
