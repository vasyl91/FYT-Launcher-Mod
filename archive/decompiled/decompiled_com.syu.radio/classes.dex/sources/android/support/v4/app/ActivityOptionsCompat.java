package android.support.v4.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ActivityOptionsCompat {
    public static ActivityOptionsCompat makeCustomAnimation(Context context, int enterResId, int exitResId) {
        return Build.VERSION.SDK_INT >= 16 ? new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeCustomAnimation(context, enterResId, exitResId)) : new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeScaleUpAnimation(View source, int startX, int startY, int startWidth, int startHeight) {
        return Build.VERSION.SDK_INT >= 16 ? new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeScaleUpAnimation(source, startX, startY, startWidth, startHeight)) : new ActivityOptionsCompat();
    }

    public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(View source, Bitmap thumbnail, int startX, int startY) {
        return Build.VERSION.SDK_INT >= 16 ? new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeThumbnailScaleUpAnimation(source, thumbnail, startX, startY)) : new ActivityOptionsCompat();
    }

    private static class ActivityOptionsImplJB extends ActivityOptionsCompat {
        private final ActivityOptionsCompatJB mImpl;

        ActivityOptionsImplJB(ActivityOptionsCompatJB impl) {
            this.mImpl = impl;
        }

        @Override // android.support.v4.app.ActivityOptionsCompat
        public Bundle toBundle() {
            return this.mImpl.toBundle();
        }

        @Override // android.support.v4.app.ActivityOptionsCompat
        public void update(ActivityOptionsCompat otherOptions) {
            if (otherOptions instanceof ActivityOptionsImplJB) {
                ActivityOptionsImplJB otherImpl = (ActivityOptionsImplJB) otherOptions;
                this.mImpl.update(otherImpl.mImpl);
            }
        }
    }

    protected ActivityOptionsCompat() {
    }

    public Bundle toBundle() {
        return null;
    }

    public void update(ActivityOptionsCompat otherOptions) {
    }
}
