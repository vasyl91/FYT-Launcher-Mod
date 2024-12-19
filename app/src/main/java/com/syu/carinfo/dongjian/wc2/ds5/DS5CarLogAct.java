package com.syu.carinfo.dongjian.wc2.ds5;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class DS5CarLogAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dongjian.wc2.ds5.DS5CarLogAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 1:
                    DS5CarLogAct.this.updaterSpeed();
                    break;
                case 2:
                    DS5CarLogAct.this.updaterOil();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_302_dongjian_wc2_ds5_car_log);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSpeed() {
        int xingshiSpeedValue = DataCanbus.DATA[1];
        ((TextView) findViewById(R.id.dongjian_wc2_ds5_xingshi_speed_tv)).setText(xingshiSpeedValue + "Km/h");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterOil() {
        int xunshiOilValue = DataCanbus.DATA[2];
        ((TextView) findViewById(R.id.dongjian_wc2_ds5_xunshi_oil_tv)).setText(String.valueOf(String.format("%.1f", Float.valueOf(xunshiOilValue / 10.0f))) + "L/100Km");
    }
}
