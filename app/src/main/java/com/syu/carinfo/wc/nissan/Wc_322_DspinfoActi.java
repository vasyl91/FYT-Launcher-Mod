package com.syu.carinfo.wc.nissan;

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
public class Wc_322_DspinfoActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 1:
                    Wc_322_DspinfoActi.this.ma6d64();
                    break;
                case 2:
                    Wc_322_DspinfoActi.this.ma6d63();
                    break;
                case 3:
                    Wc_322_DspinfoActi.this.ma6d60();
                    break;
                case 4:
                    Wc_322_DspinfoActi.this.ma6d70();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_322_xima_dspinfo);
        init();
    }

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.wc_322_sound_state)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[1] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 10;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(0, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.wc_322_bose_state)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[2] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 9;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(0, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_322_volume_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[3] & 255;
                if (value > 0) {
                    int i = value - 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{7, 255}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_322_volume_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[3] & 255;
                if (value < 5) {
                    int i = value + 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{7, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_322_surround_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[4] & 255;
                if (value > -5) {
                    int i = value + 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{8, 255}, null, null);
            }
        });
        ((Button) findViewById(R.id.wc_322_surround_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[3] & 255;
                if (value < 5) {
                    int i = value - 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{8, 1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
    }

    
    public void ma6d64() {
        int temp = DataCanbus.DATA[1] & 65535;
        int value = temp & 255;
        if (((CheckedTextView) findViewById(R.id.wc_322_sound_state)) != null) {
            ((CheckedTextView) findViewById(R.id.wc_322_sound_state)).setChecked(value == 1);
        }
    }

    
    public void ma6d63() {
        int temp = DataCanbus.DATA[2] & 65535;
        int value = temp & 255;
        if (((CheckedTextView) findViewById(R.id.wc_322_bose_state)) != null) {
            ((CheckedTextView) findViewById(R.id.wc_322_bose_state)).setChecked(value == 1);
        }
    }

    
    public void ma6d60() {
        int temp = DataCanbus.DATA[3] & 65535;
        int value = temp & 255;
        if (((TextView) findViewById(R.id.wc_322_volume_set_show)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.wc_322_volume_set_show)).setText(R.string.wc_372_volumestr0);
                return;
            }
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_322_volume_set_show)).setText(R.string.wc_372_volumestr1);
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.wc_322_volume_set_show)).setText(R.string.wc_372_volumestr2);
                return;
            }
            if (value == 3) {
                ((TextView) findViewById(R.id.wc_322_volume_set_show)).setText(R.string.wc_372_volumestr3);
            } else if (value == 4) {
                ((TextView) findViewById(R.id.wc_322_volume_set_show)).setText(R.string.wc_372_volumestr4);
            } else if (value == 5) {
                ((TextView) findViewById(R.id.wc_322_volume_set_show)).setText(R.string.wc_372_volumestr5);
            }
        }
    }

    
    public void ma6d70() {
        int temp = DataCanbus.DATA[4] & 65535;
        int value = temp & 255;
        if (((TextView) findViewById(R.id.wc_322_surround_set_show)) != null) {
            if (value <= 5) {
                ((TextView) findViewById(R.id.wc_322_surround_set_show)).setText("+" + value);
            } else if (value >= 251) {
                ((TextView) findViewById(R.id.wc_322_surround_set_show)).setText("-" + ((255 - value) + 1));
            }
        }
    }
}
