package com.syu.carinfo.bnr.guanzhi;

import android.os.Bundle;
import android.os.SystemProperties;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class BnrGuanzhiTireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.bnr.guanzhi.BnrGuanzhiTireAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 110:
                    BnrGuanzhiTireAct.this.mUpdaterTireFL();
                    break;
                case 111:
                    BnrGuanzhiTireAct.this.mUpdaterTireFR();
                    break;
                case 112:
                    BnrGuanzhiTireAct.this.mUpdaterTireRL();
                    break;
                case 113:
                    BnrGuanzhiTireAct.this.mUpdaterTireRR();
                    break;
                case 114:
                    BnrGuanzhiTireAct.this.updaterFLWarn();
                    break;
                case 115:
                    BnrGuanzhiTireAct.this.updaterFRWarn();
                    break;
                case 116:
                    BnrGuanzhiTireAct.this.updaterRLWarn();
                    break;
                case 117:
                    BnrGuanzhiTireAct.this.updaterRRWarn();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bnr_guanzhi_tire);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        findViewById(R.id.btn_bnr_tire_reset).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bnr.guanzhi.BnrGuanzhiTireAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{9, 1}, null, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFLWarn() {
        int value = DataCanbus.DATA[114];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.xp_yinglang_tire_str01);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.xp_yinglang_tire_str02);
                break;
            case 3:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.zt_t600_car_chuanganqi);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFRWarn() {
        int value = DataCanbus.DATA[115];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.xp_yinglang_tire_str01);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.xp_yinglang_tire_str02);
                break;
            case 3:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.zt_t600_car_chuanganqi);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRLWarn() {
        int value = DataCanbus.DATA[116];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.xp_yinglang_tire_str01);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.xp_yinglang_tire_str02);
                break;
            case 3:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.zt_t600_car_chuanganqi);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRRWarn() {
        int value = DataCanbus.DATA[117];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.xp_yinglang_tire_str01);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.xp_yinglang_tire_str02);
                break;
            case 3:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.zt_t600_car_chuanganqi);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[110];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
        }
        int value2 = (int) (((double) value) * 137.3d);
        if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(df.format(value2 / 100.0f)) + "Kpa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(df.format(((value2 * 1000) / 6895) / 100.0f)) + "Psi");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(df.format(value2 / 10000.0f)) + "bar");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[111];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
        }
        int value2 = (int) (((double) value) * 137.3d);
        if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(df.format(value2 / 100.0f)) + "Kpa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(df.format(((value2 * 1000) / 6895) / 100.0f)) + "Psi");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(df.format(value2 / 10000.0f)) + "bar");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[112];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
        }
        int value2 = (int) (((double) value) * 137.3d);
        if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(df.format(value2 / 100.0f)) + "Kpa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(df.format(((value2 * 1000) / 6895) / 100.0f)) + "Psi");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(df.format(value2 / 10000.0f)) + "bar");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[113];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
        }
        int value2 = (int) (((double) value) * 137.3d);
        if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            int TireUnit = SystemProperties.getInt("persist.syu.reversetaiya", 0);
            switch (TireUnit) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(df.format(value2 / 100.0f)) + "Kpa");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(df.format(((value2 * 1000) / 6895) / 100.0f)) + "Psi");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(df.format(value2 / 10000.0f)) + "bar");
                    break;
            }
        }
    }
}
