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
public class YLInfoSetFirstAct_BNR extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 104:
                    YLInfoSetFirstAct_BNR.this.updaterlightsParking();
                    break;
                case 105:
                    YLInfoSetFirstAct_BNR.this.updaterLasuoHeadlightDelay();
                    break;
                case 106:
                    YLInfoSetFirstAct_BNR.this.updaterdefeatDoorAutoLock();
                    break;
                case 107:
                    YLInfoSetFirstAct_BNR.this.updaterdoorAutoLock();
                    break;
                case 108:
                    YLInfoSetFirstAct_BNR.this.updaterparkCarAutoUnlock();
                    break;
                case 109:
                    YLInfoSetFirstAct_BNR.this.updaterlaterLock();
                    break;
                case 110:
                    YLInfoSetFirstAct_BNR.this.updaterremoteUnlockLight();
                    break;
                case 111:
                    YLInfoSetFirstAct_BNR.this.updaterremoteLockDoor();
                    break;
                case 112:
                    YLInfoSetFirstAct_BNR.this.updaterremoteUnlock();
                    break;
                case 113:
                    YLInfoSetFirstAct_BNR.this.updaterreversWipersStart();
                    break;
                case 114:
                    YLInfoSetFirstAct_BNR.this.uRemoteStartCar(DataCanbus.DATA[updateCode]);
                    break;
                case 131:
                    YLInfoSetFirstAct_BNR.this.uWarnVolume(DataCanbus.DATA[updateCode]);
                    break;
                case 184:
                    YLInfoSetFirstAct_BNR.this.uBackCar(DataCanbus.DATA[updateCode]);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_xp_yl_info_first_set_bnr);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.xp_yl_btn_Look_for_lightsParking_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.xp_yl_btn_Prevent_automatic_door_latch_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.xp_yl_btn_Automatic_latch_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.xp_yl_btn_Delay_latch_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.xp_yl_Remote_control_Unlock_light_Feedback_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.xp_yl_Remote_control_Unlock_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.xp_yl_comfort_rear_wiper_auto_start_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.xp_yl_radarswitch_check)).setOnClickListener(this);
        ((Button) findViewById(R.id.xp_yl_btn_Lasuo_headlight_delay_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.xp_yl_btn_Lasuo_headlight_delay_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.xp_yl_lock_automatic_transmission_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.xp_yl_lock_automatic_transmission_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.xp_yl_Remote_control_lock_door_Feedback_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.xp_yl_Remote_control_lock_door_Feedback_next)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_klc_Remote_start_car_check)).setOnClickListener(this);
        ((Button) findViewById(R.id.xp_yl_warn_volm_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.xp_yl_warn_volm_next)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.xp_yl_btn_Delay_latch_check /* 2131429070 */:
                int value3 = DataCanbus.DATA[109];
                YLFunc.CAR_COMM_CONTROL(5, value3 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_Remote_control_Unlock_light_Feedback_check /* 2131429072 */:
                int value4 = DataCanbus.DATA[110];
                YLFunc.CAR_COMM_CONTROL(6, value4 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_Remote_control_lock_door_Feedback_pre /* 2131429074 */:
                int value9 = DataCanbus.DATA[111];
                if (value9 == 0) {
                    YLFunc.CAR_COMM_CONTROL(7, 3);
                    break;
                } else if (value9 == 1) {
                    YLFunc.CAR_COMM_CONTROL(7, 0);
                    break;
                } else if (value9 == 2) {
                    YLFunc.CAR_COMM_CONTROL(7, 1);
                    break;
                } else if (value9 == 3) {
                    YLFunc.CAR_COMM_CONTROL(7, 2);
                    break;
                }
            case R.id.xp_yl_Remote_control_lock_door_Feedback_next /* 2131429076 */:
                int value10 = DataCanbus.DATA[111];
                if (value10 == 0) {
                    YLFunc.CAR_COMM_CONTROL(7, 1);
                    break;
                } else if (value10 == 1) {
                    YLFunc.CAR_COMM_CONTROL(7, 2);
                    break;
                } else if (value10 == 2) {
                    YLFunc.CAR_COMM_CONTROL(7, 3);
                    break;
                } else if (value10 == 3) {
                    YLFunc.CAR_COMM_CONTROL(7, 0);
                    break;
                }
            case R.id.xp_yl_Remote_control_Unlock_check /* 2131429078 */:
                int value5 = DataCanbus.DATA[112];
                YLFunc.CAR_COMM_CONTROL(8, value5 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_comfort_rear_wiper_auto_start_check /* 2131429081 */:
                int value6 = DataCanbus.DATA[113];
                YLFunc.CAR_COMM_CONTROL(9, value6 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_warn_volm_pre /* 2131429082 */:
                int value11 = DataCanbus.DATA[131];
                if (value11 == 0) {
                    YLFunc.CAR_WARNN_VOL(15);
                    break;
                } else {
                    YLFunc.CAR_WARNN_VOL(value11 - 1);
                    break;
                }
            case R.id.xp_yl_warn_volm_next /* 2131429084 */:
                int value12 = DataCanbus.DATA[131];
                if (value12 == 15) {
                    YLFunc.CAR_WARNN_VOL(0);
                    break;
                } else {
                    YLFunc.CAR_WARNN_VOL(value12 + 1);
                    break;
                }
            case R.id.xp_yl_btn_Look_for_lightsParking_check /* 2131433419 */:
                int valLightPark = DataCanbus.DATA[104];
                YLFunc.CAR_COMM_CONTROL(0, valLightPark == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_btn_Lasuo_headlight_delay_pre /* 2131433421 */:
                int valLasuoDelayPre = DataCanbus.DATA[105];
                if (valLasuoDelayPre == 0) {
                    YLFunc.CAR_COMM_CONTROL(1, 3);
                    break;
                } else if (valLasuoDelayPre == 1) {
                    YLFunc.CAR_COMM_CONTROL(1, 0);
                    break;
                } else if (valLasuoDelayPre == 2) {
                    YLFunc.CAR_COMM_CONTROL(1, 1);
                    break;
                } else if (valLasuoDelayPre == 3) {
                    YLFunc.CAR_COMM_CONTROL(1, 2);
                    break;
                }
            case R.id.xp_yl_btn_Lasuo_headlight_delay_next /* 2131433423 */:
                int valLasuoDelayNext = DataCanbus.DATA[105];
                if (valLasuoDelayNext == 0) {
                    YLFunc.CAR_COMM_CONTROL(1, 1);
                    break;
                } else if (valLasuoDelayNext == 1) {
                    YLFunc.CAR_COMM_CONTROL(1, 2);
                    break;
                } else if (valLasuoDelayNext == 2) {
                    YLFunc.CAR_COMM_CONTROL(1, 3);
                    break;
                } else if (valLasuoDelayNext == 3) {
                    YLFunc.CAR_COMM_CONTROL(1, 0);
                    break;
                }
            case R.id.xp_yl_btn_Prevent_automatic_door_latch_check /* 2131433424 */:
                int value1 = DataCanbus.DATA[107];
                YLFunc.CAR_COMM_CONTROL(3, value1 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_btn_Automatic_latch_check /* 2131433425 */:
                int value2 = DataCanbus.DATA[106];
                YLFunc.CAR_COMM_CONTROL(2, value2 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_lock_automatic_transmission_pre /* 2131433426 */:
                int value7 = DataCanbus.DATA[108];
                if (value7 == 0) {
                    YLFunc.CAR_COMM_CONTROL(4, 2);
                    break;
                } else if (value7 == 1) {
                    YLFunc.CAR_COMM_CONTROL(4, 0);
                    break;
                } else if (value7 == 2) {
                    YLFunc.CAR_COMM_CONTROL(4, 1);
                    break;
                }
            case R.id.xp_yl_lock_automatic_transmission_next /* 2131433428 */:
                int value8 = DataCanbus.DATA[108];
                if (value8 == 0) {
                    YLFunc.CAR_COMM_CONTROL(4, 1);
                    break;
                } else if (value8 == 1) {
                    YLFunc.CAR_COMM_CONTROL(4, 2);
                    break;
                } else if (value8 == 2) {
                    YLFunc.CAR_COMM_CONTROL(4, 0);
                    break;
                }
            case R.id.xp_yl_radarswitch_check /* 2131433437 */:
                int value62 = DataCanbus.DATA[184];
                YLFunc.CAR_ON_RADAR_CTL(value62 == 0 ? 1 : 0);
                break;
            case R.id.rzc_klc_Remote_start_car_check /* 2131433438 */:
                int value13 = DataCanbus.DATA[114];
                YLFunc.CAR_COMM_CONTROL(11, value13 == 0 ? 1 : 0);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        addUpdater();
        if (DataCanbus.DATA[1000] == 2294139) {
            findViewById(R.id.xp_yl_lock_Delay_latch_view).setVisibility(8);
            findViewById(R.id.xp_yl_Remote_control_Unlock_light_Feedback).setVisibility(8);
            findViewById(R.id.xp_yl_Remote_control_Unlock).setVisibility(8);
            findViewById(R.id.xp_yl_comfort_rear_wiper_auto_start).setVisibility(8);
            findViewById(R.id.xp_yl_radarswitch_view).setVisibility(8);
            findViewById(R.id.xp_yl_warn_vol_view).setVisibility(8);
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
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
    }

    
    public void updaterlightsParking() {
        int switchOn = DataCanbus.DATA[104];
        ((CheckedTextView) findViewById(R.id.xp_yl_btn_Look_for_lightsParking_check)).setChecked(switchOn != 0);
    }

    protected void uWarnVolume(int i) {
        TextView v = (TextView) findViewById(R.id.xp_yl_warn_volm_tv);
        if (v != null) {
            v.setText(new StringBuilder(String.valueOf(i)).toString());
        }
    }

    protected void uBackCar(int i) {
        if (((CheckedTextView) findViewById(R.id.xp_yl_radarswitch_check)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_yl_radarswitch_check)).setChecked(i != 0);
        }
    }

    protected void uRemoteStartCar(int i) {
        if (((CheckedTextView) findViewById(R.id.rzc_klc_Remote_start_car_check)) != null) {
            ((CheckedTextView) findViewById(R.id.rzc_klc_Remote_start_car_check)).setChecked(i != 0);
        }
    }

    
    public void updaterLasuoHeadlightDelay() {
        int switchOn = DataCanbus.DATA[105];
        if (switchOn == 0) {
            ((TextView) findViewById(R.id.xp_yl_light_Lasuo_headlight_delay_tv)).setText(R.string.klc_Parking_with_trailer_Off);
            return;
        }
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.xp_yl_light_Lasuo_headlight_delay_tv)).setText(R.string.klc_light_Lasuo_headlight_delay_1);
        } else if (switchOn == 2) {
            ((TextView) findViewById(R.id.xp_yl_light_Lasuo_headlight_delay_tv)).setText(R.string.klc_light_Lasuo_headlight_delay_2);
        } else if (switchOn == 3) {
            ((TextView) findViewById(R.id.xp_yl_light_Lasuo_headlight_delay_tv)).setText(R.string.klc_light_Lasuo_headlight_delay_3);
        }
    }

    
    public void updaterdefeatDoorAutoLock() {
        int switchOn = DataCanbus.DATA[106];
        ((CheckedTextView) findViewById(R.id.xp_yl_btn_Automatic_latch_check)).setChecked(switchOn != 0);
        if (switchOn == 0) {
            findViewById(R.id.xp_yl_lock_Delay_latch_view).setVisibility(0);
        } else if (switchOn == 1) {
            findViewById(R.id.xp_yl_lock_Delay_latch_view).setVisibility(8);
        }
    }

    
    public void updaterdoorAutoLock() {
        int switchOn = DataCanbus.DATA[107];
        ((CheckedTextView) findViewById(R.id.xp_yl_btn_Prevent_automatic_door_latch_check)).setChecked(switchOn != 0);
    }

    
    public void updaterparkCarAutoUnlock() {
        int switchOn = DataCanbus.DATA[108];
        if (switchOn == 0) {
            ((TextView) findViewById(R.id.xp_yl_lock_automatic_transmission_Tv)).setText(R.string.klc_Parking_with_trailer_Off);
        } else if (switchOn == 1) {
            ((TextView) findViewById(R.id.xp_yl_lock_automatic_transmission_Tv)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
        } else if (switchOn == 2) {
            ((TextView) findViewById(R.id.xp_yl_lock_automatic_transmission_Tv)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
        }
    }

    
    public void updaterlaterLock() {
        int switchOn = DataCanbus.DATA[109];
        ((CheckedTextView) findViewById(R.id.xp_yl_btn_Delay_latch_check)).setChecked(switchOn != 0);
    }

    
    public void updaterremoteUnlockLight() {
        int switchOn = DataCanbus.DATA[110];
        ((CheckedTextView) findViewById(R.id.xp_yl_Remote_control_Unlock_light_Feedback_check)).setChecked(switchOn != 0);
    }

    
    public void updaterremoteLockDoor() {
        int switchOn = DataCanbus.DATA[111];
        if (switchOn == 0) {
            ((TextView) findViewById(R.id.xp_yl_Remote_control_lock_door_Feedback_Tv)).setText(R.string.klc_remote_Remote_control_latch_only_light);
            return;
        }
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.xp_yl_Remote_control_lock_door_Feedback_Tv)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
        } else if (switchOn == 2) {
            ((TextView) findViewById(R.id.xp_yl_Remote_control_lock_door_Feedback_Tv)).setText(R.string.klc_remote_Remote_control_latch_speaker);
        } else if (switchOn == 3) {
            ((TextView) findViewById(R.id.xp_yl_Remote_control_lock_door_Feedback_Tv)).setText(R.string.klc_Parking_with_trailer_Off);
        }
    }

    
    public void updaterremoteUnlock() {
        int switchOn = DataCanbus.DATA[112];
        if (switchOn == 0) {
            ((CheckedTextView) findViewById(R.id.xp_yl_Remote_control_Unlock_check)).setChecked(false);
            ((TextView) findViewById(R.id.xp_yl_Remote_control_Unlock_tv)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
        } else if (switchOn == 1) {
            ((CheckedTextView) findViewById(R.id.xp_yl_Remote_control_Unlock_check)).setChecked(true);
            ((TextView) findViewById(R.id.xp_yl_Remote_control_Unlock_tv)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
        }
    }

    
    public void updaterreversWipersStart() {
        int switchOn = DataCanbus.DATA[113];
        ((CheckedTextView) findViewById(R.id.xp_yl_comfort_rear_wiper_auto_start_check)).setChecked(switchOn != 0);
    }
}
