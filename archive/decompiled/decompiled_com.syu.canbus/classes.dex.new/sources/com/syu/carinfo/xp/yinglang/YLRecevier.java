package com.syu.carinfo.xp.yinglang;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class YLRecevier extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("com.syu.onstar.xp.yinglang.showpip") && !YLOnStarAct.mIsFront) {
            YLShowPip.showWindow();
        }
    }
}
