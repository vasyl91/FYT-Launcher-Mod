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

@SuppressWarnings({"deprecation", "unchecked"})
public class Wc_372_SafeyActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    Wc_372_SafeyActi.this.m43d36();
                    break;
                case 99:
                    Wc_372_SafeyActi.this.m43d34();
                    break;
                case 100:
                    Wc_372_SafeyActi.this.m43d32();
                    break;
                case 101:
                    Wc_372_SafeyActi.this.m43d31();
                    break;
                case 102:
                    Wc_372_SafeyActi.this.m43d30();
                    break;
                case 103:
                    Wc_372_SafeyActi.this.m43d47();
                    break;
                case 104:
                    Wc_372_SafeyActi.this.m43d46();
                    break;
                case 105:
                    Wc_372_SafeyActi.this.m43d45();
                    break;
                case 106:
                    Wc_372_SafeyActi.this.m43d43();
                    break;
                case 107:
                    Wc_372_SafeyActi.this.m43d42();
                    break;
                case 108:
                    Wc_372_SafeyActi.this.m43d40();
                    break;
                case 109:
                    Wc_372_SafeyActi.this.m43d56();
                    break;
                case 110:
                    Wc_372_SafeyActi.this.m43d55();
                    break;
                case 111:
                    Wc_372_SafeyActi.this.m43d54();
                    break;
                case 112:
                    Wc_372_SafeyActi.this.m43d52();
                    break;
                case 113:
                    Wc_372_SafeyActi.this.m43d50();
                    break;
                case 162:
                    Wc_372_SafeyActi.this.m43d44();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_372_zyg_safetyassist);
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.jeep_parksense_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[98] & 255;
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.jeep_parksense_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[98] & 255;
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_view_lanedev_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[99] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_view_lanedev_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[99] & 255;
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_lanewar_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[100] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_lanewar_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[100] & 255;
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{3, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_372_crash_brak)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[101] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 2;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_372_crash_brakwarring)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[102] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 1;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.jeep_auto_park_brake)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[103] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 12;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.jeep_hill_start_assist)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[104] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 11;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_372_rainauto)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[105] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 10;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_372_video_move)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[106] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 7;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_372_video_static)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[107] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 8;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_blindwarring_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[108] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{6, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_blindwarring_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[108] & 255;
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{6, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_autoserve_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[109] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{17, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_autoserve_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[109] & 255;
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{17, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_372_parksystem)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[110] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 16;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_372_parksensebreak)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[111] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 15;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_frontsensevo_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[113] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{13, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_frontsensevo_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[113] & 255;
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{13, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_backsensevol_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[112] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{14, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_backsensevol_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[112] & 255;
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{14, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_372_parkingimagedelay)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[162] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 9;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
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
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
    }

    
    public void m43d36() {
        int temp = DataCanbus.DATA[98] & 65535;
        int value = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_assist).setVisibility(enable == 0 ? 8 : 0);
        if (((TextView) findViewById(R.id.jeep_parksense_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.jeep_parksense_set_show)).setText(R.string.jeep_parksense_1);
            } else if (value == 0) {
                ((TextView) findViewById(R.id.jeep_parksense_set_show)).setText(R.string.jeep_parksense_0);
            }
        }
    }

    protected void m43d44() {
        int temp = DataCanbus.DATA[162] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_parkingimagedelay).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.wc_372_parkingimagedelay)).setChecked(switchOn == 1);
    }

    
    public void m43d34() {
        int temp = DataCanbus.DATA[99] & 65535;
        int value = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_lanedev).setVisibility(enable == 0 ? 8 : 0);
        if (((TextView) findViewById(R.id.wc_372_view_lanedev_set_show)) != null) {
            if (value == 2) {
                ((TextView) findViewById(R.id.wc_372_view_lanedev_set_show)).setText(R.string.wc_372_high);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.wc_372_view_lanedev_set_show)).setText(R.string.wc_372_mid);
            } else if (value == 0) {
                ((TextView) findViewById(R.id.wc_372_view_lanedev_set_show)).setText(R.string.wc_372_low);
            }
        }
    }

    
    public void m43d32() {
        int temp = DataCanbus.DATA[100] & 65535;
        int value = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_lanewar).setVisibility(enable == 0 ? 8 : 0);
        if (((TextView) findViewById(R.id.wc_372_lanewar_set_show)) != null) {
            if (value == 2) {
                ((TextView) findViewById(R.id.wc_372_lanewar_set_show)).setText(R.string.jeep_lanesensewarn_2);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.wc_372_lanewar_set_show)).setText(R.string.jeep_lanesensewarn_1);
            } else if (value == 0) {
                ((TextView) findViewById(R.id.wc_372_lanewar_set_show)).setText(R.string.jeep_lanesensewarn_0);
            }
        }
    }

    
    public void m43d31() {
        int temp = DataCanbus.DATA[101] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_crash_brak).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.wc_372_crash_brak)).setChecked(switchOn == 1);
    }

    
    public void m43d30() {
        int temp = DataCanbus.DATA[102] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_crash_brakwarring).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.wc_372_crash_brakwarring)).setChecked(switchOn == 1);
    }

    
    public void m43d47() {
        int temp = DataCanbus.DATA[103] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_auto_park_brake).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.jeep_auto_park_brake)).setChecked(switchOn == 1);
    }

    
    public void m43d46() {
        int temp = DataCanbus.DATA[104] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_jeep_hill_start_assist).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.jeep_hill_start_assist)).setChecked(switchOn == 1);
    }

    
    public void m43d45() {
        int temp = DataCanbus.DATA[105] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_rainauto).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.wc_372_rainauto)).setChecked(switchOn == 1);
    }

    
    public void m43d43() {
        int temp = DataCanbus.DATA[106] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_video_move).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.wc_372_video_move)).setChecked(switchOn == 1);
    }

    
    public void m43d42() {
        int temp = DataCanbus.DATA[107] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_video_static).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.wc_372_video_static)).setChecked(switchOn == 1);
    }

    
    public void m43d40() {
        int temp = DataCanbus.DATA[108] & 65535;
        int value = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_blindwarring).setVisibility(enable == 0 ? 8 : 0);
        if (((TextView) findViewById(R.id.wc_372_blindwarring_set_show)) != null) {
            if (value == 2) {
                ((TextView) findViewById(R.id.wc_372_blindwarring_set_show)).setText(R.string.jeep_blindwarn_2);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.wc_372_blindwarring_set_show)).setText(R.string.jeep_blindwarn_1);
            } else if (value == 0) {
                ((TextView) findViewById(R.id.wc_372_blindwarring_set_show)).setText(R.string.jeep_blindwarn_0);
            }
        }
    }

    
    public void m43d56() {
        int temp = DataCanbus.DATA[109] & 65535;
        int value = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_autoserve).setVisibility(enable == 0 ? 8 : 0);
        if (((TextView) findViewById(R.id.wc_372_autoserve_set_show)) != null) {
            if (value == 2) {
                ((TextView) findViewById(R.id.wc_372_autoserve_set_show)).setText(R.string.jeep_comfortsystems_2);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.wc_372_autoserve_set_show)).setText(R.string.jeep_comfortsystems_1);
            } else if (value == 0) {
                ((TextView) findViewById(R.id.wc_372_autoserve_set_show)).setText(R.string.jeep_comfortsystems_0);
            }
        }
    }

    
    public void m43d55() {
        int temp = DataCanbus.DATA[110] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_parksystem).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.wc_372_parksystem)).setChecked(switchOn == 1);
    }

    
    public void m43d54() {
        int temp = DataCanbus.DATA[111] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_parksensebreak).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.wc_372_parksensebreak)).setChecked(switchOn == 1);
    }

    
    public void m43d52() {
        int temp = DataCanbus.DATA[112] & 65535;
        int value = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_backsensevol).setVisibility(enable == 0 ? 8 : 0);
        if (((TextView) findViewById(R.id.wc_372_backsensevol_set_show)) != null) {
            if (value == 2) {
                ((TextView) findViewById(R.id.wc_372_backsensevol_set_show)).setText(R.string.wc_372_high);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.wc_372_backsensevol_set_show)).setText(R.string.wc_372_mid);
            } else if (value == 0) {
                ((TextView) findViewById(R.id.wc_372_backsensevol_set_show)).setText(R.string.wc_372_low);
            }
        }
    }

    
    public void m43d50() {
        int temp = DataCanbus.DATA[113] & 65535;
        int value = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_frontsensevol).setVisibility(enable == 0 ? 8 : 0);
        if (((TextView) findViewById(R.id.wc_372_frontsensevo_set_show)) != null) {
            if (value == 2) {
                ((TextView) findViewById(R.id.wc_372_frontsensevo_set_show)).setText(R.string.wc_372_high);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.wc_372_frontsensevo_set_show)).setText(R.string.wc_372_mid);
            } else if (value == 0) {
                ((TextView) findViewById(R.id.wc_372_frontsensevo_set_show)).setText(R.string.wc_372_low);
            }
        }
    }
}
