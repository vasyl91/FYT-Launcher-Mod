package jp.wasabeef.glide.transformations.gpu;

import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageBrightnessFilter;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class BrightnessFilterTransformation extends GPUFilterTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.gpu.BrightnessFilterTransformation.1";
    private static final int VERSION = 1;
    private final float brightness;

    public BrightnessFilterTransformation() {
        this(0.0f);
    }

    public BrightnessFilterTransformation(float brightness) {
        super(new GPUImageBrightnessFilter());
        this.brightness = brightness;
        ((GPUImageBrightnessFilter) getFilter()).setBrightness(brightness);
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation
    public String toString() {
        return "BrightnessFilterTransformation(brightness=" + this.brightness + ")";
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, jp.wasabeef.glide.transformations.BitmapTransformation
    public boolean equals(Object o) {
        return (o instanceof BrightnessFilterTransformation) && ((BrightnessFilterTransformation) o).brightness == this.brightness;
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, jp.wasabeef.glide.transformations.BitmapTransformation
    public int hashCode() {
        return (-1311211954) + ((int) ((this.brightness + 1.0f) * 10.0f));
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, jp.wasabeef.glide.transformations.BitmapTransformation
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update((ID + this.brightness).getBytes(CHARSET));
    }
}
