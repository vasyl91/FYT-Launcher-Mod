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
public class Megane4AirSetActi extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.leinuo.Megane4AirSetActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 151:
                    Megane4AirSetActi.this.setCheck((CheckedTextView) Megane4AirSetActi.this.findViewById(R.id.ctv_checkedtext27), value == 1);
                    break;
                case 152:
                    Megane4AirSetActi.this.setCheck((CheckedTextView) Megane4AirSetActi.this.findViewById(R.id.ctv_checkedtext28), value == 1);
                    break;
                case 191:
                    if (((TextView) Megane4AirSetActi.this.findViewById(R.id.tv_text20)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Megane4AirSetActi.this.findViewById(R.id.tv_text20)).setText(R.string.rzc_zhenglizi_str);
                                break;
                            case 2:
                                ((TextView) Megane4AirSetActi.this.findViewById(R.id.tv_text20)).setText(R.string.rzc_fulizi_str);
                                break;
                            default:
                                ((TextView) Megane4AirSetActi.this.findViewById(R.id.tv_text20)).setText(R.string.off);
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
        setContentView(R.layout.layout_0352_wc_magane_air_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext27), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext28), this);
        setSelfClick((Button) findViewById(R.id.btn_minus20), this);
        setSelfClick((Button) findViewById(R.id.btn_plus20), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus20 /* 2131427597 */:
                int value = DataCanbus.DATA[191] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(89, value, 0, 0);
                break;
            case R.id.btn_plus20 /* 2131427599 */:
                int value2 = DataCanbus.DATA[191] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(89, value2, 0, 0);
                break;
            case R.id.ctv_checkedtext27 /* 2131427825 */:
                int value3 = DataCanbus.DATA[151];
                if (value3 == 0) {
                    value3 = 1;
                } else if (value3 == 1) {
                    value3 = 0;
                }
                setCarInfo(45, value3, 0, 0);
                break;
            case R.id.ctv_checkedtext28 /* 2131427826 */:
                int value4 = DataCanbus.DATA[152];
                if (value4 == 0) {
                    value4 = 1;
                } else if (value4 == 1) {
                    value4 = 0;
                }
                setCarInfo(46, value4, 0, 0);
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
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
    }
}
