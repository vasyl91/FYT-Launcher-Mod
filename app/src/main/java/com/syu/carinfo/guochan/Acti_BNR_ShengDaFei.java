package com.syu.carinfo.guochan;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Acti_BNR_ShengDaFei extends BaseActivity {
    private int bitHight;
    private int bitLow;
    private int bitWarn;
    int tireFL;
    int tireFR;
    int tireRL;
    int tireRR;
    int warnFL;
    int warnFR;
    int warnRL;
    int warnRR;
    private int[] resIDs = {24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 21, 22};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.guochan.Acti_BNR_ShengDaFei.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 21:
                    Acti_BNR_ShengDaFei.this.uCurSpeed(value);
                    break;
                case 22:
                    Acti_BNR_ShengDaFei.this.uEngineSpeed(value);
                    break;
                case 24:
                    Acti_BNR_ShengDaFei.this.uSelfDetect(value);
                    break;
                case 25:
                    Acti_BNR_ShengDaFei.this.uTireFL(value);
                    break;
                case 26:
                    Acti_BNR_ShengDaFei.this.uTempFL(value);
                    break;
                case 27:
                    Acti_BNR_ShengDaFei.this.uBatteryFL(value);
                    break;
                case 28:
                    Acti_BNR_ShengDaFei.this.uWarnFL(value);
                    break;
                case 29:
                    Acti_BNR_ShengDaFei.this.uTireFR(value);
                    break;
                case 30:
                    Acti_BNR_ShengDaFei.this.uTempFR(value);
                    break;
                case 31:
                    Acti_BNR_ShengDaFei.this.uBatteryFR(value);
                    break;
                case 32:
                    Acti_BNR_ShengDaFei.this.uWarnFR(value);
                    break;
                case 33:
                    Acti_BNR_ShengDaFei.this.uTireRL(value);
                    break;
                case 34:
                    Acti_BNR_ShengDaFei.this.uTempRL(value);
                    break;
                case 35:
                    Acti_BNR_ShengDaFei.this.uBatteryRL(value);
                    break;
                case 36:
                    Acti_BNR_ShengDaFei.this.uWarnRL(value);
                    break;
                case 37:
                    Acti_BNR_ShengDaFei.this.uTireRR(value);
                    break;
                case 38:
                    Acti_BNR_ShengDaFei.this.uTempRR(value);
                    break;
                case 39:
                    Acti_BNR_ShengDaFei.this.uBatteryRR(value);
                    break;
                case 40:
                    Acti_BNR_ShengDaFei.this.uWarnRR(value);
                    break;
            }
        }
    };
    int[] resTireId = {R.string.tirefllow, R.string.tireflhigh};
    int[] resWarnId = {R.string.wc_damaix5_str7, R.string.wc_damaix5_str2, R.string.str_408_carinfo_81_1, R.string.str_focus_warm_8_7};

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_237_bnr_shengdafei_tire);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        for (int i = 0; i < this.resIDs.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.resIDs[i]].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        for (int i = 0; i < this.resIDs.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.resIDs[i]].removeNotify(this.mNotifyCanbus);
        }
    }

    private void setTxt(TextView tv, String str) {
        if (tv != null) {
            tv.setText(str);
        }
    }

    protected void uCurSpeed(int value) {
        setTxt((TextView) findViewById(R.id.zt_tv_car_curspeed), String.valueOf(value) + "km/h");
    }

    protected void uEngineSpeed(int value) {
        setTxt((TextView) findViewById(R.id.zt_tv_car_enginespeed), String.valueOf(value) + "rpm");
    }

    private void setTxt(TextView tv, int id) {
        if (tv != null) {
            if (id == -1) {
                tv.setText("");
            } else {
                tv.setText(id);
            }
        }
    }

    protected void uSelfDetect(int value) {
        int id = -1;
        if (value == 1) {
            id = R.string.wc_damaix5_str1;
        } else if (value == 2) {
            id = R.string.klc_onstar_call_alarm_status;
        }
        setTxt((TextView) findViewById(R.id.zt_tv_car_tire_state), id);
    }

    protected void uTireFL(int value) {
        this.tireFL = value;
        TextView txt = (TextView) findViewById(R.id.zt_tv_car_tire_press_0);
        setTires(txt, value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uTireRR(int value) {
        this.tireRR = value;
        TextView txt = (TextView) findViewById(R.id.zt_tv_car_tire_press_3);
        setTires(txt, value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uTireRL(int value) {
        this.tireRL = value;
        TextView txt = (TextView) findViewById(R.id.zt_tv_car_tire_press_2);
        setTires(txt, value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uTireFR(int value) {
        this.tireFR = value;
        TextView txt = (TextView) findViewById(R.id.zt_tv_car_tire_press_1);
        setTires(txt, value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uWarnRR(int value) {
        this.warnRR = value;
        setWarnText((TextView) findViewById(R.id.zt_tv_car_tire_press_3), value);
        TextView txt = (TextView) findViewById(R.id.zt_tv_car_tire_press_3);
        if (this.warnRR == 0) {
            setTires(txt, this.tireRR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uWarnRL(int value) {
        this.warnRL = value;
        setWarnText((TextView) findViewById(R.id.zt_tv_car_tire_press_2), value);
        TextView txt = (TextView) findViewById(R.id.zt_tv_car_tire_press_2);
        if (this.warnRL == 0) {
            setTires(txt, this.tireRL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uWarnFR(int value) {
        this.warnFR = value;
        setWarnText((TextView) findViewById(R.id.zt_tv_car_tire_press_1), value);
        TextView txt = (TextView) findViewById(R.id.zt_tv_car_tire_press_1);
        if (this.warnFR == 0) {
            setTires(txt, this.tireFR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uWarnFL(int value) {
        this.warnFL = value;
        setWarnText((TextView) findViewById(R.id.zt_tv_car_tire_press_0), value);
        TextView txt = (TextView) findViewById(R.id.zt_tv_car_tire_press_0);
        if (this.warnFL == 0) {
            setTires(txt, this.tireFL);
        }
    }

    private void setTires(TextView txt, int value) {
        this.bitHight = (value >> 7) & 1;
        this.bitLow = (value >> 6) & 1;
        if (this.bitHight != 0) {
            setTxt(txt, this.resTireId[1]);
            return;
        }
        if (this.bitLow != 0) {
            setTxt(txt, this.resTireId[0]);
        } else if (value >= 0 && value <= 62) {
            setTxt(txt, String.valueOf(value / 10.0f) + "Bar");
        } else {
            setTxt(txt, "--");
        }
    }

    private void setWarnText(TextView txt, int value) {
        if (txt != null) {
            this.bitWarn = value;
            if (((this.bitWarn >> 7) & 1) == 1) {
                setTxt(txt, R.string.wc_damaix5_str7);
                return;
            }
            if (((this.bitWarn >> 6) & 1) == 1) {
                setTxt(txt, R.string.wc_damaix5_str2);
                return;
            }
            if (((this.bitWarn >> 5) & 1) == 1) {
                setTxt(txt, R.string.str_408_carinfo_81_1);
            } else if (((this.bitWarn >> 4) & 1) == 1) {
                setTxt(txt, R.string.str_focus_warm_8_7);
            } else if ((this.bitWarn & 1) == 1) {
                setTxt(txt, R.string.wc_damaix5_str8);
            }
        }
    }

    private void setBatteryText(TextView txt, int value) {
        if (txt != null) {
            int value2 = value & 15;
            if (value2 >= 0 && value2 <= 5) {
                setTxt(txt, "电量:" + value2);
            } else {
                setTxt(txt, "--");
            }
        }
    }

    private void setTempText(TextView txt, int value) {
        if (txt != null) {
            if (value >= 0 && value <= 165) {
                setTxt(txt, String.valueOf(value - 40) + "℃");
            } else {
                setTxt(txt, "--");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uBatteryRR(int value) {
        setBatteryText((TextView) findViewById(R.id.zt_tv_car_tire_battery_3), value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uBatteryRL(int value) {
        setBatteryText((TextView) findViewById(R.id.zt_tv_car_tire_battery_2), value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uBatteryFR(int value) {
        setBatteryText((TextView) findViewById(R.id.zt_tv_car_tire_battery_1), value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uBatteryFL(int value) {
        setBatteryText((TextView) findViewById(R.id.zt_tv_car_tire_battery_0), value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uTempRR(int value) {
        setTempText((TextView) findViewById(R.id.zt_tv_car_tire_temp_3), value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uTempRL(int value) {
        setTempText((TextView) findViewById(R.id.zt_tv_car_tire_temp_2), value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uTempFR(int value) {
        setTempText((TextView) findViewById(R.id.zt_tv_car_tire_temp_1), value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uTempFL(int value) {
        setTempText((TextView) findViewById(R.id.zt_tv_car_tire_temp_0), value);
    }
}
