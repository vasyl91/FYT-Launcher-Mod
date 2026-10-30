package com.syu.carinfo.wc.ziyouguang;

import android.os.Bundle;
import android.os.SystemProperties;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Wc_372_TireAct extends BaseActivity {
    public static Wc_372_TireAct mInit;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_TireAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 212:
                    Wc_372_TireAct.this.mUpdaterTireWarn();
                    break;
                case 213:
                    Wc_372_TireAct.this.mUpdaterTireFL();
                    break;
                case 214:
                    Wc_372_TireAct.this.mUpdaterTireFR();
                    break;
                case 215:
                    Wc_372_TireAct.this.mUpdaterTireRL();
                    break;
                case 216:
                    Wc_372_TireAct.this.mUpdaterTireRR();
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
        DataCanbus.NOTIFY_EVENTS[213].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[214].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[215].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[216].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[212].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[213].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[214].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[215].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[216].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[212].removeNotify(this.mNotifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        mInit = this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[213];
        if (value == 254) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("---");
        }
        int temp = (value / 256) + (value % 256);
        int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
        switch (TireUnit) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(temp) + "kPa");
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf((temp * 1000) / 6895) + "Psi");
                break;
            case 2:
                int temp2 = temp / 10;
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(temp2 / 10) + "." + (temp2 % 10) + "bar");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[214];
        if (value == 254) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("---");
        }
        int temp = (value / 256) + (value % 256);
        int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
        switch (TireUnit) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(temp) + "kPa");
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf((temp * 1000) / 6895) + "Psi");
                break;
            case 2:
                int temp2 = temp / 10;
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(temp2 / 10) + "." + (temp2 % 10) + "bar");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[215];
        if (value == 254) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("---");
        }
        int temp = (value / 256) + (value % 256);
        int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
        switch (TireUnit) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(temp) + "kPa");
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf((temp * 1000) / 6895) + "Psi");
                break;
            case 2:
                int temp2 = temp / 10;
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(temp2 / 10) + "." + (temp2 % 10) + "bar");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[216];
        if (value == 254) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("---");
        }
        int temp = (value / 256) + (value % 256);
        int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
        switch (TireUnit) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(temp) + "kPa");
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf((temp * 1000) / 6895) + "Psi");
                break;
            case 2:
                int temp2 = temp / 10;
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(temp2 / 10) + "." + (temp2 % 10) + "bar");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireWarn() {
        int value = DataCanbus.DATA[212];
        if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflalarm);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflalarm);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflalarm);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflalarm);
            return;
        }
        ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-1);
        ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tirefrnormal);
        ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tirefrnormal);
        ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tirefrnormal);
        ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tirefrnormal);
    }
}
