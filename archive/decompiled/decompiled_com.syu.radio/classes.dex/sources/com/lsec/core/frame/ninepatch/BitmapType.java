package com.lsec.core.frame.ninepatch;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public enum BitmapType {
    NinePatch { // from class: com.lsec.core.frame.ninepatch.BitmapType.1
        @Override // com.lsec.core.frame.ninepatch.BitmapType
        public NinePatchChunk createChunk(Bitmap bitmap) {
            return NinePatchChunk.parse(bitmap.getNinePatchChunk());
        }
    },
    RawNinePatch { // from class: com.lsec.core.frame.ninepatch.BitmapType.2
        @Override // com.lsec.core.frame.ninepatch.BitmapType
        protected NinePatchChunk createChunk(Bitmap bitmap) {
            try {
                return NinePatchChunk.createChunkFromRawBitmap(bitmap, false);
            } catch (RuntimeException e) {
                return NinePatchChunk.createEmptyChunk();
            }
        }

        @Override // com.lsec.core.frame.ninepatch.BitmapType
        protected Bitmap modifyBitmap(Resources resources, Bitmap bitmap, NinePatchChunk chunk) {
            Bitmap content = Bitmap.createBitmap(bitmap, 1, 1, bitmap.getWidth() - 2, bitmap.getHeight() - 2);
            int targetDensity = resources.getDisplayMetrics().densityDpi;
            float densityChange = targetDensity / bitmap.getDensity();
            if (densityChange != 1.0f) {
                int dstWidth = Math.round(content.getWidth() * densityChange);
                int dstHeight = Math.round(content.getHeight() * densityChange);
                content = Bitmap.createScaledBitmap(content, dstWidth, dstHeight, true);
                content.setDensity(targetDensity);
                chunk.padding = new Rect(Math.round(chunk.padding.left * densityChange), Math.round(chunk.padding.top * densityChange), Math.round(chunk.padding.right * densityChange), Math.round(chunk.padding.bottom * densityChange));
                recalculateDivs(densityChange, chunk.xDivs);
                recalculateDivs(densityChange, chunk.yDivs);
            }
            return content;
        }

        private void recalculateDivs(float densityChange, ArrayList<Div> divs) {
            for (Div div : divs) {
                div.start = Math.round(div.start * densityChange);
                div.stop = Math.round(div.stop * densityChange);
            }
        }
    },
    PlainImage { // from class: com.lsec.core.frame.ninepatch.BitmapType.3
        @Override // com.lsec.core.frame.ninepatch.BitmapType
        protected NinePatchChunk createChunk(Bitmap bitmap) {
            return NinePatchChunk.createEmptyChunk();
        }
    },
    NULL { // from class: com.lsec.core.frame.ninepatch.BitmapType.4
        @Override // com.lsec.core.frame.ninepatch.BitmapType
        protected NinePatchDrawable createNinePatchDrawable(Resources resources, Bitmap bitmap, String srcName) {
            return null;
        }
    };

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static BitmapType[] valuesCustom() {
        BitmapType[] bitmapTypeArrValuesCustom = values();
        int length = bitmapTypeArrValuesCustom.length;
        BitmapType[] bitmapTypeArr = new BitmapType[length];
        System.arraycopy(bitmapTypeArrValuesCustom, 0, bitmapTypeArr, 0, length);
        return bitmapTypeArr;
    }

    /* synthetic */ BitmapType(BitmapType bitmapType) {
        this();
    }

    protected NinePatchChunk createChunk(Bitmap bitmap) {
        return NinePatchChunk.createEmptyChunk();
    }

    protected Bitmap modifyBitmap(Resources resources, Bitmap bitmap, NinePatchChunk chunk) {
        return bitmap;
    }

    public static BitmapType determineBitmapType(Bitmap bitmap) {
        if (bitmap == null) {
            return NULL;
        }
        byte[] ninePatchChunk = bitmap.getNinePatchChunk();
        if (ninePatchChunk != null && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            return NinePatch;
        }
        if (NinePatchChunk.isRawNinePatchBitmap(bitmap)) {
            return RawNinePatch;
        }
        return PlainImage;
    }

    public static NinePatchDrawable getNinePatchDrawable(Resources resources, Bitmap bitmap, String srcName) {
        return determineBitmapType(bitmap).createNinePatchDrawable(resources, bitmap, srcName);
    }

    protected NinePatchDrawable createNinePatchDrawable(Resources resources, Bitmap bitmap, String srcName) {
        NinePatchChunk chunk = createChunk(bitmap);
        return new NinePatchDrawable(resources, modifyBitmap(resources, bitmap, chunk), chunk.toBytes(), chunk.padding, srcName);
    }
}
