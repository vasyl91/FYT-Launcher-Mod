package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class ResourceBitmapDecoder implements ResourceDecoder<Uri, Bitmap> {
    private final BitmapPool bitmapPool;
    private final ResourceDrawableDecoder drawableDecoder;

    public ResourceBitmapDecoder(ResourceDrawableDecoder resourceDrawableDecoder, BitmapPool bitmapPool) {
        this.drawableDecoder = resourceDrawableDecoder;
        this.bitmapPool = bitmapPool;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(Uri uri, Options options) {
        return "android.resource".equals(uri.getScheme());
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<Bitmap> decode(Uri uri, int i, int i2, Options options) {
        Resource<Drawable> resourceDecode = this.drawableDecoder.decode(uri, i, i2, options);
        if (resourceDecode == null) {
            return null;
        }
        return DrawableToBitmapConverter.convert(this.bitmapPool, resourceDecode.get(), i, i2);
    }
}
