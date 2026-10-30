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
public class GS4LightSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.gs4.GS4LightSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 118:
                    GS4LightSetAct.this.updaterWithMeHome();
                    break;
                case 119:
                    GS4LightSetAct.this.updaterWudengHelp();
                    break;
                case 120:
                    GS4LightSetAct.this.updaterDayLight();
                    break;
                case 121:
                    GS4LightSetAct.this.updaterlightAsitly();
                    break;
                case 127:
                    GS4LightSetAct.this.updaterAtmosphereLight();
                    break;
                case 146:
                    ((CheckedTextView) GS4LightSetAct.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
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
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427456 */:
                int mWithMeHomeInt = DataCanbus.DATA[118];
                if (mWithMeHomeInt == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{18, 2}, null, null);
                } else if (mWithMeHomeInt == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{18, 0}, null, null);
                } else if (mWithMeHomeInt == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{18, 1}, null, null);
                }
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int mWithMeHomeInt2 = DataCanbus.DATA[118];
                if (mWithMeHomeInt2 == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{18, 1}, null, null);
                } else if (mWithMeHomeInt2 == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{18, 2}, null, null);
                } else if (mWithMeHomeInt2 == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{18, 0}, null, null);
                }
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int mLightAsistyInt = DataCanbus.DATA[121];
                if (mLightAsistyInt == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{21, 2}, null, null);
                } else if (mLightAsistyInt == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{21, 0}, null, null);
                } else if (mLightAsistyInt == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{21, 1}, null, null);
                }
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int mLightAsistyInt2 = DataCanbus.DATA[121];
                if (mLightAsistyInt2 == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{21, 1}, null, null);
                } else if (mLightAsistyInt2 == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{21, 2}, null, null);
                } else if (mLightAsistyInt2 == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{21, 0}, null, null);
                }
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int mWuDengHelpInt = DataCanbus.DATA[119];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 19;
                iArr[1] = mWuDengHelpInt == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int value = DataCanbus.DATA[146];
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 32;
                iArr2[1] = value == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(2, iArr2, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value2 = DataCanbus.DATA[127];
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[2];
                iArr3[0] = 27;
                iArr3[1] = value2 == 0 ? 1 : 0;
                remoteModuleProxy3.cmd(2, iArr3, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int mDayLightInt = DataCanbus.DATA[120];
                RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                int[] iArr4 = new int[2];
                iArr4[0] = 20;
                iArr4[1] = mDayLightInt == 0 ? 1 : 0;
                remoteModuleProxy4.cmd(2, iArr4, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterWithMeHome() {
        int mWithMeHomeInt = DataCanbus.DATA[118];
        if (mWithMeHomeInt == 0) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.off);
        } else if (mWithMeHomeInt == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_gs4_only_near_light);
        } else if (mWithMeHomeInt == 2) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_gs4_near_light_forgost);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAtmosphereLight() {
        int value = DataCanbus.DATA[127];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterWudengHelp() {
        int mWuDengHelpInt = DataCanbus.DATA[119];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(mWuDengHelpInt != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterDayLight() {
        int mDayLightInt = DataCanbus.DATA[120];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(mDayLightInt != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterlightAsitly() {
        int mLightAsistyInt = DataCanbus.DATA[121];
        if (mLightAsistyInt == 0) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_air_low);
        } else if (mLightAsistyInt == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_air_middle);
        } else if (mLightAsistyInt == 2) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_air_high);
        }
    }
}
