package com.lsec.core.util;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class SingleDoubleClickListener implements View.OnTouchListener {
    private static int timeout = 400;
    private int clickCount = 0;
    private Handler handler = new Handler();
    private MyClickCallBack myClickCallBack;

    public interface MyClickCallBack {
        void doubleClick(View view);

        void oneClick(View view);
    }

    public SingleDoubleClickListener(MyClickCallBack myClickCallBack) {
        this.myClickCallBack = myClickCallBack;
    }

    public class Runnable_Touch implements Runnable {
        View v;

        public Runnable_Touch(View v) {
            this.v = v;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SingleDoubleClickListener.this.clickCount != 1) {
                if (SingleDoubleClickListener.this.clickCount == 2) {
                    SingleDoubleClickListener.this.myClickCallBack.doubleClick(this.v);
                }
            } else {
                SingleDoubleClickListener.this.myClickCallBack.oneClick(this.v);
            }
            SingleDoubleClickListener.this.handler.removeCallbacksAndMessages(null);
            SingleDoubleClickListener.this.clickCount = 0;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            this.clickCount++;
            this.handler.postDelayed(new Runnable_Touch(v), timeout);
            return true;
        }
        return true;
    }
}
