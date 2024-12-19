package com.syu.carinfo.xincheng.infiniti;

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
public class Infiniti_XinCheng_EQSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xincheng.infiniti.Infiniti_XinCheng_EQSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 75:
                    if (((TextView) Infiniti_XinCheng_EQSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) Infiniti_XinCheng_EQSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 76:
                    if (((TextView) Infiniti_XinCheng_EQSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) Infiniti_XinCheng_EQSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 77:
                    if (((TextView) Infiniti_XinCheng_EQSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) Infiniti_XinCheng_EQSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 78:
                    if (((TextView) Infiniti_XinCheng_EQSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) Infiniti_XinCheng_EQSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 79:
                    if (((TextView) Infiniti_XinCheng_EQSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) Infiniti_XinCheng_EQSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 80:
                    if (((TextView) Infiniti_XinCheng_EQSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) Infiniti_XinCheng_EQSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 81:
                    Infiniti_XinCheng_EQSet.this.setCheck((CheckedTextView) Infiniti_XinCheng_EQSet.this.findViewById(R.id.ctv_checkedtext1), val == 144);
                    break;
                case 82:
                    if (((TextView) Infiniti_XinCheng_EQSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) Infiniti_XinCheng_EQSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 83:
                    Infiniti_XinCheng_EQSet.this.setCheck((CheckedTextView) Infiniti_XinCheng_EQSet.this.findViewById(R.id.ctv_checkedtext2), val == 144);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_xincheng_infiniti_eq_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
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
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int val = DataCanbus.DATA[81];
                if (val == 0) {
                    val = 1;
                } else if (val == 1) {
                    val = 0;
                }
                setCarInfo(39, val);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                setCarInfo(33, 49);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                setCarInfo(33, 33);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                setCarInfo(34, 49);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                setCarInfo(34, 33);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                setCarInfo(35, 49);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                setCarInfo(35, 33);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                setCarInfo(36, 49);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                setCarInfo(36, 33);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                setCarInfo(37, 49);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                setCarInfo(37, 33);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                setCarInfo(38, 49);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                setCarInfo(38, 33);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                setCarInfo(40, 49);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                setCarInfo(40, 33);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int val2 = DataCanbus.DATA[83];
                if (val2 == 0) {
                    val2 = 1;
                } else if (val2 == 1) {
                    val2 = 0;
                }
                setCarInfo(41, val2);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(4, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{147}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[75].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[79].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[80].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[81].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[82].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[83].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[75].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[78].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[79].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[81].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[82].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[83].removeNotify(this.mNotifyCanbus);
    }
}
