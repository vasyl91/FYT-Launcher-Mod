package com.syu.carinfo.od.mazdall;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class WCLeepMotorElecCarInfo extends BaseActivity implements View.OnClickListener {
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 114:
                    if ((32768 & value) != 0) {
                        int value2 = 65536 - value;
                        ((TextView) WCLeepMotorElecCarInfo.this.findViewById(R.id.tv_text1)).setText("-" + (value2 / 10) + "." + (value2 % 10) + " A");
                        break;
                    } else {
                        ((TextView) WCLeepMotorElecCarInfo.this.findViewById(R.id.tv_text1)).setText(value / 10 + "." + (value % 10) + " A");
                        break;
                    }
                case 115:
                    if (value == 65535) {
                        ((TextView) WCLeepMotorElecCarInfo.this.findViewById(R.id.tv_text2)).setText("----");
                        break;
                    } else {
                        ((TextView) WCLeepMotorElecCarInfo.this.findViewById(R.id.tv_text2)).setText(value / 10 + "." + (value % 10) + " V");
                        break;
                    }
                case 116:
                    if (value == 255) {
                        ((TextView) WCLeepMotorElecCarInfo.this.findViewById(R.id.tv_text3)).setText("----");
                        break;
                    } else {
                        ((TextView) WCLeepMotorElecCarInfo.this.findViewById(R.id.tv_text3)).setText(value + "%");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc_leepmotor_elc_carinfo);
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
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
    }
}
