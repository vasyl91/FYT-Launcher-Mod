package com.syu.carinfo.od.mazdall;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class WCLeepMotorLastChargingCarInfo extends BaseActivity implements View.OnClickListener {
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 108:
                    if (value == 65535) {
                        ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text1)).setText("----");
                        break;
                    } else {
                        ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text1)).setText(value / 10 + "." + (value % 10) + " kWh/100km");
                        break;
                    }
                case 109:
                    if (value == 65535) {
                        ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text2)).setText("----");
                        break;
                    } else {
                        ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text2)).setText(value / 10 + "." + (value % 10) + " kWh/100km");
                        break;
                    }
                case 110:
                    if (value == 16777215) {
                        ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text3)).setText("----");
                        break;
                    } else {
                        ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text3)).setText(value / 10 + "." + (value % 10) + " km");
                        break;
                    }
                case 111:
                    if (value == 255) {
                        ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text4)).setText("----");
                        break;
                    } else {
                        ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text4)).setText(value + "%");
                        break;
                    }
                case 112:
                    if (value == 255) {
                        ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text5)).setText("----");
                        break;
                    } else {
                        ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text5)).setText(value + "%");
                        break;
                    }
                case 113:
                    if (value == 255) {
                        ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text6)).setText("----");
                        break;
                    } else {
                        ((TextView) WCLeepMotorLastChargingCarInfo.this.findViewById(R.id.tv_text6)).setText(value + "%");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc_leepmotor_lastcharge_carinfo);
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
        v.getId();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
    }
}
