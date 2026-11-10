package com.syu.carinfo.xp.yinglang;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

@SuppressWarnings({"deprecation", "unchecked"})
public class YLRecevier extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("com.syu.onstar.xp.yinglang.showpip") && !YLOnStarAct.mIsFront) {
            YLShowPip.showWindow();
        }
    }
}
