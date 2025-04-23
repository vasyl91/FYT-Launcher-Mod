package com.syu.carinfo.rzc.klc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class RZC_GMChargeSet3InfoAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 230:
                    if (((TextView) RZC_GMChargeSet3InfoAct.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZC_GMChargeSet3InfoAct.this.findViewById(R.id.tv_text1)).setText("6A");
                                break;
                            case 1:
                                ((TextView) RZC_GMChargeSet3InfoAct.this.findViewById(R.id.tv_text1)).setText("8A");
                                break;
                        }
                    }
                    break;
                case 231:
                    if (((TextView) RZC_GMChargeSet3InfoAct.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 4:
                                ((TextView) RZC_GMChargeSet3InfoAct.this.findViewById(R.id.tv_text2)).setText("40% 192km");
                                break;
                            case 5:
                                ((TextView) RZC_GMChargeSet3InfoAct.this.findViewById(R.id.tv_text2)).setText("50% 243km");
                                break;
                            case 6:
                                ((TextView) RZC_GMChargeSet3InfoAct.this.findViewById(R.id.tv_text2)).setText("60% 295km");
                                break;
                            case 7:
                                ((TextView) RZC_GMChargeSet3InfoAct.this.findViewById(R.id.tv_text2)).setText("70% 347km");
                                break;
                            case 8:
                                ((TextView) RZC_GMChargeSet3InfoAct.this.findViewById(R.id.tv_text2)).setText("80% 401km");
                                break;
                            case 9:
                                ((TextView) RZC_GMChargeSet3InfoAct.this.findViewById(R.id.tv_text2)).setText("90% 458km");
                                break;
                            case 10:
                                ((TextView) RZC_GMChargeSet3InfoAct.this.findViewById(R.id.tv_text2)).setText("100% 518km");
                                break;
                            default:
                                ((TextView) RZC_GMChargeSet3InfoAct.this.findViewById(R.id.tv_text2)).setText("---");
                                break;
                        }
                    }
                    break;
                case 232:
                    RZC_GMChargeSet3InfoAct.this.setCheck((CheckedTextView) RZC_GMChargeSet3InfoAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 233:
                    RZC_GMChargeSet3InfoAct.this.setCheck((CheckedTextView) RZC_GMChargeSet3InfoAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 234:
                    if (((TextView) RZC_GMChargeSet3InfoAct.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) RZC_GMChargeSet3InfoAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + "km");
                        break;
                    }
                case 235:
                    if (((TextView) RZC_GMChargeSet3InfoAct.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) RZC_GMChargeSet3InfoAct.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 236:
                    if (((TextView) RZC_GMChargeSet3InfoAct.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) RZC_GMChargeSet3InfoAct.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 237:
                    if (((TextView) RZC_GMChargeSet3InfoAct.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) RZC_GMChargeSet3InfoAct.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 238:
                    if (((TextView) RZC_GMChargeSet3InfoAct.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) RZC_GMChargeSet3InfoAct.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0061_rzc_gm_charge_setinf3);
        init();
    }

    @Override
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[230];
                if (value == 1) {
                    value = 1;
                } else if (value == 0) {
                    value = 2;
                }
                setCarInfo(1, value, 0, 0);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[230];
                if (value2 == 1) {
                    value2 = 1;
                } else if (value2 == 0) {
                    value2 = 2;
                }
                setCarInfo(1, value2, 0, 0);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[231];
                if (value3 > 4) {
                    value3--;
                }
                setCarInfo(2, value3, 0, 0);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[231];
                if (value4 < 10) {
                    value4++;
                }
                setCarInfo(2, value4, 0, 0);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int hour = DataCanbus.DATA[235];
                int min = DataCanbus.DATA[236];
                int hour2 = hour - 1;
                if (hour2 < 0) {
                    hour2 = 23;
                }
                setCarInfo(4, hour2, min, 0);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int hour3 = DataCanbus.DATA[235];
                int min2 = DataCanbus.DATA[236];
                int hour4 = hour3 + 1;
                if (hour4 > 23) {
                    hour4 = 0;
                }
                setCarInfo(4, hour4, min2, 0);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int hour5 = DataCanbus.DATA[235];
                int min3 = DataCanbus.DATA[236] - 1;
                if (min3 < 0) {
                    min3 = 59;
                }
                setCarInfo(4, hour5, min3, 0);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int hour6 = DataCanbus.DATA[235];
                int min4 = DataCanbus.DATA[236] + 1;
                if (min4 > 59) {
                    min4 = 0;
                }
                setCarInfo(4, hour6, min4, 0);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int hour7 = DataCanbus.DATA[237];
                int min5 = DataCanbus.DATA[238];
                int hour8 = hour7 - 1;
                if (hour8 < 0) {
                    hour8 = 23;
                }
                setCarInfo(5, hour8, min5, 0);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int hour9 = DataCanbus.DATA[237];
                int min6 = DataCanbus.DATA[238];
                int hour10 = hour9 + 1;
                if (hour10 > 23) {
                    hour10 = 0;
                }
                setCarInfo(5, hour10, min6, 0);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int hour11 = DataCanbus.DATA[237];
                int min7 = DataCanbus.DATA[238] - 1;
                if (min7 < 0) {
                    min7 = 59;
                }
                setCarInfo(5, hour11, min7, 0);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int hour12 = DataCanbus.DATA[237];
                int min8 = DataCanbus.DATA[238] + 1;
                if (min8 > 59) {
                    min8 = 0;
                }
                setCarInfo(5, hour12, min8, 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value5 = DataCanbus.DATA[232];
                if (value5 == 1) {
                    value5 = 0;
                } else if (value5 == 0) {
                    value5 = 1;
                }
                setCarInfo(3, value5, 0, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value6 = DataCanbus.DATA[233];
                if (value6 == 1) {
                    value6 = 0;
                } else if (value6 == 0) {
                    value6 = 1;
                }
                setCarInfo(6, value6, 0, 0);
                break;
        }
    }

    public void setCarInfo(int value1, int value2, int value3, int value4) {
        DataCanbus.PROXY.cmd(12, new int[]{value1, value2, value3, value4}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(11, new int[]{81, 1}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[230].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[231].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[232].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[233].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[234].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[235].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[236].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[237].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[238].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[230].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[231].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[232].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[233].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[234].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[235].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[236].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[237].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[238].removeNotify(this.mNotifyCanbus);
    }
}
