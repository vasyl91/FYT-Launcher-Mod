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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class Golf7FunctionalParkingAndManoeurvrinActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 116:
                    Golf7FunctionalParkingAndManoeurvrinActi.this.mUpdaterActivateAutomaticlly();
                    break;
                case 117:
                    Golf7FunctionalParkingAndManoeurvrinActi.this.mUpdaterFrontVolumn();
                    break;
                case 118:
                    Golf7FunctionalParkingAndManoeurvrinActi.this.mUpdaterFrontTone();
                    break;
                case 119:
                    Golf7FunctionalParkingAndManoeurvrinActi.this.mUpdaterRearVol();
                    break;
                case 120:
                    Golf7FunctionalParkingAndManoeurvrinActi.this.mUpdaterRearTone();
                    break;
                case 121:
                    Golf7FunctionalParkingAndManoeurvrinActi.this.mUpdaterParkMode();
                    break;
                case 122:
                    Golf7FunctionalParkingAndManoeurvrinActi.this.mUpdaterRadarVol();
                    break;
                case 216:
                case 327:
                    Golf7FunctionalParkingAndManoeurvrinActi.this.updateActivateMaticlly();
                    break;
                case 244:
                case 329:
                    Golf7FunctionalParkingAndManoeurvrinActi.this.updateOutOfParkingAssist();
                    break;
                case 250:
                    Golf7FunctionalParkingAndManoeurvrinActi.this.updateOffRoadIcon();
                    break;
                case 276:
                case 328:
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[116] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(39, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[216] & 255;
                if (ConstGolf.isRZCGolf()) {
                    int switchOn2 = DataCanbus.DATA[327] & 255;
                    return;
                }
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(109, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus1), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[117] & 255;
                if (mValue > 0) {
                    DataCanbus.PROXY.cmd(40, new int[]{mValue - 1}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus1), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[117] & 255;
                if (mValue < 8) {
                    DataCanbus.PROXY.cmd(40, new int[]{mValue + 1}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus2), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[118] & 255;
                if (mValue > 0) {
                    DataCanbus.PROXY.cmd(41, new int[]{mValue - 1}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus2), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[118] & 255;
                if (mValue < 8) {
                    DataCanbus.PROXY.cmd(41, new int[]{mValue + 1}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus3), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[119] & 255;
                if (mValue > 0) {
                    DataCanbus.PROXY.cmd(42, new int[]{mValue - 1}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus3), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[119] & 255;
                if (mValue < 8) {
                    DataCanbus.PROXY.cmd(42, new int[]{mValue + 1}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus4), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[120] & 255;
                if (mValue > 0) {
                    DataCanbus.PROXY.cmd(43, new int[]{mValue - 1}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus4), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[120] & 255;
                if (mValue < 8) {
                    DataCanbus.PROXY.cmd(43, new int[]{mValue + 1}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus5), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[121] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = mValue == 1 ? 0 : 1;
                remoteModuleProxy.cmd(44, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus5), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[121] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = mValue == 1 ? 0 : 1;
                remoteModuleProxy.cmd(44, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[122] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = mValue != 0 ? 0 : 1;
                remoteModuleProxy.cmd(30, iArr, null, null);
            }
        });
        if ((DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) && findViewById(R.id.layout_view9) != null) {
            findViewById(R.id.layout_view9).setVisibility(8);
        }
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[244] & 255;
                if (ConstGolf.isRZCGolf()) {
                    int mValue2 = DataCanbus.DATA[329];
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[276] & 255;
                if (ConstGolf.isRZCGolf()) {
                    int mValue2 = DataCanbus.DATA[328];
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalParkingAndManoeurvrinActi.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[250] & 255;
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
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[216].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[244].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[250].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[276].addNotify(this.mNotifyCanbus, 1);
        if (ConstGolf.isRZCGolf()) {
            DataCanbus.NOTIFY_EVENTS[327].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[328].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[329].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[330].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[216].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[244].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[250].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[276].removeNotify(this.mNotifyCanbus);
        if (ConstGolf.isRZCGolf()) {
            DataCanbus.NOTIFY_EVENTS[327].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[328].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[329].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[330].removeNotify(this.mNotifyCanbus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterActivateAutomaticlly() {
        int value = DataCanbus.DATA[116];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.layout_view2), enable != 0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.layout_view2), true);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateActivateMaticlly() {
        int value = DataCanbus.DATA[116];
        if (ConstGolf.isRZCGolf()) {
            value = DataCanbus.DATA[327];
        }
        if (DataCanbus.DATA[1000] == 437 || ConstGolf.isRZCGolf()) {
            setViewVisible(findViewById(R.id.layout_view1), true);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
        } else {
            setViewVisible(findViewById(R.id.layout_view1), false);
        }
    }

    public void updateOutOfParkingAssist() {
        int value = DataCanbus.DATA[244];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            if (DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
                setViewVisible(findViewById(R.id.layout_view9), false);
            } else {
                setViewVisible(findViewById(R.id.layout_view9), enable != 0);
            }
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(switchOn != 0);
            return;
        }
        if (DataCanbus.DATA[1000] == 393256) {
            int i = (65280 & value) >> 8;
            int switchOn2 = value & 255;
            setViewVisible(findViewById(R.id.layout_view9), true);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(switchOn2 != 0);
            return;
        }
        if (ConstGolf.isRZCGolf()) {
            int switchOn3 = DataCanbus.DATA[329] & 255;
            setViewVisible(findViewById(R.id.layout_view9), true);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(switchOn3 != 0);
            return;
        }
        setViewVisible(findViewById(R.id.layout_view9), false);
    }

    public void updateOffRoadIcon() {
        int value = DataCanbus.DATA[250];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.layout_view10), enable != 0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.layout_view10), false);
    }

    public void updateParkingBrake() {
        int value = DataCanbus.DATA[276];
        if (ConstGolf.isWcGolf()) {
            int enable = (value & 65280) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.layout_view11), enable != 0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(switchOn != 0);
            return;
        }
        if (DataCanbus.DATA[1000] == 393256) {
            int i = (value & 65280) >> 8;
            int switchOn2 = value & 255;
            setViewVisible(findViewById(R.id.layout_view11), true);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(switchOn2 != 0);
            return;
        }
        if (ConstGolf.isRZCGolf()) {
            int switchOn3 = DataCanbus.DATA[328] & 255;
            setViewVisible(findViewById(R.id.layout_view11), true);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(switchOn3 != 0);
            return;
        }
        setViewVisible(findViewById(R.id.layout_view11), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterFrontVolumn() {
        int value = DataCanbus.DATA[117];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int mValue = value & 255;
            setViewVisible(findViewById(R.id.layout_view3), enable != 0);
            ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder().append(mValue).toString());
            return;
        }
        setViewVisible(findViewById(R.id.layout_view3), true);
        ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value + 1).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterFrontTone() {
        int value = DataCanbus.DATA[118];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int mValue = value & 255;
            setViewVisible(findViewById(R.id.layout_view4), enable != 0);
            ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(mValue).toString());
            return;
        }
        setViewVisible(findViewById(R.id.layout_view4), true);
        ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value + 1).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRearVol() {
        int value = DataCanbus.DATA[119];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int mValue = value & 255;
            setViewVisible(findViewById(R.id.layout_view5), enable != 0);
            ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder().append(mValue).toString());
            return;
        }
        setViewVisible(findViewById(R.id.layout_view5), true);
        ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value + 1).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRearTone() {
        int value = DataCanbus.DATA[120];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int mValue = value & 255;
            setViewVisible(findViewById(R.id.layout_view6), enable != 0);
            ((TextView) findViewById(R.id.tv_text4)).setText(new StringBuilder().append(mValue).toString());
            return;
        }
        setViewVisible(findViewById(R.id.layout_view6), true);
        ((TextView) findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value + 1).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterParkMode() {
        int value = DataCanbus.DATA[121];
        int enable = (65280 & value) >> 8;
        int mValue = value & 255;
        if (ConstGolf.isWcGolf()) {
            setViewVisible(findViewById(R.id.layout_view7), enable != 0);
            if (mValue == 1) {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.storage_parking);
                return;
            } else if (mValue == 2) {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.side_parking);
                return;
            } else {
                ((TextView) findViewById(R.id.tv_text5)).setText("");
                return;
            }
        }
        setViewVisible(findViewById(R.id.layout_view7), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRadarVol() {
        int value = DataCanbus.DATA[122];
        int enable = (65280 & value) >> 8;
        int mValue = value & 255;
        if (ConstGolf.isWcGolf()) {
            setViewVisible(findViewById(R.id.layout_view8), enable != 0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(mValue != 0);
        } else {
            setViewVisible(findViewById(R.id.layout_view8), true);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(mValue != 0);
        }
    }
}
