package com.syu.carinfo.focus;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.android.launcher66.LauncherApplication;

@SuppressWarnings({"deprecation", "unchecked"})
public class FocusReceiver extends BroadcastReceiver {
    private static final int msg_handle_back = 0;
    Handler handler = new Handler(Looper.getMainLooper()) { 
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    removeMessages(0);
                    if (FocusSyncBtActi.getInstance() != null) {
                        FocusSyncBtActi.getInstance();
                        if (FocusSyncBtActi.isFront) {
                            FocusReceiver.this.toBack(FocusSyncBtActi.getInstance());
                            break;
                        }
                    }
                    break;
            }
        }
    };
    private Context mContext;

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002e, code lost:
    
        if (com.syu.carinfo.focus.FocusSyncBtActi.isFront == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0051, code lost:
    
        if (com.syu.carinfo.focus.FocusSyncBtActi.isFront == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
    
        if (com.syu.carinfo.focus.FocusSyncBtActi.isFront == false) goto L25;
     */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onReceive(android.content.Context r5, android.content.Intent r6) {
        /*
            r4 = this;
            r3 = 0
            r4.mContext = r5
            if (r6 == 0) goto L40
            java.lang.String r1 = r6.getAction()
            java.lang.String r2 = "com.syu.canbus.focus.sync"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L40
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            android.os.Bundle r0 = r6.getExtras()
            java.lang.String r1 = "key.display.mode"
            int r1 = r0.getInt(r1)
            switch(r1) {
                case 0: goto L6d;
                case 1: goto L41;
                case 2: goto L57;
                default: goto L23;
            }
        L23:
            com.syu.carinfo.focus.FocusSyncBtActi r1 = com.syu.carinfo.focus.FocusSyncBtActi.getInstance()
            if (r1 == 0) goto L30
            com.syu.carinfo.focus.FocusSyncBtActi.getInstance()
            boolean r1 = com.syu.carinfo.focus.FocusSyncBtActi.isFront
            if (r1 != 0) goto L37
        L30:
            com.syu.carinfo.focus.FocusSyncBtActi r1 = com.syu.carinfo.focus.FocusSyncBtActi.getInstance()
            r4.toBack(r1)
        L37:
            java.lang.String r1 = "key.sync_state"
            int r1 = r0.getInt(r1)
            switch(r1) {
                case -1: goto L73;
                default: goto L40;
            }
        L40:
            return
        L41:
            android.os.Handler r1 = r4.handler
            r1.removeMessages(r3)
            com.syu.carinfo.focus.FocusSyncBtActi r1 = com.syu.carinfo.focus.FocusSyncBtActi.getInstance()
            if (r1 == 0) goto L53
            com.syu.carinfo.focus.FocusSyncBtActi.getInstance()
            boolean r1 = com.syu.carinfo.focus.FocusSyncBtActi.isFront
            if (r1 != 0) goto L37
        L53:
            r4.toActivity()
            goto L37
        L57:
            android.os.Handler r1 = r4.handler
            r1.removeMessages(r3)
            com.syu.carinfo.focus.FocusSyncBtActi r1 = com.syu.carinfo.focus.FocusSyncBtActi.getInstance()
            if (r1 == 0) goto L69
            com.syu.carinfo.focus.FocusSyncBtActi.getInstance()
            boolean r1 = com.syu.carinfo.focus.FocusSyncBtActi.isFront
            if (r1 != 0) goto L37
        L69:
            r4.toActivity()
            goto L37
        L6d:
            r1 = 2000(0x7d0, float:2.803E-42)
            r4.handleBack(r1)
            goto L37
        L73:
            com.syu.carinfo.focus.FocusSyncBtActi r1 = com.syu.carinfo.focus.FocusSyncBtActi.getInstance()
            if (r1 == 0) goto L40
            com.syu.carinfo.focus.FocusSyncBtActi.getInstance()
            boolean r1 = com.syu.carinfo.focus.FocusSyncBtActi.isFront
            if (r1 == 0) goto L40
            com.syu.carinfo.focus.FocusSyncBtActi r1 = com.syu.carinfo.focus.FocusSyncBtActi.getInstance()
            r4.toBack(r1)
            goto L40
        */
        throw new UnsupportedOperationException("Method not decompiled: com.syu.carinfo.focus.FocusReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }

    
    public void toBack(Activity activity) {
        if (activity != null) {
            activity.moveTaskToBack(true);
        }
    }

    private void toActivity() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.syu.carinfo.sync");
            intent.addFlags(335544320);
            LauncherApplication.getInstance().startActivity(intent);
        }
    }

    private void handleBack(int delayed) {
        this.handler.removeMessages(0);
        this.handler.sendEmptyMessageDelayed(0, delayed);
    }
}
