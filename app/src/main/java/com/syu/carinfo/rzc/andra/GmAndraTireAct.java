package com.syu.carinfo.rzc.andra;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class GmAndraTireAct extends BaseActivity {
    public static GmAndraTireAct mInit;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.andra.GmAndraTireAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 113:
                    GmAndraTireAct.this.mUpdaterTireFL();
                    break;
                case 114:
                    GmAndraTireAct.this.mUpdaterTireFR();
                    break;
                case 115:
                    GmAndraTireAct.this.mUpdaterTireRL();
                    break;
                case 116:
                    GmAndraTireAct.this.mUpdaterTireRR();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_camry_tire);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        mInit = this;
        findViewById(R.id.camry_layout_car).setVisibility(0);
        findViewById(R.id.camry_layout_line).setVisibility(8);
        findViewById(R.id.camry_layout_none).setVisibility(8);
        findViewById(R.id.camry_tv_car_tire_4).setVisibility(8);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(11, new int[]{74, 1}, null, null);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
    }

    void mUpdaterTireRR() {
        int value = DataCanbus.DATA[116];
        ((TextView) findViewById(R.id.camry_tv_car_tire_3)).setText(new StringBuilder().append(value * 4).toString());
        ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText("KPA");
    }

    void mUpdaterTireRL() {
        int value = DataCanbus.DATA[115];
        ((TextView) findViewById(R.id.camry_tv_car_tire_2)).setText(new StringBuilder().append(value * 4).toString());
        ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText("KPA");
    }

    void mUpdaterTireFR() {
        int value = DataCanbus.DATA[114];
        ((TextView) findViewById(R.id.camry_tv_car_tire_1)).setText(new StringBuilder().append(value * 4).toString());
        ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText("KPA");
    }

    void mUpdaterTireFL() {
        int value = DataCanbus.DATA[113];
        ((TextView) findViewById(R.id.camry_tv_car_tire_0)).setText(new StringBuilder().append(value * 4).toString());
        ((TextView) findViewById(R.id.camry_tv_car_tire_unit)).setText("KPA");
    }
}
