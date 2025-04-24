package com.syu.carinfo.golf7_xp;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
public class Golf7_XP_FunctionalDrivingInfo1Acti extends BaseActivity {
    public static Golf7_XP_FunctionalDrivingInfo1Acti mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 186:
                    Golf7_XP_FunctionalDrivingInfo1Acti.this.mUpdaterCurConsumption();
                    break;
                case 187:
                    Golf7_XP_FunctionalDrivingInfo1Acti.this.mUpdaterAverageConsumption();
                    break;
                case 188:
                    Golf7_XP_FunctionalDrivingInfo1Acti.this.mUpdaterConvenience();
                    break;
                case 189:
                    Golf7_XP_FunctionalDrivingInfo1Acti.this.mUpdaterEcoTips();
                    break;
                case 190:
                    Golf7_XP_FunctionalDrivingInfo1Acti.this.mUpdaterTravellingTime();
                    break;
                case 216:
                    switch (value) {
                        case 0:
                            ((TextView) Golf7_XP_FunctionalDrivingInfo1Acti.this.findViewById(R.id.tv_text2)).setText(R.string.str_driving_normal);
                            break;
                        case 3:
                            ((TextView) Golf7_XP_FunctionalDrivingInfo1Acti.this.findViewById(R.id.tv_text2)).setText(R.string.str_17_off_road);
                            break;
                    }
                case 217:
                    switch (value) {
                        case 0:
                            ((TextView) Golf7_XP_FunctionalDrivingInfo1Acti.this.findViewById(R.id.tv_text3)).setText(R.string.str_driving_normal);
                            break;
                        case 1:
                            ((TextView) Golf7_XP_FunctionalDrivingInfo1Acti.this.findViewById(R.id.tv_text3)).setText(R.string.str_driving_sport);
                            break;
                    }
                case 218:
                    switch (value) {
                        case 0:
                            ((TextView) Golf7_XP_FunctionalDrivingInfo1Acti.this.findViewById(R.id.tv_text4)).setText(R.string.str_driving_normal);
                            break;
                        case 1:
                            ((TextView) Golf7_XP_FunctionalDrivingInfo1Acti.this.findViewById(R.id.tv_text4)).setText(R.string.str_driving_sport);
                            break;
                        case 2:
                            ((TextView) Golf7_XP_FunctionalDrivingInfo1Acti.this.findViewById(R.id.tv_text4)).setText(R.string.str_driving_eco);
                            break;
                        case 3:
                            ((TextView) Golf7_XP_FunctionalDrivingInfo1Acti.this.findViewById(R.id.tv_text4)).setText(R.string.str_17_off_road);
                            break;
                    }
                case 219:
                    switch (value) {
                        case 0:
                            ((TextView) Golf7_XP_FunctionalDrivingInfo1Acti.this.findViewById(R.id.tv_text5)).setText(R.string.str_driving_normal);
                            break;
                        case 2:
                            ((TextView) Golf7_XP_FunctionalDrivingInfo1Acti.this.findViewById(R.id.tv_text5)).setText(R.string.str_driving_eco);
                            break;
                    }
                case 220:
                    Golf7_XP_FunctionalDrivingInfo1Acti.this.setCheck((CheckedTextView) Golf7_XP_FunctionalDrivingInfo1Acti.this.findViewById(R.id.ctv_checkedtext1), value != 0);
                    break;
                case 221:
                    Golf7_XP_FunctionalDrivingInfo1Acti.this.setCheck((CheckedTextView) Golf7_XP_FunctionalDrivingInfo1Acti.this.findViewById(R.id.ctv_checkedtext2), value != 0);
                    break;
                case 222:
                    Golf7_XP_FunctionalDrivingInfo1Acti.this.setCheck((CheckedTextView) Golf7_XP_FunctionalDrivingInfo1Acti.this.findViewById(R.id.ctv_checkedtext3), value != 0);
                    break;
                case 223:
                    switch (value) {
                        case 0:
                            ((TextView) Golf7_XP_FunctionalDrivingInfo1Acti.this.findViewById(R.id.tv_text6)).setText(R.string.str_driving_normal);
                            break;
                        case 3:
                            ((TextView) Golf7_XP_FunctionalDrivingInfo1Acti.this.findViewById(R.id.tv_text6)).setText(R.string.str_17_off_road);
                            break;
                    }
            }
        }
    };
    int[] resProfile = {R.string.str_driving_normal, R.string.str_driving_sport, R.string.str_driving_eco, R.string.str_driving_indivdual, R.string.str_17_snow, R.string.str_17_off_road, R.string.str_17_off_road_presonalization, R.string.wc_golf_comfort};
    int[] resEngine = {R.string.str_driving_normal, R.string.str_driving_sport, R.string.str_driving_eco};
    int[] resSteer = {R.string.str_driving_normal, R.string.str_driving_sport};
    int[] resClimate = {R.string.str_driving_normal, R.string.off, R.string.str_driving_eco};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_golf7_functional_driving_info1_xp);
        init();
        mInstance = this;
    }

    @Override
    public void init() {
        setViewVisible(findViewById(R.id.rzc_golf_driveprofile_steer_view), (DataCanbus.DATA[186] & 255) == 3);
        setViewVisible(findViewById(R.id.rzc_golf_driveprofile_climate_view), (DataCanbus.DATA[186] & 255) == 3);
        setViewVisible(findViewById(R.id.rzc_golf_driveprofile_engine_view), (DataCanbus.DATA[186] & 255) == 3);
        setViewVisible(findViewById(R.id.rzc_golf_driveprofile_frontlight_view), (DataCanbus.DATA[186] & 255) == 3);
        setViewVisible(findViewById(R.id.layout_view2), (DataCanbus.DATA[186] & 255) == 6);
        setViewVisible(findViewById(R.id.layout_view3), (DataCanbus.DATA[186] & 255) == 6);
        setViewVisible(findViewById(R.id.layout_view4), (DataCanbus.DATA[186] & 255) == 6);
        setViewVisible(findViewById(R.id.layout_view5), (DataCanbus.DATA[186] & 255) == 6);
        setViewVisible(findViewById(R.id.layout_view6), (DataCanbus.DATA[186] & 255) == 6);
        setViewVisible(findViewById(R.id.layout_view7), (DataCanbus.DATA[186] & 255) == 6);
        setViewVisible(findViewById(R.id.layout_view8), (DataCanbus.DATA[186] & 255) == 6);
        setViewVisible(findViewById(R.id.layout_view9), (DataCanbus.DATA[186] & 255) == 6);
        setSelfClick((Button) findViewById(R.id.rzc_golf_driveprofile_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = (DataCanbus.DATA[186] & 255) - 1;
                if (val < 0) {
                    val = 7;
                }
                DataCanbus.PROXY.cmd(107, new int[]{208, val}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.rzc_golf_driveprofile_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = (DataCanbus.DATA[186] & 255) + 1;
                if (val > 7) {
                    val = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{208, val}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.rzc_golf_driveprofile_engine_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = (DataCanbus.DATA[187] & 255) - 1;
                if (val < 0) {
                    val = 2;
                }
                DataCanbus.PROXY.cmd(107, new int[]{210, val}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.rzc_golf_driveprofile_engine_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = (DataCanbus.DATA[187] & 255) + 1;
                if (val > 2) {
                    val = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{210, val}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.rzc_golf_driveprofile_steer_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = (DataCanbus.DATA[188] & 255) - 1;
                if (val < 0) {
                    val = 1;
                }
                DataCanbus.PROXY.cmd(107, new int[]{209, val}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.rzc_golf_driveprofile_steer_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = (DataCanbus.DATA[188] & 255) + 1;
                if (val > 1) {
                    val = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{209, val}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.rzc_golf_driveprofile_climate_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = DataCanbus.DATA[190] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 211;
                iArr[1] = val != 0 ? 0 : 2;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.rzc_golf_driveprofile_climate_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = DataCanbus.DATA[190] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 211;
                iArr[1] = val != 0 ? 0 : 2;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.rzc_golf_driveprofile_frontlight_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = (DataCanbus.DATA[189] & 255) - 1;
                if (val < 0) {
                    val = 2;
                }
                DataCanbus.PROXY.cmd(107, new int[]{213, val}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.rzc_golf_driveprofile_frontlight_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = (DataCanbus.DATA[189] & 255) + 1;
                if (val > 2) {
                    val = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{213, val}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus2), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = DataCanbus.DATA[216] & 255;
                if (val == 0) {
                    val = 3;
                } else if (val == 3) {
                    val = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{214, val}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus2), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = DataCanbus.DATA[216] & 255;
                if (val == 0) {
                    val = 3;
                } else if (val == 3) {
                    val = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{214, val}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus3), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = DataCanbus.DATA[217] & 255;
                if (val == 0) {
                    val = 1;
                } else if (val == 1) {
                    val = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{215, val}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus3), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = DataCanbus.DATA[217] & 255;
                if (val == 0) {
                    val = 1;
                } else if (val == 1) {
                    val = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{215, val}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus4), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = (DataCanbus.DATA[218] & 255) - 1;
                if (val < 0) {
                    val = 3;
                }
                DataCanbus.PROXY.cmd(107, new int[]{216, val}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus4), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = (DataCanbus.DATA[218] & 255) + 1;
                if (val > 3) {
                    val = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{216, val}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus5), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = DataCanbus.DATA[219] & 255;
                if (val == 0) {
                    val = 2;
                } else if (val == 2) {
                    val = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{217, val}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus5), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = DataCanbus.DATA[219] & 255;
                if (val == 0) {
                    val = 2;
                } else if (val == 2) {
                    val = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{217, val}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus6), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = DataCanbus.DATA[223] & 255;
                if (val == 0) {
                    val = 3;
                } else if (val == 3) {
                    val = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{221, val}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus6), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = DataCanbus.DATA[223] & 255;
                if (val == 0) {
                    val = 3;
                } else if (val == 3) {
                    val = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{221, val}, null, null);
            }
        });
        bindViewOnClick(R.id.ctv_checkedtext1, new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = DataCanbus.DATA[220] & 255;
                if (val == 0) {
                    val = 1;
                } else if (val == 1) {
                    val = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{218, val}, null, null);
            }
        });
        bindViewOnClick(R.id.ctv_checkedtext2, new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = DataCanbus.DATA[221] & 255;
                if (val == 0) {
                    val = 1;
                } else if (val == 1) {
                    val = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{219, val}, null, null);
            }
        });
        bindViewOnClick(R.id.ctv_checkedtext3, new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = DataCanbus.DATA[222] & 255;
                if (val == 0) {
                    val = 1;
                } else if (val == 1) {
                    val = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{220, val}, null, null);
            }
        });
        bindViewOnClick(R.id.layout_reset, new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                Golf7_XP_FunctionalDrivingInfo1Acti.this.resetDialog();
            }
        });
    }

    protected void resetDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.bsd_klj_str14)) + "?");
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(107, new int[]{212, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        mIsFront = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    @Override
    protected void finalize() throws Throwable {
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[216].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[217].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[218].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[219].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[220].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[221].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[222].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[223].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[216].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[217].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[218].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[219].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[220].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[221].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[222].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[223].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterCurConsumption() {
        int value = DataCanbus.DATA[186];
        if (((TextView) findViewById(R.id.rzc_golf_driveprofile_txt)) != null && value < this.resProfile.length) {
            ((TextView) findViewById(R.id.rzc_golf_driveprofile_txt)).setText(this.resProfile[value]);
        }
        setViewVisible(findViewById(R.id.rzc_golf_driveprofile_frontlight_view), value == 3);
        setViewVisible(findViewById(R.id.rzc_golf_driveprofile_engine_view), value == 3);
        setViewVisible(findViewById(R.id.rzc_golf_driveprofile_steer_view), value == 3);
        setViewVisible(findViewById(R.id.rzc_golf_driveprofile_climate_view), value == 3);
        setViewVisible(findViewById(R.id.layout_view2), (DataCanbus.DATA[186] & 255) == 6);
        setViewVisible(findViewById(R.id.layout_view3), (DataCanbus.DATA[186] & 255) == 6);
        setViewVisible(findViewById(R.id.layout_view4), (DataCanbus.DATA[186] & 255) == 6);
        setViewVisible(findViewById(R.id.layout_view5), (DataCanbus.DATA[186] & 255) == 6);
        setViewVisible(findViewById(R.id.layout_view6), (DataCanbus.DATA[186] & 255) == 6);
        setViewVisible(findViewById(R.id.layout_view7), (DataCanbus.DATA[186] & 255) == 6);
        setViewVisible(findViewById(R.id.layout_view8), (DataCanbus.DATA[186] & 255) == 6);
        setViewVisible(findViewById(R.id.layout_view9), (DataCanbus.DATA[186] & 255) == 6);
    }

    
    public void mUpdaterAverageConsumption() {
        int value = DataCanbus.DATA[187];
        if (((TextView) findViewById(R.id.rzc_golf_driveprofile_engine_txt)) != null && value < this.resEngine.length) {
            ((TextView) findViewById(R.id.rzc_golf_driveprofile_engine_txt)).setText(this.resEngine[value]);
        }
    }

    
    public void mUpdaterConvenience() {
        int value = DataCanbus.DATA[188];
        if (((TextView) findViewById(R.id.rzc_golf_driveprofile_steer_txt)) != null && value < this.resSteer.length) {
            ((TextView) findViewById(R.id.rzc_golf_driveprofile_steer_txt)).setText(this.resSteer[value]);
        }
    }

    
    public void mUpdaterEcoTips() {
        int value = DataCanbus.DATA[189];
        if (((TextView) findViewById(R.id.rzc_golf_driveprofile_frontlight_txt)) != null && value < this.resEngine.length) {
            ((TextView) findViewById(R.id.rzc_golf_driveprofile_frontlight_txt)).setText(this.resEngine[value]);
        }
    }

    
    public void mUpdaterTravellingTime() {
        int value = DataCanbus.DATA[190];
        if (((TextView) findViewById(R.id.rzc_golf_driveprofile_climate_txt)) != null && value < this.resClimate.length) {
            ((TextView) findViewById(R.id.rzc_golf_driveprofile_climate_txt)).setText(this.resClimate[value]);
        }
    }
}
