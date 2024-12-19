package com.syu.carinfo.dj;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class DjBYDG6 extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dj.DjBYDG6.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 17:
                    DjBYDG6.this.mUpdaterAutoUnlock();
                    break;
                case 18:
                    DjBYDG6.this.mUpdaterAssiLight();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_151_dj_bydg6);
        ((CheckedTextView) findViewById(R.id.dj_airuize7_auto_unlock)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dj.DjBYDG6.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[17];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = value == 1 ? 16 : 1;
                iArr[1] = 255;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.dj_airuize7_assi_lamp)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dj.DjBYDG6.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[18];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 255;
                iArr[1] = value != 1 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutoUnlock() {
        int value = DataCanbus.DATA[17];
        ((CheckedTextView) findViewById(R.id.dj_airuize7_auto_unlock)).setChecked(value == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAssiLight() {
        int value = DataCanbus.DATA[18];
        ((CheckedTextView) findViewById(R.id.dj_airuize7_assi_lamp)).setChecked(value == 1);
    }
}
