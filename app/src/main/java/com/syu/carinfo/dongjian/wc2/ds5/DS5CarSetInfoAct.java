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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class DS5CarSetInfoAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dongjian.wc2.ds5.DS5CarSetInfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 11:
                    DS5CarSetInfoAct.this.updaterAutozhuche();
                    break;
                case 12:
                    DS5CarSetInfoAct.this.updaterRearYugua();
                    break;
                case 13:
                    DS5CarSetInfoAct.this.updaterzhucheHelp();
                    break;
                case 14:
                    DS5CarSetInfoAct.this.updaterdoorautolock();
                    break;
                case 15:
                    DS5CarSetInfoAct.this.updaterdoorlock();
                    break;
                case 16:
                    DS5CarSetInfoAct.this.updaterdoorUnlock();
                    break;
                case 17:
                    DS5CarSetInfoAct.this.updaterdaylight();
                    break;
                case 18:
                    DS5CarSetInfoAct.this.updaterdadenglater();
                    break;
                case 19:
                    DS5CarSetInfoAct.this.updatersuidongdadeng();
                    break;
                case 20:
                    DS5CarSetInfoAct.this.updaterzhucheHelpSystem();
                    break;
                case 21:
                    DS5CarSetInfoAct.this.updateryingbinLight();
                    break;
                case 22:
                    DS5CarSetInfoAct.this.updatercarspeedsaveState();
                    break;
                case 23:
                    DS5CarSetInfoAct.this.updatercarspeedM1saveState();
                    break;
                case 24:
                    DS5CarSetInfoAct.this.updatercarspeedM2saveState();
                    break;
                case 25:
                    DS5CarSetInfoAct.this.updatercarspeedM3saveState();
                    break;
                case 26:
                    DS5CarSetInfoAct.this.updatercarspeedM4saveState();
                    break;
                case 27:
                    DS5CarSetInfoAct.this.updatercarspeedM5saveState();
                    break;
                case 28:
                    DS5CarSetInfoAct.this.updatercarspeedM1();
                    break;
                case 29:
                    DS5CarSetInfoAct.this.updatercarspeedM2();
                    break;
                case 30:
                    DS5CarSetInfoAct.this.updatercarspeedM3();
                    break;
                case 31:
                    DS5CarSetInfoAct.this.updatercarspeedM4();
                    break;
                case 32:
                    DS5CarSetInfoAct.this.updatercarspeedM5();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_302_dongjian_wc2_ds5_car_set_info);
        init();
        setUI();
    }

    @Override // com.syu.canbus.BaseActivity
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

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutozhuche() {
        int autozhucheValue = DataCanbus.DATA[11];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_auto_zhuche_check)).setChecked(autozhucheValue != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRearYugua() {
        int rearYuguaValue = DataCanbus.DATA[12];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_rear_yugua_check)).setChecked(rearYuguaValue != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterzhucheHelp() {
        int zhucheHelpValue = DataCanbus.DATA[13];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_zhuche_help_check)).setChecked(zhucheHelpValue != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterdoorautolock() {
        int doorAutoLockValue = DataCanbus.DATA[14];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_door_auto_lock_check)).setChecked(doorAutoLockValue != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterdoorlock() {
        int doorLockValue = DataCanbus.DATA[15];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_door_lock_check)).setChecked(doorLockValue != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterdoorUnlock() {
        int doorUnlockValue = DataCanbus.DATA[16];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_door_unlock_check)).setChecked(doorUnlockValue != 0);
        if (doorUnlockValue == 0) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_door_unlock_tv)).setText(R.string.wc_ruiteng_string_unlock_mode_0);
        } else if (doorUnlockValue == 1) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_door_unlock_tv)).setText(R.string.wc_ruiteng_string_unlock_mode_1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterdaylight() {
        int dayLightValue = DataCanbus.DATA[17];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_rijian_xingchedeng_check)).setChecked(dayLightValue != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterdadenglater() {
        int dadengLaterValue = DataCanbus.DATA[18];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updatersuidongdadeng() {
        int suidongdadengValue = DataCanbus.DATA[19];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_suidong_dadeng_check)).setChecked(suidongdadengValue != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterzhucheHelpSystem() {
        int zhucheHelpSystemValue = DataCanbus.DATA[20];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_zhuche_help_system_check)).setChecked(zhucheHelpSystemValue != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateryingbinLight() {
        int yingbindadengValue = DataCanbus.DATA[21];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updatercarspeedsaveState() {
        int carSpeedStatevalue = DataCanbus.DATA[22];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_car_speed_save_check)).setChecked(carSpeedStatevalue != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatercarspeedM1saveState() {
        int carSpeedM1StateValue = DataCanbus.DATA[23];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_car_speed_save_m1_check)).setChecked(carSpeedM1StateValue != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatercarspeedM2saveState() {
        int carSpeedM2StateValue = DataCanbus.DATA[24];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_car_speed_save_m2_check)).setChecked(carSpeedM2StateValue != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatercarspeedM3saveState() {
        int carSpeedM3StateValue = DataCanbus.DATA[25];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_car_speed_save_m3_check)).setChecked(carSpeedM3StateValue != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatercarspeedM4saveState() {
        int carSpeedM4StateValue = DataCanbus.DATA[26];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_car_speed_save_m4_check)).setChecked(carSpeedM4StateValue != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatercarspeedM5saveState() {
        int carSpeedM5StateValue = DataCanbus.DATA[27];
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_car_speed_save_m5_check)).setChecked(carSpeedM5StateValue != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatercarspeedM1() {
        int carSpeedM1Value = DataCanbus.DATA[28];
        ((TextView) findViewById(R.id.dongjian_wc2_ds5_car_speed_M1_TV)).setText(carSpeedM1Value + "km/h");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatercarspeedM2() {
        int carSpeedM2Value = DataCanbus.DATA[29];
        ((TextView) findViewById(R.id.dongjian_wc2_ds5_car_speed_M2_TV)).setText(carSpeedM2Value + "km/h");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatercarspeedM3() {
        int carSpeedM3Value = DataCanbus.DATA[30];
        ((TextView) findViewById(R.id.dongjian_wc2_ds5_car_speed_M3_TV)).setText(carSpeedM3Value + "km/h");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatercarspeedM4() {
        int carSpeedM4Value = DataCanbus.DATA[31];
        ((TextView) findViewById(R.id.dongjian_wc2_ds5_car_speed_M4_TV)).setText(carSpeedM4Value + "km/h");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatercarspeedM5() {
        int carSpeedM5Value = DataCanbus.DATA[32];
        ((TextView) findViewById(R.id.dongjian_wc2_ds5_car_speed_M5_TV)).setText(carSpeedM5Value + "km/h");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dongjian_wc2_ds5_auto_zhuche_check /* 2131429201 */:
                DS5Func.C_CAR_COMPUTER_SET(8, DataCanbus.DATA[11] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_ds5_rear_yugua_check /* 2131429202 */:
                DS5Func.C_CAR_COMPUTER_SET(1, DataCanbus.DATA[12] == 0 ? 1 : 0);
                break;
            case R.id.dongjian_wc2_ds5_zhuche_help_check /* 2131429203 */:
                DS5Func.C_CAR_COMPUTER_SET(2, DataCanbus.DATA[13] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_ds5_door_unlock_check /* 2131429206 */:
                DS5Func.C_CAR_COMPUTER_SET(4, DataCanbus.DATA[16] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_ds5_rijian_xingchedeng_check /* 2131429208 */:
                DS5Func.C_CAR_COMPUTER_SET(5, DataCanbus.DATA[17] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_ds5_dadeng_later_pre /* 2131429209 */:
                if (DataCanbus.DATA[18] == 0) {
                    DS5Func.C_CAR_COMPUTER_SET(6, 3);
                    break;
                } else if (DataCanbus.DATA[18] == 1) {
                    DS5Func.C_CAR_COMPUTER_SET(6, 0);
                    break;
                } else if (DataCanbus.DATA[18] == 2) {
                    DS5Func.C_CAR_COMPUTER_SET(6, 1);
                    break;
                } else if (DataCanbus.DATA[18] == 3) {
                    DS5Func.C_CAR_COMPUTER_SET(6, 2);
                    break;
                }
            case R.id.dongjian_wc2_ds5_dadeng_later_next /* 2131429211 */:
                if (DataCanbus.DATA[18] == 0) {
                    DS5Func.C_CAR_COMPUTER_SET(6, 1);
                    break;
                } else if (DataCanbus.DATA[18] == 1) {
                    DS5Func.C_CAR_COMPUTER_SET(6, 2);
                    break;
                } else if (DataCanbus.DATA[18] == 2) {
                    DS5Func.C_CAR_COMPUTER_SET(6, 3);
                    break;
                } else if (DataCanbus.DATA[18] == 3) {
                    DS5Func.C_CAR_COMPUTER_SET(6, 0);
                    break;
                }
            case R.id.dongjian_wc2_ds5_suidong_dadeng_check /* 2131429212 */:
                DS5Func.C_CAR_COMPUTER_SET(128, DataCanbus.DATA[19] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_zhuche_help_system_check /* 2131429213 */:
                DS5Func.C_CAR_COMPUTER_SET(130, DataCanbus.DATA[20] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_ds5_yingbin_dadeng_pre /* 2131429214 */:
                if (DataCanbus.DATA[21] == 0) {
                    DS5Func.C_CAR_COMPUTER_SET(129, 3);
                    break;
                } else if (DataCanbus.DATA[21] == 1) {
                    DS5Func.C_CAR_COMPUTER_SET(129, 0);
                    break;
                } else if (DataCanbus.DATA[21] == 2) {
                    DS5Func.C_CAR_COMPUTER_SET(129, 1);
                    break;
                } else if (DataCanbus.DATA[21] == 3) {
                    DS5Func.C_CAR_COMPUTER_SET(129, 2);
                    break;
                }
            case R.id.dongjian_wc2_ds5_yingbin_dadeng_next /* 2131429216 */:
                if (DataCanbus.DATA[21] == 0) {
                    DS5Func.C_CAR_COMPUTER_SET(129, 1);
                    break;
                } else if (DataCanbus.DATA[21] == 1) {
                    DS5Func.C_CAR_COMPUTER_SET(129, 2);
                    break;
                } else if (DataCanbus.DATA[21] == 2) {
                    DS5Func.C_CAR_COMPUTER_SET(129, 3);
                    break;
                } else if (DataCanbus.DATA[21] == 3) {
                    DS5Func.C_CAR_COMPUTER_SET(129, 0);
                    break;
                }
            case R.id.dongjian_wc2_car_speed_save_check /* 2131429217 */:
                DS5Func.C_CAR_COMPUTER_SET(144, DataCanbus.DATA[22] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_car_speed_save_m1_check /* 2131429218 */:
                DS5Func.C_CAR_COMPUTER_SET(145, DataCanbus.DATA[23] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_car_speed_save_m2_check /* 2131429219 */:
                DS5Func.C_CAR_COMPUTER_SET(146, DataCanbus.DATA[24] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_car_speed_save_m3_check /* 2131429220 */:
                DS5Func.C_CAR_COMPUTER_SET(147, DataCanbus.DATA[25] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_car_speed_save_m4_check /* 2131429221 */:
                DS5Func.C_CAR_COMPUTER_SET(148, DataCanbus.DATA[26] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_car_speed_save_m5_check /* 2131429222 */:
                DS5Func.C_CAR_COMPUTER_SET(149, DataCanbus.DATA[27] != 0 ? 0 : 1);
                break;
            case R.id.dongjian_wc2_ds5_car_speed_M1_pre /* 2131429223 */:
                if (DataCanbus.DATA[28] - 1 > 40) {
                    DS5Func.C_CAR_COMPUTER_SET(161, DataCanbus.DATA[28] - 1);
                    break;
                }
            case R.id.dongjian_wc2_ds5_car_speed_M1_next /* 2131429225 */:
                if (DataCanbus.DATA[28] + 1 < 180) {
                    DS5Func.C_CAR_COMPUTER_SET(161, DataCanbus.DATA[28] + 1);
                    break;
                }
            case R.id.dongjian_wc2_ds5_car_speed_M2_pre /* 2131429226 */:
                if (DataCanbus.DATA[29] - 1 > 40) {
                    DS5Func.C_CAR_COMPUTER_SET(162, DataCanbus.DATA[29] - 1);
                    break;
                }
            case R.id.dongjian_wc2_ds5_car_speed_M2_next /* 2131429228 */:
                if (DataCanbus.DATA[29] + 1 < 180) {
                    DS5Func.C_CAR_COMPUTER_SET(162, DataCanbus.DATA[29] + 1);
                    break;
                }
            case R.id.dongjian_wc2_ds5_car_speed_M3_pre /* 2131429229 */:
                if (DataCanbus.DATA[30] - 1 > 40) {
                    DS5Func.C_CAR_COMPUTER_SET(163, DataCanbus.DATA[30] - 1);
                    break;
                }
            case R.id.dongjian_wc2_ds5_car_speed_M3_next /* 2131429231 */:
                if (DataCanbus.DATA[30] + 1 < 180) {
                    DS5Func.C_CAR_COMPUTER_SET(163, DataCanbus.DATA[30] + 1);
                    break;
                }
            case R.id.dongjian_wc2_ds5_car_speed_M4_pre /* 2131429232 */:
                if (DataCanbus.DATA[31] - 1 > 40) {
                    DS5Func.C_CAR_COMPUTER_SET(164, DataCanbus.DATA[31] - 1);
                    break;
                }
            case R.id.dongjian_wc2_ds5_car_speed_M4_next /* 2131429234 */:
                if (DataCanbus.DATA[31] + 1 < 180) {
                    DS5Func.C_CAR_COMPUTER_SET(164, DataCanbus.DATA[31] + 1);
                    break;
                }
            case R.id.dongjian_wc2_ds5_car_speed_M5_pre /* 2131429235 */:
                if (DataCanbus.DATA[32] - 1 > 40) {
                    DS5Func.C_CAR_COMPUTER_SET(165, DataCanbus.DATA[32] - 1);
                    break;
                }
            case R.id.dongjian_wc2_ds5_car_speed_M5_next /* 2131429237 */:
                if (DataCanbus.DATA[32] + 1 < 180) {
                    DS5Func.C_CAR_COMPUTER_SET(165, DataCanbus.DATA[32] + 1);
                    break;
                }
        }
    }
}
