package com.syu.carinfo.wc.leinuo;

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
public class Megane4HandUpSetActi extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.leinuo.Megane4HandUpSetActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 168:
                    Megane4HandUpSetActi.this.setCheck((CheckedTextView) Megane4HandUpSetActi.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 169:
                    Megane4HandUpSetActi.this.setCheck((CheckedTextView) Megane4HandUpSetActi.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 170:
                    if (((TextView) Megane4HandUpSetActi.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) Megane4HandUpSetActi.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value * 5).toString());
                    }
                    break;
                case 171:
                    if (((TextView) Megane4HandUpSetActi.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) Megane4HandUpSetActi.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value * 5).toString());
                    }
                    break;
                case 172:
                    if (((TextView) Megane4HandUpSetActi.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) Megane4HandUpSetActi.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0352_wc_magane_handup_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus3 /* 2131427462 */:
                int value = DataCanbus.DATA[170];
                if (value > 0) {
                    value--;
                }
                setCarInfo(84, value, 0, 0);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value2 = DataCanbus.DATA[170];
                if (value2 < 20) {
                    value2++;
                }
                setCarInfo(84, value2, 0, 0);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value3 = DataCanbus.DATA[171];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(85, value3, 0, 0);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value4 = DataCanbus.DATA[171];
                if (value4 < 20) {
                    value4++;
                }
                setCarInfo(85, value4, 0, 0);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value5 = DataCanbus.DATA[172];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(86, value5, 0, 0);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value6 = DataCanbus.DATA[172];
                if (value6 < 50) {
                    value6++;
                }
                setCarInfo(86, value6, 0, 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                int value7 = DataCanbus.DATA[168];
                if (value7 == 0) {
                    value7 = 1;
                } else if (value7 == 1) {
                    value7 = 0;
                }
                setCarInfo(82, value7, 0, 0);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                int value8 = DataCanbus.DATA[169];
                if (value8 == 0) {
                    value8 = 1;
                } else if (value8 == 1) {
                    value8 = 0;
                }
                setCarInfo(83, value8, 0, 0);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1, value2, value3}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
    }
}
