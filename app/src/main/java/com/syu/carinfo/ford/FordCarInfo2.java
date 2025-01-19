package com.syu.carinfo.ford;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;
import com.syu.module.canbus.DataCanbus;

public class FordCarInfo2 extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 142:
                    ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + " km");
                    break;
                case 143:
                    if (value > 999) {
                        ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text2)).setText("-- km");
                        break;
                    } else {
                        ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " km");
                        break;
                    }
                case 144:
                    int value2 = (value * 2) + 1;
                    if (value2 > 300) {
                        ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text1)).setText("---- L/100km");
                        break;
                    } else {
                        ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + " L/100km");
                        break;
                    }
                case 145:
                    int temp = value / 2;
                    if (temp > 100) {
                        ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text3)).setText("-- L");
                        break;
                    } else {
                        ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text3)).setText(String.format("%d L", Integer.valueOf(temp)));
                        break;
                    }
                case 243:
                    if (value == 255) {
                        ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text8)).setText("-- km/h");
                        break;
                    } else {
                        ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + " km/h");
                        break;
                    }
                case 244:
                    ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 2) + " km");
                    break;
                case 245:
                    if (value > 100) {
                        ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text6)).setText("-- ");
                        break;
                    } else {
                        ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "%");
                        break;
                    }
                case 246:
                    ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text7)).setText(String.valueOf((((value * Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D11_D2_B3) / 755) + 30) / 10.0f) + " V");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0334_rzc_ford_carinfo2);
        init();
    }

    @Override
    public void init() {
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{66}, null, null);
        DataCanbus.PROXY.cmd(0, new int[]{105}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[243].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[244].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[245].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[246].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[243].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[244].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[245].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[246].removeNotify(this.mNotifyCanbus);
    }
}
