package com.syu.carinfo.daojun.ats;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class AtsInfoSetFirstAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 107:
                    AtsInfoSetFirstAct.this.updaterlightsParking();
                    break;
                case 108:
                    AtsInfoSetFirstAct.this.updaterLasuoHeadlightDelay();
                    break;
                case 109:
                    AtsInfoSetFirstAct.this.updaterdefeatDoorAutoLock();
                    break;
                case 110:
                    AtsInfoSetFirstAct.this.updaterdoorAutoLock();
                    break;
                case 111:
                    AtsInfoSetFirstAct.this.updaterparkCarAutoUnlock();
                    break;
                case 112:
                    AtsInfoSetFirstAct.this.updaterlaterLock();
                    break;
                case 113:
                    AtsInfoSetFirstAct.this.updaterremoteUnlockLight();
                    break;
                case 114:
                    AtsInfoSetFirstAct.this.updaterremoteLockDoor();
                    break;
                case 115:
                    AtsInfoSetFirstAct.this.updaterremoteUnlock();
                    break;
                case 118:
                    AtsInfoSetFirstAct.this.updaterreversWipersStart();
                    break;
                case 119:
                    AtsInfoSetFirstAct.this.updaterRemoteStartCar();
                    break;
                case 135:
                    AtsInfoSetFirstAct.this.updaterWarnVolumSet();
                    break;
                case 136:
                    AtsInfoSetFirstAct.this.updaterRemoteCarWindow();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_daojun_ats_info_first_set);
        init();
        setUI();
    }

    @Override
    public void init() {
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427455 */:
                int valLasuoDelayPre = DataCanbus.DATA[108] & 255;
                if (valLasuoDelayPre == 0) {
                    AtsFunc.CAR_COMM_CONTROL(1, 3);
                    break;
                } else if (valLasuoDelayPre == 1) {
                    AtsFunc.CAR_COMM_CONTROL(1, 0);
                    break;
                } else if (valLasuoDelayPre == 2) {
                    AtsFunc.CAR_COMM_CONTROL(1, 1);
                    break;
                } else if (valLasuoDelayPre == 3) {
                    AtsFunc.CAR_COMM_CONTROL(1, 2);
                    break;
                }
            case R.id.btn_plus1 /* 2131427457 */:
                int valLasuoDelayNext = DataCanbus.DATA[108] & 255;
                if (valLasuoDelayNext == 0) {
                    AtsFunc.CAR_COMM_CONTROL(1, 1);
                    break;
                } else if (valLasuoDelayNext == 1) {
                    AtsFunc.CAR_COMM_CONTROL(1, 2);
                    break;
                } else if (valLasuoDelayNext == 2) {
                    AtsFunc.CAR_COMM_CONTROL(1, 3);
                    break;
                } else if (valLasuoDelayNext == 3) {
                    AtsFunc.CAR_COMM_CONTROL(1, 0);
                    break;
                }
            case R.id.btn_minus2 /* 2131427458 */:
                int value7 = DataCanbus.DATA[111];
                if (value7 == 0) {
                    AtsFunc.CAR_COMM_CONTROL(4, 2);
                    break;
                } else if (value7 == 1) {
                    AtsFunc.CAR_COMM_CONTROL(4, 0);
                    break;
                } else if (value7 == 2) {
                    AtsFunc.CAR_COMM_CONTROL(4, 1);
                    break;
                }
            case R.id.btn_plus2 /* 2131427460 */:
                int value8 = DataCanbus.DATA[111];
                if (value8 == 0) {
                    AtsFunc.CAR_COMM_CONTROL(4, 1);
                    break;
                } else if (value8 == 1) {
                    AtsFunc.CAR_COMM_CONTROL(4, 2);
                    break;
                } else if (value8 == 2) {
                    AtsFunc.CAR_COMM_CONTROL(4, 0);
                    break;
                }
            case R.id.btn_minus3 /* 2131427461 */:
                int value9 = DataCanbus.DATA[114];
                if (value9 == 0) {
                    AtsFunc.CAR_COMM_CONTROL(7, 3);
                    break;
                } else if (value9 == 1) {
                    AtsFunc.CAR_COMM_CONTROL(7, 0);
                    break;
                } else if (value9 == 2) {
                    AtsFunc.CAR_COMM_CONTROL(7, 1);
                    break;
                } else if (value9 == 3) {
                    AtsFunc.CAR_COMM_CONTROL(7, 2);
                    break;
                }
            case R.id.btn_plus3 /* 2131427463 */:
                int value10 = DataCanbus.DATA[114];
                if (value10 == 0) {
                    AtsFunc.CAR_COMM_CONTROL(7, 1);
                    break;
                } else if (value10 == 1) {
                    AtsFunc.CAR_COMM_CONTROL(7, 2);
                    break;
                } else if (value10 == 2) {
                    AtsFunc.CAR_COMM_CONTROL(7, 3);
                    break;
                } else if (value10 == 3) {
                    AtsFunc.CAR_COMM_CONTROL(7, 0);
                    break;
                }
            case R.id.btn_minus4 /* 2131427464 */:
                int value11 = DataCanbus.DATA[135];
                if (value11 == 0) {
                    AtsFunc.CAR_WARNN_VOL(15);
                    break;
                } else {
                    AtsFunc.CAR_WARNN_VOL(value11 - 1);
                    break;
                }
            case R.id.btn_plus4 /* 2131427466 */:
                int value12 = DataCanbus.DATA[135];
                if (value12 == 15) {
                    AtsFunc.CAR_WARNN_VOL(0);
                    break;
                } else {
                    AtsFunc.CAR_WARNN_VOL(value12 + 1);
                    break;
                }
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int valLightPark = DataCanbus.DATA[107];
                AtsFunc.CAR_COMM_CONTROL(0, valLightPark == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value1 = DataCanbus.DATA[110];
                AtsFunc.CAR_COMM_CONTROL(3, value1 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value2 = DataCanbus.DATA[109];
                AtsFunc.CAR_COMM_CONTROL(2, value2 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value3 = DataCanbus.DATA[112];
                AtsFunc.CAR_COMM_CONTROL(5, value3 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value4 = DataCanbus.DATA[113];
                AtsFunc.CAR_COMM_CONTROL(6, value4 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value5 = DataCanbus.DATA[115];
                AtsFunc.CAR_COMM_CONTROL(8, value5 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value6 = DataCanbus.DATA[118];
                AtsFunc.CAR_COMM_CONTROL(9, value6 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                AtsFunc.CAR_COMM_CONTROL(11, DataCanbus.DATA[119] == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                AtsFunc.CAR_COMM_CONTROL(119, DataCanbus.DATA[136] == 0 ? 1 : 0);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.notifyCanbus);
    }

    
    public void updaterlightsParking() {
        int switchOn = DataCanbus.DATA[107];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(switchOn != 0);
    }

    
    public void updaterLasuoHeadlightDelay() {
        int switchOn = DataCanbus.DATA[108];
        if (switchOn == 0) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_Parking_with_trailer_Off);
            return;
        }
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_light_Lasuo_headlight_delay_1);
        } else if (switchOn == 2) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_light_Lasuo_headlight_delay_2);
        } else if (switchOn == 3) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_light_Lasuo_headlight_delay_3);
        }
    }

    
    public void updaterdefeatDoorAutoLock() {
        int switchOn = DataCanbus.DATA[109];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(switchOn != 0);
    }

    
    public void updaterdoorAutoLock() {
        int switchOn = DataCanbus.DATA[110];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(switchOn != 0);
    }

    
    public void updaterparkCarAutoUnlock() {
        int switchOn = DataCanbus.DATA[111];
        if (switchOn == 0) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_Parking_with_trailer_Off);
        } else if (switchOn == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
        } else if (switchOn == 2) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
        }
    }

    
    public void updaterlaterLock() {
        int switchOn = DataCanbus.DATA[112];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(switchOn != 0);
    }

    
    public void updaterremoteUnlockLight() {
        int switchOn = DataCanbus.DATA[113];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(switchOn != 0);
    }

    
    public void updaterremoteLockDoor() {
        int switchOn = DataCanbus.DATA[114];
        if (switchOn == 0) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Remote_control_latch_only_light);
            return;
        }
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
        } else if (switchOn == 2) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Remote_control_latch_speaker);
        } else if (switchOn == 3) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_Parking_with_trailer_Off);
        }
    }

    
    public void updaterremoteUnlock() {
        int switchOn = DataCanbus.DATA[115];
        if (switchOn == 0) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(false);
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
        } else if (switchOn == 1) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(true);
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
        }
    }

    
    public void updaterreversWipersStart() {
        int switchOn = DataCanbus.DATA[118];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(switchOn != 0);
    }

    
    public void updaterWarnVolumSet() {
        int switchOn = DataCanbus.DATA[135];
        ((TextView) findViewById(R.id.tv_text5)).setText(new StringBuilder().append(switchOn).toString());
    }

    
    public void updaterRemoteStartCar() {
        int RemotecarStartValue = DataCanbus.DATA[119];
        if (RemotecarStartValue == 0) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(false);
        } else if (RemotecarStartValue == 1) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(true);
        }
    }

    
    public void updaterRemoteCarWindow() {
        int remounteCarWindowValue = DataCanbus.DATA[136];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(remounteCarWindowValue != 0);
    }
}
