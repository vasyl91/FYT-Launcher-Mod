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
public class ODQiruiXiaomayiCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.ODQiruiXiaomayiCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 21:
                    ODQiruiXiaomayiCarInfo.this.setCheck((CheckedTextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 22:
                    ODQiruiXiaomayiCarInfo.this.setCheck((CheckedTextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 23:
                    ODQiruiXiaomayiCarInfo.this.setCheck((CheckedTextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 24:
                    ODQiruiXiaomayiCarInfo.this.setCheck((CheckedTextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 25:
                    ODQiruiXiaomayiCarInfo.this.setCheck((CheckedTextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 26:
                    ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                    break;
                case 27:
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
                case 28:
                    ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km");
                    break;
                case 29:
                    ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + "kWh/100km");
                    break;
                case 30:
                    ODQiruiXiaomayiCarInfo.this.setCheck((CheckedTextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 31:
                    ODQiruiXiaomayiCarInfo.this.setCheck((CheckedTextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 32:
                    ODQiruiXiaomayiCarInfo.this.setCheck((CheckedTextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.ctv_checkedtext8), value == 1);
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
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{65}, null, null);
        DataCanbus.PROXY.cmd(1, new int[]{68}, null, null);
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
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[21];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(145, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[26] - 1;
                if (value2 < 1) {
                    value2 = 7;
                }
                setCarInfo(146, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[26] + 1;
                if (value3 > 7) {
                    value3 = 1;
                }
                setCarInfo(146, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[27] - 1;
                if (value4 < 0) {
                    value4 = 7;
                }
                setCarInfo(151, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[27] + 1;
                if (value5 > 7) {
                    value5 = 0;
                }
                setCarInfo(151, value5);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value6 = DataCanbus.DATA[22];
                if (value6 == 1) {
                    value6 = 0;
                } else if (value6 == 0) {
                    value6 = 1;
                }
                setCarInfo(147, value6);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value7 = DataCanbus.DATA[23];
                if (value7 == 1) {
                    value7 = 0;
                } else if (value7 == 0) {
                    value7 = 1;
                }
                setCarInfo(148, value7);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value8 = DataCanbus.DATA[24];
                if (value8 == 1) {
                    value8 = 0;
                } else if (value8 == 0) {
                    value8 = 1;
                }
                setCarInfo(149, value8);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value9 = DataCanbus.DATA[25];
                if (value9 == 1) {
                    value9 = 0;
                } else if (value9 == 0) {
                    value9 = 1;
                }
                setCarInfo(150, value9);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value10 = DataCanbus.DATA[30];
                if (value10 == 1) {
                    value10 = 0;
                } else if (value10 == 0) {
                    value10 = 1;
                }
                setCarInfo(152, value10);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value11 = DataCanbus.DATA[31];
                if (value11 == 1) {
                    value11 = 0;
                } else if (value11 == 0) {
                    value11 = 1;
                }
                setCarInfo(153, value11);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value12 = DataCanbus.DATA[32];
                if (value12 == 1) {
                    value12 = 0;
                } else if (value12 == 0) {
                    value12 = 1;
                }
                setCarInfo(154, value12);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
    }
}
