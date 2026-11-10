package com.nostra13.universalimageloader.core;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public final class DisplayImageOptions {
    private final boolean cacheInMemory;
    private final boolean cacheOnDisc;
    private final boolean considerExifParams;
    private final BitmapFactory.Options decodingOptions;
    private final int delayBeforeLoading;
    private final BitmapDisplayer displayer;
    private final Object extraForDownloader;
    private final Handler handler;
    private final Drawable imageForEmptyUri;
    private final Drawable imageOnFail;
    private final Drawable imageOnLoading;
    private final int imageResForEmptyUri;
    private final int imageResOnFail;
    private final int imageResOnLoading;
    private final ImageScaleType imageScaleType;
    private final boolean isSyncLoading;
    private final BitmapProcessor postProcessor;
    private final BitmapProcessor preProcessor;
    private final boolean resetViewBeforeLoading;

    private DisplayImageOptions(Builder builder) {
        this.imageResOnLoading = builder.imageResOnLoading;
        this.imageResForEmptyUri = builder.imageResForEmptyUri;
        this.imageResOnFail = builder.imageResOnFail;
        this.imageOnLoading = builder.imageOnLoading;
        this.imageForEmptyUri = builder.imageForEmptyUri;
        this.imageOnFail = builder.imageOnFail;
        this.resetViewBeforeLoading = builder.resetViewBeforeLoading;
        this.cacheInMemory = builder.cacheInMemory;
        this.cacheOnDisc = builder.cacheOnDisc;
        this.imageScaleType = builder.imageScaleType;
        this.decodingOptions = builder.decodingOptions;
        this.delayBeforeLoading = builder.delayBeforeLoading;
        this.considerExifParams = builder.considerExifParams;
        this.extraForDownloader = builder.extraForDownloader;
        this.preProcessor = builder.preProcessor;
        this.postProcessor = builder.postProcessor;
        this.displayer = builder.displayer;
        this.handler = builder.handler;
        this.isSyncLoading = builder.isSyncLoading;
    }

    public boolean shouldShowImageOnLoading() {
        return (this.imageOnLoading == null && this.imageResOnLoading == 0) ? false : true;
    }

    public boolean shouldShowImageForEmptyUri() {
        return (this.imageForEmptyUri == null && this.imageResForEmptyUri == 0) ? false : true;
    }

    public boolean shouldShowImageOnFail() {
        return (this.imageOnFail == null && this.imageResOnFail == 0) ? false : true;
    }

    public boolean shouldPreProcess() {
        return this.preProcessor != null;
    }

    public boolean shouldPostProcess() {
        return this.postProcessor != null;
    }

    public boolean shouldDelayBeforeLoading() {
        return this.delayBeforeLoading > 0;
    }

    public Drawable getImageOnLoading(Resources res) {
        return this.imageResOnLoading != 0 ? res.getDrawable(this.imageResOnLoading) : this.imageOnLoading;
    }

    public Drawable getImageForEmptyUri(Resources res) {
        return this.imageResForEmptyUri != 0 ? res.getDrawable(this.imageResForEmptyUri) : this.imageForEmptyUri;
    }

    public Drawable getImageOnFail(Resources res) {
        return this.imageResOnFail != 0 ? res.getDrawable(this.imageResOnFail) : this.imageOnFail;
    }

    public boolean isResetViewBeforeLoading() {
        return this.resetViewBeforeLoading;
    }

    public boolean isCacheInMemory() {
        return this.cacheInMemory;
    }

    public boolean isCacheOnDisc() {
        return this.cacheOnDisc;
    }

    public ImageScaleType getImageScaleType() {
        return this.imageScaleType;
    }

    public BitmapFactory.Options getDecodingOptions() {
        return this.decodingOptions;
    }

    public int getDelayBeforeLoading() {
        return this.delayBeforeLoading;
    }

    public boolean isConsiderExifParams() {
        return this.considerExifParams;
    }

    public Object getExtraForDownloader() {
        return this.extraForDownloader;
    }

    public BitmapProcessor getPreProcessor() {
        return this.preProcessor;
    }

    public BitmapProcessor getPostProcessor() {
        return this.postProcessor;
    }

    public BitmapDisplayer getDisplayer() {
        return this.displayer;
    }

    public Handler getHandler() {
        if (this.isSyncLoading) {
            return null;
        }
        if (this.handler == null) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                throw new IllegalStateException("ImageLoader.displayImage(...) must be invoked from the main thread or from Looper thread");
            }
            return new Handler();
        }
        return this.handler;
    }

    boolean isSyncLoading() {
        return this.isSyncLoading;
    }

    public static class Builder {
        private int imageResOnLoading = 0;
        private int imageResForEmptyUri = 0;
        private int imageResOnFail = 0;
        private Drawable imageOnLoading = null;
        private Drawable imageForEmptyUri = null;
        private Drawable imageOnFail = null;
        private boolean resetViewBeforeLoading = false;
        private boolean cacheInMemory = false;
        private boolean cacheOnDisc = false;
        private ImageScaleType imageScaleType = ImageScaleType.IN_SAMPLE_POWER_OF_2;
        private BitmapFactory.Options decodingOptions = new BitmapFactory.Options();
        private int delayBeforeLoading = 0;
        private boolean considerExifParams = false;
        private Object extraForDownloader = null;
        private BitmapProcessor preProcessor = null;
        private BitmapProcessor postProcessor = null;
        private BitmapDisplayer displayer = DefaultConfigurationFactory.createBitmapDisplayer();
        private Handler handler = null;
        private boolean isSyncLoading = false;

        public Builder() {
            this.decodingOptions.inPurgeable = true;
            this.decodingOptions.inInputShareable = true;
        }

        @Deprecated
        public Builder showStubImage(int imageRes) {
            this.imageResOnLoading = imageRes;
            return this;
        }

        public Builder showImageOnLoading(int imageRes) {
            this.imageResOnLoading = imageRes;
            return this;
        }

        public Builder showImageOnLoading(Drawable drawable) {
            this.imageOnLoading = drawable;
            return this;
        }

        public Builder showImageForEmptyUri(int imageRes) {
            this.imageResForEmptyUri = imageRes;
            return this;
        }

        public Builder showImageForEmptyUri(Drawable drawable) {
            this.imageForEmptyUri = drawable;
            return this;
        }

        public Builder showImageOnFail(int imageRes) {
            this.imageResOnFail = imageRes;
            return this;
        }

        public Builder showImageOnFail(Drawable drawable) {
            this.imageOnFail = drawable;
            return this;
        }

        public Builder resetViewBeforeLoading() {
            this.resetViewBeforeLoading = true;
            return this;
        }

        public Builder resetViewBeforeLoading(boolean resetViewBeforeLoading) {
            this.resetViewBeforeLoading = resetViewBeforeLoading;
            return this;
        }

        public Builder cacheInMemory() {
            this.cacheInMemory = true;
            return this;
        }

        public Builder cacheInMemory(boolean cacheInMemory) {
            this.cacheInMemory = cacheInMemory;
            return this;
        }

        public Builder cacheOnDisc() {
            this.cacheOnDisc = true;
            return this;
        }

        public Builder cacheOnDisc(boolean cacheOnDisc) {
            this.cacheOnDisc = cacheOnDisc;
            return this;
        }

        public Builder imageScaleType(ImageScaleType imageScaleType) {
            this.imageScaleType = imageScaleType;
            return this;
        }

        public Builder bitmapConfig(Bitmap.Config bitmapConfig) {
            if (bitmapConfig == null) {
                throw new IllegalArgumentException("bitmapConfig can't be null");
            }
            this.decodingOptions.inPreferredConfig = bitmapConfig;
            return this;
        }

        public Builder decodingOptions(BitmapFactory.Options decodingOptions) {
            if (decodingOptions == null) {
                throw new IllegalArgumentException("decodingOptions can't be null");
            }
            this.decodingOptions = decodingOptions;
            return this;
        }

        public Builder delayBeforeLoading(int delayInMillis) {
            this.delayBeforeLoading = delayInMillis;
            return this;
        }

        public Builder extraForDownloader(Object extra) {
            this.extraForDownloader = extra;
            return this;
        }

        public Builder considerExifParams(boolean considerExifParams) {
            this.considerExifParams = considerExifParams;
            return this;
        }

        public Builder preProcessor(BitmapProcessor preProcessor) {
            this.preProcessor = preProcessor;
            return this;
        }

        public Builder postProcessor(BitmapProcessor postProcessor) {
            this.postProcessor = postProcessor;
            return this;
        }

        public Builder displayer(BitmapDisplayer displayer) {
            if (displayer == null) {
                throw new IllegalArgumentException("displayer can't be null");
            }
            this.displayer = displayer;
            return this;
        }

        Builder syncLoading(boolean isSyncLoading) {
            this.isSyncLoading = isSyncLoading;
            return this;
        }

        public Builder handler(Handler handler) {
            this.handler = handler;
            return this;
        }

        public Builder cloneFrom(DisplayImageOptions options) {
            this.imageResOnLoading = options.imageResOnLoading;
            this.imageResForEmptyUri = options.imageResForEmptyUri;
            this.imageResOnFail = options.imageResOnFail;
            this.imageOnLoading = options.imageOnLoading;
            this.imageForEmptyUri = options.imageForEmptyUri;
            this.imageOnFail = options.imageOnFail;
            this.resetViewBeforeLoading = options.resetViewBeforeLoading;
            this.cacheInMemory = options.cacheInMemory;
            this.cacheOnDisc = options.cacheOnDisc;
            this.imageScaleType = options.imageScaleType;
            this.decodingOptions = options.decodingOptions;
            this.delayBeforeLoading = options.delayBeforeLoading;
            this.considerExifParams = options.considerExifParams;
            this.extraForDownloader = options.extraForDownloader;
            this.preProcessor = options.preProcessor;
            this.postProcessor = options.postProcessor;
            this.displayer = options.displayer;
            this.handler = options.handler;
            this.isSyncLoading = options.isSyncLoading;
            return this;
        }

        public DisplayImageOptions build() {
            return new DisplayImageOptions(this);
        }
    }

    public static DisplayImageOptions createSimple() {
        return new Builder().build();
    }
}
