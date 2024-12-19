package com.syu.carinfo.psa_all;

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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class PSA4008CarSetActi extends BaseActivity implements View.OnClickListener {
    private int[] eventIds = {165, 166, 167, 168, 169, 170, 171, 172, 184, 173, 174, 175, 176, 177, 178, 179, 180, 181, 185, 186, 187, 196, 197, 199, 200, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.psa_all.PSA4008CarSetActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int i, int[] iArr, float[] fArr, String[] strArr) {
            switch (i) {
                case 165:
                    PSA4008CarSetActi.this.findViewById(R.id.layout_view1).setVisibility(DataCanbus.DATA[i] == 1 ? 0 : 8);
                    break;
                case 166:
                    PSA4008CarSetActi.this.findViewById(R.id.layout_view2).setVisibility(DataCanbus.DATA[i] != 1 ? 8 : 0);
                    break;
                case 167:
                    PSA4008CarSetActi.this.findViewById(R.id.layout_view3).setVisibility(DataCanbus.DATA[i] != 1 ? 8 : 0);
                    break;
                case 168:
                    PSA4008CarSetActi.this.findViewById(R.id.layout_view4).setVisibility(DataCanbus.DATA[i] != 1 ? 8 : 0);
                    break;
                case 169:
                    PSA4008CarSetActi.this.findViewById(R.id.layout_view5).setVisibility(DataCanbus.DATA[i] != 1 ? 8 : 0);
                    break;
                case 170:
                    PSA4008CarSetActi.this.findViewById(R.id.layout_view6).setVisibility(DataCanbus.DATA[i] != 1 ? 8 : 0);
                    break;
                case 171:
                    PSA4008CarSetActi.this.findViewById(R.id.layout_view7).setVisibility(DataCanbus.DATA[i] != 1 ? 8 : 0);
                    break;
                case 172:
                    PSA4008CarSetActi.this.findViewById(R.id.layout_view8).setVisibility(DataCanbus.DATA[i] == 1 ? 0 : 8);
                    PSA4008CarSetActi.this.findViewById(R.id.layout_view9).setVisibility(DataCanbus.DATA[i] != 1 ? 8 : 0);
                    break;
                case 173:
                    PSA4008CarSetActi.this.updateIncense2(i);
                    break;
                case 174:
                    PSA4008CarSetActi.this.updateLane(i);
                    break;
                case 175:
                    PSA4008CarSetActi.this.updateFatigue(i);
                    break;
                case 176:
                    PSA4008CarSetActi.this.updateSpeed(i);
                    break;
                case 177:
                    PSA4008CarSetActi.this.updateTheme(i);
                    break;
                case 178:
                    PSA4008CarSetActi.this.updateAmbient(i);
                    break;
                case 179:
                    PSA4008CarSetActi.this.updateDriver(i);
                    break;
                case 180:
                    PSA4008CarSetActi.this.updateIon(i);
                    break;
                case 181:
                    PSA4008CarSetActi.this.updateIncense(i);
                    break;
                case 184:
                    PSA4008CarSetActi.this.findViewById(R.id.layout_view11).setVisibility(DataCanbus.DATA[i] != 1 ? 8 : 0);
                    break;
                case 185:
                    PSA4008CarSetActi.this.updatePanelbright(i);
                    break;
                case 186:
                    PSA4008CarSetActi.this.updatePanelleft(i);
                    break;
                case 187:
                    PSA4008CarSetActi.this.updatePanelright(i);
                    break;
                case 196:
                    ((CheckedTextView) PSA4008CarSetActi.this.findViewById(R.id.ctv_checkedtext10)).setChecked(DataCanbus.DATA[i] != 0);
                    break;
                case 197:
                    ((CheckedTextView) PSA4008CarSetActi.this.findViewById(R.id.ctv_checkedtext11)).setChecked(DataCanbus.DATA[i] != 0);
                    break;
                case 199:
                    ((CheckedTextView) PSA4008CarSetActi.this.findViewById(R.id.ctv_checkedtext12)).setChecked(DataCanbus.DATA[i] != 0);
                    break;
                case 200:
                    ((CheckedTextView) PSA4008CarSetActi.this.findViewById(R.id.ctv_checkedtext13)).setChecked(DataCanbus.DATA[i] != 0);
                    break;
                case 232:
                    ((CheckedTextView) PSA4008CarSetActi.this.findViewById(R.id.ctv_checkedtext14)).setChecked(DataCanbus.DATA[i] != 0);
                    break;
                case 233:
                    ((CheckedTextView) PSA4008CarSetActi.this.findViewById(R.id.ctv_checkedtext15)).setChecked(DataCanbus.DATA[i] != 0);
                    break;
                case 234:
                    ((CheckedTextView) PSA4008CarSetActi.this.findViewById(R.id.ctv_checkedtext16)).setChecked(DataCanbus.DATA[i] != 0);
                    break;
                case 235:
                    if (((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(DataCanbus.DATA[i]).toString());
                        break;
                    }
                case 236:
                    if (((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(DataCanbus.DATA[i]).toString());
                        break;
                    }
                case 237:
                    if (((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text11)) != null) {
                        switch (DataCanbus.DATA[i]) {
                            case 0:
                                ((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text11)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text11)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text11)).setText(R.string.klc_air_middle);
                                break;
                            case 3:
                                ((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text11)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 238:
                    if (((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text13)) != null) {
                        switch (DataCanbus.DATA[i]) {
                            case 0:
                                ((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text13)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text13)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text13)).setText(R.string.klc_air_middle);
                                break;
                            case 3:
                                ((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text13)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 239:
                    if (((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text14)) != null) {
                        switch (DataCanbus.DATA[i]) {
                            case 0:
                                ((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text14)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text14)).setText(R.string.jeep_forwardcollisionwarn_0);
                                break;
                            case 2:
                                ((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text14)).setText(R.string.klc_air_middle);
                                break;
                            case 3:
                                ((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text14)).setText(R.string.jeep_forwardcollisionwarn_1);
                                break;
                        }
                    }
                    break;
                case 240:
                    ((CheckedTextView) PSA4008CarSetActi.this.findViewById(R.id.ctv_checkedtext17)).setChecked(DataCanbus.DATA[i] != 0);
                    break;
                case 241:
                    ((CheckedTextView) PSA4008CarSetActi.this.findViewById(R.id.ctv_checkedtext18)).setChecked(DataCanbus.DATA[i] != 0);
                    break;
                case 242:
                    switch (DataCanbus.DATA[i]) {
                        case 0:
                            ((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text15)).setText("14-28");
                            break;
                        case 1:
                            ((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text15)).setText("16-30");
                            break;
                    }
                case 243:
                    ((CheckedTextView) PSA4008CarSetActi.this.findViewById(R.id.ctv_checkedtext19)).setChecked(DataCanbus.DATA[i] != 0);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_psa_all_4008_carset);
        registerListener();
    }

    public void registerListener() {
        findViewById(R.id.ctv_checkedtext1).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext2).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext3).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext4).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext5).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext6).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext7).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext8).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext9).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext10).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext11).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext12).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext13).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext14).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext15).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext16).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext17).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext18).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext19).setOnClickListener(this);
        findViewById(R.id.layout_view10).setOnClickListener(this);
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
        ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus9)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(this);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        for (int i = 0; i < this.eventIds.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventIds[i]].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        for (int i = 0; i < this.eventIds.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventIds[i]].removeNotify(this.mNotifyCanbus);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        int value5;
        int value6;
        int value7;
        int value8;
        int value9;
        int value10;
        int value11;
        int value12;
        int value13;
        int value14;
        int value15;
        int value16;
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value17 = DataCanbus.DATA[174];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 6;
                iArr[1] = value17 == 0 ? 1 : 0;
                remoteModuleProxy.cmd(101, iArr, null, null);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value18 = DataCanbus.DATA[185];
                if (value18 > 0) {
                    value6 = value18 - 1;
                } else {
                    value6 = 15;
                }
                DataCanbus.PROXY.cmd(101, new int[]{16, value6}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value19 = DataCanbus.DATA[185];
                if (value19 < 15) {
                    value5 = value19 + 1;
                } else {
                    value5 = 0;
                }
                DataCanbus.PROXY.cmd(101, new int[]{16, value5}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value20 = DataCanbus.DATA[186];
                if (value20 > 0) {
                    value4 = value20 - 1;
                } else {
                    value4 = 7;
                }
                DataCanbus.PROXY.cmd(101, new int[]{17, value4}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value21 = DataCanbus.DATA[186];
                if (value21 < 7) {
                    value3 = value21 + 1;
                } else {
                    value3 = 0;
                }
                DataCanbus.PROXY.cmd(101, new int[]{17, value3}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value22 = DataCanbus.DATA[187];
                if (value22 > 0) {
                    value2 = value22 - 1;
                } else {
                    value2 = 7;
                }
                DataCanbus.PROXY.cmd(101, new int[]{18, value2}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value23 = DataCanbus.DATA[187];
                if (value23 < 7) {
                    value = value23 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(101, new int[]{18, value}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value24 = DataCanbus.DATA[235] - 1;
                if (value24 < 1) {
                    value24 = 5;
                }
                DataCanbus.PROXY.cmd(101, new int[]{29, value24}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value25 = DataCanbus.DATA[235] + 1;
                if (value25 > 5) {
                    value25 = 1;
                }
                DataCanbus.PROXY.cmd(101, new int[]{29, value25}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value26 = DataCanbus.DATA[237] - 1;
                if (value26 < 0) {
                    value26 = 3;
                }
                DataCanbus.PROXY.cmd(101, new int[]{31, value26}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value27 = DataCanbus.DATA[237] + 1;
                if (value27 > 3) {
                    value27 = 0;
                }
                DataCanbus.PROXY.cmd(101, new int[]{31, value27}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value28 = DataCanbus.DATA[236] - 1;
                if (value28 < 1) {
                    value28 = 5;
                }
                DataCanbus.PROXY.cmd(101, new int[]{30, value28}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value29 = DataCanbus.DATA[236] + 1;
                if (value29 > 5) {
                    value29 = 1;
                }
                DataCanbus.PROXY.cmd(101, new int[]{30, value29}, null, null);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value30 = DataCanbus.DATA[238] - 1;
                if (value30 < 0) {
                    value30 = 3;
                }
                DataCanbus.PROXY.cmd(101, new int[]{32, value30}, null, null);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value31 = DataCanbus.DATA[238] + 1;
                if (value31 > 3) {
                    value31 = 0;
                }
                DataCanbus.PROXY.cmd(101, new int[]{32, value31}, null, null);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value32 = DataCanbus.DATA[239] - 1;
                if (value32 < 0) {
                    value32 = 3;
                }
                DataCanbus.PROXY.cmd(101, new int[]{33, value32}, null, null);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value33 = DataCanbus.DATA[239] + 1;
                if (value33 > 3) {
                    value33 = 0;
                }
                DataCanbus.PROXY.cmd(101, new int[]{33, value33}, null, null);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value34 = DataCanbus.DATA[242] - 1;
                if (value34 < 0) {
                    value34 = 1;
                }
                DataCanbus.PROXY.cmd(101, new int[]{36, value34}, null, null);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value35 = DataCanbus.DATA[242] + 1;
                if (value35 > 1) {
                    value35 = 0;
                }
                DataCanbus.PROXY.cmd(101, new int[]{36, value35}, null, null);
                break;
            case R.id.layout_view10 /* 2131427516 */:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(R.string.str_wc_174008_str21).setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSA4008CarSetActi.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        DataCanbus.PROXY.cmd(101, new int[]{15, 1}, null, null);
                    }
                }).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSA4008CarSetActi.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        DataCanbus.PROXY.cmd(101, new int[]{15}, null, null);
                    }
                });
                builder.show();
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value36 = DataCanbus.DATA[175];
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 7;
                iArr2[1] = value36 == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(101, iArr2, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value37 = DataCanbus.DATA[176];
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[2];
                iArr3[0] = 8;
                iArr3[1] = value37 == 0 ? 1 : 0;
                remoteModuleProxy3.cmd(101, iArr3, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value38 = DataCanbus.DATA[177];
                RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                int[] iArr4 = new int[2];
                iArr4[0] = 9;
                iArr4[1] = value38 == 0 ? 1 : 0;
                remoteModuleProxy4.cmd(101, iArr4, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                DataCanbus.PROXY.cmd(101, new int[]{10, (DataCanbus.DATA[178] + 1) % 3}, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value39 = DataCanbus.DATA[179];
                RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                int[] iArr5 = new int[2];
                iArr5[0] = 11;
                iArr5[1] = value39 == 0 ? 1 : 0;
                remoteModuleProxy5.cmd(101, iArr5, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                DataCanbus.PROXY.cmd(101, new int[]{12, (DataCanbus.DATA[180] + 1) % 3}, null, null);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                DataCanbus.PROXY.cmd(101, new int[]{13, (DataCanbus.DATA[181] + 1) % 3}, null, null);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                DataCanbus.PROXY.cmd(101, new int[]{14, (DataCanbus.DATA[173] + 1) % 4}, null, null);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                if (DataCanbus.DATA[196] == 1) {
                    value16 = 0;
                } else {
                    value16 = 1;
                }
                DataCanbus.PROXY.cmd(101, new int[]{20, value16}, null, null);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                if (DataCanbus.DATA[197] == 1) {
                    value15 = 0;
                } else {
                    value15 = 1;
                }
                DataCanbus.PROXY.cmd(101, new int[]{21, value15}, null, null);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                if (DataCanbus.DATA[199] == 1) {
                    value14 = 0;
                } else {
                    value14 = 1;
                }
                DataCanbus.PROXY.cmd(101, new int[]{22, value14}, null, null);
                break;
            case R.id.ctv_checkedtext13 /* 2131427545 */:
                if (DataCanbus.DATA[200] == 1) {
                    value13 = 0;
                } else {
                    value13 = 1;
                }
                DataCanbus.PROXY.cmd(101, new int[]{23, value13}, null, null);
                break;
            case R.id.ctv_checkedtext14 /* 2131427546 */:
                if (DataCanbus.DATA[232] == 1) {
                    value12 = 0;
                } else {
                    value12 = 1;
                }
                DataCanbus.PROXY.cmd(101, new int[]{25, value12}, null, null);
                break;
            case R.id.ctv_checkedtext15 /* 2131427547 */:
                if (DataCanbus.DATA[233] == 1) {
                    value11 = 0;
                } else {
                    value11 = 1;
                }
                DataCanbus.PROXY.cmd(101, new int[]{26, value11}, null, null);
                break;
            case R.id.ctv_checkedtext16 /* 2131427548 */:
                if (DataCanbus.DATA[234] == 1) {
                    value10 = 0;
                } else {
                    value10 = 1;
                }
                DataCanbus.PROXY.cmd(101, new int[]{27, value10}, null, null);
                break;
            case R.id.ctv_checkedtext17 /* 2131427647 */:
                if (DataCanbus.DATA[240] == 1) {
                    value9 = 0;
                } else {
                    value9 = 1;
                }
                DataCanbus.PROXY.cmd(101, new int[]{34, value9}, null, null);
                break;
            case R.id.ctv_checkedtext18 /* 2131427649 */:
                if (DataCanbus.DATA[241] == 1) {
                    value8 = 0;
                } else {
                    value8 = 1;
                }
                DataCanbus.PROXY.cmd(101, new int[]{35, value8}, null, null);
                break;
            case R.id.ctv_checkedtext19 /* 2131427651 */:
                if (DataCanbus.DATA[243] == 1) {
                    value7 = 0;
                } else {
                    value7 = 1;
                }
                DataCanbus.PROXY.cmd(101, new int[]{37, value7}, null, null);
                break;
        }
    }

    void sendCmd(int cmd, int para) {
    }

    protected void updateIncense(int updateCode) {
        int i = DataCanbus.DATA[updateCode];
        int[] strId = {R.string.str_wc_174008_str18, R.string.str_wc_174008_str19, R.string.str_wc_174008_str20};
        if (((TextView) findViewById(R.id.tv_text8)) != null && i < strId.length) {
            ((TextView) findViewById(R.id.tv_text8)).setText(strId[i]);
        }
    }

    protected void updateIon(int updateCode) {
        int i = DataCanbus.DATA[updateCode];
        int[] strId = {R.string.off, R.string.str_wc_174008_str16, R.string.str_wc_174008_str17};
        if (((TextView) findViewById(R.id.tv_text7)) != null && i < strId.length) {
            ((TextView) findViewById(R.id.tv_text7)).setText(strId[i]);
        }
    }

    protected void updateDriver(int updateCode) {
        int i = DataCanbus.DATA[updateCode];
        int[] strId = {R.string.driver_system_standard, R.string.driver_system_sports};
        if (((TextView) findViewById(R.id.tv_text6)) != null && i < strId.length) {
            ((TextView) findViewById(R.id.tv_text6)).setText(strId[i]);
        }
    }

    protected void updateAmbient(int updateCode) {
        int i = DataCanbus.DATA[updateCode];
        int[] strId = {R.string.str_wc_174008_str13, R.string.str_wc_174008_str14, R.string.str_wc_174008_str15};
        if (((TextView) findViewById(R.id.tv_text5)) != null && i < strId.length) {
            ((TextView) findViewById(R.id.tv_text5)).setText(strId[i]);
        }
    }

    protected void updateTheme(int updateCode) {
        int i = DataCanbus.DATA[updateCode];
        int[] strId = {R.string.str_wc_174008_str11, R.string.str_wc_174008_str12};
        if (((TextView) findViewById(R.id.tv_text4)) != null && i < strId.length) {
            ((TextView) findViewById(R.id.tv_text4)).setText(strId[i]);
        }
    }

    protected void updateSpeed(int updateCode) {
        int i = DataCanbus.DATA[updateCode];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(i != 0);
        }
    }

    protected void updateFatigue(int updateCode) {
        int i = DataCanbus.DATA[updateCode];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(i != 0);
        }
    }

    protected void updateLane(int updateCode) {
        int i = DataCanbus.DATA[updateCode];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(i != 0);
        }
    }

    protected void updatePanelbright(int updateCode) {
        int i = DataCanbus.DATA[updateCode];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder().append(i).toString());
        }
    }

    protected void updatePanelleft(int updateCode) {
        int i = DataCanbus.DATA[updateCode];
        int[] strId = {R.string.crv_source_null, R.string.wc_4008_pannel_str1, R.string.wc_4008_pannel_str2, R.string.wc_4008_pannel_str3, R.string.wc_4008_pannel_str4, R.string.wc_4008_pannel_str5, R.string.wc_4008_pannel_str6, R.string.wc_4008_pannel_str7};
        if (((TextView) findViewById(R.id.tv_text2)) != null && i < strId.length) {
            ((TextView) findViewById(R.id.tv_text2)).setText(strId[i]);
        }
    }

    protected void updatePanelright(int updateCode) {
        int i = DataCanbus.DATA[updateCode];
        int[] strId = {R.string.crv_source_null, R.string.wc_4008_pannel_str1, R.string.wc_4008_pannel_str2, R.string.wc_4008_pannel_str3, R.string.wc_4008_pannel_str4, R.string.wc_4008_pannel_str5, R.string.wc_4008_pannel_str6, R.string.wc_4008_pannel_str7};
        if (((TextView) findViewById(R.id.tv_text3)) != null && i < strId.length) {
            ((TextView) findViewById(R.id.tv_text3)).setText(strId[i]);
        }
    }

    protected void updateIncense2(int updateCode) {
        int i = DataCanbus.DATA[updateCode];
        int[] strId = {R.string.off, R.string.klc_air_low, R.string.klc_air_middle, R.string.klc_air_high};
        if (((TextView) findViewById(R.id.tv_text9)) != null && i < strId.length) {
            ((TextView) findViewById(R.id.tv_text9)).setText(strId[i]);
        }
    }
}
