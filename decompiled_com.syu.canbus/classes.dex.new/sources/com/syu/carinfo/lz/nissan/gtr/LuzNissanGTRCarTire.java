package com.syu.carinfo.lz.nissan.gtr;

import android.os.Bundle;
import android.os.SystemProperties;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LuzNissanGTRCarTire extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.nissan.gtr.LuzNissanGTRCarTire.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 115:
                case 119:
                    LuzNissanGTRCarTire.this.mUpdaterTireFR();
                    break;
                case 116:
                case 120:
                    LuzNissanGTRCarTire.this.mUpdaterTireFL();
                    break;
                case 117:
                case 121:
                    LuzNissanGTRCarTire.this.mUpdaterTireRR();
                    break;
                case 118:
                case 122:
                    LuzNissanGTRCarTire.this.mUpdaterTireRL();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (TheApp.getConfiguration() == 1) {
            setContentView(R.layout.layout_xbs_tule_tire);
        } else {
            setContentView(R.layout.layout_oudi_zt_t600_tire);
        }
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(2, new int[]{54, 0}, null, null);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[116];
        int state = DataCanbus.DATA[120];
        if (state == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value) + "kPa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf((value * 1000) / 6895) + "Psi");
                    break;
                case 2:
                    int value2 = value / 10;
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "bar");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[115];
        int state = DataCanbus.DATA[119];
        if (state == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
        }
        int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
        switch (TireUnit) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value) + "kPa");
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf((value * 1000) / 6895) + "Psi");
                break;
            case 2:
                int value2 = value / 10;
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "bar");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[118];
        int state = DataCanbus.DATA[122];
        if (state == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
        }
        int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
        switch (TireUnit) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value) + "kPa");
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf((value * 1000) / 6895) + "Psi");
                break;
            case 2:
                int value2 = value / 10;
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "bar");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[117];
        int state = DataCanbus.DATA[121];
        if (state == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
        }
        int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
        switch (TireUnit) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value) + "kPa");
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf((value * 1000) / 6895) + "Psi");
                break;
            case 2:
                int value2 = value / 10;
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "bar");
                break;
        }
    }
}
