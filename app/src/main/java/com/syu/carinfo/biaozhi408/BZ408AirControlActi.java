package com.syu.carinfo.biaozhi408;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class BZ408AirControlActi extends BaseActivity {
    public static BZ408AirControlActi mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.biaozhi408.BZ408AirControlActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 70:
                    BZ408AirControlActi.this.mUpdaterAirAutoOn();
                    break;
                case 75:
                    BZ408AirControlActi.this.mUpdaterAirTempLeft();
                    break;
                case 76:
                    BZ408AirControlActi.this.mUpdaterBlowBodyLeftOn();
                    break;
                case 77:
                    BZ408AirControlActi.this.mUpdaterBlowFootLeftOn();
                    break;
                case 78:
                    BZ408AirControlActi.this.mUpdaterBlowUpLeftOn();
                    break;
                case 79:
                    BZ408AirControlActi.this.mUpdaterAirWindLevelLeft();
                    BZ408AirControlActi.this.mUpdatePowerOn();
                    break;
                case 80:
                    BZ408AirControlActi.this.mUpdaterAirDual();
                    break;
                case 81:
                    BZ408AirControlActi.this.mUpdaterAirTempRight();
                    break;
                case 83:
                    BZ408AirControlActi.this.mUpdaterAirWindStrong();
                    break;
                case 87:
                    BZ408AirControlActi.this.mUpdaterAirAcMax();
                    break;
                case 88:
                    BZ408AirControlActi.this.mUpdaterAirMono();
                    break;
                case 89:
                    BZ408AirControlActi.this.mUpdaterAirHybirdAc();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wc_xp_biaozhi_408_air_control);
        AirHelper.disableAirWindowLocal(true);
        mInstance = this;
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        findViewById(R.id.btn_air_temp_left_minus).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.BZ408AirControlActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(266, new int[]{1}, null, null);
            }
        });
        findViewById(R.id.btn_air_temp_left_plus).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.BZ408AirControlActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(266, new int[1], null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_mode_win)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.BZ408AirControlActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[78];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(262, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_mode_body)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.BZ408AirControlActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[76];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(263, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_mode_foot)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.BZ408AirControlActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[77];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(264, iArr, null, null);
            }
        });
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.BZ408AirControlActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(265, new int[]{1}, null, null);
            }
        });
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.BZ408AirControlActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(265, new int[1], null, null);
            }
        });
        findViewById(R.id.btn_air_temp_right_minus).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.BZ408AirControlActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(267, new int[]{1}, null, null);
            }
        });
        findViewById(R.id.btn_air_temp_right_plus).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.BZ408AirControlActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(267, new int[1], null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_auto)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.BZ408AirControlActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[70];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(258, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_ac)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.BZ408AirControlActi.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[89];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(256, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_maxac)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.BZ408AirControlActi.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[87];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(257, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_mono)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.BZ408AirControlActi.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[1000] == 118 || DataCanbus.DATA[1000] == 185 || DataCanbus.DATA[1000] == 65817 || DataCanbus.DATA[1000] == 281) {
                    int value = DataCanbus.DATA[80];
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[1];
                    iArr[0] = value != 0 ? 0 : 1;
                    remoteModuleProxy.cmd(29, iArr, null, null);
                    return;
                }
                int value2 = DataCanbus.DATA[88];
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[1];
                iArr2[0] = value2 != 0 ? 0 : 1;
                remoteModuleProxy2.cmd(269, iArr2, null, null);
            }
        });
        ((Button) findViewById(R.id.air_xts_winlev)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.biaozhi408.BZ408AirControlActi.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[83];
                if (value == 2) {
                    DataCanbus.PROXY.cmd(268, new int[1], null, null);
                } else if (value == 1) {
                    DataCanbus.PROXY.cmd(268, new int[]{2}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(268, new int[]{1}, null, null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirTempLeft() {
        int unit = DataCanbus.DATA[84];
        int temp = DataCanbus.DATA[75];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("NO");
                return;
            }
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                return;
            }
            if (DataCanbus.DATA[1000] == 118 || DataCanbus.DATA[1000] == 185 || DataCanbus.DATA[1000] == 65817 || DataCanbus.DATA[1000] == 281) {
                if (unit != 0) {
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 5) + "°F");
                    return;
                } else {
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText(((temp - 20) / 10.0f) + "°C");
                    return;
                }
            }
            ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 10.0f) + "°C");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdatePowerOn() {
        int power = DataCanbus.DATA[79];
        findViewById(R.id.air_xts_power).setBackgroundResource(power != 0 ? R.drawable.ic_xts_power_p : R.drawable.ic_xts_power_n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevelLeft() {
        int level = DataCanbus.DATA[79];
        if (((TextView) findViewById(R.id.dj_xts_air_winlevel)) != null) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(level).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBlowUpLeftOn() {
        int value = DataCanbus.DATA[78];
        if (((Button) findViewById(R.id.air_xts_mode_win)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_win)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_win_n : R.drawable.ic_xts_mode_win_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBlowBodyLeftOn() {
        int value = DataCanbus.DATA[76];
        if (((Button) findViewById(R.id.air_xts_mode_body)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_body)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_body_n : R.drawable.ic_xts_mode_body_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBlowFootLeftOn() {
        int value = DataCanbus.DATA[77];
        if (((Button) findViewById(R.id.air_xts_mode_foot)) != null) {
            ((Button) findViewById(R.id.air_xts_mode_foot)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mode_foot_n : R.drawable.ic_xts_mode_foot_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirTempRight() {
        int unit = DataCanbus.DATA[84];
        int temp = DataCanbus.DATA[81];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            if (temp == -1) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("NO");
                return;
            }
            if (temp == -2) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                return;
            }
            if (temp == -3) {
                ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
                return;
            }
            if (DataCanbus.DATA[1000] == 118 || DataCanbus.DATA[1000] == 185 || DataCanbus.DATA[1000] == 65817 || DataCanbus.DATA[1000] == 281) {
                if (unit != 0) {
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp / 5) + "°F");
                    return;
                } else {
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText(((temp - 20) / 10.0f) + "°C");
                    return;
                }
            }
            ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp / 10.0f) + "°C");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirAutoOn() {
        int value = DataCanbus.DATA[70];
        if (((Button) findViewById(R.id.air_xts_auto)) != null) {
            ((Button) findViewById(R.id.air_xts_auto)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirHybirdAc() {
        int value = DataCanbus.DATA[89];
        if (((Button) findViewById(R.id.air_xts_ac)) != null) {
            ((Button) findViewById(R.id.air_xts_ac)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_ac_n : R.drawable.ic_xts_ac_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirAcMax() {
        int value = DataCanbus.DATA[87];
        if (((Button) findViewById(R.id.air_xts_maxac)) != null) {
            ((Button) findViewById(R.id.air_xts_maxac)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_maxac_n : R.drawable.ic_xts_maxac_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirDual() {
        int value = DataCanbus.DATA[80];
        if (((Button) findViewById(R.id.air_xts_mono)) != null) {
            if (DataCanbus.DATA[1000] == 122 || DataCanbus.DATA[1000] == 185 || DataCanbus.DATA[1000] == 65817 || DataCanbus.DATA[1000] == 281) {
                ((Button) findViewById(R.id.air_xts_mono)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mono_n : R.drawable.ic_xts_mono_p);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirMono() {
        int value = DataCanbus.DATA[88];
        if (((Button) findViewById(R.id.air_xts_mono)) != null && DataCanbus.DATA[1000] != 118 && DataCanbus.DATA[1000] != 185 && DataCanbus.DATA[1000] != 65817 && DataCanbus.DATA[1000] != 281) {
            ((Button) findViewById(R.id.air_xts_mono)).setBackgroundResource(value == 0 ? R.drawable.ic_xts_mono_n : R.drawable.ic_xts_mono_p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindStrong() {
        int temp = DataCanbus.DATA[83];
        if (((Button) findViewById(R.id.air_xts_winlev)) != null) {
            if (temp == 1) {
                ((Button) findViewById(R.id.air_xts_winlev)).setBackgroundResource(R.drawable.ic_xts_winlev2);
            } else if (temp == 2) {
                ((Button) findViewById(R.id.air_xts_winlev)).setBackgroundResource(R.drawable.ic_xts_winlev3);
            } else {
                ((Button) findViewById(R.id.air_xts_winlev)).setBackgroundResource(R.drawable.ic_xts_winlev1);
            }
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[75].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[79].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
        if (DataCanbus.DATA[1000] == 122) {
            DataCanbus.NOTIFY_EVENTS[75].addNotify(this.mNotifyCanbus, 1);
        } else {
            DataCanbus.NOTIFY_EVENTS[81].addNotify(this.mNotifyCanbus, 1);
        }
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[80].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[83].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[75].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[79].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[78].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
        if (DataCanbus.DATA[1000] == 122) {
            DataCanbus.NOTIFY_EVENTS[75].removeNotify(this.mNotifyCanbus);
        } else {
            DataCanbus.NOTIFY_EVENTS[81].removeNotify(this.mNotifyCanbus);
        }
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[83].removeNotify(this.mNotifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        mIsFront = true;
        AirHelper.disableAirWindowLocal(true);
        if (DataCanbus.DATA[1000] == 118 || DataCanbus.DATA[1000] == 185 || DataCanbus.DATA[1000] == 281 || DataCanbus.DATA[1000] == 65817) {
            DataCanbus.PROXY.cmd(53, new int[]{33}, null, null);
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
        AirHelper.disableAirWindowLocal(false);
    }
}
