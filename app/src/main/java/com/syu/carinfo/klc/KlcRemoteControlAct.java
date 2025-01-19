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

public class KlcRemoteControlAct extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
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
                KlcRemoteControlAct.this.findViewById(R.id.klc_remote_Remote_control_latch_view).setVisibility(8);
                return;
            }
            if (enable == 1) {
                KlcRemoteControlAct.this.findViewById(R.id.klc_remote_Remote_control_latch_view).setVisibility(0);
                if (switchOn == 0) {
                    ((TextView) KlcRemoteControlAct.this.findViewById(R.id.klc_remote_Remote_control_latch_tv)).setText(R.string.klc_remote_Remote_control_latch_only_light);
                    return;
                }
                if (switchOn == 1) {
                    ((TextView) KlcRemoteControlAct.this.findViewById(R.id.klc_remote_Remote_control_latch_tv)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                } else if (switchOn == 2) {
                    ((TextView) KlcRemoteControlAct.this.findViewById(R.id.klc_remote_Remote_control_latch_tv)).setText(R.string.klc_remote_Remote_control_latch_speaker);
                } else if (switchOn == 3) {
                    ((TextView) KlcRemoteControlAct.this.findViewById(R.id.klc_remote_Remote_control_latch_tv)).setText(R.string.klc_Parking_with_trailer_Off);
                }
            }
        }

        private void updateRemoteUnLockFeedBack() {
            int val = DataCanbus.DATA[130];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                KlcRemoteControlAct.this.findViewById(R.id.Remote_control_Unlock_Feedback_view).setVisibility(8);
                return;
            }
            if (enable == 1) {
                KlcRemoteControlAct.this.findViewById(R.id.Remote_control_Unlock_Feedback_view).setVisibility(0);
                ((CheckedTextView) KlcRemoteControlAct.this.findViewById(R.id.klc_btn_Remote_control_Unlock_Feedback_check)).setChecked(switchOn != 0);
                if (switchOn == 0) {
                    ((TextView) KlcRemoteControlAct.this.findViewById(R.id.klc_Remote_control_Unlock_Feedback_Tv)).setText(R.string.klc_Parking_with_trailer_Off);
                } else if (switchOn == 1) {
                    ((TextView) KlcRemoteControlAct.this.findViewById(R.id.klc_Remote_control_Unlock_Feedback_Tv)).setText(R.string.klc_Remote_control_Unlock_Feedback_light);
                }
            }
        }

        private void updateRemoteLockSet() {
            int val = DataCanbus.DATA[131];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                KlcRemoteControlAct.this.findViewById(R.id.klc_btn_Remote_control_Unlock_view).setVisibility(8);
                return;
            }
            if (enable == 1) {
                KlcRemoteControlAct.this.findViewById(R.id.klc_btn_Remote_control_Unlock_view).setVisibility(0);
                ((CheckedTextView) KlcRemoteControlAct.this.findViewById(R.id.klc_btn_Remote_control_Unlock_check)).setChecked(switchOn != 0);
                if (switchOn == 0) {
                    ((TextView) KlcRemoteControlAct.this.findViewById(R.id.klc_Remote_control_Unlock_Tv)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
                } else if (switchOn == 1) {
                    ((TextView) KlcRemoteControlAct.this.findViewById(R.id.klc_Remote_control_Unlock_Tv)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
                }
            }
        }

        private void updateRemoteUnlockAutoLock() {
            int val = DataCanbus.DATA[132];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                KlcRemoteControlAct.this.findViewById(R.id.klc_Remote_unlocking_doors_automatically_relock_view).setVisibility(8);
            } else if (enable == 1) {
                KlcRemoteControlAct.this.findViewById(R.id.klc_Remote_unlocking_doors_automatically_relock_view).setVisibility(0);
                ((CheckedTextView) KlcRemoteControlAct.this.findViewById(R.id.klc_Remote_unlocking_doors_automatically_relock_check)).setChecked(switchOn != 0);
            }
        }

        private void updateRelockRemoteOpenDoor() {
            int val = DataCanbus.DATA[133];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                KlcRemoteControlAct.this.findViewById(R.id.klc_btn_Re_opened_door_lock_Remote_control_view).setVisibility(8);
            } else if (enable == 1) {
                KlcRemoteControlAct.this.findViewById(R.id.klc_btn_Re_opened_door_lock_Remote_control_view).setVisibility(0);
                ((CheckedTextView) KlcRemoteControlAct.this.findViewById(R.id.klc_btn_Re_opened_door_lock_Remote_control_check)).setChecked(switchOn != 0);
            }
        }

        private void updateDriverKeyAutoShibie() {
            int val = DataCanbus.DATA[134];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                KlcRemoteControlAct.this.findViewById(R.id.klc_btn_Automatic_identification_key_driver_view).setVisibility(8);
            } else if (enable == 1) {
                KlcRemoteControlAct.this.findViewById(R.id.klc_btn_Automatic_identification_key_driver_view).setVisibility(0);
                ((CheckedTextView) KlcRemoteControlAct.this.findViewById(R.id.klc_btn_Automatic_identification_key_driver_check)).setChecked(switchOn != 0);
            }
        }

        private void updateYuanchengStartSet() {
            int val = DataCanbus.DATA[135];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                KlcRemoteControlAct.this.findViewById(R.id.klc_btn_Remote_Start_view).setVisibility(8);
            } else if (enable == 1) {
                KlcRemoteControlAct.this.findViewById(R.id.klc_btn_Remote_Start_view).setVisibility(0);
                ((CheckedTextView) KlcRemoteControlAct.this.findViewById(R.id.klc_btn_Remote_Start_check)).setChecked(switchOn != 0);
            }
        }

        private void updateNearCarUnlock() {
            int val = DataCanbus.DATA[136];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                KlcRemoteControlAct.this.findViewById(R.id.klc_btn_Smart_Near_car_unlocked_view).setVisibility(8);
                return;
            }
            if (enable == 1) {
                KlcRemoteControlAct.this.findViewById(R.id.klc_btn_Smart_Near_car_unlocked_view).setVisibility(0);
                ((CheckedTextView) KlcRemoteControlAct.this.findViewById(R.id.klc_btn_Smart_Near_car_unlocked_check)).setChecked(switchOn != 0);
                if (switchOn == 0) {
                    ((TextView) KlcRemoteControlAct.this.findViewById(R.id.klc_remote_Smart_Near_car_unlocked_TV)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
                } else if (switchOn == 1) {
                    ((TextView) KlcRemoteControlAct.this.findViewById(R.id.klc_remote_Smart_Near_car_unlocked_TV)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
                }
            }
        }

        private void updateLeaveCarLock() {
            int val = DataCanbus.DATA[137];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                KlcRemoteControlAct.this.findViewById(R.id.klc_remote_Smart_from_the_car_latch_view).setVisibility(8);
                return;
            }
            if (enable == 1) {
                KlcRemoteControlAct.this.findViewById(R.id.klc_remote_Smart_from_the_car_latch_view).setVisibility(0);
                if (switchOn == 0) {
                    ((TextView) KlcRemoteControlAct.this.findViewById(R.id.klc_Smart_from_the_car_latch_Tv)).setText(R.string.klc_Parking_with_trailer_Off);
                } else if (switchOn == 1) {
                    ((TextView) KlcRemoteControlAct.this.findViewById(R.id.klc_Smart_from_the_car_latch_Tv)).setText(R.string.klc_Parking_with_trailer_ON);
                } else if (switchOn == 2) {
                    ((TextView) KlcRemoteControlAct.this.findViewById(R.id.klc_Smart_from_the_car_latch_Tv)).setText(R.string.klc_remote_Smart_from_the_car_latch_Speaker_tweet_enabled);
                }
            }
        }

        private void updateForgetKey() {
            int val = DataCanbus.DATA[138];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                KlcRemoteControlAct.this.findViewById(R.id.klc_btn_Forgotten_Keys_view).setVisibility(8);
            } else if (enable == 1) {
                KlcRemoteControlAct.this.findViewById(R.id.klc_btn_Forgotten_Keys_view).setVisibility(0);
                ((CheckedTextView) KlcRemoteControlAct.this.findViewById(R.id.klc_btn_Forgotten_Keys_check)).setChecked(switchOn != 0);
            }
        }

        private void updateRemoteHuayimenSet() {
            int val = DataCanbus.DATA[139];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                KlcRemoteControlAct.this.findViewById(R.id.klc_remote_Remote_control_sliding_door_view).setVisibility(8);
                return;
            }
            if (enable == 1) {
                KlcRemoteControlAct.this.findViewById(R.id.klc_remote_Remote_control_sliding_door_view).setVisibility(0);
                ((CheckedTextView) KlcRemoteControlAct.this.findViewById(R.id.klc_remote_Remote_control_sliding_door_set_check)).setChecked(switchOn != 0);
                if (switchOn == 0) {
                    ((TextView) KlcRemoteControlAct.this.findViewById(R.id.klc_remote_Remote_control_sliding_door_set_tv)).setText(R.string.klc_remote_unlock_sliding_door_open_all_door_set);
                } else if (switchOn == 1) {
                    ((TextView) KlcRemoteControlAct.this.findViewById(R.id.klc_remote_Remote_control_sliding_door_set_tv)).setText(R.string.klc_remote_unlock_open_sliding_door_set);
                }
            }
        }

        private void updateRemoteWindowControl() {
            int val = DataCanbus.DATA[167];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                KlcRemoteControlAct.this.findViewById(R.id.wc_weilang_remote_car_window_control_view).setVisibility(8);
            } else if (enable == 1) {
                KlcRemoteControlAct.this.findViewById(R.id.wc_weilang_remote_car_window_control_view).setVisibility(0);
                ((CheckedTextView) KlcRemoteControlAct.this.findViewById(R.id.wc_weilang_remote_car_window_control_check)).setChecked(switchOn != 0);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_klc_remote_control_set);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.klc_btn_Remote_control_Unlock_Feedback_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_btn_Remote_control_Unlock_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_Remote_unlocking_doors_automatically_relock_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_btn_Re_opened_door_lock_Remote_control_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_btn_Automatic_identification_key_driver_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_btn_Remote_Start_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_btn_Smart_Near_car_unlocked_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_btn_Forgotten_Keys_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_remote_Remote_control_sliding_door_set_check)).setOnClickListener(this);
        ((Button) findViewById(R.id.klc_remote_Remote_control_latch_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.klc_remote_Remote_control_latch_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.klc_Smart_from_the_car_latch_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.klc_Smart_from_the_car_latch_next)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.wc_weilang_remote_car_window_control_check)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.klc_remote_Remote_control_latch_pre /* 2131431943 */:
                int valLatchPre = DataCanbus.DATA[129] & 255;
                if (valLatchPre == 0) {
                    KlcFunc.C_CAR_REMOTE(1, 3);
                    break;
                } else if (valLatchPre == 1) {
                    KlcFunc.C_CAR_REMOTE(1, 0);
                    break;
                } else if (valLatchPre == 2) {
                    KlcFunc.C_CAR_REMOTE(1, 1);
                    break;
                } else if (valLatchPre == 3) {
                    KlcFunc.C_CAR_REMOTE(1, 2);
                    break;
                }
            case R.id.klc_remote_Remote_control_latch_next /* 2131431945 */:
                int valLatchNext = DataCanbus.DATA[129] & 255;
                if (valLatchNext == 0) {
                    KlcFunc.C_CAR_REMOTE(1, 1);
                    break;
                } else if (valLatchNext == 1) {
                    KlcFunc.C_CAR_REMOTE(1, 2);
                    break;
                } else if (valLatchNext == 2) {
                    KlcFunc.C_CAR_REMOTE(1, 3);
                    break;
                } else if (valLatchNext == 3) {
                    KlcFunc.C_CAR_REMOTE(1, 0);
                    break;
                }
            case R.id.klc_btn_Remote_control_Unlock_Feedback_check /* 2131431947 */:
                int valFeed = DataCanbus.DATA[130] & 255;
                KlcFunc.C_CAR_REMOTE(2, valFeed == 0 ? 1 : 0);
                break;
            case R.id.klc_btn_Remote_control_Unlock_check /* 2131431950 */:
                int valUnlock = DataCanbus.DATA[131] & 255;
                KlcFunc.C_CAR_REMOTE(3, valUnlock == 0 ? 1 : 0);
                break;
            case R.id.klc_Remote_unlocking_doors_automatically_relock_check /* 2131431953 */:
                int valRemoteAutoRelock = DataCanbus.DATA[132] & 255;
                KlcFunc.C_CAR_REMOTE(4, valRemoteAutoRelock == 0 ? 1 : 0);
                break;
            case R.id.klc_btn_Re_opened_door_lock_Remote_control_check /* 2131431955 */:
                int valReOpen = DataCanbus.DATA[133] & 255;
                KlcFunc.C_CAR_REMOTE(5, valReOpen == 0 ? 1 : 0);
                break;
            case R.id.klc_btn_Automatic_identification_key_driver_check /* 2131431957 */:
                int valAutoKey = DataCanbus.DATA[134] & 255;
                KlcFunc.C_CAR_REMOTE(6, valAutoKey == 0 ? 1 : 0);
                break;
            case R.id.klc_btn_Remote_Start_check /* 2131431959 */:
                int valRemoteStart = DataCanbus.DATA[135] & 255;
                KlcFunc.C_CAR_REMOTE(7, valRemoteStart == 0 ? 1 : 0);
                break;
            case R.id.klc_btn_Smart_Near_car_unlocked_check /* 2131431961 */:
                int valSmartNearUnlock = DataCanbus.DATA[136] & 255;
                KlcFunc.C_CAR_REMOTE(8, valSmartNearUnlock == 0 ? 1 : 0);
                break;
            case R.id.klc_btn_Forgotten_Keys_check /* 2131431964 */:
                int valForgotKey = DataCanbus.DATA[138] & 255;
                KlcFunc.C_CAR_REMOTE(9, valForgotKey == 0 ? 1 : 0);
                break;
            case R.id.klc_Smart_from_the_car_latch_pre /* 2131431966 */:
                int valSmartCarPre = DataCanbus.DATA[137] & 255;
                if (valSmartCarPre == 0) {
                    KlcFunc.C_CAR_REMOTE(10, 2);
                    break;
                } else if (valSmartCarPre == 1) {
                    KlcFunc.C_CAR_REMOTE(10, 0);
                    break;
                } else if (valSmartCarPre == 2) {
                    KlcFunc.C_CAR_REMOTE(10, 1);
                    break;
                }
            case R.id.klc_Smart_from_the_car_latch_next /* 2131431968 */:
                int valSmartCarNext = DataCanbus.DATA[137] & 255;
                if (valSmartCarNext == 0) {
                    KlcFunc.C_CAR_REMOTE(10, 1);
                    break;
                } else if (valSmartCarNext == 1) {
                    KlcFunc.C_CAR_REMOTE(10, 2);
                    break;
                } else if (valSmartCarNext == 2) {
                    KlcFunc.C_CAR_REMOTE(10, 0);
                    break;
                }
            case R.id.klc_remote_Remote_control_sliding_door_set_check /* 2131431970 */:
                int valSilidSet = DataCanbus.DATA[139] & 255;
                KlcFunc.C_CAR_REMOTE(11, valSilidSet == 0 ? 1 : 0);
                break;
            case R.id.wc_weilang_remote_car_window_control_check /* 2131431973 */:
                int value = DataCanbus.DATA[167] & 255;
                KlcFunc.C_CAR_REMOTE(12, value == 0 ? 1 : 0);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        findViewById(R.id.wc_weilang_remote_car_window_control_view).setVisibility(0);
        addUpdater();
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
