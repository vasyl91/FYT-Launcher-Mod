package com.syu.carinfo.hc.elysion;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Hc_103_Elysion_CarSettingAct extends BaseActivity {
    private char DIS_CONTROL_BIT = 'A';
    private int DisplayBit5 = 0;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 99:
                    Hc_103_Elysion_CarSettingAct.this.updateDisplayInfo();
                    break;
                case 102:
                    Hc_103_Elysion_CarSettingAct.this.updateAveOil();
                    break;
                case 103:
                    Hc_103_Elysion_CarSettingAct.this.updateTravelDistance();
                    break;
                case 104:
                    Hc_103_Elysion_CarSettingAct.this.updateAveSpeed();
                    break;
                case 105:
                    Hc_103_Elysion_CarSettingAct.this.updateTripTravelTime();
                    break;
                case 107:
                    Hc_103_Elysion_CarSettingAct.this.updateSpeedInfo();
                    break;
                case 113:
                    Hc_103_Elysion_CarSettingAct.this.updateInstrument();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0103_hc_elysion_carsetting);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateDisplayInfo() {
        this.DisplayBit5 = DataCanbus.DATA[99] & 255;
        if (this.DisplayBit5 == 0) {
            if (findViewById(R.id.layout_view1) != null) {
                findViewById(R.id.layout_view1).setVisibility(8);
            }
            if (findViewById(R.id.layout_view3) != null) {
                findViewById(R.id.layout_view3).setVisibility(8);
            }
            if (findViewById(R.id.layout_view2) != null) {
                findViewById(R.id.layout_view2).setVisibility(8);
            }
            if (findViewById(R.id.layout_view5) != null) {
                findViewById(R.id.layout_view5).setVisibility(8);
                return;
            }
            return;
        }
        if (findViewById(R.id.layout_view1) != null) {
            findViewById(R.id.layout_view1).setVisibility(0);
        }
        if (findViewById(R.id.layout_view3) != null) {
            findViewById(R.id.layout_view3).setVisibility(0);
        }
        if (findViewById(R.id.layout_view2) != null) {
            findViewById(R.id.layout_view2).setVisibility(0);
        }
        if (findViewById(R.id.layout_view5) != null) {
            findViewById(R.id.layout_view5).setVisibility(0);
        }
    }

    
    public void updateAveOil() {
        int aveoil = DataCanbus.DATA[102] & 4095;
        if ((DataCanbus.DATA[102] & 16384) == 16384) {
            this.DIS_CONTROL_BIT = 'A';
        }
        if ((DataCanbus.DATA[102] & 8192) == 8192) {
            this.DIS_CONTROL_BIT = 'B';
        }
        if (findViewById(R.id.layout_view1) != null) {
            if (aveoil == 2046) {
                findViewById(R.id.layout_view1).setVisibility(8);
                return;
            }
            if (this.DisplayBit5 == 1) {
                findViewById(R.id.layout_view1).setVisibility(0);
            }
            if (findViewById(R.id.tv_text1) != null) {
                if (aveoil >= 0 && aveoil <= 2045) {
                    ((TextView) findViewById(R.id.tv_text1)).setText(String.format("%c %d.%d", Character.valueOf(this.DIS_CONTROL_BIT), Integer.valueOf(aveoil / 10), Integer.valueOf(aveoil % 10)) + " L/100Km");
                } else {
                    ((TextView) findViewById(R.id.tv_text1)).setText("---");
                }
            }
        }
    }

    
    public void updateTravelDistance() {
        int traveldistance = DataCanbus.DATA[103];
        if (findViewById(R.id.layout_view2) != null) {
            if (traveldistance == 2046) {
                findViewById(R.id.layout_view2).setVisibility(8);
                return;
            }
            if (this.DisplayBit5 == 1) {
                findViewById(R.id.layout_view2).setVisibility(0);
            }
            if (findViewById(R.id.tv_text2) != null) {
                if (traveldistance >= 0 && traveldistance <= 2045) {
                    ((TextView) findViewById(R.id.tv_text2)).setText(String.format("%d", Integer.valueOf(traveldistance)) + " Km");
                } else {
                    ((TextView) findViewById(R.id.tv_text2)).setText("---");
                }
            }
        }
    }

    
    public void updateAveSpeed() {
        int avespeed = DataCanbus.DATA[104];
        if (findViewById(R.id.layout_view3) != null) {
            if ((avespeed & 255) == 254) {
                findViewById(R.id.layout_view3).setVisibility(8);
                return;
            }
            if (this.DisplayBit5 == 1) {
                findViewById(R.id.layout_view3).setVisibility(0);
            }
            if (findViewById(R.id.tv_text3) != null) {
                if ((avespeed & 255) == 255) {
                    ((TextView) findViewById(R.id.tv_text3)).setText("---");
                } else if (avespeed >= 0 && avespeed <= 400) {
                    ((TextView) findViewById(R.id.tv_text3)).setText(String.format("%d", Integer.valueOf(avespeed)) + " Km/h");
                } else {
                    ((TextView) findViewById(R.id.tv_text3)).setText("---");
                }
            }
        }
    }

    
    public void updateSpeedInfo() {
        int speedinfo = DataCanbus.DATA[107] & 255;
        if (findViewById(R.id.tv_text4) != null) {
            if (speedinfo >= 0 && speedinfo <= 400) {
                ((TextView) findViewById(R.id.tv_text4)).setText(String.format("%d", Integer.valueOf(speedinfo)) + " Km/h");
            } else {
                ((TextView) findViewById(R.id.tv_text4)).setText("---");
            }
        }
    }

    
    public void updateTripTravelTime() {
        int travelhour = DataCanbus.DATA[105] >> 8;
        int travelminute = DataCanbus.DATA[105] & 255;
        if (findViewById(R.id.layout_view5) != null) {
            if ((travelhour << 8) + travelminute == 65535) {
                findViewById(R.id.layout_view5).setVisibility(8);
                return;
            }
            if (this.DisplayBit5 == 1) {
                findViewById(R.id.layout_view5).setVisibility(0);
            }
            if (findViewById(R.id.tv_text5) != null) {
                ((TextView) findViewById(R.id.tv_text5)).setText(travelhour + ":" + travelminute);
            }
        }
    }

    
    public void updateInstrument() {
        int instrument = DataCanbus.DATA[113];
        if (findViewById(R.id.tv_text6) != null) {
            if (instrument == 1) {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_244_screenbright);
            } else if (instrument == 22) {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_screen_bright_brightest);
            } else {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.invalid_value);
            }
        }
    }
}
