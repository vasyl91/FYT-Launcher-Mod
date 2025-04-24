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
public class Wc_372_LightEngineActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 114:
                    Wc_372_LightEngineActi.this.m62d24();
                    break;
                case 115:
                    Wc_372_LightEngineActi.this.m62d22();
                    break;
                case 116:
                    Wc_372_LightEngineActi.this.m62d20();
                    break;
                case 117:
                    Wc_372_LightEngineActi.this.m62d34();
                    break;
                case 118:
                    Wc_372_LightEngineActi.this.m62d33();
                    break;
                case 119:
                    Wc_372_LightEngineActi.this.m62d31();
                    break;
                case 120:
                    Wc_372_LightEngineActi.this.m62d30();
                    break;
                case 139:
                    Wc_372_LightEngineActi.this.m62d35();
                    break;
                case 158:
                    Wc_372_LightEngineActi.this.m62d14();
                    break;
                case 159:
                    Wc_372_LightEngineActi.this.m62d26();
                    break;
                case 160:
                    Wc_372_LightEngineActi.this.m62d32();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_372_zyg_lightengine);
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.wc_372_lightdelay_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[116] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_lightdelay_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[116] & 255;
                if (value2 < 3) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_nearlight_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[115] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_nearlight_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[115] & 255;
                if (value2 < 3) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{2, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_372_rainautolight)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[120] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 3;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_372_autolight)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[119] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 4;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_372_daylight)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[118] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 5;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_372_lockturnlight)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[117] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 6;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_engstop_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[114] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{7, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_engstop_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[114] & 255;
                if (value2 < 3) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{7, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_headlight_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[159] & 255;
                if (value2 > 1) {
                    value = value2 - 1;
                } else {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{8, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_headlight_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[159] & 255;
                if (value2 < 3) {
                    value = value2 + 1;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{8, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_372_greetlight)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[160] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 9;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_372_assiatlight)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[158] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 10;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_amblight_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[139] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 6;
                }
                DataCanbus.PROXY.cmd(2, new int[]{11, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_amblight_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[139] & 255;
                if (value2 < 6) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{11, value}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
    }

    
    public void m62d35() {
        int temp = DataCanbus.DATA[139] & 65535;
        int value = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_amblight).setVisibility(enable == 0 ? 8 : 0);
        if (((TextView) findViewById(R.id.wc_372_amblight_set_show)) != null) {
            ((TextView) findViewById(R.id.wc_372_amblight_set_show)).setText(new StringBuilder().append(value).toString());
        }
    }

    
    public void m62d14() {
        int temp = DataCanbus.DATA[158] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_assiatlight).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.wc_372_assiatlight)).setChecked(switchOn == 1);
    }

    
    public void m62d24() {
        int temp = DataCanbus.DATA[114] & 65535;
        int value = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_engstop).setVisibility(enable == 0 ? 8 : 0);
        if (((TextView) findViewById(R.id.wc_372_engstop_set_show)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.wc_372_engstop_set_show)).setText("0s");
                return;
            }
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_372_engstop_set_show)).setText("45s");
            } else if (value == 2) {
                ((TextView) findViewById(R.id.wc_372_engstop_set_show)).setText("5Min");
            } else if (value == 3) {
                ((TextView) findViewById(R.id.wc_372_engstop_set_show)).setText("10Min");
            }
        }
    }

    
    public void m62d22() {
        int temp = DataCanbus.DATA[115] & 65535;
        int value = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_nearlight).setVisibility(enable == 0 ? 8 : 0);
        if (((TextView) findViewById(R.id.wc_372_nearlight_set_show)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.wc_372_nearlight_set_show)).setText("0s");
                return;
            }
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_372_nearlight_set_show)).setText("30s");
            } else if (value == 2) {
                ((TextView) findViewById(R.id.wc_372_nearlight_set_show)).setText("60s");
            } else if (value == 3) {
                ((TextView) findViewById(R.id.wc_372_nearlight_set_show)).setText("90s");
            }
        }
    }

    
    public void m62d20() {
        int temp = DataCanbus.DATA[116] & 65535;
        int value = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_lightdelay).setVisibility(enable == 0 ? 8 : 0);
        if (((TextView) findViewById(R.id.wc_372_lightdelay_set_show)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.wc_372_lightdelay_set_show)).setText("0s");
                return;
            }
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_372_lightdelay_set_show)).setText("30s");
            } else if (value == 2) {
                ((TextView) findViewById(R.id.wc_372_lightdelay_set_show)).setText("60s");
            } else if (value == 3) {
                ((TextView) findViewById(R.id.wc_372_lightdelay_set_show)).setText("90s");
            }
        }
    }

    
    public void m62d34() {
        int temp = DataCanbus.DATA[117] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_lockturnlight).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.wc_372_lockturnlight)).setChecked(switchOn == 1);
    }

    
    public void m62d33() {
        int temp = DataCanbus.DATA[118] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_daylight).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.wc_372_daylight)).setChecked(switchOn == 1);
    }

    
    public void m62d31() {
        int temp = DataCanbus.DATA[119] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_autolight).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.wc_372_autolight)).setChecked(switchOn == 1);
    }

    
    public void m62d30() {
        int temp = DataCanbus.DATA[120] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_rainautolight).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.wc_372_rainautolight)).setChecked(switchOn == 1);
    }

    
    public void m62d32() {
        int temp = DataCanbus.DATA[160] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_greetlight).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.wc_372_greetlight)).setChecked(switchOn == 1);
    }

    
    public void m62d26() {
        int temp = DataCanbus.DATA[159] & 65535;
        int value = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_headlight_sensitivity).setVisibility(enable == 0 ? 8 : 0);
        if (((TextView) findViewById(R.id.wc_372_headlight_set_show)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_372_headlight_set_show)).setText("1");
            } else if (value == 2) {
                ((TextView) findViewById(R.id.wc_372_headlight_set_show)).setText("2");
            } else if (value == 3) {
                ((TextView) findViewById(R.id.wc_372_headlight_set_show)).setText("3");
            }
        }
    }
}
