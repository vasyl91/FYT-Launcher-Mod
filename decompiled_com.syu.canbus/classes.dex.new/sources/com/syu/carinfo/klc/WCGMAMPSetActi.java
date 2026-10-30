package com.syu.carinfo.klc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class WCGMAMPSetActi extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.klc.WCGMAMPSetActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 213:
                    if (((TextView) WCGMAMPSetActi.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) WCGMAMPSetActi.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 214:
                    if (((TextView) WCGMAMPSetActi.this.findViewById(R.id.tv_text2)) != null) {
                        if (val < 7) {
                            ((TextView) WCGMAMPSetActi.this.findViewById(R.id.tv_text2)).setText("L" + (7 - val));
                        } else if (val > 7) {
                            ((TextView) WCGMAMPSetActi.this.findViewById(R.id.tv_text2)).setText("R" + (val - 7));
                        } else {
                            ((TextView) WCGMAMPSetActi.this.findViewById(R.id.tv_text2)).setText("0");
                        }
                    }
                    break;
                case 215:
                    if (((TextView) WCGMAMPSetActi.this.findViewById(R.id.tv_text3)) != null) {
                        if (val < 7) {
                            ((TextView) WCGMAMPSetActi.this.findViewById(R.id.tv_text3)).setText("F" + (7 - val));
                        } else if (val > 7) {
                            ((TextView) WCGMAMPSetActi.this.findViewById(R.id.tv_text3)).setText("R" + (val - 7));
                        } else {
                            ((TextView) WCGMAMPSetActi.this.findViewById(R.id.tv_text3)).setText("0");
                        }
                    }
                    break;
                case 216:
                    if (((TextView) WCGMAMPSetActi.this.findViewById(R.id.tv_text4)) != null) {
                        if (val < 7) {
                            ((TextView) WCGMAMPSetActi.this.findViewById(R.id.tv_text4)).setText("-" + (7 - val));
                        } else if (val > 7) {
                            ((TextView) WCGMAMPSetActi.this.findViewById(R.id.tv_text4)).setText("+" + (val - 7));
                        } else {
                            ((TextView) WCGMAMPSetActi.this.findViewById(R.id.tv_text4)).setText("0");
                        }
                    }
                    break;
                case 217:
                    if (((TextView) WCGMAMPSetActi.this.findViewById(R.id.tv_text5)) != null) {
                        if (val < 7) {
                            ((TextView) WCGMAMPSetActi.this.findViewById(R.id.tv_text5)).setText("-" + (7 - val));
                        } else if (val > 7) {
                            ((TextView) WCGMAMPSetActi.this.findViewById(R.id.tv_text5)).setText("+" + (val - 7));
                        } else {
                            ((TextView) WCGMAMPSetActi.this.findViewById(R.id.tv_text5)).setText("0");
                        }
                    }
                    break;
                case 218:
                    if (((TextView) WCGMAMPSetActi.this.findViewById(R.id.tv_text6)) != null) {
                        if (val < 7) {
                            ((TextView) WCGMAMPSetActi.this.findViewById(R.id.tv_text6)).setText("-" + (7 - val));
                        } else if (val > 7) {
                            ((TextView) WCGMAMPSetActi.this.findViewById(R.id.tv_text6)).setText("+" + (val - 7));
                        } else {
                            ((TextView) WCGMAMPSetActi.this.findViewById(R.id.tv_text6)).setText("0");
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0036_wc_gm_amp_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                DataCanbus.PROXY.cmd(16, new int[]{1, 255}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                DataCanbus.PROXY.cmd(16, new int[]{1, 1}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value = DataCanbus.DATA[214];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(16, new int[]{2, value}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value2 = DataCanbus.DATA[214];
                if (value2 < 14) {
                    value2++;
                }
                DataCanbus.PROXY.cmd(16, new int[]{2, value2}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value3 = DataCanbus.DATA[215];
                if (value3 > 0) {
                    value3--;
                }
                DataCanbus.PROXY.cmd(16, new int[]{3, value3}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value4 = DataCanbus.DATA[215];
                if (value4 < 14) {
                    value4++;
                }
                DataCanbus.PROXY.cmd(16, new int[]{3, value4}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value5 = DataCanbus.DATA[216];
                if (value5 > 0) {
                    value5--;
                }
                DataCanbus.PROXY.cmd(16, new int[]{4, value5}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value6 = DataCanbus.DATA[216];
                if (value6 < 14) {
                    value6++;
                }
                DataCanbus.PROXY.cmd(16, new int[]{4, value6}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value7 = DataCanbus.DATA[217];
                if (value7 > 0) {
                    value7--;
                }
                DataCanbus.PROXY.cmd(16, new int[]{5, value7}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value8 = DataCanbus.DATA[217];
                if (value8 < 14) {
                    value8++;
                }
                DataCanbus.PROXY.cmd(16, new int[]{5, value8}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value9 = DataCanbus.DATA[218];
                if (value9 > 0) {
                    value9--;
                }
                DataCanbus.PROXY.cmd(16, new int[]{6, value9}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value10 = DataCanbus.DATA[218];
                if (value10 < 14) {
                    value10++;
                }
                DataCanbus.PROXY.cmd(16, new int[]{6, value10}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[213].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[214].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[215].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[216].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[217].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[218].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[213].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[214].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[215].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[216].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[217].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[218].removeNotify(this.mNotifyCanbus);
    }
}
