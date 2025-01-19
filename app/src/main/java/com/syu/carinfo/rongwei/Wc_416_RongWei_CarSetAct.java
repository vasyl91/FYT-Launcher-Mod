package com.syu.carinfo.rongwei;

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
import com.syu.module.canbus.FinalCanbus;

public class Wc_416_RongWei_CarSetAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 110:
                    Wc_416_RongWei_CarSetAct.this.setCheck((CheckedTextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    if (((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text1)).setText(R.string.wc_ruiteng_string_intelligent_unlocke_0);
                                break;
                            case 1:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text1)).setText(R.string.wc_ruiteng_string_intelligent_unlocke_1);
                                break;
                        }
                    }
                    break;
                case 111:
                    Wc_416_RongWei_CarSetAct.this.setCheck((CheckedTextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    if (((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text2)).setText(R.string.wc_ruiteng_string_intelligent_unlocke_0);
                                break;
                            case 1:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text2)).setText(R.string.wc_ruiteng_string_intelligent_unlocke_1);
                                break;
                        }
                    }
                    break;
                case 112:
                    Wc_416_RongWei_CarSetAct.this.setCheck((CheckedTextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 113:
                    Wc_416_RongWei_CarSetAct.this.setCheck((CheckedTextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    if (((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text3)).setText(R.string.dj_airuize7_prompt_light);
                                break;
                            case 1:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text3)).setText(R.string.dj_airuize7_prompt_lightsounds);
                                break;
                        }
                    }
                    break;
                case 115:
                    Wc_416_RongWei_CarSetAct.this.setCheck((CheckedTextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 116:
                    Wc_416_RongWei_CarSetAct.this.setCheck((CheckedTextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 117:
                    Wc_416_RongWei_CarSetAct.this.setCheck((CheckedTextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 118:
                    Wc_416_RongWei_CarSetAct.this.setCheck((CheckedTextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 119:
                    if (((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_klc_nomal);
                                break;
                            case 1:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text5)).setText(R.string.wc_golf_comfort);
                                break;
                            case 2:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text5)).setText(R.string.driver_system_sports);
                                break;
                        }
                    }
                    break;
                case 120:
                    if (((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text4)).setText("30S");
                                break;
                            case 1:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text4)).setText("60S");
                                break;
                            case 2:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text4)).setText("90S");
                                break;
                        }
                    }
                    break;
                case 121:
                    Wc_416_RongWei_CarSetAct.this.setCheck((CheckedTextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 122:
                    Wc_416_RongWei_CarSetAct.this.setCheck((CheckedTextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 123:
                    Wc_416_RongWei_CarSetAct.this.setCheck((CheckedTextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 124:
                    Wc_416_RongWei_CarSetAct.this.setCheck((CheckedTextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 125:
                    Wc_416_RongWei_CarSetAct.this.setCheck((CheckedTextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 126:
                    Wc_416_RongWei_CarSetAct.this.setCheck((CheckedTextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 127:
                    Wc_416_RongWei_CarSetAct.this.setCheck((CheckedTextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.ctv_checkedtext15), value == 1);
                    break;
                case 128:
                    Wc_416_RongWei_CarSetAct.this.setCheck((CheckedTextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.ctv_checkedtext16), value == 1);
                    break;
                case 129:
                    if (((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text6)).setText("30S");
                                break;
                            case 1:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text6)).setText("60S");
                                break;
                            case 2:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text6)).setText("90S");
                                break;
                            case 3:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text6)).setText("120S");
                                break;
                            case 4:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text6)).setText("150S");
                                break;
                            case 5:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text6)).setText("180S");
                                break;
                            case 6:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text6)).setText("210S");
                                break;
                            case 7:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text6)).setText("240S");
                                break;
                            case 8:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text6)).setText("270S");
                                break;
                            case 9:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text6)).setText("300S");
                                break;
                        }
                    }
                    break;
                case 130:
                    if (((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text7)).setText("30S");
                                break;
                            case 1:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text7)).setText("60S");
                                break;
                            case 2:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text7)).setText("90S");
                                break;
                            case 3:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text7)).setText("120S");
                                break;
                            case 4:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text7)).setText("150S");
                                break;
                            case 5:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text7)).setText("180S");
                                break;
                            case 6:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text7)).setText("210S");
                                break;
                            case 7:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text7)).setText("240S");
                                break;
                            case 8:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text7)).setText("270S");
                                break;
                            case 9:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text7)).setText("300S");
                                break;
                        }
                    }
                    break;
                case 131:
                    Wc_416_RongWei_CarSetAct.this.setCheck((CheckedTextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.ctv_checkedtext17), value == 1);
                    break;
                case 132:
                    Wc_416_RongWei_CarSetAct.this.setCheck((CheckedTextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.ctv_checkedtext18), value == 1);
                    break;
                case 133:
                    if (((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_low);
                                break;
                            case 1:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 134:
                    if (((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text9)).setText(R.string.str_smart_mode);
                                break;
                            case 1:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text9)).setText(R.string.str_power_maintain);
                                break;
                            case 2:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text9)).setText(R.string.str_forced_charging);
                                break;
                        }
                    }
                    break;
                case 135:
                    if (((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text10)).setText(R.string.driver_system_economics);
                                break;
                            case 1:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text10)).setText(R.string.driver_system_standard);
                                break;
                            case 2:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text10)).setText(R.string.driver_system_sports);
                                break;
                            case 3:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text10)).setText(R.string.wc_17zhinanzhe_str1);
                                break;
                        }
                    }
                    break;
                case 136:
                    if (((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text11)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text11)).setText(R.string.driver_system_economics);
                                break;
                            case 1:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text11)).setText(R.string.driver_system_standard);
                                break;
                            case 2:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text11)).setText(R.string.driver_system_sports);
                                break;
                        }
                    }
                    break;
                case 137:
                    if (((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text12)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text12)).setText(R.string.str_light_state);
                                break;
                            case 1:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text12)).setText(R.string.driver_system_standard);
                                break;
                            case 2:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text12)).setText(R.string.driver_system_sports);
                                break;
                        }
                    }
                    break;
                case 138:
                    if (((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text13)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text13)).setText(R.string.driver_system_economics);
                                break;
                            case 1:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text13)).setText(R.string.driver_system_standard);
                                break;
                        }
                    }
                    break;
                case 139:
                    Wc_416_RongWei_CarSetAct.this.setCheck((CheckedTextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.ctv_checkedtext19), value == 1);
                    break;
                case 140:
                    Wc_416_RongWei_CarSetAct.this.setCheck((CheckedTextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.ctv_checkedtext20), value == 1);
                    break;
                case 141:
                    if (((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text14)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text14)).setText(R.string.str_manual_speed_limit);
                                break;
                            case 1:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text14)).setText(R.string.str_speed_alarm);
                                break;
                            case 2:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text14)).setText(R.string.str_intelligent_speed_limit);
                                break;
                        }
                    }
                    break;
                case 142:
                    Wc_416_RongWei_CarSetAct.this.setCheck((CheckedTextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.ctv_checkedtext21), value == 1);
                    break;
                case 143:
                    Wc_416_RongWei_CarSetAct.this.setCheck((CheckedTextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.ctv_checkedtext22), value == 1);
                    break;
                case 144:
                    if (((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text15)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text15)).setText(R.string.klc_air_low);
                                break;
                            case 1:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text15)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text15)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 145:
                    Wc_416_RongWei_CarSetAct.this.setCheck((CheckedTextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.ctv_checkedtext23), value == 1);
                    break;
                case 146:
                    Wc_416_RongWei_CarSetAct.this.setCheck((CheckedTextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.ctv_checkedtext24), value == 1);
                    break;
                case 147:
                    if (((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text16)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text16)).setText(R.string.alarm);
                                break;
                            case 1:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text16)).setText(R.string.str_mode1);
                                break;
                            case 2:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text16)).setText(R.string.str_mode2);
                                break;
                        }
                    }
                    break;
                case 148:
                    if (((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text17)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text17)).setText(R.string.klc_air_low);
                                break;
                            case 1:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text17)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text17)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 149:
                    if (((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text19)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text19)).setText(R.string.klc_air_low);
                                break;
                            case 1:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text19)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text19)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 150:
                    if (((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text18)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text18)).setText(R.string.alarm);
                                break;
                            case 1:
                                ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text18)).setText(R.string.jeep_forwardcollisionbrake);
                                break;
                        }
                    }
                    break;
                case 151:
                    Wc_416_RongWei_CarSetAct.this.setCheck((CheckedTextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.ctv_checkedtext25), value == 1);
                    break;
                case 152:
                    Wc_416_RongWei_CarSetAct.this.setCheck((CheckedTextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.ctv_checkedtext26), value == 1);
                    break;
                case 153:
                    Wc_416_RongWei_CarSetAct.this.setCheck((CheckedTextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.ctv_checkedtext27), value == 1);
                    break;
                case 154:
                    Wc_416_RongWei_CarSetAct.this.setCheck((CheckedTextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.ctv_checkedtext28), value == 1);
                    break;
                case 155:
                    Wc_416_RongWei_CarSetAct.this.setCheck((CheckedTextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.ctv_checkedtext29), value == 1);
                    break;
                case 156:
                    Wc_416_RongWei_CarSetAct.this.setCheck((CheckedTextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.ctv_checkedtext30), value == 1);
                    break;
                case 157:
                    Wc_416_RongWei_CarSetAct.this.setCheck((CheckedTextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.ctv_checkedtext31), value == 1);
                    break;
                case 158:
                    if (((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text20)) != null) {
                        ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text20)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 159:
                    break;
                case 160:
                    if (((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text22)) != null) {
                        ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text22)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 161:
                    if (((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text23)) != null) {
                        ((TextView) Wc_416_RongWei_CarSetAct.this.findViewById(R.id.tv_text23)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0416_wc_rongwei_settings);
        init();
    }

    @Override
    public void init() {
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
        setSelfClick((Button) findViewById(R.id.btn_minus16), this);
        setSelfClick((Button) findViewById(R.id.btn_plus16), this);
        setSelfClick((Button) findViewById(R.id.btn_minus17), this);
        setSelfClick((Button) findViewById(R.id.btn_plus17), this);
        setSelfClick((Button) findViewById(R.id.btn_minus18), this);
        setSelfClick((Button) findViewById(R.id.btn_plus18), this);
        setSelfClick((Button) findViewById(R.id.btn_minus19), this);
        setSelfClick((Button) findViewById(R.id.btn_plus19), this);
        setSelfClick((Button) findViewById(R.id.btn_minus20), this);
        setSelfClick((Button) findViewById(R.id.btn_plus20), this);
        findViewById(R.id.layout_view1).setVisibility(8);
        findViewById(R.id.layout_view2).setVisibility(8);
        findViewById(R.id.layout_view3).setVisibility(8);
        findViewById(R.id.layout_view4).setVisibility(8);
        findViewById(R.id.layout_view5).setVisibility(8);
        findViewById(R.id.layout_view6).setVisibility(8);
        findViewById(R.id.layout_view7).setVisibility(8);
        findViewById(R.id.layout_view8).setVisibility(8);
        findViewById(R.id.layout_view9).setVisibility(8);
        findViewById(R.id.layout_view10).setVisibility(8);
        findViewById(R.id.layout_view11).setVisibility(8);
        findViewById(R.id.layout_view12).setVisibility(8);
        findViewById(R.id.layout_view13).setVisibility(8);
        findViewById(R.id.layout_view14).setVisibility(8);
        findViewById(R.id.layout_view15).setVisibility(8);
        findViewById(R.id.layout_view16).setVisibility(8);
        findViewById(R.id.layout_view17).setVisibility(8);
        findViewById(R.id.layout_view18).setVisibility(8);
        findViewById(R.id.layout_view19).setVisibility(8);
        findViewById(R.id.layout_view20).setVisibility(8);
        findViewById(R.id.layout_view21).setVisibility(8);
        findViewById(R.id.layout_view22).setVisibility(8);
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
        findViewById(R.id.layout_view35).setVisibility(8);
        findViewById(R.id.layout_view36).setVisibility(8);
        findViewById(R.id.layout_view37).setVisibility(8);
        findViewById(R.id.layout_view38).setVisibility(8);
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
        switch (DataCanbus.DATA[1000]) {
            case 416:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view51).setVisibility(0);
                findViewById(R.id.layout_view52).setVisibility(0);
                findViewById(R.id.layout_view53).setVisibility(0);
                break;
            case FinalCanbus.CAR_WC2_17MingJue6 /* 65952 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_view47).setVisibility(0);
                findViewById(R.id.layout_view48).setVisibility(0);
                findViewById(R.id.layout_view50).setVisibility(0);
                findViewById(R.id.layout_view52).setVisibility(0);
                break;
            case FinalCanbus.CAR_WC2_RongWei_I5 /* 131488 */:
            case FinalCanbus.CAR_WC2_RongWei_I5_H /* 459168 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view30).setVisibility(0);
                findViewById(R.id.layout_view31).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view34).setVisibility(0);
                findViewById(R.id.layout_view39).setVisibility(0);
                findViewById(R.id.layout_view40).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                break;
            case FinalCanbus.CAR_WC2_RongWei_I6 /* 197024 */:
            case FinalCanbus.CAR_WC2_RongWei_EI6 /* 262560 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view29).setVisibility(0);
                findViewById(R.id.layout_view52).setVisibility(0);
                break;
            case FinalCanbus.CAR_WC2_RongWei_RX3 /* 328096 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view52).setVisibility(0);
                findViewById(R.id.layout_view53).setVisibility(0);
                break;
            case FinalCanbus.CAR_WC2_RongWei_HS /* 393632 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[120] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(9, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[120] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(9, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[119] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(3, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[119] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(3, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[129] - 1;
                if (value5 < 0) {
                    value5 = 9;
                }
                setCarInfo(41, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[129] + 1;
                if (value6 > 9) {
                    value6 = 0;
                }
                setCarInfo(41, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[130] - 1;
                if (value7 < 0) {
                    value7 = 9;
                }
                setCarInfo(42, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[130] + 1;
                if (value8 > 9) {
                    value8 = 0;
                }
                setCarInfo(42, value8);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value9 = DataCanbus.DATA[134] - 1;
                if (value9 < 0) {
                    value9 = 2;
                }
                setCarInfo(67, value9);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value10 = DataCanbus.DATA[134] + 1;
                if (value10 > 2) {
                    value10 = 0;
                }
                setCarInfo(67, value10);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value11 = DataCanbus.DATA[135] - 1;
                if (value11 < 0) {
                    value11 = 3;
                }
                setCarInfo(81, value11);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value12 = DataCanbus.DATA[135] + 1;
                if (value12 > 3) {
                    value12 = 0;
                }
                setCarInfo(81, value12);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value13 = DataCanbus.DATA[136] - 1;
                if (value13 < 0) {
                    value13 = 2;
                }
                setCarInfo(82, value13);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value14 = DataCanbus.DATA[136] + 1;
                if (value14 > 2) {
                    value14 = 0;
                }
                setCarInfo(82, value14);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value15 = DataCanbus.DATA[137] - 1;
                if (value15 < 0) {
                    value15 = 2;
                }
                setCarInfo(83, value15);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value16 = DataCanbus.DATA[137] + 1;
                if (value16 > 2) {
                    value16 = 0;
                }
                setCarInfo(83, value16);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value17 = DataCanbus.DATA[138] - 1;
                if (value17 < 0) {
                    value17 = 1;
                }
                setCarInfo(84, value17);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value18 = DataCanbus.DATA[138] + 1;
                if (value18 > 1) {
                    value18 = 0;
                }
                setCarInfo(84, value18);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value19 = DataCanbus.DATA[141] - 1;
                if (value19 < 0) {
                    value19 = 2;
                }
                setCarInfo(98, value19);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value20 = DataCanbus.DATA[141] + 1;
                if (value20 > 2) {
                    value20 = 0;
                }
                setCarInfo(98, value20);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value21 = DataCanbus.DATA[144] - 1;
                if (value21 < 0) {
                    value21 = 2;
                }
                setCarInfo(100, value21);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value22 = DataCanbus.DATA[144] + 1;
                if (value22 > 2) {
                    value22 = 0;
                }
                setCarInfo(100, value22);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value23 = DataCanbus.DATA[147] - 1;
                if (value23 < 0) {
                    value23 = 2;
                }
                setCarInfo(104, value23);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value24 = DataCanbus.DATA[147] + 1;
                if (value24 > 2) {
                    value24 = 0;
                }
                setCarInfo(104, value24);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value25 = DataCanbus.DATA[148] - 1;
                if (value25 < 0) {
                    value25 = 2;
                }
                setCarInfo(105, value25);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value26 = DataCanbus.DATA[148] + 1;
                if (value26 > 2) {
                    value26 = 0;
                }
                setCarInfo(105, value26);
                break;
            case R.id.btn_minus15 /* 2131427515 */:
                int value27 = DataCanbus.DATA[150] - 1;
                if (value27 < 0) {
                    value27 = 1;
                }
                setCarInfo(108, value27);
                break;
            case R.id.btn_plus15 /* 2131427517 */:
                int value28 = DataCanbus.DATA[150] + 1;
                if (value28 > 1) {
                    value28 = 0;
                }
                setCarInfo(108, value28);
                break;
            case R.id.btn_minus16 /* 2131427518 */:
                int value29 = DataCanbus.DATA[149] - 1;
                if (value29 < 0) {
                    value29 = 2;
                }
                setCarInfo(109, value29);
                break;
            case R.id.btn_plus16 /* 2131427520 */:
                int value30 = DataCanbus.DATA[149] + 1;
                if (value30 > 2) {
                    value30 = 0;
                }
                setCarInfo(109, value30);
                break;
            case R.id.btn_minus17 /* 2131427521 */:
                int value31 = DataCanbus.DATA[158];
                if (value31 > 30) {
                    value31 -= 5;
                }
                if (value31 < 30) {
                    value31 = 30;
                }
                setCarInfo(115, value31);
                break;
            case R.id.btn_plus17 /* 2131427523 */:
                int value32 = DataCanbus.DATA[158];
                if (value32 < 240) {
                    value32 += 5;
                }
                if (value32 > 240) {
                    value32 = 240;
                }
                setCarInfo(115, value32);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value33 = DataCanbus.DATA[110];
                if (value33 == 1) {
                    value33 = 0;
                } else if (value33 == 0) {
                    value33 = 1;
                }
                setCarInfo(32, value33);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value34 = DataCanbus.DATA[111];
                if (value34 == 1) {
                    value34 = 0;
                } else if (value34 == 0) {
                    value34 = 1;
                }
                setCarInfo(18, value34);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value35 = DataCanbus.DATA[112];
                if (value35 == 1) {
                    value35 = 0;
                } else if (value35 == 0) {
                    value35 = 1;
                }
                setCarInfo(58, value35);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value36 = DataCanbus.DATA[113];
                if (value36 == 1) {
                    value36 = 0;
                } else if (value36 == 0) {
                    value36 = 1;
                }
                setCarInfo(59, value36);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value37 = DataCanbus.DATA[115];
                if (value37 == 1) {
                    value37 = 0;
                } else if (value37 == 0) {
                    value37 = 1;
                }
                setCarInfo(60, value37);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value38 = DataCanbus.DATA[116];
                if (value38 == 1) {
                    value38 = 0;
                } else if (value38 == 0) {
                    value38 = 1;
                }
                setCarInfo(61, value38);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value39 = DataCanbus.DATA[117];
                if (value39 == 1) {
                    value39 = 0;
                } else if (value39 == 0) {
                    value39 = 1;
                }
                setCarInfo(6, value39);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value40 = DataCanbus.DATA[118];
                if (value40 == 1) {
                    value40 = 0;
                } else if (value40 == 0) {
                    value40 = 1;
                }
                setCarInfo(8, value40);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value41 = DataCanbus.DATA[121];
                if (value41 == 1) {
                    value41 = 0;
                } else if (value41 == 0) {
                    value41 = 1;
                }
                setCarInfo(65, value41);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int value42 = DataCanbus.DATA[122];
                if (value42 == 1) {
                    value42 = 0;
                } else if (value42 == 0) {
                    value42 = 1;
                }
                setCarInfo(66, value42);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                int value43 = DataCanbus.DATA[123];
                if (value43 == 1) {
                    value43 = 0;
                } else if (value43 == 0) {
                    value43 = 1;
                }
                setCarInfo(35, value43);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                int value44 = DataCanbus.DATA[124];
                if (value44 == 1) {
                    value44 = 0;
                } else if (value44 == 0) {
                    value44 = 1;
                }
                setCarInfo(36, value44);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                int value45 = DataCanbus.DATA[125];
                if (value45 == 1) {
                    value45 = 0;
                } else if (value45 == 0) {
                    value45 = 1;
                }
                setCarInfo(37, value45);
                break;
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                int value46 = DataCanbus.DATA[126];
                if (value46 == 1) {
                    value46 = 0;
                } else if (value46 == 0) {
                    value46 = 1;
                }
                setCarInfo(37, value46);
                break;
            case R.id.ctv_checkedtext15 /* 2131427557 */:
                int value47 = DataCanbus.DATA[127];
                if (value47 == 1) {
                    value47 = 0;
                } else if (value47 == 0) {
                    value47 = 1;
                }
                setCarInfo(38, value47);
                break;
            case R.id.ctv_checkedtext16 /* 2131427558 */:
                int value48 = DataCanbus.DATA[128];
                if (value48 == 1) {
                    value48 = 0;
                } else if (value48 == 0) {
                    value48 = 1;
                }
                setCarInfo(39, value48);
                break;
            case R.id.ctv_checkedtext17 /* 2131427559 */:
                int value49 = DataCanbus.DATA[131];
                if (value49 == 1) {
                    value49 = 0;
                } else if (value49 == 0) {
                    value49 = 1;
                }
                setCarInfo(70, value49);
                break;
            case R.id.ctv_checkedtext18 /* 2131427661 */:
                int value50 = DataCanbus.DATA[132];
                if (value50 == 1) {
                    value50 = 0;
                } else if (value50 == 0) {
                    value50 = 1;
                }
                setCarInfo(4, value50);
                break;
            case R.id.ctv_checkedtext19 /* 2131427663 */:
                int value51 = DataCanbus.DATA[139];
                if (value51 == 1) {
                    value51 = 0;
                } else if (value51 == 0) {
                    value51 = 1;
                }
                setCarInfo(68, value51);
                break;
            case R.id.ctv_checkedtext20 /* 2131427665 */:
                int value52 = DataCanbus.DATA[140];
                if (value52 == 1) {
                    value52 = 0;
                } else if (value52 == 0) {
                    value52 = 1;
                }
                setCarInfo(101, value52);
                break;
            case R.id.ctv_checkedtext21 /* 2131427667 */:
                int value53 = DataCanbus.DATA[142];
                if (value53 == 1) {
                    value53 = 0;
                } else if (value53 == 0) {
                    value53 = 1;
                }
                setCarInfo(97, value53);
                break;
            case R.id.ctv_checkedtext22 /* 2131427669 */:
                int value54 = DataCanbus.DATA[143];
                if (value54 == 1) {
                    value54 = 0;
                } else if (value54 == 0) {
                    value54 = 1;
                }
                setCarInfo(99, value54);
                break;
            case R.id.ctv_checkedtext23 /* 2131427672 */:
                int value55 = DataCanbus.DATA[145];
                if (value55 == 1) {
                    value55 = 0;
                } else if (value55 == 0) {
                    value55 = 1;
                }
                setCarInfo(102, value55);
                break;
            case R.id.ctv_checkedtext24 /* 2131427848 */:
                int value56 = DataCanbus.DATA[146];
                if (value56 == 1) {
                    value56 = 0;
                } else if (value56 == 0) {
                    value56 = 1;
                }
                setCarInfo(103, value56);
                break;
            case R.id.ctv_checkedtext25 /* 2131427850 */:
                int value57 = DataCanbus.DATA[151];
                if (value57 == 1) {
                    value57 = 0;
                } else if (value57 == 0) {
                    value57 = 1;
                }
                setCarInfo(107, value57);
                break;
            case R.id.ctv_checkedtext26 /* 2131427852 */:
                int value58 = DataCanbus.DATA[152];
                if (value58 == 1) {
                    value58 = 0;
                } else if (value58 == 0) {
                    value58 = 1;
                }
                setCarInfo(106, value58);
                break;
            case R.id.ctv_checkedtext27 /* 2131427854 */:
                int value59 = DataCanbus.DATA[153];
                if (value59 == 1) {
                    value59 = 0;
                } else if (value59 == 0) {
                    value59 = 1;
                }
                setCarInfo(110, value59);
                break;
            case R.id.ctv_checkedtext32 /* 2131427892 */:
                dialog(R.string.str_416_reset_tire, 169);
                break;
            case R.id.ctv_checkedtext29 /* 2131427893 */:
                int value60 = DataCanbus.DATA[155];
                if (value60 == 1) {
                    value60 = 0;
                } else if (value60 == 0) {
                    value60 = 1;
                }
                setCarInfo(112, value60);
                break;
            case R.id.btn_minus19 /* 2131427896 */:
                int value61 = DataCanbus.DATA[160];
                if (value61 > 0) {
                    value61--;
                }
                setCarInfo(24, value61);
                break;
            case R.id.btn_plus19 /* 2131427897 */:
                int value62 = DataCanbus.DATA[160];
                if (value62 < 10) {
                    value62++;
                }
                setCarInfo(24, value62);
                break;
            case R.id.ctv_checkedtext30 /* 2131427902 */:
                int value63 = DataCanbus.DATA[156];
                if (value63 == 1) {
                    value63 = 0;
                } else if (value63 == 0) {
                    value63 = 1;
                }
                setCarInfo(113, value63);
                break;
            case R.id.ctv_checkedtext31 /* 2131427903 */:
                int value64 = DataCanbus.DATA[157];
                if (value64 == 1) {
                    value64 = 0;
                } else if (value64 == 0) {
                    value64 = 1;
                }
                setCarInfo(114, value64);
                break;
            case R.id.ctv_checkedtext28 /* 2131427904 */:
                int value65 = DataCanbus.DATA[154];
                if (value65 == 1) {
                    value65 = 0;
                } else if (value65 == 0) {
                    value65 = 1;
                }
                setCarInfo(111, value65);
                break;
            case R.id.btn_minus20 /* 2131427905 */:
                int value66 = DataCanbus.DATA[161];
                if (value66 > 51) {
                    value66--;
                }
                setCarInfo(69, value66);
                break;
            case R.id.btn_plus20 /* 2131427906 */:
                int value67 = DataCanbus.DATA[161];
                if (value67 < 127) {
                    value67++;
                }
                setCarInfo(69, value67);
                break;
            case R.id.ctv_checkedtext33 /* 2131428105 */:
                dialog(R.string.rzc_klc_default_set_str, 170);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{102}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(1, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
