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
public class GS3LightSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.gs3.GS3LightSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 119:
                    GS3LightSetAct.this.updaterWithMeHome();
                    break;
                case 120:
                    GS3LightSetAct.this.updaterWudengHelp();
                    break;
                case 121:
                    GS3LightSetAct.this.updaterDayLight();
                    break;
                case 122:
                    GS3LightSetAct.this.updaterlightAsitly();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_289_wc_gs4_light_set);
        setUI();
    }

    private void setUI() {
        DataCanbus.PROXY.cmd(3, new int[]{10}, null, null);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427456 */:
                if (DataCanbus.DATA[119] == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{9, 2}, null, null);
                } else if (DataCanbus.DATA[119] == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{9, 0}, null, null);
                } else if (DataCanbus.DATA[119] == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{9, 1}, null, null);
                }
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                if (DataCanbus.DATA[119] == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{9, 1}, null, null);
                } else if (DataCanbus.DATA[119] == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{9, 2}, null, null);
                } else if (DataCanbus.DATA[119] == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{9, 0}, null, null);
                }
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                if (DataCanbus.DATA[122] == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{18, 2}, null, null);
                } else if (DataCanbus.DATA[122] == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{18, 3}, null, null);
                } else if (DataCanbus.DATA[122] == 3) {
                    DataCanbus.PROXY.cmd(2, new int[]{18, 1}, null, null);
                }
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                if (DataCanbus.DATA[122] == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{18, 3}, null, null);
                } else if (DataCanbus.DATA[122] == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{18, 1}, null, null);
                } else if (DataCanbus.DATA[122] == 3) {
                    DataCanbus.PROXY.cmd(2, new int[]{18, 2}, null, null);
                }
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 13;
                iArr[1] = DataCanbus.DATA[120] == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 15;
                iArr2[1] = DataCanbus.DATA[121] == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(2, iArr2, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterWithMeHome() {
        int mWithMeHomeInt = DataCanbus.DATA[119];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            if (mWithMeHomeInt == 0) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.off);
            } else if (mWithMeHomeInt == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_gs4_only_near_light);
            } else if (mWithMeHomeInt == 2) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_gs4_near_light_forgost);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterWudengHelp() {
        int mWuDengHelpInt = DataCanbus.DATA[120];
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext1), mWuDengHelpInt != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterDayLight() {
        int mDayLightInt = DataCanbus.DATA[121];
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext3), mDayLightInt != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterlightAsitly() {
        int mLightAsistyInt = DataCanbus.DATA[122];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (mLightAsistyInt == 3) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_air_low);
            } else if (mLightAsistyInt == 2) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_air_middle);
            } else if (mLightAsistyInt == 1) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_air_high);
            }
        }
    }
}
