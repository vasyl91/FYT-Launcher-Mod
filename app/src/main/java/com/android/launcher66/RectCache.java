package com.android.launcher66;

import android.graphics.Rect;

class RectCache extends SoftReferenceThreadLocal<Rect> {
    RectCache() {
    }

    
    /* JADX WARN: Can't rename method to resolve collision */
    @Override
    public Rect initialValue() {
        return new Rect();
    }
}
