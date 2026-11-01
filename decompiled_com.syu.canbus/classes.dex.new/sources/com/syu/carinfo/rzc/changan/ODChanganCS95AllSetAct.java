package com.syu.carinfo.rzc.changan;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ODChanganCS95AllSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.changan.ODChanganCS95AllSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    ODChanganCS95AllSetAct.this.uFoldRearMirror(DataCanbus.DATA[updateCode]);
                    break;
                case 99:
                    ODChanganCS95AllSetAct.this.mUpdaterDrivingMileage();
                    break;
                case 100:
                    ODChanganCS95AllSetAct.this.mUpdaterValue8();
                    break;
                case 101:
                    ODChanganCS95AllSetAct.this.uRemoteUnlock(DataCanbus.DATA[updateCode]);
                    break;
                case 102:
                    ODChanganCS95AllSetAct.this.uDriveLock(DataCanbus.DATA[updateCode]);
                    break;
                case 103:
                    ODChanganCS95AllSetAct.this.uAccOffLock(DataCanbus.DATA[updateCode]);
                    break;
                case 104:
                    ODChanganCS95AllSetAct.this.uLightFrontDelay(DataCanbus.DATA[updateCode]);
                    break;
                case 105:
                    ODChanganCS95AllSetAct.this.uLightOnKeyTurn(DataCanbus.DATA[updateCode]);
                    break;
                case 106:
                    ODChanganCS95AllSetAct.this.uBackRainAssist(DataCanbus.DATA[updateCode]);
                    break;
                case 107:
                    ODChanganCS95AllSetAct.this.uAutoAir(DataCanbus.DATA[updateCode]);
                    break;
                case 108:
                    ODChanganCS95AllSetAct.this.uOpenWindowToWind(DataCanbus.DATA[updateCode]);
                    break;
                case 109:
                    ((CheckedTextView) ODChanganCS95AllSetAct.this.findViewById(R.id.ctv_checkedtext10)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
                case 110:
                    ((CheckedTextView) ODChanganCS95AllSetAct.this.findViewById(R.id.ctv_checkedtext11)).setChecked(value == 1);
                    break;
                case 111:
                    ((CheckedTextView) ODChanganCS95AllSetAct.this.findViewById(R.id.ctv_checkedtext12)).setChecked(value == 1);
                    break;
                case 112:
                    ((CheckedTextView) ODChanganCS95AllSetAct.this.findViewById(R.id.ctv_checkedtext13)).setChecked(value == 1);
                    break;
                case 113:
                    ((CheckedTextView) ODChanganCS95AllSetAct.this.findViewById(R.id.ctv_checkedtext14)).setChecked(value == 1);
                    break;
                case 114:
                    ((CheckedTextView) ODChanganCS95AllSetAct.this.findViewById(R.id.ctv_checkedtext15)).setChecked(value == 1);
                    break;
                case 115:
                    ((CheckedTextView) ODChanganCS95AllSetAct.this.findViewById(R.id.ctv_checkedtext16)).setChecked(value == 1);
                    break;
                case 116:
                    ((CheckedTextView) ODChanganCS95AllSetAct.this.findViewById(R.id.ctv_checkedtext17)).setChecked(value == 1);
                    break;
                case 117:
                    ((CheckedTextView) ODChanganCS95AllSetAct.this.findViewById(R.id.ctv_checkedtext18)).setChecked(value == 1);
                    break;
                case 118:
                    switch (value) {
                        case 0:
                            ((TextView) ODChanganCS95AllSetAct.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_high);
                            break;
                        case 1:
                            ((TextView) ODChanganCS95AllSetAct.this.findViewById(R.id.tv_text3)).setText(R.string.wc_golf_normal);
                            break;
                        case 2:
                            ((TextView) ODChanganCS95AllSetAct.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_low);
                            break;
                    }
                    break;
                case 119:
                    switch (value) {
                        case 0:
                            ((TextView) ODChanganCS95AllSetAct.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) ODChanganCS95AllSetAct.this.findViewById(R.id.tv_text4)).setText("仅识别提示");
                            break;
                        case 2:
                            ((TextView) ODChanganCS95AllSetAct.this.findViewById(R.id.tv_text4)).setText("仅消失提示");
                            break;
                        case 3:
                            ((TextView) ODChanganCS95AllSetAct.this.findViewById(R.id.tv_text4)).setText("识别和消失均提示");
                            break;
                    }
                    break;
                case 120:
                    ((TextView) ODChanganCS95AllSetAct.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                    break;
                case 121:
                    ((CheckedTextView) ODChanganCS95AllSetAct.this.findViewById(R.id.ctv_checkedtext20)).setChecked(value == 1);
                    break;
                case 122:
                    ((CheckedTextView) ODChanganCS95AllSetAct.this.findViewById(R.id.ctv_checkedtext21)).setChecked(value == 1);
                    break;
                case 123:
                    ((CheckedTextView) ODChanganCS95AllSetAct.this.findViewById(R.id.ctv_checkedtext22)).setChecked(value == 1);
                    break;
                case 124:
                    ((CheckedTextView) ODChanganCS95AllSetAct.this.findViewById(R.id.ctv_checkedtext23)).setChecked(value == 1);
                    break;
                case 125:
                    switch (value) {
                        case 0:
                            ((TextView) ODChanganCS95AllSetAct.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_high);
                            break;
                        case 1:
                            ((TextView) ODChanganCS95AllSetAct.this.findViewById(R.id.tv_text6)).setText(R.string.wc_golf_normal);
                            break;
                    }
                    break;
                case 126:
                    ((CheckedTextView) ODChanganCS95AllSetAct.this.findViewById(R.id.ctv_checkedtext19)).setChecked(value == 1);
                    break;
                case 127:
                    ((CheckedTextView) ODChanganCS95AllSetAct.this.findViewById(R.id.ctv_checkedtext24)).setChecked(value == 1);
                    break;
                case 128:
                    ((CheckedTextView) ODChanganCS95AllSetAct.this.findViewById(R.id.ctv_checkedtext25)).setChecked(value == 1);
                    break;
                case 129:
                    switch (value) {
                        case 0:
                            ((TextView) ODChanganCS95AllSetAct.this.findViewById(R.id.tv_text7)).setText(R.string.wc_golf_normal);
                            break;
                        case 1:
                            ((TextView) ODChanganCS95AllSetAct.this.findViewById(R.id.tv_text7)).setText(R.string.wc_golf_comfort);
                            break;
                    }
                    break;
                case 130:
                    ((TextView) ODChanganCS95AllSetAct.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                    break;
                case 131:
                    ((TextView) ODChanganCS95AllSetAct.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                    break;
                case 132:
                    switch (value) {
                        case 0:
                            ((TextView) ODChanganCS95AllSetAct.this.findViewById(R.id.tv_text10)).setText(R.string.wc_372_low);
                            break;
                        case 1:
                            ((TextView) ODChanganCS95AllSetAct.this.findViewById(R.id.tv_text10)).setText(R.string.wc_372_mid);
                            break;
                        case 2:
                            ((TextView) ODChanganCS95AllSetAct.this.findViewById(R.id.tv_text10)).setText(R.string.wc_372_high);
                            break;
                    }
                    break;
                case 133:
                    ((TextView) ODChanganCS95AllSetAct.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_od_changan_cs95_setfunc);
        initview();
    }

    private void initview() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext23), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext24), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext25), this);
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
        setSelfClick((Button) findViewById(R.id.btn_minus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
        setSelfClick((Button) findViewById(R.id.btn_minus10), this);
        setSelfClick((Button) findViewById(R.id.btn_plus10), this);
        setSelfClick((Button) findViewById(R.id.btn_minus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                FrontLightDelayMode(-1);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                FrontLightDelayMode(1);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                OnekeyturnMode(-1);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                OnekeyturnMode(1);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int i = DataCanbus.DATA[118] - 1;
                if (i < 0) {
                    i = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{16, i}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int i2 = DataCanbus.DATA[118] + 1;
                if (i2 > 2) {
                    i2 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{16, i2}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int i3 = DataCanbus.DATA[119] - 1;
                if (i3 < 0) {
                    i3 = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{18, i3}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int i4 = DataCanbus.DATA[119] + 1;
                if (i4 > 3) {
                    i4 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{18, i4}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int i5 = DataCanbus.DATA[120] - 1;
                if (i5 < 0) {
                    i5 = 6;
                }
                DataCanbus.PROXY.cmd(1, new int[]{19, i5}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int i6 = DataCanbus.DATA[120] + 1;
                if (i6 > 6) {
                    i6 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{19, i6}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int i7 = DataCanbus.DATA[125] - 1;
                if (i7 < 0) {
                    i7 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{32, i7}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int i8 = DataCanbus.DATA[125] + 1;
                if (i8 > 1) {
                    i8 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{32, i8}, null, null);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int i9 = DataCanbus.DATA[129] - 1;
                if (i9 < 0) {
                    i9 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{41, i9}, null, null);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int i10 = DataCanbus.DATA[129] + 1;
                if (i10 > 1) {
                    i10 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{41, i10}, null, null);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int i11 = DataCanbus.DATA[130] - 1;
                if (i11 < 1) {
                    i11 = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{42, i11}, null, null);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int i12 = DataCanbus.DATA[130] + 1;
                if (i12 > 3) {
                    i12 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{42, i12}, null, null);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int i13 = DataCanbus.DATA[131] - 1;
                if (i13 < 1) {
                    i13 = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{43, i13}, null, null);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int i14 = DataCanbus.DATA[131] + 1;
                if (i14 > 3) {
                    i14 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{43, i14}, null, null);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int i15 = DataCanbus.DATA[132] - 1;
                if (i15 < 1) {
                    i15 = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{44, i15}, null, null);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int i16 = DataCanbus.DATA[132] + 1;
                if (i16 > 3) {
                    i16 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{44, i16}, null, null);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int i17 = DataCanbus.DATA[133] - 1;
                if (i17 < 1) {
                    i17 = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{45, i17}, null, null);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int i18 = DataCanbus.DATA[133] + 1;
                if (i18 > 3) {
                    i18 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{45, i18}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value = DataCanbus.DATA[100] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(0, iArr, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                DataCanbus.PROXY.cmd(1, new int[]{0, getCheckedValue(DataCanbus.DATA[101])}, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                DataCanbus.PROXY.cmd(1, new int[]{1, getCheckedValue(DataCanbus.DATA[102])}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                ShoeRestoreCarSetDialog();
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int i19 = DataCanbus.DATA[98];
                if (DataCanbus.DATA[1000] == 13566407) {
                    DataCanbus.PROXY.cmd(1, new int[]{40, getCheckedValue(i19)}, null, null);
                } else {
                    if (i19 == 1) {
                        i19 = 0;
                    } else if (i19 == 0) {
                        i19 = 64;
                    }
                    DataCanbus.PROXY.cmd(3, new int[]{4, i19}, null, null);
                }
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                DataCanbus.PROXY.cmd(1, new int[]{2, getCheckedValue(DataCanbus.DATA[103])}, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                DataCanbus.PROXY.cmd(1, new int[]{6, getCheckedValue(DataCanbus.DATA[106])}, null, null);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                DataCanbus.PROXY.cmd(1, new int[]{7, getCheckedValue(DataCanbus.DATA[107])}, null, null);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                DataCanbus.PROXY.cmd(1, new int[]{8, getCheckedValue(DataCanbus.DATA[108])}, null, null);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                DataCanbus.PROXY.cmd(1, new int[]{9, getCheckedValue(DataCanbus.DATA[109])}, null, null);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                DataCanbus.PROXY.cmd(1, new int[]{31, getCheckedValue(DataCanbus.DATA[110])}, null, null);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                DataCanbus.PROXY.cmd(1, new int[]{34, getCheckedValue(DataCanbus.DATA[111])}, null, null);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                DataCanbus.PROXY.cmd(1, new int[]{38, getCheckedValue(DataCanbus.DATA[112])}, null, null);
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                DataCanbus.PROXY.cmd(1, new int[]{35, getCheckedValue(DataCanbus.DATA[113])}, null, null);
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                DataCanbus.PROXY.cmd(1, new int[]{36, getCheckedValue(DataCanbus.DATA[114])}, null, null);
                break;
            case R.id.ctv_checkedtext16 /* 2131427641 */:
                DataCanbus.PROXY.cmd(1, new int[]{37, getCheckedValue(DataCanbus.DATA[115])}, null, null);
                break;
            case R.id.ctv_checkedtext17 /* 2131427642 */:
                DataCanbus.PROXY.cmd(1, new int[]{39, getCheckedValue(DataCanbus.DATA[116])}, null, null);
                break;
            case R.id.ctv_checkedtext18 /* 2131427764 */:
                DataCanbus.PROXY.cmd(1, new int[]{15, getCheckedValue(DataCanbus.DATA[117])}, null, null);
                break;
            case R.id.ctv_checkedtext19 /* 2131427766 */:
                DataCanbus.PROXY.cmd(1, new int[]{14, getCheckedValue(DataCanbus.DATA[126])}, null, null);
                break;
            case R.id.ctv_checkedtext20 /* 2131427768 */:
                DataCanbus.PROXY.cmd(1, new int[]{24, getCheckedValue(DataCanbus.DATA[121])}, null, null);
                break;
            case R.id.ctv_checkedtext21 /* 2131427770 */:
                DataCanbus.PROXY.cmd(1, new int[]{30, getCheckedValue(DataCanbus.DATA[122])}, null, null);
                break;
            case R.id.ctv_checkedtext22 /* 2131427772 */:
                DataCanbus.PROXY.cmd(1, new int[]{28, getCheckedValue(DataCanbus.DATA[123])}, null, null);
                break;
            case R.id.ctv_checkedtext23 /* 2131427775 */:
                DataCanbus.PROXY.cmd(1, new int[]{29, getCheckedValue(DataCanbus.DATA[124])}, null, null);
                break;
            case R.id.ctv_checkedtext24 /* 2131427780 */:
                DataCanbus.PROXY.cmd(1, new int[]{46, getCheckedValue(DataCanbus.DATA[127])}, null, null);
                break;
            case R.id.ctv_checkedtext25 /* 2131427782 */:
                DataCanbus.PROXY.cmd(1, new int[]{33, getCheckedValue(DataCanbus.DATA[128])}, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(4, new int[]{102}, null, null);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
    }

    private int getCheckedValue(int i) {
        return i == 1 ? 0 : 1;
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[100] & 255;
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
        }
    }

    protected void OnekeyturnMode(int i) {
        int temp = DataCanbus.DATA[105];
        if (i < 0) {
            if (temp > 0) {
                temp--;
            }
        } else if (i > 0 && temp < 3) {
            temp++;
        }
        DataCanbus.PROXY.cmd(1, new int[]{4, temp}, null, null);
    }

    protected void FrontLightDelayMode(int i) {
        int temp = DataCanbus.DATA[104];
        if (i < 0) {
            if (temp > 0) {
                temp--;
            }
        } else if (i > 0 && temp < 4) {
            temp++;
        }
        DataCanbus.PROXY.cmd(1, new int[]{3, temp}, null, null);
    }

    protected void ShoeRestoreCarSetDialog() {
        AlertDialog.Builder normalDialog = new AlertDialog.Builder(this);
        normalDialog.setTitle(R.string.str_gs4_setting0);
        normalDialog.setMessage(R.string.str_gs4_setting0);
        normalDialog.setPositiveButton(R.string.wc_psa_all_confirm, new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.ODChanganCS95AllSetAct.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                DataCanbus.PROXY.cmd(1, new int[]{255, 0}, null, null);
            }
        });
        normalDialog.setNegativeButton(R.string.wc_psa_all_cancel, new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.ODChanganCS95AllSetAct.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        normalDialog.show();
    }

    protected void uLightOnKeyTurn(int i) {
        switch (i) {
            case 1:
                ((TextView) findViewById(R.id.tv_text2)).setText("3 times");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text2)).setText("5 times");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text2)).setText("7 times");
                break;
            default:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.jeep_comfortsystems_0);
                break;
        }
    }

    protected void uLightFrontDelay(int i) {
        switch (i) {
            case 1:
                ((TextView) findViewById(R.id.tv_text1)).setText("10s");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text1)).setText("30s");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text1)).setText("60s");
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_text1)).setText("120s");
                break;
            default:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.jeep_comfortsystems_0);
                break;
        }
    }

    protected void uOpenWindowToWind(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext9)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(i == 1);
        }
    }

    protected void uAutoAir(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext8)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(i == 1);
        }
    }

    protected void uAccOffLock(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(i == 1);
        }
    }

    protected void uDriveLock(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(i == 1);
        }
    }

    protected void uRemoteUnlock(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(i == 1);
        }
    }

    protected void uBackRainAssist(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext7)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(i == 1);
        }
    }

    protected void uFoldRearMirror(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(i == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingMileage() {
        if (((TextView) findViewById(R.id.rzc_xp_cs75_tv_mileage_last)) != null) {
            int value = DataCanbus.DATA[99];
            String str = "0";
            if (value >= 0) {
                if (value > 8191) {
                    str = "--";
                } else {
                    str = new StringBuilder(String.valueOf(value)).toString();
                }
            }
            ((TextView) findViewById(R.id.rzc_xp_cs75_tv_mileage_last)).setText(String.valueOf(str) + " KM");
        }
    }
}
