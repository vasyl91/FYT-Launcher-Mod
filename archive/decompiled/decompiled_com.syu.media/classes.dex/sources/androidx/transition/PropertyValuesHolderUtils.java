package androidx.transition;

import android.animation.PropertyValuesHolder;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
class PropertyValuesHolderUtils {
    static PropertyValuesHolder ofPointF(Property<?, PointF> property, Path path) {
        return PropertyValuesHolder.ofObject(property, (TypeConverter) null, path);
    }

    private PropertyValuesHolderUtils() {
    }
}
