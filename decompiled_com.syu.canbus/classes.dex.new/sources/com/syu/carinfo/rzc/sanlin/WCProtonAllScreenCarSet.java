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
public class WCProtonAllScreenCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.WCProtonAllScreenCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    if (((TextView) WCProtonAllScreenCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        if (value == 255) {
                            ((TextView) WCProtonAllScreenCarSet.this.findViewById(R.id.tv_text6)).setText("----");
                        } else {
                            ((TextView) WCProtonAllScreenCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder(String.valueOf(value)).toString());
                        }
                    }
                    break;
                case 99:
                    if (((TextView) WCProtonAllScreenCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        if (value == 255) {
                            ((TextView) WCProtonAllScreenCarSet.this.findViewById(R.id.tv_text7)).setText("----");
                        } else {
                            ((TextView) WCProtonAllScreenCarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder(String.valueOf(value)).toString());
                        }
                    }
                    break;
                case 120:
                    if (((TextView) WCProtonAllScreenCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) WCProtonAllScreenCarSet.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value) + "km");
                    }
                    break;
                case 156:
                    if (((TextView) WCProtonAllScreenCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (value == 1) {
                            ((TextView) WCProtonAllScreenCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_244_als2);
                        } else {
                            ((TextView) WCProtonAllScreenCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_244_als1);
                        }
                    }
                    break;
                case 157:
                    if (((TextView) WCProtonAllScreenCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        if (value == 1) {
                            ((TextView) WCProtonAllScreenCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_video_box_upgrade);
                        } else {
                            ((TextView) WCProtonAllScreenCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_protocol_box_upgrade);
                        }
                    }
                    break;
                case 159:
                    if (((TextView) WCProtonAllScreenCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) WCProtonAllScreenCarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(value)).toString());
                    }
                    break;
                case 160:
                    WCProtonAllScreenCarSet.this.setCheck((CheckedTextView) WCProtonAllScreenCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 161:
                    if (((TextView) WCProtonAllScreenCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        if (value == 1) {
                            ((TextView) WCProtonAllScreenCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_built_out_360);
                        } else {
                            ((TextView) WCProtonAllScreenCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_built_in_360);
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc2_proton_sceen_settings);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[157] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(1, value, 255, 255);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[157] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(1, value2, 255, 255);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[156] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCarInfo(40, value3, 255, 255);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[156] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarInfo(40, value4, 255, 255);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[159];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(41, value5, 255, 255);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[159];
                if (value6 < 36) {
                    value6++;
                }
                setCarInfo(41, value6, 255, 255);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[161] - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                setCarInfo(2, value7, 255, 255);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[161] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfo(2, value8, 255, 255);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value9 = DataCanbus.DATA[160];
                if (value9 == 1) {
                    value9 = 0;
                } else if (value9 == 0) {
                    value9 = 1;
                }
                DataCanbus.PROXY.cmd(5, new int[]{9, value9}, null, null);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(1, new int[]{value0, value1, value2, value3}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{50}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
    }
}
