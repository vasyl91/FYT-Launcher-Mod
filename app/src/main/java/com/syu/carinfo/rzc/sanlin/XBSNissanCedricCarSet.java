package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class XBSNissanCedricCarSet extends BaseActivity implements View.OnClickListener {
    int unit = 0;
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    if (((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "km");
                        break;
                    }
                case 99:
                    if (((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (value >= 32768) {
                            ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text2)).setText("***km");
                            break;
                        } else {
                            ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "km");
                            break;
                        }
                    }
                    break;
                case 100:
                    if (((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (value == 65535) {
                            ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text3)).setText("----L/100km");
                            break;
                        } else {
                            ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10.0f) + CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                            break;
                        }
                    }
                    break;
                case 101:
                    XBSNissanCedricCarSet.this.setCheck((CheckedTextView) XBSNissanCedricCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 102:
                    XBSNissanCedricCarSet.this.setCheck((CheckedTextView) XBSNissanCedricCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 103:
                    XBSNissanCedricCarSet.this.setCheck((CheckedTextView) XBSNissanCedricCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 104:
                    XBSNissanCedricCarSet.this.setCheck((CheckedTextView) XBSNissanCedricCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 105:
                    if (((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text11)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 106:
                    if (((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text12)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text12)).setText("0S");
                                break;
                            case 1:
                                ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text12)).setText("15S");
                                break;
                            case 2:
                                ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text12)).setText("30S");
                                break;
                            case 3:
                                ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text12)).setText("45S");
                                break;
                            case 4:
                                ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text12)).setText("60S");
                                break;
                            case 5:
                                ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text12)).setText("90S");
                                break;
                            case 6:
                                ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text12)).setText("120S");
                                break;
                            case 7:
                                ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text12)).setText("150S");
                                break;
                            case 8:
                                ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text12)).setText("180S");
                                break;
                        }
                    }
                    break;
                case 107:
                    if (((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text8)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 108:
                    if (((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 109:
                    if (((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 110:
                    if (((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 111:
                    if (((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 112:
                    if (((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text9)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 113:
                    XBSNissanCedricCarSet.this.setCheck((CheckedTextView) XBSNissanCedricCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 114:
                    if (((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) XBSNissanCedricCarSet.this.findViewById(R.id.tv_text10)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_xbs_nissan_cedric_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                setCarAmpInfo(37, 49);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                setCarAmpInfo(37, 33);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                setCarAmpInfo(36, 49);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                setCarAmpInfo(36, 33);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                setCarAmpInfo(34, 49);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                setCarAmpInfo(34, 33);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                setCarAmpInfo(35, 49);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                setCarAmpInfo(35, 33);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                setCarAmpInfo(33, 49);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                setCarAmpInfo(33, 33);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                setCarAmpInfo(38, 49);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                setCarAmpInfo(38, 33);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                setCarAmpInfo(40, 49);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                setCarAmpInfo(40, 33);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                setCarInfo(2);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                setCarInfo(3);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                setCarInfo(4);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                setCarInfo(5);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value = DataCanbus.DATA[113];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarAmpInfo(39, value);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                setCarInfo(1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                setCarInfo(6);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                setCarInfo(8);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                setCarInfo(10);
                break;
        }
    }

    public void setCarInfo(int value0) {
        DataCanbus.PROXY.cmd(0, new int[]{value0}, null, null);
    }

    public void setCarAmpInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(1, new int[]{value0, value1}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(3, new int[]{107}, null, null);
        DataCanbus.PROXY.cmd(3, new int[]{109}, null, null);
        DataCanbus.PROXY.cmd(3, new int[]{147}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
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
    }

    @Override
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
    }
}
