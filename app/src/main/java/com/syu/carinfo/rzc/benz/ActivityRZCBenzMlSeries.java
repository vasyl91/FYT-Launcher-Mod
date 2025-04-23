package com.syu.carinfo.rzc.benz;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ActivityRZCBenzMlSeries extends Activity {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 99:
                    if (DataCanbus.DATA[updateCode] == 1) {
                        ((TextView) ActivityRZCBenzMlSeries.this.findViewById(R.id.benz_carassist_flag)).setText(R.string.rzc_c4l_open);
                        break;
                    } else {
                        ((TextView) ActivityRZCBenzMlSeries.this.findViewById(R.id.benz_carassist_flag)).setText(R.string.rzc_c4l_close);
                        break;
                    }
                case 100:
                    if (DataCanbus.DATA[updateCode] == 1) {
                        ((TextView) ActivityRZCBenzMlSeries.this.findViewById(R.id.benz_carradar_flag)).setText(R.string.rzc_c4l_open);
                        break;
                    } else {
                        ((TextView) ActivityRZCBenzMlSeries.this.findViewById(R.id.benz_carradar_flag)).setText(R.string.rzc_c4l_close);
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_benz_mlseries);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    protected void onPause() {
        super.onPause();
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
    }
}
