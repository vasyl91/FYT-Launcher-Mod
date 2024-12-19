package com.syu.carinfo.xbs.tule;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XBSTuleTireActDZSJ extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.tule.XBSTuleTireActDZSJ.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 41:
                    XBSTuleTireActDZSJ.this.mUpdaterTireFL();
                    break;
                case 42:
                    XBSTuleTireActDZSJ.this.mUpdaterTireFR();
                    break;
                case 43:
                    XBSTuleTireActDZSJ.this.mUpdaterTireRL();
                    break;
                case 44:
                    XBSTuleTireActDZSJ.this.mUpdaterTireRR();
                    break;
                case 45:
                    XBSTuleTireActDZSJ.this.updaterFLWalm();
                    break;
                case 46:
                    XBSTuleTireActDZSJ.this.updaterFRWalm();
                    break;
                case 47:
                    XBSTuleTireActDZSJ.this.updaterRLWalm();
                    break;
                case 48:
                    XBSTuleTireActDZSJ.this.updaterRRWalm();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xbs_tule_dzsj_tire);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[41];
        if (value == 65535) {
            ((TextView) findViewById(R.id.xbs_tule_fl_tire_tv)).setText("--.--");
        } else if (((TextView) findViewById(R.id.xbs_tule_fl_tire_tv)) != null) {
            ((TextView) findViewById(R.id.xbs_tule_fl_tire_tv)).setText(String.valueOf(value) + "kPa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[42];
        if (value == 65535) {
            ((TextView) findViewById(R.id.xbs_tule_fr_tire_tv)).setText("--.--");
        } else if (((TextView) findViewById(R.id.xbs_tule_fr_tire_tv)) != null) {
            ((TextView) findViewById(R.id.xbs_tule_fr_tire_tv)).setText(String.valueOf(value) + "kPa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[43];
        if (value == 65535) {
            ((TextView) findViewById(R.id.xbs_tule_rl_tire_tv)).setText("--.--");
        } else if (((TextView) findViewById(R.id.xbs_tule_rl_tire_tv)) != null) {
            ((TextView) findViewById(R.id.xbs_tule_rl_tire_tv)).setText(String.valueOf(value) + "kPa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[44];
        if (value == 65535) {
            ((TextView) findViewById(R.id.xbs_tule_rr_tire_tv)).setText("--.--");
        } else if (((TextView) findViewById(R.id.xbs_tule_rr_tire_tv)) != null) {
            ((TextView) findViewById(R.id.xbs_tule_rr_tire_tv)).setText(String.valueOf(value) + "kPa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFLWalm() {
        int value = DataCanbus.DATA[45];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.xbs_tule_fl_tire_tv)).setTextColor(-1);
                break;
            case 1:
                ((TextView) findViewById(R.id.xbs_tule_fl_tire_tv)).setTextColor(-65536);
                break;
            case 2:
                ((TextView) findViewById(R.id.xbs_tule_fl_tire_tv)).setTextColor(-256);
                break;
            case 3:
                ((TextView) findViewById(R.id.xbs_tule_fl_tire_tv)).setTextColor(-65536);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFRWalm() {
        int value = DataCanbus.DATA[46];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.xbs_tule_fr_tire_tv)).setTextColor(-1);
                break;
            case 1:
                ((TextView) findViewById(R.id.xbs_tule_fr_tire_tv)).setTextColor(-65536);
                break;
            case 2:
                ((TextView) findViewById(R.id.xbs_tule_fr_tire_tv)).setTextColor(-256);
                break;
            case 3:
                ((TextView) findViewById(R.id.xbs_tule_fr_tire_tv)).setTextColor(-65536);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRLWalm() {
        int value = DataCanbus.DATA[47];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.xbs_tule_rl_tire_tv)).setTextColor(-1);
                break;
            case 1:
                ((TextView) findViewById(R.id.xbs_tule_rl_tire_tv)).setTextColor(-65536);
                break;
            case 2:
                ((TextView) findViewById(R.id.xbs_tule_rl_tire_tv)).setTextColor(-256);
                break;
            case 3:
                ((TextView) findViewById(R.id.xbs_tule_rl_tire_tv)).setTextColor(-65536);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRRWalm() {
        int value = DataCanbus.DATA[48];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.xbs_tule_rr_tire_tv)).setTextColor(-1);
                break;
            case 1:
                ((TextView) findViewById(R.id.xbs_tule_rr_tire_tv)).setTextColor(-65536);
                break;
            case 2:
                ((TextView) findViewById(R.id.xbs_tule_rr_tire_tv)).setTextColor(-256);
                break;
            case 3:
                ((TextView) findViewById(R.id.xbs_tule_rr_tire_tv)).setTextColor(-65536);
                break;
        }
    }
}
