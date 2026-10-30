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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Golf7_XP_FunctionalParkingAndManoeurvrinActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalParkingAndManoeurvrinActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 116:
                    Golf7_XP_FunctionalParkingAndManoeurvrinActi.this.mUpdaterActivateAutomaticlly();
                    break;
                case 117:
                    Golf7_XP_FunctionalParkingAndManoeurvrinActi.this.mUpdaterFrontVolumn();
                    break;
                case 118:
                    Golf7_XP_FunctionalParkingAndManoeurvrinActi.this.mUpdaterFrontTone();
                    break;
                case 119:
                    Golf7_XP_FunctionalParkingAndManoeurvrinActi.this.mUpdaterRearVol();
                    break;
                case 120:
                    Golf7_XP_FunctionalParkingAndManoeurvrinActi.this.mUpdaterRearTone();
                    break;
                case 122:
                    Golf7_XP_FunctionalParkingAndManoeurvrinActi.this.mUpdaterRadarVol();
                    break;
                case 204:
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
                int switchOn = DataCanbus.DATA[116] & 255;
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
                int switchOn = DataCanbus.DATA[204] & 255;
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
                int mValue = DataCanbus.DATA[117] & 255;
                if (mValue > 1) {
                    mValue--;
                }
                DataCanbus.PROXY.cmd(107, new int[]{65, mValue}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_front_volumn_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalParkingAndManoeurvrinActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[117] & 255;
                if (mValue < 9) {
                    mValue++;
                }
                DataCanbus.PROXY.cmd(107, new int[]{65, mValue}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_front_tone_setting_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalParkingAndManoeurvrinActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[118] & 255;
                if (mValue > 1) {
                    mValue--;
                }
                DataCanbus.PROXY.cmd(107, new int[]{66, mValue}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_front_tone_setting_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalParkingAndManoeurvrinActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[118] & 255;
                if (mValue < 9) {
                    mValue++;
                }
                DataCanbus.PROXY.cmd(107, new int[]{66, mValue}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_Rear_volumn_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalParkingAndManoeurvrinActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[119] & 255;
                if (mValue > 1) {
                    mValue--;
                }
                DataCanbus.PROXY.cmd(107, new int[]{67, mValue}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_Rear_volumn_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalParkingAndManoeurvrinActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[119] & 255;
                if (mValue < 9) {
                    mValue++;
                }
                DataCanbus.PROXY.cmd(107, new int[]{67, mValue}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_Rear_tone_setting_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalParkingAndManoeurvrinActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[120] & 255;
                if (mValue > 1) {
                    mValue--;
                }
                DataCanbus.PROXY.cmd(107, new int[]{68, mValue}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_Rear_tone_setting_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalParkingAndManoeurvrinActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[120] & 255;
                if (mValue < 9) {
                    mValue++;
                }
                DataCanbus.PROXY.cmd(107, new int[]{68, mValue}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_radar_volumn), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalParkingAndManoeurvrinActi.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[122] & 255;
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
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[204].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[204].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterActivateAutomaticlly() {
        int value = DataCanbus.DATA[116];
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_activate_automaticlly)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateActivateMaticlly() {
        int value = DataCanbus.DATA[204];
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_activate_maticlly)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterFrontVolumn() {
        int value = DataCanbus.DATA[117];
        ((TextView) findViewById(R.id.glf7_tv_functional_parking_and_manoeurvring_front_volumn)).setText(new StringBuilder().append(value).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterFrontTone() {
        int value = DataCanbus.DATA[118];
        ((TextView) findViewById(R.id.glf7_tv_functional_parking_and_manoeurvring_front_tone_setting)).setText(new StringBuilder().append(value).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRearVol() {
        int value = DataCanbus.DATA[119];
        ((TextView) findViewById(R.id.glf7_tv_functional_parking_and_manoeurvring_Rear_volumn)).setText(new StringBuilder().append(value).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRearTone() {
        int value = DataCanbus.DATA[120];
        ((TextView) findViewById(R.id.glf7_tv_functional_parking_and_manoeurvring_Rear_tone_setting)).setText(new StringBuilder().append(value).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRadarVol() {
        int mValue = DataCanbus.DATA[122] & 255;
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_radar_volumn)).setChecked(mValue != 0);
    }
}
