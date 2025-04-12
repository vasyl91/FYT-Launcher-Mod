package com.syu.carinfo.wc.changan;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ActivityChangAnCS75 extends Activity {
    private IUiNotify canbusNotify = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 99:
                    ((TextView) ActivityChangAnCS75.this.findViewById(R.id.cs75_tv_current_speed)).setText(String.valueOf(DataCanbus.DATA[updateCode]) + " km/h");
                    break;
                case 100:
                    ((TextView) ActivityChangAnCS75.this.findViewById(R.id.cs75_tv_engine_speed)).setText(String.valueOf(DataCanbus.DATA[updateCode]) + " r/min");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_128_wc_changancs75);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.canbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.canbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.canbusNotify);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.canbusNotify);
    }
}
