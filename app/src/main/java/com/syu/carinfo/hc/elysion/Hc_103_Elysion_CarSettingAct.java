package com.syu.carinfo.hc.elysion;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Hc_103_Elysion_CarSettingAct extends BaseActivity {
    private char DIS_CONTROL_BIT = 'A';
    private int DisplayBit5 = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.hc.elysion.Hc_103_Elysion_CarSettingAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 1:
                    Hc_103_Elysion_CarSettingAct.this.updateDisplayInfo();
                    break;
                case 4:
                    Hc_103_Elysion_CarSettingAct.this.updateAveOil();
                    break;
                case 5:
                    Hc_103_Elysion_CarSettingAct.this.updateTravelDistance();
                    break;
                case 6:
                    Hc_103_Elysion_CarSettingAct.this.updateAveSpeed();
                    break;
                case 7:
                    Hc_103_Elysion_CarSettingAct.this.updateTripTravelTime();
                    break;
                case 9:
                    Hc_103_Elysion_CarSettingAct.this.updateSpeedInfo();
                    break;
                case 15:
                    Hc_103_Elysion_CarSettingAct.this.updateInstrument();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0103_hc_elysion_carsetting);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDisplayInfo() {
        this.DisplayBit5 = DataCanbus.DATA[1] & 255;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAveOil() {
        int aveoil = DataCanbus.DATA[4] & 4095;
        if ((DataCanbus.DATA[4] & 16384) == 16384) {
            this.DIS_CONTROL_BIT = 'A';
        }
        if ((DataCanbus.DATA[4] & 8192) == 8192) {
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
            if (((TextView) findViewById(R.id.tv_text1)) != null) {
                if (aveoil >= 0 && aveoil <= 2045) {
                    ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("%c %d.%d", Character.valueOf(this.DIS_CONTROL_BIT), Integer.valueOf(aveoil / 10), Integer.valueOf(aveoil % 10))) + " L/100Km");
                } else {
                    ((TextView) findViewById(R.id.tv_text1)).setText("---");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTravelDistance() {
        int traveldistance = DataCanbus.DATA[5];
        if (findViewById(R.id.layout_view2) != null) {
            if (traveldistance == 2046) {
                findViewById(R.id.layout_view2).setVisibility(8);
                return;
            }
            if (this.DisplayBit5 == 1) {
                findViewById(R.id.layout_view2).setVisibility(0);
            }
            if (((TextView) findViewById(R.id.tv_text2)) != null) {
                if (traveldistance >= 0 && traveldistance <= 2045) {
                    ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(String.format("%d", Integer.valueOf(traveldistance))) + " Km");
                } else {
                    ((TextView) findViewById(R.id.tv_text2)).setText("---");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAveSpeed() {
        int avespeed = DataCanbus.DATA[6];
        if (findViewById(R.id.layout_view3) != null) {
            if ((avespeed & 255) == 254) {
                findViewById(R.id.layout_view3).setVisibility(8);
                return;
            }
            if (this.DisplayBit5 == 1) {
                findViewById(R.id.layout_view3).setVisibility(0);
            }
            if (((TextView) findViewById(R.id.tv_text3)) != null) {
                if ((avespeed & 255) == 255) {
                    ((TextView) findViewById(R.id.tv_text3)).setText("---");
                } else if (avespeed >= 0 && avespeed <= 400) {
                    ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(String.format("%d", Integer.valueOf(avespeed))) + " Km/h");
                } else {
                    ((TextView) findViewById(R.id.tv_text3)).setText("---");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSpeedInfo() {
        int speedinfo = DataCanbus.DATA[9] & 255;
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            if (speedinfo >= 0 && speedinfo <= 400) {
                ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(String.format("%d", Integer.valueOf(speedinfo))) + " Km/h");
            } else {
                ((TextView) findViewById(R.id.tv_text4)).setText("---");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTripTravelTime() {
        int travelhour = DataCanbus.DATA[7] >> 8;
        int travelminute = DataCanbus.DATA[7] & 255;
        if (findViewById(R.id.layout_view5) != null) {
            if ((travelhour << 8) + travelminute == 65535) {
                findViewById(R.id.layout_view5).setVisibility(8);
                return;
            }
            if (this.DisplayBit5 == 1) {
                findViewById(R.id.layout_view5).setVisibility(0);
            }
            if (((TextView) findViewById(R.id.tv_text5)) != null) {
                ((TextView) findViewById(R.id.tv_text5)).setText(String.valueOf(travelhour) + ":" + travelminute);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInstrument() {
        int instrument = DataCanbus.DATA[15];
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
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
