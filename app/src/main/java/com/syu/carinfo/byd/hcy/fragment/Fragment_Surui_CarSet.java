package com.syu.carinfo.byd.hcy.fragment;

import android.view.View;
import android.widget.CheckedTextView;

import com.syu.canbus.BaseFragment;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Fragment_Surui_CarSet extends BaseFragment implements View.OnClickListener {
    int iPressDownvalue;
    int iPressUpvalue;
    int iRemoteDownvalue;
    int iRemoteUpvalue;
    int[] ids = {107, 108, 109, 110};
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        int value;

        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            this.value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 107:
                    Fragment_Surui_CarSet.this.uRemoteUp(this.value);
                    break;
                case 108:
                    Fragment_Surui_CarSet.this.uRemoteDown(this.value);
                    break;
                case 109:
                    Fragment_Surui_CarSet.this.uLongPressUp(this.value);
                    break;
                case 110:
                    Fragment_Surui_CarSet.this.uLongPressDown(this.value);
                    break;
                case 116:
                    Fragment_Surui_CarSet.this.recvalue = this.value;
                    break;
            }
        }
    };
    int sendvalue = 0;
    int recvalue = 0;

    @Override
    public void initView() {
        bindViewOnClick(R.id.ctv_checkedtext1, this);
        bindViewOnClick(R.id.ctv_checkedtext2, this);
        bindViewOnClick(R.id.ctv_checkedtext3, this);
        bindViewOnClick(R.id.ctv_checkedtext4, this);
    }

    @Override
    public void initListener() {
    }

    @Override
    public int getViewLayout() {
        return R.layout.layout_0178_hcy_surui_carset;
    }

    @Override
    public void addNotify() {
        if (DataCanbus.sCanbusId == 8782263) {
            DataCanbus.PROXY.cmd(5, 16);
        } else if (DataCanbus.sCanbusId == 9699767 || DataCanbus.sCanbusId == 9765303 || DataCanbus.sCanbusId == 9830839 || DataCanbus.sCanbusId == 9896375 || DataCanbus.sCanbusId == 9961911 || DataCanbus.sCanbusId == 10027447 || DataCanbus.sCanbusId == 10092983) {
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
        if (DataCanbus.sCanbusId == 8782263) {
            int value5 = 0;
            switch (v.getId()) {
                case R.id.ctv_checkedtext1 /* 2131427525 */:
                    if (DataCanbus.DATA[107] == 0) {
                        value5 = 7;
                        break;
                    } else {
                        value5 = 8;
                        break;
                    }
                case R.id.ctv_checkedtext2 /* 2131427541 */:
                    if (DataCanbus.DATA[108] == 0) {
                        value5 = 9;
                        break;
                    } else {
                        value5 = 10;
                        break;
                    }
                case R.id.ctv_checkedtext3 /* 2131427542 */:
                    if (DataCanbus.DATA[109] == 0) {
                        value5 = 11;
                        break;
                    } else {
                        value5 = 12;
                        break;
                    }
                case R.id.ctv_checkedtext4 /* 2131427544 */:
                    if (DataCanbus.DATA[110] == 0) {
                        value5 = 13;
                        break;
                    } else {
                        value5 = 14;
                        break;
                    }
            }
            if (value5 != 0) {
                DataCanbus.PROXY.cmd(1, value5);
                return;
            }
            return;
        }
        if (DataCanbus.sCanbusId == 9699767 || DataCanbus.sCanbusId == 9765303 || DataCanbus.sCanbusId == 9830839 || DataCanbus.sCanbusId == 9896375 || DataCanbus.sCanbusId == 9961911 || DataCanbus.sCanbusId == 10027447 || DataCanbus.sCanbusId == 10092983) {
            switch (v.getId()) {
                case R.id.ctv_checkedtext1 /* 2131427525 */:
                    if (DataCanbus.DATA[107] == 0) {
                        value4 = 1;
                    } else {
                        value4 = 0;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{3, value4}, null, null);
                    break;
                case R.id.ctv_checkedtext2 /* 2131427541 */:
                    if (DataCanbus.DATA[108] == 0) {
                        value3 = 1;
                    } else {
                        value3 = 0;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{4, value3}, null, null);
                    break;
                case R.id.ctv_checkedtext3 /* 2131427542 */:
                    if (DataCanbus.DATA[109] == 0) {
                        value2 = 1;
                    } else {
                        value2 = 0;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{5, value2}, null, null);
                    break;
                case R.id.ctv_checkedtext4 /* 2131427544 */:
                    if (DataCanbus.DATA[110] == 0) {
                        value = 1;
                    } else {
                        value = 0;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{6, value}, null, null);
                    break;
            }
            return;
        }
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                if (((this.recvalue >> 7) & 1) == 1) {
                    this.sendvalue = this.recvalue & 127;
                    break;
                } else {
                    this.sendvalue = this.recvalue | 128;
                    break;
                }
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                if (((this.recvalue >> 6) & 1) == 1) {
                    this.sendvalue = this.recvalue & 191;
                    break;
                } else {
                    this.sendvalue = this.recvalue | 64;
                    break;
                }
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                if (((this.recvalue >> 3) & 1) == 1) {
                    this.sendvalue = this.recvalue & 247;
                    break;
                } else {
                    this.sendvalue = this.recvalue | 8;
                    break;
                }
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                if (((this.recvalue >> 2) & 1) == 1) {
                    this.sendvalue = this.recvalue & 251;
                    break;
                } else {
                    this.sendvalue = this.recvalue | 4;
                    break;
                }
        }
        sendCmd();
    }

    private void sendCmd() {
        int val = this.sendvalue;
        DataCanbus.PROXY.cmd(1, val);
    }

    protected void uLongPressDown(int value) {
        setCheck((CheckedTextView) findView(R.id.ctv_checkedtext4), value != 0);
    }

    protected void uLongPressUp(int value) {
        setCheck((CheckedTextView) findView(R.id.ctv_checkedtext3), value != 0);
    }

    protected void uRemoteDown(int value) {
        setCheck((CheckedTextView) findView(R.id.ctv_checkedtext2), value != 0);
    }

    protected void uRemoteUp(int value) {
        setCheck((CheckedTextView) findView(R.id.ctv_checkedtext1), value != 0);
    }
}
