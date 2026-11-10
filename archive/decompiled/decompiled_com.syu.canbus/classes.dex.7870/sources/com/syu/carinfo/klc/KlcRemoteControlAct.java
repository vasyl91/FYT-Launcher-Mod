package com.syu.carinfo.klc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class KlcRemoteControlAct extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.klc.KlcRemoteControlAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 129:
                    updateRemoteLockFeedBack();
                    break;
                case 130:
                    updateRemoteUnLockFeedBack();
                    break;
                case 131:
                    updateRemoteLockSet();
                    break;
                case 132:
                    updateRemoteUnlockAutoLock();
                    break;
                case 133:
                    updateRelockRemoteOpenDoor();
                    break;
                case 134:
                    updateDriverKeyAutoShibie();
                    break;
                case 135:
                    updateYuanchengStartSet();
                    break;
                case 136:
                    updateNearCarUnlock();
                    break;
                case 137:
                    updateLeaveCarLock();
                    break;
                case 138:
                    updateForgetKey();
                    break;
                case 139:
                    updateRemoteHuayimenSet();
                    break;
                case 167:
                    updateRemoteWindowControl();
                    break;
            }
        }

        private void updateRemoteLockFeedBack() {
            int val = DataCanbus.DATA[129];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                KlcRemoteControlAct.this.findViewById(R.id.layout_view1).setVisibility(8);
                return;
            }
            if (enable == 1) {
                KlcRemoteControlAct.this.findViewById(R.id.layout_view1).setVisibility(0);
                if (switchOn == 0) {
                    ((TextView) KlcRemoteControlAct.this.findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Remote_control_latch_only_light);
                    return;
                }
                if (switchOn == 1) {
                    ((TextView) KlcRemoteControlAct.this.findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                } else if (switchOn == 2) {
                    ((TextView) KlcRemoteControlAct.this.findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Remote_control_latch_speaker);
                } else if (switchOn == 3) {
                    ((TextView) KlcRemoteControlAct.this.findViewById(R.id.tv_text1)).setText(R.string.klc_Parking_with_trailer_Off);
                }
            }
        }

        private void updateRemoteUnLockFeedBack() {
            int val = DataCanbus.DATA[130];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                KlcRemoteControlAct.this.findViewById(R.id.layout_view2).setVisibility(8);
                return;
            }
            if (enable == 1) {
                KlcRemoteControlAct.this.findViewById(R.id.layout_view2).setVisibility(0);
                ((CheckedTextView) KlcRemoteControlAct.this.findViewById(R.id.ctv_checkedtext1)).setChecked(switchOn != 0);
                if (switchOn == 0) {
                    ((TextView) KlcRemoteControlAct.this.findViewById(R.id.tv_text2)).setText(R.string.klc_Parking_with_trailer_Off);
                } else if (switchOn == 1) {
                    ((TextView) KlcRemoteControlAct.this.findViewById(R.id.tv_text2)).setText(R.string.klc_Remote_control_Unlock_Feedback_light);
                }
            }
        }

        private void updateRemoteLockSet() {
            int val = DataCanbus.DATA[131];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                KlcRemoteControlAct.this.findViewById(R.id.layout_view3).setVisibility(8);
                return;
            }
            if (enable == 1) {
                KlcRemoteControlAct.this.findViewById(R.id.layout_view3).setVisibility(0);
                ((CheckedTextView) KlcRemoteControlAct.this.findViewById(R.id.ctv_checkedtext2)).setChecked(switchOn != 0);
                if (switchOn == 0) {
                    ((TextView) KlcRemoteControlAct.this.findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
                } else if (switchOn == 1) {
                    ((TextView) KlcRemoteControlAct.this.findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
                }
            }
        }

        private void updateRemoteUnlockAutoLock() {
            int val = DataCanbus.DATA[132];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                KlcRemoteControlAct.this.findViewById(R.id.layout_view4).setVisibility(8);
            } else if (enable == 1) {
                KlcRemoteControlAct.this.findViewById(R.id.layout_view4).setVisibility(0);
                ((CheckedTextView) KlcRemoteControlAct.this.findViewById(R.id.ctv_checkedtext3)).setChecked(switchOn != 0);
            }
        }

        private void updateRelockRemoteOpenDoor() {
            int val = DataCanbus.DATA[133];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                KlcRemoteControlAct.this.findViewById(R.id.layout_view5).setVisibility(8);
            } else if (enable == 1) {
                KlcRemoteControlAct.this.findViewById(R.id.layout_view5).setVisibility(0);
                ((CheckedTextView) KlcRemoteControlAct.this.findViewById(R.id.ctv_checkedtext4)).setChecked(switchOn != 0);
            }
        }

        private void updateDriverKeyAutoShibie() {
            int val = DataCanbus.DATA[134];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                KlcRemoteControlAct.this.findViewById(R.id.layout_view6).setVisibility(8);
            } else if (enable == 1) {
                KlcRemoteControlAct.this.findViewById(R.id.layout_view6).setVisibility(0);
                ((CheckedTextView) KlcRemoteControlAct.this.findViewById(R.id.ctv_checkedtext5)).setChecked(switchOn != 0);
            }
        }

        private void updateYuanchengStartSet() {
            int val = DataCanbus.DATA[135];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                KlcRemoteControlAct.this.findViewById(R.id.layout_view7).setVisibility(8);
            } else if (enable == 1) {
                KlcRemoteControlAct.this.findViewById(R.id.layout_view7).setVisibility(0);
                ((CheckedTextView) KlcRemoteControlAct.this.findViewById(R.id.ctv_checkedtext6)).setChecked(switchOn != 0);
            }
        }

        private void updateNearCarUnlock() {
            int val = DataCanbus.DATA[136];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                KlcRemoteControlAct.this.findViewById(R.id.layout_view8).setVisibility(8);
                return;
            }
            if (enable == 1) {
                KlcRemoteControlAct.this.findViewById(R.id.layout_view8).setVisibility(0);
                ((CheckedTextView) KlcRemoteControlAct.this.findViewById(R.id.ctv_checkedtext7)).setChecked(switchOn != 0);
                if (switchOn == 0) {
                    ((TextView) KlcRemoteControlAct.this.findViewById(R.id.tv_text4)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
                } else if (switchOn == 1) {
                    ((TextView) KlcRemoteControlAct.this.findViewById(R.id.tv_text4)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
                }
            }
        }

        private void updateLeaveCarLock() {
            int val = DataCanbus.DATA[137];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                KlcRemoteControlAct.this.findViewById(R.id.layout_view10).setVisibility(8);
                return;
            }
            if (enable == 1) {
                KlcRemoteControlAct.this.findViewById(R.id.layout_view10).setVisibility(0);
                if (switchOn == 0) {
                    ((TextView) KlcRemoteControlAct.this.findViewById(R.id.tv_text5)).setText(R.string.klc_Parking_with_trailer_Off);
                } else if (switchOn == 1) {
                    ((TextView) KlcRemoteControlAct.this.findViewById(R.id.tv_text5)).setText(R.string.klc_Parking_with_trailer_ON);
                } else if (switchOn == 2) {
                    ((TextView) KlcRemoteControlAct.this.findViewById(R.id.tv_text5)).setText(R.string.klc_remote_Smart_from_the_car_latch_Speaker_tweet_enabled);
                }
            }
        }

        private void updateForgetKey() {
            int val = DataCanbus.DATA[138];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                KlcRemoteControlAct.this.findViewById(R.id.layout_view9).setVisibility(8);
            } else if (enable == 1) {
                KlcRemoteControlAct.this.findViewById(R.id.layout_view9).setVisibility(0);
                ((CheckedTextView) KlcRemoteControlAct.this.findViewById(R.id.ctv_checkedtext8)).setChecked(switchOn != 0);
            }
        }

        private void updateRemoteHuayimenSet() {
            int val = DataCanbus.DATA[139];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                KlcRemoteControlAct.this.findViewById(R.id.layout_view11).setVisibility(8);
                return;
            }
            if (enable == 1) {
                KlcRemoteControlAct.this.findViewById(R.id.layout_view11).setVisibility(0);
                ((CheckedTextView) KlcRemoteControlAct.this.findViewById(R.id.ctv_checkedtext9)).setChecked(switchOn != 0);
                if (switchOn == 0) {
                    ((TextView) KlcRemoteControlAct.this.findViewById(R.id.tv_text6)).setText(R.string.klc_remote_unlock_sliding_door_open_all_door_set);
                } else if (switchOn == 1) {
                    ((TextView) KlcRemoteControlAct.this.findViewById(R.id.tv_text6)).setText(R.string.klc_remote_unlock_open_sliding_door_set);
                }
            }
        }

        private void updateRemoteWindowControl() {
            int val = DataCanbus.DATA[167];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                KlcRemoteControlAct.this.findViewById(R.id.layout_view12).setVisibility(8);
            } else if (enable == 1) {
                KlcRemoteControlAct.this.findViewById(R.id.layout_view12).setVisibility(0);
                ((CheckedTextView) KlcRemoteControlAct.this.findViewById(R.id.ctv_checkedtext10)).setChecked(switchOn != 0);
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_klc_remote_control_set);
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
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427417 */:
                int valLatchPre = DataCanbus.DATA[129] & 255;
                if (valLatchPre == 0) {
                    KlcFunc.C_CAR_REMOTE(1, 3);
                } else if (valLatchPre == 1) {
                    KlcFunc.C_CAR_REMOTE(1, 0);
                } else if (valLatchPre == 2) {
                    KlcFunc.C_CAR_REMOTE(1, 1);
                } else if (valLatchPre == 3) {
                    KlcFunc.C_CAR_REMOTE(1, 2);
                }
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int valLatchNext = DataCanbus.DATA[129] & 255;
                if (valLatchNext == 0) {
                    KlcFunc.C_CAR_REMOTE(1, 1);
                } else if (valLatchNext == 1) {
                    KlcFunc.C_CAR_REMOTE(1, 2);
                } else if (valLatchNext == 2) {
                    KlcFunc.C_CAR_REMOTE(1, 3);
                } else if (valLatchNext == 3) {
                    KlcFunc.C_CAR_REMOTE(1, 0);
                }
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int valSmartCarPre = DataCanbus.DATA[137] & 255;
                if (valSmartCarPre == 0) {
                    KlcFunc.C_CAR_REMOTE(10, 2);
                } else if (valSmartCarPre == 1) {
                    KlcFunc.C_CAR_REMOTE(10, 0);
                } else if (valSmartCarPre == 2) {
                    KlcFunc.C_CAR_REMOTE(10, 1);
                }
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int valSmartCarNext = DataCanbus.DATA[137] & 255;
                if (valSmartCarNext == 0) {
                    KlcFunc.C_CAR_REMOTE(10, 1);
                } else if (valSmartCarNext == 1) {
                    KlcFunc.C_CAR_REMOTE(10, 2);
                } else if (valSmartCarNext == 2) {
                    KlcFunc.C_CAR_REMOTE(10, 0);
                }
                break;
            case R.id.ctv_checkedtext1 /* 2131427548 */:
                int valFeed = DataCanbus.DATA[130] & 255;
                KlcFunc.C_CAR_REMOTE(2, valFeed == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427552 */:
                int valReOpen = DataCanbus.DATA[133] & 255;
                KlcFunc.C_CAR_REMOTE(5, valReOpen == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427553 */:
                int valAutoKey = DataCanbus.DATA[134] & 255;
                KlcFunc.C_CAR_REMOTE(6, valAutoKey == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427558 */:
                int valUnlock = DataCanbus.DATA[131] & 255;
                KlcFunc.C_CAR_REMOTE(3, valUnlock == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427559 */:
                int valRemoteAutoRelock = DataCanbus.DATA[132] & 255;
                KlcFunc.C_CAR_REMOTE(4, valRemoteAutoRelock == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427563 */:
                int valRemoteStart = DataCanbus.DATA[135] & 255;
                KlcFunc.C_CAR_REMOTE(7, valRemoteStart == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427564 */:
                int valSmartNearUnlock = DataCanbus.DATA[136] & 255;
                KlcFunc.C_CAR_REMOTE(8, valSmartNearUnlock == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427615 */:
                int valForgotKey = DataCanbus.DATA[138] & 255;
                KlcFunc.C_CAR_REMOTE(9, valForgotKey == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427616 */:
                int valSilidSet = DataCanbus.DATA[139] & 255;
                KlcFunc.C_CAR_REMOTE(11, valSilidSet == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext10 /* 2131427617 */:
                int value = DataCanbus.DATA[167] & 255;
                KlcFunc.C_CAR_REMOTE(12, value == 0 ? 1 : 0);
                break;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        findViewById(R.id.layout_view12).setVisibility(0);
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
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
    }
}
