package com.syu.carinfo.mzd.cx5;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ActivityHaiMaSettings extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.mzd.cx5.ActivityHaiMaSettings.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 120:
                    if (((CheckedTextView) ActivityHaiMaSettings.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) ActivityHaiMaSettings.this.findViewById(R.id.ctv_checkedtext1)).setChecked(val == 1);
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_237_setting);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value2 = DataCanbus.DATA[120];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                setCarInfo(1, value);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, value1, value2);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
    }
}
