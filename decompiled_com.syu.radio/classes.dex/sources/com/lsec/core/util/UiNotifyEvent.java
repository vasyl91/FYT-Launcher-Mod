package com.lsec.core.util;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class UiNotifyEvent {
    public static Handler HANDLER_UI = new Handler(Looper.getMainLooper());
    public IUiNotify uiNotify = null;

    public void updateNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
        NotifyData notifyData = new NotifyData(updateCode, ints, flts, strs);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            notifyData.run();
        } else {
            HANDLER_UI.post(notifyData);
        }
    }

    private class NotifyData implements Runnable {
        public float[] flts;
        public int[] ints;
        public String[] strs;
        public int updateCode;

        public NotifyData(int updateCode, int[] ints, float[] flts, String[] strs) {
            this.updateCode = updateCode;
            this.ints = ints;
            this.flts = flts;
            this.strs = strs;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (UiNotifyEvent.this.uiNotify != null) {
                UiNotifyEvent.this.uiNotify.onNotify(this.updateCode, this.ints, this.flts, this.strs);
            }
        }
    }
}
