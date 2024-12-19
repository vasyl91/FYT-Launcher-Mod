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
public class Golf7_XP_FunctionalParkingAndManoeurvrinActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalParkingAndManoeurvrinActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 19:
                    Golf7_XP_FunctionalParkingAndManoeurvrinActi.this.mUpdaterActivateAutomaticlly();
                    break;
                case 20:
                    Golf7_XP_FunctionalParkingAndManoeurvrinActi.this.mUpdaterFrontVolumn();
                    break;
                case 21:
                    Golf7_XP_FunctionalParkingAndManoeurvrinActi.this.mUpdaterFrontTone();
                    break;
                case 22:
                    Golf7_XP_FunctionalParkingAndManoeurvrinActi.this.mUpdaterRearVol();
                    break;
                case 23:
                    Golf7_XP_FunctionalParkingAndManoeurvrinActi.this.mUpdaterRearTone();
                    break;
                case 25:
                    Golf7_XP_FunctionalParkingAndManoeurvrinActi.this.mUpdaterRadarVol();
                    break;
                case 150:
                    Golf7_XP_FunctionalParkingAndManoeurvrinActi.this.updateActivateMaticlly();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_golf7_functional_state_parking_and_manoeurvring_xp);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_activate_automaticlly), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalParkingAndManoeurvrinActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[19] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 64;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_activate_maticlly), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalParkingAndManoeurvrinActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[150] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 69;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_front_volumn_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalParkingAndManoeurvrinActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[20] & 255;
                if (mValue > 1) {
                    mValue--;
                }
                DataCanbus.PROXY.cmd(107, new int[]{65, mValue}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_front_volumn_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalParkingAndManoeurvrinActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[20] & 255;
                if (mValue < 9) {
                    mValue++;
                }
                DataCanbus.PROXY.cmd(107, new int[]{65, mValue}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_front_tone_setting_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalParkingAndManoeurvrinActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[21] & 255;
                if (mValue > 1) {
                    mValue--;
                }
                DataCanbus.PROXY.cmd(107, new int[]{66, mValue}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_front_tone_setting_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalParkingAndManoeurvrinActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[21] & 255;
                if (mValue < 9) {
                    mValue++;
                }
                DataCanbus.PROXY.cmd(107, new int[]{66, mValue}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_Rear_volumn_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalParkingAndManoeurvrinActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[22] & 255;
                if (mValue > 1) {
                    mValue--;
                }
                DataCanbus.PROXY.cmd(107, new int[]{67, mValue}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_Rear_volumn_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalParkingAndManoeurvrinActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[22] & 255;
                if (mValue < 9) {
                    mValue++;
                }
                DataCanbus.PROXY.cmd(107, new int[]{67, mValue}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_Rear_tone_setting_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalParkingAndManoeurvrinActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[23] & 255;
                if (mValue > 1) {
                    mValue--;
                }
                DataCanbus.PROXY.cmd(107, new int[]{68, mValue}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_Rear_tone_setting_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalParkingAndManoeurvrinActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[23] & 255;
                if (mValue < 9) {
                    mValue++;
                }
                DataCanbus.PROXY.cmd(107, new int[]{68, mValue}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_radar_volumn), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalParkingAndManoeurvrinActi.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[25] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 171;
                iArr[1] = mValue == 0 ? 1 : 0;
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
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterActivateAutomaticlly() {
        int value = DataCanbus.DATA[19];
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_activate_automaticlly)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateActivateMaticlly() {
        int value = DataCanbus.DATA[150];
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_activate_maticlly)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterFrontVolumn() {
        int value = DataCanbus.DATA[20];
        ((TextView) findViewById(R.id.glf7_tv_functional_parking_and_manoeurvring_front_volumn)).setText(new StringBuilder().append(value).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterFrontTone() {
        int value = DataCanbus.DATA[21];
        ((TextView) findViewById(R.id.glf7_tv_functional_parking_and_manoeurvring_front_tone_setting)).setText(new StringBuilder().append(value).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRearVol() {
        int value = DataCanbus.DATA[22];
        ((TextView) findViewById(R.id.glf7_tv_functional_parking_and_manoeurvring_Rear_volumn)).setText(new StringBuilder().append(value).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRearTone() {
        int value = DataCanbus.DATA[23];
        ((TextView) findViewById(R.id.glf7_tv_functional_parking_and_manoeurvring_Rear_tone_setting)).setText(new StringBuilder().append(value).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRadarVol() {
        int mValue = DataCanbus.DATA[25] & 255;
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_radar_volumn)).setChecked(mValue != 0);
    }
}
