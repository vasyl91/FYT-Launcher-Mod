package com.syu.carinfo.xc.tule;

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
public class XCTuleCDCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xc.tule.XCTuleCDCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 118:
                    XCTuleCDCarSet.this.setCheck((CheckedTextView) XCTuleCDCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 119:
                    if (((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 120:
                    if (((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 121:
                    XCTuleCDCarSet.this.setCheck((CheckedTextView) XCTuleCDCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 122:
                    XCTuleCDCarSet.this.setCheck((CheckedTextView) XCTuleCDCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 123:
                    XCTuleCDCarSet.this.setCheck((CheckedTextView) XCTuleCDCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 124:
                    XCTuleCDCarSet.this.setCheck((CheckedTextView) XCTuleCDCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 125:
                    XCTuleCDCarSet.this.setCheck((CheckedTextView) XCTuleCDCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 126:
                    if (((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 127:
                    if (((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text4)).setText("0S");
                                break;
                            case 1:
                                ((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text4)).setText("15S");
                                break;
                            case 2:
                                ((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text4)).setText("30S");
                                break;
                            case 3:
                                ((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text4)).setText("45S");
                                break;
                            case 4:
                                ((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text4)).setText("60S");
                                break;
                            case 5:
                                ((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text4)).setText("90S");
                                break;
                            case 6:
                                ((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text4)).setText("120S");
                                break;
                            case 7:
                                ((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text4)).setText("150S");
                                break;
                            case 8:
                                ((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text4)).setText("180S");
                                break;
                        }
                    }
                    break;
                case 128:
                    if (((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 129:
                    if (((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 130:
                    if (((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 131:
                    if (((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 132:
                    if (((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 133:
                    if (((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 134:
                    XCTuleCDCarSet.this.setCheck((CheckedTextView) XCTuleCDCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 135:
                    if (((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 136:
                    XCTuleCDCarSet.this.setCheck((CheckedTextView) XCTuleCDCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 150:
                    XCTuleCDCarSet.this.setCheck((CheckedTextView) XCTuleCDCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 151:
                    XCTuleCDCarSet.this.setCheck((CheckedTextView) XCTuleCDCarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 152:
                    XCTuleCDCarSet.this.setCheck((CheckedTextView) XCTuleCDCarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 153:
                    if (((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 154:
                    if (((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text13)) != null) {
                        ((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text13)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 155:
                    XCTuleCDCarSet.this.setCheck((CheckedTextView) XCTuleCDCarSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 156:
                    XCTuleCDCarSet.this.setCheck((CheckedTextView) XCTuleCDCarSet.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 157:
                    XCTuleCDCarSet.this.setCheck((CheckedTextView) XCTuleCDCarSet.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 158:
                    XCTuleCDCarSet.this.setCheck((CheckedTextView) XCTuleCDCarSet.this.findViewById(R.id.ctv_checkedtext15), value == 1);
                    break;
                case 159:
                    XCTuleCDCarSet.this.setCheck((CheckedTextView) XCTuleCDCarSet.this.findViewById(R.id.ctv_checkedtext16), value == 1);
                    break;
                case 160:
                    XCTuleCDCarSet.this.setCheck((CheckedTextView) XCTuleCDCarSet.this.findViewById(R.id.ctv_checkedtext17), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_xc_nissan_tule_cd_settings);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext17), this);
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
        setSelfClick((Button) findViewById(R.id.btn_minus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
        setSelfClick((Button) findViewById(R.id.btn_minus12), this);
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
        setSelfClick((Button) findViewById(R.id.btn_minus13), this);
        setSelfClick((Button) findViewById(R.id.btn_plus13), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus13 /* 2131427468 */:
                setD36CarInfo(6);
                break;
            case R.id.btn_plus13 /* 2131427470 */:
                setD36CarInfo(7);
                break;
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                setD34CarInfo(1);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                setD34CarInfo(2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                setD34CarInfo(3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                setD34CarInfo(4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                setD34CarInfo(5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                setD35CarInfo(2);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                setD35CarInfo(3);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                setD35CarInfo(4);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                setD35CarInfo(5);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                setD83CarInfo(33, 49);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                setD83CarInfo(33, 33);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                setD83CarInfo(34, 49);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                setD83CarInfo(34, 33);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                setD83CarInfo(35, 49);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                setD83CarInfo(35, 33);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                setD83CarInfo(36, 49);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                setD83CarInfo(36, 33);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                setD83CarInfo(37, 49);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                setD83CarInfo(37, 33);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                setD83CarInfo(38, 49);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                setD83CarInfo(38, 33);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                setD83CarInfo(40, 49);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                setD83CarInfo(40, 33);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                setD36CarInfo(4);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                setD36CarInfo(5);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                setD35CarInfo(17);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                setD35CarInfo(8);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                setD35CarInfo(7);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                setD35CarInfo(6);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                setD35CarInfo(1);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value = DataCanbus.DATA[134];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setD83CarInfo(39, value);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value2 = DataCanbus.DATA[136];
                if (value2 == 1) {
                    value2 = 0;
                } else if (value2 == 0) {
                    value2 = 1;
                }
                setD83CarInfo(41, value2);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                setD36CarInfo(1);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                setD36CarInfo(2);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                setD36CarInfo(3);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                setD37CarInfo(6);
                break;
            case R.id.ctv_checkedtext13 /* 2131427545 */:
                setD37CarInfo(5);
                break;
            case R.id.ctv_checkedtext14 /* 2131427546 */:
                setD37CarInfo(4);
                break;
            case R.id.ctv_checkedtext15 /* 2131427547 */:
                setD37CarInfo(3);
                break;
            case R.id.ctv_checkedtext16 /* 2131427548 */:
                setD37CarInfo(2);
                break;
            case R.id.ctv_checkedtext17 /* 2131427647 */:
                setD37CarInfo(1);
                break;
        }
    }

    void setD34CarInfo(int value0) {
        DataCanbus.PROXY.cmd(0, new int[]{value0}, null, null);
    }

    void setD35CarInfo(int value0) {
        DataCanbus.PROXY.cmd(1, new int[]{value0}, null, null);
    }

    void setD83CarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1}, null, null);
    }

    void setD36CarInfo(int value0) {
        DataCanbus.PROXY.cmd(3, new int[]{value0}, null, null);
    }

    void setD37CarInfo(int value0) {
        DataCanbus.PROXY.cmd(4, new int[]{value0}, null, null);
    }

    void setD90CarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(5, new int[]{value0, value1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        setD90CarInfo(108, 0);
        setD90CarInfo(109, 0);
        setD90CarInfo(147, 0);
        setD90CarInfo(112, 0);
        setD90CarInfo(113, 0);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
    }
}
