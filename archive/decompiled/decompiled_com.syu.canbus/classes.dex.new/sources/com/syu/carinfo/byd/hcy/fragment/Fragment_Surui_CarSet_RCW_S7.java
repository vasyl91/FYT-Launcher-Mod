package com.syu.carinfo.byd.hcy.fragment;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseFragment;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Fragment_Surui_CarSet_RCW_S7 extends BaseFragment implements View.OnClickListener {
    int[] ids = {135, 136, 137, 138, 139, 140, 141, 146, 147, 148, 149};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.byd.hcy.fragment.Fragment_Surui_CarSet_RCW_S7.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 135:
                    switch (value) {
                        case 0:
                            ((TextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.tv_text2)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.tv_text2)).setText("10s");
                            break;
                        case 2:
                            ((TextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.tv_text2)).setText("20s");
                            break;
                        case 3:
                            ((TextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.tv_text2)).setText("30s");
                            break;
                        case 4:
                            ((TextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.tv_text2)).setText("40s");
                            break;
                        case 5:
                            ((TextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.tv_text2)).setText("50s");
                            break;
                        case 6:
                            ((TextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.tv_text2)).setText("60s");
                            break;
                    }
                    break;
                case 136:
                    switch (value) {
                        case 0:
                            ((TextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.tv_text1)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
                            break;
                        case 1:
                            ((TextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.tv_text1)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
                            break;
                    }
                    break;
                case 137:
                    Fragment_Surui_CarSet_RCW_S7.this.setCheck((CheckedTextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.ctv_checkedtext4), value != 0);
                    break;
                case 138:
                    Fragment_Surui_CarSet_RCW_S7.this.setCheck((CheckedTextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.ctv_checkedtext3), value != 0);
                    break;
                case 139:
                    Fragment_Surui_CarSet_RCW_S7.this.setCheck((CheckedTextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.ctv_checkedtext2), value != 0);
                    break;
                case 140:
                    Fragment_Surui_CarSet_RCW_S7.this.setCheck((CheckedTextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.ctv_checkedtext1), value != 0);
                    break;
                case 141:
                    switch (value) {
                        case 0:
                            ((TextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.tv_text3)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.tv_text3)).setText("10s");
                            break;
                        case 2:
                            ((TextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.tv_text3)).setText("20s");
                            break;
                        case 3:
                            ((TextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.tv_text3)).setText("30s");
                            break;
                        case 4:
                            ((TextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.tv_text3)).setText("40s");
                            break;
                        case 5:
                            ((TextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.tv_text3)).setText("50s");
                            break;
                        case 6:
                            ((TextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.tv_text3)).setText("60s");
                            break;
                    }
                    break;
                case 146:
                    Fragment_Surui_CarSet_RCW_S7.this.setCheck((CheckedTextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.ctv_checkedtext5), value != 0);
                    break;
                case 147:
                    Fragment_Surui_CarSet_RCW_S7.this.setCheck((CheckedTextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.ctv_checkedtext6), value != 0);
                    break;
                case 148:
                    switch (value) {
                        case 0:
                            ((TextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.tv_text4)).setText(R.string.off);
                            break;
                        default:
                            ((TextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.tv_text4)).setText(String.valueOf(value * 10) + "%");
                            break;
                    }
                    break;
                case 149:
                    switch (value) {
                        case 1:
                            ((TextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.tv_text5)).setText("10min");
                            break;
                        case 2:
                            ((TextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.tv_text5)).setText("15min");
                            break;
                        case 3:
                            ((TextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.tv_text5)).setText("20min");
                            break;
                        case 4:
                            ((TextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.tv_text5)).setText("25min");
                            break;
                        case 5:
                            ((TextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.tv_text5)).setText("30min");
                            break;
                        default:
                            ((TextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.tv_text5)).setText("--");
                            break;
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseFragment
    public void initView() {
        bindViewOnClick(R.id.ctv_checkedtext1, this);
        bindViewOnClick(R.id.ctv_checkedtext2, this);
        bindViewOnClick(R.id.ctv_checkedtext3, this);
        bindViewOnClick(R.id.ctv_checkedtext4, this);
        bindViewOnClick(R.id.ctv_checkedtext5, this);
        bindViewOnClick(R.id.ctv_checkedtext6, this);
        bindViewOnClick(R.id.ctv_checkedtext7, this);
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
    }

    @Override // com.syu.canbus.BaseFragment
    public void initListener() {
    }

    @Override // com.syu.canbus.BaseFragment
    public int getViewLayout() {
        return R.layout.layout_0439_byds7_carset;
    }

    @Override // com.syu.canbus.BaseFragment
    public void addNotify() {
        if (DataCanbus.DATA[1000] == 9830839) {
            findView(R.id.layout_view1).setVisibility(0);
            findView(R.id.layout_view2).setVisibility(0);
        } else {
            findView(R.id.layout_view1).setVisibility(8);
            findView(R.id.layout_view2).setVisibility(8);
        }
        if (DataCanbus.DATA[1000] == 9699767 || DataCanbus.DATA[1000] == 9765303 || DataCanbus.DATA[1000] == 9830839 || DataCanbus.DATA[1000] == 9896375 || DataCanbus.DATA[1000] == 9961911 || DataCanbus.DATA[1000] == 10027447 || DataCanbus.DATA[1000] == 10092983 || DataCanbus.DATA[1000] == 4325831 || DataCanbus.DATA[1000] == 4391367 || DataCanbus.DATA[1000] == 4456903) {
            RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
            int[] iArr = new int[4];
            iArr[0] = 41;
            remoteModuleProxy.cmd(2, iArr, null, null);
        }
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
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                if (DataCanbus.DATA[136] == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{11, value2}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                if (DataCanbus.DATA[136] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{11, value}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value9 = DataCanbus.DATA[135];
                if (value9 > 0) {
                    value9--;
                }
                DataCanbus.PROXY.cmd(1, new int[]{12, value9}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value10 = DataCanbus.DATA[135];
                if (value10 < 6) {
                    value10++;
                }
                DataCanbus.PROXY.cmd(1, new int[]{12, value10}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value11 = DataCanbus.DATA[141];
                if (value11 > 0) {
                    value11--;
                }
                DataCanbus.PROXY.cmd(1, new int[]{13, value11}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value12 = DataCanbus.DATA[141];
                if (value12 < 6) {
                    value12++;
                }
                DataCanbus.PROXY.cmd(1, new int[]{13, value12}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value13 = DataCanbus.DATA[148];
                if (value13 > 0) {
                    value13--;
                }
                DataCanbus.PROXY.cmd(1, new int[]{17, value13}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value14 = DataCanbus.DATA[148];
                if (value14 < 10) {
                    value14++;
                }
                DataCanbus.PROXY.cmd(1, new int[]{17, value14}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value15 = DataCanbus.DATA[149] - 1;
                if (value15 < 1) {
                    value15 = 5;
                }
                DataCanbus.PROXY.cmd(1, new int[]{18, value15}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value16 = DataCanbus.DATA[149] + 1;
                if (value16 > 5) {
                    value16 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{18, value16}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                if (DataCanbus.DATA[140] == 0) {
                    value8 = 1;
                } else {
                    value8 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{7, value8}, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                if (DataCanbus.DATA[137] == 0) {
                    value5 = 1;
                } else {
                    value5 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{10, value5}, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                if (DataCanbus.DATA[146] == 0) {
                    value4 = 1;
                } else {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{15, value4}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                if (DataCanbus.DATA[139] == 0) {
                    value7 = 1;
                } else {
                    value7 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{8, value7}, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                if (DataCanbus.DATA[138] == 0) {
                    value6 = 1;
                } else {
                    value6 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{9, value6}, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                if (DataCanbus.DATA[147] == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{14, value3}, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                DataCanbus.PROXY.cmd(1, new int[]{16, 1}, null, null);
                break;
        }
    }
}
