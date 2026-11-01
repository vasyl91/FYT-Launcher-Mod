package com.syu.carinfo.wccamry;

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
public class WcToyotaDrivemodeActi extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wccamry.WcToyotaDrivemodeActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 202:
                    if (((TextView) WcToyotaDrivemodeActi.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WcToyotaDrivemodeActi.this.findViewById(R.id.tv_text1)).setText(R.string.wc_golf_normal);
                                break;
                            case 1:
                                ((TextView) WcToyotaDrivemodeActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_driving_eco);
                                break;
                            case 2:
                                ((TextView) WcToyotaDrivemodeActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_driving_sport);
                                break;
                            case 3:
                                ((TextView) WcToyotaDrivemodeActi.this.findViewById(R.id.tv_text1)).setText(R.string.wc_17zhinanzhe_str1);
                                break;
                        }
                    }
                    break;
                case 203:
                    if (((TextView) WcToyotaDrivemodeActi.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WcToyotaDrivemodeActi.this.findViewById(R.id.tv_text2)).setText(R.string.wc_golf_normal);
                                break;
                            case 1:
                                ((TextView) WcToyotaDrivemodeActi.this.findViewById(R.id.tv_text2)).setText(R.string.str_driving_eco);
                                break;
                            case 2:
                                ((TextView) WcToyotaDrivemodeActi.this.findViewById(R.id.tv_text2)).setText(R.string.str_driving_sport);
                                break;
                        }
                    }
                    break;
                case 204:
                    if (((TextView) WcToyotaDrivemodeActi.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WcToyotaDrivemodeActi.this.findViewById(R.id.tv_text3)).setText(R.string.wc_golf_normal);
                                break;
                            case 1:
                                ((TextView) WcToyotaDrivemodeActi.this.findViewById(R.id.tv_text3)).setText(R.string.str_driving_eco);
                                break;
                            case 2:
                                ((TextView) WcToyotaDrivemodeActi.this.findViewById(R.id.tv_text3)).setText(R.string.str_driving_sport);
                                break;
                        }
                    }
                    break;
                case 205:
                    if (((TextView) WcToyotaDrivemodeActi.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WcToyotaDrivemodeActi.this.findViewById(R.id.tv_text4)).setText(R.string.wc_golf_normal);
                                break;
                            case 1:
                                ((TextView) WcToyotaDrivemodeActi.this.findViewById(R.id.tv_text4)).setText(R.string.str_driving_eco);
                                break;
                        }
                    }
                    break;
                case 206:
                    WcToyotaDrivemodeActi.this.setCheck((CheckedTextView) WcToyotaDrivemodeActi.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 207:
                    WcToyotaDrivemodeActi.this.setCheck((CheckedTextView) WcToyotaDrivemodeActi.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 208:
                    WcToyotaDrivemodeActi.this.setCheck((CheckedTextView) WcToyotaDrivemodeActi.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 209:
                    WcToyotaDrivemodeActi.this.setCheck((CheckedTextView) WcToyotaDrivemodeActi.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 210:
                    WcToyotaDrivemodeActi.this.setCheck((CheckedTextView) WcToyotaDrivemodeActi.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 211:
                    WcToyotaDrivemodeActi.this.setCheck((CheckedTextView) WcToyotaDrivemodeActi.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0294_wc_toyota_drivemode_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
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
        int value;
        int value2;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value3 = DataCanbus.DATA[202] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(1, 22, value3);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value4 = DataCanbus.DATA[202] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(1, 22, value4);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value5 = DataCanbus.DATA[203] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(1, 23, value5);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value6 = DataCanbus.DATA[203] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(1, 23, value6);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                if (DataCanbus.DATA[204] == 0) {
                    value2 = 2;
                } else {
                    value2 = 0;
                }
                setCarInfo(1, 24, value2);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                if (DataCanbus.DATA[204] == 0) {
                    value = 2;
                } else {
                    value = 0;
                }
                setCarInfo(1, 24, value);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[205] - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                setCarInfo(1, 25, value7);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[205] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfo(1, 25, value8);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                setCarInfo(1, 50, 1);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                setCarInfo(1, 49, 1);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                setCarInfo(1, 52, 1);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                setCarInfo(1, 51, 1);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value9 = DataCanbus.DATA[212] - 1;
                if (value9 < 0) {
                    value9 = 2;
                }
                setCarInfo(1, 31, value9);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value10 = DataCanbus.DATA[206];
                if (value10 == 0) {
                    value10 = 1;
                } else if (value10 == 1) {
                    value10 = 0;
                }
                setCarInfo(1, 26, value10);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int value11 = DataCanbus.DATA[209];
                if (value11 == 0) {
                    value11 = 1;
                } else if (value11 == 1) {
                    value11 = 0;
                }
                setCarInfo(1, 29, value11);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int value12 = DataCanbus.DATA[210];
                if (value12 == 0) {
                    value12 = 1;
                } else if (value12 == 1) {
                    value12 = 0;
                }
                setCarInfo(1, 30, value12);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value13 = DataCanbus.DATA[207];
                if (value13 == 0) {
                    value13 = 1;
                } else if (value13 == 1) {
                    value13 = 0;
                }
                setCarInfo(1, 27, value13);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int value14 = DataCanbus.DATA[208];
                if (value14 == 0) {
                    value14 = 1;
                } else if (value14 == 1) {
                    value14 = 0;
                }
                setCarInfo(1, 28, value14);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int value15 = DataCanbus.DATA[211];
                if (value15 == 0) {
                    value15 = 1;
                } else if (value15 == 1) {
                    value15 = 0;
                }
                setCarInfo(1, 48, value15);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                setCarInfo(1, 53, 1);
                break;
        }
    }

    public void setCarInfo(int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(29, new int[]{value1, value2, value3}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[202].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[203].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[204].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[205].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[206].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[207].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[208].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[209].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[210].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[211].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[202].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[203].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[204].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[205].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[206].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[207].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[208].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[209].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[210].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[211].removeNotify(this.mNotifyCanbus);
    }
}
