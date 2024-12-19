package com.syu.carinfo.hc.elysion;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Hc_103_Elysion_LightAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.hc.elysion.Hc_103_Elysion_LightAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 10:
                    Hc_103_Elysion_LightAct.this.updateSmallLights();
                    break;
                case 11:
                    Hc_103_Elysion_LightAct.this.updateHeadLight();
                    break;
                case 12:
                    Hc_103_Elysion_LightAct.this.updateHighBeam();
                    break;
                case 13:
                    Hc_103_Elysion_LightAct.this.updateFrontFog();
                    break;
                case 14:
                    Hc_103_Elysion_LightAct.this.updateRearFog();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0103_hc_elysion_light);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHeadLight() {
        int value = DataCanbus.DATA[11];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text2)).setBackgroundResource(R.drawable.wc_ruiteng_day_light_1);
            } else {
                ((TextView) findViewById(R.id.tv_text2)).setBackgroundResource(R.drawable.wc_ruiteng_day_light_0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSmallLights() {
        int value = DataCanbus.DATA[10];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setBackgroundResource(R.drawable.wc_ruiteng_width_light_1);
            } else {
                ((TextView) findViewById(R.id.tv_text1)).setBackgroundResource(R.drawable.wc_ruiteng_width_light_0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHighBeam() {
        int value = DataCanbus.DATA[12];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text3)).setBackgroundResource(R.drawable.wc_ruiteng_away_light_1);
            } else {
                ((TextView) findViewById(R.id.tv_text3)).setBackgroundResource(R.drawable.wc_ruiteng_away_light_0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFrontFog() {
        int value = DataCanbus.DATA[13];
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text4)).setBackgroundResource(R.drawable.wc_ruiteng_front_fog_light_1);
            } else {
                ((TextView) findViewById(R.id.tv_text4)).setBackgroundResource(R.drawable.wc_ruiteng_front_fog_light_0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRearFog() {
        int value = DataCanbus.DATA[14];
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text5)).setBackgroundResource(R.drawable.wc_ruiteng_rear_fog_light_1);
            } else {
                ((TextView) findViewById(R.id.tv_text5)).setBackgroundResource(R.drawable.wc_ruiteng_rear_fog_light_0);
            }
        }
    }
}
