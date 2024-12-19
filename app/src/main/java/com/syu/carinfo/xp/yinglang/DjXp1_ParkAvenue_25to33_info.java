package com.syu.carinfo.xp.yinglang;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class DjXp1_ParkAvenue_25to33_info extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.yinglang.DjXp1_ParkAvenue_25to33_info.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 33:
                    DjXp1_ParkAvenue_25to33_info.this.mUpdateCarSpeed();
                    break;
                case 38:
                    DjXp1_ParkAvenue_25to33_info.this.mUpdateMachineSpeed();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0025_dj_parkavenue);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCarSpeed() {
        int value = DataCanbus.DATA[33];
        if (((TextView) findViewById(R.id.cs75_tv_current_speed)) != null) {
            ((TextView) findViewById(R.id.cs75_tv_current_speed)).setText(String.valueOf(value) + "km/h");
        }
    }

    protected void mUpdateMachineSpeed() {
        int value = DataCanbus.DATA[38];
        if (((TextView) findViewById(R.id.cs75_tv_engine_speed)) != null) {
            ((TextView) findViewById(R.id.cs75_tv_engine_speed)).setText(String.valueOf(value) + "rpm");
        }
    }
}
