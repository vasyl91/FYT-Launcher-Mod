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
public class Golf7FunctionalLightActi extends BaseActivity {
    int cartype = 1;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 42:
                    Golf7FunctionalLightActi.this.mUpdaterSwitchOnTime();
                    break;
                case 43:
                    Golf7FunctionalLightActi.this.mUpdaterAutoRain();
                    break;
                case 44:
                    Golf7FunctionalLightActi.this.mUpdaterLaneChange();
                    break;
                case 45:
                    Golf7FunctionalLightActi.this.mUpdaterTravelMode();
                    break;
                case 46:
                    Golf7FunctionalLightActi.this.mUpdaterInstrument();
                    break;
                case 47:
                    Golf7FunctionalLightActi.this.mUpdaterDoorLight();
                    break;
                case 48:
                    Golf7FunctionalLightActi.this.mUpdaterFootLight();
                    break;
                case 49:
                    Golf7FunctionalLightActi.this.mUpdaterComeHome();
                    break;
                case 50:
                    Golf7FunctionalLightActi.this.mUpdaterLeaveHome();
                    break;
                case 78:
                    Golf7FunctionalLightActi.this.mUpdaterDayTimeRuningLights();
                    break;
                case 139:
                    Golf7FunctionalLightActi.this.mUpdaterlightcolor();
                    break;
                case 140:
                    Golf7FunctionalLightActi.this.mUpdaterlightfan();
                    break;
                case 141:
                    Golf7FunctionalLightActi.this.mUpdaterlightright();
                    break;
                case 142:
                    Golf7FunctionalLightActi.this.mUpdaterLightassist();
                    break;
                case 143:
                    Golf7FunctionalLightActi.this.mUpdaterLightbend();
                    break;
                case 144:
                    Golf7FunctionalLightActi.this.mUpdaterLightall();
                    break;
                case 159:
                    Golf7FunctionalLightActi.this.mUpdaterBackbright();
                    break;
                case 160:
                    Golf7FunctionalLightActi.this.mUpdaterBackcontrast();
                    break;
                case 161:
                    Golf7FunctionalLightActi.this.mUpdaterBacksrturation();
                    break;
                case 235:
                    Golf7FunctionalLightActi.this.mUpdaterLightDistance();
                    break;
                case 258:
                    Golf7FunctionalLightActi.this.updateChangeBright();
                    break;
                case 267:
                    Golf7FunctionalLightActi.this.mUpdaterAllbrightness();
                    break;
                case 339:
                    int strid = R.string.off;
                    if (((TextView) Golf7FunctionalLightActi.this.findViewById(R.id.tv_text1)) != null) {
                        if (value == 2) {
                            strid = R.string.klc_air_auto;
                        } else if (value == 1) {
                            strid = R.string.klc_air_Manual;
                        }
                        ((TextView) Golf7FunctionalLightActi.this.findViewById(R.id.tv_text1)).setText(strid);
                        break;
                    }
                case 371:
                case 372:
                    int onoff = DataCanbus.DATA[371];
                    int coclor = DataCanbus.DATA[372];
                    Golf7FunctionalLightActi.this.setCheck((CheckedTextView) Golf7FunctionalLightActi.this.findViewById(R.id.ctv_checkedtext1), onoff != 0);
                    if (((TextView) Golf7FunctionalLightActi.this.findViewById(R.id.tv_text1)) != null) {
                        int strid2 = R.string.off;
                        if (onoff == 1) {
                            if (coclor == 1) {
                                strid2 = R.string.color_white_str;
                            } else if (coclor == 4) {
                                strid2 = R.string.str_403_ambient_4;
                            } else if (coclor == 5) {
                                strid2 = R.string.str_403_ambient_5;
                            }
                        }
                        ((TextView) Golf7FunctionalLightActi.this.findViewById(R.id.tv_text3)).setText(strid2);
                        break;
                    }
                case 385:
                    if (((TextView) Golf7FunctionalLightActi.this.findViewById(R.id.tv_text2)) != null) {
                        if (value == 1) {
                            ((TextView) Golf7FunctionalLightActi.this.findViewById(R.id.tv_text2)).setText("type1");
                            break;
                        } else if (value == 2) {
                            ((TextView) Golf7FunctionalLightActi.this.findViewById(R.id.tv_text2)).setText("type2");
                            break;
                        } else if (value == 3) {
                            ((TextView) Golf7FunctionalLightActi.this.findViewById(R.id.tv_text2)).setText("type3");
                            break;
                        }
                    }
                    break;
                case 395:
                    if (((TextView) Golf7FunctionalLightActi.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) Golf7FunctionalLightActi.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "%");
                        break;
                    }
                case 399:
                    if (((TextView) Golf7FunctionalLightActi.this.findViewById(R.id.tv_text5)) != null) {
                        if (value == 1) {
                            ((TextView) Golf7FunctionalLightActi.this.findViewById(R.id.tv_text5)).setText(R.string.str_different);
                            break;
                        } else {
                            ((TextView) Golf7FunctionalLightActi.this.findViewById(R.id.tv_text5)).setText(R.string.str_same);
                            break;
                        }
                    }
                    break;
                case 400:
                    if (((TextView) Golf7FunctionalLightActi.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Golf7FunctionalLightActi.this.findViewById(R.id.tv_text6)).setText(R.string.str_driving_indivdual);
                                break;
                            case 2:
                            default:
                                ((TextView) Golf7FunctionalLightActi.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                                break;
                            case 3:
                                ((TextView) Golf7FunctionalLightActi.this.findViewById(R.id.tv_text6)).setText("无限");
                                break;
                            case 4:
                                ((TextView) Golf7FunctionalLightActi.this.findViewById(R.id.tv_text6)).setText("永恒");
                                break;
                            case 5:
                                ((TextView) Golf7FunctionalLightActi.this.findViewById(R.id.tv_text6)).setText("渴望");
                                break;
                            case 6:
                                ((TextView) Golf7FunctionalLightActi.this.findViewById(R.id.tv_text6)).setText("沉醉");
                                break;
                            case 7:
                                ((TextView) Golf7FunctionalLightActi.this.findViewById(R.id.tv_text6)).setText("活力");
                                break;
                        }
                    }
                    break;
                case 401:
                    if (((TextView) Golf7FunctionalLightActi.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) Golf7FunctionalLightActi.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 402:
                    if (((TextView) Golf7FunctionalLightActi.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) Golf7FunctionalLightActi.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            setContentView(R.layout.layout_golf7_functional_state_light_od);
        } else {
            setContentView(R.layout.layout_golf7_functional_state_light);
        }
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            setSelfClick((Button) findViewById(R.id.glf7_btn_car_back_od), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(Golf7FunctionalLightActi.this, Golf7FunctionalActiOD.class);
                        Golf7FunctionalLightActi.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_daytime_light), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[78] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(13, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_automatic_headlight_control_rain), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[43] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(59, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_dynamic), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[142] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 1;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(105, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_follower), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[143] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 2;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(105, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_color_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn;
                int switchOn2 = DataCanbus.DATA[139] & 255;
                if (switchOn2 > 0) {
                    switchOn = switchOn2 - 1;
                } else {
                    switchOn = 3;
                }
                DataCanbus.PROXY.cmd(105, new int[]{12, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_color_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn;
                int switchOn2 = DataCanbus.DATA[139] & 255;
                if (switchOn2 < 3) {
                    switchOn = switchOn2 + 1;
                } else {
                    switchOn = 0;
                }
                DataCanbus.PROXY.cmd(105, new int[]{12, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_10color_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[139] & 255;
                if (ConstGolf.isWcGolf()) {
                    if (switchOn > 4) {
                        switchOn--;
                    } else {
                        switchOn = 13;
                    }
                } else if (switchOn > 0) {
                    switchOn--;
                }
                DataCanbus.PROXY.cmd(105, new int[]{12, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_10color_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[139] & 255;
                if (ConstGolf.isWcGolf()) {
                    switchOn = switchOn < 4 ? 4 : switchOn < 13 ? switchOn + 1 : 4;
                } else if (DataCanbus.DATA[1000] == 3604640) {
                    if (switchOn < 20) {
                        switchOn++;
                    }
                } else if (switchOn < 10) {
                    switchOn++;
                }
                DataCanbus.PROXY.cmd(105, new int[]{12, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_30color_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn;
                int switchOn2 = DataCanbus.DATA[139] & 255;
                if (switchOn2 > 4) {
                    switchOn = switchOn2 - 1;
                } else {
                    switchOn = 33;
                }
                DataCanbus.PROXY.cmd(105, new int[]{12, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_30color_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn;
                int switchOn2 = DataCanbus.DATA[139] & 255;
                if (switchOn2 < 4) {
                    switchOn = 4;
                } else if (switchOn2 < 33) {
                    switchOn = switchOn2 + 1;
                } else {
                    switchOn = 4;
                }
                DataCanbus.PROXY.cmd(105, new int[]{12, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_fan_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[140] & 255) - 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(105, new int[]{13, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_fan_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[140] & 255) + 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(105, new int[]{13, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_right_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[141] & 255) - 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(105, new int[]{14, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_right_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[141] & 255) + 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(105, new int[]{14, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.wc_btn_alllight_brightness_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[267] & 255) - 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(105, new int[]{15, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.wc_btn_alllight_brightness_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[267] & 255) + 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(105, new int[]{15, switchOn}, null, null);
            }
        });
        if (ConstGolf.isRZCGolf()) {
            setSelfClick((Button) findViewById(R.id.btn_minus1), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.19
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int switchOn = (DataCanbus.DATA[339] & 255) - 1;
                    if (switchOn < 0) {
                        switchOn = 0;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{74, switchOn}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_plus1), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.20
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int switchOn = (DataCanbus.DATA[339] & 255) + 1;
                    if (switchOn > 2) {
                        switchOn = 2;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{74, switchOn}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_minus2), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.21
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int cartype = (DataCanbus.DATA[385] & 255) - 1;
                    if (cartype < 1) {
                        cartype = 3;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{75, cartype}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_plus2), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.22
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int cartype = (DataCanbus.DATA[385] & 255) + 1;
                    if (cartype > 3) {
                        cartype = 1;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{75, cartype}, null, null);
                }
            });
            setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.23
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int switchOn = DataCanbus.DATA[371] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 76;
                    iArr[1] = switchOn == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(160, iArr, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_minus3), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.24
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int switchOn = DataCanbus.DATA[372] & 255;
                    if (switchOn == 1) {
                        switchOn = 5;
                    } else if (switchOn == 4) {
                        switchOn = 1;
                    } else if (switchOn == 5) {
                        switchOn = 4;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{76, switchOn}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_plus3), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.25
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int switchOn = DataCanbus.DATA[372] & 255;
                    if (switchOn == 1) {
                        switchOn = 4;
                    } else if (switchOn == 4) {
                        switchOn = 5;
                    } else if (switchOn == 5) {
                        switchOn = 1;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{76, switchOn}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_minus4), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.26
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int switchOn = (DataCanbus.DATA[395] & 255) - 10;
                    if (switchOn < 0) {
                        switchOn = 0;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{77, switchOn}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_plus4), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.27
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int switchOn = (DataCanbus.DATA[395] & 255) + 10;
                    if (switchOn > 100) {
                        switchOn = 100;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{77, switchOn}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_minus5), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.28
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int switchOn = (DataCanbus.DATA[399] & 255) - 1;
                    if (switchOn < 0) {
                        switchOn = 0;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{79, switchOn}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_plus5), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.29
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int switchOn = (DataCanbus.DATA[399] & 255) + 1;
                    if (switchOn > 1) {
                        switchOn = 1;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{79, switchOn}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_minus6), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.30
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int switchOn = (DataCanbus.DATA[400] & 255) - 1;
                    if (switchOn == 2) {
                        switchOn = 1;
                    } else if (switchOn < 1) {
                        switchOn = 8;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{101, switchOn}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_plus6), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.31
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int switchOn = (DataCanbus.DATA[400] & 255) + 1;
                    if (switchOn > 8) {
                        switchOn = 1;
                    } else if (switchOn == 2) {
                        switchOn = 3;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{101, switchOn}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_minus7), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.32
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int switchOn = (DataCanbus.DATA[401] & 255) - 1;
                    if (switchOn < 1) {
                        switchOn = 1;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{78, switchOn & 127}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_plus7), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.33
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int switchOn = (DataCanbus.DATA[401] & 255) + 1;
                    if (switchOn > 10) {
                        switchOn = 10;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{78, switchOn & 127}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_minus8), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.34
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int switchOn = (DataCanbus.DATA[402] & 255) - 1;
                    if (switchOn < 1) {
                        switchOn = 1;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{78, switchOn | 128}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_plus8), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.35
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int switchOn = (DataCanbus.DATA[402] & 255) + 1;
                    if (switchOn > 10) {
                        switchOn = 10;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{78, switchOn | 128}, null, null);
                }
            });
            findViewById(R.id.layout_view1).setVisibility(0);
            findViewById(R.id.layout_view2).setVisibility(0);
            if (DataCanbus.DATA[1000] != 2818208) {
                findViewById(R.id.layout_view3).setVisibility(8);
                findViewById(R.id.layout_view4).setVisibility(8);
            } else {
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
            }
            if (DataCanbus.DATA[1000] == 3342496) {
                findViewById(R.id.layout_view2).setVisibility(8);
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.glf7_view_functional_light_color_10).setVisibility(8);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
            } else {
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.glf7_view_functional_light_color_10).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(8);
                findViewById(R.id.layout_view7).setVisibility(8);
                findViewById(R.id.layout_view8).setVisibility(8);
                findViewById(R.id.layout_view9).setVisibility(8);
            }
        } else if (DataCanbus.DATA[1000] != 393233 && DataCanbus.DATA[1000] != 458769) {
            findViewById(R.id.layout_view1).setVisibility(8);
            findViewById(R.id.layout_view2).setVisibility(8);
            findViewById(R.id.layout_view3).setVisibility(8);
            findViewById(R.id.layout_view4).setVisibility(8);
        }
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_all_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.36
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[144] & 255) - 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(105, new int[]{15, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_all_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.37
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[144] & 255) + 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(105, new int[]{15, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_switch_on_time_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.38
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[42] & 255;
                if (switchOn == 2) {
                    DataCanbus.PROXY.cmd(58, new int[]{1}, null, null);
                } else if (switchOn == 1) {
                    DataCanbus.PROXY.cmd(58, new int[1], null, null);
                } else {
                    DataCanbus.PROXY.cmd(58, new int[]{2}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_switch_on_time_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.39
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[42] & 255;
                if (switchOn == 0) {
                    DataCanbus.PROXY.cmd(58, new int[]{1}, null, null);
                } else if (switchOn == 1) {
                    DataCanbus.PROXY.cmd(58, new int[]{2}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(58, new int[1], null, null);
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_lane_change_flash), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.40
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[44] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(60, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_travel_mode), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.41
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[45] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(61, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_instrument_switch_lighting_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.42
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[46] & 255) - 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(62, new int[]{switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_instrument_switch_lighting_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.43
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[46] & 255) + 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(62, new int[]{switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_door_background_lighting_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.44
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[47] & 255) - 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(63, new int[]{switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_door_background_lighting_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.45
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[47] & 255) + 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(63, new int[]{switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_footwell_lighting_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.46
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[48] & 255) - 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(64, new int[]{switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_footwell_lighting_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.47
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[48] & 255) + 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(64, new int[]{switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_coming_home_function_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.48
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[49] & 255) - 5;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 30) {
                    switchOn = 30;
                }
                DataCanbus.PROXY.cmd(65, new int[]{switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_coming_home_function_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.49
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[49] & 255) + 5;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 30) {
                    switchOn = 30;
                }
                DataCanbus.PROXY.cmd(65, new int[]{switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_leaving_home_function_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.50
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[50] & 255) - 5;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 30) {
                    switchOn = 30;
                }
                DataCanbus.PROXY.cmd(66, new int[]{switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_leaving_home_function_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.51
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[50] & 255) + 5;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 30) {
                    switchOn = 30;
                }
                DataCanbus.PROXY.cmd(66, new int[]{switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_back_bright_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.52
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[159] & 255) - 10;
                if (switchOn < 30) {
                    switchOn = 30;
                } else if (switchOn > 70) {
                    switchOn = 70;
                }
                DataCanbus.PROXY.cmd(105, new int[]{32, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_back_bright_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.53
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[159] & 255) + 10;
                if (switchOn < 30) {
                    switchOn = 30;
                } else if (switchOn > 70) {
                    switchOn = 70;
                }
                DataCanbus.PROXY.cmd(105, new int[]{32, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_back_contrast_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.54
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[160] & 255) - 10;
                if (switchOn < 30) {
                    switchOn = 30;
                } else if (switchOn > 70) {
                    switchOn = 70;
                }
                DataCanbus.PROXY.cmd(105, new int[]{33, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_back_contrast_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.55
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[160] & 255) + 10;
                if (switchOn < 30) {
                    switchOn = 30;
                } else if (switchOn > 70) {
                    switchOn = 70;
                }
                DataCanbus.PROXY.cmd(105, new int[]{33, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_back_saturation_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.56
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[161] & 255) - 10;
                if (switchOn < 30) {
                    switchOn = 30;
                } else if (switchOn > 70) {
                    switchOn = 70;
                }
                DataCanbus.PROXY.cmd(105, new int[]{34, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_back_saturation_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.57
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[161] & 255) + 10;
                if (switchOn < 30) {
                    switchOn = 30;
                } else if (switchOn > 70) {
                    switchOn = 70;
                }
                DataCanbus.PROXY.cmd(105, new int[]{34, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_light_distance_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.58
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[235] & 255) - 1;
                if (switchOn < 0) {
                    switchOn = 0;
                }
                DataCanbus.PROXY.cmd(133, new int[]{switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_light_distance_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.59
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[235] & 255) + 1;
                if (switchOn > 6) {
                    switchOn = 6;
                }
                DataCanbus.PROXY.cmd(133, new int[]{switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.wc_btn_change_bright_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.60
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[258] & 255;
                if (value2 <= 1) {
                    value = 1;
                } else {
                    value = value2 - 1;
                }
                DataCanbus.PROXY.cmd(135, new int[]{value}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.wc_btn_change_bright_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalLightActi.61
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[258] & 255;
                if (value2 >= 5) {
                    value = 5;
                } else {
                    value = value2 + 1;
                }
                DataCanbus.PROXY.cmd(135, new int[]{value}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[385].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[235].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[258].addNotify(this.mNotifyCanbus, 1);
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            DataCanbus.NOTIFY_EVENTS[267].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstGolf.isRZCGolf()) {
            DataCanbus.NOTIFY_EVENTS[339].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[371].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[372].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[395].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[399].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[400].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[401].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[402].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[385].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[78].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[235].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[258].removeNotify(this.mNotifyCanbus);
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            DataCanbus.NOTIFY_EVENTS[267].removeNotify(this.mNotifyCanbus);
        }
        if (ConstGolf.isRZCGolf()) {
            DataCanbus.NOTIFY_EVENTS[339].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[371].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[372].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[395].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[399].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[400].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[401].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[402].removeNotify(this.mNotifyCanbus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBackbright() {
        int value = DataCanbus.DATA[159] & 255;
        if (DataCanbus.DATA[1000] == 437) {
            setViewVisible(findViewById(R.id.glf7_view_back_bright), true);
            ((TextView) findViewById(R.id.glf7_tv_back_bright)).setText(new StringBuilder().append(value).toString());
        } else {
            setViewVisible(findViewById(R.id.glf7_view_back_bright), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBackcontrast() {
        int value = DataCanbus.DATA[160] & 255;
        if (DataCanbus.DATA[1000] == 437) {
            setViewVisible(findViewById(R.id.glf7_view_back_contrast), true);
            ((TextView) findViewById(R.id.glf7_tv_back_contrast)).setText(new StringBuilder().append(value).toString());
        } else {
            setViewVisible(findViewById(R.id.glf7_view_back_contrast), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBacksrturation() {
        int value = DataCanbus.DATA[161] & 255;
        if (DataCanbus.DATA[1000] == 437) {
            setViewVisible(findViewById(R.id.glf7_view_back_saturation), true);
            ((TextView) findViewById(R.id.glf7_tv_back_saturation)).setText(new StringBuilder().append(value).toString());
        } else {
            setViewVisible(findViewById(R.id.glf7_view_back_saturation), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLightDistance() {
        int value = DataCanbus.DATA[235];
        int enable = (65280 & value) >> 8;
        int switchOn = value & 255;
        if (ConstGolf.isWcGolf()) {
            setViewVisible(findViewById(R.id.glf7_view_light_distance), enable != 0);
            ((TextView) findViewById(R.id.glf7_tv_light_distance)).setText(new StringBuilder().append(switchOn).toString());
        } else {
            setViewVisible(findViewById(R.id.glf7_view_light_distance), true);
            ((TextView) findViewById(R.id.glf7_tv_light_distance)).setText(new StringBuilder().append(switchOn).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateChangeBright() {
        int value = DataCanbus.DATA[258];
        int enable = (65280 & value) >> 8;
        int switchOn = value & 255;
        if (ConstGolf.isWcGolf()) {
            setViewVisible(findViewById(R.id.glf7_view_brightness), enable != 0);
            ((TextView) findViewById(R.id.wc_tv_change_bright)).setText(new StringBuilder().append(switchOn).toString());
        } else {
            setViewVisible(findViewById(R.id.glf7_view_brightness), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDayTimeRuningLights() {
        int value = DataCanbus.DATA[78];
        int enable = (65280 & value) >> 8;
        int switchOn = value & 255;
        if (ConstGolf.isWcGolf()) {
            setViewVisible(findViewById(R.id.glf7_view_functional_light_daytime_light), enable != 0);
        } else {
            setViewVisible(findViewById(R.id.glf7_view_functional_light_daytime_light), true);
        }
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_daytime_light), switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterlightcolor() {
        int value = DataCanbus.DATA[139];
        int enable = (65280 & value) >> 8;
        int switchOn = value & 255;
        if (ConstGolf.isWcGolf()) {
            setViewVisible(findViewById(R.id.glf7_view_functional_light_color), enable != 0);
            setViewVisible(findViewById(R.id.glf7_view_functional_light_color_10), enable != 0);
            setViewVisible(findViewById(R.id.glf7_view_functional_light_30color), enable != 0);
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_color)).setText(R.string.off);
                ((TextView) findViewById(R.id.glf7_tv_functional_light_10color)).setText(R.string.off);
                ((TextView) findViewById(R.id.glf7_tv_functional_light_30color)).setText(R.string.off);
                return;
            }
            if (switchOn > 3) {
                if (switchOn > 10) {
                    ((TextView) findViewById(R.id.glf7_tv_functional_light_10color)).setText("10");
                } else {
                    ((TextView) findViewById(R.id.glf7_tv_functional_light_10color)).setText(String.format("%d", Integer.valueOf(switchOn - 3)));
                }
                ((TextView) findViewById(R.id.glf7_tv_functional_light_30color)).setText(String.format("%d", Integer.valueOf(switchOn - 3)));
                return;
            }
            if (switchOn == 1) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_color)).setText(R.string.color_white_str);
                return;
            }
            if (switchOn == 2) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_color)).setText(R.string.color_orange_str);
                return;
            } else if (switchOn == 3) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_color)).setText(R.string.str_background_blue);
                return;
            } else {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_color)).setText(R.string.off);
                return;
            }
        }
        if (DataCanbus.DATA[1000] == 437) {
            setViewVisible(findViewById(R.id.glf7_view_functional_light_color), true);
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_color)).setText(R.string.off);
            } else if (switchOn == 1) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_color)).setText(R.string.color_white_str);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_color)).setText(R.string.color_orange_str);
            } else if (switchOn == 3) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_color)).setText(R.string.str_background_blue);
            }
            setViewVisible(findViewById(R.id.glf7_view_functional_light_color_10), false);
            setViewVisible(findViewById(R.id.glf7_view_functional_light_30color), false);
            return;
        }
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.glf7_tv_functional_light_10color)).setText(R.string.color_white_str);
        } else if (switchOn == 2) {
            ((TextView) findViewById(R.id.glf7_tv_functional_light_10color)).setText(R.string.color_orange_str);
        } else if (switchOn == 3) {
            ((TextView) findViewById(R.id.glf7_tv_functional_light_10color)).setText(R.string.str_background_blue);
        } else if (switchOn == 4) {
            ((TextView) findViewById(R.id.glf7_tv_functional_light_10color)).setText(R.string.str_403_ambient_3);
        } else if (switchOn == 5) {
            ((TextView) findViewById(R.id.glf7_tv_functional_light_10color)).setText(R.string.str_color_orange_yellow);
        } else if (switchOn == 6) {
            ((TextView) findViewById(R.id.glf7_tv_functional_light_10color)).setText(R.string.str_403_ambient_7);
        } else if (switchOn == 7) {
            ((TextView) findViewById(R.id.glf7_tv_functional_light_10color)).setText(R.string.str_403_ambient_4);
        } else if (switchOn == 8) {
            ((TextView) findViewById(R.id.glf7_tv_functional_light_10color)).setText(R.string.str_wc_174008_str11);
        } else if (switchOn == 9) {
            ((TextView) findViewById(R.id.glf7_tv_functional_light_10color)).setText(R.string.color_darkskyblue_str);
        } else if (switchOn == 10) {
            ((TextView) findViewById(R.id.glf7_tv_functional_light_10color)).setText(R.string.str_403_ambient_8);
        } else if (switchOn == 0) {
            ((TextView) findViewById(R.id.glf7_tv_functional_light_10color)).setText(R.string.off);
        } else {
            ((TextView) findViewById(R.id.glf7_tv_functional_light_10color)).setText(new StringBuilder(String.valueOf(switchOn)).toString());
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_light_color), false);
        if (DataCanbus.DATA[1000] != 3342496) {
            setViewVisible(findViewById(R.id.glf7_view_functional_light_color_10), true);
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_light_30color), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterlightfan() {
        int value = DataCanbus.DATA[140];
        int enable = (65280 & value) >> 8;
        int switchOn = value & 255;
        if (ConstGolf.isWcGolf()) {
            setViewVisible(findViewById(R.id.glf7_view_functional_light_fan), enable != 0);
            if (switchOn > -1 && switchOn < 101) {
                if (switchOn == 0) {
                    ((TextView) findViewById(R.id.glf7_tv_functional_light_fan)).setText(R.string.least);
                    return;
                } else {
                    ((TextView) findViewById(R.id.glf7_tv_functional_light_fan)).setText(String.valueOf(switchOn) + "%");
                    return;
                }
            }
            return;
        }
        if (ConstGolf.isRZCGolf() || DataCanbus.DATA[1000] == 437) {
            setViewVisible(findViewById(R.id.glf7_view_functional_light_fan), true);
            if (switchOn > -1 && switchOn < 101) {
                if (switchOn == 0) {
                    ((TextView) findViewById(R.id.glf7_tv_functional_light_fan)).setText(R.string.least);
                    return;
                } else {
                    ((TextView) findViewById(R.id.glf7_tv_functional_light_fan)).setText(String.valueOf(switchOn) + "%");
                    return;
                }
            }
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_light_fan), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterlightright() {
        int value = DataCanbus.DATA[141];
        int enable = (65280 & value) >> 8;
        int switchOn = value & 255;
        if (ConstGolf.isWcGolf()) {
            setViewVisible(findViewById(R.id.glf7_view_functional_light_right), enable != 0);
            if (switchOn > -1 && switchOn < 101) {
                if (switchOn == 0) {
                    ((TextView) findViewById(R.id.glf7_tv_functional_light_right_lighting)).setText(R.string.least);
                    return;
                } else {
                    ((TextView) findViewById(R.id.glf7_tv_functional_light_right_lighting)).setText(String.valueOf(switchOn) + "%");
                    return;
                }
            }
            return;
        }
        if (ConstGolf.isRZCGolf() || DataCanbus.DATA[1000] == 437) {
            setViewVisible(findViewById(R.id.glf7_view_functional_light_right), true);
            if (switchOn > -1 && switchOn < 101) {
                if (switchOn == 0) {
                    ((TextView) findViewById(R.id.glf7_tv_functional_light_right_lighting)).setText(R.string.least);
                    return;
                } else {
                    ((TextView) findViewById(R.id.glf7_tv_functional_light_right_lighting)).setText(String.valueOf(switchOn) + "%");
                    return;
                }
            }
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_light_right), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLightall() {
        int value = DataCanbus.DATA[144];
        int switchOn = value & 255;
        if (ConstGolf.isWcGolf()) {
            setViewVisible(findViewById(R.id.glf7_view_functional_light_all), false);
            return;
        }
        if (ConstGolf.isRZCGolf() || DataCanbus.DATA[1000] == 437) {
            setViewVisible(findViewById(R.id.glf7_view_functional_light_all), true);
            if (switchOn > -1 && switchOn < 101) {
                if (switchOn == 0) {
                    ((TextView) findViewById(R.id.glf7_tv_functional_light_all_lighting)).setText(R.string.least);
                    return;
                } else {
                    ((TextView) findViewById(R.id.glf7_tv_functional_light_all_lighting)).setText(String.valueOf(switchOn) + "%");
                    return;
                }
            }
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_light_all), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLightassist() {
        int value = DataCanbus.DATA[142];
        int enable = (65280 & value) >> 8;
        int switchOn = value & 255;
        if (ConstGolf.isWcGolf()) {
            setViewVisible(findViewById(R.id.glf7_view_functional_light_dynamic), enable != 0);
        } else {
            setViewVisible(findViewById(R.id.glf7_view_functional_light_dynamic), true);
        }
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_dynamic), switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLightbend() {
        int value = DataCanbus.DATA[143];
        int enable = (65280 & value) >> 8;
        int switchOn = value & 255;
        if (ConstGolf.isWcGolf()) {
            setViewVisible(findViewById(R.id.glf7_view_functional_light_follower), enable != 0);
        } else {
            setViewVisible(findViewById(R.id.glf7_view_functional_light_follower), true);
        }
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_follower), switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutoRain() {
        int value = DataCanbus.DATA[43];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_light_automatic_headlight_control_rain), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_automatic_headlight_control_rain), switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_light_automatic_headlight_control_rain), true);
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_automatic_headlight_control_rain), value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSwitchOnTime() {
        int value = DataCanbus.DATA[42];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_light_switch_on_time), enable != 0);
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_switch_on_time)).setText(R.string.switch_on_time_early);
                return;
            } else if (switchOn == 1) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_switch_on_time)).setText(R.string.switch_on_time_medium);
                return;
            } else {
                if (switchOn == 2) {
                    ((TextView) findViewById(R.id.glf7_tv_functional_light_switch_on_time)).setText(R.string.switch_on_time_late);
                    return;
                }
                return;
            }
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_light_switch_on_time), true);
        if (value == 0) {
            ((TextView) findViewById(R.id.glf7_tv_functional_light_switch_on_time)).setText(R.string.switch_on_time_early);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.glf7_tv_functional_light_switch_on_time)).setText(R.string.switch_on_time_medium);
        } else if (value == 2) {
            ((TextView) findViewById(R.id.glf7_tv_functional_light_switch_on_time)).setText(R.string.switch_on_time_late);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAllbrightness() {
        int value = DataCanbus.DATA[267];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_alllight_brightness), enable != 0);
            if (switchOn > -1 && switchOn < 101) {
                if (switchOn == 0) {
                    ((TextView) findViewById(R.id.wc_tv_alllight_brightness)).setText(R.string.least);
                } else {
                    ((TextView) findViewById(R.id.wc_tv_alllight_brightness)).setText(String.valueOf(switchOn) + "%");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLaneChange() {
        int value = DataCanbus.DATA[44];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_light_lane_change_flash), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_lane_change_flash), switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_light_lane_change_flash), true);
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_lane_change_flash), value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTravelMode() {
        int i = R.string.travel_mode_left_hand_traffic;
        int value = DataCanbus.DATA[45];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_light_travel_mode), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_travel_mode), switchOn != 0);
            ((TextView) findViewById(R.id.glf7_tv_functional_light_travel_mode)).setText(switchOn == 0 ? 2131296458 : 2131296457);
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_light_travel_mode), true);
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_travel_mode), value != 0);
        TextView textView = (TextView) findViewById(R.id.glf7_tv_functional_light_travel_mode);
        if (value == 0) {
            i = 2131296457;
        }
        textView.setText(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterInstrument() {
        int value = DataCanbus.DATA[46];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_light_instrument_switch_lighting), enable != 0);
            if (switchOn > -1 && switchOn < 101) {
                if (switchOn == 0) {
                    ((TextView) findViewById(R.id.glf7_tv_functional_light_instrument_switch_lighting)).setText(R.string.least);
                    return;
                } else {
                    ((TextView) findViewById(R.id.glf7_tv_functional_light_instrument_switch_lighting)).setText(String.valueOf(switchOn) + "%");
                    return;
                }
            }
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_light_instrument_switch_lighting), true);
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
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_light_door_background_lighting), enable != 0);
            if (switchOn > -1 && switchOn < 101) {
                if (switchOn == 0) {
                    ((TextView) findViewById(R.id.glf7_tv_functional_light_door_background_lighting_lighting)).setText(R.string.least);
                    return;
                } else {
                    ((TextView) findViewById(R.id.glf7_tv_functional_light_door_background_lighting_lighting)).setText(String.valueOf(switchOn) + "%");
                    return;
                }
            }
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_light_door_background_lighting), true);
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
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_light_footwell_lighting_lighting), enable != 0);
            if (switchOn > -1 && switchOn < 101) {
                if (switchOn == 0) {
                    ((TextView) findViewById(R.id.glf7_tv_functional_light_footwell_lighting_lighting)).setText(R.string.least);
                    return;
                } else {
                    ((TextView) findViewById(R.id.glf7_tv_functional_light_footwell_lighting_lighting)).setText(String.valueOf(switchOn) + "%");
                    return;
                }
            }
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_light_footwell_lighting_lighting), true);
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
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_light_coming_home_function), enable != 0);
            if (switchOn > -1 && switchOn < 31) {
                if (switchOn == 0) {
                    ((TextView) findViewById(R.id.glf7_tv_functional_light_coming_home_function_lighting)).setText(R.string.off);
                    return;
                } else {
                    ((TextView) findViewById(R.id.glf7_tv_functional_light_coming_home_function_lighting)).setText(String.valueOf(switchOn) + "s");
                    return;
                }
            }
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_light_coming_home_function), true);
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
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_light_leaving_home_function), enable != 0);
            if (switchOn > -1 && switchOn < 31) {
                if (switchOn == 0) {
                    ((TextView) findViewById(R.id.glf7_tv_functional_light_leaving_home_function_lighting)).setText(R.string.off);
                    return;
                } else {
                    ((TextView) findViewById(R.id.glf7_tv_functional_light_leaving_home_function_lighting)).setText(String.valueOf(switchOn) + "s");
                    return;
                }
            }
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_light_leaving_home_function), true);
        if (value > -1 && value < 31) {
            if (value == 0) {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_leaving_home_function_lighting)).setText(R.string.off);
            } else {
                ((TextView) findViewById(R.id.glf7_tv_functional_light_leaving_home_function_lighting)).setText(String.valueOf(value) + "s");
            }
        }
    }
}
