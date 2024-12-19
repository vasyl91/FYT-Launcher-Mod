package com.syu.carinfo.rzc.keleijia;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class KeLeiJiaCarTire extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.keleijia.KeLeiJiaCarTire.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 72:
                    KeLeiJiaCarTire.this.mUpdaterTireFL();
                    break;
                case 73:
                    KeLeiJiaCarTire.this.mUpdaterTireFR();
                    break;
                case 74:
                    KeLeiJiaCarTire.this.mUpdaterTireRL();
                    break;
                case 75:
                    KeLeiJiaCarTire.this.mUpdaterTireRR();
                    break;
                case 76:
                    KeLeiJiaCarTire.this.updaterTireWarn();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (LauncherApplication.getConfiguration() == 1) {
            setContentView(R.layout.layout_xbs_tule_tire);
        } else {
            setContentView(R.layout.layout_oudi_zt_t600_tire);
        }
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[74].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[75].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[74].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[75].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[72];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
            return;
        }
        int value2 = value * 3;
        if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value2 / 100) + "." + ((value2 % 100) / 10) + "BAR");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[73];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
            return;
        }
        int value2 = value * 3;
        if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value2 / 100) + "." + ((value2 % 100) / 10) + "BAR");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[74];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
            return;
        }
        int value2 = value * 3;
        if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value2 / 100) + "." + ((value2 % 100) / 10) + "BAR");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[75];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
            return;
        }
        int value2 = value * 3;
        if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value2 / 100) + "." + ((value2 % 100) / 10) + "BAR");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTireWarn() {
        int value = DataCanbus.DATA[76];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText(R.string.str_tire_state0);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText(R.string.str_tire_state1);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText(R.string.str_tire_state2);
                break;
            case 3:
                ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText(R.string.str_tire_state3);
                break;
            case 4:
                ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText(R.string.str_tire_state4);
                break;
            case 5:
                ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText(R.string.str_tire_state5);
                break;
            case 6:
                ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText(R.string.str_tire_state6);
                break;
        }
    }
}
