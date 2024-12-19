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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RzcKlcRemoteAct extends Activity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.klc.RzcKlcRemoteAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 13:
                    RzcKlcRemoteAct.this.updateUnlockLight();
                    break;
                case 14:
                    RzcKlcRemoteAct.this.updateLockDoorFeed();
                    break;
                case 15:
                    RzcKlcRemoteAct.this.updateRemoteOpen();
                    break;
                case 17:
                    RzcKlcRemoteAct.this.updateRemoteReLock();
                    break;
                case 18:
                    RzcKlcRemoteAct.this.updateRemoteSatrtCar();
                    break;
                case 22:
                    RzcKlcRemoteAct.this.updateRemoteNearOpen();
                    break;
                case 23:
                    RzcKlcRemoteAct.this.updateKeyFogget();
                    break;
                case 24:
                    RzcKlcRemoteAct.this.updatePersonalization();
                    break;
                case 25:
                    RzcKlcRemoteAct.this.updateAutoRelockDoor();
                    break;
                case 27:
                    RzcKlcRemoteAct.this.updateSideBlidWarn();
                    break;
                case 28:
                    RzcKlcRemoteAct.this.updateLeaveAutoLatch();
                    break;
                case 29:
                    RzcKlcRemoteAct.this.updateAutoCollision();
                    break;
                case 30:
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
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int UnlockLightState = DataCanbus.DATA[13];
                RzcKlcFunc.CAR_COMM_CONTROL(6, UnlockLightState == 0 ? 1 : 0);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int LockFeedState = DataCanbus.DATA[14];
                if (LockFeedState == 0) {
                    RzcKlcFunc.CAR_COMM_CONTROL(7, 3);
                    break;
                } else if (LockFeedState == 1) {
                    RzcKlcFunc.CAR_COMM_CONTROL(7, 0);
                    break;
                } else if (LockFeedState == 2) {
                    RzcKlcFunc.CAR_COMM_CONTROL(7, 1);
                    break;
                } else if (LockFeedState == 3) {
                    RzcKlcFunc.CAR_COMM_CONTROL(7, 2);
                    break;
                }
            case R.id.btn_plus1 /* 2131427482 */:
                int LockFeedState2 = DataCanbus.DATA[14];
                if (LockFeedState2 == 0) {
                    RzcKlcFunc.CAR_COMM_CONTROL(7, 1);
                    break;
                } else if (LockFeedState2 == 1) {
                    RzcKlcFunc.CAR_COMM_CONTROL(7, 2);
                    break;
                } else if (LockFeedState2 == 2) {
                    RzcKlcFunc.CAR_COMM_CONTROL(7, 3);
                    break;
                } else if (LockFeedState2 == 3) {
                    RzcKlcFunc.CAR_COMM_CONTROL(7, 0);
                    break;
                }
            case R.id.btn_minus2 /* 2131427484 */:
                int LeaverDoorState = DataCanbus.DATA[28];
                if (LeaverDoorState == 0) {
                    RzcKlcFunc.CAR_COMM_CONTROL(23, 2);
                    break;
                } else if (LeaverDoorState == 1) {
                    RzcKlcFunc.CAR_COMM_CONTROL(23, 0);
                    break;
                } else if (LeaverDoorState == 2) {
                    RzcKlcFunc.CAR_COMM_CONTROL(23, 1);
                    break;
                }
            case R.id.btn_plus2 /* 2131427486 */:
                int LeaverDoorState2 = DataCanbus.DATA[28];
                if (LeaverDoorState2 == 0) {
                    RzcKlcFunc.CAR_COMM_CONTROL(23, 1);
                    break;
                } else if (LeaverDoorState2 == 1) {
                    RzcKlcFunc.CAR_COMM_CONTROL(23, 2);
                    break;
                } else if (LeaverDoorState2 == 2) {
                    RzcKlcFunc.CAR_COMM_CONTROL(23, 0);
                    break;
                }
            case R.id.btn_minus3 /* 2131427488 */:
                int AutoCollisionSate = DataCanbus.DATA[29];
                if (AutoCollisionSate == 0) {
                    RzcKlcFunc.CAR_COMM_CONTROL(24, 2);
                    break;
                } else if (AutoCollisionSate == 1) {
                    RzcKlcFunc.CAR_COMM_CONTROL(24, 0);
                    break;
                } else if (AutoCollisionSate == 2) {
                    RzcKlcFunc.CAR_COMM_CONTROL(24, 1);
                    break;
                }
            case R.id.btn_plus3 /* 2131427490 */:
                int AutoCollisionSate2 = DataCanbus.DATA[29];
                if (AutoCollisionSate2 == 0) {
                    RzcKlcFunc.CAR_COMM_CONTROL(24, 1);
                    break;
                } else if (AutoCollisionSate2 == 1) {
                    RzcKlcFunc.CAR_COMM_CONTROL(24, 2);
                    break;
                } else if (AutoCollisionSate2 == 2) {
                    RzcKlcFunc.CAR_COMM_CONTROL(24, 0);
                    break;
                }
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int RemoteUnlockState = DataCanbus.DATA[15];
                RzcKlcFunc.CAR_COMM_CONTROL(8, RemoteUnlockState == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int RemoteReLockState = DataCanbus.DATA[17];
                RzcKlcFunc.CAR_COMM_CONTROL(10, RemoteReLockState == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int RemoteStartCarState = DataCanbus.DATA[18];
                RzcKlcFunc.CAR_COMM_CONTROL(11, RemoteStartCarState == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int NearOpenSetState = DataCanbus.DATA[22];
                RzcKlcFunc.CAR_COMM_CONTROL(12, NearOpenSetState == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int KeyFoggetState = DataCanbus.DATA[23];
                RzcKlcFunc.CAR_COMM_CONTROL(13, KeyFoggetState == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int PersonalizationSate = DataCanbus.DATA[24];
                RzcKlcFunc.CAR_COMM_CONTROL(14, PersonalizationSate == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int AutoRelockDoorState = DataCanbus.DATA[25];
                RzcKlcFunc.CAR_COMM_CONTROL(15, AutoRelockDoorState == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int SideBlindState = DataCanbus.DATA[27];
                RzcKlcFunc.CAR_COMM_CONTROL(22, SideBlindState == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int CarStatusNote = DataCanbus.DATA[30];
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
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUnlockLight() {
        int UnlockLightState = DataCanbus.DATA[13];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(UnlockLightState != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLockDoorFeed() {
        int LockFeedState = DataCanbus.DATA[14];
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
        int RemoteUnlockState = DataCanbus.DATA[15];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(RemoteUnlockState != 0);
        if (RemoteUnlockState == 0) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
        } else if (RemoteUnlockState == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRemoteReLock() {
        int RemoteReLockState = DataCanbus.DATA[17];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(RemoteReLockState != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRemoteSatrtCar() {
        int RemoteStartCarState = DataCanbus.DATA[18];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(RemoteStartCarState != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRemoteNearOpen() {
        int NearOpenSetState = DataCanbus.DATA[22];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(NearOpenSetState != 0);
        if (NearOpenSetState == 0) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
        } else if (NearOpenSetState == 1) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateKeyFogget() {
        int KeyFoggetState = DataCanbus.DATA[23];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(KeyFoggetState != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePersonalization() {
        int PersonalizationSate = DataCanbus.DATA[24];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(PersonalizationSate != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoRelockDoor() {
        int AutoRelockDoorState = DataCanbus.DATA[25];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(AutoRelockDoorState != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSideBlidWarn() {
        int SideBlindState = DataCanbus.DATA[27];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(SideBlindState != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLeaveAutoLatch() {
        int LeaverDoorState = DataCanbus.DATA[28];
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
        int CarStatusNote = DataCanbus.DATA[30];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(CarStatusNote != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoCollision() {
        int AutoCollisionSate = DataCanbus.DATA[29];
        if (AutoCollisionSate == 0) {
            ((TextView) findViewById(R.id.tv_text5)).setText(R.string.klc_onstar_close);
        } else if (AutoCollisionSate == 1) {
            ((TextView) findViewById(R.id.tv_text5)).setText(R.string.wc_weilang_auto_fangzhuang_warn);
        } else if (AutoCollisionSate == 2) {
            ((TextView) findViewById(R.id.tv_text5)).setText(R.string.wc_weilang_auto_fangzhuang_warn_and_zhidong);
        }
    }
}
