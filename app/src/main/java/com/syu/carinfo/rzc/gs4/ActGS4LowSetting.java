package com.syu.carinfo.rzc.gs4;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActGS4LowSetting extends BaseActivity implements View.OnClickListener {
    boolean mLanguage;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.gs4.ActGS4LowSetting.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 0:
                    ActGS4LowSetting.this.mUpdaterGS4Settings();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_rzc_gs4_low_setting);
        ((CheckedTextView) findViewById(R.id.ctv_gs4_setting_language)).setOnClickListener(this);
    }

    public static void C_CAR_CMD(int cmd, int value) {
        DataCanbus.PROXY.cmd(0, new int[]{((cmd & 255) << 8) | (value + 1)}, null, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_gs4_setting_language /* 2131432756 */:
                C_CAR_CMD(1, !this.mLanguage ? 0 : 1);
                break;
        }
    }

    private void updateLaguageState(int data) {
        String str = getString(R.string.rzc_others_language_setting_0);
        if (data == 1) {
            str = getString(R.string.rzc_others_language_setting_1);
        }
        ((TextView) findViewById(R.id.tv_gs4_language)).setText(str);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterGS4Settings() {
        int value = DataCanbus.DATA[0];
        byte data0 = (byte) ((value >> 8) & 255);
        byte data1 = (byte) (value & 255);
        switch (data0) {
            case 1:
                this.mLanguage = data1 == 1;
                updateLaguageState(data1);
                break;
        }
    }
}
