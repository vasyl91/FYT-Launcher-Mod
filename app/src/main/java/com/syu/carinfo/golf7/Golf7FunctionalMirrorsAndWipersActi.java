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

@SuppressWarnings({"deprecation", "unchecked"})
public class Golf7FunctionalMirrorsAndWipersActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 148:
                    Golf7FunctionalMirrorsAndWipersActi.this.mUpdaterSynchronousAdjustment();
                    break;
                case 149:
                    Golf7FunctionalMirrorsAndWipersActi.this.mUpdaterLoweReversing();
                    break;
                case 150:
                    Golf7FunctionalMirrorsAndWipersActi.this.mUpdaterFoldIn();
                    break;
                case 151:
                    Golf7FunctionalMirrorsAndWipersActi.this.mUpdaterAutoWiping();
                    break;
                case 152:
                    Golf7FunctionalMirrorsAndWipersActi.this.mUpdaterRearWindow();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            //setContentView(R.layout.layout_golf7_functional_state_mirrors_and_wipers_od);
        } else {
            //setContentView(R.layout.layout_golf7_functional_state_mirrors_and_wipers);
        }
        init();
    }

    @Override
    public void init() {
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            ((Button) findViewById(R.id.glf7_btn_car_back_od)).setOnClickListener(new View.OnClickListener() { 
                @Override
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
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_synchronous_adjustment)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[148] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(67, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_lower_while_reversing)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[149] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(68, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_fold_in_when_parded)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[150] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(69, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_automatic_wiping_in_rain)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[151] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(70, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_rear_window_wiping_in_resverse_gear)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[152] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(71, iArr, null, null);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterSynchronousAdjustment() {
        int value = DataCanbus.DATA[148];
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

    
    public void mUpdaterLoweReversing() {
        int value = DataCanbus.DATA[149];
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

    
    public void mUpdaterFoldIn() {
        int value = DataCanbus.DATA[150];
        if (ConstGolf.isWcGolf()) {
            int switchOn = value & 255;
            findViewById(R.id.glf7_view_functional_mirrors_and_wipers_fold_in_when_parded).setVisibility(1 == 0 ? 8 : 0);
            ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_fold_in_when_parded)).setChecked(switchOn != 0);
        } else {
            findViewById(R.id.glf7_view_functional_mirrors_and_wipers_fold_in_when_parded).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_fold_in_when_parded)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterAutoWiping() {
        int value = DataCanbus.DATA[151];
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

    
    public void mUpdaterRearWindow() {
        int value = DataCanbus.DATA[152];
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
