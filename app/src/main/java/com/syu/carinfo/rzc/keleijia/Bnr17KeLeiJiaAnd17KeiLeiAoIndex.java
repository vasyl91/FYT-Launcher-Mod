package com.syu.carinfo.rzc.keleijia;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Bnr17KeLeiJiaAnd17KeiLeiAoIndex extends BaseActivity {
    protected Handler mHandler;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.keleijia.Bnr17KeLeiJiaAnd17KeiLeiAoIndex.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 51:
                    int val = DataCanbus.DATA[updateCode];
                    Bnr17KeLeiJiaAnd17KeiLeiAoIndex.this.uAirMode(val);
                    break;
            }
        }
    };
    View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.syu.carinfo.rzc.keleijia.Bnr17KeLeiJiaAnd17KeiLeiAoIndex.2
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.bnr_air_soft /* 2131430625 */:
                    if (DataCanbus.DATA[1000] == 1048978 || DataCanbus.DATA[1000] == 1376658 || DataCanbus.DATA[1000] == 1180050 || DataCanbus.DATA[1000] == 1311122 || DataCanbus.DATA[1000] == 1638802 || DataCanbus.DATA[1000] == 2228626 || DataCanbus.DATA[1000] == 1704338 || DataCanbus.DATA[1000] == 1769874 || DataCanbus.DATA[1000] == 1966482 || DataCanbus.DATA[1000] == 2032018 || DataCanbus.DATA[1000] == 2097554 || DataCanbus.DATA[1000] == 2163090 || DataCanbus.DATA[1000] == 3801490 || DataCanbus.DATA[1000] == 3867026 || DataCanbus.DATA[1000] == 3932562 || DataCanbus.DATA[1000] == 5964178) {
                        Bnr17KeLeiJiaAnd17KeiLeiAoIndex.this.setCarCMD(25, DataCanbus.DATA[51] & 32);
                        break;
                    } else {
                        Bnr17KeLeiJiaAnd17KeiLeiAoIndex.this.setCarCMD(50, DataCanbus.DATA[51] & 32);
                        break;
                    }
                case R.id.bnr_air_normal /* 2131430626 */:
                    if (DataCanbus.DATA[1000] == 1048978 || DataCanbus.DATA[1000] == 1376658 || DataCanbus.DATA[1000] == 1180050 || DataCanbus.DATA[1000] == 1311122 || DataCanbus.DATA[1000] == 1638802 || DataCanbus.DATA[1000] == 2228626 || DataCanbus.DATA[1000] == 1704338 || DataCanbus.DATA[1000] == 1769874 || DataCanbus.DATA[1000] == 1966482 || DataCanbus.DATA[1000] == 2032018 || DataCanbus.DATA[1000] == 2097554 || DataCanbus.DATA[1000] == 2163090 || DataCanbus.DATA[1000] == 3801490 || DataCanbus.DATA[1000] == 3867026 || DataCanbus.DATA[1000] == 3932562 || DataCanbus.DATA[1000] == 5964178) {
                        Bnr17KeLeiJiaAnd17KeiLeiAoIndex.this.setCarCMD(27, DataCanbus.DATA[51] & 32);
                        break;
                    } else {
                        Bnr17KeLeiJiaAnd17KeiLeiAoIndex.this.setCarCMD(51, DataCanbus.DATA[51] & 16);
                        break;
                    }
                case R.id.bnr_air_fast /* 2131430627 */:
                    if (DataCanbus.DATA[1000] == 1048978 || DataCanbus.DATA[1000] == 1376658 || DataCanbus.DATA[1000] == 1180050 || DataCanbus.DATA[1000] == 1311122 || DataCanbus.DATA[1000] == 1638802 || DataCanbus.DATA[1000] == 2228626 || DataCanbus.DATA[1000] == 1704338 || DataCanbus.DATA[1000] == 1769874 || DataCanbus.DATA[1000] == 1966482 || DataCanbus.DATA[1000] == 2032018 || DataCanbus.DATA[1000] == 2097554 || DataCanbus.DATA[1000] == 2163090 || DataCanbus.DATA[1000] == 3801490 || DataCanbus.DATA[1000] == 3867026 || DataCanbus.DATA[1000] == 3932562 || DataCanbus.DATA[1000] == 5964178) {
                        Bnr17KeLeiJiaAnd17KeiLeiAoIndex.this.setCarCMD(26, DataCanbus.DATA[51] & 32);
                        break;
                    } else {
                        Bnr17KeLeiJiaAnd17KeiLeiAoIndex.this.setCarCMD(52, DataCanbus.DATA[51] & 8);
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bnr_17keleijiaand17keileiao_airset);
        this.mHandler = new Handler(Looper.getMainLooper());
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((CheckedTextView) findViewById(R.id.bnr_air_soft)).setOnClickListener(this.mClickListener);
        ((CheckedTextView) findViewById(R.id.bnr_air_normal)).setOnClickListener(this.mClickListener);
        ((CheckedTextView) findViewById(R.id.bnr_air_fast)).setOnClickListener(this.mClickListener);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCarCMD(final int cmd, int id) {
        DataCanbus.PROXY.cmd(0, new int[]{cmd, 1}, null, null);
        this.mHandler.postDelayed(new Runnable() { // from class: com.syu.carinfo.rzc.keleijia.Bnr17KeLeiJiaAnd17KeiLeiAoIndex.3
            @Override // java.lang.Runnable
            public void run() {
                DataCanbus.PROXY.cmd(0, new int[]{cmd}, null, null);
            }
        }, 200L);
    }

    protected void uAirMode(int val) {
        if (DataCanbus.DATA[1000] == 1048978 || DataCanbus.DATA[1000] == 1376658 || DataCanbus.DATA[1000] == 1769874 || DataCanbus.DATA[1000] == 1704338 || DataCanbus.DATA[1000] == 2228626 || DataCanbus.DATA[1000] == 1180050 || DataCanbus.DATA[1000] == 1311122 || DataCanbus.DATA[1000] == 1638802 || DataCanbus.DATA[1000] == 1704338 || DataCanbus.DATA[1000] == 1769874 || DataCanbus.DATA[1000] == 1966482 || DataCanbus.DATA[1000] == 2032018 || DataCanbus.DATA[1000] == 2097554 || DataCanbus.DATA[1000] == 2163090 || DataCanbus.DATA[1000] == 3801490 || DataCanbus.DATA[1000] == 3867026 || DataCanbus.DATA[1000] == 3932562 || DataCanbus.DATA[1000] == 5964178) {
            int status = (val >> 6) & 1;
            if (status == 1) {
                ((CheckedTextView) findViewById(R.id.bnr_air_soft)).setChecked(true);
            } else {
                ((CheckedTextView) findViewById(R.id.bnr_air_soft)).setChecked(false);
            }
            int status2 = (val >> 4) & 1;
            if (status2 == 1) {
                ((CheckedTextView) findViewById(R.id.bnr_air_normal)).setChecked(true);
            } else {
                ((CheckedTextView) findViewById(R.id.bnr_air_normal)).setChecked(false);
            }
            int status3 = (val >> 5) & 1;
            if (status3 == 1) {
                ((CheckedTextView) findViewById(R.id.bnr_air_fast)).setChecked(true);
                return;
            } else {
                ((CheckedTextView) findViewById(R.id.bnr_air_fast)).setChecked(false);
                return;
            }
        }
        int status4 = val & 32;
        if (status4 == 32) {
            ((CheckedTextView) findViewById(R.id.bnr_air_soft)).setChecked(true);
        } else {
            ((CheckedTextView) findViewById(R.id.bnr_air_soft)).setChecked(false);
        }
        int status5 = val & 16;
        if (status5 == 16) {
            ((CheckedTextView) findViewById(R.id.bnr_air_normal)).setChecked(true);
        } else {
            ((CheckedTextView) findViewById(R.id.bnr_air_normal)).setChecked(false);
        }
        int status6 = val & 8;
        if (status6 == 8) {
            ((CheckedTextView) findViewById(R.id.bnr_air_fast)).setChecked(true);
        } else {
            ((CheckedTextView) findViewById(R.id.bnr_air_fast)).setChecked(false);
        }
    }
}
