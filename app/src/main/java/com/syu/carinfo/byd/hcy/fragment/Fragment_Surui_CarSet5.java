package com.syu.carinfo.byd.hcy.fragment;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseFragment;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Fragment_Surui_CarSet5 extends BaseFragment implements View.OnClickListener {
    int[] ids = {60, 61, 62, 63, 64, 65, 66, 67, 68, 69};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.byd.hcy.fragment.Fragment_Surui_CarSet5.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 60:
                    Fragment_Surui_CarSet5.this.uBhomeLightDelay(value);
                    break;
                case 61:
                    Fragment_Surui_CarSet5.this.uAhomeLightDelay(value);
                    break;
                case 62:
                    Fragment_Surui_CarSet5.this.setCheck((CheckedTextView) Fragment_Surui_CarSet5.this.findView(R.id.ctv_checkedtext1), value != 0);
                    break;
                case 63:
                    Fragment_Surui_CarSet5.this.uUnlockSys(value);
                    break;
                case 64:
                    Fragment_Surui_CarSet5.this.uAirMode(value);
                    break;
                case 65:
                    Fragment_Surui_CarSet5.this.setCheck((CheckedTextView) Fragment_Surui_CarSet5.this.findView(R.id.ctv_checkedtext2), value != 0);
                    break;
                case 66:
                    Fragment_Surui_CarSet5.this.setCheck((CheckedTextView) Fragment_Surui_CarSet5.this.findView(R.id.ctv_checkedtext3), value != 0);
                    break;
                case 67:
                    Fragment_Surui_CarSet5.this.uAirWinlev(value);
                    break;
                case 68:
                    Fragment_Surui_CarSet5.this.setCheck((CheckedTextView) Fragment_Surui_CarSet5.this.findView(R.id.ctv_checkedtext4), value != 0);
                    break;
                case 69:
                    Fragment_Surui_CarSet5.this.uAudiomode(value);
                    break;
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
        bindViewOnClick(R.id.ctv_checkedtext1, this);
        bindViewOnClick(R.id.ctv_checkedtext2, this);
        bindViewOnClick(R.id.ctv_checkedtext3, this);
        bindViewOnClick(R.id.ctv_checkedtext4, this);
    }

    @Override // com.syu.canbus.BaseFragment
    public void initListener() {
    }

    @Override // com.syu.canbus.BaseFragment
    public int getViewLayout() {
        return R.layout.layout_0439_od_byd_all_carset;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                if (DataCanbus.DATA[62] == 0) {
                    value4 = 1;
                } else {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{3, value4}, null, null);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value5 = DataCanbus.DATA[60] - 1;
                if (value5 < 0) {
                    value5 = 6;
                }
                DataCanbus.PROXY.cmd(5, new int[]{1, value5}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value6 = DataCanbus.DATA[60] + 1;
                if (value6 > 6) {
                    value6 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{1, value6}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value7 = DataCanbus.DATA[61] - 1;
                if (value7 < 0) {
                    value7 = 6;
                }
                DataCanbus.PROXY.cmd(5, new int[]{2, value7}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value8 = DataCanbus.DATA[61] + 1;
                if (value8 > 6) {
                    value8 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{2, value8}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value9 = DataCanbus.DATA[63] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                DataCanbus.PROXY.cmd(5, new int[]{4, value9}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value10 = DataCanbus.DATA[63] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{4, value10}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value11 = DataCanbus.DATA[64] - 1;
                if (value11 < 0) {
                    value11 = 2;
                }
                DataCanbus.PROXY.cmd(5, new int[]{5, value11}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value12 = DataCanbus.DATA[64] + 1;
                if (value12 > 2) {
                    value12 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{5, value12}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value13 = DataCanbus.DATA[67] - 1;
                if (value13 < 0) {
                    value13 = 2;
                }
                DataCanbus.PROXY.cmd(5, new int[]{8, value13}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value14 = DataCanbus.DATA[67] + 1;
                if (value14 > 2) {
                    value14 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{8, value14}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value15 = DataCanbus.DATA[69] - 1;
                if (value15 < 0) {
                    value15 = 1;
                }
                DataCanbus.PROXY.cmd(5, new int[]{10, value15}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value16 = DataCanbus.DATA[69] + 1;
                if (value16 > 1) {
                    value16 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{10, value16}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                if (DataCanbus.DATA[65] == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{6, value3}, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                if (DataCanbus.DATA[66] == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{7, value2}, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                if (DataCanbus.DATA[68] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{9, value}, null, null);
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

    protected void uAudiomode(int value) {
        switch (value) {
            case 0:
                ((TextView) findView(R.id.tv_text6)).setText(R.string.haval_volspeed1);
                break;
            case 1:
                ((TextView) findView(R.id.tv_text6)).setText("DTS");
                break;
        }
    }

    protected void uAirWinlev(int value) {
        switch (value) {
            case 0:
                ((TextView) findView(R.id.tv_text5)).setText(R.string.distance_close);
                break;
            case 1:
                ((TextView) findView(R.id.tv_text5)).setText(R.string.klc_air_middle);
                break;
            case 2:
                ((TextView) findView(R.id.tv_text5)).setText(R.string.distance_far);
                break;
        }
    }

    protected void uAirMode(int value) {
        switch (value) {
            case 0:
                ((TextView) findView(R.id.tv_text4)).setText(R.string.str_driving_eco);
                break;
            case 1:
                ((TextView) findView(R.id.tv_text4)).setText(R.string.wc_golf_comfort);
                break;
            case 2:
                ((TextView) findView(R.id.tv_text4)).setText(R.string.str_intelligent);
                break;
        }
    }

    protected void uUnlockSys(int value) {
        switch (value) {
            case 0:
                ((TextView) findView(R.id.tv_text3)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
                break;
            case 1:
                ((TextView) findView(R.id.tv_text3)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
                break;
        }
    }

    protected void uAhomeLightDelay(int value) {
        switch (value) {
            case 0:
                ((TextView) findView(R.id.tv_text2)).setText(R.string.off);
                break;
            case 1:
                ((TextView) findView(R.id.tv_text2)).setText("10s");
                break;
            case 2:
                ((TextView) findView(R.id.tv_text2)).setText("20s");
                break;
            case 3:
                ((TextView) findView(R.id.tv_text2)).setText("30s");
                break;
            case 4:
                ((TextView) findView(R.id.tv_text2)).setText("40s");
                break;
            case 5:
                ((TextView) findView(R.id.tv_text2)).setText("50s");
                break;
            case 6:
                ((TextView) findView(R.id.tv_text2)).setText("60s");
                break;
        }
    }

    protected void uBhomeLightDelay(int value) {
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
