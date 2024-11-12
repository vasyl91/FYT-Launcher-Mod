package com.android.launcher66;

import android.app.ActionBar;
import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.android.gallery3d.common.Utils;
import com.android.gallery3d.exif.ExifInterface;
import com.android.photos.BitmapRegionTileSource;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class WallpaperCropActivity extends Activity {
    private static final int DEFAULT_COMPRESS_QUALITY = 90;
    private static final String LOGTAG = "Launcher3.CropActivity";
    public static final int MAX_BMAP_IN_INTENT = 750000;
    protected static final String WALLPAPER_HEIGHT_KEY = "wallpaper.height";
    private static final float WALLPAPER_SCREENS_SPAN = 2.0f;
    protected static final String WALLPAPER_WIDTH_KEY = "wallpaper.width";
    protected CropView mCropView;
    protected Uri mUri;

    public interface OnBitmapCroppedHandler {
        void onBitmapCropped(byte[] Bar);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        if (!enableRotation()) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    protected void init() {
        setContentView(R.layout.wallpaper_cropper);
        this.mCropView = (CropView) findViewById(R.id.cropView);
        Intent cropIntent = getIntent();
        final Uri imageUri = cropIntent.getData();
        if (imageUri == null) {
            Log.e(LOGTAG, "No URI passed in intent, exiting WallpaperCropActivity");
            finish();
            return;
        }
        int rotation = getRotationFromExif(this, imageUri);
        this.mCropView.setTileSource(new BitmapRegionTileSource(this, imageUri, 1024, rotation), null);
        this.mCropView.setTouchEnabled(true);
        ActionBar actionBar = getActionBar();
        actionBar.setCustomView(R.layout.actionbar_set_wallpaper);
        actionBar.getCustomView().setOnClickListener(new View.OnClickListener() { // from class: com.android.launcher66.WallpaperCropActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                WallpaperCropActivity.this.cropImageAndSetWallpaper(imageUri, null, true);
            }
        });
    }

    public boolean enableRotation() {
        return getResources().getBoolean(R.bool.allow_rotation);
    }

    public static String getSharedPreferencesKey() {
        return WallpaperCropActivity.class.getName();
    }

    private static float wallpaperTravelToScreenWidthRatio(int width, int height) {
        float aspectRatio = width / height;
        return (0.30769226f * aspectRatio) + 1.0076923f;
    }

    protected static Point getDefaultWallpaperSize(Resources res, WindowManager windowManager) {
        int defaultWidth;
        int defaultHeight;
        Point minDims = new Point();
        Point maxDims = new Point();
        Display display = windowManager.getDefaultDisplay();
        display.getCurrentSizeRange(minDims, maxDims);
        int maxDim = Math.max(maxDims.x, maxDims.y);
        int minDim = Math.max(minDims.x, minDims.y);
        if (Build.VERSION.SDK_INT >= 17) {
            Point realSize = new Point();
            windowManager.getDefaultDisplay().getRealSize(realSize);
            maxDim = Math.max(realSize.x, realSize.y);
            minDim = Math.min(realSize.x, realSize.y);
        }
        if (isScreenLarge(res)) {
            defaultWidth = (int) (maxDim * wallpaperTravelToScreenWidthRatio(maxDim, minDim));
            defaultHeight = maxDim;
        } else {
            defaultWidth = Math.min((int) (minDim * WALLPAPER_SCREENS_SPAN), maxDim);
            defaultHeight = minDim;
        }
        return new Point(defaultWidth, defaultHeight);
    }

    public static int getRotationFromExif(String path) {
        return getRotationFromExifHelper(path, null, 0, null, null);
    }

    public static int getRotationFromExif(Context context, Uri uri) {
        return getRotationFromExifHelper(null, null, 0, context, uri);
    }

    public static int getRotationFromExif(Resources res, int resId) {
        return getRotationFromExifHelper(null, res, resId, null, null);
    }

    private static int getRotationFromExifHelper(String path, Resources res, int resId, Context context, Uri uri) {
        ExifInterface ei = new ExifInterface();
        try {
            if (path != null) {
                ei.readExif(path);
            } else if (uri != null) {
                InputStream is = context.getContentResolver().openInputStream(uri);
                BufferedInputStream bis = new BufferedInputStream(is);
                ei.readExif(bis);
            } else {
                InputStream is2 = res.openRawResource(resId);
                BufferedInputStream bis2 = new BufferedInputStream(is2);
                ei.readExif(bis2);
            }
            Integer ori = ei.getTagIntValue(ExifInterface.TAG_ORIENTATION);
            if (ori != null) {
                return ExifInterface.getRotationForOrientationValue(ori.shortValue());
            }
        } catch (Exception e) {
            Log.w(LOGTAG, "Getting exif data failed", e);
        }
        return 0;
    }

    protected void setWallpaper(String filePath, final boolean finishActivityWhenDone) {
        int rotation = getRotationFromExif(filePath);
        BitmapCropTask cropTask = new BitmapCropTask((Context) this, filePath, (RectF) null, rotation, 0, 0, true, false, (Runnable) null);
        final Point bounds = cropTask.getImageBounds();
        Runnable onEndCrop = new Runnable() { // from class: com.android.launcher66.WallpaperCropActivity.2
            @Override // java.lang.Runnable
            public void run() {
                WallpaperCropActivity.this.updateWallpaperDimensions(bounds.x, bounds.y);
                if (finishActivityWhenDone) {
                    WallpaperCropActivity.this.setResult(-1);
                    WallpaperCropActivity.this.finish();
                }
            }
        };
        cropTask.setOnEndRunnable(onEndCrop);
        cropTask.setNoCrop(true);
        cropTask.execute(new Void[0]);
    }

    protected void cropImageAndSetWallpaper(Resources res, int resId, final boolean finishActivityWhenDone, final String resName) {
        int rotation = getRotationFromExif(res, resId);
        Point inSize = this.mCropView.getSourceDimensions();
        Point outSize = getDefaultWallpaperSize(getResources(), getWindowManager());
        RectF crop = getMaxCropRect(inSize.x, inSize.y, outSize.x, outSize.y, false);
        Runnable onEndCrop = new Runnable() { // from class: com.android.launcher66.WallpaperCropActivity.3
            @Override // java.lang.Runnable
            public void run() {
                WallpaperCropActivity.this.updateWallpaperDimensions(0, 0);
                if (finishActivityWhenDone) {
                    WallpaperCropActivity.this.setResult(-1);
                    Intent intent = new Intent();
                    intent.putExtra("wallpaperRes", resName.replace("_n", ""));
                    WallpaperCropActivity.this.setResult(202, intent);
                    WallpaperCropActivity.this.finish();
                }
            }
        };
        BitmapCropTask cropTask = new BitmapCropTask(this, res, resId, crop, rotation, outSize.x, outSize.y, true, false, onEndCrop);
        cropTask.execute(new Void[0]);
    }

    private static boolean isScreenLarge(Resources res) {
        Configuration config = res.getConfiguration();
        return config.smallestScreenWidthDp > 721;
    }

    protected void cropImageAndSetWallpaper(Uri uri, OnBitmapCroppedHandler onBitmapCroppedHandler, final boolean finishActivityWhenDone) {
        int defaultWallpaperWidth;
        int portraitHeight;
        boolean ltr = this.mCropView.getLayoutDirection() == View.LAYOUT_DIRECTION_LTR;
        Point minDims = new Point();
        Point maxDims = new Point();
        Display d = getWindowManager().getDefaultDisplay();
        d.getCurrentSizeRange(minDims, maxDims);
        Point displaySize = new Point();
        d.getSize(displaySize);
        int maxDim = Math.max(maxDims.x, maxDims.y);
        int minDim = Math.min(minDims.x, minDims.y);
        if (isScreenLarge(getResources())) {
            defaultWallpaperWidth = (int) (maxDim * wallpaperTravelToScreenWidthRatio(maxDim, minDim));
        } else {
            defaultWallpaperWidth = Math.max((int) (minDim * WALLPAPER_SCREENS_SPAN), maxDim);
        }
        boolean isPortrait = displaySize.x < displaySize.y;
        if (isPortrait) {
            portraitHeight = this.mCropView.getHeight();
        } else {
            portraitHeight = Math.max(maxDims.x, maxDims.y);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            Point realSize = new Point();
            d.getRealSize(realSize);
            portraitHeight = Math.max(realSize.x, realSize.y);
        }
        RectF cropRect = this.mCropView.getCrop();
        int cropRotation = this.mCropView.getImageRotation();
        float cropScale = this.mCropView.getWidth() / cropRect.width();
        Point inSize = this.mCropView.getSourceDimensions();
        Matrix rotateMatrix = new Matrix();
        rotateMatrix.setRotate(cropRotation);
        float[] rotatedInSize = {inSize.x, inSize.y};
        rotateMatrix.mapPoints(rotatedInSize);
        rotatedInSize[0] = Math.abs(rotatedInSize[0]);
        rotatedInSize[1] = Math.abs(rotatedInSize[1]);
        float extraSpace = ltr ? rotatedInSize[0] - cropRect.right : cropRect.left;
        float maxExtraSpace = (defaultWallpaperWidth / cropScale) - cropRect.width();
        float extraSpace2 = Math.min(extraSpace, maxExtraSpace);
        if (ltr) {
            cropRect.right += extraSpace2;
        } else {
            cropRect.left -= extraSpace2;
        }
        if (isPortrait) {
            cropRect.bottom = cropRect.top + (portraitHeight / cropScale);
        } else {
            float extraPortraitHeight = (portraitHeight / cropScale) - cropRect.height();
            float expandHeight = Math.min(Math.min(rotatedInSize[1] - cropRect.bottom, cropRect.top), extraPortraitHeight / WALLPAPER_SCREENS_SPAN);
            cropRect.top -= expandHeight;
            cropRect.bottom += expandHeight;
        }
        final int outWidth = Math.round(cropRect.width() * cropScale);
        final int outHeight = Math.round(cropRect.height() * cropScale);
        Runnable onEndCrop = new Runnable() { // from class: com.android.launcher66.WallpaperCropActivity.4
            @Override // java.lang.Runnable
            public void run() {
                WallpaperCropActivity.this.updateWallpaperDimensions(outWidth, outHeight);
                if (finishActivityWhenDone) {
                    WallpaperCropActivity.this.setResult(-1);
                    WallpaperCropActivity.this.finish();
                }
            }
        };
        BitmapCropTask cropTask = new BitmapCropTask((Context) this, uri, cropRect, cropRotation, outWidth, outHeight, true, false, onEndCrop);
        if (onBitmapCroppedHandler != null) {
            cropTask.setOnBitmapCropped(onBitmapCroppedHandler);
        }
        cropTask.execute(new Void[0]);
    }

    protected static class BitmapCropTask extends AsyncTask<Void, Void, Boolean> {
        Context mContext;
        RectF mCropBounds;
        Bitmap mCroppedBitmap;
        String mInFilePath;
        byte[] mInImageBytes;
        int mInResId;
        InputStream mInStream;
        Uri mInUri;
        boolean mNoCrop;
        OnBitmapCroppedHandler mOnBitmapCroppedHandler;
        Runnable mOnEndRunnable;
        int mOutHeight;
        int mOutWidth;
        String mOutputFormat;
        Resources mResources;
        int mRotation;
        boolean mSaveCroppedBitmap;
        boolean mSetWallpaper;

        public BitmapCropTask(Context c, String filePath, RectF cropBounds, int rotation, int outWidth, int outHeight, boolean setWallpaper, boolean saveCroppedBitmap, Runnable onEndRunnable) {
            this.mInUri = null;
            this.mInResId = 0;
            this.mCropBounds = null;
            this.mOutputFormat = "jpg";
            this.mContext = c;
            this.mInFilePath = filePath;
            init(cropBounds, rotation, outWidth, outHeight, setWallpaper, saveCroppedBitmap, onEndRunnable);
        }

        public BitmapCropTask(byte[] imageBytes, RectF cropBounds, int rotation, int outWidth, int outHeight, boolean setWallpaper, boolean saveCroppedBitmap, Runnable onEndRunnable) {
            this.mInUri = null;
            this.mInResId = 0;
            this.mCropBounds = null;
            this.mOutputFormat = "jpg";
            this.mInImageBytes = imageBytes;
            init(cropBounds, rotation, outWidth, outHeight, setWallpaper, saveCroppedBitmap, onEndRunnable);
        }

        public BitmapCropTask(Context c, Uri inUri, RectF cropBounds, int rotation, int outWidth, int outHeight, boolean setWallpaper, boolean saveCroppedBitmap, Runnable onEndRunnable) {
            this.mInUri = null;
            this.mInResId = 0;
            this.mCropBounds = null;
            this.mOutputFormat = "jpg";
            this.mContext = c;
            this.mInUri = inUri;
            init(cropBounds, rotation, outWidth, outHeight, setWallpaper, saveCroppedBitmap, onEndRunnable);
        }

        public BitmapCropTask(Context c, Resources res, int inResId, RectF cropBounds, int rotation, int outWidth, int outHeight, boolean setWallpaper, boolean saveCroppedBitmap, Runnable onEndRunnable) {
            this.mInUri = null;
            this.mInResId = 0;
            this.mCropBounds = null;
            this.mOutputFormat = "jpg";
            this.mContext = c;
            this.mInResId = inResId;
            this.mResources = res;
            init(cropBounds, rotation, outWidth, outHeight, setWallpaper, saveCroppedBitmap, onEndRunnable);
        }

        private void init(RectF cropBounds, int rotation, int outWidth, int outHeight, boolean setWallpaper, boolean saveCroppedBitmap, Runnable onEndRunnable) {
            this.mCropBounds = cropBounds;
            this.mRotation = rotation;
            this.mOutWidth = outWidth;
            this.mOutHeight = outHeight;
            this.mSetWallpaper = setWallpaper;
            this.mSaveCroppedBitmap = saveCroppedBitmap;
            this.mOnEndRunnable = onEndRunnable;
        }

        public void setOnBitmapCropped(OnBitmapCroppedHandler handler) {
            this.mOnBitmapCroppedHandler = handler;
        }

        public void setNoCrop(boolean value) {
            this.mNoCrop = value;
        }

        public void setOnEndRunnable(Runnable onEndRunnable) {
            this.mOnEndRunnable = onEndRunnable;
        }

        private void regenerateInputStream() {
            if (this.mInUri == null && this.mInResId == 0 && this.mInFilePath == null && this.mInImageBytes == null) {
                Log.w(WallpaperCropActivity.LOGTAG, "cannot read original file, no input URI, resource ID, or image byte array given");
                return;
            }
            Utils.closeSilently(this.mInStream);
            try {
                if (this.mInUri != null) {
                    this.mInStream = new BufferedInputStream(this.mContext.getContentResolver().openInputStream(this.mInUri));
                } else if (this.mInFilePath != null) {
                    this.mInStream = this.mContext.openFileInput(this.mInFilePath);
                } else if (this.mInImageBytes != null) {
                    this.mInStream = new BufferedInputStream(new ByteArrayInputStream(this.mInImageBytes));
                } else {
                    this.mInStream = new BufferedInputStream(this.mResources.openRawResource(this.mInResId));
                }
            } catch (FileNotFoundException e) {
                Log.w(WallpaperCropActivity.LOGTAG, "cannot read file: " + this.mInUri.toString(), e);
            }
        }

        public Point getImageBounds() {
            regenerateInputStream();
            if (this.mInStream == null) {
                return null;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(this.mInStream, null, options);
            if (options.outWidth == 0 || options.outHeight == 0) {
                return null;
            }
            return new Point(options.outWidth, options.outHeight);
        }

        public void setCropBounds(RectF cropBounds) {
            this.mCropBounds = cropBounds;
        }

        public Bitmap getCroppedBitmap() {
            return this.mCroppedBitmap;
        }

        public boolean cropBitmap() {
            boolean failure = false;
            regenerateInputStream();
            WallpaperManager wallpaperManager = null;
            if (this.mSetWallpaper) {
                wallpaperManager = WallpaperManager.getInstance(this.mContext.getApplicationContext());
            }
            LauncherApplication.mAppWallPaper = true;
            SharedPreferences.Editor editor = com.syu.util.Utils.getSp().edit();
            editor.putBoolean("mAppWallPaper", LauncherApplication.mAppWallPaper);
            editor.commit();
            if (this.mSetWallpaper && this.mNoCrop && this.mInStream != null) {
                try {
                    wallpaperManager.setStream(this.mInStream);
                } catch (IOException e) {
                    Log.w(WallpaperCropActivity.LOGTAG, "cannot write stream to wallpaper", e);
                    failure = true;
                }
                return !failure;
            }
            if (this.mInStream != null) {
                Rect roundedTrueCrop = new Rect();
                Matrix rotateMatrix = new Matrix();
                Matrix inverseRotateMatrix = new Matrix();
                if (this.mRotation > 0) {
                    rotateMatrix.setRotate(this.mRotation);
                    inverseRotateMatrix.setRotate(-this.mRotation);
                    this.mCropBounds.roundOut(roundedTrueCrop);
                    this.mCropBounds = new RectF(roundedTrueCrop);
                    Point bounds = getImageBounds();
                    float[] rotatedBounds = {bounds.x, bounds.y};
                    rotateMatrix.mapPoints(rotatedBounds);
                    rotatedBounds[0] = Math.abs(rotatedBounds[0]);
                    rotatedBounds[1] = Math.abs(rotatedBounds[1]);
                    this.mCropBounds.offset((-rotatedBounds[0]) / WallpaperCropActivity.WALLPAPER_SCREENS_SPAN, (-rotatedBounds[1]) / WallpaperCropActivity.WALLPAPER_SCREENS_SPAN);
                    inverseRotateMatrix.mapRect(this.mCropBounds);
                    this.mCropBounds.offset(bounds.x / 2, bounds.y / 2);
                    regenerateInputStream();
                }
                this.mCropBounds.roundOut(roundedTrueCrop);
                if (roundedTrueCrop.width() <= 0 || roundedTrueCrop.height() <= 0) {
                    Log.w(WallpaperCropActivity.LOGTAG, "crop has bad values for full size image");
                    return false;
                }
                int scaleDownSampleSize = Math.min(roundedTrueCrop.width() / this.mOutWidth, roundedTrueCrop.height() / this.mOutHeight);
                BitmapRegionDecoder decoder = null;
                try {
                    decoder = BitmapRegionDecoder.newInstance(this.mInStream, true);
                } catch (IOException e2) {
                    Log.w(WallpaperCropActivity.LOGTAG, "cannot open region decoder for file: " + this.mInUri.toString(), e2);
                }
                Bitmap crop = null;
                if (decoder != null) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    if (scaleDownSampleSize > 1) {
                        options.inSampleSize = scaleDownSampleSize;
                    }
                    crop = decoder.decodeRegion(roundedTrueCrop, options);
                    decoder.recycle();
                }
                if (crop == null) {
                    regenerateInputStream();
                    Bitmap fullSize = null;
                    if (this.mInStream != null) {
                        BitmapFactory.Options options2 = new BitmapFactory.Options();
                        if (scaleDownSampleSize > 1) {
                            options2.inSampleSize = scaleDownSampleSize;
                        }
                        fullSize = BitmapFactory.decodeStream(this.mInStream, null, options2);
                    }
                    if (fullSize != null) {
                        this.mCropBounds.left /= scaleDownSampleSize;
                        this.mCropBounds.top /= scaleDownSampleSize;
                        this.mCropBounds.bottom /= scaleDownSampleSize;
                        this.mCropBounds.right /= scaleDownSampleSize;
                        this.mCropBounds.roundOut(roundedTrueCrop);
                        crop = Bitmap.createBitmap(fullSize);
                    }
                }
                if (crop == null) {
                    Log.w(WallpaperCropActivity.LOGTAG, "cannot decode file: " + this.mInUri.toString());
                    return false;
                }
                if ((this.mOutWidth > 0 && this.mOutHeight > 0) || this.mRotation > 0) {
                    float[] dimsAfter = {crop.getWidth(), crop.getHeight()};
                    rotateMatrix.mapPoints(dimsAfter);
                    dimsAfter[0] = Math.abs(dimsAfter[0]);
                    dimsAfter[1] = Math.abs(dimsAfter[1]);
                    if (this.mOutWidth <= 0 || this.mOutHeight <= 0) {
                        this.mOutWidth = Math.round(dimsAfter[0]);
                        this.mOutHeight = Math.round(dimsAfter[1]);
                    }
                    RectF cropRect = new RectF(0.0f, 0.0f, dimsAfter[0], dimsAfter[1]);
                    RectF returnRect = new RectF(0.0f, 0.0f, this.mOutWidth, this.mOutHeight);
                    Matrix m = new Matrix();
                    if (this.mRotation == 0) {
                        m.setRectToRect(cropRect, returnRect, Matrix.ScaleToFit.FILL);
                    } else {
                        Matrix m1 = new Matrix();
                        m1.setTranslate((-crop.getWidth()) / WallpaperCropActivity.WALLPAPER_SCREENS_SPAN, (-crop.getHeight()) / WallpaperCropActivity.WALLPAPER_SCREENS_SPAN);
                        Matrix m2 = new Matrix();
                        m2.setRotate(this.mRotation);
                        Matrix m3 = new Matrix();
                        m3.setTranslate(dimsAfter[0] / WallpaperCropActivity.WALLPAPER_SCREENS_SPAN, dimsAfter[1] / WallpaperCropActivity.WALLPAPER_SCREENS_SPAN);
                        Matrix m4 = new Matrix();
                        m4.setRectToRect(cropRect, returnRect, Matrix.ScaleToFit.FILL);
                        Matrix c1 = new Matrix();
                        c1.setConcat(m2, m1);
                        Matrix c2 = new Matrix();
                        c2.setConcat(m4, m3);
                        m.setConcat(c2, c1);
                    }
                    Bitmap tmp = Bitmap.createBitmap((int) returnRect.width(), (int) returnRect.height(), Bitmap.Config.ARGB_8888);
                    if (tmp != null) {
                        Canvas c = new Canvas(tmp);
                        Paint p = new Paint();
                        p.setFilterBitmap(true);
                        c.drawBitmap(crop, m, p);
                        crop = tmp;
                    }
                }
                if (this.mSaveCroppedBitmap) {
                    this.mCroppedBitmap = crop;
                }
                Bitmap.CompressFormat cf = WallpaperCropActivity.convertExtensionToCompressFormat(WallpaperCropActivity.getFileExtension(this.mOutputFormat));
                ByteArrayOutputStream tmpOut = new ByteArrayOutputStream(2048);
                if (crop.compress(cf, 90, tmpOut)) {
                    if (this.mSetWallpaper && wallpaperManager != null) {
                        try {
                            byte[] outByteArray = tmpOut.toByteArray();
                            wallpaperManager.setStream(new ByteArrayInputStream(outByteArray));
                            if (this.mOnBitmapCroppedHandler != null) {
                                this.mOnBitmapCroppedHandler.onBitmapCropped(outByteArray);
                            }
                        } catch (IOException e3) {
                            Log.w(WallpaperCropActivity.LOGTAG, "cannot write stream to wallpaper", e3);
                            failure = true;
                        }
                    }
                } else {
                    Log.w(WallpaperCropActivity.LOGTAG, "cannot compress bitmap");
                    failure = true;
                }
            }
            return !failure;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Boolean doInBackground(Void... params) {
            return Boolean.valueOf(cropBitmap());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean result) {
            if (this.mOnEndRunnable != null) {
                this.mOnEndRunnable.run();
            }
        }
    }

    protected void updateWallpaperDimensions(int width, int height) {
        String spKey = getSharedPreferencesKey();
        SharedPreferences sp = getSharedPreferences(spKey, 0);
        SharedPreferences.Editor editor = sp.edit();
        if (width != 0 && height != 0) {
            editor.putInt(WALLPAPER_WIDTH_KEY, width);
            editor.putInt(WALLPAPER_HEIGHT_KEY, height);
        } else {
            editor.remove(WALLPAPER_WIDTH_KEY);
            editor.remove(WALLPAPER_HEIGHT_KEY);
        }
        editor.commit();
        suggestWallpaperDimension(getResources(), sp, getWindowManager(), WallpaperManager.getInstance(this));
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.android.launcher66.WallpaperCropActivity$5] */
    public static void suggestWallpaperDimension(Resources res, final SharedPreferences sharedPrefs, WindowManager windowManager, final WallpaperManager wallpaperManager) {
        final Point defaultWallpaperSize = getDefaultWallpaperSize(res, windowManager);
        new Thread("suggestWallpaperDimension") { // from class: com.android.launcher66.WallpaperCropActivity.5
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                int savedWidth = sharedPrefs.getInt(WallpaperCropActivity.WALLPAPER_WIDTH_KEY, defaultWallpaperSize.x);
                int savedHeight = sharedPrefs.getInt(WallpaperCropActivity.WALLPAPER_HEIGHT_KEY, defaultWallpaperSize.y);
                wallpaperManager.suggestDesiredDimensions(savedWidth, savedHeight);
            }
        }.start();
    }

    protected static RectF getMaxCropRect(int inWidth, int inHeight, int outWidth, int outHeight, boolean leftAligned) {
        RectF cropRect = new RectF();
        if (inWidth / inHeight > outWidth / outHeight) {
            cropRect.top = 0.0f;
            cropRect.bottom = inHeight;
            cropRect.left = (inWidth - ((outWidth / outHeight) * inHeight)) / WALLPAPER_SCREENS_SPAN;
            cropRect.right = inWidth - cropRect.left;
            if (leftAligned) {
                cropRect.right -= cropRect.left;
                cropRect.left = 0.0f;
            }
        } else {
            cropRect.left = 0.0f;
            cropRect.right = inWidth;
            cropRect.top = (inHeight - ((outHeight / outWidth) * inWidth)) / WALLPAPER_SCREENS_SPAN;
            cropRect.bottom = inHeight - cropRect.top;
        }
        return cropRect;
    }

    protected static Bitmap.CompressFormat convertExtensionToCompressFormat(String extension) {
        return extension.equals("png") ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }

    protected static String getFileExtension(String requestFormat) {
        String outputFormat = (requestFormat == null ? "jpg" : requestFormat).toLowerCase();
        return (outputFormat.equals("png") || outputFormat.equals("gif")) ? "png" : "jpg";
    }
}
