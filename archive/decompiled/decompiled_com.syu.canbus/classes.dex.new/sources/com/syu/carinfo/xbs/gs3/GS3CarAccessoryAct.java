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
public class GS3CarAccessoryAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.gs3.GS3CarAccessoryAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 111:
                    GS3CarAccessoryAct.this.updaterRomoteUnlock();
                    break;
                case 112:
                    GS3CarAccessoryAct.this.updaterSpeedLock();
                    break;
                case 113:
                    GS3CarAccessoryAct.this.updaterAutoUnlock();
                    break;
                case 114:
                    GS3CarAccessoryAct.this.updaterFrontWind();
                    break;
                case 115:
                    GS3CarAccessoryAct.this.updaterFrontYuGua();
                    break;
                case 116:
                    GS3CarAccessoryAct.this.updaterRearYuGua();
                    break;
                case 117:
                    GS3CarAccessoryAct.this.updaterLanguage();
                    break;
                case 118:
                    GS3CarAccessoryAct.this.updaterGuangXiaoQi();
                    break;
                case 123:
                    GS3CarAccessoryAct.this.updaterUnlockVol();
                    break;
                case 124:
                    GS3CarAccessoryAct.this.updaterAutoRear();
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
        DataCanbus.PROXY.cmd(3, new int[]{6}, null, null);
        setViewVisible(findViewById(R.id.layout_view6), false);
        if (DataCanbus.DATA[1000] == 196773 || DataCanbus.DATA[1000] == 131237) {
            setViewVisible(findViewById(R.id.layout_view8), true);
            setViewVisible(findViewById(R.id.layout_view11), true);
            setViewVisible(findViewById(R.id.layout_view9), true);
            setViewVisible(findViewById(R.id.layout_view10), true);
        }
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427456 */:
            case R.id.btn_plus1 /* 2131427458 */:
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 27;
                iArr[1] = DataCanbus.DATA[117] == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
            case R.id.btn_plus2 /* 2131427461 */:
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 28;
                iArr2[1] = DataCanbus.DATA[118] == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(2, iArr2, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[2];
                iArr3[0] = 11;
                iArr3[1] = DataCanbus.DATA[112] == 0 ? 1 : 0;
                remoteModuleProxy3.cmd(2, iArr3, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                int[] iArr4 = new int[2];
                iArr4[0] = 17;
                iArr4[1] = DataCanbus.DATA[115] == 0 ? 1 : 0;
                remoteModuleProxy4.cmd(2, iArr4, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                int[] iArr5 = new int[2];
                iArr5[0] = 16;
                iArr5[1] = DataCanbus.DATA[116] == 0 ? 1 : 0;
                remoteModuleProxy5.cmd(2, iArr5, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                RemoteModuleProxy remoteModuleProxy6 = DataCanbus.PROXY;
                int[] iArr6 = new int[2];
                iArr6[0] = 10;
                iArr6[1] = DataCanbus.DATA[113] == 0 ? 1 : 0;
                remoteModuleProxy6.cmd(2, iArr6, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                RemoteModuleProxy remoteModuleProxy7 = DataCanbus.PROXY;
                int[] iArr7 = new int[2];
                iArr7[0] = 14;
                iArr7[1] = DataCanbus.DATA[114] == 0 ? 1 : 0;
                remoteModuleProxy7.cmd(2, iArr7, null, null);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                RemoteModuleProxy remoteModuleProxy8 = DataCanbus.PROXY;
                int[] iArr8 = new int[2];
                iArr8[0] = 26;
                iArr8[1] = DataCanbus.DATA[124] == 0 ? 1 : 0;
                remoteModuleProxy8.cmd(2, iArr8, null, null);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                RemoteModuleProxy remoteModuleProxy9 = DataCanbus.PROXY;
                int[] iArr9 = new int[2];
                iArr9[0] = 25;
                iArr9[1] = DataCanbus.DATA[123] == 0 ? 1 : 0;
                remoteModuleProxy9.cmd(2, iArr9, null, null);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                RemoteModuleProxy remoteModuleProxy10 = DataCanbus.PROXY;
                int[] iArr10 = new int[2];
                iArr10[0] = 12;
                iArr10[1] = DataCanbus.DATA[111] == 0 ? 1 : 0;
                remoteModuleProxy10.cmd(2, iArr10, null, null);
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
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
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
    public void updaterUnlockVol() {
        int mUnlockVol = DataCanbus.DATA[123];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(mUnlockVol != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoRear() {
        int mAutoRear = DataCanbus.DATA[124];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(mAutoRear != 0);
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
    public void updaterLanguage() {
        int mLanguage = DataCanbus.DATA[117];
        if (mLanguage == 0) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.jeep_language_set1);
        } else if (mLanguage == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.jeep_language_set0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterGuangXiaoQi() {
        int mGuangXiaoQi = DataCanbus.DATA[118];
        if (mGuangXiaoQi == 0) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_165_guagnxiaoqi0);
        } else if (mGuangXiaoQi == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_165_guagnxiaoqi1);
        }
    }
}
