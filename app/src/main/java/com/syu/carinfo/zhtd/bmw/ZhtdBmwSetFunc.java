package com.syu.carinfo.zhtd.bmw;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemProperties;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

public class ZhtdBmwSetFunc extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 112:
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_450_ZHTD_Benz /* 65986 */:
                        case FinalCanbus.CAR_450_ZHTD_Benz_S /* 197058 */:
                            switch (value) {
                                case 0:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("5:NTG4.5_400");
                                    break;
                                case 1:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("4:NTG4.5_800");
                                    break;
                                case 2:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("6:NTG4.0_800");
                                    break;
                                case 3:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("7:NTG4.0_400");
                                    break;
                                case 4:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("8:NTG4.7_800");
                                    break;
                                case 5:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("9:NTG4.7_400");
                                    break;
                                case 6:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("1:NTG5.0_800");
                                    break;
                                case 7:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("10:NTG3.5_800");
                                    break;
                                case 8:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("11:NTG3.5_400");
                                    break;
                                case 9:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("12:NTG3.0_800");
                                    break;
                                case 10:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("13:NTG3.0_400");
                                    break;
                                case 128:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("2:NTG5.0_960");
                                    break;
                                case 129:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("3:NTG5.0_1440");
                                    break;
                                default:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("OFF");
                                    break;
                            }
                        case FinalCanbus.CAR_450_ZHTD_Audi /* 131522 */:
                            switch (value) {
                                case 0:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("1:A4L_800*480 1");
                                    break;
                                case 1:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("2:A4L_800*480 2");
                                    break;
                                case 2:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("3:Q5L_800*480/Q5_400*234");
                                    break;
                                case 3:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("4:A3_400*234/Q3_400*234");
                                    break;
                                case 4:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("5:A3_800*480/Q5_800*480");
                                    break;
                                case 16:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("6:A4L_1280*480/A6_800*480");
                                    break;
                                case 32:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("7:A4L_1280*480 2/Q3 800*480");
                                    break;
                                default:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("OFF");
                                    break;
                            }
                        case FinalCanbus.CAR_450_ZHTD_Lexus /* 262594 */:
                        case FinalCanbus.CAR_450_ZHTD_Lexus_L /* 590274 */:
                            switch (value) {
                                case 0:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("1、800 1");
                                    break;
                                case 1:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("2、800 2");
                                    break;
                                case 2:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("3、800 3");
                                    break;
                                case 3:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("4、800 DE");
                                    break;
                                case 4:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("5、1280 1");
                                    break;
                                case 5:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("6、1280 2");
                                    break;
                                case 6:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("7、1280 DE");
                                    break;
                                case 7:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("8.------");
                                    break;
                                case 8:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("9.------");
                                    break;
                                case 9:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("10。------");
                                    break;
                                default:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("1、800 1");
                                    break;
                            }
                        case FinalCanbus.CAR_450_ZHTD_LandRover /* 328130 */:
                            switch (value) {
                                case 1:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("2、HAMAN 800 2");
                                    break;
                                case 2:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("3、HAMAN ------");
                                    break;
                                case 16:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("4、BOSCH R 800 1");
                                    break;
                                case 17:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("5、BOSCH R 800 2");
                                    break;
                                case 32:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("6、BOSCH C 800 1");
                                    break;
                                case 33:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("7、BOSCH C 800 2");
                                    break;
                                case 34:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("8、BOSCH C 800 3");
                                    break;
                                case 35:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("9、BOSCH C 800 4");
                                    break;
                                case 36:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("10、BOSCH C ----");
                                    break;
                                case 128:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("11、HAMAN 1280 1");
                                    break;
                                case 144:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("12、BOSCH------");
                                    break;
                                default:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("1、HAMAN 800 1");
                                    break;
                            }
                        case FinalCanbus.CAR_450_ZHTD_Volvo /* 524738 */:
                            switch (value) {
                                case 0:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("1:15-19");
                                    break;
                                case 1:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("2:11-14");
                                    break;
                                case 2:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("3:06-10");
                                    break;
                                case 3:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("4:------");
                                    break;
                                default:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("------");
                                    break;
                            }
                        case FinalCanbus.CAR_450_ZHTD_Porsche /* 655810 */:
                            switch (value) {
                                case 1:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("2:C2");
                                    break;
                                case 2:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("3:C3");
                                    break;
                                case 3:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("4:C4");
                                    break;
                                default:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("1.C1");
                                    break;
                            }
                        default:
                            switch (value) {
                                case 0:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("1:1280*480 1(EVO/NBT 8.8/10.25)");
                                    break;
                                case 1:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("2:1280*480 2(EVO/NBT 8.8/10.25)");
                                    break;
                                case 2:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("7:1280*480 (CIC 8.8/10.25)");
                                    break;
                                case 3:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("3:800*480 1(EVO/NBT 6.5)");
                                    break;
                                case 4:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("4:800*480 2(EVO/NBT 6.5)");
                                    break;
                                case 5:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("5:1280*480 1(ID5 8.8/10.25)");
                                    break;
                                case 6:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("6:1280*480 2(ID5 8.8/10.25)");
                                    break;
                                case 7:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("8:800*480 1(CIC 6.5)");
                                    break;
                                case 8:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("9:800*480 2(CIC 6.5)");
                                    break;
                                case 9:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("10:800*480 3(CIC 6.5)");
                                    break;
                                case 10:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("11:800*480 3(CIC 7.0)");
                                    break;
                                case 126:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("12:800*480 1(CCC 6.5)");
                                    break;
                                case 128:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("13:1280*480 1(CCC 8.8)");
                                    break;
                                case 129:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("14:1280*480 2(CCC 8.8)");
                                    break;
                                default:
                                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text9)).setText("OFF");
                                    break;
                            }
                    }
                case 113:
                    if (value >= 7) {
                        ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value - 7).toString());
                        break;
                    } else {
                        ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text2)).setText("-" + (7 - value));
                        break;
                    }
                case 114:
                    if (value >= 7) {
                        ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value - 7).toString());
                        break;
                    } else {
                        ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text3)).setText("-" + (7 - value));
                        break;
                    }
                case 115:
                    if (value >= 7) {
                        ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value - 7).toString());
                        break;
                    } else {
                        ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text4)).setText("-" + (7 - value));
                        break;
                    }
                case 116:
                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                    break;
                case 117:
                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                    break;
                case 118:
                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                    break;
                case 119:
                    switch (value) {
                        case 0:
                            ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text8)).setText(R.string.str_original_car_mode);
                            break;
                        case 1:
                            ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text8)).setText(R.string.str_installation_mode);
                            break;
                        case 2:
                            if (DataCanbus.DATA[1000] == 262594 || DataCanbus.DATA[1000] == 590274) {
                                ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text8)).setText(R.string.str_built_in_360);
                                break;
                            } else {
                                ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text8)).setText("360(VGA)");
                                break;
                            }
                        case 3:
                            ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text8)).setText("360(CVBS)");
                            break;
                    }
                case 120:
                    ((CheckedTextView) ZhtdBmwSetFunc.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                    break;
                case 121:
                    ((CheckedTextView) ZhtdBmwSetFunc.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                    break;
                case 122:
                    ((CheckedTextView) ZhtdBmwSetFunc.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
                    break;
                case 124:
                    if (DataCanbus.DATA[1000] == 65986 || DataCanbus.DATA[1000] == 197058) {
                        switch (value) {
                            case 0:
                                ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text1)).setText("BT");
                                ZhtdBmwSetFunc.this.findViewById(R.id.layout_view1).setVisibility(8);
                                ZhtdBmwSetFunc.this.findViewById(R.id.layout_view2).setVisibility(8);
                                ZhtdBmwSetFunc.this.findViewById(R.id.layout_view3).setVisibility(8);
                                ZhtdBmwSetFunc.this.findViewById(R.id.layout_view4).setVisibility(8);
                                break;
                            case 1:
                                ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text1)).setText("USB");
                                ZhtdBmwSetFunc.this.findViewById(R.id.layout_view1).setVisibility(8);
                                ZhtdBmwSetFunc.this.findViewById(R.id.layout_view2).setVisibility(8);
                                ZhtdBmwSetFunc.this.findViewById(R.id.layout_view3).setVisibility(8);
                                ZhtdBmwSetFunc.this.findViewById(R.id.layout_view4).setVisibility(8);
                                break;
                            case 2:
                                ZhtdBmwSetFunc.this.findViewById(R.id.layout_view1).setVisibility(0);
                                ZhtdBmwSetFunc.this.findViewById(R.id.layout_view2).setVisibility(0);
                                ZhtdBmwSetFunc.this.findViewById(R.id.layout_view3).setVisibility(0);
                                ZhtdBmwSetFunc.this.findViewById(R.id.layout_view4).setVisibility(0);
                                ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text1)).setText("AUX");
                                break;
                            case 3:
                                ZhtdBmwSetFunc.this.findViewById(R.id.layout_view1).setVisibility(0);
                                ZhtdBmwSetFunc.this.findViewById(R.id.layout_view2).setVisibility(8);
                                ZhtdBmwSetFunc.this.findViewById(R.id.layout_view3).setVisibility(0);
                                ZhtdBmwSetFunc.this.findViewById(R.id.layout_view4).setVisibility(8);
                                ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text1)).setText("TV");
                                break;
                        }
                    } else if (DataCanbus.DATA[1000] == 524738 || DataCanbus.DATA[1000] == 262594 || DataCanbus.DATA[1000] == 590274) {
                        ZhtdBmwSetFunc.this.findViewById(R.id.layout_view1).setVisibility(8);
                        ZhtdBmwSetFunc.this.findViewById(R.id.layout_view2).setVisibility(8);
                        ZhtdBmwSetFunc.this.findViewById(R.id.layout_view3).setVisibility(8);
                        ZhtdBmwSetFunc.this.findViewById(R.id.layout_view4).setVisibility(8);
                        switch (value) {
                            case 0:
                                ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text1)).setText("AUTO");
                                break;
                            case 1:
                                ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text1)).setText("OFF");
                                break;
                        }
                    } else {
                        ZhtdBmwSetFunc.this.findViewById(R.id.layout_view1).setVisibility(8);
                        ZhtdBmwSetFunc.this.findViewById(R.id.layout_view2).setVisibility(8);
                        ZhtdBmwSetFunc.this.findViewById(R.id.layout_view3).setVisibility(8);
                        ZhtdBmwSetFunc.this.findViewById(R.id.layout_view4).setVisibility(8);
                        switch (value) {
                            case 0:
                                ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text1)).setText("[NUM 8]");
                                break;
                            case 1:
                                ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text1)).setText("AUTO");
                                break;
                            case 2:
                                ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text1)).setText("HAND");
                                break;
                        }
                    }
                case 126:
                    switch (value) {
                        case 1:
                            ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text10)).setText(R.string.str_aux_activation_state0);
                            break;
                        case 2:
                            ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text10)).setText(R.string.str_aux_activation_state1);
                            break;
                        case 3:
                            ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text10)).setText(R.string.str_aux_activation_state2);
                            break;
                    }
                case 127:
                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                    break;
                case 128:
                    switch (value) {
                        case 0:
                            ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text12)).setText(R.string.crv_source_null);
                            break;
                        case 1:
                            ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text12)).setText(R.string.str_have);
                            break;
                    }
                case 129:
                    switch (value) {
                        case 0:
                            ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text13)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text13)).setText(R.string.rzc_c4l_open);
                            break;
                    }
                case 133:
                    ((CheckedTextView) ZhtdBmwSetFunc.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value == 0);
                    break;
                case 134:
                    switch (value) {
                        case 1:
                            ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text14)).setText("Type2");
                            break;
                        case 2:
                            ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text14)).setText("Type3");
                            break;
                        default:
                            ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text14)).setText("Type1");
                            break;
                    }
                case 135:
                    switch (value) {
                        case 1:
                            ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text15)).setText("Type2");
                            break;
                        default:
                            ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text15)).setText("Type1");
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_zhtd_bmw_setfunc);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        int audio = SystemProperties.getInt("persist.sys.syu.dsp", 0);
        if (audio == 1) {
            findViewById(R.id.layout_view5).setVisibility(8);
            findViewById(R.id.layout_view6).setVisibility(8);
            findViewById(R.id.layout_view7).setVisibility(8);
            findViewById(R.id.layout_view8).setVisibility(8);
            findViewById(R.id.layout_view9).setVisibility(8);
            findViewById(R.id.layout_view10).setVisibility(8);
            findViewById(R.id.layout_view11).setVisibility(8);
            findViewById(R.id.layout_view12).setVisibility(8);
        }
        if (DataCanbus.DATA[1000] != 65986 && DataCanbus.DATA[1000] != 197058 && DataCanbus.DATA[1000] != 524738) {
            findViewById(R.id.layout_view1).setVisibility(8);
            findViewById(R.id.layout_view2).setVisibility(8);
            findViewById(R.id.layout_view3).setVisibility(8);
            findViewById(R.id.layout_view4).setVisibility(8);
        }
        if (DataCanbus.DATA[1000] != 328130) {
            findViewById(R.id.layout_view13).setVisibility(8);
            findViewById(R.id.layout_view14).setVisibility(8);
        }
    }

    @Override
    public void onClick(View v) {
        int value;
        int guij;
        int auto360;
        int mirr;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value2 = DataCanbus.DATA[124] - 1;
                if (DataCanbus.DATA[1000] == 65986 || DataCanbus.DATA[1000] == 197058) {
                    if (value2 < 0) {
                        value2 = 3;
                    }
                } else if (DataCanbus.DATA[1000] == 524738 || DataCanbus.DATA[1000] == 262594 || DataCanbus.DATA[1000] == 590274) {
                    if (value2 < 0) {
                        value2 = 1;
                    }
                } else if (value2 < 0) {
                    value2 = 2;
                }
                setCarInfo(0, value2, 0, 0);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value3 = DataCanbus.DATA[124] + 1;
                if (DataCanbus.DATA[1000] == 65986 || DataCanbus.DATA[1000] == 197058) {
                    if (value3 > 3) {
                        value3 = 0;
                    }
                } else if (DataCanbus.DATA[1000] == 524738 || DataCanbus.DATA[1000] == 262594 || DataCanbus.DATA[1000] == 590274) {
                    if (value3 > 1) {
                        value3 = 0;
                    }
                } else if (value3 > 2) {
                    value3 = 0;
                }
                setCarInfo(0, value3, 0, 0);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int bass = DataCanbus.DATA[113];
                int middle = DataCanbus.DATA[114];
                int treb = DataCanbus.DATA[115];
                if (bass > 0) {
                    bass--;
                }
                setCarInfo(2, bass, middle, treb);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int bass2 = DataCanbus.DATA[113];
                int middle2 = DataCanbus.DATA[114];
                int treb2 = DataCanbus.DATA[115];
                if (bass2 < 14) {
                    bass2++;
                }
                setCarInfo(2, bass2, middle2, treb2);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int bass3 = DataCanbus.DATA[113];
                int middle3 = DataCanbus.DATA[114];
                int treb3 = DataCanbus.DATA[115];
                if (middle3 > 0) {
                    middle3--;
                }
                setCarInfo(2, bass3, middle3, treb3);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int bass4 = DataCanbus.DATA[113];
                int middle4 = DataCanbus.DATA[114];
                int treb4 = DataCanbus.DATA[115];
                if (middle4 < 14) {
                    middle4++;
                }
                setCarInfo(2, bass4, middle4, treb4);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int bass5 = DataCanbus.DATA[113];
                int middle5 = DataCanbus.DATA[114];
                int treb5 = DataCanbus.DATA[115];
                if (treb5 > 0) {
                    treb5--;
                }
                setCarInfo(2, bass5, middle5, treb5);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int bass6 = DataCanbus.DATA[113];
                int middle6 = DataCanbus.DATA[114];
                int treb6 = DataCanbus.DATA[115];
                if (treb6 < 14) {
                    treb6++;
                }
                setCarInfo(2, bass6, middle6, treb6);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int sys = DataCanbus.DATA[116];
                int navi = DataCanbus.DATA[117];
                int bt = DataCanbus.DATA[118];
                if (sys > 0) {
                    sys--;
                }
                setCarInfo(3, sys, navi, bt);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int sys2 = DataCanbus.DATA[116];
                int navi2 = DataCanbus.DATA[117];
                int bt2 = DataCanbus.DATA[118];
                if (sys2 < 40) {
                    sys2++;
                }
                setCarInfo(3, sys2, navi2, bt2);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int sys3 = DataCanbus.DATA[116];
                int navi3 = DataCanbus.DATA[117];
                int bt3 = DataCanbus.DATA[118];
                if (navi3 > 0) {
                    navi3--;
                }
                setCarInfo(3, sys3, navi3, bt3);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int sys4 = DataCanbus.DATA[116];
                int navi4 = DataCanbus.DATA[117];
                int bt4 = DataCanbus.DATA[118];
                if (navi4 < 40) {
                    navi4++;
                }
                setCarInfo(3, sys4, navi4, bt4);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int sys5 = DataCanbus.DATA[116];
                int navi5 = DataCanbus.DATA[117];
                int bt5 = DataCanbus.DATA[118];
                if (bt5 > 0) {
                    bt5--;
                }
                setCarInfo(3, sys5, navi5, bt5);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int sys6 = DataCanbus.DATA[116];
                int navi6 = DataCanbus.DATA[117];
                int bt6 = DataCanbus.DATA[118];
                if (bt6 < 40) {
                    bt6++;
                }
                setCarInfo(3, sys6, navi6, bt6);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int mirr2 = DataCanbus.DATA[121];
                int guij2 = DataCanbus.DATA[120];
                int auto3602 = DataCanbus.DATA[122];
                int type = DataCanbus.DATA[119];
                if (type > 0) {
                    type--;
                }
                setCarInfo(4, ((mirr2 << 4) & 16) | ((auto3602 << 5) & 32) | ((guij2 << 6) & 64) | (type & 7), 0, 0);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int mirr3 = DataCanbus.DATA[121];
                int guij3 = DataCanbus.DATA[120];
                int auto3603 = DataCanbus.DATA[122];
                int type2 = DataCanbus.DATA[119];
                if (type2 < 3) {
                    type2++;
                }
                setCarInfo(4, ((mirr3 << 4) & 16) | ((auto3603 << 5) & 32) | ((guij3 << 6) & 64) | (type2 & 7), 0, 0);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value4 = DataCanbus.DATA[112];
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_450_ZHTD_Benz /* 65986 */:
                    case FinalCanbus.CAR_450_ZHTD_Benz_S /* 197058 */:
                        if (value4 == 10) {
                            value4 = 9;
                            break;
                        } else if (value4 == 9) {
                            value4 = 8;
                            break;
                        } else if (value4 == 8) {
                            value4 = 7;
                            break;
                        } else if (value4 == 7) {
                            value4 = 5;
                            break;
                        } else if (value4 == 5) {
                            value4 = 4;
                            break;
                        } else if (value4 == 4) {
                            value4 = 3;
                            break;
                        } else if (value4 == 3) {
                            value4 = 2;
                            break;
                        } else if (value4 == 2) {
                            value4 = 0;
                            break;
                        } else if (value4 == 0) {
                            value4 = 1;
                            break;
                        } else if (value4 == 1) {
                            value4 = 129;
                            break;
                        } else if (value4 == 129) {
                            value4 = 128;
                            break;
                        } else if (value4 == 128) {
                            value4 = 6;
                            break;
                        } else if (value4 == 6) {
                            value4 = 10;
                            break;
                        }
                    case FinalCanbus.CAR_450_ZHTD_Audi /* 131522 */:
                        if (value4 == 4) {
                            value4 = 3;
                            break;
                        } else if (value4 == 3) {
                            value4 = 2;
                            break;
                        } else if (value4 == 2) {
                            value4 = 1;
                            break;
                        } else if (value4 == 1) {
                            value4 = 0;
                            break;
                        } else if (value4 == 16) {
                            value4 = 4;
                            break;
                        } else if (value4 == 32) {
                            value4 = 16;
                            break;
                        }
                    case FinalCanbus.CAR_450_ZHTD_Lexus /* 262594 */:
                    case FinalCanbus.CAR_450_ZHTD_Lexus_L /* 590274 */:
                        if (value4 == 0) {
                            value4 = 9;
                            break;
                        } else if (value4 == 1) {
                            value4 = 0;
                            break;
                        } else if (value4 == 2) {
                            value4 = 1;
                            break;
                        } else if (value4 == 3) {
                            value4 = 2;
                            break;
                        } else if (value4 == 4) {
                            value4 = 3;
                            break;
                        } else if (value4 == 5) {
                            value4 = 4;
                            break;
                        } else if (value4 == 6) {
                            value4 = 5;
                            break;
                        } else if (value4 == 7) {
                            value4 = 6;
                            break;
                        } else if (value4 == 8) {
                            value4 = 7;
                            break;
                        } else if (value4 == 9) {
                            value4 = 8;
                            break;
                        }
                    case FinalCanbus.CAR_450_ZHTD_LandRover /* 328130 */:
                        if (value4 == 0) {
                            value4 = 144;
                            break;
                        } else if (value4 == 1) {
                            value4 = 0;
                            break;
                        } else if (value4 == 2) {
                            value4 = 1;
                            break;
                        } else if (value4 == 16) {
                            value4 = 2;
                            break;
                        } else if (value4 == 17) {
                            value4 = 16;
                            break;
                        } else if (value4 == 32) {
                            value4 = 17;
                            break;
                        } else if (value4 == 33) {
                            value4 = 32;
                            break;
                        } else if (value4 == 34) {
                            value4 = 33;
                            break;
                        } else if (value4 == 35) {
                            value4 = 34;
                            break;
                        } else if (value4 == 36) {
                            value4 = 35;
                            break;
                        } else if (value4 == 128) {
                            value4 = 36;
                            break;
                        } else if (value4 == 144) {
                            value4 = 128;
                            break;
                        }
                    case FinalCanbus.CAR_450_ZHTD_Volvo /* 524738 */:
                        if (value4 == 0) {
                            value4 = 3;
                            break;
                        } else if (value4 == 1) {
                            value4 = 0;
                            break;
                        } else if (value4 == 2) {
                            value4 = 1;
                            break;
                        } else if (value4 == 3) {
                            value4 = 2;
                            break;
                        }
                    case FinalCanbus.CAR_450_ZHTD_Porsche /* 655810 */:
                        if (value4 == 0) {
                            value4 = 3;
                            break;
                        } else if (value4 == 3) {
                            value4 = 2;
                            break;
                        } else if (value4 == 2) {
                            value4 = 1;
                            break;
                        } else if (value4 == 1) {
                            value4 = 0;
                            break;
                        }
                    default:
                        if (value4 == 255) {
                            value4 = 129;
                            break;
                        } else if (value4 == 129) {
                            value4 = 128;
                            break;
                        } else if (value4 == 128) {
                            value4 = 126;
                            break;
                        } else if (value4 == 126) {
                            value4 = 10;
                            break;
                        } else if (value4 == 10) {
                            value4 = 9;
                            break;
                        } else if (value4 == 9) {
                            value4 = 8;
                            break;
                        } else if (value4 == 8) {
                            value4 = 7;
                            break;
                        } else if (value4 == 7) {
                            value4 = 2;
                            break;
                        } else if (value4 == 2) {
                            value4 = 6;
                            break;
                        } else if (value4 == 6) {
                            value4 = 5;
                            break;
                        } else if (value4 == 5) {
                            value4 = 4;
                            break;
                        } else if (value4 == 4) {
                            value4 = 3;
                            break;
                        } else if (value4 == 3) {
                            value4 = 1;
                            break;
                        } else if (value4 == 1) {
                            value4 = 0;
                            break;
                        }
                }
                setCarInfo(162, 0, value4, 0);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value5 = DataCanbus.DATA[112];
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_450_ZHTD_Benz /* 65986 */:
                    case FinalCanbus.CAR_450_ZHTD_Benz_S /* 197058 */:
                        if (value5 == 6) {
                            value5 = 128;
                            break;
                        } else if (value5 == 128) {
                            value5 = 129;
                            break;
                        } else if (value5 == 129) {
                            value5 = 1;
                            break;
                        } else if (value5 == 1) {
                            value5 = 0;
                            break;
                        } else if (value5 == 0) {
                            value5 = 2;
                            break;
                        } else if (value5 == 2) {
                            value5 = 3;
                            break;
                        } else if (value5 == 3) {
                            value5 = 4;
                            break;
                        } else if (value5 == 4) {
                            value5 = 5;
                            break;
                        } else if (value5 == 5) {
                            value5 = 7;
                            break;
                        } else if (value5 == 7) {
                            value5 = 8;
                            break;
                        } else if (value5 == 8) {
                            value5 = 9;
                            break;
                        } else if (value5 == 9) {
                            value5 = 10;
                            break;
                        } else if (value5 == 10) {
                            value5 = 6;
                            break;
                        }
                    case FinalCanbus.CAR_450_ZHTD_Audi /* 131522 */:
                        if (value5 == 0) {
                            value5 = 1;
                            break;
                        } else if (value5 == 1) {
                            value5 = 2;
                            break;
                        } else if (value5 == 2) {
                            value5 = 3;
                            break;
                        } else if (value5 == 3) {
                            value5 = 4;
                            break;
                        } else if (value5 == 4) {
                            value5 = 16;
                            break;
                        } else if (value5 == 16) {
                            value5 = 32;
                            break;
                        }
                    case FinalCanbus.CAR_450_ZHTD_Lexus /* 262594 */:
                    case FinalCanbus.CAR_450_ZHTD_Lexus_L /* 590274 */:
                        if (value5 == 0) {
                            value5 = 1;
                            break;
                        } else if (value5 == 1) {
                            value5 = 2;
                            break;
                        } else if (value5 == 2) {
                            value5 = 3;
                            break;
                        } else if (value5 == 3) {
                            value5 = 4;
                            break;
                        } else if (value5 == 4) {
                            value5 = 5;
                            break;
                        } else if (value5 == 5) {
                            value5 = 6;
                            break;
                        } else if (value5 == 6) {
                            value5 = 7;
                            break;
                        } else if (value5 == 7) {
                            value5 = 8;
                            break;
                        } else if (value5 == 8) {
                            value5 = 9;
                            break;
                        } else if (value5 == 9) {
                            value5 = 0;
                            break;
                        }
                    case FinalCanbus.CAR_450_ZHTD_LandRover /* 328130 */:
                        if (value5 == 0) {
                            value5 = 1;
                            break;
                        } else if (value5 == 1) {
                            value5 = 2;
                            break;
                        } else if (value5 == 2) {
                            value5 = 16;
                            break;
                        } else if (value5 == 16) {
                            value5 = 17;
                            break;
                        } else if (value5 == 17) {
                            value5 = 32;
                            break;
                        } else if (value5 == 32) {
                            value5 = 33;
                            break;
                        } else if (value5 == 33) {
                            value5 = 34;
                            break;
                        } else if (value5 == 34) {
                            value5 = 35;
                            break;
                        } else if (value5 == 35) {
                            value5 = 36;
                            break;
                        } else if (value5 == 36) {
                            value5 = 128;
                            break;
                        } else if (value5 == 128) {
                            value5 = 144;
                            break;
                        } else if (value5 == 144) {
                            value5 = 0;
                            break;
                        }
                    case FinalCanbus.CAR_450_ZHTD_Volvo /* 524738 */:
                        if (value5 == 0) {
                            value5 = 1;
                            break;
                        } else if (value5 == 1) {
                            value5 = 2;
                            break;
                        } else if (value5 == 2) {
                            value5 = 3;
                            break;
                        } else if (value5 == 3) {
                            value5 = 0;
                            break;
                        }
                    case FinalCanbus.CAR_450_ZHTD_Porsche /* 655810 */:
                        if (value5 == 0) {
                            value5 = 1;
                            break;
                        } else if (value5 == 1) {
                            value5 = 2;
                            break;
                        } else if (value5 == 2) {
                            value5 = 3;
                            break;
                        } else if (value5 == 3) {
                            value5 = 0;
                            break;
                        }
                    default:
                        if (value5 == 0) {
                            value5 = 1;
                            break;
                        } else if (value5 == 1) {
                            value5 = 3;
                            break;
                        } else if (value5 == 3) {
                            value5 = 4;
                            break;
                        } else if (value5 == 4) {
                            value5 = 5;
                            break;
                        } else if (value5 == 5) {
                            value5 = 6;
                            break;
                        } else if (value5 == 6) {
                            value5 = 2;
                            break;
                        } else if (value5 == 2) {
                            value5 = 7;
                            break;
                        } else if (value5 == 7) {
                            value5 = 8;
                            break;
                        } else if (value5 == 8) {
                            value5 = 9;
                            break;
                        } else if (value5 == 9) {
                            value5 = 10;
                            break;
                        } else if (value5 == 10) {
                            value5 = 126;
                            break;
                        } else if (value5 == 126) {
                            value5 = 128;
                            break;
                        } else if (value5 == 128) {
                            value5 = 129;
                            break;
                        } else if (value5 == 129) {
                            value5 = 255;
                            break;
                        }
                }
                setCarInfo(162, 0, value5, 0);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value6 = DataCanbus.DATA[127] - 1;
                if (value6 < 1) {
                    value6 = 15;
                }
                setCarInfo(241, value6, 0, 0);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value7 = DataCanbus.DATA[127] + 1;
                if (value7 > 15) {
                    value7 = 1;
                }
                setCarInfo(241, value7, 0, 0);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value8 = DataCanbus.DATA[128] - 1;
                if (value8 < 0) {
                    value8 = 1;
                }
                setCarInfo(242, value8, 0, 0);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value9 = DataCanbus.DATA[128] + 1;
                if (value9 > 1) {
                    value9 = 0;
                }
                setCarInfo(242, value9, 0, 0);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value10 = DataCanbus.DATA[129] - 1;
                if (value10 < 0) {
                    value10 = 1;
                }
                setCarInfo(243, value10, 0, 0);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value11 = DataCanbus.DATA[129] + 1;
                if (value11 > 1) {
                    value11 = 0;
                }
                setCarInfo(243, value11, 0, 0);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value12 = DataCanbus.DATA[134] - 1;
                if (value12 < 0) {
                    value12 = 2;
                }
                setCarInfo(16, value12, 0, 0);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value13 = DataCanbus.DATA[134] + 1;
                if (value13 > 2) {
                    value13 = 0;
                }
                setCarInfo(16, value13, 0, 0);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value14 = DataCanbus.DATA[135] - 1;
                if (value14 < 0) {
                    value14 = 1;
                }
                setCarInfo(17, value14, 0, 0);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value15 = DataCanbus.DATA[135] + 1;
                if (value15 > 1) {
                    value15 = 0;
                }
                setCarInfo(17, value15, 0, 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int mirr4 = DataCanbus.DATA[121];
                if (mirr4 == 0) {
                    mirr = 1;
                } else {
                    mirr = 0;
                }
                int guij4 = DataCanbus.DATA[120];
                int auto3604 = DataCanbus.DATA[122];
                setCarInfo(4, ((mirr << 4) & 16) | ((auto3604 << 5) & 32) | ((guij4 << 6) & 64) | (DataCanbus.DATA[119] & 7), 0, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int mirr5 = DataCanbus.DATA[121];
                int guij5 = DataCanbus.DATA[120];
                int auto3605 = DataCanbus.DATA[122];
                if (auto3605 == 0) {
                    auto360 = 1;
                } else {
                    auto360 = 0;
                }
                setCarInfo(4, ((mirr5 << 4) & 16) | ((auto360 << 5) & 32) | ((guij5 << 6) & 64) | (DataCanbus.DATA[119] & 7), 0, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int mirr6 = DataCanbus.DATA[121];
                int guij6 = DataCanbus.DATA[120];
                if (guij6 == 0) {
                    guij = 1;
                } else {
                    guij = 0;
                }
                int auto3606 = DataCanbus.DATA[122];
                setCarInfo(4, ((mirr6 << 4) & 16) | ((auto3606 << 5) & 32) | ((guij << 6) & 64) | (DataCanbus.DATA[119] & 7), 0, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                dialog();
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                if (DataCanbus.DATA[133] == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                setCarInfo(151, value, 0, 0);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1, value2, value3}, null, null);
    }

    @Override
    public void addNotify() {
        DataCanbus.PROXY.cmd(3, new int[]{1}, null, null);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.notifyCanbus);
    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.str_aux_activation_progress1));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        ZhtdBmwSetFunc.this.setCarInfo(5, 0, 0, 0);
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
