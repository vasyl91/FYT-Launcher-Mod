package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
class TintResources extends ResourcesWrapper {
    private final WeakReference<Context> mContextRef;

    public TintResources(Context context, Resources resources) {
        super(resources);
        this.mContextRef = new WeakReference<>(context);
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        Drawable drawableCanonical = getDrawableCanonical(i);
        Context context = this.mContextRef.get();
        if (drawableCanonical != null && context != null) {
            ResourceManagerInternal.get().tintDrawableUsingColorFilter(context, i, drawableCanonical);
        }
        return drawableCanonical;
    }
}
