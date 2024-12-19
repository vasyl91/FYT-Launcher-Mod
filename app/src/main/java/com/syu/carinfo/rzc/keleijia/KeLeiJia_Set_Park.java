package com.syu.carinfo.rzc.keleijia;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class KeLeiJia_Set_Park extends BaseActivity {
    private int[] eventsIDs = {41, 77};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.keleijia.KeLeiJia_Set_Park.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 41:
                case 77:
                    int val = DataCanbus.DATA[updateCode];
                    if (((CheckedTextView) KeLeiJia_Set_Park.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) KeLeiJia_Set_Park.this.findViewById(R.id.ctv_checkedtext1)).setChecked(val != 0);
                        break;
                    }
            }
        }
    };
    View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.syu.carinfo.rzc.keleijia.KeLeiJia_Set_Park.2
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ctv_checkedtext1 /* 2131427478 */:
                    if (DataCanbus.DATA[1000] == 1048978 || DataCanbus.DATA[1000] == 1376658 || DataCanbus.DATA[1000] == 1769874 || DataCanbus.DATA[1000] == 402 || DataCanbus.DATA[1000] == 197010 || ((DataCanbus.DATA[1000] & 65535) == 402 && ((DataCanbus.DATA[1000] >> 16) & 65535) >= 10)) {
                        int value = DataCanbus.DATA[77] & 255;
                        RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                        int[] iArr = new int[2];
                        iArr[0] = 32;
                        iArr[1] = value != 1 ? 1 : 0;
                        remoteModuleProxy.cmd(1, iArr, null, null);
                        break;
                    } else {
                        int value2 = DataCanbus.DATA[34] & 255;
                        RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                        int[] iArr2 = new int[2];
                        iArr2[0] = 71;
                        iArr2[1] = value2 != 1 ? 1 : 0;
                        remoteModuleProxy2.cmd(1, iArr2, null, null);
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bsd_keleijia_set_park);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        checkAndSetListener((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this.mClickListener);
    }

    void checkAndSetListener(View v, View.OnClickListener clickListener) {
        if (v != null) {
            v.setOnClickListener(clickListener);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        for (int i = 0; i < this.eventsIDs.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventsIDs[i]].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        for (int i = 0; i < this.eventsIDs.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventsIDs[i]].removeNotify(this.mNotifyCanbus);
        }
    }
}
