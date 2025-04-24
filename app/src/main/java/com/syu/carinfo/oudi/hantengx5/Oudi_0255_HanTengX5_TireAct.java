package com.syu.carinfo.oudi.hantengx5;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.text.DecimalFormat;

@SuppressWarnings({"deprecation", "unchecked"})
public class Oudi_0255_HanTengX5_TireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 99:
                    Oudi_0255_HanTengX5_TireAct.this.mUpdaterTireFL();
                    break;
                case 100:
                    Oudi_0255_HanTengX5_TireAct.this.mUpdaterTireFR();
                    break;
                case 101:
                    Oudi_0255_HanTengX5_TireAct.this.mUpdaterTireRL();
                    break;
                case 102:
                    Oudi_0255_HanTengX5_TireAct.this.mUpdaterTireRR();
                    break;
                case 103:
                    Oudi_0255_HanTengX5_TireAct.this.updaterTempFL();
                    break;
                case 104:
                    Oudi_0255_HanTengX5_TireAct.this.updaterTempFR();
                    break;
                case 105:
                    Oudi_0255_HanTengX5_TireAct.this.updaterTempRL();
                    break;
                case 106:
                    Oudi_0255_HanTengX5_TireAct.this.updaterTempRR();
                    break;
                case 107:
                    Oudi_0255_HanTengX5_TireAct.this.updaterFlTipWalm();
                    break;
                case 108:
                    Oudi_0255_HanTengX5_TireAct.this.updaterFlLowWalm();
                    break;
                case 109:
                    Oudi_0255_HanTengX5_TireAct.this.updaterFlHighWalm();
                    break;
                case 110:
                    Oudi_0255_HanTengX5_TireAct.this.updaterFRlowWalm();
                    break;
                case 111:
                    Oudi_0255_HanTengX5_TireAct.this.updaterFRTipWalm();
                    break;
                case 112:
                    Oudi_0255_HanTengX5_TireAct.this.updaterFRHighWalm();
                    break;
                case 113:
                    Oudi_0255_HanTengX5_TireAct.this.updaterRRTipWalm();
                    break;
                case 114:
                    Oudi_0255_HanTengX5_TireAct.this.updaterRRLowWalm();
                    break;
                case 115:
                    Oudi_0255_HanTengX5_TireAct.this.updaterRRHighWalm();
                    break;
                case 116:
                    Oudi_0255_HanTengX5_TireAct.this.updaterRLTipWalm();
                    break;
                case 117:
                    Oudi_0255_HanTengX5_TireAct.this.updaterRLLowWalm();
                    break;
                case 118:
                    Oudi_0255_HanTengX5_TireAct.this.updaterRLHighWalm();
                    break;
                case 119:
                    Oudi_0255_HanTengX5_TireAct.this.updaterSystemBad();
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
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
    }

    @Override
    public void init() {
    }

    
    public void updaterTempFL() {
        String str;
        int value = DataCanbus.DATA[103];
        if (value == 255) {
            str = "--";
        } else {
            str = String.valueOf(value - 40) + "℃";
        }
        ((TextView) findViewById(R.id.zt_tv_car_tire_temp_0)).setText(str);
    }

    
    public void updaterTempFR() {
        String str;
        int value = DataCanbus.DATA[104];
        if (value == 255) {
            str = "--";
        } else {
            str = String.valueOf(value - 40) + "℃";
        }
        ((TextView) findViewById(R.id.zt_tv_car_tire_temp_1)).setText(str);
    }

    
    public void updaterTempRL() {
        String str;
        int value = DataCanbus.DATA[105];
        if (value == 255) {
            str = "--";
        } else {
            str = String.valueOf(value - 40) + "℃";
        }
        ((TextView) findViewById(R.id.zt_tv_car_tire_temp_2)).setText(str);
    }

    
    public void updaterTempRR() {
        String str;
        int value = DataCanbus.DATA[106];
        if (value == 255) {
            str = "--";
        } else {
            str = String.valueOf(value - 40) + "℃";
        }
        ((TextView) findViewById(R.id.zt_tv_car_tire_temp_3)).setText(str);
    }

    
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[99] & 65535;
        if (value == 255 || value == 65535) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_0)).setText("--.--");
            return;
        }
        int value2 = (int) (value * 1.373d * 100.0d);
        if (((TextView) findViewById(R.id.zt_tv_car_tire_press_0)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_0)).setText(String.valueOf(df.format(value2 / 100.0f)) + "Kpa");
        }
    }

    
    public void updaterFlHighWalm() {
        int system = DataCanbus.DATA[119];
        int value = DataCanbus.DATA[109];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.zt_t600_car_system_band);
        } else if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.xp_yinglang_tire_str01);
        }
    }

    
    public void updaterFlLowWalm() {
        int system = DataCanbus.DATA[119];
        int value = DataCanbus.DATA[108];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.zt_t600_car_system_band);
        } else if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    
    public void updaterFlTipWalm() {
        int system = DataCanbus.DATA[119];
        int value = DataCanbus.DATA[107];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.zt_t600_car_system_band);
        } else if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.zt_t600_car_chuanganqi);
        }
    }

    
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[100] & 65535;
        if (value == 255 || value == 65535) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_1)).setText("--.--");
            return;
        }
        int value2 = (int) (value * 1.373d * 100.0d);
        if (((TextView) findViewById(R.id.zt_tv_car_tire_press_1)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_1)).setText(String.valueOf(df.format(value2 / 100.0f)) + "Kpa");
        }
    }

    
    public void updaterFRHighWalm() {
        int system = DataCanbus.DATA[119];
        int value = DataCanbus.DATA[112];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.zt_t600_car_system_band);
        } else if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.xp_yinglang_tire_str01);
        }
    }

    
    public void updaterFRlowWalm() {
        int system = DataCanbus.DATA[119];
        int value = DataCanbus.DATA[111];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.zt_t600_car_system_band);
        } else if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    
    public void updaterFRTipWalm() {
        int system = DataCanbus.DATA[119];
        int value = DataCanbus.DATA[110];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.zt_t600_car_system_band);
        } else if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.zt_t600_car_chuanganqi);
        }
    }

    
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[101] & 65535;
        if (value == 255 || value == 65535) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_2)).setText("--.--");
            return;
        }
        int value2 = (int) (value * 1.373d * 100.0d);
        if (((TextView) findViewById(R.id.zt_tv_car_tire_press_2)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_2)).setText(String.valueOf(df.format(value2 / 100.0f)) + "Kpa");
        }
    }

    
    public void updaterRLHighWalm() {
        int system = DataCanbus.DATA[119];
        int value = DataCanbus.DATA[118];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.zt_t600_car_system_band);
        } else if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.xp_yinglang_tire_str01);
        }
    }

    
    public void updaterRLLowWalm() {
        int system = DataCanbus.DATA[119];
        int value = DataCanbus.DATA[117];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.zt_t600_car_system_band);
        } else if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    
    public void updaterRLTipWalm() {
        int system = DataCanbus.DATA[119];
        int value = DataCanbus.DATA[116];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.zt_t600_car_system_band);
        } else if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.zt_t600_car_chuanganqi);
        }
    }

    
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[102] & 65535;
        if (value == 255 || value == 65535) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_3)).setText("--.--");
            return;
        }
        int value2 = (int) (value * 1.373d * 100.0d);
        if (((TextView) findViewById(R.id.zt_tv_car_tire_press_3)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.zt_tv_car_tire_press_3)).setText(String.valueOf(df.format(value2 / 100.0f)) + "Kpa");
        }
    }

    
    public void updaterRRHighWalm() {
        int system = DataCanbus.DATA[119];
        int value = DataCanbus.DATA[115];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.zt_t600_car_system_band);
        } else if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.xp_yinglang_tire_str01);
        }
    }

    
    public void updaterRRLowWalm() {
        int system = DataCanbus.DATA[119];
        int value = DataCanbus.DATA[114];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.zt_t600_car_system_band);
        } else if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    
    public void updaterRRTipWalm() {
        int system = DataCanbus.DATA[119];
        int value = DataCanbus.DATA[113];
        if (system == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.zt_t600_car_system_band);
        } else if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText("");
        } else if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.zt_t600_car_chuanganqi);
        }
    }

    
    public void updaterSystemBad() {
        int value = DataCanbus.DATA[119];
        if (value == 1) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText(R.string.zt_t600_car_system_band);
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText(R.string.zt_t600_car_system_band);
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText(R.string.zt_t600_car_system_band);
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0) {
            ((TextView) findViewById(R.id.zt_tv_car_tire_0_warn)).setText("");
            ((TextView) findViewById(R.id.zt_tv_car_tire_1_warn)).setText("");
            ((TextView) findViewById(R.id.zt_tv_car_tire_2_warn)).setText("");
            ((TextView) findViewById(R.id.zt_tv_car_tire_3_warn)).setText("");
        }
    }
}
