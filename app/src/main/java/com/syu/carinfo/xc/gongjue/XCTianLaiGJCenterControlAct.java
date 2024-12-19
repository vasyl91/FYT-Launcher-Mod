package com.syu.carinfo.xc.gongjue;

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
public class XCTianLaiGJCenterControlAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xc.gongjue.XCTianLaiGJCenterControlAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 25:
                    XCTianLaiGJCenterControlAct.this.setCheck((CheckedTextView) XCTianLaiGJCenterControlAct.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 26:
                    ((TextView) XCTianLaiGJCenterControlAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(val)).toString());
                    break;
                case 27:
                    XCTianLaiGJCenterControlAct.this.setCheck((CheckedTextView) XCTianLaiGJCenterControlAct.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 28:
                    XCTianLaiGJCenterControlAct.this.setCheck((CheckedTextView) XCTianLaiGJCenterControlAct.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 29:
                    XCTianLaiGJCenterControlAct.this.updateHeadLightOffDelay(val);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_xc_tianlai_gj_center_control);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[25] + 1;
                if (value > 1) {
                    value = 0;
                }
                cmd(2, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[26] - 1;
                if (value2 >= 0) {
                    cmd(3, value2);
                    break;
                }
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[26] + 1;
                if (value3 <= 7) {
                    cmd(3, value3);
                    break;
                }
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[29] - 1;
                if (value4 >= 0) {
                    cmd(4, value4);
                    break;
                }
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[29];
                if (value5 <= 7) {
                    cmd(4, value5);
                    break;
                }
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value6 = DataCanbus.DATA[27] + 1;
                if (value6 > 1) {
                    value6 = 0;
                }
                cmd(5, value6);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value7 = DataCanbus.DATA[28] + 1;
                if (value7 > 1) {
                    value7 = 0;
                }
                cmd(7, value7);
                break;
        }
    }

    private void cmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(0, new int[]{data0, data1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHeadLightOffDelay(int value) {
        int second = 0;
        switch (value) {
            case 1:
                second = 30;
                break;
            case 2:
                second = 45;
                break;
            case 3:
                second = 60;
                break;
            case 4:
                second = 90;
                break;
            case 5:
                second = 120;
                break;
            case 6:
                second = 150;
                break;
            case 7:
                second = 180;
                break;
        }
        ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(second) + "s");
    }
}
