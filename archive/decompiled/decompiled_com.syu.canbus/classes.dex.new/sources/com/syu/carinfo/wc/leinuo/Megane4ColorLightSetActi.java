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
public class Megane4ColorLightSetActi extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.leinuo.Megane4ColorLightSetActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 109:
                    if (((TextView) Megane4ColorLightSetActi.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Megane4ColorLightSetActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_0);
                                break;
                            case 1:
                                ((TextView) Megane4ColorLightSetActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_3);
                                break;
                            case 2:
                                ((TextView) Megane4ColorLightSetActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_5);
                                break;
                            case 3:
                                ((TextView) Megane4ColorLightSetActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_6);
                                break;
                            case 4:
                                ((TextView) Megane4ColorLightSetActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_brown);
                                break;
                            case 5:
                                ((TextView) Megane4ColorLightSetActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_2);
                                break;
                            case 6:
                                ((TextView) Megane4ColorLightSetActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_7);
                                break;
                            case 7:
                                ((TextView) Megane4ColorLightSetActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_1);
                                break;
                        }
                    }
                    break;
                case 110:
                    if (((TextView) Megane4ColorLightSetActi.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) Megane4ColorLightSetActi.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value * 5).toString());
                    }
                    break;
                case 111:
                    Megane4ColorLightSetActi.this.setCheck((CheckedTextView) Megane4ColorLightSetActi.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 112:
                    Megane4ColorLightSetActi.this.setCheck((CheckedTextView) Megane4ColorLightSetActi.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 113:
                    Megane4ColorLightSetActi.this.setCheck((CheckedTextView) Megane4ColorLightSetActi.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 114:
                    Megane4ColorLightSetActi.this.setCheck((CheckedTextView) Megane4ColorLightSetActi.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 212:
                    Megane4ColorLightSetActi.this.setCheck((CheckedTextView) Megane4ColorLightSetActi.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0352_wc_magane_colorlight_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[109] - 1;
                if (value < 0) {
                    value = 7;
                }
                setCarInfo(1, value, 0, 0);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[109] + 1;
                if (value2 > 7) {
                    value2 = 0;
                }
                setCarInfo(1, value2, 0, 0);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[110];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(2, value3, 0, 0);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[110];
                if (value4 < 20) {
                    value4++;
                }
                setCarInfo(2, value4, 0, 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value5 = DataCanbus.DATA[111];
                if (value5 == 0) {
                    value5 = 1;
                } else if (value5 == 1) {
                    value5 = 0;
                }
                setCarInfo(3, value5, 0, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int value6 = DataCanbus.DATA[114];
                if (value6 == 0) {
                    value6 = 1;
                } else if (value6 == 1) {
                    value6 = 0;
                }
                setCarInfo(6, value6, 0, 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int value7 = DataCanbus.DATA[212];
                if (value7 == 0) {
                    value7 = 1;
                } else if (value7 == 1) {
                    value7 = 0;
                }
                setCarInfo(102, value7, 0, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value8 = DataCanbus.DATA[112];
                if (value8 == 0) {
                    value8 = 1;
                } else if (value8 == 1) {
                    value8 = 0;
                }
                setCarInfo(4, value8, 0, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int value9 = DataCanbus.DATA[113];
                if (value9 == 0) {
                    value9 = 1;
                } else if (value9 == 1) {
                    value9 = 0;
                }
                setCarInfo(5, value9, 0, 0);
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
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[212].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[212].removeNotify(this.mNotifyCanbus);
    }
}
