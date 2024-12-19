package com.syu.carinfo.psa;

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
public class Psa3008settingActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.psa.Psa3008settingActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 10:
                    Psa3008settingActi.this.mUpdaterValue2();
                    break;
                case 11:
                    Psa3008settingActi.this.mUpdaterValue3();
                    break;
                case 12:
                    Psa3008settingActi.this.uAutoLockDoor(DataCanbus.DATA[updateCode]);
                    break;
                case 13:
                    Psa3008settingActi.this.uLockDoor(DataCanbus.DATA[updateCode]);
                    break;
                case 14:
                    Psa3008settingActi.this.mUpdaterValue1();
                    break;
                case 15:
                    Psa3008settingActi.this.mUpdaterValue4();
                    break;
                case 16:
                    Psa3008settingActi.this.mUpdaterValue5();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_psa3008_setting);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((CheckedTextView) findViewById(R.id.psa3008_parking_rear_window_wiping)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa3008settingActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[10];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(0, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.psa3008_parking_assist)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa3008settingActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[11];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.psa3008_btn_lock_door_unlocking)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa3008settingActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[14];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(3, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.psa3008_daytime_running_lights)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa3008settingActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[15];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value == 0 ? 0 : 1;
                remoteModuleProxy.cmd(4, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.psa3008_with_me_home_lighting_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa3008settingActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[16] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(5, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psa3008_with_me_home_lighting_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.Psa3008settingActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[16] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(5, new int[]{value}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[14];
        if (((CheckedTextView) findViewById(R.id.psa3008_btn_lock_door_unlocking)) != null) {
            ((CheckedTextView) findViewById(R.id.psa3008_btn_lock_door_unlocking)).setChecked(value != 0);
        }
        if (((TextView) findViewById(R.id.psa3008_tv_lock_door_unlocking)) != null) {
            ((TextView) findViewById(R.id.psa3008_tv_lock_door_unlocking)).setText(value != 0 ? R.string.lock_set_unlock_intelligent_door_driver : R.string.lock_set_unlock_intelligent_door_all);
        }
    }

    protected void uLockDoor(int i) {
        if (((CheckedTextView) findViewById(R.id.psa3008_lock_door)) != null) {
            ((CheckedTextView) findViewById(R.id.psa3008_lock_door)).setChecked(i != 0);
        }
    }

    protected void uAutoLockDoor(int i) {
        if (((CheckedTextView) findViewById(R.id.psa3008_autolock_door)) != null) {
            ((CheckedTextView) findViewById(R.id.psa3008_autolock_door)).setChecked(i != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[10];
        if (((CheckedTextView) findViewById(R.id.psa3008_parking_rear_window_wiping)) != null) {
            ((CheckedTextView) findViewById(R.id.psa3008_parking_rear_window_wiping)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[11];
        if (((CheckedTextView) findViewById(R.id.psa3008_parking_assist)) != null) {
            ((CheckedTextView) findViewById(R.id.psa3008_parking_assist)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue4() {
        int value = DataCanbus.DATA[15];
        if (((CheckedTextView) findViewById(R.id.psa3008_daytime_running_lights)) != null) {
            ((CheckedTextView) findViewById(R.id.psa3008_daytime_running_lights)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue5() {
        int value = DataCanbus.DATA[16];
        if (((TextView) findViewById(R.id.psa3008_with_me_home_lighting)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.psa3008_with_me_home_lighting)).setText("15s");
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.psa3008_with_me_home_lighting)).setText("30s");
            } else if (value == 3) {
                ((TextView) findViewById(R.id.psa3008_with_me_home_lighting)).setText("60s");
            } else {
                ((TextView) findViewById(R.id.psa3008_with_me_home_lighting)).setText(R.string.off);
            }
        }
    }
}
