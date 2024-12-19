package com.syu.carinfo.golf7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Golf7FunctionalMirrorsAndWipersActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.Golf7FunctionalMirrorsAndWipersActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 51:
                    Golf7FunctionalMirrorsAndWipersActi.this.mUpdaterSynchronousAdjustment();
                    break;
                case 52:
                    Golf7FunctionalMirrorsAndWipersActi.this.mUpdaterLoweReversing();
                    break;
                case 53:
                    Golf7FunctionalMirrorsAndWipersActi.this.mUpdaterFoldIn();
                    break;
                case 54:
                    Golf7FunctionalMirrorsAndWipersActi.this.mUpdaterAutoWiping();
                    break;
                case 55:
                    Golf7FunctionalMirrorsAndWipersActi.this.mUpdaterRearWindow();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            setContentView(R.layout.layout_golf7_functional_state_mirrors_and_wipers_od);
        } else {
            setContentView(R.layout.layout_golf7_functional_state_mirrors_and_wipers);
        }
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            ((Button) findViewById(R.id.glf7_btn_car_back_od)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalMirrorsAndWipersActi.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(Golf7FunctionalMirrorsAndWipersActi.this, Golf7FunctionalActiOD.class);
                        Golf7FunctionalMirrorsAndWipersActi.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_synchronous_adjustment)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalMirrorsAndWipersActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[51] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(67, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_lower_while_reversing)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalMirrorsAndWipersActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[52] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(68, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_fold_in_when_parded)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalMirrorsAndWipersActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[53] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(69, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_automatic_wiping_in_rain)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalMirrorsAndWipersActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[54] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(70, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_rear_window_wiping_in_resverse_gear)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalMirrorsAndWipersActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[55] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(71, iArr, null, null);
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
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            findViewById(R.id.glf7_view_functional_mirrors_and_wipers_synchronous_adjustment).setVisibility(enable == 0 ? 8 : 0);
            ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_synchronous_adjustment)).setChecked(switchOn != 0);
            return;
        }
        findViewById(R.id.glf7_view_functional_mirrors_and_wipers_synchronous_adjustment).setVisibility(0);
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_synchronous_adjustment)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLoweReversing() {
        int value = DataCanbus.DATA[52];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            findViewById(R.id.glf7_view_functional_mirrors_and_wipers_lower_while_reversing).setVisibility(enable == 0 ? 8 : 0);
            ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_lower_while_reversing)).setChecked(switchOn != 0);
            return;
        }
        findViewById(R.id.glf7_view_functional_mirrors_and_wipers_lower_while_reversing).setVisibility(0);
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_lower_while_reversing)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterFoldIn() {
        int value = DataCanbus.DATA[53];
        if (ConstGolf.isWcGolf()) {
            int switchOn = value & 255;
            findViewById(R.id.glf7_view_functional_mirrors_and_wipers_fold_in_when_parded).setVisibility(1 == 0 ? 8 : 0);
            ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_fold_in_when_parded)).setChecked(switchOn != 0);
        } else {
            findViewById(R.id.glf7_view_functional_mirrors_and_wipers_fold_in_when_parded).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_fold_in_when_parded)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutoWiping() {
        int value = DataCanbus.DATA[54];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            findViewById(R.id.glf7_view_functional_mirrors_and_wipers_automatic_wiping_in_rain).setVisibility(enable == 0 ? 8 : 0);
            ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_automatic_wiping_in_rain)).setChecked(switchOn != 0);
            return;
        }
        findViewById(R.id.glf7_view_functional_mirrors_and_wipers_automatic_wiping_in_rain).setVisibility(0);
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_automatic_wiping_in_rain)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRearWindow() {
        int value = DataCanbus.DATA[55];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            findViewById(R.id.glf7_view_functional_mirrors_and_wipers_rear_window_wiping_in_resverse_gear).setVisibility(enable == 0 ? 8 : 0);
            ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_rear_window_wiping_in_resverse_gear)).setChecked(switchOn != 0);
            return;
        }
        findViewById(R.id.glf7_view_functional_mirrors_and_wipers_rear_window_wiping_in_resverse_gear).setVisibility(0);
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_rear_window_wiping_in_resverse_gear)).setChecked(value != 0);
    }
}
