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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Golf7FunctionalDriverAssistanceActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 126:
                    Golf7FunctionalDriverAssistanceActi.this.mUpdaterDriverSystem();
                    break;
                case 127:
                    Golf7FunctionalDriverAssistanceActi.this.mUpdaterLastDistance();
                    break;
                case 128:
                    Golf7FunctionalDriverAssistanceActi.this.mUpdaterDistance();
                    break;
                case 129:
                    Golf7FunctionalDriverAssistanceActi.this.mUpdaterFrontAssist();
                    break;
                case 130:
                    Golf7FunctionalDriverAssistanceActi.this.mUpdaterAdvanceWarning();
                    break;
                case 131:
                    Golf7FunctionalDriverAssistanceActi.this.mUpdaterDisplayDistanceWarning();
                    break;
                case 132:
                    Golf7FunctionalDriverAssistanceActi.this.mUpdaterDisplayLaneAssist();
                    break;
                case 133:
                    Golf7FunctionalDriverAssistanceActi.this.mUpdaterTrafficeSignRecognition();
                    break;
                case 134:
                    Golf7FunctionalDriverAssistanceActi.this.mUpdaterDriverAlertSystem();
                    break;
                case 135:
                    Golf7FunctionalDriverAssistanceActi.this.mUpdaterProactiveOccupationProtection();
                    break;
                case 245:
                    Golf7FunctionalDriverAssistanceActi.this.updateBlindDetect();
                    break;
                case 270:
                    Golf7FunctionalDriverAssistanceActi.this.mUpdaterProTectMemberSys();
                    break;
                case 272:
                    Golf7FunctionalDriverAssistanceActi.this.mUpdaterDisplayLaneAssist_JH();
                    break;
                case 286:
                    Golf7FunctionalDriverAssistanceActi.this.updateChangeAids();
                    break;
                case 287:
                    Golf7FunctionalDriverAssistanceActi.this.updateChangeBright();
                    break;
                case 323:
                    Golf7FunctionalDriverAssistanceActi.this.setCheck((CheckedTextView) Golf7FunctionalDriverAssistanceActi.this.findViewById(R.id.ctv_checkedtext1), value != 0);
                    break;
                case 324:
                    int strid = R.string.off;
                    if (((TextView) Golf7FunctionalDriverAssistanceActi.this.findViewById(R.id.tv_text1)) != null) {
                        if (value == 3) {
                            strid = R.string.switch_on_time_early;
                        } else if (value == 2) {
                            strid = R.string.switch_on_time_medium;
                        } else if (value == 1) {
                            strid = R.string.switch_on_time_late;
                        }
                        ((TextView) Golf7FunctionalDriverAssistanceActi.this.findViewById(R.id.tv_text1)).setText(strid);
                    }
                    break;
                case 325:
                    Golf7FunctionalDriverAssistanceActi.this.setCheck((CheckedTextView) Golf7FunctionalDriverAssistanceActi.this.findViewById(R.id.ctv_checkedtext2), value != 0);
                    break;
                case 326:
                    Golf7FunctionalDriverAssistanceActi.this.setCheck((CheckedTextView) Golf7FunctionalDriverAssistanceActi.this.findViewById(R.id.ctv_checkedtext3), value != 0);
                    break;
                case 356:
                    Golf7FunctionalDriverAssistanceActi.this.setCheck((CheckedTextView) Golf7FunctionalDriverAssistanceActi.this.findViewById(R.id.ctv_checkedtext4), value != 0);
                    break;
                case 357:
                    if (((TextView) Golf7FunctionalDriverAssistanceActi.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) Golf7FunctionalDriverAssistanceActi.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 487:
                    Golf7FunctionalDriverAssistanceActi.this.setCheck((CheckedTextView) Golf7FunctionalDriverAssistanceActi.this.findViewById(R.id.ctv_checkedtext5), value != 0);
                    break;
                case 488:
                    int strid2 = R.string.klc_air_low;
                    if (((TextView) Golf7FunctionalDriverAssistanceActi.this.findViewById(R.id.tv_text3)) != null) {
                        if (value == 2) {
                            strid2 = R.string.klc_air_high;
                        } else if (value == 1) {
                            strid2 = R.string.klc_air_middle;
                        }
                        ((TextView) Golf7FunctionalDriverAssistanceActi.this.findViewById(R.id.tv_text3)).setText(strid2);
                    }
                    break;
                case 489:
                    Golf7FunctionalDriverAssistanceActi.this.setCheck((CheckedTextView) Golf7FunctionalDriverAssistanceActi.this.findViewById(R.id.ctv_checkedtext6), value != 0);
                    break;
                case 490:
                    int strid3 = R.string.klc_air_low;
                    if (((TextView) Golf7FunctionalDriverAssistanceActi.this.findViewById(R.id.tv_text4)) != null) {
                        if (value == 2) {
                            strid3 = R.string.klc_air_high;
                        } else if (value == 1) {
                            strid3 = R.string.klc_air_middle;
                        }
                        ((TextView) Golf7FunctionalDriverAssistanceActi.this.findViewById(R.id.tv_text4)).setText(strid3);
                    }
                    break;
                case 491:
                    Golf7FunctionalDriverAssistanceActi.this.setCheck((CheckedTextView) Golf7FunctionalDriverAssistanceActi.this.findViewById(R.id.ctv_checkedtext7), value != 0);
                    break;
                case 492:
                    Golf7FunctionalDriverAssistanceActi.this.setCheck((CheckedTextView) Golf7FunctionalDriverAssistanceActi.this.findViewById(R.id.ctv_checkedtext8), value != 0);
                    break;
                case 493:
                    Golf7FunctionalDriverAssistanceActi.this.setCheck((CheckedTextView) Golf7FunctionalDriverAssistanceActi.this.findViewById(R.id.ctv_checkedtext9), value != 0);
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
            setContentView(R.layout.layout_golf7_functional_state_driver_assistance_od);
        } else {
            setContentView(R.layout.layout_golf7_functional_state_driver_assistance);
        }
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        if (DataCanbus.DATA[1000] == 393256) {
            setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_distance), true);
        } else {
            setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_distance), false);
        }
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            setSelfClick((Button) findViewById(R.id.glf7_btn_car_back_od), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(Golf7FunctionalDriverAssistanceActi.this, Golf7FunctionalActiOD.class);
                        Golf7FunctionalDriverAssistanceActi.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_front_assist), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[129] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(48, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_advance_warning), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[130] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(49, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_display_distance_warning), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[131] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(50, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_display_lane_Assist), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[132] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(51, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_display_lane_Assist_JH), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[272] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(120, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_traffice_sign_recognition), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[133] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(52, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_driver_alert_system), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[134] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(53, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_proactive_occupation_protection), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[135] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(54, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_driver_assistance_driver_system_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[126] & 255;
                if (DataCanbus.DATA[1000] == 17 || DataCanbus.DATA[1000] == 65553 || DataCanbus.DATA[1000] == 131089 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769 || DataCanbus.DATA[1000] == 524305) {
                    if (mValue == 2) {
                        DataCanbus.PROXY.cmd(56, new int[]{1}, null, null);
                        return;
                    } else if (mValue == 1) {
                        DataCanbus.PROXY.cmd(56, new int[1], null, null);
                        return;
                    } else {
                        if (mValue == 0) {
                            DataCanbus.PROXY.cmd(56, new int[]{2}, null, null);
                            return;
                        }
                        return;
                    }
                }
                if (mValue == 1) {
                    DataCanbus.PROXY.cmd(56, new int[1], null, null);
                    return;
                }
                if (mValue == 0) {
                    DataCanbus.PROXY.cmd(56, new int[]{3}, null, null);
                } else if (mValue == 3) {
                    DataCanbus.PROXY.cmd(56, new int[]{2}, null, null);
                } else if (mValue == 2) {
                    DataCanbus.PROXY.cmd(56, new int[]{1}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_driver_assistance_driver_system_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[126] & 255;
                if (DataCanbus.DATA[1000] == 17 || DataCanbus.DATA[1000] == 65553 || DataCanbus.DATA[1000] == 131089 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769 || DataCanbus.DATA[1000] == 524305) {
                    if (mValue == 0) {
                        DataCanbus.PROXY.cmd(56, new int[]{1}, null, null);
                        return;
                    } else if (mValue == 1) {
                        DataCanbus.PROXY.cmd(56, new int[]{2}, null, null);
                        return;
                    } else {
                        if (mValue == 2) {
                            DataCanbus.PROXY.cmd(56, new int[1], null, null);
                            return;
                        }
                        return;
                    }
                }
                if (mValue == 1) {
                    DataCanbus.PROXY.cmd(56, new int[]{2}, null, null);
                    return;
                }
                if (mValue == 2) {
                    DataCanbus.PROXY.cmd(56, new int[]{3}, null, null);
                } else if (mValue == 3) {
                    DataCanbus.PROXY.cmd(56, new int[1], null, null);
                } else {
                    DataCanbus.PROXY.cmd(56, new int[]{1}, null, null);
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_last_distance_selected), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[127] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(57, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_driver_assistance_distance_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = (DataCanbus.DATA[128] & 255) - 1;
                if (mValue < 0) {
                    DataCanbus.PROXY.cmd(55, new int[]{4}, null, null);
                } else if (mValue > 4) {
                    DataCanbus.PROXY.cmd(55, new int[1], null, null);
                } else {
                    DataCanbus.PROXY.cmd(55, new int[]{mValue}, null, null);
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_driver_assistance_distance_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int mValue = (DataCanbus.DATA[128] & 255) + 1;
                if (mValue < 0) {
                    DataCanbus.PROXY.cmd(55, new int[]{4}, null, null);
                } else if (mValue > 4) {
                    DataCanbus.PROXY.cmd(55, new int[1], null, null);
                } else {
                    DataCanbus.PROXY.cmd(55, new int[]{mValue}, null, null);
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_17_blind_detect), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[245] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = switchOn != 0 ? 0 : 1;
                remoteModuleProxy.cmd(112, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_view_functional_tuguanl_warning_m), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[130] & 255;
                if (value2 == 0) {
                    value = 0;
                } else {
                    value = value2 - 1;
                }
                DataCanbus.PROXY.cmd(49, new int[]{value}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_view_functional_tuguanl_warning_p), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[130] & 255;
                if (value2 == 3) {
                    value = 3;
                } else {
                    value = value2 + 1;
                }
                DataCanbus.PROXY.cmd(49, new int[]{value}, null, null);
            }
        });
        if (ConstGolf.isRZCGolf()) {
            setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.19
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value = DataCanbus.DATA[323] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 48;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(160, iArr, null, null);
                }
            });
            findViewById(R.id.layout_view2).setVisibility(0);
            findViewById(R.id.layout_view3).setVisibility(0);
            findViewById(R.id.layout_view4).setVisibility(0);
            findViewById(R.id.layout_view5).setVisibility(0);
            findViewById(R.id.layout_view6).setVisibility(0);
            findViewById(R.id.layout_view7).setVisibility(0);
            findViewById(R.id.layout_view8).setVisibility(0);
            findViewById(R.id.layout_view9).setVisibility(0);
            findViewById(R.id.layout_view10).setVisibility(0);
            findViewById(R.id.layout_view11).setVisibility(0);
            findViewById(R.id.layout_view12).setVisibility(0);
            findViewById(R.id.layout_view13).setVisibility(0);
            setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.20
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value = DataCanbus.DATA[325] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 61;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(160, iArr, null, null);
                }
            });
            setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.21
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value = DataCanbus.DATA[326] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 57;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(160, iArr, null, null);
                }
            });
            setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.22
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value = DataCanbus.DATA[356] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 62;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(160, iArr, null, null);
                }
            });
            setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.23
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value = DataCanbus.DATA[487] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 123;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(160, iArr, null, null);
                }
            });
            setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.24
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value = DataCanbus.DATA[489] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 125;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(160, iArr, null, null);
                }
            });
            setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.25
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value = DataCanbus.DATA[491] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 127;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(160, iArr, null, null);
                }
            });
            setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.26
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value = DataCanbus.DATA[492] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 45;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(160, iArr, null, null);
                }
            });
            setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.27
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value = DataCanbus.DATA[493] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 47;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(160, iArr, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_minus1), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.28
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value = (DataCanbus.DATA[324] & 255) - 1;
                    if (value <= 0) {
                        value = 0;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{60, value}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_plus1), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.29
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value = (DataCanbus.DATA[324] & 255) + 1;
                    if (value >= 3) {
                        value = 3;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{60, value}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_minus2), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.30
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value = (DataCanbus.DATA[357] & 255) - 1;
                    if (value <= 0) {
                        value = 0;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{63, value}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_plus2), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.31
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value = (DataCanbus.DATA[357] & 255) + 1;
                    if (value >= 4) {
                        value = 4;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{63, value}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_minus3), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.32
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value = (DataCanbus.DATA[488] & 255) - 1;
                    if (value <= 0) {
                        value = 0;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{124, value}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_plus3), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.33
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value = (DataCanbus.DATA[488] & 255) + 1;
                    if (value >= 2) {
                        value = 2;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{124, value}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_minus3), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.34
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value = (DataCanbus.DATA[490] & 255) - 1;
                    if (value <= 0) {
                        value = 0;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{126, value}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_plus3), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.35
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value = (DataCanbus.DATA[490] & 255) + 1;
                    if (value >= 2) {
                        value = 2;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{126, value}, null, null);
                }
            });
        } else {
            findViewById(R.id.layout_view2).setVisibility(8);
            findViewById(R.id.layout_view3).setVisibility(8);
            findViewById(R.id.layout_view4).setVisibility(8);
            findViewById(R.id.layout_view5).setVisibility(8);
            findViewById(R.id.layout_view6).setVisibility(8);
            findViewById(R.id.layout_view7).setVisibility(8);
            findViewById(R.id.layout_view8).setVisibility(8);
            findViewById(R.id.layout_view9).setVisibility(8);
            findViewById(R.id.layout_view10).setVisibility(8);
            findViewById(R.id.layout_view11).setVisibility(8);
            findViewById(R.id.layout_view12).setVisibility(8);
            findViewById(R.id.layout_view13).setVisibility(8);
        }
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_protect_member), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.36
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[270] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(118, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_tuan_change_aids), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.37
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[286] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value == 0 ? 0 : 1;
                remoteModuleProxy.cmd(134, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.tuan_btn_change_bright_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.38
            @Override // android.view.View.OnClickListener
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
        setSelfClick((Button) findViewById(R.id.tuan_btn_change_bright_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDriverAssistanceActi.39
            @Override // android.view.View.OnClickListener
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (findViewById(R.id.glf7_view_tuan_change) != null) {
            if (DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 589841 || DataCanbus.DATA[1000] == 720913 || DataCanbus.DATA[1000] == 655377 || DataCanbus.DATA[1000] == 786449 || DataCanbus.DATA[1000] == 851985 || DataCanbus.DATA[1000] == 917521 || DataCanbus.DATA[1000] == 983057 || DataCanbus.DATA[1000] == 1048593 || DataCanbus.DATA[1000] == 1114129 || DataCanbus.DATA[1000] == 1179665 || DataCanbus.DATA[1000] == 1245201 || DataCanbus.DATA[1000] == 1310737 || DataCanbus.DATA[1000] == 1376273 || DataCanbus.DATA[1000] == 1441809 || DataCanbus.DATA[1000] == 1507345 || DataCanbus.DATA[1000] == 1572881 || DataCanbus.DATA[1000] == 1638417 || DataCanbus.DATA[1000] == 1703953 || DataCanbus.DATA[1000] == 1769489 || DataCanbus.DATA[1000] == 1835025 || DataCanbus.DATA[1000] == 1900561 || DataCanbus.DATA[1000] == 1966097 || DataCanbus.DATA[1000] == 2031633 || DataCanbus.DATA[1000] == 2097169 || DataCanbus.DATA[1000] == 2162705 || DataCanbus.DATA[1000] == 2228241 || DataCanbus.DATA[1000] == 2293777 || DataCanbus.DATA[1000] == 2359313 || DataCanbus.DATA[1000] == 2424849 || DataCanbus.DATA[1000] == 2490385 || DataCanbus.DATA[1000] == 2555921 || DataCanbus.DATA[1000] == 2621457 || DataCanbus.DATA[1000] == 2686993 || DataCanbus.DATA[1000] == 2752529 || DataCanbus.DATA[1000] == 2818065) {
                findViewById(R.id.glf7_view_tuan_change).setVisibility(0);
            } else {
                findViewById(R.id.glf7_view_tuan_change).setVisibility(8);
            }
        }
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        if (DataCanbus.DATA[1000] == 589841 || DataCanbus.DATA[1000] == 720913 || DataCanbus.DATA[1000] == 655377 || DataCanbus.DATA[1000] == 786449 || DataCanbus.DATA[1000] == 851985 || DataCanbus.DATA[1000] == 917521 || DataCanbus.DATA[1000] == 983057 || DataCanbus.DATA[1000] == 1048593 || DataCanbus.DATA[1000] == 1114129 || DataCanbus.DATA[1000] == 1179665 || DataCanbus.DATA[1000] == 1245201 || DataCanbus.DATA[1000] == 1310737 || DataCanbus.DATA[1000] == 1376273 || DataCanbus.DATA[1000] == 1441809 || DataCanbus.DATA[1000] == 1507345 || DataCanbus.DATA[1000] == 1572881 || DataCanbus.DATA[1000] == 1638417 || DataCanbus.DATA[1000] == 1703953 || DataCanbus.DATA[1000] == 1769489 || DataCanbus.DATA[1000] == 1835025 || DataCanbus.DATA[1000] == 1900561 || DataCanbus.DATA[1000] == 1966097 || DataCanbus.DATA[1000] == 2031633 || DataCanbus.DATA[1000] == 2097169 || DataCanbus.DATA[1000] == 2162705 || DataCanbus.DATA[1000] == 2228241 || DataCanbus.DATA[1000] == 2293777 || DataCanbus.DATA[1000] == 2359313 || DataCanbus.DATA[1000] == 2424849 || DataCanbus.DATA[1000] == 2490385 || DataCanbus.DATA[1000] == 2555921 || DataCanbus.DATA[1000] == 2621457 || DataCanbus.DATA[1000] == 2686993 || DataCanbus.DATA[1000] == 2752529 || DataCanbus.DATA[1000] == 2818065) {
            setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_display_lane_Assist_JH), true);
        } else {
            setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_display_lane_Assist_JH), false);
        }
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[272].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[245].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[270].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[286].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[287].addNotify(this.mNotifyCanbus, 1);
        if (ConstGolf.isRZCGolf()) {
            DataCanbus.NOTIFY_EVENTS[323].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[324].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[325].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[326].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[356].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[357].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[487].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[488].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[489].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[490].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[491].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[492].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[493].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[272].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[245].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[270].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[286].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[287].removeNotify(this.mNotifyCanbus);
        if (ConstGolf.isRZCGolf()) {
            DataCanbus.NOTIFY_EVENTS[323].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[324].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[325].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[326].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[356].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[357].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[487].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[488].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[489].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[490].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[491].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[492].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[493].removeNotify(this.mNotifyCanbus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterFrontAssist() {
        int value = DataCanbus.DATA[129];
        int enable = (65280 & value) >> 8;
        int switchOn = value & 255;
        if (ConstGolf.isWcGolf()) {
            setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_front_assist), enable != 0);
        } else {
            setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_advance_warning), value != 0);
            setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_display_distance_warning), value != 0);
            setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_front_assist), true);
        }
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_front_assist), switchOn != 0);
    }

    protected void mUpdaterProTectMemberSys() {
        int value = DataCanbus.DATA[270];
        setViewVisible(findViewById(R.id.glf7_btn_functional_driver_assistance_protect_member_view), DataCanbus.DATA[1000] == 437);
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_protect_member), value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAdvanceWarning() {
        setViewVisible(findViewById(R.id.glf7_view_functional_tuguanl_warning_view), false);
        int value = DataCanbus.DATA[130];
        int enable = (65280 & value) >> 8;
        int switchOn = value & 255;
        if (DataCanbus.DATA[1000] == 196625 || DataCanbus.DATA[1000] == 589841 || DataCanbus.DATA[1000] == 720913 || DataCanbus.DATA[1000] == 655377 || DataCanbus.DATA[1000] == 786449 || DataCanbus.DATA[1000] == 851985 || DataCanbus.DATA[1000] == 917521 || DataCanbus.DATA[1000] == 983057 || DataCanbus.DATA[1000] == 1048593 || DataCanbus.DATA[1000] == 1114129 || DataCanbus.DATA[1000] == 1179665 || DataCanbus.DATA[1000] == 1245201 || DataCanbus.DATA[1000] == 1310737 || DataCanbus.DATA[1000] == 1376273 || DataCanbus.DATA[1000] == 1441809 || DataCanbus.DATA[1000] == 1507345 || DataCanbus.DATA[1000] == 1572881 || DataCanbus.DATA[1000] == 1638417 || DataCanbus.DATA[1000] == 1703953 || DataCanbus.DATA[1000] == 1769489 || DataCanbus.DATA[1000] == 1835025 || DataCanbus.DATA[1000] == 1900561 || DataCanbus.DATA[1000] == 1966097 || DataCanbus.DATA[1000] == 2031633 || DataCanbus.DATA[1000] == 2097169 || DataCanbus.DATA[1000] == 2162705 || DataCanbus.DATA[1000] == 2228241 || DataCanbus.DATA[1000] == 2293777 || DataCanbus.DATA[1000] == 2359313 || DataCanbus.DATA[1000] == 2424849 || DataCanbus.DATA[1000] == 2490385 || DataCanbus.DATA[1000] == 2555921 || DataCanbus.DATA[1000] == 2621457 || DataCanbus.DATA[1000] == 2686993 || DataCanbus.DATA[1000] == 2752529 || DataCanbus.DATA[1000] == 2818065) {
            setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_advance_warning), false);
            setViewVisible(findViewById(R.id.glf7_view_functional_tuguanl_warning_view), true);
            int strid = R.string.off;
            if (((TextView) findViewById(R.id.glf7_view_functional_tuguanl_warning_txt)) != null) {
                if (switchOn == 1) {
                    strid = R.string.switch_on_time_early;
                } else if (switchOn == 2) {
                    strid = R.string.switch_on_time_medium;
                } else if (switchOn == 3) {
                    strid = R.string.switch_on_time_late;
                }
                ((TextView) findViewById(R.id.glf7_view_functional_tuguanl_warning_txt)).setText(strid);
            }
        } else if (ConstGolf.isWcGolf()) {
            setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_advance_warning), enable != 0);
        } else {
            setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_advance_warning), true);
        }
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_advance_warning), switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDisplayDistanceWarning() {
        int value = DataCanbus.DATA[131];
        int enable = (65280 & value) >> 8;
        int switchOn = value & 255;
        if (ConstGolf.isWcGolf()) {
            setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_display_distance_warning), enable != 0);
        } else {
            setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_display_distance_warning), true);
        }
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_display_distance_warning), switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDisplayLaneAssist() {
        int value = DataCanbus.DATA[132];
        int enable = (65280 & value) >> 8;
        int switchOn = value & 255;
        if (ConstGolf.isWcGolf()) {
            setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_display_lane_Assist), enable != 0);
        } else if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256) {
            setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_display_lane_Assist), false);
        } else {
            setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_display_lane_Assist), true);
        }
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_display_lane_Assist), switchOn != 0);
        if (ConstGolf.isRZCGolf()) {
            setViewVisible(findViewById(R.id.layout_view1), switchOn != 0);
            setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_display_lane_Assist_JH), false);
        } else {
            setViewVisible(findViewById(R.id.layout_view1), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDisplayLaneAssist_JH() {
        int value = DataCanbus.DATA[272];
        int enable = (65280 & value) >> 8;
        int switchOn = value & 255;
        if (ConstGolf.isWcGolf()) {
            setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_display_lane_Assist_JH), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_display_lane_Assist_JH), switchOn != 0);
        } else {
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_display_lane_Assist_JH), switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTrafficeSignRecognition() {
        int value = DataCanbus.DATA[133];
        int enable = (65280 & value) >> 8;
        int switchOn = value & 255;
        if (ConstGolf.isWcGolf()) {
            setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_traffice_sign_recognition), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_traffice_sign_recognition), switchOn != 0);
        } else {
            setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_traffice_sign_recognition), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDriverAlertSystem() {
        int value = DataCanbus.DATA[134];
        int enable = (65280 & value) >> 8;
        int switchOn = value & 255;
        if (ConstGolf.isWcGolf()) {
            setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_driver_alert_system), enable != 0);
        } else {
            setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_driver_alert_system), true);
        }
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_driver_alert_system), switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterProactiveOccupationProtection() {
        int value = DataCanbus.DATA[135];
        int enable = (65280 & value) >> 8;
        int switchOn = value & 255;
        if (ConstGolf.isWcGolf()) {
            setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_proactive_occupation_protection), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_proactive_occupation_protection), switchOn != 0);
        } else {
            setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_proactive_occupation_protection), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlindDetect() {
        int value = DataCanbus.DATA[245];
        int enable = (65280 & value) >> 8;
        int switchOn = value & 255;
        setViewVisible(findViewById(R.id.layout_17_blind_detect), enable != 0);
        if (DataCanbus.DATA[1000] == 437) {
            setViewVisible(findViewById(R.id.layout_17_blind_detect), true);
        }
        setCheck((CheckedTextView) findViewById(R.id.ctv_17_blind_detect), switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDriverSystem() {
        int value = DataCanbus.DATA[126];
        int enable = (65280 & value) >> 8;
        int switchOn = value & 255;
        if (ConstGolf.isWcGolf()) {
            setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_driver_system), enable != 0);
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.glf7_tv_functional_driver_assistance_driver_system)).setText(R.string.driver_system_economics);
                return;
            } else if (switchOn == 1) {
                ((TextView) findViewById(R.id.glf7_tv_functional_driver_assistance_driver_system)).setText(R.string.driver_system_standard);
                return;
            } else {
                if (switchOn == 2) {
                    ((TextView) findViewById(R.id.glf7_tv_functional_driver_assistance_driver_system)).setText(R.string.driver_system_sports);
                    return;
                }
                return;
            }
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_driver_system), true);
        if (switchOn == 3) {
            ((TextView) findViewById(R.id.glf7_tv_functional_driver_assistance_driver_system)).setText(R.string.driver_system_economics);
            return;
        }
        if (switchOn == 2) {
            ((TextView) findViewById(R.id.glf7_tv_functional_driver_assistance_driver_system)).setText(R.string.driver_system_sports);
        } else if (switchOn == 1) {
            ((TextView) findViewById(R.id.glf7_tv_functional_driver_assistance_driver_system)).setText(R.string.driver_system_standard);
        } else {
            ((TextView) findViewById(R.id.glf7_tv_functional_driver_assistance_driver_system)).setText(R.string.wc_golf_comfort);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLastDistance() {
        boolean z = false;
        int value = DataCanbus.DATA[127];
        int enable = (65280 & value) >> 8;
        int switchOn = value & 255;
        if (ConstGolf.isWcGolf()) {
            setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_last_distance_selected), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_last_distance_selected), switchOn != 0);
            View viewFindViewById = findViewById(R.id.glf7_view_functional_driver_assistance_distance);
            if (enable != 0 && switchOn == 0) {
                z = true;
            }
            setViewVisible(viewFindViewById, z);
            return;
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_last_distance_selected), true);
        setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_distance), value == 0);
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_last_distance_selected), value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDistance() {
        int value = DataCanbus.DATA[128];
        int mValue = value & 255;
        if (((TextView) findViewById(R.id.glf7_tv_functional_driver_assistance_distance)) != null) {
            if (ConstGolf.isWcGolf()) {
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
                    return;
                } else if (mValue == 3) {
                    ((TextView) findViewById(R.id.glf7_tv_functional_driver_assistance_distance)).setText(R.string.distance_far);
                    return;
                } else {
                    if (mValue == 4) {
                        ((TextView) findViewById(R.id.glf7_tv_functional_driver_assistance_distance)).setText(R.string.distance_very_far);
                        return;
                    }
                    return;
                }
            }
            setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_distance), true);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateChangeAids() {
        int value = DataCanbus.DATA[286];
        if (((CheckedTextView) findViewById(R.id.ctv_tuan_change_aids)) != null) {
            setCheck((CheckedTextView) findViewById(R.id.ctv_tuan_change_aids), value == 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateChangeBright() {
        int value = DataCanbus.DATA[287];
        if (((TextView) findViewById(R.id.tuan_tv_change_bright)) != null) {
            ((TextView) findViewById(R.id.tuan_tv_change_bright)).setText(new StringBuilder().append(value).toString());
        }
    }
}
