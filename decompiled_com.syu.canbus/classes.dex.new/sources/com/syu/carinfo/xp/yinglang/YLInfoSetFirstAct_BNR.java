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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class YLInfoSetFirstAct_BNR extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.yinglang.YLInfoSetFirstAct_BNR.1
        @Override // com.syu.module.IUiNotify
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

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xp_yl_info_first_set_bnr);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427456 */:
                int valLasuoDelayPre = DataCanbus.DATA[105];
                if (valLasuoDelayPre == 0) {
                    YLFunc.CAR_COMM_CONTROL(1, 3);
                } else if (valLasuoDelayPre == 1) {
                    YLFunc.CAR_COMM_CONTROL(1, 0);
                } else if (valLasuoDelayPre == 2) {
                    YLFunc.CAR_COMM_CONTROL(1, 1);
                } else if (valLasuoDelayPre == 3) {
                    YLFunc.CAR_COMM_CONTROL(1, 2);
                }
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int valLasuoDelayNext = DataCanbus.DATA[105];
                if (valLasuoDelayNext == 0) {
                    YLFunc.CAR_COMM_CONTROL(1, 1);
                } else if (valLasuoDelayNext == 1) {
                    YLFunc.CAR_COMM_CONTROL(1, 2);
                } else if (valLasuoDelayNext == 2) {
                    YLFunc.CAR_COMM_CONTROL(1, 3);
                } else if (valLasuoDelayNext == 3) {
                    YLFunc.CAR_COMM_CONTROL(1, 0);
                }
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value7 = DataCanbus.DATA[108];
                if (value7 == 0) {
                    YLFunc.CAR_COMM_CONTROL(4, 2);
                } else if (value7 == 1) {
                    YLFunc.CAR_COMM_CONTROL(4, 0);
                } else if (value7 == 2) {
                    YLFunc.CAR_COMM_CONTROL(4, 1);
                }
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value8 = DataCanbus.DATA[108];
                if (value8 == 0) {
                    YLFunc.CAR_COMM_CONTROL(4, 1);
                } else if (value8 == 1) {
                    YLFunc.CAR_COMM_CONTROL(4, 2);
                } else if (value8 == 2) {
                    YLFunc.CAR_COMM_CONTROL(4, 0);
                }
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value9 = DataCanbus.DATA[111];
                if (value9 == 0) {
                    YLFunc.CAR_COMM_CONTROL(7, 3);
                } else if (value9 == 1) {
                    YLFunc.CAR_COMM_CONTROL(7, 0);
                } else if (value9 == 2) {
                    YLFunc.CAR_COMM_CONTROL(7, 1);
                } else if (value9 == 3) {
                    YLFunc.CAR_COMM_CONTROL(7, 2);
                }
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value10 = DataCanbus.DATA[111];
                if (value10 == 0) {
                    YLFunc.CAR_COMM_CONTROL(7, 1);
                } else if (value10 == 1) {
                    YLFunc.CAR_COMM_CONTROL(7, 2);
                } else if (value10 == 2) {
                    YLFunc.CAR_COMM_CONTROL(7, 3);
                } else if (value10 == 3) {
                    YLFunc.CAR_COMM_CONTROL(7, 0);
                }
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value11 = DataCanbus.DATA[131];
                if (value11 == 0) {
                    YLFunc.CAR_WARNN_VOL(15);
                } else {
                    YLFunc.CAR_WARNN_VOL(value11 - 1);
                }
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value12 = DataCanbus.DATA[131];
                if (value12 == 15) {
                    YLFunc.CAR_WARNN_VOL(0);
                } else {
                    YLFunc.CAR_WARNN_VOL(value12 + 1);
                }
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int valLightPark = DataCanbus.DATA[104];
                YLFunc.CAR_COMM_CONTROL(0, valLightPark == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int value3 = DataCanbus.DATA[109];
                YLFunc.CAR_COMM_CONTROL(5, value3 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int value4 = DataCanbus.DATA[110];
                YLFunc.CAR_COMM_CONTROL(6, value4 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value1 = DataCanbus.DATA[107];
                YLFunc.CAR_COMM_CONTROL(3, value1 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int value2 = DataCanbus.DATA[106];
                YLFunc.CAR_COMM_CONTROL(2, value2 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int value5 = DataCanbus.DATA[112];
                YLFunc.CAR_COMM_CONTROL(8, value5 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                int value6 = DataCanbus.DATA[113];
                YLFunc.CAR_COMM_CONTROL(9, value6 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                int value13 = DataCanbus.DATA[114];
                YLFunc.CAR_COMM_CONTROL(11, value13 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                int value14 = DataCanbus.DATA[184];
                YLFunc.CAR_ON_RADAR_CTL(value14 == 0 ? 1 : 0);
                break;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addUpdater();
        if (DataCanbus.DATA[1000] == 2294139) {
            findViewById(R.id.layout_view5).setVisibility(8);
            findViewById(R.id.layout_view7).setVisibility(8);
            findViewById(R.id.layout_view9).setVisibility(8);
            findViewById(R.id.layout_view10).setVisibility(8);
            findViewById(R.id.layout_view12).setVisibility(8);
            findViewById(R.id.layout_view11).setVisibility(8);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterlightsParking() {
        int switchOn = DataCanbus.DATA[104];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(switchOn != 0);
    }

    protected void uWarnVolume(int i) {
        TextView v = (TextView) findViewById(R.id.tv_text5);
        if (v != null) {
            v.setText(new StringBuilder(String.valueOf(i)).toString());
        }
    }

    protected void uBackCar(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext9)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(i != 0);
        }
    }

    protected void uRemoteStartCar(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext8)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(i != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterLasuoHeadlightDelay() {
        int switchOn = DataCanbus.DATA[105];
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
        int switchOn = DataCanbus.DATA[106];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(switchOn != 0);
        if (switchOn == 0) {
            findViewById(R.id.layout_view5).setVisibility(0);
        } else if (switchOn == 1) {
            findViewById(R.id.layout_view5).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterdoorAutoLock() {
        int switchOn = DataCanbus.DATA[107];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterparkCarAutoUnlock() {
        int switchOn = DataCanbus.DATA[108];
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
        int switchOn = DataCanbus.DATA[109];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterremoteUnlockLight() {
        int switchOn = DataCanbus.DATA[110];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterremoteLockDoor() {
        int switchOn = DataCanbus.DATA[111];
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
        int switchOn = DataCanbus.DATA[112];
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
        int switchOn = DataCanbus.DATA[113];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(switchOn != 0);
    }
}
