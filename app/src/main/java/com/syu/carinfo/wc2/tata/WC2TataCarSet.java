package com.syu.carinfo.wc2.tata;

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
public class WC2TataCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc2.tata.WC2TataCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 86:
                    if (((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 87:
                    if (((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text2)).setText("0S");
                                break;
                            case 1:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text2)).setText("5S");
                                break;
                            case 2:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text2)).setText("10S");
                                break;
                        }
                    }
                    break;
                case 88:
                    if (((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text3)).setText("Tone 1");
                                break;
                            case 1:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text3)).setText("Tone 2");
                                break;
                            case 2:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text3)).setText("Tone 3");
                                break;
                        }
                    }
                    break;
                case 89:
                    if (((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text4)).setText("All Doors");
                                break;
                            case 1:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text4)).setText("Driver Door");
                                break;
                        }
                    }
                    break;
                case 90:
                    WC2TataCarSet.this.setCheck((CheckedTextView) WC2TataCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 91:
                    if (((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text5)).setText("30S");
                                break;
                            case 1:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text5)).setText("60S");
                                break;
                            case 2:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text5)).setText("90S");
                                break;
                        }
                    }
                    break;
                case 92:
                    if (((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text6)).setText("OFF");
                                break;
                            case 1:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text6)).setText("ON");
                                break;
                            case 2:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text6)).setText("AUTO");
                                break;
                        }
                    }
                    break;
                case 93:
                    WC2TataCarSet.this.setCheck((CheckedTextView) WC2TataCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 94:
                    WC2TataCarSet.this.setCheck((CheckedTextView) WC2TataCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 95:
                    if (((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.color_white_str);
                                break;
                            case 1:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_403_ambient_3);
                                break;
                            case 2:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_403_ambient_5);
                                break;
                            case 3:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_403_ambient_1);
                                break;
                            case 4:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_403_ambient_6);
                                break;
                            case 5:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_color_gray);
                                break;
                            case 6:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_403_ambient_4);
                                break;
                            case 7:
                                ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_403_ambient_0);
                                break;
                        }
                    }
                    break;
                case 96:
                    if (((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 97:
                    if (((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        if (value == 65535) {
                            ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text9)).setText("----");
                            break;
                        } else {
                            ((TextView) WC2TataCarSet.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value) + "km");
                            break;
                        }
                    }
                    break;
                case 118:
                    WC2TataCarSet.this.setCheck((CheckedTextView) WC2TataCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc_tata_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
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
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[90];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(5, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[86];
                if (value2 > 0) {
                    value2--;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[86];
                if (value3 < 15) {
                    value3++;
                }
                setCarInfo(1, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[87] - 1;
                if (value4 < 0) {
                    value4 = 2;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[87] + 1;
                if (value5 > 2) {
                    value5 = 0;
                }
                setCarInfo(2, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value6 = DataCanbus.DATA[88] - 1;
                if (value6 < 0) {
                    value6 = 2;
                }
                setCarInfo(3, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[88] + 1;
                if (value7 > 2) {
                    value7 = 0;
                }
                setCarInfo(3, value7);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value8 = DataCanbus.DATA[89] - 1;
                if (value8 < 0) {
                    value8 = 1;
                }
                setCarInfo(4, value8);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value9 = DataCanbus.DATA[89] + 1;
                if (value9 > 1) {
                    value9 = 0;
                }
                setCarInfo(4, value9);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value10 = DataCanbus.DATA[91] - 1;
                if (value10 < 0) {
                    value10 = 2;
                }
                setCarInfo(6, value10);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value11 = DataCanbus.DATA[91] + 1;
                if (value11 > 2) {
                    value11 = 0;
                }
                setCarInfo(6, value11);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value12 = DataCanbus.DATA[92] - 1;
                if (value12 < 0) {
                    value12 = 2;
                }
                setCarInfo(7, value12);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value13 = DataCanbus.DATA[92] + 1;
                if (value13 > 2) {
                    value13 = 0;
                }
                setCarInfo(7, value13);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value14 = DataCanbus.DATA[95] - 1;
                if (value14 < 0) {
                    value14 = 7;
                }
                setCarInfo(10, value14);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value15 = DataCanbus.DATA[95] + 1;
                if (value15 > 7) {
                    value15 = 0;
                }
                setCarInfo(10, value15);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value16 = DataCanbus.DATA[96];
                if (value16 > 0) {
                    value16--;
                }
                setCarInfo(11, value16);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value17 = DataCanbus.DATA[96];
                if (value17 < 5) {
                    value17++;
                }
                setCarInfo(11, value17);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value18 = DataCanbus.DATA[93];
                if (value18 == 1) {
                    value18 = 0;
                } else if (value18 == 0) {
                    value18 = 1;
                }
                setCarInfo(8, value18);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value19 = DataCanbus.DATA[94];
                if (value19 == 1) {
                    value19 = 0;
                } else if (value19 == 0) {
                    value19 = 1;
                }
                setCarInfo(9, value19);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value20 = DataCanbus.DATA[118];
                if (value20 == 1) {
                    value20 = 0;
                } else if (value20 == 0) {
                    value20 = 1;
                }
                setCarInfo(12, value20);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
    }
}
