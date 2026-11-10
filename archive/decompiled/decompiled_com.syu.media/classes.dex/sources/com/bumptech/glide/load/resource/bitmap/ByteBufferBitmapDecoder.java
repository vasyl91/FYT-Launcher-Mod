package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class ByteBufferBitmapDecoder implements ResourceDecoder<ByteBuffer, Bitmap> {
    private final Downsampler downsampler;

    public ByteBufferBitmapDecoder(Downsampler downsampler) {
        this.downsampler = downsampler;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(ByteBuffer byteBuffer, Options options) {
        return this.downsampler.handles(byteBuffer);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<Bitmap> decode(ByteBuffer byteBuffer, int i, int i2, Options options) throws IOException {
        return this.downsampler.decode(byteBuffer, i, i2, options);
    }
}
