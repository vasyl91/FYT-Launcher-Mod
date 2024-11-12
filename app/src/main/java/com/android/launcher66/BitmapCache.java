package com.android.launcher66;

import android.graphics.Bitmap;

class BitmapCache extends WeakReferenceThreadLocal<Bitmap> {
    BitmapCache() {
    }

    public Bitmap initialValue() {
        return null;
    }
}