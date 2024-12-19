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
public class JhRuiFengS7TireAct extends BaseActivity {
    public static boolean bFront = false;
    public static boolean bNotShowingWarning = false;
    private CheckBox mCheckSetShowWarning;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.ruifengs3.JhRuiFengS7TireAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 23:
                    JhRuiFengS7TireAct.this.mUpdaterTireFL();
                    break;
                case 24:
                    JhRuiFengS7TireAct.this.mUpdaterTireFR();
                    break;
                case 25:
                    JhRuiFengS7TireAct.this.mUpdaterTireRL();
                    break;
                case 26:
                    JhRuiFengS7TireAct.this.mUpdaterTireRR();
                    break;
                case 27:
                    JhRuiFengS7TireAct.this.mUpdaterTempFL();
                    break;
                case 28:
                    JhRuiFengS7TireAct.this.mUpdaterTempFR();
                    break;
                case 29:
                    JhRuiFengS7TireAct.this.mUpdaterTempRL();
                    break;
                case 30:
                    JhRuiFengS7TireAct.this.mUpdaterTempRR();
                    break;
                case 31:
                    JhRuiFengS7TireAct.this.mUpdaterWarnFL();
                    break;
                case 32:
                    JhRuiFengS7TireAct.this.mUpdaterWarnFR();
                    break;
                case 33:
                    JhRuiFengS7TireAct.this.mUpdaterWarnRL();
                    break;
                case 34:
                    JhRuiFengS7TireAct.this.mUpdaterWarnRR();
                    break;
            }
        }
    };
    private final float VALUE = 0.02745f;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_ruifengs3);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mCheckSetShowWarning = (CheckBox) findViewById(R.id.check_setwarning_not_to_show);
        this.mCheckSetShowWarning.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.syu.carinfo.rzc.ruifengs3.JhRuiFengS7TireAct.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                JhRuiFengS7TireAct.bNotShowingWarning = isChecked;
            }
        });
    }

    boolean getShowWarningConfig() {
        SharedPreferences sp = LauncherApplication.getInstance().getSharedPreferences("0452RuiFengS7", 0);
        if (sp == null) {
            return false;
        }
        boolean b = sp.getBoolean("showwarning", false);
        return b;
    }

    void setShowWarningConfig(boolean on) {
        SharedPreferences sp = LauncherApplication.getInstance().getSharedPreferences("0452RuiFengS7", 0);
        if (sp != null) {
            sp.edit().putBoolean("showwarning", on).commit();
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        bFront = true;
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.notifyCanbus, 1);
        bNotShowingWarning = getShowWarningConfig();
        if (this.mCheckSetShowWarning != null) {
            this.mCheckSetShowWarning.setChecked(bNotShowingWarning);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        bFront = false;
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.notifyCanbus);
        setShowWarningConfig(bNotShowingWarning);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempFL() {
        int value = DataCanbus.DATA[27];
        float num = 16777215 & value;
        ((TextView) findViewById(R.id.rzc_s3_tv_car_temp_0)).setText(String.format("%d℃", Integer.valueOf((int) (num - 40.0f))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempFR() {
        int value = DataCanbus.DATA[28];
        int num = value & 16777215;
        ((TextView) findViewById(R.id.rzc_s3_tv_car_temp_1)).setText(String.format("%d℃", Integer.valueOf(num - 40)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempRL() {
        int value = DataCanbus.DATA[29];
        int num = value & 16777215;
        ((TextView) findViewById(R.id.rzc_s3_tv_car_temp_2)).setText(String.format("%d℃", Integer.valueOf(num - 40)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempRR() {
        int value = DataCanbus.DATA[30];
        int num = value & 16777215;
        ((TextView) findViewById(R.id.rzc_s3_tv_car_temp_3)).setText(String.format("%d℃", Integer.valueOf(num - 40)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[23];
        float num = 16777215 & value;
        ((TextView) findViewById(R.id.rzc_s3_tv_car_tire_0)).setText(String.format("%.1fBar", Float.valueOf(0.02745f * num)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[24];
        int num = value & 16777215;
        ((TextView) findViewById(R.id.rzc_s3_tv_car_tire_1)).setText(String.format("%.1fBar", Float.valueOf(num * 0.02745f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[25];
        int num = value & 16777215;
        ((TextView) findViewById(R.id.rzc_s3_tv_car_tire_2)).setText(String.format("%.1fBar", Float.valueOf(num * 0.02745f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[26];
        int num = value & 16777215;
        ((TextView) findViewById(R.id.rzc_s3_tv_car_tire_3)).setText(String.format("%.1fBar", Float.valueOf(num * 0.02745f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterWarnFL() {
        int value = DataCanbus.DATA[31];
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
        int value = DataCanbus.DATA[32];
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
        int value = DataCanbus.DATA[33];
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
        int value = DataCanbus.DATA[34];
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
