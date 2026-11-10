package jp.wasabeef.glide.transformations.gpu;

import android.graphics.PointF;
import java.security.MessageDigest;
import java.util.Arrays;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageVignetteFilter;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class VignetteFilterTransformation extends GPUFilterTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.gpu.VignetteFilterTransformation.1";
    private static final int VERSION = 1;
    private final PointF center;
    private final float[] vignetteColor;
    private final float vignetteEnd;
    private final float vignetteStart;

    public VignetteFilterTransformation() {
        this(new PointF(0.5f, 0.5f), new float[]{0.0f, 0.0f, 0.0f}, 0.0f, 0.75f);
    }

    public VignetteFilterTransformation(PointF center, float[] color, float start, float end) {
        super(new GPUImageVignetteFilter());
        this.center = center;
        this.vignetteColor = color;
        this.vignetteStart = start;
        this.vignetteEnd = end;
        GPUImageVignetteFilter gPUImageVignetteFilter = (GPUImageVignetteFilter) getFilter();
        gPUImageVignetteFilter.setVignetteCenter(center);
        gPUImageVignetteFilter.setVignetteColor(color);
        gPUImageVignetteFilter.setVignetteStart(start);
        gPUImageVignetteFilter.setVignetteEnd(end);
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation
    public String toString() {
        return "VignetteFilterTransformation(center=" + this.center.toString() + ",color=" + Arrays.toString(this.vignetteColor) + ",start=" + this.vignetteStart + ",end=" + this.vignetteEnd + ")";
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, jp.wasabeef.glide.transformations.BitmapTransformation
    public boolean equals(Object o) {
        if (o instanceof VignetteFilterTransformation) {
            VignetteFilterTransformation vignetteFilterTransformation = (VignetteFilterTransformation) o;
            if (vignetteFilterTransformation.center.equals(this.center.x, this.center.y) && Arrays.equals(vignetteFilterTransformation.vignetteColor, this.vignetteColor) && vignetteFilterTransformation.vignetteStart == this.vignetteStart && vignetteFilterTransformation.vignetteEnd == this.vignetteEnd) {
                return true;
            }
        }
        return false;
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, jp.wasabeef.glide.transformations.BitmapTransformation
    public int hashCode() {
        return 1874002103 + this.center.hashCode() + Arrays.hashCode(this.vignetteColor) + ((int) (this.vignetteStart * 100.0f)) + ((int) (this.vignetteEnd * 10.0f));
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, jp.wasabeef.glide.transformations.BitmapTransformation
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update((ID + this.center + Arrays.hashCode(this.vignetteColor) + this.vignetteStart + this.vignetteEnd).getBytes(CHARSET));
    }
}
