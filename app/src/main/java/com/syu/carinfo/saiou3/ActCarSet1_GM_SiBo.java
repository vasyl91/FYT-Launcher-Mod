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

public class ActCarSet1_GM_SiBo extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 104:
                    ActCarSet1_GM_SiBo.this.updaterLookLight();
                    break;
                case 105:
                    ActCarSet1_GM_SiBo.this.updaterDelaySet();
                    break;
                case 106:
                    ActCarSet1_GM_SiBo.this.updatePreventAutoLatch();
                    break;
                case 107:
                    ActCarSet1_GM_SiBo.this.updateAutoLatch();
                    break;
                case 108:
                    ActCarSet1_GM_SiBo.this.updateParkingAutoUnLock();
                    break;
                case 109:
                    ActCarSet1_GM_SiBo.this.updateDelayLatch();
                    break;
                case 110:
                    ActCarSet1_GM_SiBo.this.updateUnlockLight();
                    break;
                case 111:
                    ActCarSet1_GM_SiBo.this.updateLockDoorFeed();
                    break;
                case 112:
                    ActCarSet1_GM_SiBo.this.updateRemoteOpen();
                    break;
                case 113:
                    ActCarSet1_GM_SiBo.this.updaterreversWipersStart();
                    break;
                case 114:
                    ActCarSet1_GM_SiBo.this.updateRemoteReLock();
                    break;
                case 115:
                    ActCarSet1_GM_SiBo.this.updateRemoteSatrtCar();
                    break;
                case 116:
                    ActCarSet1_GM_SiBo.this.mUpdaterSaturation();
                    break;
                case 117:
                    ActCarSet1_GM_SiBo.this.mUpdaterContrast();
                    break;
                case 132:
                    ActCarSet1_GM_SiBo.this.mUpdaterBrightness();
                    break;
                case 133:
                    ActCarSet1_GM_SiBo.this.updateKeyFogget();
                    break;
                case 134:
                    ActCarSet1_GM_SiBo.this.mUpdaterValue6();
                    break;
                case 135:
                    ActCarSet1_GM_SiBo.this.updaterCheckEnable();
                    break;
                case 137:
                    ActCarSet1_GM_SiBo.this.uAutoLock();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_sb_gm_car_set1);
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

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427455 */:
                int lasuoState = DataCanbus.DATA[105];
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
            case R.id.btn_plus1 /* 2131427457 */:
                int lasuoState2 = DataCanbus.DATA[105];
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
            case R.id.btn_minus2 /* 2131427458 */:
                int ParkingAutoUnlockState = DataCanbus.DATA[108];
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
            case R.id.btn_plus2 /* 2131427460 */:
                int ParkingAutoUnlockState2 = DataCanbus.DATA[108];
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
            case R.id.btn_minus3 /* 2131427461 */:
                int LockFeedState = DataCanbus.DATA[111];
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
            case R.id.btn_plus3 /* 2131427463 */:
                int LockFeedState2 = DataCanbus.DATA[111];
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
            case R.id.btn_minus4 /* 2131427464 */:
                int mSeatHeat = DataCanbus.DATA[117];
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
            case R.id.btn_plus4 /* 2131427466 */:
                int mSeatHeat2 = DataCanbus.DATA[117];
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
            case R.id.btn_minus5 /* 2131427467 */:
                int mSeatWind = DataCanbus.DATA[116];
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
            case R.id.btn_plus5 /* 2131427469 */:
                int mSeatWind2 = DataCanbus.DATA[116];
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
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                XflCkFunc.CAR_COMM_CONTROL(0, DataCanbus.DATA[104] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                XflCkFunc.CAR_COMM_CONTROL(2, DataCanbus.DATA[106] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                XflCkFunc.CAR_COMM_CONTROL(3, DataCanbus.DATA[107] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                XflCkFunc.CAR_COMM_CONTROL(5, DataCanbus.DATA[109] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                XflCkFunc.CAR_COMM_CONTROL(6, DataCanbus.DATA[110] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                XflCkFunc.CAR_COMM_CONTROL(8, DataCanbus.DATA[112] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                XflCkFunc.CAR_COMM_CONTROL(9, DataCanbus.DATA[114] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                YLFunc.CAR_COMM_CONTROL(10, DataCanbus.DATA[115] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                YLFunc.CAR_COMM_CONTROL(12, DataCanbus.DATA[133] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                YLFunc.CAR_COMM_CONTROL(11, DataCanbus.DATA[113] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                YLFunc.CAR_COMM_CONTROL(14, DataCanbus.DATA[132] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                YLFunc.CAR_COMM_CONTROL(35, DataCanbus.DATA[137] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                YLFunc.CAR_COMM_CONTROL(15, DataCanbus.DATA[134] != 0 ? 0 : 1);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        addUpdater();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    @Override
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
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterBrightness() {
        int mInCarAutoUnLock = DataCanbus.DATA[132];
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
        int mAutoLock = DataCanbus.DATA[137];
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext13), mAutoLock == 1);
    }

    
    public void mUpdaterContrast() {
        int mSeatHeat = DataCanbus.DATA[117];
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

    
    public void mUpdaterSaturation() {
        int mSeatWind = DataCanbus.DATA[116];
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

    
    public void mUpdaterValue6() {
        int mCarWarm = DataCanbus.DATA[134];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext14)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setChecked(mCarWarm != 0);
        }
    }

    
    public void updaterLookLight() {
        int lightState = DataCanbus.DATA[104];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(lightState != 0);
    }

    
    public void updaterDelaySet() {
        int lasuoState = DataCanbus.DATA[105];
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

    
    public void updateParkingAutoUnLock() {
        int ParkingAutoUnlockState = DataCanbus.DATA[108];
        if (ParkingAutoUnlockState == 0) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_Parking_with_trailer_Off);
        } else if (ParkingAutoUnlockState == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
        } else if (ParkingAutoUnlockState == 2) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
        }
    }

    
    public void updateAutoLatch() {
        int AutoLatchState = DataCanbus.DATA[107];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(AutoLatchState != 0);
    }

    
    public void updatePreventAutoLatch() {
        int PreventAutoLatchState = DataCanbus.DATA[106];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(PreventAutoLatchState != 0);
    }

    
    public void updateDelayLatch() {
        int DelayLatchState = DataCanbus.DATA[109];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(DelayLatchState != 0);
    }

    
    public void updateUnlockLight() {
        int UnlockLightState = DataCanbus.DATA[110];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(UnlockLightState != 0);
    }

    
    public void updateLockDoorFeed() {
        int LockFeedState = DataCanbus.DATA[111];
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

    
    public void updateRemoteOpen() {
        int RemoteUnlockState = DataCanbus.DATA[112];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(RemoteUnlockState != 0);
        if (RemoteUnlockState == 0) {
            ((TextView) findViewById(R.id.tv_text8)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
        } else if (RemoteUnlockState == 1) {
            ((TextView) findViewById(R.id.tv_text8)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
        }
    }

    
    public void updateRemoteReLock() {
        int RemoteReLockState = DataCanbus.DATA[114];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(RemoteReLockState != 0);
    }

    
    public void updateRemoteSatrtCar() {
        int RemoteStartCarState = DataCanbus.DATA[115];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(RemoteStartCarState != 0);
    }

    
    public void updateKeyFogget() {
        int KeyFoggetState = DataCanbus.DATA[133];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(KeyFoggetState != 0);
    }

    
    public void updaterreversWipersStart() {
        int AutoWipesState = DataCanbus.DATA[113];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(AutoWipesState != 0);
    }

    
    public void updaterCheckEnable() {
        int carControlEnAble = DataCanbus.DATA[135];
        if (carControlEnAble == 0) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setChecked(false);
            ((TextView) findViewById(R.id.tv_text6)).setText(R.string.xfl_ck_car_enable_off);
        } else if (carControlEnAble == 1) {
            ((TextView) findViewById(R.id.tv_text6)).setText(R.string.xfl_ck_car_enable_on);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setChecked(true);
        }
    }
}
