package androidx.dynamicanimation.animation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class FloatValueHolder {
    private float mValue = 0.0f;

    public FloatValueHolder() {
    }

    public FloatValueHolder(float f) {
        setValue(f);
    }

    public void setValue(float f) {
        this.mValue = f;
    }

    public float getValue() {
        return this.mValue;
    }
}
