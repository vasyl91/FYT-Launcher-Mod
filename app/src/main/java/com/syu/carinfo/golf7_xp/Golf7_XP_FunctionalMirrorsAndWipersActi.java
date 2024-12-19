package com.syu.carinfo.golf7_xp;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Golf7_XP_FunctionalMirrorsAndWipersActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalMirrorsAndWipersActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 51:
                    Golf7_XP_FunctionalMirrorsAndWipersActi.this.mUpdaterSynchronousAdjustment();
                    break;
                case 52:
                    Golf7_XP_FunctionalMirrorsAndWipersActi.this.mUpdaterLoweReversing();
                    break;
                case 53:
                    Golf7_XP_FunctionalMirrorsAndWipersActi.this.mUpdaterFoldIn();
                    break;
                case 54:
                    Golf7_XP_FunctionalMirrorsAndWipersActi.this.mUpdaterAutoWiping();
                    break;
                case 55:
                    Golf7_XP_FunctionalMirrorsAndWipersActi.this.mUpdaterRearWindow();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_golf7_functional_state_mirrors_and_wipers);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_synchronous_adjustment)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalMirrorsAndWipersActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[51] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 96;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_lower_while_reversing)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalMirrorsAndWipersActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[52] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 97;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_fold_in_when_parded)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalMirrorsAndWipersActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[53] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 100;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_automatic_wiping_in_rain)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalMirrorsAndWipersActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[54] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 98;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_rear_window_wiping_in_resverse_gear)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalMirrorsAndWipersActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[55] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 99;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSynchronousAdjustment() {
        int value = DataCanbus.DATA[51];
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_synchronous_adjustment)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLoweReversing() {
        int value = DataCanbus.DATA[52];
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_lower_while_reversing)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterFoldIn() {
        int value = DataCanbus.DATA[53];
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_fold_in_when_parded)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutoWiping() {
        int value = DataCanbus.DATA[54];
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_automatic_wiping_in_rain)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRearWindow() {
        int value = DataCanbus.DATA[55];
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_rear_window_wiping_in_resverse_gear)).setChecked(value != 0);
    }
}
