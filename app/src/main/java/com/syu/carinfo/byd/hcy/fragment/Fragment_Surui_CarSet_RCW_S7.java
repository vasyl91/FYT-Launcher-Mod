package com.syu.carinfo.byd.hcy.fragment;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseFragment;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Fragment_Surui_CarSet_RCW_S7 extends BaseFragment implements View.OnClickListener {
    int[] ids = {135, 136, 137, 138, 139, 140, 141, 169, 170};
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
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
                case 136:
                    switch (value) {
                        case 0:
                            ((TextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.tv_text1)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
                            break;
                        case 1:
                            ((TextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.tv_text1)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
                            break;
                    }
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
                case 169:
                    Fragment_Surui_CarSet_RCW_S7.this.setCheck((CheckedTextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.ctv_checkedtext5), value != 0);
                    break;
                case 170:
                    Fragment_Surui_CarSet_RCW_S7.this.setCheck((CheckedTextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.ctv_checkedtext6), value != 0);
                    break;
            }
        }
    };

    @Override
    public void initView() {
        bindViewOnClick(R.id.ctv_checkedtext1, this);
        bindViewOnClick(R.id.ctv_checkedtext2, this);
        bindViewOnClick(R.id.ctv_checkedtext3, this);
        bindViewOnClick(R.id.ctv_checkedtext4, this);
        bindViewOnClick(R.id.ctv_checkedtext5, this);
        bindViewOnClick(R.id.ctv_checkedtext6, this);
        bindViewOnClick(R.id.btn_minus1, this);
        bindViewOnClick(R.id.btn_plus1, this);
        bindViewOnClick(R.id.btn_minus2, this);
        bindViewOnClick(R.id.btn_plus2, this);
        bindViewOnClick(R.id.btn_minus3, this);
        bindViewOnClick(R.id.btn_plus3, this);
    }

    @Override
    public void initListener() {
    }

    @Override
    public int getViewLayout() {
        return R.layout.layout_0439_byds7_carset;
    }

    @Override
    public void addNotify() {
        if (DataCanbus.DATA[1000] == 9830839) {
            findView(R.id.layout_view1).setVisibility(0);
            findView(R.id.layout_view2).setVisibility(0);
        } else {
            findView(R.id.layout_view1).setVisibility(8);
            findView(R.id.layout_view2).setVisibility(8);
        }
        if (DataCanbus.sCanbusId == 9699767 || DataCanbus.sCanbusId == 9765303 || DataCanbus.sCanbusId == 9830839 || DataCanbus.sCanbusId == 9896375 || DataCanbus.sCanbusId == 9961911 || DataCanbus.sCanbusId == 10027447 || DataCanbus.sCanbusId == 10092983) {
            RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
            int[] iArr = new int[4];
            iArr[0] = 41;
            remoteModuleProxy.cmd(2, iArr, null, null);
        }
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.mNotifyCanbus);
        }
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
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
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                if (DataCanbus.DATA[136] == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{11, value2}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                if (DataCanbus.DATA[136] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{11, value}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value9 = DataCanbus.DATA[135];
                if (value9 > 0) {
                    value9--;
                }
                DataCanbus.PROXY.cmd(1, new int[]{12, value9}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value10 = DataCanbus.DATA[135];
                if (value10 < 6) {
                    value10++;
                }
                DataCanbus.PROXY.cmd(1, new int[]{12, value10}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value11 = DataCanbus.DATA[141];
                if (value11 > 0) {
                    value11--;
                }
                DataCanbus.PROXY.cmd(1, new int[]{13, value11}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value12 = DataCanbus.DATA[141];
                if (value12 < 6) {
                    value12++;
                }
                DataCanbus.PROXY.cmd(1, new int[]{13, value12}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                if (DataCanbus.DATA[140] == 0) {
                    value8 = 1;
                } else {
                    value8 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{7, value8}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                if (DataCanbus.DATA[139] == 0) {
                    value7 = 1;
                } else {
                    value7 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{8, value7}, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                if (DataCanbus.DATA[138] == 0) {
                    value6 = 1;
                } else {
                    value6 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{9, value6}, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                if (DataCanbus.DATA[137] == 0) {
                    value5 = 1;
                } else {
                    value5 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{10, value5}, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                if (DataCanbus.DATA[169] == 0) {
                    value4 = 1;
                } else {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{15, value4}, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                if (DataCanbus.DATA[170] == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{14, value3}, null, null);
                break;
        }
    }
}
