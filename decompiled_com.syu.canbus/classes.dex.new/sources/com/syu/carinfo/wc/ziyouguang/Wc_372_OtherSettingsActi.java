package com.syu.carinfo.wc.ziyouguang;

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
public class Wc_372_OtherSettingsActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode] & 65535;
            switch (updateCode) {
                case 196:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view1).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.ctv_checkedtext1)).setChecked((value & 255) == 1);
                    break;
                case 197:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view2).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.ctv_checkedtext2)).setChecked((value & 255) == 1);
                    break;
                case 198:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view3).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.ctv_checkedtext3)).setChecked((value & 255) == 1);
                    break;
                case 199:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view4).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.ctv_checkedtext4)).setChecked((value & 255) == 1);
                    break;
                case 200:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view5).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.ctv_checkedtext5)).setChecked((value & 255) == 1);
                    break;
                case 201:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view6).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.ctv_checkedtext6)).setChecked((value & 255) == 1);
                    break;
                case 202:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view7).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.ctv_checkedtext7)).setChecked((value & 255) == 1);
                    break;
                case 203:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view8).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.ctv_checkedtext8)).setChecked((value & 255) == 1);
                    break;
                case 204:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view9).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.ctv_checkedtext9)).setChecked((value & 255) == 1);
                    break;
                case 205:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view10).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.ctv_checkedtext10)).setChecked((value & 255) == 1);
                    break;
                case 206:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view11).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.ctv_checkedtext11)).setChecked((value & 255) == 1);
                    break;
                case 207:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view12).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    if (((TextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.tv_text1)) != null) {
                        int num = (value & 255) + 1;
                        ((TextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(num).toString());
                    }
                    break;
                case 208:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view13).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    if (((TextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value & 255) {
                            case 0:
                                ((TextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.tv_text2)).setText(R.string.str_mild_electric_brake);
                                break;
                            case 1:
                                ((TextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.tv_text2)).setText(R.string.str_heavy_electric_brake);
                                break;
                            case 2:
                                ((TextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.tv_text2)).setText(R.string.str_mild_electric_hydraulic_brake);
                                break;
                            case 3:
                                ((TextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.tv_text2)).setText(R.string.str_heavy_electric_hydraulic_brake);
                                break;
                        }
                    }
                    break;
                case 209:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view14).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.ctv_checkedtext12)).setChecked((value & 255) == 1);
                    break;
                case 210:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view15).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.ctv_checkedtext13)).setChecked((value & 255) == 1);
                    break;
                case 211:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view16).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.ctv_checkedtext14)).setChecked((value & 255) == 1);
                    break;
                case 219:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view17).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.ctv_checkedtext15)).setChecked((value & 255) == 1);
                    break;
                case 225:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view18).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.ctv_checkedtext16)).setChecked((value & 255) == 1);
                    break;
                case 226:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view19).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    if (((TextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value & 255) {
                            case 0:
                                ((TextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.tv_text3)).setText("0s");
                                break;
                            case 1:
                                ((TextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.tv_text3)).setText("45s");
                                break;
                            case 2:
                                ((TextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.tv_text3)).setText("5min");
                                break;
                            case 3:
                                ((TextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.tv_text3)).setText("10min");
                                break;
                        }
                    }
                    break;
                case 227:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view20).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    if (((TextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value & 255) {
                            case 0:
                                ((TextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.tv_text4)).setText("0s");
                                break;
                            case 1:
                                ((TextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.tv_text4)).setText("45s");
                                break;
                            case 2:
                                ((TextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.tv_text4)).setText("5min");
                                break;
                            case 3:
                                ((TextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.tv_text4)).setText("10min");
                                break;
                        }
                    }
                    break;
                case 234:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view21).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.ctv_checkedtext17)).setChecked((value & 255) == 1);
                    break;
                case 235:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view22).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.ctv_checkedtext18)).setChecked((value & 255) == 1);
                    break;
                case 236:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view23).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.ctv_checkedtext19)).setChecked((value & 255) == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_372_zyg_othersettings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[207] & 255) - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{80, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[207] & 255) + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{80, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[208] & 255) - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{81, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[208] & 255) + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{81, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[226] & 255) - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{49, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[226] & 255) + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{49, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[227] & 255) - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{50, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[227] & 255) + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{50, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[196] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 16;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[197] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 48;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[198] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 32;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[199] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 33;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[200] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 64;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[201] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 65;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[202] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 66;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[203] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 67;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[204] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 68;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[205] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 69;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[206] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 70;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[209] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 96;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[210] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 97;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[211] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 98;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext15)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.24
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[219] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 34;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.25
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[225] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 51;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext17)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.26
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[234] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 52;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext18)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.27
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[235] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 35;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext19)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.28
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[236] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 36;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(10, new int[]{100}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[199].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[200].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[201].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[202].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[203].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[204].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[205].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[206].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[207].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[208].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[209].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[210].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[211].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[219].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[225].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[226].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[227].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[234].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[235].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[236].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[199].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[200].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[201].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[202].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[203].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[204].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[205].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[206].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[207].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[208].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[209].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[210].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[211].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[219].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[225].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[226].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[227].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[234].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[235].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[236].removeNotify(this.mNotifyCanbus);
    }
}
