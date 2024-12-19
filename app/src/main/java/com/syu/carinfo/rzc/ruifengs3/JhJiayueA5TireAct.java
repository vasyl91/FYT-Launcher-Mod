package com.syu.carinfo.rzc.ruifengs3;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class JhJiayueA5TireAct extends BaseActivity {
    public static boolean bFront = false;
    public static boolean bNotShowingWarning = false;
    private CheckBox mCheckSetShowWarning;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.ruifengs3.JhJiayueA5TireAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 86:
                    JhJiayueA5TireAct.this.mUpdaterTireFL();
                    break;
                case 87:
                    JhJiayueA5TireAct.this.mUpdaterTireFR();
                    break;
                case 88:
                    JhJiayueA5TireAct.this.mUpdaterTireRL();
                    break;
                case 89:
                    JhJiayueA5TireAct.this.mUpdaterTireRR();
                    break;
                case 90:
                    JhJiayueA5TireAct.this.mUpdaterTempFL();
                    break;
                case 91:
                    JhJiayueA5TireAct.this.mUpdaterTempFR();
                    break;
                case 92:
                    JhJiayueA5TireAct.this.mUpdaterTempRL();
                    break;
                case 93:
                    JhJiayueA5TireAct.this.mUpdaterTempRR();
                    break;
                case 94:
                    JhJiayueA5TireAct.this.mUpdaterWarnFL();
                    break;
                case 95:
                    JhJiayueA5TireAct.this.mUpdaterWarnFR();
                    break;
                case 96:
                    JhJiayueA5TireAct.this.mUpdaterWarnRL();
                    break;
                case 97:
                    JhJiayueA5TireAct.this.mUpdaterWarnRR();
                    break;
            }
        }
    };
    private final float VALUE = 1.373f;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_ruifengs3);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mCheckSetShowWarning = (CheckBox) findViewById(R.id.check_setwarning_not_to_show);
        this.mCheckSetShowWarning.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.syu.carinfo.rzc.ruifengs3.JhJiayueA5TireAct.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                JhJiayueA5TireAct.bNotShowingWarning = isChecked;
            }
        });
    }

    boolean getShowWarningConfig() {
        SharedPreferences sp = LauncherApplication.getInstance().getSharedPreferences("0453JiayueA5", 0);
        if (sp == null) {
            return false;
        }
        boolean b = sp.getBoolean("showwarning", false);
        return b;
    }

    void setShowWarningConfig(boolean on) {
        SharedPreferences sp = LauncherApplication.getInstance().getSharedPreferences("0453JiayueA5", 0);
        if (sp != null) {
            sp.edit().putBoolean("showwarning", on).commit();
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        bFront = true;
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.notifyCanbus, 1);
        bNotShowingWarning = getShowWarningConfig();
        if (this.mCheckSetShowWarning != null) {
            this.mCheckSetShowWarning.setChecked(bNotShowingWarning);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        bFront = false;
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.notifyCanbus);
        setShowWarningConfig(bNotShowingWarning);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempFL() {
        int value = DataCanbus.DATA[90];
        float num = 16777215 & value;
        ((TextView) findViewById(R.id.rzc_s3_tv_car_temp_0)).setText(String.format("%d℃", Integer.valueOf((int) (num - 50.0f))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempFR() {
        int value = DataCanbus.DATA[91];
        int num = value & 16777215;
        ((TextView) findViewById(R.id.rzc_s3_tv_car_temp_1)).setText(String.format("%d℃", Integer.valueOf(num - 50)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempRL() {
        int value = DataCanbus.DATA[92];
        int num = value & 16777215;
        ((TextView) findViewById(R.id.rzc_s3_tv_car_temp_2)).setText(String.format("%d℃", Integer.valueOf(num - 50)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempRR() {
        int value = DataCanbus.DATA[93];
        int num = value & 16777215;
        ((TextView) findViewById(R.id.rzc_s3_tv_car_temp_3)).setText(String.format("%d℃", Integer.valueOf(num - 50)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[86];
        float num = 16777215 & value;
        ((TextView) findViewById(R.id.rzc_s3_tv_car_tire_0)).setText(String.format("%.1fKPA", Float.valueOf(1.373f * num)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[87];
        int num = value & 16777215;
        ((TextView) findViewById(R.id.rzc_s3_tv_car_tire_1)).setText(String.format("%.1fKPA", Float.valueOf(num * 1.373f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[88];
        int num = value & 16777215;
        ((TextView) findViewById(R.id.rzc_s3_tv_car_tire_2)).setText(String.format("%.1fKPA", Float.valueOf(num * 1.373f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[89];
        int num = value & 16777215;
        ((TextView) findViewById(R.id.rzc_s3_tv_car_tire_3)).setText(String.format("%.1fKPA", Float.valueOf(num * 1.373f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterWarnFL() {
        int value = DataCanbus.DATA[94];
        if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText("");
            return;
        }
        if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.str_272_tire_warn1);
        } else if (value == 2) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.str_272_tire_warn2);
        } else if (value == 3) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setTextColor(-256);
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.str_272_tire_warn3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterWarnFR() {
        int value = DataCanbus.DATA[95];
        if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText("");
            return;
        }
        if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.str_272_tire_warn1);
        } else if (value == 2) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.str_272_tire_warn2);
        } else if (value == 3) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setTextColor(-256);
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.str_272_tire_warn3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterWarnRL() {
        int value = DataCanbus.DATA[96];
        if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText("");
            return;
        }
        if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.str_272_tire_warn1);
        } else if (value == 2) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.str_272_tire_warn2);
        } else if (value == 3) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setTextColor(-256);
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.str_272_tire_warn3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterWarnRR() {
        int value = DataCanbus.DATA[97];
        if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText("");
            return;
        }
        if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.str_272_tire_warn1);
        } else if (value == 2) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.str_272_tire_warn2);
        } else if (value == 3) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setTextColor(-256);
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.str_272_tire_warn3);
        }
    }
}
