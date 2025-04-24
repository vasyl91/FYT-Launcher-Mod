package com.syu.carinfo.golf7_xp;

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
public class Golf7_XP_FunctionalAirConditionerActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode] & 255;
            switch (updateCode) {
                case 73:
                    if (value == 0) {
                        ((TextView) Golf7_XP_FunctionalAirConditionerActi.this.findViewById(R.id.glf7_tv_functional_air_auto_set)).setText(R.string.klc_air_low);
                        break;
                    } else if (value == 1) {
                        ((TextView) Golf7_XP_FunctionalAirConditionerActi.this.findViewById(R.id.glf7_tv_functional_air_auto_set)).setText(R.string.klc_air_middle);
                        break;
                    } else if (value == 2) {
                        ((TextView) Golf7_XP_FunctionalAirConditionerActi.this.findViewById(R.id.glf7_tv_functional_air_auto_set)).setText(R.string.klc_air_high);
                        break;
                    }
                case 226:
                    if (value == 0) {
                        ((TextView) Golf7_XP_FunctionalAirConditionerActi.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_low);
                        break;
                    } else if (value == 1) {
                        ((TextView) Golf7_XP_FunctionalAirConditionerActi.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_middle);
                        break;
                    } else if (value == 2) {
                        ((TextView) Golf7_XP_FunctionalAirConditionerActi.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
                        break;
                    }
                case 227:
                    Golf7_XP_FunctionalAirConditionerActi.this.setCheck((CheckedTextView) Golf7_XP_FunctionalAirConditionerActi.this.findViewById(R.id.ctv_checkedtext1), value != 0);
                    break;
                case 228:
                    Golf7_XP_FunctionalAirConditionerActi.this.setCheck((CheckedTextView) Golf7_XP_FunctionalAirConditionerActi.this.findViewById(R.id.ctv_checkedtext2), value != 0);
                    break;
                case 229:
                    Golf7_XP_FunctionalAirConditionerActi.this.setCheck((CheckedTextView) Golf7_XP_FunctionalAirConditionerActi.this.findViewById(R.id.ctv_checkedtext3), value != 0);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_golf7_functional_state_air_conditioner_xp);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[229] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 189;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[228] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 167;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[227] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 168;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_air_auto_sete_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn;
                int switchOn2 = DataCanbus.DATA[73] & 255;
                if (switchOn2 > 0) {
                    switchOn = switchOn2 - 1;
                } else {
                    switchOn = 2;
                }
                DataCanbus.PROXY.cmd(107, new int[]{177, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_air_auto_sete_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn;
                int switchOn2 = DataCanbus.DATA[73] & 255;
                if (switchOn2 < 2) {
                    switchOn = switchOn2 + 1;
                } else {
                    switchOn = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{177, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus1), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn;
                int switchOn2 = DataCanbus.DATA[226] & 255;
                if (switchOn2 > 0) {
                    switchOn = switchOn2 - 1;
                } else {
                    switchOn = 2;
                }
                DataCanbus.PROXY.cmd(107, new int[]{169, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus1), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn;
                int switchOn2 = DataCanbus.DATA[226] & 255;
                if (switchOn2 < 2) {
                    switchOn = switchOn2 + 1;
                } else {
                    switchOn = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{169, switchOn}, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[226].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[227].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[228].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[229].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[226].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[227].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[228].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[229].removeNotify(this.mNotifyCanbus);
    }
}
