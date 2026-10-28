package com.syu.carinfo.focus;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class FocusReceiver extends BroadcastReceiver {
    private static final int msg_handle_back = 0;
    Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.syu.carinfo.focus.FocusReceiver.1
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    removeMessages(0);
                    if (FocusSyncBtActi.getInstance() != null) {
                        FocusSyncBtActi.getInstance();
                        if (FocusSyncBtActi.isFront) {
                            FocusReceiver.this.toBack(FocusSyncBtActi.getInstance());
                        }
                    }
                    break;
            }
        }
    };
    private Context mContext;

    /* JADX WARN: Code duplicated, block: B:12:0x0030  */
    /* JADX WARN: Code duplicated, block: B:20:0x0053  */
    /* JADX WARN: Code duplicated, block: B:25:0x0069  */
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.mContext = context;
        if (intent != null && intent.getAction().equals("com.syu.canbus.focus.sync")) {
            new Bundle();
            Bundle bundle = intent.getExtras();
            switch (bundle.getInt("key.display.mode")) {
                case 0:
                    handleBack(2000);
                    break;
                case 1:
                    this.handler.removeMessages(0);
                    if (FocusSyncBtActi.getInstance() == null) {
                        toActivity();
                    } else {
                        FocusSyncBtActi.getInstance();
                        if (!FocusSyncBtActi.isFront) {
                            toActivity();
                        }
                    }
                    break;
                case 2:
                    this.handler.removeMessages(0);
                    if (FocusSyncBtActi.getInstance() == null) {
                        toActivity();
                    } else {
                        FocusSyncBtActi.getInstance();
                        if (!FocusSyncBtActi.isFront) {
                            toActivity();
                        }
                    }
                    break;
                default:
                    if (FocusSyncBtActi.getInstance() == null) {
                        toBack(FocusSyncBtActi.getInstance());
                    } else {
                        FocusSyncBtActi.getInstance();
                        if (!FocusSyncBtActi.isFront) {
                            toBack(FocusSyncBtActi.getInstance());
                        }
                    }
                    break;
            }
            switch (bundle.getInt("key.sync_state")) {
                case -1:
                    if (FocusSyncBtActi.getInstance() != null) {
                        FocusSyncBtActi.getInstance();
                        if (FocusSyncBtActi.isFront) {
                            toBack(FocusSyncBtActi.getInstance());
                        }
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toBack(Activity activity) {
        if (activity != null) {
            activity.moveTaskToBack(true);
        }
    }

    private void toActivity() {
        if (this.mContext != null) {
            Intent intent = new Intent("com.syu.carinfo.sync");
            intent.addFlags(335544320);
            TheApp.getInstance().startActivity(intent);
        }
    }

    private void handleBack(int delayed) {
        this.handler.removeMessages(0);
        this.handler.sendEmptyMessageDelayed(0, delayed);
    }
}
