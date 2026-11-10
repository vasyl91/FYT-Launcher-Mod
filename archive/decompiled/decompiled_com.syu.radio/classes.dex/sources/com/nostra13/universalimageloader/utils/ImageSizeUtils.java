package com.nostra13.universalimageloader.utils;

import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public final class ImageSizeUtils {
    private ImageSizeUtils() {
    }

    public static ImageSize defineTargetSizeForView(ImageAware imageAware, ImageSize maxImageSize) {
        int width = imageAware.getWidth();
        if (width <= 0) {
            width = maxImageSize.getWidth();
        }
        int height = imageAware.getHeight();
        if (height <= 0) {
            height = maxImageSize.getHeight();
        }
        return new ImageSize(width, height);
    }

    public static int computeImageSampleSize(ImageSize srcSize, ImageSize targetSize, ViewScaleType viewScaleType, boolean powerOf2Scale) {
        int srcWidth = srcSize.getWidth();
        int srcHeight = srcSize.getHeight();
        int targetWidth = targetSize.getWidth();
        int targetHeight = targetSize.getHeight();
        int scale = 1;
        int widthScale = srcWidth / targetWidth;
        int heightScale = srcHeight / targetHeight;
        switch (viewScaleType) {
            case FIT_INSIDE:
                if (!powerOf2Scale) {
                    scale = Math.max(widthScale, heightScale);
                } else {
                    while (true) {
                        if (srcWidth / 2 >= targetWidth || srcHeight / 2 >= targetHeight) {
                            srcWidth /= 2;
                            srcHeight /= 2;
                            scale *= 2;
                        }
                    }
                }
                break;
            case CROP:
                if (powerOf2Scale) {
                    while (srcWidth / 2 >= targetWidth && srcHeight / 2 >= targetHeight) {
                        srcWidth /= 2;
                        srcHeight /= 2;
                        scale *= 2;
                    }
                } else {
                    scale = Math.min(widthScale, heightScale);
                }
                break;
        }
        if (scale < 1) {
            return 1;
        }
        return scale;
    }

    public static float computeImageScale(ImageSize srcSize, ImageSize targetSize, ViewScaleType viewScaleType, boolean stretch) {
        int destWidth;
        int destHeight;
        int srcWidth = srcSize.getWidth();
        int srcHeight = srcSize.getHeight();
        int targetWidth = targetSize.getWidth();
        int targetHeight = targetSize.getHeight();
        float widthScale = srcWidth / targetWidth;
        float heightScale = srcHeight / targetHeight;
        if ((viewScaleType == ViewScaleType.FIT_INSIDE && widthScale >= heightScale) || (viewScaleType == ViewScaleType.CROP && widthScale < heightScale)) {
            destWidth = targetWidth;
            destHeight = (int) (srcHeight / widthScale);
        } else {
            destWidth = (int) (srcWidth / heightScale);
            destHeight = targetHeight;
        }
        if ((stretch || destWidth >= srcWidth || destHeight >= srcHeight) && (!stretch || destWidth == srcWidth || destHeight == srcHeight)) {
            return 1.0f;
        }
        float scale = destWidth / srcWidth;
        return scale;
    }
}
