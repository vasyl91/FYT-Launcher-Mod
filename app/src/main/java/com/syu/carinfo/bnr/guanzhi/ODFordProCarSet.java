package com.syu.carinfo.bnr.guanzhi;

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
public class ODFordProCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.bnr.guanzhi.ODFordProCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 94:
                    ODFordProCarSet.this.setCheck((CheckedTextView) ODFordProCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 95:
                    if (((TextView) ODFordProCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODFordProCarSet.this.findViewById(R.id.tv_text1)).setText("0S");
                                break;
                            case 1:
                                ((TextView) ODFordProCarSet.this.findViewById(R.id.tv_text1)).setText("30S");
                                break;
                            case 2:
                                ((TextView) ODFordProCarSet.this.findViewById(R.id.tv_text1)).setText("60S");
                                break;
                            case 3:
                                ((TextView) ODFordProCarSet.this.findViewById(R.id.tv_text1)).setText("120S");
                                break;
                        }
                    }
                    break;
                case 96:
                    if (((TextView) ODFordProCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODFordProCarSet.this.findViewById(R.id.tv_text2)).setText("5min");
                                break;
                            case 1:
                                ((TextView) ODFordProCarSet.this.findViewById(R.id.tv_text2)).setText("10min");
                                break;
                            case 2:
                                ((TextView) ODFordProCarSet.this.findViewById(R.id.tv_text2)).setText("15min");
                                break;
                        }
                    }
                    break;
                case 97:
                    ODFordProCarSet.this.setCheck((CheckedTextView) ODFordProCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 98:
                    ODFordProCarSet.this.setCheck((CheckedTextView) ODFordProCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 99:
                    ODFordProCarSet.this.setCheck((CheckedTextView) ODFordProCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 100:
                    if (((TextView) ODFordProCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODFordProCarSet.this.findViewById(R.id.tv_text3)).setText("5min");
                                break;
                            case 1:
                                ((TextView) ODFordProCarSet.this.findViewById(R.id.tv_text3)).setText("10min");
                                break;
                        }
                    }
                    break;
                case 105:
                    ODFordProCarSet.this.setCheck((CheckedTextView) ODFordProCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 106:
                    ODFordProCarSet.this.setCheck((CheckedTextView) ODFordProCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 107:
                    ODFordProCarSet.this.setCheck((CheckedTextView) ODFordProCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 108:
                    ODFordProCarSet.this.setCheck((CheckedTextView) ODFordProCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 109:
                    ODFordProCarSet.this.setCheck((CheckedTextView) ODFordProCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_od_ford_pro_settings);
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
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[94];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[95] - 1;
                if (value2 < 0) {
                    value2 = 3;
                }
                setCarInfo(2, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[95] + 1;
                if (value3 > 3) {
                    value3 = 0;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[96] - 1;
                if (value4 < 0) {
                    value4 = 2;
                }
                setCarInfo(3, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[96] + 1;
                if (value5 > 2) {
                    value5 = 0;
                }
                setCarInfo(3, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value6 = DataCanbus.DATA[100] - 1;
                if (value6 < 0) {
                    value6 = 1;
                }
                setCarInfo(7, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[100] + 1;
                if (value7 > 1) {
                    value7 = 0;
                }
                setCarInfo(7, value7);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value8 = DataCanbus.DATA[97];
                if (value8 == 1) {
                    value8 = 0;
                } else if (value8 == 0) {
                    value8 = 1;
                }
                setCarInfo(4, value8);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value9 = DataCanbus.DATA[98];
                if (value9 == 1) {
                    value9 = 0;
                } else if (value9 == 0) {
                    value9 = 1;
                }
                setCarInfo(5, value9);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value10 = DataCanbus.DATA[99];
                if (value10 == 1) {
                    value10 = 0;
                } else if (value10 == 0) {
                    value10 = 1;
                }
                setCarInfo(6, value10);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value11 = DataCanbus.DATA[105];
                if (value11 == 1) {
                    value11 = 0;
                } else if (value11 == 0) {
                    value11 = 1;
                }
                setCarInfo(8, value11);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value12 = DataCanbus.DATA[106];
                if (value12 == 1) {
                    value12 = 0;
                } else if (value12 == 0) {
                    value12 = 1;
                }
                setCarInfo(9, value12);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value13 = DataCanbus.DATA[107];
                if (value13 == 1) {
                    value13 = 0;
                } else if (value13 == 0) {
                    value13 = 1;
                }
                setCarInfo(10, value13);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value14 = DataCanbus.DATA[108];
                if (value14 == 1) {
                    value14 = 0;
                } else if (value14 == 0) {
                    value14 = 1;
                }
                setCarInfo(11, value14);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value15 = DataCanbus.DATA[109];
                if (value15 == 1) {
                    value15 = 0;
                } else if (value15 == 0) {
                    value15 = 1;
                }
                setCarInfo(12, value15);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{65}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
    }
}
