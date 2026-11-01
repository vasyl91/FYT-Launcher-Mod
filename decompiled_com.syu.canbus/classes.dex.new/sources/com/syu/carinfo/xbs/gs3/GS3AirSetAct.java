package com.syu.carinfo.xbs.gs3;

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
public class GS3AirSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.gs3.GS3AirSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    GS3AirSetAct.this.updaterAutoCompressor();
                    break;
                case 99:
                    GS3AirSetAct.this.updaterAutoCycleState();
                    break;
                case 100:
                    GS3AirSetAct.this.updaterComfort();
                    break;
                case 101:
                    GS3AirSetAct.this.updaterAnionMode();
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
        DataCanbus.PROXY.cmd(3, new int[]{8}, null, null);
        setViewVisible(findViewById(R.id.layout_view9), true);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427456 */:
                if (DataCanbus.DATA[100] == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{1, 2}, null, null);
                } else if (DataCanbus.DATA[100] == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{1, 0}, null, null);
                } else if (DataCanbus.DATA[100] == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{1, 1}, null, null);
                }
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                if (DataCanbus.DATA[100] == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{1, 1}, null, null);
                } else if (DataCanbus.DATA[100] == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{1, 2}, null, null);
                } else if (DataCanbus.DATA[100] == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{1, 0}, null, null);
                }
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 3;
                iArr[1] = DataCanbus.DATA[98] == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 2;
                iArr2[1] = DataCanbus.DATA[99] == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(2, iArr2, null, null);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[2];
                iArr3[0] = 21;
                iArr3[1] = DataCanbus.DATA[101] == 0 ? 1 : 0;
                remoteModuleProxy3.cmd(2, iArr3, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoCompressor() {
        int mAutoCompre = DataCanbus.DATA[98];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(mAutoCompre == 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAnionMode() {
        int mAnionMode = DataCanbus.DATA[101];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(mAnionMode != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoCycleState() {
        int mAutoCycle = DataCanbus.DATA[99];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(mAutoCycle == 0);
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
