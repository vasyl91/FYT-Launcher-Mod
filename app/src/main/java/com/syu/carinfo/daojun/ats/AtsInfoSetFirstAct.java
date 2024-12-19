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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class AtsInfoSetFirstAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.daojun.ats.AtsInfoSetFirstAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 9:
                    AtsInfoSetFirstAct.this.updaterlightsParking();
                    break;
                case 10:
                    AtsInfoSetFirstAct.this.updaterLasuoHeadlightDelay();
                    break;
                case 11:
                    AtsInfoSetFirstAct.this.updaterdefeatDoorAutoLock();
                    break;
                case 12:
                    AtsInfoSetFirstAct.this.updaterdoorAutoLock();
                    break;
                case 13:
                    AtsInfoSetFirstAct.this.updaterparkCarAutoUnlock();
                    break;
                case 14:
                    AtsInfoSetFirstAct.this.updaterlaterLock();
                    break;
                case 15:
                    AtsInfoSetFirstAct.this.updaterremoteUnlockLight();
                    break;
                case 16:
                    AtsInfoSetFirstAct.this.updaterremoteLockDoor();
                    break;
                case 17:
                    AtsInfoSetFirstAct.this.updaterremoteUnlock();
                    break;
                case 20:
                    AtsInfoSetFirstAct.this.updaterreversWipersStart();
                    break;
                case 21:
                    AtsInfoSetFirstAct.this.updaterRemoteStartCar();
                    break;
                case 37:
                    AtsInfoSetFirstAct.this.updaterWarnVolumSet();
                    break;
                case 38:
                    AtsInfoSetFirstAct.this.updaterRemoteCarWindow();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_daojun_ats_info_first_set);
        init();
        setUI();
    }

    @Override // com.syu.canbus.BaseActivity
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int valLightPark = DataCanbus.DATA[9];
                AtsFunc.CAR_COMM_CONTROL(0, valLightPark == 0 ? 1 : 0);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int valLasuoDelayPre = DataCanbus.DATA[10] & 255;
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
            case R.id.btn_plus1 /* 2131427482 */:
                int valLasuoDelayNext = DataCanbus.DATA[10] & 255;
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
            case R.id.btn_minus2 /* 2131427484 */:
                int value7 = DataCanbus.DATA[13];
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
            case R.id.btn_plus2 /* 2131427486 */:
                int value8 = DataCanbus.DATA[13];
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
            case R.id.btn_minus3 /* 2131427488 */:
                int value9 = DataCanbus.DATA[16];
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
            case R.id.btn_plus3 /* 2131427490 */:
                int value10 = DataCanbus.DATA[16];
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
            case R.id.btn_minus4 /* 2131427492 */:
                int value11 = DataCanbus.DATA[37];
                if (value11 == 0) {
                    AtsFunc.CAR_WARNN_VOL(15);
                    break;
                } else {
                    AtsFunc.CAR_WARNN_VOL(value11 - 1);
                    break;
                }
            case R.id.btn_plus4 /* 2131427494 */:
                int value12 = DataCanbus.DATA[37];
                if (value12 == 15) {
                    AtsFunc.CAR_WARNN_VOL(0);
                    break;
                } else {
                    AtsFunc.CAR_WARNN_VOL(value12 + 1);
                    break;
                }
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value1 = DataCanbus.DATA[12];
                AtsFunc.CAR_COMM_CONTROL(3, value1 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value2 = DataCanbus.DATA[11];
                AtsFunc.CAR_COMM_CONTROL(2, value2 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value3 = DataCanbus.DATA[14];
                AtsFunc.CAR_COMM_CONTROL(5, value3 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value4 = DataCanbus.DATA[15];
                AtsFunc.CAR_COMM_CONTROL(6, value4 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value5 = DataCanbus.DATA[17];
                AtsFunc.CAR_COMM_CONTROL(8, value5 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value6 = DataCanbus.DATA[20];
                AtsFunc.CAR_COMM_CONTROL(9, value6 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                AtsFunc.CAR_COMM_CONTROL(11, DataCanbus.DATA[21] == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                AtsFunc.CAR_COMM_CONTROL(119, DataCanbus.DATA[38] == 0 ? 1 : 0);
                break;
        }
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
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterlightsParking() {
        int switchOn = DataCanbus.DATA[9];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterLasuoHeadlightDelay() {
        int switchOn = DataCanbus.DATA[10];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterdefeatDoorAutoLock() {
        int switchOn = DataCanbus.DATA[11];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterdoorAutoLock() {
        int switchOn = DataCanbus.DATA[12];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterparkCarAutoUnlock() {
        int switchOn = DataCanbus.DATA[13];
        if (switchOn == 0) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_Parking_with_trailer_Off);
        } else if (switchOn == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
        } else if (switchOn == 2) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterlaterLock() {
        int switchOn = DataCanbus.DATA[14];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterremoteUnlockLight() {
        int switchOn = DataCanbus.DATA[15];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterremoteLockDoor() {
        int switchOn = DataCanbus.DATA[16];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterremoteUnlock() {
        int switchOn = DataCanbus.DATA[17];
        if (switchOn == 0) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(false);
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
        } else if (switchOn == 1) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(true);
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterreversWipersStart() {
        int switchOn = DataCanbus.DATA[20];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterWarnVolumSet() {
        int switchOn = DataCanbus.DATA[37];
        ((TextView) findViewById(R.id.tv_text5)).setText(new StringBuilder().append(switchOn).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRemoteStartCar() {
        int RemotecarStartValue = DataCanbus.DATA[21];
        if (RemotecarStartValue == 0) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(false);
        } else if (RemotecarStartValue == 1) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRemoteCarWindow() {
        int remounteCarWindowValue = DataCanbus.DATA[38];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(remounteCarWindowValue != 0);
    }
}
