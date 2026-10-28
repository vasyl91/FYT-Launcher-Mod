package com.syu.carinfo.honda;

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
public class Wc_16Civic_Pannel extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 136:
                    Wc_16Civic_Pannel.this.m69D05();
                    break;
                case 137:
                    Wc_16Civic_Pannel.this.m69D04();
                    break;
                case 138:
                    Wc_16Civic_Pannel.this.m69D03();
                    break;
                case 139:
                    Wc_16Civic_Pannel.this.m69D02();
                    break;
                case 140:
                    Wc_16Civic_Pannel.this.m69D00();
                    break;
                case 141:
                    Wc_16Civic_Pannel.this.m69D15();
                    break;
                case 142:
                    Wc_16Civic_Pannel.this.m69D13();
                    break;
                case 143:
                    Wc_16Civic_Pannel.this.m69D10();
                    break;
                case 149:
                    Wc_16Civic_Pannel.this.m69D06();
                    break;
                case 161:
                    ((CheckedTextView) Wc_16Civic_Pannel.this.findViewById(R.id.ctv_checkedtext1)).setChecked(val == 1);
                    break;
                case 163:
                    Wc_16Civic_Pannel.this.m69D17();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_321_civic_pannel);
        init();
    }

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[161] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 10;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(106, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[149] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 9;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(106, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[136] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 6;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(106, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[137] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 7;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(106, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[138] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 8;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(106, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[139] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 5;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(106, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[163] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 13;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(106, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[140] & 255;
                if (value2 > 1) {
                    value = value2 - 1;
                } else {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(106, new int[]{4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[140] & 255;
                if (value2 < 3) {
                    value = value2 + 1;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(106, new int[]{4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[141] & 255;
                if (value2 > 1) {
                    value = value2 - 1;
                } else {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(106, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[141] & 255;
                if (value2 < 3) {
                    value = value2 + 1;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(106, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[142] & 255;
                if (value2 > 1) {
                    value = value2 - 1;
                } else {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(106, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[142] & 255;
                if (value2 < 3) {
                    value = value2 + 1;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(106, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[143] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 7;
                }
                DataCanbus.PROXY.cmd(106, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[143] & 255;
                if (value2 < 7) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(106, new int[]{1, value}, null, null);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
    }

    
    public void m69D17() {
        int temp = DataCanbus.DATA[163] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(switchOn == 1);
    }

    
    public void m69D06() {
        int temp = DataCanbus.DATA[149] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(switchOn == 1);
    }

    
    public void m69D05() {
        int temp = DataCanbus.DATA[136] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(switchOn == 1);
    }

    
    public void m69D04() {
        int temp = DataCanbus.DATA[137] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(switchOn == 1);
    }

    
    public void m69D03() {
        int temp = DataCanbus.DATA[138] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(switchOn == 1);
    }

    
    public void m69D02() {
        int temp = DataCanbus.DATA[139] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(switchOn == 1);
    }

    
    public void m69D00() {
        int temp = DataCanbus.DATA[140] & 65535;
        int switchOn = temp & 255;
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.jeep_playstate11);
                return;
            }
            if (switchOn == 1) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.xp_accord9_auto_light_3higher);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.xp_accord9_auto_light_2middle);
            } else if (switchOn == 3) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.xp_accord9_auto_light_1lower);
            }
        }
    }

    
    public void m69D15() {
        int temp = DataCanbus.DATA[141] & 65535;
        int switchOn = temp & 255;
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.jeep_playstate11);
                return;
            }
            if (switchOn == 1) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.xp_accord9_with_refuel);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.xp_accord9_ign_off);
            } else if (switchOn == 3) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_air_Manual);
            }
        }
    }

    
    public void m69D13() {
        int temp = DataCanbus.DATA[142] & 65535;
        int switchOn = temp & 255;
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.jeep_playstate11);
                return;
            }
            if (switchOn == 1) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.xp_accord9_with_refuel);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.xp_accord9_ign_off);
            } else if (switchOn == 3) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_air_Manual);
            }
        }
    }

    
    public void m69D10() {
        int temp = DataCanbus.DATA[143] & 65535;
        int switchOn = temp & 255;
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.jeep_playstate11);
                return;
            }
            if (switchOn == 1) {
                ((TextView) findViewById(R.id.tv_text5)).setText("-3");
                return;
            }
            if (switchOn == 2) {
                ((TextView) findViewById(R.id.tv_text5)).setText("-2");
                return;
            }
            if (switchOn == 3) {
                ((TextView) findViewById(R.id.tv_text5)).setText("-1");
            } else if (switchOn == 4) {
                ((TextView) findViewById(R.id.tv_text5)).setText("0");
            } else {
                ((TextView) findViewById(R.id.tv_text5)).setText(new StringBuilder().append(switchOn - 4).toString());
            }
        }
    }
}
