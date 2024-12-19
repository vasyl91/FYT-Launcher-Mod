package com.syu.carinfo.byd.hcy.fragment;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseFragment;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Fragment_Surui_CarSet_RCW_S7 extends BaseFragment implements View.OnClickListener {
    int[] ids = {73, 74, 75, 76, 77, 78, 79, 107, 108};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.byd.hcy.fragment.Fragment_Surui_CarSet_RCW_S7.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 73:
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
                case 74:
                    switch (value) {
                        case 0:
                            ((TextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.tv_text1)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
                            break;
                        case 1:
                            ((TextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.tv_text1)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
                            break;
                    }
                case 75:
                    Fragment_Surui_CarSet_RCW_S7.this.setCheck((CheckedTextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.ctv_checkedtext4), value != 0);
                    break;
                case 76:
                    Fragment_Surui_CarSet_RCW_S7.this.setCheck((CheckedTextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.ctv_checkedtext3), value != 0);
                    break;
                case 77:
                    Fragment_Surui_CarSet_RCW_S7.this.setCheck((CheckedTextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.ctv_checkedtext2), value != 0);
                    break;
                case 78:
                    Fragment_Surui_CarSet_RCW_S7.this.setCheck((CheckedTextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.ctv_checkedtext1), value != 0);
                    break;
                case 79:
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
                case 107:
                    Fragment_Surui_CarSet_RCW_S7.this.setCheck((CheckedTextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.ctv_checkedtext5), value != 0);
                    break;
                case 108:
                    Fragment_Surui_CarSet_RCW_S7.this.setCheck((CheckedTextView) Fragment_Surui_CarSet_RCW_S7.this.findView(R.id.ctv_checkedtext6), value != 0);
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
        bindViewOnClick(R.id.btn_minus1, this);
        bindViewOnClick(R.id.btn_plus1, this);
        bindViewOnClick(R.id.btn_minus2, this);
        bindViewOnClick(R.id.btn_plus2, this);
        bindViewOnClick(R.id.btn_minus3, this);
        bindViewOnClick(R.id.btn_plus3, this);
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
        if (DataCanbus.sCanbusId == 9699767 || DataCanbus.sCanbusId == 9765303 || DataCanbus.sCanbusId == 9830839 || DataCanbus.sCanbusId == 9896375 || DataCanbus.sCanbusId == 9961911 || DataCanbus.sCanbusId == 10027447 || DataCanbus.sCanbusId == 10092983) {
            RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
            int[] iArr = new int[4];
            iArr[0] = 41;
            remoteModuleProxy.cmd(2, iArr, null, null);
        }
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseFragment
    public void removeNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.mNotifyCanbus);
        }
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
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
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                if (DataCanbus.DATA[78] == 0) {
                    value8 = 1;
                } else {
                    value8 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{7, value8}, null, null);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                if (DataCanbus.DATA[74] == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{11, value2}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                if (DataCanbus.DATA[74] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{11, value}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value9 = DataCanbus.DATA[73];
                if (value9 > 0) {
                    value9--;
                }
                DataCanbus.PROXY.cmd(1, new int[]{12, value9}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value10 = DataCanbus.DATA[73];
                if (value10 < 6) {
                    value10++;
                }
                DataCanbus.PROXY.cmd(1, new int[]{12, value10}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value11 = DataCanbus.DATA[79];
                if (value11 > 0) {
                    value11--;
                }
                DataCanbus.PROXY.cmd(1, new int[]{13, value11}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value12 = DataCanbus.DATA[79];
                if (value12 < 6) {
                    value12++;
                }
                DataCanbus.PROXY.cmd(1, new int[]{13, value12}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                if (DataCanbus.DATA[77] == 0) {
                    value7 = 1;
                } else {
                    value7 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{8, value7}, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                if (DataCanbus.DATA[76] == 0) {
                    value6 = 1;
                } else {
                    value6 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{9, value6}, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                if (DataCanbus.DATA[75] == 0) {
                    value5 = 1;
                } else {
                    value5 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{10, value5}, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                if (DataCanbus.DATA[107] == 0) {
                    value4 = 1;
                } else {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{15, value4}, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                if (DataCanbus.DATA[108] == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{14, value3}, null, null);
                break;
        }
    }
}
