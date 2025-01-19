package com.syu.carinfo.psa;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class PsaDs5lsSettingActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 108:
                    PsaDs5lsSettingActi.this.mUpdaterValue2();
                    break;
                case 109:
                    PsaDs5lsSettingActi.this.mUpdaterValue1();
                    break;
                case 112:
                    PsaDs5lsSettingActi.this.mUpdaterValue3();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_psads5ls_setting);
        init();
    }

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.psads5ls_auto_park)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[109];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(6, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.psads5ls_park_assist)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[108];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.psads5ls_daytime_running_lights)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[112];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(4, iArr, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[109];
        if (((CheckedTextView) findViewById(R.id.psads5ls_auto_park)) != null) {
            ((CheckedTextView) findViewById(R.id.psads5ls_auto_park)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[108];
        if (((CheckedTextView) findViewById(R.id.psads5ls_park_assist)) != null) {
            ((CheckedTextView) findViewById(R.id.psads5ls_park_assist)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[112];
        if (((CheckedTextView) findViewById(R.id.psads5ls_daytime_running_lights)) != null) {
            ((CheckedTextView) findViewById(R.id.psads5ls_daytime_running_lights)).setChecked(value != 0);
        }
    }
}
