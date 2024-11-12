package com.android.launcher66;

import android.graphics.BitmapFactory;

class BitmapFactoryOptionsCache extends SoftReferenceThreadLocal<BitmapFactory.Options> {
    BitmapFactoryOptionsCache() {
    }

    public BitmapFactory.Options initialValue() {
        return new BitmapFactory.Options();
    }
}