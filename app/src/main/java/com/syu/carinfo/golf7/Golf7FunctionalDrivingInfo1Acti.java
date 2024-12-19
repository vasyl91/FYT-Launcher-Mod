package com.syu.carinfo.golf7;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
public class Golf7FunctionalDrivingInfo1Acti extends BaseActivity {
    public static Golf7FunctionalDrivingInfo1Acti mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 127:
                    Golf7FunctionalDrivingInfo1Acti.this.mUpdaterCurConsumption();
                    break;
                case 128:
                    Golf7FunctionalDrivingInfo1Acti.this.mUpdaterAverageConsumption();
                    break;
                case 129:
                    Golf7FunctionalDrivingInfo1Acti.this.mUpdaterConvenience();
                    break;
                case 130:
                    Golf7FunctionalDrivingInfo1Acti.this.mUpdaterEcoTips();
                    break;
                case 131:
                    Golf7FunctionalDrivingInfo1Acti.this.mUpdaterTravellingTime();
                    break;
                case 135:
                    Golf7FunctionalDrivingInfo1Acti.this.mUpdaterAcc();
                    break;
                case 196:
                    Golf7FunctionalDrivingInfo1Acti.this.mUpdaterSnow();
                    break;
                case 197:
                    Golf7FunctionalDrivingInfo1Acti.this.mUpdaterOffRoad();
                    break;
                case 198:
                    Golf7FunctionalDrivingInfo1Acti.this.mUpdaterOffRoadPresonal();
                    break;
                case 344:
                    int strid = R.string.str_17_driver_e_mode;
                    if (((TextView) Golf7FunctionalDrivingInfo1Acti.this.findViewById(R.id.tv_text1)) != null) {
                        if (value == 1) {
                            strid = R.string.str_17_driver_hybrid_power_mode;
                        } else if (value == 2) {
                            strid = R.string.str_17_driver_battery_maintain_mode;
                        } else if (value == 3) {
                            strid = R.string.str_17_driver_battery_charge_mode;
                        } else if (value == 5) {
                            strid = R.string.str_17_driver_gte_mode;
                        }
                        ((TextView) Golf7FunctionalDrivingInfo1Acti.this.findViewById(R.id.tv_text1)).setText(strid);
                        break;
                    }
                case 347:
                    int strid2 = R.string.wc_golf_normal;
                    if (((TextView) Golf7FunctionalDrivingInfo1Acti.this.findViewById(R.id.tv_text2)) != null) {
                        if (value == 1) {
                            strid2 = R.string.str_17_off_road;
                        }
                        ((TextView) Golf7FunctionalDrivingInfo1Acti.this.findViewById(R.id.tv_text2)).setText(strid2);
                        break;
                    }
                case 348:
                    int strid3 = R.string.wc_golf_normal;
                    if (((TextView) Golf7FunctionalDrivingInfo1Acti.this.findViewById(R.id.tv_text3)) != null) {
                        if (value == 1) {
                            strid3 = R.string.str_driving_sport;
                        }
                        ((TextView) Golf7FunctionalDrivingInfo1Acti.this.findViewById(R.id.tv_text3)).setText(strid3);
                        break;
                    }
                case 349:
                    int strid4 = R.string.wc_golf_normal;
                    if (((TextView) Golf7FunctionalDrivingInfo1Acti.this.findViewById(R.id.tv_text4)) != null) {
                        if (value == 1) {
                            strid4 = R.string.str_17_off_road;
                        }
                        ((TextView) Golf7FunctionalDrivingInfo1Acti.this.findViewById(R.id.tv_text4)).setText(strid4);
                        break;
                    }
                case 350:
                    int strid5 = R.string.wc_golf_normal;
                    if (((TextView) Golf7FunctionalDrivingInfo1Acti.this.findViewById(R.id.tv_text5)) != null) {
                        if (value == 2) {
                            strid5 = R.string.str_driving_eco;
                        }
                        ((TextView) Golf7FunctionalDrivingInfo1Acti.this.findViewById(R.id.tv_text5)).setText(strid5);
                        break;
                    }
                case 351:
                    Golf7FunctionalDrivingInfo1Acti.this.setCheck((CheckedTextView) Golf7FunctionalDrivingInfo1Acti.this.findViewById(R.id.ctv_checkedtext1), value != 0);
                    break;
                case 352:
                    Golf7FunctionalDrivingInfo1Acti.this.setCheck((CheckedTextView) Golf7FunctionalDrivingInfo1Acti.this.findViewById(R.id.ctv_checkedtext2), value != 0);
                    break;
                case 357:
                    String strid6 = "5A";
                    if (((TextView) Golf7FunctionalDrivingInfo1Acti.this.findViewById(R.id.tv_text6)) != null) {
                        if (value == 1) {
                            strid6 = "10A";
                        } else if (value == 2) {
                            strid6 = "13A";
                        } else if (value == 3) {
                            strid6 = "MAX";
                        }
                        ((TextView) Golf7FunctionalDrivingInfo1Acti.this.findViewById(R.id.tv_text6)).setText(strid6);
                        break;
                    }
                case 358:
                    Golf7FunctionalDrivingInfo1Acti.this.setCheck((CheckedTextView) Golf7FunctionalDrivingInfo1Acti.this.findViewById(R.id.ctv_checkedtext3), value != 0);
                    break;
                case 359:
                    if (((TextView) Golf7FunctionalDrivingInfo1Acti.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) Golf7FunctionalDrivingInfo1Acti.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + "%");
                        break;
                    }
                case 360:
                    if (((TextView) Golf7FunctionalDrivingInfo1Acti.this.findViewById(R.id.tv_text7)) != null) {
                        if (value < 60) {
                            ((TextView) Golf7FunctionalDrivingInfo1Acti.this.findViewById(R.id.tv_text7)).setText("LO");
                            break;
                        } else if (value > 195 || value == 255) {
                            ((TextView) Golf7FunctionalDrivingInfo1Acti.this.findViewById(R.id.tv_text7)).setText("HI");
                            break;
                        } else {
                            int value2 = value + 100;
                            ((TextView) Golf7FunctionalDrivingInfo1Acti.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "℃");
                            break;
                        }
                    }
                    break;
            }
        }
    };
    int[] resProfile = {R.string.str_driving_normal, R.string.str_driving_sport, R.string.str_driving_eco, R.string.str_driving_indivdual, R.string.str_17_snow, R.string.str_17_off_road, R.string.str_17_off_road_presonalization, R.string.wc_golf_comfort};
    int[] resEngine = {R.string.str_driving_normal, R.string.str_driving_sport, R.string.str_driving_eco};
    int[] resSteer = {R.string.str_driving_normal, R.string.str_driving_sport};
    int[] resClimate = {R.string.str_driving_normal, R.string.off, R.string.str_driving_eco};

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_golf7_functional_driving_info1);
        init();
        mInstance = this;
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_driving_comfort), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(103, new int[]{1}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_driving_normal), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(103, new int[]{2}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_driving_sport), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(103, new int[]{3}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_driving_eco), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(103, new int[]{4}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_driving_indivdual), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(103, new int[]{5}, null, null);
            }
        });
        setSelfClick(findViewById(R.id.glf7_functional_driving_indivdual_set_view), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7FunctionalDrivingInfo1Acti.this, Golf7FunctionalDrivingInfo2Acti.class);
                    Golf7FunctionalDrivingInfo1Acti.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setViewVisible(findViewById(R.id.glf7_functional_driving_indivdual_set_view), false);
        setViewVisible(findViewById(R.id.rzc_golf_driveprofile_steer_view), (DataCanbus.DATA[127] & 255) == 3);
        setViewVisible(findViewById(R.id.rzc_golf_driveprofile_climate_view), (DataCanbus.DATA[127] & 255) == 3);
        setViewVisible(findViewById(R.id.rzc_golf_driveprofile_engine_view), (DataCanbus.DATA[127] & 255) == 3);
        setViewVisible(findViewById(R.id.rzc_golf_driveprofile_frontlight_view), (DataCanbus.DATA[127] & 255) == 3);
        setViewVisible(findViewById(R.id.rzc_golf_driveprofile_acc_view), (DataCanbus.DATA[127] & 255) == 3);
        setViewVisible(findViewById(R.id.layout_view2), (DataCanbus.DATA[127] & 255) == 6);
        setViewVisible(findViewById(R.id.layout_view3), (DataCanbus.DATA[127] & 255) == 6);
        setViewVisible(findViewById(R.id.layout_view4), (DataCanbus.DATA[127] & 255) == 6);
        setViewVisible(findViewById(R.id.layout_view5), (DataCanbus.DATA[127] & 255) == 6);
        setViewVisible(findViewById(R.id.layout_view6), (DataCanbus.DATA[127] & 255) == 6);
        setViewVisible(findViewById(R.id.layout_view7), (DataCanbus.DATA[127] & 255) == 6);
        if (ConstGolf.isRZCGolf()) {
            setSelfClick((Button) findViewById(R.id.btn_minus1), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.8
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int val = (DataCanbus.DATA[344] & 255) - 1;
                    if (val < 0) {
                        val = 3;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{240, val}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_plus1), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.9
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int val = (DataCanbus.DATA[344] & 255) + 1;
                    if (val > 3) {
                        val = 0;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{240, val}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_minus6), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.10
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int val = (DataCanbus.DATA[357] & 255) - 1;
                    if (val < 0) {
                        val = 3;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{241, val}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_plus6), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.11
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int val = (DataCanbus.DATA[357] & 255) + 1;
                    if (val > 3) {
                        val = 0;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{241, val}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_minus7), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.12
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int val = DataCanbus.DATA[360] & 255;
                    if (val > 60 && val <= 195 && val != 255) {
                        val -= 5;
                    } else if (val > 195 || val == 255) {
                        val = 195;
                    } else if (val <= 60) {
                        val = 0;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{242, val}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_plus7), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.13
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int val = DataCanbus.DATA[360] & 255;
                    if (val >= 60 && val < 195 && val != 255) {
                        val += 5;
                    } else if (val >= 195) {
                        val = 255;
                    } else if (val < 60) {
                        val = 60;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{242, val}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_minus8), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.14
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int val = (DataCanbus.DATA[359] & 255) - 10;
                    if (val < 10) {
                        val = 10;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{244, val}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_plus8), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.15
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int val = (DataCanbus.DATA[359] & 255) + 10;
                    if (val > 100) {
                        val = 100;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{244, val}, null, null);
                }
            });
            setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.16
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value = DataCanbus.DATA[358] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 243;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(160, iArr, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_minus2), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.17
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int val = (DataCanbus.DATA[347] & 255) - 1;
                    if (val < 0) {
                        val = 1;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{226, val}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_plus2), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.18
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int val = (DataCanbus.DATA[347] & 255) + 1;
                    if (val > 1) {
                        val = 0;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{226, val}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_minus3), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.19
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int val = (DataCanbus.DATA[348] & 255) - 1;
                    if (val < 0) {
                        val = 1;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{225, val}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_plus3), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.20
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int val = (DataCanbus.DATA[348] & 255) + 1;
                    if (val > 1) {
                        val = 0;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{225, val}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_minus4), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.21
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int val = (DataCanbus.DATA[349] & 255) - 1;
                    if (val < 0) {
                        val = 1;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{227, val}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_plus4), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.22
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int val = (DataCanbus.DATA[349] & 255) + 1;
                    if (val > 1) {
                        val = 0;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{227, val}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_minus5), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.23
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int val = DataCanbus.DATA[350] & 255;
                    if (val == 0) {
                        val = 2;
                    } else if (val == 2) {
                        val = 0;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{228, val}, null, null);
                }
            });
            setSelfClick((Button) findViewById(R.id.btn_plus5), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.24
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int val = DataCanbus.DATA[350] & 255;
                    if (val == 0) {
                        val = 2;
                    } else if (val == 2) {
                        val = 0;
                    }
                    DataCanbus.PROXY.cmd(160, new int[]{228, val}, null, null);
                }
            });
            setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.25
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value = DataCanbus.DATA[351] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 229;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(160, iArr, null, null);
                }
            });
            setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.26
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int value = DataCanbus.DATA[352] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 230;
                    iArr[1] = value == 0 ? 1 : 0;
                    remoteModuleProxy.cmd(160, iArr, null, null);
                }
            });
        }
        setSelfClick((Button) findViewById(R.id.rzc_golf_driveprofile_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.27
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[127] & 255) - 1;
                if (val < 0) {
                    if (ConstGolf.isRZCGolf()) {
                        val = 7;
                    } else {
                        val = 3;
                    }
                }
                DataCanbus.PROXY.cmd(103, new int[]{208, val}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.rzc_golf_driveprofile_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.28
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[127] & 255) + 1;
                if (ConstGolf.isRZCGolf()) {
                    if (val > 7) {
                        val = 0;
                    }
                } else if (val > 3) {
                    val = 0;
                }
                DataCanbus.PROXY.cmd(103, new int[]{208, val}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.rzc_golf_driveprofile_engine_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.29
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[128] & 255) - 1;
                if (val < 0) {
                    val = 2;
                }
                DataCanbus.PROXY.cmd(103, new int[]{210, val}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.rzc_golf_driveprofile_engine_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.30
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[128] & 255) + 1;
                if (val > 2) {
                    val = 0;
                }
                DataCanbus.PROXY.cmd(103, new int[]{210, val}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.rzc_golf_driveprofile_steer_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.31
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[129] & 255) - 1;
                if (val < 0) {
                    val = 1;
                }
                DataCanbus.PROXY.cmd(103, new int[]{209, val}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.rzc_golf_driveprofile_steer_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.32
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[129] & 255) + 1;
                if (val > 1) {
                    val = 0;
                }
                DataCanbus.PROXY.cmd(103, new int[]{209, val}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.rzc_golf_driveprofile_climate_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.33
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = DataCanbus.DATA[131] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 211;
                iArr[1] = val != 0 ? 0 : 2;
                remoteModuleProxy.cmd(103, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.rzc_golf_driveprofile_climate_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.34
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = DataCanbus.DATA[131] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 211;
                iArr[1] = val != 0 ? 0 : 2;
                remoteModuleProxy.cmd(103, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.rzc_golf_driveprofile_frontlight_minus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.35
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[130] & 255) - 1;
                if (val < 0) {
                    val = 2;
                }
                DataCanbus.PROXY.cmd(103, new int[]{213, val}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.rzc_golf_driveprofile_frontlight_plus), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.36
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[130] & 255) + 1;
                if (val > 2) {
                    val = 0;
                }
                DataCanbus.PROXY.cmd(103, new int[]{213, val}, null, null);
            }
        });
        bindViewOnClick(R.id.rzc_golf_driveprofile_acc_m, new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.37
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[135] & 255) - 1;
                if (val < 0) {
                    val = 2;
                }
                DataCanbus.PROXY.cmd(103, new int[]{214, val}, null, null);
            }
        });
        bindViewOnClick(R.id.rzc_golf_driveprofile_acc_p, new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.38
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int val = (DataCanbus.DATA[135] & 255) + 1;
                if (val > 2) {
                    val = 0;
                }
                DataCanbus.PROXY.cmd(103, new int[]{214, val}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.layout_reset), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.39
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Golf7FunctionalDrivingInfo1Acti.this.resetDialog();
            }
        });
        setViewVisible(findViewById(R.id.layout_reset_view), false);
        if (DataCanbus.DATA[1000] == 437) {
            setViewVisible(findViewById(R.id.layout_reset), true);
        }
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_17_snow), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.40
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(103, 6);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_17_off_road), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.41
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(103, 8);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_17_off_road_presonal), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.42
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(103, 9);
            }
        });
        setSelfClick(findViewById(R.id.glf7_functional_offroad_driving_indivdual_set_view), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.43
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Golf7FunctionalDrivingInfo1Acti.this, Golf7Functional_OffRoadCustom_Wc_Acti.class);
                    Golf7FunctionalDrivingInfo1Acti.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setViewVisible(findViewById(R.id.glf7_functional_offroad_driving_indivdual_set_view), false);
    }

    protected void resetDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.bsd_klj_str14)) + "?");
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.44
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.44.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(103, new int[]{212, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti.45
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
        DataCanbus.PROXY.cmd(98, new int[]{5}, null, null);
        mIsFront = true;
        if (DataCanbus.DATA[1000] == 655520 || DataCanbus.DATA[1000] == 2883744 || DataCanbus.DATA[1000] == 2949280 || DataCanbus.DATA[1000] == 3014816) {
            setViewVisible(findViewById(R.id.layout_view1), true);
            setViewVisible(findViewById(R.id.layout_view8), true);
            setViewVisible(findViewById(R.id.layout_view9), true);
            setViewVisible(findViewById(R.id.layout_view10), true);
            setViewVisible(findViewById(R.id.layout_view11), true);
            return;
        }
        setViewVisible(findViewById(R.id.layout_view1), false);
        setViewVisible(findViewById(R.id.layout_view8), false);
        setViewVisible(findViewById(R.id.layout_view9), false);
        setViewVisible(findViewById(R.id.layout_view10), false);
        setViewVisible(findViewById(R.id.layout_view11), false);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
        if (DataCanbus.DATA[1000] == 437) {
            DataCanbus.PROXY.cmd(103, new int[]{208, 255}, null, null);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    protected void finalize() throws Throwable {
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        if (ConstGolf.isRZCGolf()) {
            DataCanbus.NOTIFY_EVENTS[344].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[347].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[348].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[349].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[350].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[351].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[352].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[357].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[358].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[359].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[360].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        if (ConstGolf.isRZCGolf()) {
            DataCanbus.NOTIFY_EVENTS[344].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[347].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[348].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[349].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[350].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[351].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[352].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[357].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[358].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[359].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[360].removeNotify(this.mNotifyCanbus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCurConsumption() {
        int value = DataCanbus.DATA[127];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_driving_comfort), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_driving_comfort), switchOn != 0);
        } else {
            setViewVisible(findViewById(R.id.glf7_view_functional_driving_comfort), false);
        }
        if (findViewById(R.id.rzc_golf_driveprofile_view) != null) {
            if (DataCanbus.DATA[1000] == 437) {
                setViewVisible(findViewById(R.id.rzc_golf_driveprofile_view), true);
                if (((TextView) findViewById(R.id.rzc_golf_driveprofile_txt)) != null && value < this.resProfile.length) {
                    ((TextView) findViewById(R.id.rzc_golf_driveprofile_txt)).setText(this.resProfile[value]);
                }
                setViewVisible(findViewById(R.id.rzc_golf_driveprofile_steer_view), value == 3);
                setViewVisible(findViewById(R.id.rzc_golf_driveprofile_climate_view), value == 3);
                setViewVisible(findViewById(R.id.rzc_golf_driveprofile_engine_view), value == 3);
                setViewVisible(findViewById(R.id.rzc_golf_driveprofile_frontlight_view), value == 3);
                setViewVisible(findViewById(R.id.rzc_golf_driveprofile_acc_view), value == 3);
                return;
            }
            if (ConstGolf.isRZCGolf()) {
                setViewVisible(findViewById(R.id.rzc_golf_driveprofile_view), true);
                if (((TextView) findViewById(R.id.rzc_golf_driveprofile_txt)) != null && value < this.resProfile.length) {
                    ((TextView) findViewById(R.id.rzc_golf_driveprofile_txt)).setText(this.resProfile[value]);
                }
                setViewVisible(findViewById(R.id.rzc_golf_driveprofile_steer_view), value == 3);
                setViewVisible(findViewById(R.id.rzc_golf_driveprofile_climate_view), value == 3);
                setViewVisible(findViewById(R.id.rzc_golf_driveprofile_engine_view), value == 3);
                setViewVisible(findViewById(R.id.rzc_golf_driveprofile_frontlight_view), value == 3);
                setViewVisible(findViewById(R.id.layout_view2), value == 6);
                setViewVisible(findViewById(R.id.layout_view3), value == 6);
                setViewVisible(findViewById(R.id.layout_view4), value == 6);
                setViewVisible(findViewById(R.id.layout_view5), value == 6);
                setViewVisible(findViewById(R.id.layout_view6), value == 6);
                setViewVisible(findViewById(R.id.layout_view7), value == 6);
                return;
            }
            setViewVisible(findViewById(R.id.rzc_golf_driveprofile_view), false);
        }
    }

    protected void mUpdaterAcc() {
        int value = DataCanbus.DATA[135];
        if (DataCanbus.DATA[1000] == 437) {
            if (((TextView) findViewById(R.id.rzc_golf_driveprofile_acc_txt)) != null && value < this.resEngine.length) {
                ((TextView) findViewById(R.id.rzc_golf_driveprofile_acc_txt)).setText(this.resEngine[value]);
                return;
            }
            return;
        }
        setViewVisible(findViewById(R.id.rzc_golf_driveprofile_acc_view), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAverageConsumption() {
        int value = DataCanbus.DATA[128];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_driving_normal), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_driving_normal), switchOn != 0);
        } else {
            setViewVisible(findViewById(R.id.glf7_view_functional_driving_normal), false);
        }
        if (findViewById(R.id.rzc_golf_driveprofile_engine_view) != null) {
            if (ConstGolf.isRZCGolf() || DataCanbus.DATA[1000] == 437) {
                if (((TextView) findViewById(R.id.rzc_golf_driveprofile_engine_txt)) != null && value < this.resEngine.length) {
                    ((TextView) findViewById(R.id.rzc_golf_driveprofile_engine_txt)).setText(this.resEngine[value]);
                    return;
                }
                return;
            }
            setViewVisible(findViewById(R.id.rzc_golf_driveprofile_engine_view), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterConvenience() {
        int value = DataCanbus.DATA[129];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_driving_sport), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_driving_sport), switchOn != 0);
        } else {
            setViewVisible(findViewById(R.id.glf7_view_functional_driving_sport), false);
        }
        if (findViewById(R.id.rzc_golf_driveprofile_steer_view) != null) {
            if (ConstGolf.isRZCGolf() || DataCanbus.DATA[1000] == 437) {
                if (((TextView) findViewById(R.id.rzc_golf_driveprofile_steer_txt)) != null && value < this.resSteer.length) {
                    ((TextView) findViewById(R.id.rzc_golf_driveprofile_steer_txt)).setText(this.resSteer[value]);
                    return;
                }
                return;
            }
            setViewVisible(findViewById(R.id.rzc_golf_driveprofile_steer_view), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterEcoTips() {
        int value = DataCanbus.DATA[130];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_driving_eco), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_driving_eco), switchOn != 0);
        } else {
            setViewVisible(findViewById(R.id.glf7_view_functional_driving_eco), false);
        }
        if (findViewById(R.id.rzc_golf_driveprofile_frontlight_view) != null) {
            if (ConstGolf.isRZCGolf() || DataCanbus.DATA[1000] == 437) {
                if (((TextView) findViewById(R.id.rzc_golf_driveprofile_frontlight_txt)) != null && value < this.resEngine.length) {
                    ((TextView) findViewById(R.id.rzc_golf_driveprofile_frontlight_txt)).setText(this.resEngine[value]);
                    return;
                }
                return;
            }
            setViewVisible(findViewById(R.id.rzc_golf_driveprofile_frontlight_view), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTravellingTime() {
        int value = DataCanbus.DATA[131];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.glf7_view_functional_driving_indivdual), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_driving_indivdual), switchOn != 0);
            setViewVisible(findViewById(R.id.glf7_functional_driving_indivdual_set_view), switchOn != 0);
        } else {
            setViewVisible(findViewById(R.id.glf7_view_functional_driving_indivdual), false);
        }
        if (findViewById(R.id.rzc_golf_driveprofile_climate_view) != null) {
            if (ConstGolf.isRZCGolf() || DataCanbus.DATA[1000] == 437) {
                if (((TextView) findViewById(R.id.rzc_golf_driveprofile_climate_txt)) != null && value < this.resClimate.length) {
                    ((TextView) findViewById(R.id.rzc_golf_driveprofile_climate_txt)).setText(this.resClimate[value]);
                    return;
                }
                return;
            }
            setViewVisible(findViewById(R.id.rzc_golf_driveprofile_climate_view), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSnow() {
        int value = DataCanbus.DATA[196];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.layout_17_snow), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.ctv_17_snow), switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.layout_17_snow), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOffRoad() {
        int value = DataCanbus.DATA[197];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.layout_17_off_road), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.ctv_17_off_road), switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.layout_17_off_road), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOffRoadPresonal() {
        int value = DataCanbus.DATA[198];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.layout_17_off_road_presonal), enable != 0);
            setCheck((CheckedTextView) findViewById(R.id.ctv_17_off_road_presonal), switchOn != 0);
            setViewVisible(findViewById(R.id.glf7_functional_offroad_driving_indivdual_set_view), switchOn != 0);
            return;
        }
        setViewVisible(findViewById(R.id.layout_17_off_road_presonal), false);
    }
}
