package com.syu.carinfo.xp.ziyouguang;

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

@SuppressWarnings({"deprecation", "unchecked"})
public class Activity_374_AmpSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 290:
                    Activity_374_AmpSet.this.setCheck((CheckedTextView) Activity_374_AmpSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 291:
                    if (((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 292:
                    if (((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text4)) != null) {
                        if (value >= 10) {
                            ((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text4)).setText("R" + (value - 10));
                            break;
                        } else {
                            ((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text4)).setText("F" + (10 - value));
                            break;
                        }
                    }
                    break;
                case 293:
                    if (((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text5)) != null) {
                        if (value >= 10) {
                            ((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text5)).setText("R" + (value - 10));
                            break;
                        } else {
                            ((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text5)).setText("L" + (10 - value));
                            break;
                        }
                    }
                    break;
                case 294:
                    if (((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (value >= 10) {
                            ((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value - 10).toString());
                            break;
                        } else {
                            ((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text3)).setText("-" + (10 - value));
                            break;
                        }
                    }
                    break;
                case 295:
                    if (((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text1)) != null) {
                        if (value >= 10) {
                            ((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value - 10).toString());
                            break;
                        } else {
                            ((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text1)).setText("-" + (10 - value));
                            break;
                        }
                    }
                    break;
                case 296:
                    if (((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (value >= 10) {
                            ((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value - 10).toString());
                            break;
                        } else {
                            ((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text2)).setText("-" + (10 - value));
                            break;
                        }
                    }
                    break;
                case 298:
                    Activity_374_AmpSet.this.setCheck((CheckedTextView) Activity_374_AmpSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 299:
                    if (((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                                break;
                        }
                    }
                    break;
                case 385:
                    if (((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_back_row);
                                break;
                            case 2:
                                ((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_252_sound_distribution0);
                                break;
                            default:
                                ((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text8)).setText(R.string.driver_system_standard);
                                break;
                        }
                    }
                    break;
                case 418:
                    if (((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text9)).setText(R.string.str_252_sound_selection0);
                                break;
                            case 2:
                                ((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text9)).setText(R.string.str_sbd_x80_eq_3);
                                break;
                            case 3:
                                ((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text9)).setText(R.string.str_sbd_x80_eq_4);
                                break;
                            case 4:
                                ((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text9)).setText(R.string.str_252_sound_selection4);
                                break;
                            default:
                                ((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text9)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 419:
                    if (((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_252_sound_distribution0);
                                break;
                            default:
                                ((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text8)).setText(R.string.klc_meter_Speed_Range_Tips_all);
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0374_xp_jeep_eqsettings);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_PA_GMC_13 /* 2031990 */:
            case FinalCanbus.CAR_PA_SONOTEC_13 /* 2294134 */:
            case FinalCanbus.CAR_PA_Escalade_13 /* 2359670 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(8);
                break;
            case FinalCanbus.CAR_PA_Ford_Explorer_19_CD /* 3408246 */:
            case FinalCanbus.CAR_PA_Ford_Fusion_22_CD /* 3473782 */:
            case FinalCanbus.CAR_PA_Ford_F150_14_CD /* 3539318 */:
            case FinalCanbus.CAR_PA_Ford_F150_20_CD /* 3604854 */:
            case FinalCanbus.CAR_PA_Ford_Focus_18_CD /* 3670390 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_21_CD /* 3735926 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_17_CD /* 3801462 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_21_CD /* 3866998 */:
            case FinalCanbus.CAR_PA_Ford_mustang_15_CD /* 3998070 */:
            case FinalCanbus.CAR_PA_Ford_Explorer_19_Amp /* 4260214 */:
            case FinalCanbus.CAR_PA_Ford_Fusion_22_Amp /* 4325750 */:
            case FinalCanbus.CAR_PA_Ford_F150_14_Amp /* 4391286 */:
            case FinalCanbus.CAR_PA_Ford_F150_20_Amp /* 4456822 */:
            case FinalCanbus.CAR_PA_Ford_Focus_18_Amp /* 4522358 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_21_Amp /* 4587894 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_17_Amp /* 4653430 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_21_Amp /* 4718966 */:
            case FinalCanbus.CAR_PA_Ford_mustang_15_Amp /* 4784502 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_16_CD /* 4915574 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_16_Amp /* 4981110 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(8);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value4 = DataCanbus.DATA[295];
                if (value4 > 0) {
                    value4--;
                }
                setCarInfo(6, value4);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value5 = DataCanbus.DATA[295];
                if (value5 < 19) {
                    value5++;
                }
                setCarInfo(6, value5);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value6 = DataCanbus.DATA[296];
                if (value6 > 0) {
                    value6--;
                }
                setCarInfo(7, value6);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value7 = DataCanbus.DATA[296];
                if (value7 < 19) {
                    value7++;
                }
                setCarInfo(7, value7);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value8 = DataCanbus.DATA[294];
                if (value8 > 0) {
                    value8--;
                }
                setCarInfo(5, value8);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value9 = DataCanbus.DATA[294];
                if (value9 < 19) {
                    value9++;
                }
                setCarInfo(5, value9);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value10 = DataCanbus.DATA[292];
                if (value10 > 0) {
                    value10--;
                }
                setCarInfo(3, value10);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value11 = DataCanbus.DATA[292];
                if (value11 < 19) {
                    value11++;
                }
                setCarInfo(3, value11);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value12 = DataCanbus.DATA[293];
                if (value12 > 0) {
                    value12--;
                }
                setCarInfo(4, value12);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value13 = DataCanbus.DATA[293];
                if (value13 < 19) {
                    value13++;
                }
                setCarInfo(4, value13);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value14 = DataCanbus.DATA[299];
                if (value14 > 0) {
                    value14--;
                }
                setCarInfo(9, value14);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value15 = DataCanbus.DATA[299];
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_PA_Ford_Explorer_19_CD /* 3408246 */:
                    case FinalCanbus.CAR_PA_Ford_Fusion_22_CD /* 3473782 */:
                    case FinalCanbus.CAR_PA_Ford_F150_14_CD /* 3539318 */:
                    case FinalCanbus.CAR_PA_Ford_F150_20_CD /* 3604854 */:
                    case FinalCanbus.CAR_PA_Ford_Focus_18_CD /* 3670390 */:
                    case FinalCanbus.CAR_PA_Ford_Expedition_21_CD /* 3735926 */:
                    case FinalCanbus.CAR_PA_Ford_Expedition_17_CD /* 3801462 */:
                    case FinalCanbus.CAR_PA_Ford_F_Super_duty_21_CD /* 3866998 */:
                    case FinalCanbus.CAR_PA_Ford_mustang_15_CD /* 3998070 */:
                    case FinalCanbus.CAR_PA_Ford_Explorer_19_Amp /* 4260214 */:
                    case FinalCanbus.CAR_PA_Ford_Fusion_22_Amp /* 4325750 */:
                    case FinalCanbus.CAR_PA_Ford_F150_14_Amp /* 4391286 */:
                    case FinalCanbus.CAR_PA_Ford_F150_20_Amp /* 4456822 */:
                    case FinalCanbus.CAR_PA_Ford_Focus_18_Amp /* 4522358 */:
                    case FinalCanbus.CAR_PA_Ford_Expedition_21_Amp /* 4587894 */:
                    case FinalCanbus.CAR_PA_Ford_Expedition_17_Amp /* 4653430 */:
                    case FinalCanbus.CAR_PA_Ford_F_Super_duty_21_Amp /* 4718966 */:
                    case FinalCanbus.CAR_PA_Ford_mustang_15_Amp /* 4784502 */:
                    case FinalCanbus.CAR_PA_Ford_F_Super_duty_16_CD /* 4915574 */:
                    case FinalCanbus.CAR_PA_Ford_F_Super_duty_16_Amp /* 4981110 */:
                        if (value15 < 7) {
                            value15++;
                        }
                        setCarInfo(9, value15);
                        break;
                    default:
                        if (value15 < 3) {
                            value15++;
                        }
                        setCarInfo(9, value15);
                        break;
                }
            case R.id.btn_minus7 /* 2131427473 */:
                int value16 = DataCanbus.DATA[291];
                if (value16 > 0) {
                    value16--;
                }
                setCarInfo(2, value16);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value17 = DataCanbus.DATA[291];
                if (value17 < 38) {
                    value17++;
                }
                setCarInfo(2, value17);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
            case R.id.btn_plus8 /* 2131427478 */:
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_PA_Ford_Explorer_19_CD /* 3408246 */:
                    case FinalCanbus.CAR_PA_Ford_Fusion_22_CD /* 3473782 */:
                    case FinalCanbus.CAR_PA_Ford_F150_14_CD /* 3539318 */:
                    case FinalCanbus.CAR_PA_Ford_F150_20_CD /* 3604854 */:
                    case FinalCanbus.CAR_PA_Ford_Focus_18_CD /* 3670390 */:
                    case FinalCanbus.CAR_PA_Ford_Expedition_21_CD /* 3735926 */:
                    case FinalCanbus.CAR_PA_Ford_Expedition_17_CD /* 3801462 */:
                    case FinalCanbus.CAR_PA_Ford_F_Super_duty_21_CD /* 3866998 */:
                    case FinalCanbus.CAR_PA_Ford_mustang_15_CD /* 3998070 */:
                    case FinalCanbus.CAR_PA_Ford_Explorer_19_Amp /* 4260214 */:
                    case FinalCanbus.CAR_PA_Ford_Fusion_22_Amp /* 4325750 */:
                    case FinalCanbus.CAR_PA_Ford_F150_14_Amp /* 4391286 */:
                    case FinalCanbus.CAR_PA_Ford_F150_20_Amp /* 4456822 */:
                    case FinalCanbus.CAR_PA_Ford_Focus_18_Amp /* 4522358 */:
                    case FinalCanbus.CAR_PA_Ford_Expedition_21_Amp /* 4587894 */:
                    case FinalCanbus.CAR_PA_Ford_Expedition_17_Amp /* 4653430 */:
                    case FinalCanbus.CAR_PA_Ford_F_Super_duty_21_Amp /* 4718966 */:
                    case FinalCanbus.CAR_PA_Ford_mustang_15_Amp /* 4784502 */:
                    case FinalCanbus.CAR_PA_Ford_F_Super_duty_16_CD /* 4915574 */:
                    case FinalCanbus.CAR_PA_Ford_F_Super_duty_16_Amp /* 4981110 */:
                        if (DataCanbus.DATA[419] == 0) {
                            value = 1;
                        } else {
                            value = 0;
                        }
                        setCarInfo(11, value);
                        break;
                    default:
                        setCarInfo(11, 0);
                        break;
                }
            case R.id.btn_minus9 /* 2131427479 */:
                int value18 = DataCanbus.DATA[418] - 1;
                if (value18 < 0) {
                    value18 = 4;
                }
                setCarInfo(12, value18);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value19 = DataCanbus.DATA[418] + 1;
                if (value19 > 4) {
                    value19 = 0;
                }
                setCarInfo(12, value19);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                if (DataCanbus.DATA[298] == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                setCarInfo(10, value3);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                if (DataCanbus.DATA[290] == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                setCarInfo(1, value2);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(13, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(4, new int[]{23}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[291].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[293].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[292].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[294].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[296].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[295].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[299].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[298].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[290].addNotify(this.mNotifyCanbus, 1);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_PA_Ford_Explorer_19_CD /* 3408246 */:
            case FinalCanbus.CAR_PA_Ford_Fusion_22_CD /* 3473782 */:
            case FinalCanbus.CAR_PA_Ford_F150_14_CD /* 3539318 */:
            case FinalCanbus.CAR_PA_Ford_F150_20_CD /* 3604854 */:
            case FinalCanbus.CAR_PA_Ford_Focus_18_CD /* 3670390 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_21_CD /* 3735926 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_17_CD /* 3801462 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_21_CD /* 3866998 */:
            case FinalCanbus.CAR_PA_Ford_mustang_15_CD /* 3998070 */:
            case FinalCanbus.CAR_PA_Ford_Explorer_19_Amp /* 4260214 */:
            case FinalCanbus.CAR_PA_Ford_Fusion_22_Amp /* 4325750 */:
            case FinalCanbus.CAR_PA_Ford_F150_14_Amp /* 4391286 */:
            case FinalCanbus.CAR_PA_Ford_F150_20_Amp /* 4456822 */:
            case FinalCanbus.CAR_PA_Ford_Focus_18_Amp /* 4522358 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_21_Amp /* 4587894 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_17_Amp /* 4653430 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_21_Amp /* 4718966 */:
            case FinalCanbus.CAR_PA_Ford_mustang_15_Amp /* 4784502 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_16_CD /* 4915574 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_16_Amp /* 4981110 */:
                DataCanbus.NOTIFY_EVENTS[419].addNotify(this.mNotifyCanbus, 1);
                break;
            default:
                DataCanbus.NOTIFY_EVENTS[385].addNotify(this.mNotifyCanbus, 1);
                break;
        }
        DataCanbus.NOTIFY_EVENTS[418].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[291].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[293].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[292].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[294].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[296].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[295].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[299].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[298].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[290].removeNotify(this.mNotifyCanbus);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_PA_Ford_Explorer_19_CD /* 3408246 */:
            case FinalCanbus.CAR_PA_Ford_Fusion_22_CD /* 3473782 */:
            case FinalCanbus.CAR_PA_Ford_F150_14_CD /* 3539318 */:
            case FinalCanbus.CAR_PA_Ford_F150_20_CD /* 3604854 */:
            case FinalCanbus.CAR_PA_Ford_Focus_18_CD /* 3670390 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_21_CD /* 3735926 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_17_CD /* 3801462 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_21_CD /* 3866998 */:
            case FinalCanbus.CAR_PA_Ford_mustang_15_CD /* 3998070 */:
            case FinalCanbus.CAR_PA_Ford_Explorer_19_Amp /* 4260214 */:
            case FinalCanbus.CAR_PA_Ford_Fusion_22_Amp /* 4325750 */:
            case FinalCanbus.CAR_PA_Ford_F150_14_Amp /* 4391286 */:
            case FinalCanbus.CAR_PA_Ford_F150_20_Amp /* 4456822 */:
            case FinalCanbus.CAR_PA_Ford_Focus_18_Amp /* 4522358 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_21_Amp /* 4587894 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_17_Amp /* 4653430 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_21_Amp /* 4718966 */:
            case FinalCanbus.CAR_PA_Ford_mustang_15_Amp /* 4784502 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_16_CD /* 4915574 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_16_Amp /* 4981110 */:
                DataCanbus.NOTIFY_EVENTS[419].removeNotify(this.mNotifyCanbus);
                break;
            default:
                DataCanbus.NOTIFY_EVENTS[385].removeNotify(this.mNotifyCanbus);
                break;
        }
        DataCanbus.NOTIFY_EVENTS[418].removeNotify(this.mNotifyCanbus);
    }
}
