package com.syu.carinfo.byd.hcy.fragment;

import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseFragment;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Fragment_Surui_Pm25 extends BaseFragment implements View.OnClickListener {
    private int detectin;
    private int detectout;
    private int inmainshow;
    private int intime;
    private int invalue;
    private int opendoor;
    private int openwindow;
    private int poweron;
    int[] ids = {113, 114, 105, 101, 102, 103, 104};
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 101:
                    Fragment_Surui_Pm25.this.uCarIn(value);
                    break;
                case 102:
                    Fragment_Surui_Pm25.this.uCarOut(value);
                    break;
                case 103:
                    Fragment_Surui_Pm25.this.uLevelIn(value);
                    break;
                case 104:
                    Fragment_Surui_Pm25.this.uLevelOut(value);
                    break;
                case 105:
                    Fragment_Surui_Pm25.this.uState(value);
                    break;
                case 113:
                    Fragment_Surui_Pm25.this.uPMDectectIn(value);
                    break;
                case 114:
                    Fragment_Surui_Pm25.this.uPMDectectOut(value);
                    break;
            }
        }
    };
    int[] resid = {R.string.rzc_c4l_close, R.string.rzc_c4l_open};
    private int[] strIdPM = {R.string.str_265_2, R.string.str_265_3, R.string.str_265_4, R.string.str_265_5, R.string.str_265_6, R.string.str_265_7};

    @Override
    public void initView() {
    }

    @Override
    public int getViewLayout() {
        return R.layout.layout_0178_hcy_surui_pm25;
    }

    @Override
    public void addNotify() {
        if (DataCanbus.DATA[1000] == 8782263) {
            DataCanbus.PROXY.cmd(5, 3);
            DataCanbus.PROXY.cmd(5, 14);
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

    protected void uLevelIn(int value) {
        uPmValue((TextView) findView(R.id.id_pm_inside_type), value);
    }

    protected void uPMDectectOut(int value) {
        this.detectout = value;
        setText((TextView) bindViewOnClick(R.id.id_detectout, this), value);
    }

    protected void uPMDectectIn(int value) {
        this.detectin = value;
        setText((TextView) bindViewOnClick(R.id.id_detectin, this), value);
    }

    protected void uLevelOut(int value) {
        uPmValue((TextView) findView(R.id.id_pm_outside_type), value);
    }

    protected void uCarOut(int value) {
        if (((TextView) findView(R.id.id_pm_outside)) != null) {
            ((TextView) findView(R.id.id_pm_outside)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    protected void uCarIn(int value) {
        if (((TextView) findView(R.id.id_pm_inside)) != null) {
            ((TextView) findView(R.id.id_pm_inside)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    protected void uState(int value) {
        if (DataCanbus.DATA[1000] == 8782263) {
            this.poweron = (value >> 0) & 1;
            this.opendoor = (value >> 1) & 1;
            this.intime = (value >> 2) & 1;
        } else if (DataCanbus.DATA[1000] == 9699767 || DataCanbus.DATA[1000] == 9765303 || DataCanbus.DATA[1000] == 9830839 || DataCanbus.DATA[1000] == 9896375 || DataCanbus.DATA[1000] == 9961911 || DataCanbus.DATA[1000] == 10027447 || DataCanbus.DATA[1000] == 10092983) {
            this.poweron = (value >> 7) & 1;
            this.opendoor = (value >> 5) & 1;
            this.intime = (value >> 4) & 1;
        } else {
            this.poweron = (value >> 7) & 1;
            this.openwindow = (value >> 6) & 1;
            this.opendoor = (value >> 5) & 1;
            this.intime = (value >> 4) & 1;
            this.invalue = (value >> 2) & 3;
            this.inmainshow = (value >> 0) & 3;
        }
        setText((TextView) bindViewOnClick(R.id.id_poweron, this), this.poweron);
        setText((TextView) bindViewOnClick(R.id.id_openwindow, this), this.openwindow);
        setText((TextView) bindViewOnClick(R.id.id_opendoor, this), this.opendoor);
        setText((TextView) bindViewOnClick(R.id.id_intime, this), this.intime);
    }

    void setText(TextView v, String str) {
        if (v != null) {
            v.setText(str);
        }
    }

    void setText(TextView v, int id) {
        if (v != null && id < this.resid.length) {
            v.setText(this.resid[id]);
            v.setBackgroundResource(id == 0 ? R.drawable.ic_sbd_kelu_ok : R.drawable.ic_sbd_play_text);
        }
    }

    private void uPmValue(TextView tv, int val) {
        int strid = -1;
        switch (val) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                strid = this.strIdPM[val - 1];
                break;
        }
        if (tv != null) {
            if (strid > -1) {
                tv.setVisibility(0);
                int txtClr = 0;
                int txtBackgroudClr = 0;
                switch (val) {
                    case 1:
                        txtClr = R.color.white;
                        txtBackgroudClr = R.color.green;
                        break;
                    case 2:
                        txtClr = R.color.black2;
                        txtBackgroudClr = R.color.yellow;
                        break;
                    case 3:
                        txtClr = R.color.black2;
                        txtBackgroudClr = R.color.orange;
                        break;
                    case 4:
                        txtClr = R.color.white;
                        txtBackgroudClr = R.color.red;
                        break;
                    case 5:
                        txtClr = R.color.white;
                        txtBackgroudClr = R.color.purple;
                        break;
                    case 6:
                        txtClr = R.color.white;
                        txtBackgroudClr = R.color.saddlebrown;
                        break;
                }
                tv.setTextColor(getResources().getColor(txtClr));
                tv.setBackgroundColor(getResources().getColor(txtBackgroudClr));
                tv.setText(strid);
                return;
            }
            tv.setVisibility(4);
        }
    }

    @Override
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        int value5;
        if (DataCanbus.DATA[1000] == 8782263) {
            int value6 = 0;
            switch (v.getId()) {
                case R.id.id_poweron /* 2131427601 */:
                    if (this.poweron == 0) {
                        value6 = 10;
                        break;
                    } else {
                        value6 = 11;
                        break;
                    }
                case R.id.id_opendoor /* 2131427603 */:
                    if (this.opendoor == 0) {
                        value6 = 12;
                        break;
                    } else {
                        value6 = 13;
                        break;
                    }
                case R.id.id_intime /* 2131427604 */:
                    if (this.intime == 0) {
                        value6 = 14;
                        break;
                    } else {
                        value6 = 15;
                        break;
                    }
            }
            if (value6 != 0) {
                DataCanbus.PROXY.cmd(3, value6);
                return;
            }
            return;
        }
        if (DataCanbus.DATA[1000] == 12976567 || DataCanbus.DATA[1000] == 15663558) {
            int value7 = 0;
            switch (v.getId()) {
                case R.id.id_poweron /* 2131427601 */:
                    value7 = 3;
                    break;
                case R.id.id_opendoor /* 2131427603 */:
                    value7 = 4;
                    break;
                case R.id.id_intime /* 2131427604 */:
                    value7 = 5;
                    break;
                case R.id.id_detectin /* 2131427605 */:
                    value7 = 1;
                    break;
                case R.id.id_detectout /* 2131427606 */:
                    value7 = 2;
                    break;
            }
            if (value7 != 0) {
                DataCanbus.PROXY.cmd(6, value7);
                return;
            }
            return;
        }
        if (DataCanbus.DATA[1000] == 9699767 || DataCanbus.DATA[1000] == 9765303 || DataCanbus.DATA[1000] == 9830839 || DataCanbus.DATA[1000] == 9896375 || DataCanbus.DATA[1000] == 9961911 || DataCanbus.DATA[1000] == 10027447 || DataCanbus.DATA[1000] == 10092983) {
            switch (v.getId()) {
                case R.id.id_poweron /* 2131427601 */:
                    if (this.poweron == 0) {
                        value5 = 1;
                    } else {
                        value5 = 0;
                    }
                    DataCanbus.PROXY.cmd(3, new int[]{3, value5}, null, null);
                    break;
                case R.id.id_opendoor /* 2131427603 */:
                    if (this.opendoor == 0) {
                        value3 = 1;
                    } else {
                        value3 = 0;
                    }
                    DataCanbus.PROXY.cmd(3, new int[]{4, value3}, null, null);
                    break;
                case R.id.id_intime /* 2131427604 */:
                    if (this.intime == 0) {
                        value4 = 1;
                    } else {
                        value4 = 0;
                    }
                    DataCanbus.PROXY.cmd(3, new int[]{5, value4}, null, null);
                    break;
                case R.id.id_detectin /* 2131427605 */:
                    if (this.detectin == 0) {
                        value2 = 1;
                    } else {
                        value2 = 0;
                    }
                    DataCanbus.PROXY.cmd(3, new int[]{1, value2}, null, null);
                    break;
                case R.id.id_detectout /* 2131427606 */:
                    if (this.detectout == 0) {
                        value = 1;
                    } else {
                        value = 0;
                    }
                    DataCanbus.PROXY.cmd(3, new int[]{2, value}, null, null);
                    break;
            }
            return;
        }
        int ipoweron = 0;
        int iopendoor = 0;
        int iintime = 0;
        int idetectin = 0;
        int idetectout = 0;
        switch (v.getId()) {
            case R.id.id_poweron /* 2131427601 */:
                ipoweron = (this.poweron + 1) % 2;
                break;
            case R.id.id_opendoor /* 2131427603 */:
                iopendoor = (this.opendoor + 1) % 2;
                break;
            case R.id.id_intime /* 2131427604 */:
                iintime = (this.intime + 1) % 2;
                break;
            case R.id.id_detectin /* 2131427605 */:
                idetectin = (this.detectin + 1) % 2;
                break;
            case R.id.id_detectout /* 2131427606 */:
                idetectout = (this.detectout + 1) % 2;
                break;
        }
        sendCmd(iopendoor, iintime, idetectout, idetectin, ipoweron);
    }

    private void sendCmd(int opendoor, int intime, int detectout, int detectin, int poweron) {
        int val = ((intime & 1) << 3) | ((opendoor & 1) << 4) | ((poweron & 1) << 5) | ((detectout & 1) << 6) | ((detectin & 1) << 7);
        DataCanbus.PROXY.cmd(3, val);
    }
}
