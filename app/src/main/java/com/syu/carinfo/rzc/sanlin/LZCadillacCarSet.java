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

@SuppressWarnings({"deprecation", "unchecked"})
public class LZCadillacCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
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
                case 100:
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
                case 101:
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
                case 102:
                    LZCadillacCarSet.this.setCheck((CheckedTextView) LZCadillacCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 103:
                    LZCadillacCarSet.this.setCheck((CheckedTextView) LZCadillacCarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 104:
                    LZCadillacCarSet.this.setCheck((CheckedTextView) LZCadillacCarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 105:
                    LZCadillacCarSet.this.setCheck((CheckedTextView) LZCadillacCarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 106:
                    LZCadillacCarSet.this.setCheck((CheckedTextView) LZCadillacCarSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 107:
                    LZCadillacCarSet.this.setCheck((CheckedTextView) LZCadillacCarSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 108:
                    LZCadillacCarSet.this.setCheck((CheckedTextView) LZCadillacCarSet.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 109:
                    LZCadillacCarSet.this.setCheck((CheckedTextView) LZCadillacCarSet.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 110:
                    LZCadillacCarSet.this.setCheck((CheckedTextView) LZCadillacCarSet.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 111:
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
                case 112:
                    LZCadillacCarSet.this.setCheck((CheckedTextView) LZCadillacCarSet.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 113:
                    LZCadillacCarSet.this.setCheck((CheckedTextView) LZCadillacCarSet.this.findViewById(R.id.ctv_checkedtext11), val == 1);
                    break;
                case 114:
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
                case 115:
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
                case 116:
                    LZCadillacCarSet.this.setCheck((CheckedTextView) LZCadillacCarSet.this.findViewById(R.id.ctv_checkedtext12), val == 1);
                    break;
                case 117:
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0412_lz_cadillac_settings);
        init();
    }

    @Override
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[99] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(0, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[99] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(0, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[100] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCarInfo(1, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[100] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarInfo(1, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[101] - 1;
                if (value5 < 0) {
                    value5 = 1;
                }
                setCarInfo(2, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[101] + 1;
                if (value6 > 1) {
                    value6 = 0;
                }
                setCarInfo(2, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[111] - 1;
                if (value7 < 0) {
                    value7 = 6;
                }
                setCarInfo(10, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[111] + 1;
                if (value8 > 6) {
                    value8 = 0;
                }
                setCarInfo(10, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[114] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarInfo(15, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[114] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarInfo(15, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[115] - 1;
                if (value11 < 0) {
                    value11 = 1;
                }
                setCarInfo(16, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[115] + 1;
                if (value12 > 1) {
                    value12 = 0;
                }
                setCarInfo(16, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[117] - 1;
                if (value13 < 0) {
                    value13 = 1;
                }
                setCarInfo(18, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[117] + 1;
                if (value14 > 1) {
                    value14 = 0;
                }
                setCarInfo(18, value14);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value15 = DataCanbus.DATA[102];
                if (value15 == 1) {
                    value15 = 0;
                } else if (value15 == 0) {
                    value15 = 1;
                }
                setCarInfo(3, value15);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value16 = DataCanbus.DATA[103];
                if (value16 == 1) {
                    value16 = 0;
                } else if (value16 == 0) {
                    value16 = 1;
                }
                setCarInfo(4, value16);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value17 = DataCanbus.DATA[104];
                if (value17 == 1) {
                    value17 = 0;
                } else if (value17 == 0) {
                    value17 = 1;
                }
                setCarInfo(5, value17);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value18 = DataCanbus.DATA[105];
                if (value18 == 1) {
                    value18 = 0;
                } else if (value18 == 0) {
                    value18 = 1;
                }
                setCarInfo(6, value18);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value19 = DataCanbus.DATA[106];
                if (value19 == 1) {
                    value19 = 0;
                } else if (value19 == 0) {
                    value19 = 1;
                }
                setCarInfo(7, value19);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value20 = DataCanbus.DATA[107];
                if (value20 == 1) {
                    value20 = 0;
                } else if (value20 == 0) {
                    value20 = 1;
                }
                setCarInfo(8, value20);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value21 = DataCanbus.DATA[108];
                if (value21 == 1) {
                    value21 = 0;
                } else if (value21 == 0) {
                    value21 = 1;
                }
                setCarInfo(9, value21);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value22 = DataCanbus.DATA[109];
                if (value22 == 1) {
                    value22 = 0;
                } else if (value22 == 0) {
                    value22 = 1;
                }
                setCarInfo(11, value22);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value23 = DataCanbus.DATA[110];
                if (value23 == 1) {
                    value23 = 0;
                } else if (value23 == 0) {
                    value23 = 1;
                }
                setCarInfo(12, value23);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int value24 = DataCanbus.DATA[112];
                if (value24 == 1) {
                    value24 = 0;
                } else if (value24 == 0) {
                    value24 = 1;
                }
                setCarInfo(13, value24);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                int value25 = DataCanbus.DATA[113];
                if (value25 == 1) {
                    value25 = 0;
                } else if (value25 == 0) {
                    value25 = 1;
                }
                setCarInfo(14, value25);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                int value26 = DataCanbus.DATA[116];
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

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.PROXY.cmd(1, new int[]{56}, null, null);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
    }
}
