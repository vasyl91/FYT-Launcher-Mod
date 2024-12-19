package com.syu.carinfo.wc.gs4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class GS4AirSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.gs4.GS4AirSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 0:
                    GS4AirSetAct.this.updaterAutoCompressor();
                    break;
                case 1:
                    GS4AirSetAct.this.updaterAutoCycleState();
                    break;
                case 2:
                    GS4AirSetAct.this.updaterComfort();
                    break;
                case 3:
                    GS4AirSetAct.this.updaterNegativeIonMode();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_289_wc_gs4_air_set);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.wc_gs4_air_set_auto_compressor_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.wc_gs4_air_set_auto_cycle_state_check)).setOnClickListener(this);
        ((Button) findViewById(R.id.wc_gs4_air_set_comfort_curve_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.wc_gs4_air_set_comfort_curve_next)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.wc_chga6_negativeioc_modeengineer)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.wc_gs4_air_set_auto_compressor_check /* 2131429059 */:
                int mAutoCompre = DataCanbus.DATA[0];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 2;
                iArr[1] = mAutoCompre == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
                break;
            case R.id.wc_gs4_air_set_auto_cycle_state_check /* 2131429060 */:
                int mAutoCycle = DataCanbus.DATA[1];
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 3;
                iArr2[1] = mAutoCycle == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(2, iArr2, null, null);
                break;
            case R.id.wc_gs4_air_set_comfort_curve_pre /* 2131429062 */:
                int mAirComfort = DataCanbus.DATA[2];
                if (mAirComfort == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{4, 2}, null, null);
                    break;
                } else if (mAirComfort == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{4}, null, null);
                    break;
                } else if (mAirComfort == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{4, 1}, null, null);
                    break;
                }
            case R.id.wc_gs4_air_set_comfort_curve_next /* 2131429064 */:
                int mAirComfort2 = DataCanbus.DATA[2];
                if (mAirComfort2 == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{4, 1}, null, null);
                    break;
                } else if (mAirComfort2 == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{4, 2}, null, null);
                    break;
                } else if (mAirComfort2 == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{4}, null, null);
                    break;
                }
            case R.id.wc_chga6_negativeioc_modeengineer /* 2131429128 */:
                int mNegativeIonMode = DataCanbus.DATA[3];
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[2];
                iArr3[0] = 22;
                iArr3[1] = mNegativeIonMode == 0 ? 1 : 0;
                remoteModuleProxy3.cmd(2, iArr3, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoCompressor() {
        int mAutoCompre = DataCanbus.DATA[0];
        ((CheckedTextView) findViewById(R.id.wc_gs4_air_set_auto_compressor_check)).setChecked(mAutoCompre != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoCycleState() {
        int mAutoCycle = DataCanbus.DATA[1];
        ((CheckedTextView) findViewById(R.id.wc_gs4_air_set_auto_cycle_state_check)).setChecked(mAutoCycle != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterNegativeIonMode() {
        int mNegativeIonMode = DataCanbus.DATA[3];
        ((CheckedTextView) findViewById(R.id.wc_chga6_negativeioc_modeengineer)).setChecked(mNegativeIonMode != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterComfort() {
        int mAirComfort = DataCanbus.DATA[2];
        if (mAirComfort == 0) {
            ((TextView) findViewById(R.id.wc_gs4_air_set_comfort_curve_TV)).setText(R.string.wc_gs4_air_set_comfort_slow);
        } else if (mAirComfort == 1) {
            ((TextView) findViewById(R.id.wc_gs4_air_set_comfort_curve_TV)).setText(R.string.wc_gs4_air_set_comfort_nomol);
        } else if (mAirComfort == 2) {
            ((TextView) findViewById(R.id.wc_gs4_air_set_comfort_curve_TV)).setText(R.string.wc_gs4_air_set_comfort_fast);
        }
    }
}
