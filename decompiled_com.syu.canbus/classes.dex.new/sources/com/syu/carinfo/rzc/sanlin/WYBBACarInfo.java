package com.syu.carinfo.rzc.sanlin;

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
public class WYBBACarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.WYBBACarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 112:
                    ((TextView) WYBBACarInfo.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                    break;
                case 113:
                    switch (value) {
                        case 0:
                            ((TextView) WYBBACarInfo.this.findViewById(R.id.tv_text3)).setText(R.string.str_original_car_mode);
                            break;
                        case 1:
                            ((TextView) WYBBACarInfo.this.findViewById(R.id.tv_text3)).setText(R.string.str_installation_mode);
                            break;
                    }
                    break;
                case 114:
                    ((CheckedTextView) WYBBACarInfo.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                    break;
                case 115:
                    ((CheckedTextView) WYBBACarInfo.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
                    break;
                case 117:
                    ((CheckedTextView) WYBBACarInfo.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
                    break;
                case 164:
                    ((CheckedTextView) WYBBACarInfo.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        findViewById(R.id.layout_view1).setVisibility(8);
        if (DataCanbus.DATA[1000] == 7078332 || DataCanbus.DATA[1000] == 2294206) {
            findViewById(R.id.layout_view6).setVisibility(0);
        } else {
            findViewById(R.id.layout_view6).setVisibility(8);
        }
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
        int value4;
        int value5;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value6 = DataCanbus.DATA[112];
                if (value6 > 0) {
                    value6--;
                }
                setCarInfo(value6);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value7 = DataCanbus.DATA[112];
                if (value7 < 15) {
                    value7++;
                }
                setCarInfo(value7);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
            case R.id.btn_plus2 /* 2131427461 */:
                int value8 = DataCanbus.DATA[113];
                if (value8 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{1, value}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value9 = DataCanbus.DATA[114];
                if (value9 == 1) {
                    value5 = 0;
                } else {
                    value5 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{2, value5}, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int value10 = DataCanbus.DATA[117];
                if (value10 == 1) {
                    value3 = 0;
                } else {
                    value3 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{4, value3}, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int value11 = DataCanbus.DATA[164];
                if (value11 == 1) {
                    value2 = 0;
                } else {
                    value2 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{5, value2}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value12 = DataCanbus.DATA[115];
                if (value12 == 1) {
                    value4 = 0;
                } else {
                    value4 = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{3, value4}, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                DataCanbus.PROXY.cmd(3, new int[]{1}, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, WYLandRoverPenelCarinfoAct.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
        }
    }

    public void setCarInfo(int value0) {
        DataCanbus.PROXY.cmd(0, new int[]{value0}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
    }
}
