package com.syu.carinfo.lz.spirior;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Lz_425_Spirior_LightAct extends BaseActivity {
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 101:
                    Lz_425_Spirior_LightAct.this.updateHighBeam();
                    break;
                case 102:
                    Lz_425_Spirior_LightAct.this.updateLowBeam();
                    break;
                case 103:
                    Lz_425_Spirior_LightAct.this.updateFogLights();
                    break;
                case 104:
                    Lz_425_Spirior_LightAct.this.updateFogLamps();
                    break;
                case 105:
                    Lz_425_Spirior_LightAct.this.updateBrakeLight();
                    break;
                case 106:
                    Lz_425_Spirior_LightAct.this.updateTurnLeftLight();
                    break;
                case 107:
                    Lz_425_Spirior_LightAct.this.updateTurnRightLight();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0425_lz_spirior_light);
        init();
    }

    @Override
    public void init() {
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateHighBeam() {
        int highbeam = DataCanbus.DATA[101];
        if (findViewById(R.id.tv_text1) != null) {
            if (highbeam == 1) {
                findViewById(R.id.tv_text1).setBackgroundResource(R.drawable.wc_ruiteng_away_light_1);
            } else {
                findViewById(R.id.tv_text1).setBackgroundResource(R.drawable.wc_ruiteng_away_light_0);
            }
        }
    }

    
    public void updateLowBeam() {
        int lowbeam = DataCanbus.DATA[102];
        if (findViewById(R.id.tv_text2) != null) {
            if (lowbeam == 1) {
                findViewById(R.id.tv_text2).setBackgroundResource(R.drawable.wc_ruiteng_near_light_1);
            } else {
                findViewById(R.id.tv_text2).setBackgroundResource(R.drawable.wc_ruiteng_near_light_0);
            }
        }
    }

    
    public void updateFogLights() {
        int foglights = DataCanbus.DATA[103];
        if (findViewById(R.id.tv_text3) != null) {
            if (foglights == 1) {
                findViewById(R.id.tv_text3).setBackgroundResource(R.drawable.wc_ruiteng_front_fog_light_1);
            } else {
                findViewById(R.id.tv_text3).setBackgroundResource(R.drawable.wc_ruiteng_front_fog_light_0);
            }
        }
    }

    
    public void updateFogLamps() {
        int foglamps = DataCanbus.DATA[104];
        if (findViewById(R.id.tv_text4) != null) {
            if (foglamps == 1) {
                findViewById(R.id.tv_text4).setBackgroundResource(R.drawable.wc_ruiteng_rear_fog_light_1);
            } else {
                findViewById(R.id.tv_text4).setBackgroundResource(R.drawable.wc_ruiteng_rear_fog_light_0);
            }
        }
    }

    
    public void updateBrakeLight() {
        int brakelight = DataCanbus.DATA[105];
        if (findViewById(R.id.tv_text5) != null) {
            if (brakelight == 1) {
                findViewById(R.id.tv_text5).setBackgroundResource(R.drawable.wc_ruiteng_brake_car_light_1);
            } else {
                findViewById(R.id.tv_text5).setBackgroundResource(R.drawable.wc_ruiteng_brake_car_light_0);
            }
        }
    }

    
    public void updateTurnLeftLight() {
        int turnleftlight = DataCanbus.DATA[106];
        if (findViewById(R.id.tv_text7) != null) {
            if (turnleftlight == 1) {
                findViewById(R.id.tv_text7).setBackgroundResource(R.drawable.wc_ruiteng_left_turn_light_1);
            } else {
                findViewById(R.id.tv_text7).setBackgroundResource(R.drawable.wc_ruiteng_left_turn_light_0);
            }
        }
    }

    
    public void updateTurnRightLight() {
        int turnrightlight = DataCanbus.DATA[107];
        if (findViewById(R.id.tv_text6) != null) {
            if (turnrightlight == 1) {
                findViewById(R.id.tv_text6).setBackgroundResource(R.drawable.wc_ruiteng_right_turn_light_1);
            } else {
                findViewById(R.id.tv_text6).setBackgroundResource(R.drawable.wc_ruiteng_right_turn_light_0);
            }
        }
    }
}
