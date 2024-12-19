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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class KeLeiJia_Set_Drive extends BaseActivity {
    private int[] eventsIDs = {34, 35, 36, 37, 38, 39, 40, 85, 86, 87, 88, 89, 11, 78, 92, 95, 96};
    private int[] sensorString = {R.string.klc_air_low, R.string.klc_air_middle, R.string.klc_air_high};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.keleijia.KeLeiJia_Set_Drive.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 11:
                case 38:
                    int val = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext5)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext5)).setChecked(val != 0);
                        break;
                    }
                case 34:
                case 85:
                    int val2 = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext3)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext3)).setChecked(val2 != 0);
                        break;
                    }
                case 35:
                    int val3 = DataCanbus.DATA[updateCode];
                    if (val3 > -1 && val3 < KeLeiJia_Set_Drive.this.sensorString.length && ((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text2)).setText(KeLeiJia_Set_Drive.this.sensorString[val3]);
                        break;
                    }
                case 36:
                    int val4 = DataCanbus.DATA[updateCode];
                    if (((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(val4 + 1)).toString());
                        break;
                    }
                case 37:
                case 78:
                    int val5 = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext4)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext4)).setChecked(val5 != 0);
                        break;
                    }
                case 39:
                case 88:
                    int val6 = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext6)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext6)).setChecked(val6 != 0);
                        break;
                    }
                case 40:
                case 89:
                    int val7 = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext7)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext7)).setChecked(val7 != 0);
                        break;
                    }
                case 86:
                    int val8 = DataCanbus.DATA[updateCode];
                    if (((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(val8)).toString());
                        break;
                    }
                case 87:
                    int val9 = DataCanbus.DATA[updateCode];
                    if (((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val9) {
                            case 1:
                                ((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_high);
                                break;
                            case 2:
                                ((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_middle);
                                break;
                            case 3:
                                ((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_low);
                                break;
                        }
                    }
                    break;
                case 92:
                    int val10 = DataCanbus.DATA[updateCode];
                    if (((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val10) {
                            case 1:
                                ((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text1)).setText("Eco");
                                break;
                            case 2:
                                ((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text1)).setText("Perso");
                                break;
                            case 3:
                                ((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text1)).setText("Sport");
                                break;
                            case 4:
                                ((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text1)).setText("Comfort");
                                break;
                            case 5:
                                ((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text1)).setText("Neutral");
                                break;
                        }
                    }
                    break;
                case 95:
                    int val11 = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext1)).setChecked(val11 != 0);
                        break;
                    }
                case 96:
                    int val12 = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext2)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext2)).setChecked(val12 != 0);
                        break;
                    }
            }
        }
    };
    View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.syu.carinfo.rzc.keleijia.KeLeiJia_Set_Drive.2
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ctv_checkedtext1 /* 2131427478 */:
                    int value = DataCanbus.DATA[95];
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 36;
                    iArr[1] = value != 1 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                    break;
                case R.id.btn_minus1 /* 2131427480 */:
                    int value2 = (DataCanbus.DATA[92] & 255) - 1;
                    if (value2 < 1) {
                        value2 = 5;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{34, value2}, null, null);
                    break;
                case R.id.btn_plus1 /* 2131427482 */:
                    int value3 = (DataCanbus.DATA[92] & 255) + 1;
                    if (value3 > 5) {
                        value3 = 1;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{34, value3}, null, null);
                    break;
                case R.id.btn_minus2 /* 2131427484 */:
                    if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
                        int value4 = (DataCanbus.DATA[87] & 255) - 1;
                        if (value4 < 1) {
                            value4 = 3;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{28, value4}, null, null);
                        break;
                    } else {
                        int value5 = (DataCanbus.DATA[35] & 255) - 1;
                        if (value5 < 0) {
                            value5 = KeLeiJia_Set_Drive.this.sensorString.length - 1;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{65, value5}, null, null);
                        break;
                    }
                case R.id.btn_plus2 /* 2131427486 */:
                    if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
                        int value6 = (DataCanbus.DATA[87] & 255) + 1;
                        if (value6 > 3) {
                            value6 = 1;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{28, value6}, null, null);
                        break;
                    } else {
                        int value7 = (DataCanbus.DATA[35] & 255) + 1;
                        if (value7 >= KeLeiJia_Set_Drive.this.sensorString.length) {
                            value7 = 0;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{65, value7}, null, null);
                        break;
                    }
                case R.id.btn_minus3 /* 2131427488 */:
                    if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
                        int value8 = (DataCanbus.DATA[86] & 255) - 1;
                        if (value8 < 1) {
                            value8 = 5;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{27, value8}, null, null);
                        break;
                    } else {
                        int value9 = (DataCanbus.DATA[36] & 255) - 1;
                        if (value9 < 0) {
                            value9 = 0;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{66, value9}, null, null);
                        break;
                    }
                case R.id.btn_plus3 /* 2131427490 */:
                    if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
                        int value10 = (DataCanbus.DATA[86] & 255) + 1;
                        if (value10 > 5) {
                            value10 = 1;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{27, value10}, null, null);
                        break;
                    } else {
                        int value11 = (DataCanbus.DATA[36] & 255) + 1;
                        if (value11 > 4) {
                            value11 = 4;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{66, value11}, null, null);
                        break;
                    }
                case R.id.ctv_checkedtext2 /* 2131427531 */:
                    int value12 = DataCanbus.DATA[96];
                    RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                    int[] iArr2 = new int[2];
                    iArr2[0] = 35;
                    iArr2[1] = value12 != 1 ? 1 : 0;
                    remoteModuleProxy2.cmd(1, iArr2, null, null);
                    break;
                case R.id.ctv_checkedtext3 /* 2131427532 */:
                    if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
                        int value13 = DataCanbus.DATA[85] & 255;
                        RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                        int[] iArr3 = new int[2];
                        iArr3[0] = 26;
                        iArr3[1] = value13 != 1 ? 1 : 0;
                        remoteModuleProxy3.cmd(1, iArr3, null, null);
                        break;
                    } else {
                        int value14 = DataCanbus.DATA[34] & 255;
                        RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                        int[] iArr4 = new int[2];
                        iArr4[0] = 64;
                        iArr4[1] = value14 != 1 ? 1 : 0;
                        remoteModuleProxy4.cmd(1, iArr4, null, null);
                        break;
                    }
                case R.id.ctv_checkedtext4 /* 2131427533 */:
                    if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
                        int value15 = DataCanbus.DATA[78] & 255;
                        RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                        int[] iArr5 = new int[2];
                        iArr5[0] = 29;
                        iArr5[1] = value15 != 1 ? 1 : 0;
                        remoteModuleProxy5.cmd(1, iArr5, null, null);
                        break;
                    } else {
                        int value16 = DataCanbus.DATA[37] & 255;
                        RemoteModuleProxy remoteModuleProxy6 = DataCanbus.PROXY;
                        int[] iArr6 = new int[2];
                        iArr6[0] = 67;
                        iArr6[1] = value16 != 1 ? 1 : 0;
                        remoteModuleProxy6.cmd(1, iArr6, null, null);
                        break;
                    }
                case R.id.ctv_checkedtext5 /* 2131427537 */:
                    if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
                        int value17 = DataCanbus.DATA[11] & 255;
                        RemoteModuleProxy remoteModuleProxy7 = DataCanbus.PROXY;
                        int[] iArr7 = new int[2];
                        iArr7[0] = 17;
                        iArr7[1] = value17 != 1 ? 1 : 0;
                        remoteModuleProxy7.cmd(1, iArr7, null, null);
                        break;
                    } else {
                        int value18 = DataCanbus.DATA[38] & 255;
                        RemoteModuleProxy remoteModuleProxy8 = DataCanbus.PROXY;
                        int[] iArr8 = new int[2];
                        iArr8[0] = 68;
                        iArr8[1] = value18 != 1 ? 1 : 0;
                        remoteModuleProxy8.cmd(1, iArr8, null, null);
                        break;
                    }
                case R.id.ctv_checkedtext6 /* 2131427538 */:
                    if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
                        int value19 = DataCanbus.DATA[88] & 255;
                        RemoteModuleProxy remoteModuleProxy9 = DataCanbus.PROXY;
                        int[] iArr9 = new int[2];
                        iArr9[0] = 30;
                        iArr9[1] = value19 != 1 ? 1 : 0;
                        remoteModuleProxy9.cmd(1, iArr9, null, null);
                        break;
                    } else {
                        int value20 = DataCanbus.DATA[39] & 255;
                        RemoteModuleProxy remoteModuleProxy10 = DataCanbus.PROXY;
                        int[] iArr10 = new int[2];
                        iArr10[0] = 69;
                        iArr10[1] = value20 != 1 ? 1 : 0;
                        remoteModuleProxy10.cmd(1, iArr10, null, null);
                        break;
                    }
                case R.id.ctv_checkedtext7 /* 2131427539 */:
                    if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
                        int value21 = DataCanbus.DATA[89] & 255;
                        RemoteModuleProxy remoteModuleProxy11 = DataCanbus.PROXY;
                        int[] iArr11 = new int[2];
                        iArr11[0] = 31;
                        iArr11[1] = value21 != 1 ? 1 : 0;
                        remoteModuleProxy11.cmd(1, iArr11, null, null);
                        break;
                    } else {
                        int value22 = DataCanbus.DATA[40] & 255;
                        RemoteModuleProxy remoteModuleProxy12 = DataCanbus.PROXY;
                        int[] iArr12 = new int[2];
                        iArr12[0] = 70;
                        iArr12[1] = value22 != 1 ? 1 : 0;
                        remoteModuleProxy12.cmd(1, iArr12, null, null);
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bsd_keleijia_set_drive);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this.mClickListener);
        checkAndSetListener((Button) findViewById(R.id.btn_minus2), this.mClickListener);
        checkAndSetListener((Button) findViewById(R.id.btn_plus2), this.mClickListener);
        checkAndSetListener((Button) findViewById(R.id.btn_minus3), this.mClickListener);
        checkAndSetListener((Button) findViewById(R.id.btn_plus3), this.mClickListener);
        checkAndSetListener((Button) findViewById(R.id.btn_minus1), this.mClickListener);
        checkAndSetListener((Button) findViewById(R.id.btn_plus1), this.mClickListener);
    }

    void checkAndSetListener(View v, View.OnClickListener clickListener) {
        if (v != null) {
            v.setOnClickListener(clickListener);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        for (int i = 0; i < this.eventsIDs.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventsIDs[i]].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        for (int i = 0; i < this.eventsIDs.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventsIDs[i]].removeNotify(this.mNotifyCanbus);
        }
    }
}
