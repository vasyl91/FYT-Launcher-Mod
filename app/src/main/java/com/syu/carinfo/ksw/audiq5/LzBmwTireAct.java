package com.syu.carinfo.ksw.audiq5;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LzBmwTireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.ksw.audiq5.LzBmwTireAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 21:
                    LzBmwTireAct.this.mUpdaterTireFL();
                    break;
                case 22:
                    LzBmwTireAct.this.mUpdaterTireFR();
                    break;
                case 23:
                    LzBmwTireAct.this.mUpdaterTireRL();
                    break;
                case 24:
                    LzBmwTireAct.this.mUpdaterTireRR();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_oudi_zt_t600_tire);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[21];
        if (value == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(R.string.tireflnormal);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(R.string.tireflalarm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[22];
        if (value == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(R.string.tireflnormal);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(R.string.tireflalarm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[23];
        if (value == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(R.string.tireflnormal);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(R.string.tireflalarm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[24];
        if (value == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(R.string.tireflnormal);
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(R.string.tireflalarm);
        }
    }
}
