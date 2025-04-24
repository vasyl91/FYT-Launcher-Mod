package com.syu.carinfo.lifan720;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class LiFan720IndexAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    LiFan720IndexAct.this.updaterFirstStart();
                    break;
                case 99:
                    LiFan720IndexAct.this.updaterSmartInsert();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_lifan720);
        init();
    }

    @Override
    public void init() {
        findViewById(R.id.tv_rzc720_radaron_check).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[99] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        findViewById(R.id.tv_rzc720_warringvol_check).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[98] & 255;
                if (switchOn == 255) {
                    DataCanbus.PROXY.cmd(0, new int[1], null, null);
                } else {
                    DataCanbus.PROXY.cmd(0, new int[]{255}, null, null);
                }
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
    }

    
    public void updaterSmartInsert() {
        int mSmartInsertState = DataCanbus.DATA[99];
        ((CheckedTextView) findViewById(R.id.tv_rzc720_radaron_check)).setChecked(mSmartInsertState != 0);
    }

    
    public void updaterFirstStart() {
        int mFirstStartState = DataCanbus.DATA[98];
        ((CheckedTextView) findViewById(R.id.tv_rzc720_warringvol_check)).setChecked(mFirstStartState != 0);
    }
}
