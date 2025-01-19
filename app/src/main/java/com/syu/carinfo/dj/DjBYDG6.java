package com.syu.carinfo.dj;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class DjBYDG6 extends BaseActivity {
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 107:
                    DjBYDG6.this.mUpdaterAutoUnlock();
                    break;
                case 108:
                    DjBYDG6.this.mUpdaterAssiLight();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_151_dj_bydg6);
        findViewById(R.id.dj_airuize7_auto_unlock).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[107];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = value == 1 ? 16 : 1;
                iArr[1] = 255;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        findViewById(R.id.dj_airuize7_assi_lamp).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[108];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 255;
                iArr[1] = value != 1 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterAutoUnlock() {
        int value = DataCanbus.DATA[107];
        ((CheckedTextView) findViewById(R.id.dj_airuize7_auto_unlock)).setChecked(value == 1);
    }

    
    public void mUpdaterAssiLight() {
        int value = DataCanbus.DATA[108];
        ((CheckedTextView) findViewById(R.id.dj_airuize7_assi_lamp)).setChecked(value == 1);
    }
}
