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
public class Golf7FunctionalOpeningAndClosingActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.Golf7FunctionalOpeningAndClosingActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 39:
                    Golf7FunctionalOpeningAndClosingActi.this.mUpdaterConvenience();
                    break;
                case 40:
                    Golf7FunctionalOpeningAndClosingActi.this.mUpdaterDoorUnlock();
                    break;
                case 41:
                    Golf7FunctionalOpeningAndClosingActi.this.mUpdaterAutoLock();
                    break;
                case 145:
                    Golf7FunctionalOpeningAndClosingActi.this.mUpdaterRemindpair();
                    break;
                case 146:
                    Golf7FunctionalOpeningAndClosingActi.this.mUpdaterSenselan();
                    break;
                case 163:
                    Golf7FunctionalOpeningAndClosingActi.this.updateCarKeyActivated();
                    break;
                case 268:
                    Golf7FunctionalOpeningAndClosingActi.this.mUpdaterDoorVoice();
                    break;
                case 340:
                    Golf7FunctionalOpeningAndClosingActi.this.setCheck((CheckedTextView) Golf7FunctionalOpeningAndClosingActi.this.findViewById(R.id.ctv_checkedtext1), value != 0);
                    break;
                case 341:
                    Golf7FunctionalOpeningAndClosingActi.this.setCheck((CheckedTextView) Golf7FunctionalOpeningAndClosingActi.this.findViewById(R.id.ctv_checkedtext2), value != 0);
                    break;
                case 342:
                    Golf7FunctionalOpeningAndClosingActi.this.setCheck((CheckedTextView) Golf7FunctionalOpeningAndClosingActi.this.findViewById(R.id.ctv_checkedtext3), value != 0);
                    break;
                case 368:
                    Golf7FunctionalOpeningAndClosingActi.this.setCheck((CheckedTextView) Golf7FunctionalOpeningAndClosingActi.this.findViewById(R.id.ctv_checkedtext4), value != 0);
                    break;
                case 369:
                    Golf7FunctionalOpeningAndClosingActi.this.setCheck((CheckedTextView) Golf7FunctionalOpeningAndClosingActi.this.findViewById(R.id.ctv_checkedtext5), value != 0);
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
            setContentView(R.layout.layout_golf7_functional_state_opening_and_closing_od);
        } else {
            setContentView(R.layout.layout_golf7_functional_state_opening_and_closing);
        }
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            setSelfClick((Button) findViewById(R.id.glf7_btn_car_back_od), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalOpeningAndClosingActi.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(Golf7FunctionalOpeningAndClosingActi.this, Golf7FunctionalActiOD.class);
                        Golf7FunctionalOpeningAndClosingActi.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_opening_and_closing_automatic_locking), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalOpeningAndClosingActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[41] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(74, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_opening_and_closing_remindpair), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalOpeningAndClosingActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[145] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 4;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(106, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_opening_and_closing_car_key_isactivated), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalOpeningAndClosingActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[163] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 3;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(106, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_opening_and_closing_senselan), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalOpeningAndClosingActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[146] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 5;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(106, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_opening_and_closing_voice), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalOpeningAndClosingActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[268] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 6;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(106, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_opening_and_closing_door_unlocking_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalOpeningAndClosingActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[40] & 255;
                if (switchOn == 0) {
                    DataCanbus.PROXY.cmd(73, new int[]{2}, null, null);
                } else if (switchOn == 1) {
                    DataCanbus.PROXY.cmd(73, new int[1], null, null);
                } else if (switchOn == 2) {
                    DataCanbus.PROXY.cmd(73, new int[]{1}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_opening_and_closing_door_unlocking_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalOpeningAndClosingActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[40] & 255;
                if (switchOn == 0) {
                    DataCanbus.PROXY.cmd(73, new int[]{1}, null, null);
                } else if (switchOn == 1) {
                    DataCanbus.PROXY.cmd(73, new int[]{2}, null, null);
                } else if (switchOn == 2) {
                    DataCanbus.PROXY.cmd(73, new int[1], null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_opening_and_closing_convenience_opening_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalOpeningAndClosingActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[39] & 255;
                if (switchOn == 0) {
                    DataCanbus.PROXY.cmd(72, new int[]{2}, null, null);
                } else if (switchOn == 1) {
                    DataCanbus.PROXY.cmd(72, new int[1], null, null);
                } else if (switchOn == 2) {
                    DataCanbus.PROXY.cmd(72, new int[]{1}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_opening_and_closing_convenience_opening_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalOpeningAndClosingActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[39] & 255;
                if (switchOn == 0) {
                    DataCanbus.PROXY.cmd(72, new int[]{1}, null, null);
                } else if (switchOn == 1) {
                    DataCanbus.PROXY.cmd(72, new int[]{2}, null, null);
                } else if (switchOn == 2) {
                    DataCanbus.PROXY.cmd(72, new int[1], null, null);
                }
            }
        });
        if (ConstGolf.isRZCGolf()) {
            setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalOpeningAndClosingActi.12
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value = DataCanbus.DATA[340] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 102;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(160, iArr, null, null);
                }
            });
            findViewById(R.id.layout_view1).setVisibility(0);
            findViewById(R.id.layout_view2).setVisibility(0);
            findViewById(R.id.layout_view3).setVisibility(0);
            findViewById(R.id.layout_view4).setVisibility(0);
            findViewById(R.id.layout_view5).setVisibility(0);
            setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalOpeningAndClosingActi.13
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value = DataCanbus.DATA[341] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 103;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(160, iArr, null, null);
                }
            });
            setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalOpeningAndClosingActi.14
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value = DataCanbus.DATA[342] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 104;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(160, iArr, null, null);
                }
            });
            setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalOpeningAndClosingActi.15
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value = DataCanbus.DATA[368] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 115;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(160, iArr, null, null);
                }
            });
            setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalOpeningAndClosingActi.16
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value = DataCanbus.DATA[369] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 117;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(160, iArr, null, null);
                }
            });
            return;
        }
        if (DataCanbus.DATA[1000] != 393233 && DataCanbus.DATA[1000] != 458769) {
            findViewById(R.id.layout_view1).setVisibility(8);
            findViewById(R.id.layout_view2).setVisibility(8);
            findViewById(R.id.layout_view3).setVisibility(8);
            findViewById(R.id.layout_view4).setVisibility(8);
            findViewById(R.id.layout_view5).setVisibility(8);
        }
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
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[268].addNotify(this.mNotifyCanbus, 1);
        if (ConstGolf.isRZCGolf()) {
            DataCanbus.NOTIFY_EVENTS[340].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[341].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[342].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[368].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[369].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[268].removeNotify(this.mNotifyCanbus);
        if (ConstGolf.isRZCGolf()) {
            DataCanbus.NOTIFY_EVENTS[340].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[341].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[342].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[368].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[369].removeNotify(this.mNotifyCanbus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRemindpair() {
        int value = DataCanbus.DATA[145];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_opening_and_closing_remindpair), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_opening_and_closing_remindpair), switchOn != 0);
            return;
        }
        if (DataCanbus.DATA[1000] == 437) {
            setViewVisible(findViewById(R.id.glf7_view_functional_opening_and_closing_remindpair), true);
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_opening_and_closing_remindpair), value != 0);
        } else if (ConstGolf.isRZCGolf()) {
            setViewVisible(findViewById(R.id.glf7_view_functional_opening_and_closing_remindpair), true);
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_opening_and_closing_remindpair), value != 0);
        } else {
            setViewVisible(findViewById(R.id.glf7_view_functional_opening_and_closing_remindpair), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarKeyActivated() {
        int i = DataCanbus.DATA[163];
        setViewVisible(findViewById(R.id.glf7_view_functional_opening_and_closing_car_key_isactivated), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDoorVoice() {
        int value = DataCanbus.DATA[268];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_opening_and_closing_voice), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_opening_and_closing_voice), switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSenselan() {
        int value = DataCanbus.DATA[146];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_opening_and_closing_senselan), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_opening_and_closing_senselan), switchOn != 0);
            return;
        }
        if (ConstGolf.isRZCGolf() || DataCanbus.DATA[1000] == 437) {
            setViewVisible(findViewById(R.id.glf7_view_functional_opening_and_closing_senselan), true);
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_opening_and_closing_senselan), value != 0);
        } else {
            setViewVisible(findViewById(R.id.glf7_view_functional_opening_and_closing_senselan), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutoLock() {
        int value = DataCanbus.DATA[41];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_opening_and_closing_automatic_locking), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_opening_and_closing_automatic_locking), switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_opening_and_closing_automatic_locking), true);
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_opening_and_closing_automatic_locking), value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDoorUnlock() {
        int value = DataCanbus.DATA[40];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_opening_and_closing_door_unlocking), enable != 0);
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.glf7_tv_functional_opening_and_closing_door_unlocking)).setText(R.string.door_unlocking_all_doors);
            } else if (switchOn == 1) {
                ((TextView) findViewById(R.id.glf7_tv_functional_opening_and_closing_door_unlocking)).setText(R.string.door_unlocking_single_door);
            }
            if (switchOn == 2) {
                ((TextView) findViewById(R.id.glf7_tv_functional_opening_and_closing_door_unlocking)).setText(R.string.door_unlocking_vehicle_side);
                return;
            }
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_opening_and_closing_door_unlocking), true);
        if (value == 0) {
            ((TextView) findViewById(R.id.glf7_tv_functional_opening_and_closing_door_unlocking)).setText(R.string.door_unlocking_vehicle_side);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.glf7_tv_functional_opening_and_closing_door_unlocking)).setText(R.string.door_unlocking_single_door);
        }
        if (value == 2) {
            ((TextView) findViewById(R.id.glf7_tv_functional_opening_and_closing_door_unlocking)).setText(R.string.door_unlocking_all_doors);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterConvenience() {
        int value = DataCanbus.DATA[39];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_opening_and_closing_convenience_opening), enable != 0);
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.glf7_tv_functional_opening_and_closing_convenience_opening)).setText(R.string.convenience_opening_all_window);
            } else if (switchOn == 1) {
                ((TextView) findViewById(R.id.glf7_tv_functional_opening_and_closing_convenience_opening)).setText(R.string.convenience_opening_driver_window);
            }
            if (switchOn == 2) {
                ((TextView) findViewById(R.id.glf7_tv_functional_opening_and_closing_convenience_opening)).setText(R.string.convenience_opening_off);
                return;
            }
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_opening_and_closing_convenience_opening), true);
        if (value == 0) {
            ((TextView) findViewById(R.id.glf7_tv_functional_opening_and_closing_convenience_opening)).setText(R.string.convenience_opening_off);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.glf7_tv_functional_opening_and_closing_convenience_opening)).setText(R.string.convenience_opening_driver_window);
        }
        if (value == 2) {
            ((TextView) findViewById(R.id.glf7_tv_functional_opening_and_closing_convenience_opening)).setText(R.string.convenience_opening_all_window);
        }
    }
}
