package com.syu.carinfo.rzc.jianghuai;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.text.DecimalFormat;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RzcJianghuaiTireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiTireAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 20:
                    RzcJianghuaiTireAct.this.mUpdaterTireFL();
                    break;
                case 21:
                    RzcJianghuaiTireAct.this.mUpdaterTireFR();
                    break;
                case 22:
                    RzcJianghuaiTireAct.this.mUpdaterTireRL();
                    break;
                case 23:
                    RzcJianghuaiTireAct.this.mUpdaterTireRR();
                    break;
                case 24:
                    RzcJianghuaiTireAct.this.updaterTempFL();
                    break;
                case 25:
                    RzcJianghuaiTireAct.this.updaterTempFR();
                    break;
                case 26:
                    RzcJianghuaiTireAct.this.updaterTempRL();
                    break;
                case 27:
                    RzcJianghuaiTireAct.this.updaterTempRR();
                    break;
                case 28:
                    RzcJianghuaiTireAct.this.updaterFLWalm();
                    break;
                case 29:
                    RzcJianghuaiTireAct.this.updaterFRWalm();
                    break;
                case 30:
                    RzcJianghuaiTireAct.this.updaterRLWalm();
                    break;
                case 31:
                    RzcJianghuaiTireAct.this.updaterRRWalm();
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
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempFL() {
        int value = DataCanbus.DATA[24];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempFR() {
        int value = DataCanbus.DATA[25];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempRL() {
        int value = DataCanbus.DATA[26];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempRR() {
        int value = DataCanbus.DATA[27];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[20];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
            return;
        }
        int value2 = (int) (value * 274.5d);
        if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(df.format(value2 / 10000.0f)) + "bar");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[21];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
            return;
        }
        int value2 = (int) (value * 274.5d);
        if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(df.format(value2 / 10000.0f)) + "bar");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[22];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
            return;
        }
        int value2 = (int) (value * 274.5d);
        if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(df.format(value2 / 10000.0f)) + "bar");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[23];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
            return;
        }
        int value2 = (int) (value * 274.5d);
        if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(df.format(value2 / 10000.0f)) + "bar");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFLWalm() {
        int value = DataCanbus.DATA[28];
        if (DataCanbus.DATA[1000] == 6029765 || DataCanbus.DATA[1000] == 6095301) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-1);
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflnormal);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_390_lost_sensor);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.wc_damaix5_str2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflhigh);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tirefrlow);
                    break;
                case 5:
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_390_sensor_battery_low);
                    break;
                case 6:
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_390_sensor_failure);
                    break;
                case 7:
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-256);
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_272_tire_warn3);
                    break;
                case 8:
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tiretempalarm);
                    break;
                case 9:
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_wc_rfs2_3);
                    break;
                case 10:
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_wc_rfs2_2);
                    break;
                case 11:
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_wc_rfs2_1);
                    break;
            }
        }
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_272_tire_warn1);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_272_tire_warn2);
                break;
            case 3:
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setTextColor(-256);
                ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.str_272_tire_warn3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFRWalm() {
        int value = DataCanbus.DATA[29];
        if (DataCanbus.DATA[1000] == 6029765 || DataCanbus.DATA[1000] == 6095301) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-1);
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflnormal);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_390_lost_sensor);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.wc_damaix5_str2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflhigh);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tirefrlow);
                    break;
                case 5:
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_390_sensor_battery_low);
                    break;
                case 6:
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_390_sensor_failure);
                    break;
                case 7:
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-256);
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_272_tire_warn3);
                    break;
                case 8:
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tiretempalarm);
                    break;
                case 9:
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_wc_rfs2_3);
                    break;
                case 10:
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_wc_rfs2_2);
                    break;
                case 11:
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_wc_rfs2_1);
                    break;
            }
        }
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_272_tire_warn1);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_272_tire_warn2);
                break;
            case 3:
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setTextColor(-256);
                ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.str_272_tire_warn3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRLWalm() {
        int value = DataCanbus.DATA[30];
        if (DataCanbus.DATA[1000] == 6029765 || DataCanbus.DATA[1000] == 6095301) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-1);
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflnormal);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_390_lost_sensor);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.wc_damaix5_str2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflhigh);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tirefrlow);
                    break;
                case 5:
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_390_sensor_battery_low);
                    break;
                case 6:
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_390_sensor_failure);
                    break;
                case 7:
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-256);
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_272_tire_warn3);
                    break;
                case 8:
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tiretempalarm);
                    break;
                case 9:
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_wc_rfs2_3);
                    break;
                case 10:
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_wc_rfs2_2);
                    break;
                case 11:
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_wc_rfs2_1);
                    break;
            }
        }
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_272_tire_warn1);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_272_tire_warn2);
                break;
            case 3:
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setTextColor(-256);
                ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.str_272_tire_warn3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRRWalm() {
        int value = DataCanbus.DATA[31];
        if (DataCanbus.DATA[1000] == 6029765 || DataCanbus.DATA[1000] == 6095301) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-1);
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflnormal);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_390_lost_sensor);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.wc_damaix5_str2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflhigh);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tirefrlow);
                    break;
                case 5:
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_390_sensor_battery_low);
                    break;
                case 6:
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_390_sensor_failure);
                    break;
                case 7:
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-256);
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_272_tire_warn3);
                    break;
                case 8:
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tiretempalarm);
                    break;
                case 9:
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_wc_rfs2_3);
                    break;
                case 10:
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_wc_rfs2_2);
                    break;
                case 11:
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                    ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_wc_rfs2_1);
                    break;
            }
        }
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-1);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflnormal);
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_272_tire_warn1);
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-65536);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_272_tire_warn2);
                break;
            case 3:
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setTextColor(-256);
                ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.str_272_tire_warn3);
                break;
        }
    }
}
