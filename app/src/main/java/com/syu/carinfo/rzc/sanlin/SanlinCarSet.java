package com.syu.carinfo.rzc.sanlin;

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

public class SanlinCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 104:
                    SanlinCarSet.this.updateText1(val);
                    break;
                case 105:
                    SanlinCarSet.this.updateText2(val);
                    break;
                case 106:
                    SanlinCarSet.this.updateText3(val);
                    break;
                case 107:
                    SanlinCarSet.this.updateText4(val);
                    break;
                case 108:
                    SanlinCarSet.this.updateText5(val);
                    break;
                case 109:
                    SanlinCarSet.this.updateText6(val);
                    break;
                case 110:
                    SanlinCarSet.this.updateText7(val);
                    break;
                case 111:
                    SanlinCarSet.this.updateText8(val);
                    break;
                case 112:
                    SanlinCarSet.this.updateText9(val);
                    break;
                case 113:
                    SanlinCarSet.this.setCheck((CheckedTextView) SanlinCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 144);
                    break;
                case 114:
                    SanlinCarSet.this.updateText10(val);
                    break;
                case 115:
                    SanlinCarSet.this.updateText11(val);
                    break;
                case 116:
                    SanlinCarSet.this.updateText12(val);
                    break;
                case 117:
                    SanlinCarSet.this.updateText13(val);
                    break;
                case 118:
                    SanlinCarSet.this.updateText14(val);
                    break;
                case 119:
                    SanlinCarSet.this.setCheck((CheckedTextView) SanlinCarSet.this.findViewById(R.id.ctv_checkedtext2), val == 144);
                    break;
                case 120:
                    SanlinCarSet.this.updateText15(val);
                    break;
                case 121:
                    SanlinCarSet.this.updateText16(val);
                    break;
                case 122:
                    SanlinCarSet.this.updateText17(val);
                    break;
                case 123:
                    SanlinCarSet.this.updateText18(val);
                    break;
                case 124:
                    SanlinCarSet.this.updateText19(val);
                    break;
                case 125:
                    SanlinCarSet.this.updateText20(val);
                    break;
                case 126:
                    SanlinCarSet.this.updateText21(val);
                    break;
                case 127:
                    SanlinCarSet.this.updateText22(val);
                    break;
                case 128:
                    SanlinCarSet.this.updateText23(val);
                    break;
                case 129:
                    SanlinCarSet.this.setCheck((CheckedTextView) SanlinCarSet.this.findViewById(R.id.ctv_checkedtext3), val == 144);
                    break;
                case 130:
                    SanlinCarSet.this.updateText24(val);
                    break;
                case 131:
                    SanlinCarSet.this.updateText25(val);
                    break;
                case 132:
                    SanlinCarSet.this.updateText26(val);
                    break;
                case 133:
                    if (((TextView) SanlinCarSet.this.findViewById(R.id.tv_text27)) != null) {
                        if (val > 11) {
                            ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text27)).setText("R" + (val - 11));
                            break;
                        } else if (val < 11) {
                            ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text27)).setText("F" + (11 - val));
                            break;
                        } else {
                            ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text27)).setText("0");
                            break;
                        }
                    }
                    break;
                case 134:
                    if (((TextView) SanlinCarSet.this.findViewById(R.id.tv_text28)) != null) {
                        if (val > 11) {
                            ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text28)).setText("R" + (val - 11));
                            break;
                        } else if (val < 11) {
                            ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text28)).setText("L" + (11 - val));
                            break;
                        } else {
                            ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text28)).setText("0");
                            break;
                        }
                    }
                    break;
                case 135:
                    if (((TextView) SanlinCarSet.this.findViewById(R.id.tv_text29)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text29)).setText("ROCK");
                                break;
                            case 1:
                                ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text29)).setText("POP");
                                break;
                            case 2:
                                ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text29)).setText("HIPHOP");
                                break;
                            case 3:
                                ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text29)).setText("JAZZ");
                                break;
                            case 4:
                                ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text29)).setText("NORMAL");
                                break;
                        }
                    }
                    break;
                case 136:
                    if (((TextView) SanlinCarSet.this.findViewById(R.id.tv_text30)) != null) {
                        if (val > 7) {
                            ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text30)).setText("+" + (val - 7));
                            break;
                        } else if (val < 7) {
                            ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text30)).setText("-" + (7 - val));
                            break;
                        } else {
                            ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text30)).setText("0");
                            break;
                        }
                    }
                    break;
                case 137:
                    if (((TextView) SanlinCarSet.this.findViewById(R.id.tv_text32)) != null) {
                        if (val > 7) {
                            ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text32)).setText("+" + (val - 7));
                            break;
                        } else if (val < 7) {
                            ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text32)).setText("-" + (7 - val));
                            break;
                        } else {
                            ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text32)).setText("0");
                            break;
                        }
                    }
                    break;
                case 138:
                    if (((TextView) SanlinCarSet.this.findViewById(R.id.tv_text31)) != null) {
                        if (val > 7) {
                            ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text31)).setText("+" + (val - 7));
                            break;
                        } else if (val < 7) {
                            ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text31)).setText("-" + (7 - val));
                            break;
                        } else {
                            ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text31)).setText("0");
                            break;
                        }
                    }
                    break;
                case 139:
                    if (((TextView) SanlinCarSet.this.findViewById(R.id.tv_text33)) != null) {
                        if (val > 5) {
                            ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text33)).setText("+" + (val - 5));
                            break;
                        } else if (val < 5) {
                            ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text33)).setText("-" + (5 - val));
                            break;
                        } else {
                            ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text33)).setText("0");
                            break;
                        }
                    }
                    break;
                case 140:
                    if (((TextView) SanlinCarSet.this.findViewById(R.id.tv_text34)) != null) {
                        ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text34)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 141:
                    if (((TextView) SanlinCarSet.this.findViewById(R.id.tv_text35)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text35)).setText("OFF");
                                break;
                            case 1:
                                ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text35)).setText("DTS Neural");
                                break;
                            case 2:
                                ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text35)).setText("PREMIDIA WIDE");
                                break;
                        }
                    }
                    break;
                case 142:
                    if (((TextView) SanlinCarSet.this.findViewById(R.id.tv_text36)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text36)).setText("ALL");
                                break;
                            case 1:
                                ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text36)).setText("Front");
                                break;
                            case 2:
                                ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text36)).setText("Driver");
                                break;
                        }
                    }
                    break;
                case 143:
                    if (((TextView) SanlinCarSet.this.findViewById(R.id.tv_text37)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text37)).setText("OFF");
                                break;
                            case 1:
                                ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text37)).setText("LOW");
                                break;
                            case 2:
                                ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text37)).setText("HIGH");
                                break;
                        }
                    }
                    break;
                case 144:
                    if (((TextView) SanlinCarSet.this.findViewById(R.id.tv_text38)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text38)).setText("OFF");
                                break;
                            case 1:
                                ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text38)).setText("LOW");
                                break;
                            case 2:
                                ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text38)).setText("MID");
                                break;
                            case 3:
                                ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text38)).setText("HIGH");
                                break;
                        }
                    }
                    break;
                case 145:
                    if (((TextView) SanlinCarSet.this.findViewById(R.id.tv_text39)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text39)).setText("OFF");
                                break;
                            case 1:
                                ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text39)).setText("LOW");
                                break;
                            case 2:
                                ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text39)).setText("MID");
                                break;
                            case 3:
                                ((TextView) SanlinCarSet.this.findViewById(R.id.tv_text39)).setText("HIGH");
                                break;
                        }
                    }
                    break;
                case 146:
                    SanlinCarSet.this.setCheck((CheckedTextView) SanlinCarSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_rzc_sanlin_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
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
        setSelfClick((Button) findViewById(R.id.btn_minus21), this);
        setSelfClick((Button) findViewById(R.id.btn_plus21), this);
        setSelfClick((Button) findViewById(R.id.btn_minus22), this);
        setSelfClick((Button) findViewById(R.id.btn_plus22), this);
        setSelfClick((Button) findViewById(R.id.btn_minus23), this);
        setSelfClick((Button) findViewById(R.id.btn_plus23), this);
        setSelfClick((Button) findViewById(R.id.btn_minus24), this);
        setSelfClick((Button) findViewById(R.id.btn_plus24), this);
        setSelfClick((Button) findViewById(R.id.btn_minus25), this);
        setSelfClick((Button) findViewById(R.id.btn_plus25), this);
        setSelfClick((Button) findViewById(R.id.btn_minus26), this);
        setSelfClick((Button) findViewById(R.id.btn_plus26), this);
        setSelfClick((Button) findViewById(R.id.btn_minus27), this);
        setSelfClick((Button) findViewById(R.id.btn_plus27), this);
        setSelfClick((Button) findViewById(R.id.btn_minus28), this);
        setSelfClick((Button) findViewById(R.id.btn_plus28), this);
        setSelfClick((Button) findViewById(R.id.btn_minus29), this);
        setSelfClick((Button) findViewById(R.id.btn_plus29), this);
        setSelfClick((Button) findViewById(R.id.btn_minus30), this);
        setSelfClick((Button) findViewById(R.id.btn_plus30), this);
        setSelfClick((Button) findViewById(R.id.btn_minus31), this);
        setSelfClick((Button) findViewById(R.id.btn_plus31), this);
        setSelfClick((Button) findViewById(R.id.btn_minus32), this);
        setSelfClick((Button) findViewById(R.id.btn_plus32), this);
        setSelfClick((Button) findViewById(R.id.btn_minus33), this);
        setSelfClick((Button) findViewById(R.id.btn_plus33), this);
        setSelfClick((Button) findViewById(R.id.btn_minus34), this);
        setSelfClick((Button) findViewById(R.id.btn_plus34), this);
        setSelfClick((Button) findViewById(R.id.btn_minus35), this);
        setSelfClick((Button) findViewById(R.id.btn_plus35), this);
        setSelfClick((Button) findViewById(R.id.btn_minus36), this);
        setSelfClick((Button) findViewById(R.id.btn_plus36), this);
        setSelfClick((Button) findViewById(R.id.btn_minus37), this);
        setSelfClick((Button) findViewById(R.id.btn_plus37), this);
        setSelfClick((Button) findViewById(R.id.btn_minus38), this);
        setSelfClick((Button) findViewById(R.id.btn_plus38), this);
        setSelfClick((Button) findViewById(R.id.btn_minus39), this);
        setSelfClick((Button) findViewById(R.id.btn_plus39), this);
        findViewById(R.id.layout_text_view1).setVisibility(8);
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
        findViewById(R.id.layout_text_view2).setVisibility(8);
        findViewById(R.id.layout_view15).setVisibility(8);
        findViewById(R.id.layout_text_view3).setVisibility(8);
        findViewById(R.id.layout_view16).setVisibility(8);
        findViewById(R.id.layout_view17).setVisibility(8);
        findViewById(R.id.layout_view18).setVisibility(8);
        findViewById(R.id.layout_text_view4).setVisibility(8);
        findViewById(R.id.layout_view19).setVisibility(8);
        findViewById(R.id.layout_view20).setVisibility(8);
        findViewById(R.id.layout_view21).setVisibility(8);
        findViewById(R.id.layout_view22).setVisibility(8);
        findViewById(R.id.layout_view23).setVisibility(8);
        findViewById(R.id.layout_text_view5).setVisibility(8);
        findViewById(R.id.layout_view24).setVisibility(8);
        findViewById(R.id.layout_view25).setVisibility(8);
        findViewById(R.id.layout_view26).setVisibility(8);
        findViewById(R.id.layout_view27).setVisibility(8);
        findViewById(R.id.layout_view28).setVisibility(8);
        findViewById(R.id.layout_text_view6).setVisibility(8);
        findViewById(R.id.layout_view29).setVisibility(8);
        findViewById(R.id.layout_view30).setVisibility(8);
        findViewById(R.id.layout_view31).setVisibility(8);
        findViewById(R.id.layout_text_view7).setVisibility(8);
        findViewById(R.id.layout_view32).setVisibility(8);
        findViewById(R.id.layout_view33).setVisibility(8);
        findViewById(R.id.layout_view34).setVisibility(8);
        findViewById(R.id.layout_text_view8).setVisibility(8);
        findViewById(R.id.layout_view36).setVisibility(8);
        findViewById(R.id.layout_view37).setVisibility(8);
        findViewById(R.id.layout_view38).setVisibility(8);
        findViewById(R.id.layout_view39).setVisibility(8);
        findViewById(R.id.layout_view40).setVisibility(8);
        findViewById(R.id.layout_text_view9).setVisibility(8);
        findViewById(R.id.layout_view41).setVisibility(8);
        findViewById(R.id.layout_view42).setVisibility(8);
        findViewById(R.id.layout_view43).setVisibility(8);
        findViewById(R.id.layout_view44).setVisibility(8);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_439_RZC_Sanlin_18Pajieluo_H /* 9634231 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                break;
            case FinalCanbus.CAR_439_RZC_Sanlin_19Yige /* 10224055 */:
            case FinalCanbus.CAR_439_RZC_Sanlin_19Yige_H /* 10289591 */:
            case FinalCanbus.CAR_454_RZC_Sanlin_Pajero_22_Sport /* 10420678 */:
            case FinalCanbus.CAR_454_RZC_Sanlin_Pajero_22_Sport_H /* 10486214 */:
            case FinalCanbus.CAR_454_RZC_Sanlin_LancerEVO_08 /* 15991238 */:
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_text_view6).setVisibility(0);
                findViewById(R.id.layout_view29).setVisibility(0);
                findViewById(R.id.layout_view30).setVisibility(0);
                findViewById(R.id.layout_view31).setVisibility(0);
                findViewById(R.id.layout_text_view7).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view34).setVisibility(0);
                findViewById(R.id.layout_text_view8).setVisibility(0);
                findViewById(R.id.layout_view36).setVisibility(0);
                findViewById(R.id.layout_view37).setVisibility(0);
                findViewById(R.id.layout_view38).setVisibility(0);
                findViewById(R.id.layout_view39).setVisibility(0);
                findViewById(R.id.layout_view40).setVisibility(0);
                findViewById(R.id.layout_text_view9).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                findViewById(R.id.layout_view42).setVisibility(0);
                findViewById(R.id.layout_view43).setVisibility(0);
                findViewById(R.id.layout_view44).setVisibility(0);
                break;
            case FinalCanbus.CAR_439_RZC_Sanlin_19Yige_Top /* 10355127 */:
            case FinalCanbus.CAR_454_RZC_Sanlin_Pajero_22_Sport_Top /* 16056774 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_text_view6).setVisibility(0);
                findViewById(R.id.layout_view29).setVisibility(0);
                findViewById(R.id.layout_view30).setVisibility(0);
                findViewById(R.id.layout_view31).setVisibility(0);
                findViewById(R.id.layout_text_view7).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view34).setVisibility(0);
                findViewById(R.id.layout_text_view8).setVisibility(0);
                findViewById(R.id.layout_view36).setVisibility(0);
                findViewById(R.id.layout_view37).setVisibility(0);
                findViewById(R.id.layout_view38).setVisibility(0);
                findViewById(R.id.layout_view39).setVisibility(0);
                findViewById(R.id.layout_view40).setVisibility(0);
                findViewById(R.id.layout_text_view9).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                findViewById(R.id.layout_view42).setVisibility(0);
                findViewById(R.id.layout_view43).setVisibility(0);
                findViewById(R.id.layout_view44).setVisibility(0);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        int value;
        int value2;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value3 = DataCanbus.DATA[104] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(0, value3);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value4 = DataCanbus.DATA[104] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(0, value4);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value5 = ((DataCanbus.DATA[105] >> 4) & 15) - 1;
                if (value5 < 8) {
                    value5 = 14;
                }
                setCarInfo(1, (value5 << 4) & 240);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value6 = ((DataCanbus.DATA[105] >> 4) & 15) + 1;
                if (value6 > 14) {
                    value6 = 8;
                }
                setCarInfo(1, (value6 << 4) & 240);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                if (((DataCanbus.DATA[106] >> 4) & 15) == 8) {
                    value2 = 12;
                } else {
                    value2 = 8;
                }
                setCarInfo(2, (value2 << 4) & 240);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                if (((DataCanbus.DATA[106] >> 4) & 15) == 8) {
                    value = 12;
                } else {
                    value = 8;
                }
                setCarInfo(2, (value << 4) & 240);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = ((DataCanbus.DATA[107] >> 4) & 15) - 1;
                if (value7 < 8) {
                    value7 = 10;
                }
                setCarInfo(3, (value7 << 4) & 240);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = ((DataCanbus.DATA[107] >> 4) & 15) + 1;
                if (value8 > 10) {
                    value8 = 8;
                }
                setCarInfo(3, (value8 << 4) & 240);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = ((DataCanbus.DATA[108] >> 4) & 15) - 1;
                if (value9 < 8) {
                    value9 = 11;
                }
                setCarInfo(4, (value9 << 4) & 240);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = ((DataCanbus.DATA[108] >> 4) & 15) + 1;
                if (value10 > 11) {
                    value10 = 8;
                }
                setCarInfo(4, (value10 << 4) & 240);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = ((DataCanbus.DATA[109] >> 4) & 15) - 1;
                if (value11 < 8) {
                    value11 = 10;
                }
                setCarInfo(5, (value11 << 4) & 240);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = ((DataCanbus.DATA[109] >> 4) & 15) + 1;
                if (value12 > 10) {
                    value12 = 8;
                }
                setCarInfo(5, (value12 << 4) & 240);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = ((DataCanbus.DATA[110] >> 4) & 15) - 1;
                if (value13 < 8) {
                    value13 = 9;
                }
                setCarInfo(6, (value13 << 4) & 240);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = ((DataCanbus.DATA[110] >> 4) & 15) + 1;
                if (value14 > 9) {
                    value14 = 8;
                }
                setCarInfo(6, (value14 << 4) & 240);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = ((DataCanbus.DATA[111] >> 4) & 15) - 1;
                if (value15 < 8) {
                    value15 = 11;
                }
                setCarInfo(7, (value15 << 4) & 240);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = ((DataCanbus.DATA[111] >> 4) & 15) + 1;
                if (value16 > 11) {
                    value16 = 8;
                }
                setCarInfo(7, (value16 << 4) & 240);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = ((DataCanbus.DATA[112] >> 4) & 15) - 1;
                if (value17 < 8) {
                    value17 = 9;
                }
                setCarInfo(8, (value17 << 4) & 240);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = ((DataCanbus.DATA[112] >> 4) & 15) + 1;
                if (value18 > 9) {
                    value18 = 8;
                }
                setCarInfo(8, (value18 << 4) & 240);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value19 = ((DataCanbus.DATA[114] >> 4) & 15) - 1;
                if (value19 < 8) {
                    value19 = 12;
                }
                setCarInfo(10, (value19 << 4) & 240);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value20 = ((DataCanbus.DATA[114] >> 4) & 15) + 1;
                if (value20 > 12) {
                    value20 = 8;
                }
                setCarInfo(10, (value20 << 4) & 240);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value21 = ((DataCanbus.DATA[115] >> 4) & 15) - 1;
                if (value21 < 8) {
                    value21 = 10;
                }
                setCarInfo(11, (value21 << 4) & 240);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value22 = ((DataCanbus.DATA[115] >> 4) & 15) + 1;
                if (value22 > 10) {
                    value22 = 8;
                }
                setCarInfo(11, (value22 << 4) & 240);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value23 = ((DataCanbus.DATA[116] >> 4) & 15) - 1;
                if (value23 < 8) {
                    value23 = 11;
                }
                setCarInfo(12, (value23 << 4) & 240);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value24 = ((DataCanbus.DATA[116] >> 4) & 15) + 1;
                if (value24 > 11) {
                    value24 = 8;
                }
                setCarInfo(12, (value24 << 4) & 240);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value25 = ((DataCanbus.DATA[117] >> 4) & 15) - 1;
                if (value25 < 8) {
                    value25 = 14;
                }
                setCarInfo(13, (value25 << 4) & 240);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value26 = ((DataCanbus.DATA[117] >> 4) & 15) + 1;
                if (value26 > 14) {
                    value26 = 8;
                }
                setCarInfo(13, (value26 << 4) & 240);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value27 = ((DataCanbus.DATA[118] >> 4) & 15) - 1;
                if (value27 < 8) {
                    value27 = 9;
                }
                setCarInfo(14, (value27 << 4) & 240);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value28 = ((DataCanbus.DATA[118] >> 4) & 15) + 1;
                if (value28 > 9) {
                    value28 = 8;
                }
                setCarInfo(14, (value28 << 4) & 240);
                break;
            case R.id.btn_minus15 /* 2131427515 */:
                int value29 = ((DataCanbus.DATA[120] >> 4) & 15) - 1;
                if (value29 < 8) {
                    value29 = 9;
                }
                setCarInfo(16, (value29 << 4) & 240);
                break;
            case R.id.btn_plus15 /* 2131427517 */:
                int value30 = ((DataCanbus.DATA[120] >> 4) & 15) + 1;
                if (value30 > 9) {
                    value30 = 8;
                }
                setCarInfo(16, (value30 << 4) & 240);
                break;
            case R.id.btn_minus16 /* 2131427518 */:
                int value31 = ((DataCanbus.DATA[121] >> 4) & 15) - 1;
                if (value31 < 8) {
                    value31 = 11;
                }
                setCarInfo(17, (value31 << 4) & 240);
                break;
            case R.id.btn_plus16 /* 2131427520 */:
                int value32 = ((DataCanbus.DATA[121] >> 4) & 15) + 1;
                if (value32 > 11) {
                    value32 = 8;
                }
                setCarInfo(17, (value32 << 4) & 240);
                break;
            case R.id.btn_minus17 /* 2131427521 */:
                int value33 = ((DataCanbus.DATA[122] >> 4) & 15) - 1;
                if (value33 < 8) {
                    value33 = 9;
                }
                setCarInfo(18, (value33 << 4) & 240);
                break;
            case R.id.btn_plus17 /* 2131427523 */:
                int value34 = ((DataCanbus.DATA[122] >> 4) & 15) + 1;
                if (value34 > 9) {
                    value34 = 8;
                }
                setCarInfo(18, (value34 << 4) & 240);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value35 = DataCanbus.DATA[113];
                if (value35 == 128) {
                    value35 = 144;
                } else if (value35 == 144) {
                    value35 = 128;
                }
                setCarInfo(9, value35);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value36 = DataCanbus.DATA[119];
                if (value36 == 128) {
                    value36 = 144;
                } else if (value36 == 144) {
                    value36 = 128;
                }
                setCarInfo(15, value36);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value37 = DataCanbus.DATA[129];
                if (value37 == 128) {
                    value37 = 144;
                } else if (value37 == 144) {
                    value37 = 128;
                }
                setCarInfo(25, value37);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                dialog(R.string.all_settings, 31);
                break;
            case R.id.btn_minus18 /* 2131427894 */:
                int value38 = ((DataCanbus.DATA[123] >> 4) & 15) - 1;
                if (value38 < 8) {
                    value38 = 10;
                }
                setCarInfo(19, (value38 << 4) & 240);
                break;
            case R.id.btn_plus18 /* 2131427895 */:
                int value39 = ((DataCanbus.DATA[123] >> 4) & 15) + 1;
                if (value39 > 10) {
                    value39 = 8;
                }
                setCarInfo(19, (value39 << 4) & 240);
                break;
            case R.id.btn_minus19 /* 2131427896 */:
                int value40 = ((DataCanbus.DATA[124] >> 4) & 15) - 1;
                if (value40 < 8) {
                    value40 = 9;
                }
                setCarInfo(20, (value40 << 4) & 240);
                break;
            case R.id.btn_plus19 /* 2131427897 */:
                int value41 = ((DataCanbus.DATA[124] >> 4) & 15) + 1;
                if (value41 > 9) {
                    value41 = 8;
                }
                setCarInfo(20, (value41 << 4) & 240);
                break;
            case R.id.btn_minus21 /* 2131427898 */:
                int value42 = ((DataCanbus.DATA[126] >> 4) & 15) - 1;
                if (value42 < 8) {
                    value42 = 9;
                }
                setCarInfo(22, (value42 << 4) & 240);
                break;
            case R.id.btn_plus21 /* 2131427899 */:
                int value43 = ((DataCanbus.DATA[126] >> 4) & 15) + 1;
                if (value43 > 9) {
                    value43 = 8;
                }
                setCarInfo(22, (value43 << 4) & 240);
                break;
            case R.id.btn_minus22 /* 2131427900 */:
                int value44 = ((DataCanbus.DATA[127] >> 4) & 15) - 1;
                if (value44 < 8) {
                    value44 = 10;
                }
                setCarInfo(23, (value44 << 4) & 240);
                break;
            case R.id.btn_plus22 /* 2131427901 */:
                int value45 = ((DataCanbus.DATA[127] >> 4) & 15) + 1;
                if (value45 > 10) {
                    value45 = 8;
                }
                setCarInfo(23, (value45 << 4) & 240);
                break;
            case R.id.btn_minus20 /* 2131427905 */:
                int value46 = ((DataCanbus.DATA[125] >> 4) & 15) - 1;
                if (value46 < 8) {
                    value46 = 9;
                }
                setCarInfo(21, (value46 << 4) & 240);
                break;
            case R.id.btn_plus20 /* 2131427906 */:
                int value47 = ((DataCanbus.DATA[125] >> 4) & 15) + 1;
                if (value47 > 9) {
                    value47 = 8;
                }
                setCarInfo(21, (value47 << 4) & 240);
                break;
            case R.id.btn_plus25 /* 2131427926 */:
                int value48 = ((DataCanbus.DATA[131] >> 4) & 15) + 1;
                if (value48 > 10) {
                    value48 = 8;
                }
                setCarInfo(27, (value48 << 4) & 240);
                break;
            case R.id.btn_plus24 /* 2131427927 */:
                int value49 = ((DataCanbus.DATA[130] >> 4) & 15) + 1;
                if (value49 > 11) {
                    value49 = 8;
                }
                setCarInfo(26, (value49 << 4) & 240);
                break;
            case R.id.btn_plus26 /* 2131427928 */:
                int value50 = DataCanbus.DATA[132] + 1;
                if (value50 > 2) {
                    value50 = 1;
                }
                setCarInfo(28, value50);
                break;
            case R.id.btn_plus27 /* 2131427929 */:
                int value51 = DataCanbus.DATA[133];
                if (value51 < 22) {
                    value51++;
                }
                setCarAmpInfo(1, value51);
                break;
            case R.id.btn_plus28 /* 2131427930 */:
                int value52 = DataCanbus.DATA[134];
                if (value52 < 22) {
                    value52++;
                }
                setCarAmpInfo(2, value52);
                break;
            case R.id.btn_plus23 /* 2131427931 */:
                int value53 = ((DataCanbus.DATA[128] >> 4) & 15) + 1;
                if (value53 > 10) {
                    value53 = 8;
                }
                setCarInfo(24, (value53 << 4) & 240);
                break;
            case R.id.btn_minus28 /* 2131428300 */:
                int value54 = DataCanbus.DATA[134];
                if (value54 > 0) {
                    value54--;
                }
                setCarAmpInfo(2, value54);
                break;
            case R.id.btn_minus29 /* 2131428301 */:
                int value55 = DataCanbus.DATA[135] - 1;
                if (value55 < 0) {
                    value55 = 4;
                }
                setCarAmpInfo(3, value55);
                break;
            case R.id.btn_plus29 /* 2131428302 */:
                int value56 = DataCanbus.DATA[135] + 1;
                if (value56 > 4) {
                    value56 = 0;
                }
                setCarAmpInfo(3, value56);
                break;
            case R.id.btn_minus25 /* 2131428303 */:
                int value57 = ((DataCanbus.DATA[131] >> 4) & 15) - 1;
                if (value57 < 8) {
                    value57 = 10;
                }
                setCarInfo(27, (value57 << 4) & 240);
                break;
            case R.id.btn_minus26 /* 2131428304 */:
                int value58 = DataCanbus.DATA[132] - 1;
                if (value58 < 1) {
                    value58 = 2;
                }
                setCarInfo(28, value58);
                break;
            case R.id.btn_minus27 /* 2131428305 */:
                int value59 = DataCanbus.DATA[133];
                if (value59 > 0) {
                    value59--;
                }
                setCarAmpInfo(1, value59);
                break;
            case R.id.btn_minus23 /* 2131428306 */:
                int value60 = ((DataCanbus.DATA[128] >> 4) & 15) - 1;
                if (value60 < 8) {
                    value60 = 10;
                }
                setCarInfo(24, (value60 << 4) & 240);
                break;
            case R.id.btn_minus24 /* 2131428307 */:
                int value61 = ((DataCanbus.DATA[130] >> 4) & 15) - 1;
                if (value61 < 8) {
                    value61 = 11;
                }
                setCarInfo(26, (value61 << 4) & 240);
                break;
            case R.id.btn_minus30 /* 2131428365 */:
                int value62 = DataCanbus.DATA[136];
                if (value62 > 0) {
                    value62--;
                }
                setCarAmpInfo(4, value62);
                break;
            case R.id.btn_plus30 /* 2131428366 */:
                int value63 = DataCanbus.DATA[136];
                if (value63 < 12) {
                    value63++;
                }
                setCarAmpInfo(4, value63);
                break;
            case R.id.btn_minus31 /* 2131428447 */:
                int value64 = DataCanbus.DATA[138];
                if (value64 > 0) {
                    value64--;
                }
                setCarAmpInfo(6, value64);
                break;
            case R.id.btn_plus31 /* 2131428448 */:
                int value65 = DataCanbus.DATA[138];
                if (value65 < 12) {
                    value65++;
                }
                setCarAmpInfo(6, value65);
                break;
            case R.id.btn_minus32 /* 2131428449 */:
                int value66 = DataCanbus.DATA[137];
                if (value66 > 0) {
                    value66--;
                }
                setCarAmpInfo(5, value66);
                break;
            case R.id.btn_plus32 /* 2131428450 */:
                int value67 = DataCanbus.DATA[137];
                if (value67 < 12) {
                    value67++;
                }
                setCarAmpInfo(5, value67);
                break;
            case R.id.btn_minus33 /* 2131428451 */:
                int value68 = DataCanbus.DATA[139];
                if (value68 > 0) {
                    value68--;
                }
                setCarAmpInfo(7, value68);
                break;
            case R.id.btn_plus33 /* 2131428452 */:
                int value69 = DataCanbus.DATA[139];
                if (value69 < 8) {
                    value69++;
                }
                setCarAmpInfo(7, value69);
                break;
            case R.id.btn_minus34 /* 2131428453 */:
                int value70 = DataCanbus.DATA[140];
                if (value70 > 0) {
                    value70--;
                }
                setCarAmpInfo(8, value70);
                break;
            case R.id.btn_plus34 /* 2131428454 */:
                int value71 = DataCanbus.DATA[140];
                if (value71 < 45) {
                    value71++;
                }
                setCarAmpInfo(8, value71);
                break;
            case R.id.btn_minus35 /* 2131428455 */:
                int value72 = DataCanbus.DATA[141] - 1;
                if (value72 < 0) {
                    value72 = 2;
                }
                setCarAmpInfo(10, value72);
                break;
            case R.id.btn_plus35 /* 2131428456 */:
                int value73 = DataCanbus.DATA[141] + 1;
                if (value73 > 2) {
                    value73 = 0;
                }
                setCarAmpInfo(10, value73);
                break;
            case R.id.btn_minus36 /* 2131428457 */:
                int value74 = DataCanbus.DATA[142] - 1;
                if (value74 < 0) {
                    value74 = 2;
                }
                setCarAmpInfo(11, value74);
                break;
            case R.id.btn_plus36 /* 2131428458 */:
                int value75 = DataCanbus.DATA[142] + 1;
                if (value75 > 2) {
                    value75 = 0;
                }
                setCarAmpInfo(11, value75);
                break;
            case R.id.btn_minus37 /* 2131428459 */:
                int value76 = DataCanbus.DATA[143] - 1;
                if (value76 < 0) {
                    value76 = 2;
                }
                setCarAmpInfo(12, value76);
                break;
            case R.id.btn_plus37 /* 2131428460 */:
                int value77 = DataCanbus.DATA[143] + 1;
                if (value77 > 2) {
                    value77 = 0;
                }
                setCarAmpInfo(12, value77);
                break;
            case R.id.btn_minus38 /* 2131428461 */:
                int value78 = DataCanbus.DATA[144] - 1;
                if (value78 < 0) {
                    value78 = 3;
                }
                setCarAmpInfo(13, value78);
                break;
            case R.id.btn_plus38 /* 2131428462 */:
                int value79 = DataCanbus.DATA[144] + 1;
                if (value79 > 3) {
                    value79 = 0;
                }
                setCarAmpInfo(13, value79);
                break;
            case R.id.btn_minus39 /* 2131428463 */:
                int value80 = DataCanbus.DATA[145] - 1;
                if (value80 < 0) {
                    value80 = 3;
                }
                setCarAmpInfo(14, value80);
                break;
            case R.id.btn_plus39 /* 2131428465 */:
                int value81 = DataCanbus.DATA[145] + 1;
                if (value81 > 3) {
                    value81 = 0;
                }
                setCarAmpInfo(14, value81);
                break;
        }
    }

    public void setCarAmpInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2}, null, null);
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(3, new int[]{80}, null, null);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_439_RZC_Sanlin_18Pajieluo_H /* 9634231 */:
            case FinalCanbus.CAR_439_RZC_Sanlin_19Yige_Top /* 10355127 */:
                DataCanbus.PROXY.cmd(3, new int[]{23}, null, null);
                break;
        }
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
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
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
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
    }

    void updateText26(int value) {
        if (((TextView) findViewById(R.id.tv_text26)) != null) {
            switch (value) {
                case 2:
                    ((TextView) findViewById(R.id.tv_text26)).setText("Automatic");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text26)).setText("Manual");
                    break;
            }
        }
    }

    
    public void updateText25(int value) {
        if (((TextView) findViewById(R.id.tv_text25)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text25)).setText("30 minute");
                    break;
                case 160:
                    ((TextView) findViewById(R.id.tv_text25)).setText("60 minute");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text25)).setText("Never");
                    break;
            }
        }
    }

    
    public void updateText24(int value) {
        if (((TextView) findViewById(R.id.tv_text24)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text24)).setText("Fold out(by vehicle speed)");
                    break;
                case 160:
                    ((TextView) findViewById(R.id.tv_text24)).setText("Fold In/Out by ignition switch ON/OFF");
                    break;
                case 176:
                    ((TextView) findViewById(R.id.tv_text24)).setText("Fold In/Out by Keyless Entry");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text24)).setText("None");
                    break;
            }
        }
    }

    
    public void updateText23(int value) {
        if (((TextView) findViewById(R.id.tv_text23)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text23)).setText("More Airflow to Face");
                    break;
                case 160:
                    ((TextView) findViewById(R.id.tv_text23)).setText("More Airflow to Foot");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text23)).setText("Normal");
                    break;
            }
        }
    }

    
    public void updateText22(int value) {
        if (((TextView) findViewById(R.id.tv_text22)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text22)).setText("More Airflow to Foot");
                    break;
                case 160:
                    ((TextView) findViewById(R.id.tv_text22)).setText("More Airflow to Windshield");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text22)).setText("Normal");
                    break;
            }
        }
    }

    
    public void updateText21(int value) {
        if (((TextView) findViewById(R.id.tv_text21)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text21)).setText("Comfort");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text21)).setText("Eco");
                    break;
            }
        }
    }

    
    public void updateText20(int value) {
        if (((TextView) findViewById(R.id.tv_text20)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text20)).setText("Automatic");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text20)).setText("Manual");
                    break;
            }
        }
    }

    
    public void updateText19(int value) {
        if (((TextView) findViewById(R.id.tv_text19)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text19)).setText("Automatic");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text19)).setText("Manual");
                    break;
            }
        }
    }

    
    public void updateText18(int value) {
        if (((TextView) findViewById(R.id.tv_text18)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text18)).setText("Connects to gearlever in position");
                    break;
                case 160:
                    ((TextView) findViewById(R.id.tv_text18)).setText("Connects to ignition switch OFF(LOCK) position");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text18)).setText("Off");
                    break;
            }
        }
    }

    
    public void updateText17(int value) {
        if (((TextView) findViewById(R.id.tv_text17)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text17)).setText("Dirver door only");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text17)).setText("ALL doors");
                    break;
            }
        }
    }

    
    public void updateText16(int value) {
        if (((TextView) findViewById(R.id.tv_text16)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text16)).setText("1 minute");
                    break;
                case 160:
                    ((TextView) findViewById(R.id.tv_text16)).setText("2 minute");
                    break;
                case 176:
                    ((TextView) findViewById(R.id.tv_text16)).setText("3 minute");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text16)).setText("30 seconds");
                    break;
            }
        }
    }

    
    public void updateText15(int value) {
        if (((TextView) findViewById(R.id.tv_text15)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text15)).setText("Long");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text15)).setText("Short");
                    break;
            }
        }
    }

    
    public void updateText14(int value) {
        if (((TextView) findViewById(R.id.tv_text14)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text14)).setText("ignition switch ON");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text14)).setText("ignition switch ON or Accessory");
                    break;
            }
        }
    }

    
    public void updateText13(int value) {
        if (((TextView) findViewById(R.id.tv_text13)) != null) {
            switch (value) {
                case 128:
                    ((TextView) findViewById(R.id.tv_text13)).setText("0 seconds");
                    break;
                case 144:
                    ((TextView) findViewById(R.id.tv_text13)).setText("7.5 seconds");
                    break;
                case 160:
                    ((TextView) findViewById(R.id.tv_text13)).setText("15 seconds");
                    break;
                case 176:
                    ((TextView) findViewById(R.id.tv_text13)).setText("30 seconds");
                    break;
                case 192:
                    ((TextView) findViewById(R.id.tv_text13)).setText("1 minute");
                    break;
                case 208:
                    ((TextView) findViewById(R.id.tv_text13)).setText("2 minute");
                    break;
                case 224:
                    ((TextView) findViewById(R.id.tv_text13)).setText("3 minute");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text13)).setText("0 seconds");
                    break;
            }
        }
    }

    
    public void updateText12(int value) {
        if (((TextView) findViewById(R.id.tv_text12)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text12)).setText("3 minute");
                    break;
                case 160:
                    ((TextView) findViewById(R.id.tv_text12)).setText("30 minute");
                    break;
                case 176:
                    ((TextView) findViewById(R.id.tv_text12)).setText("60 minute");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text12)).setText("Never");
                    break;
            }
        }
    }

    
    public void updateText11(int value) {
        if (((TextView) findViewById(R.id.tv_text11)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text11)).setText("Front position Lamp ON");
                    break;
                case 160:
                    ((TextView) findViewById(R.id.tv_text11)).setText("Head lights ON");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text11)).setText("Off");
                    break;
            }
        }
    }

    
    public void updateText10(int value) {
        if (((TextView) findViewById(R.id.tv_text10)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text10)).setText("15 seconds");
                    break;
                case 160:
                    ((TextView) findViewById(R.id.tv_text10)).setText("30 seconds");
                    break;
                case 176:
                    ((TextView) findViewById(R.id.tv_text10)).setText("1 minute");
                    break;
                case 192:
                    ((TextView) findViewById(R.id.tv_text10)).setText("3 minute");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text10)).setText("Off");
                    break;
            }
        }
    }

    
    public void updateText9(int value) {
        if (((TextView) findViewById(R.id.tv_text9)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text9)).setText("Front/ Rear Wiper switch ON");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text9)).setText("Rear Wiper switch ON");
                    break;
            }
        }
    }

    
    public void updateText8(int value) {
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text8)).setText("4 seconds");
                    break;
                case 160:
                    ((TextView) findViewById(R.id.tv_text8)).setText("8 seconds");
                    break;
                case 176:
                    ((TextView) findViewById(R.id.tv_text8)).setText("16 seconds");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text8)).setText("0 seconds");
                    break;
            }
        }
    }

    
    public void updateText7(int value) {
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text7)).setText("On");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text7)).setText("Off");
                    break;
            }
        }
    }

    
    public void updateText6(int value) {
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text6)).setText("On");
                    break;
                case 160:
                    ((TextView) findViewById(R.id.tv_text6)).setText("On(with Delayed Finishing Wipe)");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text6)).setText("Off");
                    break;
            }
        }
    }

    
    public void updateText5(int value) {
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text5)).setText("Variable");
                    break;
                case 160:
                    ((TextView) findViewById(R.id.tv_text5)).setText("Variable(by vehicle speed)");
                    break;
                case 176:
                    ((TextView) findViewById(R.id.tv_text5)).setText("Variable(rain sensing)");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text5)).setText("4 seconds");
                    break;
            }
        }
    }

    
    public void updateText4(int value) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            switch (value) {
                case 144:
                    ((TextView) findViewById(R.id.tv_text4)).setText("3 seconds");
                    break;
                case 160:
                    ((TextView) findViewById(R.id.tv_text4)).setText("5 seconds");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text4)).setText("Off");
                    break;
            }
        }
    }

    
    public void updateText3(int value) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            switch (value) {
                case 192:
                    ((TextView) findViewById(R.id.tv_text3)).setText("Wing mirror:Fold out&Fold in");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text3)).setText("Off");
                    break;
            }
        }
    }

    
    public void updateText2(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            switch (value) {
                case 128:
                    ((TextView) findViewById(R.id.tv_text2)).setText("Lock:Once/Unlock:Twice");
                    break;
                case 144:
                    ((TextView) findViewById(R.id.tv_text2)).setText("Lock:Once/Unlock:Off");
                    break;
                case 160:
                    ((TextView) findViewById(R.id.tv_text2)).setText("Lock:Off/Unlock:Twice");
                    break;
                case 176:
                    ((TextView) findViewById(R.id.tv_text2)).setText("Lock: Twice /Unlock: Once");
                    break;
                case 192:
                    ((TextView) findViewById(R.id.tv_text2)).setText("Lock: Off /Unlock: Once");
                    break;
                case 208:
                    ((TextView) findViewById(R.id.tv_text2)).setText("Lock: Twice /Unlock: Off");
                    break;
                case 224:
                    ((TextView) findViewById(R.id.tv_text2)).setText("Off");
                    break;
            }
        }
    }

    
    public void updateText1(int value) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text1)).setText("High");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText("Medium");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text1)).setText("Low");
                    break;
            }
        }
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
                        DataCanbus.PROXY.cmd(0, new int[]{i, 1}, null, null);
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
