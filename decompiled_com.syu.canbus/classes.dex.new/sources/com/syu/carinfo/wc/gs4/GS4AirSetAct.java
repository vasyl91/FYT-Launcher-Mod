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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class GS4AirSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.gs4.GS4AirSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    GS4AirSetAct.this.updaterAutoCompressor();
                    break;
                case 99:
                    GS4AirSetAct.this.updaterAutoCycleState();
                    break;
                case 100:
                    GS4AirSetAct.this.updaterComfort();
                    break;
                case 101:
                    GS4AirSetAct.this.updaterNegativeIonMode();
                    break;
                case 144:
                    ((CheckedTextView) GS4AirSetAct.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
                    break;
                case 145:
                    if (value == 0) {
                        ((TextView) GS4AirSetAct.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_low);
                    } else if (value == 1) {
                        ((TextView) GS4AirSetAct.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_middle);
                    } else if (value == 2) {
                        ((TextView) GS4AirSetAct.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_high);
                    }
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
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427456 */:
                int mAirComfort = DataCanbus.DATA[100];
                if (mAirComfort == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{4, 2}, null, null);
                } else if (mAirComfort == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{4, 0}, null, null);
                } else if (mAirComfort == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{4, 1}, null, null);
                }
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int mAirComfort2 = DataCanbus.DATA[100];
                if (mAirComfort2 == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{4, 1}, null, null);
                } else if (mAirComfort2 == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{4, 2}, null, null);
                } else if (mAirComfort2 == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{4, 0}, null, null);
                }
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value = DataCanbus.DATA[145];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{31, 2}, null, null);
                } else if (value == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{31, 0}, null, null);
                } else if (value == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{31, 1}, null, null);
                }
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value2 = DataCanbus.DATA[145];
                if (value2 == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{31, 1}, null, null);
                } else if (value2 == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{31, 2}, null, null);
                } else if (value2 == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{31, 0}, null, null);
                }
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int mAutoCompre = DataCanbus.DATA[98];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 2;
                iArr[1] = mAutoCompre == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int mNegativeIonMode = DataCanbus.DATA[101];
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 22;
                iArr2[1] = mNegativeIonMode == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(2, iArr2, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int mAutoCycle = DataCanbus.DATA[99];
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[2];
                iArr3[0] = 3;
                iArr3[1] = mAutoCycle == 0 ? 1 : 0;
                remoteModuleProxy3.cmd(2, iArr3, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int value3 = DataCanbus.DATA[144];
                RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                int[] iArr4 = new int[2];
                iArr4[0] = 30;
                iArr4[1] = value3 == 0 ? 1 : 0;
                remoteModuleProxy4.cmd(2, iArr4, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoCompressor() {
        int mAutoCompre = DataCanbus.DATA[98];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(mAutoCompre != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoCycleState() {
        int mAutoCycle = DataCanbus.DATA[99];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(mAutoCycle != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterNegativeIonMode() {
        int mNegativeIonMode = DataCanbus.DATA[101];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(mNegativeIonMode != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterComfort() {
        int mAirComfort = DataCanbus.DATA[100];
        if (mAirComfort == 0) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_gs4_air_set_comfort_slow);
        } else if (mAirComfort == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_gs4_air_set_comfort_nomol);
        } else if (mAirComfort == 2) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_gs4_air_set_comfort_fast);
        }
    }
}
