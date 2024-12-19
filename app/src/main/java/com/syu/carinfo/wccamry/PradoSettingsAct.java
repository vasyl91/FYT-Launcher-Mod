package com.syu.carinfo.wccamry;

import android.content.Intent;
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
public class PradoSettingsAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 4:
                    PradoSettingsAct.this.mUpdaterInteriorLightOffTime();
                    break;
                case 5:
                    PradoSettingsAct.this.mUpdaterAutolockBySpeed();
                    break;
                case 6:
                    PradoSettingsAct.this.mUpdaterAutolockByShiftFromP();
                    break;
                case 7:
                    PradoSettingsAct.this.mUpdaterAutoUnlockByShiftToP();
                    break;
                case 8:
                    PradoSettingsAct.this.mUpdaterAutoAc();
                    break;
                case 9:
                    PradoSettingsAct.this.mUpdaterValidVentilation();
                    break;
                case 10:
                    PradoSettingsAct.this.mUpdaterRemote2PressUnlock();
                    break;
                case 11:
                    PradoSettingsAct.this.mUpdaterHeadLampsOnSensitivity();
                    break;
                case 12:
                    PradoSettingsAct.this.m2TimesKeyUnLock();
                    break;
                case 13:
                    PradoSettingsAct.this.mUpdaterUnLockByDriversDoorOpen();
                    break;
                case 14:
                    PradoSettingsAct.this.mUpdaterLockUnLockFeedbackByLights();
                    break;
                case 15:
                    PradoSettingsAct.this.mUpdaterKeySystemWithElecKey();
                    break;
                case 16:
                    PradoSettingsAct.this.mUpdaterSmartLockAndOneKeyBoot();
                    break;
                case 21:
                    PradoSettingsAct.this.mUpdaterRadarSwitch();
                    break;
                case 22:
                    PradoSettingsAct.this.mUpdaterRadarAlarmVol();
                    break;
                case 24:
                    PradoSettingsAct.this.mUpdaterRadarfrontRange();
                    break;
                case 25:
                    PradoSettingsAct.this.mUpdaterRadarrearRange();
                    break;
                case 28:
                    PradoSettingsAct.this.mUpdaterDsplinkspeed();
                    break;
                case 29:
                    PradoSettingsAct.this.mUpdaterDspsurround();
                    break;
                case 33:
                    PradoSettingsAct.this.mUpdaterOutLightOffTime();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_18pardo_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_autolock_by_speed)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[5] == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(0, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_unlock_intelligent_door)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[15] == 0) {
                    DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(1, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_unlock_driver_door_linkage)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[13] == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(2, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_autounlock_by_shift_to_p)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[7] == 0) {
                    DataCanbus.PROXY.cmd(3, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(3, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_autolock_by_shift_from_p)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[6] == 0) {
                    DataCanbus.PROXY.cmd(4, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(4, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_lock_unlock_emergency_flashers_response)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[14] == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(5, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_remote_2_press_unlock)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[10] == 0) {
                    DataCanbus.PROXY.cmd(8, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(8, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_intelligent_lock_and_one_key_start)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[16] == 0) {
                    DataCanbus.PROXY.cmd(6, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(6, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_unlock_operation_key_two_times)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[12] == 0) {
                    DataCanbus.PROXY.cmd(7, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(7, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.rav4_btn_auto_ac_enabled)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[8] == 0) {
                    DataCanbus.PROXY.cmd(9, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(9, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.rav4_btn_valid_ventilation_enabled)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[9] == 0) {
                    DataCanbus.PROXY.cmd(10, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(10, new int[1], null, null);
                }
            }
        });
        ((Button) findViewById(R.id.rav4_btn_sens_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = 0;
                int value2 = DataCanbus.DATA[11];
                if (value2 > 0 && value2 - 1 > -1 && value < 5) {
                    DataCanbus.PROXY.cmd(11, new int[]{value}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.rav4_btn_sens_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[11];
                if (value2 < 4 && (value = value2 + 1) > -1 && value < 5) {
                    DataCanbus.PROXY.cmd(11, new int[]{value}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.rav4_btn_interior_lighting_off_time_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[4];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(12, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.rav4_btn_interior_lighting_off_time_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[4];
                if (value < 3) {
                    DataCanbus.PROXY.cmd(12, new int[]{value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.rav4_btn_out_lighting_off_time_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[33];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(21, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.rav4_btn_out_lighting_off_time_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[33];
                if (value < 3) {
                    DataCanbus.PROXY.cmd(21, new int[]{value + 1}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.rav4_btn_radar_switch)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[21] == 0) {
                    DataCanbus.PROXY.cmd(24, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(24, new int[1], null, null);
                }
            }
        });
        ((Button) findViewById(R.id.rav4_btn_radar_alarm_volume_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[22];
                if (value > 1) {
                    DataCanbus.PROXY.cmd(25, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.rav4_btn_radar_alarm_volume_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[22];
                if (value < 5) {
                    DataCanbus.PROXY.cmd(25, new int[]{value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.rav4_btn_radar_front_range_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(26, new int[]{1}, null, null);
            }
        });
        ((Button) findViewById(R.id.rav4_btn_radar_front_range)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(26, new int[]{1}, null, null);
            }
        });
        ((Button) findViewById(R.id.rav4_btn_radar_rear_range_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.24
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(26, new int[]{2}, null, null);
            }
        });
        ((Button) findViewById(R.id.rav4_btn_radar_rear_range)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.25
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(26, new int[]{2}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.pardo_btn_vol_link_speed)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.26
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[28] == 0) {
                    DataCanbus.PROXY.cmd(19, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(19, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.pardo_btn_surround)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.27
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[29] == 0) {
                    DataCanbus.PROXY.cmd(20, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(20, new int[1], null, null);
                }
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            try {
                Intent intent = new Intent();
                intent.setClass(this, Rav4TripAct.class);
                startActivity(intent);
                finish();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }
        return true;
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDsplinkspeed() {
        int value = DataCanbus.DATA[28];
        if (((CheckedTextView) findViewById(R.id.pardo_btn_vol_link_speed)) != null) {
            ((CheckedTextView) findViewById(R.id.pardo_btn_vol_link_speed)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDspsurround() {
        int value = DataCanbus.DATA[29];
        if (((CheckedTextView) findViewById(R.id.pardo_btn_surround)) != null) {
            ((CheckedTextView) findViewById(R.id.pardo_btn_surround)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutolockBySpeed() {
        int value = DataCanbus.DATA[5];
        if (((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_autolock_by_speed)) != null) {
            ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_autolock_by_speed)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterKeySystemWithElecKey() {
        int value = DataCanbus.DATA[15];
        if (((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_unlock_intelligent_door)) != null) {
            ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_unlock_intelligent_door)).setChecked(value != 0);
        }
        if (value == 0) {
            ((TextView) findViewById(R.id.rav4_tv_lock_set_unlock_intelligent_door)).setText(R.string.lock_set_unlock_intelligent_door_all);
        } else {
            ((TextView) findViewById(R.id.rav4_tv_lock_set_unlock_intelligent_door)).setText(R.string.lock_set_unlock_intelligent_door_driver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterUnLockByDriversDoorOpen() {
        int value = DataCanbus.DATA[13];
        if (((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_unlock_driver_door_linkage)) != null) {
            ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_unlock_driver_door_linkage)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutoUnlockByShiftToP() {
        int value = DataCanbus.DATA[7];
        if (((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_autounlock_by_shift_to_p)) != null) {
            ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_autounlock_by_shift_to_p)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutolockByShiftFromP() {
        int value = DataCanbus.DATA[6];
        if (((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_autolock_by_shift_from_p)) != null) {
            ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_autolock_by_shift_from_p)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLockUnLockFeedbackByLights() {
        int value = DataCanbus.DATA[14];
        if (((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_lock_unlock_emergency_flashers_response)) != null) {
            ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_lock_unlock_emergency_flashers_response)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRemote2PressUnlock() {
        int value = DataCanbus.DATA[10];
        if (((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_remote_2_press_unlock)) != null) {
            ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_remote_2_press_unlock)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSmartLockAndOneKeyBoot() {
        int value = DataCanbus.DATA[16];
        if (((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_intelligent_lock_and_one_key_start)) != null) {
            ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_intelligent_lock_and_one_key_start)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m2TimesKeyUnLock() {
        int value = DataCanbus.DATA[12];
        if (((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_unlock_operation_key_two_times)) != null) {
            ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_unlock_operation_key_two_times)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutoAc() {
        int value = DataCanbus.DATA[8];
        if (((CheckedTextView) findViewById(R.id.rav4_btn_auto_ac_enabled)) != null) {
            ((CheckedTextView) findViewById(R.id.rav4_btn_auto_ac_enabled)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValidVentilation() {
        int value = DataCanbus.DATA[9];
        if (((CheckedTextView) findViewById(R.id.rav4_btn_valid_ventilation_enabled)) != null) {
            ((CheckedTextView) findViewById(R.id.rav4_btn_valid_ventilation_enabled)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterInteriorLightOffTime() {
        int value = DataCanbus.DATA[4];
        if (((TextView) findViewById(R.id.rav4_tv_interior_lighting_off_time)) != null && value > -1 && value < 5) {
            ((TextView) findViewById(R.id.rav4_tv_interior_lighting_off_time)).setText(ConstWcToyota.mStrInteriorLightOffTime[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOutLightOffTime() {
        int value = DataCanbus.DATA[33];
        if (((TextView) findViewById(R.id.rav4_tv_out_lighting_off_time)) != null && value > -1 && value < 5) {
            ((TextView) findViewById(R.id.rav4_tv_out_lighting_off_time)).setText(ConstWcToyota.mStrInteriorLightOffTime[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterHeadLampsOnSensitivity() {
        int value = DataCanbus.DATA[11];
        if (((TextView) findViewById(R.id.rav4_tv_sens_cur)) != null && value > -1 && value < 5) {
            ((TextView) findViewById(R.id.rav4_tv_sens_cur)).setBackgroundResource(Rav4Data.mSensDrawableId[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRadarSwitch() {
        int value = DataCanbus.DATA[21];
        if (((CheckedTextView) findViewById(R.id.rav4_btn_radar_switch)) != null) {
            ((CheckedTextView) findViewById(R.id.rav4_btn_radar_switch)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRadarAlarmVol() {
        int value = DataCanbus.DATA[22];
        if (((TextView) findViewById(R.id.rav4_tv_radar_alarm_volume)) != null && value >= 1 && value < 6) {
            ((TextView) findViewById(R.id.rav4_tv_radar_alarm_volume)).setBackgroundResource(ConstWcToyota.mSensDrawableId[value - 1]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRadarfrontRange() {
        int mFrontRamge = DataCanbus.DATA[24];
        if (((TextView) findViewById(R.id.rav4_tv_radar_front_range)) != null) {
            if (mFrontRamge == 1) {
                ((TextView) findViewById(R.id.rav4_tv_radar_front_range)).setText(R.string.radar_range_level1);
            } else {
                ((TextView) findViewById(R.id.rav4_tv_radar_front_range)).setText(R.string.radar_range_level2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRadarrearRange() {
        int mRearRamge = DataCanbus.DATA[25];
        if (((TextView) findViewById(R.id.rav4_tv_radar_rear_range)) != null) {
            if (mRearRamge == 1) {
                ((TextView) findViewById(R.id.rav4_tv_radar_rear_range)).setText(R.string.radar_range_level1);
            } else {
                ((TextView) findViewById(R.id.rav4_tv_radar_rear_range)).setText(R.string.radar_range_level2);
            }
        }
    }
}
