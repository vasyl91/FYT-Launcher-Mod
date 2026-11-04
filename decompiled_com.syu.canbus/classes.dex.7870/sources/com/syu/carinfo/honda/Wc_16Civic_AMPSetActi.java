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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class Wc_16Civic_AMPSetActi extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.honda.Wc_16Civic_AMPSetActi.1
        @Override // com.syu.module.IUiNotify
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
                    }
                    break;
                case 201:
                    if (((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text2)) != null) {
                        if (val > 9) {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text2)).setText("R" + (val - 9));
                        } else if (val < 9) {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text2)).setText("L" + val);
                        } else {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text2)).setText("0");
                        }
                    }
                    break;
                case 202:
                    if (((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text3)) != null) {
                        if (val > 9) {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text3)).setText("R" + (val - 9));
                        } else if (val < 9) {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text3)).setText("F" + val);
                        } else {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text3)).setText("0");
                        }
                    }
                    break;
                case 203:
                    if (((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text4)) != null) {
                        if (val > 6) {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text4)).setText("+" + (val - 6));
                        } else if (val < 6) {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text4)).setText("-" + (6 - val));
                        } else {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text4)).setText("0");
                        }
                    }
                    break;
                case 204:
                    if (((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text5)) != null) {
                        if (val > 6) {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text5)).setText("+" + (val - 6));
                        } else if (val < 6) {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text5)).setText("-" + (6 - val));
                        } else {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text5)).setText("0");
                        }
                    }
                    break;
                case 205:
                    if (((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text6)) != null) {
                        if (val > 6) {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text6)).setText("+" + (val - 6));
                        } else if (val < 6) {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text6)).setText("-" + (6 - val));
                        } else {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text6)).setText("0");
                        }
                    }
                    break;
                case 206:
                    if (((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text7)) != null) {
                        if (val > 6) {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text7)).setText("+" + (val - 6));
                        } else if (val < 6) {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text7)).setText("-" + (6 - val));
                        } else {
                            ((TextView) Wc_16Civic_AMPSetActi.this.findViewById(R.id.tv_text7)).setText("0");
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_321_civic_amp_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427417 */:
                int value = DataCanbus.DATA[200];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(2, new int[]{1, value}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int value2 = DataCanbus.DATA[200];
                if (value2 < 40) {
                    value2++;
                }
                DataCanbus.PROXY.cmd(2, new int[]{1, value2}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int value3 = DataCanbus.DATA[201];
                if (value3 > 0) {
                    value3--;
                }
                DataCanbus.PROXY.cmd(2, new int[]{2, value3}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int value4 = DataCanbus.DATA[201];
                if (value4 < 18) {
                    value4++;
                }
                DataCanbus.PROXY.cmd(2, new int[]{2, value4}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427425 */:
                int value5 = DataCanbus.DATA[202];
                if (value5 > 0) {
                    value5--;
                }
                DataCanbus.PROXY.cmd(2, new int[]{3, value5}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                int value6 = DataCanbus.DATA[202];
                if (value6 < 18) {
                    value6++;
                }
                DataCanbus.PROXY.cmd(2, new int[]{3, value6}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427428 */:
                int value7 = DataCanbus.DATA[203];
                if (value7 < 12) {
                    value7++;
                }
                DataCanbus.PROXY.cmd(2, new int[]{4, value7}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427429 */:
                int value8 = DataCanbus.DATA[204];
                if (value8 < 12) {
                    value8++;
                }
                DataCanbus.PROXY.cmd(2, new int[]{5, value8}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427430 */:
                int value9 = DataCanbus.DATA[205];
                if (value9 < 12) {
                    value9++;
                }
                DataCanbus.PROXY.cmd(2, new int[]{6, value9}, null, null);
                break;
            case R.id.btn_plus7 /* 2131427431 */:
                int value10 = DataCanbus.DATA[206];
                if (value10 < 12) {
                    value10++;
                }
                DataCanbus.PROXY.cmd(2, new int[]{10, value10}, null, null);
                break;
            case R.id.btn_plus8 /* 2131427432 */:
                int value11 = DataCanbus.DATA[152] + 1;
                if (value11 > 3) {
                    value11 = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{7, value11}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427473 */:
                int value12 = DataCanbus.DATA[203];
                if (value12 > 0) {
                    value12--;
                }
                DataCanbus.PROXY.cmd(2, new int[]{4, value12}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427474 */:
                int value13 = DataCanbus.DATA[204];
                if (value13 > 0) {
                    value13--;
                }
                DataCanbus.PROXY.cmd(2, new int[]{5, value13}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427476 */:
                int value14 = DataCanbus.DATA[205];
                if (value14 > 0) {
                    value14--;
                }
                DataCanbus.PROXY.cmd(2, new int[]{6, value14}, null, null);
                break;
            case R.id.btn_minus7 /* 2131427478 */:
                int value15 = DataCanbus.DATA[206];
                if (value15 > 0) {
                    value15--;
                }
                DataCanbus.PROXY.cmd(2, new int[]{10, value15}, null, null);
                break;
            case R.id.btn_minus8 /* 2131427480 */:
                int value16 = DataCanbus.DATA[152] - 1;
                if (value16 < 0) {
                    value16 = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{7, value16}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427548 */:
                int value17 = DataCanbus.DATA[153];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 8;
                iArr[1] = value17 == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
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

    @Override // com.syu.canbus.BaseActivity
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
