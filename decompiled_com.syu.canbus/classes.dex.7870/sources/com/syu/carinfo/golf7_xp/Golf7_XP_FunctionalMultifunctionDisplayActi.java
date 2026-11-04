package com.syu.carinfo.golf7_xp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class Golf7_XP_FunctionalMultifunctionDisplayActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalMultifunctionDisplayActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 153:
                    Golf7_XP_FunctionalMultifunctionDisplayActi.this.mUpdaterCurConsumption();
                    break;
                case 154:
                    Golf7_XP_FunctionalMultifunctionDisplayActi.this.mUpdaterAverageConsumption();
                    break;
                case 155:
                    Golf7_XP_FunctionalMultifunctionDisplayActi.this.mUpdaterConvenience();
                    break;
                case 156:
                    Golf7_XP_FunctionalMultifunctionDisplayActi.this.mUpdaterEcoTips();
                    break;
                case 157:
                    Golf7_XP_FunctionalMultifunctionDisplayActi.this.mUpdaterTravellingTime();
                    break;
                case 158:
                    Golf7_XP_FunctionalMultifunctionDisplayActi.this.mUpdaterDistanceTravelled();
                    break;
                case 159:
                    Golf7_XP_FunctionalMultifunctionDisplayActi.this.mUpdaterAverageSpeed();
                    break;
                case 160:
                    Golf7_XP_FunctionalMultifunctionDisplayActi.this.mUpdaterDigitalSpeed();
                    break;
                case 161:
                    Golf7_XP_FunctionalMultifunctionDisplayActi.this.mUpdaterSpeedWarning();
                    break;
                case 182:
                    Golf7_XP_FunctionalMultifunctionDisplayActi.this.mUpdaterOil();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_golf7_functional_state_multifunction_display);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalMultifunctionDisplayActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[153] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 128;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalMultifunctionDisplayActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[154] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 129;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalMultifunctionDisplayActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[155] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 130;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalMultifunctionDisplayActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[156] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 131;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalMultifunctionDisplayActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[157] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 132;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalMultifunctionDisplayActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[158] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 133;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalMultifunctionDisplayActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[159] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 134;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalMultifunctionDisplayActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[160] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 135;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalMultifunctionDisplayActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[161] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 136;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalMultifunctionDisplayActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[182] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 137;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalMultifunctionDisplayActi.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Golf7_XP_FunctionalMultifunctionDisplayActi.this.dialog(R.string.reset_long_term_drving_data, 138);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext12), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalMultifunctionDisplayActi.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Golf7_XP_FunctionalMultifunctionDisplayActi.this.dialog(R.string.reset_long_term_drving_data, 139);
            }
        });
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(stringId)) + "?");
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalMultifunctionDisplayActi.14
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalMultifunctionDisplayActi.14.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(107, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalMultifunctionDisplayActi.15
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
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
    protected void finalize() throws Throwable {
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCurConsumption() {
        int value = DataCanbus.DATA[153];
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext1), value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAverageConsumption() {
        int value = DataCanbus.DATA[154];
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext2), value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterConvenience() {
        int value = DataCanbus.DATA[155];
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext3), value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterEcoTips() {
        int value = DataCanbus.DATA[156];
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext4), value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTravellingTime() {
        int value = DataCanbus.DATA[157];
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext5), value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDistanceTravelled() {
        int value = DataCanbus.DATA[158];
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext6), value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAverageSpeed() {
        int value = DataCanbus.DATA[159];
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext7), value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDigitalSpeed() {
        int value = DataCanbus.DATA[160];
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext8), value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSpeedWarning() {
        int value = DataCanbus.DATA[161];
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext9), value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOil() {
        int switchOn = DataCanbus.DATA[182] & 255;
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext10), switchOn != 0);
    }
}
