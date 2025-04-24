package com.syu.carinfo.oudi.hantengx5;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Oudi_0452_Hongqi_TireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    Oudi_0452_Hongqi_TireAct.this.mUpdaterTireFL();
                    break;
                case 99:
                    Oudi_0452_Hongqi_TireAct.this.mUpdaterTireFR();
                    break;
                case 100:
                    Oudi_0452_Hongqi_TireAct.this.mUpdaterTireRL();
                    break;
                case 101:
                    Oudi_0452_Hongqi_TireAct.this.mUpdaterTireRR();
                    break;
                case 102:
                    Oudi_0452_Hongqi_TireAct.this.updaterTempFL();
                    break;
                case 103:
                    Oudi_0452_Hongqi_TireAct.this.updaterTempFR();
                    break;
                case 104:
                    Oudi_0452_Hongqi_TireAct.this.updaterTempRL();
                    break;
                case 105:
                    Oudi_0452_Hongqi_TireAct.this.updaterTempRR();
                    break;
                case 106:
                    Oudi_0452_Hongqi_TireAct.this.updaterFlTipWalm();
                    break;
                case 107:
                    Oudi_0452_Hongqi_TireAct.this.updaterFlLowWalm();
                    break;
                case 108:
                    Oudi_0452_Hongqi_TireAct.this.updaterFlHighWalm();
                    break;
                case 109:
                    Oudi_0452_Hongqi_TireAct.this.updaterFRlowWalm();
                    break;
                case 110:
                    Oudi_0452_Hongqi_TireAct.this.updaterFRTipWalm();
                    break;
                case 111:
                    Oudi_0452_Hongqi_TireAct.this.updaterFRHighWalm();
                    break;
                case 112:
                    Oudi_0452_Hongqi_TireAct.this.updaterRRTipWalm();
                    break;
                case 113:
                    Oudi_0452_Hongqi_TireAct.this.updaterRRLowWalm();
                    break;
                case 114:
                    Oudi_0452_Hongqi_TireAct.this.updaterRRHighWalm();
                    break;
                case 115:
                    Oudi_0452_Hongqi_TireAct.this.updaterRLTipWalm();
                    break;
                case 116:
                    Oudi_0452_Hongqi_TireAct.this.updaterRLLowWalm();
                    break;
                case 117:
                    Oudi_0452_Hongqi_TireAct.this.updaterRLHighWalm();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_zt_t600_tire);
        init();
    }

    @Override
    public void addNotify() {
        DataCanbus.PROXY.cmd(2, new int[]{56}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{57}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
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
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
    }

    @Override
    public void init() {
    }

    
    public void updaterTempFL() {
        String str;
        int value = DataCanbus.DATA[102];
        if (value == 255) {
            str = "--";
        } else {
            str = String.valueOf(value - 40) + "℃";
        }
        ((TextView) findViewById(R.id.zt_tv_car_tire_temp_0)).setText(str);
    }

    
    public void updaterTempFR() {
        String str;
        int value = DataCanbus.DATA[103];
        if (value == 255) {
            str = "--";
        } else {
            str = String.valueOf(value - 40) + "℃";
        }
        ((TextView) findViewById(R.id.zt_tv_car_tire_temp_1)).setText(str);
    }

    
    public void updaterTempRL() {
        String str;
        int value = DataCanbus.DATA[104];
        if (value == 255) {
            str = "--";
        } else {
            str = String.valueOf(value - 40) + "℃";
        }
        ((TextView) findViewById(R.id.zt_tv_car_tire_temp_2)).setText(str);
    }

    
    public void updaterTempRR() {
        String str;
        int value = DataCanbus.DATA[105];
        if (value == 255) {
            str = "--";
        } else {
            str = String.valueOf(value - 40) + "℃";
        }
        ((TextView) findViewById(R.id.zt_tv_car_tire_temp_3)).setText(str);
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[98] & 65535;
        if (value == 255) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_0)).setText("--.--");
        } else if (((TextView) findViewById(R.id.zt_tv_car_tire_press_0)) != null) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_0)).setText(String.valueOf(value / 10.0f) + "bar");
        }
    }

    
    public void updaterFlHighWalm() {
        int value = DataCanbus.DATA[108];
        if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.xp_yinglang_tire_str01);
        }
    }

    
    public void updaterFlLowWalm() {
        int value = DataCanbus.DATA[107];
        if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    
    public void updaterFlTipWalm() {
        int value = DataCanbus.DATA[106];
        if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.zt_t600_car_chuanganqi);
        }
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[99] & 65535;
        if (value == 255) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_1)).setText("--.--");
        } else if (((TextView) findViewById(R.id.zt_tv_car_tire_press_1)) != null) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_1)).setText(String.valueOf(value / 10.0f) + "bar");
        }
    }

    
    public void updaterFRHighWalm() {
        int value = DataCanbus.DATA[111];
        if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.xp_yinglang_tire_str01);
        }
    }

    
    public void updaterFRlowWalm() {
        int value = DataCanbus.DATA[110];
        if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    
    public void updaterFRTipWalm() {
        int value = DataCanbus.DATA[109];
        if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.zt_t600_car_chuanganqi);
        }
    }

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[100] & 65535;
        if (value == 255) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_2)).setText("--.--");
        } else if (((TextView) findViewById(R.id.zt_tv_car_tire_press_2)) != null) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_2)).setText(String.valueOf(value / 10.0f) + "bar");
        }
    }

    
    public void updaterRLHighWalm() {
        int value = DataCanbus.DATA[117];
        if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.xp_yinglang_tire_str01);
        }
    }

    
    public void updaterRLLowWalm() {
        int value = DataCanbus.DATA[116];
        if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    
    public void updaterRLTipWalm() {
        int value = DataCanbus.DATA[115];
        if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.zt_t600_car_chuanganqi);
        }
    }

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[101] & 65535;
        if (value == 255) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_3)).setText("--.--");
        } else if (((TextView) findViewById(R.id.zt_tv_car_tire_press_3)) != null) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_3)).setText(String.valueOf(value / 10.0f) + "bar");
        }
    }

    
    public void updaterRRHighWalm() {
        int value = DataCanbus.DATA[114];
        if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.xp_yinglang_tire_str01);
        }
    }

    
    public void updaterRRLowWalm() {
        int value = DataCanbus.DATA[113];
        if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    
    public void updaterRRTipWalm() {
        int value = DataCanbus.DATA[112];
        if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.zt_t600_car_chuanganqi);
        }
    }
}
