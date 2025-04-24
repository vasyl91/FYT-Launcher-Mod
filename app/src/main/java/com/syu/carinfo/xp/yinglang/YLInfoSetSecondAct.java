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
public class YLInfoSetSecondAct extends Activity implements View.OnClickListener {
    private boolean bRzc_Gl8;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 117:
                    YLInfoSetSecondAct.this.updaternearCarUnlock();
                    break;
                case 118:
                    YLInfoSetSecondAct.this.updaterForgotKey();
                    break;
                case 119:
                    YLInfoSetSecondAct.this.updaterDriverStyle();
                    break;
                case 120:
                    YLInfoSetSecondAct.this.updaterRelockDoor();
                    break;
                case 121:
                    YLInfoSetSecondAct.this.updaterautoWipers();
                    break;
                case 122:
                    YLInfoSetSecondAct.this.updaterblindZone();
                    break;
                case 123:
                    YLInfoSetSecondAct.this.updaterleaveCarLock();
                    break;
                case 124:
                    YLInfoSetSecondAct.this.updaterhandTraffic();
                    break;
                case 125:
                    YLInfoSetSecondAct.this.updateradaptiveForwardLight();
                    break;
                case 126:
                    YLInfoSetSecondAct.this.updaterMirrorAutoFold();
                    break;
                case 127:
                    YLInfoSetSecondAct.this.updaterReverTiltMirror();
                    break;
                case 128:
                    YLInfoSetSecondAct.this.updatereasyExitCar();
                    break;
                case 129:
                    YLInfoSetSecondAct.this.updaterAutoMemory();
                    break;
                case 163:
                    YLInfoSetSecondAct.this.updaterblindZoneAble();
                    break;
                case 165:
                    YLInfoSetSecondAct.this.updaterDriverStyleAble();
                    break;
                case 166:
                    YLInfoSetSecondAct.this.updaterAutoMemoryAble();
                    break;
                case 167:
                    YLInfoSetSecondAct.this.updatereasyExitCarAble();
                    break;
                case 168:
                    YLInfoSetSecondAct.this.updaterReverTiltMirrorAble();
                    break;
                case 169:
                    YLInfoSetSecondAct.this.updaterMirrorAutoFoldAble();
                    break;
                case 170:
                    YLInfoSetSecondAct.this.updaterautoWipersAble();
                    break;
                case 180:
                    YLInfoSetSecondAct.this.updaterRelockDoorAble();
                    break;
                case 181:
                    YLInfoSetSecondAct.this.updaternearCarUnlockAble();
                    break;
                case 182:
                    YLInfoSetSecondAct.this.updaterForgotKeyAble();
                    break;
                case 183:
                    YLInfoSetSecondAct.this.updaterleaveCarLockAble();
                    break;
                case 185:
                    YLInfoSetSecondAct.this.uCrashPrepare(DataCanbus.DATA[185]);
                    break;
                case 186:
                    YLInfoSetSecondAct.this.updaterAutoAnticrashPrepare();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_xp_yl_info_second_set);
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
        if (DataCanbus.DATA[1000] == 6422589 || DataCanbus.DATA[1000] == 6488125 || DataCanbus.DATA[1000] == 6553661) {
            findViewById(R.id.xp_yl_easy_exit_set).setVisibility(8);
            findViewById(R.id.xp_yl_auto_memory_set).setVisibility(8);
            findViewById(R.id.xp_yinglang_left_right_traffic_set).setVisibility(8);
            findViewById(R.id.xp_yinglang_adaptive_forward_lighting_set).setVisibility(8);
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.xp_yl_Near_car_unlocked_set_check /* 2131433441 */:
                YLFunc.CAR_COMM_CONTROL(12, DataCanbus.DATA[117] == 0 ? 1 : 0);
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
                if (DataCanbus.DATA[1000] == 6422589 || DataCanbus.DATA[1000] == 6488125 || DataCanbus.DATA[1000] == 6553661 || this.bRzc_Gl8 || (DataCanbus.DATA[1000] & 65535) == 61) {
                    YLFunc.CAR_COMM_CONTROL(26, value5 == 0 ? 1 : 0);
                    break;
                } else {
                    YLFunc.CAR_COMM_CONTROL(24, value5 == 0 ? 1 : 0);
                    break;
                }
            case R.id.xp_yl_Side_blind_zone_check /* 2131433452 */:
                int value6 = DataCanbus.DATA[122];
                YLFunc.CAR_COMM_CONTROL(22, value6 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_leave_door_latch_pre /* 2131433454 */:
                int value13 = DataCanbus.DATA[123];
                if (value13 == 0) {
                    YLFunc.CAR_COMM_CONTROL(23, 2);
                    break;
                } else if (value13 == 1) {
                    YLFunc.CAR_COMM_CONTROL(23, 0);
                    break;
                } else if (value13 == 2) {
                    YLFunc.CAR_COMM_CONTROL(23, 1);
                    break;
                }
            case R.id.xp_yl_leave_door_latch_next /* 2131433456 */:
                int value14 = DataCanbus.DATA[123];
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
                if (DataCanbus.DATA[1000] == 6422589 || DataCanbus.DATA[1000] == 6488125 || DataCanbus.DATA[1000] == 6553661 || this.bRzc_Gl8 || (DataCanbus.DATA[1000] & 65535) == 61) {
                    YLFunc.CAR_COMM_CONTROL(91, value9 == 0 ? 1 : 0);
                    break;
                } else {
                    YLFunc.CAR_COMM_CONTROL(18, value9 == 0 ? 1 : 0);
                    break;
                }
            case R.id.xp_yl_comfort_Mirror_reversing_automatic_tilt_check /* 2131433466 */:
                int value10 = DataCanbus.DATA[127];
                YLFunc.CAR_COMM_CONTROL(19, value10 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_easy_exit_check /* 2131433468 */:
                int value11 = DataCanbus.DATA[128];
                if (DataCanbus.DATA[1000] == 6422589 || DataCanbus.DATA[1000] == 6488125 || DataCanbus.DATA[1000] == 6553661 || this.bRzc_Gl8 || (DataCanbus.DATA[1000] & 65535) == 61) {
                    YLFunc.CAR_COMM_CONTROL(89, value11 == 0 ? 1 : 0);
                    break;
                } else {
                    YLFunc.CAR_COMM_CONTROL(20, value11 == 0 ? 1 : 0);
                    break;
                }
            case R.id.xp_yl_auto_memory_check /* 2131433470 */:
                int value12 = DataCanbus.DATA[129];
                if (DataCanbus.DATA[1000] == 6422589 || DataCanbus.DATA[1000] == 6488125 || DataCanbus.DATA[1000] == 6553661 || this.bRzc_Gl8 || (DataCanbus.DATA[1000] & 65535) == 61) {
                    YLFunc.CAR_COMM_CONTROL(88, value12 == 0 ? 1 : 0);
                    break;
                } else {
                    YLFunc.CAR_COMM_CONTROL(21, value12 == 0 ? 1 : 0);
                    break;
                }
            case R.id.wc_weilang_auto_fangzhuang_preper_pre /* 2131433472 */:
                if (DataCanbus.DATA[1000] == 6422589 || DataCanbus.DATA[1000] == 6488125 || DataCanbus.DATA[1000] == 6553661 || this.bRzc_Gl8 || (DataCanbus.DATA[1000] & 65535) == 61) {
                    int value1 = DataCanbus.DATA[185] - 1;
                    if (value1 < 0) {
                        value1 = 2;
                    }
                    YLFunc.CAR_COMM_CONTROL(24, value1);
                    break;
                } else {
                    int value15 = DataCanbus.DATA[185] + 1;
                    if (value15 == 4) {
                        value15 = 3;
                    }
                    YLFunc.CAR_COMM_CONTROL(25, value15 % 3);
                    break;
                }
            case R.id.wc_weilang_auto_fangzhuang_preper_next /* 2131433474 */:
                int value16 = DataCanbus.DATA[185] + 1;
                if (DataCanbus.DATA[1000] == 6422589 || DataCanbus.DATA[1000] == 6488125 || DataCanbus.DATA[1000] == 6553661 || this.bRzc_Gl8 || (DataCanbus.DATA[1000] & 65535) == 61) {
                    if (value16 > 2) {
                        value16 = 0;
                    }
                    YLFunc.CAR_COMM_CONTROL(24, value16);
                    break;
                } else {
                    if (value16 == 4) {
                        value16 = 3;
                    }
                    YLFunc.CAR_COMM_CONTROL(25, value16 % 3);
                    break;
                }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        addUpdater();
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
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
    }

    
    public void updaternearCarUnlockAble() {
        int enable = DataCanbus.DATA[181];
        if (enable == 0) {
            findViewById(R.id.xp_yl_Near_car_unlocked_set).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_Near_car_unlocked_set).setVisibility(0);
        }
    }

    
    public void updaterForgotKeyAble() {
        int enable = DataCanbus.DATA[182];
        if (enable == 0) {
            findViewById(R.id.xp_yl_remote_Forgotten_Keys_set).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_remote_Forgotten_Keys_set).setVisibility(0);
        }
    }

    
    public void updaterDriverStyleAble() {
        int enable = DataCanbus.DATA[165];
        if (enable == 0) {
            findViewById(R.id.xp_yl_PERSONALIZATION_BY_DRIVER).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_PERSONALIZATION_BY_DRIVER).setVisibility(0);
        }
    }

    
    public void updaterRelockDoorAble() {
        int enable = DataCanbus.DATA[180];
        if (enable == 0) {
            findViewById(R.id.xp_yl_AUTO_RELOCK_DOORS_set).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_AUTO_RELOCK_DOORS_set).setVisibility(0);
        }
    }

    
    public void updaterautoWipersAble() {
        int enable = DataCanbus.DATA[170];
        if (enable == 0) {
            findViewById(R.id.xp_yl_car_set_Second_auto_rain_refresh_set).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_car_set_Second_auto_rain_refresh_set).setVisibility(0);
        }
    }

    
    public void updaterblindZoneAble() {
        int enable = DataCanbus.DATA[163];
        if (enable == 0) {
            findViewById(R.id.xp_yl_Side_blind_zone_set).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_Side_blind_zone_set).setVisibility(0);
        }
    }

    
    public void updaterleaveCarLockAble() {
        int enable = DataCanbus.DATA[123];
        if (this.bRzc_Gl8) {
            enable = DataCanbus.DATA[183];
        }
        if (enable == 0) {
            findViewById(R.id.xp_yl_leave_door_latch_set).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_leave_door_latch_set).setVisibility(0);
        }
    }

    
    public void updaterMirrorAutoFoldAble() {
        int enable = DataCanbus.DATA[126];
        if (enable == 0) {
            findViewById(R.id.xp_yl_comfort_Automatic_folding_mirrors_set).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_comfort_Automatic_folding_mirrors_set).setVisibility(0);
        }
    }

    
    public void updaterReverTiltMirrorAble() {
        int enable = DataCanbus.DATA[127];
        if (enable == 0) {
            findViewById(R.id.xp_yl_comfort_Mirror_reversing_automatic_tilt_set).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_comfort_Mirror_reversing_automatic_tilt_set).setVisibility(0);
        }
    }

    
    public void updatereasyExitCarAble() {
        int enable = DataCanbus.DATA[167];
        if (enable == 0) {
            findViewById(R.id.xp_yl_easy_exit_set).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_easy_exit_set).setVisibility(0);
        }
        if (DataCanbus.DATA[1000] == 6422589 || DataCanbus.DATA[1000] == 6488125 || DataCanbus.DATA[1000] == 6553661) {
            findViewById(R.id.xp_yl_easy_exit_set).setVisibility(8);
        }
    }

    
    public void updaterAutoMemoryAble() {
        int enable = DataCanbus.DATA[166];
        if (enable == 0) {
            findViewById(R.id.xp_yl_auto_memory_set).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_auto_memory_set).setVisibility(0);
        }
        if (DataCanbus.DATA[1000] == 6422589 || DataCanbus.DATA[1000] == 6488125 || DataCanbus.DATA[1000] == 6553661) {
            findViewById(R.id.xp_yl_auto_memory_set).setVisibility(8);
        }
    }

    
    public void updaterAutoAnticrashPrepare() {
        int enable = DataCanbus.DATA[186];
        if (enable == 0) {
            findViewById(R.id.wc_weilang_auto_fangzhuang_preper_view).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.wc_weilang_auto_fangzhuang_preper_view).setVisibility(0);
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
            if (DataCanbus.DATA[1000] == 6422589 || DataCanbus.DATA[1000] == 6488125 || DataCanbus.DATA[1000] == 6553661 || this.bRzc_Gl8 || (DataCanbus.DATA[1000] & 65535) == 61) {
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
