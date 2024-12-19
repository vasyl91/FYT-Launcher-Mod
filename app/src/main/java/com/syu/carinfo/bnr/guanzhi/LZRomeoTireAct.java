package com.syu.carinfo.bnr.guanzhi;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LZRomeoTireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.bnr.guanzhi.LZRomeoTireAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 28:
                    LZRomeoTireAct.this.mUpdaterTireFL();
                    break;
                case 29:
                    LZRomeoTireAct.this.mUpdaterTireFR();
                    break;
                case 30:
                    LZRomeoTireAct.this.mUpdaterTireRL();
                    break;
                case 31:
                    LZRomeoTireAct.this.mUpdaterTireRR();
                    break;
                case 32:
                    LZRomeoTireAct.this.mUpdaterTireFL();
                    LZRomeoTireAct.this.mUpdaterTireFR();
                    LZRomeoTireAct.this.mUpdaterTireRL();
                    LZRomeoTireAct.this.mUpdaterTireRR();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bnr_guanzhi_tire);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        findViewById(R.id.btn_bnr_tire_reset).setVisibility(8);
        findViewById(R.id.tv_text1).setVisibility(8);
        DataCanbus.PROXY.cmd(0, new int[]{54}, null, null);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[28];
        int unit = DataCanbus.DATA[32];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
        }
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value * 10) + "Kpa");
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value) + "psi");
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value / 10) + "." + (value % 10) + "bar");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[29];
        int unit = DataCanbus.DATA[32];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
        }
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value * 10) + "Kpa");
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value) + "psi");
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value / 10) + "." + (value % 10) + "bar");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[30];
        int unit = DataCanbus.DATA[32];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
        }
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value * 10) + "Kpa");
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value) + "psi");
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value / 10) + "." + (value % 10) + "bar");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[31];
        int unit = DataCanbus.DATA[32];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
        }
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value * 10) + "Kpa");
                break;
            case 1:
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value) + "psi");
                break;
            case 2:
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value / 10) + "." + (value % 10) + "bar");
                break;
        }
    }
}
