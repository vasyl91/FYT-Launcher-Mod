package com.syu.carinfo.wc.infeinidi;

import android.content.Intent;
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
public class WcInfeinidiEQSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.infeinidi.WcInfeinidiEQSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 145:
                    WcInfeinidiEQSet.this.updateText1(val);
                    break;
                case 146:
                    WcInfeinidiEQSet.this.updateText2(val);
                    break;
                case 147:
                    WcInfeinidiEQSet.this.updateText3(val);
                    break;
                case 148:
                    WcInfeinidiEQSet.this.updateText4(val);
                    break;
                case 149:
                    WcInfeinidiEQSet.this.updateText5(val);
                    break;
                case 150:
                    WcInfeinidiEQSet.this.updateText6(val);
                    break;
                case 151:
                    WcInfeinidiEQSet.this.setCheck((CheckedTextView) WcInfeinidiEQSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 152:
                    WcInfeinidiEQSet.this.setCheck((CheckedTextView) WcInfeinidiEQSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 153:
                    WcInfeinidiEQSet.this.updateText7(val);
                    break;
                case 154:
                    WcInfeinidiEQSet.this.updateText8(val);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc_infeinidi_eq_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        if (DataCanbus.DATA[1000] == 7209403) {
            findViewById(R.id.layout_view1).setVisibility(8);
        } else {
            findViewById(R.id.layout_view1).setVisibility(0);
        }
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
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
        setSelfClick((Button) findViewById(R.id.btn_minus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                setCarInfo(1, 255);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                setCarInfo(1, 1);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                setCarInfo(2, 255);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                setCarInfo(2, 1);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                setCarInfo(3, 255);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                setCarInfo(3, 1);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                setCarInfo(4, 255);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                setCarInfo(4, 1);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                setCarInfo(5, 255);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                setCarInfo(5, 1);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                setCarInfo(6, 255);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                setCarInfo(6, 1);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                setCarInfo(7, 255);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                setCarInfo(7, 1);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                setCarInfo(8, 255);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                setCarInfo(8, 1);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value = DataCanbus.DATA[151];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(10, value);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value2 = DataCanbus.DATA[152];
                if (value2 == 1) {
                    value2 = 0;
                } else if (value2 == 0) {
                    value2 = 1;
                }
                setCarInfo(9, value2);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                try {
                    startActivity(new Intent(this, (Class<?>) WcInfinitCarInfo.class));
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(5, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText8(int value) {
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            ((TextView) findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText7(int value) {
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            ((TextView) findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText6(int value) {
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            ((TextView) findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText5(int value) {
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            ((TextView) findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText4(int value) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            ((TextView) findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText3(int value) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText2(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText1(int value) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
        }
    }
}
