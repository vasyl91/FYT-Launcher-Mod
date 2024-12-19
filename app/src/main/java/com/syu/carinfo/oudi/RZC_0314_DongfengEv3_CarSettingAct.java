package com.syu.carinfo.oudi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RZC_0314_DongfengEv3_CarSettingAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarSettingAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 87:
                    RZC_0314_DongfengEv3_CarSettingAct.this.updateCycleLev();
                    break;
                case 88:
                    RZC_0314_DongfengEv3_CarSettingAct.this.updateHandUpOnoff();
                    break;
                case 105:
                    RZC_0314_DongfengEv3_CarSettingAct.this.setCheck((CheckedTextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.ctv_checkedtext1), value != 0);
                    break;
                case 106:
                    ((TextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                    break;
                case 107:
                    RZC_0314_DongfengEv3_CarSettingAct.this.setCheck((CheckedTextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.ctv_checkedtext2), value != 0);
                    break;
                case 108:
                    switch (value) {
                        case 0:
                            ((TextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.tv_text2)).setText("30S");
                            break;
                        case 2:
                            ((TextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.tv_text2)).setText("60S");
                            break;
                        case 3:
                            ((TextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.tv_text2)).setText("90S");
                            break;
                    }
                case 109:
                    switch (value) {
                        case 0:
                            ((TextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.tv_text3)).setText(R.string.rzc_c4l_open);
                            break;
                        case 2:
                            ((TextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.tv_text3)).setText("随小灯开关");
                            break;
                    }
                case 110:
                    RZC_0314_DongfengEv3_CarSettingAct.this.setCheck((CheckedTextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.ctv_checkedtext3), value != 0);
                    break;
                case 111:
                    switch (value) {
                        case 1:
                            ((TextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.tv_text5)).setText(R.string.driver_system_standard);
                            break;
                        case 2:
                            ((TextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.tv_text5)).setText(R.string.wc_gs4_driver_help_turn_mode_comfort);
                            break;
                        case 3:
                            ((TextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.tv_text5)).setText(R.string.str_driving_sport);
                            break;
                        default:
                            ((TextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.tv_text5)).setText(R.string.driver_system_standard);
                            break;
                    }
                case 123:
                    ((TextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                    break;
                case 124:
                    ((TextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                    break;
                case 125:
                    ((TextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                    break;
                case 126:
                    ((TextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                    break;
                case 127:
                    RZC_0314_DongfengEv3_CarSettingAct.this.setCheck((CheckedTextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.ctv_checkedtext5), value != 0);
                    break;
                case 128:
                    RZC_0314_DongfengEv3_CarSettingAct.this.setCheck((CheckedTextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.ctv_checkedtext6), value != 0);
                    break;
                case 129:
                    RZC_0314_DongfengEv3_CarSettingAct.this.setCheck((CheckedTextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.ctv_checkedtext7), value != 0);
                    break;
                case 130:
                    switch (value) {
                        case 1:
                            ((TextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.tv_text10)).setText("起翘");
                            break;
                        case 2:
                            ((TextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.tv_text10)).setText("开启");
                            break;
                        default:
                            ((TextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.tv_text10)).setText(R.string.off);
                            break;
                    }
                case 131:
                    switch (value) {
                        case 1:
                            ((TextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.tv_text11)).setText("同步开");
                            break;
                        case 2:
                            ((TextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.tv_text11)).setText("同步关");
                            break;
                        case 3:
                            ((TextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.tv_text11)).setText("同开和同关");
                            break;
                        default:
                            ((TextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.tv_text11)).setText("不同步");
                            break;
                    }
                case 132:
                    RZC_0314_DongfengEv3_CarSettingAct.this.setCheck((CheckedTextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.ctv_checkedtext8), value != 0);
                    break;
                case 133:
                    RZC_0314_DongfengEv3_CarSettingAct.this.setCheck((CheckedTextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.ctv_checkedtext9), value != 0);
                    break;
                case 135:
                    RZC_0314_DongfengEv3_CarSettingAct.this.setCheck((CheckedTextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.ctv_checkedtext10), value != 0);
                    break;
                case 136:
                    RZC_0314_DongfengEv3_CarSettingAct.this.setCheck((CheckedTextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.ctv_checkedtext11), value != 0);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0314_rzc_yizhiev3_carsetting);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        if (DataCanbus.DATA[1000] == 1769786) {
            findViewById(R.id.layout_view1).setVisibility(0);
            findViewById(R.id.layout_view9).setVisibility(0);
            findViewById(R.id.layout_view10).setVisibility(0);
            findViewById(R.id.layout_view11).setVisibility(0);
            findViewById(R.id.layout_view12).setVisibility(0);
            findViewById(R.id.layout_view13).setVisibility(0);
            findViewById(R.id.layout_text_view1).setVisibility(0);
            findViewById(R.id.layout_view2).setVisibility(8);
            findViewById(R.id.layout_view3).setVisibility(8);
            findViewById(R.id.layout_view4).setVisibility(8);
            findViewById(R.id.layout_view5).setVisibility(8);
            findViewById(R.id.layout_view6).setVisibility(8);
            findViewById(R.id.layout_view7).setVisibility(8);
            findViewById(R.id.layout_view8).setVisibility(8);
            findViewById(R.id.layout_view14).setVisibility(8);
            findViewById(R.id.layout_view15).setVisibility(8);
            findViewById(R.id.layout_view16).setVisibility(8);
            findViewById(R.id.layout_view17).setVisibility(8);
            findViewById(R.id.layout_view18).setVisibility(8);
            findViewById(R.id.layout_view19).setVisibility(8);
            findViewById(R.id.layout_view20).setVisibility(8);
            findViewById(R.id.layout_view21).setVisibility(8);
            findViewById(R.id.layout_view22).setVisibility(8);
        } else if (DataCanbus.DATA[1000] == 1835322 || DataCanbus.DATA[1000] == 1900858) {
            findViewById(R.id.layout_view1).setVisibility(8);
            findViewById(R.id.layout_view10).setVisibility(8);
            findViewById(R.id.layout_view11).setVisibility(8);
            findViewById(R.id.layout_view12).setVisibility(8);
            findViewById(R.id.layout_view13).setVisibility(8);
            findViewById(R.id.layout_text_view1).setVisibility(8);
            findViewById(R.id.layout_view2).setVisibility(8);
            findViewById(R.id.layout_view3).setVisibility(8);
            findViewById(R.id.layout_view4).setVisibility(8);
            findViewById(R.id.layout_view5).setVisibility(8);
            findViewById(R.id.layout_view6).setVisibility(8);
            findViewById(R.id.layout_view7).setVisibility(8);
            findViewById(R.id.layout_view8).setVisibility(8);
            findViewById(R.id.layout_view9).setVisibility(0);
            findViewById(R.id.layout_view14).setVisibility(0);
            findViewById(R.id.layout_view15).setVisibility(0);
            findViewById(R.id.layout_view16).setVisibility(0);
            findViewById(R.id.layout_view17).setVisibility(0);
            findViewById(R.id.layout_view18).setVisibility(0);
            findViewById(R.id.layout_view19).setVisibility(0);
            findViewById(R.id.layout_view20).setVisibility(0);
            findViewById(R.id.layout_view21).setVisibility(0);
            findViewById(R.id.layout_view22).setVisibility(0);
        } else {
            findViewById(R.id.layout_view1).setVisibility(0);
            findViewById(R.id.layout_view9).setVisibility(8);
            findViewById(R.id.layout_view10).setVisibility(8);
            findViewById(R.id.layout_view11).setVisibility(8);
            findViewById(R.id.layout_view12).setVisibility(8);
            findViewById(R.id.layout_view13).setVisibility(8);
            findViewById(R.id.layout_text_view1).setVisibility(8);
            findViewById(R.id.layout_view2).setVisibility(0);
            findViewById(R.id.layout_view3).setVisibility(0);
            findViewById(R.id.layout_view4).setVisibility(0);
            findViewById(R.id.layout_view5).setVisibility(0);
            findViewById(R.id.layout_view6).setVisibility(0);
            findViewById(R.id.layout_view7).setVisibility(0);
            findViewById(R.id.layout_view8).setVisibility(0);
            findViewById(R.id.layout_view14).setVisibility(8);
            findViewById(R.id.layout_view15).setVisibility(8);
            findViewById(R.id.layout_view16).setVisibility(8);
            findViewById(R.id.layout_view17).setVisibility(8);
            findViewById(R.id.layout_view18).setVisibility(8);
            findViewById(R.id.layout_view19).setVisibility(8);
            findViewById(R.id.layout_view20).setVisibility(8);
            findViewById(R.id.layout_view21).setVisibility(8);
            findViewById(R.id.layout_view22).setVisibility(8);
        }
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarSettingAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[105];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{3, value}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarSettingAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[107];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{5, value}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarSettingAct.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[110];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{9, value}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarSettingAct.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[88];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{2, value}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarSettingAct.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[127];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{11, value}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarSettingAct.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[128];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{12, value}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarSettingAct.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[129];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{13, value}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarSettingAct.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[132];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{16, value}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarSettingAct.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[133];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{17, value}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarSettingAct.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[135];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{19, value}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarSettingAct.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[136];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{20, value}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus1), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarSettingAct.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[106] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{4, value}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus1), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarSettingAct.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[106] + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{4, value}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus2), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarSettingAct.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[108] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{7, value}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus2), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarSettingAct.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[108] + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{7, value}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus3), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarSettingAct.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[109] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{8, value}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus3), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarSettingAct.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[109] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{8, value}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus4), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarSettingAct.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[87] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{1, value}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus4), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarSettingAct.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[87] + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{1, value}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus5), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarSettingAct.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[111] - 1;
                if (value < 1) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{10, value}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus5), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarSettingAct.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[111] + 1;
                if (value > 3) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{10, value}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus6), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarSettingAct.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int start_h = DataCanbus.DATA[123];
                int start_m = DataCanbus.DATA[124];
                int stop_h = DataCanbus.DATA[125];
                int stop_m = DataCanbus.DATA[126];
                if (start_h > 0) {
                    start_h--;
                }
                DataCanbus.PROXY.cmd(4, new int[]{start_h, start_m, stop_h, stop_m}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus6), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarSettingAct.24
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int start_h = DataCanbus.DATA[123];
                int start_m = DataCanbus.DATA[124];
                int stop_h = DataCanbus.DATA[125];
                int stop_m = DataCanbus.DATA[126];
                if (start_h < 23) {
                    start_h++;
                }
                DataCanbus.PROXY.cmd(4, new int[]{start_h, start_m, stop_h, stop_m}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus7), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarSettingAct.25
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int start_h = DataCanbus.DATA[123];
                int start_m = DataCanbus.DATA[124];
                int stop_h = DataCanbus.DATA[125];
                int stop_m = DataCanbus.DATA[126];
                if (start_m > 0) {
                    start_m--;
                }
                DataCanbus.PROXY.cmd(4, new int[]{start_h, start_m, stop_h, stop_m}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus7), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarSettingAct.26
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int start_h = DataCanbus.DATA[123];
                int start_m = DataCanbus.DATA[124];
                int stop_h = DataCanbus.DATA[125];
                int stop_m = DataCanbus.DATA[126];
                if (start_m < 59) {
                    start_m++;
                }
                DataCanbus.PROXY.cmd(4, new int[]{start_h, start_m, stop_h, stop_m}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus8), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarSettingAct.27
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int start_h = DataCanbus.DATA[123];
                int start_m = DataCanbus.DATA[124];
                int stop_h = DataCanbus.DATA[125];
                int stop_m = DataCanbus.DATA[126];
                if (stop_h > 0) {
                    stop_h--;
                }
                DataCanbus.PROXY.cmd(4, new int[]{start_h, start_m, stop_h, stop_m}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus8), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarSettingAct.28
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int start_h = DataCanbus.DATA[123];
                int start_m = DataCanbus.DATA[124];
                int stop_h = DataCanbus.DATA[125];
                int stop_m = DataCanbus.DATA[126];
                if (stop_h < 23) {
                    stop_h++;
                }
                DataCanbus.PROXY.cmd(4, new int[]{start_h, start_m, stop_h, stop_m}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus9), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarSettingAct.29
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int start_h = DataCanbus.DATA[123];
                int start_m = DataCanbus.DATA[124];
                int stop_h = DataCanbus.DATA[125];
                int stop_m = DataCanbus.DATA[126];
                if (stop_m > 0) {
                    stop_m--;
                }
                DataCanbus.PROXY.cmd(4, new int[]{start_h, start_m, stop_h, stop_m}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus9), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarSettingAct.30
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int start_h = DataCanbus.DATA[123];
                int start_m = DataCanbus.DATA[124];
                int stop_h = DataCanbus.DATA[125];
                int stop_m = DataCanbus.DATA[126];
                if (stop_m < 59) {
                    stop_m++;
                }
                DataCanbus.PROXY.cmd(4, new int[]{start_h, start_m, stop_h, stop_m}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus10), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarSettingAct.31
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[130] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{14, value}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus10), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarSettingAct.32
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[130] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{14, value}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus11), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarSettingAct.33
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[131] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{15, value}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus11), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarSettingAct.34
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[131] + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{15, value}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(3, new int[]{41}, null, null);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCycleLev() {
        int value = DataCanbus.DATA[87];
        ((TextView) findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHandUpOnoff() {
        int value = DataCanbus.DATA[88];
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext4), value != 0);
    }
}
