package com.syu.carinfo.honda;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Wc_16Civic_RemoteActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode] & 65535;
            switch (updateCode) {
                case 125:
                    Wc_16Civic_RemoteActi.this.m66D13();
                    break;
                case 126:
                    Wc_16Civic_RemoteActi.this.m66D12();
                    break;
                case 127:
                    Wc_16Civic_RemoteActi.this.m66D11();
                    break;
                case 128:
                    Wc_16Civic_RemoteActi.this.m66D10();
                    break;
                case 183:
                    int switchOn = value & 255;
                    ((CheckedTextView) Wc_16Civic_RemoteActi.this.findViewById(R.id.ctv_checkedtext5)).setChecked(switchOn == 1);
                    if (switchOn == 1) {
                        ((TextView) Wc_16Civic_RemoteActi.this.findViewById(R.id.tv_text5)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
                        break;
                    } else {
                        ((TextView) Wc_16Civic_RemoteActi.this.findViewById(R.id.tv_text5)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_321_civic_remote);
        init();
    }

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[125] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 4;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(103, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[126] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 3;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(103, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[127] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 2;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(103, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[128] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 1;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(103, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[183] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 5;
                iArr[1] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(103, iArr, null, null);
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
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
    }

    
    public void m66D13() {
        int temp = DataCanbus.DATA[125] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(switchOn == 1);
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_right_camera_open);
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_right_camera_close);
        }
    }

    
    public void m66D12() {
        int temp = DataCanbus.DATA[126] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(switchOn == 1);
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_right_camera_open);
        } else {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_right_camera_close);
        }
    }

    
    public void m66D11() {
        int temp = DataCanbus.DATA[127] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(switchOn == 1);
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.distance_far);
        } else {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.distance_close);
        }
    }

    
    public void m66D10() {
        int temp = DataCanbus.DATA[128] & 65535;
        int switchOn = temp & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(switchOn == 1);
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_right_camera_open);
        } else {
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_right_camera_close);
        }
    }
}
