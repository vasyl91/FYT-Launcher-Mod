package com.syu.carinfo.rzc.ruifengs3;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class JhJiayueA5TireAct extends BaseActivity {
    public static boolean bFront = false;
    public static boolean bNotShowingWarning = false;
    private CheckBox mCheckSetShowWarning;
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    JhJiayueA5TireAct.this.mUpdaterTireFL();
                    break;
                case 99:
                    JhJiayueA5TireAct.this.mUpdaterTireFR();
                    break;
                case 100:
                    JhJiayueA5TireAct.this.mUpdaterTireRL();
                    break;
                case 101:
                    JhJiayueA5TireAct.this.mUpdaterTireRR();
                    break;
                case 102:
                    JhJiayueA5TireAct.this.mUpdaterTempFL();
                    break;
                case 103:
                    JhJiayueA5TireAct.this.mUpdaterTempFR();
                    break;
                case 104:
                    JhJiayueA5TireAct.this.mUpdaterTempRL();
                    break;
                case 105:
                    JhJiayueA5TireAct.this.mUpdaterTempRR();
                    break;
                case 106:
                    JhJiayueA5TireAct.this.mUpdaterWarnFL();
                    break;
                case 107:
                    JhJiayueA5TireAct.this.mUpdaterWarnFR();
                    break;
                case 108:
                    JhJiayueA5TireAct.this.mUpdaterWarnRL();
                    break;
                case 109:
                    JhJiayueA5TireAct.this.mUpdaterWarnRR();
                    break;
            }
        }
    };
    private final float VALUE = 1.373f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_ruifengs3);
        init();
    }

    @Override
    public void init() {
        this.mCheckSetShowWarning = (CheckBox) findViewById(R.id.check_setwarning_not_to_show);
        this.mCheckSetShowWarning.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { 
            @Override
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

    @Override
    public void addNotify() {
        bFront = true;
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
        bNotShowingWarning = getShowWarningConfig();
        if (this.mCheckSetShowWarning != null) {
            this.mCheckSetShowWarning.setChecked(bNotShowingWarning);
        }
    }

    @Override
    public void removeNotify() {
        bFront = false;
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
        setShowWarningConfig(bNotShowingWarning);
    }

    
    public void mUpdaterTempFL() {
        int value = DataCanbus.DATA[102];
        float num = 16777215 & value;
        ((TextView) findViewById(R.id.rzc_s3_tv_car_temp_0)).setText(String.format("%d℃", Integer.valueOf((int) (num - 50.0f))));
    }

    
    public void mUpdaterTempFR() {
        int value = DataCanbus.DATA[103];
        int num = value & 16777215;
        ((TextView) findViewById(R.id.rzc_s3_tv_car_temp_1)).setText(String.format("%d℃", Integer.valueOf(num - 50)));
    }

    
    public void mUpdaterTempRL() {
        int value = DataCanbus.DATA[104];
        int num = value & 16777215;
        ((TextView) findViewById(R.id.rzc_s3_tv_car_temp_2)).setText(String.format("%d℃", Integer.valueOf(num - 50)));
    }

    
    public void mUpdaterTempRR() {
        int value = DataCanbus.DATA[105];
        int num = value & 16777215;
        ((TextView) findViewById(R.id.rzc_s3_tv_car_temp_3)).setText(String.format("%d℃", Integer.valueOf(num - 50)));
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[98];
        float num = 16777215 & value;
        ((TextView) findViewById(R.id.rzc_s3_tv_car_tire_0)).setText(String.format("%.1fKPA", Float.valueOf(1.373f * num)));
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[99];
        int num = value & 16777215;
        ((TextView) findViewById(R.id.rzc_s3_tv_car_tire_1)).setText(String.format("%.1fKPA", Float.valueOf(num * 1.373f)));
    }

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[100];
        int num = value & 16777215;
        ((TextView) findViewById(R.id.rzc_s3_tv_car_tire_2)).setText(String.format("%.1fKPA", Float.valueOf(num * 1.373f)));
    }

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[101];
        int num = value & 16777215;
        ((TextView) findViewById(R.id.rzc_s3_tv_car_tire_3)).setText(String.format("%.1fKPA", Float.valueOf(num * 1.373f)));
    }

    
    public void mUpdaterWarnFL() {
        int value = DataCanbus.DATA[106];
        if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.str_272_tire_warn1);
        } else if (value == 2) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.str_272_tire_warn2);
        } else if (value == 3) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setTextColor(-256);
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.str_272_tire_warn3);
        }
        ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setTextColor(-256);
        ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.str_272_tire_warn3);
    }

    
    public void mUpdaterWarnFR() {
        int value = DataCanbus.DATA[107];
        if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.str_272_tire_warn1);
        } else if (value == 2) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.str_272_tire_warn2);
        } else if (value == 3) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setTextColor(-256);
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.str_272_tire_warn3);
        }
        ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setTextColor(-256);
        ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.str_272_tire_warn3);
    }

    
    public void mUpdaterWarnRL() {
        int value = DataCanbus.DATA[108];
        if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.str_272_tire_warn1);
        } else if (value == 2) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.str_272_tire_warn2);
        } else if (value == 3) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setTextColor(-256);
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.str_272_tire_warn3);
        }
        ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setTextColor(-256);
        ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.str_272_tire_warn3);
    }

    
    public void mUpdaterWarnRR() {
        int value = DataCanbus.DATA[109];
        if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.str_272_tire_warn1);
        } else if (value == 2) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setTextColor(-65536);
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.str_272_tire_warn2);
        } else if (value == 3) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setTextColor(-256);
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.str_272_tire_warn3);
        }
        ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setTextColor(-256);
        ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.str_272_tire_warn3);
    }
}
