package com.syu.loopview;

final class SmoothScrollTimerTask implements Runnable {
    final LoopView loopView;
    int offset;
    int realTotalOffset = Integer.MAX_VALUE;
    int realOffset = 0;

    SmoothScrollTimerTask(LoopView loopview, int offset) {
        this.loopView = loopview;
        this.offset = offset;
    }

    @Override
    public final void run() {
        if (this.realTotalOffset == Integer.MAX_VALUE) {
            this.realTotalOffset = this.offset;
        }
        this.realOffset = (int) (this.realTotalOffset * 0.1f);
        if (this.realOffset == 0) {
            if (this.realTotalOffset < 0) {
                this.realOffset = -1;
            } else {
                this.realOffset = 1;
            }
        }
        if (Math.abs(this.realTotalOffset) <= 0) {
            this.loopView.cancelFuture();
            this.loopView.handler.sendEmptyMessage(MessageHandler.WHAT_ITEM_SELECTED);
        } else {
            this.loopView.totalScrollY += this.realOffset;
            this.loopView.handler.sendEmptyMessage(1000);
            this.realTotalOffset -= this.realOffset;
        }
    }
}
