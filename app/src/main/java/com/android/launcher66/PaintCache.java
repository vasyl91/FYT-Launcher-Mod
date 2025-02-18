package com.android.launcher66;

import android.graphics.Paint;

class PaintCache extends SoftReferenceThreadLocal<Paint> {
    PaintCache() {
    }

    
    /* JADX WARN: Can't rename method to resolve collision */
    @Override
    public Paint initialValue() {
        return null;
    }
}
