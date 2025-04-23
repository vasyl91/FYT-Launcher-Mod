package com.syu.carinfo.byd.hcy.fragment;

import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseFragment;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Fragment_Driving_CarSet_RCW_S7 extends BaseFragment implements View.OnClickListener {
    int[] ids = {142, 143, 144, 145};
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
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
                case 143:
                    switch (value) {
                        case 0:
                            ((TextView) Fragment_Driving_CarSet_RCW_S7.this.findView(R.id.tv_text2)).setText(R.string.str_standard_feedback);
                            break;
                        case 1:
                            ((TextView) Fragment_Driving_CarSet_RCW_S7.this.findView(R.id.tv_text2)).setText(R.string.str_larger_feedback);
                            break;
                    }
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
                case 145:
                    ((TextView) Fragment_Driving_CarSet_RCW_S7.this.findView(R.id.tv_text4)).setText(String.valueOf(value) + "%");
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
    }

    @Override
    public void initListener() {
    }

    @Override
    public int getViewLayout() {
        return R.layout.layout_0439_byds7_driving_carset;
    }

    @Override
    public void addNotify() {
        if (DataCanbus.sCanbusId == 9699767 || DataCanbus.sCanbusId == 9765303 || DataCanbus.sCanbusId == 9830839 || DataCanbus.sCanbusId == 9896375 || DataCanbus.sCanbusId == 9961911 || DataCanbus.sCanbusId == 10027447 || DataCanbus.sCanbusId == 10092983) {
            RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
            int[] iArr = new int[4];
            iArr[0] = 43;
            remoteModuleProxy.cmd(2, iArr, null, null);
        }
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
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
            case R.id.btn_plus1 /* 2131427457 */:
                if (DataCanbus.DATA[142] == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(6, new int[]{3, value2}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
            case R.id.btn_plus2 /* 2131427460 */:
                if (DataCanbus.DATA[143] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(6, new int[]{2, value}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value3 = DataCanbus.DATA[144] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                DataCanbus.PROXY.cmd(6, new int[]{1, value3}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value4 = DataCanbus.DATA[144] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(6, new int[]{1, value4}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value5 = DataCanbus.DATA[145] - 5;
                if (value5 < 15) {
                    value5 = 15;
                } else if (value5 > 70) {
                    value5 = 70;
                }
                DataCanbus.PROXY.cmd(6, new int[]{4, value5}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value6 = DataCanbus.DATA[145] + 5;
                if (value6 > 70) {
                    value6 = 70;
                } else if (value6 < 15) {
                    value6 = 15;
                }
                DataCanbus.PROXY.cmd(6, new int[]{4, value6}, null, null);
                break;
        }
    }
}
