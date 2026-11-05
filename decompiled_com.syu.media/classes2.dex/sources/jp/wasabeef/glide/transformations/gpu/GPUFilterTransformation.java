package jp.wasabeef.glide.transformations.gpu;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.GPUImage;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter;
import jp.wasabeef.glide.transformations.BitmapTransformation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class GPUFilterTransformation extends BitmapTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation.1";
    private static final byte[] ID_BYTES = ID.getBytes(CHARSET);
    private static final int VERSION = 1;
    private final GPUImageFilter gpuImageFilter;

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public int hashCode() {
        return 1751294359;
    }

    public GPUFilterTransformation(GPUImageFilter filter) {
        this.gpuImageFilter = filter;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    protected Bitmap transform(Context context, BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        GPUImage gPUImage = new GPUImage(context);
        gPUImage.setImage(toTransform);
        gPUImage.setFilter(this.gpuImageFilter);
        return gPUImage.getBitmapWithFilterApplied();
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public <T> T getFilter() {
        return (T) this.gpuImageFilter;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public boolean equals(Object o) {
        return o instanceof GPUFilterTransformation;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
    }
}
