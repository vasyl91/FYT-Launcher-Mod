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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class DasAutoXpAct extends BaseActivity {
    int tempunit = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dasauto.DasAutoXpAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (DataCanbus.DATA[1000] == 65583) {
                if (DataCanbus.DATA[1000] != 65583) {
                    return;
                }
                switch (updateCode) {
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        DasAutoXpAct.this.mUpdaterDoor();
                        DasAutoXpAct.this.mUpdaterDoorBack();
                        break;
                    case 17:
                        DasAutoXpAct.this.mUpdaterLastOilWarning();
                        break;
                    case 18:
                        DasAutoXpAct.this.mUpdaterBatteryVolWarning();
                        break;
                    case 19:
                        DasAutoXpAct.this.mUpdaterSafetyBelt();
                        break;
                    case 20:
                        DasAutoXpAct.this.mUpdaterCleanLiquid();
                        break;
                    case 21:
                        DasAutoXpAct.this.mUpdaterBreakwarn();
                        break;
                    case 22:
                        DasAutoXpAct.this.mUpdaterLastOil();
                        break;
                    case 23:
                        DasAutoXpAct.this.mUpdaterBatteryVol();
                        break;
                    case 24:
                        DasAutoXpAct.this.mUpdaterDrivingMileage();
                        break;
                    case 27:
                        DasAutoXpAct.this.mUpdaterCurrentVelocity();
                        break;
                    case 28:
                        DasAutoXpAct.this.mUpdaterEngineSpeed();
                        break;
                    case 30:
                        DasAutoXpAct.this.mUpdaterOutTemp();
                        break;
                }
            }
            switch (updateCode) {
                case 1:
                    DasAutoXpAct.this.mUpdaterLastOilWarning();
                    break;
                case 2:
                    DasAutoXpAct.this.mUpdaterBatteryVolWarning();
                    break;
                case 3:
                    DasAutoXpAct.this.mUpdaterSafetyBelt();
                    break;
                case 4:
                    DasAutoXpAct.this.mUpdaterCleanLiquid();
                    break;
                case 5:
                    DasAutoXpAct.this.mUpdaterBreakwarn();
                    break;
                case 6:
                    DasAutoXpAct.this.mUpdaterLastOil();
                    break;
                case 7:
                    DasAutoXpAct.this.mUpdaterBatteryVol();
                    break;
                case 8:
                    DasAutoXpAct.this.mUpdaterDrivingMileage();
                    break;
                case 11:
                    DasAutoXpAct.this.mUpdaterCurrentVelocity();
                    break;
                case 12:
                    DasAutoXpAct.this.mUpdaterEngineSpeed();
                    break;
                case 34:
                    DasAutoXpAct.this.mUpdaterOutTemp();
                    break;
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                    DasAutoXpAct.this.mUpdaterDoor();
                    DasAutoXpAct.this.mUpdaterDoorBack();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dasauto);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.dasauto_btn_setting)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.DasAutoXpAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        DataCanbus.PROXY.cmd(3, 0);
        DoorHelper.disableDoorWindowLocal(false);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        this.tempunit = SystemProperties.getInt("persist.fyt.temperature", 0);
        if (DataCanbus.DATA[1000] != 65583) {
            DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        if (DataCanbus.DATA[1000] != 65583) {
            DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterEngineSpeed() {
        int value;
        if (DataCanbus.DATA[1000] == 65583) {
            value = DataCanbus.DATA[28];
        } else {
            value = DataCanbus.DATA[12];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCurrentVelocity() {
        int value;
        if (DataCanbus.DATA[1000] == 65583) {
            value = DataCanbus.DATA[27];
        } else {
            value = DataCanbus.DATA[11];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingMileage() {
        int value;
        if (DataCanbus.DATA[1000] == 65583) {
            value = DataCanbus.DATA[24];
        } else {
            value = DataCanbus.DATA[8];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSafetyBelt() {
        int value;
        if (DataCanbus.DATA[1000] == 65583) {
            value = DataCanbus.DATA[19];
        } else {
            value = DataCanbus.DATA[3];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCleanLiquid() {
        int value;
        if (DataCanbus.DATA[1000] == 65583) {
            value = DataCanbus.DATA[20];
        } else {
            value = DataCanbus.DATA[4];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBreakwarn() {
        int value;
        if (DataCanbus.DATA[1000] == 65583) {
            value = DataCanbus.DATA[21];
        } else {
            value = DataCanbus.DATA[5];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBatteryVol() {
        int value;
        if (DataCanbus.DATA[1000] == 65583) {
            value = DataCanbus.DATA[23];
        } else {
            value = DataCanbus.DATA[7];
        }
        if (value > 0) {
            ((TextView) findViewById(R.id.dasauto_tv_battery_voltage)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 100), Integer.valueOf(value % 100))) + " V");
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_battery_voltage)).setText("--.-- V");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBatteryVolWarning() {
        int value;
        if (DataCanbus.DATA[1000] == 65583) {
            value = DataCanbus.DATA[18];
        } else {
            value = DataCanbus.DATA[2];
        }
        if (value == 1) {
            ((TextView) findViewById(R.id.dasauto_tv_battery_voltage)).setTextColor(-65536);
            ((TextView) findViewById(R.id.dasauto_battery_voltage_xp_icon)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_battery_voltage)).setTextColor(-1);
            ((TextView) findViewById(R.id.dasauto_battery_voltage_xp_icon)).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOutTemp() {
        int value;
        if (DataCanbus.DATA[1000] == 65583) {
            value = DataCanbus.DATA[30];
        } else {
            value = DataCanbus.DATA[34];
        }
        if (((TextView) findViewById(R.id.dasauto_tv_outside_temperature)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.dasauto_tv_outside_temperature)).setText("OFF");
                return;
            }
            if (this.tempunit == 1) {
                if ((value & 32768) != 0) {
                    ((TextView) findViewById(R.id.dasauto_tv_outside_temperature)).setText(String.valueOf(String.format("%d", Integer.valueOf(((((value - 65536) * 9) / 5) + 320) / 10))) + " ℉");
                    return;
                } else {
                    ((TextView) findViewById(R.id.dasauto_tv_outside_temperature)).setText(String.valueOf(String.format("%d", Integer.valueOf((((value * 9) / 5) + 320) / 10))) + " ℉");
                    return;
                }
            }
            if ((value & 32768) != 0) {
                int value2 = value - 65536;
                ((TextView) findViewById(R.id.dasauto_tv_outside_temperature)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10))) + " ℃");
            } else {
                ((TextView) findViewById(R.id.dasauto_tv_outside_temperature)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " ℃");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLastOil() {
        int value;
        if (DataCanbus.DATA[1000] == 65583) {
            value = DataCanbus.DATA[22];
        } else {
            value = DataCanbus.DATA[6];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLastOilWarning() {
        int value;
        if (DataCanbus.DATA[1000] == 65583) {
            value = DataCanbus.DATA[17];
        } else {
            value = DataCanbus.DATA[1];
        }
        if (value == 1) {
            ((TextView) findViewById(R.id.dasauto_tv_last_oil)).setTextColor(-65536);
            ((TextView) findViewById(R.id.dasauto_tv_last_oil_xp_icon)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_last_oil)).setTextColor(-1);
            ((TextView) findViewById(R.id.dasauto_tv_last_oil_xp_icon)).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDoor() {
        if (((DoorContentView) findViewById(R.id.dasauto_door_xp)) != null) {
            ((DoorContentView) findViewById(R.id.dasauto_door_xp)).invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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
