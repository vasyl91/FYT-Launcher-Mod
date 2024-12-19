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
public class YLInfoSetSecondAct extends Activity implements View.OnClickListener {
    private boolean bRzc_Gl8;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.yinglang.YLInfoSetSecondAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 20:
                    YLInfoSetSecondAct.this.updaternearCarUnlock();
                    break;
                case 21:
                    YLInfoSetSecondAct.this.updaterForgotKey();
                    break;
                case 22:
                    YLInfoSetSecondAct.this.updaterDriverStyle();
                    break;
                case 23:
                    YLInfoSetSecondAct.this.updaterRelockDoor();
                    break;
                case 24:
                    YLInfoSetSecondAct.this.updaterautoWipers();
                    break;
                case 25:
                    YLInfoSetSecondAct.this.updaterblindZone();
                    break;
                case 26:
                    YLInfoSetSecondAct.this.updaterleaveCarLock();
                    break;
                case 27:
                    YLInfoSetSecondAct.this.updaterhandTraffic();
                    break;
                case 28:
                    YLInfoSetSecondAct.this.updateradaptiveForwardLight();
                    break;
                case 29:
                    YLInfoSetSecondAct.this.updaterMirrorAutoFold();
                    break;
                case 30:
                    YLInfoSetSecondAct.this.updaterReverTiltMirror();
                    break;
                case 31:
                    YLInfoSetSecondAct.this.updatereasyExitCar();
                    break;
                case 32:
                    YLInfoSetSecondAct.this.updaterAutoMemory();
                    break;
                case 66:
                    YLInfoSetSecondAct.this.updaterblindZoneAble();
                    break;
                case 68:
                    YLInfoSetSecondAct.this.updaterDriverStyleAble();
                    break;
                case 69:
                    YLInfoSetSecondAct.this.updaterAutoMemoryAble();
                    break;
                case 70:
                    YLInfoSetSecondAct.this.updatereasyExitCarAble();
                    break;
                case 71:
                    YLInfoSetSecondAct.this.updaterReverTiltMirrorAble();
                    break;
                case 72:
                    YLInfoSetSecondAct.this.updaterMirrorAutoFoldAble();
                    break;
                case 73:
                    YLInfoSetSecondAct.this.updaterautoWipersAble();
                    break;
                case 83:
                    YLInfoSetSecondAct.this.updaterRelockDoorAble();
                    break;
                case 84:
                    YLInfoSetSecondAct.this.updaternearCarUnlockAble();
                    break;
                case 85:
                    YLInfoSetSecondAct.this.updaterForgotKeyAble();
                    break;
                case 86:
                    YLInfoSetSecondAct.this.updaterleaveCarLockAble();
                    break;
                case 122:
                    YLInfoSetSecondAct.this.uCrashPrepare(DataCanbus.DATA[122]);
                    break;
                case 123:
                    YLInfoSetSecondAct.this.updaterAutoAnticrashPrepare();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xp_yl_info_second_set);
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
        this.bRzc_Gl8 = DataCanbus.DATA[1000] == 262407 || DataCanbus.DATA[1000] == 327943 || DataCanbus.DATA[1000] == 655623 || DataCanbus.DATA[1000] == 524551 || DataCanbus.DATA[1000] == 590087 || DataCanbus.DATA[1000] == 393479;
        ((Button) findViewById(R.id.wc_weilang_auto_fangzhuang_preper_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.wc_weilang_auto_fangzhuang_preper_pre)).setOnClickListener(this);
        if (DataCanbus.DATA[1000] == 364 || DataCanbus.DATA[1000] == 65900 || DataCanbus.DATA[1000] == 131436) {
            findViewById(R.id.xp_yl_easy_exit_set).setVisibility(8);
            findViewById(R.id.xp_yl_auto_memory_set).setVisibility(8);
            findViewById(R.id.xp_yinglang_left_right_traffic_set).setVisibility(8);
            findViewById(R.id.xp_yinglang_adaptive_forward_lighting_set).setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.wc_weilang_auto_fangzhuang_preper_pre /* 2131431904 */:
                if (DataCanbus.DATA[1000] == 364 || DataCanbus.DATA[1000] == 65900 || DataCanbus.DATA[1000] == 131436 || this.bRzc_Gl8 || (DataCanbus.DATA[1000] & 65535) == 61) {
                    int value1 = DataCanbus.DATA[122] - 1;
                    if (value1 < 0) {
                        value1 = 2;
                    }
                    YLFunc.CAR_COMM_CONTROL(24, value1);
                    break;
                } else {
                    int value12 = DataCanbus.DATA[122] + 1;
                    if (value12 == 4) {
                        value12 = 3;
                    }
                    YLFunc.CAR_COMM_CONTROL(25, value12 % 3);
                    break;
                }
            case R.id.wc_weilang_auto_fangzhuang_preper_next /* 2131431906 */:
                int value13 = DataCanbus.DATA[122] + 1;
                if (DataCanbus.DATA[1000] == 364 || DataCanbus.DATA[1000] == 65900 || DataCanbus.DATA[1000] == 131436 || this.bRzc_Gl8 || (DataCanbus.DATA[1000] & 65535) == 61) {
                    if (value13 > 2) {
                        value13 = 0;
                    }
                    YLFunc.CAR_COMM_CONTROL(24, value13);
                    break;
                } else {
                    if (value13 == 4) {
                        value13 = 3;
                    }
                    YLFunc.CAR_COMM_CONTROL(25, value13 % 3);
                    break;
                }
            case R.id.xp_yl_Near_car_unlocked_set_check /* 2131433526 */:
                YLFunc.CAR_COMM_CONTROL(12, DataCanbus.DATA[20] == 0 ? 1 : 0);
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
                if (DataCanbus.DATA[1000] == 364 || DataCanbus.DATA[1000] == 65900 || DataCanbus.DATA[1000] == 131436 || this.bRzc_Gl8 || (DataCanbus.DATA[1000] & 65535) == 61) {
                    YLFunc.CAR_COMM_CONTROL(26, value5 == 0 ? 1 : 0);
                    break;
                } else {
                    YLFunc.CAR_COMM_CONTROL(24, value5 == 0 ? 1 : 0);
                    break;
                }
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
                int value14 = DataCanbus.DATA[26];
                if (value14 == 0) {
                    YLFunc.CAR_COMM_CONTROL(23, 1);
                    break;
                } else if (value14 == 1) {
                    YLFunc.CAR_COMM_CONTROL(23, 2);
                    break;
                } else if (value14 == 2) {
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
                if (DataCanbus.DATA[1000] == 364 || DataCanbus.DATA[1000] == 65900 || DataCanbus.DATA[1000] == 131436 || this.bRzc_Gl8 || (DataCanbus.DATA[1000] & 65535) == 61) {
                    YLFunc.CAR_COMM_CONTROL(91, value9 == 0 ? 1 : 0);
                    break;
                } else {
                    YLFunc.CAR_COMM_CONTROL(18, value9 == 0 ? 1 : 0);
                    break;
                }
            case R.id.xp_yl_comfort_Mirror_reversing_automatic_tilt_check /* 2131433550 */:
                int value10 = DataCanbus.DATA[30];
                YLFunc.CAR_COMM_CONTROL(19, value10 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_easy_exit_check /* 2131433552 */:
                int value11 = DataCanbus.DATA[31];
                if (DataCanbus.DATA[1000] == 364 || DataCanbus.DATA[1000] == 65900 || DataCanbus.DATA[1000] == 131436 || this.bRzc_Gl8 || (DataCanbus.DATA[1000] & 65535) == 61) {
                    YLFunc.CAR_COMM_CONTROL(89, value11 == 0 ? 1 : 0);
                    break;
                } else {
                    YLFunc.CAR_COMM_CONTROL(20, value11 == 0 ? 1 : 0);
                    break;
                }
            case R.id.xp_yl_auto_memory_check /* 2131433554 */:
                int value122 = DataCanbus.DATA[32];
                if (DataCanbus.DATA[1000] == 364 || DataCanbus.DATA[1000] == 65900 || DataCanbus.DATA[1000] == 131436 || this.bRzc_Gl8 || (DataCanbus.DATA[1000] & 65535) == 61) {
                    YLFunc.CAR_COMM_CONTROL(88, value122 == 0 ? 1 : 0);
                    break;
                } else {
                    YLFunc.CAR_COMM_CONTROL(21, value122 == 0 ? 1 : 0);
                    break;
                }
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addUpdater();
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
        DataCanbus.NOTIFY_EVENTS[84].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[85].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[83].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[84].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[85].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[83].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[71].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaternearCarUnlockAble() {
        int enable = DataCanbus.DATA[84];
        if (enable == 0) {
            findViewById(R.id.xp_yl_Near_car_unlocked_set).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_Near_car_unlocked_set).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterForgotKeyAble() {
        int enable = DataCanbus.DATA[85];
        if (enable == 0) {
            findViewById(R.id.xp_yl_remote_Forgotten_Keys_set).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_remote_Forgotten_Keys_set).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterDriverStyleAble() {
        int enable = DataCanbus.DATA[68];
        if (enable == 0) {
            findViewById(R.id.xp_yl_PERSONALIZATION_BY_DRIVER).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_PERSONALIZATION_BY_DRIVER).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRelockDoorAble() {
        int enable = DataCanbus.DATA[83];
        if (enable == 0) {
            findViewById(R.id.xp_yl_AUTO_RELOCK_DOORS_set).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_AUTO_RELOCK_DOORS_set).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterautoWipersAble() {
        int enable = DataCanbus.DATA[73];
        if (enable == 0) {
            findViewById(R.id.xp_yl_car_set_Second_auto_rain_refresh_set).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_car_set_Second_auto_rain_refresh_set).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterblindZoneAble() {
        int enable = DataCanbus.DATA[66];
        if (enable == 0) {
            findViewById(R.id.xp_yl_Side_blind_zone_set).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_Side_blind_zone_set).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterleaveCarLockAble() {
        int enable = DataCanbus.DATA[26];
        if (this.bRzc_Gl8) {
            enable = DataCanbus.DATA[86];
        }
        if (enable == 0) {
            findViewById(R.id.xp_yl_leave_door_latch_set).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_leave_door_latch_set).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterMirrorAutoFoldAble() {
        int enable = DataCanbus.DATA[29];
        if (enable == 0) {
            findViewById(R.id.xp_yl_comfort_Automatic_folding_mirrors_set).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_comfort_Automatic_folding_mirrors_set).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterReverTiltMirrorAble() {
        int enable = DataCanbus.DATA[30];
        if (enable == 0) {
            findViewById(R.id.xp_yl_comfort_Mirror_reversing_automatic_tilt_set).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_comfort_Mirror_reversing_automatic_tilt_set).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatereasyExitCarAble() {
        int enable = DataCanbus.DATA[70];
        if (enable == 0) {
            findViewById(R.id.xp_yl_easy_exit_set).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_easy_exit_set).setVisibility(0);
        }
        if (DataCanbus.DATA[1000] == 364 || DataCanbus.DATA[1000] == 65900 || DataCanbus.DATA[1000] == 131436) {
            findViewById(R.id.xp_yl_easy_exit_set).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoMemoryAble() {
        int enable = DataCanbus.DATA[69];
        if (enable == 0) {
            findViewById(R.id.xp_yl_auto_memory_set).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_auto_memory_set).setVisibility(0);
        }
        if (DataCanbus.DATA[1000] == 364 || DataCanbus.DATA[1000] == 65900 || DataCanbus.DATA[1000] == 131436) {
            findViewById(R.id.xp_yl_auto_memory_set).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoAnticrashPrepare() {
        int enable = DataCanbus.DATA[123];
        if (enable == 0) {
            findViewById(R.id.wc_weilang_auto_fangzhuang_preper_view).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.wc_weilang_auto_fangzhuang_preper_view).setVisibility(0);
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

    protected void uCrashPrepare(int val) {
        TextView v = (TextView) findViewById(R.id.wc_weilang_auto_fangzhuang_preper_TV);
        if (v != null) {
            int s = R.string.off;
            if (DataCanbus.DATA[1000] == 364 || DataCanbus.DATA[1000] == 65900 || DataCanbus.DATA[1000] == 131436 || this.bRzc_Gl8 || (DataCanbus.DATA[1000] & 65535) == 61) {
                if (val == 1) {
                    s = R.string.wc_weilang_auto_fangzhuang_warn;
                } else if (val == 2) {
                    s = R.string.wc_weilang_auto_fangzhuang_warn_and_zhidong;
                }
            } else if (val == 1) {
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
