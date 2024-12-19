package com.syu.carinfo.oudi.hantengx5;

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
public class Oudi_0255_HanTengX5_CarSettingAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.oudi.hantengx5.Oudi_0255_HanTengX5_CarSettingAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 51:
                    Oudi_0255_HanTengX5_CarSettingAct.this.updateBrightLevel();
                    break;
                case 52:
                    Oudi_0255_HanTengX5_CarSettingAct.this.updateAmbientLightSwitch();
                    break;
                case 53:
                    Oudi_0255_HanTengX5_CarSettingAct.this.updateSeatCourtesySwitch();
                    break;
                case 54:
                    Oudi_0255_HanTengX5_CarSettingAct.this.updateControlMethod();
                    break;
                case 55:
                    Oudi_0255_HanTengX5_CarSettingAct.this.updateStaticSet();
                    break;
                case 56:
                    Oudi_0255_HanTengX5_CarSettingAct.this.updateBlueGreenRed();
                    break;
                case 57:
                    Oudi_0255_HanTengX5_CarSettingAct.this.updateBluePurpleRed();
                    break;
                case 58:
                    Oudi_0255_HanTengX5_CarSettingAct.this.updateDynamicSetting();
                    break;
                case 59:
                    Oudi_0255_HanTengX5_CarSettingAct.this.updateDynamicSampling();
                    break;
                case 60:
                    Oudi_0255_HanTengX5_CarSettingAct.this.updateDynamicSpeed();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0255_oudi_hantentx5_carsetting);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((Button) findViewById(R.id.btn_minus1), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.hantengx5.Oudi_0255_HanTengX5_CarSettingAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int brightlevel;
                int brightlevel2 = DataCanbus.DATA[51] & 255;
                if (brightlevel2 <= 1) {
                    brightlevel = 7;
                } else {
                    brightlevel = brightlevel2 - 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{149, brightlevel}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus1), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.hantengx5.Oudi_0255_HanTengX5_CarSettingAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int brightlevel;
                int brightlevel2 = DataCanbus.DATA[51] & 255;
                if (brightlevel2 >= 6) {
                    brightlevel = 1;
                } else {
                    brightlevel = brightlevel2 + 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{149, brightlevel}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus2), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.hantengx5.Oudi_0255_HanTengX5_CarSettingAct.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int controlmethod;
                int controlmethod2 = DataCanbus.DATA[54] & 255;
                if (controlmethod2 <= 0) {
                    controlmethod = 2;
                } else {
                    controlmethod = controlmethod2 - 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{150, controlmethod}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus2), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.hantengx5.Oudi_0255_HanTengX5_CarSettingAct.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int controlmethod;
                int controlmethod2 = DataCanbus.DATA[54] & 255;
                if (controlmethod2 > 1) {
                    controlmethod = 2;
                } else {
                    controlmethod = controlmethod2 + 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{150, controlmethod}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus3), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.hantengx5.Oudi_0255_HanTengX5_CarSettingAct.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int dynamicset;
                int dynamicset2 = DataCanbus.DATA[58] & 255;
                if (dynamicset2 <= 0) {
                    dynamicset = 2;
                } else {
                    dynamicset = dynamicset2 - 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{151, dynamicset}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus3), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.hantengx5.Oudi_0255_HanTengX5_CarSettingAct.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int dynamicset;
                int dynamicset2 = DataCanbus.DATA[58] & 255;
                if (dynamicset2 >= 2) {
                    dynamicset = 0;
                } else {
                    dynamicset = dynamicset2 + 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{151, dynamicset}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus4), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.hantengx5.Oudi_0255_HanTengX5_CarSettingAct.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int bluegreenred;
                int bluegreenred2 = DataCanbus.DATA[56] & 255;
                if (bluegreenred2 <= 0) {
                    bluegreenred = 255;
                } else {
                    bluegreenred = bluegreenred2 - 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{152, bluegreenred}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus4), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.hantengx5.Oudi_0255_HanTengX5_CarSettingAct.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int bluegreenred;
                int bluegreenred2 = DataCanbus.DATA[56] & 255;
                if (bluegreenred2 >= 255) {
                    bluegreenred = 0;
                } else {
                    bluegreenred = bluegreenred2 + 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{152, bluegreenred}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus5), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.hantengx5.Oudi_0255_HanTengX5_CarSettingAct.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int bluepurplered;
                int bluepurplered2 = DataCanbus.DATA[57] & 255;
                if (bluepurplered2 <= 0) {
                    bluepurplered = 255;
                } else {
                    bluepurplered = bluepurplered2 - 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{153, bluepurplered}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus5), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.hantengx5.Oudi_0255_HanTengX5_CarSettingAct.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int bluepurplered;
                int bluepurplered2 = DataCanbus.DATA[57] & 255;
                if (bluepurplered2 >= 255) {
                    bluepurplered = 0;
                } else {
                    bluepurplered = bluepurplered2 + 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{153, bluepurplered}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus6), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.hantengx5.Oudi_0255_HanTengX5_CarSettingAct.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int dynamicsampling;
                int dynamicsampling2 = DataCanbus.DATA[59] & 255;
                if (dynamicsampling2 == 0) {
                    dynamicsampling = 1;
                } else {
                    dynamicsampling = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{155, dynamicsampling}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus6), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.hantengx5.Oudi_0255_HanTengX5_CarSettingAct.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int dynamicsampling;
                int dynamicsampling2 = DataCanbus.DATA[59] & 255;
                if (dynamicsampling2 == 0) {
                    dynamicsampling = 1;
                } else {
                    dynamicsampling = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{155, dynamicsampling}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus7), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.hantengx5.Oudi_0255_HanTengX5_CarSettingAct.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int dynamicspeed;
                int dynamicspeed2 = DataCanbus.DATA[60] & 255;
                if (dynamicspeed2 <= 0) {
                    dynamicspeed = 255;
                } else {
                    dynamicspeed = dynamicspeed2 - 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{156, dynamicspeed}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus7), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.hantengx5.Oudi_0255_HanTengX5_CarSettingAct.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int dynamicspeed;
                int dynamicspeed2 = DataCanbus.DATA[60] & 255;
                if (dynamicspeed2 >= 255) {
                    dynamicspeed = 0;
                } else {
                    dynamicspeed = dynamicspeed2 + 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{156, dynamicspeed}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.hantengx5.Oudi_0255_HanTengX5_CarSettingAct.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[52] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 148;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.hantengx5.Oudi_0255_HanTengX5_CarSettingAct.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[53] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 147;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.hantengx5.Oudi_0255_HanTengX5_CarSettingAct.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[58] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 154;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBrightLevel() {
        int brightlevel = DataCanbus.DATA[51];
        if (((TextView) findViewById(R.id.tv_text1)) != null && brightlevel > 0 && brightlevel <= 7) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("%d", Integer.valueOf(brightlevel))) + "level");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateControlMethod() {
        int controlmethod = DataCanbus.DATA[54];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (controlmethod == 1) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_255_hantengx5_11);
            } else if (controlmethod == 2) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_255_hantengx5_12);
            } else {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.crv_source_null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateStaticSet() {
        int staticset = DataCanbus.DATA[55];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (staticset == 1) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_255_hantengx5_14);
            } else if (staticset == 2) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_255_hantengx5_15);
            } else {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_255_hantengx5_13);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDynamicSampling() {
        int dynamicsampling = DataCanbus.DATA[59];
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            if (dynamicsampling == 1) {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_255_hantengx5_17);
            } else {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_255_hantengx5_16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlueGreenRed() {
        int bluegreenred = DataCanbus.DATA[56];
        if (((TextView) findViewById(R.id.tv_text4)) != null && bluegreenred > 0 && bluegreenred <= 255) {
            ((TextView) findViewById(R.id.tv_text4)).setText(String.format("%d", Integer.valueOf(bluegreenred)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBluePurpleRed() {
        int bluepurplered = DataCanbus.DATA[57];
        if (((TextView) findViewById(R.id.tv_text5)) != null && bluepurplered > 0 && bluepurplered <= 255) {
            ((TextView) findViewById(R.id.tv_text5)).setText(String.format("%d", Integer.valueOf(bluepurplered)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDynamicSpeed() {
        int dynamicspeed = DataCanbus.DATA[60];
        if (((TextView) findViewById(R.id.tv_text7)) != null && dynamicspeed > 0 && dynamicspeed <= 255) {
            ((TextView) findViewById(R.id.tv_text7)).setText(String.format("%d", Integer.valueOf(dynamicspeed)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAmbientLightSwitch() {
        int ambientlight = DataCanbus.DATA[52];
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext1), ambientlight != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSeatCourtesySwitch() {
        int seatcourtesy = DataCanbus.DATA[53];
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext2), seatcourtesy != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDynamicSetting() {
        int dynamicsetting = DataCanbus.DATA[58];
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext3), dynamicsetting != 0);
    }
}
