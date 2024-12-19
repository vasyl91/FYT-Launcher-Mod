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
public class Golf7_XP_FunctionalDriverAssistanceActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalDriverAssistanceActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode] & 255;
            switch (updateCode) {
                case 29:
                    Golf7_XP_FunctionalDriverAssistanceActi.this.mUpdaterDriverSystem();
                    break;
                case 30:
                    Golf7_XP_FunctionalDriverAssistanceActi.this.mUpdaterLastDistance();
                    break;
                case 31:
                    Golf7_XP_FunctionalDriverAssistanceActi.this.mUpdaterDistance();
                    break;
                case 32:
                    Golf7_XP_FunctionalDriverAssistanceActi.this.mUpdaterFrontAssist();
                    break;
                case 33:
                    Golf7_XP_FunctionalDriverAssistanceActi.this.mUpdaterAdvanceWarning();
                    break;
                case 34:
                    Golf7_XP_FunctionalDriverAssistanceActi.this.mUpdaterDisplayDistanceWarning();
                    break;
                case 35:
                    Golf7_XP_FunctionalDriverAssistanceActi.this.mUpdaterDisplayLaneAssist();
                    break;
                case 37:
                    Golf7_XP_FunctionalDriverAssistanceActi.this.mUpdaterDriverAlertSystem();
                    break;
                case 152:
                    Golf7_XP_FunctionalDriverAssistanceActi.this.mUpdaterDisplayLaneAssist_JH();
                    break;
                case 176:
                    Golf7_XP_FunctionalDriverAssistanceActi.this.setCheck((CheckedTextView) Golf7_XP_FunctionalDriverAssistanceActi.this.findViewById(R.id.ctv_checkedtext1), value != 0);
                    break;
                case 179:
                    ((TextView) Golf7_XP_FunctionalDriverAssistanceActi.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value + 1).toString());
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_golf7_functional_state_driver_assistance_xp);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_front_assist), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalDriverAssistanceActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[32] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 51;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_advance_warning), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalDriverAssistanceActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[33] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 52;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_display_distance_warning), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalDriverAssistanceActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[34] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 53;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_display_lane_Assist), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalDriverAssistanceActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[35] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 48;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_display_lane_Assist_JH), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalDriverAssistanceActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[152] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 54;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_driver_alert_system), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalDriverAssistanceActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[37] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 49;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_driver_assistance_driver_system_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalDriverAssistanceActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[29] & 255;
                if (mValue > 1) {
                    mValue--;
                }
                DataCanbus.PROXY.cmd(107, new int[]{55, mValue}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_driver_assistance_driver_system_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalDriverAssistanceActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[29] & 255;
                if (mValue < 3) {
                    mValue++;
                }
                DataCanbus.PROXY.cmd(107, new int[]{55, mValue}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalDriverAssistanceActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[176] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 57;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_last_distance_selected), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalDriverAssistanceActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[30] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 50;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_driver_assistance_distance_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalDriverAssistanceActi.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = (DataCanbus.DATA[31] & 255) - 1;
                if (mValue < 0) {
                    mValue = 4;
                }
                DataCanbus.PROXY.cmd(107, new int[]{56, mValue}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_driver_assistance_distance_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalDriverAssistanceActi.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = (DataCanbus.DATA[31] & 255) + 1;
                if (mValue > 4) {
                    mValue = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{56, mValue}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus1), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalDriverAssistanceActi.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = (DataCanbus.DATA[179] & 255) - 1;
                if (mValue < 0) {
                    mValue = 4;
                }
                DataCanbus.PROXY.cmd(107, new int[]{59, mValue}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus1), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalDriverAssistanceActi.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = (DataCanbus.DATA[179] & 255) + 1;
                if (mValue > 4) {
                    mValue = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{59, mValue}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterFrontAssist() {
        int switchOn = DataCanbus.DATA[32] & 255;
        setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_advance_warning), switchOn != 0);
        setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_display_distance_warning), switchOn != 0);
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_front_assist), switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAdvanceWarning() {
        int switchOn = DataCanbus.DATA[33] & 255;
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_advance_warning), switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDisplayDistanceWarning() {
        int switchOn = DataCanbus.DATA[34] & 255;
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_display_distance_warning), switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDisplayLaneAssist() {
        int switchOn = DataCanbus.DATA[35] & 255;
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_display_lane_Assist), switchOn != 0);
        setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_display_lane_Assist_JH), switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDisplayLaneAssist_JH() {
        int switchOn = DataCanbus.DATA[152] & 255;
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_display_lane_Assist_JH), switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDriverAlertSystem() {
        int switchOn = DataCanbus.DATA[37] & 255;
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_driver_alert_system), switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDriverSystem() {
        int switchOn = DataCanbus.DATA[29] & 255;
        if (switchOn == 3) {
            ((TextView) findViewById(R.id.glf7_tv_functional_driver_assistance_driver_system)).setText(R.string.driver_system_economics);
        } else if (switchOn == 2) {
            ((TextView) findViewById(R.id.glf7_tv_functional_driver_assistance_driver_system)).setText(R.string.driver_system_sports);
        } else {
            ((TextView) findViewById(R.id.glf7_tv_functional_driver_assistance_driver_system)).setText(R.string.driver_system_standard);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLastDistance() {
        int value = DataCanbus.DATA[30] & 255;
        setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_distance), value == 0);
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_last_distance_selected), value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDistance() {
        int mValue = DataCanbus.DATA[31] & 255;
        if (mValue == 0) {
            ((TextView) findViewById(R.id.glf7_tv_functional_driver_assistance_distance)).setText(R.string.distance_very_close);
            return;
        }
        if (mValue == 1) {
            ((TextView) findViewById(R.id.glf7_tv_functional_driver_assistance_distance)).setText(R.string.distance_close);
            return;
        }
        if (mValue == 2) {
            ((TextView) findViewById(R.id.glf7_tv_functional_driver_assistance_distance)).setText(R.string.distance_medium);
        } else if (mValue == 3) {
            ((TextView) findViewById(R.id.glf7_tv_functional_driver_assistance_distance)).setText(R.string.distance_far);
        } else if (mValue == 4) {
            ((TextView) findViewById(R.id.glf7_tv_functional_driver_assistance_distance)).setText(R.string.distance_very_far);
        }
    }
}
