package com.nostra13.universalimageloader.core.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Build;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.utils.ImageSizeUtils;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.nostra13.universalimageloader.utils.L;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class BaseImageDecoder implements ImageDecoder {
    protected static final String ERROR_CANT_DECODE_IMAGE = "Image can't be decoded [%s]";
    protected static final String LOG_FLIP_IMAGE = "Flip image horizontally [%s]";
    protected static final String LOG_ROTATE_IMAGE = "Rotate image on %1$d° [%2$s]";
    protected static final String LOG_SABSAMPLE_IMAGE = "Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]";
    protected static final String LOG_SCALE_IMAGE = "Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]";
    protected final boolean loggingEnabled;

    public BaseImageDecoder(boolean loggingEnabled) {
        this.loggingEnabled = loggingEnabled;
    }

    @Override // com.nostra13.universalimageloader.core.decode.ImageDecoder
    public Bitmap decode(ImageDecodingInfo decodingInfo) throws IOException {
        InputStream imageStream = getImageStream(decodingInfo);
        ImageFileInfo imageInfo = defineImageSizeAndRotation(imageStream, decodingInfo);
        BitmapFactory.Options decodingOptions = prepareDecodingOptions(imageInfo.imageSize, decodingInfo);
        Bitmap decodedBitmap = decodeStream(resetStream(imageStream, decodingInfo), decodingOptions);
        if (decodedBitmap == null) {
            L.e(ERROR_CANT_DECODE_IMAGE, decodingInfo.getImageKey());
            return decodedBitmap;
        }
        return considerExactScaleAndOrientaiton(decodedBitmap, decodingInfo, imageInfo.exif.rotation, imageInfo.exif.flipHorizontal);
    }

    protected InputStream getImageStream(ImageDecodingInfo decodingInfo) throws IOException {
        return decodingInfo.getDownloader().getStream(decodingInfo.getImageUri(), decodingInfo.getExtraForDownloader());
    }

    protected ImageFileInfo defineImageSizeAndRotation(InputStream imageStream, ImageDecodingInfo decodingInfo) throws IOException {
        ExifInfo exif;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(imageStream, null, options);
        String imageUri = decodingInfo.getImageUri();
        if (decodingInfo.shouldConsiderExifParams() && canDefineExifParams(imageUri, options.outMimeType)) {
            exif = defineExifOrientation(imageUri);
        } else {
            exif = new ExifInfo();
        }
        return new ImageFileInfo(new ImageSize(options.outWidth, options.outHeight, exif.rotation), exif);
    }

    private boolean canDefineExifParams(String imageUri, String mimeType) {
        return Build.VERSION.SDK_INT >= 5 && "image/jpeg".equalsIgnoreCase(mimeType) && ImageDownloader.Scheme.ofUri(imageUri) == ImageDownloader.Scheme.FILE;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected ExifInfo defineExifOrientation(String imageUri) {
        int rotation = 0;
        boolean flip = false;
        try {
            ExifInterface exif = new ExifInterface(ImageDownloader.Scheme.FILE.crop(imageUri));
            int exifOrientation = exif.getAttributeInt("Orientation", 1);
            switch (exifOrientation) {
                case 1:
                    rotation = 0;
                    break;
                case 2:
                    flip = true;
                    rotation = 0;
                    break;
                case 3:
                    rotation = 180;
                    break;
                case 4:
                    flip = true;
                    rotation = 180;
                    break;
                case 5:
                    flip = true;
                    rotation = 270;
                    break;
                case 6:
                    rotation = 90;
                    break;
                case 7:
                    flip = true;
                    rotation = 90;
                    break;
                case 8:
                    rotation = 270;
                    break;
            }
        } catch (IOException e) {
            L.w("Can't read EXIF tags from file [%s]", imageUri);
        }
        return new ExifInfo(rotation, flip);
    }

    protected BitmapFactory.Options prepareDecodingOptions(ImageSize imageSize, ImageDecodingInfo decodingInfo) {
        ImageScaleType scaleType = decodingInfo.getImageScaleType();
        ImageSize targetSize = decodingInfo.getTargetSize();
        int scale = 1;
        if (scaleType != ImageScaleType.NONE) {
            boolean powerOf2 = scaleType == ImageScaleType.IN_SAMPLE_POWER_OF_2;
            scale = ImageSizeUtils.computeImageSampleSize(imageSize, targetSize, decodingInfo.getViewScaleType(), powerOf2);
            if (this.loggingEnabled) {
                L.d(LOG_SABSAMPLE_IMAGE, imageSize, imageSize.scaleDown(scale), Integer.valueOf(scale), decodingInfo.getImageKey());
            }
        }
        BitmapFactory.Options decodingOptions = decodingInfo.getDecodingOptions();
        decodingOptions.inSampleSize = scale;
        return decodingOptions;
    }

    protected InputStream resetStream(InputStream imageStream, ImageDecodingInfo decodingInfo) throws IOException {
        try {
            imageStream.reset();
            return imageStream;
        } catch (IOException e) {
            return getImageStream(decodingInfo);
        }
    }

    protected Bitmap decodeStream(InputStream imageStream, BitmapFactory.Options decodingOptions) throws IOException {
        try {
            return BitmapFactory.decodeStream(imageStream, null, decodingOptions);
        } finally {
            IoUtils.closeSilently(imageStream);
        }
    }

    protected Bitmap considerExactScaleAndOrientaiton(Bitmap subsampledBitmap, ImageDecodingInfo decodingInfo, int rotation, boolean flipHorizontal) {
        Matrix m = new Matrix();
        ImageScaleType scaleType = decodingInfo.getImageScaleType();
        if (scaleType == ImageScaleType.EXACTLY || scaleType == ImageScaleType.EXACTLY_STRETCHED) {
            ImageSize srcSize = new ImageSize(subsampledBitmap.getWidth(), subsampledBitmap.getHeight(), rotation);
            float scale = ImageSizeUtils.computeImageScale(srcSize, decodingInfo.getTargetSize(), decodingInfo.getViewScaleType(), scaleType == ImageScaleType.EXACTLY_STRETCHED);
            if (Float.compare(scale, 1.0f) != 0) {
                m.setScale(scale, scale);
                if (this.loggingEnabled) {
                    L.d(LOG_SCALE_IMAGE, srcSize, srcSize.scale(scale), Float.valueOf(scale), decodingInfo.getImageKey());
                }
            }
        }
        if (flipHorizontal) {
            m.postScale(-1.0f, 1.0f);
            if (this.loggingEnabled) {
                L.d(LOG_FLIP_IMAGE, decodingInfo.getImageKey());
            }
        }
        if (rotation != 0) {
            m.postRotate(rotation);
            if (this.loggingEnabled) {
                L.d(LOG_ROTATE_IMAGE, Integer.valueOf(rotation), decodingInfo.getImageKey());
            }
        }
        Bitmap finalBitmap = Bitmap.createBitmap(subsampledBitmap, 0, 0, subsampledBitmap.getWidth(), subsampledBitmap.getHeight(), m, true);
        if (finalBitmap != subsampledBitmap) {
            subsampledBitmap.recycle();
        }
        return finalBitmap;
    }

    protected static class ExifInfo {
        public final boolean flipHorizontal;
        public final int rotation;

        protected ExifInfo() {
            this.rotation = 0;
            this.flipHorizontal = false;
        }

        protected ExifInfo(int rotation, boolean flipHorizontal) {
            this.rotation = rotation;
            this.flipHorizontal = flipHorizontal;
        }
    }

    protected static class ImageFileInfo {
        public final ExifInfo exif;
        public final ImageSize imageSize;

        protected ImageFileInfo(ImageSize imageSize, ExifInfo exif) {
            this.imageSize = imageSize;
            this.exif = exif;
        }
    }
}
