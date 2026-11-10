package com.syu.carinfo.rzc.klc;

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
public class RzcKlcRemoteAct extends Activity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.klc.RzcKlcRemoteAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 111:
                    RzcKlcRemoteAct.this.updateUnlockLight();
                    break;
                case 112:
                    RzcKlcRemoteAct.this.updateLockDoorFeed();
                    break;
                case 113:
                    RzcKlcRemoteAct.this.updateRemoteOpen();
                    break;
                case 115:
                    RzcKlcRemoteAct.this.updateRemoteReLock();
                    break;
                case 116:
                    RzcKlcRemoteAct.this.updateRemoteSatrtCar();
                    break;
                case 120:
                    RzcKlcRemoteAct.this.updateRemoteNearOpen();
                    break;
                case 121:
                    RzcKlcRemoteAct.this.updateKeyFogget();
                    break;
                case 122:
                    RzcKlcRemoteAct.this.updatePersonalization();
                    break;
                case 123:
                    RzcKlcRemoteAct.this.updateAutoRelockDoor();
                    break;
                case 125:
                    RzcKlcRemoteAct.this.updateSideBlidWarn();
                    break;
                case 126:
                    RzcKlcRemoteAct.this.updateLeaveAutoLatch();
                    break;
                case 127:
                    RzcKlcRemoteAct.this.updateAutoCollision();
                    break;
                case 128:
                    RzcKlcRemoteAct.this.updateCarStatusNote();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_klc_remote_set);
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
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int LockFeedState = DataCanbus.DATA[112];
                if (LockFeedState == 0) {
                    RzcKlcFunc.CAR_COMM_CONTROL(7, 3);
                } else if (LockFeedState == 1) {
                    RzcKlcFunc.CAR_COMM_CONTROL(7, 0);
                } else if (LockFeedState == 2) {
                    RzcKlcFunc.CAR_COMM_CONTROL(7, 1);
                } else if (LockFeedState == 3) {
                    RzcKlcFunc.CAR_COMM_CONTROL(7, 2);
                }
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int LockFeedState2 = DataCanbus.DATA[112];
                if (LockFeedState2 == 0) {
                    RzcKlcFunc.CAR_COMM_CONTROL(7, 1);
                } else if (LockFeedState2 == 1) {
                    RzcKlcFunc.CAR_COMM_CONTROL(7, 2);
                } else if (LockFeedState2 == 2) {
                    RzcKlcFunc.CAR_COMM_CONTROL(7, 3);
                } else if (LockFeedState2 == 3) {
                    RzcKlcFunc.CAR_COMM_CONTROL(7, 0);
                }
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int LeaverDoorState = DataCanbus.DATA[126];
                if (LeaverDoorState == 0) {
                    RzcKlcFunc.CAR_COMM_CONTROL(23, 2);
                } else if (LeaverDoorState == 1) {
                    RzcKlcFunc.CAR_COMM_CONTROL(23, 0);
                } else if (LeaverDoorState == 2) {
                    RzcKlcFunc.CAR_COMM_CONTROL(23, 1);
                }
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int LeaverDoorState2 = DataCanbus.DATA[126];
                if (LeaverDoorState2 == 0) {
                    RzcKlcFunc.CAR_COMM_CONTROL(23, 1);
                } else if (LeaverDoorState2 == 1) {
                    RzcKlcFunc.CAR_COMM_CONTROL(23, 2);
                } else if (LeaverDoorState2 == 2) {
                    RzcKlcFunc.CAR_COMM_CONTROL(23, 0);
                }
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int AutoCollisionSate = DataCanbus.DATA[127];
                if (AutoCollisionSate == 0) {
                    RzcKlcFunc.CAR_COMM_CONTROL(24, 2);
                } else if (AutoCollisionSate == 1) {
                    RzcKlcFunc.CAR_COMM_CONTROL(24, 0);
                } else if (AutoCollisionSate == 2) {
                    RzcKlcFunc.CAR_COMM_CONTROL(24, 1);
                }
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int AutoCollisionSate2 = DataCanbus.DATA[127];
                if (AutoCollisionSate2 == 0) {
                    RzcKlcFunc.CAR_COMM_CONTROL(24, 1);
                } else if (AutoCollisionSate2 == 1) {
                    RzcKlcFunc.CAR_COMM_CONTROL(24, 2);
                } else if (AutoCollisionSate2 == 2) {
                    RzcKlcFunc.CAR_COMM_CONTROL(24, 0);
                }
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int UnlockLightState = DataCanbus.DATA[111];
                RzcKlcFunc.CAR_COMM_CONTROL(6, UnlockLightState == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int RemoteStartCarState = DataCanbus.DATA[116];
                RzcKlcFunc.CAR_COMM_CONTROL(11, RemoteStartCarState == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int NearOpenSetState = DataCanbus.DATA[120];
                RzcKlcFunc.CAR_COMM_CONTROL(12, NearOpenSetState == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int RemoteUnlockState = DataCanbus.DATA[113];
                RzcKlcFunc.CAR_COMM_CONTROL(8, RemoteUnlockState == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int RemoteReLockState = DataCanbus.DATA[115];
                RzcKlcFunc.CAR_COMM_CONTROL(10, RemoteReLockState == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int KeyFoggetState = DataCanbus.DATA[121];
                RzcKlcFunc.CAR_COMM_CONTROL(13, KeyFoggetState == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                int PersonalizationSate = DataCanbus.DATA[122];
                RzcKlcFunc.CAR_COMM_CONTROL(14, PersonalizationSate == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                int AutoRelockDoorState = DataCanbus.DATA[123];
                RzcKlcFunc.CAR_COMM_CONTROL(15, AutoRelockDoorState == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                int SideBlindState = DataCanbus.DATA[125];
                RzcKlcFunc.CAR_COMM_CONTROL(22, SideBlindState == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                int CarStatusNote = DataCanbus.DATA[128];
                RzcKlcFunc.CAR_COMM_CONTROL(25, CarStatusNote == 0 ? 1 : 0);
                break;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addUpdater();
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
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUnlockLight() {
        int UnlockLightState = DataCanbus.DATA[111];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(UnlockLightState != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLockDoorFeed() {
        int LockFeedState = DataCanbus.DATA[112];
        if (LockFeedState == 0) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Remote_control_latch_only_light);
            return;
        }
        if (LockFeedState == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
        } else if (LockFeedState == 2) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Remote_control_latch_speaker);
        } else if (LockFeedState == 3) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_onstar_close);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRemoteOpen() {
        int RemoteUnlockState = DataCanbus.DATA[113];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(RemoteUnlockState != 0);
        if (RemoteUnlockState == 0) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
        } else if (RemoteUnlockState == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRemoteReLock() {
        int RemoteReLockState = DataCanbus.DATA[115];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(RemoteReLockState != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRemoteSatrtCar() {
        int RemoteStartCarState = DataCanbus.DATA[116];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(RemoteStartCarState != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRemoteNearOpen() {
        int NearOpenSetState = DataCanbus.DATA[120];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(NearOpenSetState != 0);
        if (NearOpenSetState == 0) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
        } else if (NearOpenSetState == 1) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateKeyFogget() {
        int KeyFoggetState = DataCanbus.DATA[121];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(KeyFoggetState != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePersonalization() {
        int PersonalizationSate = DataCanbus.DATA[122];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(PersonalizationSate != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoRelockDoor() {
        int AutoRelockDoorState = DataCanbus.DATA[123];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(AutoRelockDoorState != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSideBlidWarn() {
        int SideBlindState = DataCanbus.DATA[125];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(SideBlindState != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLeaveAutoLatch() {
        int LeaverDoorState = DataCanbus.DATA[126];
        if (LeaverDoorState == 0) {
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_onstar_close);
        } else if (LeaverDoorState == 1) {
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_Parking_with_trailer_ON);
        } else if (LeaverDoorState == 2) {
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_remote_Smart_from_the_car_latch_Speaker_tweet_enabled);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarStatusNote() {
        int CarStatusNote = DataCanbus.DATA[128];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(CarStatusNote != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoCollision() {
        int AutoCollisionSate = DataCanbus.DATA[127];
        if (AutoCollisionSate == 0) {
            ((TextView) findViewById(R.id.tv_text5)).setText(R.string.klc_onstar_close);
        } else if (AutoCollisionSate == 1) {
            ((TextView) findViewById(R.id.tv_text5)).setText(R.string.wc_weilang_auto_fangzhuang_warn);
        } else if (AutoCollisionSate == 2) {
            ((TextView) findViewById(R.id.tv_text5)).setText(R.string.wc_weilang_auto_fangzhuang_warn_and_zhidong);
        }
    }
}
