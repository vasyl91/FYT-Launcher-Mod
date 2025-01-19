package com.syu.carinfo.byd.hcy.fragment;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseFragment;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Fragment_Surui_CarSet6 extends BaseFragment implements View.OnClickListener {
    int[] ids = {146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168};
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 146:
                    switch (value) {
                        case 0:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text1)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text1)).setText("10s");
                            break;
                        case 2:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text1)).setText("20s");
                            break;
                        case 3:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text1)).setText("30s");
                            break;
                        case 4:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text1)).setText("40s");
                            break;
                        case 5:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text1)).setText("50s");
                            break;
                        case 6:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text1)).setText("60s");
                            break;
                    }
                case 147:
                    Fragment_Surui_CarSet6.this.setCheck((CheckedTextView) Fragment_Surui_CarSet6.this.findView(R.id.ctv_checkedtext1), value != 0);
                    break;
                case 148:
                    Fragment_Surui_CarSet6.this.setCheck((CheckedTextView) Fragment_Surui_CarSet6.this.findView(R.id.ctv_checkedtext2), value != 0);
                    break;
                case 149:
                    Fragment_Surui_CarSet6.this.setCheck((CheckedTextView) Fragment_Surui_CarSet6.this.findView(R.id.ctv_checkedtext3), value != 0);
                    break;
                case 150:
                    Fragment_Surui_CarSet6.this.setCheck((CheckedTextView) Fragment_Surui_CarSet6.this.findView(R.id.ctv_checkedtext4), value != 0);
                    break;
                case 151:
                    Fragment_Surui_CarSet6.this.setCheck((CheckedTextView) Fragment_Surui_CarSet6.this.findView(R.id.ctv_checkedtext5), value != 0);
                    break;
                case 152:
                    switch (value) {
                        case 0:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text2)).setText(R.string.jeep_presskeyunlock_1);
                            break;
                        case 1:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text2)).setText(R.string.jeep_presskeyunlock_0);
                            break;
                    }
                case 153:
                    Fragment_Surui_CarSet6.this.setCheck((CheckedTextView) Fragment_Surui_CarSet6.this.findView(R.id.ctv_checkedtext6), value != 0);
                    break;
                case 154:
                    Fragment_Surui_CarSet6.this.setCheck((CheckedTextView) Fragment_Surui_CarSet6.this.findView(R.id.ctv_checkedtext7), value != 0);
                    break;
                case 155:
                    switch (value) {
                        case 0:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text3)).setText(R.string.str_driving_eco);
                            break;
                        case 1:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text3)).setText(R.string.str_driving_comfort);
                            break;
                        case 2:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text3)).setText(R.string.str_intelligent);
                            break;
                    }
                case 156:
                    Fragment_Surui_CarSet6.this.setCheck((CheckedTextView) Fragment_Surui_CarSet6.this.findView(R.id.ctv_checkedtext8), value != 0);
                    break;
                case 157:
                    switch (value) {
                        case 0:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text4)).setText(R.string.distance_close);
                            break;
                        case 1:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text4)).setText(R.string.distance_medium);
                            break;
                        case 2:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text4)).setText(R.string.distance_far);
                            break;
                    }
                case 158:
                    Fragment_Surui_CarSet6.this.setCheck((CheckedTextView) Fragment_Surui_CarSet6.this.findView(R.id.ctv_checkedtext9), value != 0);
                    break;
                case 159:
                    ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 160:
                    ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text6)).setText(String.valueOf(value) + "km");
                    break;
                case 161:
                    ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text7)).setText(String.valueOf(value) + "km/h");
                    break;
                case 162:
                    ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text8)).setText(String.valueOf(value) + "km/h");
                    break;
                case 163:
                    switch (value) {
                        case 0:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text9)).setText("幻际星穗");
                            break;
                        case 1:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text9)).setText("灵动空间");
                            break;
                        case 2:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text9)).setText("简约主义");
                            break;
                    }
                case 164:
                    switch (value) {
                        case 0:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text10)).setText(R.string.off);
                            break;
                        default:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text10)).setText(new StringBuilder(String.valueOf(value)).toString());
                            break;
                    }
                case 165:
                    switch (value) {
                        case 0:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text14)).setText(R.string.rzc_others_language_setting_1);
                            break;
                        case 1:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text14)).setText(R.string.rzc_others_language_setting_0);
                            break;
                    }
                case 166:
                    switch (value) {
                        case 0:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text11)).setText("℃");
                            break;
                        case 1:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text11)).setText("℉");
                            break;
                    }
                case 167:
                    switch (value) {
                        case 0:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text12)).setText("bar");
                            break;
                        case 1:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text12)).setText("psi");
                            break;
                        case 2:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text12)).setText("kpa");
                            break;
                    }
                case 168:
                    switch (value) {
                        case 0:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text13)).setText(CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                            break;
                        case 1:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text13)).setText("mpg(GB)");
                            break;
                        case 2:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text13)).setText(CamryData.OIL_EXPEND_UNIT_KM_PER_L);
                            break;
                        case 3:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text13)).setText("mpg(US)");
                            break;
                    }
            }
        }
    };

    @Override
    public void initView() {
        bindViewOnClick(R.id.btn_minus1, this);
        bindViewOnClick(R.id.btn_plus1, this);
        bindViewOnClick(R.id.btn_minus2, this);
        bindViewOnClick(R.id.btn_plus2, this);
        bindViewOnClick(R.id.btn_minus3, this);
        bindViewOnClick(R.id.btn_plus3, this);
        bindViewOnClick(R.id.btn_minus4, this);
        bindViewOnClick(R.id.btn_plus4, this);
        bindViewOnClick(R.id.btn_minus5, this);
        bindViewOnClick(R.id.btn_plus5, this);
        bindViewOnClick(R.id.btn_minus6, this);
        bindViewOnClick(R.id.btn_plus6, this);
        bindViewOnClick(R.id.btn_minus7, this);
        bindViewOnClick(R.id.btn_plus7, this);
        bindViewOnClick(R.id.btn_minus8, this);
        bindViewOnClick(R.id.btn_plus8, this);
        bindViewOnClick(R.id.btn_minus9, this);
        bindViewOnClick(R.id.btn_plus9, this);
        bindViewOnClick(R.id.btn_minus10, this);
        bindViewOnClick(R.id.btn_plus10, this);
        bindViewOnClick(R.id.btn_minus11, this);
        bindViewOnClick(R.id.btn_plus11, this);
        bindViewOnClick(R.id.btn_minus12, this);
        bindViewOnClick(R.id.btn_plus12, this);
        bindViewOnClick(R.id.btn_minus13, this);
        bindViewOnClick(R.id.btn_plus13, this);
        bindViewOnClick(R.id.btn_minus14, this);
        bindViewOnClick(R.id.btn_plus14, this);
        bindViewOnClick(R.id.ctv_checkedtext1, this);
        bindViewOnClick(R.id.ctv_checkedtext2, this);
        bindViewOnClick(R.id.ctv_checkedtext3, this);
        bindViewOnClick(R.id.ctv_checkedtext4, this);
        bindViewOnClick(R.id.ctv_checkedtext5, this);
        bindViewOnClick(R.id.ctv_checkedtext6, this);
        bindViewOnClick(R.id.ctv_checkedtext7, this);
        bindViewOnClick(R.id.ctv_checkedtext8, this);
        bindViewOnClick(R.id.ctv_checkedtext9, this);
    }

    @Override
    public void initListener() {
    }

    @Override
    public int getViewLayout() {
        return R.layout.layout_0453_od_byd_sirui_carset;
    }

    @Override
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        int value5;
        int value6;
        int value7;
        int value8;
        int value9;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value10 = DataCanbus.DATA[146] - 1;
                if (value10 < 0) {
                    value10 = 6;
                }
                DataCanbus.PROXY.cmd(5, new int[]{1, value10}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value11 = DataCanbus.DATA[146] + 1;
                if (value11 > 6) {
                    value11 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{1, value11}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value12 = DataCanbus.DATA[152] - 1;
                if (value12 < 0) {
                    value12 = 1;
                }
                DataCanbus.PROXY.cmd(5, new int[]{8, value12}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value13 = DataCanbus.DATA[152] + 1;
                if (value13 > 1) {
                    value13 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{8, value13}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value14 = DataCanbus.DATA[155] - 1;
                if (value14 < 0) {
                    value14 = 2;
                }
                DataCanbus.PROXY.cmd(5, new int[]{10, value14}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value15 = DataCanbus.DATA[155] + 1;
                if (value15 > 2) {
                    value15 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{10, value15}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value16 = DataCanbus.DATA[157] - 1;
                if (value16 < 0) {
                    value16 = 2;
                }
                DataCanbus.PROXY.cmd(5, new int[]{12, value16}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value17 = DataCanbus.DATA[157] + 1;
                if (value17 > 2) {
                    value17 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{12, value17}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value18 = DataCanbus.DATA[159] - 5;
                if (value18 < 0) {
                    value18 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{14, value18}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                DataCanbus.PROXY.cmd(5, new int[]{14, DataCanbus.DATA[159] + 5}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value19 = DataCanbus.DATA[160] - 1;
                if (value19 < 0) {
                    value19 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{15, value19}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                DataCanbus.PROXY.cmd(5, new int[]{15, DataCanbus.DATA[160] + 1}, null, null);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value20 = DataCanbus.DATA[161] - 1;
                if (value20 < 0) {
                    value20 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{16, value20}, null, null);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value21 = DataCanbus.DATA[161] + 1;
                if (value21 > 200) {
                    value21 = 200;
                }
                DataCanbus.PROXY.cmd(5, new int[]{16, value21}, null, null);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value22 = DataCanbus.DATA[162] - 1;
                if (value22 < 0) {
                    value22 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{17, value22}, null, null);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value23 = DataCanbus.DATA[162] + 1;
                if (value23 > 200) {
                    value23 = 200;
                }
                DataCanbus.PROXY.cmd(5, new int[]{17, value23}, null, null);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value24 = DataCanbus.DATA[163] - 1;
                if (value24 < 0) {
                    value24 = 2;
                }
                DataCanbus.PROXY.cmd(5, new int[]{18, value24}, null, null);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value25 = DataCanbus.DATA[163] + 1;
                if (value25 > 2) {
                    value25 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{18, value25}, null, null);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value26 = DataCanbus.DATA[164] - 1;
                if (value26 < 0) {
                    value26 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{19, value26}, null, null);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value27 = DataCanbus.DATA[164] + 1;
                if (value27 > 16) {
                    value27 = 16;
                }
                DataCanbus.PROXY.cmd(5, new int[]{19, value27}, null, null);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value28 = DataCanbus.DATA[166] - 1;
                if (value28 < 0) {
                    value28 = 1;
                }
                DataCanbus.PROXY.cmd(5, new int[]{21, value28}, null, null);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value29 = DataCanbus.DATA[166] + 1;
                if (value29 > 1) {
                    value29 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{21, value29}, null, null);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value30 = DataCanbus.DATA[167] - 1;
                if (value30 < 0) {
                    value30 = 2;
                }
                DataCanbus.PROXY.cmd(5, new int[]{22, value30}, null, null);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value31 = DataCanbus.DATA[167] + 1;
                if (value31 > 2) {
                    value31 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{22, value31}, null, null);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value32 = DataCanbus.DATA[168] - 1;
                if (value32 < 0) {
                    value32 = 2;
                }
                DataCanbus.PROXY.cmd(5, new int[]{23, value32}, null, null);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value33 = DataCanbus.DATA[168] + 1;
                if (value33 > 2) {
                    value33 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{23, value33}, null, null);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value34 = DataCanbus.DATA[165] - 1;
                if (value34 < 0) {
                    value34 = 1;
                }
                DataCanbus.PROXY.cmd(5, new int[]{20, value34}, null, null);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value35 = DataCanbus.DATA[165] + 1;
                if (value35 > 1) {
                    value35 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{20, value35}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                if (DataCanbus.DATA[147] == 0) {
                    value9 = 1;
                } else {
                    value9 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{2, value9}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                if (DataCanbus.DATA[148] == 0) {
                    value8 = 1;
                } else {
                    value8 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{3, value8}, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                if (DataCanbus.DATA[149] == 0) {
                    value7 = 1;
                } else {
                    value7 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{4, value7}, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                if (DataCanbus.DATA[150] == 0) {
                    value6 = 1;
                } else {
                    value6 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{5, value6}, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                if (DataCanbus.DATA[151] == 0) {
                    value5 = 1;
                } else {
                    value5 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{6, value5}, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                if (DataCanbus.DATA[153] == 0) {
                    value4 = 1;
                } else {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{7, value4}, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                if (DataCanbus.DATA[154] == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{9, value3}, null, null);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                if (DataCanbus.DATA[156] == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{11, value2}, null, null);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                if (DataCanbus.DATA[158] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{13, value}, null, null);
                break;
        }
    }

    @Override
    public void addNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override
    public void removeNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.mNotifyCanbus);
        }
    }
}
