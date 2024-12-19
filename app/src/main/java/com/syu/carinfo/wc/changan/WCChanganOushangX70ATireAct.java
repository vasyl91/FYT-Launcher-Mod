package com.syu.carinfo.wc.changan;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.text.DecimalFormat;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class WCChanganOushangX70ATireAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.changan.WCChanganOushangX70ATireAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 47:
                    WCChanganOushangX70ATireAct.this.mUpdaterTireFL();
                    break;
                case 48:
                    WCChanganOushangX70ATireAct.this.mUpdaterTireFR();
                    break;
                case 49:
                    WCChanganOushangX70ATireAct.this.mUpdaterTireRL();
                    break;
                case 50:
                    WCChanganOushangX70ATireAct.this.mUpdaterTireRR();
                    break;
                case 51:
                    WCChanganOushangX70ATireAct.this.updaterTempFL();
                    break;
                case 52:
                    WCChanganOushangX70ATireAct.this.updaterTempFR();
                    break;
                case 53:
                    WCChanganOushangX70ATireAct.this.updaterTempRL();
                    break;
                case 54:
                    WCChanganOushangX70ATireAct.this.updaterTempRR();
                    break;
                case 67:
                    WCChanganOushangX70ATireAct.this.updaterFLWarn();
                    break;
                case 68:
                    WCChanganOushangX70ATireAct.this.updaterFRWarn();
                    break;
                case 69:
                    WCChanganOushangX70ATireAct.this.updaterRLWarn();
                    break;
                case 70:
                    WCChanganOushangX70ATireAct.this.updaterRRWarn();
                    break;
                case 71:
                    ((TextView) WCChanganOushangX70ATireAct.this.findViewById(R.id.oudi_changan_tire1_top)).setText(String.valueOf(WCChanganOushangX70ATireAct.this.getResources().getString(R.string.tpms_calibration)) + ":" + (value / 10) + "." + (value % 10) + "bar");
                    break;
                case 72:
                    ((TextView) WCChanganOushangX70ATireAct.this.findViewById(R.id.oudi_changan_tire2_top)).setText(String.valueOf(WCChanganOushangX70ATireAct.this.getResources().getString(R.string.tpms_calibration)) + ":" + (value / 10) + "." + (value % 10) + "bar");
                    break;
                case 73:
                    ((TextView) WCChanganOushangX70ATireAct.this.findViewById(R.id.oudi_changan_tire3_top)).setText(String.valueOf(WCChanganOushangX70ATireAct.this.getResources().getString(R.string.tpms_calibration)) + ":" + (value / 10) + "." + (value % 10) + "bar");
                    break;
                case 74:
                    ((TextView) WCChanganOushangX70ATireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText(String.valueOf(WCChanganOushangX70ATireAct.this.getResources().getString(R.string.tpms_calibration)) + ":" + (value / 10) + "." + (value % 10) + "bar");
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
        setSelfClick((TextView) findViewById(R.id.oudi_changan_tire1_top), this);
        setSelfClick((TextView) findViewById(R.id.oudi_changan_tire2_top), this);
        setSelfClick((TextView) findViewById(R.id.oudi_changan_tire3_top), this);
        setSelfClick((TextView) findViewById(R.id.oudi_changan_tire4_top), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.oudi_changan_tire1_top /* 2131432159 */:
                int value = DataCanbus.DATA[71] + 1;
                if (value > 30) {
                    value = 20;
                }
                setCarInfo(1, value);
                break;
            case R.id.oudi_changan_tire2_top /* 2131432161 */:
                int value2 = DataCanbus.DATA[72] + 1;
                if (value2 > 30) {
                    value2 = 20;
                }
                setCarInfo(2, value2);
                break;
            case R.id.oudi_changan_tire3_top /* 2131432163 */:
                int value3 = DataCanbus.DATA[73] + 1;
                if (value3 > 30) {
                    value3 = 20;
                }
                setCarInfo(3, value3);
                break;
            case R.id.oudi_changan_tire4_top /* 2131432165 */:
                int value4 = DataCanbus.DATA[74] + 1;
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
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[74].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[71].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[74].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFLWarn() {
        int value = DataCanbus.DATA[67];
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
        int value = DataCanbus.DATA[68];
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
        int value = DataCanbus.DATA[69];
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
        int value = DataCanbus.DATA[70];
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
        int value = DataCanbus.DATA[51];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempFR() {
        int value = DataCanbus.DATA[52];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempRL() {
        int value = DataCanbus.DATA[53];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempRR() {
        int value = DataCanbus.DATA[54];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[47];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(df.format(value / 10.0f)) + "bar");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[48];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(df.format(value / 10.0f)) + "bar");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[49];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(df.format(value / 10.0f)) + "bar");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[50];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(df.format(value / 10.0f)) + "bar");
        }
    }
}
