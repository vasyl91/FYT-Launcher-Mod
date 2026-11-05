package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.util.Util;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class BitmapPreFiller {
    private final BitmapPool bitmapPool;
    private BitmapPreFillRunner current;
    private final DecodeFormat defaultFormat;
    private final MemoryCache memoryCache;

    public BitmapPreFiller(MemoryCache memoryCache, BitmapPool bitmapPool, DecodeFormat decodeFormat) {
        this.memoryCache = memoryCache;
        this.bitmapPool = bitmapPool;
        this.defaultFormat = decodeFormat;
    }

    public void preFill(PreFillType.Builder... builderArr) {
        Bitmap.Config config;
        BitmapPreFillRunner bitmapPreFillRunner = this.current;
        if (bitmapPreFillRunner != null) {
            bitmapPreFillRunner.cancel();
        }
        PreFillType[] preFillTypeArr = new PreFillType[builderArr.length];
        for (int i = 0; i < builderArr.length; i++) {
            PreFillType.Builder builder = builderArr[i];
            if (builder.getConfig() == null) {
                if (this.defaultFormat == DecodeFormat.PREFER_ARGB_8888) {
                    config = Bitmap.Config.ARGB_8888;
                } else {
                    config = Bitmap.Config.RGB_565;
                }
                builder.setConfig(config);
            }
            preFillTypeArr[i] = builder.build();
        }
        BitmapPreFillRunner bitmapPreFillRunner2 = new BitmapPreFillRunner(this.bitmapPool, this.memoryCache, generateAllocationOrder(preFillTypeArr));
        this.current = bitmapPreFillRunner2;
        Util.postOnUiThread(bitmapPreFillRunner2);
    }

    PreFillQueue generateAllocationOrder(PreFillType... preFillTypeArr) {
        long maxSize = (this.memoryCache.getMaxSize() - this.memoryCache.getCurrentSize()) + this.bitmapPool.getMaxSize();
        int weight = 0;
        for (PreFillType preFillType : preFillTypeArr) {
            weight += preFillType.getWeight();
        }
        float f = maxSize / weight;
        HashMap map = new HashMap();
        for (PreFillType preFillType2 : preFillTypeArr) {
            map.put(preFillType2, Integer.valueOf(Math.round(preFillType2.getWeight() * f) / getSizeInBytes(preFillType2)));
        }
        return new PreFillQueue(map);
    }

    private static int getSizeInBytes(PreFillType preFillType) {
        return Util.getBitmapByteSize(preFillType.getWidth(), preFillType.getHeight(), preFillType.getConfig());
    }
}
