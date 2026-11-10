package com.syu.carinfo.golf7;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class Golf7FunctionalMultifunctionDisplayActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.Golf7FunctionalMultifunctionDisplayActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 153:
                    Golf7FunctionalMultifunctionDisplayActi.this.mUpdaterCurConsumption();
                    break;
                case 154:
                    Golf7FunctionalMultifunctionDisplayActi.this.mUpdaterAverageConsumption();
                    break;
                case 155:
                    Golf7FunctionalMultifunctionDisplayActi.this.mUpdaterConvenience();
                    break;
                case 156:
                    Golf7FunctionalMultifunctionDisplayActi.this.mUpdaterEcoTips();
                    break;
                case 157:
                    Golf7FunctionalMultifunctionDisplayActi.this.mUpdaterTravellingTime();
                    break;
                case 158:
                    Golf7FunctionalMultifunctionDisplayActi.this.mUpdaterDistanceTravelled();
                    break;
                case 159:
                    Golf7FunctionalMultifunctionDisplayActi.this.mUpdaterAverageSpeed();
                    break;
                case 160:
                    Golf7FunctionalMultifunctionDisplayActi.this.mUpdaterDigitalSpeed();
                    break;
                case 161:
                    Golf7FunctionalMultifunctionDisplayActi.this.mUpdaterSpeedWarning();
                    break;
                case 182:
                    Golf7FunctionalMultifunctionDisplayActi.this.mUpdaterOil();
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
            setContentView(R.layout.layout_golf7_functional_state_multifunction_display_od);
        } else {
            setContentView(R.layout.layout_golf7_functional_state_multifunction_display);
        }
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            setSelfClick((Button) findViewById(R.id.btn_plus1), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalMultifunctionDisplayActi.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(Golf7FunctionalMultifunctionDisplayActi.this, Golf7FunctionalActiOD.class);
                        Golf7FunctionalMultifunctionDisplayActi.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalMultifunctionDisplayActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[153] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(75, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalMultifunctionDisplayActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[154] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(76, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalMultifunctionDisplayActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[155] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(77, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalMultifunctionDisplayActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[156] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(78, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalMultifunctionDisplayActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[157] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(79, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalMultifunctionDisplayActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[158] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(80, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalMultifunctionDisplayActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[159] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(81, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalMultifunctionDisplayActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[160] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(82, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalMultifunctionDisplayActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[161] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(83, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalMultifunctionDisplayActi.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[182] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(0, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalMultifunctionDisplayActi.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Golf7FunctionalMultifunctionDisplayActi.this.dialog(R.string.reset_long_term_drving_data, 84);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext12), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalMultifunctionDisplayActi.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Golf7FunctionalMultifunctionDisplayActi.this.dialog(R.string.reset_long_term_drving_data, 85);
            }
        });
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(stringId)) + "?");
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalMultifunctionDisplayActi.15
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.golf7.Golf7FunctionalMultifunctionDisplayActi.15.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(i, new int[]{1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalMultifunctionDisplayActi.16
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
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible((Button) findViewById(R.id.btn_plus1), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext1), switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.btn_plus1), true);
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext1), value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAverageConsumption() {
        int value = DataCanbus.DATA[154];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.layout_view2), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext2), switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.layout_view2), true);
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext2), value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterConvenience() {
        int value = DataCanbus.DATA[155];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.layout_view3), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext3), switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.layout_view3), true);
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext3), value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterEcoTips() {
        int value = DataCanbus.DATA[156];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.layout_view4), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext4), switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.layout_view4), true);
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext4), value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTravellingTime() {
        int value = DataCanbus.DATA[157];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.layout_view5), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext5), switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.layout_view5), true);
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext5), value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDistanceTravelled() {
        int value = DataCanbus.DATA[158];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.layout_view6), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext6), switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.layout_view6), true);
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext6), value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAverageSpeed() {
        int value = DataCanbus.DATA[159];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.layout_view7), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext7), switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.layout_view7), true);
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext7), value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDigitalSpeed() {
        int value = DataCanbus.DATA[160];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.layout_view8), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext8), switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.layout_view8), true);
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext8), value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSpeedWarning() {
        int value = DataCanbus.DATA[161];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.layout_view9), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext9), switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.layout_view9), true);
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext9), value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOil() {
        int value = DataCanbus.DATA[182];
        int enable = (65280 & value) >> 8;
        int switchOn = value & 255;
        if (ConstGolf.isWcGolf()) {
            setViewVisible(findViewById(R.id.layout_view10), enable != 0);
        } else {
            setViewVisible(findViewById(R.id.layout_view10), true);
        }
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext10), switchOn != 0);
    }
}
