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
public class LZBenzC200NTG5CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.LZBenzC200NTG5CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 118:
                    LZBenzC200NTG5CarSet.this.setCheck((CheckedTextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 119:
                    LZBenzC200NTG5CarSet.this.setCheck((CheckedTextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 120:
                    LZBenzC200NTG5CarSet.this.setCheck((CheckedTextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 121:
                    LZBenzC200NTG5CarSet.this.setCheck((CheckedTextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 122:
                    LZBenzC200NTG5CarSet.this.setCheck((CheckedTextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 123:
                    LZBenzC200NTG5CarSet.this.setCheck((CheckedTextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 124:
                    if (((TextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_driving_comfort);
                                break;
                            case 1:
                                ((TextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_driving_sport);
                                break;
                        }
                    }
                    break;
                case 125:
                    LZBenzC200NTG5CarSet.this.setCheck((CheckedTextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 126:
                    if (((TextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_driving_eco);
                                break;
                            case 1:
                                ((TextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_driving_comfort);
                                break;
                        }
                    }
                    break;
                case 127:
                    if (((TextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                                break;
                        }
                    }
                    break;
                case 128:
                    if (((TextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.tv_text4)).setText("solar");
                                break;
                            case 1:
                                ((TextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.tv_text4)).setText("neutral");
                                break;
                            case 2:
                                ((TextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.tv_text4)).setText("polar");
                                break;
                        }
                    }
                    break;
                case 129:
                    if (((TextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.tv_text5)).setText("comfort");
                                break;
                            case 1:
                                ((TextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.tv_text5)).setText("eco");
                                break;
                            case 2:
                                ((TextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.tv_text5)).setText("sport");
                                break;
                            case 3:
                                ((TextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.tv_text5)).setText("sport+");
                                break;
                            case 4:
                                ((TextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.tv_text5)).setText("manual");
                                break;
                        }
                    }
                    break;
                case 130:
                    if (((TextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.tv_text6)).setText("0s");
                                break;
                            case 1:
                                ((TextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.tv_text6)).setText("15s");
                                break;
                            case 2:
                                ((TextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.tv_text6)).setText("30s");
                                break;
                            case 3:
                                ((TextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.tv_text6)).setText("45s");
                                break;
                            case 4:
                                ((TextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.tv_text6)).setText("60s");
                                break;
                        }
                    }
                    break;
                case 131:
                    if (((TextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.tv_text7)).setText("0s");
                                break;
                            case 1:
                                ((TextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.tv_text7)).setText("15s");
                                break;
                            case 2:
                                ((TextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.tv_text7)).setText("30s");
                                break;
                            case 3:
                                ((TextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.tv_text7)).setText("45s");
                                break;
                            case 4:
                                ((TextView) LZBenzC200NTG5CarSet.this.findViewById(R.id.tv_text7)).setText("60s");
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
        setContentView(R.layout.layout_0455_lz_benz_c200_ntg50_settings);
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
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[124] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(10, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[124] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(10, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[126] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCarInfo(12, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[126] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarInfo(12, value4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[127] - 1;
                if (value5 < 0) {
                    value5 = 5;
                }
                setCarInfo(8, value5);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[127] + 1;
                if (value6 > 5) {
                    value6 = 0;
                }
                setCarInfo(8, value6);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[128] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(9, value7);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[128] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(9, value8);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[129] - 1;
                if (value9 < 0) {
                    value9 = 4;
                }
                setCarInfo(13, value9);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[129] + 1;
                if (value10 > 4) {
                    value10 = 0;
                }
                setCarInfo(13, value10);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value11 = DataCanbus.DATA[130] - 1;
                if (value11 < 0) {
                    value11 = 4;
                }
                setCarInfo(6, value11);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value12 = DataCanbus.DATA[130] + 1;
                if (value12 > 4) {
                    value12 = 0;
                }
                setCarInfo(6, value12);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value13 = DataCanbus.DATA[131] - 1;
                if (value13 < 0) {
                    value13 = 4;
                }
                setCarInfo(7, value13);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value14 = DataCanbus.DATA[131] + 1;
                if (value14 > 4) {
                    value14 = 0;
                }
                setCarInfo(7, value14);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCarInfo(0, DataCanbus.DATA[118] == 1 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                setCarInfo(3, DataCanbus.DATA[121] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                setCarInfo(4, DataCanbus.DATA[122] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCarInfo(1, DataCanbus.DATA[119] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                setCarInfo(2, DataCanbus.DATA[120] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                setCarInfo(5, DataCanbus.DATA[123] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                setCarInfo(11, DataCanbus.DATA[125] != 1 ? 1 : 0);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{57, 0}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
    }
}
