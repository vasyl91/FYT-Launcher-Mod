package jp.wasabeef.glide.transformations.gpu;

import android.graphics.PointF;
import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageSwirlFilter;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SwirlFilterTransformation extends GPUFilterTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.gpu.SwirlFilterTransformation.1";
    private static final int VERSION = 1;
    private final float angle;
    private final PointF center;
    private final float radius;

    public SwirlFilterTransformation() {
        this(0.5f, 1.0f, new PointF(0.5f, 0.5f));
    }

    public SwirlFilterTransformation(float radius, float angle, PointF center) {
        super(new GPUImageSwirlFilter());
        this.radius = radius;
        this.angle = angle;
        this.center = center;
        GPUImageSwirlFilter gPUImageSwirlFilter = (GPUImageSwirlFilter) getFilter();
        gPUImageSwirlFilter.setRadius(radius);
        gPUImageSwirlFilter.setAngle(angle);
        gPUImageSwirlFilter.setCenter(center);
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation
    public String toString() {
        return "SwirlFilterTransformation(radius=" + this.radius + ",angle=" + this.angle + ",center=" + this.center.toString() + ")";
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, jp.wasabeef.glide.transformations.BitmapTransformation
    public boolean equals(Object o) {
        if (o instanceof SwirlFilterTransformation) {
            SwirlFilterTransformation swirlFilterTransformation = (SwirlFilterTransformation) o;
            float f = swirlFilterTransformation.radius;
            float f2 = this.radius;
            if (f == f2 && swirlFilterTransformation.angle == f2 && swirlFilterTransformation.center.equals(this.center.x, this.center.y)) {
                return true;
            }
        }
        return false;
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, jp.wasabeef.glide.transformations.BitmapTransformation
    public int hashCode() {
        return (-981084566) + ((int) (this.radius * 1000.0f)) + ((int) (this.angle * 10.0f)) + this.center.hashCode();
    }

    @Override // jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation, jp.wasabeef.glide.transformations.BitmapTransformation
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update((ID + this.radius + this.angle + this.center.hashCode()).getBytes(CHARSET));
    }
}
