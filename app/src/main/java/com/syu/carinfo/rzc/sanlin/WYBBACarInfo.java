package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class WYBBACarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.WYBBACarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 36:
                    ((TextView) WYBBACarInfo.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                    break;
                case 37:
                    switch (value) {
                        case 0:
                            ((TextView) WYBBACarInfo.this.findViewById(R.id.tv_text3)).setText(R.string.str_original_car_mode);
                            break;
                        case 1:
                            ((TextView) WYBBACarInfo.this.findViewById(R.id.tv_text3)).setText(R.string.str_installation_mode);
                            break;
                    }
                case 38:
                    ((CheckedTextView) WYBBACarInfo.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                    break;
                case 39:
                    ((CheckedTextView) WYBBACarInfo.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wy_bba_all_carinfo);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value4 = DataCanbus.DATA[38];
                if (value4 == 1) {
                    value3 = 0;
                } else {
                    value3 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{2, value3}, null, null);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value5 = DataCanbus.DATA[36];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(value5);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value6 = DataCanbus.DATA[36];
                if (value6 < 15) {
                    value6++;
                }
                setCarInfo(value6);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
            case R.id.btn_plus2 /* 2131427486 */:
                int value7 = DataCanbus.DATA[37];
                if (value7 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{1, value}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value8 = DataCanbus.DATA[39];
                if (value8 == 1) {
                    value2 = 0;
                } else {
                    value2 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{3, value2}, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                DataCanbus.PROXY.cmd(3, new int[]{1}, null, null);
                break;
        }
    }

    public void setCarInfo(int value0) {
        DataCanbus.PROXY.cmd(0, new int[]{value0}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
    }
}
