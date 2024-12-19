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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Activity_374_AmpSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.Activity_374_AmpSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 278:
                    Activity_374_AmpSet.this.setCheck((CheckedTextView) Activity_374_AmpSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 279:
                    if (((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) Activity_374_AmpSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 280:
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
                case 281:
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
                case 282:
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
                case 283:
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
                case 284:
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
                case 286:
                    Activity_374_AmpSet.this.setCheck((CheckedTextView) Activity_374_AmpSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 287:
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
                case 373:
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
                case 406:
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
                case 407:
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0374_xp_jeep_eqsettings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
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
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(8);
                break;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                if (DataCanbus.DATA[286] == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                setCarInfo(10, value3);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value4 = DataCanbus.DATA[283];
                if (value4 > 0) {
                    value4--;
                }
                setCarInfo(6, value4);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value5 = DataCanbus.DATA[283];
                if (value5 < 19) {
                    value5++;
                }
                setCarInfo(6, value5);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value6 = DataCanbus.DATA[284];
                if (value6 > 0) {
                    value6--;
                }
                setCarInfo(7, value6);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value7 = DataCanbus.DATA[284];
                if (value7 < 19) {
                    value7++;
                }
                setCarInfo(7, value7);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value8 = DataCanbus.DATA[282];
                if (value8 > 0) {
                    value8--;
                }
                setCarInfo(5, value8);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value9 = DataCanbus.DATA[282];
                if (value9 < 19) {
                    value9++;
                }
                setCarInfo(5, value9);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value10 = DataCanbus.DATA[280];
                if (value10 > 0) {
                    value10--;
                }
                setCarInfo(3, value10);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value11 = DataCanbus.DATA[280];
                if (value11 < 19) {
                    value11++;
                }
                setCarInfo(3, value11);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value12 = DataCanbus.DATA[281];
                if (value12 > 0) {
                    value12--;
                }
                setCarInfo(4, value12);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value13 = DataCanbus.DATA[281];
                if (value13 < 19) {
                    value13++;
                }
                setCarInfo(4, value13);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value14 = DataCanbus.DATA[287];
                if (value14 > 0) {
                    value14--;
                }
                setCarInfo(9, value14);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value15 = DataCanbus.DATA[287];
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
            case R.id.btn_minus7 /* 2131427505 */:
                int value16 = DataCanbus.DATA[279];
                if (value16 > 0) {
                    value16--;
                }
                setCarInfo(2, value16);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value17 = DataCanbus.DATA[279];
                if (value17 < 38) {
                    value17++;
                }
                setCarInfo(2, value17);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
            case R.id.btn_plus8 /* 2131427511 */:
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
                        if (DataCanbus.DATA[407] == 0) {
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
            case R.id.btn_minus9 /* 2131427513 */:
                int value18 = DataCanbus.DATA[406] - 1;
                if (value18 < 0) {
                    value18 = 4;
                }
                setCarInfo(12, value18);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value19 = DataCanbus.DATA[406] + 1;
                if (value19 > 4) {
                    value19 = 0;
                }
                setCarInfo(12, value19);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                if (DataCanbus.DATA[278] == 0) {
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(4, new int[]{23}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[279].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[281].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[280].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[282].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[284].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[283].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[287].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[286].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[278].addNotify(this.mNotifyCanbus, 1);
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
                DataCanbus.NOTIFY_EVENTS[407].addNotify(this.mNotifyCanbus, 1);
                break;
            default:
                DataCanbus.NOTIFY_EVENTS[373].addNotify(this.mNotifyCanbus, 1);
                break;
        }
        DataCanbus.NOTIFY_EVENTS[406].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[279].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[281].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[280].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[282].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[284].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[283].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[287].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[286].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[278].removeNotify(this.mNotifyCanbus);
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
                DataCanbus.NOTIFY_EVENTS[407].removeNotify(this.mNotifyCanbus);
                break;
            default:
                DataCanbus.NOTIFY_EVENTS[373].removeNotify(this.mNotifyCanbus);
                break;
        }
        DataCanbus.NOTIFY_EVENTS[406].removeNotify(this.mNotifyCanbus);
    }
}
