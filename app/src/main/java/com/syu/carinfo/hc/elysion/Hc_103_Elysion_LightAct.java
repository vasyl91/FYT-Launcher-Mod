package com.syu.carinfo.hc.elysion;

import android.os.Bundle;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Hc_103_Elysion_LightAct extends BaseActivity {
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 108:
                    Hc_103_Elysion_LightAct.this.updateSmallLights();
                    break;
                case 109:
                    Hc_103_Elysion_LightAct.this.updateHeadLight();
                    break;
                case 110:
                    Hc_103_Elysion_LightAct.this.updateHighBeam();
                    break;
                case 111:
                    Hc_103_Elysion_LightAct.this.updateFrontFog();
                    break;
                case 112:
                    Hc_103_Elysion_LightAct.this.updateRearFog();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0103_hc_elysion_light);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateHeadLight() {
        int value = DataCanbus.DATA[109];
        if (findViewById(R.id.tv_text2) != null) {
            if (value == 1) {
                findViewById(R.id.tv_text2).setBackgroundResource(R.drawable.wc_ruiteng_day_light_1);
            } else {
                findViewById(R.id.tv_text2).setBackgroundResource(R.drawable.wc_ruiteng_day_light_0);
            }
        }
    }

    
    public void updateSmallLights() {
        int value = DataCanbus.DATA[108];
        if (findViewById(R.id.tv_text1) != null) {
            if (value == 1) {
                findViewById(R.id.tv_text1).setBackgroundResource(R.drawable.wc_ruiteng_width_light_1);
            } else {
                findViewById(R.id.tv_text1).setBackgroundResource(R.drawable.wc_ruiteng_width_light_0);
            }
        }
    }

    
    public void updateHighBeam() {
        int value = DataCanbus.DATA[110];
        if (findViewById(R.id.tv_text3) != null) {
            if (value == 1) {
                findViewById(R.id.tv_text3).setBackgroundResource(R.drawable.wc_ruiteng_away_light_1);
            } else {
                findViewById(R.id.tv_text3).setBackgroundResource(R.drawable.wc_ruiteng_away_light_0);
            }
        }
    }

    
    public void updateFrontFog() {
        int value = DataCanbus.DATA[111];
        if (findViewById(R.id.tv_text4) != null) {
            if (value == 1) {
                findViewById(R.id.tv_text4).setBackgroundResource(R.drawable.wc_ruiteng_front_fog_light_1);
            } else {
                findViewById(R.id.tv_text4).setBackgroundResource(R.drawable.wc_ruiteng_front_fog_light_0);
            }
        }
    }

    
    public void updateRearFog() {
        int value = DataCanbus.DATA[112];
        if (findViewById(R.id.tv_text5) != null) {
            if (value == 1) {
                findViewById(R.id.tv_text5).setBackgroundResource(R.drawable.wc_ruiteng_rear_fog_light_1);
            } else {
                findViewById(R.id.tv_text5).setBackgroundResource(R.drawable.wc_ruiteng_rear_fog_light_0);
            }
        }
    }
}
