package com.syu.carinfo.dongjian.ga6;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class GA6CarAccessoryAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dongjian.ga6.GA6CarAccessoryAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 8:
                    GA6CarAccessoryAct.this.updaterRomoteUnlock();
                    break;
                case 9:
                    GA6CarAccessoryAct.this.updaterSpeedLock();
                    break;
                case 10:
                    GA6CarAccessoryAct.this.updaterAutoUnlock();
                    break;
                case 11:
                    GA6CarAccessoryAct.this.updaterFrontWind();
                    break;
                case 12:
                    GA6CarAccessoryAct.this.updaterFrontYuGua();
                    break;
                case 15:
                    GA6CarAccessoryAct.this.mUpdaterValue3();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_257_dongjian_ga6_car_accessory);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                GA6Func.C_CAR_CARINFO_CMD(4, 1, DataCanbus.DATA[8] == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                GA6Func.C_CAR_CARINFO_CMD(4, 2, DataCanbus.DATA[9] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                GA6Func.C_CAR_CARINFO_CMD(4, 3, DataCanbus.DATA[10] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                GA6Func.C_CAR_CARINFO_CMD(4, 4, DataCanbus.DATA[11] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                GA6Func.C_CAR_CARINFO_CMD(4, 6, DataCanbus.DATA[12] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                GA6Func.C_CAR_CARINFO_CMD(4, 5, DataCanbus.DATA[15] != 0 ? 0 : 1);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue3() {
        int mAutoFoldOutMirrors = DataCanbus.DATA[15];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(mAutoFoldOutMirrors != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRomoteUnlock() {
        int mRomoteUnlockInt = DataCanbus.DATA[8];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(mRomoteUnlockInt != 0);
        if (mRomoteUnlockInt == 0) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_ruiteng_string_unlock_mode_0);
        } else if (mRomoteUnlockInt == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_ruiteng_string_unlock_mode_1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSpeedLock() {
        int mSpeedLockInt = DataCanbus.DATA[9];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(mSpeedLockInt != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoUnlock() {
        int mAutoLockInt = DataCanbus.DATA[10];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(mAutoLockInt != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFrontWind() {
        int mRomoteFrontWindInt = DataCanbus.DATA[11];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(mRomoteFrontWindInt != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFrontYuGua() {
        int mFrontYuGuaFixInt = DataCanbus.DATA[12];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(mFrontYuGuaFixInt != 0);
    }
}
