package com.syu.carinfo.rzc.sanlin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

public class WCProtonAllCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    if (((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        if (value == 255) {
                            ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text6)).setText("----");
                            break;
                        } else {
                            ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder(String.valueOf(value)).toString());
                            break;
                        }
                    }
                    break;
                case 99:
                    if (((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        if (value == 255) {
                            ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text7)).setText("----");
                            break;
                        } else {
                            ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder(String.valueOf(value)).toString());
                            break;
                        }
                    }
                    break;
                case 100:
                    if (((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.dj_airuize7_prompt_light);
                                break;
                            default:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.dj_airuize7_prompt_lightsounds);
                                break;
                        }
                    }
                    break;
                case 101:
                    if (((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text2)).setText("60S");
                                break;
                            case 2:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text2)).setText("90S");
                                break;
                            default:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text2)).setText("30S");
                                break;
                        }
                    }
                    break;
                case 102:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 103:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 104:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 105:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 106:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 107:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 108:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 109:
                    if (((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.str_driving_sport);
                                break;
                            default:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.str_driving_comfort);
                                break;
                        }
                    }
                    break;
                case 110:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 111:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 112:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 113:
                    if (((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_high);
                                break;
                            default:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_low);
                                break;
                        }
                    }
                    break;
                case 114:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 115:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 116:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 117:
                    if (((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_244_als2);
                                break;
                            default:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_244_als1);
                                break;
                        }
                    }
                    break;
                case 118:
                    if (((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_403_ambient_7);
                                break;
                            case 2:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_403_ambient_5);
                                break;
                            default:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_403_ambient_3);
                                break;
                        }
                    }
                    break;
                case 119:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 120:
                    if (((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value) + "km");
                        break;
                    }
                case 121:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext15), value == 1);
                    break;
                case 122:
                    if (((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text10)).setText("LV" + value);
                        break;
                    }
                case 123:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext16), value == 1);
                    break;
                case 124:
                    if (((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text11)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text11)).setText("all");
                                break;
                            default:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text11)).setText("driver");
                                break;
                        }
                    }
                    break;
                case 125:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext17), value == 1);
                    break;
                case 126:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext18), value == 1);
                    break;
                case 127:
                    if (((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text12)) != null) {
                        switch (value) {
                            case 2:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text12)).setText("Sport");
                                break;
                            case 3:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text12)).setText("Comfort");
                                break;
                            default:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text12)).setText("ECO");
                                break;
                        }
                    }
                    break;
                case 128:
                    if (((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text13)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text13)).setText("10km/h");
                                break;
                            case 2:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text13)).setText("20km/h");
                                break;
                            default:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text13)).setText("off");
                                break;
                        }
                    }
                    break;
                case 129:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext19), value == 1);
                    break;
                case 130:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext20), value == 1);
                    break;
                case 131:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext21), value == 1);
                    break;
                case 132:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext22), value == 1);
                    break;
                case 133:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext23), value == 1);
                    break;
                case 134:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext24), value == 1);
                    break;
                case 135:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext25), value == 1);
                    break;
                case 136:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext26), value == 1);
                    break;
                case 137:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext27), value == 1);
                    break;
                case 138:
                    if (((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text14)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text14)).setText("Medium");
                                break;
                            case 2:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text14)).setText("Strong");
                                break;
                            default:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text14)).setText("Soft");
                                break;
                        }
                    }
                    break;
                case 139:
                    if (((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text15)) != null) {
                        ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text15)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 140:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext28), value == 1);
                    break;
                case 141:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext29), value == 1);
                    break;
                case 142:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext30), value == 1);
                    break;
                case 143:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext31), value == 1);
                    break;
                case 144:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext32), value == 1);
                    break;
                case 145:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext36), value == 1);
                    break;
                case 146:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext37), value == 1);
                    break;
                case 147:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext38), value == 1);
                    break;
                case 148:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext39), value == 1);
                    break;
                case 149:
                    if (((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text17)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text17)).setText("Departure prevention");
                                break;
                            case 2:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text17)).setText("Centering control");
                                break;
                            default:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text17)).setText("Warning only");
                                break;
                        }
                    }
                    break;
                case 150:
                    if (((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text18)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text18)).setText("Tactile");
                                break;
                            case 2:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text18)).setText("Audio&Tactile");
                                break;
                            default:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text18)).setText("Audio");
                                break;
                        }
                    }
                    break;
                case 151:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext33), value == 1);
                    break;
                case 152:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext34), value == 1);
                    break;
                case 153:
                    if (((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text16)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text16)).setText("ACC");
                                break;
                            default:
                                ((TextView) WCProtonAllCarSet.this.findViewById(R.id.tv_text16)).setText("ICC");
                                break;
                        }
                    }
                    break;
                case 154:
                    WCProtonAllCarSet.this.setCheck((CheckedTextView) WCProtonAllCarSet.this.findViewById(R.id.ctv_checkedtext35), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc2_proton_settings);
        init();
    }

    @Override
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
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
        setSelfClick((Button) findViewById(R.id.btn_minus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
        setSelfClick((Button) findViewById(R.id.btn_minus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
        setSelfClick((Button) findViewById(R.id.btn_minus10), this);
        setSelfClick((Button) findViewById(R.id.btn_plus10), this);
        setSelfClick((Button) findViewById(R.id.btn_minus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
        setSelfClick((Button) findViewById(R.id.btn_minus12), this);
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
        setSelfClick((Button) findViewById(R.id.btn_minus13), this);
        setSelfClick((Button) findViewById(R.id.btn_plus13), this);
        setSelfClick((Button) findViewById(R.id.btn_minus14), this);
        setSelfClick((Button) findViewById(R.id.btn_plus14), this);
        setSelfClick((Button) findViewById(R.id.btn_minus15), this);
        setSelfClick((Button) findViewById(R.id.btn_plus15), this);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext12), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext13), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext14), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext15), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext16), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext17), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext18), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext19), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext20), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext21), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext22), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext23), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext24), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext25), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext26), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext27), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext28), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext29), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext30), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext31), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext32), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext33), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext34), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext35), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext36), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext37), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext38), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext39), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext40), this);
        findViewById(R.id.layout_text_view1).setVisibility(8);
        findViewById(R.id.layout_view1).setVisibility(8);
        findViewById(R.id.layout_view3).setVisibility(8);
        findViewById(R.id.layout_view6).setVisibility(8);
        findViewById(R.id.layout_view8).setVisibility(8);
        findViewById(R.id.layout_text_view2).setVisibility(8);
        findViewById(R.id.layout_view2).setVisibility(8);
        findViewById(R.id.layout_view7).setVisibility(8);
        findViewById(R.id.layout_text_view3).setVisibility(8);
        findViewById(R.id.layout_view4).setVisibility(8);
        findViewById(R.id.layout_view5).setVisibility(8);
        findViewById(R.id.layout_view9).setVisibility(8);
        findViewById(R.id.layout_view10).setVisibility(8);
        findViewById(R.id.layout_view19).setVisibility(8);
        findViewById(R.id.layout_view21).setVisibility(8);
        findViewById(R.id.layout_view22).setVisibility(8);
        findViewById(R.id.layout_text_view4).setVisibility(8);
        findViewById(R.id.layout_view11).setVisibility(8);
        findViewById(R.id.layout_view12).setVisibility(8);
        findViewById(R.id.layout_view13).setVisibility(8);
        findViewById(R.id.layout_view14).setVisibility(8);
        findViewById(R.id.layout_view15).setVisibility(8);
        findViewById(R.id.layout_view20).setVisibility(8);
        findViewById(R.id.layout_view16).setVisibility(8);
        findViewById(R.id.layout_view17).setVisibility(8);
        findViewById(R.id.layout_view18).setVisibility(8);
        findViewById(R.id.layout_text_view6).setVisibility(8);
        findViewById(R.id.layout_view35).setVisibility(8);
        findViewById(R.id.layout_view36).setVisibility(8);
        findViewById(R.id.layout_view37).setVisibility(8);
        findViewById(R.id.layout_view38).setVisibility(8);
        findViewById(R.id.layout_text_view5).setVisibility(8);
        findViewById(R.id.layout_view23).setVisibility(8);
        findViewById(R.id.layout_view24).setVisibility(8);
        findViewById(R.id.layout_view25).setVisibility(8);
        findViewById(R.id.layout_view26).setVisibility(8);
        findViewById(R.id.layout_view27).setVisibility(8);
        findViewById(R.id.layout_view28).setVisibility(8);
        findViewById(R.id.layout_view29).setVisibility(8);
        findViewById(R.id.layout_view30).setVisibility(8);
        findViewById(R.id.layout_view31).setVisibility(8);
        findViewById(R.id.layout_view32).setVisibility(8);
        findViewById(R.id.layout_view33).setVisibility(8);
        findViewById(R.id.layout_view34).setVisibility(8);
        findViewById(R.id.layout_view39).setVisibility(8);
        findViewById(R.id.layout_view40).setVisibility(8);
        findViewById(R.id.layout_view41).setVisibility(8);
        findViewById(R.id.layout_view42).setVisibility(8);
        findViewById(R.id.layout_view43).setVisibility(8);
        findViewById(R.id.layout_view44).setVisibility(8);
        findViewById(R.id.layout_view45).setVisibility(8);
        findViewById(R.id.layout_view46).setVisibility(8);
        findViewById(R.id.layout_view47).setVisibility(8);
        findViewById(R.id.layout_view48).setVisibility(8);
        findViewById(R.id.layout_view49).setVisibility(8);
        findViewById(R.id.layout_view50).setVisibility(8);
        findViewById(R.id.layout_view51).setVisibility(8);
        findViewById(R.id.layout_view52).setVisibility(8);
        findViewById(R.id.layout_view53).setVisibility(8);
        findViewById(R.id.layout_view54).setVisibility(8);
        findViewById(R.id.layout_view55).setVisibility(8);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_443_WC2_Proton_X50_22 /* 9306555 */:
            case FinalCanbus.CAR_443_WC2_Proton_X50_22_H /* 9372091 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                break;
            case FinalCanbus.CAR_443_WC2_Proton_X70_22 /* 9503163 */:
            case FinalCanbus.CAR_443_WC2_Proton_X70_22_H /* 9568699 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                break;
            case FinalCanbus.CAR_443_WC2_Proton_S70_24 /* 16449979 */:
            case FinalCanbus.CAR_443_WC2_Proton_S70_24_H /* 16515515 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_text_view6).setVisibility(0);
                findViewById(R.id.layout_view35).setVisibility(0);
                findViewById(R.id.layout_view36).setVisibility(0);
                findViewById(R.id.layout_view37).setVisibility(0);
                findViewById(R.id.layout_view38).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_view29).setVisibility(0);
                findViewById(R.id.layout_view30).setVisibility(0);
                findViewById(R.id.layout_view31).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view34).setVisibility(0);
                findViewById(R.id.layout_view40).setVisibility(0);
                findViewById(R.id.layout_view47).setVisibility(0);
                findViewById(R.id.layout_view48).setVisibility(0);
                findViewById(R.id.layout_view49).setVisibility(0);
                findViewById(R.id.layout_view50).setVisibility(0);
                findViewById(R.id.layout_view51).setVisibility(0);
                findViewById(R.id.layout_view52).setVisibility(0);
                findViewById(R.id.layout_view53).setVisibility(0);
                findViewById(R.id.layout_view54).setVisibility(0);
                findViewById(R.id.layout_view55).setVisibility(0);
                break;
            case FinalCanbus.CAR_443_WC2_Proton_X90_24 /* 16581051 */:
            case FinalCanbus.CAR_443_WC2_Proton_X90_24_H /* 16646587 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_text_view6).setVisibility(0);
                findViewById(R.id.layout_view35).setVisibility(0);
                findViewById(R.id.layout_view36).setVisibility(0);
                findViewById(R.id.layout_view37).setVisibility(0);
                findViewById(R.id.layout_view38).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_view30).setVisibility(0);
                findViewById(R.id.layout_view31).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view34).setVisibility(0);
                findViewById(R.id.layout_view40).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                findViewById(R.id.layout_view42).setVisibility(0);
                findViewById(R.id.layout_view43).setVisibility(0);
                findViewById(R.id.layout_view44).setVisibility(0);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[100] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(1, value, 255, 255);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[100] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(1, value2, 255, 255);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[101] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(4, value3, 255, 255);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[101] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(4, value4, 255, 255);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[109] - 1;
                if (value5 < 0) {
                    value5 = 1;
                }
                setCarInfo(13, value5, 255, 255);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[109] + 1;
                if (value6 > 1) {
                    value6 = 0;
                }
                setCarInfo(13, value6, 255, 255);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[113] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(36, value7, 255, 255);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[113] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(36, value8, 255, 255);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[117] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarInfo(40, value9, 255, 255);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[117] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarInfo(40, value10, 255, 255);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                if (DataCanbus.DATA[121] != 1) {
                    int value11 = DataCanbus.DATA[118] - 1;
                    if (value11 < 0) {
                        value11 = 2;
                    }
                    setCarInfo(41, value11, 255, 255);
                    break;
                }
            case R.id.btn_plus6 /* 2131427472 */:
                if (DataCanbus.DATA[121] != 1) {
                    int value12 = DataCanbus.DATA[118] + 1;
                    if (value12 > 2) {
                        value12 = 0;
                    }
                    setCarInfo(41, value12, 255, 255);
                    break;
                }
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[122] - 1;
                if (value13 < 1) {
                    value13 = 5;
                }
                setCarInfo(50, value13, 255, 255);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[122] + 1;
                if (value14 > 5) {
                    value14 = 1;
                }
                setCarInfo(50, value14, 255, 255);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[124] - 1;
                if (value15 < 0) {
                    value15 = 1;
                }
                setCarInfo(52, value15, 255, 255);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[124] + 1;
                if (value16 > 1) {
                    value16 = 0;
                }
                setCarInfo(52, value16, 255, 255);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[127] - 1;
                if (value17 < 0) {
                    value17 = 0;
                }
                int value18 = value17 - 1;
                if (value18 < 0) {
                    value18 = 2;
                }
                setCarInfo(55, value18, 255, 255);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value19 = DataCanbus.DATA[127] - 1;
                if (value19 < 0) {
                    value19 = 0;
                }
                int value20 = value19 + 1;
                if (value20 > 2) {
                    value20 = 0;
                }
                setCarInfo(55, value20, 255, 255);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value21 = DataCanbus.DATA[128] - 1;
                if (value21 < 0) {
                    value21 = 2;
                }
                setCarInfo(56, value21, 255, 255);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value22 = DataCanbus.DATA[128] + 1;
                if (value22 > 2) {
                    value22 = 0;
                }
                setCarInfo(56, value22, 255, 255);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value23 = DataCanbus.DATA[138] - 1;
                if (value23 < 0) {
                    value23 = 2;
                }
                setCarInfo(66, value23, 255, 255);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value24 = DataCanbus.DATA[138] + 1;
                if (value24 > 2) {
                    value24 = 0;
                }
                setCarInfo(66, value24, 255, 255);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value25 = DataCanbus.DATA[139];
                if (value25 > 0) {
                    value25--;
                }
                setCarInfo(67, value25, 255, 255);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value26 = DataCanbus.DATA[139];
                if (value26 < 10) {
                    value26++;
                }
                setCarInfo(67, value26, 255, 255);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value27 = DataCanbus.DATA[153] - 1;
                if (value27 < 0) {
                    value27 = 1;
                }
                setCarInfo(78, value27, 255, 255);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value28 = DataCanbus.DATA[153] + 1;
                if (value28 > 1) {
                    value28 = 0;
                }
                setCarInfo(78, value28, 255, 255);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value29 = DataCanbus.DATA[149] - 1;
                if (value29 < 0) {
                    value29 = 2;
                }
                setCarInfo(80, value29, 255, 255);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value30 = DataCanbus.DATA[149] + 1;
                if (value30 > 2) {
                    value30 = 0;
                }
                setCarInfo(80, value30, 255, 255);
                break;
            case R.id.btn_minus15 /* 2131427515 */:
                int value31 = DataCanbus.DATA[150] - 1;
                if (value31 < 0) {
                    value31 = 2;
                }
                setCarInfo(81, value31, 255, 255);
                break;
            case R.id.btn_plus15 /* 2131427517 */:
                int value32 = DataCanbus.DATA[150] + 1;
                if (value32 > 2) {
                    value32 = 0;
                }
                setCarInfo(81, value32, 255, 255);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value33 = DataCanbus.DATA[102];
                if (value33 == 1) {
                    value33 = 0;
                } else if (value33 == 0) {
                    value33 = 1;
                }
                setCarInfo(6, value33, 255, 255);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value34 = DataCanbus.DATA[103];
                if (value34 == 1) {
                    value34 = 0;
                } else if (value34 == 0) {
                    value34 = 1;
                }
                setCarInfo(7, value34, 255, 255);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value35 = DataCanbus.DATA[104];
                if (value35 == 1) {
                    value35 = 0;
                } else if (value35 == 0) {
                    value35 = 1;
                }
                setCarInfo(8, value35, 255, 255);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value36 = DataCanbus.DATA[105];
                if (value36 == 1) {
                    value36 = 0;
                } else if (value36 == 0) {
                    value36 = 1;
                }
                setCarInfo(9, value36, 255, 255);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value37 = DataCanbus.DATA[106];
                if (value37 == 1) {
                    value37 = 0;
                } else if (value37 == 0) {
                    value37 = 1;
                }
                setCarInfo(10, value37, 255, 255);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value38 = DataCanbus.DATA[107];
                if (value38 == 1) {
                    value38 = 0;
                } else if (value38 == 0) {
                    value38 = 1;
                }
                setCarInfo(11, value38, 255, 255);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value39 = DataCanbus.DATA[108];
                if (value39 == 1) {
                    value39 = 0;
                } else if (value39 == 0) {
                    value39 = 1;
                }
                setCarInfo(12, value39, 255, 255);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value40 = DataCanbus.DATA[110];
                if (value40 == 1) {
                    value40 = 0;
                } else if (value40 == 0) {
                    value40 = 1;
                }
                setCarInfo(33, value40, 255, 255);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value41 = DataCanbus.DATA[111];
                if (value41 == 1) {
                    value41 = 0;
                } else if (value41 == 0) {
                    value41 = 1;
                }
                setCarInfo(34, value41, 255, 255);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int value42 = DataCanbus.DATA[112];
                if (value42 == 1) {
                    value42 = 0;
                } else if (value42 == 0) {
                    value42 = 1;
                }
                setCarInfo(35, value42, 255, 255);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                int value43 = DataCanbus.DATA[114];
                if (value43 == 1) {
                    value43 = 0;
                } else if (value43 == 0) {
                    value43 = 1;
                }
                setCarInfo(37, value43, 255, 255);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                int value44 = DataCanbus.DATA[115];
                if (value44 == 1) {
                    value44 = 0;
                } else if (value44 == 0) {
                    value44 = 1;
                }
                setCarInfo(38, value44, 255, 255);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                int value45 = DataCanbus.DATA[116];
                if (value45 == 1) {
                    value45 = 0;
                } else if (value45 == 0) {
                    value45 = 1;
                }
                setCarInfo(39, value45, 255, 255);
                break;
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                int value46 = DataCanbus.DATA[119];
                if (value46 == 1) {
                    value46 = 0;
                } else if (value46 == 0) {
                    value46 = 1;
                }
                setCarInfo(48, value46, 255, 255);
                break;
            case R.id.ctv_checkedtext15 /* 2131427557 */:
                int value47 = DataCanbus.DATA[121];
                if (value47 == 1) {
                    value47 = 0;
                } else if (value47 == 0) {
                    value47 = 1;
                }
                setCarInfo(49, value47, 255, 255);
                break;
            case R.id.ctv_checkedtext16 /* 2131427558 */:
                int value48 = DataCanbus.DATA[123];
                if (value48 == 1) {
                    value48 = 0;
                } else if (value48 == 0) {
                    value48 = 1;
                }
                setCarInfo(51, value48, 255, 255);
                break;
            case R.id.ctv_checkedtext17 /* 2131427559 */:
                int value49 = DataCanbus.DATA[125];
                if (value49 == 1) {
                    value49 = 0;
                } else if (value49 == 0) {
                    value49 = 1;
                }
                setCarInfo(53, value49, 255, 255);
                break;
            case R.id.ctv_checkedtext18 /* 2131427661 */:
                int value50 = DataCanbus.DATA[126];
                if (value50 == 1) {
                    value50 = 0;
                } else if (value50 == 0) {
                    value50 = 1;
                }
                setCarInfo(54, value50, 255, 255);
                break;
            case R.id.ctv_checkedtext19 /* 2131427663 */:
                int value51 = DataCanbus.DATA[129];
                if (value51 == 1) {
                    value51 = 0;
                } else if (value51 == 0) {
                    value51 = 1;
                }
                setCarInfo(57, value51, 255, 255);
                break;
            case R.id.ctv_checkedtext20 /* 2131427665 */:
                int value52 = DataCanbus.DATA[130];
                if (value52 == 1) {
                    value52 = 0;
                } else if (value52 == 0) {
                    value52 = 1;
                }
                setCarInfo(58, value52, 255, 255);
                break;
            case R.id.ctv_checkedtext21 /* 2131427667 */:
                int value53 = DataCanbus.DATA[131];
                if (value53 == 1) {
                    value53 = 0;
                } else if (value53 == 0) {
                    value53 = 1;
                }
                setCarInfo(59, value53, 255, 255);
                break;
            case R.id.ctv_checkedtext22 /* 2131427669 */:
                int value54 = DataCanbus.DATA[132];
                if (value54 == 1) {
                    value54 = 0;
                } else if (value54 == 0) {
                    value54 = 1;
                }
                setCarInfo(60, value54, 255, 255);
                break;
            case R.id.ctv_checkedtext23 /* 2131427672 */:
                int value55 = DataCanbus.DATA[133];
                if (value55 == 1) {
                    value55 = 0;
                } else if (value55 == 0) {
                    value55 = 1;
                }
                setCarInfo(61, value55, 255, 255);
                break;
            case R.id.ctv_checkedtext24 /* 2131427848 */:
                int value56 = DataCanbus.DATA[134];
                if (value56 == 1) {
                    value56 = 0;
                } else if (value56 == 0) {
                    value56 = 1;
                }
                setCarInfo(62, value56, 255, 255);
                break;
            case R.id.ctv_checkedtext25 /* 2131427850 */:
                int value57 = DataCanbus.DATA[135];
                if (value57 == 1) {
                    value57 = 0;
                } else if (value57 == 0) {
                    value57 = 1;
                }
                setCarInfo(63, value57, 255, 255);
                break;
            case R.id.ctv_checkedtext26 /* 2131427852 */:
                int value58 = DataCanbus.DATA[136];
                if (value58 == 1) {
                    value58 = 0;
                } else if (value58 == 0) {
                    value58 = 1;
                }
                setCarInfo(64, value58, 255, 255);
                break;
            case R.id.ctv_checkedtext27 /* 2131427854 */:
                int value59 = DataCanbus.DATA[137];
                if (value59 == 1) {
                    value59 = 0;
                } else if (value59 == 0) {
                    value59 = 1;
                }
                setCarInfo(65, value59, 255, 255);
                break;
            case R.id.ctv_checkedtext32 /* 2131427892 */:
                int value60 = DataCanbus.DATA[144];
                if (value60 == 1) {
                    value60 = 0;
                } else if (value60 == 0) {
                    value60 = 1;
                }
                setCarInfo(72, value60, 255, 255);
                break;
            case R.id.ctv_checkedtext29 /* 2131427893 */:
                int value61 = DataCanbus.DATA[141];
                if (value61 == 1) {
                    value61 = 0;
                } else if (value61 == 0) {
                    value61 = 1;
                }
                setCarInfo(69, value61, 255, 255);
                break;
            case R.id.ctv_checkedtext30 /* 2131427902 */:
                int value62 = DataCanbus.DATA[142];
                if (value62 == 1) {
                    value62 = 0;
                } else if (value62 == 0) {
                    value62 = 1;
                }
                setCarInfo(70, value62, 255, 255);
                break;
            case R.id.ctv_checkedtext31 /* 2131427903 */:
                int value63 = DataCanbus.DATA[143];
                if (value63 == 1) {
                    value63 = 0;
                } else if (value63 == 0) {
                    value63 = 1;
                }
                setCarInfo(71, value63, 255, 255);
                break;
            case R.id.ctv_checkedtext28 /* 2131427904 */:
                int value64 = DataCanbus.DATA[140];
                if (value64 == 1) {
                    value64 = 0;
                } else if (value64 == 0) {
                    value64 = 1;
                }
                setCarInfo(68, value64, 255, 255);
                break;
            case R.id.ctv_checkedtext33 /* 2131428105 */:
                int value65 = DataCanbus.DATA[151];
                if (value65 == 1) {
                    value65 = 0;
                } else if (value65 == 0) {
                    value65 = 1;
                }
                setCarInfo(73, value65, 255, 255);
                break;
            case R.id.ctv_checkedtext40 /* 2131428339 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, WCProtonSunroofSet.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext34 /* 2131428370 */:
                int value66 = DataCanbus.DATA[152];
                if (value66 == 1) {
                    value66 = 0;
                } else if (value66 == 0) {
                    value66 = 1;
                }
                setCarInfo(74, value66, 255, 255);
                break;
            case R.id.ctv_checkedtext35 /* 2131428372 */:
                int value67 = DataCanbus.DATA[154];
                if (value67 == 1) {
                    value67 = 0;
                } else if (value67 == 0) {
                    value67 = 1;
                }
                setCarInfo(82, value67, 255, 255);
                break;
            case R.id.ctv_checkedtext36 /* 2131428374 */:
                int value68 = DataCanbus.DATA[145];
                if (value68 == 1) {
                    value68 = 0;
                } else if (value68 == 0) {
                    value68 = 1;
                }
                setCarInfo(75, value68, 255, 255);
                break;
            case R.id.ctv_checkedtext37 /* 2131428377 */:
                int value69 = DataCanbus.DATA[146];
                if (value69 == 1) {
                    value69 = 0;
                } else if (value69 == 0) {
                    value69 = 1;
                }
                setCarInfo(76, value69, 255, 255);
                break;
            case R.id.ctv_checkedtext38 /* 2131428379 */:
                int value70 = DataCanbus.DATA[147];
                if (value70 == 1) {
                    value70 = 0;
                } else if (value70 == 0) {
                    value70 = 1;
                }
                setCarInfo(77, value70, 255, 255);
                break;
            case R.id.ctv_checkedtext39 /* 2131428381 */:
                int value71 = DataCanbus.DATA[148];
                if (value71 == 1) {
                    value71 = 0;
                } else if (value71 == 0) {
                    value71 = 1;
                }
                setCarInfo(79, value71, 255, 255);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(1, new int[]{value0, value1, value2, value3}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{97}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
    }
}
