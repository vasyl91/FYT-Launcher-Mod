package com.syu.carinfo.rzc.klc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

@SuppressWarnings({"deprecation", "unchecked"})
public class RzcKlcRecevier extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("com.syu.onstar.rzc.showpip") && !RzcKlcOnStarAct.mIsFront) {
            RzcShowPip.showWindow();
        }
    }
}
