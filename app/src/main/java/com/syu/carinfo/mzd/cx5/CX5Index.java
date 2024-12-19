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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class CX5Index extends BaseActivity implements View.OnClickListener {
    Button AutoDoorLockModeNext;
    Button AutoDoorLockModePre;
    TextView AutoDoorLockModeTV;
    Button AutoHeadlingOnNext;
    Button AutoHeadlingOnPre;
    TextView AutoHeadlingOnTv;
    int AutoHeadlingOnValue;
    Button AutoRelockTimeNext;
    Button AutoRelockTimePre;
    TextView AutoRelockTimeTv;
    Button DoorCloseNext;
    Button DoorClosePre;
    TextView DoorCloseTV;
    int DoorCloseValue;
    Button DoorOpenNext;
    Button DoorOpenPre;
    TextView DoorOpenTV;
    int DoorOpenValue;
    CheckedTextView FlashChecked;
    Button HeadlightOffTimerNext;
    Button HeadlightOffTimerPre;
    TextView HeadlightOffTimerTV;
    int HeadlightOffTimerValue;
    Button LockBeepVolumeNext;
    Button LockBeepVolumePre;
    TextView LockBeepVolumeTV;
    CheckedTextView UnlockModeChecked;
    TextView UnlockModeTV;
    CheckedTextView WarkAwayLockChecked;
    CheckedTextView WipersChecked;
    int WipersValue;
    int autoDoorLockModeValue;
    int autoRelocktimeValue;
    int flashTurnSingnalValue;
    int lockBeepVolumeValue;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.mzd.cx5.CX5Index.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 1:
                    CX5Index.this.updaterAutoDoorLockMode();
                    break;
                case 2:
                    CX5Index.this.updaterUnlockMode();
                    break;
                case 3:
                    CX5Index.this.updaterAutoreLockTime();
                    break;
                case 4:
                    CX5Index.this.updaterLockBeepVolum();
                    break;
                case 5:
                    CX5Index.this.updaterWalkAwayLock();
                    break;
                case 6:
                    CX5Index.this.updaterDoorOpen();
                    break;
                case 7:
                    CX5Index.this.updaterDoorClose();
                    break;
                case 8:
                    CX5Index.this.updaterHeadingOffTimer();
                    break;
                case 9:
                    CX5Index.this.updaterFlashTurnSingnal();
                    break;
                case 10:
                    CX5Index.this.updaterAutoHeadingOn();
                    break;
                case 11:
                    CX5Index.this.updaterWipers();
                    break;
            }
        }
    };
    int unlockmodeValue;
    int walkawayValue;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_175_xp1_mzd_cx5);
        init();
        setUI();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.UnlockModeChecked = (CheckedTextView) findViewById(R.id.xp_mzd_cx5_unlock_mode_check);
        this.WarkAwayLockChecked = (CheckedTextView) findViewById(R.id.xp_mzd_cx5_walk_away_lock_check);
        this.FlashChecked = (CheckedTextView) findViewById(R.id.xp_mzd_cx5_flash_turn_singnal_check);
        this.WipersChecked = (CheckedTextView) findViewById(R.id.xp_mzd_cx5_wipers_check);
        this.AutoDoorLockModePre = (Button) findViewById(R.id.xp_mzd_cx5_auto_door_lock_mode_pre);
        this.AutoDoorLockModeNext = (Button) findViewById(R.id.xp_mzd_cx5_auto_door_lock_mode_next);
        this.AutoRelockTimePre = (Button) findViewById(R.id.xp_mzd_cx5_auto_relock_time_pre);
        this.AutoRelockTimeNext = (Button) findViewById(R.id.xp_mzd_cx5_auto_relock_time_next);
        this.LockBeepVolumePre = (Button) findViewById(R.id.xp_mzd_cx5_lock_beep_volume_pre);
        this.LockBeepVolumeNext = (Button) findViewById(R.id.xp_mzd_cx5_lock_beep_volume_next);
        this.DoorOpenPre = (Button) findViewById(R.id.xp_mzd_cx5_int_light_timeout_door_open_pre);
        this.DoorOpenNext = (Button) findViewById(R.id.xp_mzd_cx5_int_light_timeout_door_open_next);
        this.DoorClosePre = (Button) findViewById(R.id.xp_mzd_cx5_int_light_timeout_door_close_pre);
        this.DoorCloseNext = (Button) findViewById(R.id.xp_mzd_cx5_int_light_timeout_door_close_next);
        this.HeadlightOffTimerPre = (Button) findViewById(R.id.xp_mzd_cx5_headlight_off_timer_pre);
        this.HeadlightOffTimerNext = (Button) findViewById(R.id.xp_mzd_cx5_headlight_off_timer_next);
        this.AutoHeadlingOnPre = (Button) findViewById(R.id.xp_mzd_cx5_auto_headlight_on_pre);
        this.AutoHeadlingOnNext = (Button) findViewById(R.id.xp_mzd_cx5_auto_headlight_on_next);
        this.UnlockModeTV = (TextView) findViewById(R.id.xp_mzd_cx5_unlock_mode_tv);
        this.AutoDoorLockModeTV = (TextView) findViewById(R.id.xp_mzd_cx5_auto_door_lock_mode_tv);
        this.AutoRelockTimeTv = (TextView) findViewById(R.id.xp_mzd_cx5_auto_relock_time_tv);
        this.LockBeepVolumeTV = (TextView) findViewById(R.id.xp_mzd_cx5_lock_beep_volume_tv);
        this.DoorOpenTV = (TextView) findViewById(R.id.xp_mzd_cx5_int_light_timeout_door_open_tv);
        this.DoorCloseTV = (TextView) findViewById(R.id.xp_mzd_cx5_int_light_timeout_door_close_tv);
        this.HeadlightOffTimerTV = (TextView) findViewById(R.id.xp_mzd_cx5_headlight_off_timer_tv);
        this.AutoHeadlingOnTv = (TextView) findViewById(R.id.xp_mzd_cx5_auto_headlight_on_tv);
    }

    public void setUI() {
        this.UnlockModeChecked.setOnClickListener(this);
        this.WarkAwayLockChecked.setOnClickListener(this);
        this.FlashChecked.setOnClickListener(this);
        this.WipersChecked.setOnClickListener(this);
        this.AutoDoorLockModePre.setOnClickListener(this);
        this.AutoDoorLockModeNext.setOnClickListener(this);
        this.AutoRelockTimePre.setOnClickListener(this);
        this.AutoRelockTimeNext.setOnClickListener(this);
        this.LockBeepVolumePre.setOnClickListener(this);
        this.LockBeepVolumeNext.setOnClickListener(this);
        this.DoorOpenPre.setOnClickListener(this);
        this.DoorOpenNext.setOnClickListener(this);
        this.DoorClosePre.setOnClickListener(this);
        this.DoorCloseNext.setOnClickListener(this);
        this.HeadlightOffTimerPre.setOnClickListener(this);
        this.HeadlightOffTimerNext.setOnClickListener(this);
        this.AutoHeadlingOnPre.setOnClickListener(this);
        this.AutoHeadlingOnNext.setOnClickListener(this);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addUpdater();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoDoorLockMode() {
        this.autoDoorLockModeValue = DataCanbus.DATA[1];
        switch (this.autoDoorLockModeValue) {
            case 0:
                this.AutoDoorLockModeTV.setText(R.string.str_xp_mzd_cx5_auto_door_lock_mode_0);
                break;
            case 1:
                this.AutoDoorLockModeTV.setText(R.string.str_xp_mzd_cx5_auto_door_lock_mode_1);
                break;
            case 2:
                this.AutoDoorLockModeTV.setText(R.string.str_xp_mzd_cx5_auto_door_lock_mode_2);
                break;
            case 3:
                this.AutoDoorLockModeTV.setText(R.string.str_xp_mzd_cx5_auto_door_lock_mode_3);
                break;
            case 4:
                this.AutoDoorLockModeTV.setText(R.string.str_xp_mzd_cx5_auto_door_lock_mode_4);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterUnlockMode() {
        this.unlockmodeValue = DataCanbus.DATA[2];
        this.UnlockModeChecked.setChecked(this.unlockmodeValue != 0);
        if (this.unlockmodeValue == 0) {
            this.UnlockModeTV.setText(R.string.str_xp_mzd_cx5_unlock_mode_0);
        } else if (this.unlockmodeValue == 1) {
            this.UnlockModeTV.setText(R.string.str_xp_mzd_cx5_unlock_mode_1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoreLockTime() {
        this.autoRelocktimeValue = DataCanbus.DATA[3];
        switch (this.autoRelocktimeValue) {
            case 0:
                this.AutoRelockTimeTv.setText(R.string.str_xp_mzd_cx5_auto_relock_time_0);
                break;
            case 1:
                this.AutoRelockTimeTv.setText(R.string.klc_light_Lasuo_headlight_delay_2);
                break;
            case 2:
                this.AutoRelockTimeTv.setText(R.string.klc_light_Lasuo_headlight_delay_1);
                break;
            case 3:
                this.AutoRelockTimeTv.setText(R.string.klc_Parking_with_trailer_Off);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterLockBeepVolum() {
        this.lockBeepVolumeValue = DataCanbus.DATA[4];
        switch (this.lockBeepVolumeValue) {
            case 0:
                this.LockBeepVolumeTV.setText(R.string.xp_accord9_auto_light_3higher);
                break;
            case 1:
                this.LockBeepVolumeTV.setText(R.string.xp_accord9_auto_light_2middle);
                break;
            case 2:
                this.LockBeepVolumeTV.setText(R.string.xp_accord9_auto_light_1lower);
                break;
            case 3:
                this.LockBeepVolumeTV.setText(R.string.klc_Parking_with_trailer_Off);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterWalkAwayLock() {
        this.walkawayValue = DataCanbus.DATA[5];
        this.WarkAwayLockChecked.setChecked(this.walkawayValue != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterDoorOpen() {
        this.DoorOpenValue = DataCanbus.DATA[6];
        switch (this.DoorOpenValue) {
            case 0:
                this.DoorOpenTV.setText(R.string.str_xp_mzd_cx5_int_light_timeout_door_open_0);
                break;
            case 1:
                this.DoorOpenTV.setText(R.string.str_xp_mzd_cx5_int_light_timeout_door_open_1);
                break;
            case 2:
                this.DoorOpenTV.setText(R.string.str_xp_mzd_cx5_int_light_timeout_door_open_2);
                break;
            case 3:
                this.DoorOpenTV.setText(R.string.klc_Parking_with_trailer_Off);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterDoorClose() {
        this.DoorCloseValue = DataCanbus.DATA[7];
        switch (this.DoorCloseValue) {
            case 0:
                this.DoorCloseTV.setText(R.string.klc_light_Lasuo_headlight_delay_2);
                break;
            case 1:
                this.DoorCloseTV.setText(R.string.klc_light_Lasuo_headlight_delay_1);
                break;
            case 2:
                this.DoorCloseTV.setText(R.string.str_xp_mzd_cx5_int_light_timeout_door_close_2);
                break;
            case 3:
                this.DoorCloseTV.setText(R.string.str_xp_mzd_cx5_int_light_timeout_door_close_3);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterHeadingOffTimer() {
        this.HeadlightOffTimerValue = DataCanbus.DATA[8];
        switch (this.HeadlightOffTimerValue) {
            case 0:
                this.HeadlightOffTimerTV.setText(R.string.klc_light_Lasuo_headlight_delay_3);
                break;
            case 1:
                this.HeadlightOffTimerTV.setText(R.string.str_xp_mzd_cx5_auto_relock_time_0);
                break;
            case 2:
                this.HeadlightOffTimerTV.setText(R.string.klc_light_Lasuo_headlight_delay_2);
                break;
            case 3:
                this.HeadlightOffTimerTV.setText(R.string.klc_light_Lasuo_headlight_delay_1);
                break;
            case 4:
                this.HeadlightOffTimerTV.setText(R.string.klc_Parking_with_trailer_Off);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFlashTurnSingnal() {
        this.flashTurnSingnalValue = DataCanbus.DATA[9];
        this.FlashChecked.setChecked(this.flashTurnSingnalValue != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoHeadingOn() {
        this.AutoHeadlingOnValue = DataCanbus.DATA[10];
        switch (this.AutoHeadlingOnValue) {
            case 0:
                this.AutoHeadlingOnTv.setText(R.string.str_xp_mzd_cx5_auto_headlight_on_0);
                break;
            case 1:
                this.AutoHeadlingOnTv.setText(R.string.str_xp_mzd_cx5_auto_headlight_on_1);
                break;
            case 2:
                this.AutoHeadlingOnTv.setText(R.string.str_xp_mzd_cx5_auto_headlight_on_2);
                break;
            case 3:
                this.AutoHeadlingOnTv.setText(R.string.str_xp_mzd_cx5_auto_headlight_on_3);
                break;
            case 4:
                this.AutoHeadlingOnTv.setText(R.string.str_xp_mzd_cx5_auto_headlight_on_4);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterWipers() {
        this.WipersValue = DataCanbus.DATA[11];
        this.WipersChecked.setChecked(this.WipersValue != 0);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xp_mzd_cx5_auto_door_lock_mode_pre /* 2131428803 */:
                if (this.autoDoorLockModeValue == 0) {
                    FucMZD.C_MZD_CX5_CMD(0, 4);
                    break;
                } else if (this.autoDoorLockModeValue == 1) {
                    FucMZD.C_MZD_CX5_CMD(0, 0);
                    break;
                } else if (this.autoDoorLockModeValue == 2) {
                    FucMZD.C_MZD_CX5_CMD(0, 1);
                    break;
                } else if (this.autoDoorLockModeValue == 3) {
                    FucMZD.C_MZD_CX5_CMD(0, 2);
                    break;
                } else if (this.autoDoorLockModeValue == 4) {
                    FucMZD.C_MZD_CX5_CMD(0, 3);
                    break;
                }
            case R.id.xp_mzd_cx5_auto_door_lock_mode_next /* 2131428805 */:
                if (this.autoDoorLockModeValue == 0) {
                    FucMZD.C_MZD_CX5_CMD(0, 1);
                    break;
                } else if (this.autoDoorLockModeValue == 1) {
                    FucMZD.C_MZD_CX5_CMD(0, 2);
                    break;
                } else if (this.autoDoorLockModeValue == 2) {
                    FucMZD.C_MZD_CX5_CMD(0, 3);
                    break;
                } else if (this.autoDoorLockModeValue == 3) {
                    FucMZD.C_MZD_CX5_CMD(0, 4);
                    break;
                } else if (this.autoDoorLockModeValue == 4) {
                    FucMZD.C_MZD_CX5_CMD(0, 0);
                    break;
                }
            case R.id.xp_mzd_cx5_unlock_mode_check /* 2131428806 */:
                FucMZD.C_MZD_CX5_CMD(1, this.unlockmodeValue == 0 ? 1 : 0);
                break;
            case R.id.xp_mzd_cx5_auto_relock_time_pre /* 2131428808 */:
                if (this.autoRelocktimeValue == 0) {
                    FucMZD.C_MZD_CX5_CMD(2, 2);
                    break;
                } else if (this.autoRelocktimeValue == 1) {
                    FucMZD.C_MZD_CX5_CMD(2, 0);
                    break;
                } else if (this.autoRelocktimeValue == 2) {
                    FucMZD.C_MZD_CX5_CMD(2, 1);
                    break;
                }
            case R.id.xp_mzd_cx5_auto_relock_time_next /* 2131428810 */:
                if (this.autoRelocktimeValue == 0) {
                    FucMZD.C_MZD_CX5_CMD(2, 1);
                    break;
                } else if (this.autoRelocktimeValue == 1) {
                    FucMZD.C_MZD_CX5_CMD(2, 2);
                    break;
                } else if (this.autoRelocktimeValue == 2) {
                    FucMZD.C_MZD_CX5_CMD(2, 0);
                    break;
                }
            case R.id.xp_mzd_cx5_lock_beep_volume_pre /* 2131428811 */:
                if (this.lockBeepVolumeValue == 0) {
                    FucMZD.C_MZD_CX5_CMD(3, 2);
                    break;
                } else if (this.lockBeepVolumeValue == 1) {
                    FucMZD.C_MZD_CX5_CMD(3, 0);
                    break;
                } else if (this.lockBeepVolumeValue == 2) {
                    FucMZD.C_MZD_CX5_CMD(3, 1);
                    break;
                } else if (this.lockBeepVolumeValue == 3) {
                    FucMZD.C_MZD_CX5_CMD(3, 2);
                    break;
                }
            case R.id.xp_mzd_cx5_lock_beep_volume_next /* 2131428813 */:
                if (this.lockBeepVolumeValue == 0) {
                    FucMZD.C_MZD_CX5_CMD(3, 1);
                    break;
                } else if (this.lockBeepVolumeValue == 1) {
                    FucMZD.C_MZD_CX5_CMD(3, 2);
                    break;
                } else if (this.lockBeepVolumeValue == 2) {
                    FucMZD.C_MZD_CX5_CMD(3, 3);
                    break;
                } else if (this.lockBeepVolumeValue == 3) {
                    FucMZD.C_MZD_CX5_CMD(3, 0);
                    break;
                }
            case R.id.xp_mzd_cx5_walk_away_lock_check /* 2131428815 */:
                FucMZD.C_MZD_CX5_CMD(4, this.walkawayValue != 0 ? 0 : 1);
                break;
            case R.id.xp_mzd_cx5_int_light_timeout_door_open_pre /* 2131428816 */:
                if (this.DoorOpenValue == 0) {
                    FucMZD.C_MZD_CX5_CMD(5, 2);
                    break;
                } else if (this.DoorOpenValue == 1) {
                    FucMZD.C_MZD_CX5_CMD(5, 0);
                    break;
                } else if (this.DoorOpenValue == 2) {
                    FucMZD.C_MZD_CX5_CMD(5, 1);
                    break;
                }
            case R.id.xp_mzd_cx5_int_light_timeout_door_open_next /* 2131428818 */:
                if (this.DoorOpenValue == 0) {
                    FucMZD.C_MZD_CX5_CMD(5, 1);
                    break;
                } else if (this.DoorOpenValue == 1) {
                    FucMZD.C_MZD_CX5_CMD(5, 2);
                    break;
                } else if (this.DoorOpenValue == 2) {
                    FucMZD.C_MZD_CX5_CMD(5, 0);
                    break;
                }
            case R.id.xp_mzd_cx5_int_light_timeout_door_close_pre /* 2131428819 */:
                if (this.DoorCloseValue == 0) {
                    FucMZD.C_MZD_CX5_CMD(6, 3);
                    break;
                } else if (this.DoorCloseValue == 1) {
                    FucMZD.C_MZD_CX5_CMD(6, 0);
                    break;
                } else if (this.DoorCloseValue == 2) {
                    FucMZD.C_MZD_CX5_CMD(6, 1);
                    break;
                } else if (this.DoorCloseValue == 3) {
                    FucMZD.C_MZD_CX5_CMD(6, 2);
                    break;
                }
            case R.id.xp_mzd_cx5_int_light_timeout_door_close_next /* 2131428821 */:
                if (this.DoorCloseValue == 0) {
                    FucMZD.C_MZD_CX5_CMD(6, 1);
                    break;
                } else if (this.DoorCloseValue == 1) {
                    FucMZD.C_MZD_CX5_CMD(6, 2);
                    break;
                } else if (this.DoorCloseValue == 2) {
                    FucMZD.C_MZD_CX5_CMD(6, 3);
                    break;
                } else if (this.DoorCloseValue == 3) {
                    FucMZD.C_MZD_CX5_CMD(6, 0);
                    break;
                }
            case R.id.xp_mzd_cx5_headlight_off_timer_pre /* 2131428822 */:
                if (this.HeadlightOffTimerValue == 0) {
                    FucMZD.C_MZD_CX5_CMD(8, 4);
                    break;
                } else if (this.HeadlightOffTimerValue == 1) {
                    FucMZD.C_MZD_CX5_CMD(8, 0);
                    break;
                } else if (this.HeadlightOffTimerValue == 2) {
                    FucMZD.C_MZD_CX5_CMD(8, 1);
                    break;
                } else if (this.HeadlightOffTimerValue == 3) {
                    FucMZD.C_MZD_CX5_CMD(8, 2);
                    break;
                } else if (this.HeadlightOffTimerValue == 4) {
                    FucMZD.C_MZD_CX5_CMD(8, 3);
                    break;
                }
            case R.id.xp_mzd_cx5_headlight_off_timer_next /* 2131428824 */:
                if (this.HeadlightOffTimerValue == 0) {
                    FucMZD.C_MZD_CX5_CMD(8, 1);
                    break;
                } else if (this.HeadlightOffTimerValue == 1) {
                    FucMZD.C_MZD_CX5_CMD(8, 2);
                    break;
                } else if (this.HeadlightOffTimerValue == 2) {
                    FucMZD.C_MZD_CX5_CMD(8, 3);
                    break;
                } else if (this.HeadlightOffTimerValue == 3) {
                    FucMZD.C_MZD_CX5_CMD(8, 4);
                    break;
                } else if (this.HeadlightOffTimerValue == 4) {
                    FucMZD.C_MZD_CX5_CMD(8, 0);
                    break;
                }
            case R.id.xp_mzd_cx5_flash_turn_singnal_check /* 2131428825 */:
                FucMZD.C_MZD_CX5_CMD(7, this.flashTurnSingnalValue != 0 ? 0 : 1);
                break;
            case R.id.xp_mzd_cx5_auto_headlight_on_pre /* 2131428826 */:
                if (this.AutoHeadlingOnValue == 0) {
                    FucMZD.C_MZD_CX5_CMD(9, 4);
                    break;
                } else if (this.AutoHeadlingOnValue == 1) {
                    FucMZD.C_MZD_CX5_CMD(9, 0);
                    break;
                } else if (this.AutoHeadlingOnValue == 2) {
                    FucMZD.C_MZD_CX5_CMD(9, 1);
                    break;
                } else if (this.AutoHeadlingOnValue == 3) {
                    FucMZD.C_MZD_CX5_CMD(9, 2);
                    break;
                } else if (this.AutoHeadlingOnValue == 4) {
                    FucMZD.C_MZD_CX5_CMD(9, 3);
                    break;
                }
            case R.id.xp_mzd_cx5_auto_headlight_on_next /* 2131428828 */:
                if (this.AutoHeadlingOnValue == 0) {
                    FucMZD.C_MZD_CX5_CMD(9, 1);
                    break;
                } else if (this.AutoHeadlingOnValue == 1) {
                    FucMZD.C_MZD_CX5_CMD(9, 2);
                    break;
                } else if (this.AutoHeadlingOnValue == 2) {
                    FucMZD.C_MZD_CX5_CMD(9, 3);
                    break;
                } else if (this.AutoHeadlingOnValue == 3) {
                    FucMZD.C_MZD_CX5_CMD(9, 4);
                    break;
                } else if (this.AutoHeadlingOnValue == 4) {
                    FucMZD.C_MZD_CX5_CMD(9, 0);
                    break;
                }
            case R.id.xp_mzd_cx5_wipers_check /* 2131428829 */:
                FucMZD.C_MZD_CX5_CMD(10, this.WipersValue != 0 ? 0 : 1);
                break;
        }
    }
}
