package com.syu.carinfo.byd.hcy.fragment;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseFragment;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Fragment_Surui_CarSet3 extends BaseFragment implements View.OnClickListener {
    int[] ids = {59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.byd.hcy.fragment.Fragment_Surui_CarSet3.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 59:
                    Fragment_Surui_CarSet3.this.updateHomeLightDelay(value);
                    break;
                case 60:
                    Fragment_Surui_CarSet3.this.uRemoteUp(value);
                    break;
                case 61:
                    Fragment_Surui_CarSet3.this.uRemoteDown(value);
                    break;
                case 62:
                    Fragment_Surui_CarSet3.this.uRearViewAutoBack(value);
                    break;
                case 63:
                    Fragment_Surui_CarSet3.this.uRearCtrl(value);
                    break;
                case 64:
                    Fragment_Surui_CarSet3.this.uBlueWindDown(value);
                    break;
                case 65:
                    Fragment_Surui_CarSet3.this.uUnlockSet(value);
                    break;
                case 66:
                    Fragment_Surui_CarSet3.this.uAutolockSet(value);
                    break;
                case 67:
                    Fragment_Surui_CarSet3.this.uNightModeSet(value);
                    break;
                case 68:
                    Fragment_Surui_CarSet3.this.uAirAutoAc(value);
                    break;
                case 69:
                    Fragment_Surui_CarSet3.this.uAutoCyclePark(value);
                    break;
                case 70:
                    Fragment_Surui_CarSet3.this.uAutoWindlev(value);
                    break;
                case 71:
                    Fragment_Surui_CarSet3.this.uAutoCycleTunnel(value);
                    break;
                case 72:
                    Fragment_Surui_CarSet3.this.uMaintenanceDay(value);
                    break;
                case 73:
                    Fragment_Surui_CarSet3.this.uMaintenanceMileage(value);
                    break;
                case 74:
                    Fragment_Surui_CarSet3.this.uSpeedWarn(value);
                    break;
                case 75:
                    Fragment_Surui_CarSet3.this.uWinterSpeedWarn(value);
                    break;
                case 76:
                    Fragment_Surui_CarSet3.this.uMeterTheme(value);
                    break;
                case 77:
                    Fragment_Surui_CarSet3.this.uMeterBackLight(value);
                    break;
                case 79:
                    Fragment_Surui_CarSet3.this.uTempUnit(value);
                    break;
                case 80:
                    Fragment_Surui_CarSet3.this.uPressureUnit(value);
                    break;
                case 81:
                    Fragment_Surui_CarSet3.this.uOilUnit(value);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseFragment
    public void initView() {
        bindViewOnClick(R.id.btn_minus13, this);
        bindViewOnClick(R.id.btn_plus13, this);
        bindViewOnClick(R.id.btn_minus12, this);
        bindViewOnClick(R.id.btn_plus12, this);
        bindViewOnClick(R.id.btn_minus11, this);
        bindViewOnClick(R.id.btn_plus11, this);
        bindViewOnClick(R.id.btn_minus10, this);
        bindViewOnClick(R.id.btn_plus10, this);
        bindViewOnClick(R.id.btn_minus9, this);
        bindViewOnClick(R.id.btn_plus9, this);
        bindViewOnClick(R.id.btn_minus8, this);
        bindViewOnClick(R.id.btn_plus8, this);
        bindViewOnClick(R.id.btn_minus7, this);
        bindViewOnClick(R.id.btn_plus7, this);
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
        return R.layout.layout_0439_od_hcy_byd_sirui_carset;
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
                int value10 = DataCanbus.DATA[75];
                int value11 = value10 - 10;
                if (value11 <= 0) {
                    value11 = 200;
                }
                DataCanbus.PROXY.cmd(5, new int[]{17, value11}, null, null);
                break;
            case R.id.btn_plus13 /* 2131427470 */:
                int value12 = DataCanbus.DATA[75];
                int value13 = value12 + 10;
                if (value13 > 200) {
                    value13 = 10;
                }
                DataCanbus.PROXY.cmd(5, new int[]{17, value13}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value14 = DataCanbus.DATA[61];
                if (value14 == 0) {
                    value9 = 1;
                } else {
                    value9 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{3, value9}, null, null);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value15 = DataCanbus.DATA[59];
                int value16 = value15 - 1;
                if (value16 < 0) {
                    value16 = 6;
                }
                DataCanbus.PROXY.cmd(5, new int[]{1, value16}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value17 = DataCanbus.DATA[59];
                int value18 = value17 + 1;
                if (value18 > 6) {
                    value18 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{1, value18}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value19 = DataCanbus.DATA[65];
                int value20 = value19 - 1;
                if (value20 < 0) {
                    value20 = 1;
                }
                DataCanbus.PROXY.cmd(5, new int[]{8, value20}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value21 = DataCanbus.DATA[65];
                int value22 = value21 + 1;
                if (value22 > 1) {
                    value22 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{8, value22}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value23 = DataCanbus.DATA[68];
                int value24 = value23 - 1;
                if (value24 < 0) {
                    value24 = 2;
                }
                DataCanbus.PROXY.cmd(5, new int[]{10, value24}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value25 = DataCanbus.DATA[68];
                int value26 = value25 + 1;
                if (value26 > 2) {
                    value26 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{10, value26}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value27 = DataCanbus.DATA[70];
                int value28 = value27 - 1;
                if (value28 < 0) {
                    value28 = 2;
                }
                DataCanbus.PROXY.cmd(5, new int[]{12, value28}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value29 = DataCanbus.DATA[70];
                int value30 = value29 + 1;
                if (value30 > 2) {
                    value30 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{12, value30}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value31 = DataCanbus.DATA[72];
                int value32 = value31 - 5;
                if (value32 < 0) {
                    value32 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{14, value32}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value33 = DataCanbus.DATA[72];
                DataCanbus.PROXY.cmd(5, new int[]{14, value33 + 5}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value34 = DataCanbus.DATA[73];
                int value35 = value34 - 1;
                if (value35 < 0) {
                    value35 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{15, value35}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value36 = DataCanbus.DATA[73];
                DataCanbus.PROXY.cmd(5, new int[]{15, value36 + 1}, null, null);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value37 = DataCanbus.DATA[76];
                int value38 = value37 - 1;
                if (value38 < 0) {
                    value38 = 2;
                }
                DataCanbus.PROXY.cmd(5, new int[]{18, value38}, null, null);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value39 = DataCanbus.DATA[76];
                int value40 = value39 + 1;
                if (value40 > 2) {
                    value40 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{18, value40}, null, null);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value41 = DataCanbus.DATA[77];
                int value42 = value41 - 1;
                if (value42 < 0) {
                    value42 = 16;
                }
                DataCanbus.PROXY.cmd(5, new int[]{19, value42}, null, null);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value43 = DataCanbus.DATA[77];
                int value44 = value43 + 1;
                if (value44 > 16) {
                    value44 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{19, value44}, null, null);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value45 = DataCanbus.DATA[79];
                int value46 = value45 - 1;
                if (value46 < 0) {
                    value46 = 1;
                }
                DataCanbus.PROXY.cmd(5, new int[]{21, value46}, null, null);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value47 = DataCanbus.DATA[79];
                int value48 = value47 + 1;
                if (value48 > 1) {
                    value48 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{21, value48}, null, null);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value49 = DataCanbus.DATA[80];
                int value50 = value49 - 1;
                if (value50 < 0) {
                    value50 = 2;
                }
                DataCanbus.PROXY.cmd(5, new int[]{22, value50}, null, null);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value51 = DataCanbus.DATA[80];
                int value52 = value51 + 1;
                if (value52 > 2) {
                    value52 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{22, value52}, null, null);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value53 = DataCanbus.DATA[81];
                int value54 = value53 - 1;
                if (value54 < 0) {
                    value54 = 3;
                }
                DataCanbus.PROXY.cmd(5, new int[]{23, value54}, null, null);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value55 = DataCanbus.DATA[81];
                int value56 = value55 + 1;
                if (value56 > 3) {
                    value56 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{23, value56}, null, null);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int value57 = DataCanbus.DATA[74];
                int value58 = value57 - 10;
                if (value58 <= 0) {
                    value58 = 200;
                }
                DataCanbus.PROXY.cmd(5, new int[]{16, value58}, null, null);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int value59 = DataCanbus.DATA[74];
                int value60 = value59 + 10;
                if (value60 > 200) {
                    value60 = 10;
                }
                DataCanbus.PROXY.cmd(5, new int[]{16, value60}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value61 = DataCanbus.DATA[60];
                if (value61 == 0) {
                    value8 = 1;
                } else {
                    value8 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{2, value8}, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value62 = DataCanbus.DATA[66];
                if (value62 == 0) {
                    value7 = 1;
                } else {
                    value7 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{7, value7}, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value63 = DataCanbus.DATA[63];
                if (value63 == 0) {
                    value6 = 1;
                } else {
                    value6 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{5, value6}, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value64 = DataCanbus.DATA[64];
                if (value64 == 0) {
                    value5 = 1;
                } else {
                    value5 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{6, value5}, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value65 = DataCanbus.DATA[69];
                if (value65 == 0) {
                    value4 = 1;
                } else {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{11, value4}, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value66 = DataCanbus.DATA[71];
                if (value66 == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{13, value3}, null, null);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value67 = DataCanbus.DATA[62];
                if (value67 == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{4, value2}, null, null);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value68 = DataCanbus.DATA[67];
                if (value68 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{9, value}, null, null);
                break;
        }
    }

    protected void uOilUnit(int value) {
        if (((TextView) findView(R.id.tv_text11)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findView(R.id.tv_text11)).setText("L/100km");
                    break;
                case 1:
                    ((TextView) findView(R.id.tv_text11)).setText("mpg(GB)");
                    break;
                case 2:
                    ((TextView) findView(R.id.tv_text11)).setText("km/L");
                    break;
                case 3:
                    ((TextView) findView(R.id.tv_text11)).setText("mpg(US)");
                    break;
            }
        }
    }

    protected void uPressureUnit(int value) {
        if (((TextView) findView(R.id.tv_text10)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findView(R.id.tv_text10)).setText("bar");
                    break;
                case 1:
                    ((TextView) findView(R.id.tv_text10)).setText("psi");
                    break;
                case 2:
                    ((TextView) findView(R.id.tv_text10)).setText("kpa");
                    break;
            }
        }
    }

    protected void uTempUnit(int value) {
        if (((TextView) findView(R.id.tv_text9)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findView(R.id.tv_text9)).setText("℃");
                    break;
                case 1:
                    ((TextView) findView(R.id.tv_text9)).setText("℉");
                    break;
            }
        }
    }

    protected void uMeterBackLight(int value) {
        if (((TextView) findView(R.id.tv_text8)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findView(R.id.tv_text8)).setText(R.string.off);
                    break;
                default:
                    ((TextView) findView(R.id.tv_text8)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
            }
        }
    }

    protected void uMeterTheme(int value) {
        if (((TextView) findView(R.id.tv_text7)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findView(R.id.tv_text7)).setText("幻际星穗");
                    break;
                case 1:
                    ((TextView) findView(R.id.tv_text7)).setText("灵动空间");
                    break;
                case 2:
                    ((TextView) findView(R.id.tv_text7)).setText("简约主义");
                    break;
            }
        }
    }

    protected void uWinterSpeedWarn(int value) {
        if (((TextView) findView(R.id.tv_text13)) != null) {
            ((TextView) findView(R.id.tv_text13)).setText(String.valueOf(value) + "km/h");
        }
    }

    protected void uSpeedWarn(int value) {
        if (((TextView) findView(R.id.tv_text12)) != null) {
            ((TextView) findView(R.id.tv_text12)).setText(String.valueOf(value) + "km/h");
        }
    }

    protected void uMaintenanceMileage(int value) {
        if (((TextView) findView(R.id.tv_text6)) != null) {
            ((TextView) findView(R.id.tv_text6)).setText(String.valueOf(value) + "km");
        }
    }

    protected void uMaintenanceDay(int value) {
        if (((TextView) findView(R.id.tv_text5)) != null) {
            ((TextView) findView(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
        }
    }

    protected void uAutoCycleTunnel(int value) {
        setCheck((CheckedTextView) findView(R.id.ctv_checkedtext7), value != 0);
    }

    protected void uAutoWindlev(int value) {
        if (((TextView) findView(R.id.tv_text4)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findView(R.id.tv_text4)).setText(R.string.distance_close);
                    break;
                case 1:
                    ((TextView) findView(R.id.tv_text4)).setText(R.string.klc_air_middle);
                    break;
                case 2:
                    ((TextView) findView(R.id.tv_text4)).setText(R.string.distance_far);
                    break;
            }
        }
    }

    protected void uAutoCyclePark(int value) {
        setCheck((CheckedTextView) findView(R.id.ctv_checkedtext6), value != 0);
    }

    protected void uAirAutoAc(int value) {
        if (((TextView) findView(R.id.tv_text3)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findView(R.id.tv_text3)).setText(R.string.str_driving_eco);
                    break;
                case 1:
                    ((TextView) findView(R.id.tv_text3)).setText(R.string.str_wc_174008_str17);
                    break;
                case 2:
                    ((TextView) findView(R.id.tv_text3)).setText(R.string.str_intelligent);
                    break;
            }
        }
    }

    protected void uNightModeSet(int value) {
        setCheck((CheckedTextView) findView(R.id.ctv_checkedtext9), value != 0);
    }

    protected void uUnlockSet(int value) {
        if (((TextView) findView(R.id.tv_text2)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findView(R.id.tv_text2)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
                    break;
                case 1:
                    ((TextView) findView(R.id.tv_text2)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
                    break;
            }
        }
    }

    protected void uBlueWindDown(int value) {
        setCheck((CheckedTextView) findView(R.id.ctv_checkedtext5), value != 0);
    }

    protected void uRearCtrl(int value) {
        setCheck((CheckedTextView) findView(R.id.ctv_checkedtext4), value != 0);
    }

    protected void uRearViewAutoBack(int value) {
        setCheck((CheckedTextView) findView(R.id.ctv_checkedtext8), value != 0);
    }

    protected void uAutolockSet(int value) {
        setCheck((CheckedTextView) findView(R.id.ctv_checkedtext3), value != 0);
    }

    protected void uRemoteUp(int value) {
        setCheck((CheckedTextView) findView(R.id.ctv_checkedtext2), value != 0);
    }

    protected void uRemoteDown(int value) {
        setCheck((CheckedTextView) findView(R.id.ctv_checkedtext1), value != 0);
    }

    protected void updateHomeLightDelay(int value) {
        if (((TextView) findView(R.id.tv_text1)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findView(R.id.tv_text1)).setText(R.string.off);
                    break;
                case 1:
                    ((TextView) findView(R.id.tv_text1)).setText("10s");
                    break;
                case 2:
                    ((TextView) findView(R.id.tv_text1)).setText("20s");
                    break;
                case 3:
                    ((TextView) findView(R.id.tv_text1)).setText("30s");
                    break;
                case 4:
                    ((TextView) findView(R.id.tv_text1)).setText("40s");
                    break;
                case 5:
                    ((TextView) findView(R.id.tv_text1)).setText("50s");
                    break;
                case 6:
                    ((TextView) findView(R.id.tv_text1)).setText("60s");
                    break;
            }
        }
    }
}
