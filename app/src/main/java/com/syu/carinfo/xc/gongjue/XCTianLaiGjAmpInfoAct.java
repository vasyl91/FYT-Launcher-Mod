package com.syu.carinfo.xc.gongjue;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XCTianLaiGjAmpInfoAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xc.gongjue.XCTianLaiGjAmpInfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 37:
                    if (((TextView) XCTianLaiGjAmpInfoAct.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) XCTianLaiGjAmpInfoAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 38:
                    if (((TextView) XCTianLaiGjAmpInfoAct.this.findViewById(R.id.tv_text2)) != null) {
                        if (val > 250) {
                            ((TextView) XCTianLaiGjAmpInfoAct.this.findViewById(R.id.tv_text2)).setText("L" + Math.abs(val - 256));
                            break;
                        } else {
                            ((TextView) XCTianLaiGjAmpInfoAct.this.findViewById(R.id.tv_text2)).setText(val == 0 ? new StringBuilder().append(val).toString() : "R" + val);
                            break;
                        }
                    }
                    break;
                case 39:
                    if (((TextView) XCTianLaiGjAmpInfoAct.this.findViewById(R.id.tv_text3)) != null) {
                        if (val > 250) {
                            ((TextView) XCTianLaiGjAmpInfoAct.this.findViewById(R.id.tv_text3)).setText("R" + Math.abs(val - 256));
                            break;
                        } else {
                            ((TextView) XCTianLaiGjAmpInfoAct.this.findViewById(R.id.tv_text3)).setText(val == 0 ? new StringBuilder().append(val).toString() : "F" + val);
                            break;
                        }
                    }
                    break;
                case 40:
                    if (((TextView) XCTianLaiGjAmpInfoAct.this.findViewById(R.id.tv_text4)) != null) {
                        if (val > 250) {
                            ((TextView) XCTianLaiGjAmpInfoAct.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(val - 256).toString());
                            break;
                        } else {
                            ((TextView) XCTianLaiGjAmpInfoAct.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(val).toString());
                            break;
                        }
                    }
                    break;
                case 41:
                    if (((TextView) XCTianLaiGjAmpInfoAct.this.findViewById(R.id.tv_text5)) != null) {
                        if (val > 250) {
                            ((TextView) XCTianLaiGjAmpInfoAct.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(val - 256).toString());
                            break;
                        } else {
                            ((TextView) XCTianLaiGjAmpInfoAct.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(val).toString());
                            break;
                        }
                    }
                    break;
                case 42:
                    if (((TextView) XCTianLaiGjAmpInfoAct.this.findViewById(R.id.tv_text6)) != null) {
                        if (val > 250) {
                            ((TextView) XCTianLaiGjAmpInfoAct.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(val - 256).toString());
                            break;
                        } else {
                            ((TextView) XCTianLaiGjAmpInfoAct.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(val).toString());
                            break;
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_xc_tianlai_gj_amp_info);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int data = 0;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427480 */:
                data = 2;
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                data = 1;
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                data = 6;
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                data = 7;
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                data = 10;
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                data = 9;
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                data = 4;
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                data = 3;
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                data = 12;
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                data = 11;
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                data = 6;
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                data = 5;
                break;
        }
        cmd(data);
    }

    private void cmd(int data0) {
        DataCanbus.PROXY.cmd(0, new int[]{data0}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
    }
}
