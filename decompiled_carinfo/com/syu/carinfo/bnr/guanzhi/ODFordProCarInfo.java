package com.syu.carinfo.bnr.guanzhi;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ODFordProCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 122:
                    if (value == 255) {
                        ((TextView) ODFordProCarInfo.this.findViewById(R.id.tv_text1)).setText("---- L/100km");
                        break;
                    } else {
                        ((TextView) ODFordProCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                        break;
                    }
                case 123:
                    ((TextView) ODFordProCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " km");
                    break;
                case 124:
                    ((TextView) ODFordProCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "%");
                    break;
                case 125:
                    ((TextView) ODFordProCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value * 0.1f) + " km");
                    break;
                case 126:
                    ((TextView) ODFordProCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 2) + " km");
                    break;
                case 127:
                    if (value > 100) {
                        ((TextView) ODFordProCarInfo.this.findViewById(R.id.tv_text6)).setText("-- ");
                        break;
                    } else {
                        ((TextView) ODFordProCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "%");
                        break;
                    }
                case 128:
                    ((TextView) ODFordProCarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10.0f) + " V");
                    break;
                case 129:
                    ((TextView) ODFordProCarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + " km/h");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0334_rzc_ford_carinfo2);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{66}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
    }
}
