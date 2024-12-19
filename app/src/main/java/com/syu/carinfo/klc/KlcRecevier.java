package com.syu.carinfo.klc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class KlcRecevier extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (DataCanbus.DATA[1000] == 458788) {
            if (action.equals("com.syu.onstar.showpip") && !KlcOnStarGl6Act.mIsFront) {
                ShowPip.showWindow();
            } else if (action.equals("com.syu.onstar.showpip") && !KlcOnStarAct.mIsFront) {
                ShowPip.showWindow();
            }
        }
    }
}
