package com.syu.carinfo.wc.gs4;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class GS3SpeedAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 123:
                    ((TextView) GS3SpeedAct.this.findViewById(R.id.cs75_tv_engine_speed)).setText(String.valueOf(DataCanbus.DATA[updateCode]) + " rpm");
                    break;
                case 124:
                    ((TextView) GS3SpeedAct.this.findViewById(R.id.cs75_tv_current_speed)).setText(String.valueOf(DataCanbus.DATA[updateCode]) + " km/h");
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
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
    }
}
