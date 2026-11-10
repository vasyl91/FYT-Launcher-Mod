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
public class KlcLockAct extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.klc.KlcLockAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 124:
                    KlcLockAct.this.updatePreventAutoLuoSuo();
                    break;
                case 125:
                    KlcLockAct.this.updateAutoLuosuo();
                    break;
                case 126:
                    KlcLockAct.this.updateAutoUnlockZidong();
                    break;
                case 127:
                    KlcLockAct.this.updataDelayLockSet();
                    break;
                case 128:
                    KlcLockAct.this.updataAutoUnlockShoudong();
                    break;
                case 189:
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
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427417 */:
                int valAutoTranPre = DataCanbus.DATA[126] & 255;
                if (valAutoTranPre == 0) {
                    KlcFunc.C_CAR_LOCK(3, 2);
                } else if (valAutoTranPre == 1) {
                    KlcFunc.C_CAR_LOCK(3, 0);
                } else if (valAutoTranPre == 2) {
                    KlcFunc.C_CAR_LOCK(3, 1);
                }
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int valAutoTranNext = DataCanbus.DATA[126] & 255;
                if (valAutoTranNext == 0) {
                    KlcFunc.C_CAR_LOCK(3, 1);
                } else if (valAutoTranNext == 1) {
                    KlcFunc.C_CAR_LOCK(3, 2);
                } else if (valAutoTranNext == 2) {
                    KlcFunc.C_CAR_LOCK(3, 0);
                }
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int valManTranPre = DataCanbus.DATA[128] & 255;
                if (DataCanbus.DATA[1000] == 2424868) {
                    if (valManTranPre == 0) {
                        KlcFunc.C_CAR_LOCK(5, 2);
                    } else if (valManTranPre == 2) {
                        KlcFunc.C_CAR_LOCK(5, 0);
                    }
                } else if (valManTranPre == 0) {
                    KlcFunc.C_CAR_LOCK(5, 2);
                } else if (valManTranPre == 1) {
                    KlcFunc.C_CAR_LOCK(5, 0);
                } else if (valManTranPre == 2) {
                    KlcFunc.C_CAR_LOCK(5, 1);
                }
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int valManTranNext = DataCanbus.DATA[128] & 255;
                if (DataCanbus.DATA[1000] == 2424868) {
                    if (valManTranNext == 0) {
                        KlcFunc.C_CAR_LOCK(5, 2);
                    } else if (valManTranNext == 2) {
                        KlcFunc.C_CAR_LOCK(5, 0);
                    }
                } else if (valManTranNext == 0) {
                    KlcFunc.C_CAR_LOCK(5, 1);
                } else if (valManTranNext == 1) {
                    KlcFunc.C_CAR_LOCK(5, 2);
                } else if (valManTranNext == 2) {
                    KlcFunc.C_CAR_LOCK(5, 0);
                }
                break;
            case R.id.ctv_checkedtext1 /* 2131427548 */:
                int valPre = DataCanbus.DATA[124] & 255;
                KlcFunc.C_CAR_LOCK(1, valPre == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427552 */:
                int val_antilock = DataCanbus.DATA[189] & 255;
                KlcFunc.C_CAR_LOCK(6, val_antilock == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427558 */:
                int valLatch = DataCanbus.DATA[125] & 255;
                KlcFunc.C_CAR_LOCK(2, valLatch == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427559 */:
                int valLatchDelay = DataCanbus.DATA[127] & 255;
                KlcFunc.C_CAR_LOCK(4, valLatchDelay == 0 ? 1 : 0);
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
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePreventAutoLuoSuo() {
        int val = DataCanbus.DATA[124];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view1).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.layout_view1).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoLuosuo() {
        int val = DataCanbus.DATA[125];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view2).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.layout_view2).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoUnlockZidong() {
        int val = DataCanbus.DATA[126];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view3).setVisibility(8);
            return;
        }
        if (enable == 1) {
            findViewById(R.id.layout_view3).setVisibility(0);
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_Parking_with_trailer_Off);
            } else if (switchOn == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_lock_automatic_Only_the_driver_door_unlocks);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_lock_automatic_All_doors_unlock);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updataDelayLockSet() {
        int val = DataCanbus.DATA[127];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view4).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.layout_view4).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updataAnitLock() {
        int val = DataCanbus.DATA[189];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view6).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.layout_view6).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updataAutoUnlockShoudong() {
        int val = DataCanbus.DATA[128];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view5).setVisibility(8);
            return;
        }
        if (enable == 1) {
            findViewById(R.id.layout_view5).setVisibility(0);
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_Parking_with_trailer_Off);
            } else if (switchOn == 1) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_lock_manual_Only_the_driver_door_unlocks);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_lock_manual_All_doors_unlock);
            }
        }
    }
}
