package com.syu.carinfo.xbs.tule;

import android.os.Bundle;
import android.os.SystemProperties;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class TdTuleCarInfo extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 125:
                    if (value >= 32768) {
                        ((TextView) TdTuleCarInfo.this.findViewById(R.id.xbstule_driving_mileage)).setText(R.string.str_oil_signal_low);
                        break;
                    } else {
                        ((TextView) TdTuleCarInfo.this.findViewById(R.id.xbstule_driving_mileage)).setText(String.valueOf(value) + " km");
                        break;
                    }
                case 126:
                    if (value == 65535) {
                        ((TextView) TdTuleCarInfo.this.findViewById(R.id.xbstule_avgoil)).setText("---- L/100km");
                        break;
                    } else {
                        ((TextView) TdTuleCarInfo.this.findViewById(R.id.xbstule_avgoil)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                        break;
                    }
                case 127:
                    ((TextView) TdTuleCarInfo.this.findViewById(R.id.xbstule_mileage)).setText(String.valueOf(value) + " km");
                    break;
                case 128:
                case 129:
                    int unit = DataCanbus.DATA[129];
                    int data = DataCanbus.DATA[128];
                    if (data == 65535) {
                        ((TextView) TdTuleCarInfo.this.findViewById(R.id.xbstule_engine_speed)).setText("---- ");
                        break;
                    } else if (unit == 1) {
                        ((TextView) TdTuleCarInfo.this.findViewById(R.id.xbstule_engine_speed)).setText(String.valueOf(data / 10) + "." + (data % 10) + " L/100km");
                        break;
                    } else {
                        ((TextView) TdTuleCarInfo.this.findViewById(R.id.xbstule_engine_speed)).setText(String.valueOf(data / 10) + "." + (data % 10) + " L/H");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String platform = SystemProperties.get("ro.fyt.platform", "");
        if (("6521".equals(platform) || "6315".equals(platform) || "6312".equals(platform) || "6316".equals(platform) || "6318".equals(platform)) && LauncherApplication.getConfiguration() == 1) {
            //setContentView(R.layout.layout_0439_xbstule_carinfo_9853);
        } else {
            //setContentView(R.layout.layout_0439_xbstule_carinfo);
        }
        ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_cur_oil);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{113}, null, null);
        DataCanbus.PROXY.cmd(1, new int[]{114}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
    }
}
