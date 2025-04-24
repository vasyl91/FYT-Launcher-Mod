package com.syu.carinfo.aiying.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class JeepCarSettings extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 97:
                    JeepCarSettings.this.mParksense_brake_assist();
                    break;
                case 98:
                    JeepCarSettings.this.mForward_collision_brake();
                    break;
                case 99:
                    JeepCarSettings.this.mParkview_movingline();
                    break;
                case 100:
                    JeepCarSettings.this.mParkview_fixedline();
                    break;
                case 101:
                    JeepCarSettings.this.mRain_sense_wipers();
                    break;
                case 102:
                    JeepCarSettings.this.mHill_start_assist();
                    break;
                case 103:
                    JeepCarSettings.this.mAuto_park_brake();
                    break;
                case 104:
                    JeepCarSettings.this.mStart_headlights();
                    break;
                case 105:
                    JeepCarSettings.this.mAuto_dimming_highbeams();
                    break;
                case 106:
                    JeepCarSettings.this.mDaytime_running_lights();
                    break;
                case 107:
                    JeepCarSettings.this.mLock_lights();
                    break;
                case 108:
                    JeepCarSettings.this.mAuto_lock();
                    break;
                case 109:
                    JeepCarSettings.this.mGetoff_autolock();
                    break;
                case 110:
                    JeepCarSettings.this.mKeyless_entry();
                    break;
                case 111:
                    JeepCarSettings.this.mPower_tailgate_alarm();
                    break;
                case 112:
                    JeepCarSettings.this.mHeadlights_off_delay();
                    break;
                case 113:
                    JeepCarSettings.this.mHeadlights_on_delay();
                    break;
                case 114:
                    JeepCarSettings.this.mpower_off_delay();
                    break;
                case 115:
                    JeepCarSettings.this.mParkSense();
                    break;
                case 116:
                    JeepCarSettings.this.mForwardCollLisionWarn();
                    break;
                case 117:
                    JeepCarSettings.this.mLanesenseWarn();
                    break;
                case 118:
                    JeepCarSettings.this.mLaneSenseLevel();
                    break;
                case 119:
                    JeepCarSettings.this.mFrontParkSenseVol();
                    break;
                case 120:
                    JeepCarSettings.this.mRearParkSenseVol();
                    break;
                case 121:
                    JeepCarSettings.this.mBlindWarn();
                    break;
                case 122:
                    JeepCarSettings.this.mComfortSystens();
                    break;
                case 123:
                    JeepCarSettings.this.mPressKeyUnlock();
                    break;
                case 124:
                    JeepCarSettings.this.mSurround_sound();
                    break;
                case 125:
                    JeepCarSettings.this.mSpeed_volume();
                    break;
                case 126:
                    JeepCarSettings.this.set_language();
                    break;
                case 127:
                    JeepCarSettings.this.set_unit();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_jeep_365_settings);
        init();
    }

    @Override
    public void init() {
        if (DataCanbus.DATA[1000] == 365) {
            findViewById(R.id.jeep_rain_sense).setVisibility(8);
        } else {
            findViewById(R.id.jeep_rain_sense).setVisibility(0);
        }
        findViewById(R.id.btn_minus1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{1}, null, null);
            }
        });
        findViewById(R.id.btn_plus1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{2}, null, null);
            }
        });
        findViewById(R.id.btn_minus2).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{4}, null, null);
            }
        });
        findViewById(R.id.btn_plus2).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{5}, null, null);
            }
        });
        findViewById(R.id.btn_minus3).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{7}, null, null);
            }
        });
        findViewById(R.id.btn_plus3).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{8}, null, null);
            }
        });
        findViewById(R.id.btn_minus4).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{9}, null, null);
            }
        });
        findViewById(R.id.btn_plus4).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{10}, null, null);
            }
        });
        findViewById(R.id.btn_minus5).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{11}, null, null);
            }
        });
        findViewById(R.id.btn_plus5).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{12}, null, null);
            }
        });
        findViewById(R.id.btn_minus6).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{13}, null, null);
            }
        });
        findViewById(R.id.btn_plus6).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{14}, null, null);
            }
        });
        findViewById(R.id.btn_minus7).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{15}, null, null);
            }
        });
        findViewById(R.id.btn_plus7).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{16}, null, null);
            }
        });
        findViewById(R.id.btn_minus8).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{17}, null, null);
            }
        });
        findViewById(R.id.btn_plus8).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{18}, null, null);
            }
        });
        findViewById(R.id.btn_minus9).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{34}, null, null);
            }
        });
        findViewById(R.id.btn_plus9).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{35}, null, null);
            }
        });
        findViewById(R.id.btn_minus10).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{36}, null, null);
            }
        });
        findViewById(R.id.btn_plus10).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{37}, null, null);
            }
        });
        findViewById(R.id.btn_minus11).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{38}, null, null);
            }
        });
        findViewById(R.id.btn_plus11).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{39}, null, null);
            }
        });
        findViewById(R.id.btn_minus12).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{40}, null, null);
            }
        });
        findViewById(R.id.btn_plus12).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{41}, null, null);
            }
        });
        findViewById(R.id.btn_minus14).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{42}, null, null);
            }
        });
        findViewById(R.id.btn_plus14).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{43}, null, null);
            }
        });
        findViewById(R.id.btn_minus15).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{44}, null, null);
            }
        });
        findViewById(R.id.btn_plus15).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{45}, null, null);
            }
        });
        findViewById(R.id.btn_minus13).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[125];
                int value1 = DataCanbus.DATA[124];
                if (value2 >= 2) {
                    value = value2 - 2;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{value, value1}, null, null);
            }
        });
        findViewById(R.id.btn_plus13).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[125];
                int value1 = DataCanbus.DATA[124];
                if (value2 < 6) {
                    value = value2 + 2;
                } else {
                    value = 6;
                }
                DataCanbus.PROXY.cmd(1, new int[]{value, value1}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{3}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{6}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{19}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{20}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{21}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{22}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{23}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{24}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{25}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{26}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{28}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{29}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{30}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{32}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext15)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, new int[]{33}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value1;
                int value = DataCanbus.DATA[125];
                int value12 = DataCanbus.DATA[124];
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
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
    }

    
    public void mParksense_brake_assist() {
        int value = DataCanbus.DATA[97];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(switchOn != 0);
    }

    
    public void mForward_collision_brake() {
        int value = DataCanbus.DATA[98];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(switchOn != 0);
    }

    
    public void mParkview_movingline() {
        int value = DataCanbus.DATA[99];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(switchOn != 0);
    }

    
    public void mParkview_fixedline() {
        int value = DataCanbus.DATA[100];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(switchOn != 0);
    }

    
    public void mRain_sense_wipers() {
        int value = DataCanbus.DATA[101];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(switchOn != 0);
    }

    
    public void mHill_start_assist() {
        int value = DataCanbus.DATA[102];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(switchOn != 0);
    }

    
    public void mAuto_park_brake() {
        int value = DataCanbus.DATA[103];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(switchOn != 0);
    }

    
    public void mStart_headlights() {
        int value = DataCanbus.DATA[104];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(switchOn != 0);
    }

    
    public void mAuto_dimming_highbeams() {
        int value = DataCanbus.DATA[105];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(switchOn != 0);
    }

    
    public void mDaytime_running_lights() {
        int value = DataCanbus.DATA[106];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(switchOn != 0);
    }

    
    public void mLock_lights() {
        int value = DataCanbus.DATA[107];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setChecked(switchOn != 0);
    }

    
    public void mAuto_lock() {
        int value = DataCanbus.DATA[108];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setChecked(switchOn != 0);
    }

    
    public void mGetoff_autolock() {
        int value = DataCanbus.DATA[109];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setChecked(switchOn != 0);
    }

    
    public void mKeyless_entry() {
        int value = DataCanbus.DATA[110];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setChecked(switchOn != 0);
    }

    
    public void mPower_tailgate_alarm() {
        int value = DataCanbus.DATA[111];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext15)).setChecked(switchOn != 0);
    }

    
    public void mSurround_sound() {
        int value = DataCanbus.DATA[124];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setChecked(switchOn != 0);
    }

    
    public void mHeadlights_off_delay() {
        int value = DataCanbus.DATA[112];
        if (((TextView) findViewById(R.id.tv_text10)) != null) {
            if (value < 60) {
                ((TextView) findViewById(R.id.tv_text10)).setText(String.valueOf(value) + "秒");
            } else {
                ((TextView) findViewById(R.id.tv_text10)).setText(String.valueOf(value / 60) + "分" + (value % 60) + "秒");
            }
        }
    }

    
    public void mHeadlights_on_delay() {
        int value = DataCanbus.DATA[113];
        if (((TextView) findViewById(R.id.tv_text11)) != null) {
            if (value < 60) {
                ((TextView) findViewById(R.id.tv_text11)).setText(String.valueOf(value) + "秒");
            } else {
                ((TextView) findViewById(R.id.tv_text11)).setText(String.valueOf(value / 60) + "分" + (value % 60) + "秒");
            }
        }
    }

    
    public void mpower_off_delay() {
        int value = DataCanbus.DATA[114] * 15;
        if (((TextView) findViewById(R.id.tv_text12)) != null) {
            if (value < 60) {
                ((TextView) findViewById(R.id.tv_text12)).setText(String.valueOf(value) + "秒");
            } else {
                ((TextView) findViewById(R.id.tv_text12)).setText(String.valueOf(value / 60) + "分" + (value % 60) + "秒");
            }
        }
    }

    
    public void set_language() {
        int value = DataCanbus.DATA[126];
        if (((TextView) findViewById(R.id.tv_text14)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text14)).setText(R.string.jeep_language_set1);
            } else {
                ((TextView) findViewById(R.id.tv_text14)).setText(R.string.jeep_language_set0);
            }
        }
    }

    
    public void set_unit() {
        int value = DataCanbus.DATA[127];
        if (((TextView) findViewById(R.id.tv_text15)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text15)).setText(R.string.jeep_format_set1);
            } else {
                ((TextView) findViewById(R.id.tv_text15)).setText(R.string.jeep_format_set0);
            }
        }
    }

    
    public void mSpeed_volume() {
        int value = DataCanbus.DATA[125] / 2;
        if (((TextView) findViewById(R.id.tv_text13)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text13)).setText(R.string.jeep_comfortsystems_0);
            } else {
                ((TextView) findViewById(R.id.tv_text13)).setText(new StringBuilder().append(value).toString());
            }
        }
    }

    
    public void mParkSense() {
        int value = DataCanbus.DATA[115];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.jeep_parksense_1);
            } else {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.jeep_parksense_0);
            }
        }
    }

    
    public void mForwardCollLisionWarn() {
        int value = DataCanbus.DATA[116];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.jeep_forwardcollisionwarn_1);
            } else {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.jeep_forwardcollisionwarn_0);
            }
        }
    }

    
    public void mLanesenseWarn() {
        int value = DataCanbus.DATA[117];
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

    
    public void mLaneSenseLevel() {
        int value = DataCanbus.DATA[118];
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

    
    public void mFrontParkSenseVol() {
        int value = DataCanbus.DATA[119];
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

    
    public void mRearParkSenseVol() {
        int value = DataCanbus.DATA[120];
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

    
    public void mBlindWarn() {
        int value = DataCanbus.DATA[121];
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

    
    public void mComfortSystens() {
        int value = DataCanbus.DATA[122];
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

    
    public void mPressKeyUnlock() {
        int value = DataCanbus.DATA[123];
        if (((TextView) findViewById(R.id.tv_text9)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text9)).setText(R.string.jeep_presskeyunlock_1);
            } else {
                ((TextView) findViewById(R.id.tv_text9)).setText(R.string.jeep_presskeyunlock_0);
            }
        }
    }
}
