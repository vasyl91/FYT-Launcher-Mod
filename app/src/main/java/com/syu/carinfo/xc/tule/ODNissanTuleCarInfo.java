package com.syu.carinfo.xc.tule;

import android.os.Bundle;
import android.os.SystemProperties;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ODNissanTuleCarInfo extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 107:
                    ((TextView) ODNissanTuleCarInfo.this.findViewById(R.id.xbstule_driving_mileage)).setText(String.valueOf(value) + " km");
                    break;
                case 108:
                    if (value == 65535) {
                        ((TextView) ODNissanTuleCarInfo.this.findViewById(R.id.xbstule_avgoil)).setText("---- L/100km");
                        break;
                    } else {
                        ((TextView) ODNissanTuleCarInfo.this.findViewById(R.id.xbstule_avgoil)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                        break;
                    }
                case 109:
                    ((TextView) ODNissanTuleCarInfo.this.findViewById(R.id.xbstule_mileage)).setText(String.valueOf(value) + " km");
                    break;
                case 110:
                    ((TextView) ODNissanTuleCarInfo.this.findViewById(R.id.xbstule_engine_speed)).setText(String.format("%d rqm", Integer.valueOf(value)));
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String platform = SystemProperties.get("ro.fyt.platform", "");
        if ("6315".equals(platform) || "6312".equals(platform) || "6521".equals(platform) || "6316".equals(platform) || "6318".equals(platform)) {
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
        DataCanbus.PROXY.cmd(1, new int[]{113}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{2}, null, null);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.PROXY.cmd(2, new int[1], null, null);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
    }
}
