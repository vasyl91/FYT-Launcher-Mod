package com.syu.carinfo.wc.gs4;

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
public class GS4OtherSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.gs4.GS4OtherSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 147:
                    if (value == 0) {
                        ((TextView) GS4OtherSetAct.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                    } else if (value == 1) {
                        ((TextView) GS4OtherSetAct.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_low);
                    } else if (value == 2) {
                        ((TextView) GS4OtherSetAct.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_middle);
                    } else if (value == 3) {
                        ((TextView) GS4OtherSetAct.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
                    }
                    break;
                case 148:
                    if (value == 0) {
                        ((TextView) GS4OtherSetAct.this.findViewById(R.id.tv_text2)).setText("NORMAL");
                    } else if (value == 1) {
                        ((TextView) GS4OtherSetAct.this.findViewById(R.id.tv_text2)).setText("SPORT");
                    } else if (value == 2) {
                        ((TextView) GS4OtherSetAct.this.findViewById(R.id.tv_text2)).setText("ECO");
                    }
                    break;
                case 149:
                    ((CheckedTextView) GS4OtherSetAct.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
                    break;
                case 150:
                    ((CheckedTextView) GS4OtherSetAct.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
                    break;
                case 151:
                    ((CheckedTextView) GS4OtherSetAct.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
                    break;
                case 152:
                    ((CheckedTextView) GS4OtherSetAct.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
                    break;
                case 153:
                    ((CheckedTextView) GS4OtherSetAct.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
                    break;
                case 154:
                    ((CheckedTextView) GS4OtherSetAct.this.findViewById(R.id.ctv_checkedtext6)).setChecked(value != 0);
                    break;
                case 155:
                    ((TextView) GS4OtherSetAct.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_289_wc_gs4_other_set);
        setUI();
    }

    private void setUI() {
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[147];
                int value2 = value - 1;
                if (value2 < 0) {
                    value2 = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{33, value2}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value3 = DataCanbus.DATA[147];
                int value4 = value3 + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{33, value4}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value5 = DataCanbus.DATA[148];
                int value6 = value5 - 1;
                if (value6 < 0) {
                    value6 = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{34, value6}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value7 = DataCanbus.DATA[148];
                int value8 = value7 + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{34, value8}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value9 = DataCanbus.DATA[155];
                int value10 = value9 - 1;
                if (value10 < 0) {
                    value10 = 12;
                }
                DataCanbus.PROXY.cmd(2, new int[]{39, value10}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value11 = DataCanbus.DATA[155];
                int value12 = value11 + 1;
                if (value12 > 12) {
                    value12 = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{39, value12}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value13 = DataCanbus.DATA[149];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 40;
                iArr[1] = value13 == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int value14 = DataCanbus.DATA[152];
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 36;
                iArr2[1] = value14 == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(2, iArr2, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int value15 = DataCanbus.DATA[153];
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[2];
                iArr3[0] = 37;
                iArr3[1] = value15 == 0 ? 1 : 0;
                remoteModuleProxy3.cmd(2, iArr3, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value16 = DataCanbus.DATA[150];
                RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                int[] iArr4 = new int[2];
                iArr4[0] = 41;
                iArr4[1] = value16 == 0 ? 1 : 0;
                remoteModuleProxy4.cmd(2, iArr4, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int value17 = DataCanbus.DATA[151];
                RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                int[] iArr5 = new int[2];
                iArr5[0] = 35;
                iArr5[1] = value17 == 0 ? 1 : 0;
                remoteModuleProxy5.cmd(2, iArr5, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int value18 = DataCanbus.DATA[154];
                RemoteModuleProxy remoteModuleProxy6 = DataCanbus.PROXY;
                int[] iArr6 = new int[2];
                iArr6[0] = 38;
                iArr6[1] = value18 == 0 ? 1 : 0;
                remoteModuleProxy6.cmd(2, iArr6, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
    }
}
