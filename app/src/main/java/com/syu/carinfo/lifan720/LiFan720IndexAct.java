package com.syu.carinfo.lifan720;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LiFan720IndexAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lifan720.LiFan720IndexAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 0:
                    LiFan720IndexAct.this.updaterFirstStart();
                    break;
                case 1:
                    LiFan720IndexAct.this.updaterSmartInsert();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_lifan720);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        findViewById(R.id.tv_rzc720_radaron_check).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lifan720.LiFan720IndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[1] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        findViewById(R.id.tv_rzc720_warringvol_check).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lifan720.LiFan720IndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[0] & 255;
                if (switchOn == 255) {
                    DataCanbus.PROXY.cmd(0, new int[1], null, null);
                } else {
                    DataCanbus.PROXY.cmd(0, new int[]{255}, null, null);
                }
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSmartInsert() {
        int mSmartInsertState = DataCanbus.DATA[1];
        ((CheckedTextView) findViewById(R.id.tv_rzc720_radaron_check)).setChecked(mSmartInsertState != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFirstStart() {
        int mFirstStartState = DataCanbus.DATA[0];
        ((CheckedTextView) findViewById(R.id.tv_rzc720_warringvol_check)).setChecked(mFirstStartState != 0);
    }
}
