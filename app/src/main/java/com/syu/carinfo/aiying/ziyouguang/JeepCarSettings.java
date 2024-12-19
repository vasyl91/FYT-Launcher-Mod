package com.syu.carinfo.aiying.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class JeepCarSettings extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 0:
                    JeepCarSettings.this.mParksense_brake_assist();
                    break;
                case 1:
                    JeepCarSettings.this.mForward_collision_brake();
                    break;
                case 2:
                    JeepCarSettings.this.mParkview_movingline();
                    break;
                case 3:
                    JeepCarSettings.this.mParkview_fixedline();
                    break;
                case 4:
                    JeepCarSettings.this.mRain_sense_wipers();
                    break;
                case 5:
                    JeepCarSettings.this.mHill_start_assist();
                    break;
                case 6:
                    JeepCarSettings.this.mAuto_park_brake();
                    break;
                case 7:
                    JeepCarSettings.this.mStart_headlights();
                    break;
                case 8:
                    JeepCarSettings.this.mAuto_dimming_highbeams();
                    break;
                case 9:
                    JeepCarSettings.this.mDaytime_running_lights();
                    break;
                case 10:
                    JeepCarSettings.this.mLock_lights();
                    break;
                case 11:
                    JeepCarSettings.this.mAuto_lock();
                    break;
                case 12:
                    JeepCarSettings.this.mGetoff_autolock();
                    break;
                case 13:
                    JeepCarSettings.this.mKeyless_entry();
                    break;
                case 14:
                    JeepCarSettings.this.mPower_tailgate_alarm();
                    break;
                case 15:
                    JeepCarSettings.this.mHeadlights_off_delay();
                    break;
                case 16:
                    JeepCarSettings.this.mHeadlights_on_delay();
                    break;
                case 17:
                    JeepCarSettings.this.mpower_off_delay();
                    break;
                case 18:
                    JeepCarSettings.this.mParkSense();
                    break;
                case 19:
                    JeepCarSettings.this.mForwardCollLisionWarn();
                    break;
                case 20:
                    JeepCarSettings.this.mLanesenseWarn();
                    break;
                case 21:
                    JeepCarSettings.this.mLaneSenseLevel();
                    break;
                case 22:
                    JeepCarSettings.this.mFrontParkSenseVol();
                    break;
                case 23:
                    JeepCarSettings.this.mRearParkSenseVol();
                    break;
                case 24:
                    JeepCarSettings.this.mBlindWarn();
                    break;
                case 25:
                    JeepCarSettings.this.mComfortSystens();
                    break;
                case 26:
                    JeepCarSettings.this.mPressKeyUnlock();
                    break;
                case 27:
                    JeepCarSettings.this.mSurround_sound();
                    break;
                case 28:
                    JeepCarSettings.this.mSpeed_volume();
                    break;
                case 29:
                    JeepCarSettings.this.set_language();
                    break;
                case 30:
                    JeepCarSettings.this.set_unit();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_jeep_365_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        if (DataCanbus.DATA[1000] == 365) {
            findViewById(R.id.jeep_rain_sense).setVisibility(8);
        } else {
            findViewById(R.id.jeep_rain_sense).setVisibility(0);
        }
        findViewById(R.id.btn_minus1).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{1}, null, null);
            }
        });
        findViewById(R.id.btn_plus1).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{2}, null, null);
            }
        });
        findViewById(R.id.btn_minus2).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{4}, null, null);
            }
        });
        findViewById(R.id.btn_plus2).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{5}, null, null);
            }
        });
        findViewById(R.id.btn_minus3).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{7}, null, null);
            }
        });
        findViewById(R.id.btn_plus3).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{8}, null, null);
            }
        });
        findViewById(R.id.btn_minus4).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{9}, null, null);
            }
        });
        findViewById(R.id.btn_plus4).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{10}, null, null);
            }
        });
        findViewById(R.id.btn_minus5).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{11}, null, null);
            }
        });
        findViewById(R.id.btn_plus5).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{12}, null, null);
            }
        });
        findViewById(R.id.btn_minus6).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{13}, null, null);
            }
        });
        findViewById(R.id.btn_plus6).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{14}, null, null);
            }
        });
        findViewById(R.id.btn_minus7).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{15}, null, null);
            }
        });
        findViewById(R.id.btn_plus7).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{16}, null, null);
            }
        });
        findViewById(R.id.btn_minus8).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{17}, null, null);
            }
        });
        findViewById(R.id.btn_plus8).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{18}, null, null);
            }
        });
        findViewById(R.id.btn_minus9).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{34}, null, null);
            }
        });
        findViewById(R.id.btn_plus9).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{35}, null, null);
            }
        });
        findViewById(R.id.btn_minus10).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{36}, null, null);
            }
        });
        findViewById(R.id.btn_plus10).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{37}, null, null);
            }
        });
        findViewById(R.id.btn_minus11).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{38}, null, null);
            }
        });
        findViewById(R.id.btn_plus11).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{39}, null, null);
            }
        });
        findViewById(R.id.btn_minus12).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.24
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{40}, null, null);
            }
        });
        findViewById(R.id.btn_plus12).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.25
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{41}, null, null);
            }
        });
        findViewById(R.id.btn_minus14).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.26
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{42}, null, null);
            }
        });
        findViewById(R.id.btn_plus14).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.27
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{43}, null, null);
            }
        });
        findViewById(R.id.btn_minus15).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.28
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{44}, null, null);
            }
        });
        findViewById(R.id.btn_plus15).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.29
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{45}, null, null);
            }
        });
        findViewById(R.id.btn_minus13).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.30
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[28];
                int value1 = DataCanbus.DATA[27];
                if (value2 >= 2) {
                    value = value2 - 2;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{value, value1}, null, null);
            }
        });
        findViewById(R.id.btn_plus13).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.31
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[28];
                int value1 = DataCanbus.DATA[27];
                if (value2 < 6) {
                    value = value2 + 2;
                } else {
                    value = 6;
                }
                DataCanbus.PROXY.cmd(1, new int[]{value, value1}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.32
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{3}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.33
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{6}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.34
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{19}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.35
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{20}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.36
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{21}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.37
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{22}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.38
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{23}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.39
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{24}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.40
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{25}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.41
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{26}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.42
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{28}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.43
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{29}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.44
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{30}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.45
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{32}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext15)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.46
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{33}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.aiying.ziyouguang.JeepCarSettings.47
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value1;
                int value = DataCanbus.DATA[28];
                int value12 = DataCanbus.DATA[27];
                if (value12 == 0) {
                    value1 = 1;
                } else {
                    value1 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{value, value1}, null, null);
            }
        });
        if (DataCanbus.DATA[1000] == 365) {
            findViewById(R.id.jeep_surround_set).setVisibility(8);
            findViewById(R.id.jeep_speed_volume_set).setVisibility(8);
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
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mParksense_brake_assist() {
        int value = DataCanbus.DATA[0];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mForward_collision_brake() {
        int value = DataCanbus.DATA[1];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mParkview_movingline() {
        int value = DataCanbus.DATA[2];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mParkview_fixedline() {
        int value = DataCanbus.DATA[3];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mRain_sense_wipers() {
        int value = DataCanbus.DATA[4];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mHill_start_assist() {
        int value = DataCanbus.DATA[5];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mAuto_park_brake() {
        int value = DataCanbus.DATA[6];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mStart_headlights() {
        int value = DataCanbus.DATA[7];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mAuto_dimming_highbeams() {
        int value = DataCanbus.DATA[8];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mDaytime_running_lights() {
        int value = DataCanbus.DATA[9];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mLock_lights() {
        int value = DataCanbus.DATA[10];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mAuto_lock() {
        int value = DataCanbus.DATA[11];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mGetoff_autolock() {
        int value = DataCanbus.DATA[12];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mKeyless_entry() {
        int value = DataCanbus.DATA[13];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mPower_tailgate_alarm() {
        int value = DataCanbus.DATA[14];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext15)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mSurround_sound() {
        int value = DataCanbus.DATA[27];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mHeadlights_off_delay() {
        int value = DataCanbus.DATA[15];
        if (((TextView) findViewById(R.id.tv_text10)) != null) {
            if (value < 60) {
                ((TextView) findViewById(R.id.tv_text10)).setText(String.valueOf(value) + "秒");
            } else {
                ((TextView) findViewById(R.id.tv_text10)).setText(String.valueOf(value / 60) + "分" + (value % 60) + "秒");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mHeadlights_on_delay() {
        int value = DataCanbus.DATA[16];
        if (((TextView) findViewById(R.id.tv_text11)) != null) {
            if (value < 60) {
                ((TextView) findViewById(R.id.tv_text11)).setText(String.valueOf(value) + "秒");
            } else {
                ((TextView) findViewById(R.id.tv_text11)).setText(String.valueOf(value / 60) + "分" + (value % 60) + "秒");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mpower_off_delay() {
        int value = DataCanbus.DATA[17] * 15;
        if (((TextView) findViewById(R.id.tv_text12)) != null) {
            if (value < 60) {
                ((TextView) findViewById(R.id.tv_text12)).setText(String.valueOf(value) + "秒");
            } else {
                ((TextView) findViewById(R.id.tv_text12)).setText(String.valueOf(value / 60) + "分" + (value % 60) + "秒");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void set_language() {
        int value = DataCanbus.DATA[29];
        if (((TextView) findViewById(R.id.tv_text14)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text14)).setText(R.string.jeep_language_set1);
            } else {
                ((TextView) findViewById(R.id.tv_text14)).setText(R.string.jeep_language_set0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void set_unit() {
        int value = DataCanbus.DATA[30];
        if (((TextView) findViewById(R.id.tv_text15)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text15)).setText(R.string.jeep_format_set1);
            } else {
                ((TextView) findViewById(R.id.tv_text15)).setText(R.string.jeep_format_set0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mSpeed_volume() {
        int value = DataCanbus.DATA[28] / 2;
        if (((TextView) findViewById(R.id.tv_text13)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text13)).setText(R.string.jeep_comfortsystems_0);
            } else {
                ((TextView) findViewById(R.id.tv_text13)).setText(new StringBuilder().append(value).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mParkSense() {
        int value = DataCanbus.DATA[18];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.jeep_parksense_1);
            } else {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.jeep_parksense_0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mForwardCollLisionWarn() {
        int value = DataCanbus.DATA[19];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.jeep_forwardcollisionwarn_1);
            } else {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.jeep_forwardcollisionwarn_0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mLanesenseWarn() {
        int value = DataCanbus.DATA[20];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.jeep_lanesensewarn_2);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.jeep_lanesensewarn_1);
            } else {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.jeep_lanesensewarn_0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mLaneSenseLevel() {
        int value = DataCanbus.DATA[21];
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_air_high);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_air_middle);
            } else {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_air_low);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mFrontParkSenseVol() {
        int value = DataCanbus.DATA[22];
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.klc_air_high);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.klc_air_middle);
            } else {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.klc_air_low);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mRearParkSenseVol() {
        int value = DataCanbus.DATA[23];
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.klc_air_high);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.klc_air_middle);
            } else {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.klc_air_low);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mBlindWarn() {
        int value = DataCanbus.DATA[24];
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text7)).setText(R.string.jeep_blindwarn_2);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text7)).setText(R.string.jeep_blindwarn_1);
            } else {
                ((TextView) findViewById(R.id.tv_text7)).setText(R.string.jeep_blindwarn_0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mComfortSystens() {
        int value = DataCanbus.DATA[25];
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text8)).setText(R.string.jeep_comfortsystems_2);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text8)).setText(R.string.jeep_comfortsystems_1);
            } else {
                ((TextView) findViewById(R.id.tv_text8)).setText(R.string.jeep_comfortsystems_0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mPressKeyUnlock() {
        int value = DataCanbus.DATA[26];
        if (((TextView) findViewById(R.id.tv_text9)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text9)).setText(R.string.jeep_presskeyunlock_1);
            } else {
                ((TextView) findViewById(R.id.tv_text9)).setText(R.string.jeep_presskeyunlock_0);
            }
        }
    }
}
