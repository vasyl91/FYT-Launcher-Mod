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

@SuppressWarnings({"deprecation", "unchecked"})
public class PardoSettingsAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 102:
                    PardoSettingsAct.this.mUpdaterInteriorLightOffTime();
                    break;
                case 103:
                    PardoSettingsAct.this.mUpdaterRemote2PressUnlock();
                    break;
                case 104:
                    PardoSettingsAct.this.mUpdaterHeadLampsOnSensitivity();
                    break;
                case 105:
                    PardoSettingsAct.this.m2TimesKeyUnLock();
                    break;
                case 106:
                    PardoSettingsAct.this.mUpdaterLockUnLockFeedbackByLights();
                    break;
                case 107:
                    PardoSettingsAct.this.mUpdaterKeySystemWithElecKey();
                    break;
                case 108:
                    PardoSettingsAct.this.mUpdaterSmartLockAndOneKeyBoot();
                    break;
                case 111:
                    PardoSettingsAct.this.mUpdaterRadarSwitch();
                    break;
                case 112:
                    PardoSettingsAct.this.mUpdaterRadarAlarmVol();
                    break;
                case 113:
                    PardoSettingsAct.this.mUpdaterRadarfrontRange();
                    break;
                case 114:
                    PardoSettingsAct.this.mUpdaterRadarrearRange();
                    break;
                case 115:
                    PardoSettingsAct.this.mUpdaterInOutAirByAutoKey();
                    break;
                case 116:
                    PardoSettingsAct.this.mUpdaterAirByAutoKey();
                    break;
                case 117:
                    PardoSettingsAct.this.mUpdaterOutLightOffTime();
                    break;
                case 119:
                    PardoSettingsAct.this.mUpdaterDsplinkspeed();
                    break;
                case 120:
                    PardoSettingsAct.this.mUpdaterDspsurround();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_pardo_settings);
        init();
    }

    @Override
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

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.pardo_btn_lock_set_remote_2_press_unlock)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[103] == 0) {
                    DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(1, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.pardo_btn_lock_set_unlock_operation_key_two_times)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[105] == 0) {
                    DataCanbus.PROXY.cmd(4, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(4, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.pardo_btn_lock_set_unlock_intelligent_door)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[107] == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(5, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.pardo_btn_lock_set_intelligent_lock_and_one_key_start)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[108] == 0) {
                    DataCanbus.PROXY.cmd(6, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(6, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.pardo_btn_lock_set_lock_unlock_emergency_flashers_response)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[106] == 0) {
                    DataCanbus.PROXY.cmd(7, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(7, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.pardo_btn_climate_set_air_conditioning_and_AUTO_bond_linkage)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[116] == 0) {
                    DataCanbus.PROXY.cmd(8, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(8, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.pardo_btn_climate_set_gas_switch_and_AUTO_bond_linkage)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[115] == 0) {
                    DataCanbus.PROXY.cmd(9, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(9, new int[1], null, null);
                }
            }
        });
        ((Button) findViewById(R.id.pardo_btn_sens_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[104];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.pardo_btn_sens_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[104];
                if (value < 4) {
                    DataCanbus.PROXY.cmd(0, new int[]{value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.pardo_btn_interior_lighting_off_time_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[102];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.pardo_btn_interior_lighting_off_time_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[102];
                if (value < 3) {
                    DataCanbus.PROXY.cmd(2, new int[]{value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.pardo_btn_out_lighting_off_time_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[117];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(3, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.pardo_btn_out_lighting_off_time_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[117];
                if (value < 3) {
                    DataCanbus.PROXY.cmd(3, new int[]{value + 1}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.pardo_btn_radar_switch)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[111] == 0) {
                    DataCanbus.PROXY.cmd(10, new int[1], null, null);
                } else {
                    DataCanbus.PROXY.cmd(10, new int[]{1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.pardo_btn_radar_alarm_volume_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[112];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(11, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.pardo_btn_radar_alarm_volume_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[112];
                if (value < 4) {
                    DataCanbus.PROXY.cmd(11, new int[]{value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.pardo_btn_radar_front_range_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(12, new int[1], null, null);
            }
        });
        ((Button) findViewById(R.id.pardo_btn_radar_front_range)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(12, new int[1], null, null);
            }
        });
        ((Button) findViewById(R.id.pardo_btn_radar_rear_range_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(12, new int[]{1}, null, null);
            }
        });
        ((Button) findViewById(R.id.pardo_btn_radar_rear_range)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(12, new int[]{1}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.pardo_btn_vol_link_speed)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[119] == 0) {
                    DataCanbus.PROXY.cmd(15, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(15, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.pardo_btn_surround)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[120] == 0) {
                    DataCanbus.PROXY.cmd(16, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(16, new int[1], null, null);
                }
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterRemote2PressUnlock() {
        int value = DataCanbus.DATA[103];
        if (((CheckedTextView) findViewById(R.id.pardo_btn_lock_set_remote_2_press_unlock)) != null) {
            ((CheckedTextView) findViewById(R.id.pardo_btn_lock_set_remote_2_press_unlock)).setChecked(value != 0);
        }
    }

    
    public void m2TimesKeyUnLock() {
        int value = DataCanbus.DATA[105];
        if (((CheckedTextView) findViewById(R.id.pardo_btn_lock_set_unlock_operation_key_two_times)) != null) {
            ((CheckedTextView) findViewById(R.id.pardo_btn_lock_set_unlock_operation_key_two_times)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterKeySystemWithElecKey() {
        int value = DataCanbus.DATA[107];
        if (((CheckedTextView) findViewById(R.id.pardo_btn_lock_set_unlock_intelligent_door)) != null) {
            ((CheckedTextView) findViewById(R.id.pardo_btn_lock_set_unlock_intelligent_door)).setChecked(value != 0);
        }
        if (value == 0) {
            ((TextView) findViewById(R.id.pardo_tv_lock_set_unlock_intelligent_door)).setText(R.string.lock_set_unlock_intelligent_door_all);
        } else {
            ((TextView) findViewById(R.id.pardo_tv_lock_set_unlock_intelligent_door)).setText(R.string.lock_set_unlock_intelligent_door_driver);
        }
    }

    
    public void mUpdaterSmartLockAndOneKeyBoot() {
        int value = DataCanbus.DATA[108];
        if (((CheckedTextView) findViewById(R.id.pardo_btn_lock_set_intelligent_lock_and_one_key_start)) != null) {
            ((CheckedTextView) findViewById(R.id.pardo_btn_lock_set_intelligent_lock_and_one_key_start)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterLockUnLockFeedbackByLights() {
        int value = DataCanbus.DATA[106];
        if (((CheckedTextView) findViewById(R.id.pardo_btn_lock_set_lock_unlock_emergency_flashers_response)) != null) {
            ((CheckedTextView) findViewById(R.id.pardo_btn_lock_set_lock_unlock_emergency_flashers_response)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterAirByAutoKey() {
        int value = DataCanbus.DATA[116];
        if (((CheckedTextView) findViewById(R.id.pardo_btn_climate_set_air_conditioning_and_AUTO_bond_linkage)) != null) {
            ((CheckedTextView) findViewById(R.id.pardo_btn_climate_set_air_conditioning_and_AUTO_bond_linkage)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterInOutAirByAutoKey() {
        int value = DataCanbus.DATA[115];
        if (((CheckedTextView) findViewById(R.id.pardo_btn_climate_set_gas_switch_and_AUTO_bond_linkage)) != null) {
            ((CheckedTextView) findViewById(R.id.pardo_btn_climate_set_gas_switch_and_AUTO_bond_linkage)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterHeadLampsOnSensitivity() {
        int value = DataCanbus.DATA[104];
        if (((TextView) findViewById(R.id.pardo_tv_sens_cur)) != null && value > -1 && value < 5) {
            ((TextView) findViewById(R.id.pardo_tv_sens_cur)).setBackgroundResource(ConstWcToyota.mSensDrawableId[value]);
        }
    }

    
    public void mUpdaterInteriorLightOffTime() {
        int value = DataCanbus.DATA[102];
        if (((TextView) findViewById(R.id.pardo_tv_interior_lighting_off_time)) != null && value > -1 && value < 4) {
            ((TextView) findViewById(R.id.pardo_tv_interior_lighting_off_time)).setText(PardoData.mStrLightOffTime[value]);
        }
    }

    
    public void mUpdaterOutLightOffTime() {
        int value = DataCanbus.DATA[117];
        if (((TextView) findViewById(R.id.pardo_tv_out_lighting_off_time)) != null && value > -1 && value < 4) {
            ((TextView) findViewById(R.id.pardo_tv_out_lighting_off_time)).setText(PardoData.mStrLightOffTime[value]);
        }
    }

    
    public void mUpdaterRadarSwitch() {
        int value = DataCanbus.DATA[111];
        if (((CheckedTextView) findViewById(R.id.pardo_btn_radar_switch)) != null) {
            ((CheckedTextView) findViewById(R.id.pardo_btn_radar_switch)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterRadarAlarmVol() {
        int value = DataCanbus.DATA[112];
        if (((TextView) findViewById(R.id.pardo_tv_radar_alarm_volume)) != null && value > -1 && value < 5) {
            ((TextView) findViewById(R.id.pardo_tv_radar_alarm_volume)).setBackgroundResource(ConstWcToyota.mSensDrawableId[value]);
        }
    }

    
    public void mUpdaterRadarfrontRange() {
        int mFrontRamge = DataCanbus.DATA[113];
        if (((TextView) findViewById(R.id.pardo_tv_radar_front_range)) != null) {
            if (mFrontRamge == 0) {
                ((TextView) findViewById(R.id.pardo_tv_radar_front_range)).setText(R.string.radar_range_level1);
            } else {
                ((TextView) findViewById(R.id.pardo_tv_radar_front_range)).setText(R.string.radar_range_level2);
            }
        }
    }

    
    public void mUpdaterRadarrearRange() {
        int mRearRamge = DataCanbus.DATA[114];
        if (((TextView) findViewById(R.id.pardo_tv_radar_rear_range)) != null) {
            if (mRearRamge == 0) {
                ((TextView) findViewById(R.id.pardo_tv_radar_rear_range)).setText(R.string.radar_range_level1);
            } else {
                ((TextView) findViewById(R.id.pardo_tv_radar_rear_range)).setText(R.string.radar_range_level2);
            }
        }
    }

    
    public void mUpdaterDsplinkspeed() {
        int value = DataCanbus.DATA[119];
        if (((CheckedTextView) findViewById(R.id.pardo_btn_vol_link_speed)) != null) {
            ((CheckedTextView) findViewById(R.id.pardo_btn_vol_link_speed)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterDspsurround() {
        int value = DataCanbus.DATA[120];
        if (((CheckedTextView) findViewById(R.id.pardo_btn_surround)) != null) {
            ((CheckedTextView) findViewById(R.id.pardo_btn_surround)).setChecked(value != 0);
        }
    }
}
