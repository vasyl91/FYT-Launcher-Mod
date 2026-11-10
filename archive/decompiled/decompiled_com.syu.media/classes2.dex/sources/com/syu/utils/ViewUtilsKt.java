package com.syu.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b\u001a\u001c\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u001a\u001c\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\r\u001a\u001a\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004\u001a\u001c\u0010\t\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u001a\u001c\u0010\t\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\r\u001a\u001a\u0010\t\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004\u001a\u001a\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004\u001a\u001c\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u001a\u001a\u0010\u0010\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004\u001a\u001c\u0010\u0010\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¨\u0006\u0013"}, d2 = {"setCheckBox", "", "Landroid/app/Activity;", "vid", "", "listener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "isChecked", "", "setImageView", "bitmap", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "resId", "Landroidx/fragment/app/Fragment;", "setTextView", "text", "", "Library_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ViewUtilsKt {
    public static final void setCheckBox(Activity activity, int i, CompoundButton.OnCheckedChangeListener listener) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(listener, "listener");
        CheckBox checkBox = (CheckBox) activity.findViewById(i);
        if (checkBox != null) {
            checkBox.setOnCheckedChangeListener(listener);
        }
    }

    public static final void setImageView(Activity activity, int i, int i2) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        ImageView imageView = (ImageView) activity.findViewById(i);
        if (imageView != null) {
            imageView.setImageResource(i2);
        }
    }

    public static final void setTextView(Activity activity, int i, int i2) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        TextView textView = (TextView) activity.findViewById(i);
        if (textView != null) {
            textView.setText(i2);
        }
    }

    public static final void setCheckBox(Activity activity, int i, boolean z) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        CheckBox checkBox = (CheckBox) activity.findViewById(i);
        if (checkBox == null) {
            return;
        }
        checkBox.setChecked(z);
    }

    public static final void setImageView(Activity activity, int i, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        ImageView imageView = (ImageView) activity.findViewById(i);
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    public static final void setTextView(Activity activity, int i, String str) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        TextView textView = (TextView) activity.findViewById(i);
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public static final void setImageView(Activity activity, int i, Drawable drawable) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        ImageView imageView = (ImageView) activity.findViewById(i);
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public static final void setTextView(Fragment fragment, int i, int i2) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        TextView textView = (TextView) fragment.requireView().findViewById(i);
        if (textView != null) {
            textView.setText(i2);
        }
    }

    public static final void setImageView(Fragment fragment, int i, int i2) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        ImageView imageView = (ImageView) fragment.requireView().findViewById(i);
        if (imageView != null) {
            imageView.setImageResource(i2);
        }
    }

    public static final void setTextView(Fragment fragment, int i, String str) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        TextView textView = (TextView) fragment.requireView().findViewById(i);
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public static final void setImageView(Fragment fragment, int i, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        ImageView imageView = (ImageView) fragment.requireView().findViewById(i);
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    public static final void setImageView(Fragment fragment, int i, Drawable drawable) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        ImageView imageView = (ImageView) fragment.requireView().findViewById(i);
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }
}
