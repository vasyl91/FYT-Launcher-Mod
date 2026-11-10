package com.syu.carinfo.od.mazdall;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class WCSuzukiCurrentCarInfo extends BaseActivity implements View.OnClickListener {
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    if (value == 65535) {
                        ((TextView) WCSuzukiCurrentCarInfo.this.findViewById(R.id.tv_text1)).setText("----");
                        break;
                    } else {
                        ((TextView) WCSuzukiCurrentCarInfo.this.findViewById(R.id.tv_text1)).setText(value / 10 + "." + (value % 10) + " kWh/100km");
                        break;
                    }
                case 100:
                    if (value == 65535) {
                        ((TextView) WCSuzukiCurrentCarInfo.this.findViewById(R.id.tv_text2)).setText("----");
                        break;
                    } else {
                        ((TextView) WCSuzukiCurrentCarInfo.this.findViewById(R.id.tv_text2)).setText(value / 10 + "." + (value % 10) + " kWh/100km");
                        break;
                    }
                case 101:
                    if (value == 65535) {
                        ((TextView) WCSuzukiCurrentCarInfo.this.findViewById(R.id.tv_text3)).setText("----");
                        break;
                    } else {
                        ((TextView) WCSuzukiCurrentCarInfo.this.findViewById(R.id.tv_text3)).setText(value / 10 + "." + (value % 10) + " km/h");
                        break;
                    }
                case 102:
                    if (value == 65535) {
                        ((TextView) WCSuzukiCurrentCarInfo.this.findViewById(R.id.tv_text4)).setText("----");
                        break;
                    } else {
                        ((TextView) WCSuzukiCurrentCarInfo.this.findViewById(R.id.tv_text4)).setText(value / 10 + "." + (value % 10) + " km");
                        break;
                    }
                case 103:
                    if (value == 65535) {
                        ((TextView) WCSuzukiCurrentCarInfo.this.findViewById(R.id.tv_text5)).setText("----");
                        break;
                    } else {
                        ((TextView) WCSuzukiCurrentCarInfo.this.findViewById(R.id.tv_text5)).setText(value / 10 + "." + (value % 10) + " km");
                        break;
                    }
                case 104:
                    int hour = (value >> 8) & 65535;
                    int min = value & 255;
                    if (value == 16777215) {
                        ((TextView) WCSuzukiCurrentCarInfo.this.findViewById(R.id.tv_text6)).setText("----");
                        break;
                    } else {
                        ((TextView) WCSuzukiCurrentCarInfo.this.findViewById(R.id.tv_text6)).setText(hour / 10 + "H" + min + "M");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc_suzuki_cur_carinfo);
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

    @Override
    public void onClick(View v) {
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
    }
}
