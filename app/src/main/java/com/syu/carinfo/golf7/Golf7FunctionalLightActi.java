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
public class Golf7FunctionalLightActi extends BaseActivity {
    int cartype = 1;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 139:
                    Golf7FunctionalLightActi.this.mUpdaterSwitchOnTime();
                    break;
                case 140:
                    Golf7FunctionalLightActi.this.mUpdaterAutoRain();
                    break;
                case 141:
                    Golf7FunctionalLightActi.this.mUpdaterLaneChange();
                    break;
                case 142:
                    Golf7FunctionalLightActi.this.mUpdaterTravelMode();
                    break;
                case 143:
                    Golf7FunctionalLightActi.this.mUpdaterInstrument();
                    break;
                case 144:
                    Golf7FunctionalLightActi.this.mUpdaterDoorLight();
                    break;
                case 145:
                    Golf7FunctionalLightActi.this.mUpdaterFootLight();
                    break;
                case 146:
                    Golf7FunctionalLightActi.this.mUpdaterComeHome();
                    break;
                case 147:
                    Golf7FunctionalLightActi.this.mUpdaterLeaveHome();
                    break;
                case 175:
                    Golf7FunctionalLightActi.this.mUpdaterDayTimeRuningLights();
                    break;
                case 202:
                    Golf7FunctionalLightActi.this.mUpdaterlightcolor();
                    break;
                case 203:
                    Golf7FunctionalLightActi.this.mUpdaterlightfan();
                    break;
                case 204:
                    Golf7FunctionalLightActi.this.mUpdaterlightright();
                    break;
                case 205:
                    Golf7FunctionalLightActi.this.mUpdaterLightassist();
                    break;
                case 206:
                    Golf7FunctionalLightActi.this.mUpdaterLightbend();
                    break;
                case 207:
                    Golf7FunctionalLightActi.this.mUpdaterLightall();
                    break;
                case 213:
                    Golf7FunctionalLightActi.this.mUpdaterBackbright();
                    break;
                case 214:
                    Golf7FunctionalLightActi.this.mUpdaterBackcontrast();
                    break;
                case 215:
                    Golf7FunctionalLightActi.this.mUpdaterBacksrturation();
                    break;
                case 277:
                    Golf7FunctionalLightActi.this.mUpdaterLightDistance();
                    break;
                case 287:
                    Golf7FunctionalLightActi.this.updateChangeBright();
                    break;
                case 296:
                    Golf7FunctionalLightActi.this.mUpdaterAllbrightness();
                    break;
                case 331:
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
                case 363:
                case 364:
                    int onoff = DataCanbus.DATA[363];
                    int coclor = DataCanbus.DATA[364];
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
                case 377:
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
                        } else if (value == 4) {
                            ((TextView) Golf7FunctionalLightActi.this.findViewById(R.id.tv_text2)).setText("type4");
                            break;
                        }
                    }
                    break;
                case 387:
                    if (((TextView) Golf7FunctionalLightActi.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) Golf7FunctionalLightActi.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "%");
                        break;
                    }
                case 391:
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
                case 392:
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
                case 393:
                    if (((TextView) Golf7FunctionalLightActi.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) Golf7FunctionalLightActi.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 394:
                    if (((TextView) Golf7FunctionalLightActi.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) Golf7FunctionalLightActi.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            //setContentView(R.layout.layout_golf7_functional_state_light_od);
        } else {
            //setContentView(R.layout.layout_golf7_functional_state_light);
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
                        intent.setClass(Golf7FunctionalLightActi.this, Golf7FunctionalActiOD.class);
                        Golf7FunctionalLightActi.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_daytime_light), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[175] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(13, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_automatic_headlight_control_rain), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[140] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(59, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_dynamic), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[205] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 1;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(105, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_follower), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[206] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 2;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(105, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_color_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn;
                int switchOn2 = DataCanbus.DATA[202] & 255;
                if (switchOn2 > 0) {
                    switchOn = switchOn2 - 1;
                } else {
                    switchOn = 3;
                }
                DataCanbus.PROXY.cmd(105, new int[]{12, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_color_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn;
                int switchOn2 = DataCanbus.DATA[202] & 255;
                if (switchOn2 < 3) {
                    switchOn = switchOn2 + 1;
                } else {
                    switchOn = 0;
                }
                DataCanbus.PROXY.cmd(105, new int[]{12, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_10color_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[202] & 255;
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
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_10color_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[202] & 255;
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
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_30color_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn;
                int switchOn2 = DataCanbus.DATA[202] & 255;
                if (switchOn2 > 4) {
                    switchOn = switchOn2 - 1;
                } else {
                    switchOn = 33;
                }
                DataCanbus.PROXY.cmd(105, new int[]{12, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_30color_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn;
                int switchOn2 = DataCanbus.DATA[202] & 255;
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
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_fan_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[203] & 255) - 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(105, new int[]{13, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_fan_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[203] & 255) + 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(105, new int[]{13, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_right_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[204] & 255) - 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(105, new int[]{14, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_right_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[204] & 255) + 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(105, new int[]{14, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.wc_btn_alllight_brightness_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[296] & 255) - 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(105, new int[]{15, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.wc_btn_alllight_brightness_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[296] & 255) + 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(105, new int[]{15, switchOn}, null, null);
            }
        });
        if (ConstGolf.isRZCGolf()) {
            setSelfClick((Button) findViewById(R.id.btn_minus1), new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int switchOn = (DataCanbus.DATA[331] & 255) - 1;
                    if (switchOn < 0) {
                        switchOn = 0;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{74, switchOn}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_plus1), new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int switchOn = (DataCanbus.DATA[331] & 255) + 1;
                    if (switchOn > 2) {
                        switchOn = 2;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{74, switchOn}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_minus2), new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int cartype = (DataCanbus.DATA[377] & 255) - 1;
                    if (cartype < 1) {
                        cartype = 4;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{75, cartype}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_plus2), new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int cartype = (DataCanbus.DATA[377] & 255) + 1;
                    if (cartype > 4) {
                        cartype = 1;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{75, cartype}, null, null);
                }
            });
            setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int switchOn = DataCanbus.DATA[363] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 76;
                    iArr[1] = switchOn == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(160, iArr, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_minus3), new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int switchOn = DataCanbus.DATA[364] & 255;
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
            setSelfClick((Button) findViewById(R.id.btn_plus3), new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int switchOn = DataCanbus.DATA[364] & 255;
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
            setSelfClick((Button) findViewById(R.id.btn_minus4), new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int switchOn = (DataCanbus.DATA[387] & 255) - 10;
                    if (switchOn < 0) {
                        switchOn = 0;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{77, switchOn}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_plus4), new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int switchOn = (DataCanbus.DATA[387] & 255) + 10;
                    if (switchOn > 100) {
                        switchOn = 100;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{77, switchOn}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_minus5), new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int switchOn = (DataCanbus.DATA[391] & 255) - 1;
                    if (switchOn < 0) {
                        switchOn = 0;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{79, switchOn}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_plus5), new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int switchOn = (DataCanbus.DATA[391] & 255) + 1;
                    if (switchOn > 1) {
                        switchOn = 1;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{79, switchOn}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_minus6), new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int switchOn = (DataCanbus.DATA[392] & 255) - 1;
                    if (switchOn == 2) {
                        switchOn = 1;
                    } else if (switchOn < 1) {
                        switchOn = 8;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{101, switchOn}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_plus6), new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int switchOn = (DataCanbus.DATA[392] & 255) + 1;
                    if (switchOn > 8) {
                        switchOn = 1;
                    } else if (switchOn == 2) {
                        switchOn = 3;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{101, switchOn}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_minus7), new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int switchOn = (DataCanbus.DATA[393] & 255) - 1;
                    if (switchOn < 1) {
                        switchOn = 1;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{78, switchOn & 127}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_plus7), new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int switchOn = (DataCanbus.DATA[393] & 255) + 1;
                    if (switchOn > 10) {
                        switchOn = 10;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{78, switchOn & 127}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_minus8), new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int switchOn = (DataCanbus.DATA[394] & 255) - 1;
                    if (switchOn < 1) {
                        switchOn = 1;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{78, switchOn | 128}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_plus8), new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    int switchOn = (DataCanbus.DATA[394] & 255) + 1;
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
            if (DataCanbus.DATA[1000] == 3342496 || DataCanbus.DATA[1000] == 3735712) {
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
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_all_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[207] & 255) - 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(105, new int[]{15, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_all_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[207] & 255) + 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(105, new int[]{15, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_switch_on_time_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[139] & 255;
                if (switchOn == 2) {
                    DataCanbus.PROXY.cmd(58, new int[]{1}, null, null);
                } else if (switchOn == 1) {
                    DataCanbus.PROXY.cmd(58, new int[1], null, null);
                } else {
                    DataCanbus.PROXY.cmd(58, new int[]{2}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_light_switch_on_time_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[139] & 255;
                if (switchOn == 0) {
                    DataCanbus.PROXY.cmd(58, new int[]{1}, null, null);
                } else if (switchOn == 1) {
                    DataCanbus.PROXY.cmd(58, new int[]{2}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(58, new int[1], null, null);
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_lane_change_flash), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[141] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(60, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_travel_mode), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[142] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(61, iArr, null, null);
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
                DataCanbus.PROXY.cmd(62, new int[]{switchOn}, null, null);
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
                DataCanbus.PROXY.cmd(62, new int[]{switchOn}, null, null);
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
                DataCanbus.PROXY.cmd(63, new int[]{switchOn}, null, null);
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
                DataCanbus.PROXY.cmd(63, new int[]{switchOn}, null, null);
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
                DataCanbus.PROXY.cmd(64, new int[]{switchOn}, null, null);
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
                DataCanbus.PROXY.cmd(64, new int[]{switchOn}, null, null);
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
                DataCanbus.PROXY.cmd(65, new int[]{switchOn}, null, null);
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
                DataCanbus.PROXY.cmd(65, new int[]{switchOn}, null, null);
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
                DataCanbus.PROXY.cmd(66, new int[]{switchOn}, null, null);
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
                DataCanbus.PROXY.cmd(66, new int[]{switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_back_bright_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[213] & 255) - 10;
                if (switchOn < 30) {
                    switchOn = 30;
                } else if (switchOn > 70) {
                    switchOn = 70;
                }
                DataCanbus.PROXY.cmd(105, new int[]{32, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_back_bright_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[213] & 255) + 10;
                if (switchOn < 30) {
                    switchOn = 30;
                } else if (switchOn > 70) {
                    switchOn = 70;
                }
                DataCanbus.PROXY.cmd(105, new int[]{32, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_back_contrast_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[214] & 255) - 10;
                if (switchOn < 30) {
                    switchOn = 30;
                } else if (switchOn > 70) {
                    switchOn = 70;
                }
                DataCanbus.PROXY.cmd(105, new int[]{33, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_back_contrast_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[214] & 255) + 10;
                if (switchOn < 30) {
                    switchOn = 30;
                } else if (switchOn > 70) {
                    switchOn = 70;
                }
                DataCanbus.PROXY.cmd(105, new int[]{33, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_back_saturation_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[215] & 255) - 10;
                if (switchOn < 30) {
                    switchOn = 30;
                } else if (switchOn > 70) {
                    switchOn = 70;
                }
                DataCanbus.PROXY.cmd(105, new int[]{34, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_back_saturation_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[215] & 255) + 10;
                if (switchOn < 30) {
                    switchOn = 30;
                } else if (switchOn > 70) {
                    switchOn = 70;
                }
                DataCanbus.PROXY.cmd(105, new int[]{34, switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_light_distance_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[277] & 255) - 1;
                if (switchOn < 0) {
                    switchOn = 0;
                }
                DataCanbus.PROXY.cmd(133, new int[]{switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_light_distance_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[277] & 255) + 1;
                if (switchOn > 6) {
                    switchOn = 6;
                }
                DataCanbus.PROXY.cmd(133, new int[]{switchOn}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.wc_btn_change_bright_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[287] & 255;
                if (value2 <= 1) {
                    value = 1;
                } else {
                    value = value2 - 1;
                }
                DataCanbus.PROXY.cmd(135, new int[]{value}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.wc_btn_change_bright_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[287] & 255;
                if (value2 >= 5) {
                    value = 5;
                } else {
                    value = value2 + 1;
                }
                DataCanbus.PROXY.cmd(135, new int[]{value}, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[377].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[202].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[203].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[204].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[205].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[206].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[207].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[213].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[214].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[215].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[277].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[287].addNotify(this.mNotifyCanbus, 1);
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            DataCanbus.NOTIFY_EVENTS[296].addNotify(this.mNotifyCanbus, 1);
        }
        if (ConstGolf.isRZCGolf()) {
            DataCanbus.NOTIFY_EVENTS[331].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[363].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[364].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[387].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[391].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[392].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[393].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[394].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[377].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[202].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[203].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[204].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[205].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[206].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[207].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[213].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[214].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[215].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[277].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[287].removeNotify(this.mNotifyCanbus);
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            DataCanbus.NOTIFY_EVENTS[296].removeNotify(this.mNotifyCanbus);
        }
        if (ConstGolf.isRZCGolf()) {
            DataCanbus.NOTIFY_EVENTS[331].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[363].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[364].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[387].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[391].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[392].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[393].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[394].removeNotify(this.mNotifyCanbus);
        }
    }

    
    public void mUpdaterBackbright() {
        int value = DataCanbus.DATA[213] & 255;
        if (DataCanbus.DATA[1000] == 437) {
            setViewVisible(findViewById(R.id.glf7_view_back_bright), true);
            ((TextView) findViewById(R.id.glf7_tv_back_bright)).setText(new StringBuilder().append(value).toString());
        } else {
            setViewVisible(findViewById(R.id.glf7_view_back_bright), false);
        }
    }

    
    public void mUpdaterBackcontrast() {
        int value = DataCanbus.DATA[214] & 255;
        if (DataCanbus.DATA[1000] == 437) {
            setViewVisible(findViewById(R.id.glf7_view_back_contrast), true);
            ((TextView) findViewById(R.id.glf7_tv_back_contrast)).setText(new StringBuilder().append(value).toString());
        } else {
            setViewVisible(findViewById(R.id.glf7_view_back_contrast), false);
        }
    }

    
    public void mUpdaterBacksrturation() {
        int value = DataCanbus.DATA[215] & 255;
        if (DataCanbus.DATA[1000] == 437) {
            setViewVisible(findViewById(R.id.glf7_view_back_saturation), true);
            ((TextView) findViewById(R.id.glf7_tv_back_saturation)).setText(new StringBuilder().append(value).toString());
        } else {
            setViewVisible(findViewById(R.id.glf7_view_back_saturation), false);
        }
    }

    
    public void mUpdaterLightDistance() {
        int value = DataCanbus.DATA[277];
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

    
    public void updateChangeBright() {
        int value = DataCanbus.DATA[287];
        int enable = (65280 & value) >> 8;
        int switchOn = value & 255;
        if (ConstGolf.isWcGolf()) {
            setViewVisible(findViewById(R.id.glf7_view_brightness), enable != 0);
            ((TextView) findViewById(R.id.wc_tv_change_bright)).setText(new StringBuilder().append(switchOn).toString());
        } else {
            setViewVisible(findViewById(R.id.glf7_view_brightness), false);
        }
    }

    
    public void mUpdaterDayTimeRuningLights() {
        int value = DataCanbus.DATA[175];
        int enable = (65280 & value) >> 8;
        int switchOn = value & 255;
        if (ConstGolf.isWcGolf()) {
            setViewVisible(findViewById(R.id.glf7_view_functional_light_daytime_light), enable != 0);
        } else {
            setViewVisible(findViewById(R.id.glf7_view_functional_light_daytime_light), true);
        }
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_daytime_light), switchOn != 0);
    }

    
    public void mUpdaterlightcolor() {
        int value = DataCanbus.DATA[202];
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
        if (DataCanbus.DATA[1000] != 3342496 || DataCanbus.DATA[1000] == 3735712) {
            setViewVisible(findViewById(R.id.glf7_view_functional_light_color_10), true);
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_light_30color), false);
    }

    
    public void mUpdaterlightfan() {
        int value = DataCanbus.DATA[203];
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

    
    public void mUpdaterlightright() {
        int value = DataCanbus.DATA[204];
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

    
    public void mUpdaterLightall() {
        int value = DataCanbus.DATA[207];
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

    
    public void mUpdaterLightassist() {
        int value = DataCanbus.DATA[205];
        int enable = (65280 & value) >> 8;
        int switchOn = value & 255;
        if (ConstGolf.isWcGolf()) {
            setViewVisible(findViewById(R.id.glf7_view_functional_light_dynamic), enable != 0);
        } else {
            setViewVisible(findViewById(R.id.glf7_view_functional_light_dynamic), true);
        }
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_dynamic), switchOn != 0);
    }

    
    public void mUpdaterLightbend() {
        int value = DataCanbus.DATA[206];
        int enable = (65280 & value) >> 8;
        int switchOn = value & 255;
        if (ConstGolf.isWcGolf()) {
            setViewVisible(findViewById(R.id.glf7_view_functional_light_follower), enable != 0);
        } else {
            setViewVisible(findViewById(R.id.glf7_view_functional_light_follower), true);
        }
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_follower), switchOn != 0);
    }

    
    public void mUpdaterAutoRain() {
        int value = DataCanbus.DATA[140];
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

    
    public void mUpdaterSwitchOnTime() {
        int value = DataCanbus.DATA[139];
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

    
    public void mUpdaterAllbrightness() {
        int value = DataCanbus.DATA[296];
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

    
    public void mUpdaterLaneChange() {
        int value = DataCanbus.DATA[141];
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

    
    public void mUpdaterTravelMode() {
        int i = R.string.travel_mode_left_hand_traffic;
        int value = DataCanbus.DATA[142];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_light_travel_mode), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_travel_mode), switchOn != 0);
            ((TextView) findViewById(R.id.glf7_tv_functional_light_travel_mode)).setText(switchOn == 0 ? 2131296460 : 2131296459);
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_light_travel_mode), true);
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_light_travel_mode), value != 0);
        TextView textView = (TextView) findViewById(R.id.glf7_tv_functional_light_travel_mode);
        if (value == 0) {
            i = 2131296459;
        }
        textView.setText(i);
    }

    
    public void mUpdaterInstrument() {
        int value = DataCanbus.DATA[143];
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

    
    public void mUpdaterDoorLight() {
        int value = DataCanbus.DATA[144];
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

    
    public void mUpdaterFootLight() {
        int value = DataCanbus.DATA[145];
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

    
    public void mUpdaterComeHome() {
        int value = DataCanbus.DATA[146];
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

    
    public void mUpdaterLeaveHome() {
        int value = DataCanbus.DATA[147];
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
