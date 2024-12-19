package com.syu.carinfo.xp.ziyouguang;

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
public class Activity_424_MultiSenseFuncSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.Activity_424_MultiSenseFuncSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 132:
                    if (((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text1)).setText("Eco");
                                break;
                            case 1:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text1)).setText("Regular");
                                break;
                            case 2:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text1)).setText("Sport");
                                break;
                            case 3:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text1)).setText("My Sense");
                                break;
                        }
                    }
                    break;
                case 133:
                    if (((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text2)).setText("Eco");
                                break;
                            case 1:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text2)).setText("Regular");
                                break;
                            case 2:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text2)).setText("Sport");
                                break;
                        }
                    }
                    break;
                case 134:
                    if (((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text3)).setText("Eco");
                                break;
                            case 1:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text3)).setText("Regular");
                                break;
                            case 2:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text3)).setText("Sport");
                                break;
                        }
                    }
                    break;
                case 135:
                    if (((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text4)).setText("Eco");
                                break;
                            case 1:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text4)).setText("Regular");
                                break;
                        }
                    }
                    break;
                case 136:
                    if (((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text5)).setText("Eco");
                                break;
                            case 1:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text5)).setText("Comfort");
                                break;
                            case 2:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text5)).setText("Regular");
                                break;
                            case 3:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text5)).setText("Sport");
                                break;
                        }
                    }
                    break;
                case 137:
                    if (((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text6)).setText(R.string.color_white_str);
                                break;
                            case 1:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_5);
                                break;
                            case 2:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_4);
                                break;
                            case 3:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_3);
                                break;
                            case 4:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_6);
                                break;
                            case 5:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_2);
                                break;
                            case 6:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_7);
                                break;
                            case 7:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_1);
                                break;
                        }
                    }
                    break;
                case 138:
                    Activity_424_MultiSenseFuncSet.this.setCheck((CheckedTextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 139:
                    Activity_424_MultiSenseFuncSet.this.setCheck((CheckedTextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 140:
                    Activity_424_MultiSenseFuncSet.this.setCheck((CheckedTextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 141:
                    if (((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 142:
                    if (((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text8)).setText("Sport");
                                break;
                            case 1:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text8)).setText("Race");
                                break;
                            case 2:
                                ((TextView) Activity_424_MultiSenseFuncSet.this.findViewById(R.id.tv_text8)).setText("Neutral");
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
        setContentView(R.layout.layout_0424_xp_clio_multi_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
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
                int value = DataCanbus.DATA[138];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                setCarInfo(102, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[132] - 1;
                if (value2 < 0) {
                    value2 = 3;
                }
                setCarInfo(96, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[132] + 1;
                if (value3 > 3) {
                    value3 = 0;
                }
                setCarInfo(96, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[133] - 1;
                if (value4 < 0) {
                    value4 = 2;
                }
                setCarInfo(97, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[133] + 1;
                if (value5 > 2) {
                    value5 = 0;
                }
                setCarInfo(97, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value6 = DataCanbus.DATA[134] - 1;
                if (value6 < 0) {
                    value6 = 2;
                }
                setCarInfo(98, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[134] + 1;
                if (value7 > 2) {
                    value7 = 0;
                }
                setCarInfo(98, value7);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value8 = DataCanbus.DATA[135] - 1;
                if (value8 < 0) {
                    value8 = 1;
                }
                setCarInfo(105, value8);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value9 = DataCanbus.DATA[135] + 1;
                if (value9 > 1) {
                    value9 = 0;
                }
                setCarInfo(105, value9);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value10 = DataCanbus.DATA[136] - 1;
                if (value10 < 0) {
                    value10 = 3;
                }
                setCarInfo(99, value10);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value11 = DataCanbus.DATA[136] + 1;
                if (value11 > 3) {
                    value11 = 0;
                }
                setCarInfo(99, value11);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value12 = DataCanbus.DATA[137] - 1;
                if (value12 < 0) {
                    value12 = 7;
                }
                setCarInfo(100, value12);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value13 = DataCanbus.DATA[137] + 1;
                if (value13 > 7) {
                    value13 = 0;
                }
                setCarInfo(100, value13);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value14 = DataCanbus.DATA[141];
                if (value14 > 0) {
                    value14 -= 5;
                }
                if (value14 < 0) {
                    value14 = 0;
                }
                setCarInfo(101, value14);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value15 = DataCanbus.DATA[141];
                if (value15 < 100) {
                    value15 += 5;
                }
                if (value15 < 100) {
                    value15 = 100;
                }
                setCarInfo(101, value15);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value16 = DataCanbus.DATA[142] - 1;
                if (value16 < 0) {
                    value16 = 2;
                }
                setCarInfo(106, value16);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value17 = DataCanbus.DATA[142] + 1;
                if (value17 > 2) {
                    value17 = 0;
                }
                setCarInfo(106, value17);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value18 = DataCanbus.DATA[139];
                if (value18 == 0) {
                    value18 = 1;
                } else if (value18 == 1) {
                    value18 = 0;
                }
                setCarInfo(103, value18);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value19 = DataCanbus.DATA[140];
                if (value19 == 0) {
                    value19 = 1;
                } else if (value19 == 1) {
                    value19 = 0;
                }
                setCarInfo(104, value19);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{96}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
    }
}
