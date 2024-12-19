package com.syu.carinfo.rzc.klc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RzcKlcComfortAct extends Activity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.klc.RzcKlcComfortAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 16:
                    RzcKlcComfortAct.this.updaterRearWiperAuto();
                    break;
                case 31:
                    RzcKlcComfortAct.this.updaterWarnVol();
                    break;
                case 111:
                    ((CheckedTextView) RzcKlcComfortAct.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_klc_comfort_set);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = DataCanbus.DATA[111] != 0 ? 0 : 1;
                remoteModuleProxy.cmd(97, iArr, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                if (DataCanbus.DATA[31] == 6) {
                    RzcKlcFunc.CAR_WARNN_VOL(12, 0);
                    break;
                } else {
                    RzcKlcFunc.CAR_WARNN_VOL(6, 0);
                    break;
                }
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                RzcKlcFunc.CAR_COMM_CONTROL(9, DataCanbus.DATA[16] != 0 ? 0 : 1);
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

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
    }

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterWarnVol() {
        int WarnVolState = DataCanbus.DATA[31];
        if (WarnVolState == 6) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.rzc_klc_nomal);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(false);
        } else if (WarnVolState == 12) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRearWiperAuto() {
        int RearWiperAutoState = DataCanbus.DATA[16];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(RearWiperAutoState != 0);
    }
}
