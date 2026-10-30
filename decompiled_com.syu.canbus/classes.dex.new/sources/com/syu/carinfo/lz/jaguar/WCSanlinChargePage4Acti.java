package com.syu.carinfo.lz.jaguar;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
public class WCSanlinChargePage4Acti extends BaseActivity implements View.OnClickListener {
    int data2 = 0;
    int data3 = 0;
    int data4 = 0;
    int data5 = 0;
    int data6 = 0;
    int data7 = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.jaguar.WCSanlinChargePage4Acti.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 173:
                    WCSanlinChargePage4Acti.this.data2 = value;
                    int bit2 = (value >> 2) & 1;
                    int bit1 = (value >> 1) & 1;
                    int bit0 = (value >> 0) & 1;
                    WCSanlinChargePage4Acti.this.setCheck((CheckedTextView) WCSanlinChargePage4Acti.this.findViewById(R.id.ctv_checkedtext1), bit2 == 1);
                    WCSanlinChargePage4Acti.this.setCheck((CheckedTextView) WCSanlinChargePage4Acti.this.findViewById(R.id.ctv_checkedtext2), bit0 == 1);
                    if (bit1 == 1) {
                        ((TextView) WCSanlinChargePage4Acti.this.findViewById(R.id.tv_text5)).setText("Set OK");
                    } else {
                        ((TextView) WCSanlinChargePage4Acti.this.findViewById(R.id.tv_text5)).setText("Not set");
                    }
                    break;
                case 174:
                    if (((TextView) WCSanlinChargePage4Acti.this.findViewById(R.id.tv_text1)) != null) {
                        int hour = (value >> 8) & 255;
                        int min = value & 255;
                        WCSanlinChargePage4Acti.this.data3 = hour;
                        WCSanlinChargePage4Acti.this.data4 = min;
                        ((TextView) WCSanlinChargePage4Acti.this.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(hour)).toString());
                        ((TextView) WCSanlinChargePage4Acti.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(min)).toString());
                    }
                    break;
                case 175:
                    if (((TextView) WCSanlinChargePage4Acti.this.findViewById(R.id.tv_text3)) != null) {
                        int hour2 = (value >> 8) & 255;
                        int min2 = value & 255;
                        WCSanlinChargePage4Acti.this.data5 = hour2;
                        WCSanlinChargePage4Acti.this.data6 = min2;
                        ((TextView) WCSanlinChargePage4Acti.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(hour2)).toString());
                        ((TextView) WCSanlinChargePage4Acti.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(min2)).toString());
                    }
                    break;
                case 176:
                    WCSanlinChargePage4Acti.this.data7 = value;
                    int bit6 = (value >> 6) & 1;
                    int bit5 = (value >> 5) & 1;
                    int bit4 = (value >> 4) & 1;
                    int bit3 = (value >> 3) & 1;
                    int bit7 = (value >> 2) & 1;
                    int bit8 = (value >> 1) & 1;
                    int bit9 = (value >> 0) & 1;
                    WCSanlinChargePage4Acti.this.setCheck((CheckedTextView) WCSanlinChargePage4Acti.this.findViewById(R.id.ctv_checkedtext3), bit9 == 1);
                    WCSanlinChargePage4Acti.this.setCheck((CheckedTextView) WCSanlinChargePage4Acti.this.findViewById(R.id.ctv_checkedtext4), bit8 == 1);
                    WCSanlinChargePage4Acti.this.setCheck((CheckedTextView) WCSanlinChargePage4Acti.this.findViewById(R.id.ctv_checkedtext5), bit7 == 1);
                    WCSanlinChargePage4Acti.this.setCheck((CheckedTextView) WCSanlinChargePage4Acti.this.findViewById(R.id.ctv_checkedtext6), bit3 == 1);
                    WCSanlinChargePage4Acti.this.setCheck((CheckedTextView) WCSanlinChargePage4Acti.this.findViewById(R.id.ctv_checkedtext7), bit4 == 1);
                    WCSanlinChargePage4Acti.this.setCheck((CheckedTextView) WCSanlinChargePage4Acti.this.findViewById(R.id.ctv_checkedtext8), bit5 == 1);
                    WCSanlinChargePage4Acti.this.setCheck((CheckedTextView) WCSanlinChargePage4Acti.this.findViewById(R.id.ctv_checkedtext9), bit6 == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc_sanlin_chargepage1_settings);
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
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        ((TextView) findViewById(R.id.tv_text6)).setText("Tab4");
    }

    protected void dialog(int stringId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.lz.jaguar.WCSanlinChargePage4Acti.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.lz.jaguar.WCSanlinChargePage4Acti.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                        int[] iArr = new int[10];
                        iArr[0] = 4;
                        iArr[1] = 2;
                        remoteModuleProxy.cmd(4, iArr, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.lz.jaguar.WCSanlinChargePage4Acti.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                this.data3--;
                if (this.data3 < 0) {
                    this.data3 = 23;
                }
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                this.data3++;
                if (this.data3 > 23) {
                    this.data3 = 0;
                }
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                this.data4 -= 10;
                if (this.data4 < 0) {
                    this.data4 = 50;
                }
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                this.data4 += 10;
                if (this.data4 > 50) {
                    this.data4 = 0;
                }
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                this.data5--;
                if (this.data5 < 0) {
                    this.data5 = 23;
                }
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                this.data5++;
                if (this.data5 > 23) {
                    this.data5 = 0;
                }
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                this.data6 -= 10;
                if (this.data6 < 0) {
                    this.data6 = 50;
                }
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                this.data6 += 10;
                if (this.data6 > 50) {
                    this.data6 = 0;
                }
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int bit2 = (this.data2 >> 2) & 1;
                if (bit2 == 0) {
                    this.data2 |= 4;
                } else if (bit2 == 1) {
                    this.data2 &= 251;
                }
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int bit1 = (this.data7 >> 1) & 1;
                if (bit1 == 0) {
                    this.data7 |= 2;
                } else if (bit1 == 1) {
                    this.data7 &= 253;
                }
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int bit3 = (this.data7 >> 2) & 1;
                if (bit3 == 0) {
                    this.data7 |= 4;
                } else if (bit3 == 1) {
                    this.data7 &= 251;
                }
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int bit0 = (this.data2 >> 0) & 1;
                if (bit0 == 0) {
                    this.data2 |= 1;
                } else if (bit0 == 1) {
                    this.data2 &= 254;
                }
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int bit4 = (this.data7 >> 0) & 1;
                if (bit4 == 0) {
                    this.data7 |= 1;
                } else if (bit4 == 1) {
                    this.data7 &= 254;
                }
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int bit5 = (this.data7 >> 3) & 1;
                if (bit5 == 0) {
                    this.data7 |= 8;
                } else if (bit5 == 1) {
                    this.data7 &= 247;
                }
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                int bit6 = (this.data7 >> 4) & 1;
                if (bit6 == 0) {
                    this.data7 |= 16;
                } else if (bit6 == 1) {
                    this.data7 &= 239;
                }
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                int bit7 = (this.data7 >> 5) & 1;
                if (bit7 == 0) {
                    this.data7 |= 32;
                } else if (bit7 == 1) {
                    this.data7 &= 223;
                }
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                int bit8 = (this.data7 >> 6) & 1;
                if (bit8 == 0) {
                    this.data7 |= 64;
                } else if (bit8 == 1) {
                    this.data7 &= 191;
                }
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                DataCanbus.PROXY.cmd(4, new int[]{4, 1, this.data2, this.data3, this.data4, this.data5, this.data6, this.data7, 0, 0}, null, null);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                dialog(R.string.all_settings);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
        int[] iArr = new int[10];
        iArr[0] = 4;
        iArr[1] = 3;
        remoteModuleProxy.cmd(4, iArr, null, null);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
    }
}
