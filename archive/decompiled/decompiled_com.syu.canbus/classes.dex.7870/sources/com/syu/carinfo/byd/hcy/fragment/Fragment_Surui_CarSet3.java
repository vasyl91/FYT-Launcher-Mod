package com.syu.carinfo.byd.hcy.fragment;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseFragment;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class Fragment_Surui_CarSet3 extends BaseFragment implements View.OnClickListener {
    int[] ids = {123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.byd.hcy.fragment.Fragment_Surui_CarSet3.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 123:
                    Fragment_Surui_CarSet3.this.updateHomeLightDelay(value);
                    break;
                case 124:
                    Fragment_Surui_CarSet3.this.uRemoteUp(value);
                    break;
                case 125:
                    Fragment_Surui_CarSet3.this.uRemoteDown(value);
                    break;
                case 126:
                    Fragment_Surui_CarSet3.this.uRearViewAutoBack(value);
                    break;
                case 127:
                    Fragment_Surui_CarSet3.this.uRearCtrl(value);
                    break;
                case 128:
                    Fragment_Surui_CarSet3.this.uBlueWindDown(value);
                    break;
                case 129:
                    Fragment_Surui_CarSet3.this.uUnlockSet(value);
                    break;
                case 130:
                    Fragment_Surui_CarSet3.this.uAutolockSet(value);
                    break;
                case 131:
                    Fragment_Surui_CarSet3.this.uNightModeSet(value);
                    break;
                case 132:
                    Fragment_Surui_CarSet3.this.uAirAutoAc(value);
                    break;
                case 133:
                    Fragment_Surui_CarSet3.this.uAutoCyclePark(value);
                    break;
                case 134:
                    Fragment_Surui_CarSet3.this.uAutoWindlev(value);
                    break;
                case 135:
                    Fragment_Surui_CarSet3.this.uAutoCycleTunnel(value);
                    break;
                case 136:
                    Fragment_Surui_CarSet3.this.uMaintenanceDay(value);
                    break;
                case 137:
                    Fragment_Surui_CarSet3.this.uMaintenanceMileage(value);
                    break;
                case 138:
                    Fragment_Surui_CarSet3.this.uSpeedWarn(value);
                    break;
                case 139:
                    Fragment_Surui_CarSet3.this.uWinterSpeedWarn(value);
                    break;
                case 140:
                    Fragment_Surui_CarSet3.this.uMeterTheme(value);
                    break;
                case 141:
                    Fragment_Surui_CarSet3.this.uMeterBackLight(value);
                    break;
                case 143:
                    Fragment_Surui_CarSet3.this.uTempUnit(value);
                    break;
                case 144:
                    Fragment_Surui_CarSet3.this.uPressureUnit(value);
                    break;
                case 145:
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
            case R.id.btn_minus1 /* 2131427417 */:
                int value10 = DataCanbus.DATA[123];
                int value11 = value10 - 1;
                if (value11 < 0) {
                    value11 = 6;
                }
                DataCanbus.PROXY.cmd(5, new int[]{1, value11}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int value12 = DataCanbus.DATA[123];
                int value13 = value12 + 1;
                if (value13 > 6) {
                    value13 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{1, value13}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int value14 = DataCanbus.DATA[129];
                int value15 = value14 - 1;
                if (value15 < 0) {
                    value15 = 1;
                }
                DataCanbus.PROXY.cmd(5, new int[]{8, value15}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int value16 = DataCanbus.DATA[129];
                int value17 = value16 + 1;
                if (value17 > 1) {
                    value17 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{8, value17}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427425 */:
                int value18 = DataCanbus.DATA[132];
                int value19 = value18 - 1;
                if (value19 < 0) {
                    value19 = 2;
                }
                DataCanbus.PROXY.cmd(5, new int[]{10, value19}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                int value20 = DataCanbus.DATA[132];
                int value21 = value20 + 1;
                if (value21 > 2) {
                    value21 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{10, value21}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427428 */:
                int value22 = DataCanbus.DATA[134];
                int value23 = value22 + 1;
                if (value23 > 2) {
                    value23 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{12, value23}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427429 */:
                int value24 = DataCanbus.DATA[136];
                DataCanbus.PROXY.cmd(5, new int[]{14, value24 + 5}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427430 */:
                int value25 = DataCanbus.DATA[137];
                DataCanbus.PROXY.cmd(5, new int[]{15, value25 + 1}, null, null);
                break;
            case R.id.btn_plus7 /* 2131427431 */:
                int value26 = DataCanbus.DATA[140];
                int value27 = value26 + 1;
                if (value27 > 2) {
                    value27 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{18, value27}, null, null);
                break;
            case R.id.btn_plus8 /* 2131427432 */:
                int value28 = DataCanbus.DATA[141];
                int value29 = value28 + 1;
                if (value29 > 16) {
                    value29 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{19, value29}, null, null);
                break;
            case R.id.btn_plus9 /* 2131427433 */:
                int value30 = DataCanbus.DATA[143];
                int value31 = value30 + 1;
                if (value31 > 1) {
                    value31 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{21, value31}, null, null);
                break;
            case R.id.btn_plus10 /* 2131427434 */:
                int value32 = DataCanbus.DATA[144];
                int value33 = value32 + 1;
                if (value33 > 2) {
                    value33 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{22, value33}, null, null);
                break;
            case R.id.btn_plus11 /* 2131427435 */:
                int value34 = DataCanbus.DATA[145];
                int value35 = value34 + 1;
                if (value35 > 3) {
                    value35 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{23, value35}, null, null);
                break;
            case R.id.btn_plus12 /* 2131427436 */:
                int value36 = DataCanbus.DATA[138];
                int value37 = value36 + 10;
                if (value37 > 200) {
                    value37 = 10;
                }
                DataCanbus.PROXY.cmd(5, new int[]{16, value37}, null, null);
                break;
            case R.id.btn_plus13 /* 2131427437 */:
                int value38 = DataCanbus.DATA[139];
                int value39 = value38 + 10;
                if (value39 > 200) {
                    value39 = 10;
                }
                DataCanbus.PROXY.cmd(5, new int[]{17, value39}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427473 */:
                int value40 = DataCanbus.DATA[134];
                int value41 = value40 - 1;
                if (value41 < 0) {
                    value41 = 2;
                }
                DataCanbus.PROXY.cmd(5, new int[]{12, value41}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427474 */:
                int value42 = DataCanbus.DATA[136];
                int value43 = value42 - 5;
                if (value43 < 0) {
                    value43 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{14, value43}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427476 */:
                int value44 = DataCanbus.DATA[137];
                int value45 = value44 - 1;
                if (value45 < 0) {
                    value45 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{15, value45}, null, null);
                break;
            case R.id.btn_minus7 /* 2131427478 */:
                int value46 = DataCanbus.DATA[140];
                int value47 = value46 - 1;
                if (value47 < 0) {
                    value47 = 2;
                }
                DataCanbus.PROXY.cmd(5, new int[]{18, value47}, null, null);
                break;
            case R.id.btn_minus8 /* 2131427480 */:
                int value48 = DataCanbus.DATA[141];
                int value49 = value48 - 1;
                if (value49 < 0) {
                    value49 = 16;
                }
                DataCanbus.PROXY.cmd(5, new int[]{19, value49}, null, null);
                break;
            case R.id.btn_minus9 /* 2131427482 */:
                int value50 = DataCanbus.DATA[143];
                int value51 = value50 - 1;
                if (value51 < 0) {
                    value51 = 1;
                }
                DataCanbus.PROXY.cmd(5, new int[]{21, value51}, null, null);
                break;
            case R.id.btn_minus10 /* 2131427484 */:
                int value52 = DataCanbus.DATA[144];
                int value53 = value52 - 1;
                if (value53 < 0) {
                    value53 = 2;
                }
                DataCanbus.PROXY.cmd(5, new int[]{22, value53}, null, null);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value54 = DataCanbus.DATA[145];
                int value55 = value54 - 1;
                if (value55 < 0) {
                    value55 = 3;
                }
                DataCanbus.PROXY.cmd(5, new int[]{23, value55}, null, null);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value56 = DataCanbus.DATA[138];
                int value57 = value56 - 10;
                if (value57 <= 0) {
                    value57 = 200;
                }
                DataCanbus.PROXY.cmd(5, new int[]{16, value57}, null, null);
                break;
            case R.id.btn_minus13 /* 2131427490 */:
                int value58 = DataCanbus.DATA[139];
                int value59 = value58 - 10;
                if (value59 <= 0) {
                    value59 = 200;
                }
                DataCanbus.PROXY.cmd(5, new int[]{17, value59}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427548 */:
                int value60 = DataCanbus.DATA[125];
                if (value60 == 0) {
                    value9 = 1;
                } else {
                    value9 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{3, value9}, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427552 */:
                int value61 = DataCanbus.DATA[127];
                if (value61 == 0) {
                    value6 = 1;
                } else {
                    value6 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{5, value6}, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427553 */:
                int value62 = DataCanbus.DATA[128];
                if (value62 == 0) {
                    value5 = 1;
                } else {
                    value5 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{6, value5}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427558 */:
                int value63 = DataCanbus.DATA[124];
                if (value63 == 0) {
                    value8 = 1;
                } else {
                    value8 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{2, value8}, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427559 */:
                int value64 = DataCanbus.DATA[130];
                if (value64 == 0) {
                    value7 = 1;
                } else {
                    value7 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{7, value7}, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427563 */:
                int value65 = DataCanbus.DATA[133];
                if (value65 == 0) {
                    value4 = 1;
                } else {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{11, value4}, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427564 */:
                int value66 = DataCanbus.DATA[135];
                if (value66 == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{13, value3}, null, null);
                break;
            case R.id.ctv_checkedtext8 /* 2131427615 */:
                int value67 = DataCanbus.DATA[126];
                if (value67 == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{4, value2}, null, null);
                break;
            case R.id.ctv_checkedtext9 /* 2131427616 */:
                int value68 = DataCanbus.DATA[131];
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
                    ((TextView) findView(R.id.tv_text11)).setText(CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                    break;
                case 1:
                    ((TextView) findView(R.id.tv_text11)).setText("mpg(GB)");
                    break;
                case 2:
                    ((TextView) findView(R.id.tv_text11)).setText(CamryData.OIL_EXPEND_UNIT_KM_PER_L);
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
