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
public class Fragment_Driving_CarSet_RCW_S7 extends BaseFragment implements View.OnClickListener {
    int[] ids = {142, 143, 144, 145, 150, 151};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.byd.hcy.fragment.Fragment_Driving_CarSet_RCW_S7.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 142:
                    switch (value) {
                        case 0:
                            ((TextView) Fragment_Driving_CarSet_RCW_S7.this.findView(R.id.tv_text1)).setText(R.string.str_anti_theft);
                            break;
                        case 1:
                            ((TextView) Fragment_Driving_CarSet_RCW_S7.this.findView(R.id.tv_text1)).setText(R.string.str_stop_anti_theft);
                            break;
                    }
                    break;
                case 143:
                    switch (value) {
                        case 0:
                            ((TextView) Fragment_Driving_CarSet_RCW_S7.this.findView(R.id.tv_text2)).setText(R.string.str_standard_feedback);
                            break;
                        case 1:
                            ((TextView) Fragment_Driving_CarSet_RCW_S7.this.findView(R.id.tv_text2)).setText(R.string.str_larger_feedback);
                            break;
                    }
                    break;
                case 144:
                    switch (value) {
                        case 0:
                            ((TextView) Fragment_Driving_CarSet_RCW_S7.this.findView(R.id.tv_text3)).setText(R.string.jeep_playstate11);
                            break;
                        case 1:
                            ((TextView) Fragment_Driving_CarSet_RCW_S7.this.findView(R.id.tv_text3)).setText(R.string.str_driving_comfort);
                            break;
                        case 2:
                            ((TextView) Fragment_Driving_CarSet_RCW_S7.this.findView(R.id.tv_text3)).setText(R.string.wc_golf_normal);
                            break;
                        case 3:
                            ((TextView) Fragment_Driving_CarSet_RCW_S7.this.findView(R.id.tv_text3)).setText(R.string.str_driving_sport);
                            break;
                    }
                    break;
                case 145:
                    ((TextView) Fragment_Driving_CarSet_RCW_S7.this.findView(R.id.tv_text4)).setText(String.valueOf(value) + "%");
                    break;
                case 150:
                    Fragment_Driving_CarSet_RCW_S7.this.setCheck((CheckedTextView) Fragment_Driving_CarSet_RCW_S7.this.findView(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 151:
                    switch (value) {
                        case 0:
                            ((TextView) Fragment_Driving_CarSet_RCW_S7.this.findView(R.id.tv_text5)).setText(R.string.jeep_playstate11);
                            break;
                        case 1:
                            ((TextView) Fragment_Driving_CarSet_RCW_S7.this.findView(R.id.tv_text5)).setText(R.string.str_driving_comfort);
                            break;
                        case 2:
                            ((TextView) Fragment_Driving_CarSet_RCW_S7.this.findView(R.id.tv_text5)).setText(R.string.wc_golf_normal);
                            break;
                    }
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
        bindViewOnClick(R.id.ctv_checkedtext1, this);
    }

    @Override // com.syu.canbus.BaseFragment
    public void initListener() {
    }

    @Override // com.syu.canbus.BaseFragment
    public int getViewLayout() {
        return R.layout.layout_0439_byds7_driving_carset;
    }

    @Override // com.syu.canbus.BaseFragment
    public void addNotify() {
        RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
        int[] iArr = new int[4];
        iArr[0] = 43;
        remoteModuleProxy.cmd(2, iArr, null, null);
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
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
            case R.id.btn_plus1 /* 2131427458 */:
                if (DataCanbus.DATA[142] == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(6, new int[]{3, value2}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
            case R.id.btn_plus2 /* 2131427461 */:
                if (DataCanbus.DATA[143] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(6, new int[]{2, value}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value4 = DataCanbus.DATA[144] - 1;
                if (value4 < 0) {
                    value4 = 3;
                }
                DataCanbus.PROXY.cmd(6, new int[]{1, value4}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value5 = DataCanbus.DATA[144] + 1;
                if (value5 > 3) {
                    value5 = 0;
                }
                DataCanbus.PROXY.cmd(6, new int[]{1, value5}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value6 = DataCanbus.DATA[145] - 5;
                if (value6 < 15) {
                    value6 = 15;
                } else if (value6 > 70) {
                    value6 = 70;
                }
                DataCanbus.PROXY.cmd(6, new int[]{4, value6}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value7 = DataCanbus.DATA[145] + 5;
                if (value7 > 70) {
                    value7 = 70;
                } else if (value7 < 15) {
                    value7 = 15;
                }
                DataCanbus.PROXY.cmd(6, new int[]{4, value7}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value8 = DataCanbus.DATA[151] - 1;
                if (value8 < 0) {
                    value8 = 2;
                }
                DataCanbus.PROXY.cmd(6, new int[]{6, value8}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value9 = DataCanbus.DATA[151] + 1;
                if (value9 > 2) {
                    value9 = 0;
                }
                DataCanbus.PROXY.cmd(6, new int[]{6, value9}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                if (DataCanbus.DATA[150] == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                DataCanbus.PROXY.cmd(6, new int[]{5, value3}, null, null);
                break;
        }
    }
}
