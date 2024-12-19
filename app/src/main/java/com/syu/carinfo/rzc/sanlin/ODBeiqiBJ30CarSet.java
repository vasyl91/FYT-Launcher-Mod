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
public class ODBeiqiBJ30CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.ODBeiqiBJ30CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 100:
                    if (((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 2:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text1)).setText("10S");
                                break;
                            case 3:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text1)).setText("20S");
                                break;
                            case 4:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text1)).setText("30S");
                                break;
                            case 5:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text1)).setText("60S");
                                break;
                            case 6:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text1)).setText("120S");
                                break;
                            default:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 101:
                    if (((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 2:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text2)).setText("5km/h");
                                break;
                            case 3:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text2)).setText("10km/h");
                                break;
                            case 4:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text2)).setText("15km/h");
                                break;
                            case 5:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text2)).setText("20km/h");
                                break;
                            default:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 102:
                    ODBeiqiBJ30CarSet.this.setCheck((CheckedTextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 103:
                    ODBeiqiBJ30CarSet.this.setCheck((CheckedTextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 104:
                    if (((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (val) {
                            case 2:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text3)).setText("单色呼吸");
                                break;
                            case 3:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text3)).setText("双色呼吸");
                                break;
                            case 4:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text3)).setText("音乐律动模式");
                                break;
                            case 5:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text3)).setText("20km/h");
                                break;
                            default:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text3)).setText("单色静止");
                                break;
                        }
                    }
                    break;
                case 105:
                    if (((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 106:
                    if (((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text5)).setText("强制开启");
                                break;
                            default:
                                ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text5)).setText("跟随位置灯");
                                break;
                        }
                    }
                    break;
                case 107:
                    if (((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 108:
                    if (((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 109:
                    if (((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) ODBeiqiBJ30CarSet.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_od_beiqi_bj30_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
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
                int value = DataCanbus.DATA[102];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(3, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[100] - 1;
                if (value2 < 1) {
                    value2 = 6;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[100] + 1;
                if (value3 > 6) {
                    value3 = 1;
                }
                setCarInfo(1, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[101] - 1;
                if (value4 < 1) {
                    value4 = 5;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[101] + 1;
                if (value5 > 5) {
                    value5 = 1;
                }
                setCarInfo(2, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value6 = DataCanbus.DATA[104] - 1;
                if (value6 < 1) {
                    value6 = 5;
                }
                setCarInfo(5, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[104] + 1;
                if (value7 > 5) {
                    value7 = 1;
                }
                setCarInfo(5, value7);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value8 = DataCanbus.DATA[105] - 1;
                if (value8 < 1) {
                    value8 = 4;
                }
                setCarInfo(6, value8);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value9 = DataCanbus.DATA[105] + 1;
                if (value9 > 4) {
                    value9 = 1;
                }
                setCarInfo(6, value9);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value10 = DataCanbus.DATA[106] - 1;
                if (value10 < 0) {
                    value10 = 1;
                }
                setCarInfo(7, value10);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value11 = DataCanbus.DATA[106] + 1;
                if (value11 > 1) {
                    value11 = 0;
                }
                setCarInfo(7, value11);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value12 = DataCanbus.DATA[107];
                if (value12 > 0) {
                    value12--;
                }
                setCarInfo(8, value12);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value13 = DataCanbus.DATA[107];
                if (value13 < 255) {
                    value13++;
                }
                setCarInfo(8, value13);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value14 = DataCanbus.DATA[108];
                if (value14 > 0) {
                    value14--;
                }
                setCarInfo(9, value14);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value15 = DataCanbus.DATA[108];
                if (value15 < 255) {
                    value15++;
                }
                setCarInfo(9, value15);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value16 = DataCanbus.DATA[109] - 1;
                if (value16 < 1) {
                    value16 = 8;
                }
                setCarInfo(10, value16);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value17 = DataCanbus.DATA[109] + 1;
                if (value17 > 8) {
                    value17 = 1;
                }
                setCarInfo(10, value17);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value18 = DataCanbus.DATA[103];
                if (value18 == 1) {
                    value18 = 0;
                } else if (value18 == 0) {
                    value18 = 1;
                }
                setCarInfo(4, value18);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(3, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{65}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        setCarInfo(0, 1);
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
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
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
    }
}
