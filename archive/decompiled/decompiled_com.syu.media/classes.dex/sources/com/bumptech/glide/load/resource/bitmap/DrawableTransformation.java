package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class DrawableTransformation implements Transformation<Drawable> {
    private final boolean isRequired;
    private final Transformation<Bitmap> wrapped;

    public Transformation<BitmapDrawable> asBitmapDrawable() {
        return this;
    }

    public DrawableTransformation(Transformation<Bitmap> transformation, boolean z) {
        this.wrapped = transformation;
        this.isRequired = z;
    }

    @Override // com.bumptech.glide.load.Transformation
    public Resource<Drawable> transform(Context context, Resource<Drawable> resource, int i, int i2) {
        BitmapPool bitmapPool = Glide.get(context).getBitmapPool();
        Drawable drawable = resource.get();
        Resource<Bitmap> resourceConvert = DrawableToBitmapConverter.convert(bitmapPool, drawable, i, i2);
        if (resourceConvert == null) {
            if (this.isRequired) {
                throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
            }
            return resource;
        }
        Resource<Bitmap> resourceTransform = this.wrapped.transform(context, resourceConvert, i, i2);
        if (resourceTransform.equals(resourceConvert)) {
            resourceTransform.recycle();
            return resource;
        }
        return newDrawableResource(context, resourceTransform);
    }

    private Resource<Drawable> newDrawableResource(Context context, Resource<Bitmap> resource) {
        return LazyBitmapDrawableResource.obtain(context.getResources(), resource);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof DrawableTransformation) {
            return this.wrapped.equals(((DrawableTransformation) obj).wrapped);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.wrapped.hashCode();
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.wrapped.updateDiskCacheKey(messageDigest);
    }
}
