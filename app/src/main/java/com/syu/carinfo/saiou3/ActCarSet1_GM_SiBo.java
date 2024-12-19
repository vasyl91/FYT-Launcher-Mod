package com.syu.carinfo.saiou3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.xfl.chuangku.XflCkFunc;
import com.syu.carinfo.xp.yinglang.YLFunc;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActCarSet1_GM_SiBo extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.saiou3.ActCarSet1_GM_SiBo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 7:
                    ActCarSet1_GM_SiBo.this.updaterLookLight();
                    break;
                case 8:
                    ActCarSet1_GM_SiBo.this.updaterDelaySet();
                    break;
                case 9:
                    ActCarSet1_GM_SiBo.this.updatePreventAutoLatch();
                    break;
                case 10:
                    ActCarSet1_GM_SiBo.this.updateAutoLatch();
                    break;
                case 11:
                    ActCarSet1_GM_SiBo.this.updateParkingAutoUnLock();
                    break;
                case 12:
                    ActCarSet1_GM_SiBo.this.updateDelayLatch();
                    break;
                case 13:
                    ActCarSet1_GM_SiBo.this.updateUnlockLight();
                    break;
                case 14:
                    ActCarSet1_GM_SiBo.this.updateLockDoorFeed();
                    break;
                case 15:
                    ActCarSet1_GM_SiBo.this.updateRemoteOpen();
                    break;
                case 16:
                    ActCarSet1_GM_SiBo.this.updaterreversWipersStart();
                    break;
                case 17:
                    ActCarSet1_GM_SiBo.this.updateRemoteReLock();
                    break;
                case 18:
                    ActCarSet1_GM_SiBo.this.updateRemoteSatrtCar();
                    break;
                case 19:
                    ActCarSet1_GM_SiBo.this.mUpdaterSaturation();
                    break;
                case 20:
                    ActCarSet1_GM_SiBo.this.mUpdaterContrast();
                    break;
                case 35:
                    ActCarSet1_GM_SiBo.this.mUpdaterBrightness();
                    break;
                case 36:
                    ActCarSet1_GM_SiBo.this.updateKeyFogget();
                    break;
                case 37:
                    ActCarSet1_GM_SiBo.this.mUpdaterValue6();
                    break;
                case 38:
                    ActCarSet1_GM_SiBo.this.updaterCheckEnable();
                    break;
                case 78:
                    ActCarSet1_GM_SiBo.this.uAutoLock();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sb_gm_car_set1);
        init();
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setOnClickListener(this);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                XflCkFunc.CAR_COMM_CONTROL(0, DataCanbus.DATA[7] != 0 ? 0 : 1);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int lasuoState = DataCanbus.DATA[8];
                if (lasuoState == 0) {
                    XflCkFunc.CAR_COMM_CONTROL(1, 3);
                    break;
                } else if (lasuoState == 1) {
                    XflCkFunc.CAR_COMM_CONTROL(1, 0);
                    break;
                } else if (lasuoState == 2) {
                    XflCkFunc.CAR_COMM_CONTROL(1, 1);
                    break;
                } else if (lasuoState == 3) {
                    XflCkFunc.CAR_COMM_CONTROL(1, 2);
                    break;
                }
            case R.id.btn_plus1 /* 2131427482 */:
                int lasuoState2 = DataCanbus.DATA[8];
                if (lasuoState2 == 0) {
                    XflCkFunc.CAR_COMM_CONTROL(1, 1);
                    break;
                } else if (lasuoState2 == 1) {
                    XflCkFunc.CAR_COMM_CONTROL(1, 2);
                    break;
                } else if (lasuoState2 == 2) {
                    XflCkFunc.CAR_COMM_CONTROL(1, 3);
                    break;
                } else if (lasuoState2 == 3) {
                    XflCkFunc.CAR_COMM_CONTROL(1, 0);
                    break;
                }
            case R.id.btn_minus2 /* 2131427484 */:
                int ParkingAutoUnlockState = DataCanbus.DATA[11];
                if (ParkingAutoUnlockState == 0) {
                    XflCkFunc.CAR_COMM_CONTROL(4, 2);
                    break;
                } else if (ParkingAutoUnlockState == 1) {
                    XflCkFunc.CAR_COMM_CONTROL(4, 0);
                    break;
                } else if (ParkingAutoUnlockState == 2) {
                    XflCkFunc.CAR_COMM_CONTROL(4, 1);
                    break;
                }
            case R.id.btn_plus2 /* 2131427486 */:
                int ParkingAutoUnlockState2 = DataCanbus.DATA[11];
                if (ParkingAutoUnlockState2 == 0) {
                    XflCkFunc.CAR_COMM_CONTROL(4, 1);
                    break;
                } else if (ParkingAutoUnlockState2 == 1) {
                    XflCkFunc.CAR_COMM_CONTROL(4, 2);
                    break;
                } else if (ParkingAutoUnlockState2 == 2) {
                    XflCkFunc.CAR_COMM_CONTROL(4, 0);
                    break;
                }
            case R.id.btn_minus3 /* 2131427488 */:
                int LockFeedState = DataCanbus.DATA[14];
                if (LockFeedState == 0) {
                    XflCkFunc.CAR_COMM_CONTROL(7, 3);
                    break;
                } else if (LockFeedState == 1) {
                    XflCkFunc.CAR_COMM_CONTROL(7, 0);
                    break;
                } else if (LockFeedState == 2) {
                    XflCkFunc.CAR_COMM_CONTROL(7, 1);
                    break;
                } else if (LockFeedState == 3) {
                    XflCkFunc.CAR_COMM_CONTROL(7, 2);
                    break;
                }
            case R.id.btn_plus3 /* 2131427490 */:
                int LockFeedState2 = DataCanbus.DATA[14];
                if (LockFeedState2 == 0) {
                    XflCkFunc.CAR_COMM_CONTROL(7, 1);
                    break;
                } else if (LockFeedState2 == 1) {
                    XflCkFunc.CAR_COMM_CONTROL(7, 2);
                    break;
                } else if (LockFeedState2 == 2) {
                    XflCkFunc.CAR_COMM_CONTROL(7, 3);
                    break;
                } else if (LockFeedState2 == 3) {
                    XflCkFunc.CAR_COMM_CONTROL(7, 0);
                    break;
                }
            case R.id.btn_minus4 /* 2131427492 */:
                int mSeatHeat = DataCanbus.DATA[20];
                if (mSeatHeat == 0) {
                    XflCkFunc.CAR_COMM_CONTROL(13, 3);
                    break;
                } else if (mSeatHeat == 1) {
                    XflCkFunc.CAR_COMM_CONTROL(13, 0);
                    break;
                } else if (mSeatHeat == 2) {
                    XflCkFunc.CAR_COMM_CONTROL(13, 1);
                    break;
                } else if (mSeatHeat == 3) {
                    XflCkFunc.CAR_COMM_CONTROL(13, 2);
                    break;
                }
            case R.id.btn_plus4 /* 2131427494 */:
                int mSeatHeat2 = DataCanbus.DATA[20];
                if (mSeatHeat2 == 0) {
                    XflCkFunc.CAR_COMM_CONTROL(13, 1);
                    break;
                } else if (mSeatHeat2 == 1) {
                    XflCkFunc.CAR_COMM_CONTROL(13, 2);
                    break;
                } else if (mSeatHeat2 == 2) {
                    XflCkFunc.CAR_COMM_CONTROL(13, 3);
                    break;
                } else if (mSeatHeat2 == 3) {
                    XflCkFunc.CAR_COMM_CONTROL(13, 0);
                    break;
                }
            case R.id.btn_minus5 /* 2131427496 */:
                int mSeatWind = DataCanbus.DATA[19];
                if (mSeatWind == 0) {
                    XflCkFunc.CAR_COMM_CONTROL(26, 3);
                    break;
                } else if (mSeatWind == 1) {
                    XflCkFunc.CAR_COMM_CONTROL(26, 0);
                    break;
                } else if (mSeatWind == 2) {
                    XflCkFunc.CAR_COMM_CONTROL(26, 1);
                    break;
                } else if (mSeatWind == 3) {
                    XflCkFunc.CAR_COMM_CONTROL(26, 2);
                    break;
                }
            case R.id.btn_plus5 /* 2131427498 */:
                int mSeatWind2 = DataCanbus.DATA[19];
                if (mSeatWind2 == 0) {
                    XflCkFunc.CAR_COMM_CONTROL(26, 1);
                    break;
                } else if (mSeatWind2 == 1) {
                    XflCkFunc.CAR_COMM_CONTROL(26, 2);
                    break;
                } else if (mSeatWind2 == 2) {
                    XflCkFunc.CAR_COMM_CONTROL(26, 3);
                    break;
                } else if (mSeatWind2 == 3) {
                    XflCkFunc.CAR_COMM_CONTROL(26, 0);
                    break;
                }
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                XflCkFunc.CAR_COMM_CONTROL(2, DataCanbus.DATA[9] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                XflCkFunc.CAR_COMM_CONTROL(3, DataCanbus.DATA[10] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                XflCkFunc.CAR_COMM_CONTROL(5, DataCanbus.DATA[12] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                XflCkFunc.CAR_COMM_CONTROL(6, DataCanbus.DATA[13] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                XflCkFunc.CAR_COMM_CONTROL(8, DataCanbus.DATA[15] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                XflCkFunc.CAR_COMM_CONTROL(9, DataCanbus.DATA[17] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                YLFunc.CAR_COMM_CONTROL(10, DataCanbus.DATA[18] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                YLFunc.CAR_COMM_CONTROL(12, DataCanbus.DATA[36] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                YLFunc.CAR_COMM_CONTROL(11, DataCanbus.DATA[16] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                YLFunc.CAR_COMM_CONTROL(14, DataCanbus.DATA[35] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext13 /* 2131427545 */:
                YLFunc.CAR_COMM_CONTROL(35, DataCanbus.DATA[78] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext14 /* 2131427546 */:
                YLFunc.CAR_COMM_CONTROL(15, DataCanbus.DATA[37] != 0 ? 0 : 1);
                break;
        }
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

    @Override // com.syu.canbus.BaseActivity
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
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[78].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBrightness() {
        int mInCarAutoUnLock = DataCanbus.DATA[35];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setChecked(mInCarAutoUnLock == 1);
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            if (mInCarAutoUnLock == 0) {
                ((TextView) findViewById(R.id.tv_text7)).setText(R.string.xp_psa_all_string_door_open_0);
            } else {
                ((TextView) findViewById(R.id.tv_text7)).setText(R.string.xp_psa_all_string_door_open_1);
            }
        }
    }

    protected void uAutoLock() {
        int mAutoLock = DataCanbus.DATA[78];
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext13), mAutoLock == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterContrast() {
        int mSeatHeat = DataCanbus.DATA[20];
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            switch (mSeatHeat) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_onstar_call_alarm_off);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_sb_saiou3_str8);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_sb_saiou3_str9);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSaturation() {
        int mSeatWind = DataCanbus.DATA[19];
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            switch (mSeatWind) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text5)).setText(R.string.klc_onstar_call_alarm_off);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_sb_saiou3_str8);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_sb_saiou3_str9);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue6() {
        int mCarWarm = DataCanbus.DATA[37];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext14)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setChecked(mCarWarm != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterLookLight() {
        int lightState = DataCanbus.DATA[7];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(lightState != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterDelaySet() {
        int lasuoState = DataCanbus.DATA[8];
        if (lasuoState == 0) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_Parking_with_trailer_Off);
            return;
        }
        if (lasuoState == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_light_Lasuo_headlight_delay_1);
        } else if (lasuoState == 2) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_light_Lasuo_headlight_delay_2);
        } else if (lasuoState == 3) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_light_Lasuo_headlight_delay_3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateParkingAutoUnLock() {
        int ParkingAutoUnlockState = DataCanbus.DATA[11];
        if (ParkingAutoUnlockState == 0) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_Parking_with_trailer_Off);
        } else if (ParkingAutoUnlockState == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
        } else if (ParkingAutoUnlockState == 2) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoLatch() {
        int AutoLatchState = DataCanbus.DATA[10];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(AutoLatchState != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePreventAutoLatch() {
        int PreventAutoLatchState = DataCanbus.DATA[9];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(PreventAutoLatchState != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDelayLatch() {
        int DelayLatchState = DataCanbus.DATA[12];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(DelayLatchState != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUnlockLight() {
        int UnlockLightState = DataCanbus.DATA[13];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(UnlockLightState != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLockDoorFeed() {
        int LockFeedState = DataCanbus.DATA[14];
        if (LockFeedState == 0) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Remote_control_latch_only_light);
            return;
        }
        if (LockFeedState == 1) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
        } else if (LockFeedState == 2) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Remote_control_latch_speaker);
        } else if (LockFeedState == 3) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_onstar_close);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRemoteOpen() {
        int RemoteUnlockState = DataCanbus.DATA[15];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(RemoteUnlockState != 0);
        if (RemoteUnlockState == 0) {
            ((TextView) findViewById(R.id.tv_text8)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
        } else if (RemoteUnlockState == 1) {
            ((TextView) findViewById(R.id.tv_text8)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRemoteReLock() {
        int RemoteReLockState = DataCanbus.DATA[17];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(RemoteReLockState != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRemoteSatrtCar() {
        int RemoteStartCarState = DataCanbus.DATA[18];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(RemoteStartCarState != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateKeyFogget() {
        int KeyFoggetState = DataCanbus.DATA[36];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(KeyFoggetState != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterreversWipersStart() {
        int AutoWipesState = DataCanbus.DATA[16];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(AutoWipesState != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCheckEnable() {
        int carControlEnAble = DataCanbus.DATA[38];
        if (carControlEnAble == 0) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setChecked(false);
            ((TextView) findViewById(R.id.tv_text6)).setText(R.string.xfl_ck_car_enable_off);
        } else if (carControlEnAble == 1) {
            ((TextView) findViewById(R.id.tv_text6)).setText(R.string.xfl_ck_car_enable_on);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setChecked(true);
        }
    }
}
