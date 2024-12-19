package com.syu.carinfo.golf7;

import android.content.Intent;
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
public class Golf7FunctionalParkingAndManoeurvrinActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 19:
                    Golf7FunctionalParkingAndManoeurvrinActi.this.mUpdaterActivateAutomaticlly();
                    break;
                case 20:
                    Golf7FunctionalParkingAndManoeurvrinActi.this.mUpdaterFrontVolumn();
                    break;
                case 21:
                    Golf7FunctionalParkingAndManoeurvrinActi.this.mUpdaterFrontTone();
                    break;
                case 22:
                    Golf7FunctionalParkingAndManoeurvrinActi.this.mUpdaterRearVol();
                    break;
                case 23:
                    Golf7FunctionalParkingAndManoeurvrinActi.this.mUpdaterRearTone();
                    break;
                case 24:
                    Golf7FunctionalParkingAndManoeurvrinActi.this.mUpdaterParkMode();
                    break;
                case 25:
                    Golf7FunctionalParkingAndManoeurvrinActi.this.mUpdaterRadarVol();
                    break;
                case 162:
                case 335:
                    Golf7FunctionalParkingAndManoeurvrinActi.this.updateActivateMaticlly();
                    break;
                case 194:
                case 337:
                    Golf7FunctionalParkingAndManoeurvrinActi.this.updateOutOfParkingAssist();
                    break;
                case 200:
                    Golf7FunctionalParkingAndManoeurvrinActi.this.updateOffRoadIcon();
                    break;
                case 234:
                case 336:
                    Golf7FunctionalParkingAndManoeurvrinActi.this.updateParkingBrake();
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
            setContentView(R.layout.layout_golf7_functional_state_parking_and_manoeurvring_od);
        } else {
            setContentView(R.layout.layout_golf7_functional_state_parking_and_manoeurvring);
        }
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            setSelfClick((Button) findViewById(R.id.glf7_btn_car_back_od), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(Golf7FunctionalParkingAndManoeurvrinActi.this, Golf7FunctionalActiOD.class);
                        Golf7FunctionalParkingAndManoeurvrinActi.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_activate_automaticlly), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[19] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(39, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_activate_maticlly), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[162] & 255;
                if (ConstGolf.isRZCGolf()) {
                    int switchOn2 = DataCanbus.DATA[335] & 255;
                    return;
                }
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(109, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_front_volumn_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[20] & 255;
                if (mValue > 0) {
                    DataCanbus.PROXY.cmd(40, new int[]{mValue - 1}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_front_volumn_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[20] & 255;
                if (mValue < 8) {
                    DataCanbus.PROXY.cmd(40, new int[]{mValue + 1}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_front_tone_setting_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[21] & 255;
                if (mValue > 0) {
                    DataCanbus.PROXY.cmd(41, new int[]{mValue - 1}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_front_tone_setting_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[21] & 255;
                if (mValue < 8) {
                    DataCanbus.PROXY.cmd(41, new int[]{mValue + 1}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_Rear_volumn_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[22] & 255;
                if (mValue > 0) {
                    DataCanbus.PROXY.cmd(42, new int[]{mValue - 1}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_Rear_volumn_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[22] & 255;
                if (mValue < 8) {
                    DataCanbus.PROXY.cmd(42, new int[]{mValue + 1}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_Rear_tone_setting_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[23] & 255;
                if (mValue > 0) {
                    DataCanbus.PROXY.cmd(43, new int[]{mValue - 1}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_Rear_tone_setting_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[23] & 255;
                if (mValue < 8) {
                    DataCanbus.PROXY.cmd(43, new int[]{mValue + 1}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_parking_mode_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[24] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = mValue == 1 ? 0 : 1;
                remoteModuleProxy.cmd(44, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_parking_mode_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[24] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = mValue == 1 ? 0 : 1;
                remoteModuleProxy.cmd(44, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_radar_volumn), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[25] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = mValue != 0 ? 0 : 1;
                remoteModuleProxy.cmd(30, iArr, null, null);
            }
        });
        if ((DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) && findViewById(R.id.layout_17_out_of_park_assist) != null) {
            findViewById(R.id.layout_17_out_of_park_assist).setVisibility(8);
        }
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_17_out_of_park_assist), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[194] & 255;
                if (ConstGolf.isRZCGolf()) {
                    int mValue2 = DataCanbus.DATA[337];
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 59;
                    iArr[1] = mValue2 == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(160, iArr, null, null);
                    return;
                }
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[1];
                iArr2[0] = mValue != 0 ? 0 : 1;
                remoteModuleProxy2.cmd(110, iArr2, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_17_parking_brake), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[234] & 255;
                if (ConstGolf.isRZCGolf()) {
                    int mValue2 = DataCanbus.DATA[336];
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 58;
                    iArr[1] = mValue2 == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(160, iArr, null, null);
                    return;
                }
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[1];
                iArr2[0] = mValue != 0 ? 0 : 1;
                remoteModuleProxy2.cmd(132, iArr2, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_17_off_road_icon), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[200] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = mValue != 0 ? 0 : 1;
                remoteModuleProxy.cmd(111, iArr, null, null);
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
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[200].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[234].addNotify(this.mNotifyCanbus, 1);
        if (ConstGolf.isRZCGolf()) {
            DataCanbus.NOTIFY_EVENTS[335].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[336].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[337].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[338].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[200].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[234].removeNotify(this.mNotifyCanbus);
        if (ConstGolf.isRZCGolf()) {
            DataCanbus.NOTIFY_EVENTS[335].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[336].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[337].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[338].removeNotify(this.mNotifyCanbus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterActivateAutomaticlly() {
        int value = DataCanbus.DATA[19];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_parking_and_manoeurvring_activate_automaticlly), enable != 0);
            ((CheckedTextView) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_activate_automaticlly)).setChecked(switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_parking_and_manoeurvring_activate_automaticlly), true);
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_activate_automaticlly)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateActivateMaticlly() {
        int value = DataCanbus.DATA[19];
        if (ConstGolf.isRZCGolf()) {
            value = DataCanbus.DATA[335];
        }
        if (DataCanbus.DATA[1000] == 437 || ConstGolf.isRZCGolf()) {
            setViewVisible(findViewById(R.id.glf7_view_functional_parking_and_manoeurvring_activate_maticlly), true);
            ((CheckedTextView) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_activate_maticlly)).setChecked(value != 0);
        } else {
            setViewVisible(findViewById(R.id.glf7_view_functional_parking_and_manoeurvring_activate_maticlly), false);
        }
    }

    public void updateOutOfParkingAssist() {
        int value = DataCanbus.DATA[194];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            if (DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
                setViewVisible(findViewById(R.id.layout_17_out_of_park_assist), false);
            } else {
                setViewVisible(findViewById(R.id.layout_17_out_of_park_assist), enable != 0);
            }
            ((CheckedTextView) findViewById(R.id.ctv_17_out_of_park_assist)).setChecked(switchOn != 0);
            return;
        }
        if (DataCanbus.DATA[1000] == 393256) {
            int i = (65280 & value) >> 8;
            int switchOn2 = value & 255;
            setViewVisible(findViewById(R.id.layout_17_out_of_park_assist), true);
            ((CheckedTextView) findViewById(R.id.ctv_17_out_of_park_assist)).setChecked(switchOn2 != 0);
            return;
        }
        if (ConstGolf.isRZCGolf()) {
            int switchOn3 = DataCanbus.DATA[337] & 255;
            setViewVisible(findViewById(R.id.layout_17_out_of_park_assist), true);
            ((CheckedTextView) findViewById(R.id.ctv_17_out_of_park_assist)).setChecked(switchOn3 != 0);
            return;
        }
        setViewVisible(findViewById(R.id.layout_17_out_of_park_assist), false);
    }

    public void updateOffRoadIcon() {
        int value = DataCanbus.DATA[200];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.layout_17_off_road_icon), enable != 0);
            ((CheckedTextView) findViewById(R.id.ctv_17_off_road_icon)).setChecked(switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.layout_17_off_road_icon), false);
    }

    public void updateParkingBrake() {
        int value = DataCanbus.DATA[234];
        if (ConstGolf.isWcGolf()) {
            int enable = (value & 65280) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.layout_17_parking_brake), enable != 0);
            ((CheckedTextView) findViewById(R.id.ctv_17_parking_brake)).setChecked(switchOn != 0);
            return;
        }
        if (DataCanbus.DATA[1000] == 393256) {
            int i = (value & 65280) >> 8;
            int switchOn2 = value & 255;
            setViewVisible(findViewById(R.id.layout_17_parking_brake), true);
            ((CheckedTextView) findViewById(R.id.ctv_17_parking_brake)).setChecked(switchOn2 != 0);
            return;
        }
        if (ConstGolf.isRZCGolf()) {
            int switchOn3 = DataCanbus.DATA[336] & 255;
            setViewVisible(findViewById(R.id.layout_17_parking_brake), true);
            ((CheckedTextView) findViewById(R.id.ctv_17_parking_brake)).setChecked(switchOn3 != 0);
            return;
        }
        setViewVisible(findViewById(R.id.layout_17_parking_brake), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterFrontVolumn() {
        int value = DataCanbus.DATA[20];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int mValue = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_parking_and_manoeurvring_front_volumn), enable != 0);
            ((TextView) findViewById(R.id.glf7_tv_functional_parking_and_manoeurvring_front_volumn)).setText(new StringBuilder().append(mValue).toString());
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_parking_and_manoeurvring_front_volumn), true);
        ((TextView) findViewById(R.id.glf7_tv_functional_parking_and_manoeurvring_front_volumn)).setText(new StringBuilder().append(value + 1).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterFrontTone() {
        int value = DataCanbus.DATA[21];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int mValue = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_parking_and_manoeurvring_front_tone_setting), enable != 0);
            ((TextView) findViewById(R.id.glf7_tv_functional_parking_and_manoeurvring_front_tone_setting)).setText(new StringBuilder().append(mValue).toString());
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_parking_and_manoeurvring_front_tone_setting), true);
        ((TextView) findViewById(R.id.glf7_tv_functional_parking_and_manoeurvring_front_tone_setting)).setText(new StringBuilder().append(value + 1).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRearVol() {
        int value = DataCanbus.DATA[22];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int mValue = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_parking_and_manoeurvring_Rear_volumn), enable != 0);
            ((TextView) findViewById(R.id.glf7_tv_functional_parking_and_manoeurvring_Rear_volumn)).setText(new StringBuilder().append(mValue).toString());
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_parking_and_manoeurvring_Rear_volumn), true);
        ((TextView) findViewById(R.id.glf7_tv_functional_parking_and_manoeurvring_Rear_volumn)).setText(new StringBuilder().append(value + 1).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRearTone() {
        int value = DataCanbus.DATA[23];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int mValue = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_parking_and_manoeurvring_Rear_tone_setting), enable != 0);
            ((TextView) findViewById(R.id.glf7_tv_functional_parking_and_manoeurvring_Rear_tone_setting)).setText(new StringBuilder().append(mValue).toString());
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_parking_and_manoeurvring_Rear_tone_setting), true);
        ((TextView) findViewById(R.id.glf7_tv_functional_parking_and_manoeurvring_Rear_tone_setting)).setText(new StringBuilder().append(value + 1).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterParkMode() {
        int value = DataCanbus.DATA[24];
        int enable = (65280 & value) >> 8;
        int mValue = value & 255;
        if (ConstGolf.isWcGolf()) {
            setViewVisible(findViewById(R.id.glf7_view_functional_parking_and_manoeurvring_parking_mode), enable != 0);
            if (mValue == 1) {
                ((TextView) findViewById(R.id.glf7_tv_functional_parking_and_manoeurvring_parking_mode)).setText(R.string.storage_parking);
                return;
            } else if (mValue == 2) {
                ((TextView) findViewById(R.id.glf7_tv_functional_parking_and_manoeurvring_parking_mode)).setText(R.string.side_parking);
                return;
            } else {
                ((TextView) findViewById(R.id.glf7_tv_functional_parking_and_manoeurvring_parking_mode)).setText("");
                return;
            }
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_parking_and_manoeurvring_parking_mode), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRadarVol() {
        int value = DataCanbus.DATA[25];
        int enable = (65280 & value) >> 8;
        int mValue = value & 255;
        if (ConstGolf.isWcGolf()) {
            setViewVisible(findViewById(R.id.glf7_view_functional_parking_and_manoeurvring_radar_volumn), enable != 0);
            ((CheckedTextView) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_radar_volumn)).setChecked(mValue != 0);
        } else {
            setViewVisible(findViewById(R.id.glf7_view_functional_parking_and_manoeurvring_radar_volumn), true);
            ((CheckedTextView) findViewById(R.id.glf7_btn_functional_parking_and_manoeurvring_radar_volumn)).setChecked(mValue != 0);
        }
    }
}
