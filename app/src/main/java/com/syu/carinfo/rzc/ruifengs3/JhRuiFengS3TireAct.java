package com.syu.carinfo.rzc.ruifengs3;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class JhRuiFengS3TireAct extends BaseActivity {
    public static boolean bFront = false;
    public static boolean bNotShowingWarning = false;
    private CheckBox mCheckSetShowWarning;
    public View mLayoutNone;
    public View mLayoutTrieCar;
    public View mLayoutTrieLine;
    public TextView mTvCarTemp0;
    public TextView mTvCarTemp1;
    public TextView mTvCarTemp2;
    public TextView mTvCarTemp3;
    public TextView mTvCarTire0;
    public TextView mTvCarTire1;
    public TextView mTvCarTire2;
    public TextView mTvCarTire3;
    public TextView mTvCarWarn0;
    public TextView mTvCarWarn1;
    public TextView mTvCarWarn2;
    public TextView mTvCarWarn3;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.ruifengs3.JhRuiFengS3TireAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 1:
                    JhRuiFengS3TireAct.this.mUpdaterTireFL();
                    break;
                case 2:
                    JhRuiFengS3TireAct.this.mUpdaterTireFR();
                    break;
                case 3:
                    JhRuiFengS3TireAct.this.mUpdaterTireRL();
                    break;
                case 4:
                    JhRuiFengS3TireAct.this.mUpdaterTireRR();
                    break;
                case 5:
                    JhRuiFengS3TireAct.this.mUpdaterTempFL();
                    break;
                case 6:
                    JhRuiFengS3TireAct.this.mUpdaterTempFR();
                    break;
                case 7:
                    JhRuiFengS3TireAct.this.mUpdaterTempRL();
                    break;
                case 8:
                    JhRuiFengS3TireAct.this.mUpdaterTempRR();
                    break;
                case 9:
                    JhRuiFengS3TireAct.this.mUpdaterWarnFL();
                    break;
                case 10:
                    JhRuiFengS3TireAct.this.mUpdaterWarnFR();
                    break;
                case 11:
                    JhRuiFengS3TireAct.this.mUpdaterWarnRL();
                    break;
                case 12:
                    JhRuiFengS3TireAct.this.mUpdaterWarnRR();
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
        this.mLayoutTrieCar = findViewById(R.id.rzc_s3_layout_car);
        this.mTvCarTemp0 = (TextView) findViewById(R.id.rzc_s3_tv_car_temp_0);
        this.mTvCarTemp1 = (TextView) findViewById(R.id.rzc_s3_tv_car_temp_1);
        this.mTvCarTemp2 = (TextView) findViewById(R.id.rzc_s3_tv_car_temp_2);
        this.mTvCarTemp3 = (TextView) findViewById(R.id.rzc_s3_tv_car_temp_3);
        this.mTvCarTire0 = (TextView) findViewById(R.id.rzc_s3_tv_car_tire_0);
        this.mTvCarTire1 = (TextView) findViewById(R.id.rzc_s3_tv_car_tire_1);
        this.mTvCarTire2 = (TextView) findViewById(R.id.rzc_s3_tv_car_tire_2);
        this.mTvCarTire3 = (TextView) findViewById(R.id.rzc_s3_tv_car_tire_3);
        this.mTvCarWarn0 = (TextView) findViewById(R.id.zt_tv_car_tire_0_warn);
        this.mTvCarWarn1 = (TextView) findViewById(R.id.zt_tv_car_tire_1_warn);
        this.mTvCarWarn2 = (TextView) findViewById(R.id.zt_tv_car_tire_2_warn);
        this.mTvCarWarn3 = (TextView) findViewById(R.id.zt_tv_car_tire_3_warn);
        this.mCheckSetShowWarning = (CheckBox) findViewById(R.id.check_setwarning_not_to_show);
        this.mCheckSetShowWarning.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.syu.carinfo.rzc.ruifengs3.JhRuiFengS3TireAct.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                JhRuiFengS3TireAct.bNotShowingWarning = isChecked;
            }
        });
    }

    boolean getShowWarningConfig() {
        SharedPreferences sp = LauncherApplication.getInstance().getSharedPreferences("0272RuiFengS3", 0);
        if (sp == null) {
            return false;
        }
        boolean b = sp.getBoolean("showwarning", false);
        return b;
    }

    void setShowWarningConfig(boolean on) {
        SharedPreferences sp = LauncherApplication.getInstance().getSharedPreferences("0272RuiFengS3", 0);
        if (sp != null) {
            sp.edit().putBoolean("showwarning", on).commit();
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        bFront = true;
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.notifyCanbus, 1);
        bNotShowingWarning = getShowWarningConfig();
        if (this.mCheckSetShowWarning != null) {
            this.mCheckSetShowWarning.setChecked(bNotShowingWarning);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        bFront = false;
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.notifyCanbus);
        setShowWarningConfig(bNotShowingWarning);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempFL() {
        int value = DataCanbus.DATA[5];
        float num = 16777215 & value;
        this.mTvCarTemp0.setText(String.format("%d℃", Integer.valueOf((int) (num - 40.0f))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempFR() {
        int value = DataCanbus.DATA[6];
        int num = value & 16777215;
        this.mTvCarTemp1.setText(String.format("%d℃", Integer.valueOf(num - 40)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempRL() {
        int value = DataCanbus.DATA[7];
        int num = value & 16777215;
        this.mTvCarTemp2.setText(String.format("%d℃", Integer.valueOf(num - 40)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempRR() {
        int value = DataCanbus.DATA[8];
        int num = value & 16777215;
        this.mTvCarTemp3.setText(String.format("%d℃", Integer.valueOf(num - 40)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[1];
        float num = 16777215 & value;
        this.mTvCarTire0.setText(String.format("%.1fBar", Float.valueOf(0.02745f * num)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[2];
        int num = value & 16777215;
        this.mTvCarTire1.setText(String.format("%.1fBar", Float.valueOf(num * 0.02745f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[3];
        int num = value & 16777215;
        this.mTvCarTire2.setText(String.format("%.1fBar", Float.valueOf(num * 0.02745f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[4];
        int num = value & 16777215;
        this.mTvCarTire3.setText(String.format("%.1fBar", Float.valueOf(num * 0.02745f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterWarnFL() {
        int value = DataCanbus.DATA[9];
        if (value != 0) {
            if (value == 1) {
                this.mTvCarWarn0.setTextColor(-65536);
                this.mTvCarWarn0.setText(R.string.str_272_tire_warn1);
                return;
            } else if (value == 2) {
                this.mTvCarWarn0.setTextColor(-65536);
                this.mTvCarWarn0.setText(R.string.str_272_tire_warn2);
                return;
            } else {
                if (value == 3) {
                    this.mTvCarWarn0.setTextColor(-256);
                    this.mTvCarWarn0.setText(R.string.str_272_tire_warn3);
                    return;
                }
                return;
            }
        }
        this.mTvCarWarn0.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterWarnFR() {
        int value = DataCanbus.DATA[10];
        if (value != 0) {
            if (value == 1) {
                this.mTvCarWarn1.setTextColor(-65536);
                this.mTvCarWarn1.setText(R.string.str_272_tire_warn1);
                return;
            } else if (value == 2) {
                this.mTvCarWarn1.setTextColor(-65536);
                this.mTvCarWarn1.setText(R.string.str_272_tire_warn2);
                return;
            } else {
                if (value == 3) {
                    this.mTvCarWarn1.setTextColor(-256);
                    this.mTvCarWarn1.setText(R.string.str_272_tire_warn3);
                    return;
                }
                return;
            }
        }
        this.mTvCarWarn1.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterWarnRL() {
        int value = DataCanbus.DATA[11];
        if (value != 0) {
            if (value == 1) {
                this.mTvCarWarn2.setTextColor(-65536);
                this.mTvCarWarn2.setText(R.string.str_272_tire_warn1);
                return;
            } else if (value == 2) {
                this.mTvCarWarn2.setTextColor(-65536);
                this.mTvCarWarn2.setText(R.string.str_272_tire_warn2);
                return;
            } else {
                if (value == 3) {
                    this.mTvCarWarn2.setTextColor(-256);
                    this.mTvCarWarn2.setText(R.string.str_272_tire_warn3);
                    return;
                }
                return;
            }
        }
        this.mTvCarWarn2.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterWarnRR() {
        int value = DataCanbus.DATA[12];
        if (value != 0) {
            if (value == 1) {
                this.mTvCarWarn3.setTextColor(-65536);
                this.mTvCarWarn3.setText(R.string.str_272_tire_warn1);
                return;
            } else if (value == 2) {
                this.mTvCarWarn3.setTextColor(-65536);
                this.mTvCarWarn3.setText(R.string.str_272_tire_warn2);
                return;
            } else {
                if (value == 3) {
                    this.mTvCarWarn3.setTextColor(-256);
                    this.mTvCarWarn3.setText(R.string.str_272_tire_warn3);
                    return;
                }
                return;
            }
        }
        this.mTvCarWarn3.setText("");
    }
}
