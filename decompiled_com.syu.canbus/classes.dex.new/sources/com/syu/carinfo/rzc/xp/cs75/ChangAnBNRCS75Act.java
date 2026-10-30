package com.syu.carinfo.rzc.xp.cs75;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ChangAnBNRCS75Act extends BaseActivity implements View.OnClickListener {
    private int mMode = 1;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnBNRCS75Act.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    ChangAnBNRCS75Act.this.mUpdateCurOilExpend();
                    break;
                case 99:
                    ChangAnBNRCS75Act.this.mUpdateCurOptimalOilExpend();
                    break;
                case 100:
                    ChangAnBNRCS75Act.this.mUpdaterDrivingMileage();
                    break;
                case 101:
                    ChangAnBNRCS75Act.this.mUpdaterCurTripOilExpend();
                    break;
                case 102:
                    ChangAnBNRCS75Act.this.uFoldRearMirror(DataCanbus.DATA[updateCode]);
                    break;
                case 103:
                    ChangAnBNRCS75Act.this.mUpdaterValue8();
                    break;
                case 116:
                    ChangAnBNRCS75Act.this.uRestoreCarSet(DataCanbus.DATA[updateCode]);
                    break;
                case 118:
                    ChangAnBNRCS75Act.this.uRemoteUnlock(DataCanbus.DATA[updateCode]);
                    break;
                case 119:
                    ChangAnBNRCS75Act.this.uDriveLock(DataCanbus.DATA[updateCode]);
                    break;
                case 120:
                    ChangAnBNRCS75Act.this.uAccOffLock(DataCanbus.DATA[updateCode]);
                    break;
                case 122:
                    ChangAnBNRCS75Act.this.uAutoAir(DataCanbus.DATA[updateCode]);
                    break;
                case 123:
                    ChangAnBNRCS75Act.this.uOpenWindowToWind(DataCanbus.DATA[updateCode]);
                    break;
                case 124:
                    ChangAnBNRCS75Act.this.uAirAutoDry(DataCanbus.DATA[updateCode]);
                    break;
                case 125:
                    ChangAnBNRCS75Act.this.uLightFrontDelay(DataCanbus.DATA[updateCode]);
                    break;
                case 126:
                    ChangAnBNRCS75Act.this.uLightOnKeyTurn(DataCanbus.DATA[updateCode]);
                    break;
                case 138:
                    ((CheckedTextView) ChangAnBNRCS75Act.this.findViewById(R.id.ctv_checkedtext6)).setChecked(value == 1);
                    break;
                case 139:
                    ((CheckedTextView) ChangAnBNRCS75Act.this.findViewById(R.id.ctv_checkedtext14)).setChecked(value == 1);
                    break;
                case 140:
                    ((CheckedTextView) ChangAnBNRCS75Act.this.findViewById(R.id.ctv_checkedtext15)).setChecked(value == 1);
                    break;
                case 141:
                    if (((TextView) ChangAnBNRCS75Act.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) ChangAnBNRCS75Act.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 142:
                    if (((TextView) ChangAnBNRCS75Act.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ChangAnBNRCS75Act.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ChangAnBNRCS75Act.this.findViewById(R.id.tv_text5)).setText("仅识别提示");
                                break;
                            case 2:
                                ((TextView) ChangAnBNRCS75Act.this.findViewById(R.id.tv_text5)).setText("仅消失提示");
                                break;
                            case 3:
                                ((TextView) ChangAnBNRCS75Act.this.findViewById(R.id.tv_text5)).setText("识别和消失提示");
                                break;
                        }
                    }
                    break;
                case 143:
                    if (((TextView) ChangAnBNRCS75Act.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ChangAnBNRCS75Act.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_low);
                                break;
                            case 1:
                                ((TextView) ChangAnBNRCS75Act.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) ChangAnBNRCS75Act.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 144:
                    ((CheckedTextView) ChangAnBNRCS75Act.this.findViewById(R.id.ctv_checkedtext17)).setChecked(value == 1);
                    break;
                case 145:
                    ((CheckedTextView) ChangAnBNRCS75Act.this.findViewById(R.id.ctv_checkedtext16)).setChecked(value == 1);
                    break;
                case 146:
                    ((CheckedTextView) ChangAnBNRCS75Act.this.findViewById(R.id.ctv_checkedtext21)).setChecked(value == 1);
                    break;
                case 147:
                    ((CheckedTextView) ChangAnBNRCS75Act.this.findViewById(R.id.ctv_checkedtext20)).setChecked(value == 1);
                    break;
                case 148:
                    ((CheckedTextView) ChangAnBNRCS75Act.this.findViewById(R.id.ctv_checkedtext19)).setChecked(value == 1);
                    break;
                case 149:
                    ((CheckedTextView) ChangAnBNRCS75Act.this.findViewById(R.id.ctv_checkedtext18)).setChecked(value == 1);
                    break;
                case 150:
                    ((CheckedTextView) ChangAnBNRCS75Act.this.findViewById(R.id.ctv_checkedtext22)).setChecked(value == 1);
                    break;
                case 151:
                    if (((TextView) ChangAnBNRCS75Act.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ChangAnBNRCS75Act.this.findViewById(R.id.tv_text7)).setText(R.string.wc_golf_normal);
                                break;
                            case 1:
                                ((TextView) ChangAnBNRCS75Act.this.findViewById(R.id.tv_text7)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 152:
                    if (((TextView) ChangAnBNRCS75Act.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) ChangAnBNRCS75Act.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + "km");
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_070_bnr_cs75);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext12), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext13), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext14), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext15), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext16), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext17), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext18), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext19), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext20), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext21), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext22), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
        setSelfClick((Button) findViewById(R.id.btn_minus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_BNR_17CS95 /* 1310790 */:
            case FinalCanbus.CAR_BNR_17CS95_H /* 1835078 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(8);
                break;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                setMode(-1);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                setMode(1);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                FrontLightDelayMode(-1);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                FrontLightDelayMode(1);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                OnekeyturnMode(-1);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                OnekeyturnMode(1);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int i = DataCanbus.DATA[141];
                int i2 = i - 1;
                if (i2 < 0) {
                    i2 = 5;
                }
                DataCanbus.PROXY.cmd(2, new int[]{136, 19, i2}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int i3 = DataCanbus.DATA[141];
                int i4 = i3 + 1;
                if (i4 > 5) {
                    i4 = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{136, 19, i4}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int i5 = DataCanbus.DATA[142];
                int i6 = i5 - 1;
                if (i6 < 0) {
                    i6 = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{136, 11, i6}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int i7 = DataCanbus.DATA[142];
                int i8 = i7 + 1;
                if (i8 > 3) {
                    i8 = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{136, 11, i8}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int i9 = DataCanbus.DATA[143];
                int i10 = i9 - 1;
                if (i10 < 0) {
                    i10 = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{136, 32, i10}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int i11 = DataCanbus.DATA[143];
                int i12 = i11 + 1;
                if (i12 > 2) {
                    i12 = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{136, 32, i12}, null, null);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int i13 = DataCanbus.DATA[151];
                int i14 = i13 - 1;
                if (i14 < 0) {
                    i14 = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{136, 17, i14}, null, null);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int i15 = DataCanbus.DATA[151];
                int i16 = i15 + 1;
                if (i16 > 1) {
                    i16 = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{136, 17, i16}, null, null);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
            case R.id.btn_plus8 /* 2131427479 */:
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                int i17 = DataCanbus.DATA[118];
                DataCanbus.PROXY.cmd(2, new int[]{136, 0, getCheckedValue(i17)}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int oilReminder = DataCanbus.DATA[99];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 1;
                iArr[1] = oilReminder != 1 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                ShoeRestoreCarSetDialog();
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                maintenanceCarSetDialog();
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int i18 = DataCanbus.DATA[102];
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 2;
                iArr2[1] = i18 != 1 ? 1 : 0;
                remoteModuleProxy2.cmd(1, iArr2, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int value = DataCanbus.DATA[103] & 255;
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[1];
                iArr3[0] = value != 0 ? 0 : 1;
                remoteModuleProxy3.cmd(3, iArr3, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int i19 = DataCanbus.DATA[138] & 255;
                DataCanbus.PROXY.cmd(2, new int[]{136, 20, getCheckedValue(i19)}, null, null);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                int i20 = DataCanbus.DATA[119];
                DataCanbus.PROXY.cmd(2, new int[]{136, 1, getCheckedValue(i20)}, null, null);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                int i21 = DataCanbus.DATA[120];
                DataCanbus.PROXY.cmd(2, new int[]{136, 2, getCheckedValue(i21)}, null, null);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                int i22 = DataCanbus.DATA[122];
                DataCanbus.PROXY.cmd(2, new int[]{136, 7, getCheckedValue(i22)}, null, null);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                int i23 = DataCanbus.DATA[123];
                DataCanbus.PROXY.cmd(2, new int[]{136, 8, getCheckedValue(i23)}, null, null);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                int i24 = DataCanbus.DATA[124];
                DataCanbus.PROXY.cmd(2, new int[]{136, 9, getCheckedValue(i24)}, null, null);
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                int i25 = DataCanbus.DATA[139];
                DataCanbus.PROXY.cmd(2, new int[]{136, 33, getCheckedValue(i25)}, null, null);
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                int i26 = DataCanbus.DATA[140];
                DataCanbus.PROXY.cmd(2, new int[]{136, 34, getCheckedValue(i26)}, null, null);
                break;
            case R.id.ctv_checkedtext16 /* 2131427641 */:
                int i27 = DataCanbus.DATA[145];
                DataCanbus.PROXY.cmd(2, new int[]{136, 12, getCheckedValue(i27)}, null, null);
                break;
            case R.id.ctv_checkedtext17 /* 2131427642 */:
                int i28 = DataCanbus.DATA[144];
                DataCanbus.PROXY.cmd(2, new int[]{136, 13, getCheckedValue(i28)}, null, null);
                break;
            case R.id.ctv_checkedtext18 /* 2131427764 */:
                int i29 = DataCanbus.DATA[149];
                DataCanbus.PROXY.cmd(2, new int[]{136, 14, getCheckedValue(i29)}, null, null);
                break;
            case R.id.ctv_checkedtext19 /* 2131427766 */:
                int i30 = DataCanbus.DATA[148];
                DataCanbus.PROXY.cmd(2, new int[]{136, 15, getCheckedValue(i30)}, null, null);
                break;
            case R.id.ctv_checkedtext20 /* 2131427768 */:
                int i31 = DataCanbus.DATA[147];
                DataCanbus.PROXY.cmd(2, new int[]{136, 16, getCheckedValue(i31)}, null, null);
                break;
            case R.id.ctv_checkedtext21 /* 2131427770 */:
                int i32 = DataCanbus.DATA[146];
                DataCanbus.PROXY.cmd(2, new int[]{136, 23, getCheckedValue(i32)}, null, null);
                break;
            case R.id.ctv_checkedtext22 /* 2131427772 */:
                int i33 = DataCanbus.DATA[150];
                DataCanbus.PROXY.cmd(2, new int[]{136, 18, getCheckedValue(i33)}, null, null);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[103] & 255;
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
        }
    }

    protected void OnekeyturnMode(int i) {
        int temp = DataCanbus.DATA[126];
        if (i < 0) {
            if (temp > 0) {
                temp--;
            }
        } else if (i > 0 && temp < 3) {
            temp++;
        }
        DataCanbus.PROXY.cmd(2, new int[]{136, 4, temp}, null, null);
    }

    protected void FrontLightDelayMode(int i) {
        int temp = DataCanbus.DATA[125];
        if (i < 0) {
            if (temp > 0) {
                temp--;
            }
        } else if (i > 0 && temp < 4) {
            temp++;
        }
        DataCanbus.PROXY.cmd(2, new int[]{136, 3, temp}, null, null);
    }

    protected void ShoeRestoreCarSetDialog() {
        AlertDialog.Builder normalDialog = new AlertDialog.Builder(this);
        normalDialog.setTitle(R.string.str_gs4_setting0);
        normalDialog.setMessage(R.string.str_gs4_setting0);
        normalDialog.setPositiveButton(R.string.wc_psa_all_confirm, new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnBNRCS75Act.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                DataCanbus.PROXY.cmd(2, new int[]{136, 255, 0}, null, null);
            }
        });
        normalDialog.setNegativeButton(R.string.wc_psa_all_cancel, new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnBNRCS75Act.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        normalDialog.show();
    }

    protected void maintenanceCarSetDialog() {
        AlertDialog.Builder normalDialog = new AlertDialog.Builder(this);
        normalDialog.setTitle(R.string.str_other_set_Maintenance_Reset);
        normalDialog.setMessage(R.string.str_other_set_Maintenance_Reset);
        normalDialog.setPositiveButton(R.string.wc_psa_all_confirm, new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnBNRCS75Act.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                DataCanbus.PROXY.cmd(2, new int[]{136, 10, 0}, null, null);
            }
        });
        normalDialog.setNegativeButton(R.string.wc_psa_all_cancel, new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.xp.cs75.ChangAnBNRCS75Act.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        normalDialog.show();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(5, new int[]{102, 0}, null, null);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
    }

    private int getCheckedValue(int i) {
        return i == 1 ? 0 : 1;
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCurTripOilExpend() {
        if (((TextView) findViewById(R.id.tv_text9)) != null) {
            int value = DataCanbus.DATA[101];
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_oil_signal_normal);
            } else {
                ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_oil_signal_low);
            }
        }
    }

    protected void uLightOnKeyTurn(int i) {
        switch (i) {
            case 1:
                ((TextView) findViewById(R.id.tv_text3)).setText("3 times");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text3)).setText("5 times");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text3)).setText("7 times");
                break;
            default:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.jeep_comfortsystems_0);
                break;
        }
    }

    protected void uLightFrontDelay(int i) {
        switch (i) {
            case 1:
                ((TextView) findViewById(R.id.tv_text2)).setText("10s");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text2)).setText("30s");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text2)).setText("60s");
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_text2)).setText("120s");
                break;
            default:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.jeep_comfortsystems_0);
                break;
        }
    }

    protected void uAirAutoDry(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext13)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setChecked(i == 1);
        }
    }

    protected void uOpenWindowToWind(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext12)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setChecked(i == 1);
        }
    }

    protected void uAutoAir(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext11)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setChecked(i == 1);
        }
    }

    protected void uAccOffLock(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext9)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(i == 1);
        }
    }

    protected void uDriveLock(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext8)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(i == 1);
        }
    }

    protected void uRemoteUnlock(int i) {
        if (((TextView) findViewById(R.id.tv_text11)) != null) {
            switch (i) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text11)).setText(R.string.wc_ruiteng_string_unlock_mode_1);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text11)).setText(R.string.wc_ruiteng_string_unlock_mode_0);
                    break;
            }
        }
    }

    protected void uRestoreCarSet(int i) {
    }

    protected void uFoldRearMirror(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(i == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingMileage() {
        if (((TextView) findViewById(R.id.tv_text10)) != null) {
            int value = DataCanbus.DATA[100];
            String str = "0";
            if (value >= 0) {
                if (value > 8191) {
                    str = "--";
                } else {
                    str = new StringBuilder(String.valueOf(value)).toString();
                }
            }
            ((TextView) findViewById(R.id.tv_text10)).setText(String.valueOf(str) + " KM");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCurOilExpend() {
        this.mMode = DataCanbus.DATA[98];
        showModeState(this.mMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCurOptimalOilExpend() {
        int oilReminder = DataCanbus.DATA[99];
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext1), oilReminder == 1);
    }

    private void setMode(int mode) {
        this.mMode += mode;
        if (this.mMode <= 0) {
            this.mMode = 3;
        } else if (this.mMode > 3) {
            this.mMode = 1;
        }
        DataCanbus.PROXY.cmd(0, new int[]{this.mMode}, null, null);
        showModeState(this.mMode);
    }

    private void showModeState(int mode) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (mode) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_mode_normal);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_mode_paraller);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_mode_close);
                    break;
            }
        }
    }
}
