package com.syu.carinfo.pardo2014.wc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.wccamry.ConstWcToyota;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.CallbackCanbusBase;
import com.syu.module.canbus.Callback_0121_WC2_14Prado;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.ModuleCallbackCanbusProxy;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class PardoSettingsAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.pardo2014.wc.PardoSettingsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 4:
                    PardoSettingsAct.this.mUpdaterInteriorLightOffTime();
                    break;
                case 5:
                    PardoSettingsAct.this.mUpdaterRemote2PressUnlock();
                    break;
                case 6:
                    PardoSettingsAct.this.mUpdaterHeadLampsOnSensitivity();
                    break;
                case 7:
                    PardoSettingsAct.this.m2TimesKeyUnLock();
                    break;
                case 8:
                    PardoSettingsAct.this.mUpdaterLockUnLockFeedbackByLights();
                    break;
                case 9:
                    PardoSettingsAct.this.mUpdaterKeySystemWithElecKey();
                    break;
                case 10:
                    PardoSettingsAct.this.mUpdaterSmartLockAndOneKeyBoot();
                    break;
                case 13:
                    PardoSettingsAct.this.mUpdaterRadarSwitch();
                    break;
                case 14:
                    PardoSettingsAct.this.mUpdaterRadarAlarmVol();
                    break;
                case 15:
                    PardoSettingsAct.this.mUpdaterRadarfrontRange();
                    break;
                case 16:
                    PardoSettingsAct.this.mUpdaterRadarrearRange();
                    break;
                case 17:
                    PardoSettingsAct.this.mUpdaterInOutAirByAutoKey();
                    break;
                case 18:
                    PardoSettingsAct.this.mUpdaterAirByAutoKey();
                    break;
                case 19:
                    PardoSettingsAct.this.mUpdaterOutLightOffTime();
                    break;
                case 21:
                    PardoSettingsAct.this.mUpdaterDsplinkspeed();
                    break;
                case 22:
                    PardoSettingsAct.this.mUpdaterDspsurround();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pardo_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        CallbackCanbusBase callback = ModuleCallbackCanbusProxy.getInstance().getCallbackCanbus();
        if (!(callback instanceof Callback_0121_WC2_14Prado)) {
            finish();
            return;
        }
        if (findViewById(R.id.pardo_view_set_high) != null) {
            if (DataCanbus.DATA[1000] == 131193 || DataCanbus.DATA[1000] == 262265 || DataCanbus.DATA[1000] == 721017 || DataCanbus.DATA[1000] == 524409) {
                findViewById(R.id.pardo_view_set_high).setVisibility(0);
            } else {
                findViewById(R.id.pardo_view_set_high).setVisibility(8);
            }
        }
        if (findViewById(R.id.pardo_dsp) != null) {
            if (DataCanbus.DATA[1000] == 121 || DataCanbus.DATA[1000] == 196729 || DataCanbus.DATA[1000] == 458873 || DataCanbus.DATA[1000] == 589945 || DataCanbus.DATA[1000] == 655481) {
                findViewById(R.id.pardo_dsp).setVisibility(8);
            } else {
                findViewById(R.id.pardo_dsp).setVisibility(0);
            }
        }
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((CheckedTextView) findViewById(R.id.pardo_btn_lock_set_remote_2_press_unlock)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.pardo2014.wc.PardoSettingsAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[5] == 0) {
                    DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(1, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.pardo_btn_lock_set_unlock_operation_key_two_times)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.pardo2014.wc.PardoSettingsAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[7] == 0) {
                    DataCanbus.PROXY.cmd(4, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(4, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.pardo_btn_lock_set_unlock_intelligent_door)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.pardo2014.wc.PardoSettingsAct.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[9] == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(5, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.pardo_btn_lock_set_intelligent_lock_and_one_key_start)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.pardo2014.wc.PardoSettingsAct.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[10] == 0) {
                    DataCanbus.PROXY.cmd(6, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(6, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.pardo_btn_lock_set_lock_unlock_emergency_flashers_response)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.pardo2014.wc.PardoSettingsAct.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[8] == 0) {
                    DataCanbus.PROXY.cmd(7, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(7, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.pardo_btn_climate_set_air_conditioning_and_AUTO_bond_linkage)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.pardo2014.wc.PardoSettingsAct.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[18] == 0) {
                    DataCanbus.PROXY.cmd(8, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(8, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.pardo_btn_climate_set_gas_switch_and_AUTO_bond_linkage)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.pardo2014.wc.PardoSettingsAct.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[17] == 0) {
                    DataCanbus.PROXY.cmd(9, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(9, new int[1], null, null);
                }
            }
        });
        ((Button) findViewById(R.id.pardo_btn_sens_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.pardo2014.wc.PardoSettingsAct.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[6];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.pardo_btn_sens_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.pardo2014.wc.PardoSettingsAct.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[6];
                if (value < 4) {
                    DataCanbus.PROXY.cmd(0, new int[]{value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.pardo_btn_interior_lighting_off_time_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.pardo2014.wc.PardoSettingsAct.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[4];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.pardo_btn_interior_lighting_off_time_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.pardo2014.wc.PardoSettingsAct.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[4];
                if (value < 3) {
                    DataCanbus.PROXY.cmd(2, new int[]{value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.pardo_btn_out_lighting_off_time_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.pardo2014.wc.PardoSettingsAct.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[19];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(3, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.pardo_btn_out_lighting_off_time_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.pardo2014.wc.PardoSettingsAct.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[19];
                if (value < 3) {
                    DataCanbus.PROXY.cmd(3, new int[]{value + 1}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.pardo_btn_radar_switch)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.pardo2014.wc.PardoSettingsAct.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[13] == 0) {
                    DataCanbus.PROXY.cmd(10, new int[1], null, null);
                } else {
                    DataCanbus.PROXY.cmd(10, new int[]{1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.pardo_btn_radar_alarm_volume_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.pardo2014.wc.PardoSettingsAct.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[14];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(11, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.pardo_btn_radar_alarm_volume_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.pardo2014.wc.PardoSettingsAct.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[14];
                if (value < 4) {
                    DataCanbus.PROXY.cmd(11, new int[]{value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.pardo_btn_radar_front_range_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.pardo2014.wc.PardoSettingsAct.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(12, new int[1], null, null);
            }
        });
        ((Button) findViewById(R.id.pardo_btn_radar_front_range)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.pardo2014.wc.PardoSettingsAct.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(12, new int[1], null, null);
            }
        });
        ((Button) findViewById(R.id.pardo_btn_radar_rear_range_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.pardo2014.wc.PardoSettingsAct.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(12, new int[]{1}, null, null);
            }
        });
        ((Button) findViewById(R.id.pardo_btn_radar_rear_range)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.pardo2014.wc.PardoSettingsAct.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(12, new int[]{1}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.pardo_btn_vol_link_speed)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.pardo2014.wc.PardoSettingsAct.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[21] == 0) {
                    DataCanbus.PROXY.cmd(15, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(15, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.pardo_btn_surround)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.pardo2014.wc.PardoSettingsAct.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[22] == 0) {
                    DataCanbus.PROXY.cmd(16, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(16, new int[1], null, null);
                }
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRemote2PressUnlock() {
        int value = DataCanbus.DATA[5];
        if (((CheckedTextView) findViewById(R.id.pardo_btn_lock_set_remote_2_press_unlock)) != null) {
            ((CheckedTextView) findViewById(R.id.pardo_btn_lock_set_remote_2_press_unlock)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m2TimesKeyUnLock() {
        int value = DataCanbus.DATA[7];
        if (((CheckedTextView) findViewById(R.id.pardo_btn_lock_set_unlock_operation_key_two_times)) != null) {
            ((CheckedTextView) findViewById(R.id.pardo_btn_lock_set_unlock_operation_key_two_times)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterKeySystemWithElecKey() {
        int value = DataCanbus.DATA[9];
        if (((CheckedTextView) findViewById(R.id.pardo_btn_lock_set_unlock_intelligent_door)) != null) {
            ((CheckedTextView) findViewById(R.id.pardo_btn_lock_set_unlock_intelligent_door)).setChecked(value != 0);
        }
        if (value == 0) {
            ((TextView) findViewById(R.id.pardo_tv_lock_set_unlock_intelligent_door)).setText(R.string.lock_set_unlock_intelligent_door_all);
        } else {
            ((TextView) findViewById(R.id.pardo_tv_lock_set_unlock_intelligent_door)).setText(R.string.lock_set_unlock_intelligent_door_driver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSmartLockAndOneKeyBoot() {
        int value = DataCanbus.DATA[10];
        if (((CheckedTextView) findViewById(R.id.pardo_btn_lock_set_intelligent_lock_and_one_key_start)) != null) {
            ((CheckedTextView) findViewById(R.id.pardo_btn_lock_set_intelligent_lock_and_one_key_start)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLockUnLockFeedbackByLights() {
        int value = DataCanbus.DATA[8];
        if (((CheckedTextView) findViewById(R.id.pardo_btn_lock_set_lock_unlock_emergency_flashers_response)) != null) {
            ((CheckedTextView) findViewById(R.id.pardo_btn_lock_set_lock_unlock_emergency_flashers_response)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirByAutoKey() {
        int value = DataCanbus.DATA[18];
        if (((CheckedTextView) findViewById(R.id.pardo_btn_climate_set_air_conditioning_and_AUTO_bond_linkage)) != null) {
            ((CheckedTextView) findViewById(R.id.pardo_btn_climate_set_air_conditioning_and_AUTO_bond_linkage)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterInOutAirByAutoKey() {
        int value = DataCanbus.DATA[17];
        if (((CheckedTextView) findViewById(R.id.pardo_btn_climate_set_gas_switch_and_AUTO_bond_linkage)) != null) {
            ((CheckedTextView) findViewById(R.id.pardo_btn_climate_set_gas_switch_and_AUTO_bond_linkage)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterHeadLampsOnSensitivity() {
        int value = DataCanbus.DATA[6];
        if (((TextView) findViewById(R.id.pardo_tv_sens_cur)) != null && value > -1 && value < 5) {
            ((TextView) findViewById(R.id.pardo_tv_sens_cur)).setBackgroundResource(ConstWcToyota.mSensDrawableId[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterInteriorLightOffTime() {
        int value = DataCanbus.DATA[4];
        if (((TextView) findViewById(R.id.pardo_tv_interior_lighting_off_time)) != null && value > -1 && value < 4) {
            ((TextView) findViewById(R.id.pardo_tv_interior_lighting_off_time)).setText(PardoData.mStrLightOffTime[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOutLightOffTime() {
        int value = DataCanbus.DATA[19];
        if (((TextView) findViewById(R.id.pardo_tv_out_lighting_off_time)) != null && value > -1 && value < 4) {
            ((TextView) findViewById(R.id.pardo_tv_out_lighting_off_time)).setText(PardoData.mStrLightOffTime[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRadarSwitch() {
        int value = DataCanbus.DATA[13];
        if (((CheckedTextView) findViewById(R.id.pardo_btn_radar_switch)) != null) {
            ((CheckedTextView) findViewById(R.id.pardo_btn_radar_switch)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRadarAlarmVol() {
        int value = DataCanbus.DATA[14];
        if (((TextView) findViewById(R.id.pardo_tv_radar_alarm_volume)) != null && value > -1 && value < 5) {
            ((TextView) findViewById(R.id.pardo_tv_radar_alarm_volume)).setBackgroundResource(ConstWcToyota.mSensDrawableId[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRadarfrontRange() {
        int mFrontRamge = DataCanbus.DATA[15];
        if (((TextView) findViewById(R.id.pardo_tv_radar_front_range)) != null) {
            if (mFrontRamge == 0) {
                ((TextView) findViewById(R.id.pardo_tv_radar_front_range)).setText(R.string.radar_range_level1);
            } else {
                ((TextView) findViewById(R.id.pardo_tv_radar_front_range)).setText(R.string.radar_range_level2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRadarrearRange() {
        int mRearRamge = DataCanbus.DATA[16];
        if (((TextView) findViewById(R.id.pardo_tv_radar_rear_range)) != null) {
            if (mRearRamge == 0) {
                ((TextView) findViewById(R.id.pardo_tv_radar_rear_range)).setText(R.string.radar_range_level1);
            } else {
                ((TextView) findViewById(R.id.pardo_tv_radar_rear_range)).setText(R.string.radar_range_level2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDsplinkspeed() {
        int value = DataCanbus.DATA[21];
        if (((CheckedTextView) findViewById(R.id.pardo_btn_vol_link_speed)) != null) {
            ((CheckedTextView) findViewById(R.id.pardo_btn_vol_link_speed)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDspsurround() {
        int value = DataCanbus.DATA[22];
        if (((CheckedTextView) findViewById(R.id.pardo_btn_surround)) != null) {
            ((CheckedTextView) findViewById(R.id.pardo_btn_surround)).setChecked(value != 0);
        }
    }
}
