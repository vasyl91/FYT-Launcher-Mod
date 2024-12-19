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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Rzc_YingFeiNiDi_GX50_CarSettingAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.yingfeinidi_gx50.Rzc_YingFeiNiDi_GX50_CarSettingAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 26:
                    Rzc_YingFeiNiDi_GX50_CarSettingAct.this.updateAutoLighUnlockt();
                    break;
                case 27:
                    Rzc_YingFeiNiDi_GX50_CarSettingAct.this.updateAutoLightSensor();
                    break;
                case 28:
                    Rzc_YingFeiNiDi_GX50_CarSettingAct.this.updateAutoLightTime();
                    break;
                case 29:
                    Rzc_YingFeiNiDi_GX50_CarSettingAct.this.updateSelectUnlock();
                    break;
                case 30:
                    Rzc_YingFeiNiDi_GX50_CarSettingAct.this.updateKeyUnlock();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_rzc_yingfeinidi_gx50_carsetting);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View arg0) {
        int id = arg0.getId();
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[26];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 1;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[27];
                int value3 = value2 - 1;
                if (value3 < 1) {
                    value3 = 4;
                }
                DataCanbus.PROXY.cmd(1, new int[]{2, value3}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value4 = DataCanbus.DATA[27];
                int value5 = value4 + 1;
                if (value5 > 4) {
                    value5 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{2, value5}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value6 = DataCanbus.DATA[28];
                int value7 = value6 - 1;
                if (value7 < 0) {
                    value7 = 7;
                }
                DataCanbus.PROXY.cmd(1, new int[]{3, value7}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value8 = DataCanbus.DATA[28];
                int value9 = value8 + 1;
                if (value9 > 7) {
                    value9 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{3, value9}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value10 = DataCanbus.DATA[29];
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 4;
                iArr2[1] = value10 == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(1, iArr2, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value11 = DataCanbus.DATA[30];
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[2];
                iArr3[0] = 5;
                iArr3[1] = value11 == 0 ? 1 : 0;
                remoteModuleProxy3.cmd(1, iArr3, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateKeyUnlock() {
        int value = DataCanbus.DATA[30];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSelectUnlock() {
        int value = DataCanbus.DATA[29];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
    }

    protected void updateAutoLightTime() {
        int value = DataCanbus.DATA[28];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_ruiteng_string_time_12);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_ruiteng_string_time_0);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_ruiteng_string_time_11);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_ruiteng_string_time_1);
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_ruiteng_string_time_2);
                break;
            case 5:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_ruiteng_string_time_3);
                break;
            case 6:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_ruiteng_string_time_4);
                break;
            case 7:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_ruiteng_string_time_5);
                break;
        }
    }

    protected void updateAutoLightSensor() {
        int value = DataCanbus.DATA[27];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_372_volumestr1);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_372_volumestr2);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_372_volumestr3);
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_372_volumestr4);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoLighUnlockt() {
        int value = DataCanbus.DATA[26];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
    }
}
