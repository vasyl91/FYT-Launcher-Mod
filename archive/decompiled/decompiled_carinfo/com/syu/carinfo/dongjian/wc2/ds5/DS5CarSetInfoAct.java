package com.syu.carinfo.dongjian.wc2.ds5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class DS5CarSetInfoAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 108:
                    DS5CarSetInfoAct.this.updaterAutozhuche();
                    break;
                case 109:
                    DS5CarSetInfoAct.this.updaterRearYugua();
                    break;
                case 110:
                    DS5CarSetInfoAct.this.updaterzhucheHelp();
                    break;
                case 111:
                    DS5CarSetInfoAct.this.updaterdoorautolock();
                    break;
                case 112:
                    DS5CarSetInfoAct.this.updaterdoorlock();
                    break;
                case 113:
                    DS5CarSetInfoAct.this.updaterdoorUnlock();
                    break;
                case 114:
                    DS5CarSetInfoAct.this.updaterdaylight();
                    break;
                case 115:
                    DS5CarSetInfoAct.this.updaterdadenglater();
                    break;
                case 116:
                    DS5CarSetInfoAct.this.updatersuidongdadeng();
                    break;
                case 117:
                    DS5CarSetInfoAct.this.updaterzhucheHelpSystem();
                    break;
                case 118:
                    DS5CarSetInfoAct.this.updateryingbinLight();
                    break;
                case 119:
                    DS5CarSetInfoAct.this.updatercarspeedsaveState();
                    break;
                case 120:
                    DS5CarSetInfoAct.this.updatercarspeedM1saveState();
                    break;
                case 121:
                    DS5CarSetInfoAct.this.updatercarspeedM2saveState();
                    break;
                case 122:
                    DS5CarSetInfoAct.this.updatercarspeedM3saveState();
                    break;
                case 123:
                    DS5CarSetInfoAct.this.updatercarspeedM4saveState();
                    break;
                case 124:
                    DS5CarSetInfoAct.this.updatercarspeedM5saveState();
                    break;
                case 125:
                    DS5CarSetInfoAct.this.updatercarspeedM1();
                    break;
                case 126:
                    DS5CarSetInfoAct.this.updatercarspeedM2();
                    break;
                case 127:
                    DS5CarSetInfoAct.this.updatercarspeedM3();
                    break;
                case 128:
                    DS5CarSetInfoAct.this.updatercarspeedM4();
                    break;
                case 129:
                    DS5CarSetInfoAct.this.updatercarspeedM5();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        //setContentView(R.layout.layout_302_dongjian_wc2_ds5_car_set_info);
        init();
        setUI();
    }

    @Override
    public void init() {
    }

    public void setUI() {
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_auto_zhuche_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_rear_yugua_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_zhuche_help_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_door_auto_lock_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_door_lock_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_door_unlock_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_rijian_xingchedeng_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_suidong_dadeng_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_zhuche_help_system_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_car_speed_save_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_car_speed_save_m1_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_car_speed_save_m2_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_car_speed_save_m3_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_car_speed_save_m4_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_car_speed_save_m5_check)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_dadeng_later_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_dadeng_later_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_yingbin_dadeng_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_yingbin_dadeng_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_car_speed_M1_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_car_speed_M1_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_car_speed_M2_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_car_speed_M2_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_car_speed_M3_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_car_speed_M3_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_car_speed_M4_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_car_speed_M4_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_car_speed_M5_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_car_speed_M5_next)).setOnClickListener(this);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
    }

    
    public void updaterAutozhuche() {
        int autozhucheValue = DataCanbus.DATA[108];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_auto_zhuche_check)).setChecked(autozhucheValue != 0);
    }

    
    public void updaterRearYugua() {
        int rearYuguaValue = DataCanbus.DATA[109];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_rear_yugua_check)).setChecked(rearYuguaValue != 0);
    }

    
    public void updaterzhucheHelp() {
        int zhucheHelpValue = DataCanbus.DATA[110];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_zhuche_help_check)).setChecked(zhucheHelpValue != 0);
    }

    
    public void updaterdoorautolock() {
        int doorAutoLockValue = DataCanbus.DATA[111];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_door_auto_lock_check)).setChecked(doorAutoLockValue != 0);
    }

    
    public void updaterdoorlock() {
        int doorLockValue = DataCanbus.DATA[112];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_door_lock_check)).setChecked(doorLockValue != 0);
    }

    
    public void updaterdoorUnlock() {
        int doorUnlockValue = DataCanbus.DATA[113];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_door_unlock_check)).setChecked(doorUnlockValue != 0);
        if (doorUnlockValue == 0) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_door_unlock_tv)).setText(R.string.wc_ruiteng_string_unlock_mode_0);
        } else if (doorUnlockValue == 1) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_door_unlock_tv)).setText(R.string.wc_ruiteng_string_unlock_mode_1);
        }
    }

    
    public void updaterdaylight() {
        int dayLightValue = DataCanbus.DATA[114];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_rijian_xingchedeng_check)).setChecked(dayLightValue != 0);
    }

    
    public void updaterdadenglater() {
        int dadengLaterValue = DataCanbus.DATA[115];
        if (dadengLaterValue == 0) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_dadeng_later_TV)).setText(R.string.off);
            return;
        }
        if (dadengLaterValue == 1) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_dadeng_later_TV)).setText(R.string.str_dongjian_wc2_dadeng_later_15s);
        } else if (dadengLaterValue == 2) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_dadeng_later_TV)).setText(R.string.klc_light_Lasuo_headlight_delay_1);
        } else if (dadengLaterValue == 3) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_dadeng_later_TV)).setText(R.string.klc_light_Lasuo_headlight_delay_2);
        }
    }

    
    public void updatersuidongdadeng() {
        int suidongdadengValue = DataCanbus.DATA[116];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_suidong_dadeng_check)).setChecked(suidongdadengValue != 0);
    }

    
    public void updaterzhucheHelpSystem() {
        int zhucheHelpSystemValue = DataCanbus.DATA[117];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_zhuche_help_system_check)).setChecked(zhucheHelpSystemValue != 0);
    }

    
    public void updateryingbinLight() {
        int yingbindadengValue = DataCanbus.DATA[118];
        if (yingbindadengValue == 0) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_yingbin_dadeng_TV)).setText(R.string.off);
            return;
        }
        if (yingbindadengValue == 1) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_yingbin_dadeng_TV)).setText(R.string.str_dongjian_wc2_dadeng_later_15s);
        } else if (yingbindadengValue == 2) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_yingbin_dadeng_TV)).setText(R.string.klc_light_Lasuo_headlight_delay_1);
        } else if (yingbindadengValue == 3) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_yingbin_dadeng_TV)).setText(R.string.klc_light_Lasuo_headlight_delay_2);
        }
    }

    
    public void updatercarspeedsaveState() {
        int carSpeedStatevalue = DataCanbus.DATA[119];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_car_speed_save_check)).setChecked(carSpeedStatevalue != 0);
    }

    
    public void updatercarspeedM1saveState() {
        int carSpeedM1StateValue = DataCanbus.DATA[120];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_car_speed_save_m1_check)).setChecked(carSpeedM1StateValue != 0);
    }

    
    public void updatercarspeedM2saveState() {
        int carSpeedM2StateValue = DataCanbus.DATA[121];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_car_speed_save_m2_check)).setChecked(carSpeedM2StateValue != 0);
    }

    
    public void updatercarspeedM3saveState() {
        int carSpeedM3StateValue = DataCanbus.DATA[122];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_car_speed_save_m3_check)).setChecked(carSpeedM3StateValue != 0);
    }

    
    public void updatercarspeedM4saveState() {
        int carSpeedM4StateValue = DataCanbus.DATA[123];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_car_speed_save_m4_check)).setChecked(carSpeedM4StateValue != 0);
    }

    
    public void updatercarspeedM5saveState() {
        int carSpeedM5StateValue = DataCanbus.DATA[124];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_car_speed_save_m5_check)).setChecked(carSpeedM5StateValue != 0);
    }

    
    public void updatercarspeedM1() {
        int carSpeedM1Value = DataCanbus.DATA[125];
        ((TextView) findViewById(R.id.dongjian_wc2_ds5_car_speed_M1_TV)).setText(carSpeedM1Value + "km/h");
    }

    
    public void updatercarspeedM2() {
        int carSpeedM2Value = DataCanbus.DATA[126];
        ((TextView) findViewById(R.id.dongjian_wc2_ds5_car_speed_M2_TV)).setText(carSpeedM2Value + "km/h");
    }

    
    public void updatercarspeedM3() {
        int carSpeedM3Value = DataCanbus.DATA[127];
        ((TextView) findViewById(R.id.dongjian_wc2_ds5_car_speed_M3_TV)).setText(carSpeedM3Value + "km/h");
    }

    
    public void updatercarspeedM4() {
        int carSpeedM4Value = DataCanbus.DATA[128];
        ((TextView) findViewById(R.id.dongjian_wc2_ds5_car_speed_M4_TV)).setText(carSpeedM4Value + "km/h");
    }

    
    public void updatercarspeedM5() {
        int carSpeedM5Value = DataCanbus.DATA[129];
        ((TextView) findViewById(R.id.dongjian_wc2_ds5_car_speed_M5_TV)).setText(carSpeedM5Value + "km/h");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dongjian_wc2_ds5_auto_zhuche_check /* 2131429161 */:
                DS5Func.C_CAR_COMPUTER_SET(8, DataCanbus.DATA[108] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_ds5_rear_yugua_check /* 2131429162 */:
                DS5Func.C_CAR_COMPUTER_SET(1, DataCanbus.DATA[109] == 0 ? 1 : 0);
                break;
            case R.id.dongjian_wc2_ds5_zhuche_help_check /* 2131429163 */:
                DS5Func.C_CAR_COMPUTER_SET(2, DataCanbus.DATA[110] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_ds5_door_unlock_check /* 2131429166 */:
                DS5Func.C_CAR_COMPUTER_SET(4, DataCanbus.DATA[113] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_ds5_rijian_xingchedeng_check /* 2131429168 */:
                DS5Func.C_CAR_COMPUTER_SET(5, DataCanbus.DATA[114] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_ds5_dadeng_later_pre /* 2131429169 */:
                if (DataCanbus.DATA[115] == 0) {
                    DS5Func.C_CAR_COMPUTER_SET(6, 3);
                    break;
                } else if (DataCanbus.DATA[115] == 1) {
                    DS5Func.C_CAR_COMPUTER_SET(6, 0);
                    break;
                } else if (DataCanbus.DATA[115] == 2) {
                    DS5Func.C_CAR_COMPUTER_SET(6, 1);
                    break;
                } else if (DataCanbus.DATA[115] == 3) {
                    DS5Func.C_CAR_COMPUTER_SET(6, 2);
                    break;
                }
            case R.id.dongjian_wc2_ds5_dadeng_later_next /* 2131429171 */:
                if (DataCanbus.DATA[115] == 0) {
                    DS5Func.C_CAR_COMPUTER_SET(6, 1);
                    break;
                } else if (DataCanbus.DATA[115] == 1) {
                    DS5Func.C_CAR_COMPUTER_SET(6, 2);
                    break;
                } else if (DataCanbus.DATA[115] == 2) {
                    DS5Func.C_CAR_COMPUTER_SET(6, 3);
                    break;
                } else if (DataCanbus.DATA[115] == 3) {
                    DS5Func.C_CAR_COMPUTER_SET(6, 0);
                    break;
                }
            case R.id.dongjian_wc2_ds5_suidong_dadeng_check /* 2131429172 */:
                DS5Func.C_CAR_COMPUTER_SET(128, DataCanbus.DATA[116] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_zhuche_help_system_check /* 2131429173 */:
                DS5Func.C_CAR_COMPUTER_SET(130, DataCanbus.DATA[117] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_ds5_yingbin_dadeng_pre /* 2131429174 */:
                if (DataCanbus.DATA[118] == 0) {
                    DS5Func.C_CAR_COMPUTER_SET(129, 3);
                    break;
                } else if (DataCanbus.DATA[118] == 1) {
                    DS5Func.C_CAR_COMPUTER_SET(129, 0);
                    break;
                } else if (DataCanbus.DATA[118] == 2) {
                    DS5Func.C_CAR_COMPUTER_SET(129, 1);
                    break;
                } else if (DataCanbus.DATA[118] == 3) {
                    DS5Func.C_CAR_COMPUTER_SET(129, 2);
                    break;
                }
            case R.id.dongjian_wc2_ds5_yingbin_dadeng_next /* 2131429176 */:
                if (DataCanbus.DATA[118] == 0) {
                    DS5Func.C_CAR_COMPUTER_SET(129, 1);
                    break;
                } else if (DataCanbus.DATA[118] == 1) {
                    DS5Func.C_CAR_COMPUTER_SET(129, 2);
                    break;
                } else if (DataCanbus.DATA[118] == 2) {
                    DS5Func.C_CAR_COMPUTER_SET(129, 3);
                    break;
                } else if (DataCanbus.DATA[118] == 3) {
                    DS5Func.C_CAR_COMPUTER_SET(129, 0);
                    break;
                }
            case R.id.dongjian_wc2_car_speed_save_check /* 2131429177 */:
                DS5Func.C_CAR_COMPUTER_SET(144, DataCanbus.DATA[119] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_car_speed_save_m1_check /* 2131429178 */:
                DS5Func.C_CAR_COMPUTER_SET(145, DataCanbus.DATA[120] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_car_speed_save_m2_check /* 2131429179 */:
                DS5Func.C_CAR_COMPUTER_SET(146, DataCanbus.DATA[121] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_car_speed_save_m3_check /* 2131429180 */:
                DS5Func.C_CAR_COMPUTER_SET(147, DataCanbus.DATA[122] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_car_speed_save_m4_check /* 2131429181 */:
                DS5Func.C_CAR_COMPUTER_SET(148, DataCanbus.DATA[123] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_car_speed_save_m5_check /* 2131429182 */:
                DS5Func.C_CAR_COMPUTER_SET(149, DataCanbus.DATA[124] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_ds5_car_speed_M1_pre /* 2131429183 */:
                if (DataCanbus.DATA[125] - 1 > 40) {
                    DS5Func.C_CAR_COMPUTER_SET(161, DataCanbus.DATA[125] - 1);
                    break;
                }
            case R.id.dongjian_wc2_ds5_car_speed_M1_next /* 2131429185 */:
                if (DataCanbus.DATA[125] + 1 < 180) {
                    DS5Func.C_CAR_COMPUTER_SET(161, DataCanbus.DATA[125] + 1);
                    break;
                }
            case R.id.dongjian_wc2_ds5_car_speed_M2_pre /* 2131429186 */:
                if (DataCanbus.DATA[126] - 1 > 40) {
                    DS5Func.C_CAR_COMPUTER_SET(162, DataCanbus.DATA[126] - 1);
                    break;
                }
            case R.id.dongjian_wc2_ds5_car_speed_M2_next /* 2131429188 */:
                if (DataCanbus.DATA[126] + 1 < 180) {
                    DS5Func.C_CAR_COMPUTER_SET(162, DataCanbus.DATA[126] + 1);
                    break;
                }
            case R.id.dongjian_wc2_ds5_car_speed_M3_pre /* 2131429189 */:
                if (DataCanbus.DATA[127] - 1 > 40) {
                    DS5Func.C_CAR_COMPUTER_SET(163, DataCanbus.DATA[127] - 1);
                    break;
                }
            case R.id.dongjian_wc2_ds5_car_speed_M3_next /* 2131429191 */:
                if (DataCanbus.DATA[127] + 1 < 180) {
                    DS5Func.C_CAR_COMPUTER_SET(163, DataCanbus.DATA[127] + 1);
                    break;
                }
            case R.id.dongjian_wc2_ds5_car_speed_M4_pre /* 2131429192 */:
                if (DataCanbus.DATA[128] - 1 > 40) {
                    DS5Func.C_CAR_COMPUTER_SET(164, DataCanbus.DATA[128] - 1);
                    break;
                }
            case R.id.dongjian_wc2_ds5_car_speed_M4_next /* 2131429194 */:
                if (DataCanbus.DATA[128] + 1 < 180) {
                    DS5Func.C_CAR_COMPUTER_SET(164, DataCanbus.DATA[128] + 1);
                    break;
                }
            case R.id.dongjian_wc2_ds5_car_speed_M5_pre /* 2131429195 */:
                if (DataCanbus.DATA[129] - 1 > 40) {
                    DS5Func.C_CAR_COMPUTER_SET(165, DataCanbus.DATA[129] - 1);
                    break;
                }
            case R.id.dongjian_wc2_ds5_car_speed_M5_next /* 2131429197 */:
                if (DataCanbus.DATA[129] + 1 < 180) {
                    DS5Func.C_CAR_COMPUTER_SET(165, DataCanbus.DATA[129] + 1);
                    break;
                }
        }
    }
}
