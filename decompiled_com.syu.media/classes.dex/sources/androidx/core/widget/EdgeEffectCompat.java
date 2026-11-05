package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import androidx.core.os.BuildCompat;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class EdgeEffectCompat {
    private EdgeEffect mEdgeEffect;

    @Deprecated
    public EdgeEffectCompat(Context context) {
        this.mEdgeEffect = new EdgeEffect(context);
    }

    public static EdgeEffect create(Context context, AttributeSet attributeSet) {
        if (BuildCompat.isAtLeastS()) {
            return Api31Impl.create(context, attributeSet);
        }
        return new EdgeEffect(context);
    }

    public static float getDistance(EdgeEffect edgeEffect) {
        if (BuildCompat.isAtLeastS()) {
            return Api31Impl.getDistance(edgeEffect);
        }
        return 0.0f;
    }

    @Deprecated
    public void setSize(int i, int i2) {
        this.mEdgeEffect.setSize(i, i2);
    }

    @Deprecated
    public boolean isFinished() {
        return this.mEdgeEffect.isFinished();
    }

    @Deprecated
    public void finish() {
        this.mEdgeEffect.finish();
    }

    @Deprecated
    public boolean onPull(float f) {
        this.mEdgeEffect.onPull(f);
        return true;
    }

    @Deprecated
    public boolean onPull(float f, float f2) {
        onPull(this.mEdgeEffect, f, f2);
        return true;
    }

    public static void onPull(EdgeEffect edgeEffect, float f, float f2) {
        edgeEffect.onPull(f, f2);
    }

    public static float onPullDistance(EdgeEffect edgeEffect, float f, float f2) {
        if (BuildCompat.isAtLeastS()) {
            return Api31Impl.onPullDistance(edgeEffect, f, f2);
        }
        onPull(edgeEffect, f, f2);
        return f;
    }

    @Deprecated
    public boolean onRelease() {
        this.mEdgeEffect.onRelease();
        return this.mEdgeEffect.isFinished();
    }

    @Deprecated
    public boolean onAbsorb(int i) {
        this.mEdgeEffect.onAbsorb(i);
        return true;
    }

    @Deprecated
    public boolean draw(Canvas canvas) {
        return this.mEdgeEffect.draw(canvas);
    }

    private static class Api31Impl {
        private Api31Impl() {
        }

        public static EdgeEffect create(Context context, AttributeSet attributeSet) {
            try {
                return new EdgeEffect(context, attributeSet);
            } catch (Throwable unused) {
                return new EdgeEffect(context);
            }
        }

        public static float onPullDistance(EdgeEffect edgeEffect, float f, float f2) {
            try {
                return edgeEffect.onPullDistance(f, f2);
            } catch (Throwable unused) {
                edgeEffect.onPull(f, f2);
                return 0.0f;
            }
        }

        public static float getDistance(EdgeEffect edgeEffect) {
            try {
                return edgeEffect.getDistance();
            } catch (Throwable unused) {
                return 0.0f;
            }
        }
    }
}
