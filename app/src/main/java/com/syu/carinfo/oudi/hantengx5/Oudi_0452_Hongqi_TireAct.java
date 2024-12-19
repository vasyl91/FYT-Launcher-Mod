package com.syu.carinfo.oudi.hantengx5;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Oudi_0452_Hongqi_TireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.oudi.hantengx5.Oudi_0452_Hongqi_TireAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 18:
                    Oudi_0452_Hongqi_TireAct.this.mUpdaterTireFL();
                    break;
                case 19:
                    Oudi_0452_Hongqi_TireAct.this.mUpdaterTireFR();
                    break;
                case 20:
                    Oudi_0452_Hongqi_TireAct.this.mUpdaterTireRL();
                    break;
                case 21:
                    Oudi_0452_Hongqi_TireAct.this.mUpdaterTireRR();
                    break;
                case 22:
                    Oudi_0452_Hongqi_TireAct.this.updaterTempFL();
                    break;
                case 23:
                    Oudi_0452_Hongqi_TireAct.this.updaterTempFR();
                    break;
                case 24:
                    Oudi_0452_Hongqi_TireAct.this.updaterTempRL();
                    break;
                case 25:
                    Oudi_0452_Hongqi_TireAct.this.updaterTempRR();
                    break;
                case 26:
                    Oudi_0452_Hongqi_TireAct.this.updaterFlTipWalm();
                    break;
                case 27:
                    Oudi_0452_Hongqi_TireAct.this.updaterFlLowWalm();
                    break;
                case 28:
                    Oudi_0452_Hongqi_TireAct.this.updaterFlHighWalm();
                    break;
                case 29:
                    Oudi_0452_Hongqi_TireAct.this.updaterFRlowWalm();
                    break;
                case 30:
                    Oudi_0452_Hongqi_TireAct.this.updaterFRTipWalm();
                    break;
                case 31:
                    Oudi_0452_Hongqi_TireAct.this.updaterFRHighWalm();
                    break;
                case 32:
                    Oudi_0452_Hongqi_TireAct.this.updaterRRTipWalm();
                    break;
                case 33:
                    Oudi_0452_Hongqi_TireAct.this.updaterRRLowWalm();
                    break;
                case 34:
                    Oudi_0452_Hongqi_TireAct.this.updaterRRHighWalm();
                    break;
                case 35:
                    Oudi_0452_Hongqi_TireAct.this.updaterRLTipWalm();
                    break;
                case 36:
                    Oudi_0452_Hongqi_TireAct.this.updaterRLLowWalm();
                    break;
                case 37:
                    Oudi_0452_Hongqi_TireAct.this.updaterRLHighWalm();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_zt_t600_tire);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(2, new int[]{56}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{57}, null, null);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempFL() {
        String str;
        int value = DataCanbus.DATA[22];
        if (value == 255) {
            str = "--";
        } else {
            str = String.valueOf(value - 40) + "℃";
        }
        ((TextView) findViewById(R.id.zt_tv_car_tire_temp_0)).setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempFR() {
        String str;
        int value = DataCanbus.DATA[23];
        if (value == 255) {
            str = "--";
        } else {
            str = String.valueOf(value - 40) + "℃";
        }
        ((TextView) findViewById(R.id.zt_tv_car_tire_temp_1)).setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempRL() {
        String str;
        int value = DataCanbus.DATA[24];
        if (value == 255) {
            str = "--";
        } else {
            str = String.valueOf(value - 40) + "℃";
        }
        ((TextView) findViewById(R.id.zt_tv_car_tire_temp_2)).setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempRR() {
        String str;
        int value = DataCanbus.DATA[25];
        if (value == 255) {
            str = "--";
        } else {
            str = String.valueOf(value - 40) + "℃";
        }
        ((TextView) findViewById(R.id.zt_tv_car_tire_temp_3)).setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[18] & 65535;
        if (value == 255) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_0)).setText("--.--");
        } else if (((TextView) findViewById(R.id.zt_tv_car_tire_press_0)) != null) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_0)).setText(String.valueOf(value / 10.0f) + "bar");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFlHighWalm() {
        int value = DataCanbus.DATA[28];
        if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.xp_yinglang_tire_str01);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFlLowWalm() {
        int value = DataCanbus.DATA[27];
        if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFlTipWalm() {
        int value = DataCanbus.DATA[26];
        if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.zt_t600_car_chuanganqi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[19] & 65535;
        if (value == 255) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_1)).setText("--.--");
        } else if (((TextView) findViewById(R.id.zt_tv_car_tire_press_1)) != null) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_1)).setText(String.valueOf(value / 10.0f) + "bar");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFRHighWalm() {
        int value = DataCanbus.DATA[31];
        if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.xp_yinglang_tire_str01);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFRlowWalm() {
        int value = DataCanbus.DATA[30];
        if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFRTipWalm() {
        int value = DataCanbus.DATA[29];
        if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.zt_t600_car_chuanganqi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[20] & 65535;
        if (value == 255) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_2)).setText("--.--");
        } else if (((TextView) findViewById(R.id.zt_tv_car_tire_press_2)) != null) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_2)).setText(String.valueOf(value / 10.0f) + "bar");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRLHighWalm() {
        int value = DataCanbus.DATA[37];
        if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.xp_yinglang_tire_str01);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRLLowWalm() {
        int value = DataCanbus.DATA[36];
        if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRLTipWalm() {
        int value = DataCanbus.DATA[35];
        if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.zt_t600_car_chuanganqi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[21] & 65535;
        if (value == 255) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_3)).setText("--.--");
        } else if (((TextView) findViewById(R.id.zt_tv_car_tire_press_3)) != null) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_3)).setText(String.valueOf(value / 10.0f) + "bar");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRRHighWalm() {
        int value = DataCanbus.DATA[34];
        if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.xp_yinglang_tire_str01);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRRLowWalm() {
        int value = DataCanbus.DATA[33];
        if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRRTipWalm() {
        int value = DataCanbus.DATA[32];
        if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.zt_t600_car_chuanganqi);
        }
    }
}
