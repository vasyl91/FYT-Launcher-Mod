package com.syu.carinfo.rzc.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class RZC_JeepCarEQSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 189:
                    if (((TextView) RZC_JeepCarEQSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) RZC_JeepCarEQSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 190:
                    if (((TextView) RZC_JeepCarEQSet.this.findViewById(R.id.tv_text5)) != null) {
                        if (value >= 9) {
                            ((TextView) RZC_JeepCarEQSet.this.findViewById(R.id.tv_text5)).setText("R" + (value - 9));
                            break;
                        } else {
                            ((TextView) RZC_JeepCarEQSet.this.findViewById(R.id.tv_text5)).setText("L" + (9 - value));
                            break;
                        }
                    }
                    break;
                case 191:
                    if (((TextView) RZC_JeepCarEQSet.this.findViewById(R.id.tv_text4)) != null) {
                        if (value >= 9) {
                            ((TextView) RZC_JeepCarEQSet.this.findViewById(R.id.tv_text4)).setText("R" + (value - 9));
                            break;
                        } else {
                            ((TextView) RZC_JeepCarEQSet.this.findViewById(R.id.tv_text4)).setText("F" + (9 - value));
                            break;
                        }
                    }
                    break;
                case 192:
                    if (((TextView) RZC_JeepCarEQSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (value >= 9) {
                            ((TextView) RZC_JeepCarEQSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value - 9).toString());
                            break;
                        } else {
                            ((TextView) RZC_JeepCarEQSet.this.findViewById(R.id.tv_text3)).setText("-" + (9 - value));
                            break;
                        }
                    }
                    break;
                case 193:
                    if (((TextView) RZC_JeepCarEQSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (value >= 9) {
                            ((TextView) RZC_JeepCarEQSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value - 9).toString());
                            break;
                        } else {
                            ((TextView) RZC_JeepCarEQSet.this.findViewById(R.id.tv_text2)).setText("-" + (9 - value));
                            break;
                        }
                    }
                    break;
                case 194:
                    if (((TextView) RZC_JeepCarEQSet.this.findViewById(R.id.tv_text1)) != null) {
                        if (value >= 9) {
                            ((TextView) RZC_JeepCarEQSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value - 9).toString());
                            break;
                        } else {
                            ((TextView) RZC_JeepCarEQSet.this.findViewById(R.id.tv_text1)).setText("-" + (9 - value));
                            break;
                        }
                    }
                    break;
                case 195:
                    if (((TextView) RZC_JeepCarEQSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZC_JeepCarEQSet.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZC_JeepCarEQSet.this.findViewById(R.id.tv_text6)).setText(R.string.wc_372_low);
                                break;
                            case 2:
                                ((TextView) RZC_JeepCarEQSet.this.findViewById(R.id.tv_text6)).setText(R.string.wc_372_mid);
                                break;
                            case 3:
                                ((TextView) RZC_JeepCarEQSet.this.findViewById(R.id.tv_text6)).setText(R.string.wc_372_high);
                                break;
                        }
                    }
                    break;
                case 196:
                    RZC_JeepCarEQSet.this.setCheck((CheckedTextView) RZC_JeepCarEQSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 197:
                    RZC_JeepCarEQSet.this.setCheck((CheckedTextView) RZC_JeepCarEQSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0373_rzc_jeep_eqsettings);
        init();
    }

    @Override
    public void init() {
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
    }

    @Override
    public void onClick(View v) {
        int value;
        int value2;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value3 = DataCanbus.DATA[194];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(6, value3);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value4 = DataCanbus.DATA[194];
                if (value4 < 19) {
                    value4++;
                }
                setCarInfo(6, value4);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value5 = DataCanbus.DATA[193];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(5, value5);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value6 = DataCanbus.DATA[193];
                if (value6 < 19) {
                    value6++;
                }
                setCarInfo(5, value6);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value7 = DataCanbus.DATA[192];
                if (value7 > 0) {
                    value7--;
                }
                setCarInfo(4, value7);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value8 = DataCanbus.DATA[192];
                if (value8 < 19) {
                    value8++;
                }
                setCarInfo(4, value8);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value9 = DataCanbus.DATA[191];
                if (value9 > 0) {
                    value9--;
                }
                setCarInfo(3, value9);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value10 = DataCanbus.DATA[191];
                if (value10 < 19) {
                    value10++;
                }
                setCarInfo(3, value10);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value11 = DataCanbus.DATA[190];
                if (value11 > 0) {
                    value11--;
                }
                setCarInfo(2, value11);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value12 = DataCanbus.DATA[190];
                if (value12 < 19) {
                    value12++;
                }
                setCarInfo(2, value12);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value13 = DataCanbus.DATA[195];
                if (value13 > 0) {
                    value13--;
                }
                setCarInfo(8, value13);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value14 = DataCanbus.DATA[195];
                if (value14 < 3) {
                    value14++;
                }
                setCarInfo(8, value14);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value15 = DataCanbus.DATA[189];
                if (value15 > 0) {
                    value15--;
                }
                setCarInfo(1, value15);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value16 = DataCanbus.DATA[189];
                if (value16 < 38) {
                    value16++;
                }
                setCarInfo(1, value16);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                if (DataCanbus.DATA[196] == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                setCarInfo(9, value2);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                if (DataCanbus.DATA[197] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                setCarInfo(10, value);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(8, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(9, new int[]{49}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[193].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[193].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
    }
}
