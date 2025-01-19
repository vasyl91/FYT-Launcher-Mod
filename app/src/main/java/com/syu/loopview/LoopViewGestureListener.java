package com.syu.loopview;

import android.view.GestureDetector;
import android.view.MotionEvent;

final class LoopViewGestureListener extends GestureDetector.SimpleOnGestureListener {
    final LoopView loopView;

    LoopViewGestureListener(LoopView loopview) {
        this.loopView = loopview;
    }

    @Override
    public final boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        this.loopView.scrollBy(velocityY);
        return true;
    }
}
