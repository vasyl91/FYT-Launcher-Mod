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

public class Oudi_0255_XiaoYao_CarSettingAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int vel = DataCanbus.DATA[updateCode] & 255;
            switch (updateCode) {
                case 131:
                    Oudi_0255_XiaoYao_CarSettingAct.this.updateYkUnlock(vel);
                    break;
                case 132:
                    Oudi_0255_XiaoYao_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0255_XiaoYao_CarSettingAct.this.findViewById(R.id.xiaoyao_avm_switch_check), vel != 0);
                    break;
                case 133:
                    Oudi_0255_XiaoYao_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0255_XiaoYao_CarSettingAct.this.findViewById(R.id.xiaoyao_auto_window_switch_check), vel != 0);
                    break;
                case 134:
                    Oudi_0255_XiaoYao_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0255_XiaoYao_CarSettingAct.this.findViewById(R.id.xiaoyao_day_light_switch_check), vel != 0);
                    break;
                case 135:
                    Oudi_0255_XiaoYao_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0255_XiaoYao_CarSettingAct.this.findViewById(R.id.xiaoyao_welcome_light_switch_check), vel != 0);
                    break;
                case 136:
                    Oudi_0255_XiaoYao_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0255_XiaoYao_CarSettingAct.this.findViewById(R.id.xiaoyao_auto_mirror_switch_check), vel != 0);
                    break;
                case 137:
                    Oudi_0255_XiaoYao_CarSettingAct.this.updateReturnHome(vel);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0255_oudi_xiaoyao_carsetting);
        init();
    }

    @Override
    public void init() {
        setSelfClick((Button) findViewById(R.id.xiaoyao_remote_unlock_m), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int brightlevel;
                int brightlevel2 = DataCanbus.DATA[131] & 255;
                if (brightlevel2 == 1) {
                    brightlevel = 0;
                } else {
                    brightlevel = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{146, brightlevel}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.xiaoyao_remote_unlock_p), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int brightlevel;
                int brightlevel2 = DataCanbus.DATA[131] & 255;
                if (brightlevel2 == 1) {
                    brightlevel = 0;
                } else {
                    brightlevel = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{146, brightlevel}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.xiaoyao_return_home_m), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int controlmethod;
                int controlmethod2 = DataCanbus.DATA[137] & 255;
                if (controlmethod2 <= 0) {
                    controlmethod = 3;
                } else {
                    controlmethod = controlmethod2 - 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{152, controlmethod}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.xiaoyao_return_home_p), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int controlmethod;
                int controlmethod2 = DataCanbus.DATA[137] & 255;
                if (controlmethod2 >= 3) {
                    controlmethod = 0;
                } else {
                    controlmethod = controlmethod2 + 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{152, controlmethod}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.xiaoyao_avm_switch_check), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[132] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 147;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.xiaoyao_auto_window_switch_check), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[133] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 148;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.xiaoyao_day_light_switch_check), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[134] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 149;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.xiaoyao_welcome_light_switch_check), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[135] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 150;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.xiaoyao_auto_mirror_switch_check), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[136] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 151;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateYkUnlock(int vel) {
        if (((TextView) findViewById(R.id.xiaoyao_remote_unlock_text)) != null) {
            if (vel == 0) {
                ((TextView) findViewById(R.id.xiaoyao_remote_unlock_text)).setText(R.string.str_remote_unlock0);
            } else {
                ((TextView) findViewById(R.id.xiaoyao_remote_unlock_text)).setText(R.string.str_remote_unlock1);
            }
        }
    }

    
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
