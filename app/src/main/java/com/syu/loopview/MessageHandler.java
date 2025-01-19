package com.syu.loopview;

import android.os.Handler;
import android.os.Message;
import com.syu.loopview.LoopView;

public final class MessageHandler extends Handler {
    public static final int WHAT_INVALIDATE_LOOP_VIEW = 1000;
    public static final int WHAT_ITEM_SELECTED = 3000;
    public static final int WHAT_SMOOTH_SCROLL = 2000;
    public static final int WHAT_SMOOTH_SCROLL_INERTIA = 2001;
    final LoopView loopview;

    MessageHandler(LoopView loopview) {
        this.loopview = loopview;
    }

    @Override
    public final void handleMessage(Message msg) {
        switch (msg.what) {
            case 1000:
                this.loopview.invalidate();
                break;
            case WHAT_SMOOTH_SCROLL /* 2000 */:
                removeMessages(WHAT_SMOOTH_SCROLL_INERTIA);
                this.loopview.smoothScroll(LoopView.ACTION.FLING);
                break;
            case WHAT_ITEM_SELECTED /* 3000 */:
                this.loopview.onItemSelected();
                break;
        }
    }
}
