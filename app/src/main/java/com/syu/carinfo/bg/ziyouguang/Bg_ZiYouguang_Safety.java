package com.syu.carinfo.bg.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Bg_ZiYouguang_Safety extends BaseActivity {
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 97:
                    Bg_ZiYouguang_Safety.this.mParksense_brake_assist();
                    break;
                case 98:
                    Bg_ZiYouguang_Safety.this.mHill_start_assist();
                    break;
                case 99:
                    Bg_ZiYouguang_Safety.this.mAuto_park_brake();
                    break;
                case 108:
                    Bg_ZiYouguang_Safety.this.mParkSense();
                    break;
                case 109:
                    Bg_ZiYouguang_Safety.this.mFrontParkSenseVol();
                    break;
                case 110:
                    Bg_ZiYouguang_Safety.this.mRearParkSenseVol();
                    break;
                case 116:
                    Bg_ZiYouguang_Safety.this.mBrake_mode();
                    break;
                case 117:
                    Bg_ZiYouguang_Safety.this.mForwardCollision();
                    break;
                case 118:
                    Bg_ZiYouguang_Safety.this.mVideoMove();
                    break;
                case 119:
                    Bg_ZiYouguang_Safety.this.mVideoStatic();
                    break;
                case 120:
                    Bg_ZiYouguang_Safety.this.mViewRainAuto();
                    break;
                case 121:
                    Bg_ZiYouguang_Safety.this.mForwardCollisionWarn();
                    break;
                case 122:
                    Bg_ZiYouguang_Safety.this.mLanewar();
                    break;
                case 123:
                    Bg_ZiYouguang_Safety.this.mView_Lanedev();
                    break;
                case 124:
                    Bg_ZiYouguang_Safety.this.mBlindWarring();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_jeep_safety);
        init();
    }

    @Override
    public void init() {
        if (DataCanbus.DATA[1000] == 371) {
            findViewById(R.id.layout_view8).setVisibility(8);
            findViewById(R.id.layout_view9).setVisibility(8);
            findViewById(R.id.layout_view10).setVisibility(8);
            findViewById(R.id.layout_view11).setVisibility(8);
            findViewById(R.id.layout_view12).setVisibility(8);
            findViewById(R.id.layout_view13).setVisibility(8);
            findViewById(R.id.layout_view14).setVisibility(8);
            findViewById(R.id.layout_view15).setVisibility(8);
        }
        findViewById(R.id.btn_minus1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[108];
                if (value2 == 1) {
                    value = 2;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{1, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[108];
                if (value2 == 1) {
                    value = 2;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{1, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus2).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[109];
                if (value2 == 3) {
                    value = 1;
                } else if (value2 == 2) {
                    value = 0;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{2, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus2).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[109];
                if (value2 == 1) {
                    value = 1;
                } else if (value2 == 2) {
                    value = 2;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{2, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus3).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[110];
                if (value2 == 3) {
                    value = 1;
                } else if (value2 == 2) {
                    value = 0;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{3, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus3).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[110];
                if (value2 == 1) {
                    value = 1;
                } else if (value2 == 2) {
                    value = 2;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(2, new int[]{3, value}, null, null);
            }
        });
        findViewById(R.id.ctv_checkedtext1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[97];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{4, value}, null, null);
            }
        });
        findViewById(R.id.ctv_checkedtext2).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[98];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{7, value}, null, null);
            }
        });
        findViewById(R.id.ctv_checkedtext4).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[99];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{6, value}, null, null);
            }
        });
        findViewById(R.id.ctv_checkedtext3).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int i = DataCanbus.DATA[116];
                DataCanbus.PROXY.cmd(2, new int[]{5, 2}, null, null);
            }
        });
        findViewById(R.id.ctv_checkedtext5).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[118];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(3, new int[]{6, value}, null, null);
            }
        });
        findViewById(R.id.ctv_checkedtext6).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[119];
                if (value2 == 0) {
                    value = 17;
                } else {
                    value = 16;
                }
                DataCanbus.PROXY.cmd(3, new int[]{7, value}, null, null);
            }
        });
        findViewById(R.id.ctv_checkedtext7).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[120];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(3, new int[]{8, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus4).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[117];
                if (value2 == 2) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(3, new int[]{1, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus4).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[117];
                if (value2 == 2) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(3, new int[]{1, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus5).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[121];
                if (value2 == 2) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(3, new int[]{2, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus5).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[121];
                if (value2 == 1) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(3, new int[]{2, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus6).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[122];
                if (value2 == 3) {
                    value = 2;
                } else if (value2 == 2) {
                    value = 0;
                } else {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(3, new int[]{3, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus6).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[122];
                if (value2 == 1) {
                    value = 2;
                } else if (value2 == 2) {
                    value = 4;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{3, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus7).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[123];
                if (value2 == 3) {
                    value = 1;
                } else if (value2 == 2) {
                    value = 0;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(3, new int[]{4, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus7).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[123];
                if (value2 == 1) {
                    value = 1;
                } else if (value2 == 2) {
                    value = 2;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{4, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus8).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[124];
                if (value2 == 3) {
                    value = 1;
                } else if (value2 == 2) {
                    value = 0;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(3, new int[]{5, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus8).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[124];
                if (value2 == 1) {
                    value = 1;
                } else if (value2 == 2) {
                    value = 2;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{5, value}, null, null);
            }
        });
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
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
    }

    
    public void mParksense_brake_assist() {
        int value = DataCanbus.DATA[97];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(switchOn == 1);
    }

    
    public void mHill_start_assist() {
        int value = DataCanbus.DATA[98];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(switchOn == 1);
    }

    
    public void mAuto_park_brake() {
        int value = DataCanbus.DATA[99];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(switchOn == 1);
    }

    
    public void mBrake_mode() {
        int value = DataCanbus.DATA[116];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(switchOn == 1);
    }

    
    public void mParkSense() {
        int value = DataCanbus.DATA[108];
        if (findViewById(R.id.tv_text1) != null) {
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.jeep_parksense_1);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.jeep_parksense_0);
            } else {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_psa_all_factory_settings_select_models_0);
            }
        }
    }

    
    public void mFrontParkSenseVol() {
        int value = DataCanbus.DATA[109];
        if (findViewById(R.id.tv_text2) != null) {
            if (value == 3) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_air_high);
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_air_middle);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_air_low);
            } else {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.crv_source_null);
            }
        }
    }

    
    public void mRearParkSenseVol() {
        int value = DataCanbus.DATA[110];
        if (findViewById(R.id.tv_text3) != null) {
            if (value == 3) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_air_high);
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_air_middle);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_air_low);
            } else {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.crv_source_null);
            }
        }
    }

    
    public void mForwardCollision() {
        int value = DataCanbus.DATA[117];
        if (findViewById(R.id.tv_text4) != null) {
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.jeep_forwardcollisionwarn_1);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.jeep_forwardcollisionwarn_0);
            } else {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.crv_source_null);
            }
        }
    }

    
    public void mVideoMove() {
        int value = DataCanbus.DATA[118];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(switchOn == 1);
    }

    
    public void mVideoStatic() {
        int value = DataCanbus.DATA[119];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(switchOn == 1);
    }

    
    public void mViewRainAuto() {
        int value = DataCanbus.DATA[120];
        int switchOn = value & 255;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(switchOn == 1);
    }

    
    public void mForwardCollisionWarn() {
        int value = DataCanbus.DATA[121];
        if (findViewById(R.id.tv_text5) != null) {
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text5)).setText("ON");
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text5)).setText("OFF");
            } else {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.crv_source_null);
            }
        }
    }

    
    public void mLanewar() {
        int value = DataCanbus.DATA[122];
        if (findViewById(R.id.tv_text6) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.jeep_lanesensewarn_0);
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.jeep_lanesensewarn_1);
            } else if (value == 3) {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.jeep_lanesensewarn_2);
            } else {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.crv_source_null);
            }
        }
    }

    
    public void mView_Lanedev() {
        int value = DataCanbus.DATA[123];
        if (findViewById(R.id.tv_text7) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text7)).setText(R.string.wc_372_low);
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text7)).setText(R.string.wc_372_mid);
            } else if (value == 3) {
                ((TextView) findViewById(R.id.tv_text7)).setText(R.string.wc_372_high);
            } else {
                ((TextView) findViewById(R.id.tv_text7)).setText(R.string.crv_source_null);
            }
        }
    }

    
    public void mBlindWarring() {
        int value = DataCanbus.DATA[124];
        if (findViewById(R.id.tv_text8) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text8)).setText(R.string.jeep_blindwarn_0);
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text8)).setText(R.string.jeep_blindwarn_1);
            } else if (value == 3) {
                ((TextView) findViewById(R.id.tv_text8)).setText(R.string.jeep_blindwarn_2);
            } else {
                ((TextView) findViewById(R.id.tv_text8)).setText(R.string.crv_source_null);
            }
        }
    }
}
