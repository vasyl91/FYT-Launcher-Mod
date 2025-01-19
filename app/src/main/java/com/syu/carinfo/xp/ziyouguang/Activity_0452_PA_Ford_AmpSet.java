package com.syu.carinfo.xp.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Activity_0452_PA_Ford_AmpSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 116:
                    Activity_0452_PA_Ford_AmpSet.this.setCheck((CheckedTextView) Activity_0452_PA_Ford_AmpSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 117:
                    if (((TextView) Activity_0452_PA_Ford_AmpSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) Activity_0452_PA_Ford_AmpSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 118:
                    if (((TextView) Activity_0452_PA_Ford_AmpSet.this.findViewById(R.id.tv_text4)) != null) {
                        if (value >= 10) {
                            ((TextView) Activity_0452_PA_Ford_AmpSet.this.findViewById(R.id.tv_text4)).setText("R" + (value - 10));
                            break;
                        } else {
                            ((TextView) Activity_0452_PA_Ford_AmpSet.this.findViewById(R.id.tv_text4)).setText("F" + (10 - value));
                            break;
                        }
                    }
                    break;
                case 119:
                    if (((TextView) Activity_0452_PA_Ford_AmpSet.this.findViewById(R.id.tv_text5)) != null) {
                        if (value >= 10) {
                            ((TextView) Activity_0452_PA_Ford_AmpSet.this.findViewById(R.id.tv_text5)).setText("R" + (value - 10));
                            break;
                        } else {
                            ((TextView) Activity_0452_PA_Ford_AmpSet.this.findViewById(R.id.tv_text5)).setText("L" + (10 - value));
                            break;
                        }
                    }
                    break;
                case 120:
                    if (((TextView) Activity_0452_PA_Ford_AmpSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (value >= 10) {
                            ((TextView) Activity_0452_PA_Ford_AmpSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value - 10).toString());
                            break;
                        } else {
                            ((TextView) Activity_0452_PA_Ford_AmpSet.this.findViewById(R.id.tv_text3)).setText("-" + (10 - value));
                            break;
                        }
                    }
                    break;
                case 121:
                    if (((TextView) Activity_0452_PA_Ford_AmpSet.this.findViewById(R.id.tv_text1)) != null) {
                        if (value >= 10) {
                            ((TextView) Activity_0452_PA_Ford_AmpSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value - 10).toString());
                            break;
                        } else {
                            ((TextView) Activity_0452_PA_Ford_AmpSet.this.findViewById(R.id.tv_text1)).setText("-" + (10 - value));
                            break;
                        }
                    }
                    break;
                case 122:
                    if (((TextView) Activity_0452_PA_Ford_AmpSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (value >= 10) {
                            ((TextView) Activity_0452_PA_Ford_AmpSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value - 10).toString());
                            break;
                        } else {
                            ((TextView) Activity_0452_PA_Ford_AmpSet.this.findViewById(R.id.tv_text2)).setText("-" + (10 - value));
                            break;
                        }
                    }
                    break;
                case 124:
                    Activity_0452_PA_Ford_AmpSet.this.setCheck((CheckedTextView) Activity_0452_PA_Ford_AmpSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 125:
                    if (((TextView) Activity_0452_PA_Ford_AmpSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Activity_0452_PA_Ford_AmpSet.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) Activity_0452_PA_Ford_AmpSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
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
        //setContentView(R.layout.layout_0452_pa_ford_eqsettings);
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
                int value3 = DataCanbus.DATA[121];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(6, value3);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value4 = DataCanbus.DATA[121];
                if (value4 < 19) {
                    value4++;
                }
                setCarInfo(6, value4);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value5 = DataCanbus.DATA[122];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(7, value5);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value6 = DataCanbus.DATA[122];
                if (value6 < 19) {
                    value6++;
                }
                setCarInfo(7, value6);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value7 = DataCanbus.DATA[120];
                if (value7 > 0) {
                    value7--;
                }
                setCarInfo(5, value7);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value8 = DataCanbus.DATA[120];
                if (value8 < 19) {
                    value8++;
                }
                setCarInfo(5, value8);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value9 = DataCanbus.DATA[118];
                if (value9 > 0) {
                    value9--;
                }
                setCarInfo(3, value9);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value10 = DataCanbus.DATA[118];
                if (value10 < 19) {
                    value10++;
                }
                setCarInfo(3, value10);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value11 = DataCanbus.DATA[119];
                if (value11 > 0) {
                    value11--;
                }
                setCarInfo(4, value11);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value12 = DataCanbus.DATA[119];
                if (value12 < 19) {
                    value12++;
                }
                setCarInfo(4, value12);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value13 = DataCanbus.DATA[125];
                if (value13 > 0) {
                    value13--;
                }
                setCarInfo(9, value13);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value14 = DataCanbus.DATA[125];
                if (value14 < 3) {
                    value14++;
                }
                setCarInfo(9, value14);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value15 = DataCanbus.DATA[117];
                if (value15 > 0) {
                    value15--;
                }
                setCarInfo(2, value15);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value16 = DataCanbus.DATA[117];
                if (value16 < 38) {
                    value16++;
                }
                setCarInfo(2, value16);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                if (DataCanbus.DATA[124] == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                setCarInfo(10, value2);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                if (DataCanbus.DATA[116] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                setCarInfo(1, value);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(13, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(4, new int[]{23}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
    }
}
