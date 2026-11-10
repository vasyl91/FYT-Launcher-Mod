package com.syu.carinfo.od.tusheng;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZC_XiandaiE_ENCINO_ModeSettingAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.od.tusheng.RZC_XiandaiE_ENCINO_ModeSettingAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 232:
                    ((TextView) RZC_XiandaiE_ENCINO_ModeSettingAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "%");
                    break;
                case 233:
                    ((TextView) RZC_XiandaiE_ENCINO_ModeSettingAct.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "%");
                    break;
                case 234:
                    ((TextView) RZC_XiandaiE_ENCINO_ModeSettingAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "%");
                    break;
                case 235:
                    if (value == 254) {
                        ((TextView) RZC_XiandaiE_ENCINO_ModeSettingAct.this.findViewById(R.id.tv_text4)).setText("----");
                    } else {
                        ((TextView) RZC_XiandaiE_ENCINO_ModeSettingAct.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "km/h");
                    }
                    break;
                case 236:
                    int bit76 = (value >> 6) & 3;
                    int bit54 = (value >> 4) & 3;
                    int bit32 = (value >> 2) & 3;
                    switch (bit76) {
                        case 0:
                            ((TextView) RZC_XiandaiE_ENCINO_ModeSettingAct.this.findViewById(R.id.tv_text5)).setText("Lv1");
                            break;
                        case 1:
                            ((TextView) RZC_XiandaiE_ENCINO_ModeSettingAct.this.findViewById(R.id.tv_text5)).setText("Lv2");
                            break;
                        case 2:
                            ((TextView) RZC_XiandaiE_ENCINO_ModeSettingAct.this.findViewById(R.id.tv_text5)).setText("Lv3");
                            break;
                    }
                    switch (bit54) {
                        case 0:
                            ((TextView) RZC_XiandaiE_ENCINO_ModeSettingAct.this.findViewById(R.id.tv_text6)).setText("Lv1");
                            break;
                        case 1:
                            ((TextView) RZC_XiandaiE_ENCINO_ModeSettingAct.this.findViewById(R.id.tv_text6)).setText("Lv2");
                            break;
                        case 2:
                            ((TextView) RZC_XiandaiE_ENCINO_ModeSettingAct.this.findViewById(R.id.tv_text6)).setText("Lv3");
                            break;
                    }
                    switch (bit32) {
                        case 0:
                            ((TextView) RZC_XiandaiE_ENCINO_ModeSettingAct.this.findViewById(R.id.tv_text7)).setText("Lv1");
                            break;
                        case 1:
                            ((TextView) RZC_XiandaiE_ENCINO_ModeSettingAct.this.findViewById(R.id.tv_text7)).setText("Lv2");
                            break;
                        case 2:
                            ((TextView) RZC_XiandaiE_ENCINO_ModeSettingAct.this.findViewById(R.id.tv_text7)).setText("Lv3");
                            break;
                    }
                    break;
                case 237:
                    int bit5 = (value >> 5) & 1;
                    int bit3 = (value >> 3) & 1;
                    int bit1 = (value >> 1) & 1;
                    switch (bit5) {
                        case 0:
                            ((TextView) RZC_XiandaiE_ENCINO_ModeSettingAct.this.findViewById(R.id.tv_text8)).setText("ECO");
                            break;
                        case 1:
                            ((TextView) RZC_XiandaiE_ENCINO_ModeSettingAct.this.findViewById(R.id.tv_text8)).setText(R.string.wc_golf_normal);
                            break;
                    }
                    switch (bit3) {
                        case 0:
                            ((TextView) RZC_XiandaiE_ENCINO_ModeSettingAct.this.findViewById(R.id.tv_text9)).setText("ECO");
                            break;
                        case 1:
                            ((TextView) RZC_XiandaiE_ENCINO_ModeSettingAct.this.findViewById(R.id.tv_text9)).setText(R.string.wc_golf_normal);
                            break;
                    }
                    switch (bit1) {
                        case 0:
                            ((TextView) RZC_XiandaiE_ENCINO_ModeSettingAct.this.findViewById(R.id.tv_text10)).setText("ECO");
                            break;
                        case 1:
                            ((TextView) RZC_XiandaiE_ENCINO_ModeSettingAct.this.findViewById(R.id.tv_text10)).setText(R.string.wc_golf_normal);
                            break;
                    }
                    break;
                case 238:
                    switch (value) {
                        case 0:
                            ((TextView) RZC_XiandaiE_ENCINO_ModeSettingAct.this.findViewById(R.id.tv_text11)).setText("COMFORT");
                            break;
                        case 1:
                            ((TextView) RZC_XiandaiE_ENCINO_ModeSettingAct.this.findViewById(R.id.tv_text11)).setText("SPORT");
                            break;
                        case 2:
                            ((TextView) RZC_XiandaiE_ENCINO_ModeSettingAct.this.findViewById(R.id.tv_text11)).setText("ECO");
                            break;
                    }
                    break;
                case 239:
                    ((TextView) RZC_XiandaiE_ENCINO_ModeSettingAct.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value) + "km");
                    break;
                case 240:
                    ((TextView) RZC_XiandaiE_ENCINO_ModeSettingAct.this.findViewById(R.id.tv_text13)).setText(String.valueOf(value / 10) + "." + (value % 10) + "kg");
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0447_rzc_xiandai_encino_e_modesetting);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(this);
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.od.tusheng.RZC_XiandaiE_ENCINO_ModeSettingAct.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.od.tusheng.RZC_XiandaiE_ENCINO_ModeSettingAct.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(13, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.od.tusheng.RZC_XiandaiE_ENCINO_ModeSettingAct.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.od.tusheng.RZC_XiandaiE_ENCINO_ModeSettingAct.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(13, new int[]{i, 0}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View arg0) {
        int id = arg0.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value1 = DataCanbus.DATA[237];
                int value2 = DataCanbus.DATA[236];
                int value3 = DataCanbus.DATA[235];
                if (value3 > 90) {
                    value3 -= 10;
                }
                if (value3 < 90) {
                    value3 = 90;
                }
                DataCanbus.PROXY.cmd(14, new int[]{10, value1, value2, value3}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value4 = DataCanbus.DATA[237];
                int value5 = DataCanbus.DATA[236];
                int value6 = DataCanbus.DATA[235];
                if (value6 < 130) {
                    value6 += 10;
                }
                if (value6 > 130) {
                    value6 = 130;
                }
                DataCanbus.PROXY.cmd(14, new int[]{10, value4, value5, value6}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value7 = DataCanbus.DATA[237];
                int value8 = DataCanbus.DATA[236];
                int value9 = DataCanbus.DATA[235];
                int bit76 = (value8 >> 6) & 3;
                int bit54 = (value8 >> 4) & 3;
                int bit32 = (value8 >> 2) & 3;
                int bit77 = bit76 - 1;
                if (bit77 < 0) {
                    bit77 = 2;
                }
                int data = ((bit77 << 6) & 192) | ((bit54 << 4) & 48) | ((bit32 << 2) & 12);
                DataCanbus.PROXY.cmd(14, new int[]{10, value7, data, value9}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value10 = DataCanbus.DATA[237];
                int value11 = DataCanbus.DATA[236];
                int value12 = DataCanbus.DATA[235];
                int bit78 = (value11 >> 6) & 3;
                int bit55 = (value11 >> 4) & 3;
                int bit33 = (value11 >> 2) & 3;
                int bit79 = bit78 + 1;
                if (bit79 > 2) {
                    bit79 = 0;
                }
                int data2 = ((bit79 << 6) & 192) | ((bit55 << 4) & 48) | ((bit33 << 2) & 12);
                DataCanbus.PROXY.cmd(14, new int[]{10, value10, data2, value12}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value13 = DataCanbus.DATA[237];
                int value14 = DataCanbus.DATA[236];
                int value15 = DataCanbus.DATA[235];
                int bit710 = (value14 >> 6) & 3;
                int bit56 = (value14 >> 4) & 3;
                int bit34 = (value14 >> 2) & 3;
                int bit57 = bit56 - 1;
                if (bit57 < 0) {
                    bit57 = 2;
                }
                int data3 = ((bit710 << 6) & 192) | ((bit57 << 4) & 48) | ((bit34 << 2) & 12);
                DataCanbus.PROXY.cmd(14, new int[]{10, value13, data3, value15}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value16 = DataCanbus.DATA[237];
                int value17 = DataCanbus.DATA[236];
                int value18 = DataCanbus.DATA[235];
                int bit711 = (value17 >> 6) & 3;
                int bit58 = (value17 >> 4) & 3;
                int bit35 = (value17 >> 2) & 3;
                int bit59 = bit58 + 1;
                if (bit59 > 2) {
                    bit59 = 0;
                }
                int data4 = ((bit711 << 6) & 192) | ((bit59 << 4) & 48) | ((bit35 << 2) & 12);
                DataCanbus.PROXY.cmd(14, new int[]{10, value16, data4, value18}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value19 = DataCanbus.DATA[237];
                int value20 = DataCanbus.DATA[236];
                int value21 = DataCanbus.DATA[235];
                int bit712 = (value20 >> 6) & 3;
                int bit510 = (value20 >> 4) & 3;
                int bit36 = ((value20 >> 2) & 3) - 1;
                if (bit36 < 0) {
                    bit36 = 2;
                }
                int data5 = ((bit712 << 6) & 192) | ((bit510 << 4) & 48) | ((bit36 << 2) & 12);
                DataCanbus.PROXY.cmd(14, new int[]{10, value19, data5, value21}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value22 = DataCanbus.DATA[237];
                int value23 = DataCanbus.DATA[236];
                int value24 = DataCanbus.DATA[235];
                int bit713 = (value23 >> 6) & 3;
                int bit511 = (value23 >> 4) & 3;
                int bit37 = ((value23 >> 2) & 3) + 1;
                if (bit37 > 2) {
                    bit37 = 0;
                }
                int data6 = ((bit713 << 6) & 192) | ((bit511 << 4) & 48) | ((bit37 << 2) & 12);
                DataCanbus.PROXY.cmd(14, new int[]{10, value22, data6, value24}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value25 = DataCanbus.DATA[237];
                int value26 = DataCanbus.DATA[236];
                int value27 = DataCanbus.DATA[235];
                int bit5 = (value25 >> 5) & 1;
                int bit3 = (value25 >> 3) & 1;
                int bit1 = (value25 >> 1) & 1;
                int bit6 = bit5 - 1;
                if (bit6 < 0) {
                    bit6 = 1;
                }
                int data7 = ((bit6 << 6) & 64) | ((bit3 << 2) & 4) | ((bit1 << 4) & 16);
                DataCanbus.PROXY.cmd(14, new int[]{10, data7, value26, value27}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value28 = DataCanbus.DATA[237];
                int value29 = DataCanbus.DATA[236];
                int value30 = DataCanbus.DATA[235];
                int bit7 = (value28 >> 5) & 1;
                int bit4 = (value28 >> 3) & 1;
                int bit2 = (value28 >> 1) & 1;
                int bit8 = bit7 + 1;
                if (bit8 > 1) {
                    bit8 = 0;
                }
                int data8 = ((bit8 << 6) & 64) | ((bit4 << 2) & 4) | ((bit2 << 4) & 16);
                DataCanbus.PROXY.cmd(14, new int[]{10, data8, value29, value30}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value31 = DataCanbus.DATA[237];
                int value32 = DataCanbus.DATA[236];
                int value33 = DataCanbus.DATA[235];
                int bit9 = (value31 >> 5) & 1;
                int bit10 = (value31 >> 3) & 1;
                int bit11 = (value31 >> 1) & 1;
                int bit12 = bit10 - 1;
                if (bit12 < 0) {
                    bit12 = 1;
                }
                int data9 = ((bit9 << 6) & 64) | ((bit12 << 2) & 4) | ((bit11 << 4) & 16);
                DataCanbus.PROXY.cmd(14, new int[]{10, data9, value32, value33}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value34 = DataCanbus.DATA[237];
                int value35 = DataCanbus.DATA[236];
                int value36 = DataCanbus.DATA[235];
                int bit13 = (value34 >> 5) & 1;
                int bit14 = (value34 >> 3) & 1;
                int bit15 = (value34 >> 1) & 1;
                int bit16 = bit14 + 1;
                if (bit16 > 1) {
                    bit16 = 0;
                }
                int data10 = ((bit13 << 6) & 64) | ((bit16 << 2) & 4) | ((bit15 << 4) & 16);
                DataCanbus.PROXY.cmd(14, new int[]{10, data10, value35, value36}, null, null);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value37 = DataCanbus.DATA[237];
                int value38 = DataCanbus.DATA[236];
                int value39 = DataCanbus.DATA[235];
                int bit17 = (value37 >> 5) & 1;
                int bit18 = (value37 >> 3) & 1;
                int bit19 = ((value37 >> 1) & 1) - 1;
                if (bit19 < 0) {
                    bit19 = 1;
                }
                int data11 = ((bit17 << 6) & 64) | ((bit18 << 2) & 4) | ((bit19 << 4) & 16);
                DataCanbus.PROXY.cmd(14, new int[]{10, data11, value38, value39}, null, null);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value40 = DataCanbus.DATA[237];
                int value41 = DataCanbus.DATA[236];
                int value42 = DataCanbus.DATA[235];
                int bit20 = (value40 >> 5) & 1;
                int bit21 = (value40 >> 3) & 1;
                int bit22 = ((value40 >> 1) & 1) + 1;
                if (bit22 > 1) {
                    bit22 = 0;
                }
                int data12 = ((bit20 << 6) & 64) | ((bit21 << 2) & 4) | ((bit22 << 4) & 16);
                DataCanbus.PROXY.cmd(14, new int[]{10, data12, value41, value42}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                dialog(R.string.str_wc_174008_str6, 11);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(2, new int[]{87, 0}, null, null);
        DataCanbus.NOTIFY_EVENTS[232].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[233].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[234].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[235].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[236].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[237].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[238].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[239].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[240].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[232].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[233].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[234].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[235].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[236].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[237].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[238].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[239].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[240].removeNotify(this.mNotifyCanbus);
    }
}
