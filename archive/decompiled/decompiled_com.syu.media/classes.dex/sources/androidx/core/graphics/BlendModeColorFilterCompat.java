package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class BlendModeColorFilterCompat {
    public static ColorFilter createBlendModeColorFilterCompat(int i, BlendModeCompat blendModeCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            BlendMode blendModeObtainBlendModeFromCompat = BlendModeUtils.obtainBlendModeFromCompat(blendModeCompat);
            if (blendModeObtainBlendModeFromCompat != null) {
                return new BlendModeColorFilter(i, blendModeObtainBlendModeFromCompat);
            }
            return null;
        }
        PorterDuff.Mode modeObtainPorterDuffFromCompat = BlendModeUtils.obtainPorterDuffFromCompat(blendModeCompat);
        if (modeObtainPorterDuffFromCompat != null) {
            return new PorterDuffColorFilter(i, modeObtainPorterDuffFromCompat);
        }
        return null;
    }

    private BlendModeColorFilterCompat() {
    }
}
