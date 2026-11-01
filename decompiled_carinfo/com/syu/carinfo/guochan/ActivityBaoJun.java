package com.syu.carinfo.guochan;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivityBaoJun extends Activity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 120:
                    int value = DataCanbus.DATA[120];
                    ((TextView) ActivityBaoJun.this.findViewById(R.id.tv_wc2_baojun_engine_speed)).setText(String.valueOf(String.valueOf(value)) + " r/min");
                    break;
                case 121:
                    int value2 = DataCanbus.DATA[121];
                    if (value2 == -1) {
                        ((TextView) ActivityBaoJun.this.findViewById(R.id.tv_wc2_baojun_throttle_position)).setText("-");
                        break;
                    } else {
                        ((TextView) ActivityBaoJun.this.findViewById(R.id.tv_wc2_baojun_throttle_position)).setText(String.valueOf(value2) + " %");
                        break;
                    }
                case 122:
                    int value3 = DataCanbus.DATA[122];
                    ActivityBaoJun.this.setText((TextView) ActivityBaoJun.this.findViewById(R.id.tv_wc2_baojun_dipped), value3);
                    break;
                case 123:
                    int value4 = DataCanbus.DATA[123];
                    ActivityBaoJun.this.setText((TextView) ActivityBaoJun.this.findViewById(R.id.tv_wc2_baojun_higbean), value4);
                    break;
                case 124:
                    int value5 = DataCanbus.DATA[124];
                    ActivityBaoJun.this.setText((TextView) ActivityBaoJun.this.findViewById(R.id.tv_wc2_baojun_lamp), value5);
                    break;
                case 125:
                    int value6 = DataCanbus.DATA[125];
                    ActivityBaoJun.this.setText((TextView) ActivityBaoJun.this.findViewById(R.id.tv_wc2_baojun_ffog), value6);
                    break;
                case 126:
                    int value7 = DataCanbus.DATA[126];
                    ActivityBaoJun.this.setText((TextView) ActivityBaoJun.this.findViewById(R.id.tv_wc2_baojun_turnleft), value7);
                    break;
                case 127:
                    int value8 = DataCanbus.DATA[127];
                    ActivityBaoJun.this.setText((TextView) ActivityBaoJun.this.findViewById(R.id.tv_wc2_baojun_turnright), value8);
                    break;
                case 128:
                    int value9 = DataCanbus.DATA[128];
                    ActivityBaoJun.this.setText((TextView) ActivityBaoJun.this.findViewById(R.id.tv_wc2_baojun_doubleflash), value9);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_395_wc2_baojun);
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
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.notifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.notifyCanbus);
    }

    
    public void setText(TextView textview, int value) {
        if (value == 1) {
            textview.setText(R.string.rzc_c4l_open);
        } else {
            textview.setText(R.string.rzc_c4l_close);
        }
    }
}
