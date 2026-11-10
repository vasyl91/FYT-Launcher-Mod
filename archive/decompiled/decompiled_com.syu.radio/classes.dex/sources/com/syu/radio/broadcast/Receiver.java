package com.syu.radio.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.lsec.core.frame.app.MyApplication;
import com.lsec.core.ipc.module.main.Main;
import com.syu.radio.App_Radio;
import com.syu.radio.Interface_Radio;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Receiver extends BroadcastReceiver {
    public static final String Gallery_SetPic = "com.syu.gallery.setradiobk";
    public static final String REMOVE_BROADCAST = "com.fyt.systemui.remove";
    public Runnable mRunnableSetBtnBk = new Runnable() { // from class: com.syu.radio.broadcast.Receiver.1
        @Override // java.lang.Runnable
        public void run() {
            for (Interface_Radio interfaceRadio : App_Radio.mInterfaceRadio) {
                interfaceRadio.setBtnBk();
            }
        }
    };

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws Throwable {
        String action = intent.getAction();
        if (REMOVE_BROADCAST.equals(action)) {
            Bundle bundle = intent.getExtras();
            if (bundle != null && !bundle.isEmpty()) {
                handleRemoveTask(bundle);
                return;
            }
            return;
        }
        if (Gallery_SetPic.equals(action)) {
            String path = intent.getStringExtra("pic_path");
            App_Radio.getInstance().mRadioFreqBkManager.add(App_Radio.mStrFreqCur, path);
            Main.postRunnable_Ui(true, this.mRunnableSetBtnBk);
        }
    }

    private void handleRemoveTask(Bundle bundle) throws Throwable {
        if (!App_Radio.getInstance().isAppTop() && MyApplication.myApp.getPackageName().equals(bundle.getString("pkg"))) {
            App_Radio.getInstance().saveSet();
            App_Radio.getInstance().mIpcObj.requestAppIdNull();
        }
    }
}
