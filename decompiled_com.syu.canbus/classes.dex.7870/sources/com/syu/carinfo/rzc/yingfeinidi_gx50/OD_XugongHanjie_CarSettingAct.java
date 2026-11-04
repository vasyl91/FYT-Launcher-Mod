package com.syu.carinfo.rzc.yingfeinidi_gx50;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class OD_XugongHanjie_CarSettingAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.yingfeinidi_gx50.OD_XugongHanjie_CarSettingAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    ((TextView) OD_XugongHanjie_CarSettingAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                    break;
                case 99:
                    switch (value) {
                        case 0:
                            ((TextView) OD_XugongHanjie_CarSettingAct.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) OD_XugongHanjie_CarSettingAct.this.findViewById(R.id.tv_text2)).setText("30s");
                            break;
                        case 2:
                            ((TextView) OD_XugongHanjie_CarSettingAct.this.findViewById(R.id.tv_text2)).setText("60s");
                            break;
                        case 3:
                            ((TextView) OD_XugongHanjie_CarSettingAct.this.findViewById(R.id.tv_text2)).setText("90s");
                            break;
                    }
                    break;
                case 100:
                    switch (value) {
                        case 0:
                            ((TextView) OD_XugongHanjie_CarSettingAct.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_low);
                            break;
                        case 1:
                            ((TextView) OD_XugongHanjie_CarSettingAct.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_middle);
                            break;
                        case 2:
                            ((TextView) OD_XugongHanjie_CarSettingAct.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_high);
                            break;
                    }
                    break;
                case 101:
                    ((CheckedTextView) OD_XugongHanjie_CarSettingAct.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
                    break;
                case 102:
                    switch (value) {
                        case 0:
                            ((TextView) OD_XugongHanjie_CarSettingAct.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) OD_XugongHanjie_CarSettingAct.this.findViewById(R.id.tv_text4)).setText("30s");
                            break;
                        case 2:
                            ((TextView) OD_XugongHanjie_CarSettingAct.this.findViewById(R.id.tv_text4)).setText("60s");
                            break;
                        case 3:
                            ((TextView) OD_XugongHanjie_CarSettingAct.this.findViewById(R.id.tv_text4)).setText("90s");
                            break;
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0456_od_xugong_qingka_carsetting);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View arg0) {
        int id = arg0.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427417 */:
                int value = DataCanbus.DATA[98] - 1;
                if (value < 0) {
                    value = 15;
                }
                DataCanbus.PROXY.cmd(1, new int[]{1, value}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int value2 = DataCanbus.DATA[98] + 1;
                if (value2 > 15) {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{1, value2}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int value3 = DataCanbus.DATA[99] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{2, value3}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int value4 = DataCanbus.DATA[99] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{2, value4}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427425 */:
                int value5 = DataCanbus.DATA[100] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{3, value5}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                int value6 = DataCanbus.DATA[100] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{3, value6}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427428 */:
                int value7 = DataCanbus.DATA[102] + 1;
                if (value7 > 3) {
                    value7 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{5, value7}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427473 */:
                int value8 = DataCanbus.DATA[102] - 1;
                if (value8 < 0) {
                    value8 = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{5, value8}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427548 */:
                int value9 = DataCanbus.DATA[101];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 4;
                iArr[1] = value9 == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
    }
}
