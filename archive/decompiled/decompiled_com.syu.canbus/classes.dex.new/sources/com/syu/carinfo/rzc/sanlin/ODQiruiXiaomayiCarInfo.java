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
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ODQiruiXiaomayiCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.ODQiruiXiaomayiCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    ODQiruiXiaomayiCarInfo.this.setCheck((CheckedTextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 99:
                    ODQiruiXiaomayiCarInfo.this.setCheck((CheckedTextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 100:
                    ODQiruiXiaomayiCarInfo.this.setCheck((CheckedTextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 101:
                    ODQiruiXiaomayiCarInfo.this.setCheck((CheckedTextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 102:
                    ODQiruiXiaomayiCarInfo.this.setCheck((CheckedTextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 103:
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_455_OD_Qirui_RuihuE /* 15270343 */:
                            switch (value) {
                                case 0:
                                    ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_low);
                                    break;
                                case 1:
                                    ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_middle);
                                    break;
                                case 2:
                                    ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_high);
                                    break;
                            }
                            break;
                        default:
                            ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                            break;
                    }
                    break;
                case 104:
                    switch (value) {
                        case 0:
                            ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text4)).setText("1小时");
                            break;
                        case 2:
                            ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text4)).setText("1.5小时");
                            break;
                        case 3:
                            ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text4)).setText("2小时");
                            break;
                        case 4:
                            ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text4)).setText("2.5小时");
                            break;
                        case 5:
                            ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text4)).setText("3小时");
                            break;
                        case 6:
                            ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text4)).setText("3.5小时");
                            break;
                        case 7:
                            ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text4)).setText("4小时");
                            break;
                    }
                    break;
                case 105:
                    ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km");
                    break;
                case 106:
                    ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + "kWh/100km");
                    break;
                case 107:
                    ODQiruiXiaomayiCarInfo.this.setCheck((CheckedTextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 108:
                    ODQiruiXiaomayiCarInfo.this.setCheck((CheckedTextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 109:
                    ODQiruiXiaomayiCarInfo.this.setCheck((CheckedTextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 110:
                    ODQiruiXiaomayiCarInfo.this.setCheck((CheckedTextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 111:
                    switch (value) {
                        case 0:
                            ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text5)).setText("灯光+喇叭");
                            break;
                        case 1:
                            ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text5)).setText("灯光");
                            break;
                        case 2:
                            ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text5)).setText("喇叭");
                            break;
                    }
                    break;
                case 112:
                    ODQiruiXiaomayiCarInfo.this.setCheck((CheckedTextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 113:
                    ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                    break;
                case 114:
                    ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append((value + 5) * 5).toString());
                    break;
                case 115:
                    ODQiruiXiaomayiCarInfo.this.setCheck((CheckedTextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 116:
                    ODQiruiXiaomayiCarInfo.this.setCheck((CheckedTextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 117:
                    ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + "s");
                    break;
                case 118:
                    ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                    break;
                case 119:
                    ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                    break;
                case 120:
                    ODQiruiXiaomayiCarInfo.this.setCheck((CheckedTextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_od_xiaomayi_carinfo);
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
        findViewById(R.id.layout_view1).setVisibility(8);
        findViewById(R.id.layout_view2).setVisibility(8);
        findViewById(R.id.layout_view3).setVisibility(8);
        findViewById(R.id.layout_view4).setVisibility(8);
        findViewById(R.id.layout_view5).setVisibility(8);
        findViewById(R.id.layout_view6).setVisibility(8);
        findViewById(R.id.layout_view7).setVisibility(8);
        findViewById(R.id.layout_view8).setVisibility(8);
        findViewById(R.id.layout_view9).setVisibility(8);
        findViewById(R.id.layout_view10).setVisibility(8);
        findViewById(R.id.layout_view11).setVisibility(8);
        findViewById(R.id.layout_view12).setVisibility(8);
        findViewById(R.id.layout_view13).setVisibility(8);
        findViewById(R.id.layout_view14).setVisibility(8);
        findViewById(R.id.layout_view15).setVisibility(8);
        findViewById(R.id.layout_text_view1).setVisibility(8);
        findViewById(R.id.layout_view16).setVisibility(8);
        findViewById(R.id.layout_view17).setVisibility(8);
        findViewById(R.id.layout_view18).setVisibility(8);
        findViewById(R.id.layout_text_view2).setVisibility(8);
        findViewById(R.id.layout_view19).setVisibility(8);
        findViewById(R.id.layout_view20).setVisibility(8);
        findViewById(R.id.layout_view21).setVisibility(8);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_452_OD_Qirui_Xiaomayi /* 12517828 */:
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                break;
            case FinalCanbus.CAR_455_OD_Qirui_RuihuE /* 15270343 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{65, 0}, null, null);
        DataCanbus.PROXY.cmd(1, new int[]{68, 0}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[103] - 1;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_455_OD_Qirui_RuihuE /* 15270343 */:
                        if (value < 0) {
                            value = 2;
                        }
                        break;
                    default:
                        if (value < 1) {
                            value = 7;
                        }
                        break;
                }
                setCarInfo(146, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[103] + 1;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_455_OD_Qirui_RuihuE /* 15270343 */:
                        if (value2 > 2) {
                            value2 = 0;
                        }
                        break;
                    default:
                        if (value2 > 7) {
                            value2 = 1;
                        }
                        break;
                }
                setCarInfo(146, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[104] - 1;
                if (value3 < 0) {
                    value3 = 7;
                }
                setCarInfo(151, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[104] + 1;
                if (value4 > 7) {
                    value4 = 0;
                }
                setCarInfo(151, value4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[111] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(162, value5);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[111] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(162, value6);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[113] - 1;
                if (value7 < 1) {
                    value7 = 15;
                }
                setCarInfo(163, value7);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[113] + 1;
                if (value8 > 15) {
                    value8 = 1;
                }
                setCarInfo(163, value8);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[114] - 1;
                if (value9 < 1) {
                    value9 = 63;
                }
                setCarInfo(164, value9);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[114] + 1;
                if (value10 > 63) {
                    value10 = 1;
                }
                setCarInfo(164, value10);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value11 = DataCanbus.DATA[117] - 1;
                if (value11 < 1) {
                    value11 = 10;
                }
                setCarInfo(159, value11);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value12 = DataCanbus.DATA[117] + 1;
                if (value12 > 10) {
                    value12 = 1;
                }
                setCarInfo(159, value12);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value13 = DataCanbus.DATA[118] - 1;
                if (value13 < 1) {
                    value13 = 15;
                }
                setCarInfo(157, value13);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value14 = DataCanbus.DATA[118] + 1;
                if (value14 > 15) {
                    value14 = 1;
                }
                setCarInfo(157, value14);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value15 = DataCanbus.DATA[119] - 1;
                if (value15 < 1) {
                    value15 = 7;
                }
                setCarInfo(156, value15);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value16 = DataCanbus.DATA[119] + 1;
                if (value16 > 7) {
                    value16 = 1;
                }
                setCarInfo(156, value16);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value17 = DataCanbus.DATA[98];
                if (value17 == 1) {
                    value17 = 0;
                } else if (value17 == 0) {
                    value17 = 1;
                }
                setCarInfo(145, value17);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int value18 = DataCanbus.DATA[101];
                if (value18 == 1) {
                    value18 = 0;
                } else if (value18 == 0) {
                    value18 = 1;
                }
                setCarInfo(149, value18);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int value19 = DataCanbus.DATA[102];
                if (value19 == 1) {
                    value19 = 0;
                } else if (value19 == 0) {
                    value19 = 1;
                }
                setCarInfo(150, value19);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value20 = DataCanbus.DATA[99];
                if (value20 == 1) {
                    value20 = 0;
                } else if (value20 == 0) {
                    value20 = 1;
                }
                setCarInfo(147, value20);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int value21 = DataCanbus.DATA[100];
                if (value21 == 1) {
                    value21 = 0;
                } else if (value21 == 0) {
                    value21 = 1;
                }
                setCarInfo(148, value21);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int value22 = DataCanbus.DATA[107];
                if (value22 == 1) {
                    value22 = 0;
                } else if (value22 == 0) {
                    value22 = 1;
                }
                setCarInfo(152, value22);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                int value23 = DataCanbus.DATA[108];
                if (value23 == 1) {
                    value23 = 0;
                } else if (value23 == 0) {
                    value23 = 1;
                }
                setCarInfo(153, value23);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                int value24 = DataCanbus.DATA[109];
                if (value24 == 1) {
                    value24 = 0;
                } else if (value24 == 0) {
                    value24 = 1;
                }
                setCarInfo(154, value24);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                int value25 = DataCanbus.DATA[110];
                if (value25 == 1) {
                    value25 = 0;
                } else if (value25 == 0) {
                    value25 = 1;
                }
                setCarInfo(160, value25);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                int value26 = DataCanbus.DATA[112];
                if (value26 == 1) {
                    value26 = 0;
                } else if (value26 == 0) {
                    value26 = 1;
                }
                setCarInfo(161, value26);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                int value27 = DataCanbus.DATA[115];
                if (value27 == 1) {
                    value27 = 0;
                } else if (value27 == 0) {
                    value27 = 1;
                }
                setCarInfo(158, value27);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                int value28 = DataCanbus.DATA[116];
                if (value28 == 1) {
                    value28 = 0;
                } else if (value28 == 0) {
                    value28 = 1;
                }
                setCarInfo(165, value28);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                int value29 = DataCanbus.DATA[120];
                if (value29 == 1) {
                    value29 = 0;
                } else if (value29 == 0) {
                    value29 = 1;
                }
                setCarInfo(155, value29);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
    }
}
