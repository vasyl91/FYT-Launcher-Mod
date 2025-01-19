package com.syu.loopview;

import android.util.Log;

final class InertiaTimerTask implements Runnable {
    float a = 2.1474836E9f;
    final LoopView loopView;
    final float velocityY;

    InertiaTimerTask(LoopView loopview, float velocityY) {
        this.loopView = loopview;
        this.velocityY = velocityY;
    }

    @Override
    public final void run() {
        if (this.a == 2.1474836E9f) {
            if (Math.abs(this.velocityY) <= 2000.0f) {
                this.a = this.velocityY;
            } else if (this.velocityY > 0.0f) {
                this.a = 2000.0f;
            } else {
                this.a = -2000.0f;
            }
        }
        if (Math.abs(this.a) >= 0.0f && Math.abs(this.a) <= 20.0f) {
            Log.i("gy", "WHAT_SMOOTH_SCROLL_INERTIA");
            this.loopView.handler.sendEmptyMessageDelayed(MessageHandler.WHAT_SMOOTH_SCROLL_INERTIA, 60L);
            this.loopView.cancelFuture();
            this.loopView.handler.sendEmptyMessage(MessageHandler.WHAT_SMOOTH_SCROLL);
            return;
        }
        int i = (int) ((this.a * 10.0f) / 1000.0f);
        LoopView loopview = this.loopView;
        loopview.totalScrollY -= i;
        if (!this.loopView.isLoop) {
            float itemHeight = this.loopView.lineSpacingMultiplier * this.loopView.itemTextHeight;
            if (this.loopView.totalScrollY <= ((int) ((-this.loopView.initPosition) * itemHeight))) {
                this.a = 40.0f;
                this.loopView.totalScrollY = (int) ((-this.loopView.initPosition) * itemHeight);
            } else if (this.loopView.totalScrollY >= ((int) (((this.loopView.items.size() - 1) - this.loopView.initPosition) * itemHeight))) {
                this.loopView.totalScrollY = (int) (((this.loopView.items.size() - 1) - this.loopView.initPosition) * itemHeight);
                this.a = -40.0f;
            }
        }
        if (this.a < 0.0f) {
            this.a += 20.0f;
        } else {
            this.a -= 20.0f;
        }
        this.loopView.handler.sendEmptyMessage(1000);
    }
}
