package com.syu.carinfo.xp.yinglang;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class YLInfoSetSecondAct_BNR extends Activity implements View.OnClickListener {
    int[] ids = {185, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201};
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            YLInfoSetSecondAct_BNR.this.value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 117:
                    YLInfoSetSecondAct_BNR.this.updaternearCarUnlock();
                    break;
                case 118:
                    YLInfoSetSecondAct_BNR.this.updaterForgotKey();
                    break;
                case 119:
                    YLInfoSetSecondAct_BNR.this.updaterDriverStyle();
                    break;
                case 120:
                    YLInfoSetSecondAct_BNR.this.updaterRelockDoor();
                    break;
                case 121:
                    YLInfoSetSecondAct_BNR.this.updaterautoWipers();
                    break;
                case 122:
                    YLInfoSetSecondAct_BNR.this.updaterblindZone();
                    break;
                case 123:
                    YLInfoSetSecondAct_BNR.this.updaterleaveCarLock();
                    break;
                case 124:
                    YLInfoSetSecondAct_BNR.this.updaterhandTraffic();
                    break;
                case 125:
                    YLInfoSetSecondAct_BNR.this.updateradaptiveForwardLight();
                    break;
                case 126:
                    YLInfoSetSecondAct_BNR.this.updaterMirrorAutoFold();
                    break;
                case 127:
                    YLInfoSetSecondAct_BNR.this.updaterReverTiltMirror();
                    break;
                case 128:
                    YLInfoSetSecondAct_BNR.this.updatereasyExitCar();
                    break;
                case 129:
                    YLInfoSetSecondAct_BNR.this.updaterAutoMemory();
                    break;
                case 185:
                    YLInfoSetSecondAct_BNR.this.uCrashPrepare(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 189:
                    YLInfoSetSecondAct_BNR.this.uRampStartAssist(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 190:
                    YLInfoSetSecondAct_BNR.this.uRemoteDoorWindow(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 191:
                    YLInfoSetSecondAct_BNR.this.uCarState(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 192:
                    YLInfoSetSecondAct_BNR.this.uRemoteAirPower(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 193:
                    YLInfoSetSecondAct_BNR.this.uRemoteRearAirPower(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 194:
                    YLInfoSetSecondAct_BNR.this.uRemoteRearDefrog(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 195:
                    YLInfoSetSecondAct_BNR.this.uAcc(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 196:
                    YLInfoSetSecondAct_BNR.this.uRearSeat(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 197:
                    YLInfoSetSecondAct_BNR.this.uCrashType(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 198:
                    YLInfoSetSecondAct_BNR.this.uWalker(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 199:
                    YLInfoSetSecondAct_BNR.this.uChangeLane(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 200:
                    YLInfoSetSecondAct_BNR.this.uEasyExit(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 201:
                    YLInfoSetSecondAct_BNR.this.uRearCarPass(YLInfoSetSecondAct_BNR.this.value);
                    break;
            }
        }
    };
    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_xp_yl_info_second_set_bnr);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.xp_yl_Near_car_unlocked_set_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.xp_yl_remote_Forgotten_Keys_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.xp_yl_PERSONALIZATION_BY_DRIVER_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.xp_yl_AUTO_RELOCK_DOORS_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.xp_yl_car_set_Second_auto_rain_refresh_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.xp_yl_Side_blind_zone_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.xp_yinglang_left_right_traffic_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.xp_yinglang_adaptive_forward_lighting_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.xp_yl_comfort_Automatic_folding_mirrors_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.xp_yl_comfort_Mirror_reversing_automatic_tilt_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.xp_yl_easy_exit_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.xp_yl_auto_memory_check)).setOnClickListener(this);
        ((Button) findViewById(R.id.xp_yl_leave_door_latch_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.xp_yl_leave_door_latch_next)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.wc_weilang_remote_car_window_control_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.wc_weilang_car_state_check)).setOnClickListener(this);
        ((Button) findViewById(R.id.xp_yl_lane_assist_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.xp_yl_lane_assist_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.wc_weilang_auto_fangzhuang_preper_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.wc_weilang_auto_fangzhuang_preper_pre)).setOnClickListener(this);
        findViewById(R.id.rzc_gl8_remote_start_air).setOnClickListener(this);
        findViewById(R.id.rzc_gl8_start_rear_air).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.xfl_ck_air_rear_window_auto_foggest_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.wc_gm_cruise_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.wc_gm_rearseat_reminder)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_sb_so3_change_wall_warm)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.wc_gm_crash_remind_type)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_sb_so3_back_car_accose_warm)).setOnClickListener(this);
        ((Button) findViewById(R.id.wc_gm_walker_m)).setOnClickListener(this);
        ((Button) findViewById(R.id.wc_gm_walker_p)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.wc_weilang_remote_car_window_control_check /* 2131431973 */:
                int value1 = DataCanbus.DATA[190];
                YLFunc.CAR_COMM_CONTROL(27, value1 == 0 ? 1 : 0);
                break;
            case R.id.xfl_ck_air_rear_window_auto_foggest_check /* 2131432816 */:
                int value12 = DataCanbus.DATA[194];
                YLFunc.CAR_AIR_CONTROL(98, value12 == 0 ? 1 : 0);
                break;
            case R.id.rzc_gl8_remote_start_air /* 2131433401 */:
                int value13 = DataCanbus.DATA[192];
                YLFunc.CAR_AIR_CONTROL(96, value13 == 0 ? 1 : 0);
                break;
            case R.id.rzc_gl8_start_rear_air /* 2131433403 */:
                int value14 = DataCanbus.DATA[193] + 1;
                YLFunc.CAR_AIR_CONTROL(97, value14 % 3);
                break;
            case R.id.xp_yl_lane_assist_pre /* 2131433431 */:
            case R.id.xp_yl_lane_assist_next /* 2131433433 */:
                int value15 = DataCanbus.DATA[189];
                YLFunc.CAR_COMM_CONTROL(28, value15 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_Near_car_unlocked_set_check /* 2131433441 */:
                int value16 = DataCanbus.DATA[117];
                YLFunc.CAR_COMM_CONTROL(12, value16 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_remote_Forgotten_Keys_check /* 2131433444 */:
                int value2 = DataCanbus.DATA[118];
                YLFunc.CAR_COMM_CONTROL(13, value2 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_PERSONALIZATION_BY_DRIVER_check /* 2131433446 */:
                int value3 = DataCanbus.DATA[119];
                YLFunc.CAR_COMM_CONTROL(14, value3 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_AUTO_RELOCK_DOORS_check /* 2131433448 */:
                int value4 = DataCanbus.DATA[120];
                YLFunc.CAR_COMM_CONTROL(15, value4 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_car_set_Second_auto_rain_refresh_check /* 2131433450 */:
                int value5 = DataCanbus.DATA[121];
                YLFunc.CAR_COMM_CONTROL(24, value5 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_Side_blind_zone_check /* 2131433452 */:
                int value6 = DataCanbus.DATA[122];
                YLFunc.CAR_COMM_CONTROL(22, value6 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_leave_door_latch_pre /* 2131433454 */:
                int value132 = DataCanbus.DATA[123];
                if (value132 == 0) {
                    YLFunc.CAR_COMM_CONTROL(23, 2);
                    break;
                } else if (value132 == 1) {
                    YLFunc.CAR_COMM_CONTROL(23, 0);
                    break;
                } else if (value132 == 2) {
                    YLFunc.CAR_COMM_CONTROL(23, 1);
                    break;
                }
            case R.id.xp_yl_leave_door_latch_next /* 2131433456 */:
                int value142 = DataCanbus.DATA[123];
                if (value142 == 0) {
                    YLFunc.CAR_COMM_CONTROL(23, 1);
                    break;
                } else if (value142 == 1) {
                    YLFunc.CAR_COMM_CONTROL(23, 2);
                    break;
                } else if (value142 == 2) {
                    YLFunc.CAR_COMM_CONTROL(23, 0);
                    break;
                }
            case R.id.xp_yinglang_left_right_traffic_check /* 2131433458 */:
                int value7 = DataCanbus.DATA[124];
                YLFunc.CAR_COMM_CONTROL(16, value7 == 0 ? 1 : 0);
                break;
            case R.id.xp_yinglang_adaptive_forward_lighting_check /* 2131433461 */:
                int value8 = DataCanbus.DATA[125];
                YLFunc.CAR_COMM_CONTROL(17, value8 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_comfort_Automatic_folding_mirrors_check /* 2131433464 */:
                int value9 = DataCanbus.DATA[126];
                YLFunc.CAR_COMM_CONTROL(18, value9 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_comfort_Mirror_reversing_automatic_tilt_check /* 2131433466 */:
                int value10 = DataCanbus.DATA[127];
                YLFunc.CAR_COMM_CONTROL(19, value10 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_easy_exit_check /* 2131433468 */:
                int value11 = DataCanbus.DATA[128];
                YLFunc.CAR_COMM_CONTROL(20, value11 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_auto_memory_check /* 2131433470 */:
                int value122 = DataCanbus.DATA[129];
                YLFunc.CAR_COMM_CONTROL(21, value122 == 0 ? 1 : 0);
                break;
            case R.id.wc_weilang_auto_fangzhuang_preper_pre /* 2131433472 */:
            case R.id.wc_weilang_auto_fangzhuang_preper_next /* 2131433474 */:
                int value17 = DataCanbus.DATA[185] + 1;
                if (value17 == 4) {
                    value17 = 3;
                }
                YLFunc.CAR_COMM_CONTROL(25, value17 % 3);
                break;
            case R.id.wc_weilang_car_state_check /* 2131433476 */:
                int value18 = DataCanbus.DATA[191];
                YLFunc.CAR_COMM_CONTROL(26, value18 == 0 ? 1 : 0);
                break;
            case R.id.wc_gm_cruise_check /* 2131433478 */:
                int value19 = DataCanbus.DATA[195];
                YLFunc.CAR_COMM_CONTROL(96, value19 == 0 ? 1 : 0);
                break;
            case R.id.wc_gm_rearseat_reminder /* 2131433480 */:
                int value110 = DataCanbus.DATA[196];
                YLFunc.CAR_COMM_CONTROL(97, value110 == 0 ? 1 : 0);
                break;
            case R.id.wc_gm_crash_remind_type /* 2131433482 */:
                int value111 = DataCanbus.DATA[197];
                YLFunc.CAR_COMM_CONTROL(98, value111 == 0 ? 1 : 0);
                break;
            case R.id.wc_gm_walker_m /* 2131433485 */:
            case R.id.wc_gm_walker_p /* 2131433487 */:
                int value112 = DataCanbus.DATA[198] + 1;
                YLFunc.CAR_COMM_CONTROL(99, value112 % 3);
                break;
            case R.id.ctv_sb_so3_change_wall_warm /* 2131433489 */:
                int value113 = DataCanbus.DATA[199];
                YLFunc.CAR_COMM_CONTROL(100, value113 == 0 ? 1 : 0);
                break;
            case R.id.ctv_sb_so3_back_car_accose_warm /* 2131433491 */:
                int value114 = DataCanbus.DATA[201];
                YLFunc.CAR_COMM_CONTROL(102, value114 == 0 ? 1 : 0);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        addUpdater();
        if (DataCanbus.DATA[1000] == 2294139) {
            findViewById(R.id.xp_yl_Near_car_unlocked_set).setVisibility(8);
            findViewById(R.id.xp_yl_PERSONALIZATION_BY_DRIVER).setVisibility(8);
            findViewById(R.id.xp_yl_car_set_Second_auto_rain_refresh_set).setVisibility(8);
            findViewById(R.id.xp_yl_leave_door_latch_set).setVisibility(8);
            findViewById(R.id.xp_yinglang_left_right_traffic_set).setVisibility(8);
            findViewById(R.id.xp_yinglang_adaptive_forward_lighting_set).setVisibility(8);
            findViewById(R.id.xp_yl_comfort_Automatic_folding_mirrors_set).setVisibility(8);
            findViewById(R.id.xp_yl_comfort_Mirror_reversing_automatic_tilt_set).setVisibility(8);
            findViewById(R.id.xp_yl_easy_exit_set).setVisibility(8);
            findViewById(R.id.xp_yl_auto_memory_set).setVisibility(8);
            findViewById(R.id.wc_weilang_auto_fangzhuang_preper_view).setVisibility(8);
            findViewById(R.id.xp_yl_lane_assist).setVisibility(8);
            findViewById(R.id.wc_weilang_car_state_view).setVisibility(8);
            findViewById(R.id.rzc_gl8_remote_start_air).setVisibility(8);
            findViewById(R.id.rzc_gl8_start_rear_air).setVisibility(8);
            findViewById(R.id.wc_gm_cruise_view).setVisibility(8);
            findViewById(R.id.wc_gm_rearseat_reminder_view).setVisibility(8);
            findViewById(R.id.wc_gm_crash_remind_type_view).setVisibility(8);
            findViewById(R.id.wc_gm_walker_view).setVisibility(8);
            findViewById(R.id.ctv_change_wall_warm_view).setVisibility(8);
            findViewById(R.id.ctv_back_car_accose_warm_view).setVisibility(8);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    private void addUpdater() {
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
        for (int i = 0; i < this.ids.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.ids[i]].addNotify(this.mNotifyCanbus, 1);
        }
    }

    private void removeUpdater() {
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
        for (int i = 0; i < this.ids.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.ids[i]].removeNotify(this.mNotifyCanbus);
        }
    }

    
    public void updaternearCarUnlock() {
        int switchOn = DataCanbus.DATA[117];
        if (switchOn == 0) {
            ((CheckedTextView) findViewById(R.id.xp_yl_Near_car_unlocked_set_check)).setChecked(false);
            ((TextView) findViewById(R.id.xp_yl_Near_car_unlocked_set_tv)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
        } else if (switchOn == 1) {
            ((CheckedTextView) findViewById(R.id.xp_yl_Near_car_unlocked_set_check)).setChecked(true);
            ((TextView) findViewById(R.id.xp_yl_Near_car_unlocked_set_tv)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
        }
    }

    protected void uRearCarPass(int val) {
        setcheck((CheckedTextView) findViewById(R.id.ctv_sb_so3_back_car_accose_warm), val != 0);
    }

    protected void uEasyExit(int val) {
        setcheck((CheckedTextView) findViewById(R.id.xp_yl_easy_exit_check), val != 0);
    }

    protected void uChangeLane(int val) {
        setcheck((CheckedTextView) findViewById(R.id.ctv_sb_so3_change_wall_warm), val != 0);
    }

    protected void uWalker(int val) {
        TextView v = (TextView) findViewById(R.id.wc_gm_walker_txt);
        if (v != null) {
            int id = R.string.off;
            if (val == 1) {
                id = R.string.wc_weilang_auto_fangzhuang_warn;
            } else if (val == 2) {
                id = R.string.wc_weilang_auto_fangzhuang_warn_and_zhidong;
            }
            v.setText(id);
        }
    }

    protected void uCrashType(int val) {
        setcheck((CheckedTextView) findViewById(R.id.wc_gm_crash_remind_type), val != 0);
        TextView v = (TextView) findViewById(R.id.wc_gm_crash_remind_type_txt);
        if (v != null) {
            v.setText(val == 0 ? R.string.str_379_str_2 : R.string.str_379_str_3);
        }
    }

    protected void uRearSeat(int val) {
        setcheck((CheckedTextView) findViewById(R.id.wc_gm_rearseat_reminder), val != 0);
    }

    protected void uAcc(int val) {
        setcheck((CheckedTextView) findViewById(R.id.wc_gm_cruise_check), val != 0);
    }

    protected void uRemoteRearDefrog(int val) {
        setcheck((CheckedTextView) findViewById(R.id.xfl_ck_air_rear_window_auto_foggest_check), val == 1);
    }

    private void setcheck(CheckedTextView v, boolean on) {
        if (v != null) {
            v.setChecked(on);
        }
    }

    protected void uRemoteAirPower(int val) {
        TextView v = (TextView) findViewById(R.id.rzc_gl8_remote_start_air_tip);
        if (v != null) {
            v.setText(val == 0 ? R.string.klc_air_auto : R.string.klc_air_last_set);
        }
    }

    protected void uRemoteRearAirPower(int val) {
        TextView v = (TextView) findViewById(R.id.rzc_gl8_start_rear_air_tip);
        if (v != null) {
            int id = R.string.str_rzc_17gl8_str1;
            if (val == 1) {
                id = R.string.str_rzc_17gl8_str2;
            } else if (val == 2) {
                id = R.string.str_rzc_17gl8_str3;
            }
            v.setText(id);
        }
    }

    protected void uCarState(int val) {
        if (((CheckedTextView) findViewById(R.id.wc_weilang_car_state_check)) != null) {
            ((CheckedTextView) findViewById(R.id.wc_weilang_car_state_check)).setChecked(val != 0);
        }
    }

    protected void uRemoteDoorWindow(int val) {
        if (((CheckedTextView) findViewById(R.id.wc_weilang_remote_car_window_control_check)) != null) {
            ((CheckedTextView) findViewById(R.id.wc_weilang_remote_car_window_control_check)).setChecked(val != 0);
        }
    }

    protected void uRampStartAssist(int val) {
        TextView v = (TextView) findViewById(R.id.xp_yl_lane_assist_tv);
        if (v != null) {
            v.setText(val == 0 ? R.string.xp_yl_lane_assist_str2 : R.string.xp_yl_lane_assist_str1);
        }
    }

    protected void uCrashPrepare(int val) {
        TextView v = (TextView) findViewById(R.id.wc_weilang_auto_fangzhuang_preper_TV);
        if (v != null) {
            int s = R.string.off;
            if (val == 1) {
                s = R.string.wc_weilang_auto_fangzhuang_warn;
            } else if (val == 3) {
                s = R.string.wc_weilang_auto_fangzhuang_warn_and_zhidong;
            }
            v.setText(s);
        }
    }

    
    public void updaterForgotKey() {
        int switchOn = DataCanbus.DATA[118];
        ((CheckedTextView) findViewById(R.id.xp_yl_remote_Forgotten_Keys_check)).setChecked(switchOn != 0);
    }

    
    public void updaterDriverStyle() {
        int switchOn = DataCanbus.DATA[119];
        ((CheckedTextView) findViewById(R.id.xp_yl_PERSONALIZATION_BY_DRIVER_check)).setChecked(switchOn != 0);
    }

    
    public void updaterRelockDoor() {
        int switchOn = DataCanbus.DATA[120];
        ((CheckedTextView) findViewById(R.id.xp_yl_AUTO_RELOCK_DOORS_check)).setChecked(switchOn != 0);
    }

    
    public void updaterautoWipers() {
        int switchOn = DataCanbus.DATA[121];
        ((CheckedTextView) findViewById(R.id.xp_yl_car_set_Second_auto_rain_refresh_check)).setChecked(switchOn != 0);
    }

    
    public void updaterblindZone() {
        int switchOn = DataCanbus.DATA[122];
        ((CheckedTextView) findViewById(R.id.xp_yl_Side_blind_zone_check)).setChecked(switchOn != 0);
    }

    
    public void updaterleaveCarLock() {
        int switchOn = DataCanbus.DATA[123];
        if (switchOn == 0) {
            ((TextView) findViewById(R.id.xp_yl_leave_door_latch_tv)).setText(R.string.klc_onstar_close);
        } else if (switchOn == 1) {
            ((TextView) findViewById(R.id.xp_yl_leave_door_latch_tv)).setText(R.string.xp_yinglang_car_set_Second_str9);
        } else if (switchOn == 2) {
            ((TextView) findViewById(R.id.xp_yl_leave_door_latch_tv)).setText(R.string.klc_remote_Smart_from_the_car_latch_Speaker_tweet_enabled);
        }
    }

    
    public void updaterhandTraffic() {
        int switchOn = DataCanbus.DATA[124];
        if (switchOn == 0) {
            ((CheckedTextView) findViewById(R.id.xp_yinglang_left_right_traffic_check)).setChecked(false);
            ((TextView) findViewById(R.id.xp_yinglang_left_right_traffic_Tv)).setText(R.string.xp_yinglang_car_set_Second_str2);
        } else if (switchOn == 1) {
            ((CheckedTextView) findViewById(R.id.xp_yinglang_left_right_traffic_check)).setChecked(true);
            ((TextView) findViewById(R.id.xp_yinglang_left_right_traffic_Tv)).setText(R.string.xp_yinglang_car_set_Second_str3);
        }
    }

    
    public void updateradaptiveForwardLight() {
        int switchOn = DataCanbus.DATA[125];
        if (switchOn == 0) {
            ((CheckedTextView) findViewById(R.id.xp_yinglang_adaptive_forward_lighting_check)).setChecked(false);
            ((TextView) findViewById(R.id.xp_yinglang_adaptive_forward_lighting_Tv)).setText(R.string.xp_yinglang_car_set_Second_str5);
        } else if (switchOn == 1) {
            ((CheckedTextView) findViewById(R.id.xp_yinglang_adaptive_forward_lighting_check)).setChecked(true);
            ((TextView) findViewById(R.id.xp_yinglang_adaptive_forward_lighting_Tv)).setText(R.string.xp_yinglang_car_set_Second_str6);
        }
    }

    
    public void updaterMirrorAutoFold() {
        int switchOn = DataCanbus.DATA[126];
        ((CheckedTextView) findViewById(R.id.xp_yl_comfort_Automatic_folding_mirrors_check)).setChecked(switchOn != 0);
    }

    
    public void updaterReverTiltMirror() {
        int switchOn = DataCanbus.DATA[127];
        ((CheckedTextView) findViewById(R.id.xp_yl_comfort_Mirror_reversing_automatic_tilt_check)).setChecked(switchOn != 0);
    }

    
    public void updatereasyExitCar() {
        int switchOn = DataCanbus.DATA[128];
        ((CheckedTextView) findViewById(R.id.xp_yl_easy_exit_check)).setChecked(switchOn != 0);
    }

    
    public void updaterAutoMemory() {
        int switchOn = DataCanbus.DATA[129];
        ((CheckedTextView) findViewById(R.id.xp_yl_auto_memory_check)).setChecked(switchOn != 0);
    }
}
