package com.syu.carinfo.xfy.guandao;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.accord9.wc.AccordConfig;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class GuandaoSetting2Act extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xfy.guandao.GuandaoSetting2Act.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 101:
                    GuandaoSetting2Act.this.mD0B04();
                    break;
                case 118:
                    GuandaoSetting2Act.this.mD0B02();
                    break;
                case 119:
                    GuandaoSetting2Act.this.mD0B00();
                    break;
                case 120:
                    GuandaoSetting2Act.this.mD5B06();
                    break;
                case 121:
                    GuandaoSetting2Act.this.mD5B05();
                    break;
                case 122:
                    GuandaoSetting2Act.this.mD5B04();
                    break;
                case 123:
                    GuandaoSetting2Act.this.mD5B03();
                    break;
                case 124:
                    GuandaoSetting2Act.this.mD5B02();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_425_guandao_settingse);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xfy.guandao.GuandaoSetting2Act.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[123] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 23;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_321_civic_message)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xfy.guandao.GuandaoSetting2Act.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[124] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 24;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xfy.guandao.GuandaoSetting2Act.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[122] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 22;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xfy.guandao.GuandaoSetting2Act.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[121] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 21;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xfy.guandao.GuandaoSetting2Act.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[120] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{20, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xfy.guandao.GuandaoSetting2Act.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[120] & 255;
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{20, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xfy.guandao.GuandaoSetting2Act.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[119] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xfy.guandao.GuandaoSetting2Act.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[119] & 255;
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xfy.guandao.GuandaoSetting2Act.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[118] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xfy.guandao.GuandaoSetting2Act.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[118] & 255;
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xfy.guandao.GuandaoSetting2Act.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[101] - 1;
                if (value < 0) {
                    value = 10;
                } else if (value > 10) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{0, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xfy.guandao.GuandaoSetting2Act.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[101] + 1;
                if (value < 0) {
                    value = 10;
                } else if (value > 10) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{0, value}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mD5B03() {
        int temp = DataCanbus.DATA[123] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(switchOn == 1);
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_right_camera_open);
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_right_camera_close);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mD5B02() {
        int temp = DataCanbus.DATA[124] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.wc_321_civic_message)).setChecked(switchOn == 1);
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.wc_321_civic_message_state)).setText(R.string.str_right_camera_open);
        } else {
            ((TextView) findViewById(R.id.wc_321_civic_message_state)).setText(R.string.str_right_camera_close);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mD5B04() {
        int temp = DataCanbus.DATA[122] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(switchOn == 1);
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_right_camera_open);
        } else {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_right_camera_close);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mD5B05() {
        int temp = DataCanbus.DATA[121] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(switchOn == 1);
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_right_camera_open);
        } else {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_right_camera_close);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mD5B06() {
        int temp = DataCanbus.DATA[120] & 65535;
        int switchOn = temp & 255;
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.xp_accord9_auto_light_1lower);
                return;
            }
            if (switchOn == 1) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.xp_accord9_auto_light_2middle);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.xp_accord9_auto_light_3higher);
            } else {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.jeep_playstate11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mD0B00() {
        int temp = DataCanbus.DATA[119] & 65535;
        int switchOn = temp & 255;
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.xp_accord9_with_refuel);
                return;
            }
            if (switchOn == 1) {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.xp_accord9_ign_off);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.klc_air_Manual);
            } else {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.jeep_playstate11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mD0B02() {
        int temp = DataCanbus.DATA[118] & 65535;
        int switchOn = temp & 255;
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.xp_accord9_with_refuel);
                return;
            }
            if (switchOn == 1) {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.xp_accord9_ign_off);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.klc_air_Manual);
            } else {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.jeep_playstate11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mD0B04() {
        int temp = DataCanbus.DATA[101];
        int switchOn = temp & 255;
        if (((TextView) findViewById(R.id.tv_text7)) != null && switchOn >= 0 && switchOn < 11) {
            ((TextView) findViewById(R.id.tv_text7)).setText(AccordConfig.mStrOutSideTemp[switchOn]);
        }
    }
}
