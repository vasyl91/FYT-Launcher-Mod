package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
final class ResourceCacheKey implements Key {
    private static final LruCache<Class<?>, byte[]> RESOURCE_CLASS_BYTES = new LruCache<>(50);
    private final ArrayPool arrayPool;
    private final Class<?> decodedResourceClass;
    private final int height;
    private final Options options;
    private final Key signature;
    private final Key sourceKey;
    private final Transformation<?> transformation;
    private final int width;

    ResourceCacheKey(ArrayPool arrayPool, Key key, Key key2, int i, int i2, Transformation<?> transformation, Class<?> cls, Options options) {
        this.arrayPool = arrayPool;
        this.sourceKey = key;
        this.signature = key2;
        this.width = i;
        this.height = i2;
        this.transformation = transformation;
        this.decodedResourceClass = cls;
        this.options = options;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (!(obj instanceof ResourceCacheKey)) {
            return false;
        }
        ResourceCacheKey resourceCacheKey = (ResourceCacheKey) obj;
        return this.height == resourceCacheKey.height && this.width == resourceCacheKey.width && Util.bothNullOrEqual(this.transformation, resourceCacheKey.transformation) && this.decodedResourceClass.equals(resourceCacheKey.decodedResourceClass) && this.sourceKey.equals(resourceCacheKey.sourceKey) && this.signature.equals(resourceCacheKey.signature) && this.options.equals(resourceCacheKey.options);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        int iHashCode = (((((this.sourceKey.hashCode() * 31) + this.signature.hashCode()) * 31) + this.width) * 31) + this.height;
        Transformation<?> transformation = this.transformation;
        if (transformation != null) {
            iHashCode = (iHashCode * 31) + transformation.hashCode();
        }
        return (((iHashCode * 31) + this.decodedResourceClass.hashCode()) * 31) + this.options.hashCode();
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.arrayPool.getExact(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.width).putInt(this.height).array();
        this.signature.updateDiskCacheKey(messageDigest);
        this.sourceKey.updateDiskCacheKey(messageDigest);
        messageDigest.update(bArr);
        Transformation<?> transformation = this.transformation;
        if (transformation != null) {
            transformation.updateDiskCacheKey(messageDigest);
        }
        this.options.updateDiskCacheKey(messageDigest);
        messageDigest.update(getResourceClassBytes());
        this.arrayPool.put(bArr);
    }

    private byte[] getResourceClassBytes() {
        LruCache<Class<?>, byte[]> lruCache = RESOURCE_CLASS_BYTES;
        byte[] bArr = lruCache.get(this.decodedResourceClass);
        if (bArr != null) {
            return bArr;
        }
        byte[] bytes = this.decodedResourceClass.getName().getBytes(CHARSET);
        lruCache.put(this.decodedResourceClass, bytes);
        return bytes;
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.sourceKey + ", signature=" + this.signature + ", width=" + this.width + ", height=" + this.height + ", decodedResourceClass=" + this.decodedResourceClass + ", transformation='" + this.transformation + "', options=" + this.options + '}';
    }
}
