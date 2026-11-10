package com.syu.carinfo.mzd.cx5;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class CX5Index extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    CX5Index.this.updaterAutoDoorLockMode();
                    break;
                case 99:
                    CX5Index.this.updaterUnlockMode();
                    break;
                case 100:
                    CX5Index.this.updaterAutoreLockTime();
                    break;
                case 101:
                    CX5Index.this.updaterLockBeepVolum();
                    break;
                case 102:
                    CX5Index.this.updaterWalkAwayLock();
                    break;
                case 103:
                    CX5Index.this.updaterDoorOpen();
                    break;
                case 104:
                    CX5Index.this.updaterDoorClose();
                    break;
                case 105:
                    CX5Index.this.updaterHeadingOffTimer();
                    break;
                case 106:
                    CX5Index.this.updaterFlashTurnSingnal();
                    break;
                case 107:
                    CX5Index.this.updaterAutoHeadingOn();
                    break;
                case 108:
                    CX5Index.this.updaterWipers();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_175_xp1_mzd_cx5);
        init();
        setUI();
    }

    @Override
    public void init() {
    }

    public void setUI() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(this);
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

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
    }

    
    public void updaterAutoDoorLockMode() {
        int autoDoorLockModeValue = DataCanbus.DATA[98];
        switch (autoDoorLockModeValue) {
            case 0:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_xp_mzd_cx5_auto_door_lock_mode_0);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_xp_mzd_cx5_auto_door_lock_mode_1);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_xp_mzd_cx5_auto_door_lock_mode_2);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_xp_mzd_cx5_auto_door_lock_mode_3);
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_xp_mzd_cx5_auto_door_lock_mode_4);
                break;
        }
    }

    
    public void updaterUnlockMode() {
        int unlockmodeValue = DataCanbus.DATA[99];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(unlockmodeValue != 0);
        if (unlockmodeValue == 0) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_xp_mzd_cx5_unlock_mode_0);
        } else if (unlockmodeValue == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_xp_mzd_cx5_unlock_mode_1);
        }
    }

    
    public void updaterAutoreLockTime() {
        int autoRelocktimeValue = DataCanbus.DATA[100];
        switch (autoRelocktimeValue) {
            case 0:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_xp_mzd_cx5_auto_relock_time_0);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_light_Lasuo_headlight_delay_2);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_light_Lasuo_headlight_delay_1);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_Parking_with_trailer_Off);
                break;
        }
    }

    
    public void updaterLockBeepVolum() {
        int lockBeepVolumeValue = DataCanbus.DATA[101];
        switch (lockBeepVolumeValue) {
            case 0:
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.xp_accord9_auto_light_3higher);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.xp_accord9_auto_light_2middle);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.xp_accord9_auto_light_1lower);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_Parking_with_trailer_Off);
                break;
        }
    }

    
    public void updaterWalkAwayLock() {
        int walkawayValue = DataCanbus.DATA[102];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(walkawayValue != 0);
    }

    
    public void updaterDoorOpen() {
        int DoorOpenValue = DataCanbus.DATA[103];
        switch (DoorOpenValue) {
            case 0:
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_xp_mzd_cx5_int_light_timeout_door_open_0);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_xp_mzd_cx5_int_light_timeout_door_open_1);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_xp_mzd_cx5_int_light_timeout_door_open_2);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.klc_Parking_with_trailer_Off);
                break;
        }
    }

    
    public void updaterDoorClose() {
        int DoorCloseValue = DataCanbus.DATA[104];
        switch (DoorCloseValue) {
            case 0:
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.klc_light_Lasuo_headlight_delay_2);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.klc_light_Lasuo_headlight_delay_1);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_xp_mzd_cx5_int_light_timeout_door_close_2);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_xp_mzd_cx5_int_light_timeout_door_close_3);
                break;
        }
    }

    
    public void updaterHeadingOffTimer() {
        int HeadlightOffTimerValue = DataCanbus.DATA[105];
        switch (HeadlightOffTimerValue) {
            case 0:
                ((TextView) findViewById(R.id.tv_text7)).setText(R.string.klc_light_Lasuo_headlight_delay_3);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text7)).setText(R.string.str_xp_mzd_cx5_auto_relock_time_0);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text7)).setText(R.string.klc_light_Lasuo_headlight_delay_2);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text7)).setText(R.string.klc_light_Lasuo_headlight_delay_1);
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_text7)).setText(R.string.klc_Parking_with_trailer_Off);
                break;
        }
    }

    
    public void updaterFlashTurnSingnal() {
        int flashTurnSingnalValue = DataCanbus.DATA[106];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(flashTurnSingnalValue != 0);
    }

    
    public void updaterAutoHeadingOn() {
        int AutoHeadlingOnValue = DataCanbus.DATA[107];
        switch (AutoHeadlingOnValue) {
            case 0:
                ((TextView) findViewById(R.id.tv_text8)).setText(R.string.str_xp_mzd_cx5_auto_headlight_on_0);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text8)).setText(R.string.str_xp_mzd_cx5_auto_headlight_on_1);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text8)).setText(R.string.str_xp_mzd_cx5_auto_headlight_on_2);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text8)).setText(R.string.str_xp_mzd_cx5_auto_headlight_on_3);
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_text8)).setText(R.string.str_xp_mzd_cx5_auto_headlight_on_4);
                break;
        }
    }

    
    public void updaterWipers() {
        int WipersValue = DataCanbus.DATA[108];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(WipersValue != 0);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int autoDoorLockModeValue = DataCanbus.DATA[98];
                if (autoDoorLockModeValue == 0) {
                    FucMZD.C_MZD_CX5_CMD(0, 4);
                    break;
                } else if (autoDoorLockModeValue == 1) {
                    FucMZD.C_MZD_CX5_CMD(0, 0);
                    break;
                } else if (autoDoorLockModeValue == 2) {
                    FucMZD.C_MZD_CX5_CMD(0, 1);
                    break;
                } else if (autoDoorLockModeValue == 3) {
                    FucMZD.C_MZD_CX5_CMD(0, 2);
                    break;
                } else if (autoDoorLockModeValue == 4) {
                    FucMZD.C_MZD_CX5_CMD(0, 3);
                    break;
                }
            case R.id.btn_plus1 /* 2131427457 */:
                int autoDoorLockModeValue2 = DataCanbus.DATA[98];
                if (autoDoorLockModeValue2 == 0) {
                    FucMZD.C_MZD_CX5_CMD(0, 1);
                    break;
                } else if (autoDoorLockModeValue2 == 1) {
                    FucMZD.C_MZD_CX5_CMD(0, 2);
                    break;
                } else if (autoDoorLockModeValue2 == 2) {
                    FucMZD.C_MZD_CX5_CMD(0, 3);
                    break;
                } else if (autoDoorLockModeValue2 == 3) {
                    FucMZD.C_MZD_CX5_CMD(0, 4);
                    break;
                } else if (autoDoorLockModeValue2 == 4) {
                    FucMZD.C_MZD_CX5_CMD(0, 0);
                    break;
                }
            case R.id.btn_minus2 /* 2131427458 */:
                int autoRelocktimeValue = DataCanbus.DATA[100];
                if (autoRelocktimeValue == 0) {
                    FucMZD.C_MZD_CX5_CMD(2, 2);
                    break;
                } else if (autoRelocktimeValue == 1) {
                    FucMZD.C_MZD_CX5_CMD(2, 0);
                    break;
                } else if (autoRelocktimeValue == 2) {
                    FucMZD.C_MZD_CX5_CMD(2, 1);
                    break;
                }
            case R.id.btn_plus2 /* 2131427460 */:
                int autoRelocktimeValue2 = DataCanbus.DATA[100];
                if (autoRelocktimeValue2 == 0) {
                    FucMZD.C_MZD_CX5_CMD(2, 1);
                    break;
                } else if (autoRelocktimeValue2 == 1) {
                    FucMZD.C_MZD_CX5_CMD(2, 2);
                    break;
                } else if (autoRelocktimeValue2 == 2) {
                    FucMZD.C_MZD_CX5_CMD(2, 0);
                    break;
                }
            case R.id.btn_minus3 /* 2131427461 */:
                int lockBeepVolumeValue = DataCanbus.DATA[101];
                if (lockBeepVolumeValue == 0) {
                    FucMZD.C_MZD_CX5_CMD(3, 2);
                    break;
                } else if (lockBeepVolumeValue == 1) {
                    FucMZD.C_MZD_CX5_CMD(3, 0);
                    break;
                } else if (lockBeepVolumeValue == 2) {
                    FucMZD.C_MZD_CX5_CMD(3, 1);
                    break;
                } else if (lockBeepVolumeValue == 3) {
                    FucMZD.C_MZD_CX5_CMD(3, 2);
                    break;
                }
            case R.id.btn_plus3 /* 2131427463 */:
                int lockBeepVolumeValue2 = DataCanbus.DATA[101];
                if (lockBeepVolumeValue2 == 0) {
                    FucMZD.C_MZD_CX5_CMD(3, 1);
                    break;
                } else if (lockBeepVolumeValue2 == 1) {
                    FucMZD.C_MZD_CX5_CMD(3, 2);
                    break;
                } else if (lockBeepVolumeValue2 == 2) {
                    FucMZD.C_MZD_CX5_CMD(3, 3);
                    break;
                } else if (lockBeepVolumeValue2 == 3) {
                    FucMZD.C_MZD_CX5_CMD(3, 0);
                    break;
                }
            case R.id.btn_minus4 /* 2131427464 */:
                int DoorOpenValue = DataCanbus.DATA[103];
                if (DoorOpenValue == 0) {
                    FucMZD.C_MZD_CX5_CMD(5, 2);
                    break;
                } else if (DoorOpenValue == 1) {
                    FucMZD.C_MZD_CX5_CMD(5, 0);
                    break;
                } else if (DoorOpenValue == 2) {
                    FucMZD.C_MZD_CX5_CMD(5, 1);
                    break;
                }
            case R.id.btn_plus4 /* 2131427466 */:
                int DoorOpenValue2 = DataCanbus.DATA[103];
                if (DoorOpenValue2 == 0) {
                    FucMZD.C_MZD_CX5_CMD(5, 1);
                    break;
                } else if (DoorOpenValue2 == 1) {
                    FucMZD.C_MZD_CX5_CMD(5, 2);
                    break;
                } else if (DoorOpenValue2 == 2) {
                    FucMZD.C_MZD_CX5_CMD(5, 0);
                    break;
                }
            case R.id.btn_minus5 /* 2131427467 */:
                int DoorCloseValue = DataCanbus.DATA[104];
                if (DoorCloseValue == 0) {
                    FucMZD.C_MZD_CX5_CMD(6, 3);
                    break;
                } else if (DoorCloseValue == 1) {
                    FucMZD.C_MZD_CX5_CMD(6, 0);
                    break;
                } else if (DoorCloseValue == 2) {
                    FucMZD.C_MZD_CX5_CMD(6, 1);
                    break;
                } else if (DoorCloseValue == 3) {
                    FucMZD.C_MZD_CX5_CMD(6, 2);
                    break;
                }
            case R.id.btn_plus5 /* 2131427469 */:
                int DoorCloseValue2 = DataCanbus.DATA[104];
                if (DoorCloseValue2 == 0) {
                    FucMZD.C_MZD_CX5_CMD(6, 1);
                    break;
                } else if (DoorCloseValue2 == 1) {
                    FucMZD.C_MZD_CX5_CMD(6, 2);
                    break;
                } else if (DoorCloseValue2 == 2) {
                    FucMZD.C_MZD_CX5_CMD(6, 3);
                    break;
                } else if (DoorCloseValue2 == 3) {
                    FucMZD.C_MZD_CX5_CMD(6, 0);
                    break;
                }
            case R.id.btn_minus6 /* 2131427470 */:
                int HeadlightOffTimerValue = DataCanbus.DATA[105];
                if (HeadlightOffTimerValue == 0) {
                    FucMZD.C_MZD_CX5_CMD(8, 4);
                    break;
                } else if (HeadlightOffTimerValue == 1) {
                    FucMZD.C_MZD_CX5_CMD(8, 0);
                    break;
                } else if (HeadlightOffTimerValue == 2) {
                    FucMZD.C_MZD_CX5_CMD(8, 1);
                    break;
                } else if (HeadlightOffTimerValue == 3) {
                    FucMZD.C_MZD_CX5_CMD(8, 2);
                    break;
                } else if (HeadlightOffTimerValue == 4) {
                    FucMZD.C_MZD_CX5_CMD(8, 3);
                    break;
                }
            case R.id.btn_plus6 /* 2131427472 */:
                int HeadlightOffTimerValue2 = DataCanbus.DATA[105];
                if (HeadlightOffTimerValue2 == 0) {
                    FucMZD.C_MZD_CX5_CMD(8, 1);
                    break;
                } else if (HeadlightOffTimerValue2 == 1) {
                    FucMZD.C_MZD_CX5_CMD(8, 2);
                    break;
                } else if (HeadlightOffTimerValue2 == 2) {
                    FucMZD.C_MZD_CX5_CMD(8, 3);
                    break;
                } else if (HeadlightOffTimerValue2 == 3) {
                    FucMZD.C_MZD_CX5_CMD(8, 4);
                    break;
                } else if (HeadlightOffTimerValue2 == 4) {
                    FucMZD.C_MZD_CX5_CMD(8, 0);
                    break;
                }
            case R.id.btn_minus7 /* 2131427473 */:
                int AutoHeadlingOnValue = DataCanbus.DATA[107];
                if (AutoHeadlingOnValue == 0) {
                    FucMZD.C_MZD_CX5_CMD(9, 4);
                    break;
                } else if (AutoHeadlingOnValue == 1) {
                    FucMZD.C_MZD_CX5_CMD(9, 0);
                    break;
                } else if (AutoHeadlingOnValue == 2) {
                    FucMZD.C_MZD_CX5_CMD(9, 1);
                    break;
                } else if (AutoHeadlingOnValue == 3) {
                    FucMZD.C_MZD_CX5_CMD(9, 2);
                    break;
                } else if (AutoHeadlingOnValue == 4) {
                    FucMZD.C_MZD_CX5_CMD(9, 3);
                    break;
                }
            case R.id.btn_plus7 /* 2131427475 */:
                int AutoHeadlingOnValue2 = DataCanbus.DATA[107];
                if (AutoHeadlingOnValue2 == 0) {
                    FucMZD.C_MZD_CX5_CMD(9, 1);
                    break;
                } else if (AutoHeadlingOnValue2 == 1) {
                    FucMZD.C_MZD_CX5_CMD(9, 2);
                    break;
                } else if (AutoHeadlingOnValue2 == 2) {
                    FucMZD.C_MZD_CX5_CMD(9, 3);
                    break;
                } else if (AutoHeadlingOnValue2 == 3) {
                    FucMZD.C_MZD_CX5_CMD(9, 4);
                    break;
                } else if (AutoHeadlingOnValue2 == 4) {
                    FucMZD.C_MZD_CX5_CMD(9, 0);
                    break;
                }
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int unlockmodeValue = DataCanbus.DATA[99];
                FucMZD.C_MZD_CX5_CMD(1, unlockmodeValue == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int walkawayValue = DataCanbus.DATA[102];
                FucMZD.C_MZD_CX5_CMD(4, walkawayValue == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int flashTurnSingnalValue = DataCanbus.DATA[106];
                FucMZD.C_MZD_CX5_CMD(7, flashTurnSingnalValue == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int WipersValue = DataCanbus.DATA[108];
                FucMZD.C_MZD_CX5_CMD(10, WipersValue == 0 ? 1 : 0);
                break;
        }
    }
}
