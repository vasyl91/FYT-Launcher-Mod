package com.syu.carinfo.psa;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class PsaC5settingActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.psa.PsaC5settingActi.1
        @Override // com.syu.module.IUiNotify
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_psac5_setting);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((CheckedTextView) findViewById(R.id.psac5_door_auto_lock)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.PsaC5settingActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[109];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(9, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.psac5_door_lock)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.PsaC5settingActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[110];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(10, iArr, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[109];
        if (((CheckedTextView) findViewById(R.id.psac5_door_auto_lock)) != null) {
            ((CheckedTextView) findViewById(R.id.psac5_door_auto_lock)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[110];
        if (((CheckedTextView) findViewById(R.id.psac5_door_lock)) != null) {
            ((CheckedTextView) findViewById(R.id.psac5_door_lock)).setChecked(value != 0);
        }
    }
}
