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

@SuppressWarnings({"deprecation", "unchecked"})
public class Golf7_XP_FunctionalOpeningAndClosingActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 136:
                    Golf7_XP_FunctionalOpeningAndClosingActi.this.mUpdaterConvenience();
                    break;
                case 137:
                    Golf7_XP_FunctionalOpeningAndClosingActi.this.mUpdaterDoorUnlock();
                    break;
                case 138:
                    Golf7_XP_FunctionalOpeningAndClosingActi.this.mUpdaterAutoLock();
                    break;
                case 198:
                    Golf7_XP_FunctionalOpeningAndClosingActi.this.mUpdaterRemindpair();
                    break;
                case 199:
                    Golf7_XP_FunctionalOpeningAndClosingActi.this.mUpdaterSenselan();
                    break;
                case 224:
                    Golf7_XP_FunctionalOpeningAndClosingActi.this.setCheck((CheckedTextView) Golf7_XP_FunctionalOpeningAndClosingActi.this.findViewById(R.id.ctv_checkedtext1), value != 0);
                    break;
                case 232:
                    Golf7_XP_FunctionalOpeningAndClosingActi.this.setCheck((CheckedTextView) Golf7_XP_FunctionalOpeningAndClosingActi.this.findViewById(R.id.ctv_checkedtext2), value != 0);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_golf7_functional_state_opening_and_closing_xp);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_opening_and_closing_automatic_locking), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[138] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 114;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_opening_and_closing_remindpair), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[198] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 202;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_opening_and_closing_senselan), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[199] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 115;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[224] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 201;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[232] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 116;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_opening_and_closing_door_unlocking_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[137] & 255) - 1;
                if (switchOn == 0) {
                    switchOn = 2;
                }
                DataCanbus.PROXY.cmd(107, new int[]{113, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_opening_and_closing_door_unlocking_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[137] & 255) + 1;
                if (switchOn > 2) {
                    switchOn = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{113, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_opening_and_closing_convenience_opening_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[136] & 255) - 1;
                if (switchOn == 0) {
                    switchOn = 2;
                }
                DataCanbus.PROXY.cmd(107, new int[]{112, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_opening_and_closing_convenience_opening_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[136] & 255) + 1;
                if (switchOn > 2) {
                    switchOn = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{112, switchOn}, null, null);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[199].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[224].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[232].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[199].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[224].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[232].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterRemindpair() {
        int value = DataCanbus.DATA[198];
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_opening_and_closing_remindpair), value != 0);
    }

    
    public void mUpdaterSenselan() {
        int value = DataCanbus.DATA[199];
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_opening_and_closing_senselan), value != 0);
    }

    
    public void mUpdaterAutoLock() {
        int value = DataCanbus.DATA[138];
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_opening_and_closing_automatic_locking), value != 0);
    }

    
    public void mUpdaterDoorUnlock() {
        int value = DataCanbus.DATA[137];
        if (value == 0) {
            ((TextView) findViewById(R.id.glf7_tv_functional_opening_and_closing_door_unlocking)).setText(R.string.door_unlocking_vehicle_side);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.glf7_tv_functional_opening_and_closing_door_unlocking)).setText(R.string.door_unlocking_single_door);
        } else if (value == 2) {
            ((TextView) findViewById(R.id.glf7_tv_functional_opening_and_closing_door_unlocking)).setText(R.string.door_unlocking_all_doors);
        }
    }

    
    public void mUpdaterConvenience() {
        int value = DataCanbus.DATA[136];
        if (value == 0) {
            ((TextView) findViewById(R.id.glf7_tv_functional_opening_and_closing_convenience_opening)).setText(R.string.convenience_opening_off);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.glf7_tv_functional_opening_and_closing_convenience_opening)).setText(R.string.convenience_opening_driver_window);
        } else if (value == 2) {
            ((TextView) findViewById(R.id.glf7_tv_functional_opening_and_closing_convenience_opening)).setText(R.string.convenience_opening_all_window);
        }
    }
}
