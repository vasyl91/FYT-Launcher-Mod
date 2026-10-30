package com.syu.carinfo.wc.changan;

import android.os.Bundle;
import android.os.SystemProperties;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class WCChanganOushangX70ATireAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.changan.WCChanganOushangX70ATireAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 124:
                    WCChanganOushangX70ATireAct.this.mUpdaterTireFL();
                    break;
                case 125:
                    WCChanganOushangX70ATireAct.this.mUpdaterTireFR();
                    break;
                case 126:
                    WCChanganOushangX70ATireAct.this.mUpdaterTireRL();
                    break;
                case 127:
                    WCChanganOushangX70ATireAct.this.mUpdaterTireRR();
                    break;
                case 128:
                    WCChanganOushangX70ATireAct.this.updaterTempFL();
                    break;
                case 129:
                    WCChanganOushangX70ATireAct.this.updaterTempFR();
                    break;
                case 130:
                    WCChanganOushangX70ATireAct.this.updaterTempRL();
                    break;
                case 131:
                    WCChanganOushangX70ATireAct.this.updaterTempRR();
                    break;
                case 142:
                    WCChanganOushangX70ATireAct.this.updaterFLWarn();
                    break;
                case 143:
                    WCChanganOushangX70ATireAct.this.updaterFRWarn();
                    break;
                case 144:
                    WCChanganOushangX70ATireAct.this.updaterRLWarn();
                    break;
                case 145:
                    WCChanganOushangX70ATireAct.this.updaterRRWarn();
                    break;
                case 146:
                    ((TextView) WCChanganOushangX70ATireAct.this.findViewById(R.id.oudi_changan_tire1_top)).setText(String.valueOf(WCChanganOushangX70ATireAct.this.getResources().getString(R.string.tpms_calibration)) + ":" + (value / 10) + "." + (value % 10) + "bar");
                    break;
                case 147:
                    ((TextView) WCChanganOushangX70ATireAct.this.findViewById(R.id.oudi_changan_tire2_top)).setText(String.valueOf(WCChanganOushangX70ATireAct.this.getResources().getString(R.string.tpms_calibration)) + ":" + (value / 10) + "." + (value % 10) + "bar");
                    break;
                case 148:
                    ((TextView) WCChanganOushangX70ATireAct.this.findViewById(R.id.oudi_changan_tire3_top)).setText(String.valueOf(WCChanganOushangX70ATireAct.this.getResources().getString(R.string.tpms_calibration)) + ":" + (value / 10) + "." + (value % 10) + "bar");
                    break;
                case 149:
                    ((TextView) WCChanganOushangX70ATireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText(String.valueOf(WCChanganOushangX70ATireAct.this.getResources().getString(R.string.tpms_calibration)) + ":" + (value / 10) + "." + (value % 10) + "bar");
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
        setSelfClick((TextView) findViewById(R.id.oudi_changan_tire1_top), this);
        setSelfClick((TextView) findViewById(R.id.oudi_changan_tire2_top), this);
        setSelfClick((TextView) findViewById(R.id.oudi_changan_tire3_top), this);
        setSelfClick((TextView) findViewById(R.id.oudi_changan_tire4_top), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.oudi_changan_tire1_top /* 2131431291 */:
                int value = DataCanbus.DATA[146] + 1;
                if (value > 30) {
                    value = 20;
                }
                setCarInfo(1, value);
                break;
            case R.id.oudi_changan_tire2_top /* 2131431293 */:
                int value2 = DataCanbus.DATA[147] + 1;
                if (value2 > 30) {
                    value2 = 20;
                }
                setCarInfo(2, value2);
                break;
            case R.id.oudi_changan_tire3_top /* 2131431295 */:
                int value3 = DataCanbus.DATA[148] + 1;
                if (value3 > 30) {
                    value3 = 20;
                }
                setCarInfo(3, value3);
                break;
            case R.id.oudi_changan_tire4_top /* 2131431297 */:
                int value4 = DataCanbus.DATA[149] + 1;
                if (value4 > 30) {
                    value4 = 20;
                }
                setCarInfo(4, value4);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFLWarn() {
        int value = DataCanbus.DATA[142];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflnormal);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-1);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflalarm);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setTextColor(-65536);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFRWarn() {
        int value = DataCanbus.DATA[143];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflnormal);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-1);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflalarm);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setTextColor(-65536);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRLWarn() {
        int value = DataCanbus.DATA[144];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflnormal);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-1);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflalarm);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setTextColor(-65536);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRRWarn() {
        int value = DataCanbus.DATA[145];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflnormal);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-1);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflalarm);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setTextColor(-65536);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempFL() {
        int value = DataCanbus.DATA[128];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempFR() {
        int value = DataCanbus.DATA[129];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempRL() {
        int value = DataCanbus.DATA[130];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempRR() {
        int value = DataCanbus.DATA[131];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[124];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value * 10) + "kPa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(((value * 1000) / 6895) * 10) + "Psi");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(df.format(value / 10.0f)) + "bar");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[125];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value * 10) + "kPa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(((value * 1000) / 6895) * 10) + "Psi");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(df.format(value / 10.0f)) + "bar");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[126];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value * 10) + "kPa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(((value * 1000) / 6895) * 10) + "Psi");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(df.format(value / 10.0f)) + "bar");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[127];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value * 10) + "kPa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(((value * 1000) / 6895) * 10) + "Psi");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(df.format(value / 10.0f)) + "bar");
                    break;
            }
        }
    }
}
