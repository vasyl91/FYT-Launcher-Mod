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

@SuppressWarnings({"deprecation", "unchecked"})
public class Golf7FunctionalOpeningAndClosingActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 136:
                    Golf7FunctionalOpeningAndClosingActi.this.mUpdaterConvenience();
                    break;
                case 137:
                    Golf7FunctionalOpeningAndClosingActi.this.mUpdaterDoorUnlock();
                    break;
                case 138:
                    Golf7FunctionalOpeningAndClosingActi.this.mUpdaterAutoLock();
                    break;
                case 208:
                    Golf7FunctionalOpeningAndClosingActi.this.mUpdaterRemindpair();
                    break;
                case 209:
                    Golf7FunctionalOpeningAndClosingActi.this.mUpdaterSenselan();
                    break;
                case 217:
                    Golf7FunctionalOpeningAndClosingActi.this.updateCarKeyActivated();
                    break;
                case 297:
                    Golf7FunctionalOpeningAndClosingActi.this.mUpdaterDoorVoice();
                    break;
                case 332:
                    Golf7FunctionalOpeningAndClosingActi.this.setCheck((CheckedTextView) Golf7FunctionalOpeningAndClosingActi.this.findViewById(R.id.ctv_checkedtext1), value != 0);
                    break;
                case 333:
                    Golf7FunctionalOpeningAndClosingActi.this.setCheck((CheckedTextView) Golf7FunctionalOpeningAndClosingActi.this.findViewById(R.id.ctv_checkedtext2), value != 0);
                    break;
                case 334:
                    Golf7FunctionalOpeningAndClosingActi.this.setCheck((CheckedTextView) Golf7FunctionalOpeningAndClosingActi.this.findViewById(R.id.ctv_checkedtext3), value != 0);
                    break;
                case 360:
                    Golf7FunctionalOpeningAndClosingActi.this.setCheck((CheckedTextView) Golf7FunctionalOpeningAndClosingActi.this.findViewById(R.id.ctv_checkedtext4), value != 0);
                    break;
                case 361:
                    Golf7FunctionalOpeningAndClosingActi.this.setCheck((CheckedTextView) Golf7FunctionalOpeningAndClosingActi.this.findViewById(R.id.ctv_checkedtext5), value != 0);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            //setContentView(R.layout.layout_golf7_functional_state_opening_and_closing_od);
        } else {
            //setContentView(R.layout.layout_golf7_functional_state_opening_and_closing);
        }
        init();
    }

    @Override
    public void init() {
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            setSelfClick((Button) findViewById(R.id.glf7_btn_car_back_od), new View.OnClickListener() { 
                @Override
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
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_opening_and_closing_automatic_locking), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[138] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(74, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_opening_and_closing_remindpair), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[208] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 4;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(106, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_opening_and_closing_car_key_isactivated), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[217] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 3;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(106, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_opening_and_closing_senselan), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[209] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 5;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(106, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_opening_and_closing_voice), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[297] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 6;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(106, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_opening_and_closing_door_unlocking_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[137] & 255;
                if (switchOn == 0) {
                    DataCanbus.PROXY.cmd(73, new int[]{2}, null, null);
                } else if (switchOn == 1) {
                    DataCanbus.PROXY.cmd(73, new int[1], null, null);
                } else if (switchOn == 2) {
                    DataCanbus.PROXY.cmd(73, new int[]{1}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_opening_and_closing_door_unlocking_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[137] & 255;
                if (switchOn == 0) {
                    DataCanbus.PROXY.cmd(73, new int[]{1}, null, null);
                } else if (switchOn == 1) {
                    DataCanbus.PROXY.cmd(73, new int[]{2}, null, null);
                } else if (switchOn == 2) {
                    DataCanbus.PROXY.cmd(73, new int[1], null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_opening_and_closing_convenience_opening_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[136] & 255;
                if (switchOn == 0) {
                    DataCanbus.PROXY.cmd(72, new int[]{2}, null, null);
                } else if (switchOn == 1) {
                    DataCanbus.PROXY.cmd(72, new int[1], null, null);
                } else if (switchOn == 2) {
                    DataCanbus.PROXY.cmd(72, new int[]{1}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_opening_and_closing_convenience_opening_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[136] & 255;
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
            setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int value = DataCanbus.DATA[332] & 255;
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
            setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int value = DataCanbus.DATA[333] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 103;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(160, iArr, null, null);
                }
            });
            setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int value = DataCanbus.DATA[334] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 104;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(160, iArr, null, null);
                }
            });
            setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int value = DataCanbus.DATA[360] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 115;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(160, iArr, null, null);
                }
            });
            setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int value = DataCanbus.DATA[361] & 255;
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
        DataCanbus.NOTIFY_EVENTS[208].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[209].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[217].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[297].addNotify(this.mNotifyCanbus, 1);
        if (ConstGolf.isRZCGolf()) {
            DataCanbus.NOTIFY_EVENTS[332].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[333].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[334].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[360].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[361].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[208].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[209].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[217].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[297].removeNotify(this.mNotifyCanbus);
        if (ConstGolf.isRZCGolf()) {
            DataCanbus.NOTIFY_EVENTS[332].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[333].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[334].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[360].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[361].removeNotify(this.mNotifyCanbus);
        }
    }

    
    public void mUpdaterRemindpair() {
        int value = DataCanbus.DATA[208];
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

    
    public void updateCarKeyActivated() {
        int i = DataCanbus.DATA[217];
        setViewVisible(findViewById(R.id.glf7_view_functional_opening_and_closing_car_key_isactivated), false);
    }

    
    public void mUpdaterDoorVoice() {
        int value = DataCanbus.DATA[297];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_opening_and_closing_voice), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_opening_and_closing_voice), switchOn != 0);
        }
    }

    
    public void mUpdaterSenselan() {
        int value = DataCanbus.DATA[209];
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

    
    public void mUpdaterAutoLock() {
        int value = DataCanbus.DATA[138];
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

    
    public void mUpdaterDoorUnlock() {
        int value = DataCanbus.DATA[137];
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

    
    public void mUpdaterConvenience() {
        int value = DataCanbus.DATA[136];
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
