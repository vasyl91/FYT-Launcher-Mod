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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class KlcLockAct extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.klc.KlcLockAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 27:
                    KlcLockAct.this.updatePreventAutoLuoSuo();
                    break;
                case 28:
                    KlcLockAct.this.updateAutoLuosuo();
                    break;
                case 29:
                    KlcLockAct.this.updateAutoUnlockZidong();
                    break;
                case 30:
                    KlcLockAct.this.updataDelayLockSet();
                    break;
                case 31:
                    KlcLockAct.this.updataAutoUnlockShoudong();
                    break;
                case 137:
                    KlcLockAct.this.updataAnitLock();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_klc_lock_set);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.klc_btn_Prevent_automatic_door_latch_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_btn_Automatic_latch_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_btn_Delay_latch_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.klc_btn_prevent_anti_lock)).setOnClickListener(this);
        ((Button) findViewById(R.id.klc_lock_automatic_transmission_btn_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.klc_lock_automatic_transmission_btn_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.klc_lock_manual_transmission_btn_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.klc_lock_manual_transmission_btn_next)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.klc_btn_Prevent_automatic_door_latch_check /* 2131431935 */:
                int valPre = DataCanbus.DATA[27] & 255;
                KlcFunc.C_CAR_LOCK(1, valPre == 0 ? 1 : 0);
                break;
            case R.id.klc_btn_Automatic_latch_check /* 2131431937 */:
                int valLatch = DataCanbus.DATA[28] & 255;
                KlcFunc.C_CAR_LOCK(2, valLatch == 0 ? 1 : 0);
                break;
            case R.id.klc_lock_automatic_transmission_btn_pre /* 2131431939 */:
                int valAutoTranPre = DataCanbus.DATA[29] & 255;
                if (valAutoTranPre == 0) {
                    KlcFunc.C_CAR_LOCK(3, 2);
                    break;
                } else if (valAutoTranPre == 1) {
                    KlcFunc.C_CAR_LOCK(3, 0);
                    break;
                } else if (valAutoTranPre == 2) {
                    KlcFunc.C_CAR_LOCK(3, 1);
                    break;
                }
            case R.id.klc_lock_automatic_transmission_btn_next /* 2131431941 */:
                int valAutoTranNext = DataCanbus.DATA[29] & 255;
                if (valAutoTranNext == 0) {
                    KlcFunc.C_CAR_LOCK(3, 1);
                    break;
                } else if (valAutoTranNext == 1) {
                    KlcFunc.C_CAR_LOCK(3, 2);
                    break;
                } else if (valAutoTranNext == 2) {
                    KlcFunc.C_CAR_LOCK(3, 0);
                    break;
                }
            case R.id.klc_btn_Delay_latch_check /* 2131431943 */:
                int valLatchDelay = DataCanbus.DATA[30] & 255;
                KlcFunc.C_CAR_LOCK(4, valLatchDelay == 0 ? 1 : 0);
                break;
            case R.id.klc_lock_manual_transmission_btn_pre /* 2131431945 */:
                int valManTranPre = DataCanbus.DATA[31] & 255;
                if (DataCanbus.DATA[1000] == 308) {
                    if (valManTranPre == 0) {
                        KlcFunc.C_CAR_LOCK(5, 2);
                        break;
                    } else if (valManTranPre == 2) {
                        KlcFunc.C_CAR_LOCK(5, 0);
                        break;
                    }
                } else if (valManTranPre == 0) {
                    KlcFunc.C_CAR_LOCK(5, 2);
                    break;
                } else if (valManTranPre == 1) {
                    KlcFunc.C_CAR_LOCK(5, 0);
                    break;
                } else if (valManTranPre == 2) {
                    KlcFunc.C_CAR_LOCK(5, 1);
                    break;
                }
            case R.id.klc_lock_manual_transmission_btn_next /* 2131431947 */:
                int valManTranNext = DataCanbus.DATA[31] & 255;
                if (DataCanbus.DATA[1000] == 308) {
                    if (valManTranNext == 0) {
                        KlcFunc.C_CAR_LOCK(5, 2);
                        break;
                    } else if (valManTranNext == 2) {
                        KlcFunc.C_CAR_LOCK(5, 0);
                        break;
                    }
                } else if (valManTranNext == 0) {
                    KlcFunc.C_CAR_LOCK(5, 1);
                    break;
                } else if (valManTranNext == 1) {
                    KlcFunc.C_CAR_LOCK(5, 2);
                    break;
                } else if (valManTranNext == 2) {
                    KlcFunc.C_CAR_LOCK(5, 0);
                    break;
                }
            case R.id.klc_btn_prevent_anti_lock /* 2131431949 */:
                int val_antilock = DataCanbus.DATA[137] & 255;
                KlcFunc.C_CAR_LOCK(6, val_antilock == 0 ? 1 : 0);
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
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePreventAutoLuoSuo() {
        int val = DataCanbus.DATA[27];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.klc_lock_Prevent_automatic_door_latch_view).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.klc_lock_Prevent_automatic_door_latch_view).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.klc_btn_Prevent_automatic_door_latch_check)).setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoLuosuo() {
        int val = DataCanbus.DATA[28];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (DataCanbus.DATA[1000] == 254) {
            enable = 1;
        }
        if (enable == 0) {
            findViewById(R.id.klc_lock_Automatic_latch_view).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.klc_lock_Automatic_latch_view).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.klc_btn_Automatic_latch_check)).setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoUnlockZidong() {
        int val = DataCanbus.DATA[29];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (DataCanbus.DATA[1000] == 254) {
            enable = 1;
        }
        if (enable == 0) {
            findViewById(R.id.klc_lock_automatic_transmission_view).setVisibility(8);
            return;
        }
        if (enable == 1) {
            findViewById(R.id.klc_lock_automatic_transmission_view).setVisibility(0);
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.klc_lock_automatic_transmission_Tv)).setText(R.string.klc_Parking_with_trailer_Off);
            } else if (switchOn == 1) {
                ((TextView) findViewById(R.id.klc_lock_automatic_transmission_Tv)).setText(R.string.klc_lock_automatic_Only_the_driver_door_unlocks);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.klc_lock_automatic_transmission_Tv)).setText(R.string.klc_lock_automatic_All_doors_unlock);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updataDelayLockSet() {
        int val = DataCanbus.DATA[30];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.klc_lock_Delay_latch_view).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.klc_lock_Delay_latch_view).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.klc_btn_Delay_latch_check)).setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updataAnitLock() {
        int val = DataCanbus.DATA[137];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.klc_prevent_anti_lock_view).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.klc_prevent_anti_lock_view).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.klc_btn_prevent_anti_lock)).setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updataAutoUnlockShoudong() {
        int val = DataCanbus.DATA[31];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.klc_lock_manual_transmission_view).setVisibility(8);
            return;
        }
        if (enable == 1) {
            findViewById(R.id.klc_lock_manual_transmission_view).setVisibility(0);
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.klc_lock_manual_transmission_Tv)).setText(R.string.klc_Parking_with_trailer_Off);
            } else if (switchOn == 1) {
                ((TextView) findViewById(R.id.klc_lock_manual_transmission_Tv)).setText(R.string.klc_lock_manual_Only_the_driver_door_unlocks);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.klc_lock_manual_transmission_Tv)).setText(R.string.klc_lock_manual_All_doors_unlock);
            }
        }
    }
}