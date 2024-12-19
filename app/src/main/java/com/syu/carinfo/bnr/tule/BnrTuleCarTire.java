package com.syu.carinfo.bnr.tule;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class BnrTuleCarTire extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.bnr.tule.BnrTuleCarTire.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 25:
                    BnrTuleCarTire.this.mUpdaterTireFL();
                    break;
                case 26:
                    BnrTuleCarTire.this.mUpdaterTireFR();
                    break;
                case 27:
                    BnrTuleCarTire.this.mUpdaterTireRL();
                    break;
                case 28:
                    BnrTuleCarTire.this.mUpdaterTireRR();
                    break;
                case 29:
                    BnrTuleCarTire.this.mUpdaterTireFL();
                    BnrTuleCarTire.this.mUpdaterTireFR();
                    BnrTuleCarTire.this.mUpdaterTireRL();
                    BnrTuleCarTire.this.mUpdaterTireRR();
                    break;
                case 30:
                    BnrTuleCarTire.this.updaterFRWalm();
                    BnrTuleCarTire.this.updaterFLWalm();
                    BnrTuleCarTire.this.updaterRLWalm();
                    BnrTuleCarTire.this.updaterRRWalm();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (LauncherApplication.getConfiguration() == 1) {
            setContentView(R.layout.layout_xbs_tule_tire);
        } else {
            setContentView(R.layout.layout_oudi_zt_t600_tire);
        }
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[25];
        int value1 = (DataCanbus.DATA[29] >> 6) & 1;
        if (value1 == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value) + "kPa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[26];
        int value1 = (DataCanbus.DATA[29] >> 7) & 1;
        if (value1 == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value) + "kPa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[27];
        int value1 = (DataCanbus.DATA[29] >> 4) & 1;
        if (value1 == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value) + "kPa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[28];
        int value1 = (DataCanbus.DATA[29] >> 5) & 1;
        if (value1 == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value) + "kPa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFLWalm() {
        int value = (DataCanbus.DATA[30] >> 6) & 1;
        int value1 = (DataCanbus.DATA[30] >> 2) & 1;
        if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflalarm);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tirefllow);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflnormal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFRWalm() {
        int value = (DataCanbus.DATA[30] >> 7) & 1;
        int value1 = (DataCanbus.DATA[30] >> 3) & 1;
        if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflalarm);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tirefllow);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflnormal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRLWalm() {
        int value = (DataCanbus.DATA[30] >> 4) & 1;
        int value1 = (DataCanbus.DATA[30] >> 0) & 1;
        if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflalarm);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tirefllow);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflnormal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRRWalm() {
        int value = (DataCanbus.DATA[30] >> 5) & 1;
        int value1 = (DataCanbus.DATA[30] >> 1) & 1;
        if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflalarm);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tirefllow);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflnormal);
        }
    }
}
