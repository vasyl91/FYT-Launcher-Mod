package com.android.launcher66;

import android.graphics.Canvas;

class CanvasCache extends SoftReferenceThreadLocal<Canvas> {
    CanvasCache() {
    }

    public Canvas initialValue() {
        return new Canvas();
    }
}
