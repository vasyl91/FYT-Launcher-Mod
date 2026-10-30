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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class WCSuburuCarEQSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.WCSuburuCarEQSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    ((TextView) WCSuburuCarEQSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(val).toString());
                    break;
                case 99:
                    if (((TextView) WCSuburuCarEQSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (val % 128 != 0) {
                            ((TextView) WCSuburuCarEQSet.this.findViewById(R.id.tv_text2)).setText("L" + (256 - val));
                        } else if (val == 0) {
                            ((TextView) WCSuburuCarEQSet.this.findViewById(R.id.tv_text2)).setText("0");
                        } else {
                            ((TextView) WCSuburuCarEQSet.this.findViewById(R.id.tv_text2)).setText("R" + val);
                        }
                    }
                    break;
                case 100:
                    if (((TextView) WCSuburuCarEQSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (val % 128 != 0) {
                            ((TextView) WCSuburuCarEQSet.this.findViewById(R.id.tv_text3)).setText("F" + (256 - val));
                        } else if (val == 0) {
                            ((TextView) WCSuburuCarEQSet.this.findViewById(R.id.tv_text3)).setText("0");
                        } else {
                            ((TextView) WCSuburuCarEQSet.this.findViewById(R.id.tv_text3)).setText("R" + val);
                        }
                    }
                    break;
                case 101:
                    if (((TextView) WCSuburuCarEQSet.this.findViewById(R.id.tv_text4)) != null) {
                        if (val % 128 != 0) {
                            ((TextView) WCSuburuCarEQSet.this.findViewById(R.id.tv_text4)).setText("-" + (256 - val));
                        } else if (val == 0) {
                            ((TextView) WCSuburuCarEQSet.this.findViewById(R.id.tv_text4)).setText("0");
                        } else {
                            ((TextView) WCSuburuCarEQSet.this.findViewById(R.id.tv_text4)).setText("+" + val);
                        }
                    }
                    break;
                case 102:
                    if (((TextView) WCSuburuCarEQSet.this.findViewById(R.id.tv_text5)) != null) {
                        if (val % 128 != 0) {
                            ((TextView) WCSuburuCarEQSet.this.findViewById(R.id.tv_text5)).setText("-" + (256 - val));
                        } else if (val == 0) {
                            ((TextView) WCSuburuCarEQSet.this.findViewById(R.id.tv_text5)).setText("0");
                        } else {
                            ((TextView) WCSuburuCarEQSet.this.findViewById(R.id.tv_text5)).setText("+" + val);
                        }
                    }
                    break;
                case 103:
                    if (((TextView) WCSuburuCarEQSet.this.findViewById(R.id.tv_text6)) != null) {
                        if (val % 128 != 0) {
                            ((TextView) WCSuburuCarEQSet.this.findViewById(R.id.tv_text6)).setText("-" + (256 - val));
                        } else if (val == 0) {
                            ((TextView) WCSuburuCarEQSet.this.findViewById(R.id.tv_text6)).setText("0");
                        } else {
                            ((TextView) WCSuburuCarEQSet.this.findViewById(R.id.tv_text6)).setText("+" + val);
                        }
                    }
                    break;
                case 104:
                    WCSuburuCarEQSet.this.setCheck((CheckedTextView) WCSuburuCarEQSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 105:
                    WCSuburuCarEQSet.this.setCheck((CheckedTextView) WCSuburuCarEQSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0444_wc2_suburu_eq_settings);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
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
                setCarInfo(5, 255);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                setCarInfo(5, 1);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value = DataCanbus.DATA[105];
                setCarInfo(8, value != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value2 = DataCanbus.DATA[104];
                setCarInfo(7, value2 != 1 ? 1 : 0);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
    }
}
