package com.syu.carinfo.honda;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Wc_16Civic_AMPSetActi extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 152:
                    if (((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text8)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text8)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_middle);
                                break;
                            case 3:
                                ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 153:
                    ((CheckedTextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.ctv_checkedtext1)).setChecked(val == 1);
                    break;
                case 200:
                    if (((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 201:
                    if (((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text2)) != null) {
                        if (val > 9) {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text2)).setText("R" + (val - 9));
                            break;
                        } else if (val < 9) {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text2)).setText("L" + val);
                            break;
                        } else {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text2)).setText("0");
                            break;
                        }
                    }
                    break;
                case 202:
                    if (((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text3)) != null) {
                        if (val > 9) {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text3)).setText("R" + (val - 9));
                            break;
                        } else if (val < 9) {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text3)).setText("F" + val);
                            break;
                        } else {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text3)).setText("0");
                            break;
                        }
                    }
                    break;
                case 203:
                    if (((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text4)) != null) {
                        if (val > 6) {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text4)).setText("+" + (val - 6));
                            break;
                        } else if (val < 6) {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text4)).setText("-" + (6 - val));
                            break;
                        } else {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text4)).setText("0");
                            break;
                        }
                    }
                    break;
                case 204:
                    if (((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text5)) != null) {
                        if (val > 6) {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text5)).setText("+" + (val - 6));
                            break;
                        } else if (val < 6) {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text5)).setText("-" + (6 - val));
                            break;
                        } else {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text5)).setText("0");
                            break;
                        }
                    }
                    break;
                case 205:
                    if (((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text6)) != null) {
                        if (val > 6) {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text6)).setText("+" + (val - 6));
                            break;
                        } else if (val < 6) {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text6)).setText("-" + (6 - val));
                            break;
                        } else {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text6)).setText("0");
                            break;
                        }
                    }
                    break;
                case 206:
                    if (((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text7)) != null) {
                        if (val > 6) {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text7)).setText("+" + (val - 6));
                            break;
                        } else if (val < 6) {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text7)).setText("-" + (6 - val));
                            break;
                        } else {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text7)).setText("0");
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
        //setContentView(R.layout.layout_321_civic_amp_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                DataCanbus.PROXY.cmd(2, new int[]{1, 255}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                DataCanbus.PROXY.cmd(2, new int[]{1, 1}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value = DataCanbus.DATA[201];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(2, new int[]{2, value}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value2 = DataCanbus.DATA[201];
                if (value2 < 18) {
                    value2++;
                }
                DataCanbus.PROXY.cmd(2, new int[]{2, value2}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value3 = DataCanbus.DATA[202];
                if (value3 > 0) {
                    value3--;
                }
                DataCanbus.PROXY.cmd(2, new int[]{3, value3}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value4 = DataCanbus.DATA[202];
                if (value4 < 18) {
                    value4++;
                }
                DataCanbus.PROXY.cmd(2, new int[]{3, value4}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value5 = DataCanbus.DATA[203];
                if (value5 > 0) {
                    value5--;
                }
                DataCanbus.PROXY.cmd(2, new int[]{4, value5}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value6 = DataCanbus.DATA[203];
                if (value6 < 12) {
                    value6++;
                }
                DataCanbus.PROXY.cmd(2, new int[]{4, value6}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value7 = DataCanbus.DATA[204];
                if (value7 > 0) {
                    value7--;
                }
                DataCanbus.PROXY.cmd(2, new int[]{5, value7}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value8 = DataCanbus.DATA[204];
                if (value8 < 12) {
                    value8++;
                }
                DataCanbus.PROXY.cmd(2, new int[]{5, value8}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value9 = DataCanbus.DATA[205];
                if (value9 > 0) {
                    value9--;
                }
                DataCanbus.PROXY.cmd(2, new int[]{6, value9}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value10 = DataCanbus.DATA[205];
                if (value10 < 12) {
                    value10++;
                }
                DataCanbus.PROXY.cmd(2, new int[]{6, value10}, null, null);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value11 = DataCanbus.DATA[206];
                if (value11 > 0) {
                    value11--;
                }
                DataCanbus.PROXY.cmd(2, new int[]{10, value11}, null, null);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value12 = DataCanbus.DATA[206];
                if (value12 < 12) {
                    value12++;
                }
                DataCanbus.PROXY.cmd(2, new int[]{10, value12}, null, null);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value13 = DataCanbus.DATA[152] - 1;
                if (value13 < 0) {
                    value13 = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{7, value13}, null, null);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value14 = DataCanbus.DATA[152] + 1;
                if (value14 > 3) {
                    value14 = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{7, value14}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value15 = DataCanbus.DATA[153];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 8;
                iArr[1] = value15 == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[200].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[201].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[202].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[203].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[204].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[205].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[206].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[200].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[201].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[202].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[203].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[204].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[205].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[206].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
    }
}
