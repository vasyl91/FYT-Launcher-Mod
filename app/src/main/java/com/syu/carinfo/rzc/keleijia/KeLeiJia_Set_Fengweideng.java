package com.syu.carinfo.rzc.keleijia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class KeLeiJia_Set_Fengweideng extends BaseActivity {
    private int[] eventsIDs = {119, 120, 121, 122, 123};
    private int[] colorString = {R.string.str_background_green, R.string.str_background_red, R.string.str_background_blue, R.string.color_pueple_str, R.string.color_orange_str};
    private int[] colorString_rzc = {R.string.color_white_str, R.string.str_background_green, R.string.str_background_red, R.string.str_background_blue, R.string.color_pueple_str, R.string.color_orange_str, R.string.color_blue_green_str, R.string.str_403_ambient_7};
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 119:
                case 147:
                    int val = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) KeLeiJia_Set_Fengweideng.this.findViewById(R.id.ctv_checkedtext2)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_Fengweideng.this.findViewById(R.id.ctv_checkedtext2)).setChecked(val != 0);
                        break;
                    }
                case 120:
                case 148:
                    int val2 = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) KeLeiJia_Set_Fengweideng.this.findViewById(R.id.ctv_checkedtext3)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_Fengweideng.this.findViewById(R.id.ctv_checkedtext3)).setChecked(val2 != 0);
                        break;
                    }
                case 121:
                case 149:
                    int val3 = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) KeLeiJia_Set_Fengweideng.this.findViewById(R.id.ctv_checkedtext4)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_Fengweideng.this.findViewById(R.id.ctv_checkedtext4)).setChecked(val3 != 0);
                        break;
                    }
                case 122:
                    int val4 = DataCanbus.DATA[updateCode];
                    if (val4 > -1 && val4 < KeLeiJia_Set_Fengweideng.this.colorString.length && ((TextView) KeLeiJia_Set_Fengweideng.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) KeLeiJia_Set_Fengweideng.this.findViewById(R.id.tv_text1)).setText(KeLeiJia_Set_Fengweideng.this.colorString[val4]);
                        break;
                    }
                case 123:
                case 151:
                    int val5 = DataCanbus.DATA[updateCode];
                    if (((TextView) KeLeiJia_Set_Fengweideng.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) KeLeiJia_Set_Fengweideng.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(val5)).toString());
                        break;
                    }
                case 150:
                    int val6 = DataCanbus.DATA[updateCode];
                    if (val6 > -1 && val6 < KeLeiJia_Set_Fengweideng.this.colorString_rzc.length && ((TextView) KeLeiJia_Set_Fengweideng.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) KeLeiJia_Set_Fengweideng.this.findViewById(R.id.tv_text1)).setText(KeLeiJia_Set_Fengweideng.this.colorString_rzc[val6]);
                        break;
                    }
                case 160:
                    int val7 = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) KeLeiJia_Set_Fengweideng.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_Fengweideng.this.findViewById(R.id.ctv_checkedtext1)).setChecked(val7 != 0);
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
                    if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
                        int value = (DataCanbus.DATA[150] & 255) - 1;
                        if (value < 0) {
                            value = 7;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{24, value}, null, null);
                        break;
                    } else {
                        int value2 = (DataCanbus.DATA[122] & 255) - 1;
                        if (value2 < 0) {
                            value2 = KeLeiJia_Set_Fengweideng.this.colorString.length - 1;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{51, value2}, null, null);
                        break;
                    }
                case R.id.btn_plus1 /* 2131427457 */:
                    if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
                        int value3 = (DataCanbus.DATA[150] & 255) + 1;
                        if (value3 > 7) {
                            value3 = 0;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{24, value3}, null, null);
                        break;
                    } else {
                        int value4 = (DataCanbus.DATA[122] & 255) + 1;
                        if (value4 >= KeLeiJia_Set_Fengweideng.this.colorString.length) {
                            value4 = 0;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{51, value4}, null, null);
                        break;
                    }
                case R.id.btn_minus2 /* 2131427458 */:
                    if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
                        int value5 = (DataCanbus.DATA[151] & 255) - 5;
                        if (value5 < 0) {
                            value5 = 0;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{25, value5}, null, null);
                        break;
                    } else {
                        int value6 = (DataCanbus.DATA[123] & 255) - 5;
                        if (value6 < 0) {
                            value6 = 0;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{52, value6}, null, null);
                        break;
                    }
                case R.id.btn_plus2 /* 2131427460 */:
                    if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
                        int value7 = (DataCanbus.DATA[151] & 255) + 5;
                        if (value7 > 100) {
                            value7 = 100;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{25, value7}, null, null);
                        break;
                    } else {
                        int value8 = (DataCanbus.DATA[123] & 255) + 5;
                        if (value8 > 100) {
                            value8 = 100;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{52, value8}, null, null);
                        break;
                    }
                case R.id.ctv_checkedtext1 /* 2131427525 */:
                    int value9 = DataCanbus.DATA[160] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 33;
                    iArr[1] = value9 != 1 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                    break;
                case R.id.ctv_checkedtext2 /* 2131427541 */:
                    if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
                        int value10 = DataCanbus.DATA[147] & 255;
                        RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                        int[] iArr2 = new int[2];
                        iArr2[0] = 21;
                        iArr2[1] = value10 != 1 ? 1 : 0;
                        remoteModuleProxy2.cmd(1, iArr2, null, null);
                        break;
                    } else {
                        int value11 = DataCanbus.DATA[119] & 255;
                        RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                        int[] iArr3 = new int[2];
                        iArr3[0] = 48;
                        iArr3[1] = value11 != 1 ? 1 : 0;
                        remoteModuleProxy3.cmd(1, iArr3, null, null);
                        break;
                    }
                case R.id.ctv_checkedtext3 /* 2131427542 */:
                    if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
                        int value12 = DataCanbus.DATA[148] & 255;
                        RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                        int[] iArr4 = new int[2];
                        iArr4[0] = 22;
                        iArr4[1] = value12 != 1 ? 1 : 0;
                        remoteModuleProxy4.cmd(1, iArr4, null, null);
                        break;
                    } else {
                        int value13 = DataCanbus.DATA[120] & 255;
                        RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                        int[] iArr5 = new int[2];
                        iArr5[0] = 49;
                        iArr5[1] = value13 != 1 ? 1 : 0;
                        remoteModuleProxy5.cmd(1, iArr5, null, null);
                        break;
                    }
                case R.id.ctv_checkedtext4 /* 2131427544 */:
                    if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
                        int value14 = DataCanbus.DATA[149] & 255;
                        RemoteModuleProxy remoteModuleProxy6 = DataCanbus.PROXY;
                        int[] iArr6 = new int[2];
                        iArr6[0] = 23;
                        iArr6[1] = value14 != 1 ? 1 : 0;
                        remoteModuleProxy6.cmd(1, iArr6, null, null);
                        break;
                    } else {
                        int value15 = DataCanbus.DATA[121] & 255;
                        RemoteModuleProxy remoteModuleProxy7 = DataCanbus.PROXY;
                        int[] iArr7 = new int[2];
                        iArr7[0] = 50;
                        iArr7[1] = value15 != 1 ? 1 : 0;
                        remoteModuleProxy7.cmd(1, iArr7, null, null);
                        break;
                    }
                case R.id.ctv_checkedtext5 /* 2131427547 */:
                    DataCanbus.PROXY.cmd(1, new int[]{128, 5}, null, null);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_bsd_keleijia_set_fenweideng);
        init();
    }

    @Override
    public void init() {
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this.mClickListener);
        checkAndSetListener((Button) findViewById(R.id.btn_minus1), this.mClickListener);
        checkAndSetListener((Button) findViewById(R.id.btn_plus1), this.mClickListener);
        checkAndSetListener((Button) findViewById(R.id.btn_minus2), this.mClickListener);
        checkAndSetListener((Button) findViewById(R.id.btn_plus2), this.mClickListener);
    }

    void checkAndSetListener(View v, View.OnClickListener clickListener) {
        if (v != null) {
            v.setOnClickListener(clickListener);
        }
    }

    @Override
    public void addNotify() {
        if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
            DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
            return;
        }
        for (int i = 0; i < this.eventsIDs.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventsIDs[i]].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override
    public void removeNotify() {
        if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
            DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
            return;
        }
        for (int i = 0; i < this.eventsIDs.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventsIDs[i]].removeNotify(this.mNotifyCanbus);
        }
    }
}
