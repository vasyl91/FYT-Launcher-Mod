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
public class LZCadillacCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.LZCadillacCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 8:
                    if (((TextView) LZCadillacCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) LZCadillacCarSet.this.findViewById(R.id.tv_text1)).setText("熄火时驾驶员车门解锁");
                                break;
                            case 1:
                                ((TextView) LZCadillacCarSet.this.findViewById(R.id.tv_text1)).setText("熄火时所有车门解锁");
                                break;
                            case 2:
                                ((TextView) LZCadillacCarSet.this.findViewById(R.id.tv_text1)).setText("停车时驾驶员车门解锁");
                                break;
                            case 3:
                                ((TextView) LZCadillacCarSet.this.findViewById(R.id.tv_text1)).setText("停车时所有车门解锁");
                                break;
                        }
                    }
                    break;
                case 9:
                    if (((TextView) LZCadillacCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) LZCadillacCarSet.this.findViewById(R.id.tv_text2)).setText("拉开任一前门把手时该车门解锁");
                                break;
                            case 1:
                                ((TextView) LZCadillacCarSet.this.findViewById(R.id.tv_text2)).setText("拉开任一前门把手所有车门解锁");
                                break;
                        }
                    }
                    break;
                case 10:
                    if (((TextView) LZCadillacCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) LZCadillacCarSet.this.findViewById(R.id.tv_text3)).setText("在最后一扇门关闭并且有任意锁定命令延迟锁定");
                                break;
                            case 1:
                                ((TextView) LZCadillacCarSet.this.findViewById(R.id.tv_text3)).setText("最后一扇车门关闭，稍后自动锁定");
                                break;
                        }
                    }
                    break;
                case 11:
                    LZCadillacCarSet.this.setCheck((CheckedTextView) LZCadillacCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 12:
                    LZCadillacCarSet.this.setCheck((CheckedTextView) LZCadillacCarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 13:
                    LZCadillacCarSet.this.setCheck((CheckedTextView) LZCadillacCarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 14:
                    LZCadillacCarSet.this.setCheck((CheckedTextView) LZCadillacCarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 15:
                    LZCadillacCarSet.this.setCheck((CheckedTextView) LZCadillacCarSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 16:
                    LZCadillacCarSet.this.setCheck((CheckedTextView) LZCadillacCarSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 17:
                    LZCadillacCarSet.this.setCheck((CheckedTextView) LZCadillacCarSet.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 18:
                    LZCadillacCarSet.this.setCheck((CheckedTextView) LZCadillacCarSet.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 19:
                    LZCadillacCarSet.this.setCheck((CheckedTextView) LZCadillacCarSet.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 20:
                    if (((TextView) LZCadillacCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) LZCadillacCarSet.this.findViewById(R.id.tv_text4)).setText("5s");
                                break;
                            case 1:
                                ((TextView) LZCadillacCarSet.this.findViewById(R.id.tv_text4)).setText("15s");
                                break;
                            case 2:
                                ((TextView) LZCadillacCarSet.this.findViewById(R.id.tv_text4)).setText("30s");
                                break;
                            case 3:
                                ((TextView) LZCadillacCarSet.this.findViewById(R.id.tv_text4)).setText("90s");
                                break;
                            case 4:
                                ((TextView) LZCadillacCarSet.this.findViewById(R.id.tv_text4)).setText("2min");
                                break;
                            case 5:
                                ((TextView) LZCadillacCarSet.this.findViewById(R.id.tv_text4)).setText("3min");
                                break;
                            case 6:
                                ((TextView) LZCadillacCarSet.this.findViewById(R.id.tv_text4)).setText("4min");
                                break;
                        }
                    }
                    break;
                case 21:
                    LZCadillacCarSet.this.setCheck((CheckedTextView) LZCadillacCarSet.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 22:
                    LZCadillacCarSet.this.setCheck((CheckedTextView) LZCadillacCarSet.this.findViewById(R.id.ctv_checkedtext11), val == 1);
                    break;
                case 23:
                    if (((TextView) LZCadillacCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) LZCadillacCarSet.this.findViewById(R.id.tv_text5)).setText("普通");
                                break;
                            case 1:
                                ((TextView) LZCadillacCarSet.this.findViewById(R.id.tv_text5)).setText("高");
                                break;
                        }
                    }
                    break;
                case 24:
                    if (((TextView) LZCadillacCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) LZCadillacCarSet.this.findViewById(R.id.tv_text6)).setText("标准");
                                break;
                            case 1:
                                ((TextView) LZCadillacCarSet.this.findViewById(R.id.tv_text6)).setText("自定义");
                                break;
                        }
                    }
                    break;
                case 25:
                    LZCadillacCarSet.this.setCheck((CheckedTextView) LZCadillacCarSet.this.findViewById(R.id.ctv_checkedtext12), val == 1);
                    break;
                case 26:
                    if (((TextView) LZCadillacCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) LZCadillacCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.rzc_others_language_setting_1);
                                break;
                            case 1:
                                ((TextView) LZCadillacCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.rzc_others_language_setting_0);
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
        setContentView(R.layout.layout_0412_lz_cadillac_settings);
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
                int value = DataCanbus.DATA[11];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(3, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[8] - 1;
                if (value2 < 0) {
                    value2 = 3;
                }
                setCarInfo(0, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[8] + 1;
                if (value3 > 3) {
                    value3 = 0;
                }
                setCarInfo(0, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[9] - 1;
                if (value4 < 0) {
                    value4 = 1;
                }
                setCarInfo(1, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[9] + 1;
                if (value5 > 1) {
                    value5 = 0;
                }
                setCarInfo(1, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value6 = DataCanbus.DATA[10] - 1;
                if (value6 < 0) {
                    value6 = 1;
                }
                setCarInfo(2, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[10] + 1;
                if (value7 > 1) {
                    value7 = 0;
                }
                setCarInfo(2, value7);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value8 = DataCanbus.DATA[20] - 1;
                if (value8 < 0) {
                    value8 = 6;
                }
                setCarInfo(10, value8);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value9 = DataCanbus.DATA[20] + 1;
                if (value9 > 6) {
                    value9 = 0;
                }
                setCarInfo(10, value9);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value10 = DataCanbus.DATA[23] - 1;
                if (value10 < 0) {
                    value10 = 1;
                }
                setCarInfo(15, value10);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value11 = DataCanbus.DATA[23] + 1;
                if (value11 > 1) {
                    value11 = 0;
                }
                setCarInfo(15, value11);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value12 = DataCanbus.DATA[24] - 1;
                if (value12 < 0) {
                    value12 = 1;
                }
                setCarInfo(16, value12);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value13 = DataCanbus.DATA[24] + 1;
                if (value13 > 1) {
                    value13 = 0;
                }
                setCarInfo(16, value13);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value14 = DataCanbus.DATA[26] - 1;
                if (value14 < 0) {
                    value14 = 1;
                }
                setCarInfo(18, value14);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value15 = DataCanbus.DATA[26] + 1;
                if (value15 > 1) {
                    value15 = 0;
                }
                setCarInfo(18, value15);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value16 = DataCanbus.DATA[12];
                if (value16 == 1) {
                    value16 = 0;
                } else if (value16 == 0) {
                    value16 = 1;
                }
                setCarInfo(4, value16);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value17 = DataCanbus.DATA[13];
                if (value17 == 1) {
                    value17 = 0;
                } else if (value17 == 0) {
                    value17 = 1;
                }
                setCarInfo(5, value17);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value18 = DataCanbus.DATA[14];
                if (value18 == 1) {
                    value18 = 0;
                } else if (value18 == 0) {
                    value18 = 1;
                }
                setCarInfo(6, value18);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value19 = DataCanbus.DATA[15];
                if (value19 == 1) {
                    value19 = 0;
                } else if (value19 == 0) {
                    value19 = 1;
                }
                setCarInfo(7, value19);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value20 = DataCanbus.DATA[16];
                if (value20 == 1) {
                    value20 = 0;
                } else if (value20 == 0) {
                    value20 = 1;
                }
                setCarInfo(8, value20);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value21 = DataCanbus.DATA[17];
                if (value21 == 1) {
                    value21 = 0;
                } else if (value21 == 0) {
                    value21 = 1;
                }
                setCarInfo(9, value21);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value22 = DataCanbus.DATA[18];
                if (value22 == 1) {
                    value22 = 0;
                } else if (value22 == 0) {
                    value22 = 1;
                }
                setCarInfo(11, value22);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value23 = DataCanbus.DATA[19];
                if (value23 == 1) {
                    value23 = 0;
                } else if (value23 == 0) {
                    value23 = 1;
                }
                setCarInfo(12, value23);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int value24 = DataCanbus.DATA[21];
                if (value24 == 1) {
                    value24 = 0;
                } else if (value24 == 0) {
                    value24 = 1;
                }
                setCarInfo(13, value24);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                int value25 = DataCanbus.DATA[22];
                if (value25 == 1) {
                    value25 = 0;
                } else if (value25 == 0) {
                    value25 = 1;
                }
                setCarInfo(14, value25);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                int value26 = DataCanbus.DATA[25];
                if (value26 == 1) {
                    value26 = 0;
                } else if (value26 == 0) {
                    value26 = 1;
                }
                setCarInfo(17, value26);
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
        DataCanbus.PROXY.cmd(1, new int[]{56}, null, null);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
    }
}
