package com.syu.carinfo.huiteng;

import android.os.Bundle;
import android.os.SystemProperties;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class HuitengCarInfo extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.huiteng.HuitengCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    ((TextView) HuitengCarInfo.this.findViewById(R.id.huiteng_engine_speed)).setText(String.format("%d rqm", Integer.valueOf(value)));
                    break;
                case 100:
                    ((TextView) HuitengCarInfo.this.findViewById(R.id.huiteng_voltage)).setText(String.valueOf(value / 100) + "." + (value % 100) + " V");
                    break;
                case 101:
                    ((TextView) HuitengCarInfo.this.findViewById(R.id.huiteng_mileage)).setText(String.format("%d km", Integer.valueOf(value)));
                    break;
                case 102:
                    ((TextView) HuitengCarInfo.this.findViewById(R.id.huiteng_oil)).setText(String.format("%d L", Integer.valueOf(value)));
                    break;
                case 103:
                    if (value != 0) {
                        ((TextView) HuitengCarInfo.this.findViewById(R.id.huiteng_voltage)).setTextColor(-65536);
                    } else {
                        ((TextView) HuitengCarInfo.this.findViewById(R.id.huiteng_voltage)).setTextColor(-1);
                    }
                    break;
                case 104:
                    if (value != 0) {
                        ((TextView) HuitengCarInfo.this.findViewById(R.id.huiteng_oil)).setTextColor(-65536);
                    } else {
                        ((TextView) HuitengCarInfo.this.findViewById(R.id.huiteng_oil)).setTextColor(-1);
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String platform = SystemProperties.get("ro.fyt.platform", "");
        if ("6315".equals(platform) || "6312".equals(platform) || "6521".equals(platform) || "6316".equals(platform) || "6318".equals(platform) || "6321".equals(platform)) {
            setContentView(R.layout.layout_0439_huiteng_carinfo_9853);
        } else {
            setContentView(R.layout.layout_0439_huiteng_carinfo);
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
    }
}
