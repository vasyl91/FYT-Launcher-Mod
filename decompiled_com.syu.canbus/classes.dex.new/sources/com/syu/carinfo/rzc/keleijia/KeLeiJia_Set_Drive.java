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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class KeLeiJia_Set_Drive extends BaseActivity {
    private int[] eventsIDs = {124, 125, 126, 127, 128, 129, 130, 152, 153, 154, 155, 156, 101, 145, 159, 162, 163, 186, 187, 206, 207, 208, 209, 210, 211, 212, 213, 214};
    private int[] sensorString = {R.string.klc_air_low, R.string.klc_air_middle, R.string.klc_air_high};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.keleijia.KeLeiJia_Set_Drive.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 101:
                case 128:
                    int val = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext5)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext5)).setChecked(val != 0);
                    }
                    break;
                case 124:
                case 152:
                    int val2 = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext3)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext3)).setChecked(val2 != 0);
                    }
                    break;
                case 125:
                    int val3 = DataCanbus.DATA[updateCode];
                    if (val3 > -1 && val3 < KeLeiJia_Set_Drive.this.sensorString.length && ((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text2)).setText(KeLeiJia_Set_Drive.this.sensorString[val3]);
                        break;
                    }
                    break;
                case 126:
                    int val4 = DataCanbus.DATA[updateCode];
                    if (((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(val4 + 1)).toString());
                    }
                    break;
                case 127:
                case 145:
                    int val5 = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext4)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext4)).setChecked(val5 != 0);
                    }
                    break;
                case 129:
                case 155:
                    int val6 = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext6)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext6)).setChecked(val6 != 0);
                    }
                    break;
                case 130:
                case 156:
                    int val7 = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext7)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext7)).setChecked(val7 != 0);
                    }
                    break;
                case 153:
                    int val8 = DataCanbus.DATA[updateCode];
                    if (((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(val8)).toString());
                    }
                    break;
                case 154:
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
                case 159:
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
                case 162:
                    int val11 = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext1)).setChecked(val11 != 0);
                    }
                    break;
                case 163:
                    int val12 = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext2)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext2)).setChecked(val12 != 0);
                    }
                    break;
                case 186:
                    int val13 = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext8)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext8)).setChecked(val13 != 0);
                    }
                    break;
                case 187:
                    int val14 = DataCanbus.DATA[updateCode];
                    if (((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val14) {
                            case 0:
                            case 1:
                                ((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text4)).setText(R.string.jeep_lanesensewarn_2);
                                break;
                            case 2:
                                ((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text4)).setText(R.string.jeep_lanesensewarn_1);
                                break;
                            case 3:
                                ((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text4)).setText(R.string.jeep_lanesensewarn_0);
                                break;
                        }
                    }
                    break;
                case 206:
                    int val15 = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext9)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext9)).setChecked(val15 != 0);
                    }
                    break;
                case 207:
                    int val16 = DataCanbus.DATA[updateCode];
                    if (((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text5)) != null) {
                        switch (val16) {
                            case 0:
                            case 1:
                                ((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_middle);
                                break;
                            case 3:
                                ((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 208:
                    int val17 = DataCanbus.DATA[updateCode];
                    if (((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text6)) != null) {
                        switch (val17) {
                            case 0:
                                ((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text6)).setText("Perso");
                                break;
                            case 1:
                                ((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text6)).setText("All on");
                                break;
                        }
                    }
                    break;
                case 209:
                    int val18 = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext10)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext10)).setChecked(val18 != 0);
                    }
                    break;
                case 210:
                    int val19 = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext11)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext11)).setChecked(val19 != 0);
                    }
                    break;
                case 211:
                    int val20 = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext12)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext12)).setChecked(val20 != 0);
                    }
                    break;
                case 212:
                    int val21 = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext13)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext13)).setChecked(val21 != 0);
                    }
                    break;
                case 213:
                    int val22 = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext14)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_Drive.this.findViewById(R.id.ctv_checkedtext14)).setChecked(val22 != 0);
                    }
                    break;
                case 214:
                    int val23 = DataCanbus.DATA[updateCode];
                    if (((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text7)) != null) {
                        switch (val23) {
                            case 0:
                            case 1:
                                ((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text7)).setText(R.string.jeep_lanesensewarn_0);
                                break;
                            case 2:
                                ((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text7)).setText(R.string.jeep_lanesensewarn_1);
                                break;
                            case 3:
                                ((TextView) KeLeiJia_Set_Drive.this.findViewById(R.id.tv_text7)).setText(R.string.jeep_lanesensewarn_2);
                                break;
                        }
                    }
                    break;
            }
        }
    };
    View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.syu.carinfo.rzc.keleijia.KeLeiJia_Set_Drive.2
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_minus1 /* 2131427456 */:
                    int value = (DataCanbus.DATA[159] & 255) - 1;
                    if (value < 1) {
                        value = 5;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{34, value}, null, null);
                    break;
                case R.id.btn_plus1 /* 2131427458 */:
                    int value2 = (DataCanbus.DATA[159] & 255) + 1;
                    if (value2 > 5) {
                        value2 = 1;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{34, value2}, null, null);
                    break;
                case R.id.btn_minus2 /* 2131427459 */:
                    if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
                        int value3 = (DataCanbus.DATA[154] & 255) - 1;
                        if (value3 < 1) {
                            value3 = 3;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{28, value3}, null, null);
                    } else {
                        int value4 = (DataCanbus.DATA[125] & 255) - 1;
                        if (value4 < 0) {
                            value4 = KeLeiJia_Set_Drive.this.sensorString.length - 1;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{65, value4}, null, null);
                    }
                    break;
                case R.id.btn_plus2 /* 2131427461 */:
                    if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
                        int value5 = (DataCanbus.DATA[154] & 255) + 1;
                        if (value5 > 3) {
                            value5 = 1;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{28, value5}, null, null);
                    } else {
                        int value6 = (DataCanbus.DATA[125] & 255) + 1;
                        if (value6 >= KeLeiJia_Set_Drive.this.sensorString.length) {
                            value6 = 0;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{65, value6}, null, null);
                    }
                    break;
                case R.id.btn_minus3 /* 2131427462 */:
                    if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
                        int value7 = (DataCanbus.DATA[153] & 255) - 1;
                        if (value7 < 1) {
                            value7 = 5;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{27, value7}, null, null);
                    } else {
                        int value8 = (DataCanbus.DATA[126] & 255) - 1;
                        if (value8 < 0) {
                            value8 = 0;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{66, value8}, null, null);
                    }
                    break;
                case R.id.btn_plus3 /* 2131427464 */:
                    if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
                        int value9 = (DataCanbus.DATA[153] & 255) + 1;
                        if (value9 > 5) {
                            value9 = 1;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{27, value9}, null, null);
                    } else {
                        int value10 = (DataCanbus.DATA[126] & 255) + 1;
                        if (value10 > 4) {
                            value10 = 4;
                        }
                        DataCanbus.PROXY.cmd(1, new int[]{66, value10}, null, null);
                    }
                    break;
                case R.id.btn_minus4 /* 2131427465 */:
                    int value11 = (DataCanbus.DATA[187] & 255) - 1;
                    if (value11 < 1) {
                        value11 = 3;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{49, value11}, null, null);
                    break;
                case R.id.btn_plus4 /* 2131427467 */:
                    int value12 = (DataCanbus.DATA[187] & 255) + 1;
                    if (value12 > 3) {
                        value12 = 1;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{49, value12}, null, null);
                    break;
                case R.id.btn_minus5 /* 2131427468 */:
                    int value13 = (DataCanbus.DATA[207] & 255) - 1;
                    if (value13 < 1) {
                        value13 = 3;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{59, value13}, null, null);
                    break;
                case R.id.btn_plus5 /* 2131427470 */:
                    int value14 = (DataCanbus.DATA[207] & 255) + 1;
                    if (value14 > 3) {
                        value14 = 1;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{59, value14}, null, null);
                    break;
                case R.id.btn_minus6 /* 2131427471 */:
                    int value15 = (DataCanbus.DATA[208] & 255) - 1;
                    if (value15 < 0) {
                        value15 = 1;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{51, value15}, null, null);
                    break;
                case R.id.btn_plus6 /* 2131427473 */:
                    int value16 = (DataCanbus.DATA[208] & 255) + 1;
                    if (value16 > 1) {
                        value16 = 0;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{51, value16}, null, null);
                    break;
                case R.id.btn_minus7 /* 2131427474 */:
                    int value17 = (DataCanbus.DATA[214] & 255) - 1;
                    if (value17 < 1) {
                        value17 = 3;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{57, value17}, null, null);
                    break;
                case R.id.btn_plus7 /* 2131427476 */:
                    int value18 = (DataCanbus.DATA[214] & 255) + 1;
                    if (value18 > 3) {
                        value18 = 1;
                    }
                    DataCanbus.PROXY.cmd(1, new int[]{57, value18}, null, null);
                    break;
                case R.id.ctv_checkedtext1 /* 2131427554 */:
                    int value19 = DataCanbus.DATA[162];
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 36;
                    iArr[1] = value19 != 1 ? 1 : 0;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                    break;
                case R.id.ctv_checkedtext4 /* 2131427561 */:
                    if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
                        int value20 = DataCanbus.DATA[145] & 255;
                        RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                        int[] iArr2 = new int[2];
                        iArr2[0] = 29;
                        iArr2[1] = value20 != 1 ? 1 : 0;
                        remoteModuleProxy2.cmd(1, iArr2, null, null);
                    } else {
                        int value21 = DataCanbus.DATA[127] & 255;
                        RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                        int[] iArr3 = new int[2];
                        iArr3[0] = 67;
                        iArr3[1] = value21 != 1 ? 1 : 0;
                        remoteModuleProxy3.cmd(1, iArr3, null, null);
                    }
                    break;
                case R.id.ctv_checkedtext5 /* 2131427562 */:
                    if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
                        int value22 = DataCanbus.DATA[101] & 255;
                        RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                        int[] iArr4 = new int[2];
                        iArr4[0] = 17;
                        iArr4[1] = value22 != 1 ? 1 : 0;
                        remoteModuleProxy4.cmd(1, iArr4, null, null);
                    } else {
                        int value23 = DataCanbus.DATA[128] & 255;
                        RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                        int[] iArr5 = new int[2];
                        iArr5[0] = 68;
                        iArr5[1] = value23 != 1 ? 1 : 0;
                        remoteModuleProxy5.cmd(1, iArr5, null, null);
                    }
                    break;
                case R.id.ctv_checkedtext2 /* 2131427576 */:
                    int value24 = DataCanbus.DATA[163];
                    RemoteModuleProxy remoteModuleProxy6 = DataCanbus.PROXY;
                    int[] iArr6 = new int[2];
                    iArr6[0] = 35;
                    iArr6[1] = value24 != 1 ? 1 : 0;
                    remoteModuleProxy6.cmd(1, iArr6, null, null);
                    break;
                case R.id.ctv_checkedtext3 /* 2131427577 */:
                    if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
                        int value25 = DataCanbus.DATA[152] & 255;
                        RemoteModuleProxy remoteModuleProxy7 = DataCanbus.PROXY;
                        int[] iArr7 = new int[2];
                        iArr7[0] = 26;
                        iArr7[1] = value25 != 1 ? 1 : 0;
                        remoteModuleProxy7.cmd(1, iArr7, null, null);
                    } else {
                        int value26 = DataCanbus.DATA[124] & 255;
                        RemoteModuleProxy remoteModuleProxy8 = DataCanbus.PROXY;
                        int[] iArr8 = new int[2];
                        iArr8[0] = 64;
                        iArr8[1] = value26 != 1 ? 1 : 0;
                        remoteModuleProxy8.cmd(1, iArr8, null, null);
                    }
                    break;
                case R.id.ctv_checkedtext6 /* 2131427581 */:
                    if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
                        int value27 = DataCanbus.DATA[155] & 255;
                        RemoteModuleProxy remoteModuleProxy9 = DataCanbus.PROXY;
                        int[] iArr9 = new int[2];
                        iArr9[0] = 30;
                        iArr9[1] = value27 != 1 ? 1 : 0;
                        remoteModuleProxy9.cmd(1, iArr9, null, null);
                    } else {
                        int value28 = DataCanbus.DATA[129] & 255;
                        RemoteModuleProxy remoteModuleProxy10 = DataCanbus.PROXY;
                        int[] iArr10 = new int[2];
                        iArr10[0] = 69;
                        iArr10[1] = value28 != 1 ? 1 : 0;
                        remoteModuleProxy10.cmd(1, iArr10, null, null);
                    }
                    break;
                case R.id.ctv_checkedtext7 /* 2131427582 */:
                    if (((DataCanbus.DATA[1000] >> 16) & 65535) == 0 || ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10) {
                        int value29 = DataCanbus.DATA[156] & 255;
                        RemoteModuleProxy remoteModuleProxy11 = DataCanbus.PROXY;
                        int[] iArr11 = new int[2];
                        iArr11[0] = 31;
                        iArr11[1] = value29 != 1 ? 1 : 0;
                        remoteModuleProxy11.cmd(1, iArr11, null, null);
                    } else {
                        int value30 = DataCanbus.DATA[130] & 255;
                        RemoteModuleProxy remoteModuleProxy12 = DataCanbus.PROXY;
                        int[] iArr12 = new int[2];
                        iArr12[0] = 70;
                        iArr12[1] = value30 != 1 ? 1 : 0;
                        remoteModuleProxy12.cmd(1, iArr12, null, null);
                    }
                    break;
                case R.id.ctv_checkedtext8 /* 2131427633 */:
                    int value31 = DataCanbus.DATA[186] & 255;
                    RemoteModuleProxy remoteModuleProxy13 = DataCanbus.PROXY;
                    int[] iArr13 = new int[2];
                    iArr13[0] = 48;
                    iArr13[1] = value31 != 1 ? 1 : 0;
                    remoteModuleProxy13.cmd(1, iArr13, null, null);
                    break;
                case R.id.ctv_checkedtext9 /* 2131427634 */:
                    int value32 = DataCanbus.DATA[206] & 255;
                    RemoteModuleProxy remoteModuleProxy14 = DataCanbus.PROXY;
                    int[] iArr14 = new int[2];
                    iArr14[0] = 60;
                    iArr14[1] = value32 != 1 ? 1 : 0;
                    remoteModuleProxy14.cmd(1, iArr14, null, null);
                    break;
                case R.id.ctv_checkedtext10 /* 2131427635 */:
                    int value33 = DataCanbus.DATA[209] & 255;
                    RemoteModuleProxy remoteModuleProxy15 = DataCanbus.PROXY;
                    int[] iArr15 = new int[2];
                    iArr15[0] = 52;
                    iArr15[1] = value33 != 1 ? 1 : 0;
                    remoteModuleProxy15.cmd(1, iArr15, null, null);
                    break;
                case R.id.ctv_checkedtext11 /* 2131427636 */:
                    int value34 = DataCanbus.DATA[210] & 255;
                    RemoteModuleProxy remoteModuleProxy16 = DataCanbus.PROXY;
                    int[] iArr16 = new int[2];
                    iArr16[0] = 53;
                    iArr16[1] = value34 != 1 ? 1 : 0;
                    remoteModuleProxy16.cmd(1, iArr16, null, null);
                    break;
                case R.id.ctv_checkedtext12 /* 2131427637 */:
                    int value35 = DataCanbus.DATA[211] & 255;
                    RemoteModuleProxy remoteModuleProxy17 = DataCanbus.PROXY;
                    int[] iArr17 = new int[2];
                    iArr17[0] = 54;
                    iArr17[1] = value35 != 1 ? 1 : 0;
                    remoteModuleProxy17.cmd(1, iArr17, null, null);
                    break;
                case R.id.ctv_checkedtext13 /* 2131427638 */:
                    int value36 = DataCanbus.DATA[212] & 255;
                    RemoteModuleProxy remoteModuleProxy18 = DataCanbus.PROXY;
                    int[] iArr18 = new int[2];
                    iArr18[0] = 55;
                    iArr18[1] = value36 != 1 ? 1 : 0;
                    remoteModuleProxy18.cmd(1, iArr18, null, null);
                    break;
                case R.id.ctv_checkedtext14 /* 2131427639 */:
                    int value37 = DataCanbus.DATA[213] & 255;
                    RemoteModuleProxy remoteModuleProxy19 = DataCanbus.PROXY;
                    int[] iArr19 = new int[2];
                    iArr19[0] = 56;
                    iArr19[1] = value37 != 1 ? 1 : 0;
                    remoteModuleProxy19.cmd(1, iArr19, null, null);
                    break;
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
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext11), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext12), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext13), this.mClickListener);
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext14), this.mClickListener);
        checkAndSetListener((Button) findViewById(R.id.btn_minus1), this.mClickListener);
        checkAndSetListener((Button) findViewById(R.id.btn_plus1), this.mClickListener);
        checkAndSetListener((Button) findViewById(R.id.btn_minus2), this.mClickListener);
        checkAndSetListener((Button) findViewById(R.id.btn_plus2), this.mClickListener);
        checkAndSetListener((Button) findViewById(R.id.btn_minus3), this.mClickListener);
        checkAndSetListener((Button) findViewById(R.id.btn_plus3), this.mClickListener);
        checkAndSetListener((Button) findViewById(R.id.btn_minus4), this.mClickListener);
        checkAndSetListener((Button) findViewById(R.id.btn_plus4), this.mClickListener);
        checkAndSetListener((Button) findViewById(R.id.btn_minus5), this.mClickListener);
        checkAndSetListener((Button) findViewById(R.id.btn_plus5), this.mClickListener);
        checkAndSetListener((Button) findViewById(R.id.btn_minus6), this.mClickListener);
        checkAndSetListener((Button) findViewById(R.id.btn_plus6), this.mClickListener);
        checkAndSetListener((Button) findViewById(R.id.btn_minus7), this.mClickListener);
        checkAndSetListener((Button) findViewById(R.id.btn_plus7), this.mClickListener);
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
