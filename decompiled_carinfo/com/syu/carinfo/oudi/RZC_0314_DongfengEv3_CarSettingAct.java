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

@SuppressWarnings({"deprecation", "unchecked"})
public class RZC_0314_DongfengEv3_CarSettingAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    RZC_0314_DongfengEv3_CarSettingAct.this.updateCycleLev();
                    break;
                case 100:
                    RZC_0314_DongfengEv3_CarSettingAct.this.updateHandUpOnoff();
                    break;
                case 117:
                    RZC_0314_DongfengEv3_CarSettingAct.this.setCheck((CheckedTextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.ctv_checkedtext1), value != 0);
                    break;
                case 118:
                    ((TextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                    break;
                case 119:
                    RZC_0314_DongfengEv3_CarSettingAct.this.setCheck((CheckedTextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.ctv_checkedtext2), value != 0);
                    break;
                case 120:
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
                case 121:
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
                case 122:
                    RZC_0314_DongfengEv3_CarSettingAct.this.setCheck((CheckedTextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.ctv_checkedtext3), value != 0);
                    break;
                case 123:
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
                case 135:
                    ((TextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                    break;
                case 136:
                    ((TextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                    break;
                case 137:
                    ((TextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                    break;
                case 138:
                    ((TextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                    break;
                case 139:
                    RZC_0314_DongfengEv3_CarSettingAct.this.setCheck((CheckedTextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.ctv_checkedtext5), value != 0);
                    break;
                case 140:
                    RZC_0314_DongfengEv3_CarSettingAct.this.setCheck((CheckedTextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.ctv_checkedtext6), value != 0);
                    break;
                case 141:
                    RZC_0314_DongfengEv3_CarSettingAct.this.setCheck((CheckedTextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.ctv_checkedtext7), value != 0);
                    break;
                case 142:
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
                case 143:
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
                case 144:
                    RZC_0314_DongfengEv3_CarSettingAct.this.setCheck((CheckedTextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.ctv_checkedtext8), value != 0);
                    break;
                case 145:
                    RZC_0314_DongfengEv3_CarSettingAct.this.setCheck((CheckedTextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.ctv_checkedtext9), value != 0);
                    break;
                case 147:
                    RZC_0314_DongfengEv3_CarSettingAct.this.setCheck((CheckedTextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.ctv_checkedtext10), value != 0);
                    break;
                case 148:
                    RZC_0314_DongfengEv3_CarSettingAct.this.setCheck((CheckedTextView) RZC_0314_DongfengEv3_CarSettingAct.this.findViewById(R.id.ctv_checkedtext11), value != 0);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0314_rzc_yizhiev3_carsetting);
        init();
    }

    @Override
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[117];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{3, value}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[119];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{5, value}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[122];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{9, value}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[100];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{2, value}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[139];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{11, value}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[140];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{12, value}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[141];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{13, value}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[144];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{16, value}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[145];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{17, value}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[147];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{19, value}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[148];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{20, value}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus1), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[118] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{4, value}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus1), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[118] + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{4, value}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus2), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[120] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{7, value}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus2), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[120] + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{7, value}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus3), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[121] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{8, value}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus3), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[121] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{8, value}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus4), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[99] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{1, value}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus4), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[99] + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{1, value}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus5), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[123] - 1;
                if (value < 1) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{10, value}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus5), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[123] + 1;
                if (value > 3) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{10, value}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus6), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int start_h = DataCanbus.DATA[135];
                int start_m = DataCanbus.DATA[136];
                int stop_h = DataCanbus.DATA[137];
                int stop_m = DataCanbus.DATA[138];
                if (start_h > 0) {
                    start_h--;
                }
                DataCanbus.PROXY.cmd(4, new int[]{start_h, start_m, stop_h, stop_m}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus6), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int start_h = DataCanbus.DATA[135];
                int start_m = DataCanbus.DATA[136];
                int stop_h = DataCanbus.DATA[137];
                int stop_m = DataCanbus.DATA[138];
                if (start_h < 23) {
                    start_h++;
                }
                DataCanbus.PROXY.cmd(4, new int[]{start_h, start_m, stop_h, stop_m}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus7), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int start_h = DataCanbus.DATA[135];
                int start_m = DataCanbus.DATA[136];
                int stop_h = DataCanbus.DATA[137];
                int stop_m = DataCanbus.DATA[138];
                if (start_m > 0) {
                    start_m--;
                }
                DataCanbus.PROXY.cmd(4, new int[]{start_h, start_m, stop_h, stop_m}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus7), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int start_h = DataCanbus.DATA[135];
                int start_m = DataCanbus.DATA[136];
                int stop_h = DataCanbus.DATA[137];
                int stop_m = DataCanbus.DATA[138];
                if (start_m < 59) {
                    start_m++;
                }
                DataCanbus.PROXY.cmd(4, new int[]{start_h, start_m, stop_h, stop_m}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus8), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int start_h = DataCanbus.DATA[135];
                int start_m = DataCanbus.DATA[136];
                int stop_h = DataCanbus.DATA[137];
                int stop_m = DataCanbus.DATA[138];
                if (stop_h > 0) {
                    stop_h--;
                }
                DataCanbus.PROXY.cmd(4, new int[]{start_h, start_m, stop_h, stop_m}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus8), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int start_h = DataCanbus.DATA[135];
                int start_m = DataCanbus.DATA[136];
                int stop_h = DataCanbus.DATA[137];
                int stop_m = DataCanbus.DATA[138];
                if (stop_h < 23) {
                    stop_h++;
                }
                DataCanbus.PROXY.cmd(4, new int[]{start_h, start_m, stop_h, stop_m}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus9), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int start_h = DataCanbus.DATA[135];
                int start_m = DataCanbus.DATA[136];
                int stop_h = DataCanbus.DATA[137];
                int stop_m = DataCanbus.DATA[138];
                if (stop_m > 0) {
                    stop_m--;
                }
                DataCanbus.PROXY.cmd(4, new int[]{start_h, start_m, stop_h, stop_m}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus9), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int start_h = DataCanbus.DATA[135];
                int start_m = DataCanbus.DATA[136];
                int stop_h = DataCanbus.DATA[137];
                int stop_m = DataCanbus.DATA[138];
                if (stop_m < 59) {
                    stop_m++;
                }
                DataCanbus.PROXY.cmd(4, new int[]{start_h, start_m, stop_h, stop_m}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus10), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[142] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{14, value}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus10), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[142] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{14, value}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus11), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[143] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{15, value}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus11), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[143] + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{15, value}, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.PROXY.cmd(3, new int[]{41}, null, null);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateCycleLev() {
        int value = DataCanbus.DATA[99];
        ((TextView) findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
    }

    
    public void updateHandUpOnoff() {
        int value = DataCanbus.DATA[100];
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext4), value != 0);
    }
}
