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
public class Oudi_0255_XiaoYao_CarSettingAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.oudi.hantengx5.Oudi_0255_XiaoYao_CarSettingAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int vel = DataCanbus.DATA[updateCode] & 255;
            switch (updateCode) {
                case 61:
                    Oudi_0255_XiaoYao_CarSettingAct.this.updateYkUnlock(vel);
                    break;
                case 62:
                    Oudi_0255_XiaoYao_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0255_XiaoYao_CarSettingAct.this.findViewById(R.id.xiaoyao_avm_switch_check), vel != 0);
                    break;
                case 63:
                    Oudi_0255_XiaoYao_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0255_XiaoYao_CarSettingAct.this.findViewById(R.id.xiaoyao_auto_window_switch_check), vel != 0);
                    break;
                case 64:
                    Oudi_0255_XiaoYao_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0255_XiaoYao_CarSettingAct.this.findViewById(R.id.xiaoyao_day_light_switch_check), vel != 0);
                    break;
                case 65:
                    Oudi_0255_XiaoYao_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0255_XiaoYao_CarSettingAct.this.findViewById(R.id.xiaoyao_welcome_light_switch_check), vel != 0);
                    break;
                case 66:
                    Oudi_0255_XiaoYao_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0255_XiaoYao_CarSettingAct.this.findViewById(R.id.xiaoyao_auto_mirror_switch_check), vel != 0);
                    break;
                case 67:
                    Oudi_0255_XiaoYao_CarSettingAct.this.updateReturnHome(vel);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0255_oudi_xiaoyao_carsetting);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((Button) findViewById(R.id.xiaoyao_remote_unlock_m), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.hantengx5.Oudi_0255_XiaoYao_CarSettingAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int brightlevel;
                int brightlevel2 = DataCanbus.DATA[61] & 255;
                if (brightlevel2 == 1) {
                    brightlevel = 0;
                } else {
                    brightlevel = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{146, brightlevel}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.xiaoyao_remote_unlock_p), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.hantengx5.Oudi_0255_XiaoYao_CarSettingAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int brightlevel;
                int brightlevel2 = DataCanbus.DATA[61] & 255;
                if (brightlevel2 == 1) {
                    brightlevel = 0;
                } else {
                    brightlevel = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{146, brightlevel}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.xiaoyao_return_home_m), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.hantengx5.Oudi_0255_XiaoYao_CarSettingAct.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int controlmethod;
                int controlmethod2 = DataCanbus.DATA[67] & 255;
                if (controlmethod2 <= 0) {
                    controlmethod = 3;
                } else {
                    controlmethod = controlmethod2 - 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{152, controlmethod}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.xiaoyao_return_home_p), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.hantengx5.Oudi_0255_XiaoYao_CarSettingAct.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int controlmethod;
                int controlmethod2 = DataCanbus.DATA[67] & 255;
                if (controlmethod2 >= 3) {
                    controlmethod = 0;
                } else {
                    controlmethod = controlmethod2 + 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{152, controlmethod}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.xiaoyao_avm_switch_check), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.hantengx5.Oudi_0255_XiaoYao_CarSettingAct.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[62] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 147;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.xiaoyao_auto_window_switch_check), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.hantengx5.Oudi_0255_XiaoYao_CarSettingAct.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[63] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 148;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.xiaoyao_day_light_switch_check), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.hantengx5.Oudi_0255_XiaoYao_CarSettingAct.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[64] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 149;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.xiaoyao_welcome_light_switch_check), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.hantengx5.Oudi_0255_XiaoYao_CarSettingAct.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[65] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 150;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.xiaoyao_auto_mirror_switch_check), new View.OnClickListener() { // from class: com.syu.carinfo.oudi.hantengx5.Oudi_0255_XiaoYao_CarSettingAct.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[66] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 151;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateYkUnlock(int vel) {
        if (((TextView) findViewById(R.id.xiaoyao_remote_unlock_text)) != null) {
            if (vel == 0) {
                ((TextView) findViewById(R.id.xiaoyao_remote_unlock_text)).setText(R.string.str_remote_unlock0);
            } else {
                ((TextView) findViewById(R.id.xiaoyao_remote_unlock_text)).setText(R.string.str_remote_unlock1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateReturnHome(int vel) {
        if (((TextView) findViewById(R.id.xiaoyao_return_home_text)) != null) {
            if (vel == 1) {
                ((TextView) findViewById(R.id.xiaoyao_return_home_text)).setText(R.string.wc_ruiteng_string_time_0);
                return;
            }
            if (vel == 2) {
                ((TextView) findViewById(R.id.xiaoyao_return_home_text)).setText(R.string.wc_ruiteng_string_time_1);
                return;
            }
            if (vel == 3) {
                ((TextView) findViewById(R.id.xiaoyao_return_home_text)).setText(R.string.wc_ruiteng_string_time_5);
            } else if (vel == 4) {
                ((TextView) findViewById(R.id.xiaoyao_return_home_text)).setText(R.string.wc_ruiteng_string_time_9);
            } else {
                ((TextView) findViewById(R.id.xiaoyao_return_home_text)).setText(R.string.jeep_comfortsystems_0);
            }
        }
    }
}
