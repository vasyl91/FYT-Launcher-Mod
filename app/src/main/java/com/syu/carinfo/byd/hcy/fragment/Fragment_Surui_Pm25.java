package com.syu.carinfo.byd.hcy.fragment;

import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseFragment;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Fragment_Surui_Pm25 extends BaseFragment implements View.OnClickListener {
    private int detectin;
    private int detectout;
    private int inmainshow;
    private int intime;
    private int invalue;
    private int opendoor;
    private int openwindow;
    private int poweron;
    int[] ids = {49, 50, 48, 28, 29, 30, 31};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.byd.hcy.fragment.Fragment_Surui_Pm25.1
        int value;

        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            this.value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 28:
                    Fragment_Surui_Pm25.this.uCarIn(this.value);
                    break;
                case 29:
                    Fragment_Surui_Pm25.this.uCarOut(this.value);
                    break;
                case 30:
                    Fragment_Surui_Pm25.this.uLevelIn(this.value);
                    break;
                case 31:
                    Fragment_Surui_Pm25.this.uLevelOut(this.value);
                    break;
                case 48:
                    Fragment_Surui_Pm25.this.uState(this.value);
                    break;
                case 49:
                    Fragment_Surui_Pm25.this.uPMDectectIn(this.value);
                    break;
                case 50:
                    Fragment_Surui_Pm25.this.uPMDectectOut(this.value);
                    break;
            }
        }
    };
    int[] resid = {R.string.rzc_c4l_close, R.string.rzc_c4l_open};
    private int[] strIdPM = {R.string.str_265_2, R.string.str_265_3, R.string.str_265_4, R.string.str_265_5, R.string.str_265_6, R.string.str_265_7};

    @Override // com.syu.canbus.BaseFragment
    public void initView() {
    }

    @Override // com.syu.canbus.BaseFragment
    public int getViewLayout() {
        return R.layout.layout_0178_hcy_surui_pm25;
    }

    @Override // com.syu.canbus.BaseFragment
    public void addNotify() {
        if (DataCanbus.sCanbusId == 8782263) {
            DataCanbus.PROXY.cmd(5, 3);
            DataCanbus.PROXY.cmd(5, 14);
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
        if (DataCanbus.sCanbusId == 8782263) {
            this.poweron = (value >> 0) & 1;
            this.opendoor = (value >> 1) & 1;
            this.intime = (value >> 2) & 1;
        } else if (DataCanbus.sCanbusId == 9699767 || DataCanbus.sCanbusId == 9765303 || DataCanbus.sCanbusId == 9830839 || DataCanbus.sCanbusId == 9896375 || DataCanbus.sCanbusId == 9961911 || DataCanbus.sCanbusId == 10027447 || DataCanbus.sCanbusId == 10092983) {
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        int value5;
        if (DataCanbus.sCanbusId == 8782263) {
            int value6 = 0;
            switch (v.getId()) {
                case R.id.id_poweron /* 2131427589 */:
                    if (this.poweron == 0) {
                        value6 = 10;
                        break;
                    } else {
                        value6 = 11;
                        break;
                    }
                case R.id.id_opendoor /* 2131427591 */:
                    if (this.opendoor == 0) {
                        value6 = 12;
                        break;
                    } else {
                        value6 = 13;
                        break;
                    }
                case R.id.id_intime /* 2131427592 */:
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
        if (DataCanbus.sCanbusId == 12976567) {
            int value7 = 0;
            switch (v.getId()) {
                case R.id.id_poweron /* 2131427589 */:
                    value7 = 3;
                    break;
                case R.id.id_opendoor /* 2131427591 */:
                    value7 = 4;
                    break;
                case R.id.id_intime /* 2131427592 */:
                    value7 = 5;
                    break;
                case R.id.id_detectin /* 2131427593 */:
                    value7 = 1;
                    break;
                case R.id.id_detectout /* 2131427594 */:
                    value7 = 2;
                    break;
            }
            if (value7 != 0) {
                DataCanbus.PROXY.cmd(6, value7);
                return;
            }
            return;
        }
        if (DataCanbus.sCanbusId == 9699767 || DataCanbus.sCanbusId == 9765303 || DataCanbus.sCanbusId == 9830839 || DataCanbus.sCanbusId == 9896375 || DataCanbus.sCanbusId == 9961911 || DataCanbus.sCanbusId == 10027447 || DataCanbus.sCanbusId == 10092983) {
            switch (v.getId()) {
                case R.id.id_poweron /* 2131427589 */:
                    if (this.poweron == 0) {
                        value5 = 1;
                    } else {
                        value5 = 0;
                    }
                    DataCanbus.PROXY.cmd(3, new int[]{3, value5}, null, null);
                    break;
                case R.id.id_opendoor /* 2131427591 */:
                    if (this.opendoor == 0) {
                        value3 = 1;
                    } else {
                        value3 = 0;
                    }
                    DataCanbus.PROXY.cmd(3, new int[]{4, value3}, null, null);
                    break;
                case R.id.id_intime /* 2131427592 */:
                    if (this.intime == 0) {
                        value4 = 1;
                    } else {
                        value4 = 0;
                    }
                    DataCanbus.PROXY.cmd(3, new int[]{5, value4}, null, null);
                    break;
                case R.id.id_detectin /* 2131427593 */:
                    if (this.detectin == 0) {
                        value2 = 1;
                    } else {
                        value2 = 0;
                    }
                    DataCanbus.PROXY.cmd(3, new int[]{1, value2}, null, null);
                    break;
                case R.id.id_detectout /* 2131427594 */:
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
            case R.id.id_poweron /* 2131427589 */:
                ipoweron = (this.poweron + 1) % 2;
                break;
            case R.id.id_opendoor /* 2131427591 */:
                iopendoor = (this.opendoor + 1) % 2;
                break;
            case R.id.id_intime /* 2131427592 */:
                iintime = (this.intime + 1) % 2;
                break;
            case R.id.id_detectin /* 2131427593 */:
                idetectin = (this.detectin + 1) % 2;
                break;
            case R.id.id_detectout /* 2131427594 */:
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
