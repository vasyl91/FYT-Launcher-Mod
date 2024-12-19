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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class YLInfoSetSecondAct_BNR extends Activity implements View.OnClickListener {
    int[] ids = {124, 125, 126, 127, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.yinglang.YLInfoSetSecondAct_BNR.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            YLInfoSetSecondAct_BNR.this.value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 20:
                    YLInfoSetSecondAct_BNR.this.updaternearCarUnlock();
                    break;
                case 21:
                    YLInfoSetSecondAct_BNR.this.updaterForgotKey();
                    break;
                case 22:
                    YLInfoSetSecondAct_BNR.this.updaterDriverStyle();
                    break;
                case 23:
                    YLInfoSetSecondAct_BNR.this.updaterRelockDoor();
                    break;
                case 24:
                    YLInfoSetSecondAct_BNR.this.updaterautoWipers();
                    break;
                case 25:
                    YLInfoSetSecondAct_BNR.this.updaterblindZone();
                    break;
                case 26:
                    YLInfoSetSecondAct_BNR.this.updaterleaveCarLock();
                    break;
                case 27:
                    YLInfoSetSecondAct_BNR.this.updaterhandTraffic();
                    break;
                case 28:
                    YLInfoSetSecondAct_BNR.this.updateradaptiveForwardLight();
                    break;
                case 29:
                    YLInfoSetSecondAct_BNR.this.updaterMirrorAutoFold();
                    break;
                case 30:
                    YLInfoSetSecondAct_BNR.this.updaterReverTiltMirror();
                    break;
                case 31:
                    YLInfoSetSecondAct_BNR.this.updatereasyExitCar();
                    break;
                case 32:
                    YLInfoSetSecondAct_BNR.this.updaterAutoMemory();
                    break;
                case 124:
                    YLInfoSetSecondAct_BNR.this.uCrashPrepare(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 125:
                    YLInfoSetSecondAct_BNR.this.uRampStartAssist(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 126:
                    YLInfoSetSecondAct_BNR.this.uRemoteDoorWindow(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 127:
                    YLInfoSetSecondAct_BNR.this.uCarState(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 135:
                    YLInfoSetSecondAct_BNR.this.uRemoteAirPower(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 136:
                    YLInfoSetSecondAct_BNR.this.uRemoteRearAirPower(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 137:
                    YLInfoSetSecondAct_BNR.this.uRemoteRearDefrog(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 138:
                    YLInfoSetSecondAct_BNR.this.uAcc(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 139:
                    YLInfoSetSecondAct_BNR.this.uRearSeat(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 140:
                    YLInfoSetSecondAct_BNR.this.uCrashType(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 141:
                    YLInfoSetSecondAct_BNR.this.uWalker(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 142:
                    YLInfoSetSecondAct_BNR.this.uChangeLane(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 143:
                    YLInfoSetSecondAct_BNR.this.uEasyExit(YLInfoSetSecondAct_BNR.this.value);
                    break;
                case 144:
                    YLInfoSetSecondAct_BNR.this.uRearCarPass(YLInfoSetSecondAct_BNR.this.value);
                    break;
            }
        }
    };
    int value;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xp_yl_info_second_set_bnr);
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.wc_weilang_auto_fangzhuang_preper_pre /* 2131431904 */:
            case R.id.wc_weilang_auto_fangzhuang_preper_next /* 2131431906 */:
                int value1 = DataCanbus.DATA[124] + 1;
                if (value1 == 4) {
                    value1 = 3;
                }
                YLFunc.CAR_COMM_CONTROL(25, value1 % 3);
                break;
            case R.id.wc_weilang_car_state_check /* 2131431908 */:
                int value12 = DataCanbus.DATA[127];
                YLFunc.CAR_COMM_CONTROL(26, value12 == 0 ? 1 : 0);
                break;
            case R.id.wc_gm_cruise_check /* 2131431910 */:
                int value13 = DataCanbus.DATA[138];
                YLFunc.CAR_COMM_CONTROL(96, value13 == 0 ? 1 : 0);
                break;
            case R.id.wc_weilang_remote_car_window_control_check /* 2131432023 */:
                int value14 = DataCanbus.DATA[126];
                YLFunc.CAR_COMM_CONTROL(27, value14 == 0 ? 1 : 0);
                break;
            case R.id.xfl_ck_air_rear_window_auto_foggest_check /* 2131432890 */:
                int value15 = DataCanbus.DATA[137];
                YLFunc.CAR_AIR_CONTROL(98, value15 == 0 ? 1 : 0);
                break;
            case R.id.rzc_gl8_remote_start_air /* 2131433479 */:
                int value16 = DataCanbus.DATA[135];
                YLFunc.CAR_AIR_CONTROL(96, value16 == 0 ? 1 : 0);
                break;
            case R.id.rzc_gl8_start_rear_air /* 2131433481 */:
                int value17 = DataCanbus.DATA[136] + 1;
                YLFunc.CAR_AIR_CONTROL(97, value17 % 3);
                break;
            case R.id.xp_yl_lane_assist_pre /* 2131433517 */:
            case R.id.xp_yl_lane_assist_next /* 2131433519 */:
                int value18 = DataCanbus.DATA[125];
                YLFunc.CAR_COMM_CONTROL(28, value18 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_Near_car_unlocked_set_check /* 2131433526 */:
                int value19 = DataCanbus.DATA[20];
                YLFunc.CAR_COMM_CONTROL(12, value19 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_remote_Forgotten_Keys_check /* 2131433528 */:
                int value2 = DataCanbus.DATA[21];
                YLFunc.CAR_COMM_CONTROL(13, value2 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_PERSONALIZATION_BY_DRIVER_check /* 2131433530 */:
                int value3 = DataCanbus.DATA[22];
                YLFunc.CAR_COMM_CONTROL(14, value3 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_AUTO_RELOCK_DOORS_check /* 2131433532 */:
                int value4 = DataCanbus.DATA[23];
                YLFunc.CAR_COMM_CONTROL(15, value4 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_car_set_Second_auto_rain_refresh_check /* 2131433534 */:
                int value5 = DataCanbus.DATA[24];
                YLFunc.CAR_COMM_CONTROL(24, value5 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_Side_blind_zone_check /* 2131433536 */:
                int value6 = DataCanbus.DATA[25];
                YLFunc.CAR_COMM_CONTROL(22, value6 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_leave_door_latch_pre /* 2131433538 */:
                int value132 = DataCanbus.DATA[26];
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
            case R.id.xp_yl_leave_door_latch_next /* 2131433540 */:
                int value142 = DataCanbus.DATA[26];
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
            case R.id.xp_yinglang_left_right_traffic_check /* 2131433542 */:
                int value7 = DataCanbus.DATA[27];
                YLFunc.CAR_COMM_CONTROL(16, value7 == 0 ? 1 : 0);
                break;
            case R.id.xp_yinglang_adaptive_forward_lighting_check /* 2131433545 */:
                int value8 = DataCanbus.DATA[28];
                YLFunc.CAR_COMM_CONTROL(17, value8 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_comfort_Automatic_folding_mirrors_check /* 2131433548 */:
                int value9 = DataCanbus.DATA[29];
                YLFunc.CAR_COMM_CONTROL(18, value9 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_comfort_Mirror_reversing_automatic_tilt_check /* 2131433550 */:
                int value10 = DataCanbus.DATA[30];
                YLFunc.CAR_COMM_CONTROL(19, value10 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_easy_exit_check /* 2131433552 */:
                int value11 = DataCanbus.DATA[31];
                YLFunc.CAR_COMM_CONTROL(20, value11 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_auto_memory_check /* 2131433554 */:
                int value122 = DataCanbus.DATA[32];
                YLFunc.CAR_COMM_CONTROL(21, value122 == 0 ? 1 : 0);
                break;
            case R.id.wc_gm_rearseat_reminder /* 2131433556 */:
                int value110 = DataCanbus.DATA[139];
                YLFunc.CAR_COMM_CONTROL(97, value110 == 0 ? 1 : 0);
                break;
            case R.id.wc_gm_crash_remind_type /* 2131433558 */:
                int value111 = DataCanbus.DATA[140];
                YLFunc.CAR_COMM_CONTROL(98, value111 == 0 ? 1 : 0);
                break;
            case R.id.wc_gm_walker_m /* 2131433561 */:
            case R.id.wc_gm_walker_p /* 2131433563 */:
                int value112 = DataCanbus.DATA[141] + 1;
                YLFunc.CAR_COMM_CONTROL(99, value112 % 3);
                break;
            case R.id.ctv_sb_so3_change_wall_warm /* 2131433565 */:
                int value113 = DataCanbus.DATA[142];
                YLFunc.CAR_COMM_CONTROL(100, value113 == 0 ? 1 : 0);
                break;
            case R.id.ctv_sb_so3_back_car_accose_warm /* 2131433567 */:
                int value114 = DataCanbus.DATA[144];
                YLFunc.CAR_COMM_CONTROL(102, value114 == 0 ? 1 : 0);
                break;
        }
    }

    @Override // android.app.Activity
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

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    private void addUpdater() {
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
        for (int i = 0; i < this.ids.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.ids[i]].addNotify(this.mNotifyCanbus, 1);
        }
    }

    private void removeUpdater() {
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
        for (int i = 0; i < this.ids.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.ids[i]].removeNotify(this.mNotifyCanbus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaternearCarUnlock() {
        int switchOn = DataCanbus.DATA[20];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterForgotKey() {
        int switchOn = DataCanbus.DATA[21];
        ((CheckedTextView) findViewById(R.id.xp_yl_remote_Forgotten_Keys_check)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterDriverStyle() {
        int switchOn = DataCanbus.DATA[22];
        ((CheckedTextView) findViewById(R.id.xp_yl_PERSONALIZATION_BY_DRIVER_check)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRelockDoor() {
        int switchOn = DataCanbus.DATA[23];
        ((CheckedTextView) findViewById(R.id.xp_yl_AUTO_RELOCK_DOORS_check)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterautoWipers() {
        int switchOn = DataCanbus.DATA[24];
        ((CheckedTextView) findViewById(R.id.xp_yl_car_set_Second_auto_rain_refresh_check)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterblindZone() {
        int switchOn = DataCanbus.DATA[25];
        ((CheckedTextView) findViewById(R.id.xp_yl_Side_blind_zone_check)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterleaveCarLock() {
        int switchOn = DataCanbus.DATA[26];
        if (switchOn == 0) {
            ((TextView) findViewById(R.id.xp_yl_leave_door_latch_tv)).setText(R.string.klc_onstar_close);
        } else if (switchOn == 1) {
            ((TextView) findViewById(R.id.xp_yl_leave_door_latch_tv)).setText(R.string.xp_yinglang_car_set_Second_str9);
        } else if (switchOn == 2) {
            ((TextView) findViewById(R.id.xp_yl_leave_door_latch_tv)).setText(R.string.klc_remote_Smart_from_the_car_latch_Speaker_tweet_enabled);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterhandTraffic() {
        int switchOn = DataCanbus.DATA[27];
        if (switchOn == 0) {
            ((CheckedTextView) findViewById(R.id.xp_yinglang_left_right_traffic_check)).setChecked(false);
            ((TextView) findViewById(R.id.xp_yinglang_left_right_traffic_Tv)).setText(R.string.xp_yinglang_car_set_Second_str2);
        } else if (switchOn == 1) {
            ((CheckedTextView) findViewById(R.id.xp_yinglang_left_right_traffic_check)).setChecked(true);
            ((TextView) findViewById(R.id.xp_yinglang_left_right_traffic_Tv)).setText(R.string.xp_yinglang_car_set_Second_str3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateradaptiveForwardLight() {
        int switchOn = DataCanbus.DATA[28];
        if (switchOn == 0) {
            ((CheckedTextView) findViewById(R.id.xp_yinglang_adaptive_forward_lighting_check)).setChecked(false);
            ((TextView) findViewById(R.id.xp_yinglang_adaptive_forward_lighting_Tv)).setText(R.string.xp_yinglang_car_set_Second_str5);
        } else if (switchOn == 1) {
            ((CheckedTextView) findViewById(R.id.xp_yinglang_adaptive_forward_lighting_check)).setChecked(true);
            ((TextView) findViewById(R.id.xp_yinglang_adaptive_forward_lighting_Tv)).setText(R.string.xp_yinglang_car_set_Second_str6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterMirrorAutoFold() {
        int switchOn = DataCanbus.DATA[29];
        ((CheckedTextView) findViewById(R.id.xp_yl_comfort_Automatic_folding_mirrors_check)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterReverTiltMirror() {
        int switchOn = DataCanbus.DATA[30];
        ((CheckedTextView) findViewById(R.id.xp_yl_comfort_Mirror_reversing_automatic_tilt_check)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatereasyExitCar() {
        int switchOn = DataCanbus.DATA[31];
        ((CheckedTextView) findViewById(R.id.xp_yl_easy_exit_check)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoMemory() {
        int switchOn = DataCanbus.DATA[32];
        ((CheckedTextView) findViewById(R.id.xp_yl_auto_memory_check)).setChecked(switchOn != 0);
    }
}
