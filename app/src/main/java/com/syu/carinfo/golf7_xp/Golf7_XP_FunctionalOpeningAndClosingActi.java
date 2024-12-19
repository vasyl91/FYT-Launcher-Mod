package com.syu.carinfo.golf7_xp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Golf7_XP_FunctionalOpeningAndClosingActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalOpeningAndClosingActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 39:
                    Golf7_XP_FunctionalOpeningAndClosingActi.this.mUpdaterConvenience();
                    break;
                case 40:
                    Golf7_XP_FunctionalOpeningAndClosingActi.this.mUpdaterDoorUnlock();
                    break;
                case 41:
                    Golf7_XP_FunctionalOpeningAndClosingActi.this.mUpdaterAutoLock();
                    break;
                case 144:
                    Golf7_XP_FunctionalOpeningAndClosingActi.this.mUpdaterRemindpair();
                    break;
                case 145:
                    Golf7_XP_FunctionalOpeningAndClosingActi.this.mUpdaterSenselan();
                    break;
                case 170:
                    Golf7_XP_FunctionalOpeningAndClosingActi.this.setCheck((CheckedTextView) Golf7_XP_FunctionalOpeningAndClosingActi.this.findViewById(R.id.ctv_checkedtext1), value != 0);
                    break;
                case 178:
                    Golf7_XP_FunctionalOpeningAndClosingActi.this.setCheck((CheckedTextView) Golf7_XP_FunctionalOpeningAndClosingActi.this.findViewById(R.id.ctv_checkedtext2), value != 0);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_golf7_functional_state_opening_and_closing_xp);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_opening_and_closing_automatic_locking), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalOpeningAndClosingActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[41] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 114;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_opening_and_closing_remindpair), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalOpeningAndClosingActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[144] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 202;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_opening_and_closing_senselan), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalOpeningAndClosingActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[145] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 115;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalOpeningAndClosingActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[170] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 201;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalOpeningAndClosingActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[178] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 116;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_opening_and_closing_door_unlocking_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalOpeningAndClosingActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[40] & 255) - 1;
                if (switchOn == 0) {
                    switchOn = 2;
                }
                DataCanbus.PROXY.cmd(107, new int[]{113, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_opening_and_closing_door_unlocking_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalOpeningAndClosingActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[40] & 255) + 1;
                if (switchOn > 2) {
                    switchOn = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{113, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_opening_and_closing_convenience_opening_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalOpeningAndClosingActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[39] & 255) - 1;
                if (switchOn == 0) {
                    switchOn = 2;
                }
                DataCanbus.PROXY.cmd(107, new int[]{112, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_opening_and_closing_convenience_opening_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalOpeningAndClosingActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[39] & 255) + 1;
                if (switchOn > 2) {
                    switchOn = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{112, switchOn}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRemindpair() {
        int value = DataCanbus.DATA[144];
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_opening_and_closing_remindpair), value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSenselan() {
        int value = DataCanbus.DATA[145];
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_opening_and_closing_senselan), value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutoLock() {
        int value = DataCanbus.DATA[41];
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_opening_and_closing_automatic_locking), value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDoorUnlock() {
        int value = DataCanbus.DATA[40];
        if (value == 0) {
            ((TextView) findViewById(R.id.glf7_tv_functional_opening_and_closing_door_unlocking)).setText(R.string.door_unlocking_vehicle_side);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.glf7_tv_functional_opening_and_closing_door_unlocking)).setText(R.string.door_unlocking_single_door);
        } else if (value == 2) {
            ((TextView) findViewById(R.id.glf7_tv_functional_opening_and_closing_door_unlocking)).setText(R.string.door_unlocking_all_doors);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterConvenience() {
        int value = DataCanbus.DATA[39];
        if (value == 0) {
            ((TextView) findViewById(R.id.glf7_tv_functional_opening_and_closing_convenience_opening)).setText(R.string.convenience_opening_off);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.glf7_tv_functional_opening_and_closing_convenience_opening)).setText(R.string.convenience_opening_driver_window);
        } else if (value == 2) {
            ((TextView) findViewById(R.id.glf7_tv_functional_opening_and_closing_convenience_opening)).setText(R.string.convenience_opening_all_window);
        }
    }
}
