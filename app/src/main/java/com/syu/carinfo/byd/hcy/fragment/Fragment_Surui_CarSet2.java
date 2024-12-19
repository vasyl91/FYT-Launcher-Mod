package com.syu.carinfo.byd.hcy.fragment;

import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseFragment;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Fragment_Surui_CarSet2 extends BaseFragment implements View.OnClickListener {
    int[] ids = {54, 55, 56, 57, 58};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.byd.hcy.fragment.Fragment_Surui_CarSet2.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 54:
                    Fragment_Surui_CarSet2.this.updateSteering(value);
                    break;
                case 55:
                    Fragment_Surui_CarSet2.this.updateEnergyback(value);
                    break;
                case 56:
                    Fragment_Surui_CarSet2.this.updateChargingPort(value);
                    break;
                case 58:
                    Fragment_Surui_CarSet2.this.updateSOCValue(value);
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
    }

    @Override // com.syu.canbus.BaseFragment
    public void initListener() {
    }

    @Override // com.syu.canbus.BaseFragment
    public int getViewLayout() {
        return R.layout.layout_0439_hcy_byds7_carset2;
    }

    @Override // com.syu.canbus.BaseFragment
    public void addNotify() {
        if (DataCanbus.sCanbusId == 8782263) {
            DataCanbus.PROXY.cmd(5, 16);
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
        if (DataCanbus.sCanbusId == 8782263) {
            int value = 0;
            switch (v.getId()) {
                case R.id.btn_minus1 /* 2131427480 */:
                    value = 5;
                    break;
                case R.id.btn_plus1 /* 2131427482 */:
                    value = 6;
                    break;
                case R.id.btn_minus2 /* 2131427484 */:
                    value = 3;
                    break;
                case R.id.btn_plus2 /* 2131427486 */:
                    value = 4;
                    break;
                case R.id.btn_minus3 /* 2131427488 */:
                    value = 1;
                    break;
                case R.id.btn_plus3 /* 2131427490 */:
                    value = 2;
                    break;
                case R.id.btn_minus4 /* 2131427492 */:
                    int data = DataCanbus.DATA[58];
                    if (data > 25) {
                        data--;
                    }
                    DataCanbus.PROXY.cmd(4, data);
                    break;
                case R.id.btn_plus4 /* 2131427494 */:
                    int data2 = DataCanbus.DATA[58];
                    if (data2 < 70) {
                        data2++;
                    }
                    DataCanbus.PROXY.cmd(4, data2);
                    break;
            }
            if (value != 0) {
                DataCanbus.PROXY.cmd(1, value);
                return;
            }
            return;
        }
        int sendvalue = DataCanbus.DATA[57];
        int SOCvalue = DataCanbus.DATA[58];
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427480 */:
                if (((DataCanbus.DATA[57] >> 1) & 1) == 1) {
                    sendvalue = DataCanbus.DATA[57] & 253;
                    break;
                } else {
                    sendvalue = DataCanbus.DATA[57] | 2;
                    break;
                }
            case R.id.btn_plus1 /* 2131427482 */:
                if (((DataCanbus.DATA[57] >> 1) & 1) == 1) {
                    sendvalue = DataCanbus.DATA[57] & 253;
                    break;
                } else {
                    sendvalue = DataCanbus.DATA[57] | 2;
                    break;
                }
            case R.id.btn_minus2 /* 2131427484 */:
                if (((DataCanbus.DATA[57] >> 2) & 1) == 1) {
                    sendvalue = DataCanbus.DATA[57] & 251;
                    break;
                } else {
                    sendvalue = DataCanbus.DATA[57] | 4;
                    break;
                }
            case R.id.btn_plus2 /* 2131427486 */:
                if (((DataCanbus.DATA[57] >> 2) & 1) == 1) {
                    sendvalue = DataCanbus.DATA[57] & 251;
                    break;
                } else {
                    sendvalue = DataCanbus.DATA[57] | 4;
                    break;
                }
            case R.id.btn_minus3 /* 2131427488 */:
                if (((DataCanbus.DATA[57] >> 3) & 1) == 1) {
                    sendvalue = DataCanbus.DATA[57] & 247;
                    break;
                } else {
                    sendvalue = DataCanbus.DATA[57] | 8;
                    break;
                }
            case R.id.btn_plus3 /* 2131427490 */:
                if (((DataCanbus.DATA[57] >> 3) & 1) == 1) {
                    sendvalue = DataCanbus.DATA[57] & 247;
                    break;
                } else {
                    sendvalue = DataCanbus.DATA[57] | 8;
                    break;
                }
            case R.id.btn_minus4 /* 2131427492 */:
                SOCvalue = DataCanbus.DATA[58] - 5;
                if (SOCvalue < 15) {
                    SOCvalue = 15;
                    break;
                }
            case R.id.btn_plus4 /* 2131427494 */:
                SOCvalue = DataCanbus.DATA[58] + 5;
                if (SOCvalue > 70) {
                    SOCvalue = 70;
                    break;
                }
        }
        DataCanbus.PROXY.cmd(4, new int[]{sendvalue, SOCvalue}, null, null);
    }

    protected void updateSteering(int value) {
        if (((TextView) findView(R.id.tv_text1)) != null) {
            if (DataCanbus.sCanbusId == 8782263) {
                switch (value) {
                    case 0:
                        ((TextView) findView(R.id.tv_text1)).setText(R.string.str_driving_comfort);
                        break;
                    case 1:
                        ((TextView) findView(R.id.tv_text1)).setText(R.string.str_driving_sport);
                        break;
                }
            }
            switch (value) {
                case 0:
                    ((TextView) findView(R.id.tv_text1)).setText(R.string.str_driving_sport);
                    break;
                case 1:
                    ((TextView) findView(R.id.tv_text1)).setText(R.string.str_driving_comfort);
                    break;
            }
        }
    }

    protected void updateEnergyback(int value) {
        if (((TextView) findView(R.id.tv_text2)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findView(R.id.tv_text2)).setText(R.string.str_standard_feedback);
                    break;
                case 1:
                    ((TextView) findView(R.id.tv_text2)).setText(R.string.str_larger_feedback);
                    break;
            }
        }
    }

    protected void updateChargingPort(int value) {
        if (((TextView) findView(R.id.tv_text3)) != null) {
            if (DataCanbus.sCanbusId == 8782263) {
                switch (value) {
                    case 0:
                        ((TextView) findView(R.id.tv_text3)).setText(R.string.str_stop_anti_theft);
                        break;
                    case 1:
                        ((TextView) findView(R.id.tv_text3)).setText(R.string.str_anti_theft);
                        break;
                }
            }
            switch (value) {
                case 0:
                    ((TextView) findView(R.id.tv_text3)).setText(R.string.str_anti_theft);
                    break;
                case 1:
                    ((TextView) findView(R.id.tv_text3)).setText(R.string.str_stop_anti_theft);
                    break;
            }
        }
    }

    protected void updateSOCValue(int value) {
        if (((TextView) findView(R.id.tv_text4)) != null) {
            ((TextView) findView(R.id.tv_text4)).setText(String.valueOf(value) + "%");
        }
    }
}
