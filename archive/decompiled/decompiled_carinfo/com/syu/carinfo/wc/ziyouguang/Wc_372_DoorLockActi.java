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
public class Wc_372_DoorLockActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 126:
                    Wc_372_DoorLockActi.this.m60d14();
                    break;
                case 127:
                    Wc_372_DoorLockActi.this.m60d13();
                    break;
                case 128:
                    Wc_372_DoorLockActi.this.m60d12();
                    break;
                case 129:
                    Wc_372_DoorLockActi.this.m60D11();
                    break;
                case 130:
                    Wc_372_DoorLockActi.this.m60D10();
                    break;
                case 157:
                    Wc_372_DoorLockActi.this.m60d15();
                    break;
                case 163:
                    Wc_372_DoorLockActi.this.m60d17();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_372_zyg_doorlock);
        init();
    }

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.wc_372_dorrwarring)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[126] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 5;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(3, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_372_nokeyenter)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[127] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 4;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(3, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_firsttimeunlock_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[128] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_firsttimeunlock_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[128] & 255;
                if (value2 < 1) {
                    value = value2 + 1;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(3, new int[]{3, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_372_offautolock)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[129] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 2;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(3, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_372_autolock)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[130] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 1;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(3, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_lock_voice_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[157] & 255;
                if (value2 > 0) {
                    value = value2 - 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(3, new int[]{6, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_372_lock_voice_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[157] & 255;
                if (value2 < 2) {
                    value = value2 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{6, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_372_remotestartsound)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[163] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 7;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(3, iArr, null, null);
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
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
    }

    
    public void m60d15() {
        int temp = DataCanbus.DATA[157] & 65535;
        int value = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_lock_voice).setVisibility(enable == 0 ? 8 : 0);
        if (((TextView) findViewById(R.id.wc_372_lock_voice_set_show)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.wc_372_lock_voice_set_show)).setText("OFF");
            } else if (value == 1) {
                ((TextView) findViewById(R.id.wc_372_lock_voice_set_show)).setText(String.format("1" + getString(R.string.str_372_press1), new Object[0]));
            } else if (value == 2) {
                ((TextView) findViewById(R.id.wc_372_lock_voice_set_show)).setText(String.format("2" + getString(R.string.str_372_press2), new Object[0]));
            }
        }
    }

    protected void m60d17() {
        int temp = DataCanbus.DATA[163] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_remotestartsound).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.wc_372_remotestartsound)).setChecked(switchOn == 1);
    }

    
    public void m60d14() {
        int temp = DataCanbus.DATA[126] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_dorrwarring).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.wc_372_dorrwarring)).setChecked(switchOn == 1);
    }

    
    public void m60d13() {
        int temp = DataCanbus.DATA[127] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_nokeyenter).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.wc_372_nokeyenter)).setChecked(switchOn == 1);
    }

    
    public void m60d12() {
        int temp = DataCanbus.DATA[128] & 65535;
        int value = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_firsttimeunlock).setVisibility(enable == 0 ? 8 : 0);
        if (((TextView) findViewById(R.id.wc_372_firsttimeunlock_set_show)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.wc_372_firsttimeunlock_set_show)).setText(R.string.klc_lock_manual_Only_the_driver_door_unlocks);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.wc_372_firsttimeunlock_set_show)).setText(R.string.klc_lock_manual_All_doors_unlock);
            }
        }
    }

    
    public void m60D11() {
        int temp = DataCanbus.DATA[129] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_offautolock).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.wc_372_offautolock)).setChecked(switchOn == 1);
    }

    
    public void m60D10() {
        int temp = DataCanbus.DATA[130] & 65535;
        int switchOn = temp & 255;
        int enable = (65280 & temp) >> 8;
        findViewById(R.id.wc_372_view_autolock).setVisibility(enable == 0 ? 8 : 0);
        ((CheckedTextView) findViewById(R.id.wc_372_autolock)).setChecked(switchOn == 1);
    }
}
