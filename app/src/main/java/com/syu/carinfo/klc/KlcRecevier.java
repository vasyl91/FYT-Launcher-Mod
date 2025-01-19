package com.syu.carinfo.klc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.syu.module.canbus.DataCanbus;

public class KlcRecevier extends BroadcastReceiver {
    @Override
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
