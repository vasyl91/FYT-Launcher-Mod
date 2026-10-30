package com.syu.carinfo.wc.gs4;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class GS4CarAccessoryAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.gs4.GS4CarAccessoryAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 111:
                    GS4CarAccessoryAct.this.updaterRomoteUnlock();
                    break;
                case 112:
                    GS4CarAccessoryAct.this.updaterSpeedLock();
                    break;
                case 113:
                    GS4CarAccessoryAct.this.updaterAutoUnlock();
                    break;
                case 114:
                    GS4CarAccessoryAct.this.updaterFrontWind();
                    break;
                case 115:
                    GS4CarAccessoryAct.this.updaterFrontYuGua();
                    break;
                case 116:
                    GS4CarAccessoryAct.this.updaterRearYuGua();
                    break;
                case 117:
                    GS4CarAccessoryAct.this.updaterAutoFoldOutSideMirrors();
                    break;
                case 122:
                    GS4CarAccessoryAct.this.updaterUnlockWhistleTone();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_289_wc_gs4_car_accessory);
        setUI();
    }

    private void setUI() {
        if (DataCanbus.DATA[1000] == 262433) {
            findViewById(R.id.layout_view7).setVisibility(0);
        } else {
            findViewById(R.id.layout_view7).setVisibility(8);
        }
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int mSpeedLockInt = DataCanbus.DATA[112];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 13;
                iArr[1] = mSpeedLockInt == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int mFrontYuGuaFixInt = DataCanbus.DATA[115];
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 16;
                iArr2[1] = mFrontYuGuaFixInt == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(2, iArr2, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int mRearYuGuaInt = DataCanbus.DATA[116];
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[2];
                iArr3[0] = 17;
                iArr3[1] = mRearYuGuaInt == 0 ? 1 : 0;
                remoteModuleProxy3.cmd(2, iArr3, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int mAutoLockInt = DataCanbus.DATA[113];
                RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                int[] iArr4 = new int[2];
                iArr4[0] = 14;
                iArr4[1] = mAutoLockInt == 0 ? 1 : 0;
                remoteModuleProxy4.cmd(2, iArr4, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int mRomoteFrontWindInt = DataCanbus.DATA[114];
                RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                int[] iArr5 = new int[2];
                iArr5[0] = 15;
                iArr5[1] = mRomoteFrontWindInt == 0 ? 1 : 0;
                remoteModuleProxy5.cmd(2, iArr5, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int mAutoFoldOutSideMirrors = DataCanbus.DATA[117];
                RemoteModuleProxy remoteModuleProxy6 = DataCanbus.PROXY;
                int[] iArr6 = new int[2];
                iArr6[0] = 25;
                iArr6[1] = mAutoFoldOutSideMirrors == 0 ? 1 : 0;
                remoteModuleProxy6.cmd(2, iArr6, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                int mUnlockWhistleTone = DataCanbus.DATA[122];
                RemoteModuleProxy remoteModuleProxy7 = DataCanbus.PROXY;
                int[] iArr7 = new int[2];
                iArr7[0] = 26;
                iArr7[1] = mUnlockWhistleTone == 0 ? 1 : 0;
                remoteModuleProxy7.cmd(2, iArr7, null, null);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                int mRomoteUnlockInt = DataCanbus.DATA[111];
                RemoteModuleProxy remoteModuleProxy8 = DataCanbus.PROXY;
                int[] iArr8 = new int[2];
                iArr8[0] = 12;
                iArr8[1] = mRomoteUnlockInt == 0 ? 1 : 0;
                remoteModuleProxy8.cmd(2, iArr8, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterUnlockWhistleTone() {
        int mUnlockWhistleTone = DataCanbus.DATA[122];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(mUnlockWhistleTone != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRomoteUnlock() {
        int mRomoteUnlockInt = DataCanbus.DATA[111];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(mRomoteUnlockInt != 0);
        if (mRomoteUnlockInt == 0) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.wc_ruiteng_string_unlock_mode_0);
        } else if (mRomoteUnlockInt == 1) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.wc_ruiteng_string_unlock_mode_1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSpeedLock() {
        int mSpeedLockInt = DataCanbus.DATA[112];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(mSpeedLockInt != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoUnlock() {
        int mAutoLockInt = DataCanbus.DATA[113];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(mAutoLockInt != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFrontWind() {
        int mRomoteFrontWindInt = DataCanbus.DATA[114];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(mRomoteFrontWindInt != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFrontYuGua() {
        int mFrontYuGuaFixInt = DataCanbus.DATA[115];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(mFrontYuGuaFixInt != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRearYuGua() {
        int mRearYuGuaInt = DataCanbus.DATA[116];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(mRearYuGuaInt != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoFoldOutSideMirrors() {
        int mAutoFoldOutSideMirrors = DataCanbus.DATA[117];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(mAutoFoldOutSideMirrors != 0);
    }
}
