package com.syu.carinfo.golf7_xp;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Golf7_XP_FunctionalMirrorsAndWipersActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 148:
                    Golf7_XP_FunctionalMirrorsAndWipersActi.this.mUpdaterSynchronousAdjustment();
                    break;
                case 149:
                    Golf7_XP_FunctionalMirrorsAndWipersActi.this.mUpdaterLoweReversing();
                    break;
                case 150:
                    Golf7_XP_FunctionalMirrorsAndWipersActi.this.mUpdaterFoldIn();
                    break;
                case 151:
                    Golf7_XP_FunctionalMirrorsAndWipersActi.this.mUpdaterAutoWiping();
                    break;
                case 152:
                    Golf7_XP_FunctionalMirrorsAndWipersActi.this.mUpdaterRearWindow();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_golf7_functional_state_mirrors_and_wipers);
        init();
    }

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_synchronous_adjustment)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[148] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 96;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_lower_while_reversing)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[149] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 97;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_fold_in_when_parded)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[150] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 100;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_automatic_wiping_in_rain)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[151] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 98;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_rear_window_wiping_in_resverse_gear)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[152] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 99;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
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
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_synchronous_adjustment)).setChecked(value != 0);
    }

    
    public void mUpdaterLoweReversing() {
        int value = DataCanbus.DATA[149];
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_lower_while_reversing)).setChecked(value != 0);
    }

    
    public void mUpdaterFoldIn() {
        int value = DataCanbus.DATA[150];
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_fold_in_when_parded)).setChecked(value != 0);
    }

    
    public void mUpdaterAutoWiping() {
        int value = DataCanbus.DATA[151];
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_automatic_wiping_in_rain)).setChecked(value != 0);
    }

    
    public void mUpdaterRearWindow() {
        int value = DataCanbus.DATA[152];
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_mirrors_and_wipers_rear_window_wiping_in_resverse_gear)).setChecked(value != 0);
    }
}
