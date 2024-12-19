package com.syu.carinfo.wc.ziyouguang;

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
public class Wc_372_OtherSettingsActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode] & 65535;
            switch (updateCode) {
                case 138:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view1).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.ctv_checkedtext1)).setChecked((value & 255) == 1);
                    break;
                case 139:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view2).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.ctv_checkedtext2)).setChecked((value & 255) == 1);
                    break;
                case 140:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view3).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.ctv_checkedtext3)).setChecked((value & 255) == 1);
                    break;
                case 141:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view4).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.ctv_checkedtext4)).setChecked((value & 255) == 1);
                    break;
                case 142:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view5).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.ctv_checkedtext5)).setChecked((value & 255) == 1);
                    break;
                case 143:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view6).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.ctv_checkedtext6)).setChecked((value & 255) == 1);
                    break;
                case 144:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view7).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.ctv_checkedtext7)).setChecked((value & 255) == 1);
                    break;
                case 145:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view8).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.ctv_checkedtext8)).setChecked((value & 255) == 1);
                    break;
                case 146:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view9).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.ctv_checkedtext9)).setChecked((value & 255) == 1);
                    break;
                case 147:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view10).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.ctv_checkedtext10)).setChecked((value & 255) == 1);
                    break;
                case 148:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view11).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.ctv_checkedtext11)).setChecked((value & 255) == 1);
                    break;
                case 149:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view12).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    if (((TextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.tv_text1)) != null) {
                        int num = (value & 255) + 1;
                        ((TextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(num).toString());
                        break;
                    }
                case 150:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view13).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    if (((TextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value & 255) {
                            case 0:
                                ((TextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.tv_text2)).setText(R.string.str_mild_electric_brake);
                                break;
                            case 1:
                                ((TextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.tv_text2)).setText(R.string.str_heavy_electric_brake);
                                break;
                            case 2:
                                ((TextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.tv_text2)).setText(R.string.str_mild_electric_hydraulic_brake);
                                break;
                            case 3:
                                ((TextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.tv_text2)).setText(R.string.str_heavy_electric_hydraulic_brake);
                                break;
                        }
                    }
                    break;
                case 151:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view14).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.ctv_checkedtext12)).setChecked((value & 255) == 1);
                    break;
                case 152:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view15).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.ctv_checkedtext13)).setChecked((value & 255) == 1);
                    break;
                case 153:
                    Wc_372_OtherSettingsActi.this.findViewById(R.id.layout_view16).setVisibility(((value & 65280) >> 8) != 0 ? 0 : 8);
                    ((CheckedTextView) Wc_372_OtherSettingsActi.this.findViewById(R.id.ctv_checkedtext14)).setChecked((value & 255) == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_372_zyg_othersettings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[149] & 255) - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{80, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[149] & 255) + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{80, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[150] & 255) - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{81, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = (DataCanbus.DATA[150] & 255) + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{81, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[138] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 16;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[139] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 48;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[140] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 32;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[141] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 33;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[142] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 64;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[143] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 65;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[144] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 66;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[145] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 67;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[146] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 68;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[147] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 69;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[148] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 70;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[151] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 96;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[152] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 97;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc.ziyouguang.Wc_372_OtherSettingsActi.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[153] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 98;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(10, new int[]{100}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
    }
}
