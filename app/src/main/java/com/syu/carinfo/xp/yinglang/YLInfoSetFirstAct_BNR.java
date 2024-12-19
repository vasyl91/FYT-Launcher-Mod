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
public class YLInfoSetFirstAct_BNR extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.yinglang.YLInfoSetFirstAct_BNR.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 7:
                    YLInfoSetFirstAct_BNR.this.updaterlightsParking();
                    break;
                case 8:
                    YLInfoSetFirstAct_BNR.this.updaterLasuoHeadlightDelay();
                    break;
                case 9:
                    YLInfoSetFirstAct_BNR.this.updaterdefeatDoorAutoLock();
                    break;
                case 10:
                    YLInfoSetFirstAct_BNR.this.updaterdoorAutoLock();
                    break;
                case 11:
                    YLInfoSetFirstAct_BNR.this.updaterparkCarAutoUnlock();
                    break;
                case 12:
                    YLInfoSetFirstAct_BNR.this.updaterlaterLock();
                    break;
                case 13:
                    YLInfoSetFirstAct_BNR.this.updaterremoteUnlockLight();
                    break;
                case 14:
                    YLInfoSetFirstAct_BNR.this.updaterremoteLockDoor();
                    break;
                case 15:
                    YLInfoSetFirstAct_BNR.this.updaterremoteUnlock();
                    break;
                case 16:
                    YLInfoSetFirstAct_BNR.this.updaterreversWipersStart();
                    break;
                case 17:
                    YLInfoSetFirstAct_BNR.this.uRemoteStartCar(DataCanbus.DATA[updateCode]);
                    break;
                case 34:
                    YLInfoSetFirstAct_BNR.this.uWarnVolume(DataCanbus.DATA[updateCode]);
                    break;
                case 150:
                    YLInfoSetFirstAct_BNR.this.uBackCar(DataCanbus.DATA[updateCode]);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xp_yl_info_first_set_bnr);
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.xp_yl_btn_Delay_latch_check /* 2131429110 */:
                int value3 = DataCanbus.DATA[12];
                YLFunc.CAR_COMM_CONTROL(5, value3 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_Remote_control_Unlock_light_Feedback_check /* 2131429112 */:
                int value4 = DataCanbus.DATA[13];
                YLFunc.CAR_COMM_CONTROL(6, value4 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_Remote_control_lock_door_Feedback_pre /* 2131429114 */:
                int value9 = DataCanbus.DATA[14];
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
            case R.id.xp_yl_Remote_control_lock_door_Feedback_next /* 2131429116 */:
                int value10 = DataCanbus.DATA[14];
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
            case R.id.xp_yl_Remote_control_Unlock_check /* 2131429118 */:
                int value5 = DataCanbus.DATA[15];
                YLFunc.CAR_COMM_CONTROL(8, value5 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_comfort_rear_wiper_auto_start_check /* 2131429121 */:
                int value6 = DataCanbus.DATA[16];
                YLFunc.CAR_COMM_CONTROL(9, value6 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_warn_volm_pre /* 2131429122 */:
                int value11 = DataCanbus.DATA[34];
                if (value11 == 0) {
                    YLFunc.CAR_WARNN_VOL(15);
                    break;
                } else {
                    YLFunc.CAR_WARNN_VOL(value11 - 1);
                    break;
                }
            case R.id.xp_yl_warn_volm_next /* 2131429124 */:
                int value12 = DataCanbus.DATA[34];
                if (value12 == 15) {
                    YLFunc.CAR_WARNN_VOL(0);
                    break;
                } else {
                    YLFunc.CAR_WARNN_VOL(value12 + 1);
                    break;
                }
            case R.id.xp_yl_btn_Look_for_lightsParking_check /* 2131433505 */:
                int valLightPark = DataCanbus.DATA[7];
                YLFunc.CAR_COMM_CONTROL(0, valLightPark == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_btn_Lasuo_headlight_delay_pre /* 2131433507 */:
                int valLasuoDelayPre = DataCanbus.DATA[8];
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
            case R.id.xp_yl_btn_Lasuo_headlight_delay_next /* 2131433509 */:
                int valLasuoDelayNext = DataCanbus.DATA[8];
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
            case R.id.xp_yl_btn_Prevent_automatic_door_latch_check /* 2131433510 */:
                int value1 = DataCanbus.DATA[10];
                YLFunc.CAR_COMM_CONTROL(3, value1 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_btn_Automatic_latch_check /* 2131433511 */:
                int value2 = DataCanbus.DATA[9];
                YLFunc.CAR_COMM_CONTROL(2, value2 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_lock_automatic_transmission_pre /* 2131433512 */:
                int value7 = DataCanbus.DATA[11];
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
            case R.id.xp_yl_lock_automatic_transmission_next /* 2131433514 */:
                int value8 = DataCanbus.DATA[11];
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
            case R.id.xp_yl_radarswitch_check /* 2131433523 */:
                int value62 = DataCanbus.DATA[150];
                YLFunc.CAR_ON_RADAR_CTL(value62 == 0 ? 1 : 0);
                break;
            case R.id.rzc_klc_Remote_start_car_check /* 2131433524 */:
                int value13 = DataCanbus.DATA[17];
                YLFunc.CAR_COMM_CONTROL(11, value13 == 0 ? 1 : 0);
                break;
        }
    }

    @Override // android.app.Activity
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

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterlightsParking() {
        int switchOn = DataCanbus.DATA[7];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterLasuoHeadlightDelay() {
        int switchOn = DataCanbus.DATA[8];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterdefeatDoorAutoLock() {
        int switchOn = DataCanbus.DATA[9];
        ((CheckedTextView) findViewById(R.id.xp_yl_btn_Automatic_latch_check)).setChecked(switchOn != 0);
        if (switchOn == 0) {
            findViewById(R.id.xp_yl_lock_Delay_latch_view).setVisibility(0);
        } else if (switchOn == 1) {
            findViewById(R.id.xp_yl_lock_Delay_latch_view).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterdoorAutoLock() {
        int switchOn = DataCanbus.DATA[10];
        ((CheckedTextView) findViewById(R.id.xp_yl_btn_Prevent_automatic_door_latch_check)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterparkCarAutoUnlock() {
        int switchOn = DataCanbus.DATA[11];
        if (switchOn == 0) {
            ((TextView) findViewById(R.id.xp_yl_lock_automatic_transmission_Tv)).setText(R.string.klc_Parking_with_trailer_Off);
        } else if (switchOn == 1) {
            ((TextView) findViewById(R.id.xp_yl_lock_automatic_transmission_Tv)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
        } else if (switchOn == 2) {
            ((TextView) findViewById(R.id.xp_yl_lock_automatic_transmission_Tv)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterlaterLock() {
        int switchOn = DataCanbus.DATA[12];
        ((CheckedTextView) findViewById(R.id.xp_yl_btn_Delay_latch_check)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterremoteUnlockLight() {
        int switchOn = DataCanbus.DATA[13];
        ((CheckedTextView) findViewById(R.id.xp_yl_Remote_control_Unlock_light_Feedback_check)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterremoteLockDoor() {
        int switchOn = DataCanbus.DATA[14];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterremoteUnlock() {
        int switchOn = DataCanbus.DATA[15];
        if (switchOn == 0) {
            ((CheckedTextView) findViewById(R.id.xp_yl_Remote_control_Unlock_check)).setChecked(false);
            ((TextView) findViewById(R.id.xp_yl_Remote_control_Unlock_tv)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
        } else if (switchOn == 1) {
            ((CheckedTextView) findViewById(R.id.xp_yl_Remote_control_Unlock_check)).setChecked(true);
            ((TextView) findViewById(R.id.xp_yl_Remote_control_Unlock_tv)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterreversWipersStart() {
        int switchOn = DataCanbus.DATA[16];
        ((CheckedTextView) findViewById(R.id.xp_yl_comfort_rear_wiper_auto_start_check)).setChecked(switchOn != 0);
    }
}
