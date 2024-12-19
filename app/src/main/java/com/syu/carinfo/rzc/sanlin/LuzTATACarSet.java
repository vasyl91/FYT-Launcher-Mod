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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LuzTATACarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.LuzTATACarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 24:
                    if (((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text1)).setText("TONE1");
                                break;
                            case 1:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text1)).setText("TONE2");
                                break;
                            case 2:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text1)).setText("TONE3");
                                break;
                        }
                    }
                    break;
                case 25:
                    if (((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text2)).setText("0S");
                                break;
                            case 1:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text2)).setText("5S");
                                break;
                            case 2:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text2)).setText("10S");
                                break;
                        }
                    }
                    break;
                case 26:
                    LuzTATACarSet.this.setCheck((CheckedTextView) LuzTATACarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 27:
                    LuzTATACarSet.this.setCheck((CheckedTextView) LuzTATACarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 28:
                    if (((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text3)).setText("All");
                                break;
                            case 1:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text3)).setText("Driver");
                                break;
                        }
                    }
                    break;
                case 29:
                    if (((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text4)).setText("30S");
                                break;
                            case 1:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text4)).setText("60S");
                                break;
                            case 2:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text4)).setText("90S");
                                break;
                        }
                    }
                    break;
                case 30:
                    if (((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text5)).setText("All");
                                break;
                            case 1:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text5)).setText("Off");
                                break;
                            case 2:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text5)).setText("Auto");
                                break;
                        }
                    }
                    break;
                case 31:
                    LuzTATACarSet.this.setCheck((CheckedTextView) LuzTATACarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 32:
                    LuzTATACarSet.this.setCheck((CheckedTextView) LuzTATACarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 33:
                    if (((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text6)).setText(R.string.color_white_str);
                                break;
                            case 1:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_3);
                                break;
                            case 2:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_5);
                                break;
                            case 3:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text6)).setText(R.string.color_orange_str);
                                break;
                            case 4:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text6)).setText(R.string.color_pueple_str);
                                break;
                            case 5:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_color_gray);
                                break;
                            case 6:
                                ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_background_green);
                                break;
                        }
                    }
                    break;
                case 34:
                    if (((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) LuzTATACarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 35:
                    LuzTATACarSet.this.setCheck((CheckedTextView) LuzTATACarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_luz_tata_all_settings);
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
                int value = DataCanbus.DATA[26];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(0, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[24] - 1;
                if (value2 < 0) {
                    value2 = 2;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[24] + 1;
                if (value3 > 2) {
                    value3 = 0;
                }
                setCarInfo(1, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[25] - 1;
                if (value4 < 0) {
                    value4 = 2;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[25] + 1;
                if (value5 > 2) {
                    value5 = 0;
                }
                setCarInfo(2, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value6 = DataCanbus.DATA[28] - 1;
                if (value6 < 0) {
                    value6 = 1;
                }
                setCarInfo(4, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[28] + 1;
                if (value7 > 1) {
                    value7 = 0;
                }
                setCarInfo(4, value7);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value8 = DataCanbus.DATA[29] - 1;
                if (value8 < 0) {
                    value8 = 2;
                }
                setCarInfo(5, value8);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value9 = DataCanbus.DATA[29] + 1;
                if (value9 > 2) {
                    value9 = 0;
                }
                setCarInfo(5, value9);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value10 = DataCanbus.DATA[30] - 1;
                if (value10 < 0) {
                    value10 = 2;
                }
                setCarInfo(6, value10);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value11 = DataCanbus.DATA[30] + 1;
                if (value11 > 2) {
                    value11 = 0;
                }
                setCarInfo(6, value11);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value12 = DataCanbus.DATA[33] - 1;
                if (value12 < 0) {
                    value12 = 6;
                }
                setCarInfo(10, value12);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value13 = DataCanbus.DATA[33] + 1;
                if (value13 > 6) {
                    value13 = 0;
                }
                setCarInfo(10, value13);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value14 = DataCanbus.DATA[34] - 1;
                if (value14 < 0) {
                    value14 = 3;
                }
                setCarInfo(11, value14);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value15 = DataCanbus.DATA[34] + 1;
                if (value15 > 3) {
                    value15 = 0;
                }
                setCarInfo(11, value15);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value16 = DataCanbus.DATA[27];
                if (value16 == 1) {
                    value16 = 0;
                } else if (value16 == 0) {
                    value16 = 1;
                }
                setCarInfo(3, value16);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value17 = DataCanbus.DATA[31];
                if (value17 == 1) {
                    value17 = 0;
                } else if (value17 == 0) {
                    value17 = 1;
                }
                setCarInfo(8, value17);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value18 = DataCanbus.DATA[32];
                if (value18 == 1) {
                    value18 = 0;
                } else if (value18 == 0) {
                    value18 = 1;
                }
                setCarInfo(9, value18);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value19 = DataCanbus.DATA[35];
                if (value19 == 1) {
                    value19 = 0;
                } else if (value19 == 0) {
                    value19 = 1;
                }
                setCarInfo(12, value19);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
    }
}
