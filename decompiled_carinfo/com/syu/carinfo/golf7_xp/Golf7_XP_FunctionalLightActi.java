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
public class Golf7_XP_FunctionalLightActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 139:
                    Golf7_XP_FunctionalLightActi.this.mUpdaterSwitchOnTime();
                    break;
                case 140:
                    Golf7_XP_FunctionalLightActi.this.mUpdaterAutoRain();
                    break;
                case 141:
                    Golf7_XP_FunctionalLightActi.this.mUpdaterLaneChange();
                    break;
                case 142:
                    Golf7_XP_FunctionalLightActi.this.mUpdaterTravelMode();
                    break;
                case 143:
                    Golf7_XP_FunctionalLightActi.this.mUpdaterInstrument();
                    break;
                case 144:
                    Golf7_XP_FunctionalLightActi.this.mUpdaterDoorLight();
                    break;
                case 145:
                    Golf7_XP_FunctionalLightActi.this.mUpdaterFootLight();
                    break;
                case 146:
                    Golf7_XP_FunctionalLightActi.this.mUpdaterComeHome();
                    break;
                case 147:
                    Golf7_XP_FunctionalLightActi.this.mUpdaterLeaveHome();
                    break;
                case 175:
                    Golf7_XP_FunctionalLightActi.this.mUpdaterDayTimeRuningLights();
                    break;
                case 192:
                    Golf7_XP_FunctionalLightActi.this.mUpdaterlightcolor();
                    break;
                case 193:
                    Golf7_XP_FunctionalLightActi.this.mUpdaterlightfan();
                    break;
                case 194:
                    Golf7_XP_FunctionalLightActi.this.mUpdaterlightright();
                    break;
                case 195:
                    Golf7_XP_FunctionalLightActi.this.mUpdaterLightassist();
                    break;
                case 196:
                    Golf7_XP_FunctionalLightActi.this.mUpdaterLightbend();
                    break;
                case 197:
                    Golf7_XP_FunctionalLightActi.this.mUpdaterLightall();
                    break;
                case 231:
                    ((TextView) Golf7_XP_FunctionalLightActi.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_golf7_functional_state_light_xp);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_daytime_light), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[175] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 200;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_automatic_headlight_control_rain), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[140] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 81;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_dynamic), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[195] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 90;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_follower), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[196] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 89;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_color_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn;
                int switchOn2 = DataCanbus.DATA[192] & 255;
                if (switchOn2 > 0) {
                    switchOn = switchOn2 - 1;
                } else {
                    switchOn = 3;
                }
                DataCanbus.PROXY.cmd(107, new int[]{94, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_color_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn;
                int switchOn2 = DataCanbus.DATA[192] & 255;
                if (switchOn2 < 3) {
                    switchOn = switchOn2 + 1;
                } else {
                    switchOn = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{94, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_10color_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[192] & 255;
                if (switchOn > 5) {
                    switchOn--;
                }
                DataCanbus.PROXY.cmd(107, new int[]{94, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_10color_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[192] & 255;
                if (switchOn < 5) {
                    switchOn = 5;
                } else if (switchOn < 14) {
                    switchOn++;
                }
                DataCanbus.PROXY.cmd(107, new int[]{94, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus2), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[192] & 255;
                if (switchOn > 15) {
                    switchOn--;
                }
                DataCanbus.PROXY.cmd(107, new int[]{94, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus2), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[192] & 255;
                if (switchOn < 15) {
                    switchOn = 15;
                } else if (switchOn < 44) {
                    switchOn++;
                }
                DataCanbus.PROXY.cmd(107, new int[]{94, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_fan_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[193] & 255) - 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(107, new int[]{91, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_fan_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[193] & 255) + 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(107, new int[]{91, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_right_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[194] & 255) - 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(107, new int[]{92, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_right_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[194] & 255) + 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(107, new int[]{92, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_all_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[197] & 255) - 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(107, new int[]{93, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_all_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[197] & 255) + 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(107, new int[]{93, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_switch_on_time_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[139] & 255) - 1;
                if (switchOn < 0) {
                    switchOn = 2;
                }
                DataCanbus.PROXY.cmd(107, new int[]{80, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_switch_on_time_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[139] & 255) + 1;
                if (switchOn > 2) {
                    switchOn = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{80, switchOn}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_lane_change_flash), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[141] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 82;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_travel_mode), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[142] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 86;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_instrument_switch_lighting_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[143] & 255) - 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(107, new int[]{83, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_instrument_switch_lighting_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[143] & 255) + 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(107, new int[]{83, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_door_background_lighting_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[144] & 255) - 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(107, new int[]{87, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_door_background_lighting_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[144] & 255) + 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(107, new int[]{87, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_footwell_lighting_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[145] & 255) - 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(107, new int[]{88, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_footwell_lighting_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[145] & 255) + 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(107, new int[]{88, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_coming_home_function_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[146] & 255) - 5;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 30) {
                    switchOn = 30;
                }
                DataCanbus.PROXY.cmd(107, new int[]{84, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_coming_home_function_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[146] & 255) + 5;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 30) {
                    switchOn = 30;
                }
                DataCanbus.PROXY.cmd(107, new int[]{84, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_leaving_home_function_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[147] & 255) - 5;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 30) {
                    switchOn = 30;
                }
                DataCanbus.PROXY.cmd(107, new int[]{85, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_leaving_home_function_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[147] & 255) + 5;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 30) {
                    switchOn = 30;
                }
                DataCanbus.PROXY.cmd(107, new int[]{85, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus1), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[231] & 255) - 1;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 6) {
                    switchOn = 6;
                }
                DataCanbus.PROXY.cmd(107, new int[]{95, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus1), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[231] & 255) + 1;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 6) {
                    switchOn = 6;
                }
                DataCanbus.PROXY.cmd(107, new int[]{95, switchOn}, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[193].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[231].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[193].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[231].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterDayTimeRuningLights() {
        int switchOn = DataCanbus.DATA[175] & 255;
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_daytime_light), switchOn != 0);
    }

    
    public void mUpdaterlightcolor() {
        int switchOn = DataCanbus.DATA[192] & 255;
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

    
    public void mUpdaterlightfan() {
        int switchOn = DataCanbus.DATA[193] & 255;
        if (switchOn > -1 && switchOn < 101) {
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_fan)).setText(R.string.least);
            } else {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_fan)).setText(String.valueOf(switchOn) + "%");
            }
        }
    }

    
    public void mUpdaterlightright() {
        int switchOn = DataCanbus.DATA[194] & 255;
        if (switchOn > -1 && switchOn < 101) {
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_right_lighting)).setText(R.string.least);
            } else {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_right_lighting)).setText(String.valueOf(switchOn) + "%");
            }
        }
    }

    
    public void mUpdaterLightall() {
        int switchOn = DataCanbus.DATA[197] & 255;
        if (switchOn > -1 && switchOn < 101) {
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_all_lighting)).setText(R.string.least);
            } else {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_all_lighting)).setText(String.valueOf(switchOn) + "%");
            }
        }
    }

    
    public void mUpdaterLightassist() {
        int switchOn = DataCanbus.DATA[195] & 255;
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_dynamic), switchOn != 0);
    }

    
    public void mUpdaterLightbend() {
        int switchOn = DataCanbus.DATA[196] & 255;
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_follower), switchOn != 0);
    }

    
    public void mUpdaterAutoRain() {
        int value = DataCanbus.DATA[140];
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_automatic_headlight_control_rain), value != 0);
    }

    
    public void mUpdaterSwitchOnTime() {
        int value = DataCanbus.DATA[139];
        if (value == 0) {
            ((TextView) findViewById(R.id.glf7_tv_functional_light_switch_on_time)).setText(R.string.switch_on_time_early);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.glf7_tv_functional_light_switch_on_time)).setText(R.string.switch_on_time_medium);
        } else if (value == 2) {
            ((TextView) findViewById(R.id.glf7_tv_functional_light_switch_on_time)).setText(R.string.switch_on_time_late);
        }
    }

    
    public void mUpdaterLaneChange() {
        int value = DataCanbus.DATA[141];
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_lane_change_flash), value != 0);
    }

    
    public void mUpdaterTravelMode() {
        int value = DataCanbus.DATA[142];
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_travel_mode), value != 0);
        ((TextView) findViewById(R.id.glf7_tv_functional_light_travel_mode)).setText(value != 0 ? R.string.travel_mode_left_hand_traffic : R.string.travel_mode_right_hand_traffic);
    }

    
    public void mUpdaterInstrument() {
        int value = DataCanbus.DATA[143];
        if (value > -1 && value < 101) {
            if (value == 0) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_instrument_switch_lighting)).setText(R.string.least);
            } else {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_instrument_switch_lighting)).setText(String.valueOf(value) + "%");
            }
        }
    }

    
    public void mUpdaterDoorLight() {
        int value = DataCanbus.DATA[144];
        if (value > -1 && value < 101) {
            if (value == 0) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_door_background_lighting_lighting)).setText(R.string.least);
            } else {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_door_background_lighting_lighting)).setText(String.valueOf(value) + "%");
            }
        }
    }

    
    public void mUpdaterFootLight() {
        int value = DataCanbus.DATA[145];
        if (value > -1 && value < 101) {
            if (value == 0) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_footwell_lighting_lighting)).setText(R.string.least);
            } else {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_footwell_lighting_lighting)).setText(String.valueOf(value) + "%");
            }
        }
    }

    
    public void mUpdaterComeHome() {
        int value = DataCanbus.DATA[146];
        if (value > -1 && value < 31) {
            if (value == 0) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_coming_home_function_lighting)).setText(R.string.off);
            } else {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_coming_home_function_lighting)).setText(String.valueOf(value) + "s");
            }
        }
    }

    
    public void mUpdaterLeaveHome() {
        int value = DataCanbus.DATA[147];
        if (value > -1 && value < 31) {
            if (value == 0) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_leaving_home_function_lighting)).setText(R.string.off);
            } else {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_leaving_home_function_lighting)).setText(String.valueOf(value) + "s");
            }
        }
    }
}
