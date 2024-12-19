package com.syu.carinfo.rzc.ruifengs3;

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
public class JhJiayueA5SetFunc extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.ruifengs3.JhJiayueA5SetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_low);
                                break;
                            case 1:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 99:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text2)).setText("0s");
                                break;
                            case 1:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text2)).setText("30s");
                                break;
                            case 2:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text2)).setText("60s");
                                break;
                            case 3:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text2)).setText("90");
                                break;
                            case 4:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text2)).setText("120s");
                                break;
                        }
                    }
                    break;
                case 100:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text3)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text3)).setText("0s");
                                break;
                            case 1:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text3)).setText("15s");
                                break;
                            case 2:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text3)).setText("30s");
                                break;
                            case 3:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text3)).setText("45");
                                break;
                            case 4:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text3)).setText("60s");
                                break;
                        }
                    }
                    break;
                case 101:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text4)).setText("15km/h");
                                break;
                            case 2:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text4)).setText("40km/h");
                                break;
                        }
                    }
                    break;
                case 102:
                    JhJiayueA5SetFunc.this.setCheck((CheckedTextView) JhJiayueA5SetFunc.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 103:
                    JhJiayueA5SetFunc.this.setCheck((CheckedTextView) JhJiayueA5SetFunc.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 104:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 105:
                    JhJiayueA5SetFunc.this.setCheck((CheckedTextView) JhJiayueA5SetFunc.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 106:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text6)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text6)).setText(R.string.wc_golf_normal);
                                break;
                            case 1:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text6)).setText(R.string.wc_golf_comfort);
                                break;
                            case 2:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text6)).setText(R.string.driver_system_sports);
                                break;
                        }
                    }
                    break;
                case 107:
                    JhJiayueA5SetFunc.this.setCheck((CheckedTextView) JhJiayueA5SetFunc.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 108:
                    JhJiayueA5SetFunc.this.setCheck((CheckedTextView) JhJiayueA5SetFunc.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 109:
                    JhJiayueA5SetFunc.this.setCheck((CheckedTextView) JhJiayueA5SetFunc.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 110:
                    JhJiayueA5SetFunc.this.setCheck((CheckedTextView) JhJiayueA5SetFunc.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 111:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 112:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text8)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text8)).setText("静态");
                                break;
                            case 1:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text8)).setText("呼吸");
                                break;
                            case 2:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text8)).setText("音乐律动");
                                break;
                        }
                    }
                    break;
                case 113:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 114:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text10)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text10)).setText("春意盎然");
                                break;
                            case 1:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text10)).setText("骄阳似火");
                                break;
                            case 2:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text10)).setText("秋色宜人");
                                break;
                            case 3:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text10)).setText("白雪皑皑");
                                break;
                            case 4:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text10)).setText("水碧山青");
                                break;
                            case 5:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text10)).setText("姹紫嫣红");
                                break;
                            case 6:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text10)).setText("金碧辉煌");
                                break;
                            case 7:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text10)).setText("碧海蓝天");
                                break;
                            case 8:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text10)).setText("紫气东来");
                                break;
                            case 9:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text10)).setText("绚丽多姿");
                                break;
                        }
                    }
                    break;
                case 115:
                    JhJiayueA5SetFunc.this.setCheck((CheckedTextView) JhJiayueA5SetFunc.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_od_jianghuai_jiayuea5_setfunc);
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
        setSelfClick((Button) findViewById(R.id.btn_minus10), this);
        setSelfClick((Button) findViewById(R.id.btn_plus10), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[102];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(5, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[98] - 1;
                if (value2 < 0) {
                    value2 = 2;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[98] + 1;
                if (value3 > 2) {
                    value3 = 0;
                }
                setCarInfo(1, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[99] - 1;
                if (value4 < 0) {
                    value4 = 4;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[99] + 1;
                if (value5 > 4) {
                    value5 = 0;
                }
                setCarInfo(2, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value6 = DataCanbus.DATA[100] - 1;
                if (value6 < 0) {
                    value6 = 4;
                }
                setCarInfo(3, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[100] + 1;
                if (value7 > 4) {
                    value7 = 0;
                }
                setCarInfo(3, value7);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value8 = DataCanbus.DATA[101] - 1;
                if (value8 < 0) {
                    value8 = 2;
                }
                setCarInfo(4, value8);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value9 = DataCanbus.DATA[101] + 1;
                if (value9 > 2) {
                    value9 = 0;
                }
                setCarInfo(4, value9);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value10 = DataCanbus.DATA[104];
                if (value10 > 0) {
                    value10--;
                }
                setCarInfo(7, value10);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value11 = DataCanbus.DATA[104];
                if (value11 < 10) {
                    value11++;
                }
                setCarInfo(7, value11);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value12 = DataCanbus.DATA[106] - 1;
                if (value12 < 0) {
                    value12 = 2;
                }
                setCarInfo(9, value12);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value13 = DataCanbus.DATA[106] + 1;
                if (value13 > 2) {
                    value13 = 0;
                }
                setCarInfo(9, value13);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value14 = DataCanbus.DATA[111];
                if (value14 > 0) {
                    value14--;
                }
                setCarLight(2, value14);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value15 = DataCanbus.DATA[111];
                if (value15 < 10) {
                    value15++;
                }
                setCarLight(2, value15);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value16 = DataCanbus.DATA[112] - 1;
                if (value16 < 0) {
                    value16 = 2;
                }
                setCarLight(3, value16);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value17 = DataCanbus.DATA[112] + 1;
                if (value17 > 2) {
                    value17 = 0;
                }
                setCarLight(3, value17);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value18 = DataCanbus.DATA[113];
                if (value18 > 0) {
                    value18--;
                }
                setCarLight(4, value18);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value19 = DataCanbus.DATA[113];
                if (value19 < 63) {
                    value19++;
                }
                setCarLight(4, value19);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value20 = DataCanbus.DATA[114] - 1;
                if (value20 < 0) {
                    value20 = 9;
                }
                setCarLight(5, value20);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value21 = DataCanbus.DATA[114] + 1;
                if (value21 > 9) {
                    value21 = 0;
                }
                setCarLight(5, value21);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value22 = DataCanbus.DATA[103];
                if (value22 == 1) {
                    value22 = 0;
                } else if (value22 == 0) {
                    value22 = 1;
                }
                setCarInfo(6, value22);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value23 = DataCanbus.DATA[105];
                if (value23 == 1) {
                    value23 = 0;
                } else if (value23 == 0) {
                    value23 = 1;
                }
                setCarInfo(8, value23);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value24 = DataCanbus.DATA[107];
                if (value24 == 1) {
                    value24 = 0;
                } else if (value24 == 0) {
                    value24 = 1;
                }
                setCarInfo(10, value24);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value25 = DataCanbus.DATA[108];
                if (value25 == 1) {
                    value25 = 0;
                } else if (value25 == 0) {
                    value25 = 1;
                }
                setCarInfo(11, value25);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value26 = DataCanbus.DATA[109];
                if (value26 == 1) {
                    value26 = 0;
                } else if (value26 == 0) {
                    value26 = 1;
                }
                setCarInfo(12, value26);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value27 = DataCanbus.DATA[110];
                if (value27 == 1) {
                    value27 = 0;
                } else if (value27 == 0) {
                    value27 = 1;
                }
                setCarLight(1, value27);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value28 = DataCanbus.DATA[115];
                if (value28 == 1) {
                    value28 = 0;
                } else if (value28 == 0) {
                    value28 = 1;
                }
                setCarLight(6, value28);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    public void setCarLight(int value1, int value2) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{83}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
    }
}
