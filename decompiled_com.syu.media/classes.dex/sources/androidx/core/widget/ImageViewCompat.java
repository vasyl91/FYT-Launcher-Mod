package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.ImageView;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class ImageViewCompat {
    public static ColorStateList getImageTintList(ImageView imageView) {
        return imageView.getImageTintList();
    }

    public static void setImageTintList(ImageView imageView, ColorStateList colorStateList) {
        imageView.setImageTintList(colorStateList);
    }

    public static PorterDuff.Mode getImageTintMode(ImageView imageView) {
        return imageView.getImageTintMode();
    }

    public static void setImageTintMode(ImageView imageView, PorterDuff.Mode mode) {
        imageView.setImageTintMode(mode);
    }

    private ImageViewCompat() {
    }
}
