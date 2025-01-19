package com.syu.carinfo.psa;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class PsaC5settingActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 109:
                    PsaC5settingActi.this.mUpdaterValue1();
                    break;
                case 110:
                    PsaC5settingActi.this.mUpdaterValue2();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_psac5_setting);
        init();
    }

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.psac5_door_auto_lock)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[109];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(9, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.psac5_door_lock)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[110];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(10, iArr, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[109];
        if (((CheckedTextView) findViewById(R.id.psac5_door_auto_lock)) != null) {
            ((CheckedTextView) findViewById(R.id.psac5_door_auto_lock)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[110];
        if (((CheckedTextView) findViewById(R.id.psac5_door_lock)) != null) {
            ((CheckedTextView) findViewById(R.id.psac5_door_lock)).setChecked(value != 0);
        }
    }
}
