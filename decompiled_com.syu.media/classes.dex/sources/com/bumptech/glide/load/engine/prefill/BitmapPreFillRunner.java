package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Util;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
final class BitmapPreFillRunner implements Runnable {
    static final int BACKOFF_RATIO = 4;
    static final long INITIAL_BACKOFF_MS = 40;
    static final long MAX_DURATION_MS = 32;
    static final String TAG = "PreFillRunner";
    private final BitmapPool bitmapPool;
    private final Clock clock;
    private long currentDelay;
    private final Handler handler;
    private boolean isCancelled;
    private final MemoryCache memoryCache;
    private final Set<PreFillType> seenTypes;
    private final PreFillQueue toPrefill;
    private static final Clock DEFAULT_CLOCK = new Clock();
    static final long MAX_BACKOFF_MS = TimeUnit.SECONDS.toMillis(1);

    public BitmapPreFillRunner(BitmapPool bitmapPool, MemoryCache memoryCache, PreFillQueue preFillQueue) {
        this(bitmapPool, memoryCache, preFillQueue, DEFAULT_CLOCK, new Handler(Looper.getMainLooper()));
    }

    BitmapPreFillRunner(BitmapPool bitmapPool, MemoryCache memoryCache, PreFillQueue preFillQueue, Clock clock, Handler handler) {
        this.seenTypes = new HashSet();
        this.currentDelay = INITIAL_BACKOFF_MS;
        this.bitmapPool = bitmapPool;
        this.memoryCache = memoryCache;
        this.toPrefill = preFillQueue;
        this.clock = clock;
        this.handler = handler;
    }

    public void cancel() {
        this.isCancelled = true;
    }

    boolean allocate() {
        Bitmap bitmapCreateBitmap;
        long jNow = this.clock.now();
        while (!this.toPrefill.isEmpty() && !isGcDetected(jNow)) {
            PreFillType preFillTypeRemove = this.toPrefill.remove();
            if (!this.seenTypes.contains(preFillTypeRemove)) {
                this.seenTypes.add(preFillTypeRemove);
                bitmapCreateBitmap = this.bitmapPool.getDirty(preFillTypeRemove.getWidth(), preFillTypeRemove.getHeight(), preFillTypeRemove.getConfig());
            } else {
                bitmapCreateBitmap = Bitmap.createBitmap(preFillTypeRemove.getWidth(), preFillTypeRemove.getHeight(), preFillTypeRemove.getConfig());
            }
            int bitmapByteSize = Util.getBitmapByteSize(bitmapCreateBitmap);
            if (getFreeMemoryCacheBytes() >= bitmapByteSize) {
                this.memoryCache.put(new UniqueKey(), BitmapResource.obtain(bitmapCreateBitmap, this.bitmapPool));
            } else {
                this.bitmapPool.put(bitmapCreateBitmap);
            }
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "allocated [" + preFillTypeRemove.getWidth() + "x" + preFillTypeRemove.getHeight() + "] " + preFillTypeRemove.getConfig() + " size: " + bitmapByteSize);
            }
        }
        return (this.isCancelled || this.toPrefill.isEmpty()) ? false : true;
    }

    private boolean isGcDetected(long j) {
        return this.clock.now() - j >= MAX_DURATION_MS;
    }

    private long getFreeMemoryCacheBytes() {
        return this.memoryCache.getMaxSize() - this.memoryCache.getCurrentSize();
    }

    @Override // java.lang.Runnable
    public void run() {
        if (allocate()) {
            this.handler.postDelayed(this, getNextDelay());
        }
    }

    private long getNextDelay() {
        long j = this.currentDelay;
        this.currentDelay = Math.min(4 * j, MAX_BACKOFF_MS);
        return j;
    }

    private static final class UniqueKey implements Key {
        UniqueKey() {
        }

        @Override // com.bumptech.glide.load.Key
        public void updateDiskCacheKey(MessageDigest messageDigest) {
            throw new UnsupportedOperationException();
        }
    }

    static class Clock {
        Clock() {
        }

        long now() {
            return SystemClock.currentThreadTimeMillis();
        }
    }
}
