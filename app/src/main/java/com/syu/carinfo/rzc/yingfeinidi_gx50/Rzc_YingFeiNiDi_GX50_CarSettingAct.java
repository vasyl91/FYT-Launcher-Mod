package com.syu.carinfo.rzc.yingfeinidi_gx50;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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
public class Rzc_YingFeiNiDi_GX50_CarSettingAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    Rzc_YingFeiNiDi_GX50_CarSettingAct.this.updateAutoLighUnlockt();
                    break;
                case 100:
                    Rzc_YingFeiNiDi_GX50_CarSettingAct.this.updateAutoLightSensor();
                    break;
                case 101:
                    Rzc_YingFeiNiDi_GX50_CarSettingAct.this.updateAutoLightTime();
                    break;
                case 102:
                    Rzc_YingFeiNiDi_GX50_CarSettingAct.this.updateSelectUnlock();
                    break;
                case 103:
                    Rzc_YingFeiNiDi_GX50_CarSettingAct.this.updateKeyUnlock();
                    break;
                case 117:
                    ((CheckedTextView) Rzc_YingFeiNiDi_GX50_CarSettingAct.this.findViewById(R.id.ctv_checkedtext7)).setChecked(value != 0);
                    break;
                case 118:
                    ((TextView) Rzc_YingFeiNiDi_GX50_CarSettingAct.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                    ((TextView) Rzc_YingFeiNiDi_GX50_CarSettingAct.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                    break;
                case 119:
                    ((TextView) Rzc_YingFeiNiDi_GX50_CarSettingAct.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                    break;
                case 120:
                    ((CheckedTextView) Rzc_YingFeiNiDi_GX50_CarSettingAct.this.findViewById(R.id.ctv_checkedtext8)).setChecked(value != 0);
                    break;
                case 121:
                    ((CheckedTextView) Rzc_YingFeiNiDi_GX50_CarSettingAct.this.findViewById(R.id.ctv_checkedtext9)).setChecked(value != 0);
                    break;
                case 122:
                    ((CheckedTextView) Rzc_YingFeiNiDi_GX50_CarSettingAct.this.findViewById(R.id.ctv_checkedtext10)).setChecked(value != 0);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_rzc_yingfeinidi_gx50_carsetting);
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {
        int id = arg0.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[100] - 1;
                if (value < 1) {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(1, new int[]{2, value}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[100] + 1;
                if (value2 > 4) {
                    value2 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{2, value2}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[101] - 1;
                if (value3 < 0) {
                    value3 = 7;
                }
                DataCanbus.PROXY.cmd(1, new int[]{3, value3}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[101] + 1;
                if (value4 > 7) {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{3, value4}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                DataCanbus.PROXY.cmd(1, new int[]{7, 2}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                DataCanbus.PROXY.cmd(1, new int[]{7, 1}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                DataCanbus.PROXY.cmd(1, new int[]{8, 2}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                DataCanbus.PROXY.cmd(1, new int[]{8, 1}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value5 = DataCanbus.DATA[118] - 1;
                if (value5 < 1) {
                    value5 = 4;
                }
                DataCanbus.PROXY.cmd(1, new int[]{149, value5}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value6 = DataCanbus.DATA[118] + 1;
                if (value6 > 4) {
                    value6 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{149, value6}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value7 = DataCanbus.DATA[99];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 1;
                iArr[1] = value7 == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value8 = DataCanbus.DATA[102];
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 4;
                iArr2[1] = value8 == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(1, iArr2, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value9 = DataCanbus.DATA[103];
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[2];
                iArr3[0] = 5;
                iArr3[1] = value9 == 0 ? 1 : 0;
                remoteModuleProxy3.cmd(1, iArr3, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, Rzc_Infiniti_CarinfoAct.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                try {
                    Intent intent2 = new Intent();
                    intent2.setClass(this, Rzc_Infiniti_CarTireAct.class);
                    startActivity(intent2);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                try {
                    Intent intent3 = new Intent();
                    intent3.setClass(this, Rzc_Infeiniti_EQSetAct.class);
                    startActivity(intent3);
                    break;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value10 = DataCanbus.DATA[117];
                RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                int[] iArr4 = new int[2];
                iArr4[0] = 6;
                iArr4[1] = value10 == 0 ? 1 : 0;
                remoteModuleProxy4.cmd(1, iArr4, null, null);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value11 = DataCanbus.DATA[120];
                RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                int[] iArr5 = new int[2];
                iArr5[0] = 11;
                iArr5[1] = value11 == 0 ? 1 : 0;
                remoteModuleProxy5.cmd(1, iArr5, null, null);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value12 = DataCanbus.DATA[121];
                RemoteModuleProxy remoteModuleProxy6 = DataCanbus.PROXY;
                int[] iArr6 = new int[2];
                iArr6[0] = 10;
                iArr6[1] = value12 == 0 ? 1 : 0;
                remoteModuleProxy6.cmd(1, iArr6, null, null);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int value13 = DataCanbus.DATA[122];
                RemoteModuleProxy remoteModuleProxy7 = DataCanbus.PROXY;
                int[] iArr7 = new int[2];
                iArr7[0] = 9;
                iArr7[1] = value13 == 0 ? 1 : 0;
                remoteModuleProxy7.cmd(1, iArr7, null, null);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                try {
                    Intent intent4 = new Intent();
                    intent4.setClass(this, Rzc_Infeiniti_360ViewSetAct.class);
                    startActivity(intent4);
                    break;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                dialog(R.string.all_settings, 255);
                break;
        }
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(1, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(1, new int[]{i}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    
    public void updateKeyUnlock() {
        int value = DataCanbus.DATA[103];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
    }

    
    public void updateSelectUnlock() {
        int value = DataCanbus.DATA[102];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
    }

    protected void updateAutoLightTime() {
        int value = DataCanbus.DATA[101];
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
        int value = DataCanbus.DATA[100];
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

    
    public void updateAutoLighUnlockt() {
        int value = DataCanbus.DATA[99];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
    }
}
