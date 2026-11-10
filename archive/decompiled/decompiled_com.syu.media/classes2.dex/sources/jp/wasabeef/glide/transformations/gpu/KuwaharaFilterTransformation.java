package jp.wasabeef.glide.transformations.gpu;

import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageKuwaharaFilter;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class KuwaharaFilterTransformation extends GPUFilterTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.gpu.KuwaharaFilterTransformation.1";
    private static final int VERSION = 1;
    private final int radius;

    public KuwaharaFilterTransformation() {
        this(25);
    }

    public KuwaharaFilterTransformation(int radius) {
        super(new GPUImageKuwaharaFilter());
        this.radius = radius;
        ((GPUImageKuwaharaFilter) getFilter()).setRadius(radius);
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation
    public String toString() {
        return "KuwaharaFilterTransformation(radius=" + this.radius + ")";
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, jp.wasabeef.glide.transformations.BitmapTransformation
    public boolean equals(Object o) {
        return o instanceof KuwaharaFilterTransformation;
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, jp.wasabeef.glide.transformations.BitmapTransformation
    public int hashCode() {
        return (-1859800423) + (this.radius * 10);
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, jp.wasabeef.glide.transformations.BitmapTransformation
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update((ID + this.radius).getBytes(CHARSET));
    }
}
