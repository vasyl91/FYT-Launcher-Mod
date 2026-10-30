package com.syu.carinfo.rzc.baojun;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ODFotonTOANOSetFunc extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.baojun.ODFotonTOANOSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 102:
                    ODFotonTOANOSetFunc.this.setCheck((CheckedTextView) ODFotonTOANOSetFunc.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 103:
                    switch (value) {
                        case 1:
                            ((TextView) ODFotonTOANOSetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
                            break;
                        default:
                            ((TextView) ODFotonTOANOSetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_low);
                            break;
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_0454_od_foton_toano);
        setupView();
    }

    private void setupView() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[103] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(2, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[103] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(2, value2);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value3 = DataCanbus.DATA[102];
                if (value3 == 0) {
                    value3 = 1;
                } else if (value3 == 1) {
                    value3 = 0;
                }
                setCarInfo(1, value3);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(3, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{65}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
    }
}
