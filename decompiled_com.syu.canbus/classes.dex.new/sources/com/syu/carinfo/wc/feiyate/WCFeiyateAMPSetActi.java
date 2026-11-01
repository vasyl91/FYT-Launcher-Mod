package com.syu.carinfo.wc.feiyate;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class WCFeiyateAMPSetActi extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.feiyate.WCFeiyateAMPSetActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 169:
                    if (((TextView) WCFeiyateAMPSetActi.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) WCFeiyateAMPSetActi.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 170:
                    if (((TextView) WCFeiyateAMPSetActi.this.findViewById(R.id.tv_text2)) != null) {
                        if (val < 0) {
                            ((TextView) WCFeiyateAMPSetActi.this.findViewById(R.id.tv_text2)).setText("L" + (0 - val));
                        } else if (val == 0) {
                            ((TextView) WCFeiyateAMPSetActi.this.findViewById(R.id.tv_text2)).setText("0");
                        } else {
                            ((TextView) WCFeiyateAMPSetActi.this.findViewById(R.id.tv_text2)).setText("R" + val);
                        }
                    }
                    break;
                case 171:
                    if (((TextView) WCFeiyateAMPSetActi.this.findViewById(R.id.tv_text3)) != null) {
                        if (val < 0) {
                            ((TextView) WCFeiyateAMPSetActi.this.findViewById(R.id.tv_text3)).setText("F" + (0 - val));
                        } else if (val == 0) {
                            ((TextView) WCFeiyateAMPSetActi.this.findViewById(R.id.tv_text3)).setText("0");
                        } else {
                            ((TextView) WCFeiyateAMPSetActi.this.findViewById(R.id.tv_text3)).setText("R" + val);
                        }
                    }
                    break;
                case 172:
                    if (((TextView) WCFeiyateAMPSetActi.this.findViewById(R.id.tv_text4)) != null) {
                        if (val < 0) {
                            ((TextView) WCFeiyateAMPSetActi.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(val).toString());
                        } else if (val == 0) {
                            ((TextView) WCFeiyateAMPSetActi.this.findViewById(R.id.tv_text4)).setText("0");
                        } else {
                            ((TextView) WCFeiyateAMPSetActi.this.findViewById(R.id.tv_text4)).setText("+" + val);
                        }
                    }
                    break;
                case 173:
                    if (((TextView) WCFeiyateAMPSetActi.this.findViewById(R.id.tv_text5)) != null) {
                        if (val < 0) {
                            ((TextView) WCFeiyateAMPSetActi.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(val).toString());
                        } else if (val == 0) {
                            ((TextView) WCFeiyateAMPSetActi.this.findViewById(R.id.tv_text5)).setText("0");
                        } else {
                            ((TextView) WCFeiyateAMPSetActi.this.findViewById(R.id.tv_text5)).setText("+" + val);
                        }
                    }
                    break;
                case 174:
                    if (((TextView) WCFeiyateAMPSetActi.this.findViewById(R.id.tv_text6)) != null) {
                        if (val < 0) {
                            ((TextView) WCFeiyateAMPSetActi.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(val).toString());
                        } else if (val == 0) {
                            ((TextView) WCFeiyateAMPSetActi.this.findViewById(R.id.tv_text6)).setText("0");
                        } else {
                            ((TextView) WCFeiyateAMPSetActi.this.findViewById(R.id.tv_text6)).setText("+" + val);
                        }
                    }
                    break;
                case 175:
                    if (((TextView) WCFeiyateAMPSetActi.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) WCFeiyateAMPSetActi.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 176:
                    ((CheckedTextView) WCFeiyateAMPSetActi.this.findViewById(R.id.ctv_checkedtext1)).setChecked(val == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc_feiyate_amp_settings);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[169];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(6, new int[]{1, value}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[169];
                if (value2 < 38) {
                    value2++;
                }
                DataCanbus.PROXY.cmd(6, new int[]{1, value2}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[170];
                if (value3 > -9) {
                    value3--;
                }
                DataCanbus.PROXY.cmd(6, new int[]{2, value3}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[170];
                if (value4 < 9) {
                    value4++;
                }
                DataCanbus.PROXY.cmd(6, new int[]{2, value4}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[171];
                if (value5 > -9) {
                    value5--;
                }
                DataCanbus.PROXY.cmd(6, new int[]{3, value5}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[171];
                if (value6 < 9) {
                    value6++;
                }
                DataCanbus.PROXY.cmd(6, new int[]{3, value6}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[172];
                if (value7 > -9) {
                    value7--;
                }
                DataCanbus.PROXY.cmd(6, new int[]{4, value7}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[172];
                if (value8 < 9) {
                    value8++;
                }
                DataCanbus.PROXY.cmd(6, new int[]{4, value8}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[173];
                if (value9 > -9) {
                    value9--;
                }
                DataCanbus.PROXY.cmd(6, new int[]{5, value9}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[173];
                if (value10 < 9) {
                    value10++;
                }
                DataCanbus.PROXY.cmd(6, new int[]{5, value10}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value11 = DataCanbus.DATA[174];
                if (value11 > -9) {
                    value11--;
                }
                DataCanbus.PROXY.cmd(6, new int[]{6, value11}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value12 = DataCanbus.DATA[174];
                if (value12 < 9) {
                    value12++;
                }
                DataCanbus.PROXY.cmd(6, new int[]{6, value12}, null, null);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value13 = DataCanbus.DATA[175];
                if (value13 > 0) {
                    value13--;
                }
                DataCanbus.PROXY.cmd(6, new int[]{7, value13}, null, null);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value14 = DataCanbus.DATA[175];
                if (value14 < 3) {
                    value14++;
                }
                DataCanbus.PROXY.cmd(6, new int[]{7, value14}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value15 = DataCanbus.DATA[176];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 8;
                iArr[1] = value15 == 0 ? 1 : 0;
                remoteModuleProxy.cmd(6, iArr, null, null);
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
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
    }
}
