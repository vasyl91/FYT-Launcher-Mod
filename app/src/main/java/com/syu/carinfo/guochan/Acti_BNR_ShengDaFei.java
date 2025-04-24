package com.syu.carinfo.guochan;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
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
    private int[] resIDs = {101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 98, 99};
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    Acti_BNR_ShengDaFei.this.uCurSpeed(value);
                    break;
                case 99:
                    Acti_BNR_ShengDaFei.this.uEngineSpeed(value);
                    break;
                case 101:
                    Acti_BNR_ShengDaFei.this.uSelfDetect(value);
                    break;
                case 102:
                    Acti_BNR_ShengDaFei.this.uTireFL(value);
                    break;
                case 103:
                    Acti_BNR_ShengDaFei.this.uTempFL(value);
                    break;
                case 104:
                    Acti_BNR_ShengDaFei.this.uBatteryFL(value);
                    break;
                case 105:
                    Acti_BNR_ShengDaFei.this.uWarnFL(value);
                    break;
                case 106:
                    Acti_BNR_ShengDaFei.this.uTireFR(value);
                    break;
                case 107:
                    Acti_BNR_ShengDaFei.this.uTempFR(value);
                    break;
                case 108:
                    Acti_BNR_ShengDaFei.this.uBatteryFR(value);
                    break;
                case 109:
                    Acti_BNR_ShengDaFei.this.uWarnFR(value);
                    break;
                case 110:
                    Acti_BNR_ShengDaFei.this.uTireRL(value);
                    break;
                case 111:
                    Acti_BNR_ShengDaFei.this.uTempRL(value);
                    break;
                case 112:
                    Acti_BNR_ShengDaFei.this.uBatteryRL(value);
                    break;
                case 113:
                    Acti_BNR_ShengDaFei.this.uWarnRL(value);
                    break;
                case 114:
                    Acti_BNR_ShengDaFei.this.uTireRR(value);
                    break;
                case 115:
                    Acti_BNR_ShengDaFei.this.uTempRR(value);
                    break;
                case 116:
                    Acti_BNR_ShengDaFei.this.uBatteryRR(value);
                    break;
                case 117:
                    Acti_BNR_ShengDaFei.this.uWarnRR(value);
                    break;
            }
        }
    };
    int[] resTireId = {R.string.tirefllow, R.string.tireflhigh};
    int[] resWarnId = {R.string.wc_damaix5_str7, R.string.wc_damaix5_str2, R.string.str_408_carinfo_81_1, R.string.str_focus_warm_8_7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_237_bnr_shengdafei_tire);
        init();
    }

    @Override
    public void init() {
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        for (int i = 0; i < this.resIDs.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.resIDs[i]].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override
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

    
    public void uTireRR(int value) {
        this.tireRR = value;
        TextView txt = (TextView) findViewById(R.id.zt_tv_car_tire_press_3);
        setTires(txt, value);
    }

    
    public void uTireRL(int value) {
        this.tireRL = value;
        TextView txt = (TextView) findViewById(R.id.zt_tv_car_tire_press_2);
        setTires(txt, value);
    }

    
    public void uTireFR(int value) {
        this.tireFR = value;
        TextView txt = (TextView) findViewById(R.id.zt_tv_car_tire_press_1);
        setTires(txt, value);
    }

    
    public void uWarnRR(int value) {
        this.warnRR = value;
        setWarnText((TextView) findViewById(R.id.zt_tv_car_tire_press_3), value);
        TextView txt = (TextView) findViewById(R.id.zt_tv_car_tire_press_3);
        if (this.warnRR == 0) {
            setTires(txt, this.tireRR);
        }
    }

    
    public void uWarnRL(int value) {
        this.warnRL = value;
        setWarnText((TextView) findViewById(R.id.zt_tv_car_tire_press_2), value);
        TextView txt = (TextView) findViewById(R.id.zt_tv_car_tire_press_2);
        if (this.warnRL == 0) {
            setTires(txt, this.tireRL);
        }
    }

    
    public void uWarnFR(int value) {
        this.warnFR = value;
        setWarnText((TextView) findViewById(R.id.zt_tv_car_tire_press_1), value);
        TextView txt = (TextView) findViewById(R.id.zt_tv_car_tire_press_1);
        if (this.warnFR == 0) {
            setTires(txt, this.tireFR);
        }
    }

    
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

    
    public void uBatteryRR(int value) {
        setBatteryText((TextView) findViewById(R.id.zt_tv_car_tire_battery_3), value);
    }

    
    public void uBatteryRL(int value) {
        setBatteryText((TextView) findViewById(R.id.zt_tv_car_tire_battery_2), value);
    }

    
    public void uBatteryFR(int value) {
        setBatteryText((TextView) findViewById(R.id.zt_tv_car_tire_battery_1), value);
    }

    
    public void uBatteryFL(int value) {
        setBatteryText((TextView) findViewById(R.id.zt_tv_car_tire_battery_0), value);
    }

    
    public void uTempRR(int value) {
        setTempText((TextView) findViewById(R.id.zt_tv_car_tire_temp_3), value);
    }

    
    public void uTempRL(int value) {
        setTempText((TextView) findViewById(R.id.zt_tv_car_tire_temp_2), value);
    }

    
    public void uTempFR(int value) {
        setTempText((TextView) findViewById(R.id.zt_tv_car_tire_temp_1), value);
    }

    
    public void uTempFL(int value) {
        setTempText((TextView) findViewById(R.id.zt_tv_car_tire_temp_0), value);
    }
}
