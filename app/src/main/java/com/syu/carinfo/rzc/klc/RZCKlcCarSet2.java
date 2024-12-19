package com.syu.carinfo.rzc.klc;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
public class RZCKlcCarSet2 extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.klc.RZCKlcCarSet2.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 83:
                    RZCKlcCarSet2.this.setCheck((CheckedTextView) RZCKlcCarSet2.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 84:
                    RZCKlcCarSet2.this.setCheck((CheckedTextView) RZCKlcCarSet2.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 85:
                    if (((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text1)).setText(R.string.str_379_str_2);
                                break;
                            case 1:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text1)).setText(R.string.str_379_str_3);
                                break;
                        }
                    }
                    break;
                case 86:
                    if (((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text2)).setText(R.string.alarm);
                                break;
                            case 2:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text2)).setText(R.string.wc_weilang_auto_fangzhuang_warn_and_zhidong);
                                break;
                        }
                    }
                    break;
                case 87:
                    RZCKlcCarSet2.this.setCheck((CheckedTextView) RZCKlcCarSet2.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 88:
                    RZCKlcCarSet2.this.setCheck((CheckedTextView) RZCKlcCarSet2.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 89:
                    RZCKlcCarSet2.this.setCheck((CheckedTextView) RZCKlcCarSet2.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 90:
                    RZCKlcCarSet2.this.setCheck((CheckedTextView) RZCKlcCarSet2.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 91:
                    if (((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text3)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text3)).setText(R.string.wc_weilang_driver_and_customer);
                                break;
                            case 2:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text3)).setText(R.string.wc_weilang_driver);
                                break;
                            case 3:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text3)).setText(R.string.str_252_sound_distribution1);
                                break;
                        }
                    }
                    break;
                case 92:
                    RZCKlcCarSet2.this.setCheck((CheckedTextView) RZCKlcCarSet2.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 93:
                    if (((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text4)).setText(R.string.str_long_lasting);
                                break;
                            case 1:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text4)).setText(R.string.str_short_acting);
                                break;
                        }
                    }
                    break;
                case 94:
                    if (((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text5)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text5)).setText("Left-Hand Traffic");
                                break;
                            case 1:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text5)).setText("Right-Hand Traffic");
                                break;
                        }
                    }
                    break;
                case 95:
                    if (((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text6)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text6)).setText("Corner and Bend Lighting");
                                break;
                            case 1:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text6)).setText("Intelligent Distribution");
                                break;
                        }
                    }
                    break;
                case 96:
                    RZCKlcCarSet2.this.setCheck((CheckedTextView) RZCKlcCarSet2.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 97:
                    RZCKlcCarSet2.this.setCheck((CheckedTextView) RZCKlcCarSet2.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 98:
                    RZCKlcCarSet2.this.setCheck((CheckedTextView) RZCKlcCarSet2.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 99:
                    RZCKlcCarSet2.this.setCheck((CheckedTextView) RZCKlcCarSet2.this.findViewById(R.id.ctv_checkedtext11), val == 1);
                    break;
                case 100:
                    if (((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text7)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text7)).setText(R.string.str_corner_lighting);
                                break;
                            case 2:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text7)).setText(R.string.str_smart_light_distribution);
                                break;
                        }
                    }
                    break;
                case 104:
                    if (((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text8)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text8)).setText(R.string.MAX);
                                break;
                            case 1:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text8)).setText("6A");
                                break;
                        }
                    }
                    break;
                case 105:
                    if (((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text9)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text9)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text9)).setText(R.string.wc_ruiteng_string_unlock_mode_0);
                                break;
                            case 2:
                                ((TextView) RZCKlcCarSet2.this.findViewById(R.id.tv_text9)).setText(R.string.wc_ruiteng_string_unlock_mode_1);
                                break;
                        }
                    }
                    break;
                case 106:
                    RZCKlcCarSet2.this.setCheck((CheckedTextView) RZCKlcCarSet2.this.findViewById(R.id.ctv_checkedtext12), val == 1);
                    break;
                case 107:
                    RZCKlcCarSet2.this.setCheck((CheckedTextView) RZCKlcCarSet2.this.findViewById(R.id.ctv_checkedtext13), val == 1);
                    break;
                case 108:
                    RZCKlcCarSet2.this.setCheck((CheckedTextView) RZCKlcCarSet2.this.findViewById(R.id.ctv_checkedtext14), val == 1);
                    break;
                case 109:
                    RZCKlcCarSet2.this.setCheck((CheckedTextView) RZCKlcCarSet2.this.findViewById(R.id.ctv_checkedtext15), val == 1);
                    break;
                case 110:
                    RZCKlcCarSet2.this.setCheck((CheckedTextView) RZCKlcCarSet2.this.findViewById(R.id.ctv_checkedtext16), val == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0062_rzc_gm_settings2);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext12), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext13), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext14), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext15), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext16), this);
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
        setSelfClick((Button) findViewById(R.id.btn_minus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[83];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(26, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[85];
                int value3 = value2 - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCarInfo(84, value3);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value4 = DataCanbus.DATA[85];
                int value5 = value4 + 1;
                if (value5 > 1) {
                    value5 = 0;
                }
                setCarInfo(84, value5);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value6 = DataCanbus.DATA[86];
                int value7 = value6 - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(85, value7);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value8 = DataCanbus.DATA[86];
                int value9 = value8 + 1;
                if (value9 > 2) {
                    value9 = 0;
                }
                setCarInfo(85, value9);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value10 = DataCanbus.DATA[91];
                int value11 = value10 - 1;
                if (value11 < 0) {
                    value11 = 3;
                }
                setCarInfo(90, value11);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value12 = DataCanbus.DATA[91];
                int value13 = value12 + 1;
                if (value13 > 3) {
                    value13 = 0;
                }
                setCarInfo(90, value13);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value14 = DataCanbus.DATA[93];
                int value15 = value14 - 1;
                if (value15 < 0) {
                    value15 = 1;
                }
                setCarInfo(92, value15);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value16 = DataCanbus.DATA[93];
                int value17 = value16 + 1;
                if (value17 > 1) {
                    value17 = 0;
                }
                setCarInfo(92, value17);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value18 = DataCanbus.DATA[94];
                int value19 = value18 - 1;
                if (value19 < 0) {
                    value19 = 1;
                }
                setCarInfo(16, value19);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value20 = DataCanbus.DATA[94];
                int value21 = value20 + 1;
                if (value21 > 1) {
                    value21 = 0;
                }
                setCarInfo(16, value21);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value22 = DataCanbus.DATA[95];
                int value23 = value22 - 1;
                if (value23 < 0) {
                    value23 = 1;
                }
                setCarInfo(17, value23);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value24 = DataCanbus.DATA[95];
                int value25 = value24 + 1;
                if (value25 > 1) {
                    value25 = 0;
                }
                setCarInfo(17, value25);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value26 = DataCanbus.DATA[100];
                int value27 = value26 - 1;
                if (value27 < 0) {
                    value27 = 2;
                }
                setCarInfo(94, value27);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value28 = DataCanbus.DATA[100];
                int value29 = value28 + 1;
                if (value29 > 2) {
                    value29 = 0;
                }
                setCarInfo(94, value29);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value30 = DataCanbus.DATA[104];
                int value31 = value30 - 1;
                if (value31 < 0) {
                    value31 = 1;
                }
                setCarInfo(34, value31);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value32 = DataCanbus.DATA[104];
                int value33 = value32 + 1;
                if (value33 > 1) {
                    value33 = 0;
                }
                setCarInfo(34, value33);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value34 = DataCanbus.DATA[105];
                if (value34 - 1 < 0) {
                }
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value35 = DataCanbus.DATA[105];
                if (value35 + 1 > 2) {
                }
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value36 = DataCanbus.DATA[84];
                if (value36 == 1) {
                    value36 = 0;
                } else if (value36 == 0) {
                    value36 = 1;
                }
                setCarInfo(27, value36);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value37 = DataCanbus.DATA[87];
                if (value37 == 1) {
                    value37 = 0;
                } else if (value37 == 0) {
                    value37 = 1;
                }
                setCarInfo(86, value37);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value38 = DataCanbus.DATA[88];
                if (value38 == 1) {
                    value38 = 0;
                } else if (value38 == 0) {
                    value38 = 1;
                }
                setCarInfo(87, value38);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value39 = DataCanbus.DATA[89];
                if (value39 == 1) {
                    value39 = 0;
                } else if (value39 == 0) {
                    value39 = 1;
                }
                setCarInfo(88, value39);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value40 = DataCanbus.DATA[90];
                if (value40 == 1) {
                    value40 = 0;
                } else if (value40 == 0) {
                    value40 = 1;
                }
                setCarInfo(89, value40);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value41 = DataCanbus.DATA[92];
                if (value41 == 1) {
                    value41 = 0;
                } else if (value41 == 0) {
                    value41 = 1;
                }
                setCarInfo(91, value41);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value42 = DataCanbus.DATA[96];
                if (value42 == 1) {
                    value42 = 0;
                } else if (value42 == 0) {
                    value42 = 1;
                }
                setCarInfo(19, value42);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value43 = DataCanbus.DATA[97];
                if (value43 == 1) {
                    value43 = 0;
                } else if (value43 == 0) {
                    value43 = 1;
                }
                setCarInfo(20, value43);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int value44 = DataCanbus.DATA[98];
                if (value44 == 1) {
                    value44 = 0;
                } else if (value44 == 0) {
                    value44 = 1;
                }
                setCarInfo(21, value44);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                int value45 = DataCanbus.DATA[99];
                if (value45 == 1) {
                    value45 = 0;
                } else if (value45 == 0) {
                    value45 = 1;
                }
                setCarInfo(93, value45);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                int value46 = DataCanbus.DATA[106];
                if (value46 == 1) {
                    value46 = 0;
                } else if (value46 == 0) {
                    value46 = 1;
                }
                setCarInfo(36, value46);
                break;
            case R.id.ctv_checkedtext13 /* 2131427545 */:
                int value47 = DataCanbus.DATA[107];
                if (value47 == 1) {
                    value47 = 0;
                } else if (value47 == 0) {
                    value47 = 1;
                }
                setCarInfo(35, value47);
                break;
            case R.id.ctv_checkedtext14 /* 2131427546 */:
                int value48 = DataCanbus.DATA[108];
                if (value48 == 1) {
                    value48 = 0;
                } else if (value48 == 0) {
                    value48 = 1;
                }
                setCarInfo(37, value48);
                break;
            case R.id.ctv_checkedtext15 /* 2131427547 */:
                int value49 = DataCanbus.DATA[109];
                if (value49 == 1) {
                    value49 = 0;
                } else if (value49 == 0) {
                    value49 = 1;
                }
                setCarInfo(38, value49);
                break;
            case R.id.ctv_checkedtext16 /* 2131427548 */:
                int value50 = DataCanbus.DATA[110];
                if (value50 == 1) {
                    value50 = 0;
                } else if (value50 == 0) {
                    value50 = 1;
                }
                setCarInfo(39, value50);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(3, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(8, new int[]{10}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[83].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[84].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[85].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[83].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[84].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[85].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.klc.RZCKlcCarSet2.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.klc.RZCKlcCarSet2.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.klc.RZCKlcCarSet2.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
