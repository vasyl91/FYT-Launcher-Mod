package com.syu.carinfo.dasauto;

import android.os.Bundle;
import android.os.SystemProperties;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.widget.DoorContentView;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.ui.door.DoorHelper;

public class DasAutoXpAct extends BaseActivity {
    int tempunit = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (DataCanbus.DATA[1000] == 65583) {
                if (DataCanbus.DATA[1000] != 65583) {
                    return;
                }
                switch (updateCode) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        DasAutoXpAct.this.mUpdaterDoor();
                        DasAutoXpAct.this.mUpdaterDoorBack();
                        break;
                    case 108:
                        DasAutoXpAct.this.mUpdaterLastOilWarning();
                        break;
                    case 109:
                        DasAutoXpAct.this.mUpdaterBatteryVolWarning();
                        break;
                    case 110:
                        DasAutoXpAct.this.mUpdaterSafetyBelt();
                        break;
                    case 111:
                        DasAutoXpAct.this.mUpdaterCleanLiquid();
                        break;
                    case 112:
                        DasAutoXpAct.this.mUpdaterBreakwarn();
                        break;
                    case 113:
                        DasAutoXpAct.this.mUpdaterLastOil();
                        break;
                    case 114:
                        DasAutoXpAct.this.mUpdaterBatteryVol();
                        break;
                    case 115:
                        DasAutoXpAct.this.mUpdaterDrivingMileage();
                        break;
                    case 118:
                        DasAutoXpAct.this.mUpdaterCurrentVelocity();
                        break;
                    case 119:
                        DasAutoXpAct.this.mUpdaterEngineSpeed();
                        break;
                    case 121:
                        DasAutoXpAct.this.mUpdaterOutTemp();
                        break;
                }
            }
            switch (updateCode) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    DasAutoXpAct.this.mUpdaterDoor();
                    DasAutoXpAct.this.mUpdaterDoorBack();
                    break;
                case 99:
                    DasAutoXpAct.this.mUpdaterLastOilWarning();
                    break;
                case 100:
                    DasAutoXpAct.this.mUpdaterBatteryVolWarning();
                    break;
                case 101:
                    DasAutoXpAct.this.mUpdaterSafetyBelt();
                    break;
                case 102:
                    DasAutoXpAct.this.mUpdaterCleanLiquid();
                    break;
                case 103:
                    DasAutoXpAct.this.mUpdaterBreakwarn();
                    break;
                case 104:
                    DasAutoXpAct.this.mUpdaterLastOil();
                    break;
                case 105:
                    DasAutoXpAct.this.mUpdaterBatteryVol();
                    break;
                case 106:
                    DasAutoXpAct.this.mUpdaterDrivingMileage();
                    break;
                case 109:
                    DasAutoXpAct.this.mUpdaterCurrentVelocity();
                    break;
                case 110:
                    DasAutoXpAct.this.mUpdaterEngineSpeed();
                    break;
                case 121:
                    DasAutoXpAct.this.mUpdaterOutTemp();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_dasauto);
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.dasauto_btn_setting)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if ((DataCanbus.DATA[1000] != 369 && DataCanbus.DATA[1000] != 65905) || DataCanbus.DATA[1000] == 131441 || DataCanbus.DATA[1000] == 196977) {
            DataCanbus.PROXY.cmd(3, 1);
        }
        addNotify();
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        if (dm.widthPixels != 800 && dm.widthPixels != 768) {
            DoorHelper.disableDoorWindowLocal(true);
        }
        if (DataCanbus.DATA[1000] == 261 || DataCanbus.DATA[1000] == 65583) {
            if (((TextView) findViewById(R.id.dasauto_tv_engine_text)) != null) {
                ((TextView) findViewById(R.id.dasauto_tv_engine_text)).setText(R.string.coolant_temp);
            }
            if (findViewById(R.id.dasauto_tv_engine_image) != null) {
                findViewById(R.id.dasauto_tv_engine_image).setBackgroundResource(R.drawable.ic_dasauto_engine_speed_ks);
            }
            if (((TextView) findViewById(R.id.dasauto_tv_mileage_text)) != null) {
                ((TextView) findViewById(R.id.dasauto_tv_mileage_text)).setText(R.string.travelling_time);
            }
        } else {
            if (((TextView) findViewById(R.id.dasauto_tv_engine_text)) != null) {
                ((TextView) findViewById(R.id.dasauto_tv_engine_text)).setText(R.string.engine_speed);
            }
            if (findViewById(R.id.dasauto_tv_engine_image) != null) {
                findViewById(R.id.dasauto_tv_engine_image).setBackgroundResource(R.drawable.ic_dasauto_engine_speed);
            }
            if (((TextView) findViewById(R.id.dasauto_tv_mileage_text)) != null) {
                ((TextView) findViewById(R.id.dasauto_tv_mileage_text)).setText(R.string.mileage);
            }
        }
        if (((Button) findViewById(R.id.dasauto_btn_setting)) != null) {
            ((Button) findViewById(R.id.dasauto_btn_setting)).setVisibility(8);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
        DataCanbus.PROXY.cmd(3, 0);
        DoorHelper.disableDoorWindowLocal(false);
    }

    @Override
    public void addNotify() {
        this.tempunit = SystemProperties.getInt("persist.fyt.temperature", 0);
        if (DataCanbus.DATA[1000] != 65583) {
            DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        if (DataCanbus.DATA[1000] != 65583) {
            DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterEngineSpeed() {
        int value;
        if (DataCanbus.DATA[1000] == 65583) {
            value = DataCanbus.DATA[119];
        } else {
            value = DataCanbus.DATA[110];
        }
        if (DataCanbus.DATA[1000] == 261 || DataCanbus.DATA[1000] == 65583) {
            if (value > 0) {
                if (value > 60000) {
                    value -= 65536;
                }
                ((TextView) findViewById(R.id.dasauto_tv_engine_speed)).setText(String.valueOf(value / 10) + " °C");
                return;
            }
            ((TextView) findViewById(R.id.dasauto_tv_engine_speed)).setText("--.-- °C");
            return;
        }
        if (value > 0) {
            ((TextView) findViewById(R.id.dasauto_tv_engine_speed)).setText(String.valueOf(value) + " RPM");
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_engine_speed)).setText("--.-- RPM");
        }
    }

    
    public void mUpdaterCurrentVelocity() {
        int value;
        if (DataCanbus.DATA[1000] == 65583) {
            value = DataCanbus.DATA[118];
        } else {
            value = DataCanbus.DATA[109];
        }
        if (this.tempunit == 1) {
            if (value > 0) {
                int value2 = (value * 10) / 16;
                if (DataCanbus.DATA[1000] == 369 || DataCanbus.DATA[1000] == 65905 || DataCanbus.DATA[1000] == 131441 || DataCanbus.DATA[1000] == 196977) {
                    ((TextView) findViewById(R.id.dasauto_tv_current_speed)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10))) + " mph");
                    return;
                } else {
                    ((TextView) findViewById(R.id.dasauto_tv_current_speed)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value2 / 100), Integer.valueOf(value2 % 100))) + " mph");
                    return;
                }
            }
            ((TextView) findViewById(R.id.dasauto_tv_current_speed)).setText("--.-- mph");
            return;
        }
        if (value > 0) {
            if (DataCanbus.DATA[1000] == 369 || DataCanbus.DATA[1000] == 65905 || DataCanbus.DATA[1000] == 131441 || DataCanbus.DATA[1000] == 196977) {
                ((TextView) findViewById(R.id.dasauto_tv_current_speed)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km/h");
                return;
            } else {
                ((TextView) findViewById(R.id.dasauto_tv_current_speed)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 100), Integer.valueOf(value % 100))) + " km/h");
                return;
            }
        }
        ((TextView) findViewById(R.id.dasauto_tv_current_speed)).setText("--.-- km/h");
    }

    
    public void mUpdaterDrivingMileage() {
        int value;
        if (DataCanbus.DATA[1000] == 65583) {
            value = DataCanbus.DATA[115];
        } else {
            value = DataCanbus.DATA[106];
        }
        if (DataCanbus.DATA[1000] == 261 || DataCanbus.DATA[1000] == 65583) {
            int hour = (value >> 16) & 255;
            int minuts = (value >> 8) & 255;
            ((TextView) findViewById(R.id.dasauto_tv_mileage)).setText(String.format("%02d:%02d", Integer.valueOf(hour), Integer.valueOf(minuts)));
        } else {
            if (this.tempunit == 1) {
                if (value > 0) {
                    ((TextView) findViewById(R.id.dasauto_tv_mileage)).setText(String.valueOf((value * 10) / 16) + " miles");
                    return;
                } else {
                    ((TextView) findViewById(R.id.dasauto_tv_mileage)).setText("--.-- miles");
                    return;
                }
            }
            if (value > 0) {
                ((TextView) findViewById(R.id.dasauto_tv_mileage)).setText(String.valueOf(value) + " km");
            } else {
                ((TextView) findViewById(R.id.dasauto_tv_mileage)).setText("--.-- km");
            }
        }
    }

    
    public void mUpdaterSafetyBelt() {
        int value;
        if (DataCanbus.DATA[1000] == 65583) {
            value = DataCanbus.DATA[110];
        } else {
            value = DataCanbus.DATA[101];
        }
        if (value == 1) {
            ((TextView) findViewById(R.id.dasauto_tv_safety_belt)).setText(R.string.alarm);
            ((TextView) findViewById(R.id.dasauto_tv_safety_belt)).setTextColor(-65536);
            ((TextView) findViewById(R.id.dasauto_safety_belt_xp_icon)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_safety_belt)).setText(R.string.normal);
            ((TextView) findViewById(R.id.dasauto_tv_safety_belt)).setTextColor(-1);
            ((TextView) findViewById(R.id.dasauto_safety_belt_xp_icon)).setVisibility(8);
        }
    }

    
    public void mUpdaterCleanLiquid() {
        int value;
        if (DataCanbus.DATA[1000] == 65583) {
            value = DataCanbus.DATA[111];
        } else {
            value = DataCanbus.DATA[102];
        }
        if (value == 1) {
            ((TextView) findViewById(R.id.dasauto_tv_cleaning_liquid)).setText(R.string.alarm);
            ((TextView) findViewById(R.id.dasauto_tv_cleaning_liquid)).setTextColor(-65536);
            ((TextView) findViewById(R.id.dasauto_cleaning_xp_icon)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_cleaning_liquid)).setText(R.string.normal);
            ((TextView) findViewById(R.id.dasauto_tv_cleaning_liquid)).setTextColor(-1);
            ((TextView) findViewById(R.id.dasauto_cleaning_xp_icon)).setVisibility(8);
        }
    }

    
    public void mUpdaterBreakwarn() {
        int value;
        if (DataCanbus.DATA[1000] == 65583) {
            value = DataCanbus.DATA[112];
        } else {
            value = DataCanbus.DATA[103];
        }
        switch (DataCanbus.DATA[1000]) {
            case 51:
            case FinalCanbus.CAR_RZC_DaZhong_H /* 131123 */:
            case FinalCanbus.CAR_RZC_DaZhong_SUP /* 196659 */:
            case FinalCanbus.CAR_RZC_DaZhong_SUP_H /* 262195 */:
            case FinalCanbus.CAR_RCW_DaZhong_07_11Maiteng /* 327731 */:
            case FinalCanbus.CAR_RCW_DaZhong_07_11Maiteng_H /* 393267 */:
            case FinalCanbus.CAR_RZC_DaZhong_SUP_M /* 458803 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_07_10Suteng /* 524339 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_05_11Pasate /* 589875 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_07_10Maiteng /* 655411 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_10_12Gaoerfu6 /* 720947 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_08_10Gaoerfu6 /* 786483 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_07_12Mingrui /* 852019 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_07_10Jieda /* 917555 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_10_12CC /* 983091 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_08_10Shangku /* 1048627 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_08_10Langyi /* 1114163 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_13_17Langyi /* 1179699 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_11_18Baolai /* 1245235 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_08_18Polo /* 1310771 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_13_18CC /* 1376307 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_13_18Sangtana /* 1441843 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_13_17langxing /* 1507379 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_14_17langJing /* 1572915 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_08_15Tuan /* 1638451 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_11_19Jieda /* 1703987 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_08_17Jingrui /* 1769523 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_14_19Xindong /* 1835059 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_13_19XinRui /* 1900595 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_09_13HaoRui /* 1966131 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_14_17Yedi /* 2031667 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_12_18Xialang /* 2162739 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_11_16Shangku /* 2228275 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_11_16Passat /* 2293811 */:
            case FinalCanbus.CAR_RZC_DaZhong_PQ_10_15Tiguan /* 2359347 */:
            case FinalCanbus.CAR_RZC_Audi_TT_08_13 /* 2424883 */:
            case FinalCanbus.CAR_RZC_Audi_A3_04_12 /* 2490419 */:
            case FinalCanbus.CAR_RZC_Audi_A4_03_07 /* 2555955 */:
            case FinalCanbus.CAR_RZC_PQ_11_15Magotan_B7 /* 2818099 */:
            case FinalCanbus.CAR_RZC_Audi_Q3_13_18 /* 2883635 */:
            case FinalCanbus.CAR_RZC_Audi_Q5_10_18 /* 2949171 */:
            case FinalCanbus.CAR_XC_Ford_ForexClub /* 4259891 */:
            case FinalCanbus.CAR_RZC_SSANGYONG_TIVOLAN /* 4325427 */:
            case FinalCanbus.CAR_RZC_JH_All /* 4456499 */:
                if (value != 1) {
                    value = 1;
                    break;
                } else {
                    value = 0;
                    break;
                }
        }
        if (value == 1) {
            ((TextView) findViewById(R.id.dasauto_tv_hand_brake)).setText(R.string.alarm);
            ((TextView) findViewById(R.id.dasauto_tv_hand_brake)).setTextColor(-65536);
            ((TextView) findViewById(R.id.dasauto_hand_brake_xp_icon)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_hand_brake)).setText(R.string.normal);
            ((TextView) findViewById(R.id.dasauto_tv_hand_brake)).setTextColor(-1);
            ((TextView) findViewById(R.id.dasauto_hand_brake_xp_icon)).setVisibility(8);
        }
    }

    
    public void mUpdaterBatteryVol() {
        int value;
        if (DataCanbus.DATA[1000] == 65583) {
            value = DataCanbus.DATA[114];
        } else {
            value = DataCanbus.DATA[105];
        }
        if (value > 0) {
            ((TextView) findViewById(R.id.dasauto_tv_battery_voltage)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 100), Integer.valueOf(value % 100))) + " V");
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_battery_voltage)).setText("--.-- V");
        }
    }

    
    public void mUpdaterBatteryVolWarning() {
        int value;
        if (DataCanbus.DATA[1000] == 65583) {
            value = DataCanbus.DATA[109];
        } else {
            value = DataCanbus.DATA[100];
        }
        if (value == 1) {
            ((TextView) findViewById(R.id.dasauto_tv_battery_voltage)).setTextColor(-65536);
            ((TextView) findViewById(R.id.dasauto_battery_voltage_xp_icon)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_battery_voltage)).setTextColor(-1);
            ((TextView) findViewById(R.id.dasauto_battery_voltage_xp_icon)).setVisibility(8);
        }
    }

    
    public void mUpdaterOutTemp() {
        int value;
        if (DataCanbus.DATA[1000] == 65583) {
            value = DataCanbus.DATA[121];
        } else {
            value = DataCanbus.DATA[121];
        }
        if (((TextView) findViewById(R.id.dasauto_tv_outside_temperature)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.dasauto_tv_outside_temperature)).setText("OFF");
                return;
            }
            if (this.tempunit == 1) {
                if ((32768 & value) != 0) {
                    ((TextView) findViewById(R.id.dasauto_tv_outside_temperature)).setText(String.valueOf(String.format("%d", Integer.valueOf(((((value - 65536) * 9) / 5) + 320) / 10))) + " ℉");
                    return;
                } else {
                    ((TextView) findViewById(R.id.dasauto_tv_outside_temperature)).setText(String.valueOf(String.format("%d", Integer.valueOf((((value * 9) / 5) + 320) / 10))) + " ℉");
                    return;
                }
            }
            if ((32768 & value) != 0) {
                int value2 = value - 65536;
                ((TextView) findViewById(R.id.dasauto_tv_outside_temperature)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10))) + " ℃");
            } else {
                ((TextView) findViewById(R.id.dasauto_tv_outside_temperature)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " ℃");
            }
        }
    }

    
    public void mUpdaterLastOil() {
        int value;
        if (DataCanbus.DATA[1000] == 65583) {
            value = DataCanbus.DATA[113];
        } else {
            value = DataCanbus.DATA[104];
        }
        if (this.tempunit == 1) {
            if (value > 0) {
                ((TextView) findViewById(R.id.dasauto_tv_last_oil)).setText(String.valueOf((value * 100) / 378) + " gal");
                return;
            } else {
                ((TextView) findViewById(R.id.dasauto_tv_last_oil)).setText("--.-- gal");
                return;
            }
        }
        if (value > 0) {
            ((TextView) findViewById(R.id.dasauto_tv_last_oil)).setText(String.valueOf(value) + " L");
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_last_oil)).setText("--.-- L");
        }
    }

    
    public void mUpdaterLastOilWarning() {
        int value;
        if (DataCanbus.DATA[1000] == 65583) {
            value = DataCanbus.DATA[108];
        } else {
            value = DataCanbus.DATA[99];
        }
        if (value == 1) {
            ((TextView) findViewById(R.id.dasauto_tv_last_oil)).setTextColor(-65536);
            ((TextView) findViewById(R.id.dasauto_tv_last_oil_xp_icon)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_last_oil)).setTextColor(-1);
            ((TextView) findViewById(R.id.dasauto_tv_last_oil_xp_icon)).setVisibility(8);
        }
    }

    
    public void mUpdaterDoor() {
        if (((DoorContentView) findViewById(R.id.dasauto_door_xp)) != null) {
            ((DoorContentView) findViewById(R.id.dasauto_door_xp)).invalidate();
        }
    }

    
    public void mUpdaterDoorBack() {
        if (DoorHelper.sUcDoorBack > -1) {
            int value = DataCanbus.DATA[DoorHelper.sUcDoorBack];
            if (value == 1) {
                ((TextView) findViewById(R.id.dasauto_tv_trunk)).setText(R.string.alarm);
                ((TextView) findViewById(R.id.dasauto_tv_trunk)).setTextColor(-65536);
                ((TextView) findViewById(R.id.dasauto_trunk_xp_icon)).setVisibility(0);
            } else {
                ((TextView) findViewById(R.id.dasauto_tv_trunk)).setText(R.string.normal);
                ((TextView) findViewById(R.id.dasauto_tv_trunk)).setTextColor(-1);
                ((TextView) findViewById(R.id.dasauto_trunk_xp_icon)).setVisibility(8);
            }
        }
    }
}
