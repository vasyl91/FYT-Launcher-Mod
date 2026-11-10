package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class ByteBufferBitmapImageDecoderResourceDecoder implements ResourceDecoder<ByteBuffer, Bitmap> {
    private final BitmapImageDecoderResourceDecoder wrapped = new BitmapImageDecoderResourceDecoder();

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(ByteBuffer byteBuffer, Options options) throws IOException {
        return true;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<Bitmap> decode(ByteBuffer byteBuffer, int i, int i2, Options options) throws IOException {
        return this.wrapped.decode(ImageDecoder.createSource(byteBuffer), i, i2, options);
    }
}
