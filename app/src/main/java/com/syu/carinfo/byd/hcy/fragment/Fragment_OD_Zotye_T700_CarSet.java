package com.syu.carinfo.byd.hcy.fragment;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseFragment;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Fragment_OD_Zotye_T700_CarSet extends BaseFragment implements View.OnClickListener {
    int[] ids = {106, 107, 108, 109, 126, 127, 128, 129, 130};
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 106:
                    ((TextView) Fragment_OD_Zotye_T700_CarSet.this.findView(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                    break;
                case 107:
                    Fragment_OD_Zotye_T700_CarSet.this.setCheck((CheckedTextView) Fragment_OD_Zotye_T700_CarSet.this.findView(R.id.ctv_checkedtext1), value != 0);
                    break;
                case 108:
                    Fragment_OD_Zotye_T700_CarSet.this.setCheck((CheckedTextView) Fragment_OD_Zotye_T700_CarSet.this.findView(R.id.ctv_checkedtext2), value != 0);
                    break;
                case 109:
                    switch (value) {
                        case 0:
                            ((TextView) Fragment_OD_Zotye_T700_CarSet.this.findView(R.id.tv_text2)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) Fragment_OD_Zotye_T700_CarSet.this.findView(R.id.tv_text2)).setText("20s");
                            break;
                        case 2:
                            ((TextView) Fragment_OD_Zotye_T700_CarSet.this.findView(R.id.tv_text2)).setText("30s");
                            break;
                        case 3:
                            ((TextView) Fragment_OD_Zotye_T700_CarSet.this.findView(R.id.tv_text2)).setText("40s");
                            break;
                        case 4:
                            ((TextView) Fragment_OD_Zotye_T700_CarSet.this.findView(R.id.tv_text2)).setText("50s");
                            break;
                        case 5:
                            ((TextView) Fragment_OD_Zotye_T700_CarSet.this.findView(R.id.tv_text2)).setText("60s");
                            break;
                        case 6:
                            ((TextView) Fragment_OD_Zotye_T700_CarSet.this.findView(R.id.tv_text2)).setText("70s");
                            break;
                        case 7:
                            ((TextView) Fragment_OD_Zotye_T700_CarSet.this.findView(R.id.tv_text2)).setText("80s");
                            break;
                        case 8:
                            ((TextView) Fragment_OD_Zotye_T700_CarSet.this.findView(R.id.tv_text2)).setText("90s");
                            break;
                        case 9:
                            ((TextView) Fragment_OD_Zotye_T700_CarSet.this.findView(R.id.tv_text2)).setText("100s");
                            break;
                        case 10:
                            ((TextView) Fragment_OD_Zotye_T700_CarSet.this.findView(R.id.tv_text2)).setText("110s");
                            break;
                        case 11:
                            ((TextView) Fragment_OD_Zotye_T700_CarSet.this.findView(R.id.tv_text2)).setText("120s");
                            break;
                        case 12:
                            ((TextView) Fragment_OD_Zotye_T700_CarSet.this.findView(R.id.tv_text2)).setText("130s");
                            break;
                        case 13:
                            ((TextView) Fragment_OD_Zotye_T700_CarSet.this.findView(R.id.tv_text2)).setText("140s");
                            break;
                        case 14:
                            ((TextView) Fragment_OD_Zotye_T700_CarSet.this.findView(R.id.tv_text2)).setText("150s");
                            break;
                        case 15:
                            ((TextView) Fragment_OD_Zotye_T700_CarSet.this.findView(R.id.tv_text2)).setText("240s");
                            break;
                    }
                case 126:
                    switch (value) {
                        case 0:
                            ((TextView) Fragment_OD_Zotye_T700_CarSet.this.findView(R.id.tv_text3)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) Fragment_OD_Zotye_T700_CarSet.this.findView(R.id.tv_text3)).setText(R.string.str_255_hantengx5_11);
                            break;
                        case 2:
                            ((TextView) Fragment_OD_Zotye_T700_CarSet.this.findView(R.id.tv_text3)).setText(R.string.str_255_hantengx5_12);
                            break;
                    }
                case 127:
                    switch (value) {
                        case 0:
                            ((TextView) Fragment_OD_Zotye_T700_CarSet.this.findView(R.id.tv_text4)).setText(R.string.str_255_hantengx5_13);
                            break;
                        case 1:
                            ((TextView) Fragment_OD_Zotye_T700_CarSet.this.findView(R.id.tv_text4)).setText(R.string.str_255_hantengx5_14);
                            break;
                        case 2:
                            ((TextView) Fragment_OD_Zotye_T700_CarSet.this.findView(R.id.tv_text4)).setText(R.string.str_255_hantengx5_15);
                            break;
                        case 3:
                            ((TextView) Fragment_OD_Zotye_T700_CarSet.this.findView(R.id.tv_text4)).setText("全色呼吸");
                            break;
                    }
                case 128:
                    ((TextView) Fragment_OD_Zotye_T700_CarSet.this.findView(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 129:
                    Fragment_OD_Zotye_T700_CarSet.this.setCheck((CheckedTextView) Fragment_OD_Zotye_T700_CarSet.this.findView(R.id.ctv_checkedtext3), value != 0);
                    break;
                case 130:
                    ((TextView) Fragment_OD_Zotye_T700_CarSet.this.findView(R.id.tv_text6)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
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
        bindViewOnClick(R.id.ctv_checkedtext1, this);
        bindViewOnClick(R.id.ctv_checkedtext2, this);
        bindViewOnClick(R.id.ctv_checkedtext3, this);
    }

    @Override
    public void initListener() {
    }

    @Override
    public int getViewLayout() {
        return R.layout.layout_0452_od_zotye_t700_carset;
    }

    @Override
    public void addNotify() {
        DataCanbus.PROXY.cmd(2, new int[]{65}, null, null);
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

    @Override
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int temp = DataCanbus.DATA[106];
                if (temp > 1) {
                    temp--;
                }
                DataCanbus.PROXY.cmd(1, new int[]{149, temp}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int temp2 = DataCanbus.DATA[106];
                if (temp2 < 7) {
                    int i = temp2 + 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{149, 0}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int temp3 = DataCanbus.DATA[109];
                if (temp3 > 0) {
                    temp3--;
                }
                DataCanbus.PROXY.cmd(1, new int[]{150, temp3}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int temp4 = DataCanbus.DATA[109];
                if (temp4 < 15) {
                    int i2 = temp4 + 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{150, 0}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int temp5 = DataCanbus.DATA[126];
                if (temp5 > 0) {
                    temp5--;
                }
                DataCanbus.PROXY.cmd(1, new int[]{151, temp5}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int temp6 = DataCanbus.DATA[126];
                if (temp6 < 2) {
                    int i3 = temp6 + 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{151, 0}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int temp7 = DataCanbus.DATA[127];
                if (temp7 > 0) {
                    temp7--;
                }
                DataCanbus.PROXY.cmd(1, new int[]{152, temp7}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int temp8 = DataCanbus.DATA[127];
                if (temp8 < 3) {
                    int i4 = temp8 + 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{152, 0}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int temp9 = DataCanbus.DATA[128];
                if (temp9 > 0) {
                    temp9--;
                }
                DataCanbus.PROXY.cmd(1, new int[]{153, temp9}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int temp10 = DataCanbus.DATA[128];
                if (temp10 < 255) {
                    int i5 = temp10 + 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{153, 0}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int temp11 = DataCanbus.DATA[130];
                if (temp11 > 0) {
                    temp11--;
                }
                DataCanbus.PROXY.cmd(1, new int[]{155, temp11}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int temp12 = DataCanbus.DATA[130];
                if (temp12 < 7) {
                    int i6 = temp12 + 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{155, 0}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                if (DataCanbus.DATA[107] == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{148, value3}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                if (DataCanbus.DATA[108] == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{147, value2}, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                if (DataCanbus.DATA[129] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{154, value}, null, null);
                break;
        }
    }
}
