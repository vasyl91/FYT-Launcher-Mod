package com.syu.carinfo.byd.hcy.fragment;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseFragment;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Fragment_Surui_CarSet6 extends BaseFragment implements View.OnClickListener {
    int[] ids = {84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.byd.hcy.fragment.Fragment_Surui_CarSet6.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 84:
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
                case 85:
                    Fragment_Surui_CarSet6.this.setCheck((CheckedTextView) Fragment_Surui_CarSet6.this.findView(R.id.ctv_checkedtext1), value != 0);
                    break;
                case 86:
                    Fragment_Surui_CarSet6.this.setCheck((CheckedTextView) Fragment_Surui_CarSet6.this.findView(R.id.ctv_checkedtext2), value != 0);
                    break;
                case 87:
                    Fragment_Surui_CarSet6.this.setCheck((CheckedTextView) Fragment_Surui_CarSet6.this.findView(R.id.ctv_checkedtext3), value != 0);
                    break;
                case 88:
                    Fragment_Surui_CarSet6.this.setCheck((CheckedTextView) Fragment_Surui_CarSet6.this.findView(R.id.ctv_checkedtext4), value != 0);
                    break;
                case 89:
                    Fragment_Surui_CarSet6.this.setCheck((CheckedTextView) Fragment_Surui_CarSet6.this.findView(R.id.ctv_checkedtext5), value != 0);
                    break;
                case 90:
                    switch (value) {
                        case 0:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text2)).setText(R.string.jeep_presskeyunlock_1);
                            break;
                        case 1:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text2)).setText(R.string.jeep_presskeyunlock_0);
                            break;
                    }
                case 91:
                    Fragment_Surui_CarSet6.this.setCheck((CheckedTextView) Fragment_Surui_CarSet6.this.findView(R.id.ctv_checkedtext6), value != 0);
                    break;
                case 92:
                    Fragment_Surui_CarSet6.this.setCheck((CheckedTextView) Fragment_Surui_CarSet6.this.findView(R.id.ctv_checkedtext7), value != 0);
                    break;
                case 93:
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
                case 94:
                    Fragment_Surui_CarSet6.this.setCheck((CheckedTextView) Fragment_Surui_CarSet6.this.findView(R.id.ctv_checkedtext8), value != 0);
                    break;
                case 95:
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
                case 96:
                    Fragment_Surui_CarSet6.this.setCheck((CheckedTextView) Fragment_Surui_CarSet6.this.findView(R.id.ctv_checkedtext9), value != 0);
                    break;
                case 97:
                    ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 98:
                    ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text6)).setText(String.valueOf(value) + "km");
                    break;
                case 99:
                    ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text7)).setText(String.valueOf(value) + "km/h");
                    break;
                case 100:
                    ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text8)).setText(String.valueOf(value) + "km/h");
                    break;
                case 101:
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
                case 102:
                    switch (value) {
                        case 0:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text10)).setText(R.string.off);
                            break;
                        default:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text10)).setText(new StringBuilder(String.valueOf(value)).toString());
                            break;
                    }
                case 103:
                    switch (value) {
                        case 0:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text14)).setText(R.string.rzc_others_language_setting_1);
                            break;
                        case 1:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text14)).setText(R.string.rzc_others_language_setting_0);
                            break;
                    }
                case 104:
                    switch (value) {
                        case 0:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text11)).setText("℃");
                            break;
                        case 1:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text11)).setText("℉");
                            break;
                    }
                case 105:
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
                case 106:
                    switch (value) {
                        case 0:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text13)).setText("L/100km");
                            break;
                        case 1:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text13)).setText("mpg(GB)");
                            break;
                        case 2:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text13)).setText("km/L");
                            break;
                        case 3:
                            ((TextView) Fragment_Surui_CarSet6.this.findView(R.id.tv_text13)).setText("mpg(US)");
                            break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseFragment
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

    @Override // com.syu.canbus.BaseFragment
    public void initListener() {
    }

    @Override // com.syu.canbus.BaseFragment
    public int getViewLayout() {
        return R.layout.layout_0453_od_byd_sirui_carset;
    }

    @Override // android.view.View.OnClickListener
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
            case R.id.btn_minus13 /* 2131427468 */:
                int value10 = DataCanbus.DATA[106] - 1;
                if (value10 < 0) {
                    value10 = 2;
                }
                DataCanbus.PROXY.cmd(5, new int[]{23, value10}, null, null);
                break;
            case R.id.btn_plus13 /* 2131427470 */:
                int value11 = DataCanbus.DATA[106] + 1;
                if (value11 > 2) {
                    value11 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{23, value11}, null, null);
                break;
            case R.id.btn_minus14 /* 2131427471 */:
                int value12 = DataCanbus.DATA[103] - 1;
                if (value12 < 0) {
                    value12 = 1;
                }
                DataCanbus.PROXY.cmd(5, new int[]{20, value12}, null, null);
                break;
            case R.id.btn_plus14 /* 2131427473 */:
                int value13 = DataCanbus.DATA[103] + 1;
                if (value13 > 1) {
                    value13 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{20, value13}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                if (DataCanbus.DATA[85] == 0) {
                    value9 = 1;
                } else {
                    value9 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{2, value9}, null, null);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value14 = DataCanbus.DATA[84] - 1;
                if (value14 < 0) {
                    value14 = 6;
                }
                DataCanbus.PROXY.cmd(5, new int[]{1, value14}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value15 = DataCanbus.DATA[84] + 1;
                if (value15 > 6) {
                    value15 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{1, value15}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value16 = DataCanbus.DATA[90] - 1;
                if (value16 < 0) {
                    value16 = 1;
                }
                DataCanbus.PROXY.cmd(5, new int[]{8, value16}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value17 = DataCanbus.DATA[90] + 1;
                if (value17 > 1) {
                    value17 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{8, value17}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value18 = DataCanbus.DATA[93] - 1;
                if (value18 < 0) {
                    value18 = 2;
                }
                DataCanbus.PROXY.cmd(5, new int[]{10, value18}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value19 = DataCanbus.DATA[93] + 1;
                if (value19 > 2) {
                    value19 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{10, value19}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value20 = DataCanbus.DATA[95] - 1;
                if (value20 < 0) {
                    value20 = 2;
                }
                DataCanbus.PROXY.cmd(5, new int[]{12, value20}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value21 = DataCanbus.DATA[95] + 1;
                if (value21 > 2) {
                    value21 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{12, value21}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value22 = DataCanbus.DATA[97] - 5;
                if (value22 < 0) {
                    value22 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{14, value22}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                DataCanbus.PROXY.cmd(5, new int[]{14, DataCanbus.DATA[97] + 5}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value23 = DataCanbus.DATA[98] - 1;
                if (value23 < 0) {
                    value23 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{15, value23}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                DataCanbus.PROXY.cmd(5, new int[]{15, DataCanbus.DATA[98] + 1}, null, null);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value24 = DataCanbus.DATA[99] - 1;
                if (value24 < 0) {
                    value24 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{16, value24}, null, null);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value25 = DataCanbus.DATA[99] + 1;
                if (value25 > 200) {
                    value25 = 200;
                }
                DataCanbus.PROXY.cmd(5, new int[]{16, value25}, null, null);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value26 = DataCanbus.DATA[100] - 1;
                if (value26 < 0) {
                    value26 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{17, value26}, null, null);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value27 = DataCanbus.DATA[100] + 1;
                if (value27 > 200) {
                    value27 = 200;
                }
                DataCanbus.PROXY.cmd(5, new int[]{17, value27}, null, null);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value28 = DataCanbus.DATA[101] - 1;
                if (value28 < 0) {
                    value28 = 2;
                }
                DataCanbus.PROXY.cmd(5, new int[]{18, value28}, null, null);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value29 = DataCanbus.DATA[101] + 1;
                if (value29 > 2) {
                    value29 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{18, value29}, null, null);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value30 = DataCanbus.DATA[102] - 1;
                if (value30 < 0) {
                    value30 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{19, value30}, null, null);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value31 = DataCanbus.DATA[102] + 1;
                if (value31 > 16) {
                    value31 = 16;
                }
                DataCanbus.PROXY.cmd(5, new int[]{19, value31}, null, null);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value32 = DataCanbus.DATA[104] - 1;
                if (value32 < 0) {
                    value32 = 1;
                }
                DataCanbus.PROXY.cmd(5, new int[]{21, value32}, null, null);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value33 = DataCanbus.DATA[104] + 1;
                if (value33 > 1) {
                    value33 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{21, value33}, null, null);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int value34 = DataCanbus.DATA[105] - 1;
                if (value34 < 0) {
                    value34 = 2;
                }
                DataCanbus.PROXY.cmd(5, new int[]{22, value34}, null, null);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int value35 = DataCanbus.DATA[105] + 1;
                if (value35 > 2) {
                    value35 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{22, value35}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                if (DataCanbus.DATA[86] == 0) {
                    value8 = 1;
                } else {
                    value8 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{3, value8}, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                if (DataCanbus.DATA[87] == 0) {
                    value7 = 1;
                } else {
                    value7 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{4, value7}, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                if (DataCanbus.DATA[88] == 0) {
                    value6 = 1;
                } else {
                    value6 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{5, value6}, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                if (DataCanbus.DATA[89] == 0) {
                    value5 = 1;
                } else {
                    value5 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{6, value5}, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                if (DataCanbus.DATA[91] == 0) {
                    value4 = 1;
                } else {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{7, value4}, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                if (DataCanbus.DATA[92] == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{9, value3}, null, null);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                if (DataCanbus.DATA[94] == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{11, value2}, null, null);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                if (DataCanbus.DATA[96] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{13, value}, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseFragment
    public void addNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseFragment
    public void removeNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.mNotifyCanbus);
        }
    }
}
