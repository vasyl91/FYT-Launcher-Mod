package com.fyt.flow;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;

public class TrifficReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        float percentage;
        if (intent != null) {
            double total_usage = intent.getDoubleExtra("total_usage", 0.0d);
            double surplusUsage = intent.getDoubleExtra("surplusUsage", 0.0d);
            if (surplusUsage == 0.0d) {
                percentage = 0.0f;
            } else {
                percentage = ((float) (surplusUsage / total_usage)) * 100.0f;
            }
            Message msg = new Message();
            msg.obj = new Triffic(total_usage, surplusUsage, percentage);
        }
    }
}
