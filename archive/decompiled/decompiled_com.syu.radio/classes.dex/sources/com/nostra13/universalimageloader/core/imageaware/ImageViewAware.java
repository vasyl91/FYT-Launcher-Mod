package com.nostra13.universalimageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.utils.L;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ImageViewAware implements ImageAware {
    protected boolean checkActualViewSize;
    protected Reference<ImageView> imageViewRef;

    public ImageViewAware(ImageView imageView) {
        this(imageView, true);
    }

    public ImageViewAware(ImageView imageView, boolean checkActualViewSize) {
        this.imageViewRef = new WeakReference(imageView);
        this.checkActualViewSize = checkActualViewSize;
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.ImageAware
    public int getWidth() {
        ImageView imageView = this.imageViewRef.get();
        if (imageView == null) {
            return 0;
        }
        ViewGroup.LayoutParams params = imageView.getLayoutParams();
        int width = 0;
        if (this.checkActualViewSize && params != null && params.width != -2) {
            width = imageView.getWidth();
        }
        if (width <= 0 && params != null) {
            width = params.width;
        }
        if (width <= 0) {
            width = getImageViewFieldValue(imageView, "mMaxWidth");
        }
        L.w("width = " + width, new Object[0]);
        return width;
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.ImageAware
    public int getHeight() {
        ImageView imageView = this.imageViewRef.get();
        if (imageView == null) {
            return 0;
        }
        ViewGroup.LayoutParams params = imageView.getLayoutParams();
        int height = 0;
        if (this.checkActualViewSize && params != null && params.height != -2) {
            height = imageView.getHeight();
        }
        if (height <= 0 && params != null) {
            height = params.height;
        }
        if (height <= 0) {
            height = getImageViewFieldValue(imageView, "mMaxHeight");
        }
        L.w("height = " + height, new Object[0]);
        return height;
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.ImageAware
    public ViewScaleType getScaleType() {
        ImageView imageView = this.imageViewRef.get();
        if (imageView != null) {
            return ViewScaleType.fromImageView(imageView);
        }
        return null;
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.ImageAware
    public ImageView getWrappedView() {
        return this.imageViewRef.get();
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.ImageAware
    public boolean isCollected() {
        return this.imageViewRef.get() == null;
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.ImageAware
    public int getId() {
        ImageView imageView = this.imageViewRef.get();
        return imageView == null ? super.hashCode() : imageView.hashCode();
    }

    private static int getImageViewFieldValue(Object object, String fieldName) {
        try {
            Field field = ImageView.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            int fieldValue = ((Integer) field.get(object)).intValue();
            if (fieldValue <= 0 || fieldValue >= Integer.MAX_VALUE) {
                return 0;
            }
            return fieldValue;
        } catch (Exception e) {
            L.e(e);
            return 0;
        }
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.ImageAware
    public boolean setImageDrawable(Drawable drawable) {
        ImageView imageView = this.imageViewRef.get();
        if (imageView == null) {
            return false;
        }
        imageView.setImageDrawable(drawable);
        return true;
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.ImageAware
    public boolean setImageBitmap(Bitmap bitmap) {
        ImageView imageView = this.imageViewRef.get();
        if (imageView == null) {
            return false;
        }
        imageView.setImageBitmap(bitmap);
        return true;
    }
}
