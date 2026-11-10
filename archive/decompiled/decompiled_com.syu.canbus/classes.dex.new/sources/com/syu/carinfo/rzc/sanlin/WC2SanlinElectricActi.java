package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class WC2SanlinElectricActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.WC2SanlinElectricActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = R.drawable.icon_car_null;
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 147:
                    WC2SanlinElectricActi.this.mUpdaterBatteryVol();
                    break;
                case 148:
                    View viewFindViewById = WC2SanlinElectricActi.this.findViewById(R.id.layout_view2);
                    if (value == 1) {
                        i = R.drawable.ic_wc_sanlin_electri2;
                    }
                    viewFindViewById.setBackgroundResource(i);
                    break;
                case 149:
                    View viewFindViewById2 = WC2SanlinElectricActi.this.findViewById(R.id.layout_view3);
                    if (value == 1) {
                        i = R.drawable.ic_wc_sanlin_electri3;
                    }
                    viewFindViewById2.setBackgroundResource(i);
                    break;
                case 150:
                    View viewFindViewById3 = WC2SanlinElectricActi.this.findViewById(R.id.layout_view4);
                    if (value == 1) {
                        i = R.drawable.ic_wc_sanlin_electri1;
                    }
                    viewFindViewById3.setBackgroundResource(i);
                    break;
                case 151:
                    View viewFindViewById4 = WC2SanlinElectricActi.this.findViewById(R.id.layout_view5);
                    if (value == 1) {
                        i = R.drawable.ic_wc_sanlin_electri4;
                    }
                    viewFindViewById4.setBackgroundResource(i);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc_sanlin_electric);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBatteryVol() {
        int value = DataCanbus.DATA[147];
        switch (value) {
            case 0:
                findViewById(R.id.layout_view6).setBackgroundResource(R.drawable.ic_wc_sanlin_battery_lv0);
                break;
            case 1:
                findViewById(R.id.layout_view6).setBackgroundResource(R.drawable.ic_wc_sanlin_battery_lv1);
                break;
            case 2:
                findViewById(R.id.layout_view6).setBackgroundResource(R.drawable.ic_wc_sanlin_battery_lv2);
                break;
            case 3:
                findViewById(R.id.layout_view6).setBackgroundResource(R.drawable.ic_wc_sanlin_battery_lv3);
                break;
            case 4:
                findViewById(R.id.layout_view6).setBackgroundResource(R.drawable.ic_wc_sanlin_battery_lv4);
                break;
            case 5:
                findViewById(R.id.layout_view6).setBackgroundResource(R.drawable.ic_wc_sanlin_battery_lv5);
                break;
            case 6:
                findViewById(R.id.layout_view6).setBackgroundResource(R.drawable.ic_wc_sanlin_battery_lv6);
                break;
        }
    }
}
