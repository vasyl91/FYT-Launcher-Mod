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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ZhtdBmwSetFunc extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.zhtd.bmw.ZhtdBmwSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 21:
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
                case 44:
                    if (value >= 7) {
                        ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value - 7).toString());
                        break;
                    } else {
                        ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text2)).setText("-" + (7 - value));
                        break;
                    }
                case 45:
                    if (value >= 7) {
                        ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value - 7).toString());
                        break;
                    } else {
                        ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text3)).setText("-" + (7 - value));
                        break;
                    }
                case 46:
                    if (value >= 7) {
                        ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value - 7).toString());
                        break;
                    } else {
                        ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text4)).setText("-" + (7 - value));
                        break;
                    }
                case 47:
                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                    break;
                case 48:
                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                    break;
                case 49:
                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                    break;
                case 50:
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
                case 51:
                    ((CheckedTextView) ZhtdBmwSetFunc.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                    break;
                case 52:
                    ((CheckedTextView) ZhtdBmwSetFunc.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                    break;
                case 53:
                    ((CheckedTextView) ZhtdBmwSetFunc.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
                    break;
                case 55:
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
                case 57:
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
                case 58:
                    ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                    break;
                case 59:
                    switch (value) {
                        case 0:
                            ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text12)).setText(R.string.crv_source_null);
                            break;
                        case 1:
                            ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text12)).setText(R.string.str_have);
                            break;
                    }
                case 60:
                    switch (value) {
                        case 0:
                            ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text13)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text13)).setText(R.string.rzc_c4l_open);
                            break;
                    }
                case 64:
                    ((CheckedTextView) ZhtdBmwSetFunc.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value == 0);
                    break;
                case 65:
                    switch (value) {
                        case 1:
                            ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text14)).setText("Type2");
                            break;
                        default:
                            ((TextView) ZhtdBmwSetFunc.this.findViewById(R.id.tv_text14)).setText("Type1");
                            break;
                    }
                case 66:
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_zhtd_bmw_setfunc);
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int guij;
        int auto360;
        int mirr;
        switch (v.getId()) {
            case R.id.btn_minus13 /* 2131427468 */:
                int value2 = DataCanbus.DATA[65] - 1;
                if (value2 < 0) {
                    value2 = 1;
                }
                setCarInfo(16, value2, 0, 0);
                break;
            case R.id.btn_plus13 /* 2131427470 */:
                int value3 = DataCanbus.DATA[65] + 1;
                if (value3 > 1) {
                    value3 = 0;
                }
                setCarInfo(16, value3, 0, 0);
                break;
            case R.id.btn_minus14 /* 2131427471 */:
                int value4 = DataCanbus.DATA[66] - 1;
                if (value4 < 0) {
                    value4 = 1;
                }
                setCarInfo(17, value4, 0, 0);
                break;
            case R.id.btn_plus14 /* 2131427473 */:
                int value5 = DataCanbus.DATA[66] + 1;
                if (value5 > 1) {
                    value5 = 0;
                }
                setCarInfo(17, value5, 0, 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int mirr2 = DataCanbus.DATA[52];
                if (mirr2 == 0) {
                    mirr = 1;
                } else {
                    mirr = 0;
                }
                int guij2 = DataCanbus.DATA[51];
                int auto3602 = DataCanbus.DATA[53];
                setCarInfo(4, ((mirr << 4) & 16) | ((auto3602 << 5) & 32) | ((guij2 << 6) & 64) | (DataCanbus.DATA[50] & 7), 0, 0);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value6 = DataCanbus.DATA[55] - 1;
                if (DataCanbus.DATA[1000] == 65986 || DataCanbus.DATA[1000] == 197058) {
                    if (value6 < 0) {
                        value6 = 3;
                    }
                } else if (DataCanbus.DATA[1000] == 524738 || DataCanbus.DATA[1000] == 262594 || DataCanbus.DATA[1000] == 590274) {
                    if (value6 < 0) {
                        value6 = 1;
                    }
                } else if (value6 < 0) {
                    value6 = 2;
                }
                setCarInfo(0, value6, 0, 0);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value7 = DataCanbus.DATA[55] + 1;
                if (DataCanbus.DATA[1000] == 65986 || DataCanbus.DATA[1000] == 197058) {
                    if (value7 > 3) {
                        value7 = 0;
                    }
                } else if (DataCanbus.DATA[1000] == 524738 || DataCanbus.DATA[1000] == 262594 || DataCanbus.DATA[1000] == 590274) {
                    if (value7 > 1) {
                        value7 = 0;
                    }
                } else if (value7 > 2) {
                    value7 = 0;
                }
                setCarInfo(0, value7, 0, 0);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int bass = DataCanbus.DATA[44];
                int middle = DataCanbus.DATA[45];
                int treb = DataCanbus.DATA[46];
                if (bass > 0) {
                    bass--;
                }
                setCarInfo(2, bass, middle, treb);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int bass2 = DataCanbus.DATA[44];
                int middle2 = DataCanbus.DATA[45];
                int treb2 = DataCanbus.DATA[46];
                if (bass2 < 14) {
                    bass2++;
                }
                setCarInfo(2, bass2, middle2, treb2);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int bass3 = DataCanbus.DATA[44];
                int middle3 = DataCanbus.DATA[45];
                int treb3 = DataCanbus.DATA[46];
                if (middle3 > 0) {
                    middle3--;
                }
                setCarInfo(2, bass3, middle3, treb3);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int bass4 = DataCanbus.DATA[44];
                int middle4 = DataCanbus.DATA[45];
                int treb4 = DataCanbus.DATA[46];
                if (middle4 < 14) {
                    middle4++;
                }
                setCarInfo(2, bass4, middle4, treb4);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int bass5 = DataCanbus.DATA[44];
                int middle5 = DataCanbus.DATA[45];
                int treb5 = DataCanbus.DATA[46];
                if (treb5 > 0) {
                    treb5--;
                }
                setCarInfo(2, bass5, middle5, treb5);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int bass6 = DataCanbus.DATA[44];
                int middle6 = DataCanbus.DATA[45];
                int treb6 = DataCanbus.DATA[46];
                if (treb6 < 14) {
                    treb6++;
                }
                setCarInfo(2, bass6, middle6, treb6);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int sys = DataCanbus.DATA[47];
                int navi = DataCanbus.DATA[48];
                int bt = DataCanbus.DATA[49];
                if (sys > 0) {
                    sys--;
                }
                setCarInfo(3, sys, navi, bt);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int sys2 = DataCanbus.DATA[47];
                int navi2 = DataCanbus.DATA[48];
                int bt2 = DataCanbus.DATA[49];
                if (sys2 < 40) {
                    sys2++;
                }
                setCarInfo(3, sys2, navi2, bt2);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int sys3 = DataCanbus.DATA[47];
                int navi3 = DataCanbus.DATA[48];
                int bt3 = DataCanbus.DATA[49];
                if (navi3 > 0) {
                    navi3--;
                }
                setCarInfo(3, sys3, navi3, bt3);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int sys4 = DataCanbus.DATA[47];
                int navi4 = DataCanbus.DATA[48];
                int bt4 = DataCanbus.DATA[49];
                if (navi4 < 40) {
                    navi4++;
                }
                setCarInfo(3, sys4, navi4, bt4);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int sys5 = DataCanbus.DATA[47];
                int navi5 = DataCanbus.DATA[48];
                int bt5 = DataCanbus.DATA[49];
                if (bt5 > 0) {
                    bt5--;
                }
                setCarInfo(3, sys5, navi5, bt5);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int sys6 = DataCanbus.DATA[47];
                int navi6 = DataCanbus.DATA[48];
                int bt6 = DataCanbus.DATA[49];
                if (bt6 < 40) {
                    bt6++;
                }
                setCarInfo(3, sys6, navi6, bt6);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int mirr3 = DataCanbus.DATA[52];
                int guij3 = DataCanbus.DATA[51];
                int auto3603 = DataCanbus.DATA[53];
                int type = DataCanbus.DATA[50];
                if (type > 0) {
                    type--;
                }
                setCarInfo(4, ((mirr3 << 4) & 16) | ((auto3603 << 5) & 32) | ((guij3 << 6) & 64) | (type & 7), 0, 0);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int mirr4 = DataCanbus.DATA[52];
                int guij4 = DataCanbus.DATA[51];
                int auto3604 = DataCanbus.DATA[53];
                int type2 = DataCanbus.DATA[50];
                if (type2 < 3) {
                    type2++;
                }
                setCarInfo(4, ((mirr4 << 4) & 16) | ((auto3604 << 5) & 32) | ((guij4 << 6) & 64) | (type2 & 7), 0, 0);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value8 = DataCanbus.DATA[21];
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_450_ZHTD_Benz /* 65986 */:
                    case FinalCanbus.CAR_450_ZHTD_Benz_S /* 197058 */:
                        if (value8 == 5) {
                            value8 = 4;
                            break;
                        } else if (value8 == 4) {
                            value8 = 3;
                            break;
                        } else if (value8 == 3) {
                            value8 = 2;
                            break;
                        } else if (value8 == 2) {
                            value8 = 0;
                            break;
                        } else if (value8 == 0) {
                            value8 = 1;
                            break;
                        } else if (value8 == 1) {
                            value8 = 129;
                            break;
                        } else if (value8 == 129) {
                            value8 = 128;
                            break;
                        } else if (value8 == 128) {
                            value8 = 6;
                            break;
                        }
                    case FinalCanbus.CAR_450_ZHTD_Audi /* 131522 */:
                        if (value8 == 4) {
                            value8 = 3;
                            break;
                        } else if (value8 == 3) {
                            value8 = 2;
                            break;
                        } else if (value8 == 2) {
                            value8 = 1;
                            break;
                        } else if (value8 == 1) {
                            value8 = 0;
                            break;
                        } else if (value8 == 16) {
                            value8 = 4;
                            break;
                        } else if (value8 == 32) {
                            value8 = 16;
                            break;
                        }
                    case FinalCanbus.CAR_450_ZHTD_Lexus /* 262594 */:
                    case FinalCanbus.CAR_450_ZHTD_Lexus_L /* 590274 */:
                        if (value8 == 0) {
                            value8 = 9;
                            break;
                        } else if (value8 == 1) {
                            value8 = 0;
                            break;
                        } else if (value8 == 2) {
                            value8 = 1;
                            break;
                        } else if (value8 == 3) {
                            value8 = 2;
                            break;
                        } else if (value8 == 4) {
                            value8 = 3;
                            break;
                        } else if (value8 == 5) {
                            value8 = 4;
                            break;
                        } else if (value8 == 6) {
                            value8 = 5;
                            break;
                        } else if (value8 == 7) {
                            value8 = 6;
                            break;
                        } else if (value8 == 8) {
                            value8 = 7;
                            break;
                        } else if (value8 == 9) {
                            value8 = 8;
                            break;
                        }
                    case FinalCanbus.CAR_450_ZHTD_LandRover /* 328130 */:
                        if (value8 == 0) {
                            value8 = 144;
                            break;
                        } else if (value8 == 1) {
                            value8 = 0;
                            break;
                        } else if (value8 == 2) {
                            value8 = 1;
                            break;
                        } else if (value8 == 16) {
                            value8 = 2;
                            break;
                        } else if (value8 == 17) {
                            value8 = 16;
                            break;
                        } else if (value8 == 32) {
                            value8 = 17;
                            break;
                        } else if (value8 == 33) {
                            value8 = 32;
                            break;
                        } else if (value8 == 34) {
                            value8 = 33;
                            break;
                        } else if (value8 == 35) {
                            value8 = 34;
                            break;
                        } else if (value8 == 36) {
                            value8 = 35;
                            break;
                        } else if (value8 == 128) {
                            value8 = 36;
                            break;
                        } else if (value8 == 144) {
                            value8 = 128;
                            break;
                        }
                    case FinalCanbus.CAR_450_ZHTD_Volvo /* 524738 */:
                        if (value8 == 0) {
                            value8 = 3;
                            break;
                        } else if (value8 == 1) {
                            value8 = 0;
                            break;
                        } else if (value8 == 2) {
                            value8 = 1;
                            break;
                        } else if (value8 == 3) {
                            value8 = 2;
                            break;
                        }
                    case FinalCanbus.CAR_450_ZHTD_Porsche /* 655810 */:
                        if (value8 == 0) {
                            value8 = 3;
                            break;
                        } else if (value8 == 3) {
                            value8 = 2;
                            break;
                        } else if (value8 == 2) {
                            value8 = 1;
                            break;
                        } else if (value8 == 1) {
                            value8 = 0;
                            break;
                        }
                        break;
                    default:
                        if (value8 == 255) {
                            value8 = 129;
                            break;
                        } else if (value8 == 129) {
                            value8 = 128;
                            break;
                        } else if (value8 == 128) {
                            value8 = 126;
                            break;
                        } else if (value8 == 126) {
                            value8 = 10;
                            break;
                        } else if (value8 == 10) {
                            value8 = 9;
                            break;
                        } else if (value8 == 9) {
                            value8 = 8;
                            break;
                        } else if (value8 == 8) {
                            value8 = 7;
                            break;
                        } else if (value8 == 7) {
                            value8 = 2;
                            break;
                        } else if (value8 == 2) {
                            value8 = 6;
                            break;
                        } else if (value8 == 6) {
                            value8 = 5;
                            break;
                        } else if (value8 == 5) {
                            value8 = 4;
                            break;
                        } else if (value8 == 4) {
                            value8 = 3;
                            break;
                        } else if (value8 == 3) {
                            value8 = 1;
                            break;
                        } else if (value8 == 1) {
                            value8 = 0;
                            break;
                        }
                }
                setCarInfo(162, 0, value8, 0);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value9 = DataCanbus.DATA[21];
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_450_ZHTD_Benz /* 65986 */:
                    case FinalCanbus.CAR_450_ZHTD_Benz_S /* 197058 */:
                        if (value9 == 6) {
                            value9 = 128;
                            break;
                        } else if (value9 == 128) {
                            value9 = 129;
                            break;
                        } else if (value9 == 129) {
                            value9 = 1;
                            break;
                        } else if (value9 == 1) {
                            value9 = 0;
                            break;
                        } else if (value9 == 0) {
                            value9 = 2;
                            break;
                        } else if (value9 == 2) {
                            value9 = 3;
                            break;
                        } else if (value9 == 3) {
                            value9 = 4;
                            break;
                        } else if (value9 == 4) {
                            value9 = 5;
                            break;
                        }
                    case FinalCanbus.CAR_450_ZHTD_Audi /* 131522 */:
                        if (value9 == 0) {
                            value9 = 1;
                            break;
                        } else if (value9 == 1) {
                            value9 = 2;
                            break;
                        } else if (value9 == 2) {
                            value9 = 3;
                            break;
                        } else if (value9 == 3) {
                            value9 = 4;
                            break;
                        } else if (value9 == 4) {
                            value9 = 16;
                            break;
                        } else if (value9 == 16) {
                            value9 = 32;
                            break;
                        }
                    case FinalCanbus.CAR_450_ZHTD_Lexus /* 262594 */:
                    case FinalCanbus.CAR_450_ZHTD_Lexus_L /* 590274 */:
                        if (value9 == 0) {
                            value9 = 1;
                            break;
                        } else if (value9 == 1) {
                            value9 = 2;
                            break;
                        } else if (value9 == 2) {
                            value9 = 3;
                            break;
                        } else if (value9 == 3) {
                            value9 = 4;
                            break;
                        } else if (value9 == 4) {
                            value9 = 5;
                            break;
                        } else if (value9 == 5) {
                            value9 = 6;
                            break;
                        } else if (value9 == 6) {
                            value9 = 7;
                            break;
                        } else if (value9 == 7) {
                            value9 = 8;
                            break;
                        } else if (value9 == 8) {
                            value9 = 9;
                            break;
                        } else if (value9 == 9) {
                            value9 = 0;
                            break;
                        }
                    case FinalCanbus.CAR_450_ZHTD_LandRover /* 328130 */:
                        if (value9 == 0) {
                            value9 = 1;
                            break;
                        } else if (value9 == 1) {
                            value9 = 2;
                            break;
                        } else if (value9 == 2) {
                            value9 = 16;
                            break;
                        } else if (value9 == 16) {
                            value9 = 17;
                            break;
                        } else if (value9 == 17) {
                            value9 = 32;
                            break;
                        } else if (value9 == 32) {
                            value9 = 33;
                            break;
                        } else if (value9 == 33) {
                            value9 = 34;
                            break;
                        } else if (value9 == 34) {
                            value9 = 35;
                            break;
                        } else if (value9 == 35) {
                            value9 = 36;
                            break;
                        } else if (value9 == 36) {
                            value9 = 128;
                            break;
                        } else if (value9 == 128) {
                            value9 = 144;
                            break;
                        } else if (value9 == 144) {
                            value9 = 0;
                            break;
                        }
                    case FinalCanbus.CAR_450_ZHTD_Volvo /* 524738 */:
                        if (value9 == 0) {
                            value9 = 1;
                            break;
                        } else if (value9 == 1) {
                            value9 = 2;
                            break;
                        } else if (value9 == 2) {
                            value9 = 3;
                            break;
                        } else if (value9 == 3) {
                            value9 = 0;
                            break;
                        }
                    case FinalCanbus.CAR_450_ZHTD_Porsche /* 655810 */:
                        if (value9 == 0) {
                            value9 = 1;
                            break;
                        } else if (value9 == 1) {
                            value9 = 2;
                            break;
                        } else if (value9 == 2) {
                            value9 = 3;
                            break;
                        } else if (value9 == 3) {
                            value9 = 0;
                            break;
                        }
                        break;
                    default:
                        if (value9 == 0) {
                            value9 = 1;
                            break;
                        } else if (value9 == 1) {
                            value9 = 3;
                            break;
                        } else if (value9 == 3) {
                            value9 = 4;
                            break;
                        } else if (value9 == 4) {
                            value9 = 5;
                            break;
                        } else if (value9 == 5) {
                            value9 = 6;
                            break;
                        } else if (value9 == 6) {
                            value9 = 2;
                            break;
                        } else if (value9 == 2) {
                            value9 = 7;
                            break;
                        } else if (value9 == 7) {
                            value9 = 8;
                            break;
                        } else if (value9 == 8) {
                            value9 = 9;
                            break;
                        } else if (value9 == 9) {
                            value9 = 10;
                            break;
                        } else if (value9 == 10) {
                            value9 = 126;
                            break;
                        } else if (value9 == 126) {
                            value9 = 128;
                            break;
                        } else if (value9 == 128) {
                            value9 = 129;
                            break;
                        } else if (value9 == 129) {
                            value9 = 255;
                            break;
                        }
                }
                setCarInfo(162, 0, value9, 0);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value10 = DataCanbus.DATA[58] - 1;
                if (value10 < 1) {
                    value10 = 15;
                }
                setCarInfo(241, value10, 0, 0);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value11 = DataCanbus.DATA[58] + 1;
                if (value11 > 15) {
                    value11 = 1;
                }
                setCarInfo(241, value11, 0, 0);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value12 = DataCanbus.DATA[59] - 1;
                if (value12 < 0) {
                    value12 = 1;
                }
                setCarInfo(242, value12, 0, 0);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value13 = DataCanbus.DATA[59] + 1;
                if (value13 > 1) {
                    value13 = 0;
                }
                setCarInfo(242, value13, 0, 0);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int value14 = DataCanbus.DATA[60] - 1;
                if (value14 < 0) {
                    value14 = 1;
                }
                setCarInfo(243, value14, 0, 0);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int value15 = DataCanbus.DATA[60] + 1;
                if (value15 > 1) {
                    value15 = 0;
                }
                setCarInfo(243, value15, 0, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int mirr5 = DataCanbus.DATA[52];
                int guij5 = DataCanbus.DATA[51];
                int auto3605 = DataCanbus.DATA[53];
                if (auto3605 == 0) {
                    auto360 = 1;
                } else {
                    auto360 = 0;
                }
                setCarInfo(4, ((mirr5 << 4) & 16) | ((auto360 << 5) & 32) | ((guij5 << 6) & 64) | (DataCanbus.DATA[50] & 7), 0, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int mirr6 = DataCanbus.DATA[52];
                int guij6 = DataCanbus.DATA[51];
                if (guij6 == 0) {
                    guij = 1;
                } else {
                    guij = 0;
                }
                int auto3606 = DataCanbus.DATA[53];
                setCarInfo(4, ((mirr6 << 4) & 16) | ((auto3606 << 5) & 32) | ((guij << 6) & 64) | (DataCanbus.DATA[50] & 7), 0, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                dialog();
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                if (DataCanbus.DATA[64] == 1) {
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

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(3, new int[]{1}, null, null);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.notifyCanbus);
    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.str_aux_activation_progress1));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.zhtd.bmw.ZhtdBmwSetFunc.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.zhtd.bmw.ZhtdBmwSetFunc.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ZhtdBmwSetFunc.this.setCarInfo(5, 0, 0, 0);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.zhtd.bmw.ZhtdBmwSetFunc.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
