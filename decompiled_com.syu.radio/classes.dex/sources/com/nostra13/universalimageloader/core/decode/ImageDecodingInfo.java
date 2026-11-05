package com.nostra13.universalimageloader.core.decode;

import android.annotation.TargetApi;
import android.graphics.BitmapFactory;
import android.os.Build;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ImageDecodingInfo {
    private final boolean considerExifParams;
    private final BitmapFactory.Options decodingOptions = new BitmapFactory.Options();
    private final ImageDownloader downloader;
    private final Object extraForDownloader;
    private final String imageKey;
    private final ImageScaleType imageScaleType;
    private final String imageUri;
    private final ImageSize targetSize;
    private final ViewScaleType viewScaleType;

    public ImageDecodingInfo(String imageKey, String imageUri, ImageSize targetSize, ViewScaleType viewScaleType, ImageDownloader downloader, DisplayImageOptions displayOptions) {
        this.imageKey = imageKey;
        this.imageUri = imageUri;
        this.targetSize = targetSize;
        this.imageScaleType = displayOptions.getImageScaleType();
        this.viewScaleType = viewScaleType;
        this.downloader = downloader;
        this.extraForDownloader = displayOptions.getExtraForDownloader();
        this.considerExifParams = displayOptions.isConsiderExifParams();
        copyOptions(displayOptions.getDecodingOptions(), this.decodingOptions);
    }

    private void copyOptions(BitmapFactory.Options srcOptions, BitmapFactory.Options destOptions) {
        destOptions.inDensity = srcOptions.inDensity;
        destOptions.inDither = srcOptions.inDither;
        destOptions.inInputShareable = srcOptions.inInputShareable;
        destOptions.inJustDecodeBounds = srcOptions.inJustDecodeBounds;
        destOptions.inPreferredConfig = srcOptions.inPreferredConfig;
        destOptions.inPurgeable = srcOptions.inPurgeable;
        destOptions.inSampleSize = srcOptions.inSampleSize;
        destOptions.inScaled = srcOptions.inScaled;
        destOptions.inScreenDensity = srcOptions.inScreenDensity;
        destOptions.inTargetDensity = srcOptions.inTargetDensity;
        destOptions.inTempStorage = srcOptions.inTempStorage;
        if (Build.VERSION.SDK_INT >= 10) {
            copyOptions10(srcOptions, destOptions);
        }
        if (Build.VERSION.SDK_INT >= 11) {
            copyOptions11(srcOptions, destOptions);
        }
    }

    @TargetApi(10)
    private void copyOptions10(BitmapFactory.Options srcOptions, BitmapFactory.Options destOptions) {
        destOptions.inPreferQualityOverSpeed = srcOptions.inPreferQualityOverSpeed;
    }

    @TargetApi(11)
    private void copyOptions11(BitmapFactory.Options srcOptions, BitmapFactory.Options destOptions) {
        destOptions.inBitmap = srcOptions.inBitmap;
        destOptions.inMutable = srcOptions.inMutable;
    }

    public String getImageKey() {
        return this.imageKey;
    }

    public String getImageUri() {
        return this.imageUri;
    }

    public ImageSize getTargetSize() {
        return this.targetSize;
    }

    public ImageScaleType getImageScaleType() {
        return this.imageScaleType;
    }

    public ViewScaleType getViewScaleType() {
        return this.viewScaleType;
    }

    public ImageDownloader getDownloader() {
        return this.downloader;
    }

    public Object getExtraForDownloader() {
        return this.extraForDownloader;
    }

    public boolean shouldConsiderExifParams() {
        return this.considerExifParams;
    }

    public BitmapFactory.Options getDecodingOptions() {
        return this.decodingOptions;
    }
}
