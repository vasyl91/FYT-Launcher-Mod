package com.syu.carinfo.focus.yl;

import android.os.Handler;
import android.os.Message;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class HandlerAnim extends Handler {
    public static final HandlerAnim mInst = new HandlerAnim();
    private static final int msg_rulerview_anim = 0;

    private HandlerAnim() {
    }

    public void startRulerAnim() {
        sendEmptyMessage(0);
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case 0:
                if (ActivityRadio.mInst != null && ActivityRadio.mInst.mRuler != null) {
                    if (!ActivityRadio.mInst.mRuler.isAnimEnd()) {
                        ActivityRadio.mInst.mRuler.doAnim();
                        sendEmptyMessage(0);
                        break;
                    } else {
                        ActivityRadio.mInst.mRuler.setToTarget();
                        break;
                    }
                }
                break;
        }
    }
}
