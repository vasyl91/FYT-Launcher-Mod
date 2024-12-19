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
public class Golf7_XP_FunctionalLightActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalLightActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 42:
                    Golf7_XP_FunctionalLightActi.this.mUpdaterSwitchOnTime();
                    break;
                case 43:
                    Golf7_XP_FunctionalLightActi.this.mUpdaterAutoRain();
                    break;
                case 44:
                    Golf7_XP_FunctionalLightActi.this.mUpdaterLaneChange();
                    break;
                case 45:
                    Golf7_XP_FunctionalLightActi.this.mUpdaterTravelMode();
                    break;
                case 46:
                    Golf7_XP_FunctionalLightActi.this.mUpdaterInstrument();
                    break;
                case 47:
                    Golf7_XP_FunctionalLightActi.this.mUpdaterDoorLight();
                    break;
                case 48:
                    Golf7_XP_FunctionalLightActi.this.mUpdaterFootLight();
                    break;
                case 49:
                    Golf7_XP_FunctionalLightActi.this.mUpdaterComeHome();
                    break;
                case 50:
                    Golf7_XP_FunctionalLightActi.this.mUpdaterLeaveHome();
                    break;
                case 78:
                    Golf7_XP_FunctionalLightActi.this.mUpdaterDayTimeRuningLights();
                    break;
                case 138:
                    Golf7_XP_FunctionalLightActi.this.mUpdaterlightcolor();
                    break;
                case 139:
                    Golf7_XP_FunctionalLightActi.this.mUpdaterlightfan();
                    break;
                case 140:
                    Golf7_XP_FunctionalLightActi.this.mUpdaterlightright();
                    break;
                case 141:
                    Golf7_XP_FunctionalLightActi.this.mUpdaterLightassist();
                    break;
                case 142:
                    Golf7_XP_FunctionalLightActi.this.mUpdaterLightbend();
                    break;
                case 143:
                    Golf7_XP_FunctionalLightActi.this.mUpdaterLightall();
                    break;
                case 177:
                    ((TextView) Golf7_XP_FunctionalLightActi.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_golf7_functional_state_light_xp);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_daytime_light), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalLightActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[78] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 200;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_automatic_headlight_control_rain), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalLightActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[43] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 81;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_dynamic), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalLightActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[141] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 90;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_follower), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalLightActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[142] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 89;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_color_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalLightActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn;
                int switchOn2 = DataCanbus.DATA[138] & 255;
                if (switchOn2 > 0) {
                    switchOn = switchOn2 - 1;
                } else {
                    switchOn = 3;
                }
                DataCanbus.PROXY.cmd(107, new int[]{94, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_color_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalLightActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn;
                int switchOn2 = DataCanbus.DATA[138] & 255;
                if (switchOn2 < 3) {
                    switchOn = switchOn2 + 1;
                } else {
                    switchOn = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{94, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_10color_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalLightActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[138] & 255;
                if (switchOn > 5) {
                    switchOn--;
                }
                DataCanbus.PROXY.cmd(107, new int[]{94, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_10color_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalLightActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[138] & 255;
                if (switchOn < 5) {
                    switchOn = 5;
                } else if (switchOn < 14) {
                    switchOn++;
                }
                DataCanbus.PROXY.cmd(107, new int[]{94, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus2), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalLightActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[138] & 255;
                if (switchOn > 15) {
                    switchOn--;
                }
                DataCanbus.PROXY.cmd(107, new int[]{94, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus2), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalLightActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[138] & 255;
                if (switchOn < 15) {
                    switchOn = 15;
                } else if (switchOn < 44) {
                    switchOn++;
                }
                DataCanbus.PROXY.cmd(107, new int[]{94, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_fan_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalLightActi.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[139] & 255) - 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(107, new int[]{91, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_fan_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalLightActi.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[139] & 255) + 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(107, new int[]{91, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_right_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalLightActi.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[140] & 255) - 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(107, new int[]{92, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_right_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalLightActi.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[140] & 255) + 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(107, new int[]{92, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_all_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalLightActi.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[143] & 255) - 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(107, new int[]{93, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_all_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalLightActi.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[143] & 255) + 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(107, new int[]{93, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_switch_on_time_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalLightActi.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[42] & 255) - 1;
                if (switchOn < 0) {
                    switchOn = 2;
                }
                DataCanbus.PROXY.cmd(107, new int[]{80, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_switch_on_time_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalLightActi.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[42] & 255) + 1;
                if (switchOn > 2) {
                    switchOn = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{80, switchOn}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_lane_change_flash), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalLightActi.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[44] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 82;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_travel_mode), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalLightActi.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[45] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 86;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_instrument_switch_lighting_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalLightActi.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[46] & 255) - 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(107, new int[]{83, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_instrument_switch_lighting_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalLightActi.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[46] & 255) + 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(107, new int[]{83, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_door_background_lighting_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalLightActi.24
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[47] & 255) - 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(107, new int[]{87, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_door_background_lighting_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalLightActi.25
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[47] & 255) + 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(107, new int[]{87, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_footwell_lighting_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalLightActi.26
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[48] & 255) - 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(107, new int[]{88, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_footwell_lighting_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalLightActi.27
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[48] & 255) + 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(107, new int[]{88, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_coming_home_function_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalLightActi.28
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[49] & 255) - 5;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 30) {
                    switchOn = 30;
                }
                DataCanbus.PROXY.cmd(107, new int[]{84, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_coming_home_function_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalLightActi.29
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[49] & 255) + 5;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 30) {
                    switchOn = 30;
                }
                DataCanbus.PROXY.cmd(107, new int[]{84, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_leaving_home_function_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalLightActi.30
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[50] & 255) - 5;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 30) {
                    switchOn = 30;
                }
                DataCanbus.PROXY.cmd(107, new int[]{85, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_leaving_home_function_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalLightActi.31
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[50] & 255) + 5;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 30) {
                    switchOn = 30;
                }
                DataCanbus.PROXY.cmd(107, new int[]{85, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus1), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalLightActi.32
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[177] & 255) - 1;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 6) {
                    switchOn = 6;
                }
                DataCanbus.PROXY.cmd(107, new int[]{95, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus1), new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalLightActi.33
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[177] & 255) + 1;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 6) {
                    switchOn = 6;
                }
                DataCanbus.PROXY.cmd(107, new int[]{95, switchOn}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[78].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDayTimeRuningLights() {
        int switchOn = DataCanbus.DATA[78] & 255;
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_daytime_light), switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterlightcolor() {
        int switchOn = DataCanbus.DATA[138] & 255;
        if (switchOn < 5) {
            if (switchOn == 1) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_color)).setText(R.string.color_white_str);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_color)).setText(R.string.str_background_green);
            } else if (switchOn == 3) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_color)).setText(R.string.str_background_blue);
            } else {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_color)).setText(R.string.off);
            }
            ((TextView) findViewById(R.id.glf7_tv_functional_light_10color)).setText(R.string.off);
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.off);
            return;
        }
        if (switchOn >= 5 && switchOn <= 14) {
            ((TextView) findViewById(R.id.glf7_tv_functional_light_color)).setText(R.string.off);
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.off);
            if (switchOn == 5) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_10color)).setText(R.string.color_white_str);
                return;
            }
            if (switchOn == 6) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_10color)).setText(R.string.str_403_ambient_7);
                return;
            }
            if (switchOn == 7) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_10color)).setText(R.string.str_403_ambient_1);
                return;
            }
            if (switchOn == 8) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_10color)).setText(R.string.str_403_ambient_3);
                return;
            }
            if (switchOn == 9) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_10color)).setText(R.string.str_403_ambient_8);
                return;
            }
            if (switchOn == 10) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_10color)).setText(R.string.color_ice_blue);
                return;
            }
            if (switchOn == 11) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_10color)).setText(R.string.str_background_blue);
                return;
            }
            if (switchOn == 12) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_10color)).setText(R.string.str_403_ambient_2);
                return;
            }
            if (switchOn == 13) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_10color)).setText(R.string.str_403_ambient_4);
                return;
            } else if (switchOn == 14) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_10color)).setText(R.string.color_yellow_str);
                return;
            } else {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_10color)).setText(R.string.off);
                return;
            }
        }
        if (switchOn >= 15 && switchOn <= 44) {
            ((TextView) findViewById(R.id.glf7_tv_functional_light_10color)).setText(R.string.off);
            ((TextView) findViewById(R.id.glf7_tv_functional_light_color)).setText(R.string.off);
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.off);
            if (switchOn >= 15 && switchOn <= 44) {
                int value = switchOn - 14;
                ((TextView) findViewById(R.id.tv_text2)).setText("Color " + value);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterlightfan() {
        int switchOn = DataCanbus.DATA[139] & 255;
        if (switchOn > -1 && switchOn < 101) {
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_fan)).setText(R.string.least);
            } else {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_fan)).setText(String.valueOf(switchOn) + "%");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterlightright() {
        int switchOn = DataCanbus.DATA[140] & 255;
        if (switchOn > -1 && switchOn < 101) {
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_right_lighting)).setText(R.string.least);
            } else {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_right_lighting)).setText(String.valueOf(switchOn) + "%");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLightall() {
        int switchOn = DataCanbus.DATA[143] & 255;
        if (switchOn > -1 && switchOn < 101) {
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_all_lighting)).setText(R.string.least);
            } else {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_all_lighting)).setText(String.valueOf(switchOn) + "%");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLightassist() {
        int switchOn = DataCanbus.DATA[141] & 255;
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_dynamic), switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLightbend() {
        int switchOn = DataCanbus.DATA[142] & 255;
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_follower), switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutoRain() {
        int value = DataCanbus.DATA[43];
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_automatic_headlight_control_rain), value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSwitchOnTime() {
        int value = DataCanbus.DATA[42];
        if (value == 0) {
            ((TextView) findViewById(R.id.glf7_tv_functional_light_switch_on_time)).setText(R.string.switch_on_time_early);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.glf7_tv_functional_light_switch_on_time)).setText(R.string.switch_on_time_medium);
        } else if (value == 2) {
            ((TextView) findViewById(R.id.glf7_tv_functional_light_switch_on_time)).setText(R.string.switch_on_time_late);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLaneChange() {
        int value = DataCanbus.DATA[44];
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_lane_change_flash), value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTravelMode() {
        int value = DataCanbus.DATA[45];
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_travel_mode), value != 0);
        ((TextView) findViewById(R.id.glf7_tv_functional_light_travel_mode)).setText(value != 0 ? R.string.travel_mode_left_hand_traffic : R.string.travel_mode_right_hand_traffic);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterInstrument() {
        int value = DataCanbus.DATA[46];
        if (value > -1 && value < 101) {
            if (value == 0) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_instrument_switch_lighting)).setText(R.string.least);
            } else {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_instrument_switch_lighting)).setText(String.valueOf(value) + "%");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDoorLight() {
        int value = DataCanbus.DATA[47];
        if (value > -1 && value < 101) {
            if (value == 0) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_door_background_lighting_lighting)).setText(R.string.least);
            } else {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_door_background_lighting_lighting)).setText(String.valueOf(value) + "%");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterFootLight() {
        int value = DataCanbus.DATA[48];
        if (value > -1 && value < 101) {
            if (value == 0) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_footwell_lighting_lighting)).setText(R.string.least);
            } else {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_footwell_lighting_lighting)).setText(String.valueOf(value) + "%");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterComeHome() {
        int value = DataCanbus.DATA[49];
        if (value > -1 && value < 31) {
            if (value == 0) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_coming_home_function_lighting)).setText(R.string.off);
            } else {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_coming_home_function_lighting)).setText(String.valueOf(value) + "s");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLeaveHome() {
        int value = DataCanbus.DATA[50];
        if (value > -1 && value < 31) {
            if (value == 0) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_leaving_home_function_lighting)).setText(R.string.off);
            } else {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_leaving_home_function_lighting)).setText(String.valueOf(value) + "s");
            }
        }
    }
}
