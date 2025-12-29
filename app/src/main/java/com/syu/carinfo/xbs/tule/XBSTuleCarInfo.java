package com.syu.carinfo.xbs.tule;

import android.os.Bundle;
import android.SystemProperties;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class XBSTuleCarInfo extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    ((TextView) XBSTuleCarInfo.this.findViewById(R.id.xbstule_mileage)).setText(String.valueOf(value) + " km");
                    break;
                case 100:
                    if (value >= 32768) {
                        ((TextView) XBSTuleCarInfo.this.findViewById(R.id.xbstule_driving_mileage)).setText(R.string.str_oil_signal_low);
                        break;
                    } else {
                        ((TextView) XBSTuleCarInfo.this.findViewById(R.id.xbstule_driving_mileage)).setText(String.valueOf(value) + " km");
                        break;
                    }
                case 101:
                    if (value == 65535) {
                        ((TextView) XBSTuleCarInfo.this.findViewById(R.id.xbstule_avgoil)).setText("---- L/100km");
                        break;
                    } else {
                        ((TextView) XBSTuleCarInfo.this.findViewById(R.id.xbstule_avgoil)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                        break;
                    }
                case 136:
                    ((TextView) XBSTuleCarInfo.this.findViewById(R.id.xbstule_engine_speed)).setText(String.format("%d rqm", Integer.valueOf(value)));
                    break;
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
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
    }
}
