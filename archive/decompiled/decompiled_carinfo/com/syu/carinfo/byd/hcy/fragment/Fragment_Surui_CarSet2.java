package com.syu.carinfo.byd.hcy.fragment;

import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseFragment;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Fragment_Surui_CarSet2 extends BaseFragment implements View.OnClickListener {
    int[] ids = {118, 119, 120, 121, 122};
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 118:
                    Fragment_Surui_CarSet2.this.updateSteering(value);
                    break;
                case 119:
                    Fragment_Surui_CarSet2.this.updateEnergyback(value);
                    break;
                case 120:
                    Fragment_Surui_CarSet2.this.updateChargingPort(value);
                    break;
                case 122:
                    Fragment_Surui_CarSet2.this.updateSOCValue(value);
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
        return R.layout.layout_0439_hcy_byds7_carset2;
    }

    @Override
    public void addNotify() {
        if (DataCanbus.sCanbusId == 8782263) {
            DataCanbus.PROXY.cmd(5, 16);
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
        if (DataCanbus.sCanbusId == 8782263) {
            int value = 0;
            switch (v.getId()) {
                case R.id.btn_minus1 /* 2131427455 */:
                    value = 5;
                    break;
                case R.id.btn_plus1 /* 2131427457 */:
                    value = 6;
                    break;
                case R.id.btn_minus2 /* 2131427458 */:
                    value = 3;
                    break;
                case R.id.btn_plus2 /* 2131427460 */:
                    value = 4;
                    break;
                case R.id.btn_minus3 /* 2131427461 */:
                    value = 1;
                    break;
                case R.id.btn_plus3 /* 2131427463 */:
                    value = 2;
                    break;
                case R.id.btn_minus4 /* 2131427464 */:
                    int data = DataCanbus.DATA[122];
                    if (data > 25) {
                        data--;
                    }
                    DataCanbus.PROXY.cmd(4, data);
                    break;
                case R.id.btn_plus4 /* 2131427466 */:
                    int data2 = DataCanbus.DATA[122];
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
        int sendvalue = DataCanbus.DATA[121];
        int SOCvalue = DataCanbus.DATA[122];
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                if (((DataCanbus.DATA[121] >> 1) & 1) == 1) {
                    sendvalue = DataCanbus.DATA[121] & 253;
                    break;
                } else {
                    sendvalue = DataCanbus.DATA[121] | 2;
                    break;
                }
            case R.id.btn_plus1 /* 2131427457 */:
                if (((DataCanbus.DATA[121] >> 1) & 1) == 1) {
                    sendvalue = DataCanbus.DATA[121] & 253;
                    break;
                } else {
                    sendvalue = DataCanbus.DATA[121] | 2;
                    break;
                }
            case R.id.btn_minus2 /* 2131427458 */:
                if (((DataCanbus.DATA[121] >> 2) & 1) == 1) {
                    sendvalue = DataCanbus.DATA[121] & 251;
                    break;
                } else {
                    sendvalue = DataCanbus.DATA[121] | 4;
                    break;
                }
            case R.id.btn_plus2 /* 2131427460 */:
                if (((DataCanbus.DATA[121] >> 2) & 1) == 1) {
                    sendvalue = DataCanbus.DATA[121] & 251;
                    break;
                } else {
                    sendvalue = DataCanbus.DATA[121] | 4;
                    break;
                }
            case R.id.btn_minus3 /* 2131427461 */:
                if (((DataCanbus.DATA[121] >> 3) & 1) == 1) {
                    sendvalue = DataCanbus.DATA[121] & 247;
                    break;
                } else {
                    sendvalue = DataCanbus.DATA[121] | 8;
                    break;
                }
            case R.id.btn_plus3 /* 2131427463 */:
                if (((DataCanbus.DATA[121] >> 3) & 1) == 1) {
                    sendvalue = DataCanbus.DATA[121] & 247;
                    break;
                } else {
                    sendvalue = DataCanbus.DATA[121] | 8;
                    break;
                }
            case R.id.btn_minus4 /* 2131427464 */:
                SOCvalue = DataCanbus.DATA[122] - 5;
                if (SOCvalue < 15) {
                    SOCvalue = 15;
                    break;
                }
            case R.id.btn_plus4 /* 2131427466 */:
                SOCvalue = DataCanbus.DATA[122] + 5;
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
