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

public class XCTuleCDCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 130:
                    XCTuleCDCarSet.this.setCheck((CheckedTextView) XCTuleCDCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 131:
                    if (((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 132:
                    if (((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 133:
                    XCTuleCDCarSet.this.setCheck((CheckedTextView) XCTuleCDCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 134:
                    XCTuleCDCarSet.this.setCheck((CheckedTextView) XCTuleCDCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 135:
                    XCTuleCDCarSet.this.setCheck((CheckedTextView) XCTuleCDCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 136:
                    XCTuleCDCarSet.this.setCheck((CheckedTextView) XCTuleCDCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 137:
                    XCTuleCDCarSet.this.setCheck((CheckedTextView) XCTuleCDCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 138:
                    if (((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 139:
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
                case 140:
                    if (((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 141:
                    if (((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 142:
                    if (((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 143:
                    if (((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 144:
                    if (((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 145:
                    if (((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 146:
                    XCTuleCDCarSet.this.setCheck((CheckedTextView) XCTuleCDCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 147:
                    if (((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 148:
                    XCTuleCDCarSet.this.setCheck((CheckedTextView) XCTuleCDCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 162:
                    XCTuleCDCarSet.this.setCheck((CheckedTextView) XCTuleCDCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 163:
                    XCTuleCDCarSet.this.setCheck((CheckedTextView) XCTuleCDCarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 164:
                    XCTuleCDCarSet.this.setCheck((CheckedTextView) XCTuleCDCarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 165:
                    if (((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 166:
                    if (((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text13)) != null) {
                        ((TextView) XCTuleCDCarSet.this.findViewById(R.id.tv_text13)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 167:
                    XCTuleCDCarSet.this.setCheck((CheckedTextView) XCTuleCDCarSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 168:
                    XCTuleCDCarSet.this.setCheck((CheckedTextView) XCTuleCDCarSet.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 169:
                    XCTuleCDCarSet.this.setCheck((CheckedTextView) XCTuleCDCarSet.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 170:
                    XCTuleCDCarSet.this.setCheck((CheckedTextView) XCTuleCDCarSet.this.findViewById(R.id.ctv_checkedtext15), value == 1);
                    break;
                case 171:
                    XCTuleCDCarSet.this.setCheck((CheckedTextView) XCTuleCDCarSet.this.findViewById(R.id.ctv_checkedtext16), value == 1);
                    break;
                case 172:
                    XCTuleCDCarSet.this.setCheck((CheckedTextView) XCTuleCDCarSet.this.findViewById(R.id.ctv_checkedtext17), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_xc_nissan_tule_cd_settings);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                setD34CarInfo(2);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                setD34CarInfo(3);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                setD34CarInfo(4);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                setD34CarInfo(5);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                setD35CarInfo(2);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                setD35CarInfo(3);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                setD35CarInfo(4);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                setD35CarInfo(5);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                setD83CarInfo(33, 49);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                setD83CarInfo(33, 33);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                setD83CarInfo(34, 49);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                setD83CarInfo(34, 33);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                setD83CarInfo(35, 49);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                setD83CarInfo(35, 33);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                setD83CarInfo(36, 49);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                setD83CarInfo(36, 33);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                setD83CarInfo(37, 49);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                setD83CarInfo(37, 33);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                setD83CarInfo(38, 49);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                setD83CarInfo(38, 33);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                setD83CarInfo(40, 49);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                setD83CarInfo(40, 33);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                setD36CarInfo(4);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                setD36CarInfo(5);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                setD36CarInfo(6);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                setD36CarInfo(7);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                setD34CarInfo(1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                setD35CarInfo(17);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                setD35CarInfo(8);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                setD35CarInfo(7);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                setD35CarInfo(6);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                setD35CarInfo(1);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value = DataCanbus.DATA[146];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setD83CarInfo(39, value);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value2 = DataCanbus.DATA[148];
                if (value2 == 1) {
                    value2 = 0;
                } else if (value2 == 0) {
                    value2 = 1;
                }
                setD83CarInfo(41, value2);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                setD36CarInfo(1);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                setD36CarInfo(2);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                setD36CarInfo(3);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                setD37CarInfo(6);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                setD37CarInfo(5);
                break;
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                setD37CarInfo(4);
                break;
            case R.id.ctv_checkedtext15 /* 2131427557 */:
                setD37CarInfo(3);
                break;
            case R.id.ctv_checkedtext16 /* 2131427558 */:
                setD37CarInfo(2);
                break;
            case R.id.ctv_checkedtext17 /* 2131427559 */:
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

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        setD90CarInfo(108, 0);
        setD90CarInfo(109, 0);
        setD90CarInfo(147, 0);
        setD90CarInfo(112, 0);
        setD90CarInfo(113, 0);
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
    }
}
