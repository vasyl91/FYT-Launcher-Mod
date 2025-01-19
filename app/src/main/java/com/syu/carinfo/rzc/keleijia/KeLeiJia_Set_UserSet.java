package com.syu.carinfo.rzc.keleijia;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class KeLeiJia_Set_UserSet extends BaseActivity {
    private Handler handler;
    private int[] airTempAdjString = {R.string.bsd_klj_str20, R.string.bsd_klj_str21, R.string.bsd_klj_str22};
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode] & 255;
            switch (updateCode) {
                case 56:
                    if (((TextView) KeLeiJia_Set_UserSet.this.findViewById(R.id.tv_text1)) != null && value < KeLeiJia_Set_UserSet.this.airTempAdjString.length && value > -1) {
                        ((TextView) KeLeiJia_Set_UserSet.this.findViewById(R.id.tv_text1)).setText(KeLeiJia_Set_UserSet.this.airTempAdjString[value]);
                        break;
                    }
                case 117:
                    if (((CheckedTextView) KeLeiJia_Set_UserSet.this.findViewById(R.id.ctv_checkedtext9)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_UserSet.this.findViewById(R.id.ctv_checkedtext9)).setChecked(value != 0);
                        break;
                    }
                case 118:
                    if (((CheckedTextView) KeLeiJia_Set_UserSet.this.findViewById(R.id.ctv_checkedtext10)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_UserSet.this.findViewById(R.id.ctv_checkedtext10)).setChecked(value != 0);
                        break;
                    }
                case 146:
                    if (((CheckedTextView) KeLeiJia_Set_UserSet.this.findViewById(R.id.ctv_checkedtext9)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_UserSet.this.findViewById(R.id.ctv_checkedtext9)).setChecked(value != 0);
                        break;
                    }
                case 173:
                    if (((CheckedTextView) KeLeiJia_Set_UserSet.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_UserSet.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
                        break;
                    }
                case 174:
                    if (((CheckedTextView) KeLeiJia_Set_UserSet.this.findViewById(R.id.ctv_checkedtext2)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_UserSet.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
                        break;
                    }
                case 175:
                    if (((CheckedTextView) KeLeiJia_Set_UserSet.this.findViewById(R.id.ctv_checkedtext3)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_UserSet.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
                        break;
                    }
                case 176:
                    if (((CheckedTextView) KeLeiJia_Set_UserSet.this.findViewById(R.id.ctv_checkedtext4)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_UserSet.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
                        break;
                    }
                case 177:
                    if (((CheckedTextView) KeLeiJia_Set_UserSet.this.findViewById(R.id.ctv_checkedtext5)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_UserSet.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
                        break;
                    }
                case 178:
                    if (((CheckedTextView) KeLeiJia_Set_UserSet.this.findViewById(R.id.ctv_checkedtext6)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_UserSet.this.findViewById(R.id.ctv_checkedtext6)).setChecked(value != 0);
                        break;
                    }
                case 179:
                    if (((CheckedTextView) KeLeiJia_Set_UserSet.this.findViewById(R.id.ctv_checkedtext7)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_UserSet.this.findViewById(R.id.ctv_checkedtext7)).setChecked(value != 0);
                        break;
                    }
                case 183:
                    if (((CheckedTextView) KeLeiJia_Set_UserSet.this.findViewById(R.id.ctv_checkedtext8)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_UserSet.this.findViewById(R.id.ctv_checkedtext8)).setChecked(value != 0);
                        break;
                    }
            }
        }
    };
    View.OnClickListener mClickListener = new View.OnClickListener() { 
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_minus1 /* 2131427455 */:
                    int value = DataCanbus.DATA[56] & 255;
                    int cmd = 64;
                    if (value == 0) {
                        cmd = 65;
                    } else if (value == 1) {
                        cmd = 66;
                    } else if (value == 2) {
                        cmd = 64;
                    }
                    KeLeiJia_Set_UserSet.this.sendAirCmd(cmd);
                    break;
                case R.id.btn_plus1 /* 2131427457 */:
                    int value2 = DataCanbus.DATA[56] & 255;
                    int cmd2 = 64;
                    if (value2 == 0) {
                        cmd2 = 66;
                    } else if (value2 == 1) {
                        cmd2 = 64;
                    } else if (value2 == 2) {
                        cmd2 = 65;
                    }
                    KeLeiJia_Set_UserSet.this.sendAirCmd(cmd2);
                    break;
                case R.id.ctv_checkedtext1 /* 2131427525 */:
                    int value3 = DataCanbus.DATA[173] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 43;
                    iArr[1] = value3 != 1 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                    break;
                case R.id.ctv_checkedtext2 /* 2131427541 */:
                    int value4 = DataCanbus.DATA[174] & 255;
                    RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                    int[] iArr2 = new int[2];
                    iArr2[0] = 42;
                    iArr2[1] = value4 != 1 ? 1 : 0;
                    remoteModuleProxy2.cmd(1, iArr2, null, null);
                    break;
                case R.id.ctv_checkedtext3 /* 2131427542 */:
                    int value5 = DataCanbus.DATA[175] & 255;
                    RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                    int[] iArr3 = new int[2];
                    iArr3[0] = 41;
                    iArr3[1] = value5 != 1 ? 1 : 0;
                    remoteModuleProxy3.cmd(1, iArr3, null, null);
                    break;
                case R.id.ctv_checkedtext4 /* 2131427544 */:
                    int value6 = DataCanbus.DATA[176] & 255;
                    RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                    int[] iArr4 = new int[2];
                    iArr4[0] = 40;
                    iArr4[1] = value6 != 1 ? 1 : 0;
                    remoteModuleProxy4.cmd(1, iArr4, null, null);
                    break;
                case R.id.ctv_checkedtext5 /* 2131427547 */:
                    int value7 = DataCanbus.DATA[177] & 255;
                    RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                    int[] iArr5 = new int[2];
                    iArr5[0] = 39;
                    iArr5[1] = value7 != 1 ? 1 : 0;
                    remoteModuleProxy5.cmd(1, iArr5, null, null);
                    break;
                case R.id.ctv_checkedtext6 /* 2131427548 */:
                    int value8 = DataCanbus.DATA[178] & 255;
                    RemoteModuleProxy remoteModuleProxy6 = DataCanbus.PROXY;
                    int[] iArr6 = new int[2];
                    iArr6[0] = 38;
                    iArr6[1] = value8 != 1 ? 1 : 0;
                    remoteModuleProxy6.cmd(1, iArr6, null, null);
                    break;
                case R.id.ctv_checkedtext7 /* 2131427549 */:
                    int value9 = DataCanbus.DATA[179] & 255;
                    RemoteModuleProxy remoteModuleProxy7 = DataCanbus.PROXY;
                    int[] iArr7 = new int[2];
                    iArr7[0] = 37;
                    iArr7[1] = value9 != 1 ? 1 : 0;
                    remoteModuleProxy7.cmd(1, iArr7, null, null);
                    break;
                case R.id.ctv_checkedtext8 /* 2131427550 */:
                    int value10 = DataCanbus.DATA[183] & 255;
                    RemoteModuleProxy remoteModuleProxy8 = DataCanbus.PROXY;
                    int[] iArr8 = new int[2];
                    iArr8[0] = 44;
                    iArr8[1] = value10 != 1 ? 1 : 0;
                    remoteModuleProxy8.cmd(1, iArr8, null, null);
                    break;
                case R.id.ctv_checkedtext9 /* 2131427551 */:
                    if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
                        int value11 = DataCanbus.DATA[146] & 255;
                        RemoteModuleProxy remoteModuleProxy9 = DataCanbus.PROXY;
                        int[] iArr9 = new int[2];
                        iArr9[0] = 20;
                        iArr9[1] = value11 != 1 ? 1 : 0;
                        remoteModuleProxy9.cmd(1, iArr9, null, null);
                        break;
                    } else {
                        int value12 = DataCanbus.DATA[117] & 255;
                        RemoteModuleProxy remoteModuleProxy10 = DataCanbus.PROXY;
                        int[] iArr10 = new int[2];
                        iArr10[0] = 32;
                        iArr10[1] = value12 != 1 ? 1 : 0;
                        remoteModuleProxy10.cmd(1, iArr10, null, null);
                        break;
                    }
                case R.id.ctv_checkedtext10 /* 2131427552 */:
                    int value13 = DataCanbus.DATA[118] & 255;
                    RemoteModuleProxy remoteModuleProxy11 = DataCanbus.PROXY;
                    int[] iArr11 = new int[2];
                    iArr11[0] = 33;
                    iArr11[1] = value13 != 1 ? 1 : 0;
                    remoteModuleProxy11.cmd(1, iArr11, null, null);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_bsd_keleijia_set_setting);
        init();
    }

    @Override
    public void init() {
        this.handler = new Handler(Looper.getMainLooper());
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this.mClickListener);
        checkAndSetListener((Button) findViewById(R.id.btn_minus1), this.mClickListener);
        checkAndSetListener((Button) findViewById(R.id.btn_plus1), this.mClickListener);
    }

    void checkAndSetListener(View v, View.OnClickListener clickListener) {
        if (v != null) {
            v.setOnClickListener(clickListener);
        }
    }

    @Override
    public void addNotify() {
        if (DataCanbus.DATA[1000] == 590226 || DataCanbus.DATA[1000] == 1048978 || DataCanbus.DATA[1000] == 1376658 || DataCanbus.DATA[1000] == 1769874 || DataCanbus.DATA[1000] == 2032018 || DataCanbus.DATA[1000] == 6029714 || DataCanbus.DATA[1000] == 2097554 || DataCanbus.DATA[1000] == 2163090 || DataCanbus.DATA[1000] == 3408274 || DataCanbus.DATA[1000] == 3473810) {
            setViewVisible(findViewById(R.id.layout_view10), 0);
        }
        if (DataCanbus.DATA[1000] == 1048978 || DataCanbus.DATA[1000] == 1376658 || DataCanbus.DATA[1000] == 1769874 || DataCanbus.DATA[1000] == 2032018 || DataCanbus.DATA[1000] == 6029714 || DataCanbus.DATA[1000] == 2097554 || DataCanbus.DATA[1000] == 2163090 || DataCanbus.DATA[1000] == 3408274 || DataCanbus.DATA[1000] == 3473810) {
            setViewVisible(findViewById(R.id.layout_view9), 0);
        }
        if (DataCanbus.DATA[1000] == 2032018 || DataCanbus.DATA[1000] == 6029714 || DataCanbus.DATA[1000] == 2097554 || DataCanbus.DATA[1000] == 2163090 || DataCanbus.DATA[1000] == 3408274 || DataCanbus.DATA[1000] == 3473810) {
            findViewById(R.id.layout_view1).setVisibility(0);
            findViewById(R.id.layout_view2).setVisibility(0);
            findViewById(R.id.layout_view3).setVisibility(0);
            findViewById(R.id.layout_view4).setVisibility(0);
            findViewById(R.id.layout_view5).setVisibility(0);
            findViewById(R.id.layout_view6).setVisibility(0);
            findViewById(R.id.layout_view7).setVisibility(0);
        } else {
            findViewById(R.id.layout_view1).setVisibility(8);
            findViewById(R.id.layout_view2).setVisibility(8);
            findViewById(R.id.layout_view3).setVisibility(8);
            findViewById(R.id.layout_view4).setVisibility(8);
            findViewById(R.id.layout_view5).setVisibility(8);
            findViewById(R.id.layout_view6).setVisibility(8);
            findViewById(R.id.layout_view7).setVisibility(8);
        }
        if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
            DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
            DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
    }

    void sendAirCmd(final int cmd) {
        DataCanbus.PROXY.cmd(0, new int[]{cmd, 1}, null, null);
        this.handler.postDelayed(new Runnable() { 
            @Override
            public void run() {
                DataCanbus.PROXY.cmd(0, new int[]{cmd}, null, null);
            }
        }, 300L);
    }
}
