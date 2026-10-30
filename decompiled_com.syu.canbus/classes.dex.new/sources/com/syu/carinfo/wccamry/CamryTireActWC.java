package com.syu.carinfo.wccamry;

import android.os.Bundle;
import android.os.SystemProperties;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class CamryTireActWC extends BaseActivity {
    public static CamryTireActWC mInit;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wccamry.CamryTireActWC.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 132:
                    CamryTireActWC.this.mUpdaterTireWarn();
                    break;
                case 133:
                    CamryTireActWC.this.mUpdaterTireFL();
                    break;
                case 134:
                    CamryTireActWC.this.mUpdaterTireFR();
                    break;
                case 135:
                    CamryTireActWC.this.mUpdaterTireRL();
                    break;
                case 136:
                    CamryTireActWC.this.mUpdaterTireRR();
                    break;
                case 194:
                    CamryTireActWC.this.mUpdaterTempFL();
                    break;
                case 195:
                    CamryTireActWC.this.mUpdaterTempFR();
                    break;
                case 196:
                    CamryTireActWC.this.mUpdaterTempRL();
                    break;
                case 197:
                    CamryTireActWC.this.mUpdaterTempRR();
                    break;
                case 198:
                    CamryTireActWC.this.updaterTitleState();
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
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_WC2_TOYOTA_YL_15Alpha_H /* 8323366 */:
                case FinalCanbus.CAR_WC2_TOYOTA_GCG_15Alpha_H /* 8847654 */:
                    setContentView(R.layout.layout_oudi_zt_t600_tire_xuanniu);
                    break;
                default:
                    setContentView(R.layout.layout_oudi_zt_t600_tire);
                    break;
            }
        }
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        if (DataCanbus.DATA[1000] == 5767462 || DataCanbus.DATA[1000] == 5832998) {
            DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        if (DataCanbus.DATA[1000] == 5767462 || DataCanbus.DATA[1000] == 5832998) {
            DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        mInit = this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTitleState() {
        int value = DataCanbus.DATA[198];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText("----");
            return;
        }
        if (value >= 128) {
            ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText(String.valueOf(getResources().getString(R.string.str_forward_tilt)) + ": " + (value - 128));
        } else if (value >= 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText(String.valueOf(getResources().getString(R.string.str_backward_tilt)) + ": " + value);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText(new StringBuilder().append(value).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempFL() {
        int value = DataCanbus.DATA[194];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire1_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText(String.valueOf(value - 40) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempFR() {
        int value = DataCanbus.DATA[195];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire2_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText(String.valueOf(value - 40) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempRL() {
        int value = DataCanbus.DATA[196];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire3_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText(String.valueOf(value - 40) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempRR() {
        int value = DataCanbus.DATA[197];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire4_temp)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText(String.valueOf(value - 40) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[133];
        if (value == 65024) {
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
        int value = DataCanbus.DATA[134];
        if (value == 65024) {
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
        int value = DataCanbus.DATA[135];
        if (value == 65024) {
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
        int value = DataCanbus.DATA[136];
        if (value == 65024) {
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
        int value = DataCanbus.DATA[132];
        if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflalarm);
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflalarm);
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflalarm);
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflalarm);
            return;
        }
        ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tirefrnormal);
        ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tirefrnormal);
        ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tirefrnormal);
        ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tirefrnormal);
    }
}
